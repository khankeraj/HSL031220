package com.master.model;
import java.io.Serializable;

public class IssueModel implements Serializable{
	
	private String issue_no;
	private String customer_no;
	private String customer_name;
	private String lead_id;
	private String mobile_no;
	private String date;
	private String employee;
	private String[] description;
	private String[] quantity;
	private String pono;
	private String remark;
	private String issue_status;
	
	
	
	public String getIssue_status() {
		return issue_status;
	}
	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIssue_no() {
		return issue_no;
	}
	public void setIssue_no(String issue_no) {
		this.issue_no = issue_no;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getLead_id() {
		return lead_id;
	}
	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return issue_no+" "+customer_no+" "+customer_name+" "+lead_id+" "+mobile_no+" "+date+" "+employee+" "+description+" "+quantity+" "+pono+" "+lead_id;
	}
 }