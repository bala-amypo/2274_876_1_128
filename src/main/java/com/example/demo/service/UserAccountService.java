package com.example.demo.service;

import java.util.Optional;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    // existing
    Optional<UserAccount> getUserDataFromDB(Long id);

    UserAccount postUserDateToDB(UserAccount userAccount);

    Optional<UserAccount> updateUserDataInDB(Long id, UserAccount userAccount);

    String deleteUserDataInDB(Long id);

    // ✅ AUTH (MANDATORY)
    UserAccount register(RegisterRequest request);

    AuthResponse login(AuthRequest request);
}
