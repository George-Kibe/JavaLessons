package com.kibe.bankingapp.controllers;

import com.kibe.bankingapp.dto.AccountDTO;
import com.kibe.bankingapp.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // create an account API
    @PostMapping()
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public  ResponseEntity<AccountDTO> getAccountById(@PathVariable long id){
        AccountDTO accountDTO = accountService.getAccountById(id);
        if (accountDTO != null){
            return ResponseEntity.ok(accountDTO);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // deposit REST API
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> depositAmount(@PathVariable  Long id,
                                                    @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        if(amount <= 0 || id == null){
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        AccountDTO accountDTO = accountService.depositToAccount(id, amount);
        if(accountDTO != null){
            return ResponseEntity.ok(accountDTO);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
