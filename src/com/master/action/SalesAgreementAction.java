package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.SalesAgreementDAO;
import com.master.model.SalesAgreementModal;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalesAgreementAction extends ActionSupport implements ModelDriven{

	private SalesAgreementModal salesAgreement=new SalesAgreementModal();
	
	private List<SalesAgreementModal> agreement_reports;
	private List<SalesAgreementModal> agreement_report;
	
	private List<SalesAgreementModal> sales_agreement_report;
	
	public List<SalesAgreementModal> getSales_agreement_report() {
		return sales_agreement_report;
	}

	public void setSales_agreement_report(List<SalesAgreementModal> sales_agreement_report) {
		this.sales_agreement_report = sales_agreement_report;
	}

	public List<SalesAgreementModal> getAgreement_report() {
		return agreement_report;
	}

	public void setAgreement_report(List<SalesAgreementModal> agreement_report) {
		this.agreement_report = agreement_report;
	}

	public List<SalesAgreementModal> getAgreement_reports() {
		return agreement_reports;
	}

	public void setAgreement_reports(List<SalesAgreementModal> agreement_reports) {
		this.agreement_reports = agreement_reports;
	}

	public SalesAgreementModal getSalesAgreement() {
		return salesAgreement;
	}

	public void setSalesAgreement(SalesAgreementModal salesAgreement) {
		this.salesAgreement = salesAgreement;
	}

	public String execute()
	{
		return "success";
	}
	
	
	public String insert_sales_agreement()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String lead_no=request.getParameter("lead_no");
		String token_id=request.getParameter("token_id");
		
		int i=new SalesAgreementDAO().insert_sales_agreement(salesAgreement,lead_no,token_id);
		agreement_report=new SalesAgreementDAO().set_agreement_details(salesAgreement);
		
		if(agreement_report.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}

	
	public String fetch_agreements_details()
	{
		String response;
		agreement_reports=new SalesAgreementDAO().fetch_agreements_details(salesAgreement);
		if(agreement_reports!=null)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String set_agreement_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String sales_agg_id=request.getParameter("agreement_id");
		sales_agreement_report=new SalesAgreementDAO().set_agreementdet(salesAgreement,sales_agg_id);
		if(sales_agreement_report.size()>0)
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
		return salesAgreement;
	}
	
}
