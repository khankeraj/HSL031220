package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.GstTaxMasterModel;

public class GstTaxMasterDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_gstTaxMaster(GstTaxMasterModel gsttaxmodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `gst_tax_master`(`hsn_code`, `tax_per`) VALUES (?,?)");
			pst.setString(1, gsttaxmodel.getHsn_code());
			pst.setString(2, gsttaxmodel.getTax_percentage());
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<GstTaxMasterModel> fetchGstTaxReports(GstTaxMasterModel gsttaxmodel) {
		// TODO Auto-generated method stub
		List<GstTaxMasterModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `hsn_code`, `tax_per` FROM `gst_tax_master` WHERE 1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				GstTaxMasterModel gstTaxMasterModel=new GstTaxMasterModel();
				gstTaxMasterModel.setId(rs.getInt(1));
				gstTaxMasterModel.setHsn_code(rs.getString(2));
				gstTaxMasterModel.setTax_percentage(rs.getString(3));
				list.add(gstTaxMasterModel);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
