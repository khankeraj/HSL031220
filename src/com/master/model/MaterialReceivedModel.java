package com.master.model;

public class MaterialReceivedModel {
	private int material_id;
	private String received_material_status;
	private String customer_name;
	private String date;
	private String pono;
	private String customer_code;
	private String material_code;
	private String material_code1;
	private String remain;
	private String balance_qty;
	private String material_num;
	private String supplier;
	private String supplier_id;
	
	
	public String getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	private String[] description;
	private String[] quantity;
	private String[] receivedquantity;
	
	
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String[] getReceivedquantity() {
		return receivedquantity;
	}
	public void setReceivedquantity(String[] receivedquantity) {
		this.receivedquantity = receivedquantity;
	}
	public String getMaterial_num() {
		return material_num;
	}
	public void setMaterial_num(String material_num) {
		this.material_num = material_num;
	}
	public String getMaterial_code() {
		return material_code;
	}
	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getBalance_qty() {
		return balance_qty;
	}
	public void setBalance_qty(String balance_qty) {
		this.balance_qty = balance_qty;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public void setMaterial_id(int materil_id) {
		this.material_id = materil_id;
	}
	public String getReceived_material_status() {
		return received_material_status;
	}
	public void setReceived_material_status(String received_material_status) {
		this.received_material_status = received_material_status;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMaterial_code1() {
		return material_code1;
	}
	public void setMaterial_code1(String material_code1) {
		this.material_code1 = material_code1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return customer_code+" "+customer_name+" "+supplier;
	}
}
