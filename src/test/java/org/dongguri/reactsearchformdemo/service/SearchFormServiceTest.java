package org.dongguri.reactsearchformdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-jdbc.properties")
public class SearchFormServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private TftApiService searchFormService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createIndex() throws Exception {
        // Given && When
        ResultActions resultActions = mockMvc.perform(post("/api/index"))

                .andDo(print());

        // Then
        resultActions.andExpect(status().isOk());
    }

}
