package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.AutoCasePackerRepoModel;

public class AutoCasePackerRepoDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public List<AutoCasePackerRepoModel> fetchAutocasePackerreports() {
		// TODO Auto-generated method stub
		List<AutoCasePackerRepoModel> list=new ArrayList<AutoCasePackerRepoModel>();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT `autocase_packer_id`,`quotation_name` FROM `autocase_packer_config_master`");
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				AutoCasePackerRepoModel autocasePacker=new AutoCasePackerRepoModel();
				autocasePacker.setAutocasepacker_id(rs.getInt(1));
				autocasePacker.setQuotation_name(rs.getString(2));
				list.add(autocasePacker);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	

}
