package com.bankingapp.fundtransferservice.model.response;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
}
