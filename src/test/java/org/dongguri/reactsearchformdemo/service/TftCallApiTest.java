package org.dongguri.reactsearchformdemo.service;

import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.dto.match.MatchDto;
import org.dongguri.reactsearchformdemo.dto.summoner.SummonerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class TftCallApiTest {
    @Autowired
    TftApiService tftApiService;

    @Autowired
    AppProperties appProperties;

    @Test
    @DisplayName("Api Summoner의 정보를 가져옴")
    void callSummonerApiByName() throws Exception {
        // Given
        final String userName = "mkttt";

        // When && Then
        SummonerDTO summonerDTO = tftApiService.callSummonerApiByName(userName);
        assertEquals(userName, summonerDTO.getSummonerName());
    }

    @Test
    @DisplayName("puuid 기준으로 matchList가져오기")
    void callSummonerMatchListByPuuid() throws Exception {
        // Given
        final String userName = "mkttt";
        SummonerDTO summonerVO = tftApiService.callSummonerApiByName(userName);
        // When
        List<String> matchList = tftApiService.callMatchListByPuuid(summonerVO.getPuuid());
        // Then
        assertNotNull(matchList.get(0), "가져온 매칭리스트가 null이 아니여야한다.");
        assertEquals(appProperties.getCallMatchListSize(), matchList.size());

    }

    @Test
    @DisplayName("매칭아이디 기준으로 상세 매치 정보를 가져온다.")
    void callDetailMatchByMatchId() throws Exception {
        // Given
        final String userName = "mkttt";
        SummonerDTO summonerDTO = tftApiService.callSummonerApiByName(userName);
        List<String> matchList = tftApiService.callMatchListByPuuid(summonerDTO.getPuuid());
        // When
        MatchDto matchDto = tftApiService.callDetailMatchByMatchId(matchList.get(0));

        // Then
        assertNotNull(matchDto.getMetadata().getMatch_id());
        assertNotNull(matchDto.getInfo().getMatch_id());
        assertEquals(matchList.get(0), matchDto.getInfo().getMatch_id());
    }


}
