package org.dongguri.reactsearchformdemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dongguri.reactsearchformdemo.dto.*;

import java.util.List;

@Mapper
public interface TftApiMapper {

    Integer saveSummoner(SummonerDTO summonerVO);

    SummonerDTO getSummonerByName(String summoner_name);

    Integer saveMatchInfo(InfoDto info);

    InfoDto getMatchInfos(String match_id);

    Integer saveMatchDetailParticipant(ParticipantDto participantDto);

    Integer saveParticipantCompanion(CompanionDto companion);

    Integer saveParticipantsTrait(TraitDto traitDto);

    Integer saveParticipantsUnit(UnitDto unitDto);



    Integer saveMetaData(MetaDataDto metadata);
    Integer saveMatchParticipants(MetaDataDto participants);

    MetaDataDto getMetaDataByMatchId(String match_id);

}
