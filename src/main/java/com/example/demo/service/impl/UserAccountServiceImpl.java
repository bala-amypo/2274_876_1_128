package com.example.demo.service.impl;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserAccount register(RegisterRequest request) {

        if (repository.findByEmail(request.email).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        UserAccount user = new UserAccount();
        user.setUsername(request.username);
        user.setEmail(request.email);
        user.setPassword(request.password);

        return repository.save(user);
    }

    @Override
    public UserAccount login(LoginRequest request) {

        UserAccount user = repository.findByEmail(request.email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.password)) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return user;
    }
}
