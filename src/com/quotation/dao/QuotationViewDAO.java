package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.QuotationIndexModel;
import com.quotation.model.QuotationViewModel;

public class QuotationViewDAO {
	
	DBConnection conn=new DBConnection();
	Connection connection=conn.getConnection();
	
	
	public int finalized_quoytation_Details(QuotationIndexModel quotationIndex,int quotation_id, String finalized_amt,String token_amt,String lead_no) {
		int i=0;
		int max_count=0;
		try {
			
			int finalized_status=1;
			
			System.out.println("_finalized_amount:"+finalized_amt);
			System.out.println("_token_amount:"+token_amt);
			
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `finalized_quotation_master`(`lead_no`,`quotation_id`, `finalized_amount`, `token_amount`, `finalized_status`) VALUES (?,?,?,?,1)");
			pst.setString(1, lead_no);
			pst.setInt(2, quotation_id);
			pst.setString(3, finalized_amt);
			pst.setString(4, token_amt);
			i=pst.executeUpdate();
			
			PreparedStatement pst1=connection.prepareStatement("SELECT MAX(id) AS max_count FROM finalized_quotation_master");
			ResultSet rs=pst1.executeQuery();
			if(rs.next())
			{
				max_count=rs.getInt(1);
			}
			
				for(int j=0;j<quotationIndex.getSub_name_of_index().length;j++) {
				
				PreparedStatement pst2=connection.prepareStatement("INSERT INTO `finalized_quotation_index`(`finalized_id`, `quotation_id`, `specifications`, `quontity`) VALUES (?,?,?,?)");
				pst2.setInt(1, max_count);
				pst2.setInt(2, quotation_id);
				pst2.setString(3,quotationIndex.getSub_name_of_index()[j]);
				try {
					pst2.setString(4, quotationIndex.getSelectQuotationName()[j]);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				i=pst2.executeUpdate();
				
				}
				
				PreparedStatement pst11=connection.prepareStatement("UPDATE `status_master` SET `finalization`='YES' WHERE lead_no='"+lead_no+"'");
				int j=pst11.executeUpdate();
				if(j>0)
				{
					System.out.println("status Updated Successfully");
				}
				
				PreparedStatement pst111=connection.prepareStatement("UPDATE `quotation_master` SET `status`=2 WHERE `quotation_id`="+quotation_id+"");
				int j1=pst111.executeUpdate();
				if(j1>0)
				{
					System.out.println("status Updated Successfully");
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	
	public int edit_quoytation_Details(QuotationIndexModel quotationIndex,int quotation_id) {
		int i=0;
		int max_count=0;
		try {
			
			PreparedStatement pst=connection.prepareStatement("UPDATE `quotation_reports_master` SET `quotation_id`=? WHERE `quotation_id`="+quotation_id+"");
			pst.setInt(1, quotation_id);
			i=pst.executeUpdate();
			
			PreparedStatement pst1=connection.prepareStatement("DELETE FROM `edit_quotation_index` WHERE edit_quotation_index.quotation_id="+quotation_id+"");
			i=pst1.executeUpdate();
			
			System.out.println("delete edit_quotation_index:"+pst1);
			
				for(int j=0;j<quotationIndex.getSub_name_of_index().length;j++) {
				
				PreparedStatement pst2=connection.prepareStatement("INSERT INTO `edit_quotation_index`(`name_of_index`, `select_quotation`, `customer_id`, `quotation_id`) VALUES (?,?,?,?)");
				pst2.setString(1,quotationIndex.getSub_name_of_index()[j]);
				pst2.setString(2, quotationIndex.getSelectQuotationName()[j]);
				pst2.setInt(3, max_count);
				pst2.setInt(4,quotation_id);
				
				i=pst2.executeUpdate();
				
				System.out.println("insert edit_quotation_index:"+pst2);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	
	public int insert_quotation_view(QuotationIndexModel quotationIndex,String customer_name,int quotation_id, String lead_no,String counter) {
		int i=0;
		try {
				System.out.println("1 in dao :"+quotation_id);
				
				/*PreparedStatement pst1=connection.prepareStatement("SELECT MAX(customer_master.customer_id) as max_cust_id,MAX(customer_master.quotation_id) AS max_quot_id FROM customer_master");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					max_cust_id=rs.getInt(1);
					max_quot_id=rs.getInt(2);
					
					System.out.println("2");
				}*/
				System.out.println("counter :"+Integer.parseInt(counter));
				int len=Integer.parseInt(counter);
				
				PreparedStatement pst=connection.prepareStatement("INSERT INTO `quotation_master`(`quotation_id`, `lead_no`, `customer_name`, `status`) VALUES (?,?,?,1)");
				pst.setInt(1, quotation_id);
				pst.setString(2, lead_no);
				pst.setString(3, customer_name);
				i=pst.executeUpdate();
				
				for(int j=0;j<len;j++) {
					System.out.println("counter length:"+counter.length());
				
				PreparedStatement pst2=connection.prepareStatement("INSERT INTO `edit_quotation_index`(`name_of_index`, `select_quotation`, `lead_no`, `quotation_id`) VALUES (?,?,?,?)");
				pst2.setString(1,quotationIndex.getSub_name_of_index()[j]);
				pst2.setString(2,quotationIndex.getSelectQuotationName()[j]);
				pst2.setString(3,lead_no);
				pst2.setInt(4,quotation_id);
				
				i=pst2.executeUpdate();
				
				//System.out.println("1:"+quotationIndex.getSub_name_of_index()[j]+"2:"+quotationIndex.getSelectQuotationName()[j]+"3"+max_cust_id+"4:"+max_quot_id);
				
				System.out.println("pst2:"+pst2+"1:"+i);
				
				}
				
				PreparedStatement pst1=connection.prepareStatement("UPDATE `meeting_details` SET `status`=2 WHERE `lead_no`='"+lead_no+"'");
				i=pst1.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<QuotationViewModel> fetchCustomerDetails(QuotationViewModel quotationViewModal) {
		List<QuotationViewModel> list=new ArrayList<QuotationViewModel>();
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `customer_name`,`lead_no`, `quotation_id` FROM `quotation_master` WHERE status=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationViewModel quotationView=new QuotationViewModel();
				
				quotationView.setCust_name(rs.getString(1));
				quotationView.setLead_no(rs.getString(2));
				int quot_id=rs.getInt(3);
				quotationView.setQuotation_id(quot_id);
				
				list.add(quotationView);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}


}
