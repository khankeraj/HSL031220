package com.master.action;

import java.util.List;

import com.master.dao.GstTaxMasterDAO;
import com.master.model.GstTaxMasterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GstTaxMasterAction extends ActionSupport implements ModelDriven{

	private GstTaxMasterModel gsttaxmodel=new GstTaxMasterModel();
	private List<GstTaxMasterModel> fetchGstTaxRepo;
	
	public List<GstTaxMasterModel> getFetchGstTaxRepo() {
		return fetchGstTaxRepo;
	}

	public void setFetchGstTaxRepo(List<GstTaxMasterModel> fetchGstTaxRepo) {
		this.fetchGstTaxRepo = fetchGstTaxRepo;
	}

	public GstTaxMasterModel getGsttaxmodel() {
		return gsttaxmodel;
	}

	public void setGsttaxmodel(GstTaxMasterModel gsttaxmodel) {
		this.gsttaxmodel = gsttaxmodel;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_gst_tax_master()
	{
		String response;
		int i=new GstTaxMasterDAO().insert_gstTaxMaster(gsttaxmodel);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchGstTaxReports()
	{
		String response;
		fetchGstTaxRepo=new GstTaxMasterDAO().fetchGstTaxReports(gsttaxmodel);
		if(fetchGstTaxRepo.size()>0)
		{
			response="success";
		}else
		{
			response="fails";
		}
		return response;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return gsttaxmodel;
	}
}
