package org.dongguri.reactsearchformdemo.config.error;

public class ApiUnauthException extends ApiException {
    public ApiUnauthException() {
        super(ErrorCode.API_UNAUTHORIZED);
    }
}
