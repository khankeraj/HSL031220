package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.HOTFABMoldReportsModel;

public class HotFABMoldReportsDAO {
	
	DBConnection connection=new DBConnection();
	public List<HOTFABMoldReportsModel> fetchHotFabMoldingDetails(HOTFABMoldReportsModel hotfab) {
		// TODO Auto-generated method stub
		List<HOTFABMoldReportsModel> list=new ArrayList<HOTFABMoldReportsModel>();
		
		Connection conn=connection.getConnection();
		 try {
			PreparedStatement pst=conn.prepareStatement("SELECT `hotfabmoldingmc_id`,`quotation_name` FROM `hotfabmold_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HOTFABMoldReportsModel hotfabmolding=new HOTFABMoldReportsModel();
				hotfabmolding.setHtfab_moldingId(rs.getInt(1));
				hotfabmolding.setQuotation_name(rs.getString(2));
				list.add(hotfabmolding);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
