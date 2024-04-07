package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.FABRFCModel;

public class FABRFCDAO {
	
	DBConnection connection=new DBConnection();

	public int insert_fabrfc_master(FABRFCModel fabrfc) {
		
		int i=0;
		
		int max_count=0;
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `fab_rfc_master`(`fab_rfc_name`, `fab_rfc_subname`, `select_image`, `heading1`, `heading2`, `heading3`, `quotation_name`) VALUES (?,?,?,?,?,?,?)");
			pst.setString(1, fabrfc.getFab_rfc_name());
			pst.setString(2, fabrfc.getFab_rfc_subname());
			pst.setString(3, fabrfc.getSelect_image());
			pst.setString(4, fabrfc.getHeading1());
			pst.setString(5, fabrfc.getHeading2());
			pst.setString(6, fabrfc.getHeading3());
			pst.setString(7, fabrfc.getName_of_quotation());
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println(" master inserted....!!!");
				 
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(fab_rfc_master.fab_rins_fill_cap_maid) AS maxCount FROM fab_rfc_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
				}
				
				for(int j=0;j<fabrfc.getFabrfc_specification().length;j++)
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_rfc_sp_001`(`fab_rins_fill_cap_specifications`, `fab_rins_fill_cap_quantity`, `fab_rins_fill_cap_master_id`) VALUES (?,?,?)");
					pst11.setString(1, fabrfc.getFabrfc_specification()[j]);
					pst11.setString(2, fabrfc.getFabrfc_quantity()[j]);
					pst11.setInt(3, max_count);
					
					i=pst11.executeUpdate();
				
					System.out.println(" config001 inserted....!!!");
				}
				
				for(int k=0;k<fabrfc.getSpecifications1().length;k++)
				{
					PreparedStatement pst111=conn.prepareStatement("INSERT INTO `fab_rfc_sp_002`(`specifications1`, `quantity1`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
					pst111.setString(1, fabrfc.getSpecifications1()[k]);
					pst111.setString(2, fabrfc.getQuantity1()[k]);
					pst111.setInt(3, max_count);
					i=pst111.executeUpdate();
					
					System.out.println(" config002 inserted....!!!");
				}
				
				for(int l=0;l<fabrfc.getSpecifications2().length;l++)
				{
					PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `fab_rfc_sp_003`(`specifications2`, `quantity2`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
					
					pst1111.setString(1, fabrfc.getSpecifications2()[l]);
					pst1111.setString(2, fabrfc.getQuantity2()[l]);
					pst1111.setInt(3, max_count);
					i=pst1111.executeUpdate();
					
					System.out.println(" config003 inserted....!!!");
				}
				
				for(int m=0;m<fabrfc.getSpecifications3().length;m++)
				{
					PreparedStatement pmst=conn.prepareStatement("INSERT INTO `fab_rfc_sp_004`(`specifications3`, `quantity3`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
					
					pmst.setString(1, fabrfc.getSpecifications3()[m]);
					pmst.setString(2, fabrfc.getQuantity3()[m]);
					pmst.setInt(3, max_count);
					i=pmst.executeUpdate();
					
					System.out.println(" config004 inserted....!!!");
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<FABRFCModel> fectrfcMasterDetails(FABRFCModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			
			Connection conn=connection.getConnection();
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_rfc_name`, `fab_rfc_subname`, `select_image`, `heading1`, `heading2`, `heading3` FROM `fab_rfc_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				
				fabrfc1.setFab_rfc_name(rs.getString(1));
				fabrfc1.setFab_rfc_subname(rs.getString(2));
				fabrfc1.setSelect_image(rs.getString(3));
				fabrfc1.setHeading1(rs.getString(4));
				fabrfc1.setHeading2(rs.getString(5));
				fabrfc1.setHeading3(rs.getString(6));
				
				list.add(fabrfc1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails1(FABRFCModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_rins_fill_cap_specifications`, `fab_rins_fill_cap_quantity` FROM `fab_rfc_config_001`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp1(rs.getString(1));
				fabrfc1.setQty1(rs.getString(2));
				
				System.out.println("specifications:"+rs.getString(1)+"qty:"+rs.getString(2));
				
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<FABRFCModel> fectrfcMasterDetails2(FABRFCModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications1`, `quantity1` FROM `fab_rfc_config_002`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp2(rs.getString(1));;
				fabrfc1.setQty2(rs.getString(2));;
				
				System.out.println("specifications:"+rs.getString(1)+"qty:"+rs.getString(2));
				
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails3(FABRFCModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications2`, `quantity2` FROM `fab_rfc_config_003` ");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp3(rs.getString(1));;
				fabrfc1.setQty3(rs.getString(2));;
				
				System.out.println("specifications:"+rs.getString(1)+"qty:"+rs.getString(2));
				
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails4(FABRFCModel fabrfc) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications3`, `quantity3` FROM `fab_rfc_config_004` ");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp4(rs.getString(1));;
				fabrfc1.setQty4(rs.getString(2));;
				
				System.out.println("specifications:"+rs.getString(1)+"qty:"+rs.getString(2));
				
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateFABRFCDetails(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		int max_count=0;
		int i=0;
		int fabrfc_ID=Integer.parseInt(fabrfc_id);
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement("UPDATE `fab_rfc_master` SET `fab_rfc_name`=?,`fab_rfc_subname`=?,`select_image`=?,`heading1`=?,`heading2`=?,`heading3`=?,`quotation_name`=? WHERE fab_rins_fill_cap_maid=?");
			pstmt.setString(1, fabrfc.getFab_rfc_name());
			pstmt.setString(2, fabrfc.getFab_rfc_subname());
			pstmt.setString(3, fabrfc.getSelect_image());
			pstmt.setString(4, fabrfc.getHeading1());
			pstmt.setString(5, fabrfc.getHeading2());
			pstmt.setString(6, fabrfc.getHeading3());
			pstmt.setString(7, fabrfc.getName_of_quotation());
			pstmt.setInt(8, fabrfc_ID);
			i=pstmt.executeUpdate();
			System.out.println("rfc_updated 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	try{
		
		try {
			
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_001` WHERE fab_rins_fill_cap_master_id=?");
			pst.setInt(1, fabrfc_ID);
			i=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int j=0;j<fabrfc.getFabrfc_specification().length;j++)
		{
			PreparedStatement pst11=conn.prepareStatement("INSERT INTO `fab_rfc_sp_001`(`fab_rins_fill_cap_specifications`, `fab_rins_fill_cap_quantity`, `fab_rins_fill_cap_master_id`) VALUES (?,?,?)");
			pst11.setString(1, fabrfc.getFabrfc_specification()[j]);
			pst11.setString(2, fabrfc.getFabrfc_quantity()[j]);
			pst11.setInt(3, fabrfc_ID);
			
			i=pst11.executeUpdate();
		
		}
		
		try {
			
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_002` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabrfc_ID);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int k=0;k<fabrfc.getSpecifications1().length;k++)
		{
			PreparedStatement pst111=conn.prepareStatement("INSERT INTO `fab_rfc_sp_002`(`specifications1`, `quantity1`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
			pst111.setString(1, fabrfc.getSpecifications1()[k]);
			pst111.setString(2, fabrfc.getQuantity1()[k]);
			pst111.setInt(3, fabrfc_ID);
			i=pst111.executeUpdate();
			
		}
		
	try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_003` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabrfc_ID);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int l=0;l<fabrfc.getSpecifications2().length;l++)
		{
			PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `fab_rfc_sp_003`(`specifications2`, `quantity2`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
			
			pst1111.setString(1, fabrfc.getSpecifications2()[l]);
			pst1111.setString(2, fabrfc.getQuantity2()[l]);
			pst1111.setInt(3, fabrfc_ID);
			i=pst1111.executeUpdate();
			
		}
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_004` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabrfc_ID);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		for(int m=0;m<fabrfc.getSpecifications3().length;m++)
		{
			PreparedStatement pmst=conn.prepareStatement("INSERT INTO `fab_rfc_sp_004`(`specifications3`, `quantity3`, `fab_rfc_config_master_id`) VALUES (?,?,?)");
			
			pmst.setString(1, fabrfc.getSpecifications3()[m]);
			pmst.setString(2, fabrfc.getQuantity3()[m]);
			pmst.setInt(3, fabrfc_ID);
			i=pmst.executeUpdate();
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return i;
	
	}

	public List<FABRFCModel> fectrfcMasterDetails6(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		List<FABRFCModel> list=new ArrayList<>();
		int fabRFCId=Integer.parseInt(fabrfc_id);
		
		try {
			
			Connection conn=connection.getConnection();
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_rins_fill_cap_maid`, `fab_rfc_name`, `fab_rfc_subname`, `select_image`, `heading1`, `heading2`, `heading3`, `quotation_name` FROM `fab_rfc_master` WHERE fab_rins_fill_cap_maid=?");
			pst.setInt(1, fabRFCId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				
				fabrfc1.setFabrfc_id(rs.getInt(1));
				fabrfc1.setFab_rfc_name(rs.getString(2));
				fabrfc1.setFab_rfc_subname(rs.getString(3));
				fabrfc1.setSelect_image(rs.getString(4));
				fabrfc1.setHeading1(rs.getString(5));
				fabrfc1.setHeading2(rs.getString(6));
				fabrfc1.setHeading3(rs.getString(7));
				fabrfc1.setName_of_quotation(rs.getString(8));

				list.add(fabrfc1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<FABRFCModel> fectrfcMasterDetail7(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		int fabRFCId=Integer.parseInt(fabrfc_id);
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `fab_rins_fill_cap_specifications`, `fab_rins_fill_cap_quantity` FROM `fab_rfc_sp_001` WHERE fab_rins_fill_cap_master_id=?");
			pst.setInt(1, fabRFCId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp1(rs.getString(1));
				fabrfc1.setQty1(rs.getString(2));
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails8(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		List<FABRFCModel> list=new ArrayList<>();
		int fabRFCId=Integer.parseInt(fabrfc_id);
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications1`, `quantity1` FROM `fab_rfc_sp_002` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabRFCId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp2(rs.getString(1));;
				fabrfc1.setQty2(rs.getString(2));;
				
				System.out.println("specifications:"+rs.getString(1)+"qty:"+rs.getString(2));
				
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails9(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		List<FABRFCModel> list=new ArrayList<>();
		int fabRFCId=Integer.parseInt(fabrfc_id);
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications2`, `quantity2`, `fab_rfc_config_master_id` FROM `fab_rfc_sp_003` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabRFCId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp3(rs.getString(1));;
				fabrfc1.setQty3(rs.getString(2));;
				list.add(fabrfc1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<FABRFCModel> fectrfcMasterDetails10(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		
		List<FABRFCModel> list=new ArrayList<>();
		int fabRFCId=Integer.parseInt(fabrfc_id);
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications3`, `quantity3` FROM `fab_rfc_sp_004` WHERE fab_rfc_config_master_id=?");
			pst.setInt(1, fabRFCId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFab_rfc_sp4(rs.getString(1));;
				fabrfc1.setQty4(rs.getString(2));;
				list.add(fabrfc1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public int deleteFABRFC(FABRFCModel fabrfc,String fabrfc_id) {
		// TODO Auto-generated method stub
		int fabRFCId=Integer.parseInt(fabrfc_id);
			Connection conn=connection.getConnection();
			int i=0;
			try {
				PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_master` WHERE fab_rins_fill_cap_maid=?");
				pst.setInt(1, fabRFCId);
				i=pst.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				
				PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_001` WHERE fab_rins_fill_cap_master_id=?");
				pst.setInt(1, fabRFCId);
				i=pst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				
				PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_002` WHERE fab_rfc_config_master_id=?");
				pst.setInt(1, fabRFCId);
				i=pst.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				
				PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_003` WHERE fab_rfc_config_master_id=?");
				pst.setInt(1, fabRFCId);
				i=pst.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				PreparedStatement pst=conn.prepareStatement("DELETE FROM `fab_rfc_sp_004` WHERE fab_rfc_config_master_id=?");
				pst.setInt(1, fabRFCId);
				i=pst.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		return i;
	}
	
}
