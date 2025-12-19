package com.example.demo.controller;

import com.example.demo.entity.RebalancingAlert;
import com.example.demo.service.RebalancingAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rebalancing-alerts")
@Tag(name = "Rebalancing Alert API")
public class RebalancingAlertController {

    private final RebalancingAlertService service;

    public RebalancingAlertController(
            RebalancingAlertService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RebalancingAlert> createAlert(
            @RequestBody RebalancingAlert alert) {
        return new ResponseEntity<>(
                service.generateAlert(alert),
                HttpStatus.CREATED);
    }

    @GetMapping("/investor/{investorId}")
    public ResponseEntity<List<RebalancingAlert>> getByInvestor(
            @PathVariable Long investorId) {
        return ResponseEntity.ok(
                service.getAlertsByInvestor(investorId));
    }

    @GetMapping("/triggered")
    public ResponseEntity<List<RebalancingAlert>> getTriggeredAlerts() {
        return ResponseEntity.ok(
                service.getTriggeredAlerts());
    }
}
