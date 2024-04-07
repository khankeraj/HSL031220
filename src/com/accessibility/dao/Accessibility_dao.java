package com.accessibility.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.accessibility.model.accessibility_model;
import com.login.loginModel.userinfo;
import com.master.util.SystemDateTime;







public class Accessibility_dao {
	
	static DBConnection connection=new DBConnection();
	
	
public String insertRoleMaster(accessibility_model bin, userinfo bean)throws SQLException,ParseException {
		
		String response="";
		
		Connection conn=connection.getConnection();
		
		try {
			
			
				
					
					PreparedStatement pst = conn.prepareStatement("select *  from role_master where role_name=? ");
					
					pst.setString(1,bin.getRoute());
			
			          
					ResultSet resultSet1=pst.executeQuery();
					
					if(resultSet1.next())
					{
					response="Already";
					
					}
					
					else
					
					{
						
						
						
						
						
						
					PreparedStatement pst2 = conn.prepareStatement(
							"insert into role_master(role_name,username,datetime) values(?,?,?) ");
					
						pst2.setString(1,bin.getRoute().trim());
					
					
					pst2.setString(2, bean.getUsername());
					
					pst2.setString(3, SystemDateTime.CurrentDateTime());
					
					
					
				
					
					pst2.executeUpdate();
					
					
						
					response = "success";
				}
					
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		DBConnection.closeConnection();
		
		return response;

	}


public List<accessibility_model> displayRoleMaster(userinfo bean) {

	List<accessibility_model> report = new ArrayList<accessibility_model>();
	
	Connection conn=connection.getConnection();
	
	try {
		
		//PreparedStatement pst = connection.prepareStatement("select *  from medicine_master where clinicId='"+bean.getClinicId()+"' ");
		
		PreparedStatement pst = conn.prepareStatement("select *  from role_master  ");
	
	
		ResultSet resultSet1=pst.executeQuery();
	
		while(resultSet1.next())
	
		{
	
			accessibility_model bean1 = new accessibility_model();
		
			bean1.setRoute(resultSet1.getString("role_name"));
			
			bean1.setId(resultSet1.getString("id"));
			
		
			report.add(bean1);

			
		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println(e.getMessage());
	}		
	
	
	DBConnection.closeConnection();
	
	return report;
	
	
}


public static String deleteRoleMaster(accessibility_model pb,userinfo bean,String id) throws Exception {

	Connection conn=connection.getConnection();
	
	try {
		
		PreparedStatement pst4 = conn.prepareStatement("delete from role_master where id='"
						+ id+ "' ");

	//System.out.println("Delete>>>"+pst4);
		pst4.executeUpdate();

		
		
			
	} catch (Exception e) {
		// TODO: handle exception
	}
	

	DBConnection.closeConnection();
	
	return "success";
	

}



public List<accessibility_model> fetchroleReport1(userinfo bean) {
	// TODO Auto-generated method stub
	List<accessibility_model> list2 = new ArrayList<accessibility_model>();
	try {

		
		Connection conn=connection.getConnection();
		
	
		PreparedStatement pst2 = conn
				.prepareStatement("select  role_name  from role ");
		
		
		
		ResultSet rs = pst2.executeQuery();
		
		while (rs.next()) {
			accessibility_model amb = new accessibility_model();

			amb.setRole_name(rs.getString("role_name"));

			/*
			 * amb.setZones(rs.getString("zones"));
			 * amb.setOffices(rs.getString("offices"));
			 * amb.setCity_name(rs.getString("city_name"));
			 * amb.setDepartments(rs.getString("departments"));
			 * amb.setUsers(rs.getString("users"));
			 */
			list2.add(amb);
		}

	} catch (Exception ex) {
		
	}
	DBConnection.closeConnection();
	return list2;
}


public List<accessibility_model> adduserMaster(userinfo bean) {

	List<accessibility_model> report = new ArrayList<accessibility_model>();
	
	Connection conn=connection.getConnection();
	
	try {
		
		
		PreparedStatement pst = conn.prepareStatement("select *  from userinfo");
	
	
		ResultSet resultSet1=pst.executeQuery();
	
		while(resultSet1.next())
	
		{
	
			accessibility_model bean1 = new accessibility_model();
		
			
			 	
			bean1.setUid(resultSet1.getString("uid"));
			bean1.setUser_name(resultSet1.getString("username"));
			bean1.setUser_type(resultSet1.getString("type"));
			bean1.setUser_contact(resultSet1.getString("contact_no"));
			bean1.setUser_password(resultSet1.getString("password"));
			
			
		
			report.add(bean1);

			
		
	}
	
	} catch (Exception e) {
		// TODO: handle exception
	}		
	
	
	DBConnection.closeConnection();
	
	return report;
	
	
}

public String updateuser(accessibility_model bin, userinfo bean)throws SQLException,ParseException {
	
	String response="";
	
	Connection conn=connection.getConnection();
	
	try {
		
		
			
			
		PreparedStatement pst = null;
		
		pst = conn.prepareStatement("update userinfo set password='" + bin.getPassword() + "' where username='" + bin.getUser_name()
				+ "' and password='" + bin.getCurrent_password() + "' ");
		
		
		int k = pst.executeUpdate();
		
		
		if (k > 0)
			return "success";
		else
			return "fail";

				
		
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	DBConnection.closeConnection();
	
	return response;

}

}
