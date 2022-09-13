package com.one.two.springcloudgatewayservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {
    @Value("${baseurl.songservice}")
    private String songServiceBaseUrl;
    @Value("${baseurl.resourceservice}")
    private String resourceServiceBaseUrl;
    @Value("${baseurl.storageservice}")
    private String storageServiceBaseUrl;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/songs/**")
                        .uri(songServiceBaseUrl))

                .route(r -> r.path("/resources/**")
                        .uri(resourceServiceBaseUrl))

                .route(r -> r.path("/storages/**")
                        .uri(storageServiceBaseUrl))

                .build();
    }
}
