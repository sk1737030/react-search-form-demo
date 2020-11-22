package org.dongguri.reactsearchformdemo.config.error;

public class ApiForbiddenException extends ApiException {

    public ApiForbiddenException() {
        super(ErrorCode.API_FORBIDDEN);
    }
}
