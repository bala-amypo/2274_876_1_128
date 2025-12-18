package com.example.demo.entity;
import jakarta.persistence.*;

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
    public void setId(String investorId) {
        this.investorId = investorId;
    }
    public String getFullName() {
           return fullName;
       }
       public void setId(String fullName) {
           this.fullName = fullName;
       }
}