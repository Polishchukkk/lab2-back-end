package org.example.lab2.service;

import org.example.lab2.model.Record;
import org.example.lab2.repository.RecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;


@Service
public class RecordService {
    private final RecordRepository recordRepository;

    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public Record createRecord(Record record) {
        record.setDateTime(LocalDateTime.now());
        return recordRepository.save(record);
    }

    public List<Record> getRecords(Long userId, Long categoryId) {
        return recordRepository.findByUserIdAndCategoryId(userId, categoryId);
    }

    public Optional<Record> getRecordById(Long recordId) {
        return recordRepository.findById(recordId);
    }

    public void deleteRecordById(Long recordId) {
        recordRepository.deleteById(recordId);
    }
}

