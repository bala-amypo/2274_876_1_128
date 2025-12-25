
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.demo.entity.AssetClassAllocationRule;

public interface AssetClassAllocationRuleRepository
        extends JpaRepository<AssetClassAllocationRule, Long> {

    
    List<AssetClassAllocationRule> findByInvestorId(Long investorId);

   
    List<AssetClassAllocationRule> findByInvestorIdAndActiveTrue(Long investorId);

    
    default List<AssetClassAllocationRule> findActiveRulesHql(Long investorId) {
        return findByInvestorIdAndActiveTrue(investorId);
    }
}
