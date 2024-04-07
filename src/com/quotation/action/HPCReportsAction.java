package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.HPCReportsDAO;
import com.quotation.model.HPCReportsModel;

public class HPCReportsAction extends ActionSupport implements ModelDriven{

	private HPCReportsModel hpcReports=new HPCReportsModel();
	
	private List<HPCReportsModel> hpcReports1;
	
	public HPCReportsModel getHpcReports() {
		return hpcReports;
	}

	public void setHpcReports(HPCReportsModel hpcReports) {
		this.hpcReports = hpcReports;
	}

	public List<HPCReportsModel> getHpcReports1() {
		return hpcReports1;
	}

	public void setHpcReports1(List<HPCReportsModel> hpcReports1) {
		this.hpcReports1 = hpcReports1;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchHPCReportsDetails()
	{
		String response;
		hpcReports1=new HPCReportsDAO().fetchHPCReportsDetails(hpcReports);
		if(hpcReports1.size()>0)
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
		return hpcReports;
	}

	
}
