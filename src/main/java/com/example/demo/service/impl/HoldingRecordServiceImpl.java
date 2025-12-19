package com.example.demo.service.impl;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository holdingRepository;

    public HoldingRecordServiceImpl(
            HoldingRecordRepository holdingRepository) {
        this.holdingRepository = holdingRepository;
    }

    @Override
    public HoldingRecord recordHolding(HoldingRecord holding) {

        
        holding.setSnapshotDate(LocalDateTime.now());
        return holdingRepository.save(holding);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRepository.findByInvestorId(investorId);
    }

    @Override
    public HoldingRecord getHoldingById(Long id) {
        return holdingRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Holding not found"));
    }

    @Override
    public List<HoldingRecord> getAllHoldings() {
        return holdingRepository.findAll();
    }
}
