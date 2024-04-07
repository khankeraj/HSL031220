package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.quotation.model.ROModel;
import com.quotation.model.ROWaterTPModel;

public class ROReportsDAO {
	DBConnection connection=new DBConnection();
	public List<ROModel> fetch_roReports(ROModel ro_name) {
		
	List<ROModel> list=new ArrayList<ROModel>();
	
	try {
		Connection conn=connection.getConnection();
		
		PreparedStatement pst=conn.prepareStatement("SELECT `ro_id`,`quotation_name` FROM `ro_config_master` ");
		
		ResultSet rs=pst.executeQuery();
		
		while(rs.next())
		{
			ROModel ro_name1=new ROModel();
			
			ro_name1.setRo_name(rs.getString(2));
			ro_name1.setId(rs.getInt(1));
			System.out.println("pst:"+rs.getString(2));
			
			list.add(ro_name1);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return list;
	}
	
	public List<ROModel> fetchROConfiguration(ROModel rowater,String quotation_id) {
		
		List<ROModel> list=new ArrayList<>();
		
		try {
			Connection conn1=connection.getConnection();
			
			PreparedStatement pmst=conn1.prepareStatement("SELECT `ro_id`, `name_of_index`, `subname_of_index`, `select_image`, `subheading1`, `subheading2`, `summary`, `name_of_index1`, `quotation_name` FROM `ro_config_master` WHERE ro_id="+quotation_id+"");
			System.out.println("pst 11:"+pmst);
			ResultSet rs=pmst.executeQuery();
			if(rs.next())
			{
				ROModel rowater1=new ROModel();
				
				rowater1.setRo_id(rs.getInt(1));
				rowater1.setName_of_index(rs.getString(2));
				rowater1.setSub_name_of_index(rs.getString(3));
				rowater1.setSelect_image(rs.getString(4));
				rowater1.setSubHeading1(rs.getString(5));
				rowater1.setSubHeading2(rs.getString(6));
				rowater1.setSummary(rs.getString(7));
				rowater1.setName_of_index1(rs.getString(8));
				rowater1.setQuotation_name(rs.getString(9));
				
				HttpServletRequest request = ServletActionContext.getRequest();
				
				request.setAttribute("select_image", rs.getString(4));
				
				list.add(rowater1);	
				
				/*PreparedStatement pst=conn1.prepareStatement("SELECT `spefication`, `quantity` FROM `ro_specifications_part1`");
				ResultSet rs1=pst.executeQuery();
				
				while(rs1.next())
				{
					ROWaterTPModel rowater11=new ROWaterTPModel();
					
					rowater11.setSpecifi(rs1.getString(1));
					rowater11.setQty(rs1.getString(2));
					
					System.out.println("specifi:"+rs1.getString(1));
					System.out.println("qty:"+rs1.getString(2));
					
					list.add(rowater11);
				}*/
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ROModel> fetchROConfiguration1(ROModel rowater,String quotation_id) {
		
		List<ROModel> list1=new ArrayList<>();
		
		Connection conn2=connection.getConnection();
		
		try {
			
			PreparedStatement pst = conn2.prepareStatement("SELECT `spefication`, `quantity` FROM `ro_config_001` WHERE ro_id="+quotation_id+"");
			
			ResultSet rs1=pst.executeQuery();
			
			while(rs1.next())
			{
				ROModel rowater11=new ROModel();
				
				rowater11.setSpecifi(rs1.getString(1));
				rowater11.setQty(rs1.getString(2));

				list1.add(rowater11);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list1;
	}

	public List<ROModel> fetchROConfiguration2(ROModel rowater,String quotation_id) {
		
		List<ROModel> list2=new ArrayList<>();
		
		Connection conn3=connection.getConnection();
		
		try {
			
			PreparedStatement pst1 = conn3.prepareStatement("SELECT `specification`, `quantity` FROM `ro_config_002` WHERE ro_id="+quotation_id+"");
			
			ResultSet rs11=pst1.executeQuery();
			
			while(rs11.next())
			{
				ROModel rowater111=new ROModel();
				
				rowater111.setSpecifi1(rs11.getString(1));
				rowater111.setQty1(rs11.getString(2));

				list2.add(rowater111);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list2;
	}

	public List<ROModel> fetchROConfiguration3(ROModel rowater,String quotation_id) {
		
		List<ROModel> list3=new ArrayList<>();
		
		Connection conn4=connection.getConnection();
		
		try {
			
			PreparedStatement prep = conn4.prepareStatement("SELECT `specifications3`, `quantity3` FROM `ro_config_003` WHERE ro_id="+quotation_id+"");
			
			ResultSet result=prep.executeQuery();
			
			while(result.next())
			{
				ROModel row=new ROModel();
				
				row.setSpecifi2(result.getString(1));
				row.setQty2(result.getString(2));
				
				list3.add(row);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list3;
	}

	public List<ROModel> fetchROConfiguration4(ROModel rowater,String quotation_id) {
		
		List<ROModel> list4=new ArrayList<>();
		
		Connection conn5=connection.getConnection();
		
		try {
			
			PreparedStatement prep1 = conn5.prepareStatement("SELECT `specifications4`, `quantity4` FROM `ro_config_004` WHERE ro_id="+quotation_id+"");
			
			ResultSet result1=prep1.executeQuery();
			
			while(result1.next())
			{
				ROModel row1=new ROModel();
				
				row1.setSpecifi3(result1.getString(1));
				row1.setQty3(result1.getString(2));
				
				list4.add(row1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list4;
}

	public List<ROModel> fetchROConfiguration5(ROModel rowater,String quotation_id) {
		
		List<ROModel> list5=new ArrayList<>();
		
		Connection conn6=connection.getConnection();
		
		try {
			
			PreparedStatement prep2 = conn6.prepareStatement("SELECT `heading_id`,`heading_nme` FROM `ro_config_005_heading` WHERE ro_id="+quotation_id+"");
			
			ResultSet result2=prep2.executeQuery();
			
			while(result2.next())
			{
				String flag="1";
				ROModel row1=new ROModel();//first bean object1
				row1.setStatus(flag);
				row1.setH_id(result2.getInt(1));
				row1.setHeading(result2.getString(2));
				list5.add(row1);
				
				PreparedStatement prep3 = conn6.prepareStatement("SELECT `rosp_specification`, `rosp_quantity` FROM `ro_config_005` WHERE heading_id="+result2.getInt(1)+"");
				
				ResultSet rs=prep3.executeQuery();
				while(rs.next())
				{
					ROModel row=new ROModel();//second bean object2
					    String flag1="0";
					    row.setStatus(flag1);
					    row.setHeading(rs.getString("rosp_specification"));
						row.setValue(rs.getString("rosp_quantity"));
						
						list5.add(row);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list5;
	}


}
