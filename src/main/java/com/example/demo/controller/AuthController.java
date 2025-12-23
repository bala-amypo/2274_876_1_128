package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount userAccount) {
        return userAccountService.postUserDateToDB(userAccount);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {

        return new AuthResponse(
                "dummy-token",
                1L,
                "demo-user",
                "Login success"
        );
    }
}
