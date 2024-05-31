package com.bankibgapp.bankingservice.model.entity;


import com.bankibgapp.bankingservice.model.TransactionType;
import com.bankibgapp.bankingservice.model.builder.ITransactionBuilder;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "banking_transaction")
public class TransactionEntity implements ITransactionBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String referenceNumber;
    private String transactionId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccount account;

    public TransactionEntity(TransactionEntity transactionEntity) {
        this.id = transactionEntity.id;
        this.amount = transactionEntity.amount;
        this.transactionType = transactionEntity.transactionType;
        this.referenceNumber = transactionEntity.referenceNumber;
        this.transactionId = transactionEntity.transactionId;
        this.account = transactionEntity.account;
    }

    public TransactionEntity() {

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    //builder
    @Override
    public TransactionEntity amount(BigDecimal amount) {
        setAmount(amount);
        return this;
    }

    @Override
    public TransactionEntity transactionType(TransactionType transactionType) {
        setTransactionType(transactionType);
        return this;
    }

    @Override
    public TransactionEntity referenceNumber(String referenceNumber) {
        setReferenceNumber(referenceNumber);
        return this;
    }

    @Override
    public TransactionEntity transactionId(String transactionId) {
        setTransactionId(transactionId);
        return this;
    }

    @Override
    public TransactionEntity account(BankAccount account) {
        setAccount(account);
        return this;
    }

    @Override
    public TransactionEntity build() {
        return new TransactionEntity(this);
    }
}
