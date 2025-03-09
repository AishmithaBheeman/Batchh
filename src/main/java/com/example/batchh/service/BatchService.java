package com.example.batchh.service;

import com.example.batchh.model.Batch;
import com.example.batchh.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    private BatchRepository batchRepository;

    public List<Batch> getAllBatches() {
        return batchRepository.findAll();
    }

    public Optional<Batch> getBatchById(Long id) {
        return batchRepository.findById(id);
    }

    public Batch createBatch(Batch batch) {
        return batchRepository.save(batch);
    }

    public Batch updateBatch(Long id, Batch batchDetails) {
        return batchRepository.findById(id).map(batch -> {
            batch.setBatchName(batchDetails.getBatchName());
            batch.setDepartmentId(batchDetails.getDepartmentId());
            batch.setCollegeId(batchDetails.getCollegeId());
            batch.setStartYear(batchDetails.getStartYear());
            batch.setEndYear(batchDetails.getEndYear());
            batch.setIsActive(batchDetails.getIsActive());
            return batchRepository.save(batch);
        }).orElseThrow(() -> new RuntimeException("Batch not found with id " + id));
    }

    public void deleteBatch(Long id) {
        batchRepository.deleteById(id);
    }
}

