package com.master.action;

import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.master.dao.ContractDAO;
import com.master.dao.CustomerMasterDAO;
import com.master.dao.LeadFormDAO;
import com.master.model.ContractModel;
import com.master.model.CustomerMasterModel;
import com.master.model.LeadFormModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.QuotationIndexDAO;
import com.quotation.dao.SubmitQuotationDAO;
import com.quotation.model.QuotationIndexModel;

public class ContractMaster extends ActionSupport implements ModelDriven  {
	
	private ContractModel customer=new ContractModel();
	private List<ContractModel> contractor;
	private List<ContractModel> contractDetails;
	private List<ContractModel> coverDetails;
	private List<LeadFormModel> fetchCustomerDetailstocontractor;
	
	private String ref_no;
	private String ref_no1;
	public String getRef_no() {
		return ref_no;
	}

	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}

	private QuotationIndexModel quotationIndex=new QuotationIndexModel();
	private LeadFormModel leadForm=new LeadFormModel();
	
	public List<LeadFormModel> getFetchCustomerDetailstocontractor() {
		return fetchCustomerDetailstocontractor;
	}

	public void setFetchCustomerDetailstocontractor(List<LeadFormModel> fetchCustomerDetailstocontractor) {
		this.fetchCustomerDetailstocontractor = fetchCustomerDetailstocontractor;
	}

	public LeadFormModel getLeadForm() {
		return leadForm;
	}

	public void setLeadForm(LeadFormModel leadForm) {
		this.leadForm = leadForm;
	}



	private List<QuotationIndexModel> q1;
	private List<QuotationIndexModel> q2;
	
	public QuotationIndexModel getQuotationIndex() {
		return quotationIndex;
	}

	public void setQuotationIndex(QuotationIndexModel quotationIndex) {
		this.quotationIndex = quotationIndex;
	}

	public List<QuotationIndexModel> getQ1() {
		return q1;
	}

	public void setQ1(List<QuotationIndexModel> q1) {
		this.q1 = q1;
	}

	public List<QuotationIndexModel> getQ2() {
		return q2;
	}

	public void setQ2(List<QuotationIndexModel> q2) {
		this.q2 = q2;
	}

	public List<ContractModel> getContractDetails() {
		return contractDetails;
	}

	public List<ContractModel> getCoverDetails() {
		return coverDetails;
	}

	public void setCoverDetails(List<ContractModel> coverDetails) {
		this.coverDetails = coverDetails;
	}

	public void setContractDetails(List<ContractModel> contractDetails) {
		this.contractDetails = contractDetails;
	}

	public List<ContractModel> getContractor() {
		return contractor;
	}

	public void setContractor(List<ContractModel> contractor) {
		this.contractor = contractor;
	}

	public ContractModel getCustomer() {
		return customer;
	}

	public void setCustomer(ContractModel customer) {
		this.customer = customer;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchReferance_no()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		String quotation_name=request.getParameter("quotation_name");
		ref_no1=new ContractDAO().fetchRefNo(quotation_name);
		System.out.println("ref:"+ref_no1);
		return "success";
	}
	
	public String fetchCustomerDetailsToContractor()
	{
		String response;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String lead_no=request.getParameter("lead_no");
		String ref_no=request.getParameter("ref_no");
		
		System.out.println("lead_no:"+lead_no);
		
		fetchCustomerDetailstocontractor=new ContractDAO().fetchCustomerDetailsToContractor(leadForm,lead_no,ref_no);
		if(fetchCustomerDetailstocontractor.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String insert_customer_details()
	{
		 String response="";
		HttpServletRequest request = ServletActionContext.getRequest();
		String lead_no=request.getParameter("lead_no");
		
		int status=new ContractDAO().insert_customer_details(customer,lead_no);
		
		q1=new QuotationIndexDAO().fetchQ1(quotationIndex);
		q2=new QuotationIndexDAO().fetchQ2(quotationIndex);
		
		if(q2.size()>0)
		{
			response="success1";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchContractDetails()
	{
		System.out.println("in fecth report");
		
		String response="";
		
		 HttpServletRequest request = ServletActionContext.getRequest();
		
		contractor=new ContractDAO().fetchContractDetails(customer);
		
		System.out.println(contractor.size());
		
		if(contractor.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String deleteContractor()
	{
		String response="";
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_contractor_id=request.getParameter("customer_id");
		int delete_status=new ContractDAO().deleteContractor(customer,delete_contractor_id);
		if(delete_status>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	public String contract_edit_Master()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String lead_no=request.getParameter("lead_no");
		
		contractor=new ContractDAO().update_contractor_Details(customer,lead_no);
		if(contractor!=null)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	/*public String editContractMaster()
	{
		String response="";
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String update_id=request.getParameter("update_id");
		
		int status=new ContractDAO().update_contractor(customer,update_id);
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}*/
	
	public String getContractor_details()
	{
		System.out.println("in action qq");
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String contractor_id=request.getParameter("contractor_id");
		contractor=new ContractDAO().getContractor_details(customer,contractor_id);
		return "success";
	}
	
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public String getRef_no1() {
		return ref_no1;
	}

	public void setRef_no1(String ref_no1) {
		this.ref_no1 = ref_no1;
	}
}
