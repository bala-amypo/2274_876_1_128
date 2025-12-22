package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

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
        userAccountRepository.deleteById(id);
        userAccountRepository.saveAndFlush(userAccount);
        return userAccountRepository.findById(id);
    }

    @Override
    public String deleteUserDataInDB(Long id) {
        userAccountRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
