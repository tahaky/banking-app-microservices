package com.bankingapp.userservice.service;

import com.bankingapp.userservice.model.Status;
import com.bankingapp.userservice.model.UserEntity;
import com.bankingapp.userservice.model.dto.UserDto;
import com.bankingapp.userservice.model.mapper.UserMapper;
import com.bankingapp.userservice.model.request.UserUpdateRequest;
import com.bankingapp.userservice.repository.UserRepository;
import com.bankingapp.userservice.util.IUserServiceUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IKeycloakUserService keycloakService;
    private final UserRepository userRepository;
    private final IUserServiceUtil userServiceUtil;
    private final UserMapper userMapper = new UserMapper();


    public String createUser(UserDto user) {
        List<UserRepresentation> userRepresentations = keycloakService.readUserByEmail(user.getEmail());
        if (!userRepresentations.isEmpty()) {
            throw new RuntimeException("This email already registered as a user. Please check and retry.");
        }
        CredentialRepresentation credentialRepresentation = userServiceUtil.createCredentialRepresentation(user);
        UserRepresentation userRepresentation = userServiceUtil.createUserRepresentation(user, credentialRepresentation);
        Integer userCreationResponse = keycloakService.createUser(userRepresentation);
        if (userCreationResponse == HttpStatus.SC_CREATED) {
            log.info("User created under given username {}", user.getEmail());
            return user.getEmail();
        }
        throw new RuntimeException("User could not be created");
    }

    public List<UserDto> getUsers() {
        List<UserDto> users = userMapper.mapToDtoList(userRepository.findAll());
        users = users.stream()
                .map(userServiceUtil::representationToEntityDto)
                .map(user -> setEmailFromUserRepresentation(user.getAuthId()))
                .collect(Collectors.toList());
        return users;
    }

    public UserDto getUser(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.mapToDto(user.get());
        }
        throw new RuntimeException("User Not Found");
    }

    public String updateUser(UUID id, UserUpdateRequest userUpdateRequest) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            if (user.getStatus() == Status.APPROVED) {
                UserRepresentation userRepresentation = keycloakService.readUser(user.getAuthId());
                userRepresentation.setEnabled(true);
                userRepresentation.setEmailVerified(true);
                keycloakService.updateUser(userRepresentation);
            }
            user.setStatus(userUpdateRequest.getStatus());
            return user.getAuthId();
        } else {
            throw new RuntimeException("User is not present");
        }
    }


    private UserDto setEmailFromUserRepresentation(String authId) {
        UserRepresentation userRepresentation = keycloakService.readUser(authId);
        return UserDto
                .builder()
                .email(userRepresentation.getEmail())
                .build();
    }
}


