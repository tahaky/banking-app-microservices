package com.bankingapp.userservice.util;

import com.bankingapp.userservice.model.dto.UserDto;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class UserServiceUtil implements IUserServiceUtil {
    @Override
    public UserRepresentation createUserRepresentation(UserDto userDto,CredentialRepresentation credentialRepresentation) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(userDto.getEmail());
        userRepresentation.setEmailVerified(false);
        userRepresentation.setEnabled(false);
        userRepresentation.setUsername(userDto.getEmail());
        userRepresentation.setCredentials(Collections.singletonList(credentialRepresentation));

        return userRepresentation;
    }

    @Override
    public CredentialRepresentation createCredentialRepresentation(UserDto userDto) {
        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(userDto.getPassword());
        credentialRepresentation.setTemporary(false);
        return credentialRepresentation;
    }

    @Override
    public UserDto representationToEntityDto(UserDto userDto) {
        return UserDto.builder()
                .authId(userDto.getAuthId())
                .email(userDto.getEmail())
                .build();
    }
}
