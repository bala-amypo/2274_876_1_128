package com.example.demo.service.implementation;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.repository.InvestorProfileRepository;
import com.example.demo.service.InvestorProfileService;

@Service
public class InvestorProfileServiceImpl implements InvestorProfileService {

    @Autowired
    InvestorProfileRepository repo;

    @Override
    public InvestorProfile createInvestor(InvestorProfile investor) {
        return repo.save(investor);
    }

    @Override
    public List<InvestorProfile> fetchAll() {
        return repo.findAll();
    }

    @Override
    public Optional<InvestorProfile> fetchById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void deleteInvestor(Long id) {
        repo.deleteById(id);
    }
}