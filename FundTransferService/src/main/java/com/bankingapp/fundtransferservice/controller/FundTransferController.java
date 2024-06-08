package com.bankingapp.fundtransferservice.controller;

import com.bankingapp.fundtransferservice.model.dto.FundTransferDto;
import com.bankingapp.fundtransferservice.model.request.FundTransferRequest;
import com.bankingapp.fundtransferservice.model.response.FundTransferResponse;
import com.bankingapp.fundtransferservice.service.FundTransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/transfer")
public class FundTransferController {
    private final FundTransferService fundTransfer;


    @PostMapping
    public ResponseEntity<FundTransferResponse> sendFundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        log.info("Got fund transfer request from API {}", fundTransferRequest.toString());
        return ResponseEntity.ok(fundTransfer.fundTransfer(fundTransferRequest));
    }

    @GetMapping
    public ResponseEntity<List<FundTransferDto>> readFundTransfers() {
        log.info("Reading fund transfers from core");
        return ResponseEntity.ok(fundTransfer.readAllTransfers());
    }
}
