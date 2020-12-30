package org.dongguri.reactsearchformdemo.service;

import org.dongguri.reactsearchformdemo.config.AppProperties;
import org.dongguri.reactsearchformdemo.dto.*;
import org.dongguri.reactsearchformdemo.mapper.TftApiMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class TftApiServiceTest {
    @Autowired
    private TftApiService tftApiService;

    @Autowired
    private TftApiMapper tftApiMapper;

    @Autowired
    private AppProperties appProperties;
    public static final String TEST_USER_NAME = "mkttt";


    @Test
    @DisplayName("처음 호출된 SummonerStdScalarSerializer일 경우 DB 저장")
    void saveSummonerAtFirst() throws Exception {
        // Given
        final String testUserName = "mkttt";
        // When
        tftApiService.saveSummonerInfo(testUserName);
        SummonerDTO summonerByName = tftApiMapper.getSummonerByName(testUserName);

        // Then
        assertEquals(testUserName, summonerByName.getSummonerName());
    }

    @Test
    @DisplayName("puuid 기준으로 매칭리스트 가져오기")
    void getMatchingListByPuuid_200() throws Exception {
        // Given
        final String testUserName = "mkttt";

        // When
        final SummonerDTO summonerByName = tftApiService.getSummonerByName(testUserName);
        final List<String> matchList = tftApiService.callMatchListByPuuid(summonerByName.getPuuid());

        // Then
        assertEquals(appProperties.getCallMatchListSize(), matchList.size(), "기본 10개가 나와야한다");
    }

    @Test
    @DisplayName("사용자 매치 상세 정보 데이터 Mapping  테스트")
    void getSummonerByNameAtFirst() throws Exception {
        // Given
        final String testUserName = "mkttt";
        SummonerDTO summonerByName = tftApiService.getSummonerByName(testUserName);
        String testUserPuuid = summonerByName.getPuuid();
        List<String> matchList = tftApiService.callMatchListByPuuid(testUserPuuid);

        // When
        String testMatch_id = matchList.get(0);
        InfoDto matchInfo = tftApiMapper.getMatchInfos(testMatch_id);
        List<ParticipantDto> participants = matchInfo.getParticipants();

        // Then
        assertEquals(testMatch_id, matchInfo.getMatch_id(), "테스트할 매치ID와 저장한 MatchId는 같다");
        assertNotNull(participants.get(0).getMatch_participant_seq());
        assertNotNull(participants.get(0).getCompanion().getMatch_participant_seq());
        assertTrue(participants.stream().anyMatch(participantDto -> participantDto.getPuuid().equals(testUserPuuid)),
                "참가자들 중에 testUser의 Puuid와 같은 참가자가 있다.");
        assertTrue(participants.get(0).getTraits().size() > 0, "사용자가 사용한 시너지 0 개 이상이다.");
        assertTrue(participants.get(0).getUnits().size() > 0, "사용자가 사용한 유닛은 0 개 이상이다.");

    }

    @Test
    @DisplayName("가져온 매치정보로 상세 게임정보 가져오기")
    void getDetailMatch_200() throws Exception {
        // Given
        final SummonerDTO summonerByName = tftApiService.callSummonerApiByName(TEST_USER_NAME);
        final List<String> matchList = tftApiService.callMatchListByPuuid(summonerByName.getPuuid());

        // When
        MatchDto detailMatchByMatchId = tftApiService.callDetailMatchByMatchId(matchList.get(0));

        // Then
        assertEquals(matchList.get(0), detailMatchByMatchId.getMetadata().getMatch_id());
    }

    @Test
    @DisplayName("매치Id에 참가자들 저장및 호출")
    void saveAndGetMatchParticipants() throws Exception {
        // Given
        final SummonerDTO summonerByName = tftApiService.callSummonerApiByName(TEST_USER_NAME);
        final List<String> matchList = tftApiService.callMatchListByPuuid(summonerByName.getPuuid());
        MatchDto detailMatchByMatchId = tftApiService.callDetailMatchByMatchId(matchList.get(0));


        // When
        tftApiService.saveMetaData(detailMatchByMatchId.getMetadata());
        MetaDataDto metaDataDto = tftApiService.getMetaDataByMatchId(matchList.get(0));

        // Then
        assertNotNull(metaDataDto.getParticipants());
        assertTrue(metaDataDto.getParticipants().contains(summonerByName.getPuuid()), "매치 참가들중에 TestUser의 puuid가 있다.");

    }
}

