
package com.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.Factory.ServiceFactory;
import com.Service.NewUserService;
import com.ValuesToBean.NewUserActionToNewUserBean;
import com.login.loginModel.NewUserBean;
import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.opensymphony.xwork2.ActionSupport;

public class NewUserAction extends ActionSupport implements SessionAware {
	private Map session;
	private String username;
	private String password;
	private String role_name;
	private String email;
	private String address;
	private String contact_no;
	private String zone_name;
	private String office_name;
	private String dept_name;
	private String city_name;
    private String dealerCode;	

public String getDealerCode() {
	return dealerCode;
}

public void setDealerCode(String dealerCode) {
	this.dealerCode = dealerCode;
}



public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getZone_name() {
		return zone_name;
	}

	public void setZone_name(String zone_name) {
		this.zone_name = zone_name;
	}

	public String getOffice_name() {
		return office_name;
	}

	public void setOffice_name(String office_name) {
		this.office_name = office_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	

	
	
	
	public String execute() throws SQLException {
		
		
		ServiceFactory factory = ServiceFactory.getInstance();
		
		NewUserService newuserservice = factory.getNewUserService();
		
		NewUserBean nub = new NewUserActionToNewUserBean().setvalues(this);
		
		userinfo lb = (userinfo) session.get(Constants.USER_PROFILE);
		if(lb==null){
		
		}
		//
		int status = newuserservice.newUserService(nub, lb);
		if (status == 1) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	
	
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCity_name() {
		return city_name;
	}


}
