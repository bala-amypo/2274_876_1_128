// package com.example.demo.repository;

// import com.example.demo.entity.AllocationSnapshotRecord;
// import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

// public interface AllocationSnapshotRecordRepository
//         extends JpaRepository<AllocationSnapshotRecord, Long> {

//     List<AllocationSnapshotRecord> findByInvestorId(Long investorId);
// }


package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.AllocationSnapshotRecord;

public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshotRecord, Long> {
}
