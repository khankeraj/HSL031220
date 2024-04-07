package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.AutocasePackerDAO;
import com.quotation.model.AutocasePackerModel;

public class AutocasePackerAction extends ActionSupport implements ModelDriven{

	private AutocasePackerModel autoCasePacker=new AutocasePackerModel();
	private List<AutocasePackerModel> ap;
	private List<AutocasePackerModel> autocasepacker1;
	
	private List<AutocasePackerModel> ap2;
	private List<AutocasePackerModel> autocasepacker3;
	
	public List<AutocasePackerModel> getAp2() {
		return ap2;
	}
	public void setAp2(List<AutocasePackerModel> ap2) {
		this.ap2 = ap2;
	}
	public List<AutocasePackerModel> getAutocasepacker3() {
		return autocasepacker3;
	}
	public void setAutocasepacker3(List<AutocasePackerModel> autocasepacker3) {
		this.autocasepacker3 = autocasepacker3;
	}
	public List<AutocasePackerModel> getAutocasepacker1() {
		return autocasepacker1;
	}
	public void setAutocasepacker1(List<AutocasePackerModel> autocasepacker1) {
		this.autocasepacker1 = autocasepacker1;
	}
	public String execute()
	{
		return "success";
	}
	public String insert_autoCasePacker_master()
	{
		String response;
		int i=new AutocasePackerDAO().insert_autoCasePacker_master(autoCasePacker);
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
	
	
	public String fetchAutocasePacker()
	{
			String response;
			autocasepacker1=new AutocasePackerDAO().fetchAutocasePacker1(autoCasePacker);
			ap=new AutocasePackerDAO().fetchAutocasePacker(autoCasePacker);
			if(ap.size()>0)
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
			String autocasepackerId=request.getParameter("autocasepacker_id");
			
			ap2=new AutocasePackerDAO().fetchAutocasePacker2(autoCasePacker,autocasepackerId);
			autocasepacker3=new AutocasePackerDAO().fetchAutocasePacker3(autoCasePacker,autocasepackerId);
			
			if(ap2.size()>0)
			{
				response="success";
			}
			else
			{
				response="fail";
			}
			
			return response;
	}
	
	public String updateAutoCasePackerDetails()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String autocasepackerId=request.getParameter("auto_case_id");
		
		int i=new AutocasePackerDAO().updateAutoCasePackerDetails(autoCasePacker,autocasepackerId);
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
	
	public String deleteAutoCasePacker()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String autocasepackerId=request.getParameter("autocasepacker_id");
		int i=new AutocasePackerDAO().deleteAutoCasePacker(autoCasePacker,autocasepackerId);
		
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
		return autoCasePacker;
	}

	public AutocasePackerModel getAutoCasePacker() {
		return autoCasePacker;
	}

	public void setAutoCasePacker(AutocasePackerModel autoCasePacker) {
		this.autoCasePacker = autoCasePacker;
	}
	public List<AutocasePackerModel> getAp() {
		return ap;
	}
	public void setAp(List<AutocasePackerModel> ap) {
		this.ap = ap;
	}

}
