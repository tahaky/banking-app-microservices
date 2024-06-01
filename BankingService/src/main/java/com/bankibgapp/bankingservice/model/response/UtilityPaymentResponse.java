package com.bankibgapp.bankingservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UtilityPaymentResponse  {
    private String message;
    private String transactionId;
}