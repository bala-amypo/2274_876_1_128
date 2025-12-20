package com.example.demo.controller;

import com.example.demo.entity.AllocationSnapshotRecord;
import com.example.demo.service.AllocationSnapshotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/snapshots")
public class AllocationSnapshotController {

    private final AllocationSnapshotService snapshotService;

    public AllocationSnapshotController(AllocationSnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    @PostMapping("/compute/{investorId}")
    public AllocationSnapshotRecord compute(@PathVariable Long investorId) {
        return snapshotService.computeSnapshot(investorId);
    }

    @GetMapping("/investor/{investorId}")
    public List<AllocationSnapshotRecord> byInvestor(
            @PathVariable Long investorId) {
        return snapshotService.getSnapshotsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public AllocationSnapshotRecord byId(@PathVariable Long id) {
        return snapshotService.getSnapshotById(id);
    }

    @GetMapping
    public List<AllocationSnapshotRecord> all() {
        return snapshotService.getAllSnapshots();
    }
}
