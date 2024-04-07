package com.master.action;

import com.master.dao.ResourceMasterDAO;
import com.master.model.ResourceMasterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ResourceMasterAction  extends ActionSupport implements ModelDriven{

	private ResourceMasterModel resource=new ResourceMasterModel();

	public ResourceMasterModel getResorce() {
		return resource;
	}
	
	public String execute()
	{
		return "success";
	}
	
	public String insert_resource_master()
	{
		String response;
		int i=new ResourceMasterDAO().insert_resource_master(resource);
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

	public void setResorce(ResourceMasterModel resorce) {
		this.resource = resorce;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return resource;
	}
	
	
}
