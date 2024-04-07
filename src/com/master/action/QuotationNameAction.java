package com.master.action;

import java.util.List;

import com.master.dao.QuotationNameDAO;
import com.master.model.QuotationNameModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class QuotationNameAction extends ActionSupport implements ModelDriven{

	private QuotationNameModel quotationNameModel=new QuotationNameModel();
	private List<QuotationNameModel> quotationNameModel1;
	
	public List<QuotationNameModel> getQuotationNameModel1() {
		return quotationNameModel1;
	}

	public void setQuotationNameModel1(List<QuotationNameModel> quotationNameModel1) {
		this.quotationNameModel1 = quotationNameModel1;
	}

	public QuotationNameModel getQuotationNameModel() {
		return quotationNameModel;
	}

	public void setQuotationNameModel(QuotationNameModel quotationNameModel) {
		this.quotationNameModel = quotationNameModel;
	}
	
	public String saveQuotationName()
	{
		QuotationNameModel quotationname=new QuotationNameModel();
		String response;
		int i=new QuotationNameDAO().saveQuotationName(quotationNameModel);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchQuotationNameReports()
	{
		String response;
		quotationNameModel1=new QuotationNameDAO().fetchQuotationNameReports(quotationNameModel);
		System.out.println("size:"+quotationNameModel1.size());
		if(quotationNameModel1.size()>0)
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
		return quotationNameModel;
	}
	
	

}
