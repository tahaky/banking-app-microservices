package com.bankibgapp.bankingservice.util;

import com.bankibgapp.bankingservice.model.dto.BankAccountDTO;
import com.bankibgapp.bankingservice.model.entity.BankAccount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransactionUtil {

    public void validateBalance(BankAccountDTO bankAccount, BigDecimal amount) {
        BigDecimal actualBalance = bankAccount.getActualBalance();
        if (actualBalance != null) {
            if (actualBalance.signum() < 0 ||
                    bankAccount.getActualBalance().compareTo(amount) < 0) {
                throw new RuntimeException("err");
            }

        }

    }

    public BankAccount setAccountBalances(BankAccount bankAccount, BigDecimal amount) {
        BigDecimal actualBalance = bankAccount.getActualBalance();
        bankAccount.setActualBalance(actualBalance.subtract(amount));
        bankAccount.setAvailableBalance(actualBalance.subtract(amount));
        return bankAccount;
    }


}
