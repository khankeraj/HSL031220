package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.RentalMasterDao;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.master.model.RentalModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CityMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private CityModel citymodel = new CityModel();

	
	private CityModel city_modal=new CityModel();


	public CityModel getCity_modal() {
		return city_modal;
	}



	public void setCity_modal(CityModel city_modal) {
		this.city_modal = city_modal;
	}


	public String insert_city_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String response;
		int i = 0;
		try {
			i=new CityMasterDao().insert_city_Details(citymodel);
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
	
	
	public String update_city_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_city=request.getParameter("city_id");
		System.out.println("update:"+update_city);
		
		System.out.println("city modal city_name : "+citymodel.getCity_name());
		int i=new CityMasterDao().update_city_details(citymodel,update_city);
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
	

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return citymodel;
	}







	public CityModel getCitymodel() {
		return citymodel;
	}







	public void setCitymodel(CityModel citymodel) {
		this.citymodel = citymodel;
	}
	
	
	
	
}
