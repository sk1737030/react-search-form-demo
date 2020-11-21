package org.dongguri.reactsearchformdemo.config.error;

public class ApiException extends BusinessException {

    public ApiException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ApiException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
