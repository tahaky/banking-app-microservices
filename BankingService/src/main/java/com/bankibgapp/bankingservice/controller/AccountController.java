package com.bankibgapp.bankingservice.controller;


import com.bankibgapp.bankingservice.model.dto.BankAccountDto;
import com.bankibgapp.bankingservice.model.dto.UtilityAccountDto;
import com.bankibgapp.bankingservice.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/account")
public class AccountController {

    private final IAccountService accountService;

    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/bank-account/{account_number}")
    public ResponseEntity<BankAccountDto> getBankAccount(@PathVariable("account_number") String accountNumber) {
        log.info("Reading account by ID {}", accountNumber);
        return ResponseEntity.ok(accountService.readBankAccount(accountNumber));
    }

    @GetMapping("/util-account/{account_name}")
    public ResponseEntity<UtilityAccountDto> getUtilityAccount(@PathVariable("account_name") String providerName) {
        log.info("Reading utitlity account by ID {}", providerName);
        return ResponseEntity.ok(accountService.readUtilityAccount(providerName));
    }

}
