package org.dongguri.reactsearchformdemo.dto.match;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongguri.reactsearchformdemo.dto.match.CommonMatchParticipantDTO;

import java.util.List;

@Getter
@NoArgsConstructor
public class UnitDto extends CommonMatchParticipantDTO {
    private List<Integer> items;
    private String character_id;
    private String chosen;
    private String name;
    private int rarity;
    private int tier;

    @Builder
    public UnitDto(List<Integer> items, String character_id, String chosen, String name, int rarity, int tier) {
        this.items = items;
        this.character_id = character_id;
        this.chosen = chosen;
        this.name = name;
        this.rarity = rarity;
        this.tier = tier;
    }
}
