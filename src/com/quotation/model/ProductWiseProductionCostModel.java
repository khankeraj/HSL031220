package com.quotation.model;

public class ProductWiseProductionCostModel {
	
	private int pwproduction_id;
	
	private String quotation_name;
	
	private String name_of_index;
	
	private String heading1;
	
	private String heading2;
	
	private String particulars[];
	private String parti;
	private String ltr;
	
	private String LTR[];
	
	private String requirment[];
	private String req;
	
	private String quantity[];
	private String qty;
	
	
	public String getParti() {
		return parti;
	}
	public void setParti(String parti) {
		this.parti = parti;
	}
	public String getLtr() {
		return ltr;
	}
	public void setLtr(String ltr) {
		this.ltr = ltr;
	}
	public String getReq() {
		return req;
	}
	public void setReq(String req) {
		this.req = req;
	}
	public int getPwproduction_id() {
		return pwproduction_id;
	}
	public void setPwproduction_id(int pwproduction_id) {
		this.pwproduction_id = pwproduction_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getHeading1() {
		return heading1;
	}
	public void setHeading1(String heading1) {
		this.heading1 = heading1;
	}
	public String getHeading2() {
		return heading2;
	}
	public void setHeading2(String heading2) {
		this.heading2 = heading2;
	}
	public String[] getParticulars() {
		return particulars;
	}
	public void setParticulars(String[] particulars) {
		this.particulars = particulars;
	}
	public String[] getLTR() {
		return LTR;
	}
	public void setLTR(String[] lTR) {
		LTR = lTR;
	}
	public String[] getRequirment() {
		return requirment;
	}
	public void setRequirment(String[] requirment) {
		this.requirment = requirment;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getQuotation_name() {
		return quotation_name;
	}
	public void setQuotation_name(String quotation_name) {
		this.quotation_name = quotation_name;
	}

}
