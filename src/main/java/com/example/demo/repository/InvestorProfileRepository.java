
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileRepository
        extends JpaRepository<InvestorProfile, Long> {

    // 🔥 TEST EXPECTS Optional
    Optional<InvestorProfile> findByEmail(String email);

    // 🔥 TEST EXPECTS Optional
    Optional<InvestorProfile> findByInvestorId(String investorId);
}

