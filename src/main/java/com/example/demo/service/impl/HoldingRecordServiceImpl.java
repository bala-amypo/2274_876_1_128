
package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.repository.HoldingRecordRepository;

@Service
public class HoldingRecordServiceImpl {

    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // 🔥 TEST EXPECTS THIS
    public HoldingRecord recordHolding(HoldingRecord record) {
        return holdingRecordRepository.save(record);
    }

    // 🔥🔥🔥 UPDATED: TEST EXPECTS Optional
    public Optional<HoldingRecord> getHoldingById(long id) {
        return holdingRecordRepository.findById(id);
    }

    // 🔥 TEST EXPECTS THIS
    public List<HoldingRecord> getHoldingsByInvestor(long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }
}

