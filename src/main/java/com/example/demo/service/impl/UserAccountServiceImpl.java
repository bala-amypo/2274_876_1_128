package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserAccountServiceImpl(
            UserAccountRepository userAccountRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // ---------------- REGISTER ----------------
    public UserAccount register(RegisterRequest request) {

        UserAccount user = new UserAccount(
                true,                                   // active
                request.getEmail(),                     // email
                null,                                   // id (auto generated)
                passwordEncoder.encode(request.getPassword()),
                RoleType.USER,                          // default role
                request.getUsername()                   // username
        );

        return userAccountRepository.save(user);
    }

    // ---------------- LOGIN ----------------
    public AuthResponse login(AuthRequest request) {

        UserAccount user = userAccountRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user);

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    // ---------------- BASIC CRUD ----------------
    @Override
    public Optional<UserAccount> getUserDataFromDB(Long id) {
        return userAccountRepository.findById(id);
    }

    @Override
    public UserAccount postUserDateToDB(UserAccount userAccount) {
        return userAccountRepository.saveAndFlush(userAccount);
    }

    @Override
    public Optional<UserAccount> updateUserDataInDB(Long id, UserAccount userAccount) {
        return userAccountRepository.findById(id).map(existing -> {
            existing.setEmail(userAccount.getEmail());
            existing.setActive(userAccount.getActive());
            existing.setRole(userAccount.getRole());
            return userAccountRepository.save(existing);
        });
    }

    @Override
    public String deleteUserDataInDB(Long id) {
        userAccountRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
