package com.bankingapp.userservice.service;

import com.bankingapp.userservice.model.dto.UserDto;
import com.bankingapp.userservice.model.request.UserUpdateRequest;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    String createUser(UserDto user);

    String updateUser(UUID id, UserUpdateRequest userUpdateRequest);

    List<UserDto> getUsers();

    UserDto getUser(UUID id);
}
