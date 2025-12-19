package com.example.demo.service;

import com.example.demo.entity.RebalancingAlert;

import java.util.List;

public interface RebalancingAlertService {

    RebalancingAlert generateAlert(RebalancingAlert alert);

    List<RebalancingAlert> getAlertsByInvestor(Long investorId);

    List<RebalancingAlert> getTriggeredAlerts();
}
