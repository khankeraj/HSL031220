package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.CityModel;
import com.master.model.CustomerMasterModel;
import com.master.model.DriverModel;
import com.master.model.RateMasterModel;


public class RateMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public List<RateMasterModel> fetchRateMasterDetails(RateMasterModel rate_modal) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
List<RateMasterModel> list=new ArrayList<RateMasterModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT * from rate_master ");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			RateMasterModel rateMasterModel=new RateMasterModel();
			rateMasterModel.setCustomer(rs.getString(1));
			rateMasterModel.setType(rs.getString(2));
			rateMasterModel.setRateid(rs.getInt(4));
			list.add(rateMasterModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

}
public List<RateMasterModel> fetchCityMasterDetails() {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
List<RateMasterModel> list=new ArrayList<RateMasterModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT * from vehicle_type_master ");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			RateMasterModel rateMasterModel=new RateMasterModel();
			rateMasterModel.setType(rs.getString("model"));
			
			list.add(rateMasterModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;


}







}
