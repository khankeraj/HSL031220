package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.quotation.model.CabinateWaterATMModel;

public class CabinateWaterATMDAO {
	
	DBConnection connection=new DBConnection();

	public int insert_cabinate_water_atm(CabinateWaterATMModel cabinateWaterAtm) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `cabinate_water_atm_master`(`name_of_index`, `image`) VALUES (?,?)");
			
			pst.setString(1, cabinateWaterAtm.getName_of_index());
			pst.setString(2, cabinateWaterAtm.getImage());
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(cabinate_water_atm_master.cabinate_water_atm_id) AS maxCount FROM cabinate_water_atm_master ");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<cabinateWaterAtm.getAtm_deatils().length;j++) 
					{
					
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `cabinate_water_atm_details`(`atm_details`, `cabinate_water_atm_id`) VALUES (?,?)");
						pst11.setString(1, cabinateWaterAtm.getAtm_deatils()[j]);
						pst11.setInt(2, max_count);
						i=pst11.executeUpdate();
					}
					
					for(int k=0;k<cabinateWaterAtm.getSpecifications().length;k++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `cabinate_water_atm_sp_details`(`specifications`, `quantity`, `cabinate_water_atm_is`) VALUES (?,?,?)");
						pst11.setString(1, cabinateWaterAtm.getSpecifications()[k]);
						pst11.setString(2, cabinateWaterAtm.getQuantity()[k]);
						pst11.setInt(3, max_count);
						i=pst11.executeUpdate();
					}
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
