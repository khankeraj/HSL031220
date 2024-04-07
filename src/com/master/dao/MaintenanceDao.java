package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.MaintenanceModel;
//import com.master.model.TripModel;


public class MaintenanceDao{

	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
public String insertMaintenanceDetails(MaintenanceModel maintenanceModel) {
			
			String response = "";
			// TODO Auto-generated method stub
			String stringValue2 = "";
			String stringValue3 = "";
			
			int len1 = 0;
			try {
			PreparedStatement preparedStatement3 = conn
					.prepareStatement("select  max(SUBSTRING(maintenance_id,-4)) as myval1 from maintenance");
			
			
			String mystr2 = "";
			int myval2 = 0;
			ResultSet resultSet2 = preparedStatement3.executeQuery();
			
			if (resultSet2.next()) {
				try {
					mystr2 = resultSet2.getString("myval1");
					myval2 = Integer.parseInt(mystr2);
					myval2 = myval2 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval2 = 1;
					mystr2 = "";
				}
			}
			
			
			int size2 = len1 + 1;
			stringValue3 = String.valueOf(myval2);
			
				if (stringValue3.length() == 1) {
					stringValue3 = "MNT/" + "000" + stringValue3;
				} else if (stringValue3.length() == 2) {
					stringValue3 = "MNT/" + "00" + stringValue3;
				} else if (stringValue3.length() == 3) {
					stringValue3 = "MNT/" + "0" + stringValue3;
				} else {
					stringValue3 = "MNT/" + stringValue3;
				}
				maintenanceModel.setMaintenance_id(stringValue3);
			
		
			
				String stringValue5 = "";
				int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from vehiclecreditdebit");
				
				
				String mystr3 = "";
				int myval3 = 0;
				ResultSet resultSet3 = preparedStatement4.executeQuery();
				
				if (resultSet3.next()) {
					try {
						mystr3 = resultSet3.getString("myval1");
						myval3 = Integer.parseInt(mystr3);
						myval3 = myval3 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval3 = 1;
						mystr3 = "";
					}
				}
				
				
				
				
				int size3 = len2 + 1;
				stringValue5 = String.valueOf(myval3);
				
					if (stringValue5.length() == 1) {
						stringValue5 = "BILL/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "BILL/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "BILL/" + "0" + stringValue5;
					} else {
						stringValue5 = "BILL/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					maintenanceModel.setBill_no(stringValue5);;	
				
				
				
				
				
				
				
				
				
				
			
			
			
			
			
			
			PreparedStatement pst2 = conn.prepareStatement("insert into maintenance(maintenance_id, vehicle_no, servicing_company, km, total_amount, date) values(?,?,?,?,?,?)");
			pst2.setString(1, maintenanceModel.getMaintenance_id());
			pst2.setString(2, maintenanceModel.getVehicle_no());
			pst2.setString(3, maintenanceModel.getServicing_company());
			pst2.setString(4, maintenanceModel.getKm());
			pst2.setString(5, maintenanceModel.getTotal_amount());
			pst2.setString(6, maintenanceModel.getDate());
			
			/*pst2.setString(4, tripModel.getCustomer_name());*/
			int c2 =pst2.executeUpdate();
			
			
			
			PreparedStatement pst3 = conn.prepareStatement("insert into vehiclecreditdebit(Vehicle_no, date, Amount, Name, Documentsno, Typecode, type, billno, remark) values(?,?,?,?,?,?,?,?,?)");
			pst3.setString(1, maintenanceModel.getVehicle_no());
			pst3.setString(2, maintenanceModel.getDate());
			pst3.setString(3, maintenanceModel.getTotal_amount());
			pst3.setString(4, "");
			pst3.setString(5, maintenanceModel.getMaintenance_id());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, maintenanceModel.getBill_no());
			pst3.setString(9, "Maintenance");
			//pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();
			
			
			
			
			
			
			
			
			System.out.println("pst2 .... "+pst2);
			PreparedStatement pstd = conn.prepareStatement("insert into maintenance_details(maintenance_id, description, amount) values(?, ?, ?)");
			
			int k = 0;
			
			try {
				for (int l = 0; l < maintenanceModel.getDescription().length; l++) {
					
					if ((maintenanceModel.getDescription()[l] != "")) {
						
						pstd.setString(1, maintenanceModel.getMaintenance_id());
						pstd.setString(2, maintenanceModel.getDescription()[l]);
						pstd.setString(3, maintenanceModel.getAmount()[l]);
			
//						pst2.setString(6, bean.getUsername());
//						pst2.setString(7, SystemDateTime.CurrentDateTime());
						
						k = pstd.executeUpdate();
						
					}
				}
				System.out.println("size k = "+k);
				
				response = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return response;
		}


public List<MaintenanceModel> fetchMaintenanceDetails(String vehicle_no) {
	// TODO Auto-generated method stub
	
	List<MaintenanceModel> list = new ArrayList<>();
	try {
		PreparedStatement pst = conn.prepareStatement("select * from maintenance where vehicle_no = '"+vehicle_no+"'");
		ResultSet rs = pst.executeQuery();
		
		System.out.println("pst  --- "+pst);
		
		while(rs.next())
		{
			MaintenanceModel model = new MaintenanceModel();
			model.setMaintenance_id(rs.getString("maintenance_id"));
			model.setVehicle_no(rs.getString("vehicle_no"));
			model.setDate(rs.getString("date"));
			model.setServicing_company(rs.getString("servicing_company"));
			model.setKm(rs.getString("km"));
			model.setTotal_amount(rs.getString("total_amount"));
			
			PreparedStatement pst1 = conn.prepareStatement("select description, amount from maintenance_details where maintenance_id='"+model.getMaintenance_id()+"'");
			ResultSet rs1 = pst1.executeQuery();
			//System.out.println("pst  --- "+pst1);
			//int i =0;
			ArrayList<String> des  = new ArrayList<>();
			ArrayList<String> amount  = new ArrayList<>();
			while(rs1.next())
			{
				des.add(rs1.getString(1));
				amount.add(rs1.getString(2));
				
			}
			
			/*String[] desc = des.toArray(new String[des.size()]);
			String[] amt = amount.toArray(new String[amount.size()]);*/
			String[] desc = new String[des.size()];
			String[] amt = new String[amount.size()];
			
			for (int i = 0; i < des.size(); i++) {
				desc[i] = des.get(i);
				amt[i] = amount.get(i);
			}
			
			
			model.setDescription(desc);
			model.setAmount(amt);

			/*for(String s : desc)
			{
				//System.out.println("desc - - - "+s);
			}*/
			
			list.add(model);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}
}