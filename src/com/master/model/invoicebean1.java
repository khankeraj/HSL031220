package com.master.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class invoicebean1 implements Serializable{
	/**
	 * 
	 **/
	private static final long serialVersionUID = 1L;
	private String Job_Card_no;
	private String Date;
	private String Vehicle_no;
	private String Customer_name;
	private String tamount;
	private String paymod;
	private String cust_subname;
	private String address;
	private String paid_amt;
	private String email;
	private String gstn;
	
	private String order_id;
	private String despatch_id;
	
	private String inquiry_id;
	
	public String getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	private String stot;
	private String schemeh;
	private String batch22;
	private String balance_amt;
	private String cheque_date;
	private String cheque_no;
	private String invoiceno;
	private String srno1[];
	private String description1[];
	private String unit1[];
	private String unit;
	private String ttype[];
	private String quantity1[];
	private String amount1[];
	private String vat1[];
	private String taxqmount1[];
	private String vatamount1[];
	private String srno2[];
	private String description2[];
	private String quantity2[];
	private String amount2[];
	private String vat2[];
	
	private String aa[];
	
	private String aa1;
	
	private String batch1[];
	
	private String taxqmount2[];
	private String vatamount2[];
	private String myrate[];
	private String grate1[];
	private String gstamount1[];
	private String grate2[];
	private String gstamount2[];
	private String response;
	private String disc[];
	private String partno[];
	private String partdate[];
	private String partnox[];
	private String disc1;
	private String perunit[];
	
	private String amtwithdisc[];
	
	private String transmode;
	private String contactp;
	private String contactpno;
	private String shipparty;
	private String shipadd;
	private String 	shipgstn;
	private String 	shipstate;
	private String vehino;
	private String freight;
	private String transport;
	
	private String schemep;
	private String schemeq;
	private String schemeu;
	
	private String ggtotal;
	
	private String discamt[];
	private String myrate1;
	private String gr1;
	private String gsa1;
	private String gr2;
	private String gsa2;
	private String vendor;
	
	private String dcnox;
	private String dcdatex;
	
	private String pono;
	private String podate;
	private String termcond;
	
	
	private String hsn;
	private String taxablevalue;
	private String crate;
	private String srate;
	private String camount;
	private String samount;
	
	private String Customer_Id;
	
	private String cgst;
	private String sgst;
	
	private String amountinwords;
	private String description;
	private String type_1;
	private String submit2;
	private String quantity;
	private String amount;
	private String vat;
	private String taxqmount;
	private String vatamount;
	private  String mobile;
	private String  t[];
	private String  A[];
	private String  A2[];
	private String  btype[];
	private String A1;
	//private String A2;
	private String A3;
	private String A4;
	private String t1;
	private String t2;
	private String t3;
	private String t4;
	private String t5;
	private String submit;
	private String printbutton2;
	
	private String date1;
	
	private String ntparts;
	private String tparts;
	private String nntparts;
	private String LAB1;
	private String LAB2;
	private String LAB3;
	private String grossamt;
	private String netamt;
	private String tax;
	private String sn;
	
	private String desc1;
	private String amt1;
	private String tax1;
	private String hh1;
	private String hh2;
	private String hh3;
	private String hh4;
	private String hh5;
	
	private String bb1;
	private String bb2;
	private String bb3;
	private String bb4;
	private String bb5;
	
	private String r1;
	private String r2;
	private String r3;
	
	private String cgstamt;
	private String sgstamt;
	private String igstamt;
	private String cgstrate;
	private String sgstrate;
	private String igstrate;
	private String igstamount;
	private String billno;
	//private String Customer_name;

	
	private String customer_name1;
	private String address1;
	private String vat007;
	
	private String state1;
	private String pincode;
	
	
	
	public String getCustomer_name1() {
		return customer_name1;
	}
	public void setCustomer_name1(String customer_name1) {
		this.customer_name1 = customer_name1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getVat007() {
		return vat007;
	}
	public void setVat007(String vat007) {
		this.vat007 = vat007;
	}
	public String getState1() {
		return state1;
	}
	public void setState1(String state1) {
		this.state1 = state1;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getR1() {
		return r1;
	}
	public String getTransmode() {
		return transmode;
	}
	public void setTransmode(String transmode) {
		this.transmode = transmode;
	}
	public String getContactp() {
		return contactp;
	}
	public void setContactp(String contactp) {
		this.contactp = contactp;
	}
	public String getContactpno() {
		return contactpno;
	}
	public void setContactpno(String contactpno) {
		this.contactpno = contactpno;
	}
	public String getShipparty() {
		return shipparty;
	}
	public void setShipparty(String shipparty) {
		this.shipparty = shipparty;
	}
	public String getShipadd() {
		return shipadd;
	}
	public void setShipadd(String shipadd) {
		this.shipadd = shipadd;
	}
	public String getShipgstn() {
		return shipgstn;
	}
	public void setShipgstn(String shipgstn) {
		this.shipgstn = shipgstn;
	}
	public String getShipstate() {
		return shipstate;
	}
	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}
	public String[] getPartno() {
		return partno;
	}
	public void setPartno(String[] partno) {
		this.partno = partno;
	}
	public String[] getPartdate() {
		return partdate;
	}
	public void setPartdate(String[] partdate) {
		this.partdate = partdate;
	}
	public String[] getPartnox() {
		return partnox;
	}
	public void setPartnox(String[] partnox) {
		this.partnox = partnox;
	}
	public void setR1(String r1) {
		this.r1 = r1;
	}
	public String getR2() {
		return r2;
	}
	public void setR2(String r2) {
		this.r2 = r2;
	}
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	private String net_amount;
	private String net_amountcard;
	private String 	cardid;
	private String  total_amt22;
	private String paid_amt22;
	private String balance_amt22;
	private String insurance;
	private String id;
	private String date22;
	private String cash_amt;
	private String bankname;
	private String amount22;
	private String cheque_amt;
	private String trandi;
	private String carddd;
	private String cashhh;
	private String KM;
	
	private String partnoo;
	private String partdatee;
	private String partnoox;
	
	private String sparename;
	private String brand;
	private String model;
	private String comprice;
	private String cprice;
	private String taxtype;
	private String taxper;
	private String remark;
	private String hh8;
	private String hh9;
	private String hh10;
	private String hh11;
	private String hh12;
	private String dcno[];
	private String dcdate;
	private List<String> dcno1=new ArrayList<String>();
	
	
	private String  dcnoo;
	
	
	
	public String getPartnoo() {
		return partnoo;
	}
	public void setPartnoo(String partnoo) {
		this.partnoo = partnoo;
	}
	public String getPartdatee() {
		return partdatee;
	}
	public void setPartdatee(String partdatee) {
		this.partdatee = partdatee;
	}
	public String getPartnoox() {
		return partnoox;
	}
	public void setPartnoox(String partnoox) {
		this.partnoox = partnoox;
	}
	public String[] getDcno() {
		return dcno;
	}
	public void setDcno(String[] dcno) {
		this.dcno = dcno;
	}
	public String getDcdate() {
		return dcdate;
	}
	public void setDcdate(String dcdate) {
		this.dcdate = dcdate;
	}
	private String service_name;
	private String  tax_type;
	private String  taxpercent;
	
	private String  vvtaxtype;
	private String  vvtaxableamt;
	private String  vvtax;
	
	
	private List<String> type1=new ArrayList<String>();
	private List<String> descrip1=new ArrayList<String>();
	private List<String> batcht=new ArrayList<String>();
	private List<String> qty1=new ArrayList<String>();
	private List<String> amt112=new ArrayList<String>();
	private List<String> vat_percent1=new ArrayList<String>();
	private List<String> tax_amt_percent1=new ArrayList<String>();
	private List<String> net_amt1=new ArrayList<String>();
	private List<String> type_name1=new ArrayList<String>();
	private List<String> rate1=new ArrayList<String>();
	private List<String> rate2=new ArrayList<String>();
	private List<String> gstamt1=new ArrayList<String>();
	private List<String> gstamt2=new ArrayList<String>();
	private List<String> myrate2=new ArrayList<String>();
	private List<String> partno2=new ArrayList<String>();
	private List<String> partdate2=new ArrayList<String>();
	private List<String> partnox2=new ArrayList<String>();
	private List<String> dcno2=new ArrayList<String>();
	private List<String> partno2x=new ArrayList<String>();
	List<String> papercodedetails = new ArrayList<String>();
	List<String> papercodeid = new ArrayList<String>();
	List<String> papercodequantity = new ArrayList<String>();

	private List<String> disc2=new ArrayList<String>();
	private List<String> discamt2=new ArrayList<String>();
	private List<String> amtwithdisc2=new ArrayList<String>();
	
	
	private int sparesize;
	private String invno;
	
	private String state;
	public String getJob_Card_no() {
		return Job_Card_no;
	}
	public void setJob_Card_no(String job_Card_no) {
		Job_Card_no = job_Card_no;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getVehicle_no() {
		return Vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		Vehicle_no = vehicle_no;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	public String getPaymod() {
		return paymod;
	}
	public void setPaymod(String paymod) {
		this.paymod = paymod;
	}
	public String getPaid_amt() {
		return paid_amt;
	}
	public void setPaid_amt(String paid_amt) {
		this.paid_amt = paid_amt;
	}
	public String getBalance_amt() {
		return balance_amt;
	}
	public void setBalance_amt(String balance_amt) {
		this.balance_amt = balance_amt;
	}
	public String getCheque_date() {
		return cheque_date;
	}
	public void setCheque_date(String cheque_date) {
		this.cheque_date = cheque_date;
	}
	public String getCheque_no() {
		return cheque_no;
	}
	public void setCheque_no(String cheque_no) {
		this.cheque_no = cheque_no;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public void setSrno1(String srno1[]) {
		this.srno1 = srno1;
	}
	private int gridSize;
	public List<String> getPapercodedetails() {
		return papercodedetails;
	}
	public void setPapercodedetails(List<String> papercodedetails) {
		this.papercodedetails = papercodedetails;
	}
	public List<String> getPapercodeid() {
		return papercodeid;
	}
	public void setPapercodeid(List<String> papercodeid) {
		this.papercodeid = papercodeid;
	}
	public List<String> getPapercodequantity() {
		return papercodequantity;
	}
	public void setPapercodequantity(List<String> papercodequantity) {
		this.papercodequantity = papercodequantity;
	}
	public String[] getSrno1() {
		return srno1;
	}
	public void setDescription1(String description1[]) {
		this.description1 = description1;
	}
	public String[] getDescription1() {
		return description1;
	}
	public void setQuantity1(String quantity1[]) {
		this.quantity1 = quantity1;
	}
	public String[] getQuantity1() {
		return quantity1;
	}
	public void setVat1(String vat1[]) {
		this.vat1 = vat1;
	}
	public String[] getVat1() {
		return vat1;
	}
	public void setAmount1(String amount1[]) {
		this.amount1 = amount1;
	}
	public String[] getAmount1() {
		return amount1;
	}
	public void setTaxqmount1(String taxqmount1[]) {
		this.taxqmount1 = taxqmount1;
	}
	public String[] getTaxqmount1() {
		return taxqmount1;
	}
	public void setVatamount1(String vatamount1[]) {
		this.vatamount1 = vatamount1;
	}
	public String[] getVatamount1() {
		return vatamount1;
	}
	public void setSrno2(String srno2[]) {
		this.srno2 = srno2;
	}
	public String[] getSrno2() {
		return srno2;
	}
	public void setQuantity2(String quantity2[]) {
		this.quantity2 = quantity2;
	}
	public String[] getQuantity2() {
		return quantity2;
	}
	public void setDescription2(String description2[]) {
		this.description2 = description2;
	}
	public String[] getDescription2() {
		return description2;
	}
	public void setAmount2(String amount2[]) {
		this.amount2 = amount2;
	}
	public String[] getAmount2() {
		return amount2;
	}
	public void setVat2(String vat2[]) {
		this.vat2 = vat2;
	}
	public String[] getVat2() {
		return vat2;
	}
	public void setTaxqmount2(String taxqmount2[]) {
		this.taxqmount2 = taxqmount2;
	}
	public String[] getTaxqmount2() {
		return taxqmount2;
	}
	public void setVatamount2(String vatamount2[]) {
		this.vatamount2 = vatamount2;
	}
	public String[] getVatamount2() {
		return vatamount2;
	}
	
	public void setBtype(String btype[]) {
		this.btype = btype;
	}
	public String[] getBtype() {
		return btype;
	}
	public void setA1(String a1) {
		A1 = a1;
	}
	public String getA1() {
		return A1;
	}
	
	public void setA3(String a3) {
		A3 = a3;
	}
	public String getA3() {
		return A3;
	}
	public void setA4(String a4) {
		A4 = a4;
	}
	public String getA4() {
		return A4;
	}
	public void setT1(String t1) {
		this.t1 = t1;
	}
	public String getT1() {
		return t1;
	}
	public void setT2(String t2) {
		this.t2 = t2;
	}
	public String getT2() {
		return t2;
	}
	public void setT3(String t3) {
		this.t3 = t3;
	}
	public String getT3() {
		return t3;
	}
	public void setT4(String t4) {
		this.t4 = t4;
	}
	public String getT4() {
		return t4;
	}
	public void setT5(String t5) {
		this.t5 = t5;
	}
	public String getT5() {
		return t5;
	}
	public void setT(String t[]) {
		this.t = t;
	}
	public String[] getT() {
		return t;
	}
	public void setA(String a[]) {
		A = a;
	}
	public String[] getA() {
		return A;
	}
	public void setA2(String a2[]) {
		A2 = a2;
	}
	public String[] getA2() {
		return A2;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getSubmit() {
		return submit;
	}
	public void setPrintbutton2(String printbutton2) {
		this.printbutton2 = printbutton2;
	}
	public String getPrintbutton2() {
		return printbutton2;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setVat(String vat) {
		this.vat = vat;
	}
	public String getVat() {
		return vat;
	}
	public void setTaxqmount(String taxqmount) {
		this.taxqmount = taxqmount;
	}
	public String getTaxqmount() {
		return taxqmount;
	}
	public void setVatamount(String vatamount) {
		this.vatamount = vatamount;
	}
	public String getVatamount() {
		return vatamount;
	}
	public void setType_1(String type_1) {
		this.type_1 = type_1;
	}
	public String getType_1() {
		return type_1;
	}
	public void setNtparts(String ntparts) {
		this.ntparts = ntparts;
	}
	public String getNtparts() {
		return ntparts;
	}
	public void setTparts(String tparts) {
		this.tparts = tparts;
	}
	public String getTparts() {
		return tparts;
	}
	public void setNntparts(String nntparts) {
		this.nntparts = nntparts;
	}
	public String getNntparts() {
		return nntparts;
	}
	public void setLAB1(String lAB1) {
		LAB1 = lAB1;
	}
	public String getLAB1() {
		return LAB1;
	}
	public void setLAB2(String lAB2) {
		LAB2 = lAB2;
	}
	public String getLAB2() {
		return LAB2;
	}
	public void setLAB3(String lAB3) {
		LAB3 = lAB3;
	}
	public String getLAB3() {
		return LAB3;
	}
	public void setGrossamt(String grossamt) {
		this.grossamt = grossamt;
	}
	public String getGrossamt() {
		return grossamt;
	}
	public void setNetamt(String netamt) {
		this.netamt = netamt;
	}
	public String getNetamt() {
		return netamt;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getTax() {
		return tax;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setAmt1(String amt1) {
		this.amt1 = amt1;
	}
	public String getAmt1() {
		return amt1;
	}
	public void setTax1(String tax1) {
		this.tax1 = tax1;
	}
	public String getTax1() {
		return tax1;
	}
	public void setHh1(String hh1) {
		this.hh1 = hh1;
	}
	public String getHh1() {
		return hh1;
	}
	public void setHh2(String hh2) {
		this.hh2 = hh2;
	}
	public String getHh2() {
		return hh2;
	}
	public void setHh3(String hh3) {
		this.hh3 = hh3;
	}
	public String getHh3() {
		return hh3;
	}
	public void setHh4(String hh4) {
		this.hh4 = hh4;
	}
	public String getHh4() {
		return hh4;
	}
	public void setHh5(String hh5) {
		this.hh5 = hh5;
	}
	public String getHh5() {
		return hh5;
	}
	public void setNet_amount(String net_amount) {
		this.net_amount = net_amount;
	}
	public String getNet_amount() {
		return net_amount;
	}
	public void setNet_amountcard(String net_amountcard) {
		this.net_amountcard = net_amountcard;
	}
	public String getNet_amountcard() {
		return net_amountcard;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getCardid() {
		return cardid;
	}
	public void setTotal_amt22(String total_amt22) {
		this.total_amt22 = total_amt22;
	}
	public String getTotal_amt22() {
		return total_amt22;
	}
	public void setPaid_amt22(String paid_amt22) {
		this.paid_amt22 = paid_amt22;
	}
	public String getPaid_amt22() {
		return paid_amt22;
	}
	public void setBalance_amt22(String balance_amt22) {
		this.balance_amt22 = balance_amt22;
	}
	public String getBalance_amt22() {
		return balance_amt22;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setDate22(String date22) {
		this.date22 = date22;
	}
	public String getDate22() {
		return date22;
	}
	public void setCash_amt(String cash_amt) {
		this.cash_amt = cash_amt;
	}
	public String getCash_amt() {
		return cash_amt;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBankname() {
		return bankname;
	}
	public void setCheque_amt(String cheque_amt) {
		this.cheque_amt = cheque_amt;
	}
	public String getCheque_amt() {
		return cheque_amt;
	}
	public void setAmount22(String amount22) {
		this.amount22 = amount22;
	}
	public String getAmount22() {
		return amount22;
	}
	public void setTrandi(String trandi) {
		this.trandi = trandi;
	}
	public String getTrandi() {
		return trandi;
	}
	public void setCarddd(String carddd) {
		this.carddd = carddd;
	}
	public String getCarddd() {
		return carddd;
	}
	public void setCashhh(String cashhh) {
		this.cashhh = cashhh;
	}
	public String getCashhh() {
		return cashhh;
	}
	public void setSparename(String sparename) {
		this.sparename = sparename;
	}
	public String getSparename() {
		return sparename;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getBrand() {
		return brand;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel() {
		return model;
	}
	public void setComprice(String comprice) {
		this.comprice = comprice;
	}
	public String getComprice() {
		return comprice;
	}
	public void setCprice(String cprice) {
		this.cprice = cprice;
	}
	public String getCprice() {
		return cprice;
	}
	public void setTaxtype(String taxtype) {
		this.taxtype = taxtype;
	}
	public String getTaxtype() {
		return taxtype;
	}
	public void setTaxper(String taxper) {
		this.taxper = taxper;
	}
	public String getTaxper() {
		return taxper;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setHh8(String hh8) {
		this.hh8 = hh8;
	}
	public String getHh8() {
		return hh8;
	}
	public void setHh9(String hh9) {
		this.hh9 = hh9;
	}
	public String getHh9() {
		return hh9;
	}
	public void setHh10(String hh10) {
		this.hh10 = hh10;
	}
	public String getHh10() {
		return hh10;
	}
	public void setHh11(String hh11) {
		this.hh11 = hh11;
	}
	public String getHh11() {
		return hh11;
	}
	public void setHh12(String hh12) {
		this.hh12 = hh12;
	}
	public String getHh12() {
		return hh12;
	}
	public void setTaxpercent(String taxpercent) {
		this.taxpercent = taxpercent;
	}
	public String getTaxpercent() {
		return taxpercent;
	}
	public void setTax_type(String tax_type) {
		this.tax_type = tax_type;
	}
	public String getTax_type() {
		return tax_type;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getService_name() {
		return service_name;
	}
	public void setBb1(String bb1) {
		this.bb1 = bb1;
	}
	public String getBb1() {
		return bb1;
	}
	public void setBb2(String bb2) {
		this.bb2 = bb2;
	}
	public String getBb2() {
		return bb2;
	}
	public void setBb3(String bb3) {
		this.bb3 = bb3;
	}
	public String getBb3() {
		return bb3;
	}
	public void setBb4(String bb4) {
		this.bb4 = bb4;
	}
	public String getBb4() {
		return bb4;
	}
	public void setBb5(String bb5) {
		this.bb5 = bb5;
	}
	public String getBb5() {
		return bb5;
	}
	public void setVvtaxtype(String vvtaxtype) {
		this.vvtaxtype = vvtaxtype;
	}
	public String getVvtaxtype() {
		return vvtaxtype;
	}
	public void setVvtaxableamt(String vvtaxableamt) {
		this.vvtaxableamt = vvtaxableamt;
	}
	public String getVvtaxableamt() {
		return vvtaxableamt;
	}
	public void setVvtax(String vvtax) {
		this.vvtax = vvtax;
	}
	public String getVvtax() {
		return vvtax;
	}
	public void setKM(String kM) {
		KM = kM;
	}
	public String getKM() {
		return KM;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile() {
		return mobile;
	}
	public void setAmountinwords(String amountinwords) {
		this.amountinwords = amountinwords;
	}
	public String getAmountinwords() {
		return amountinwords;
	}
	public void setSubmit2(String submit2) {
		this.submit2 = submit2;
	}
	public String getSubmit2() {
		return submit2;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setType1(List<String> type1) {
		this.type1 = type1;
	}
	public List<String> getType1() {
		return type1;
	}
	public void setDescrip1(List<String> descrip1) {
		this.descrip1 = descrip1;
	}
	public List<String> getDescrip1() {
		return descrip1;
	}
	public void setQty1(List<String> qty1) {
		this.qty1 = qty1;
	}
	public List<String> getQty1() {
		return qty1;
	}
	public void setAmt112(List<String> amt112) {
		this.amt112 = amt112;
	}
	public List<String> getAmt112() {
		return amt112;
	}
	public void setVat_percent1(List<String> vat_percent1) {
		this.vat_percent1 = vat_percent1;
	}
	public List<String> getVat_percent1() {
		return vat_percent1;
	}
	public void setTax_amt_percent1(List<String> tax_amt_percent1) {
		this.tax_amt_percent1 = tax_amt_percent1;
	}
	public List<String> getTax_amt_percent1() {
		return tax_amt_percent1;
	}
	public void setNet_amt1(List<String> net_amt1) {
		this.net_amt1 = net_amt1;
	}
	public List<String> getNet_amt1() {
		return net_amt1;
	}
	public void setSparesize(int sparesize) {
		this.sparesize = sparesize;
	}
	public int getSparesize() {
		return sparesize;
	}
	public void setTtype(String ttype[]) {
		this.ttype = ttype;
	}
	public String[] getTtype() {
		return ttype;
	}
	public void setType_name1(List<String> type_name1) {
		this.type_name1 = type_name1;
	}
	public List<String> getType_name1() {
		return type_name1;
	}
	public void setInvno(String invno) {
		this.invno = invno;
	}
	public String getInvno() {
		return invno;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate1() {
		return date1;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getSn() {
		return sn;
	}
	public void setUnit1(String unit1[]) {
		this.unit1 = unit1;
	}
	public String[] getUnit1() {
		return unit1;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}
	public void setTamount(String tamount) {
		this.tamount = tamount;
	}
	public String getTamount() {
		return tamount;
	}
	public void setCust_subname(String cust_subname) {
		this.cust_subname = cust_subname;
	}
	public String getCust_subname() {
		return cust_subname;
	}
	public String[] getGrate1() {
		return grate1;
	}
	public void setGrate1(String grate1[]) {
		this.grate1 = grate1;
	}
	public String[] getGstamount1() {
		return gstamount1;
	}
	public void setGstamount1(String gstamount1[]) {
		this.gstamount1 = gstamount1;
	}
	public String[] getGrate2() {
		return grate2;
	}
	public void setGrate2(String grate2[]) {
		this.grate2 = grate2;
	}
	public String[] getGstamount2() {
		return gstamount2;
	}
	public void setGstamount2(String gstamount2[]) {
		this.gstamount2 = gstamount2;
	}
	public String getGr1() {
		return gr1;
	}
	public void setGr1(String gr1) {
		this.gr1 = gr1;
	}
	public String getGsa1() {
		return gsa1;
	}
	public void setGsa1(String gsa1) {
		this.gsa1 = gsa1;
	}
	public String getGsa2() {
		return gsa2;
	}
	public void setGsa2(String gsa2) {
		this.gsa2 = gsa2;
	}
	public String getGr2() {
		return gr2;
	}
	public void setGr2(String gr2) {
		this.gr2 = gr2;
	}
	public String getSgst() {
		return sgst;
	}
	public void setSgst(String sgst) {
		this.sgst = sgst;
	}
	public String getCgst() {
		return cgst;
	}
	public void setCgst(String cgst) {
		this.cgst = cgst;
	}
	public List<String> getRate1() {
		return rate1;
	}
	public void setRate1(List<String> rate1) {
		this.rate1 = rate1;
	}
	public List<String> getRate2() {
		return rate2;
	}
	public void setRate2(List<String> rate2) {
		this.rate2 = rate2;
	}
	public List<String> getGstamt1() {
		return gstamt1;
	}
	public void setGstamt1(List<String> gstamt1) {
		this.gstamt1 = gstamt1;
	}
	public List<String> getGstamt2() {
		return gstamt2;
	}
	public void setGstamt2(List<String> gstamt2) {
		this.gstamt2 = gstamt2;
	}
	public String[] getMyrate() {
		return myrate;
	}
	public void setMyrate(String myrate[]) {
		this.myrate = myrate;
	}
	public String getMyrate1() {
		return myrate1;
	}
	public void setMyrate1(String myrate1) {
		this.myrate1 = myrate1;
	}
	public List<String> getMyrate2() {
		return myrate2;
	}
	public void setMyrate2(List<String> myrate2) {
		this.myrate2 = myrate2;
	}
	public String getCustomer_Id() {
		return Customer_Id;
	}
	public void setCustomer_Id(String customer_Id) {
		Customer_Id = customer_Id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getPodate() {
		return podate;
	}
	public void setPodate(String podate) {
		this.podate = podate;
	}
	public String getTermcond() {
		return termcond;
	}
	public void setTermcond(String termcond) {
		this.termcond = termcond;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String[] getDiscamt() {
		return discamt;
	}
	public void setDiscamt(String discamt[]) {
		this.discamt = discamt;
	}
	public String[] getDisc() {
		return disc;
	}
	public void setDisc(String disc[]) {
		this.disc = disc;
	}
	public String getCgstamt() {
		return cgstamt;
	}
	public void setCgstamt(String cgstamt) {
		this.cgstamt = cgstamt;
	}
	public String getSgstamt() {
		return sgstamt;
	}
	public void setSgstamt(String sgstamt) {
		this.sgstamt = sgstamt;
	}
	public String getIgstamt() {
		return igstamt;
	}
	public void setIgstamt(String igstamt) {
		this.igstamt = igstamt;
	}
	public String getCgstrate() {
		return cgstrate;
	}
	public void setCgstrate(String cgstrate) {
		this.cgstrate = cgstrate;
	}
	public String getSgstrate() {
		return sgstrate;
	}
	public void setSgstrate(String sgstrate) {
		this.sgstrate = sgstrate;
	}
	public String getIgstrate() {
		return igstrate;
	}
	public void setIgstrate(String igstrate) {
		this.igstrate = igstrate;
	}
	public String getIgstamount() {
		return igstamount;
	}
	public void setIgstamount(String igstamount) {
		this.igstamount = igstamount;
	}
	public String getBillno() {
		return billno;
	}
	public void setBillno(String billno) {
		this.billno = billno;
	}
	
	public List<String> getDcno1() {
		return dcno1;
	}
	public void setDcno1(List<String> dcno1) {
		this.dcno1 = dcno1;
	}
	public String getDcnoo() {
		return dcnoo;
	}
	public void setDcnoo(String dcnoo) {
		this.dcnoo = dcnoo;
	}
	public int getGridSize() {
		return gridSize;
	}
	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public List<String> getPartno2() {
		return partno2;
	}
	public void setPartno2(List<String> partno2) {
		this.partno2 = partno2;
	}
	public List<String> getPartdate2() {
		return partdate2;
	}
	public void setPartdate2(List<String> partdate2) {
		this.partdate2 = partdate2;
	}
	public List<String> getPartnox2() {
		return partnox2;
	}
	public void setPartnox2(List<String> partnox2) {
		this.partnox2 = partnox2;
	}
	public List<String> getDcno2() {
		return dcno2;
	}
	public void setDcno2(List<String> dcno2) {
		this.dcno2 = dcno2;
	}
	public List<String> getPartno2x() {
		return partno2x;
	}
	public void setPartno2x(List<String> partno2x) {
		this.partno2x = partno2x;
	}
	public String getDcdatex() {
		return dcdatex;
	}
	public void setDcdatex(String dcdatex) {
		this.dcdatex = dcdatex;
	}
	public String getDcnox() {
		return dcnox;
	}
	public void setDcnox(String dcnox) {
		this.dcnox = dcnox;
	}
	public String getVehino() {
		return vehino;
	}
	public void setVehino(String vehino) {
		this.vehino = vehino;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getGgtotal() {
		return ggtotal;
	}
	public void setGgtotal(String ggtotal) {
		this.ggtotal = ggtotal;
	}
	public String[] getAmtwithdisc() {
		return amtwithdisc;
	}
	public void setAmtwithdisc(String amtwithdisc[]) {
		this.amtwithdisc = amtwithdisc;
	}
	public String getDisc1() {
		return disc1;
	}
	public void setDisc1(String disc1) {
		this.disc1 = disc1;
	}
	public List<String> getDisc2() {
		return disc2;
	}
	public void setDisc2(List<String> disc2) {
		this.disc2 = disc2;
	}
	public List<String> getDiscamt2() {
		return discamt2;
	}
	public void setDiscamt2(List<String> discamt2) {
		this.discamt2 = discamt2;
	}
	public List<String> getAmtwithdisc2() {
		return amtwithdisc2;
	}
	public void setAmtwithdisc2(List<String> amtwithdisc2) {
		this.amtwithdisc2 = amtwithdisc2;
	}
	public String getStot() {
		return stot;
	}
	public void setStot(String stot) {
		this.stot = stot;
	}
	public String[] getPerunit() {
		return perunit;
	}
	public void setPerunit(String perunit[]) {
		this.perunit = perunit;
	}
	public String getHsn() {
		return hsn;
	}
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}
	public String getTaxablevalue() {
		return taxablevalue;
	}
	public void setTaxablevalue(String taxablevalue) {
		this.taxablevalue = taxablevalue;
	}
	public String getCrate() {
		return crate;
	}
	public void setCrate(String crate) {
		this.crate = crate;
	}
	public String getSrate() {
		return srate;
	}
	public void setSrate(String srate) {
		this.srate = srate;
	}
	public String getCamount() {
		return camount;
	}
	public void setCamount(String camount) {
		this.camount = camount;
	}
	public String getSamount() {
		return samount;
	}
	public void setSamount(String samount) {
		this.samount = samount;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String[] getBatch1() {
		return batch1;
	}
	public void setBatch1(String batch1[]) {
		this.batch1 = batch1;
	}
	public String getBatch22() {
		return batch22;
	}
	public void setBatch22(String batch22) {
		this.batch22 = batch22;
	}
	public List<String> getBatcht() {
		return batcht;
	}
	public void setBatcht(List<String> batcht) {
		this.batcht = batcht;
	}
	public String getSchemep() {
		return schemep;
	}
	public void setSchemep(String schemep) {
		this.schemep = schemep;
	}
	public String getSchemeq() {
		return schemeq;
	}
	public void setSchemeq(String schemeq) {
		this.schemeq = schemeq;
	}
	public String getSchemeu() {
		return schemeu;
	}
	public void setSchemeu(String schemeu) {
		this.schemeu = schemeu;
	}
	public String getSchemeb() {
		return schemeb;
	}
	public void setSchemeb(String schemeb) {
		this.schemeb = schemeb;
	}
	public String getSchemeh() {
		return schemeh;
	}
	public void setSchemeh(String schemeh) {
		this.schemeh = schemeh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getDespatch_id() {
		return despatch_id;
	}
	public void setDespatch_id(String despatch_id) {
		this.despatch_id = despatch_id;
	}
	public String[] getAa() {
		return aa;
	}
	public void setAa(String aa[]) {
		this.aa = aa;
	}
	public String getAa1() {
		return aa1;
	}
	public void setAa1(String aa1) {
		this.aa1 = aa1;
	}
	private String schemeb;



	
	
		
}