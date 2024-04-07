package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.ShrinkMachineModel;

public class ShrinkMachineDAO {
	DBConnection connection=new DBConnection();

	public int insert_shrink_machine(ShrinkMachineModel shrinkmachine) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `shrink_machine_config_master`(`name_of_index`, `image`, `name`, `parameterValue`, `features`, `quotation_name`) VALUES (?,?,?,?,?,?)");
			pst.setString(1,shrinkmachine.getName_of_index());
			pst.setString(2, shrinkmachine.getImage());
			pst.setString(3, shrinkmachine.getName());
			pst.setString(4, shrinkmachine.getParameterValue());
			pst.setString(5, shrinkmachine.getFeatures());
			pst.setString(6, shrinkmachine.getQuotation_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(shrink_machine_config_master.shrink_machine_id) AS maxCount FROM shrink_machine_config_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<shrinkmachine.getSpecifications().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `shrink_machine_config_001`(`specifications`, `shrink_machine_id`) VALUES (?,?)");
						pst11.setString(1, shrinkmachine.getSpecifications()[j]);
						pst11.setInt(2, max_count);
						i=pst11.executeUpdate();
						
					}
					
					for(int k=0;k<shrinkmachine.getFeature().length;k++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `shrink_machine_config_002`(`features`, `shrink_master_id`) VALUES (?,?)");
						pst11.setString(1, shrinkmachine.getFeature()[k]);
						pst11.setInt(2, max_count);
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

	public List<ShrinkMachineModel> fetchShrinkMachineMaster(ShrinkMachineModel shrinkmachine) {
		// TODO Auto-generated method stub
		
		List<ShrinkMachineModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("SELECT `name_of_index`, `image`, `name`, `parameterValue`, `features` FROM `shrink_machine_master`");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrinkmachine1=new ShrinkMachineModel();
				shrinkmachine1.setName_of_index(rs.getString(1));
				shrinkmachine1.setImage(rs.getString(2));
				shrinkmachine1.setName(rs.getString(3));
				shrinkmachine1.setParameterValue(rs.getString(4));
				shrinkmachine1.setFeatures(rs.getString(5));
				list.add(shrinkmachine1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMachineMaster1(ShrinkMachineModel shrinkmachine) {
		
		List<ShrinkMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `specifications` FROM `shrink_machine_specifications`");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrinkMachineModel=new ShrinkMachineModel();
				shrinkMachineModel.setSpecifi(rs.getString(1));
				list.add(shrinkMachineModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMachineMaster2(ShrinkMachineModel shrinkmachine) {
		List<ShrinkMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("SELECT `features` FROM `shrink_machine_features` ");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrink=new ShrinkMachineModel();
				shrink.setSpecifi1(rs.getString(1));
				list.add(shrink);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMachineMaster4(ShrinkMachineModel shrinkmachine,String shrinkId) {
		// TODO Auto-generated method stub
		
		List<ShrinkMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		int shrink_Id=Integer.parseInt(shrinkId);
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("SELECT `shrink_machine_id`, `name_of_index`, `image`, `name`, `parameterValue`, `features`, `quotation_name` FROM `shrink_machine_config_master` WHERE shrink_machine_id=?");
			pstmt.setInt(1, shrink_Id);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				ShrinkMachineModel shrinkmachine1=new ShrinkMachineModel();
				shrinkmachine1.setShrink_id(rs.getInt(1));
				shrinkmachine1.setName_of_index(rs.getString(2));
				shrinkmachine1.setImage(rs.getString(3));
				shrinkmachine1.setName(rs.getString(4));
				shrinkmachine1.setParameterValue(rs.getString(5));
				shrinkmachine1.setFeatures(rs.getString(6));
				shrinkmachine1.setQuotation_name(rs.getString(7));
				
				list.add(shrinkmachine1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMachineMaster5(ShrinkMachineModel shrinkmachine,String shrinkId) {
		// TODO Auto-generated method stub
		List<ShrinkMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		int shrink_Id=Integer.parseInt(shrinkId);
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("SELECT `specifications` FROM `shrink_machine_config_001` WHERE shrink_machine_id=?");
			pstmt.setInt(1, shrink_Id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrinkMachineModel=new ShrinkMachineModel();
				shrinkMachineModel.setSpecifi(rs.getString(1));
				list.add(shrinkMachineModel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMachineMaster6(ShrinkMachineModel shrinkmachine,String shrinkId) {
		// TODO Auto-generated method stub
		List<ShrinkMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		int shrink_Id=Integer.parseInt(shrinkId);
		try {
			
			PreparedStatement pstmt=conn.prepareStatement("SELECT `features` FROM `shrink_machine_config_002` WHERE shrink_master_id=?");
			pstmt.setInt(1, shrink_Id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrink=new ShrinkMachineModel();
				shrink.setSpecifi1(rs.getString(1));
				list.add(shrink);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateShrinkMC(ShrinkMachineModel shrinkmachine,String shrinkId) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		Connection conn=connection.getConnection();
		int shrink_Id=Integer.parseInt(shrinkId);
		try {
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `shrink_machine_config_master` SET `name_of_index`=?,`image`=?,`name`=?,`parameterValue`=?,`features`=?,`quotation_name`=? WHERE shrink_machine_id=?");
			
			pst.setString(1,shrinkmachine.getName_of_index());
			pst.setString(2, shrinkmachine.getImage());
			pst.setString(3, shrinkmachine.getName());
			pst.setString(4, shrinkmachine.getParameterValue());
			pst.setString(5, shrinkmachine.getFeatures());
			pst.setString(6, shrinkmachine.getQuotation_name());
			
			pst.setInt(7, shrink_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			
				PreparedStatement pstmt1=conn.prepareStatement("DELETE FROM `shrink_machine_config_001` WHERE shrink_machine_id=?");
				pstmt1.setInt(1, shrink_Id);
				i=pstmt1.executeUpdate();
				
				for(int j=0;j<shrinkmachine.getSpecifications().length;j++)
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `shrink_machine_config_001`(`specifications`, `shrink_machine_id`) VALUES (?,?)");
					pst11.setString(1, shrinkmachine.getSpecifications()[j]);
					pst11.setInt(2, shrink_Id);
					i=pst11.executeUpdate();
					
				}
				
                PreparedStatement pstmt2=conn.prepareStatement("DELETE FROM `shrink_machine_config_002` WHERE shrink_master_id=?");
                pstmt2.setInt(1, shrink_Id);
                i=pstmt2.executeUpdate();
				
				for(int k=0;k<shrinkmachine.getFeature().length;k++)
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `shrink_machine_config_002`(`features`, `shrink_master_id`) VALUES (?,?)");
					pst11.setString(1, shrinkmachine.getFeature()[k]);
					pst11.setInt(2, shrink_Id);
					i=pst11.executeUpdate();
					
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

	public int deleteShrinkMachine(ShrinkMachineModel shrinkmachine, String shrinkId) {
		// TODO Auto-generated method stub
		int i=0;
		Connection conn=connection.getConnection();
		int shrink_id=Integer.parseInt(shrinkId);
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `shrink_machine_config_master` WHERE shrink_machine_id=?");
			pst.setInt(1, shrink_id);
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `shrink_machine_config_001` WHERE shrink_machine_id=?");
			pst1.setInt(1, shrink_id);
			i=pst1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			PreparedStatement pst2=conn.prepareStatement("DELETE FROM `shrink_machine_config_002` WHERE shrink_master_id=?");
			pst2.setInt(1, shrink_id);
			i=pst2.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}
}
