package com.quotation.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.ROWaterTPDAO;
import com.quotation.model.ROWaterTPModel;

public class ROWaterTPAction extends ActionSupport implements ModelDriven{

	private ROWaterTPModel rowater=new ROWaterTPModel();
	
	private List<ROWaterTPModel> roWatertp;
	private List<ROWaterTPModel> roWatertp1;
	private List<ROWaterTPModel> roWatertp2;
	private List<ROWaterTPModel> roWatertp3;
	private List<ROWaterTPModel> roWatertp4;
	private List<ROWaterTPModel> roWatertp5;
	
	private String checkQuotation_name;
	
	public List<ROWaterTPModel> getRoWatertp3() {
		return roWatertp3;
	}

	public void setRoWatertp3(List<ROWaterTPModel> roWatertp3) {
		this.roWatertp3 = roWatertp3;
	}

	public List<ROWaterTPModel> getRoWatertp4() {
		return roWatertp4;
	}

	public void setRoWatertp4(List<ROWaterTPModel> roWatertp4) {
		this.roWatertp4 = roWatertp4;
	}

	public List<ROWaterTPModel> getRoWatertp5() {
		return roWatertp5;
	}

	public void setRoWatertp5(List<ROWaterTPModel> roWatertp5) {
		this.roWatertp5 = roWatertp5;
	}

	public List<ROWaterTPModel> getRoWatertp2() {
		return roWatertp2;
	}

	public void setRoWatertp2(List<ROWaterTPModel> roWatertp2) {
		this.roWatertp2 = roWatertp2;
	}

	public List<ROWaterTPModel> getRoWatertp1() {
		return roWatertp1;
	}

	public void setRoWatertp1(List<ROWaterTPModel> roWatertp1) {
		this.roWatertp1 = roWatertp1;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchROConfiguration()
	{
		String response;
		roWatertp=new ROWaterTPDAO().fetchROConfiguration(rowater);
		
		roWatertp1=new ROWaterTPDAO().fetchROConfiguration1(rowater);
		
		roWatertp2=new ROWaterTPDAO().fetchROConfiguration2(rowater);
		
		roWatertp3=new ROWaterTPDAO().fetchROConfiguration3(rowater);
		
		roWatertp4=new ROWaterTPDAO().fetchROConfiguration4(rowater);
		
		roWatertp5=new ROWaterTPDAO().fetchROConfiguration5(rowater);
		
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
	
	public String insert_ro_water_plant() throws IOException
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		int i=new ROWaterTPDAO().insert_ro_water_tp(rowater);
		
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
	
	public String checkQuotationName()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String quotation_name=request.getParameter("quotation_name");
		checkQuotation_name=new ROWaterTPDAO().checkQuotationName(rowater,quotation_name);
		if(checkQuotation_name.equals("Name Of Quotation Already Exits!"))
		{
			response="success";
		}else
		{
			response="fail";
		}
		
		return response;
		
	}
	
	public String updateROWaterTP()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String ro_id=request.getParameter("ro_id");
		int i=new ROWaterTPDAO().updateROWaterTP(rowater,ro_id);
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
	
	
	public String deleteRoWatertp()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String ro_id=request.getParameter("quotation_id");
		
		System.out.println("ro_id:"+ro_id);
		
		int i=new ROWaterTPDAO().deleteRoWatertp(rowater,ro_id);
			if(i>0)
			{
				System.out.println("success");
				response="success";
			}
			else
			{
				System.out.println("fail");
				response="fail";
			}
			
			return response;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return rowater;
	}

	public ROWaterTPModel getRowater() {
		return rowater;
	}


	public void setRowater(ROWaterTPModel rowater) {
		this.rowater = rowater;
	}

	public List<ROWaterTPModel> getRoWatertp() {
		return roWatertp;
	}

	public void setRoWatertp(List<ROWaterTPModel> roWatertp) {
		this.roWatertp = roWatertp;
	}

	public String getCheckQuotation_name() {
		return checkQuotation_name;
	}

	public void setCheckQuotation_name(String checkQuotation_name) {
		this.checkQuotation_name = checkQuotation_name;
	}

}
