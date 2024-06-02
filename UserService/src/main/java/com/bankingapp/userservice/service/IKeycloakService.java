package com.bankingapp.userservice.service;

import jakarta.ws.rs.core.Response;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakService {


    Integer createUser(UserRepresentation userRepresentation);

    void updateUser(UserRepresentation userRepresentation);

    List<UserRepresentation> readUserByEmail(String email);

    UserRepresentation readUser(String authId);
}
