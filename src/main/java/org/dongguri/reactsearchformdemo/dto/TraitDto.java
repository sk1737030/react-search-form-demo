package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraitDto {
    private String name;
    private int num_units;
    private int style;
    private int tier_current;
    private int tier_total;
}
