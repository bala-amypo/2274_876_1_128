

// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     List<HoldingRecord> findByInvestorId(Long investorId);

//     List<HoldingRecord> findByInvestorAndAssetClass(
//             Long investorId, AssetClassType assetClass);

//     // 🔥🔥🔥 THIS IS THE MISSING METHOD (MAIN ERROR)
//     List<HoldingRecord> findByValueGreaterThan(Double value);

//     Optional<HoldingRecord> findById(Long id);
// }

// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     List<HoldingRecord> findByInvestorId(Long investorId);

//     // 🔥 FIXED METHOD NAME
//     List<HoldingRecord> findByInvestorIdAndAssetClass(
//             Long investorId, AssetClassType assetClass);

//     // ✅ This is correct
//     List<HoldingRecord> findByValueGreaterThan(Double value);

//     // (Optional) JpaRepository already has this, but ok to keep
//     Optional<HoldingRecord> findById(Long id);
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

    // 🔥 FIXED METHOD NAME
    List<HoldingRecord> findByInvestorIdAndAssetClass(
            Long investorId, AssetClassType assetClass);

    // ✅ This is correct
    List<HoldingRecord> findByValueGreaterThan(Double value);

    // (Optional) JpaRepository already has this, but ok to keep
    Optional<HoldingRecord> findById(Long id);
}

