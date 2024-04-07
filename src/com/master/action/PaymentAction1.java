package com.master.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.Constants.Constants;
import com.master.dao.Payment1_Dao;
import com.master.dao.dealer_payment_dao;
import com.master.model.LoginBean;
import com.master.model.Payment1Model;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaymentAction1 extends ActionSupport implements ModelDriven{

	
	Payment1Model pay1model = new Payment1Model();
	private Payment1Model dpb;
	private String recpco="";
	
	
	List<Payment1Model> paymentDetails = new ArrayList<Payment1Model>();
	
	
	public List<Payment1Model> getPaymentDetails() {
		return paymentDetails;
	}




	public void setPaymentDetails(List<Payment1Model> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}




	public String getRecpco() {
		return recpco;
	}




	public void setRecpco(String recpco) {
		this.recpco = recpco;
	}




	public Payment1Model getDpb() {
		return dpb;
	}




	public void setDpb(Payment1Model dpb) {
		this.dpb = dpb;
	}




	public Payment1Model getPay1model() {
		return pay1model;
	}




	public void setPay1model(Payment1Model pay1model) {
		this.pay1model = pay1model;
	}




	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return pay1model;
	}

	
	

	public String openbill()
	{
		return "success";
	}
	
	public String openbill1()
	{
		return "success";
	}


	
	public String commissionsearch1() throws SQLException {

		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String transporter_code = request.getParameter("transporter_code");
		
		System.out.println("Transporter code:"+transporter_code);
		try {
			pay1model = new Payment1_Dao().FetchspareMaterial12(transporter_code);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	
	public String inserttransporterpaymentv()
	{
		
		/*LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);*/
		
			
		String status=new Payment1_Dao().inserttransporterpaymentv(dpb);		
		
		recpco=dpb.getVoucher_no();
		
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

		
	}
	
	
	public String insertcustomerpaymentv()
	{
		
		
			
		
		String status=new Payment1_Dao().insertcustomerpaymentv(dpb);
			
		
		recpco=dpb.getVoucher_no();
		
		System.out.println(recpco);
		
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}
	}
	
	
	public String transporter_outstanding_report()
	{
		paymentDetails = new Payment1_Dao().getTransporterOutstandingDetails();
		
		if(paymentDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	
	public String customer_outstanding_report()
	{
		paymentDetails = new Payment1_Dao().getCustomerOutstandingDetails();
		
		if(paymentDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	
	
	public String transporter_payment_report()
	{
		/*paymentDetails = new Payment1_Dao().getTransporterPayDetails();
		
		if(paymentDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}*/
		return "success";
	}
	
	public String customer_payment_report()
	{
		return "success";
	}
	
	public String transporter_payment_report1() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String transporter_name = request.getParameter("transporter_name");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		
		paymentDetails = new Payment1_Dao().getTransporterPayDetails(transporter_name, from_date, to_date);
		
		if(paymentDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	
	
	public String customer_payment_report1()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String customer_name = request.getParameter("customer_name");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		
		paymentDetails = new Payment1_Dao().getCustomerPayDetails(customer_name, from_date, to_date);
		
		if(paymentDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	
}
