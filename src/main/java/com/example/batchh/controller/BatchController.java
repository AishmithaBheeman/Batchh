package com.example.batchh.controller;

import com.example.batchh.model.Batch;
import com.example.batchh.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/batches")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @GetMapping
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();
    }

    @GetMapping("/{id}")
    public Optional<Batch> getBatchById(@PathVariable Long id) {
        return batchService.getBatchById(id);
    }

    @PostMapping
    public Batch createBatch(@RequestBody Batch batch) {
        return batchService.createBatch(batch);
    }

    @PutMapping("/{id}")
    public Batch updateBatch(@PathVariable Long id, @RequestBody Batch batchDetails) {
        return batchService.updateBatch(id, batchDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
    }
}
