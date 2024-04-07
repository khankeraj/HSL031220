package com.master.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.MAterialReceivedDAO;
import com.master.model.MaterialReceivedModel;
import com.master.model.invoicebean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InvoiceTax extends ActionSupport implements ModelDriven{
	
	List<MaterialReceivedModel> taxinvoicereport = new ArrayList<>();
	MaterialReceivedModel mmodel = new MaterialReceivedModel();
	
	List<invoicebean> invoicebean123 = new ArrayList<>();
	
	public MaterialReceivedModel getMmodel() {
		return mmodel;
	}

	public void setMmodel(MaterialReceivedModel mmodel) {
		this.mmodel = mmodel;
	}

	public List<MaterialReceivedModel> getTaxinvoicereport() {
		return taxinvoicereport;
	}

	public void setTaxinvoicereport(List<MaterialReceivedModel> taxinvoicereport) {
		this.taxinvoicereport = taxinvoicereport;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String openbill()
	{
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String pono = request.getParameter("pono");
		
		invoicebean123 = new MAterialReceivedDAO().invoiceFormDetails(pono);
		
		System.out.println(invoicebean123);
		
		if(invoicebean123.size()>0)
		{
		return "success";
		}
		else {
			return "fail";
		}
	}
	
	
	
	
	public List<invoicebean> getInvoicebean123() {
		return invoicebean123;
	}

	public void setInvoicebean123(List<invoicebean> invoicebean123) {
		this.invoicebean123 = invoicebean123;
	}

	public String tax_invoice_report()
	{
		String response="";
		taxinvoicereport = new MAterialReceivedDAO().taxInvoiceReport();
		
		if(taxinvoicereport.size()>0)
		{
			response = "success";
		}
		else
		{
			response = "fail";
		}
		
		return response;
	}
	
}