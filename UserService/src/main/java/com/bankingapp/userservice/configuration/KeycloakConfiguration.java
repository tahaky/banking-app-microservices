package com.bankingapp.userservice.configuration;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Slf4j
@Configuration
public class KeycloakConfiguration {
    @Getter
    @Value("${app.config.keycloak.realm}")
    private String realm;
    @Value("${app.config.keycloak.server-url}")
    private String serverUrl;
    @Value("${app.config.keycloak.clientId}")
    private String clientId;
    @Value("${app.config.keycloak.client-secret}")
    private String clientSecret;
    private Optional<Keycloak> keycloakInstance;

    public Keycloak getInstance() {
        Keycloak keycloak;
        if (keycloakInstance.isEmpty()) {
            keycloak = KeycloakBuilder
                    .builder()
                    .serverUrl(serverUrl)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .realm(realm)
                    .grantType("client_credentials")
                    .build();
        } else throw new RuntimeException("err");
        return keycloak;
    }

}
