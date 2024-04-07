package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.HotFABMoldReportsDAO;
import com.quotation.model.HOTFABMoldReportsModel;

public class HOTFABMoldReportsAction extends ActionSupport implements ModelDriven{

	private HOTFABMoldReportsModel hotfab=new HOTFABMoldReportsModel();
	private List<HOTFABMoldReportsModel> hotfabReports;
	

	public HOTFABMoldReportsModel getHotfab() {
		return hotfab;
	}

	public void setHotfab(HOTFABMoldReportsModel hotfab) {
		this.hotfab = hotfab;
	}

	public List<HOTFABMoldReportsModel> getHotfabReports() {
		return hotfabReports;
	}

	public void setHotfabReports(List<HOTFABMoldReportsModel> hotfabReports) {
		this.hotfabReports = hotfabReports;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchHotFabMoldingDetails()
	{
		String response;
		hotfabReports=new HotFABMoldReportsDAO().fetchHotFabMoldingDetails(hotfab);
		
		if(hotfabReports.size()>0)
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
		return null;
	}

}
