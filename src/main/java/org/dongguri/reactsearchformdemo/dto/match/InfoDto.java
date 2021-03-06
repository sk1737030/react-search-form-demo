package org.dongguri.reactsearchformdemo.dto.match;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongguri.reactsearchformdemo.dto.metadata.ParticipantDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class InfoDto {
    private String match_id;
    private String game_version;
    private String game_variation;
    private List<ParticipantDto> participants;
    private Float game_length;
    private Integer queue_id;
    private Integer tft_set_number;
    private LocalDateTime game_datetime;

    @Builder
    public InfoDto(String match_id, String game_version, String game_variation, Float game_length, Integer queue_id, Integer tft_set_number, LocalDateTime game_datetime) {
        this.match_id = match_id;
        this.game_version = game_version;
        this.game_variation = game_variation;
        this.game_length = game_length;
        this.queue_id = queue_id;
        this.tft_set_number = tft_set_number;
        this.game_datetime = game_datetime;
    }

    @Builder
    public InfoDto(String match_id, String game_version, String game_variation, List<ParticipantDto> participants, Float game_length, Integer queue_id, Integer tft_set_number, LocalDateTime game_datetime) {
        this.match_id = match_id;
        this.game_version = game_version;
        this.game_variation = game_variation;
        this.participants = participants;
        this.game_length = game_length;
        this.queue_id = queue_id;
        this.tft_set_number = tft_set_number;
        this.game_datetime = game_datetime;
    }

    public void setMatch_id(String match_id) {
        this.match_id = match_id;
    }
}
