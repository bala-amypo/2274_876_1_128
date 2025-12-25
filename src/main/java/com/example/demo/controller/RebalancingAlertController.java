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

    
    @PostMapping
    public RebalancingAlertRecord createAlert(
            @RequestBody RebalancingAlertRecord alert) {
        return alertService.createAlert(alert);
    }

    
    @PutMapping("/{id}/resolve")
    public RebalancingAlertRecord resolveAlert(@PathVariable Long id) {
        return alertService.resolveAlert(id);
    }

    
    @GetMapping("/investor/{investorId}")
    public List<RebalancingAlertRecord> getAlertsByInvestor(
            @PathVariable Long investorId) {
        return alertService.getAlertsByInvestor(investorId);
    }

    
    @GetMapping("/{id}")
    public RebalancingAlertRecord getAlertById(@PathVariable Long id) {
        return alertService.getAlertById(id);
    }

    
    @GetMapping
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertService.getAllAlerts();
    }
}
