package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDataTime;
@Entity;
public class InvestorProfile{
    @Id;
    private Long id;
    private String investorId;
    private String fullName;
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getInvestorId() {
        return investorId;
       }
    public void setInvestorId(String investorId) {
        this.investorId = investorId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public LocalDataTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
     public InvestorProfile(Long id,String investorId, String fullName, String email, Boolean active,LocalDateTime createdAt) {
        this.id = id;
        this.investorId = investorId;
        this.fullName = fullName;
        this.email = email;
        this.active = active;
        this.createdAt = createdAt;
       }
       public InvestorProfile() {
       }

}