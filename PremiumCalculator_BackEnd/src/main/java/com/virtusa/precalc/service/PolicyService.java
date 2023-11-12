package com.virtusa.precalc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.precalc.model.PolicyModel;
import com.virtusa.precalc.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	private PolicyRepository policyRepository;

	public PolicyModel savePolicy(PolicyModel policy) {
		return policyRepository.save(policy);
	}

	public List<PolicyModel> findAllPolicies() {
		return policyRepository.findAll();
	}

	public PolicyModel findPolicyById(int policyId) {
		return policyRepository.findByPolicyId(policyId);
	}

	public PolicyModel saveUpdatedPolicy(PolicyModel pm) {
		return policyRepository.save(pm);
	}

	public void deletePolicy(PolicyModel pm) {
		policyRepository.delete(pm);
		
	}
	
	

}
