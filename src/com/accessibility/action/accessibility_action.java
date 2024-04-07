package com.accessibility.action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.accessibility.dao.Accessibility_dao;
import com.accessibility.model.accessibility_model;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class accessibility_action  extends ActionSupport implements ModelDriven<accessibility_model>, ServletRequestAware  {

	
	private accessibility_model bin = new accessibility_model();
	
	private List<accessibility_model> ProductReport = new ArrayList<accessibility_model>();
	
	private List<accessibility_model> role_master_bean=new ArrayList<accessibility_model>();
	
	private List<accessibility_model> areamaster=new ArrayList<accessibility_model>();
	
	
	
public List<accessibility_model> getRole_master_bean() {
		return role_master_bean;
	}



	public void setRole_master_bean(List<accessibility_model> role_master_bean) {
		this.role_master_bean = role_master_bean;
	}



	public List<accessibility_model> getAreamaster() {
		return areamaster;
	}



	public void setAreamaster(List<accessibility_model> areamaster) {
		this.areamaster = areamaster;
	}



public String insertRoleMaster() throws SQLException, ParseException {
		
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response = new Accessibility_dao().insertRoleMaster(bin,bean);
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





public String displayRoleMaster() throws SQLException, ParseException {

	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
		
	
	ProductReport = new Accessibility_dao().displayRoleMaster(bean);
	
	
	  return "display";

}
	



public String deleteRoleMaster() throws Exception
{
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
		
	HttpServletRequest request=ServletActionContext.getRequest();
	String id=request.getParameter("id");
	
	String delete=Accessibility_dao.deleteRoleMaster(bin,bean,id);
	
	ProductReport = new Accessibility_dao().displayRoleMaster(bean);
	
	
	return "deleteRoleMaster";
	
}





public String eeeeee()throws IOException,SQLException
{
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
 
	 role_master_bean= new Accessibility_dao().fetchroleReport1(bean);
	
	
	/*if(role_master_bean.size()>0)
	{
		request.setAttribute("role_bean",role_master_bean);
		return "success";
	}
	else
	{
		return "fail";	
	}*/
	
	return "success";
}




public String execute1()
{
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	return "success";
	
}




public String adddisplayProductMaster() throws SQLException {

	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
	areamaster = new Accessibility_dao().adduserMaster(bean);
	
	
	  return "display";

}




public String Opennew() throws IOException, SQLException {
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
		return "success";

	}



public String update_user() throws Exception {
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	String response = new Accessibility_dao().updateuser(bin,bean);

	if (response.equals("success"))
		return "success";
	else
		return "fail";

	/*
	 * else { return "fail"; }
	 */

}
	
public String newuser()
{
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
	return "success";
	
}
	public List<accessibility_model> getProductReport() {
		return ProductReport;
	}

	public void setProductReport(List<accessibility_model> productReport) {
		ProductReport = productReport;
	}

	public accessibility_model getBin() {
		return bin;
	}

	public void setBin(accessibility_model bin) {
		this.bin = bin;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public accessibility_model getModel() {
		// TODO Auto-generated method stub
		return bin;
	}

}
