package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.pwpcReportsDAO;
import com.quotation.model.pwpcReportsModel;

public class pwpcReportsAction extends ActionSupport implements ModelDriven{

	private pwpcReportsModel pwpc=new pwpcReportsModel();
	private List<pwpcReportsModel> pwpc_list;
	
	
	public pwpcReportsModel getPwpc() {
		return pwpc;
	}


	public void setPwpc(pwpcReportsModel pwpc) {
		this.pwpc = pwpc;
	}


	public List<pwpcReportsModel> getPwpc_list() {
		return pwpc_list;
	}


	public void setPwpc_list(List<pwpcReportsModel> pwpc_list) {
		this.pwpc_list = pwpc_list;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchPWPCReports()
	{
		String response;
		pwpc_list=new pwpcReportsDAO().fetchPWPCReports(pwpc);
		if(pwpc_list.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return  response;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return pwpc;
	}

}
