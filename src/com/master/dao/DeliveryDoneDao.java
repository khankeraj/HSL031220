package com.master.dao;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
//import com.aqua.dao.DaoHelper;
import com.master.model.DeliveryModel;
import com.master.model.MaintenanceModel;
//import com.master.model.TripModel;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;


public class DeliveryDoneDao{

	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
	public List<DeliveryModel> fetchDeliveryDoneDetails(String trip_id, String source, String destination,
			String vehicle_no, String driver_name, String updown_id, String updown, String customer_name,
			String lr_number, userinfo bean, String inquiry_id) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		try {
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("select * from lr_details where LR_no = '"+lr_number+"'");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst "+pst);
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				model.setDescription1(rs.getString("description"));
				model.setWeight1(rs.getString("weight"));
				model.setRate1(rs.getString("rate"));
				model.setAmount1(rs.getString("amount"));
				
				list.add(model);
			}
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}


	public String insertDeliveryDoneDetails(DeliveryModel deliverymodel, userinfo bean) {
		// TODO Auto-generated method stub
		
		String response = "";
		// TODO Auto-generated method stub
		String stringValue2 = "";
		String stringValue3 = "";
		
		int len1 = 0;
		
		try {
		
			
			PreparedStatement preparedStatement3 = conn
				.prepareStatement("select  max(SUBSTRING(delivery_done_id,-4)) as myval1 from delivery_done");
		
		
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
				stringValue3 = "HSL/DEL/" + "000" + stringValue3;
			} else if (stringValue3.length() == 2) {
				stringValue3 = "HSL/DEL/" + "00" + stringValue3;
			} else if (stringValue3.length() == 3) {
				stringValue3 = "HSL/DEL/" + "0" + stringValue3;
			} else {
				stringValue3 = "HSL/DEL/" + stringValue3;
			}
			deliverymodel.setDelivery_done_id(stringValue3);
			
			
			
		
			PreparedStatement pst2 = conn.prepareStatement("insert into delivery_done(delivery_done_id ,trip_id, updown_id, LR_no, Customer_name, date, source, destination, vehicle_no, driver_name, total_amount, customer_no, driver_code, loading, unloading, other, mathadi, updown, commission_done_status,status,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst2.setString(1, deliverymodel.getDelivery_done_id());
			pst2.setString(2, deliverymodel.getTrip_id());
			pst2.setString(3, deliverymodel.getUpdown_id());
			pst2.setString(4, deliverymodel.getLr_number());
			pst2.setString(5, deliverymodel.getCustomer_name());
			pst2.setString(6, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
			pst2.setString(7, deliverymodel.getSource());
			pst2.setString(8, deliverymodel.getDestination());
			pst2.setString(9, deliverymodel.getVehicle_no());
			pst2.setString(10, deliverymodel.getDriver_name());
			pst2.setString(11, deliverymodel.getTotal_amount());
			
			
			
			PreparedStatement pst3 = conn.prepareStatement("select customer_no, driver_code from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
			String customer_no = "";
			String driver_code = "";
			System.out.println("pst3   --- "+pst3);
			ResultSet rs = pst3.executeQuery();
			
			if(rs.next())
			{
				customer_no = rs.getString("customer_no");
				driver_code = rs.getString("driver_code");
			}
			
			pst2.setString(12, customer_no);
			pst2.setString(13, driver_code);
			pst2.setString(14, deliverymodel.getLoading());
			pst2.setString(15, deliverymodel.getUnloading());
			pst2.setString(16, deliverymodel.getOther());
			pst2.setString(17, deliverymodel.getMathadi());
			pst2.setString(18, deliverymodel.getUpdown());
			
			
			
			PreparedStatement pst02 = conn.prepareStatement("select commission_done_status from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
			ResultSet rs02 = pst02.executeQuery();
			if(rs02.next())
			{
				if(rs02.getString(1)!=null)
					pst2.setString(19, rs02.getString(1));
				else
					pst2.setString(19, null);
			}
			
			pst2.setString(20,"0");
			pst2.setString(21,bean.getUsername());
			pst2.setString(22,SystemDateTime.CurrentDateTime());
			
			
			int eu = pst2.executeUpdate();
			
			
			response = "success";
			
			//System.out.println("eu : "+eu);
			
			PreparedStatement pst4 = conn.prepareStatement("update lr set delivery_done_status='1',status='1' where LR_no = '"+deliverymodel.getLr_number()+"'");
			int st = pst4.executeUpdate();
			//System.out.println("st  = "+st);
			
			int te1=0;
			if(!deliverymodel.getLoading().equals("") &&  !deliverymodel.getLoading().equals("0"))
			{
				PreparedStatement pste1 = conn.prepareStatement("insert into trip_issue(LR_no, vehicle_no, driver_name, date, exp_parti, exp_amount) values(?, ?, ?, ?, ?, ?)");
				pste1.setString(1, deliverymodel.getLr_number());
				pste1.setString(2, deliverymodel.getVehicle_no());
				pste1.setString(3, deliverymodel.getDriver_name());
				pste1.setString(4, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
				pste1.setString(5, "loading");
				pste1.setString(6, deliverymodel.getLoading());
				
				te1 = pste1.executeUpdate();
				pste1.close();
				
				response = "success";
			}
			
			if(!deliverymodel.getUnloading().equals("") &&  !deliverymodel.getUnloading().equals("0"))
			{
				PreparedStatement pste1 = conn.prepareStatement("insert into trip_issue(LR_no, vehicle_no, driver_name, date, exp_parti, exp_amount) values(?, ?, ?, ?, ?, ?)");
				pste1.setString(1, deliverymodel.getLr_number());
				pste1.setString(2, deliverymodel.getVehicle_no());
				pste1.setString(3, deliverymodel.getDriver_name());
				pste1.setString(4, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
				pste1.setString(5, "unloading");
				pste1.setString(6, deliverymodel.getUnloading());
				
				te1 = pste1.executeUpdate();
				pste1.close();
				
				response = "success";
				
			}
			
			if(!deliverymodel.getOther().equals("") &&  !deliverymodel.getOther().equals("0"))
			{
				PreparedStatement pste1 = conn.prepareStatement("insert into trip_issue(LR_no, vehicle_no, driver_name, date, exp_parti, exp_amount) values(?, ?, ?, ?, ?, ?)");
				pste1.setString(1, deliverymodel.getLr_number());
				pste1.setString(2, deliverymodel.getVehicle_no());
				pste1.setString(3, deliverymodel.getDriver_name());
				pste1.setString(4, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
				pste1.setString(5, "other");
				pste1.setString(6, deliverymodel.getOther());
				
				te1 = pste1.executeUpdate();
				pste1.close();
				
				response = "success";
				
			}
			
			if(!deliverymodel.getMathadi().equals("") &&  !deliverymodel.getMathadi().equals("0"))
			{
				PreparedStatement pste1 = conn.prepareStatement("insert into trip_issue(LR_no, vehicle_no, driver_name, date, exp_parti, exp_amount) values(?, ?, ?, ?, ?, ?)");
				pste1.setString(1, deliverymodel.getLr_number());
				pste1.setString(2, deliverymodel.getVehicle_no());
				pste1.setString(3, deliverymodel.getDriver_name());
				pste1.setString(4, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
				pste1.setString(5, "mathadi");
				pste1.setString(6, deliverymodel.getMathadi());
				
				te1 = pste1.executeUpdate();
				pste1.close();
				
				response = "success";
				
			}
			
			PreparedStatement pstd = conn.prepareStatement("insert into delivery_done_details(delivery_done_id, description, weight, received_weight, short_weight, rate, amount) values(?, ?, ?, ?, ?, ?, ?)");
			
			int k = 0;
			
			try {
				for (int l = 0; l < deliverymodel.getDescription().length; l++) {
					
					if ((deliverymodel.getDescription()[l] != "")) {
						
						pstd.setString(1, deliverymodel.getDelivery_done_id());
						pstd.setString(2, deliverymodel.getDescription()[l]);
						pstd.setString(3, deliverymodel.getWeight()[l]);
						pstd.setString(4, deliverymodel.getReceived_weight()[l]);
						pstd.setString(5, deliverymodel.getShort_weight()[l]);
						pstd.setString(6, deliverymodel.getRate()[l]);
						pstd.setString(7, deliverymodel.getAmount()[l]);
			
//						pst2.setString(6, bean.getUsername());
//						pst2.setString(7, SystemDateTime.CurrentDateTime());
						
						k = pstd.executeUpdate();
						
						response = "success";
						
					}
				}
				//System.out.println("size k = "+k);
				
				response = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			////////// Update Inquiry Status ////////////////////////////
			
			
			try {
				
				String inquiry="";
				
				PreparedStatement pp = conn.prepareStatement("select inquiry_id from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
				
				ResultSet rp = pp.executeQuery();
				
				if(rp.next())
				{
					
					 inquiry=rp.getString("inquiry_id");
				}
				
				
				PreparedStatement pst41 = conn.prepareStatement("update inquiry_status set delivery_username='"+bean.getUsername()+"',delivery_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id = '"+inquiry+"'");
				
				int st1 = pst41.executeUpdate();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return response;
	}

	
	
	
	

	public List<DeliveryModel> fetchShortDetails(String from_date, String to_date, String customer_name2, String driver_name2) {
		// TODO Auto-generated method stub
		String cond="";
		String cust_code= "";
		String drv_code= "";
		
		if(!customer_name2.equals(""))
		{
			String[] cust = customer_name2.split("-");
			cust_code = cust[1];
		}
		
		if(!driver_name2.equals(""))
		{
			String[] drv = driver_name2.split("-");
			drv_code = drv[1];
		}
		
		
		if(!cust_code.equals("")){
			cond= "  and customer_no like '%"+cust_code+"%' ";
			
		}
		
		if(!drv_code.equals("")){
			cond= "  and driver_code like '%"+drv_code+"%' ";
			
		}
		
		/*if(!tripModel.getExp_parti().equals("")){
			cond= "  and exp_parti like '%"+tripModel.getExp_parti()+"%' ";
			
		}
		
		if(!tripModel.getVehicle_no().equals("")){
			cond= "  and vehicle_no like '%"+tripModel.getVehicle_no()+"%' ";
			
		}*/
		
		
		
		
		
		
		
		
		
		
		
		List<DeliveryModel> list = new ArrayList<>();
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from delivery_done_details where short_weight>0");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				model.setDelivery_done_id(rs.getString("delivery_done_id"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done where delivery_done_id = '"+model.getDelivery_done_id()+"' "+cond+" and date between '"+from_date+"' and '"+to_date+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				System.out.println("pst1: "+pst1);
				
				String lr_number = "";
				String source = "";
				String destination = "";
				String customer_name = "";
				String vehicle_no = "";
				String driver_name = "";
				
				if(rs1.next())
				{
					lr_number = rs1.getString("LR_no");
					source = rs1.getString("source");
					destination = rs1.getString("destination");
					customer_name = rs1.getString("customer_name");
					vehicle_no = rs1.getString("vehicle_no");
					driver_name = rs1.getString("driver_name");
					
					
					model.setLr_number(lr_number);
					model.setSource(source);
					model.setDestination(destination);
					model.setCustomer_name(customer_name);
					model.setVehicle_no(vehicle_no);
					model.setDriver_name(driver_name);
					
					model.setDescription1(rs.getString("description"));
					model.setShort_weight1(rs.getString("short_weight"));
					model.setRate1(rs.getString("rate"));
					
					
					
					System.out.println("Lr number: "+model.getLr_number()+" source: "+model.getSource());
					
					double short_amount = Double.parseDouble(model.getShort_weight1()) * Double.parseDouble(model.getRate1());
					
					
					model.setShort_amount(String.valueOf(short_amount));
					
					list.add(model);
					
					
				}
				
				
				
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}


	public List<DeliveryModel> fetchDeliveryDoneDetails() {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from delivery_done1 where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				
				model.setDelivery_done_id(rs.getString("delivery_id"));
				
				
				
				model.setLr_number(rs.getString("LR_no"));
				model.setSource(rs.getString("source"));
				model.setDestination(rs.getString("destination"));
				model.setVehicle_no(rs.getString("vehicle_no"));
				model.setDriver_name(rs.getString("driver_name"));
				model.setCustomer_name(rs.getString("Customer_name"));
				model.setCustomer_no(rs.getString("customer_no"));
				model.setTotal_amount(rs.getString("total_amount"));
				model.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				model.setTransporter_name(rs.getString("transporter_name"));
				model.setPrint_file(rs.getString("photus"));
				model.setInquiry_id(rs.getString("inquiry_id"));
				
				
							
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}

	
	
	
	
	
	
	public List<DeliveryModel> fetchPIDoneDetails() {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from PI_done1 where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				
				model.setDelivery_done_id(rs.getString("delivery_id"));
				
				
				
				model.setLr_number(rs.getString("LR_no"));
				model.setSource(rs.getString("source"));
				model.setDestination(rs.getString("destination"));
				model.setVehicle_no(rs.getString("vehicle_no"));
				model.setDriver_name(rs.getString("driver_name"));
				model.setCustomer_name(rs.getString("Customer_name"));
				model.setCustomer_no(rs.getString("customer_no"));
				model.setTotal_amount(rs.getString("total_amount"));
				model.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				model.setTransporter_name(rs.getString("transporter_name"));
				model.setPrint_file(rs.getString("photus"));
				model.setInquiry_id(rs.getString("inquiry_id"));
				
				
							
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
	
	

	public String insertCommissionDetails(DeliveryModel deliverymodel) {
		// TODO Auto-generated method stub
		String response="";
		
			String stringValue2 = "";
			String stringValue3 = "";
			
			String stringValue4 = "";
			String stringValue5 = "";
			
			
			int len1 = 0;
			try {
			PreparedStatement preparedStatement3 = conn
					.prepareStatement("select  max(SUBSTRING(commission_id,-4)) as myval1 from commission");
			
			
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
					stringValue3 = "HSL/COMM/" + "000" + stringValue3;
				} else if (stringValue3.length() == 2) {
					stringValue3 = "HSL/COMM/" + "00" + stringValue3;
				} else if (stringValue3.length() == 3) {
					stringValue3 = "HSL/COMM/" + "0" + stringValue3;
				} else {
					stringValue3 = "HSL/COMM/" + stringValue3;
				}
				deliverymodel.setCommision_id(stringValue3);	
			
			
			
			
				int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from transportercreditdebit");
				
				
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
						stringValue5 = "HSL/BILLNO/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "HSL/BILLNO/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "HSL/BILLNO/" + "0" + stringValue5;
					} else {
						stringValue5 = "HSL/BILLNO/" + stringValue5;
					}
					deliverymodel.setBill_no(stringValue5);	
				
				
				
				
				
				
		
				
				
				
				
		String date = "";		
			
		PreparedStatement pstd = conn.prepareStatement("select date from delivery_done where LR_no = '"+deliverymodel.getLr_number()+"'");
		ResultSet rs1 = pstd.executeQuery();
		if(rs1.next())
		{
			date = rs1.getString(1);
		}
			
			
			
		PreparedStatement pst2 = conn.prepareStatement("insert into commission(trip_id, updown_id, LR_no, source, destination, vehicle_no, driver_name, commission_amount, transporter_name, commission_id, remaining_amount, transporter_code, date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pst2.setString(1, deliverymodel.getTrip_id());
		pst2.setString(2, deliverymodel.getUpdown_id());
		pst2.setString(3, deliverymodel.getLr_number());
		pst2.setString(4, deliverymodel.getSource());
		pst2.setString(5, deliverymodel.getDestination());
		pst2.setString(6, deliverymodel.getVehicle_no());
		pst2.setString(7, deliverymodel.getDriver_name());
		pst2.setString(8, deliverymodel.getCommision());
		pst2.setString(9, deliverymodel.getTransporter_name());
		pst2.setString(10, deliverymodel.getCommision_id());
		pst2.setString(11, deliverymodel.getCommision());
		
		String trans_code = "";
		PreparedStatement pst33 = conn.prepareStatement("select transporter_code from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
		ResultSet rs33 = pst33.executeQuery();
		if(rs33.next())
		{
			trans_code = rs33.getString(1);
		}
		
		deliverymodel.setTransporter_code(trans_code);
		
		pst2.setString(12, trans_code);
		pst2.setString(13, date);
		
		int c1 = pst2.executeUpdate();
		
		System.out.println("c1 : "+c1);
		
		PreparedStatement pst3 = conn.prepareStatement("insert into transportercreditdebit(Customercode, date, trip_id, updown_id, LR_no, source, destination,  Amount, Name, Documentsno, Typecode, type, billno, transporter_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		
		String customercode = "";
		
		
		
		
		PreparedStatement pstc = conn.prepareStatement("select customer_no from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
		ResultSet rs2 = pstc.executeQuery();
		if(rs2.next())
		{
			customercode = rs2.getString(1);
		}
		
		
		
		pst3.setString(1, customercode);
		pst3.setString(2, date);
		pst3.setString(3, deliverymodel.getTrip_id());
		pst3.setString(4, deliverymodel.getUpdown_id());
		pst3.setString(5, deliverymodel.getLr_number());
		pst3.setString(6, deliverymodel.getSource());
		pst3.setString(7, deliverymodel.getDestination());
		
		pst3.setString(8, deliverymodel.getCommision());
		pst3.setString(9, deliverymodel.getTransporter_name());
		pst3.setString(10, deliverymodel.getCommision_id());
		pst3.setString(11, "101");
		pst3.setString(12, "Credit");
		pst3.setString(13, deliverymodel.getBill_no());
		pst3.setString(14, deliverymodel.getTransporter_code());
		int c2 = pst3.executeUpdate();
		
		
		System.out.println("c2 :"+c2);
		
		
		PreparedStatement pst4 = conn.prepareStatement("update delivery_done set commission_done_status='1' where LR_no = '"+deliverymodel.getLr_number()+"'");
		int c3 = pst4.executeUpdate();
		
		
		PreparedStatement pst04 = conn.prepareStatement("update lr set commission_done_status='1' where LR_no = '"+deliverymodel.getLr_number()+"'");
		int c03 = pst04.executeUpdate();
		
		
		System.out.println("c3: "+c3);
		
		
		if(c2>0)
		{
			response= "success";
		}
		else
		{
			response= "fail";
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return response;
		
	}

	
	public String insertCommissionDetails1(DeliveryModel deliverymodel, String transporter_name) {
		// TODO Auto-generated method stub
			String response="";
		
			
			
			String stringValue4 = "";
			String stringValue5 = "";
			
			try {
			int len2 = 0;
			PreparedStatement preparedStatement4 = conn
					.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from transportercreditdebit");
			
			
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
					stringValue5 = "HSL/BILLNO/" + "000" + stringValue5;
				} else if (stringValue5.length() == 2) {
					stringValue5 = "HSL/BILLNO/" + "00" + stringValue5;
				} else if (stringValue5.length() == 3) {
					stringValue5 = "HSL/BILLNO/" + "0" + stringValue5;
				} else {
					stringValue5 = "HSL/BILLNO/" + stringValue5;
				}
				deliverymodel.setBill_no(stringValue5);	
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			for(int i=0; i<deliverymodel.getLr_number1().length; i++)
			{
				
					
				String stringValue2 = "";
				String stringValue3 = "";
				
				int len1 = 0;
				try {
				PreparedStatement preparedStatement3 = conn
						.prepareStatement("select  max(SUBSTRING(commission_id,-4)) as myval1 from commission");
				
				
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
						stringValue3 = "HSL/COMM/" + "000" + stringValue3;
					} else if (stringValue3.length() == 2) {
						stringValue3 = "HSL/COMM/" + "00" + stringValue3;
					} else if (stringValue3.length() == 3) {
						stringValue3 = "HSL/COMM/" + "0" + stringValue3;
					} else {
						stringValue3 = "HSL/COMM/" + stringValue3;
					}
					deliverymodel.setCommision_id(stringValue3);	
				
				
				
				
					
					
					
					
					
					
					
					
					
			String date = "";		
			PreparedStatement pstd = conn.prepareStatement("select date from delivery_done where LR_no = '"+deliverymodel.getLr_number1()[i]+"'");
			ResultSet rs1 = pstd.executeQuery();
			if(rs1.next())
			{
				date = rs1.getString(1);
			}		
					
					
				
				
				
				
				
			PreparedStatement pst2 = conn.prepareStatement("insert into commission(trip_id, updown_id, LR_no, source, destination, vehicle_no, driver_name, commission_amount, transporter_name, commission_id, remaining_amount, transporter_code, date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst2.setString(1, deliverymodel.getTrip_id1()[i]);
			pst2.setString(2, deliverymodel.getUpdown_id1()[i]);
			pst2.setString(3, deliverymodel.getLr_number1()[i]);
			pst2.setString(4, deliverymodel.getSource1()[i]);
			pst2.setString(5, deliverymodel.getDestination1()[i]);
			pst2.setString(6, deliverymodel.getVehicle_no1()[i]);
			pst2.setString(7, deliverymodel.getDriver_name1()[i]);
			pst2.setString(8, deliverymodel.getCommision1()[i]);
			pst2.setString(9, transporter_name);
			pst2.setString(10, deliverymodel.getCommision_id());
			pst2.setString(11, deliverymodel.getCommision1()[i]);
			
			String trans_code = "";
			PreparedStatement pst33 = conn.prepareStatement("select transporter_code from lr where LR_no = '"+deliverymodel.getLr_number1()[i]+"'");
			ResultSet rs33 = pst33.executeQuery();
			if(rs33.next())
			{
				trans_code = rs33.getString(1);
			}
			
			deliverymodel.setTransporter_code(trans_code);
			
			pst2.setString(12, trans_code);
			
			
			
			int c1 = pst2.executeUpdate();
			
			System.out.println("c1 : "+c1);
			
			PreparedStatement pst3 = conn.prepareStatement("insert into transportercreditdebit(Customercode, date, trip_id, updown_id, LR_no, source, destination,  Amount, Name, Documentsno, Typecode, type, billno, transporter_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			String customercode = "";
			
			
			
			
			PreparedStatement pstc = conn.prepareStatement("select customer_no from lr where LR_no = '"+deliverymodel.getLr_number1()[i]+"'");
			ResultSet rs2 = pstc.executeQuery();
			if(rs2.next())
			{
				customercode = rs2.getString(1);
			}
			
			
			
			pst3.setString(1, customercode);
			pst3.setString(2, date);
			pst3.setString(3, deliverymodel.getTrip_id1()[i]);
			pst3.setString(4, deliverymodel.getUpdown_id1()[i]);
			pst3.setString(5, deliverymodel.getLr_number1()[i]);
			pst3.setString(6, deliverymodel.getSource1()[i]);
			pst3.setString(7, deliverymodel.getDestination1()[i]);
			
			pst3.setString(8, deliverymodel.getCommision1()[i]);
			pst3.setString(9, transporter_name);
			pst3.setString(10, deliverymodel.getCommision_id());
			pst3.setString(11, "101");
			pst3.setString(12, "Debit");
			pst3.setString(13, deliverymodel.getBill_no());
			pst3.setString(14, deliverymodel.getTransporter_code());
			int c2 = pst3.executeUpdate();
			
			
			System.out.println("c2 :"+c2);
			
			
			PreparedStatement pst4 = conn.prepareStatement("update delivery_done set commission_done_status='1' where LR_no = '"+deliverymodel.getLr_number1()[i]+"'");
			int c3 = pst4.executeUpdate();
			
			
			PreparedStatement pst04 = conn.prepareStatement("update lr set commission_done_status='1' where LR_no = '"+deliverymodel.getLr_number1()[i]+"'");
			int c03 = pst04.executeUpdate();
			
			
			
			System.out.println("c3: "+c3);
			
			
			if(c2>0)
			{
				response= "success";
			}
			else
			{
				response= "fail";
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
		
	return response;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<DeliveryModel> fetchForMultiCommision(String str) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		String string = str.substring(0, str.length()-1);
		System.out.println(string);
		
		String[] lr_nos = string.split("~");
		
		
		try {
			
			for(int i=0; i<lr_nos.length; i++)
			{
				PreparedStatement pst = conn.prepareStatement("select * from lr where LR_no = '"+lr_nos[i]+"'");
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
					
					DeliveryModel model = new DeliveryModel();
					
					model.setTrip_id(rs.getString("trip_id"));
					model.setUpdown_id(rs.getString("updown_id"));
					model.setLr_number(rs.getString("LR_no"));
					model.setSource(rs.getString("source"));
					model.setDestination(rs.getString("destination"));
					model.setVehicle_no(rs.getString("vehicle_no"));
					model.setDriver_name(rs.getString("driver_name"));
					
					
					PreparedStatement pstt = conn.prepareStatement("select transporter_name from lr where LR_no = '"+model.getLr_number()+"'");
					ResultSet rst = pstt.executeQuery();
					
					String transport_name = "";
					if(rst.next())
					{
						transport_name = rst.getString(1);
					}
					
					model.setTransporter_name(transport_name);
					
					
					/*PreparedStatement pstc = conn.prepareStatement("select commission_amount from commission where LR_no = '"+model.getLr_number()+"'");
					ResultSet rsc = pstc.executeQuery();
					
					String commission = "";
					if(rsc.next())
					{
						commission = rsc.getString(1);
					}
					
					model.setCommision(commission);
					
					
					
					PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done_details where delivery_done_id='"+model.getDelivery_done_id()+"'");
					ResultSet rs1 = pst1.executeQuery();
					
					double sum = 0;
					
					while(rs1.next())
					{
						double short_weight = Double.parseDouble(rs1.getString("short_weight"));
						double rate = Double.parseDouble(rs1.getString("rate"));
						
						sum = sum + (short_weight*rate);
					}
					
					model.setPenalty_amount(String.valueOf(sum));*/
					
					list.add(model);
			}
			
			
			
			
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}


	public List<DeliveryModel> fetchForInvoice(String lr_number) {
		// TODO Auto-generated method stub
		
		List<DeliveryModel> list = new ArrayList<>();
		try {
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_number+"'");
		
		ResultSet rs = pst.executeQuery();
		System.out.println("pst : "+pst);
		
		String delivery_done_id = "";
		
		if(rs.next())
		{
			delivery_done_id = rs.getString("delivery_done_id");
			
			PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done_details where delivery_done_id = '"+delivery_done_id+"'");
			
			ResultSet rs1 = pst1.executeQuery();
			System.out.println("pst1 : "+pst1);
			while(rs1.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setCustomer_no(rs.getString("customer_no"));
				
				
				PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
				ResultSet rst = ptcd.executeQuery();
				System.out.println("ptcd : "+ptcd);
				
				
				String gst = "";
				String pan = "";
				String state = "";
				String city = "";
				String mobile = "";
				String pending_amount = "";
				String address = "";
				
				if(rst.next())
				{
					gst = rst.getString("customer_gst_no");
					pan = rst.getString("pan_no");
					state = rst.getString("state");
					city = rst.getString("city");
					mobile = rst.getString("mobile_no");
					address = rst.getString("customer_address");
					
					PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number+"'");
					ResultSet rstb = pstb.executeQuery();
					System.out.println("pstb : "+pstb);
					
					if(rstb.next())
					{
						pending_amount = rstb.getString(1);
					}
					
					model.setGstin_no(gst);
					model.setPan_no(pan);
					model.setState(state);
					model.setCity(city);
					model.setMobile(mobile);
					model.setPending_amount(pending_amount);
					model.setAddress(address);
				}
				
				
				model.setDescription1(rs1.getString("description"));
				model.setWeight1(rs1.getString("weight"));
				model.setReceived_weight1(rs1.getString("received_weight"));
				model.setShort_weight1(rs1.getString("short_weight"));
				model.setRate1(rs1.getString("rate"));
				model.setAmount1(rs1.getString("amount"));
				
				PreparedStatement psttt = conn.prepareStatement("select hsn_code, tax_per from product_master where product_name = '"+model.getDescription1()+"'");
				ResultSet rsttt = psttt.executeQuery();
				System.out.println("psttt : "+psttt);
				
				String hsn = "";
				String tax_rate = "";
				String tax_rate1 = "";
				String tax_rate2 = "";
				
				double tax = 0;
				double tax_amt = 0;
				
				
				
				if(rsttt.next())
				{
					hsn = rsttt.getString(1);
					tax_rate = rsttt.getString(2);
				}
				
				
				tax = Double.parseDouble(tax_rate)/2;
				tax_amt = (Double.parseDouble(model.getAmount1()) * tax)/100;
				
				
				model.setHsn1(hsn);
				model.setGstrate1(String.valueOf(tax));
				model.setGstrate2(String.valueOf(tax));
				
				model.setGstamt1(String.valueOf(tax_amt));
				model.setGstamt2(String.valueOf(tax_amt));
				
				
					
				
				double short_penalty = Double.parseDouble(model.getShort_weight1()) * Double.parseDouble(model.getRate1());
				model.setPenalty_amount(String.valueOf(short_penalty));
				
				/*double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1()) + short_penalty;*/
				double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1());
				model.setNet_amt1(String.valueOf(net_amt));
				
				list.add(model);
				
			}
		}
		
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	
	
	public List<DeliveryModel> invoiceFormwoTax(String lr_number) {
		// TODO Auto-generated method stub
		
		List<DeliveryModel> list = new ArrayList<>();
		try {
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_number+"'");
		
		ResultSet rs = pst.executeQuery();
		System.out.println("pst : "+pst);
		
		String delivery_done_id = "";
		
		if(rs.next())
		{
			delivery_done_id = rs.getString("delivery_done_id");
			
			PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done_details where delivery_done_id = '"+delivery_done_id+"'");
			
			ResultSet rs1 = pst1.executeQuery();
			System.out.println("pst1 : "+pst1);
			while(rs1.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setCustomer_no(rs.getString("customer_no"));
				
				
				PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
				ResultSet rst = ptcd.executeQuery();
				System.out.println("ptcd : "+ptcd);
				
				
				String gst = "";
				String pan = "";
				String state = "";
				String city = "";
				String mobile = "";
				String pending_amount = "";
				String address = "";
				
				if(rst.next())
				{
					gst = rst.getString("customer_gst_no");
					pan = rst.getString("pan_no");
					state = rst.getString("state");
					city = rst.getString("city");
					mobile = rst.getString("mobile_no");
					address = rst.getString("customer_address");
					
					PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number+"'");
					ResultSet rstb = pstb.executeQuery();
					System.out.println("pstb : "+pstb);
					
					if(rstb.next())
					{
						pending_amount = rstb.getString(1);
					}
					
					model.setGstin_no(gst);
					model.setPan_no(pan);
					model.setState(state);
					model.setCity(city);
					model.setMobile(mobile);
					model.setPending_amount(pending_amount);
					model.setAddress(address);
				}
				
				
				model.setDescription1(rs1.getString("description"));
				model.setWeight1(rs1.getString("weight"));
				model.setReceived_weight1(rs1.getString("received_weight"));
				model.setShort_weight1(rs1.getString("short_weight"));
				model.setRate1(rs1.getString("rate"));
				model.setAmount1(rs1.getString("amount"));
				
				/*PreparedStatement psttt = conn.prepareStatement("select hsn_code, tax_per from product_master where product_name = '"+model.getDescription1()+"'");
				ResultSet rsttt = psttt.executeQuery();
				System.out.println("psttt : "+psttt);
				
				String hsn = "";
				String tax_rate = "";
				String tax_rate1 = "";
				String tax_rate2 = "";
				
				double tax = 0;
				double tax_amt = 0;
				
				
				
				if(rsttt.next())
				{
					hsn = rsttt.getString(1);
					tax_rate = rsttt.getString(2);
				}
				
				
				tax = Double.parseDouble(tax_rate)/2;
				tax_amt = (Double.parseDouble(model.getAmount1()) * tax)/100;
				
				
				model.setHsn1(hsn);
				model.setGstrate1(String.valueOf(tax));
				model.setGstrate2(String.valueOf(tax));
				
				model.setGstamt1(String.valueOf(tax_amt));
				model.setGstamt2(String.valueOf(tax_amt));
				
				
					
				
				double short_penalty = Double.parseDouble(model.getShort_weight1()) * Double.parseDouble(model.getRate1());
				model.setPenalty_amount(String.valueOf(short_penalty));
				
				double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1()) + short_penalty;
				double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1());
				model.setNet_amt1(String.valueOf(net_amt));*/
				
				list.add(model);
				
			}
		}
		
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<DeliveryModel> fetchForInvoiceIgst(String lr_number) {
		// TODO Auto-generated method stub
		
		List<DeliveryModel> list = new ArrayList<>();
		try {
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_number+"'");
		
		ResultSet rs = pst.executeQuery();
		System.out.println("pst : "+pst);
		
		String delivery_done_id = "";
		
		if(rs.next())
		{
			delivery_done_id = rs.getString("delivery_done_id");
			
			PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done_details where delivery_done_id = '"+delivery_done_id+"'");
			
			ResultSet rs1 = pst1.executeQuery();
			System.out.println("pst1 : "+pst1);
			while(rs1.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setCustomer_no(rs.getString("customer_no"));
				
				
				PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
				ResultSet rst = ptcd.executeQuery();
				System.out.println("ptcd : "+ptcd);
				
				
				String gst = "";
				String pan = "";
				String state = "";
				String city = "";
				String mobile = "";
				String pending_amount = "";
				String address = "";
				
				if(rst.next())
				{
					gst = rst.getString("customer_gst_no");
					pan = rst.getString("pan_no");
					state = rst.getString("state");
					city = rst.getString("city");
					mobile = rst.getString("mobile_no");
					address = rst.getString("customer_address");
					
					PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number+"'");
					ResultSet rstb = pstb.executeQuery();
					System.out.println("pstb : "+pstb);
					
					if(rstb.next())
					{
						pending_amount = rstb.getString(1);
					}
					
					model.setGstin_no(gst);
					model.setPan_no(pan);
					model.setState(state);
					model.setCity(city);
					model.setMobile(mobile);
					model.setPending_amount(pending_amount);
					model.setAddress(address);
				}
				
				
				model.setDescription1(rs1.getString("description"));
				model.setWeight1(rs1.getString("weight"));
				model.setReceived_weight1(rs1.getString("received_weight"));
				model.setShort_weight1(rs1.getString("short_weight"));
				model.setRate1(rs1.getString("rate"));
				model.setAmount1(rs1.getString("amount"));
				
				PreparedStatement psttt = conn.prepareStatement("select hsn_code, tax_per from product_master where product_name = '"+model.getDescription1()+"'");
				ResultSet rsttt = psttt.executeQuery();
				System.out.println("psttt : "+psttt);
				
				String hsn = "";
				String tax_rate = "";
				String tax_rate1 = "";
				String tax_rate2 = "";
				
				double tax = 0;
				double tax_amt = 0;
				
				
				
				if(rsttt.next())
				{
					hsn = rsttt.getString(1);
					
					tax_rate = rsttt.getString(2);
				}
				
				
				tax = Double.parseDouble(tax_rate);
				
				tax_amt = (Double.parseDouble(model.getAmount1()) * tax)/100;
				
				
				model.setHsn1(hsn);
				
				model.setGstrate1(String.valueOf(tax));
				
				//model.setGstrate2(String.valueOf(tax));
				
				model.setGstamt1(String.valueOf(tax_amt));
				
				//model.setGstamt2(String.valueOf(tax_amt));
				
				
					
				
				double short_penalty = Double.parseDouble(model.getShort_weight1()) * Double.parseDouble(model.getRate1());
				
				model.setPenalty_amount(String.valueOf(short_penalty));
				
				/*double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1()) + short_penalty;*/
				
				double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getAmount1());
				
				model.setNet_amt1(String.valueOf(net_amt));
				
				list.add(model);
				
			}
		}
		
		
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	

	public String insertInvoiceInfo(DeliveryModel deliverymodel, String lr_number) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("2");
		String response = "";
		DBConnection connection=new DBConnection();
		int flag1 = 0;
		Connection con = connection.getConnection();
		
		//PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
		//System.out.println("preparedStatement112"+preparedStatement112);
				//ResultSet resultSet12z = preparedStatement112z.executeQuery();
				System.out.println("3");
				try {
					//if (resultSet12z.next()) {
		System.out.println("4");
	  //if(resultSet12z.getString("po").equals("yes")){			
		  System.out.println("5");
		
			
				try {
				int result = -1;
				 Date date=new Date();
					if (date != null) {
				       Calendar cal = Calendar.getInstance();
				       cal.setTime(date);
				       result = cal.get(Calendar.MONTH)+1;
				   }
					 int result1 = -1;
				        if (date != null) {
				            Calendar cal = Calendar.getInstance();
				            cal.setTime(date);
				            result1 = cal.get(Calendar.YEAR);
				        }
				        String year = "";
				        String yy="";
				        String yy1="";
				        yy=""+result1;
				        
				        yy1=yy.substring(2,4);
				        
				       int pp=0;
				        pp=Integer.parseInt(yy1);
				        
				        if (result <= 3) {
				        year=""+(result1 - 1);
				        }else{
				        	
				        	  year=""+result1;
				        	
				        }
				        String Fyear ="";
				        if (result <= 3) {
				        	Fyear=  (result1 - 1) + "-" + pp;
				        } else {
				        	
				        	Fyear=  result1 + "-" + (pp + 1);
				          
				        }
				        
				        
				        String FMONTH = ""+result;
				    




				        String pref = "HSL/GST/";

						PreparedStatement pst9 = null;
						PreparedStatement pst99 = null;

						// String pref="INV";
						PreparedStatement preparedStatement11 = con
								.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
						preparedStatement11.setString(1, "" + "%" + pref+Fyear + "%");

						String mystr1 = "";
						int myval1 = 0;
						int w = 0;
						String stringValue1 = "1";
					
						ResultSet resultSet11 = preparedStatement11.executeQuery();
						if (resultSet11.next()) {
							try {
								mystr1 = resultSet11.getString("myval1");
								myval1 = Integer.parseInt(mystr1);
								myval1 = myval1 + 1;
							} catch (Exception e) {
								
								myval1 = 1;
								mystr1 = "";
							}
						}

						if (mystr1.equals("")) {
							stringValue1 = pref+ Fyear + "/0000" + stringValue1;

						} else {

							if (String.valueOf(myval1).length() == 1) {
								stringValue1 = pref+  Fyear + "/0000" + String.valueOf(myval1);

							} else if (String.valueOf(myval1).length() == 2) {
								stringValue1 =pref+  Fyear + "/000" + String.valueOf(myval1);
							} else if (String.valueOf(myval1).length() == 3) {
								stringValue1 = pref+  Fyear + "/00" + String.valueOf(myval1);
							} else if (String.valueOf(myval1).length() == 4) { 
								stringValue1 = pref+  Fyear + "/0" + String.valueOf(myval1);
							}
							else {
								stringValue1 = pref+  Fyear + "/" + String.valueOf(myval1);
							}
						}

				deliverymodel.setInvoiceno(stringValue1);
				System.out.println("6 "+stringValue1);
				/*String q1 = "insert into invoice_tax_details(invoice_no,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pst41 = con.prepareStatement(q1);
				
				pst41.setString(1, deliverymodel.getInvoiceno());
				pst41.setString(2, deliverymodel.getDescription()[mx]);
				pst41.setString(3, deliverymodel.getWeight()[mx]);
				pst41.setString(4, deliverymodel.getAmount()[mx]);
				
				double vat_percent = Double.parseDouble(deliverymodel.getGst_rate1()[mx]) + Double.parseDouble(deliverymodel.getGst_rate2()[mx]); 
				pst41.setString(5, String.valueOf(vat_percent));
				pst41.setString(6, String.valueOf(vat_percent));
				pst41.setString(7, deliverymodel.getNet_amt()[mx]);
				pst41.setString(8, deliverymodel.getHsn()[mx]);*/
				
				
				String query = "";
				PreparedStatement preparedStatement = con
						.prepareStatement("select * from invoice where  invoice_no=?");
				String inv = deliverymodel.getInvoiceno();
				String inv1 = " " + inv;
				System.out.println(preparedStatement);
				preparedStatement.setString(1, inv1.trim());

				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {/*
					System.out.println("7");
					response = "Already";
					
					PreparedStatement pst1 = con.prepareStatement(
							"select * from customer_payment_details where invoiceno='"+inv1.trim()+"'");
					System.out.println("pst........." + pst1);
					ResultSet rs1 = pst1.executeQuery();
					if (rs1.next()) {
						System.out.println("8");
						
					}else{
						System.out.println("9");
						query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,LR_no=?,LR_date=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

						inv1=deliverymodel.getInvoiceno();
						deliverymodel.setInvoiceno(inv1);
						Date d1 = new Date();
						String da = "" + d1;
						
						
						pst9 = con.prepareStatement(query);
						pst9.setString(1, deliverymodel.getCustomer_no());
						pst9.setString(2, deliverymodel.getDate());
						pst9.setString(3, deliverymodel.getInvoiceno());
						pst9.setString(25, inv1);
						pst9.setString(4, deliverymodel.getTotal_amount1());
						pst9.setString(5, deliverymodel.getLr_number());
						
						PreparedStatement pstttt = con.prepareStatement("select date from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
						ResultSet rsttt = pstttt.executeQuery();
						String d3 = "";
						if(rsttt.next())
						{
							d3 = rsttt.getString(1);
						}
						
						pst9.setString(6, d3);
						pst9.setString(7, "");
						pst9.setString(8, "");
						pst9.setString(9, "");
						pst9.setString(10, "");
						
						pst9.setString(11,"");
						pst9.setString(12, "");
						pst9.setString(13, "");
						pst9.setString(14, "");
						pst9.setString(15, "");
						pst9.setString(16, "");
						pst9.setString(17, "");
						pst9.setString(18, "");
						pst9.setString(19, "");
						pst9.setString(20, "");
						pst9.setString(21, deliverymodel.getGst_rate1amt()[mx]);
						pst9.setString(22, deliverymodel.getGst_rate2amt()[mx]);
						
						double tta = Double.parseDouble(deliverymodel.getGst_rate1amt()[mx]) + Double.parseDouble(deliverymodel.getGst_rate2amt()[mx]);
						pst9.setString(23,String.valueOf(tta));
						pst9.setString(24, "");
						pst9.setString(25, deliverymodel.getInvoiceno());
						
						int k = 0;
						k = pst9.executeUpdate();
					}
					

				
					response = "success";
				
					System.out.println("10");
					
					String qd = "delete  from invoice_tax_details where invoice_no=?";
					String inv2 = deliverymodel.getInvoiceno();
					 String inv21 = " " + inv2;
					PreparedStatement pstdel = con.prepareStatement(qd);
					pstdel.setString(1, inv21.trim());

					int n1 = pstdel.executeUpdate();

					int i = 0;
					int l1 = 0;
					String q1 = "insert into invoice_tax_details(invoice_no, type, descrip, qty, amt, vat_percent, tax_amt_percent, net_amt, type_name, cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pst41 = con.prepareStatement(q1);
					System.out.println("11");
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {

						if (!deliverymodel.getDescription()[j1].trim().equals("") && !deliverymodel.getDescription()[j1].trim().equals(null)) {
							
							pst41.setString(1, inv21.trim());
							

							String btype = "";

							try {
								btype = ib.getBtype()[j1];
							} catch (Exception e) {
								
								btype = "";
							}
							pst41.setString(2, "");

							// pst41.setString(2,"labour");

							pst41.setString(3, deliverymodel.getDescription()[j1]);

							Double amount = 0.0;
							double vatpercent = 0.0;
							double taxamount = 0.0;
							double netamount = 0.0;

							String amountlist = deliverymodel.getAmount()[j1];
							
							double tx1 = Double.parseDouble(deliverymodel.getGst_rate1()[j1]) + Double.parseDouble(deliverymodel.getGst_rate1()[j1]);
							//123
							
							String vatpercentlist = String.valueOf(tx1);

							String taxamountlist = "";

							// String qty=ib.getQuantity1()[j1];
							// Integer Quantity1=0;
							String netamountlist = deliverymodel.getNet_amt()[j1];

							Double Quantity1 = 0.0;
							try {
								String qty = deliverymodel.getWeight()[j1];
							
								Quantity1 = Double.parseDouble(qty);
								;
							} catch (Exception e) {
								
								Quantity1 = 0.0;
							}

						
							pst41.setDouble(4, Quantity1);
							

							try {
								amount = Double.parseDouble(amountlist);
							} catch (Exception e) {
								
								amount = 0.0;
							}

							try {
								vatpercent = Double.parseDouble(vatpercentlist);
							} catch (Exception e) {
								
								vatpercent = 0;
							}

							try {
								taxamount = Double.parseDouble(taxamountlist);
							} catch (Exception e) {
								
								taxamount = 0;
							}
							try {
								netamount = Double.parseDouble(netamountlist);
							} catch (Exception e) {
								
								netamount = 0;
							}

							
							pst41.setDouble(5, amount);
							pst41.setDouble(6, vatpercent);

							pst41.setDouble(7, taxamount);
							pst41.setDouble(8, netamount);
							String ttype = "";

							try {
								ttype = deliverymodel.getHsn()[j1];
							} catch (Exception e) {
								
								ttype = "";
							}
							pst41.setString(9, ttype);
							
							pst41.setString(10, deliverymodel.getGst_rate1()[j1]);
							pst41.setString(11, deliverymodel.getGst_rate1amt()[j1]);
							pst41.setString(12, deliverymodel.getGst_rate2()[j1]);
							pst41.setString(13, deliverymodel.getGst_rate2amt()[j1]);
							pst41.setString(14, deliverymodel.getRate()[j1]);
							pst41.setString(15, "");
							pst41.setString(16, "");
							pst41.setString(17, "");
							pst41.setString(18, "");
							pst41.setString(19, "");
							pst41.setString(20, "");
							pst41.setString(21, "");
							i = i++;
							String sn = "" + i;

							deliverymodel.setSn(sn);

							l1 = pst41.executeUpdate();

						}
						
						System.out.println("12");
						String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
						 inv2 = deliverymodel.getInvoiceno();
						 inv21 = " " + inv2;
						PreparedStatement pstdel1 = con.prepareStatement(qd1);
						pstdel1.setString(1, inv21.trim());

						int n12 = pstdel1.executeUpdate();
					
								PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
								System.out.println("preparedStatement112"+preparedStatement112zz);
							ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

							while (resultSet12zz.next()) {
								
							query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
							PreparedStatement pst41z = con.prepareStatement(query);
							
							pst41z.setString(1, inv21.trim());	
							pst41z.setString(2, resultSet12zz.getString("type_name"));	
							pst41z.setString(3, resultSet12zz.getString("cgstrate"));	
							pst41z.setString(4, resultSet12zz.getString("sgstrate"));	
							pst41z.setString(5, resultSet12zz.getString("cgstamount"));	
							pst41z.setString(6, resultSet12zz.getString("sgstamount"));	
							pst41z.setString(7, resultSet12zz.getString("vat_percent"));	
							pst41z.setString(8, resultSet12zz.getString("taxablevalue"));	
							System.out.println(pst41z);
							pst41z.executeUpdate();
							}
							
						
						if (l1 > 0 && n1 > 0) {
							response = "success";
						} else {
							response = "fail";

						}

					}

					// --------------

					// update taxcollection details

					String qdtc = "delete  from invoice_tax_collection where invoice_no=?";
					String inv23 = deliverymodel.getInvoiceno();
					String inv231 = " " + inv23;
					PreparedStatement pstdeltc = con.prepareStatement(qdtc);
					pstdeltc.setString(1, inv231.trim());

					int ntc = pstdeltc.executeUpdate();
					System.out.println("13");
					 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";
					 
					 int js = 0;
					 
					 pst41 = con.prepareStatement(q1);
					for (int j1 = 0; j1 < 3; j1++) {
						
						if(j1==0)
						{
							pst41.setString(1, inv231.trim());
							pst41.setString(2, "CGST");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getCgst()));
							pst41.setString(5, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						if(j1==1)
						{
							pst41.setString(1, inv231.trim());
							pst41.setString(2, "SGST");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getSgst()));
							pst41.setString(5, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						if(j1==2)
						{
							pst41.setString(1, inv231.trim());
							pst41.setString(2, "Total Tax Amount");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getTotal_tax_amount()));
							pst41.setString(5, CoreData.getDateFormatAsDb(deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						
						
						
						
						String type = "";
						String taxableamount = "";
						String tax = deliverymodel.[j1];

						double taxableamount1 = 0.0;
						double tax1 = 0.0;
						// double netamount =0.0;
						try {
							type = ib.getT()[j1];
						} catch (Exception e) {
							
							type = "";
						}

						pst41.setString(2, type);

						try {
							taxableamount1 = Double.parseDouble(taxableamount);
						} catch (Exception e) {
							
							taxableamount1 = 0.0;
						}

						pst41.setDouble(3, taxableamount1);

						try {
							tax1 = Double.parseDouble(tax);
						} catch (Exception e) {
							
							tax1 = 0.0;
						}

						pst41.setDouble(4, tax1);

						

						pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

						
						
						
						
						
						
						
						
						query = "UPDATE   customercreditdebit  set Amount=? where Documentsno=?";
						
						System.out.println("14");
						
						inv1=deliverymodel.getInvoiceno();
						deliverymodel.setInvoiceno(inv1);
						Date d1 = new Date();
						String da = "" + d1;
					
						pst9 = con.prepareStatement(query);
						pst9.setString(1, deliverymodel.getTotal_amount1());
						pst9.setString(2, inv1);
						
							int k = 0;	
							k = pst9.executeUpdate();

						

						if (js > 0 && ntc > 0) {
							response = "success";
						} else {
							response = "fail";

						}
					}
						// pst41.setString(2,"labour");

					*/}

					try{
						
						DBConnection connection1=new DBConnection();
						Connection con1 = connection1.getConnection();
							
						
					}catch(Exception e){
						e.printStackTrace();
					}

				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			

/*				else {*/
			
					PreparedStatement pstcn = con.prepareStatement("select customer_no from lr where LR_no = '"+lr_number+"'");
					ResultSet rs55 = pstcn.executeQuery();
					
					if(rs55.next())
					{
						deliverymodel.setCustomer_no(rs55.getString(1));
					}
					
					PreparedStatement pst9 = null;
					
					System.out.println("15");
					System.out.println("LR no:"+lr_number);
					String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,LR_no,LR_date,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,LR_num,status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
					pst9=con.prepareStatement(query1);
					pst9.setString(40, lr_number);
					
					
					
					
					pst9.setString(1, deliverymodel.getCustomer_no());
					pst9.setString(10,deliverymodel.getInvoiceno());
					pst9.setString(14, deliverymodel.getInvoiceno());
					pst9.setString(19, lr_number);
					
					PreparedStatement pstlr = con.prepareStatement("select date from lr where LR_no = '"+lr_number+"'");
					ResultSet rslr = pstlr.executeQuery();
					
					String d3 = "";
					if(rslr.next())
					{
						d3 = rslr.getString(1);
					}
					
					pst9.setString(20, (d3));
					pst9.setString(21, "");
					pst9.setString(22, "");
					pst9.setString(23, "");
					pst9.setString(24, "");
					
					pst9.setString(25, "");
					pst9.setString(26, "");
					pst9.setString(27, "");
					pst9.setString(28, "");
					pst9.setString(29, "");
					pst9.setString(30, "");
					pst9.setString(31, "");
					pst9.setString(32, "");
					pst9.setString(33, "");
					pst9.setString(34, "");
					pst9.setString(35, "sgst");
					pst9.setString(36, ""+deliverymodel.getTotal_amount1());
					pst9.setString(37, ""+deliverymodel.getCgst());
					pst9.setString(38, ""+deliverymodel.getSgst());
					pst9.setString(39, ""+deliverymodel.getTotal_tax_amount());
					
					PreparedStatement rslr55 = con.prepareStatement("select advance, balance from lr where LR_no = '"+lr_number+"'");
					ResultSet rslr5 = rslr55.executeQuery();
					String paid_amt="";
					String balance_amt="";
					if(rslr5.next())
					{
						paid_amt = rslr5.getString(1);
						balance_amt = rslr5.getString(2);
					}
					
					
					/*paid_amt=ib.getPaid_amt();
					balance_amt=ib.getBalance_amt();*/
					
					
					try{
					// x = Integer.valueOf(paid_amt);
					}catch (Exception e) {
						
						//x=0;
					}
					try{
					 //Y = Integer.valueOf(balance_amt);
					}catch (Exception e) {
						
						//Y=0;
					}
					//Integer  pp=Integer.parseInt(paid_amt);
					//Integer  bb=Integer.parseInt(balance_amt);
					
					// CASH
/*					if(ib.getPaymod().equalsIgnoreCase("CASH"))
					{
					pst9.setString(3, "CASH");
					
					String paid_amt1="";

					paid_amt1=ib.getNet_amount();
					
					
					try{
						 x = Integer.valueOf(paid_amt1);
						}catch (Exception e) {
							
							x=0;
						}
					
							
					pst9.setString(4, paid_amt1);
					pst9.setString(5, ""+0);
					
					pst9.setString(7,"");
					pst9.setInt(8,0);
					pst9.setString(9,"");
					
					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6,java.sql.Types.DATE);
					pst9.setString(11,""+ x);
					pst9.setString(12,""+ 0);
					pst9.setString(13, ""+0);
					pst9.setString(15, ""+ib.getTamount());
					pst9.setString(18, "0");
					pst9.setString(16, "");
					
					pst9.setString(17,"");
					
					 k=pst9.executeUpdate();
					 
					 PreparedStatement pst=con.prepareStatement("UPDATE `sales_agreement_master` SET `status`=2 WHERE `lead_no`='"+lead_no+"'");
					int i=pst.executeUpdate();
					
					 System.out.println("query of pst9:"+pst9+"K:"+k);
					 
					}
					
					// CHEQUE
					else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
					{
						
						
						pst9.setString(3, "CHEQUE");
						Integer l=0;
						String paid_amt2="";
						String chek_amt="";
					
						paid_amt2=ib.getCash_amt();
						
					
						chek_amt=ib.getCheque_amt();
						Integer c=0;
						try{
							 l = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								l=0;
							}
							pst9.setString(4, ""+l);
							pst9.setString(5, ""+0);
							
							pst9.setString(7,ib.getCheque_no());
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString=ib.getCheque_date();
							Date dNo = new Date();
							dNo = ft.parse(dateInString);
							Date dNow = new Date();
						
						
							try{
							pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
							}catch (Exception e) {
								
								pst9.setString(2,null);
							}
							
						
							try{
							pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
							}catch (Exception e) {
								
								pst9.setString(6,null);
							}																																		
							
							pst9.setString(11, ""+0);
							try{
								c = Integer.valueOf(chek_amt);
								}catch (Exception e) {
									
									c=0;
								}
							pst9.setString(12, ""+c);
							pst9.setString(13, ""+0);
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, ""+ib.getBankname());
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
							
							 k=pst9.executeUpdate();
						
						}
						
						
						
						//credit
						
					else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
					{
						
						
						pst9.setString(3, "CARD");
						
						String paid_amt2="";
						String chek_amt="";
					
						paid_amt2=ib.getNet_amountcard();
						
					
						chek_amt=ib.getNet_amountcard();
						Integer c=0;
						Integer a=0;
						try{
							 a = Integer.valueOf(paid_amt2);
							}catch (Exception e) {
								
								a=0;
							}
							pst9.setString(4, ""+a);
							pst9.setString(5,""+ 0);
							
							pst9.setString(7,"");
							pst9.setString(8,ib.getCardid());
							pst9.setString(9,"");
							
							DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString=ib.getCheque_date();
							Date dNo = new Date();
							dNo = ft.parse(dateInString);
							Date dNow = new Date();
						
						
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setInt(11, 0);
							try{
								c = Integer.valueOf(chek_amt);
								}catch (Exception e) {
									
									c=0;
								}
							pst9.setString(12,""+ 0);
							pst9.setString(13, ""+a);
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
							
							 k=pst9.executeUpdate();
						
						}
						
						// Insurance
					else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
					{
						
						
						pst9.setString(3, "INSURANCE");
						
						String paid_amt2="";
						String balace="";
						String chek_amt="";
					
						paid_amt2=ib.getPaid_amt22();
						
						
						//chek_amt=ib.getNet_amountcard();
						balace=ib.getBalance_amt22();
						Integer c=0;
						Integer a=0;
						try{
							 a = Integer.valueOf(paid_amt2);
							}catch (Exception e) {
								
								a=0;
							}
							pst9.setString(4, ""+a);
							try{
								c = Integer.valueOf(balace);
								}catch (Exception e) {
									
									c=0;
								}
							pst9.setString(5,""+ c);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,ib.getInsurance());
							
							DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString=ib.getCheque_date();
							Date dNo = new Date();
							dNo = ft.parse(dateInString);
							Date dNow = new Date();
						
						
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setString(11, ""+a);
							
							pst9.setString(12, ""+0);
							pst9.setString(13, ""+0);
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							String d=null;
							try{
							 d= CoreData.getDateFormatAsDb(ib.getDate22());
							}catch (Exception e) {
								
								d=null;
							}
							pst9.setString(17, d);
							pst9.setString(18, "0");
							
							 k=pst9.executeUpdate();
						
						}
						
						
						
					else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
					{
						
						String paymode="";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";
						String paycash = "";
						String paycheque = "";
						String paycredit = "";
						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
						{
							paymode=ib.getR1()+"~"+"CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");
						
						}
						else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
						{
							
							paymode=ib.getR1()+"~"+"CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						}
						else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
						{
							paymode=ib.getR1()+"~"+"CARD";
							pst9.setString(11,"0");
							
							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);
							
						}
						else
						{
							paymode=ib.getPaymod();
								pst9.setString(11,"0");
							
							pst9.setString(12, "0");
							pst9.setString(13,"0");
						}
						

						pst9.setString(3, paymode);		
						
						//chek_amt=ib.getNet_amountcard();
						balace=ib.getBalance_amt();
						Integer c=0;
						Integer a=0;
						try{
							 a = Integer.valueOf(paid_amt2);
							}catch (Exception e) {
								
								a=0;
							}
							pst9.setString(4, ""+a);
							try{
								c = Integer.valueOf(balace);
								}catch (Exception e) {
									
									c=0;
								}
							pst9.setString(5, ""+c);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString=ib.getCheque_date();
							Date dNo = new Date();
							dNo = ft.parse(dateInString);
							Date dNow = new Date();
						
							
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
							
							 k=pst9.executeUpdate();
						
						}
						
						
						// card and cash
					
					else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
					{
						
						
						pst9.setString(3, "CARDANDCASH");
						
						String paid_amt2="";
						String balace="";
						String credit="";
					
						paid_amt2=ib.getCashhh();
						
						
						//chek_amt=ib.getNet_amountcard();
						credit=ib.getCarddd();
						Integer c=0;
						Integer a=0;
						Integer p=0;
						try{
							 a = Integer.valueOf(paid_amt2);
							}catch (Exception e) {
								
								a=0;
							}
							
							try{
								 c = Integer.valueOf(credit);
								}catch (Exception e) {
									
									c=0;
								}
							
							p=(a+c);
							
							pst9.setString(4, ""+p);
							try{
								c = Integer.valueOf(balace);
								}catch (Exception e) {
									
									c=0;
								}
							pst9.setString(5, ""+0);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
							String dateInString=ib.getCheque_date();
							Date dNo = new Date();
							dNo = ft.parse(dateInString);
							Date dNow = new Date();
						
						
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setString(11,""+paid_amt2);
							
							pst9.setString(12, ""+0);
							pst9.setString(13, ""+credit);
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
							
							 k=pst9.executeUpdate();
						
						}*/
							
							pst9.setString(3, "");
					
								pst9.setString(4, "");
								
								pst9.setString(5, ""+0);
								
								pst9.setString(7,"");
								pst9.setString(8,""+0);
								pst9.setString(9,"");
								
								
								pst9.setString(2,(deliverymodel.getDate()));
								
								pst9.setNull(6,java.sql.Types.DATE);
																																											
								
								pst9.setString(11,"");
								
								pst9.setString(12, "");
								pst9.setString(13, "");
								pst9.setString(15, ""+deliverymodel.getTotal_amount1());
								pst9.setString(16, "");
								
								pst9.setString(17, "");
								pst9.setString(18, "0");
								int k = 0;
								System.out.println("16"+pst9);

								k=pst9.executeUpdate();
							
						

					System.out.println("16");
					
					
					
					// Insert Into Customer Credit Debit Report
					

					String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
					
					pst9=con.prepareStatement(query11);
					pst9.setString(1, deliverymodel.getCustomer_no());
					pst9.setString(2,deliverymodel.getDate());
					pst9.setString(3,deliverymodel.getInvoiceno());
					pst9.setString(4, "Invoice");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7,deliverymodel.getTotal_amount1());
					pst9.setString(8,deliverymodel.getCustomer_name());
					
					System.out.println("SQL:"+pst9);
					 k=pst9.executeUpdate();
						
					 
					 
					 
					// Bill Number Generation For Customer Credit Debit
						
					
					//--------------------
						
						
					/*PreparedStatement preparedStatement1121 = con
					.prepareStatement("update  job_card set job_card_done_status='"
							+ 1 + "' where job_card_no=? ");

				preparedStatement1121.setString(1, ib.getJob_Card_no());
				j = preparedStatement1121.executeUpdate();

				if (k > 0 && j > 0 && v>0) {
				response = "success";
				} else {
				response = "fail";

				}*/

				try{/*
				System.out.println(">>>>s");

				PreparedStatement preparedStatement112 = con.prepareStatement("select * from settings ");
						//System.out.println("preparedStatement112"+preparedStatement112);
					ResultSet resultSet12 = preparedStatement112.executeQuery();
					System.out.println(">>>>s1");

					if (resultSet12.next()) {
						System.out.println(">>>>s2"+resultSet12.getString("po"));

					if(resultSet12.getString("po").trim().equals("yes")){	
						System.out.println(">>>>3>>>"+ib.getDescription1().length);

				for (int k2=0;k2<ib.getDescription1().length;k2++)
				{
				System.out.println(">>>>4");

				System.out.println(">>>>s");
				PreparedStatement ppt = con
					.prepareStatement("select qtyremaining,descrip from purchase_order_details where pono='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

				System.out.println("SQL:"+ppt);
				ResultSet rst = ppt.executeQuery();

				while (rst.next()) {

				String desc=ib.getDescription1()[k2];
				String qty=rst.getString("qtyremaining");

				System.out.println("Quantity:"+qty);

				String qty1=ib.getQuantity1()[k2];

				Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);

				System.out.println("New QUantity:"+qty2);

				String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and pono='"+ib.getPono()+"'";
				PreparedStatement ps1 = con.prepareStatement(q11);	


				System.out.println("Sql12::"+ps1);

				ps1.executeUpdate();

				}

				}
					}
					}
				*/}catch(Exception e){

					e.printStackTrace();
				}

					// list insert
				
					PreparedStatement pst18 = conn.prepareStatement("update delivery_done set invoice_done_status='1' where LR_no = '"+lr_number+"'");
					int q = pst18.executeUpdate();
				
					System.out.println("18"+deliverymodel.getDescription().length);
					int rr = 0;
					String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty, LR_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pst41 = con.prepareStatement(q1);
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
						if (!deliverymodel.getDescription()[j1].trim().equals("") && !deliverymodel.getDescription()[j1].trim().equals(null)) {
						

						pst41.setString(1, deliverymodel.getInvoiceno());

						String btype = "";

						try {
							//btype = ib.getBtype()[j1];
						} catch (Exception e) {
							e.printStackTrace();
							
							btype = "";
						}
						pst41.setString(2, "");

						// pst41.setString(2,"labour");

						pst41.setString(3, deliverymodel.getDescription()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = deliverymodel.getAmount()[j1];
						
						Double vatper = Double.parseDouble(deliverymodel.getGst_rate1()[j1]) +  Double.parseDouble(deliverymodel.getGst_rate2()[j1]);
						
						
						String vatpercentlist = String.valueOf(vatper);

						String taxamountlist = "";

						String netamountlist = deliverymodel.getNet_amt()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = deliverymodel.getWeight()[j1];
							
							Quantity1 = Double.parseDouble(qty);
							
						} catch (Exception e) {
						
							Quantity1 = 0.0;
						}

					
						pst41.setDouble(4, Quantity1);

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}
						
						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst41.setDouble(5, amount);
						pst41.setDouble(6, vatpercent);

						pst41.setDouble(7, taxamount);
						pst41.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = deliverymodel.getHsn()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst41.setString(9, ttype);
						pst41.setString(10, deliverymodel.getGst_rate1()[j1]);
						pst41.setString(11, deliverymodel.getGst_rate1amt()[j1]);
						pst41.setString(12, deliverymodel.getGst_rate2()[j1]);
						pst41.setString(13, deliverymodel.getGst_rate2amt()[j1]);
						pst41.setString(14, deliverymodel.getRate()[j1]);
						pst41.setString(15, "");
						pst41.setString(16, "");
						pst41.setString(17, "");
						pst41.setString(18, "");
						pst41.setString(19, "");
						pst41.setString(20, "");
						pst41.setString(21, "");
						pst41.setString(22, lr_number);
						System.out.println("16"+pst41);
						int l1 = pst41.executeUpdate();

						if (l1 > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						rr = rr + 1;
						;

						String sn = "" + rr;

						deliverymodel.setSn(sn);
						}

					}

					// -----------
					
					System.out.println("19");	
					
							PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+deliverymodel.getInvoiceno()+"' GROUP BY type_name   ");
							System.out.println("preparedStatement112"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						String query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41x = con.prepareStatement(query);
						
						pst41x.setString(1, deliverymodel.getInvoiceno());	
						pst41x.setString(2, resultSet12zz.getString("type_name"));	
						pst41x.setString(3, resultSet12zz.getString("cgstrate"));	
						pst41x.setString(4, resultSet12zz.getString("sgstrate"));	
						pst41x.setString(5, resultSet12zz.getString("cgstamount"));	
						pst41x.setString(6, resultSet12zz.getString("sgstamount"));	
						pst41x.setString(7, resultSet12zz.getString("vat_percent"));	
						pst41x.setString(8, resultSet12zz.getString("taxablevalue"));	
						System.out.println(pst41x);
						pst41x.executeUpdate();
						}
						
						System.out.println("20");

					// insert to tax collection
					 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";
					 	
					 int js = 0;
					 pst41 = con.prepareStatement(q1);
					for (int j1 = 0; j1 < 3; j1++) {

						
						if(j1==0)
						{
							pst41.setString(1, deliverymodel.getInvoiceno());
							pst41.setString(2, "CGST");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getCgst()));
							pst41.setString(5, (deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						if(j1==1)
						{
							pst41.setString(1, deliverymodel.getInvoiceno());
							pst41.setString(2, "SGST");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getSgst()));
							pst41.setString(5, (deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						if(j1==2)
						{
							pst41.setString(1, deliverymodel.getInvoiceno());
							pst41.setString(2, "Total Tax Amount");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getTotal_tax_amount()));
							pst41.setString(5, (deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						

						/*pst41.setString(1, stringValue1);

						
						String type = "";
						String taxableamount = ib.getA()[j1];
						String tax = ib.getA2()[j1];

						double taxableamount1 = 0.0;
						double tax1 = 0.0;
						// double netamount =0.0;
						try {
							type = ib.getT()[j1];
						} catch (Exception e) {
							
							type = "";
						}

						pst41.setString(2, type);

						try {
							taxableamount1 = Double.parseDouble(taxableamount);
						} catch (Exception e) {
							
							taxableamount1 = 0.0;
						}

						pst41.setDouble(3, taxableamount1);

						try {
							tax1 = Double.parseDouble(tax);
						} catch (Exception e) {
							
							tax1 = 0.0;
						}

						pst41.setDouble(4, tax1);

						
						pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
*/					
						
						//int js = pst41.executeUpdate();
						System.out.println("21");
						if (js > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						// pst41.setString(2,"labour");

					}

				

				// -----

				try{
					System.out.println("22");
					DBConnection connection1=new DBConnection();Connection conn = connection1.getConnection();

					
				}catch(Exception e){
					e.printStackTrace();
				}

				

				return response;

					
					
					
					
					
				
				
				
				
				
				
		//}
				//}
	}
		catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return response;
	}


	
	
	
	public String Add_New_invoice_Igst(DeliveryModel deliverymodel, String lr_number) throws SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("2");
		
		String response = "";
		
		DBConnection connection=new DBConnection();
		
		int flag1 = 0;
		
		Connection con = connection.getConnection();
		
				System.out.println("3");
				try {
					//if (resultSet12z.next()) {
	
					System.out.println("4");
	 
					//if(resultSet12z.getString("po").equals("yes")){			
		 
					System.out.println("5");
		
			
				try {
				int result = -1;
				 Date date=new Date();
					if (date != null) {
				       Calendar cal = Calendar.getInstance();
				       cal.setTime(date);
				       result = cal.get(Calendar.MONTH)+1;
				   }
					 int result1 = -1;
				        if (date != null) {
				            Calendar cal = Calendar.getInstance();
				            cal.setTime(date);
				            result1 = cal.get(Calendar.YEAR);
				        }
				        String year = "";
				        String yy="";
				        String yy1="";
				        yy=""+result1;
				        
				        yy1=yy.substring(2,4);
				        
				       int pp=0;
				        pp=Integer.parseInt(yy1);
				        
				        if (result <= 3) {
				        year=""+(result1 - 1);
				        }else{
				        	
				        	  year=""+result1;
				        	
				        }
				        String Fyear ="";
				        if (result <= 3) {
				        	Fyear=  (result1 - 1) + "-" + pp;
				        } else {
				        	
				        	Fyear=  result1 + "-" + (pp + 1);
				          
				        }
				        
				        
				        String FMONTH = ""+result;
				    




				        String pref = "HSL/GST/";

						PreparedStatement pst9 = null;
						PreparedStatement pst99 = null;

						// String pref="INV";
						PreparedStatement preparedStatement11 = con
								.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
						preparedStatement11.setString(1, "" + "%" + pref+Fyear + "%");

						String mystr1 = "";
						int myval1 = 0;
						int w = 0;
						String stringValue1 = "1";
					
						ResultSet resultSet11 = preparedStatement11.executeQuery();
						if (resultSet11.next()) {
							try {
								mystr1 = resultSet11.getString("myval1");
								myval1 = Integer.parseInt(mystr1);
								myval1 = myval1 + 1;
							} catch (Exception e) {
								
								myval1 = 1;
								mystr1 = "";
							}
						}

						if (mystr1.equals("")) {
							stringValue1 = pref+ Fyear + "/0000" + stringValue1;

						} else {

							if (String.valueOf(myval1).length() == 1) {
								stringValue1 = pref+  Fyear + "/0000" + String.valueOf(myval1);

							} else if (String.valueOf(myval1).length() == 2) {
								stringValue1 =pref+  Fyear + "/000" + String.valueOf(myval1);
							} else if (String.valueOf(myval1).length() == 3) {
								stringValue1 = pref+  Fyear + "/00" + String.valueOf(myval1);
							} else if (String.valueOf(myval1).length() == 4) { 
								stringValue1 = pref+  Fyear + "/0" + String.valueOf(myval1);
							}
							else {
								stringValue1 = pref+  Fyear + "/" + String.valueOf(myval1);
							}
						}

				deliverymodel.setInvoiceno(stringValue1);
				System.out.println("6 "+stringValue1);
				
				
				
				String query = "";
				PreparedStatement preparedStatement = con
						.prepareStatement("select * from invoice where  invoice_no=?");
				String inv = deliverymodel.getInvoiceno();
				String inv1 = " " + inv;
				System.out.println(preparedStatement);
				preparedStatement.setString(1, inv1.trim());

				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					
					
					
				}

					try{
						
						DBConnection connection1=new DBConnection();
						Connection con1 = connection1.getConnection();
							
						
					}catch(Exception e){
						e.printStackTrace();
					}

				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			

/*				else {*/
			
					PreparedStatement pstcn = con.prepareStatement("select customer_no from lr where LR_no = '"+lr_number+"'");
					ResultSet rs55 = pstcn.executeQuery();
					
					if(rs55.next())
					{
						deliverymodel.setCustomer_no(rs55.getString(1));
					}
					
					PreparedStatement pst9 = null;
					
					System.out.println("15");
					System.out.println("LR no:"+lr_number);
					
					
					
					String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,LR_no,LR_date,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,igstamount,sgstamount,totaltax,LR_num,status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
					
					pst9=con.prepareStatement(query1);
					
					pst9.setString(40, lr_number);
					
					
					
					
					pst9.setString(1, deliverymodel.getCustomer_no());
					pst9.setString(10,deliverymodel.getInvoiceno());
					pst9.setString(14, deliverymodel.getInvoiceno());
					pst9.setString(19, lr_number);
					
					PreparedStatement pstlr = con.prepareStatement("select date from lr where LR_no = '"+lr_number+"'");
					ResultSet rslr = pstlr.executeQuery();
					
					String d3 = "";
					if(rslr.next())
					{
						d3 = rslr.getString(1);
					}
					
					pst9.setString(20, (d3));
					pst9.setString(21, "");
					pst9.setString(22, "");
					pst9.setString(23, "");
					pst9.setString(24, "");
					
					pst9.setString(25, "");
					pst9.setString(26, "");
					pst9.setString(27, "");
					pst9.setString(28, "");
					pst9.setString(29, "");
					pst9.setString(30, "");
					pst9.setString(31, "");
					pst9.setString(32, "");
					pst9.setString(33, "");
					pst9.setString(34, "");
					pst9.setString(35, "igst");
					pst9.setString(36, ""+deliverymodel.getTotal_amount1());
					pst9.setString(37, ""+deliverymodel.getCgst());
					pst9.setString(38, "");
					pst9.setString(39, ""+deliverymodel.getTotal_tax_amount());
					
					PreparedStatement rslr55 = con.prepareStatement("select advance, balance from lr where LR_no = '"+lr_number+"'");
					ResultSet rslr5 = rslr55.executeQuery();
					String paid_amt="";
					String balance_amt="";
					if(rslr5.next())
					{
						paid_amt = rslr5.getString(1);
						balance_amt = rslr5.getString(2);
					}
					
					
						
					
					try{
					// x = Integer.valueOf(paid_amt);
					}catch (Exception e) {
						
						//x=0;
					}
					try{
					 //Y = Integer.valueOf(balance_amt);
					}catch (Exception e) {
						
						//Y=0;
					}
					
							
							pst9.setString(3, "");
					
								pst9.setString(4, "");
								
								pst9.setString(5, ""+0);
								
								pst9.setString(7,"");
								pst9.setString(8,""+0);
								pst9.setString(9,"");
								
								
								pst9.setString(2,(deliverymodel.getDate()));
								
								pst9.setNull(6,java.sql.Types.DATE);
																																											
								
								pst9.setString(11,"");
								
								pst9.setString(12, "");
								pst9.setString(13, "");
								pst9.setString(15, ""+deliverymodel.getTotal_amount1());
								pst9.setString(16, "");
								
								pst9.setString(17, "");
								pst9.setString(18, "0");
								int k = 0;
								System.out.println("16"+pst9);

								k=pst9.executeUpdate();
							
						

					System.out.println("16");
					
					
					
					// Insert Into Customer Credit Debit Report
					

					String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
					
					pst9=con.prepareStatement(query11);
					pst9.setString(1, deliverymodel.getCustomer_no());
					pst9.setString(2,deliverymodel.getDate());
					pst9.setString(3,deliverymodel.getInvoiceno());
					pst9.setString(4, "Invoice");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7,deliverymodel.getTotal_amount1());
					pst9.setString(8,deliverymodel.getCustomer_name());
					
					System.out.println("SQL:"+pst9);
					 k=pst9.executeUpdate();
						
					 
					 
					


					// list insert
				
					PreparedStatement pst18 = conn.prepareStatement("update delivery_done set invoice_done_status='1' where LR_no = '"+lr_number+"'");
					int q = pst18.executeUpdate();
				
					System.out.println("18"+deliverymodel.getDescription().length);
					int rr = 0;
					
					
					String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty, LR_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pst41 = con.prepareStatement(q1);
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
						if (!deliverymodel.getDescription()[j1].trim().equals("") && !deliverymodel.getDescription()[j1].trim().equals(null)) {
						

						pst41.setString(1, deliverymodel.getInvoiceno());

						String btype = "";

						try {
							//btype = ib.getBtype()[j1];
						} catch (Exception e) {
							e.printStackTrace();
							
							btype = "";
						}
						pst41.setString(2, "");

						// pst41.setString(2,"labour");

						pst41.setString(3, deliverymodel.getDescription()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = deliverymodel.getAmount()[j1];
						
						Double vatper = Double.parseDouble(deliverymodel.getGst_rate1()[j1]);
						
						
						String vatpercentlist = String.valueOf(vatper);

						String taxamountlist = "";

						String netamountlist = deliverymodel.getNet_amt()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = deliverymodel.getWeight()[j1];
							
							Quantity1 = Double.parseDouble(qty);
							
						} catch (Exception e) {
						
							Quantity1 = 0.0;
						}

					
						pst41.setDouble(4, Quantity1);

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}
						
						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst41.setDouble(5, amount);
						pst41.setDouble(6, vatpercent);

						pst41.setDouble(7, taxamount);
						pst41.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = deliverymodel.getHsn()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst41.setString(9, ttype);
						pst41.setString(10, deliverymodel.getGst_rate1()[j1]);
						pst41.setString(11, deliverymodel.getGst_rate1amt()[j1]);
						pst41.setString(12, "");
						pst41.setString(13, "");
						pst41.setString(14, deliverymodel.getRate()[j1]);
						pst41.setString(15, "");
						pst41.setString(16, "");
						pst41.setString(17, "");
						pst41.setString(18, "");
						pst41.setString(19, "");
						pst41.setString(20, "");
						pst41.setString(21, "");
						pst41.setString(22, lr_number);
						System.out.println("16"+pst41);
						int l1 = pst41.executeUpdate();

						if (l1 > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						rr = rr + 1;
						

						String sn = "" + rr;

						deliverymodel.setSn(sn);
						}

					}

					// -----------jghjgh
					
				
					
					
					PreparedStatement preparedStatement112zz = conn.prepareStatement(
							"select sum(igstamount) as igstamount,sum(amtwithdisc) as taxablevalue , igstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"
									+ deliverymodel.getInvoiceno() + "'  GROUP BY type_name   ");

					System.out.println("preparedStatement112" + preparedStatement112zz);
					ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

					while (resultSet12zz.next()) {

						String query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,igstamount,rate ,taxablevalue) values (?,?,?,?,?,?) ";
						PreparedStatement pst41x = conn.prepareStatement(query);

						pst41x.setString(1, deliverymodel.getInvoiceno());	
						pst41x.setString(2, resultSet12zz.getString("type_name"));
						pst41x.setString(3, resultSet12zz.getString("igstrate"));

						pst41x.setString(4, resultSet12zz.getString("igstamount"));
						pst41x.setString(5, resultSet12zz.getString("vat_percent"));
						pst41x.setString(6, resultSet12zz.getString("taxablevalue"));

						
						System.out.println(pst41x);
						pst41x.executeUpdate();
					}
					
					
					
					
					
					
				/*	System.out.println("19");	
					
							PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+deliverymodel.getInvoiceno()+"' GROUP BY type_name   ");
							System.out.println("preparedStatement112"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						String query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41x = con.prepareStatement(query);
						
						pst41x.setString(1, deliverymodel.getInvoiceno());	
						pst41x.setString(2, resultSet12zz.getString("type_name"));	
						pst41x.setString(3, resultSet12zz.getString("cgstrate"));	
						pst41x.setString(4, resultSet12zz.getString("sgstrate"));	
						pst41x.setString(5, resultSet12zz.getString("cgstamount"));	
						pst41x.setString(6, resultSet12zz.getString("sgstamount"));	
						pst41x.setString(7, resultSet12zz.getString("vat_percent"));	
						pst41x.setString(8, resultSet12zz.getString("taxablevalue"));	
						System.out.println(pst41x);
						pst41x.executeUpdate();
						}*/
						
						System.out.println("20");

					// insert to tax collection
					 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";
					 	
					 int js = 0;
					 pst41 = con.prepareStatement(q1);
					
					 for (int j1 = 0; j1 < 2; j1++) {

						
						if(j1==0)
						{
							pst41.setString(1, deliverymodel.getInvoiceno());
							pst41.setString(2, "IGST");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getCgst()));
							pst41.setString(5, (deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						
						
						if(j1==2)
						{
							pst41.setString(1, deliverymodel.getInvoiceno());
							pst41.setString(2, "Total Tax Amount");
							pst41.setDouble(3, 0);
							pst41.setDouble(4, Double.parseDouble(deliverymodel.getTotal_tax_amount()));
							pst41.setString(5, (deliverymodel.getDate()));
							
							
							js = pst41.executeUpdate();
						}
						
						

						
				
						
						//int js = pst41.executeUpdate();
						System.out.println("21");
						if (js > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						// pst41.setString(2,"labour");

					}

					

				return response;

					
		
	}
		catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<DeliveryModel> fetchForMultiInv(String str, String c_name) {
		// TODO Auto-generated method stub
		
		List<DeliveryModel> list = new ArrayList<>();
		
		String string = str.substring(0, str.length()-1);
		System.out.println(string);
		
		String[] lr_nos = string.split("~");
		
		try {
			
			for(int i=0; i<lr_nos.length; i++)
			{
				
					PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_nos[i]+"'");
					ResultSet rs = pst.executeQuery();
					
					String delivery_done_id = "";
					String trip_id = "";
					String updown_id = "";
					String source = "";
					String destination = "";
					String vehicle_no = "";
					String driver_name = "";
					String lr_number = "";
					if(rs.next())
					{
						
						delivery_done_id = rs.getString("delivery_done_id");
						trip_id = rs.getString("trip_id");
						updown_id = rs.getString("updown_id");
						source = rs.getString("source");
						destination = rs.getString("destination");
						vehicle_no = rs.getString("vehicle_no");
						driver_name = rs.getString("driver_name");
						lr_number = lr_nos[i];
						
						PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done_details where delivery_done_id = '"+delivery_done_id+"'");
						ResultSet rs1 = pst1.executeQuery();
						
						while(rs1.next())
						{
							DeliveryModel model = new DeliveryModel();
							
							System.out.println("Lr_number : "+lr_number);
							model.setLr_number(lr_number);
							System.out.println("lr get : "+model.getLr_number());
							model.setTrip_id(trip_id);
							model.setUpdown_id(updown_id);
							model.setSource(source);
							model.setDestination(destination);
							model.setVehicle_no(vehicle_no);
							model.setDriver_name(driver_name);
							
							model.setDescription1(rs1.getString("description"));
							model.setWeight1(rs1.getString("weight"));
							model.setReceived_weight1(rs1.getString("received_weight"));
							model.setShort_weight1(rs1.getString("short_weight"));
							model.setRate1(rs1.getString("rate"));
							model.setAmount1(rs1.getString("amount"));
							
							PreparedStatement psttt = conn.prepareStatement("select hsn_code, tax_per from product_master where product_name = '"+model.getDescription1()+"'");
							ResultSet rsttt = psttt.executeQuery();
							
							String hsn = "";
							String tax_rate = "";
							String tax_rate1 = "";
							String tax_rate2 = "";
							
							double tax = 0;
							double tax_amt = 0;
							
							
							
							if(rsttt.next())
							{
								hsn = rsttt.getString(1);
								tax_rate = rsttt.getString(2);
							}
							
							
							tax = Double.parseDouble(tax_rate)/2;
							tax_amt = (Double.parseDouble(model.getAmount1()) * tax)/100;
							
							
							model.setHsn1(hsn);
							model.setGstrate1(String.valueOf(tax));
							model.setGstrate2(String.valueOf(tax));
							
							model.setGstamt1(String.valueOf(tax_amt));
							model.setGstamt2(String.valueOf(tax_amt));
							
							
							
							
							
							
							double short_penalty = Double.parseDouble(model.getShort_weight1()) * Double.parseDouble(model.getRate1());
							model.setPenalty_amount(String.valueOf(short_penalty));
							
							/*double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1()) + short_penalty;*/
							double net_amt = Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()) + Double.parseDouble(model.getAmount1());
							model.setNet_amt1(String.valueOf(net_amt));
							
							list.add(model);
							
						}
					}
			
			
			
			
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
		
		return list;
	}


	public String insertInvoiceInfo2(DeliveryModel deliverymodel) {
		
		System.out.println("2");
		String response = "";
		DBConnection connection=new DBConnection();
		int flag1 = 0;
		Connection con = connection.getConnection();
		
		
				System.out.println("3");
				try {
					
					System.out.println("4");
	  			
					System.out.println("5");
					
					
					
						try {
						int result = -1;
						 Date date=new Date();
							if (date != null) {
						       Calendar cal = Calendar.getInstance();
						       cal.setTime(date);
						       result = cal.get(Calendar.MONTH)+1;
						   }
							 int result1 = -1;
						        if (date != null) {
						            Calendar cal = Calendar.getInstance();
						            cal.setTime(date);
						            result1 = cal.get(Calendar.YEAR);
						        }
						        String year = "";
						        String yy="";
						        String yy1="";
						        yy=""+result1;
						        
						        yy1=yy.substring(2,4);
						        
						       int pp=0;
						        pp=Integer.parseInt(yy1);
						        
						        if (result <= 3) {
						        year=""+(result1 - 1);
						        }else{
						        	
						        	  year=""+result1;
						        	
						        }
						        String Fyear ="";
						        if (result <= 3) {
						        	Fyear=  (result1 - 1) + "-" + pp;
						        } else {
						        	
						        	Fyear=  result1 + "-" + (pp + 1);
						          
						        }
						        
						        
						        String FMONTH = ""+result;
						    




						        String pref = "HSL/GST/";

								PreparedStatement pst9 = null;
								PreparedStatement pst99 = null;

								
								PreparedStatement preparedStatement11 = con
										.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
								preparedStatement11.setString(1, "" + "%" + pref+Fyear + "%");

								String mystr1 = "";
								int myval1 = 0;
								int w = 0;
								String stringValue1 = "1";
							
								ResultSet resultSet11 = preparedStatement11.executeQuery();
								if (resultSet11.next()) {
									try {
										mystr1 = resultSet11.getString("myval1");
										myval1 = Integer.parseInt(mystr1);
										myval1 = myval1 + 1;
									} catch (Exception e) {
										
										myval1 = 1;
										mystr1 = "";
									}
								}

								if (mystr1.equals("")) {
									stringValue1 = pref+ Fyear + "/0000" + stringValue1;

								} else {

									if (String.valueOf(myval1).length() == 1) {
										stringValue1 = pref+  Fyear + "/0000" + String.valueOf(myval1);

									} else if (String.valueOf(myval1).length() == 2) {
										stringValue1 =pref+  Fyear + "/000" + String.valueOf(myval1);
									} else if (String.valueOf(myval1).length() == 3) {
										stringValue1 = pref+  Fyear + "/00" + String.valueOf(myval1);
									} else if (String.valueOf(myval1).length() == 4) { 
										stringValue1 = pref+  Fyear + "/0" + String.valueOf(myval1);
									}
									else {
										stringValue1 = pref+  Fyear + "/" + String.valueOf(myval1);
									}
								}

						deliverymodel.setInvoiceno(stringValue1);
						System.out.println("6 "+stringValue1);
						
						
						String query = "";
						PreparedStatement preparedStatement = con
								.prepareStatement("select * from invoice where  invoice_no=?");
						String inv = deliverymodel.getInvoiceno();
						String inv1 = " " + inv;
						System.out.println(preparedStatement);
						preparedStatement.setString(1, inv1.trim());

						ResultSet resultSet = preparedStatement.executeQuery();
						if (resultSet.next()) {}

							try{
								
								DBConnection connection1=new DBConnection();
								Connection con1 = connection1.getConnection();
									
								
							}catch(Exception e){
								e.printStackTrace();
							}

						}catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}catch (Exception e) {
						// TODO: handle exception
					}


					try {
							PreparedStatement pstcn = con.prepareStatement("select customer_no from lr where LR_no = '"+deliverymodel.getLr_number1()[0]+"'");
							ResultSet rs55 = pstcn.executeQuery();
							
							if(rs55.next())
							{
								deliverymodel.setCustomer_no(rs55.getString(1));
							}
							
							PreparedStatement pst9 = null;
							
							System.out.println("15");
							System.out.println("LR no:"+deliverymodel.getLr_number1()[0]);
							String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,LR_no,LR_date,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,LR_num,status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
							pst9=con.prepareStatement(query1);
							pst9.setString(40, "");
							
							
							
							
							pst9.setString(1, deliverymodel.getCustomer_no());
							pst9.setString(10,deliverymodel.getInvoiceno());
							pst9.setString(14, deliverymodel.getInvoiceno());
							pst9.setString(19, "");
							
							PreparedStatement pstlr = con.prepareStatement("select date from lr where LR_no = '"+deliverymodel.getLr_number1()[0]+"'");
							ResultSet rslr = pstlr.executeQuery();
							
							String d3 = "";
							if(rslr.next())
							{
								d3 = rslr.getString(1);
							}
							
							pst9.setString(20, "");
							pst9.setString(21, "");
							pst9.setString(22, "");
							pst9.setString(23, "");
							pst9.setString(24, "");
							
							pst9.setString(25, "");
							pst9.setString(26, "");
							pst9.setString(27, "");
							pst9.setString(28, "");
							pst9.setString(29, "");
							pst9.setString(30, "");
							pst9.setString(31, "");
							pst9.setString(32, "");
							pst9.setString(33, "");
							pst9.setString(34, "");
							pst9.setString(35, "sgst");
							pst9.setString(36, ""+deliverymodel.getTotal_amount1());
							pst9.setString(37, ""+deliverymodel.getCgst());
							pst9.setString(38, ""+deliverymodel.getSgst());
							pst9.setString(39, ""+deliverymodel.getTotal_tax_amount());
							
							PreparedStatement rslr55 = con.prepareStatement("select advance, balance from lr where LR_no = '"+deliverymodel.getLr_number1()[0]+"'");
							ResultSet rslr5 = rslr55.executeQuery();
							String paid_amt="";
							String balance_amt="";
							if(rslr5.next())
							{
								paid_amt = rslr5.getString(1);
								balance_amt = rslr5.getString(2);
							}
							
							
							
							
							
							try{
							
							}catch (Exception e) {
								

							}
							try{

							}catch (Exception e) {
								

							}

							
									
									pst9.setString(3, "");
							
										pst9.setString(4, "");
										
										pst9.setString(5, ""+0);
										
										pst9.setString(7,"");
										pst9.setString(8,""+0);
										pst9.setString(9,"");
										
										
										pst9.setString(2,(deliverymodel.getDate()));
										
										pst9.setNull(6,java.sql.Types.DATE);
																																													
										
										pst9.setString(11,"");
										
										pst9.setString(12, "");
										pst9.setString(13, "");
										pst9.setString(15, ""+deliverymodel.getTotal_amount1());
										pst9.setString(16, "");
										
										pst9.setString(17, "");
										pst9.setString(18, "0");
										int k = 0;
										
										k=pst9.executeUpdate();
									
								

							System.out.println("16");
							
							
							

							

							String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
							
							pst9=con.prepareStatement(query11);
							pst9.setString(1, deliverymodel.getCustomer_no());
							pst9.setString(2,deliverymodel.getDate());
							pst9.setString(3,deliverymodel.getInvoiceno());
							pst9.setString(4, "Invoice");
							pst9.setString(5, "101");
							pst9.setString(6, "Debit");
							pst9.setString(7,deliverymodel.getTotal_amount1());
							pst9.setString(8,deliverymodel.getCustomer_name());
							
							System.out.println("SQL:"+pst9);
							 k=pst9.executeUpdate();
								
							 
							 
							 
							

						try{}catch(Exception e){

							e.printStackTrace();
						}

						
						
						
						
					
					System.out.println("20");

				
				String  q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";
				 	
				 int js = 0;
				 PreparedStatement pst41 = con.prepareStatement(q1);
				 
				 if(deliverymodel.getDescription()[0] != "" ){
				for (int j1 = 0; j1 < 3; j1++) {

					
					if(j1==0)
					{
						pst41.setString(1, deliverymodel.getInvoiceno());
						pst41.setString(2, "CGST");
						pst41.setDouble(3, 0);
						pst41.setDouble(4, Double.parseDouble(deliverymodel.getCgst()));
						pst41.setString(5, (deliverymodel.getDate()));
						
						
						js = pst41.executeUpdate();
					}
					
					if(j1==1)
					{
						pst41.setString(1, deliverymodel.getInvoiceno());
						pst41.setString(2, "SGST");
						pst41.setDouble(3, 0);
						pst41.setDouble(4, Double.parseDouble(deliverymodel.getSgst()));
						pst41.setString(5, (deliverymodel.getDate()));
						
						
						js = pst41.executeUpdate();
					}
					
					if(j1==2)
					{
						pst41.setString(1, deliverymodel.getInvoiceno());
						pst41.setString(2, "Total Tax Amount");
						pst41.setDouble(3, 0);
						pst41.setDouble(4, Double.parseDouble(deliverymodel.getTotal_tax_amount()));
						pst41.setString(5, (deliverymodel.getDate()));
						
						
						js = pst41.executeUpdate();
					}
					
					
					System.out.println("21");
					if (js > 0) {
						response = "success";
					} else {
						response = "fail";

					}



				}

					
					
					
					
					
					
			
					// 
					System.out.println("18");
					int rr = 0;
					String q2 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty, LR_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pst42 = con.prepareStatement(q2);
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
						if (!deliverymodel.getDescription()[j1].trim().equals("") && !deliverymodel.getDescription()[j1].trim().equals(null)) {
						

						pst42.setString(1, deliverymodel.getInvoiceno());

						String btype = "";

						try {
							
						} catch (Exception e) {
							e.printStackTrace();
							
							btype = "";
						}
						pst42.setString(2, "");

						

						pst42.setString(3, deliverymodel.getDescription()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = deliverymodel.getAmount()[j1];
						
						Double vatper = Double.parseDouble(deliverymodel.getGst_rate1()[j1]) +  Double.parseDouble(deliverymodel.getGst_rate2()[j1]);
						
						
						String vatpercentlist = String.valueOf(vatper);

						String taxamountlist = "";

						String netamountlist = deliverymodel.getNet_amt()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = deliverymodel.getWeight()[j1];
							
							Quantity1 = Double.parseDouble(qty);
							
						} catch (Exception e) {
						
							Quantity1 = 0.0;
						}

					
						pst42.setDouble(4, Quantity1);

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}
						
						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst42.setDouble(5, amount);
						pst42.setDouble(6, vatpercent);

						pst42.setDouble(7, taxamount);
						pst42.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = deliverymodel.getHsn()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst42.setString(9, ttype);
						pst42.setString(10, deliverymodel.getGst_rate1()[j1]);
						pst42.setString(11, deliverymodel.getGst_rate1amt()[j1]);
						pst42.setString(12, deliverymodel.getGst_rate2()[j1]);
						pst42.setString(13, deliverymodel.getGst_rate2amt()[j1]);
						pst42.setString(14, deliverymodel.getRate()[j1]);
						pst42.setString(15, "");
						pst42.setString(16, "");
						pst42.setString(17, "");
						pst42.setString(18, "");
						pst42.setString(19, "");
						pst42.setString(20, "");
						pst42.setString(21, "");
						pst42.setString(22, deliverymodel.getLr_number1()[j1]);
						int l1 = pst42.executeUpdate();
						
						
						PreparedStatement pst18 = conn.prepareStatement("update delivery_done set invoice_done_status='1' where LR_no = '"+deliverymodel.getLr_number1()[j1]+"'");
						int q = pst18.executeUpdate();
						
						
						if (l1 > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						rr = rr + 1;
						;

						String sn = "" + rr;

						deliverymodel.setSn(sn);
						}

					}

					// -----------
					
					System.out.println("19");	
					
				PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+deliverymodel.getInvoiceno()+"' GROUP BY type_name   ");
				System.out.println("preparedStatement112"+preparedStatement112zz);
				ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

				while (resultSet12zz.next()) {
					
				String query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
				PreparedStatement pst41x = con.prepareStatement(query);
				
				pst41x.setString(1, deliverymodel.getInvoiceno());	
				pst41x.setString(2, resultSet12zz.getString("type_name"));	
				pst41x.setString(3, resultSet12zz.getString("cgstrate"));	
				pst41x.setString(4, resultSet12zz.getString("sgstrate"));	
				pst41x.setString(5, resultSet12zz.getString("cgstamount"));	
				pst41x.setString(6, resultSet12zz.getString("sgstamount"));	
				pst41x.setString(7, resultSet12zz.getString("vat_percent"));	
				pst41x.setString(8, resultSet12zz.getString("taxablevalue"));	
				System.out.println(pst41x);
				pst41x.executeUpdate();
				}
							
				



				try{
					System.out.println("22");
					DBConnection connection1=new DBConnection();Connection conn = connection1.getConnection();

					
				}catch(Exception e){
					e.printStackTrace();
				}

				}

				return response;

					
					
					
					
					
				
				
				
				
				
				
	
					}
	
		catch(Exception e) {

			e.printStackTrace();
		}
						
	return response;
	
	}


	public DeliveryModel fetchCustDetails(String lr_number) {
		// TODO Auto-generated method stub
		
		DeliveryModel model = new DeliveryModel();
		try {
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_number+"'");
		ResultSet rs = pst.executeQuery();
		
		String delivery_done_id = "";
		
		if(rs.next())
		{
			delivery_done_id = rs.getString(1);
			model.setCustomer_no(rs.getString("customer_no"));
		
		}
		
		PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
		ResultSet rst = ptcd.executeQuery();
		
		System.out.println("ptcd: "+ptcd);
		
		
		String gst = "";
		String pan = "";
		String state = "";
		String city = "";
		String mobile = "";
		String pending_amount = "";
		String address = "";
		
		if(rst.next())
		{
			gst = rst.getString("customer_gst_no");
			pan = rst.getString("pan_no");
			state = rst.getString("state");
			city = rst.getString("city");
			mobile = rst.getString("mobile_no");
			address = rst.getString("customer_address");
			
			PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number+"'");
			ResultSet rstb = pstb.executeQuery();
			
			System.out.println("pstb: "+pstb);
			
			if(rstb.next())
			{
				pending_amount = rstb.getString(1);
			}
			
			model.setGstin_no(gst);
			System.out.println("gst : "+model.getGstin_no());
			model.setPan_no(pan);
			model.setState(state);
			model.setCity(city);
			model.setMobile(mobile);
			model.setPending_amount(pending_amount);
			model.setAddress(address);
		}
		
		
		return model;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	
	public DeliveryModel fetchCustDetailsIgst(String lr_number) {
		// TODO Auto-generated method stub
		
		DeliveryModel model = new DeliveryModel();
		try {
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_number+"'");
		ResultSet rs = pst.executeQuery();
		
		String delivery_done_id = "";
		
		if(rs.next())
		{
			delivery_done_id = rs.getString(1);
			model.setCustomer_no(rs.getString("customer_no"));
		
		}
		
		PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
		ResultSet rst = ptcd.executeQuery();
		
		System.out.println("ptcd: "+ptcd);
		
		
		String gst = "";
		String pan = "";
		String state = "";
		String city = "";
		String mobile = "";
		String pending_amount = "";
		String address = "";
		
		if(rst.next())
		{
			gst = rst.getString("customer_gst_no");
			pan = rst.getString("pan_no");
			state = rst.getString("state");
			city = rst.getString("city");
			mobile = rst.getString("mobile_no");
			address = rst.getString("customer_address");
			
			PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number+"'");
			ResultSet rstb = pstb.executeQuery();
			
			System.out.println("pstb: "+pstb);
			
			if(rstb.next())
			{
				pending_amount = rstb.getString(1);
			}
			
			model.setGstin_no(gst);
			System.out.println("gst : "+model.getGstin_no());
			model.setPan_no(pan);
			model.setState(state);
			model.setCity(city);
			model.setMobile(mobile);
			model.setPending_amount(pending_amount);
			model.setAddress(address);
		}
		
		
		return model;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}


	public DeliveryModel fetchCustDetails1(String string) {
		// TODO Auto-generated method stub
		
		String string1 = string.substring(0, string.length()-1);
		System.out.println(string);
		
		String[] lr_nos = string1.split("~");
		
		
		DeliveryModel model = new DeliveryModel();
		try {
		System.out.println("lr_number1 : "+lr_nos[0]);
		PreparedStatement pst  = conn.prepareStatement("select * from delivery_done where LR_no = '"+lr_nos[0]+"'");
		System.out.println("pst : "+pst);
		ResultSet rs = pst.executeQuery();
		System.out.println("pst : "+pst);
		//String delivery_done_id = "";
		
		if(rs.next())
		{
			//delivery_done_id = rs.getString(1);
			model.setCustomer_no(rs.getString("customer_no"));
		
		}
		
		PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
		ResultSet rst = ptcd.executeQuery();
		System.out.println("ptcd : "+ptcd);
		
		
		
		String gst = "";
		String pan = "";
		String state = "";
		String city = "";
		String mobile = "";
		//String pending_amount = "";
		String address = "";
		
		if(rst.next())
		{
			gst = rst.getString("customer_gst_no");
			pan = rst.getString("pan_no");
			state = rst.getString("state");
			city = rst.getString("city");
			mobile = rst.getString("mobile_no");
			address = rst.getString("customer_address");
			
			//PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number1[0]+"'");
			/*ResultSet rstb = pstb.executeQuery();
			if(rstb.next())
			{
				pending_amount = rstb.getString(1);
			}*/
			
			model.setGstin_no(gst);
			System.out.println("gst : "+model.getGstin_no());
			model.setPan_no(pan);
			model.setState(state);
			model.setCity(city);
			model.setMobile(mobile);
			//model.setPending_amount(pending_amount);
			model.setAddress(address);
		}
		
		double sum = 0;
		
		for (int i = 0; i < lr_nos.length; i++) {
			
			PreparedStatement pstt = conn.prepareStatement("select balance from lr where LR_no = '"+lr_nos[i]+"'");
			ResultSet rst12 = pstt.executeQuery();
			
			System.out.println("pstt: "+pstt);
			
			if(rst12.next())
			{
				sum = sum + Double.parseDouble(rst12.getString(1));
			}
			
		}
		
		System.out.println("sum : "+sum);
		
		model.setPending_amount(String.valueOf(sum));
		
		return model;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;

	}


	public List<DeliveryModel> fetchInvoiveDetails() {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		//System.out.println("1");
		try {
			PreparedStatement pst = conn.prepareStatement("select * from invoice where status='1' ");
			ResultSet rs = pst.executeQuery();
			//System.out.println("2");
			while(rs.next())
			{
				//System.out.println("3");
				DeliveryModel model = new DeliveryModel();
				model.setInvoiceno(rs.getString("invoice_no"));
				model.setCustomer_no(rs.getString("vehicle_no"));
				model.setDate(rs.getString("date"));
				model.setTotal_amount(rs.getString("total"));
				
				model.setInvtype(rs.getString("invtype"));
				
				System.out.println("cust no : "+model.getCustomer_no());
				PreparedStatement pstt = conn.prepareStatement("select customer_name from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
				ResultSet rsttt = pstt.executeQuery();
				//System.out.println("4");
				System.out.println("pstt : "+pstt);
				
				String cust_name = "";
				
				if(rsttt.next())
				{
					cust_name = rsttt.getString("customer_name");
				}
				model.setCustomer_name(cust_name);
				
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}


	public List<DeliveryModel> fetchForEditInv(String invoiceno) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select * from invoice_tax_details where invoice_no = '"+invoiceno+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				
				model.setLr_number(rs.getString("LR_no"));
				model.setDescription1(rs.getString("descrip"));
				model.setWeight1(rs.getString("qty"));
				model.setRate1(rs.getString("rate"));
				model.setAmount1(rs.getString("amt"));
				model.setHsn1(rs.getString("type_name"));
				model.setGstrate1(rs.getString("cgstrate"));
				model.setGstamt1(rs.getString("cgstamount"));
				
				model.setGstrate2(rs.getString("sgstrate"));
				model.setGstamt2(rs.getString("sgstamount"));
				
				double netamt = Double.parseDouble(model.getAmount1()) + Double.parseDouble(model.getGstamt1()) + Double.parseDouble(model.getGstamt2()); 
				System.out.println("net amt : "+netamt);
				model.setNet_amt1(String.valueOf(netamt));
				
				double sum2 = 0;
				
				PreparedStatement pstp = conn.prepareStatement("select delivery_done_id from delivery_done where LR_no = '"+model.getLr_number()+"'");
				ResultSet rstp = pstp.executeQuery();
				if(rstp.next())
				{
					PreparedStatement pstp1 = conn.prepareStatement("select short_weight, rate from delivery_done_details where delivery_done_id = '"+rstp.getString(1)+"' and description = '"+model.getDescription1()+"'");
					ResultSet rstp1 = pstp1.executeQuery();
					
					while(rstp1.next())
					{
						sum2 = sum2 + (Double.parseDouble(rstp1.getString(1)) * Double.parseDouble(rstp1.getString(2)));
					}
				}
				
				model.setPenalty_amount(String.valueOf(sum2));
				
				list.add(model);
			}
			
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}


	public DeliveryModel fetchCustDetails2(String invoiceno) {
		// TODO Auto-generated method stub
		DeliveryModel model = new DeliveryModel();
		try {
			
			model.setInvoiceno(invoiceno);
			
			PreparedStatement pst = conn.prepareStatement("select vehicle_no from invoice where invoice_no = '"+invoiceno+"'");
			ResultSet rs = pst.executeQuery();
			
			String customer_no = "";
			if(rs.next())
			{
				customer_no = rs.getString(1);
				model.setCustomer_no(customer_no);
			}
			
			
			
			PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
			ResultSet rst = ptcd.executeQuery();
			System.out.println("ptcd : "+ptcd);
			
			
			
			String gst = "";
			String pan = "";
			String state = "";
			String city = "";
			String mobile = "";
			//String pending_amount = "";
			String address = "";
			
			if(rst.next())
			{
				gst = rst.getString("customer_gst_no");
				pan = rst.getString("pan_no");
				state = rst.getString("state");
				city = rst.getString("city");
				mobile = rst.getString("mobile_no");
				address = rst.getString("customer_address");
				
				
				//PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number1[0]+"'");
				/*ResultSet rstb = pstb.executeQuery();
				if(rstb.next())
				{
					pending_amount = rstb.getString(1);
				}*/
				model.setCustomer_name(rst.getString("customer_name"));
				model.setGstin_no(gst);
				System.out.println("gst : "+model.getGstin_no());
				model.setPan_no(pan);
				model.setState(state);
				model.setCity(city);
				model.setMobile(mobile);
				//model.setPending_amount(pending_amount);
				model.setAddress(address);
			}
			
			double sum = 0;
			
			int count = 0;
			PreparedStatement pstc = conn.prepareStatement("select DISTINCT LR_no from invoice_tax_details WHERE invoice_no='"+invoiceno+"'");
			ResultSet rstc = pstc.executeQuery();
			
			ArrayList<String> lrnos = new ArrayList<>(); 
			
			while(rstc.next())
			{
				lrnos.add(rstc.getString(1));
				count++;
			}
			
			
			for (int i = 0; i < lrnos.size(); i++) {
				
				PreparedStatement pstt = conn.prepareStatement("select balance from lr where LR_no = '"+lrnos.get(i)+"'");
				ResultSet rst12 = pstt.executeQuery();
				
				System.out.println("pstt: "+pstt);
				
				if(rst12.next())
				{
					sum = sum + Double.parseDouble(rst12.getString(1));
				}
				
			}
			
			System.out.println("sum : "+sum);
			
			model.setPending_amount(String.valueOf(sum));

			sum=0;
			for (int i = 0; i < lrnos.size(); i++) {
				
					PreparedStatement pstt = conn.prepareStatement("select total_amount from delivery_done where LR_no = '"+lrnos.get(i)+"'");
					ResultSet rst12 = pstt.executeQuery();
					
					System.out.println("pstt: "+pstt);
					
					if(rst12.next())
					{
						sum = sum + Double.parseDouble(rst12.getString(1));
					}
					
				}
			
			System.out.println("sum : "+sum);
			DecimalFormat format = new DecimalFormat("0.#");
			model.setTotal_amount(String.valueOf(format.format(sum)));

			
			
			
			
			
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	
	
	
	public List<DeliveryModel> fetchForEditInvIgst(String invoiceno) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select * from invoice_tax_details where invoice_no = '"+invoiceno+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				
				model.setLr_number(rs.getString("LR_no"));
				model.setDescription1(rs.getString("descrip"));
				model.setWeight1(rs.getString("qty"));
				model.setRate1(rs.getString("rate"));
				model.setAmount1(rs.getString("amt"));
				model.setHsn1(rs.getString("type_name"));
				model.setGstrate1(rs.getString("igstrate"));
				model.setGstamt1(rs.getString("igstamount"));
				
				//model.setGstrate2(rs.getString("sgstrate"));
				//model.setGstamt2(rs.getString("sgstamount"));
				
				double netamt = Double.parseDouble(model.getAmount1()) + Double.parseDouble(model.getGstamt1()) ; 
				System.out.println("net amt : "+netamt);
				model.setNet_amt1(String.valueOf(netamt));
				
				double sum2 = 0;
				
				PreparedStatement pstp = conn.prepareStatement("select delivery_done_id from delivery_done where LR_no = '"+model.getLr_number()+"'");
				ResultSet rstp = pstp.executeQuery();
				if(rstp.next())
				{
					PreparedStatement pstp1 = conn.prepareStatement("select short_weight, rate from delivery_done_details where delivery_done_id = '"+rstp.getString(1)+"' and description = '"+model.getDescription1()+"'");
					ResultSet rstp1 = pstp1.executeQuery();
					
					while(rstp1.next())
					{
						sum2 = sum2 + (Double.parseDouble(rstp1.getString(1)) * Double.parseDouble(rstp1.getString(2)));
					}
				}
				
				model.setPenalty_amount(String.valueOf(sum2));
				
				list.add(model);
			}
			
			return list;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public DeliveryModel fetchCustDetails2Igst(String invoiceno) {
		// TODO Auto-generated method stub
		DeliveryModel model = new DeliveryModel();
		try {
			
			model.setInvoiceno(invoiceno);
			
			PreparedStatement pst = conn.prepareStatement("select vehicle_no from invoice where invoice_no = '"+invoiceno+"'");
			ResultSet rs = pst.executeQuery();
			
			String customer_no = "";
			if(rs.next())
			{
				customer_no = rs.getString(1);
				model.setCustomer_no(customer_no);
			}
			
			
			
			PreparedStatement ptcd = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
			ResultSet rst = ptcd.executeQuery();
			System.out.println("ptcd : "+ptcd);
			
			
			
			String gst = "";
			String pan = "";
			String state = "";
			String city = "";
			String mobile = "";
			//String pending_amount = "";
			String address = "";
			
			if(rst.next())
			{
				gst = rst.getString("customer_gst_no");
				pan = rst.getString("pan_no");
				state = rst.getString("state");
				city = rst.getString("city");
				mobile = rst.getString("mobile_no");
				address = rst.getString("customer_address");
				
				
				//PreparedStatement pstb = conn.prepareStatement("select balance from lr where LR_no = '"+lr_number1[0]+"'");
				/*ResultSet rstb = pstb.executeQuery();
				if(rstb.next())
				{
					pending_amount = rstb.getString(1);
				}*/
				model.setCustomer_name(rst.getString("customer_name"));
				model.setGstin_no(gst);
				System.out.println("gst : "+model.getGstin_no());
				model.setPan_no(pan);
				model.setState(state);
				model.setCity(city);
				model.setMobile(mobile);
				//model.setPending_amount(pending_amount);
				model.setAddress(address);
			}
			
			double sum = 0;
			
			int count = 0;
			PreparedStatement pstc = conn.prepareStatement("select DISTINCT LR_no from invoice_tax_details WHERE invoice_no='"+invoiceno+"'");
			ResultSet rstc = pstc.executeQuery();
			
			ArrayList<String> lrnos = new ArrayList<>(); 
			
			while(rstc.next())
			{
				lrnos.add(rstc.getString(1));
				count++;
			}
			
			
			for (int i = 0; i < lrnos.size(); i++) {
				
				PreparedStatement pstt = conn.prepareStatement("select balance from lr where LR_no = '"+lrnos.get(i)+"'");
				ResultSet rst12 = pstt.executeQuery();
				
				System.out.println("pstt: "+pstt);
				
				if(rst12.next())
				{
					sum = sum + Double.parseDouble(rst12.getString(1));
				}
				
			}
			
			System.out.println("sum : "+sum);
			
			model.setPending_amount(String.valueOf(sum));

			sum=0;
			for (int i = 0; i < lrnos.size(); i++) {
				
					PreparedStatement pstt = conn.prepareStatement("select total_amount from delivery_done where LR_no = '"+lrnos.get(i)+"'");
					ResultSet rst12 = pstt.executeQuery();
					
					System.out.println("pstt: "+pstt);
					
					if(rst12.next())
					{
						sum = sum + Double.parseDouble(rst12.getString(1));
					}
					
				}
			
			System.out.println("sum : "+sum);
			DecimalFormat format = new DecimalFormat("0.#");
			model.setTotal_amount(String.valueOf(format.format(sum)));

				
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return model;
	}
	
	
	
	
	
	
	
	
	public String editInvoice(DeliveryModel deliverymodel)
	{
		String response = "";
		String query = "";
		try {
		PreparedStatement preparedStatement = conn
				.prepareStatement("select * from invoice where  invoice_no=?");
		String inv = deliverymodel.getInvoiceno();
		String inv1 = " " + inv;
		System.out.println(preparedStatement);
		preparedStatement.setString(1, inv1.trim());

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			response = "Already";
			
			PreparedStatement pst1 = conn.prepareStatement(
					"select * from customer_payment_details where invoiceno='"+inv1.trim()+"'");
			System.out.println("pst........." + pst1);
			ResultSet rs1 = pst1.executeQuery();
			if (rs1.next()) {
				
				
			}/*else{*/
			

			
			
			/*if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {*//*	
				
				
				query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

				inv1=ib.getInvno();
				ib.setInvoiceno(inv1);
				Date d1 = new Date();
				String da = "" + d1;
				
				
				pst9 = con.prepareStatement(query);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3, ib.getJob_Card_no());
				pst9.setString(25, inv1);
				pst9.setString(4, ib.getTamount());
				pst9.setString(5, ib.getPono());
				pst9.setString(6, ib.getPodate());
				pst9.setString(7, ib.getTermcond());
				pst9.setString(8, ib.getVendor());
				pst9.setString(9, ib.getDcnox());
				pst9.setString(10, ib.getDcdatex());
				
				pst9.setString(11, ib.getTransmode());
				pst9.setString(12, ib.getContactp());
				pst9.setString(13, ib.getContactpno());
				pst9.setString(14, ib.getShipparty());
				pst9.setString(15, ib.getShipadd());
				pst9.setString(16, ib.getShipgstn());
				pst9.setString(17, ib.getShipstate());
				pst9.setString(18, ib.getVehino());
				pst9.setString(19, ib.getFreight());
				pst9.setString(20, ib.getTransport());
				pst9.setString(21, ib.getA2()[0]);
				pst9.setString(22, ib.getA2()[1]);
				pst9.setString(23, ib.getA2()[2]);
				pst9.setString(24, ib.getTamount());
				k = pst9.executeUpdate();
				
			}*/
			else{
			
			PreparedStatement pst9 = null;	
				
				
			query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',LR_no=?,LR_date=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

			inv1=deliverymodel.getInvoiceno();
			deliverymodel.setInvoiceno(inv1);
			Date d1 = new Date();
			String da = "" + d1;
			
			
			pst9 = conn.prepareStatement(query);
			pst9.setString(1, deliverymodel.getCustomer_no());
			pst9.setString(32, inv1);
			pst9.setString(10, deliverymodel.getInvoiceno());
			pst9.setString(18, "");
			pst9.setString(19, "");
			pst9.setString(20, "");
			 pst9.setString(38, inv1);
			pst9.setString(21, "");
			pst9.setString(34, inv);
			pst9.setString(22, "");
			pst9.setString(23, "");
			pst9.setString(24, "");
			pst9.setString(25, "");
			pst9.setString(26, "");
			pst9.setString(27, "");
			pst9.setString(28, "");
			pst9.setString(29, "");
			pst9.setString(30, "");
			pst9.setString(31, "");
			pst9.setString(32, "");
			pst9.setString(33, "");
			pst9.setString(34, deliverymodel.getCgst());
			pst9.setString(35, deliverymodel.getSgst());
			pst9.setString(36, deliverymodel.getTotal_tax_amount());
			pst9.setString(37, deliverymodel.getTotal_amount1());
			String paid_amt = "";
			String balance_amt = "";
			/*paid_amt = ib.getPaid_amt();
			balance_amt = ib.getBalance_amt();*/

			
			
			// CASH
			/*if (ib.getPaymod().trim().equals("CASH")) {*//*
				pst9.setString(3, "CASH");
			
				String paid_amt1 = "";

				paid_amt1 = ib.getNet_amount();


				pst9.setString(4, paid_amt1);
				pst9.setString(5, "0");
				
				pst9.setString(7, "");
				
				pst9.setString(8, "0");
			
				pst9.setString(9, "");
			
				
				
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6, java.sql.Types.DATE);
				pst9.setString(11, paid_amt1);
				
				pst9.setString(12, "0");
				pst9.setString(13, "0");
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				pst9.setString(16, "");
				pst9.setString(17, "");
				
					
				k = pst9.executeUpdate();

			*//*}*/

			/*else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {*//*

				pst9.setString(3, "CHEQUE");
				Integer l = 0;
				String paid_amt2 = "";
				String chek_amt = "";

				//paid_amt2 = ib.getCash_amt();

				chek_amt = ib.getCheque_amt();
				Integer c = 0;
				try {
					l = Integer.valueOf(chek_amt);
				} catch (Exception e) {
					
					l = 0;
				}
				pst9.setString(4, chek_amt);
				pst9.setString(5, "0");

				pst9.setString(7, ib.getCheque_no());
				pst9.setString(8, "0");
				pst9.setString(9, "");

				
				
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
				pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

				pst9.setInt(11, 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {
					
					c = 0;
				}
				pst9.setString(12, chek_amt);
				pst9.setString(13, "0");
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				pst9.setString(16, ib.getBankname());
				pst9.setString(17, "");
				

				k = pst9.executeUpdate();

			*//*}*/

			// credit

			/*else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {*//*

				pst9.setString(3, "CARD");

				String paid_amt2 = "";
				String chek_amt = "";

				paid_amt2 = ib.getNet_amountcard();

				chek_amt = ib.getNet_amountcard();
				Integer c = 0;
				Integer a = 0;
				try {
					a = Integer.valueOf(paid_amt2);
				} catch (Exception e) {
					
					a = 0;
				}
				pst9.setString(4, paid_amt2);
				pst9.setString(5, "0");

				pst9.setString(7, "");
				pst9.setString(8, ib.getCardid());
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 
				Date dNow = new Date();

				
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
			
				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "0");
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {
					
					c = 0;
				}
				pst9.setString(12, "0");
				pst9.setString(13, paid_amt2);
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				pst9.setString(16, "");
				pst9.setString(17, "");
			
				k = pst9.executeUpdate();

			*//*}*/

			// Insurance
			/*else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {*//*

				pst9.setString(3, "INSURANCE");

				String paid_amt2 = "";
				String balace = "";
				String chek_amt = "";

				paid_amt2 = ib.getPaid_amt22();

				// chek_amt=ib.getNet_amountcard();
				balace = ib.getBalance_amt22();
				Integer c = 0;
				Integer a = 0;
				try {
					a = Integer.valueOf(paid_amt2);
				} catch (Exception e) {
					
					a = 0;
				}
				pst9.setString(4, paid_amt2);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {
					
					c = 0;
				}
				pst9.setString(5, balace);

				pst9.setString(7, "");
				pst9.setString(8, "0");
				pst9.setString(9, ib.getInsurance());

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 
				



				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, paid_amt2);

				pst9.setString(12, "0");
				pst9.setString(13, "0");
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				String d="";
				try{
					d=CoreData.getDateFormatAsDb(ib.getDate22());
					
				}catch (Exception e) {
					
				}
				
				pst9.setString(16, d);
				
				pst9.setString(17, "");
				
				k = pst9.executeUpdate();

			*//*}*/

			/*else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {*//*
				String paymode="";
				String paid_amt2 = "";
				String balace = "";
				String chek_amt = "";

				paid_amt2 = ib.getPaid_amt();

				if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
				{
					paymode=ib.getR1()+"~"+"CASH";
					pst9.setString(11, paid_amt2);
					pst9.setString(12, "0");
					pst9.setString(13, "0");
				
				}
				else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
				{
					
					paymode=ib.getR1()+"~"+"CHEQUE";
					pst9.setString(12, paid_amt2);
					pst9.setString(11, "0");
					pst9.setString(13, "0");
				}
				else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
				{
					paymode=ib.getR1()+"~"+"CARD";
		pst9.setString(11,"0");
					
					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);
					
				}
				else
				{
					paymode=ib.getPaymod();
						pst9.setString(11,"0");
					
					pst9.setString(12, "0");
					pst9.setString(13,"0");
				}
				
				

				pst9.setString(3, paymode);

				
				// chek_amt=ib.getNet_amountcard();
				balace = ib.getBalance_amt();
				Integer c = 0;
				Integer a = 0;
				try {
					a = Integer.valueOf(paid_amt2);
				} catch (Exception e) {
					
					a = 0;
				}
				pst9.setString(4, paid_amt2);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {
					
					c = 0;
				}
				pst9.setString(5, balace);

				pst9.setString(7, "");
				pst9.setString(8, "0");
				pst9.setString(9, "");

				

				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "0");

				pst9.setString(12, "0");
				pst9.setString(13, "0");
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
				
				
				k = pst9.executeUpdate();

			*//*}*/

			// card and cash

			/*else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {*//*

				pst9.setString(3, "CARDANDCASH");

				String paid_amt2 = "";
				String balace = "";
				String credit = "";

				paid_amt2 = ib.getCashhh();

				
				// chek_amt=ib.getNet_amountcard();
				credit = ib.getCarddd();
				Integer c = 0;
				Integer a = 0;
				Integer p = 0;
				try {
					a = Integer.valueOf(paid_amt2);
				} catch (Exception e) {
					
					a = 0;
				}

				try {
					c = Integer.valueOf(credit);
				} catch (Exception e) {
					
					c = 0;
				}

				p = (a + c);

				pst9.setString(4,""+p);
				
				 * try{ c = Integer.valueOf(balace); }catch (Exception e) { //
				 * TODO: handle exception c=0; }
				 
				pst9.setString(5, ""+0);

				pst9.setString(7, "");
				pst9.setString(8, ""+ib.getTrandi());
				pst9.setString(9, "");

				

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, ""+a);

				pst9.setString(12, ""+0);
				pst9.setString(13, ""+c);
				pst9.setString(14, ib.getTamount());
				pst9.setString(15, ib.getJob_Card_no());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
			
				k = pst9.executeUpdate();

			*//*}else{*/
				
				
			
				pst9.setString(3, "");
				
				//String paid_amt1 = "";

				//paid_amt1 = ib.getNet_amount();


				pst9.setString(4, "0");
				pst9.setString(5, "0");
				
				pst9.setString(7, "");
				
				pst9.setString(8, "0");
			
				pst9.setString(9, "");
			
			
				pst9.setString(2, (deliverymodel.getDate()));
				pst9.setNull(6, java.sql.Types.DATE);
				pst9.setString(11, "0");
				
				pst9.setString(12, "0");
				pst9.setString(13, "0");
				pst9.setString(14, deliverymodel.getTotal_amount1());
				pst9.setString(15, "");
				pst9.setString(16, "");
				
				pst9.setString(17, "");
			
				
				int k = pst9.executeUpdate();

				
				
			/*}*/
			
			
		/*}*/
			
			
			
			
			
		/*
			PreparedStatement preparedStatement1121 = con
					.prepareStatement("update  job_card set job_card_done_status='"
							+ 1 + "' where job_card_no=? ");

			preparedStatement1121.setString(1, ib.getJob_Card_no());

			j = preparedStatement1121.executeUpdate();

				response = "success";
			*/

			// update tax_datails
			response = "success";
			
			
			
			
			
			
			
			String qd = "delete  from invoice_tax_details where invoice_no=?";
			String inv2 = deliverymodel.getInvoiceno();
			String inv21 = " " + inv2;
			PreparedStatement pstdel = conn.prepareStatement(qd);
			pstdel.setString(1, inv21.trim());

			int n1 = pstdel.executeUpdate();

			int i = 0;
			int l1 = 0;
			String q1 = "insert into invoice_tax_details(invoice_no, type, descrip, qty, amt, vat_percent, tax_amt_percent, net_amt, type_name, cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty, LR_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst41 = conn.prepareStatement(q1);

			for (int j1 = 0; j1 < deliverymodel.getAmount().length; j1++) {

				if (!deliverymodel.getDescription()[j1].trim().equals("") && !deliverymodel.getDescription()[j1].trim().equals(null)) {
					
					pst41.setString(1, inv21.trim());
					

					/*String btype = "";

					try {
						btype = ib.getBtype()[j1];
					} catch (Exception e) {
						
						btype = "";
					}*/
					pst41.setString(2, "");

					// pst41.setString(2,"labour");

					pst41.setString(3, deliverymodel.getDescription()[j1]);

					Double amount = 0.0;
					double vatpercent = 0.0;
					double taxamount = 0.0;
					double netamount = 0.0;

					String amountlist = deliverymodel.getAmount()[j1];
					
					Double vatper = Double.parseDouble(deliverymodel.getGst_rate1()[j1]) +  Double.parseDouble(deliverymodel.getGst_rate2()[j1]);
					
					
					String vatpercentlist = String.valueOf(vatper);

					String taxamountlist = "";

					// String qty=ib.getQuantity1()[j1];
					// Integer Quantity1=0;
					String netamountlist = deliverymodel.getNet_amt()[j1];

					Double Quantity1 = 0.0;
					try {
						String qty = deliverymodel.getWeight()[j1];
					
						Quantity1 = Double.parseDouble(qty);
						;
					} catch (Exception e) {
						
						Quantity1 = 0.0;
					}

				
					pst41.setDouble(4, Quantity1);
					

					try {
						amount = Double.parseDouble(amountlist);
					} catch (Exception e) {
						
						amount = 0.0;
					}

					try {
						vatpercent = Double.parseDouble(vatpercentlist);
					} catch (Exception e) {
						
						vatpercent = 0;
					}

					try {
						taxamount = Double.parseDouble(taxamountlist);
					} catch (Exception e) {
						
						taxamount = 0;
					}
					try {
						netamount = Double.parseDouble(netamountlist);
					} catch (Exception e) {
						
						netamount = 0;
					}

					
					pst41.setDouble(5, amount);
					pst41.setDouble(6, vatpercent);

					pst41.setDouble(7, taxamount);
					pst41.setDouble(8, netamount);
					String ttype = "";

					try {
						ttype = deliverymodel.getHsn()[j1];
					} catch (Exception e) {
						
						ttype = "";
					}
					pst41.setString(9, ttype);
					
					pst41.setString(10, deliverymodel.getGst_rate1()[j1]);
					pst41.setString(11, deliverymodel.getGst_rate1amt()[j1]);
					pst41.setString(12, deliverymodel.getGst_rate2()[j1]);
					pst41.setString(13, deliverymodel.getGst_rate2amt()[j1]);
					pst41.setString(14, deliverymodel.getRate()[j1]);
					pst41.setString(15, "");
					pst41.setString(16, "");
					pst41.setString(17, "");
					pst41.setString(18, "");
					pst41.setString(19, "");
					pst41.setString(20, "");
					pst41.setString(21, "");
					pst41.setString(22, deliverymodel.getLr_number1()[j1]);
					i = i++;
					String sn = "" + i;

					deliverymodel.setSn(sn);

					l1 = pst41.executeUpdate();

				}
				
				
				String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
				 inv2 = deliverymodel.getInvoiceno();
				 inv21 = " " + inv2;
				PreparedStatement pstdel1 = conn.prepareStatement(qd1);
				pstdel1.setString(1, inv21.trim());

				int n12 = pstdel1.executeUpdate();
			
						PreparedStatement preparedStatement112zz = conn.prepareStatement("select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
						System.out.println("preparedStatement112"+preparedStatement112zz);
					ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

					while (resultSet12zz.next()) {
						
					query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
					PreparedStatement pst41z = conn.prepareStatement(query);
					
					pst41z.setString(1, inv21.trim());	
					pst41z.setString(2, resultSet12zz.getString("type_name"));	
					pst41z.setString(3, resultSet12zz.getString("cgstrate"));	
					pst41z.setString(4, resultSet12zz.getString("sgstrate"));	
					pst41z.setString(5, resultSet12zz.getString("cgstamount"));	
					pst41z.setString(6, resultSet12zz.getString("sgstamount"));	
					pst41z.setString(7, resultSet12zz.getString("vat_percent"));	
					pst41z.setString(8, resultSet12zz.getString("taxablevalue"));	
					System.out.println(pst41z);
					pst41z.executeUpdate();
					}
					
				
				if (l1 > 0 && n1 > 0) {
					response = "success";
				} else {
					response = "fail";

				}

			}

			// --------------

			// update taxcollection details

			PreparedStatement psdt = conn.prepareStatement("delete from invoice_tax_collection where invoice_no = '"+deliverymodel.getInvoiceno()+"'");
			int del = psdt.executeUpdate();
			
			System.out.println("del "+del);
			
			String  q2 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";
		 	
			 int js = 0;
			 PreparedStatement pst41a = conn.prepareStatement(q2);
			 
			 if(deliverymodel.getDescription()[0] != "" ){
			for (int j1 = 0; j1 < 3; j1++) {

				
				if(j1==0)
				{
					pst41a.setString(1, deliverymodel.getInvoiceno());
					pst41a.setString(2, "CGST");
					pst41a.setDouble(3, 0);
					pst41a.setDouble(4, Double.parseDouble(deliverymodel.getCgst()));
					pst41a.setString(5, (deliverymodel.getDate()));
					
					
					js = pst41a.executeUpdate();
				}
				
				if(j1==1)
				{
					pst41a.setString(1, deliverymodel.getInvoiceno());
					pst41a.setString(2, "SGST");
					pst41a.setDouble(3, 0);
					pst41a.setDouble(4, Double.parseDouble(deliverymodel.getSgst()));
					pst41a.setString(5, (deliverymodel.getDate()));
					
					
					js = pst41a.executeUpdate();
				}
				
				if(j1==2)
				{
					pst41a.setString(1, deliverymodel.getInvoiceno());
					pst41a.setString(2, "Total Tax Amount");
					pst41a.setDouble(3, 0);
					pst41a.setDouble(4, Double.parseDouble(deliverymodel.getTotal_tax_amount()));
					pst41a.setString(5, (deliverymodel.getDate()));
					
					
					js = pst41a.executeUpdate();
				}
				
				
				System.out.println("21");
				if (js > 0) {
					response = "success";
				} else {
					response = "fail";

				}
			}
				// pst41.setString(2,"labour");

			}

			try{
				
				DBConnection connection1=new DBConnection();Connection con1 = connection1.getConnection();
					
				
			}catch(Exception e){}

		}

	}

	
		
		
		
		
		
		
		return response;
		
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
		
		return response;
}


	public List<DeliveryModel> fetchCommDetails(String transporter_name, String from_date, String to_date, String trip_id) {
		// TODO Auto-generated method stub
		String trans[] = transporter_name.split("-");
		
		List<DeliveryModel> list = new ArrayList<>();
		try {
			
			if(trip_id.equals("") || trip_id.equals(null))
			{
				PreparedStatement pst = conn.prepareStatement("select * from commission where transporter_code='"+trans[1]+"'");
				ResultSet rs = pst.executeQuery();
				System.out.println("pst transporter : "+pst);
				
				
				double sum = 0;
				while(rs.next())
				{
					PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done where LR_no = '"+rs.getString("LR_no")+"' and date between '"+from_date+"' and '"+to_date+"'");
					ResultSet rs1 = pst1.executeQuery();
					
					System.out.println("pst1 : "+pst1);
					
				
					
					if(rs1.next())
					{
						DeliveryModel model = new DeliveryModel();
						
							model.setTransporter_name(rs.getString("transporter_name"));
						
						
						System.out.println("transporter name: "+model.getTransporter_name());
						model.setTrip_id(rs.getString("trip_id"));
						model.setUpdown_id(rs.getString("updown_id"));
						model.setLr_number(rs.getString("LR_no"));
						model.setCustomer_name(rs1.getString("customer_name"));
						model.setDate(rs1.getString("date"));
						model.setSource(rs.getString("source"));
						model.setDestination(rs.getString("destination"));
						model.setCommision(rs.getString("commission_amount"));
						
						sum = sum + Double.parseDouble(model.getCommision());
						
						model.setComm_sum(String.valueOf(sum));
						System.out.println("33");
						list.add(model);
						System.out.println("44");
					}
					
				}
				
				
				
				
			}
			
			else if(transporter_name.equals("") || transporter_name.equals(null))
			{
				PreparedStatement pst = conn.prepareStatement("select * from commission where trip_id='"+trip_id+"'");
				ResultSet rs = pst.executeQuery();
				System.out.println("pst trip : "+pst);
				
				
				double sum = 0;
				while(rs.next())
				{
					PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done where LR_no = '"+rs.getString("LR_no")+"' and date between '"+from_date+"' and '"+to_date+"'");
					ResultSet rs1 = pst1.executeQuery();
					
					System.out.println("pst1 : "+pst1);
					
				
					
					if(rs1.next())
					{
						DeliveryModel model = new DeliveryModel();
						
						model.setTransporter_name(rs.getString("transporter_name"));
						
						
						System.out.println("transporter name: "+model.getTransporter_name());
						model.setTrip_id(rs.getString("trip_id"));
						model.setUpdown_id(rs.getString("updown_id"));
						model.setLr_number(rs.getString("LR_no"));
						model.setCustomer_name(rs1.getString("customer_name"));
						model.setDate(rs1.getString("date"));
						model.setSource(rs.getString("source"));
						model.setDestination(rs.getString("destination"));
						model.setCommision(rs.getString("commission_amount"));
						
						sum = sum + Double.parseDouble(model.getCommision());
						
						model.setComm_sum(String.valueOf(sum));
						System.out.println("33");
						list.add(model);
						System.out.println("44");
					}
					
				}
			}
			
			else
			{
				PreparedStatement pst = conn.prepareStatement("select * from commission where trip_id='"+trip_id+"' and transporter_code='"+trans[1]+"'");
				ResultSet rs = pst.executeQuery();
				System.out.println("pst trip and transporter : "+pst);
				
				
				double sum = 0;
				while(rs.next())
				{
					PreparedStatement pst1 = conn.prepareStatement("select * from delivery_done where LR_no = '"+rs.getString("LR_no")+"' and date between '"+from_date+"' and '"+to_date+"'");
					ResultSet rs1 = pst1.executeQuery();
					
					System.out.println("pst1 : "+pst1);
					
				
					
					if(rs1.next())
					{
						DeliveryModel model = new DeliveryModel();
						
							model.setTransporter_name(rs.getString("transporter_name"));
						
						
						System.out.println("transporter name: "+model.getTransporter_name());
						model.setTrip_id(rs.getString("trip_id"));
						model.setUpdown_id(rs.getString("updown_id"));
						model.setLr_number(rs.getString("LR_no"));
						model.setCustomer_name(rs1.getString("customer_name"));
						model.setDate(rs1.getString("date"));
						model.setSource(rs.getString("source"));
						model.setDestination(rs.getString("destination"));
						model.setCommision(rs.getString("commission_amount"));
						
						sum = sum + Double.parseDouble(model.getCommision());
						
						model.setComm_sum(String.valueOf(sum));
						System.out.println("33");
						list.add(model);
						System.out.println("44");
					}
					
				}
				
			}
			
			//System.out.println("pst : "+pst);
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	public List<DeliveryModel> fetchProfitDetails(String from_date, String to_date, String trip_id, String source, String destination, String drv_code) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		try {
			
			int sno = 1;
			String cond="";
			/*String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];*/
			
			
			if(!trip_id.equals("")){
				cond= "  and trip_id like '%"+trip_id+"%' ";
				
			}
			
			if(!source.equals("")){
				cond= "  and source like '%"+source+"%' ";
				
			}
			
			if(!destination.equals("")){
				cond= "  and destination like '%"+destination+"%' ";
				
			}
			
			if(!drv_code.equals("")){
				cond= "  and driver_code like '%"+drv_code+"%' ";
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("select distinct trip_id from lr");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setTrip_id(rs.getString(1));
				
				/*PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from tripissue where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setTrip_expense(rs1.getString(1));
					else
						model.setTrip_expense("0");
				}
				
				
				PreparedStatement pst2 = conn.prepareStatement("select sum(exp_amount) from updown_issue where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					if(rs2.getString(1)!= null && !rs2.getString(1).isEmpty())
						model.setUpdown_expense(rs2.getString(1));
					else
						model.setUpdown_expense("0");
				}
				
				
				double sum = 0;
				
				PreparedStatement pst3 = conn.prepareStatement("select distinct LR_no from lr where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs3 = pst3.executeQuery();
				System.out.println("pst3: "+pst3);
				
				while(rs3.next())
				{
					PreparedStatement pst4 = conn.prepareStatement("select sum(exp_amount) from trip_issue where LR_no = '"+rs3.getString(1)+"'");
					ResultSet rs4 = pst4.executeQuery();
					System.out.println("pst4: "+pst4);
					
					if(rs4.next())
					{
						//string != null && !string.isEmpty()
						if(rs4.getString(1)!= null && !rs4.getString(1).isEmpty())
							sum = sum + Double.parseDouble(rs4.getString(1));
						
						System.out.println("sum: "+sum);
					}
				}
				
				model.setLr_expense(String.valueOf(sum));
				
				double total_expense = Double.parseDouble(model.getTrip_expense()) + Double.parseDouble(model.getUpdown_expense()) + sum;*/
				PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from issue_expenses where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				double total_expense = 0;
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
					{
						model.setTrip_expense(rs1.getString(1));
						total_expense = Double.parseDouble(model.getTrip_expense());
					}
					else
						model.setTrip_expense("0");
				}
				
				
				
				
				
				model.setTotal_expense(model.getTrip_expense());
				
				double total = 0;
				PreparedStatement pst5 = conn.prepareStatement("select sum(total_amount) from lr where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs5 = pst5.executeQuery();
				System.out.println("pst5: "+pst5);
				
				if(rs5.next())
				{
					model.setTotal_amount(rs5.getString(1));
					total = Double.parseDouble(model.getTotal_amount());
				}
				
				double comm_total = 0;
				PreparedStatement pst05 = conn.prepareStatement("select sum(commission_amount) from commission where trip_id ='"+model.getTrip_id()+"'");
				ResultSet rs06 = pst05.executeQuery();
				if(rs06.next())
				{
					model.setCommision(rs06.getString(1));
					
					if(rs06.getString(1)!=null)
						comm_total = Double.parseDouble(model.getCommision());
				}
				
				
				double profit = total - total_expense - comm_total;
				model.setProfit(String.valueOf(profit));
				
				PreparedStatement pst6 = conn.prepareStatement("select * from trip where trip_id = '"+model.getTrip_id()+"' and date between '"+from_date+"' and '"+to_date+"' "+cond);
				ResultSet rs6 = pst6.executeQuery();
				System.out.println("pst6: "+pst6);
				
				if(rs6.next())
				{
					model.setSource(rs6.getString("source"));
					model.setDestination(rs6.getString("destination"));
					model.setVehicle_no(rs6.getString("vehicle_no"));
					model.setDriver_name(rs6.getString("driver_name"));
					model.setDate(rs6.getString("date"));
					
					
					list.add(model);
				}
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}


	public boolean send_ready_sms(DeliveryModel deliverymodel) {
		// TODO Auto-generated method stub
		Properties systemPropery = null;
		//Connection connection=DaoHelper.getConnection();
		systemPropery = new Properties();
		try {
			systemPropery.load(new  DeliveryDoneDao().getClass()
					.getResourceAsStream(
							"/com/master/dao/UserProfile.properties"));
			
			String userid = systemPropery.getProperty("USERID");
			String senderid = systemPropery.getProperty("SENDERID");
			String pass = systemPropery.getProperty("SMSPASS");
			String mobile = systemPropery.getProperty("MOBILE");
			
			
			String companyname = "";
			PreparedStatement pst = conn.prepareStatement("select companyname from settings");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) 
			{
				companyname = rs.getString(1);
			}
			
			String short_materials = "";
			String desc = "";
			
			
			for(int i=0; i<deliverymodel.getDescription().length; i++)
			{
				
				if(Integer.parseInt(deliverymodel.getShort_weight()[i])>0)
				{
					desc = desc + "'"+deliverymodel.getDescription()[i];
					short_materials = short_materials + "'" + deliverymodel.getShort_weight()[i];
				}
			}
			
			
			
			
			String requestUrl = "http://bhashsms.com/api/sendmsg.php?user="
					+ userid
					+ "&pass="
					+ pass
					+ "&sender="
					+ senderid
					+ "&phone="
					+ mobile
					+ "&text=Dear, "
					
					+ ", short weights of materials  "+desc+" are  "+short_materials+" for LR No. "+deliverymodel.getLr_number()+". . &priority=ndnd&stype=normal";

					
					requestUrl = requestUrl.replace(" ", "%20");
					
					System.out.println(requestUrl);
					URL url = new URL(requestUrl);

					HttpURLConnection uc = (HttpURLConnection) url
							.openConnection();
					uc.addRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

					System.out.println(uc.getResponseMessage());

					uc.disconnect();
	}	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return false;
}


	public List<DeliveryModel> getTransportBussReduce() {
		// TODO Auto-generated method stub
		
		List<DeliveryModel> list = new ArrayList<>();
		
		java.util.Date dt = new java.util.Date();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date dt1 = cal.getTime();
		
		cal.add(Calendar.MONTH, -1);
		Date dt2 = cal.getTime();
		
		
		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		String beforeOne = sdf.format(dt1);
		String beforeTwo = sdf.format(dt2);
		
		System.out.println("currentTime: "+currentTime);
		System.out.println("beforeOne: "+beforeOne);
		System.out.println("beforeTwo: "+beforeTwo);
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select distinct transporter_code from commission");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			
			while(rs.next())
			{
				
				
				
				
				double this_month = 0;
				double previous_month = 0;
				DeliveryModel model = new DeliveryModel();
				
				PreparedStatement pst1 = conn.prepareStatement("select * from commission where transporter_code = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				
				
				
				
				
				System.out.println("pst1: "+pst1);
				
				while(rs1.next())
				{
					
					
					model.setTransporter_code(rs1.getString("transporter_code"));
					model.setTransporter_name(rs1.getString("transporter_name"));
					
					PreparedStatement pst2 = conn.prepareStatement("select LR_no from delivery_done where date between '"+beforeOne+"' and '"+currentTime+"' and LR_no = '"+rs1.getString("LR_no")+"'");
					ResultSet rs2 = pst2.executeQuery();
					
					PreparedStatement pst22 = conn.prepareStatement("select LR_no from delivery_done where date between '"+beforeTwo+"' and '"+beforeOne+"' and LR_no = '"+rs1.getString("LR_no")+"'");
					ResultSet rs22 = pst22.executeQuery();
					
					System.out.println("pst2: "+pst2);
					
					
					
					if(rs2.next())
					{
						PreparedStatement pst3 = conn.prepareStatement("select sum(commission_amount) from commission where LR_no = '"+rs2.getString(1)+"'");
						ResultSet rs3 = pst3.executeQuery();
						
						System.out.println("pst3: "+pst3);
						
						if(rs3.next())
						{
							this_month = this_month + Double.parseDouble(rs3.getString(1));
						}
					}
					
					
					if(rs22.next())
					{
						PreparedStatement pst33 = conn.prepareStatement("select sum(commission_amount) from commission where LR_no = '"+rs22.getString(1)+"'");
						System.out.println("pst33 previous: "+pst33);
						ResultSet rs33 = pst33.executeQuery();
						
						System.out.println("pst33 previous: "+pst33);
						
						if(rs33.next())
						{
							previous_month = previous_month + Double.parseDouble(rs33.getString(1));
						}
					}
					
					
					/*PreparedStatement pst21 = conn.prepareStatement("select LR_no from delivery_done where date between '"+beforeTwo+"' and '"+beforeOne+"' and LR_no = '"+rs1.getString("LR_no")+"'");
					ResultSet rs21 = pst21.executeQuery();
					
					System.out.println("pst21: "+pst21);
					
					while(rs21.next())
					{
						PreparedStatement pst31 = conn.prepareStatement("select sum(commission_amount) from commission where LR_no = '"+rs2.getString(1)+"'");
						ResultSet rs31 = pst31.executeQuery();
						
						System.out.println("pst31: "+pst31);
						
						if(rs31.next())
						{
							previous_month = previous_month + Double.parseDouble(rs31.getString(1));
						}
					}*/
					
					
				}
				
				System.out.println("this_month : "+this_month);
				System.out.println("previous_month : "+previous_month);
				if(this_month<previous_month)
				{
					
					model.setThis_month(String.valueOf(this_month));
					model.setPrevious_month(String.valueOf(previous_month));
					
					list.add(model);
				}
				
				
				
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}


	public List<DeliveryModel> fetchVehicleProfitDetails(String vehicle_no, String from_date, String to_date) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int sno = 1;
		String cond="";
		/*String[] drv = tripModel.getDriver_name().split("-");
		String drv_name = drv[0];*/
		
		
		if(!vehicle_no.equals("")){
			cond= "  and vehicle_no like '%"+vehicle_no+"%' ";
			
		}
		
		
		
		
		
		List<DeliveryModel> list = new ArrayList<>();
		try {
			
			PreparedStatement pst = conn.prepareStatement("select distinct vehicle_no from lr where date between '"+from_date+"' and '"+to_date+"' "+cond);
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setVehicle_no(rs.getString(1));
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from issue_expenses where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setTrip_expense(rs1.getString(1));
					else
						model.setTrip_expense("0");
				}
				
				
				/*PreparedStatement pst2 = conn.prepareStatement("select sum(exp_amount) from updown_issue where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					if(rs2.getString(1)!= null && !rs2.getString(1).isEmpty())
						model.setUpdown_expense(rs2.getString(1));
					else
						model.setUpdown_expense("0");
				}*/
				
				
				double sum = 0;
				
				/*PreparedStatement pst3 = conn.prepareStatement("select distinct LR_no from lr where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs3 = pst3.executeQuery();
				System.out.println("pst3: "+pst3);
				
				while(rs3.next())
				{
					PreparedStatement pst4 = conn.prepareStatement("select sum(exp_amount) from trip_issue where LR_no = '"+rs3.getString(1)+"'");
					ResultSet rs4 = pst4.executeQuery();
					System.out.println("pst4: "+pst4);
					
					if(rs4.next())
					{
						//string != null && !string.isEmpty()
						if(rs4.getString(1)!= null && !rs4.getString(1).isEmpty())
							sum = sum + Double.parseDouble(rs4.getString(1));
						
						System.out.println("sum: "+sum);
					}
				}
				
				model.setLr_expense(String.valueOf(sum));
				*/
				double total_expense = Double.parseDouble(model.getTrip_expense());
				
				model.setTotal_expense(String.valueOf(total_expense));
				
				double total = 0;
				PreparedStatement pst5 = conn.prepareStatement("select sum(total_amount) from lr where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs5 = pst5.executeQuery();
				System.out.println("pst5: "+pst5);
				
				if(rs5.next())
				{
					model.setTotal_amount(rs5.getString(1));
					total = Double.parseDouble(model.getTotal_amount());
				}
				
				
				double comm_total = 0;
				PreparedStatement pst05 = conn.prepareStatement("select distinct LR_no from lr where vehicle_no = '"+model.getVehicle_no()+"'");
				ResultSet rs05 = pst05.executeQuery();
				while(rs05.next())
				{
					PreparedStatement pst005 = conn.prepareStatement("select sum(commission_amount) from commission where LR_no = '"+rs05.getString(1)+"'");
					ResultSet rs005 = pst005.executeQuery();
					if(rs005.next())
					{
						if(rs005.getString(1)!=null)
							comm_total = comm_total + Double.parseDouble(rs005.getString(1));
					}
				}
				
				
				model.setCommision(String.valueOf(comm_total));
				
				double profit = total - total_expense - comm_total;
				model.setProfit(String.valueOf(profit));
				
				/*PreparedStatement pst6 = conn.prepareStatement("select * from trip where vehicle_no = '"+model.getVehicle_no()+"'");
				ResultSet rs6 = pst6.executeQuery();
				System.out.println("pst6: "+pst6);
				
				if(rs6.next())
				{
					model.setSource(rs6.getString("source"));
					model.setDestination(rs6.getString("destination"));
					model.setVehicle_no(rs6.getString("vehicle_no"));
					model.setDriver_name(rs6.getString("driver_name"));
				}*/
				
				
				list.add(model);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list;
	
	}


	public List<DeliveryModel> fetchSaleDetails(String from_date, String to_date) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement("select * from invoice where date between '"+from_date+"' and '"+to_date+"'");
			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				model.setInvoiceno(rs.getString("invoice_no"));
				model.setCustomer_no(rs.getString("vehicle_no"));
				model.setTotal_amount(rs.getString("total"));
				model.setDate(rs.getString("date").substring(0, 10));
				
				
				
				System.out.println("date: "+model.getDate());
				
				PreparedStatement pst1 = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getCustomer_no()+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					model.setCustomer_name(rs1.getString("customer_name"));
					model.setGstin_no(rs1.getString("customer_gst_no"));
				}
				
				
				
				Double tcgst25=0.0;
				Double tcgst6=0.0;
				Double tcgst9=0.0;
				Double tcgst14=0.0;
				
				Double tsgst25=0.0;
				Double tsgst6=0.0;
				Double tsgst9=0.0;
				Double tsgst14=0.0;
				
				
				PreparedStatement pst2 = conn.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='2.5' group by  invoice_no");
				pst2.setString(1, model.getInvoiceno());
				ResultSet rs2 = pst2.executeQuery();
				
				if(rs2.next())
				{
					model.setCgst25(rs2.getString("nmt"));
				}
				
				PreparedStatement pst3 = conn.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='6.0' group by  invoice_no");
				pst3.setString(1, model.getInvoiceno());
				ResultSet rs3 = pst3.executeQuery();
				
				if(rs3.next())
				{
					model.setCgst6(rs3.getString("nmt"));
				}
				
				PreparedStatement pst4 = conn.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='9.0' group by  invoice_no");
				pst4.setString(1, model.getInvoiceno());
				ResultSet rs4 = pst4.executeQuery();
				
				if(rs4.next())
				{
					model.setCgst9(rs4.getString("nmt"));
				}
				
				PreparedStatement pst5 = conn.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='14.0' group by  invoice_no");
				pst5.setString(1, model.getInvoiceno());
				ResultSet rs5 = pst5.executeQuery();
				
				if(rs5.next())
				{
					model.setCgst14(rs5.getString("nmt"));
				}
				
				PreparedStatement pst6 = conn.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='2.5' group by  invoice_no");
				pst6.setString(1, model.getInvoiceno());
				ResultSet rs6 = pst6.executeQuery();
				
				if(rs6.next())
				{
					model.setSgst25(rs6.getString("nmt"));
				}
				
				PreparedStatement pst7 = conn.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='6.0' group by  invoice_no");
				pst7.setString(1, model.getInvoiceno());
				ResultSet rs7 = pst7.executeQuery();
				
				if(rs7.next())
				{
					model.setSgst6(rs7.getString("nmt"));
				}
				
				PreparedStatement pst8 = conn.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='9.0' group by  invoice_no");
				pst8.setString(1, model.getInvoiceno());
				ResultSet rs8 = pst8.executeQuery();
				
				if(rs8.next())
				{
					model.setSgst9(rs8.getString("nmt"));
				}
				
				
				PreparedStatement pst9 = conn.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='14.0' group by  invoice_no");
				pst9.setString(1, model.getInvoiceno());
				ResultSet rs9 = pst9.executeQuery();
				
				if(rs9.next())
				{
					model.setSgst14(rs9.getString("nmt"));
				}
				
				
				
				list.add(model);
				
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}


	public String getvehicleGraph() {
		// TODO Auto-generated method stub
		String a = "";
		String report = "";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select distinct vehicle_no from lr");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setVehicle_no(rs.getString(1));
				report += rs.getString(1)+ "~";
				
				
				double total = 0;
				PreparedStatement pst5 = conn.prepareStatement("select sum(total_amount) from lr where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs5 = pst5.executeQuery();
				System.out.println("pst5: "+pst5);
				
				if(rs5.next())
				{
					report +=rs5.getString(1)+"~"; 
					model.setTotal_amount(rs5.getString(1));
					total = Double.parseDouble(model.getTotal_amount());
				}
				else
				{
					report += "0" + "~";
				}
				
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from issue_expenses where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setTrip_expense(rs1.getString(1));
					else
						model.setTrip_expense("0");
				}
				
				
				/*PreparedStatement pst2 = conn.prepareStatement("select sum(exp_amount) from updown_issue where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					if(rs2.getString(1)!= null && !rs2.getString(1).isEmpty())
						model.setUpdown_expense(rs2.getString(1));
					else
						model.setUpdown_expense("0");
				}
				
				
				double sum = 0;
				
				PreparedStatement pst3 = conn.prepareStatement("select distinct LR_no from lr where vehicle_no = '"+rs.getString(1)+"'");
				ResultSet rs3 = pst3.executeQuery();
				System.out.println("pst3: "+pst3);
				
				while(rs3.next())
				{
					PreparedStatement pst4 = conn.prepareStatement("select sum(exp_amount) from trip_issue where LR_no = '"+rs3.getString(1)+"'");
					ResultSet rs4 = pst4.executeQuery();
					System.out.println("pst4: "+pst4);
					
					if(rs4.next())
					{
						//string != null && !string.isEmpty()
						if(rs4.getString(1)!= null && !rs4.getString(1).isEmpty())
							sum = sum + Double.parseDouble(rs4.getString(1));
						
						System.out.println("sum: "+sum);
					}
				}
				
				model.setLr_expense(String.valueOf(sum));
				*/
				/*double total_expense = Double.parseDouble(model.getTrip_expense()) + Double.parseDouble(model.getUpdown_expense()) + sum;*/
				double total_expense = Double.parseDouble(model.getTrip_expense());
				
				model.setTotal_expense(String.valueOf(total_expense));
				
				report+= String.valueOf(total_expense)+"#";
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		report = report.substring(0,report.length() - 1);
		return report;
	}


	public List<DeliveryModel> fetchUpDownProfitDetails(String from_date, String to_date, String trip_id,
			String updown_id, String source, String destination, String drv_code) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		try {
			
			int sno = 1;
			String cond="";
			/*String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];*/
			
			
			if(!trip_id.equals("")){
				cond= "  and trip_id like '%"+trip_id+"%' ";
				
			}
			
			if(!updown_id.equals("")){
				cond= "  and updown_id like '%"+updown_id+"%' ";
				
			}
			
			if(!source.equals("")){
				cond= "  and source like '%"+source+"%' ";
				
			}
			
			if(!destination.equals("")){
				cond= "  and destination like '%"+destination+"%' ";
				
			}
			
			if(!drv_code.equals("")){
				cond= "  and driver_code like '%"+drv_code+"%' ";
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("select distinct updown_id from lr");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setUpdown_id(rs.getString(1));
				
				/*PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from updown_issue where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setUpdown_expense(rs1.getString(1));
					else
						model.setUpdown_expense("0");
				}
				*/
				
				/*PreparedStatement pst2 = conn.prepareStatement("select sum(exp_amount) from updown_issue where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					if(rs2.getString(1)!= null && !rs2.getString(1).isEmpty())
						model.setUpdown_expense(rs2.getString(1));
					else
						model.setUpdown_expense("0");
				}*/
				
				
				//double sum = 0;
				
				/*PreparedStatement pst3 = conn.prepareStatement("select LR_no, trip_id from lr where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs3 = pst3.executeQuery();
				System.out.println("pst3: "+pst3);
				
				while(rs3.next())
				{
					model.setTrip_id(rs3.getString(2));
					
					PreparedStatement pst4 = conn.prepareStatement("select sum(exp_amount) from trip_issue where LR_no = '"+rs3.getString(1)+"'");
					ResultSet rs4 = pst4.executeQuery();
					System.out.println("pst4: "+pst4);
					
					if(rs4.next())
					{
						//string != null && !string.isEmpty()
						if(rs4.getString(1)!= null && !rs4.getString(1).isEmpty())
							sum = sum + Double.parseDouble(rs4.getString(1));
						
						System.out.println("sum: "+sum);
					}
				}
				
				model.setLr_expense(String.valueOf(sum));*/
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from issue_expenses where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setUpdown_expense(rs1.getString(1));
					else
						model.setUpdown_expense("0");
				}
				
				
				double total_expense = Double.parseDouble(model.getUpdown_expense());
				
				model.setTotal_expense(String.valueOf(total_expense));
				
				double total = 0;
				PreparedStatement pst5 = conn.prepareStatement("select sum(total_amount) from lr where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs5 = pst5.executeQuery();
				System.out.println("pst5: "+pst5);
				
				if(rs5.next())
				{
					model.setTotal_amount(rs5.getString(1));
					total = Double.parseDouble(model.getTotal_amount());
				}
				
				
				double comm_amt = 0;
				PreparedStatement pst05 = conn.prepareStatement("select sum(commission_amount) from commission where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs05 = pst05.executeQuery();
				System.out.println("pst05: "+pst05);
				
				if(rs05.next())
				{
					model.setCommision(rs05.getString(1));
					//total = Double.parseDouble(model.getTotal_amount());
					if(rs05.getString(1) != null )
					{
						comm_amt = Double.parseDouble(rs05.getString(1));
					}
				}
				
				System.out.println("comm_amt: "+comm_amt);
				
				
				double profit = total - total_expense - comm_amt ;
				model.setProfit(String.valueOf(profit));
				
				/*PreparedStatement pst6 = conn.prepareStatement("select * from updown where updown_id = '"+model.getUpdown_id()+"' and date between '"+from_date+"' and '"+to_date+"' "+cond);*/
				PreparedStatement pst6 = conn.prepareStatement("select * from updown where updown_id = '"+model.getUpdown_id()+"' and date between '"+from_date+"' and '"+to_date+"' "+cond);
				ResultSet rs6 = pst6.executeQuery();
				System.out.println("pst6: "+pst6);
				
				if(rs6.next())
				{
					model.setSource(rs6.getString("source"));
					model.setDestination(rs6.getString("destination"));
					model.setVehicle_no(rs6.getString("vehicle_no"));
					model.setDriver_name(rs6.getString("driver_name"));
					model.setDate(rs6.getString("date"));
					model.setTrip_id(rs6.getString("trip_id"));
					
					list.add(model);
				}
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}


	public List<DeliveryModel> fetchLRProfitDetails(String from_date, String to_date, String trip_id, String updown_id,
			String source, String destination, String drv_code, String cust_code, String lr_number) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		try {
			
			int sno = 1;
			String cond="";
			/*String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];*/
			
			
			if(!trip_id.equals("")){
				cond= "  and trip_id like '%"+trip_id+"%' ";
				
			}
			
			if(!updown_id.equals("")){
				cond= "  and updown_id like '%"+updown_id+"%' ";
				
			}
			
			if(!lr_number.equals("")){
				cond= "  and LR_no like '%"+lr_number+"%' ";
				
			}
			
			if(!source.equals("")){
				cond= "  and source like '%"+source+"%' ";
				
			}
			
			if(!destination.equals("")){
				cond= "  and destination like '%"+destination+"%' ";
				
			}
			
			if(!drv_code.equals("")){
				cond= "  and driver_code like '%"+drv_code+"%' ";
				
			}
			
			if(!cust_code.equals("")){
				cond= "  and customer_no like '%"+cust_code+"%' ";
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("select distinct LR_no from lr");
			ResultSet rs = pst.executeQuery();
			
			System.out.println("pst: "+pst);
			
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setLr_number(rs.getString(1));
				
				/*PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from updown_issue where updown_id = '"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				
				
				if(rs1.next())
				{
					if(rs1.getString(1)!= null && !rs1.getString(1).isEmpty())
						model.setUpdown_expense(rs1.getString(1));
					else
						model.setUpdown_expense("0");
				}*/
				
				
				/*PreparedStatement pst2 = conn.prepareStatement("select sum(exp_amount) from updown_issue where trip_id = '"+rs.getString(1)+"'");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					if(rs2.getString(1)!= null && !rs2.getString(1).isEmpty())
						model.setUpdown_expense(rs2.getString(1));
					else
						model.setUpdown_expense("0");
				}*/
				
				
				double sum = 0;
				
				PreparedStatement pst3 = conn.prepareStatement("select LR_no, trip_id, updown_id from lr where LR_no = '"+rs.getString(1)+"'");
				ResultSet rs3 = pst3.executeQuery();
				System.out.println("pst3: "+pst3);
				
				while(rs3.next())
				{
					model.setTrip_id(rs3.getString(2));
					model.setUpdown_id(rs3.getString(3));
					
					PreparedStatement pst4 = conn.prepareStatement("select sum(exp_amount) from issue_expenses where LR_no = '"+rs3.getString(1)+"'");
					ResultSet rs4 = pst4.executeQuery();
					System.out.println("pst4: "+pst4);
					
					if(rs4.next())
					{
						//string != null && !string.isEmpty()
						if(rs4.getString(1)!= null && !rs4.getString(1).isEmpty())
							sum = sum + Double.parseDouble(rs4.getString(1));
						
						System.out.println("sum: "+sum);
					}
				}
				
				model.setLr_expense(String.valueOf(sum));
				
				double total_expense = sum;
				
				model.setTotal_expense(String.valueOf(total_expense));
				
				double total = 0;
				PreparedStatement pst5 = conn.prepareStatement("select sum(total_amount) from lr where LR_no = '"+rs.getString(1)+"'");
				ResultSet rs5 = pst5.executeQuery();
				System.out.println("pst5: "+pst5);
				
				if(rs5.next())
				{
					model.setTotal_amount(rs5.getString(1));
					total = Double.parseDouble(model.getTotal_amount());
				}
				
				double comm_amt = 0;
				PreparedStatement pst05 = conn.prepareStatement("select sum(commission_amount) from commission where LR_no = '"+rs.getString(1)+"'");
				ResultSet rs05 = pst05.executeQuery();
				System.out.println("pst5: "+pst05);
				
				if(rs05.next())
				{
					model.setCommision(rs05.getString(1));
					if(rs05.getString(1)!=null)
						comm_amt = Double.parseDouble(model.getCommision());
				}
				
				
				
				
				double profit = total - total_expense - comm_amt;
				model.setProfit(String.valueOf(profit));
				
				/*PreparedStatement pst6 = conn.prepareStatement("select * from updown where updown_id = '"+model.getUpdown_id()+"' and date between '"+from_date+"' and '"+to_date+"' "+cond);*/
				PreparedStatement pst6 = conn.prepareStatement("select * from lr where LR_no = '"+model.getLr_number()+"' and date between '"+from_date+"' and '"+to_date+"' "+cond);
				ResultSet rs6 = pst6.executeQuery();
				System.out.println("pst6: "+pst6);
				
				if(rs6.next())
				{
					model.setSource(rs6.getString("source"));
					model.setDestination(rs6.getString("destination"));
					model.setVehicle_no(rs6.getString("vehicle_no"));
					model.setDriver_name(rs6.getString("driver_name"));
					model.setDate(rs6.getString("date"));
					model.setCustomer_name(rs6.getString("customer_name"));
					
					list.add(model);
				}
				
				
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}


	public List<DeliveryModel> getInvoiceDetails(String invoice_no) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		try {
			PreparedStatement pst001 = conn.prepareStatement("select * from invoice_tax_details where invoice_no = '"+invoice_no+"'");
			ResultSet rs001 = pst001.executeQuery();
			
			while(rs001.next())
			{
				DeliveryModel model = new DeliveryModel();
				model.setDescription1(rs001.getString("descrip"));
				model.setWeight1(rs001.getString("qty"));
				model.setRate1(rs001.getString("rate"));
				model.setAmount1(rs001.getString("amt"));
				model.setNet_amt1(rs001.getString("net_amt"));
				model.setHsn1(rs001.getString("type_name"));
				model.setGstrate1(rs001.getString("cgstrate"));
				model.setGstamt1(rs001.getString("cgstamount"));
				model.setGstrate2(rs001.getString("sgstrate"));
				model.setGstamt2(rs001.getString("sgstamount"));
				
				list.add(model);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}


	public DeliveryModel getInvoiceDetails1(String invoice_no) {
		// TODO Auto-generated method stub
		DeliveryModel model = new DeliveryModel();
		try {
			
			PreparedStatement pst001 = conn.prepareStatement("select * from invoice where invoice_no= '"+invoice_no+"'");
			ResultSet rs001 = pst001.executeQuery();
			
			String cust_code = "";
			
			if(rs001.next())
			{
				cust_code = rs001.getString("vehicle_no");
				model.setInvoiceno(rs001.getString("invoice_no"));
				model.setDate(rs001.getString("date"));
				PreparedStatement pst0010 = conn.prepareStatement("select sum(amt) from invoice_tax_details where invoice_no = '"+invoice_no+"'");
				ResultSet rs0010 = pst0010.executeQuery();
				if(rs0010.next())
				{
					model.setTotal_amount(rs0010.getString(1));
				}
				model.setCgst(rs001.getString("cgstamount"));
				model.setSgst(rs001.getString("sgstamount"));
				model.setTotal_tax_amount(rs001.getString("totaltax"));
				model.setTotal_amount1(rs001.getString("total"));
			}
			
			PreparedStatement pst002 = conn.prepareStatement("select * from customer_master_details where customer_no= '"+cust_code+"'");
			ResultSet rs002 = pst002.executeQuery();
			
			if(rs002.next())
			{
				model.setCustomer_name(rs002.getString("customer_name"));
				model.setAddress(rs002.getString("customer_address"));
				model.setGstin_no(rs002.getString("customer_gst_no"));
				model.setState(rs002.getString("state"));
				model.setPan_no(rs002.getString("pan_no"));
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}

	
	
	
	
	
	public DeliveryModel getInvoiceDetails1Igst(String invoice_no) {
		// TODO Auto-generated method stub
		DeliveryModel model = new DeliveryModel();
		try {
			
			PreparedStatement pst001 = conn.prepareStatement("select * from invoice where invoice_no= '"+invoice_no+"'");
			ResultSet rs001 = pst001.executeQuery();
			
			String cust_code = "";
			
			if(rs001.next())
			{
				cust_code = rs001.getString("vehicle_no");
				model.setInvoiceno(rs001.getString("invoice_no"));
				model.setDate(rs001.getString("date"));
				PreparedStatement pst0010 = conn.prepareStatement("select sum(amt) from invoice_tax_details where invoice_no = '"+invoice_no+"'");
				ResultSet rs0010 = pst0010.executeQuery();
				if(rs0010.next())
				{
					model.setTotal_amount(rs0010.getString(1));
				}
				
				model.setCgst(rs001.getString("igstamount"));
				//model.setSgst(rs001.getString("sgstamount"));
				model.setTotal_tax_amount(rs001.getString("totaltax"));
				model.setTotal_amount1(rs001.getString("total"));
			}
			
			PreparedStatement pst002 = conn.prepareStatement("select * from customer_master_details where customer_no= '"+cust_code+"'");
			ResultSet rs002 = pst002.executeQuery();
			
			if(rs002.next())
			{
				model.setCustomer_name(rs002.getString("customer_name"));
				model.setAddress(rs002.getString("customer_address"));
				model.setGstin_no(rs002.getString("customer_gst_no"));
				model.setState(rs002.getString("state"));
				model.setPan_no(rs002.getString("pan_no"));
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return model;
	}
	
	public List<DeliveryModel> getInvoiceDetailsIgst(String invoice_no) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		try {
			PreparedStatement pst001 = conn.prepareStatement("select * from invoice_tax_details where invoice_no = '"+invoice_no+"'");
			ResultSet rs001 = pst001.executeQuery();
			
			while(rs001.next())
			{
				DeliveryModel model = new DeliveryModel();
				model.setDescription1(rs001.getString("descrip"));
				model.setWeight1(rs001.getString("qty"));
				model.setRate1(rs001.getString("rate"));
				model.setAmount1(rs001.getString("amt"));
				model.setNet_amt1(rs001.getString("net_amt"));
				model.setHsn1(rs001.getString("type_name"));
				model.setGstrate1(rs001.getString("igstrate"));
				model.setGstamt1(rs001.getString("igstamount"));
				
				
				//model.setGstrate2(rs001.getString("sgstrate"));
				//model.setGstamt2(rs001.getString("sgstamount"));
				
				list.add(model);
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
	
	

	public String getBusinessGraph() {
		// TODO Auto-generated method stub
		String report = "";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select month(date) month, sum(total_amount) p from lr where YEAR(date) = YEAR(NOW()) GROUP BY  month");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				report += rs.getString("p")+"~";
				report += rs.getString("month") + "-";
			}
			
			if(report.length()>1) {
				report = report.substring(0,report.length() - 1);
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return report;
	}
	
	
	
	public String getOrderLostGraph() throws Exception {
		
		
	String report = "";

		
		try {
		
		
			
		
		PreparedStatement pst = conn.prepareStatement("select reason from reason ");
		
		//System.out.println("SQL:"+pst);
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			
			
			
			
			PreparedStatement pst1 = conn.prepareStatement("select count(*) as count1 from quotation_final where  reason='"+rs.getString("reason")+"' ");
			
			//System.out.println("SQL>>>:"+pst1);
			
			ResultSet rs1 = pst1.executeQuery();
			
			if(rs1.next())
			{
				
			
						
					report += rs1.getString("count1")+"~";
					report += rs.getString("reason") + "-";
					
				}
			
			}
		
		
		if(report.length()>1) {
			report = report.substring(0,report.length() - 1);
			}
			
				
				
				
		//}	

		
		} catch (Exception ex) {
			System.out.println("error" + ex.getMessage());
		}
		//return report;
		return report;

	}
	
	
	public String getResourceEnquiryGraph() throws Exception {
		
		
		String report = "";

			
			try {
			
			
			PreparedStatement pst = conn.prepareStatement("select resource from inquiry_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				
				PreparedStatement pst1 = conn.prepareStatement("select count(*) as count1 from inquiry where  resource_from='"+rs.getString("resource")+"' ");
				
				//System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
							
						report += rs1.getString("count1")+"~";
						report += rs.getString("resource") + "-";
						
					}
				
				}
			
			
			if(report.length()>1) {
				report = report.substring(0,report.length() - 1);
				}
				
					
					
					
			//}	

			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}
	
	
	
	
	
	public String eximyGraph() throws Exception {
		
		
		String report = "";

			
			try {
			
			
			PreparedStatement pst = conn.prepareStatement("select resource from import_export_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				
				PreparedStatement pst1 = conn.prepareStatement("select count(*) as count1 from inquiry where  exim='"+rs.getString("resource")+"' ");
				
				//System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
						report += rs1.getString("count1")+"~";
						report += rs.getString("resource") + "-";
						
					}
				
				}
				if(report.length()>1) {
				report = report.substring(0,report.length() - 1);
				}
				
					
					
					
			//}	

			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}
	
	
	
	
	public String eximyGraph1() throws Exception {
		
		
		String report = "";
		
		String enq_id = "";

			
			try {
			
			
			PreparedStatement pst = conn.prepareStatement("select resource from import_export_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(transport_amount)as tps  from lr,inquiry where  inquiry.inquiry_id=lr.inquiry_id and inquiry.exim='"+rs.getString("resource")+"' ");
				
				System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
							
						report += rs1.getString("tps")+"~";
						report += rs.getString("resource") + "-";
						
				}
			}
			
			if(report.length()>1) {
				
				report = report.substring(0,report.length() - 1);
				
			}
			
			//System.out.println("Report::"+report);
			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}
	
public String eximyGraph12() throws Exception {
		
		
		String report = "";
		
		String enq_id = "";

			
			try {
				PreparedStatement pst = conn.prepareStatement("select resource from import_export_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				PreparedStatement pst1 = conn.prepareStatement("select sum(transport_amount)as tps  from lr,inquiry where  inquiry.inquiry_id=lr.inquiry_id and inquiry.exim='"+rs.getString("resource")+"' ");
				
				System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
							
						report += rs1.getString("tps")+"~";
						report += rs.getString("resource") + "-";
						
				}
				}
			
			if(report.length()>1) {
				
				report = report.substring(0,report.length() - 1);
				
			}
			
			//System.out.println("Report::"+report);
			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}

public String eximyGraph123() throws Exception {
	
	
	String report = "";
	
	String enq_id = "";

		
		try {
		
		
		PreparedStatement pst = conn.prepareStatement("select * from route_master");
		
		//System.out.println("SQL:"+pst);
		
		ResultSet rs = pst.executeQuery();
		System.out.println("SQL---------------:"+pst);
		
		while(rs.next())
		{
		PreparedStatement pst1 = conn.prepareStatement("select * from order_table where  route='"+rs.getString("route")+"'");
		ResultSet rs11 = pst1.executeQuery();
		System.out.println("SQL222:-----"+pst1);
		if(rs11.next())
		{
			PreparedStatement pst12 = conn.prepareStatement("select sum(transport_amount)as tps  from lr where LR_no='"+rs11.getString("lr_no")+"'");
			ResultSet rs12 = pst12.executeQuery();
			System.out.println("SQL33:----"+pst12);
			if(rs12.next())
			{
				
				String ss=rs.getString("route");
				String rout=ss.replace('-','*');
					report += rs12.getString("tps")+"~";
					report += rout + "-";
				}
			
		}
			}
		
		if(report.length()>1) {
			
			report = report.substring(0,report.length() - 1);
			
		}
		
		//System.out.println("Report::"+report);
		
		} catch (Exception ex) {
			System.out.println("error" + ex.getMessage());
		}
		//return report;
		return report;

	}
	
	public String getResourceEnquiryGraph1() throws Exception {
		
		
		String report = "";
		
		String enq_id = "";

			
			try {
			
			
			PreparedStatement pst = conn.prepareStatement("select resource from inquiry_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(total)as total  from order_table,inquiry where  inquiry.inquiry_id=order_table.inquiry_id and inquiry.resource_from='"+rs.getString("resource")+"' ");
				
				System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
							
						report += rs1.getString("total")+"~";
						report += rs.getString("resource") + "-";
						
				}
				
				
			
		
			}
			
			if(report.length()>1) {
				
				report = report.substring(0,report.length() - 1);
				
			}
			
			System.out.println("Report::"+report);
			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}
	
	
	
	
	
	
	public String businessGraph() throws Exception {
		
		
		String report = "";
		
		String enq_id = "";

			
			try {
			
			
			PreparedStatement pst = conn.prepareStatement("select resource from inquiry_resource ");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				
				PreparedStatement pst1 = conn.prepareStatement("select sum(total)as total  from pricing,inquiry where  inquiry.inquiry_id=pricing.inquiry_id and inquiry.resource_from='"+rs.getString("resource")+"' ");
				
				System.out.println("SQL>>>:"+pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
							
						report += rs1.getString("total")+"~";
						//report += rs.getString("resource") + "-";
						
				}
				
				
				PreparedStatement pst11 = conn.prepareStatement("select sum(total)as total1  from order_table,inquiry where  inquiry.inquiry_id=order_table.inquiry_id and inquiry.resource_from='"+rs.getString("resource")+"' ");
				
				System.out.println("SQL>>>:"+pst11);
				
				ResultSet rs11 = pst11.executeQuery();
				
				if(rs11.next())
				{
							
						report += rs11.getString("total1")+"~";
						report += rs.getString("resource") + "-";
						
				}
				
				
			
		
			}
			
			if(report.length()>1) {
				
				report = report.substring(0,report.length() - 1);
				
			}
			
			System.out.println("Report::"+report);
			
			} catch (Exception ex) {
				System.out.println("error" + ex.getMessage());
			}
			//return report;
			return report;

		}
	


	public String getShortWeightGraph() {
		// TODO Auto-generated method stub
		String report = "";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select month(date) month from delivery_done where YEAR(date) = YEAR(NOW()) GROUP BY  month");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				/*report += rs.getString("p")+"~";
				report += rs.getString("month") + "-";*/
				
				double shortwt = 0;
				
				PreparedStatement pst1 = conn.prepareStatement("select delivery_done_id from delivery_done where month(date) = '"+rs.getString(1)+"' and YEAR(date) = YEAR(NOW())");
				ResultSet rs1 = pst1.executeQuery();
				
				while(rs1.next())
				{
					PreparedStatement pst2 = conn.prepareStatement("select sum(short_weight) from delivery_done_details where delivery_done_id = '"+rs1.getString(1)+"'");
					ResultSet rs2 = pst2.executeQuery();
					
					if(rs2.next())
					{
						shortwt  = shortwt + Double.parseDouble(rs2.getString(1));
					}
				}
				
				report += String.valueOf(shortwt)+"~";
				report += rs.getString("month") + "-";
			}
			
			if(report.length()>1) {
				report = report.substring(0,report.length() - 1);
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return report;
	}


	public String getTripsGraph() {
		// TODO Auto-generated method stub
		String report = "";
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select month(date) month from trip where YEAR(date) = YEAR(NOW()) GROUP BY  month");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				/*report += rs.getString("p")+"~";
				report += rs.getString("month") + "-";*/
				
				PreparedStatement pst1 = conn.prepareStatement("select count(*) from trip where month(date)='"+rs.getString(1)+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					report += rs1.getString(1)+"~";
					report += rs.getString("month") + "-";
				}
				
			}
			
			if(report.length()>1) {
				report = report.substring(0,report.length() - 1);
				}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return report;
	}	
	
	
	
	
	public List<DeliveryModel> fetchTransporterDoneDetails(String vname) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		String vid="";
		try {
		String name[]=vname.split("-");
		vid=name[1];
		}
		catch(Exception e)
		{
			vid="";
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from delivery_done1 where vendor_status='0' and transporter_code='"+vid+"'");
			ResultSet rs = pst.executeQuery();
			
			System.out.println(" fetch query id=-------"+pst);
			
			while(rs.next())
			{
				
				DeliveryModel model = new DeliveryModel();
				
				model.setDelivery_done_id(rs.getString("delivery_id"));
	
				model.setLr_number(rs.getString("LR_no"));
				model.setSource(rs.getString("source"));
				model.setDestination(rs.getString("destination"));
				model.setVehicle_no(rs.getString("vehicle_no"));
				model.setDriver_name(rs.getString("driver_name"));
				model.setCustomer_name(rs.getString("Customer_name"));
				model.setCustomer_no(rs.getString("customer_no"));
				
				PreparedStatement pst1 = conn.prepareStatement("select * from pricing where inquiry_id='"+rs.getString("inquiry_id")+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					model.setTotal_amount(rs1.getString("total"));
				}
				
				model.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				model.setTransporter_name(rs.getString("transporter_name"));
				model.setPrint_file(rs.getString("photus"));
				model.setInquiry_id(rs.getString("inquiry_id"));
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public String insertvendorBill(DeliveryModel deliverymodel, userinfo bean) {
		// TODO Auto-generated method stub
		
		String response = "";
		// TODO Auto-generated method stub
		String stringValue2 = "";
		String stringValue3 = "";
		
		int len1 = 0;
		
		try {
		
			
			PreparedStatement preparedStatement3 = conn
				.prepareStatement("select  max(SUBSTRING(bill_id,-4)) as myval1 from vendor_bill");
		
		
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
				stringValue3 = "HSL/BILL/" + "000" + stringValue3;
			} else if (stringValue3.length() == 2) {
				stringValue3 = "HSL/BILL/" + "00" + stringValue3;
			} else if (stringValue3.length() == 3) {
				stringValue3 = "HSL/BILL/" + "0" + stringValue3;
			} else {
				stringValue3 = "HSL/BILL/" + stringValue3;
			}
			deliverymodel.setDelivery_done_id(stringValue3);
			
			
			int k = 0;
			String alloption[]=deliverymodel.getOther().split("~");
			
			System.out.println("dfgdfgdfg0000000000000000-----------"+deliverymodel.getOther());
			
			double final_amount=0.0;
			
			try {
				for (int l = 0; l <deliverymodel.getLr_number1().length; l++) {
					
					
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getLr_number1()[l].equals(alloption[i]))) {
						
						PreparedStatement pstd = conn.prepareStatement("insert into vendor_bill_details(Bill_no, Lr_no, customer_name, source, destination, vehicelno, drivername,amount) values(?, ?, ?, ?, ?, ?, ?,?)");
						
						pstd.setString(1, deliverymodel.getDelivery_done_id());
						pstd.setString(2, deliverymodel.getLr_number1()[l]);
						pstd.setString(3, deliverymodel.getCustomet_name()[l]);
						pstd.setString(4, deliverymodel.getFrom()[l]);
						pstd.setString(5, deliverymodel.getDescription()[l]);
						pstd.setString(6, deliverymodel.getVehicelno()[l]);
						pstd.setString(7, deliverymodel.getDriver_name1()[l]);
						pstd.setString(8, deliverymodel.getAmount()[l]);
						final_amount+=Double.parseDouble(deliverymodel.getAmount()[l]);
						
						k = pstd.executeUpdate();
						System.out.println("grid query is ====------"+pstd);
						
						response = "success";
					}
					}
				}
				//System.out.println("size k = "+k);
				
				response = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			try {
			

			PreparedStatement pst2 = conn.prepareStatement("insert into vendor_bill(bill_id ,vendor_name, vendor_id, Bill_no, username, date, totalamount,datetime) values(?,?,?,?,?,?,?,?)");
			pst2.setString(1, deliverymodel.getDelivery_done_id());
			pst2.setString(2, deliverymodel.getTransporter_name());
			pst2.setString(3, deliverymodel.getTransporter_code());
			pst2.setString(4, deliverymodel.getBill_no());
			pst2.setString(5, bean.getUsername());
			pst2.setString(6, SystemDateTime.CurrentDate());
			pst2.setString(7, String.valueOf(final_amount));
			pst2.setString(8,SystemDateTime.CurrentDateTime());
			int eu = pst2.executeUpdate();
			
			
			response = "success";
			
			
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			try {
				

				PreparedStatement pst2 = conn.prepareStatement("insert into vendor_creditdebit(Documentsno ,vendor_name, vendor_id, Bill_no, username, Date, totalamount,type,datetime,LR_no_amount) values(?,?,?,?,?,?,?,?,?,?)");
				pst2.setString(1, deliverymodel.getDelivery_done_id());
				pst2.setString(2, deliverymodel.getTransporter_name());
				pst2.setString(3, deliverymodel.getTransporter_code());
				pst2.setString(4, deliverymodel.getBill_no());
				pst2.setString(5, bean.getUsername());
				pst2.setString(6, SystemDateTime.CurrentDate());
				pst2.setString(7, String.valueOf(final_amount));
				pst2.setString(8, "Debit");
				pst2.setString(9,SystemDateTime.CurrentDateTime());
				
				
				String alllr="";
				
					for (int l = 0; l <deliverymodel.getLr_number1().length; l++) {
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getLr_number1()[l].equals(alloption[i]))) {
				
						alllr+=deliverymodel.getLr_number1()[l]+"~"+deliverymodel.getAmount()[l]+"^";								
					}
					}
				}
				
					pst2.setString(10,alllr);		
					
					
					
			int eu = pst2.executeUpdate();
			
			System.out.println("0000000000000-------"+pst2);
			
				response = "success";
				}
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			
			
			
			try {
				for (int l = 0; l <deliverymodel.getLr_number1().length; l++) {
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getLr_number1()[l].equals(alloption[i]))) {
				
						PreparedStatement pst4 = conn.prepareStatement("update delivery_done1 set vendor_status='1'where LR_no = '"+deliverymodel.getLr_number1()[l]+"'");
						int st = pst4.executeUpdate();
						
				
					}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
				
				response = "success";
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return response;
	}
	
	
	
	
	
	
	
	
	
	public List<DeliveryModel> vendorbillreport() {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from vendor_bill where status='0'");
			ResultSet rs = pst.executeQuery();
			
			System.out.println(" fetch query id=-------"+pst);
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setDelivery_done_id(rs.getString("bill_id"));
	
				model.setTransporter_name(rs.getString("vendor_name"));
				model.setTransporter_code(rs.getString("vendor_id"));
				model.setBill_no(rs.getString("Bill_no"));
				model.setDate(rs.getString("date"));
				model.setTotal_amount(rs.getString("totalamount"));				
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	public List<DeliveryModel> vendorbilldetails(String bill_id) {
		// TODO Auto-generated method stub
		List<DeliveryModel> list = new ArrayList<>();
		
		
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from vendor_bill_details where Bill_no='"+bill_id+"' and  amount>0 ");
			ResultSet rs = pst.executeQuery();
			
			System.out.println(" fetch query id=-------"+pst);
			
			while(rs.next())
			{
				DeliveryModel model = new DeliveryModel();
				
				model.setInvoiceno(rs.getString("Bill_no"));
	
				model.setLr_number(rs.getString("Lr_no"));
				model.setCustomer_name(rs.getString("customer_name"));
				model.setSource(rs.getString("source"));
				model.setDestination(rs.getString("destination"));
				model.setVehicle_no(rs.getString("vehicelno"));	
				model.setDriver_name(rs.getString("drivername"));	
				model.setAmount1(rs.getString("amount"));
				
				
				
				
				list.add(model);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	
	
	
	public String insertvendorpayment(DeliveryModel deliverymodel, userinfo bean) {
		// TODO Auto-generated method stub
		
		String response = "";
		// TODO Auto-generated method stub
		String stringValue2 = "";
		String stringValue3 = "";
		
		int len1 = 0;
		
		try {
		
			
			PreparedStatement preparedStatement3 = conn
				.prepareStatement("select  max(SUBSTRING(payment_id,-4)) as myval1 from vendor_bill_Payment");
		
		
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
				stringValue3 = "HSL/PAY/" + "000" + stringValue3;
			} else if (stringValue3.length() == 2) {
				stringValue3 = "HSL/PAY/" + "00" + stringValue3;
			} else if (stringValue3.length() == 3) {
				stringValue3 = "HSL/PAY/" + "0" + stringValue3;
			} else {
				stringValue3 = "HSL/PAY/" + stringValue3;
			}
			deliverymodel.setDelivery_done_id(stringValue3);
			
			
			int k = 0;
			String alloption[]=deliverymodel.getOther().split("~");
			
			String vendorname="";
			String vendorcode="";
			try {
				for (int l = 0; l <deliverymodel.getBill_id().length; l++) {
									
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getBill_id()[l].equals(alloption[i]))) {
						
						PreparedStatement pstd = conn.prepareStatement("insert into vendor_bill_details_Payment(payment_id, Bill_no, date, amount, advance, advance_amount, reman_amount) values(?, ?, ?, ?, ?, ?, ?)");
						
						pstd.setString(1, deliverymodel.getDelivery_done_id());
						pstd.setString(2, deliverymodel.getBillno1()[l]);
						pstd.setString(3, deliverymodel.getDate1()[l]);
						pstd.setString(4, deliverymodel.getBilllamount1()[l]);
						pstd.setString(5, deliverymodel.getAdvance1()[l]);
						pstd.setString(6, deliverymodel.getAdvanceamt1()[l]);
						pstd.setString(7, deliverymodel.getRemanamount1()[l]);
						vendorname=deliverymodel.getVendorname1()[0];
						vendorcode=deliverymodel.getVendorcode1()[0];
						k = pstd.executeUpdate();
						System.out.println("grid query is ====------"+pstd);
						
						response = "success";
					}
					}
				}
				response = "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
				try {
					
				PreparedStatement pst2 = conn.prepareStatement("insert into vendor_bill_Payment(payment_id ,vendor_name, vendor_id, username, date, totalamount,datetime) values(?,?,?,?,?,?,?)");
				pst2.setString(1, deliverymodel.getDelivery_done_id());
				pst2.setString(2, vendorname);
				pst2.setString(3, vendorcode);
				pst2.setString(4, bean.getUsername());
				pst2.setString(5, SystemDateTime.CurrentDate());
				pst2.setString(6, deliverymodel.getTotal_amount1());
				pst2.setString(7,SystemDateTime.CurrentDateTime());
				int eu = pst2.executeUpdate();
				
				response = "success";
					
				}
			catch(Exception e)
				{
				e.printStackTrace();
				}
			
			try {
				
				
				for (int l = 0; l <deliverymodel.getBill_id().length; l++) {
					
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getBill_id()[l].equals(alloption[i]))) {
						
				
				PreparedStatement pst2 = conn.prepareStatement("insert into vendor_creditdebit(Documentsno ,vendor_name, vendor_id, Bill_no, username, Date, totalamount,type,datetime,LR_no_amount) values(?,?,?,?,?,?,?,?,?,?)");
				pst2.setString(1, deliverymodel.getBill_id()[l]+"("+deliverymodel.getAdvance1()[l]+")");
				
			    pst2.setString(2, deliverymodel.getVendorname1()[l]);
				pst2.setString(3, deliverymodel.getVendorcode1()[l]);
				pst2.setString(4, deliverymodel.getDelivery_done_id());
				pst2.setString(5, bean.getUsername());
				pst2.setString(6, SystemDateTime.CurrentDate());
				pst2.setString(7, deliverymodel.getRemanamount1()[l]);
				pst2.setString(8, "Credit");
				pst2.setString(9,SystemDateTime.CurrentDateTime());
				
				
					pst2.setString(10,"aa");		
					
					
					
			int eu = pst2.executeUpdate();
			
			System.out.println("0000000000000-------"+pst2);
			
				response = "success";
				}
					
					}}}
					
				catch(Exception ee)
				{
					ee.printStackTrace();
				}
			
			
			
			try {	
				for (int l = 0; l <deliverymodel.getBill_id().length; l++) {
					for(int i = 0; i <alloption.length; i++)
					{
					
					if ((deliverymodel.getBill_id()[l].equals(alloption[i]))) {
				
						PreparedStatement pst4 = conn.prepareStatement("update vendor_bill set status='1'where bill_id = '"+deliverymodel.getBill_id()[l]+"'");
						int st = pst4.executeUpdate();
						
				
					}
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
			
				
				response = "success";
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}	
	

