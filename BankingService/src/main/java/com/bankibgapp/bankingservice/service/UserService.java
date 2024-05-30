package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.dto.UserDTO;
import com.bankibgapp.bankingservice.mapper.UserMapper;
import com.bankibgapp.bankingservice.model.User;
import com.bankibgapp.bankingservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDTO getUser(String identificationNumber) {
        Optional<User> user = userRepository.findByIdentificationNumber(identificationNumber);
        if (user.isPresent()) {
            UserDTO userDTO = new UserDTO();
            return userMapper.convertToDto(user.get());
        } else {
            throw new RuntimeException("err");
        }
    }

    public List<UserDTO> readUsers() {
        return userMapper.convertToDtoList(userRepository.findAll());
    }

}
