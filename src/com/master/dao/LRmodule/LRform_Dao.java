package com.master.dao.LRmodule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.LoginBean;
import com.master.model.TripModel;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;

public class LRform_Dao {

	public String getpmsamount(String description, String qty, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			{
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select spare_rate,tax_percent from spare_master where description=?");
			preparedStatement1.setString(1, description);
			
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			if (resultSet1.next()) {
				response = resultSet1.getString("spare_rate") + "^"
						+ resultSet1.getString("tax_percent");
			
			}
			}
			
				
				
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	public String getpmsamount1(String description, String qty, String btype,LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "";
		try {
System.out.println("sssss");
			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			if(btype.equalsIgnoreCase("parts"))
			{
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select sale_price,tax_per,hsn_code,item_name from item_master where item_name=?");
			preparedStatement11.setString(1, description);
		System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		while (resultSet1.next()) {
				response = resultSet1.getString("sale_price") + "^"
						+ resultSet1.getString("tax_per")+ "^"
						+ resultSet1.getString("hsn_code")+ "^"
								+ resultSet1.getString("item_name");
				
				
				
				
			}
			}
			else if(btype.equalsIgnoreCase("labour"))
			{
				
				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select cust_price,tax_percent,tax_type,spare_nameinv from spare_master where spare_name=?");
				preparedStatement11.setString(1, description);
			
				ResultSet resultSet1 = preparedStatement11.executeQuery();
				
			while (resultSet1.next()) {
					response = resultSet1.getString("cust_price") + "^"
							+ resultSet1.getString("tax_percent")+ "^"
							+ resultSet1.getString("tax_type")+ "^"
									+ resultSet1.getString("spare_nameinv");
					
					
					
					
				}
			
			}
			
			else if(btype.equalsIgnoreCase("repair"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			else if(btype.equalsIgnoreCase("painting"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			else if(btype.equalsIgnoreCase("repairandrefitting"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	public String getpmsvalue1(String vehicleno1, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String response1 = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select job_card_done_status from job_card where vehicle_no=?");
	preparedStatement112.setString(1, vehicleno1);
	System.out.println(preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	int flg=0;
	while (resultSet12.next()) {
		flg=1;
		response1 = resultSet12.getString("job_card_done_status");
		if(response1.equalsIgnoreCase("0"))
		{
			
			response=" Vehicle no ALready exist";
			
		}
		else{
		
		
		
			
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select model,vehicle_no,cust_name from customer_master where vehicle_no=?");
			preparedStatement11.setString(1, vehicleno1);
	System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
			if (resultSet1.next()) {
				response = resultSet1.getString("model") + "^"
						+ resultSet1.getString("vehicle_no")+ "^"
						+ resultSet1.getString("cust_name");
				
			}
			
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select SUM(Cast( remaining_amount as DECIMAL(10,2)))  from invoice where  vehicle_no='"+vehicleno1+"' ");
				System.out.println("preparedStatement1 " + preparedStatement1);
			ResultSet rs112 = preparedStatement1.executeQuery();
			String pendingamt = "";Double totos=0.0;
			if (rs112.next()) {
				 pendingamt=rs112.getString("amt");
			}
			System.out.println("pendingamt>>>>>"+pendingamt);
			
			response = response + "^" +pendingamt;
			
		}
	}	
			
			
			if(flg==0){
				

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select model,vehicle_no,cust_name from customer_master where vehicle_no=?");
				preparedStatement11.setString(1, vehicleno1);
		System.out.println(preparedStatement11);
				ResultSet resultSet1 = preparedStatement11.executeQuery();
				
				if (resultSet1.next()) {
					response = resultSet1.getString("model") + "^"
							+ resultSet1.getString("vehicle_no")+ "^"
							+ resultSet1.getString("cust_name");
					
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	public String getjobamount1(String Vehicle_no, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String cust_name = "";
		String mobile = "";
		String vendor = "";
		String address = "";
	
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			
				PreparedStatement preparedStatement112qq = connection
				.prepareStatement("select * from customer_master_details where customer_no=?");
				
				preparedStatement112qq.setString(1, Vehicle_no);
		System.out.println(preparedStatement112qq);
				ResultSet resultSet112qq = preparedStatement112qq.executeQuery();
	
				if (resultSet112qq.next()) {
					
					
					
					cust_name=resultSet112qq.getString("customer_name");
				mobile=resultSet112qq.getString("mobile_no");
				
				vendor="";
				address=resultSet112qq.getString("customer_address");
				
				/*PreparedStatement preparedStatement1 = connection
						.prepareStatement("select SUM(Cast( remaining_amount as DECIMAL(10,2)))  as amt  from invoice where  vehicle_no='"+Vehicle_no+"' ");
				
				ResultSet rs112 = preparedStatement1.executeQuery();
				String pendingamt = "";
				if (rs112.next()) {*/
				String pendingamt = "";
				Double totos=0.0;
			//	}
				
				response=resultSet112qq.getString("city")+"^"
				+ resultSet112qq.getString("state")+"^"
				+cust_name+"^"
				+ resultSet112qq.getString("pan_no")+"^"
				+ resultSet112qq.getString("customer_gst_no")+"^"
				+ resultSet112qq.getString("customer_email");
				
				
				
					
					
					response=response+"^"+mobile+ "^" + pendingamt+"^"+vendor+"^"+address;
				
				
				
				
				
				
				}
			
			
			
			
			System.out.println(response);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	
	
	
	
	
	public String getcustname(String cust_id) {
		// TODO Auto-generated method stub
		String response = "0";
			try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			
				PreparedStatement preparedStatement112qq = connection
				.prepareStatement("select * from customer_master where cust_id=?");
				
				preparedStatement112qq.setString(1, cust_id);
				System.out.println(preparedStatement112qq);
				ResultSet resultSet112qq = preparedStatement112qq.executeQuery();
	
				if (resultSet112qq.next()) {
						
				response=resultSet112qq.getString("cust_name");
							
				}
			
				
			System.out.println(response);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}
	
	
	
	
	
	
	public String getbillamount(String billno) {
		// TODO Auto-generated method stub
		String response = "0";
			try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			
				PreparedStatement preparedStatement112qq = connection
				.prepareStatement("select * from lr_advance where voucher_no=?");
				
				preparedStatement112qq.setString(1, billno);
				System.out.println(preparedStatement112qq);
				ResultSet resultSet112qq = preparedStatement112qq.executeQuery();
	
				if (resultSet112qq.next()) {
						
				response=resultSet112qq.getString("exp_amount");
							
				}
			
				
			System.out.println(response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}
	
	
	
	
	
	public String getcustnamegst(String cust_id) {
		// TODO Auto-generated method stub
		String response = "0";
			try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			
				PreparedStatement preparedStatement112qq = connection
				.prepareStatement("select * from product_master where product_name=?");
				
				preparedStatement112qq.setString(1, cust_id);
				System.out.println(preparedStatement112qq);
				ResultSet resultSet112qq = preparedStatement112qq.executeQuery();
					System.out.println("qqqq---"+preparedStatement112qq);
				if (resultSet112qq.next()) {
						
					response=resultSet112qq.getString("hsn_code")+"^"
							+ resultSet112qq.getString("tax_per");
				}
			
				
			System.out.println(response);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}
	
	
	
	
	
	
	
	
	public String gettaxpercent(String taxtype) {
		// TODO Auto-generated method stub
		String response = "0";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select * from spare_master where spare_name=?");
			preparedStatement11.setString(1, taxtype);
			
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
			if (resultSet1.next()) {
				response = resultSet1.getString("tax");
						
				
			}
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	public String getjobamountagain(String vehicle_no, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String cust_name = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select vehicle_no,date,job_card_no,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,bankname,insurance_date,paybycash,paybycredit,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,remaining_amount from invoice where invoice_no=?  ");
			preparedStatement11.setString(1, vehicle_no);
			System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			String model="";
			String Km="";
			String company_vat="";
			String pan="";
			String pono="";
			String podate="";
			String termcond="";
			String vendor="";
			String address="";
			String dcno="";
			String dcdate="";
			 String transmode="";
			 String contactp="";
			 String contactpno="";
			 String shipparty="";
			 String shipadd="";
			 String 	shipgstn="";
			 String 	shipstate="";
			 String vehino="";
			 String 	freight="";
			 String 	transport="";
			
			if (resultSet1.next()) {
				
				
				 pono=resultSet1.getString("pono");
				 podate=resultSet1.getString("podate");
				 termcond=resultSet1.getString("termcond");
				 vendor=resultSet1.getString("vendor");
				 
				  dcno=resultSet1.getString("dcno");
					 dcdate=resultSet1.getString("dcdate");
					 
					  transmode=resultSet1.getString("transmode");
					  contactp=resultSet1.getString("contactp");
					  contactpno=resultSet1.getString("contactpno");
					  shipparty=resultSet1.getString("shipparty");
					  shipadd=resultSet1.getString("shipadd");
					  	shipgstn=resultSet1.getString("shipgstn");
					  	shipstate=resultSet1.getString("shipstate");
					  vehino=resultSet1.getString("vehino");
					  freight=resultSet1.getString("freight");
					  transport=resultSet1.getString("transport");
					
				PreparedStatement preparedStatement112 = connection
				.prepareStatement("select * from customer_master where cust_id=?");
				
				preparedStatement112.setString(1, resultSet1.getString("vehicle_no"));
				
				ResultSet resultSet112 = preparedStatement112.executeQuery();
	String mobile="";
	
				if (resultSet112.next()) {
					
					model=resultSet112.getString("eng_no");
					
					mobile=resultSet112.getString("mobile_no");
					cust_name=resultSet112.getString("cust_name");
				Km=resultSet112.getString("battery_no");
				company_vat=resultSet112.getString("company_vat");
				pan=resultSet112.getString("vehicle_no");
				address=resultSet112.getString("cust_address");
				}
				
				String st="";
				PreparedStatement pst1 = connection.prepareStatement(
						"select * from customer_payment_details where invoiceno='"+vehicle_no+"'");
				System.out.println("pst........." + pst1);
				ResultSet rs1 = pst1.executeQuery();
				if (rs1.next()) {
					
					st="1";
				}else{
					st="0";

				}
				
				response=model+"^"
				+ resultSet1.getString("vehicle_no")+"^"
				+cust_name+"^"
				+ Km+"^"
				+company_vat+"^"
				+ CoreData.getDateFormatAsUser(resultSet1.getString("date"))+"^"
				+ mobile+"^"+resultSet1.getString("pay_mode")+"^"+resultSet1.getString("paid_amount")
				+"^"+resultSet1.getString("remaining_amount")+"^"+ CoreData.getDateFormatAsUser(resultSet1.getString("CHECK_date"))+"^"
				+resultSet1.getString("check_no")+"^"+resultSet1.getString("card_trn_id")+"^"+resultSet1.getString("insurance_comp")+"^"
				+resultSet1.getString("bankname")+"^"+CoreData.getDateFormatAsUser(resultSet1.getString("insurance_date"))
				+"^"+resultSet1.getString("paybycash")+"^"+resultSet1.getString("paybycredit")+"^"+pan+"^"+pono+"^"+podate+"^"+termcond
				+"^"+vendor+"^"+address+"^"+dcno+"^"+dcdate+"^"
				+transmode+"^"+contactp+"^"+contactpno+"^"+shipparty+"^"+shipadd+"^"+shipgstn+"^"+shipstate
				+"^"+vehino+"^"+freight+"^"+transport+"^"+st;
				
				
				
				
				
			}
			
			
			
			
			
			
			System.out.println("<<<<<"+response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}
	
	
	
	
	
	
		
	
	
	public String getjobamountagainsales(String vehicle_no, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String cust_name = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select vehicle_no,date,job_card_no,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,bankname,insurance_date,paybycash,paybycredit,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport from invoice_sales_return where invoice_no=?  ");
			preparedStatement11.setString(1, vehicle_no);
			System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			String model="";
			String Km="";
			String company_vat="";
			String pan="";
			String pono="";
			String podate="";
			String termcond="";
			String vendor="";
			String address="";
			String dcno="";
			String dcdate="";
			 String transmode="";
			 String contactp="";
			 String contactpno="";
			 String shipparty="";
			 String shipadd="";
			 String 	shipgstn="";
			 String 	shipstate="";
			 String vehino="";
			 String 	freight="";
			 String 	transport="";
			
			if (resultSet1.next()) {
				
				
				 pono=resultSet1.getString("pono");
				 podate=resultSet1.getString("podate");
				 termcond=resultSet1.getString("termcond");
				 vendor=resultSet1.getString("vendor");
				 
				  dcno=resultSet1.getString("dcno");
					 dcdate=resultSet1.getString("dcdate");
					 
					  transmode=resultSet1.getString("transmode");
					  contactp=resultSet1.getString("contactp");
					  contactpno=resultSet1.getString("contactpno");
					  shipparty=resultSet1.getString("shipparty");
					  shipadd=resultSet1.getString("shipadd");
					  	shipgstn=resultSet1.getString("shipgstn");
					  	shipstate=resultSet1.getString("shipstate");
					  vehino=resultSet1.getString("vehino");
					  freight=resultSet1.getString("freight");
					  transport=resultSet1.getString("transport");
					
				PreparedStatement preparedStatement112 = connection
				.prepareStatement("select * from customer_master where cust_id=?");
				
				preparedStatement112.setString(1, resultSet1.getString("vehicle_no"));
				
				ResultSet resultSet112 = preparedStatement112.executeQuery();
	String mobile="";
	
				if (resultSet112.next()) {
					
					model=resultSet112.getString("eng_no");
					
					mobile=resultSet112.getString("mobile_no");
					cust_name=resultSet112.getString("cust_name");
				Km=resultSet112.getString("battery_no");
				company_vat=resultSet112.getString("company_vat");
				pan=resultSet112.getString("vehicle_no");
				address=resultSet112.getString("cust_address");
				}
				
				
				response=model+"^"
				+ resultSet1.getString("vehicle_no")+"^"
				+cust_name+"^"
				+ Km+"^"
				+company_vat+"^"
				+ CoreData.getDateFormatAsUser(resultSet1.getString("date"))+"^"
				+ mobile+"^"+resultSet1.getString("pay_mode")+"^"+resultSet1.getString("paid_amount")
				+"^"+resultSet1.getString("balance_amount")+"^"+ CoreData.getDateFormatAsUser(resultSet1.getString("CHECK_date"))+"^"
				+resultSet1.getString("check_no")+"^"+resultSet1.getString("card_trn_id")+"^"+resultSet1.getString("insurance_comp")+"^"
				+resultSet1.getString("bankname")+"^"+CoreData.getDateFormatAsUser(resultSet1.getString("insurance_date"))
				+"^"+resultSet1.getString("paybycash")+"^"+resultSet1.getString("paybycredit")+"^"+pan+"^"+pono+"^"+podate+"^"+termcond
				+"^"+vendor+"^"+address+"^"+dcno+"^"+dcdate+"^"
				+transmode+"^"+contactp+"^"+contactpno+"^"+shipparty+"^"+shipadd+"^"+shipgstn+"^"+shipstate
				+"^"+vehino+"^"+freight+"^"+transport;
							
				
			}
				
			System.out.println("<<<<<"+response);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	public String getpmsvalue1112(String vehicleno1, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String response1 = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select * from customer_master where vehicle_no=?");
	preparedStatement112.setString(1, vehicleno1);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		response = "vehicle_no already exist" ;
			} 
		 else{
		
		
			 response="ok";
			
			
				
			}
			
		
			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	public String getvehicle(String vehicle_no, LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		String response1 = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select * from customer_master where vehicle_no=?");
	preparedStatement112.setString(1, vehicle_no);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		
			response = resultSet12.getString("cust_name") + "^"
					+ resultSet12.getString("cust_address")+ "^"
					+ resultSet12.getString("mobile_no")+ "^"
					+ resultSet12.getString("chasis_no")+ "^"
					+ resultSet12.getString("eng_no")+ "^"
					+ resultSet12.getString("battery_no");
					
			
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}

	public String getjobamountagain1(String estno, LoginBean bean) {
		String response = "0";
		String cust_name = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select cust_name,cust_address,mobile_no,model,vechical_no,email,chasis_no,battery_no,eng_no,date,survey_by,insurance from estimate where estimateno=?  ");
			preparedStatement11.setString(1, estno);
			System.out.println("lrmmm 1"+	preparedStatement11);
			
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
			if (resultSet1.next()) {
				/*System.out.println("lrmmm 2");
				String model="";
				String Km="";
				
				System.out.println("lrmmm 3");
				PreparedStatement preparedStatement112x = connection
				.prepareStatement("select model,KM from job_card where job_card_no=?");
				System.out.println("lrmmm 4");
				preparedStatement112x.setString(1, resultSet1.getString("job_card_no"));
				System.out.println("lrmmm 222"+	preparedStatement112x);
				
				ResultSet resultSet112x = preparedStatement112x.executeQuery();
	
				if (resultSet112x.next()) {
					
					model=resultSet112x.getString("model");
					Km=resultSet112x.getString("KM");
				
				
				
				}
				*/
				/*PreparedStatement preparedStatement112 = connection
				.prepareStatement("select mobile_no,cust_name,model from customer_master where vehicle_no=?");
				
				preparedStatement112.setString(1, resultSet1.getString("vehicle_no"));
				System.out.println("lrmmm 222"+	preparedStatement112);
				
				ResultSet resultSet112 = preparedStatement112.executeQuery();
	String mobile="";
	
				if (resultSet112.next()) {
					
					model=resultSet112.getString("model");
					
					mobile=resultSet112.getString("mobile_no");
					cust_name=resultSet112.getString("cust_name");
				
				}
				
				*/
				response=
				 resultSet1.getString("vechical_no")+"^"
				+ resultSet1.getString("cust_name")+"^"
				+  resultSet1.getString("cust_address")+"^"
				+ CoreData.getDateFormatAsUser(resultSet1.getString("date"))+"^"
				+ resultSet1.getString("mobile_no")+"^"+ resultSet1.getString("chasis_no")+"^"+resultSet1.getString("eng_no")+"^"+resultSet1.getString("battery_no")+"^"+resultSet1.getString("insurance")+"^"+ resultSet1.getString("survey_by");
				
				
			System.out.println("response"+response);
				
				
				
			}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;

	}



	public String getlastmonthjccount(LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
	
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select count(*) as count1  from invoice WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')  ");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		
			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getcurrentmonthjccount(LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select count(*) as count1  from invoice WHERE date BETWEEN DATE_FORMAT(NOW(), '%y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW()), '%y-%m-%d 23:59:59')  ");
			System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;
	}

	public String getlastmonthjcoll(LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(paid_amount) as count1  from invoice WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59') ");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getcurrmonthjcoll(LoginBean bean) {
		// TODO Auto-generated method stub
String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(paid_amount) as count1  from invoice WHERE date BETWEEN DATE_FORMAT(NOW(), '%y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW()), '%y-%m-%d 23:59:59') ");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		

			

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getlastmonthlvtl(LoginBean bean) {
		// TODO Auto-generated method stub
	String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(cgstamount) as count1   from invoice_tax_details   WHERE  invoice_no in (SELECT invoice_no from  invoice  where date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59'))  ");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
	
			response = resultSet12.getString("count1") ;
						
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			//System.out.println("lastmonthlvt Dao"+response);
		return response;

	}

	public String getcurrmonthlvtl(LoginBean bean) {
		// TODO Auto-generated method stub
			String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(cgstamount) as count1   from invoice_tax_details   WHERE  invoice_no in (SELECT invoice_no from  invoice  where date BETWEEN DATE_FORMAT(NOW(), '%y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW()), '%y-%m-%d 23:59:59'))   ");
			System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		

			

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 
		 System.out.println("response"+response);
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getlastmonthstax(LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(sgstamount) as count1   from invoice_tax_details   WHERE  invoice_no in (SELECT invoice_no from  invoice  where date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59'))  ");
			System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		

			

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			System.out.println("lastmonthlvt Dao"+response);
		return response;

	}

	public String getcurrmonthstax(LoginBean bean) {
		// TODO Auto-generated method stub
			String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select sum(sgstamount) as count1   from invoice_tax_details   WHERE  invoice_no in (SELECT invoice_no from  invoice  where date BETWEEN DATE_FORMAT(NOW(), '%y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW()), '%y-%m-%d 23:59:59'))  ");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		

			

			response = resultSet12.getString("count1") ;
					
		
		
	}


			}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getcurrmonthosbill(LoginBean bean) {
		// TODO Auto-generated method stub
	String response = "0";
			double t=0.0;
			double p=0.0;
			double bal=0.0;
			String t1="";
			String p1="";
			String bal1="";
			
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select DISTINCT sum(total) as tot,sum(paid_amount)  as tpaid  from invoice where  Cast( total as DECIMAL(10,2)) > Cast(paid_amount as DECIMAL(10,2))");
			//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		t1=resultSet12.getString("tot") ;
		p1=resultSet12.getString("tpaid") ;
		t=Double.parseDouble(t1);
		p=Double.parseDouble(p1);
		bal=(t-p);
		response = ""+bal ;
	}
			}	
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			
		return response;

	}

	public String getlastpendingjc(LoginBean bean) {
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select count(job_card_no) as count1   from job_card  where date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59') and job_card_done_status='0' ");
			ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
								response = resultSet12.getString("count1") ;
				}

			}	
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			//System.out.println("lastmonthlvt Dao"+response);
		return response;
	}

	public String getcurrpendingjc(LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select count(job_card_no) as count1   from job_card  where date BETWEEN DATE_FORMAT(NOW(), '%y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW()), '%y-%m-%d 23:59:59') and job_card_done_status='0' ");
			ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
			response = resultSet12.getString("count1") ;
	}

			}	
			
		 catch (Exception e) {
			// TODO: handle exception
		}
			System.out.println("curpendingjc Dao"+response);
		return response;
	}

	public String getalertt(LoginBean bean) {
		// TODO Auto-generated method stub
		
		
		int sr=0;
		String response = "0";
		
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			PreparedStatement preparedStatement112 = connection
			.prepareStatement("select DISTINCT vehicle_no from invoice");
			ResultSet resultSet12 = preparedStatement112.executeQuery();
	
			while (resultSet12.next()) {
		
		
			PreparedStatement preparedStatement1123 = connection
			.prepareStatement("select invoice_no ,date from invoice where date <= DATE_FORMAT(NOW() - INTERVAL 4 MONTH, '%Y-%m-01 00:00:00')  and vehicle_no='"+resultSet12.getString("vehicle_no")+"'");
			ResultSet rs3311 = preparedStatement1123.executeQuery();
			if (rs3311.next()) {
				sr++;
				response = ""+sr ;
						
			
			
			}
		}
	
				}	
			
			
			
			
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		 //DaoHelper.closeConnection();
			System.out.println("alert Dao"+response);
		return response;	
	}

	public String getpmsamount1purchase(String description, String qty,
			String btype, LoginBean bean, String model) {
		// TODO Auto-generated method stub
		String response = "0";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			if(btype.equalsIgnoreCase("parts"))
			{
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select company_price,tax_percent,tax_type from spare_master where spare_name=?");
			preparedStatement11.setString(1, description);
		
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		while (resultSet1.next()) {
				response = resultSet1.getString("company_price") + "^"
						+ resultSet1.getString("tax_percent")+ "^"
						+ resultSet1.getString("tax_type");
				
				
				
				
			}
			}
			else if(btype.equalsIgnoreCase("labour"))
			{
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?    ");
				preparedStatement12.setString(1, description);
	
				ResultSet resultSet1 = preparedStatement12.executeQuery();
				System.out.println(preparedStatement12);
				if (resultSet1.next()) {
					response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
				
				}
					
					}
					
					else if(btype.equalsIgnoreCase("repair"))
					{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
				preparedStatement12.setString(1, description);
			
				ResultSet resultSet1 = preparedStatement12.executeQuery();
				
				if (resultSet1.next()) {
					response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
				
				}
				
				}
				else if(btype.equalsIgnoreCase("painting"))
				{
					
					PreparedStatement preparedStatement12 = connection
					.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
					preparedStatement12.setString(1, description);
				
					ResultSet resultSet1 = preparedStatement12.executeQuery();
					
					if (resultSet1.next()) {
						response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
					
					}
					
					}
					else if(btype.equalsIgnoreCase("repairandrefitting"))
					{
						
						PreparedStatement preparedStatement12 = connection
						.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
						preparedStatement12.setString(1, description);
					
						ResultSet resultSet1 = preparedStatement12.executeQuery();
						
						if (resultSet1.next()) {
							response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
						
						}
			
					}
			
					} catch (Exception e) {
						// TODO: handle exception
					}
					return response;
				}
	
	public String getpmsamount1(String description, String qty, String btype,LoginBean bean, String model, String vno) {
		// TODO Auto-generated method stub
		String response = "0";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
			if(btype.equalsIgnoreCase("parts"))
			{
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select cust_price,tax_percent,tax_type from spare_master where spare_name=?");
			preparedStatement11.setString(1, description);
		
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		while (resultSet1.next()) {
			
			PreparedStatement preparedStatement11x = connection
					.prepareStatement("select total from lrform,lrform_details where lrform.lr_no=lrform_details.lr_no and  lrform.lrnumber=? and lrform_details.material_code=? and lrform.po_done_status='0'");
			preparedStatement11x.setString(1, vno);
			preparedStatement11x.setString(2, description);
			System.out.println(preparedStatement11x);
			ResultSet resultSet1x = preparedStatement11x.executeQuery();
			String price="";
		if (resultSet1x.next()) {
			
			price=resultSet1x.getString("total") ;
		}
			
				response = price + "^"
						+ resultSet1.getString("tax_percent")+ "^"
						+ resultSet1.getString("tax_type");
				
				
				
				
			}
			}
			else if(btype.equalsIgnoreCase("labour") || btype.equalsIgnoreCase("labour1") || btype.equalsIgnoreCase("labour2"))
			{
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?    ");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		System.out.println(preparedStatement12);
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			
			else if(btype.equalsIgnoreCase("repair"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			else if(btype.equalsIgnoreCase("painting"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			else if(btype.equalsIgnoreCase("repairandrefitting"))
			{
				
				PreparedStatement preparedStatement12 = connection
				.prepareStatement("select tax_type,tax_percent,amount from stax_master where service_tax_name=?");
		preparedStatement12.setString(1, description);
	
		ResultSet resultSet1 = preparedStatement12.executeQuery();
		
		if (resultSet1.next()) {
			response =  resultSet1.getString("tax_type")+ "^"+ resultSet1.getString("tax_percent") + "^" + resultSet1.getString("amount");
		
		}
			
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
	
	
	
	public String getpmsamount1x(String description, String qty, String btype,
			LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
		
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select sale_price,tax_per,hsn_code from item_master where item_name=?");
			preparedStatement11.setString(1, description);
		System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		while (resultSet1.next()) {
				response = resultSet1.getString("sale_price") + "^"
						+ resultSet1.getString("tax_per")+ "^"
						+ resultSet1.getString("hsn_code");
						
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}
	
	
	
	//akshu
	public String getpmsamount11x(String description, 
			LoginBean bean) {
		// TODO Auto-generated method stub
		String response = "";
		try {

			 DBConnection con=new DBConnection(); Connection connection = con.getConnection();
			
		
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select cust_price from spare_master where spare_name=?");
			preparedStatement11.setString(1, description);
		System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		while (resultSet1.next()) {
				response = resultSet1.getString("cust_price");
						
						
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return response;
	}

	public String gettaxnhsn(String description) {
		// TODO Auto-generated method stub
		String response = "";
		try {

			 DBConnection con=new DBConnection(); 
			 Connection connection = con.getConnection();
			
		
				
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select hsn_code, tax_per from product_master where product_name=?");
			preparedStatement11.setString(1, description);
		
			System.out.println(preparedStatement11);
			ResultSet resultSet1 = preparedStatement11.executeQuery();
			
		if (resultSet1.next()) {
				
					response = 	resultSet1.getString(1)+"^"+resultSet1.getString(2);
						
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}

	public String getAddress(String transporter_code, String customer_code) {
		// TODO Auto-generated method stub
		
		String response="";
		
		try {
			String tadd = "";
			String cadd = "";
			DBConnection con=new DBConnection(); 
			 Connection connection = con.getConnection();
			
			
			PreparedStatement pst = connection.prepareStatement("select transporter_address from transporter_master where transporter_no = '"+transporter_code+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				tadd = rs.getString(1);
			}
			
			
			PreparedStatement pst1 = connection.prepareStatement("select customer_address from customer_master_details where customer_no = '"+customer_code+"'");
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			{
				cadd = rs1.getString(1);
			}
			
			
			
			response = tadd+"^"+cadd;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return response;
	}

	public String getRemainingAmount(String emp_name, String exp_amount) {
		// TODO Auto-generated method stub
		DBConnection con=new DBConnection(); 
		 Connection conn = con.getConnection();
		
		try {
		TripModel model = new TripModel();
		PreparedStatement pst1 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+emp_name+"' and typecode='101' ");
		ResultSet rs1 = pst1.executeQuery();
		System.out.println("pst1: "+pst1);
		
		if(rs1.next())
		{
			
				model.setDebit_amount(rs1.getString(1));
			
		}
		
		
		
		System.out.println("debit: "+model.getDebit_amount());
		PreparedStatement pst2 = conn.prepareStatement("select sum(amount) from managercreditdebit where emp_name= '"+emp_name+"' and typecode='201' ");
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
		
		System.out.println("remain: "+model.getRemaining_amount());
		System.out.println("exp_amount: "+exp_amount);
		
		if(Double.parseDouble(model.getRemaining_amount())<Double.parseDouble(exp_amount))
		{
			return "insufficient";
		}
		else {
			return "sufficient";
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return "sufficient";
	}
	
	

	
	public String getcustditeals(String customer_code) {
		// TODO Auto-generated method stub
		
		String response="";
		
		try {
			String tadd = "";
			String cadd = "";
			DBConnection con=new DBConnection(); 
			 Connection connection = con.getConnection();
			
			
		/*	PreparedStatement pst = connection.prepareStatement("select transporter_address from transporter_master where transporter_no = '"+transporter_code+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				tadd = rs.getString(1);
			}
			*/
			
			PreparedStatement pst1 = connection.prepareStatement("select * from customer_master_details where customer_no = '"+customer_code+"'");
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			{
				cadd = rs1.getString("customer_address")+"^"+ rs1.getString("state")+"^"+ rs1.getString("customer_gst_no")+"^"+ rs1.getString("company_name")+"^"+ rs1.getString("mobile_no");
			}
			else {
				cadd = ""+"^"+ ""+"^"+""+"^"+ ""+"^"+"";
				
			}
			
			
			
			response = cadd;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return response;
	}

	
	
	
	
	
	
	}
