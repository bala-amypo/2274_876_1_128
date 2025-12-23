package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.entity.enums.RoleType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserAccountServiceImpl(
            UserAccountRepository userRepo,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    

    @Override
public UserAccount register(RegisterRequest request) {

    UserAccount user = new UserAccount(
            true,                       // active
            request.getEmail(),         // email
            null,                       // id (auto)
            passwordEncoder.encode(request.getPassword()),
            request.getRole(),          // role
            request.getUsername()       // username
    );

    return userRepo.save(user);
}


    @Override
    public AuthResponse login(AuthRequest request) {

        UserAccount user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getRole().name()
        );
    }

    

    @Override
    public Optional<UserAccount> getUserDataFromDB(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserAccount postUserDateToDB(UserAccount userAccount) {
        return userRepo.save(userAccount);
    }

    @Override
    public Optional<UserAccount> updateUserDataInDB(Long id, UserAccount userAccount) {
        return userRepo.findById(id)
                .map(existing -> {
                    existing.setUsername(userAccount.getUsername());
                    existing.setEmail(userAccount.getEmail());
                    existing.setActive(userAccount.getActive());
                    return userRepo.save(existing);
                });
    }

    @Override
    public String deleteUserDataInDB(Long id) {
        userRepo.deleteById(id);
        return "Deleted Successfully";
    }
}
