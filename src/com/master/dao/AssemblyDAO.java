package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.AssemblyModel;

public class AssemblyDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_assembly_details(AssemblyModel assembly) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO assembly_details(assembly_status,customer_name) VALUES (?,?)");
			pst.setString(1, assembly.getAssembly_status());
			pst.setString(2, assembly.getCustomer_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted Succesfully");
				 PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+assembly.getCustomer_name()+"'");
				 ResultSet rs=pst1.executeQuery();
				 if(rs.next())
				 {
					 int lead_id=Integer.parseInt(rs.getString(1));
					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `assembly`='YES' WHERE status_master.status_id="+lead_id+"");
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

	public List<AssemblyModel> outstandingReport(List<AssemblyModel> outstandingmodel) {
		// TODO Auto-generated method stub
		
		List<AssemblyModel> list = new ArrayList<>();
		
		try {
			
			PreparedStatement pst = conn.prepareStatement("select issue_no, date, employee, customer_code, customer_name, lead_no, pono, issue_status from issue");
			ResultSet rs = pst.executeQuery();
			String status = "";
			while(rs.next())
			{
				AssemblyModel model = new AssemblyModel();
				model.setIssue_no(rs.getString(1));
				model.setDate(rs.getString(2));
				model.setEmployee(rs.getString(3));
				model.setCustomer_code(rs.getString(4));
				model.setCustomer_name(rs.getString(5));
				model.setLead_no(rs.getString(6));
				model.setPono(rs.getString(7));
				
				if(rs.getString(8)!=null && rs.getString(8)!="")
					status =rs.getString(8);
				
				if(status.equals("1"))
					list.add(model);
					
			}
			
		}catch(Exception  e) {e.printStackTrace();}
		
		
		return list;
	}

	public List<AssemblyModel> issueSpareBulkReport(List<AssemblyModel> issue_sparebulkmodel) {
		// TODO Auto-generated method stub
		List<AssemblyModel> list = new ArrayList<>();
		try {
			PreparedStatement pst = conn.prepareStatement("select customer_name, customer_code, description, quantity, emp_code from issue_spare_bulk");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				AssemblyModel model = new AssemblyModel();
				model.setCustomer_name(rs.getString(1));
				model.setCustomer_code(rs.getString(2));
				model.setDescription(rs.getString(3));
				model.setQuantity(rs.getString(4));
				model.setEmp_code(rs.getString(5));
				
				list.add(model);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
