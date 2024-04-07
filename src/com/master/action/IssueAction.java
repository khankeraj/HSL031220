package com.master.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.master.dao.IssueDAO;
import com.master.dao.MAterialReceivedDAO;
import com.master.model.IssueModel;
import com.master.model.MaterialReceivedModel;
import com.master.model.invoicebean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class IssueAction extends ActionSupport implements ServletRequestAware, SessionAware, ModelDriven<IssueModel>{

	
	private List<IssueModel> issueReport= new ArrayList<IssueModel>();
	private List<IssueModel> issuemodel = new ArrayList<IssueModel>();
	
	private IssueModel im;
	private IssueModel issue  = new IssueModel();
	
	public IssueModel getIssue() {
		return issue;
	}

	public void setIssue(IssueModel issue) {
		this.issue = issue;
	}

	public IssueModel getIm() {
		return im;
	}

	public void setIm(IssueModel im) {
		this.im = im;
	}



	List<IssueModel> issue_model_123=new ArrayList<IssueModel>();
	IssueModel issue_model = new IssueModel();
	
	
	public List<IssueModel> getIssue_model_123() {
		return issue_model_123;
	}

	public void setIssue_model_123(List<IssueModel> issue_model_123) {
		this.issue_model_123 = issue_model_123;
	}

	public IssueModel getIssue_model() {
		return issue_model;
	}

	public void setIssue_model(IssueModel issue_model) {
		this.issue_model = issue_model;
	}

	public List<IssueModel> getIssueReport() {
		return issueReport;
	}

	public void setIssueReport(List<IssueModel> issueReport) {
		this.issueReport = issueReport;
	}

	public List<IssueModel> getIssuemodel() {
		return issuemodel;
	}

	public void setIssuemodel(List<IssueModel> issuemodel) {
		this.issuemodel = issuemodel;
	}



	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String issue_report()
	{
		String response="";
		issueReport = new IssueDAO().issuereport(issuemodel);
		
		if(issueReport.size()>0)
		{
			response = "success";
		}
		else
		{
			response = "fail";
		}
		
		return response;
	}
	
	
	public String insert_issue_details()
	{
		String response="success";
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		//String pono = request.getParameter("purchase_po_no");
		
		
		//material_Received_model123=new MAterialReceivedDAO().insert_material_details(pono,materialReceived);
		//System.out.println(material_Received_model123.get(0).getMaterial_code1());
//		if(i>0)
//		{
//			response="success";
//		}
//		else
//		{
//			response="fail";
//		}
//		return response;
		//po=pono;
		response = new IssueDAO().insert_issue_details(issue_model);
		
		
		return response;
	}
	
	
	
	public String issueinsert() throws SQLException {
		String status = new IssueDAO().insertIssueDetails(im);
		
		if (status.equals("success")) {
			return "success";
		} 
		 else {
			return "error";
			
		}
		//return status;
	}
	
	@Override
	public IssueModel getModel() {
		// TODO Auto-generated method stub
		return issue;
	}
	
}