package com.bankibgapp.bankingservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
public class FundTransferResponse {
    private String transactionId;
    private String message;


}
