package com.Service.Impl;

import java.sql.SQLException;

import com.Factory.DAOFactory;
import com.Service.NewUserService;
import com.dao.NewUserDao;
import com.login.loginModel.NewUserBean;
import com.login.loginModel.userinfo;
import com.master.model.LeadBean;



public class NewUserServiceImpl implements NewUserService {

	@Override
	public int newUserService(NewUserBean rb, userinfo lb) throws SQLException {
		DAOFactory factory = DAOFactory.getInstance();
		NewUserDao newUserDao = factory.getNewUserDao();
		return newUserDao.newUserDao(rb, lb);
	}

	

}
