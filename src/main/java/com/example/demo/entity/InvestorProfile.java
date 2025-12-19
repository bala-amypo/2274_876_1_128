package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "investor_profile",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "investorId"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class InvestorProfile {

    @Id
    
    private Long id;

    @Column(unique=true)
    private String investorId;

    private String fullName;

    @Column(unique=true)
    private String email;

    private Boolean active;

    private LocalDateTime createdAt;

    
    public InvestorProfile() {
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    
    public InvestorProfile(Long id, String investorId, String fullName,
                           String email, Boolean active, LocalDateTime createdAt) {
        this.id = id;
        this.investorId = investorId;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getInvestorId() { return investorId; }
    public void setInvestorId(String investorId) { this.investorId = investorId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
