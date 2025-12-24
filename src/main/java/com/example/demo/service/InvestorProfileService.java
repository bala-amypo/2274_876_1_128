// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.InvestorProfile;

// public interface InvestorProfileService {

//     InvestorProfile createInvestor(InvestorProfile investor);

//     InvestorProfile getInvestorById(Long id);

//     InvestorProfile findByInvestorId(String investorId);

//     List<InvestorProfile> getAllInvestors();

//     InvestorProfile updateInvestorStatus(Long id, boolean active);
// }



package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileService {

    InvestorProfile createInvestor(InvestorProfile investor);

    InvestorProfile getInvestorById(Long id);

    // 🔥 TEST EXPECTS Optional
    Optional<InvestorProfile> findByInvestorId(String investorId);

    // 🔥 TEST EXPECTS Optional
    Optional<InvestorProfile> findByEmail(String email);

    List<InvestorProfile> getAllInvestors();

    InvestorProfile updateInvestorStatus(Long id, boolean active);
}
