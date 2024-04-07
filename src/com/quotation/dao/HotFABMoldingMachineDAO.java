package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.oro.text.regex.Perl5Pattern;

import com.DB.DBConnection;
import com.quotation.model.HotFABMoldingMachineModel;

public class HotFABMoldingMachineDAO {

	DBConnection connection=new DBConnection();
	
	public int insert_hot_fab_moldingmc(HotFABMoldingMachineModel hotfabmoldingmc) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `hotfabmold_config_master`(`name`, `iimage`, `machine_details`, `subheading1`, `techSpecifications1`, `subheading2`, `techSpecifications2`, `specificationsDetails`, `quotation_name`) VALUES (?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, hotfabmoldingmc.getName());
			pst.setString(2, hotfabmoldingmc.getImage());
			pst.setString(3, hotfabmoldingmc.getMachine_details());
			pst.setString(4, hotfabmoldingmc.getSubheading1());
			pst.setString(5, hotfabmoldingmc.getSubname());
			pst.setString(6, hotfabmoldingmc.getSubheading2());
			pst.setString(7, hotfabmoldingmc.getSubname1());
			pst.setString(8, hotfabmoldingmc.getSpecificationsDetails());
			pst.setString(9, hotfabmoldingmc.getQuotation_name());
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println(" master inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(hotfabmold_config_master.hotfabmoldingmc_id) AS hotfabCount FROM hotfabmold_config_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int k=0;k<hotfabmoldingmc.getSpecifications().length;k++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `hotfabmold_config_001`(`specifications`, `fab_hotfab_id`) VALUES (?,?)");
						
						pst11.setString(1, hotfabmoldingmc.getSpecifications()[k]);
						pst11.setInt(2, max_count);
					  
					  i=pst11.executeUpdate();
					  System.out.println("inserted 1");
					}
					
					for(int j=0;j<hotfabmoldingmc.getSpecifications1().length;j++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hotfabmold_config_002`(`srno`, `specifications`, `fab_hotfab_id`) VALUES (?,?,?)");
						
						pst111.setString(1, hotfabmoldingmc.getSrno()[j]);
						pst111.setString(2, hotfabmoldingmc.getSpecifications1()[j]);
						pst111.setInt(3, max_count);
						
					  i=pst111.executeUpdate();
					  
					  System.out.println("inserted 1");
					}
					
					for(int l=0;l<hotfabmoldingmc.getSpecifications2().length;l++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hotfabmold_config_003`(`specifications`, `quantity`, `hotfab_id`) VALUES (?,?,?)");
						
						pst111.setString(1, hotfabmoldingmc.getSpecifications2()[l]);
						pst111.setString(2, hotfabmoldingmc.getQuantity2()[l]);
						pst111.setInt(3, max_count);
						
					  i=pst111.executeUpdate();
					  
					  System.out.println("inserted 1");
					}
					
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC(HotFABMoldingMachineModel hotfabmoldingmc) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name`, `iimage`, `machine_details`, `subheading1`, `techSpecifications1`, `subheading2`, `techSpecifications2`, `specificationsDetails` FROM `hotfabmoldingmc_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmolding=new HotFABMoldingMachineModel();
				hotfabmolding.setName(rs.getString(1));
				hotfabmolding.setImage(rs.getString(2));
				hotfabmolding.setMachine_details(rs.getString(3));
				hotfabmolding.setSubheading1(rs.getString(4));
				hotfabmolding.setSubname(rs.getString(5));
				hotfabmolding.setSubheading2(rs.getString(6));
				hotfabmolding.setSubname1(rs.getString(7));
				hotfabmolding.setSpecificationsDetails(rs.getString(8));
				list.add(hotfabmolding);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC1(HotFABMoldingMachineModel hotfabmoldingmc) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`FROM `hotfabmoldingmc_details_1`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSpecification(rs.getString(1));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC2(HotFABMoldingMachineModel hotfabmoldingmc) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `srno`, `specifications` FROM `hotfabmoldingmc_details_2`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSrno1(rs.getString(1));
				hotfabmoding.setSpecification1(rs.getString(2));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC3(HotFABMoldingMachineModel hotfabmoldingmc) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hotfabmoldingmc_details_3`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSpecification2(rs.getString(1));
				hotfabmoding.setQuantity21(rs.getString(2));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int deleteHOTFABMoldingmc(HotFABMoldingMachineModel hotfabmoldingmc,String hotfabmolding_id) {
		// TODO Auto-generated method stub
		int i=0;
		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_master` WHERE hotfabmoldingmc_id=?");
			pst.setInt(1, hotfabmoldingId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_001` WHERE fab_hotfab_id=?");
			pst.setInt(1, hotfabmoldingId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_002` WHERE fab_hotfab_id=?");
			pst.setInt(1, hotfabmoldingId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_003` WHERE hotfab_id=?");
			pst.setInt(1, hotfabmoldingId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC4(HotFABMoldingMachineModel hotfabmoldingmc,String hotfabmolding_id) {
		// TODO Auto-generated method stub
		
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		
		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `hotfabmoldingmc_id`, `name`, `iimage`, `machine_details`, `subheading1`, `techSpecifications1`, `subheading2`, `techSpecifications2`, `specificationsDetails`, `quotation_name` FROM `hotfabmold_config_master` WHERE hotfabmoldingmc_id=?");
			pst.setInt(1, hotfabmoldingId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmolding=new HotFABMoldingMachineModel();
				hotfabmolding.setHotfab_id(rs.getInt(1));
				hotfabmolding.setName(rs.getString(2));
				hotfabmolding.setImage(rs.getString(3));
				hotfabmolding.setMachine_details(rs.getString(4));
				hotfabmolding.setSubheading1(rs.getString(5));
				hotfabmolding.setSubname(rs.getString(6));
				hotfabmolding.setSubheading2(rs.getString(7));
				hotfabmolding.setSubname1(rs.getString(8));
				hotfabmolding.setSpecificationsDetails(rs.getString(9));
				hotfabmolding.setQuotation_name(rs.getString(10));
				list.add(hotfabmolding);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC5(HotFABMoldingMachineModel hotfabmoldingmc,String hotfabmolding_id) {
		// TODO Auto-generated method stub
		
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		
		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications` FROM `hotfabmold_config_001` WHERE fab_hotfab_id=?");
			pst.setInt(1, hotfabmoldingId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSpecification(rs.getString(1));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC6(HotFABMoldingMachineModel hotfabmoldingmc,String hotfabmolding_id) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();

		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT  `srno`, `specifications` FROM `hotfabmold_config_002` WHERE fab_hotfab_id=?");
			pst.setInt(1, hotfabmoldingId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSrno1(rs.getString(1));
				hotfabmoding.setSpecification1(rs.getString(2));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchHotFABModlingMC7(HotFABMoldingMachineModel hotfabmoldingmc,String hotfabmolding_id) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hotfabmold_config_003` WHERE hotfab_id=?");
			pst.setInt(1,hotfabmoldingId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotfabmoding=new HotFABMoldingMachineModel();
				hotfabmoding.setSpecification2(rs.getString(1));
				hotfabmoding.setQuantity21(rs.getString(2));
				list.add(hotfabmoding);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public int updateHOTFABMoldingMc(HotFABMoldingMachineModel hotfabmoldingmc, String hotfabmolding_id) {
		// TODO Auto-generated method stub
		int i=0;
		Connection conn=connection.getConnection();
		int hotfabmoldingId=Integer.parseInt(hotfabmolding_id);
		int max_count=0;
		
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `hotfabmold_config_master` SET `name`=?,`iimage`=?,`machine_details`=?,`subheading1`=?,`techSpecifications1`=?,`subheading2`=?,`techSpecifications2`=?,`specificationsDetails`=?,`quotation_name`=? WHERE hotfabmoldingmc_id=?");
			
			pst.setString(1, hotfabmoldingmc.getName());
			pst.setString(2, hotfabmoldingmc.getImage());
			pst.setString(3, hotfabmoldingmc.getMachine_details());
			pst.setString(4, hotfabmoldingmc.getSubheading1());
			pst.setString(5, hotfabmoldingmc.getSubname());
			pst.setString(6, hotfabmoldingmc.getSubheading2());
			pst.setString(7, hotfabmoldingmc.getSubname1());
			pst.setString(8, hotfabmoldingmc.getSpecificationsDetails());
			pst.setString(9, hotfabmoldingmc.getQuotation_name());
			pst.setInt(10, hotfabmoldingId);
			i=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
			try {
					
					try {
						PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_001` WHERE fab_hotfab_id=?");
						pst.setInt(1, hotfabmoldingId);
						i=pst.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int k=0;k<hotfabmoldingmc.getSpecifications().length;k++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `hotfabmold_config_001`(`specifications`, `fab_hotfab_id`) VALUES (?,?)");
						
						pst11.setString(1, hotfabmoldingmc.getSpecifications()[k]);
						pst11.setInt(2, hotfabmoldingId);
					  
					  i=pst11.executeUpdate();
					}
					
					try {
						PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_002` WHERE fab_hotfab_id=?");
						pst.setInt(1, hotfabmoldingId);
						i=pst.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int j=0;j<hotfabmoldingmc.getSpecifications1().length;j++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hotfabmold_config_002`(`srno`, `specifications`, `fab_hotfab_id`) VALUES (?,?,?)");
						
						pst111.setString(1, hotfabmoldingmc.getSrno()[j]);
						pst111.setString(2, hotfabmoldingmc.getSpecifications1()[j]);
						pst111.setInt(3, hotfabmoldingId);
						
					  i=pst111.executeUpdate();
					  
					}
					
					try {
						PreparedStatement pst=conn.prepareStatement("DELETE FROM `hotfabmold_config_003` WHERE hotfab_id=?");
						pst.setInt(1, hotfabmoldingId);
						i=pst.executeUpdate();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for(int l=0;l<hotfabmoldingmc.getSpecifications2().length;l++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hotfabmold_config_003`(`specifications`, `quantity`, `hotfab_id`) VALUES (?,?,?)");
						
						pst111.setString(1, hotfabmoldingmc.getSpecifications2()[l]);
						pst111.setString(2, hotfabmoldingmc.getQuantity2()[l]);
						pst111.setInt(3, hotfabmoldingId);
						
					  i=pst111.executeUpdate();
					  
					}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}
