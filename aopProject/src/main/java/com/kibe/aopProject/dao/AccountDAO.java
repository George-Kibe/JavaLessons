package com.kibe.aopProject.dao;

import com.kibe.aopProject.entity.Account;

import java.util.List;

public interface AccountDAO {
    // add a new method : findAccounts(
    List<Account> findAccounts();
    void addAccount();
}
