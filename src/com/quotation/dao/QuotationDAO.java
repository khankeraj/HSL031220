package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.QuotationModel;

public class QuotationDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	

	public int insert_quotation_details(QuotationModel quotation) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO quotation_master(customer_name,quotation_status) VALUES (?,?)");
			pst.setString(1, quotation.getQuotation_status());
			pst.setString(2, quotation.getCustomer_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted successFully");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+quotation.getCustomer_name()+"' ");
				 ResultSet rs=pst1.executeQuery();
				 if(rs.next())
				 {
					 int lead_id=Integer.parseInt(rs.getString(1));
					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `quotation`='YES' WHERE status_master.lead_id="+lead_id+"");
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


	public List<QuotationModel> fetchQuotationPages(QuotationModel quotationmodel) {
		// TODO Auto-generated method stub
		List<QuotationModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `page_id`, `index_name` FROM `quotation_pages`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationModel quotationmodel1=new QuotationModel();
				quotationmodel1.setQuotationPages_id(rs.getInt(1));
				quotationmodel1.setName_of_index(rs.getString(2));
				list.add(quotationmodel1);
				System.out.println("list:"+rs.getInt(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	/*public List<QuotationModel> fetchCoverPageDetails(QuotationModel quotationmodel,String cover_page_id) {
		// TODO Auto-generated method stub
		int cover_pageId=Integer.parseInt(cover_page_id);
		
		List<QuotationModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}*/
	

}
