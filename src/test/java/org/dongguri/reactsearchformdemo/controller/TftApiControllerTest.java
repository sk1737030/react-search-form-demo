package org.dongguri.reactsearchformdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.dongguri.reactsearchformdemo.service.TftApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
@ActiveProfiles("test")
class TftApiControllerTest {
    @Autowired
    TftApiService tftApiService;

    @Autowired
    TftApiMapper tftApiMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("소환사 이름을 기준으로 사용자 정보를 가져오는 테스트")
    void getSummonerByName_200() throws Exception {
        // Given
        String userName = "mkttt";

        // When
        mockMvc.perform(get("/api/summoner/{name}", userName))
                .andDo(print())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("puuid").exists())
                .andExpect(jsonPath("accountId").exists())
                .andExpect(jsonPath("name").value(userName))
                .andExpect(jsonPath("summonerLevel").exists())
        ;
    }

    @Test
    @DisplayName("Name으로 호출후 닉네임가 없으면 403받기")
    void getSummonerByName_403() throws Exception {
        mockMvc.perform(get("/api/summoner/{name}", "mkttt11111")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("처음 호출된 사용자일경우 디비에 저장하는 테스트")
    void saveSummonerByName_200() throws Exception {
        // Given
        String userName = "mkttt";

        // When
        mockMvc.perform(get("/api/summoner/{name}", userName))
                .andDo(print());

        SummonerVO summoner = tftApiMapper.getSummonerByName(userName);

        // Then
        assertThat(summoner.getName()).isEqualTo(userName);
    }

}