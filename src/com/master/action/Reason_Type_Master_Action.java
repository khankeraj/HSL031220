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
import com.master.dao.Reason_Type_Master_Dao;
import com.master.dao.Reason_Type_Master_Dao;
import com.master.model.LoginBean;
import com.master.model.TransportBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Reason_Type_Master_Action extends ActionSupport implements ModelDriven<TransportBean>, ServletRequestAware {

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
	
	
	
	

	public String insertReasonTypeMaster() throws SQLException, ParseException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response = new Reason_Type_Master_Dao().insertReasonTypeMaster(bin,bean);
		
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
	
	

	
	
	public String displayReasonTypeMaster() throws SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		ProductReport = new Reason_Type_Master_Dao().displayReasonTypeMaster(bean);
		
		
		  return "display";

	}
	
	
	
	public String editReasonTypeMaster()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		ProductReport = new Reason_Type_Master_Dao().displayReasonTypeMasterEdit(bean,id);
		
		if(ProductReport.size()>0)
		{
			response="editReasonTypeMaster";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
		//return "editProductMaster";
	}
	
	
	
	
	
	
	public String updateReasonTypeMaster() throws Exception
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		List<TransportBean> ss = Reason_Type_Master_Dao.updateReasonTypeMaster(bin,bean);
		
		
		ProductReport = new Reason_Type_Master_Dao().displayReasonTypeMaster(bean);
		
		return "updateReasonTypeMaster";
	}
	
	
	
	public String deleteReasonTypeMaster() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		String delete=Reason_Type_Master_Dao.deleteReasonTypeMaster(bin,bean,id);
		
		ProductReport = new Reason_Type_Master_Dao().displayReasonTypeMaster(bean);
		
		return "deleteReasonTypeMaster";
		
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
