// package com.example.demo.repository;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import java.util.List;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     List<HoldingRecord> findByInvestorId(Long investorId);

//     @Query("SELECT h FROM HoldingRecord h WHERE h.currentValue > :amount")
//     List<HoldingRecord> findHoldingsWithValueGreaterThan(
//             @Param("amount") Double amount);

//     @Query("SELECT h FROM HoldingRecord h WHERE h.investorId = :investorId AND h.assetClass = :assetClass")
//     List<HoldingRecord> findByInvestorAndAssetClass(
//             @Param("investorId") Long investorId,
//             @Param("assetClass") AssetClassType assetClass);
// }




// package com.example.demo.repository;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;

// import java.util.List;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     List<HoldingRecord> findByInvestorId(Long investorId);

//     // FIXED: currentValue → value
//     @Query("SELECT h FROM HoldingRecord h WHERE h.value > :amount")
//     List<HoldingRecord> findHoldingsWithValueGreaterThan(
//             @Param("amount") Double amount);

//     @Query("SELECT h FROM HoldingRecord h WHERE h.investorId = :investorId AND h.assetClass = :assetClass")
//     List<HoldingRecord> findByInvestorAndAssetClass(
//             @Param("investorId") Long investorId,
//             @Param("assetClass") AssetClassType assetClass);
// }



package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;

public interface HoldingRecordRepository
        extends JpaRepository<HoldingRecord, Long> {

    List<HoldingRecord> findByInvestorId(Long investorId);

    List<HoldingRecord> findByInvestorAndAssetClass(
            Long investorId, AssetClassType assetClass);

    // 🔥🔥🔥 THIS IS THE MISSING METHOD (MAIN ERROR)
    List<HoldingRecord> findByValueGreaterThan(Double value);

    Optional<HoldingRecord> findById(Long id);
}
