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
    private Integer gold_left;
    private Integer last_round;
    private Integer level;
    private Integer placement;
    private Integer players_eliminated;
    private String puuid;
    private Float time_eliminated;
    private Integer total_damage_to_players;
    private List<TraitDto> traits;
    private List<UnitDto> units;

    public ParticipantDto(String match_id, Integer gold_left, Integer last_round, Integer level, Integer placement, Integer players_eliminated, String puuid, Float time_eliminated, Integer total_damage_to_players) {
        this.match_id = match_id;
        this.gold_left = gold_left;
        this.last_round = last_round;
        this.level = level;
        this.placement = placement;
        this.players_eliminated = players_eliminated;
        this.puuid = puuid;
        this.time_eliminated = time_eliminated;
        this.total_damage_to_players = total_damage_to_players;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }
}
