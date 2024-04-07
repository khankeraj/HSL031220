package com.quotation.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.AboutWaterATMDAO;
import com.quotation.model.AboutWaterATMModel;

public class AboutWaterATMAction extends ActionSupport implements ModelDriven {

	private AboutWaterATMModel aboutWaterATM=new AboutWaterATMModel();
	
	
	public AboutWaterATMModel getAboutWaterATM() {
		return aboutWaterATM;
	}


	public void setAboutWaterATM(AboutWaterATMModel aboutWaterATM) {
		this.aboutWaterATM = aboutWaterATM;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_aboutWaterATM()
	{
		String response;
		
		int i=new AboutWaterATMDAO().insert_aboutWaterATM(aboutWaterATM);
		
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
		return aboutWaterATM;
	}

}
