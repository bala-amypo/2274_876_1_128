
// package com.example.demo.service.impl;

// import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

// import com.example.demo.entity.AllocationSnapshotRecord;
// import com.example.demo.entity.HoldingRecord;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AllocationSnapshotRecordRepository;
// import com.example.demo.repository.HoldingRecordRepository;
// import com.example.demo.service.AllocationSnapshotService;

// @Service
// public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

//     private HoldingRecordRepository holdingRepo;
//     private AllocationSnapshotRecordRepository snapshotRepo;

    
//     @Autowired
//     public AllocationSnapshotServiceImpl(
//             HoldingRecordRepository holdingRepo,
//             AllocationSnapshotRecordRepository snapshotRepo) {

//         this.holdingRepo = holdingRepo;
//         this.snapshotRepo = snapshotRepo;
//     }

    
//     public AllocationSnapshotServiceImpl(Object... args) {

//         for (Object arg : args) {
//             if (arg instanceof HoldingRecordRepository) {
//                 this.holdingRepo = (HoldingRecordRepository) arg;
//             }
//             if (arg instanceof AllocationSnapshotRecordRepository) {
//                 this.snapshotRepo = (AllocationSnapshotRecordRepository) arg;
//             }
//         }
//     }

    
//     @Override
//     public AllocationSnapshotRecord computeSnapshot(Long investorId) {

//         List<HoldingRecord> holdings =
//                 holdingRepo.findByInvestorId(investorId);

//         if (holdings == null || holdings.isEmpty()) {
//             throw new IllegalArgumentException("No holdings");
//         }

//         Map<String, Double> snapshotMap =
//                 holdings.stream()
//                         .collect(Collectors.groupingBy(
//                                 h -> h.getAssetClass().name(),
//                                 Collectors.summingDouble(HoldingRecord::getValue)
//                         ));

//         double totalValue =
//                 holdings.stream()
//                         .mapToDouble(HoldingRecord::getValue)
//                         .sum();

//         AllocationSnapshotRecord record =
//                 new AllocationSnapshotRecord(
//                         investorId,
//                         snapshotMap.toString()
//                 );

//         record.setTotalValue(totalValue);
//         return snapshotRepo.save(record);
//     }

//     @Override
//     public AllocationSnapshotRecord getSnapshotById(Long id) {
//         return snapshotRepo.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Snapshot not found"));
//     }

//     @Override
//     public List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId) {
//         return snapshotRepo.findByInvestorId(investorId);
//     }

//     @Override
//     public List<AllocationSnapshotRecord> getAllSnapshots() {
//         return snapshotRepo.findAll();
//     }
// }





package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.repository.AllocationSnapshotRecordRepository;
import com.example.demo.service.AllocationSnapshotService;

@Service
public class AllocationSnapshotServiceImpl implements AllocationSnapshotService {

    private final AllocationSnapshotRecordRepository snapshotRepo;

    public AllocationSnapshotServiceImpl(
            AllocationSnapshotRecordRepository snapshotRepo) {
        this.snapshotRepo = snapshotRepo;
    }

    @Override
    public AllocationSnapshotRecord getSnapshotById(Long id) {
        if (!snapshotRepo.findById(id).isPresent()) {
            throw new RuntimeException("Snapshot not found");
        }
        return snapshotRepo.findById(id).get();
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

