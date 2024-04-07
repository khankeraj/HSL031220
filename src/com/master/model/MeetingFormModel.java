package com.master.model;

public class MeetingFormModel {
	private int meeting_id;
	private String lead_no;
	public String getLead_no() {
		return lead_no;
	}
	public void setLead_no(String lead_no) {
		this.lead_no = lead_no;
	}
	private String customer_name;
	private String contact_no;
	private String requiredDate;
	private String meeting_status;
	private int status;
	private String next_meeting_date;
	private String description;
	private String remark;
	private String amount;
	
	public int getMeeting_id() {
		return meeting_id;
	}
	public void setMeeting_id(int meeting_id) {
		this.meeting_id = meeting_id;
	}
	public String getMeeting_status() {
		return meeting_status;
	}
	public void setMeeting_status(String meeting_status) {
		this.meeting_status = meeting_status;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNext_meeting_date() {
		return next_meeting_date;
	}
	public void setNext_meeting_date(String next_meeting_date) {
		this.next_meeting_date = next_meeting_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
	

}
