package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.RouteMasterDao;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RouteMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private CityModel citymodel = new CityModel();
	
	
	
	
	
	
	
	
	


	public String insert_route_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String response;
		int i = 0;
		try {
			i=new RouteMasterDao().insert_route_Details(citymodel);
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
	
	
	
	public String update_route_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_route=request.getParameter("route_id");
		System.out.println("update:"+update_route);
		
		System.out.println("city model route : "+citymodel.getRoute());
		int i=new RouteMasterDao().update_route_details(citymodel,update_route);
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
