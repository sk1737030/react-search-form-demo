package org.dongguri.reactsearchformdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application-private.properties")
@Getter
public class AppProperties {
    @Value("${API_KEY}")
    private String apiKey;

    @Value("${elasticsearch.ip}")
    private String hostName;

    @Value("${elasticsearch.port}")
    private String port;

    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    @Value("${elasticsearch.pool}")
    private String poolSize;

    @Value("${API_CALL_SIZE}")
    private Integer callMatchListSize;

}
