package com.bankibgapp.bankingservice.controller;


import com.bankibgapp.bankingservice.model.request.FundTransferRequest;
import com.bankibgapp.bankingservice.model.request.UtilityPaymentRequest;
import com.bankibgapp.bankingservice.model.response.FundTransferResponse;
import com.bankibgapp.bankingservice.model.response.UtilityPaymentResponse;
import com.bankibgapp.bankingservice.service.ITransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/fund-transfer")
    public ResponseEntity<FundTransferResponse> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {

        log.info("Fund transfer initiated in core bank from {}", fundTransferRequest.toString());
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));

    }

    @PostMapping("/util-payment")
    public ResponseEntity<UtilityPaymentResponse> utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {
        log.info("Utility Payment initiated in core bank from {}", utilityPaymentRequest.toString());
        return ResponseEntity.ok(transactionService.utilPayment(utilityPaymentRequest));

    }
}
