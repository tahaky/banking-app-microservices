package com.bankingapp.userservice.configuration;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
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
    private static Keycloak keycloakInstance = null;

    public Keycloak getInstance() {
        if (keycloakInstance == null) {
            keycloakInstance = KeycloakBuilder
                    .builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .build();
        }
        return keycloakInstance;
    }


}
