package com.master.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

;
public class Product_Sale_Bean {

	private String address;
	private String tot_a;
	private String amount;
	
	private String chequenov[];
	private String chequedatev[];
	private String banknamev[];
	private String paymodv[];
	private String ammttv[];
	private String vid;
	private String vattin;
	private String unit[];
	private String unit1;
	private String tax_type;
	
	
	public String[] getChequenov() {
		return chequenov;
	}

	public void setChequenov(String[] chequenov) {
		this.chequenov = chequenov;
	}

	public String[] getChequedatev() {
		return chequedatev;
	}

	public void setChequedatev(String[] chequedatev) {
		this.chequedatev = chequedatev;
	}

	public String[] getBanknamev() {
		return banknamev;
	}

	public void setBanknamev(String[] banknamev) {
		this.banknamev = banknamev;
	}

	public String getProductamt() {
		return productamt;
	}

	public void setProductamt(String productamt) {
		this.productamt = productamt;
	}

	public String getVatper() {
		return vatper;
	}

	public void setVatper(String vatper) {
		this.vatper = vatper;
	}

	public String getTaxamt() {
		return taxamt;
	}

	public void setTaxamt(String taxamt) {
		this.taxamt = taxamt;
	}

	private String id;
	private String oldserialno;
	private String newserialno;
private String productamt;
private String productamt2[];
private String vatper;
private String taxamt;

	public String getOldserialno() {
		return oldserialno;
	}

	public void setOldserialno(String oldserialno) {
		this.oldserialno = oldserialno;
	}

	public String getNewserialno() {
		return newserialno;
	}

	public void setNewserialno(String newserialno) {
		this.newserialno = newserialno;
	}

	private String visit_type;
	private String service_type;
	private String service_done;
	public String getPms_code() {
		return pms_code;
	}

	public void setPms_code(String pms_code) {
		this.pms_code = pms_code;
	}

	public String getPms_qty() {
		return pms_qty;
	}

	public void setPms_qty(String pms_qty) {
		this.pms_qty = pms_qty;
	}

	private String foc;
	private String reason;
	private String assign_date;
	private String zone;
	private String part_replace;
	private String pms_code;
	private String pms_qty;

	public String getComplain_done() {
		return complain_done;
	}

	public void setComplain_done(String complain_done) {
		this.complain_done = complain_done;
	}

	private String complain_done;

	public String getVisit_type() {
		return visit_type;
	}

	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getService_done() {
		return service_done;
	}

	public void setService_done(String service_done) {
		this.service_done = service_done;
	}

	public String getFoc() {
		return foc;
	}

	public void setFoc(String foc) {
		this.foc = foc;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAssign_date() {
		return assign_date;
	}

	public void setAssign_date(String assign_date) {
		this.assign_date = assign_date;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getPart_replace() {
		return part_replace;
	}

	public void setPart_replace(String part_replace) {
		this.part_replace = part_replace;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTot_a() {
		return tot_a;
	}

	public void setTot_a(String tot_a) {
		this.tot_a = tot_a;
	}

	private String amc_expiry_date;

	private double AMOUNT_PAID;

	private String amtpert;
	private String fromcounter;
	private String tocounter;
	private String area;
	private String date;

	private String balance_amt;

	private String bankname;

	private String cash_amt;

	private String cashcredit;

	private String cashdebit;

	private String cheque_amt;

	private String cheque_date;

	private String cheque_no;

	private String cheque_status;

	private String chequecredit;
	private String chequedebit;
	private String credit;
	private String CreditNote;
	private String cust_code;
	private String cust_id;
	private String cust_name;
	private String cust_type;
	private String customer_paid_amt;
	private String date1;
	private String datediff;
	private String dc_date;
	private String dc_no;
	private String dealer_id;
	private String debit;
	private String DebitNote;
	private String delader;
	private String discount;
	private String Documentsno;
	private String emp_code;
	private String feedbakID;
	private String finalbalanccecredit;
	private String finalbalanccedebit;
	private String finalbalance;

	private String finalbalancecredit;
	private String finalbalancedebit;

	private String storecredit;
	private String storedebit;
	private String accountscredit;
	private String accountsdebit;
	private String accountsbalance;
	private String storebalance;
	private String storetransfer;
	private String accountstransfer;
	private String cashgiventosir;
	private String cashgiventosir2;

	private String initialbalstore;
	private String initialbalaccounts;

	private String flagservicenotgiven;
	private String from_date;
	private String gatepassno;
	private int ic;
	private String iccrno;
	private String icr_no;
	private String initialbalance;
	private String Installation_cupan;
	private String invoice_no;
	private String invoice_status;
	private String invoiceno;
	private int iw;
	private int iw_period1;
	private int iw_service;
	private String landlineno;
	private String landlineno1;
	private String landlineno2;
	private String last_service;
	private String mobile_no1;
	private String mobno1;
	private String mobno2;
	private String modelno;
	private String msg;
	private String qty2[];
	private String net_amount;
	private int no_of_service;
	private int oc;

	private int ow;

	private String ow_sms;

	private String ow_sms_date;

	private String paid_amt;

	private String payment_date;

	private String payment_status;

	private String paymod;

	private String pcode;

	private String price;

	private String prn_no;
	private String prod_id;

	private String product_code;
	public String[] getProduct_amt() {
		return product_amt;
	}

	public void setProduct_amt(String[] product_amt) {
		this.product_amt = product_amt;
	}

	public String[] getTax_amt() {
		return tax_amt;
	}

	public void setTax_amt(String[] tax_amt) {
		this.tax_amt = tax_amt;
	}

	private String product_expiry_date[];
	private String product_name[];
	
	
	private String product_amt[];
	private String tax_amt[];
	
	private String price1[];
	private String product_status;
	private String qty;
	private String qty1;
	private String recptno;

	private String remark;
	private String remark1;
	private String response;
	private String sale_date;
	private List<String> selectthis = new ArrayList<String>();
	private int sno;
	private String spare_code;
	private String spare_rate;
	private String ST_Id;

	private String to_date;
	private String to_date1;
	private int total_amc;
	private String total_amt;
	private long total_dealersale;
	private long total_expenses;
	private int total_feedback;
	private int total_product;

	private long total_spare;
	private String transactiondate;
	private String transactiondetail;
	private String transactionremark;
	private String transcation_id;
	private String type;

	private String type1;
	private String unit_no[];
	
	 
	private String ppaymod[];
	private String pamount[];
	private String pbankname[];
	private String chequedate[];
	private String chequeno[];
	private String voucherno[];
	private String voucherno1[];

	public String[] getPpaymod() {
		return ppaymod;
	}

	public void setPpaymod(String[] ppaymod) {
		this.ppaymod = ppaymod;
	}

	public String[] getPamount() {
		return pamount;
	}

	public void setPamount(String[] pamount) {
		this.pamount = pamount;
	}

	public String[] getPbankname() {
		return pbankname;
	}

	public void setPbankname(String[] pbankname) {
		this.pbankname = pbankname;
	}

	public String[] getChequedate() {
		return chequedate;
	}

	public void setChequedate(String[] chequedate) {
		this.chequedate = chequedate;
	}

	public String[] getChequeno() {
		return chequeno;
	}

	public void setChequeno(String[] chequeno) {
		this.chequeno = chequeno;
	}

	private String unitno;
	private String username;

	private String voucher_no;

	private String warranty_status;

	public String getAddress() {
		return address;
	}

	public String getAmc_expiry_date() {
		return amc_expiry_date;
	}

	public double getAMOUNT_PAID() {
		return AMOUNT_PAID;
	}

	public String getAmtpert() {
		return amtpert;
	}

	public String getArea() {
		return area;
	}

	public String getBalance_amt() {
		return balance_amt;
	}

	public String getBankname() {
		return bankname;
	}

	public String getCash_amt() {
		return cash_amt;
	}

	public String getCashcredit() {
		return cashcredit;
	}

	public String getCashdebit() {
		return cashdebit;
	}

	public String getCheque_amt() {
		return cheque_amt;
	}

	public String getCheque_date() {
		return cheque_date;
	}

	public String getCheque_no() {
		return cheque_no;
	}

	/**
	 * @return the cheque_status
	 */
	public String getCheque_status() {
		return cheque_status;
	}

	public String getChequecredit() {
		return chequecredit;
	}

	public String getChequedebit() {
		return chequedebit;
	}

	public String getCredit() {
		return credit;
	}

	public String getCreditNote() {
		return CreditNote;
	}

	public String getCust_code() {
		return cust_code;
	}

	public String getCust_id() {
		return cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public String getCust_type() {
		return cust_type;
	}

	/**
	 * @return the customer_paid_amt
	 */
	public String getCustomer_paid_amt() {
		return customer_paid_amt;
	}

	public String getDate1() {
		return date1;
	}

	/**
	 * @return the datediff
	 */
	public String getDatediff() {
		return datediff;
	}

	public String getDc_date() {
		return dc_date;
	}

	public String getDc_no() {
		return dc_no;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public String getDebit() {
		return debit;
	}

	public String getDebitNote() {
		return DebitNote;
	}

	public String getDelader() {
		return delader;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	public String getDocumentsno() {
		return Documentsno;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public String getFeedbakID() {
		return feedbakID;
	}

	public String getFinalbalanccecredit() {
		return finalbalanccecredit;
	}

	public String getFinalbalanccedebit() {
		return finalbalanccedebit;
	}

	public String getFinalbalance() {
		return finalbalance;
	}

	public String getFinalbalancecredit() {
		return finalbalancecredit;
	}

	public String getFinalbalancedebit() {
		return finalbalancedebit;
	}

	public String getFlagservicenotgiven() {
		return flagservicenotgiven;
	}

	public String getFrom_date() {
		return from_date;
	}

	public String getGatepassno() {
		return gatepassno;
	}

	public int getIc() {
		return ic;
	}

	public String getIccrno() {
		return iccrno;
	}

	public String getIcr_no() {
		return icr_no;
	}

	public String getInitialbalance() {
		return initialbalance;
	}

	public String getInstallation_cupan() {
		return Installation_cupan;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public String getInvoice_status() {
		return invoice_status;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	/**
	 * @return the sno
	 */
	public int getIw() {
		return iw;

	}

	/**
	 * @param iw_period1
	 *            the iw_period1 to set
	 */
	public int getIw_period1() {
		return iw_period1;
	}

	public int getIw_service() {
		return iw_service;
	}

	public String getLandlineno() {
		return landlineno;
	}

	public String getLandlineno1() {
		return landlineno1;
	}

	public String getLandlineno2() {
		return landlineno2;
	}

	/**
	 * @return the last_service
	 */
	public String getLast_service() {
		return last_service;
	}

	public String getMobile_no1() {
		return mobile_no1;
	}

	public String getMobno1() {
		return mobno1;
	}

	public String getMobno2() {
		return mobno2;
	}

	public String getModelno() {
		return modelno;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * @return the net_amount
	 */
	public String getNet_amount() {
		return net_amount;
	}

	public int getNo_of_service() {
		return no_of_service;
	}

	public int getOc() {
		return oc;
	}

	public int getOw() {
		return ow;
	}

	public String getOw_sms() {
		return ow_sms;
	}

	public String getOw_sms_date() {
		return ow_sms_date;
	}

	public String getPaid_amt() {
		return paid_amt;
	}

	/**
	 * @return the payment_date
	 */
	public String getPayment_date() {
		return payment_date;
	}

	/**
	 * @param iw_period
	 *            the iw_period to set
	 */

	/**
	 * @return the payment_status
	 */
	public String getPayment_status() {
		return payment_status;
	}

	public String getPaymod() {
		return paymod;
	}

	/**
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;

	}

	public String getPrice() {
		return price;
	}

	public String getPrn_no() {
		return prn_no;
	}

	public String getProd_id() {
		return prod_id;
	}

	/**
	 * @param iw_service
	 *            the iw_service to set
	 */

	/**
	 * @param no_of_service_per_month
	 *            the no_of_service_per_month to set
	 */
	/**
	 * @param no_of_service
	 *            the no_of_service to set
	 */

	public String getProduct_code() {
		return product_code;
	}

	/**
	 * @return the product_expiry_date
	 */
	public String[] getProduct_expiry_date() {
		return product_expiry_date;
	}

	/**
	 * @return the sapre_name
	 */
	public String[] getProduct_name() {
		return product_name;
	}

	/**
	 * @return the product_status
	 */
	public String getProduct_status() {
		return product_status;
	}

	public String getQty() {
		return qty;
	}

	public String getQty1() {
		return qty1;
	}

	public String getRecptno() {
		return recptno;
	}

	public String getRemark() {
		return remark;
	}

	public String getRemark1() {
		return remark1;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	public String getSale_date() {
		return sale_date;
	}

	public List<String> getSelectthis() {
		return selectthis;
	}

	/**
	 * @return the sno
	 */
	public int getSno() {
		return sno;
	}

	public String getSpare_code() {
		return spare_code;
	}

	public String getSpare_rate() {
		return spare_rate;
	}

	public String getST_Id() {
		return ST_Id;
	}

	public String getTo_date() {
		return to_date;
	}

	public String getTo_date1() {
		return to_date1;
	}

	public int getTotal_amc() {
		return total_amc;
	}

	/**
	 * @return the total_amt
	 */
	public String getTotal_amt() {
		return total_amt;
	}

	public long getTotal_dealersale() {
		return total_dealersale;
	}

	public long getTotal_expenses() {
		return total_expenses;
	}

	public int getTotal_feedback() {
		return total_feedback;
	}

	public int getTotal_product() {
		return total_product;
	}

	public long getTotal_spare() {
		return total_spare;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public String getTransactiondetail() {
		return transactiondetail;
	}

	public String getTransactionremark() {
		return transactionremark;
	}

	public String getTranscation_id() {
		return transcation_id;
	}

	public String getType() {
		return type;
	}

	public String getType1() {
		return type1;
	}

	public String[] getUnit_no() {
		return unit_no;
	}

	/**
	 * @return the unitno
	 */
	public String getUnitno() {

		return unitno;

	}

	public String getUsername() {
		return username;
	}

	/**
	 * @return the voucher_no
	 */
	public String getVoucher_no() {
		return voucher_no;
	}

	public String getWarranty_status() {
		return warranty_status;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmc_expiry_date(String amc_expiry_date) {
		this.amc_expiry_date = amc_expiry_date;
	}

	public void setAMOUNT_PAID(double aMOUNT_PAID) {
		AMOUNT_PAID = aMOUNT_PAID;
	}

	public void setAmtpert(String amtpert) {
		this.amtpert = amtpert;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setBalance_amt(String balance_amt) {
		this.balance_amt = balance_amt;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setCash_amt(String cash_amt) {
		this.cash_amt = cash_amt;
	}

	public void setCashcredit(String cashcredit) {
		this.cashcredit = cashcredit;
	}

	public void setCashdebit(String cashdebit) {
		this.cashdebit = cashdebit;
	}

	public void setCheque_amt(String cheque_amt) {
		this.cheque_amt = cheque_amt;
	}

	public void setCheque_date(String cheque_date) {
		this.cheque_date = cheque_date;
	}

	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}

	/**
	 * @param cheque_status
	 *            the cheque_status to set
	 */
	public void setCheque_status(String cheque_status) {
		this.cheque_status = cheque_status;
	}

	public void setChequecredit(String chequecredit) {
		this.chequecredit = chequecredit;
	}

	public void setChequedebit(String chequedebit) {
		this.chequedebit = chequedebit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public void setCreditNote(String creditNote) {
		CreditNote = creditNote;
	}

	public void setCust_code(String cust_code) {
		this.cust_code = cust_code;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	/**
	 * @param customer_paid_amt
	 *            the customer_paid_amt to set
	 */
	public void setCustomer_paid_amt(String customer_paid_amt) {
		this.customer_paid_amt = customer_paid_amt;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	/**
	 * @param datediff
	 *            the datediff to set
	 */
	public void setDatediff(String datediff) {
		this.datediff = datediff;
	}

	public void setDc_date(String dc_date) {
		this.dc_date = dc_date;
	}

	public void setDc_no(String dc_no) {
		this.dc_no = dc_no;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public void setDebitNote(String debitNote) {
		DebitNote = debitNote;
	}

	public void setDelader(String delader) {
		this.delader = delader;
	}

	/**
	 * @param discount
	 *            the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public void setDocumentsno(String documentsno) {
		Documentsno = documentsno;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public void setFeedbakID(String feedbakID) {
		this.feedbakID = feedbakID;
	}

	public void setFinalbalanccecredit(String finalbalanccecredit) {
		this.finalbalanccecredit = finalbalanccecredit;
	}

	public void setFinalbalanccedebit(String finalbalanccedebit) {
		this.finalbalanccedebit = finalbalanccedebit;
	}

	public void setFinalbalance(String finalbalance) {
		this.finalbalance = finalbalance;
	}

	public void setFinalbalancecredit(String finalbalancecredit) {
		this.finalbalancecredit = finalbalancecredit;
	}

	public void setFinalbalancedebit(String finalbalancedebit) {
		this.finalbalancedebit = finalbalancedebit;
	}

	public void setFlagservicenotgiven(String flagservicenotgiven) {
		this.flagservicenotgiven = flagservicenotgiven;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public void setGatepassno(String gatepassno) {
		this.gatepassno = gatepassno;
	}

	public void setIc(int ic) {
		this.ic = ic;
	}

	public void setIccrno(String iccrno) {
		this.iccrno = iccrno;
	}

	public void setIcr_no(String icr_no) {
		this.icr_no = icr_no;
	}

	public void setInitialbalance(String initialbalance) {
		this.initialbalance = initialbalance;
	}

	public void setInstallation_cupan(String Installation_cupan) {
		this.Installation_cupan = Installation_cupan;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public void setInvoice_status(String invoice_status) {
		this.invoice_status = invoice_status;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public void setIw(int iw) {
		this.iw = iw;
		System.out.println("IW" + iw);

	}

	public void setIw_period1(int iw_period1) {
		this.iw_period1 = iw_period1;
	}

	public void setIw_service(int iw_service) {
		this.iw_service = iw_service;
	}

	public void setLandlineno(String landlineno) {
		this.landlineno = landlineno;
	}

	public void setLandlineno1(String landlineno1) {
		this.landlineno1 = landlineno1;
	}

	public void setLandlineno2(String landlineno2) {
		this.landlineno2 = landlineno2;
	}

	/**
	 * @param last_service
	 *            the last_service to set
	 */
	public void setLast_service(String last_service) {
		this.last_service = last_service;
	}

	public void setMobile_no1(String mobile_no1) {
		this.mobile_no1 = mobile_no1;
	}

	public void setMobno1(String mobno1) {
		this.mobno1 = mobno1;
	}

	public void setMobno2(String mobno2) {
		this.mobno2 = mobno2;
	}

	public void setModelno(String modelno) {
		this.modelno = modelno;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @param net_amount
	 *            the net_amount to set
	 */
	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}

	public void setNo_of_service(int no_of_service) {
		this.no_of_service = no_of_service;
	}

	public void setOc(int oc) {
		this.oc = oc;
	}

	public void setOw(int ow) {
		this.ow = ow;
	}

	public void setOw_sms(String ow_sms) {
		this.ow_sms = ow_sms;
	}

	public void setOw_sms_date(String ow_sms_date) {
		this.ow_sms_date = ow_sms_date;
	}

	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}

	/**
	 * @param payment_date
	 *            the payment_date to set
	 */
	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	/**
	 * @param payment_status
	 *            the payment_status to set
	 */
	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	public void setPaymod(String paymod) {
		this.paymod = paymod;
	}

	/**
	 * @param pcode
	 *            the pcode to set
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;

	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setPrn_no(String prn_no) {
		this.prn_no = prn_no;
	}

	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	/**
	 * @param product_expiry_date
	 *            the product_expiry_date to set
	 */
	public void setProduct_expiry_date(String product_expiry_date[]) {
		this.product_expiry_date = product_expiry_date;
	}

	public void setProduct_name(String product_name[]) {
		this.product_name = product_name;
	}

	/**
	 * @param product_status
	 *            the product_status to set
	 */
	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}

	public void setRecptno(String recptno) {
		this.recptno = recptno;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	/**
	 * @param response
	 *            the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}

	public void setSelectthis(List<String> selectthis) {
		this.selectthis = selectthis;
	}

	/**
	 * @param sno
	 *            the sno to set
	 */
	/**
	 * @param sno
	 *            the sno to set
	 */
	public void setSno(int sno) {
		this.sno = sno;
	}

	public void setSpare_code(String spare_code) {
		this.spare_code = spare_code;
	}

	public void setSpare_rate(String spare_rate) {
		this.spare_rate = spare_rate;
	}

	public void setST_Id(String sT_Id) {
		ST_Id = sT_Id;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public void setTo_date1(String to_date1) {
		this.to_date1 = to_date1;
	}

	public void setTotal_amc(int total_amc) {
		this.total_amc = total_amc;
	}

	/**
	 * @param total_amt
	 *            the total_amt to set
	 */
	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}

	public void setTotal_dealersale(long total_dealersale) {
		this.total_dealersale = total_dealersale;
	}

	public void setTotal_expenses(long total_expenses) {
		this.total_expenses = total_expenses;
	}

	public void setTotal_feedback(int total_feedback) {
		this.total_feedback = total_feedback;
	}

	public void setTotal_product(int total_product) {
		this.total_product = total_product;
	}

	public void setTotal_spare(long total_spare) {
		this.total_spare = total_spare;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	public void setTransactiondetail(String transactiondetail) {
		this.transactiondetail = transactiondetail;
	}

	public void setTransactionremark(String transactionremark) {
		this.transactionremark = transactionremark;
	}

	public void setTranscation_id(String transcation_id) {
		this.transcation_id = transcation_id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public void setUnit_no(String[] unit_no) {
		this.unit_no = unit_no;
	}

	/**
	 * @param unitno
	 *            the unitno to set
	 */
	public void setUnitno(String unitno) {
		this.unitno = unitno;

	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param voucher_no
	 *            the voucher_no to set
	 */
	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
	}

	public void setWarranty_status(String warranty_status) {
		this.warranty_status = warranty_status;
	}

	public void setFromcounter(String fromcounter) {
		this.fromcounter = fromcounter;
	}

	public String getFromcounter() {
		return fromcounter;
	}

	public void setTocounter(String tocounter) {
		this.tocounter = tocounter;
	}

	public String getTocounter() {
		return tocounter;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setStorecredit(String storecredit) {
		this.storecredit = storecredit;
	}

	public String getStorecredit() {
		return storecredit;
	}

	public void setStoredebit(String storedebit) {
		this.storedebit = storedebit;
	}

	public String getStoredebit() {
		return storedebit;
	}

	public void setAccountscredit(String accountscredit) {
		this.accountscredit = accountscredit;
	}

	public String getAccountscredit() {
		return accountscredit;
	}

	public void setAccountsdebit(String accountsdebit) {
		this.accountsdebit = accountsdebit;
	}

	public String getAccountsdebit() {
		return accountsdebit;
	}

	public void setAccountsbalance(String accountsbalance) {
		this.accountsbalance = accountsbalance;
	}

	public String getAccountsbalance() {
		return accountsbalance;
	}

	public void setStorebalance(String storebalance) {
		this.storebalance = storebalance;
	}

	public String getStorebalance() {
		return storebalance;
	}

	public void setStoretransfer(String storetransfer) {
		this.storetransfer = storetransfer;
	}

	public String getStoretransfer() {
		return storetransfer;
	}

	public void setAccountstransfer(String accountstransfer) {
		this.accountstransfer = accountstransfer;
	}

	public String getAccountstransfer() {
		return accountstransfer;
	}

	public void setCashgiventosir(String cashgiventosir) {
		this.cashgiventosir = cashgiventosir;
	}

	public String getCashgiventosir() {
		return cashgiventosir;
	}

	public void setCashgiventosir2(String cashgiventosir2) {
		this.cashgiventosir2 = cashgiventosir2;
	}

	public String getCashgiventosir2() {
		return cashgiventosir2;
	}

	public void setInitialbalstore(String initialbalstore) {
		this.initialbalstore = initialbalstore;
	}

	public String getInitialbalstore() {
		return initialbalstore;
	}

	public void setInitialbalaccounts(String initialbalaccounts) {
		this.initialbalaccounts = initialbalaccounts;
	}

	public String getInitialbalaccounts() {
		return initialbalaccounts;
	}

	public String[] getPrice1() {
		return price1;
	}

	public void setPrice1(String price1[]) {
		this.price1 = price1;
	}

	public String getVattin() {
		return vattin;
	}

	public void setVattin(String vattin) {
		this.vattin = vattin;
	}

	public String[] getQty2() {
		return qty2;
	}

	public void setQty2(String qty2[]) {
		this.qty2 = qty2;
	}

	public String[] getProductamt2() {
		return productamt2;
	}

	public void setProductamt2(String productamt2[]) {
		this.productamt2 = productamt2;
	}

	public String getTax_type() {
		return tax_type;
	}

	public void setTax_type(String tax_type) {
		this.tax_type = tax_type;
	}

	public String[] getUnit() {
		return unit;
	}

	public void setUnit(String unit[]) {
		this.unit = unit;
	}

	public String getUnit1() {
		return unit1;
	}

	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String[] getVoucherno() {
		return voucherno;
	}

	public void setVoucherno(String voucherno[]) {
		this.voucherno = voucherno;
	}

	public String[] getVoucherno1() {
		return voucherno1;
	}

	public void setVoucherno1(String voucherno1[]) {
		this.voucherno1 = voucherno1;
	}

	public String[] getPaymodv() {
		return paymodv;
	}

	public void setPaymodv(String paymodv[]) {
		this.paymodv = paymodv;
	}

	public String[] getAmmttv() {
		return ammttv;
	}

	public void setAmmttv(String ammttv[]) {
		this.ammttv = ammttv;
	}

}
