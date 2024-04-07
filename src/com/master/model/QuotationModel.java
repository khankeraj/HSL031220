package com.master.model;

public class QuotationModel {
	
	private String name_of_index;
	private String sub_name_of_index;
	private String quantity;
	private String quotation_status;
	private String customer_name;
	
	private int quotationPages_id;
	
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getSub_name_of_index() {
		return sub_name_of_index;
	}
	public void setSub_name_of_index(String sub_name_of_index) {
		this.sub_name_of_index = sub_name_of_index;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getQuotation_status() {
		return quotation_status;
	}
	public void setQuotation_status(String quotation_status) {
		this.quotation_status = quotation_status;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public int getQuotationPages_id() {
		return quotationPages_id;
	}
	public void setQuotationPages_id(int quotationPages_id) {
		this.quotationPages_id = quotationPages_id;
	}
	
}
