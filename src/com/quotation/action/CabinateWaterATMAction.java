package com.quotation.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.CabinateWaterATMDAO;
import com.quotation.model.CabinateWaterATMModel;

public class CabinateWaterATMAction extends ActionSupport implements ModelDriven {
	
	private CabinateWaterATMModel cabinateWaterAtm=new CabinateWaterATMModel();

	public CabinateWaterATMModel getCabinateWaterAtm() {
		return cabinateWaterAtm;
	}

	public void setCabinateWaterAtm(CabinateWaterATMModel cabinateWaterAtm) {
		this.cabinateWaterAtm = cabinateWaterAtm;
	}
	
	public String execute()
	{
		return "success";
	}
	
	public String insert_cabinate_water_atm()
	{
		String response;
		int i=new CabinateWaterATMDAO().insert_cabinate_water_atm(cabinateWaterAtm);
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
		return cabinateWaterAtm;
	}
	
	

}
