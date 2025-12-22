package com.example.demo.service;

import java.util.Optional;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {

    Optional<UserAccount> getUserDataFromDB(Long id);

    UserAccount postUserDateToDB(UserAccount userAccount);

    Optional<UserAccount> updateUserDataInDB(Long id, UserAccount userAccount);

    String deleteUserDataInDB(Long id);
}
