package com.bankingapp.fundtransferservice.repository;

import com.bankingapp.fundtransferservice.model.FundTransfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FundTransferRepository extends JpaRepository<FundTransfer, UUID> {

}
