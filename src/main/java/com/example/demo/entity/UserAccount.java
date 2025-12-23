package com.example.demo.entity;

import com.example.demo.entity.enums.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private Boolean active = true;

   
    public UserAccount() {
    }

    
    public UserAccount(
            Boolean active,
            String email,
            Long id,
            String password,
            RoleType role,
            String userName) {

        this.active = active;
        this.email = email;
        this.id = id;
        this.password = password;
        this.role = role;
        this.userName = userName;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
