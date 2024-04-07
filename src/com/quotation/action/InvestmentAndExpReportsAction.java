package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.InvestmentAndExpReportsReportsDAO;
import com.quotation.model.InvestmentAndExpReportsReportsModel;

public class InvestmentAndExpReportsAction extends ActionSupport implements ModelDriven{

	private InvestmentAndExpReportsReportsModel investexp=new InvestmentAndExpReportsReportsModel();
	private List<InvestmentAndExpReportsReportsModel> investExpReports;
	
	public InvestmentAndExpReportsReportsModel getInvestexp() {
		return investexp;
	}

	public void setInvestexp(InvestmentAndExpReportsReportsModel investexp) {
		this.investexp = investexp;
	}

	public List<InvestmentAndExpReportsReportsModel> getInvestExpReports() {
		return investExpReports;
	}

	public void setInvestExpReports(List<InvestmentAndExpReportsReportsModel> investExpReports) {
		this.investExpReports = investExpReports;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchInvestExpReports()
	{
		String response;
		investExpReports=new InvestmentAndExpReportsReportsDAO().fetchInvestExpReports(investexp);
		if(investExpReports.size()>0)
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
		return investexp;
	}

}
