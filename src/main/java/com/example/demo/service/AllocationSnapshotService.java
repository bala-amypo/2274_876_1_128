package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AllocationSnapshotRecord;

public interface AllocationSnapshotService {

    AllocationSnapshotRecord computeSnapshot(Long investorId);

    AllocationSnapshotRecord getSnapshotById(Long id);

    List<AllocationSnapshotRecord> getSnapshotsByInvestor(Long investorId);

    List<AllocationSnapshotRecord> getAllSnapshots();
}