package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.model.dto.UserDto;

import java.util.List;

public interface IUserService {


    UserDto readUser(String identificationNumber);

    List<UserDto> readUsers();
}
