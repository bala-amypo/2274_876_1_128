
// package com.example.demo.service.impl;

// import com.example.demo.entity.AssetClassAllocationRule;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.AssetClassAllocationRuleRepository;
// import com.example.demo.service.AllocationRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AllocationRuleServiceImpl implements AllocationRuleService {

//     private final AssetClassAllocationRuleRepository ruleRepository;

//     public AllocationRuleServiceImpl(
//             AssetClassAllocationRuleRepository ruleRepository) {
//         this.ruleRepository = ruleRepository;
//     }

    
//     @Override
//     public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {

//         validatePercentage(rule.getTargetPercentage());

//         return ruleRepository.save(rule);
//     }

    
//     @Override
//     public AssetClassAllocationRule updateRule(
//             Long id, AssetClassAllocationRule updatedRule) {

//         AssetClassAllocationRule existing =
//                 ruleRepository.findById(id)
//                         .orElseThrow(() ->
//                                 new ResourceNotFoundException("Rule not found"));

//         validatePercentage(updatedRule.getTargetPercentage());

//         existing.setInvestorId(updatedRule.getInvestorId());
//         existing.setAssetClass(updatedRule.getAssetClass());
//         existing.setTargetPercentage(updatedRule.getTargetPercentage());
//         existing.setActive(updatedRule.getActive());

//         return ruleRepository.save(existing);
//     }

//     @Override
//     public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
//         return ruleRepository.findByInvestorId(investorId);
//     }

//     @Override
//     public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
//         return ruleRepository.findActiveRulesHql(investorId);
//     }

//     @Override
//     public AssetClassAllocationRule getRuleById(Long id) {
//         return ruleRepository.findById(id)
//                 .orElseThrow(() ->
//                         new ResourceNotFoundException("Rule not found"));
//     }

//     @Override
//     public List<AssetClassAllocationRule> getAllRules() {
//         return ruleRepository.findAll();
//     }

    
//     private void validatePercentage(Double percentage) {
//         if (percentage == null || percentage < 0 || percentage > 100) {
//             throw new IllegalArgumentException(
//                     "Target percentage must be between 0 and 100");
//         }
//     }
// }

// package com.example.demo.service.impl;

// import com.example.demo.entity.AssetClassAllocationRule;
// import com.example.demo.repository.AssetClassAllocationRuleRepository;
// import com.example.demo.service.AllocationRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class AllocationRuleServiceImpl implements AllocationRuleService {

//     private final AssetClassAllocationRuleRepository ruleRepository;

//     public AllocationRuleServiceImpl(
//             AssetClassAllocationRuleRepository ruleRepository) {
//         this.ruleRepository = ruleRepository;
//     }

//     @Override
//     public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {

//         validatePercentage(rule.getTargetPercentage());
//         return ruleRepository.save(rule);
//     }

//     @Override
//     public AssetClassAllocationRule updateRule(
//             Long id, AssetClassAllocationRule updatedRule) {

//         AssetClassAllocationRule existing =
//                 ruleRepository.findById(id)
//                         // 🔥 TEST EXPECTS RuntimeException
//                         .orElseThrow(() ->
//                                 new RuntimeException("Allocation rule not found"));

//         validatePercentage(updatedRule.getTargetPercentage());

//         existing.setInvestorId(updatedRule.getInvestorId());
//         existing.setAssetClass(updatedRule.getAssetClass());
//         existing.setTargetPercentage(updatedRule.getTargetPercentage());
//         existing.setActive(updatedRule.getActive());

//         return ruleRepository.save(existing);
//     }

//     @Override
//     public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
//         return ruleRepository.findByInvestorId(investorId);
//     }

//     @Override
//     public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
//         return ruleRepository.findActiveRulesHql(investorId);
//     }

//     @Override
//     public AssetClassAllocationRule getRuleById(Long id) {
//         return ruleRepository.findById(id)
//                 // 🔥 TEST EXPECTS RuntimeException
//                .orElseThrow(() -> new ResourceNotFoundException(
//         "Allocation rule not found with id " + ruleId
// ));

//     }

//     @Override
//     public List<AssetClassAllocationRule> getAllRules() {
//         return ruleRepository.findAll();
//     }

//     private void validatePercentage(Double percentage) {
//         if (percentage == null || percentage < 0 || percentage > 100) {
//             throw new IllegalArgumentException(
//                     "Target percentage must be between 0 and 100");
//         }
//     }
// }

package com.example.demo.service.impl;

import com.example.demo.entity.AssetClassAllocationRule;
import com.example.demo.repository.AssetClassAllocationRuleRepository;
import com.example.demo.service.AllocationRuleService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationRuleServiceImpl implements AllocationRuleService {

    private final AssetClassAllocationRuleRepository ruleRepository;

    public AllocationRuleServiceImpl(
            AssetClassAllocationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public AssetClassAllocationRule createRule(AssetClassAllocationRule rule) {
        validatePercentage(rule.getTargetPercentage());
        return ruleRepository.save(rule);
    }

    @Override
    public AssetClassAllocationRule updateRule(
            Long id, AssetClassAllocationRule updatedRule) {

        AssetClassAllocationRule existing =
                ruleRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Allocation rule not found with id " + id
                                ));

        validatePercentage(updatedRule.getTargetPercentage());

        existing.setInvestorId(updatedRule.getInvestorId());
        existing.setAssetClass(updatedRule.getAssetClass());
        existing.setTargetPercentage(updatedRule.getTargetPercentage());
        existing.setActive(updatedRule.getActive());

        return ruleRepository.save(existing);
    }

    @Override
    public List<AssetClassAllocationRule> getRulesByInvestor(Long investorId) {
        return ruleRepository.findByInvestorId(investorId);
    }

    @Override
    public List<AssetClassAllocationRule> getActiveRules(Long investorId) {
        return ruleRepository.findActiveRulesHql(investorId);
    }

    @Override
    public AssetClassAllocationRule getRuleById(Long id) {
        return ruleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Allocation rule not found with id " + id
                ));
    }

    @Override
    public List<AssetClassAllocationRule> getAllRules() {
        return ruleRepository.findAll();
    }

    private void validatePercentage(Double percentage) {
        if (percentage == null || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException(
                    "Target percentage must be between 0 and 100");
        }
    }
}


