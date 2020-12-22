package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.dto.InfoDto;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TftApiMapper {

    Integer saveSummoner(SummonerDTO summonerVO);

    SummonerDTO getSummonerByName(String summoner_name);

    Integer saveMatchInfo(InfoDto info);

    InfoDto getMatchInfos(String match_id);


}
