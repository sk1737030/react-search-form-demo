package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSummonerDto {

    private Integer statusCode;
    private String message;
    private SummonerDTO summonerDTO;
}
