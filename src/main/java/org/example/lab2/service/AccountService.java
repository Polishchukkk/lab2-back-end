package org.example.lab2.service;

import org.example.lab2.model.Account;
import org.example.lab2.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account deposit(Long userId, Double amount) {
        Account account = accountRepository.findByUserId(userId);
        account.deposit(amount);
        return accountRepository.save(account);
    }

    public boolean withdraw(Long userId, Double amount) {
        Account account = accountRepository.findByUserId(userId);
        if (account.withdraw(amount)) {
            accountRepository.save(account);
            return true;
        }
        return false;
    }

    // Метод для створення нового рахунку
    public Account createAccount(Long userId) {
        // Перевіримо, чи вже є рахунок для цього користувача
        if (accountRepository.findByUserId(userId) != null) {
            throw new RuntimeException("Account already exists for this user");
        }

        // Створюємо новий рахунок
        Account newAccount = new Account();
        newAccount.setUserId(userId);
        return accountRepository.save(newAccount);
    }
}
