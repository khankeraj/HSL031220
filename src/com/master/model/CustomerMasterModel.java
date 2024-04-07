package com.master.model;

public class CustomerMasterModel {
	
	private int customer_id;
	private String customer_no;
	private String customer_name;
	private String company_name;
	private String customer_address;
	private String customer_mobile;
	private String phone_no;
	private String state;
	private String city;
	private String pan_no;
	private String pincode_no;
	private String customer_gst_no;
	private String email;
	private String pendingAmt;
	
	private String type;
	
	public String getPendingAmt() {
		return pendingAmt;
	}
	public void setPendingAmt(String pendingAmt) {
		this.pendingAmt = pendingAmt;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String getCustomer_mobile() {
		return customer_mobile;
	}
	public void setCustomer_mobile(String customer_mobile) {
		this.customer_mobile = customer_mobile;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getPincode_no() {
		return pincode_no;
	}
	public void setPincode_no(String pincode_no) {
		this.pincode_no = pincode_no;
	}
	public String getCustomer_gst_no() {
		return customer_gst_no;
	}
	public void setCustomer_gst_no(String customer_gst_no) {
		this.customer_gst_no = customer_gst_no;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
