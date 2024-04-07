package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.quotation.model.AboutWaterATMModel;

public class AboutWaterATMDAO {
	
	DBConnection connection=new DBConnection();

	public int insert_aboutWaterATM(AboutWaterATMModel aboutWaterATM) {
		int i=0;
		int max_count=0;
		
	try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `about_water_atm_master`(`name_of_index`) VALUES (?)");
			pst.setString(1, aboutWaterATM.getName_of_index());
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(about_water_atm_master.water_atm_id) FROM about_water_atm_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<aboutWaterATM.getLabelname().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `water_atm_details1`(`label_name`, `details`, `water_atm_id`) VALUES (?,?,?)");
						pst11.setString(1, aboutWaterATM.getLabelname()[j]);
						pst11.setString(2, aboutWaterATM.getDetails()[j]);
						pst11.setInt(3, max_count);
						i=pst11.executeUpdate();
					}
					
					for(int k=0;k<aboutWaterATM.getFeatures().length;k++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `water_atm_features`(`features`, `water_atm_id`) VALUES (?,?)");
						pst111.setString(1, aboutWaterATM.getFeatures()[k]);
						pst111.setInt(2, max_count);
						i=pst111.executeUpdate();
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	

}
