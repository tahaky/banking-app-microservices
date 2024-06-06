package com.bankibgapp.bankingservice.service;


import com.bankibgapp.bankingservice.model.dto.BankAccountDto;
import com.bankibgapp.bankingservice.model.dto.UtilityAccountDto;
import com.bankibgapp.bankingservice.model.entity.BankAccount;
import com.bankibgapp.bankingservice.model.entity.UtilityAccount;
import com.bankibgapp.bankingservice.model.mapper.BankAccountMapper;
import com.bankibgapp.bankingservice.model.mapper.UtilityAccountMapper;
import com.bankibgapp.bankingservice.repository.BankAccountRepository;
import com.bankibgapp.bankingservice.repository.UtilityAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {

    private final BankAccountMapper bankAccountMapper;
    private final UtilityAccountMapper utilityAccountMapper;
    private final BankAccountRepository bankAccountRepository;
    private final UtilityAccountRepository utilityAccountRepository;

    public AccountService(BankAccountMapper bankAccountMapper, UtilityAccountMapper utilityAccountMapper, BankAccountRepository bankAccountRepository, UtilityAccountRepository utilityAccountRepository) {
        this.bankAccountMapper = bankAccountMapper;
        this.utilityAccountMapper = utilityAccountMapper;
        this.bankAccountRepository = bankAccountRepository;
        this.utilityAccountRepository = utilityAccountRepository;
    }

    public BankAccountDto readBankAccount(String accountNumber) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findByBankingNumber(accountNumber);
        if (bankAccount.isPresent()) {
            return bankAccountMapper.convertToDto(bankAccount.get());
        } else {
            throw new RuntimeException("err");
        }
    }

    public UtilityAccountDto readUtilityAccount(String provider) {
        Optional<UtilityAccount> utilityAccountEntity = utilityAccountRepository.findByProviderName(provider);
        if (utilityAccountEntity.isPresent()) {
            return utilityAccountMapper.convertToDto(utilityAccountEntity.get());
        } else {
            throw new RuntimeException("err");
        }
    }

    public UtilityAccountDto readUtilityAccount(UUID id) {
        Optional<UtilityAccount> utilityAccount = utilityAccountRepository.findById(id);
        if (utilityAccount.isPresent()) {
            return utilityAccountMapper.convertToDto(utilityAccount.get());
        } else {
            throw new RuntimeException("err");
        }
    }

}
