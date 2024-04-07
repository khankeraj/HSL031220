package com.master.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CityMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.ProductMasterDao;
import com.master.dao.RouteMasterDao;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.master.model.ProductModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ExpenseMasterAction extends ActionSupport implements ModelDriven{

	/*private DriverModel drivermodel = new DriverModel();*/
	private ProductModel productmodel = new ProductModel();
	
	
	
	
	
	
	
	
	


	public String insert_expense_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String response;
		int i = 0;
		try {
			i=new ProductMasterDao().insert_expense_Details(productmodel);
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
	


	public String update_product_details()
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




	public ProductModel getProductmodel() {
		return productmodel;
	}







	public void setProductmodel(ProductModel productmodel) {
		this.productmodel = productmodel;
	}







	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return productmodel;
	}







	
	
	
	
	
}
