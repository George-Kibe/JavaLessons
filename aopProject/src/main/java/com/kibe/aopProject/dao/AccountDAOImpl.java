package com.kibe.aopProject.dao;

import com.kibe.aopProject.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();
        // create sample accounts
        Account tempAccount1 = new Account("John", "Silver");
        Account tempAccount2 = new Account("Madhu", "Platinum");
        Account tempAccount3 = new Account("Lukas", "Gold");
        // add them to accounts list
        myAccounts.add(tempAccount1);
        myAccounts.add(tempAccount2);
        myAccounts.add(tempAccount3);
        return myAccounts;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass() + " Doing my DB work. Adding an Account");
    }
}
