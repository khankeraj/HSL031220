package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.TokenAmountDAO;
import com.quotation.model.TokenAmountModel;

public class TokenAmountAction extends ActionSupport implements ModelDriven{
	
	private TokenAmountModel tokenAmt=new TokenAmountModel();
	private List<TokenAmountModel> tokenReports;
	private List<TokenAmountModel> getFinalizationAmttokenamt;
	
	public List<TokenAmountModel> getGetFinalizationAmttokenamt() {
		return getFinalizationAmttokenamt;
	}

	public void setGetFinalizationAmttokenamt(List<TokenAmountModel> getFinalizationAmttokenamt) {
		this.getFinalizationAmttokenamt = getFinalizationAmttokenamt;
	}

	public List<TokenAmountModel> getTokenReports() {
		return tokenReports;
	}

	public void setTokenReports(List<TokenAmountModel> tokenReports) {
		this.tokenReports = tokenReports;
	}

	public TokenAmountModel getTokenAmt() {
		return tokenAmt;
	}

	public void setTokenAmt(TokenAmountModel tokenAmt) {
		this.tokenAmt = tokenAmt;
	}
	
	public String getFinalizationAmttokenamt()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		int site_visitor_id=Integer.parseInt(request.getParameter("site_visitor_id"));
		getFinalizationAmttokenamt=new TokenAmountDAO().getFinalizationAmttokenamt(site_visitor_id);
		if(getFinalizationAmttokenamt.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String insert_token_Form()
	{
		String response = null;
		HttpServletRequest request=ServletActionContext.getRequest();
		int site_visitor_id=Integer.parseInt(request.getParameter("site_visitor_id"));
		String paymode=request.getParameter("paymode");
		String lead_no=request.getParameter("lead_no");
		
		System.out.println("paymode:"+paymode);
		int i=0;
		
		if(paymode.equals("Cash"))
		{
			i=new TokenAmountDAO().insert_cash_amount(tokenAmt,site_visitor_id,lead_no);
			
			if(i>0)
			{
				System.out.println("success1");
				response="success";
			}else
			{
				response="fail";
			}
		}
		
		else if(paymode.equals("Card"))
		{
			i=new TokenAmountDAO().insert_card_amount(tokenAmt,site_visitor_id,lead_no);
			if(i>0)
			{
				System.out.println("success2");
				response="success";
			}else
			{
				response="fail";
			}
			
		}
			else if(paymode.equals("Cheque"))
		{
			i=new TokenAmountDAO().insert_cheque_amount(tokenAmt,site_visitor_id,lead_no);
			if(i>0)
			{
				System.out.println("success3");
				response="success";
			}else
			{
				response="fail";
			}
		}
			else if(paymode.equals("Cash&Card"))
		{
			i=new TokenAmountDAO().insert_cash_card_amount(tokenAmt,site_visitor_id,lead_no);
			if(i>0)
			{
				System.out.println("success4");
				response="success";
			}else
			{
				response="fail";
			}
		}
		return response;
	}
	
	public String fetchTokenReports()
	{
		String response;
		tokenReports=new TokenAmountDAO().fetchTokenReports(tokenAmt);
		System.out.println("tokenReports:"+tokenReports.size());
		
		if(tokenReports!=null)
		{
			response="success";
		}else
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
		return tokenAmt;
	}

}
