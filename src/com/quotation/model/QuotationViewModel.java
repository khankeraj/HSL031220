package com.quotation.model;

public class QuotationViewModel {
	
	private int id;
	private int quotation_id;
	private String customer_name;
	private String lead_no;
	private String cust_name;
	
	private String  mycheckbox[];
	private String sub_name_of_index[];
	private String selectQuotationName[];
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuotation_id() {
		return quotation_id;
	}
	public void setQuotation_id(int quotation_id) {
		this.quotation_id = quotation_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String[] getSub_name_of_index() {
		return sub_name_of_index;
	}
	public void setSub_name_of_index(String[] sub_name_of_index) {
		this.sub_name_of_index = sub_name_of_index;
	}
	public String[] getSelectQuotationName() {
		return selectQuotationName;
	}
	public void setSelectQuotationName(String[] selectQuotationName) {
		this.selectQuotationName = selectQuotationName;
	}
	public String[] getMycheckbox() {
		return mycheckbox;
	}
	public void setMycheckbox(String mycheckbox[]) {
		this.mycheckbox = mycheckbox;
	}
	public String getLead_no() {
		return lead_no;
	}
	public void setLead_no(String lead_no) {
		this.lead_no = lead_no;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	
	
}
