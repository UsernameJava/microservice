package com.one.two.springcloudgatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/songs/**")
                        .uri("http://songservice:8084/"))

                .route(r -> r.path("/resources/**")
                        .uri("http://resourceservice:8086/"))

                .route(r -> r.path("/storages/**")
                        .uri("http://storageservice:8087/"))

                .build();
    }
}
