package org.dongguri.reactsearchformdemo.controller;

import org.dongguri.reactsearchformdemo.dto.MatchDto;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.dongguri.reactsearchformdemo.service.TftApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TftApiController {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    TftApiService tftApiService;


    @GetMapping(value = "/api/summoner/{name}", produces = "application/json")
    public ResponseEntity getSummonerByName(@PathVariable String name) throws Exception {
        SummonerDTO summonerDTO = tftApiService.getSummonerByName(name);

        return ResponseEntity.ok().body(summonerDTO);
    }

    @GetMapping(value = "/api/summoner/{puuid}/reload", produces = "application/json")
    public ResponseEntity reloadSummoner(@PathVariable String puuid) throws Exception {
        List<MatchDto> matchDtos = new ArrayList<>();
        List<String> matchList = tftApiService.callMatchListByPuuid(puuid);
        matchList.forEach(matchId -> matchDtos.add(tftApiService.callDetailMatchByMatchId(matchId)));

        return ResponseEntity.ok().body(matchDtos);
    }
}
