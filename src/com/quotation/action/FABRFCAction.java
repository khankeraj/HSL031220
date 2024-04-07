package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FABRFCDAO;
import com.quotation.dao.ROWaterTPDAO;
import com.quotation.model.FABRFCModel;

public class FABRFCAction extends ActionSupport implements ModelDriven{
	
	private FABRFCModel fabrfc=new FABRFCModel();
	private List<FABRFCModel> fabrfc1;
	private List<FABRFCModel> fabrfc2;
	private List<FABRFCModel> fabrfc3;
	private List<FABRFCModel> fabrfc4;
	private List<FABRFCModel> fabrfc5;
	
	private List<FABRFCModel> fabrfc6;
	private List<FABRFCModel> fabrfc7;
	private List<FABRFCModel> fabrfc8;
	private List<FABRFCModel> fabrfc9;
	private List<FABRFCModel> fabrfc10;
	
	public List<FABRFCModel> getFabrfc6() {
		return fabrfc6;
	}

	public void setFabrfc6(List<FABRFCModel> fabrfc6) {
		this.fabrfc6 = fabrfc6;
	}

	public List<FABRFCModel> getFabrfc7() {
		return fabrfc7;
	}

	public void setFabrfc7(List<FABRFCModel> fabrfc7) {
		this.fabrfc7 = fabrfc7;
	}

	public List<FABRFCModel> getFabrfc8() {
		return fabrfc8;
	}

	public void setFabrfc8(List<FABRFCModel> fabrfc8) {
		this.fabrfc8 = fabrfc8;
	}

	public List<FABRFCModel> getFabrfc9() {
		return fabrfc9;
	}

	public void setFabrfc9(List<FABRFCModel> fabrfc9) {
		this.fabrfc9 = fabrfc9;
	}

	public List<FABRFCModel> getFabrfc10() {
		return fabrfc10;
	}

	public void setFabrfc10(List<FABRFCModel> fabrfc10) {
		this.fabrfc10 = fabrfc10;
	}

	public List<FABRFCModel> getFabrfc5() {
		return fabrfc5;
	}

	public void setFabrfc5(List<FABRFCModel> fabrfc5) {
		this.fabrfc5 = fabrfc5;
	}

	public List<FABRFCModel> getFabrfc1() {
		return fabrfc1;
	}

	public void setFabrfc1(List<FABRFCModel> fabrfc1) {
		this.fabrfc1 = fabrfc1;
	}

	public List<FABRFCModel> getFabrfc2() {
		return fabrfc2;
	}

	public void setFabrfc2(List<FABRFCModel> fabrfc2) {
		this.fabrfc2 = fabrfc2;
	}

	public List<FABRFCModel> getFabrfc3() {
		return fabrfc3;
	}

	public void setFabrfc3(List<FABRFCModel> fabrfc3) {
		this.fabrfc3 = fabrfc3;
	}

	public List<FABRFCModel> getFabrfc4() {
		return fabrfc4;
	}

	public void setFabrfc4(List<FABRFCModel> fabrfc4) {
		this.fabrfc4 = fabrfc4;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_fabrfcMaster()
	{
		String response;
		
		int i=new FABRFCDAO().insert_fabrfc_master(fabrfc);
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
	
	public String fetch_fab_rfc_master_details()
	{
		String response;
		
		fabrfc1=new FABRFCDAO().fectrfcMasterDetails(fabrfc);
		
		fabrfc2=new FABRFCDAO().fectrfcMasterDetails1(fabrfc);
		
		fabrfc3=new FABRFCDAO().fectrfcMasterDetails2(fabrfc);
		
		fabrfc4=new FABRFCDAO().fectrfcMasterDetails3(fabrfc);
		
		fabrfc5=new FABRFCDAO().fectrfcMasterDetails4(fabrfc);
		
		
		System.out.println("max size Of fabrfc001:"+fabrfc1.size());
		
		System.out.println("max size Of fabrfc002:"+fabrfc2.size());
		
		System.out.println("max size Of fabrfc003:"+fabrfc3.size());
		
		if(fabrfc1.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}

	public String updateFABRFCDetails()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String fabrfc_id=request.getParameter("update_id");
		
		int i=new FABRFCDAO().updateFABRFCDetails(fabrfc,fabrfc_id);
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
	
	public String fetchFABRFCFOrUpdate()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String fabrfc_id=request.getParameter("fabrfc_id");
		
		fabrfc6=new FABRFCDAO().fectrfcMasterDetails6(fabrfc,fabrfc_id);
		
		fabrfc7=new FABRFCDAO().fectrfcMasterDetail7(fabrfc,fabrfc_id);
		
		fabrfc8=new FABRFCDAO().fectrfcMasterDetails8(fabrfc,fabrfc_id);
		
		fabrfc9=new FABRFCDAO().fectrfcMasterDetails9(fabrfc,fabrfc_id);
		
		fabrfc10=new FABRFCDAO().fectrfcMasterDetails10(fabrfc,fabrfc_id);
		
		if(fabrfc6.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String deleteFABRFC()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String fabrfc_id=request.getParameter("fabrfc_id");
		int i=new FABRFCDAO().deleteFABRFC(fabrfc,fabrfc_id);
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
		return fabrfc;
	}

	public FABRFCModel getFabrfc() {
		return fabrfc;
	}

	public void setFabrfc(FABRFCModel fabrfc) {
		this.fabrfc = fabrfc;
	}

}
