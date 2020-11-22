package org.dongguri.reactsearchformdemo.service;

import org.apache.http.client.utils.URIBuilder;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URISyntaxException;

@Service
public class TftApiService {

    private static final String HTTPS_KR_API_RIOTGAMES_COM = "https://kr.api.riotgames.com/";
    private static final String LOL_SUMMONERS_BY_NAME_API = "lol/summoner/v4/summoners/by-name/";

    @Value("${API_KEY}")
    private static String TFT_API_KEY;

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private TftApiMapper summonerMapper;

    public SummonerDTO getSummonerByName(String name) throws Exception {
        SummonerDTO summonerDTO = summonerMapper.getSummonerByName(name);

        // API 호출
        if (summonerDTO == null) {
            summonerDTO = callSummonerApiByName(name);
        }

        return summonerDTO;
    }


    private SummonerDTO callSummonerApiByName(String name) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONERS_BY_NAME_API + name);
        uriBuilder.addParameter("api_key", TFT_API_KEY);

        // TODO:: 비동기처리도 따로 가능함. AsyncRestTemplate 사용해서
        return restTemplate.getForObject(uriBuilder.build(), SummonerDTO.class);

    }
}
