package org.dongguri.reactsearchformdemo.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dongguri.reactsearchformdemo.config.CustomLocalDateTimeDeserializer;
import org.dongguri.reactsearchformdemo.config.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InfoDto {
    private String match_id;
    private String game_version;
    private String game_variation;
    private List<ParticipantDto> participants;
    private float game_length;
    private int queue_id;
    private int tft_set_number;
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime game_datetime;

}
