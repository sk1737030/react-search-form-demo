package org.dongguri.reactsearchformdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dongguri.reactsearchformdemo.service.SearchFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SearchFormController {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    SearchFormService searchFormService;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }

    @PostMapping("/api/index")
    public ResponseEntity createIndex() throws Exception {

        boolean indexExists = elasticsearchOperations.indexOps(IndexCoordinates.of("grandmama-user")).create();

        if (indexExists) {
            return ResponseEntity.ok().body("Already Index Created");
        }

        return ResponseEntity.ok().body("Success Index Created");
    }
}
