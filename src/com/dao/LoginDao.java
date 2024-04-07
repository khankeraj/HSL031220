package com.dao;

import java.sql.SQLException;

import com.login.loginModel.userinfo;

public interface LoginDao {
	public userinfo loginDao(String username, String password)throws SQLException; 
	public userinfo loginDao1(String username, String password)throws SQLException;
}
