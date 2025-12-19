package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.service.HoldingRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
public class HoldingRecordController {

    private final HoldingRecordService holdingService;

    public HoldingRecordController(
            HoldingRecordService holdingService) {
        this.holdingService = holdingService;
    }

    @PostMapping
    public HoldingRecord recordHolding(
            @RequestBody HoldingRecord holding) {
        return holdingService.recordHolding(holding);
    }

    @GetMapping("/investor/{investorId}")
    public List<HoldingRecord> getHoldingsByInvestor(
            @PathVariable Long investorId) {
        return holdingService.getHoldingsByInvestor(investorId);
    }

    @GetMapping("/{id}")
    public HoldingRecord getHoldingById(
            @PathVariable Long id) {
        return holdingService.getHoldingById(id);
    }

    @GetMapping
    public List<HoldingRecord> getAllHoldings() {
        return holdingService.getAllHoldings();
    }
}
