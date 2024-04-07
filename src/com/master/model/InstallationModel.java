package com.master.model;

public class InstallationModel {
	private int installation_id;
	private String installation_status;
	private String customer_name;
	public int getInstallation_id() {
		return installation_id;
	}
	public void setInstallation_id(int installation_id) {
		this.installation_id = installation_id;
	}
	public String getInstallation_status() {
		return installation_status;
	}
	public void setInstallation_status(String installation_status) {
		this.installation_status = installation_status;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	

}
