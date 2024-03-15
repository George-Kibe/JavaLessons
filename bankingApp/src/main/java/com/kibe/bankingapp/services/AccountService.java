package com.kibe.bankingapp.services;

import com.kibe.bankingapp.dto.AccountDTO;
import com.kibe.bankingapp.entity.Account;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    AccountDTO depositToAccount(Long id, double amount);
    AccountDTO withdrawFromAccount(Long id, double amount);
    List<AccountDTO> getAllAccounts();
    boolean deleteAccount(Long id);
}
