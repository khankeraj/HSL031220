package com.master.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.master.dao.PaymentDAO;
import com.master.model.PaymentModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PurchasePaymentAction extends ActionSupport implements ModelDriven,ServletRequestAware {

	private PaymentModel payment=new PaymentModel();
	HttpServletRequest request;
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
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String openbill()throws IOException,SQLException
	{
		
	
		
		response = new PaymentDAO().getnvnumbereway(payment);
		response = "";
		//request.setAttribute("response", response);
		System.out.println("111>>>"+response);
		
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
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return payment;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=request;
	}

}
