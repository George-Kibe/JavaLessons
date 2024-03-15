package com.kibe.bankingapp.services;

import com.kibe.bankingapp.dto.AccountDTO;
import com.kibe.bankingapp.entity.Account;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    AccountDTO depositToAccount(Long id, double amount);
}
