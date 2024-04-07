package com.master.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InquiryBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String issue_no;
	private String customer_no;
	private String customer_name;
	private String lead_id;
	
	private String from_date;
	private String to_date1;
	
	private String purchaserate[];
	private String typerate[];
	private String salerate[];
	
	private String mobile_no;
	private String date;
	private String employee;
	private String[] description;
	private String[] quantity;
	private String pono;
	private String remark;
	private String issue_status;
	
	private String print_file12;
	
	private String total12;
	
	
	public String[] getPurchaserate() {
		return purchaserate;
	}
	public void setPurchaserate(String[] purchaserate) {
		this.purchaserate = purchaserate;
	}
	public String[] getTyperate() {
		return typerate;
	}
	public void setTyperate(String[] typerate) {
		this.typerate = typerate;
	}
	public String[] getSalerate() {
		return salerate;
	}
	public void setSalerate(String[] salerate) {
		this.salerate = salerate;
	}
	public String getTotal12() {
		return total12;
	}
	public void setTotal12(String total12) {
		this.total12 = total12;
	}

	private String lr_no12;
	

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
	public String getLr_no12() {
		return lr_no12;
	}
	public void setLr_no12(String lr_no12) {
		this.lr_no12 = lr_no12;
	}
	public String getPrint_file12() {
		return print_file12;
	}
	public void setPrint_file12(String print_file12) {
		this.print_file12 = print_file12;
	}

	private String lr_amount;
	
	public String getLr_amount() {
		return lr_amount;
	}
	public void setLr_amount(String lr_amount) {
		this.lr_amount = lr_amount;
	}

	private String name;
	private String reference;
	private String kind_attn;
	private String bill_to;
	public String getBill_to() {
		return bill_to;
	}
	public void setBill_to(String bill_to) {
		this.bill_to = bill_to;
	}

	private String buyername;
	private String buyeradd;
	private String buyerstatus;
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public String getBuyeradd() {
		return buyeradd;
	}
	public void setBuyeradd(String buyeradd) {
		this.buyeradd = buyeradd;
	}
	public String getBuyerstatus() {
		return buyerstatus;
	}
	public void setBuyerstatus(String buyerstatus) {
		this.buyerstatus = buyerstatus;
	}
	public String getBuyergstn() {
		return buyergstn;
	}
	public void setBuyergstn(String buyergstn) {
		this.buyergstn = buyergstn;
	}
	public String getBuyer_contact_person() {
		return buyer_contact_person;
	}
	public void setBuyer_contact_person(String buyer_contact_person) {
		this.buyer_contact_person = buyer_contact_person;
	}
	public String getBuyer_contact_no() {
		return buyer_contact_no;
	}
	public void setBuyer_contact_no(String buyer_contact_no) {
		this.buyer_contact_no = buyer_contact_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String buyergstn;
	private String buyer_contact_person;
	private String buyer_contact_no;
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getKind_attn() {
		return kind_attn;
	}
	public void setKind_attn(String kind_attn) {
		this.kind_attn = kind_attn;
	}

	private String id;
	
	private String halt_charge;
	
	private String gstn;
	
	private String state;
	
	private String payterm;
	
	private String job_no;
	
	private String amountinwords;
	
	private String reason;
	
	private String mobile;
	
	private String contact_person;
	
	private String rno;
	
	private String contactp;
	private String exp_date;
	
	private String exim;
	
	private String contact_no;
	private String source;
	private String resource;
	private String destination;
	
	private String inquiry_id;
	private String pricing_id;
	
	private String total;
	
	private String total1;
	
	private String vendor;
	
	private String quotation_no;
	private String address;
	
	private String dealer_id;
	
	
	private String aa[];
	private String bb[];
	private String cc[];
	private String dd[];
	private String ee[];
	private String ff[];
	private String gg[];
	private String hh[];
	private String ii[];
	
	private String transname[];
	private String transtype[];
	
	
	
	public String[] getTransname() {
		return transname;
	}
	public void setTransname(String[] transname) {
		this.transname = transname;
	}
	public String[] getTranstype() {
		return transtype;
	}
	public void setTranstype(String[] transtype) {
		this.transtype = transtype;
	}

	private String aa1;
	private String bb1;
	private String cc1;
	private String dd1;
	private String ee1;
	private String ff1;
	private String gg1;
	private String hh1;
	private String ii1;
	
	
	private int sn;
	
	
	
	private String order_id;
	private String src_contact_person;
	private String src_contact_no;
	private String dest_contact_person;
	private String dest_contact_no;
	
	
	
	private String shipstate;
	private String shipgstn;
	private String shipname;
	private String shipadd;
	private String ebillno;
	private String invoiceno;
	private String route;
	private String delevery_date;
	
	
	
	private String delivery_time;
	private String vehicle_type;
	
	
	
	private String type;
	private String resource_from;
	
	private String transporter_name;
	private String vehicle_no;
	private String driver_name;
	private String driver_mobile;
	
	private String loadname;
	private String loadadd;
	private String loadstate;
	private String loadgstn;
	
	private String load_contact_person;
	private String load_contact_no;
	private String lr_no;
	
	private String transport_code;
	private String driver_code;
	
	
	private List<String> schemeid1 = new ArrayList<String>();
	
	private List<String> schemename1 = new ArrayList<String>();
	private List<String> city1 = new ArrayList<String>();
	
	private int sparesize;
	
	
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
	
	List<String> descriptiont=new ArrayList<String>();
	List<String> quantityt=new ArrayList<String>();
	

	
	List<String> lrno=new ArrayList<String>();
	List<String> drivername=new ArrayList<String>();
	List<String> expdate=new ArrayList<String>();
	List<String> exppart1=new ArrayList<String>();
	List<String> expamt=new ArrayList<String>();
	List<String> vehicleno=new ArrayList<String>();
	List<String> remark1=new ArrayList<String>();

	List<String> givenby=new ArrayList<String>();
		
	List<String> bank22=new ArrayList<String>();
	List<String> totalamt=new ArrayList<String>();
	List<String> account22=new ArrayList<String>();
	
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
	public List<String> getVehicleno() {
		return vehicleno;
	}
	public void setVehicleno(List<String> vehicleno) {
		this.vehicleno = vehicleno;
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
	public List<String> getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(List<String> totalamt) {
		this.totalamt = totalamt;
	}

	List<String> ifsc22=new ArrayList<String>();
	List<String> branch22=new ArrayList<String>();
	
	public String getIssue_status() {
		return issue_status;
	}
	public void setIssue_status(String issue_status) {
		this.issue_status = issue_status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIssue_no() {
		return issue_no;
	}
	public void setIssue_no(String issue_no) {
		this.issue_no = issue_no;
	}
	public String getPono() {
		return pono;
	}
	public void setPono(String pono) {
		this.pono = pono;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getLead_id() {
		return lead_id;
	}
	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
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
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public String[] getAa() {
		return aa;
	}
	public void setAa(String[] aa) {
		this.aa = aa;
	}
	public String[] getBb() {
		return bb;
	}
	public void setBb(String[] bb) {
		this.bb = bb;
	}
	public String[] getCc() {
		return cc;
	}
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	public String[] getDd() {
		return dd;
	}
	public void setDd(String[] dd) {
		this.dd = dd;
	}
	public String[] getEe() {
		return ee;
	}
	public void setEe(String[] ee) {
		this.ee = ee;
	}
	public String[] getFf() {
		return ff;
	}
	public void setFf(String[] ff) {
		this.ff = ff;
	}
	public String[] getGg() {
		return gg;
	}
	public void setGg(String[] gg) {
		this.gg = gg;
	}
	public String[] getHh() {
		return hh;
	}
	public void setHh(String[] hh) {
		this.hh = hh;
	}
	
	public String getAa1() {
		return aa1;
	}
	public void setAa1(String aa1) {
		this.aa1 = aa1;
	}
	public String getBb1() {
		return bb1;
	}
	public void setBb1(String bb1) {
		this.bb1 = bb1;
	}
	public String getCc1() {
		return cc1;
	}
	public void setCc1(String cc1) {
		this.cc1 = cc1;
	}
	public String getDd1() {
		return dd1;
	}
	public void setDd1(String dd1) {
		this.dd1 = dd1;
	}
	public String getEe1() {
		return ee1;
	}
	public void setEe1(String ee1) {
		this.ee1 = ee1;
	}
	public String getFf1() {
		return ff1;
	}
	public void setFf1(String ff1) {
		this.ff1 = ff1;
	}
	public String getGg1() {
		return gg1;
	}
	public void setGg1(String gg1) {
		this.gg1 = gg1;
	}
	public String getHh1() {
		return hh1;
	}
	public void setHh1(String hh1) {
		this.hh1 = hh1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return issue_no+" "+customer_no+" "+customer_name+" "+lead_id+" "+mobile_no+" "+date+" "+employee+" "+description+" "+quantity+" "+pono+" "+lead_id;
	}
	public String getInquiry_id() {
		return inquiry_id;
	}
	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}
	public String getPricing_id() {
		return pricing_id;
	}
	public void setPricing_id(String pricing_id) {
		this.pricing_id = pricing_id;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getQuotation_no() {
		return quotation_no;
	}
	public void setQuotation_no(String quotation_no) {
		this.quotation_no = quotation_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getSrc_contact_person() {
		return src_contact_person;
	}
	public void setSrc_contact_person(String src_contact_person) {
		this.src_contact_person = src_contact_person;
	}
	public String getSrc_contact_no() {
		return src_contact_no;
	}
	public void setSrc_contact_no(String src_contact_no) {
		this.src_contact_no = src_contact_no;
	}
	public String getDest_contact_person() {
		return dest_contact_person;
	}
	public void setDest_contact_person(String dest_contact_person) {
		this.dest_contact_person = dest_contact_person;
	}
	public String getDest_contact_no() {
		return dest_contact_no;
	}
	public void setDest_contact_no(String dest_contact_no) {
		this.dest_contact_no = dest_contact_no;
	}
	public String getShipstate() {
		return shipstate;
	}
	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}
	public String getShipgstn() {
		return shipgstn;
	}
	public void setShipgstn(String shipgstn) {
		this.shipgstn = shipgstn;
	}
	public String getShipname() {
		return shipname;
	}
	public void setShipname(String shipname) {
		this.shipname = shipname;
	}
	public String getShipadd() {
		return shipadd;
	}
	public void setShipadd(String shipadd) {
		this.shipadd = shipadd;
	}
	public String getEbillno() {
		return ebillno;
	}
	public void setEbillno(String ebillno) {
		this.ebillno = ebillno;
	}
	public String getInvoiceno() {
		return invoiceno;
	}
	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDelevery_date() {
		return delevery_date;
	}
	public void setDelevery_date(String delevery_date) {
		this.delevery_date = delevery_date;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	public String getVehicle_type() {
		return vehicle_type;
	}
	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}
	public String getTotal1() {
		return total1;
	}
	public void setTotal1(String total1) {
		this.total1 = total1;
	}
	public String getResource_from() {
		return resource_from;
	}
	public void setResource_from(String resource_from) {
		this.resource_from = resource_from;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String[] getIi() {
		return ii;
	}
	public void setIi(String[] ii) {
		this.ii = ii;
	}
	public String getIi1() {
		return ii1;
	}
	public void setIi1(String ii1) {
		this.ii1 = ii1;
	}
	public String getExim() {
		return exim;
	}
	public void setExim(String exim) {
		this.exim = exim;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContactp() {
		return contactp;
	}
	public void setContactp(String contactp) {
		this.contactp = contactp;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getTransporter_name() {
		return transporter_name;
	}
	public void setTransporter_name(String transporter_name) {
		this.transporter_name = transporter_name;
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
	public String getDriver_mobile() {
		return driver_mobile;
	}
	public void setDriver_mobile(String driver_mobile) {
		this.driver_mobile = driver_mobile;
	}
	public String getLoadname() {
		return loadname;
	}
	public void setLoadname(String loadname) {
		this.loadname = loadname;
	}
	public String getLoadadd() {
		return loadadd;
	}
	public void setLoadadd(String loadadd) {
		this.loadadd = loadadd;
	}
	public String getLoadstate() {
		return loadstate;
	}
	public void setLoadstate(String loadstate) {
		this.loadstate = loadstate;
	}
	public String getLoadgstn() {
		return loadgstn;
	}
	public void setLoadgstn(String loadgstn) {
		this.loadgstn = loadgstn;
	}
	public String getLoad_contact_person() {
		return load_contact_person;
	}
	public void setLoad_contact_person(String load_contact_person) {
		this.load_contact_person = load_contact_person;
	}
	public String getLoad_contact_no() {
		return load_contact_no;
	}
	public void setLoad_contact_no(String load_contact_no) {
		this.load_contact_no = load_contact_no;
	}
	public String getLr_no() {
		return lr_no;
	}
	public void setLr_no(String lr_no) {
		this.lr_no = lr_no;
	}
	public String getTransport_code() {
		return transport_code;
	}
	public void setTransport_code(String transport_code) {
		this.transport_code = transport_code;
	}
	public String getDriver_code() {
		return driver_code;
	}
	public void setDriver_code(String driver_code) {
		this.driver_code = driver_code;
	}
	public List<String> getSchemeid1() {
		return schemeid1;
	}
	public void setSchemeid1(List<String> schemeid1) {
		this.schemeid1 = schemeid1;
	}
	public List<String> getSchemename1() {
		return schemename1;
	}
	public void setSchemename1(List<String> schemename1) {
		this.schemename1 = schemename1;
	}
	public List<String> getCity1() {
		return city1;
	}
	public void setCity1(List<String> city1) {
		this.city1 = city1;
	}
	public int getSparesize() {
		return sparesize;
	}
	public void setSparesize(int sparesize) {
		this.sparesize = sparesize;
	}
	
	private int gridsize;
	
	public List<String> getDcnot() {
		return dcnot;
	}
	public void setDcnot(List<String> dcnot) {
		this.dcnot = dcnot;
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
	public List<String> getMyamt() {
		return myamt;
	}
	public void setMyamt(List<String> myamt) {
		this.myamt = myamt;
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
	public List<String> getDescriptiont() {
		return descriptiont;
	}
	public void setDescriptiont(List<String> descriptiont) {
		this.descriptiont = descriptiont;
	}
	public List<String> getQuantityt() {
		return quantityt;
	}
	public void setQuantityt(List<String> quantityt) {
		this.quantityt = quantityt;
	}
	public List<String> getBank22() {
		return bank22;
	}
	public void setBank22(List<String> bank22) {
		this.bank22 = bank22;
	}
	public List<String> getAccount22() {
		return account22;
	}
	public void setAccount22(List<String> account22) {
		this.account22 = account22;
	}
	public List<String> getIfsc22() {
		return ifsc22;
	}
	public void setIfsc22(List<String> ifsc22) {
		this.ifsc22 = ifsc22;
	}
	public List<String> getBranch22() {
		return branch22;
	}
	public void setBranch22(List<String> branch22) {
		this.branch22 = branch22;
	}
	public int getGridsize() {
		return gridsize;
	}
	public void setGridsize(int gridsize) {
		this.gridsize = gridsize;
	}
	public String getGstn() {
		return gstn;
	}
	public void setGstn(String gstn) {
		this.gstn = gstn;
	}
	public String getJob_no() {
		return job_no;
	}
	public void setJob_no(String job_no) {
		this.job_no = job_no;
	}
	public String getAmountinwords() {
		return amountinwords;
	}
	public void setAmountinwords(String amountinwords) {
		this.amountinwords = amountinwords;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPayterm() {
		return payterm;
	}
	public void setPayterm(String payterm) {
		this.payterm = payterm;
	}
	public String getHalt_charge() {
		return halt_charge;
	}
	public void setHalt_charge(String halt_charge) {
		this.halt_charge = halt_charge;
	}
 }