package org.dongguri.reactsearchformdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.config.error.ApiException;
import org.dongguri.reactsearchformdemo.config.error.ApiForbiddenException;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class TftApiService {

    private static final String HTTPS_KR_API_RIOTGAMES_COM = "https://kr.api.riotgames.com/";
    private static final String HTTPS_ASIA_API_RIOTGAMES_COM = "https://asia.api.riotgames.com/";

    private static final String LOL_SUMMONERS_BY_NAME_API = "lol/summoner/v4/summoners/by-name/";
    private static final String LOL_SUMMONER_MATCH_BY_PUUID = "/tft/match/v1/matches/by-puuid/{puuid}/ids";


    @Autowired
    AppProperties appProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private TftApiMapper summonerMapper;

    @Autowired
    ModelMapper modelMapper;

    public SummonerDTO getSummonerByName(String name) throws Exception {
        SummonerVO summonerVO = summonerMapper.getSummonerByName(name);

        // API 호출
        if (summonerVO == null) {
            summonerVO = callSummonerApiByName(name);
            summonerMapper.saveSummoner(summonerVO);
        }

        return modelMapper.map(summonerVO, SummonerDTO.class);
    }

    // Riot Api 통신 Method
    private SummonerVO callSummonerApiByName(String name) {
        URI uri = UriComponentsBuilder.fromUriString(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONERS_BY_NAME_API + name)
                .queryParam("api_key", appProperties.getApiKey())
                .build().toUri();


        // TODO:: 비동기처리도 따로 가능함. AsyncRestTemplate 사용해서
        return restTemplate.getForObject(uri, SummonerVO.class);
    }

    public List<String> getSummonerMatchListByPuuid(String puuid)   {
        // @Pathvariable처럼 URl에 {puuid} Bind되게

        URI uri = UriComponentsBuilder.fromUriString(HTTPS_ASIA_API_RIOTGAMES_COM + LOL_SUMMONER_MATCH_BY_PUUID)
                .queryParam("count", appProperties.getCallMatchListSize())
                .queryParam("api_key",appProperties.getApiKey())
                .buildAndExpand(puuid).toUri();

        // null 떨어질시 api서버에러인데 일단 401으로
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(uri, String[].class), () -> {
            throw new ApiForbiddenException();
        }));
    }
}
