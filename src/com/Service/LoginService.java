package com.Service;

import java.sql.SQLException;

import com.login.loginModel.userinfo;


public interface LoginService {
	public userinfo loginService(String username, String password)throws SQLException;
	public userinfo loginService1(String username, String password)throws SQLException;
}
