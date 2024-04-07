package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.DesignationMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.ProductMasterDao;
import com.master.dao.RouteMasterDao;
import com.master.model.CityModel;
import com.master.model.DesignationModel;
import com.master.model.DriverModel;
import com.master.model.ProductModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DesignationMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private DesignationModel designationmodel = new DesignationModel();
	
	
	
	
	public String designationMaster()
	{
		return "success";
	}
	
	
	
	


	public String insert_designation_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String response;
		int i = 0;
		try {
			i=new DesignationMasterDao().insert_designation_Details(designationmodel);
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
	


	public String update_designation_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_designation=request.getParameter("designation_id");
		System.out.println("update:"+update_designation);
		
		System.out.println("designation name : "+designationmodel.getDesignation_name());
		int i=new DesignationMasterDao().update_designation_details(designationmodel,update_designation);
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




	/*public ProductModel getProductmodel() {
		return productmodel;
	}







	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}*/







	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return designationmodel;
	}






	public DesignationModel getDesignationmodel() {
		return designationmodel;
	}






	public void setDesignationmodel(DesignationModel designationmodel) {
		this.designationmodel = designationmodel;
	}







	
	
	
	
	
}
