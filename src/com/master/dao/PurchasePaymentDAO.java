package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import com.DB.DBConnection;
//import com.aqua.dao.DaoHelper;
import com.master.model.PaymentModel;

public class PurchasePaymentDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public int insert_payment_details(PaymentModel payment) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO payment(payment_status,customer_name) VALUES (?,?)");
			pst.setString(1, payment.getPayment_status());
			pst.setString(2, payment.getCustomer_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("inserted Succesfully");
				
				 PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+payment.getCustomer_name()+"'");
				 ResultSet rs=pst1.executeQuery();
				 if(rs.next())
				 {
					 int lead_id=Integer.parseInt(rs.getString(1));
					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `payment`='YES' WHERE status_master.lead_id="+lead_id+"");
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

	public String getnvnumbereway() throws SQLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();		
		
		int result = -1;
		 Date date=new Date();
			if (date != null) {
	          Calendar cal = Calendar.getInstance();
	          cal.setTime(date);
	          result = cal.get(Calendar.MONTH)+1;
	      }
			 int result1 = -1;
		        if (date != null) {
		            Calendar cal = Calendar.getInstance();
		            cal.setTime(date);
		            result1 = cal.get(Calendar.YEAR);
		        }
		        String year = "";
		        String yy="";
		        String yy1="";
		        yy=""+result1;
		        
		        yy1=yy.substring(2,4);
		        
		       int pp=0;
		        pp=Integer.parseInt(yy1);
		        
		        if (result <= 3) {
		        year=""+(result1 - 1);
		        }else{
		        	
		        	  year=""+result1;
		        	
		        }
		        String Fyear ="";
		        if (result <= 3) {
		        	Fyear=  (result1 - 1) + "-" + pp;
		        } else {
		        	
		        	Fyear=  result1 + "-" + (pp + 1);
		          
		        }
		        
		        
		        String FMONTH = ""+result;
	       


		

		String pref = "INV";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		// String pref="INV";
		PreparedStatement preparedStatement11 = conn
				.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
		preparedStatement11.setString(1, "" + "%" + Fyear + "%");

		String mystr1 = "";
		int myval1 = 0;
		int w = 0;
		String stringValue1 = "1";

		ResultSet resultSet11 = preparedStatement11.executeQuery();
		if (resultSet11.next()) {
			try {
				mystr1 = resultSet11.getString("myval1");
				myval1 = Integer.parseInt(mystr1);
				myval1 = myval1 + 1;
			} catch (Exception e) {
				
				myval1 = 1;
				mystr1 = "";
			}
		}

		if (mystr1.equals("")) {
			stringValue1 =  "GST/"+Fyear + "/0000" + stringValue1;

		} else {

			if (String.valueOf(myval1).length() == 1) {
				stringValue1 =  "GST/"+Fyear + "/0000" + String.valueOf(myval1);

			} else if (String.valueOf(myval1).length() == 2) {
				stringValue1 = "GST/"+Fyear + "/000" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 3) {
				stringValue1 =  "GST/"+Fyear + "/00" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 4) { 
				stringValue1 =  "GST/"+Fyear + "/0" + String.valueOf(myval1);
			}
			else {
				stringValue1 =  "GST/"+Fyear + "/" + String.valueOf(myval1);
			}
		}
		
		return stringValue1;

	}

}
