package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.QuotationViewDAO;
import com.quotation.model.QuotationViewModel;

public class QuotationViewAction extends ActionSupport implements ModelDriven{
	
	private QuotationViewModel quotationViewModal=new QuotationViewModel();
	private List<QuotationViewModel> quotationList;
	
	
	public List<QuotationViewModel> getQuotationList() {
		return quotationList;
	}

	public void setQuotationList(List<QuotationViewModel> quotationList) {
		this.quotationList = quotationList;
	}

	public QuotationViewModel getQuotationViewModal() {
		return quotationViewModal;
	}

	public void setQuotationViewModal(QuotationViewModel quotationViewModal) {
		this.quotationViewModal = quotationViewModal;
	}
	
	public String execute()
	{
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return quotationViewModal;
	}

}
