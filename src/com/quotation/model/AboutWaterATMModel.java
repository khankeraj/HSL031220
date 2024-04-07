package com.quotation.model;

public class AboutWaterATMModel {
	private int aboutwateratm_id;
	private String name_of_index;
	private String subname;
	
	private String labelname[];
	private String details[];
	
	private String labelname2[];
	private String features[];
	
	public int getAboutwateratm_id() {
		return aboutwateratm_id;
	}
	public void setAboutwateratm_id(int aboutwateratm_id) {
		this.aboutwateratm_id = aboutwateratm_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String[] getLabelname() {
		return labelname;
	}
	public void setLabelname(String[] labelname) {
		this.labelname = labelname;
	}
	public String[] getDetails() {
		return details;
	}
	public void setDetails(String[] details) {
		this.details = details;
	}
	public String[] getLabelname2() {
		return labelname2;
	}
	public void setLabelname2(String[] labelname2) {
		this.labelname2 = labelname2;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}

}
