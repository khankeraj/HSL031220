package com.master.model;

import java.util.ArrayList;
import java.util.List;

public class Payment1Model {
	
	
	private String[] commcheck;
	
	
	
	
	
	
	
	public String[] getCommcheck() {
		return commcheck;
	}
	public void setCommcheck(String[] commcheck) {
		this.commcheck = commcheck;
	}

	private String receipt_no;
	private String paid_amount;
	private String date;
	private String transporter_code;
	
	
	public String getTransporter_code() {
		return transporter_code;
	}
	public void setTransporter_code(String transporter_code) {
		this.transporter_code = transporter_code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReceipt_no() {
		return receipt_no;
	}
	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	public String getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(String paid_amount) {
		this.paid_amount = paid_amount;
	}

	private String transporter_address;
	private String transporter_mobile;
	private String city;
	private String company;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTransporter_address() {
		return transporter_address;
	}
	public void setTransporter_address(String transporter_address) {
		this.transporter_address = transporter_address;
	}
	public String getTransporter_mobile() {
		return transporter_mobile;
	}
	public void setTransporter_mobile(String transporter_mobile) {
		this.transporter_mobile = transporter_mobile;
	}

	private String transporter_name;
	private String total_amount;
	private String pay_mode;
	private String voucher_no;
	private String paytype;
	private String paymod;
	private String net_amount;
	private String cash_amt;
	private String bankname;
	private String bankname22;
	private String cheque_no;
	private String cheque_amt;
	private String cheque_date;
	private String chkno2;
	private String amt2;
	private String chkdate2;
	private String chkno3;
	private String amt3;
	private String chkdate3;
	private String transcation_id;
	private String suppliername;
	private String supplierbankname;
	private String suppliercity;
	private String verifyby;
	private String remark;
	private String payment_date;
	
	
	
	private String customer_name;
	private String inv1[];
	private String invcheck[];
	private String d11[]; 
	private String totamt1[]; 
	private String reamt1[]; 
	
	public String[] getD11() {
		return d11;
	}
	public void setD11(String[] d11) {
		this.d11 = d11;
	}
	public String[] getTotamt1() {
		return totamt1;
	}
	public void setTotamt1(String[] totamt1) {
		this.totamt1 = totamt1;
	}
	public String[] getReamt1() {
		return reamt1;
	}
	public void setReamt1(String[] reamt1) {
		this.reamt1 = reamt1;
	}
	public String[] getInvcheck() {
		return invcheck;
	}
	public void setInvcheck(String[] invcheck) {
		this.invcheck = invcheck;
	}
	public String[] getInv1() {
		return inv1;
	}
	public void setInv1(String[] inv1) {
		this.inv1 = inv1;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPayment_date() {
		return payment_date;
	}
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPaymod() {
		return paymod;
	}
	public void setPaymod(String paymod) {
		this.paymod = paymod;
	}
	public String getNet_amount() {
		return net_amount;
	}
	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}
	public String getCash_amt() {
		return cash_amt;
	}
	public void setCash_amt(String cash_amt) {
		this.cash_amt = cash_amt;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankname22() {
		return bankname22;
	}
	public void setBankname22(String bankname22) {
		this.bankname22 = bankname22;
	}
	public String getCheque_no() {
		return cheque_no;
	}
	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}
	public String getCheque_amt() {
		return cheque_amt;
	}
	public void setCheque_amt(String cheque_amt) {
		this.cheque_amt = cheque_amt;
	}
	public String getCheque_date() {
		return cheque_date;
	}
	public void setCheque_date(String cheque_date) {
		this.cheque_date = cheque_date;
	}
	public String getChkno2() {
		return chkno2;
	}
	public void setChkno2(String chkno2) {
		this.chkno2 = chkno2;
	}
	public String getAmt2() {
		return amt2;
	}
	public void setAmt2(String amt2) {
		this.amt2 = amt2;
	}
	public String getChkdate2() {
		return chkdate2;
	}
	public void setChkdate2(String chkdate2) {
		this.chkdate2 = chkdate2;
	}
	public String getChkno3() {
		return chkno3;
	}
	public void setChkno3(String chkno3) {
		this.chkno3 = chkno3;
	}
	public String getAmt3() {
		return amt3;
	}
	public void setAmt3(String amt3) {
		this.amt3 = amt3;
	}
	public String getChkdate3() {
		return chkdate3;
	}
	public void setChkdate3(String chkdate3) {
		this.chkdate3 = chkdate3;
	}
	public String getTranscation_id() {
		return transcation_id;
	}
	public void setTranscation_id(String transcation_id) {
		this.transcation_id = transcation_id;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSupplierbankname() {
		return supplierbankname;
	}
	public void setSupplierbankname(String supplierbankname) {
		this.supplierbankname = supplierbankname;
	}
	public String getSuppliercity() {
		return suppliercity;
	}
	public void setSuppliercity(String suppliercity) {
		this.suppliercity = suppliercity;
	}
	public String getVerifyby() {
		return verifyby;
	}
	public void setVerifyby(String verifyby) {
		this.verifyby = verifyby;
	}
	public String getVoucher_no() {
		return voucher_no;
	}
	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
	}


	private int spare_size;
	
	public int getSpare_size() {
		return spare_size;
	}
	public void setSpare_size(int spare_size) {
		this.spare_size = spare_size;
	}
	public String getTransporter_name() {
		return transporter_name;
	}
	public void setTransporter_name(String transporter_name) {
		this.transporter_name = transporter_name;
	}
	public String getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}
	public String getPay_mode() {
		return pay_mode;
	}
	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	public List<String> getTrip_id2() {
		return trip_id2;
	}
	public void setTrip_id2(List<String> trip_id2) {
		this.trip_id2 = trip_id2;
	}
	public List<String> getUpdown_id2() {
		return updown_id2;
	}
	public void setUpdown_id2(List<String> updown_id2) {
		this.updown_id2 = updown_id2;
	}
	public List<String> getLr_number2() {
		return lr_number2;
	}
	public void setLr_number2(List<String> lr_number2) {
		this.lr_number2 = lr_number2;
	}
	public List<String> getCommision2() {
		return commision2;
	}
	public void setCommision2(List<String> commision2) {
		this.commision2 = commision2;
	}
	public List<String> getRemaining_amount2() {
		return remaining_amount2;
	}
	public void setRemaining_amount2(List<String> remaining_amount2) {
		this.remaining_amount2 = remaining_amount2;
	}
	
	
	List<String> trip_id2 = new ArrayList<String>();
	List<String> updown_id2 = new ArrayList<String>();
	List<String> lr_number2 = new ArrayList<String>();
	List<String> commision2 = new ArrayList<String>();
	List<String> remaining_amount2 = new ArrayList<String>();
	List<String> date2 = new ArrayList<String>();

	public List<String> getDate2() {
		return date2;
	}
	public void setDate2(List<String> date2) {
		this.date2 = date2;
	}
	
	
}
