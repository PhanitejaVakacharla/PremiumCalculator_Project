package com.virtusa.precalc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="precalc_policy")
public class PolicyModel {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policyId;
	@Column(nullable = false)
	private String insurer;
	@Column(nullable = false)
	private String insuranceType;
	@Column(nullable = false)
	private String schemeName;
	@Column(nullable = false)
	private int minPolicyTerm;
	@Column(nullable = false)
	private int maxPolicyTerm;
	@Column(nullable = false)
	private int minEntryAge;
	@Column(nullable = false)
	private int maxEntryAge;
	@Column(nullable = false)
	private int maxCoverAge;
	@Column(nullable = false)
	private int minSumAssured;
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getInsurer() {
		return insurer;
	}
	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public int getMinPolicyTerm() {
		return minPolicyTerm;
	}
	public void setMinPolicyTerm(int minPolicyTerm) {
		this.minPolicyTerm = minPolicyTerm;
	}
	public int getMaxPolicyTerm() {
		return maxPolicyTerm;
	}
	public void setMaxPolicyTerm(int maxPolicyTerm) {
		this.maxPolicyTerm = maxPolicyTerm;
	}
	public int getMinEntryAge() {
		return minEntryAge;
	}
	public void setMinEntryAge(int minEntryAge) {
		this.minEntryAge = minEntryAge;
	}
	public int getMaxEntryAge() {
		return maxEntryAge;
	}
	public void setMaxEntryAge(int maxEntryAge) {
		this.maxEntryAge = maxEntryAge;
	}
	public int getMaxCoverAge() {
		return maxCoverAge;
	}
	public void setMaxCoverAge(int maxCoverAge) {
		this.maxCoverAge = maxCoverAge;
	}
	public int getMinSumAssured() {
		return minSumAssured;
	}
	public void setMinSumAssured(int minSumAssured) {
		this.minSumAssured = minSumAssured;
	}
	public PolicyModel() {
		super();
	}
	
	
	
}
