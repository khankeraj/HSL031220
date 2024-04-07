package com.master.model;

public class RateMasterModel {
	
	private int rateid;
	private String customer;
	private String type;
	
	private String purchaserate;
	private String salerate;
	public int getRateid() {
		return rateid;
	}
	public void setRateid(int rateid) {
		this.rateid = rateid;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPurchaserate() {
		return purchaserate;
	}
	public void setPurchaserate(String purchaserate) {
		this.purchaserate = purchaserate;
	}
	public String getSalerate() {
		return salerate;
	}
	public void setSalerate(String salerate) {
		this.salerate = salerate;
	}
	
}
