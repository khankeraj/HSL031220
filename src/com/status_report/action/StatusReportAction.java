package com.status_report.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.master.model.LeadFormModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.status_report.dao.StatusReportDAO;
import com.status_report.model.StatusReportModel;

public class StatusReportAction extends ActionSupport implements ModelDriven<Object> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StatusReportModel statusModel=new StatusReportModel();
	private List<LeadFormModel> LeadForm;
	
	private LeadFormModel lead=new LeadFormModel();
	
	
	public LeadFormModel getLead() {
		return lead;
	}
	public void setLead(LeadFormModel lead) {
		this.lead = lead;
	}
	
	public List<LeadFormModel> getLeadForm() {
		return LeadForm;
	}
	public void setLeadForm(List<LeadFormModel> leadForm) {
		LeadForm = leadForm;
	}
	public StatusReportModel getStatusModel() {
		return statusModel;
	}
	public void setStatusModel(StatusReportModel statusModel) {
		this.statusModel = statusModel;
	}
	public String execute()
	{
		return "success";
	}
	
	public String fetchStatusReport()
	{
		String response="";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		LeadForm=new StatusReportDAO().fetchLeadDetails(lead);
		
		//String check_status=(String)request.getAttribute("check_status");
		
		if(LeadForm!=null)
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
		return LeadForm;
	}
	

}
