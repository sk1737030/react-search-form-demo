package org.dongguri.reactsearchformdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URISyntaxException;

@Service
@Slf4j
public class TftApiService {

    private static final String HTTPS_KR_API_RIOTGAMES_COM = "https://kr.api.riotgames.com/";
    private static final String LOL_SUMMONERS_BY_NAME_API = "lol/summoner/v4/summoners/by-name/";

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

    private SummonerVO callSummonerApiByName(String name) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(HTTPS_KR_API_RIOTGAMES_COM + LOL_SUMMONERS_BY_NAME_API + name);
        uriBuilder.addParameter("api_key", appProperties.getApiKey());

        // TODO:: 비동기처리도 따로 가능함. AsyncRestTemplate 사용해서
        return restTemplate.getForObject(uriBuilder.build(), SummonerVO.class);
    }
}
