package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.model.dto.UserDto;
import com.bankibgapp.bankingservice.model.entity.User;
import com.bankibgapp.bankingservice.model.mapper.UserMapper;
import com.bankibgapp.bankingservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto readUser(String identificationNumber) {
        Optional<User> user = userRepository.findByIdentificationNumber(identificationNumber);
        if (user.isPresent()) {
            return userMapper.convertToDto(user.get());
        } else {
            throw new RuntimeException();
        }
    }

    public List<UserDto> readUsers() {
        return userMapper.convertToDtoList(userRepository.findAll());
    }

}
