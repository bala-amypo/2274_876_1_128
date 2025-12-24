
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.demo.entity.AssetClassAllocationRule;

public interface AssetClassAllocationRuleRepository
        extends JpaRepository<AssetClassAllocationRule, Long> {

    // 🔥 Used in AllocationRuleServiceImpl
    List<AssetClassAllocationRule> findByInvestorId(Long investorId);

    // 🔥 Used in AllocationRuleServiceImpl (dummy HQL replacement)
    List<AssetClassAllocationRule> findByInvestorIdAndActiveTrue(Long investorId);

    // 🔥 Alias method to satisfy service call
    default List<AssetClassAllocationRule> findActiveRulesHql(Long investorId) {
        return findByInvestorIdAndActiveTrue(investorId);
    }
}
