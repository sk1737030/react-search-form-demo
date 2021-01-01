package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.dto.match.CompanionDto;
import org.dongguri.reactsearchformdemo.dto.match.InfoDto;
import org.dongguri.reactsearchformdemo.dto.match.TraitDto;
import org.dongguri.reactsearchformdemo.dto.match.UnitDto;
import org.dongguri.reactsearchformdemo.dto.metadata.MetaDataDto;
import org.dongguri.reactsearchformdemo.dto.metadata.ParticipantDto;
import org.dongguri.reactsearchformdemo.dto.summoner.SummonerDTO;

import java.util.List;

@Mapper
public interface TftApiMapper {

    Integer saveSummoner(SummonerDTO summonerVO);

    SummonerDTO getSummonerByName(String summoner_name);

    Integer saveMatchInfo(InfoDto info);

    InfoDto getMatchInfosByMatchId(String match_id);

    Integer saveMatchDetailParticipant(ParticipantDto participantDto);

    Integer saveParticipantCompanion(CompanionDto companion);

    Integer saveParticipantsTrait(TraitDto traitDto);

    Integer saveParticipantsUnit(UnitDto unitDto);

    Integer saveMetaData(MetaDataDto metadata);

    Integer saveMatchParticipants(MetaDataDto participants);

    MetaDataDto getMetaDataByMatchId(String match_id);

    List<String> getMatchListByPuuid(String puuid);

    List<SummonerDTO> getMatchSummonerListByMatchId(MetaDataDto metaDataDto);
}
