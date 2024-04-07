package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.ROReportsDAO;
import com.quotation.dao.ROWaterTPDAO;
import com.quotation.model.ROModel;
import com.quotation.model.ROWaterTPModel;

public class ROReportsAction extends ActionSupport implements ModelDriven{

	private ROModel ro_name=new ROModel();
	private List<ROModel> roWatertp;
	private List<ROModel> roWatertp1;
	private List<ROModel> roWatertp2;
	private List<ROModel> roWatertp3;
	private List<ROModel> roWatertp4;
	private List<ROModel> roWatertp5;
	
	public List<ROModel> getRoWatertp() {
		return roWatertp;
	}

	public void setRoWatertp(List<ROModel> roWatertp) {
		this.roWatertp = roWatertp;
	}

	public List<ROModel> getRoWatertp1() {
		return roWatertp1;
	}

	public void setRoWatertp1(List<ROModel> roWatertp1) {
		this.roWatertp1 = roWatertp1;
	}

	public List<ROModel> getRoWatertp2() {
		return roWatertp2;
	}

	public void setRoWatertp2(List<ROModel> roWatertp2) {
		this.roWatertp2 = roWatertp2;
	}

	public List<ROModel> getRoWatertp3() {
		return roWatertp3;
	}

	public void setRoWatertp3(List<ROModel> roWatertp3) {
		this.roWatertp3 = roWatertp3;
	}

	public List<ROModel> getRoWatertp4() {
		return roWatertp4;
	}

	public void setRoWatertp4(List<ROModel> roWatertp4) {
		this.roWatertp4 = roWatertp4;
	}

	public List<ROModel> getRoWatertp5() {
		return roWatertp5;
	}

	public void setRoWatertp5(List<ROModel> roWatertp5) {
		this.roWatertp5 = roWatertp5;
	}

	public ROModel getRo_name() {
		return ro_name;
	}

	public void setRo_name(ROModel ro_name) {
		this.ro_name = ro_name;
	}

	private List<ROModel> roList;
	
	public List<ROModel> getRoList() {
		return roList;
	}

	public void setRoList(List<ROModel> roList) {
		this.roList = roList;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchReports()
	{
		String response;
		roList=new ROReportsDAO().fetch_roReports(ro_name);
		System.out.println("ro_name max size:"+roList.size());
		if(roList.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
	}
	
	public String fetchROConfiguration()
	{
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		String response;
		String quotation_id=request.getParameter("quotation_id");
		System.out.println("update Quotation_id:"+quotation_id);
		
		roWatertp=new ROReportsDAO().fetchROConfiguration(ro_name,quotation_id);
		
		roWatertp1=new ROReportsDAO().fetchROConfiguration1(ro_name,quotation_id);
		
		roWatertp2=new ROReportsDAO().fetchROConfiguration2(ro_name,quotation_id);
		
		roWatertp3=new ROReportsDAO().fetchROConfiguration3(ro_name,quotation_id);
		
		roWatertp4=new ROReportsDAO().fetchROConfiguration4(ro_name,quotation_id);
		
		roWatertp5=new ROReportsDAO().fetchROConfiguration5(ro_name,quotation_id);
		
		System.out.println("max grid 5:"+roWatertp5.size());
		
		System.out.println("max grid 4:"+roWatertp4.size());
		
		System.out.println("max grid 3:"+roWatertp3.size());
		
		System.out.println("max grid 2:"+roWatertp2.size());
		
		System.out.println("max grid 1:"+roWatertp1.size());
		
		if(roWatertp.size()>0)
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
		return ro_name;
	}

}
