package org.dongguri.reactsearchformdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongguri.reactsearchformdemo.mapper.SearchFormMapper;
import org.dongguri.reactsearchformdemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFormService {

    @Autowired
    private SearchFormMapper searchFormMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public String reIndex() throws Exception {
        List<UserVO> userList = searchFormMapper.getGmamaListForIndex();


        return objectMapper.writeValueAsString(userList);
    }
}
