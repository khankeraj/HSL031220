package com.master.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.CityMasterDao;
import com.master.dao.CustomerMasterDAO;
import com.master.dao.DesignationMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.ProductMasterDao;
import com.master.dao.RateMasterDao;
import com.master.dao.TransporterMasterDao;
import com.master.dao.VehicleMasterDao;
import com.master.model.CityModel;
import com.master.model.CustomerMasterModel;
import com.master.model.DesignationModel;
import com.master.model.DriverModel;
import com.master.model.EmployeeMasterModel;
import com.master.model.ProductModel;
import com.master.model.RateMasterModel;
import com.master.model.TransporterModel;
import com.master.model.VehicleModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RateMasterAction extends ActionSupport implements ModelDriven{

	private RateMasterModel rate_modal=new RateMasterModel();
	
	public RateMasterModel getRate_modal() {
		return rate_modal;
	}




	public void setRate_modal(RateMasterModel rate_modal) {
		this.rate_modal = rate_modal;
	}




	private List<RateMasterModel> rate_modalDetails;

	
	private List<RateMasterModel> vtype;
	public List<RateMasterModel> getVtype() {
		return vtype;
	}




	public void setVtype(List<RateMasterModel> vtype) {
		this.vtype = vtype;
	}




	public List<RateMasterModel> getRate_modalDetails() {
		return rate_modalDetails;
	}




	public void setRate_modalDetails(List<RateMasterModel> rate_modalDetails) {
		this.rate_modalDetails = rate_modalDetails;
	}


	public String rateMaster() {
		
		vtype=new RateMasterDao().fetchCityMasterDetails();
		return "success";
	}

	public String fetchRateMasterDetails()
	{
		String response;
		rate_modalDetails=new RateMasterDao().fetchRateMasterDetails(rate_modal);
		if(rate_modalDetails.size()>0)
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
		return rate_modal;
	}

	

	
}
