package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.TaxMasterDAO;
import com.master.model.TaxMasterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TaxMasterAction extends ActionSupport implements ModelDriven{
	
	private TaxMasterModel taxmodel=new TaxMasterModel();
	private List<TaxMasterModel> fetchTaxRepo;
	private List<TaxMasterModel> fetchForUpdate;
	
	public List<TaxMasterModel> getFetchForUpdate() {
		return fetchForUpdate;
	}

	public void setFetchForUpdate(List<TaxMasterModel> fetchForUpdate) {
		this.fetchForUpdate = fetchForUpdate;
	}

	public List<TaxMasterModel> getFetchTaxRepo() {
		return fetchTaxRepo;
	}

	public void setFetchTaxRepo(List<TaxMasterModel> fetchTaxRepo) {
		this.fetchTaxRepo = fetchTaxRepo;
	}

	public TaxMasterModel getTaxmodel() {
		return taxmodel;
	}

	public void setTaxmodel(TaxMasterModel taxmodel) {
		this.taxmodel = taxmodel;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_tax_master()
	{
		String response;
		int i=new TaxMasterDAO().insert_tax_master(taxmodel);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchTaxReports()
	{
		String response;
		fetchTaxRepo=new TaxMasterDAO().fetchTaxReports(taxmodel);
		if(fetchTaxRepo.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}

	public String fetchForUpdate()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		int tax_id=Integer.parseInt(request.getParameter("tax_id"));
		
		fetchForUpdate=new TaxMasterDAO().fetchForUpdate(taxmodel,tax_id);
		if(fetchForUpdate.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String UpdateTaxMaster()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		int update_tax_id=Integer.parseInt(request.getParameter("update_id"));
		int i=new TaxMasterDAO().updateTaxMaster(taxmodel,update_tax_id);
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
	
	
	public String deleteTax()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		int tax_id=Integer.parseInt(request.getParameter("tax_id"));
		int i=new TaxMasterDAO().deleteTax(taxmodel,tax_id);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return taxmodel;
	}
}
