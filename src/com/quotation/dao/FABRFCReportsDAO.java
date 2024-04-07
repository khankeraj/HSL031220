package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.FABRFCReportsModel;

public class FABRFCReportsDAO {
	
	DBConnection connection=new DBConnection();
	
	public List<FABRFCReportsModel> fetchFABRFCReports(FABRFCReportsModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCReportsModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_rins_fill_cap_maid`, `quotation_name` FROM `fab_rfc_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCReportsModel fabrfc1=new FABRFCReportsModel();
				fabrfc1.setFabrfc_id(rs.getInt(1));
				fabrfc1.setQuotation_name(rs.getString(2));
				list.add(fabrfc1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	

}
