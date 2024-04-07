package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.TermsAndConditionsDAO;
import com.quotation.model.TermsAndConditionsModel;

public class TermsAndConditionsAction extends ActionSupport implements ModelDriven{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2130654250550250258L;
	private TermsAndConditionsModel termsConditions=new TermsAndConditionsModel();
	
	private List<TermsAndConditionsModel> terms_conditions;
	private List<TermsAndConditionsModel> terms_conditions1;
	private List<TermsAndConditionsModel> terms_conditions2;
	
	private List<TermsAndConditionsModel> terms_conditions3;
	private List<TermsAndConditionsModel> terms_conditions4;
	private List<TermsAndConditionsModel> terms_conditions5;
	
	
	public List<TermsAndConditionsModel> getTerms_conditions3() {
		return terms_conditions3;
	}

	public void setTerms_conditions3(List<TermsAndConditionsModel> terms_conditions3) {
		this.terms_conditions3 = terms_conditions3;
	}

	public List<TermsAndConditionsModel> getTerms_conditions4() {
		return terms_conditions4;
	}

	public void setTerms_conditions4(List<TermsAndConditionsModel> terms_conditions4) {
		this.terms_conditions4 = terms_conditions4;
	}

	public List<TermsAndConditionsModel> getTerms_conditions5() {
		return terms_conditions5;
	}

	public void setTerms_conditions5(List<TermsAndConditionsModel> terms_conditions5) {
		this.terms_conditions5 = terms_conditions5;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<TermsAndConditionsModel> getTerms_conditions() {
		return terms_conditions;
	}

	public void setTerms_conditions(List<TermsAndConditionsModel> terms_conditions) {
		this.terms_conditions = terms_conditions;
	}

	public List<TermsAndConditionsModel> getTerms_conditions1() {
		return terms_conditions1;
	}

	public void setTerms_conditions1(List<TermsAndConditionsModel> terms_conditions1) {
		this.terms_conditions1 = terms_conditions1;
	}

	public List<TermsAndConditionsModel> getTerms_conditions2() {
		return terms_conditions2;
	}

	public void setTerms_conditions2(List<TermsAndConditionsModel> terms_conditions2) {
		this.terms_conditions2 = terms_conditions2;
	}

	public TermsAndConditionsModel getTermsConditions() {
		return termsConditions;
	}

	public void setTermsConditions(TermsAndConditionsModel termsConditions) {
		this.termsConditions = termsConditions;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_terms_conditions()
	{
		String response;
		int i=new TermsAndConditionsDAO().insert_terms_conditions(termsConditions);
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
	
	public String fetch_terms_conditions_details()
	{
		String response;
		terms_conditions2=new TermsAndConditionsDAO().fetch_terms_conditions_details2(termsConditions);
		terms_conditions1=new TermsAndConditionsDAO().fetch_terms_conditions_details1(termsConditions);
		terms_conditions=new TermsAndConditionsDAO().fetch_terms_conditions_details(termsConditions);
		
		if(terms_conditions.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdate()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String termsConditionsId=request.getParameter("termsConditionsId");
		
		terms_conditions3=new TermsAndConditionsDAO().fetch_terms_conditions_details3(termsConditions,termsConditionsId);
		terms_conditions4=new TermsAndConditionsDAO().fetch_terms_conditions_details4(termsConditions,termsConditionsId);
		terms_conditions5=new TermsAndConditionsDAO().fetch_terms_conditions_details5(termsConditions,termsConditionsId);
		
		if(terms_conditions3.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateTermsConditions()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String termsConditionsId=request.getParameter("terms_condition_id");
		int i=new TermsAndConditionsDAO().updateTermsConditions(termsConditions,termsConditionsId);
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
	
	public String deleteTermsConditions()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String termsConditionsId=request.getParameter("termsConditionsId");
		int i=new TermsAndConditionsDAO().deleteTermsConditions(termsConditions,termsConditionsId);
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
		return termsConditions;
	}


}
