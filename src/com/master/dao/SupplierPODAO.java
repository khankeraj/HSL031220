package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.master.model.SupplierPOModel;

public class SupplierPODAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_supplier_Details(SupplierPOModel supplierPo) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO supplier_po(supplier_po_status,customer_name) VALUES (?,?)");
			pst.setString(1, supplierPo.getSupplier_po_status());
			pst.setString(2, supplierPo.getCustomer_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted Succesfully");
				 PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+supplierPo.getCustomer_name()+"'");
				 ResultSet rs=pst1.executeQuery();
				 if(rs.next())
				 {
					 int lead_id=Integer.parseInt(rs.getString(1));
					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `suppo`='YES' WHERE status_master.lead_id="+lead_id+"");
				     i=pst2.executeUpdate();
					 if(i>0)
					 {
						 System.out.println("Updated SuccessFully...!!!");
					 }
				 }
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

}
