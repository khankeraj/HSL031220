package com.master.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.master.model.ResourceMasterModel;

public class ResourceMasterDAO {

	public int insert_resource_master(ResourceMasterModel resource) {
		// TODO Auto-generated method stub
		int i=0;
		DBConnection connection=new DBConnection();
		java.sql.Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `resource_master`(`resource_name`) VALUES (?)");
			pst.setString(1, resource.getResource_name());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
}
