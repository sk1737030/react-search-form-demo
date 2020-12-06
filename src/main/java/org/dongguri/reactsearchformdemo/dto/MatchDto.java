package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class MatchDto {
    private final String data_version;
    private final String match_id;
    private final List<String> participants = new ArrayList<>();
}
