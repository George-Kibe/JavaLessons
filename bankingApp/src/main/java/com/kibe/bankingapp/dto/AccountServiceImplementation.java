package com.kibe.bankingapp.dto;

import com.kibe.bankingapp.entity.Account;
import com.kibe.bankingapp.mapper.AccountMapper;
import com.kibe.bankingapp.repository.AccountRepository;
import com.kibe.bankingapp.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImplementation implements AccountService {
    private AccountRepository accountRepository;

    public AccountServiceImplementation(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = AccountMapper.mapToAccount(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElse(null);
                                //.orElseThrow(() -> new RuntimeException("Account does not exist));
        if (account != null){
            return AccountMapper.mapToAccountDTO(account);
        }
        return null;
    }

    @Override
    public AccountDTO depositToAccount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null){
            double total = account.getBalance() + amount;
            account.setBalance(total);
            Account savedAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDTO(savedAccount);
        }
        return null;
    }
}
