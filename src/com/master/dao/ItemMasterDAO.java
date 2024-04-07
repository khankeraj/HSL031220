package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.ItemMasterModel;
import com.sun.mail.imap.protocol.Item;

public class ItemMasterDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	

	public int insert_item_master(ItemMasterModel itemmaster) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `item_master`(`item_name`, `part_no`, `unit`, `buy_price`, `sale_price`, `hsn_code`, `tax_per`, `minimum_qty`) VALUES (?,?,?,?,?,?,?,?)");
			pst.setString(1, itemmaster.getItem_name());
			pst.setString(2, itemmaster.getPart_no());
			pst.setString(3, itemmaster.getUnit());
			pst.setString(4, itemmaster.getBuy_price());
			pst.setString(5, itemmaster.getSale_price());
			pst.setString(6, itemmaster.getHsn_code());
			pst.setString(7, itemmaster.getTax_per());
			pst.setString(8, itemmaster.getMinimum_quantity());
			
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	public String fetchTaxPercentage(ItemMasterModel itemmaster,String hsncode) {
		// TODO Auto-generated method stub
		String response = null;
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `tax_per` FROM `gst_tax_master` WHERE `hsn_code`='"+hsncode+"'");
			ResultSet rs=pst.executeQuery();
			System.out.println("pst:"+pst);
			while(rs.next())
			{
				
				response=rs.getString(1);
				
				System.out.println("tax:"+rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public List<ItemMasterModel> fetchReports(ItemMasterModel itemmaster) {
		// TODO Auto-generated method stub
		List<ItemMasterModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `item_name`, `unit`, `buy_price`, `sale_price`, `hsn_code`, `tax_per`,`id` FROM `item_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ItemMasterModel itemMaster1=new ItemMasterModel();
				itemMaster1.setItem_name(rs.getString(1));
				itemMaster1.setUnit(rs.getString(2));
				itemMaster1.setBuy_price(rs.getString(3));
				itemMaster1.setSale_price(rs.getString(4));
				itemMaster1.setHsn_code(rs.getString(5));
				itemMaster1.setTax_per(rs.getString(6));
				itemMaster1.setId(rs.getInt(7));
				list.add(itemMaster1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public String fetchItemDetails(ItemMasterModel itemmaster,String item_name) {
		// TODO Auto-generated method stub
		String response = null;
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `sale_price`, `hsn_code`, `tax_per` FROM `item_master` WHERE item_name='"+item_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				response=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
