package org.dongguri.reactsearchformdemo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MetaDataDto {
    private Integer data_version;
    private String match_id;
    private List<String> participants;

    @Builder
    public MetaDataDto(Integer data_version, String match_id, List<String> participants) {
        this.data_version = data_version;
        this.match_id = match_id;
        this.participants = participants;
    }

    public MetaDataDto(String match_id, Integer data_version) {
        this.data_version = data_version;
        this.match_id = match_id;
    }
}
