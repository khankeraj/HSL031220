package com.master.model;

public class GstTaxMasterModel {
	
	private int id;
	private String hsn_code;
	private String tax_percentage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHsn_code() {
		return hsn_code;
	}
	public void setHsn_code(String hsn_code) {
		this.hsn_code = hsn_code;
	}
	public String getTax_percentage() {
		return tax_percentage;
	}
	public void setTax_percentage(String tax_percentage) {
		this.tax_percentage = tax_percentage;
	}
}
