package org.example.lab2.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.lab2.service.AccountService;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long categoryId;

    private LocalDateTime dateTime;
    private Double amount;

    @Transient
    private AccountService accountService;

    @PrePersist
    public void prePersist() {
        Account account = accountService.getAccountByUserId(userId);

        if (account.getBalance() >= amount) {
            accountService.withdraw(userId, amount);
        } else {
            throw new RuntimeException("Insufficient funds for the expense.");
        }
    }
}
