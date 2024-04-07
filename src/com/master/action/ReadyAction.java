package com.master.action;

import com.master.dao.ReadyDAO;
import com.master.model.ReadyModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReadyAction extends ActionSupport implements ModelDriven{

	private ReadyModel readyModel=new ReadyModel();
	
	public ReadyModel getReadyModel() {
		return readyModel;
	}

	public void setReadyModel(ReadyModel readyModel) {
		this.readyModel = readyModel;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_ready_details()
	{
		String rsponse;
		int i=new ReadyDAO().insert_ready_details(readyModel);
				if(i>0)
				{
					rsponse="success";
				}else
				{
					rsponse="fail";
				}
				return rsponse;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return readyModel;
	}
	
	

}
