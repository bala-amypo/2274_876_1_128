
package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;

@Service
public class HoldingRecordServiceImpl implements HoldingRecordService {

    private final HoldingRecordRepository repo;

    public HoldingRecordServiceImpl(HoldingRecordRepository repo) {
        this.repo = repo;
    }

    
    @Override
    public HoldingRecord saveHolding(HoldingRecord record) {

       if (record.getValue() == null || record.getValue() <= 0) {
    throw new IllegalArgumentException("Invalid holding value");
}

        return repo.save(record);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return repo.findByInvestorId(investorId);
    }

    @Override
    public List<HoldingRecord> getHoldingsAboveValue(Double value) {
        return repo.findByValueGreaterThan(value);
    }

    @Override
    public List<HoldingRecord> getHoldingsByInvestorAndAsset(
            Long investorId,
            AssetClassType assetClass) {
        return repo.findByInvestorIdAndAssetClass(investorId, assetClass);
    }

    
    public Optional<HoldingRecord> getHoldingById(Long id) {
        return repo.findById(id);
    }

    
    public HoldingRecord recordHolding(HoldingRecord record) {
        return saveHolding(record);
    }
}




