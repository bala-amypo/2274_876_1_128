package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.service.InvestorProfileService;

@RestController
public class InvestorProfileController {

    @Autowired
    InvestorProfileService ser;

    @PostMapping("/addInvestor")
    public InvestorProfile add(@RequestBody InvestorProfile inv) {
        return ser.createInvestor(inv);
    }

    @GetMapping("/getInvestors")
    public List<InvestorProfile> fetchAll() {
        return ser.fetchAll();
    }

    @GetMapping("/getInvestor/{id}")
    public Optional<InvestorProfile> fetchById(@PathVariable Long id) {
        return ser.fetchById(id);
    }

    @PutMapping("/updateInvestor/{id}")
    public String update(@PathVariable Long id,
                         @RequestBody InvestorProfile inv) {

        Optional<InvestorProfile> data = ser.fetchById(id);

        if (data.isPresent()) {
            inv.setId(id);
            ser.createInvestor(inv);
            return "Investor Updated Successfully";
        } else {
            return id + " not found";
        }
    }

    @DeleteMapping("/deleteInvestor/{id}")
    public String delete(@PathVariable Long id) {

        Optional<InvestorProfile> data = ser.fetchById(id);

        if (data.isPresent()) {
            ser.deleteInvestor(id);
            return "Investor Deleted Successfully";
        } else {
            return id + " not found";
        }
    }
}