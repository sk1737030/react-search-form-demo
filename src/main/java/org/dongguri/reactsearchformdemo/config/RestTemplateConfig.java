package org.dongguri.reactsearchformdemo.config;


import lombok.RequiredArgsConstructor;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {


    private final RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder
                .requestFactory(new ClientHttpRequestFactorySupplier())
                .errorHandler(new RestTemplateErrorHandler())
                .build();
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClientFactory());

        return clientHttpRequestFactory;
    }

    @Bean
    public HttpClient httpClientFactory() {
        return HttpClientBuilder.create()
                .setMaxConnTotal(120)
                .setMaxConnPerRoute(10) // IP,포트 1쌍에 대해 수행 할 연결 수를 제한한다.
                .setConnectionTimeToLive(5, TimeUnit.SECONDS) // keep - alive
                .build();
    }


}
