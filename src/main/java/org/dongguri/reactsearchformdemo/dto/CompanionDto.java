package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanionDto extends CommonMatchParticipantDTO {
    private String accountId;
    private String content_ID;
    private String skin_ID;
    private String species;
}
