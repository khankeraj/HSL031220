package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.FABLabelingMCModel;

public class FABLAbelingMCDAO {
	
	DBConnection connection=new DBConnection();

	public List<FABLabelingMCModel> fetchFABLabelingmcDetails(FABLabelingMCModel fablabelingmc) {
		// TODO Auto-generated method stub
		List<FABLabelingMCModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_labeling_id`,`quotation_name` FROM `fab_labeling_mc_config_001`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABLabelingMCModel fablabeling=new FABLabelingMCModel();
				fablabeling.setLabeling_id(rs.getInt(1));
				fablabeling.setQuotation_name(rs.getString(2));
				list.add(fablabeling);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}
