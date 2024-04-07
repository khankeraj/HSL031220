package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.TermsConditionsReportsDAO;
import com.quotation.model.TermsConditionsReportsModel;

public class TermsConditionsReportsAction extends ActionSupport implements ModelDriven{
	
	private TermsConditionsReportsModel termsConditions=new TermsConditionsReportsModel();
	private List<TermsConditionsReportsModel> termsConditionsReports;
	

	
	public TermsConditionsReportsModel getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(TermsConditionsReportsModel termsConditions) {
		this.termsConditions = termsConditions;
	}

	public List<TermsConditionsReportsModel> getTermsConditionsReports() {
		return termsConditionsReports;
	}

	public void setTermsConditionsReports(List<TermsConditionsReportsModel> termsConditionsReports) {
		this.termsConditionsReports = termsConditionsReports;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchTermsConditionsDetails()
	{
		String response;
		termsConditionsReports=new TermsConditionsReportsDAO().fetchTermsConditionsDetails(termsConditions);
		if(termsConditionsReports.size()>0)
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
		return termsConditions;
	}

}
