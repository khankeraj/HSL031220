package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.pwpcReportsModel;

public class pwpcReportsDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public List<pwpcReportsModel> fetchPWPCReports(pwpcReportsModel pwpc) {
		// TODO Auto-generated method stub
		List<pwpcReportsModel> pwpc1=new ArrayList<pwpcReportsModel>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `pwpc_id`,`quotation_name` FROM `product_wise_prod_cost_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				pwpcReportsModel pwpc11=new pwpcReportsModel();
				pwpc11.setPwpc_id(rs.getInt(1));
				pwpc11.setQuotation_name(rs.getString(2));
				pwpc1.add(pwpc11);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pwpc1;
	}

}
