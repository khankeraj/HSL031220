package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.master.model.MachinerySetupModel;

public class MachinerySetupDAO {
	
	List<String> list_of_machinery_setup=new ArrayList<>();
	
	public int insert_machinery_details(MachinerySetupModel machinery_setup)
	{
		int status=0;
		String status1="";
		String lm_id="";
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			/*PreparedStatement pst2=connection.prepareStatement("SELECT list_of_machinery.name_of_index FROM list_of_machinery WHERE list_of_machinery.name_of_index=? " );
			pst2.setString(1, machinery_setup.getName_of_index());
			ResultSet rs=pst2.executeQuery();
			if(rs.getString(1).equals(machinery_setup.getName_of_index()))
			{
				
			}*/
			
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `list_of_machinery`(`name_of_index`) VALUES (?)");
			pst.setString(1, machinery_setup.getName_of_index());
			status=pst.executeUpdate();
			if(status>0)
			{
			System.out.println("hiiii");
			PreparedStatement pst1=connection.prepareStatement("SELECT MAX(list_of_machinery.lm_id) FROM list_of_machinery ");
			ResultSet rs=pst1.executeQuery();
			while(rs.next())
			{
				lm_id=rs.getString(1);
			}
			int list_of_machinery_id=Integer.parseInt(lm_id);
			
			System.out.println("lm_id:"+list_of_machinery_id);
			
			for(int i=0;i<machinery_setup.getMachinery_setup().length;i++)
			{
				PreparedStatement pst11=connection.prepareStatement("INSERT INTO `machinery_and_setup_details`(`lm_id`, `machinery_name_and_setup`) VALUES (?,?)");
				pst11.setInt(1, list_of_machinery_id);
				pst11.setString(2, machinery_setup.getMachinery_setup()[i]);
				status=pst11.executeUpdate();
			}
			
		  }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public List<MachinerySetupModel> fetchnameOfIndex(MachinerySetupModel machinery_setup_model)
	{
		List<MachinerySetupModel> list=new ArrayList<>();
		int machinery=0;
		ResultSet rs;
		try {
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("SELECT list_of_machinery.lm_id,list_of_machinery.name_of_index FROM list_of_machinery ");
			rs=pst.executeQuery();
			while(rs.next())
			{
				machinery=rs.getInt(1);
				MachinerySetupModel machinery_setup=new MachinerySetupModel();
				machinery_setup.setMachinery_id(rs.getString(1));
				machinery_setup.setName_of_index(rs.getString(2));
				list.add(machinery_setup);
				System.out.println("Machinery_id:"+machinery);
			}
			
			/*PreparedStatement pst3=connection.prepareStatement("SELECT COUNT(machinery_and_setup_details.lm_id) FROM machinery_and_setup_details WHERE machinery_and_setup_details.lm_id=? ");
			pst3.setInt(1, machinery);
			rs=pst3.executeQuery();
			while(rs.next())
			{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("count_of_machinery", rs.getInt(1));
			System.out.println(rs.getInt(1));
			}
			
			PreparedStatement pst1=connection.prepareStatement("SELECT machinery_and_setup_details.machinery_name_and_setup FROM machinery_and_setup_details WHERE machinery_and_setup_details.lm_id=?");
			pst1.setInt(1, machinery);
			System.out.println(pst1);
			rs=pst1.executeQuery();
			while(rs.next())
			{
				String list1=(String) rs.getString("machinery_name_and_setup");
				System.out.println(list1);
				MachinerySetupModel machinery_setup1=new MachinerySetupModel();
				machinery_setup1.setList1(list1);
				System.out.println("list1:"+machinery_setup1.getList1());
				list.add(machinery_setup1);
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
}
