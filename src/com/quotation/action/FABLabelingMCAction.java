package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FABLAbelingMCDAO;
import com.quotation.model.FABLabelingMCModel;

public class FABLabelingMCAction extends ActionSupport implements ModelDriven{

	private FABLabelingMCModel fablabelingmc=new FABLabelingMCModel();
	
	private List<FABLabelingMCModel> fablabel;
	
	
	public List<FABLabelingMCModel> getFablabel() {
		return fablabel;
	}

	public void setFablabel(List<FABLabelingMCModel> fablabel) {
		this.fablabel = fablabel;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchFABLabelingmcDetails()
	{
		String response;
		fablabel=new FABLAbelingMCDAO().fetchFABLabelingmcDetails(fablabelingmc);
		System.out.println("fabLabeling:"+fablabel.size());
		if(fablabel.size()>0)
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
		return fablabelingmc;
	}

	public FABLabelingMCModel getFablabelingmc() {
		return fablabelingmc;
	}

	public void setFablabelingmc(FABLabelingMCModel fablabelingmc) {
		this.fablabelingmc = fablabelingmc;
	}

}
