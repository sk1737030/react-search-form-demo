package org.dongguri.reactsearchformdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
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

}