package com.master.model;


public class MaintenanceModel{
	
	private String maintenance_id;
	
	public String getMaintenance_id() {
		return maintenance_id;
	}
	public void setMaintenance_id(String maintenance_id) {
		this.maintenance_id = maintenance_id;
	}
	
	
	private String bill_no;
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}


	private String vehicle_no;
	private String date;
	private String servicing_company;
	private String km;
	
	private String description[];
	private String amount[];
	
	private String total_amount;
	
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getServicing_company() {
		return servicing_company;
	}
	public void setServicing_company(String servicing_company) {
		this.servicing_company = servicing_company;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	public String[] getAmount() {
		return amount;
	}
	public void setAmount(String[] amount) {
		this.amount = amount;
	}
	
	
	
}