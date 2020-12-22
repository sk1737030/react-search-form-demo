package org.dongguri.reactsearchformdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dongguri.reactsearchformdemo.config.CustomLocalDateTimeDeserializer;
import org.dongguri.reactsearchformdemo.config.CustomLocalDateTimeSerializer;

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
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime revisionDate;
    @JsonProperty(value = "name")
    private String summonerName;
    private String summonerLevel;
    private LocalDateTime updDate;

}