package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.AllocationSnapshotRecord;

@Repository
public interface AllocationSnapshotRecordRepository
        extends JpaRepository<AllocationSnapshotRecord, Long> {

    List<AllocationSnapshotRecord> findByInvestorId(Long investorId);
}