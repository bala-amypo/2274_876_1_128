package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/investors")
@Tag(name = "Investor Profile")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile create(@RequestBody InvestorProfile i) {
        return service.createInvestor(i);
    }

    @GetMapping("/{id}")
    public InvestorProfile get(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAll() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile update(@PathVariable Long id, @RequestParam boolean active) {
        return service.updateInvestorStatus(id, active);
    }

    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookup(@PathVariable String investorId) {
        return service.findByInvestorId(investorId);
    }
}
