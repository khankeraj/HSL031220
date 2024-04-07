package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.LowPressureCompressorModel;

public class LowPressureCompressorDAO {
	DBConnection connection=new DBConnection();

	public int insert_lowPressureCompressorMaster(LowPressureCompressorModel lowPressureCompressor) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		int max_count1=0;
		
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `lpc_config_master`(`name_of_index`, `image`, `machine_details1`, `machine_details2`, `technical_specifications`, `scope_of_supply`, `quotation_name`) VALUES (?,?,?,?,?,?,?)");
			
			pst.setString(1, lowPressureCompressor.getName_of_index());
			pst.setString(2, lowPressureCompressor.getImage());
			pst.setString(3, lowPressureCompressor.getMachine_details1());
			pst.setString(4, lowPressureCompressor.getMachine_details2());
			pst.setString(5, lowPressureCompressor.getTech_specifications());
			pst.setString(6, lowPressureCompressor.getScope_of_supply());
			pst.setString(7, lowPressureCompressor.getQuotation_name());
		
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lpc_config_master.lpc_id) AS maxcount FROM lpc_config_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<lowPressureCompressor.getSpecifications().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lpc_config_001`(`specifications`, `quantity`, `lpc_id`) VALUES (?,?,?)");
						pst11.setString(1, lowPressureCompressor.getSpecifications()[j]);
						pst11.setString(2, lowPressureCompressor.getQuantity()[j]);
						pst11.setInt(3, max_count);
						i=pst11.executeUpdate();
						System.out.println("inserted part1");
						
					}
					
					PreparedStatement pmst1=conn.prepareStatement("SELECT MAX(lpc_id) FROM lpc_config_master");
					ResultSet result1=pmst1.executeQuery();
					if(result1.next())
					{
						max_count1=result1.getInt(1);
					}
					
					
					for(int k=0;k<lowPressureCompressor.getFlag().length;k++)
					{
						String flag=lowPressureCompressor.getFlag()[k];
						System.out.println("flag:"+flag);
						if(flag.equals("1")) 
						{
							String heading=lowPressureCompressor.getHeadingsOfspecifications()[k];
							PreparedStatement pst111=conn.prepareStatement("INSERT INTO `lpc_config_002`(`specifications`, `lpc_id`) VALUES (?,?)");
							pst111.setString(1, heading);
							pst111.setInt(2, max_count1);
							i=pst111.executeUpdate();
						}
						
						PreparedStatement pmst=conn.prepareStatement("SELECT MAX(lpc_sp_id) FROM lpc_config_002");
						ResultSet rs1=pmst.executeQuery();
						if(rs1.next())
						{
							max_count=rs1.getInt(1);
						}
						
						if(flag.equals("0"))
						{
							PreparedStatement pstmt1=conn.prepareStatement("INSERT INTO `lpc_config_003`(`quantity`, `lpc_sp_id`) VALUES (?,?)");
							
							pstmt1.setString(1, lowPressureCompressor.getHeadingsOfspecifications()[k]);
							pstmt1.setInt(2, max_count);
							
							i=pstmt1.executeUpdate();
							
							System.out.println("pstmt1:"+pstmt1);
							
							System.out.println("inserted part2");
						}

					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure(
			LowPressureCompressorModel lowPressureCompressor) {
			
		List<LowPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `image`, `machine_details1`, `machine_details2`, `technical_specifications`, `scope_of_supply` FROM `low_pressure_compressor_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LowPressureCompressorModel lowPressCompress=new LowPressureCompressorModel();
				lowPressCompress.setName_of_index(rs.getString(1));
				lowPressCompress.setImage(rs.getString(2));
				lowPressCompress.setMachine_details1(rs.getString(3));
				lowPressCompress.setMachine_details2(rs.getString(4));
				lowPressCompress.setTech_specifications(rs.getString(5));
				lowPressCompress.setScope_of_supply(rs.getString(6));
				
				list.add(lowPressCompress);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure1(LowPressureCompressorModel lowPressureCompressor){
			
			List<LowPressureCompressorModel> list=new ArrayList<>();
			
			Connection conn=connection.getConnection();
			try {
				
				PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity`, `lpc_id` FROM `low_pressure_compressor_details1`");
				
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					LowPressureCompressorModel lowPressCompress=new LowPressureCompressorModel();
					lowPressCompress.setSpecifi(rs.getString(1));
					lowPressCompress.setQty(rs.getString(2));
					list.add(lowPressCompress);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return list;
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure2(
			LowPressureCompressorModel lowPressureCompressor) {
		List<LowPressureCompressorModel> list=new ArrayList<>();
		
		int lpc_id;
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lpc_sp_id`, `specifications` FROM `low_pressure_compressor_details2`");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String flag="1";
				LowPressureCompressorModel lpc=new LowPressureCompressorModel();
				lpc_id=rs.getInt(1);
				lpc.setSpecificationsdetails(rs.getString(2));
				lpc.setStatus(flag);
				list.add(lpc);
				PreparedStatement pst1=conn.prepareStatement("SELECT `quantity` FROM `low_pressure_compressor_details3` WHERE lpc_sp_id="+lpc_id+"");
				ResultSet rs1=pst1.executeQuery();
				System.out.println("pst1:"+pst1);
				while(rs1.next())
				{
					String flag1="0";
					
					LowPressureCompressorModel lpc1=new LowPressureCompressorModel();
					lpc1.setSpecificationsdetails(rs1.getString(1));
					lpc1.setStatus(flag1);
					System.out.println("rs1:"+rs1.getString(1));
					list.add(lpc1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure3(
			LowPressureCompressorModel lowPressureCompressor,String lpc_id) {
		
		List<LowPressureCompressorModel> list=new ArrayList<>();
		int lpcId=Integer.parseInt(lpc_id);
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lpc_id`, `name_of_index`, `image`, `machine_details1`, `machine_details2`, `technical_specifications`, `scope_of_supply`, `quotation_name` FROM `lpc_config_master` WHERE lpc_id=?");
			pst.setInt(1,lpcId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LowPressureCompressorModel lowPressCompress=new LowPressureCompressorModel();
				lowPressCompress.setLpc_id(rs.getInt(1));
				lowPressCompress.setName_of_index(rs.getString(2));
				lowPressCompress.setImage(rs.getString(3));
				lowPressCompress.setMachine_details1(rs.getString(4));
				lowPressCompress.setMachine_details2(rs.getString(5));
				lowPressCompress.setTech_specifications(rs.getString(6));
				lowPressCompress.setScope_of_supply(rs.getString(7));
				lowPressCompress.setQuotation_name(rs.getString(8));
				
				list.add(lowPressCompress);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
		
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure4(
			LowPressureCompressorModel lowPressureCompressor,String lpc_id) {
		// TODO Auto-generated method stub
		int lpcId=Integer.parseInt(lpc_id);
		List<LowPressureCompressorModel> list=new ArrayList<>();
		
		Connection conn=connection.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `specifications`, `quantity` FROM `lpc_config_001` WHERE lpc_id=?");
			pst.setInt(1,lpcId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LowPressureCompressorModel lowPressCompress=new LowPressureCompressorModel();
				lowPressCompress.setSpecifi(rs.getString(1));
				lowPressCompress.setQty(rs.getString(2));
				list.add(lowPressCompress);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	public List<LowPressureCompressorModel> fetchLowPressureCompressure5(
			LowPressureCompressorModel lowPressureCompressor,String lpc_id) {
		// TODO Auto-generated method stub
		List<LowPressureCompressorModel> list=new ArrayList<>();
		int lap_sp_id;
		int lpcId=Integer.parseInt(lpc_id);
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lpc_sp_id`,`specifications`  FROM `lpc_config_002` WHERE lpc_id=?");
			pst.setInt(1, lpcId);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				String flag="1";
				LowPressureCompressorModel lpc=new LowPressureCompressorModel();
				lap_sp_id=rs.getInt(1);
				lpc.setSpecificationsdetails(rs.getString(2));
				lpc.setStatus(flag);
				list.add(lpc);
				PreparedStatement pst1=conn.prepareStatement("SELECT `quantity` FROM `lpc_config_003` WHERE lpc_sp_id=?");
				pst1.setInt(1, lap_sp_id);
				ResultSet rs1=pst1.executeQuery();
				System.out.println("pst1:"+pst1);
				while(rs1.next())
				{
					String flag1="0";
					
					LowPressureCompressorModel lpc1=new LowPressureCompressorModel();
					lpc1.setSpecificationsdetails(rs1.getString(1));
					lpc1.setStatus(flag1);
					System.out.println("rs1:"+rs1.getString(1));
					list.add(lpc1);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	public int updateLPCDetails(LowPressureCompressorModel lowPressureCompressor,String lpc_id) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		int lpcId=Integer.parseInt(lpc_id);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `lpc_config_master` SET `name_of_index`=?,`image`=?,`machine_details1`=?,`machine_details2`=?,`technical_specifications`=?,`scope_of_supply`=?,`quotation_name`=? WHERE lpc_id=?");
			
			pst.setString(1, lowPressureCompressor.getName_of_index());
			pst.setString(2, lowPressureCompressor.getImage());
			pst.setString(3, lowPressureCompressor.getMachine_details1());
			pst.setString(4, lowPressureCompressor.getMachine_details2());
			pst.setString(5, lowPressureCompressor.getTech_specifications());
			pst.setString(6, lowPressureCompressor.getScope_of_supply());
			pst.setString(7, lowPressureCompressor.getQuotation_name());
			pst.setInt(8,lpcId);
			
			i=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	try {
			
			try {
				
				PreparedStatement pst1111=conn.prepareStatement("DELETE FROM `lpc_config_001` WHERE lpc_id=?");
				pst1111.setInt(1, lpcId);
				i=pst1111.executeUpdate();
				System.out.println("lpc:"+pst1111);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			for(int j=0;j<lowPressureCompressor.getSpecifications().length;j++)
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lpc_config_001`(`specifications`, `quantity`, `lpc_id`) VALUES (?,?,?)");
				pst11.setString(1, lowPressureCompressor.getSpecifications()[j]);
				pst11.setString(2, lowPressureCompressor.getQuantity()[j]);
				pst11.setInt(3, lpcId);
				i=pst11.executeUpdate();
				System.out.println("inserted part1");
				
			}
			
			try {
				
				PreparedStatement pst2=conn.prepareStatement("DELETE lpc_config_002,lpc_config_003 FROM lpc_config_002 INNER JOIN lpc_config_003 ON lpc_config_002.lpc_sp_id=lpc_config_003.lpc_sp_id WHERE lpc_config_002.lpc_id=?");
				pst2.setInt(1, lpcId);
				i=pst2.executeUpdate();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			for(int k=0;k<lowPressureCompressor.getFlag().length;k++)
			{
				String flag=lowPressureCompressor.getFlag()[k];
				System.out.println("flag:"+flag);
				if(flag.equals("1")) 
				{
					String heading=lowPressureCompressor.getHeadingsOfspecifications()[k];
					PreparedStatement pst111=conn.prepareStatement("INSERT INTO `lpc_config_002`(`specifications`, `lpc_id`) VALUES (?,?)");
					pst111.setString(1, heading);
					pst111.setInt(2, lpcId);
					i=pst111.executeUpdate();
				}
				
				PreparedStatement pmst=conn.prepareStatement("SELECT MAX(lpc_sp_id) FROM lpc_config_002");
				ResultSet rs1=pmst.executeQuery();
				if(rs1.next())
				{
					max_count=rs1.getInt(1);
				}
				
				if(flag.equals("0"))
				{
					PreparedStatement pstmt1=conn.prepareStatement("INSERT INTO `lpc_config_003`(`quantity`, `lpc_sp_id`) VALUES (?,?)");
					
					pstmt1.setString(1, lowPressureCompressor.getHeadingsOfspecifications()[k]);
					pstmt1.setInt(2, max_count);
					
					i=pstmt1.executeUpdate();
					
					System.out.println("pstmt1:"+pstmt1);
					
					System.out.println("inserted part2");
				}

			}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
	
	}

	public int deleteLPCDetails(LowPressureCompressorModel lowPressureCompressor, String lpc_id) {
		// TODO Auto-generated method stub
		int i=0;
		int lpcId=Integer.parseInt(lpc_id);
		
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lpc_config_master` WHERE lpc_id=?");
			pst.setInt(1, lpcId);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `lpc_config_001` WHERE lpc_id=?");
			pst1.setInt(1, lpcId);
			i=pst1.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			PreparedStatement pst2=conn.prepareStatement("DELETE lpc_config_002,lpc_config_003 FROM lpc_config_002 INNER JOIN lpc_config_003 ON lpc_config_002.lpc_sp_id=lpc_config_003.lpc_sp_id WHERE lpc_config_002.lpc_id=?");
			pst2.setInt(1, lpcId);
			i=pst2.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

}
