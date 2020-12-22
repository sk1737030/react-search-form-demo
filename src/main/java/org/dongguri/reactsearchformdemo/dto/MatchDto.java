package org.dongguri.reactsearchformdemo.dto;

import lombok.Getter;

@Getter
public class MatchDto {
    private MetadataDto metadata;
    private InfoDto  info;

    public void setInfo(InfoDto info) {
        this.info = info;
        this.info.setMatch_id(this.metadata.getMatch_id());
    }
}
