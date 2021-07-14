package com.onyx.gateway.demo.gatewaydemo.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableAutoConfiguration
public class OnyxGatewayConfig {

    @Bean
    public RouteLocator onyxRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/**")
                .uri("http://localhost:8080/"))
            .build();
    }
}
