package com.status_report.model;

public class StatusReportModel {
	
	private String customer_name;
	private String lead_status;
	private String meeting_status;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getLead_status() {
		return lead_status;
	}
	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}
	public String getMeeting_status() {
		return meeting_status;
	}
	public void setMeeting_status(String meeting_status) {
		this.meeting_status = meeting_status;
	}
	
}
