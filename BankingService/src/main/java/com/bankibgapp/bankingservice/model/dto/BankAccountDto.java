package com.bankibgapp.bankingservice.model.dto;

import com.bankibgapp.bankingservice.model.AccountStatus;
import com.bankibgapp.bankingservice.model.AccountType;
import com.bankibgapp.bankingservice.model.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BankAccountDto {
    private UUID id;
    private String bankingNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private UserDto user;
}
