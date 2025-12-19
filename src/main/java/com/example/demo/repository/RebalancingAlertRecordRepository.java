package com.example.demo.repository;

import com.example.demo.entity.RebalancingAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RebalancingAlertRepository
        extends JpaRepository<RebalancingAlert, Long> {

    List<RebalancingAlert> findByInvestorId(Long investorId);

    List<RebalancingAlert> findByAlertTriggeredTrue();
}
