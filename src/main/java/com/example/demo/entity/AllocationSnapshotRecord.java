
package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private LocalDateTime snapshotDate;

    
    private Double totalValue;

    
    private String snapshotData;

    
    public AllocationSnapshotRecord() {
        this.snapshotDate = LocalDateTime.now();
        this.totalValue = 0.0;
    }

   
    public AllocationSnapshotRecord(Long investorId,
                                    LocalDateTime snapshotDate,
                                    Double totalValue,
                                    String snapshotData) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalValue = totalValue;
        this.snapshotData = snapshotData;
    }

    
    public AllocationSnapshotRecord(Long investorId, String snapshotData) {
        this.investorId = investorId;
        this.snapshotData = snapshotData;
        this.snapshotDate = LocalDateTime.now();
        this.totalValue = 0.0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public LocalDateTime getSnapshotDate() {
        return snapshotDate;
    }

    public String getSnapshotData() {
        return snapshotData;
    }

    
    public Double getTotalPortfolioValue() {
        return totalValue;
    }

    
    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}




