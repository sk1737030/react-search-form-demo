package org.dongguri.reactsearchformdemo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TypeAlias("summoner")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SummonerVO {
    private String id;
    private String accountId;
    private String puuid;
    private String profileIconId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date revisionDate;
    private String name;
    private String summonerLevel;
    private Date inptDate;
    private Date updDate;
}

