package com.bankingapp.apigateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange(
                        auth -> auth.pathMatchers("/user/api/v1/register").permitAll()
                                .anyExchange().authenticated()
                )
                .csrf(csrf -> csrf.disable())
                .oauth2ResourceServer((oauth2) -> oauth2
                .jwt(Customizer.withDefaults()))
                .oauth2Login(Customizer.withDefaults());
      return http.build();
    }
}
