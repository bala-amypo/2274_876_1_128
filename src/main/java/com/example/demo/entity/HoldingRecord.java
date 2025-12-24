// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import com.example.demo.entity.enums.AssetClassType;

// @Entity
// public class HoldingRecord {

//     @Id
//     //@GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long investorId;

//     @Enumerated(EnumType.STRING)
//     private AssetClassType assetClass;

//     private Double currentValue;

//     private LocalDateTime snapshotDate;

    
//     public HoldingRecord() {
        
//     }


    
//     public HoldingRecord(Long id, Long investorId,
//                          AssetClassType assetClass,
//                          Double currentValue,
//                          LocalDateTime snapshotDate) {
//         this.id = id;
//         this.investorId = investorId;
//         this.assetClass = assetClass;
//         this.currentValue = currentValue;
//         this.snapshotDate = snapshotDate;
//     }


    
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public Long getInvestorId() { return investorId; }
//     public void setInvestorId(Long investorId) { this.investorId = investorId; }

//     public AssetClassType getAssetClass() { return assetClass; }
//     public void setAssetClass(AssetClassType assetClass) { this.assetClass = assetClass; }

//     public Double getCurrentValue() { return currentValue; }
//     public void setCurrentValue(Double currentValue) { this.currentValue = currentValue; }

//     public LocalDateTime getSnapshotDate() { return snapshotDate; }
//     public void setSnapshotDate(LocalDateTime snapshotDate) { this.snapshotDate = snapshotDate; }
// }




// package com.example.demo.entity;

// import jakarta.persistence.*;
// import com.example.demo.entity.enums.AssetClassType;

// @Entity
// public class HoldingRecord {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long investorId;

//     @Enumerated(EnumType.STRING)
//     private AssetClassType assetClass;

//     private String assetName;

//     private Integer quantity;

//     private Double value;

//     // Default constructor
//     public HoldingRecord() {
//     }

//     // Parameterized constructor
//     public HoldingRecord(Long investorId,
//                          AssetClassType assetClass,
//                          String assetName,
//                          Integer quantity,
//                          Double value) {
//         this.investorId = investorId;
//         this.assetClass = assetClass;
//         this.assetName = assetName;
//         this.quantity = quantity;
//         this.value = value;
//     }

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getInvestorId() {
//         return investorId;
//     }

//     public void setInvestorId(Long investorId) {
//         this.investorId = investorId;
//     }

//     public AssetClassType getAssetClass() {
//         return assetClass;
//     }

//     public void setAssetClass(AssetClassType assetClass) {
//         this.assetClass = assetClass;
//     }

//     public String getAssetName() {
//         return assetName;
//     }

//     public void setAssetName(String assetName) {
//         this.assetName = assetName;
//     }

//     public Integer getQuantity() {
//         return quantity;
//     }

//     public void setQuantity(Integer quantity) {
//         this.quantity = quantity;
//     }

//     public Double getValue() {
//         return value;
//     }

//     public void setValue(Double value) {
//         this.value = value;
//     }
// }


package com.example.demo.entity;

import jakarta.persistence.*;
import com.example.demo.entity.enums.AssetClassType;
import java.time.LocalDateTime;

@Entity
public class HoldingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long investorId;

    @Enumerated(EnumType.STRING)
    private AssetClassType assetClass;

    // 🔥 TEST EXPECTS FIELD NAME = value
    private Double value;

    private LocalDateTime createdAt;

    public HoldingRecord() {
        this.createdAt = LocalDateTime.now();
    }

    public HoldingRecord(Long investorId,
                         AssetClassType assetClass,
                         Double value,
                         LocalDateTime createdAt) {
        this.investorId = investorId;
        this.assetClass = assetClass;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInvestorId() { return investorId; }

    public AssetClassType getAssetClass() { return assetClass; }

    // 🔥 REQUIRED BY TEST + STREAM
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    public boolean isEmpty() {
        return value == null || value == 0.0;
    }
}
