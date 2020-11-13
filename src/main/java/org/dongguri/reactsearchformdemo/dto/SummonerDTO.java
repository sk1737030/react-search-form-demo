package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("summoner")
@Getter @AllArgsConstructor @NoArgsConstructor
public class SummonerDTO {
    private String id;
    private String accountId;
    private String puuid;
    private String profileIconId;
    private DateTime revisionDate;
    private String name;
    private String summonerLevel;
}
