package org.dongguri.reactsearchformdemo.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.TypeAlias;

@TypeAlias("grandmama")
@Getter @AllArgsConstructor @NoArgsConstructor
public class UserVO {
    private String gmama_cd;
    private String gmama_seq;
    private String gmama_id;
    private DateTime birth_day;
    private String lat;
    private String lng;
    private String gmama_nm_kor;
    private String gmama_status;
    private String cn;
}
