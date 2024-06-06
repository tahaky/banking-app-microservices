package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.model.dto.BankAccountDto;
import com.bankibgapp.bankingservice.model.dto.UtilityAccountDto;

import java.util.UUID;

public interface IAccountService {
    BankAccountDto readBankAccount(String accountNumber);

    public UtilityAccountDto readUtilityAccount(String provider);

    public UtilityAccountDto readUtilityAccount(UUID id);
}
