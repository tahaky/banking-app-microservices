package com.bankibgapp.bankingservice.model.dto;

import com.bankibgapp.bankingservice.model.entity.BankAccount;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
