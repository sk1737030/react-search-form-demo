package org.dongguri.reactsearchformdemo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.config.error.SummonerNotFoundException;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.MatchDto;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor

public class TftApiService {

    private static final String API_KEY = "api_key";
    private static final String HTTPS_KR_API_RIOTGAMES_COM = "https://kr.api.riotgames.com";
    private static final String HTTPS_ASIA_API_RIOTGAMES_COM = "https://asia.api.riotgames.com";
    private static final String LOL_SUMMONERS_BY_NAME_API = "/lol/summoner/v4/summoners/by-name/";
    private static final String LOL_SUMMONER_MATCH_LIST_BY_PUUID = "/tft/match/v1/matches/by-puuid/{puuid}/ids";
    private static final String LOL_SUMMONER_MATCH_BY_MATCHID = "/tft/match/v1/matches/{matchId}";

    private final AppProperties appProperties;
    private final RestTemplate restTemplate;
    private final TftApiMapper summonerMapper;
    private final ModelMapper modelMapper;

    @Transactional
    public SummonerDTO getSummonerByName(String userName) throws Exception {
        SummonerVO summonerVO = summonerMapper.getSummonerByName(userName);

        // 최초 호출시
        if (summonerVO == null) {
            summonerVO = getFirstSummoner(userName);
        } else {

        }

        return modelMapper.map(summonerVO, SummonerDTO.class);
    }

    public SummonerVO getFirstSummoner(String firstName) throws Exception {
        SummonerVO summonerVO = callSummonerApiByName(firstName);
        summonerMapper.saveSummoner(summonerVO);
        List<String> matchList = callMatchListByPuuid(summonerVO.getPuuid());
        matchList.forEach(match_id -> {
            MatchDto matchDto = callDetailMatchByMatchId(match_id);
            summonerMapper.saveMatchInfo(matchDto.getInfo());
        });
        return summonerVO;
    }

    // Riot Api 통신 Method
    public SummonerVO callSummonerApiByName(String name) {
        URI uri =
                UriComponentsBuilder
                        .fromUriString(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONERS_BY_NAME_API + name)
                        .queryParam(API_KEY, appProperties.getApiKey())
                        .build().toUri();

        // TODO:: 비동기처리도 따로 가능함. AsyncRestTemplate 사용해서
        return restTemplate.getForObject(uri, SummonerVO.class);
    }

    /**
     * Summoner Match List
     * reload없이 부를시
     */
    public List<String> getSummonerMatchListByPuuid(String puuid) throws Exception {
        return summonerMapper.getSummonerMatchListByPuuid(puuid);
    }

    private List<String> callMatchListByPuuid(String puuid) {
        URI uri =
                UriComponentsBuilder
                        .fromUriString(HTTPS_ASIA_API_RIOTGAMES_COM + LOL_SUMMONER_MATCH_LIST_BY_PUUID)
                        .queryParam("count", appProperties.getCallMatchListSize())
                        .queryParam(API_KEY, appProperties.getApiKey())
                        .buildAndExpand(puuid).toUri();
        // null 떨어질시 403
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(uri, String[].class), () -> {
            throw new SummonerNotFoundException("소환사의 매칭정보를 찾을 수 없습니다.");
        }));
    }

    public MatchDto callDetailMatchByMatchId(String matchId) {
        URI uri =
                UriComponentsBuilder
                        .fromUriString(HTTPS_ASIA_API_RIOTGAMES_COM + LOL_SUMMONER_MATCH_BY_MATCHID)
                        .queryParam(API_KEY, appProperties.getApiKey())
                        .buildAndExpand(matchId).toUri();

        return restTemplate.getForObject(uri, MatchDto.class);
    }
}
