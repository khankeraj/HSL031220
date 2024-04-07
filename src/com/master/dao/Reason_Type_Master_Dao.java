package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.model.TransportBean;
import com.master.util.SystemDateTime;

public class Reason_Type_Master_Dao {
	
	
	static DBConnection connection=new DBConnection();
	//static Connection conn=connection.getConnection();

	public String insertReasonTypeMaster(TransportBean bin, userinfo bean)throws SQLException,ParseException {
		
		Connection conn=connection.getConnection();
		String response="";
		try {
			
			
					//PreparedStatement pst = connection.prepareStatement("select *  from medicine_master where medicine=? and clinicId=?");
					PreparedStatement pst = conn.prepareStatement("select *  from reason where reason=? ");
					
					
					
					pst.setString(1,bin.getModel());
					
				//	pst.setString(2,bean.getClinicId());
			           
					
					ResultSet resultSet1=pst.executeQuery();
					
					if(resultSet1.next())
					{
					response="Already";
					
					}
					
					else
					
					{
						
						
						String pref="RESN";
						
						PreparedStatement preparedStatement11 = conn
								.prepareStatement("select  max(SUBSTRING(reason_id,-5)) as myval1 from reason  ");
	
						
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
						
						bin.setVehicle_id(stringValue1);	
						
						
						
					PreparedStatement pst2 = conn.prepareStatement(
							"insert into reason(reason_id,reason,username,datetime) values(?,?,?,?) ");
					
					pst2.setString(1,bin.getVehicle_id());
					pst2.setString(2,bin.getModel().trim());
					/*pst2.setString(3,bin.getSize());
					pst2.setString(4,bin.getNo_of_bag());
					pst2.setString(5,bin.getNo_of_box());
					*/
					pst2.setString(3, bean.getUsername());
					
					pst2.setString(4, SystemDateTime.CurrentDateTime());
					
					
					pst2.executeUpdate();
					
					
						
					response = "success";
				}
					
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		DBConnection.closeConnection();
		
		return response;

	}

	
	
	
	public List<TransportBean> displayReasonTypeMaster(userinfo bean) {

		List<TransportBean> report = new ArrayList<TransportBean>();
		
		Connection conn=connection.getConnection();
		
		try {
			
			//PreparedStatement pst = connection.prepareStatement("select *  from medicine_master where clinicId='"+bean.getClinicId()+"' ");
			
			PreparedStatement pst = conn.prepareStatement("select *  from reason  ");
		
		
			System.out.println("SQL::"+pst);
			
			
			ResultSet resultSet1=pst.executeQuery();
		
			while(resultSet1.next())
		
			{
		
				TransportBean bean1 = new TransportBean();
			
				bean1.setModel(resultSet1.getString("reason"));
				//bean1.setSize(resultSet1.getString("size"));
				//bean1.setNo_of_bag(resultSet1.getString("no_of_bag"));
				//bean1.setNo_of_box(resultSet1.getString("no_of_box"));
			
				bean1.setId(resultSet1.getString("id"));
				
			
				report.add(bean1);

				
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		
		DBConnection.closeConnection();
		
		return report;
		
		
	}
	
	
	
	public List<TransportBean> displayReasonTypeMasterEdit(userinfo bean,String id) {

		List<TransportBean> report = new ArrayList<TransportBean>();
		
		Connection conn=connection.getConnection();
		
		try {
			
			//PreparedStatement pst = connection.prepareStatement("select *  from medicine_master where clinicId='"+bean.getClinicId()+"' ");
			
			PreparedStatement pst = conn.prepareStatement("select *  from reason where id="+id+" ");
		
		System.out.println("SQL::"+pst);
			ResultSet resultSet1=pst.executeQuery();
		
			while(resultSet1.next())
		
			{
		
				TransportBean bean1 = new TransportBean();
			
				bean1.setModel(resultSet1.getString("reason"));
				//bean1.setSize(resultSet1.getString("size"));
				//bean1.setNo_of_bag(resultSet1.getString("no_of_bag"));
				//bean1.setNo_of_box(resultSet1.getString("no_of_box"));
			
				bean1.setId(resultSet1.getString("id"));
					
			
				report.add(bean1);

				
			
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		
		DBConnection.closeConnection();
		
		return report;
		
		
	}
	
	
	public static List<TransportBean> updateReasonTypeMaster(TransportBean pb,userinfo bean) throws Exception {
		
		List<TransportBean> clist = new ArrayList<TransportBean>();
		
		Connection conn=connection.getConnection();
		
		try{
			System.out.println("SQL:");
			
			
					String q1 = "update reason set reason='"+pb.getModel()+"',"
							+ "username='"+bean.getUsername()+"',"
							+ "datetime='"+SystemDateTime.CurrentDateTime()+"' where id='"+pb.getId()+"'";
					
					System.out.println("SQL:"+q1);

					PreparedStatement ps = conn.prepareStatement(q1);	
     	
					//ps.setString(1, bean.getUsername());
					
					//ps.setString(2, SystemDateTime.CurrentDateTime());
					
					//ps.setString(3, pb.getWeight());
					
					//ps.setString(4, pb.getPouch_size());
					
					//ps.setString(5, pb.getMrp());
					//ps.setString(6, pb.getQty1());
     	
					System.out.println("SQL:"+ps);
					ps.executeUpdate();
				
	        
	        
	  		} catch (Exception e) {
	  		}
		
		
		DBConnection.closeConnection();
		
	  		return clist;
	  	
	}
	
	
	
	public static String deleteReasonTypeMaster(TransportBean pb,userinfo bean,String id) throws Exception {
		
		Connection conn=connection.getConnection();

		try {
			
			PreparedStatement pst4 = conn.prepareStatement("delete from reason where id='"
							+ id+ "' ");

		System.out.println("Delete>>>"+pst4);
			pst4.executeUpdate();

			
			
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		DBConnection.closeConnection();
	
		return "success";
		
	
	}




	/*public String insertmedicineInfo(String medicine, String hsn, String tax,
			String price, String qty1, Pathology bin,userinfo bean, String bprice, String dprice, String molecule) throws SQLException {
String response="";
		
		Connection connection = DaoHelper.getConnection1();
		try{
		
		PreparedStatement pstx = connection.prepareStatement("select *  from medicine_master where medicine=? ");
		
		pstx.setString(1,bin.getMedicine());
		ResultSet resultSet1x=pstx.executeQuery();
		if(resultSet1x.next())
		{
			response = "already";
		}
		else{
		

			PreparedStatement pst2 = connection.prepareStatement(
					"insert into medicine_master(medicine,username,datetime,doctorId,assistantId,clinicId,hsn,tax,price,min_qty,clinic_type,buyprice,dealerprice,molecule) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

			
			pst2.setString(1,bin.getMedicine());
			
			pst2.setString(2, bean.getUsername());
			pst2.setString(3, SystemDateTime.CurrentDateTime());
			
			try {
				
				pst2.setString(4,bean.getDoctorId());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				pst2.setString(4,"");
				e.printStackTrace();
			}
			
			try {
					
				pst2.setString(5,bean.getAssistantId());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				pst2.setString(5,"");
				e.printStackTrace();
			}
			
			try {
				
				pst2.setString(6,bean.getClinicId());
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				pst2.setString(6,"");
				e.printStackTrace();
			}
			
			
			
			if(bin.getHsn().equals(""))
				
			{
			
				pst2.setDouble(7,0.0);
		
			}
			
			else
				
			{
				
				pst2.setString(7,bin.getHsn());
			}
			
			
			if(bin.getTax().equals(""))
				
			{
			
				pst2.setDouble(8,0.0);
		
			}
			
			else
				
			{
				
				pst2.setString(8,bin.getTax());
			}
			
			
			if(bin.getPrice().equals(""))
				
			{
			
				pst2.setDouble(9,0.0);
		
			}
			
			else
				
			{
				
				pst2.setString(9,bin.getPrice());
			}
			pst2.setString(10,bin.getQty1());
			pst2.setString(11,bean.getClinic_type());
			
			pst2.setString(12,bprice);
			pst2.setString(13,dprice);
			pst2.setString(14,molecule);
			//pst2.setString(9,bin.getPrice());
			
						
			pst2.executeUpdate();
			
			
				
			response = "success";
		//}
		}
		catch(Exception e)
		{
			


		}
		DaoHelper.closeConnection();
return response;
	
	
	
	}




	public String ValidEmailCheck(String email, userinfo bean) {
		String response = "";
		String response1 = "";
		try {

			Connection connection = DaoHelper.getConnection1();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select * from userinfo where username=?");
	preparedStatement112.setString(1, email);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	if (resultSet12.next()) {
		response = "email already exist" ;
			} 
		 else{
		
		
			 response="ok";
			
			
				
			}
			
		
			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 DaoHelper.closeConnection();
		return response;

	}


	public String getpmsvalue12(String medicine, userinfo bean) {
		String response = "";
		String response1 = "";
		try {

			Connection connection = DaoHelper.getConnection1();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select * from medicine_master where medicine=?");
	preparedStatement112.setString(1, medicine);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	if (resultSet12.next()) {
		response = "medicine already exist" ;
			} 
		 else{
		
		
			 response="ok";
			
			
				
			}
			
		
			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 DaoHelper.closeConnection();
		return response;

	}



	public String getpmsvalue123(String particular_name, userinfo bean) {
		String response = "";
		String response1 = "";
		try {

			Connection connection = DaoHelper.getConnection1();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select * from payment_particular_master where particular_name=?");
	preparedStatement112.setString(1, particular_name);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	if (resultSet12.next()) {
		response = "particular already exist" ;
			} 
		 else{
		
		
			 response="ok";
			
			
				
			}
			
		
			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 DaoHelper.closeConnection();
		return response;

	}*/

}
	




