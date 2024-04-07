package com.master.model;

import java.io.File;

public class DeliveryModel{
	
	private String transporter_code;
	
	
	public String getTransporter_code() {
		return transporter_code;
	}

	public void setTransporter_code(String transporter_code) {
		this.transporter_code = transporter_code;
	}

	private String trip_expense;
	private String updown_expense;
	private String lr_expense;
	private String total_expense;
	private String profit;
	private String this_month;
	private String previous_month;
	
	
	private String cgst25;
	private String cgst6;
	private String cgst9;
	private String cgst14;
	private String sgst25;
	private String sgst6;
	private String sgst9;
	private String sgst14;
	private String inquiry_id;
	
	
	
	private String customet_name[];
	
	private String from[];
	private String vehicelno[];
	private String drivername[];
	
	private String billno1[];
	private String date1[];
	private String billlamount1[];
	private String advance1[];
	private String advanceamt1[];
	private String remanamount1[];
	
	private String vendorname1[];
	private String vendorcode1[];
	private String bill_id[];
	

	
	

	public String[] getBill_id() {
		return bill_id;
	}

	public void setBill_id(String[] bill_id) {
		this.bill_id = bill_id;
	}

	public String[] getVendorcode1() {
		return vendorcode1;
	}

	public void setVendorcode1(String[] vendorcode1) {
		this.vendorcode1 = vendorcode1;
	}

	public String[] getVendorname1() {
		return vendorname1;
	}

	public void setVendorname1(String[] vendorname1) {
		this.vendorname1 = vendorname1;
	}

	public String[] getBillno1() {
		return billno1;
	}

	public void setBillno1(String[] billno1) {
		this.billno1 = billno1;
	}

	public String[] getDate1() {
		return date1;
	}

	public void setDate1(String[] date1) {
		this.date1 = date1;
	}

	public String[] getBilllamount1() {
		return billlamount1;
	}

	public void setBilllamount1(String[] billlamount1) {
		this.billlamount1 = billlamount1;
	}

	public String[] getAdvance1() {
		return advance1;
	}

	public void setAdvance1(String[] advance1) {
		this.advance1 = advance1;
	}

	public String[] getAdvanceamt1() {
		return advanceamt1;
	}

	public void setAdvanceamt1(String[] advanceamt1) {
		this.advanceamt1 = advanceamt1;
	}

	public String[] getRemanamount1() {
		return remanamount1;
	}

	public void setRemanamount1(String[] remanamount1) {
		this.remanamount1 = remanamount1;
	}

	public String[] getFrom() {
		return from;
	}

	public void setFrom(String[] from) {
		this.from = from;
	}

	public String[] getVehicelno() {
		return vehicelno;
	}

	public void setVehicelno(String[] vehicelno) {
		this.vehicelno = vehicelno;
	}

	public String[] getDrivername() {
		return drivername;
	}

	public void setDrivername(String[] drivername) {
		this.drivername = drivername;
	}

	public String[] getCustomet_name() {
		return customet_name;
	}

	public void setCustomet_name(String[] customet_name) {
		this.customet_name = customet_name;
	}

	public String getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	private String print_file;
	
	
	

	public String getPrint_file() {
		return print_file;
	}

	public void setPrint_file(String print_file) {
		this.print_file = print_file;
	}

	private String invtype;
	
	
	public String getCgst25() {
		return cgst25;
	}

	public void setCgst25(String cgst25) {
		this.cgst25 = cgst25;
	}

	public String getCgst6() {
		return cgst6;
	}

	public void setCgst6(String cgst6) {
		this.cgst6 = cgst6;
	}

	public String getCgst9() {
		return cgst9;
	}

	public void setCgst9(String cgst9) {
		this.cgst9 = cgst9;
	}

	public String getCgst14() {
		return cgst14;
	}

	public void setCgst14(String cgst14) {
		this.cgst14 = cgst14;
	}

	public String getSgst25() {
		return sgst25;
	}

	public void setSgst25(String sgst25) {
		this.sgst25 = sgst25;
	}

	public String getSgst6() {
		return sgst6;
	}

	public void setSgst6(String sgst6) {
		this.sgst6 = sgst6;
	}

	public String getSgst9() {
		return sgst9;
	}

	public void setSgst9(String sgst9) {
		this.sgst9 = sgst9;
	}

	public String getSgst14() {
		return sgst14;
	}

	public void setSgst14(String sgst14) {
		this.sgst14 = sgst14;
	}

	public String getTcgst25() {
		return tcgst25;
	}

	public void setTcgst25(String tcgst25) {
		this.tcgst25 = tcgst25;
	}

	public String getTcgst6() {
		return tcgst6;
	}

	public void setTcgst6(String tcgst6) {
		this.tcgst6 = tcgst6;
	}

	public String getTcgst9() {
		return tcgst9;
	}

	public void setTcgst9(String tcgst9) {
		this.tcgst9 = tcgst9;
	}

	public String getTcgst14() {
		return tcgst14;
	}

	public void setTcgst14(String tcgst14) {
		this.tcgst14 = tcgst14;
	}

	public String getTsgst25() {
		return tsgst25;
	}

	public void setTsgst25(String tsgst25) {
		this.tsgst25 = tsgst25;
	}

	public String getTsgst6() {
		return tsgst6;
	}

	public void setTsgst6(String tsgst6) {
		this.tsgst6 = tsgst6;
	}

	public String getTsgst9() {
		return tsgst9;
	}

	public void setTsgst9(String tsgst9) {
		this.tsgst9 = tsgst9;
	}

	public String getTsgst14() {
		return tsgst14;
	}

	public void setTsgst14(String tsgst14) {
		this.tsgst14 = tsgst14;
	}

	private String  tcgst25;
	private String  tcgst6;
	private String  tcgst9;
	private String  tcgst14;
	
	private String  tsgst25;
	private String  tsgst6;
	private String  tsgst9;
	private String  tsgst14;
	
	
	public String getThis_month() {
		return this_month;
	}

	public void setThis_month(String this_month) {
		this.this_month = this_month;
	}

	public String getPrevious_month() {
		return previous_month;
	}

	public void setPrevious_month(String previous_month) {
		this.previous_month = previous_month;
	}

	public String getProfit() {
		
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getTrip_expense() {
		return trip_expense;
	}

	public void setTrip_expense(String trip_expense) {
		this.trip_expense = trip_expense;
	}

	public String getUpdown_expense() {
		return updown_expense;
	}

	public void setUpdown_expense(String updown_expense) {
		this.updown_expense = updown_expense;
	}

	public String getLr_expense() {
		return lr_expense;
	}

	public void setLr_expense(String lr_expense) {
		this.lr_expense = lr_expense;
	}

	public String getTotal_expense() {
		return total_expense;
	}

	public void setTotal_expense(String total_expense) {
		this.total_expense = total_expense;
	}

	private String address;
	private String state;
	private String mobile;
	
	private String comm_sum;
	
	public String getComm_sum() {
		return comm_sum;
	}

	public void setComm_sum(String comm_sum) {
		this.comm_sum = comm_sum;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPending_amount() {
		return pending_amount;
	}

	public void setPending_amount(String pending_amount) {
		this.pending_amount = pending_amount;
	}

	private String trip_id;
	private String updown_id;
	private String updown;
	public String getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(String trip_id) {
		this.trip_id = trip_id;
	}

	public String getUpdown_id() {
		return updown_id;
	}

	public void setUpdown_id(String updown_id) {
		this.updown_id = updown_id;
	}

	public String getUpdown() {
		return updown;
	}

	public void setUpdown(String updown) {
		this.updown = updown;
	}

	private String delivery_done_id;
	public String getDelivery_done_id() {
		return delivery_done_id;
	}

	public void setDelivery_done_id(String delivery_done_id) {
		this.delivery_done_id = delivery_done_id;
	}

	
	
	
	private String lr_number;
	private String source;
	private String destination;
	private String customer_name;
	private String vehicle_no;
	private String driver_name;
	private String date;
	private String customer_no;
	private String driver_code;
	private String total_tax_amount;
	private String sn;
	private String cgst;
	private String sgst;
	private String gstin_no;
	private String pan_no;
	//private String state;
	private String city;
	//private String mobile;
	private String pending_amount;
	//private String address;
	
	
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

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getTotal_tax_amount() {
		return total_tax_amount;
	}

	public void setTotal_tax_amount(String total_tax_amount) {
		this.total_tax_amount = total_tax_amount;
	}

	public String getCustomer_no() {
		return customer_no;
	}

	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}

	public String getDriver_code() {
		return driver_code;
	}

	public void setDriver_code(String driver_code) {
		this.driver_code = driver_code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String loading;
	private String unloading;
	private String other;
	private String mathadi;
	
	private String description1;
	private String weight1;
	private String received_weight1;
	private String short_weight1;
	private String rate1;
	private String amount1;
	private String hsn1;
	private String tax_per1;
	
	private String gstrate1;
	private String gstrate2;
	private String gstamt1;
	private String gstamt2;
	private String net_amt1;
	
	
	public String getNet_amt1() {
		return net_amt1;
	}

	public void setNet_amt1(String net_amt1) {
		this.net_amt1 = net_amt1;
	}

	public String[] getNet_amt() {
		return net_amt;
	}

	public void setNet_amt(String[] net_amt) {
		this.net_amt = net_amt;
	}

	public String getGstrate1() {
		return gstrate1;
	}

	public void setGstrate1(String gstrate1) {
		this.gstrate1 = gstrate1;
	}

	public String getGstrate2() {
		return gstrate2;
	}

	public void setGstrate2(String gstrate2) {
		this.gstrate2 = gstrate2;
	}

	public String getGstamt1() {
		return gstamt1;
	}

	public void setGstamt1(String gstamt1) {
		this.gstamt1 = gstamt1;
	}

	public String getGstamt2() {
		return gstamt2;
	}

	public void setGstamt2(String gstamt2) {
		this.gstamt2 = gstamt2;
	}

	public String getHsn1() {
		return hsn1;
	}

	public void setHsn1(String hsn1) {
		this.hsn1 = hsn1;
	}

	public String getTax_per1() {
		return tax_per1;
	}

	public void setTax_per1(String tax_per1) {
		this.tax_per1 = tax_per1;
	}

	public String[] getHsn() {
		return hsn;
	}

	public void setHsn(String[] hsn) {
		this.hsn = hsn;
	}

	public String[] getTax_per() {
		return tax_per;
	}

	public void setTax_per(String[] tax_per) {
		this.tax_per = tax_per;
	}

	
	private String total_amount;
	private String short_amount;
	private String penalty_amount;
	private String commision;
	private String remaining_amount;
	
	
	public String getRemaining_amount() {
		return remaining_amount;
	}

	public void setRemaining_amount(String remaining_amount) {
		this.remaining_amount = remaining_amount;
	}

	private String commision_id;
	private String bill_no;
	
	
	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getCommision_id() {
		return commision_id;
	}

	public void setCommision_id(String commision_id) {
		this.commision_id = commision_id;
	}

	private String checkbox[];
	
	private String t1;

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	private String transporter_name;
	
	
	
	
	public String getTransporter_name() {
		return transporter_name;
	}

	public void setTransporter_name(String transporter_name) {
		this.transporter_name = transporter_name;
	}

	public String getCommision() {
		return commision;
	}

	public void setCommision(String commision) {
		this.commision = commision;
	}

	public String getPenalty_amount() {
		return penalty_amount;
	}

	public void setPenalty_amount(String penalty_amount) {
		this.penalty_amount = penalty_amount;
	}

	public String getShort_amount() {
		return short_amount;
	}

	public void setShort_amount(String short_amount) {
		this.short_amount = short_amount;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}

	public String getDescription1() {
		return description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getWeight1() {
		return weight1;
	}

	public void setWeight1(String weight1) {
		this.weight1 = weight1;
	}

	public String getReceived_weight1() {
		return received_weight1;
	}

	public void setReceived_weight1(String received_weight1) {
		this.received_weight1 = received_weight1;
	}

	public String getShort_weight1() {
		return short_weight1;
	}

	public void setShort_weight1(String short_weight1) {
		this.short_weight1 = short_weight1;
	}

	public String getRate1() {
		return rate1;
	}

	public void setRate1(String rate1) {
		this.rate1 = rate1;
	}

	public String getAmount1() {
		return amount1;
	}

	public void setAmount1(String amount1) {
		this.amount1 = amount1;
	}

	private String[] description;
	private String[] weight;
	private String[] received_weight;
	private String[] short_weight;
	private String[] rate;
	private String[] amount;
	private String[] hsn;
	private String[] tax_per;
	private String[] gst_rate1;
	private String[] gst_rate2;
	private String[] gst_rate1amt;
	private String[] gst_rate2amt;
	private String[] net_amt;
	private String[] penalty_amt;
	private String total_amount1;
	private String total_amt;
	
	private String invoiceno;
	
	
	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}

	public String getTotal_amount1() {
		return total_amount1;
	}

	public void setTotal_amount1(String total_amount1) {
		this.total_amount1 = total_amount1;
	}

	public String[] getPenalty_amt() {
		return penalty_amt;
	}

	public void setPenalty_amt(String[] penalty_amt) {
		this.penalty_amt = penalty_amt;
	}

	public String[] getGst_rate1() {
		return gst_rate1;
	}

	public void setGst_rate1(String[] gst_rate1) {
		this.gst_rate1 = gst_rate1;
	}

	public String[] getGst_rate2() {
		return gst_rate2;
	}

	public void setGst_rate2(String[] gst_rate2) {
		this.gst_rate2 = gst_rate2;
	}

	public String[] getGst_rate1amt() {
		return gst_rate1amt;
	}

	public void setGst_rate1amt(String[] gst_rate1amt) {
		this.gst_rate1amt = gst_rate1amt;
	}

	public String[] getGst_rate2amt() {
		return gst_rate2amt;
	}

	public void setGst_rate2amt(String[] gst_rate2amt) {
		this.gst_rate2amt = gst_rate2amt;
	}

	private String total_short_amount;
	
	
	public String[] getTrip_id1() {
		return trip_id1;
	}

	public void setTrip_id1(String[] trip_id1) {
		this.trip_id1 = trip_id1;
	}

	public String[] getUpdown_id1() {
		return updown_id1;
	}

	public void setUpdown_id1(String[] updown_id1) {
		this.updown_id1 = updown_id1;
	}

	public String[] getLr_number1() {
		return lr_number1;
	}

	public void setLr_number1(String[] lr_number1) {
		this.lr_number1 = lr_number1;
	}

	public String[] getSource1() {
		return source1;
	}

	public void setSource1(String[] source1) {
		this.source1 = source1;
	}

	public String[] getDestination1() {
		return destination1;
	}

	public void setDestination1(String[] destination1) {
		this.destination1 = destination1;
	}

	public String[] getVehicle_no1() {
		return vehicle_no1;
	}

	public void setVehicle_no1(String[] vehicle_no1) {
		this.vehicle_no1 = vehicle_no1;
	}

	public String[] getDriver_name1() {
		return driver_name1;
	}

	public void setDriver_name1(String[] driver_name1) {
		this.driver_name1 = driver_name1;
	}

	public String[] getCommision1() {
		return commision1;
	}

	public void setCommision1(String[] commision1) {
		this.commision1 = commision1;
	}

	private String[] trip_id1;
	private String[] updown_id1;
	private String[] lr_number1;
	private String[] source1;
	private String[] destination1;
	private String[] vehicle_no1;
	private String[] driver_name1;
	private String[] commision1;
	
	

	public String getLr_number() {
		return lr_number;
	}

	public void setLr_number(String lr_number) {
		this.lr_number = lr_number;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getDriver_name() {
		return driver_name;
	}

	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}

	public String getLoading() {
		return loading;
	}

	public void setLoading(String loading) {
		this.loading = loading;
	}

	public String getUnloading() {
		return unloading;
	}

	public void setUnloading(String unloading) {
		this.unloading = unloading;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getMathadi() {
		return mathadi;
	}

	public void setMathadi(String mathadi) {
		this.mathadi = mathadi;
	}

	public String[] getDescription() {
		return description;
	}

	public void setDescription(String[] description) {
		this.description = description;
	}

	public String[] getWeight() {
		return weight;
	}

	public void setWeight(String[] weight) {
		this.weight = weight;
	}

	public String[] getReceived_weight() {
		return received_weight;
	}

	public void setReceived_weight(String[] received_weight) {
		this.received_weight = received_weight;
	}

	public String[] getShort_weight() {
		return short_weight;
	}

	public void setShort_weight(String[] short_weight) {
		this.short_weight = short_weight;
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

	public String getTotal_short_amount() {
		return total_short_amount;
	}

	public void setTotal_short_amount(String total_short_amount) {
		this.total_short_amount = total_short_amount;
	}

	public String getInvtype() {
		return invtype;
	}

	public void setInvtype(String invtype) {
		this.invtype = invtype;
	}
	
	
	
}