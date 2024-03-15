package com.kibe.aopProject;

import com.kibe.aopProject.dao.AccountDAO;
import com.kibe.aopProject.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
		return runner -> {
			// System.out.println("Hello from Command Line Runner");
			// demoBeforeAdvice(accountDAO);
			demoAfterReturningAdvice(accountDAO);
		};
	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		// find accounts
		List<Account> theAccounts = accountDAO.findAccounts();
		// display the accounts
		System.out.println("\n\nMain Program: Demo After ReturningAdvice \n########\n");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoBeforeAdvice(AccountDAO accountDAO) {
		// call the business method
		accountDAO.addAccount();
	}
}
