package com.kibe.bankingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor

@Data // helps in generating constructors, getters and setters
public class AccountDTO {
    private Long id;
    private String accountHolderName;
    private double balance;
}
