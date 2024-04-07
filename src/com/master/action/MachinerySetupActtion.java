package com.master.action;

import java.util.List;

import com.master.dao.MachinerySetupDAO;
import com.master.model.MachinerySetupModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MachinerySetupActtion extends ActionSupport implements ModelDriven{
	
	private MachinerySetupModel machinery_setup=new MachinerySetupModel();
	private List<MachinerySetupModel> machinery_setup1;
	
	public List<MachinerySetupModel> getMachinery_setup1() {
		return machinery_setup1;
	}

	public void setMachinery_setup1(List<MachinerySetupModel> machinery_setup1) {
		this.machinery_setup1 = machinery_setup1;
	}

	public MachinerySetupModel getMachinery_setup() {
		return machinery_setup;
	}

	public void setMachinery_setup(MachinerySetupModel machinery_setup) {
		this.machinery_setup = machinery_setup;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_machinery_details()
	{
		String response="";
		
		int status=new MachinerySetupDAO().insert_machinery_details(machinery_setup);
		
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String get_machinery_setup_details()
	{
		String response="";
		machinery_setup1=new MachinerySetupDAO().fetchnameOfIndex(machinery_setup);
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return machinery_setup;
	}
}
