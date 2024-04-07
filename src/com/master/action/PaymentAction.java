package com.master.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.master.dao.PaymentDAO;
import com.master.dao.job_card_dao;
import com.master.model.PaymentModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction extends ActionSupport implements ModelDriven {

	private PaymentModel payment=new PaymentModel();
	private List<PaymentModel> piPaymentReport;
	
	public List<PaymentModel> getPiPaymentReport() {
		return piPaymentReport;
	}
	public void setPiPaymentReport(List<PaymentModel> piPaymentReport) {
		this.piPaymentReport = piPaymentReport;
	}
	public PaymentModel getPayment() {
		return payment;
	}
	public void setPayment(PaymentModel payment) {
		this.payment = payment;
	}
	public String execute()
	{
		return "success";
	}
	
	private String response;
	private String invoice_no;
	
	public String getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String openbill()throws IOException,SQLException
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		response = new PaymentDAO().getnvnumbereway(payment);
		//response = "";
		System.out.println("111>>>"+response);
		request.setAttribute("pono", response);
		
		invoice_no = new job_card_dao().getnvnumber();
		request.setAttribute("invoice_no", invoice_no);
		System.out.println(">>>"+invoice_no);
		
		return "success";	
	}
	
	public String insert_payment_details()
	{
		String response="";
		int i=new PaymentDAO().insert_payment_details(payment);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchPIPaymentReports()
	{
		String response;
		piPaymentReport=new PaymentDAO().fetchPIPaymentReports(payment);
		if(piPaymentReport!=null)
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
		return payment;
	}
}
