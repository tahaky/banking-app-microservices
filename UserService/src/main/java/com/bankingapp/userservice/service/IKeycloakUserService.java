package com.bankingapp.userservice.service;

import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface IKeycloakUserService {


    Integer createUser(UserRepresentation userRepresentation);

    void updateUser(UserRepresentation userRepresentation);

    List<UserRepresentation> readUserByEmail(String email);

    UserRepresentation readUser(String authId);
}
