package org.dongguri.reactsearchformdemo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MatchDto {
    private MetaDataDto metadata;
    private InfoDto  info;

    @Builder
    public MatchDto(MetaDataDto metadata, InfoDto info) {
        this.metadata = metadata;
        this.info = info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
        this.info.setMatch_id(this.metadata.getMatch_id());
    }
}
