package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.FlowChartsReportsModel;

public class FlowChartsReportsDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public List<FlowChartsReportsModel> fetchFlowchartsReports(List<FlowChartsReportsModel> flowcharts) {
		// TODO Auto-generated method stub
		List<FlowChartsReportsModel> list=new ArrayList<FlowChartsReportsModel>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `flow_chart_id`,`quotation_name` FROM `flow_chart_config`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FlowChartsReportsModel flow=new FlowChartsReportsModel();
				flow.setFlowchart_id(rs.getInt(1));
				flow.setQuotation_name(rs.getString(2));
				list.add(flow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	

}
