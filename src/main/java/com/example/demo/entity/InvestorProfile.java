package com.example.demo.entity;
import jakarta.persistence.*;

@Entity;
public class InvestorProfile{
    @Id;
    private Long id;
    private String InvestorId;
    private String fullName;
    private String email;
    private Boolean active;
    private LocalDateTime createdAt;

}