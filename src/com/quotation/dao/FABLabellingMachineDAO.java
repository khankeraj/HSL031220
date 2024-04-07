package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.FABLabellingMachineModel;

public class FABLabellingMachineDAO {

	DBConnection connection=new DBConnection();
	
	public int insert_FABLabellingMachine(FABLabellingMachineModel fABLabellingMachine) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `fab_labeling_mc_config_001`(`fab_name`, `fab_subname`, `select_image`, `heading`, `quotation_name`) VALUES (?,?,?,?,?)");
			
			pst.setString(1, fABLabellingMachine.getFab_labeling_name());
			pst.setString(2, fABLabellingMachine.getFab_labeling_subname());
			pst.setString(3, fABLabellingMachine.getSelect_image());
			pst.setString(4, fABLabellingMachine.getHeading());
			pst.setString(5, fABLabellingMachine.getQuotation_name());
			
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX( fab_labeling_mc_config_001.fab_labeling_id) as maxCount FROM  fab_labeling_mc_config_001");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<fABLabellingMachine.getFab_specifications().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_lableing_mc_det_config_002`(`fab_spefications`, `fab_quantity`, `fab_labeling_id`) VALUES (?,?,?)");
						pst11.setString(1, fABLabellingMachine.getFab_specifications()[j]);
						pst11.setString(2, fABLabellingMachine.getFab_quantity()[j]);
						pst11.setInt(3, max_count);
						i=pst11.executeUpdate();
					}
					
					for(int k=0;k<fABLabellingMachine.getSpecifications1().length;k++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_lableing_mc_feat_config_003`( `features`, `fab_labeling_mc_id`) VALUES (?,?)");
						pst11.setString(1, fABLabellingMachine.getSpecifications1()[k]);
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

	public List<FABLabellingMachineModel> fetchFabLabelingMC(FABLabellingMachineModel fABLabellingMachine) {
		// TODO Auto-generated method stub
		
		List<FABLabellingMachineModel> list=new ArrayList<>();
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_name`, `fab_subname`, `select_image`, `heading` FROM `fab_labeling_mc_master`");
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				FABLabellingMachineModel fABLabellingMachine1=new FABLabellingMachineModel();
				
				fABLabellingMachine1.setFab_labeling_name(rs.getString(1));
				fABLabellingMachine1.setFab_labeling_subname(rs.getString(2));
				fABLabellingMachine1.setSelect_image(rs.getString(3));
				fABLabellingMachine1.setHeading(rs.getString(4));
				
				list.add(fABLabellingMachine1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABLabellingMachineModel> fetchFabLabelingMC1(FABLabellingMachineModel fABLabellingMachine) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_spefications`, `fab_quantity` FROM `fab_labeling_mc_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABLabellingMachineModel fablabeling=new FABLabellingMachineModel();
				fablabeling.setSpecifi(rs.getString(1));
				fablabeling.setQty(rs.getString(2));
				list.add(fablabeling);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	public List<FABLabellingMachineModel> fetchFabLabelingMC2(FABLabellingMachineModel fABLabellingMachine) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `features` FROM `fab_labeling_mc_features`");
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				FABLabellingMachineModel fablabeling=new FABLabellingMachineModel();
				fablabeling.setFeature(rs.getString(1));
				list.add(fablabeling);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<FABLabellingMachineModel> fetchFabLabelingMC4(FABLabellingMachineModel fABLabellingMachine,String fablabeling) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		int fablabelingId=Integer.parseInt(fablabeling);
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_labeling_id`, `fab_name`, `fab_subname`, `select_image`, `heading`, `quotation_name` FROM `fab_labeling_mc_config_001` WHERE fab_labeling_id=?");
			pst.setInt(1, fablabelingId);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				FABLabellingMachineModel fABLabellingMachine1=new FABLabellingMachineModel();
				fABLabellingMachine1.setFab_labeling_id(rs.getInt(1));
				fABLabellingMachine1.setFab_labeling_name(rs.getString(2));
				fABLabellingMachine1.setFab_labeling_subname(rs.getString(3));
				fABLabellingMachine1.setSelect_image(rs.getString(4));
				fABLabellingMachine1.setHeading(rs.getString(5));
				fABLabellingMachine1.setQuotation_name(rs.getString(6));
				
				list.add(fABLabellingMachine1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABLabellingMachineModel> fetchFabLabelingMC5(FABLabellingMachineModel fABLabellingMachine,String fablabeling) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		int fabLabelingId=Integer.parseInt(fablabeling);
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_spefications`, `fab_quantity` FROM `fab_lableing_mc_det_config_002` WHERE fab_labeling_id=?");
			pst.setInt(1, fabLabelingId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABLabellingMachineModel fablabeling1=new FABLabellingMachineModel();
				fablabeling1.setSpecifi(rs.getString(1));
				fablabeling1.setQty(rs.getString(2));
				list.add(fablabeling1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABLabellingMachineModel> fetchFabLabelingMC6(FABLabellingMachineModel fABLabellingMachine,String fablabeling) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		int fabLabelingId=Integer.parseInt(fablabeling);
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `features` FROM `fab_lableing_mc_feat_config_003` WHERE fab_labeling_mc_id=?");
			pst.setInt(1, fabLabelingId);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				FABLabellingMachineModel fablabeling1=new FABLabellingMachineModel();
				fablabeling1.setFeature(rs.getString(1));
				list.add(fablabeling1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateFABLabelingMC( FABLabellingMachineModel FABLabellingMachine,String fablabeling) {
		// TODO Auto-generated method stub
		int i=0;
		int updateFABLabelingid=Integer.parseInt(fablabeling);
		int max_count=0;
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `fab_labeling_mc_config_001` SET `fab_name`=?,`fab_subname`=?,`select_image`=?,`heading`=?,`quotation_name`=? WHERE fab_labeling_id=?");
			pst.setString(1, FABLabellingMachine.getFab_labeling_name());
			pst.setString(2, FABLabellingMachine.getFab_labeling_subname());
			pst.setString(3, FABLabellingMachine.getSelect_image());
			pst.setString(4, FABLabellingMachine.getHeading());
			pst.setString(5, FABLabellingMachine.getQuotation_name());
			pst.setInt(6, updateFABLabelingid);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		try{
			
			try {
				PreparedStatement pst11=conn.prepareStatement("DELETE FROM `fab_lableing_mc_det_config_002` WHERE fab_labeling_id=?");
				pst11.setInt(1, updateFABLabelingid);
				i=pst11.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int j=0;j<FABLabellingMachine.getFab_specifications().length;j++)
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_lableing_mc_det_config_002`(`fab_spefications`, `fab_quantity`, `fab_labeling_id`) VALUES (?,?,?)");
				pst11.setString(1, FABLabellingMachine.getFab_specifications()[j]);
				pst11.setString(2, FABLabellingMachine.getFab_quantity()[j]);
				pst11.setInt(3, updateFABLabelingid);
				i=pst11.executeUpdate();
			}
			
			try {
				PreparedStatement pst2=conn.prepareStatement("DELETE FROM `fab_lableing_mc_feat_config_003` WHERE fab_labeling_mc_id=?");
				pst2.setInt(1, updateFABLabelingid);
				i=pst2.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int k=0;k<FABLabellingMachine.getSpecifications1().length;k++)
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_lableing_mc_feat_config_003`( `features`, `fab_labeling_mc_id`) VALUES (?,?)");
				pst11.setString(1, FABLabellingMachine.getSpecifications1()[k]);
				pst11.setInt(2, updateFABLabelingid);
				i=pst11.executeUpdate();
			}
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return i;
}

	public int deleteFABLabelingmc(FABLabellingMachineModel fABLabellingMachine, String delete_id) {
		// TODO Auto-generated method stub
		int i=0;
		Connection conn=connection.getConnection();
		int deleteFABLabelingid=Integer.parseInt(delete_id);
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_labeling_mc_config_001` WHERE fab_labeling_id=?");
			pst.setInt(1, deleteFABLabelingid);
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `fab_lableing_mc_det_config_002` WHERE fab_labeling_id=?");
			pst1.setInt(1, deleteFABLabelingid);
			i=pst1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst2=conn.prepareStatement("DELETE FROM `fab_lableing_mc_feat_config_003` WHERE fab_labeling_mc_id=?");
			pst2.setInt(1, deleteFABLabelingid);
			i=pst2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
}
