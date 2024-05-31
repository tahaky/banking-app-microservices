package com.bankibgapp.bankingservice.model.entity;

import com.bankibgapp.bankingservice.model.AccountStatus;
import com.bankibgapp.bankingservice.model.AccountType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "banking_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String number;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public BankAccount(UUID id, String number, AccountType accountType, AccountStatus accountStatus,
                       BigDecimal availableBalance, BigDecimal actualBalance, User user) {
        this.id = id;
        this.number = number;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.availableBalance = availableBalance;
        this.actualBalance = actualBalance;
        this.user = user;
    }

    public BankAccount() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getActualBalance() {
        return actualBalance;
    }

    public void setActualBalance(BigDecimal actualBalance) {
        this.actualBalance = actualBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
