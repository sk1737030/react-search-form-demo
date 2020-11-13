package org.dongguri.reactsearchformdemo.controller;

import org.dongguri.reactsearchformdemo.service.TftApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TftApiController {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    TftApiService tftApiService;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }

    @GetMapping("/api/summoner/{name}")
    public ResponseEntity getSummonerByName(@PathVariable String name) throws Exception {

        tftApiService.getSummonerByName(name);

        //boolean indexExists = elasticsearchOperations.indexOps(IndexCoordinates.of("grandmama-user")).create();

/*
        if (indexExists) {
            return ResponseEntity.ok().body("Already Index Created");
        }
*/

        return ResponseEntity.ok().body("Success Index Created");
    }
}
