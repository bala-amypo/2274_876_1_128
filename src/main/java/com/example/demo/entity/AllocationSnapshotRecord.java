// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "allocation_snapshot_record")
// public class AllocationSnapshotRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long investorId;

//     private LocalDateTime snapshotDate;

//     private Double totalPortfolioValue;

//     @Lob
//     private String allocationJson;

//     public AllocationSnapshotRecord() {}

//     public AllocationSnapshotRecord(Long investorId,
//                                     LocalDateTime snapshotDate,
//                                     Double totalPortfolioValue,
//                                     String allocationJson) {
//         //this.id=id;
//         this.investorId = investorId;
//         this.snapshotDate = snapshotDate;
//         this.totalPortfolioValue = totalPortfolioValue;
//         this.allocationJson = allocationJson;
//     }

//     public Long getId() { return id; }
//     public Long getInvestorId() { return investorId; }
//     public void setInvestorId(Long investorId) { this.investorId = investorId; }

//     public LocalDateTime getSnapshotDate() { return snapshotDate; }
//     public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }

//     public Double getTotalPortfolioValue() { return totalPortfolioValue; }
//     public void setTotalPortfolioValue(Double totalPortfolioValue) {
//         this.totalPortfolioValue = totalPortfolioValue;
//     }

//     public String getAllocationJson() { return allocationJson; }
//     public void setAllocationJson(String allocationJson) {
//         this.allocationJson = allocationJson;
//     }
// }

package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "allocation_snapshot_record")
public class AllocationSnapshotRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    private LocalDateTime snapshotDate;

    private Double totalPortfolioValue;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String allocationJson;

    // Default constructor (JPA-ku mandatory)
    public AllocationSnapshotRecord() {
    }

    // Parameterized constructor
    public AllocationSnapshotRecord(Long investorId,
                                    LocalDateTime snapshotDate,
                                    Double totalPortfolioValue,
                                    String allocationJson) {
        this.investorId = investorId;
        this.snapshotDate = snapshotDate;
        this.totalPortfolioValue = totalPortfolioValue;
        this.allocationJson = allocationJson;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }
    

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public LocalDateTime getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDateTime snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public Double getTotalPortfolioValue() {
        return totalPortfolioValue;
    }

    public void setTotalPortfolioValue(Double totalPortfolioValue) {
        this.totalPortfolioValue = totalPortfolioValue;
    }

    public String getAllocationJson() {
        return allocationJson;
    }

    public void setAllocationJson(String allocationJson) {
        this.allocationJson = allocationJson;
    }
}



