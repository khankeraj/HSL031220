package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.ShrinkMachineReportsModel;

public class ShrinkMachineReportsDAO {

	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	public List<ShrinkMachineReportsModel> fetchShrinkMachineDetails(ShrinkMachineReportsModel shrinkmcreports) {
		// TODO Auto-generated method stub
		List<ShrinkMachineReportsModel> list=new ArrayList<ShrinkMachineReportsModel>();
		try {
			
			PreparedStatement pst = conn.prepareStatement("SELECT `shrink_machine_id`,`quotation_name` FROM `shrink_machine_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ShrinkMachineReportsModel shrinkmcReports=new ShrinkMachineReportsModel();
				shrinkmcReports.setShrinkmc_id(rs.getInt(1));
				shrinkmcReports.setQuotation_name(rs.getString(2));
				list.add(shrinkmcReports);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
