package com.dao;

import java.sql.SQLException;

import com.accessibility.action.RoleAction;
import com.login.loginModel.userinfo;


public interface RoleDao {
	public int roleDao(RoleAction rb, userinfo lb) throws SQLException;
	
	public int roleDao1(RoleAction rb, userinfo lb) throws SQLException;
}
