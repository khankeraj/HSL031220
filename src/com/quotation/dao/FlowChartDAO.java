package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.quotation.model.FlowChartModel;

public class FlowChartDAO {

	DBConnection connection=new DBConnection();
	
	public int insert_flowChart_details(FlowChartModel flowChart) {
		// TODO Auto-generated method stub
	int i=0;
	
	try {
		Connection conn=connection.getConnection();
		
		PreparedStatement pst=conn.prepareStatement("INSERT INTO `flow_chart_config`(`name_of_index`, `image`, `quotation_name`) VALUES (?,?,?)");
		pst.setString(1, flowChart.getName_of_index());
		pst.setString(2, flowChart.getImage());
		pst.setString(3, flowChart.getQuotation_name());
		
		i=pst.executeUpdate();
		
		if(i>0)
		{
			System.out.println("inserted...!!!");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		return i;
	}

}
