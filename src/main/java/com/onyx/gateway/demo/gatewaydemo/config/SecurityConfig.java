package com.onyx.gateway.demo.gatewaydemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${jwk.endpoint}")
    private String jwkEndpoint;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                .csrf().disable()
                .authorizeExchange()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt(jwtSpec -> {jwtSpec.jwkSetUri(jwkEndpoint);})
                .and()
                .build();
    }
}
