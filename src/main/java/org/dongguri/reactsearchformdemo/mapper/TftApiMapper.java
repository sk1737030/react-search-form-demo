package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.dto.SummonerDTO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TftApiMapper {

    SummonerDTO getSummonerByName(String name) throws Exception;
}
