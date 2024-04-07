package com.master.action;

import com.master.model.QuotationModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.QuotationDAO;

public class QuotationMaster extends ActionSupport implements ModelDriven {

	private QuotationModel quotation=new QuotationModel();

	public QuotationModel getQuotation() {
		return quotation;
	}

	public void setQuotation(QuotationModel quotation) {
		this.quotation = quotation;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_quotation_details()
	{
		String response;
		int i=new QuotationDAO().insert_quotation_details(quotation);
		if(i>0)
		{
			response="success";
		}
		else {
			response="fail";
		}
		return response;
	}
	

	@Override
	public Object getModel() {
		return quotation;
	}

}
