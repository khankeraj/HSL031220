package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FABRFCReportsDAO;
import com.quotation.model.FABRFCReportsModel;

public class FABRFCReportsAction extends ActionSupport implements ModelDriven{

	private FABRFCReportsModel fabrfc=new FABRFCReportsModel();
	private List<FABRFCReportsModel> fabrfc1;
	

	public FABRFCReportsModel getFabrfc() {
		return fabrfc;
	}

	public void setFabrfc(FABRFCReportsModel fabrfc) {
		this.fabrfc = fabrfc;
	}

	public List<FABRFCReportsModel> getFabrfc1() {
		return fabrfc1;
	}

	public void setFabrfc1(List<FABRFCReportsModel> fabrfc1) {
		this.fabrfc1 = fabrfc1;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchFABRFCReports()
	{
		String response;
		fabrfc1=new FABRFCReportsDAO().fetchFABRFCReports(fabrfc);
		if(fabrfc1.size()>0)
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
		return fabrfc;
	}

}
