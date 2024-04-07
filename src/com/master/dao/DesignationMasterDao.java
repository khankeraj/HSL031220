package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.CityModel;
import com.master.model.CustomerMasterModel;
import com.master.model.DesignationModel;
import com.master.model.DriverModel;
import com.master.model.ProductModel;


public class DesignationMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public int insert_designation_Details(DesignationModel designationmodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
						
			
			PreparedStatement ps = conn.prepareStatement("select * from designation where designation_name = '"+designationmodel.getDesignation_name()+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return -1;
			}
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `designation` (`designation_name`, `remark`) values(?, ?)");
			pst.setString(1, designationmodel.getDesignation_name());
			pst.setString(2, designationmodel.getRemark());
			
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
/*public List<ProductModel> fetchProductMasterDetails() {
	// TODO Auto-generated method stub
List<ProductModel> list=new ArrayList<ProductModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `product_name`, `remark` FROM `product_master`");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				ProductModel productModel=new ProductModel();
				
				productModel.setProduct_id(rs.getString(1));
				productModel.setProduct_name(rs.getString(2));
				productModel.setRemark(rs.getString(3));
				
				list.add(productModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}*/
/*public int deleteProduct_master(ProductModel product_model, String delete_product_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `product_master` WHERE id="+delete_product_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}*/
/*public List<ProductModel> fetchForUpdateProductDetailss(ProductModel product_model, String product_id) {
	// TODO Auto-generated method stub
List<ProductModel> list=new ArrayList<ProductModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `product_name`, `remark` from product_master WHERE id='"+product_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			ProductModel productModel=new ProductModel();
			productModel.setProduct_id(rs.getString(1));
			productModel.setProduct_name(rs.getString(2));
			productModel.setRemark(rs.getString(3));
			
			list.add(productModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}*/
/*public int update_product_details(ProductModel productmodel, String update_product) {
	// TODO Auto-generated method stub
	int i=0;
	int product_id=Integer.parseInt(update_product);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `product_master` SET `product_name`=?, `remark`=? WHERE `id`=?");
		
		pst.setString(1, productmodel.getProduct_name());
		pst.setString(2, productmodel.getRemark());
		
		pst.setInt(3, product_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}*/
/*public int insert_expense_Details(ProductModel productmodel) {
	// TODO Auto-generated method stub
	int i=0;
	try {
					
		
		
		
		
		
		
		PreparedStatement pst = conn.prepareStatement("insert into `exp_part_master` (`name`, `remark`) values(?, ?)");
		pst.setString(1, productmodel.getExp_parti());
		pst.setString(2, productmodel.getRemark());
		
		
		i=pst.executeUpdate();
		
		System.out.println("i:"+i+"pst:"+pst);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return i;
}*/
/*public List<ProductModel> fetchExpenseMasterDetails() {
	// TODO Auto-generated method stub
	List<ProductModel> list = new ArrayList<ProductModel>();
	try {
		
		
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `name`, `remark` FROM `exp_part_master`");
		ResultSet rs=pst.executeQuery();
		System.out.println("1...."+pst);
		while(rs.next())
		{
			ProductModel productModel=new ProductModel();
			
			productModel.setExpense_id(rs.getString(1));
			productModel.setExp_parti(rs.getString(2));
			productModel.setRemark(rs.getString(3));
			
			list.add(productModel);
		}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return list;
}*/
public List<DesignationModel> fetchDesigantionMasterDetails() {
	// TODO Auto-generated method stub
	List<DesignationModel> list = new ArrayList<DesignationModel>();
	try {
		
		
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `designation_name`, `remark` FROM `designation`");
		ResultSet rs=pst.executeQuery();
		System.out.println("1...."+pst);
		while(rs.next())
		{
			DesignationModel designationModel=new DesignationModel();
			
			/*productModel.setExpense_id(rs.getString(1));
			productModel.setExp_parti(rs.getString(2));
			productModel.setRemark(rs.getString(3));*/
			
			designationModel.setDesignation_id(rs.getString(1));
			designationModel.setDesignation_name(rs.getString(2));
			designationModel.setRemark(rs.getString(3));
			
			list.add(designationModel);
		}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return list;
}

public List<DesignationModel> fetchForUpdateDesignationDetailss(String designation_id) {
	// TODO Auto-generated method stub
List<DesignationModel> list=new ArrayList<DesignationModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `designation_name`, `remark` from designation WHERE id='"+designation_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			DesignationModel designationModel=new DesignationModel();
			designationModel.setDesignation_id(rs.getString(1));
			designationModel.setDesignation_name(rs.getString(2));
			designationModel.setRemark(rs.getString(3));
			
			list.add(designationModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}
public int update_designation_details(DesignationModel designationmodel, String update_designation) {
	// TODO Auto-generated method stub
	int i=0;
	int designation_id=Integer.parseInt(update_designation);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `designation` SET `designation_name`=?, `remark`=? WHERE `id`=?");
		
		pst.setString(1, designationmodel.getDesignation_name());
		pst.setString(2, designationmodel.getRemark());
		
		pst.setInt(3, designation_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public int deleteDesignation_master(String delete_designation_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `designation` WHERE id="+delete_designation_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
}


