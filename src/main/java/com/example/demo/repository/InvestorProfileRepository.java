package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.InvestorProfile;

public interface InvestorProfileRepository
        extends JpaRepository<InvestorProfile, Long> {

    Optional<InvestorProfile> findByInvestorId(String investorId);
}
