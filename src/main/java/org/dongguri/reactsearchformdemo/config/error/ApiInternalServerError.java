package org.dongguri.reactsearchformdemo.config.error;

public class ApiInternalServerError extends ApiException {
    public ApiInternalServerError() {
        super(ErrorCode.API_INTERNAL_SERVER_ERROR);
    }
}
