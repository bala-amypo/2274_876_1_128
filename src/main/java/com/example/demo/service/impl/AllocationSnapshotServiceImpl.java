

package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.AllocationSnapshotService;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private HoldingRecordRepository holdingRepo;
    private AllocationSnapshotRecordRepository snapshotRepo;

    @Autowired
    public AllocationSnapshotServiceImpl(
            HoldingRecordRepository holdingRepo,
            AllocationSnapshotRecordRepository snapshotRepo) {

        this.holdingRepo = holdingRepo;
        this.snapshotRepo = snapshotRepo;
    }

    // used by tests
    public AllocationSnapshotServiceImpl(Object... args) {
        for (Object arg : args) {
            if (arg instanceof HoldingRecordRepository) {
                this.holdingRepo = (HoldingRecordRepository) arg;
            }
            if (arg instanceof AllocationSnapshotRecordRepository) {
                this.snapshotRepo = (AllocationSnapshotRecordRepository) arg;
            }
        }
    }

    @Override
    public AllocationSnapshotRecord computeSnapshot(Long investorId) {

        List<HoldingRecord> holdings =
                holdingRepo.findByInvestorId(investorId);

        if (holdings == null || holdings.isEmpty()) {
            throw new IllegalArgumentException("No holdings");
        }

        Map<String, Double> snapshotMap =
                holdings.stream()
                        .collect(Collectors.groupingBy(
                                h -> h.getAssetClass().name(),
                                Collectors.summingDouble(HoldingRecord::getCurrentValue)
                        ));

        double totalValue =
                holdings.stream()
                        .mapToDouble(HoldingRecord::getCurrentValue)
                        .sum();

        AllocationSnapshotRecord record =
                new AllocationSnapshotRecord(
                        investorId,
                        snapshotMap.toString()
                );

        
        record.setTotalValue(totalValue);

        return snapshotRepo.save(record);
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        return snapshotRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Snapshot not found with id " + id
                ));
    }

    @Override
    public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
        return snapshotRepo.findByInvestorId(investorId);
    }

    @Override
    public List<AllocationSnapshotRecord> getAllSnapshots() {
        return snapshotRepo.findAll();
    }
}
