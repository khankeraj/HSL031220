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
import com.master.model.ContractModel;
import com.master.model.LeadFormModel;

public class ContractDAO {
	public int insert_customer_details(ContractModel customer,String lead_no) {
		System.out.println("Address:"+customer.getAddress());
		int status=0;
		try {
			
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			int quotation_id=0;
			
			PreparedStatement pst1=connection.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				int id=rs1.getInt(1);
				quotation_id=id+1;
				System.out.println("quottaion_id:"+quotation_id);
			}
			
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `customer_master`(`lead_no`,`quotation_id`,`quotation_name`, `ref_no`, `date`, `to`, `name1`, `name2`, `state`, `city`, `address`, `contact`, `email`, `subject`, `pincode`, `pro_co_ordi_name`, `pro_co_ordi_contact_no`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
			
			pst.setString(1, lead_no);
			pst.setInt(2, quotation_id);
			pst.setString(3, customer.getName_of_quotation());
			pst.setString(4, customer.getRef_no());
			pst.setString(5, customer.getRequiredDate());
			pst.setString(6, customer.getTo());
			pst.setString(7, customer.getName1());
			pst.setString(8, customer.getName2());
			pst.setString(9, customer.getState());
			pst.setString(10, customer.getCity());
			pst.setString(11, customer.getAddress());
			pst.setString(12, customer.getContact());
			pst.setString(13, customer.getEmail());
			pst.setString(14, customer.getSubject());
			pst.setString(15, customer.getPincode());
			pst.setString(16, customer.getProCoOrdiName());
			pst.setString(17, customer.getProCoOrdiContactNo());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public List<ContractModel> fetchContractDetails(ContractModel customer)
	{
		List<ContractModel> list=new ArrayList<>();
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			PreparedStatement pst=connection.prepareStatement("SELECT customer_master.ref_no,customer_master.contact,customer_master.email,customer_master.subject,customer_master.cust_id FROM customer_master ");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ContractModel contractor=new ContractModel();
				contractor.setRef_no(rs.getString(1));
				contractor.setContact(rs.getString(2));
				contractor.setEmail(rs.getString(3));
				contractor.setSubject(rs.getString(4));
				contractor.setCust_id(rs.getString(5));
				list.add(contractor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int deleteContractor(ContractModel contractor,String contractor1)
	{
		int delete_status=0;
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("DELETE FROM `customer_master` WHERE customer_master.cust_id=?");
			pst.setString(1, contractor1);
			delete_status=pst.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return delete_status;
	
	}
	
	public List<ContractModel> update_contractor_Details(ContractModel contractor,String lead_no)
	{
		List<ContractModel> list=new ArrayList<>();
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("SELECT `lead_no`, `ref_no`, `date`, `to`, `name1`, `name2`, `state`, `city`, `address`, `contact`, `email`, `subject`, `pincode`, `pro_co_ordi_name`, `pro_co_ordi_contact_no` FROM `customer_master` WHERE lead_no=?");
			pst.setString(1, lead_no);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ContractModel contractor1=new ContractModel();
				contractor1.setLead_no(rs.getString(1));
				contractor1.setRef_no(rs.getString(2));
				contractor1.setRequiredDate(rs.getString(3));
				contractor1.setTo(rs.getString(4));
				contractor1.setName1(rs.getString(5));
				contractor1.setName2(rs.getString(6));
				contractor1.setState(rs.getString(7));
				contractor1.setCity(rs.getString(8));
				contractor1.setAddress(rs.getString(9));
				contractor1.setContact(rs.getString(10));
				contractor1.setEmail(rs.getString(11));
				contractor1.setSubject(rs.getString(12));
				contractor1.setPincode(rs.getString(13));
				contractor1.setProCoOrdiName(rs.getString(14));
				contractor1.setProCoOrdiContactNo(rs.getString(15));
				list.add(contractor1);
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				request.setAttribute("lead_no", rs.getString(1));
				request.setAttribute("ref_no", rs.getString(2));
				request.setAttribute("requiredDate", rs.getString(3));
				request.setAttribute("to", rs.getString(4));
				request.setAttribute("name1", rs.getString(5));
				request.setAttribute("name2", rs.getString(6));
				request.setAttribute("state", rs.getString(7));
				request.setAttribute("city", rs.getString(8));
				request.setAttribute("address", rs.getString(9));
				request.setAttribute("contact", rs.getString(10));
				request.setAttribute("email", rs.getString(11));
				request.setAttribute("subject", rs.getString(12));
				request.setAttribute("pincode", rs.getString(13));
				request.setAttribute("proCoOrdiName", rs.getString(14));
				request.setAttribute("proCoOrdiContactNo", rs.getString(15));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int update_contractor(ContractModel contractor,String update_id,String ref_no,String req_date,String to,String name1,String name2,String address,String state,String city,String contact,String email,String subject,String pincode,String proConame,String prococontact)
	{
		int status=0;
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("UPDATE `customer_master` SET `ref_no`=?,`date`=?,`to`=?,`name1`=?,`name2`=?,`state`=?,`city`=?,`address`=?,`contact`=?,`email`=?,`subject`=?,`pincode`=?,`pro_co_ordi_name`=?,`pro_co_ordi_contact_no`=? WHERE quotation_id=?");
			pst.setString(1,ref_no);
			pst.setString(2,req_date);
			pst.setString(3,to);
			pst.setString(4,name1);
			pst.setString(5,name2);
			pst.setString(6,state);
			pst.setString(7,city);
			pst.setString(8,address);
			pst.setString(9,contact);
			pst.setString(10,email);
			pst.setString(11,subject);
			pst.setString(12,pincode);
			pst.setString(13,proConame);
			pst.setString(14,prococontact);
			pst.setString(15,update_id);
			status=pst.executeUpdate();
			System.out.println("update_customer_id:"+pst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}
	
	public List<ContractModel> getContractor_details(ContractModel contractor,String contractor_id)
	{
		List<ContractModel> list=new ArrayList<>();
		try {
			
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("SELECT `ref_no`, `date`, `to`, `name1`, `name2`, `state`, `city`, `address`, `contact`, `email`, `subject`, `pincode`, `pro_co_ordi_name`, `pro_co_ordi_contact_no` FROM `customer_master` WHERE cust_id=?");
			pst.setString(1, contractor_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ContractModel contractor1=new ContractModel();
				contractor1.setRef_no(rs.getString(1));
				contractor1.setRequiredDate(rs.getString(2));
				contractor1.setTo(rs.getString(3));
				contractor1.setName1(rs.getString(4));
				contractor1.setName2(rs.getString(5));
				contractor1.setState(rs.getString(6));
				contractor1.setCity(rs.getString(7));
				contractor1.setAddress(rs.getString(8));
				contractor1.setContact(rs.getString(9));
				contractor1.setEmail(rs.getString(10));
				contractor1.setSubject(rs.getString(11));
				contractor1.setPincode(rs.getString(12));
				contractor1.setProCoOrdiName(rs.getString(13));
				contractor1.setProCoOrdiContactNo(rs.getString(14));
				list.add(contractor1);
				
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("ref_no", rs.getString(1));
				request.setAttribute("requiredDate", rs.getString(2));
				request.setAttribute("to", rs.getString(3));
				request.setAttribute("name1", rs.getString(4));
				request.setAttribute("name2", rs.getString(5));
				request.setAttribute("state", rs.getString(6));
				request.setAttribute("city", rs.getString(7));
				request.setAttribute("address", rs.getString(8));
				request.setAttribute("contact", rs.getString(9));
				request.setAttribute("email", rs.getString(10));
				request.setAttribute("subject", rs.getString(11));
				request.setAttribute("pincode", rs.getString(12));
				request.setAttribute("proCoOrdiName", rs.getString(13));
				request.setAttribute("proCoOrdiContactNo", rs.getString(14));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public List<LeadFormModel> fetchCustomerDetailsToContractor(LeadFormModel leadForm, String lead_no,String ref_no) {
		// TODO Auto-generated method stub
		
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		List<LeadFormModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `customer_name`, `contact_no`,`lead_no` FROM `meeting_details` WHERE `lead_no`='"+lead_no+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				
				LeadFormModel lead=new LeadFormModel();
				
				lead.setCustomer_name(rs.getString(1));
				lead.setContact_no(rs.getString(2));
				lead.setLead_serial_no(rs.getString(3));
				lead.setRef_no(ref_no);
				list.add(lead);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public String fetchRefNo(String quotation_name) {
		// TODO Auto-generated method stub
		String[] response;
		String refernce_no;
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		String stringValue1 = null;
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
		        
		String pref = "US/QTN";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		// String pref="INV";
		PreparedStatement preparedStatement11;
		try {
			preparedStatement11 = connection
					.prepareStatement("select  max(SUBSTRING(ref_no,-4)) as myval1 from  customer_master  where LENGTH(ref_no)>5 and ref_no  like  ?");
		
			preparedStatement11.setString(1, "" + "%" + Fyear + "%");

			String mystr1 = "";
			int myval1 = 0;
			int w = 0;
		     stringValue1 = "1";

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
				stringValue1 =  "US/QTN/"+Fyear + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 =  "US/QTN/"+Fyear + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = "US/QTN/"+Fyear + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 =  "US/QTN/"+Fyear + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) { 
					stringValue1 =  "US/QTN/"+Fyear + "/0" + String.valueOf(myval1);
				}
				else {
					stringValue1 =  "US/QTN/"+Fyear + "/" + String.valueOf(myval1);
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		response=stringValue1.split("/");
		refernce_no=response[0]+"/"+response[1]+"/"+quotation_name+"/"+response[3];	
		System.out.println("refernce_no:"+refernce_no);
		return refernce_no;
	}
}
