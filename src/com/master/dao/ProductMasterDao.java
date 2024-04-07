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
import com.master.model.DriverModel;
import com.master.model.ProductModel;


public class ProductMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public int insert_product_Details(ProductModel productmodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
						
			
			PreparedStatement psac = conn.prepareStatement("select * from product_master where product_name = '"+productmodel.getProduct_name()+"'");
			ResultSet rsac = psac.executeQuery();
			
			if(rsac.next())
			{
				return -1;
			}
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `product_master` (`product_name`, `remark`, `hsn_code`, `tax_per`) values(?, ?, ?, ?)");
			pst.setString(1, productmodel.getProduct_name());
			pst.setString(2, productmodel.getRemark());
			pst.setString(3, productmodel.getHsn_code());
			pst.setString(4, productmodel.getTax_percentage());
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
public List<ProductModel> fetchProductMasterDetails() {
	// TODO Auto-generated method stub
List<ProductModel> list=new ArrayList<ProductModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `product_name`, `remark`, `hsn_code`, `tax_per` FROM `product_master`");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				ProductModel productModel=new ProductModel();
				
				productModel.setProduct_id(rs.getString(1));
				productModel.setProduct_name(rs.getString(2));
				productModel.setRemark(rs.getString(3));
				productModel.setHsn_code(rs.getString(4));
				productModel.setTax_percentage(rs.getString(5));
				list.add(productModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public int deleteProduct_master(ProductModel product_model, String delete_product_id) {
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
}




public List<ProductModel> fetchForUpdateProductDetailss(ProductModel product_model, String product_id) {
	// TODO Auto-generated method stub
List<ProductModel> list=new ArrayList<ProductModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `product_name`, `remark`, `hsn_code`, `tax_per` from product_master WHERE id='"+product_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			ProductModel productModel=new ProductModel();
			productModel.setProduct_id(rs.getString(1));
			productModel.setProduct_name(rs.getString(2));
			productModel.setRemark(rs.getString(3));
			productModel.setHsn_code(rs.getString(4));
			productModel.setTax_percentage(rs.getString(5));
			
			list.add(productModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}





public int update_product_details(ProductModel productmodel, String update_product) {
	// TODO Auto-generated method stub
	int i=0;
	int product_id=Integer.parseInt(update_product);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `product_master` SET `product_name`=?, `remark`=?, `hsn_code`=?, `tax_per`=? WHERE `id`=?");
		
		pst.setString(1, productmodel.getProduct_name());
		pst.setString(2, productmodel.getRemark());
		pst.setString(3, productmodel.getHsn_code());
		pst.setString(4, productmodel.getTax_percentage());
		
		pst.setInt(5, product_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}




public int insert_expense_Details(ProductModel productmodel) {
	// TODO Auto-generated method stub
	int i=0;
	try {
					
		
		PreparedStatement ps = conn.prepareStatement("select * from exp_part_master where name = '"+productmodel.getExp_parti()+"'");
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			return -1;
		}
		
		
		
		
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
}
public List<ProductModel> fetchExpenseMasterDetails() {
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
}
public List<ProductModel> fetchForUpdateExpenseDetailss(String expense_id) {
	// TODO Auto-generated method stub
List<ProductModel> list=new ArrayList<ProductModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `name`, `remark` from exp_part_master WHERE id='"+expense_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			ProductModel productModel=new ProductModel();
			productModel.setExpense_id(rs.getString(1));
			productModel.setExp_parti(rs.getString(2));
			productModel.setRemark(rs.getString(3));
			
			list.add(productModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

}
public int update_expense_details(ProductModel productmodel, String update_expense) {
	// TODO Auto-generated method stub
	int i=0;
	int expense_id=Integer.parseInt(update_expense);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `exp_part_master` SET `name`=?, `remark`=? WHERE `id`=?");
		
		pst.setString(1, productmodel.getExp_parti());
		pst.setString(2, productmodel.getRemark());
		
		pst.setInt(3, expense_id);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public int deleteExpense_master(ProductModel product_model, String delete_expense_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `exp_part_master` WHERE id="+delete_expense_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
}

