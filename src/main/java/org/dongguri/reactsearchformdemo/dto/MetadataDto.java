package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MetadataDto {
    private String data_version;
    private String match_id;
    private List<String> participants;
}
