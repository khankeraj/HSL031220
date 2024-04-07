package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.dao.NewUserDao;
import com.login.loginModel.NewUserBean;
import com.login.loginModel.userinfo;



public class NewUserDaoImpl implements NewUserDao {

	DBConnection conn=new DBConnection();
	//Connection con=conn.getConnection();
	
	public int newUserDao(NewUserBean nub, userinfo lb) throws SQLException {
		
		Connection con=conn.getConnection();
		
		
		int role_id = 0;
		int user_id = 0;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = con
					.prepareStatement("select max(r.role_id) as maxroleid, max(u.uid) as max from role r, userinfo u where r.role_name='"
							+ nub.getRole_name() + "'");
			rs = pst.executeQuery();
			
			if (rs.next()) {
				role_id = rs.getInt(1);
				user_id = rs.getInt(2);
				
			}
			user_id++;
			if(lb.getUid()==0){
				lb.setUid(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lb.setUid(1);
		
	  
		
		
		try {
			String query="insert into userinfo values(" + user_id+ ",'" + nub.getUsername() + "','" + nub.getPassword() + "',"+ role_id + ",'" + nub.getEmail() + "','" + nub.getAddress()
					+ "','" + nub.getContact_no() + "','" + nub.getZone_name()
					+ "','" + nub.getOffice_name() + "','" + nub.getDept_name()
					+ "','" + lb.getUid() +"','" + nub.getCity_name()+"','" + nub.getDealerCode()+"','0000-00-00 00:00:00','' )";
			
			
			System.out.println("SQL:"+query);
			
			pst = con.prepareStatement(query);
			
			
			pst.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
		
		DBConnection.closeConnection();
		
		return 1;
		
	}

}
