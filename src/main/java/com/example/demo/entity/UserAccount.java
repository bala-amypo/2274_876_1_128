package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "user_account",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
    }
)
public class UserAccount {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Boolean active;

    public UserAccount() {
        this.active = true;
    }

    public UserAccount(Long oid, String username, String email,
                       String password, RoleType role, Boolean active) {
        this.oid = oid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public Long getOid() { return oid; }
    public void setOid(Long oid) { this.oid = oid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public RoleType getRole() { return role; }
    public void setRole(RoleType role) { this.role = role; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
