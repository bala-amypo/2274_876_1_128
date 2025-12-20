package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount register(RegisterRequest request);

    UserAccount login(LoginRequest request);
}
