package com.kibe.bankingapp.repository;

import com.kibe.bankingapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
