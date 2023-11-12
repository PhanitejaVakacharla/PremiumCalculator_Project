package com.virtusa.precalc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "precalc_query")
public class QueryModel {

	@Id
	@GeneratedValue
	private int queryId;
	@Column
	private String customerName;
	@Column
	private String phone;
	@Column
	private String email;
	@Column
	private String queryDescription;

	public QueryModel(int queryId, String customerName, String phone, String email, String queryDescription) {
		super();
		this.queryId = queryId;
		this.customerName = customerName;
		this.phone = phone;
		this.email = email;
		this.queryDescription = queryDescription;
	}

	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public QueryModel() {
		super();
	}



}