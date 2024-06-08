package com.bankingapp.fundtransferservice.service;

import com.bankingapp.fundtransferservice.model.FundTransfer;
import com.bankingapp.fundtransferservice.model.TransactionStatus;
import com.bankingapp.fundtransferservice.model.dto.FundTransferDto;
import com.bankingapp.fundtransferservice.model.mapper.FundTransferMapper;
import com.bankingapp.fundtransferservice.model.request.FundTransferRequest;
import com.bankingapp.fundtransferservice.model.response.FundTransferResponse;
import com.bankingapp.fundtransferservice.repository.FundTransferRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FundTransferService implements IFundTransferService {
    private final FundTransferRepository fundTransferRepository;
    private final FundTransferMapper fundTransferMapper = new FundTransferMapper();

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest request) {
        log.info("Sending fund transfer request {}" + request.toString());
        FundTransfer entity = GetTransferEntity(request);
        FundTransfer optFundTransfer = fundTransferRepository.save(entity);
        return GetTransferResponse(optFundTransfer.getId());
    }

    @Override
    public List<FundTransferDto> readAllTransfers() {
        List<FundTransfer> fundTransferDtoList = fundTransferRepository.findAll();
        return fundTransferMapper.mapToDtoList(fundTransferDtoList);
    }

    private FundTransfer GetTransferEntity(FundTransferRequest request) {
        FundTransfer fundTransfer = new FundTransfer();
        BeanUtils.copyProperties(request, fundTransfer);
        fundTransfer.setStatus(TransactionStatus.PENDING);
        return fundTransfer;
    }

    private FundTransferResponse GetTransferResponse(UUID transferId) {
        FundTransferResponse fundTransferResponse = new FundTransferResponse();
        fundTransferResponse.setTransactionId(transferId.toString());
        fundTransferResponse.setMessage("Success");
        return fundTransferResponse;
    }
}
