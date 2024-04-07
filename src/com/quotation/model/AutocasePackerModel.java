package com.quotation.model;

public class AutocasePackerModel {
	private int autocase_packer_id;
	private String name_of_index;
	private String subanme;
	private String note;
	private String quotation_name;
	
	private String specfication[];
	private String quantity[];
	
	private String specifi;
	private String qty;
	
	public String getSpecifi() {
		return specifi;
	}
	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public int getAutocase_packer_id() {
		return autocase_packer_id;
	}
	public void setAutocase_packer_id(int autocase_packer_id) {
		this.autocase_packer_id = autocase_packer_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getSubanme() {
		return subanme;
	}
	public void setSubanme(String subanme) {
		this.subanme = subanme;
	}
	public String[] getSpecfication() {
		return specfication;
	}
	public void setSpecfication(String[] specfication) {
		this.specfication = specfication;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getQuotation_name() {
		return quotation_name;
	}
	public void setQuotation_name(String quotation_name) {
		this.quotation_name = quotation_name;
	}
	
}
