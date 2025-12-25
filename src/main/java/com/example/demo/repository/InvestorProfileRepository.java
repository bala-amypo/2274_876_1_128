
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileRepository
        extends JpaRepository<InvestorProfile, Long> {

    
    Optional<InvestorProfile> findByEmail(String email);

    
    Optional<InvestorProfile> findByInvestorId(String investorId);
}

