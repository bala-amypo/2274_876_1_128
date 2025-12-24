
// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.entity.AllocationSnapshotRecord;

// public interface AllocationSnapshotRecordRepository
//         extends JpaRepository<AllocationSnapshotRecord, Long> {
// }


// package com.example.demo.repository;

// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// import com.example.demo.entity.AllocationSnapshotRecord;

// public interface AllocationSnapshotRecordRepository
//         extends JpaRepository<AllocationSnapshotRecord, Long> {

//     // 🔥 REQUIRED BY SERVICE & CONTROLLER
//     List<AllocationSnapshotRecord> findByInvestorId(Long investorId);
// }

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.demo.entity.AllocationSnapshotRecord;

public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshotRecord, Long> {

    // 🔥 REQUIRED BY SERVICE & CONTROLLER
    List<AllocationSnapshotRecord> findByInvestorId(Long investorId);
}
