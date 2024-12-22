package org.example.lab2.controller;

import org.example.lab2.model.Record;
import org.example.lab2.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    // Отримати всі записи
    @GetMapping
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    // Отримати запис за ID
    @GetMapping("/{id}")
    public Record getRecordById(@PathVariable Long id) {
        return recordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    // Створити новий запис
    @PostMapping
    public Record createRecord(@RequestBody Record record) {
        return recordRepository.save(record);
    }

    // Оновити існуючий запис
    @PutMapping("/{id}")
    public Record updateRecord(@PathVariable Long id, @RequestBody Record updatedRecord) {
        return recordRepository.findById(id)
                .map(record -> {
                    record.setUserId(updatedRecord.getUserId());
                    record.setCategoryId(updatedRecord.getCategoryId());
                    record.setDateTime(updatedRecord.getDateTime());
                    record.setAmount(updatedRecord.getAmount());
                    return recordRepository.save(record);
                })
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }

    // Видалити запис
    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        recordRepository.deleteById(id);
        return "Record deleted successfully";
    }
}
