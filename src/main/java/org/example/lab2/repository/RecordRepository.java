package org.example.lab2.repository;

import org.example.lab2.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findByUserIdAndCategoryId(Long userId, Long categoryId);
}
