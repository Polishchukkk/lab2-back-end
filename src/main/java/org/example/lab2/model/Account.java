package org.example.lab2.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double balance = 0.0;

    public void deposit(Double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public boolean withdraw(Double amount) {
        if (amount <= balance) {
            this.balance -= amount;
            return true;
        }
        return false; // не вистачає коштів
    }
}
