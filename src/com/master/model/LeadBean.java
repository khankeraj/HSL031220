package com.master.model;

import java.util.ArrayList;
import java.util.List;

public class LeadBean {
	private String customer_name;
	private String mob_no;
	private String product;
	private String uname;
	private String partno1;
	private String mid;
	private String emp_name;
	private String emp_id;
	private String time;
	private String times;
	private String terms;
	private String assign_to;
	private String assign_to_code;
	private String pdf_img;
	private String partno[];
	private int sn;
	private String datetime;
	private String unit1[];
	private String cp;
	private String free;
	private String unit2;
	
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String sename;
	
	private String assign_status;
	private String amount;

	private String city;
	private String from_date;
	private String to_date;
	public String getFrom_date() {
		return from_date;
	}
	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}
	public String getTo_date() {
		return to_date;
	}
	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}
	private String zone;
	private String qtid;
	private String area;
	private String date;
	private String contact_person;
	private String remark;
	private String qtno;
	private String status;
	private String img;
	private String description;
	private String image;
	private String pending_days;
	public String getPending_days() {
		return pending_days;
	}
	public void setPending_days(String pending_days) {
		this.pending_days = pending_days;
	}
	private String reference;
	private String kindattn;
	private String leadid;
	private String recamount;
	private String reason;
	private String rno;
	public String getRecamount() {
		return recamount;
	}
	public void setRecamount(String recamount) {
		this.recamount = recamount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLeadid() {
		return leadid;
	}
	public void setLeadid(String leadid) {
		this.leadid = leadid;
	}
	private String totalbeforetax;
	private String gtotal;
	private String totaltax;
	private String pricemode;
	private String discountmode;
	private String Payment_percent;
	private String address;
	private String email;
	private String code[];
	private String model[];
	private String taxamount[];
	private String desc[];
	private String qty[];
	private String unitprice[];
	private String totalprice[];
	private String discount[];
	private String t_a_discount[];
	private String hsn[];
	private String tax[];
	private String tax_amount[];
	private String total[];
	private String unit[];
	
	private String code1;
	private String model1;
	private String taxamount1;
	private String desc1;
	private String qty1;
	private String unitprice1;
	private String totalprice1;
	private String discount1;
	private String t_a_discount1;
	private String hsn1;
	private String tax1;
	
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getModel1() {
		return model1;
	}
	public void setModel1(String model1) {
		this.model1 = model1;
	}
	public String getTaxamount1() {
		return taxamount1;
	}
	public void setTaxamount1(String taxamount1) {
		this.taxamount1 = taxamount1;
	}
	public String getDesc1() {
		return desc1;
	}
	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}
	public String getQty1() {
		return qty1;
	}
	public void setQty1(String qty1) {
		this.qty1 = qty1;
	}
	public String getUnitprice1() {
		return unitprice1;
	}
	public void setUnitprice1(String unitprice1) {
		this.unitprice1 = unitprice1;
	}
	public String getTotalprice1() {
		return totalprice1;
	}
	public void setTotalprice1(String totalprice1) {
		this.totalprice1 = totalprice1;
	}
	public String getDiscount1() {
		return discount1;
	}
	public void setDiscount1(String discount1) {
		this.discount1 = discount1;
	}
	public String getT_a_discount1() {
		return t_a_discount1;
	}
	public void setT_a_discount1(String t_a_discount1) {
		this.t_a_discount1 = t_a_discount1;
	}
	public String getHsn1() {
		return hsn1;
	}
	public void setHsn1(String hsn1) {
		this.hsn1 = hsn1;
	}
	public String getTax1() {
		return tax1;
	}
	public void setTax1(String tax1) {
		this.tax1 = tax1;
	}
	public String getTotal1() {
		return total1;
	}
	public void setTotal1(String total1) {
		this.total1 = total1;
	}
	private String total1;
	
	
	
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getKindattn() {
		return kindattn;
	}
	public void setKindattn(String kindattn) {
		this.kindattn = kindattn;
	}
	public String getTotalbeforetax() {
		return totalbeforetax;
	}
	public void setTotalbeforetax(String totalbeforetax) {
		this.totalbeforetax = totalbeforetax;
	}
	
	public String[] getCode() {
		return code;
	}
	public void setCode(String[] code) {
		this.code = code;
	}
	public String[] getModel() {
		return model;
	}
	public void setModel(String[] model) {
		this.model = model;
	}
	public String[] getDesc() {
		return desc;
	}
	public void setDesc(String[] desc) {
		this.desc = desc;
	}
	public String[] getQty() {
		return qty;
	}
	public void setQty(String[] qty) {
		this.qty = qty;
	}
	public String[] getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String[] unitprice) {
		this.unitprice = unitprice;
	}
	public String[] getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String[] totalprice) {
		this.totalprice = totalprice;
	}
	public String[] getDiscount() {
		return discount;
	}
	public void setDiscount(String[] discount) {
		this.discount = discount;
	}
	public String[] getT_a_discount() {
		return t_a_discount;
	}
	public void setT_a_discount(String[] t_a_discount) {
		this.t_a_discount = t_a_discount;
	}
	public String[] getHsn() {
		return hsn;
	}
	public void setHsn(String[] hsn) {
		this.hsn = hsn;
	}
	public String[] getTax() {
		return tax;
	}
	public void setTax(String[] tax) {
		this.tax = tax;
	}
	public String[] getTax_amount() {
		return tax_amount;
	}
	public void setTax_amount(String[] tax_amount) {
		this.tax_amount = tax_amount;
	}
	public String[] getTotal() {
		return total;
	}
	public void setTotal(String[] total) {
		this.total = total;
	}
	public String getTotaltax() {
		return totaltax;
	}
	public void setTotaltax(String totaltax) {
		this.totaltax = totaltax;
	}
	public String getPricemode() {
		return pricemode;
	}
	public void setPricemode(String pricemode) {
		this.pricemode = pricemode;
	}
	public String getDiscountmode() {
		return discountmode;
	}
	public void setDiscountmode(String discountmode) {
		this.discountmode = discountmode;
	}
	public String getPayment_percent() {
		return Payment_percent;
	}
	public void setPayment_percent(String payment_percent) {
		Payment_percent = payment_percent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private String next_date;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNext_date() {
		return next_date;
	}
	public void setNext_date(String next_date) {
		this.next_date = next_date;
	}
	private String resource;
	private String type;
	private String id;
	//private String image;
	private String path2;
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getMob_no() {
		return mob_no;
	}
	public void setMob_no(String mob_no) {
		this.mob_no = mob_no;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void setPath2(String path2) {
		this.path2 = path2;
	}
	public String getPath2() {
		return path2;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getResource() {
		return resource;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setQtid(String qtid) {
		this.qtid = qtid;
	}
	public String getQtid() {
		return qtid;
	}
	public void setGtotal(String gtotal) {
		this.gtotal = gtotal;
	}
	public String getGtotal() {
		return gtotal;
	}
	public void setQtno(String qtno) {
		this.qtno = qtno;
	}
	public String getQtno() {
		return qtno;
	}
	public void setTaxamount(String taxamount[]) {
		this.taxamount = taxamount;
	}
	public String[] getTaxamount() {
		return taxamount;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getRno() {
		return rno;
	}
	/*public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return image;
	}*/
	public void setImg(String img) {
		this.img = img;
	}
	public String getImg() {
		return img;
	}
	public void setSename(String sename) {
		this.sename = sename;
	}
	public String getSename() {
		return sename;
	}
	public void setAssign_status(String assign_status) {
		this.assign_status = assign_status;
	}
	public String getAssign_status() {
		return assign_status;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUname() {
		return uname;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMid() {
		return mid;
	}
	public void setAssign_to(String assign_to) {
		this.assign_to = assign_to;
	}
	public String getAssign_to() {
		return assign_to;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public int getSn() {
		return sn;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getTimes() {
		return times;
	}
	public void setPdf_img(String pdf_img) {
		this.pdf_img = pdf_img;
	}
	public String getPdf_img() {
		return pdf_img;
	}
	public void setPartno(String partno[]) {
		this.partno = partno;
	}
	public String[] getPartno() {
		return partno;
	}
	public void setPartno1(String partno1) {
		this.partno1 = partno1;
	}
	public String getPartno1() {
		return partno1;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getTerms() {
		return terms;
	}
	public String getAssign_to_code() {
		return assign_to_code;
	}
	public void setAssign_to_code(String assign_to_code) {
		this.assign_to_code = assign_to_code;
	}
	public String[] getUnit() {
		return unit;
	}
	public void setUnit(String unit[]) {
		this.unit = unit;
	}
	public String[] getUnit1() {
		return unit1;
	}
	public void setUnit1(String unit1[]) {
		this.unit1 = unit1;
	}
	public String getUnit2() {
		return unit2;
	}
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	

	



		
}
