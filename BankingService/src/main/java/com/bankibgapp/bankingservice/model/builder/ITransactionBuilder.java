package com.bankibgapp.bankingservice.model.builder;

import com.bankibgapp.bankingservice.model.TransactionType;
import com.bankibgapp.bankingservice.model.entity.BankAccount;
import com.bankibgapp.bankingservice.model.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

public interface ITransactionBuilder {
    TransactionEntity amount(BigDecimal amount);

    TransactionEntity transactionType(TransactionType transactionType);

    TransactionEntity referenceNumber(String referenceNumber);

    TransactionEntity transactionId(String transactionId);

    TransactionEntity account(BankAccount account);

    TransactionEntity build();

}
