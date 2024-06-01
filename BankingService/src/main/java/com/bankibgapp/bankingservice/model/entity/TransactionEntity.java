package com.bankibgapp.bankingservice.model.entity;


import com.bankibgapp.bankingservice.model.TransactionType;
import com.bankibgapp.bankingservice.model.builder.ITransactionBuilder;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@Getter
@Setter
@Builder
@Entity
@Table(name = "banking_transaction")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String referenceNumber;
    private String transactionId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private BankAccount account;

}
