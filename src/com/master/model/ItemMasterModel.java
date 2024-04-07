package com.master.model;

public class ItemMasterModel {

	private int id;
	private String item_name;
	private String part_no;
	private String unit;
	private String buy_price;
	private String sale_price;
	private String hsn_code;
	private String tax_per;
	private String minimum_quantity;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getPart_no() {
		return part_no;
	}
	public void setPart_no(String part_no) {
		this.part_no = part_no;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(String buy_price) {
		this.buy_price = buy_price;
	}
	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	public String getHsn_code() {
		return hsn_code;
	}
	public void setHsn_code(String hsn_code) {
		this.hsn_code = hsn_code;
	}
	public String getTax_per() {
		return tax_per;
	}
	public void setTax_per(String tax_per) {
		this.tax_per = tax_per;
	}
	public String getMinimum_quantity() {
		return minimum_quantity;
	}
	public void setMinimum_quantity(String minimum_quantity) {
		this.minimum_quantity = minimum_quantity;
	}
	
}
