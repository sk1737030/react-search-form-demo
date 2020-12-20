package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.InfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TftApiMapper {

    Integer saveSummoner(SummonerVO summonerVO) throws Exception;

    SummonerVO getSummonerByName(String name) throws Exception;

    List<String> getSummonerMatchListByPuuid(String puuid) throws Exception;

    Integer saveMatchInfo(InfoDto info) ;
}
