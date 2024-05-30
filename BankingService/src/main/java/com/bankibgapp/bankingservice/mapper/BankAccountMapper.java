package com.bankibgapp.bankingservice.mapper;

import com.bankibgapp.bankingservice.dto.BankAccountDTO;
import com.bankibgapp.bankingservice.model.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper extends BaseMapper<BankAccount, BankAccountDTO> {
    @Override
    public BankAccount convertToEntity(BankAccountDTO dto, Object... args) {
        BankAccount bankAccount = new BankAccount();
        if (dto != null) {
            BeanUtils.copyProperties(dto, bankAccount, "user");
        }
        return bankAccount;
    }

    @Override
    public BankAccountDTO convertToDto(BankAccount entity, Object... args) {
        BankAccountDTO dto = new BankAccountDTO();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "user");
        }
        return dto;
    }
}
