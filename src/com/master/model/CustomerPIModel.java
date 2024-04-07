package com.master.model;

public class CustomerPIModel {

	private int customer_pi_id;
	private int cust_details_id;
	private String invoice_no;
	private String customer_code;
	private String customer_name;
	private String gstin_no;
	private String pan_no;
	private String state;
	private String city;
	private String mobile_no;
	private String pending_amt;
	private String requiredDate;
	private String address;
	private String po_no;
	private String po_date;
	private String total;
	private String feight;
	private String transport;
	private String totalamt;
	private String cgst;
	private String sgst;
	private String total_tax_amt;
	
	private String description[];
	private String quantity[];
	public int getCustomer_pi_id() {
		return customer_pi_id;
	}
	public void setCustomer_pi_id(int customer_pi_id) {
		this.customer_pi_id = customer_pi_id;
	}
	public int getCust_details_id() {
		return cust_details_id;
	}
	public void setCust_details_id(int cust_details_id) {
		this.cust_details_id = cust_details_id;
	}
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getGstin_no() {
		return gstin_no;
	}
	public void setGstin_no(String gstin_no) {
		this.gstin_no = gstin_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getPending_amt() {
		return pending_amt;
	}
	public void setPending_amt(String pending_amt) {
		this.pending_amt = pending_amt;
	}
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPo_no() {
		return po_no;
	}
	public void setPo_no(String po_no) {
		this.po_no = po_no;
	}
	public String getPo_date() {
		return po_date;
	}
	public void setPo_date(String po_date) {
		this.po_date = po_date;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getFeight() {
		return feight;
	}
	public void setFeight(String feight) {
		this.feight = feight;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(String totalamt) {
		this.totalamt = totalamt;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getTotal_tax_amt() {
		return total_tax_amt;
	}
	public void setTotal_tax_amt(String total_tax_amt) {
		this.total_tax_amt = total_tax_amt;
	}
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
	public String[] getRate() {
		return rate;
	}
	public void setRate(String[] rate) {
		this.rate = rate;
	}
	public String[] getAmount() {
		return amount;
	}
	public void setAmount(String[] amount) {
		this.amount = amount;
	}
	public String[] getHsn_code() {
		return hsn_code;
	}
	public void setHsn_code(String[] hsn_code) {
		this.hsn_code = hsn_code;
	}
	public String[] getRate1() {
		return rate1;
	}
	public void setRate1(String[] rate1) {
		this.rate1 = rate1;
	}
	public String[] getAmount1() {
		return amount1;
	}
	public void setAmount1(String[] amount1) {
		this.amount1 = amount1;
	}
	public String[] getRate2() {
		return rate2;
	}
	public void setRate2(String[] rate2) {
		this.rate2 = rate2;
	}
	public String[] getAmount2() {
		return amount2;
	}
	public void setAmount2(String[] amount2) {
		this.amount2 = amount2;
	}
	public String[] getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(String[] net_amount) {
		this.net_amount = net_amount;
	}
	private String rate[];
	private String amount[];
	private String hsn_code[];
	private String rate1[];
	private String amount1[];
	private String rate2[];
	private String amount2[];
	private String net_amount[];
	
	
	private String descript;
	private String qty;
	private String rt;
	private String amt;
	private String hsncode;
	private String rt1;
	private String amt1;
	private String rt2;
	private String amt2;
	private String netamt;
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getHsncode() {
		return hsncode;
	}
	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}
	public String getRt1() {
		return rt1;
	}
	public void setRt1(String rt1) {
		this.rt1 = rt1;
	}
	public String getAmt1() {
		return amt1;
	}
	public void setAmt1(String amt1) {
		this.amt1 = amt1;
	}
	public String getRt2() {
		return rt2;
	}
	public void setRt2(String rt2) {
		this.rt2 = rt2;
	}
	public String getAmt2() {
		return amt2;
	}
	public void setAmt2(String amt2) {
		this.amt2 = amt2;
	}
	public String getNetamt() {
		return netamt;
	}
	public void setNetamt(String netamt) {
		this.netamt = netamt;
	}
	
}
