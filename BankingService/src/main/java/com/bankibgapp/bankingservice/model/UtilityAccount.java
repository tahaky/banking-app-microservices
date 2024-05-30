package com.bankibgapp.bankingservice.model;

import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "banking_utility_account")
public class UtilityAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String number;
    private String providerName;

    public UtilityAccount(UUID id, String number, String providerName) {
        this.id = id;
        this.number = number;
        this.providerName = providerName;
    }

    public UtilityAccount() {

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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }


}
