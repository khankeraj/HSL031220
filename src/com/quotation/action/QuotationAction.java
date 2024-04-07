package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.model.QuotationModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.QuotationDAO;

import javafx.geometry.Side;

public class QuotationAction extends ActionSupport implements ModelDriven{
	
	private QuotationModel quotationmodel=new QuotationModel();
	private List<QuotationModel> quotation;
	private List<QuotationModel> quotationCoverPage;

	public List<QuotationModel> getQuotationCoverPage() {
		return quotationCoverPage;
	}

	public void setQuotationCoverPage(List<QuotationModel> quotationCoverPage) {
		this.quotationCoverPage = quotationCoverPage;
	}

	public QuotationModel getQuotationmodel() {
		return quotationmodel;
	}

	public void setQuotationmodel(QuotationModel quotationmodel) {
		this.quotationmodel = quotationmodel;
	}


	public List<QuotationModel> getQuotation() {
		return quotation;
	}

	public void setQuotation(List<QuotationModel> quotation) {
		this.quotation = quotation;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchQuotationPages()
	{
		String response;
		quotation=new QuotationDAO().fetchQuotationPages(quotationmodel);
		System.out.println("quotation index pages:"+quotation.size());
		if(quotation.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	/*public String fetchCoverPageDetails()
	{
		String response;
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String cover_page_id=request.getParameter("cover_page_id");
		
		quotationCoverPage=new QuotationDAO().fetchCoverPageDetails(quotationmodel,cover_page_id);
		
		if(quotationCoverPage.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	*/

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return quotationmodel;
	}
	
}
