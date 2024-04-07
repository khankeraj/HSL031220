package com.master.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.Resource_Type_Master_Dao;
import com.master.dao.Resource_Type_Master_Dao;
import com.master.model.LoginBean;
import com.master.model.TransportBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Resource_Type_Master_Action extends ActionSupport implements ModelDriven<TransportBean>, ServletRequestAware {

	/**
	 * 
	 */
	@Override

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	private static final long serialVersionUID = 1L;

	HttpServletRequest request;

	private TransportBean bin = new TransportBean();

	private List<TransportBean> ProductReport = new ArrayList<TransportBean>();

	private Map session;
	
	private String price1;
	
	
	
	

	public String insertResourceTypeMaster() throws SQLException, ParseException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response = new Resource_Type_Master_Dao().insertResourceTypeMaster(bin,bean);
		
		if (response.equals("Already")) {
			response = "already";
		
		} else if (response.equals("success")) {
			response = "success";
		
		} else {
			response = "fail";
		}
		
		return response;

	}

	
	public String execute()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return "success";
		
	}
	
	

	
	
	public String displayResourceTypeMaster() throws SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		ProductReport = new Resource_Type_Master_Dao().displayResourceTypeMaster(bean);
		
		
		  return "display";

	}
	
	
	
	public String editResourceTypeMaster()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		ProductReport = new Resource_Type_Master_Dao().displayResourceTypeMasterEdit(bean,id);
		
		if(ProductReport.size()>0)
		{
			response="editResourceTypeMaster";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
		//return "editProductMaster";
	}
	
	
	
	
	
	
	public String updateResourceTypeMaster() throws Exception
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		List<TransportBean> ss = Resource_Type_Master_Dao.updateResourceTypeMaster(bin,bean);
		
		
		ProductReport = new Resource_Type_Master_Dao().displayResourceTypeMaster(bean);
		
		return "updateResourceTypeMaster";
	}
	
	
	
	public String deleteResourceTypeMaster() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		String delete=Resource_Type_Master_Dao.deleteResourceTypeMaster(bin,bean,id);
		
		ProductReport = new Resource_Type_Master_Dao().displayResourceTypeMaster(bean);
		
		return "deleteResourceTypeMaster";
		
	}
	
	
	
	

	

	public String getPrice1() {
		return price1;
	}


	public void setPrice1(String price1) {
		this.price1 = price1;
	}


	


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public TransportBean getBin() {
		return bin;
	}


	public void setBin(TransportBean bin) {
		this.bin = bin;
	}


	public List<TransportBean> getProductReport() {
		return ProductReport;
	}


	public void setProductReport(List<TransportBean> productReport) {
		ProductReport = productReport;
	}


	@Override
	public TransportBean getModel() {
		// TODO Auto-generated method stub
		return bin;
	}


	


	

	
}
