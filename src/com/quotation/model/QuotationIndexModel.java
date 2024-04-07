package com.quotation.model;

import java.util.List;

public class QuotationIndexModel {
	
	private int index_id;
	private String name_of_index;
	private String sub_name_of_index[];
	private String subindex;
	private String quotation_name;
	private String selectQuotationName[];
	private String select_quoatation_name;
	private String lead_no;
	
	//finalization
	
	public String getLead_no() {
		return lead_no;
	}
	public void setLead_no(String lead_no) {
		this.lead_no = lead_no;
	}

	private int id;
	private String customer_name;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	private int quotation_id;
	private String finalized_amount;
	private String token_amount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFinalized_amount() {
		return finalized_amount;
	}
	public void setFinalized_amount(String finalized_amount) {
		this.finalized_amount = finalized_amount;
	}
	public String getToken_amount() {
		return token_amount;
	}
	public void setToken_amount(String token_amount) {
		this.token_amount = token_amount;
	}
	
	//end finalization
	
	private String checkbox;
	
	private String select_quot[];
	
	public String[] getSelect_quot() {
		return select_quot;
	}
	public void setSelect_quot(String[] select_quot) {
		this.select_quot = select_quot;
	}
	public String getCheckbox() {
		return checkbox;
	}
	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}
	private String quot_id;
	
	public String getSelect_quoatation_name() {
		return select_quoatation_name;
	}
	public void setSelect_quoatation_name(String select_quoatation_name) {
		this.select_quoatation_name = select_quoatation_name;
	}
	private String myarrays[];
	private int mysize;
	private String mycheckbox[];
	
	public String getQuotation_name() {
		return quotation_name;
	}
	public void setQuotation_name(String quotation_name) {
		this.quotation_name = quotation_name;
	}
	public String[] getSelectQuotationName() {
		return selectQuotationName;
	}
	public void setSelectQuotationName(String[] selectQuotationName) {
		this.selectQuotationName = selectQuotationName;
	}
	public int getMysize() {
		return mysize;
	}
	public void setMysize(int mysize) {
		this.mysize = mysize;
	}
	public int getIndex_id() {
		return index_id;
	}
	public void setIndex_id(int index_id) {
		this.index_id = index_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String[] getSub_name_of_index() {
		return sub_name_of_index;
	}
	public void setSub_name_of_index(String[] sub_name_of_index) {
		this.sub_name_of_index = sub_name_of_index;
	}
	public String getSubindex() {
		return subindex;
	}
	public void setSubindex(String subindex) {
		this.subindex = subindex;
	}
	
	public String[] getMyarrays() {
		return myarrays;
	}
	public void setMyarrays(String[] myarrays) {
		this.myarrays = myarrays;
	}
	public String[] getMycheckbox() {
		return mycheckbox;
	}
	public void setMycheckbox(String mycheckbox[]) {
		this.mycheckbox = mycheckbox;
	}
	public String getQuot_id() {
		return quot_id;
	}
	public void setQuot_id(String quot_id) {
		this.quot_id = quot_id;
	}
	public int getQuotation_id() {
		return quotation_id;
	}
	public void setQuotation_id(int quotation_id) {
		this.quotation_id = quotation_id;
	}
	
}
