package org.dongguri.reactsearchformdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.tomcat.jni.Local;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@TypeAlias("summoner")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class SummonerDTO {
    private String id;
    private String accountId;
    private String puuid;
    private String profileIconId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date revisionDate;
    private String name;
    private String summonerLevel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updDate;
}
