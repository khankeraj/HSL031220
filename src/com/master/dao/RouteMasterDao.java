package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.master.model.CityModel;
import com.master.model.DriverModel;


public class RouteMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public int insert_route_Details(CityModel citymodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
						
			PreparedStatement psac = conn.prepareStatement("select * from route_master where route = '"+citymodel.getRoute()+"'");
			ResultSet rsac = psac.executeQuery();
			
			if(rsac.next())
			{
				return -1;
			}
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `route_master` (`route`) values(?)");
			pst.setString(1, citymodel.getRoute());
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
public int update_route_details(CityModel citymodel, String update_route) {
	// TODO Auto-generated method stub
	int i=0;
	int route_id=Integer.parseInt(update_route);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `route_master` SET `route`=? WHERE `id`=?");
		
		pst.setString(1, citymodel.getRoute());
		pst.setInt(2, route_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
}
