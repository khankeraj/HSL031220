package com.master.model;

import java.util.ArrayList;
import java.util.List;

public class purchase_bean {
	private String from_date;
	private String to_date1;
	private int size;
	private String from_date22;
	private String to_date122;
	private String paybycashtotal;
	private String paybychequetotal;
	private String paybycardtotal;
	private String totalamtparts;
	private String totalamtlabour;
	private String totalamtlabourwct;
	private String totalnetamt;
	private String customername;
	private String model;
	private String invstatus;
	private String	cheque_date;
	private String cheque_no;
	private String cardid;
	private String insurance;
	private String carddd;
	private String pono;
	private String gstnno;
	private String panno;
	private String state;
	private String city;
	private String mobile;
	private String pendamt;
	private String mydate;
	private String payeterm;
	
	
	List<String> description = new ArrayList<String>();
	List<String> partno = new ArrayList<String>();
	List<String> qty = new ArrayList<String>();
	List<String> myrate = new ArrayList<String>();
	List<String> myamt = new ArrayList<String>();
	List<String> hsncode = new ArrayList<String>();
	List<String> disc = new ArrayList<String>();
	List<String> discamt = new ArrayList<String>();
	
	List<String> grate1 = new ArrayList<String>();
	List<String> gstamt1 = new ArrayList<String>();
	
	List<String> grate2 = new ArrayList<String>();
	List<String> gstamt2 = new ArrayList<String>();
	List<String> netamt = new ArrayList<String>();
	
	private int	mysize;
	private String iccr_no;
	private String Customer_Name;
	private String Address;
	private String Outstanding_Amount;
	private String paidamount;
	private String paymod;
	private String net_amount;
	private String ppamount;
	private String cash_amt;
	private String net_amountcard;
	private String paid_amt22;
	private String cashhh;
	private String response;
	private String cheque_amt;
	
	private String cgst25;
	private String cgst6;
	private String cgst9;
	private String cgst14;
	private String sgst25;
	private String sgst6;
	private String sgst9;
	private String sgst14;
	
	
	private String igst5;
	private String igst12;
	private String igst18;
	private String igst28;
	private String tigst5;
	private String tigst12;
	private String tigst18;
	private String tigst28;
	
	private String  tcgst25;
	private String  tcgst6;
	private String  tcgst9;
	private String  tcgst14;
	
	private String  tsgst25;
	private String  tsgst6;
	private String  tsgst9;
	private String  tsgst14;
	
	
	private String spare;
	private String qty1;
	private String unit;
	private String cust_id;
	private String vat9;
	
	private String enquiryid;
	private String source;
	private String destination;
	private String buyrate;
	private String brocker;
	private String status;
	private String remark;
	
	private String lrno;
	private String bookingby;
	private String sellrate;
	private String transporter;
	private String transporterref;
	private String totallr;
	private String vehicletype;
	private String vehiclebrkup;
	private String profit;
	private String customer;
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getVehiclebrkup() {
		return vehiclebrkup;
	}

	public void setVehiclebrkup(String vehiclebrkup) {
		this.vehiclebrkup = vehiclebrkup;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getTotallr() {
		return totallr;
	}

	public void setTotallr(String totallr) {
		this.totallr = totallr;
	}

	public String getTransporter() {
		return transporter;
	}

	public void setTransporter(String transporter) {
		this.transporter = transporter;
	}

	public String getTransporterref() {
		return transporterref;
	}

	public void setTransporterref(String transporterref) {
		this.transporterref = transporterref;
	}

	public String getSellrate() {
		return sellrate;
	}

	public void setSellrate(String sellrate) {
		this.sellrate = sellrate;
	}

	public String getBookingby() {
		return bookingby;
	}

	public void setBookingby(String bookingby) {
		this.bookingby = bookingby;
	}

	public String getLrno() {
		return lrno;
	}

	public void setLrno(String lrno) {
		this.lrno = lrno;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBrocker() {
		return brocker;
	}

	public void setBrocker(String brocker) {
		this.brocker = brocker;
	}

	public String getBuyrate() {
		return buyrate;
	}

	public void setBuyrate(String buyrate) {
		this.buyrate = buyrate;
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

	public String getEnquiryid() {
		return enquiryid;
	}

	public void setEnquiryid(String enquiryid) {
		this.enquiryid = enquiryid;
	}

	List<String> inv1 = new ArrayList<String>();
	List<String> d11 = new ArrayList<String>();
	List<String> totamt1 = new ArrayList<String>();
	List<String> reamt1 = new ArrayList<String>();
	List<String> recno = new ArrayList<String>();
	public List<String> getRecno() {
		return recno;
	}

	public void setRecno(List<String> recno) {
		this.recno = recno;
	}

	private int sparesize;
	
	public String getIgst5() {
		return igst5;
	}

	public void setIgst5(String igst5) {
		this.igst5 = igst5;
	}

	public String getIgst12() {
		return igst12;
	}

	public void setIgst12(String igst12) {
		this.igst12 = igst12;
	}

	public String getIgst18() {
		return igst18;
	}

	public void setIgst18(String igst18) {
		this.igst18 = igst18;
	}

	public String getIgst28() {
		return igst28;
	}

	public void setIgst28(String igst28) {
		this.igst28 = igst28;
	}

	public String getTigst5() {
		return tigst5;
	}

	public void setTigst5(String tigst5) {
		this.tigst5 = tigst5;
	}

	public String getTigst12() {
		return tigst12;
	}

	public void setTigst12(String tigst12) {
		this.tigst12 = tigst12;
	}

	public String getTigst18() {
		return tigst18;
	}

	public void setTigst18(String tigst18) {
		this.tigst18 = tigst18;
	}

	public String getTigst28() {
		return tigst28;
	}

	public void setTigst28(String tigst28) {
		this.tigst28 = tigst28;
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

	public String getSpare() {
		return spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}

	public String getQty1() {
		return qty1;
	}

	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public List<String> getPartno() {
		return partno;
	}

	public void setPartno(List<String> partno) {
		this.partno = partno;
	}

	public List<String> getQty() {
		return qty;
	}

	public void setQty(List<String> qty) {
		this.qty = qty;
	}

	public List<String> getMyrate() {
		return myrate;
	}

	public void setMyrate(List<String> myrate) {
		this.myrate = myrate;
	}

	public List<String> getMyamt() {
		return myamt;
	}

	public void setMyamt(List<String> myamt) {
		this.myamt = myamt;
	}

	public List<String> getHsncode() {
		return hsncode;
	}

	public void setHsncode(List<String> hsncode) {
		this.hsncode = hsncode;
	}

	public List<String> getDisc() {
		return disc;
	}

	public void setDisc(List<String> disc) {
		this.disc = disc;
	}

	public List<String> getDiscamt() {
		return discamt;
	}

	public void setDiscamt(List<String> discamt) {
		this.discamt = discamt;
	}

	public List<String> getGrate1() {
		return grate1;
	}

	public void setGrate1(List<String> grate1) {
		this.grate1 = grate1;
	}

	public List<String> getGstamt1() {
		return gstamt1;
	}

	public void setGstamt1(List<String> gstamt1) {
		this.gstamt1 = gstamt1;
	}

	public List<String> getGrate2() {
		return grate2;
	}

	public void setGrate2(List<String> grate2) {
		this.grate2 = grate2;
	}

	public List<String> getGstamt2() {
		return gstamt2;
	}

	public void setGstamt2(List<String> gstamt2) {
		this.gstamt2 = gstamt2;
	}

	public List<String> getNetamt() {
		return netamt;
	}

	public void setNetamt(List<String> netamt) {
		this.netamt = netamt;
	}

	public String getGstnno() {
		return gstnno;
	}

	public void setGstnno(String gstnno) {
		this.gstnno = gstnno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPendamt() {
		return pendamt;
	}

	public void setPendamt(String pendamt) {
		this.pendamt = pendamt;
	}

	public String getMydate() {
		return mydate;
	}

	public void setMydate(String mydate) {
		this.mydate = mydate;
	}

	public String getPayeterm() {
		return payeterm;
	}

	public void setPayeterm(String payeterm) {
		this.payeterm = payeterm;
	}

	public String getIccr_no() {
		return iccr_no;
	}

	public void setIccr_no(String iccr_no) {
		this.iccr_no = iccr_no;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getOutstanding_Amount() {
		return Outstanding_Amount;
	}

	public void setOutstanding_Amount(String outstanding_Amount) {
		Outstanding_Amount = outstanding_Amount;
	}

	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}

	public String getInvstatus() {
		return invstatus;
	}

	public void setInvstatus(String invstatus) {
		this.invstatus = invstatus;
	}

	private String insurancecompany;
	
	private String tparts;
	private String tlabour;
	private String tlabourwct;
	private String tot;
	private String bank;
	private String r1;
	private String billno;
	private String recidno;
	private String balance_amount;
	
	private String vat1;
	private String totvat;
	
	private String vat2;
	
	private String vat3;
	private String paid_amt;
	
	public String getVat2() {
		return vat2;
	}

	public void setVat2(String vat2) {
		this.vat2 = vat2;
	}

	public String getVat3() {
		return vat3;
	}

	public void setVat3(String vat3) {
		this.vat3 = vat3;
	}

	public String getVat4() {
		return vat4;
	}

	public void setVat4(String vat4) {
		this.vat4 = vat4;
	}

	public String getVat5() {
		return vat5;
	}

	public void setVat5(String vat5) {
		this.vat5 = vat5;
	}

	public String getVat6() {
		return vat6;
	}

	public void setVat6(String vat6) {
		this.vat6 = vat6;
	}

	private String vat4;
	
	private String vat5;
	private String vat6;
	
	
	
	
	
	
	public String getFrom_date22() {
		return from_date22;
	}

	public void setFrom_date22(String from_date22) {
		this.from_date22 = from_date22;
	}

	public String getTo_date122() {
		return to_date122;
	}

	public void setTo_date122(String to_date122) {
		this.to_date122 = to_date122;
	}

	private String dist_name;
	private String mobile_no;
	private String date;
	private String pay_mode;
	private String DC_no;
	private String amtinwords;
	public String getTotalamtparts() {
		return totalamtparts;
	}

	public void setTotalamtparts(String totalamtparts) {
		this.totalamtparts = totalamtparts;
	}

	public String getTotalamtlabour() {
		return totalamtlabour;
	}

	public void setTotalamtlabour(String totalamtlabour) {
		this.totalamtlabour = totalamtlabour;
	}

	private String total;
	private String invoice_no;
	private String job_card_no;
	private String vechicle_no;
	private String cust_name;
	private String mode;
	private String totalamount1;
	private String tax_type;
	private String tax_amt;
	private String type;
	private String cust_address;
	private String paybycash;
	private String paybycheque;
	public String[] getJob_card_no1() {
		return job_card_no1;
	}

	public void setJob_card_no1(String[] job_card_no1) {
		this.job_card_no1 = job_card_no1;
	}

	public String[] getVechicle_no1() {
		return vechicle_no1;
	}

	public void setVechicle_no1(String[] vechicle_no1) {
		this.vechicle_no1 = vechicle_no1;
	}

	public String[] getDate1() {
		return date1;
	}

	public void setDate1(String[] date1) {
		this.date1 = date1;
	}

	public String[] getPaid_amt1() {
		return paid_amt1;
	}

	public void setPaid_amt1(String[] paid_amt1) {
		this.paid_amt1 = paid_amt1;
	}

	public String[] getTot1() {
		return tot1;
	}

	public void setTot1(String[] tot1) {
		this.tot1 = tot1;
	}

	public String[] getInv_status1() {
		return inv_status1;
	}

	public void setInv_status1(String[] inv_status1) {
		this.inv_status1 = inv_status1;
	}

	private String paybycredit;
	private String CHEQUENO;
	private String job_card_no1[];
	private String vechicle_no1[];
	private String date1[];
	private String paid_amt1[];
	private String tot1[];
	private String inv_status1[];
	
	
	
	public String getTax_type() {
		return tax_type;
	}

	public void setTax_type(String tax_type) {
		this.tax_type = tax_type;
	}

	public String getTax_amt() {
		return tax_amt;
	}

	public void setTax_amt(String tax_amt) {
		this.tax_amt = tax_amt;
	}

	public String getDist_name() {
		return dist_name;
	}

	public String getJob_card_no() {
		return job_card_no;
	}

	public void setJob_card_no(String job_card_no) {
		this.job_card_no = job_card_no;
	}

	public String getVechicle_no() {
		return vechicle_no;
	}

	public void setVechicle_no(String vechicle_no) {
		this.vechicle_no = vechicle_no;
	}

	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDC_no() {
		return DC_no;
	}

	public void setDC_no(String dC_no) {
		DC_no = dC_no;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date1() {
		return to_date1;
	}

	public void setTo_date1(String to_date1) {
		this.to_date1 = to_date1;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}

	public String getTotalamount1() {
		return totalamount1;
	}

	public void setTotalamount1(String totalamount1) {
		this.totalamount1 = totalamount1;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public String getPaybycash() {
		return paybycash;
	}

	public void setPaybycash(String paybycash) {
		this.paybycash = paybycash;
	}

	public String getPaybycheque() {
		return paybycheque;
	}

	public void setPaybycheque(String paybycheque) {
		this.paybycheque = paybycheque;
	}

	public String getPaybycredit() {
		return paybycredit;
	}

	public void setPaybycredit(String paybycredit) {
		this.paybycredit = paybycredit;
	}

	public void setPaybycashtotal(String paybycashtotal) {
		this.paybycashtotal = paybycashtotal;
	}

	public String getPaybycashtotal() {
		return paybycashtotal;
	}

	public void setPaybychequetotal(String paybychequetotal) {
		this.paybychequetotal = paybychequetotal;
	}

	public String getPaybychequetotal() {
		return paybychequetotal;
	}

	public void setPaybycardtotal(String paybycardtotal) {
		this.paybycardtotal = paybycardtotal;
	}

	public String getPaybycardtotal() {
		return paybycardtotal;
	}

	public void setTotalnetamt(String totalnetamt) {
		this.totalnetamt = totalnetamt;
	}

	public String getTotalnetamt() {
		return totalnetamt;
	}

	public void setVat1(String vat1) {
		this.vat1 = vat1;
	}

	public String getVat1() {
		return vat1;
	}

	public void setTotvat(String totvat) {
		this.totvat = totvat;
	}

	public String getTotvat() {
		return totvat;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomername() {
		return customername;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setInsurancecompany(String insurancecompany) {
		this.insurancecompany = insurancecompany;
	}

	public String getInsurancecompany() {
		return insurancecompany;
	}

	public void setTparts(String tparts) {
		this.tparts = tparts;
	}

	public String getTparts() {
		return tparts;
	}

	public void setTlabour(String tlabour) {
		this.tlabour = tlabour;
	}

	public String getTlabour() {
		return tlabour;
	}

	public void setTot(String tot) {
		this.tot = tot;
	}

	public String getTot() {
		return tot;
	}

	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}

	public String getPaid_amt() {
		return paid_amt;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBank() {
		return bank;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public String getBillno() {
		return billno;
	}

	public void setRecidno(String recidno) {
		this.recidno = recidno;
	}

	public String getRecidno() {
		return recidno;
	}

	public void setAmtinwords(String amtinwords) {
		this.amtinwords = amtinwords;
	}

	public String getAmtinwords() {
		return amtinwords;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setCHEQUENO(String cHEQUENO) {
		CHEQUENO = cHEQUENO;
	}

	public String getCHEQUENO() {
		return CHEQUENO;
	}

	public void setBalance_amount(String balance_amount) {
		this.balance_amount = balance_amount;
	}

	public String getBalance_amount() {
		return balance_amount;
	}

	public void setPaymod(String paymod) {
		this.paymod = paymod;
	}

	public String getPaymod() {
		return paymod;
	}

	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}

	public String getNet_amount() {
		return net_amount;
	}

	public void setPpamount(String ppamount) {
		this.ppamount = ppamount;
	}

	public String getPpamount() {
		return ppamount;
	}

	public void setCash_amt(String cash_amt) {
		this.cash_amt = cash_amt;
	}

	public String getCash_amt() {
		return cash_amt;
	}

	public void setNet_amountcard(String net_amountcard) {
		this.net_amountcard = net_amountcard;
	}

	public String getNet_amountcard() {
		return net_amountcard;
	}

	public void setPaid_amt22(String paid_amt22) {
		this.paid_amt22 = paid_amt22;
	}

	public String getPaid_amt22() {
		return paid_amt22;
	}

	public void setCashhh(String cashhh) {
		this.cashhh = cashhh;
	}

	public String getCashhh() {
		return cashhh;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setCheque_amt(String cheque_amt) {
		this.cheque_amt = cheque_amt;
	}

	public String getCheque_amt() {
		return cheque_amt;
	}

	public void setCheque_date(String cheque_date) {
		this.cheque_date = cheque_date;
	}

	public String getCheque_date() {
		return cheque_date;
	}

	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}

	public String getCheque_no() {
		return cheque_no;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setCarddd(String carddd) {
		this.carddd = carddd;
	}

	public String getCarddd() {
		return carddd;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getR1() {
		return r1;
	}

	public void setTotalamtlabourwct(String totalamtlabourwct) {
		this.totalamtlabourwct = totalamtlabourwct;
	}

	public String getTotalamtlabourwct() {
		return totalamtlabourwct;
	}

	public void setTlabourwct(String tlabourwct) {
		this.tlabourwct = tlabourwct;
	}

	public String getTlabourwct() {
		return tlabourwct;
	}

	public int getMysize() {
		return mysize;
	}

	public void setMysize(int mysize) {
		this.mysize = mysize;
	}

	public String getVat9() {
		return vat9;
	}

	public void setVat9(String vat9) {
		this.vat9 = vat9;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public List<String> getInv1() {
		return inv1;
	}

	public void setInv1(List<String> inv1) {
		this.inv1 = inv1;
	}

	public List<String> getD11() {
		return d11;
	}

	public void setD11(List<String> d11) {
		this.d11 = d11;
	}

	public List<String> getTotamt1() {
		return totamt1;
	}

	public void setTotamt1(List<String> totamt1) {
		this.totamt1 = totamt1;
	}

	public List<String> getReamt1() {
		return reamt1;
	}

	public void setReamt1(List<String> reamt1) {
		this.reamt1 = reamt1;
	}

	public int getSparesize() {
		return sparesize;
	}

	public void setSparesize(int sparesize) {
		this.sparesize = sparesize;
	}

	public String getPono() {
		return pono;
	}

	public void setPono(String pono) {
		this.pono = pono;
	}

	

}
