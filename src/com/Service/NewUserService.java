package com.Service;

import java.sql.SQLException;

import com.dao.NewUserDao;
import com.login.loginModel.NewUserBean;
import com.login.loginModel.userinfo;


public interface NewUserService {
	public int newUserService(NewUserBean rb, userinfo lb) throws SQLException;
}
