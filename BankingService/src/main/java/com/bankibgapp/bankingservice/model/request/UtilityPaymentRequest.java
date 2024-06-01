package com.bankibgapp.bankingservice.model.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;


@Data
public class UtilityPaymentRequest {
    private UUID providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;

}