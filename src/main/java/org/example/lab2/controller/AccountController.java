package org.example.lab2.controller;

import org.example.lab2.model.Account;
import org.example.lab2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{userId}")
    public Account getAccountByUserId(@PathVariable Long userId) {
        return accountService.getAccountByUserId(userId);
    }

    @PostMapping("/{userId}/deposit")
    public Account deposit(@PathVariable Long userId, @RequestParam Double amount) {
        return accountService.deposit(userId, amount);
    }

    @PostMapping("/{userId}/withdraw")
    public String withdraw(@PathVariable Long userId, @RequestParam Double amount) {
        boolean success = accountService.withdraw(userId, amount);
        return success ? "Withdrawal successful" : "Insufficient funds";
    }

    @PostMapping("/{userId}/create")
    public Account createAccount(@PathVariable Long userId) {
        return accountService.createAccount(userId);
    }
}
