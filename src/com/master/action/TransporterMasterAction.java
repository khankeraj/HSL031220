package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.EmployeeMasterDAO;
import com.master.dao.TransporterMasterDao;
import com.master.model.ProductModel;
import com.master.model.TransporterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TransporterMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private TransporterModel transportermodel = new TransporterModel();
	
	
	
	
	
	
	
	
	


	public String insert_transporter_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String response;
		int i = 0;
		try {
			i=new TransporterMasterDao().insert_transporter_Details(transportermodel);
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
	
	
	public String update_expense_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_expense=request.getParameter("expense_id");
		System.out.println("update:"+update_expense);
		
		System.out.println("expence parti name : "+productmodel.getExp_parti());
		int i=new ProductMasterDao().update_expense_details(productmodel,update_expense);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}*/



	public String update_transporter_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_transporter=request.getParameter("transporter_id");
		System.out.println("update:"+update_transporter);
		
		System.out.println("transporter name : "+transportermodel.getTransporter_name());
		int i=new TransporterMasterDao().update_transporter_details(transportermodel,update_transporter);
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
		return transportermodel;
	}



	public TransporterModel getTransportermodel() {
		return transportermodel;
	}



	public void setTransportermodel(TransporterModel transportermodel) {
		this.transportermodel = transportermodel;
	}







	
	
	
	
	
}
