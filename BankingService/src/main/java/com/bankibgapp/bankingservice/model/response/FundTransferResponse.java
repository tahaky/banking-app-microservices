package com.bankibgapp.bankingservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class FundTransferResponse {
    private String transactionId;
    private String message;


}
