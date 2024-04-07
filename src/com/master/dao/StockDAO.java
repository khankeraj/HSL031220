package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.StockModel;

public class StockDAO
{
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
	public List<StockModel> stock_report(List<StockModel> stockmodel){
		List<StockModel> list = new ArrayList<>();
		try {
			
			PreparedStatement pst = conn.prepareStatement("Select description, qty from stock_details");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				StockModel stock = new StockModel();
				stock.setDescription(rs.getString(1));
				stock.setQuantity(rs.getString(2));
				list.add(stock);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}