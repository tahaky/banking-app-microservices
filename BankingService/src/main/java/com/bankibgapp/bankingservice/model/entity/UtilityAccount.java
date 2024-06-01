package com.bankibgapp.bankingservice.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "banking_utility_account")

public class UtilityAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String number;
    private String providerName;


}
