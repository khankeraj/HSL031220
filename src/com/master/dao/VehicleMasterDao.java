package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.master.model.ProductModel;
import com.master.model.VehicleModel;


public class VehicleMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public int insert_vehicle_Details(VehicleModel vehiclemodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from vehicle_master where vehicle_no = '"+vehiclemodel.getVehicle_no()+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return -1;
			}
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `vehicle_master` (`vehicle_no`,  `vehicle_type`, `model`, `size`, `capacity`, `driver`, `road_tax_photo`, `fitness_tax_photo`, `permit_tax_photo`, `puc_photo`, `servicing_photo`, `insurance_photo`, `driver_code`, `road_tax_date`, `fitness_tax_date`, `permit_tax_date`, `puc_date`, `servicing_date`, `insurance_date`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1,  vehiclemodel.getVehicle_no());
			pst.setString(2,  vehiclemodel.getVehicle_type());
			pst.setString(3,  vehiclemodel.getModel());
			pst.setString(4,  vehiclemodel.getSize());
			pst.setString(5,  vehiclemodel.getCapacity());
			
			String[] drv = vehiclemodel.getDriver().split("-");
			
			/*pst.setString(6,  vehiclemodel.getDriver());*/
			pst.setString(6,  drv[0]);
			pst.setString(7,  vehiclemodel.getRoad_tax_photo());
			pst.setString(8,  vehiclemodel.getFitness_tax_photo());
			pst.setString(9,  vehiclemodel.getPermit_tax_photo());
			pst.setString(10,  vehiclemodel.getPuc_photo());
			pst.setString(11,  vehiclemodel.getServicing_photo());
			pst.setString(12,  vehiclemodel.getInsurance_photo());
			pst.setString(13, drv[1]);
			pst.setString(14, vehiclemodel.getRoad_tax_date());
			pst.setString(15, vehiclemodel.getFitness_tax_date());
			pst.setString(16, vehiclemodel.getPermit_tax_date());
			pst.setString(17, vehiclemodel.getPuc_date());
			pst.setString(18, vehiclemodel.getServicing_date());
			pst.setString(19, vehiclemodel.getInsurance_date());
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public List<VehicleModel> fetchVehicleMasterDetails() {
		// TODO Auto-generated method stub
		List<VehicleModel> list=new ArrayList<VehicleModel>();
		
		try {
				PreparedStatement pst=conn.prepareStatement("SELECT `id`, `vehicle_no`, `vehicle_type`, `model`, `size`, `capacity`, `driver`, `road_tax_photo`, `fitness_tax_photo`, `permit_tax_photo`, `puc_photo`, `servicing_photo`, `insurance_photo` FROM `vehicle_master`");
				ResultSet rs=pst.executeQuery();
				System.out.println("1...."+pst);
				while(rs.next())
				{
					VehicleModel vehicleModel=new VehicleModel();
					
					vehicleModel.setV_id(String.valueOf(rs.getInt(1)));
					vehicleModel.setVehicle_no(rs.getString(2));
					vehicleModel.setVehicle_type(rs.getString(3));
					vehicleModel.setModel(rs.getString(4));
					vehicleModel.setSize(rs.getString(5));
					vehicleModel.setCapacity(rs.getString(6));
					vehicleModel.setDriver(rs.getString(7));
					vehicleModel.setRoad_tax_photo(rs.getString(8));
					vehicleModel.setFitness_tax_photo(rs.getString(9));
					vehicleModel.setPermit_tax_photo(rs.getString(10));
					vehicleModel.setPuc_photo(rs.getString(11));
					vehicleModel.setServicing_photo(rs.getString(12));
					vehicleModel.setInsurance_photo(rs.getString(13));
					
					list.add(vehicleModel);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<VehicleModel> fetchForUpdateVehicleDetailss(VehicleModel vehicle_model, String vehicle_id) {
		// TODO Auto-generated method stub
		List<VehicleModel> list=new ArrayList<VehicleModel>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `vehicle_no`, `vehicle_type`, `model`, `size`, `capacity`, `driver`, `road_tax_photo`, `fitness_tax_photo`, `permit_tax_photo`, `puc_photo`, `servicing_photo`, `insurance_photo`, `road_tax_date`, `fitness_tax_date`, `permit_tax_date`, `puc_date`, `servicing_date`, `insurance_date` FROM `vehicle_master` WHERE id='"+vehicle_id+"'");
			ResultSet rs=pst.executeQuery();
			System.out.println("pst ---- "+pst);
			while(rs.next())
			{
				VehicleModel vehicleModel=new VehicleModel();
				vehicleModel.setV_id(rs.getString(1));
				vehicleModel.setVehicle_no(rs.getString(2));
				vehicleModel.setVehicle_type(rs.getString(3));
				vehicleModel.setModel(rs.getString(4));
				vehicleModel.setSize(rs.getString(5));
				vehicleModel.setCapacity(rs.getString(6));
				vehicleModel.setDriver(rs.getString(7));
				vehicleModel.setRoad_tax_photo(rs.getString(8));
				vehicleModel.setFitness_tax_photo(rs.getString(9));
				vehicleModel.setPermit_tax_photo(rs.getString(10));
				vehicleModel.setPuc_photo(rs.getString(11));
				vehicleModel.setServicing_photo(rs.getString(12));
				vehicleModel.setInsurance_photo(rs.getString(13));
				vehicleModel.setRoad_tax_date(rs.getString(14));
				vehicleModel.setFitness_tax_date(rs.getString(15));
				vehicleModel.setPermit_tax_date(rs.getString(16));
				vehicleModel.setPuc_date(rs.getString(17));
				vehicleModel.setServicing_date(rs.getString(18));
				vehicleModel.setInsurance_date(rs.getString(19));
				
				list.add(vehicleModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	public int deleteVehicle_master(String delete_vehicle_id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `vehicle_master` WHERE id="+delete_vehicle_id+"");
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public int update_vehicle_details(VehicleModel vehiclemodel, String update_vehicle) {
		// TODO Auto-generated method stub
		int i=0;
		int vehicle_id=Integer.parseInt(update_vehicle);
		
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `vehicle_master` SET `vehicle_no`=?, `vehicle_type`=?, `model`=?, `size`=?, `capacity`=?, `driver`=?, `road_tax_photo`=?, `fitness_tax_photo`=?, `permit_tax_photo`=?, `puc_photo`=?, `servicing_photo`=?, `insurance_photo`=?, `road_tax_date`=?, `fitness_tax_date`=?, `permit_tax_date`=?, `puc_date`=?, `servicing_date`=?, `insurance_date`=? WHERE `id`=?");
			
			pst.setString(1, vehiclemodel.getVehicle_no());
			pst.setString(2, vehiclemodel.getVehicle_type());
			pst.setString(3, vehiclemodel.getModel());
			pst.setString(4, vehiclemodel.getSize());
			pst.setString(5, vehiclemodel.getCapacity());
			pst.setString(6, vehiclemodel.getDriver());
			pst.setString(7, vehiclemodel.getRoad_tax_photo());
			pst.setString(8, vehiclemodel.getFitness_tax_photo());
			pst.setString(9, vehiclemodel.getPermit_tax_photo());
			pst.setString(10, vehiclemodel.getPuc_photo());
			pst.setString(11, vehiclemodel.getServicing_photo());
			pst.setString(12, vehiclemodel.getInsurance_photo());
			pst.setString(13, vehiclemodel.getRoad_tax_date());
			pst.setString(14, vehiclemodel.getFitness_tax_date());
			pst.setString(15, vehiclemodel.getPermit_tax_date());
			pst.setString(16, vehiclemodel.getPuc_date());
			pst.setString(17, vehiclemodel.getServicing_date());
			pst.setString(18, vehiclemodel.getInsurance_date());
			
			pst.setInt(19, vehicle_id);
			
			
			i=pst.executeUpdate();
			System.out.println(pst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public List<VehicleModel> fetchVehicleAlertDetails() {
		// TODO Auto-generated method stub
		List<VehicleModel> list = new ArrayList<>();
		
		
		try {
			
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			System.out.println("currentTime: "+currentTime);
			/*PreparedStatement pst = conn.prepareStatement("select * from vehicle_master where road_tax_date<='"+currentTime+"' or fitness_tax_date<='"+currentTime+"'");*/
			
			PreparedStatement pst1 = conn.prepareStatement("select vehicle_no, DATEDIFF("+"'"+currentTime+"'"+",road_tax_date), DATEDIFF("+"'"+currentTime+"'"+",fitness_tax_date), DATEDIFF("+"'"+currentTime+"'"+",permit_tax_date), DATEDIFF("+"'"+currentTime+"'"+",puc_date), DATEDIFF("+"'"+currentTime+"'"+",servicing_date), DATEDIFF("+"'"+currentTime+"'"+",insurance_date), road_tax_date, fitness_tax_date, permit_tax_date, puc_date, servicing_date, insurance_date   from vehicle_master where DATEDIFF("+"'"+currentTime+"'"+",road_tax_date)>=-30 or DATEDIFF("+"'"+currentTime+"'"+",fitness_tax_date)>=-30 or DATEDIFF("+"'"+currentTime+"'"+",permit_tax_date)>=-30 or DATEDIFF("+"'"+currentTime+"'"+",puc_date)>=-30 or DATEDIFF("+"'"+currentTime+"'"+",servicing_date)>=-30 or DATEDIFF("+"'"+currentTime+"'"+",insurance_date)>=-30" );
			
			ResultSet rs1 = pst1.executeQuery();
			
			System.out.println("pst1: "+pst1);
			while(rs1.next())
			{
				if(Integer.parseInt(rs1.getString(2))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("Road tax alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("road_tax_date"));
					list.add(model);
				}
				
				if(Integer.parseInt(rs1.getString(3))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("Fitness tax alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("fitness_tax_date"));
					list.add(model);
				}
				
				if(Integer.parseInt(rs1.getString(4))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("Permit tax alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("permit_tax_date"));
					list.add(model);
				}
				
				if(Integer.parseInt(rs1.getString(5))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("PUC alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("puc_date"));
					list.add(model);
				}
				
				if(Integer.parseInt(rs1.getString(6))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("Servicing alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("servicing_date"));
					list.add(model);
				}
				
				if(Integer.parseInt(rs1.getString(7))>=-30) {
					VehicleModel model = new VehicleModel();
					model.setAlert("Insurance alert");
					model.setVehicle_no(rs1.getString(1));
					model.setDate(rs1.getString("insurance_date"));
					list.add(model);
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
}
