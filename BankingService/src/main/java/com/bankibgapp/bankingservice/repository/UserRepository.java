package com.bankibgapp.bankingservice.repository;

import com.bankibgapp.bankingservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByIdentificationNumber(String identificationNumber);
}
