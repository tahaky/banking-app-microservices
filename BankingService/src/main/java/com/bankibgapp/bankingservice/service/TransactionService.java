package com.bankibgapp.bankingservice.service;


import com.bankibgapp.bankingservice.model.dto.BankAccountDto;
import com.bankibgapp.bankingservice.model.dto.UtilityAccountDto;
import com.bankibgapp.bankingservice.model.entity.BankAccount;
import com.bankibgapp.bankingservice.model.entity.TransactionEntity;
import com.bankibgapp.bankingservice.model.TransactionType;
import com.bankibgapp.bankingservice.repository.BankAccountRepository;
import com.bankibgapp.bankingservice.repository.TransactionRepository;
import com.bankibgapp.bankingservice.model.request.FundTransferRequest;
import com.bankibgapp.bankingservice.model.request.UtilityPaymentRequest;
import com.bankibgapp.bankingservice.model.response.FundTransferResponse;
import com.bankibgapp.bankingservice.model.response.UtilityPaymentResponse;
import com.bankibgapp.bankingservice.util.TransactionUtil;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TransactionService implements ITransactionService {
    private final AccountService accountService;
    private final BankAccountRepository bankAccountRepository;

    private final TransactionRepository transactionRepository;
    private final TransactionUtil transactionUtil;

    public TransactionService(AccountService accountService, BankAccountRepository bankAccountRepository, TransactionRepository transactionRepository, TransactionUtil transactionUtil) {
        this.accountService = accountService;
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
        this.transactionUtil = transactionUtil;
    }

    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        BankAccountDto fromBankAccount = accountService.readBankAccount(fundTransferRequest.getFromAccount());
        BankAccountDto toBankAccount = accountService.readBankAccount(fundTransferRequest.getToAccount());
        transactionUtil.validateBalance(fromBankAccount, fundTransferRequest.getAmount());
        String transactionId = internalFundTransfer(fromBankAccount, toBankAccount, fundTransferRequest.getAmount());
        return new
                FundTransferResponse("Transaction successfully completed",
                transactionId);
    }


    public String internalFundTransfer(BankAccountDto fromBankAccount, BankAccountDto toBankAccount, BigDecimal amount) {
        String transactionId = UUID.randomUUID().toString();
        Optional<BankAccount> fromBankAccountEntityOptional = bankAccountRepository.findByBankingNumber(fromBankAccount.getBankingNumber());
        Optional<BankAccount> toBankAccountEntityOptional = bankAccountRepository.findByBankingNumber(toBankAccount.getBankingNumber());
        BankAccount fromBankAccountEntity;
        BankAccount toBankAccountEntity;

        if (fromBankAccountEntityOptional.isPresent() && toBankAccountEntityOptional.isPresent()) {
            toBankAccountEntity = toBankAccountEntityOptional.get();
            fromBankAccountEntity = fromBankAccountEntityOptional.get();
        } else throw new RuntimeException("err");

        fromBankAccountEntity = transactionUtil.setAccountBalances(fromBankAccountEntity, amount);
        bankAccountRepository.save(fromBankAccountEntity);
        transactionRepository.save(
                TransactionEntity.builder()
                        .transactionType(TransactionType.FUND_TRANSFER)
                        .referenceNumber(toBankAccountEntity.getBankingNumber())
                        .transactionId(transactionId)
                        .account(fromBankAccountEntity)
                        .amount(amount.negate())
                        .build()
        );
        toBankAccountEntity = transactionUtil.setAccountBalances(toBankAccountEntity, amount);
        transactionRepository.save(
                TransactionEntity.builder()
                        .transactionType(TransactionType.FUND_TRANSFER)
                        .referenceNumber(toBankAccountEntity.getBankingNumber())
                        .transactionId(transactionId)
                        .account(toBankAccountEntity)
                        .amount(amount)
                        .build());
        return transactionId;
    }

    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest) {

        String transactionId = UUID.randomUUID().toString();

        BankAccountDto fromBankAccount = accountService.readBankAccount(utilityPaymentRequest.getAccount());

        transactionUtil.validateBalance(fromBankAccount, utilityPaymentRequest.getAmount());

        UtilityAccountDto utilityAccount = accountService.readUtilityAccount(utilityPaymentRequest.getProviderId());

        Optional<BankAccount> fromAccountOptional = bankAccountRepository.findByBankingNumber(fromBankAccount.getBankingNumber());
        BankAccount fromAccount;
        if (fromAccountOptional.isPresent()) {
            fromAccount = fromAccountOptional.get();
        } else throw new RuntimeException("err");

        transactionRepository.save(TransactionEntity.builder()
                .transactionType(TransactionType.UTILITY_PAYMENT)
                .account(fromAccount)
                .transactionId(transactionId)
                .referenceNumber(utilityPaymentRequest.getReferenceNumber())
                .amount(utilityPaymentRequest.getAmount().negate()).build());

        return new UtilityPaymentResponse("Utility payment successfully completed", transactionId);

    }
}
