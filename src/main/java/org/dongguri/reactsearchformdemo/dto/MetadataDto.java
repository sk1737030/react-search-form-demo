package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MetadataDto {
    private String data_version;
    private String match_id;
    private List<String> participants;

    @Builder
    public MetadataDto(String data_version, String match_id, List<String> participants) {
        this.data_version = data_version;
        this.match_id = match_id;
        this.participants = participants;
    }
}
