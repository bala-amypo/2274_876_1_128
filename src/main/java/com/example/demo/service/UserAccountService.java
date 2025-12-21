package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    UserAccount register(UserAccount user);

    UserAccount findByEmail(String email);
}
