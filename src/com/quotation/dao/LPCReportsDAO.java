package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.LPCReportsModel;

public class LPCReportsDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public List<LPCReportsModel> fetchLPCReportsDetails(LPCReportsModel lpcReporst) {
		// TODO Auto-generated method stub
		List<LPCReportsModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lpc_id`, `quotation_name` FROM `lpc_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LPCReportsModel lpcreports=new LPCReportsModel();
				lpcreports.setLpc_id(rs.getInt(1));
				lpcreports.setQuotation_name(rs.getString(2));
				list.add(lpcreports);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
