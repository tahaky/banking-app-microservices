package com.bankibgapp.bankingservice.model.mapper;

import com.bankibgapp.bankingservice.model.dto.UserDTO;
import com.bankibgapp.bankingservice.model.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends BaseMapper<User, UserDTO> {
    private final BankAccountMapper bankAccountMapper;
    public UserMapper(BankAccountMapper bankAccountMapper) {
        this.bankAccountMapper = bankAccountMapper;
    }
    @Override
    public User convertToEntity(UserDTO dto, Object... args) {
        User user = new User();
        if (dto != null) {
            BeanUtils.copyProperties(dto, user, "accounts");
            user.setBankAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
        }
        return user;
    }

    @Override
    public UserDTO convertToDto(User entity, Object... args) {
        UserDTO userDTO = new UserDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, userDTO);
        }
        return userDTO;
    }

}
