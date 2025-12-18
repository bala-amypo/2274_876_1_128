package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileService {

    InvestorProfile createInvestor(InvestorProfile investor);
    List<InvestorProfile> fetchAll();
    Optional<InvestorProfile> fetchById(Long id);
    void deleteInvestor(Long id);
}