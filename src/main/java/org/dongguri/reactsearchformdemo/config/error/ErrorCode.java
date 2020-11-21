package org.dongguri.reactsearchformdemo.config.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    API_BAD_REQUEST(400, "A000", "잘못된 요청입니다."),
    API_UNAUTHORIZED(401, "A001", "잘못된 요청입니다."), // Unauthorized
    API_FORBIDDEN(403, "A002", "내부 오류입니다. 관리자에 문의해주세요."), // 라이센스 만료

    SUMMONER_NOT_FOUND(404, "S001", "요청하신 사용자 닉네임이 없습니다. 다시 한 번 확인해주세요."),

    ;

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
