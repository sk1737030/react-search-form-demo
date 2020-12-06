package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.joda.time.DateTime;

import java.util.List;

@Getter
@AllArgsConstructor
public class InfoDto {
    private DateTime game_datetime;
    private float game_length;
    private String game_variation;
    private String game_version;
    private List<ParticipantDto> participants;
    private int queue_id;
    private int tft_set_number;
}
