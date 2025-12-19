package com.example.demo.controller;

import com.example.demo.entity.HoldingRecord;
import com.example.demo.entity.enums.AssetClassType;
import com.example.demo.service.HoldingRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@Tag(name = "Holding Record API")
public class HoldingRecordController {

    private final HoldingRecordService service;

    public HoldingRecordController(HoldingRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HoldingRecord> createHolding(
            @RequestBody HoldingRecord record) {
        return new ResponseEntity<>(
                service.saveHolding(record),
                HttpStatus.CREATED);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<HoldingRecord>> getByInvestor(
            @PathVariable Long investorId) {
        return ResponseEntity.ok(
                service.getHoldingsByInvestor(investorId));
    }

    @GetMapping("/above-value/{value}")
    public ResponseEntity<List<HoldingRecord>> getAboveValue(
            @PathVariable Double value) {
        return ResponseEntity.ok(
                service.getHoldingsAboveValue(value));
    }

    @GetMapping("/investor/{investorId}/asset/{assetClass}")
    public ResponseEntity<List<HoldingRecord>> getByInvestorAndAsset(
            @PathVariable Long investorId,
            @PathVariable AssetClassType assetClass) {
        return ResponseEntity.ok(
                service.getHoldingsByInvestorAndAsset(investorId, assetClass));
    }
}
