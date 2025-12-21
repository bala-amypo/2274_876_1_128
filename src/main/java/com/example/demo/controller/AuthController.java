package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserAccountService userAccountService;

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(
            @RequestBody UserAccount userAccount) {

        return ResponseEntity.ok(
                userAccountService.register(userAccount)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        // JWT later
        return ResponseEntity.ok("Login success (JWT pending)");
    }
}
