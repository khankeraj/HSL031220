package com.status_report.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.DB.DBConnection;
import com.master.model.LeadFormModel;

public class StatusReportDAO
{
	
	public List<LeadFormModel> fetchLeadDetails(LeadFormModel lead)
	{
		List<LeadFormModel> list=new ArrayList<LeadFormModel>();
		HttpServletRequest request = ServletActionContext.getRequest();
		
		try {
			
			DBConnection connection=new DBConnection();
			Connection conn=connection.getConnection();
			String lead_no;
			
			PreparedStatement pst=conn.prepareStatement("SELECT status_master.lead_no,lead_deatils.customer_name FROM lead_deatils,status_master WHERE lead_deatils.lead_no=status_master.lead_no");
			ResultSet rs=pst.executeQuery();

			while(rs.next())
			{
				LeadFormModel lead1=new LeadFormModel();
				lead1.setCustomer_name(rs.getString(2));
				lead_no=rs.getString(1);
				 
				PreparedStatement pst1=conn.prepareStatement("SELECT COUNT(process_flow.name) FROM process_flow ");
				ResultSet rs1=pst1.executeQuery();
				if(rs1.next())
				{
					 request.setAttribute("count_columns", rs1.getString(1));
					 lead1.setMysize(rs1.getInt(1));
					 
				} 
				int j=0;
				String dates[]=new String[100];
				PreparedStatement pmst=conn.prepareStatement("SELECT lead_deatils.date,meeting_details.requiredDate FROM lead_deatils,meeting_details WHERE lead_deatils.customer_name=meeting_details.customer_name");
				ResultSet resultset=pmst.executeQuery();
				while(resultset.next())
				{
					 System.out.println("REsultset:"+resultset.getString(1));
					 dates[j]=resultset.getString(1);
					 lead1.setDates(dates);
					 j++;
				}
					 PreparedStatement pst11=conn.prepareStatement("SELECT process_flow.name FROM process_flow");
					 ResultSet rs11=pst11.executeQuery();
					 int i=0;
					 String mystatus[]=new String[100];
					 String indexName[]=new String[100];
					 
					 while(rs11.next())
					 { 
						 String status=rs11.getString(1);
						 PreparedStatement pst111=conn.prepareStatement("SELECT `"+status+"` FROM status_master WHERE status_master.lead_no='"+lead_no+"'");
						 ResultSet result=pst111.executeQuery();
						 if(result.next())
						 {
							 String check_status=(String)result.getString(1);
							 if(check_status.equals("YES")) 
							 {
								 mystatus[i]="YES";
								 indexName[i]=rs11.getString(1);
								 request.setAttribute("check_status","YES");
							 }else
							 {
								 
								 request.setAttribute("check_status","NO");
								 mystatus[i]="NO";
								 indexName[i]=rs11.getString(1);
								
							 }
							 System.out.println(lead_no+">>>>>"+mystatus[i]+">>>>>>>>>>"+status+".....:"+indexName[i]);
						 }
						 lead1.setMystatus(mystatus);
						 lead1.setIndexName(indexName);
						// lead1.setDates(dates);
						 i++;
				   }
				
				list.add(lead1);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
