package com.bankingapp.userservice.model.mapper;

import com.bankingapp.userservice.model.UserEntity;
import com.bankingapp.userservice.model.dto.UserDto;
import org.springframework.beans.BeanUtils;

public class UserMapper extends Mapper<UserEntity, UserDto> {
    @Override
    public UserEntity mapToEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    @Override
    public UserDto mapToDto(UserEntity entity) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto);
        return userDto;
    }
}
