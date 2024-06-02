package com.bankingapp.userservice.configuration;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KeycloakManager {
    private final KeycloakConfiguration keycloakConfiguration;

    public RealmResource getKeyCloakInstanceWithRealm() {
        return keycloakConfiguration.getInstance().realm(keycloakConfiguration.getRealm());
    }
}
