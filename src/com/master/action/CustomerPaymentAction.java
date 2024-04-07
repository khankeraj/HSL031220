package com.master.action;

import javax.xml.ws.RespectBinding;

import com.master.dao.CustomerPaymentDAO;
import com.master.model.CustomerPaymentModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerPaymentAction extends ActionSupport implements ModelDriven {

	private CustomerPaymentModel  paymentModel=new CustomerPaymentModel();
	

	public CustomerPaymentModel getPaymentModel() {
		return paymentModel;
	}

	public void setPaymentModel(CustomerPaymentModel paymentModel) {
		this.paymentModel = paymentModel;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_customer_payment_details() {
		String response;
		int i=new CustomerPaymentDAO().insert_payment_details(paymentModel);
		if(i>0)
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
		return paymentModel;
	}

}
