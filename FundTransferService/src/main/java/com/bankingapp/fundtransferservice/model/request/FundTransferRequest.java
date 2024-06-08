package com.bankingapp.fundtransferservice.model.request;

import java.math.BigDecimal;

public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
