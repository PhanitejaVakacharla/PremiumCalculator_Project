package com.virtusa.precalc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.precalc.model.PolicyModel;

@Repository
public interface PolicyRepository extends JpaRepository<PolicyModel, Integer> {

	PolicyModel findByPolicyId(int policyId);

}
