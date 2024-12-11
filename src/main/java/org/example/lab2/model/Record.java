package org.example.lab2.model;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    private Long id;
    private Long userId;
    private Long categoryId;
    private LocalDateTime dateTime;
    private Double amount;
}