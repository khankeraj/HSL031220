package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.QuotationNameModel;

public class QuotationNameDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	int i=0;
	public int saveQuotationName(QuotationNameModel quotationNameModel) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `quotation_name_master`(`quotation_name`) VALUES (?)");
			pst.setString(1, quotationNameModel.getQuotation_name());
			i=pst.executeUpdate();
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public List<QuotationNameModel> fetchQuotationNameReports(QuotationNameModel quotationNameModel) {
		// TODO Auto-generated method stub
		List<QuotationNameModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `quotation_id`, `quotation_name` FROM `quotation_name_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationNameModel quotationname=new QuotationNameModel();
				quotationname.setQuotation_id(rs.getInt(1));
				quotationname.setQuotation_name(rs.getString(2));
				list.add(quotationname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
