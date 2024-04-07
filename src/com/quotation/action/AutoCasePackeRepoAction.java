package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.AutoCasePackerRepoDAO;
import com.quotation.model.AutoCasePackerRepoModel;

public class AutoCasePackeRepoAction extends ActionSupport implements ModelDriven{

	private AutoCasePackerRepoModel autocasepacker=new AutoCasePackerRepoModel();
	private List<AutoCasePackerRepoModel> autocasepacker1;
	
	public AutoCasePackerRepoModel getAutocasepacker() {
		return autocasepacker;
	}


	public void setAutocasepacker(AutoCasePackerRepoModel autocasepacker) {
		this.autocasepacker = autocasepacker;
	}


	public List<AutoCasePackerRepoModel> getAutocasepacker1() {
		return autocasepacker1;
	}


	public void setAutocasepacker1(List<AutoCasePackerRepoModel> autocasepacker1) {
		this.autocasepacker1 = autocasepacker1;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchAutocasePackerreports()
	{
		String response;
		autocasepacker1=new AutoCasePackerRepoDAO().fetchAutocasePackerreports();
		if(autocasepacker1.size()>0)
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
		return autocasepacker;
	}

}
