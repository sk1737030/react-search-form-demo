package org.dongguri.reactsearchformdemo.controller;

import org.apache.http.HttpStatus;
import org.dongguri.reactsearchformdemo.service.TftApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
/*@TestPropertySource(locations = "classpath:application-jdbc.properties")*/
@ActiveProfiles("test")
public class TftApiControllerTest {
    @Autowired
    TftApiService tftApiService;

    @Autowired
    MockMvc mockMvc;


    @Test
    public void getSummonerByName_200() throws Exception {
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
    public void getSummonerByName_403() throws Exception {
        mockMvc.perform(get("/api/summoner/{name}", "mkttt11111")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}