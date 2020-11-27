package org.dongguri.reactsearchformdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongguri.reactsearchformdemo.config.error.ErrorCode;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorResponseDto {
    private String message;
    private int status;
    private List<FieldError> errors;
    private String code;

    public ErrorResponseDto(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
        this.errors = new ArrayList<>();
    }

    public ErrorResponseDto(final ErrorCode code, final List<FieldError> errors) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
        this.errors = errors;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FieldError {
        private String field;
        private String value;
        private String reason;
    }
}
