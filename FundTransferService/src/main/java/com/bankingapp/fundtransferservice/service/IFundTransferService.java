package com.bankingapp.fundtransferservice.service;

import com.bankingapp.fundtransferservice.model.dto.FundTransferDto;
import com.bankingapp.fundtransferservice.model.request.FundTransferRequest;
import com.bankingapp.fundtransferservice.model.response.FundTransferResponse;

import java.util.List;


public interface IFundTransferService {
    public FundTransferResponse fundTransfer(FundTransferRequest request);

    public List<FundTransferDto> readAllTransfers();


}
