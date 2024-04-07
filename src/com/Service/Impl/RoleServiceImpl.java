package com.Service.Impl;

import java.sql.SQLException;

import com.Factory.DAOFactory;
import com.Service.RoleService;
import com.accessibility.action.RoleAction;
import com.dao.RoleDao;
import com.login.loginModel.userinfo;


public class RoleServiceImpl implements RoleService {

	@Override
	public int roleService(RoleAction rb, userinfo lb) throws SQLException {
		DAOFactory factory = DAOFactory.getInstance();
		RoleDao roledao = factory.getRoleDao();
		return roledao.roleDao(rb, lb);

	}
	
	
	public int roleService1(RoleAction rb, userinfo lb) throws SQLException {
		DAOFactory factory = DAOFactory.getInstance();
		RoleDao roledao = factory.getRoleDao();
		return roledao.roleDao1(rb, lb);

	}

}
