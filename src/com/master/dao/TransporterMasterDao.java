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
import com.master.model.EmployeeMasterModel;
import com.master.model.ProductModel;
import com.master.model.TransporterModel;


public class TransporterMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public int insert_transporter_Details(TransporterModel transportermodel) {
		// TODO Auto-generated method stub
		int i=0;
		String stringValue4 = "";
		String stringValue5 = "";
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from transporter_master where transporter_name = '"+transportermodel.getTransporter_name()+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return -1;
			}
			
			
			
						
			int len2 = 0;
			PreparedStatement preparedStatement4 = conn
					.prepareStatement("select  max(SUBSTRING(transporter_no,-4)) as myval1 from transporter_master");
			
			
			String mystr3 = "";
			int myval3 = 0;
			ResultSet resultSet3 = preparedStatement4.executeQuery();
			
			if (resultSet3.next()) {
				try {
					mystr3 = resultSet3.getString("myval1");
					myval3 = Integer.parseInt(mystr3);
					myval3 = myval3 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval3 = 1;
					mystr3 = "";
				}
			}
			
			
			int size3 = len2 + 1;
			stringValue5 = String.valueOf(myval3);
			
				if (stringValue5.length() == 1) {
					stringValue5 = "TSP/" + "000" + stringValue5;
				} else if (stringValue5.length() == 2) {
					stringValue5 = "TSP/" + "00" + stringValue5;
				} else if (stringValue5.length() == 3) {
					stringValue5 = "TSP/" + "0" + stringValue5;
				} else {
					stringValue5 = "TSP/" + stringValue5;
				}
				
				transportermodel.setTransporter_no(stringValue5);	
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `transporter_master` (`transporter_no`, `transporter_name`, `company_name`, `transporter_address`, `mobile`, `phone_no`, `state`, `city`, `pan_no`, `pincode_no`, `email`, `bank_name`, `account_no`, `ifsc_code`, `remark`,`branch`,`location`,`gstn`) values(?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, transportermodel.getTransporter_no());
			pst.setString(2, transportermodel.getTransporter_name());
			pst.setString(3, transportermodel.getCompany_name());
			pst.setString(4, transportermodel.getTransporter_address());
			pst.setString(5, transportermodel.getTransporter_mobile());
			pst.setString(6, transportermodel.getPhone_no());
			pst.setString(7, transportermodel.getState());
			pst.setString(8, transportermodel.getCity());
			pst.setString(9, transportermodel.getPan_no());
			pst.setString(10, transportermodel.getPincode_no());
			pst.setString(11, transportermodel.getEmail());
			pst.setString(12, transportermodel.getBank_name());
			pst.setString(13, transportermodel.getAccount_no());
			pst.setString(14, transportermodel.getIfsc_code());
			pst.setString(15, transportermodel.getRemark());
			
			pst.setString(16, transportermodel.getBranch());
			pst.setString(17, transportermodel.getLoc());
			pst.setString(18, transportermodel.getGstn());
			
			
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
}
public int update_product_details(ProductModel productmodel, String update_product) {
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
}
public int insert_expense_Details(ProductModel productmodel) {
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

public List<TransporterModel> fetchTransporterMasterDetails() {
	// TODO Auto-generated method stub
	List<TransporterModel> list = new ArrayList<TransporterModel>();
	try {
		
		
		PreparedStatement pst=conn.prepareStatement("SELECT * FROM `transporter_master`");
		ResultSet rs=pst.executeQuery();
		System.out.println("1...."+pst);
		while(rs.next())
		{
			TransporterModel transporterModel=new TransporterModel();
			
			/*productModel.setExpense_id(rs.getString(1));
			productModel.setExp_parti(rs.getString(2));
			productModel.setRemark(rs.getString(3));*/
			transporterModel.setTransporter_id(rs.getInt("id"));
			transporterModel.setTransporter_no(rs.getString("transporter_no"));
			transporterModel.setTransporter_name(rs.getString("transporter_name"));
			transporterModel.setCompany_name(rs.getString("company_name"));
			transporterModel.setTransporter_address(rs.getString("transporter_address"));
			transporterModel.setTransporter_mobile(rs.getString("mobile"));
			transporterModel.setPhone_no(rs.getString("phone_no"));
			transporterModel.setState(rs.getString("state"));
			transporterModel.setCity(rs.getString("city"));
			transporterModel.setPan_no(rs.getString("pan_no"));
			transporterModel.setPincode_no(rs.getString("pincode_no"));
			transporterModel.setEmail(rs.getString("email"));
			transporterModel.setBank_name(rs.getString("bank_name"));
			transporterModel.setAccount_no(rs.getString("account_no"));
			transporterModel.setIfsc_code(rs.getString("ifsc_code"));
			transporterModel.setRemark(rs.getString("remark"));
			
			
			
			list.add(transporterModel);
		}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return list;
}
public List<TransporterModel> fetchForUpdateTransporterDetailss(String transporter_id) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
	List<TransporterModel> list=new ArrayList<TransporterModel>();
	int t_id = Integer.parseInt(transporter_id);
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT * from transporter_master WHERE id="+t_id+"");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			/*EmployeeMasterModel employeeModel=new EmployeeMasterModel();
			employeeModel.setEmployee_id(rs.getInt(1));
			employeeModel.setEmployee_name(rs.getString(2));
			employeeModel.setAddress(rs.getString(3));
			employeeModel.setMobile_no(rs.getString(4));
			employeeModel.setDate_of_joining(rs.getString(5));
			employeeModel.setDate_of_birth(rs.getString(6));
			employeeModel.setDesignation(rs.getString(7));
			employeeModel.setBank_name(rs.getString(8));
			employeeModel.setAccount_no(rs.getString(9));
			employeeModel.setIfsc_code(rs.getString(10));
			employeeModel.setRemark(rs.getString(11));*/
			
			TransporterModel model = new TransporterModel();
			model.setTransporter_id(rs.getInt("id"));
			model.setTransporter_name(rs.getString("transporter_name"));
			model.setCompany_name(rs.getString("company_name"));
			model.setTransporter_address(rs.getString("transporter_address"));
			model.setTransporter_mobile(rs.getString("mobile"));
			model.setPhone_no(rs.getString("phone_no"));
			model.setState(rs.getString("state"));
			model.setCity(rs.getString("city"));
			model.setPan_no(rs.getString("pan_no"));
			model.setPincode_no(rs.getString("pincode_no"));
			model.setEmail(rs.getString("email"));
			model.setBank_name(rs.getString("bank_name"));
			model.setAccount_no(rs.getString("account_no"));
			model.setIfsc_code(rs.getString("ifsc_code"));
			model.setRemark(rs.getString("remark"));
			
			
			model.setBranch(rs.getString("branch"));
			model.setLoc(rs.getString("location"));
			model.setGstn(rs.getString("gstn"));
			
			
			list.add(model);
			System.out.println("here");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;


}
public int update_transporter_details(TransporterModel transportermodel, String update_transporter) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub
	int i=0;
	System.out.println("update_transporter: "+update_transporter);
	int transporter_id=Integer.parseInt(update_transporter);
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `transporter_master` SET `transporter_name`=?, `company_name`=?, `transporter_address`=?, `mobile`=?, `phone_no`=?, `state`=?, `city`=?, `pan_no`=?, `pincode_no`=?, `email`=?, `bank_name`=?, `account_no`=?, `ifsc_code`=?, remark=?,branch=?,location=?,gstn=?   WHERE `id`=? ");
		
		pst.setString(1, transportermodel.getTransporter_name());
		pst.setString(2, transportermodel.getCompany_name());
		pst.setString(3, transportermodel.getTransporter_address());
		pst.setString(4, transportermodel.getTransporter_mobile());
		pst.setString(5, transportermodel.getPhone_no());
		pst.setString(6, transportermodel.getState());
		pst.setString(7, transportermodel.getCity());
		pst.setString(8, transportermodel.getPan_no());
		pst.setString(9, transportermodel.getPincode_no());
		pst.setString(10, transportermodel.getEmail());
		pst.setString(11, transportermodel.getBank_name());
		pst.setString(12, transportermodel.getAccount_no());
		pst.setString(13, transportermodel.getIfsc_code());
		pst.setString(14, transportermodel.getRemark());
		
		
		pst.setString(15, transportermodel.getBranch());
		pst.setString(16, transportermodel.getLoc());
		pst.setString(17, transportermodel.getGstn());
		
		
		
		pst.setInt(18, transporter_id);
		
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;

}
public int deleteTransporter_master(String delete_transporter_id) {
	int transporter_id = Integer.parseInt(delete_transporter_id);
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `transporter_master` WHERE id="+transporter_id+"");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}

}

