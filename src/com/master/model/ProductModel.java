package com.master.model;


public class ProductModel{
	
	private String product_name;
	private String remark;
	private String product_id;
	private String hsn_code;
	private String tax_percentage;
	
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
	private String expense_id;
	public String getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(String expense_id) {
		this.expense_id = expense_id;
	}
	private String exp_parti;
	
	public String getExp_parti() {
		return exp_parti;
	}
	public void setExp_parti(String exp_parti) {
		this.exp_parti = exp_parti;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
}