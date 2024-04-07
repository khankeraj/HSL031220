package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.BankMasterModel;

public class BankMasterDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public int insert_bank_details(BankMasterModel bankmastermodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
				PreparedStatement pst=conn.prepareStatement("INSERT INTO `bank_master`(`bank_name`, `branch_name`, `status`) VALUES (?,?,?)");
				pst.setString(1, bankmastermodel.getBank_name());
				pst.setString(2, bankmastermodel.getBranch_name());
				pst.setInt(3, bankmastermodel.getBank_id());
				
				i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public List<BankMasterModel> fetchBankMaster(BankMasterModel bankmastermodel) {
		// TODO Auto-generated method stub
		List<BankMasterModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `bank_id`, `bank_name`, `branch_name` FROM `bank_master` WHERE 1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				BankMasterModel bankmodel=new BankMasterModel();
				bankmodel.setBank_id(rs.getInt(1));
				bankmodel.setBank_name(rs.getString(2));
				bankmodel.setBranch_name(rs.getString(3));
				list.add(bankmodel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
