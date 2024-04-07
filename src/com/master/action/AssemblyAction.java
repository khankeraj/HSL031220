package com.master.action;

import java.util.ArrayList;
import java.util.List;

import com.master.dao.AssemblyDAO;
import com.master.model.AssemblyModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AssemblyAction extends ActionSupport implements ModelDriven{

	private AssemblyModel assembly=new AssemblyModel();
	private List<AssemblyModel> outstandingReport = new ArrayList<>();
	private List<AssemblyModel> outstandingmodel = new ArrayList<>();
	
	private List<AssemblyModel> issue_sparebulkReport = new ArrayList<>();
	private List<AssemblyModel> issue_sparebulkmodel = new ArrayList<>();
	
	
	public List<AssemblyModel> getIssue_sparebulkReport() {
		return issue_sparebulkReport;
	}



	public void setIssue_sparebulkReport(List<AssemblyModel> issue_sparebulkReport) {
		this.issue_sparebulkReport = issue_sparebulkReport;
	}



	public List<AssemblyModel> getIssue_sparebulkmodel() {
		return issue_sparebulkmodel;
	}



	public void setIssue_sparebulkmodel(List<AssemblyModel> issue_sparebulkmodel) {
		this.issue_sparebulkmodel = issue_sparebulkmodel;
	}



	public List<AssemblyModel> getOutstandingReport() {
		return outstandingReport;
	}



	public void setOutstandingReport(List<AssemblyModel> outstandingReport) {
		this.outstandingReport = outstandingReport;
	}



	public AssemblyModel getAssembly() {
		return assembly;
	}



	public void setAssembly(AssemblyModel assembly) {
		this.assembly = assembly;
	}

	public String execute()
	{
		return "success";
	}

	public String insert_assembly_details()
	{
		String response;
		int i=new AssemblyDAO().insert_assembly_details(assembly);
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
	
	
	public String outstanding_report()
	{
		String response = "";
		outstandingReport = new AssemblyDAO().outstandingReport(outstandingmodel);
		
		if(outstandingReport.size()>0)
		{
			response = "success";
		}
		else
		{
			response = "fail";
		}
		return response;
		
	}
	
	public String issue_spare_bulk_report()
	{
		String response = "";
		issue_sparebulkReport = new AssemblyDAO().issueSpareBulkReport(issue_sparebulkmodel);
		
		
		if(issue_sparebulkReport.size()>0)
		{
			response = "success";
		}
		else
		{
			response = "fail";
		}
		
		return response;
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return assembly;
	}

}
