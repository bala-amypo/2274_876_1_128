
// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.repository.HoldingRecordRepository;

// @Service
// public class HoldingRecordServiceImpl {

//     private final HoldingRecordRepository holdingRecordRepository;

//     public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
//         this.holdingRecordRepository = holdingRecordRepository;
//     }

//     // 🔥 TEST EXPECTS THIS
//     public HoldingRecord recordHolding(HoldingRecord record) {
//         return holdingRecordRepository.save(record);
//     }

//     // 🔥🔥🔥 UPDATED: TEST EXPECTS Optional
//     public Optional<HoldingRecord> getHoldingById(long id) {
//         return holdingRecordRepository.findById(id);
//     }

//     // 🔥 TEST EXPECTS THIS
//     public List<HoldingRecord> getHoldingsByInvestor(long investorId) {
//         return holdingRecordRepository.findByInvestorId(investorId);
//     }
// }



// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.repository.HoldingRecordRepository;

// @Service
// public class HoldingRecordServiceImpl {

//     private final HoldingRecordRepository holdingRecordRepository;

//     public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
//         this.holdingRecordRepository = holdingRecordRepository;
//     }

//     // 🔥 FIX: INVALID VALUE VALIDATION (TEST EXPECTS THIS)
//     public HoldingRecord recordHolding(HoldingRecord record) {

//         if (record.getCurrentValue() == null || record.getCurrentValue() <= 0) {
//             throw new IllegalArgumentException("Holding value must be greater than zero");
//         }

//         return holdingRecordRepository.save(record);
//     }

//     // 🔥 TEST EXPECTS Optional
//     public Optional<HoldingRecord> getHoldingById(long id) {
//         return holdingRecordRepository.findById(id);
//     }

//     // 🔥 TEST EXPECTS THIS
//     public List<HoldingRecord> getHoldingsByInvestor(long investorId) {
//         return holdingRecordRepository.findByInvestorId(investorId);
//     }
// }

// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import java.util.List;
// import java.util.Optional;

// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.repository.HoldingRecordRepository;
// import com.example.demo.service.HoldingRecordService;

// @Service
// public class HoldingRecordServiceImpl
//         implements HoldingRecordService {

//     private final HoldingRecordRepository holdingRecordRepository;

//     public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
//         this.holdingRecordRepository = holdingRecordRepository;
//     }

//     // 🔥 VALIDATION FIXED (uses getValue)
//     @Override
//     public HoldingRecord recordHolding(HoldingRecord record) {

//         if (record.getValue() == null || record.getValue() <= 0) {
//             throw new IllegalArgumentException(
//                     "Holding value must be greater than zero");
//         }

//         return holdingRecordRepository.save(record);
//     }

//     // 🔥 Long (not long)
//     @Override
//     public Optional<HoldingRecord> getHoldingById(Long id) {
//         return holdingRecordRepository.findById(id);
//     }

//     // 🔥 Long (not long)
//     @Override
//     public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
//         return holdingRecordRepository.findByInvestorId(investorId);
//     }
// }

package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.repository.HoldingRecordRepository;
import com.example.demo.service.HoldingRecordService;

@Service
public class HoldingRecordServiceImpl
        implements HoldingRecordService {

    private final HoldingRecordRepository holdingRecordRepository;

    public HoldingRecordServiceImpl(HoldingRecordRepository holdingRecordRepository) {
        this.holdingRecordRepository = holdingRecordRepository;
    }

    // ✅ INTERFACE METHOD 1 (NAME FIXED)
    @Override
    public HoldingRecord saveHolding(HoldingRecord record) {

        if (record.getValue() == null || record.getValue() <= 0) {
            throw new IllegalArgumentException(
                    "Holding value must be greater than zero");
        }

        return holdingRecordRepository.save(record);
    }

    // ✅ INTERFACE METHOD 2
    @Override
    public List<HoldingRecord> getHoldingsByInvestor(Long investorId) {
        return holdingRecordRepository.findByInvestorId(investorId);
    }

    // ✅ INTERFACE METHOD 3
    @Override
    public List<HoldingRecord> getHoldingsAboveValue(Double value) {
        return holdingRecordRepository.findByValueGreaterThan(value);
    }

    // ✅ INTERFACE METHOD 4
    @Override
    public List<HoldingRecord> getHoldingsByInvestorAndAsset(
            Long investorId,
            AssetClassType assetClass) {

        return holdingRecordRepository
                .findByInvestorAndAssetClass(investorId, assetClass);
    }
}
