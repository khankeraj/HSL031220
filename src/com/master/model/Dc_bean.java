package com.master.model;

import java.util.ArrayList;
import java.util.List;

public class Dc_bean {
	
	private String cust_name;
	private String mob_no;
	private String cust_address;
	private String pancard_no;					
	private String	email;
	private String gstn_no;
	private String Dc_id;
	private String custid;
	
	private String totamt;
	private String cgstamt;
	private String sgstamt;
	private String cno;
	private String cdate;
	private String state;
	
	private String city;
	private String vendor;
	
	private String dest;
	private String lr_amt;
	
	public String getLr_amt() {
		return lr_amt;
	}
	public void setLr_amt(String lr_amt) {
		this.lr_amt = lr_amt;
	}
	private String inquiry_id;
	
	public String getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	private String sn;
	private int mysize;
	private String description[];
	private String pono;
private String date;
	private String qty[];
	private String reqty[];
	private String dqty[];
	private String price[];
	private List<String> description122 = new ArrayList<String>();
	private List<String> nn = new ArrayList<String>();
	private List<String> id1 = new ArrayList<String>();
	private List<String> qty122 = new ArrayList<String>();
	private List<String> qtyremain = new ArrayList<String>();
	private List<String> dcqty = new ArrayList<String>();
	private String dcno[];
	
List<String> descriptiont=new ArrayList<String>();
List<String> dcnot=new ArrayList<String>();
List<String> hsncode=new ArrayList<String>();

List<String> rate=new ArrayList<String>();

List<String> myrate=new ArrayList<String>();
List<String> gstamt1=new ArrayList<String>();
List<String> gstamt2=new ArrayList<String>();
List<String> netamt=new ArrayList<String>();
List<String> myamt=new ArrayList<String>();
List<String> vat=new ArrayList<String>();
List<String> taxqamount=new ArrayList<String>();

List<String> lrno=new ArrayList<String>();
List<String> drivername=new ArrayList<String>();
List<String> expdate=new ArrayList<String>();
List<String> exppart1=new ArrayList<String>();
List<String> expamt=new ArrayList<String>();
List<String> vehiclenoz=new ArrayList<String>();
List<String> remark1=new ArrayList<String>();

List<String> givenby=new ArrayList<String>();

private int sparesize;

public int getSparesize() {
	return sparesize;
}
public void setSparesize(int sparesize) {
	this.sparesize = sparesize;
}
private String jobs;
private String dcnox;
private String dcdatex;
private String termcond;
private String transport1;

private String order_id;



public List<String> getLrno() {
	return lrno;
}
public void setLrno(List<String> lrno) {
	this.lrno = lrno;
}
public List<String> getDrivername() {
	return drivername;
}
public void setDrivername(List<String> drivername) {
	this.drivername = drivername;
}
public List<String> getExpdate() {
	return expdate;
}
public void setExpdate(List<String> expdate) {
	this.expdate = expdate;
}
public List<String> getExppart1() {
	return exppart1;
}
public void setExppart1(List<String> exppart1) {
	this.exppart1 = exppart1;
}
public List<String> getExpamt() {
	return expamt;
}
public void setExpamt(List<String> expamt) {
	this.expamt = expamt;
}
public List<String> getVehiclenoz() {
	return vehiclenoz;
}
public void setVehiclenoz(List<String> vehiclenoz) {
	this.vehiclenoz = vehiclenoz;
}
public List<String> getRemark1() {
	return remark1;
}
public void setRemark1(List<String> remark1) {
	this.remark1 = remark1;
}
public List<String> getGivenby() {
	return givenby;
}
public void setGivenby(List<String> givenby) {
	this.givenby = givenby;
}
private String despatch_id;

private String invoice;

private String job_card_id;
private String freight;
private String transport;
private String total;
private String total_amt;
private String address;
private String po;

private String podate;
private String vehicleno;
private String dc;
private String dcdate;
private String tps;

private String contactp;
private String contactno;
private String shipp;
private String shipadd;
private String shipgstn;
private String shipstate;

private String invoiceno;
private String name;
private String type;
private String amount;


List<String> email22=new ArrayList<String>();


List<String> batcht=new ArrayList<String>();



private List<String> disc2=new ArrayList<String>();
private List<String> discamt2=new ArrayList<String>();
private List<String> amtwithdisc2=new ArrayList<String>();


public String getTotamt() {
	return totamt;
}
public void setTotamt(String totamt) {
	this.totamt = totamt;
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
public List<String> getMyamt() {
	return myamt;
}
public void setMyamt(List<String> myamt) {
	this.myamt = myamt;
}
List<String> quantity=new ArrayList<String>();
private int gridsize;
	
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
public String getVendor() {
	return vendor;
}
public void setVendor(String vendor) {
	this.vendor = vendor;
}
	public List<String> getDescriptiont() {
		return descriptiont;
	}
	public void setDescriptiont(List<String> descriptiont) {
		this.descriptiont = descriptiont;
	}
	
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public String getPancard_no() {
		return pancard_no;
	}
	public void setPancard_no(String pancard_no) {
		this.pancard_no = pancard_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstn_no() {
		return gstn_no;
	}
	public void setGstn_no(String gstn_no) {
		this.gstn_no = gstn_no;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String description[]) {
		this.description = description;
	}
	public String[] getQty() {
		return qty;
	}
	public void setQty(String qty[]) {
		this.qty = qty;
	}
	public String[] getPrice() {
		return price;
	}
	public void setPrice(String price[]) {
		this.price = price;
	}
	public String getDc_id() {
		return Dc_id;
	}
	public void setDc_id(String dc_id) {
		Dc_id = dc_id;
	}
	
	
	public int getGridsize() {
		return gridsize;
	}
	public void setGridsize(int gridsize) {
		this.gridsize = gridsize;
	}
	public String[] getDcno() {
		return dcno;
	}
	public void setDcno(String dcno[]) {
		this.dcno = dcno;
	}
	public List<String> getDcnot() {
		return dcnot;
	}
	public void setDcnot(List<String> dcnot) {
		this.dcnot = dcnot;
	}
	public List<String> getQuantity() {
		return quantity;
	}
	public void setQuantity(List<String> quantity) {
		this.quantity = quantity;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public List<String> getHsncode() {
		return hsncode;
	}
	public void setHsncode(List<String> hsncode) {
		this.hsncode = hsncode;
	}
	public List<String> getRate() {
		return rate;
	}
	public void setRate(List<String> rate) {
		this.rate = rate;
	}
	public List<String> getMyrate() {
		return myrate;
	}
	public void setMyrate(List<String> myrate) {
		this.myrate = myrate;
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
	public List<String> getNetamt() {
		return netamt;
	}
	public void setNetamt(List<String> netamt) {
		this.netamt = netamt;
	}
	public List<String> getVat() {
		return vat;
	}
	public void setVat(List<String> vat) {
		this.vat = vat;
	}
	public List<String> getTaxqamount() {
		return taxqamount;
	}
	public void setTaxqamount(List<String> taxqamount) {
		this.taxqamount = taxqamount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<String> getDescription122() {
		return description122;
	}
	public void setDescription122(List<String> description122) {
		this.description122 = description122;
	}
	public List<String> getNn() {
		return nn;
	}
	public void setNn(List<String> nn) {
		this.nn = nn;
	}
	public List<String> getId1() {
		return id1;
	}
	public void setId1(List<String> id1) {
		this.id1 = id1;
	}
	public List<String> getQty122() {
		return qty122;
	}
	public void setQty122(List<String> qty122) {
		this.qty122 = qty122;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public int getMysize() {
		return mysize;
	}
	public void setMysize(int mysize) {
		this.mysize = mysize;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public List<String> getDcqty() {
		return dcqty;
	}
	public void setDcqty(List<String> dcqty) {
		this.dcqty = dcqty;
	}
	public List<String> getQtyremain() {
		return qtyremain;
	}
	public void setQtyremain(List<String> qtyremain) {
		this.qtyremain = qtyremain;
	}
	public String[] getDqty() {
		return dqty;
	}
	public void setDqty(String dqty[]) {
		this.dqty = dqty;
	}
	public String[] getReqty() {
		return reqty;
	}
	public void setReqty(String reqty[]) {
		this.reqty = reqty;
	}
	public String getJobs() {
		return jobs;
	}
	public void setJobs(String jobs) {
		this.jobs = jobs;
	}
	public String getDcnox() {
		return dcnox;
	}
	public void setDcnox(String dcnox) {
		this.dcnox = dcnox;
	}
	public String getDcdatex() {
		return dcdatex;
	}
	public void setDcdatex(String dcdatex) {
		this.dcdatex = dcdatex;
	}
	public String getTermcond() {
		return termcond;
	}
	public void setTermcond(String termcond) {
		this.termcond = termcond;
	}
	public String getTransport1() {
		return transport1;
	}
	public void setTransport1(String transport1) {
		this.transport1 = transport1;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getDespatch_id() {
		return despatch_id;
	}
	public void setDespatch_id(String despatch_id) {
		this.despatch_id = despatch_id;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getJob_card_id() {
		return job_card_id;
	}
	public void setJob_card_id(String job_card_id) {
		this.job_card_id = job_card_id;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_amt() {
		return total_amt;
	}
	public void setTotal_amt(String total_amt) {
		this.total_amt = total_amt;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	public String getPodate() {
		return podate;
	}
	public void setPodate(String podate) {
		this.podate = podate;
	}
	public String getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}
	public String getDc() {
		return dc;
	}
	public void setDc(String dc) {
		this.dc = dc;
	}
	public String getDcdate() {
		return dcdate;
	}
	public void setDcdate(String dcdate) {
		this.dcdate = dcdate;
	}
	public String getTps() {
		return tps;
	}
	public void setTps(String tps) {
		this.tps = tps;
	}
	public String getContactp() {
		return contactp;
	}
	public void setContactp(String contactp) {
		this.contactp = contactp;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getShipp() {
		return shipp;
	}
	public void setShipp(String shipp) {
		this.shipp = shipp;
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
	public List<String> getEmail22() {
		return email22;
	}
	public void setEmail22(List<String> email22) {
		this.email22 = email22;
	}
	public List<String> getBatcht() {
		return batcht;
	}
	public void setBatcht(List<String> batcht) {
		this.batcht = batcht;
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
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}

	
	  
}
