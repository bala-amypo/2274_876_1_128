// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.entity.InvestorProfile;
// import com.example.demo.service.InvestorProfileService;

// import io.swagger.v3.oas.annotations.tags.Tag;

// @RestController
// @RequestMapping("/api/investors")
// @Tag(name = "Investor Profile API")
// public class InvestorProfileController {

//     private final InvestorProfileService service;

//     public InvestorProfileController(InvestorProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
//         return service.createInvestor(investor);
//     }

//     @GetMapping("/{id}")
//     public InvestorProfile getInvestorById(@PathVariable Long id) {
//         return service.getInvestorById(id);
//     }

//     @GetMapping
//     public List<InvestorProfile> getAllInvestors() {
//         return service.getAllInvestors();
//     }

    
//     @PutMapping("/{id}/status")
//     public InvestorProfile updateInvestorStatus(
//             @PathVariable Long id,
//             @RequestBody InvestorProfile request) {

//         return service.updateInvestorStatus(id, request.getActive());
//     }

//     @GetMapping("/lookup/{investorId}")
//     public InvestorProfile lookupByInvestorId(
//             @PathVariable String investorId) {
//         return service.findByInvestorId(investorId);
//     }
// }



package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.InvestorProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.InvestorProfileService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/investors")
@Tag(name = "Investor Profile API")
public class InvestorProfileController {

    private final InvestorProfileService service;

    public InvestorProfileController(InvestorProfileService service) {
        this.service = service;
    }

    @PostMapping
    public InvestorProfile createInvestor(@RequestBody InvestorProfile investor) {
        return service.createInvestor(investor);
    }

    @GetMapping("/{id}")
    public InvestorProfile getInvestorById(@PathVariable Long id) {
        return service.getInvestorById(id);
    }

    @GetMapping
    public List<InvestorProfile> getAllInvestors() {
        return service.getAllInvestors();
    }

    @PutMapping("/{id}/status")
    public InvestorProfile updateInvestorStatus(
            @PathVariable Long id,
            @RequestBody InvestorProfile request) {

        return service.updateInvestorStatus(id, request.getActive());
    }

    // 🔥🔥🔥 UPDATED: Optional handling
    @GetMapping("/lookup/{investorId}")
    public InvestorProfile lookupByInvestorId(
            @PathVariable String investorId) {

        return service.findByInvestorId(investorId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Investor not found with investorId: " + investorId));
    }

    // 🔥 OPTIONAL but SAFE (email lookup – test friendly)
    @GetMapping("/lookup/email/{email}")
    public InvestorProfile lookupByEmail(@PathVariable String email) {
        return service.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Investor not found with email: " + email));
    }
}
