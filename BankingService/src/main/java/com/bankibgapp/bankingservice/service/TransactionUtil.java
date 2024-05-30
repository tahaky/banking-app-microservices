package com.bankibgapp.bankingservice.service;

import com.bankibgapp.bankingservice.dto.BankAccountDTO;
import com.bankibgapp.bankingservice.model.BankAccount;

import java.math.BigDecimal;

public class TransactionUtil {

    private TransactionUtil() {

    }

    protected static void validateBalance(BankAccountDTO bankAccount, BigDecimal amount) {
        BigDecimal actualBalance = bankAccount.getActualBalance();
        if (actualBalance != null) {
            if (actualBalance.signum() < 0 ||
                    bankAccount.getActualBalance().compareTo(amount) < 0) {
                throw new RuntimeException("err");
            }

        }

    }



}
