package com.precalc.dto;

public class QueryModelDto {
	private int queryId;

	private String cname;

	private String phone;

	private String email;

	private String description;

	public int getQueryId() {
		return queryId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public QueryModelDto() {
		super();
	}

	
}
