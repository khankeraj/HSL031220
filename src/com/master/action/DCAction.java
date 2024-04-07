package com.master.action;

import com.master.dao.DCDAO;
import com.master.model.DCModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DCAction extends ActionSupport implements ModelDriven {

 private DCModel dc_model=new DCModel();
 
 public DCModel getDc_model() {
	return dc_model;
}
public void setDc_model(DCModel dc_model) {
	this.dc_model = dc_model;
}
public String execute()
 {
	 return "success";
 }

public String insert_dc_details()
{
	String response;
	int i=new DCDAO().insert_dc_details(dc_model);
	if(i>0)
	{
		response="success";
	}
	else
	{
		response="success";
	}
	return response;
}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return dc_model;
	}

}
