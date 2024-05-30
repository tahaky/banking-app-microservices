package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.dto.BankAccountDTO;
import com.bankibgapp.bankingservice.model.BankAccount;
import com.bankibgapp.bankingservice.repository.BankAccountRepository;
import com.bankibgapp.bankingservice.repository.TransactionRepository;
import com.bankibgapp.bankingservice.request.FundTransferRequest;
import com.bankibgapp.bankingservice.response.FundTransferResponse;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final AccountService accountService;
    private final BankAccountRepository bankAccountRepository;

    private final TransactionRepository transactionRepository;

    public TransactionService(AccountService accountService, BankAccountRepository bankAccountRepository, TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }


    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        BankAccountDTO fromBankAccount = accountService.readBankAccount(fundTransferRequest.getFromAccount());
        BankAccountDTO toBankAccount = accountService.readBankAccount(fundTransferRequest.getToAccount());
        TransactionUtil.validateBalance(fromBankAccount, fundTransferRequest.getAmount());



    }
}
