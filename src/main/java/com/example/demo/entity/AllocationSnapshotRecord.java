
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

    // 🔥 total portfolio value
    private Double totalValue;

    // snapshot data (map as string)
    private String snapshotData;

    // JPA default constructor
    public AllocationSnapshotRecord() {
        this.snapshotDate = LocalDateTime.now();
        this.totalValue = 0.0;
    }

    // Existing constructor
    public AllocationSnapshotRecord(Long investorId,
                                    LocalDateTime snapshotDate,
                                    Double totalValue,
                                    String snapshotData) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalValue = totalValue;
        this.snapshotData = snapshotData;
    }

    // Constructor used by service
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

    /* =====================================================
       🔥🔥🔥 THIS IS THE MISSING METHOD (MAIN FIX)
       ===================================================== */
    public Double getTotalPortfolioValue() {
        return totalValue;
    }

    // keep normal getter also (safe)
    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}




