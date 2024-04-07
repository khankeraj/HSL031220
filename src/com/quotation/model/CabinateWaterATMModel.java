package com.quotation.model;

public class CabinateWaterATMModel {
	
	private int cabinate_water_id;
	private String name_of_index;
	private String image;
	
	private String atm_deatils[];
	private String specifications[];
	private String quantity[];
	
	public int getCabinate_water_id() {
		return cabinate_water_id;
	}
	public void setCabinate_water_id(int cabinate_water_id) {
		this.cabinate_water_id = cabinate_water_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String[] getAtm_deatils() {
		return atm_deatils;
	}
	public void setAtm_deatils(String[] atm_deatils) {
		this.atm_deatils = atm_deatils;
	}
	public String[] getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String[] specifications) {
		this.specifications = specifications;
	}
	public String[] getQuantity() {
		return quantity;
	}
	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}
}
