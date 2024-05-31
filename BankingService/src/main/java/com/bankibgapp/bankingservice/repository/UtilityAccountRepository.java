package com.bankibgapp.bankingservice.repository;

import com.bankibgapp.bankingservice.model.entity.UtilityAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UtilityAccountRepository extends JpaRepository<UtilityAccount, UUID> {
    Optional<UtilityAccount> findByProviderName(String provider);

}
