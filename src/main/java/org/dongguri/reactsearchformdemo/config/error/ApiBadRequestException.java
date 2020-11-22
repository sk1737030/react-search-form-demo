package org.dongguri.reactsearchformdemo.config.error;

public class ApiBadRequestException extends ApiException {
    public ApiBadRequestException() {
        super(ErrorCode.API_BAD_REQUEST);
    }
}
