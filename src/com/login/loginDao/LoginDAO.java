package com.login.loginDao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;

public class LoginDAO {
	
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginAccess(userinfo user) {
		
		String response = "";
		
		DBConnection conn=new DBConnection();
		try {
				Connection connection=conn.getConnection();
				PreparedStatement pst=connection.prepareStatement("select username,password from userinfo");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					userinfo userinfo=new userinfo();
					String username1=rs.getString(1);
					String password1=rs.getString(2);
					System.out.println("user:"+username1+"password:"+password1);
					
					HttpServletRequest request = ServletActionContext.getRequest();
					String username=request.getParameter("username");
					String password=request.getParameter("password");
					
					
					userinfo.setUsername(username);
					
					System.out.println("username:"+username+"password:"+password);
					
					if(username1.equals(username) && password1.equals(password))
					{
						System.out.println("success");
						
						response="success";
					}
					else
					{
						System.out.println("fail");
						response="fail";
					}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public String getTotalOutstanding() {
		// TODO Auto-generated method stub
		String result = "";
		double debit = 0;
		double credit = 0;
		double res = 0;
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement("select sum(amount) from `transportercreditdebit` where Typecode='101'");
			ResultSet rs = pst.executeQuery();
			
			//System.out.println("pst: "+pst);
			if(rs.next())
			{
				debit = Double.parseDouble(rs.getString(1));
			}
			
			
			PreparedStatement pst1 = connection.prepareStatement("select sum(amount) from `transportercreditdebit` where Typecode='201'");
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			{
				credit = Double.parseDouble(rs1.getString(1));
			}
			
			res = debit - credit;
			
			result = String.valueOf(res);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return result;
	}
}
