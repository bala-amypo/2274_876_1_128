package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.service.RebalancingAlertService;

@RestController
@RequestMapping("/api/alerts")
public class RebalancingAlertController {

    private final RebalancingAlertService alertService;

    public RebalancingAlertController(RebalancingAlertService alertService) {
        this.alertService = alertService;
    }

    // Create alert
    @PostMapping
    public RebalancingAlertRecord createAlert(
            @RequestBody RebalancingAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    // Resolve alert
    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    // Get alerts by investor
    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getAlertsByInvestor(
            @PathVariable Long investorId) {
        return alertService.getAlertsByInvestor(investorId);
    }

    // Get alert by id
    @GetMapping("/{id}")
    public RebalancingAlertRecord getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    // Get all alerts
    @GetMapping
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
