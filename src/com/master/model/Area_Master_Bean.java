package com.master.model;

import java.io.Serializable;

public class Area_Master_Bean implements Serializable{
	
	private String zone_name;
	private String from_date;
	private String to_date;
	private String amc_date;
	private String iccr_no;
	private String emp_code;
	private String product_code;
	private String status;
	private String cust_name;
	private String area;
	private String address;
	private String mobile_no1;
	private String amc_rate;
	private String actual_spare_amount;
	public String getAmc_date() {
		return amc_date;
	}
	public void setAmc_date(String amc_date) {
		this.amc_date = amc_date;
	}
	public String getIccr_no() {
		return iccr_no;
	}
	public void setIccr_no(String iccr_no) {
		this.iccr_no = iccr_no;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no1() {
		return mobile_no1;
	}
	public void setMobile_no1(String mobile_no1) {
		this.mobile_no1 = mobile_no1;
	}
	public String getAmc_rate() {
		return amc_rate;
	}
	public void setAmc_rate(String amc_rate) {
		this.amc_rate = amc_rate;
	}
	public String getActual_spare_amount() {
		return actual_spare_amount;
	}
	public void setActual_spare_amount(String actual_spare_amount) {
		this.actual_spare_amount = actual_spare_amount;
	}
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	private String area_name;
	private String id;
	public String getZone_name() {
		return zone_name;
	}
	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	
	private static final long serialVersionUID = 1L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	
	

}
