package org.example.lab2.controller;

import org.example.lab2.model.Record;
import org.example.lab2.service.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record createdRecord = recordService.createRecord(record);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    }

    @GetMapping
    public ResponseEntity<List<Record>> getRecords(@RequestParam(required = false) Long userId,
                                                   @RequestParam(required = false) Long categoryId) {
        if (userId == null && categoryId == null) {
            return ResponseEntity.badRequest().build();
        }

        List<Record> records = recordService.getRecords(userId, categoryId);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<Record> getRecord(@PathVariable Long recordId) {
        return recordService.getRecordById(recordId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        recordService.deleteRecordById(recordId);
        return ResponseEntity.noContent().build();
    }
}
