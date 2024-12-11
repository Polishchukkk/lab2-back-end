package org.example.lab2.service;

import org.example.lab2.model.Record;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordService {
    private final List<Record> records = new ArrayList<>();

    public Record createRecord(Record record) {
        record.setId((long) (records.size() + 1));
        record.setDateTime(LocalDateTime.now());
        records.add(record);
        return record;
    }

    public List<Record> getRecords(Long userId, Long categoryId) {
        return records.stream()
                .filter(record -> (userId == null || record.getUserId().equals(userId)) &&
                        (categoryId == null || record.getCategoryId().equals(categoryId)))
                .collect(Collectors.toList());
    }

    public Optional<Record> getRecordById(Long recordId) {
        return records.stream().filter(record -> record.getId().equals(recordId)).findFirst();
    }

    public void deleteRecordById(Long recordId) {
        records.removeIf(record -> record.getId().equals(recordId));
    }
}
