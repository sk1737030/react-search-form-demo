package org.dongguri.reactsearchformdemo.config;

import org.dongguri.reactsearchformdemo.config.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    private static final Map<HttpStatus, BusinessException> exceptionMap = new EnumMap<>(HttpStatus.class);

    static {
        exceptionMap.put(HttpStatus.BAD_REQUEST, new ApiBadRequestException());
        exceptionMap.put(HttpStatus.NOT_FOUND, new SummonerNotFoundException());
        exceptionMap.put(HttpStatus.UNAUTHORIZED, new ApiUnauthException());
        exceptionMap.put(HttpStatus.FORBIDDEN, new ApiForbiddenException());
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (exceptionMap.containsKey(response.getStatusCode())) {
            throw exceptionMap.get(response.getStatusCode());
        }
    }
}
