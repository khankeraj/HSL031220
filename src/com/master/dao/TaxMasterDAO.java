package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.TaxMasterModel;

public class TaxMasterDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_tax_master(TaxMasterModel taxmodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `tax_master`(`tax_percentage`) VALUES (?)");
			pst.setString(1, taxmodel.getTax_per());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}

	public List<TaxMasterModel> fetchTaxReports(TaxMasterModel taxmodel) {
		// TODO Auto-generated method stub
		List<TaxMasterModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `tax_percentage` FROM `tax_master` WHERE 1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TaxMasterModel taxmaster=new TaxMasterModel();
				taxmaster.setId(rs.getInt(1));
				taxmaster.setTax_per(rs.getString(2));
				list.add(taxmaster);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<TaxMasterModel> fetchForUpdate(TaxMasterModel taxmodel, int tax_id) {
		// TODO Auto-generated method stub
		List<TaxMasterModel> list=new ArrayList<>();
		PreparedStatement pst;
		
		try {
			pst = conn.prepareStatement("SELECT `id`, `tax_percentage` FROM `tax_master` WHERE id="+tax_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TaxMasterModel taxmodel1=new TaxMasterModel();
				taxmodel1.setId(rs.getInt(1));
				taxmodel1.setTax_per(rs.getString(2));
				list.add(taxmodel1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int deleteTax(TaxMasterModel taxmodel, int tax_id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `tax_master` WHERE id="+tax_id+"");
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int updateTaxMaster(TaxMasterModel taxmodel, int update_tax_id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `tax_master` SET `tax_percentage`=? WHERE `id`="+update_tax_id+"");
			pst.setString(1, taxmodel.getTax_per());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	

}
