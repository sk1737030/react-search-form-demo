package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDto extends CommonMatchParticipantDTO {
    private String match_id;
    private CompanionDto companion;
    private int gold_left;
    private int last_round;
    private int level;
    private int placement;
    private int players_eliminated;
    private String puuid;
    private float time_eliminated;
    private int total_damage_to_players;
    private List<TraitDto> traits;
    private List<UnitDto> units;

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }
}
