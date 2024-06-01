package com.bankibgapp.bankingservice.model.mapper;

import com.bankibgapp.bankingservice.model.dto.BankAccountDto;
import com.bankibgapp.bankingservice.model.entity.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper extends BaseMapper<BankAccount, BankAccountDto> {
    @Override
    public BankAccount convertToEntity(BankAccountDto dto, Object... args) {
        BankAccount bankAccount = new BankAccount();
        if (dto != null) {
            BeanUtils.copyProperties(dto, bankAccount,"user");
        }
        return bankAccount;
    }

    @Override
    public BankAccountDto convertToDto(BankAccount entity, Object... args) {
        System.out.println(entity);
        BankAccountDto dto = new BankAccountDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto,"user");
        }
        return dto;
    }
}
