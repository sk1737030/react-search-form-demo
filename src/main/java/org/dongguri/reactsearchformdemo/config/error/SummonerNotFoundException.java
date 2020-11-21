package org.dongguri.reactsearchformdemo.config.error;

public class SummonerNotFoundException extends SummonerException {

    public SummonerNotFoundException() {
        super(ErrorCode.SUMMONER_NOT_FOUND);
    }
}
