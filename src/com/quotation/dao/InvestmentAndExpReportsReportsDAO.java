package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.InvestmentAndExpReportsReportsModel;

public class InvestmentAndExpReportsReportsDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public List<InvestmentAndExpReportsReportsModel> fetchInvestExpReports(InvestmentAndExpReportsReportsModel investexp) {
		// TODO Auto-generated method stub
		List<InvestmentAndExpReportsReportsModel> list=new ArrayList<InvestmentAndExpReportsReportsModel>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `invest_exp_id`,`quotation_name` FROM `investmt_exp_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpReportsReportsModel investExpReports=new InvestmentAndExpReportsReportsModel();
				investExpReports.setInvestExp_id(rs.getInt(1));
				investExpReports.setQuotation_name(rs.getString(2));
				list.add(investExpReports);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
