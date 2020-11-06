package org.dongguri.reactsearchformdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-jdbc.properties")
public class SearchFormServiceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private SearchFormService  searchFormService;

    @Autowired
    private ObjectMapper objectMapper; // 자바Spec에 맞게 등록된 Bean Serialize로  변환해준다.

    /*@Autowired
    private ModelMapper modelMapper;
*/
    @Test
    public void test() throws Exception {
        mockMvc.perform(post("/re-index"))
                .andDo(print());




    }

}
