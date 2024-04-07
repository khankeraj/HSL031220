package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.HPCReportsModel;

public class HPCReportsDAO {

	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	

	public List<HPCReportsModel> fetchHPCReportsDetails(HPCReportsModel hpcReports) {
		// TODO Auto-generated method stub
		
		List<HPCReportsModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `high_pressure_compressor_id`,`quotation_name` FROM `hpc_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HPCReportsModel hpcReports1=new HPCReportsModel();
				hpcReports1.setHpc_id(rs.getInt(1));
				hpcReports1.setQuotation_name(rs.getString(2));
				
				list.add(hpcReports1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
