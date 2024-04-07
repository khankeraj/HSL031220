package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.LeadFormDAO;
import com.master.model.LeadFormModel;
import com.master.model.MeetingFormModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LeadFormAction extends ActionSupport implements ModelDriven {
	
private LeadFormModel leadForm=new LeadFormModel();
private List<LeadFormModel> leadForm1;
private List<LeadFormModel> leadForm2;
private List<LeadFormModel> fetchForLead;
private String lead_serial_no;


public String getLead_serial_no() {
	return lead_serial_no;
}

public void setLead_serial_no(String lead_serial_no) {
	this.lead_serial_no = lead_serial_no;
}

public List<LeadFormModel> getFetchForLead() {
	return fetchForLead;
}

public void setFetchForLead(List<LeadFormModel> fetchForLead) {
	this.fetchForLead = fetchForLead;
}

	public List<LeadFormModel> getLeadForm2() {
	return leadForm2;
}

public void setLeadForm2(List<LeadFormModel> leadForm2) {
	this.leadForm2 = leadForm2;
}

	public List<LeadFormModel> getLeadForm1() {
	return leadForm1;
}

public void setLeadForm1(List<LeadFormModel> leadForm1) {
	this.leadForm1 = leadForm1;
}

	public LeadFormModel getLeadForm() {
		return leadForm;
	}

	public void setLeadForm(LeadFormModel leadForm) {
		this.leadForm = leadForm;
	}

	public String execute()
	{
		return "success";
	}
	
	
	public String insert_leadForm_details()
	{
		 String response="";
		 System.out.println("in action");
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		int status=new LeadFormDAO().insert_lead_details(leadForm);
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
		
	}
	
	public String fetchLeadFormDetails()
	{
		String response="";
		 System.out.println("in action");
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		leadForm1=new LeadFormDAO().fetchLeadFormDetails();
		if(leadForm1!=null)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
	}

	public String fetchLeadDeatilsForMeeting()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String lead_no=request.getParameter("lead_no");
		
		leadForm2=new LeadFormDAO().fetchForUpdateMeeting(leadForm,lead_no);
		
		if(leadForm2.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdateLeadForm()
	{
		String respose;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String lead_no=request.getParameter("lead_no");
		fetchForLead=new LeadFormDAO().fetchForLeadUpdate(lead_no);
		if(fetchForLead.size()>0)
		{
			respose="success";
		}
		else
		{
			respose="fail";
		}
		
		return respose;
	}
	
	public String update_leadForm_details()
	{
		 String response;
		 
		HttpServletRequest request=ServletActionContext.getRequest();
			
		String lead_no=request.getParameter("lead_no");
		
		System.out.println("update_lead_form:"+lead_no);
		 
		int status=new LeadFormDAO().update_lead_details(leadForm,lead_no);
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
	}
	
	public String delete_lead_form()
	{
		String response;
		 
		HttpServletRequest request=ServletActionContext.getRequest();
			
		String lead_no=request.getParameter("lead_no");
		
		System.out.println("delete:"+lead_no);
		
		int status=new LeadFormDAO().delete_lead_form(leadForm,lead_no);
		
		System.out.println("del:"+status);
		
		if(status>0)
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
		return leadForm;
	}

}