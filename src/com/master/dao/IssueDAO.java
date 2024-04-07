package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.IssueModel;
import com.master.model.invoicebean;

public class IssueDAO{
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	public List<IssueModel> issuereport(List<IssueModel> issuemodel) {
	List<IssueModel> list = new ArrayList<>();
	
	
	
	try {
		
		PreparedStatement pst = conn.prepareStatement("SELECT customer_master_details.customer_no, customer_master_details.customer_name, purchase.lead_no, customer_master_details.mobile_no, purchase_order_details.pono from customer_master_details, purchase, purchase_order_details WHERE customer_master_details.customer_no=purchase.vehicle_no AND purchase.invoice_no=purchase_order_details.pono group by pono");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			IssueModel issue = new IssueModel();
			issue.setCustomer_no(rs.getString(1));
			issue.setCustomer_name(rs.getString(2));
			issue.setLead_id(rs.getString(3));
			issue.setMobile_no(rs.getString(4));
			issue.setPono(rs.getString(5));
			
			int rq = 0;
			
			PreparedStatement pst1 = conn.prepareStatement("SELECT remaining_quantity from purchase_order_details where pono='"+rs.getString(5)+"'");
			ResultSet rs1 = pst1.executeQuery();
			
			while(rs1.next())
			{
				rq = rq + Integer.parseInt(rs1.getString(1)); 
			}
			
			String status="";
			PreparedStatement pst2 = conn.prepareStatement("select DISTINCT issue.issue_status from issue, purchase_order_details where issue.pono=purchase_order_details.pono and issue.pono='"+issue.getPono()+"'");
			ResultSet rs2 = pst2.executeQuery();
			
			while(rs2.next())
			{
				if(rs2.getString(1)!=null && rs2.getString(1)!="")
					status = rs2.getString(1).trim();
			}
			
			if(rq<=0 && (!status.equals("1")))
			{
				list.add(issue);
			}
			

		}
		
		
		
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	
	
	return list;
}

	public String insert_issue_details(IssueModel issue_model) {
		// TODO Auto-generated method stub
		
		
		
		return "success";
	}

	public String insertIssueDetails(IssueModel im) {
		// TODO Auto-generated method stub
		String response = "";
		
		
		try {
			String stringValue = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement("select max(SUBSTRING(issue_no,-4)) as myval1 from issue");
			String mystr1 = "";
			int myval1 = 0;
			
			ResultSet rs = preparedStatement.executeQuery();
			
			if(rs.next())
			{
				try {
					mystr1 = rs.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				}catch(Exception e) {
					myval1 = 1;
					mystr1 = "";
				}
			}
			
			stringValue = String.valueOf(myval1);
			
			if(stringValue.length()==1)
			{
				stringValue = "IS/"+"000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue = "IS/"+"00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue = "IS/"+"0"+stringValue;
			}
			else
			{
				stringValue = "IS/"+stringValue;
			}
			
			im.setIssue_no(stringValue);
			
			
			PreparedStatement pst1 = conn.prepareStatement("insert into issue(issue_no, customer_code, customer_name, date, employee, remark, pono, lead_no, issue_status) values(?,?,?,?,?,?,?,?,?)");
			System.out.println(pst1);
			pst1.setString(1, im.getIssue_no());
			pst1.setString(2, im.getCustomer_no());
			pst1.setString(3, im.getCustomer_name());
			pst1.setString(4, im.getDate());
			pst1.setString(5, im.getEmployee());
			pst1.setString(6, im.getRemark());
			pst1.setString(7, im.getPono());
			pst1.setString(8, im.getLead_id());
			pst1.setString(9, "1");
			pst1.executeUpdate();
			System.out.println(im);
			
			PreparedStatement pst2 = conn.prepareStatement("insert into issue_details(issue_no, pono, descrip, quantity) values(?,?,?,?)");
			System.out.println(pst2);
			try {
				
				for(int l=0; l<im.getDescription().length; l++)
				{
					if((im.getDescription()[l]!="")){
						pst2.setString(1, im.getIssue_no());
						pst2.setString(2, im.getPono());
						pst2.setString(3, im.getDescription()[l]);
						pst2.setString(4, im.getQuantity()[l]);
						pst2.executeUpdate();
					}
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			try {
				
				for(int l=0; l<im.getDescription().length; l++)
				{
					if(im.getDescription()[l]!="") {
						PreparedStatement pst3 = conn.prepareStatement("select * from stock_details where description=?");
						System.out.println(pst3);
						pst3.setString(1, im.getDescription()[l]);
						ResultSet rs3 = pst3.executeQuery();
						
						
						if(rs3.next()) {
							PreparedStatement pst4 = conn.prepareStatement("Update stock_details set qty=qty-"+im.getQuantity()[l]+" where description = '"+im.getDescription()[l]+"' ");
							pst4.executeUpdate();
							System.out.println(pst4);
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			try {
				for (int l = 0; l < im.getDescription().length; l++) {
					if (im.getDescription()[l] != "") {

						PreparedStatement pst223 = conn.prepareStatement("select employee_id from employee_master where name_of_employee=?");
						pst223.setString(1, im.getEmployee());
						ResultSet rset = pst223.executeQuery();
						int eid = 0;
						if(rset.next())
						{
							eid = rset.getInt(1);
						}
						
						System.out.println(pst223);
						
						
						PreparedStatement preparedStatement11 = conn
								.prepareStatement("select * from issue_spare_bulk where description=? and customer_name=? and emp_code=?");
						
						preparedStatement11.setString(1, String.valueOf(im.getDescription()[l]));
						preparedStatement11.setString(2, String.valueOf(im.getCustomer_name()));
						//preparedStatement11.setString(3, String.valueOf(rset.getInt(1)));
						preparedStatement11.setString(3, String.valueOf(eid));
						
						ResultSet resultSet11 = preparedStatement11.executeQuery();
						System.out.println(preparedStatement11);
						
						
						if (resultSet11.next()) {
//							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//							Date updatedate = new Date();

							PreparedStatement pst11 = conn.prepareStatement(
									"Update issue_spare_bulk set quantity=quantity+" + im.getQuantity()[l]
											+ " where description='"+im.getDescription()[l]+"' and customer_name=? and emp_code=?" );
							pst11.setString(1, im.getCustomer_name());
							pst11.setString(2, String.valueOf(rset.getInt(1)));

							//k = pst11.executeUpdate();
							pst11.executeUpdate();
							System.out.println(pst11);
						}
						else {
							
							
							
							
							
							PreparedStatement pst11 = conn.prepareStatement(
									"insert into issue_spare_bulk(customer_name, customer_code, description, quantity, emp_code) values(?,?,?,?,?)");
							
							
							
							pst11.setString(1, im.getCustomer_name());
							pst11.setString(2, im.getCustomer_no());
							pst11.setString(3, im.getDescription()[l]);
							pst11.setString(4, im.getQuantity()[l]);
//							pst11.setString(3, prb.getUnitno()[l]);
							//k = pst11.executeUpdate();
							pst11.setString(5, String.valueOf(rset.getInt(1)));
							pst11.executeUpdate();
							
							System.out.println(pst11);

						}
						
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			
			
			
			
			
			
			response = "success";
		}catch(Exception e) {
			e.printStackTrace();
			response ="fail";
		}
		
		return response;
	}
	
	
}