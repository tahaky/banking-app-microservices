package com.bankibgapp.bankingservice.model.mapper;

import com.bankibgapp.bankingservice.model.dto.UserDto;
import com.bankibgapp.bankingservice.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper extends BaseMapper<User, UserDto> {

    private final BankAccountMapper bankAccountMapper;


    @Override
    public User convertToEntity(UserDto dto, Object... args) {
        User user = new User();
        if (dto != null) {
            BeanUtils.copyProperties(dto, user,"bankAccounts");
            System.out.println(dto.getBankAccounts());
            user.setBankAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
        }
        return user;

    }

    @Override
    public UserDto convertToDto(User entity, Object... args) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(entity, userDto,"bankAccounts");
        userDto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getBankAccounts()));
        return userDto;
    }
}
