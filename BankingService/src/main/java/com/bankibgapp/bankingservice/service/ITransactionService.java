package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.model.dto.BankAccountDto;

import com.bankibgapp.bankingservice.model.request.FundTransferRequest;
import com.bankibgapp.bankingservice.model.request.UtilityPaymentRequest;
import com.bankibgapp.bankingservice.model.response.FundTransferResponse;
import com.bankibgapp.bankingservice.model.response.UtilityPaymentResponse;

import java.math.BigDecimal;


public interface ITransactionService {

    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);

    String internalFundTransfer(BankAccountDto fromBankAccount, BankAccountDto toBankAccount, BigDecimal amount);

    UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest);
}
