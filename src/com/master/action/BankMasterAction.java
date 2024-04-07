package com.master.action;

import java.util.List;

import com.master.dao.BankMasterDAO;
import com.master.model.BankMasterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BankMasterAction extends ActionSupport implements ModelDriven {
	
	private BankMasterModel bankmastermodel=new BankMasterModel();
	private List<BankMasterModel> fetchBankMaster;

	public List<BankMasterModel> getFetchBankMaster() {
		return fetchBankMaster;
	}

	public void setFetchBankMaster(List<BankMasterModel> fetchBankMaster) {
		this.fetchBankMaster = fetchBankMaster;
	}

	public BankMasterModel getBankmastermodel() {
		return bankmastermodel;
	}

	public void setBankmastermodel(BankMasterModel bankmastermodel) {
		this.bankmastermodel = bankmastermodel;
	}

	
	public String execute()
	{
		return "success";
	}
	
	public String insert_bank_master_details()
	{
		String response;
		int i=new BankMasterDAO().insert_bank_details(bankmastermodel);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchBankMaster()
	{
		String response;
		fetchBankMaster=new BankMasterDAO().fetchBankMaster(bankmastermodel);
		if(fetchBankMaster!=null)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return bankmastermodel;
	}

}
