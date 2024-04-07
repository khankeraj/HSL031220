package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.TermsConditionsReportsModel;

public class TermsConditionsReportsDAO {
	
	DBConnection connection=new DBConnection();

	public List<TermsConditionsReportsModel> fetchTermsConditionsDetails(TermsConditionsReportsModel termsConditions) {
		// TODO Auto-generated method stub
		List<TermsConditionsReportsModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `terms_cond_id`,`quotation_name` FROM `terms_conditions_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsConditionsReportsModel termsConditions1=new TermsConditionsReportsModel();
				termsConditions1.setTerms_conditions_id(rs.getInt(1));
				termsConditions1.setQuotation_name(rs.getString(2));
				list.add(termsConditions1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
