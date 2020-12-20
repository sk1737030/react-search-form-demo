package org.dongguri.reactsearchformdemo.service;

import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.MatchDto;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class TftApiServiceTest {
    @Autowired
    TftApiService tftApiService;

    @Autowired
    AppProperties appProperties;

    @Test
    @DisplayName("puuid 기준으로 매칭리스트 가져오기")
    void getMatchingListByPuuid_200() throws Exception {
        // Given
        final String testUserName = "mkttt";

        // When
        final SummonerDTO summonerByName = tftApiService.getSummonerByName(testUserName);
        final List<String> matchList = tftApiService.getSummonerMatchListByPuuid(summonerByName.getPuuid());

        // Then
        // 20
        assertEquals(appProperties.getCallMatchListSize(), matchList.size());
    }

    @Test
    @DisplayName("가져온 매치정보로 상세 게임정보 가져오기")
    void getDetailMatch_200() throws Exception {
        // Given
        final String testUserName = "mkttt";
        final SummonerDTO summonerByName = tftApiService.getSummonerByName(testUserName);
        final List<String> matchList = tftApiService.getSummonerMatchListByPuuid(summonerByName.getPuuid());

        // When
        MatchDto detailMatchByMatchId = tftApiService.callDetailMatchByMatchId(matchList.get(0));

        // Then
        assertEquals(matchList.get(0), detailMatchByMatchId.getMetadata().getMatch_id());
    }

    @Test
    @DisplayName("Api Summoner 정보를 가져옴")
    void callSummonerApiByName() throws Exception {
        // Given
        final String userName = "mkttt";
        SummonerVO summonerVO = tftApiService.callSummonerApiByName(userName);
        // When && Then
        assertEquals(userName, summonerVO.getName());
    }

}
