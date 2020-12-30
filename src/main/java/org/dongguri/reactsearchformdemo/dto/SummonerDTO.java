package org.dongguri.reactsearchformdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class SummonerDTO {

    private String id;
    private String accountId;
    private String puuid;
    private String profileIconId;
    private LocalDateTime revisionDate;
    @JsonProperty(value = "name")
    private String summonerName;
    private String summonerLevel;
    private LocalDateTime updDate;

    @Builder
    public SummonerDTO(String id, String accountId, String puuid, String profileIconId, LocalDateTime revisionDate, String summonerName, String summonerLevel, LocalDateTime updDate) {
        this.id = id;
        this.accountId = accountId;
        this.puuid = puuid;
        this.profileIconId = profileIconId;
        this.revisionDate = revisionDate;
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.updDate = updDate;
    }
}