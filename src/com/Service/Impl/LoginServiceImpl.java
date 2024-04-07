package com.Service.Impl;

import java.sql.SQLException;

import com.Factory.DAOFactory;
import com.Service.LoginService;
import com.dao.LoginDao;

import com.login.loginModel.userinfo;


public class LoginServiceImpl implements LoginService {

	public userinfo loginService(String username, String password)
			throws SQLException {

		DAOFactory factory = DAOFactory.getInstance();
		LoginDao logindao = factory.getLoginDao();
		return logindao.loginDao(username, password);
	}
	
	
	public userinfo loginService1(String username, String password)
			throws SQLException {

		DAOFactory factory = DAOFactory.getInstance();
		LoginDao logindao = factory.getLoginDao();
		return logindao.loginDao1(username, password);
	}
}
