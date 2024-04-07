package com.quotationPages.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotationPages.dao.QuotationPagesDAO;
import com.quotationPages.modal.QuotationPagesModal;

public class QuotationPagesAction extends ActionSupport implements ModelDriven{

	private QuotationPagesModal quotationPages=new QuotationPagesModal();
	private List<QuotationPagesModal> listOfPages;
	
	public QuotationPagesModal getQuotationPages() {
		return quotationPages;
	}

	public void setQuotationPages(QuotationPagesModal quotationPages) {
		this.quotationPages = quotationPages;
	}
	
	public List<QuotationPagesModal> getListOfPages() {
		return listOfPages;
	}

	public void setListOfPages(List<QuotationPagesModal> listOfPages) {
		this.listOfPages = listOfPages;
	}
	

	public String fetchQuotationPages()
	{
		String response;
		listOfPages=new QuotationPagesDAO().fetchQuotationPages(quotationPages);
		System.out.println("list:"+listOfPages.size());
		if(listOfPages!=null)
		{
			System.out.println("in success action");
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String execute()
	{
		return "success";
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return quotationPages;
	}

}
