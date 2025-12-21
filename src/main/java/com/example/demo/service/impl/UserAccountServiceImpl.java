package com.example.demo.service.impl;
import com.example.demo.entity.enums.RoleType;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public UserAccount register(UserAccount userAccount) {
        userAccount.setOpassword(
                passwordEncoder.encode(userAccount.getOpassword())
        );
        userAccount.setOrole(RoleType.INVESTOR);
        userAccount.setOactive(true);
        return repository.save(userAccount);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return repository.findByOemail(email).orElse(null);
    }
}
