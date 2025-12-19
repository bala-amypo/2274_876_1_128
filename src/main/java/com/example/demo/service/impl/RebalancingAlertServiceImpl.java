package com.example.demo.service.impl;

import com.example.demo.entity.RebalancingAlert;
import com.example.demo.repository.RebalancingAlertRepository;
import com.example.demo.service.RebalancingAlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RebalancingAlertServiceImpl
        implements RebalancingAlertService {

    private final RebalancingAlertRepository repository;

    public RebalancingAlertServiceImpl(
            RebalancingAlertRepository repository) {
        this.repository = repository;
    }

    @Override
    public RebalancingAlert generateAlert(RebalancingAlert alert) {

        double deviation = Math.abs(
                alert.getCurrentPercentage()
                        - alert.getTargetPercentage());

        alert.setDeviation(deviation);

        // PDF CONDITION
        if (deviation > 5.0) {
            alert.setAlertTriggered(true);
        } else {
            alert.setAlertTriggered(false);
        }

        return repository.save(alert);
    }

    @Override
    public List<RebalancingAlert> getAlertsByInvestor(Long investorId) {
        return repository.findByInvestorId(investorId);
    }

    @Override
    public List<RebalancingAlert> getTriggeredAlerts() {
        return repository.findByAlertTriggeredTrue();
    }
}
