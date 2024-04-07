package com.master.dao.Inquiry;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.action.Inquiry.Inquiry;
import com.master.model.InquiryBean;
import com.master.model.TripModel;
import com.master.model.expenses_Bean;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class InquiryDao{
	
	
	static DBConnection connection=new DBConnection();
	
	//Connection conn=connection.getConnection();
	
	
	
	public String insert_inquiry(InquiryBean im, userinfo bean) {
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		try {
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(inquiry_id,-4)) as myval1 from inquiry");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/IN/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/IN/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/IN/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/IN/"+stringValue;
			}
			
			im.setInquiry_id(stringValue);
			
			
			
			
			
			PreparedStatement pst1 = conn.prepareStatement("insert into inquiry(inquiry_id,date,name,contact_no,resource,source,destination,remark,username,datetime,status,type,resource_from,exim,contact_person) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1, im.getInquiry_id());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getName());
			
			pst1.setString(4, im.getContact_no());
			
			pst1.setString(5, im.getResource());
			
			pst1.setString(6, im.getSource());
			
			pst1.setString(7, im.getDestination());
			
			pst1.setString(8, im.getRemark());
			
			pst1.setString(9, bean.getUsername());
			
			pst1.setString(10,SystemDateTime.CurrentDateTime());
			
			pst1.setString(11,"0");
			
			
			pst1.setString(12, im.getType());
			
			pst1.setString(13, im.getResource_from());
			
			pst1.setString(14, im.getExim());
			
			pst1.setString(15, im.getContact_person());
			
			
			//System.out.println(pst1);
			
			pst1.executeUpdate();
			
			try {
			PreparedStatement pst12 = conn.prepareStatement("insert into escalation_table(enq_id,enq_Date) values(?,?)");
			
			pst12.setString(1, im.getInquiry_id());
			pst12.setString(2,SystemDateTime.CurrentDateTime());

			pst12.executeUpdate();
			
			}
			catch(Exception e)
			{
				System.out.println(">>>>>>>>>>>>>"+e.getMessage());
			}
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		///////////// Status Report///////////////////////
		
		try {
			
			PreparedStatement pst1 = conn.prepareStatement("insert into inquiry_status(inquiry_id,date,inquiry_username,inquiry_datetime) values(?,?,?,?)");
			
			pst1.setString(1, im.getInquiry_id());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
				
			pst1.setString(3, bean.getUsername());
			
			pst1.setString(4,SystemDateTime.CurrentDateTime());
			
			pst1.executeUpdate();
		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Properties systemPropery = null;
		systemPropery = new Properties();
		
		String mobile= im.getContact_no()+",8329596526,9372888900,8805854900,8788963179,7499083359";
		

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
					+ mobile
					+ "&text=Enquiry From "+im.getSource()+" to "+im.getDestination()+" for name "+im.getName()+".&priority=ndnd&stype=normal";

			

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
		
		
		
		/*
		String mobile1=im.getContact_no();
		
		
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
					+ "&text=Thank you for the enquiry,we shall revert to you with a quote shortly.&priority=ndnd&stype=normal";

			

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
		}*/
		
		
		
		
		DBConnection.closeConnection();
		
		return response;
	}






	public List<InquiryBean> fetchInquiryReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			try {
				
				
				
				
				
			}catch(Exception e) {}
			
			
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("select * from inquiry where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setName(rs.getString("name"));
				
				bean1.setContact_no(rs.getString("contact_no"));
				
				bean1.setResource(rs.getString("resource"));
				
				bean1.setSource(rs.getString("source"));
				
				bean1.setDestination(rs.getString("destination"));
				
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setType(rs.getString("type"));
				
				bean1.setResource_from(rs.getString("resource_from"));
		
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}






	public String enquiryCancel(InquiryBean im, userinfo bean, String inquiry_id) {
		
		
		
		try {
			
			
			Connection conn=connection.getConnection();
			
			String q1 = "update inquiry set status='cancel' where inquiry_id='"+inquiry_id+"'";
			
		
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






	public String insert_pricing(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		String name="";
		String id="";
		
		
		try {
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(pricing_id,-4)) as myval1 from pricing");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/PR/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/PR/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/PR/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/PR/"+stringValue;
			}
			
			im.setPricing_id(stringValue);
			
		}
			catch(Exception e)
			{}
		
		
		
		try {
			
			
			/*String details[]=im.getName().split("-");
			
			 name=details[0];
			 id=details[1];*/
			
			
			
			
			PreparedStatement pst1 = conn.prepareStatement("insert into pricing(inquiry_id,date,vendor_name,remark,username,datetime,status,pricing_id,total,vendor_id,type) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1, im.getInquiry_id());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, name);
			
			pst1.setString(4, im.getRemark());
			
			pst1.setString(5, bean.getUsername());
			
			pst1.setString(6,SystemDateTime.CurrentDateTime());
			
			if(im.getType().equals("Contracted"))
				
			{
				
				pst1.setString(7,"2");
			}	
			else {
			
				pst1.setString(7,"0");
			
			}
			
			
			pst1.setString(8, im.getPricing_id());
			
			pst1.setString(9, im.getTotal());
			
			pst1.setString(10, id);	
			
			pst1.setString(11, im.getType());	
			
			System.out.println(pst1);
			
			pst1.executeUpdate();
			
					
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set pricind_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			
			
			response="success";
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		///////////////// Pricing Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into pricing_details(pricing_id,source,destination,price,vehicle_type,username,datetime,inquiry_id,vendorname,status,type,vendor_id) values(?,?,?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getPricing_id());
						pst22.setString(2, im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, bean.getUsername());
						pst22.setString(7, SystemDateTime.CurrentDateTime());
						pst22.setString(8, im.getInquiry_id());
						String[] zz= im.getTransname()[l].split("-");
						name=zz[0];
						id=zz[1];
						pst22.setString(9, name);
						
						String type=im.getTranstype()[l];
						if(type.equals("Contracted"))
							
						{
							
							pst22.setString(10,"2");
						}	
						else {
						 
							pst22.setString(10,"0");
						
						}
					
						pst22.setString(11, type);
						pst22.setString(12, id);
						k = pst22.executeUpdate();
						
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
		
			
			
			
			///////////////// Pricing Check Entry//////////////
			
			
			try {
			
				int k = 0;
					PreparedStatement pst22 = conn.prepareStatement(
							"insert into pricing_check(vendor_name,source,destination,price,vehicle_type,vendor_id,date) values(?,?,?,?,?,?,?)");

					for (int l = 0; l < im.getAa().length; l++) {

						if ( im.getAa()[l] != "") {
							String[] zz= im.getTransname()[l].split("-");
							name=zz[0];
							id=zz[1];
						
					
							pst22.setString(1, name);
							pst22.setString(2, im.getAa()[l]);
							pst22.setString(3, im.getBb()[l]);
							pst22.setString(4, im.getCc()[l]);
							pst22.setString(5, im.getDd()[l]);
							pst22.setString(6, id);
							pst22.setString(7, CoreData.getDateFormatAsDb(im.getDate()));
							
							k = pst22.executeUpdate();
					
						}
					}
					
					
					try
					{
					int kj = 0;
					PreparedStatement pst222 = conn.prepareStatement(
							"insert into pricing_form(vendor_name,source,destination,price,vehicle_type,vendor_id,date) values(?,?,?,?,?,?,?)");

					for (int l = 0; l < im.getAa().length; l++) {

						if ( im.getAa()[l] != "") {
					
							String[] zz= im.getTransname()[l].split("-");
							name=zz[0];
							id=zz[1];
							
							pst222.setString(1, name);
							pst222.setString(2, im.getAa()[l]);
							pst222.setString(3, im.getBb()[l]);
							pst222.setString(4, im.getCc()[l]);
							pst222.setString(5, im.getDd()[l]);
							pst222.setString(6, id);
							pst222.setString(7, CoreData.getDateFormatAsDb(im.getDate()));
							
							kj= pst222.executeUpdate();
							System.out.println("gggggggggggggg------"+pst222);
					
						}
					}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
			
			} catch (Exception e) {
			
				System.out.println(e.getMessage());
			}
			
			
		
			////// Update in Inquiry Table/////////////
			
			try {
				
				
				
				String q1 = "update inquiry set status='1' where inquiry_id='"+im.getInquiry_id()+"'";
				
			
				PreparedStatement ps = conn.prepareStatement(q1);	
				
				System.out.println("SQL:"+ps);

				ps.executeUpdate();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			////// Update in Inquiry Status Report/////////////
			
					try {
						
						
						
						String q1 = "update inquiry_status set pricing_username='"+bean.getUsername()+"',pricing_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id='"+im.getInquiry_id()+"'";
						
					
						PreparedStatement ps = conn.prepareStatement(q1);	
						
						System.out.println("SQL:"+ps);

						ps.executeUpdate();
					
					
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
		
		
		DBConnection.closeConnection();
		
		return response;
	
	}




	
	public String insert_pricing_check(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		String name="";
		String id="";
		
		
		
		try {
			
			
			String details[]=im.getName().split("-");
			
			 name=details[0];
			 id=details[1];
			
			
			
			
			///////////////// Pricing Check Entry//////////////
			
			
			try {
			
				int k = 0;
					PreparedStatement pst22 = conn.prepareStatement(
							"insert into pricing_check(vendor_name,source,destination,price,vehicle_type,vendor_id,date) values(?,?,?,?,?,?,?)");

					for (int l = 0; l < im.getAa().length; l++) {

						if ( im.getAa()[l] != "") {
					
					
							pst22.setString(1, name);
							pst22.setString(2, im.getAa()[l]);
							pst22.setString(3, im.getBb()[l]);
							pst22.setString(4, im.getCc()[l]);
							pst22.setString(5, im.getDd()[l]);
							pst22.setString(6, id);
							pst22.setString(7, CoreData.getDateFormatAsDb(im.getDate()));
							
							k = pst22.executeUpdate();
					
							
							response="success";
						}
					}
			
			} catch (Exception e) {
			
				System.out.println(e.getMessage());
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			
			
		DBConnection.closeConnection();
		
		return response;
	
	}
	
	
	
	
public String insert_pricing_check123(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		String name="";
		String id="";
		
		
		
		try {
			
			
			String details[]=im.getName().split("-");
			
			 name=details[0];
			 id=details[1];
			
			
			
			
			///////////////// Pricing Check Entry//////////////
			
			
			try {
			
				int k = 0;
					PreparedStatement pst22 = conn.prepareStatement(
							"insert into pricing_form(vendor_name,source,destination,price,vehicle_type,vendor_id,date) values(?,?,?,?,?,?,?)");

					for (int l = 0; l < im.getAa().length; l++) {

						if ( im.getAa()[l] != "") {
					
					
							pst22.setString(1, name);
							pst22.setString(2, im.getAa()[l]);
							pst22.setString(3, im.getBb()[l]);
							pst22.setString(4, im.getCc()[l]);
							pst22.setString(5, im.getDd()[l]);
							pst22.setString(6, id);
							pst22.setString(7, CoreData.getDateFormatAsDb(im.getDate()));
							
							k = pst22.executeUpdate();
					
							
							response="success";
						}
					}
			
			} catch (Exception e) {
			
				System.out.println(e.getMessage());
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			
			
		DBConnection.closeConnection();
		
		return response;
	
	}
	


	public List<InquiryBean> fetchPricingReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();	
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				PreparedStatement pst12 = conn.prepareStatement("select * from pricing_details where inquiry_id='"+rs.getString("inquiry_id")+"'");
				ResultSet rs12 = pst12.executeQuery();
				
				if(rs12.next())
				{
					bean1.setSource(rs12.getString("source"));	
					bean1.setDestination(rs12.getString("destination"));
				}
				
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setVendor(rs.getString("vendor_name"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setRemark(rs.getString("remark"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from inquiry where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setName(rs1.getString("name"));
					bean1.setContact_no(rs1.getString("contact_no"));
					
					bean1.setResource(rs1.getString("resource"));
					
					
					
					
					PreparedStatement pst2 = conn.prepareStatement("select * from customer_master_details where customer_name='"+rs1.getString("name")+"'");
					
					ResultSet rs2 = pst2.executeQuery();
					
					if(rs2.next())
					{
						
						bean1.setAddress(rs2.getString("customer_address"));
					}
					
					
				}
				
				
				list.add(bean1);
				
				

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}



	
	
public List<InquiryBean> fetchPricingReport1(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing where status='2'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setVendor(rs.getString("vendor_name"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setRemark(rs.getString("remark"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from inquiry where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setName(rs1.getString("name"));
					
					bean1.setContact_no(rs1.getString("contact_no"));
					
					bean1.setContact_person(rs1.getString("contact_person"));	
					
					
					PreparedStatement pst11 = conn.prepareStatement("select * from customer_master_details where customer_name like '%"+rs1.getString("name")+"%'");
					
					ResultSet rs11 = pst11.executeQuery();
					System.out.println("uuuuuuuuuuuuuuuuuuupppp1111111111---------------"+pst11);
					if(rs11.next())
					{
					
						bean1.setAddress(rs11.getString("customer_address"));
						System.out.println("addresssss------------"+rs11.getString("customer_address"));
						bean1.setGstn(rs11.getString("customer_gst_no"));
						
						bean1.setState(rs11.getString("state"));
						
					}
					
				}
				
				PreparedStatement pst12 = conn.prepareStatement("select * from quotation where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs12 = pst12.executeQuery();
				
				if(rs12.next())
				{
					
					//bean1.setAddress(rs12.getString("address"));
					
					
					try {
					PreparedStatement pst12q = conn.prepareStatement("select * from quotation_details where quotation_no='"+rs12.getString("quotation_no")+"'");
					
					ResultSet rs12q = pst12q.executeQuery();
					System.out.println("uuuuuuuuuuuuuuuuuuupppp---------------"+pst12q);
					if(rs12q.next())
					{
						
						bean1.setVehicle_type(rs12q.getString("type_of_vehicle"));
					}
				}
				catch(Exception e)
				
				{
					System.out.println(e.getMessage());
				}
					
				}
				PreparedStatement pst123 = conn.prepareStatement("select * from pricing where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs123 = pst123.executeQuery();
				
				if(rs123.next())
				{
					
					bean1.setTransporter_name(rs123.getString("vendor_name")+"-"+rs123.getString("vendor_id"));
				}
				
				
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}
	



	public String pricingCancel(InquiryBean im, userinfo bean, String pricing_id) {
		
		
		
		try {
			
			
			Connection conn=connection.getConnection();
			
			String q1 = "update pricing set status='cancel' where pricing_id='"+pricing_id+"'";
			
		
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






	public List<InquiryBean> editPricing(InquiryBean im, userinfo bean, String pricing_id) {
		
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing where pricing_id='"+pricing_id+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from pricing_details where pricing_id='"+pricing_id+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				while(rs1.next())
				{
					
					InquiryBean bean1 = new InquiryBean();
					
					bean1.setInquiry_id(rs.getString("inquiry_id"));
					
					bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
					
					bean1.setVendor(rs.getString("vendor_name")+"-"+rs.getString("vendor_id"));
					
					bean1.setTotal(rs.getString("total"));
					
					bean1.setPricing_id(rs.getString("pricing_id"));
					
					bean1.setRemark(rs.getString("remark"));
					
					bean1.setAa1(rs1.getString("source"));
					bean1.setBb1(rs1.getString("destination"));
					bean1.setCc1(rs1.getString("price"));
					bean1.setDd1(rs1.getString("vehicle_type"));
					
					
					list.add(bean1);
				
				}
				
				
			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}






	public String update_pricing(InquiryBean im, userinfo bean) throws Exception {
		
		
		String response="";
		
		Connection conn=connection.getConnection();
		
		try {
			
			String details[]=im.getName().split("-");
			
			String  name=details[0];
			String id=details[1];
			
			
			
			String q1 = "update pricing set vendor_name='"+name+"',"
					+ "vendor_id='"+id+"',"
					+ "date='"+CoreData.getDateFormatAsDb(im.getDate())+"',"
					+ "username='"+bean.getUsername()+"',"
					+ "datetime='"+SystemDateTime.CurrentDateTime()+"',"
					+ "total='"+im.getTotal()+"',remark='"+im.getRemark()+"' where pricing_id='"+im.getPricing_id()+"'";
			
		
			PreparedStatement ps = conn.prepareStatement(q1);	
			
			//System.out.println("SQL:"+ps);

			ps.executeUpdate();
			response="success";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		/////////////// Delete///////////////////////
		
		try{
			
			PreparedStatement pst121 = conn.prepareStatement("delete from pricing_details  where pricing_id='"
					+ im.getPricing_id() + "' ");


			//System.out.println("Delete::"+pst121);
			
			int i1 = pst121.executeUpdate();

			response="success";

         
			}catch(Exception e){
				
				
				System.out.println(e.getMessage());
			}
			
		
		
		
		
	try {
		
		int k = 0;
		PreparedStatement pst22 = conn.prepareStatement(
				"insert into pricing_details(pricing_id,source,destination,price,vehicle_type,username,datetime,inquiry_id) values(?,?,?,?,?,?,?,?)");

		for (int l = 0; l < im.getAa().length; l++) {

			if ( im.getAa()[l] != "") {
				
				
				
				pst22.setString(1,im.getPricing_id());
				pst22.setString(2, im.getAa()[l]);
				pst22.setString(3, im.getBb()[l]);
				pst22.setString(4, im.getCc()[l]);
				pst22.setString(5, im.getDd()[l]);
				pst22.setString(6, bean.getUsername());
				pst22.setString(7, SystemDateTime.CurrentDateTime());
				pst22.setString(8, im.getInquiry_id());
				
				//System.out.println("SQL:"+pst22);
				
				k = pst22.executeUpdate();
				
				response="success";
				
			}
		}
		
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}
	
	DBConnection.closeConnection();

	return response;
	
	
		
	}
		public String insert_quotation(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		try {
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(quotation_no,-4)) as myval1 from quotation");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/QT/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/QT/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/QT/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/QT/"+stringValue;
			}
			
			im.setQuotation_no(stringValue);
			
		}
			catch(Exception e)
			{}
		
		
		
		try {
			
			PreparedStatement pst1 = conn.prepareStatement("insert into quotation(quotation_no,date,customer_name,address,mobile_no,total,status,username,datetime,pricing_id,inquiry_id,payterm,reference,kind_attn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1, im.getQuotation_no());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getName());
			
			pst1.setString(4, im.getAddress());
			
			pst1.setString(5, im.getContact_no());
			
			pst1.setString(6, im.getTotal());
			
			pst1.setString(7,"0");
			
			pst1.setString(8, bean.getUsername());
			
			pst1.setString(9,SystemDateTime.CurrentDateTime());
			
			pst1.setString(10, im.getPricing_id());	
			
			pst1.setString(11, im.getInquiry_id());	
			
			pst1.setString(12, im.getPayterm());
			
			pst1.setString(13, im.getReference());
			pst1.setString(14, im.getKind_attn());
			
			
			System.out.println(pst1);
			
			pst1.executeUpdate();
			
			System.out.println("000----------------"+pst1);
					
					
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set quotation_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
					
					
					
					
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		///////////////// Quotation Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into quotation_details(quotation_no,type_of_vehicle,size_of_vehicle,weight,rate,source,destination,username,datetime) values(?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getQuotation_no());
						pst22.setString(2, im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, im.getEe()[l]);
						pst22.setString(7, im.getFf()[l]);
						
						pst22.setString(8, bean.getUsername());
						pst22.setString(9, SystemDateTime.CurrentDateTime());
						
						k = pst22.executeUpdate();
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		
		
			
			//////////////////////// Quotation History///////////////////////////
			
			
			try {
				
				PreparedStatement pst1 = conn.prepareStatement("insert into quotationhistory(quotation_no,date,customer_name,address,mobile_no,total,status,username,datetime,revised) values(?,?,?,?,?,?,?,?,?,?)");
				
				
				
				pst1.setString(1, im.getQuotation_no());
				
				pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
				
				pst1.setString(3, im.getName());
				
				pst1.setString(4, im.getAddress());
				
				pst1.setString(5, im.getContact_no());
				
				pst1.setString(6, im.getTotal());
				
				pst1.setString(7,"0");
				
				pst1.setString(8, bean.getUsername());
				
				pst1.setString(9,SystemDateTime.CurrentDateTime());
				
				pst1.setString(10,"Original");	
				
				System.out.println(pst1);
				
				pst1.executeUpdate();
				
						
				response="success";
				
			
			}catch(Exception e) {
				
			}
			
		
			
			
			//////////////////// Quotation Details Revised Entry//////////////////////////
			
			
			
			
		try {
			
			int k = 0;
			PreparedStatement pst22 = conn.prepareStatement(
					"insert into quotation_details_revised(quotation_no,type_of_vehicle,size_of_vehicle,weight,rate,source,destination,username,datetime,revised) values(?,?,?,?,?,?,?,?,?,?)");

			for (int l = 0; l < im.getAa().length; l++) {

				if ( im.getAa()[l] != "") {
					
					
					
					pst22.setString(1,im.getQuotation_no());
					pst22.setString(2, im.getAa()[l]);
					pst22.setString(3, im.getBb()[l]);
					pst22.setString(4, im.getCc()[l]);
					pst22.setString(5, im.getDd()[l]);
					pst22.setString(6, im.getEe()[l]);
					pst22.setString(7, im.getFf()[l]);
					
					pst22.setString(8, bean.getUsername());
					pst22.setString(9, SystemDateTime.CurrentDateTime());
					
					pst22.setString(10,"Original");
					
					k = pst22.executeUpdate();
					
					response="success";
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			
		
		
		///////////// Update Pricing Table///////////
		
		
		try {
			
			
			String q1 = "update pricing set status='1' where pricing_id='"+im.getPricing_id()+"'";
			
		
			PreparedStatement ps = conn.prepareStatement(q1);	
			
			//System.out.println("SQL:"+ps);

			ps.executeUpdate();
			
			response="success";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		///////////// Update Inquiry Status Report ///////////
		
		
		try {
		
		
			String q1 = "update inquiry_status set quotation_username='"+bean.getUsername()+"',quotation_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id='"+im.getInquiry_id()+"'";
		
	
			PreparedStatement ps = conn.prepareStatement(q1);	
		
			//System.out.println("SQL:"+ps);
			
			ps.executeUpdate();
			
			response="success";
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			System.out.println(e.getMessage());
		}
		
		
		
		DBConnection.closeConnection();
		
		return response;
	
	}






	public List<InquiryBean> fetchQuotationReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from quotation where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
					
				bean1.setQuotation_no(rs.getString("quotation_no"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setAddress(rs.getString("address"));
				
				bean1.setContact_no(rs.getString("mobile_no"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
					
				/*PreparedStatement pst1 = conn.prepareStatement("select * from pricing where pricing_id='"+rs.getString("pricing_id")+"'");
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setInquiry_id(rs1.getString("inquiry_id"));
					
				}*/
				
				
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	}






	public List<InquiryBean> viewQuotation(InquiryBean im, userinfo bean, String quotation_no) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from quotation where quotation_no='"+quotation_no+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from quotation_details where quotation_no='"+quotation_no+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				while(rs1.next())
				{
					
					InquiryBean bean1 = new InquiryBean();
					
					bean1.setQuotation_no(rs.getString("quotation_no"));
					
					bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
					
					bean1.setName(rs.getString("customer_name"));
					
					bean1.setTotal(rs.getString("total"));
					
					bean1.setPayterm(rs.getString("payterm"));
					
						
					bean1.setAddress(rs.getString("address"));
					
					bean1.setContact_no(rs.getString("mobile_no"));
					
					bean1.setReference(rs.getString("reference"));
					
					bean1.setKind_attn(rs.getString("kind_attn"));
					
					
					
					
					bean1.setAa1(rs1.getString("type_of_vehicle"));
					bean1.setBb1(rs1.getString("size_of_vehicle"));
					bean1.setCc1(rs1.getString("weight"));
					bean1.setDd1(rs1.getString("rate"));
					bean1.setEe1(rs1.getString("source"));
					bean1.setFf1(rs1.getString("destination"));
					
					
					list.add(bean1);
				
				}
				
				
			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	
	}






	public String update_quotation(InquiryBean im, userinfo bean) throws Exception {
		
		String response="";
		
		Connection conn=connection.getConnection();
		
		try {
			
			
			String q1 = "update quotation set customer_name='"+im.getName()+"',"
					+ "date='"+CoreData.getDateFormatAsDb(im.getDate())+"',"
					+ "address='"+im.getAddress()+"',"
					+ "mobile_no='"+im.getContact_no()+"',"
					+ "payterm='"+im.getPayterm()+"',"
					+ "reference='"+im.getReference()+"',"
					+ "kind_attn='"+im.getKind_attn()+"',"
					+ "username='"+bean.getUsername()+"',"
					+ "datetime='"+SystemDateTime.CurrentDateTime()+"',"
					+ "total='"+im.getTotal()+"' where quotation_no='"+im.getQuotation_no()+"'";
			
		
			PreparedStatement ps = conn.prepareStatement(q1);	
			
			System.out.println("SQL:"+ps);

			ps.executeUpdate();
			
			response="success";
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		/////////////// Delete///////////////////////
		
		try{
			
			PreparedStatement pst121 = conn.prepareStatement("delete from quotation_details  where quotation_no='"
					+ im.getQuotation_no() + "' ");


			System.out.println("Delete::"+pst121);
			
			int i1 = pst121.executeUpdate();

			response="success";

         
			}catch(Exception e){
				
				
				System.out.println(e.getMessage());
			}
			
		
		
	
		
		try {
			
			int k = 0;
			PreparedStatement pst22 = conn.prepareStatement(
					"insert into quotation_details(quotation_no,type_of_vehicle,size_of_vehicle,weight,rate,source,destination,username,datetime) values(?,?,?,?,?,?,?,?,?)");

			for (int l = 0; l < im.getAa().length; l++) {

				if ( im.getAa()[l] != "") {
					
					
					
					pst22.setString(1,im.getQuotation_no());
					pst22.setString(2, im.getAa()[l]);
					pst22.setString(3, im.getBb()[l]);
					pst22.setString(4, im.getCc()[l]);
					pst22.setString(5, im.getDd()[l]);
					pst22.setString(6, im.getEe()[l]);
					pst22.setString(7, im.getFf()[l]);
					
					pst22.setString(8, bean.getUsername());
					pst22.setString(9, SystemDateTime.CurrentDateTime());
					
					k = pst22.executeUpdate();
					
					response="success";
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		
		
		////////////////////////Quotation History///////////////////////////
		
		
		try {
			
			
					String stringValue = "";
					
					int len = 0;
					
					String a=im.getQuotation_no();
					
					PreparedStatement preparedStatement1 = conn
							.prepareStatement("select  max(SUBSTRING(revised,-4)) as myval1 from quotation_details_revised where quotation_no='"+im.getQuotation_no()+"' and revised like '%REV%' ");

					System.out.println("NO:" + preparedStatement1);

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

					if (stringValue.length() == 1) {
						stringValue = a +  "/HSL/REV/" + "000" + stringValue;
					} else if (stringValue.length() == 2) {
						stringValue =  a +  "/HSL/REV/" + "00" + stringValue;
					} else if (stringValue.length() == 3) {
						stringValue =  a +  "/HSL/REV/" + "0" + stringValue;
					} else {
						stringValue = a +  "/HSL/REV/" + stringValue;
					}
					
					im.setRno(stringValue);
			
			
			
			

			PreparedStatement pst1 = conn.prepareStatement("insert into quotationhistory(quotation_no,date,customer_name,address,mobile_no,total,status,username,datetime,revised) values(?,?,?,?,?,?,?,?,?,?)");



			pst1.setString(1, im.getQuotation_no());

			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));

			pst1.setString(3, im.getName());

			pst1.setString(4, im.getAddress());

			pst1.setString(5, im.getContact_no());

			pst1.setString(6, im.getTotal());

			pst1.setString(7,"0");

			pst1.setString(8, bean.getUsername());

			pst1.setString(9,SystemDateTime.CurrentDateTime());

			pst1.setString(10,im.getRno());	

			System.out.println(pst1);

			pst1.executeUpdate();

		
			response="success";


		}catch(Exception e) {

		}




		//////////////////// Quotation Details Revised Entry//////////////////////////




		try {

			int k = 0;
			PreparedStatement pst22 = conn.prepareStatement(
					"insert into quotation_details_revised(quotation_no,type_of_vehicle,size_of_vehicle,weight,rate,source,destination,username,datetime,revised) values(?,?,?,?,?,?,?,?,?,?)");

			for (int l = 0; l < im.getAa().length; l++) {

				if ( im.getAa()[l] != "") {
	
	
	
					pst22.setString(1,im.getQuotation_no());
					pst22.setString(2, im.getAa()[l]);
					pst22.setString(3, im.getBb()[l]);
					pst22.setString(4, im.getCc()[l]);
					pst22.setString(5, im.getDd()[l]);
					pst22.setString(6, im.getEe()[l]);
					pst22.setString(7, im.getFf()[l]);
	
					pst22.setString(8, bean.getUsername());
					pst22.setString(9, SystemDateTime.CurrentDateTime());
	
					pst22.setString(10,im.getRno());
	
					k = pst22.executeUpdate();
	
					response="success";
				}
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		
		
	
	DBConnection.closeConnection();

	return response;
		
	
	
	}
	
	
	
	
	
	public List<InquiryBean> Quotation_View_Print(InquiryBean im, userinfo bean,String qtno) {
		
			
			List<InquiryBean> report1 = new ArrayList<InquiryBean>();
		
			try {
			
				Connection conn=connection.getConnection();

				PreparedStatement pst1 = conn.prepareStatement("select * from quotation_details where quotation_no='"+qtno+"' ");
			
				System.out.println("SQL:"+pst1);
					
				ResultSet rs=pst1.executeQuery();
					
					int sn=0;
					
					while(rs.next())
			
					{
						InquiryBean bean1 = new InquiryBean();
					
						//System.out.println(">>>>>>11111>");
			
			
						bean1.setAa1(rs.getString("type_of_vehicle")); 
					
						bean1.setBb1(rs.getString("size_of_vehicle")); 
					
						bean1.setCc1(rs.getString("weight"));
						bean1.setDd1((rs.getString("rate")));
						bean1.setEe1(rs.getString("source"));
						bean1.setFf1(rs.getString("destination"));
					
						
					
						sn++;
						
						bean1.setSn(sn);
					
					
					
						report1.add(bean1);
		
		
					}
				
			} catch (Exception e) {
			// TODO: handle exception
			}		
		
			DBConnection.closeConnection();
		
			return report1;
		
	}

	
	
	
	
	
	public List<InquiryBean> Quotation_View_Print1(InquiryBean im,
			userinfo bean, String qtno) {
		
		
		
		List<InquiryBean> report1 = new ArrayList<InquiryBean>();
		
		try {
			
			Connection conn=connection.getConnection();

			PreparedStatement pst1 = conn.prepareStatement("select * from quotation where quotation_no='"+qtno+"' ");
			
			System.out.println("SQL:"+pst1);
				ResultSet rs=pst1.executeQuery();
			
				if(rs.next())
			
				{
					InquiryBean bean1 = new InquiryBean();
					
					bean1.setQuotation_no(rs.getString("quotation_no"));
					
					bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
					
					bean1.setTotal(rs.getString("total"));
					
					bean1.setName(rs.getString("customer_name"));
					
					bean1.setAddress(rs.getString("address"));
					
					bean1.setContact_no(rs.getString("mobile_no"));
					
					bean1.setPayterm(rs.getString("payterm"));	
					
					bean1.setReference(rs.getString("reference"));	
					
					bean1.setKind_attn(rs.getString("kind_attn"));	
					
					
					
					PreparedStatement pst11 = conn.prepareStatement("select * from quotation_details where quotation_no='"+qtno+"' ");
					
					System.out.println("SQL:"+pst11);
						
					ResultSet rs1=pst11.executeQuery();
						
						
						if(rs1.next())
				
						{
							bean1.setVehicle_type(rs1.getString("type_of_vehicle"));
							
							
							PreparedStatement pst111 = conn.prepareStatement("select * from vehicle_type_master where model='"+rs1.getString("type_of_vehicle")+"' ");
							
							System.out.println("SQL:"+pst111);
								
							ResultSet rs11=pst111.executeQuery();
								
								
								
								if(rs11.next())
								{
									
									bean1.setHalt_charge(rs11.getString("halt_charge"));
									
								}
							
						}
					
					
					
					report1.add(bean1);
		
		
		}
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		DBConnection.closeConnection();
		
		return report1;
		
	}






	public String quotationCancel(InquiryBean im, userinfo bean, String quotation_no) {


		try {
			
			
			Connection conn=connection.getConnection();
			
			String q1 = "update quotation set status='cancel' where quotation_no='"+quotation_no+"'";
			
		
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
	
	
	
	public List<InquiryBean> revise_Quotation1(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from quotationhistory where customer_name='"+im.getDealer_id()+"'");
			
			//System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
					
				bean1.setQuotation_no(rs.getString("quotation_no"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setAddress(rs.getString("address"));
				
				bean1.setContact_no(rs.getString("mobile_no"));
				
				bean1.setRno(rs.getString("revised"));
				
				
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	}






	public List<InquiryBean> Re_Quotation_View_Print(InquiryBean im, userinfo bean, String qtno, String rno) {
		
		List<InquiryBean> report1 = new ArrayList<InquiryBean>();
		
		try {
		
			Connection conn=connection.getConnection();

			PreparedStatement pst1 = conn.prepareStatement("select * from quotation_details_revised where quotation_no='"+qtno+"' and revised='"+rno+"' ");
		
			System.out.println("SQL:"+pst1);
				
			ResultSet rs=pst1.executeQuery();
				
				int sn=0;
				
				while(rs.next())
		
				{
					InquiryBean bean1 = new InquiryBean();
				
					//System.out.println(">>>>>>11111>");
		
		
					bean1.setAa1(rs.getString("type_of_vehicle")); 
				
					bean1.setBb1(rs.getString("size_of_vehicle")); 
				
					bean1.setCc1(rs.getString("weight"));
					bean1.setDd1((rs.getString("rate")));
					bean1.setEe1(rs.getString("source"));
					bean1.setFf1(rs.getString("destination"));
				
					
				
					sn++;
					
					bean1.setSn(sn);
				
				
				
					report1.add(bean1);
	
	
				}
			
		} catch (Exception e) {
		// TODO: handle exception
		}		
	
		DBConnection.closeConnection();
	
		return report1;
	}






	public List<InquiryBean> Re_Quotation_View_Print1(InquiryBean im, userinfo bean, String qtno, String rno) {
		
		
		List<InquiryBean> report1 = new ArrayList<InquiryBean>();
		
		try {
			
			Connection conn=connection.getConnection();

			PreparedStatement pst1 = conn.prepareStatement("select * from quotationhistory where quotation_no='"+qtno+"' and revised='"+rno+"'");
			
			System.out.println("SQL:"+pst1);
				ResultSet rs=pst1.executeQuery();
			
				while(rs.next())
			
				{
					InquiryBean bean1 = new InquiryBean();
					
					bean1.setQuotation_no(rs.getString("quotation_no"));
					
					bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
					
					bean1.setTotal(rs.getString("total"));
					
					bean1.setName(rs.getString("customer_name"));
					
					bean1.setAddress(rs.getString("address"));
					
					bean1.setContact_no(rs.getString("mobile_no"));
					
						report1.add(bean1);
		
		
		}
				
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		DBConnection.closeConnection();
		
		return report1;
	}






	public String quotationFinal(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
	
		
		
		
		try {
			
			PreparedStatement pst1 = conn.prepareStatement("insert into quotation_final(quotation_no,date,pricing_id,inquiry_id,amount,remark,reason,username,datetime,process) values(?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1, im.getQuotation_no());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getPricing_id());
			
			pst1.setString(4, im.getInquiry_id());
			
			pst1.setString(5, im.getTotal());
			
			pst1.setString(6, im.getRemark());
			
			pst1.setString(7,im.getReason());
			
			pst1.setString(8, bean.getUsername());
			
			pst1.setString(9,SystemDateTime.CurrentDateTime());
			
			pst1.setString(10, im.getType());	
			
			System.out.println(pst1);
			
			pst1.executeUpdate();
			
			
			
			
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set finalize_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			
					
			
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		
		
		try {
			
			
			String q1 = "update quotation set status='1' where quotation_no='"+im.getQuotation_no()+"'";
			
		
			PreparedStatement ps = conn.prepareStatement(q1);	
			
			System.out.println("SQL:"+ps);

			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			
			
			
			String q1 = "update pricing set status='2' where pricing_id='"+im.getPricing_id()+"'";
			
		
			PreparedStatement ps = conn.prepareStatement(q1);	
			
			System.out.println("SQL:"+ps);

			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		///////////// Update Inquiry Status Report ///////////
		
		
		try {
	
	
			String q1 = "update inquiry_status set quotation_final_username='"+bean.getUsername()+"',quotation_final_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id='"+im.getInquiry_id()+"'";
	

			PreparedStatement ps = conn.prepareStatement(q1);	
	
			//System.out.println("SQL:"+ps);
		
			ps.executeUpdate();
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
			System.out.println(e.getMessage());
		}
		
		
		
		DBConnection.closeConnection();
		
		return "success";
		
	}

public String insert_order(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		
		
		
/*try {
			
			PreparedStatement psac = conn.prepareStatement("select * from customer_master_details where customer_name = '"+im.getLoadname()+"'");
			ResultSet rsac = psac.executeQuery();
			
			if(rsac.next())
			{
				System.out.println("1 Customer Exist");
			}
			else {
				String customer_final_id="CUST/0001";
			
			String pref="CUST";
			
			PreparedStatement preparedStatement11 = conn
					.prepareStatement("select  max(SUBSTRING(customer_no,-5)) as myval1 from customer_master_details  where LENGTH(customer_no)>5 and customer_no like '%"
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

			
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO `customer_master_details`(`customer_no`, `customer_name`, `company_name`, `customer_address`, `mobile_no`, `state`, `customer_gst_no`,`type`) VALUES (?,?,?,?,?,?,?,?)");
		
			pstmt.setString(1, stringValue1);
			pstmt.setString(2, im.getLoadname());
			pstmt.setString(3, im.getLoad_contact_person());
			pstmt.setString(4, im.getLoadadd());
			pstmt.setString(5, im.getLoad_contact_no());
		
			pstmt.setString(6, im.getLoadstate());
			
			pstmt.setString(7,im.getLoadgstn());
			
		   
			pstmt.setString(8,"Non Existing");
			
			pstmt.executeUpdate();
		    
			System.out.println("111111111----"+pstmt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


*/
String sspp="";

System.out.println("ghghggh----"+im.getType());
		try {
			
			if(!im.getType().equals("")&&!im.getType().equals(null)) {
				
				
				sspp="yes";
				
			}
			else {
				sspp="no";
			}
		}
		catch(Exception ee)
		{
			sspp="no";
			ee.printStackTrace();
		}
		
		System.out.println("gggggggggg---"+sspp);
if(sspp.equals("yes"))
{	
	
try {
	
	PreparedStatement psac = conn.prepareStatement("select * from customer_master_details where customer_name = '"+im.getShipname()+"'");
	ResultSet rsac = psac.executeQuery();
	
	if(rsac.next())
	{
		System.out.println("2 Customer Exist");
	}
	else {
		String customer_final_id="CUST/0001";
	
	String pref="CUST";
	
	PreparedStatement preparedStatement11 = conn
			.prepareStatement("select  max(SUBSTRING(customer_no,-5)) as myval1 from customer_master_details  where LENGTH(customer_no)>5 and customer_no like '%"
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

	
	PreparedStatement pstmt=conn.prepareStatement("INSERT INTO `customer_master_details`(`customer_no`, `customer_name`, `company_name`, `customer_address`, `mobile_no`, `state`, `customer_gst_no`,`type`) VALUES (?,?,?,?,?,?,?,?)");

	pstmt.setString(1, stringValue1);
	pstmt.setString(2, im.getShipname());
	pstmt.setString(3, im.getDest_contact_person());
	pstmt.setString(4, im.getShipadd());
	pstmt.setString(5, im.getDest_contact_no());

	pstmt.setString(6, im.getShipstate());
	
	pstmt.setString(7,im.getShipgstn());
	
   
	pstmt.setString(8,"Non Existing");
	
	pstmt.executeUpdate();
    
	System.out.println("222222222----"+pstmt);
	}
} catch (SQLException e) {
	e.printStackTrace();
}
}

/*try {
	
	PreparedStatement psac = conn.prepareStatement("select * from customer_master_details where customer_name = '"+im.getBuyername()+"'");
	ResultSet rsac = psac.executeQuery();
	
	if(rsac.next())
	{
		System.out.println("3 Customer Exist");
	}
	else {
		String customer_final_id="CUST/0001";
	
	String pref="CUST";
	
	PreparedStatement preparedStatement11 = conn
			.prepareStatement("select  max(SUBSTRING(customer_no,-5)) as myval1 from customer_master_details  where LENGTH(customer_no)>5 and customer_no like '%"
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

	
	PreparedStatement pstmt=conn.prepareStatement("INSERT INTO `customer_master_details`(`customer_no`, `customer_name`, `company_name`, `customer_address`, `mobile_no`, `state`, `customer_gst_no`,`type`) VALUES (?,?,?,?,?,?,?,?)");

	pstmt.setString(1, stringValue1);
	pstmt.setString(2, im.getBuyername());
	pstmt.setString(3, im.getBuyer_contact_person());
	pstmt.setString(4, im.getBuyeradd());
	pstmt.setString(5, im.getBuyer_contact_no());

	pstmt.setString(6, im.getBuyerstatus());
	
	pstmt.setString(7,im.getBuyergstn());
	
   
	pstmt.setString(8,"Non Existing");
	
	pstmt.executeUpdate();
	System.out.println("3333333----"+pstmt);
	
	}
} catch (SQLException e) {
	e.printStackTrace();
}
*/


		
		try {
			
			
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(order_id,-4)) as myval1 from order_table");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/OR/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/OR/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/OR/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/OR/"+stringValue;
			}
			
			im.setOrder_id(stringValue);
			
		}
			catch(Exception e)
			{}
		
	try {
			
			
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select  max(SUBSTRING(lr_no,-4)) as myval1 from order_table");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rst = preparedStatement.executeQuery();
			
			if(rst.next())
			{
				try {
					mystr1 = rst.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/LR/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/LR/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/LR/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/LR/"+stringValue;
			}
			
			im.setLr_no(stringValue);
		
		}catch(Exception e){}
		
		
		
		
		try {
																																															
			String driver = im.getDriver_name();
			
			String transporter = im.getTransporter_name();
			
			String[] trans = transporter.split("-");      
			
			//String[] dd = driver.split("-");  
			
			
			System.out.println("1111");
			PreparedStatement pst1 = conn.prepareStatement("insert into order_table(order_id,pricing_id,date,src_contact_person,src_contact_no,customer_name,address,mobile_no,dest_contact_person,dest_contact_no,shipstate,shipgstn,shipname,shipadd,ebillno,invoiceno,route,delevery_date,delivery_time,vehicle_type,remark,total,status,username,datetime,total_weight,inquiry_id,transporter_name,vehicle_no,driver_name,driver_mobile,loadname,loadadd,loadstate,loadgstn,load_contact_person,load_contact_no,lr_no,transport_code,driver_code,buyername,buyeradd,buyerstatus,buyergstn,buyer_contact_person,buyer_contact_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			pst1.setString(1, im.getOrder_id());
			
			pst1.setString(2, im.getPricing_id());
			
			pst1.setString(3, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(4, im.getSrc_contact_person());
			
			pst1.setString(5, im.getSrc_contact_no());
			
			pst1.setString(6, im.getName());
			
			pst1.setString(7, im.getAddress());
			
			pst1.setString(8, im.getContact_no());
			
			pst1.setString(9, im.getDest_contact_person());
			
			pst1.setString(10, im.getDest_contact_no());
			
			pst1.setString(11, im.getShipstate());
			
			pst1.setString(12, im.getShipgstn());
			
			pst1.setString(13, im.getShipname());
			
			pst1.setString(14, im.getShipadd());
			
			pst1.setString(15, im.getEbillno());
			
			pst1.setString(16, im.getInvoiceno());
			
			pst1.setString(17, im.getRoute());
			
			pst1.setString(18, im.getDelevery_date());
			
			pst1.setString(19, im.getDelivery_time());
			
			pst1.setString(20, im.getVehicle_type());
			
			pst1.setString(21, im.getRemark());
			
			pst1.setString(22, im.getTotal());
			
			pst1.setString(23, "0");
			
			pst1.setString(24, bean.getUsername());
			
			pst1.setString(25,SystemDateTime.CurrentDateTime());
			
			pst1.setString(26, im.getTotal1());	
			
			pst1.setString(27, im.getInquiry_id());	
			
			pst1.setString(28, trans[0]);	
			
			pst1.setString(29, im.getVehicle_no());	
			
			pst1.setString(30,driver);	
			
			pst1.setString(31, im.getDriver_mobile());	
			
			pst1.setString(32, im.getLoadname());
			
			
			pst1.setString(33, im.getLoadadd());	
			
			pst1.setString(34, im.getLoadstate());	
			
			pst1.setString(35, im.getLoadgstn());	
			
			pst1.setString(36, im.getLoad_contact_person());	
			
			pst1.setString(37, im.getLoad_contact_no());	
			
			pst1.setString(38, im.getLr_no());	
			
			pst1.setString(39, trans[1]);	
			
			pst1.setString(40, "");	
			
			pst1.setString(41, im.getBuyername());	
			
			pst1.setString(42, im.getBuyeradd());	
			
			pst1.setString(43, im.getBuyerstatus());	
			
			pst1.setString(44, im.getBuyergstn());	
			
			pst1.setString(45, im.getBuyer_contact_person());	
			
			pst1.setString(46, im.getBuyer_contact_no());	
			System.out.println(pst1);
			
			pst1.executeUpdate();
			//System.out.println("0000000000000---------------"+pst1);
			
					
			
			
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set vehical_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			
			
			response="success";
			
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
		
		
		
		/*///////////////// Order Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into order_details(order_id,pricing_id,source,destination,weight,rate,amount,username,datetime,vehicle_type) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getOrder_id());
						pst22.setString(2,im.getPricing_id());
						pst22.setString(3, im.getAa()[l]);
						pst22.setString(4, im.getBb()[l]);
						pst22.setString(5, im.getCc()[l]);
						pst22.setString(6, im.getDd()[l]);
						pst22.setString(7, im.getEe()[l]);
						
						pst22.setString(8, bean.getUsername());
						pst22.setString(9, SystemDateTime.CurrentDateTime());
						
						pst22.setString(10, im.getFf()[l]);
						
						k = pst22.executeUpdate();
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}*/
			
			
			
			
			////////////////////////// Update Pricing Table ////////////////////////
			
			try {
			
				String q1 = "update pricing set status='3' where pricing_id='"+im.getPricing_id()+"'";
			
			
				PreparedStatement ps = conn.prepareStatement(q1);	
			
				System.out.println("SQL:"+ps);

				ps.executeUpdate();
			
				response="success";
			
		
			} catch (Exception e) {
		
				System.out.println(e.getMessage());
			}
	
			
			
			
			
			///////////// Update Inquiry Status Report ///////////
			
			
			try {
	
	
				String q1 = "update inquiry_status set order_username='"+bean.getUsername()+"',order_datetime='"+SystemDateTime.CurrentDateTime()+"' where inquiry_id='"+im.getInquiry_id()+"'";
	

				PreparedStatement ps = conn.prepareStatement(q1);	
	
				//System.out.println("SQL:"+ps);
		
				ps.executeUpdate();
		
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
				System.out.println(e.getMessage());
			}
			
			
			
			
			////////////////// Driver Message /////////////
			
			Properties systemPropery = null;
			systemPropery = new Properties();
			
			String mobile=im.getDriver_mobile()+",8805854900,8329596526,8788963179,7499083359";
			

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
						+ mobile
						+ "&text=Dear "+im.getDriver_name()+", Vehicle No:"+im.getVehicle_no()+" Your Route is:  "+im.getRoute()+" ";

				

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
			
			
			
			
			//////////////// Shipment Messege//////////////
			
			
			
			String mobile1=im.getDest_contact_no()+",8805854900,8329596526,8788963179,7499083359";
			
			
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
						+ "&text=Dear"+im.getShipname()+", Your Assign Driver Name is "+im.getDriver_name()+", Vehicle No:"+im.getVehicle_no()+" Driver Contact:  "+im.getDriver_mobile()+" ";

				

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






	public List<InquiryBean> fetchOrderReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_table where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setTotal1(rs.getString("total_weight"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setOrder_id(rs.getString("order_id"));
				
				
				bean1.setSrc_contact_person(rs.getString("src_contact_person"));
				
				bean1.setSrc_contact_no(rs.getString("src_contact_no"));
				
				bean1.setRoute(rs.getString("route"));
				
				bean1.setVehicle_type(rs.getString("vehicle_type"));
				
				
					
				bean1.setTransporter_name(rs.getString("transporter_name"));
				
				bean1.setVehicle_no(rs.getString("vehicle_no"));
				
				bean1.setDriver_name(rs.getString("driver_name"));
				
				bean1.setDriver_mobile(rs.getString("driver_mobile"));
				
				bean1.setLoadname(rs.getString("loadname"));
				
				bean1.setLoadadd(rs.getString("loadadd"));
				
				bean1.setLoadstate(rs.getString("loadstate"));
				
				bean1.setLoadgstn(rs.getString("loadgstn"));
				
				bean1.setLoad_contact_person(rs.getString("load_contact_person"));
				
				bean1.setLoad_contact_no(rs.getString("load_contact_no"));
				
				bean1.setLr_no(rs.getString("lr_no"));
				
				bean1.setTransport_code(rs.getString("transport_code"));
				
				bean1.setDriver_code(rs.getString("driver_code"));
				
				bean1.setVendor(rs.getString("transporter_name")+"-"+rs.getString("transport_code"));
				
				//bean1.setRemark(rs.getString("remark"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from inquiry where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setSource(rs1.getString("source"));
					bean1.setDestination(rs1.getString("destination"));
				
				
				}
				
				
				
				/*PreparedStatement pst11 = conn.prepareStatement("select * from pricing where pricing_id='"+rs.getString("pricing_id")+"'");
				
				ResultSet rs11 = pst11.executeQuery();
				
				if(rs11.next())
				{
					
					bean1.setVendor(rs11.getString("vendor_name")+"-"+rs11.getString("vendor_id"));
				
				
					
					PreparedStatement pst111 = conn.prepareStatement("select * from transporter_master where transporter_no='"+rs11.getString("vendor_id")+"'");
					
					ResultSet rs111 = pst111.executeQuery();
					
					if(rs111.next())
					{
					   
						bean1.setAddress(rs111.getString("transporter_address"));
					
					}
					
				}*/
					
				list.add(bean1);
				
	
			}
			
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	}



	public String orderCancel(InquiryBean im, userinfo bean, String order_id) {
		
		
		try {
			
			
			Connection conn=connection.getConnection();
			
			String q1 = "update order_table set status='cancel' where order_id='"+order_id+"'";
			
		
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






	public InquiryBean orderEdit(InquiryBean im, userinfo bean, String order_id) {
		
		InquiryBean bean1 =new InquiryBean();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_table where order_id='"+order_id+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				
					bean1.setOrder_id(rs.getString("order_id"));
				
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setSrc_contact_person(rs.getString("src_contact_person"));
				
				bean1.setSrc_contact_no(rs.getString("src_contact_no"));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setAddress(rs.getString("address"));
				
				bean1.setContact_no(rs.getString("mobile_no"));
				
				bean1.setDest_contact_person(rs.getString("dest_contact_person"));
				
				bean1.setDest_contact_no(rs.getString("dest_contact_no"));
				
				bean1.setShipstate(rs.getString("shipstate"));
				
				bean1.setShipgstn(rs.getString("shipgstn"));
				
				bean1.setShipadd(rs.getString("shipadd"));
				
				bean1.setShipname(rs.getString("shipname"));
				
				
				bean1.setEbillno(rs.getString("ebillno"));
				
				bean1.setInvoiceno(rs.getString("invoiceno"));
				
				bean1.setRoute(rs.getString("route"));
				
				bean1.setDelevery_date(rs.getString("delevery_date"));
				
				bean1.setDelivery_time(rs.getString("delivery_time"));
				
				bean1.setVehicle_type(rs.getString("vehicle_type"));
				
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setTotal1(rs.getString("total_weight"));
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				
				bean1.setTransporter_name(rs.getString("transporter_name"));
				
				bean1.setVehicle_no(rs.getString("vehicle_no"));
				
				bean1.setDriver_name(rs.getString("driver_name"));
				
				bean1.setDriver_mobile(rs.getString("driver_mobile"));
				
				bean1.setLoadname(rs.getString("loadname"));
				
				bean1.setLoadadd(rs.getString("loadadd"));
				
				bean1.setLoadstate(rs.getString("loadstate"));
				
				bean1.setLoadgstn(rs.getString("loadgstn"));
				
				bean1.setLoad_contact_person(rs.getString("load_contact_person"));
				
				bean1.setLoad_contact_no(rs.getString("load_contact_no"));
				
				

				bean1.setBuyername(rs.getString("buyername"));
				
				bean1.setBuyeradd(rs.getString("buyeradd"));
				
				bean1.setBuyerstatus(rs.getString("buyerstatus"));
				
				bean1.setBuyergstn(rs.getString("buyergstn"));
				
				bean1.setBuyer_contact_person(rs.getString("buyer_contact_person"));
				
				bean1.setBuyer_contact_no(rs.getString("buyer_contact_no"));
				
				

				
				
				
				bean1.setLr_no(rs.getString("lr_no"));
				
				bean1.setTransport_code(rs.getString("transport_code"));
				
				bean1.setDriver_code(rs.getString("driver_code"));
				
				
				
			
				
				
				/*PreparedStatement pst1 = conn.prepareStatement("select * from order_details where order_id='"+order_id+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				while(rs1.next())
				{
					InquiryBean bean1 = new InquiryBean();
					
					
					
					bean1.setPricing_id(rs.getString("pricing_id"));
					
					bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
					
					bean1.setSrc_contact_person(rs.getString("src_contact_person"));
					
					bean1.setSrc_contact_no(rs.getString("src_contact_no"));
					
					bean1.setName(rs.getString("customer_name"));
					
					bean1.setAddress(rs.getString("address"));
					
					bean1.setContact_no(rs.getString("mobile_no"));
					
					bean1.setDest_contact_person(rs.getString("dest_contact_person"));
					
					bean1.setDest_contact_no(rs.getString("dest_contact_no"));
					
					bean1.setShipstate(rs.getString("shipstate"));
					
					bean1.setShipgstn(rs.getString("shipgstn"));
					
					bean1.setShipadd(rs.getString("shipadd"));
					
					bean1.setShipname(rs.getString("shipname"));
					
					
					bean1.setEbillno(rs.getString("ebillno"));
					
					bean1.setInvoiceno(rs.getString("invoiceno"));
					
					bean1.setRoute(rs.getString("route"));
					
					bean1.setDelevery_date(rs.getString("delevery_date"));
					
					bean1.setDelivery_time(rs.getString("delivery_time"));
					
					bean1.setVehicle_type(rs.getString("vehicle_type"));
					
					bean1.setRemark(rs.getString("remark"));
					
					bean1.setTotal(rs.getString("total"));
					
					bean1.setTotal1(rs.getString("total_weight"));
					
					
					bean1.setInquiry_id(rs.getString("inquiry_id"));
					
					
					
					bean1.setFf1(rs1.getString("vehicle_type"));
					bean1.setAa1(rs1.getString("source"));
					bean1.setBb1(rs1.getString("destination"));
					bean1.setCc1(rs1.getString("weight"));
					bean1.setDd1(rs1.getString("rate"));
					bean1.setEe1(rs1.getString("amount"));
				
				
					list.add(bean1);
					
				}*/
				
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return bean1;
		
	
	
	
	
	}

	public List<InquiryBean> Quotation_View_Print_griddeta(InquiryBean im, userinfo bean,String qtno) {
		
		
		List<InquiryBean> report1 = new ArrayList<InquiryBean>();
	
		try {
		
			Connection conn=connection.getConnection();

			PreparedStatement pst1 = conn.prepareStatement("select * from pricing_details where pricing_id='"+qtno+"' ");
		
			System.out.println("SQL:"+pst1);
				
			ResultSet rs=pst1.executeQuery();
				
				int sn=0;
				
				while(rs.next())
		
				{
					InquiryBean bean1 = new InquiryBean();
				
					//System.out.println(">>>>>>11111>");
		
		
					bean1.setAa1(rs.getString("vehicle_type")); 
				
					/*bean1.setBb1(rs.getString("size_of_vehicle")); 
				
					bean1.setCc1(rs.getString("weight"));
					bean1.setDd1((rs.getString("price")));
				*/	bean1.setEe1(rs.getString("source"));
					bean1.setFf1(rs.getString("destination"));
				
					
				
					sn++;
					
					bean1.setSn(sn);
				
				
				
					report1.add(bean1);
	
	
				}
			
		} catch (Exception e) {
		// TODO: handle exception
		}		
	
		DBConnection.closeConnection();
	
		return report1;
	
}


	
	
	public InquiryBean vehicleChange(InquiryBean im, userinfo bean, String order_id) {
		
		InquiryBean bean1 =new InquiryBean();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_table where order_id='"+order_id+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				
				bean1.setOrder_id(rs.getString("order_id"));
				
				
				
				bean1.setTransporter_name(rs.getString("transporter_name"));
				
				bean1.setVehicle_no(rs.getString("vehicle_no"));
				
				bean1.setDriver_name(rs.getString("driver_name"));
				
				bean1.setDriver_mobile(rs.getString("driver_mobile"));
				
					
				bean1.setLr_no(rs.getString("lr_no"));
				
				bean1.setTransport_code(rs.getString("transport_code"));
				
				bean1.setDriver_code(rs.getString("driver_code"));
			
				
			
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return bean1;
		
	
	
	
	
	}
	
	



	public String orderUpdate(InquiryBean im, userinfo bean) {
		
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
			
		
		try {
			
			
			String driver = im.getDriver_name();
			
			String transporter = im.getTransporter_name();
			
			String[] trans = transporter.split("-");      
			
			//String[] dd = driver.split("-"); 
			
			PreparedStatement pst1 = conn.prepareStatement("update order_table set date=?,src_contact_person=?,src_contact_no=?,customer_name=?,address=?,mobile_no=?,dest_contact_person=?,dest_contact_no=?,shipstate=?,shipgstn=?,shipname=?,shipadd=?,ebillno=?,invoiceno=?,route=?,delevery_date=?,delivery_time=?,vehicle_type=?,remark=?,total=?,username=?,datetime=?,total_weight=?,transporter_name=?,vehicle_no=?,driver_name=?,driver_mobile=?,loadname=?,loadadd=?,loadstate=?,loadgstn=?,load_contact_person=?,load_contact_no=?,lr_no=?"
					+ ",transport_code=?,driver_code=?,buyername=?,buyeradd=?,buyerstatus=?,buyergstn=?,buyer_contact_person=?,buyer_contact_no=? where order_id='"+im.getOrder_id()+"'");
			
			
					
			pst1.setString(1, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(2, im.getSrc_contact_person());
			
			pst1.setString(3, im.getSrc_contact_no());
			
			pst1.setString(4, im.getName());
			
			pst1.setString(5, im.getAddress());
			
			pst1.setString(6, im.getContact_no());
			
			pst1.setString(7, im.getDest_contact_person());
			
			pst1.setString(8, im.getDest_contact_no());
			
			pst1.setString(9, im.getShipstate());
			
			pst1.setString(10, im.getShipgstn());
			
			pst1.setString(11, im.getShipname());
			
			pst1.setString(12, im.getShipadd());
			
			pst1.setString(13, im.getEbillno());
			
			pst1.setString(14, im.getInvoiceno());
			
			pst1.setString(15, im.getRoute());
			
			pst1.setString(16, im.getDelevery_date());
			
			pst1.setString(17, im.getDelivery_time());
			
			pst1.setString(18, im.getVehicle_type());
			
			pst1.setString(19, im.getRemark());
			
			pst1.setString(20, im.getTotal());
			
			
			pst1.setString(21, bean.getUsername());
			
			pst1.setString(22,SystemDateTime.CurrentDateTime());
			
			pst1.setString(23, im.getTotal1());	
			
			
			pst1.setString(24, trans[0]);	
			
			pst1.setString(25, im.getVehicle_no());	
			
			pst1.setString(26,driver);	
			
			pst1.setString(27, im.getDriver_mobile());	
			
			pst1.setString(28, im.getLoadname());	
			
			pst1.setString(29, im.getLoadadd());	
			
			pst1.setString(30, im.getLoadstate());	
			
			pst1.setString(31, im.getLoadgstn());	
			
			pst1.setString(32, im.getLoad_contact_person());	
			
			pst1.setString(33, im.getLoad_contact_no());	
			
			pst1.setString(34, im.getLr_no());	
			
			pst1.setString(35, trans[1]);	
			
			pst1.setString(36,"");
			
			pst1.setString(37, im.getBuyername());	
			pst1.setString(38, im.getBuyeradd());	
			pst1.setString(39, im.getBuyerstatus());	
			pst1.setString(40, im.getBuyergstn());	
			pst1.setString(41, im.getBuyer_contact_person());	
			pst1.setString(42, im.getBuyer_contact_no());	
			
			
			System.out.println("SQL::"+pst1);
			
			pst1.executeUpdate();
			
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		/*/////////////// Delete///////////////////////
		
	try{
		
		PreparedStatement pst121 = conn.prepareStatement("delete from order_details  where order_id='"
				+ im.getOrder_id() + "' ");


		System.out.println("Delete::"+pst121);
		
		int i1 = pst121.executeUpdate();

		response="success";

   
		}catch(Exception e){
			
			
			System.out.println(e.getMessage());
		}
		
		
		
		
		///////////////// Order Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into order_details(order_id,pricing_id,source,destination,weight,rate,amount,username,datetime,vehicle_type) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getOrder_id());
						pst22.setString(2,im.getPricing_id());
						pst22.setString(3, im.getAa()[l]);
						pst22.setString(4, im.getBb()[l]);
						pst22.setString(5, im.getCc()[l]);
						pst22.setString(6, im.getDd()[l]);
						pst22.setString(7, im.getEe()[l]);
						
						pst22.setString(8, bean.getUsername());
						pst22.setString(9, SystemDateTime.CurrentDateTime());
						
						pst22.setString(10, im.getFf()[l]);
						
						System.out.println("SQL>>>"+pst22);
						
						k = pst22.executeUpdate();
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}*/
		DBConnection.closeConnection();
			
			return response;
	
	
	
	}



	
	
	
	
	public String vehicleChangeSuccess(InquiryBean im, userinfo bean) {
		
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
			
		
		try {
			
			
			String driver = im.getDriver_name();
			
			String transporter = im.getTransporter_name();
			
			String[] trans = transporter.split("-");      
			
			String[] dd = driver.split("-"); 
			
			PreparedStatement pst1 = conn.prepareStatement("update order_table set transporter_name=?,vehicle_no=?,driver_name=?,driver_mobile=?,transport_code=?,driver_code=? where order_id='"+im.getOrder_id()+"' and lr_no='"+im.getLr_no()+"'");
			
			
			
			pst1.setString(1, trans[0]);	
			
			pst1.setString(2, im.getVehicle_no());	
			
			pst1.setString(3,dd[0]);	
			
			pst1.setString(4, im.getDriver_mobile());	
			
				
			pst1.setString(5, trans[1]);	
			
			pst1.setString(6, dd[1]);
			
			
			System.out.println("SQL::"+pst1);
			
			pst1.executeUpdate();
			
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		DBConnection.closeConnection();
			
			return response;
	
	
	
	}



	public List<InquiryBean> fetchPriceCheckReport(InquiryBean im, userinfo bean, String source, String dest) {
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing_check where source='"+source+"' and destination='"+dest+"'");
			
			System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				bean1.setName(rs.getString("vendor_name"));
				
				
				bean1.setSource(rs.getString("source"));
				
				bean1.setDestination(rs.getString("destination"));
				
				bean1.setRemark(rs.getString("price"));
				
				bean1.setType(rs.getString("vehicle_type"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				
				PreparedStatement pst111 = conn.prepareStatement("select * from transporter_master where transporter_no='"+rs.getString("vendor_id")+"'");
				
				ResultSet rs111 = pst111.executeQuery();
				
				if(rs111.next())
				{
				   
					bean1.setMobile(rs111.getString("mobile"));
				
				}
		
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}
	
public List<InquiryBean> fetchPriceCheckReport123(InquiryBean im, userinfo bean, String source, String dest) {
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing_form where source='"+source+"' and destination='"+dest+"'");
			
			System.out.println("SQL:"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				bean1.setName(rs.getString("vendor_name"));
				
				
				bean1.setSource(rs.getString("source"));
				
				bean1.setDestination(rs.getString("destination"));
				
				bean1.setRemark(rs.getString("price"));
				
				bean1.setType(rs.getString("vehicle_type"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				
				PreparedStatement pst111 = conn.prepareStatement("select * from transporter_master where transporter_no='"+rs.getString("vendor_id")+"'");
				
				ResultSet rs111 = pst111.executeQuery();
				
				if(rs111.next())
				{
				   
					bean1.setMobile(rs111.getString("mobile"));
				
				}
		
				list.add(bean1);
				
	
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
			System.out.println(e.getMessage());
			
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}
	
	
	
	
	public List<InquiryBean> fetchPricingDetails(InquiryBean im, userinfo bean, String p_id) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from pricing_details where pricing_id='"+p_id+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setFf1(rs.getString("vehicle_type"));
				
				bean1.setAa1(rs.getString("source"));
				
				bean1.setBb1(rs.getString("destination"));
					
				bean1.setDd1(rs.getString("price"));
				
				list.add(bean1);
				
	
			}
			
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	}






	/*public List<InquiryBean> orderLR(InquiryBean im, userinfo bean, String order_id) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_details where order_id='"+order_id+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setDd1(rs.getString("vehicle_type"));
				
				bean1.setEe1(rs.getString("source"));
				
				bean1.setFf1(rs.getString("destination"));
					
				bean1.setGg1(rs.getString("weight"));
				bean1.setHh1(rs.getString("rate"));
				bean1.setIi1(rs.getString("amount"));
				
				list.add(bean1);
				
	
			}
			
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	}*/
	
	
	
	
	
	public List<InquiryBean> deliveryAlertReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_table where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				bean1.setDate(rs.getString("delevery_date"));
				
				bean1.setDelivery_time(rs.getString("delivery_time"));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setTotal1(rs.getString("total_weight"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				bean1.setOrder_id(rs.getString("order_id"));
				
				
				bean1.setSrc_contact_person(rs.getString("src_contact_person"));
				
				bean1.setSrc_contact_no(rs.getString("src_contact_no"));
				
				bean1.setRoute(rs.getString("route"));
				
				bean1.setVehicle_type(rs.getString("vehicle_type"));
				
				//bean1.setRemark(rs.getString("remark"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from inquiry where inquiry_id='"+rs.getString("inquiry_id")+"'");
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setSource(rs1.getString("source"));
					bean1.setDestination(rs1.getString("destination"));
				
				
				}
				
				
				
				PreparedStatement pst11 = conn.prepareStatement("select * from pricing where pricing_id='"+rs.getString("pricing_id")+"'");
				
				ResultSet rs11 = pst11.executeQuery();
				
				if(rs11.next())
				{
					
					bean1.setVendor(rs11.getString("vendor_name"));
				
				
					
					PreparedStatement pst111 = conn.prepareStatement("select * from transporter_master where transporter_no='"+rs11.getString("vendor_id")+"'");
					
					ResultSet rs111 = pst111.executeQuery();
					
					if(rs111.next())
					{
					   
						bean1.setMobile(rs111.getString("mobile"));
					
					}
					
				}
				
				
				
				
					
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			
				Date datee = new Date();
						
				String dateBeforeString = df.format(datee);
				String dateAfterString = CoreData.getDateFormatAsDb(rs.getString("delevery_date"));
					
				//Parsing the date
				LocalDate dateBefore = LocalDate.parse(dateBeforeString);
				LocalDate dateAfter = LocalDate.parse(dateAfterString);
					
				//calculating number of days in between
				long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
					
				//displaying the number of days
				System.out.println(noOfDaysBetween);
				
				
				
				if(noOfDaysBetween<=1)
				{
					list.add(bean1);
				}
	
			} 
			
				
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	}
	
	
	
	
	
	public String insert_alert(InquiryBean im, userinfo bean) {
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		try {
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(alert_id,-4)) as myval1 from alert_table");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "HSL/AL/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "HSL/AL/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "HSL/AL/"+"0"+stringValue;
			}
			else
			{
				stringValue = "HSL/AL/"+stringValue;
			}
			
			im.setInquiry_id(stringValue);
			
			
			
			
			
			PreparedStatement pst1 = conn.prepareStatement("insert into alert_table(alert_id,date,name,contactp,contact_no,type,exp_date,remark,username,datetime,status) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1, im.getInquiry_id());
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getName());
			
			pst1.setString(4, im.getContactp());
			
			pst1.setString(5, im.getContact_no());
			
			pst1.setString(6, im.getType());
			
			pst1.setString(7, CoreData.getDateFormatAsDb(im.getExp_date()));
			
			pst1.setString(8, im.getRemark());
			
			pst1.setString(9, bean.getUsername());
			
			pst1.setString(10,SystemDateTime.CurrentDateTime());
			
			pst1.setString(11,"0");
			
				
			//System.out.println(pst1);
			
			pst1.executeUpdate();
			
			
			
			
				
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		
		
		DBConnection.closeConnection();
		
		return response;
	}
	
	
	
	
	
	
	public String insert_company(InquiryBean im, userinfo bean) {
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		try {
			
			
			
			PreparedStatement pst1 = conn.prepareStatement("insert into company_contact(company_name,contact_person,contact_number,department,username,datetime) values(?,?,?,?,?,?)");
			
			
				
			pst1.setString(1, im.getName());
			
			pst1.setString(2, im.getContactp());
			
			pst1.setString(3, im.getContact_no());
			
			pst1.setString(4, im.getRemark());
			
			pst1.setString(5, bean.getUsername());
			
			pst1.setString(6,SystemDateTime.CurrentDateTime());
			
				
			pst1.executeUpdate();
			
			
			
			
				
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		
		
		DBConnection.closeConnection();
		
		return response;
	}
	
	
	
	
	public List<InquiryBean> alertReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from alert_table where status='0'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				bean1.setId(rs.getString("id"));
				
				bean1.setInquiry_id(rs.getString("alert_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setName(rs.getString("name"));
				
				bean1.setContact_no(rs.getString("contact_no"));
				
				bean1.setContactp(rs.getString("contactp"));
				
					
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setType(rs.getString("type"));
				
				bean1.setExp_date(CoreData.getDateFormatAsUser(rs.getString("exp_date")));
		
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}
	
	
	
	
	
	public List<InquiryBean> companyReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from company_contact");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				bean1.setId(rs.getString("id"));
				
				
				bean1.setName(rs.getString("company_name"));
				
				bean1.setContact_no(rs.getString("contact_number"));
				
				bean1.setContactp(rs.getString("contact_person"));
				
					
				bean1.setRemark(rs.getString("department"));
				
			
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}
	
	
	

	public List<InquiryBean> alertDoneReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from alert_table where status='1'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				
				InquiryBean bean1 = new InquiryBean();
				
				bean1.setId(rs.getString("id"));
				
				bean1.setInquiry_id(rs.getString("alert_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setName(rs.getString("name"));
				
				bean1.setContact_no(rs.getString("contact_no"));
				
				bean1.setContactp(rs.getString("contactp"));
				
					
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setType(rs.getString("type"));
				
				bean1.setExp_date(CoreData.getDateFormatAsUser(rs.getString("exp_date")));
		
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	
	
	}






	public List<InquiryBean> alertEdit(InquiryBean im, userinfo bean, String id) {
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from alert_table where id='"+id+"'");
			
			System.out.println("SQL:"+pst);
			
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				bean1.setId(rs.getString("id"));
				
				bean1.setInquiry_id(rs.getString("alert_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setName(rs.getString("name"));
				
				bean1.setContact_no(rs.getString("contact_no"));
				
				bean1.setContactp(rs.getString("contactp"));
				
					
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setType(rs.getString("type"));
				
				bean1.setExp_date(CoreData.getDateFormatAsUser(rs.getString("exp_date")));
		
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	}

	
	
	
	
	public List<InquiryBean> companyEdit(InquiryBean im, userinfo bean, String id) {
		
		List<InquiryBean> list = new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from company_contact where id='"+id+"'");
			
			System.out.println("SQL:"+pst);
			
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				InquiryBean bean1 = new InquiryBean();
				
				bean1.setId(rs.getString("id"));
				
					
				bean1.setName(rs.getString("company_name"));
				
				bean1.setContact_no(rs.getString("contact_number"));
				
				bean1.setContactp(rs.getString("contact_person"));
				
					
				bean1.setRemark(rs.getString("department"));
				
			
				list.add(bean1);
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return list;
	
	}

	
	
	public String alertUpdate(InquiryBean im, userinfo bean, String id) throws Exception {

		try {
				
			Connection conn=connection.getConnection();
		
			PreparedStatement ps = conn.prepareStatement("update alert_table set date=?,name=?,contactp=?,contact_no=?,type=?,exp_date=?,remark=?,username=?,datetime=? where id='"+id+"'");
			
			
			
			ps.setString(1, CoreData.getDateFormatAsDb(im.getDate()));
			
			ps.setString(2, im.getName());
			
			ps.setString(3, im.getContactp());
			
			ps.setString(4, im.getContact_no());
			
			ps.setString(5, im.getType());
			
			ps.setString(6, CoreData.getDateFormatAsDb(im.getExp_date()));
			
			ps.setString(7, im.getRemark());
			
			ps.setString(8, bean.getUsername());
			
			ps.setString(9,SystemDateTime.CurrentDateTime());
			
			
			System.out.println("SQL:"+ps);

			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBConnection.closeConnection();
		
		return "success";
	}
	
	
	
	
	
	public String companyUpdate(InquiryBean im, userinfo bean, String id) throws Exception {

		try {
				
			Connection conn=connection.getConnection();
		
			PreparedStatement ps = conn.prepareStatement("update company_contact set company_name=?,contact_person=?,contact_number=?,department=?,username=?,datetime=? where id='"+id+"'");
			
			
				
			ps.setString(1, im.getName());
			
			ps.setString(2, im.getContactp());
			
			ps.setString(3, im.getContact_no());
				
			ps.setString(4, im.getRemark());
			
			ps.setString(5, bean.getUsername());
			
			ps.setString(6,SystemDateTime.CurrentDateTime());
			
			
			System.out.println("SQL:"+ps);

			ps.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBConnection.closeConnection();
		
		return "success";
	}




	public String alertDone(InquiryBean im, userinfo bean, String id) {

		try {
			
			
			Connection conn=connection.getConnection();
			
			String q1 = "update alert_table set status='1' where id='"+id+"'";
			
		
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
	
	
	
	
	public String companyDelete(InquiryBean im, userinfo bean, String id) {

		try {
			
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst121 = conn.prepareStatement("delete from company_contact  where id='"+id+"' ");


			//System.out.println("Delete::"+pst121);
			
			int i1 = pst121.executeUpdate();

			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		DBConnection.closeConnection();
		
		return "success";
	}
	
	
	
	public List<InquiryBean> alertExpectedReport(InquiryBean im, userinfo bean) {
		
		
		List<InquiryBean> list = new ArrayList<>();
		
		int days = 0;
	
		Connection conn=connection.getConnection();
	
		try {
	
	
		
			PreparedStatement pst = conn.prepareStatement("select * from alert_table where status='0'");
			ResultSet rs = pst.executeQuery();
		
			while(rs.next())
			{
			
				InquiryBean bean1 = new InquiryBean();
			
				bean1.setId(rs.getString("id"));
			
				bean1.setInquiry_id(rs.getString("alert_id"));
			
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
			
				bean1.setName(rs.getString("name"));
			
				bean1.setContact_no(rs.getString("contact_no"));
			
				bean1.setContactp(rs.getString("contactp"));
			
				
				bean1.setRemark(rs.getString("remark"));
			
				bean1.setType(rs.getString("type"));
			
				bean1.setExp_date(CoreData.getDateFormatAsUser(rs.getString("exp_date")));
	
				
				
				
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
				
				Date datee = new Date();
						
				String dateBeforeString = df.format(datee);
				String dateAfterString = rs.getString("exp_date");
					
				//Parsing the date
				LocalDate dateBefore = LocalDate.parse(dateBeforeString);
				LocalDate dateAfter = LocalDate.parse(dateAfterString);
					
				//calculating number of days in between
				long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
					
				//displaying the number of days
				System.out.println(noOfDaysBetween);
				
				
				PreparedStatement pst1 = conn.prepareStatement("select no_of_days from no_of_days ");
				ResultSet rs1 = pst1.executeQuery();
			
				if(rs1.next())
				{
						days=rs1.getInt("no_of_days");
				}
				
				
				if(noOfDaysBetween <=days)
				{
					list.add(bean1);
				}
			
			

			}
		
		
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		DBConnection.closeConnection();
	
		return list;
				
				
		
	
	}






	public String insertLocationInfo(String loc) throws SQLException {
		
		
		String response="";
		
		Connection conn=connection.getConnection();
		
		
		PreparedStatement pstx = conn .prepareStatement("select *  from city_master where city_name='"+loc+"'");
		
		System.out.println("dao1"+pstx);
		
		ResultSet resultSet1x=pstx.executeQuery();
		
		if(resultSet1x.next())
		{
			response = "already";
		}
		
		else{
		
		PreparedStatement pst = conn .prepareStatement("insert into city_master(city_name) values(?) ");
		
		
		System.out.println("dao2>>>"+pst);

		pst.setString(1,loc);

	

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
		
		
		DBConnection.closeConnection();

		return response;
	
	
	}






	public String Add_New_Transporter(String name, String mobile) {
		
		String response="";
		
		Connection conn=connection.getConnection();
		
		
		try {
			
			PreparedStatement pstx = conn .prepareStatement("select *  from transporter_master where transporter_name='"+name+"'");
			
			System.out.println("dao1"+pstx);
			
			ResultSet resultSet1x=pstx.executeQuery();
			
			if(resultSet1x.next())
			{
				response = "already";
			}
			
			else{
				
				
				int len2 = 0;
				String stringValue5 = "";
				
				PreparedStatement preparedStatement4 = conn
						.prepareStatement("select  max(SUBSTRING(transporter_no,-4)) as myval1 from transporter_master");
				
				
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
						stringValue5 = "HSL/TSP/" + "000" + stringValue5;
					} else if (stringValue5.length() == 2) {
						stringValue5 = "HSL/TSP/" + "00" + stringValue5;
					} else if (stringValue5.length() == 3) {
						stringValue5 = "HSL/TSP/" + "0" + stringValue5;
					} else {
						stringValue5 = "HSL/TSP/" + stringValue5;
					}
					
					
				
				
			
			PreparedStatement pst = conn .prepareStatement("insert into transporter_master(transporter_name,transporter_no,mobile) values(?,?,?) ");
			
			
		

			pst.setString(1,name);
			
			pst.setString(2,stringValue5);

			pst.setString(3,mobile);
			System.out.println("dao2>>>"+pst);
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
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(">>"+response);
		
		
		DBConnection.closeConnection();

		return response;
	
	
	}






	public InquiryBean orderLr(InquiryBean im, userinfo bean, String order_id, String lr_no) {
		
		
		InquiryBean bean1 =new InquiryBean();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pst = conn.prepareStatement("select * from order_table where order_id='"+order_id+"' and lr_no='"+lr_no+"'");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				
				
				bean1.setOrder_id(order_id);
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				bean1.setPricing_id(rs.getString("pricing_id"));
				
				
				try {

				PreparedStatement pste = conn.prepareStatement("select * from quotation where pricing_id='"+rs.getString("pricing_id")+"' and inquiry_id='"+rs.getString("inquiry_id")+"'");
				ResultSet rse = pste.executeQuery();
				
				if(rse.next())
				{
					
					PreparedStatement pstee = conn.prepareStatement("select * from quotation_details where quotation_no='"+rse.getString("quotation_no")+"'");
					ResultSet rsee = pstee.executeQuery();
					
					if(rsee.next())
					{
					
					
					
					bean1.setResource_from(rsee.getString("weight"));
					
					bean1.setRno(rsee.getString("rate"));
					
					}
				}
				
				}
				catch(Exception er)
				{
					System.out.println(er.getMessage());
				}
				
				
				
				bean1.setLr_no(lr_no);
				
				bean1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				
				bean1.setSrc_contact_person(rs.getString("src_contact_person"));
				
				bean1.setSrc_contact_no(rs.getString("src_contact_no"));
				
				bean1.setName(rs.getString("customer_name"));
				
				bean1.setAddress(rs.getString("address"));
				
				bean1.setContact_no(rs.getString("mobile_no"));
				
				bean1.setDest_contact_person(rs.getString("dest_contact_person"));
				
				bean1.setDest_contact_no(rs.getString("dest_contact_no"));
				
				bean1.setShipstate(rs.getString("shipstate"));
				
				bean1.setShipgstn(rs.getString("shipgstn"));
				
				bean1.setShipadd(rs.getString("shipadd"));
				
				bean1.setShipname(rs.getString("shipname"));
				
				
				bean1.setEbillno(rs.getString("ebillno"));
				
				bean1.setInvoiceno(rs.getString("invoiceno"));
				
				bean1.setRoute(rs.getString("route"));
				
				bean1.setDelevery_date(rs.getString("delevery_date"));
				
				bean1.setDelivery_time(rs.getString("delivery_time"));
				
				bean1.setVehicle_type(rs.getString("vehicle_type"));
				
				bean1.setRemark(rs.getString("remark"));
				
				bean1.setTotal(rs.getString("total"));
				
				bean1.setTotal1(rs.getString("total_weight"));
				
				
				bean1.setInquiry_id(rs.getString("inquiry_id"));
				
				
				bean1.setTransporter_name(rs.getString("transporter_name"));
				
				bean1.setVehicle_no(rs.getString("vehicle_no"));
				
				bean1.setDriver_name(rs.getString("driver_name"));
				
				bean1.setDriver_mobile(rs.getString("driver_mobile"));
				
				bean1.setLoadname(rs.getString("loadname"));
				
				bean1.setLoadadd(rs.getString("loadadd"));
				
				bean1.setLoadstate(rs.getString("loadstate"));
				
				bean1.setLoadgstn(rs.getString("loadgstn"));
				
				bean1.setLoad_contact_person(rs.getString("load_contact_person"));
				
				bean1.setLoad_contact_no(rs.getString("load_contact_no"));
				
				
				
				bean1.setBuyername(rs.getString("buyername"));
				
				bean1.setBuyeradd(rs.getString("buyeradd"));
				
				bean1.setBuyerstatus(rs.getString("buyerstatus"));
				
				bean1.setBuyergstn(rs.getString("buyergstn"));
				
				bean1.setBuyer_contact_person(rs.getString("buyer_contact_person"));
				
				bean1.setBuyer_contact_no(rs.getString("buyer_contact_no"));
				
				
				
				
				bean1.setLr_no(rs.getString("lr_no"));
				
				bean1.setTransport_code(rs.getString("transport_code"));
				
				bean1.setDriver_code(rs.getString("driver_code"));
				
				
				PreparedStatement pst1 = conn.prepareStatement("select * from inquiry where inquiry_id='"+rs.getString("inquiry_id")+"' ");
				
				ResultSet rs1 = pst1.executeQuery();
				
				if(rs1.next())
				{
					
					bean1.setSource(rs1.getString("source"));
					bean1.setDestination(rs1.getString("destination"));
				}
				
			
				
				
				

			}
			
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		
		return bean1;
	
	
	}






	public InquiryBean FetchSchemeDetails(String autoinvoice) {
		
		Connection conn=connection.getConnection();
		
		InquiryBean ib = new InquiryBean();
		
		int sparesize = 0;
		
		
		List<String> schemeid = new ArrayList<String>();
		List<String> schemename = new ArrayList<String>();
		List<String> city = new ArrayList<String>();
					
		try {
			
			int sno = 1;

		
			PreparedStatement pst = conn
					.prepareStatement("select * from lr_chit_chat  where lr_no='" + autoinvoice + "'");

			System.out.println("SQL::"+pst);
			
			ResultSet rs = pst.executeQuery();
			
			int as=0;
			while (rs.next()) {

				if(as==0)
				{
					schemeid.add(" background-color: #BCF36C;text-align: right;");
					as=1;
				}
				else
				{
					schemeid.add(" background-color: #6CF3D6;text-align: left;");
					as=0;
				}
				//schemeid.add(rs.getString("lr_no"));
				
				schemename.add((rs.getString("datetime")));
				
				city.add(rs.getString("status"));
				
				
				
				
			
				sparesize++;
			}

			

		} catch (Exception e) {

		}
		ib.setSparesize(sparesize);
		ib.setSchemeid1(schemeid);
		ib.setSchemename1(schemename);
		ib.setCity1(city);
		
		DBConnection.closeConnection();
	
		return ib;
		
		
	}






	public InquiryBean assignCommonInvoice(InquiryBean im, String lr,String invoice ,userinfo bin) throws SQLException {
		
		Connection conn=connection.getConnection();
		
		InquiryBean  bean1 = new InquiryBean();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		
		List<String> bank22=new ArrayList<String>();
		List<String> account22=new ArrayList<String>();
		
		List<String> ifsc22=new ArrayList<String>();
		List<String> branch22=new ArrayList<String>();
		List<String> totalamt=new ArrayList<String>();
		
		
		// TODO Auto-generated method stub

		
				List<String> lrno=new ArrayList<String>();
				List<String> drivername=new ArrayList<String>();
				List<String> expdate=new ArrayList<String>();
				List<String> exppart=new ArrayList<String>();
				List<String> expamt=new ArrayList<String>();
				List<String> vehicleno=new ArrayList<String>();
				List<String> remark=new ArrayList<String>();

				List<String> givenby=new ArrayList<String>();
				List<String> sno=new ArrayList<String>();
		
		
		int gridsize=0;
		String order=lr;
		int gridsize1=0;
		String detail[]=order.split("~");
		
		
		//System.out.println("Length:"+detail.length);
		
		for(int i=0;i<detail.length;i++){
		
			
		PreparedStatement preparedStatement112 = conn
				.prepareStatement("select * from delivery_done1 where LR_no=?");
		
		preparedStatement112.setString(1, detail[i]);
		
		System.out.println("SQL:"+preparedStatement112);
		
		ResultSet resultSet12 = preparedStatement112.executeQuery();
		
		while (resultSet12.next()) {
			
			//bean1.setName(resultSet12.getString("Customer_name"));
			bean1.setCustomer_no(resultSet12.getString("customer_no"));
			
			bean1.setInquiry_id(resultSet12.getString("inquiry_id"));
			bean1.setDate(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
			bean1.setDate(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
					
			bean1.setInvoiceno(invoice);
			
			PreparedStatement ps = conn
					.prepareStatement("select * from customer_master_details where customer_no='"+resultSet12.getString("Customer_no")+"'");
			System.out.println("SQL:"+ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				bean1.setName(rs.getString("customer_name"));
				bean1.setAddress(rs.getString("customer_address"));
				bean1.setMobile(rs.getString("mobile_no"));
				bean1.setGstn(rs.getString("customer_gst_no"));
			}
			PreparedStatement psss = conn
					.prepareStatement("select * from lr where LR_no='"+detail[i]+"'");
			System.out.println("SQL:"+psss);
			
			ResultSet rsss = psss.executeQuery();
			
			if (rsss.next()) {
				bean1.setBill_to(rsss.getString("bill_to_custname"));
			}
				dcno.add(detail[i]);

			description1.add(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
			
			quantity.add(resultSet12.getString("loadname"));
			
			myrate.add(resultSet12.getString("shipname"));
			
			hsncode.add(resultSet12.getString("source"));
			
			rate.add(resultSet12.getString("destination"));
			
			bank22.add(resultSet12.getString("advance"));
			
			totalamt.add(resultSet12.getString("total_amount"));
			gridsize++;
		}
		
		
		

		

		
		
		
		
			
		PreparedStatement preparedStatement112x = conn
				.prepareStatement("select * from issue_expenses where LR_no=?");
		
		preparedStatement112x.setString(1, detail[i]);
		
		//System.out.println("SQL:"+preparedStatement112);
		
		ResultSet resultSet12x = preparedStatement112x.executeQuery();
		
		while (resultSet12x.next()) {
			
		
				lrno.add(detail[i]);

			expdate.add(CoreData.getDateFormatAsUser(resultSet12x.getString("date")));
			
			drivername.add(resultSet12x.getString("driver_name"));
			
			exppart.add(resultSet12x.getString("exp_parti"));
			
			expamt.add(resultSet12x.getString("exp_amount"));
			
			vehicleno.add(resultSet12x.getString("vehicle_no"));
			
			givenby.add(resultSet12x.getString("given_by"));
			
			remark.add(resultSet12x.getString("remark"));
			gridsize1++;
		
		
	}
		
		}
		
	bean1.setLrno(lrno);
	bean1.setDrivername(drivername);
	bean1.setExpdate(expdate);
	bean1.setExppart1(exppart);

	bean1.setExpamt(expamt);
	bean1.setVehicleno(vehicleno);
	bean1.setRemark1(remark);
	bean1.setSparesize(gridsize1);


	bean1.setGivenby(givenby);

		
		
		
	
	bean1.setDcnot(dcno);
	bean1.setDescriptiont(description1);
	bean1.setGridsize(gridsize);
	bean1.setQuantityt(quantity);
	
	bean1.setHsncode(hsncode);
	bean1.setRate(rate);
	bean1.setMyrate(myrate);
	
	
	
	bean1.setBank22(bank22);
	
	bean1.setTotalamt(totalamt);
	
	DBConnection.closeConnection();
	
	return bean1;
	
	}
	
	
	
	public String getnvnumber(userinfo bean) throws SQLException {
		// TODO Auto-generated method stub

		Connection conn=connection.getConnection();

		int result = -1;
		
		Date date = new Date();
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			result = cal.get(Calendar.MONTH) + 1;
		}
		int result1 = -1;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			result1 = cal.get(Calendar.YEAR);
		}
		String year = "";
		String yy = "";
		String yy1 = "";
		yy = "" + result1;

		yy1 = yy.substring(2, 4);

		int pp = 0;
		pp = Integer.parseInt(yy1);

		if (result <= 3) {
			year = "" + (result1 - 1);
		} else {

			year = "" + result1;

		}
		String Fyear = "";
		if (result <= 3) {
			Fyear = (result1 - 1) + "-" + pp;
		} else {

			Fyear = result1 + "-" + (pp + 1);

		}

		String FMONTH = "" + result;

		//String Fyear = bean.getYearlogin();
		
		//System.out.println("Year:"+Fyear);
		
		String pref = "HSL";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		
		// String pref="INV";
		PreparedStatement preparedStatement11 = conn.prepareStatement(
				"select SUBSTRING(invoice_no,5,5)) as myval1 from invoice  ");
		
		//preparedStatement11.setString(1, "" + "%" + Fyear + "%");

		System.out.println("SQL:"+preparedStatement11);
		
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
			System.out.println("MyVAL:"+myval1);
			
			} catch (Exception e) {

				myval1 = 1;
				mystr1 = "";
				
				//System.out.println("MyVAL In Catch:"+myval1);
			}
		}

		if (mystr1.equals("")) {
			stringValue1 = pref + "HSL//0000" +stringValue1+"/"+Fyear;

		} else {

			if (String.valueOf(myval1).length() == 1) {
				stringValue1 = pref + "HSL//0000" + String.valueOf(myval1)+"/"+Fyear;

			} else if (String.valueOf(myval1).length() == 2) {
				stringValue1 =  pref + "HSL//000" + String.valueOf(myval1)+"/"+Fyear;
			} else if (String.valueOf(myval1).length() == 3) {
				stringValue1 = pref + "HSL//00" + String.valueOf(myval1)+"/"+Fyear;
			} else if (String.valueOf(myval1).length() == 4) {
				stringValue1 = pref + "HSL//0" + String.valueOf(myval1)+"/"+Fyear;
			} else {
				stringValue1 = pref + "/" +String.valueOf(myval1)+"/"+Fyear;
			}
		}
		
		System.out.println("NO:"+stringValue1);

		DBConnection.closeConnection();
		
		return stringValue1;
	}


	
	
	
	public String commonInvoiceSubmit(InquiryBean im, userinfo bean,double exp) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		String code="";	
		
		
		
			
		PreparedStatement psw = conn
				.prepareStatement("select * from invoice where invoice_no='"+ im.getInvoiceno()+"'");
		
		
		System.out.println("SQL:"+psw);
		
		ResultSet rsw = psw.executeQuery();
		
		if (rsw.next()) {
		
		
			response="already";
			
		}	
		else {
		
			double totalamt=Double.parseDouble(im.getTotal12())+exp;
			totalamt=Math.round(totalamt*100.0)/100.0;
			
			String totala=String.valueOf(totalamt);
			
			System.err.println("sssssdddd----"+exp);
			System.err.println("sssss----"+totala);
		
		try {
			
			
			
			PreparedStatement ps = conn
					.prepareStatement("select customer_no from delivery_done1 where LR_no='"+im.getAa()[0]+"'");
			
			
			System.out.println("SQL:"+ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
			
				code=rs.getString("customer_no");
				
			}
																																															
				
			
			PreparedStatement pst1 = conn.prepareStatement("insert into invoice(vehicle_no,date,invoice_no,total,job_card_no,invtype,remaining_amount,username,datetime,pono,dcno,name,to_add,lr_amount,termconnd,contactp,contactpno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1,code);
			
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getInvoiceno());
			
			pst1.setString(4, totala);
			
			pst1.setString(5, im.getGstn());
			
			pst1.setString(6, "WithoutTax");
			
			pst1.setString(7, totala);
			
			pst1.setString(8, bean.getUsername());
			
			pst1.setString(9,SystemDateTime.CurrentDateTime());
			
			
			pst1.setString(10, im.getJob_no());
			
			pst1.setString(11, im.getSource());
			
			pst1.setString(12, im.getName());
			
			pst1.setString(13, im.getDestination());
			
			pst1.setString(14, im.getLr_amount());
			pst1.setString(15, im.getPayterm());
			pst1.setString(16, im.getBuyer_contact_person());
			pst1.setString(17, im.getBuyer_contact_no());
			
			
			System.out.println(pst1);
			
			pst1.executeUpdate();
			
			
			try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set invoice_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}
			
			
			
			
PreparedStatement pst123 = conn.prepareStatement("insert into diley_cashreport(Documentsno,Date,Customercode,Amount,username,datetime,Name,emp_id,cash_source,form_source,type) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			pst123.setString(1,code);
			
			pst123.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst123.setString(3, im.getInvoiceno());
			
			pst123.setString(4, totala);
			
			pst123.setString(5, bean.getUsername());
			
			pst123.setString(6,SystemDateTime.CurrentDateTime());
		
			pst123.setString(7, im.getName());
			
			pst123.setString(8, im.getCustomer_no());
			
			pst123.setString(9, " ");
			
			pst123.setString(10, "Customer Invoice");
			pst123.setString(11, "Debit");
			System.out.println(pst123);
			
			pst123.executeUpdate();
			System.out.println("fjdnvgfgg---------------------------"+pst123);
			
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		/////////////////  Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into invoice_tax_details(invoice_no,lr_no,lr_date,consignor,consignee,source,destination,weight,amount,manual_lr) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getInvoiceno());
						pst22.setString(2,im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, im.getEe()[l]);
						pst22.setString(7, im.getFf()[l]);
						pst22.setString(8, im.getGg()[l]);
						/*pst22.setString(9, im.getHh()[l]);*/
						pst22.setString(9,im.getIi()[l]);
						pst22.setString(10,im.getHh()[l]);
						
						
							
						k = pst22.executeUpdate();
						System.out.println("SQL:"+pst22);
						
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			
			
			
			
			try {
				String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst9 = conn.prepareStatement(query11);
				
				pst9.setString(1, code);
				pst9.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
				pst9.setString(3, im.getInvoiceno());
				pst9.setString(4, "Invoice");
				pst9.setString(5, "101");
				pst9.setString(6, "Debit");
				pst9.setString(7, totala);
				pst9.setString(8, im.getName());

				pst9.setString(9, "");
				pst9.setString(10, bean.getUsername());
				pst9.setString(11, SystemDateTime.CurrentDateTime());

				//System.out.println("SQL:" + pst9);
				int k = pst9.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
			
			
			//////////////// Invoice Done Update////////////// 	
			
			try {
				
			
				for (int l = 0; l < im.getAa().length; l++) {
					
					String query1="update delivery_done1 set status='1' where LR_no='"+im.getAa()[l]+"' ";
					
					
					PreparedStatement pst11=conn.prepareStatement(query1);
		
					System.out.println("SQL"+pst11);
					
					pst11.executeUpdate();
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		}
			
			
			DBConnection.closeConnection();
			
			return response;
	}
	
	
	
	
public String commonInvoicePISubmit(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		String code="";	
			
		PreparedStatement psw = conn
				.prepareStatement("select * from pi_invoice where invoice_no='"+ im.getInvoiceno()+"'");
		
		
		System.out.println("SQL:"+psw);
		
		ResultSet rsw = psw.executeQuery();
		
		if (rsw.next()) {
		
		
			response="already";
			
		}	
		else {
		
		
		try {
			
			
			
			
			
			PreparedStatement ps = conn
					.prepareStatement("select customer_no from PI_done1 where LR_no='"+im.getAa()[0]+"'");
			
			
			System.out.println("SQL:"+ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
			
				code=rs.getString("customer_no");
				
			}
																																															
				
			
			PreparedStatement pst1 = conn.prepareStatement("insert into pi_invoice(vehicle_no,date,invoice_no,total,job_card_no,invtype,remaining_amount,username,datetime,pono,dcno,name,to_add,lr_amount) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			
			
			pst1.setString(1,code);
			
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst1.setString(3, im.getInvoiceno());
			
			pst1.setString(4, im.getTotal12());
			
			pst1.setString(5, im.getGstn());
			
			pst1.setString(6, "WithoutTax");
			
			pst1.setString(7, im.getTotal12());
			
			pst1.setString(8, bean.getUsername());
			
			pst1.setString(9,SystemDateTime.CurrentDateTime());
			
			
			pst1.setString(10, im.getJob_no());
			
			pst1.setString(11, im.getSource());
			
			pst1.setString(12, im.getName());
			
			pst1.setString(13, im.getDestination());
			
			pst1.setString(14, im.getLr_amount());
			
			
			System.out.println(pst1);
			
			pst1.executeUpdate();
			
			
			/*try {
				PreparedStatement pst12 = conn.prepareStatement("update escalation_table set invoice_date=? where enq_id=?");
				
				pst12.setString(2, im.getInquiry_id());
				pst12.setString(1,SystemDateTime.CurrentDateTime());

				pst12.executeUpdate();
				
				}
				catch(Exception e)
				{
					System.out.println(">>>>>>>>>>>>>"+e.getMessage());
				}*/
			
			
			
			
/*PreparedStatement pst123 = conn.prepareStatement("insert into diley_cashreport(Documentsno,Date,Customercode,Amount,username,datetime,Name,emp_id,cash_source,form_source,type) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			pst123.setString(1,code);
			
			pst123.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			pst123.setString(3, im.getInvoiceno());
			
			pst123.setString(4, im.getTotal12());
			
			pst123.setString(5, bean.getUsername());
			
			pst123.setString(6,SystemDateTime.CurrentDateTime());
		
			pst123.setString(7, im.getName());
			
			pst123.setString(8, im.getCustomer_no());
			
			pst123.setString(9, " ");
			
			pst123.setString(10, "Customer Invoice");
			pst123.setString(11, "Debit");
			System.out.println(pst123);
			
			pst123.executeUpdate();
			System.out.println("fjdnvgfgg---------------------------"+pst123);
			*/
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		/////////////////  Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into PI_invoice_tax_details(invoice_no,lr_no,lr_date,consignor,consignee,source,destination,weight,amount,manual_lr) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getInvoiceno());
						pst22.setString(2,im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, im.getEe()[l]);
						pst22.setString(7, im.getFf()[l]);
						pst22.setString(8, im.getGg()[l]);
						/*pst22.setString(9, im.getHh()[l]);*/
						pst22.setString(9,im.getIi()[l]);
						pst22.setString(10,im.getHh()[l]);
						
						
							
						k = pst22.executeUpdate();
						System.out.println("SQL:"+pst22);
						
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			
			
			
			
			/*try {
				String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst9 = conn.prepareStatement(query11);
				
				pst9.setString(1, code);
				pst9.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
				pst9.setString(3, im.getInvoiceno());
				pst9.setString(4, "Invoice");
				pst9.setString(5, "101");
				pst9.setString(6, "Debit");
				pst9.setString(7, im.getTotal12());
				pst9.setString(8, im.getName());

				pst9.setString(9, "");
				pst9.setString(10, bean.getUsername());
				pst9.setString(11, SystemDateTime.CurrentDateTime());

				//System.out.println("SQL:" + pst9);
				int k = pst9.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			*/
			
			
			
			
			
			
			
			//////////////// Invoice Done Update////////////// 	
			
			try {
				
			
				for (int l = 0; l < im.getAa().length; l++) {
					
					String query1="update pi_done1 set status='1' where LR_no='"+im.getAa()[l]+"' ";
					
					
					PreparedStatement pst11=conn.prepareStatement(query1);
		
					System.out.println("SQL"+pst11);
					
					pst11.executeUpdate();
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
		}
			
			
			DBConnection.closeConnection();
			
			return response;
	}
	
	
	
	
	
	
	
	
public List<TripModel> commonInvoiceSubmit123(InquiryBean im, userinfo bean) throws Exception {
		
	List<TripModel> list = new ArrayList<>();
	
		Connection conn=connection.getConnection();
		
		
		try {
			
			String ssk=im.getAa()[0];
			
			
			PreparedStatement pss = conn
					.prepareStatement("select * from invoice where invoice_no='"+im.getInvoiceno()+"'");
			
			
			System.out.println("SQL:"+pss);
			
			ResultSet rs= pss.executeQuery();
		
			if (rs.next()) {
				

				PreparedStatement psss = conn
						.prepareStatement("select * from customer_master_details where customer_no='"+rs.getString("vehicle_no")+"'");
				
				
				System.out.println("SQL:"+psss);
				
				ResultSet rss= psss.executeQuery();
			
				if (rss.next()) {
					
					

					TripModel tripModel1=new TripModel();
					
					
					tripModel1.setCustomer_name(rss.getString("customer_name"));
					tripModel1.setBuyer_contact_no(rs.getString("contactpno"));
					tripModel1.setBuyer_contact_person(rs.getString("contactp"));
					tripModel1.setCustomer_code(rss.getString("company_name"));
					tripModel1.setCustomer_addr(rss.getString("customer_address"));
					tripModel1.setGstin1(rss.getString("customer_gst_no"));
					tripModel1.setPath2(rss.getString("pan_no"));
					tripModel1.setState1(rss.getString("state"));
					tripModel1.setMobile(rss.getString("mobile_no"));
					try {
					tripModel1.setLoad_contact_person(rs.getString("load_contact_person"));
					
					tripModel1.setLoad_contact_no(rs.getString("load_contact_no"));
					}catch(Exception e) {}
					
					
					list.add(tripModel1);
					
				
				
				
				}
			}
				
				/*tripModel1.setLoadname(rs.getString("loadname"));
				
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
				
				*/
				
			
			
																																																
		}
		catch(Exception ex)
		{
			System.out.println("12313---"+ex);
		}
			DBConnection.closeConnection();
			
			return list;
	}
	
		
	







public List<TripModel> commonInvoiceSubmit123123(InquiryBean im, userinfo bean) throws Exception {
	
	List<TripModel> list = new ArrayList<>();
	
		Connection conn=connection.getConnection();
		
		
		try {
			
			
			for(int i=0;i<im.getAa().length;i++)
			{
			
			
			PreparedStatement pss = conn
					.prepareStatement("select * from issue_expenses where LR_no='"+im.getAa()[i].trim()+"'");
			
			
			System.out.println("SQL:"+pss);
			
			ResultSet rs= pss.executeQuery();
			
			int kks=0;
			
			while (rs.next()) {
				
				
				TripModel tripModel1=new TripModel();
				
				tripModel1.setExp_parti(rs.getString("exp_parti"));
				
				tripModel1.setExp_amount(rs.getString("exp_amount"));
				
				kks=Integer.parseInt(rs.getString("exp_amount"));
				
				tripModel1.setRemark1(rs.getString("remark"));
				tripModel1.setVoucher_no(rs.getString("voucher_no"));
				tripModel1.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
				tripModel1.setTotalamount(kks);
				
				list.add(tripModel1);
				
			}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("12313---"+ex);
		}
			DBConnection.closeConnection();
			
			return list;
	}
	
		




public double commonInvoiceSubmit12312322(InquiryBean im, userinfo bean) throws Exception {
	
		Connection conn=connection.getConnection();
		double kks=0;
		
		try {
			
			for(int i=0;i<im.getAa().length;i++)
			{
			
			
			PreparedStatement pss = conn
					.prepareStatement("select * from issue_expenses where LR_no='"+im.getAa()[i].trim()+"'");
			
			
			System.out.println("SQL:"+pss);
			
			ResultSet rs= pss.executeQuery();
			
			
			
			while (rs.next()) {
					kks=kks+Double.parseDouble(rs.getString("exp_amount"));
					}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("12313---"+ex);
		}
			DBConnection.closeConnection();
			
			return kks;
	}
	
		
	


	
public String commonInvoicelrno(InquiryBean im, userinfo bean) throws Exception {
	
	Connection conn=connection.getConnection();
	double kks=0;
	String ssk="";
	
	try {
		
		
		
			
		PreparedStatement pss = conn
				.prepareStatement("select * from invoice where invoice_no='"+im.getInvoiceno()+"'");
		ResultSet rs= pss.executeQuery();
		if(rs.next()) {
			ssk=rs.getString("lr_amount")+"~"+rs.getString("total");
				}
		
	}
	catch(Exception ex)
	{
		System.out.println("12313---"+ex);
	}
		DBConnection.closeConnection();
		
		return ssk;
}

public String pi_commonInvoicelrno(InquiryBean im, userinfo bean) throws Exception {
	
	Connection conn=connection.getConnection();
	double kks=0;
	String ssk="";
	
	try {
		
		
		
			
		PreparedStatement pss = conn
				.prepareStatement("select * from pi_invoice where invoice_no='"+im.getInvoiceno()+"'");
		ResultSet rs= pss.executeQuery();
		if(rs.next()) {
			ssk=rs.getString("lr_amount")+"~"+rs.getString("total");
				}
		
	}
	catch(Exception ex)
	{
		System.out.println("12313---"+ex);
	}
		DBConnection.closeConnection();
		
		return ssk;
}



	public String commonInvoiceUpdate(InquiryBean im, userinfo bean,double exp) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		String code="";	

		double totalamt=Double.parseDouble(im.getTotal12())+exp;
		totalamt=Math.round(totalamt*100.0)/100.0;
		
		String totala=String.valueOf(totalamt);
		
		System.err.println("sssssdddd----"+exp);
		System.err.println("sssss----"+totala);
	
		
		try {
			
			
			
			PreparedStatement ps = conn
					.prepareStatement("select * from customer_master_details where customer_name='"+im.getName()+"'");
			
			
			System.out.println("SQL:"+ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
			
				code=rs.getString("customer_no");
				
			}
																																															
				
			
			
			
			
			//PreparedStatement pst1 = conn.prepareStatement("insert into invoice(vehicle_no,date,invoice_no,total,job_card_no,invtype,remaining_amount,username,datetime,pono,dcno,name,to_add) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			PreparedStatement pst1 = conn.prepareStatement("update invoice set vehicle_no=?,date=?,total=?,job_card_no=?,remaining_amount=?,username=?,datetime=?,pono=?,dcno=?,name=?,to_add=?,lr_amount=? where invoice_no='"+im.getInvoiceno()+"'");
			
			pst1.setString(1,code);
			
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			
			pst1.setString(3, totala);
			System.out.println("1111111----"+im.getTotal12());
			
			pst1.setString(4, im.getGstn());
				
			pst1.setString(5, totala);
			
			pst1.setString(6, bean.getUsername());
			
			pst1.setString(7,SystemDateTime.CurrentDateTime());
			
			
			pst1.setString(8, im.getJob_no());
			
			pst1.setString(9, im.getSource());
			
			pst1.setString(10, im.getName());
			
			pst1.setString(11, im.getDestination());
			pst1.setString(12, im.getLr_amount());
			
			
			System.out.println("SQL>>"+pst1);
			
			pst1.executeUpdate();
			
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		/////////////// Delete///////////////////////
		
		try{
		
			PreparedStatement pst121 = conn.prepareStatement("delete from invoice_tax_details  where invoice_no='"
					+ im.getInvoiceno() + "' ");


			System.out.println("Delete::"+pst121);
		
			int i1 = pst121.executeUpdate();

			response="success";

   
			}catch(Exception e){
			
			
				System.out.println(e.getMessage());
			}
		
		
		
		
		
			
		
		
		/////////////////  Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into invoice_tax_details(invoice_no,lr_no,lr_date,consignor,consignee,source,destination,weight,amount,manual_lr) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getInvoiceno());
						pst22.setString(2,im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, im.getEe()[l]);
						pst22.setString(7, im.getFf()[l]);
						pst22.setString(8, im.getGg()[l]);
						/*pst22.setString(9, im.getHh()[l]);*/
						pst22.setString(9, im.getIi()[l]);
						pst22.setString(10, im.getHh()[l]);
						
						System.out.println("SQL:"+pst22);
						
							
						k = pst22.executeUpdate();
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
			
			
			
			
			try {
				String query = "UPDATE   customercreditdebit  set Amount=?,Customercode='"+code+"' where Documentsno=? ";

			
				PreparedStatement	pst9 = conn.prepareStatement(query);
				pst9.setString(1, totala);
				pst9.setString(2, im.getInvoiceno());

				
				System.out.println("Update:"+pst9);
				
				int k = pst9.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
				
			
			DBConnection.closeConnection();
			
			return response;
	}
	
	
	
	
	
	
	
	
	
public String pi_commonInvoiceUpdate(InquiryBean im, userinfo bean) throws Exception {
		
		
		Connection conn=connection.getConnection();
		
		String response = "";
		
		
		String code="";	
		
		
		try {
			
			
			PreparedStatement ps = conn
					.prepareStatement("select * from customer_master_details where customer_name='"+im.getName()+"'");
			
			
			System.out.println("SQL:"+ps);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
			
				code=rs.getString("customer_no");
				
			}
																																															
				
			
			
			
			
			//PreparedStatement pst1 = conn.prepareStatement("insert into invoice(vehicle_no,date,invoice_no,total,job_card_no,invtype,remaining_amount,username,datetime,pono,dcno,name,to_add) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			PreparedStatement pst1 = conn.prepareStatement("update pi_invoice set vehicle_no=?,date=?,total=?,job_card_no=?,remaining_amount=?,username=?,datetime=?,pono=?,dcno=?,name=?,to_add=?,lr_amount=? where invoice_no='"+im.getInvoiceno()+"'");
			
			pst1.setString(1,code);
			
			
			pst1.setString(2, CoreData.getDateFormatAsDb(im.getDate()));
			
			
			pst1.setString(3, im.getTotal12());
			System.out.println("1111111----"+im.getTotal12());
			
			pst1.setString(4, im.getGstn());
				
			pst1.setString(5, im.getTotal12());
			
			pst1.setString(6, bean.getUsername());
			
			pst1.setString(7,SystemDateTime.CurrentDateTime());
			
			
			pst1.setString(8, im.getJob_no());
			
			pst1.setString(9, im.getSource());
			
			pst1.setString(10, im.getName());
			
			pst1.setString(11, im.getDestination());
			pst1.setString(12, im.getLr_amount());
			
			
			System.out.println("SQL>>"+pst1);
			
			pst1.executeUpdate();
			
					
			response="success";
			
		
		}catch(Exception e) {
			
		}
		
		
		
		
		/////////////// Delete///////////////////////
		
		try{
		
			PreparedStatement pst121 = conn.prepareStatement("delete from PI_invoice_tax_details  where invoice_no='"
					+ im.getInvoiceno() + "' ");


			System.out.println("Delete::"+pst121);
		
			int i1 = pst121.executeUpdate();

			response="success";

   
			}catch(Exception e){
			
			
				System.out.println(e.getMessage());
			}
		
		
		
		
		
			
		
		
		/////////////////  Details Entry//////////////
		
			
			try {
				
				int k = 0;
				PreparedStatement pst22 = conn.prepareStatement(
						"insert into PI_invoice_tax_details(invoice_no,lr_no,lr_date,consignor,consignee,source,destination,weight,amount,manual_lr) values(?,?,?,?,?,?,?,?,?,?)");

				for (int l = 0; l < im.getAa().length; l++) {

					if ( im.getAa()[l] != "") {
						
						
						
						pst22.setString(1,im.getInvoiceno());
						pst22.setString(2,im.getAa()[l]);
						pst22.setString(3, im.getBb()[l]);
						pst22.setString(4, im.getCc()[l]);
						pst22.setString(5, im.getDd()[l]);
						pst22.setString(6, im.getEe()[l]);
						pst22.setString(7, im.getFf()[l]);
						pst22.setString(8, im.getGg()[l]);
						/*pst22.setString(9, im.getHh()[l]);*/
						pst22.setString(9, im.getIi()[l]);
						pst22.setString(10, im.getHh()[l]);
						
						System.out.println("SQL:"+pst22);
						
							
						k = pst22.executeUpdate();
						
						response="success";
					}
				}
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
			}
			
			
			
			
			
			/*try {
				String query = "UPDATE   customercreditdebit  set Amount=?,Customercode='"+code+"' where Documentsno=? ";

			
				PreparedStatement	pst9 = conn.prepareStatement(query);
				pst9.setString(1, im.getTotal12());
				pst9.setString(2, im.getInvoiceno());

				
				System.out.println("Update:"+pst9);
				
				int k = pst9.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			
				
			
			DBConnection.closeConnection();
			
			return response;
	}
	
	
	
	
	
	
	
	
	
	
	
public String manualsmssend_order(InquiryBean im, userinfo bean) throws Exception {
		
	
	
	String sskl=im.getOrder_id();
	
	
	String dname="";
	String sname="";
	String vno="";
	String root="";
	
	Connection conn=connection.getConnection();
	try {
	PreparedStatement ps = conn
				.prepareStatement("select * from order_table where order_id='"+im.getOrder_id()+"'");
		
		
		System.out.println("SQL:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
		
		
			dname=rs.getString("driver_name");
			sname=rs.getString("transporter_name");
			vno=rs.getString("vehicle_no");
			root=rs.getString("route");
			
		}
}catch(Exception e)
	{
	System.out.println(e.getMessage());
	}
		
		
	
			Properties systemPropery = null;
			systemPropery = new Properties();
			
			String mobile=im.getContact_no();
			

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
						+ mobile
						+ "&text=Dear "+dname+", Vehicle No:"+vno+" Your Route is:  "+root+" "
						+ " &priority=ndnd&stype=normal";
				

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
			
			
			
			
			//////////////// Shipment Messege//////////////
			
			
			/*
			String mobile1=im.getDest_contact_no()+",8805854900,8329596526,8788963179,7499083359";
			
			
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
						+ "&text=Dear"+im.getShipname()+", Your Assign Driver Name is "+im.getDriver_name()+", Vehicle No:"+im.getVehicle_no()+" Driver Contact:  "+im.getDriver_mobile()+" ";

				

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


	
	
	
public InquiryBean assignPIInvoice(InquiryBean im, String lr,String invoice ,userinfo bin) throws SQLException {
	
	Connection conn=connection.getConnection();
	
	InquiryBean  bean1 = new InquiryBean();
	
	List<String> description1=new ArrayList<String>();
	List<String> dcno=new ArrayList<String>();
	List<String> quantity=new ArrayList<String>();
	List<String> hsncode=new ArrayList<String>();
	List<String> rate=new ArrayList<String>();
	List<String> myrate=new ArrayList<String>();
	
	List<String> bank22=new ArrayList<String>();
	List<String> account22=new ArrayList<String>();
	
	List<String> ifsc22=new ArrayList<String>();
	List<String> branch22=new ArrayList<String>();
	List<String> totalamt=new ArrayList<String>();
	
	int gridsize=0;
	String order=lr;
	
	String detail[]=order.split("~");
	
	
	//System.out.println("Length:"+detail.length);
	
	for(int i=0;i<detail.length;i++){
	
		
	PreparedStatement preparedStatement112 = conn
			.prepareStatement("select * from PI_done1 where LR_no=?");
	
	preparedStatement112.setString(1, detail[i]);
	
	System.out.println("SQL:"+preparedStatement112);
	
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	while (resultSet12.next()) {
		
		//bean1.setName(resultSet12.getString("Customer_name"));
		bean1.setCustomer_no(resultSet12.getString("customer_no"));
		
		bean1.setInquiry_id(resultSet12.getString("inquiry_id"));
		bean1.setDate(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
		bean1.setDate(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
				
		bean1.setInvoiceno(invoice);
		
		PreparedStatement ps = conn
				.prepareStatement("select * from customer_master_details where customer_no='"+resultSet12.getString("Customer_no")+"'");
		System.out.println("SQL:"+ps);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			bean1.setName(rs.getString("customer_name"));
			bean1.setAddress(rs.getString("customer_address"));
			bean1.setMobile(rs.getString("mobile_no"));
			bean1.setGstn(rs.getString("customer_gst_no"));
		}
		PreparedStatement psss = conn
				.prepareStatement("select * from lr where LR_no='"+detail[i]+"'");
		System.out.println("SQL:"+psss);
		
		ResultSet rsss = psss.executeQuery();
		
		if (rsss.next()) {
			bean1.setBill_to(rsss.getString("bill_to_custname"));
		}
			dcno.add(detail[i]);

		description1.add(CoreData.getDateFormatAsUser(resultSet12.getString("date")));
		
		quantity.add(resultSet12.getString("loadname"));
		
		myrate.add(resultSet12.getString("shipname"));
		
		hsncode.add(resultSet12.getString("source"));
		
		rate.add(resultSet12.getString("destination"));
		
		bank22.add(resultSet12.getString("advance"));
		
		totalamt.add(resultSet12.getString("total_amount"));
		gridsize++;
	}
	
}
bean1.setDcnot(dcno);
bean1.setDescriptiont(description1);
bean1.setGridsize(gridsize);
bean1.setQuantityt(quantity);

bean1.setHsncode(hsncode);
bean1.setRate(rate);
bean1.setMyrate(myrate);



bean1.setBank22(bank22);

bean1.setTotalamt(totalamt);

DBConnection.closeConnection();

return bean1;

}






public String Add_New_Rate(InquiryBean im, userinfo bean) throws SQLException {
	// TODO Auto-generated method stub
String resp="";
	
	Connection conn=connection.getConnection();
	
	int result = -1;
	
	Date date = new Date();
	if (date != null) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		result = cal.get(Calendar.MONTH) + 1;
	}
	int result1 = -1;
	if (date != null) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		result1 = cal.get(Calendar.YEAR);
	}
	String year = "";
	String yy = "";
	String yy1 = "";
	yy = "" + result1;

	yy1 = yy.substring(2, 4);

	int pp = 0;
	pp = Integer.parseInt(yy1);

	if (result <= 3) {
		year = "" + (result1 - 1);
	} else {

		year = "" + result1;

	}
	String Fyear = "";
	if (result <= 3) {
		Fyear = (result1 - 1) + "-" + pp;
	} else {

		Fyear = result1 + "-" + (pp + 1);

	}

	String FMONTH = "" + result;

	//String Fyear = bean.getYearlogin();
	
	//System.out.println("Year:"+Fyear);
	
	String pref = "RM";

	PreparedStatement pst9 = null;
	PreparedStatement pst99 = null;

	
	// String pref="INV";
	PreparedStatement preparedStatement11 = conn.prepareStatement(
			"select SUBSTRING(rateid,4,5) as myval1 from rate_master  ");
	
	//preparedStatement11.setString(1, "" + "%" + Fyear + "%");

	System.out.println("SQL:"+preparedStatement11);
	
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
		System.out.println("MyVAL:"+myval1);
		
		} catch (Exception e) {

			myval1 = 1;
			mystr1 = "";
			
			//System.out.println("MyVAL In Catch:"+myval1);
		}
	}

	if (mystr1.equals("")) {
		stringValue1 = pref + "/0000" +stringValue1+"/"+Fyear;

	} else {

		if (String.valueOf(myval1).length() == 1) {
			stringValue1 = pref + "/0000" + String.valueOf(myval1)+"/"+Fyear;

		} else if (String.valueOf(myval1).length() == 2) {
			stringValue1 =  pref + "/000" + String.valueOf(myval1)+"/"+Fyear;
		} else if (String.valueOf(myval1).length() == 3) {
			stringValue1 = pref + "/00" + String.valueOf(myval1)+"/"+Fyear;
		} else if (String.valueOf(myval1).length() == 4) {
			stringValue1 = pref + "/0" + String.valueOf(myval1)+"/"+Fyear;
		} else {
			stringValue1 = pref + "/" +String.valueOf(myval1)+"/"+Fyear;
		}
	}
	
	System.out.println("NO:"+stringValue1);
	
	String custname="";
	String custid="";
try {
	String parts[]=im.getCustomer_name().split("-");
	custname=parts[0];
	custid=parts[1];
	
}catch(Exception e) {}
	
	
	PreparedStatement preparedStatement112 = conn
			.prepareStatement("select * from rate_master where customer='"+custid+"'");
	

	System.out.println("SQL:"+preparedStatement112);
	
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		resp="already";
	}else {
		try {
			
			int k = 0;
			PreparedStatement pst22 = conn.prepareStatement(
					"insert into rate_master(customer,date,rateid) values(?,?,?)");
			
			pst22.setString(1,custid);
			pst22.setString(2,CoreData.getDateFormatAsDb(im.getDate()));
			pst22.setString(3, stringValue1);
			k = pst22.executeUpdate();
			
			PreparedStatement pst22x = conn.prepareStatement(
					"insert into rate_master_details(type,salerate,purchaserate,rateid) values(?,?,?,?)");
			for (int l = 0; l < im.getTyperate().length; l++) {
				
				
				if ( !im.getTyperate()[l].equals("") && !im.getTyperate()[l].equals("null")) {
					
					
					
					pst22x.setString(1,im.getTyperate()[l]);
					pst22x.setString(2,im.getSalerate()[l]);
					pst22x.setString(3, im.getPurchaserate()[l]);
					
					pst22x.setString(4, stringValue1);
					System.out.println("SQL:"+pst22x);
					
						
					k = pst22x.executeUpdate();
					
				}
			}
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		resp="success";
	}
	
	
	
	
	
	

return resp;


}






public InquiryBean EditRateMaster(InquiryBean im, userinfo bean, String rateid) {
	// TODO Auto-generated method stub

	
	InquiryBean bean11 =new InquiryBean();
	
	Connection conn=connection.getConnection();
	
	try {
	
	
		String type[] = new String[1000];
		String purchaserate[] = new String[1000];
		String salerate[] = new String[1000];
		
		
		PreparedStatement pst = conn.prepareStatement("select * from rate_master where  recno="+rateid+"");
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
		{
			
			
			bean11.setDate(CoreData.getDateFormatAsUser(rs.getString("date")));
			bean11.setId(rs.getString("rateid"));
			PreparedStatement ps = conn
					.prepareStatement("select * from customer_master_details where customer_no='"+rs.getString("customer")+"'");
			System.out.println("SQL:"+ps);
			
			ResultSet rsx = ps.executeQuery();
			
			if (rsx.next()) {
				bean11.setCustomer_name(rsx.getString("customer_name")+"-"+rsx.getString("customer_no"));
			
			}
			
			
			PreparedStatement psx = conn
					.prepareStatement("select * from rate_master_details where rateid='"+rs.getString("rateid")+"'");
			System.out.println("SQL:"+psx);
			
			ResultSet rsxx = psx.executeQuery();
			int i=0;
			while (rsxx.next()) {
				type[i]=rsxx.getString("type");
				purchaserate[i]=rsxx.getString("purchaserate");
				salerate[i]=rsxx.getString("salerate");
				
			i++;
			}
			
			bean11.setGridsize(i);
			bean11.setPurchaserate(purchaserate);
			bean11.setSalerate(salerate);
			bean11.setTyperate(type);
		}
		
		
		
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	DBConnection.closeConnection();
	
	return bean11;
	





}





	
}