package com.bankibgapp.bankingservice.model.entity;

import com.bankibgapp.bankingservice.model.AccountStatus;
import com.bankibgapp.bankingservice.model.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "banking_account")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String bankingNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
