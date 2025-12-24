

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

// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     // Used by services
//     List<HoldingRecord> findByInvestorId(Long investorId);

//     // Used by services (Spring style)
//     List<HoldingRecord> findByInvestorIdAndAssetClass(
//             Long investorId,
//             AssetClassType assetClass
//     );

//     // 🔥 REQUIRED BY TEST CASES (ALIAS)
//     List<HoldingRecord> findByInvestorAndAssetClass(
//             Long investorId,
//             AssetClassType assetClass
//     );

//     // Used by value filter test
//     List<HoldingRecord> findByValueGreaterThan(Double value);
// }


// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.entity.enums.AssetClassType;

// public interface HoldingRecordRepository
//         extends JpaRepository<HoldingRecord, Long> {

//     // ===== BASIC QUERIES =====

//     // Used by Swagger + Service
//     List<HoldingRecord> findByInvestorId(Long investorId);

//     // Used by Swagger (new naming)
//     List<HoldingRecord> findByInvestorIdAndAssetClass(
//             Long investorId,
//             AssetClassType assetClass);

//     // ===== TEST COMPATIBILITY (DO NOT REMOVE) =====

//     // Used by test cases (old naming)
//     List<HoldingRecord> findByInvestorAndAssetClass(
//             Long investorId,
//             AssetClassType assetClass);

//     // Used by test case: getHoldingsAboveValue
//     List<HoldingRecord> findByValueGreaterThan(Double value);

//     // JpaRepository already has this, but test expects it explicitly
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

    // Used by Swagger + Service
    List<HoldingRecord> findByInvestorId(Long investorId);

    // ✅ ENTITY FIELD MATCHES (CORRECT)
    List<HoldingRecord> findByInvestorIdAndAssetClass(
            Long investorId,
            AssetClassType assetClass);

    // Used by test case: getHoldingsAboveValue
    List<HoldingRecord> findByValueGreaterThan(Double value);

    // JpaRepository already has this, but test expects it explicitly
    Optional<HoldingRecord> findById(Long id);
}
