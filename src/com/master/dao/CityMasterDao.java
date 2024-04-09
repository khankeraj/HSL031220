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


public class CityMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
public int insert_city_Details(CityModel citymodel) {
	
	System.out.println(citymodel.getState_name()+"pppppppppppppp");
		// TODO Auto-generated method stub
		int i=0;
		try {
			System.out.println(citymodel.getState_name()+"jjjjjjjjjjjjj");			
			PreparedStatement psac = conn.prepareStatement("select * from city_master where city_name = '"+citymodel.getCity_name()+"'");
			ResultSet rsac = psac.executeQuery();
			
			if(rsac.next())
			{
				return -1;
			}
			
			PreparedStatement pst = conn.prepareStatement("insert into `city_master` (`city_name`,  `state_name`) values(?,?)");
			
			
			System.out.println(citymodel.getCity_name()+"rrrrrrrrrrrrrrrr");
			System.out.println(citymodel.getState_name()+"pppppppppppppp");
			pst.setString(1, citymodel.getCity_name());
			pst.setString(2, citymodel.getState_name());
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}



public List<CityModel> fetchCityMasterDetails(CityModel city_model) {
	// TODO Auto-generated method stub
	List<CityModel> list=new ArrayList<CityModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `city_name`, `state_name` FROM `city_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				CityModel cityModel=new CityModel();
				
				cityModel.setCity_id(rs.getString(1));
				cityModel.setCity_name(rs.getString(2));
				cityModel.setState_name(rs.getString(3));
				list.add(cityModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}




public List<CityModel> fetchRouteMasterDetails(CityModel city_modal) {
	// TODO Auto-generated method stub
List<CityModel> list=new ArrayList<CityModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `route`, `id` FROM `route_master`");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				CityModel cityModel=new CityModel();
				
				cityModel.setRoute(rs.getString(1));
				cityModel.setRoute_id(rs.getString(2));
				list.add(cityModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}




public List<CityModel> fetchResourceMasterDetails(CityModel city_modal) {
	// TODO Auto-generated method stub
List<CityModel> list=new ArrayList<CityModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `route`, `id` FROM `resource_master`");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				CityModel cityModel=new CityModel();
				
				cityModel.setRoute(rs.getString(1));
				cityModel.setRoute_id(rs.getString(2));
				list.add(cityModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}


public List<CityModel> fetchForUpdateCityDetailss(CityModel city_modal, String city_id) {
	// TODO Auto-generated method stub
	List<CityModel> list=new ArrayList<CityModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `city_name`, `state_name` from city_master WHERE id='"+city_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			CityModel cityModel=new CityModel();
			cityModel.setCity_id(rs.getString(1));
			cityModel.setCity_name(rs.getString(2));
			cityModel.setState_name(rs.getString(3));
			list.add(cityModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}


public int deleteCity_master(CityModel city_modal, String delete_city_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `city_master` WHERE id="+delete_city_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}



public List<CityModel> fetchForUpdateRouteDetailss(CityModel city_modal, String route_id) {
	// TODO Auto-generated method stub
List<CityModel> list=new ArrayList<CityModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `route` from route_master WHERE id='"+route_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			CityModel cityModel=new CityModel();
			cityModel.setRoute_id(rs.getString(1));
			cityModel.setRoute(rs.getString(2));
			
			list.add(cityModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}



public int deleteRoute_master(CityModel city_modal, String delete_route_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `route_master` WHERE id="+delete_route_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}



public int update_city_details(CityModel city_modal, String update_city) {
	// TODO Auto-generated method stub
	int i=0;
	int city_id=Integer.parseInt(update_city);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `city_master` SET `city_name`=?,`state_name`=? WHERE `id`=?");
		
		pst.setString(1, city_modal.getCity_name());
		pst.setString(2, city_modal.getState_name());
		pst.setInt(3, city_id);
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}


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
			rateMasterModel.setPurchaserate(rs.getString(3));
			rateMasterModel.setSalerate(rs.getString(4));
			list.add(rateMasterModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

}







}
