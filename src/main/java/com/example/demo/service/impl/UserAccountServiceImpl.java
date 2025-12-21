package com.example.demo.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoleType;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserAccount register(UserAccount user) {

        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new BadRequestException("Email already exists");
        }

        if (repository.findByUsername(user.getUsername()).isPresent()) {
            throw new BadRequestException("Username already exists");
        }

        // 🔐 hash password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(RoleType.INVESTOR);
        }

        user.setActive(true);
        return repository.save(user);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new BadRequestException("User not found"));
    }
}
