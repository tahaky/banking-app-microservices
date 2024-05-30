package com.bankibgapp.bankingservice.service;


import com.bankibgapp.bankingservice.dto.BankAccountDTO;
import com.bankibgapp.bankingservice.dto.UtilityAccountDTO;
import com.bankibgapp.bankingservice.mapper.BankAccountMapper;
import com.bankibgapp.bankingservice.mapper.UtilityAccountMapper;
import com.bankibgapp.bankingservice.model.BankAccount;
import com.bankibgapp.bankingservice.model.UtilityAccount;
import com.bankibgapp.bankingservice.model.UtilityAccountRepository;
import com.bankibgapp.bankingservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

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

    public BankAccountDTO readBankAccount(String accountNumber) {
        Optional<BankAccount> bankAccount = bankAccountRepository.findByNumber(accountNumber);
        if (bankAccount.isPresent()) {
            return bankAccountMapper.convertToDto(bankAccount.get());
        } else {
            throw new RuntimeException("err");
        }
    }

    public UtilityAccountDTO readUtilityAccount(String provider) {
        Optional<UtilityAccount> utilityAccountEntity = utilityAccountRepository.findByProviderName(provider);
        if (utilityAccountEntity.isPresent()) {
            return utilityAccountMapper.convertToDto(utilityAccountEntity.get());
        } else {
            throw new RuntimeException("err");
        }
    }

    public UtilityAccountDTO readUtilityAccount(UUID id) {
        Optional<UtilityAccount> utilityAccount = utilityAccountRepository.findById(id);
        if (utilityAccount.isPresent()) {
            return utilityAccountMapper.convertToDto(utilityAccount.get());
        } else {
            throw new RuntimeException("err");
        }
    }

}
