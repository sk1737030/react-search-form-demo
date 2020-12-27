package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TraitDto extends CommonMatchParticipantDTO {
    private String name;
    private Integer num_units;
    private Integer style;
    private Integer tier_current;
    private Integer tier_total;
}
