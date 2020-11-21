package org.dongguri.reactsearchformdemo.config.error;

public class SummonerException extends BusinessException {


    public SummonerException(ErrorCode errorCode) {
        super(errorCode);
    }

    public SummonerException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }


}
