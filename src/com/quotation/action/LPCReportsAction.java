package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.LPCReportsDAO;
import com.quotation.model.LPCReportsModel;

public class LPCReportsAction extends ActionSupport implements ModelDriven {

	private LPCReportsModel lpcReporst=new LPCReportsModel();
	private List<LPCReportsModel> lpcReports;
	
	public LPCReportsModel getLpcReporst() {
		return lpcReporst;
	}



	public void setLpcReporst(LPCReportsModel lpcReporst) {
		this.lpcReporst = lpcReporst;
	}



	public List<LPCReportsModel> getLpcReports() {
		return lpcReports;
	}



	public void setLpcReports(List<LPCReportsModel> lpcReports) {
		this.lpcReports = lpcReports;
	}

	
	public String execute()
	{
		return "success";
	}

	public String fetchLPCReportsDetails()
	{
		String response;
		lpcReports=new LPCReportsDAO().fetchLPCReportsDetails(lpcReporst);
		if(lpcReports.size()>0)
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
		return lpcReporst;
	}

}
