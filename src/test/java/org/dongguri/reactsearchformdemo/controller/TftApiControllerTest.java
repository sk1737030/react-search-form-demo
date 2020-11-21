package org.dongguri.reactsearchformdemo.controller;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
    MockMvc mockMvc;

    @Test
    public void getSummonerByNameTest() throws Exception {
        // Given
        String userName = "mkttt1111";

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
    public void getSummonerByName_NotFound() throws Exception {
        mockMvc.perform(get("/api/summoner/{name}", "mkttt11111"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}