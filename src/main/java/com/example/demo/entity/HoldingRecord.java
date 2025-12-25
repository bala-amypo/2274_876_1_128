
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public AssetClassType getAssetClass() {
        return assetClass;
    }

    
    public Double getValue() {
        return value;
    }

    
    public Double getCurrentValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    
    public boolean isEmpty() {
        return value == null || value == 0.0;
    }
}
