package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.RentalMasterDao;
import com.master.model.RentalModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RentalMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/

	private RentalModel rentalmodel = new RentalModel();
	


	public RentalModel getRentalmodel() {
		return rentalmodel;
	}



	public void setRentalmodel(RentalModel rentalmodel) {
		this.rentalmodel = rentalmodel;
	}

	
	public String insert_rental_Details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String response;
		int i = 0;
		try {
			i=new RentalMasterDao().insert_rental_Details(rentalmodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
		if(i>0)
		{
			response="success";
		}
		else if(i==-1)
		{
			response="already";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return rentalmodel;
	}



	
	
}
