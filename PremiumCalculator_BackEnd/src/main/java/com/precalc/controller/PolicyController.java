package com.precalc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.precalc.dto.PolicyModelDto;
import com.precalc.exception.PolicyNotFoundException;
import com.precalc.model.PolicyModel;
import com.precalc.service.PolicyService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class PolicyController {
	
	private static final String MESSAGE = "Policy Not found with policy Id as: ";

	@Autowired
	private PolicyService policyService;

	@PostMapping("/addPolicy")
	public ResponseEntity<PolicyModel> createPolicy(@RequestBody PolicyModelDto policyDto) {
		PolicyModel p = new PolicyModel();
		p.setInsurer(policyDto.getInsurer());
		p.setInsuranceType(policyDto.getInsuranceType());
		p.setPolicyId(policyDto.getPolicyId());
		p.setMinPolicyTerm(policyDto.getMinPolicyTerm());
		p.setMinEntryAge(policyDto.getMinEntryAge());
		p.setMinSumAssured(policyDto.getMinSumAssured());
		p.setMaxPolicyTerm(policyDto.getMaxPolicyTerm());
		p.setMaxEntryAge(policyDto.getMaxEntryAge());
		p.setMaxCoverAge(policyDto.getMaxCoverAge());
		p.setSchemeName(policyDto.getSchemeName());
		policyService.savePolicy(p);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/getPolicies")
	public ResponseEntity<List<PolicyModel>> getPolicies() {
		List<PolicyModel> policies = policyService.findAllPolicies();
		return new ResponseEntity<>(policies, HttpStatus.OK);
	}

	@GetMapping("/viewPolicy/{policyId}")
	public ResponseEntity<PolicyModel> getPolicyById(@PathVariable int policyId) {
		PolicyModel pm = policyService.findPolicyById(policyId);
		if (pm != null)
			return ResponseEntity.ok(pm);
		else
			throw new PolicyNotFoundException(MESSAGE + policyId);
	}

	@PutMapping("/updatePolicy/{policyId}")
	public ResponseEntity<PolicyModel> updatePolicy(@PathVariable int policyId,
			@RequestBody PolicyModelDto policyDetails) {
		PolicyModel pm = policyService.findPolicyById(policyId);
		if (pm != null) {
			pm.setInsurer(policyDetails.getInsurer());
			pm.setInsuranceType(policyDetails.getInsuranceType());
			pm.setSchemeName(policyDetails.getSchemeName());
			pm.setMinPolicyTerm(policyDetails.getMinPolicyTerm());
			pm.setMaxPolicyTerm(policyDetails.getMaxPolicyTerm());
			pm.setMinEntryAge(policyDetails.getMinEntryAge());
			pm.setMaxEntryAge(policyDetails.getMaxEntryAge());
			pm.setMaxCoverAge(policyDetails.getMaxCoverAge());
			pm.setMinSumAssured(policyDetails.getMinSumAssured());

			PolicyModel updatePolicy = policyService.saveUpdatedPolicy(pm);
			return ResponseEntity.ok(updatePolicy);
		} else
			throw new PolicyNotFoundException(MESSAGE + policyId);
	}

	@DeleteMapping("/deletePolicy/{policyId}")
	public String deletePolicy(@PathVariable int policyId) {
		// retrive particular plan from the database using planId
		PolicyModel pm = policyService.findPolicyById(policyId);
		if (pm != null) {
			policyService.deletePolicy(pm);
			return "Policy has been deleted";
		} else
			throw new PolicyNotFoundException(MESSAGE + policyId);
	}

}
