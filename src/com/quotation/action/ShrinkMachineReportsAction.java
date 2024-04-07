package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.ShrinkMachineReportsDAO;
import com.quotation.model.ShrinkMachineReportsModel;

public class ShrinkMachineReportsAction extends ActionSupport implements ModelDriven{

	private ShrinkMachineReportsModel shrinkmcreports=new ShrinkMachineReportsModel();
	private List<ShrinkMachineReportsModel> shmcreports;
	
	public ShrinkMachineReportsModel getShrinkmcreports() {
		return shrinkmcreports;
	}

	public void setShrinkmcreports(ShrinkMachineReportsModel shrinkmcreports) {
		this.shrinkmcreports = shrinkmcreports;
	}

	public List<ShrinkMachineReportsModel> getShmcreports() {
		return shmcreports;
	}

	public void setShmcreports(List<ShrinkMachineReportsModel> shmcreports) {
		this.shmcreports = shmcreports;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchShrinkMachineDetails()
	{
		String response;
		shmcreports=new ShrinkMachineReportsDAO().fetchShrinkMachineDetails(shrinkmcreports);
		if(shmcreports.size()>0)
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
		return shrinkmcreports;
	}

}
