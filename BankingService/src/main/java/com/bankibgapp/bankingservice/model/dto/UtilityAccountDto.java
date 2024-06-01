package com.bankibgapp.bankingservice.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UtilityAccountDto {

    private UUID id;
    private String number;
    private String providerName;

}
