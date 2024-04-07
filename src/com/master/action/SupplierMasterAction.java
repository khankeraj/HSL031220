package com.master.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.master.dao.Company_Master_Bean;
import com.master.dao.SupplierMasterDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SupplierMasterAction extends ActionSupport implements ModelDriven{
	
	private Company_Master_Bean suppliermaster=new Company_Master_Bean();
	private List<Company_Master_Bean> listofsupplier;

	public List<Company_Master_Bean> getListofsupplier() {
		return listofsupplier;
	}

	public void setListofsupplier(List<Company_Master_Bean> listofsupplier) {
		this.listofsupplier = listofsupplier;
	}

	public Company_Master_Bean getSuppliermaster() {
		return suppliermaster;
	}

	public void setSuppliermaster(Company_Master_Bean suppliermaster) {
		this.suppliermaster = suppliermaster;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insertCompanyMaster()
	{
		String response;
		 response=new SupplierMasterDAO().insertCompanyMaster(suppliermaster);
		if(response!=null)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String fetchSupplierDetails()
	{
		String response = null;
		try {
			listofsupplier=new SupplierMasterDAO().fetchCompanyReport();
			if(listofsupplier.size()>0)
			{
				response="success";
			}
			else
			{
				response="fail";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
		
	}

	@Override
	public Object getModel() {
		return suppliermaster;
	}

}
