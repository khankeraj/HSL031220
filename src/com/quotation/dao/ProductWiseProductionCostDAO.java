package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.ProductWiseProductionCostModel;

public class ProductWiseProductionCostDAO {
	
	DBConnection connections=new DBConnection();
	

	public int insert_productWiseProductions(ProductWiseProductionCostModel productWiseProduction) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		try {
			Connection conn=connections.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `product_wise_prod_cost_config_master`(`name_of_index`, `heading1`, `heading2`, `quotation_name`) VALUES (?,?,?,?)");
			pst.setString(1, productWiseProduction.getName_of_index());
			pst.setString(2, productWiseProduction.getHeading1());
			pst.setString(3, productWiseProduction.getHeading2());
			pst.setString(4, productWiseProduction.getQuotation_name());
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(product_wise_prod_cost_config_master.pwpc_id) FROM product_wise_prod_cost_config_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
				
					max_count=Integer.parseInt(rs.getString(1));
				
					for(int j=0;j<productWiseProduction.getParticulars().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `pwpc_config_002`(`particulars`, `1ltr(R)`, `pwpc_id`) VALUES (?,?,?)");
						pst11.setString(1, productWiseProduction.getParticulars()[j]);
						pst11.setString(2, productWiseProduction.getLTR()[j]);
						pst11.setInt(3, max_count);
						
						i=pst11.executeUpdate();
					}
					
					for(int k=0;k<productWiseProduction.getRequirment().length;k++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `pwpc_config_001`(`requirement`, `quantity`, `pwpc_id`) VALUES (?,?,?)");
						pst111.setString(1, productWiseProduction.getRequirment()[k]);
						pst111.setString(2, productWiseProduction.getQuantity()[k]);
						pst111.setInt(3, max_count);
						
						i=pst111.executeUpdate();
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost(ProductWiseProductionCostModel productWiseProduction) {
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		Connection conn=connections.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `heading1`, `heading2` FROM `product_wise_productioncost_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setName_of_index(rs.getString(1));
				pwpc.setHeading1(rs.getString(2));
				pwpc.setHeading2(rs.getString(3));
				list.add(pwpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost1(
			ProductWiseProductionCostModel productWiseProduction) {
		// TODO Auto-generated method stub
		
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		Connection conn=connections.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `1ltr(R)` FROM `product_wise_productioncost_bydefaultdet`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setParti(rs.getString(1));
				pwpc.setLtr(rs.getString(2));
				list.add(pwpc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost2(
			ProductWiseProductionCostModel productWiseProduction) {
		// TODO Auto-generated method stub
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		Connection conn=connections.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `requirement`, `quantity` FROM `product_wise_productioncost_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setReq(rs.getString(1));
				pwpc.setQty(rs.getString(2));
				list.add(pwpc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost3(
			ProductWiseProductionCostModel productWiseProduction,String pwpc_id) {
		// TODO Auto-generated method stub
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		int pwpcId=Integer.parseInt(pwpc_id);
		Connection conn=connections.getConnection();
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `pwpc_id`, `name_of_index`, `heading1`, `heading2`, `quotation_name` FROM `product_wise_prod_cost_config_master` WHERE pwpc_id=?");
			pst.setInt(1, pwpcId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setPwproduction_id(rs.getInt(1));
				pwpc.setName_of_index(rs.getString(2));
				pwpc.setHeading1(rs.getString(3));
				pwpc.setHeading2(rs.getString(4));
				pwpc.setQuotation_name(rs.getString(5));
				
				list.add(pwpc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost4(
			ProductWiseProductionCostModel productWiseProduction,String pwpc_id) {
		// TODO Auto-generated method stub
		int pwpcId=Integer.parseInt(pwpc_id);
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		Connection conn=connections.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `requirement`, `quantity` FROM `pwpc_config_001` WHERE pwpc_id=?");
			pst.setInt(1, pwpcId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setParti(rs.getString(1));
				pwpc.setLtr(rs.getString(2));
				list.add(pwpc);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}


	public List<ProductWiseProductionCostModel> fetchProductWiseProductionCost5(
			ProductWiseProductionCostModel productWiseProduction,String pwpc_id) {
		// TODO Auto-generated method stub
		int pwpcId=Integer.parseInt(pwpc_id);
		
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		Connection conn=connections.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `1ltr(R)` FROM `pwpc_config_002` WHERE pwpc_id=?");
			pst.setInt(1, pwpcId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setReq(rs.getString(1));
				pwpc.setQty(rs.getString(2));
				list.add(pwpc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public int updatePWPC(ProductWiseProductionCostModel productWiseProduction, String pwpc_id) {
		// TODO Auto-generated method stub
		int pwpcId=Integer.parseInt(pwpc_id);
		int i=0;
		int max_count=0;
		
		Connection conn=connections.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `product_wise_prod_cost_config_master` SET `name_of_index`=?,`heading1`=?,`heading2`=?,`quotation_name`=? WHERE `pwpc_id`=?");
			pst.setString(1, productWiseProduction.getName_of_index());
			pst.setString(2, productWiseProduction.getHeading1());
			pst.setString(3, productWiseProduction.getHeading2());
			pst.setString(4, productWiseProduction.getQuotation_name());
			pst.setInt(5, pwpcId);
			
			i=pst.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
				
					PreparedStatement pst2=conn.prepareStatement("DELETE FROM `pwpc_config_002` WHERE pwpc_id=?");
					pst2.setInt(1, pwpcId);
					i=pst2.executeUpdate();
					
					for(int j=0;j<productWiseProduction.getParticulars().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `pwpc_config_002`(`particulars`, `1ltr(R)`, `pwpc_id`) VALUES (?,?,?)");
						pst11.setString(1, productWiseProduction.getParticulars()[j]);
						pst11.setString(2, productWiseProduction.getLTR()[j]);
						pst11.setInt(3, pwpcId);
						
						i=pst11.executeUpdate();
					}
					
					PreparedStatement pst21=conn.prepareStatement("DELETE FROM `pwpc_config_001` WHERE pwpc_id=?");
					pst21.setInt(1, pwpcId);
					i=pst21.executeUpdate();
					
					for(int k=0;k<productWiseProduction.getRequirment().length;k++)
					{
						PreparedStatement pst111=conn.prepareStatement("INSERT INTO `pwpc_config_001`(`requirement`, `quantity`, `pwpc_id`) VALUES (?,?,?)");
						pst111.setString(1, productWiseProduction.getRequirment()[k]);
						pst111.setString(2, productWiseProduction.getQuantity()[k]);
						pst111.setInt(3, pwpcId);
						
						i=pst111.executeUpdate();
					}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	public int DeletePWPC(ProductWiseProductionCostModel productWiseProduction, String pwpc_id) {
		// TODO Auto-generated method stub
		Connection conn=connections.getConnection();
		int pwpcId=Integer.parseInt(pwpc_id);
		int i=0;
		
		try {
			PreparedStatement pstmt=conn.prepareStatement("DELETE FROM `product_wise_prod_cost_config_master` WHERE pwpc_id=?");
			pstmt.setInt(1, pwpcId);
			i=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pstmt1=conn.prepareStatement("DELETE FROM `pwpc_config_001` WHERE pwpc_id=?");
			pstmt1.setInt(1, pwpcId);
			i=pstmt1.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pstmt2=conn.prepareStatement("DELETE FROM `pwpc_config_002` WHERE pwpc_id=?");
			pstmt2.setInt(1, pwpcId);
			i=pstmt2.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

}
