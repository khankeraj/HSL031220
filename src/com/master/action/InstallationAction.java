package com.master.action;

import com.master.dao.InstallationDAO;
import com.master.model.InstallationModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InstallationAction extends ActionSupport implements ModelDriven{

	private  InstallationModel installatiomn=new InstallationModel();
	
	
	public InstallationModel getInstallatiomn() {
		return installatiomn;
	}
	public void setInstallatiomn(InstallationModel installatiomn) {
		this.installatiomn = installatiomn;
	}
	public String execute()
	{
		return "success";
	}
	public String insert_installation_details()
	{
		String response;
		int i=new InstallationDAO().insert_installation_details(installatiomn);
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
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return installatiomn;
	}

}
