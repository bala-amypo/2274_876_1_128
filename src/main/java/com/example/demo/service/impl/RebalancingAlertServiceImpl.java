package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RebalancingAlertRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RebalancingAlertRecordRepository;
import com.example.demo.service.RebalancingAlertService;

@Service
public class RebalancingAlertServiceImpl implements RebalancingAlertService {

    private final RebalancingAlertRecordRepository alertRepo;

    public RebalancingAlertServiceImpl(RebalancingAlertRecordRepository alertRepo) {
        this.alertRepo = alertRepo;
    }

    @Override
    public RebalancingAlertRecord createAlert(RebalancingAlertRecord alert) {

        if (alert.getCurrentPercentage() <= alert.getTargetPercentage()) {
            throw new IllegalArgumentException(
                "currentPercentage > targetPercentage");
        }

        alert.setResolved(false);
        alert.setAlertDate(LocalDateTime.now());

        return alertRepo.save(alert);
    }

    @Override
    public RebalancingAlertRecord resolveAlert(Long id) {

        RebalancingAlertRecord alert = alertRepo.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Alert not found"));

        alert.setResolved(true);
        return alertRepo.save(alert);
    }

    @Override
    public List<RebalancingAlertRecord> getAlertsByInvestor(Long investorId) {
        return alertRepo.findByInvestorId(investorId);
    }

    @Override
    public RebalancingAlertRecord getAlertById(Long id) {
        return alertRepo.findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Alert not found"));
    }

    @Override
    public List<RebalancingAlertRecord> getAllAlerts() {
        return alertRepo.findAll();
    }
}
