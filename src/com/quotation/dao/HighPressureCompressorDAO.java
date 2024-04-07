package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.HighPressureCompressorModel;

public class HighPressureCompressorDAO {
	
	DBConnection connection=new DBConnection();

	public int insert_high_pressure_compressor(HighPressureCompressorModel highpressurecompressor) {
		
		int i=0;
		
		int max_count=0;
		
		try {
			
			Connection conn=connection.getConnection();
		
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `hpc_config_master`(`name_of_of_index`, `image`, `machine_details`, `subname1`, `subname2`, `techname`, `tech_details`, `heading2`, `quotation_name`) VALUES (?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, highpressurecompressor.getName_of_index());
			pst.setString(2, highpressurecompressor.getImage());
			pst.setString(3, highpressurecompressor.getMachine_details());
			pst.setString(4, highpressurecompressor.getSubname1());
			pst.setString(5, highpressurecompressor.getSubname2());
			pst.setString(6, highpressurecompressor.getTechname());
			pst.setString(7, highpressurecompressor.getTechDetails());
			pst.setString(8, highpressurecompressor.getHeading1());
			pst.setString(9, highpressurecompressor.getQuotation_name());
		  
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(hpc_config_master.high_pressure_compressor_id) AS maxCount FROM hpc_config_master");
				
				ResultSet rs=pst1.executeQuery();
				
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<highpressurecompressor.getSpecifications().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `hpc_config_001`(`specifications`, `quantity`, `hpc_id`) VALUES (?,?,?)");
						pst11.setString(1, highpressurecompressor.getSpecifications()[j]);
						pst11.setString(2, highpressurecompressor.getQuantity()[j]);
						pst11.setInt(3, max_count);
						i=pst11.executeUpdate();
					}
					
					for(int k=0;k<highpressurecompressor.getHeadingsOfspecifications().length;k++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hpc_config_002`(`specifications`, `quantity`, `hpc_id`) VALUES (?,?,?)");
						pst111.setString(1, highpressurecompressor.getHeadingsOfspecifications()[k]);
						pst111.setString(2, highpressurecompressor.getSpecifications1()[k]);
						pst111.setInt(3, max_count);
						i=pst111.executeUpdate();
					}
					
					for(int m=0;m<highpressurecompressor.getSpecifications4().length;m++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hpc_config_003`(`specifications4`, `quantity4`, `hpc_id`) VALUES (?,?,?)");
						pst111.setString(1, highpressurecompressor.getSpecifications4()[m]);
						pst111.setString(2, highpressurecompressor.getQuantity4()[m]);
						pst111.setInt(3, max_count);
						i=pst111.executeUpdate();
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public List<HighPressureCompressorModel> fetchHPCDetails(HighPressureCompressorModel highpressurecompressor) {
		// TODO Auto-generated method stub
		List<HighPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_of_index`,`image`,`machine_details`,`subname1`,`subname2`,`techname`,`tech_details`,`heading2` FROM `high_pressure_compressor`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				
				highPressureCompressor.setName_of_index(rs.getString(1));
				highpressurecompressor.setImage(rs.getString(2));
				highpressurecompressor.setMachine(rs.getString(3));
				highpressurecompressor.setName1(rs.getString(4));
				highpressurecompressor.setName2(rs.getString(5));
				highPressureCompressor.setTechname(rs.getString(6));
				highPressureCompressor.setTechDetails(rs.getString(7));
				highpressurecompressor.setHead(rs.getString(8));
				
				System.out.println(rs.getString(3)+","+rs.getString(4)+","+rs.getString(5)+","+rs.getString(6)+","+rs.getString(8));
				
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails1(HighPressureCompressorModel highpressurecompressor) {

		List<HighPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hpc_specifications_details1`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				highPressureCompressor.setSpecifi(rs.getString(1));
				highPressureCompressor.setQty(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails2(HighPressureCompressorModel highpressurecompressor) {
		
		List<HighPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hpc_specifications_details2` ");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				highPressureCompressor.setSpecifi2(rs.getString(1));
				highPressureCompressor.setQty2(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails3(HighPressureCompressorModel highpressurecompressor) {
		
		List<HighPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications4`, `quantity4` FROM `hpc_specifications_details4`");
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				
				highPressureCompressor.setSpecifi3(rs.getString(1));
				highPressureCompressor.setQty3(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails4(HighPressureCompressorModel highpressurecompressor,String hpcId) {
		// TODO Auto-generated method stub
		List<HighPressureCompressorModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		int hpc_Id=Integer.parseInt(hpcId);
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `high_pressure_compressor_id`, `name_of_of_index`, `image`, `machine_details`, `subname1`, `subname2`, `techname`, `tech_details`, `heading2`, `quotation_name` FROM `hpc_config_master` WHERE high_pressure_compressor_id=?");
			pst.setInt(1, hpc_Id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				
				highPressureCompressor.setHighPressureComp_id(rs.getInt(1));
				highPressureCompressor.setName_of_index(rs.getString(2));
				highpressurecompressor.setImage(rs.getString(3));
				highpressurecompressor.setMachine(rs.getString(4));
				highpressurecompressor.setName1(rs.getString(5));
				highpressurecompressor.setName2(rs.getString(6));
				highPressureCompressor.setTechname(rs.getString(7));
				highPressureCompressor.setTechDetails(rs.getString(8));
				highpressurecompressor.setHead(rs.getString(9));
				highpressurecompressor.setQuotation_name(rs.getString(10));
				list.add(highPressureCompressor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails5(HighPressureCompressorModel highpressurecompressor,String hpcId) {
		// TODO Auto-generated method stub
		List<HighPressureCompressorModel> list=new ArrayList<>();
		int hpc_Id=Integer.parseInt(hpcId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hpc_config_001` WHERE hpc_id=?");
			pst.setInt(1, hpc_Id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				highPressureCompressor.setSpecifi(rs.getString(1));
				highPressureCompressor.setQty(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails6(HighPressureCompressorModel highpressurecompressor,String hpcId) {
		
		List<HighPressureCompressorModel> list=new ArrayList<>();
		int hpc_Id=Integer.parseInt(hpcId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `hpc_config_002` WHERE hpc_id=?");
			pst.setInt(1, hpc_Id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				highPressureCompressor.setSpecifi2(rs.getString(1));
				highPressureCompressor.setQty2(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails7(HighPressureCompressorModel highpressurecompressor,String hpcId) {
		List<HighPressureCompressorModel> list=new ArrayList<>();
		int hpc_Id=Integer.parseInt(hpcId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications4`, `quantity4` FROM `hpc_config_003` WHERE hpc_id=?");
			pst.setInt(1, hpc_Id);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				HighPressureCompressorModel highPressureCompressor=new HighPressureCompressorModel();
				
				highPressureCompressor.setSpecifi3(rs.getString(1));
				highPressureCompressor.setQty3(rs.getString(2));
				list.add(highPressureCompressor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	

	public int deleteHPCDetails(HighPressureCompressorModel highpressurecompressor,String hpc_Id) 
	{
		int hpcId=Integer.parseInt(hpc_Id);
		int i=0;
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `hpc_config_master` WHERE high_pressure_compressor_id=?");
			pst.setInt(1, hpcId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `hpc_config_001` WHERE hps_sp_id=?");
			pst1.setInt(1, hpcId);
			i=pst1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst2=conn.prepareStatement("DELETE FROM `hpc_config_002` WHERE hpc_id=?");
			pst2.setInt(1, hpcId);
			i=pst2.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst3=conn.prepareStatement("DELETE FROM `hpc_config_003` WHERE hpc_id=?");
			pst3.setInt(1, hpcId);
			i=pst3.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int updateHPCDetails(HighPressureCompressorModel highpressurecompressor, String hpc_Id) {
		// TODO Auto-generated method stub
		Connection conn=connection.getConnection();
		int hpcId=Integer.parseInt(hpc_Id);
		int i=0;
		int max_count=0;
		try {
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `hpc_config_master` SET `name_of_of_index`=?,`image`=?,`machine_details`=?,`subname1`=?,`subname2`=?,`techname`=?,`tech_details`=?,`heading2`=?,`quotation_name`=? WHERE high_pressure_compressor_id=?");
			
			pst.setString(1, highpressurecompressor.getName_of_index());
			pst.setString(2, highpressurecompressor.getImage());
			pst.setString(3, highpressurecompressor.getMachine_details());
			pst.setString(4, highpressurecompressor.getSubname1());
			pst.setString(5, highpressurecompressor.getSubname2());
			pst.setString(6, highpressurecompressor.getTechname());
			pst.setString(7, highpressurecompressor.getTechDetails());
			pst.setString(8, highpressurecompressor.getHeading1());
			pst.setString(9, highpressurecompressor.getQuotation_name());
			pst.setInt(10, hpcId);
			
			i=pst.executeUpdate();
			
			System.out.println("pst:"+pst);
			System.out.println("update master:"+i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	try {
			
			try {
				PreparedStatement pst11=conn.prepareStatement("DELETE FROM `hpc_config_001` WHERE hps_sp_id=?");
				pst11.setInt(1, hpcId);
				i=pst11.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int j=0;j<highpressurecompressor.getSpecifications().length;j++)
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `hpc_config_001`(`specifications`, `quantity`, `hpc_id`) VALUES (?,?,?)");
				pst11.setString(1, highpressurecompressor.getSpecifications()[j]);
				pst11.setString(2, highpressurecompressor.getQuantity()[j]);
				pst11.setInt(3, hpcId);
				i=pst11.executeUpdate();
			}
			
			try {
				PreparedStatement pst2=conn.prepareStatement("DELETE FROM `hpc_config_002` WHERE hpc_id=?");
				pst2.setInt(1, hpcId);
				i=pst2.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int k=0;k<highpressurecompressor.getHeadingsOfspecifications().length;k++)
			{
				PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hpc_config_002`(`specifications`, `quantity`, `hpc_id`) VALUES (?,?,?)");
				pst111.setString(1, highpressurecompressor.getHeadingsOfspecifications()[k]);
				pst111.setString(2, highpressurecompressor.getSpecifications1()[k]);
				pst111.setInt(3, hpcId);
				i=pst111.executeUpdate();
			}
			
			try {
				PreparedStatement pst3=conn.prepareStatement("DELETE FROM `hpc_config_003` WHERE hpc_id=?");
				pst3.setInt(1, hpcId);
				i=pst3.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int m=0;m<highpressurecompressor.getSpecifications4().length;m++)
			{
				PreparedStatement pst111=conn.prepareStatement("INSERT INTO `hpc_config_003`(`specifications4`, `quantity4`, `hpc_id`) VALUES (?,?,?)");
				pst111.setString(1, highpressurecompressor.getSpecifications4()[m]);
				pst111.setString(2, highpressurecompressor.getQuantity4()[m]);
				pst111.setInt(3, hpcId);
				i=pst111.executeUpdate();
			}
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return i;
	}

}
