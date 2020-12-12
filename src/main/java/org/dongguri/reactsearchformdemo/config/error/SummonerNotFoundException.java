package org.dongguri.reactsearchformdemo.config.error;

public class SummonerNotFoundException extends SummonerException {

    public SummonerNotFoundException() {
        super(ErrorCode.SUMMONER_NOT_FOUND);
    }

    public SummonerNotFoundException(String message) {
        super(message, ErrorCode.SUMMONER_NOT_FOUND);
    }
}
