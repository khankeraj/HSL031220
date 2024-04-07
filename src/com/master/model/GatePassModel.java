package com.master.model;

public class GatePassModel {
	
	private String reqDate;
	private String gpno;
	private String customer_name;
	private String issue;
	
	private String lead_no;
	
	private String specifications[];
	private String quantity[];
	
	private String specifi;
	private String qty;
	
	public String getLead_no() {
		return lead_no;
	}
	public void setLead_no(String lead_no) {
		this.lead_no = lead_no;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getGpno() {
		return gpno;
	}
	public void setGpno(String gpno) {
		this.gpno = gpno;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String[] getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String[] specifications) {
		this.specifications = specifications;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String getSpecifi() {
		return specifi;
	}
	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
}
