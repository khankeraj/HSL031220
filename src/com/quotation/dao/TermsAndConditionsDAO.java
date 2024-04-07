package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.TermsAndConditionsModel;

public class TermsAndConditionsDAO {
	
	DBConnection connection=new DBConnection();
	

	public int insert_terms_conditions(TermsAndConditionsModel termsConditions) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `terms_conditions_config_master`(`name_of_index`, `sub_name_of_index`, `quotation_name`) VALUES (?,?,?)");
			pst.setString(1, termsConditions.getName_of_index());
			pst.setString(2, termsConditions.getSub_name_of_index());
			pst.setString(3, termsConditions.getQuotation_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted....!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(terms_cond_id) FROM terms_conditions_config_master");
				ResultSet rs=pst1.executeQuery();
				while(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
				}
				
				for(int j=0;j<termsConditions.getSpecififcations().length;j++) 
				{
				
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `terms_conditions_001`(`particulars`, `details`, `terms_conditions_id`) VALUES (?,?,?)");
					pst11.setString(1, termsConditions.getSpecififcations()[j]);
					pst11.setString(2, termsConditions.getQuantity()[j]);
					pst11.setInt(3, max_count);
					
					i=pst11.executeUpdate();
				
				}
				
				for(int k=0;k<termsConditions.getSpecififcations1().length;k++) 
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `terms_conditions_002`(`specifications`, `terms_conditions_id`) VALUES (?,?)");
					pst11.setString(1, termsConditions.getSpecififcations1()[k]);
					pst11.setInt(2, max_count);
					
					i=pst11.executeUpdate();
					
					}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details(TermsAndConditionsModel termsConditions) {
		// TODO Auto-generated method stub
		List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `name_of_index`, `sub_name_of_index` FROM `terms_condiotions_master`");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms_cond=new TermsAndConditionsModel();
				terms_cond.setName_of_index(rs.getString(1));
				terms_cond.setSub_name_of_index(rs.getString(2));
				list.add(terms_cond);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details1(TermsAndConditionsModel termsConditions) {
		// TODO Auto-generated method stub
		List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `details` FROM `terms_condiotions_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms1=new TermsAndConditionsModel();
				terms1.setSpecifi(rs.getString(1));
				terms1.setQty(rs.getString(2));
				list.add(terms1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details2(TermsAndConditionsModel termsConditions) {
		// TODO Auto-generated method stub
List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications` FROM `terms_condiotions_details2`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms1=new TermsAndConditionsModel();
				terms1.setSpecifi1(rs.getString(1));
				list.add(terms1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details3(TermsAndConditionsModel termsConditions,String termsConditionsId) {
		// TODO Auto-generated method stub
		
		List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		int termscondId=Integer.parseInt(termsConditionsId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `terms_cond_id`, `name_of_index`, `sub_name_of_index`, `quotation_name` FROM `terms_conditions_config_master` WHERE terms_cond_id=?");
			pstmt.setInt(1, termscondId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms_cond=new TermsAndConditionsModel();
				terms_cond.setTerms_condition_id(rs.getInt(1));
				terms_cond.setName_of_index(rs.getString(2));
				terms_cond.setSub_name_of_index(rs.getString(3));
				terms_cond.setQuotation_name(rs.getString(4));
				list.add(terms_cond);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details4(TermsAndConditionsModel termsConditions,String termsConditionsId) {
		// TODO Auto-generated method stub
		int termscondId=Integer.parseInt(termsConditionsId);
		
		List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `details` FROM `terms_conditions_001` WHERE terms_conditions_id=?");
			pst.setInt(1, termscondId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms1=new TermsAndConditionsModel();
				terms1.setSpecifi(rs.getString(1));
				terms1.setQty(rs.getString(2));
				list.add(terms1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public List<TermsAndConditionsModel> fetch_terms_conditions_details5(TermsAndConditionsModel termsConditions,String termsConditionsId) {
		// TODO Auto-generated method stub
		int termscondId=Integer.parseInt(termsConditionsId);
		List<TermsAndConditionsModel> list=new ArrayList<TermsAndConditionsModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications` FROM `terms_conditions_002` WHERE terms_conditions_id=?");
			pst.setInt(1, termscondId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel terms1=new TermsAndConditionsModel();
				terms1.setSpecifi1(rs.getString(1));
				list.add(terms1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public int updateTermsConditions(TermsAndConditionsModel termsConditions, String termsConditionsId) {
		// TODO Auto-generated method stub
		int uptermsConditionsId=Integer.parseInt(termsConditionsId);
		
		int i=0;
		int max_count=0;
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `terms_conditions_config_master` SET `name_of_index`=?,`sub_name_of_index`=?,`quotation_name`=? WHERE `terms_cond_id`=?");
			pst.setString(1, termsConditions.getName_of_index());
			pst.setString(2, termsConditions.getSub_name_of_index());
			pst.setString(3, termsConditions.getQuotation_name());
			pst.setInt(4, uptermsConditionsId);
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted....!!!");
				
				PreparedStatement pst2=conn.prepareStatement("DELETE FROM `terms_conditions_001` WHERE terms_conditions_id=?");
				pst2.setInt(1, uptermsConditionsId);
				i=pst2.executeUpdate();
				
				for(int j=0;j<termsConditions.getSpecififcations().length;j++) 
				{
				
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `terms_conditions_001`(`particulars`, `details`, `terms_conditions_id`) VALUES (?,?,?)");
					pst11.setString(1, termsConditions.getSpecififcations()[j]);
					pst11.setString(2, termsConditions.getQuantity()[j]);
					pst11.setInt(3, uptermsConditionsId);
					
					i=pst11.executeUpdate();
				}
				
				
				PreparedStatement pst21=conn.prepareStatement("DELETE FROM `terms_conditions_002` WHERE terms_conditions_id=?");
				pst21.setInt(1, uptermsConditionsId);
				i=pst21.executeUpdate();
				
				for(int k=0;k<termsConditions.getSpecififcations1().length;k++) 
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `terms_conditions_002`(`specifications`, `terms_conditions_id`) VALUES (?,?)");
					pst11.setString(1, termsConditions.getSpecififcations1()[k]);
					pst11.setInt(2, uptermsConditionsId);
					
					i=pst11.executeUpdate();
			    }
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
		
	}
	
	public int deleteTermsConditions(TermsAndConditionsModel termsConditions, String termsConditionsId) {
		// TODO Auto-generated method stub
		int termscondId=Integer.parseInt(termsConditionsId);
		int i=0;
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `terms_conditions_config_master` WHERE terms_cond_id=?");
			pst.setInt(1, termscondId);
			i=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `terms_conditions_001` WHERE terms_conditions_id=?");
			pst1.setInt(1, termscondId);
			i=pst1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `terms_conditions_002` WHERE terms_conditions_id=?");
			pst1.setInt(1, termscondId);
			i=pst1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

}
