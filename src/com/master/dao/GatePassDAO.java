package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DB.DBConnection;
import com.master.model.GatePassModel;

public class GatePassDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	public int insertGatePassMaster(GatePassModel gatepassmodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `gate_pass_master`(`lead_no`, `date`, `gp_no`, `customer_name`, `issue_emp`) VALUES (?,?,?,?,?)");
			pst.setString(1, gatepassmodel.getLead_no());
			pst.setString(2, gatepassmodel.getReqDate());
			pst.setString(3, gatepassmodel.getGpno());
			pst.setString(4, gatepassmodel.getCustomer_name());
			pst.setString(5, gatepassmodel.getIssue());
			i=pst.executeUpdate();
			
			PreparedStatement pst1=conn.prepareStatement("SELECT MAX(gate_pass_master.gp_id) as maxGPId FROM gate_pass_master");
			ResultSet rs=pst1.executeQuery();
			String max_count_gp_id=rs.getString(1);
			
			for(int j=0;i<gatepassmodel.getSpecifications().length;j++) {
				
			PreparedStatement pst2=conn.prepareStatement("INSERT INTO `gate_pass_details`(`gate_pass_master_id`, `specification`, `quantity`) VALUES (?,?,?)");
			pst2.setString(1, max_count_gp_id);
			pst2.setString(2, gatepassmodel.getSpecifications()[j]);
			pst2.setString(4, gatepassmodel.getQuantity()[j]);
			i=pst2.executeUpdate();
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	

}
