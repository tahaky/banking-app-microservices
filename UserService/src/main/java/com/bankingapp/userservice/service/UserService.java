package com.bankingapp.userservice.service;

import com.bankingapp.userservice.model.dto.UserDto;
import com.bankingapp.userservice.model.mapper.UserMapper;
import com.bankingapp.userservice.repository.UserRepository;
import com.bankingapp.userservice.util.IUserServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IKeycloakService keycloakService;
    private final UserRepository userRepository;
    private final IUserServiceUtil userServiceUtil;
    private final UserMapper userMapper = new UserMapper();


    public UserDto createUser(UserDto user) {
        List<UserRepresentation> userRepresentations = keycloakService.readUserByEmail(user.getEmail());
        if (!userRepresentations.isEmpty()) {
            throw new RuntimeException("This email already registered as a user. Please check and retry.");
        }
        CredentialRepresentation credentialRepresentation = userServiceUtil.createCredentialRepresentation(user);
        UserRepresentation userRepresentation = userServiceUtil.
                createUserRepresentation(user, credentialRepresentation);
        Integer userCreationResponse = keycloakService.createUser(userRepresentation);

        return null;
    }
}