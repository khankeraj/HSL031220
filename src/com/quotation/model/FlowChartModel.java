package com.quotation.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;

public class FlowChartModel {
	private int flow_chart_id;
	private String name_of_index;
	private String image;
	
	private String quotation_name;
	
	public int getFlow_chart_id() {
		return flow_chart_id;
	}
	public void setFlow_chart_id(int flow_chart_id) {
		this.flow_chart_id = flow_chart_id;
	}
	public String getName_of_index() {
		return name_of_index;
	}
	public void setName_of_index(String name_of_index) {
		this.name_of_index = name_of_index;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<FlowChartModel> fetchFlowChartDetails(FlowChartModel flowChart) {
		// TODO Auto-generated method stub
		List<FlowChartModel> list=new ArrayList<>();
		DBConnection connection=new DBConnection();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `image` FROM `flow_chart`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FlowChartModel flowChart1=new FlowChartModel();
				flowChart1.setName_of_index(rs.getString(1));
				flowChart1.setImage(rs.getString(2));
				list.add(flowChart1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String getQuotation_name() {
		return quotation_name;
	}
	public void setQuotation_name(String quotation_name) {
		this.quotation_name = quotation_name;
	}
	public List<FlowChartModel> fetchForUpdate(FlowChartModel flowChart,String flowcharts_id) {
		// TODO Auto-generated method stub
		int flowchartsId=Integer.parseInt(flowcharts_id);
		List<FlowChartModel> list=new ArrayList<>();
		DBConnection connection=new DBConnection();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `flow_chart_id`, `name_of_index`, `image`, `quotation_name` FROM `flow_chart_config` WHERE flow_chart_id=?");
			pst.setInt(1, flowchartsId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FlowChartModel flowChart1=new FlowChartModel();
				flowChart1.setFlow_chart_id(rs.getInt(1));
				flowChart1.setName_of_index(rs.getString(2));
				flowChart1.setImage(rs.getString(3));
				flowChart1.setQuotation_name(rs.getString(4));
				list.add(flowChart1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateFlowCharts(FlowChartModel flowChart, String flowcharts_id) {
		// TODO Auto-generated method stub
		int updateFlowChartsId=Integer.parseInt(flowcharts_id);
		DBConnection connection=new DBConnection();
		int i=0;
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `flow_chart_config` SET `name_of_index`=?,`image`=?,`quotation_name`=? WHERE `flow_chart_id`=?");
			pst.setString(1, flowChart.getName_of_index());
			pst.setString(2, flowChart.getImage());
			pst.setString(3, flowChart.getQuotation_name());
			pst.setInt(4, updateFlowChartsId);
			
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int deleteFlowCharts(FlowChartModel flowChart, String flowcharts_id) {
		// TODO Auto-generated method stub
		int i=0;
		int updateFlowChartsId=Integer.parseInt(flowcharts_id);
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `flow_chart_config` WHERE flow_chart_id=?");
			pst.setInt(1, updateFlowChartsId);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}

}
