package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TraitDto extends CommonMatchParticipantDTO {
    private String name;
    private Integer num_units;
    private Integer style;
    private Integer tier_current;
    private Integer tier_total;

    @Builder
    public TraitDto(String name, Integer num_units, Integer style, Integer tier_current, Integer tier_total) {
        this.name = name;
        this.num_units = num_units;
        this.style = style;
        this.tier_current = tier_current;
        this.tier_total = tier_total;
    }
}
