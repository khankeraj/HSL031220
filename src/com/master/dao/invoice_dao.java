package com.master.dao;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import com.DB.DBConnection;
import com.master.model.Area_Master_Bean;
import com.master.model.invoicebean;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;
//import com.master.ValuesToBean.jobcardvaluestobean;

//import com.aqua.model.RoleBean;

public class invoice_dao {

	public String insertCustomerInfo(invoicebean ib,String lead_no) throws SQLException,
	ParseException {

		String response="";

		DBConnection connection=new DBConnection();Connection con = connection.getConnection();
		int flag1 = 0;

		PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
//System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet resultSet12z = preparedStatement112z.executeQuery();

		if (resultSet12z.next()) {

			if(resultSet12z.getString("po").equals("yes")){	

				for(int mx=0;mx<ib.getDescription1().length;mx++)
				{
						if(ib.getDescription1()[mx] != "" ){		
		
							Double qtyremaining=0.0;
							PreparedStatement preparedStatementx=con.prepareStatement("select * from purchase_order_details where descrip=? and pono='"+ib.getPono()+"'   ");	
							preparedStatementx.setString(1, ib.getDescription1()[mx]);
							System.out.println("SQL:"+preparedStatementx);
							ResultSet resultSetx=preparedStatementx.executeQuery();
							if(resultSetx.next())
							{
								Double qtyentered=Double.parseDouble(ib.getQuantity1()[mx]);
								
								try{
								 qtyremaining =Double.parseDouble(resultSetx.getString("qtyremaining"));
								} catch (Exception e) {
									qtyremaining=0.0;
								}
								System.out.println(qtyremaining+">>>>"+qtyentered);
			
		if(qtyremaining<qtyentered){
			System.out.println("AAA");
			response="Notsuffqty";
			System.out.println("AAA12");
			flag1=1;
			System.out.println("AAA23");
			break;
		}
		}else{
			flag1=1;
		}
		
		
		
		

	}

}
System.out.println("Flag Value:"+flag1);
}


}


if(flag1==0)
{
System.out.println("iinFlag Value:"+flag1);
int m = 0;
int j3 = 0;
int n = 0;
int invid = 0;
int k = 0;
int j = 0;

int v = 0;
Integer x = 0;
Integer Y = 0;
String amcId1 = null;


// fiscal year
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
    




        String pref = "GST/";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		// String pref="INV";
		PreparedStatement preparedStatement11 = con
				.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
		preparedStatement11.setString(1, "" + "%" + pref+Fyear + "%");

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
			stringValue1 = pref+ Fyear + "/0000" + stringValue1;

		} else {

			if (String.valueOf(myval1).length() == 1) {
				stringValue1 = pref+  Fyear + "/0000" + String.valueOf(myval1);

			} else if (String.valueOf(myval1).length() == 2) {
				stringValue1 =pref+  Fyear + "/000" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 3) {
				stringValue1 = pref+  Fyear + "/00" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 4) { 
				stringValue1 = pref+  Fyear + "/0" + String.valueOf(myval1);
			}
			else {
				stringValue1 = pref+  Fyear + "/" + String.valueOf(myval1);
			}
		}

ib.setInvoiceno(stringValue1);
String query = "";
PreparedStatement preparedStatement = con
		.prepareStatement("select * from invoice where  invoice_no=?");
String inv = ib.getInvno();
String inv1 = " " + inv;
System.out.println(preparedStatement);
preparedStatement.setString(1, inv1.trim());

ResultSet resultSet = preparedStatement.executeQuery();
if (resultSet.next()) {
	response = "Already";
	
	PreparedStatement pst1 = con.prepareStatement(
			"select * from customer_payment_details where invoiceno='"+inv1.trim()+"'");
	System.out.println("pst........." + pst1);
	ResultSet rs1 = pst1.executeQuery();
	if (rs1.next()) {
		
		
	}else{
	

	
	
	if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {	
		
		
		query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

		inv1=ib.getInvno();
		ib.setInvoiceno(inv1);
		Date d1 = new Date();
		String da = "" + d1;
		
		
		pst9 = con.prepareStatement(query);
		pst9.setString(1, ib.getCustomer_Id());
		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setString(3, ib.getJob_Card_no());
		pst9.setString(25, inv1);
		pst9.setString(4, ib.getTamount());
		pst9.setString(5, ib.getPono());
		pst9.setString(6, ib.getPodate());
		pst9.setString(7, ib.getTermcond());
		pst9.setString(8, ib.getVendor());
		pst9.setString(9, ib.getDcnox());
		pst9.setString(10, ib.getDcdatex());
		
		pst9.setString(11, ib.getTransmode());
		pst9.setString(12, ib.getContactp());
		pst9.setString(13, ib.getContactpno());
		pst9.setString(14, ib.getShipparty());
		pst9.setString(15, ib.getShipadd());
		pst9.setString(16, ib.getShipgstn());
		pst9.setString(17, ib.getShipstate());
		pst9.setString(18, ib.getVehino());
		pst9.setString(19, ib.getFreight());
		pst9.setString(20, ib.getTransport());
		pst9.setString(21, ib.getA2()[0]);
		pst9.setString(22, ib.getA2()[1]);
		pst9.setString(23, ib.getA2()[2]);
		pst9.setString(24, ib.getTamount());
		k = pst9.executeUpdate();
		
	}
	else{

	query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

	inv1=ib.getInvno();
	ib.setInvoiceno(inv1);
	Date d1 = new Date();
	String da = "" + d1;
	
	
	pst9 = con.prepareStatement(query);
	pst9.setString(1, ib.getCustomer_Id());
	pst9.setString(32, inv1);
	pst9.setString(18, ib.getPono());
	pst9.setString(19, ib.getPodate());
	pst9.setString(20, ib.getTermcond());
	 pst9.setString(38, inv1);
	pst9.setString(21, ib.getVendor());
	pst9.setString(34, inv);
	pst9.setString(22, ib.getDcnox());
	pst9.setString(23, ib.getDcdatex());
	pst9.setString(24, ib.getTransmode());
	pst9.setString(25, ib.getContactp());
	pst9.setString(26, ib.getContactpno());
	pst9.setString(27, ib.getShipparty());
	pst9.setString(28, ib.getShipadd());
	pst9.setString(29, ib.getShipgstn());
	pst9.setString(30, ib.getShipstate());
	pst9.setString(31, ib.getVehino());
	pst9.setString(32, ib.getFreight());
	pst9.setString(33, ib.getTransport());
	pst9.setString(34, ib.getA2()[0]);
	pst9.setString(35, ib.getA2()[1]);
	pst9.setString(36, ib.getA2()[2]);
	pst9.setString(37, ib.getTamount());
	String paid_amt = "";
	String balance_amt = "";
	paid_amt = ib.getPaid_amt();
	balance_amt = ib.getBalance_amt();

	
	
	// CASH
	if (ib.getPaymod().trim().equals("CASH")) {
		pst9.setString(3, "CASH");
	
		String paid_amt1 = "";

		paid_amt1 = ib.getNet_amount();


		pst9.setString(4, paid_amt1);
		pst9.setString(5, "0");
		
		pst9.setString(7, "");
		
		pst9.setString(8, "0");
	
		pst9.setString(9, "");
	
		
		
		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setNull(6, java.sql.Types.DATE);
		pst9.setString(11, paid_amt1);
		
		pst9.setString(12, "0");
		pst9.setString(13, "0");
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, "");
		pst9.setString(17, "");
		
			
		k = pst9.executeUpdate();

	}

	else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

		pst9.setString(3, "CHEQUE");
		Integer l = 0;
		String paid_amt2 = "";
		String chek_amt = "";

		//paid_amt2 = ib.getCash_amt();

		chek_amt = ib.getCheque_amt();
		Integer c = 0;
		try {
			l = Integer.valueOf(chek_amt);
		} catch (Exception e) {
			
			l = 0;
		}
		pst9.setString(4, chek_amt);
		pst9.setString(5, "0");

		pst9.setString(7, ib.getCheque_no());
		pst9.setString(8, "0");
		pst9.setString(9, "");

		
		
		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
	
		pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

		pst9.setInt(11, 0);
		try {
			c = Integer.valueOf(chek_amt);
		} catch (Exception e) {
			
			c = 0;
		}
		pst9.setString(12, chek_amt);
		pst9.setString(13, "0");
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, ib.getBankname());
		pst9.setString(17, "");
		

		k = pst9.executeUpdate();

	}

	// credit

	else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {

		pst9.setString(3, "CARD");

		String paid_amt2 = "";
		String chek_amt = "";

		paid_amt2 = ib.getNet_amountcard();

		chek_amt = ib.getNet_amountcard();
		Integer c = 0;
		Integer a = 0;
		try {
			a = Integer.valueOf(paid_amt2);
		} catch (Exception e) {
			
			a = 0;
		}
		pst9.setString(4, paid_amt2);
		pst9.setString(5, "0");

		pst9.setString(7, "");
		pst9.setString(8, ib.getCardid());
		pst9.setString(9, "");

		DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		/*
		 * String dateInString=ib.getCheque_date(); Date dNo = new
		 * Date(); dNo = ft.parse(dateInString);
		 */
		Date dNow = new Date();

		
		pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
	
		pst9.setNull(6, java.sql.Types.DATE);

		pst9.setString(11, "0");
		try {
			c = Integer.valueOf(chek_amt);
		} catch (Exception e) {
			
			c = 0;
		}
		pst9.setString(12, "0");
		pst9.setString(13, paid_amt2);
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, "");
		pst9.setString(17, "");
	
		k = pst9.executeUpdate();

	}

	// Insurance
	else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {

		pst9.setString(3, "INSURANCE");

		String paid_amt2 = "";
		String balace = "";
		String chek_amt = "";

		paid_amt2 = ib.getPaid_amt22();

		// chek_amt=ib.getNet_amountcard();
		balace = ib.getBalance_amt22();
		Integer c = 0;
		Integer a = 0;
		try {
			a = Integer.valueOf(paid_amt2);
		} catch (Exception e) {
			
			a = 0;
		}
		pst9.setString(4, paid_amt2);
		try {
			c = Integer.valueOf(balace);
		} catch (Exception e) {
			
			c = 0;
		}
		pst9.setString(5, balace);

		pst9.setString(7, "");
		pst9.setString(8, "0");
		pst9.setString(9, ib.getInsurance());

		DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
		/*
		 * String dateInString=ib.getCheque_date(); Date dNo = new
		 * Date(); dNo = ft.parse(dateInString);
		 */
		



		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		
		pst9.setNull(6, java.sql.Types.DATE);

		pst9.setString(11, paid_amt2);

		pst9.setString(12, "0");
		pst9.setString(13, "0");
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		String d="";
		try{
			d=CoreData.getDateFormatAsDb(ib.getDate22());
			
		}catch (Exception e) {
			
		}
		
		pst9.setString(16, d);
		
		pst9.setString(17, "");
		
		k = pst9.executeUpdate();

	}

	else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
		String paymode="";
		String paid_amt2 = "";
		String balace = "";
		String chek_amt = "";

		paid_amt2 = ib.getPaid_amt();

		if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
		{
			paymode=ib.getR1()+"~"+"CASH";
			pst9.setString(11, paid_amt2);
			pst9.setString(12, "0");
			pst9.setString(13, "0");
		
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
		{
			
			paymode=ib.getR1()+"~"+"CHEQUE";
			pst9.setString(12, paid_amt2);
			pst9.setString(11, "0");
			pst9.setString(13, "0");
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
		{
			paymode=ib.getR1()+"~"+"CARD";
pst9.setString(11,"0");
			
			pst9.setString(12, "0");
			pst9.setString(13, paid_amt2);
			
		}
		else
		{
			paymode=ib.getPaymod();
				pst9.setString(11,"0");
			
			pst9.setString(12, "0");
			pst9.setString(13,"0");
		}
		
		

		pst9.setString(3, paymode);

		
		// chek_amt=ib.getNet_amountcard();
		balace = ib.getBalance_amt();
		Integer c = 0;
		Integer a = 0;
		try {
			a = Integer.valueOf(paid_amt2);
		} catch (Exception e) {
			
			a = 0;
		}
		pst9.setString(4, paid_amt2);
		try {
			c = Integer.valueOf(balace);
		} catch (Exception e) {
			
			c = 0;
		}
		pst9.setString(5, balace);

		pst9.setString(7, "");
		pst9.setString(8, "0");
		pst9.setString(9, "");

		

		pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
		
		pst9.setNull(6, java.sql.Types.DATE);

		/*pst9.setString(11, "0");

		pst9.setString(12, "0");
		pst9.setString(13, "0");*/
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, "");
		
		pst9.setString(17, "");
		
		
		k = pst9.executeUpdate();

	}

	// card and cash

	else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {

		pst9.setString(3, "CARDANDCASH");

		String paid_amt2 = "";
		String balace = "";
		String credit = "";

		paid_amt2 = ib.getCashhh();

		
		// chek_amt=ib.getNet_amountcard();
		credit = ib.getCarddd();
		Integer c = 0;
		Integer a = 0;
		Integer p = 0;
		try {
			a = Integer.valueOf(paid_amt2);
		} catch (Exception e) {
			
			a = 0;
		}

		try {
			c = Integer.valueOf(credit);
		} catch (Exception e) {
			
			c = 0;
		}

		p = (a + c);

		pst9.setString(4,""+p);
		/*
		 * try{ c = Integer.valueOf(balace); }catch (Exception e) { //
		 * TODO: handle exception c=0; }
		 */
		pst9.setString(5, ""+0);

		pst9.setString(7, "");
		pst9.setString(8, ""+ib.getTrandi());
		pst9.setString(9, "");

		

		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		
		pst9.setNull(6, java.sql.Types.DATE);

		pst9.setString(11, ""+a);

		pst9.setString(12, ""+0);
		pst9.setString(13, ""+c);
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, "");
		
		pst9.setString(17, "");
	
		k = pst9.executeUpdate();

	}else{
		
		
	
		pst9.setString(3, "");
		
		String paid_amt1 = "";

		paid_amt1 = ib.getNet_amount();


		pst9.setString(4, "0");
		pst9.setString(5, "0");
		
		pst9.setString(7, "");
		
		pst9.setString(8, "0");
	
		pst9.setString(9, "");
	
	
		pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setNull(6, java.sql.Types.DATE);
		pst9.setString(11, "0");
		
		pst9.setString(12, "0");
		pst9.setString(13, "0");
		pst9.setString(14, ib.getTamount());
		pst9.setString(15, ib.getJob_Card_no());
		pst9.setString(16, "");
		
		pst9.setString(17, "");
	
		
		k = pst9.executeUpdate();

		
		
	}
	
	
}
	
	
	
	
	
/*
	PreparedStatement preparedStatement1121 = con
			.prepareStatement("update  job_card set job_card_done_status='"
					+ 1 + "' where job_card_no=? ");

	preparedStatement1121.setString(1, ib.getJob_Card_no());

	j = preparedStatement1121.executeUpdate();

		response = "success";
	*/

	// update tax_datails
	response = "success";
	
	
	
	
	
	
	
	String qd = "delete  from invoice_tax_details where invoice_no=?";
	String inv2 = ib.getInvno();
	 String inv21 = " " + inv2;
	PreparedStatement pstdel = con.prepareStatement(qd);
	pstdel.setString(1, inv21.trim());

	int n1 = pstdel.executeUpdate();

	int i = 0;
	int l1 = 0;
	String q1 = "insert into invoice_tax_details(invoice_no, type, descrip, qty, amt, vat_percent, tax_amt_percent, net_amt, type_name, cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	PreparedStatement pst41 = con.prepareStatement(q1);

	for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

		if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
			
			pst41.setString(1, inv21.trim());
			

			String btype = "";

			try {
				btype = ib.getBtype()[j1];
			} catch (Exception e) {
				
				btype = "";
			}
			pst41.setString(2, btype);

			// pst41.setString(2,"labour");

			pst41.setString(3, ib.getDescription1()[j1]);

			Double amount = 0.0;
			double vatpercent = 0.0;
			double taxamount = 0.0;
			double netamount = 0.0;

			String amountlist = ib.getAmount1()[j1];

			String vatpercentlist = ib.getVat1()[j1];

			String taxamountlist = ib.getTaxqmount1()[j1];

			// String qty=ib.getQuantity1()[j1];
			// Integer Quantity1=0;
			String netamountlist = ib.getVatamount1()[j1];

			Double Quantity1 = 0.0;
			try {
				String qty = ib.getQuantity1()[j1];
			
				Quantity1 = Double.parseDouble(qty);
				;
			} catch (Exception e) {
				
				Quantity1 = 0.0;
			}

		
			pst41.setDouble(4, Quantity1);
			

			try {
				amount = Double.parseDouble(amountlist);
			} catch (Exception e) {
				
				amount = 0.0;
			}

			try {
				vatpercent = Double.parseDouble(vatpercentlist);
			} catch (Exception e) {
				
				vatpercent = 0;
			}

			try {
				taxamount = Double.parseDouble(taxamountlist);
			} catch (Exception e) {
				
				taxamount = 0;
			}
			try {
				netamount = Double.parseDouble(netamountlist);
			} catch (Exception e) {
				
				netamount = 0;
			}

			
			pst41.setDouble(5, amount);
			pst41.setDouble(6, vatpercent);

			pst41.setDouble(7, taxamount);
			pst41.setDouble(8, netamount);
			String ttype = "";

			try {
				ttype = ib.getTtype()[j1];
			} catch (Exception e) {
				
				ttype = "";
			}
			pst41.setString(9, ttype);
			
			pst41.setString(10, ib.getGrate1()[j1]);
			pst41.setString(11, ib.getGstamount1()[j1]);
			pst41.setString(12, ib.getGrate2()[j1]);
			pst41.setString(13, ib.getGstamount2()[j1]);
			pst41.setString(14, ib.getMyrate()[j1]);
			pst41.setString(15, ib.getPartno()[j1]);
			pst41.setString(16, ib.getPartdate()[j1]);
			pst41.setString(17, ib.getPartnox()[j1]);
			pst41.setString(18, ib.getDisc()[j1]);
			pst41.setString(19, ib.getDiscamt()[j1]);
			pst41.setString(20, ib.getAmtwithdisc()[j1]);
			pst41.setString(21, ib.getPerunit()[j1]);
			i = i++;
			String sn = "" + i;

			ib.setSn(sn);

			l1 = pst41.executeUpdate();

		}
		
		
		String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
		 inv2 = ib.getInvno();
		 inv21 = " " + inv2;
		PreparedStatement pstdel1 = con.prepareStatement(qd1);
		pstdel1.setString(1, inv21.trim());

		int n12 = pstdel1.executeUpdate();
	
				PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
				System.out.println("preparedStatement112"+preparedStatement112zz);
			ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

			while (resultSet12zz.next()) {
				
			query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
			PreparedStatement pst41z = con.prepareStatement(query);
			
			pst41z.setString(1, inv21.trim());	
			pst41z.setString(2, resultSet12zz.getString("type_name"));	
			pst41z.setString(3, resultSet12zz.getString("cgstrate"));	
			pst41z.setString(4, resultSet12zz.getString("sgstrate"));	
			pst41z.setString(5, resultSet12zz.getString("cgstamount"));	
			pst41z.setString(6, resultSet12zz.getString("sgstamount"));	
			pst41z.setString(7, resultSet12zz.getString("vat_percent"));	
			pst41z.setString(8, resultSet12zz.getString("taxablevalue"));	
			System.out.println(pst41z);
			pst41z.executeUpdate();
			}
			
		
		if (l1 > 0 && n1 > 0) {
			response = "success";
		} else {
			response = "fail";

		}

	}

	// --------------

	// update taxcollection details

	String qdtc = "delete  from invoice_tax_collection where invoice_no=?";
	String inv23 = ib.getInvno();
	String inv231 = " " + inv23;
	PreparedStatement pstdeltc = con.prepareStatement(qdtc);
	pstdeltc.setString(1, inv231.trim());

	int ntc = pstdeltc.executeUpdate();
	 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

	 pst41 = con.prepareStatement(q1);
	for (int j1 = 0; j1 < ib.getT().length; j1++) {
		pst41.setString(1, inv231.trim());
		
		String type = "";
		String taxableamount = ib.getA()[j1];
		String tax = ib.getA2()[j1];

		double taxableamount1 = 0.0;
		double tax1 = 0.0;
		// double netamount =0.0;
		try {
			type = ib.getT()[j1];
		} catch (Exception e) {
			
			type = "";
		}

		pst41.setString(2, type);

		try {
			taxableamount1 = Double.parseDouble(taxableamount);
		} catch (Exception e) {
			
			taxableamount1 = 0.0;
		}

		pst41.setDouble(3, taxableamount1);

		try {
			tax1 = Double.parseDouble(tax);
		} catch (Exception e) {
			
			tax1 = 0.0;
		}

		pst41.setDouble(4, tax1);

		

		pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

		int js = pst41.executeUpdate();
		
		
		
		
		
		query = "UPDATE   customercreditdebit  set Amount=? where Documentsno=?";

		inv1=ib.getInvno();
		ib.setInvoiceno(inv1);
		Date d1 = new Date();
		String da = "" + d1;
	
		pst9 = con.prepareStatement(query);
		pst9.setString(1, ib.getTamount());
		pst9.setString(2, inv1);
		
				
			k = pst9.executeUpdate();

		

		if (js > 0 && ntc > 0) {
			response = "success";
		} else {
			response = "fail";

		}
	}
		// pst41.setString(2,"labour");

	}

	try{
		
		DBConnection connection1=new DBConnection();Connection con1 = connection1.getConnection();
			
		
	}catch(Exception e){}

}

else {
	
	
	
	
	System.out.println("lead_no:"+lead_no);
	String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,lead_no,status)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
	 pst9=con.prepareStatement(query1);
	 pst9.setString(40, lead_no);
	pst9.setString(1, ib.getCustomer_Id());
	pst9.setString(10,stringValue1);
	pst9.setString(14, ib.getJob_Card_no());
	pst9.setString(19, ib.getPono());
	pst9.setString(20, CoreData.getDateFormatAsDb(ib.getPodate()));
	pst9.setString(21, ib.getTermcond());
	pst9.setString(22, ib.getVendor());
	pst9.setString(23, ib.getDcnox());
	pst9.setString(24, ib.getDcdatex());
	
	pst9.setString(25, ib.getTransmode());
	pst9.setString(26, ib.getContactp());
	pst9.setString(27, ib.getContactpno());
	pst9.setString(28, ib.getShipparty());
	pst9.setString(29, ib.getShipadd());
	pst9.setString(30, ib.getShipgstn());
	pst9.setString(31, ib.getShipstate());
	pst9.setString(32, ib.getVehino());
	pst9.setString(33, ib.getFreight());
	pst9.setString(34, ib.getTransport());
	pst9.setString(35, "sgst");
	pst9.setString(36, ""+ib.getTamount());
	pst9.setString(37, ""+ib.getA2()[0]);
	pst9.setString(38, ""+ib.getA2()[1]);
	pst9.setString(39, ""+ib.getA2()[2]);
	String paid_amt="";
	String balance_amt="";
	paid_amt=ib.getPaid_amt();
	balance_amt=ib.getBalance_amt();
	
	
	try{
	 x = Integer.valueOf(paid_amt);
	}catch (Exception e) {
		
		x=0;
	}
	try{
	 Y = Integer.valueOf(balance_amt);
	}catch (Exception e) {
		
		Y=0;
	}
	//Integer  pp=Integer.parseInt(paid_amt);
	//Integer  bb=Integer.parseInt(balance_amt);
	
	// CASH
	if(ib.getPaymod().equalsIgnoreCase("CASH"))
	{
	pst9.setString(3, "CASH");
	
	String paid_amt1="";

	paid_amt1=ib.getNet_amount();
	
	
	/*try{
		 x = Integer.valueOf(paid_amt1);
		}catch (Exception e) {
			
			x=0;
		}
	*/
			
	pst9.setString(4, paid_amt1);
	pst9.setString(5, ""+0);
	
	pst9.setString(7,"");
	pst9.setInt(8,0);
	pst9.setString(9,"");
	
	pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
	pst9.setNull(6,java.sql.Types.DATE);
	pst9.setString(11,""+ x);
	pst9.setString(12,""+ 0);
	pst9.setString(13, ""+0);
	pst9.setString(15, ""+ib.getTamount());
	pst9.setString(18, "0");
	pst9.setString(16, "");
	
	pst9.setString(17,"");
	
	 k=pst9.executeUpdate();
	 
	 PreparedStatement pst=con.prepareStatement("UPDATE `sales_agreement_master` SET `status`=2 WHERE `lead_no`='"+lead_no+"'");
	int i=pst.executeUpdate();
	
	 System.out.println("query of pst9:"+pst9+"K:"+k);
	 
	}
	
	// CHEQUE
	else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
	{
		
		
		pst9.setString(3, "CHEQUE");
		Integer l=0;
		String paid_amt2="";
		String chek_amt="";
	
		paid_amt2=ib.getCash_amt();
		
	
		chek_amt=ib.getCheque_amt();
		Integer c=0;
		try{
			 l = Integer.valueOf(chek_amt);
			}catch (Exception e) {
				
				l=0;
			}
			pst9.setString(4, ""+l);
			pst9.setString(5, ""+0);
			
			pst9.setString(7,ib.getCheque_no());
			pst9.setString(8,""+0);
			pst9.setString(9,"");
			
			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			String dateInString=ib.getCheque_date();
			Date dNo = new Date();
			dNo = ft.parse(dateInString);
			Date dNow = new Date();
		
		
			try{
			pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
			}catch (Exception e) {
				
				pst9.setString(2,null);
			}
			
		
			try{
			pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
			}catch (Exception e) {
				
				pst9.setString(6,null);
			}																																		
			
			pst9.setString(11, ""+0);
			try{
				c = Integer.valueOf(chek_amt);
				}catch (Exception e) {
					
					c=0;
				}
			pst9.setString(12, ""+c);
			pst9.setString(13, ""+0);
			pst9.setString(15, ""+ib.getTamount());
			pst9.setString(16, ""+ib.getBankname());
			
			pst9.setString(17, "");
			pst9.setString(18, "0");
			
			 k=pst9.executeUpdate();
		
		}
		
		
		
		//credit
		
	else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
	{
		
		
		pst9.setString(3, "CARD");
		
		String paid_amt2="";
		String chek_amt="";
	
		paid_amt2=ib.getNet_amountcard();
		
	
		chek_amt=ib.getNet_amountcard();
		Integer c=0;
		Integer a=0;
		try{
			 a = Integer.valueOf(paid_amt2);
			}catch (Exception e) {
				
				a=0;
			}
			pst9.setString(4, ""+a);
			pst9.setString(5,""+ 0);
			
			pst9.setString(7,"");
			pst9.setString(8,ib.getCardid());
			pst9.setString(9,"");
			
			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*String dateInString=ib.getCheque_date();
			Date dNo = new Date();
			dNo = ft.parse(dateInString);*/
			Date dNow = new Date();
		
		
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6,java.sql.Types.DATE);
																																						
			
			pst9.setInt(11, 0);
			try{
				c = Integer.valueOf(chek_amt);
				}catch (Exception e) {
					
					c=0;
				}
			pst9.setString(12,""+ 0);
			pst9.setString(13, ""+a);
			pst9.setString(15, ""+ib.getTamount());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
			pst9.setString(18, "0");
			
			 k=pst9.executeUpdate();
		
		}
		
		// Insurance
	else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
	{
		
		
		pst9.setString(3, "INSURANCE");
		
		String paid_amt2="";
		String balace="";
		String chek_amt="";
	
		paid_amt2=ib.getPaid_amt22();
		
		
		//chek_amt=ib.getNet_amountcard();
		balace=ib.getBalance_amt22();
		Integer c=0;
		Integer a=0;
		try{
			 a = Integer.valueOf(paid_amt2);
			}catch (Exception e) {
				
				a=0;
			}
			pst9.setString(4, ""+a);
			try{
				c = Integer.valueOf(balace);
				}catch (Exception e) {
					
					c=0;
				}
			pst9.setString(5,""+ c);
			
			pst9.setString(7,"");
			pst9.setString(8,""+0);
			pst9.setString(9,ib.getInsurance());
			
			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*String dateInString=ib.getCheque_date();
			Date dNo = new Date();
			dNo = ft.parse(dateInString);*/
			Date dNow = new Date();
		
		
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6,java.sql.Types.DATE);
																																						
			
			pst9.setString(11, ""+a);
			
			pst9.setString(12, ""+0);
			pst9.setString(13, ""+0);
			pst9.setString(15, ""+ib.getTamount());
			pst9.setString(16, "");
			String d=null;
			try{
			 d= CoreData.getDateFormatAsDb(ib.getDate22());
			}catch (Exception e) {
				
				d=null;
			}
			pst9.setString(17, d);
			pst9.setString(18, "0");
			
			 k=pst9.executeUpdate();
		
		}
		
		
		
	else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
	{
		
		String paymode="";
		String paid_amt2 = "";
		String balace = "";
		String chek_amt = "";
		String paycash = "";
		String paycheque = "";
		String paycredit = "";
		paid_amt2 = ib.getPaid_amt();

		if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
		{
			paymode=ib.getR1()+"~"+"CASH";
			pst9.setString(11, paid_amt2);
			pst9.setString(12, "0");
			pst9.setString(13, "0");
		
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
		{
			
			paymode=ib.getR1()+"~"+"CHEQUE";
			pst9.setString(12, paid_amt2);
			pst9.setString(11, "0");
			pst9.setString(13, "0");
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
		{
			paymode=ib.getR1()+"~"+"CARD";
			pst9.setString(11,"0");
			
			pst9.setString(12, "0");
			pst9.setString(13, paid_amt2);
			
		}
		else
		{
			paymode=ib.getPaymod();
				pst9.setString(11,"0");
			
			pst9.setString(12, "0");
			pst9.setString(13,"0");
		}
		

		pst9.setString(3, paymode);		
		
		//chek_amt=ib.getNet_amountcard();
		balace=ib.getBalance_amt();
		Integer c=0;
		Integer a=0;
		try{
			 a = Integer.valueOf(paid_amt2);
			}catch (Exception e) {
				
				a=0;
			}
			pst9.setString(4, ""+a);
			try{
				c = Integer.valueOf(balace);
				}catch (Exception e) {
					
					c=0;
				}
			pst9.setString(5, ""+c);
			
			pst9.setString(7,"");
			pst9.setString(8,""+0);
			pst9.setString(9,"");
			
			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*String dateInString=ib.getCheque_date();
			Date dNo = new Date();
			dNo = ft.parse(dateInString);*/
			Date dNow = new Date();
		
			
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		
			pst9.setNull(6,java.sql.Types.DATE);
																																						
			
			
			pst9.setString(15, ""+ib.getTamount());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
			pst9.setString(18, "0");
			
			 k=pst9.executeUpdate();
		
		}
		
		
		// card and cash
	
	else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
	{
		
		
		pst9.setString(3, "CARDANDCASH");
		
		String paid_amt2="";
		String balace="";
		String credit="";
	
		paid_amt2=ib.getCashhh();
		
		
		//chek_amt=ib.getNet_amountcard();
		credit=ib.getCarddd();
		Integer c=0;
		Integer a=0;
		Integer p=0;
		try{
			 a = Integer.valueOf(paid_amt2);
			}catch (Exception e) {
				
				a=0;
			}
			
			try{
				 c = Integer.valueOf(credit);
				}catch (Exception e) {
					
					c=0;
				}
			
			p=(a+c);
			
			pst9.setString(4, ""+p);
			/*try{
				c = Integer.valueOf(balace);
				}catch (Exception e) {
					
					c=0;
				}*/
			pst9.setString(5, ""+0);
			
			pst9.setString(7,"");
			pst9.setString(8,""+0);
			pst9.setString(9,"");
			
			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*String dateInString=ib.getCheque_date();
			Date dNo = new Date();
			dNo = ft.parse(dateInString);*/
			Date dNow = new Date();
		
		
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6,java.sql.Types.DATE);
																																						
			
			pst9.setString(11,""+paid_amt2);
			
			pst9.setString(12, ""+0);
			pst9.setString(13, ""+credit);
			pst9.setString(15, ""+ib.getTamount());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
			pst9.setString(18, "0");
			
			 k=pst9.executeUpdate();
		
		}else{
			
			pst9.setString(3, "");
	
				pst9.setString(4, "");
				
				pst9.setString(5, ""+0);
				
				pst9.setString(7,"");
				pst9.setString(8,""+0);
				pst9.setString(9,"");
				
				
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6,java.sql.Types.DATE);
																																							
				
				pst9.setString(11,"");
				
				pst9.setString(12, "");
				pst9.setString(13, "");
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
				pst9.setString(18, "0");
			
				 k=pst9.executeUpdate();
			
		}

	
	
	
	
	// Insert Into Customer Credit Debit Report
	

	String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
	
	pst9=con.prepareStatement(query11);
	pst9.setString(1, ib.getCustomer_Id());
	pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
	pst9.setString(3,stringValue1);
	pst9.setString(4, "Invoice");
	pst9.setString(5, "101");
	pst9.setString(6, "Debit");
	pst9.setString(7,ib.getTamount());
	pst9.setString(8,ib.getCustomer_name());
	
	System.out.println("SQL:"+pst9);
	 k=pst9.executeUpdate();
		
	 
	 
	 
	// Bill Number Generation For Customer Credit Debit
		
	
	//--------------------
		
		
	PreparedStatement preparedStatement1121 = con
	.prepareStatement("update  job_card set job_card_done_status='"
			+ 1 + "' where job_card_no=? ");

preparedStatement1121.setString(1, ib.getJob_Card_no());
j = preparedStatement1121.executeUpdate();

if (k > 0 && j > 0 && v>0) {
response = "success";
} else {
response = "fail";

}

try{
System.out.println(">>>>s");

PreparedStatement preparedStatement112 = con.prepareStatement("select * from settings ");
		//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	System.out.println(">>>>s1");

	if (resultSet12.next()) {
		System.out.println(">>>>s2"+resultSet12.getString("po"));

	if(resultSet12.getString("po").trim().equals("yes")){	
		System.out.println(">>>>3>>>"+ib.getDescription1().length);

for (int k2=0;k2<ib.getDescription1().length;k2++)
{
System.out.println(">>>>4");

System.out.println(">>>>s");
PreparedStatement ppt = con
	.prepareStatement("select qtyremaining,descrip from purchase_order_details where pono='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

System.out.println("SQL:"+ppt);
ResultSet rst = ppt.executeQuery();

while (rst.next()) {

String desc=ib.getDescription1()[k2];
String qty=rst.getString("qtyremaining");

System.out.println("Quantity:"+qty);

String qty1=ib.getQuantity1()[k2];

Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);

System.out.println("New QUantity:"+qty2);

String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and pono='"+ib.getPono()+"'";
PreparedStatement ps1 = con.prepareStatement(q11);	


System.out.println("Sql12::"+ps1);

ps1.executeUpdate();

}

}
	}
	}
}catch(Exception e){


}

	// list insert

	int rr = 0;
	String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	PreparedStatement pst41 = con.prepareStatement(q1);
	for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
		if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
		

		pst41.setString(1, stringValue1.trim());

		String btype = "";

		try {
			btype = ib.getBtype()[j1];
		} catch (Exception e) {
			
			btype = "";
		}
		pst41.setString(2, btype);

		// pst41.setString(2,"labour");

		pst41.setString(3, ib.getDescription1()[j1]);

		Double amount = 0.0;
		double vatpercent = 0.0;
		double taxamount = 0.0;
		double netamount = 0.0;

		String amountlist = ib.getAmount1()[j1];

		String vatpercentlist = ib.getVat1()[j1];

		String taxamountlist = ib.getTaxqmount1()[j1];

		String netamountlist = ib.getVatamount1()[j1];

		Double Quantity1 = 0.0;
		try {
			String qty = ib.getQuantity1()[j1];
			
			Quantity1 = Double.parseDouble(qty);
			
		} catch (Exception e) {
		
			Quantity1 = 0.0;
		}

	
		pst41.setDouble(4, Quantity1);

		try {
			amount = Double.parseDouble(amountlist);
		} catch (Exception e) {
			
			amount = 0.0;
		}
		
		try {
			vatpercent = Double.parseDouble(vatpercentlist);
		} catch (Exception e) {
			
			vatpercent = 0;
		}

		try {
			taxamount = Double.parseDouble(taxamountlist);
		} catch (Exception e) {
			
			taxamount = 0;
		}
		try {
			netamount = Double.parseDouble(netamountlist);
		} catch (Exception e) {
			
			netamount = 0;
		}

		
		pst41.setDouble(5, amount);
		pst41.setDouble(6, vatpercent);

		pst41.setDouble(7, taxamount);
		pst41.setDouble(8, netamount);
		String ttype = "";

		try {
			ttype = ib.getTtype()[j1];
		} catch (Exception e) {
			
			ttype = "";
		}
		pst41.setString(9, ttype);
		pst41.setString(10, ib.getGrate1()[j1]);
		pst41.setString(11, ib.getGstamount1()[j1]);
		pst41.setString(12, ib.getGrate2()[j1]);
		pst41.setString(13, ib.getGstamount2()[j1]);
		pst41.setString(14, ib.getMyrate()[j1]);
		pst41.setString(15, ib.getPartno()[j1]);
		pst41.setString(16, ib.getPartdate()[j1]);
		pst41.setString(17, ib.getPartnox()[j1]);
		pst41.setString(18, ib.getDisc()[j1]);
		pst41.setString(19, ib.getDiscamt()[j1]);
		pst41.setString(20, ib.getAmtwithdisc()[j1]);
		pst41.setString(21, ib.getPerunit()[j1]);
		int l1 = pst41.executeUpdate();

		if (l1 > 0) {
			response = "success";
		} else {
			response = "fail";

		}

		rr = rr + 1;
		;

		String sn = "" + rr;

		ib.setSn(sn);
		}

	}

	// -----------
	

			PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+stringValue1+"' GROUP BY type_name   ");
			System.out.println("preparedStatement112"+preparedStatement112zz);
		ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

		while (resultSet12zz.next()) {
			
		query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
		PreparedStatement pst41x = con.prepareStatement(query);
		
		pst41x.setString(1, stringValue1);	
		pst41x.setString(2, resultSet12zz.getString("type_name"));	
		pst41x.setString(3, resultSet12zz.getString("cgstrate"));	
		pst41x.setString(4, resultSet12zz.getString("sgstrate"));	
		pst41x.setString(5, resultSet12zz.getString("cgstamount"));	
		pst41x.setString(6, resultSet12zz.getString("sgstamount"));	
		pst41x.setString(7, resultSet12zz.getString("vat_percent"));	
		pst41x.setString(8, resultSet12zz.getString("taxablevalue"));	
		System.out.println(pst41x);
		pst41x.executeUpdate();
		}

	// insert to tax collection
	 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

	 pst41 = con.prepareStatement(q1);
	for (int j1 = 0; j1 < ib.getT().length; j1++) {

		

		pst41.setString(1, stringValue1);

		
		String type = "";
		String taxableamount = ib.getA()[j1];
		String tax = ib.getA2()[j1];

		double taxableamount1 = 0.0;
		double tax1 = 0.0;
		// double netamount =0.0;
		try {
			type = ib.getT()[j1];
		} catch (Exception e) {
			
			type = "";
		}

		pst41.setString(2, type);

		try {
			taxableamount1 = Double.parseDouble(taxableamount);
		} catch (Exception e) {
			
			taxableamount1 = 0.0;
		}

		pst41.setDouble(3, taxableamount1);

		try {
			tax1 = Double.parseDouble(tax);
		} catch (Exception e) {
			
			tax1 = 0.0;
		}

		pst41.setDouble(4, tax1);

		
		pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
	
		
		int js = pst41.executeUpdate();

		if (js > 0) {
			response = "success";
		} else {
			response = "fail";

		}

		// pst41.setString(2,"labour");

	}

}

// -----

try{
	
	DBConnection connection1=new DBConnection();Connection conn = connection1.getConnection();

	
}catch(Exception e){
	
}

}

return response;
}
	public String insertdescinfo(String sparename, String model, String cprice,
			String comprice, String taxtype, String taxper, String remark, String unit)
			throws SQLException {
		String response = "";
		

		 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
		PreparedStatement pst41;


		String q1 = "insert into spare_master(spare_name,description,company_price,cust_price,tax_type,tax_percent,remark,spare_id,model,unit) values(?,?,?,?,?,?,?,?,?,?)";

				pst41 = con.prepareStatement(q1);
		
		pst41.setString(1, sparename);
		pst41.setString(2, sparename);

		pst41.setString(5, taxtype);
		
		pst41.setString(7, "ok");

		String tax = taxper;

		float ta = 0.0f;
		try {
			ta = Float.parseFloat(tax);
		} catch (Exception e) {
			
			ta = 0.0f;
		}

		pst41.setFloat(6, ta);

		Integer q = 0;
		String amt = comprice;

		try {
			q = Integer.valueOf(amt);
		} catch (Exception e) {
			
			q = 0;
		}

		pst41.setInt(3, q);

		Integer k = 0;

		String amt1 = cprice;

		try {
			k = Integer.valueOf(amt1);
		} catch (Exception e) {
			
			k = 0;
		}

		pst41.setInt(4, k);

		String SPARENAME = sparename;

		pst41.setString(8, SPARENAME);
		
	
		pst41.setString(9, model);
		pst41.setString(10, unit);

		int HH = pst41.executeUpdate();

	

		if (HH > 0) {
			response = "success";
		} else {
			response = "fail";

		}
		try{
			if(!con.isClosed()){
				con.close();
			}
		}catch(Exception e){
			
		}
		return response;
	}

	public String insertdescinfo1(String service_name, String tax_type,
			String taxpercent, String amount) throws SQLException {
		
		String response = "";
		

		 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
		PreparedStatement pst41;

		String q1 = "insert into stax_master(service_tax_name,tax_percent,tax_type,amount) values(?,?,?,?)";

		pst41 = con.prepareStatement(q1);

		pst41.setString(1, service_name);
		String tax = taxpercent;
		float ta = 0.0f;
		ta = Float.parseFloat(tax);
		pst41.setFloat(2, ta);
		pst41.setString(3, tax_type);
		pst41.setString(4, amount);
		

		int HH = pst41.executeUpdate();

		if (HH > 0) {
			response = "success";
		} else {
			response = "fail";

		}
		try{
			if(!con.isClosed()){
				con.close();
			}
		}catch(Exception e){
			
		}
		return response;

	}

	public invoicebean FetchspareGatepassAssemblyform(String autoinvoice) {
		

		invoicebean ib = new invoicebean();
		int sparesize = 0;
		List<String> type = new ArrayList<String>();
		List<String> descrip = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
		List<String> amt = new ArrayList<String>();
		List<String> vat_percent = new ArrayList<String>();
		List<String> tax_amt_percent = new ArrayList<String>();
		List<String> net_amt = new ArrayList<String>();
		List<String> type_name = new ArrayList<String>();
		
		List<String> rate1 = new ArrayList<String>();
		List<String> rate2= new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2= new ArrayList<String>();
		List<String> myrate= new ArrayList<String>();
		List<String> partno= new ArrayList<String>();
		List<String> partdate= new ArrayList<String>();
		List<String> partnox= new ArrayList<String>();
		List<String> dcno= new ArrayList<String>();
		List<String> disc= new ArrayList<String>();
		List<String> discamt= new ArrayList<String>();
		List<String> amtwithdisc= new ArrayList<String>();
		try {
			int sno = 1;

			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();

			PreparedStatement pst = con
					.prepareStatement("select * from invoice_tax_details  where invoice_no='"
							+  autoinvoice + "'");

			
			ResultSet rs = pst.executeQuery();

		
			while (rs.next()) {

				type.add(rs.getString("type"));
				descrip.add(rs.getString("descrip"));
				qty.add(rs.getString("qty"));
				amt.add(rs.getString("amt"));
				vat_percent.add(rs.getString("vat_percent"));
				tax_amt_percent.add(rs.getString("tax_amt_percent"));
				net_amt.add(rs.getString("net_amt"));
				type_name.add(rs.getString("type_name"));
				rate1.add(rs.getString("cgstrate"));
				rate2.add(rs.getString("sgstrate"));
				myrate.add(rs.getString("rate"));
				gstamt1.add(rs.getString("cgstamount"));
				gstamt2.add(rs.getString("sgstamount"));
				partno.add(rs.getString("partno"));
				partdate.add(rs.getString("partdate"));
				partnox.add(rs.getString("partnox"));
				dcno.add(rs.getString("dcno"));
				
				disc.add(rs.getString("disc"));
				discamt.add(rs.getString("discamt"));
				amtwithdisc.add(rs.getString("amtwithdisc"));
				System.out.println(">>>"+rs.getString("amtwithdisc"));
				
				sparesize++;
			}

			
			
			try{
				//DaoHelper.closeConnection();
			}catch(Exception e){
				
			}
			
			
		} catch (Exception e) {
			
		}
		ib.setSparesize(sparesize);
		ib.setType1(type);
		ib.setDescrip1(descrip);
		ib.setQty1(qty);
		ib.setTax_amt_percent1(tax_amt_percent);
		ib.setAmt112(amt);
		ib.setVat_percent1(vat_percent);
		ib.setNet_amt1(net_amt);
		ib.setType_name1(type_name);
		ib.setMyrate2(myrate);
		ib.setRate1(rate1);
		ib.setRate2(rate2);
		ib.setGstamt1(gstamt1);
		ib.setGstamt2(gstamt2);
		ib.setPartno2(partno);
		ib.setPartdate2(partdate);
		ib.setPartnox2(partnox);
		ib.setDcno2(dcno);
		
		ib.setDisc2(disc);
		ib.setDiscamt2(discamt);
		ib.setAmtwithdisc2(amtwithdisc);
		
		
		return ib;

	}


	
	
	
	public invoicebean FetchspareGatepassAssemblyformSales(String autoinvoice) {
		

		invoicebean ib = new invoicebean();
		int sparesize = 0;
		List<String> type = new ArrayList<String>();
		List<String> descrip = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
		List<String> amt = new ArrayList<String>();
		List<String> vat_percent = new ArrayList<String>();
		List<String> tax_amt_percent = new ArrayList<String>();
		List<String> net_amt = new ArrayList<String>();
		List<String> type_name = new ArrayList<String>();
		
		List<String> rate1 = new ArrayList<String>();
		List<String> rate2= new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2= new ArrayList<String>();
		List<String> myrate= new ArrayList<String>();
		List<String> partno= new ArrayList<String>();
		List<String> partdate= new ArrayList<String>();
		List<String> partnox= new ArrayList<String>();
		List<String> dcno= new ArrayList<String>();
		try {
			int sno = 1;

			// DBConnection connection=new DBConnection();Connection con = connection.getConnection();
			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
		    	
			PreparedStatement pst = con
					.prepareStatement("select * from invoice_tax_details_sales_return  where invoice_no='"
							+  autoinvoice + "'");

			
			ResultSet rs = pst.executeQuery();

		
			while (rs.next()) {

				type.add(rs.getString("type"));
				descrip.add(rs.getString("descrip"));
				qty.add(rs.getString("qty"));
				amt.add(rs.getString("amt"));
				vat_percent.add(rs.getString("vat_percent"));
				tax_amt_percent.add(rs.getString("tax_amt_percent"));
				net_amt.add(rs.getString("net_amt"));
				type_name.add(rs.getString("type_name"));
				rate1.add(rs.getString("cgstrate"));
				rate2.add(rs.getString("sgstrate"));
				myrate.add(rs.getString("rate"));
				gstamt1.add(rs.getString("cgstamount"));
				gstamt2.add(rs.getString("sgstamount"));
				partno.add(rs.getString("partno"));
				partdate.add(rs.getString("partdate"));
				partnox.add(rs.getString("partnox"));
				dcno.add(rs.getString("dcno"));
				sparesize++;
			}

			
			
			try{
				//DaoHelper.closeConnection();
			}catch(Exception e){
				
			}
			
			
		} catch (Exception e) {
			
		}
		ib.setSparesize(sparesize);
		ib.setType1(type);
		ib.setDescrip1(descrip);
		ib.setQty1(qty);
		ib.setTax_amt_percent1(tax_amt_percent);
		ib.setAmt112(amt);
		ib.setVat_percent1(vat_percent);
		ib.setNet_amt1(net_amt);
		ib.setType_name1(type_name);
		ib.setMyrate2(myrate);
		ib.setRate1(rate1);
		ib.setRate2(rate2);
		ib.setGstamt1(gstamt1);
		ib.setGstamt2(gstamt2);
		ib.setPartno2(partno);
		ib.setPartdate2(partdate);
		ib.setPartnox2(partnox);
		ib.setDcno2(dcno);
		return ib;

	}

	
	
	
	//Add purchase order
	
	
	public String Add_purchaseorder(invoicebean ib) throws SQLException {

	
	int k = 0;
	
	
	
	Integer x = 0;
	
	
	String response = null;
	 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
	// fiscal year
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
        


	

	String pref = "PO";

	PreparedStatement pst9 = null;

	// String pref="INV";
	PreparedStatement preparedStatement11 = con
			.prepareStatement("select  max(SUBSTRING(invoice_no,-5)) as myval1 from purchase_order  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
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
		stringValue1 =  Fyear + "/0000" + stringValue1;

	} else {

		if (String.valueOf(myval1).length() == 1) {
			stringValue1 =  Fyear + "/0000" + String.valueOf(myval1);

		} else if (String.valueOf(myval1).length() == 2) {
			stringValue1 = Fyear + "/000" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 3) {
			stringValue1 =  Fyear + "/00" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 4) { 
			stringValue1 =  Fyear + "/0" + String.valueOf(myval1);
		}
		else {
			stringValue1 =  Fyear + "/" + String.valueOf(myval1);
		}
	}

	ib.setInvoiceno(stringValue1);
	String query = "";
	PreparedStatement preparedStatement = con
			.prepareStatement("select * from purchase_order where  pono=?");
	
	preparedStatement.setString(1, ib.getPono());
	
	ResultSet resultSet = preparedStatement.executeQuery();
	if (resultSet.next()) {
		response = "Already";
		
	}else{
		
		String query1="INSERT INTO purchase_order(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,name)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 pst9=con.prepareStatement(query1);
		pst9.setString(1, ib.getCustomer_Id());
		pst9.setString(10,stringValue1);
		pst9.setString(14, ib.getJob_Card_no());
		pst9.setString(19, ib.getPono());
		pst9.setString(20, CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setString(21, ib.getTermcond());
		pst9.setString(22, ib.getVendor());
		pst9.setString(23, ib.getCustomer_name());
		
		//Integer  pp=Integer.parseInt(paid_amt);
		//Integer  bb=Integer.parseInt(balance_amt);
		
		// CASH
		
		pst9.setString(3, "CASH");
		
		
		
		
		
		
		pst9.setString(4, ""+x);
		pst9.setString(5, ""+0);
		
		pst9.setString(7,"");
		pst9.setInt(8,0);
		pst9.setString(9,"");
		
		pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setString(6,null);
		pst9.setString(11,"");
		pst9.setString(12,"");
		pst9.setString(13, "");
		pst9.setString(15, ""+ib.getTamount());
		pst9.setString(18, "0");
		pst9.setString(16, "");
		
		pst9.setString(17,"");
		
		 k=pst9.executeUpdate();	
		
		

		// list insert

		int rr = 0;
		String q1 = "insert into purchase_order_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,disc,discamt,qtyremaining,dcqty,custid,pono) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pst41 = con.prepareStatement(q1);
		for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
			if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
			

			pst41.setString(1, stringValue1.trim());

			String btype = "";

			try {
				btype = ib.getBtype()[j1];
			} catch (Exception e) {
				
				btype = "";
			}
			pst41.setString(2, btype);

			// pst41.setString(2,"labour");

			pst41.setString(3, ib.getDescription1()[j1]);

			Double amount = 0.0;
			double vatpercent = 0.0;
			double taxamount = 0.0;
			double netamount = 0.0;

			String amountlist = ib.getAmount1()[j1];

			String vatpercentlist = ib.getVat1()[j1];

			String taxamountlist = ib.getTaxqmount1()[j1];

			String netamountlist = ib.getVatamount1()[j1];

			Double Quantity1 = 0.0;
			try {
				String qty = ib.getQuantity1()[j1];
				
				Quantity1 = Double.parseDouble(qty);
				
			} catch (Exception e) {
				
				Quantity1 = 0.0;
			}

		
			pst41.setDouble(4, Quantity1);

			try {
				amount = Double.parseDouble(amountlist);
			} catch (Exception e) {
				
				amount = 0.0;
			}
			
			try {
				vatpercent = Double.parseDouble(vatpercentlist);
			} catch (Exception e) {
				
				vatpercent = 0;
			}

			try {
				taxamount = Double.parseDouble(taxamountlist);
			} catch (Exception e) {
				
				taxamount = 0;
			}
			try {
				netamount = Double.parseDouble(netamountlist);
			} catch (Exception e) {
				
				netamount = 0;
			}

			
			pst41.setDouble(5, amount);
			pst41.setDouble(6, vatpercent);

			pst41.setDouble(7, taxamount);
			pst41.setDouble(8, netamount);
			String ttype = "";

			try {
				ttype = ib.getTtype()[j1];
			} catch (Exception e) {
				
				ttype = "";
			}
			pst41.setString(9, ttype);
			pst41.setString(10, ib.getGrate1()[j1]);
			pst41.setString(11, ib.getGstamount1()[j1]);
			pst41.setString(12, ib.getGrate2()[j1]);
			pst41.setString(13, ib.getGstamount2()[j1]);
			pst41.setString(14, ib.getMyrate()[j1]);
			pst41.setString(15, ib.getDisc()[j1]);
			pst41.setString(16, ib.getDiscamt()[j1]);
			pst41.setString(17, ""+Quantity1);
			pst41.setString(18, ""+Quantity1);
			pst41.setString(19, ib.getCustomer_Id());
			pst41.setString(20, ib.getPono());
			int l1 = pst41.executeUpdate();

			if (l1 > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			rr = rr + 1;
		
			String sn = "" + rr;

			ib.setSn(sn);
			}

		}

		// -----------

		response="success";
			// pst41.setString(2,"labour");

		}

	

	// -----
	
	try{
		
			//DaoHelper.closeConnection();
	
		
	}catch(Exception e){
		
	}
	
	
	
	return response;

	}




		public String insertCustomerInfoIgst(invoicebean ib) throws SQLException,
		ParseException {
	// TODO Auto-generated method stub
	String response="";
			
			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
			int flag1 = 0;
			
			PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
			//System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet resultSet12z = preparedStatement112z.executeQuery();

		if (resultSet12z.next()) {
			
		if(resultSet12z.getString("po").equals("yes")){	
			
			for(int mx=0;mx<ib.getDescription1().length;mx++)
			{
				if(ib.getDescription1()[mx] != "" ){		
					
					Double qtyremaining=0.0;
					PreparedStatement preparedStatementx=con.prepareStatement("select * from purchase_order_details where descrip=? and pono='"+ib.getPono()+"'   ");	
					preparedStatementx.setString(1, ib.getDescription1()[mx]);
					System.out.println("SQL:"+preparedStatementx);
					ResultSet resultSetx=preparedStatementx.executeQuery();
					if(resultSetx.next())
					{
						Double qtyentered=Double.parseDouble(ib.getQuantity1()[mx]);
						
						try{
						 qtyremaining =Double.parseDouble(resultSetx.getString("qtyremaining"));
						} catch (Exception e) {
							qtyremaining=0.0;
						}
						System.out.println(qtyremaining+">>>>"+qtyentered);
						
					if(qtyremaining<qtyentered){
						System.out.println("AAA");
						response="Notsuffqty";
						System.out.println("AAA12");
						flag1=1;
						System.out.println("AAA23");
						break;
					}
					}else{
						flag1=1;
					}
					
					
					
					

				}
			
			}
			System.out.println("Flag Value:"+flag1);
		}
		
		
		}
			
			
		if(flag1==0)
		{
			System.out.println("iinFlag Value:"+flag1);
			int m = 0;
			int j3 = 0;
			int n = 0;
			int invid = 0;
			int k = 0;
			int j = 0;
			
			int v = 0;
			Integer x = 0;
			Integer Y = 0;
			String amcId1 = null;
			
			
			// fiscal year
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
		        


			

			        String pref = "GST/";

					PreparedStatement pst9 = null;
					PreparedStatement pst99 = null;

					// String pref="INV";
					PreparedStatement preparedStatement11 = con
							.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
					preparedStatement11.setString(1, "" + "%" + pref+Fyear + "%");

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
						stringValue1 = pref+ Fyear + "/0000" + stringValue1;

					} else {

						if (String.valueOf(myval1).length() == 1) {
							stringValue1 = pref+  Fyear + "/0000" + String.valueOf(myval1);

						} else if (String.valueOf(myval1).length() == 2) {
							stringValue1 =pref+  Fyear + "/000" + String.valueOf(myval1);
						} else if (String.valueOf(myval1).length() == 3) {
							stringValue1 = pref+  Fyear + "/00" + String.valueOf(myval1);
						} else if (String.valueOf(myval1).length() == 4) { 
							stringValue1 = pref+  Fyear + "/0" + String.valueOf(myval1);
						}
						else {
							stringValue1 = pref+  Fyear + "/" + String.valueOf(myval1);
						}
					}

			ib.setInvoiceno(stringValue1);
			String query = "";
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from invoice where  invoice_no=?");
			String inv = ib.getInvno();
			String inv1 = " " + inv;

			preparedStatement.setString(1, inv1.trim());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";
				PreparedStatement pst1 = con.prepareStatement(
						"select * from customer_payment_details where invoiceno='"+inv1.trim()+"'");
				System.out.println("pst........." + pst1);
				ResultSet rs1 = pst1.executeQuery();
				if (rs1.next()) {
					
					
				}else{
				
				
				if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {	
					
					
					query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

					inv1=ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;
					
					
					pst9 = con.prepareStatement(query);
					pst9.setString(1, ib.getCustomer_Id());
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setString(3, ib.getJob_Card_no());
					pst9.setString(24, inv1);
					pst9.setString(4, ib.getTamount());
					pst9.setString(5, ib.getPono());
					pst9.setString(6, ib.getPodate());
					pst9.setString(7, ib.getTermcond());
					pst9.setString(8, ib.getVendor());
					pst9.setString(9, ib.getDcnox());
					pst9.setString(10, ib.getDcdatex());
					
					pst9.setString(11, ib.getTransmode());
					pst9.setString(12, ib.getContactp());
					pst9.setString(13, ib.getContactpno());
					pst9.setString(14, ib.getShipparty());
					pst9.setString(15, ib.getShipadd());
					pst9.setString(16, ib.getShipgstn());
					pst9.setString(17, ib.getShipstate());
					pst9.setString(18, ib.getVehino());
					pst9.setString(19, ib.getFreight());
					pst9.setString(20, ib.getTransport());
					pst9.setString(21, ib.getA2()[0]);
					pst9.setString(22, ib.getA2()[1]);
					pst9.setString(23, ib.getTamount());
					k = pst9.executeUpdate();
					
				}
				else{

				query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

				inv1=ib.getInvno();
				ib.setInvoiceno(inv1);
				Date d1 = new Date();
				String da = "" + d1;
				
				
				pst9 = con.prepareStatement(query);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(37, inv1);
				pst9.setString(10, inv1);
				pst9.setString(18, ib.getPono());
				pst9.setString(19, ib.getPodate());
				pst9.setString(20, ib.getTermcond());
				// pst9.setString(2, ib.getPaymod());
				pst9.setString(21, ib.getVendor());
				pst9.setString(22, ib.getDcnox());
				pst9.setString(23, ib.getDcdatex());
				pst9.setString(24, ib.getTransmode());
				pst9.setString(25, ib.getContactp());
				pst9.setString(26, ib.getContactpno());
				pst9.setString(27, ib.getShipparty());
				pst9.setString(28, ib.getShipadd());
				pst9.setString(29, ib.getShipgstn());
				pst9.setString(30, ib.getShipstate());
				pst9.setString(31, ib.getVehino());
				pst9.setString(32, ib.getFreight());
				pst9.setString(33, ib.getTransport());
				pst9.setString(34, ib.getA2()[0]);
				pst9.setString(35, ib.getA2()[1]);
				pst9.setString(36, ib.getTamount());
				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();
		
				
				
				// CASH
				if (ib.getPaymod().trim().equals("CASH")) {
					pst9.setString(3, "CASH");
				
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, paid_amt1);
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, paid_amt1);
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
				
						
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					//paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						l = 0;
					}
					pst9.setString(4, chek_amt);
					pst9.setString(5, "0");

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "0");
					pst9.setString(9, "");

					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, chek_amt);
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, ib.getBankname());
					pst9.setString(17, "");
					

					k = pst9.executeUpdate();

				}

				// credit

				else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {

					pst9.setString(3, "CARD");

					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getNet_amountcard();

					chek_amt = ib.getNet_amountcard();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					pst9.setString(5, "0");

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					
					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "0");
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
					
					k = pst9.executeUpdate();

				}

				// Insurance
				else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {

					pst9.setString(3, "INSURANCE");

					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt22();

					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt22();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					

			

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, paid_amt2);

					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					String d="";
					try{
						d=CoreData.getDateFormatAsDb(ib.getDate22());
						
					}catch (Exception e) {
						
					}
					
					pst9.setString(16, d);
					
					pst9.setString(17, "");
				
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
	pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					
					

					pst9.setString(3, paymode);

					
					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, "");

					

					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					/*pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");*/
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					
					k = pst9.executeUpdate();

				}

				// card and cash

				else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {

					pst9.setString(3, "CARDANDCASH");

					String paid_amt2 = "";
					String balace = "";
					String credit = "";

					paid_amt2 = ib.getCashhh();

					
					// chek_amt=ib.getNet_amountcard();
					credit = ib.getCarddd();
					Integer c = 0;
					Integer a = 0;
					Integer p = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}

					try {
						c = Integer.valueOf(credit);
					} catch (Exception e) {
						
						c = 0;
					}

					p = (a + c);

					pst9.setString(4,""+p);
					/*
					 * try{ c = Integer.valueOf(balace); }catch (Exception e) { //
					 * TODO: handle exception c=0; }
					 */
					pst9.setString(5, ""+0);

					pst9.setString(7, "");
					pst9.setString(8, ""+ib.getTrandi());
					pst9.setString(9, "");

					

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, ""+a);

					pst9.setString(12, ""+0);
					pst9.setString(13, ""+c);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					k = pst9.executeUpdate();

				}else{
					
					
				
					pst9.setString(3, "");
					
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, "0");
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
				
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "0");
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					
					k = pst9.executeUpdate();

					
					
				}
				
				
	}
				
				
				
				
	
				// update tax_datails
				response = "success";
				String qd = "delete  from invoice_tax_details where invoice_no=?";
				String inv2 = ib.getInvno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = con.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
						
						pst41.setString(1, inv21.trim());
						

						String btype = "";

						try {
							btype = ib.getBtype()[j1];
						} catch (Exception e) {
							
							btype = "";
						}
						pst41.setString(2, btype);

						// pst41.setString(2,"labour");

						pst41.setString(3, ib.getDescription1()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = ib.getAmount1()[j1];

						String vatpercentlist = ib.getVat1()[j1];

						String taxamountlist = ib.getTaxqmount1()[j1];

						// String qty=ib.getQuantity1()[j1];
						// Integer Quantity1=0;
						String netamountlist = ib.getVatamount1()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = ib.getQuantity1()[j1];
						
							Quantity1 = Double.parseDouble(qty);
							;
						} catch (Exception e) {
							
							Quantity1 = 0.0;
						}

					
						pst41.setDouble(4, Quantity1);
						

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}

						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst41.setDouble(5, amount);
						pst41.setDouble(6, vatpercent);

						pst41.setDouble(7, taxamount);
						pst41.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = ib.getTtype()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst41.setString(9, ttype);
						
						pst41.setString(10, ib.getGrate1()[j1]);
						pst41.setString(11, ib.getGstamount1()[j1]);
						pst41.setString(12, ib.getGrate2()[j1]);
						pst41.setString(13, ib.getGstamount2()[j1]);
						pst41.setString(14, ib.getMyrate()[j1]);
						pst41.setString(15, ib.getPartno()[j1]);
						pst41.setString(16, ib.getPartdate()[j1]);
						pst41.setString(17, ib.getPartnox()[j1]);
						pst41.setString(18, ib.getDisc()[j1]);
						pst41.setString(19, ib.getDiscamt()[j1]);
						pst41.setString(20, ib.getAmtwithdisc()[j1]);
						
						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}
					
					String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
					 inv2 = ib.getInvno();
					 inv21 = " " + inv2;
					PreparedStatement pstdel1 = con.prepareStatement(qd1);
					pstdel1.setString(1, inv21.trim());

					int n12 = pstdel1.executeUpdate();
				
							PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(igstamount) as igstamount ,sum(amtwithdisc) as taxablevalue  ,igstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
							System.out.println("preparedStatement112"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,igstamount,rate ,taxablevalue) values (?,?,?,?,?,?) ";
						PreparedStatement pst41z = con.prepareStatement(query);
						
						pst41z.setString(1, inv21.trim());	
						pst41z.setString(2, resultSet12zz.getString("type_name"));	
						pst41z.setString(3, resultSet12zz.getString("igstrate"));	
					
						pst41z.setString(4, resultSet12zz.getString("igstamount"));	
						pst41z.setString(5, resultSet12zz.getString("vat_percent"));	
						pst41z.setString(6, resultSet12zz.getString("taxablevalue"));	
						System.out.println(pst41z);
						pst41z.executeUpdate();
						}
						
						
						
						
					if (l1 > 0 && n1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}
					
				

				}

				// --------------

				// update taxcollection details

				String qdtc = "delete  from invoice_tax_collection where invoice_no=?";
				String inv23 = ib.getInvno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = con.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {
					pst41.setString(1, inv231.trim());
					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					

					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

					int js = pst41.executeUpdate();
					
					
					query = "UPDATE   customercreditdebit  set Amount=? where Documentsno=?";

					inv1=ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;
				
					pst9 = con.prepareStatement(query);
					pst9.setString(1, ib.getTamount());
					pst9.setString(2, inv1);
					
							
						k = pst9.executeUpdate();


					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}
				
				}

				try{
					
						//DaoHelper.closeConnection();
						
					
				}catch(Exception e){}

			}

			else {
				
				
				
				
				String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,igstamount,totaltax)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 pst9=con.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10,stringValue1);
				pst9.setString(14, ib.getJob_Card_no());
				pst9.setString(19, ib.getPono());
				pst9.setString(20, CoreData.getDateFormatAsDb(ib.getPodate()));
				pst9.setString(21, ib.getTermcond());
				pst9.setString(22, ib.getVendor());
				pst9.setString(23, ib.getDcnox());
				pst9.setString(24, ib.getDcdatex());
				
				pst9.setString(25, ib.getTransmode());
				pst9.setString(26, ib.getContactp());
				pst9.setString(27, ib.getContactpno());
				pst9.setString(28, ib.getShipparty());
				pst9.setString(29, ib.getShipadd());
				pst9.setString(30, ib.getShipgstn());
				pst9.setString(31, ib.getShipstate());
				pst9.setString(32, ib.getVehino());
				pst9.setString(33, ib.getFreight());
				pst9.setString(34, ib.getTransport());
				pst9.setString(35, "igst");
				pst9.setString(36, ""+ib.getTamount());
				pst9.setString(37, ""+ib.getA2()[0]);
				pst9.setString(38, ""+ib.getA2()[1]);
				
				String paid_amt="";
				String balance_amt="";
				paid_amt=ib.getPaid_amt();
				balance_amt=ib.getBalance_amt();
				
				
				try{
				 x = Integer.valueOf(paid_amt);
				}catch (Exception e) {
					
					x=0;
				}
				try{
				 Y = Integer.valueOf(balance_amt);
				}catch (Exception e) {
					
					Y=0;
				}
				//Integer  pp=Integer.parseInt(paid_amt);
				//Integer  bb=Integer.parseInt(balance_amt);
				
				// CASH
				if(ib.getPaymod().equalsIgnoreCase("CASH"))
				{
				pst9.setString(3, "CASH");
				
				String paid_amt1="";
			
				paid_amt1=ib.getNet_amount();
				
				
				try{
					 x = Integer.valueOf(paid_amt1);
					}catch (Exception e) {
						
						x=0;
					}
				
						
				pst9.setString(4, ""+x);
				pst9.setString(5, ""+0);
				
				pst9.setString(7,"");
				pst9.setInt(8,0);
				pst9.setString(9,"");
				
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6,java.sql.Types.DATE);
				pst9.setString(11,""+ x);
				pst9.setString(12,""+ 0);
				pst9.setString(13, ""+0);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");
				
				pst9.setString(17,"");
				
				 k=pst9.executeUpdate();	
				
				}
				
				// CHEQUE
				else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				{
					
					
					pst9.setString(3, "CHEQUE");
					Integer l=0;
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getCash_amt();
					
				
					chek_amt=ib.getCheque_amt();
					Integer c=0;
					try{
						 l = Integer.valueOf(chek_amt);
						}catch (Exception e) {
							
							l=0;
						}
						pst9.setString(4, ""+l);
						pst9.setString(5, ""+0);
						
						pst9.setString(7,ib.getCheque_no());
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						try{
						pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
						}catch (Exception e) {
							
							pst9.setString(2,null);
						}
						
					
						try{
						pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
						}catch (Exception e) {
							
							pst9.setString(6,null);
						}																																		
						
						pst9.setString(11, ""+0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12, ""+c);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, ""+ib.getBankname());
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					
					//credit
					
				else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
				{
					
					
					pst9.setString(3, "CARD");
					
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getNet_amountcard();
					
				
					chek_amt=ib.getNet_amountcard();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						pst9.setString(5,""+ 0);
						
						pst9.setString(7,"");
						pst9.setString(8,ib.getCardid());
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setInt(11, 0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12,""+ 0);
						pst9.setString(13, ""+a);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					// Insurance
				else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
				{
					
					
					pst9.setString(3, "INSURANCE");
					
					String paid_amt2="";
					String balace="";
					String chek_amt="";
				
					paid_amt2=ib.getPaid_amt22();
					
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt22();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5,""+ c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,ib.getInsurance());
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11, ""+a);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						String d=null;
						try{
						 d= CoreData.getDateFormatAsDb(ib.getDate22());
						}catch (Exception e) {
							
							d=null;
						}
						pst9.setString(17, d);
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					
				else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
				{
					
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
						pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					

					pst9.setString(3, paymode);		
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5, ""+c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
						
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					// card and cash
				
				else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
				{
					
					
					pst9.setString(3, "CARDANDCASH");
					
					String paid_amt2="";
					String balace="";
					String credit="";
				
					paid_amt2=ib.getCashhh();
					
					
					//chek_amt=ib.getNet_amountcard();
					credit=ib.getCarddd();
					Integer c=0;
					Integer a=0;
					Integer p=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
						
							a=0;
						}
						
						try{
							 c = Integer.valueOf(credit);
							}catch (Exception e) {
								
								c=0;
							}
						
						p=(a+c);
						
						pst9.setString(4, ""+p);
						/*try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}*/
						pst9.setString(5, ""+0);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11,""+paid_amt2);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+credit);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}else{
						
						pst9.setString(3, "");
				
							pst9.setString(4, "");
							
							pst9.setString(5, ""+0);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setString(11,"");
							
							pst9.setString(12, "");
							pst9.setString(13, "");
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
						
							 k=pst9.executeUpdate();
						
					}
			
				
				
				
				
				// Insert Into Customer Credit Debit Report
				
		
				String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
				
				pst9=con.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3,stringValue1);
				pst9.setString(4, "Invoice");
				pst9.setString(5, "101");
				pst9.setString(6, "Debit");
				pst9.setString(7,ib.getTamount());
				
				
				pst9.setString(8,ib.getCustomer_name());
				
				System.out.println("SQL:"+pst9);
				 k=pst9.executeUpdate();
					
				 
				 
				 
				
				 
				 
					
			
						
				//--------------------
					
					
				PreparedStatement preparedStatement1121 = con
				.prepareStatement("update  job_card set job_card_done_status='"
						+ 1 + "' where job_card_no=? ");

		preparedStatement1121.setString(1, ib.getJob_Card_no());
		j = preparedStatement1121.executeUpdate();

		if (k > 0 && j > 0 && v>0) {
			response = "success";
		} else {
			response = "fail";

		}
		
		PreparedStatement preparedStatement112z1 = con.prepareStatement("select * from settings ");
		//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12z1 = preparedStatement112z1.executeQuery();

	if (resultSet12z1.next()) {
		
	if(resultSet12z1.getString("po").equals("yes")){	
		
		for (int k2=0;k2<ib.getDescription1().length;k2++)
		{
			
		
		PreparedStatement ppt = con
				.prepareStatement("select * from purchase_order_details where pono='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

		System.out.println("SQL:"+pp);
		ResultSet rst = ppt.executeQuery();

		while (rst.next()) {
			
		String desc=ib.getDescription1()[k2];
		String qty=rst.getString("qtyremaining");
		
		String qty1=ib.getQuantity1()[k2];
			
		Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);
		
		System.out.println("QUantity:"+qty2);
		
		String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and pono='"+ib.getPono()+"'";
	   	PreparedStatement ps1 = con.prepareStatement(q11);	
	   	
	   	
	 System.out.println("Sql12::"+ps1);
		
	   	ps1.executeUpdate();
		
		}
		
		}
	}
	}
		

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
					

					pst41.setString(1, stringValue1.trim());

					String btype = "";

					try {
						btype = ib.getBtype()[j1];
					} catch (Exception e) {
						
						btype = "";
					}
					pst41.setString(2, btype);

					// pst41.setString(2,"labour");

					pst41.setString(3, ib.getDescription1()[j1]);

					Double amount = 0.0;
					double vatpercent = 0.0;
					double taxamount = 0.0;
					double netamount = 0.0;

					String amountlist = ib.getAmount1()[j1];

					String vatpercentlist = ib.getVat1()[j1];

					String taxamountlist = ib.getTaxqmount1()[j1];

					String netamountlist = ib.getVatamount1()[j1];

					Double Quantity1 = 0.0;
					try {
						String qty = ib.getQuantity1()[j1];
						
						Quantity1 = Double.parseDouble(qty);
						
					} catch (Exception e) {
						
						Quantity1 = 0.0;
					}

				
					pst41.setDouble(4, Quantity1);

					try {
						amount = Double.parseDouble(amountlist);
					} catch (Exception e) {
						
						amount = 0.0;
					}
					
					try {
						vatpercent = Double.parseDouble(vatpercentlist);
					} catch (Exception e) {
						
						vatpercent = 0;
					}

					try {
						taxamount = Double.parseDouble(taxamountlist);
					} catch (Exception e) {
						
						taxamount = 0;
					}
					try {
						netamount = Double.parseDouble(netamountlist);
					} catch (Exception e) {
						
						netamount = 0;
					}

					
					pst41.setDouble(5, amount);
					pst41.setDouble(6, vatpercent);

					pst41.setDouble(7, taxamount);
					pst41.setDouble(8, netamount);
					String ttype = "";

					try {
						ttype = ib.getTtype()[j1];
					} catch (Exception e) {
						
						ttype = "";
					}
					pst41.setString(9, ttype);
					pst41.setString(10, ib.getGrate1()[j1]);
					pst41.setString(11, ib.getGstamount1()[j1]);
					pst41.setString(12, ib.getGrate2()[j1]);
					pst41.setString(13, ib.getGstamount2()[j1]);
					pst41.setString(14, ib.getMyrate()[j1]);
					pst41.setString(15, ib.getPartno()[j1]);
					pst41.setString(16, ib.getPartdate()[j1]);
					pst41.setString(17, ib.getPartnox()[j1]);
					pst41.setString(18, ib.getDisc()[j1]);
					pst41.setString(19, ib.getDiscamt()[j1]);
					pst41.setString(20, ib.getAmtwithdisc()[j1]);
					
					int l1 = pst41.executeUpdate();

					if (l1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					rr = rr + 1;
					;

					String sn = "" + rr;

					ib.setSn(sn);
					}

				}

				// -----------
				
				PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(igstamount) as igstamount,sum(amtwithdisc) as taxablevalue , igstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+stringValue1+"' GROUP BY type_name   ");
				System.out.println("preparedStatement112"+preparedStatement112zz);
			ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

			while (resultSet12zz.next()) {
				
			query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,igstamount,rate ,taxablevalue) values (?,?,?,?,?,?) ";
			PreparedStatement pst41x = con.prepareStatement(query);
			
			pst41x.setString(1, stringValue1);	
			pst41x.setString(2, resultSet12zz.getString("type_name"));	
			pst41x.setString(3, resultSet12zz.getString("igstrate"));	
	
			pst41x.setString(4, resultSet12zz.getString("igstamount"));	
			pst41x.setString(5, resultSet12zz.getString("vat_percent"));	
			pst41x.setString(6, resultSet12zz.getString("taxablevalue"));	
			System.out.println(pst41x);
			pst41x.executeUpdate();
			}


				// insert to tax collection
				 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {

					

					pst41.setString(1, stringValue1);

					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					
					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
				
					
					int js = pst41.executeUpdate();

					if (js > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

			}

			// -----
			
			try{
				
					//DaoHelper.closeConnection();
			
				
			}catch(Exception e){
				
			}
			
		}
			
			return response;
	}


		public invoicebean FetchspareGatepassAssemblyform745(String autoinvoice) {
			
			invoicebean ib = new invoicebean();
			int sparesize = 0;
			List<String> type = new ArrayList<String>();
			List<String> descrip = new ArrayList<String>();
			List<String> qty = new ArrayList<String>();
			List<String> amt = new ArrayList<String>();
			List<String> vat_percent = new ArrayList<String>();
			List<String> tax_amt_percent = new ArrayList<String>();
			List<String> net_amt = new ArrayList<String>();
			List<String> type_name = new ArrayList<String>();
			
			List<String> rate1 = new ArrayList<String>();
			List<String> rate2= new ArrayList<String>();
			List<String> gstamt1 = new ArrayList<String>();
			List<String> gstamt2= new ArrayList<String>();
			List<String> myrate= new ArrayList<String>();
			List<String> partno= new ArrayList<String>();
			List<String> partdate= new ArrayList<String>();
			List<String> partnox= new ArrayList<String>();
			List<String> disc= new ArrayList<String>();
			List<String> discamt= new ArrayList<String>();
			List<String> amtwithdisc= new ArrayList<String>();
			try {
				int sno = 1;

				 DBConnection connection=new DBConnection();Connection con = connection.getConnection();

				PreparedStatement pst = con
						.prepareStatement("select * from invoice_tax_details  where invoice_no='"
								+  autoinvoice + "'");

				System.out.println(pst);
				ResultSet rs = pst.executeQuery();

			
				while (rs.next()) {

					type.add(rs.getString("type"));
					descrip.add(rs.getString("descrip"));
					qty.add(rs.getString("qty"));
					amt.add(rs.getString("amt"));
					vat_percent.add(rs.getString("vat_percent"));
					tax_amt_percent.add(rs.getString("tax_amt_percent"));
					net_amt.add(rs.getString("net_amt"));
					type_name.add(rs.getString("type_name"));
					rate1.add(rs.getString("igstrate"));
					//rate2.add(rs.getString("sgstrate"));
					myrate.add(rs.getString("rate"));
					gstamt1.add(rs.getString("igstamount"));
					///gstamt2.add(rs.getString("sgstamount"));
					partno.add(rs.getString("partno"));
					partnox.add(rs.getString("partnox"));
					partdate.add(rs.getString("partdate"));
					disc.add(rs.getString("disc"));
					discamt.add(rs.getString("discamt"));
					amtwithdisc.add(rs.getString("amtwithdisc"));
					sparesize++;
				}

				
				
				try{
					//DaoHelper.closeConnection();
				}catch(Exception e){
					
				}
				
				
			} catch (Exception e) {
				
			}
			ib.setSparesize(sparesize);
			ib.setType1(type);
			ib.setDescrip1(descrip);
			ib.setQty1(qty);
			ib.setTax_amt_percent1(tax_amt_percent);
			ib.setAmt112(amt);
			ib.setVat_percent1(vat_percent);
			ib.setNet_amt1(net_amt);
			ib.setType_name1(type_name);
			ib.setMyrate2(myrate);
			ib.setRate1(rate1);
			//ib.setRate2(rate2);
			ib.setGstamt1(gstamt1);
			//ib.setGstamt2(gstamt2);
			ib.setPartno2(partno);
			ib.setPartno2x(partnox);
			ib.setPartdate2(partdate);
			ib.setDisc2(disc);
			ib.setDiscamt2(discamt);
			ib.setAmtwithdisc2(amtwithdisc);
			return ib;
		
		}
		
		
		
		
		
		
		
		
		public invoicebean FetchspareGatepassAssemblyform745Igst(String autoinvoice) {
			
			invoicebean ib = new invoicebean();
			int sparesize = 0;
			List<String> type = new ArrayList<String>();
			List<String> descrip = new ArrayList<String>();
			List<String> qty = new ArrayList<String>();
			List<String> amt = new ArrayList<String>();
			List<String> vat_percent = new ArrayList<String>();
			List<String> tax_amt_percent = new ArrayList<String>();
			List<String> net_amt = new ArrayList<String>();
			List<String> type_name = new ArrayList<String>();
			
			List<String> rate1 = new ArrayList<String>();
			List<String> rate2= new ArrayList<String>();
			List<String> gstamt1 = new ArrayList<String>();
			List<String> gstamt2= new ArrayList<String>();
			List<String> myrate= new ArrayList<String>();
			List<String> partno= new ArrayList<String>();
			List<String> partdate= new ArrayList<String>();
			List<String> partnox= new ArrayList<String>();
			try {
				int sno = 1;

				 DBConnection connection=new DBConnection();Connection con = connection.getConnection();

				PreparedStatement pst = con
						.prepareStatement("select * from invoice_tax_details_sales_return  where invoice_no='"
								+  autoinvoice + "'");

				System.out.println(pst);
				ResultSet rs = pst.executeQuery();

			
				while (rs.next()) {

					type.add(rs.getString("type"));
					descrip.add(rs.getString("descrip"));
					qty.add(rs.getString("qty"));
					amt.add(rs.getString("amt"));
					vat_percent.add(rs.getString("vat_percent"));
					tax_amt_percent.add(rs.getString("tax_amt_percent"));
					net_amt.add(rs.getString("net_amt"));
					type_name.add(rs.getString("type_name"));
					rate1.add(rs.getString("igstrate"));
					//rate2.add(rs.getString("sgstrate"));
					myrate.add(rs.getString("rate"));
					gstamt1.add(rs.getString("igstamount"));
					///gstamt2.add(rs.getString("sgstamount"));
					partno.add(rs.getString("partno"));
					partnox.add(rs.getString("partnox"));
					partdate.add(rs.getString("partdate"));
					sparesize++;
				}

				
				
				try{
					//DaoHelper.closeConnection();
				}catch(Exception e){
					
				}
				
				
			} catch (Exception e) {
				
			}
			ib.setSparesize(sparesize);
			ib.setType1(type);
			ib.setDescrip1(descrip);
			ib.setQty1(qty);
			ib.setTax_amt_percent1(tax_amt_percent);
			ib.setAmt112(amt);
			ib.setVat_percent1(vat_percent);
			ib.setNet_amt1(net_amt);
			ib.setType_name1(type_name);
			ib.setMyrate2(myrate);
			ib.setRate1(rate1);
			//ib.setRate2(rate2);
			ib.setGstamt1(gstamt1);
			//ib.setGstamt2(gstamt2);
			ib.setPartno2(partno);
			ib.setPartno2x(partnox);
			ib.setPartdate2(partdate);
			return ib;
		
		}
		
		
		
		
		
		
		
		public String insertSalesReturn(invoicebean ib) throws SQLException,
		ParseException {
	
	String response="";
	
	 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
	int flag1 = 0;
	
	/*PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
	//System.out.println("preparedStatement112"+preparedStatement112);
ResultSet resultSet12z = preparedStatement112z.executeQuery();

if (resultSet12z.next()) {
	
if(resultSet12z.getString("withstock").equals("yes")){	
	
	for(int mx=0;mx<ib.getDescription1().length;mx++)
	{
		if(ib.getDescription1()[mx] != "" ){		
			
			
			PreparedStatement preparedStatementx=con.prepareStatement("select * from purchase_order_details where descrip=? and invoice_no='"+ib.getPono()+"'   ");	
			preparedStatementx.setString(1, ib.getDescription1()[mx]);
			System.out.println("SQL:"+preparedStatementx);
			ResultSet resultSetx=preparedStatementx.executeQuery();
			if(resultSetx.next())
			{
				int qtyentered=Integer.parseInt(ib.getQuantity1()[mx]);
				int qtyremaining =Integer.parseInt(resultSetx.getString("qtyremaining"));
			if(qtyremaining<qtyentered){
				System.out.println("AAA");
				response="Notsuffqty";
				System.out.println("AAA12");
				flag1=1;
				System.out.println("AAA23");
				//spcode=spcode +"  , "+amc_Bean.getSpare_code()[mx];
				break;
			}
			}else{
				flag1=1;
			}
			
			

		}
	
	}
	System.out.println("Flag Value:"+flag1);
}


}*/
	
	
if(flag1==0)
{
	System.out.println("iinFlag Value:"+flag1);
	int m = 0;
	int j3 = 0;
	int n = 0;
	int invid = 0;
	int k = 0;
	int j = 0;
	
	int v = 0;
	Integer x = 0;
	Integer Y = 0;
	String amcId1 = null;
	
	
	// fiscal year
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
	PreparedStatement preparedStatement11 = con
			.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice_sales_return  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
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
		stringValue1 =  Fyear+"/SR" + "/0000" + stringValue1;

	} else {

		if (String.valueOf(myval1).length() == 1) {
			stringValue1 =  Fyear+"/SR" + "/0000" + String.valueOf(myval1);

		} else if (String.valueOf(myval1).length() == 2) {
			stringValue1 = Fyear+"/SR" + "/000" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 3) {
			stringValue1 =  Fyear+"/SR" + "/00" + String.valueOf(myval1);
		} else if (String.valueOf(myval1).length() == 4) { 
			stringValue1 =  Fyear+"/SR" + "/0" + String.valueOf(myval1);
		}
		else {
			stringValue1 =  Fyear+"/SR" + "/" + String.valueOf(myval1);
		}
	}

	ib.setInvoiceno(stringValue1);
	String query = "";
	PreparedStatement preparedStatement = con
			.prepareStatement("select * from invoice_sales_return where  invoice_no=?");
	String inv = ib.getInvno();
	String inv1 = " " + inv;

	preparedStatement.setString(1, inv1.trim());
	
	ResultSet resultSet = preparedStatement.executeQuery();
	if (resultSet.next()) {
		response = "Already";
		
		
		
		if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {	
			
			
			query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=?";

			inv1=ib.getInvno();
			ib.setInvoiceno(inv1);
			Date d1 = new Date();
			String da = "" + d1;
			
			
			pst9 = con.prepareStatement(query);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(3, ib.getJob_Card_no());
			pst9.setString(21, inv1);
			pst9.setString(4, ib.getTamount());
			pst9.setString(5, ib.getPono());
			pst9.setString(6, ib.getPodate());
			pst9.setString(7, ib.getTermcond());
			pst9.setString(8, ib.getVendor());
			pst9.setString(9, ib.getDcnox());
			pst9.setString(10, ib.getDcdatex());
			
			pst9.setString(11, ib.getTransmode());
			pst9.setString(12, ib.getContactp());
			pst9.setString(13, ib.getContactpno());
			pst9.setString(14, ib.getShipparty());
			pst9.setString(15, ib.getShipadd());
			pst9.setString(16, ib.getShipgstn());
			pst9.setString(17, ib.getShipstate());
			pst9.setString(18, ib.getVehino());
			pst9.setString(19, ib.getFreight());
			pst9.setString(20, ib.getTransport());
			k = pst9.executeUpdate();
			
		}
		else{

		query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=?";

		inv1=ib.getInvno();
		ib.setInvoiceno(inv1);
		Date d1 = new Date();
		String da = "" + d1;
		
		
		pst9 = con.prepareStatement(query);
		pst9.setString(1, ib.getCustomer_Id());
		pst9.setString(32, inv1);
		pst9.setString(18, ib.getPono());
		pst9.setString(19, ib.getPodate());
		pst9.setString(20, ib.getTermcond());
		 pst9.setString(10, inv1);
		pst9.setString(21, ib.getVendor());
		pst9.setString(34, inv);
		pst9.setString(22, ib.getDcnox());
		pst9.setString(23, ib.getDcdatex());
		pst9.setString(24, ib.getTransmode());
		pst9.setString(25, ib.getContactp());
		pst9.setString(26, ib.getContactpno());
		pst9.setString(27, ib.getShipparty());
		pst9.setString(28, ib.getShipadd());
		pst9.setString(29, ib.getShipgstn());
		pst9.setString(30, ib.getShipstate());
		pst9.setString(31, ib.getVehino());
		pst9.setString(32, ib.getFreight());
		pst9.setString(33, ib.getTransport());
		String paid_amt = "";
		String balance_amt = "";
		paid_amt = ib.getPaid_amt();
		balance_amt = ib.getBalance_amt();

		
		
		// CASH
		if (ib.getPaymod().trim().equals("CASH")) {
			pst9.setString(3, "CASH");
		
			String paid_amt1 = "";

			paid_amt1 = ib.getNet_amount();


			pst9.setString(4, paid_amt1);
			pst9.setString(5, "0");
			
			pst9.setString(7, "");
			
			pst9.setString(8, "0");
		
			pst9.setString(9, "");
		
			
			
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setNull(6, java.sql.Types.DATE);
			pst9.setString(11, paid_amt1);
			
			pst9.setString(12, "0");
			pst9.setString(13, "0");
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, "");
			pst9.setString(17, "");
			
				
			k = pst9.executeUpdate();

		}

		else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

			pst9.setString(3, "CHEQUE");
			Integer l = 0;
			String paid_amt2 = "";
			String chek_amt = "";

			//paid_amt2 = ib.getCash_amt();

			chek_amt = ib.getCheque_amt();
			Integer c = 0;
			try {
				l = Integer.valueOf(chek_amt);
			} catch (Exception e) {
				
				l = 0;
			}
			pst9.setString(4, chek_amt);
			pst9.setString(5, "0");

			pst9.setString(7, ib.getCheque_no());
			pst9.setString(8, "0");
			pst9.setString(9, "");

			
			
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
		
			pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

			pst9.setInt(11, 0);
			try {
				c = Integer.valueOf(chek_amt);
			} catch (Exception e) {
				
				c = 0;
			}
			pst9.setString(12, chek_amt);
			pst9.setString(13, "0");
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, ib.getBankname());
			pst9.setString(17, "");
			

			k = pst9.executeUpdate();

		}

		// credit

		else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {

			pst9.setString(3, "CARD");

			String paid_amt2 = "";
			String chek_amt = "";

			paid_amt2 = ib.getNet_amountcard();

			chek_amt = ib.getNet_amountcard();
			Integer c = 0;
			Integer a = 0;
			try {
				a = Integer.valueOf(paid_amt2);
			} catch (Exception e) {
				
				a = 0;
			}
			pst9.setString(4, paid_amt2);
			pst9.setString(5, "0");

			pst9.setString(7, "");
			pst9.setString(8, ib.getCardid());
			pst9.setString(9, "");

			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*
			 * String dateInString=ib.getCheque_date(); Date dNo = new
			 * Date(); dNo = ft.parse(dateInString);
			 */
			Date dNow = new Date();

			
			pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
		
			pst9.setNull(6, java.sql.Types.DATE);

			pst9.setString(11, "0");
			try {
				c = Integer.valueOf(chek_amt);
			} catch (Exception e) {
				
				c = 0;
			}
			pst9.setString(12, "0");
			pst9.setString(13, paid_amt2);
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, "");
			pst9.setString(17, "");
		
			k = pst9.executeUpdate();

		}

		// Insurance
		else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {

			pst9.setString(3, "INSURANCE");

			String paid_amt2 = "";
			String balace = "";
			String chek_amt = "";

			paid_amt2 = ib.getPaid_amt22();

			// chek_amt=ib.getNet_amountcard();
			balace = ib.getBalance_amt22();
			Integer c = 0;
			Integer a = 0;
			try {
				a = Integer.valueOf(paid_amt2);
			} catch (Exception e) {
				
				a = 0;
			}
			pst9.setString(4, paid_amt2);
			try {
				c = Integer.valueOf(balace);
			} catch (Exception e) {
				
				c = 0;
			}
			pst9.setString(5, balace);

			pst9.setString(7, "");
			pst9.setString(8, "0");
			pst9.setString(9, ib.getInsurance());

			DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
			/*
			 * String dateInString=ib.getCheque_date(); Date dNo = new
			 * Date(); dNo = ft.parse(dateInString);
			 */
			

	

			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6, java.sql.Types.DATE);

			pst9.setString(11, paid_amt2);

			pst9.setString(12, "0");
			pst9.setString(13, "0");
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			String d="";
			try{
				d=CoreData.getDateFormatAsDb(ib.getDate22());
				
			}catch (Exception e) {
				
			}
			
			pst9.setString(16, d);
			
			pst9.setString(17, "");
			
			k = pst9.executeUpdate();

		}

		else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
			String paymode="";
			String paid_amt2 = "";
			String balace = "";
			String chek_amt = "";

			paid_amt2 = ib.getPaid_amt();

			if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
			{
				paymode=ib.getR1()+"~"+"CASH";
				pst9.setString(11, paid_amt2);
				pst9.setString(12, "0");
				pst9.setString(13, "0");
			
			}
			else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				paymode=ib.getR1()+"~"+"CHEQUE";
				pst9.setString(12, paid_amt2);
				pst9.setString(11, "0");
				pst9.setString(13, "0");
			}
			else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				paymode=ib.getR1()+"~"+"CARD";
pst9.setString(11,"0");
				
				pst9.setString(12, "0");
				pst9.setString(13, paid_amt2);
				
			}
			else
			{
				paymode=ib.getPaymod();
					pst9.setString(11,"0");
				
				pst9.setString(12, "0");
				pst9.setString(13,"0");
			}
			
			

			pst9.setString(3, paymode);

			
			// chek_amt=ib.getNet_amountcard();
			balace = ib.getBalance_amt();
			Integer c = 0;
			Integer a = 0;
			try {
				a = Integer.valueOf(paid_amt2);
			} catch (Exception e) {
				
				a = 0;
			}
			pst9.setString(4, paid_amt2);
			try {
				c = Integer.valueOf(balace);
			} catch (Exception e) {
				
				c = 0;
			}
			pst9.setString(5, balace);

			pst9.setString(7, "");
			pst9.setString(8, "0");
			pst9.setString(9, "");

			

			pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6, java.sql.Types.DATE);

			/*pst9.setString(11, "0");

			pst9.setString(12, "0");
			pst9.setString(13, "0");*/
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
			
			
			k = pst9.executeUpdate();

		}

		// card and cash

		else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {

			pst9.setString(3, "CARDANDCASH");

			String paid_amt2 = "";
			String balace = "";
			String credit = "";

			paid_amt2 = ib.getCashhh();

			
			// chek_amt=ib.getNet_amountcard();
			credit = ib.getCarddd();
			Integer c = 0;
			Integer a = 0;
			Integer p = 0;
			try {
				a = Integer.valueOf(paid_amt2);
			} catch (Exception e) {
				
				a = 0;
			}

			try {
				c = Integer.valueOf(credit);
			} catch (Exception e) {
				
				c = 0;
			}

			p = (a + c);

			pst9.setString(4,""+p);
			/*
			 * try{ c = Integer.valueOf(balace); }catch (Exception e) { //
			 * TODO: handle exception c=0; }
			 */
			pst9.setString(5, ""+0);

			pst9.setString(7, "");
			pst9.setString(8, ""+ib.getTrandi());
			pst9.setString(9, "");

			

			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst9.setNull(6, java.sql.Types.DATE);

			pst9.setString(11, ""+a);

			pst9.setString(12, ""+0);
			pst9.setString(13, ""+c);
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
		
			k = pst9.executeUpdate();

		}else{
			
			
		
			pst9.setString(3, "");
			
			String paid_amt1 = "";

			paid_amt1 = ib.getNet_amount();


			pst9.setString(4, "0");
			pst9.setString(5, "0");
			
			pst9.setString(7, "");
			
			pst9.setString(8, "0");
		
			pst9.setString(9, "");
		
		
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setNull(6, java.sql.Types.DATE);
			pst9.setString(11, "0");
			
			pst9.setString(12, "0");
			pst9.setString(13, "0");
			pst9.setString(14, ib.getTamount());
			pst9.setString(15, ib.getJob_Card_no());
			pst9.setString(16, "");
			
			pst9.setString(17, "");
		
			
			k = pst9.executeUpdate();

			
			
		}
		
		
}
		
		
		
		
/*
		PreparedStatement preparedStatement1121 = con
				.prepareStatement("update  job_card set job_card_done_status='"
						+ 1 + "' where job_card_no=? ");

		preparedStatement1121.setString(1, ib.getJob_Card_no());

		j = preparedStatement1121.executeUpdate();

			response = "success";
		*/

		// update tax_datails
		response = "success";
		String qd = "delete  from invoice_tax_details_sales_return where invoice_no=?";
		String inv2 = ib.getInvno();
		String inv21 = " " + inv2;
		PreparedStatement pstdel = con.prepareStatement(qd);
		pstdel.setString(1, inv21.trim());

		int n1 = pstdel.executeUpdate();

		int i = 0;
		int l1 = 0;
		String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pst41 = con.prepareStatement(q1);

		for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

			if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
				
				pst41.setString(1, inv21.trim());
				

				String btype = "";

				try {
					btype = ib.getBtype()[j1];
				} catch (Exception e) {
					
					btype = "";
				}
				pst41.setString(2, btype);

				// pst41.setString(2,"labour");

				pst41.setString(3, ib.getDescription1()[j1]);

				Double amount = 0.0;
				double vatpercent = 0.0;
				double taxamount = 0.0;
				double netamount = 0.0;

				String amountlist = ib.getAmount1()[j1];

				String vatpercentlist = ib.getVat1()[j1];

				String taxamountlist = ib.getTaxqmount1()[j1];

				// String qty=ib.getQuantity1()[j1];
				// Integer Quantity1=0;
				String netamountlist = ib.getVatamount1()[j1];

				Double Quantity1 = 0.0;
				try {
					String qty = ib.getQuantity1()[j1];
				
					Quantity1 = Double.parseDouble(qty);
					;
				} catch (Exception e) {
					
					Quantity1 = 0.0;
				}

			
				pst41.setDouble(4, Quantity1);
				

				try {
					amount = Double.parseDouble(amountlist);
				} catch (Exception e) {
					
					amount = 0.0;
				}

				try {
					vatpercent = Double.parseDouble(vatpercentlist);
				} catch (Exception e) {
					
					vatpercent = 0;
				}

				try {
					taxamount = Double.parseDouble(taxamountlist);
				} catch (Exception e) {
					
					taxamount = 0;
				}
				try {
					netamount = Double.parseDouble(netamountlist);
				} catch (Exception e) {
					
					netamount = 0;
				}

				
				pst41.setDouble(5, amount);
				pst41.setDouble(6, vatpercent);

				pst41.setDouble(7, taxamount);
				pst41.setDouble(8, netamount);
				String ttype = "";

				try {
					ttype = ib.getTtype()[j1];
				} catch (Exception e) {
					
					ttype = "";
				}
				pst41.setString(9, ttype);
				
				pst41.setString(10, ib.getGrate1()[j1]);
				pst41.setString(11, ib.getGstamount1()[j1]);
				pst41.setString(12, ib.getGrate2()[j1]);
				pst41.setString(13, ib.getGstamount2()[j1]);
				pst41.setString(14, ib.getMyrate()[j1]);
				pst41.setString(15, ib.getPartno()[j1]);
				pst41.setString(16, ib.getPartdate()[j1]);
				pst41.setString(17, ib.getPartnox()[j1]);
				i = i++;
				String sn = "" + i;

				ib.setSn(sn);

				l1 = pst41.executeUpdate();

			}
			if (l1 > 0 && n1 > 0) {
				response = "success";
			} else {
				response = "fail";

			}

		}

		// --------------

		// update taxcollection details

		String qdtc = "delete  from invoice_tax_collection_sales_return where invoice_no=?";
		String inv23 = ib.getInvno();
		String inv231 = " " + inv23;
		PreparedStatement pstdeltc = con.prepareStatement(qdtc);
		pstdeltc.setString(1, inv231.trim());

		int ntc = pstdeltc.executeUpdate();
		 q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

		 pst41 = con.prepareStatement(q1);
		for (int j1 = 0; j1 < ib.getT().length; j1++) {
			pst41.setString(1, inv231.trim());
			
			String type = "";
			String taxableamount = ib.getA()[j1];
			String tax = ib.getA2()[j1];

			double taxableamount1 = 0.0;
			double tax1 = 0.0;
			// double netamount =0.0;
			try {
				type = ib.getT()[j1];
			} catch (Exception e) {
				
				type = "";
			}

			pst41.setString(2, type);

			try {
				taxableamount1 = Double.parseDouble(taxableamount);
			} catch (Exception e) {
				
				taxableamount1 = 0.0;
			}

			pst41.setDouble(3, taxableamount1);

			try {
				tax1 = Double.parseDouble(tax);
			} catch (Exception e) {
				
				tax1 = 0.0;
			}

			pst41.setDouble(4, tax1);

			

			pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

			int js = pst41.executeUpdate();

			if (js > 0 && ntc > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			// pst41.setString(2,"labour");

		}

		try{
			
				//DaoHelper.closeConnection();
				
			
		}catch(Exception e){}

	}

	else {
		
		
		
		
		
		String query1="INSERT INTO invoice_sales_return(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 pst9=con.prepareStatement(query1);
		pst9.setString(1, ib.getCustomer_Id());
		pst9.setString(10,stringValue1);
		pst9.setString(14, ib.getJob_Card_no());
		pst9.setString(19, ib.getPono());
		pst9.setString(20, CoreData.getDateFormatAsDb(ib.getPodate()));
		pst9.setString(21, ib.getTermcond());
		pst9.setString(22, ib.getVendor());
		pst9.setString(23, ib.getDcnox());
		pst9.setString(24, ib.getDcdatex());
		
		pst9.setString(25, ib.getTransmode());
		pst9.setString(26, ib.getContactp());
		pst9.setString(27, ib.getContactpno());
		pst9.setString(28, ib.getShipparty());
		pst9.setString(29, ib.getShipadd());
		pst9.setString(30, ib.getShipgstn());
		pst9.setString(31, ib.getShipstate());
		pst9.setString(32, ib.getVehino());
		pst9.setString(33, ib.getFreight());
		pst9.setString(34, ib.getTransport());
		pst9.setString(35, "sgst");
		pst9.setString(36, ""+ib.getTamount());
		String paid_amt="";
		String balance_amt="";
		paid_amt=ib.getPaid_amt();
		balance_amt=ib.getBalance_amt();
		
		
		try{
		 x = Integer.valueOf(paid_amt);
		}catch (Exception e) {
			
			x=0;
		}
		try{
		 Y = Integer.valueOf(balance_amt);
		}catch (Exception e) {
			
			Y=0;
		}
		//Integer  pp=Integer.parseInt(paid_amt);
		//Integer  bb=Integer.parseInt(balance_amt);
		
		// CASH
		if(ib.getPaymod().equalsIgnoreCase("CASH"))
		{
		pst9.setString(3, "CASH");
		
		String paid_amt1="";
	
		paid_amt1=ib.getNet_amount();
		
		
		/*try{
			 x = Integer.valueOf(paid_amt1);
			}catch (Exception e) {
				
				x=0;
			}
		*/
				
		pst9.setString(4, paid_amt1);
		pst9.setString(5, ""+0);
		
		pst9.setString(7,"");
		pst9.setInt(8,0);
		pst9.setString(9,"");
		
		pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setNull(6,java.sql.Types.DATE);
		pst9.setString(11,""+ x);
		pst9.setString(12,""+ 0);
		pst9.setString(13, ""+0);
		pst9.setString(15, ""+ib.getTamount());
		pst9.setString(18, "0");
		pst9.setString(16, "");
		
		pst9.setString(17,"");
		
		 k=pst9.executeUpdate();	
		
		}
		
		// CHEQUE
		else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
		{
			
			
			pst9.setString(3, "CHEQUE");
			Integer l=0;
			String paid_amt2="";
			String chek_amt="";
		
			paid_amt2=ib.getCash_amt();
			
		
			chek_amt=ib.getCheque_amt();
			Integer c=0;
			try{
				 l = Integer.valueOf(chek_amt);
				}catch (Exception e) {
					
					l=0;
				}
				pst9.setString(4, ""+l);
				pst9.setString(5, ""+0);
				
				pst9.setString(7,ib.getCheque_no());
				pst9.setString(8,""+0);
				pst9.setString(9,"");
				
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);
				Date dNow = new Date();
			
			
				try{
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				}catch (Exception e) {
					
					pst9.setString(2,null);
				}
				
			
				try{
				pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
				}catch (Exception e) {
					
					pst9.setString(6,null);
				}																																		
				
				pst9.setString(11, ""+0);
				try{
					c = Integer.valueOf(chek_amt);
					}catch (Exception e) {
						
						c=0;
					}
				pst9.setString(12, ""+c);
				pst9.setString(13, ""+0);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, ""+ib.getBankname());
				
				pst9.setString(17, "");
				pst9.setString(18, "0");
				
				 k=pst9.executeUpdate();
			
			}
			
			
			
			//credit
			
		else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
		{
			
			
			pst9.setString(3, "CARD");
			
			String paid_amt2="";
			String chek_amt="";
		
			paid_amt2=ib.getNet_amountcard();
			
		
			chek_amt=ib.getNet_amountcard();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pst9.setString(4, ""+a);
				pst9.setString(5,""+ 0);
				
				pst9.setString(7,"");
				pst9.setString(8,ib.getCardid());
				pst9.setString(9,"");
				
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);*/
				Date dNow = new Date();
			
			
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6,java.sql.Types.DATE);
																																							
				
				pst9.setInt(11, 0);
				try{
					c = Integer.valueOf(chek_amt);
					}catch (Exception e) {
						
						c=0;
					}
				pst9.setString(12,""+ 0);
				pst9.setString(13, ""+a);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
				pst9.setString(18, "0");
				
				 k=pst9.executeUpdate();
			
			}
			
			// Insurance
		else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
		{
			
			
			pst9.setString(3, "INSURANCE");
			
			String paid_amt2="";
			String balace="";
			String chek_amt="";
		
			paid_amt2=ib.getPaid_amt22();
			
			
			//chek_amt=ib.getNet_amountcard();
			balace=ib.getBalance_amt22();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pst9.setString(4, ""+a);
				try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}
				pst9.setString(5,""+ c);
				
				pst9.setString(7,"");
				pst9.setString(8,""+0);
				pst9.setString(9,ib.getInsurance());
				
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);*/
				Date dNow = new Date();
			
			
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6,java.sql.Types.DATE);
																																							
				
				pst9.setString(11, ""+a);
				
				pst9.setString(12, ""+0);
				pst9.setString(13, ""+0);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, "");
				String d=null;
				try{
				 d= CoreData.getDateFormatAsDb(ib.getDate22());
				}catch (Exception e) {
					
					d=null;
				}
				pst9.setString(17, d);
				pst9.setString(18, "0");
				
				 k=pst9.executeUpdate();
			
			}
			
			
			
		else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
		{
			
			String paymode="";
			String paid_amt2 = "";
			String balace = "";
			String chek_amt = "";
			String paycash = "";
			String paycheque = "";
			String paycredit = "";
			paid_amt2 = ib.getPaid_amt();

			if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
			{
				paymode=ib.getR1()+"~"+"CASH";
				pst9.setString(11, paid_amt2);
				pst9.setString(12, "0");
				pst9.setString(13, "0");
			
			}
			else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				paymode=ib.getR1()+"~"+"CHEQUE";
				pst9.setString(12, paid_amt2);
				pst9.setString(11, "0");
				pst9.setString(13, "0");
			}
			else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				paymode=ib.getR1()+"~"+"CARD";
				pst9.setString(11,"0");
				
				pst9.setString(12, "0");
				pst9.setString(13, paid_amt2);
				
			}
			else
			{
				paymode=ib.getPaymod();
					pst9.setString(11,"0");
				
				pst9.setString(12, "0");
				pst9.setString(13,"0");
			}
			

			pst9.setString(3, paymode);		
			
			//chek_amt=ib.getNet_amountcard();
			balace=ib.getBalance_amt();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pst9.setString(4, ""+a);
				try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}
				pst9.setString(5, ""+c);
				
				pst9.setString(7,"");
				pst9.setString(8,""+0);
				pst9.setString(9,"");
				
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);*/
				Date dNow = new Date();
			
				
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
				pst9.setNull(6,java.sql.Types.DATE);
																																							
				
				
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
				pst9.setString(18, "0");
				
				 k=pst9.executeUpdate();
			
			}
			
			
			// card and cash
		
		else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
		{
			
			
			pst9.setString(3, "CARDANDCASH");
			
			String paid_amt2="";
			String balace="";
			String credit="";
		
			paid_amt2=ib.getCashhh();
			
			
			//chek_amt=ib.getNet_amountcard();
			credit=ib.getCarddd();
			Integer c=0;
			Integer a=0;
			Integer p=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				
				try{
					 c = Integer.valueOf(credit);
					}catch (Exception e) {
						
						c=0;
					}
				
				p=(a+c);
				
				pst9.setString(4, ""+p);
				/*try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}*/
				pst9.setString(5, ""+0);
				
				pst9.setString(7,"");
				pst9.setString(8,""+0);
				pst9.setString(9,"");
				
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);*/
				Date dNow = new Date();
			
			
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
				pst9.setNull(6,java.sql.Types.DATE);
																																							
				
				pst9.setString(11,""+paid_amt2);
				
				pst9.setString(12, ""+0);
				pst9.setString(13, ""+credit);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(16, "");
				
				pst9.setString(17, "");
				pst9.setString(18, "0");
				
				 k=pst9.executeUpdate();
			
			}else{
				
				pst9.setString(3, "");
		
					pst9.setString(4, "");
					
					pst9.setString(5, ""+0);
					
					pst9.setString(7,"");
					pst9.setString(8,""+0);
					pst9.setString(9,"");
					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6,java.sql.Types.DATE);
																																								
					
					pst9.setString(11,"");
					
					pst9.setString(12, "");
					pst9.setString(13, "");
					pst9.setString(15, ""+ib.getTamount());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					pst9.setString(18, "0");
				
					 k=pst9.executeUpdate();
				
			}
	
	
		
			///new insertiom
		
		/*PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,total,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstcx9.setString(1,stringValue1);
		
		// CASH
		if(ib.getPaymod().equalsIgnoreCase("CASH"))
		{
			pstcx9.setString(3, "CASH");
		
		String paid_amt1="";
	
		paid_amt1=ib.getNet_amount();
		
		
		try{
			 x = Integer.valueOf(paid_amt1);
			}catch (Exception e) {
				
				x=0;
			}
		
		
		
		
		
		
			pstcx9.setString(2, ""+x);
			pstcx9.setNull(4,java.sql.Types.DATE);
			pstcx9.setString(5, "");
		
			pstcx9.setString(6,"");
			pstcx9.setString(7,"");
			pstcx9.setString(8,""+x);
		
			pstcx9.setString(9,"");
			pstcx9.setString(10,"");
			pstcx9.setString(11, ""+ib.getTamount());
			pstcx9.setString(12,stringValue1);
		
		 v=pstcx9.executeUpdate();	
		
		}
		
		// CHEQUE
		else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
		{
			
			
			pstcx9.setString(3, "CHEQUE");
			Integer l=0;
			String paid_amt2="";
			String chek_amt="";
		
			paid_amt2=ib.getCash_amt();
			
			
			chek_amt=ib.getCheque_amt();
			Integer c=0;
			try{
				 l = Integer.valueOf(chek_amt);
				}catch (Exception e) {
					
					l=0;
				}
				pstcx9.setString(2, ""+l);
			
				
				pstcx9.setString(5,ib.getCheque_no());
				pstcx9.setString(6,"");
				pstcx9.setString(7,"");
				pstcx9.setString(8,"");
			
				pstcx9.setString(9,""+l);
				pstcx9.setString(10,"");
				pstcx9.setString(11, ""+ib.getTamount());
				pstcx9.setString(12,stringValue1);
				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				String dateInString=ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);
				Date dNow = new Date();
			
			
				try{
				pst9.setString(4,CoreData.getDateFormatAsDb(ib.getDate()));
				}catch (Exception e) {
					
					pst9.setString(2,null);
				}
				
			
				try{
					pstcx9.setString(4,CoreData.getDateFormatAsDb(ib.getCheque_date()));
				}catch (Exception e) {
					
					pstcx9.setString(4,null);
				}																																		
				
				
			
				v=pstcx9.executeUpdate();
			
			}
			
			
			
			//credit
			
		else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
		{
			
			
			pstcx9.setString(3, "CARD");
			
			String paid_amt2="";
			String chek_amt="";
		
			paid_amt2=ib.getNet_amountcard();
			
			
			chek_amt=ib.getNet_amountcard();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pstcx9.setString(2, ""+a);
				pstcx9.setNull(4,java.sql.Types.DATE);
				pstcx9.setString(5, "");
			
				pstcx9.setString(6,ib.getCardid());
				pstcx9.setString(7,"");
				pstcx9.setString(8,"");
			
				pstcx9.setString(9,"");
				pstcx9.setString(10,""+a);
				pstcx9.setString(11, ""+ib.getTamount());
				pstcx9.setString(12,stringValue1);
				v=pstcx9.executeUpdate();
			
			}
			
			// Insurance
		else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
		{
			
			
			pstcx9.setString(3, "INSURANCE");
			
			String paid_amt2="";
			String balace="";
			String chek_amt="";
		
			paid_amt2=ib.getPaid_amt22();
			
			
			//chek_amt=ib.getNet_amountcard();
			balace=ib.getBalance_amt22();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pstcx9.setString(2, ""+a);
				try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}
					pstcx9.setNull(4,java.sql.Types.DATE);
					pstcx9.setString(5, "");
				
					pstcx9.setString(6,"");
					pstcx9.setString(7,ib.getInsurance());
					pstcx9.setString(8,"");
				
					pstcx9.setString(9,"");
					pstcx9.setString(10,"");
				
					pstcx9.setString(11, ""+ib.getTamount());
					pstcx9.setString(12,stringValue1);
					
					
				
			
			v=pstcx9.executeUpdate();
			
			}
			
			
			
		else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
		{
			
			
			//pstcx9.setString(3, "PARTPAYMENT");
			String paymode="";
			String paid_amt2="";
			String balace="";
			String chek_amt="";
		
			paid_amt2=ib.getPaid_amt();
			
			
			//chek_amt=ib.getNet_amountcard();
			balace=ib.getBalance_amt();
			Integer c=0;
			Integer a=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				pstcx9.setString(2, ""+a);
				try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}
					
					String ppmode="";
					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pstcx9.setString(8, ""+a);
						pstcx9.setString(9, "0");
						pstcx9.setString(10, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pstcx9.setString(9, ""+a);
						pstcx9.setString(8, "0");
						pstcx9.setString(10, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
						pstcx9.setString(8,"0");
						
						pstcx9.setString(9, "0");
						pstcx9.setString(10, ""+a);
						
					}
					else
					{
						paymode=ib.getPaymod();
						pstcx9.setString(8,"0");
						
						pstcx9.setString(9, "0");
						pstcx9.setString(10,"0");
					}
					

					pstcx9.setString(3, paymode);

	
					pstcx9.setNull(4,java.sql.Types.DATE);
					pstcx9.setString(5, "");
				
					pstcx9.setString(6,"");
					pstcx9.setString(7,"");
					pstcx9.setString(8,"");
				
					pstcx9.setString(9,"");
					pstcx9.setString(10,"");
				
					
					pstcx9.setString(11, ""+ib.getTamount());		
					pstcx9.setString(12,stringValue1);
					
				
			
				v=pstcx9.executeUpdate();
			
			}
			
			
			// card and cash
		
		else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
		{
			
			
			pstcx9.setString(3, "CARDANDCASH");
			
			String paid_amt2="";
			String balace="";
			String credit="";
		
			paid_amt2=ib.getCashhh();
			
			
			//chek_amt=ib.getNet_amountcard();
			credit=ib.getCarddd();
			Integer c=0;
			Integer a=0;
			Integer p=0;
			try{
				 a = Integer.valueOf(paid_amt2);
				}catch (Exception e) {
					
					a=0;
				}
				
				try{
					 c = Integer.valueOf(credit);
					}catch (Exception e) {
						
						c=0;
					}
				
				p=(a+c);
				
				pstcx9.setString(2, ""+a);
				try{
					c = Integer.valueOf(balace);
					}catch (Exception e) {
						
						c=0;
					}
				
				pstcx9.setNull(4,java.sql.Types.DATE);
				pstcx9.setString(5, "");
				
				pstcx9.setString(7,"");
				pstcx9.setString(8,paid_amt2);
				pstcx9.setString(9,"");
				pstcx9.setString(10,credit);
				
				pstcx9.setString(11, ""+ib.getTamount());
				pstcx9.setString(12,stringValue1);
				v=pstcx9.executeUpdate();
			
			}else{
				pstcx9.setString(2, "");
				pstcx9.setString(3, "");
				
				pstcx9.setNull(4,java.sql.Types.DATE);
				pstcx9.setString(5,"");
				pstcx9.setString(6,"");
				pstcx9.setString(7,"");
				pstcx9.setString(8,"");
				pstcx9.setString(9,"");
				pstcx9.setString(10,"");
				
				pstcx9.setString(11, ""+ib.getTamount());
				pstcx9.setString(12,stringValue1);
	
		v= pstcx9.executeUpdate();

		
		
		
		
			}*/
		
		
		
		
		
		// Insert Into Customer Credit Debit Report
		

		String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
		
		pst9=con.prepareStatement(query11);
		pst9.setString(1, ib.getCustomer_Id());
		pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
		pst9.setString(3,stringValue1);
		pst9.setString(4, "Sales Return");
		pst9.setString(5, "101");
		pst9.setString(6, "Credit");
		pst9.setString(7,ib.getTamount());
		pst9.setString(8,ib.getCustomer_name());
		
		System.out.println("SQL:"+pst9);
		 k=pst9.executeUpdate();
			
		 
		 
		 
		// Bill Number Generation For Customer Credit Debit
			
			String stringValue="";
			int len11=0;
			PreparedStatement preparedStatement1x=con.prepareStatement("SELECT * FROM  customercreditdebit");

			ResultSet resultSet1x=preparedStatement1x.executeQuery();
			while(resultSet1x.next()){
				len11++;
			}	

			int size=len11+1;
			stringValue=String.valueOf(size);
			
			 String ap="IP";
			
			
			
			if(stringValue.length()==1)
			{
				stringValue="ICP/"+ap+"/000"+stringValue;
			}
			else if(stringValue.length()==2)
			{
				stringValue="ICP/"+ap+"/00"+stringValue;
			}
			else if(stringValue.length()==3)
			{
				stringValue="ICP/"+ap+"/0"+stringValue;
			}
			else
			{
				stringValue="ICP/"+ap+"/"+stringValue;
			}

			

			ib.setBillno(stringValue);
		 
		 
			
		/* if(!(ib.getPaymod().equals("0")) && !(Double.parseDouble(ib.getNet_amount())<=0))
		 
		// if(!(Integer.parseInt(ib.getPaymod())==0) && !(Double.parseDouble(ib.getNet_amount())<=0))
				
				{
		
			
			 String queryee="INSERT INTO customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
				
				pst99=con.prepareStatement(queryee);
				pst99.setString(1, ib.getCustomer_Id());
				pst99.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst99.setString(3,stringValue);
				pst99.setString(4, "Invoice Payment");
				pst99.setString(5, "201");
				pst99.setString(6, "Credit");
				
				if (ib.getPaymod().trim().equals("CASH")) {
		String paybycash=ib.getNet_amount();

		pst99.setString(7,paybycash );
		
		
		
	
}
else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {
	String paybycash=ib.getCheque_amt();

	pst99.setString(7,paybycash );
			
	
	

}

else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {
	
	String paybycash=ib.getNet_amountcard();

	pst99.setString(7,paybycash );
	
}
	


	else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
		
		String paybycash= ib.getPaid_amt();
		

		if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
		{
		
			pst99.setString(7,paybycash);
			
		
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
		{
			
			
			pst99.setString(7,paybycash);
		
		}
		else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
		{
			
			pst99.setString(7,paybycash);
			
		}
		else
		{
		
			pst99.setString(7,"0");
		}
				
				
			 
				
		} 
				
		pst99.setString(8,ib.getCustomer_name());
				
		System.out.println("SQL:"+pst9);
		k=pst99.executeUpdate();
				
				}*/
				
		//--------------------
			
			
		/*PreparedStatement preparedStatement1121 = con
		.prepareStatement("update  job_card set job_card_done_status='"
				+ 1 + "' where job_card_no=? ");

preparedStatement1121.setString(1, ib.getJob_Card_no());
j = preparedStatement1121.executeUpdate();

if (k > 0 && j > 0 && v>0) {
	response = "success";
} else {
	response = "fail";

}*/

/*try{

	PreparedStatement preparedStatement112 = con.prepareStatement("select * from settings ");
			//System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet resultSet12 = preparedStatement112.executeQuery();

		if (resultSet12.next()) {
			
		if(resultSet12.getString("withstock").equals("yes")){	
			
for (int k2=0;k<ib.getDescription1().length;k2++)
{
	

PreparedStatement ppt = con
		.prepareStatement("select qtyremaining,descrip from purchase_order_details where invoice_no='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

System.out.println("SQL:"+pp);
ResultSet rst = ppt.executeQuery();

while (rst.next()) {
	
String desc=ib.getDescription1()[k2];
String qty=rst.getString("qtyremaining");

String qty1=ib.getQuantity1()[k2];
	
Double qty2=Double.parseDouble(qty)+Double.parseDouble(qty1);

System.out.println("QUantity:"+qty2);

String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and invoice_no='"+ib.getPono()+"'";
	PreparedStatement ps1 = con.prepareStatement(q11);	
	
	
System.out.println("Sql12::"+ps1);

	ps1.executeUpdate();

}

}
		}
		}
}catch(Exception e){
	
	
}*/

		// list insert

		int rr = 0;
		String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement pst41 = con.prepareStatement(q1);
		for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
			if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
			

			pst41.setString(1, stringValue1.trim());

			String btype = "";

			try {
				btype = ib.getBtype()[j1];
			} catch (Exception e) {
				
				btype = "";
			}
			pst41.setString(2, btype);

			// pst41.setString(2,"labour");

			pst41.setString(3, ib.getDescription1()[j1]);

			Double amount = 0.0;
			double vatpercent = 0.0;
			double taxamount = 0.0;
			double netamount = 0.0;

			String amountlist = ib.getAmount1()[j1];

			String vatpercentlist = ib.getVat1()[j1];

			String taxamountlist = ib.getTaxqmount1()[j1];

			String netamountlist = ib.getVatamount1()[j1];

			Double Quantity1 = 0.0;
			try {
				String qty = ib.getQuantity1()[j1];
				
				Quantity1 = Double.parseDouble(qty);
				
			} catch (Exception e) {
				
				Quantity1 = 0.0;
			}

		
			pst41.setDouble(4, Quantity1);

			try {
				amount = Double.parseDouble(amountlist);
			} catch (Exception e) {
				
				amount = 0.0;
			}
			
			try {
				vatpercent = Double.parseDouble(vatpercentlist);
			} catch (Exception e) {
				
				vatpercent = 0;
			}

			try {
				taxamount = Double.parseDouble(taxamountlist);
			} catch (Exception e) {
				
				taxamount = 0;
			}
			try {
				netamount = Double.parseDouble(netamountlist);
			} catch (Exception e) {
				
				netamount = 0;
			}

			
			pst41.setDouble(5, amount);
			pst41.setDouble(6, vatpercent);

			pst41.setDouble(7, taxamount);
			pst41.setDouble(8, netamount);
			String ttype = "";

			try {
				ttype = ib.getTtype()[j1];
			} catch (Exception e) {
				
				ttype = "";
			}
			pst41.setString(9, ttype);
			pst41.setString(10, ib.getGrate1()[j1]);
			pst41.setString(11, ib.getGstamount1()[j1]);
			pst41.setString(12, ib.getGrate2()[j1]);
			pst41.setString(13, ib.getGstamount2()[j1]);
			pst41.setString(14, ib.getMyrate()[j1]);
			pst41.setString(15, ib.getPartno()[j1]);
			pst41.setString(16, ib.getPartdate()[j1]);
			pst41.setString(17, ib.getPartnox()[j1]);
			int l1 = pst41.executeUpdate();

			if (l1 > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			rr = rr + 1;
			;

			String sn = "" + rr;

			ib.setSn(sn);
			}

		}

		// -----------

		// insert to tax collection
		 q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

		 pst41 = con.prepareStatement(q1);
		for (int j1 = 0; j1 < ib.getT().length; j1++) {

			

			pst41.setString(1, stringValue1);

			
			String type = "";
			String taxableamount = ib.getA()[j1];
			String tax = ib.getA2()[j1];

			double taxableamount1 = 0.0;
			double tax1 = 0.0;
			// double netamount =0.0;
			try {
				type = ib.getT()[j1];
			} catch (Exception e) {
				
				type = "";
			}

			pst41.setString(2, type);

			try {
				taxableamount1 = Double.parseDouble(taxableamount);
			} catch (Exception e) {
				
				taxableamount1 = 0.0;
			}

			pst41.setDouble(3, taxableamount1);

			try {
				tax1 = Double.parseDouble(tax);
			} catch (Exception e) {
				
				tax1 = 0.0;
			}

			pst41.setDouble(4, tax1);

			
			pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
		
			
			int js = pst41.executeUpdate();

			if (js > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			// pst41.setString(2,"labour");

		}

	}

	// -----
	
	try{
		
			//DaoHelper.closeConnection();
	
		
	}catch(Exception e){
		
	}
	
}
	
	return response;
}
		
		
		
		
		// Method To Insert Sales Return Of Igst
		
		public String insertSalesReturnIgst(invoicebean ib) throws SQLException,
		ParseException {
	
	String response="";
			
			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
			int flag1 = 0;
			
			/*PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
			//System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet resultSet12z = preparedStatement112z.executeQuery();

		if (resultSet12z.next()) {
			
		if(resultSet12z.getString("withstock").equals("yes")){	
			
			for(int mx=0;mx<ib.getDescription1().length;mx++)
			{
				if(ib.getDescription1()[mx] != "" ){		
					
					
					PreparedStatement preparedStatementx=con.prepareStatement("select * from purchase_order_details where descrip=? and invoice_no='"+ib.getPono()+"'  and qtyremaining <"+ib.getQuantity1()[mx]+" ");	
					preparedStatementx.setString(1, ib.getDescription1()[mx]);
					System.out.println("SQL:"+preparedStatementx);
					ResultSet resultSetx=preparedStatementx.executeQuery();
					if(resultSetx.next())
					{
					
						System.out.println("AAA");
						response="Notsuffqty";
						System.out.println("AAA12");
						flag1=1;
						System.out.println("AAA23");
						//spcode=spcode +"  , "+amc_Bean.getSpare_code()[mx];
						break;
					}
					
					else
					{
						flag1=0;
					}
					
					

				}
			
			}
			System.out.println("Flag Value:"+flag1);
		}
		
		
		}*/
			
			
		if(flag1==0)
		{
			System.out.println("iinFlag Value:"+flag1);
			int m = 0;
			int j3 = 0;
			int n = 0;
			int invid = 0;
			int k = 0;
			int j = 0;
			
			int v = 0;
			Integer x = 0;
			Integer Y = 0;
			String amcId1 = null;
			
			
			// fiscal year
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
			PreparedStatement preparedStatement11 = con
					.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice_sales_return  where LENGTH(invoice_no)>5 and invoice_no  like  ?");
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
				stringValue1 =  Fyear+"/SR" + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 =  Fyear+"/SR" + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = Fyear+"/SR" + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 =  Fyear+"/SR" + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) { 
					stringValue1 =  Fyear+"/SR" + "/0" + String.valueOf(myval1);
				}
				else {
					stringValue1 =  Fyear+"/SR" + "/" + String.valueOf(myval1);
				}
			}

			ib.setInvoiceno(stringValue1);
			String query = "";
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from invoice_sales_return where  invoice_no=?");
			String inv = ib.getInvno();
			String inv1 = " " + inv;

			preparedStatement.setString(1, inv1.trim());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";
				
				
				
				if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {	
					
					
					query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=?";

					inv1=ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;
					
					
					pst9 = con.prepareStatement(query);
					pst9.setString(1, ib.getCustomer_Id());
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setString(3, ib.getJob_Card_no());
					pst9.setString(21, inv1);
					pst9.setString(4, ib.getTamount());
					pst9.setString(5, ib.getPono());
					pst9.setString(6, ib.getPodate());
					pst9.setString(7, ib.getTermcond());
					pst9.setString(8, ib.getVendor());
					pst9.setString(9, ib.getDcnox());
					pst9.setString(10, ib.getDcdatex());
					
					pst9.setString(11, ib.getTransmode());
					pst9.setString(12, ib.getContactp());
					pst9.setString(13, ib.getContactpno());
					pst9.setString(14, ib.getShipparty());
					pst9.setString(15, ib.getShipadd());
					pst9.setString(16, ib.getShipgstn());
					pst9.setString(17, ib.getShipstate());
					pst9.setString(18, ib.getVehino());
					pst9.setString(19, ib.getFreight());
					pst9.setString(20, ib.getTransport());
					k = pst9.executeUpdate();
					
				}
				else{

				query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=?";

				inv1=ib.getInvno();
				ib.setInvoiceno(inv1);
				Date d1 = new Date();
				String da = "" + d1;
				
				
				pst9 = con.prepareStatement(query);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(34, inv1);
				pst9.setString(10, inv1);
				pst9.setString(18, ib.getPono());
				pst9.setString(19, ib.getPodate());
				pst9.setString(20, ib.getTermcond());
				// pst9.setString(2, ib.getPaymod());
				pst9.setString(21, ib.getVendor());
				pst9.setString(22, ib.getDcnox());
				pst9.setString(23, ib.getDcdatex());
				pst9.setString(24, ib.getTransmode());
				pst9.setString(25, ib.getContactp());
				pst9.setString(26, ib.getContactpno());
				pst9.setString(27, ib.getShipparty());
				pst9.setString(28, ib.getShipadd());
				pst9.setString(29, ib.getShipgstn());
				pst9.setString(30, ib.getShipstate());
				pst9.setString(31, ib.getVehino());
				pst9.setString(32, ib.getFreight());
				pst9.setString(33, ib.getTransport());
				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();
		
				
				
				// CASH
				if (ib.getPaymod().trim().equals("CASH")) {
					pst9.setString(3, "CASH");
				
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, paid_amt1);
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, paid_amt1);
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
				
						
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					//paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						l = 0;
					}
					pst9.setString(4, chek_amt);
					pst9.setString(5, "0");

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "0");
					pst9.setString(9, "");

					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, chek_amt);
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, ib.getBankname());
					pst9.setString(17, "");
					

					k = pst9.executeUpdate();

				}

				// credit

				else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {

					pst9.setString(3, "CARD");

					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getNet_amountcard();

					chek_amt = ib.getNet_amountcard();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					pst9.setString(5, "0");

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					
					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "0");
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
					
					k = pst9.executeUpdate();

				}

				// Insurance
				else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {

					pst9.setString(3, "INSURANCE");

					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt22();

					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt22();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					

			

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, paid_amt2);

					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					String d="";
					try{
						d=CoreData.getDateFormatAsDb(ib.getDate22());
						
					}catch (Exception e) {
						
					}
					
					pst9.setString(16, d);
					
					pst9.setString(17, "");
				
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
	pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					
					

					pst9.setString(3, paymode);

					
					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, "");

					

					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					/*pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");*/
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					
					k = pst9.executeUpdate();

				}

				// card and cash

				else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {

					pst9.setString(3, "CARDANDCASH");

					String paid_amt2 = "";
					String balace = "";
					String credit = "";

					paid_amt2 = ib.getCashhh();

					
					// chek_amt=ib.getNet_amountcard();
					credit = ib.getCarddd();
					Integer c = 0;
					Integer a = 0;
					Integer p = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}

					try {
						c = Integer.valueOf(credit);
					} catch (Exception e) {
						
						c = 0;
					}

					p = (a + c);

					pst9.setString(4,""+p);
					/*
					 * try{ c = Integer.valueOf(balace); }catch (Exception e) { //
					 * TODO: handle exception c=0; }
					 */
					pst9.setString(5, ""+0);

					pst9.setString(7, "");
					pst9.setString(8, ""+ib.getTrandi());
					pst9.setString(9, "");

					

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, ""+a);

					pst9.setString(12, ""+0);
					pst9.setString(13, ""+c);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					k = pst9.executeUpdate();

				}else{
					
					
				
					pst9.setString(3, "");
					
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, "0");
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
				
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "0");
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					
					k = pst9.executeUpdate();

					
					
				}
				
				
	}
				
				
				
				
	/*
				PreparedStatement preparedStatement1121 = con
						.prepareStatement("update  job_card set job_card_done_status='"
								+ 1 + "' where job_card_no=? ");

				preparedStatement1121.setString(1, ib.getJob_Card_no());

				j = preparedStatement1121.executeUpdate();

					response = "success";
				*/

				// update tax_datails
				response = "success";
				String qd = "delete  from invoice_tax_details_sales_return where invoice_no=?";
				String inv2 = ib.getInvno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = con.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
						
						pst41.setString(1, inv21.trim());
						

						String btype = "";

						try {
							btype = ib.getBtype()[j1];
						} catch (Exception e) {
							
							btype = "";
						}
						pst41.setString(2, btype);

						// pst41.setString(2,"labour");

						pst41.setString(3, ib.getDescription1()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = ib.getAmount1()[j1];

						String vatpercentlist = ib.getVat1()[j1];

						String taxamountlist = ib.getTaxqmount1()[j1];

						// String qty=ib.getQuantity1()[j1];
						// Integer Quantity1=0;
						String netamountlist = ib.getVatamount1()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = ib.getQuantity1()[j1];
						
							Quantity1 = Double.parseDouble(qty);
							;
						} catch (Exception e) {
							
							Quantity1 = 0.0;
						}

					
						pst41.setDouble(4, Quantity1);
						

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}

						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst41.setDouble(5, amount);
						pst41.setDouble(6, vatpercent);

						pst41.setDouble(7, taxamount);
						pst41.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = ib.getTtype()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst41.setString(9, ttype);
						
						pst41.setString(10, ib.getGrate1()[j1]);
						pst41.setString(11, ib.getGstamount1()[j1]);
						pst41.setString(12, ib.getGrate2()[j1]);
						pst41.setString(13, ib.getGstamount2()[j1]);
						pst41.setString(14, ib.getMyrate()[j1]);
						pst41.setString(15, ib.getPartno()[j1]);
						pst41.setString(16, ib.getPartdate()[j1]);
						pst41.setString(17, ib.getPartnox()[j1]);
						
						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}
					if (l1 > 0 && n1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}

				}

				// --------------

				// update taxcollection details

				String qdtc = "delete  from invoice_tax_collection_sales_return where invoice_no=?";
				String inv23 = ib.getInvno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = con.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				 q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {
					pst41.setString(1, inv231.trim());
					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					

					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

					int js = pst41.executeUpdate();

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

				try{
					
						//DaoHelper.closeConnection();
						
					
				}catch(Exception e){}

			}

			else {
				
				
				
				
				
				String query1="INSERT INTO invoice_sales_return(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 pst9=con.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10,stringValue1);
				pst9.setString(14, ib.getJob_Card_no());
				pst9.setString(19, ib.getPono());
				pst9.setString(20, CoreData.getDateFormatAsDb(ib.getPodate()));
				pst9.setString(21, ib.getTermcond());
				pst9.setString(22, ib.getVendor());
				pst9.setString(23, ib.getDcnox());
				pst9.setString(24, ib.getDcdatex());
				
				pst9.setString(25, ib.getTransmode());
				pst9.setString(26, ib.getContactp());
				pst9.setString(27, ib.getContactpno());
				pst9.setString(28, ib.getShipparty());
				pst9.setString(29, ib.getShipadd());
				pst9.setString(30, ib.getShipgstn());
				pst9.setString(31, ib.getShipstate());
				pst9.setString(32, ib.getVehino());
				pst9.setString(33, ib.getFreight());
				pst9.setString(34, ib.getTransport());
				pst9.setString(35, "igst");
				pst9.setString(36, ""+ib.getTamount());
				String paid_amt="";
				String balance_amt="";
				paid_amt=ib.getPaid_amt();
				balance_amt=ib.getBalance_amt();
				
				
				try{
				 x = Integer.valueOf(paid_amt);
				}catch (Exception e) {
					
					x=0;
				}
				try{
				 Y = Integer.valueOf(balance_amt);
				}catch (Exception e) {
					
					Y=0;
				}
				//Integer  pp=Integer.parseInt(paid_amt);
				//Integer  bb=Integer.parseInt(balance_amt);
				
				// CASH
				if(ib.getPaymod().equalsIgnoreCase("CASH"))
				{
				pst9.setString(3, "CASH");
				
				String paid_amt1="";
			
				paid_amt1=ib.getNet_amount();
				
				
				try{
					 x = Integer.valueOf(paid_amt1);
					}catch (Exception e) {
						
						x=0;
					}
				
						
				pst9.setString(4, ""+x);
				pst9.setString(5, ""+0);
				
				pst9.setString(7,"");
				pst9.setInt(8,0);
				pst9.setString(9,"");
				
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6,java.sql.Types.DATE);
				pst9.setString(11,""+ x);
				pst9.setString(12,""+ 0);
				pst9.setString(13, ""+0);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");
				
				pst9.setString(17,"");
				
				 k=pst9.executeUpdate();	
				
				}
				
				// CHEQUE
				else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				{
					
					
					pst9.setString(3, "CHEQUE");
					Integer l=0;
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getCash_amt();
					
				
					chek_amt=ib.getCheque_amt();
					Integer c=0;
					try{
						 l = Integer.valueOf(chek_amt);
						}catch (Exception e) {
							
							l=0;
						}
						pst9.setString(4, ""+l);
						pst9.setString(5, ""+0);
						
						pst9.setString(7,ib.getCheque_no());
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						try{
						pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
						}catch (Exception e) {
							
							pst9.setString(2,null);
						}
						
					
						try{
						pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
						}catch (Exception e) {
							
							pst9.setString(6,null);
						}																																		
						
						pst9.setString(11, ""+0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12, ""+c);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, ""+ib.getBankname());
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					
					//credit
					
				else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
				{
					
					
					pst9.setString(3, "CARD");
					
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getNet_amountcard();
					
				
					chek_amt=ib.getNet_amountcard();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						pst9.setString(5,""+ 0);
						
						pst9.setString(7,"");
						pst9.setString(8,ib.getCardid());
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setInt(11, 0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12,""+ 0);
						pst9.setString(13, ""+a);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					// Insurance
				else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
				{
					
					
					pst9.setString(3, "INSURANCE");
					
					String paid_amt2="";
					String balace="";
					String chek_amt="";
				
					paid_amt2=ib.getPaid_amt22();
					
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt22();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5,""+ c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,ib.getInsurance());
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11, ""+a);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						String d=null;
						try{
						 d= CoreData.getDateFormatAsDb(ib.getDate22());
						}catch (Exception e) {
							
							d=null;
						}
						pst9.setString(17, d);
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					
				else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
				{
					
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
						pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					

					pst9.setString(3, paymode);		
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5, ""+c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
						
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					// card and cash
				
				else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
				{
					
					
					pst9.setString(3, "CARDANDCASH");
					
					String paid_amt2="";
					String balace="";
					String credit="";
				
					paid_amt2=ib.getCashhh();
					
					
					//chek_amt=ib.getNet_amountcard();
					credit=ib.getCarddd();
					Integer c=0;
					Integer a=0;
					Integer p=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						
						try{
							 c = Integer.valueOf(credit);
							}catch (Exception e) {
								
								c=0;
							}
						
						p=(a+c);
						
						pst9.setString(4, ""+p);
						/*try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}*/
						pst9.setString(5, ""+0);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						/*String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);*/
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11,""+paid_amt2);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+credit);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}else{
						
						pst9.setString(3, "");
				
							pst9.setString(4, "");
							
							pst9.setString(5, ""+0);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setString(11,"");
							
							pst9.setString(12, "");
							pst9.setString(13, "");
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
						
							 k=pst9.executeUpdate();
						
					}
			
				
				
				
				
				
				
				
				
				
				
				
					///new insertiom
				
				/*PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,total,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?)");
				
				pstcx9.setString(1,stringValue1);
				
				// CASH
				if(ib.getPaymod().equalsIgnoreCase("CASH"))
				{
					pstcx9.setString(3, "CASH");
				
				String paid_amt1="";
			
				paid_amt1=ib.getNet_amount();
				
				
				try{
					 x = Integer.valueOf(paid_amt1);
					}catch (Exception e) {
						
						x=0;
					}
				
				
				
				
				
				
					pstcx9.setString(2, ""+x);
					pstcx9.setNull(4,java.sql.Types.DATE);
					pstcx9.setString(5, "");
				
					pstcx9.setString(6,"");
					pstcx9.setString(7,"");
					pstcx9.setString(8,""+x);
				
					pstcx9.setString(9,"");
					pstcx9.setString(10,"");
					pstcx9.setString(11, ""+ib.getTamount());
					pstcx9.setString(12,stringValue1);
				
				 v=pstcx9.executeUpdate();	
				
				}
				
				// CHEQUE
				else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				{
					
					
					pstcx9.setString(3, "CHEQUE");
					Integer l=0;
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getCash_amt();
					
					
					chek_amt=ib.getCheque_amt();
					Integer c=0;
					try{
						 l = Integer.valueOf(chek_amt);
						}catch (Exception e) {
							
							l=0;
						}
						pstcx9.setString(2, ""+l);
					
						
						pstcx9.setString(5,ib.getCheque_no());
						pstcx9.setString(6,"");
						pstcx9.setString(7,"");
						pstcx9.setString(8,"");
					
						pstcx9.setString(9,""+l);
						pstcx9.setString(10,"");
						pstcx9.setString(11, ""+ib.getTamount());
						pstcx9.setString(12,stringValue1);
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						try{
						pst9.setString(4,CoreData.getDateFormatAsDb(ib.getDate()));
						}catch (Exception e) {
							
							pst9.setString(2,null);
						}
						
					
						try{
							pstcx9.setString(4,CoreData.getDateFormatAsDb(ib.getCheque_date()));
						}catch (Exception e) {
							
							pstcx9.setString(4,null);
						}																																		
						
						
					
						v=pstcx9.executeUpdate();
					
					}
					
					
					
					//credit
					
				else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
				{
					
					
					pstcx9.setString(3, "CARD");
					
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getNet_amountcard();
					
					
					chek_amt=ib.getNet_amountcard();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pstcx9.setString(2, ""+a);
						pstcx9.setNull(4,java.sql.Types.DATE);
						pstcx9.setString(5, "");
					
						pstcx9.setString(6,ib.getCardid());
						pstcx9.setString(7,"");
						pstcx9.setString(8,"");
					
						pstcx9.setString(9,"");
						pstcx9.setString(10,""+a);
						pstcx9.setString(11, ""+ib.getTamount());
						pstcx9.setString(12,stringValue1);
						v=pstcx9.executeUpdate();
					
					}
					
					// Insurance
				else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
				{
					
					
					pstcx9.setString(3, "INSURANCE");
					
					String paid_amt2="";
					String balace="";
					String chek_amt="";
				
					paid_amt2=ib.getPaid_amt22();
					
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt22();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pstcx9.setString(2, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
							pstcx9.setNull(4,java.sql.Types.DATE);
							pstcx9.setString(5, "");
						
							pstcx9.setString(6,"");
							pstcx9.setString(7,ib.getInsurance());
							pstcx9.setString(8,"");
						
							pstcx9.setString(9,"");
							pstcx9.setString(10,"");
						
							pstcx9.setString(11, ""+ib.getTamount());
							pstcx9.setString(12,stringValue1);
							
							
						
					
					v=pstcx9.executeUpdate();
					
					}
					
					
					
				else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
				{
					
					
					//pstcx9.setString(3, "PARTPAYMENT");
					String paymode="";
					String paid_amt2="";
					String balace="";
					String chek_amt="";
				
					paid_amt2=ib.getPaid_amt();
					
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pstcx9.setString(2, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
							
							String ppmode="";
							if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
							{
								paymode=ib.getR1()+"~"+"CASH";
								pstcx9.setString(8, ""+a);
								pstcx9.setString(9, "0");
								pstcx9.setString(10, "0");
							
							}
							else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
							{
								
								paymode=ib.getR1()+"~"+"CHEQUE";
								pstcx9.setString(9, ""+a);
								pstcx9.setString(8, "0");
								pstcx9.setString(10, "0");
							}
							else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
							{
								paymode=ib.getR1()+"~"+"CARD";
								pstcx9.setString(8,"0");
								
								pstcx9.setString(9, "0");
								pstcx9.setString(10, ""+a);
								
							}
							else
							{
								paymode=ib.getPaymod();
								pstcx9.setString(8,"0");
								
								pstcx9.setString(9, "0");
								pstcx9.setString(10,"0");
							}
							

							pstcx9.setString(3, paymode);

			
							pstcx9.setNull(4,java.sql.Types.DATE);
							pstcx9.setString(5, "");
						
							pstcx9.setString(6,"");
							pstcx9.setString(7,"");
							pstcx9.setString(8,"");
						
							pstcx9.setString(9,"");
							pstcx9.setString(10,"");
						
							
							pstcx9.setString(11, ""+ib.getTamount());		
							pstcx9.setString(12,stringValue1);
							
						
					
						v=pstcx9.executeUpdate();
					
					}
					
					
					// card and cash
				
				else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
				{
					
					
					pstcx9.setString(3, "CARDANDCASH");
					
					String paid_amt2="";
					String balace="";
					String credit="";
				
					paid_amt2=ib.getCashhh();
					
					
					//chek_amt=ib.getNet_amountcard();
					credit=ib.getCarddd();
					Integer c=0;
					Integer a=0;
					Integer p=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						
						try{
							 c = Integer.valueOf(credit);
							}catch (Exception e) {
								
								c=0;
							}
						
						p=(a+c);
						
						pstcx9.setString(2, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						
						pstcx9.setNull(4,java.sql.Types.DATE);
						pstcx9.setString(5, "");
						
						pstcx9.setString(7,"");
						pstcx9.setString(8,paid_amt2);
						pstcx9.setString(9,"");
						pstcx9.setString(10,credit);
						
						pstcx9.setString(11, ""+ib.getTamount());
						pstcx9.setString(12,stringValue1);
						v=pstcx9.executeUpdate();
					
					}else{
						pstcx9.setString(2, "");
						pstcx9.setString(3, "");
						
						pstcx9.setNull(4,java.sql.Types.DATE);
						pstcx9.setString(5,"");
						pstcx9.setString(6,"");
						pstcx9.setString(7,"");
						pstcx9.setString(8,"");
						pstcx9.setString(9,"");
						pstcx9.setString(10,"");
						
						pstcx9.setString(11, ""+ib.getTamount());
						pstcx9.setString(12,stringValue1);
			
				v= pstcx9.executeUpdate();

				
				
				
				
					}
*/				
				
				
				
				
				// Insert Into Customer Credit Debit Report
				
		
				String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
				
				pst9=con.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3,stringValue1);
				pst9.setString(4, "Sales Return");
				pst9.setString(5, "101");
				pst9.setString(6, "Credit");
				pst9.setString(7,ib.getTamount());
				
				
				pst9.setString(8,ib.getCustomer_name());
				
				System.out.println("SQL:"+pst9);
				 k=pst9.executeUpdate();
					
				 
				 
				 
				// Bill Number Generation For Customer Credit Debit
					
					String stringValue="";
					int len11=0;
					PreparedStatement preparedStatement1x=con.prepareStatement("SELECT * FROM  customercreditdebit");

					ResultSet resultSet1x=preparedStatement1x.executeQuery();
					while(resultSet1x.next()){
						len11++;
					}	

					int size=len11+1;
					stringValue=String.valueOf(size);
					
					 String ap="IP";
					
					
					
					if(stringValue.length()==1)
					{
						stringValue="ICP/"+ap+"/000"+stringValue;
					}
					else if(stringValue.length()==2)
					{
						stringValue="ICP/"+ap+"/00"+stringValue;
					}
					else if(stringValue.length()==3)
					{
						stringValue="ICP/"+ap+"/0"+stringValue;
					}
					else
					{
						stringValue="ICP/"+ap+"/"+stringValue;
					}

					

					ib.setBillno(stringValue);
				 
				 
					
				 /*if(!(ib.getPaymod().equals("0")) && !(Double.parseDouble(ib.getNet_amount())<=0))
				 
				// if(!(Integer.parseInt(ib.getPaymod())==0) && !(Double.parseDouble(ib.getNet_amount())<=0))
						
						{
				
					
					 String queryee="INSERT INTO customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
						
						pst99=con.prepareStatement(queryee);
						pst99.setString(1, ib.getCustomer_Id());
						pst99.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
						pst99.setString(3,stringValue);
						pst99.setString(4, "Invoice Payment");
						pst99.setString(5, "201");
						pst99.setString(6, "Credit");
						
						if (ib.getPaymod().trim().equals("CASH")) {
						
				String paybycash=ib.getNet_amount();

				pst99.setString(7,paybycash );
				
				
				
			
		}
		else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {
			String paybycash=ib.getCheque_amt();
		
			pst99.setString(7,paybycash );
					
			
			
		
		}
		
		else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {
			
			String paybycash=ib.getNet_amountcard();
		
			pst99.setString(7,paybycash );
			
		}
			

		
			else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
				
				String paybycash= ib.getPaid_amt();
				
		
				if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
				{
				
					pst99.setString(7,paybycash);
					
				
				}
				else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
				{
					
					
					pst99.setString(7,paybycash);
				
				}
				else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
				{
					
					pst99.setString(7,paybycash);
					
				}
				else
				{
				
					pst99.setString(7,"0");
				}
						
						
					 
						
				} 
						
				pst99.setString(8,ib.getCustomer_name());
						
				System.out.println("SQL:"+pst9);
				k=pst99.executeUpdate();
						
						}
						
				//--------------------
					
					
				PreparedStatement preparedStatement1121 = con
				.prepareStatement("update  job_card set job_card_done_status='"
						+ 1 + "' where job_card_no=? ");

		preparedStatement1121.setString(1, ib.getJob_Card_no());
		j = preparedStatement1121.executeUpdate();

		if (k > 0 && j > 0 && v>0) {
			response = "success";
		} else {
			response = "fail";

		}*/
		
		/*PreparedStatement preparedStatement112z1 = con.prepareStatement("select * from settings ");
		//System.out.println("preparedStatement112"+preparedStatement112);
	ResultSet resultSet12z1 = preparedStatement112z1.executeQuery();

	if (resultSet12z1.next()) {
		
	if(resultSet12z1.getString("withstock").equals("yes")){	
		
		for (int k2=0;k<ib.getDescription1().length;k2++)
		{
			
		
		PreparedStatement ppt = con
				.prepareStatement("select * from purchase_order_details where invoice_no='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

		System.out.println("SQL:"+pp);
		ResultSet rst = ppt.executeQuery();

		while (rst.next()) {
			
		String desc=ib.getDescription1()[k2];
		String qty=rst.getString("qtyremaining");
		
		String qty1=ib.getQuantity1()[k2];
			
		Double qty2=Double.parseDouble(qty)+Double.parseDouble(qty1);
		
		System.out.println("QUantity:"+qty2);
		
		String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and invoice_no='"+ib.getPono()+"'";
	   	PreparedStatement ps1 = con.prepareStatement(q11);	
	   	
	   	
	 System.out.println("Sql12::"+ps1);
		
	   	ps1.executeUpdate();
		
		}
		
		}
	}
	}*/
		

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
					

					pst41.setString(1, stringValue1.trim());

					String btype = "";

					try {
						btype = ib.getBtype()[j1];
					} catch (Exception e) {
						
						btype = "";
					}
					pst41.setString(2, btype);

					// pst41.setString(2,"labour");

					pst41.setString(3, ib.getDescription1()[j1]);

					Double amount = 0.0;
					double vatpercent = 0.0;
					double taxamount = 0.0;
					double netamount = 0.0;

					String amountlist = ib.getAmount1()[j1];

					String vatpercentlist = ib.getVat1()[j1];

					String taxamountlist = ib.getTaxqmount1()[j1];

					String netamountlist = ib.getVatamount1()[j1];

					Double Quantity1 = 0.0;
					try {
						String qty = ib.getQuantity1()[j1];
						
						Quantity1 = Double.parseDouble(qty);
						
					} catch (Exception e) {
						
						Quantity1 = 0.0;
					}

				
					pst41.setDouble(4, Quantity1);

					try {
						amount = Double.parseDouble(amountlist);
					} catch (Exception e) {
						
						amount = 0.0;
					}
					
					try {
						vatpercent = Double.parseDouble(vatpercentlist);
					} catch (Exception e) {
						
						vatpercent = 0;
					}

					try {
						taxamount = Double.parseDouble(taxamountlist);
					} catch (Exception e) {
						
						taxamount = 0;
					}
					try {
						netamount = Double.parseDouble(netamountlist);
					} catch (Exception e) {
						
						netamount = 0;
					}

					
					pst41.setDouble(5, amount);
					pst41.setDouble(6, vatpercent);

					pst41.setDouble(7, taxamount);
					pst41.setDouble(8, netamount);
					String ttype = "";

					try {
						ttype = ib.getTtype()[j1];
					} catch (Exception e) {
						
						ttype = "";
					}
					pst41.setString(9, ttype);
					pst41.setString(10, ib.getGrate1()[j1]);
					pst41.setString(11, ib.getGstamount1()[j1]);
					pst41.setString(12, ib.getGrate2()[j1]);
					pst41.setString(13, ib.getGstamount2()[j1]);
					pst41.setString(14, ib.getMyrate()[j1]);
					pst41.setString(15, ib.getPartno()[j1]);
					pst41.setString(16, ib.getPartdate()[j1]);
					pst41.setString(17, ib.getPartnox()[j1]);
					
					int l1 = pst41.executeUpdate();

					if (l1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					rr = rr + 1;
					;

					String sn = "" + rr;

					ib.setSn(sn);
					}

				}

				// -----------

				// insert to tax collection
				 q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {

					

					pst41.setString(1, stringValue1);

					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					
					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
				
					
					int js = pst41.executeUpdate();

					if (js > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

			}

			// -----
			
			try{
				
					//DaoHelper.closeConnection();
			
				
			}catch(Exception e){
				
			}
			
		}
			
			return response;
	}











		public String insertCustomerInfowotax(com.master.model.invoicebean ib) throws SQLException, ParseException {
			// TODO Auto-generated method stub

			
			String response="";
			
			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
			int flag1 = 0;
			
			PreparedStatement preparedStatement112z = con.prepareStatement("select * from settings ");
			//System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet resultSet12z = preparedStatement112z.executeQuery();

		if (resultSet12z.next()) {
			
		if(resultSet12z.getString("po").equals("yes")){	
			
			for(int mx=0;mx<ib.getDescription1().length;mx++)
			{
				if(ib.getDescription1()[mx] != "" ){		
					
					Double qtyremaining=0.0;
					PreparedStatement preparedStatementx=con.prepareStatement("select * from purchase_order_details where descrip=? and pono='"+ib.getPono()+"'   ");	
					preparedStatementx.setString(1, ib.getDescription1()[mx]);
					System.out.println("SQL:"+preparedStatementx);
					ResultSet resultSetx=preparedStatementx.executeQuery();
					if(resultSetx.next())
					{
						Double qtyentered=Double.parseDouble(ib.getQuantity1()[mx]);
						
						try{
						 qtyremaining =Double.parseDouble(resultSetx.getString("qtyremaining"));
						} catch (Exception e) {
							qtyremaining=0.0;
						}
						System.out.println(qtyremaining+">>>>"+qtyentered);
						
					if(qtyremaining<qtyentered){
						System.out.println("AAA");
						response="Notsuffqty";
						System.out.println("AAA12");
						flag1=1;
						System.out.println("AAA23");
						break;
					}
					}else{
						flag1=1;
					}
					
					
					
					

				}
			
			}
			System.out.println("Flag Value:"+flag1);
		}
		
		
		}
			
			
		if(flag1==0)
		{
			System.out.println("iinFlag Value:"+flag1);
			int m = 0;
			int j3 = 0;
			int n = 0;
			int invid = 0;
			int k = 0;
			int j = 0;
			
			int v = 0;
			Integer x = 0;
			Integer Y = 0;
			String amcId1 = null;
			
			
			// fiscal year
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
		        


			

			String pref = "";

			PreparedStatement pst9 = null;
			PreparedStatement pst99 = null;

			// String pref="INV";
			PreparedStatement preparedStatement11 = con
					.prepareStatement("select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and wotax='yes' and invoice_no  like  ?");
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
				stringValue1 =  Fyear + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 =  Fyear + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = Fyear + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 =  Fyear + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) { 
					stringValue1 =  Fyear + "/0" + String.valueOf(myval1);
				}
				else {
					stringValue1 =  Fyear + "/" + String.valueOf(myval1);
				}
			}

			ib.setInvoiceno(stringValue1);
			String query = "";
			PreparedStatement preparedStatement = con
					.prepareStatement("select * from invoice where  invoice_no=?");
			String inv = ib.getInvno();
			String inv1 = " " + inv;
	System.out.println(preparedStatement);
			preparedStatement.setString(1, inv1.trim());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";
				
				PreparedStatement pst1 = con.prepareStatement(
						"select * from customer_payment_details where invoiceno='"+inv1.trim()+"'");
				System.out.println("pst........." + pst1);
				ResultSet rs1 = pst1.executeQuery();
				if (rs1.next()) {
					
					
				}else{
				

				
				
				if (ib.getPaymod()==null  || ib.getPaymod().equals("")) {	
					
					
					query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

					inv1=ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;
					
					
					pst9 = con.prepareStatement(query);
					pst9.setString(1, ib.getCustomer_Id());
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setString(3, ib.getJob_Card_no());
					pst9.setString(25, inv1);
					pst9.setString(4, ib.getTamount());
					pst9.setString(5, ib.getPono());
					pst9.setString(6, ib.getPodate());
					pst9.setString(7, ib.getTermcond());
					pst9.setString(8, ib.getVendor());
					pst9.setString(9, ib.getDcnox());
					pst9.setString(10, ib.getDcdatex());
					
					pst9.setString(11, ib.getTransmode());
					pst9.setString(12, ib.getContactp());
					pst9.setString(13, ib.getContactpno());
					pst9.setString(14, ib.getShipparty());
					pst9.setString(15, ib.getShipadd());
					pst9.setString(16, ib.getShipgstn());
					pst9.setString(17, ib.getShipstate());
					pst9.setString(18, ib.getVehino());
					pst9.setString(19, ib.getFreight());
					pst9.setString(20, ib.getTransport());
					pst9.setString(21, ib.getA2()[0]);
					pst9.setString(22, ib.getA2()[1]);
					pst9.setString(23, ib.getA2()[2]);
					pst9.setString(24, ib.getTamount());
					k = pst9.executeUpdate();
					
				}
				else{

				query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=?";

				inv1=ib.getInvno();
				ib.setInvoiceno(inv1);
				Date d1 = new Date();
				String da = "" + d1;
				
				
				pst9 = con.prepareStatement(query);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(32, inv1);
				pst9.setString(18, ib.getPono());
				pst9.setString(19, ib.getPodate());
				pst9.setString(20, ib.getTermcond());
				 pst9.setString(38, inv1);
				pst9.setString(21, ib.getVendor());
				pst9.setString(34, inv);
				pst9.setString(22, ib.getDcnox());
				pst9.setString(23, ib.getDcdatex());
				pst9.setString(24, ib.getTransmode());
				pst9.setString(25, ib.getContactp());
				pst9.setString(26, ib.getContactpno());
				pst9.setString(27, ib.getShipparty());
				pst9.setString(28, ib.getShipadd());
				pst9.setString(29, ib.getShipgstn());
				pst9.setString(30, ib.getShipstate());
				pst9.setString(31, ib.getVehino());
				pst9.setString(32, ib.getFreight());
				pst9.setString(33, ib.getTransport());
				pst9.setString(34, ib.getA2()[0]);
				pst9.setString(35, ib.getA2()[1]);
				pst9.setString(36, ib.getA2()[2]);
				pst9.setString(37, ib.getTamount());
				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();
		
				
				
				// CASH
				if (ib.getPaymod().trim().equals("CASH")) {
					pst9.setString(3, "CASH");
				
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, paid_amt1);
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, paid_amt1);
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
					
						
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					//paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						l = 0;
					}
					pst9.setString(4, chek_amt);
					pst9.setString(5, "0");

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "0");
					pst9.setString(9, "");

					
					
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, chek_amt);
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, ib.getBankname());
					pst9.setString(17, "");
					

					k = pst9.executeUpdate();

				}

				// credit

				else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {

					pst9.setString(3, "CARD");

					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getNet_amountcard();

					chek_amt = ib.getNet_amountcard();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					pst9.setString(5, "0");

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					
					
					 
					Date dNow = new Date();

					
					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "0");
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					pst9.setString(17, "");
				
					k = pst9.executeUpdate();

				}

				// Insurance
				else if (ib.getPaymod().equalsIgnoreCase("INSURANCE")) {

					pst9.setString(3, "INSURANCE");

					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt22();

					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt22();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					
					
					 
					

			

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, paid_amt2);

					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					String d="";
					try{
						d=CoreData.getDateFormatAsDb(ib.getDate22());
						
					}catch (Exception e) {
						
					}
					
					pst9.setString(16, d);
					
					pst9.setString(17, "");
					
					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";

					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
	pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					
					

					pst9.setString(3, paymode);

					
					// chek_amt=ib.getNet_amountcard();
					balace = ib.getBalance_amt();
					Integer c = 0;
					Integer a = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}
					pst9.setString(4, paid_amt2);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {
						
						c = 0;
					}
					pst9.setString(5, balace);

					pst9.setString(7, "");
					pst9.setString(8, "0");
					pst9.setString(9, "");

					

					pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
					
					
					k = pst9.executeUpdate();

				}

				// card and cash

				else if (ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {

					pst9.setString(3, "CARDANDCASH");

					String paid_amt2 = "";
					String balace = "";
					String credit = "";

					paid_amt2 = ib.getCashhh();

					
					// chek_amt=ib.getNet_amountcard();
					credit = ib.getCarddd();
					Integer c = 0;
					Integer a = 0;
					Integer p = 0;
					try {
						a = Integer.valueOf(paid_amt2);
					} catch (Exception e) {
						
						a = 0;
					}

					try {
						c = Integer.valueOf(credit);
					} catch (Exception e) {
						
						c = 0;
					}

					p = (a + c);

					pst9.setString(4,""+p);
					
					
					 
					pst9.setString(5, ""+0);

					pst9.setString(7, "");
					pst9.setString(8, ""+ib.getTrandi());
					pst9.setString(9, "");

					

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, ""+a);

					pst9.setString(12, ""+0);
					pst9.setString(13, ""+c);
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
				
					k = pst9.executeUpdate();

				}else{
					
					
				
					pst9.setString(3, "");
					
					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();


					pst9.setString(4, "0");
					pst9.setString(5, "0");
					
					pst9.setString(7, "");
					
					pst9.setString(8, "0");
				
					pst9.setString(9, "");
				
				
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "0");
					
					pst9.setString(12, "0");
					pst9.setString(13, "0");
					pst9.setString(14, ib.getTamount());
					pst9.setString(15, ib.getJob_Card_no());
					pst9.setString(16, "");
					
					pst9.setString(17, "");
				
					
					k = pst9.executeUpdate();

					
					
				}
				
				
	}
				
				
				
				
				
	
				PreparedStatement preparedStatement1121 = con
						.prepareStatement("update  job_card set job_card_done_status='"
								+ 1 + "' where job_card_no=? ");

				preparedStatement1121.setString(1, ib.getJob_Card_no());

				j = preparedStatement1121.executeUpdate();

					response = "success";
				

				// update tax_datails
				response = "success";
				
				
				
				
				
				
				
				String qd = "delete  from invoice_tax_details where invoice_no=?";
				String inv2 = ib.getInvno();
				 String inv21 = " " + inv2;
				PreparedStatement pstdel = con.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
						
						pst41.setString(1, inv21.trim());
						

						String btype = "";

						try {
							btype = ib.getBtype()[j1];
						} catch (Exception e) {
							
							btype = "";
						}
						pst41.setString(2, btype);

						// pst41.setString(2,"labour");

						pst41.setString(3, ib.getDescription1()[j1]);

						Double amount = 0.0;
						double vatpercent = 0.0;
						double taxamount = 0.0;
						double netamount = 0.0;

						String amountlist = ib.getAmount1()[j1];

						String vatpercentlist = ib.getVat1()[j1];

						String taxamountlist = ib.getTaxqmount1()[j1];

						// String qty=ib.getQuantity1()[j1];
						// Integer Quantity1=0;
						String netamountlist = ib.getVatamount1()[j1];

						Double Quantity1 = 0.0;
						try {
							String qty = ib.getQuantity1()[j1];
						
							Quantity1 = Double.parseDouble(qty);
							;
						} catch (Exception e) {
							
							Quantity1 = 0.0;
						}

					
						pst41.setDouble(4, Quantity1);
						

						try {
							amount = Double.parseDouble(amountlist);
						} catch (Exception e) {
							
							amount = 0.0;
						}

						try {
							vatpercent = Double.parseDouble(vatpercentlist);
						} catch (Exception e) {
							
							vatpercent = 0;
						}

						try {
							taxamount = Double.parseDouble(taxamountlist);
						} catch (Exception e) {
							
							taxamount = 0;
						}
						try {
							netamount = Double.parseDouble(netamountlist);
						} catch (Exception e) {
							
							netamount = 0;
						}

						
						pst41.setDouble(5, amount);
						pst41.setDouble(6, vatpercent);

						pst41.setDouble(7, taxamount);
						pst41.setDouble(8, netamount);
						String ttype = "";

						try {
							ttype = ib.getTtype()[j1];
						} catch (Exception e) {
							
							ttype = "";
						}
						pst41.setString(9, ttype);
						
						pst41.setString(10, ib.getGrate1()[j1]);
						pst41.setString(11, ib.getGstamount1()[j1]);
						pst41.setString(12, ib.getGrate2()[j1]);
						pst41.setString(13, ib.getGstamount2()[j1]);
						pst41.setString(14, ib.getMyrate()[j1]);
						pst41.setString(15, ib.getPartno()[j1]);
						pst41.setString(16, ib.getPartdate()[j1]);
						pst41.setString(17, ib.getPartnox()[j1]);
						pst41.setString(18, ib.getDisc()[j1]);
						pst41.setString(19, ib.getDiscamt()[j1]);
						pst41.setString(20, ib.getAmtwithdisc()[j1]);
						pst41.setString(21, ib.getPerunit()[j1]);
						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}
					
					
					String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
					 inv2 = ib.getInvno();
					 inv21 = " " + inv2;
					PreparedStatement pstdel1 = con.prepareStatement(qd1);
					pstdel1.setString(1, inv21.trim());

					int n12 = pstdel1.executeUpdate();
				
							PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
							System.out.println("preparedStatement112"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41z = con.prepareStatement(query);
						
						pst41z.setString(1, inv21.trim());	
						pst41z.setString(2, resultSet12zz.getString("type_name"));	
						pst41z.setString(3, resultSet12zz.getString("cgstrate"));	
						pst41z.setString(4, resultSet12zz.getString("sgstrate"));	
						pst41z.setString(5, resultSet12zz.getString("cgstamount"));	
						pst41z.setString(6, resultSet12zz.getString("sgstamount"));	
						pst41z.setString(7, resultSet12zz.getString("vat_percent"));	
						pst41z.setString(8, resultSet12zz.getString("taxablevalue"));	
						System.out.println(pst41z);
						pst41z.executeUpdate();
						}
						
					
					if (l1 > 0 && n1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}

				}

				// --------------

				// update taxcollection details

				String qdtc = "delete  from invoice_tax_collection where invoice_no=?";
				String inv23 = ib.getInvno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = con.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {
					pst41.setString(1, inv231.trim());
					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					

					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));

					int js = pst41.executeUpdate();
					
					
					
					
					
					query = "UPDATE   customercreditdebit  set Amount=? where Documentsno=?";

					inv1=ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;
				
					pst9 = con.prepareStatement(query);
					pst9.setString(1, ib.getTamount());
					pst9.setString(2, inv1);
					
							
						k = pst9.executeUpdate();

					

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}
				}
					// pst41.setString(2,"labour");

				}

				try{
					
						//DaoHelper.closeConnection();
						
					
				}catch(Exception e){}

			}

			else {
				
				
				
				
				
				String query1="INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,wotax)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				 pst9=con.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10,stringValue1);
				pst9.setString(14, ib.getJob_Card_no());
				pst9.setString(19, ib.getPono());
				pst9.setString(20, CoreData.getDateFormatAsDb(ib.getPodate()));
				pst9.setString(21, ib.getTermcond());
				pst9.setString(22, ib.getVendor());
				pst9.setString(23, ib.getDcnox());
				pst9.setString(24, ib.getDcdatex());
				
				pst9.setString(25, ib.getTransmode());
				pst9.setString(26, ib.getContactp());
				pst9.setString(27, ib.getContactpno());
				pst9.setString(28, ib.getShipparty());
				pst9.setString(29, ib.getShipadd());
				pst9.setString(30, ib.getShipgstn());
				pst9.setString(31, ib.getShipstate());
				pst9.setString(32, ib.getVehino());
				pst9.setString(33, ib.getFreight());
				pst9.setString(34, ib.getTransport());
				pst9.setString(35, "sgst");
				pst9.setString(36, ""+ib.getTamount());
				pst9.setString(37, ""+ib.getA2()[0]);
				pst9.setString(38, ""+ib.getA2()[1]);
				pst9.setString(39, ""+ib.getA2()[2]);
				pst9.setString(40, "yes");
				String paid_amt="";
				String balance_amt="";
				paid_amt=ib.getPaid_amt();
				balance_amt=ib.getBalance_amt();
				
				
				try{
				 x = Integer.valueOf(paid_amt);
				}catch (Exception e) {
					
					x=0;
				}
				try{
				 Y = Integer.valueOf(balance_amt);
				}catch (Exception e) {
					
					Y=0;
				}
				//Integer  pp=Integer.parseInt(paid_amt);
				//Integer  bb=Integer.parseInt(balance_amt);
				
				// CASH
				if(ib.getPaymod().equalsIgnoreCase("CASH"))
				{
				pst9.setString(3, "CASH");
				
				String paid_amt1="";
			
				paid_amt1=ib.getNet_amount();
				
				
				try{
					 x = Integer.valueOf(paid_amt1);
					}catch (Exception e) {
						
						x=0;
					}
				
						
				pst9.setString(4, paid_amt1);
				pst9.setString(5, ""+0);
				
				pst9.setString(7,"");
				pst9.setInt(8,0);
				pst9.setString(9,"");
				
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6,java.sql.Types.DATE);
				pst9.setString(11,""+ x);
				pst9.setString(12,""+ 0);
				pst9.setString(13, ""+0);
				pst9.setString(15, ""+ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");
				
				pst9.setString(17,"");
				
				 k=pst9.executeUpdate();	
				
				}
				
				// CHEQUE
				else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				{
					
					
					pst9.setString(3, "CHEQUE");
					Integer l=0;
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getCash_amt();
					
				
					chek_amt=ib.getCheque_amt();
					Integer c=0;
					try{
						 l = Integer.valueOf(chek_amt);
						}catch (Exception e) {
							
							l=0;
						}
						pst9.setString(4, ""+l);
						pst9.setString(5, ""+0);
						
						pst9.setString(7,ib.getCheque_no());
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						try{
						pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
						}catch (Exception e) {
							
							pst9.setString(2,null);
						}
						
					
						try{
						pst9.setString(6,CoreData.getDateFormatAsDb(ib.getCheque_date()));
						}catch (Exception e) {
							
							pst9.setString(6,null);
						}																																		
						
						pst9.setString(11, ""+0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12, ""+c);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, ""+ib.getBankname());
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
					
						 k=pst9.executeUpdate();
					
					}
					
					
					
					//credit
					
				else if(ib.getPaymod().equalsIgnoreCase("CREDIT"))
				{
					
					
					pst9.setString(3, "CARD");
					
					String paid_amt2="";
					String chek_amt="";
				
					paid_amt2=ib.getNet_amountcard();
					
				
					chek_amt=ib.getNet_amountcard();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						pst9.setString(5,""+ 0);
						
						pst9.setString(7,"");
						pst9.setString(8,ib.getCardid());
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setInt(11, 0);
						try{
							c = Integer.valueOf(chek_amt);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(12,""+ 0);
						pst9.setString(13, ""+a);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					// Insurance
				else if(ib.getPaymod().equalsIgnoreCase("INSURANCE"))
				{
					
					
					pst9.setString(3, "INSURANCE");
					
					String paid_amt2="";
					String balace="";
					String chek_amt="";
				
					paid_amt2=ib.getPaid_amt22();
					
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt22();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5,""+ c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,ib.getInsurance());
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11, ""+a);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+0);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						String d=null;
						try{
						 d= CoreData.getDateFormatAsDb(ib.getDate22());
						}catch (Exception e) {
							
							d=null;
						}
						pst9.setString(17, d);
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					
				else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT"))
				{
					
					String paymode="";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash"))
					{
						paymode=ib.getR1()+"~"+"CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");
					
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
					{
						
						paymode=ib.getR1()+"~"+"CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					}
					else if (ib.getR1().equalsIgnoreCase("partpaymentcard"))
					{
						paymode=ib.getR1()+"~"+"CARD";
						pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);
						
					}
					else
					{
						paymode=ib.getPaymod();
							pst9.setString(11,"0");
						
						pst9.setString(12, "0");
						pst9.setString(13,"0");
					}
					

					pst9.setString(3, paymode);		
					
					//chek_amt=ib.getNet_amountcard();
					balace=ib.getBalance_amt();
					Integer c=0;
					Integer a=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						pst9.setString(4, ""+a);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5, ""+c);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
						
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}
					
					
					// card and cash
				
				else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH"))
				{
					
					
					pst9.setString(3, "CARDANDCASH");
					
					String paid_amt2="";
					String balace="";
					String credit="";
				
					paid_amt2=ib.getCashhh();
					
					
					//chek_amt=ib.getNet_amountcard();
					credit=ib.getCarddd();
					Integer c=0;
					Integer a=0;
					Integer p=0;
					try{
						 a = Integer.valueOf(paid_amt2);
						}catch (Exception e) {
							
							a=0;
						}
						
						try{
							 c = Integer.valueOf(credit);
							}catch (Exception e) {
								
								c=0;
							}
						
						p=(a+c);
						
						pst9.setString(4, ""+p);
						try{
							c = Integer.valueOf(balace);
							}catch (Exception e) {
								
								c=0;
							}
						pst9.setString(5, ""+0);
						
						pst9.setString(7,"");
						pst9.setString(8,""+0);
						pst9.setString(9,"");
						
						DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
						String dateInString=ib.getCheque_date();
						Date dNo = new Date();
						dNo = ft.parse(dateInString);
						Date dNow = new Date();
					
					
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
						
						pst9.setNull(6,java.sql.Types.DATE);
																																									
						
						pst9.setString(11,""+paid_amt2);
						
						pst9.setString(12, ""+0);
						pst9.setString(13, ""+credit);
						pst9.setString(15, ""+ib.getTamount());
						pst9.setString(16, "");
						
						pst9.setString(17, "");
						pst9.setString(18, "0");
						
						 k=pst9.executeUpdate();
					
					}else{
						
						pst9.setString(3, "");
				
							pst9.setString(4, "");
							
							pst9.setString(5, ""+0);
							
							pst9.setString(7,"");
							pst9.setString(8,""+0);
							pst9.setString(9,"");
							
							
							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
							
							pst9.setNull(6,java.sql.Types.DATE);
																																										
							
							pst9.setString(11,"");
							
							pst9.setString(12, "");
							pst9.setString(13, "");
							pst9.setString(15, ""+ib.getTamount());
							pst9.setString(16, "");
							
							pst9.setString(17, "");
							pst9.setString(18, "0");
						
							 k=pst9.executeUpdate();
						
					}
			
				
				
				
				
				// Insert Into Customer Credit Debit Report
				
		
				String query11="insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)";
				
				pst9=con.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3,stringValue1);
				pst9.setString(4, "Invoice");
				pst9.setString(5, "101");
				pst9.setString(6, "Debit");
				pst9.setString(7,ib.getTamount());
				pst9.setString(8,ib.getCustomer_name());
				
				System.out.println("SQL:"+pst9);
				 k=pst9.executeUpdate();
					
				 
				 
				 
				// Bill Number Generation For Customer Credit Debit
					
				
				//--------------------
					
					
				PreparedStatement preparedStatement1121 = con
				.prepareStatement("update  job_card set job_card_done_status='"
						+ 1 + "' where job_card_no=? ");

		preparedStatement1121.setString(1, ib.getJob_Card_no());
		j = preparedStatement1121.executeUpdate();

		if (k > 0 && j > 0 && v>0) {
			response = "success";
		} else {
			response = "fail";

		}
		
		try{
			System.out.println(">>>>s");

			PreparedStatement preparedStatement112 = con.prepareStatement("select * from settings ");
					//System.out.println("preparedStatement112"+preparedStatement112);
				ResultSet resultSet12 = preparedStatement112.executeQuery();
				System.out.println(">>>>s1");

				if (resultSet12.next()) {
					System.out.println(">>>>s2"+resultSet12.getString("po"));

				if(resultSet12.getString("po").trim().equals("yes")){	
					System.out.println(">>>>3>>>"+ib.getDescription1().length);

		for (int k2=0;k2<ib.getDescription1().length;k2++)
		{
			System.out.println(">>>>4");

		System.out.println(">>>>s");
		PreparedStatement ppt = con
				.prepareStatement("select qtyremaining,descrip from purchase_order_details where pono='"+ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' ");

		System.out.println("SQL:"+ppt);
		ResultSet rst = ppt.executeQuery();

		while (rst.next()) {
			
		String desc=ib.getDescription1()[k2];
		String qty=rst.getString("qtyremaining");
		
		System.out.println("Quantity:"+qty);
		
		String qty1=ib.getQuantity1()[k2];
			
		Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);
		
		System.out.println("New QUantity:"+qty2);
		
		String q11 = "update purchase_order_details set  qtyremaining='"+qty2+"' where descrip='"+desc+"' and pono='"+ib.getPono()+"'";
	   	PreparedStatement ps1 = con.prepareStatement(q11);	
	   	
	   	
	 System.out.println("Sql12::"+ps1);
		
	   	ps1.executeUpdate();
		
		}
		
		}
				}
				}
		}catch(Exception e){
			
			
		}

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
					

					pst41.setString(1, stringValue1.trim());

					String btype = "";

					try {
						btype = ib.getBtype()[j1];
					} catch (Exception e) {
						
						btype = "";
					}
					pst41.setString(2, btype);

					// pst41.setString(2,"labour");

					pst41.setString(3, ib.getDescription1()[j1]);

					Double amount = 0.0;
					double vatpercent = 0.0;
					double taxamount = 0.0;
					double netamount = 0.0;

					String amountlist = ib.getAmount1()[j1];

					String vatpercentlist = ib.getVat1()[j1];

					String taxamountlist = ib.getTaxqmount1()[j1];

					String netamountlist = ib.getVatamount1()[j1];

					Double Quantity1 = 0.0;
					try {
						String qty = ib.getQuantity1()[j1];
						
						Quantity1 = Double.parseDouble(qty);
						
					} catch (Exception e) {
					
						Quantity1 = 0.0;
					}

				
					pst41.setDouble(4, Quantity1);

					try {
						amount = Double.parseDouble(amountlist);
					} catch (Exception e) {
						
						amount = 0.0;
					}
					
					try {
						vatpercent = Double.parseDouble(vatpercentlist);
					} catch (Exception e) {
						
						vatpercent = 0;
					}

					try {
						taxamount = Double.parseDouble(taxamountlist);
					} catch (Exception e) {
						
						taxamount = 0;
					}
					try {
						netamount = Double.parseDouble(netamountlist);
					} catch (Exception e) {
						
						netamount = 0;
					}

					
					pst41.setDouble(5, amount);
					pst41.setDouble(6, vatpercent);

					pst41.setDouble(7, taxamount);
					pst41.setDouble(8, netamount);
					String ttype = "";

					try {
						ttype = ib.getTtype()[j1];
					} catch (Exception e) {
						
						ttype = "";
					}
					pst41.setString(9, ttype);
					pst41.setString(10, ib.getGrate1()[j1]);
					pst41.setString(11, ib.getGstamount1()[j1]);
					pst41.setString(12, ib.getGrate2()[j1]);
					pst41.setString(13, ib.getGstamount2()[j1]);
					pst41.setString(14, ib.getMyrate()[j1]);
					pst41.setString(15, ib.getPartno()[j1]);
					pst41.setString(16, ib.getPartdate()[j1]);
					pst41.setString(17, ib.getPartnox()[j1]);
					pst41.setString(18, ib.getDisc()[j1]);
					pst41.setString(19, ib.getDiscamt()[j1]);
					pst41.setString(20, ib.getAmtwithdisc()[j1]);
					pst41.setString(21, ib.getPerunit()[j1]);
					int l1 = pst41.executeUpdate();

					if (l1 > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					rr = rr + 1;
					;

					String sn = "" + rr;

					ib.setSn(sn);
					}

				}

				// -----------
				
			
						PreparedStatement preparedStatement112zz = con.prepareStatement("select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"+stringValue1+"' GROUP BY type_name   ");
						System.out.println("preparedStatement112"+preparedStatement112zz);
					ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

					while (resultSet12zz.next()) {
						
					query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
					PreparedStatement pst41x = con.prepareStatement(query);
					
					pst41x.setString(1, stringValue1);	
					pst41x.setString(2, resultSet12zz.getString("type_name"));	
					pst41x.setString(3, resultSet12zz.getString("cgstrate"));	
					pst41x.setString(4, resultSet12zz.getString("sgstrate"));	
					pst41x.setString(5, resultSet12zz.getString("cgstamount"));	
					pst41x.setString(6, resultSet12zz.getString("sgstamount"));	
					pst41x.setString(7, resultSet12zz.getString("vat_percent"));	
					pst41x.setString(8, resultSet12zz.getString("taxablevalue"));	
					System.out.println(pst41x);
					pst41x.executeUpdate();
					}

				// insert to tax collection
				 q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date) values(?,?,?,?,?)";

				 pst41 = con.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {

					

					pst41.setString(1, stringValue1);

					
					String type = "";
					String taxableamount = ib.getA()[j1];
					String tax = ib.getA2()[j1];

					double taxableamount1 = 0.0;
					double tax1 = 0.0;
					// double netamount =0.0;
					try {
						type = ib.getT()[j1];
					} catch (Exception e) {
						
						type = "";
					}

					pst41.setString(2, type);

					try {
						taxableamount1 = Double.parseDouble(taxableamount);
					} catch (Exception e) {
						
						taxableamount1 = 0.0;
					}

					pst41.setDouble(3, taxableamount1);

					try {
						tax1 = Double.parseDouble(tax);
					} catch (Exception e) {
						
						tax1 = 0.0;
					}

					pst41.setDouble(4, tax1);

					
					pst41.setString(5, CoreData.getDateFormatAsDb(ib.getDate()));
				
					
					int js = pst41.executeUpdate();

					if (js > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

			}

			// -----
			
			try{
				
					//DaoHelper.closeConnection();
			
				
			}catch(Exception e){
				
			}
			
		}
			
			return response;
		
		}
		public List<invoicebean> fetchPIDetails(invoicebean inbean) {
			// TODO Auto-generated method stub
			
			DBConnection connection=new DBConnection();
			Connection conn=connection.getConnection();
			
			List<invoicebean> list=new ArrayList<>();
			try {
					PreparedStatement pst=conn.prepareStatement("SELECT invoice.invoice_no,customercreditdebit.Name,invoice.date,invoice.total,invoice.lead_no FROM invoice,customercreditdebit WHERE invoice.invoice_no=customercreditdebit.Documentsno and invoice.status=1");
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						invoicebean ib=new invoicebean();
						ib.setInvoiceno(rs.getString(1));
						ib.setCustomer_name(rs.getString(2));
						ib.setDate(rs.getString(3));
						ib.setTotal(rs.getString(4));
						ib.setLead_no(rs.getString(5));
						list.add(ib);
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
}
