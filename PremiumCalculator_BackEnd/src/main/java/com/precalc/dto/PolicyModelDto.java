package com.precalc.dto;

public class PolicyModelDto {

	private int policyId;
	private String insurer;
	private String insuranceType;
	private String schemeName;
	private int minPolicyTerm;
	private int maxPolicyTerm;
	private int minEntryAge;
	private int maxEntryAge;
	private int maxCoverAge;
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
	public PolicyModelDto() {
		super();
	}
	
	
	
}

