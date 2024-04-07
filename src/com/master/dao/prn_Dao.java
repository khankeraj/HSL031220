package com.master.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.purchase_bean;
import com.master.util.AmtInWord;
import com.master.util.CoreData;
import com.master.util.EnglishNumberToWords;
import com.master.util.SystemDateTime;

public class prn_Dao {
	// method for purchase order submit
	int pay_cash = 0;
	int pay_cheque = 0;
	int pay_credit = 0;
	
	static DBConnection connection=new DBConnection();

	public List<purchase_bean> prodd(String from_date, String to_date1)
			throws Exception {
		DBConnection connection=new DBConnection();Connection conn=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement3 = conn
				.prepareStatement("select dist_name,mobile_no,date,DC_no,total from stock_form where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement3 " + preparedStatement3);
		preparedStatement3.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		System.out.println("preparedStatement3 " + preparedStatement3);

		ResultSet rs11 = preparedStatement3.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		while (rs11.next()) {
			bean = new purchase_bean();
			bean.setDist_name(rs11.getString("dist_name"));
			bean.setMobile_no(rs11.getString("mobile_no"));
			bean.setDate(rs11.getString("date"));
			bean.setDC_no(rs11.getString("DC_no"));
			bean.setTotal(rs11.getString("total"));

			try {

				totalamount = totalamount.add(rs11.getBigDecimal(5));
			} catch (Exception e) {
				// TODO: handle exception
			}

			bean.setTotalamount1("" + totalamount);
			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		System.out.println("report size " + report.size());
		return report;

	}

	
	
	
	
	public List<purchase_bean> prodd1(String from_date, String to_date1)
			throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv ,date, invtype from invoice where  date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		Double tparts=0.0;
		Double tlabour=0.0;
		Double tlabourwct=0.0;
		Double tot=0.0;
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			if(rs11.getString("invtype").equals("sgst")){
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setTotalamtparts(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
				tparts=tparts+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			/*PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  group by  invoice_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setTotalamtlabourwct(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tlabourwct=tlabourwct+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}
		
		System.out.println("totla labour wct dao"+tlabourwct);	*/
			
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(sgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? group by  invoice_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement3 " + preparedStatement3);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setTotalamtlabour(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tlabour=tlabour+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}
			}
			
	//System.out.println("totla labour stax dao"+tlabour);	
			
			if(rs11.getString("invtype").equals("igst")){
				
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  group by  invoice_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				 System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						System.out.println("total labour wct"+rs33.getString("nmt"));
						
					bean1.setTotalamtlabourwct(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tlabourwct=tlabourwct+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}
				
				
				
			}
			
			
			
			
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(net_amt) as nmt FROM invoice_tax_details WHERE invoice_no=? group by  invoice_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setTotalnetamt(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
				tot=tot+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}
				//System.out.println("sumwctdao........."+tlabourwct);
			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTparts(""+ Math.round(tparts));
			bean1.setTlabour(""+Math.round(tlabour));
			bean1.setTlabourwct(""+Math.round(tlabourwct));
			bean1.setTot(""+Math.round(tot));
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		
		
		
		// System.out.println("report size " + report.size());
		return report;

	}

	public List<purchase_bean> prodd2(String from_date, String to_date1,
			String mode) throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1=null;
		if(mode.equals("Cash"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycash as tot from invoice where date between ? and ? and pay_mode IN('CASH','CARDANDCASH','partpaymentcash~CASH','PARTPAYMENT','INSURANCE','')");
		}
		else if (mode.equals("Cheque"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycheque as tot  from invoice where date between ? and ? and pay_mode IN('CHEQUE','partpaymentcheque~CHEQUE','partpaymentcash~CASH')");
		}
		
		else if (mode.equals("Card"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycredit  as tot  from invoice where date between ? and ? and pay_mode IN('CARD','partpaymentcard~CARD','partpaymentcash~CASH','CREDIT','CREDITCARD','CARDANDCASH')");
		}
		
		
		
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		
		//System.out.println("mode" + mode);
		//System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
	
		BigDecimal totalamount = BigDecimal.ZERO;
		double ttamount=0.0;
		
		
		while (rs11.next()) {
			bean = new purchase_bean();

			bean.setDate(rs11.getString("date"));

			bean.setJob_card_no(rs11.getString("job_card_no"));
			bean.setInvoice_no(rs11.getString("invoice_no"));
			bean.setVechicle_no(rs11.getString("vehicle_no"));
	/*	if(rs11.getString("pay_mode").equals("CASH")|| rs11.getString("pay_mode").equals("CARDANDCASH")||rs11.getString("pay_mode").equals("partpaymentcash~CASH")||rs11.getString("pay_mode").equals("PARTPAYMENT")||rs11.getString("pay_mode").equals("INSURANCE")|| rs11.getString("pay_mode").equals("")){*/
			try{	
				
				
				
			bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("tot"))));
			
			bean.setPay_mode(rs11.getString("pay_mode"));

			totalamount = totalamount.add(rs11.getBigDecimal("tot"));
			ttamount=totalamount.doubleValue();
			bean.setTotalamount1("" +  Math.round(ttamount));
			}
			catch(Exception e)
			{
				
				
			}
			
			
			/*else if(rs11.getString("pay_mode").equals("CHEQUE")|| rs11.getString("pay_mode").equals("partpaymentcheque~CHEQUE")){
				System.out.println("within if111111111111");
				bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("paybycheque"))));
				totalamount = totalamount.add(rs11.getBigDecimal("paybycheque"));
				ttamount=totalamount.doubleValue();
				bean.setPay_mode(rs11.getString("pay_mode"));
				bean.setTotalamount1("" +  Math.round(ttamount));
				}
			else if(rs11.getString("pay_mode").equals("CREDIT")|| rs11.getString("pay_mode").equals("partpaymentcard~CARD")|| rs11.getString("pay_mode").equals("CARDANDCASH")|| rs11.getString("pay_mode").equals("CREDIT")|| rs11.getString("pay_mode").equals("CARD")|| rs11.getString("pay_mode").equals("CREDITCARD")){
				System.out.println("within if22222222222222");
				bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("paybycredit"))));
				totalamount = totalamount.add(rs11.getBigDecimal("paybycredit"));
				ttamount=totalamount.doubleValue();
				bean.setPay_mode(rs11.getString("pay_mode"));
				bean.setTotalamount1("" +  Math.round(ttamount));
				}*/
			//bean.setPay_mode(rs11.getString("pay_mode"));

			/*try {

				totalamount = totalamount.add(rs11.getBigDecimal(5));
			} catch (Exception e) {
				// TODO: handle exception
			}*/

			//bean.setTotalamount1("" +  Math.round(ttamount));
			/*
			 * PreparedStatement preparedStatement2 = con .prepareStatement(
			 * "select invoice_no,total from invoice where job_card_no=?");
			 * preparedStatement2.setString(1, rs11.getString("job_card_no"));
			 * ResultSet rs22 = preparedStatement2.executeQuery(); if
			 * (rs22.next()) { bean.setInvoice_no(rs22.getString(1));
			 * bean.setTotal(rs22.getString("total")); }
			 */
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select cust_name from customer_master where cust_id=?");
			preparedStatement3.setString(1, rs11.getString("vehicle_no"));
			//System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			if (rs33.next()) {
				bean.setCust_name(rs33.getString("cust_name"));
			}
			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		//System.out.println("report size " + report.size());
		return report;

	}

	public List<purchase_bean> tax(String from_date, String to_date1)
			throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select invoice_no,date from invoice where date between ? and ?");

		System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		ResultSet rs11 = preparedStatement1.executeQuery();
		BigDecimal totalamount = BigDecimal.ZERO;
		while (rs11.next()) {
			purchase_bean bean = new purchase_bean();
			bean.setInvoice_no("" + rs11.getString(1));
			bean.setDate("" + CoreData.getDateFormatAsUser(rs11.getString(2)));

			PreparedStatement preparedStatement1x = con
					.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='VAT 5.5%:' and  invoice_no='"
							+ rs11.getString(1) + "'");

			ResultSet rs11x = preparedStatement1x.executeQuery();

			if (rs11x.next()) {
				bean.setVat1(rs11x.getString(1));
			}

			PreparedStatement preparedStatement1x1 = con
			.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='VAT 12.5%:'  and invoice_no='"
					+ rs11.getString(1) + "'");

	ResultSet rs11x1 = preparedStatement1x1.executeQuery();

	if (rs11x1.next()) {
		bean.setVat2(rs11x1.getString(1));
	}

	PreparedStatement preparedStatement1x2 = con
	.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='SERVICE TAX 14%:'  and invoice_no='"
			+ rs11.getString(1) + "'");

ResultSet rs11x2 = preparedStatement1x2.executeQuery();

if (rs11x2.next()) {
bean.setVat3(rs11x2.getString(1));
}
			

PreparedStatement preparedStatement1x3 = con
.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='SERVICE TAX 14% on 25% of D/P:'  and invoice_no='"
		+ rs11.getString(1) + "'");

ResultSet rs11x3 = preparedStatement1x3.executeQuery();

if (rs11x3.next()) {
bean.setVat4(rs11x3.getString(1));
}


PreparedStatement preparedStatement1x4 = con
.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='VAT @ 12.5% on 75% of D/P:'  and invoice_no='"
		+ rs11.getString(1) + "'");

ResultSet rs11x4 = preparedStatement1x4.executeQuery();

if (rs11x4.next()) {
bean.setVat5(rs11x4.getString(1));
}


PreparedStatement preparedStatement1x5 = con
.prepareStatement("select tax_amt  from invoice_tax_collection where tax_type='SWATCH BHARAT CESS 0.5%:' and invoice_no='"
		+ rs11.getString(1) + "'");

ResultSet rs11x5 = preparedStatement1x5.executeQuery();

if (rs11x5.next()) {
bean.setVat6(rs11x5.getString(1));
}


			
			try {

				totalamount = totalamount.add(rs11.getBigDecimal(2));
			} catch (Exception e) {
				// TODO: handle exception
			}

			bean.setTotalamount1("" + totalamount);
			/*
			 * PreparedStatement preparedStatement2 = con .prepareStatement(
			 * "select invoice_no,total from invoice where job_card_no=?");
			 * preparedStatement2.setString(1, rs11.getString("job_card_no"));
			 * ResultSet rs22 = preparedStatement2.executeQuery(); if
			 * (rs22.next()) { bean.setInvoice_no(rs22.getString(1));
			 * bean.setTotal(rs22.getString("total")); }
			 */

			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		System.out.println("report size " + report.size());
		return report;

	}

	public List<purchase_bean> tax_detail_report(String from_date,
			String to_date1) throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no from invoice where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));

		System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		while (rs11.next()) {
			bean = new purchase_bean();
			bean.setDate(rs11.getString(1));
			bean.setJob_card_no(rs11.getString(2));
			bean.setInvoice_no(rs11.getString(3));
			bean.setVechicle_no(rs11.getString(4));

			PreparedStatement preparedStatement2 = con
					.prepareStatement("select type,tax_amt_percent from invoice_tax_details where invoice_no=?");
			preparedStatement2.setString(1, rs11.getString("invoice_no"));
			ResultSet rs22 = preparedStatement2.executeQuery();
			if (rs22.next()) {
				bean.setType(rs22.getString(1));
				bean.setTax_amt(rs22.getString(2));
				try {

					totalamount = totalamount.add(rs22.getBigDecimal(2));
				} catch (Exception e) {
					// TODO: handle exception
				}

				bean.setTotalamount1("" + totalamount);
			}
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select cust_name from customer_master where vehicle_no=?");
			preparedStatement3.setString(1, rs11.getString("vehicle_no"));
			ResultSet rs33 = preparedStatement3.executeQuery();
			if (rs33.next()) {
				bean.setCust_name(rs33.getString(1));
			}

			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		System.out.println("report size " + report.size());
		return report;

	}

	public List<purchase_bean> estimate_search(String from_date, String to_date1)
			throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select cust_name,cust_address,mobile_no,vechical_no,date,est_id from estimate where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));

		System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		while (rs11.next()) {
			bean = new purchase_bean();
			bean.setCust_name(rs11.getString(1));
			bean.setCust_address(rs11.getString(2));
			bean.setMobile_no(rs11.getString(3));
			bean.setVechicle_no(rs11.getString(4));
			bean.setDate(rs11.getString(5));

			PreparedStatement preparedStatement2 = con
					.prepareStatement("select net from estimate_details where estimate_id=?");
			preparedStatement2.setString(1, rs11.getString("est_id"));
			System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			if (rs22.next()) {
				bean.setTotal(rs22.getString(1));
				try {

					totalamount = totalamount.add(rs22.getBigDecimal(1));
				} catch (Exception e) {
					// TODO: handle exception
				}

				bean.setTotalamount1("" + totalamount);
			}

			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		System.out.println("report size " + report.size());
		return report;

	}

	public List<purchase_bean> invoice_report(String from_date, String to_date1)
			throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement3 = con
				.prepareStatement("select paybycash from invoice where date between ? and ? and pay_mode='CASH'");
		purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement3 " + preparedStatement3);
		preparedStatement3.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		System.out.println("preparedStatement3 " + preparedStatement3);

		ResultSet rs11 = preparedStatement3.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		while (rs11.next()) {
			bean = new purchase_bean();

			pay_cash = pay_cash + rs11.getInt(1);

		}
		PreparedStatement preparedStatement4 = con
				.prepareStatement("select paybycheque from invoice where date between ? and ? and pay_mode='CHEQUE'");

		System.out.println("preparedStatement3 " + preparedStatement3);
		preparedStatement4.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement4.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		System.out.println("preparedStatement4 " + preparedStatement4);

		ResultSet rs22 = preparedStatement4.executeQuery();
		// System.out.println(preparedStatement3);

		while (rs22.next()) {

			pay_cheque = pay_cheque + rs22.getInt(1);

		}
		PreparedStatement preparedStatement5 = con
				.prepareStatement("select paybycredit from invoice where date between ? and ? and pay_mode='CREDIT'");

		System.out.println("preparedStatement5 " + preparedStatement5);
		preparedStatement5.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement5.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		System.out.println("preparedStatement5 " + preparedStatement5);

		ResultSet rs33 = preparedStatement5.executeQuery();
		// System.out.println(preparedStatement3);

		while (rs33.next()) {

			pay_credit = pay_credit + rs33.getInt(1);

		}
		bean.setPaybycredit("" + pay_credit);
		bean.setPaybycheque("" + pay_cheque);
		bean.setPaybycash("" + pay_cash);
		report.add(bean);
		return report;

	}

	public purchase_bean prodd122(String datefrom, String dateto)
			throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select  sum(paybycash) as tot from  invoice where date  between ? and ? ");
		purchase_bean bean = new purchase_bean();
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
				.replace("/", "-") + " 00:00:00"));
		System.out.println(preparedStatement1+"preparedStatement1");
				ResultSet rs11 = preparedStatement1.executeQuery();
	
		String totalamount = "";
		if (rs11.next()) {
			// purchase_bean bean1 = new purchase_bean();
			bean.setPaybycashtotal(""+Math.round((Double.parseDouble(rs11.getString("tot")))));
			//bean.setPaybychequetotal(rs11.getString("tot1"));
			//bean.setPaybycardtotal(rs11.getString("tot2"));
			
		}else{
			bean.setPaybycashtotal("0.0");
		}

		PreparedStatement preparedStatement12 = con
		.prepareStatement("select  sum(paybycheque) as tot from  invoice  where  date  between ? and ? ");

preparedStatement12.setString(1, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
				.replace("/", "-") + " 00:00:00"));
preparedStatement12.setString(2, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
		.replace("/", "-") + " 00:00:00"));
System.out.println(preparedStatement12+"preparedStatement12");
		ResultSet rs112 = preparedStatement12.executeQuery();

if (rs112.next()) {
	// purchase_bean bean1 = new purchase_bean();
	//bean.setPaybycashtotal(rs112.getString("tot"));
	bean.setPaybychequetotal(""+Math.round((Double.parseDouble(rs112.getString("tot")))));
	//bean.setPaybycardtotal(rs11.getString("tot2"));
	
}else{
	bean.setPaybychequetotal("0.0");
}
PreparedStatement preparedStatement123 = con
.prepareStatement("select  sum(paybycredit) as tot from  invoice  where  date between ? and ? ");

preparedStatement123.setString(1, SystemDateTime
.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
		.replace("/", "-") + " 00:00:00"));
preparedStatement123.setString(2, SystemDateTime
.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
.replace("/", "-") + " 00:00:00"));
System.out.println(preparedStatement123+"preparedStatement123");
ResultSet rs1123 = preparedStatement123.executeQuery();
if (rs1123.next()) {
// purchase_bean bean1 = new purchase_bean();
//bean.setPaybycashtotal(rs112.getString("tot"));
//bean.setPaybychequetotal(rs112.getString("tot1"));
bean.setPaybycardtotal(""+Math.round((Double.parseDouble(rs1123.getString("tot")))));

}else{
	bean.setPaybycardtotal("0.0");

}





		// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		return bean;

	}

	
	
	
	
	
	
	
	
	public purchase_bean tax22(String datefrom, String dateto) throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		purchase_bean bean = new purchase_bean();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='5' and date BETWEEN ? and ? GROUP BY vat_percent");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement1.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs11.next()) {
			// bean = new purchase_bean();
			bean.setVat1(rs11.getString("tot1"));
			System.out.println(rs11.getString("tot1"));

		}

		PreparedStatement preparedStatement2 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='12' and date BETWEEN ? and ? GROUP BY vat_percent");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement2.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement2.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement2.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement2 " + preparedStatement2);

		ResultSet rs22 = preparedStatement2.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs22.next()) {
			// bean = new purchase_bean();
			bean.setVat2(rs22.getString("tot1"));

		}
		
		
		PreparedStatement preparedStatement3 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='18' and date BETWEEN ? and ? GROUP BY vat_percent");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement3.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement2.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement3 " + preparedStatement3);

		ResultSet rs33 = preparedStatement3.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs33.next()) {
			// bean = new purchase_bean();
			bean.setVat3(rs33.getString("tot1"));

		}
		
		
		
		PreparedStatement preparedStatement33 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='28' and date BETWEEN ? and ? GROUP BY vat_percent");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement33.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement33.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement2.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement3 " + preparedStatement33);

		ResultSet rs44 = preparedStatement33.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs44.next()) {
			// bean = new purchase_bean();
			bean.setVat4(rs44.getString("tot1"));

		}
		
		
		PreparedStatement preparedStatement7 = con
				.prepareStatement("select date,SUM(tax_amt_percent) as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and date between ? and ? GROUP BY vat_percent");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement7.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement7.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement6.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement " + preparedStatement7);

		ResultSet rs77 = preparedStatement7.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs77.next()) {
			// bean = new purchase_bean();
			bean.setTotvat(rs77.getString("tot1"));

		}
		
		
/*
		PreparedStatement preparedStatement3 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='18' and date BETWEEN ? and ? GROUP BY date");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement3.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement3.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement " + preparedStatement3);

		ResultSet rs33 = preparedStatement3.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs33.next()) {
			// bean = new purchase_bean();
			bean.setVat3(rs33.getString("tot1"));

		}

		PreparedStatement preparedStatement4 = con
				.prepareStatement("select date,vat_percent,SUM(tax_amt_percent)as tot1 from invoice,invoice_tax_details where invoice.invoice_no = invoice_tax_details.invoice_no and vat_percent='28' and date BETWEEN ? and ? GROUP BY date");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement4.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement4.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement4.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement " + preparedStatement4);

		ResultSet rs44 = preparedStatement4.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs44.next()) {
			// bean = new purchase_bean();
			bean.setVat4(rs44.getString("tot1"));

		}
		*/
		
		
		/*PreparedStatement preparedStatement7 = con
				.prepareStatement("select SUM(tax_amt) as tot1 from invoice_tax_details where date between ? and ? ");

		// System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement7.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement7.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		// preparedStatement6.setString(3, rs.getString("tax_type"));

		System.out.println("preparedStatement " + preparedStatement7);

		ResultSet rs77 = preparedStatement7.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		if (rs77.next()) {
			// bean = new purchase_bean();
			bean.setTotvat(rs77.getString("tot1"));

		}*/

		// bean.setTax_type( rs.getString("tax_type"));

		// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		return bean;

	}

	
	
	
	
	
	
	public List<purchase_bean> out22()
			throws Exception {
		// TODO Auto-generated method stub

		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		purchase_bean bean = new purchase_bean();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv  from invoice ");
		// purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement1 " + preparedStatement1);
		
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		String jobcarno = "";Double totos=0.0;
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));

			PreparedStatement preparedStatement2 = con
					.prepareStatement("select total, vehicle_no,insurance_comp,job_card_no,paid_amount FROM invoice WHERE invoice_no=? ");
			preparedStatement2.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			Double bal=0.0;
			Double tot=0.0;
			Double paid=0.0;
			
			if (rs22.next()) {
				try{
					
					if(!rs22.getString("total").equals("") && !rs22.getString("total").equals(null) ){
						tot=Double.parseDouble(rs22.getString("total"));
					}
					
				}catch (Exception e) {
					// TODO: handle exception
				}
				try{
				if( !rs22.getString("paid_amount").equals("") && !rs22.getString("paid_amount").equals(null))
				{
					paid=Double.parseDouble(rs22.getString("paid_amount"));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
				try{
				bean1.setTotalamtparts(""+(tot - paid));
				}catch (Exception e) {
					// TODO: handle exception
				}
				try{
				bal=tot - paid;
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				jobcarno = rs22.getString("job_card_no");
				bean1.setVechicle_no(rs22.getString("vehicle_no"));
				bean1.setInsurancecompany(rs22.getString("insurance_comp"));

				PreparedStatement preparedStatement21 = con
						.prepareStatement("select customer_name,model FROM job_card WHERE job_card_no=?");
				preparedStatement21.setString(1, jobcarno);
				// System.out.println("preparedStatement21"+preparedStatement21);
				ResultSet rs112 = preparedStatement21.executeQuery();
				if (rs112.next()) {
					bean1.setCust_name(rs112.getString("customer_name"));
					bean1.setModel(rs112.getString("model"));
					PreparedStatement preparedStatement212 = con
							.prepareStatement("select mobile_no FROM customer_master WHERE cust_name=?");
					preparedStatement212.setString(1, bean1.getCust_name());
					// System.out.println("preparedStatement21"+preparedStatement21);
					ResultSet rs1122 = preparedStatement212.executeQuery();
					if (rs1122.next()) {
						bean1.setMobile_no(rs1122.getString("mobile_no"));
					}

				}

			}

			/*PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(balance_amount) as nmt FROM invoice WHERE date between ? and ?");
			preparedStatement3.setString(1, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
							.replace("/", "-") + " 00:00:00"));
			preparedStatement3.setString(2, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
							.replace("/", "-") + " 00:00:00"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			if (rs33.next()) {
				bean1.setTotalamtlabour(rs33.getString("nmt"));
			}*/
		
			bean1.setInvoice_no(rs11.getString("inv"));
			try{
			if(bal > 0.0){
				totos=totos+bal;
				bean1.setTotalamtlabour(""+totos);
			report.add(bean1);
			}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

		return report;

	}

	public List<purchase_bean> alert22() throws Exception {
		// TODO Auto-generated method stub

		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		purchase_bean bean = new purchase_bean();
		String date = "";
		String jobcarno = "";
		String date4 = "";
		String date2 = "";
		Date olderDate1 = new Date();
		Date olderDate = new Date();
		PreparedStatement preparedStatement3x = con
		.prepareStatement("select DISTINCT vehicle_no from invoice ");




ResultSet rs3311x = preparedStatement3x.executeQuery();
while (rs3311x.next()) {
		

		PreparedStatement preparedStatement3 = con.prepareStatement("select  invoice_no ,date,owsms from invoice where vehicle_no='"+rs3311x.getString("vehicle_no")+"'   ORDER BY date desc");
		ResultSet rs3311 = preparedStatement3.executeQuery();
		if (rs3311.next()) {
			purchase_bean bean1 = new purchase_bean();
			date = CoreData.getDateFormatAsUser(rs3311.getString("date"));

			System.out.println("date" + date);
			bean1.setDate(CoreData.getDateFormatAsUser(rs3311.getString("date")));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String dateInString = date;
			bean1.setBank(rs3311.getString("owsms"));
			try {

				olderDate = formatter.parse(dateInString);
				System.out.println(olderDate);
				// olderDate=formatter.format(olderDate1);

			} catch (ParseException e) {
				e.printStackTrace();

			}

			Date newerDate = new Date();
			System.out.println("sysdate" + newerDate);
			/*
			 * date4=""+date1; date2=CoreData.getDateFormatAsUser(date4);
			 * System.out.println("date4"+date2);
			 */
			Calendar c1 = Calendar.getInstance();
			c1.setTime(newerDate);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(olderDate);
			int diff = 0;
			// int diff = (d2.get(Calendar.YEAR) - d1.get(Calendar.YEAR)) * 12 +
			// d2.get(Calendar.MONTH) - d1.get(Calendar.MONTH);

			diff = (c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR)) * 12
					+ c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);

			System.out.println("diffrence" + diff);

			if (diff > 4 || diff == 4) {

				PreparedStatement preparedStatement2 = con
						.prepareStatement("select balance_amount, vehicle_no,insurance_comp,job_card_no FROM invoice WHERE invoice_no=? ");
				preparedStatement2.setString(1, rs3311.getString("invoice_no"));
				// System.out.println("preparedStatement2 " +
				// preparedStatement2);
				ResultSet rs22 = preparedStatement2.executeQuery();
				if (rs22.next()) {
					bean1.setTotalamtparts(rs22.getString("balance_amount"));
					jobcarno = rs22.getString("job_card_no");
					bean1.setVechicle_no(rs22.getString("vehicle_no"));
					bean1.setInsurancecompany(rs22.getString("insurance_comp"));

					PreparedStatement preparedStatement21 = con
							.prepareStatement("select customer_name,model,KM FROM job_card WHERE job_card_no=?");
					preparedStatement21.setString(1, jobcarno);
					// System.out.println("preparedStatement21"+preparedStatement21);
					ResultSet rs112 = preparedStatement21.executeQuery();
					if (rs112.next()) {
						bean1.setCust_name(rs112.getString("customer_name"));
						bean1.setModel(rs112.getString("model"));
						bean1.setTax_type(rs112.getString("KM"));
						PreparedStatement preparedStatement212 = con
								.prepareStatement("select mobile_no FROM customer_master WHERE cust_name=?");
						preparedStatement212.setString(1, bean1.getCust_name());
						// System.out.println("preparedStatement21"+preparedStatement21);
						ResultSet rs1122 = preparedStatement212.executeQuery();
						if (rs1122.next()) {
							bean1.setMobile_no(rs1122.getString("mobile_no"));
						}

					}

				}

				bean1.setInvoice_no(rs3311.getString("invoice_no"));

				report.add(bean1);

			}

		}
}

		return report;

	}

	public List<purchase_bean> inv22() throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		purchase_bean bean = new purchase_bean();
		int size=0;

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv  from invoice ");
		// purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		// BigDecimal totalamount = BigDecimal.ZERO;
		String jobcarno = "";Double totos=0.0;
		while (rs11.next()) {
			
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));

			PreparedStatement preparedStatement2 = con
					.prepareStatement("select total,date, vehicle_no,job_card_no,paid_amount,invoice_done_status FROM invoice WHERE invoice_no=? ");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			Double bal=0.0;
			Double tot=0.0;
			Double paid=0.0;
			
			if (rs22.next()) {
				try{
					
					if(!rs22.getString("total").equals("") && !rs22.getString("total").equals(null) ){
						tot=Double.parseDouble(rs22.getString("total"));
					}
					
				}catch (Exception e) {
					// TODO: handle exception
					
				}
				bean1.setTot(""+tot);
				try{
				if( !rs22.getString("paid_amount").equals("") && !rs22.getString("paid_amount").equals(null))
				{
					paid=Double.parseDouble(rs22.getString("paid_amount"));
				}
				}catch (Exception e) {
					// TODO: handle exception
				}
				bean1.setPaid_amt(""+paid);
				bean1.setDate(CoreData.getDateFormatAsUser(rs22.getString("date")));
				bean1.setVechicle_no(rs22.getString("vehicle_no"));
				bean1.setJob_card_no(rs22.getString("job_card_no"));
				bean1.setInvstatus(rs22.getString("invoice_done_status"));
			
			}
			bean1.setInvoice_no(rs11.getString("inv"));
			size++;
			//bean1.setSize(size);
			report.add(bean1);
			}
		
		return report;
	}

	public purchase_bean Print22(String invoiceno, String jobcardno) throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		int j1=0;
		int j9=0;
		purchase_bean bean = new purchase_bean();
		
		String	pref="HSL/TRI/REC";
		PreparedStatement preparedStatement11=con.prepareStatement("select  max(SUBSTRING(receiptno,-3)) as myval1 from receipt  where LENGTH(receiptno)>5 " );
		
		System.out.println("pre"+preparedStatement11);
		
		String mystr1="";
		int myval1=0;
	String	stringValue1="1";
					ResultSet resultSet11=preparedStatement11.executeQuery();
					if(resultSet11.next()){
						try{
						mystr1=resultSet11.getString("myval1");
						myval1=Integer.parseInt(mystr1);
						myval1=myval1+1;
						}catch (Exception e) {
							// TODO: handle exception
							myval1=1;
							mystr1="";
						}
					}	
		
				
					
					
					if(mystr1.equals("")){
						stringValue1=pref+"/000"+stringValue1;
						
					}else{
				
						if(String.valueOf(myval1).length()==1)
						{
							stringValue1=pref+"/000"+String.valueOf(myval1);
							
						}
						else if(String.valueOf(myval1).length()==2)
						{
							stringValue1=pref+"/00"+String.valueOf(myval1);
						}
						else if(String.valueOf(myval1).length()==3)
						{
							stringValue1=pref+"/0"+String.valueOf(myval1);
						}
						else
						{
							stringValue1=pref+"/"+String.valueOf(myval1);
						}
					}
					
					System.out.println(">>receiptno"+stringValue1);
		
		
					System.out.println(">>receiptno"+invoiceno);
		
					System.out.println(">>receiptno"+jobcardno);
		
		

		PreparedStatement preparedStatement1 = con
				.prepareStatement("insert into receipt (receiptno,invoiceno,date,jobcardno) values(?,?,?,?)");
		// purchase_bean bean = new purchase_bean();
		
		preparedStatement1.setString(1, stringValue1);
		preparedStatement1.setString(2,invoiceno);
		//Date dNo = new Date();
		
		 /* Calendar cal = Calendar.getInstance();*/
		DateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date dNow = new Date();
		//Date dNo = new Date();
		String date1=ft.format(dNow);
		preparedStatement1.setString(3,date1);
		preparedStatement1.setString(4,jobcardno);
		
		
		
		System.out.println("preparedStatement1 " + preparedStatement1);
		
		// System.out.println("preparedStatement1 " + preparedStatement1);
		System.out.println("receipt");
			j1 = preparedStatement1.executeUpdate();
		// System.out.println(preparedStatement3);
		// BigDecimal
			//System.out.println("receipt");
			PreparedStatement preparedStatement12 = con
			.prepareStatement("select * FROM invoice WHERE invoice_no=?");
			preparedStatement12.setString(1,invoiceno);
			//System.out.println("receipt"+preparedStatement12);
			ResultSet rs1=preparedStatement12.executeQuery();
			while(rs1.next()){
			
	// purchase_bean bean = new purchase_bean();
				String total="";
				
				try{
				
			 total=rs1.getString("paid_amount");
			 if(total.equalsIgnoreCase("")||total.equalsIgnoreCase(null))
			 {
				 total=""+0;
			 }
			// System.out.println("tottal1"+total);
				}
			catch (Exception e)
			{
				total=""+0;
				
			}
			 //System.out.println("tottal2"+total);
			
				String WholeNumber = "", Decimal = "";
				String StringOfOne = total;
				boolean isDecimal = false;
				
				int decimalIndex = StringOfOne.lastIndexOf(".");

				if (decimalIndex >= 0) {
					WholeNumber = StringOfOne.substring(0, decimalIndex);
					Decimal = StringOfOne.substring(decimalIndex + 1,
							StringOfOne.length())
							+ StringOfOne.substring(StringOfOne.length());

					// now you have the WholeNumber split up.
					isDecimal = true;
				} else {
					WholeNumber = total;
				}
				
				if (isDecimal) {
					String temp = " "
						+ AmtInWord.getAmtInWord(Integer
								.parseInt(WholeNumber));
					bean.setAmtinwords(temp.toUpperCase());

				} else {
					
					
					String temp = " "
						+ EnglishNumberToWords.convert(Integer
								.parseInt(total)) + "  only";
					bean.setAmtinwords(temp.toUpperCase());

				}
				
				
			
				bean.setTot(total);
				
				//System.out.println("total"+bean.getTot());
				bean.setDate(CoreData.getDateFormatAsUser(date1));
			bean.setPay_mode(rs1.getString("pay_mode"));
			//System.out.println("paymode"+bean.getPay_mode());
				bean.setJob_card_no(rs1.getString("job_card_no"));
				bean.setBank(rs1.getString("bankname"));
				bean.setBillno(invoiceno);
				bean.setRecidno(stringValue1);
				bean.setCHEQUENO(rs1.getString("check_no"));
				PreparedStatement preparedStatement123 = con
				.prepareStatement("select * FROM job_card WHERE job_card_no=?");
				preparedStatement123.setString(1,jobcardno);
				
				ResultSet rs12=preparedStatement123.executeQuery();
				
				while(rs12.next()){
					
					bean.setCustomername(rs12.getString("customer_name"));
					
					
				}
				}
	
			PreparedStatement preparedStatement144 = con
			.prepareStatement("update invoice set invoice_done_status='1' where invoice_no=?");
	// purchase_bean bean = new purchase_bean();
	
		
	preparedStatement144.setString(1,invoiceno);
	//Date dNo = new Date();
	
	 /* Calendar cal = Calendar.getInstance();*/
	
	
	
	
	//System.out.println("preparedStatement1 " + preparedStatement144);
	
	// System.out.println("preparedStatement1 " + preparedStatement1);
	//System.out.println("receipt");
	j9 = preparedStatement144.executeUpdate();
	
			
	return bean;
}

	public purchase_bean Print44(String invoiceno, String jobcardno) throws Exception {
		// TODO Auto-generated method stub
		
		
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		purchase_bean bean = new purchase_bean();
		
		/*String	pref="TRI/REC";
		PreparedStatement preparedStatement11=con.prepareStatement("select  max(SUBSTRING(receiptno,-3)) as myval1 from receipt  where LENGTH(receiptno)>5 " );
		
		System.out.println("pre"+preparedStatement11);
		
		String mystr1="";
		int myval1=0;
	String	stringValue1="1";
					ResultSet resultSet11=preparedStatement11.executeQuery();
					if(resultSet11.next()){
						try{
						mystr1=resultSet11.getString("myval1");
						myval1=Integer.parseInt(mystr1);
						myval1=myval1+1;
						}catch (Exception e) {
							// TODO: handle exception
							myval1=1;
							mystr1="";
						}
					}	
		
				
					
					
					if(mystr1.equals("")){
						stringValue1=pref+"/000"+stringValue1;
						
					}else{
				
						if(String.valueOf(myval1).length()==1)
						{
							stringValue1=pref+"/000"+String.valueOf(myval1);
							
						}
						else if(String.valueOf(myval1).length()==2)
						{
							stringValue1=pref+"/00"+String.valueOf(myval1);
						}
						else if(String.valueOf(myval1).length()==3)
						{
							stringValue1=pref+"/0"+String.valueOf(myval1);
						}
						else
						{
							stringValue1=pref+"/"+String.valueOf(myval1);
						}
					}
					
					System.out.println(">>receiptno"+stringValue1);
*/		
		
		String mystr1="";	
PreparedStatement preparedStatement11=con.prepareStatement("select  * from receipt  where invoiceno=? " );
preparedStatement11.setString(1,invoiceno);
		System.out.println("pre"+preparedStatement11);
	
					ResultSet resultSet11=preparedStatement11.executeQuery();
					if(resultSet11.next()){
						try{
						mystr1=resultSet11.getString("receiptno");
					
						}catch (Exception e) {
							// TODO: handle exception
							mystr1="";
		
		
						}
						bean.setRecidno(mystr1);
					}
						//System.out.println(">>receiptno"+mystr1);
					
		
		
		
		
					System.out.println(">>receiptno"+invoiceno);
		
					System.out.println(">>receiptno"+jobcardno);
		
		
/*
		PreparedStatement preparedStatement1 = con
				.prepareStatement("insert into receipt (receiptno,invoiceno,date,jobcardno) values(?,?,?,?)");
		// purchase_bean bean = new purchase_bean();
		
		preparedStatement1.setString(1, stringValue1);
		preparedStatement1.setString(2,invoiceno);
		//Date dNo = new Date();
		
		  Calendar cal = Calendar.getInstance();
		DateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date dNow = new Date();
		//Date dNo = new Date();
		String date1=ft.format(dNow);
		preparedStatement1.setString(3,date1);
		preparedStatement1.setString(4,jobcardno);
		
		
		
		System.out.println("preparedStatement1 " + preparedStatement1);*/
	
		// System.out.println("preparedStatement1 " + preparedStatement1);
		//System.out.println("receipt");
		
		Calendar cal = Calendar.getInstance();
		DateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date dNow = new Date();
		//Date dNo = new Date();
		String date1=ft.format(dNow);
		
		
			//j1 = preparedStatement1.executeUpdate();
		// System.out.println(preparedStatement3);
		// BigDecimal
			//System.out.println("receipt");
			PreparedStatement preparedStatement12 = con
			.prepareStatement("select * FROM invoice WHERE invoice_no=?");
			preparedStatement12.setString(1,invoiceno);
			//System.out.println("receipt"+preparedStatement12);
			ResultSet rs1=preparedStatement12.executeQuery();
			while(rs1.next()){
			
	// purchase_bean bean = new purchase_bean();
				String total="";
				
				try{
				
			 total=rs1.getString("paid_amount");
			 if(total.equalsIgnoreCase("")||total.equalsIgnoreCase(null))
			 {
				 total=""+0;
			 }
			// System.out.println("tottal1"+total);
				}
			catch (Exception e)
			{
				total=""+0;
				
			}
			 //System.out.println("tottal2"+total);
			
				String WholeNumber = "", Decimal = "";
				String StringOfOne = total;
				boolean isDecimal = false;
				
				int decimalIndex = StringOfOne.lastIndexOf(".");

				if (decimalIndex >= 0) {
					WholeNumber = StringOfOne.substring(0, decimalIndex);
					Decimal = StringOfOne.substring(decimalIndex + 1,
							StringOfOne.length())
							+ StringOfOne.substring(StringOfOne.length());

					// now you have the WholeNumber split up.
					isDecimal = true;
				} else {
					WholeNumber = total;
				}
				
				if (isDecimal) {
					String temp = " "
						+ AmtInWord.getAmtInWord(Integer
								.parseInt(WholeNumber));
					bean.setAmtinwords(temp.toUpperCase());

				} else {
					
					
					String temp = " "
						+ EnglishNumberToWords.convert(Integer
								.parseInt(total)) + "  only";
					bean.setAmtinwords(temp.toUpperCase());

				}
				
				
			
				bean.setTot(total);
				
				//System.out.println("total"+bean.getTot());
				bean.setDate(CoreData.getDateFormatAsUser(date1));
			bean.setPay_mode(rs1.getString("pay_mode"));
			//System.out.println("paymode"+bean.getPay_mode());
				bean.setJob_card_no(rs1.getString("job_card_no"));
				bean.setBank(rs1.getString("bankname"));
				bean.setBillno(invoiceno);
				//bean.setRecidno(stringValue1);
				
				bean.setCHEQUENO(rs1.getString("check_no"));
				
				PreparedStatement preparedStatement123 = con
				.prepareStatement("select * FROM job_card WHERE job_card_no=?");
				preparedStatement123.setString(1,jobcardno);
				
				ResultSet rs12=preparedStatement123.executeQuery();
				
				while(rs12.next()){
					
					bean.setCustomername(rs12.getString("customer_name"));
					
					
				}
				}
	
		
			
	return bean;

		
		
		
		
	}

	public List<purchase_bean> out221() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con
		.prepareStatement("select DISTINCT invoice_no as inv  from invoice where  Cast( remaining_amount as DECIMAL(10,2)) > 0");
// purchase_bean bean = new purchase_bean();
System.out.println("preparedStatement1 " + preparedStatement1);

// System.out.println("preparedStatement1 " + preparedStatement1);

ResultSet rs112 = preparedStatement1.executeQuery();
// System.out.println(preparedStatement3);
// BigDecimal totalamount = BigDecimal.ZERO;
String jobcarno = "";Double totos=0.0;
while (rs112.next()) {
	purchase_bean bean1 = new purchase_bean();
	// bean.setInvoice_no(rs11.getString("inv"));

	PreparedStatement preparedStatement2 = con
			.prepareStatement("select invoice_no,vehicle_no,job_card_no,total,paid_amount,smsstatus, remaining_amount FROM invoice WHERE invoice_no=? ");
	preparedStatement2.setString(1, rs112.getString("inv"));

		/*PreparedStatement preparedStatement3 = con
				.prepareStatement("select invoice_no,vehicle_no,job_card_no,total,paid_amount from invoice where  total > paid_amount");*/
		purchase_bean bean;
		/*preparedStatement3.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement3.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));*/
		System.out.println(preparedStatement2 + "preparedStatement3");

		ResultSet rs11 = preparedStatement2.executeQuery();
		//System.out.println(preparedStatement3);
		String total_amount="";
		String paid_amount="";
		String total_amount2="";
		String paid_amount2="";
		String balance_amount2="";
		double total_amount1=0.0;
		double paid_amount1=0.0;
		double balance_amount1=0.0;
		
		while (rs11.next()) {
			bean = new purchase_bean();
			//int dur = rs11.getInt("duration");
		//	bean.setSale_date(rs11.getString(1));
			bean.setInvoice_no(rs11.getString(1));
			
			bean.setJob_card_no(rs11.getString(3));
			//bean.setTot(rs11.getString(4));
			//bean.setPaid_amt(rs11.getString(5));
			total_amount=rs11.getString(4);
			paid_amount=rs11.getString(5);
			try{
				if( !rs11.getString("remaining_amount").equals("") && !rs11.getString("remaining_amount").equals(null))
				{
					paid_amount1=Double.parseDouble(rs11.getString("remaining_amount"));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("paidamt"+paid_amount1); 
			
			try{
				if( !rs11.getString("total").equals("") && !rs11.getString("total").equals(null))
				{
					total_amount1=Double.parseDouble(rs11.getString("total"));
				}
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			//paid_amount1 = Double.parseDouble(paid_amount);
			//total_amount1=Double.parseDouble(total_amount);
			balance_amount1=(paid_amount1);
			System.out.println("balance_amount1"+balance_amount1);
			total_amount2=""+total_amount1;
			paid_amount2=""+paid_amount1;
			balance_amount2=""+ Math.round(balance_amount1);
		
			bean.setTot(total_amount2);
			bean.setPaid_amt(paid_amount2);
			bean.setBalance_amount(balance_amount2);
			bean.setBank(rs11.getString("smsstatus"));
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select cust_name,cust_address,mobile_no from customer_master where cust_id=?");
			preparedStatement4.setString(1, rs11.getString(2));
			System.out.println("preparedStatement4"+preparedStatement4);
			ResultSet rs22 = preparedStatement4.executeQuery();
			if (rs22.next()) {
				bean.setCust_name(rs22.getString(1));
				bean.setCust_address(rs22.getString(2));
				bean.setMobile_no(rs22.getString(3));
				
			}
			System.out.println( "done os");
			bean.setVechicle_no(rs11.getString(2));
			
			
			
			/*SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar input_cal = new GregorianCalendar();
			Calendar tempcal1 = new GregorianCalendar();
			Calendar tempcal2 = new GregorianCalendar();

			int input_year = 0;
			int input_month = 0;
			int input_date = 0;
			String fromdate = null;
			try {
				fromdate = bean.getAmc_date();
				// System.out.println("fromdate " + fromdate + ">>>>>" +
				// fromdate);
				input_year = Integer.parseInt(fromdate.substring(0, 4));
				// System.out.println("input_year "+input_year);
				input_month = Integer.parseInt(fromdate.substring(5, 7));
				// System.out.println("input_month "+input_month);
				input_date = Integer.parseInt(fromdate.substring(8, 10));
				// System.out.println("input_date "+input_date);
*/
			
			report.add(bean);
			} 
			
}
		
		
		return report;
		

	}

	
	//Method To Insert Customer Payment
	
	public purchase_bean insertcustpayment(purchase_bean psb) throws SQLException {
		// TODO Auto-generated method stub
		double ppamount=0.0;
		double paybycash49=0.0;
		double paybycheque49=0.0;
		double paybycredit49=0.0;
		String ppamount1="";
		
		double payamount=0.0;
		String payamount1="";
		//String payamount1="";
		double totalpayamount=0.0;
		String totalpayamount1="";
		System.out.println("totalpayamount"+totalpayamount);
		
		int len=0;
		
		
		String stringValue="";
		
		String amtpert="";
		
		
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		
		// Bill Number Generation For Customer Credit Debit
		
		
		int len1=0;
		PreparedStatement preparedStatement1x=con.prepareStatement("SELECT * FROM  customercreditdebit");

		ResultSet resultSet1x=preparedStatement1x.executeQuery();
		while(resultSet1x.next()){
			len1++;
		}	

		int size=len1+1;
		stringValue=String.valueOf(size);
		
		 String ap="CP";
		
		
		
		if(stringValue.length()==1)
		{
			stringValue="HSL/RCP/"+ap+"/000"+stringValue;
		}
		else if(stringValue.length()==2)
		{
			stringValue="HSL/RCP/"+ap+"/00"+stringValue;
		}
		else if(stringValue.length()==3)
		{
			stringValue="HSL/RCP/"+ap+"/0"+stringValue;
		}
		else
		{
			stringValue="HSL/RCP/"+ap+"/"+stringValue;
		}

		

		psb.setBillno(stringValue);

		
	
		
		PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,customername,customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		try {
			pstcx9.setString(1, psb.getIccr_no());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pstcx9.setString(1,"");
		}
		
		
		pstcx9.setString(2, psb.getCust_name());
		
		try {
			pstcx9.setString(3,psb.getAddress());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			pstcx9.setString(3,"");
		}
		
		
		pstcx9.setString(13,CoreData.getDateFormatAsDb(psb.getDate()));
		pstcx9.setString(14,psb.getBillno());
		
		if (psb.getPaymod().trim().equals("CASH")) {
			String paybycash=psb.getNet_amount();
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			pstcx9.setString(4,paybycash );
			pstcx9.setString(5,psb.getPaymod());
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			pstcx9.setString(10, paybycash);
			pstcx9.setString(11, "");
			pstcx9.setString(12, "");
			
		
	}
	else if (psb.getPaymod().equalsIgnoreCase("CHEQUE")) {
		String paybycash=psb.getCheque_amt();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
	pstcx9.setString(6, CoreData.getDateFormatAsDb(psb.getCheque_date()));
				
		
		pstcx9.setString(7, psb.getCheque_no());
		pstcx9.setString(8,"");
		pstcx9.setString(9,"");
		pstcx9.setString(11, paybycash);
		pstcx9.setString(10, "");
		pstcx9.setString(12, "");
	
	}
	
	else if (psb.getPaymod().equalsIgnoreCase("CREDIT")) {
		
		String paybycash=psb.getNet_amountcard();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,psb.getCardid());
		pstcx9.setString(9,"");
		pstcx9.setString(12, paybycash);
		//payamount1 = amb.getNet_amountcard();
		pstcx9.setString(11, "");
		pstcx9.setString(10, "");
	}
		
else if (psb.getPaymod().equalsIgnoreCase("INSURANCE")) {
		
		String paybycash= psb.getPaid_amt22();
		
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;

		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,"");
		pstcx9.setString(9,psb.getInsurance());
		pstcx9.setString(10, "");
		pstcx9.setString(11, "");
		pstcx9.setString(12, "");

		//payamount1 = amb.getNet_amountcard();

	}
	
		else if (psb.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
			
			String paybycash= psb.getPaid_amt();
			
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			
			
			String ppmode="";
			if (psb.getR1().equalsIgnoreCase("partpaymentcash"))
			{
				ppmode=psb.getR1()+"~"+"CASH";
				pstcx9.setString(10, ""+paybycash);
				pstcx9.setString(11, "0");
				pstcx9.setString(12, "0");
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				ppmode=psb.getR1()+"~"+"CHEQUE";
				pstcx9.setString(11, ""+paybycash);
				pstcx9.setString(10, "0");
				pstcx9.setString(12, "0");
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				ppmode=psb.getR1()+"~"+"CARD";
				pstcx9.setString(10,"0");
				
				pstcx9.setString(11, "0");
				pstcx9.setString(12, ""+paybycash);
				
			}
			else
			{
				ppmode=psb.getPaymod();
				pstcx9.setString(10,"0");
				
				pstcx9.setString(11, "0");
				pstcx9.setString(12,"0");
			}
			

			pstcx9.setString(5, ppmode);
		
			
			pstcx9.setString(4,paybycash );
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			/*pstcx9.setString(10, "");
			pstcx9.setString(11, "");
			pstcx9.setString(12, "");*/

			//payamount1 = amb.getNet_amountcard();

		}
	

		else if (psb.getPaymod().equalsIgnoreCase("CARDANDCASH")) {
			
			String paybycash= psb.getCashhh();
			String credit=psb.getCarddd();
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			pstcx9.setString(4,paybycash );
			pstcx9.setString(5,psb.getPaymod());
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			pstcx9.setString(10, paybycash);
			pstcx9.setString(11, "");
			pstcx9.setString(12, credit);

			//payamount1 = amb.getNet_amountcard();

		}
		
		
	else{
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setString(4,"" );
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,"");
		pstcx9.setString(9,"");
		pstcx9.setString(10, "");
		pstcx9.setString(11, "");
		pstcx9.setString(12, "");
	}
			

		System.out.println("q4"+pstcx9);
	
		int j9 = pstcx9.executeUpdate();	
		
		
		
	
		// Insert into Customer Credit Debit
		
			
		
		PreparedStatement pstcx99 = con.prepareStatement("INSERT INTO customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)");
		
		
		pstcx99.setString(1,psb.getCust_id());
		pstcx99.setString(2,CoreData.getDateFormatAsDb(psb.getDate()));
		
		pstcx99.setString(3,psb.getBillno());
		pstcx99.setString(4,"Customer Payment");
		
		pstcx99.setString(5,"202");
		pstcx99.setString(6,"Credit");
		pstcx99.setString(8,psb.getCust_name());
		
		
		if (psb.getPaymod().trim().equals("CASH")) {
			String paybycash=psb.getNet_amount();

			pstcx99.setString(7,paybycash );
						
		
	}
	else if (psb.getPaymod().equalsIgnoreCase("CHEQUE")) {
		String paybycash=psb.getCheque_amt();
	
		pstcx99.setString(7,paybycash );
				
		
		
	
	}
	
	else if (psb.getPaymod().equalsIgnoreCase("CREDIT")) {
		
		String paybycash=psb.getNet_amountcard();
	
		pstcx99.setString(7,paybycash );
		
	}
		

	
		else if (psb.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
			
			String paybycash= psb.getPaid_amt();
			
			
			
			
			String ppmode="";
			if (psb.getR1().equalsIgnoreCase("partpaymentcash"))
			{
			
				pstcx99.setString(7,paybycash);
				
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				
				pstcx99.setString(7,paybycash);
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				
				pstcx99.setString(7,paybycash);
				
			}
			else
			{
			
				pstcx99.setString(7,"0");
			}
			

		}
	

		

		System.out.println("q4"+pstcx9);
	
		int j7 = pstcx99.executeUpdate();	
		if ( j7 > 0 || j9 > 0) {
			psb.setResponse("success");
		} else {
			psb.setResponse("fail");

		}
		return psb;
		
		
		
	}
	
	
	

	public List<purchase_bean> purchasereport() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con
		.prepareStatement("select * from purchase_order");

System.out.println("preparedStatement1 " + preparedStatement1);
ResultSet rs112 = preparedStatement1.executeQuery();

String jobcarno = "";Double totos=0.0;
while (rs112.next()) {
	
		purchase_bean bean;
			
			bean = new purchase_bean();
			
			bean.setInvoice_no(rs112.getString("invoice_no"));
	
			bean.setCust_name(rs112.getString("vehicle_no"));
			bean.setPanno(rs112.getString("pono"));
			try{
			bean.setDate(CoreData.getDateFormatAsUser(rs112.getString("date")));
			}catch(Exception e){
				
			}
			
			
			bean.setTot(rs112.getString("total"));
			
			
			PreparedStatement preparedStatement12 = con
					.prepareStatement("select * from customer_master where cust_id=?    ");
			preparedStatement12.setString(1, rs112.getString("vehicle_no"));
		
			ResultSet resultSet1 = preparedStatement12.executeQuery();
			System.out.println(preparedStatement12);
			if (resultSet1.next()) {
				bean.setCustomername(resultSet1.getString("cust_name"));
			
			}
				
			
			
			report.add(bean);
			
			
}
		
		
		return report;
	}

	public purchase_bean viewpo(String pono) throws SQLException {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		purchase_bean bean = new purchase_bean();
		List<String> description = new ArrayList<String>();
		List<String> partno = new ArrayList<String>();
		List<String> qty = new ArrayList<String>();
		List<String> myrate = new ArrayList<String>();
		List<String> myamt = new ArrayList<String>();
		List<String> hsncode = new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		
		List<String> grate1 = new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		
		List<String> grate2 = new ArrayList<String>();
		List<String> gstamt2 = new ArrayList<String>();
		List<String> netamt = new ArrayList<String>();
		PreparedStatement pst1 = con
				.prepareStatement("select  * from purchase_order  where invoice_no=?"); 
				pst1.setString(1,pono);
				System.out.println("pst8888....."+pst1);

				ResultSet rs11 = pst1.executeQuery();
				if (rs11.next()) {
					//	bean = new Area_Master_Bean();
					bean.setCust_name(rs11.getString("vehicle_no"));
					
					bean.setPono(rs11.getString("pono"));
					
					System.out.println(">>>>>>>>>");
					PreparedStatement pst1x = con
							.prepareStatement("select  * from customer_master  where cust_id=?"); 
							pst1x.setString(1,rs11.getString("vehicle_no"));
							

							ResultSet rs11x = pst1x.executeQuery();
							if (rs11x.next()) {
							bean.setCustomer_Name(rs11x.getString("cust_name"));
							bean.setGstnno(rs11x.getString("company_vat"));
							bean.setPanno(rs11x.getString("vehicle_no"));
							bean.setState(rs11x.getString("eng_no"));
							bean.setCity(rs11x.getString("battery_no"));
							bean.setMobile(rs11x.getString("mobile_no"));
							bean.setPendamt("");
							bean.setCust_name(rs11.getString("vehicle_no"));
						
							bean.setBillno(rs11.getString("invoice_no"));	
							}
							
							bean.setMydate(CoreData.getDateFormatAsUser(rs11.getString("date")));
							bean.setPayeterm(rs11.getString("termcond"));
							bean.setTotal(rs11.getString("total"));
							
							PreparedStatement pst122 = con
									.prepareStatement("select * from purchase_order_details  where invoice_no=?");
									
									pst122.setString(1,pono);
									
							System.out.println("pst122......." + pst122);
							String btype = "";
							
							ResultSet rs122 = pst122.executeQuery();
							
							int mysize=0;
							while (rs122.next()) {
							
								
								description.add(rs122.getString("descrip"));
								qty.add(rs122.getString("qty"));
								 partno.add(rs122.getString("partno"));
						
								 myrate.add(rs122.getString("rate"));
								 myamt.add(rs122.getString("amt"));
								 hsncode.add(rs122.getString("type_name"));
								 disc.add(rs122.getString("disc"));
								 discamt.add(rs122.getString("discamt"));
								
								 grate1.add(rs122.getString("cgstrate"));
								 gstamt1.add(rs122.getString("cgstamount"));
								
								 grate2.add(rs122.getString("sgstrate"));
								 gstamt2.add(rs122.getString("sgstamount"));
								 netamt.add(rs122.getString("net_amt"));
							
								mysize++;
							

									
									
							
							}
							
							
							bean.setMysize(mysize);	
							bean.setDescription(description);
							bean.setPartno(partno);
							bean.setQty(qty);
							bean.setMyrate(myrate);
							bean.setMyamt(myamt);
							bean.setHsncode(hsncode);
							bean.setDisc(discamt);
							bean.setDiscamt(discamt);
							bean.setGrate1(grate1);
							bean.setGstamt1(gstamt1);
							bean.setGrate2(grate2);
							bean.setGstamt2(gstamt2);
							bean.setNetamt(netamt);
							
							
				}
		
		
		return bean;
		
	}
	
	
	
	
	// Method For Stock Report
	
	public List<purchase_bean> StockReport()
			throws Exception {
		// TODO Auto-generated method stub

		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select *  from ho_bulk_spare_stockv ");
		
		System.out.println("SQL:"+preparedStatement1);
		ResultSet rs11 = preparedStatement1.executeQuery();
		purchase_bean bean =null;
		while (rs11.next()) {
		 bean = new purchase_bean();
			
		 bean.setSpare(rs11.getString("spare_code"));
		bean.setQty1(rs11.getString("spare_qty"));
		bean.setUnit(rs11.getString("unit"));
		
		report.add(bean);
			
				}

			
		return report;

	}
	
	
	public purchase_bean insert(purchase_bean psb) throws SQLException {
		// TODO Auto-generated method stub
		int j3=0;
		int j4=0;
		int j5=0;
		int j9=0;
		
		double ppamount=0.0;
		double paybycash49=0.0;
		double paybycheque49=0.0;
		double paybycredit49=0.0;
		String ppamount1="";
		
		double payamount=0.0;
		String payamount1="";
		//String payamount1="";
		double totalpayamount=0.0;
		String totalpayamount1="";
		System.out.println("totalpayamount"+totalpayamount);
		
		int len=0;
		
		
		String stringValue="";
		
		String amtpert="";
		
		
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		
	
	System.out.println("...1");
		//payamount = Double.parseDouble(payamount1);
		ppamount1=psb.getPpamount();
		System.out.println("amount"+ppamount1);
		
		System.out.println("...2");
		try{
		ppamount = Double.parseDouble(ppamount1);
		}catch(Exception e){
			ppamount=0.0;	
			
		}
		PreparedStatement pstcx49 = con
		.prepareStatement("select   paybycash,paybycheque,paybycredit from  invoice  where invoice_no='"
				+ psb.getIccr_no()+ "'");
		
		ResultSet resultSet49 = pstcx49.executeQuery();
		
		if (resultSet49.next()) {
			try{
			paybycash49= Double.parseDouble(resultSet49.getString("paybycash"));
			
			}catch(Exception e){
					
				
			}try{
			paybycheque49= Double.parseDouble(resultSet49.getString("paybycheque"));
			}catch(Exception e){
				ppamount=0.0;	
				
			}
			
			try{
			paybycredit49= Double.parseDouble(resultSet49.getString("paybycredit"));
			}catch(Exception e){
				ppamount=0.0;	
				
			}
		}
		
		
		
		PreparedStatement pstcx4 = con
		.prepareStatement("update  invoice  set paid_amount=? ,paybycash=?,paybycheque=?,paybycredit=?  where invoice_no='"
				+ psb.getIccr_no()+ "'");
		if (psb.getPaymod().trim().equals("CASH")) {
			String paybycash=psb.getNet_amount();
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
		
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			pstcx4.setString(1,totpaybycash22 );
			double totpaybycash2=0.0;
			totpaybycash2=(paybycash49+paybycash1);
			String totpaybycash44="";
			String totpaybycheque44=""+paybycheque49;
			String totpaybycredit44=""+paybycredit49;
			totpaybycash44=""+totpaybycash2;
			pstcx4.setString(2,totpaybycash44 );
			pstcx4.setString(3,totpaybycheque44 );
			pstcx4.setString(4,totpaybycredit44);
		
		
	}
	else if (psb.getPaymod().equalsIgnoreCase("CHEQUE")) {
		String paybycash=psb.getCheque_amt();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx4.setString(1,totpaybycash22 );
		double totpaybycash2=0.0;
		totpaybycash2=(paybycheque49+paybycash1);
		String totpaybycash44="";
		totpaybycash44=""+totpaybycash2;
		String totpaybycheque44=""+paybycash49;
		String totpaybycredit44=""+paybycredit49;
		pstcx4.setString(2,totpaybycheque44 );
		pstcx4.setString(3,totpaybycash44 );
		pstcx4.setString(4,totpaybycredit44);
	
		
		
	
	}
	
	else if (psb.getPaymod().equalsIgnoreCase("CREDIT")) {
		
		String paybycash=psb.getNet_amountcard();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx4.setString(1,totpaybycash22 );
		double totpaybycash2=0.0;
		totpaybycash2=(paybycredit49+paybycash1);
		String totpaybycash44="";
		totpaybycash44=""+totpaybycash2;
		
		String totpaybycheque44=""+paybycash49;
		String totpaybycredit44=""+paybycheque49;
		pstcx4.setString(2,totpaybycheque44 );
		pstcx4.setString(4,totpaybycash44 );
		pstcx4.setString(3,totpaybycredit44);
	
		

		//payamount1 = amb.getNet_amountcard();

	}

	else if (psb.getPaymod().equalsIgnoreCase("INSURANCE")) {
	
	String paybycash= psb.getPaid_amt22();
	
	String totpaybycash22="";
	double paybycash1=0.0;
	paybycash1=Double.parseDouble(paybycash);
	double totpaybycash1=0.0;
	totpaybycash1=(ppamount+paybycash1);
	totpaybycash22=""+totpaybycash1;
	pstcx4.setString(1,totpaybycash22 );

	

	//payamount1 = amb.getNet_amountcard();

}

	else if (psb.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
		
		String paybycash= psb.getPaid_amt();
		
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx4.setString(1,totpaybycash22 );
		
		String ppmode="";
		if (psb.getR1().equalsIgnoreCase("partpaymentcash"))
		{
			double totpaybycash2=0.0;
			totpaybycash2=(paybycash49+paybycash1);
			String totpaybycash44="";
			totpaybycash44=""+totpaybycash2;
			pstcx4.setString(2,totpaybycash44 );
			String totpaybycheque44=""+paybycredit49;
			String totpaybycredit44=""+paybycheque49;
			pstcx4.setString(3,totpaybycredit44 );
			pstcx4.setString(4,totpaybycheque44 );
		
			
		}
		else if (psb.getR1().equalsIgnoreCase("partpaymentcheque"))
		{
			
			
			double totpaybycash2=0.0;
			totpaybycash2=(paybycheque49+paybycash1);
			String totpaybycash44="";
			totpaybycash44=""+totpaybycash2;
			String totpaybycheque44=""+paybycash49;
			String totpaybycredit44=""+paybycredit49;
			
			pstcx4.setString(2,totpaybycheque44 );
			pstcx4.setString(3,totpaybycash44 );
			pstcx4.setString(4,totpaybycredit44);
		
			
		}
		else if (psb.getR1().equalsIgnoreCase("partpaymentcard"))
		{
			
			double totpaybycash2=0.0;
			totpaybycash2=(paybycredit49+paybycash1);
			String totpaybycash44="";
			totpaybycash44=""+totpaybycash2;
			String totpaybycheque44=""+paybycash49;
			String totpaybycredit44=""+paybycheque49;
			pstcx4.setString(2,totpaybycheque44 );
			pstcx4.setString(4,totpaybycash44 );
			pstcx4.setString(3,totpaybycredit44 );
		
			
		}
		else
		{
			
			pstcx4.setString(2,"0" );
			pstcx4.setString(4,"0" );
			pstcx4.setString(3,"0" );
		}
		
	
		

		//payamount1 = amb.getNet_amountcard();

	}


	else if (psb.getPaymod().equalsIgnoreCase("CARDANDCASH")) {
		
		String paybycash= psb.getCashhh();
		String caerd= psb.getCarddd();
		String totpaybycash22="";
		double paybycash1=0.0;
		double paybycash12=0.0;
		paybycash1=Double.parseDouble(paybycash);
		paybycash12=Double.parseDouble(caerd);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1+paybycash12);
		totpaybycash22=""+totpaybycash1;
		pstcx4.setString(1,totpaybycash22 );
		double totpaybycash2=0.0;
		totpaybycash2=(paybycash49+paybycash1);
		String totpaybycash44="";
		totpaybycash44=""+totpaybycash2;
		pstcx4.setString(2,totpaybycash44 );
		String totpaybycredit44=""+paybycheque49;
		pstcx4.setString(3,totpaybycredit44);
		double totpaybycash29=0.0;
		totpaybycash29=(paybycredit49+paybycash12);
		String totpaybycash4499="";
		totpaybycash4499=""+totpaybycash29;
		
		
		pstcx4.setString(4,totpaybycash4499 );
	
		

		//payamount1 = amb.getNet_amountcard();

	}


		
		System.out.println("q2"+pstcx4);
		
		
		
		
		j4 = pstcx4.executeUpdate();
		
		
		
		// Bill Number Generation For Customer Credit Debit
		
		
		int len1=0;
		PreparedStatement preparedStatement1x=con.prepareStatement("SELECT * FROM  customercreditdebit");

		ResultSet resultSet1x=preparedStatement1x.executeQuery();
		while(resultSet1x.next()){
			len1++;
		}	

		int size=len+1;
		stringValue=String.valueOf(size);
		
		 String ap="CP";
		
		
		
		if(stringValue.length()==1)
		{
			stringValue="HSL/RCP/"+ap+"/000"+stringValue;
		}
		else if(stringValue.length()==2)
		{
			stringValue="HSL/RCP/"+ap+"/00"+stringValue;
		}
		else if(stringValue.length()==3)
		{
			stringValue="HSL/RCP/"+ap+"/0"+stringValue;
		}
		else
		{
			stringValue="HSL/RCP/"+ap+"/"+stringValue;
		}

		

		psb.setBillno(stringValue);

		
	
		
		PreparedStatement pstcx9 = con.prepareStatement("insert into customerpayment(Invoiceno,customername,customeraddress,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,date,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		pstcx9.setString(1, psb.getIccr_no());
		pstcx9.setString(2, psb.getCust_name());
		pstcx9.setString(3,psb.getAddress());
		pstcx9.setString(13,CoreData.getDateFormatAsDb(psb.getDate()));
		pstcx9.setString(14,psb.getBillno());
		
		if (psb.getPaymod().trim().equals("CASH")) {
			String paybycash=psb.getNet_amount();
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			pstcx9.setString(4,paybycash );
			pstcx9.setString(5,psb.getPaymod());
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			pstcx9.setString(10, paybycash);
			pstcx9.setString(11, "");
			pstcx9.setString(12, "");
			
		
	}
	else if (psb.getPaymod().equalsIgnoreCase("CHEQUE")) {
		String paybycash=psb.getCheque_amt();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
	pstcx9.setString(6, CoreData.getDateFormatAsDb(psb.getCheque_date()));
				
		
		pstcx9.setString(7, psb.getCheque_no());
		pstcx9.setString(8,"");
		pstcx9.setString(9,"");
		pstcx9.setString(11, paybycash);
		pstcx9.setString(10, "");
		pstcx9.setString(12, "");
	
	}
	
	else if (psb.getPaymod().equalsIgnoreCase("CREDIT")) {
		
		String paybycash=psb.getNet_amountcard();
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;
		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,psb.getCardid());
		pstcx9.setString(9,"");
		pstcx9.setString(12, paybycash);
		//payamount1 = amb.getNet_amountcard();
		pstcx9.setString(11, "");
		pstcx9.setString(10, "");
	}
		
else if (psb.getPaymod().equalsIgnoreCase("INSURANCE")) {
		
		String paybycash= psb.getPaid_amt22();
		
		String totpaybycash22="";
		double paybycash1=0.0;
		paybycash1=Double.parseDouble(paybycash);
		double totpaybycash1=0.0;
		totpaybycash1=(ppamount+paybycash1);
		totpaybycash22=""+totpaybycash1;

		pstcx9.setString(4,paybycash );
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,"");
		pstcx9.setString(9,psb.getInsurance());
		pstcx9.setString(10, "");
		pstcx9.setString(11, "");
		pstcx9.setString(12, "");

		//payamount1 = amb.getNet_amountcard();

	}
	
		else if (psb.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
			
			String paybycash= psb.getPaid_amt();
			
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			
			
			String ppmode="";
			if (psb.getR1().equalsIgnoreCase("partpaymentcash"))
			{
				ppmode=psb.getR1()+"~"+"CASH";
				pstcx9.setString(10, ""+paybycash);
				pstcx9.setString(11, "0");
				pstcx9.setString(12, "0");
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				ppmode=psb.getR1()+"~"+"CHEQUE";
				pstcx9.setString(11, ""+paybycash);
				pstcx9.setString(10, "0");
				pstcx9.setString(12, "0");
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				ppmode=psb.getR1()+"~"+"CARD";
				pstcx9.setString(10,"0");
				
				pstcx9.setString(11, "0");
				pstcx9.setString(12, ""+paybycash);
				
			}
			else
			{
				ppmode=psb.getPaymod();
				pstcx9.setString(10,"0");
				
				pstcx9.setString(11, "0");
				pstcx9.setString(12,"0");
			}
			

			pstcx9.setString(5, ppmode);
		
			
			pstcx9.setString(4,paybycash );
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			/*pstcx9.setString(10, "");
			pstcx9.setString(11, "");
			pstcx9.setString(12, "");*/

			//payamount1 = amb.getNet_amountcard();

		}
	

		else if (psb.getPaymod().equalsIgnoreCase("CARDANDCASH")) {
			
			String paybycash= psb.getCashhh();
			String credit=psb.getCarddd();
			String totpaybycash22="";
			double paybycash1=0.0;
			paybycash1=Double.parseDouble(paybycash);
			double totpaybycash1=0.0;
			totpaybycash1=(ppamount+paybycash1);
			totpaybycash22=""+totpaybycash1;
			pstcx9.setString(4,paybycash );
			pstcx9.setString(5,psb.getPaymod());
			pstcx9.setNull(6,java.sql.Types.DATE);
			pstcx9.setString(7, "");
			pstcx9.setString(8,"");
			pstcx9.setString(9,"");
			pstcx9.setString(10, paybycash);
			pstcx9.setString(11, "");
			pstcx9.setString(12, credit);

			//payamount1 = amb.getNet_amountcard();

		}
		
		
	else{
		pstcx9.setString(5,psb.getPaymod());
		pstcx9.setString(4,"" );
		pstcx9.setNull(6,java.sql.Types.DATE);
		pstcx9.setString(7, "");
		pstcx9.setString(8,"");
		pstcx9.setString(9,"");
		pstcx9.setString(10, "");
		pstcx9.setString(11, "");
		pstcx9.setString(12, "");
	}
			

		System.out.println("q4"+pstcx9);
	
		j9 = pstcx9.executeUpdate();	
		
		
		
		
		// Insert into Customer Credit Debit
		
		
		PreparedStatement pstcx = con
				.prepareStatement("select  * from  customer_master  where cust_name='"+ psb.getCust_name()+ "'");
				System.out.println("SQL:"+pstcx);
				ResultSet resultSet = pstcx.executeQuery();
				String ccode="";
				if (resultSet.next()) {
					
					ccode=resultSet.getString("cust_id");
					
				}
		
			
		
		PreparedStatement pstcx99 = con.prepareStatement("INSERT INTO customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)");
		
		
		pstcx99.setString(1,ccode);
		pstcx99.setString(2,CoreData.getDateFormatAsDb(psb.getDate()));
		
		pstcx99.setString(3,psb.getBillno());
		pstcx99.setString(4,"Customer Payment");
		
		pstcx99.setString(5,"202");
		pstcx99.setString(6,"Credit");
		pstcx99.setString(8,psb.getCust_name());
		
		
		if (psb.getPaymod().trim().equals("CASH")) {
			String paybycash=psb.getNet_amount();

			pstcx99.setString(7,paybycash );
			
			
			
		
	}
	else if (psb.getPaymod().equalsIgnoreCase("CHEQUE")) {
		String paybycash=psb.getCheque_amt();
	
		pstcx99.setString(7,paybycash );
				
		
		
	
	}
	
	else if (psb.getPaymod().equalsIgnoreCase("CREDIT")) {
		
		String paybycash=psb.getNet_amountcard();
	
		pstcx99.setString(7,paybycash );
		
	}
		

	
		else if (psb.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
			
			String paybycash= psb.getPaid_amt();
			
			
			
			
			String ppmode="";
			if (psb.getR1().equalsIgnoreCase("partpaymentcash"))
			{
			
				pstcx99.setString(7,paybycash);
				
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcheque"))
			{
				
				
				pstcx99.setString(7,paybycash);
			
			}
			else if (psb.getR1().equalsIgnoreCase("partpaymentcard"))
			{
				
				pstcx99.setString(7,paybycash);
				
			}
			else
			{
			
				pstcx99.setString(7,"0");
			}
			

		}
	

		

		System.out.println("q4"+pstcx9);
	
		j9 = pstcx99.executeUpdate();	
		
		
		
		
		if ( j4 > 0 || j9 > 0) {
			psb.setResponse("success");
		} else {
			psb.setResponse("fail");

		}
		
		
		
		return psb;
		
		
		
	}





	/*public List<purchase_bean> collection_summary_tax(String from_date,
			String to_date1) throws SQLException, Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv ,date from invoice where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='6'  group by  invoice_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='6'  group by  invoice_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='9'    group by  invoice_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement3 " + preparedStatement3);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='9'    group by  invoice_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and cgstrate='14'  group by  invoice_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and sgstrate='14'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='5'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='12'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='18'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='28'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
				//System.out.println("sumwctdao........."+tlabourwct);
			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			
			
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		// System.out.println("report size " + report.size());
		return report;

	}*/
	
	
	
	
	public List<purchase_bean> collection_summary_tax(String from_date,
			String to_date1) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
		Connection con=connection.getConnection();
		
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv ,date from invoice where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='6'  group by  invoice_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='6'  group by  invoice_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='9'    group by  invoice_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement3 " + preparedStatement3);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='9'    group by  invoice_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and cgstrate='14'  group by  invoice_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and sgstrate='14'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='5'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='12'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='18'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='28'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
				//System.out.println("sumwctdao........."+tlabourwct);
			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			
			
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		// System.out.println("report size " + report.size());
		return report;

	}
	

	public List<purchase_bean> collection_summary_tax(String from_date, String to_date1,
			String mode) throws Exception {
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1=null;
		if(mode.equals("Cash"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycash as tot from invoice where date between ? and ? and pay_mode IN('CASH','CARDANDCASH','partpaymentcash~CASH','PARTPAYMENT','INSURANCE','')");
		}
		else if (mode.equals("Cheque"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycheque as tot  from invoice where date between ? and ? and pay_mode IN('CHEQUE','partpaymentcheque~CHEQUE','partpaymentcash~CASH')");
		}
		
		else if (mode.equals("Card"))
		{
		 preparedStatement1 = con
				.prepareStatement("select date,job_card_no,invoice_no,vehicle_no,total,pay_mode,paybycredit  as tot  from invoice where date between ? and ? and pay_mode IN('CARD','partpaymentcard~CARD','partpaymentcash~CASH','CREDIT','CREDITCARD','CARDANDCASH')");
		}
		
		
		
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		
		//System.out.println("mode" + mode);
		//System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
	
		BigDecimal totalamount = BigDecimal.ZERO;
		double ttamount=0.0;
		
		
		while (rs11.next()) {
			bean = new purchase_bean();

			bean.setDate(rs11.getString("date"));

			bean.setJob_card_no(rs11.getString("job_card_no"));
			bean.setInvoice_no(rs11.getString("invoice_no"));
			bean.setVechicle_no(rs11.getString("vehicle_no"));
	/*	if(rs11.getString("pay_mode").equals("CASH")|| rs11.getString("pay_mode").equals("CARDANDCASH")||rs11.getString("pay_mode").equals("partpaymentcash~CASH")||rs11.getString("pay_mode").equals("PARTPAYMENT")||rs11.getString("pay_mode").equals("INSURANCE")|| rs11.getString("pay_mode").equals("")){*/
			try{	
				
				
				
			bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("tot"))));
			
			bean.setPay_mode(rs11.getString("pay_mode"));

			totalamount = totalamount.add(rs11.getBigDecimal("tot"));
			ttamount=totalamount.doubleValue();
			bean.setTotalamount1("" +  Math.round(ttamount));
			}
			catch(Exception e)
			{
				
				
			}
			
			
			/*else if(rs11.getString("pay_mode").equals("CHEQUE")|| rs11.getString("pay_mode").equals("partpaymentcheque~CHEQUE")){
				System.out.println("within if111111111111");
				bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("paybycheque"))));
				totalamount = totalamount.add(rs11.getBigDecimal("paybycheque"));
				ttamount=totalamount.doubleValue();
				bean.setPay_mode(rs11.getString("pay_mode"));
				bean.setTotalamount1("" +  Math.round(ttamount));
				}
			else if(rs11.getString("pay_mode").equals("CREDIT")|| rs11.getString("pay_mode").equals("partpaymentcard~CARD")|| rs11.getString("pay_mode").equals("CARDANDCASH")|| rs11.getString("pay_mode").equals("CREDIT")|| rs11.getString("pay_mode").equals("CARD")|| rs11.getString("pay_mode").equals("CREDITCARD")){
				System.out.println("within if22222222222222");
				bean.setTotal(""+ Math.round(Double.parseDouble(rs11.getString("paybycredit"))));
				totalamount = totalamount.add(rs11.getBigDecimal("paybycredit"));
				ttamount=totalamount.doubleValue();
				bean.setPay_mode(rs11.getString("pay_mode"));
				bean.setTotalamount1("" +  Math.round(ttamount));
				}*/
			//bean.setPay_mode(rs11.getString("pay_mode"));

			/*try {

				totalamount = totalamount.add(rs11.getBigDecimal(5));
			} catch (Exception e) {
				// TODO: handle exception
			}*/

			//bean.setTotalamount1("" +  Math.round(ttamount));
			/*
			 * PreparedStatement preparedStatement2 = con .prepareStatement(
			 * "select invoice_no,total from invoice where job_card_no=?");
			 * preparedStatement2.setString(1, rs11.getString("job_card_no"));
			 * ResultSet rs22 = preparedStatement2.executeQuery(); if
			 * (rs22.next()) { bean.setInvoice_no(rs22.getString(1));
			 * bean.setTotal(rs22.getString("total")); }
			 */
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select cust_name from customer_master where cust_id=?");
			preparedStatement3.setString(1, rs11.getString("vehicle_no"));
			//System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			if (rs33.next()) {
				bean.setCust_name(rs33.getString("cust_name"));
			}
			report.add(bean);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		//System.out.println("report size " + report.size());
		return report;
	}





	public List<purchase_bean> collection_summary_taxip(String from_date,
			String to_date1) throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT lr_no as inv ,lr_date as date,company_id from lrformv where lr_date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		 System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv WHERE lr_no=? and cgstrate='2.5' group by  lr_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv WHERE lr_no=? and sgstrate='2.5' group by  lr_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv WHERE lr_no=? and cgstrate='6'  group by  lr_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv WHERE lr_no=? and sgstrate='6'  group by  lr_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt  FROM lrform_detailsv WHERE lr_no=? and cgstrate='9'    group by  lr_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	 System.out.println("preparedStatement3 " + preparedStatement5);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt  FROM lrform_detailsv WHERE lr_no=? and sgstrate='9'    group by  lr_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and cgstrate='14'  group by  lr_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and sgstrate='14'  group by  lr_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and igstrate='5'  group by  lr_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and igstrate='12'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and igstrate='18'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv WHERE lr_no=?  and igstrate='28'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


PreparedStatement preparedStatement=con.prepareStatement("select * from company_master where company_id=?");	
preparedStatement.setString(1, rs11.getString("company_id"));
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
	bean1.setCust_name(resultSet.getString("company_name"));
	
	bean1.setGstnno(resultSet.getString("vatno"));

	
}

			
				//System.out.println("sumwctdao........."+tlabourwct);
			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			
			
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		// System.out.println("report size " + report.size());
		return report;
	}



	public List<purchase_bean> PurchaseReturnReport(String from_date,
			String to_date1) throws Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT lr_no as inv ,lr_date as date from lrformv_sales_return where lr_date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		BigDecimal totalamount = BigDecimal.ZERO;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=? and cgstrate='2.5' group by  lr_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=? and sgstrate='2.5' group by  lr_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=? and cgstrate='6'  group by  lr_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=? and sgstrate='6'  group by  lr_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt  FROM lrform_detailsv_sales_return WHERE lr_no=? and cgstrate='9'    group by  lr_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	 System.out.println("preparedStatement3 " + preparedStatement5);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt  FROM lrform_detailsv_sales_return WHERE lr_no=? and sgstrate='9'    group by  lr_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and cgstrate='14'  group by  lr_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and sgstrate='14'  group by  lr_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and igstrate='5'  group by  lr_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and igstrate='12'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and igstrate='18'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM lrform_detailsv_sales_return WHERE lr_no=?  and igstrate='28'  group by  lr_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
				//System.out.println("sumwctdao........."+tlabourwct);
			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			
			
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		// System.out.println("report size " + report.size());
		return report;
	}
	
	

	public List<purchase_bean> collection_summary_taxactual(String from_date,
			String to_date1) throws SQLException, Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
Double tcgsti=0.0;
Double tcgsto=0.0;

Double tsgsti=0.0;
Double tsgsto=0.0;

Double tigsti=0.0;
Double tigsto=0.0;

purchase_bean bean2 = new purchase_bean();
bean2.setCgst6("OUTPUT");
try{
	PreparedStatement preparedStatement2 = con
			.prepareStatement("select SUM(invoice_tax_details.cgstamount) as nmt FROM invoice,invoice_tax_details where invoice.invoice_no=invoice_tax_details.invoice_no and  invoice.date between ? and ?");


preparedStatement2.setString(1, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
				.replace("/", "-") + " 00:00:00"));
preparedStatement2.setString(2, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
				.replace("/", "-") + " 00:00:00"));
System.out.println("preparedStatement1 " + preparedStatement2);
	ResultSet rs22 = preparedStatement2.executeQuery();
	
	if (rs22.next()) {
		try{
			bean2.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
		tcgsto=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	}catch (Exception e) {
		// TODO: handle exception
	}


try{
	PreparedStatement preparedStatement2 = con
			.prepareStatement("select SUM(invoice_tax_details.sgstamount) as nmt FROM invoice,invoice_tax_details where invoice.invoice_no=invoice_tax_details.invoice_no and  invoice.date between ? and ?");

preparedStatement2.setString(1, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
				.replace("/", "-") + " 00:00:00"));
preparedStatement2.setString(2, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
				.replace("/", "-") + " 00:00:00"));
System.out.println("preparedStatement1 " + preparedStatement2);
ResultSet rs22 = preparedStatement2.executeQuery();
	
	if (rs22.next()) {
		try{
			bean2.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
		tsgsto=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	}catch (Exception e) {
		// TODO: handle exception
	}


try{
	PreparedStatement preparedStatement2 = con
			.prepareStatement("select SUM(invoice_tax_details.igstamount) as nmt FROM invoice,invoice_tax_details where invoice.invoice_no=invoice_tax_details.invoice_no and  invoice.date between ? and ?");

//	System.out.println("preparedStatement1 " + preparedStatement2);
preparedStatement2.setString(1, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
				.replace("/", "-") + " 00:00:00"));
preparedStatement2.setString(2, SystemDateTime
		.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
				.replace("/", "-") + " 00:00:00"));
System.out.println("preparedStatement1 " + preparedStatement2);
	ResultSet rs22 = preparedStatement2.executeQuery();
	
	if (rs22.next()) {
		try{
			bean2.setIgst5(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
		tigsto=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	}catch (Exception e) {
		// TODO: handle exception
	}




report.add(bean2);

			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			bean1.setCgst6("INPUT");
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(lrform_detailsv.cgstamount) as nmt FROM lrformv,lrform_detailsv where lrformv.lr_no=lrform_detailsv.lr_no and  lrformv.lr_date between ? and ?");
		
			System.out.println("preparedStatement1 " + preparedStatement2);
		preparedStatement2.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
						.replace("/", "-") + " 00:00:00"));
		preparedStatement2.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
						.replace("/", "-") + " 00:00:00"));
		System.out.println("preparedStatement1 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				tcgsti=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
		
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			try{
				PreparedStatement preparedStatement2 = con
						.prepareStatement("select SUM(lrform_detailsv.sgstamount) as nmt FROM lrformv,lrform_detailsv where lrformv.lr_no=lrform_detailsv.lr_no and  lrformv.lr_date between ? and ?");
			
			//	System.out.println("preparedStatement1 " + preparedStatement2);
			preparedStatement2.setString(1, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
							.replace("/", "-") + " 00:00:00"));
			preparedStatement2.setString(2, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
							.replace("/", "-") + " 00:00:00"));
			System.out.println("preparedStatement1 " + preparedStatement2);
				ResultSet rs22 = preparedStatement2.executeQuery();
				
				if (rs22.next()) {
					try{
					bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
					tsgsti=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
					}
					catch (Exception e) {
						// TODO: handle exception
					}
			
				}
				
				}catch (Exception e) {
					// TODO: handle exception
				}
			
			
			try{
				PreparedStatement preparedStatement2 = con
						.prepareStatement("select SUM(lrform_detailsv.igstamount) as nmt FROM lrformv,lrform_detailsv where lrformv.lr_no=lrform_detailsv.lr_no and  lrformv.lr_date between ? and ?");
			
			//	System.out.println("preparedStatement1 " + preparedStatement2);
			preparedStatement2.setString(1, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(from_date
							.replace("/", "-") + " 00:00:00"));
			preparedStatement2.setString(2, SystemDateTime
					.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(to_date1
							.replace("/", "-") + " 00:00:00"));
			System.out.println("preparedStatement1 " + preparedStatement2);
				ResultSet rs22 = preparedStatement2.executeQuery();
				
				if (rs22.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
					tigsti=(double) Math.round(Double.parseDouble(rs22.getString("nmt")));
					}
					catch (Exception e) {
						// TODO: handle exception
					}
			
				}
				
				}catch (Exception e) {
					// TODO: handle exception
				}
			report.add(bean1);
			
			purchase_bean bean3 = new purchase_bean();
			bean3.setCgst6("TOTAL");
			bean3.setCgst25(""+(tcgsto-tcgsti));
			bean3.setSgst25(""+(tsgsto-tsgsti));
			
			bean3.setIgst5(""+(tigsto-tigsti));
			
			report.add(bean3);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		
		
		// System.out.println("report size " + report.size());
		return report;
	}



	
	


	public List<purchase_bean> salereportsubmit(String datefrom, String dateto) throws SQLException, Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv ,date,total,vehicle_no from invoice where date between ? and ?  and wotax='yes' ");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		 System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		Double totalamount =0.0;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='6'  group by  invoice_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='6'  group by  invoice_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and cgstrate='9'    group by  invoice_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement3 " + preparedStatement3);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt ,net_amt FROM invoice_tax_details WHERE invoice_no=? and sgstrate='9'    group by  invoice_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and cgstrate='14'  group by  invoice_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and sgstrate='14'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='5'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='12'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='18'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details WHERE invoice_no=?  and igstrate='28'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
				//System.out.println("sumwctdao........."+tlabourwct);
try{
	totalamount=totalamount+Double.parseDouble(rs11.getString("total"));
}catch(Exception e){
	
}
try {
	PreparedStatement preparedStatementx = con
	.prepareStatement("select * from customer_master where cust_id='"
			+ rs11.getString("vehicle_no") + "'");

	ResultSet resultSetx = preparedStatementx.executeQuery();
	if (resultSetx.next()) {
		bean1.setCust_name(resultSetx.getString("cust_name"));
		
		bean1.setGstnno(resultSetx.getString("company_vat"));
	
		
	
		
		
		
		
	}
}catch (Exception e) {
	// TODO: handle exception
	
}

			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			bean1.setTotalnetamt(""+rs11.getString("total"));
			bean1.setTotalamount1(""+Math.round(totalamount));
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		 System.out.println("report size " + report.size());
		return report;
	}

	
	
	
	
	
	
	
	public List<purchase_bean> salereturnreportsubmit(String datefrom, String dateto) throws SQLException, Exception {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();

		PreparedStatement preparedStatement1 = con
				.prepareStatement("select DISTINCT invoice_no as inv ,date,total,vehicle_no from invoice_sales_return where date between ? and ?");
		purchase_bean bean = new purchase_bean();
		//System.out.println("preparedStatement1 " + preparedStatement1);
		preparedStatement1.setString(1, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
						.replace("/", "-") + " 00:00:00"));
		preparedStatement1.setString(2, SystemDateTime
				.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
						.replace("/", "-") + " 00:00:00"));
		 System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs11 = preparedStatement1.executeQuery();
		// System.out.println(preparedStatement3);
		Double totalamount =0.0;
		Double tcgst25=0.0;
		Double tcgst6=0.0;
		Double tcgst9=0.0;
		Double tcgst14=0.0;
		
		Double tsgst25=0.0;
		Double tsgst6=0.0;
		Double tsgst9=0.0;
		Double tsgst14=0.0;
		
		
		Double tigst5=0.0;
		Double tigst12=0.0;
		Double tigst18=0.0;
		Double tigst28=0.0;
		
		
		while (rs11.next()) {
			purchase_bean bean1 = new purchase_bean();
			// bean.setInvoice_no(rs11.getString("inv"));
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=? and cgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setCgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tcgst25=tcgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			}catch (Exception e) {
				// TODO: handle exception
			}
			try{
			PreparedStatement preparedStatement2 = con
					.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=? and sgstrate='2.5' group by  invoice_no");
			preparedStatement2.setString(1, rs11.getString("inv"));
		 //System.out.println("preparedStatement2 " + preparedStatement2);
			ResultSet rs22 = preparedStatement2.executeQuery();
			
			if (rs22.next()) {
				try{
				bean1.setSgst25(""+Math.round(Double.parseDouble(rs22.getString("nmt"))));
				}
				catch (Exception e) {
					// TODO: handle exception
				}
			//	bean1.setTotalamtparts(""+Math.round((Double.parseDouble(rs22.getString("nmt")))));
				
				try{
					tsgst25=tsgst25+Double.parseDouble(rs22.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
			}catch(Exception e){}
			
			try{
			PreparedStatement preparedStatement3 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=? and cgstrate='6'  group by  invoice_no");
			preparedStatement3.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement3 " + preparedStatement3);
			ResultSet rs33 = preparedStatement3.executeQuery();
			
			if (rs33.next()) {
				try{
					
					System.out.println("total labour wct"+rs33.getString("nmt"));
					
				bean1.setCgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
				}
				catch (Exception e) {
					
					
				}
				try{
					tcgst6=tcgst6+Double.parseDouble(rs33.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
					
				}
			}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement3 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=? and sgstrate='6'  group by  invoice_no");
				preparedStatement3.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement3 " + preparedStatement3);
				ResultSet rs33 = preparedStatement3.executeQuery();
				
				if (rs33.next()) {
					try{
						
						
					bean1.setSgst6(""+Math.round(Double.parseDouble(rs33.getString("nmt"))));
					}
					catch (Exception e) {
						
						
					}
					try{
						tsgst6=tsgst6+Double.parseDouble(rs33.getString("nmt"));
					}catch (Exception e) {
						// TODO: handle exception
						
					}
				}}catch(Exception e){}
		
			try{
			PreparedStatement preparedStatement5 = con
			.prepareStatement("select SUM(cgstamount) as nmt ,net_amt FROM invoice_tax_details_sales_return WHERE invoice_no=? and cgstrate='9'    group by  invoice_no");
	preparedStatement5.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement3 " + preparedStatement3);
	ResultSet rs55 = preparedStatement5.executeQuery();
	
	if (rs55.next()) {
		try{
		bean1.setCgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
		}catch (Exception e) {
		}
		try{
			tcgst9=tcgst9+Double.parseDouble(rs55.getString("nmt"));
		}catch (Exception e) {
			// TODO: handle exception
			
		}
	}}catch(Exception e){}
			
			try{
				PreparedStatement preparedStatement5 = con
				.prepareStatement("select SUM(sgstamount) as nmt ,net_amt FROM invoice_tax_details_sales_return WHERE invoice_no=? and sgstrate='9'    group by  invoice_no");
		preparedStatement5.setString(1, rs11.getString("inv"));
		// System.out.println("preparedStatement3 " + preparedStatement3);
		ResultSet rs55 = preparedStatement5.executeQuery();
		
		if (rs55.next()) {
			try{
			bean1.setSgst9(""+Math.round(Double.parseDouble(rs55.getString("nmt"))));
			}catch (Exception e) {
			}
			try{
				tsgst9=tsgst9+Double.parseDouble(rs55.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
				
			}
		}}catch(Exception e){}
			
			
			
			
			
			try{
		
			PreparedStatement preparedStatement4 = con
					.prepareStatement("select SUM(cgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and cgstrate='14'  group by  invoice_no");
			preparedStatement4.setString(1, rs11.getString("inv"));
			// System.out.println("preparedStatement4 " + preparedStatement4);
			ResultSet rs44 = preparedStatement4.executeQuery();
		
			if (rs44.next()) {
				try{
				bean1.setCgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
				}catch (Exception e) {
				}
				
				try{
					tcgst14=tcgst14+Double.parseDouble(rs44.getString("nmt"));
			}catch (Exception e) {
				// TODO: handle exception
			}
			}}catch(Exception e){}
			
			
			try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(sgstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and sgstrate='14'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setSgst14(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tsgst14=tsgst14+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}
			
			
			
try{
				
				PreparedStatement preparedStatement4 = con
						.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and igstrate='5'  group by  invoice_no");
				preparedStatement4.setString(1, rs11.getString("inv"));
				// System.out.println("preparedStatement4 " + preparedStatement4);
				ResultSet rs44 = preparedStatement4.executeQuery();
			
				if (rs44.next()) {
					try{
					bean1.setIgst5(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
					}catch (Exception e) {
					}
					
					try{
						tigst5=tigst5+Double.parseDouble(rs44.getString("nmt"));
				}catch (Exception e) {
					// TODO: handle exception
				}
				}}catch(Exception e){}



try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and igstrate='12'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst12(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst12=tigst12+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}


try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and igstrate='18'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst18(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst18=tigst18+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
			
try{
	
	PreparedStatement preparedStatement4 = con
			.prepareStatement("select SUM(igstamount) as nmt FROM invoice_tax_details_sales_return WHERE invoice_no=?  and igstrate='28'  group by  invoice_no");
	preparedStatement4.setString(1, rs11.getString("inv"));
	// System.out.println("preparedStatement4 " + preparedStatement4);
	ResultSet rs44 = preparedStatement4.executeQuery();

	if (rs44.next()) {
		try{
		bean1.setIgst28(""+Math.round(Double.parseDouble(rs44.getString("nmt"))));
		}catch (Exception e) {
		}
		
		try{
			tigst28=tigst28+Double.parseDouble(rs44.getString("nmt"));
	}catch (Exception e) {
		// TODO: handle exception
	}
	}}catch(Exception e){}
			
				//System.out.println("sumwctdao........."+tlabourwct);
try{
	totalamount=totalamount+Double.parseDouble(rs11.getString("total"));
}catch(Exception e){
	
}
try {
	PreparedStatement preparedStatementx = con
	.prepareStatement("select * from customer_master where cust_id='"
			+ rs11.getString("vehicle_no") + "'");

	ResultSet resultSetx = preparedStatementx.executeQuery();
	if (resultSetx.next()) {
		bean1.setCust_name(resultSetx.getString("cust_name"));
		
		bean1.setGstnno(resultSetx.getString("company_vat"));
	
		
	
		
		
		
		
	}
}catch (Exception e) {
	// TODO: handle exception
	
}

			bean1.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
			bean1.setInvoice_no(rs11.getString("inv"));
			bean1.setTcgst25(""+ Math.round(tcgst25));
			bean1.setTcgst6(""+Math.round(tcgst6));
			bean1.setTcgst9(""+Math.round(tcgst9));
			bean1.setTcgst14(""+Math.round(tcgst14));
			bean1.setTotalnetamt(""+rs11.getString("total"));
			bean1.setTotalamount1(""+Math.round(totalamount));
			bean1.setTsgst25(""+ Math.round(tsgst25));
			bean1.setTsgst6(""+Math.round(tsgst6));
			bean1.setTsgst9(""+Math.round(tsgst9));
			bean1.setTsgst14(""+Math.round(tsgst14));
			
			bean1.setTigst5(""+ Math.round(tigst5));
			bean1.setTigst12(""+Math.round(tigst12));
			bean1.setTigst18(""+Math.round(tigst18));
			bean1.setTigst28(""+Math.round(tigst28));
			
			
			
			report.add(bean1);
			// System.out.println(rs11.getString(1)+"rs11.getString(1)");

		}
		
		 System.out.println("report size " + report.size());
		return report;
	}
	
	
	
	public purchase_bean FetchspareMaterial(String autoinvoice) {
		// TODO Auto-generated method stub

		purchase_bean bean1  = new purchase_bean();
		int sparesize = 0;
		
		List<String> inv = new ArrayList<String>();
		List<String> d1 = new ArrayList<String>();
		List<String> totamt = new ArrayList<String>();
		List<String> remamt = new ArrayList<String>();
		System.out.println(">>>>>>>");
		try {
			int sno = 1;

			
			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			System.out.println(">>>>>>11111>");
			PreparedStatement pst = con
					.prepareStatement("select * from lrformv  where company_id='"
							+  autoinvoice + "' and remaining_amount > 0 ");

			System.out.println("SQL:"+pst);
			ResultSet rs = pst.executeQuery();
			double totalmn=0;double qtynew=0;
		
			while (rs.next()) {

			
				inv.add(rs.getString("lr_no"));
				d1.add(rs.getString("lr_date"));
				totamt.add(rs.getString("net_amount"));
				remamt.add(rs.getString("remaining_amount"));
				
				
				//String qty1=rs.getString("total_amt");
				
				 //qtynew=totalmn + Double.parseDouble(qty1);
				
				
				
				
				sparesize++;
			}
			//bean1.setBalance_amount(String.valueOf(qtynew));
			//System.out.println("TOTAL:"+qtynew);
			
			
			
				
			
			try{
				con.close();
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
		return bean1;

	}

	
	
	public purchase_bean FetchspareMaterial12(String autoinvoice) {
		// TODO Auto-generated method stub

		purchase_bean bean1  = new purchase_bean();
		int sparesize = 0;
		
		List<String> inv = new ArrayList<String>();
		List<String> d1 = new ArrayList<String>();
		List<String> totamt = new ArrayList<String>();
		List<String> remamt = new ArrayList<String>();
		List<String> recno = new ArrayList<String>();
		try {
			int sno = 1;

			
			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
				
			
			
			/*PreparedStatement pst1 = con
					.prepareStatement("select * from customer_master  where cust_id='"+  autoinvoice + "'  ");

			System.out.println("SQL:"+pst1);
			ResultSet rs1 = pst1.executeQuery();
			String custid="";
			if (rs1.next()) {

			
				custid=rs1.getString("cust_id");
				
			}*/
			
			
			//System.out.println("Customer Id:"+custid);
			
			PreparedStatement pst = con
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
				con.close();
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
		bean1.setRecno(recno);
		return bean1;

	}





	public List<purchase_bean> purchaseorderreport() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con
		.prepareStatement("select * from purchase_order_details where qtyremaining > 0");

		//System.out.println("preparedStatement1 " + preparedStatement1);
		ResultSet rs112 = preparedStatement1.executeQuery();

		String jobcarno = "";Double totos=0.0;
		
		while (rs112.next()) {
	
			purchase_bean bean;
			
			bean = new purchase_bean();
			
			bean.setInvoice_no(rs112.getString("pono"));
	
			bean.setCust_name(rs112.getString("custid"));
		
			bean.setAddress(rs112.getString("descrip"));
			
			bean.setQty1(rs112.getString("qty"));
			bean.setRecidno(rs112.getString("qtyremaining"));
			
			PreparedStatement preparedStatement12 = con
					.prepareStatement("select * from customer_master_details where customer_no=?    ");
			preparedStatement12.setString(1, rs112.getString(1));
		
			ResultSet resultSet1 = preparedStatement12.executeQuery();
			System.out.println(preparedStatement12);
			if (resultSet1.next()) {
				bean.setCustomername(resultSet1.getString("customer_name"));
			
			}
				
			
			
			report.add(bean);
			
			
}
		
		
		return report;
	}
	
	
	
	
	//Dc O/S Report
	
	public List<purchase_bean> DcOsReport() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con
		.prepareStatement("select * from purchase_order_details where dcqty > 0");

		//System.out.println("preparedStatement1 " + preparedStatement1);
		ResultSet rs112 = preparedStatement1.executeQuery();

		String jobcarno = "";Double totos=0.0;
		
		while (rs112.next()) {
	
			purchase_bean bean;
			
			bean = new purchase_bean();
			
			bean.setInvoice_no(rs112.getString("invoice_no"));
	
			bean.setCust_name(rs112.getString("custid"));
		
			bean.setAddress(rs112.getString("descrip"));
			
			bean.setQty1(rs112.getString("qty"));
			bean.setRecidno(rs112.getString("dcqty"));
			
			PreparedStatement preparedStatement12 = con
					.prepareStatement("select * from customer_master_details where customer_no=?    ");
			preparedStatement12.setString(1, rs112.getString(1));
		
			ResultSet resultSet1 = preparedStatement12.executeQuery();
			System.out.println(preparedStatement12);
			if (resultSet1.next()) {
				bean.setCustomername(resultSet1.getString("customer_name"));
			
			}
				
			
			
			report.add(bean);
			
			
}
		
		
		return report;
	}
	
	
	
	
	
	
	
		public List<purchase_bean> DcOwSrcOsReport() throws SQLException {
			// TODO Auto-generated method stub
			DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			List<purchase_bean> report = new ArrayList<purchase_bean>();
			PreparedStatement preparedStatement1 = con
			.prepareStatement("select * from outsrc_dc_details where remainingqty > 0");

			//System.out.println("preparedStatement1 " + preparedStatement1);
			ResultSet rs112 = preparedStatement1.executeQuery();

			String jobcarno = "";Double totos=0.0;
			
			while (rs112.next()) {
		
				purchase_bean bean;
				
				bean = new purchase_bean();
				
				bean.setInvoice_no(rs112.getString("Dc_id"));
		
				//bean.setCust_name(rs112.getString("custid"));
			
				bean.setAddress(rs112.getString("description"));
				
				bean.setQty1(rs112.getString("qty"));
			
				bean.setRecidno(rs112.getString("remainingqty"));
				
				
				
				PreparedStatement preparedStatement12 = con
						.prepareStatement("select * from outsrcdc where Dc_id=?    ");
				
				preparedStatement12.setString(1, rs112.getString("Dc_id"));
			
				ResultSet resultSet1 = preparedStatement12.executeQuery();
				System.out.println(preparedStatement12);
				if (resultSet1.next()) {
					bean.setCustomername(resultSet1.getString("cust_name"));
				
				}
					
				
				
				report.add(bean);
				
				
	}
			
			
			return report;
		}
	
	
	
	
	// Ageing Report
	
	public List<purchase_bean> AgeingReport() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con.prepareStatement("select * from invoice where remaining_amount > 0");

		//System.out.println("preparedStatement1 " + preparedStatement1);
		ResultSet rs112 = preparedStatement1.executeQuery();
		int flag=0;
		String jobcarno = "";Double totos=0.0;
		while (rs112.next()) {
	
			
			
			int ss=rs112.getInt("termcond");
			
			//System.out.println("Payterm:"+ss);
			
			
			
			// Calculation Of Pending Days
			
						String months = "0";
						String days="0";
						int diffInDays=0;
						try{
							String startDateString = rs112.getString("date");
							String startDateString1 =startDateString;

							String dt = startDateString;  // Start date
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							Calendar c = Calendar.getInstance();
							c.setTime(sdf.parse(dt));
							//c.add(Calendar.MONTH, Integer.parseInt(rs.getString("duration")));  // number of days to add
							dt = sdf.format(c.getTime());  // dt is now the new date

							startDateString=dt;
							String newDateString="";
							String newDateString1="";
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
							Date startDate=null;
							Date startDate1=null;
							try {
								startDate = df.parse(startDateString);
								newDateString = df.format(startDate);

								startDate1 = df.parse(startDateString1);
								newDateString1 = df.format(startDate1);
								System.out.println(newDateString1);
							} catch (ParseException e) {
								e.printStackTrace();
							}

							Date datee = new Date();
							//      System.out.println(datee);

							String datese = df.format(datee);
							//     System.out.println(datese);

							datee=df.parse(datese);
							//    System.out.println(datee);
							//		System.out.println("1	>>>"+newDateString);
							//		System.out.println("2   >>>"+datese);

							Calendar startCalendar = Calendar.getInstance();
							startCalendar.setTime(startDate);

							Calendar startCalendar1 = Calendar.getInstance();
							startCalendar1.setTime(startDate1);

							Calendar endCalendar = Calendar.getInstance();
							endCalendar.setTime(datee);

							int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar1.get(Calendar.YEAR);
							int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar1.get(Calendar.MONTH);
							int diffDay= endCalendar.get(Calendar.DAY_OF_MONTH) -startCalendar.get(Calendar.DAY_OF_MONTH);
							days = diffDay + "";
							months=diffMonth+"";

							diffInDays = (int)( (datee.getTime() - startDate.getTime()) / (1000 * 60 * 60 *24 ) );
				
							//System.out.println("diffInDays>>>"+diffInDays);
							
							
							
							
							//	 System.out.println("months>>>"+months);
						}catch (Exception e) {
							// TODO: handle exception
						}
			//int a=Integer.parseInt(ss);
			
					if(ss < diffInDays)	
					{		
					 flag=0;
					// System.out.println("1");
					 
					}
					
					else{
						
						flag=1;
						//System.out.println("2");
					}
					
					
			if(flag==0)
				
			{
				
				purchase_bean bean;
				
				bean = new purchase_bean();
				
				
				if(diffInDays==0){
					bean.setAddress("Today");
				}else{
					bean.setAddress(String.valueOf(diffInDays));
				}
			bean.setInvoice_no(rs112.getString("invoice_no"));
	
			bean.setCust_name(rs112.getString("vehicle_no"));
		
			try{
			bean.setDate(CoreData.getDateFormatAsUser(rs112.getString("date")));
			}catch(Exception e){
				
			}
			
			
			bean.setTot(rs112.getString("remaining_amount"));
			
			
			PreparedStatement preparedStatement12 = con
					.prepareStatement("select * from customer_master_details where customer_no=?    ");
			preparedStatement12.setString(1, rs112.getString("vehicle_no"));
		
			ResultSet resultSet1 = preparedStatement12.executeQuery();
			System.out.println(preparedStatement12);
			if (resultSet1.next()) {
				bean.setCustomername(resultSet1.getString("customer_name"));
			
			}
			
			
			
			report.add(bean);
			
		}}
			
					
			

		
	
		return report;
	}
/*	
	public List<purchase_bean> dcreport() throws SQLException {
		// TODO Auto-generated method stub
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
		List<purchase_bean> report = new ArrayList<purchase_bean>();
		PreparedStatement preparedStatement1 = con
		.prepareStatement("select * from dc where status='0' ");
// purchase_bean bean = new purchase_bean();
System.out.println("preparedStatement1 " + preparedStatement1);

// System.out.println("preparedStatement1 " + preparedStatement1);

ResultSet rs112 = preparedStatement1.executeQuery();

while (rs112.next()) {
	
	
purchase_bean bean;
		
		
			bean = new purchase_bean();
			
			bean.setCustid(rs112.getString("custid"));
			
			bean.setDc_id(rs112.getString("Dc_id"));
			bean.setCust_name(rs112.getString("cust_name"));
			bean.setMob_no(rs112.getString("mob_no"));
			bean.setCust_address(rs112.getString("cust_address"));
			bean.setPancard_no(rs112.getString("pancard_no"));
			bean.setEmail(rs112.getString("email"));
			bean.setGstn_no(rs112.getString("gstn_no"));
			
			
			
		
			
			report.add(bean);
			} 
			

		
		
		return report;
		
	}*/





	public List<purchase_bean> enquiryReportDetails(String datefrom, String dateto) {
		List<purchase_bean> list =new ArrayList<purchase_bean>();
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			try {
				
				datefrom=SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
								.replace("/", "-") + " 00:00:00");
				
				dateto= SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
								.replace("/", "-") + " 00:00:00");
				String[] d1=datefrom.split(" ");
				String[] d2=dateto.split(" ");
				PreparedStatement preparedStatement1 = con
						.prepareStatement("select * from inquiry where date between ? and ?");
				purchase_bean bean = new purchase_bean();
				
				preparedStatement1.setString(1, d1[0]);
				preparedStatement1.setString(2, d2[0]);
				// System.out.println("preparedStatement1 " + preparedStatement1);
				System.out.println("preparedStatement1 " + preparedStatement1);
				ResultSet rs11 = preparedStatement1.executeQuery();
				while(rs11.next()) {
					
					purchase_bean b=new purchase_bean();
					
					
					b.setEnquiryid(rs11.getString("inquiry_id"));
					b.setCust_name(rs11.getString("name"));
					b.setSource(rs11.getString("source"));
					b.setDestination(rs11.getString("destination"));
					b.setType(rs11.getString("type"));
					b.setBuyrate("");
					b.setBrocker(rs11.getString("contact_person"));
					
					try {
					if(rs11.getString("status").equals("1")) {
					
					b.setStatus("WON");
					}else {
						b.setStatus("LOOSE");
					}
					}catch(Exception e) {
						b.setStatus("LOOSE");
					}
					
					b.setRemark(rs11.getString("remark"));
				list.add(b);
				}
				
				
				
				}catch(Exception e) {
					e.printStackTrace();
					}
		
		return list;
	}





	public List<purchase_bean> LRReportDetails(String datefrom, String dateto, String customer, String transp) {
		List<purchase_bean> list =new ArrayList<purchase_bean>();
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			try {
				String cond1="";
				String cond2="";
				if(customer!=null && !customer.equals("")) {
				String[] c=customer.split("-"); 
				cond1=" and customer_no='"+c[1]+"' ";
				}else {
					cond1=" ";
				}
				
				if(transp!=null && !transp.equals("")) {
				String[] t=transp.split("-");
				cond2=" and transporter_code='"+t[1]+"' ";
				}else {
				cond2="";
				}
				
				
				datefrom=SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
								.replace("/", "-") + " 00:00:00");
				
				dateto= SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
								.replace("/", "-") + " 00:00:00");
				String[] d1=datefrom.split(" ");
				String[] d2=dateto.split(" ");
				
				PreparedStatement preparedStatement1 = con
						.prepareStatement("select * from lr where date between ? and ? "+cond1+" "+cond2+" ");
				
				
				preparedStatement1.setString(1, d1[0]);
				preparedStatement1.setString(2, d2[0]);
				// System.out.println("preparedStatement1 " + preparedStatement1);
				System.out.println("preparedStatement1 " + preparedStatement1);
				ResultSet rs11 = preparedStatement1.executeQuery();
				while(rs11.next()) {
					purchase_bean b=new purchase_bean();
					b.setLrno(rs11.getString("LR_no"));
					b.setDate(CoreData.getDateFormatAsUser(rs11.getString("date")));
					b.setCust_name(rs11.getString("Customer_name"));
					b.setBookingby(rs11.getString("booking"));
					b.setSource(rs11.getString("source"));
					b.setDestination(rs11.getString("destination"));
					b.setType(rs11.getString("vehicle_Type"));
					b.setBuyrate(rs11.getString("total_amount"));
					b.setSellrate(rs11.getString("invoice_value"));
					b.setTransporter(rs11.getString("transporter_name"));
					b.setTransporterref(rs11.getString("invoice_No"));
					list.add(b);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
	}





	public List<purchase_bean> monthlybookingdetails(String datefrom, String dateto) {

		List<purchase_bean> list =new ArrayList<purchase_bean>();
		DBConnection connection=new DBConnection();Connection con=connection.getConnection();
			try {
				
				datefrom=SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(datefrom
								.replace("/", "-") + " 00:00:00");
				
				dateto= SystemDateTime
						.From_dd_mm_yyyy_HH_mm_ss_to_yyyy_mm_dd_HH_mm_ss(dateto
								.replace("/", "-") + " 00:00:00");
				String[] d1=datefrom.split(" ");
				String[] d2=dateto.split(" ");
				
				PreparedStatement preparedStatement1 = con
						.prepareStatement("select * from lr where date between ? and ? GROUP BY vehicle_Type");
				preparedStatement1.setString(1, d1[0]);
				preparedStatement1.setString(2, d2[0]);
				ResultSet rs=preparedStatement1.executeQuery();
				double d=0.0;
				while(rs.next()) {
					purchase_bean b=new purchase_bean();
					PreparedStatement ps = con
							.prepareStatement("select SUM(invoice_value) as selling,SUM(total_amount) as purchase,COUNT(vehicle_Type) as vcount from lr where date between ? and ? and vehicle_Type='"+rs.getString("vehicle_Type")+"'");
					
					ps.setString(1, d1[0]);
					ps.setString(2, d2[0]);
					ResultSet rs2=ps.executeQuery();
					if(rs2.next()) {
						b.setTotallr(rs2.getString("vcount"));
						b.setVehicletype(rs.getString("vehicle_Type"));
						b.setVehiclebrkup("");
						b.setBuyrate(rs2.getString("purchase"));
						b.setSellrate(rs2.getString("selling"));
						
						double dsell=0.0,dpur=0.0,dprofit=0.0;
						try {
							dsell=Double.parseDouble(rs2.getString("selling"));
						}catch(Exception e) {
							dsell=0.0;	
						}
						
						try {
							dpur=Double.parseDouble(rs2.getString("purchase"));
						}catch(Exception e) {
							dpur=0.0;	
						}
						
						dprofit=dsell-dpur;
						b.setProfit(""+dprofit);
						try {
						d=d+Double.parseDouble(rs2.getString("selling"));
						}catch(Exception e) {
							d=d+0.0;
						}
						
						list.add(b);
					}
				
				}
				
				purchase_bean b2=new purchase_bean();
				b2.setTot(""+d);
				list.add(b2);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return list;
	}
		
		
}