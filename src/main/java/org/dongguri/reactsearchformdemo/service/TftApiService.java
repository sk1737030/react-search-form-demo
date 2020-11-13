package org.dongguri.reactsearchformdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TftApiService {

    @Autowired
    private TftApiMapper summonerMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public String getSummonerByName(String name) throws Exception {
        SummonerDTO summonerVO = summonerMapper.getSummonerByName(name);

        // Api 호출
        if (summonerVO == null) {
            summonerVO = callSummonerApiByName(name);

        }

        return null;
    }

    private SummonerDTO callSummonerApiByName(String name) throws Exception {

    }
}
