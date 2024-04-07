package com.Service;

import java.sql.SQLException;

import com.accessibility.action.RoleAction;
import com.login.loginModel.userinfo;



public interface RoleService {
	public int roleService(RoleAction rb, userinfo lb) throws SQLException;
	
	public int roleService1(RoleAction rb, userinfo lb) throws SQLException;
}
