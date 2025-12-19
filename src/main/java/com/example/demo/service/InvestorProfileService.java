package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileService {
    InvestorProfile createInvestor(InvestorProfile investor);
    InvestorProfile getInvestorById(Long id);
    InvestorProfile findByInvestorId(String investorId);
    List<InvestorProfile> getAllInvestors();
    InvestorProfile updateInvestorStatus(Long id, boolean active);
}
