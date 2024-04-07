package com.master.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

//import antlr.collections.List;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.master.dao.job_card_dao1;
import com.master.model.Job_card_bean;
import com.master.model.LoginBean;;

public class Job_card_action1 extends ActionSupport implements ServletRequestAware,SessionAware, ModelDriven<Job_card_bean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725869288211208449L;
	private List<Job_card_bean> Job_card_bean=new ArrayList<Job_card_bean>();
	HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request)
	{
		this.request=request;
		
	}
	private Job_card_bean jb=new Job_card_bean();
	private LoginBean bean=new LoginBean();
	
	private String response="";
	private String Job_Card_no="";
	private String Vehicle_no="";
	private String Date="";
	private String Customer_name="";
	
	public String canceljobcard()throws IOException,SQLException
	{
		Job_Card_no = request.getParameter("Job_Card_no");
		response = new job_card_dao1().canceljobcard(Job_Card_no );
		return "success";	
	}
	
	
	public String Add_New_Customer()throws IOException,SQLException
	{
		
		System.out.println(">>>"+jb.getCustomer_name1());
		
		String vehicleno1 = request.getParameter("vehicleno1");
		
		String modelno1 = request.getParameter("modelno1");
		
		String Customer_name1 = request.getParameter("Customer_name1");
		
		String chasisno = request.getParameter("chasisno");
	
		String engineno = request.getParameter("engineno");
		
		String mobile = request.getParameter("mobile");
	
		String address = request.getParameter("address");
		
		String Phone = request.getParameter("Phone");
	
		String vatno = request.getParameter("vatno");
		
		String cust_subname = request.getParameter("cust_subname");

		
		
		response = new job_card_dao1().insertCustomerInfo( vehicleno1,modelno1,Customer_name1,chasisno,engineno,mobile,address,Phone,vatno,cust_subname);
		System.out.println("<<<<"+response);
		if(response.equalsIgnoreCase("already"))
		{
			//request.setAttribute("role_bean",Job_card_bean);
			return "already";
		}
		else 	if(response.equalsIgnoreCase("success"))
		
		{
			return "success";	
		}else{
			return "fail";	
		}
		
		
	}
	
	
	
	public String openbill()throws IOException,SQLException
	{
		
		System.out.println(">>>"+jb.getCustomer_name1());
		

		
			return "success";	
		
		
		
	}
	
	
	
	public String Recordlist()throws IOException,SQLException
	{
		
		
		Job_card_bean = new job_card_dao1().fetchjobcardInfo();
		
		
			
			return "success";
	
		
	}
	
	
	
	
public String execute()throws IOException,SQLException
	{
		//jb=new jobcardvaluestobean().setvalues1(this);
	
	
	System.out.println("huthgrhtori");
	 
	String Vehicle_no1 = request.getParameter("Vehicle_no1");
	//System.out.println("2");
	String modelno1 = request.getParameter("modelnonn");
	
	String drunning = request.getParameter("drunning");
	
	
	
	
	String Customer_name1 = request.getParameter("Customer_name1");

	String KM1 = request.getParameter("KM1");
	
	String Fuel = request.getParameter("Fuel");
	
	String Date1 = request.getParameter("Date1");
	String Body_damg = request.getParameter("Body_damg");
	String Supervisor = request.getParameter("Supervisor");
	String Mechanic = request.getParameter("Mechanic");
	String multipleValues = request.getParameter("multipleValues"); 
	
	String Batteryno = request.getParameter("Batteryno"); 
	
	
	jb.setVehicle_no(Vehicle_no1);
	jb.setModel_jobcard(modelno1);
	jb.setCustomer_name(Customer_name1);
	jb.setKM(KM1);
	jb.setFuel(Fuel);
	jb.setDate(Date1);
	jb.setBody_damg(Body_damg);
	jb.setSupervisor(Supervisor);
	jb.setMechanic(Mechanic);
	jb.setBatteryno(Batteryno);
	jb.setDrunning(drunning);
	//System.out.println("jhlfghl"+jb.getService_Book());
	
	
	
	
	jb = new job_card_dao1().insertjob_card( jb,bean,multipleValues);
	
	request.setAttribute("jobcardno", jb.getJob_Card_no());
	request.setAttribute("mobile", jb.getMobile());
		
		if(jb.getResponse().equalsIgnoreCase(""))
		{
			//request.setAttribute("role_bean",Job_card_bean);
			return "fail";
		}
		else
		{
			return "success";	
		}
	}


@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}


public List<Job_card_bean> getJob_card_bean() {
	return Job_card_bean;
}


public void setJob_card_bean(List<Job_card_bean> job_card_bean) {
	Job_card_bean = job_card_bean;
}


public Job_card_bean getJb() {
	return jb;
}


public void setJb(Job_card_bean jb) {
	this.jb = jb;
}


public LoginBean getBean() {
	return bean;
}


public void setBean(LoginBean bean) {
	this.bean = bean;
}


public String getResponse() {
	return response;
}


public void setResponse(String response) {
	this.response = response;
}


@Override
public Job_card_bean getModel() {
	// TODO Auto-generated method stub
	return jb;
}



public String getJob_Card_no() {
	return Job_Card_no;
}



public void setJob_Card_no(String job_Card_no) {
	Job_Card_no = job_Card_no;
}



public String getVehicle_no() {
	return Vehicle_no;
}



public void setVehicle_no(String vehicle_no) {
	Vehicle_no = vehicle_no;
}



public String getDate() {
	return Date;
}



public void setDate(String date) {
	Date = date;
}



public String getCustomer_name() {
	return Customer_name;
}



public void setCustomer_name(String customer_name) {
	Customer_name = customer_name;
}









}