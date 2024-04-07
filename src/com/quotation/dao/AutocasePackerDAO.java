package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.AutocasePackerModel;

public class AutocasePackerDAO {
	
	DBConnection connection=new DBConnection();

	public int insert_autoCasePacker_master(AutocasePackerModel autoCasePacker) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `autocase_packer_config_master`(`name_of_index`, `sub_name`, `note`, `quotation_name`) VALUES (?,?,?,?)");
			pst.setString(1, autoCasePacker.getName_of_index());
			pst.setString(2, autoCasePacker.getSubanme());
			pst.setString(3, autoCasePacker.getNote());
			pst.setString(4, autoCasePacker.getQuotation_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(autocase_packer_config_master.autocase_packer_id) AS maxCount FROM autocase_packer_config_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<autoCasePacker.getSpecfication().length;j++) {
						
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `autocase_packer_config_001`(`specifications`, `quantity`, `autocase_packer_id`) VALUES (?,?,?)");
						
						pst11.setString(1, autoCasePacker.getSpecfication()[j]);
						pst11.setString(2, autoCasePacker.getQuantity()[j]);
						pst11.setInt(3, max_count);
						
						i=pst11.executeUpdate();
					}
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<AutocasePackerModel> fetchAutocasePacker(AutocasePackerModel autoCasePacker) {
		// TODO Auto-generated method stub
		List<AutocasePackerModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `sub_name`, `note` FROM `autocase_packer_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AutocasePackerModel autocasePacker=new AutocasePackerModel();
				autocasePacker.setName_of_index(rs.getString(1));
				autoCasePacker.setSubanme(rs.getString(2));
				autocasePacker.setNote(rs.getString(3));
				list.add(autocasePacker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<AutocasePackerModel> fetchAutocasePacker1(AutocasePackerModel autoCasePacker) {
		// TODO Auto-generated method stub
		List<AutocasePackerModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `autocase_packer_sp_details`");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				AutocasePackerModel autocaseP=new AutocasePackerModel();
				autocaseP.setSpecifi(rs.getString(1));
				autocaseP.setQty(rs.getString(2));
				list.add(autocaseP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<AutocasePackerModel> fetchAutocasePacker2(AutocasePackerModel autoCasePacker,String autocasepackerId) {
		// TODO Auto-generated method stub
		
		List<AutocasePackerModel> list=new ArrayList<>();
		int autocase_Id=Integer.parseInt(autocasepackerId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `autocase_packer_id`, `name_of_index`, `sub_name`, `note`, `quotation_name` FROM `autocase_packer_config_master` WHERE autocase_packer_id=?");
			pst.setInt(1, autocase_Id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AutocasePackerModel autocasePacker=new AutocasePackerModel();
				autocasePacker.setAutocase_packer_id(rs.getInt(1));
				autocasePacker.setName_of_index(rs.getString(2));
				autoCasePacker.setSubanme(rs.getString(3));
				autocasePacker.setNote(rs.getString(4));
				autocasePacker.setQuotation_name(rs.getString(5));
				list.add(autocasePacker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<AutocasePackerModel> fetchAutocasePacker3(AutocasePackerModel autoCasePacker,String autocasepackerId) {
		List<AutocasePackerModel> list=new ArrayList<>();
		int autocase_Id=Integer.parseInt(autocasepackerId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `autocase_packer_config_001` WHERE autocase_packer_id=?");
			pstmt.setInt(1, autocase_Id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				AutocasePackerModel autocaseP=new AutocasePackerModel();
				autocaseP.setSpecifi(rs.getString(1));
				autocaseP.setQty(rs.getString(2));
				list.add(autocaseP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateAutoCasePackerDetails(AutocasePackerModel autoCasePacker,String autocasepackerId) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		int autoCaseId=Integer.parseInt(autocasepackerId);
		
		Connection conn=connection.getConnection();
		try {
		int autocaseId=Integer.parseInt(autocasepackerId);
		PreparedStatement pst=conn.prepareStatement("UPDATE `autocase_packer_config_master` SET `name_of_index`=?,`sub_name`=?,`note`=?,`quotation_name`=? WHERE `autocase_packer_id`=?");
		pst.setString(1, autoCasePacker.getName_of_index());
		pst.setString(2, autoCasePacker.getSubanme());
		pst.setString(3, autoCasePacker.getNote());
		pst.setString(4, autoCasePacker.getQuotation_name());
		pst.setInt(5, autoCaseId);
		i=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		try {
			
				PreparedStatement pstmt=conn.prepareStatement("DELETE FROM `autocase_packer_config_001` WHERE autocase_packer_id=?");
				pstmt.setInt(1, autoCaseId);
				i=pstmt.executeUpdate();
				
				for(int j=0;j<autoCasePacker.getSpecfication().length;j++) {
					
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `autocase_packer_config_001`(`specifications`, `quantity`, `autocase_packer_id`) VALUES (?,?,?)");
					
					pst11.setString(1, autoCasePacker.getSpecfication()[j]);
					pst11.setString(2, autoCasePacker.getQuantity()[j]);
					pst11.setInt(3, autoCaseId);
					
					i=pst11.executeUpdate();
				}
				
		}
     catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return i;
	}

	public int deleteAutoCasePacker(AutocasePackerModel autoCasePacker, String autocasepackerId) {
		// TODO Auto-generated method stub
		
		int i=0;
		int deleteAutoCasePackerId=Integer.parseInt(autocasepackerId);
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `autocase_packer_config_master` WHERE autocase_packer_id=?");
			pst.setInt(1,deleteAutoCasePackerId);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `autocase_packer_config_001` WHERE autocase_sp_id=?");
			pst1.setInt(1, deleteAutoCasePackerId);
			i=pst1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

}
