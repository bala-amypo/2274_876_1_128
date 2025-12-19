package com.example.demo.repository;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HoldingRecordRepository
        extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestorId(Long investorId);

    @Query("SELECT h FROM HoldingRecord h WHERE h.currentValue > :amount")
    List<HoldingRecord> findHoldingsWithValueGreaterThan(
            @Param("amount") Double amount);

    @Query("SELECT h FROM HoldingRecord h WHERE h.investorId = :investorId AND h.assetClass = :assetClass")
    List<HoldingRecord> findByInvestorAndAssetClass(
            @Param("investorId") Long investorId,
            @Param("assetClass") AssetClassType assetClass);
}
