package org.dongguri.reactsearchformdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.dto.SummonerMatchDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.reactive.WebClientProvider;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
@Slf4j
public class TftApiService {

    private static final String HTTPS_KR_API_RIOTGAMES_COM = "https://kr.api.riotgames.com/";
    private static final String LOL_SUMMONERS_BY_NAME_API = "lol/summoner/v4/summoners/by-name/";
    private static final String LOL_SUMMONER_MATCH_BY_PUUID = "/tft/match/v1/matches/by-puuid/{puuid}/ids";
    private static final String KOREA_REGION_API_URL = "asia.api.riotgames.com";


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
    private SummonerVO callSummonerApiByName(String name) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONERS_BY_NAME_API + name);
        uriBuilder.addParameter("api_key", appProperties.getApiKey());

        // TODO:: 비동기처리도 따로 가능함. AsyncRestTemplate 사용해서
        return restTemplate.getForObject(uriBuilder.build(), SummonerVO.class);
    }


    // get MatchingList3
    public List<String> getSummonerMatchListByPuuid(String puuid) throws URISyntaxException {

        // @Pathvariable처럼 URl에 {puuid} Bind되게 
        URI uri = UriComponentsBuilder.fromUriString(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONER_MATCH_BY_PUUID)
                .buildAndExpand(puuid).toUri();
        URIBuilder uriBuilder = new URIBuilder(uri);
        restTemplate.getForObject(uriBuilder.build(), SummonerMatchDTO.class);
        return null;

    }
}
