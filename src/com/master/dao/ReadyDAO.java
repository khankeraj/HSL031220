package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.master.model.ReadyModel;

public class ReadyDAO {

	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_ready_details(ReadyModel readyModel) {
		// TODO Auto-generated method stub
		int i=0;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("INSERT INTO ready_details(ready_status,customer_name) VALUES (?,?)");
			pst.setString(1, readyModel.getReady_status());
			pst.setString(2, readyModel.getCustomer_name());
			 i=pst.executeUpdate();
			 if(i>0)
				{
				 System.out.println("inserted Succesfully");
				 PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+readyModel.getCustomer_name()+"'");
				 ResultSet rs=pst1.executeQuery();
				 if(rs.next())
				 {
					 int lead_id=Integer.parseInt(rs.getString(1));
					 //PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `ready`='YES' WHERE status_master.lead_id="+lead_id+"");
					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `ready`='YES' WHERE status_master.status_id="+lead_id+"");
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
