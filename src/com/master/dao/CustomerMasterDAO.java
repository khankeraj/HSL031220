package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.CustomerMasterModel;

public class CustomerMasterDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
	
	
public String fetchCustDetails(String name) {
		
		
		String response = "";
		try {
		
			PreparedStatement preparedStatement1 = conn
					.prepareStatement("select * from customer_master_details where customer_name=?");
			
			preparedStatement1.setString(1, name);
			
			System.out.println("SQL:"+preparedStatement1);
			
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			
			if (resultSet1.next()) {
				
				
					response = resultSet1.getString("company_name")+"~"+resultSet1.getString("mobile_no");
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		DBConnection.closeConnection();
		return response;

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int insert_customer_master_details(CustomerMasterModel customer_modal) {
		int i=0;
		try {
			
			PreparedStatement psac = conn.prepareStatement("select * from customer_master_details where customer_name = '"+customer_modal.getCustomer_name()+"'");
			ResultSet rsac = psac.executeQuery();
			
			if(rsac.next())
			{
				return -1;
			}
			
			
			
			
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

			
			PreparedStatement pstmt=conn.prepareStatement("INSERT INTO `customer_master_details`(`customer_no`, `customer_name`, `company_name`, `customer_address`, `mobile_no`, `phone_no`, `state`, `city`, `pincode_no`, `pan_no`, `customer_gst_no`, `customer_email`,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			pstmt.setString(1, stringValue1);
			pstmt.setString(2, customer_modal.getCustomer_name().replace("-", " "));
			pstmt.setString(3, customer_modal.getCompany_name());
			pstmt.setString(4, customer_modal.getCustomer_address());
			pstmt.setString(5, customer_modal.getCustomer_mobile());
			pstmt.setString(6, customer_modal.getPhone_no());
			pstmt.setString(7, customer_modal.getState());
			pstmt.setString(8, customer_modal.getCity());
			pstmt.setString(9, customer_modal.getPincode_no());
			pstmt.setString(10, customer_modal.getPan_no());
			pstmt.setString(11, customer_modal.getCustomer_gst_no());
			pstmt.setString(12, customer_modal.getEmail());
		   
			pstmt.setString(13, customer_modal.getType());
			
			i=pstmt.executeUpdate();
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<CustomerMasterModel> fetchCustomerMasterDetails(CustomerMasterModel customer_modal) {
		// TODO Auto-generated method stub
		List<CustomerMasterModel> list=new ArrayList<CustomerMasterModel>();
		
		try {
				PreparedStatement pst=conn.prepareStatement("SELECT `customer_name`, `company_name`, `customer_address`, `mobile_no`, `phone_no`, `state`, `city`, `pincode_no`, `pan_no`, `customer_gst_no`,`customer_id`,`type` FROM `customer_master_details`");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					CustomerMasterModel customerModal=new CustomerMasterModel();
					
					customerModal.setCustomer_name(rs.getString(1));
					customerModal.setCompany_name(rs.getString(2));
					customerModal.setCustomer_address(rs.getString(3));
					customerModal.setCustomer_mobile(rs.getString(4));
					customerModal.setPhone_no(rs.getString(5));
					customerModal.setState(rs.getString(6));
					customerModal.setCity(rs.getString(7));
					customerModal.setPincode_no(rs.getString(8));
					customerModal.setPan_no(rs.getString(9));
					customerModal.setCustomer_gst_no(rs.getString(10));
					customerModal.setCustomer_id(rs.getInt(11));
					
					customerModal.setType(rs.getString(12));
					
					list.add(customerModal);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public int deleteCustomer_master(CustomerMasterModel customer_modal, String delete_customer_id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `customer_master_details` WHERE customer_id="+delete_customer_id+"");
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<CustomerMasterModel> fetchForUpdateCustomerDetailss(CustomerMasterModel customer_modal,
			String customer_id) {
		// TODO Auto-generated method stub
		List<CustomerMasterModel> list=new ArrayList<CustomerMasterModel>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `customer_id`, `customer_name`, `company_name`, `customer_address`, `mobile_no`, `phone_no`, `state`, `city`, `pincode_no`, `pan_no`, `customer_gst_no`,`type` FROM `customer_master_details` WHERE customer_id="+customer_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				CustomerMasterModel custMasterModal=new CustomerMasterModel();
				custMasterModal.setCustomer_id(rs.getInt(1));
				custMasterModal.setCustomer_name(rs.getString(2));
				custMasterModal.setCompany_name(rs.getString(3));
				custMasterModal.setCustomer_address(rs.getString(4));
				custMasterModal.setCustomer_mobile(rs.getString(5));
				custMasterModal.setPhone_no(rs.getString(6));
				custMasterModal.setState(rs.getString(7));
				custMasterModal.setCity(rs.getString(8));
				custMasterModal.setPincode_no(rs.getString(9));
				custMasterModal.setPan_no(rs.getString(10));
				custMasterModal.setCustomer_gst_no(rs.getString(11));
				
				custMasterModal.setType(rs.getString(12));
				
				list.add(custMasterModal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int update_customer_details(CustomerMasterModel customer_modal, String update_customer) {
		// TODO Auto-generated method stub
		int i=0;
		int customer_id=Integer.parseInt(update_customer);
		
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `customer_master_details` SET `customer_name`=?,`company_name`=?,`customer_address`=?,`mobile_no`=?,`phone_no`=?,`state`=?,`city`=?,`pincode_no`=?,`pan_no`=?,`customer_gst_no`=?,`type`=? WHERE `customer_id`=?");
			
			pst.setString(1, customer_modal.getCustomer_name().replace("-", " "));
			pst.setString(2, customer_modal.getCompany_name());
			pst.setString(3, customer_modal.getCustomer_address());
			pst.setString(4, customer_modal.getCustomer_mobile());
			pst.setString(5, customer_modal.getPhone_no());
			pst.setString(6, customer_modal.getState());
			pst.setString(7, customer_modal.getCity());
			pst.setString(8, customer_modal.getPincode_no());
			pst.setString(9, customer_modal.getPan_no());
			pst.setString(10, customer_modal.getCustomer_gst_no());
			pst.setString(11, customer_modal.getType());
			pst.setInt(12, customer_id);
			
			
			
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public String fetchCustomerforautofilled(CustomerMasterModel customer_modal, String customer_no) {
		// TODO Auto-generated method stub
		PreparedStatement pst;
		String response = "";
		try {
			pst = conn.prepareStatement("SELECT customer_master_details.customer_name,customer_master_details.mobile_no,customer_master_details.city FROM customer_master_details WHERE customer_master_details.customer_no='"+customer_no+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				response=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public String fetchCustomerDetails(CustomerMasterModel customermaster,String customer_code) {
		// TODO Auto-generated method stub
		String response="";
		
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT customer_name,customer_gst_no,pan_no,state,city,mobile_no,pending_amt,customer_address FROM customer_master_details WHERE customer_no='"+customer_code+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				response=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(7)+","+rs.getString(8);
				System.out.println("response:"+response);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
