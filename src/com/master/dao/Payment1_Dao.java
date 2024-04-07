package com.master.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.util.CoreData;
import com.master.model.Payment1Model;


public class Payment1_Dao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	public Payment1Model FetchspareMaterial12(String transporter_code) {
		// TODO Auto-generated method stub
		Payment1Model bean1  = new Payment1Model();
		int sparesize = 0;
		
		List<String> trip_id2 = new ArrayList<String>();
		List<String> updown_id2 = new ArrayList<String>();
		List<String> lr_number2 = new ArrayList<String>();
		List<String> commision2 = new ArrayList<String>();
		List<String> remaining_amount2 = new ArrayList<String>();
		List<String> date2 = new ArrayList<String>();
		
		try {
			int sno = 1;

				
			PreparedStatement psttn = conn.prepareStatement("select transporter_name from transporter_master where transporter_no = '"+transporter_code+"'");
			ResultSet rs = psttn.executeQuery();
			
			System.out.println("pstn: "+psttn);
			String transporter_name = "";
			
			while(rs.next())
			{
				transporter_name = rs.getString(1);
			}
			
			PreparedStatement pst1 = conn
					.prepareStatement("select * from commission  where transporter_code='"+  transporter_code + "' and remaining_amount > 0 ");

			System.out.println("SQL:"+pst1);
			ResultSet rs1 = pst1.executeQuery();
			//String custid="";
			while (rs1.next()) {

				trip_id2.add(rs1.getString("trip_id"));
				updown_id2.add(rs1.getString("updown_id"));
				lr_number2.add(rs1.getString("LR_no"));
				
				/*PreparedStatement pstddd = conn.prepareStatement("select * from order_table where lr_no = '"+rs1.getString("LR_no")+"'");
				ResultSet rsdd = pstddd.executeQuery();
				String ssk="";
				if(rsdd.next())
				{
					
					PreparedStatement pstdddd = conn.prepareStatement("select * from pricing_details where pricing_id = '"+rsdd.getString("pricing_id")+"'");
					ResultSet rsddd = pstdddd.executeQuery();
					if(rsddd.next())
					{
						ssk=rsddd.getString("price");
						
					}
				}*/
				
				date2.add(rs1.getString("date"));
				
				commision2.add(rs1.getString("commission_amount"));
				//remaining_amount2.add(ssk);
				remaining_amount2.add(rs1.getString("remaining_amount"));
				sparesize++;
				
			}
			
			
			//System.out.println("Customer Id:"+custid);
			
			/*PreparedStatement pst = con
					.prepareStatement("select * from invoice  where vehicle_no='"
							+  autoinvoice + "' and remaining_amount > 0 ");

			System.out.println("SQL:"+pst);
			ResultSet rs = pst.executeQuery();
			double totalmn=0;double qtynew=0;
		
			while (rs.next()) {

			
				inv.add(rs.getString("invoice_no"));
				d1.add(rs.getString("date"));
				totamt.add(rs.getString("total"));
				remamt.add(rs.getString("remaining_amount"));
				recno.add(rs.getString("access_id"));
	
				sparesize++;
			}
				try{
				
			}catch(Exception e){
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		bean1.setSparesize(sparesize);
		bean1.setInv1(inv);
		bean1.setD11(d1);
		bean1.setTotamt1(totamt);
		bean1.setReamt1(remamt);
		bean1.setRecno(recno);*/
		
			
		bean1.setSpare_size(sparesize);	
		bean1.setTrip_id2(trip_id2);
		bean1.setUpdown_id2(updown_id2);
		bean1.setLr_number2(lr_number2);
		bean1.setCommision2(commision2);
		bean1.setRemaining_amount2(remaining_amount2);
		bean1.setDate2(date2);
		
		return bean1;

	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}


		return bean1;





}

	public String inserttransporterpaymentv(Payment1Model dpb) {
		// TODO Auto-generated method stub
		String response="";
		String stringValue="";
		
		try {
			
			PreparedStatement preparedStatement3 = conn
					.prepareStatement("select  max(SUBSTRING(Documentsno,-4)) as myval1 from transportercreditdebit");
			
			
			String mystr2 = "";
			int myval2 = 0;
			ResultSet resultSet2 = preparedStatement3.executeQuery();
			
			if (resultSet2.next()) {
				try {
					mystr2 = resultSet2.getString("myval1");
					myval2 = Integer.parseInt(mystr2);
					myval2 = myval2 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval2 = 1;
					mystr2 = "";
				}
			}
			
			stringValue=String.valueOf(myval2);
			
			String ap="TP";
			
			
			if(stringValue.length()==1)
			{
				stringValue="HSL/RTP/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="HSL/RTP/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="HSL/RTP/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="HSL/RTP/"+ap+"/"+stringValue;
			}

			

		
			dpb.setVoucher_no(stringValue);
			
			
			String dealercode="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;
			
			String s="";
			String name="";
			String name_id="";
				try{
					 s=dpb.getTransporter_name();
					 String parts[]=s.split("-");
					 dealercode=parts[1];
					 name=parts[0];
					 name_id=parts[1];
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
			
			
			
				try{
					
					if(dpb.getPaymod().equals("1")){
						dpb.setTotal_amount(dpb.getNet_amount());
					}
					}catch(Exception e){
						
					}
				
					PreparedStatement pstcx9 = conn.prepareStatement("insert into transporterpayment(Invoiceno,transporter_name,"
						+ "transporter_address,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque"
						+ ",paybycredit,date,particular,bankname,receiptno,verifyby,transporter_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				
				
					pstcx9.setString(1, stringValue);
					pstcx9.setString(2, name);
					pstcx9.setString(3,"");
					
					String paybycash=dpb.getTotal_amount();
					System.out.println(dpb.getTotal_amount());
					
					
					pstcx9.setString(4,paybycash);
					pstcx9.setString(5,dpb.getPaymod());
					
					
					try{
						pstcx9.setString(6,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
						/*if(!(dpb.getCheque_date().equals(null)) && !(dpb.getCheque_date().equals("")))
							pstcx9.setString(6, (dpb.getCheque_date()));
						else
							pstcx9.setString(6, "");*/
						}catch(Exception e){
							
							pstcx9.setString(6,null);	
						}
						
						try{
							pstcx9.setString(7,dpb.getCheque_no());
							}catch(Exception e){
								
								pstcx9.setString(7,null);	
							}
						
						try{
							pstcx9.setString(8,dpb.getTranscation_id());
							}catch(Exception e){
								
								pstcx9.setString(8,"");	
							}
						
						
						
						pstcx9.setString(9,"");
						if(dpb.getPaymod().equals("1")){	
						pstcx9.setString(10, paybycash);
						}else{
							pstcx9.setString(10, "");	
						}
						if(dpb.getPaymod().equals("3")){	
							pstcx9.setString(11, paybycash);
							}else{
								pstcx9.setString(11, "");	
							}
						if(dpb.getPaymod().equals("4")){	
							pstcx9.setString(12, paybycash);
							}else{
								pstcx9.setString(12, "");	
							}
						
							
						
						
						pstcx9.setString(13,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						//pstcx9.setString(13,(dpb.getPayment_date()));
						pstcx9.setString(14, dpb.getRemark());	
						
						
						try{
							pstcx9.setString(15,dpb.getBankname());
							}catch(Exception e){
								
								pstcx9.setString(15,"");	
							}
						pstcx9.setString(16, stringValue);
						
						try{
							pstcx9.setString(17, dpb.getVerifyby());
							}catch(Exception e){
								
								pstcx9.setString(17,"");	
							}
						
						try{
							pstcx9.setString(18, dealercode);
							}catch(Exception e){
								
								pstcx9.setString(18,"");	
							}
						
					System.out.println("q4"+pstcx9);
				
					int j9s = pstcx9.executeUpdate();

					//****************************
					
					/*PreparedStatement pst31=conn.prepareStatement("Insert into transportercreditdebit(Transporter_code, Date, Documentsno,Remark,Typecode,type,Amount,Name) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Payment to Transporter','201','Credit','"+dpb.getTotal_amount()+"','"+name+"')");*/
					PreparedStatement pst31=conn.prepareStatement("Insert into transportercreditdebit(Transporter_code, Date, Documentsno,Remark,Typecode,type,Amount,Name) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Payment to Transporter','201','Debit','"+dpb.getTotal_amount()+"','"+name+"')");
					System.out.println("pst31--"+pst31);
					int i=pst31.executeUpdate();
					String paymod="";
					switch (dpb.getPaymod()) {
					case "1":
						paymod="cash";
						break;
					case "3":
						paymod="Cheque ";
					break;case "4":
						paymod="NEFT";
						break;
					default:
						paymod="";
						break;
					}
					PreparedStatement pst331=conn.prepareStatement("Insert into diley_cashreport(Customercode, Date, Documentsno,Remark,Typecode,type,Amount,Name,emp_id,cash_source,form_source) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','"+dpb.getRemark()+"','201','Credit','"+dpb.getTotal_amount()+"','"+name+"','"+name_id+"','"+paymod+"','Transporter Payment Form')");
					System.out.println("pst331--"+pst31);
					int j=pst331.executeUpdate();
					
					System.out.println("pst331--------------"+pst31);
					
					
					
					System.out.println();
					
					/*if(dpb.getPaytype().equals("against_trip"))
					{*/
							
							for(i=0;i<dpb.getLr_number2().size();i++)
							{
								try{
									System.out.println(">>>>>"+dpb.getCommcheck()[i]);
								if( !dpb.getCommcheck()[i].equals("") &&  !dpb.getCommcheck()[i].equals(null)  ){
								PreparedStatement pstcx99 = conn.prepareStatement("insert into transporter_payment_details(suppliername,date,invoiceno,balanceamount,paidamount,voucherno,suppcode) values(?,?,?,?,?,?,?)");
								System.out.println("For");
								
		
								pstcx99.setString(1, name);
								pstcx99.setString(2,dpb.getDate2().get(i));
								pstcx99.setString(3,dpb.getLr_number2().get(i));
								pstcx99.setString(4,dpb.getCommision2().get(i));
								pstcx99.setString(5,dpb.getRemaining_amount2().get(i));
								pstcx99.setString(6,stringValue);
								pstcx99.setString(7,dealercode);
								pstcx99.executeUpdate();
								
								System.out.println("SQL:"+pstcx99);
								}
								}catch(Exception e){
									e.printStackTrace();
								}
							}
		
							
							
							for(i=0;i<dpb.getLr_number2().size();i++)
							{
								
								String amt = "";
								
								try{
									
									System.out.println(">>>>>"+dpb.getCommcheck()[i]);
									
									if( !dpb.getCommcheck()[i].equals("") &&  !dpb.getCommcheck()[i].equals(null)  ){
								//System.out.println("Update");
								PreparedStatement pst=conn.prepareStatement("SELECT * FROM  commission where LR_no='"+dpb.getLr_number2().get(i)+"'");
		
								//System.out.println("1"+pst);
								
								ResultSet rst=pst.executeQuery();
								System.out.println("pst: "+pst);
								if(rst.next()){
									
									 amt=rst.getString("remaining_amount");
									// System.out.println("Remain Amount:"+amt);
										
								
									 String amt1=dpb.getRemaining_amount2().get(i);
								
								
								//System.out.println("UI Amount:"+amt1);
								
								double amtnew=Double.parseDouble(amt)-Double.parseDouble(amt1);
								
								System.out.println("New Amount:"+amtnew+"="+amt+"-"+amt1);
								
								String query1="update commission set remaining_amount='"+amtnew+"' where LR_no='"+dpb.getLr_number2().get(i)+"'";
								
								
								PreparedStatement pst11=conn.prepareStatement(query1);
								
								System.out.println("2"+pst11);
								pst11.executeUpdate();
								
							}
								
								}
								}catch(Exception e){
									e.printStackTrace();
								}
							}
					//}
					
					
					
					/*if(dpb.getPaymod().equals("3") || dpb.getPaymod().equals("4"))
					{
						
						
						// Debit
						
						PreparedStatement pstcx99 = conn.prepareStatement("insert into bank_ledger_transporter(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)");
						pstcx99.setString(1, stringValue);
						pstcx99.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						pstcx99.setString(2,(dpb.getPayment_date()));
						pstcx99.setString(3,dpb.getBankname());
						pstcx99.setString(4,"Debit");
						pstcx99.setString(5,dpb.getTotal_amount());
						pstcx99.setString(6,"Bank");
						System.out.println("pstcx99"+pstcx99);
						pstcx99.executeUpdate();
						
						
						// Credit
						
						
						PreparedStatement pst = conn.prepareStatement("insert into bank_ledger_transporter(doc_no,date,account_name,cdtype,amount,remark,transporter_id) values(?,?,?,?,?,?,?)");
						pst.setString(1, stringValue);
						pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						pst.setString(2,(dpb.getPayment_date()));
						pst.setString(3,dpb.getBankname22());
						pst.setString(4,"Credit");
						pst.setString(5,dpb.getTotal_amount());
						pst.setString(6,"Transporter");
						pst.setString(7,dealercode);
						System.out.println("pst"+pst);
						pst.executeUpdate();
					
					}*/
					

					/*if(dpb.getPaymod().equals("1"))
					{
						
					
						// Credit
						
						
						PreparedStatement pst = conn.prepareStatement("insert into bank_ledger_transporter(doc_no,date,account_name,cdtype,amount,remark,transporter_id) values(?,?,?,?,?,?,?)");
						pst.setString(1, stringValue);
						pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						pst.setString(2,(dpb.getPayment_date()));
						pst.setString(3,"");
						pst.setString(4,"Credit");
						pst.setString(5,dpb.getTotal_amount());
						pst.setString(6,"Cash");
						pst.setString(7,dealercode);
						System.out.println(pst);
						pst.executeUpdate();
					
					}*/
		
					response="success";
					
					
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			response="fail";
		}
		
		
		return response;
	}

	public String insertcustomerpaymentv(Payment1Model dpb) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		System.out.println("in dao");
		String response;	
		Connection connection=null;
		String amtpert;
		String stringValue;
		try
		{

			DBConnection connection1=new  DBConnection();
			
			
			Connection conn=connection1.getConnection();

			String po="PO";
			//String from_companyName=prb.getFrom_companyName();
			//Date date= new Date();
			String date2="08/12/2014";
			date2 = date2.substring(3, 10);
			String str="";
			//	String str_Auto=prb.getAuto_id();
			//int autoIdlength = autoId.length();
			String po_done_status="0";
			
			int len=0;
			// Bill Number Generation For Customer Credit Debit
			int len1=0;
			PreparedStatement preparedStatement1x=conn.prepareStatement("SELECT * FROM  customercreditdebit");

			ResultSet resultSet1x=preparedStatement1x.executeQuery();
			System.out.println("preparedStatement1x : "+preparedStatement1x);
			while(resultSet1x.next()){
				len1++;
			}	

			int size=len1+1;
			stringValue=String.valueOf(size);
			
			 String ap="CP";
			
			
			
			if(stringValue.length()==1)
			{
				stringValue="HSL/CP/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="HSL/CP/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="HSL/CP/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="HSL/CP/"+ap+"/"+stringValue;
			}

			

		
			dpb.setVoucher_no(stringValue);

			String dealercode="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;	
		
				
				
			String s="";
			String name="";
			String name_id="";
				try{
					 s=dpb.getCustomer_name();
					 String parts[]=s.split("-");
					 dealercode=parts[1];
					 name=parts[0];
					 name_id=parts[1];
					 
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
				
				
				
				try{
				
				if(dpb.getPaymod().equals("1")){
					dpb.setTotal_amount(dpb.getNet_amount());
				}
				}catch(Exception e){
					
				}
				
				//PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,customername,customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				
					try {
						PreparedStatement pstcx9 = conn.prepareStatement("insert into customerpayment(Invoiceno,customername,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,particular,bankname,receiptno,verifyby,lead_no,status, customerid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						
						pstcx9.setString(1, stringValue);
						pstcx9.setString(2, name);
						String paybycash=dpb.getTotal_amount();
						//System.out.println(dpb.getDealer_payment_amt());

						pstcx9.setString(3,paybycash );
						pstcx9.setString(4,dpb.getPaymod());
						try{
						/*pstcx9.setString(5,CoreData.getDateFormatAsDb(dpb.getCheque_date()));*/
							if(!dpb.getCheque_date().equals("")) {
						pstcx9.setString(5, CoreData.getDateFormatAsDb(dpb.getCheque_date()));
							}else {
								pstcx9.setString(5,null);	
							}
						}catch(Exception e){
							
							pstcx9.setString(5,null);	
						}
						
						try{
							pstcx9.setString(6,dpb.getCheque_no());
							}catch(Exception e){
								
								pstcx9.setString(6,null);	
							}
						
						try{
							pstcx9.setString(7,dpb.getTranscation_id());
							}catch(Exception e){
								
								pstcx9.setString(7,"");	
							}
						
						pstcx9.setString(8,"");
						if(dpb.getPaymod().equals("1")){	
						pstcx9.setString(9, paybycash);
						}else{
							pstcx9.setString(9, "");	
						}
						if(dpb.getPaymod().equals("3")){	
							pstcx9.setString(10, paybycash);
							}else{
								pstcx9.setString(10, "");	
							}
						if(dpb.getPaymod().equals("4")){	
							pstcx9.setString(11, paybycash);
							}else{
								pstcx9.setString(11, "");	
							}
						
						/*pstcx9.setString(12,CoreData.getDateFormatAsDb(dpb.getPayment_date()));*/
						pstcx9.setString(12,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
						pstcx9.setString(13, dpb.getRemark());	
						
						try{
							pstcx9.setString(14,dpb.getBankname());
							}catch(Exception e){
								
								pstcx9.setString(1,"");	
							}
						pstcx9.setString(15, stringValue);
						
						try{
							pstcx9.setString(16, dpb.getVerifyby());
							}catch(Exception e){
								
								pstcx9.setString(16,"");	
							}
						pstcx9.setString(17, "");
						pstcx9.setString(18, "1");
						pstcx9.setString(19, dealercode);
						
						System.out.println("q4"+pstcx9);
								
						int j9s = pstcx9.executeUpdate();
								//System.out.println("pstcx9 : "+pstcx9);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							
		
			try {
				PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Customer Payment','201','Credit','"+dpb.getTotal_amount()+"','"+name+"')");
				System.out.println("pst31 : "+pst31);
				int i=pst31.executeUpdate();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String paymod="";
			switch (dpb.getPaymod()) {
			case "1":
				paymod="cash";
				break;
			case "3":
				paymod="Cheque ";
			break;
			case "4":
				paymod="NEFT";
				break;
			default:
				paymod="";
				break;
			}
			
			
			
			
			try {
				PreparedStatement pst31=conn.prepareStatement("Insert into diley_cashreport(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,emp_id,cash_source,form_source) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Customer Payment','201','Credit','"+dpb.getTotal_amount()+"','"+name+"','"+name_id+"','"+paymod+"','Customer Payment Form')");
				System.out.println("pst31 : "+pst31);
				int i=pst31.executeUpdate();
				System.out.println("pst31 : "+pst31);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			try {
				for(int i=0;i<dpb.getInv1().length;i++)
				{
					try{
						System.out.println(">>>>>"+dpb.getInvcheck()[i]);
					
						if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
					
							PreparedStatement pstcx99 = conn.prepareStatement("insert into customer_payment_details(suppliername,date,invoiceno,balanceamount,paidamount,voucherno,suppcode) values(?,?,?,?,?,?,?)");
					
							System.out.println("For");
					

					
							pstcx99.setString(1, name);
					
							pstcx99.setString(2,CoreData.getDateFormatAsDb(dpb.getD11()[i]));
					
							pstcx99.setString(3,dpb.getInv1()[i]);
					
							pstcx99.setString(4,dpb.getTotamt1()[i]);
					
							pstcx99.setString(5,dpb.getReamt1()[i]);
					
					
							pstcx99.setString(6,stringValue);
					
							pstcx99.setString(7,dealercode);
				
							System.out.println("SQL:"+pstcx99);
							
							pstcx99.executeUpdate();
					
					
					
					}
					}catch(Exception e){}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			for(int i=0;i<dpb.getInv1().length;i++)
			{
				String amt = "";
				try{
					System.out.println(">>>>>"+dpb.getInvcheck()[i]);
				if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
				//System.out.println("Update");
				PreparedStatement pst=conn.prepareStatement("SELECT * FROM  invoice where invoice_no='"+dpb.getInv1()[i]+"'");

				//System.out.println("1"+pst);
				
				ResultSet rst=pst.executeQuery();
				System.out.println("pst : "+pst);
				if(rst.next()){
					
					 amt=rst.getString("remaining_amount");
					// System.out.println("Remain Amount:"+amt);
						
				
				String amt1=dpb.getReamt1()[i];
				
				
				//System.out.println("UI Amount:"+amt1);
				
				double amtnew=Double.parseDouble(amt)-Double.parseDouble(amt1);
				
				//System.out.println("New Amount:"+amtnew+"="+amt+"-"+amt1);
				
				String query1="update invoice set  remaining_amount='"+amtnew+"' where invoice_no='"+dpb.getInv1()[i]+"'";
				
				
				PreparedStatement pst11=conn.prepareStatement(query1);
				
				System.out.println("pst11 : "+pst11);
				pst11.executeUpdate();
				
			}
				
				
				
				}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			
			
			
			
			
			
			
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
		//return null;
	
		
		
		
	}

	public List<Payment1Model> getTransporterOutstandingDetails() {
		// TODO Auto-generated method stub
		
		List<Payment1Model> list = new ArrayList<>();
		
		try {
		PreparedStatement pst = conn.prepareStatement("select distinct transporter_code from transportercreditdebit");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			Payment1Model model = new Payment1Model();
			
			BigDecimal sum_debit = new BigDecimal(0);
			BigDecimal sum_credit = new BigDecimal(0);
			BigDecimal debit_credit = new BigDecimal(0);
			
			
			PreparedStatement pst1 = conn.prepareStatement("SELECT sum(Amount) from `transportercreditdebit` WHERE transporter_code='"+rs.getString(1)+"' and Typecode='101'");
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			{
				if(!(rs1.getBigDecimal(1)==null))
				 sum_debit = rs1.getBigDecimal(1);
			}
			
			PreparedStatement pst2 = conn.prepareStatement("SELECT sum(Amount) from `transportercreditdebit` WHERE transporter_code='"+rs.getString(1)+"' and Typecode='201'");
			ResultSet rs2 = pst2.executeQuery();
			if(rs2.next())
			{
				if(!(rs2.getBigDecimal(1)==null))
				sum_credit = rs2.getBigDecimal(1);
			}
			
			debit_credit = sum_debit.subtract(sum_credit);
			System.out.println("sum_debit: "+sum_debit);
			System.out.println("sum_debit: "+sum_credit);
			System.out.println("debit_credit: "+debit_credit);
			int res;
			res = sum_debit.compareTo(sum_credit);
		      
			if(res == 1)
			{
				model.setTransporter_code(rs.getString(1));
				PreparedStatement pst3 = conn.prepareStatement("select * from transporter_master where transporter_no = '"+model.getTransporter_code()+"'");
				ResultSet rs3 = pst3.executeQuery();
				
				if(rs3.next())
				{
					model.setTransporter_name(rs3.getString("transporter_name"));
					model.setTransporter_address(rs3.getString("transporter_address"));
					model.setTransporter_mobile(rs3.getString("mobile"));
					model.setCity(rs3.getString("city"));
					model.setCompany(rs3.getString("company_name"));
				}
				
				model.setAmt2(String.valueOf(debit_credit));
				list.add(model);
			}
			
			
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Payment1Model> getCustomerOutstandingDetails() {
		// TODO Auto-generated method stub
		
		List<Payment1Model> list = new ArrayList<>();
		
		try {
		PreparedStatement pst = conn.prepareStatement("select distinct Customercode from customercreditdebit");
		ResultSet rs = pst.executeQuery();
		
		while(rs.next())
		{
			Payment1Model model = new Payment1Model();
			
			BigDecimal sum_debit = new BigDecimal(0);
			BigDecimal sum_credit = new BigDecimal(0);
			BigDecimal debit_credit = new BigDecimal(0);
			
			
			PreparedStatement pst1 = conn.prepareStatement("SELECT sum(Amount) from `customercreditdebit` WHERE Customercode='"+rs.getString(1)+"' and Typecode='101'");
			ResultSet rs1 = pst1.executeQuery();
			if(rs1.next())
			{
				if(!(rs1.getBigDecimal(1)==null))
				 sum_debit = rs1.getBigDecimal(1);
			}
			
			PreparedStatement pst2 = conn.prepareStatement("SELECT sum(Amount) from `customercreditdebit` WHERE Customercode='"+rs.getString(1)+"' and Typecode='201'");
			ResultSet rs2 = pst2.executeQuery();
			if(rs2.next())
			{
				if(!(rs2.getBigDecimal(1)==null))
				sum_credit = rs2.getBigDecimal(1);
			}
			
			debit_credit = sum_debit.subtract(sum_credit);
			System.out.println("sum_debit: "+sum_debit);
			System.out.println("sum_debit: "+sum_credit);
			System.out.println("debit_credit: "+debit_credit);
			int res;
			res = sum_debit.compareTo(sum_credit);
		      
			if(res == 1)
			{
				model.setTransporter_code(rs.getString(1));
				PreparedStatement pst3 = conn.prepareStatement("select * from customer_master_details where customer_no = '"+model.getTransporter_code()+"'");
				ResultSet rs3 = pst3.executeQuery();
				
				if(rs3.next())
				{
					model.setTransporter_name(rs3.getString("customer_name"));
					model.setTransporter_address(rs3.getString("customer_address"));
					model.setTransporter_mobile(rs3.getString("mobile_no"));
					model.setCity(rs3.getString("city"));
					model.setCompany(rs3.getString("company_name"));
				}
				
				model.setAmt2(String.valueOf(debit_credit));
				list.add(model);
			}
			
			
			
		}
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Payment1Model> getTransporterPayDetails(String transporter_name, String from_date, String to_date) {
		// TODO Auto-generated method stub
		
		String[] trans = transporter_name.split("-");
		
		List<Payment1Model> list = new ArrayList<>();
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from transporterpayment where transporter_id = '"+trans[1]+"'"+" and date between '"+from_date+"' and '"+to_date+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Payment1Model model = new Payment1Model();
				model.setTransporter_name(rs.getString("transporter_name"));
				model.setReceipt_no(rs.getString("receiptno"));
				model.setDate(rs.getString("date"));
				model.setPaid_amount(rs.getString("paidamount"));
				
				list.add(model);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<Payment1Model> getCustomerPayDetails(String customer_name, String from_date, String to_date) {
		// TODO Auto-generated method stub
		
		String[] cust = customer_name.split("-");
		
		List<Payment1Model> list = new ArrayList<>();
		
		try {
			PreparedStatement pst = conn.prepareStatement("select * from customerpayment where customerid = '"+cust[1]+"'"+" and date between '"+from_date+"' and '"+to_date+"'");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Payment1Model model = new Payment1Model();
				model.setTransporter_name(rs.getString("customername"));
				model.setReceipt_no(rs.getString("receiptno"));
				model.setDate(rs.getString("date"));
				model.setPaid_amount(rs.getString("paidamount"));
				
				list.add(model);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
