package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.RentalMasterDao;
import com.master.model.RentalModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RentalMasterAction extends ActionSupport implements ModelDriven {

	/* private DriverModel drivermodel = new DriverModel(); */

	private RentalModel rentalmodel = new RentalModel();

	private RentalModel rental_model = new RentalModel();

	private List<RentalModel> fetchRetalDetails;

	public String rentalMaster() {
		return "success";
	}

	public RentalModel getRentalmodel() {
		return rentalmodel;
	}

	public List<RentalModel> getFetchRetalDetails() {
		return fetchRetalDetails;
	}

	public void setFetchRetalDetails(List<RentalModel> fetchRetalDetails) {
		this.fetchRetalDetails = fetchRetalDetails;
	}

	public void setRentalmodel(RentalModel rentalmodel) {
		this.rentalmodel = rentalmodel;
	}

	public RentalModel getRental_model() {
		return rental_model;
	}

	public void setRental_model(RentalModel rental_model) {
		this.rental_model = rental_model;
	}

	public String insert_rental_Details() {

		HttpServletRequest request = ServletActionContext.getRequest();

		String response;
		int i = 0;
		try {
			i = new RentalMasterDao().insert_rental_Details(rentalmodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :" + i);

		if (i > 0) {
			response = "success";
		} else if (i == -1) {
			response = "already";
		} else {
			response = "fail";
		}
		return response;
	}

	
	
	public String fetchForUpdateRentalDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String rental_id = request.getParameter("rental_id");

		fetchRetalDetails = new RentalMasterDao().fetchForUpdateRentalDetailss(rental_model, rental_id);

		System.out.println(fetchRetalDetails.size());

		if (fetchRetalDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String update_rental_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String update_rental = request.getParameter("rental_id");
		System.out.println("update:" + update_rental);

		System.out.println("Rental modal rental_name : " + rentalmodel.getRental_name());

		int i = new RentalMasterDao().update_rental_details(rentalmodel, update_rental);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}
	
	
	public String deleteRentalMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_rental_id = request.getParameter("rental_id");

		int i = new RentalMasterDao().delete_rental_master(rental_model, delete_rental_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	
	

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return rentalmodel;
	}

}
