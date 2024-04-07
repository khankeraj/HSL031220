package com.master.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.DB.DBConnection;
import com.master.model.Area_Master_Bean;
import com.master.model.Dc_bean;
import com.master.model.Dealer_Payment_Bean;
import com.master.model.LoginBean;
import com.master.model.Product_Sale_Bean;
import com.master.model.expenses_Bean;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;


public class dealer_payment_dao
{

	/*public String insertdealerpayment(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub

		String response="";	Connection connection=null;String amtpert="";String stringValue="";
		try
		{

			 connection=DaoHelper.getConnection();
			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();

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


			PreparedStatement preparedStatement1=connection.prepareStatement("SELECT * FROM  amountreceived");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	

		

			int size=len+1;
			stringValue=String.valueOf(size);
			 amtpert=dpb.getAmtpert();
			String ap=dpb.getAmtpert();
			if (amtpert.equals("DealerPayment")) {
				ap="DP";
			}
			if (amtpert.equals("ProductSale")) {
				ap="PS";
			}
			if (amtpert.equals("Feedback")) {
				ap="FB";
			}
			if (amtpert.equals("Amc")) {
				ap="AM";
			}
			if (amtpert.equals("CashReturn")) {
				ap="CR";
			}
			if (amtpert.equals("BankDeposit")) {
				ap="BD";
			}
			if(amtpert.equals("CashTransfer")){
				ap="CT";
			}
			
			if(stringValue.length()==1)
			{
				stringValue="RCPNO/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="RCPNO/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="RCPNO/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="RCPNO/"+ap+"/"+stringValue;
			}

			System.out.println(stringValue);
			dpb.setVoucher_no(stringValue);

			String s="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;	
			if (amtpert.equals("DealerPayment")) {
				
				
				try{
					 s=dpb.getDealer_code();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
				System.out.println(s);
			String a4="insert into stock_transfer_payment(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst4=connection.prepareStatement(a4);  

			pst4.setString(1, s);

			pst4.setString(3, dpb.getPaymod());

			pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));	

			//pst4.setString(4,stb.getNet_amount());	
			pst4.setString(4,dpb.getDealer_payment_amt());

			//pst4.setString(4,dpb.getBalance_amt());
			pst4.setString(5,dpb.getBankname());

			pst4.setString(6,dpb.getCheque_date());

			pst4.setString(7,dpb.getCheque_no());

			pst4.setString(8,dpb.getCheque_amt());

			pst4.setString(9,"chequereceived");

			pst4.setString(10,"1");



			pst4.setInt(11, bean.getUid());

			pst4.setString(12, stringValue);

			pst4.setString(13, "dealerpaymentform");
			pst4.setString(14, dpb.getRemark());
			pst4.setString(15, dpb.getEmpcode());
			pst4.setString(16, dpb. getIcr_no());
			pst4.setString(17, dpb.getAmtpert());
			System.out.println(pst4);
			q=pst4.executeUpdate();
			}


			String a41="insert into amountreceived(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert,receivedstatus,chequecredit,chequedebit,cashcredit,cashdebit,verifyby,suppliername,supplierbankname,suppliercity,fromcounter,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst41=connection.prepareStatement(a41);  

			pst41.setString(1, s);

			pst41.setString(3, dpb.getPaymod());

			pst41.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));

			//pst4.setString(4,stb.getNet_amount());	
			pst41.setString(4,dpb.getDealer_payment_amt());

			//pst4.setString(4,dpb.getBalance_amt());
			pst41.setString(5,dpb.getBankname());

			pst41.setString(6,dpb.getCheque_date());

			pst41.setString(7,dpb.getCheque_no());

			pst41.setString(8,dpb.getCheque_amt());
			
				pst41.setString(9,"1");
			

			pst41.setString(10,"1");
			pst41.setInt(11, bean.getUid());

			pst41.setString(12, stringValue);

			pst41.setString(13, "dealerpaymentform");
			pst41.setString(14, dpb.getRemark());
			pst41.setString(15, dpb.getEmpcode());
			pst41.setString(16, dpb. getIcr_no());
			pst41.setString(17, dpb.getAmtpert());
			
			if (amtpert.equals("DealerPayment")) {
			pst41.setString(18,"2");
			}else{
				pst41.setString(18,"1");	
			}
			
			String chequecredit="";
			String chequedebit="";
			String cashcredit="";
			String cashdebit="";
		
			
			if(dpb.getPaymod().equals("1")){
				
				cashcredit=	dpb.getDealer_payment_amt();
			}
			else{
				
				chequecredit=	dpb.getDealer_payment_amt();
			}
if(dpb.getPaymod().equals("4")){
				
	cashdebit=dpb.getDealer_payment_amt();
			}

if(dpb.getPaymod().equals("6")){
	
	chequecredit=dpb.getDealer_payment_amt();
			}
if (amtpert.equals("BankDeposit")) {
	
	 chequecredit="";
	 chequedebit="";
	 cashcredit="";
	 cashdebit="";	
	 if(dpb.getPaymod().equals("6")){
	 cashdebit=dpb.getDealer_payment_amt();
	 chequecredit=dpb.getDealer_payment_amt();
	 }
	 
	 
}


			pst41.setString(19,chequecredit);
			pst41.setString(20,chequedebit);
			pst41.setString(21,cashcredit);
			pst41.setString(22,cashdebit);
			
			pst41.setString(23, dpb.getVerifyby());
			pst41.setString(24, dpb.getSuppliername());
			pst41.setString(25, dpb.getSupplierbankname());
			pst41.setString(26, dpb.getSuppliercity());
			if (amtpert.equals("CashTransfer")) {
				pst41.setString(27, dpb.getFromcounter());
				pst41.setString(28, dpb.getTocounter());
			}else{
				pst41.setString(27, "");
				pst41.setString(28, "");
			}
			System.out.println(pst41);
			 
			q=pst41.executeUpdate();
			
			String a412="insert into creditdebitreport2(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert,receivedstatus,chequecredit,chequedebit,cashcredit,cashdebit,transcation_id,fromcounter,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst412=connection.prepareStatement(a412);  

			pst412.setString(1, s);

			pst412.setString(3, dpb.getPaymod());

			pst412.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));

			//pst4.setString(4,stb.getNet_amount());	
			pst412.setString(4,dpb.getDealer_payment_amt());

			//pst4.setString(4,dpb.getBalance_amt());
			pst412.setString(5,dpb.getBankname());

			pst412.setString(6,dpb.getCheque_date());

			pst412.setString(7,dpb.getCheque_no());

			pst412.setString(8,dpb.getCheque_amt());
			
			pst412.setString(9,"1");
			

			pst412.setString(10,"1");
			pst412.setInt(11, bean.getUid());

			pst412.setString(12, stringValue);

			pst412.setString(13, "dealerpaymentform");
			pst412.setString(14, dpb.getRemark());
			pst412.setString(15, dpb.getEmpcode());
			pst412.setString(16, dpb. getIcr_no());
			pst412.setString(17, dpb.getAmtpert());
			pst412.setString(18,"1");
			String chequecredit1="";
			String chequedebit1="";
			String cashcredit1="";
			String cashdebit1="";
		
			
			if(dpb.getPaymod().equals("1")){
				
				cashcredit1=	dpb.getDealer_payment_amt();
			}
			else{
				
				chequecredit1=	dpb.getDealer_payment_amt();
			}
			
		
			
			if(dpb.getPaymod().equals("4")){
				
				chequecredit1=dpb.getDealer_payment_amt();
			}


			if (amtpert.equals("BankDeposit")) {
				 chequecredit1="";
				 chequedebit1="";
				 cashcredit1="";
				 cashdebit1="";	
				 if(dpb.getPaymod().equals("6")){
				 cashdebit1=dpb.getDealer_payment_amt();
				 chequecredit1=dpb.getDealer_payment_amt();
				 }
			}

			if (amtpert.equals("CashTransfer")) {
				
				 chequecredit1="";
				 chequedebit1="";
				 cashcredit1="";
				 cashdebit1="";
				
				// cashdebit1=dpb.getDealer_payment_amt();
				 cashcredit1=dpb.getDealer_payment_amt();
				 }
			pst412.setString(19,chequecredit1);
			pst412.setString(20,chequedebit1);
			pst412.setString(21,cashcredit1);
			pst412.setString(22,cashdebit1);
			
			pst412.setString(23,dpb.getTranscation_id());
			pst412.setString(24,dpb.getFromcounter());
			pst412.setString(25,dpb.getTocounter());
			
			System.out.println(pst412);
			 if(!dpb.getPaymod().equals("5")){
			q=pst412.executeUpdate();
			 }
			 //-----------------------------------------------------------------------------------------------------------
			 if(amtpert.equals("CashTransfer")){
				  a412="insert into creditdebitreport2(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert,receivedstatus,chequecredit,chequedebit,cashcredit,cashdebit,transcation_id,fromcounter,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					 pst412=connection.prepareStatement(a412);  

					pst412.setString(1, s);

					pst412.setString(3, dpb.getPaymod());

					pst412.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));

					//pst4.setString(4,stb.getNet_amount());	
					pst412.setString(4,dpb.getDealer_payment_amt());

					//pst4.setString(4,dpb.getBalance_amt());
					pst412.setString(5,dpb.getBankname());

					pst412.setString(6,dpb.getCheque_date());

					pst412.setString(7,dpb.getCheque_no());

					pst412.setString(8,dpb.getCheque_amt());
					
					pst412.setString(9,"1");
					

					pst412.setString(10,"1");
					pst412.setInt(11, bean.getUid());

					pst412.setString(12, stringValue);

					pst412.setString(13, "dealerpaymentform");
					pst412.setString(14, dpb.getRemark());
					pst412.setString(15, dpb.getEmpcode());
					pst412.setString(16, dpb. getIcr_no());
					pst412.setString(17, dpb.getAmtpert());
					pst412.setString(18,"1");
					 chequecredit1="";
					 chequedebit1="";
					 cashcredit1="";
					 cashdebit1="";
				
					
					if(dpb.getPaymod().equals("1")){
						
						cashcredit1=	"-"+dpb.getDealer_payment_amt();
					}
					else{
						
						chequecredit1=	"-"+dpb.getDealer_payment_amt();
					}
					
				
					
					if(dpb.getPaymod().equals("4")){
						
						cashdebit1="-"+dpb.getDealer_payment_amt();
					}


					if (amtpert.equals("CashTransfer")) {
						 chequecredit1="";
						 chequedebit1="";
						 cashcredit1="";
						 cashdebit1="";	
						 
						 cashcredit1="-"+dpb.getDealer_payment_amt();
						 
					}
					
					pst412.setString(19,chequecredit1);
					pst412.setString(20,chequedebit1);
					pst412.setString(21,cashcredit1);
					pst412.setString(22,cashdebit1);
					
					pst412.setString(23,dpb.getTranscation_id());
					pst412.setString(24,dpb.getTocounter());
					pst412.setString(25,dpb.getFromcounter());
					
					System.out.println(pst412);
					 if(!dpb.getPaymod().equals("5")){
					q=pst412.executeUpdate();
					 }
			 }
			 //------------------------------------------------------------------------------------------------------------
			if (amtpert.equals("DealerPayment")) {
			PreparedStatement pst3=connection.prepareStatement("update dealer_master set creditamount=creditamount+"+dpb.getDealer_payment_amt()+" where dealer_code='"+s+"'");

			int i=pst3.executeUpdate();


			PreparedStatement pst31=connection.prepareStatement("Insert into creditdebitreport(Dealercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,USERNAME,DATETIME) VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Dealer Payment','201','Credit','"+dpb.getDealer_payment_amt()+"','','"+ bean.getUid()+"','"+ date+"')");

			i=pst31.executeUpdate();
			System.out.println(pst31);
			
			}
			response="success";
		}
		catch(Exception e)
		{

			response="fail";
		}
		
		
if (amtpert.equals("DealerPayment")) {

			
			
			Properties systemPropery = null;
			systemPropery = new Properties();

			try {
				systemPropery
						.load(new complain_Dao1()
								.getClass()
								.getResourceAsStream(
										"/com/aqua/dao/UserProfile.properties"));
				String userid = systemPropery.getProperty("USERID");
				String senderid = systemPropery.getProperty("SENDERID");
				String pass = systemPropery.getProperty("SMSPASS");
				String smsflag = systemPropery.getProperty("SMSFLAG");
				String os = "";
				String mob = "";
				String s="";String s1="";
				try{
					 s=dpb.getDealer_code();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
				
			
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
				try {
					String a921="select dealer_contact,creditamount,dealer_name from dealer_master where dealer_code='"+s+"' ";
					PreparedStatement pst321 = connection.prepareStatement(a921);
					 
					ResultSet resultSet1121=pst321.executeQuery(a921);
					if(resultSet1121.next())
					{
						mob=resultSet1121.getString("dealer_contact");
						os=resultSet1121.getString("creditamount");
						s1=resultSet1121.getString("dealer_name");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				String requestUrl = "http://bhashsms.com/api/sendmsg.php?user="
						+ userid
						+ "&pass="
						+ pass
						+ "&sender="
						+ senderid
						+ "&phone="
						+ mob
						+ "&text=Dear "+s1+",Thanks for doing the Payment of Rs."+dpb.getDealer_payment_amt()+" by "+dpb.getRemark()+" and Your Recipt no is "+stringValue+". Now Your Total O/S is Rs."+os+". If any Query Pls Call 9766001166 , www.aquayash.in&priority=ndnd&stype=normal";

				// System.out.println("http://bhashsms.com/api/sendmsg.php?user="+userid+"&pass="+pass+"&sender="+senderid+"&phone="+comp_Dao.getMobile_no()+"&text=Dear "+comp_Dao.getCustomer_name()+", Your Complain is successfully locked on "+comp_Dao.getDate()+" and Complain No is "+ccomp+". Our team will shortly contact you.&priority=ndnd&stype=normal"
				// );
				// if(smsflag.equals("1")){
				// System.out.println("http://bhashsms.com/api/sendmsg.php?user="+userid+"&pass="+pass+"&sender="+senderid+"&phone="+psb.getMobno1()+"&text=Dear "+psb.getCust_name()+", Welcome to Aquayash Water Purifier family. Your Product will have "+warranty+" months Warranty.If Any query call on helpline no. 9765876000&priority=ndnd&stype=normal");

				requestUrl = requestUrl.replace(" ", "%20");
				// String
				// encodedURL=java.net.URLEncoder.encode(requestUrl,"UTF-8");
				URL url = new URL(requestUrl);

				HttpURLConnection uc = (HttpURLConnection) url
						.openConnection();
				uc.addRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
				System.out.println("Error" + uc.getResponseMessage());

				uc.disconnect();

				// URL myURL = new
				// URL("http://bhashsms.com/api/sendmsg.php?user="+userid+"&pass="+pass+"&sender="+senderid+"&phone="+psb.getMobno1()+"&text=Dear "+psb.getCust_name()+", Welcome to Aquayash Water Purifier family. Your Product will have "+warranty+" months Warranty.If Any query call on helpline no. 9765876000&priority=ndnd&stype=normal");
				// URLConnection myURLConnection =
				// myURL.openConnection();
				// myURLConnection.connect();
				// System.out.println("http://bhashsms.com/api/sendmsg.php?user="+userid+"&pass="+pass+"&sender="+senderid+"&phone="+psb.getMobno1()+"&text=Dear "+psb.getCust_name()+", Welcome to Aquayash Water Purifier family. Your Product will have "+warranty+" months Warranty.If Any query call on helpline no. 9765876000&priority=ndnd&stype=normal");

				// }
			} catch (MalformedURLException e) {
				// new URL() failed
				// ...aquayash
				System.out.println("MalformedURLException:"
						+ e.getMessage());
			} catch (IOException e) {
				// openConnection() failed
				// ...
				System.out.println("IOException:" + e.getMessage());
		}
		
			
			
		}
		
		
		return response;
		
		

		//return null;

	}*/

	public String insertexpenses(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";
		try
		{
			String s="";

			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
			
			
			String stringValue="";
			int len=0;


			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  expenses");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	


			int size=len+1;
			stringValue=String.valueOf(size);

			if(stringValue.length()==1)
			{
				stringValue="ARS/VCHNO/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="ARS/VCHNO/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="ARS/VCHNO/0"+stringValue;
			}
			else
			{
				stringValue="ARS/VCHNO/"+stringValue;
			}


			dpb.setVoucher_no(stringValue);

			
			
			try{
				 s=dpb.getDealer_code();
			s = s.substring(s.indexOf("(") + 1);
			s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}

			
			int q=0;	
			String a4="insert into expenses(voucher_no,amount,date1,reason,stcode,remark,exppart,bankname,paymode,chequeno,chequedate,chequebank,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst4=conn.prepareStatement(a4);  
			pst4.setString(1, stringValue);
			pst4.setString(2,dpb.getDealer_payment_amt());
			try{
			pst4.setString(3,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst4.setString(3,null);
			}
			pst4.setString(4,dpb.getTranscation_id());	
			pst4.setString(5, s);
			
			pst4.setString(6, dpb.getRemark());
		
			pst4.setString(7, dpb.getExppart());
			pst4.setString(8, dpb.getBankname1());
			pst4.setString(9, dpb.getPaymod());
			pst4.setString(10, dpb.getCheque_no());
			pst4.setString(11,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
			pst4.setString(12, dpb.getBankname());
			pst4.setString(13, dpb.getTocounter());
			
			
			q=pst4.executeUpdate();


			String a412="insert into creditdebitreport2(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert,receivedstatus,chequecredit,chequedebit,cashcredit,cashdebit,transcation_id,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst412=conn.prepareStatement(a412);  

			pst412.setString(1, "");

			pst412.setString(3, dpb.getPaymod());

			pst412.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));

			//pst4.setString(4,stb.getNet_amount());	
			pst412.setString(4,dpb.getDealer_payment_amt());

			//pst4.setString(4,dpb.getBalance_amt());
			pst412.setString(5,dpb.getBankname());

			pst412.setString(6,dpb.getCheque_date());

			pst412.setString(7,dpb.getCheque_no());

			pst412.setString(8,dpb.getCheque_amt());
			
			pst412.setString(9,"1");
			

			pst412.setString(10,"1");
			pst412.setInt(11, 5);

			pst412.setString(12, stringValue);

			pst412.setString(13, "dealerpaymentform");
			pst412.setString(14, dpb.getRemark());
			pst412.setString(15, s);
			pst412.setString(16, "");
			pst412.setString(17, dpb.getExppart());
			pst412.setString(18,"1");
			String chequecredit1="";
			String chequedebit1="";
			String cashcredit1="";
			String cashdebit1="";
		
			
			if(dpb.getPaymod().equals("1")){
				
				cashdebit1=	dpb.getDealer_payment_amt();
			}
			else{
				
				chequedebit1=	dpb.getDealer_payment_amt();
			}
			
			pst412.setString(19,chequecredit1);
			pst412.setString(20,chequedebit1);
			pst412.setString(21,cashcredit1);
			pst412.setString(22,cashdebit1);
			
			pst412.setString(23,dpb.getTranscation_id());
			pst412.setString(24,dpb.getTocounter());
			System.out.println(pst412);
			
			q=pst412.executeUpdate();
			
			
			
			//Bank Leadger Entry
			
			if(dpb.getPaymod().equals("3") || dpb.getPaymod().equals("4"))
			{
					
			System.out.println("1");	
			String a44="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)";
			PreparedStatement pst44=conn.prepareStatement(a44);  
			pst44.setString(1, stringValue);
			try{
			pst44.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst44.setString(2,null);
			}

			pst44.setString(3, dpb.getBankname());
			pst44.setString(4, "Debit");
			
			pst44.setString(5,dpb.getDealer_payment_amt());
			pst44.setString(6, dpb.getExppart());
			pst44.setString(7, s);
			
			System.out.println("Sql:"+pst44);
			q=pst44.executeUpdate();

			
			}
			
			
			
			//Cash Leadger Entry
			
			if(dpb.getPaymod().equals("1"))
			{
					
			System.out.println("1");	
			String a44="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)";
			PreparedStatement pst44=conn.prepareStatement(a44);  
			pst44.setString(1, stringValue);
			try{
			pst44.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst44.setString(2,null);
			}

			pst44.setString(3,"");
			pst44.setString(4, "Debit");
			
			pst44.setString(5,dpb.getDealer_payment_amt());
			pst44.setString(6,"Cash");
			pst44.setString(7, s);
			
			System.out.println("Sql:"+pst44);
			q=pst44.executeUpdate();

			
			}
			
			
			
			
			
			
			String name="";
			if(dpb.getPaymod().equals("3") )
			{
				
				
				try {
					String aa = "select * from emp_master where emp_id='"+s+"' ";
						
					PreparedStatement pst11 = conn.prepareStatement(aa);
					
					System.out.println(pst11);
					ResultSet rsa = pst11.executeQuery();
					if (rsa.next()) {

						
						name=rsa.getString("emp_name");
						

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			PreparedStatement pst = conn.prepareStatement("insert into chequeprint(date,name,amount,chequeno,bankname) values(?,?,?,?,?) ");
			pst.setString(1, dpb.getCheque_date());
			pst.setString(2, name);
			pst.setString(3, dpb.getCheque_amt());
			pst.setString(4, dpb.getCheque_no());
			pst.setString(5,dpb.getBankname());
			
			int i = pst.executeUpdate();
			
			}
			
			String recno="";
			try {
				String aa = "select * from chequeprint where chequeno='"+dpb.getCheque_no()+"' ";
					
				PreparedStatement pst11 = conn.prepareStatement(aa);
				
				System.out.println(pst11);
				ResultSet rsa = pst11.executeQuery();
				if (rsa.next()) {

					
					recno=rsa.getString("recno");
					

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dpb.setRecno(recno);
			dpb.setEmp_name(name);
			
			//System.out.println("Emp Nmae::"+dpb.getEmp_name());
			response="success";


		}
		catch(Exception e)
		{

			response="fail";
		}
		return response;

		//return null;
	}

	public String insertexpensesv(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";
		try
		{

			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
			
			
			String stringValue="";
			int len=0;


			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  expensesv");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	


			int size=len+1;
			stringValue=String.valueOf(size);

			if(stringValue.length()==1)
			{
				stringValue="ARS/VCHNO/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="ARS/VCHNO/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="ARS/VCHNO/0"+stringValue;
			}
			else
			{
				stringValue="ARS/VCHNO/"+stringValue;
			}


			dpb.setVoucher_no(stringValue);


			
			int q=0;	
			String a4="insert into expensesv(voucher_no,amount,date1,reason,stcode,remark,exppart,bankname,paymode,chequeno,chequedate,chequebank,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst4=conn.prepareStatement(a4);  
			pst4.setString(1, stringValue);
			pst4.setString(2,dpb.getDealer_payment_amt());
			try{
			pst4.setString(3,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst4.setString(3,null);
			}
			pst4.setString(4,dpb.getTranscation_id());	
			pst4.setString(5, dpb.getDealer_code());
			
			pst4.setString(6, dpb.getRemark());
		
			pst4.setString(7, dpb.getExppart());
			pst4.setString(8, dpb.getBankname1());
			pst4.setString(9, dpb.getPaymod());
			pst4.setString(10, dpb.getCheque_no());
			pst4.setString(11,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
			pst4.setString(12, dpb.getBankname());
			pst4.setString(13, dpb.getTocounter());
			
			
			q=pst4.executeUpdate();


			String a412="insert into creditdebitreport2v(dealerCode,dateS,paymentMode,paidamt,bankName,dateCheq,cheqNo,amtCheq,cheqStatus,o_s_Status,uid,voucher_no,from_form_status,remark,empcode,icr_no,amtpert,receivedstatus,chequecredit,chequedebit,cashcredit,cashdebit,transcation_id,tocounter) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst412=conn.prepareStatement(a412);  

			pst412.setString(1, "");

			pst412.setString(3, dpb.getPaymod());

			pst412.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));

			//pst4.setString(4,stb.getNet_amount());	
			pst412.setString(4,dpb.getDealer_payment_amt());

			//pst4.setString(4,dpb.getBalance_amt());
			pst412.setString(5,dpb.getBankname());

			pst412.setString(6,dpb.getCheque_date());

			pst412.setString(7,dpb.getCheque_no());

			pst412.setString(8,dpb.getCheque_amt());
			
			pst412.setString(9,"1");
			

			pst412.setString(10,"1");
			pst412.setInt(11, 5);

			pst412.setString(12, stringValue);

			pst412.setString(13, "dealerpaymentform");
			pst412.setString(14, dpb.getRemark());
			pst412.setString(15, dpb.getDealer_code());
			pst412.setString(16, "");
			pst412.setString(17, dpb.getExppart());
			pst412.setString(18,"1");
			String chequecredit1="";
			String chequedebit1="";
			String cashcredit1="";
			String cashdebit1="";
		
			
			if(dpb.getPaymod().equals("1")){
				
				cashdebit1=	dpb.getDealer_payment_amt();
			}
			else{
				
				chequedebit1=	dpb.getDealer_payment_amt();
			}
			
			pst412.setString(19,chequecredit1);
			pst412.setString(20,chequedebit1);
			pst412.setString(21,cashcredit1);
			pst412.setString(22,cashdebit1);
			
			pst412.setString(23,dpb.getTranscation_id());
			pst412.setString(24,dpb.getTocounter());
			System.out.println(pst412);
			
			q=pst412.executeUpdate();
			
			
			String q31 = "update expenses set vstatus='1' where voucher_no=?";

			PreparedStatement p41 = conn.prepareStatement(q31);
			p41.setString(1, dpb.getVoucher_no());
			System.out.println(p41);
			

			response="success";


		}
		catch(Exception e)
		{

			response="fail";
		}
		return response;

		//return null;
	}


	
	
	public String insertdealerpaymentv(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";	Connection connection=null;String amtpert="";String stringValue="";
		try
		{

			DBConnection connection1=new  DBConnection();Connection conn=connection1.getConnection();

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


			PreparedStatement preparedStatement1x=conn.prepareStatement("SELECT * FROM  lrform_paymentv");

			ResultSet resultSet1x=preparedStatement1x.executeQuery();
			while(resultSet1x.next()){
				len++;
			}	

		

			int size=len+1;
			stringValue=String.valueOf(size);
			 amtpert=dpb.getAmtpert();
			
String ap="SP";
			
			
			
			if(stringValue.length()==1)
			{
				stringValue="VNO/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="VNO/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="VNO/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="VNO/"+ap+"/"+stringValue;
			}

			

			dpb.setVoucher_no(stringValue);

			String s="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;	
		
				
				
				try{
					 s=dpb.getDealer_code();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
		
				
				String name="";
				
				PreparedStatement pt=conn.prepareStatement("SELECT * FROM  company_master where company_id='"+s+"'");

				ResultSet rs=pt.executeQuery();
				if(rs.next()){
					
					
					 name=rs.getString("company_name");
				}
				
				try{
				
				if(dpb.getPaymod().equals("1")){
					dpb.setPaid_amt(dpb.getNet_amount());
				}
				}catch(Exception e){
					
				}
				
				PreparedStatement pstcx9 = conn.prepareStatement("insert into lrform_paymentv(Invoiceno,suppliername,"
						+ "customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque"
						+ ",paybycredit,lr_no,supplierid,date,particular,verifyby) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				
				
				pstcx9.setString(1, stringValue);
				pstcx9.setString(2, name);
				pstcx9.setString(3,"");
				
			
				
				
					String paybycash=dpb.getDealer_payment_amt();
					System.out.println(dpb.getDealer_payment_amt());
				
					pstcx9.setString(4,paybycash );
					pstcx9.setString(5,dpb.getPaymod());
					try{
					pstcx9.setString(6,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
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
					
					pstcx9.setString(13, stringValue);	
					pstcx9.setString(14, s);	
					pstcx9.setString(15,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
					pstcx9.setString(16, dpb.getAmtpert());	
					pstcx9.setString(17, dpb.getVerifyby());
				System.out.println("q4"+pstcx9);
			
				int j9s = pstcx9.executeUpdate();
			 //-----------------------------------------------------------------------------------------------------------
			
			 //------------------------------------------------------------------------------------------------------------
			
			
			PreparedStatement pst31=conn.prepareStatement("Insert into creditdebitreportv(Dealercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,USERNAME,DATETIME) VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Supplier Payment','201','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"','5','"+ date+"')");
			System.out.println(pst31);
			int i=pst31.executeUpdate();
			
			
			
			response="success";
		}
		catch(Exception e)
		{

			response="fail";
		}
		
			
		
		return response;
		
		

		//return null;

	}
	
	
	
	
	
	
	public String insertsupplierpaymentv(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";	Connection connection=null;String amtpert="";String stringValue="";
		try
		{

			DBConnection connection1=new  DBConnection();Connection conn=connection1.getConnection();

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


			PreparedStatement preparedStatement1x=conn.prepareStatement("SELECT * FROM  lrform_paymentv");

			ResultSet resultSet1x=preparedStatement1x.executeQuery();
			while(resultSet1x.next()){
				len++;
			}	

		

			int size=len+1;
			stringValue=String.valueOf(size);
			 amtpert=dpb.getAmtpert();
			
String ap="SP";
			
			
			
			if(stringValue.length()==1)
			{
				stringValue="VNO/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="VNO/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="VNO/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="VNO/"+ap+"/"+stringValue;
			}

			

			dpb.setVoucher_no(stringValue);

			String dealercode="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;	
		
			String s="";
			String name="";
				try{
					 s=dpb.getDealer_code();
					 String parts[]=s.split("~");
					 dealercode=parts[1];
					 name=parts[0];
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
		
				
				
				
				/*PreparedStatement pt=connection.prepareStatement("SELECT * FROM  company_master where company_name='"+dpb.getDealer_code()+"'");

				ResultSet rs=pt.executeQuery();
				if(rs.next()){
					
					
					 dealercode=rs.getString("company_id");
				}*/
				
				try{
				
				if(dpb.getPaymod().equals("1")){
					dpb.setPaid_amt(dpb.getNet_amount());
				}
				}catch(Exception e){
					
				}
				
				
				//dealercode=dpb.getDealer_code();
				
				PreparedStatement pstcx9 = conn.prepareStatement("insert into lrform_paymentv(Invoiceno,suppliername,"
						+ "customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque"
						+ ",paybycredit,lr_no,supplierid,date,particular,verifyby,bankname) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				
				
				pstcx9.setString(1, stringValue);
				pstcx9.setString(2,name);
				pstcx9.setString(3,"");
				
			
				
				
					String paybycash=dpb.getDealer_payment_amt();
					System.out.println(dpb.getDealer_payment_amt());
				
					pstcx9.setString(4,paybycash );
					pstcx9.setString(5,dpb.getPaymod());
					try{
					pstcx9.setString(6,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
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
					
					pstcx9.setString(13, stringValue);	
					pstcx9.setString(14, dealercode);	
					pstcx9.setString(15,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
					pstcx9.setString(16, dpb.getRemark());	
					pstcx9.setString(17, dpb.getVerifyby());
					
					
					try{
						pstcx9.setString(18,dpb.getBankname());
						}catch(Exception e){
							
							pstcx9.setString(18,"");	
						}
					
				System.out.println("q4"+pstcx9);
			
				int j9s = pstcx9.executeUpdate();
			 //-----------------------------------------------------------------------------------------------------------
			
			 //------------------------------------------------------------------------------------------------------------
			
			
			PreparedStatement pst31=conn.prepareStatement("Insert into creditdebitreportv(Dealercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,USERNAME,DATETIME) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Supplier Payment','201','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"','5','"+ date+"')");
			System.out.println(pst31);
			int i=pst31.executeUpdate();
			
			
			
			
			for(i=0;i<dpb.getInv1().length;i++)
			{
				System.out.println(dpb.getInv1()[i]);
				try{
					System.out.println(">>>>>"+dpb.getInvcheck()[i]);
				if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
					
				PreparedStatement pstcx99 = conn.prepareStatement("insert into supplier_payment_details(suppliername,date,invoiceno,balanceamount,paidamount,voucherno,suppcode) values(?,?,?,?,?,?,?)");
				System.out.println("For");
				

				pstcx99.setString(1, name);
				pstcx99.setString(2,dpb.getD11()[i]);
				pstcx99.setString(3,dpb.getInv1()[i]);
				pstcx99.setString(4,dpb.getTotamt1()[i]);
				pstcx99.setString(5,dpb.getReamt1()[i]);
				pstcx99.setString(6,stringValue);
				pstcx99.setString(7,dealercode);
				pstcx99.executeUpdate();
				
				System.out.println("SQL:"+pstcx99);
				
				}
				}catch(Exception e){}
			}
			
			
			for(i=0;i<dpb.getInv1().length;i++)
			{
				String amt = "";
				try{
					System.out.println(">>>>>"+dpb.getInvcheck()[i]);
				if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
				//System.out.println("Update");
				PreparedStatement pst=conn.prepareStatement("SELECT * FROM  lrformv where lr_no='"+dpb.getInv1()[i]+"'");

				//System.out.println("1"+pst);
				
				ResultSet rst=pst.executeQuery();
				
				if(rst.next()){
					
					 amt=rst.getString("remaining_amount");
					// System.out.println("Remain Amount:"+amt);
						
				
				String amt1=dpb.getReamt1()[i];
				
				
				//System.out.println("UI Amount:"+amt1);
				
				double amtnew=Double.parseDouble(amt)-Double.parseDouble(amt1);
				
				//System.out.println("New Amount:"+amtnew+"="+amt+"-"+amt1);
				
				String query1="update lrformv set remaining_amount='"+amtnew+"' where lr_no='"+dpb.getInv1()[i]+"'";
				
				
				PreparedStatement pst11=conn.prepareStatement(query1);
				
				System.out.println("2"+pst11);
				pst11.executeUpdate();
				
				}
				
			}}catch(Exception e){}
			}
			
			
			
			// Insert into Bank Ledger
			
			if(dpb.getPaymod().equals("3") || dpb.getPaymod().equals("4"))
			{
				
				
				// Debit
				
				PreparedStatement pstcx99 = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)");
				pstcx99.setString(1, stringValue);
				pstcx99.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				pstcx99.setString(3,dpb.getBankname());
				pstcx99.setString(4,"Debit");
				pstcx99.setString(5,dpb.getDealer_payment_amt());
				pstcx99.setString(6,"Bank");
				System.out.println(pstcx99);
				pstcx99.executeUpdate();
				
				
				// Credit
				
				
				PreparedStatement pst = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)");
				pst.setString(1, stringValue);
				pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				pst.setString(3,dpb.getBankname());
				pst.setString(4,"Credit");
				pst.setString(5,dpb.getDealer_payment_amt());
				pst.setString(6,"Supplier");
				pst.setString(7,dealercode);
				System.out.println(pst);
				pst.executeUpdate();
			
			}
			
			
			// Insert into Cash Ledger
			
						if(dpb.getPaymod().equals("1") )
						{
							
							
							PreparedStatement pst = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)");
							pst.setString(1, stringValue);
							pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
							pst.setString(3,"");
							pst.setString(4,"Debit");
							pst.setString(5,dpb.getDealer_payment_amt());
							pst.setString(6,"Cash");
							pst.setString(7,dealercode);
							System.out.println(pst);
							pst.executeUpdate();
												
						
						}
			
			
			//Insert into Cheque Print Table
			
			if(dpb.getPaymod().equals("3") )
			{
				
				PreparedStatement prepareStatement = conn
						.prepareStatement("select * from chequeprint where chequeno=? and chequeno<>'' and bankname=?");
				prepareStatement.setString(1, dpb.getCheque_no());
				prepareStatement.setString(2, dpb.getBankname());
				ResultSet resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					response = "AlreadyCheque";
				}
				
				else{	
			
			PreparedStatement pst = conn.prepareStatement("insert into chequeprint(date,name,amount,chequeno,bankname) values(?,?,?,?,?) ");
			pst.setString(1, dpb.getCheque_date());
			pst.setString(2, name);
			pst.setString(3, dpb.getCheque_amt());
			pst.setString(4, dpb.getCheque_no());
			pst.setString(5,dpb.getBankname());
			
			int i1 = pst.executeUpdate();
			
			}
			
			String recno="";
			try {
				String aa = "select * from chequeprint where chequeno='"+dpb.getCheque_no()+"' ";
					
				PreparedStatement pst11 = conn.prepareStatement(aa);
				
				System.out.println(pst11);
				ResultSet rsa = pst11.executeQuery();
				if (rsa.next()) {

					
					recno=rsa.getString("recno");
					

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dpb.setRecno(recno);
			dpb.setEmp_name(name);
			
			}
			
			
			response="success";
		}
		catch(Exception e)
		{

			response="fail";
		}
		
			
		
		return response;
		
		

		//return null;

	}
	
	
	public String insertcustomerpaymentv(Dealer_Payment_Bean dpb, LoginBean bean,String customer_name,String checkvalue,String lead_no,String invoice_no) {
		// TODO Auto-generated method stub
		System.out.println("in dao");
		String response;	
		Connection connection=null;
		String amtpert;
		String stringValue;
		try
		{

			DBConnection connection1=new  DBConnection();Connection conn=connection1.getConnection();

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
			while(resultSet1x.next()){
				len1++;
			}	

			int size=len1+1;
			stringValue=String.valueOf(size);
			
			 String ap="CP";
			
			
			
			if(stringValue.length()==1)
			{
				stringValue="CP/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="CP/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="CP/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="CP/"+ap+"/"+stringValue;
			}

			

		
			dpb.setVoucher_no(stringValue);

			String dealercode="";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			
			int q=0;	
		
				
				
				/*try{
					 s=dpb.getDealer_code();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}*/
			String s="";
			String name="";
				try{
					 s=dpb.getDealer_code();
					 String parts[]=s.split("~");
					 dealercode=parts[1];
					 name=parts[0];
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
				
				
				
				PreparedStatement pt=conn.prepareStatement("SELECT * FROM  customer_master_details where customer_name='"+dpb.getDealer_code()+"'");

				ResultSet rs=pt.executeQuery();
				if(rs.next()){
					
					
					 dealercode=rs.getString("cust_id");
				}
				
				try{
				
				if(dpb.getPaymod().equals("1")){
					dpb.setPaid_amt(dpb.getNet_amount());
				}
				}catch(Exception e){
					
				}
				
				//PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,customername,customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				
				if(checkvalue.equals("1"))
				{
					System.out.println("in customerPayment");
					
					PreparedStatement pstcx9 = conn.prepareStatement("insert into customerpayment(Invoiceno,customername,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,particular,bankname,receiptno,verifyby,lead_no,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
				
					pstcx9.setString(1, stringValue);
					pstcx9.setString(2, customer_name);
					String paybycash=dpb.getDealer_payment_amt();
					//System.out.println(dpb.getDealer_payment_amt());
				
					pstcx9.setString(3,paybycash );
					pstcx9.setString(4,dpb.getPaymod());
					try{
					pstcx9.setString(5,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
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
					pstcx9.setString(17, lead_no);
						//System.out.println("q4"+pstcx9);
						int j9s = pstcx9.executeUpdate();
						System.out.println("j9s1:"+j9s);
						
						PreparedStatement pst=conn.prepareStatement("UPDATE `invoice` SET `status`=2 WHERE  invoice_no='"+invoice_no+"' AND lead_no='"+lead_no+"'");
						int i=pst.executeUpdate();
						System.out.println("i:"+i+"pst:"+pst);
						
				}
					else if(checkvalue.equals("2"))
				{
					PreparedStatement pstcx9 = conn.prepareStatement("insert into customerpayment(Invoiceno,customername,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,particular,bankname,receiptno,verifyby,lead_no,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
					
					pstcx9.setString(1, stringValue);
					pstcx9.setString(2, customer_name);
					String paybycash=dpb.getDealer_payment_amt();
					//System.out.println(dpb.getDealer_payment_amt());
				
					pstcx9.setString(3,paybycash );
					pstcx9.setString(4,dpb.getPaymod());
					try{
					pstcx9.setString(5,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
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
					pstcx9.setString(17, lead_no);
						//System.out.println("q4"+pstcx9);
							int j9s = pstcx9.executeUpdate();
							
							PreparedStatement pst=conn.prepareStatement("UPDATE `invoice` SET `status`=2 WHERE  invoice_no='"+invoice_no+"' AND lead_no='"+lead_no+"'");
							int i=pst.executeUpdate();
							System.out.println("i:"+i+"pst:"+pst);
							System.out.println("j9s2:"+j9s);
				}
				
			 //-----------------------------------------------------------------------------------------------------------
			
			 //------------------------------------------------------------------------------------------------------------
		int i;
		if(checkvalue.equals("1"))
		{
			System.out.println("in creditdebit");
			
			PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) VALUES ('"+dealercode+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Customer Payment','201','Credit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
			System.out.println(pst31);
			i=pst31.executeUpdate();
			
			for(i=0;i<dpb.getInv1().length;i++)
			{
				try{
					System.out.println(">>>>>"+dpb.getInvcheck()[i]);
				if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
				PreparedStatement pstcx99 = conn.prepareStatement("insert into customer_payment_details(suppliername,date,invoiceno,balanceamount,paidamount,voucherno,suppcode) values(?,?,?,?,?,?,?)");
				System.out.println("For");
				

				pstcx99.setString(1, name);
				pstcx99.setString(2,dpb.getD11()[i]);
				pstcx99.setString(3,dpb.getInv1()[i]);
				pstcx99.setString(4,dpb.getTotamt1()[i]);
				pstcx99.setString(5,dpb.getReamt1()[i]);
				pstcx99.setString(6,stringValue);
				pstcx99.setString(7,dealercode);
				pstcx99.executeUpdate();
				
				System.out.println("SQL:"+pstcx99);
				}
				}catch(Exception e){}
			}
			
			
			for(i=0;i<dpb.getInv1().length;i++)
			{
				String amt = "";
				try{
					System.out.println(">>>>>"+dpb.getInvcheck()[i]);
				if( !dpb.getInvcheck()[i].equals("") &&  !dpb.getInvcheck()[i].equals(null)  ){
				//System.out.println("Update");
				PreparedStatement pst=conn.prepareStatement("SELECT * FROM  invoice where invoice_no='"+dpb.getInv1()[i]+"'");

				//System.out.println("1"+pst);
				
				ResultSet rst=pst.executeQuery();
				
				if(rst.next()){
					
					 amt=rst.getString("remaining_amount");
					// System.out.println("Remain Amount:"+amt);
						
				
				String amt1=dpb.getReamt1()[i];
				
				
				//System.out.println("UI Amount:"+amt1);
				
				double amtnew=Double.parseDouble(amt)-Double.parseDouble(amt1);
				
				//System.out.println("New Amount:"+amtnew+"="+amt+"-"+amt1);
				
				String query1="update invoice set remaining_amount='"+amtnew+"' where invoice_no='"+dpb.getInv1()[i]+"'";
				
				
				PreparedStatement pst11=conn.prepareStatement(query1);
				
				//System.out.println("2"+pst11);
				pst11.executeUpdate();
				
			}
				
				}
				}catch(Exception e){}
			}
			
			
			
			// Insert into Bank Ledger
			
			if(dpb.getPaymod().equals("3") || dpb.getPaymod().equals("4"))
			{
				
				
				// Debit
				
				System.out.println("in bankLedger");
				
				PreparedStatement pstcx99 = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)");
				pstcx99.setString(1, stringValue);
				pstcx99.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				pstcx99.setString(3,dpb.getBankname());
				pstcx99.setString(4,"Debit");
				pstcx99.setString(5,dpb.getDealer_payment_amt());
				pstcx99.setString(6,"Bank");
				System.out.println(pstcx99);
				pstcx99.executeUpdate();
				
				
				// Credit
				
				
				PreparedStatement pst = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)");
				pst.setString(1, stringValue);
				pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				pst.setString(3,dpb.getBankname22());
				pst.setString(4,"Credit");
				pst.setString(5,dpb.getDealer_payment_amt());
				pst.setString(6,"Customer");
				pst.setString(7,dealercode);
				System.out.println(pst);
				pst.executeUpdate();
			
			}
			
			
			
			// Insert into Cash Ledger
			
						if(dpb.getPaymod().equals("1"))
						{
							// Credit
							PreparedStatement pst = conn.prepareStatement("insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark,customer_id) values(?,?,?,?,?,?,?)");
							pst.setString(1, stringValue);
							pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
							pst.setString(3,"");
							pst.setString(4,"Credit");
							pst.setString(5,dpb.getDealer_payment_amt());
							pst.setString(6,"Cash");
							pst.setString(7,dealercode);
							System.out.println(pst);
							pst.executeUpdate();
						
						}
			
			}
		
		
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "success";
		//return null;
	}
	
	public static List<Dealer_Payment_Bean> fetchBankLedger(Dealer_Payment_Bean bean) throws Exception {

DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<Dealer_Payment_Bean> list=new ArrayList<Dealer_Payment_Bean>();
		BigDecimal saldo=BigDecimal.ZERO;
		String dcode="";
		String dcode1="";
		String cond="";
		String s="";
//		System.out.println(bean.getFrom_date()+">>>>1"+bean.getTo_date());
		try{
			 s=bean.getBankname();
			 
		
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		System.out.println("<<<>>>>1"+s);


		
		try{
		if(!s.equals("") && !s.equals(null)){
			System.out.println("1");
			cond=" and account_name='"+s+"' ";
			System.out.println("2");
		}else{
			cond="";
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("3");
		}
		BigDecimal finalbalance=BigDecimal.ZERO;
		BigDecimal tempSaldocredit=BigDecimal.ZERO;
		BigDecimal tc=BigDecimal.ZERO;
		BigDecimal td=BigDecimal.ZERO;
		BigDecimal tempcredit=BigDecimal.ZERO;
		BigDecimal tempdebit=BigDecimal.ZERO;
		try{
		PreparedStatement preparedStatement2=con.prepareStatement("SELECT SUM(IF(bank_ledger.cdtype='Debit',bank_ledger.Amount,0.00)) AS Debito, SUM(IF(bank_ledger.cdtype='Credit',bank_ledger.amount,0.00)) AS Credito FROM bank_ledger WHERE  date < ?  and remark='Bank' "+cond+" order by  bank_ledger.date ");
		

		preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
		System.out.println("1"+preparedStatement2);
		ResultSet resultSet2=preparedStatement2.executeQuery();
		if(resultSet2.next()){
			BigDecimal temp1=BigDecimal.ZERO;
			BigDecimal temp2=BigDecimal.ZERO;

			if(resultSet2.getBigDecimal("Debito") !=null){
				temp1=resultSet2.getBigDecimal("Debito");
			}
			if(resultSet2.getBigDecimal("Credito") !=null){
				temp2=resultSet2.getBigDecimal("Credito");
			}
			BigDecimal temp3=temp2.subtract(temp1);
			saldo=saldo.add(temp3);
		}
		System.out.println(">>>>>::"+saldo);
		}catch(Exception e){}
		
		try{
			System.out.println(">>>>1");
		PreparedStatement preparedStatement3=con.prepareStatement("SELECT DATE_FORMAT(bank_ledger.date, '%d/%m/%Y') as Date,remark,doc_no,bank_ledger.cdtype,IF(bank_ledger.cdtype='Debit',bank_ledger.amount,0.00) AS Debito,IF(bank_ledger.cdtype='Credit',bank_ledger.amount,0.00) AS Credito,account_name,amount  FROM bank_ledger WHERE    date BETWEEN ? AND ?  and remark='Bank'   "+cond+"  order by bank_ledger.date " );
		System.out.println(">>>>2");
		preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
		System.out.println(preparedStatement3);
		ResultSet resultSet3=preparedStatement3.executeQuery();
		
		BigDecimal tempSaldo = saldo;
		while(resultSet3.next()){

			Dealer_Payment_Bean bean1=new Dealer_Payment_Bean();

			BigDecimal debit=resultSet3.getBigDecimal("Debito");
			BigDecimal credit=resultSet3.getBigDecimal("Credito");
			BigDecimal temp = debit.subtract(credit);
			tempSaldo = tempSaldo.add(temp);
			System.out.println("<<<<<"+tempSaldo);
			bean1.setTotal_amt(""+tempSaldo);
			//BigDecimal temp=debit.subtract(credit);
			if(resultSet3.getString("cdtype").trim().equalsIgnoreCase("debit")  ){
				tempdebit=tempdebit.add(debit);
			}
			if(resultSet3.getString("cdtype").trim().equalsIgnoreCase("credit")){
				tempcredit=tempcredit.add(credit);

			}
			dcode1=resultSet3.getString("account_name");
			//bean.setDealer_id(resultSet3.getString("Dealercode"));
			
		
		//	bean1.setDelader(resultSet3.getString("Name"));
			bean1.setDc_date(dcode1);
			bean1.setBankname(s);
			bean1.setDealer_id(bean.getBankname());
			bean1.setFrom_date(bean.getFrom_date());
			bean1.setTo_date(bean.getTo_date());
			bean1.setType(resultSet3.getString("cdtype").trim());
			bean1.setInitialbalance(saldo.toString());
			
			bean1.setSale_date(resultSet3.getString("Date"));
			bean1.setRemark(resultSet3.getString("remark"));
			bean1.setDocumentsno(resultSet3.getString("doc_no"));
			bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setFinalbalancedebit(String.valueOf(tempdebit));
			bean1.setFinalbalancecredit(String.valueOf(tempcredit));
			System.out.println("<<<<<,111");
			bean1.setRemark1(resultSet3.getString("remark"));
							
			/*}*/
			
			tc=tc.add(credit);
			td=td.add(debit);
			//bean1.setDealer_id(bean.getDealer_id());
			bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
						
			list.add(bean1);
			

		}
		
		}catch(Exception e){}
		Dealer_Payment_Bean bean2=new Dealer_Payment_Bean();
		bean2.setInitialbalance(saldo.toString());
		bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
		if(!cond.equals("")){
		bean2.setDelader(bean.getDelader());
		}
		
		try{
		bean2.setFrom_date(bean.getFrom_date());
    	bean2.setTo_date(bean.getTo_date());
    	bean2.setBankname(bean.getBankname());
		}catch(Exception e){}
    	
    	
		list.add(bean2);
		return list;

}
	
	
	//CAsh Leadger
	
	public static List<Dealer_Payment_Bean> fetchCashLedger(Dealer_Payment_Bean bean) throws Exception {

		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<Dealer_Payment_Bean> list=new ArrayList<Dealer_Payment_Bean>();
		BigDecimal saldo=BigDecimal.ZERO;
		String dcode="";
		String dcode1="";
		String cond="";
		String s="";
//		System.out.println(bean.getFrom_date()+">>>>1"+bean.getTo_date());
		/*try{
			 s=bean.getBankname();
			 
		
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		
		System.out.println("<<<>>>>1"+s);
*/

		
	/*	try{
		if(!s.equals("") && !s.equals(null)){
			System.out.println("1");
			cond=" and account_name='"+s+"' ";
			System.out.println("2");
		}else{
			cond="";
		}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("3");
		}*/
		BigDecimal finalbalance=BigDecimal.ZERO;
		BigDecimal tempSaldocredit=BigDecimal.ZERO;
		BigDecimal tc=BigDecimal.ZERO;
		BigDecimal td=BigDecimal.ZERO;
		BigDecimal tempcredit=BigDecimal.ZERO;
		BigDecimal tempdebit=BigDecimal.ZERO;
		try{
		PreparedStatement preparedStatement2=con.prepareStatement("SELECT SUM(IF(bank_ledger.cdtype='Debit',bank_ledger.Amount,0.00)) AS Debito, SUM(IF(bank_ledger.cdtype='Credit',bank_ledger.amount,0.00)) AS Credito FROM bank_ledger WHERE  date < ?  and remark='Cash'  order by  bank_ledger.date ");
		

		preparedStatement2.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
		System.out.println("1"+preparedStatement2);
		ResultSet resultSet2=preparedStatement2.executeQuery();
		if(resultSet2.next()){
			BigDecimal temp1=BigDecimal.ZERO;
			BigDecimal temp2=BigDecimal.ZERO;

			if(resultSet2.getBigDecimal("Debito") !=null){
				temp1=resultSet2.getBigDecimal("Debito");
			}
			if(resultSet2.getBigDecimal("Credito") !=null){
				temp2=resultSet2.getBigDecimal("Credito");
			}
			BigDecimal temp3=temp2.subtract(temp1);
			saldo=saldo.add(temp3);
		}
		System.out.println(">>>>>::"+saldo);
		}catch(Exception e){}
		
		try{
			System.out.println(">>>>1");
		PreparedStatement preparedStatement3=con.prepareStatement("SELECT DATE_FORMAT(bank_ledger.date, '%d/%m/%Y') as Date,remark,doc_no,bank_ledger.cdtype,IF(bank_ledger.cdtype='Debit',bank_ledger.amount,0.00) AS Debito,IF(bank_ledger.cdtype='Credit',bank_ledger.amount,0.00) AS Credito,account_name,amount  FROM bank_ledger WHERE    date BETWEEN ? AND ?  and remark='Cash' order by bank_ledger.date " );
		System.out.println(">>>>2");
		preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
		System.out.println(preparedStatement3);
		ResultSet resultSet3=preparedStatement3.executeQuery();
		
		BigDecimal tempSaldo = saldo;
		while(resultSet3.next()){

			Dealer_Payment_Bean bean1=new Dealer_Payment_Bean();

			BigDecimal debit=resultSet3.getBigDecimal("Debito");
			BigDecimal credit=resultSet3.getBigDecimal("Credito");
			BigDecimal temp = debit.subtract(credit);
			tempSaldo = tempSaldo.add(temp);
			System.out.println("<<<<<"+tempSaldo);
			bean1.setTotal_amt(""+tempSaldo);
			//BigDecimal temp=debit.subtract(credit);
			if(resultSet3.getString("cdtype").trim().equalsIgnoreCase("debit")  ){
				tempdebit=tempdebit.add(debit);
			}
			if(resultSet3.getString("cdtype").trim().equalsIgnoreCase("credit")){
				tempcredit=tempcredit.add(credit);

			}
			dcode1=resultSet3.getString("account_name");
			//bean.setDealer_id(resultSet3.getString("Dealercode"));
			
		
		//	bean1.setDelader(resultSet3.getString("Name"));
			bean1.setDc_date(dcode1);
			bean1.setDealer_id(dcode);
			bean1.setFrom_date(bean.getFrom_date());
			bean1.setTo_date(bean.getTo_date());
			bean1.setType(resultSet3.getString("cdtype").trim());
			bean1.setInitialbalance(saldo.toString());
			
			bean1.setSale_date(resultSet3.getString("Date"));
			bean1.setRemark(resultSet3.getString("remark"));
			bean1.setDocumentsno(resultSet3.getString("doc_no"));
			bean1.setDebit(String.valueOf(debit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setCredit(String.valueOf(credit.setScale(2, BigDecimal.ROUND_UP)));
			bean1.setFinalbalancedebit(String.valueOf(tempdebit));
			bean1.setFinalbalancecredit(String.valueOf(tempcredit));
			System.out.println("<<<<<,111");
			bean1.setRemark1(resultSet3.getString("remark"));
							
			/*}*/
			
			tc=tc.add(credit);
			td=td.add(debit);
			//bean1.setDealer_id(bean.getDealer_id());
			bean1.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
						
			list.add(bean1);
			

		}
		
		}catch(Exception e){}
		Dealer_Payment_Bean bean2=new Dealer_Payment_Bean();
		bean2.setInitialbalance(saldo.toString());
		bean2.setFinalbalance(String.valueOf(saldo.add(tempcredit.subtract(tempdebit))));
		if(!cond.equals("")){
		bean2.setDelader(bean.getDelader());
		}
		
		try{
		bean2.setFrom_date(bean.getFrom_date());
    	bean2.setTo_date(bean.getTo_date());
		}catch(Exception e){}
    	
    	
		list.add(bean2);
		return list;

}
	
	
	//Customer Credit Debit Note Report
	
	public static List<Dealer_Payment_Bean> fetchCreditDebitNoteCust(Dealer_Payment_Bean bean) throws Exception {

		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<Dealer_Payment_Bean> list=new ArrayList<Dealer_Payment_Bean>();
			
		String cond="";
		try{
			if (!bean.getBankname().equals("") && !bean.getBankname().equals(null)) {
				String s="";
				try{
					 s=bean.getBankname();
					 	
					s = s.substring(s.indexOf("(") + 1);
					s = s.substring(0, s.indexOf(")"));
					
					 			
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
		
				cond = " and customer_id='" + s + "' ";
			}
			}catch(Exception e){
				
			}
		
		
		
		try{
			System.out.println(">>>>1");
		PreparedStatement preparedStatement3=con.prepareStatement("SELECT *  FROM custcreditdebitnote WHERE    date BETWEEN ? AND ? "+ cond +" order by custcreditdebitnote.date " );
		System.out.println(">>>>2");
		preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
		System.out.println(preparedStatement3);
		ResultSet resultSet3=preparedStatement3.executeQuery();
		
		while(resultSet3.next()){

			Dealer_Payment_Bean bean1=new Dealer_Payment_Bean();


			
			bean1.setSale_date(CoreData.getDateFormatAsUser(resultSet3.getString("date")));
			bean1.setRemark(resultSet3.getString("nariation"));
			bean1.setDocumentsno(resultSet3.getString("doc_no"));
			bean1.setType(resultSet3.getString("cdtype"));
			bean1.setAmount(resultSet3.getString("amount"));
			bean1.setCust_id(resultSet3.getString("customer_id"));
			bean1.setCust_name(resultSet3.getString("customer_name"));
			bean1.setRefno(resultSet3.getString("refno"));
			
			list.add(bean1);
			

		}
		
		}catch(Exception e){}
		
		return list;

}
	
	
	//Supplier Credit Debit Note Report
	
		public static List<Dealer_Payment_Bean> fetchCreditDebitNoteSup(Dealer_Payment_Bean bean) throws Exception {

			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			List<Dealer_Payment_Bean> list=new ArrayList<Dealer_Payment_Bean>();
				
			
			try{
				
				String cond="";
				try{
					if (!bean.getBankname().equals("") && !bean.getBankname().equals(null)) {
						String s="";
						try{
							 s=bean.getBankname();
							 	
							s = s.substring(s.indexOf("(") + 1);
							s = s.substring(0, s.indexOf(")"));
							
							 			
						}catch (Exception e) {
							// TODO: handle exception
							s="";
						}
				
						cond = " and customer_id='" + s + "' ";
					}
					}catch(Exception e){
						
					}
				
				
				System.out.println(">>>>1");
			PreparedStatement preparedStatement3=con.prepareStatement("SELECT *  FROM suppliercreditdebitnote WHERE    date BETWEEN ? AND ? "+ cond +" order by suppliercreditdebitnote.date " );
			System.out.println(">>>>2");
			preparedStatement3.setString(1, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getFrom_date().replace("/", "-")+" 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(bean.getTo_date().replace("/", "-")+" 00:00:00"));
			System.out.println(preparedStatement3);
			ResultSet resultSet3=preparedStatement3.executeQuery();
			
			while(resultSet3.next()){

				Dealer_Payment_Bean bean1=new Dealer_Payment_Bean();


				
				bean1.setSale_date(CoreData.getDateFormatAsUser(resultSet3.getString("date")));
				bean1.setRemark(resultSet3.getString("nariation"));
				bean1.setDocumentsno(resultSet3.getString("doc_no"));
				bean1.setType(resultSet3.getString("cdtype"));
				bean1.setAmount(resultSet3.getString("amount"));
				bean1.setCust_id(resultSet3.getString("customer_id"));
				bean1.setCust_name(resultSet3.getString("customer_name"));
				bean1.setRefno(resultSet3.getString("refno"));
				
				list.add(bean1);
				

			}
			
			}catch(Exception e){}
			
			return list;

	}
	
	
	public static List<Dealer_Payment_Bean> fetchChequeLinkSup(Dealer_Payment_Bean dpb) throws IOException,
	SQLException {

		List<Dealer_Payment_Bean> list2 = new ArrayList<Dealer_Payment_Bean>();
		
		try {
			
			String cond = "",cond1="";
			try{
			if (!dpb.getChequeno().equals("") && !dpb.getChequeno().equals(null)) {
				String s="";
				try{
					 s=dpb.getChequeno();
						
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
		
				cond1 =  " and check_no='" + s + "' ";
			}
			}catch(Exception e){
				
			}
			
			
			try{
				String parts[]=dpb.getDealer_id().split("~");
				
				String s=parts[1];
				
				
			
					cond1 = " and lrform_paymentv.supplierid='" + s + "' ";
				
				}catch(Exception e){
					
				}
			
			
			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			PreparedStatement pst2 = con
					.prepareStatement("select *,supplier_payment_details.invoiceno as inv from lrform_paymentv,supplier_payment_details where lrform_paymentv.Invoiceno=supplier_payment_details.voucherno and lrform_paymentv.date BETWEEN ? and ? and pay_mode='3' "+ cond +""+ cond1 +"");
			
			pst2.setString(1, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dpb.getFrom_date()
							.replace("/", "-") + " 00:00:00"));
			pst2.setString(2, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dpb.getTo_date()
							.replace("/", "-") + " 00:00:00"));
			
			System.out.println("SQL:"+pst2);

			ResultSet rs = pst2.executeQuery();
			while (rs.next()) {
				
				Dealer_Payment_Bean dpb1 = new Dealer_Payment_Bean();

				dpb1.setVoucher_no(rs.getString("voucherno"));
				dpb1.setDate1(rs.getString("date"));
				dpb1.setBankname(rs.getString("suppliername"));
				dpb1.setIcr_no(rs.getString("check_no"));
				dpb1.setAmount(rs.getString("paidamount"));
				dpb1.setRemark(rs.getString("inv"));
				
				list2.add(dpb1);
			}

		} catch (Exception ex) {
			System.out.println("error" + ex.getMessage());
		}
		return list2;

}

	public static List<Dealer_Payment_Bean> fetchChequeLinkCust(
			Dealer_Payment_Bean dpb) {
		// TODO Auto-generated method stub
List<Dealer_Payment_Bean> list2 = new ArrayList<Dealer_Payment_Bean>();
		
		try {
			
			String cond = "",cond1="";
			try{
			if (!dpb.getChequeno().equals("") && !dpb.getChequeno().equals(null)) {
				String s="";
				try{
					 s=dpb.getChequeno();
						
				}catch (Exception e) {
					// TODO: handle exception
					s="";
				}
		
				cond1 =  " and check_no='" + s + "' ";
			}
			}catch(Exception e){
				
			}
			
			
			try{
				String parts[]=dpb.getDealer_id().split("~");
				
				String s=parts[1];
				
				
			
					cond1 = " and suppcode='" + s + "' ";
				
				}catch(Exception e){
					
				}
			
			
			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			PreparedStatement pst2 = con
					.prepareStatement("select *,customer_payment_details.invoiceno as inv from customerpayment,customer_payment_details where customerpayment.Invoiceno=customer_payment_details.voucherno and customerpayment.date BETWEEN ? and ? and pay_mode='3' "+ cond +""+ cond1 +" group by voucherno ");
			
			pst2.setString(1, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dpb.getFrom_date()
							.replace("/", "-") + " 00:00:00"));
			pst2.setString(2, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dpb.getTo_date()
							.replace("/", "-") + " 00:00:00"));
			
			System.out.println("SQL:"+pst2);

			ResultSet rs = pst2.executeQuery();
			while (rs.next()) {
				
				Dealer_Payment_Bean dpb1 = new Dealer_Payment_Bean();

				dpb1.setVoucher_no(rs.getString("voucherno"));
				dpb1.setDate1(rs.getString("date"));
				dpb1.setBankname(rs.getString("suppliername"));
				dpb1.setIcr_no(rs.getString("check_no"));
				dpb1.setAmount(rs.getString("paidamount"));
				dpb1.setRemark(rs.getString("invoiceno"));
				
				list2.add(dpb1);
			}

		} catch (Exception ex) {
			System.out.println("error" + ex.getMessage());
		}
		return list2;
	}
	
	
	
	public List<expenses_Bean> Print44(String voucher_no) throws SQLException {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<expenses_Bean> report = new ArrayList<expenses_Bean>();
		
		String	stringValue1="";
		String a = "select * from expenses where voucher_no=? ";
		//System.out.println(">>>>1");
		
		PreparedStatement pst1 = con.prepareStatement(a);
	
		pst1.setString(1, voucher_no);
	
		System.out.println(pst1);
		ResultSet rs = pst1.executeQuery();
		BigDecimal totalamount = BigDecimal.ZERO;
		int v=0;
		while (rs.next()) {

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			expenses_Bean bean1 = new expenses_Bean();
			bean1.setVoucher_no(rs.getString(2));
			bean1.setExppart(rs.getString("exppart"));
			bean1.setPaid_amt(rs.getString("amount"));
		
			
			bean1.setTotal_amt("" + totalamount);
			bean1.setDealer_code(rs.getString("stcode") );
			bean1.setRemark(rs.getString(6));
			try {
				String date1 = rs.getString(4);
				bean1.setPayment_date(CoreData.getDateFormatAsUser(date1));
			} catch (Exception e) {
				// TODO: handle exception
				bean1.setPayment_date("");
			}

			
			
			String aa = "select * from emp_master where emp_id='"+rs.getString("stcode")+"' ";
				
			PreparedStatement pst11 = con.prepareStatement(aa);
		
			System.out.println(pst11);
			ResultSet rsa = pst11.executeQuery();
			if (rsa.next()) {

				
				bean1.setTocounter(rsa.getString("emp_name"));
				bean1.setChkno3(rsa.getString("mobile_no") );
				

			}
			v++;
			
			bean1.setSno(v);
			report.add(bean1);

			
		}

	
	return report;
}
	
	
	
	
	
	public List<expenses_Bean> ChequePrint(String voucher_no) throws SQLException {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<expenses_Bean> report = new ArrayList<expenses_Bean>();
		
		String	stringValue1="";
		String a = "select * from expenses where voucher_no=? ";
		//System.out.println(">>>>1");
		
		PreparedStatement pst1 = con.prepareStatement(a);
	
		pst1.setString(1, voucher_no);
	
		System.out.println(pst1);
		ResultSet rs = pst1.executeQuery();
		while (rs.next()) {

			
			expenses_Bean bean1 = new expenses_Bean();
			bean1.setVoucher_no(rs.getString(2));
			
			bean1.setAmount(rs.getString("amount"));
		
			bean1.setDate(rs.getString("chequedate"));
			bean1.setBankname(rs.getString("chequebank"));
			bean1.setCheque_no(rs.getString("chequeno"));
			

			
			
			String aa = "select * from emp_master where emp_id='"+rs.getString("stcode")+"' ";
				
			PreparedStatement pst11 = con.prepareStatement(aa);
		
			System.out.println(pst11);
			ResultSet rsa = pst11.executeQuery();
			if (rsa.next()) {

				
				bean1.setName(rsa.getString("emp_name"));
				

			}
				report.add(bean1);

			
		}

	
	return report;
}
	
	
	
	
	public String insertcustcreditdebitnote(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";
		try
		{
			String s="";

			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
			
			
			String stringValue="";
			int len=0;


			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  custcreditdebitnote");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	


			int size=len+1;
			stringValue=String.valueOf(size);

			if(stringValue.length()==1)
			{
				stringValue="CUST/CREDEB/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="CUST/CREDEB/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="CUST/CREDEB/0"+stringValue;
			}
			else
			{
				stringValue="CUST/CREDEB/"+stringValue;
			}


			dpb.setVoucher_no(stringValue);

			
			
			try{
				 s=dpb.getDealer_code();
			s = s.substring(s.indexOf("(") + 1);
			s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}

			
			String name = null;
			try {
				String aa = "select * from customer_master where cust_id='"+s+"' ";
					
				PreparedStatement pst11 = conn.prepareStatement(aa);
				name = "";
				System.out.println(pst11);
				ResultSet rsa = pst11.executeQuery();
				if (rsa.next()) {

					
					name=rsa.getString("cust_name");
					

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int q=0;	
			String a4="insert into custcreditdebitnote(doc_no,date,nariation,cdtype,amount,refno,customer_id,customer_name) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst4=conn.prepareStatement(a4);  
			pst4.setString(1, stringValue);
			
			pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			pst4.setString(3, dpb.getRemark());
			pst4.setString(4, dpb.getType());
			
			pst4.setString(5,dpb.getDealer_payment_amt());	
			pst4.setString(6, dpb.getRefno());
			pst4.setString(7,s);
			pst4.setString(8,name);
			
			
			q=pst4.executeUpdate();


			
			if(dpb.getType().equals("Debit"))
			{
				PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
						+ "VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Debit Note','101','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
				System.out.println(pst31);
				int i=pst31.executeUpdate();
			}
			
			else{
				
				PreparedStatement pst31=conn.prepareStatement("Insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
						+ "VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Credit Note','201','Credit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
				System.out.println(pst31);
				int i=pst31.executeUpdate();
				
			}
			
			
			

			response="success";


		}
		catch(Exception e)
		{

			response="fail";
		}
		return response;

		//return null;
	}
	
	
	
	
	public String insertsupcreditdebitnote(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";
		try
		{
			String s="";

			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
			
			
			String stringValue="";
			int len=0;


			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  suppliercreditdebitnote");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	


			int size=len+1;
			stringValue=String.valueOf(size);

			if(stringValue.length()==1)
			{
				stringValue="SUP/CREDEB/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="SUP/CREDEB/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="SUP/CREDEB/0"+stringValue;
			}
			else
			{
				stringValue="SUP/CREDEB/"+stringValue;
			}


			dpb.setVoucher_no(stringValue);

			
			
			try{
				 s=dpb.getDealer_code();
			s = s.substring(s.indexOf("(") + 1);
			s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}

			
			String name = null;
			try {
				String aa = "select * from company_master where company_id='"+s+"' ";
					
				PreparedStatement pst11 = conn.prepareStatement(aa);
				name = "";
				System.out.println(pst11);
				ResultSet rsa = pst11.executeQuery();
				if (rsa.next()) {

					
					name=rsa.getString("company_name");
					

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int q=0;	
			String a4="insert into suppliercreditdebitnote(doc_no,date,nariation,cdtype,amount,refno,customer_id,customer_name) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst4=conn.prepareStatement(a4);  
			pst4.setString(1, stringValue);
			
			pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			pst4.setString(3, dpb.getRemark());
			pst4.setString(4, dpb.getType());
			
			pst4.setString(5,dpb.getDealer_payment_amt());	
			pst4.setString(6, dpb.getRefno());
			pst4.setString(7,s);
			pst4.setString(8,name);
			
			
			q=pst4.executeUpdate();


			
			if(dpb.getType().equals("Debit"))
			{
				PreparedStatement pst31=conn.prepareStatement("Insert into creditdebitreportv(Dealercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
						+ "VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Debit Note','101','Debit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
				System.out.println(pst31);
				int i=pst31.executeUpdate();
			}
			
			else{
				
				PreparedStatement pst31=conn.prepareStatement("Insert into creditdebitreportv(Dealercode,Date,Documentsno,Remark,Typecode,type,Amount,Name) "
						+ "VALUES ('"+s+"','"+CoreData.getDateFormatAsDb(dpb.getPayment_date())+"','"+stringValue+"','Credit Note','201','Credit','"+dpb.getDealer_payment_amt()+"','"+name+"')");
				System.out.println(pst31);
				int i=pst31.executeUpdate();
				
			}
			
			
			

			response="success";


		}
		catch(Exception e)
		{

			response="fail";
		}
		return response;

		//return null;
	}
	
	
	
	
	//Method to Insert Deposit Withraw and Bank Transfer
	
	public String InsertDepositWithraw(Dealer_Payment_Bean dpb, LoginBean bean) {
		// TODO Auto-generated method stub
		String response="";
		try
		{
			String s="";

			DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();
			
			
			String stringValue="DEP/WIT/BT/0001";
			int len=0;


			PreparedStatement preparedStatement1=conn.prepareStatement("SELECT * FROM  DepositWithraw");

			ResultSet resultSet1=preparedStatement1.executeQuery();
			while(resultSet1.next()){
				len++;
			}	


			int size=len+1;
			stringValue=String.valueOf(size);

			if(stringValue.length()==1)
			{
				stringValue="DEP/WIT/BT/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="DEP/WIT/BT/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="DEP/WIT/BT/0"+stringValue;
			}
			else
			{
				stringValue="DEP/WIT/BT/"+stringValue;
			}


			dpb.setVoucher_no(stringValue);

			
		
			
			String s4="insert into DepositWithraw(doc_no,date,type,amount,remark,paymode,bankname,chequeno,chequedate,chequeamount,transactionid,netamount,destbankname,chequebank) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(s4);  
			
			pst.setString(1, stringValue);
			
			try{
				pst.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
				}catch (Exception e) {
					// TODO: handle exception
					pst.setString(2,null);
				}
			
			
			if(dpb.getType().equals("1"))
				
			{
				pst.setString(3,"Deposit");
				
			}	
			
			if(dpb.getType().equals("2"))		
			{
				
				pst.setString(3,"Withdraw");
			}
			if(dpb.getType().equals("3"))		
			{
				
				pst.setString(3,"Bank Transfer");
			}
			
			pst.setString(4,dpb.getDealer_payment_amt());
			pst.setString(5, dpb.getRemark());
			pst.setString(6, dpb.getPaymod());
			pst.setString(7, dpb.getBankname1());
			pst.setString(8, dpb.getCheque_no());
			pst.setString(9,CoreData.getDateFormatAsDb(dpb.getCheque_date()));
			pst.setString(10, dpb.getCheque_amt());	
			pst.setString(11,dpb.getTranscation_id());	
			pst.setString(12,dpb.getNet_amount());	
			pst.setString(13,dpb.getBankname22());
			
			pst.setString(14,dpb.getBankname());
			
			int q12=pst.executeUpdate();


			
			
			//Bank Leadger Entry
			
			if(dpb.getType().equals("1"))
			{
					
			
			String a44="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)";
			PreparedStatement pst44=conn.prepareStatement(a44);  
			pst44.setString(1, stringValue);
			try{
			pst44.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst44.setString(2,null);
			}

			pst44.setString(3, dpb.getBankname1());
			pst44.setString(4, "Credit");
			
			pst44.setString(5,dpb.getDealer_payment_amt());
			pst44.setString(6, dpb.getRemark());
				
			System.out.println("Sql:"+pst44);
			
			int q=pst44.executeUpdate();

			
			}
			
			
			if(dpb.getType().equals("2"))
			{
					
			System.out.println("1");	
			String a44="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)";
			PreparedStatement pst44=conn.prepareStatement(a44);  
			pst44.setString(1, stringValue);
			try{
			pst44.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst44.setString(2,null);
			}

			pst44.setString(3, dpb.getBankname1());
			pst44.setString(4, "Debit");
			
			pst44.setString(5,dpb.getDealer_payment_amt());
			pst44.setString(6, dpb.getRemark());
				
			System.out.println("Sql:"+pst44);
			
			int q=pst44.executeUpdate();

			
			}
			
			
			if(dpb.getType().equals("3"))
			{
					
			String a44="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)";
			PreparedStatement pst44=conn.prepareStatement(a44);  
			pst44.setString(1, stringValue);
			try{
			pst44.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst44.setString(2,null);
			}

			pst44.setString(3, dpb.getBankname1());
			pst44.setString(4, "Debit");
			
			pst44.setString(5,dpb.getDealer_payment_amt());
			pst44.setString(6, dpb.getRemark());
				
			System.out.println("Sql:"+pst44);
			
			int q=pst44.executeUpdate();
			
			
			
			String a4="insert into bank_ledger(doc_no,date,account_name,cdtype,amount,remark) values(?,?,?,?,?,?)";
			PreparedStatement pst4=conn.prepareStatement(a4);  
			pst4.setString(1, stringValue);
			try{
			pst4.setString(2,CoreData.getDateFormatAsDb(dpb.getPayment_date()));
			}catch (Exception e) {
				// TODO: handle exception
				pst4.setString(2,null);
			}

			pst4.setString(3, dpb.getBankname22());
			pst4.setString(4, "Credit");
			
			pst4.setString(5,dpb.getDealer_payment_amt());
			pst4.setString(6, dpb.getRemark());
				
			System.out.println("Sql:"+pst4);
			
			int q1=pst4.executeUpdate();
			

			
			}
			
			
			
			response="success";


		}
		catch(Exception e)
		{

			response="fail";
		}
		return response;

		//return null;
	}

	
	

}