package com.master.dao;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import com.master.model.Area_Master_Bean;
import com.master.model.Job_card_bean;
import com.master.model.LoginBean;
import com.master.util.SystemDateTime;
import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.ValuesToBean.jobcardvaluestobean;

//import com.aqua.model.RoleBean;

public class job_card_dao {
	
	
	
	
	public Job_card_bean insertjob_card(Job_card_bean jb, LoginBean bean, String multipleValues) {
		
		String response = "";
		
		try {
		
			DBConnection connection=new DBConnection();Connection conn=connection.getConnection();
		
			//  Jobcard autocode
			
			PreparedStatement pst9 =null;
			
			//fiscal year
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
			        if (result <= 3) {
			        year=""+(result1 - 1);
			        }else{
			        	
			        	  year=""+result1;
			        	
			        }
			        String Fyear ="";
			        if (result <= 3) {
			        	Fyear= " " + (result1 - 1) + "-" + result1;
			        } else {
			        	
			        	Fyear= " " + result1 + "-" + (result1 + 1);
			          
			        }
			        
			        
			        String FMONTH = ""+result;
			        
			        
			        if (result <= 3) {
			            System.out.println("Financial Year : " + (result1 - 1) + "-" + result1);
			        } else {
			            System.out.println("Financial Year : " + result1 + "-" + (result1 + 1));
			        }
			        
			       // System.out.println("Financial Year : " + result1 + "-" + (result1+1));
			        System.out.println("Financial month : " + result);
			
			
			
			
			
			
			
			
			String	pref="JC";
			PreparedStatement preparedStatement11=conn.prepareStatement("select  max(SUBSTRING(job_card_no,-5)) as myval1 from job_card  where LENGTH(job_card_no)>5 " );
			
			String mystr1="";
			int myval1=0;
		String	stringValue1="1";
						ResultSet resultSet11=preparedStatement11.executeQuery();
						if(resultSet11.next()){
							try{
							mystr1=resultSet11.getString("myval1");
							myval1=Integer.parseInt(mystr1);
							myval1=myval1+1;
							}catch (Exception e) {
								// TODO: handle exception
								myval1=1;
								mystr1="";
							}
						}	
			
					
						
						
						if(mystr1.equals("")){
							stringValue1=pref+"/0000"+stringValue1;
							
						}else{
					
							if(String.valueOf(myval1).length()==1)
							{
								stringValue1=pref+"/0000"+String.valueOf(myval1);
								
							}
							else if(String.valueOf(myval1).length()==2)
							{
								stringValue1=pref+"/000"+String.valueOf(myval1);
							}
							else if(String.valueOf(myval1).length()==3)
							{
								stringValue1=pref+"/00"+String.valueOf(myval1);
							}
							else if(String.valueOf(myval1).length()==4)
							{
								stringValue1=pref+"/0"+String.valueOf(myval1);
							}
							else
							{
								stringValue1=pref+"/"+String.valueOf(myval1);
							}
						}
						
						System.out.println(">>jobcard"+stringValue1);
			
			
			
			

			//-----------------------
			

			PreparedStatement preparedStatement = conn
					.prepareStatement("select * from job_card where vehicle_no=? and job_card_done_status='0'");
			preparedStatement.setString(1, jb.getVehicle_no());
			System.out.println(preparedStatement);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";
			}

			else {
				PreparedStatement pst = conn
						.prepareStatement("insert into job_card(job_card_no,date,vehicle_no,fuel,KM,body_damage,supervisor,mechanic,delivery_date,ready_status,delivery_status,customer_name,model,details,job_card_done_status,battery_no,daily_running) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");

				System.out.println("jobcardno" + stringValue1);
				pst.setString(1, stringValue1);
				//pst.setString(2, jb.getDate());
				System.out.println(">>>>1");
				/*String ll= Boolean.toString(jb.isBattery());
				System.out.println(">>>>BOOLEAN"+ll);*/
				pst.setString(3, jb.getVehicle_no());
				pst.setString(4, jb.getFuel());
				pst.setString(5, jb.getKM());
				pst.setString(6, jb.getBody_damg());
				pst.setString(7, jb.getSupervisor());
				pst.setString(8, jb.getMechanic());
				//pst.setString(9, jb.getDaily_running());
				//pst.setString(10, );
				//pst.setString(11, jb.getDelivery_time());
				pst.setString(10, "0");
				pst.setString(11, "0");
				//pst.setString(14, jb.getDelivery_status());
				pst.setString(12, jb.getCustomer_name());
				pst.setString(13, jb.getModel_jobcard());
				/*pst.setBoolean(16,jb.isBattery());
				pst.setBoolean(17,jb.isFrohner());
				pst.setBoolean(18,jb.isJackie_handle());
				pst.setBoolean(19,jb.isMats_Carpet());
				pst.setBoolean(20,jb.isSpare_Wheel());
				pst.setBoolean(21,jb.isTool_kit());
				//pst.setBoolean(16,jb.isBattery());
				*/
				System.out.println("insert query"+pst);
				//pst.setString(14,jb.getService_Book()+"~"+jb.getSpare_Wheel()+"~"+jb.getJackie_handle()+"~"+jb.getTool_kit()+"~"+jb.getMats_Carpet()+"~"+jb.getBattery()+"~"+jb.getMudflaps()+"~"+jb.getCarder()+"~"+jb.getStereo()+"~"+jb.getClock());
				pst.setString(14,multipleValues);
				pst.setString(15,"0");
				pst.setString(16,jb.getBatteryno());
				pst.setString(17,jb.getDrunning());
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				Date dNow = new Date();
				Date dNo = new Date();
				jb.setDate(ft.format(dNow));
				jb.setDelivery_date(ft.format(dNo));
				System.out.println("datetime" + jb.getDate());
				pst.setString(2, jb.getDate());
				pst.setString(9, jb.getDelivery_date());
				
				
				
				int i = pst.executeUpdate();
				
				
				// update customermaster
				jb.setJob_Card_no(stringValue1);
				PreparedStatement preparedStatementy = conn
				.prepareStatement("select * from customer_master where vehicle_no=?");
		preparedStatementy.setString(1, jb.getVehicle_no());
		ResultSet resultSety = preparedStatementy.executeQuery();
		if (resultSety.next()) {
			jb.setMobile(resultSety.getString("mobile_no"));
		}

				
				
				PreparedStatement pstx = conn
				.prepareStatement("update   customer_master set  battery_no ='"+jb.getBatteryno()+"' where vehicle_no='"+jb.getVehicle_no()+"'");
				int y=pstx.executeUpdate();
				
				
				//--------------------
				

				if (i > 0 && y > 0)
				{
					response = "success";
				}
				else
				{
					response = "fail";
			}

		} 
		}catch (Exception e) {

			System.out.println("ERROR IN INSERT JOBCARD"+e.getMessage());
		}
		jb.setResponse(response);
		return jb;
	}
public String insertCustomerInfo(String vehicleno1, String modelno1,
		String customer_name1, String chasisno, String engineno, String mobile,
		String address, String phone, String vatno, String cust_subname) throws SQLException {
		System.out.println("dao1");

		
	String response="";
		
	DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
		
		
		PreparedStatement pstx = connection
		.prepareStatement("select *  from customer_master where vehicle_no='"+vehicleno1+"'");
		System.out.println("dao1"+pstx);
		ResultSet resultSet1x=pstx.executeQuery();
		if(resultSet1x.next())
		{
			response = "already";
		}
		else{
		
		PreparedStatement pst = connection
		.prepareStatement("insert into customer_master(cust_name,cust_address,mobile_no,phone_no,vehicle_no,chasis_no,model,eng_no,company_vat,cust_subname) values(?,?,?,?,?,?,?,?,?,?) ");
		System.out.println("dao2");
pst.setString(1,customer_name1);
pst.setString(2, address);

//String ll= Boolean.toString(jb.isBattery());

pst.setString(3, mobile);
pst.setString(4, phone);
pst.setString(5, vehicleno1);
pst.setString(6,chasisno);
pst.setString(7, modelno1);
pst.setString(8, engineno);

try{
	
	if(!vatno.equals("") && !vatno.equals(null)){
pst.setString(9, vatno);
	}else{
		pst.setString(9, "0");		
	}


}catch (Exception e) {
	// TODO: handle exception
	pst.setString(9, "0");		
}

pst.setString(10, cust_subname);

int i = pst.executeUpdate();

if (i > 0)
{
	response = "success";
}
else
{
	response = "fail";
}
		}
		System.out.println(">>"+response);
return response;
	
	
	
	}
public List<Job_card_bean> fetchjobcardInfo(
		) throws SQLException {
	// TODO Auto-generated method stub
	
	List<Job_card_bean> report = new ArrayList<Job_card_bean>();
	try {
		int sno = 1;

	
	DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
	PreparedStatement pst = connection
	.prepareStatement("select job_card_no,date,vehicle_no,customer_name,model,supervisor,mechanic,KM  from job_card where job_card_done_status='0'");
	
	ResultSet resultSet1=pst.executeQuery();
	while(resultSet1.next())
	{
		Job_card_bean bean1 = new Job_card_bean();
		
		bean1.setJob_Card_no(resultSet1.getString(1));
		bean1.setVehicle_no(resultSet1.getString(3));
		
		String Customer_name=resultSet1.getString(4);
		try{
		PreparedStatement pst1 = connection
		.prepareStatement("select mobile_no  from customer_master where cust_name='"+Customer_name+"'");
		ResultSet resultSet11=pst1.executeQuery();
		while(resultSet11.next())
		{
			
		System.out.println("mobileno"+ resultSet11.getString(1));	
		bean1.setMobile(resultSet11.getString(1));
		
		
		}
		}catch (Exception e) {
			// TODO: handle exception
		}
		bean1.setCustomer_name(Customer_name);
		bean1.setModel(resultSet1.getString(5));
		bean1.setSupervisor(resultSet1.getString(6));
		bean1.setMechanic(resultSet1.getString(7));
		bean1.setKM(resultSet1.getString(8));
		 Date Date =resultSet1.getDate(2);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		 String DateStr = df.format(Date);
		 bean1.setDate(DateStr);
		 
		 bean1.setSrno(sno);
		 report.add(bean1);

			sno++; 
	 
		
	}
	} catch (Exception e) {
		// TODO: handle exception
	}		
	
	return report;
	
}



public String canceljobcard(String job_Card_no) throws SQLException {
	// TODO Auto-generated method stub
	DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
	PreparedStatement pstx = conn
	.prepareStatement("update   job_card set  job_card_done_status ='2' where job_card_no='"+job_Card_no+"'");
	System.out.println(pstx);
	int y=pstx.executeUpdate();
	return "success";
}
public String getnvnumber(userinfo bean) throws SQLException {
	// TODO Auto-generated method stub
	
	DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
	
	System.out.println("hiiii");
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
	        
	String pref = "INV";

	PreparedStatement pst9 = null;
	PreparedStatement pst99 = null;

	// String pref="INV";
	PreparedStatement preparedStatement11 = conn
			.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
	preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
		stringValue1 =  "HSL/"+Fyear + "/0000" + stringValue1;

	} else {

		if (String.valueOf(myval1).length() == 1) {
			stringValue1 =  "HSL/"+Fyear + "/0000" + String.valueOf(myval1);

		} else if (String.valueOf(myval1).length() == 2) {
			stringValue1 = "HSL/"+Fyear + "/000" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 3) {
			stringValue1 =  "HSL/"+Fyear + "/00" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 4) { 
			stringValue1 =  "HSL/"+Fyear + "/0" + String.valueOf(myval1);
		}
		else {
			stringValue1 =  "HSL/"+Fyear + "/" + String.valueOf(myval1);
		}
	}
	System.out.println("invoice:"+stringValue1);
	return stringValue1;
}
public String getnvnumbereway() {
	// TODO Auto-generated method stub
	return null;
}











public String getPInvnumber(userinfo bean) throws SQLException {
	// TODO Auto-generated method stub
	
	DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
	
	System.out.println("hiiii");
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
	        
	String pref = "PI";

	PreparedStatement pst9 = null;
	PreparedStatement pst99 = null;

	// String pref="INV";
	PreparedStatement preparedStatement11 = conn
			.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from pi_invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
	preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
		stringValue1 =  "HSL/PI/"+Fyear + "/0000" + stringValue1;

	} else {

		if (String.valueOf(myval1).length() == 1) {
			stringValue1 =  "HSL/PI/"+Fyear + "/0000" + String.valueOf(myval1);

		} else if (String.valueOf(myval1).length() == 2) {
			stringValue1 = "HSL/PI/"+Fyear + "/000" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 3) {
			stringValue1 =  "HSL/PI/"+Fyear + "/00" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 4) { 
			stringValue1 =  "HSL/PI/"+Fyear + "/0" + String.valueOf(myval1);
		}
		else {
			stringValue1 =  "HSL/PI/"+Fyear + "/" + String.valueOf(myval1);
		}
	}
	System.out.println("invoice:"+stringValue1);
	return stringValue1;
}

		
		
		
		
	
	
	




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
