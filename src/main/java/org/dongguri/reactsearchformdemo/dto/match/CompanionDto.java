package org.dongguri.reactsearchformdemo.dto.match;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dongguri.reactsearchformdemo.dto.match.CommonMatchParticipantDTO;

@Getter
@AllArgsConstructor
public class CompanionDto extends CommonMatchParticipantDTO {
    private String content_ID;
    private String skin_ID;
    private String species;
}
