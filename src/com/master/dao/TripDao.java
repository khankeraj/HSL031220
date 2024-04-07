package com.master.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.dao.Inquiry.InquiryDao;
import com.master.model.InquiryBean;
import com.master.model.TripModel;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;

import utility.SysDate;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TripDao {
	
	static DBConnection connection=new DBConnection();
	
	
	
	public int insert_trip_Details(TripModel tripmodel, userinfo bean) {
		// TODO Auto-generated method stub
		
		
		Connection conn=connection.getConnection();
		
		int i=0;
		
		try {
						
			String customer_final_id="HSL/AT/TRP/0001";
			
			String pref="HSL/AT/TRP";
			
			PreparedStatement preparedStatement11 = conn
					.prepareStatement("select  max(SUBSTRING(trip_id,-5)) as myval1 from trip  where LENGTH(trip_id)>5 and trip_id like '%"
							+ pref + "%' ");
			String mystr1 = "";
			int myval1 = 0;
			String stringValue1 = "1";
			ResultSet resultSet11 = preparedStatement11.executeQuery();
			if (resultSet11.next()) {
				try {
					mystr1 = resultSet11.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval1 = 1;
					mystr1 = "";
				}
			}
	

			if (mystr1.equals("")) {
				stringValue1 = pref + "HSL//0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = pref + "HSL//0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = pref + "HSL//000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = pref + "HSL//00" + String.valueOf(myval1);
				} else  if (String.valueOf(myval1).length() == 4) {
					stringValue1 = pref + "HSL//0" + String.valueOf(myval1);
				} else {
					stringValue1 = pref + "/" + String.valueOf(myval1);
				}
			}
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `trip` (`trip_id`, `source`, `destination`, `vehicle_no`, `driver_name`, `next_destination`, `driver_code`, `date`) values(?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, stringValue1);
			pst.setString(2, tripmodel.getSource());
			pst.setString(3, tripmodel.getDestination());
			pst.setString(4, tripmodel.getVehicle_no());
			
			String driver = tripmodel.getDriver_name();
			String[] drv = driver.split("-");
			/*pst.setString(5, tripmodel.getDriver_name());*/
			pst.setString(5, drv[0]);
			pst.setString(6, tripmodel.getNext_destination());
			pst.setString(7, drv[1]);
			pst.setString(8, tripmodel.getDate());
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBConnection.closeConnection();
		
		return i;
	}
/*public int update_route_details(CityModel citymodel, String update_route) {
	// TODO Auto-generated method stub
	int i=0;
	int route_id=Integer.parseInt(update_route);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `route_master` SET `route`=? WHERE `id`=?");
		
		pst.setString(1, citymodel.getRoute());
		pst.setInt(2, route_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
	

	
}*/
	


public int deleteissueamount(TripModel product_model, String delete_product_id) {
	// TODO Auto-generated method stub
	int i=0;
	Connection conn=connection.getConnection();
	
	
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `amount_issue12` WHERE docid="+delete_product_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
	
	
	
	
		public List<TripModel> fetchTripDetails(TripModel tripModel, userinfo bean) {
			
			Connection conn=connection.getConnection();
			
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT `trip_id`, `source`, `destination`, `vehicle_no`, `driver_name`, `next_destination` FROM `trip`");
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						
						tripModel1.setTrip_id(rs.getString(1));
						tripModel1.setSource(rs.getString(2));
						tripModel1.setDestination(rs.getString(3));
						tripModel1.setVehicle_no(rs.getString(4));
						tripModel1.setDriver_name(rs.getString(5));
						tripModel1.setNext_destination(rs.getString(6));
						
						PreparedStatement pst1 = conn.prepareStatement("select status from updown where trip_id='"+tripModel1.getTrip_id()+"'"+" and updown_id like 'AT/TRP/UP%'");
						ResultSet rs1 = pst1.executeQuery();
						
						if(rs1.next())
						{
							tripModel1.setUp_status(rs1.getString(1));
						}
						
						
						PreparedStatement pst2 = conn.prepareStatement("select status from updown where trip_id='"+tripModel1.getTrip_id()+"'"+" and updown_id like 'AT/TRP/DW%'");
						ResultSet rs2 = pst2.executeQuery();
						
						if(rs2.next())
						{
							tripModel1.setDown_status(rs2.getString(1));
						}
						
						System.out.println(tripModel1.getTrip_id()+" up "+tripModel1.getUp_status());
						System.out.println(tripModel1.getTrip_id()+" down "+tripModel1.getDown_status());
						
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		
		
		public int update_amount_issue_details(TripModel productmodel) {
			// TODO Auto-generated method stub
			int i=0;
			
			Connection conn=connection.getConnection();
			
			
			//int product_id=Integer.parseInt(update_product);
			String ssk[]= productmodel.getName().split("-");
			String sskk[]= productmodel.getGiven_by().split("-");
			try {
				PreparedStatement pst=conn.prepareStatement("UPDATE `amount_issue12` SET `emp_name`=?,`emp_id`=?,`particular`=?,`given_by`=?,`given_id`=?,`amount`=?, `remark`=?  WHERE `docid`=?");
				
				pst.setString(1, ssk[0]);
				pst.setString(2, ssk[1]);
				pst.setString(3, productmodel.getParticular());
				pst.setString(4, sskk[0]);
				pst.setString(5, sskk[1]);
				pst.setString(6, productmodel.getAmount1());
				pst.setString(7, productmodel.getRemark());
				pst.setString(8, productmodel.getDocumentsno());
				
				
				
				i=pst.executeUpdate();
				System.out.println("iiiiiiiiiiiiiiiiiii----------"+pst);
			} catch (SQLException e) {
				System.out.println(">>>>>>>>>>>>>>>>>>>"+e.getMessage());
			}
			
			
			try {
				PreparedStatement pst=conn.prepareStatement("UPDATE `diley_cashreport` SET `Name`=?,`emp_id`=?,`Amount`=?, `Remark`=?  WHERE `Documentsno`=?");
				
				pst.setString(1, ssk[0]);
				pst.setString(2, ssk[1]);
				//pst.setString(3, productmodel.getParticular());
				/*pst.setString(4, sskk[0]);
				pst.setString(5, sskk[1]);
				*/
				pst.setString(3, productmodel.getAmount1());
				pst.setString(4, productmodel.getRemark());
				pst.setString(5, productmodel.getDocumentsno());
				
				
				
				i=pst.executeUpdate();
				System.out.println("iiiiiiiiiiiiiiiiiiijjjjj----------"+pst);
			} catch (SQLException e) {
				System.out.println(">>>>>>>>>>>>>>>>>>>"+e.getMessage());
			}
			return i;
		}
				
		
		
		
		
		
		
		
		
		public List<TripModel> amountDetails() {
			// TODO Auto-generated method stub
		List<TripModel> list=new ArrayList<TripModel>();
		Connection conn=connection.getConnection();
				try {
					PreparedStatement pst=conn.prepareStatement("SELECT * FROM amount_issue12");
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel productModel=new TripModel();
						
						productModel.setEmp_name(rs.getString("emp_name"));
						productModel.setDest_contact_person(rs.getString("particular"));
						productModel.setAmount1(rs.getString("amount"));
						productModel.setGiven_by(rs.getString("given_by"));
						productModel.setRemark(rs.getString("remark"));
						productModel.setDate1y(rs.getString("date"));
						productModel.setDocumentsno(rs.getString("docid"));
						
					
						list.add(productModel);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
			
		
		
		public String insertUpdownDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			
			Connection conn=connection.getConnection();
			
			
			String response = "";
			
				try {
				String stringValue = "";
				String stringValue1 = "";
				
				int len = 0;
				PreparedStatement preparedStatement1 = conn
						.prepareStatement("select  max(SUBSTRING(updown_id,-4)) as myval1 from updown where LENGTH(updown_id)>5");
				
				
				String mystr1 = "";
				int myval1 = 0;
				ResultSet resultSet1 = preparedStatement1.executeQuery();
				
				if (resultSet1.next()) {
					try {
						mystr1 = resultSet1.getString("myval1");
						myval1 = Integer.parseInt(mystr1);
						myval1 = myval1 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval1 = 1;
						mystr1 = "";
					}
				}
				
				
				int size = len + 1;
				stringValue = String.valueOf(myval1);
				if(tripModel.getUpdown().equalsIgnoreCase("up"))
				{
					if (stringValue.length() == 1) {
						stringValue = "HSL/AT/TRP/UP/" + "000" + stringValue;
					} else if (stringValue.length() == 2) {
						stringValue = "HSL/AT/TRP/UP/" + "00" + stringValue;
					} else if (stringValue.length() == 3) {
						stringValue = "HSL/AT/TRP/UP/" + "0" + stringValue;
					} else {
						stringValue = "HSL/AT/TRP/UP/" + stringValue;
					}
					tripModel.setUpdown_id(stringValue);
				}
			
				else {
					if (stringValue.length() == 1) {
						stringValue = "HSL/AT/TRP/DW/" + "000" + stringValue;
					} else if (stringValue.length() == 2) {
						stringValue = "HSL/AT/TRP/DW/" + "00" + stringValue;
					} else if (stringValue.length() == 3) {
						stringValue = "HSL/AT/TRP/DW/" + "0" + stringValue;
					} else {
						stringValue = "HSL/AT/TRP/DW/" + stringValue;
					}
					tripModel.setUpdown_id(stringValue);
					}
				
				
				
				String stringValue2 = "";
				String stringValue3 = "";
				
				int len1 = 0;
				PreparedStatement preparedStatement3 = conn
						.prepareStatement("select  max(SUBSTRING(LR_no,-4)) as myval1 from LR");
				
				
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
				if(tripModel.getUpdown().equalsIgnoreCase("up"))
				{
					if (stringValue3.length() == 1) {
						stringValue3 = "HSL/AT/TRP/UP/LR/" + "000" + stringValue3;
					} else if (stringValue3.length() == 2) {
						stringValue3 = "HSL/AT/TRP/UP/LR/" + "00" + stringValue3;
					} else if (stringValue3.length() == 3) {
						stringValue3 = "HSL/AT/TRP/UP/LR/" + "0" + stringValue3;
					} else {
						stringValue3 = "HSL/AT/TRP/UP/LR/" + stringValue3;
					}
					tripModel.setLr_number(stringValue3);
				}
			
				else {
					if (stringValue3.length() == 1) {
						stringValue3 = "HSL/AT/TRP/DW/LR/" + "000" + stringValue3;
					} else if (stringValue3.length() == 2) {
						stringValue3 = "HSL/AT/TRP/DW/LR/" + "00" + stringValue3;
					} else if (stringValue3.length() == 3) {
						stringValue3 = "HSL/AT/TRP/DW/LR/" + "0" + stringValue3;
					} else {
						stringValue3 = "HSL/AT/TRP/DW/LR/" + stringValue3;
					}
					tripModel.setLr_number(stringValue3);
					}
				
				
				
				
				
				
				
				
				
				
				
				
				int j = 0;
				PreparedStatement pst1 = conn.prepareStatement("insert into updown(trip_id, updown_id, vehicle_no, driver_name, updown, source, destination, driver_code, status, LR_no, date) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				pst1.setString(1, tripModel.getTrip_id());
				pst1.setString(2, tripModel.getUpdown_id());
				pst1.setString(3, tripModel.getVehicle_no());
				pst1.setString(4, tripModel.getDriver_name());
				pst1.setString(5, tripModel.getUpdown());
				pst1.setString(6, tripModel.getSource());
				pst1.setString(7, tripModel.getDestination());
				
				
				PreparedStatement pstc = conn.prepareStatement("select driver_code from trip where trip_id = '"+tripModel.getTrip_id()+"'");
				ResultSet rset = pstc.executeQuery();
				
				String driver_code = "";
				if(rset.next())
				{
					driver_code = rset.getString(1);
				}
				
				
				pst1.setString(8, driver_code);
				pst1.setString(9, "1");
				pst1.setString(10, tripModel.getLr_number());
				pst1.setString(11, tripModel.getDate());
				int c1 = pst1.executeUpdate();
				System.out.println("pst1  .... "+pst1);
				
				
				
				
				
				
				
				
				
				PreparedStatement pst2 = conn.prepareStatement("insert into LR(trip_id, updown_id, LR_no, Customer_name, date, mobile, source, destination, transporter_name, vehicle_no, driver_name, total_amount, advance, balance, customer_no, driver_code, transporter_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst2.setString(1, tripModel.getTrip_id());
				pst2.setString(2, tripModel.getUpdown_id());
				pst2.setString(3, tripModel.getLr_number());
				
				String customer = tripModel.getCustomer_name();
				String transporter = tripModel.getTransporter_name();
				
				String[] cust = customer.split("-");
				String[] trans = transporter.split("-");
				
				/*pst2.setString(4, tripModel.getCustomer_name());*/
				pst2.setString(4, cust[0]);
				pst2.setString(5, tripModel.getDate());
				
				PreparedStatement pstmb = conn.prepareStatement("select mobile_no from customer_master_details where customer_name='"+cust[0]+"'");
				ResultSet rs = pstmb.executeQuery();
				
				String mobile ="";
				if(rs.next())
				{
					mobile = rs.getString(1);
					tripModel.setMobile(mobile);
				}
				
				
				pst2.setString(6, mobile);
				pst2.setString(7, tripModel.getSource());
				pst2.setString(8, tripModel.getDestination());
				pst2.setString(9, trans[0]);
				pst2.setString(10, tripModel.getVehicle_no());
				pst2.setString(11, tripModel.getDriver_name());
				pst2.setString(12, tripModel.getTotal_amount());
				pst2.setString(13, tripModel.getAdvance());
				pst2.setString(14, tripModel.getBalance());
				pst2.setString(15, cust[1]);
				
				
				pst2.setString(16, driver_code);
				pst2.setString(17, trans[1]);
				/*PreparedStatement pstmc = conn.prepareStatement("select customer_ from customer_master_details where customer_name='"+tripModel.getCustomer_name()+"'");
				pst2.setString(16, );*/
				int c2 =pst2.executeUpdate();
				System.out.println("pst2 .... "+pst2);
				PreparedStatement pstd = conn.prepareStatement("insert into LR_details(LR_no, description, weight, rate, amount) values(?, ?, ?, ?, ?)");
				
				int k = 0;
				
				try {
					for (int l = 0; l < tripModel.getDescription().length; l++) {
						
						if ((tripModel.getDescription()[l] != "")) {
							
							pstd.setString(1, tripModel.getLr_number());
							pstd.setString(2, tripModel.getDescription()[l]);
							pstd.setString(3, tripModel.getWeight()[l]);
							pstd.setString(4, tripModel.getRate()[l]);
							pstd.setString(5, tripModel.getAmount()[l]);
				
//							pst2.setString(6, bean.getUsername());
//							pst2.setString(7, SystemDateTime.CurrentDateTime());
							
							k = pstd.executeUpdate();
							
						}
					}
					System.out.println("size k = "+k);
					
					response = "success";
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				if(!tripModel.getCommission().equals("") && !tripModel.getCommission().equals("0"))
				{
					
					

					// TODO Auto-generated method stub
					//String response="";
					
						String stringValue02 = "";
						String stringValue03 = "";
						
						String stringValue04 = "";
						String stringValue05 = "";
						
						
						int len01 = 0;
						
						PreparedStatement preparedStatement03 = conn
								.prepareStatement("select  max(SUBSTRING(commission_id,-4)) as myval1 from commission");
						
						
						String mystr02 = "";
						int myval02 = 0;
						ResultSet resultSet02 = preparedStatement03.executeQuery();
						
						if (resultSet02.next()) {
							try {
								mystr02 = resultSet02.getString("myval1");
								myval02 = Integer.parseInt(mystr02);
								myval02 = myval02 + 1;
							} catch (Exception e) {
								// TODO: handle exception
								myval02 = 1;
								mystr02 = "";
							}
						}
						
						
						int size02 = len01 + 1;
						stringValue03 = String.valueOf(myval02);
						
							if (stringValue03.length() == 1) {
								stringValue03 = "HSL/COMM/" + "000" + stringValue03;
							} else if (stringValue03.length() == 2) {
								stringValue03 = "HSL/COMM/" + "00" + stringValue03;
							} else if (stringValue03.length() == 3) {
								stringValue03 = "HSL/COMM/" + "0" + stringValue03;
							} else {
								stringValue03 = "HSL/COMM/" + stringValue03;
							}
							tripModel.setCommission_id(stringValue03);	
						
						
						
						
							int len02 = 0;
							PreparedStatement preparedStatement04 = conn
									.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from transportercreditdebit");
							
							
							String mystr03 = "";
							int myval03 = 0;
							ResultSet resultSet03 = preparedStatement04.executeQuery();
							
							if (resultSet03.next()) {
								try {
									mystr03 = resultSet03.getString("myval1");
									myval03 = Integer.parseInt(mystr03);
									myval03 = myval03 + 1;
								} catch (Exception e) {
									// TODO: handle exception
									myval03 = 1;
									mystr03 = "";
								}
							}
							
							
							int size3 = len02 + 1;
							stringValue05 = String.valueOf(myval03);
							
								if (stringValue05.length() == 1) {
									stringValue05 = "HSL/BILLNO/" + "000" + stringValue05;
								} else if (stringValue05.length() == 2) {
									stringValue05 = "HSL/BILLNO/" + "00" + stringValue05;
								} else if (stringValue05.length() == 3) {
									stringValue05 = "HSL/BILLNO/" + "0" + stringValue05;
								} else {
									stringValue05 = "HSL/BILLNO/" + stringValue05;
								}
								tripModel.setBill_no(stringValue05);	
							
							
							
							
							
							
							
							
							
							
							
							
						
						
						
						
						
					PreparedStatement pst02 = conn.prepareStatement("insert into commission(trip_id, updown_id, LR_no, source, destination, vehicle_no, driver_name, commission_amount, transporter_name, commission_id, remaining_amount, transporter_code, date) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					pst02.setString(1, tripModel.getTrip_id());
					pst02.setString(2, tripModel.getUpdown_id());
					pst02.setString(3, tripModel.getLr_number());
					pst02.setString(4, tripModel.getSource());
					pst02.setString(5, tripModel.getDestination());
					pst02.setString(6, tripModel.getVehicle_no());
					pst02.setString(7, tripModel.getDriver_name());
					pst02.setString(8, tripModel.getCommission());
					pst02.setString(9, trans[0]);
					pst02.setString(10, tripModel.getCommission_id());
					pst02.setString(11, tripModel.getCommission());
					
					/*String trans_code = "";
					PreparedStatement pst33 = conn.prepareStatement("select transporter_code from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
					ResultSet rs33 = pst33.executeQuery();
					if(rs33.next())
					{
						trans_code = rs33.getString(1);
					}
					
					deliverymodel.setTransporter_code(trans[1]);*/
					
					pst02.setString(12, trans[1]);
					pst02.setString(13, tripModel.getDate());
					
					int c01 = pst02.executeUpdate();
					
					System.out.println("c01 : "+c01);
					
					PreparedStatement pst03 = conn.prepareStatement("insert into transportercreditdebit(Customercode, date, trip_id, updown_id, LR_no, source, destination,  Amount, Name, Documentsno, Typecode, type, billno, transporter_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					/*String date = "";
					String customercode = "";*/
					
					/*PreparedStatement pst0d = conn.prepareStatement("select date from delivery_done where LR_no = '"+deliverymodel.getLr_number()+"'");
					ResultSet rs1 = pstd.executeQuery();
					if(rs1.next())
					{
						date = rs1.getString(1);
					}*/
					
					
					/*PreparedStatement pstc = conn.prepareStatement("select customer_no from lr where LR_no = '"+deliverymodel.getLr_number()+"'");
					ResultSet rs2 = pstc.executeQuery();
					if(rs2.next())
					{
						customercode = rs2.getString(1);
					}*/
					
					
					
					pst03.setString(1, cust[1]);
					pst03.setString(2, tripModel.getDate());
					pst03.setString(3, tripModel.getTrip_id());
					pst03.setString(4, tripModel.getUpdown_id());
					pst03.setString(5, tripModel.getLr_number());
					pst03.setString(6, tripModel.getSource());
					pst03.setString(7, tripModel.getDestination());
					
					pst03.setString(8, tripModel.getCommission());
					pst03.setString(9, trans[0]);
					pst03.setString(10, tripModel.getCommission_id());
					pst03.setString(11, "101");
					pst03.setString(12, "Credit");
					pst03.setString(13, tripModel.getBill_no());
					pst03.setString(14, trans[1]);
					int c3 = pst03.executeUpdate();
					
					
					System.out.println("c3 :"+c3);
					
					
					PreparedStatement pst04 = conn.prepareStatement("update lr set commission_done_status='1' where LR_no = '"+tripModel.getLr_number()+"'");
					int c4 = pst04.executeUpdate();
					
					System.out.println("c4: "+c4);
				
				
				
				
				}
				
				
				
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
				DBConnection.closeConnection();
				
			return response;
		}
		
		
		
		
		public List<TripModel> fetchUpDownDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			
			Connection conn=connection.getConnection();
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT `trip_id`, `updown_id`,  `vehicle_no`, `driver_name`, `source`, `destination`, `updown` FROM `updown`");
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setSource(rs.getString("source"));
						tripModel1.setDestination(rs.getString("destination"));
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setUpdown(rs.getString("updown"));
						
						
						PreparedStatement pst1 = conn.prepareStatement("select sum(exp_amount) from tripissue where trip_id = '"+tripModel1.getTrip_id()+"'");
						ResultSet rs1 = pst1.executeQuery();
						
						if(rs1.next())
						{
							tripModel1.setTrip_exp_amount(rs1.getString(1));
						}
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		
		
		public String insertLRDetails(TripModel tripModel, userinfo bean) {
			
			String response = "";
			// TODO Auto-generated method stub
			String stringValue2 = "";
			String stringValue3 = "";
			
			int len1 = 0;
			
			Connection conn=connection.getConnection();
			
			
			
			try {
				
				
				
			
			PreparedStatement pst2 = conn.prepareStatement("insert into LR(trip_id, updown_id, LR_no, Customer_name, date, mobile, source, destination, transporter_name, vehicle_no, driver_name, total_amount, advance, balance, customer_no, driver_code, transporter_code,order_id,status,transport_amount,volume,insurance,booking,val_rupees,freight,username,datetime,inquiry_id,shipname,shipadd,shipstate,shipgstn,dest_contact_person,dest_contact_no,loadname,loadadd,loadstate,loadgstn,load_contact_person,load_contact_no,driver_mobile,bill_to_custname,bill_to_custid,invoice_No,vehicle_Type,buyername,buyeradd,buyerstatus,buyergstn,buyer_contact_person,buyer_contact_no,invoice_value,owner_risk) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			System.out.println("oooooooooooooooooo----------"+pst2);
			
			pst2.setString(1, tripModel.getTrip_id());
			pst2.setString(2, tripModel.getUpdown_id());
			pst2.setString(3, tripModel.getLr_number());
			System.out.println("111111111111");
			String customer = tripModel.getCustomer_name();
			String transporter = tripModel.getTransporter_name();
			
			String driver = tripModel.getDriver_name();
			
			//String[] cust = customer.split("-");
			
			String[] trans = transporter.split("-");
			
			//String[] dd = driver.split("-");
			
			/*pst2.setString(4, tripModel.getCustomer_name());*/
			pst2.setString(4, customer);
			pst2.setString(5, CoreData.getDateFormatAsDb(tripModel.getDate()));
			
			PreparedStatement pstmb = conn.prepareStatement("select * from customer_master_details where customer_name='"+customer+"'");
			ResultSet rs = pstmb.executeQuery();
			String mobile ="";
			String cust_no ="";
			if(rs.next())
			{
				mobile = rs.getString("mobile_no");
				cust_no=rs.getString("customer_no");
			}
			
		
			pst2.setString(6, mobile);
			pst2.setString(7, tripModel.getSource());
			pst2.setString(8, tripModel.getDestination());
			pst2.setString(9, trans[0]);
			pst2.setString(10, tripModel.getVehicle_no());
			pst2.setString(11,driver);
			pst2.setString(12, tripModel.getTotal_amount());
			pst2.setString(13, tripModel.getAdvance());
			pst2.setString(14, tripModel.getBalance());
			pst2.setString(15, cust_no);
			System.out.println("444444");
			/*PreparedStatement pstdc = conn.prepareStatement("select driver_code from trip where trip_id = '"+tripModel.getTrip_id()+"'");
			ResultSet rsd = pstdc.executeQuery();
			String driver_code = "";
			if(rsd.next())
			{
				driver_code = rsd.getString(1);
			}*/
			
			
			pst2.setString(16,"");
			pst2.setString(17, trans[1]);
			
			pst2.setString(18, tripModel.getOrder_id());
			
			pst2.setString(19,"0");
			
			pst2.setString(20, tripModel.getTotal_amount());
			
			pst2.setString(21, tripModel.getVolume());
			
			pst2.setString(22, tripModel.getInsurance());
			pst2.setString(23, tripModel.getBooking());
			pst2.setString(24, tripModel.getVal_rupees());
			pst2.setString(25, tripModel.getFreight());
			System.out.println("11111111111122222");
			//pst2.setString(26,bean.getUsername());
			pst2.setString(26,"hsl");
			//System.out.println("-----------------------"+bean.getUsername());
			
			
			pst2.setString(27,SystemDateTime.CurrentDateTime());
			
			pst2.setString(28,tripModel.getInquiry_id());
			
			
			pst2.setString(29, tripModel.getShipname());
			
			pst2.setString(30, tripModel.getShipadd());
			System.out.println("1111111111112222233333");
			pst2.setString(31, tripModel.getShipstate());
			
			pst2.setString(32, tripModel.getShipgstn());
			
			pst2.setString(33, tripModel.getDest_contact_person());
			
			pst2.setString(34, tripModel.getDest_contact_no());
			
			
			pst2.setString(35, tripModel.getLoadname());	
			
			pst2.setString(36, tripModel.getLoadadd());	
			
			pst2.setString(37, tripModel.getLoadstate());	
			
			pst2.setString(38, tripModel.getLoadgstn());	
			
			pst2.setString(39, tripModel.getLoad_contact_person());	
			System.out.println("111111111111222223333344444");

			pst2.setString(40, tripModel.getLoad_contact_no());
			
			pst2.setString(41, tripModel.getDriver_mobile());
			
            String name="";
            String id="";
            try {
			
			String ss[]=tripModel.getBill_to().split("-");
            
			   name=ss[0];
	           id=ss[1];
	           
	           if(ss[1].equals("")||ss==null)
	           {
	        	   id="";
	           }
            }
            catch(Exception ex)
            {
            	System.out.println(ex.getMessage());
            }
			
			pst2.setString(42, name);
			pst2.setString(43, id);
			
			
			
			
			pst2.setString(44, tripModel.getInvoice_No());
			pst2.setString(45, tripModel.getVehicle_Type());
			
			System.out.println("1111111111112222233333444445555");
			pst2.setString(46, tripModel.getBuyername());	
			
			pst2.setString(47, tripModel.getBuyeradd());	
			
			pst2.setString(48, tripModel.getBuyerstatus());	
			
			pst2.setString(49, tripModel.getBuyergstn());	
			System.out.println("11111111111122222333334444455555");
			pst2.setString(50, tripModel.getBuyer_contact_person());	
			
			pst2.setString(51, tripModel.getBuyer_contact_no());
			
			pst2.setString(52, tripModel.getInvoice_value());	
			
			pst2.setString(53, tripModel.getOwner_risk());	
			
			int c2 =pst2.executeUpdate();
			System.out.println("lllllllllllllllllll--------------"+pst2);
			
			
			
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set creatlr_date=? where enq_id=?");
				
				pst12.setString(2, tripModel.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			
			System.out.println("pst2 .... "+pst2);
			
			
			PreparedStatement pstd = conn.prepareStatement("insert into LR_details(LR_no, description, weight, amount,order_id,no_of_package,type_of_packing) values(?,?,?,?,?,?,?)");
			
			int k = 0;
			
			try {
				for (int l = 0; l < tripModel.getCc().length; l++) {
					
					if ((tripModel.getAa()[l] != "")) {
						
						pstd.setString(1, tripModel.getLr_number());
						
						pstd.setString(2, tripModel.getCc()[l]);
						pstd.setString(3, tripModel.getGg()[l]);
						/*pstd.setString(4, tripModel.getHh()[l]);*/
						pstd.setString(4, tripModel.getIi()[l]);
						pstd.setString(5, tripModel.getOrder_id());
						
						pstd.setString(6, tripModel.getAa()[l]);
						pstd.setString(7, tripModel.getBb()[l]);
						/*pstd.setString(9, tripModel.getDd()[l]);*/
						/*pstd.setString(9, tripModel.getEe()[l]);
						pstd.setString(10, tripModel.getFf()[l]);
						*/
						k = pstd.executeUpdate();
						
						System.out.println("lr details deta --------------------------"+pstd);
						
					}
				}
				System.out.println("size k = "+k);
				
				
				
				/*if(!tripModel.getCommission().equals("") && !tripModel.getCommission().equals("0"))
				{
					*/
					

					// TODO Auto-generated method stub
					//String response="";
					
						String stringValue02 = "";
						String stringValue03 = "";
						
						String stringValue04 = "";
						String stringValue05 = "";
						
						
						int len01 = 0;
						try {
						PreparedStatement preparedStatement03 = conn
								.prepareStatement("select  max(SUBSTRING(commission_id,-4)) as myval1 from commission");
						
						
						String mystr02 = "";
						int myval02 = 0;
						ResultSet resultSet02 = preparedStatement03.executeQuery();
						
						if (resultSet02.next()) {
							try {
								mystr02 = resultSet02.getString("myval1");
								myval02 = Integer.parseInt(mystr02);
								myval02 = myval02 + 1;
							} catch (Exception e) {
								// TODO: handle exception
								myval02 = 1;
								mystr02 = "";
							}
						}
						
						
						int size02 = len01 + 1;
						stringValue03 = String.valueOf(myval02);
						
							if (stringValue03.length() == 1) {
								stringValue03 = "HSL/COMM/" + "000" + stringValue03;
							} else if (stringValue03.length() == 2) {
								stringValue03 = "HSL/COMM/" + "00" + stringValue03;
							} else if (stringValue03.length() == 3) {
								stringValue03 = "HSL/COMM/" + "0" + stringValue03;
							} else {
								stringValue03 = "HSL/COMM/" + stringValue03;
							}
							tripModel.setCommission_id(stringValue03);	
						
								
							
						
						
					try {
						PreparedStatement pst02 = conn.prepareStatement("insert into commission(trip_id, updown_id, LR_no, source, destination, vehicle_no, driver_name, commission_amount, transporter_name, commission_id, remaining_amount, transporter_code, date,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						
						pst02.setString(1, tripModel.getTrip_id());
						pst02.setString(2, tripModel.getUpdown_id());
						pst02.setString(3, tripModel.getLr_number());
						pst02.setString(4, tripModel.getSource());
						pst02.setString(5, tripModel.getDestination());
						pst02.setString(6, tripModel.getVehicle_no());
						pst02.setString(7, tripModel.getDriver_name());
						//pst02.setString(8, tripModel.getTotal_amount());
						pst02.setString(9, trans[0]);
						pst02.setString(10, tripModel.getCommission_id());
						
						

						try {
						PreparedStatement pstmbd = conn.prepareStatement("select * from pricing where inquiry_id='"+tripModel.getInquiry_id()+"'");
						ResultSet rsd = pstmbd.executeQuery();
						
						if(rsd.next())
						{
							pst02.setString(8, rsd.getString("total"));
							pst02.setString(11, rsd.getString("total"));
						}
						}
						catch(Exception ee)
						{
							System.out.println(ee.getMessage());
							pst02.setString(11, tripModel.getTotal_amount());
							pst02.setString(8, tripModel.getTotal_amount());
						}
						
						
						
						
						//pst02.setString(11, tripModel.getTotal_amount());
						
						pst02.setString(12, trans[1]);
						pst02.setString(13, tripModel.getDate());
						
						pst02.setString(14,bean.getUsername());
						pst02.setString(15,SystemDateTime.CurrentDateTime());
						
						System.out.println("c1 : "+pst02);
						
						int c1 = pst02.executeUpdate();
						
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						System.out.println("Error:"+e.getMessage());
						
					}
					
					
					
					
					
					
					
					int len02 = 0;
					PreparedStatement preparedStatement04 = conn
							.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from transportercreditdebit");
					
					
					String mystr03 = "";
					int myval03 = 0;
					ResultSet resultSet03 = preparedStatement04.executeQuery();
					
					if (resultSet03.next()) {
						try {
							mystr03 = resultSet03.getString("myval1");
							myval03 = Integer.parseInt(mystr03);
							myval03 = myval03 + 1;
						} catch (Exception e) {
							// TODO: handle exception
							myval03 = 1;
							mystr03 = "";
						}
					}
					
					
					int size3 = len02 + 1;
					stringValue05 = String.valueOf(myval03);
					
						if (stringValue05.length() == 1) {
							stringValue05 = "HSL/BILLNO/" + "000" + stringValue05;
						} else if (stringValue05.length() == 2) {
							stringValue05 = "HSL/BILLNO/" + "00" + stringValue05;
						} else if (stringValue05.length() == 3) {
							stringValue05 = "HSL/BILLNO/" + "0" + stringValue05;
						} else {
							stringValue05 = "HSL/BILLNO/" + stringValue05;
						}
						tripModel.setBill_no(stringValue05);	
					
					
					try {
					PreparedStatement pst03 = conn.prepareStatement("insert into transportercreditdebit(Customercode, date, trip_id, updown_id, LR_no, source, destination,  Amount, Name, Documentsno, Typecode, type, billno, transporter_code,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					
					
					pst03.setString(1, cust_no);
					pst03.setString(2, CoreData.getDateFormatAsDb(tripModel.getDate()));
					pst03.setString(3, tripModel.getTrip_id());
					pst03.setString(4, tripModel.getUpdown_id());
					pst03.setString(5, tripModel.getLr_number());
					pst03.setString(6, tripModel.getSource());
					pst03.setString(7, tripModel.getDestination());
					
					try {
					PreparedStatement pstmbd = conn.prepareStatement("select * from pricing where inquiry_id='"+tripModel.getInquiry_id()+"'");
					ResultSet rsd = pstmbd.executeQuery();
					
					if(rsd.next())
					{
						pst03.setString(8, rsd.getString("total"));
					}
					}
					catch(Exception ee)
					{
						System.out.println(ee.getMessage());
						pst03.setString(8, tripModel.getTotal_amount());
					}
					
					
					
					pst03.setString(9, trans[0]);
					pst03.setString(10, tripModel.getLr_number());
					pst03.setString(11, "101");
					pst03.setString(12, "Credit");
					pst03.setString(13, tripModel.getBill_no());
					pst03.setString(14, trans[1]);
					
					pst03.setString(15,bean.getUsername());
					pst03.setString(16,SystemDateTime.CurrentDateTime());
					
					int c3 = pst03.executeUpdate();
					
					
					System.out.println("c3 :"+c3);
					}
					catch(Exception ee)
					{
						System.out.println(ee.getMessage());
					}
					
					/*PreparedStatement pst04 = conn.prepareStatement("update lr set commission_done_status='1' where LR_no = '"+tripModel.getLr_number()+"'");
					int c4 = pst04.executeUpdate();
					
					System.out.println("c4: "+c4);*/
					
					
					
						response= "success";
					
					
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
						
						
						
								
						
						
				////////////// Update Order Report/////////////////////////////////////		
						
					try
					{
						
						
						PreparedStatement pst=conn.prepareStatement("update order_table set status='1',"
														+ "shipname='"+tripModel.getShipname()+"', "
														+ "shipadd='"+tripModel.getShipadd()+"', "
														+ "shipstate='"+tripModel.getShipstate()+"', "
														+ "shipgstn='"+tripModel.getShipgstn()+"', "
														+ "dest_contact_person='"+tripModel.getDest_contact_person()+"', "
														+ "dest_contact_no='"+tripModel.getDest_contact_no()+"', "
														+ "loadname='"+tripModel.getLoadname()+"', "
														+ "loadadd='"+tripModel.getLoadadd()+"', "
														+ "loadstate='"+tripModel.getLoadstate()+"', "
														+ "loadgstn='"+tripModel.getLoadgstn()+"', "
														+ "load_contact_person='"+tripModel.getLoad_contact_person()+"', "
														+ "load_contact_no='"+tripModel.getLoad_contact_no()+"', "
														+ "transporter_name='"+trans[0]+"', "
														+ "driver_name='"+driver+"', "
														+ "transport_code='"+trans[1]+"' where order_id='"+tripModel.getOrder_id()+"' and lr_no='"+tripModel.getLr_number()+"'");
						
									
								System.out.println("Update::"+pst);
						
								int i=pst.executeUpdate();
						
						
								response= "success";
						
						}catch(Exception e)
						{
						
							e.printStackTrace();
							System.out.println(e.getMessage());
						
						}
						
						
						
		///////////// Update Inquiry Status Report ///////////
					
					
					try {
			
			
						String q1 = "update inquiry_status set lr_username='"+bean.getUsername()+"',lr_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id='"+tripModel.getInquiry_id()+"'";
			

						PreparedStatement ps = conn.prepareStatement(q1);	
			
						//System.out.println("SQL:"+ps);
				
						ps.executeUpdate();
				
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			
						System.out.println(e.getMessage());
					}
					
						
					
					return response;
					
				
				
		
			} catch (Exception e) {
				e.printStackTrace();
			}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return "success";
		}
		
		
		
		
		
		
		public String deliveryinsert(TripModel tripModel, userinfo bean) {
			
			String response = "";
			// TODO Auto-generated method stub
			String stringValue2 = "";
			String stringValue3 = "";
			String mobile ="";
			String cust_no ="";
			
			int len1 = 0;
			
			Connection conn=connection.getConnection();
			
				
				
				try {
				
					
					PreparedStatement preparedStatement3 = conn
						.prepareStatement("select  max(SUBSTRING(delivery_id,-4)) as myval1 from delivery_done1");
				
				
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
					
					tripModel.setDelivery_id(stringValue3);
				
				}	
				catch(Exception e)
				{
					
					System.out.println("Error:"+e.getMessage());
				}
				try {	
					System.out.println("----------------11111"+ tripModel.getPath2());
					
				
			PreparedStatement pst2 = conn.prepareStatement("insert into delivery_done1(trip_id, updown_id, LR_no, Customer_name, date, mobile, source, destination, transporter_name, vehicle_no, driver_name, total_amount, advance, balance, customer_no, driver_code, transporter_code,order_id,status,transport_amount,volume,insurance,booking,val_rupees,freight,username,datetime,inquiry_id,shipname,shipadd,shipstate,shipgstn,dest_contact_person,dest_contact_no,loadname,loadadd,loadstate,loadgstn,load_contact_person,load_contact_no,driver_mobile,delivery_id,delivery_Date,photus,buyername,buyeradd,buyerstatus,buyergstn,buyer_contact_person,buyer_contact_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst2.setString(1, tripModel.getTrip_id());
			//System.out.println("1");
			
			pst2.setString(2, tripModel.getUpdown_id());
			
			//System.out.println("2");
			pst2.setString(3, tripModel.getLr_number());
			
			//System.out.println("3");
			
			String customer = tripModel.getCustomer_code();
			String transporter = tripModel.getTransporter_name();
			
			String driver = tripModel.getDriver_name();
			
			//String[] cust = customer.split("-");
			
			String[] trans = transporter.split("-");
			
			//String[] dd = driver.split("-");
			
			/*pst2.setString(4, tripModel.getCustomer_name());*/
			
			
			//System.out.println("4");
			
			pst2.setString(5, CoreData.getDateFormatAsDb(tripModel.getDate()));
			
			//System.out.println("5");
			
			PreparedStatement pstmb = conn.prepareStatement("select * from customer_master_details where customer_no='"+customer+"'");
			ResultSet rs = pstmb.executeQuery();
			
			if(rs.next())
			{
				mobile = rs.getString("mobile_no");
				cust_no=rs.getString("customer_no");
				pst2.setString(4, rs.getString("customer_name"));
			}
			
			
			pst2.setString(6, mobile);
			//System.out.println("6");
			pst2.setString(7, tripModel.getSource());
			//System.out.println("7");
			pst2.setString(8, tripModel.getDestination());
			//System.out.println("8");
			pst2.setString(9, trans[0]);
			//System.out.println("9");
			pst2.setString(10, tripModel.getVehicle_no());
			//System.out.println("10");
			pst2.setString(11,driver);
			//System.out.println("11");
			pst2.setString(12, tripModel.getTotal_amount());
			//System.out.println("12");
			pst2.setString(13, tripModel.getAdvance());
			//System.out.println("13");
			pst2.setString(14, tripModel.getBalance());
			//System.out.println("14");
			pst2.setString(15, cust_no);
			//System.out.println("15");
			/*PreparedStatement pstdc = conn.prepareStatement("select driver_code from trip where trip_id = '"+tripModel.getTrip_id()+"'");
			ResultSet rsd = pstdc.executeQuery();
			String driver_code = "";
			if(rsd.next())
			{
				driver_code = rsd.getString(1);
			}*/
			
			
			pst2.setString(16,"");
			pst2.setString(17, trans[1]);
			
			pst2.setString(18, tripModel.getOrder_id());
			
			pst2.setString(19,"0");
			
			pst2.setString(20, tripModel.getTotal_amount());
			
			pst2.setString(21, tripModel.getVolume());
			
			pst2.setString(22, tripModel.getInsurance());
			pst2.setString(23, tripModel.getBooking());
			pst2.setString(24, tripModel.getVal_rupees());
			pst2.setString(25, tripModel.getFreight());
			
			pst2.setString(26,bean.getUsername());
			
			pst2.setString(27,SystemDateTime.CurrentDateTime());
			
			pst2.setString(28,tripModel.getInquiry_id());
			
			
			
			pst2.setString(29, tripModel.getShipname());
			
			pst2.setString(30, tripModel.getShipadd());
			
			pst2.setString(31, tripModel.getShipstate());
			
			pst2.setString(32, tripModel.getShipgstn());
			
			pst2.setString(33, tripModel.getDest_contact_person());
			
			pst2.setString(34, tripModel.getDest_contact_no());
			
			
			pst2.setString(35, tripModel.getLoadname());	
			
			pst2.setString(36, tripModel.getLoadadd());	
			
			pst2.setString(37, tripModel.getLoadstate());	
			
			pst2.setString(38, tripModel.getLoadgstn());	
			
			pst2.setString(39, tripModel.getLoad_contact_person());	
			
			pst2.setString(40, tripModel.getLoad_contact_no());
			
			pst2.setString(41, tripModel.getDriver_mobile());
			
			pst2.setString(42, tripModel.getDelivery_id());
			
			
			pst2.setString(43,tripModel.getDelivery_Date());
			
			pst2.setString(44, tripModel.getPath2());
			
			
			pst2.setString(45, tripModel.getBuyername());	
			
			pst2.setString(46, tripModel.getBuyeradd());	
			
			pst2.setString(47, tripModel.getBuyerstatus());	
			
			pst2.setString(48, tripModel.getBuyergstn());	
			
			pst2.setString(49, tripModel.getBuyer_contact_person());	
			
			pst2.setString(50, tripModel.getBuyer_contact_no());
			
			
			
			
			System.out.println("pst2 .... "+pst2);
			
			int c2 =pst2.executeUpdate();
			
			System.out.println("****************************---------------"+pst2);
			
			
			
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set Delivery_done=? where enq_id=?");
				
				pst12.setString(2, tripModel.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			}
			catch(Exception e)
			{
				
				System.out.println("Reeor:"+e.getMessage());
			}
			
			
		
			
			try {
				
				
				PreparedStatement pstd = conn.prepareStatement("insert into delivery_done_details1(LR_no, description, weight, rate, amount,order_id,no_of_package,type_of_packing,vehicle_type,source,destination,delivery_id) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				int k = 0;
				
		
				for (int l = 0; l < tripModel.getAa().length; l++) {
					
					if ((tripModel.getAa()[l] != "")) {
						
						pstd.setString(1, tripModel.getLr_number());
						
						pstd.setString(2, tripModel.getCc()[l]);
						pstd.setString(3, tripModel.getGg()[l]);
						pstd.setString(4, tripModel.getHh()[l]);
						pstd.setString(5, tripModel.getIi()[l]);
						pstd.setString(6, tripModel.getOrder_id());
						
						pstd.setString(7, tripModel.getAa()[l]);
						pstd.setString(8, tripModel.getBb()[l]);
						pstd.setString(9, tripModel.getDd()[l]);
						pstd.setString(10, tripModel.getEe()[l]);
						pstd.setString(11, tripModel.getFf()[l]);
						
						pstd.setString(12, tripModel.getDelivery_id());
						
						System.out.println("SQL:"+pstd);
						
						k = pstd.executeUpdate();
						
					}
				}
				
				
				
			}catch(Exception e)
			{
				System.out.println("Error:"+e.getMessage());
			}
				
			
			
			
				
				try {
					
					PreparedStatement pst4 = conn
							.prepareStatement("update lr set delivery_done_status='1',status='1' where LR_no = '"
									+ tripModel.getLr_number() + "'");
					
					
					int st = pst4.executeUpdate();
				
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				
				try {
					
					String inquiry="";
					
					PreparedStatement pp = conn.prepareStatement("select inquiry_id from lr where LR_no = '"+tripModel.getLr_number()+"'");
					
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
				
				
				

				Properties systemPropery = null;
				systemPropery = new Properties();
				
				
				String mobile1=mobile+",8805854900,8329596526,8788963179,7499083359";
				
				
				try {
					systemPropery
							.load(new InquiryDao()
									.getClass()
									.getResourceAsStream(
											"/com/master/dao/UserProfile.properties"));
					String userid = systemPropery.getProperty("USERID");
					String senderid = systemPropery.getProperty("SENDERID");
					String pass = systemPropery.getProperty("SMSPASS");
					String smsflag = systemPropery.getProperty("SMSFLAG");
					String os = "";
					String mob = "";
					
					String requestUrl = "http://bhashsms.com/api/sendmsg.php?user="
							+ userid
							+ "&pass="
							+ pass
							+ "&sender="
							+ senderid
							+ "&phone="
							+ mobile1
							+ "&text=Dear"+tripModel.getCustomer_name()+", Your  Arivel Vehicle No:"+tripModel.getVehicle_no()+"";

					

					requestUrl = requestUrl.replace(" ", "%20");
					
					URL url = new URL(requestUrl);
					
					System.out.println("URL:"+url);

					HttpURLConnection uc = (HttpURLConnection) url
							.openConnection();
					uc.addRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
					System.out.println("Error" + uc.getResponseMessage());

					uc.disconnect();

				
				} catch (MalformedURLException e) {
					
					System.out.println("MalformedURLException:"
							+ e.getMessage());
				} catch (IOException e) {
					
					System.out.println("IOException:" + e.getMessage());
				}
				
				
				
					
			
			DBConnection.closeConnection();
			
			return "success";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
public String pininsert(TripModel tripModel, userinfo bean) {
			
			String response = "";
			// TODO Auto-generated method stub
			String stringValue2 = "";
			String stringValue3 = "";
			String mobile ="";
			String cust_no ="";
			
			int len1 = 0;
			
			Connection conn=connection.getConnection();
				
				try {
					PreparedStatement preparedStatement3 = conn
						.prepareStatement("select  max(SUBSTRING(delivery_id,-4)) as myval1 from PI_done1");
				
				
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
						stringValue3 = "HSL/PI/" + "000" + stringValue3;
					} else if (stringValue3.length() == 2) {
						stringValue3 = "HSL/PI/" + "00" + stringValue3;
					} else if (stringValue3.length() == 3) {
						stringValue3 = "HSL/PI/" + "0" + stringValue3;
					} else {
						stringValue3 = "HSL/PI/" + stringValue3;
					}
					
					tripModel.setDelivery_id(stringValue3);
				
				}	
				catch(Exception e)
				{
					
					System.out.println("Error:"+e.getMessage());
				}
				try {	
					System.out.println("----------------11111"+ tripModel.getPath2());
					
				
			PreparedStatement pst2 = conn.prepareStatement("insert into PI_done1(trip_id, updown_id, LR_no, Customer_name, date, mobile, source, destination, transporter_name, vehicle_no, driver_name, total_amount, advance, balance, customer_no, driver_code, transporter_code,order_id,status,transport_amount,volume,insurance,booking,val_rupees,freight,username,datetime,inquiry_id,shipname,shipadd,shipstate,shipgstn,dest_contact_person,dest_contact_no,loadname,loadadd,loadstate,loadgstn,load_contact_person,load_contact_no,driver_mobile,delivery_id,delivery_Date,photus,buyername,buyeradd,buyerstatus,buyergstn,buyer_contact_person,buyer_contact_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst2.setString(1, tripModel.getTrip_id());
			//System.out.println("1");
			
			pst2.setString(2, tripModel.getUpdown_id());
			
			//System.out.println("2");
			pst2.setString(3, tripModel.getLr_number());
			
			//System.out.println("3");
			
			String customer = tripModel.getCustomer_code();
			String transporter = tripModel.getTransporter_name();
			
			String driver = tripModel.getDriver_name();
			
			//String[] cust = customer.split("-");
			
			String[] trans = transporter.split("-");
			
			//String[] dd = driver.split("-");
			
			/*pst2.setString(4, tripModel.getCustomer_name());*/
			
			
			//System.out.println("4");
			
			pst2.setString(5, CoreData.getDateFormatAsDb(tripModel.getDate()));
			
			//System.out.println("5");
			
			PreparedStatement pstmb = conn.prepareStatement("select * from customer_master_details where customer_no='"+customer+"'");
			ResultSet rs = pstmb.executeQuery();
			
			if(rs.next())
			{
				mobile = rs.getString("mobile_no");
				cust_no=rs.getString("customer_no");
				pst2.setString(4, rs.getString("customer_name"));
			}
			
			
			pst2.setString(6, mobile);
			//System.out.println("6");
			pst2.setString(7, tripModel.getSource());
			//System.out.println("7");
			pst2.setString(8, tripModel.getDestination());
			//System.out.println("8");
			pst2.setString(9, trans[0]);
			//System.out.println("9");
			pst2.setString(10, tripModel.getVehicle_no());
			//System.out.println("10");
			pst2.setString(11,driver);
			//System.out.println("11");
			pst2.setString(12, tripModel.getTotal_amount());
			//System.out.println("12");
			pst2.setString(13, tripModel.getAdvance());
			//System.out.println("13");
			pst2.setString(14, tripModel.getBalance());
			//System.out.println("14");
			pst2.setString(15, cust_no);
			//System.out.println("15");
			/*PreparedStatement pstdc = conn.prepareStatement("select driver_code from trip where trip_id = '"+tripModel.getTrip_id()+"'");
			ResultSet rsd = pstdc.executeQuery();
			String driver_code = "";
			if(rsd.next())
			{
				driver_code = rsd.getString(1);
			}*/
			
			
			pst2.setString(16,"");
			pst2.setString(17, trans[1]);
			
			pst2.setString(18, tripModel.getOrder_id());
			
			pst2.setString(19,"0");
			
			pst2.setString(20, tripModel.getTotal_amount());
			
			pst2.setString(21, tripModel.getVolume());
			
			pst2.setString(22, tripModel.getInsurance());
			pst2.setString(23, tripModel.getBooking());
			pst2.setString(24, tripModel.getVal_rupees());
			pst2.setString(25, tripModel.getFreight());
			
			pst2.setString(26,bean.getUsername());
			
			pst2.setString(27,SystemDateTime.CurrentDateTime());
			
			pst2.setString(28,tripModel.getInquiry_id());
			
			
			
			pst2.setString(29, tripModel.getShipname());
			
			pst2.setString(30, tripModel.getShipadd());
			
			pst2.setString(31, tripModel.getShipstate());
			
			pst2.setString(32, tripModel.getShipgstn());
			
			pst2.setString(33, tripModel.getDest_contact_person());
			
			pst2.setString(34, tripModel.getDest_contact_no());
			
			
			pst2.setString(35, tripModel.getLoadname());	
			
			pst2.setString(36, tripModel.getLoadadd());	
			
			pst2.setString(37, tripModel.getLoadstate());	
			
			pst2.setString(38, tripModel.getLoadgstn());	
			
			pst2.setString(39, tripModel.getLoad_contact_person());	
			
			pst2.setString(40, tripModel.getLoad_contact_no());
			
			pst2.setString(41, tripModel.getDriver_mobile());
			
			pst2.setString(42, tripModel.getDelivery_id());
			
			
			pst2.setString(43,tripModel.getDelivery_Date());
			
			pst2.setString(44, tripModel.getPath2());
			
			
			pst2.setString(45, tripModel.getBuyername());	
			
			pst2.setString(46, tripModel.getBuyeradd());	
			
			pst2.setString(47, tripModel.getBuyerstatus());	
			
			pst2.setString(48, tripModel.getBuyergstn());	
			
			pst2.setString(49, tripModel.getBuyer_contact_person());	
			
			pst2.setString(50, tripModel.getBuyer_contact_no());
			
			
			
			
			System.out.println("pst2 .... "+pst2);
			
			int c2 =pst2.executeUpdate();
			
			System.out.println("****************************---------------"+pst2);
			
			}
			catch(Exception e)
			{
				
				System.out.println("Reeor:"+e.getMessage());
			}
			/*try {
				
				
				PreparedStatement pstd = conn.prepareStatement("insert into delivery_done_details1(LR_no, description, weight, rate, amount,order_id,no_of_package,type_of_packing,vehicle_type,source,destination,delivery_id) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				int k = 0;
				
		
				for (int l = 0; l < tripModel.getAa().length; l++) {
					
					if ((tripModel.getAa()[l] != "")) {
						
						pstd.setString(1, tripModel.getLr_number());
						
						pstd.setString(2, tripModel.getCc()[l]);
						pstd.setString(3, tripModel.getGg()[l]);
						pstd.setString(4, tripModel.getHh()[l]);
						pstd.setString(5, tripModel.getIi()[l]);
						pstd.setString(6, tripModel.getOrder_id());
						
						pstd.setString(7, tripModel.getAa()[l]);
						pstd.setString(8, tripModel.getBb()[l]);
						pstd.setString(9, tripModel.getDd()[l]);
						pstd.setString(10, tripModel.getEe()[l]);
						pstd.setString(11, tripModel.getFf()[l]);
						
						pstd.setString(12, tripModel.getDelivery_id());
						
						System.out.println("SQL:"+pstd);
						
						k = pstd.executeUpdate();
						
					}
				}
				
				
				
			}catch(Exception e)
			{
				System.out.println("Error:"+e.getMessage());
			}*/
				
				
/*
				Properties systemPropery = null;
				systemPropery = new Properties();
				
				
				String mobile1=mobile+",8805854900,8329596526,8788963179,7499083359";
				
				
				try {
					systemPropery
							.load(new InquiryDao()
									.getClass()
									.getResourceAsStream(
											"/com/master/dao/UserProfile.properties"));
					String userid = systemPropery.getProperty("USERID");
					String senderid = systemPropery.getProperty("SENDERID");
					String pass = systemPropery.getProperty("SMSPASS");
					String smsflag = systemPropery.getProperty("SMSFLAG");
					String os = "";
					String mob = "";
					
					String requestUrl = "http://bhashsms.com/api/sendmsg.php?user="
							+ userid
							+ "&pass="
							+ pass
							+ "&sender="
							+ senderid
							+ "&phone="
							+ mobile1
							+ "&text=Dear"+tripModel.getCustomer_name()+", Your  Arivel Vehicle No:"+tripModel.getVehicle_no()+"";

					

					requestUrl = requestUrl.replace(" ", "%20");
					
					URL url = new URL(requestUrl);
					
					System.out.println("URL:"+url);

					HttpURLConnection uc = (HttpURLConnection) url
							.openConnection();
					uc.addRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
					System.out.println("Error" + uc.getResponseMessage());

					uc.disconnect();

				
				} catch (MalformedURLException e) {
					
					System.out.println("MalformedURLException:"
							+ e.getMessage());
				} catch (IOException e) {
					
					System.out.println("IOException:" + e.getMessage());
				}
				*/
				
				
					
			
			DBConnection.closeConnection();
			
			return "success";
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public List<TripModel> fetchLRDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			List<TripModel> list=new ArrayList<TripModel>();
			
			Connection conn=connection.getConnection();
			
			
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT * FROM `LR` where status='0'");
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						
						TripModel tripModel1=new TripModel();
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setLr_number(rs.getString("LR_no"));
						try {
							
						PreparedStatement pst12=conn.prepareStatement("SELECT * FROM  `issue_expenses` where LR_no='"+rs.getString("LR_no")+"'");
						ResultSet rs12=pst12.executeQuery();
						System.out.println("1...."+pst);
						if(rs12.next())
						{
							tripModel1.setExp_amount(rs12.getString("exp_amount"));
						}
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
						
						tripModel1.setSource(rs.getString("source"));
						tripModel1.setDestination(rs.getString("destination"));
						tripModel1.setCustomer_name(rs.getString("Customer_name"));
						tripModel1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
						tripModel1.setMobile(rs.getString("mobile"));
						tripModel1.setTotal_amount(rs.getString("total_amount"));
						
						tripModel1.setTransporter_name(rs.getString("transporter_name"));
						
						tripModel1.setTransporter_code(rs.getString("transporter_code"));
						
						tripModel1.setAdvance(rs.getString("advance"));
						
						tripModel1.setBalance(rs.getString("balance"));
						
						tripModel1.setOrder_id(rs.getString("order_id"));
						
						tripModel1.setCustomer_code(rs.getString("customer_no"));
						
						tripModel1.setCommission(rs.getString("transport_amount"));
						
						tripModel1.setVolume(rs.getString("volume"));
						
						tripModel1.setInsurance(rs.getString("insurance"));
						
						tripModel1.setBooking(rs.getString("booking"));
						
						tripModel1.setVal_rupees(rs.getString("val_rupees"));
						
						tripModel1.setFreight(rs.getString("freight"));
						
						tripModel1.setInquiry_id(rs.getString("inquiry_id"));
						
						
						tripModel1.setLoadname(rs.getString("loadname"));
						
						tripModel1.setLoadadd(rs.getString("loadadd"));
						
						tripModel1.setLoadstate(rs.getString("loadstate"));
						
						tripModel1.setLoadgstn(rs.getString("loadgstn"));
						
						tripModel1.setLoad_contact_person(rs.getString("load_contact_person"));
						
						tripModel1.setLoad_contact_no(rs.getString("load_contact_no"));
						
						tripModel1.setDest_contact_person(rs.getString("dest_contact_person"));
						
						tripModel1.setDest_contact_no(rs.getString("dest_contact_no"));
						
						tripModel1.setShipstate(rs.getString("shipstate"));
						
						tripModel1.setShipgstn(rs.getString("shipgstn"));
						
						tripModel1.setShipadd(rs.getString("shipadd"));
						
						tripModel1.setShipname(rs.getString("shipname"));
						
						tripModel1.setDriver_mobile(rs.getString("driver_mobile"));
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		public List<TripModel> newfetchLRDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			List<TripModel> list=new ArrayList<TripModel>();
			
			Connection conn=connection.getConnection();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT * FROM `LR` WHERE    Date BETWEEN ? AND ? and status<>'cancel' ");
					
					pst.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
					pst.setString(2, SysDate.getDateFormatAsDb(tripModel.getTo_date())) ;

					
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						
						TripModel tripModel1=new TripModel();
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setLr_number(rs.getString("LR_no"));
						try {
							
						PreparedStatement pst12=conn.prepareStatement("SELECT * FROM  `issue_expenses` where LR_no='"+rs.getString("LR_no")+"'");
						ResultSet rs12=pst12.executeQuery();
						System.out.println("1...."+pst);
						if(rs12.next())
						{
							tripModel1.setExp_amount(rs12.getString("exp_amount"));
						}
						}
						catch(Exception e)
						{
							System.out.println(e.getMessage());
						}
						
						tripModel1.setSource(rs.getString("source"));
						tripModel1.setDestination(rs.getString("destination"));
						tripModel1.setCustomer_name(rs.getString("Customer_name"));
						tripModel1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
						tripModel1.setMobile(rs.getString("mobile"));
						tripModel1.setTotal_amount(rs.getString("total_amount"));
						
						tripModel1.setTransporter_name(rs.getString("transporter_name"));
						
						tripModel1.setTransporter_code(rs.getString("transporter_code"));
						
						tripModel1.setAdvance(rs.getString("advance"));
						
						tripModel1.setBalance(rs.getString("balance"));
						
						tripModel1.setOrder_id(rs.getString("order_id"));
						
						tripModel1.setCustomer_code(rs.getString("customer_no"));
						
						tripModel1.setCommission(rs.getString("transport_amount"));
						
						tripModel1.setVolume(rs.getString("volume"));
						
						tripModel1.setInsurance(rs.getString("insurance"));
						
						tripModel1.setBooking(rs.getString("booking"));
						
						tripModel1.setVal_rupees(rs.getString("val_rupees"));
						
						tripModel1.setFreight(rs.getString("freight"));
						
						tripModel1.setInquiry_id(rs.getString("inquiry_id"));
						
						
						tripModel1.setLoadname(rs.getString("loadname"));
						
						tripModel1.setLoadadd(rs.getString("loadadd"));
						
						tripModel1.setLoadstate(rs.getString("loadstate"));
						
						tripModel1.setLoadgstn(rs.getString("loadgstn"));
						
						tripModel1.setLoad_contact_person(rs.getString("load_contact_person"));
						
						tripModel1.setLoad_contact_no(rs.getString("load_contact_no"));
						
						tripModel1.setDest_contact_person(rs.getString("dest_contact_person"));
						
						tripModel1.setDest_contact_no(rs.getString("dest_contact_no"));
						
						tripModel1.setShipstate(rs.getString("shipstate"));
						
						tripModel1.setShipgstn(rs.getString("shipgstn"));
						
						tripModel1.setShipadd(rs.getString("shipadd"));
						
						tripModel1.setShipname(rs.getString("shipname"));
						
						tripModel1.setDriver_mobile(rs.getString("driver_mobile"));
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public String insertAmtIssueDetails(TripModel tripModel, userinfo bean) {
			
			
			Connection conn=connection.getConnection();
			
			int c=0;
			try {
				String stringValue5 = "";
				int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from managercreditdebit");
				
				
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
						stringValue5 = "HSL/AMTISS/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "HSL/AMTISS/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "HSL/AMTISS/" + "0" + stringValue5;
					} else {
						stringValue5 = "HSL/AMTISS/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setAmount_issue_code(stringValue5);
				
					
				
				
				
				
				
				
				
				
				
				
			PreparedStatement pst = conn.prepareStatement("insert into amount_issue(date, amount, remark, given_by, given_to) values(?,?,?,?,?)");
			pst.setString(1, tripModel.getDate());
			pst.setString(2, tripModel.getAmount1());
			pst.setString(3, tripModel.getRemark());
			pst.setString(4, tripModel.getGiven_by());
			pst.setString(5, tripModel.getGiven_to());
			
			c = pst.executeUpdate();
			
			
			
			/*PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getAmount1());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();*/
			
			
			PreparedStatement pst4 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst4.setString(1,"");
			pst4.setString(2, tripModel.getDate());
			pst4.setString(3, tripModel.getAmount1());
			pst4.setString(4, tripModel.getGiven_to());
			pst4.setString(5,tripModel.getAmount_issue_code());
			pst4.setString(6, "201");
			pst4.setString(7, "Credit");
			pst4.setString(8, tripModel.getAmount_issue_code());
			pst4.setString(9, tripModel.getGiven_to());
			pst4.setString(10, tripModel.getRemark());
			
			int c2 = pst4.executeUpdate();
			
			
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			if(c>0)
				return "success";
			else
				return "fail";
		}
		
		
		
		
		public String insertTripIssueDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			String stringValue5 = "";
			int c=0;
			
			String response="";
			
			Connection conn=connection.getConnection();
			
			try {
				
				
				TripModel model = new TripModel();
				
				
				/*PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='101' ");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				if(rs1.next())
				{
					
						model.setDebit_amount(rs1.getString(1));
					
				}*/
				
				
				
				/*System.out.println("debit: "+model.getDebit_amount());
				PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='201' ");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					
						model.setCredit_amount(rs2.getString(1));
					
					
				}*/
				
				/*String debit = model.getDebit_amount();
				if(debit==null)
				{
					model.setDebit_amount("0");
				}
				
				String credit = model.getCredit_amount();
				
				if(credit==null)
				{
					model.setCredit_amount("0");
				}
				
				System.out.println("credit001: "+credit);
				
				double remainin_amt = Double.parseDouble(model.getCredit_amount()) - Double.parseDouble(model.getDebit_amount());
				model.setRemaining_amount(String.valueOf(remainin_amt));
				
				
				if(Double.parseDouble(model.getRemaining_amount())<Double.parseDouble(tripModel.getExp_amount()))
				{
					return "insufficient";
				}*/
				
				
				
				
				
				
				
				
				
				
				
				
					
				
				/*int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from managercreditdebit");
				
				
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
						stringValue5 = "LRISS/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "LRISS/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "LRISS/" + "0" + stringValue5;
					} else {
						stringValue5 = "LRISS/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setAmount_issue_code(stringValue5);*/		
				
				String pref="HSL/VCR";
				String stringValue1 = "1";
				try {
				PreparedStatement preparedStatement11 = conn
						.prepareStatement("select  max(SUBSTRING(voucher_no,-5)) as myval1 from issue_expenses  where LENGTH(voucher_no)>5 and voucher_no like '%"
								+ pref + "%' ");
				String mystr1 = "";
				int myval1 = 0;
			
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				if (resultSet11.next()) {
					try {
						mystr1 = resultSet11.getString("myval1");
						myval1 = Integer.parseInt(mystr1);
						myval1 = myval1 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval1 = 1;
						mystr1 = "";
					}
				}
		

				if (mystr1.equals("")) {
					stringValue1 = pref + "/0000" + stringValue1;

				} else {

					if (String.valueOf(myval1).length() == 1) {
						stringValue1 = pref + "/0000" + String.valueOf(myval1);

					} else if (String.valueOf(myval1).length() == 2) {
						stringValue1 = pref + "/000" + String.valueOf(myval1);
					} else if (String.valueOf(myval1).length() == 3) {
						stringValue1 = pref + "/00" + String.valueOf(myval1);
					} else  if (String.valueOf(myval1).length() == 4) {
						stringValue1 = pref + "/0" + String.valueOf(myval1);
					} else {
						stringValue1 = pref + "/" + String.valueOf(myval1);
					}
				}
				System.out.println("2");
				//model.setVoucher_no(stringValue1);
				System.out.println(model.getVoucher_no());
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
				
			PreparedStatement pst = conn.prepareStatement("insert into issue_expenses(LR_no, vehicle_no, driver_name, date, exp_parti, exp_amount, remark, given_by, pump_receipt, trip_id, updown_id,voucher_no) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, tripModel.getLr_number());
			pst.setString(2, tripModel.getVehicle_no());
			pst.setString(3, tripModel.getDriver_name());
			pst.setString(4, CoreData.getDateFormatAsDb(tripModel.getDate()));
			pst.setString(5, tripModel.getExp_parti());
			pst.setString(6, tripModel.getExp_amount());
			pst.setString(7, tripModel.getRemark());
			pst.setString(8, tripModel.getGiven_by());
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				pst.setString(9, tripModel.getPump_receipt());
			}
			else
			{
				pst.setString(9, "");
			}
			
			pst.setString(10, tripModel.getTrip_id());
			pst.setString(11, tripModel.getUpdown_id());
			pst.setString(12, stringValue1);
			
			c = pst.executeUpdate();
			
			
			response="success";
			
			System.out.println("pst: "+pst);
			
			/*PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getExp_amount());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();*/
			
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				
				String stringValue6 = "";
				int len4 = 0;
				PreparedStatement preparedStatement5 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from vehiclecreditdebit");
				
				
				String mystr4 = "";
				int myval4 = 0;
				ResultSet resultSet4 = preparedStatement5.executeQuery();
				
				if (resultSet4.next()) {
					try {
						mystr4 = resultSet4.getString("myval1");
						myval4 = Integer.parseInt(mystr4);
						myval4 = myval4 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval4 = 1;
						mystr4 = "";
					}
				}
				
				
				
				
				int size4 = len4 + 1;
				stringValue6 = String.valueOf(myval4);
				
					if (stringValue6.length() == 1) {
						stringValue6 = "HSL/BILL/" + "000" + stringValue6;
					} else if (stringValue6.length() == 2) {
						stringValue6 = "HSL/BILL/" + "00" + stringValue6;
					} else if (stringValue6.length() == 3) {
						stringValue6 = "HSL/BILL/" + "0" + stringValue6;
					} else {
						stringValue6 = "HSL/BILL/" + stringValue6;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setBill_no(stringValue6);;	
				
				
				PreparedStatement pst4 = conn.prepareStatement("insert into vehiclecreditdebit(Vehicle_no, date, Amount, Name, Documentsno, Typecode, type, billno, remark) values(?,?,?,?,?,?,?,?,?)");
				pst4.setString(1,tripModel.getVehicle_no());
				pst4.setString(2, CoreData.getDateFormatAsDb(tripModel.getDate()));
				pst4.setString(3, tripModel.getExp_amount());
				pst4.setString(4,tripModel.getGiven_by());
				pst4.setString(5,tripModel.getAmount_issue_code());
				pst4.setString(6, "101");
				pst4.setString(7, "Debit");
				pst4.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst4.setString(9, tripModel.getRemark());
				
				
				System.out.println("pst: "+pst4);
				
				int c2 = pst4.executeUpdate();
				
				
				response="success";
				
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				System.out.println(e.getMessage());
			}
			
			
			DBConnection.closeConnection();
			return response;
		}
		
		
		
		public String insertTripIssueDetails1(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			int c=0;
			String stringValue5;
			
			Connection conn=connection.getConnection();
			
			try {
				
				
				TripModel model = new TripModel();
				PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='101' ");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				if(rs1.next())
				{
					
						model.setDebit_amount(rs1.getString(1));
					
				}
				
				
				
				System.out.println("debit: "+model.getDebit_amount());
				PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='201' ");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					
						model.setCredit_amount(rs2.getString(1));
					
					
				}
				
				String debit = model.getDebit_amount();
				if(debit==null)
				{
					model.setDebit_amount("0");
				}
				
				String credit = model.getCredit_amount();
				
				if(credit==null)
				{
					model.setCredit_amount("0");
				}
				
				System.out.println("credit001: "+credit);
				
				double remainin_amt = Double.parseDouble(model.getCredit_amount()) - Double.parseDouble(model.getDebit_amount());
				model.setRemaining_amount(String.valueOf(remainin_amt));
				
				
				if(Double.parseDouble(model.getRemaining_amount())<Double.parseDouble(tripModel.getExp_amount()))
				{
					return "insufficient";
				}
				
				
				
				
				
			
				int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from managercreditdebit");
				
				
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
						stringValue5 = "HSL/TRPISS/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "HSL/TRPISS/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "HSL/TRPISS/" + "0" + stringValue5;
					} else {
						stringValue5 = "HSL/TRPISS/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setAmount_issue_code(stringValue5);	
				
				
				
				
				
				
				
				
			PreparedStatement pst = conn.prepareStatement("insert into issue_expenses(trip_id, vehicle_no, driver_name, date, exp_parti, exp_amount, remark, given_by, pump_receipt) values(?,?,?,?,?,?,?,?,?)");
			pst.setString(1, tripModel.getTrip_id());
			pst.setString(2, tripModel.getVehicle_no());
			pst.setString(3, tripModel.getDriver_name());
			pst.setString(4, tripModel.getDate());
			pst.setString(5, tripModel.getExp_parti());
			pst.setString(6, tripModel.getExp_amount());
			pst.setString(7, tripModel.getRemark());
			pst.setString(8, tripModel.getGiven_by());
			System.out.println("trip_id: "+tripModel.getTrip_id());
			System.out.println("exp_parti: "+tripModel.getExp_parti());
			try {
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				pst.setString(9, tripModel.getPump_receipt());
			}
			else
			{
				pst.setString(9, "");
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			c = pst.executeUpdate();
			
			
			PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getExp_amount());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();
			
			
			
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				
				String stringValue6 = "";
				int len4 = 0;
				PreparedStatement preparedStatement5 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from vehiclecreditdebit");
				
				
				String mystr4 = "";
				int myval4 = 0;
				ResultSet resultSet4 = preparedStatement5.executeQuery();
				
				if (resultSet4.next()) {
					try {
						mystr4 = resultSet4.getString("myval1");
						myval4 = Integer.parseInt(mystr4);
						myval4 = myval4 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval4 = 1;
						mystr4 = "";
					}
				}
				
				
				
				
				int size4 = len4 + 1;
				stringValue6 = String.valueOf(myval4);
				
					if (stringValue6.length() == 1) {
						stringValue6 = "HSL/BILL/" + "000" + stringValue6;
					} else if (stringValue6.length() == 2) {
						stringValue6 = "HSL/BILL/" + "00" + stringValue6;
					} else if (stringValue6.length() == 3) {
						stringValue6 = "HSL/BILL/" + "0" + stringValue6;
					} else {
						stringValue6 = "HSL/BILL/" + stringValue6;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setBill_no(stringValue6);;	
				
				
				
				
				
				
				
				
				
				PreparedStatement pst4 = conn.prepareStatement("insert into vehiclecreditdebit(Vehicle_no, date, Amount, Name, Documentsno, Typecode, type, billno, remark) values(?,?,?,?,?,?,?,?,?)");
				pst4.setString(1,tripModel.getVehicle_no());
				pst4.setString(2, tripModel.getDate());
				pst4.setString(3, tripModel.getExp_amount());
				pst4.setString(4,tripModel.getGiven_by());
				pst4.setString(5,tripModel.getAmount_issue_code());
				pst4.setString(6, "101");
				pst4.setString(7, "Debit");
				pst4.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst4.setString(9, tripModel.getRemark());
				
				int c2 = pst4.executeUpdate();
			}
			

		
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
				return "success";
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		public TripModel getVoucherNo() {
			// TODO Auto-generated method stub
			
			
			Connection conn=connection.getConnection();
			
			
			TripModel model = new TripModel();
			
			String voucher_final_id="HSL/VCR/0001";
			
			String pref="HSL/VCR";
			try {
			PreparedStatement preparedStatement11 = conn
					.prepareStatement("select  max(SUBSTRING(voucher_no,-5)) as myval1 from expense  where LENGTH(voucher_no)>5 and voucher_no like '%"
							+ pref + "%' ");
			String mystr1 = "";
			int myval1 = 0;
			String stringValue1 = "1";
			ResultSet resultSet11 = preparedStatement11.executeQuery();
			if (resultSet11.next()) {
				try {
					mystr1 = resultSet11.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval1 = 1;
					mystr1 = "";
				}
			}
	

			if (mystr1.equals("")) {
				stringValue1 = pref + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = pref + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = pref + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = pref + "/00" + String.valueOf(myval1);
				} else  if (String.valueOf(myval1).length() == 4) {
					stringValue1 = pref + "/0" + String.valueOf(myval1);
				} else {
					stringValue1 = pref + "/" + String.valueOf(myval1);
				}
			}
			System.out.println("2");
			model.setVoucher_no(stringValue1);
			System.out.println(model.getVoucher_no());
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return model;
		}
		
		
		
		public String insertExpenseDetails(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			String stringValue5 = "";
			
			Connection conn=connection.getConnection();
			
			
			int c=0;
			try {
				
				/*int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from managercreditdebit");
				
				
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
						stringValue5 = "EXP/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "EXP/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "EXP/" + "0" + stringValue5;
					} else {
						stringValue5 = "EXP/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setAmount_issue_code(stringValue5);	*/
				
				
				
				
				
				
				
				
			PreparedStatement pst = conn.prepareStatement("insert into expense(voucher_no, emp_name, date, exp_parti, exp_amount, remark, given_by, drv_code) values(?,?,?,?,?,?,?,?)");
			pst.setString(1, tripModel.getVoucher_no());
			
			if(tripModel.getExp_parti().equalsIgnoreCase("SALARY ADVANCE"))
			{
				String d[] = tripModel.getDriver_name().split("-");
				pst.setString(2,d[0]);
				pst.setString(8, d[1]);
			}
			else
			{
				String d[] = tripModel.getEmp_name().split("-");
				pst.setString(2,d[0]);
				pst.setString(8, d[1]);
			
			}
			
			pst.setString(3, tripModel.getDate());
			pst.setString(4, tripModel.getExp_parti());
			pst.setString(5, tripModel.getExp_amount());
			pst.setString(6, tripModel.getRemark());
			pst.setString(7, tripModel.getGiven_by());
			c = pst.executeUpdate();
			
			
			
			String[] giver = tripModel.getGiven_by().split("-");
			
			if(tripModel.getExp_parti().equalsIgnoreCase("SALARY ADVANCE"))
			{
				String[] drv = tripModel.getDriver_name().split("-");
				String[] empname = tripModel.getEmp_name().split("-");
				
				String stringValue6 = "";
				int len4 = 0;
				PreparedStatement preparedStatement5 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from drivercreditdebit");
				
				
				String mystr4 = "";
				int myval4 = 0;
				ResultSet resultSet4 = preparedStatement5.executeQuery();
				
				if (resultSet4.next()) {
					try {
						mystr4 = resultSet4.getString("myval1");
						myval4 = Integer.parseInt(mystr4);
						myval4 = myval4 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval4 = 1;
						mystr4 = "";
					}
				}
				
				
				
				
				int size4 = len4 + 1;
				stringValue6 = String.valueOf(myval4);
				
					if (stringValue6.length() == 1) {
						stringValue6 = "HSL/BILL/" + "000" + stringValue6;
					} else if (stringValue6.length() == 2) {
						stringValue6 = "HSL/BILL/" + "00" + stringValue6;
					} else if (stringValue6.length() == 3) {
						stringValue6 = "HSL/BILL/" + "0" + stringValue6;
					} else {
						stringValue6 = "HSL/BILL/" + stringValue6;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setBill_no(stringValue6);;	
				
				PreparedStatement pst4 = conn.prepareStatement("insert into drivercreditdebit(driver_id, date, Amount, Name, Documentsno, Typecode, type, billno, remark, driver_name) values(?,?,?,?,?,?,?,?,?,?)");
				pst4.setString(1, drv[1]);
				pst4.setString(2, tripModel.getDate());
				pst4.setString(3, tripModel.getExp_amount());
				pst4.setString(4, drv[0]);
				pst4.setString(5, tripModel.getVoucher_no());
				pst4.setString(6, "201");
				pst4.setString(7, "Credit");
				pst4.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst4.setString(9, "Salary Advance");
				pst4.setString(10, drv[0]);
				int c2 = pst4.executeUpdate();
				
				PreparedStatement pst45 = conn.prepareStatement("insert into supervisorcreditdebit(emp_Name, date, Amount, emp_id, Documentsno, Typecode, type, billno, Remark, given_id,given_name) values(?,?,?,?,?,?,?,?,?,?,?)");
				pst45.setString(1, drv[0]);
				pst45.setString(2, tripModel.getDate());
				pst45.setString(3, tripModel.getExp_amount());
				pst45.setString(4, drv[1]);
				pst45.setString(5, tripModel.getVoucher_no());
				pst45.setString(6, "202");
				pst45.setString(7, "Debit");
				pst45.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst45.setString(9, tripModel.getRemark());
				pst45.setString(10, giver[1]);
				pst45.setString(11, giver[0]);
				
				int c22 = pst45.executeUpdate();
				
				PreparedStatement pst455 = conn.prepareStatement("insert into diley_cashreport(Name, Date, Amount, emp_id, Documentsno, Typecode, type, billno, Remark, cash_source,form_source) values(?,?,?,?,?,?,?,?,?,?,?)");
				pst455.setString(1, drv[0]);
				pst455.setString(2, tripModel.getDate());
				pst455.setString(3, tripModel.getExp_amount());
				pst455.setString(4, drv[1]);
				pst455.setString(5, tripModel.getVoucher_no());
				pst455.setString(6, "202");
				pst455.setString(7, "Debit");
				pst455.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst455.setString(9, tripModel.getRemark());
				pst455.setString(10, " ");
				pst455.setString(11, "Expense Form");
				
				int c252 = pst455.executeUpdate();
				
				System.out.println("888888888888888-------------"+pst455);
				
		}
			
			String emp[] = tripModel.getEmp_name().split("-");
			
			try {
			PreparedStatement pst45 = conn.prepareStatement("insert into supervisorcreditdebit(emp_Name, date, Amount, emp_id, Documentsno, Typecode, type, billno, Remark,given_id,given_name) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst45.setString(1, emp[0]);
			pst45.setString(2, tripModel.getDate());
			pst45.setString(3, tripModel.getExp_amount());
			pst45.setString(4, emp[1]);
			pst45.setString(5, tripModel.getVoucher_no());
			pst45.setString(6, "202");
			pst45.setString(7, "Debit");
			pst45.setString(8, tripModel.getBill_no());
			//pst3.setString(9, tripModel.getGiven_by());
			pst45.setString(9, tripModel.getRemark());
			pst45.setString(10, giver[1]);
			pst45.setString(11, giver[0]);
			
			 pst45.executeUpdate();
			 
			 PreparedStatement pst455 = conn.prepareStatement("insert into diley_cashreport(Name, Date, Amount, emp_id, Documentsno, Typecode, type, billno, Remark, cash_source,form_source) values(?,?,?,?,?,?,?,?,?,?,?)");
				pst455.setString(1, emp[0]);
				pst455.setString(2, tripModel.getDate());
				pst455.setString(3, tripModel.getExp_amount());
				pst455.setString(4, emp[0]);
				pst455.setString(5, tripModel.getVoucher_no());
				pst455.setString(6, "202");
				pst455.setString(7, "Debit");
				pst455.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst455.setString(9, tripModel.getRemark());
				pst455.setString(10, " ");
				pst455.setString(11, "Expense Form");
				
				int c252 = pst455.executeUpdate();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			
			/*PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getAmount1());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();*/
			
			
			
			/*PreparedStatement pst4 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst4.setString(1,"");
			pst4.setString(2, tripModel.getDate());
			pst4.setString(3, tripModel.getAmount1());
			pst4.setString(4, tripModel.getEmp_name());
			pst4.setString(5,tripModel.getAmount_issue_code());
			pst4.setString(6, "201");
			pst4.setString(7, "Credit");
			pst4.setString(8, tripModel.getAmount_issue_code());
			pst4.setString(9, tripModel.getEmp_name());
			pst4.setString(10, tripModel.getRemark());
			
			int c2 = pst4.executeUpdate();*/
			
			
			
			
			
			
			
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
				return "success";
			
		}
		
		
		
		public List<TripModel> fetchTripExpensesDetails(TripModel tripModel, String from_date, String to_date, userinfo bean) {
			// TODO Auto-generated method stub
			
			int sno = 1;
			String cond="";
			
			Connection conn=connection.getConnection();
			
			
			String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];
			
			
			if(!tripModel.getGiven_by().equals("")){
				cond= "  and given_by like '%"+tripModel.getGiven_by()+"%' ";
				
			}
			
			if(!drv_name.equals("")){
				cond= "  and driver_name like '%"+drv_name+"%' ";
				
			}
			
			if(!tripModel.getExp_parti().equals("")){
				cond= "  and exp_parti like '%"+tripModel.getExp_parti()+"%' ";
				
			}
			
			if(!tripModel.getVehicle_no().equals("")){
				cond= "  and vehicle_no like '%"+tripModel.getVehicle_no()+"%' ";
				
			}
			
			
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT `LR_no`, `date`, `exp_parti`, `exp_amount`, `vehicle_no`, `driver_name`, `given_by`, `trip_id`, `updown_id` FROM `issue_expenses` where LR_no is not null and date between '"+from_date+"'"+ "and '"+to_date+"' "+cond);
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						tripModel1.setLr_number(rs.getString("LR_no"));
						tripModel1.setDate(rs.getString("date"));
						tripModel1.setExp_parti(rs.getString("exp_parti"));
						tripModel1.setExp_amount(rs.getString("exp_amount"));
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setGiven_by(rs.getString("given_by"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						
						PreparedStatement pst1 = conn.prepareStatement("select Customer_name, source, destination from LR where LR_no = '"+tripModel1.getLr_number()+"'");
						
						ResultSet rs1 = pst1.executeQuery();
						
						String customer = "";
						String source = "";
						String destination = "";
						
						if(rs1.next())
						{
							customer = rs1.getString(1);
							source = rs1.getString(2);
							destination = rs1.getString(3);
						}
						
						tripModel1.setCustomer_name(customer);
						tripModel1.setSource(source);
						tripModel1.setDestination(destination);
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		public List<TripModel> fetchAmountIssueDetails(TripModel tripModel, String from_date, String to_date, userinfo bean) {
			// TODO Auto-generated method stub
			List<TripModel> list=new ArrayList<TripModel>();
			
			Connection conn=connection.getConnection();
			
			int sno = 1;
			String cond="";
			
			
			if(!tripModel.getGiven_by().equals("")){
				cond= "  and given_by like '%"+tripModel.getGiven_by()+"%' ";
				
			}
			
			if(!tripModel.getGiven_to().equals("")){
				cond= "  and given_to like '%"+tripModel.getGiven_to()+"%' ";
				
			}
			
			
			
			
			
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT * FROM `amount_issue` where date between '"+from_date+"' and '"+to_date+"' "+cond);
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						tripModel1.setDate(rs.getString("date"));
						tripModel1.setAmount1(rs.getString("amount"));
						tripModel1.setRemark(rs.getString("remark"));
						tripModel1.setGiven_by(rs.getString("given_by"));
						tripModel1.setGiven_to(rs.getString("given_to"));
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		public List<TripModel> fetchExpenseDetails(String from_date, String to_date, TripModel tripModel, userinfo bean) {
			
			Connection conn=connection.getConnection();
			
			int sno = 1;
			String cond="";
			
			
			if(!tripModel.getGiven_by().equals("")){
				cond= "  and given_by like '%"+tripModel.getGiven_by()+"%' ";
				
			}
			
			if(!tripModel.getGiven_to().equals("")){
				cond= "  and emp_name like '%"+tripModel.getGiven_to()+"%' ";
				
			}
			
			if(!tripModel.getExp_parti().equals("")){
				cond= "  and exp_parti like '%"+tripModel.getExp_parti()+"%' ";
				
			}
			
			
			
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT * FROM `expense` where date between '"+from_date+"' and '"+to_date+"' "+cond);
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						tripModel1.setDate(rs.getString("date"));
						tripModel1.setVoucher_no(rs.getString("voucher_no"));
						tripModel1.setEmp_name(rs.getString("emp_name"));
						tripModel1.setExp_parti(rs.getString("exp_parti"));
						tripModel1.setAmount1(rs.getString("exp_amount"));
						tripModel1.setRemark(rs.getString("remark"));
						tripModel1.setGiven_by(rs.getString("given_by"));
						
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		public String insertTripIssueDetails2(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			int c=0;
			String stringValue5 = "";
			
			Connection conn=connection.getConnection();
			
			try {
				
				
				TripModel model = new TripModel();
				PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='101' ");
				ResultSet rs1 = pst1.executeQuery();
				System.out.println("pst1: "+pst1);
				
				if(rs1.next())
				{
					
						model.setDebit_amount(rs1.getString(1));
					
				}
				
				
				
				System.out.println("debit: "+model.getDebit_amount());
				PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='201' ");
				ResultSet rs2 = pst2.executeQuery();
				System.out.println("pst2: "+pst2);
				
				if(rs2.next())
				{
					
						model.setCredit_amount(rs2.getString(1));
					
					
				}
				
				String debit = model.getDebit_amount();
				if(debit==null)
				{
					model.setDebit_amount("0");
				}
				
				String credit = model.getCredit_amount();
				
				if(credit==null)
				{
					model.setCredit_amount("0");
				}
				
				System.out.println("credit001: "+credit);
				
				double remainin_amt = Double.parseDouble(model.getCredit_amount()) - Double.parseDouble(model.getDebit_amount());
				model.setRemaining_amount(String.valueOf(remainin_amt));
				
				
				if(Double.parseDouble(model.getRemaining_amount())<Double.parseDouble(tripModel.getExp_amount()))
				{
					return "insufficient";
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				int len2 = 0;
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from managercreditdebit");
				
				
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
						stringValue5 = "HSL/UPDWISS/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "HSL/UPDWISS/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "HSL/UPDWISS/" + "0" + stringValue5;
					} else {
						stringValue5 = "HSL/UPDWISS/" + stringValue5;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setAmount_issue_code(stringValue5);		
				
			
			PreparedStatement pst = conn.prepareStatement("insert into issue_expenses(trip_id,  vehicle_no, driver_name, date, exp_parti, exp_amount, remark, given_by, updown_id, updown, pump_receipt) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, tripModel.getTrip_id());
			pst.setString(2, tripModel.getVehicle_no());
			pst.setString(3, tripModel.getDriver_name());
			pst.setString(4, tripModel.getDate());
			pst.setString(5, tripModel.getExp_parti());
			pst.setString(6, tripModel.getExp_amount());
			pst.setString(7, tripModel.getRemark());
			pst.setString(8, tripModel.getGiven_by());
			pst.setString(9, tripModel.getUpdown_id());
			pst.setString(10, tripModel.getUpdown());
			
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				pst.setString(11, tripModel.getPump_receipt());
			}
			else
			{
				pst.setString(11, "");
			}
			
			
			c = pst.executeUpdate();
			System.out.println("pst: "+pst);
			
			PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getExp_amount());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();
			System.out.println("pst3: "+pst3);
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				
				String stringValue6 = "";
				int len4 = 0;
				PreparedStatement preparedStatement5 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from vehiclecreditdebit");
				
				
				String mystr4 = "";
				int myval4 = 0;
				ResultSet resultSet4 = preparedStatement5.executeQuery();
				
				if (resultSet4.next()) {
					try {
						mystr4 = resultSet4.getString("myval1");
						myval4 = Integer.parseInt(mystr4);
						myval4 = myval4 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval4 = 1;
						mystr4 = "";
					}
				}
				
				
				
				
				int size4 = len4 + 1;
				stringValue6 = String.valueOf(myval4);
				
					if (stringValue6.length() == 1) {
						stringValue6 = "HSL/BILL/" + "000" + stringValue6;
					} else if (stringValue6.length() == 2) {
						stringValue6 = "HSL/BILL/" + "00" + stringValue6;
					} else if (stringValue6.length() == 3) {
						stringValue6 = "HSL/BILL/" + "0" + stringValue6;
					} else {
						stringValue6 = "HSL/BILL/" + stringValue6;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setBill_no(stringValue6);;	
				
				
				
				
				
				
				
				
				
				PreparedStatement pst4 = conn.prepareStatement("insert into vehiclecreditdebit(Vehicle_no, date, Amount, Name, Documentsno, Typecode, type, billno, remark) values(?,?,?,?,?,?,?,?,?)");
				pst4.setString(1,tripModel.getVehicle_no());
				pst4.setString(2, tripModel.getDate());
				pst4.setString(3, tripModel.getExp_amount());
				pst4.setString(4,tripModel.getGiven_by());
				pst4.setString(5,tripModel.getAmount_issue_code());
				pst4.setString(6, "101");
				pst4.setString(7, "Debit");
				pst4.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst4.setString(9, tripModel.getRemark());
				
				int c2 = pst4.executeUpdate();
			}
			






			
			
				
			
			
			
			
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
				return "success";
			
		}
		
		
		
		
		public TripModel getLRPrintDetails(String lr_number, userinfo bean) {
			// TODO Auto-generated method stub
			
			Connection conn=connection.getConnection();
			
			TripModel tripModel = new TripModel();
			
			try {
				
				PreparedStatement ps = conn.prepareStatement("select * from lr where LR_no = '"+lr_number+"'");
				ResultSet r = ps.executeQuery();
				
				if(r.next())
				{
					tripModel.setCustomer_code(r.getString("customer_no"));
					tripModel.setTransporter_name(r.getString("transporter_name"));
					tripModel.setLr_number(r.getString("LR_no"));
					tripModel.setSource(r.getString("source"));
					tripModel.setDestination(r.getString("destination"));
					tripModel.setCustomer_name(r.getString("customer_name"));
					tripModel.setVehicle_no(r.getString("vehicle_no"));
					tripModel.setDriver_name(r.getString("driver_name"));
					tripModel.setDate(r.getString("date"));
					tripModel.setAdvance(r.getString("advance"));
					tripModel.setTotal_amount(r.getString("total_amount"));
					tripModel.setBalance(r.getString("balance"));
					
					PreparedStatement psc = conn.prepareStatement("select * from customer_master_details where customer_no = '"+tripModel.getCustomer_code()+"'");
					ResultSet rsc = psc.executeQuery();
					
					if(rsc.next())
					{
						tripModel.setCustomer_addr(rsc.getString("customer_address"));
						tripModel.setMobile(rsc.getString("mobile_no"));
					}
					
				}
				
				
				List<String> descrip1 = new ArrayList<>();
				List<String> weight1 = new ArrayList<>();
				List<String> rate1 = new ArrayList<>();
				List<String> amount1 = new ArrayList<>();
				
				PreparedStatement pst = conn.prepareStatement("select * from lr_details where LR_no = '"+lr_number+"'");
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					descrip1.add(rs.getString("description"));
					weight1.add(rs.getString("weight"));
					rate1.add(rs.getString("rate"));
					amount1.add(rs.getString("amount"));
				}
				
				
				tripModel.setDescription(descrip1.toArray(new String[descrip1.size()]));
				tripModel.setWeight(weight1.toArray(new String[weight1.size()]));
				tripModel.setRate(rate1.toArray(new String[rate1.size()]));
				tripModel.setAmount(amount1.toArray(new String[amount1.size()]));
				
				System.out.println("descrip : "+tripModel.getDescription());
				System.out.println("weight : "+tripModel.getWeight());
				System.out.println("rate : "+tripModel.getRate());
				System.out.println("amount : "+tripModel.getAmount());
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return tripModel;
		}
		
		
		
		public List<TripModel> fetchTripIssueDetails(TripModel tripModel, String from_date, String to_date, userinfo bean) {
			// TODO Auto-generated method stub
			int sno = 1;
			String cond="";
			
			Connection conn=connection.getConnection();
			
			
			String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];
			
			
			if(!tripModel.getGiven_by().equals("")){
				cond= "  and given_by like '%"+tripModel.getGiven_by()+"%' ";
				
			}
			
			if(!drv_name.equals("")){
				cond= "  and driver_name like '%"+drv_name+"%' ";
				
			}
			
			if(!tripModel.getExp_parti().equals("")){
				cond= "  and exp_parti like '%"+tripModel.getExp_parti()+"%' ";
				
			}
			
			if(!tripModel.getVehicle_no().equals("")){
				cond= "  and vehicle_no like '%"+tripModel.getVehicle_no()+"%' ";
				
			}
			
			
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT `trip_id`, `date`, `exp_parti`, `exp_amount`, `vehicle_no`, `driver_name`, `given_by` FROM `issue_expenses` where date between '"+from_date+"'"+ "and '"+to_date+"' "+cond);
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					double total_amt = 0;
					
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setDate(rs.getString("date"));
						tripModel1.setExp_parti(rs.getString("exp_parti"));
						tripModel1.setExp_amount(rs.getString("exp_amount"));
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setGiven_by(rs.getString("given_by"));
						
						PreparedStatement pst1 = conn.prepareStatement("select  source, destination from trip where trip_id = '"+tripModel1.getTrip_id()+"'");
						
						ResultSet rs1 = pst1.executeQuery();
						
						String customer = "";
						String source = "";
						String destination = "";
						
						if(rs1.next())
						{
							//customer = rs1.getString(1);
							source = rs1.getString(1);
							destination = rs1.getString(2);
						}
						
						//tripModel1.setCustomer_name(customer);
						tripModel1.setSource(source);
						tripModel1.setDestination(destination);
						
						/*total_amt = total_amt + Double.parseDouble(tripModel1.getExp_amount());
						tripModel1.setTotal_amount(String.valueOf(total_amt));*/
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		public List<TripModel> fetchUpdownIssueDetails(TripModel tripModel, String from_date, String to_date, userinfo bean) {
			// TODO Auto-generated method stub
			
			int sno = 1;
			
			Connection conn=connection.getConnection();
			
			
			String cond="";
			String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];
			
			
			if(!tripModel.getGiven_by().equals("")){
				cond= "  and given_by like '%"+tripModel.getGiven_by()+"%' ";
				
			}
			
			if(!drv_name.equals("")){
				cond= "  and driver_name like '%"+drv_name+"%' ";
				
			}
			
			if(!tripModel.getExp_parti().equals("")){
				cond= "  and exp_parti like '%"+tripModel.getExp_parti()+"%' ";
				
			}
			
			if(!tripModel.getVehicle_no().equals("")){
				cond= "  and vehicle_no like '%"+tripModel.getVehicle_no()+"%' ";
				
			}
			
			
			
			
			
			
			
			List<TripModel> list=new ArrayList<TripModel>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT `updown_id`, `date`, `exp_parti`, `exp_amount`, `vehicle_no`, `driver_name`, `given_by`, `trip_id` FROM `issue_expenses` where updown_id is not null and date between '"+from_date+"'"+ "and '"+to_date+"' "+cond);
					ResultSet rs=pst.executeQuery();
					System.out.println("1...."+pst);
					while(rs.next())
					{
						TripModel tripModel1=new TripModel();
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setDate(rs.getString("date"));
						tripModel1.setExp_parti(rs.getString("exp_parti"));
						tripModel1.setExp_amount(rs.getString("exp_amount"));
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setGiven_by(rs.getString("given_by"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						
						
						PreparedStatement pst1 = conn.prepareStatement("select source, destination from updown where updown_id = '"+tripModel1.getUpdown_id()+"'");
						
						ResultSet rs1 = pst1.executeQuery();
						
						//String customer = "";
						String source = "";
						String destination = "";
						
						if(rs1.next())
						{
							//customer = rs1.getString(1);
							source = rs1.getString(1);
							destination = rs1.getString(2);
						}
						
						//tripModel1.setCustomer_name(customer);
						tripModel1.setSource(source);
						tripModel1.setDestination(destination);
						
						list.add(tripModel1);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		public List<TripModel> fetchManagerLedger(String emp_name, String from_date, String to_date, userinfo bean) {
			// TODO Auto-generated method stub
			List<TripModel> list = new ArrayList<>();
			
			Connection conn=connection.getConnection();
			
			int sno = 1;
			String cond="";
			/*String[] drv = tripModel.getDriver_name().split("-");
			String drv_name = drv[0];*/
			
			
			if(!emp_name.equals("")){
				cond= "  and emp_name like '%"+emp_name+"%' ";
				
			}
			
			
			
			double total_amount = 0;
			
			
			
			
			
			try {
				
				//PreparedStatement pst = conn.prepareStatement("select * from managercreditdebit where date between '"+from_date+"' and '"+to_date+"' "+cond);
				
				
				PreparedStatement pst = conn.prepareStatement("select distinct emp_name from managercreditdebit");
				ResultSet rs = pst.executeQuery();
				
				while(rs.next())
				{
					TripModel model = new TripModel();
					model.setEmp_name(rs.getString(1));
					
					PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+rs.getString(1)+"' and typecode='101' ");
					ResultSet rs1 = pst1.executeQuery();
					System.out.println("pst1: "+pst1);
					
					if(rs1.next())
					{
						
							model.setDebit_amount(rs1.getString(1));
						
					}
					
					
					
					System.out.println("debit: "+model.getDebit_amount());
					PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+rs.getString(1)+"' and typecode='201' ");
					ResultSet rs2 = pst2.executeQuery();
					System.out.println("pst2: "+pst2);
					
					if(rs2.next())
					{
						
							model.setCredit_amount(rs2.getString(1));
						
						
					}
					
					String debit = model.getDebit_amount();
					if(debit==null)
					{
						model.setDebit_amount("0");
					}
					
					String credit = model.getCredit_amount();
					
					if(credit==null)
					{
						model.setCredit_amount("0");
					}
					
					System.out.println("credit001: "+credit);
					
					double remainin_amt = Double.parseDouble(model.getCredit_amount()) - Double.parseDouble(model.getDebit_amount());
					model.setRemaining_amount(String.valueOf(remainin_amt));
					
					list.add(model);
					
				}
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		public List<TripModel> Manager_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			Connection conn=connection.getConnection();
			List<TripModel> list=new ArrayList<TripModel>();
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			
			try{
				 s=tripModel.getDealer_id();
				 
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			
			//System.out.println("<<<>>>>1"+s);


			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and Name='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(managercreditdebit.type='Debit',managercreditdebit.Amount,0.00)) AS Debito, SUM(IF(managercreditdebit.type='Credit',managercreditdebit.Amount,0.00)) AS Credito FROM managercreditdebit WHERE  Date < ?  "+cond+" order by  managercreditdebit.Date ");
			
			/*preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));*/
			preparedStatement2.setString(1, tripModel.getFrom_date()+" 00:00:00");
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			System.out.println(">>>>>::"+saldo);
		
			/*PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );*/
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,managercreditdebit.type,IF(managercreditdebit.type='Debit',managercreditdebit.Amount,0.00) AS Debito,IF(managercreditdebit.type='Credit',managercreditdebit.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM managercreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by managercreditdebit.Date " );
			
			/*preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date1().replace("/", "-")+" 00:00:00"));*/
			preparedStatement3.setString(1, tripModel.getFrom_date());
			preparedStatement3.setString(2, tripModel.getTo_date());
			//System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			while(resultSet3.next()){

				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("Name");
				//tripModel.setDealer_id(dcode1);
				//bean.setDealer_id(resultSet3.getString("Dealercode"));
				/*PreparedStatement pst4x = connection
				.prepareStatement("select cust_id,cust_name from customer_master where cust_id='"+resultSet3.getString("Customercode")+"'   ");
				//System.out.println(">>>>"+pst4x);
				ResultSet rs4x = pst4x.executeQuery();
				if (rs4x.next()) {
					dcode=rs4x.getString("cust_name");
				
					if(!cond.equals("")){
						
					}
					
				}*/
			
			//	bean1.setDelader(resultSet3.getString("Name"));
				bean1.setDc_date(dcode1);
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
								
				/*}*/

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				/*PreparedStatement pst4 = connection
				.prepareStatement(" select * from invoice,invoice_tax_details where invoice_tax_details.invoice_no=invoice.invoice_no and invoice.invoice_no='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst4);
				ResultSet rs4 = pst4.executeQuery();
				int flg=0;
				while (rs4.next()) {
					Product_Sale_Bean bean2=new Product_Sale_Bean();
					//bean2.setGatepassno(rs4.getString("lrnumber"));
					bean2.setDc_date(dcode1);
					try{
					bean2.setSale_date(CoreData.getDateFormatAsUser(rs4.getString("date")));
					}catch (Exception e) {
						// TODO: handle exception
					}
					bean2.setDealer_id(dcode);
					//bean2.setDocumentsno(rs4.getString("lr_no"));
					bean2.setUnitno("");
					bean2.setQty(rs4.getString("qty"));
					bean2.setMsg(rs4.getString("descrip"));
					bean2.setPrice(rs4.getString("rate"));
					//bean2.setTotal_amt(rs4.getString("total"));
					bean2.setRemark("Invoice");
					bean2.setRemark1("");
					
					//list.add(bean2);
					flg=1;
				}*/
				
				//System.out.println("DOC NO:"+resultSet3.getString("Documentsno"));
				
				
			/*	PreparedStatement pst41 = connection.prepareStatement("select * from customerpayment where receiptno='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst41);
				ResultSet rs41 = pst41.executeQuery();
				
				while (rs41.next()) {
					bean1.setResponse(rs41.getString("paidamount"));
					//bean1.setTotal_amt("-"+rs41.getString("paidamount"));
					//list.add(bean1);
					flg=1;
				}*/
				
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
				

			}
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getEmp_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		public List<TripModel> Transporter_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			
			
			Connection conn=connection.getConnection();
			
			List<TripModel> list=new ArrayList<TripModel>();
			
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[0];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
		
			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and Name='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00)) AS Debito, SUM(IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00)) AS Credito FROM transportercreditdebit WHERE  Date < ?  "+cond+" order by  transportercreditdebit.Date ");
			
			//preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement2.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			System.out.println("133333333344444444444444-----------"+preparedStatement2);
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			System.out.println(">>>>>::"+saldo);
		try {
			//PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,transportercreditdebit.type,IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00) AS Debito,IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00) AS Credito,Transporter_code,Name,Amount,billno  FROM transportercreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by transportercreditdebit.Date " );
			
			preparedStatement3.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
			preparedStatement3.setString(2, SysDate.getDateFormatAsDb(tripModel.getTo_date()));
			
			System.out.println(preparedStatement3);
			
			ResultSet resultSet3=preparedStatement3.executeQuery();
			
			System.out.println("afterrrr--------"+preparedStatement3);
		//	BigDecimal finalbalance=BigDecimal.ZERO;
		//	BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			//BigDecimal tempdebit=BigDecimal.ZERO;
			while(resultSet3.next()){
						System.out.println("11111111111111ppppppppp");
				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("Name");
				
			
			//	bean1.setDelader(resultSet3.getString("Name"));
				bean1.setDc_date(resultSet3.getString("Transporter_code"));
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				
				
				System.out.println("111111111111111---------"+tempdebit);
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				System.out.println("11111111111111122222---------"+tempcredit);
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
				//getFinalbalancecredit		
				//}

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
					

			}
			
		
		
			TripModel bean2=new TripModel();
			bean2.setFinalbalancedebit(String.valueOf(tempdebit));
			bean2.setFinalbalancecredit(String.valueOf(tempcredit));
			
			bean2.setInitialbalance(saldo.toString());
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getEmp_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		
		
		
public List<TripModel> supervisor_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			
			
			Connection conn=connection.getConnection();
			
			List<TripModel> list=new ArrayList<TripModel>();
			
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
		
			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and Transporter_code='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(supervisorcreditdebit.type='Debit',supervisorcreditdebit.Amount,0.00)) AS Debito, SUM(IF(supervisorcreditdebit.type='Credit',supervisorcreditdebit.Amount,0.00)) AS Credito FROM supervisorcreditdebit WHERE  Date < ?  "+cond+" order by  supervisorcreditdebit.Date ");
			
			//preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement2.setString(1, tripModel.getFrom_date()+" 00:00:00");
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			System.out.println("133333333344444444444444-----------"+preparedStatement2);
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			System.out.println(">>>>>::"+saldo);
		
			//PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,emp_id,supervisorcreditdebit.type,IF(supervisorcreditdebit.type='Debit',supervisorcreditdebit.Amount,0.00) AS Debito,IF(supervisorcreditdebit.type='Credit',supervisorcreditdebit.Amount,0.00) AS Credito,emp_Name,Amount,billno  FROM supervisorcreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by supervisorcreditdebit.Date " );
			
			preparedStatement3.setString(1, tripModel.getFrom_date());
			preparedStatement3.setString(2, tripModel.getTo_date());
			
			System.out.println(preparedStatement3);
			
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			while(resultSet3.next()){

				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("emp_Name");
				
			
			//	bean1.setDelader(resultSet3.getString("Name"));
				//bean1.setDc_date(resultSet3.getString("Transporter_code"));
				bean1.setDealer_id(resultSet3.getString("emp_Name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setEmp_id(resultSet3.getString("emp_id"));
				
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
								
				//}

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("emp_Name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				
				
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
				

			}
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getEmp_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return list;
		}
		
		
		
		



public List<TripModel> daily_Cash_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
	
	
	Connection conn=connection.getConnection();
	
	List<TripModel> list=new ArrayList<TripModel>();
	
	
	
	try {
	PreparedStatement preparedStatement3=conn.prepareStatement("SELECT * FROM diley_cashreport WHERE  Date between ? and ? order by  diley_cashreport.Date ");
	
	//preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
	
	preparedStatement3.setString(1, tripModel.getFrom_date());
	preparedStatement3.setString(2, tripModel.getTo_date());
	
	System.out.println(preparedStatement3);
	
	ResultSet resultSet3=preparedStatement3.executeQuery();
	
	while(resultSet3.next()){

		TripModel bean1=new TripModel();

		
		bean1.setDc_date(resultSet3.getString("Date"));
		bean1.setEmp_name(resultSet3.getString("Name"));
		bean1.setEmp_id(resultSet3.getString("emp_id"));
		
		bean1.setDocumentsno(resultSet3.getString("Documentsno"));
		
		bean1.setType(resultSet3.getString("type"));
		bean1.setRemark(resultSet3.getString("Remark"));
		bean1.setCash_source(resultSet3.getString("cash_source"));
		
		bean1.setForm_source(resultSet3.getString("form_source"));
		
		bean1.setAmount1(resultSet3.getString("Amount"));
	
		list.add(bean1);
	}
	DBConnection.closeConnection();
	
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}

	return list;
}
		
		








public List<TripModel> escalation_Report_Submitv(TripModel tripModel, userinfo bean) {
	
	
	Connection conn=connection.getConnection();
	
	List<TripModel> list=new ArrayList<TripModel>();
	
	
	
	try {
	PreparedStatement preparedStatement3=conn.prepareStatement("SELECT * FROM escalation_table WHERE  enq_Date between ? and ? order by  escalation_table.enq_Date ");
	
	//preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
	
	preparedStatement3.setString(1, tripModel.getFrom_date());
	preparedStatement3.setString(2, tripModel.getTo_date());
	
	System.out.println(preparedStatement3);
	
	ResultSet resultSet3=preparedStatement3.executeQuery();
	
	while(resultSet3.next()){

		TripModel bean1=new TripModel();

		bean1.setEmp_id(resultSet3.getString("enq_id"));
		
		
		
		
		bean1.setDc_date(resultSet3.getString("enq_Date"));
	//	bean1.setEmp_name(resultSet3.getString("pricind_date"));
		
		
		
		
		String place_time=resultSet3.getString("enq_Date");
		
		String approve_time=resultSet3.getString("pricind_date");
		
		
		DateTimeFormatter formatter = null;
		LocalDateTime approve_time1 = null;
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(place_time, formatter);
			approve_time1 = LocalDateTime.parse(approve_time, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setEmp_name(approve_time+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT1(approve_time_diff);
			
			
			System.out.println("ssssssssssss--------------"+approve_time_diff);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	
		
		
		
		
		
		//bean1.setDocumentsno(resultSet3.getString("quotation_date"));
		
		
		
		

		
		String time1=resultSet3.getString("quotation_date");
		
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(approve_time, formatter);
			approve_time1 = LocalDateTime.parse(time1, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setDocumentsno(time1+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT2(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String time2=resultSet3.getString("finalize_date");
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(time1, formatter);
			approve_time1 = LocalDateTime.parse(time2, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setAa1(time2+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT3(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//bean1.setType(resultSet3.getString("vehical_date"));
		
		
		
		
		
		
				String time3=resultSet3.getString("vehical_date");
		
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(time2, formatter);
			approve_time1 = LocalDateTime.parse(time3, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setType(time3+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT4(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}
	//bean1.setRemark(resultSet3.getString("creatlr_date"));
		
	String time4=resultSet3.getString("creatlr_date");
		
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(time3, formatter);
			approve_time1 = LocalDateTime.parse(time4, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setRemark(time4+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT5(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//bean1.setCash_source(resultSet3.getString("invoice_date"));
		
				String time5=resultSet3.getString("Delivery_done");
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(time4, formatter);
			approve_time1 = LocalDateTime.parse(time5, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setAdd2(time5+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT6(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String time6=resultSet3.getString("invoice_date");
		
		
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			LocalDateTime place_time1= LocalDateTime.parse(time5, formatter);
			approve_time1 = LocalDateTime.parse(time6, formatter);
			
			long approve_time_diff = java.time.Duration.between(place_time1, approve_time1).toMinutes();
			
			bean1.setCash_source(time6+"    (" +(String.valueOf(approve_time_diff))+"  mins )");
			bean1.setT7(approve_time_diff);
			
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//bean1.setAa1(resultSet3.getString("finalize_date"));
		

		
		
		
		
		//bean1.setAdd2(resultSet3.getString("Delivery_done"));
		
		

		
		
		list.add(bean1);
	}
	DBConnection.closeConnection();
	
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
	}

	return list;
}
		

		
		
		/*public List<TripModel> Transporter_Credit_Advance_Report_submitv(TripModel tripModel) throws Exception {
			// TODO Auto-generated method stub
			//Connection conn=connection.getConnection();
		
			
			List<TripModel> list=new ArrayList<TripModel>();
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			//System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
		
			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and Transporter_code='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00)) AS Debito, SUM(IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00)) AS Credito FROM transportercreditdebit WHERE  Date < ?  "+cond+" order by  transportercreditdebit.Date ");
			

			preparedStatement2.setString(1, tripModel.getFrom_date()+" 00:00:00");
			
			//System.out.println("1");
			
			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			//System.out.println(">>>>>::"+saldo);
		
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(transportercreditdebit.Date, '%d/%m/%Y') as Date,Remark,Documentsno,transportercreditdebit.type,IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00) AS Debito,IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00) AS Credito,Transporter_code,Name,Amount,billno  FROM transportercreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by transportercreditdebit.Date " );
			
			preparedStatement3.setString(1, tripModel.getFrom_date());
			preparedStatement3.setString(2, tripModel.getTo_date());																		
			//System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			
			while(resultSet3.next()){
				
				
				
			TripModel bean1=new TripModel();

			BigDecimal debit=resultSet3.getBigDecimal("Debito");
			BigDecimal credit=resultSet3.getBigDecimal("Credito");
			BigDecimal temp = debit.subtract(credit);
			tempSaldo = tempSaldo.add(temp);
			System.out.println("<<<<<"+tempSaldo);
			bean1.setTotal_amount(""+tempSaldo);
			//BigDecimal temp=debit.subtract(credit);
			if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
				tempdebit=tempdebit.add(debit);
			}
			if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
				tempcredit=tempcredit.add(credit);

			}
			dcode1=resultSet3.getString("Name");
			
		
		//	bean1.setDelader(resultSet3.getString("Name"));
			bean1.setDc_date(resultSet3.getString("Transporter_code"));
			bean1.setDealer_id(resultSet3.getString("Name"));
			bean1.setFrom_date(tripModel.getFrom_date());
			bean1.setTo_date(tripModel.getTo_date());
			bean1.setType(resultSet3.getString("type").trim());
			bean1.setInitialbalance(saldo.toString());
			
			bean1.setSale_date(resultSet3.getString("Date"));
			bean1.setRemark(resultSet3.getString("Remark"));
			bean1.setDocumentsno(resultSet3.getString("Documentsno"));
			bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setFinalbalancedebit(String.valueOf(tempdebit));
			bean1.setFinalbalancecredit(String.valueOf(tempcredit));
			
			bean1.setRemark1(resultSet3.getString("Remark"));
				
				
				
				list.add(bean1);
				

			}
			
			
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			//bean2.setDelader(bean.getDelader());
			}
			//bean2.setDelader(dcode);
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			
			list.add(bean2);
			
			
			DBConnection.closeConnection();
			
			return list;
		}*/
		
		
		
		
		
		
		
		
		
		public List<TripModel> Driver_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			Connection conn=connection.getConnection();
			List<TripModel> list=new ArrayList<TripModel>();
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			
			//System.out.println("<<<>>>>1"+s);


			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and driver_id='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(drivercreditdebit.type='Debit',drivercreditdebit.Amount,0.00)) AS Debito, SUM(IF(drivercreditdebit.type='Credit',drivercreditdebit.Amount,0.00)) AS Credito FROM drivercreditdebit WHERE  Date < ?  "+cond+" order by  drivercreditdebit.Date ");
			
			/*preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));*/
			preparedStatement2.setString(1, tripModel.getFrom_date()+" 00:00:00");
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			System.out.println(">>>>>::"+saldo);
		
			/*PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );*/
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,drivercreditdebit.type,IF(drivercreditdebit.type='Debit',drivercreditdebit.Amount,0.00) AS Debito,IF(drivercreditdebit.type='Credit',drivercreditdebit.Amount,0.00) AS Credito,driver_id,Name,Amount,billno  FROM drivercreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by drivercreditdebit.Date " );
			
			/*preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date1().replace("/", "-")+" 00:00:00"));*/
			preparedStatement3.setString(1, tripModel.getFrom_date());
			preparedStatement3.setString(2, tripModel.getTo_date());
			//System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			while(resultSet3.next()){

				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("Name");
				//tripModel.setDealer_id(dcode1);
				//bean.setDealer_id(resultSet3.getString("Dealercode"));
				/*PreparedStatement pst4x = connection
				.prepareStatement("select cust_id,cust_name from customer_master where cust_id='"+resultSet3.getString("Customercode")+"'   ");
				//System.out.println(">>>>"+pst4x);
				ResultSet rs4x = pst4x.executeQuery();
				if (rs4x.next()) {
					dcode=rs4x.getString("cust_name");
				
					if(!cond.equals("")){
						
					}
					
				}*/
			
			//	bean1.setDelader(resultSet3.getString("Name"));
				bean1.setDc_date(resultSet3.getString("driver_id"));
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
								
				/*}*/

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				/*PreparedStatement pst4 = connection
				.prepareStatement(" select * from invoice,invoice_tax_details where invoice_tax_details.invoice_no=invoice.invoice_no and invoice.invoice_no='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst4);
				ResultSet rs4 = pst4.executeQuery();
				int flg=0;
				while (rs4.next()) {
					Product_Sale_Bean bean2=new Product_Sale_Bean();
					//bean2.setGatepassno(rs4.getString("lrnumber"));
					bean2.setDc_date(dcode1);
					try{
					bean2.setSale_date(CoreData.getDateFormatAsUser(rs4.getString("date")));
					}catch (Exception e) {
						// TODO: handle exception
					}
					bean2.setDealer_id(dcode);
					//bean2.setDocumentsno(rs4.getString("lr_no"));
					bean2.setUnitno("");
					bean2.setQty(rs4.getString("qty"));
					bean2.setMsg(rs4.getString("descrip"));
					bean2.setPrice(rs4.getString("rate"));
					//bean2.setTotal_amt(rs4.getString("total"));
					bean2.setRemark("Invoice");
					bean2.setRemark1("");
					
					//list.add(bean2);
					flg=1;
				}*/
				
				//System.out.println("DOC NO:"+resultSet3.getString("Documentsno"));
				
				
			/*	PreparedStatement pst41 = connection.prepareStatement("select * from customerpayment where receiptno='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst41);
				ResultSet rs41 = pst41.executeQuery();
				
				while (rs41.next()) {
					bean1.setResponse(rs41.getString("paidamount"));
					//bean1.setTotal_amt("-"+rs41.getString("paidamount"));
					//list.add(bean1);
					flg=1;
				}*/
				
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
				

			}
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getDriver_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			
			return list;
		}
		
		
		
		public List<TripModel> Customer_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			Connection conn=connection.getConnection();
			List<TripModel> list=new ArrayList<TripModel>();
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			
			//System.out.println("<<<>>>>1"+s);


			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and Customercode='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00)) AS Debito, SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00)) AS Credito FROM customercreditdebit WHERE  Date < ?  "+cond+" order by  customercreditdebit.Date ");
			
			/*preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));*/
			preparedStatement2.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			System.out.println("14444444444444444444---------------"+preparedStatement2);
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				saldo=saldo.add(temp3);
			}
			System.out.println(">>>>>::"+saldo);
			
			/*PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );*/
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,customercreditdebit.type,IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00) AS Debito,IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM customercreditdebit WHERE    Date BETWEEN ? AND ?    "+cond+"  order by customercreditdebit.Date " );
			
			/*preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date1().replace("/", "-")+" 00:00:00"));*/
			preparedStatement3.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
			preparedStatement3.setString(2, SysDate.getDateFormatAsDb(tripModel.getTo_date())) ;
			//System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			while(resultSet3.next()){

				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("Name");
				//tripModel.setDealer_id(dcode1);
				//bean.setDealer_id(resultSet3.getString("Dealercode"));
				/*PreparedStatement pst4x = connection
				.prepareStatement("select cust_id,cust_name from customer_master where cust_id='"+resultSet3.getString("Customercode")+"'   ");
				//System.out.println(">>>>"+pst4x);
				ResultSet rs4x = pst4x.executeQuery();
				if (rs4x.next()) {
					dcode=rs4x.getString("cust_name");
				
					if(!cond.equals("")){
						
					}
					
				}*/
			
			//	bean1.setDelader(resultSet3.getString("Name"));
				bean1.setDc_date(resultSet3.getString("Customercode"));
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
								
				/*}*/

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("Name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				/*PreparedStatement pst4 = connection
				.prepareStatement(" select * from invoice,invoice_tax_details where invoice_tax_details.invoice_no=invoice.invoice_no and invoice.invoice_no='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst4);
				ResultSet rs4 = pst4.executeQuery();
				int flg=0;
				while (rs4.next()) {
					Product_Sale_Bean bean2=new Product_Sale_Bean();
					//bean2.setGatepassno(rs4.getString("lrnumber"));
					bean2.setDc_date(dcode1);
					try{
					bean2.setSale_date(CoreData.getDateFormatAsUser(rs4.getString("date")));
					}catch (Exception e) {
						// TODO: handle exception
					}
					bean2.setDealer_id(dcode);
					//bean2.setDocumentsno(rs4.getString("lr_no"));
					bean2.setUnitno("");
					bean2.setQty(rs4.getString("qty"));
					bean2.setMsg(rs4.getString("descrip"));
					bean2.setPrice(rs4.getString("rate"));
					//bean2.setTotal_amt(rs4.getString("total"));
					bean2.setRemark("Invoice");
					bean2.setRemark1("");
					
					//list.add(bean2);
					flg=1;
				}*/
				
				//System.out.println("DOC NO:"+resultSet3.getString("Documentsno"));
				
				
			/*	PreparedStatement pst41 = connection.prepareStatement("select * from customerpayment where receiptno='"+resultSet3.getString("Documentsno")+"'");
				//System.out.println(">>>>"+pst41);
				ResultSet rs41 = pst41.executeQuery();
				
				while (rs41.next()) {
					bean1.setResponse(rs41.getString("paidamount"));
					//bean1.setTotal_amt("-"+rs41.getString("paidamount"));
					//list.add(bean1);
					flg=1;
				}*/
				
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
				

			}
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			
			
			bean2.setFinalbalancedebit(String.valueOf(tempdebit));
			bean2.setFinalbalancecredit(String.valueOf(tempcredit));
			
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getDriver_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			
			return list;
		}
		
		public List<TripModel> Customer_Credit_Advance_Report_submitv123(TripModel tripModel, userinfo bean) throws SQLException {
			// TODO Auto-generated method stub
			Connection conn=connection.getConnection();
			List<TripModel> list=new ArrayList<TripModel>();
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			String kkk=tripModel.getVehicle_Type();
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			
			//System.out.println("<<<>>>>1"+s);
			
				SimpleDateFormat inSDF = new SimpleDateFormat("mm/dd/yyyy");
			  SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");
			  
			  String fromoutDate ="";
			  String frominDate=tripModel.getFrom_date();
			  try {
		            Date date = inSDF.parse(frominDate);
		            fromoutDate = outSDF.format(date);
		        } catch (ParseException ex){ 
		        }
			  
			  String tooutDate ="";
			  String toinDate=tripModel.getTo_date();
			  try {
		            Date date = inSDF.parse(toinDate);
		            tooutDate = outSDF.format(date);
		        } catch (ParseException ex){ 
		        }
			  
			  
			  PreparedStatement  preparedStatement3 = null;
			try{
			if(!s.equals(" ") && !s.equals(null) && kkk.equals(null) && kkk.equals(" ")){
				cond=" and customer_no='"+s+"' ";
				  preparedStatement3=conn.prepareStatement("SELECT *  FROM lr WHERE date BETWEEN '"+fromoutDate+"' AND '"+tooutDate+"' "+cond+"  order by lr.date");
			}
			else if(s.equals(" ") && s.equals(null) &&!kkk.equals(null) &&!kkk.equals(" ")){
				cond=" and vehicle_Type='"+s+"' ";
				  preparedStatement3=conn.prepareStatement("SELECT *  FROM lr WHERE date BETWEEN '"+fromoutDate+"' AND '"+tooutDate+"' "+cond+"  order by lr.date");
			}
			else
			{
				 preparedStatement3=conn.prepareStatement("SELECT *  FROM lr WHERE date BETWEEN '"+fromoutDate+"' AND '"+tooutDate+"' order by lr.date");			
			}
			System.out.println("------------------------"+preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			
			System.out.println("------------------------"+preparedStatement3);
			while(resultSet3.next()){

				TripModel bean1=new TripModel();
				bean1.setSale_date(resultSet3.getString("date"));
				bean1.setLr_number(resultSet3.getString("LR_no"));
				
				bean1.setDealer_id(resultSet3.getString("Customer_name"));
				bean1.setVehicle_Type(resultSet3.getString("Vehicle_Type"));
					
				PreparedStatement  preparedStatement33=conn.prepareStatement("SELECT *  FROM pricing  WHERE inquiry_id='"+resultSet3.getString("inquiry_id")+"' " );
				 ResultSet resultSet33=preparedStatement33.executeQuery();
				 if(resultSet33.next()){
					 bean1.setTotal_amt(resultSet33.getString("total"));
				 }
				 
				 
				 PreparedStatement  preparedStatement333=conn.prepareStatement("SELECT *  FROM order_table  WHERE lr_no='"+resultSet3.getString("LR_no")+"' " );
				 ResultSet resultSet333=preparedStatement333.executeQuery();
				 if(resultSet333.next()){
					 bean1.setPump_receipt(resultSet333.getString("route"));
				 }
				 

				bean1.setTotal_amount(resultSet3.getString("total_amount"));
				
				int aa=Integer.parseInt(resultSet33.getString("total"));
				int bb=Integer.parseInt(resultSet3.getString("total_amount"));
				
				int profit=bb-aa;
				bean1.setProfit(profit);
				list.add(bean1);
			}	
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			
			return list;
		}
		
		
		
		
		
		
		
		
		public TripModel fetchorderLrView(TripModel tripModel, userinfo bean, String lr) {
			
			
			Connection conn=connection.getConnection();
			
			
			TripModel tripModel1=new TripModel();
			
			int count=0;
			
			try {
					
				PreparedStatement pst=conn.prepareStatement("SELECT * FROM lr where LR_no='"+lr+"'");
					
					ResultSet rs=pst.executeQuery();
					
					
					System.out.println("1...."+pst);
					
					
					
					while(rs.next())
					{
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setLr_number(rs.getString("LR_no"));
						tripModel1.setSource(rs.getString("source"));
						tripModel1.setDestination(rs.getString("destination"));
						tripModel1.setCustomer_name(rs.getString("Customer_name")+"-"+rs.getString("customer_no"));
						tripModel1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
						tripModel1.setMobile(rs.getString("mobile"));
						tripModel1.setTotal_amount(rs.getString("total_amount"));
						
						tripModel1.setTransporter_name(rs.getString("transporter_name"));
						
						tripModel1.setTransporter_code(rs.getString("transporter_code"));
						
						tripModel1.setAdvance(rs.getString("advance"));
						
						tripModel1.setBalance(rs.getString("balance"));
						
						tripModel1.setOrder_id(rs.getString("order_id"));
						
						tripModel1.setCustomer_code(rs.getString("customer_no"));
						
						tripModel1.setCommission(rs.getString("transport_amount"));
						
						tripModel1.setVolume(rs.getString("volume"));
						
						tripModel1.setInsurance(rs.getString("insurance"));
						
						tripModel1.setBooking(rs.getString("booking"));
						
						tripModel1.setVal_rupees(rs.getString("val_rupees"));
						
						tripModel1.setFreight(rs.getString("freight"));
						
						tripModel1.setInquiry_id(rs.getString("inquiry_id"));
						
						
						
						tripModel1.setLoadname(rs.getString("loadname"));
						
						tripModel1.setLoadadd(rs.getString("loadadd"));
						
						tripModel1.setLoadstate(rs.getString("loadstate"));
						
						tripModel1.setLoadgstn(rs.getString("loadgstn"));
						
						tripModel1.setLoad_contact_person(rs.getString("load_contact_person"));
						
						tripModel1.setLoad_contact_no(rs.getString("load_contact_no"));
						
						tripModel1.setDest_contact_person(rs.getString("dest_contact_person"));
						
						tripModel1.setDest_contact_no(rs.getString("dest_contact_no"));
						
						tripModel1.setShipstate(rs.getString("shipstate"));
						
						tripModel1.setShipgstn(rs.getString("shipgstn"));
						
						tripModel1.setShipadd(rs.getString("shipadd"));
						
						tripModel1.setShipname(rs.getString("shipname"));
						
						tripModel1.setInvoice_value(rs.getString("invoice_value"));
						

						tripModel1.setBuyername(rs.getString("buyername"));
						
						tripModel1.setBuyeradd(rs.getString("buyeradd"));
						
						tripModel1.setBuyerstatus(rs.getString("buyerstatus"));
						
						tripModel1.setBuyergstn(rs.getString("buyergstn"));
						
						tripModel1.setBuyer_contact_person(rs.getString("buyer_contact_person"));
						
						tripModel1.setBuyer_contact_no(rs.getString("buyer_contact_no"));
						
						
						
						tripModel1.setInvoice_No(rs.getString("invoice_No"));
						
						tripModel1.setVehicle_Type(rs.getString("vehicle_Type"));
						
						
						
						
						tripModel1.setDriver_mobile(rs.getString("driver_mobile"));
						
						tripModel1.setDriver_code(rs.getString("driver_code"));
						
						/*tripModel1.setAdd1(rs.getString("add1"));
						tripModel1.setMobile1(rs.getString("mobile1"));
						tripModel1.setGstin1(rs.getString("gstin1"));
						tripModel1.setCustname1(rs.getString("custname1"));
						tripModel1.setState1(rs.getString("state1"));
						
						tripModel1.setAdd2(rs.getString("add2"));
						tripModel1.setMobile2(rs.getString("mobile2"));
						tripModel1.setGstin2(rs.getString("gstin2"));
						tripModel1.setCustname2(rs.getString("custname2"));
						tripModel1.setState2(rs.getString("state2"));
						
						tripModel1.setAdd3(rs.getString("add3"));
						tripModel1.setMobile3(rs.getString("mobile3"));
						tripModel1.setGstin3(rs.getString("gstin3"));
						tripModel1.setCustname3(rs.getString("custname3"));
						tripModel1.setState3(rs.getString("state3"));
						*/
						
						tripModel1.setOwner_risk(rs.getString("owner_risk"));
						
						tripModel1.setBill_to(rs.getString("bill_to_custname")+"-"+rs.getString("bill_to_custid"));
						
						System.out.println("11111--"+rs.getString("bill_to_custname")+"-"+rs.getString("bill_to_custid"));	
						
					}
					
					
					tripModel1.setSn(count);
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println(e.getMessage());
				
			}
			
			
			DBConnection.closeConnection();
			
			return tripModel1;
		
		
		}
		
		
		
		public List<TripModel> fetchorderLrView1(TripModel tripModel, String lr, userinfo bean) {
			
			
			List<TripModel> list = new ArrayList<>();
			
			Connection conn=connection.getConnection();
					
					
					try {
							
						PreparedStatement pst=conn.prepareStatement("SELECT * FROM lr_details where LR_no='"+lr+"'");
							
							ResultSet rs=pst.executeQuery();
							
							
							System.out.println("1...."+pst);
							
							
							
							while(rs.next())
							{
								
								TripModel tripModel1=new TripModel();
								
								tripModel1.setAa1(rs.getString("no_of_package"));
								
								tripModel1.setBb1(rs.getString("type_of_packing"));
								
								tripModel1.setCc1(rs.getString("description"));
								
								tripModel1.setDd1(rs.getString("vehicle_type"));
								
										
								tripModel1.setEe1(rs.getString("source"));
								
								tripModel1.setFf1(rs.getString("destination"));
								
								tripModel1.setGg1(rs.getString("weight"));
								
								tripModel1.setHh1(rs.getString("rate"));
								
								tripModel1.setIi1(rs.getString("amount"));
								
								list.add(tripModel1);
									
								
							}
							
							
							
							
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						System.out.println(e.getMessage());
						
					}
					
					
					DBConnection.closeConnection();
					
					return list;
				
				
				}
		
		
		
		
		
public List<TripModel> fetchorderLrView1ccdd(TripModel tripModel, String lr, userinfo bean) {
			
			
			List<TripModel> list = new ArrayList<>();
			
			Connection conn=connection.getConnection();
					
					
					try {
							
						PreparedStatement pst=conn.prepareStatement("SELECT * FROM lr_status where lr_no='"+lr+"'");
							
							ResultSet rs=pst.executeQuery();
							
							
							System.out.println("1.2222222..."+pst);
							
							
							
							while(rs.next())
							{
								
								TripModel tripModel1=new TripModel();
								
								tripModel1.setAa1(rs.getString("date"));
								
								tripModel1.setBb1(rs.getString("status"));
								
									
								list.add(tripModel1);
									
								
							}
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						System.out.println(e.getMessage());
						
					}
					
					
					DBConnection.closeConnection();
					
					return list;
				
				
				}
				
		
		
		
		public TripModel delivery_done(TripModel tripModel, userinfo bean, String lr) {
			
			
			Connection conn=connection.getConnection();
			
			
			TripModel tripModel1=new TripModel();
			
			int count=0;
			
			try {
					
				PreparedStatement pst=conn.prepareStatement("SELECT * FROM lr where LR_no='"+lr+"'");
					
					ResultSet rs=pst.executeQuery();
					
					
					System.out.println("1...."+pst);
					
					
					
					while(rs.next())
					{
						tripModel1.setVehicle_no(rs.getString("vehicle_no"));
						tripModel1.setDriver_name(rs.getString("driver_name"));
						tripModel1.setTrip_id(rs.getString("trip_id"));
						tripModel1.setUpdown_id(rs.getString("updown_id"));
						tripModel1.setLr_number(rs.getString("LR_no"));
						tripModel1.setSource(rs.getString("source"));
						tripModel1.setDestination(rs.getString("destination"));
						tripModel1.setCustomer_name(rs.getString("Customer_name"));
						//tripModel1.setCustomer_code(rs.getString("customer_no"));
						
						tripModel1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
						tripModel1.setMobile(rs.getString("mobile"));
						
						tripModel1.setBill_to(rs.getString("bill_to_custname"));
						
						tripModel1.setBill_no(rs.getString("bill_to_custid"));
						
						
						
						
						tripModel1.setTotal_amount(rs.getString("total_amount"));
						
						tripModel1.setTransporter_name(rs.getString("transporter_name"));
						
						tripModel1.setTransporter_code(rs.getString("transporter_code"));
						
						tripModel1.setAdvance(rs.getString("advance"));
						
						tripModel1.setBalance(rs.getString("balance"));
						
						tripModel1.setOrder_id(rs.getString("order_id"));
						
						tripModel1.setCustomer_code(rs.getString("customer_no"));
						
						tripModel1.setCommission(rs.getString("transport_amount"));
						
						tripModel1.setVolume(rs.getString("volume"));
						
						tripModel1.setInsurance(rs.getString("insurance"));
						
						tripModel1.setBooking(rs.getString("booking"));
						
						tripModel1.setVal_rupees(rs.getString("val_rupees"));
						
						tripModel1.setFreight(rs.getString("freight"));
						
						tripModel1.setInquiry_id(rs.getString("inquiry_id"));
						
						
						tripModel1.setLoadname(rs.getString("loadname"));
						
						tripModel1.setLoadadd(rs.getString("loadadd"));
						
						tripModel1.setLoadstate(rs.getString("loadstate"));
						
						tripModel1.setLoadgstn(rs.getString("loadgstn"));
						
						tripModel1.setLoad_contact_person(rs.getString("load_contact_person"));
						
						tripModel1.setLoad_contact_no(rs.getString("load_contact_no"));
						
						tripModel1.setDest_contact_person(rs.getString("dest_contact_person"));
						
						tripModel1.setDest_contact_no(rs.getString("dest_contact_no"));
						
						
						tripModel1.setBuyername(rs.getString("buyername"));
						
						tripModel1.setBuyeradd(rs.getString("buyeradd"));
						
						tripModel1.setBuyerstatus(rs.getString("buyerstatus"));
						
						tripModel1.setBuyergstn(rs.getString("buyergstn"));
						
						tripModel1.setBuyer_contact_person(rs.getString("buyer_contact_person"));
						
						tripModel1.setBuyer_contact_no(rs.getString("buyer_contact_no"));
						
						
						tripModel1.setShipstate(rs.getString("shipstate"));
						
						tripModel1.setShipgstn(rs.getString("shipgstn"));
						
						tripModel1.setShipadd(rs.getString("shipadd"));
						
						tripModel1.setShipname(rs.getString("shipname"));
						
						tripModel1.setDriver_mobile(rs.getString("driver_mobile"));
						
						tripModel1.setDriver_code(rs.getString("driver_code"));
							
						
					}
					
					
					tripModel1.setSn(count);
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				System.out.println(e.getMessage());
				
			}
			
			
			DBConnection.closeConnection();
			
			return tripModel1;
		
		
		}
		
		
		
		
		public List<TripModel> delivery_done1(TripModel tripModel, String lr, userinfo bean) {
			
			
			List<TripModel> list = new ArrayList<>();
			
			Connection conn=connection.getConnection();
					
					
					try {
							
						PreparedStatement pst=conn.prepareStatement("SELECT * FROM lr_details where LR_no='"+lr+"'");
							
							ResultSet rs=pst.executeQuery();
							
							
							System.out.println("1...."+pst);
							
							
							
							while(rs.next())
							{
								
								TripModel tripModel1=new TripModel();
								
								tripModel1.setAa1(rs.getString("no_of_package"));
								
								tripModel1.setBb1(rs.getString("type_of_packing"));
								
								tripModel1.setCc1(rs.getString("description"));
								
								tripModel1.setDd1(rs.getString("vehicle_type"));
								
										
								tripModel1.setEe1(rs.getString("source"));
								
								tripModel1.setFf1(rs.getString("destination"));
								
								tripModel1.setGg1(rs.getString("weight"));
								
								tripModel1.setHh1(rs.getString("rate"));
								
								tripModel1.setIi1(rs.getString("amount"));
								
								list.add(tripModel1);
									
								
							}
							
							
							
							
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						
						System.out.println(e.getMessage());
						
					}
					
					
					DBConnection.closeConnection();
					
					return list;
				
				
				}
		
		
		
		

		
		
		
		public String updateLRDetails(TripModel tripModel, userinfo bean) {
			
			Connection conn=connection.getConnection();
			
			String response = "";
			// TODO Auto-generated method stub
			String stringValue2 = "";
			String stringValue3 = "";
			
			int len1 = 0;
			
			
			String customer = tripModel.getCustomer_name();
			String transporter = tripModel.getTransporter_name();
			
			String[] cust = customer.split("-");
			String[] trans = transporter.split("-");
			
			try {
				
			//PreparedStatement pst2 = conn.prepareStatement("insert into LR(trip_id, updown_id, LR_no, Customer_name, date, mobile, source, destination, transporter_name, vehicle_no, driver_name, total_amount, advance, balance, customer_no, driver_code, transporter_code,order_id,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			PreparedStatement pst2 = conn.prepareStatement("update LR set trip_id=?, updown_id=?,Customer_name=?, date=?, mobile=?, source=?, destination=?, transporter_name=?, vehicle_no=?, driver_name=?, total_amount=?, advance=?, balance=?, customer_no=?, driver_code=?, transporter_code=?,transport_amount=?,volume=?,insurance=?,booking=?,val_rupees=?,freight=?,shipname=?,shipadd=?,shipstate=?,shipgstn=?,dest_contact_person=?,dest_contact_no=?,loadname=?,loadadd=?,loadstate=?,loadgstn=?,load_contact_person=?,load_contact_no=?,driver_mobile=?,bill_to_custname=?"
					+ ",bill_to_custid=?,buyername=?,buyeradd=?,buyerstatus=?,buyergstn=?,buyer_contact_person=?,buyer_contact_no=?,invoice_No=?,vehicle_Type=?,invoice_value=? where LR_no='"+tripModel.getLr_number()+"'");
			
				
			System.out.println("pst2----------------"+pst2);
			
			pst2.setString(1, tripModel.getTrip_id());
			pst2.setString(2, tripModel.getUpdown_id());
			System.out.println("11111111111");
			//pst2.setString(3, tripModel.getLr_number());
			
			
			/*pst2.setString(4, tripModel.getCustomer_name());*/
			pst2.setString(3, cust[0]);
			pst2.setString(4, CoreData.getDateFormatAsDb(tripModel.getDate()));
			System.out.println("222");
			
			
			
			PreparedStatement pstmb = conn.prepareStatement("select mobile_no from customer_master_details where customer_name='"+cust[0]+"'");
			
			ResultSet rs = pstmb.executeQuery();
			
			String mobile ="";
			
			if(rs.next())
			{
				mobile = rs.getString(1);
			}
			System.out.println("333");
			
			
			System.out.println("3331");
			
			pst2.setString(5, mobile);
			pst2.setString(6, tripModel.getSource());
			pst2.setString(7, tripModel.getDestination());
			System.out.println("3332");
			
			pst2.setString(8, trans[0]);
			pst2.setString(9, tripModel.getVehicle_no());
			pst2.setString(10, tripModel.getDriver_name());
			System.out.println("33313");
			
			pst2.setString(11, tripModel.getTotal_amount());
			pst2.setString(12, tripModel.getAdvance());
			System.out.println("3334");
			
			//pst2.setString(13, tripModel.getBalance());
			pst2.setString(13, "aa");
			System.out.println("3335");
			
			pst2.setString(14, cust[1]);
			System.out.println("444");
			
			pst2.setString(15, "");
			pst2.setString(16, trans[1]);
			
			pst2.setString(17, tripModel.getTotal_amount());
			
			pst2.setString(18, tripModel.getVolume());
			
			pst2.setString(19, tripModel.getInsurance());
			pst2.setString(20, tripModel.getBooking());
			pst2.setString(21, tripModel.getVal_rupees());
			pst2.setString(22, tripModel.getFreight());
			
			
			pst2.setString(23, tripModel.getShipname());
			
			pst2.setString(24, tripModel.getShipadd());
			System.out.println("555");
			
			pst2.setString(25, tripModel.getShipstate());
			
			pst2.setString(26, tripModel.getShipgstn());
			
			pst2.setString(27, tripModel.getDest_contact_person());
			
			pst2.setString(28, tripModel.getDest_contact_no());
			
			
			pst2.setString(29, tripModel.getLoadname());	
			
			pst2.setString(30, tripModel.getLoadadd());	
			
			pst2.setString(31, tripModel.getLoadstate());	
			System.out.println("666");
			
			pst2.setString(32, tripModel.getLoadgstn());	
			
			pst2.setString(33, tripModel.getLoad_contact_person());	
			
			pst2.setString(34, tripModel.getLoad_contact_no());
			
			pst2.setString(35, tripModel.getDriver_mobile());
			
			System.out.println("777");
			
			
			/*pst2.setString(36, tripModel.getAdd1());
			pst2.setString(37, tripModel.getMobile1());
			pst2.setString(38, tripModel.getGstin1());
			pst2.setString(39, tripModel.getCustname1());
			pst2.setString(40, tripModel.getState1());
			System.out.println("7777777");
			
			pst2.setString(41, tripModel.getAdd2());
			pst2.setString(42, tripModel.getMobile2());
			pst2.setString(43, tripModel.getGstin2());
			pst2.setString(44, tripModel.getCustname2());
			pst2.setString(45, tripModel.getState2());
			System.out.println("88888888");
			pst2.setString(46, tripModel.getAdd3());
			pst2.setString(47, tripModel.getMobile3());
			pst2.setString(48, tripModel.getGstin3());
			pst2.setString(49, tripModel.getCustname3());
			pst2.setString(50, tripModel.getState3());
			
*/			String[] billto=tripModel.getBill_to().split("-");
			
			pst2.setString(36,billto[0]);
			pst2.setString(37,billto[1] );
			
			pst2.setString(38, tripModel.getBuyername());
			pst2.setString(39, tripModel.getBuyeradd());
			pst2.setString(40, tripModel.getBuyerstatus());
			pst2.setString(41, tripModel.getBuyergstn());
			pst2.setString(42, tripModel.getBuyer_contact_person());
			pst2.setString(43, tripModel.getBuyer_contact_no());
			
			pst2.setString(44, tripModel.getInvoice_No());
			pst2.setString(45, tripModel.getVehicle_Type());
			
			pst2.setString(46, tripModel.getInvoice_value());
			
			
			
			System.out.println("pst2 .... "+pst2);
			
			int c2 =pst2.executeUpdate();
			System.out.println("pst2 after exicute----------------"+pst2);
			
			
			response="success";
			
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		/////////////// Delete///////////////////////
			
		try{
			
			PreparedStatement pst121 = conn.prepareStatement("delete from LR_details  where LR_no='"
					+ tripModel.getLr_number() + "' ");


			System.out.println("Delete::"+pst121);
			
			int i1 = pst121.executeUpdate();

			response="success";

       
			}catch(Exception e){
				
				
				System.out.println(e.getMessage());
			}
			
			
			
			
		
		
	
			
			
			try {
				
				int k = 0;
				
				PreparedStatement pstd = conn.prepareStatement("insert into LR_details(LR_no,description,weight,amount,order_id,no_of_package,type_of_packing) values(?,?,?,?,?,?,?)");
				
				for (int l = 0; l < tripModel.getAa().length; l++) {
					
					if ((tripModel.getAa()[l] != "")) {
						
						
						pstd.setString(1, tripModel.getLr_number());
						
						pstd.setString(2, tripModel.getCc()[l]);
						pstd.setString(3, tripModel.getGg()[l]);
					/*	pstd.setString(4, tripModel.getHh()[l]);*/
						pstd.setString(4, tripModel.getIi()[l]);
						pstd.setString(5, tripModel.getOrder_id());
						
						pstd.setString(6, tripModel.getAa()[l]);
						pstd.setString(7, tripModel.getBb()[l]);
						/*pstd.setString(9, tripModel.getDd()[l]);*/
						/*pstd.setString(10, tripModel.getEe()[l]);
						pstd.setString(11, tripModel.getFf()[l]);*/
						
						k = pstd.executeUpdate();
						response= "success";
						System.out.println(" ppppppppppppp---"+pstd);
					}
				}
				
				System.out.println("size k = "+k);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				

						
				try {


					
					PreparedStatement pst03 = conn.prepareStatement("update transportercreditdebit set Customercode=?, date=?, trip_id=?, updown_id=?,source=?, destination=?,  Amount=?, Name=?, Documentsno=?, Typecode=?, type=?, transporter_code=? where LR_no='"+tripModel.getLr_number()+"'");
					
					
					pst03.setString(1, cust[1]);
					pst03.setString(2, CoreData.getDateFormatAsDb(tripModel.getDate()));
					pst03.setString(3, tripModel.getTrip_id());
					pst03.setString(4, tripModel.getUpdown_id());
					
					
					pst03.setString(5, tripModel.getSource());
					pst03.setString(6, tripModel.getDestination());
					
					pst03.setString(7, tripModel.getTotal_amount());
					pst03.setString(8, trans[0]);
					pst03.setString(9, tripModel.getCommission_id());
					pst03.setString(10, "101");
					pst03.setString(11, "Debit");
					pst03.setString(12, trans[1]);
					int c3 = pst03.executeUpdate();
					
					
					System.out.println("c3 :"+c3);
					
					

	
						response= "success";
					
					
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				
				
				DBConnection.closeConnection();
				
					return response;
		
		
		}
		
		
		
		
		
		
		public String lrCancel(TripModel tripModel, String lr_number, userinfo bean) {
			
			Connection conn=connection.getConnection();
			
			try {
				
				
				
				String q1 = "update lr set status='cancel' where LR_no='"+lr_number+"'";
				
			
				PreparedStatement ps = conn.prepareStatement(q1);	
				
				System.out.println("SQL:"+ps);

				ps.executeUpdate();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			return "success";
		
		
		
		
		}
		
		
		
		
		
		public String insert_status(TripModel tripModel, userinfo bean) throws Exception {
	
			Connection conn=connection.getConnection();
			
			String response="";
			
			try {
				
				PreparedStatement pst = conn.prepareStatement("insert into lr_status (lr_no,date,status,username,datetime) values(?,?,?,?,?)");
				
				pst.setString(1, tripModel.getLr_number());
				
				pst.setString(2, CoreData.getDateFormatAsDb(tripModel.getDate()));
				
				pst.setString(3, tripModel.getRemark());
				
				pst.setString(4, bean.getUsername());
				
				pst.setString(5, SystemDateTime.CurrentDateTime());
				
			
				pst.executeUpdate();
				
				
				response= "success";
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
			
			Properties systemPropery = null;
			systemPropery = new Properties();
			
			
			String mobile1="8805854900,8329596526,8788963179,7499083359";
			
			
			try {
				systemPropery
						.load(new InquiryDao()
								.getClass()
								.getResourceAsStream(
										"/com/master/dao/UserProfile.properties"));
				String userid = systemPropery.getProperty("USERID");
				String senderid = systemPropery.getProperty("SENDERID");
				String pass = systemPropery.getProperty("SMSPASS");
				String smsflag = systemPropery.getProperty("SMSFLAG");
				String os = "";
				String mob = "";
				
				String requestUrl = "http://bhashsms.com/api/sendmsg.php?user="
						+ userid
						+ "&pass="
						+ pass
						+ "&sender="
						+ senderid
						+ "&phone="
						+ mobile1
						+ "&text=LR Number."+tripModel.getLr_number()+", Now Status Is :"+tripModel.getRemark()+"";

				

				requestUrl = requestUrl.replace(" ", "%20");
				
				URL url = new URL(requestUrl);
				
				System.out.println("URL:"+url);

				HttpURLConnection uc = (HttpURLConnection) url
						.openConnection();
				uc.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
				System.out.println("Error" + uc.getResponseMessage());

				uc.disconnect();

			
			} catch (MalformedURLException e) {
				
				System.out.println("MalformedURLException:"
						+ e.getMessage());
			} catch (IOException e) {
				
				System.out.println("IOException:" + e.getMessage());
			}
			
			
			
			
			
			
			
			
			
			
			
			DBConnection.closeConnection();
			
			return response;
			
		}
		
		
		
		
		
		public String insert_chitchat(TripModel tripModel, userinfo bean) throws Exception {
			
			Connection conn=connection.getConnection();
			
			String response="";
			
			try {
				
				PreparedStatement pst = conn.prepareStatement("insert into lr_chit_chat (lr_no,date,status,username,datetime) values(?,?,?,?,?)");
				
				pst.setString(1, tripModel.getLr_number());
				
				pst.setString(2, CoreData.getDateFormatAsDb(tripModel.getDate()));
				
				pst.setString(3, tripModel.getRemark());
				
				pst.setString(4, bean.getUsername());
				
				pst.setString(5, SystemDateTime.CurrentDateTime());
			
				pst.executeUpdate();
				
				
				response= "success";
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
			return response;
		}
		
		
		
		
		
		
		
		public String insert_amt(TripModel bin, userinfo bean) {
			// TODO Auto-generated method stub

			String response = "";

			try {
				//System.out.println("hello");

				Connection conn=connection.getConnection();

			

				String salary_code="";
				try {

					
					PreparedStatement psx = conn.prepareStatement("select  max(SUBSTRING(docid,-5)) as salary_code from amount_issue12  ");
					System.out.println(psx);
					ResultSet rsx = psx.executeQuery();
					if (rsx.next())
					{
						salary_code = String.valueOf(Integer.parseInt(rsx.getString(1)) + 1);
						if (String.valueOf(salary_code).length() == 1) 
							salary_code = "ISS/0000" + salary_code ;
						else if (String.valueOf(salary_code).length() == 2)
							salary_code = "ISS/000" + salary_code ;
						else if (String.valueOf(salary_code).length() == 3) 
							salary_code = "ISS/00" + salary_code ;
						else if (String.valueOf(salary_code).length() == 4) 
							salary_code = "ISS/0" + salary_code ;
						else if (String.valueOf(salary_code).length() == 5) 
							salary_code = "ISS/" + salary_code ;
					} 
					else 
						salary_code = "ISS/00001";
					
			}	catch (Exception e) {
					// TODO: handle exception
					salary_code = "ISS/00001";
				}
				
				
				String ssk[]=bin.getName().split("-");
				String sskk[]=bin.getGiven_by().split("-");
				
				PreparedStatement pst1 = conn.prepareStatement(
						"insert into amount_issue12(date,emp_name,particular,amount,remark,emp_id,docid,given_by,given_id) values(?,?,?,?,?,?,?,?,?)");

				//System.out.println(pst1);

				//System.out.println("111");
				pst1.setString(1, CoreData.getDateFormatAsDb(bin.getDate1y()));
				//System.out.println("222");

				pst1.setString(2, ssk[0]);
				//System.out.println("333");

				pst1.setString(3, bin.getParticular());
				//System.out.println("333");

				pst1.setString(4, bin.getAmount1());
				//System.out.println("333");

				pst1.setString(5, bin.getRemark());
				//System.out.println("333");

				pst1.setString(6, ssk[1]);
				pst1.setString(7, salary_code);
				pst1.setString(8, sskk[0]);
				pst1.setString(9, sskk[1]);
				//System.out.println(pst1);

				pst1.executeUpdate();

				//System.out.println(pst1);

			
				if (bin.getParticular().equals("SALARY ADVANCE")) {

					try {
						PreparedStatement pst9 = conn.prepareStatement("insert into supervisorcreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,emp_Name,emp_id,username,datetime,billno,given_id,given_name)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst9.setString(1, bin.getEmp_id());
						pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDateTime()));
						pst9.setString(3, salary_code);
						pst9.setString(4, "Salary Advance");
						pst9.setString(5, "201");
						pst9.setString(6, "Credit");
						pst9.setString(7, bin.getAmount1());
						pst9.setString(8, ssk[0]);
						pst9.setString(9, ssk[1]);
						
						pst9.setString(10, "");
						pst9.setString(11, SystemDateTime.CurrentDateTime());
						
						try {
							pst9.setString(12,"");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							pst9.setString(12,"");
							e1.printStackTrace();
						}
						
						pst9.setString(13,sskk[0]);
						pst9.setString(14, sskk[1]);
						

						System.out.println("SQL:" + pst9);
						int k1 = pst9.executeUpdate();
						
						System.out.println("SQL55555555555555555555555555------------:" + pst9);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				}
					
					try {
						PreparedStatement pst9 = conn.prepareStatement("insert into diley_cashreport(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,emp_id,username,datetime,billno,cash_source,form_source)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst9.setString(1, bin.getEmp_id());
						pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDateTime()));
						pst9.setString(3, salary_code);
						pst9.setString(4, bin.getRemark());
						pst9.setString(5, "201");
						pst9.setString(6, "Credit");
						pst9.setString(7, bin.getAmount1());
						pst9.setString(8, ssk[0]);
						pst9.setString(9, ssk[1]);
						
						pst9.setString(10, "");
						pst9.setString(11, SystemDateTime.CurrentDateTime());
						
						try {
							pst9.setString(12,"");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							pst9.setString(12,"");
							e1.printStackTrace();
						}
						
						pst9.setString(13, " ");
						pst9.setString(14, "Amount Issue Form");
						

						System.out.println("SQL:" + pst9);
						int k1 = pst9.executeUpdate();
						
						System.out.println("SQL55555555555555555555555555------------:" + pst9);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					
				// //System.out.println("hsn name is......."+bin.getCity());
				response = "success";
				/* } */

			} catch (Exception e) {
				// TODO: handle exception
			}
		
			return response;

		
		}
		
		
		public List<TripModel> updateamountissue(TripModel product_model, String product_id) {
			// TODO Auto-generated method stub
		List<TripModel> list=new ArrayList<TripModel>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT * FROM amount_issue12 where docid='"+product_id+"'");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				TripModel productModel=new TripModel();
				
				productModel.setEmp_name(rs.getString("emp_name")+"-"+rs.getString("emp_id"));
				productModel.setDest_contact_person(rs.getString("particular"));
				productModel.setAmount1(rs.getString("amount"));
				productModel.setGiven_by(rs.getString("given_by")+"-"+rs.getString("given_id"));
				productModel.setRemark(rs.getString("remark"));
				productModel.setDate1y(rs.getString("date"));
				productModel.setDocumentsno(rs.getString("docid"));
				
				
				
				list.add(productModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return list;
		}	
		
		
		
		
		
		
		public String insertcustcreditdebitnote(TripModel dpb, userinfo bean) {
			// TODO Auto-generated method stub
			String response="";
			try
			{
				

				Connection conn=connection.getConnection();
				
				
				
				
				String stringValue="";
				int len=0;

				String name = "aaa";
				String code = "aaa";
				
				
				if(dpb.getUsertype().equals("Customer"))
				{
					try{
						String ss[]=dpb.getDealer_code().split("-");
					  
						name = ss[0];
						 code = ss[1];
						
					
					}catch (Exception e) {
						 name = "aaa";
						 code = "111";
						}
					
				PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  custcreditdebitnote");
	System.out.println(preparedStatement1);
				ResultSet resultSet1=preparedStatement1.executeQuery();
				while(resultSet1.next()){
					len++;
				}	


				int size=len+1;
				stringValue=String.valueOf(size);

				if(stringValue.length()==1)
				{
					stringValue="CUST/CREDEB/000"+stringValue;
				}
				else if(stringValue.length()==2)
				{
					stringValue="CUST/CREDEB/00"+stringValue;
				}
				else if(stringValue.length()==3)
				{
					stringValue="CUST/CREDEB/0"+stringValue;
				}
				else
				{
					stringValue="CUST/CREDEB/"+stringValue;
				}


				dpb.setVoucher_no(stringValue);

				
				int q=0;	
				String a4="insert into custcreditdebitnote(doc_no,date,nariation,cdtype,amount,refno,customer_id,customer_name) values(?,?,?,?,?,?,?,?)";
				PreparedStatement pst4=conn.prepareStatement(a4);  
				
				pst4.setString(1, stringValue);
				
				pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				pst4.setString(3, dpb.getRemark());
				pst4.setString(4, dpb.getType());
				
				pst4.setString(5,dpb.getDealer_payment_amt());	
				pst4.setString(6, dpb.getRefno());
				pst4.setString(7, code);
				pst4.setString(8, name);
				//pst4.setString(9,"00");
				
				
				q=pst4.executeUpdate();
				
				System.out.println("1111111111111111111-------------"+pst4);


				
				if(dpb.getType().equals("Debit"))
				{
					PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
							+ "VALUES ('"+code+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Debit Note','101','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
					System.out.println(pst31);
					int i=pst31.executeUpdate();
					System.out.println("11111111111111111112222222222222-------------"+pst31);

				}
				
				else{
					
					PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
							+ "VALUES ('"+code+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Credit Note','201','Credit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
					System.out.println(pst31);
					int i=pst31.executeUpdate();

					System.out.println("11111111111111111112222222222222-------------"+pst31);

					
				}
				
				
					}else
				{
						
						
						try{
							String ss[]=dpb.getTransport_code().split("-");
						  
							name = ss[0];
							 code = ss[1];
							
						
						}catch (Exception e) {
							 name = "aaa";
							 code = "111";
							}
						
						

						PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  suppliercreditdebitnote");
			System.out.println(preparedStatement1);
						ResultSet resultSet1=preparedStatement1.executeQuery();
						while(resultSet1.next()){
							len++;
						}	


						int size=len+1;
						stringValue=String.valueOf(size);

						if(stringValue.length()==1)
						{
							stringValue="CUST/CREDEB/000"+stringValue;
						}
						else if(stringValue.length()==2)
						{
							stringValue="CUST/CREDEB/00"+stringValue;
						}
						else if(stringValue.length()==3)
						{
							stringValue="CUST/CREDEB/0"+stringValue;
						}
						else
						{
							stringValue="CUST/CREDEB/"+stringValue;
						}


						dpb.setVoucher_no(stringValue);
					
						int q=0;	
						String a4="insert into suppliercreditdebitnote(doc_no,date,nariation,cdtype,amount,refno,customer_id,customer_name) values(?,?,?,?,?,?,?,?)";
						PreparedStatement pst4=conn.prepareStatement(a4);  
						
						pst4.setString(1, stringValue);
						
						pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						pst4.setString(3, dpb.getRemark());
						pst4.setString(4, dpb.getType());
						
						pst4.setString(5,dpb.getDealer_payment_amt());	
						pst4.setString(6, dpb.getRefno());
						pst4.setString(7,code);
						pst4.setString(8,name);
						//pst4.setString(9,"00");
						
						
						q=pst4.executeUpdate();

						System.out.println("1111111111111111111222222222222233333333333333-------------"+pst4);

						
						if(dpb.getType().equals("Debit"))
						{
							PreparedStatement pst31=conn.prepareStatement("Insert into transportercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
									+ "VALUES ('"+code+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Debit Note','101','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
							System.out.println(pst31);
							int i=pst31.executeUpdate();
							System.out.println("11111111111111111112222222222222333333333333334444444-------------"+pst31);

						}
						
						else{
							
							PreparedStatement pst31=conn.prepareStatement("Insert into transportercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
									+ "VALUES ('"+code+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Credit Note','201','Credit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
							System.out.println(pst31);
							int i=pst31.executeUpdate();
							System.out.println("11111111111111111112222222222222333333333333334444444-------------"+pst31);

							
						}
						}

				response="success";

				
			}
			catch(Exception e)
			{

				response="fail";
			}
			return response;

			
		}
		
		
		
		public static List<TripModel> fetchCreditDebitNoteCust(TripModel  bean) throws Exception {


			Connection conn=connection.getConnection();
			
			
			List<TripModel> list=new ArrayList<TripModel>();
				
			String cond="";
			String conds="";
			try{
				if (!bean.getBankname().equals("") && !bean.getBankname().equals(null)) {
					
					try{
						 String s[]=bean.getBankname().split("-");
						 	
						 conds=s[1];
						//s = s.substring(0, s.indexOf(")"));
						
						 			
					}catch (Exception e) {
						// TODO: handle exception
						conds="";
					}
			
					cond = " and customer_id='" + conds + "' ";
				}
				}catch(Exception e){
					
				}
			
			
			
			try{
				System.out.println(">>>>1");
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT *  FROM custcreditdebitnote WHERE    date BETWEEN ? AND ? "+ cond +" order by custcreditdebitnote.date " );
			System.out.println(">>>>2");
			preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
			System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			
			
			System.out.println("qqqqqqqqqqqqqqqqq------------"+preparedStatement3);
			
			while(resultSet3.next()){

				TripModel bean1=new TripModel();


				
				bean1.setSale_date(CoreData.getDateFormatAsUser(resultSet3.getString("date")));
				bean1.setRemark(resultSet3.getString("nariation"));
				bean1.setDocumentsno(resultSet3.getString("doc_no"));
				bean1.setType(resultSet3.getString("cdtype"));
				bean1.setAmount1(resultSet3.getString("amount"));
				bean1.setCust_id(resultSet3.getString("customer_id"));
				bean1.setCust_name(resultSet3.getString("customer_name"));
				bean1.setRefno(resultSet3.getString("refno"));
				
				list.add(bean1);
				

			}
			
			}catch(Exception e){}
			
			return list;

	}
		
		
		public static List<TripModel> fetchCreditDebitNoteSup(TripModel bean) throws Exception {

			Connection conn=connection.getConnection();
			
			List<TripModel> list=new ArrayList<TripModel>();
				
			
			try{
				
				String cond="";
				String conds="";
				try{
					if (!bean.getBankname().equals("") && !bean.getBankname().equals(null)) {
						
					
							try{
								 String s[]=bean.getBankname().split("-");
								 	
								 conds=s[1];
								//s = s.substring(0, s.indexOf(")"));
								
								 			
							}catch (Exception e) {
								// TODO: handle exception
								conds="";
							}
					
							 			
						
				
						cond = " and customer_id='" + conds + "' ";
					
						
						}
					}catch(Exception e){
						
					}
				
				
				System.out.println(">>>>1");
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT *  FROM suppliercreditdebitnote WHERE    date BETWEEN ? AND ? "+ cond +" order by suppliercreditdebitnote.date " );
			System.out.println(">>>>2");
			preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
			System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			
			while(resultSet3.next()){

				TripModel bean1=new TripModel();


				
				bean1.setSale_date(CoreData.getDateFormatAsUser(resultSet3.getString("date")));
				bean1.setRemark(resultSet3.getString("nariation"));
				bean1.setDocumentsno(resultSet3.getString("doc_no"));
				bean1.setType(resultSet3.getString("cdtype"));
				bean1.setAmount1(resultSet3.getString("amount"));
				bean1.setCust_id(resultSet3.getString("customer_id"));
				bean1.setCust_name(resultSet3.getString("customer_name"));
				bean1.setRefno(resultSet3.getString("refno"));
				
				list.add(bean1);
				

			}
			
			}catch(Exception e){}
			
			return list;

	}
	
		
		public String insertLrAdvanceform(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			String stringValue5 = "";
			int c=0;
			
			String response="";
			
			Connection conn=connection.getConnection();
			
			try {
				
				
				TripModel model = new TripModel();
				
				String pref="HSL/ADV";
				String stringValue1 = "1";
				try {
				PreparedStatement preparedStatement11 = conn
						.prepareStatement("select  max(SUBSTRING(voucher_no,-5)) as myval1 from lr_advance  where LENGTH(voucher_no)>5 and voucher_no like '%"
								+ pref + "%' ");
				String mystr1 = "";
				int myval1 = 0;
			
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				if (resultSet11.next()) {
					try {
						mystr1 = resultSet11.getString("myval1");
						myval1 = Integer.parseInt(mystr1);
						myval1 = myval1 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval1 = 1;
						mystr1 = "";
					}
				}
		

				if (mystr1.equals("")) {
					stringValue1 = pref + "/0000" + stringValue1;

				} else {

					if (String.valueOf(myval1).length() == 1) {
						stringValue1 = pref + "/0000" + String.valueOf(myval1);

					} else if (String.valueOf(myval1).length() == 2) {
						stringValue1 = pref + "/000" + String.valueOf(myval1);
					} else if (String.valueOf(myval1).length() == 3) {
						stringValue1 = pref + "/00" + String.valueOf(myval1);
					} else  if (String.valueOf(myval1).length() == 4) {
						stringValue1 = pref + "/0" + String.valueOf(myval1);
					} else {
						stringValue1 = pref + "/" + String.valueOf(myval1);
					}
				}
				System.out.println("2");
				//model.setVoucher_no(stringValue1);
				System.out.println(model.getVoucher_no());
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				try {
					
					String sskl[]=tripModel.getDriver_name().split("-");
				
			PreparedStatement pst = conn.prepareStatement("insert into lr_advance( date, exp_parti, exp_amount, remark, given_by,voucher_no,vandor_name,vandor_id) values(?,?,?,?,?,?,?,?)");
			pst.setString(1, CoreData.getDateFormatAsDb(tripModel.getDate()));
			pst.setString(2, tripModel.getExp_parti());
			pst.setString(3, tripModel.getExp_amount());
			pst.setString(4, tripModel.getRemark());
			pst.setString(5, tripModel.getGiven_by());
			pst.setString(6, stringValue1);
			pst.setString(7, sskl[0]);
			pst.setString(8, sskl[1]);
			
			
			c = pst.executeUpdate();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			
			
				try {
					String sskl[]=tripModel.getDriver_name().split("-");
					
				
				PreparedStatement pst2 = conn.prepareStatement("insert into vendor_creditdebit(Documentsno , username, Date, totalamount,type,datetime,vendor_name,vendor_id) values(?,?,?,?,?,?,?,?)");
				pst2.setString(1, stringValue1);
				pst2.setString(2, bean.getUsername());
				pst2.setString(3, SystemDateTime.CurrentDate());
				pst2.setString(4, tripModel.getExp_amount());
				pst2.setString(5, "Credit");
				pst2.setString(6,SystemDateTime.CurrentDateTime());
				pst2.setString(7, sskl[0]);
				pst2.setString(8, sskl[1]);
				c = pst2.executeUpdate();
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				
			response="success";
			
			//System.out.println("pst: "+pst);
			
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
				System.out.println(e.getMessage());
			}
			
			
			DBConnection.closeConnection();
			return response;
		}
		
			
		
		public List<TripModel> vendor_Credit_Advance_Report_submitv(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub
			Connection conn=connection.getConnection();
			List<TripModel> list=new ArrayList<TripModel>();
			BigDecimal saldo=BigDecimal.ZERO;
			String dcode="";
			String dcode1="";
			String cond="";
			String s="";
			System.out.println(">>>>1");
			
			String[] trans = tripModel.getDealer_id().split("-");
			
			
			try{
				// s=tripModel.getDealer_id();
				 s = trans[1];
			
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			
			//System.out.println("<<<>>>>1"+s);


			
			try{
			if(!s.equals("") && !s.equals(null)){
				//System.out.println("1");
				cond=" and vendor_id='"+s+"' ";
				//System.out.println("2");
			}else{
				cond="";
			}
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("3");
			}
			try {
			PreparedStatement preparedStatement2=conn.prepareStatement("SELECT SUM(IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00)) AS Debito, SUM(IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00)) AS Credito,Documentsno FROM vendor_creditdebit WHERE  Date < ?  "+cond+" and Documentsno not like 'HSL/ADV%'  order by  vendor_creditdebit.Date ");
			
			/*preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));*/
			preparedStatement2.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date())+" 00:00:00");
			System.out.println("1"+preparedStatement2);
			ResultSet resultSet2=preparedStatement2.executeQuery();
			System.out.println("14444444444444444444---------------"+preparedStatement2);
			if(resultSet2.next()){
				BigDecimal temp1=BigDecimal.ZERO;
				BigDecimal temp2=BigDecimal.ZERO;

				if(resultSet2.getBigDecimal("Debito") !=null){
					temp1=resultSet2.getBigDecimal("Debito");
				}
				if(resultSet2.getBigDecimal("Credito") !=null){
					temp2=resultSet2.getBigDecimal("Credito");
				}
				BigDecimal temp3=temp2.subtract(temp1);
				
				
				String kkk=resultSet2.getString("Documentsno");
				System.out.println("fffffffffffffffff---------"+kkk);
				
				try {
				
			/*	String ssklp[]=kkk.split("(");
				
				String ss[]=ssklp[1].split(")");
				
				String advid=ss[0]; 
				
				System.out.println("sssssssss----------"+advid);
				*/
					String valuess="";
					  Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(kkk);
					     while(m.find()) {
					       System.out.println(m.group(1));
					       valuess=m.group(1);
					     }
					
					
				if(!valuess.equals(""))
				{
					PreparedStatement preparedStatement2un=conn.prepareStatement("SELECT SUM(IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00)) AS Debito, SUM(IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00)) AS Credito,Documentsno as dcno FROM vendor_creditdebit WHERE  Documentsno='"+valuess+"' order by  vendor_creditdebit.Date ");
					
					
					System.out.println("1"+preparedStatement2un);
					ResultSet resultSet2un=preparedStatement2un.executeQuery();
					System.out.println("14444444444444444444---------------"+preparedStatement2un);
					if(resultSet2un.next()){
						
						if(resultSet2un.getBigDecimal("Debito") !=null){
							temp1=resultSet2un.getBigDecimal("Debito");
						}
						if(resultSet2un.getBigDecimal("Credito") !=null){
							temp2=resultSet2un.getBigDecimal("Credito");
						}
						 temp3=temp2.subtract(temp1);
				}
					
					valuess="";
			}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				saldo=saldo.add(temp3);
				
			System.out.println(">>>>>::"+saldo);
			}
			
			/*PreparedStatement preparedStatement3=conn.prepareStatement("SELECT DATE_FORMAT(table3.Date, '%d/%m/%Y') as Date,Remark,Documentsno,table3.type,IF(table3.type='Debit',table3.Amount,0.00) AS Debito,IF(table3.type='Credit',table3.Amount,0.00) AS Credito,Customercode,Name,Amount,billno  FROM table3 WHERE    Date BETWEEN ? AND ?    "+cond+"  order by table3.Date " );*/
			PreparedStatement preparedStatement3=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,vendor_creditdebit.type,IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00) AS Debito,IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00) AS Credito,vendor_id,vendor_name,totalamount,Bill_no  FROM vendor_creditdebit WHERE    Date BETWEEN ? AND ?    "+cond+" and Documentsno not like 'HSL/ADV%'  order by vendor_creditdebit.Date " );
			
			/*preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date1().replace("/", "-")+" 00:00:00"));*/
			preparedStatement3.setString(1, SysDate.getDateFormatAsDb(tripModel.getFrom_date()));
			preparedStatement3.setString(2, SysDate.getDateFormatAsDb(tripModel.getTo_date())) ;
			//System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			BigDecimal finalbalance=BigDecimal.ZERO;
			BigDecimal tempSaldocredit=BigDecimal.ZERO;
			BigDecimal tc=BigDecimal.ZERO;
			BigDecimal td=BigDecimal.ZERO;
			BigDecimal tempcredit=BigDecimal.ZERO;
			BigDecimal tempdebit=BigDecimal.ZERO;
			BigDecimal tempSaldo = saldo;
			while(resultSet3.next()){

				TripModel bean1=new TripModel();

				BigDecimal debit=resultSet3.getBigDecimal("Debito");
				BigDecimal credit=resultSet3.getBigDecimal("Credito");
				BigDecimal temp = debit.subtract(credit);
				tempSaldo = tempSaldo.add(temp);
				System.out.println("<<<<<"+tempSaldo);
				bean1.setTotal_amount(""+tempSaldo);
				//BigDecimal temp=debit.subtract(credit);
				if(resultSet3.getString("type").trim().equalsIgnoreCase("debit")  ){
					tempdebit=tempdebit.add(debit);
				}
				if(resultSet3.getString("type").trim().equalsIgnoreCase("credit")){
					tempcredit=tempcredit.add(credit);

				}
				dcode1=resultSet3.getString("vendor_name");
				bean1.setDc_date(resultSet3.getString("vendor_id"));
				bean1.setDealer_id(resultSet3.getString("vendor_name"));
				bean1.setFrom_date(tripModel.getFrom_date());
				bean1.setTo_date(tripModel.getTo_date());
				bean1.setType(resultSet3.getString("type").trim());
				bean1.setInitialbalance(saldo.toString());
				
				bean1.setSale_date(resultSet3.getString("Date"));
				bean1.setRemark(resultSet3.getString("Remark"));
				bean1.setDocumentsno(resultSet3.getString("Documentsno"));
				bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
				bean1.setFinalbalancedebit(String.valueOf(tempdebit));
				bean1.setFinalbalancecredit(String.valueOf(tempcredit));
				
				bean1.setRemark1(resultSet3.getString("Remark"));
								
			

				tc=tc.add(credit);
				td=td.add(debit);
				bean1.setDealer_id(resultSet3.getString("vendor_name"));
				bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
				
				
				bean1.setTotal_amt(bean1.getFinalbalance());
				
				
				list.add(bean1);
				
			
				String kkk=resultSet3.getString("Documentsno");
				//System.out.println("fffffffffffffffff---------"+kkk);
				
				try {
					
					
					String valuess="";
					
					
					  Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(kkk);
					     while(m.find()) {
					       System.out.println(m.group(1));
					       valuess=m.group(1);
					     }
					
					
					     System.out.println("sssssssssssssssssssss------------"+valuess);
				
				/*String ssklp[]=kkk.split("(");
				
				String ss[]=ssklp[1].split(")");
				
				String advid=ss[0]; 
				
				System.out.println("sssssssss----------"+advid);
				*/
				if(!valuess.equals("") &&  ! valuess.equals(null))
				{
					PreparedStatement preparedStatement3uu=conn.prepareStatement("SELECT Date as Date,Remark,Documentsno,vendor_creditdebit.type,IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00) AS Debito,IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00) AS Credito,vendor_id,vendor_name,totalamount,Bill_no  FROM vendor_creditdebit WHERE Documentsno='"+valuess+"'  order by vendor_creditdebit.Date " );
					
					
					ResultSet resultSet3uu=preparedStatement3uu.executeQuery();
					System.out.println("14444444444444444444---------------"+preparedStatement3uu);
					if(resultSet3uu.next()){
						
						TripModel bean2=new TripModel();
						 debit=resultSet3uu.getBigDecimal("Debito");
						 credit=resultSet3uu.getBigDecimal("Credito");
						 temp = debit.subtract(credit);
						tempSaldo = tempSaldo.add(temp);
						System.out.println("<<<<<"+tempSaldo);
						bean2.setTotal_amount(""+tempSaldo);
						//BigDecimal temp=debit.subtract(credit);
						if(resultSet3uu.getString("type").trim().equalsIgnoreCase("debit")  ){
							tempdebit=tempdebit.add(debit);
						}
						if(resultSet3uu.getString("type").trim().equalsIgnoreCase("credit")){
							tempcredit=tempcredit.add(credit);

						}
						dcode1=resultSet3uu.getString("vendor_name");
						bean2.setDc_date(resultSet3uu.getString("vendor_id"));
						bean2.setDealer_id(resultSet3uu.getString("vendor_name"));
						bean2.setFrom_date(tripModel.getFrom_date());
						bean2.setTo_date(tripModel.getTo_date());
						bean2.setType(resultSet3uu.getString("type").trim());
						bean2.setInitialbalance(saldo.toString());
						
						bean2.setSale_date(resultSet3uu.getString("Date"));
						bean2.setRemark(resultSet3uu.getString("Remark"));
						bean2.setDocumentsno(resultSet3uu.getString("Documentsno"));
						bean2.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
						bean2.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
						bean2.setFinalbalancedebit(String.valueOf(tempdebit));
						bean2.setFinalbalancecredit(String.valueOf(tempcredit));
						
						bean2.setRemark1(resultSet3uu.getString("Remark"));
										
					

						tc=tc.add(credit);
						td=td.add(debit);
						bean2.setDealer_id(resultSet3uu.getString("vendor_name"));
						bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
						
						
						bean2.setTotal_amt(bean2.getFinalbalance());
						
						
						list.add(bean2);
				}
					valuess="";
			}
				
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				
				
				

			}
			TripModel bean2=new TripModel();
			bean2.setInitialbalance(saldo.toString());
			
			
			bean2.setFinalbalancedebit(String.valueOf(tempdebit));
			bean2.setFinalbalancecredit(String.valueOf(tempcredit));
			
			bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
			if(!cond.equals("")){
			bean2.setDelader(tripModel.getDriver_name());
			}
			bean2.setFrom_date(tripModel.getFrom_date());
			bean2.setTo_date(tripModel.getTo_date());
			list.add(bean2);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			DBConnection.closeConnection();
			
			
			return list;
		}



		public String insertTripIssueDetails11(TripModel tripModel, userinfo bean) {
			// TODO Auto-generated method stub

			// TODO Auto-generated method stub
			int c=0;
			String stringValue5;
			
			Connection conn=connection.getConnection();
			
			try {
				
				
//				TripModel model = new TripModel();
//				PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='101' ");
//				ResultSet rs1 = pst1.executeQuery();
//				System.out.println("pst1: "+pst1);
//				
//				if(rs1.next())
//				{
//					
//						model.setDebit_amount(rs1.getString(1));
//					
//				}
//				
//				
//				
//				System.out.println("debit: "+model.getDebit_amount());
//				PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+tripModel.getGiven_by()+"' and typecode='201' ");
//				ResultSet rs2 = pst2.executeQuery();
//				System.out.println("pst2: "+pst2);
//				
//				if(rs2.next())
//				{
//					
//						model.setCredit_amount(rs2.getString(1));
//					
//					
//				}
//				
//				String debit = model.getDebit_amount();
//				if(debit==null)
//				{
//					model.setDebit_amount("0");
//				}
//				
//				String credit = model.getCredit_amount();
//				
//				if(credit==null)
//				{
//					model.setCredit_amount("0");
//				}
//				
//				System.out.println("credit001: "+credit);
//				
//				double remainin_amt = Double.parseDouble(model.getCredit_amount()) - Double.parseDouble(model.getDebit_amount());
//				model.setRemaining_amount(String.valueOf(remainin_amt));
//				
//				
//				if(Double.parseDouble(model.getRemaining_amount())<Double.parseDouble(tripModel.getExp_amount()))
//				{
//					return "insufficient";
//				}
//				
				
				
				
				
			
				String pref="HSL/VCR";
				String stringValue1 = "1";
				try {
				PreparedStatement preparedStatement11 = conn
						.prepareStatement("select  max(SUBSTRING(voucher_no,-5)) as myval1 from issue_expenses  where LENGTH(voucher_no)>5 and voucher_no like '%"
								+ pref + "%' ");
				String mystr1 = "";
				int myval1 = 0;
			
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				if (resultSet11.next()) {
					try {
						mystr1 = resultSet11.getString("myval1");
						myval1 = Integer.parseInt(mystr1);
						myval1 = myval1 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval1 = 1;
						mystr1 = "";
					}
				}
		

				if (mystr1.equals("")) {
					stringValue1 = pref + "/0000" + stringValue1;

				} else {

					if (String.valueOf(myval1).length() == 1) {
						stringValue1 = pref + "/0000" + String.valueOf(myval1);

					} else if (String.valueOf(myval1).length() == 2) {
						stringValue1 = pref + "/000" + String.valueOf(myval1);
					} else if (String.valueOf(myval1).length() == 3) {
						stringValue1 = pref + "/00" + String.valueOf(myval1);
					} else  if (String.valueOf(myval1).length() == 4) {
						stringValue1 = pref + "/0" + String.valueOf(myval1);
					} else {
						stringValue1 = pref + "/" + String.valueOf(myval1);
					}
				}
				System.out.println("2");
				//model.setVoucher_no(stringValue1);
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			PreparedStatement pst = conn.prepareStatement("insert into issue_expenses(trip_id, vehicle_no, driver_name, date, exp_parti, exp_amount, remark, given_by, pump_receipt,LR_no,voucher_no) values(?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, tripModel.getTrip_id());
			pst.setString(2, tripModel.getVehicle_no());
			pst.setString(3, tripModel.getDriver_name());
			pst.setString(4, tripModel.getDate());
			pst.setString(5, tripModel.getExp_parti());
			pst.setString(6, tripModel.getExp_amount());
			pst.setString(7, tripModel.getRemark());
			pst.setString(8, tripModel.getGiven_by());
			System.out.println("trip_id: "+tripModel.getTrip_id());
			System.out.println("exp_parti: "+tripModel.getExp_parti());
			try {
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				pst.setString(9, tripModel.getPump_receipt());
			}
			else
			{
				pst.setString(9, "");
			}
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			pst.setString(10, tripModel.getLr_number());
			pst.setString(11, stringValue1);
			c = pst.executeUpdate();
			
			
			PreparedStatement pst3 = conn.prepareStatement("insert into managercreditdebit(Customercode, date, Amount, Name, Documentsno, Typecode, type, billno, emp_name, remark) values(?,?,?,?,?,?,?,?,?,?)");
			pst3.setString(1,"");
			pst3.setString(2, tripModel.getDate());
			pst3.setString(3, tripModel.getExp_amount());
			pst3.setString(4,tripModel.getGiven_by());
			pst3.setString(5,tripModel.getAmount_issue_code());
			pst3.setString(6, "101");
			pst3.setString(7, "Debit");
			pst3.setString(8, tripModel.getAmount_issue_code());
			pst3.setString(9, tripModel.getGiven_by());
			pst3.setString(10, tripModel.getRemark());
			
			int c1 = pst3.executeUpdate();
			
			
			
			
			if(tripModel.getExp_parti().equalsIgnoreCase("DIESEL"))
			{
				
				String stringValue6 = "";
				int len4 = 0;
				PreparedStatement preparedStatement5 = conn
						.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from vehiclecreditdebit");
				
				
				String mystr4 = "";
				int myval4 = 0;
				ResultSet resultSet4 = preparedStatement5.executeQuery();
				
				if (resultSet4.next()) {
					try {
						mystr4 = resultSet4.getString("myval1");
						myval4 = Integer.parseInt(mystr4);
						myval4 = myval4 + 1;
					} catch (Exception e) {
						// TODO: handle exception
						myval4 = 1;
						mystr4 = "";
					}
				}
				
				
				
				
				int size4 = len4 + 1;
				stringValue6 = String.valueOf(myval4);
				
					if (stringValue6.length() == 1) {
						stringValue6 = "HSL/BILL/" + "000" + stringValue6;
					} else if (stringValue6.length() == 2) {
						stringValue6 = "HSL/BILL/" + "00" + stringValue6;
					} else if (stringValue6.length() == 3) {
						stringValue6 = "HSL/BILL/" + "0" + stringValue6;
					} else {
						stringValue6 = "HSL/BILL/" + stringValue6;
					}
					//deliverymodel.setBill_no(stringValue5);		
					
					tripModel.setBill_no(stringValue6);;	
				
				
				
				
				
				
				
				
				
				PreparedStatement pst4 = conn.prepareStatement("insert into vehiclecreditdebit(Vehicle_no, date, Amount, Name, Documentsno, Typecode, type, billno, remark) values(?,?,?,?,?,?,?,?,?)");
				pst4.setString(1,tripModel.getVehicle_no());
				pst4.setString(2, tripModel.getDate());
				pst4.setString(3, tripModel.getExp_amount());
				pst4.setString(4,tripModel.getGiven_by());
				pst4.setString(5,tripModel.getAmount_issue_code());
				pst4.setString(6, "101");
				pst4.setString(7, "Debit");
				pst4.setString(8, tripModel.getBill_no());
				//pst3.setString(9, tripModel.getGiven_by());
				pst4.setString(9, tripModel.getRemark());
				
				int c2 = pst4.executeUpdate();
			}
			

		
			
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			DBConnection.closeConnection();
			
				return "success";
			
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
}
