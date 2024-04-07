package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.VisitorFormDAO;
import com.master.model.VisitorFormModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitorFormAction extends ActionSupport implements ModelDriven {

	private VisitorFormModel visitorModel=new VisitorFormModel();
	
	private List<VisitorFormModel> visitorList;
	
	private List<VisitorFormModel> editSiteVisitForm;
	
	private List<VisitorFormModel> siteVistorPrints;
	
	public List<VisitorFormModel> getSiteVistorPrints() {
		return siteVistorPrints;
	}

	public void setSiteVistorPrints(List<VisitorFormModel> siteVistorPrints) {
		this.siteVistorPrints = siteVistorPrints;
	}

	public List<VisitorFormModel> getEditSiteVisitForm() {
		return editSiteVisitForm;
	}

	public void setEditSiteVisitForm(List<VisitorFormModel> editSiteVisitForm) {
		this.editSiteVisitForm = editSiteVisitForm;
	}

	public List<VisitorFormModel> getVisitorList() {
		return visitorList;
	}

	public void setVisitorList(List<VisitorFormModel> visitorList) {
		this.visitorList = visitorList;
	}

	public VisitorFormModel getVisitorModel() {
		return visitorModel;
	}

	public void setVisitorModel(VisitorFormModel visitorModel) {
		this.visitorModel = visitorModel;
	}
	
	public String execute()
	{
		return "success";
	}
	
	/*public String insert_visitor_details()
	{
		String response;
		int i=new VisitorFormDAO().insert_visitor_details(visitorModel);
		if(i>0)
		{
			System.out.println("success");
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}*/
	
	public String insert_site_visit()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		int finalization_id=Integer.parseInt(request.getParameter("finalization_id"));
		String lead_no=request.getParameter("lead_no");
		
		int i=new VisitorFormDAO().insert_site_visitor(visitorModel,finalization_id,lead_no);
		siteVistorPrints=new VisitorFormDAO().fetchForSiteVisit1(visitorModel);
		if(siteVistorPrints.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchReportsVisitor()
	{
		String response;
		visitorList=new VisitorFormDAO().fetchVisitorReports(visitorModel);
		if(visitorList!=null)
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
		HttpServletRequest request=ServletActionContext.getRequest();
		String edit_id=request.getParameter("site_visit_id");
		
		editSiteVisitForm=new VisitorFormDAO().fetchForSiteVisit(visitorModel,edit_id);
		if(editSiteVisitForm.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateSiteVisitForm()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String site_visit_id=request.getParameter("site_visit_id");
		int i=new VisitorFormDAO().updateSiteVisitForm(visitorModel,site_visit_id);
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
	
	public String deleteSiteVisit()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String site_visit_id=request.getParameter("siteVisit_id");
		
		int i=new VisitorFormDAO().deleteVisitorDetails(visitorModel,site_visit_id);
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
		return visitorModel;
	}

}
