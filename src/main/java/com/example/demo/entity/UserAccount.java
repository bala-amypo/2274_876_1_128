package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import com.example.demo.entity.enums.RoleType;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleType role;

    @Column(nullable = false)
    private Boolean active = true;

    // ✅ Default constructor required by JPA
    public UserAccount() {}

    // 4-param constructor
    public UserAccount(String userName, String email, String password, RoleType role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = true;
    }

    // Getters
    public Long getId() { return id; }
    public String getUserName() { return userName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public RoleType getRole() { return role; }
    public Boolean getActive() { return active; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(RoleType role) { this.role = role; }
    public void setActive(Boolean active) { this.active = active; }
}
