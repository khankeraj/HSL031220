package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.master.model.LeadFormModel;
import com.master.model.MeetingFormModel;

public class LeadFormDAO {
	
	public int insert_lead_details(LeadFormModel leadform)
	{
		int i=0;
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		try {
			int status=1;
			
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
			        
			String pref = "LD";

			PreparedStatement pst9 = null;
			PreparedStatement pst99 = null;

			// String pref="INV";
			PreparedStatement preparedStatement11 = connection
					.prepareStatement("select  max(SUBSTRING(lead_no,-4)) as myval1 from lead_deatils  where LENGTH(lead_no)>5 and lead_no  like  ?");
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
				stringValue1 =  "LD/"+Fyear + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 =  "LD/"+Fyear + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = "LD/"+Fyear + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 =  "LD/"+Fyear + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) { 
					stringValue1 =  "LD/"+Fyear + "/0" + String.valueOf(myval1);
				}
				else {
					stringValue1 =  "LD/"+Fyear + "/" + String.valueOf(myval1);
				}
			}

			PreparedStatement pst=connection.prepareStatement("INSERT INTO `lead_deatils`(`lead_no`, `customer_name`, `contact_no`, `product`, `amount`, `city`, `zone`, `area`, `date`, `remark`, `contact_person`, `image`, `resource`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, stringValue1);
			pst.setString(2, leadform.getCustomer_name());
			pst.setString(3, leadform.getContact_no());
			pst.setString(4, leadform.getProduct());
			pst.setString(5, leadform.getAmount());
			pst.setString(6, leadform.getCity());
			pst.setString(7, leadform.getZone());
			pst.setString(8, leadform.getArea());
			pst.setString(9, leadform.getRequiredDate());
			pst.setString(10, leadform.getRemark());
			pst.setString(11, leadform.getContact_person());
			pst.setString(12, leadform.getImage());
			pst.setString(13, leadform.getResource());
			pst.setInt(14, status);
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				/*String lead_no = null;
				
				PreparedStatement pst1=connection.prepareStatement("SELECT MAX(lead_no) FROM lead_deatils");
				ResultSet rs=pst1.executeQuery();
				while(rs.next())
				{
					lead_no=rs.getString(1);
				}*/
				
					PreparedStatement pst11=connection.prepareStatement("INSERT INTO `status_master`(`lead_no`, `lead`, `meeting`) VALUES ('"+stringValue1+"','YES','NO')");
					int j=pst11.executeUpdate();
					if(j>0)
					{
						System.out.println("status Inserted Successfully");
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<LeadFormModel> fetchLeadFormDetails()
	{
	List<LeadFormModel> list=new ArrayList<LeadFormModel>();
		
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("SELECT `lead_no`, `customer_name`, `contact_no`, `product`, `amount`, `city`, `zone`, `area`, `date`, `remark`, `contact_person`, `image`, `resource` FROM `lead_deatils` WHERE status=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LeadFormModel leadForm=new LeadFormModel();
				leadForm.setLead_serial_no(rs.getString(1));
				leadForm.setCustomer_name(rs.getString(2));
				leadForm.setContact_no(rs.getString(3));
				leadForm.setProduct(rs.getString(4));
				leadForm.setAmount(rs.getString(5));
				leadForm.setCity(rs.getString(6));
				leadForm.setZone(rs.getString(7));
				leadForm.setArea(rs.getString(8));
				leadForm.setRequiredDate(rs.getString(9));
				leadForm.setImage(rs.getString(10));
				list.add(leadForm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
	}
	
	public List<LeadFormModel> fetchForUpdateMeeting(LeadFormModel lead, String lead_no) {
		// TODO Auto-generated method stub
		
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		List<LeadFormModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `lead_no`, `customer_name`, `contact_no`,`amount`,`remark` FROM `lead_deatils` WHERE `lead_no`='"+lead_no+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LeadFormModel leadDetails=new LeadFormModel();
				
				leadDetails.setLead_serial_no(rs.getString(1));
				leadDetails.setCustomer_name(rs.getString(2));
				leadDetails.setContact_no(rs.getString(3));
				leadDetails.setAmount(rs.getString(4));
				leadDetails.setRemark(rs.getString(5));
				
				list.add(leadDetails);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<LeadFormModel> fetchForLeadUpdate(String lead_no) {
		// TODO Auto-generated method stub
		List<LeadFormModel> list=new ArrayList<>();
		
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `customer_name`, `contact_no`, `product`, `amount`, `city`, `zone`, `area`, `date`, `remark`, `contact_person`,`resource`,`lead_id` FROM `lead_deatils` WHERE lead_id="+lead_no+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LeadFormModel editLeadForm=new LeadFormModel();
				
				editLeadForm.setCustomer_name(rs.getString(1));
				editLeadForm.setContact_no(rs.getString(2));
				editLeadForm.setProduct(rs.getString(3));
				editLeadForm.setAmount(rs.getString(4));
				editLeadForm.setCity(rs.getString(5));
				editLeadForm.setZone(rs.getString(6));
				editLeadForm.setArea(rs.getString(7));
				editLeadForm.setReqDate(rs.getString(8));
				editLeadForm.setRemark(rs.getString(9));
				editLeadForm.setContact_person(rs.getString(10));
				editLeadForm.setResource(rs.getString(11));
				editLeadForm.setLead_serial_no(lead_no);
				list.add(editLeadForm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int update_lead_details(LeadFormModel leadForm,String lead_no) {
		// TODO Auto-generated method stub
		int i=0;
		
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `lead_deatils` SET `customer_name`=?,`contact_no`=?,`product`=?,`amount`=?,`city`=?,`zone`=?,`area`=?,`date`=?,`remark`=?,`contact_person`=?,`resource`=? WHERE `lead_no`="+lead_no+"");
			pst.setString(1, leadForm.getCustomer_name());
			pst.setString(2, leadForm.getContact_no());
			pst.setString(3, leadForm.getProduct());
			pst.setString(4, leadForm.getAmount());
			pst.setString(5, leadForm.getCity());
			pst.setString(6, leadForm.getZone());
			pst.setString(7, leadForm.getArea());
			pst.setString(8, leadForm.getRequiredDate());
			pst.setString(9, leadForm.getRemark());
			pst.setString(10, leadForm.getContact_person());
			pst.setString(11, leadForm.getResource());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int delete_lead_form(LeadFormModel leadForm, String lead_no) {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lead_deatils` WHERE lead_no="+lead_no+"");
			i=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}

}
