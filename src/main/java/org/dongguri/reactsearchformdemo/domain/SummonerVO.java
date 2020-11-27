package org.dongguri.reactsearchformdemo.domain;

import lombok.*;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("summoner")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SummonerVO {
    private String id;
    private String accountId;
    private String puuid;
    private String profileIconId;
    private DateTime revisionDate;
    private String name;
    private String summonerLevel;
}

