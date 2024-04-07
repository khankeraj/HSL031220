
package com.dao;

import java.sql.SQLException;

import com.login.loginModel.NewUserBean;
import com.login.loginModel.userinfo;



public interface NewUserDao {
	public int newUserDao(NewUserBean rb, userinfo lb) throws SQLException;
}

