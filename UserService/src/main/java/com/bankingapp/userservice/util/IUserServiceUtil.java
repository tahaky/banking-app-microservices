package com.bankingapp.userservice.util;

import com.bankingapp.userservice.model.dto.UserDto;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;

public interface IUserServiceUtil {

    UserRepresentation createUserRepresentation(UserDto userDto,CredentialRepresentation credentialRepresentation);

    CredentialRepresentation createCredentialRepresentation(UserDto userDto);

    UserDto representationToEntityDto(UserDto userDto);
}
