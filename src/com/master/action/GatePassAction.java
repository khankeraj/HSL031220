package com.master.action;

import com.master.dao.BankMasterDAO;
import com.master.dao.GatePassDAO;
import com.master.model.GatePassModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GatePassAction extends ActionSupport implements ModelDriven {

	private GatePassModel gatepassmodel=new GatePassModel();
	
	public GatePassModel getGatepassmodel() {
		return gatepassmodel;
	}

	public void setGatepassmodel(GatePassModel gatepassmodel) {
		this.gatepassmodel = gatepassmodel;
	}
	
	
	public String insert_gate_pass_master()
	{
		String response;
		int i=new GatePassDAO().insertGatePassMaster(gatepassmodel);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
	}
	
	/*public String insertGetPassMDetails()
	{
		String response;
		int i=new GatePassDAO().insert_gate_pass_issueDetails();
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
	}*/
	
	public String execute()
	{
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return gatepassmodel;
	}

}
