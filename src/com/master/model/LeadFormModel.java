package com.master.model;


public class LeadFormModel{
	
	private int cust_id;
	private String lead_serial_no;
	private String customer_name;
	private String contact_no;
	private String ref_no;
	
	public String getRef_no() {
		return ref_no;
	}
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	public String getLead_serial_no() {
		return lead_serial_no;
	}
	public void setLead_serial_no(String lead_serial_no) {
		this.lead_serial_no = lead_serial_no;
	}

	private String product;
	private String amount;
	private String city;
	private String zone;
	private String area;
	private String requiredDate;
	private String remark;
	private String contact_person;
	private String image;
	private String resource;
	private int status;
	private String lead_status;
	private String  meeting_status;
	private int  mysize;
	private String  mystatus[];
	private String  indexName[];
	private String dates[];
	private String reqDate;
	private String LeadSize;
	public String getLead_status() {
		return lead_status;
	}
	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}
	public String getMeeting_status() {
		return meeting_status;
	}
	public void setMeeting_status(String meeting_status) {
		this.meeting_status = meeting_status;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String[] getMystatus() {
		return mystatus;
	}
	public void setMystatus(String mystatus[]) {
		this.mystatus = mystatus;
	}
	public int getMysize() {
		return mysize;
	}
	public void setMysize(int mysize) {
		this.mysize = mysize;
	}
	
	public String[] getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName[]) {
		this.indexName = indexName;
	}
	public String[] getDates() {
		return dates;
	}
	public void setDates(String dates[]) {
		this.dates = dates;
	}
	public String getReqDate() {
		return reqDate;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public String getLeadSize() {
		return LeadSize;
	}
	public void setLeadSize(String leadSize) {
		LeadSize = leadSize;
	}
	
}
