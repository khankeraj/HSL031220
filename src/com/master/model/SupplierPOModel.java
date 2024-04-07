package com.master.model;

public class SupplierPOModel {
	private int supp_id;
	private String supplier_po_status;
	private String customer_name;
	
	public int getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(int supp_id) {
		this.supp_id = supp_id;
	}
	public String getSupplier_po_status() {
		return supplier_po_status;
	}
	public void setSupplier_po_status(String supplier_po_status) {
		this.supplier_po_status = supplier_po_status;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

}
