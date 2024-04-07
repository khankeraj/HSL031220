package com.quotation.model;

public class FABLabellingMachineModel {
	
	private int fab_labeling_id;
	private String fab_labeling_name;
	private String fab_labeling_subname;
	private String select_image;
	private String quotation_name;
	
	private String heading;
	private String specifications1[];
	private String quantity[];
	
	private String specifi;
	private String qty;
	
	private String features[];
	private String feature;
	
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
	public String getSpecifi() {
		return specifi;
	}
	public void setSpecifi(String specifi) {
		this.specifi = specifi;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String[] getSpecifications1() {
		return specifications1;
	}
	public void setSpecifications1(String[] specifications1) {
		this.specifications1 = specifications1;
	}
	private String fab_specifications[];
	private String fab_quantity[];
	
	public int getFab_labeling_id() {
		return fab_labeling_id;
	}
	public void setFab_labeling_id(int fab_labeling_id) {
		this.fab_labeling_id = fab_labeling_id;
	}
	public String getFab_labeling_name() {
		return fab_labeling_name;
	}
	public void setFab_labeling_name(String fab_labeling_name) {
		this.fab_labeling_name = fab_labeling_name;
	}
	public String getFab_labeling_subname() {
		return fab_labeling_subname;
	}
	public void setFab_labeling_subname(String fab_labeling_subname) {
		this.fab_labeling_subname = fab_labeling_subname;
	}
	public String getSelect_image() {
		return select_image;
	}
	public void setSelect_image(String select_image) {
		this.select_image = select_image;
	}
	public String[] getFab_specifications() {
		return fab_specifications;
	}
	public void setFab_specifications(String[] fab_specifications) {
		this.fab_specifications = fab_specifications;
	}
	public String[] getFab_quantity() {
		return fab_quantity;
	}
	public void setFab_quantity(String[] fab_quantity) {
		this.fab_quantity = fab_quantity;
	}
	public String getQuotation_name() {
		return quotation_name;
	}
	public void setQuotation_name(String quotation_name) {
		this.quotation_name = quotation_name;
	}

}
