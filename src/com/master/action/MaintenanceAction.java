package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.MaintenanceDao;
import com.master.dao.ProductMasterDao;
import com.master.dao.RouteMasterDao;
import com.master.dao.TripDao;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.master.model.MaintenanceModel;
import com.master.model.ProductModel;
import com.master.model.TripModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MaintenanceAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private MaintenanceModel maintenancetmodel = new MaintenanceModel();
	/*private String from_date;
	private String to_date;*/
	private String vehicle_no;
	
	public String getVehicle_no() {
		return vehicle_no;
	}



	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}




	private List<MaintenanceModel> maintenanceDetails;
	
	
	
	
	
	
	
	


	public List<MaintenanceModel> getMaintenanceDetails() {
		return maintenanceDetails;
	}



	public void setMaintenanceDetails(List<MaintenanceModel> maintenanceDetails) {
		this.maintenanceDetails = maintenanceDetails;
	}



	



	public String insert_maintenance_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String response ="";
		//int i = 0;
		try {
			response=new MaintenanceDao().insertMaintenanceDetails(maintenancetmodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.println("i in action :"+i);
		
		/*if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}*/
		return response;
	}
	


	/*public String update_product_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_product=request.getParameter("product_id");
		System.out.println("update:"+update_product);
		
		System.out.println("product model name : "+productmodel.getProduct_name());
		int i=new ProductMasterDao().update_product_details(productmodel,update_product);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
*/



	public MaintenanceModel getMaintenancetmodel() {
		return maintenancetmodel;
	}







	public void setMaintenancetmodel(MaintenanceModel maintenancetmodel) {
		this.maintenancetmodel = maintenancetmodel;
	}







	public String maintenanceForm()
	{
		return "success";
	}


	public String fetchMaintenanceDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);
		
		maintenanceDetails=new MaintenanceDao().fetchMaintenanceDetails(vehicle_no);
		System.out.println("Size -- -- - "+maintenanceDetails.size());
		if(maintenanceDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	public String fetchMaintenanceDetails1()
	{
		
		return "success";
	}




	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return maintenancetmodel;
	}







	
	
	
	
	
}
