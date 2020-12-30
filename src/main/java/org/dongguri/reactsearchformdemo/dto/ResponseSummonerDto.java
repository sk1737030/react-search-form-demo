package org.dongguri.reactsearchformdemo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResponseSummonerDto {

    private Integer statusCode;
    private String message;
    private SummonerDTO summonerDTO;

    @Builder
    public ResponseSummonerDto(Integer statusCode, String message, SummonerDTO summonerDTO) {
        this.statusCode = statusCode;
        this.message = message;
        this.summonerDTO = summonerDTO;
    }
}
