package com.bankibgapp.bankingservice.model.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String identificationNumber;
    private List<BankAccountDto> bankAccounts;
}
