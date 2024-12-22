package org.example.lab2.repository;

import org.example.lab2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUserId(Long userId);
}

