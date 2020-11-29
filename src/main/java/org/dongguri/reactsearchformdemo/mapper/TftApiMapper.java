package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.domain.SummonerVO;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TftApiMapper {

    Integer saveSummoner(SummonerVO summonerVO) throws Exception;

    SummonerVO getSummonerByName(String name) throws Exception;
}
