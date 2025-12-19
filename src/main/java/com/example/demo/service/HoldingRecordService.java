package com.example.demo.service;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;

import java.util.List;

public interface HoldingRecordService {

    HoldingRecord saveHolding(HoldingRecord record);

    List<HoldingRecord> getHoldingsByInvestor(Long investorId);

    List<HoldingRecord> getHoldingsAboveValue(Double value);

    List<HoldingRecord> getHoldingsByInvestorAndAsset(
            Long investorId,
            AssetClassType assetClass);
}
