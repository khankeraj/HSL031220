package com.master.dao;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.model.invoicebean1;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;

//import com.aqua.model.RoleBean;

public class invoice_dao1 {

	static DBConnection connection = new DBConnection();
	//static Connection conn = connection.getConnection();

	public String insertCustomerInfo(invoicebean1 ib, userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();

		int flag1 = 0;

		

		

		//System.out.println("iinFlag Value:" + flag1);
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

		

		String pref = "INV";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		

		String query = "";
		PreparedStatement preparedStatement = conn.prepareStatement("select * from invoice_vendor where  invoice_no=? ");
		String inv = ib.getInvoiceno();
		String inv1 = " " + inv;

		preparedStatement.setString(1, inv1.trim());

		//System.out.println(preparedStatement);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			response = "Already";

			PreparedStatement pst1 = conn
					.prepareStatement("select * from transporter_payment_details where invoiceno='" + inv1.trim() + "' ");
			//System.out.println("pst........." + pst1);
			ResultSet rs1 = pst1.executeQuery();
			if (rs1.next()) {

			} else {

				if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

					query = "UPDATE   invoice_vendor  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

					/*
					 * try {
					 * 
					 * PreparedStatement pps4 = conn.prepareStatement(
					 * "select * from settings "); //
					 * System.out.println("preparedStatement112"+
					 * preparedStatement112); ResultSet rs12s =
					 * pps4.executeQuery();
					 * 
					 * if (rs12s.next()) {
					 * 
					 * if (rs12s.getString("withstock").equals("yes")) {
					 * 
					 * String qd =
					 * "Select *  from invoice_tax_details where invoice_no=? and year='"
					 * + bean.getYearlogin() + "'";
					 * 
					 * // System.out.println("1");
					 * 
					 * String inv2 = ib.getInvno(); String inv21 = " " + inv2;
					 * 
					 * PreparedStatement pstdel = conn.prepareStatement(qd);
					 * pstdel.setString(1, inv21.trim()); //
					 * System.out.println("2");
					 * 
					 * System.out.println("SQL11:" + pstdel); ResultSet rss =
					 * pstdel.executeQuery();
					 * 
					 * while (rss.next()) {
					 * 
					 * // System.out.println(rss.getString("qty"));
					 * 
					 * Double qttsparedet = rss.getDouble("qty");
					 * 
					 * // System.out.println(">>>>>");
					 * 
					 * String a92x =
					 * "select qty,sparecode from stocktablev where sparecode='"
					 * + rss.getString("descrip") + "' ";
					 * 
					 * PreparedStatement pst32x = conn.prepareStatement(a92x);
					 * 
					 * System.out.println("SQL12:" + pst32x);
					 * 
					 * ResultSet resultSet112x = pst32x.executeQuery(a92x);
					 * 
					 * if (resultSet112x.next()) {
					 * 
					 * String sparequantity = resultSet112x.getString("qty");
					 * 
					 * Double qty = Double.parseDouble(sparequantity);
					 * 
					 * Double totalqty = (qty + qttsparedet); String a1022x =
					 * "update stocktablev set qty=" + totalqty +
					 * " where sparecode='" + rss.getString("descrip") + "'  ";
					 * 
					 * PreparedStatement pst1422x =
					 * conn.prepareStatement(a1022x);
					 * 
					 * System.out.println("SQL13:	" + pst1422x);
					 * 
					 * int y = pst1422x.executeUpdate();
					 * 
					 * } }
					 * 
					 * } else {
					 * 
					 * }
					 * 
					 * } } catch (Exception e) {
					 * 
					 * }
					 */

				} else {

					query = "UPDATE   invoice_vendor  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

						// paid_amt2 = ib.getCash_amt();

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */
						Date dNow = new Date();

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, paid_amt2);

						pst9.setString(12, "0");
						pst9.setString(13, "0");
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						String d = "";
						try {
							d = CoreData.getDateFormatAsDb(ib.getDate22());

						} catch (Exception e) {

						}

						pst9.setString(16, d);

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					}

					else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
						String paymode = "";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";

						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
							paymode = ib.getR1() + "~" + "CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");

						} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

							paymode = ib.getR1() + "~" + "CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
							paymode = ib.getR1() + "~" + "CARD";
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);

						} else {
							paymode = ib.getPaymod();
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, "0");
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

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						/*
						 * pst9.setString(11, "0");
						 * 
						 * pst9.setString(12, "0"); pst9.setString(13, "0");
						 */
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

						pst9.setString(4, "" + p);
						/*
						 * try{ c = Integer.valueOf(balace); }catch (Exception
						 * e) { // TODO: handle exception c=0; }
						 */
						pst9.setString(5, "" + 0);

						pst9.setString(7, "");
						pst9.setString(8, "" + ib.getTrandi());
						pst9.setString(9, "");

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, "" + a);

						pst9.setString(12, "" + 0);
						pst9.setString(13, "" + c);
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						pst9.setString(16, "");

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					} else {

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
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no());
				 * 
				 * j = preparedStatement1121.executeUpdate();
				 * 
				 * response = "success";
				 */

				// update tax_datails
				response = "success";

				String qd = "delete  from invoice_tax_details_vendor where invoice_no=? ";
				String inv2 = ib.getInvoiceno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details_vendor(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

						
					/*	PreparedStatement preparedStatementx1 = conn
								.prepareStatement("select type from bag_config_master where bag_name='"
										+ ib.getDescription1()[j1] + "'");

						
						//System.out.println("SQL:"+preparedStatementx1);
						
						ResultSet resultSetx1 = preparedStatementx1.executeQuery();
						
						if (resultSetx1.next()) {
							
							ib.setUnit(resultSetx1.getString("type"));
						
						} else {
						*/
							ib.setUnit("");
						
						//}
						
						
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

						pst41.setString(22, "");
						pst41.setString(23, bean.getUsername());
						pst41.setString(24, SystemDateTime.CurrentDateTime());

						pst41.setString(25, ib.getBatch1()[j1]);
						
						pst41.setString(26, ib.getUnit());

						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}

					String qd1 = "delete  from invoice_hsn_details_vendor where invoiceno=? ";
					inv2 = ib.getInvoiceno();
					inv21 = " " + inv2;
					PreparedStatement pstdel1 = conn.prepareStatement(qd1);
					pstdel1.setString(1, inv21.trim());

					int n12 = pstdel1.executeUpdate();

					PreparedStatement preparedStatement112zz = conn.prepareStatement(
							"select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_hsn_details_vendor where invoice_no='"
									+ inv21.trim() + "'  GROUP BY type_name   ");
					//System.out.println("preparedStatement112" + preparedStatement112zz);
					ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

					while (resultSet12zz.next()) {

						query = "insert into   invoice_hsn_details_vendor  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41z = conn.prepareStatement(query);

						pst41z.setString(1, inv21.trim());
						pst41z.setString(2, resultSet12zz.getString("type_name"));
						pst41z.setString(3, resultSet12zz.getString("cgstrate"));
						pst41z.setString(4, resultSet12zz.getString("sgstrate"));
						pst41z.setString(5, resultSet12zz.getString("cgstamount"));
						pst41z.setString(6, resultSet12zz.getString("sgstamount"));
						pst41z.setString(7, resultSet12zz.getString("vat_percent"));
						pst41z.setString(8, resultSet12zz.getString("taxablevalue"));

						pst41z.setString(9, "");
						pst41z.setString(10, bean.getUsername());
						pst41z.setString(11, SystemDateTime.CurrentDateTime());

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

				String qdtc = "delete  from invoice_tax_collection_vendor where invoice_no=? ";
				String inv23 = ib.getInvoiceno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				q1 = "insert into invoice_tax_collection_vendor(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, "");
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

				

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}
				}
				
				
				
				try {
					query = "UPDATE   transportercreditdebit  set Amount=?,Customercode='" + ib.getCustomer_Id()
					+ "' where Documentsno=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
					pst9.setString(1, ib.getTamount());
					pst9.setString(2, inv1);

					k = pst9.executeUpdate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				

			}

			try {

				// DaoHelper.closeconnnection();

			} catch (Exception e) {
			}

		}

		else {

			String query1 = "INSERT INTO invoice_vendor(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,year,username,datetime,order_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst9 = conn.prepareStatement(query1);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(10, ib.getInvoiceno());
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
			pst9.setString(36, "" + ib.getTamount());
			pst9.setString(37, "" + ib.getA2()[0]);
			pst9.setString(38, "" + ib.getA2()[1]);
			pst9.setString(39, "" + ib.getA2()[2]);

			pst9.setString(40, "");
			pst9.setString(41, bean.getUsername());
			pst9.setString(42, SystemDateTime.CurrentDateTime());
			pst9.setString(43, ib.getOrder_id());

			String paid_amt = "";
			String balance_amt = "";
			paid_amt = ib.getPaid_amt();
			balance_amt = ib.getBalance_amt();

			try {
				x = Integer.valueOf(paid_amt);
			} catch (Exception e) {

				x = 0;
			}
			try {
				Y = Integer.valueOf(balance_amt);
			} catch (Exception e) {

				Y = 0;
			}
			// Integer pp=Integer.parseInt(paid_amt);
			// Integer bb=Integer.parseInt(balance_amt);

			// CASH
			if (ib.getPaymod().equalsIgnoreCase("CASH")) {
				pst9.setString(3, "CASH");

				String paid_amt1 = "";

				paid_amt1 = ib.getNet_amount();

				/*
				 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e) {
				 * 
				 * x=0; }
				 */

				pst9.setString(4, paid_amt1);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setInt(8, 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6, java.sql.Types.DATE);
				pst9.setString(11, "" + x);
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");

				pst9.setString(17, "");

				k = pst9.executeUpdate();

			}

			// CHEQUE
			else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

				pst9.setString(3, "CHEQUE");
				Integer l = 0;
				String paid_amt2 = "";
				String chek_amt = "";

				paid_amt2 = ib.getCash_amt();

				chek_amt = ib.getCheque_amt();
				Integer c = 0;
				try {
					l = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					l = 0;
				}
				pst9.setString(4, "" + l);
				pst9.setString(5, "" + 0);

				pst9.setString(7, ib.getCheque_no());
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				String dateInString = ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);
				Date dNow = new Date();

				try {
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				} catch (Exception e) {

					pst9.setString(2, null);
				}

				try {
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
				} catch (Exception e) {

					pst9.setString(6, null);
				}

				pst9.setString(11, "" + 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + c);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "" + ib.getBankname());

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, ib.getCardid());
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setInt(11, 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + a);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, ib.getInsurance());

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + a);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");
				String d = null;
				try {
					d = CoreData.getDateFormatAsDb(ib.getDate22());
				} catch (Exception e) {

					d = null;
				}
				pst9.setString(17, d);
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

			else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

				String paymode = "";
				String paid_amt2 = "";
				String balace = "";
				String chek_amt = "";
				String paycash = "";
				String paycheque = "";
				String paycredit = "";
				paid_amt2 = ib.getPaid_amt();

				if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
					paymode = ib.getR1() + "~" + "CASH";
					pst9.setString(11, paid_amt2);
					pst9.setString(12, "0");
					pst9.setString(13, "0");

				} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

					paymode = ib.getR1() + "~" + "CHEQUE";
					pst9.setString(12, paid_amt2);
					pst9.setString(11, "0");
					pst9.setString(13, "0");
				} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
					paymode = ib.getR1() + "~" + "CARD";
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);

				} else {
					paymode = ib.getPaymod();
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");
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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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

				pst9.setString(4, "" + p);
				/*
				 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; }
				 */
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + paid_amt2);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + credit);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			} else {

				pst9.setString(3, "");

				pst9.setString(4, "");

				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "");

				pst9.setString(12, "");
				pst9.setString(13, "");
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

			// Insert Into Customer Credit Debit Report

			/*String query11 = "insert into transportercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			pst9 = conn.prepareStatement(query11);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(3, ib.getInvoiceno());
			pst9.setString(4, "Invoice");
			pst9.setString(5, "101");
			pst9.setString(6, "Debit");
			pst9.setString(7, ib.getTamount());
			pst9.setString(8, ib.getCustomer_name());

			pst9.setString(9, "");
			pst9.setString(10, bean.getUsername());
			pst9.setString(11, SystemDateTime.CurrentDateTime());

			//System.out.println("SQL:" + pst9);
			k = pst9.executeUpdate();*/

			

			if (k > 0 && v > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			

			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			// list insert

			int rr = 0;
			String q1 = "insert into invoice_tax_details_vendor(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
				
				if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

					
					
				
					
						ib.setUnit("");
					
					
					
					pst41.setString(1, ib.getInvoiceno().trim());

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

					pst41.setString(22, "");
					pst41.setString(23, bean.getUsername());
					pst41.setString(24, SystemDateTime.CurrentDateTime());

					pst41.setString(25, ib.getBatch1()[j1]);
					
					pst41.setString(26, ib.getUnit());

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

			PreparedStatement preparedStatement112zz = conn.prepareStatement(
					"select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details_vendor where invoice_no='"
							+ ib.getInvoiceno() + "'  GROUP BY type_name   ");
			//System.out.println("preparedStatement112" + preparedStatement112zz);
			ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

			while (resultSet12zz.next()) {

				query = "insert into   invoice_hsn_details_vendor  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst41x = conn.prepareStatement(query);

				pst41x.setString(1, ib.getInvoiceno());
				pst41x.setString(2, resultSet12zz.getString("type_name"));
				pst41x.setString(3, resultSet12zz.getString("cgstrate"));
				pst41x.setString(4, resultSet12zz.getString("sgstrate"));
				pst41x.setString(5, resultSet12zz.getString("cgstamount"));
				pst41x.setString(6, resultSet12zz.getString("sgstamount"));
				pst41x.setString(7, resultSet12zz.getString("vat_percent"));
				pst41x.setString(8, resultSet12zz.getString("taxablevalue"));

				pst41x.setString(9, "");
				pst41x.setString(10, bean.getUsername());
				pst41x.setString(11, SystemDateTime.CurrentDateTime());

				//System.out.println(pst41x);
				pst41x.executeUpdate();
			}

			// insert to tax collection
			q1 = "insert into invoice_tax_collection_vendor(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

			pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getT().length; j1++) {

				pst41.setString(1, ib.getInvoiceno());

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

				pst41.setString(6, "");
				pst41.setString(7, bean.getUsername());
				pst41.setString(8, SystemDateTime.CurrentDateTime());

				int js = pst41.executeUpdate();

				if (js > 0) {
					response = "success";
				} else {
					response = "fail";

				}

				// pst41.setString(2,"labour");

			}

			
			
			
			
			
			

		}

		
		
		
	
		
		
		DBConnection.closeConnection();

		return response;
	}
	
	
	
	
	
	
	
	
	
	public String Add_invoice_Customer(invoicebean1 ib, userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();

		int flag1 = 0;

		

		

		//System.out.println("iinFlag Value:" + flag1);
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

		

		String pref = "INV";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;


		try {
			PreparedStatement pst12 = conn.prepareStatement("update escalation_table set invoice_date=? where enq_id=?");
			
			pst12.setString(2, ib.getInquiry_id());
			pst12.setString(1,SystemDateTime.CurrentDateTime());

			pst12.executeUpdate();
			
			System.out.println("<<<<<<<<<<<<<<<----"+pst12);
			}
			catch(Exception e)
			{
				System.out.println(">>>>>>>>>>>>>"+e.getMessage());
			}

		String query = "";
		PreparedStatement preparedStatement = conn.prepareStatement("select * from invoice where  invoice_no=? ");
		String inv = ib.getInvoiceno();
		String inv1 = " " + inv;

		preparedStatement.setString(1, inv1.trim());

		//System.out.println(preparedStatement);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			response = "Already";

			PreparedStatement pst1 = conn
					.prepareStatement("select * from customer_payment_details where invoiceno='" + inv1.trim() + "' ");
			//System.out.println("pst........." + pst1);
			ResultSet rs1 = pst1.executeQuery();
			if (rs1.next()) {

			} else {

				if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

					query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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
					
					
					
					
					


					/*
					 * try {
					 * 
					 * PreparedStatement pps4 = conn.prepareStatement(
					 * "select * from settings "); //
					 * System.out.println("preparedStatement112"+
					 * preparedStatement112); ResultSet rs12s =
					 * pps4.executeQuery();
					 * 
					 * if (rs12s.next()) {
					 * 
					 * if (rs12s.getString("withstock").equals("yes")) {
					 * 
					 * String qd =
					 * "Select *  from invoice_tax_details where invoice_no=? and year='"
					 * + bean.getYearlogin() + "'";
					 * 
					 * // System.out.println("1");
					 * 
					 * String inv2 = ib.getInvno(); String inv21 = " " + inv2;
					 * 
					 * PreparedStatement pstdel = conn.prepareStatement(qd);
					 * pstdel.setString(1, inv21.trim()); //
					 * System.out.println("2");
					 * 
					 * System.out.println("SQL11:" + pstdel); ResultSet rss =
					 * pstdel.executeQuery();
					 * 
					 * while (rss.next()) {
					 * 
					 * // System.out.println(rss.getString("qty"));
					 * 
					 * Double qttsparedet = rss.getDouble("qty");
					 * 
					 * // System.out.println(">>>>>");
					 * 
					 * String a92x =
					 * "select qty,sparecode from stocktablev where sparecode='"
					 * + rss.getString("descrip") + "' ";
					 * 
					 * PreparedStatement pst32x = conn.prepareStatement(a92x);
					 * 
					 * System.out.println("SQL12:" + pst32x);
					 * 
					 * ResultSet resultSet112x = pst32x.executeQuery(a92x);
					 * 
					 * if (resultSet112x.next()) {
					 * 
					 * String sparequantity = resultSet112x.getString("qty");
					 * 
					 * Double qty = Double.parseDouble(sparequantity);
					 * 
					 * Double totalqty = (qty + qttsparedet); String a1022x =
					 * "update stocktablev set qty=" + totalqty +
					 * " where sparecode='" + rss.getString("descrip") + "'  ";
					 * 
					 * PreparedStatement pst1422x =
					 * conn.prepareStatement(a1022x);
					 * 
					 * System.out.println("SQL13:	" + pst1422x);
					 * 
					 * int y = pst1422x.executeUpdate();
					 * 
					 * } }
					 * 
					 * } else {
					 * 
					 * }
					 * 
					 * } } catch (Exception e) {
					 * 
					 * }
					 */

				} else {

					query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,cgstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

						// paid_amt2 = ib.getCash_amt();

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */
						Date dNow = new Date();

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, paid_amt2);

						pst9.setString(12, "0");
						pst9.setString(13, "0");
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						String d = "";
						try {
							d = CoreData.getDateFormatAsDb(ib.getDate22());

						} catch (Exception e) {

						}

						pst9.setString(16, d);

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					}

					else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
						String paymode = "";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";

						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
							paymode = ib.getR1() + "~" + "CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");

						} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

							paymode = ib.getR1() + "~" + "CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
							paymode = ib.getR1() + "~" + "CARD";
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);

						} else {
							paymode = ib.getPaymod();
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, "0");
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

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						/*
						 * pst9.setString(11, "0");
						 * 
						 * pst9.setString(12, "0"); pst9.setString(13, "0");
						 */
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

						pst9.setString(4, "" + p);
						/*
						 * try{ c = Integer.valueOf(balace); }catch (Exception
						 * e) { // TODO: handle exception c=0; }
						 */
						pst9.setString(5, "" + 0);

						pst9.setString(7, "");
						pst9.setString(8, "" + ib.getTrandi());
						pst9.setString(9, "");

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, "" + a);

						pst9.setString(12, "" + 0);
						pst9.setString(13, "" + c);
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						pst9.setString(16, "");

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					} else {

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
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no());
				 * 
				 * j = preparedStatement1121.executeUpdate();
				 * 
				 * response = "success";
				 */

				// update tax_datails
				response = "success";

				String qd = "delete  from invoice_tax_details where invoice_no=? ";
				String inv2 = ib.getInvoiceno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit,lr_no,manual_lr) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

						
					/*	PreparedStatement preparedStatementx1 = conn
								.prepareStatement("select type from bag_config_master where bag_name='"
										+ ib.getDescription1()[j1] + "'");

						
						//System.out.println("SQL:"+preparedStatementx1);
						
						ResultSet resultSetx1 = preparedStatementx1.executeQuery();
						
						if (resultSetx1.next()) {
							
							ib.setUnit(resultSetx1.getString("type"));
						
						} else {
						*/
							ib.setUnit("");
						
						//}
						
						
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

						pst41.setString(22, "");
						pst41.setString(23, bean.getUsername());
						pst41.setString(24, SystemDateTime.CurrentDateTime());

						pst41.setString(25, ib.getBatch1()[j1]);
						
						pst41.setString(26, ib.getUnit());
						
						pst41.setString(27, ib.getAa()[j1]);
						pst41.setString(28, ib.getA2()[j1]);

						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}

					String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
					 inv2 = ib.getInvno();
					 inv21 = " " + inv2;
					PreparedStatement pstdel1 = conn.prepareStatement(qd1);
					pstdel1.setString(1, inv21.trim());

					int n12 = pstdel1.executeUpdate();
				
							PreparedStatement preparedStatement112zz = conn.prepareStatement("select sum(cgstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
							System.out.println("SQL::"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41z = conn.prepareStatement(query);
						
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

				String qdtc = "delete  from invoice_tax_collection where invoice_no=? ";
				String inv23 = ib.getInvoiceno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, "");
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

				

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}
				}
				
				
				
				try {
					query = "UPDATE   customercreditdebit  set Amount=?,Customercode='" + ib.getCustomer_Id()
					+ "' where Documentsno=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
					pst9.setString(1, ib.getTamount());
					pst9.setString(2, inv1);

					k = pst9.executeUpdate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				

			}

			try {

				// DaoHelper.closeconnnection();

			} catch (Exception e) {
			}

		}

		else {
			

try {
			PreparedStatement pst123 = conn.prepareStatement("insert into diley_cashreport(Documentsno,Date,Customercode,Amount,username,datetime,Name,emp_id,cash_source,form_source,type) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			pst123.setString(1,ib.getInvoiceno());
			
			pst123.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst123.setString(3, ib.getInvoiceno());
			
			pst123.setString(4, ib.getTamount());
			
			pst123.setString(5, bean.getUsername());
			
			pst123.setString(6,SystemDateTime.CurrentDateTime());
		
			pst123.setString(7, ib.getCustomer_name());
			
			pst123.setString(8, ib.getCustomer_Id());
			
			pst123.setString(9, " ");
			
			pst123.setString(10, "Customer Invoice CGST");
			pst123.setString(11, "Debit");
			System.out.println(pst123);
			
			pst123.executeUpdate();
			System.out.println("fjdnvgfgg---------------------------"+pst123);
}
catch(Exception e)
{
	
	System.out.println("llllllllllllllllll----------"+e.getMessage());
}





			String query1 = "INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,cgstamount,sgstamount,totaltax,year,username,datetime,order_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst9 = conn.prepareStatement(query1);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(10, ib.getInvoiceno());
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
			pst9.setString(36, "" + ib.getTamount());
			pst9.setString(37, "" + ib.getA2()[0]);
			pst9.setString(38, "" + ib.getA2()[1]);
			pst9.setString(39, "" + ib.getA2()[2]);

			pst9.setString(40, "");
			pst9.setString(41, bean.getUsername());
			pst9.setString(42, SystemDateTime.CurrentDateTime());
			pst9.setString(43, ib.getOrder_id());

			String paid_amt = "";
			String balance_amt = "";
			paid_amt = ib.getPaid_amt();
			balance_amt = ib.getBalance_amt();

			try {
				x = Integer.valueOf(paid_amt);
			} catch (Exception e) {

				x = 0;
			}
			try {
				Y = Integer.valueOf(balance_amt);
			} catch (Exception e) {

				Y = 0;
			}
			// Integer pp=Integer.parseInt(paid_amt);
			// Integer bb=Integer.parseInt(balance_amt);

			// CASH
			if (ib.getPaymod().equalsIgnoreCase("CASH")) {
				pst9.setString(3, "CASH");

				String paid_amt1 = "";

				paid_amt1 = ib.getNet_amount();

				/*
				 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e) {
				 * 
				 * x=0; }
				 */

				pst9.setString(4, paid_amt1);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setInt(8, 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6, java.sql.Types.DATE);
				pst9.setString(11, "" + x);
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");

				pst9.setString(17, "");

				k = pst9.executeUpdate();

			}

			// CHEQUE
			else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

				pst9.setString(3, "CHEQUE");
				Integer l = 0;
				String paid_amt2 = "";
				String chek_amt = "";

				paid_amt2 = ib.getCash_amt();

				chek_amt = ib.getCheque_amt();
				Integer c = 0;
				try {
					l = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					l = 0;
				}
				pst9.setString(4, "" + l);
				pst9.setString(5, "" + 0);

				pst9.setString(7, ib.getCheque_no());
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				String dateInString = ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);
				Date dNow = new Date();

				try {
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				} catch (Exception e) {

					pst9.setString(2, null);
				}

				try {
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
				} catch (Exception e) {

					pst9.setString(6, null);
				}

				pst9.setString(11, "" + 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + c);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "" + ib.getBankname());

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, ib.getCardid());
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setInt(11, 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + a);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, ib.getInsurance());

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + a);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");
				String d = null;
				try {
					d = CoreData.getDateFormatAsDb(ib.getDate22());
				} catch (Exception e) {

					d = null;
				}
				pst9.setString(17, d);
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

			else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

				String paymode = "";
				String paid_amt2 = "";
				String balace = "";
				String chek_amt = "";
				String paycash = "";
				String paycheque = "";
				String paycredit = "";
				paid_amt2 = ib.getPaid_amt();

				if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
					paymode = ib.getR1() + "~" + "CASH";
					pst9.setString(11, paid_amt2);
					pst9.setString(12, "0");
					pst9.setString(13, "0");

				} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

					paymode = ib.getR1() + "~" + "CHEQUE";
					pst9.setString(12, paid_amt2);
					pst9.setString(11, "0");
					pst9.setString(13, "0");
				} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
					paymode = ib.getR1() + "~" + "CARD";
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);

				} else {
					paymode = ib.getPaymod();
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");
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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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

				pst9.setString(4, "" + p);
				/*
				 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; }
				 */
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + paid_amt2);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + credit);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			} else {

				pst9.setString(3, "");

				pst9.setString(4, "");

				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "");

				pst9.setString(12, "");
				pst9.setString(13, "");
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

		// Insert Into Customer Credit Debit Report

			String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			pst9 = conn.prepareStatement(query11);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(3, ib.getInvoiceno());
			pst9.setString(4, "Invoice");
			pst9.setString(5, "101");
			pst9.setString(6, "Debit");
			pst9.setString(7, ib.getTamount());
			pst9.setString(8, ib.getCustomer_name());

			pst9.setString(9, "");
			pst9.setString(10, bean.getUsername());
			pst9.setString(11, SystemDateTime.CurrentDateTime());

			//System.out.println("SQL:" + pst9);
			k = pst9.executeUpdate();

			

			if (k > 0 && v > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			

			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			// list insert

			int rr = 0;
			String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit,lr_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
				
				if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

					
					
				
					
						ib.setUnit("");
					
					
					
					pst41.setString(1, ib.getInvoiceno().trim());

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

					pst41.setString(22, "");
					pst41.setString(23, bean.getUsername());
					pst41.setString(24, SystemDateTime.CurrentDateTime());

					pst41.setString(25, ib.getBatch1()[j1]);
					
					pst41.setString(26, ib.getUnit());
					
					pst41.setString(27, ib.getAa()[j1]);

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

			PreparedStatement preparedStatement112zz = conn.prepareStatement(
					"select sum(cgstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,cgstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"
							+ ib.getInvoiceno() + "'  GROUP BY type_name   ");
			//System.out.println("preparedStatement112" + preparedStatement112zz);
			ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

			while (resultSet12zz.next()) {

				query = "insert into   invoice_hsn_details  (invoiceno,hsncode,cgstrate,sgstrate,cgstamount,sgstamount,rate, taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst41x = conn.prepareStatement(query);

				pst41x.setString(1, ib.getInvoiceno());
				pst41x.setString(2, resultSet12zz.getString("type_name"));
				pst41x.setString(3, resultSet12zz.getString("cgstrate"));
				pst41x.setString(4, resultSet12zz.getString("sgstrate"));
				pst41x.setString(5, resultSet12zz.getString("cgstamount"));
				pst41x.setString(6, resultSet12zz.getString("sgstamount"));
				pst41x.setString(7, resultSet12zz.getString("vat_percent"));
				pst41x.setString(8, resultSet12zz.getString("taxablevalue"));

				pst41x.setString(9, "");
				pst41x.setString(10, bean.getUsername());
				pst41x.setString(11, SystemDateTime.CurrentDateTime());

				//System.out.println(pst41x);
				pst41x.executeUpdate();
			}

			// insert to tax collection
			q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

			pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getT().length; j1++) {

				pst41.setString(1, ib.getInvoiceno());

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

				pst41.setString(6, "");
				pst41.setString(7, bean.getUsername());
				pst41.setString(8, SystemDateTime.CurrentDateTime());

				int js = pst41.executeUpdate();

				if (js > 0) {
					response = "success";
				} else {
					response = "fail";

				}

				// pst41.setString(2,"labour");

			}

			
			
			////////////////Invoice Done Update////////////// 	
			
			try {
	

				for (int l = 0; l < ib.getAa().length; l++) {
		
					String query111="update delivery_done1 set status='1' where LR_no='"+ib.getAa()[l]+"' ";
		
		
					PreparedStatement pst11=conn.prepareStatement(query111);

					System.out.println("SQL"+pst11);
		
					pst11.executeUpdate();
				}
	
			} catch (Exception e) {
	
				System.out.println(e.getMessage());
			}
	
			

			
			
		}

			
		
		DBConnection.closeConnection();

		return response;
	}
	
	
	
	public String Add_invoice_Customer_Igst(invoicebean1 ib, userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();

		int flag1 = 0;

		

		

		//System.out.println("iinFlag Value:" + flag1);
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

		

		String pref = "INV";

		PreparedStatement pst9 = null;
		PreparedStatement pst99 = null;

		

		try {
			PreparedStatement pst12 = conn.prepareStatement("update escalation_table set invoice_date=? where enq_id=?");
			
			pst12.setString(2, ib.getInquiry_id());
			pst12.setString(1,SystemDateTime.CurrentDateTime());

			pst12.executeUpdate();
			
			}
			catch(Exception e)
			{
				System.out.println(">>>>>>>>>>>>>"+e.getMessage());
			}
		
		
		String query = "";
		PreparedStatement preparedStatement = conn.prepareStatement("select * from invoice where  invoice_no=? ");
		String inv = ib.getInvoiceno();
		String inv1 = " " + inv;

		preparedStatement.setString(1, inv1.trim());

		//System.out.println(preparedStatement);

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {

			response = "Already";

			PreparedStatement pst1 = conn
					.prepareStatement("select * from customer_payment_details where invoiceno='" + inv1.trim() + "' ");
			//System.out.println("pst........." + pst1);
			ResultSet rs1 = pst1.executeQuery();
			if (rs1.next()) {

			} else {

				if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

					query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termcond=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

					/*
					 * try {
					 * 
					 * PreparedStatement pps4 = conn.prepareStatement(
					 * "select * from settings "); //
					 * System.out.println("preparedStatement112"+
					 * preparedStatement112); ResultSet rs12s =
					 * pps4.executeQuery();
					 * 
					 * if (rs12s.next()) {
					 * 
					 * if (rs12s.getString("withstock").equals("yes")) {
					 * 
					 * String qd =
					 * "Select *  from invoice_tax_details where invoice_no=? and year='"
					 * + bean.getYearlogin() + "'";
					 * 
					 * // System.out.println("1");
					 * 
					 * String inv2 = ib.getInvno(); String inv21 = " " + inv2;
					 * 
					 * PreparedStatement pstdel = conn.prepareStatement(qd);
					 * pstdel.setString(1, inv21.trim()); //
					 * System.out.println("2");
					 * 
					 * System.out.println("SQL11:" + pstdel); ResultSet rss =
					 * pstdel.executeQuery();
					 * 
					 * while (rss.next()) {
					 * 
					 * // System.out.println(rss.getString("qty"));
					 * 
					 * Double qttsparedet = rss.getDouble("qty");
					 * 
					 * // System.out.println(">>>>>");
					 * 
					 * String a92x =
					 * "select qty,sparecode from stocktablev where sparecode='"
					 * + rss.getString("descrip") + "' ";
					 * 
					 * PreparedStatement pst32x = conn.prepareStatement(a92x);
					 * 
					 * System.out.println("SQL12:" + pst32x);
					 * 
					 * ResultSet resultSet112x = pst32x.executeQuery(a92x);
					 * 
					 * if (resultSet112x.next()) {
					 * 
					 * String sparequantity = resultSet112x.getString("qty");
					 * 
					 * Double qty = Double.parseDouble(sparequantity);
					 * 
					 * Double totalqty = (qty + qttsparedet); String a1022x =
					 * "update stocktablev set qty=" + totalqty +
					 * " where sparecode='" + rss.getString("descrip") + "'  ";
					 * 
					 * PreparedStatement pst1422x =
					 * conn.prepareStatement(a1022x);
					 * 
					 * System.out.println("SQL13:	" + pst1422x);
					 * 
					 * int y = pst1422x.executeUpdate();
					 * 
					 * } }
					 * 
					 * } else {
					 * 
					 * }
					 * 
					 * } } catch (Exception e) {
					 * 
					 * }
					 */

				} else {

					query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,sgstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

						// paid_amt2 = ib.getCash_amt();

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */
						Date dNow = new Date();

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, paid_amt2);

						pst9.setString(12, "0");
						pst9.setString(13, "0");
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						String d = "";
						try {
							d = CoreData.getDateFormatAsDb(ib.getDate22());

						} catch (Exception e) {

						}

						pst9.setString(16, d);

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					}

					else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
						String paymode = "";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";

						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
							paymode = ib.getR1() + "~" + "CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");

						} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

							paymode = ib.getR1() + "~" + "CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
							paymode = ib.getR1() + "~" + "CARD";
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);

						} else {
							paymode = ib.getPaymod();
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, "0");
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

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						/*
						 * pst9.setString(11, "0");
						 * 
						 * pst9.setString(12, "0"); pst9.setString(13, "0");
						 */
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

						pst9.setString(4, "" + p);
						/*
						 * try{ c = Integer.valueOf(balace); }catch (Exception
						 * e) { // TODO: handle exception c=0; }
						 */
						pst9.setString(5, "" + 0);

						pst9.setString(7, "");
						pst9.setString(8, "" + ib.getTrandi());
						pst9.setString(9, "");

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, "" + a);

						pst9.setString(12, "" + 0);
						pst9.setString(13, "" + c);
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						pst9.setString(16, "");

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					} else {

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
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no());
				 * 
				 * j = preparedStatement1121.executeUpdate();
				 * 
				 * response = "success";
				 */

				// update tax_datails
				response = "success";

				String qd = "delete  from invoice_tax_details where invoice_no=? ";
				String inv2 = ib.getInvoiceno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit,lr_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);

				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

						
					
							ib.setUnit("");
						
						
						
						pst41.setString(1, ib.getInvoiceno());

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
						pst41.setString(12, "");
						pst41.setString(13, "");
						pst41.setString(14, ib.getMyrate()[j1]);
						pst41.setString(15, ib.getPartno()[j1]);
						pst41.setString(16, ib.getPartdate()[j1]);
						pst41.setString(17, ib.getPartnox()[j1]);
						pst41.setString(18, ib.getDisc()[j1]);
						pst41.setString(19, ib.getDiscamt()[j1]);
						pst41.setString(20, ib.getAmtwithdisc()[j1]);
						pst41.setString(21, ib.getPerunit()[j1]);

						pst41.setString(22, "");
						pst41.setString(23, bean.getUsername());
						pst41.setString(24, SystemDateTime.CurrentDateTime());

						pst41.setString(25, ib.getBatch1()[j1]);
						
						pst41.setString(26, ib.getUnit());
						
						pst41.setString(27, ib.getAa()[j1]);

						i = i++;
						String sn = "" + i;

						ib.setSn(sn);

						l1 = pst41.executeUpdate();

					}

					String qd1 = "delete  from invoice_hsn_details where invoiceno=?";
					 inv2 = ib.getInvoiceno();
					 inv21 = " " + inv2;
					PreparedStatement pstdel1 = conn.prepareStatement(qd1);
					pstdel1.setString(1, inv21.trim());

					int n12 = pstdel1.executeUpdate();
				
							PreparedStatement preparedStatement112zz = conn.prepareStatement("select sum(igstamount) as cgstamount,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue, sgstrate,igstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"+inv21.trim()+"' GROUP BY type_name   ");
							System.out.println("SQL::"+preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {
							
						query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,sgstrate,igstamount,sgstamount,rate, taxablevalue) values (?,?,?,?,?,?,?,?) ";
						PreparedStatement pst41z = conn.prepareStatement(query);
						
						pst41z.setString(1, inv21.trim());	
						pst41z.setString(2, resultSet12zz.getString("type_name"));	
						pst41z.setString(3, resultSet12zz.getString("igstrate"));	
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

				String qdtc = "delete  from invoice_tax_collection where invoice_no=? ";
				String inv23 = ib.getInvoiceno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, "");
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

				

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}
				}
				
				
				
				try {
					query = "UPDATE   customercreditdebit  set Amount=?,Customercode='" + ib.getCustomer_Id()
					+ "' where Documentsno=? ";

					inv1 = ib.getInvoiceno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
					pst9.setString(1, ib.getTamount());
					pst9.setString(2, inv1);

					k = pst9.executeUpdate();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				

			}

			try {

				// DaoHelper.closeconnnection();

			} catch (Exception e) {
			}

		}

		else {
			

			try {
			PreparedStatement pst123 = conn.prepareStatement("insert into diley_cashreport(Documentsno,Date,Customercode,Amount,username,datetime,Name,emp_id,cash_source,form_source,type) values(?,?,?,?,?,?,?,?,?,?,?)");
			
			pst123.setString(1,ib.getInvoiceno());
			
			pst123.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			
			pst123.setString(3, ib.getInvoiceno());
			
			pst123.setString(4, ib.getTamount());
			
			pst123.setString(5, bean.getUsername());
			
			pst123.setString(6,SystemDateTime.CurrentDateTime());
		
			pst123.setString(7, ib.getCustomer_name());
			
			pst123.setString(8, ib.getCustomer_Id());
			
			pst123.setString(9, " ");
			
			pst123.setString(10, "Customer Invoice IGST");
			pst123.setString(11, "Debit");
			System.out.println(pst123);
			
			pst123.executeUpdate();
			System.out.println("fjdnvgfgg---------------------------"+pst123);
			}
				catch(Exception e)
			{
	
					System.out.println("llllllllllllllllll----------"+e.getMessage());
			}	
			
			
			
			
			

			String query1 = "INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termcond,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,igstamount,sgstamount,totaltax,year,username,datetime,order_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst9 = conn.prepareStatement(query1);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(10, ib.getInvoiceno());
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
			pst9.setString(36, "" + ib.getTamount());
			pst9.setString(37, "" + ib.getA2()[0]);
			pst9.setString(38, "" + ib.getA2()[1]);
			pst9.setString(39, "" + ib.getA2()[2]);

			pst9.setString(40, "");
			pst9.setString(41, bean.getUsername());
			pst9.setString(42, SystemDateTime.CurrentDateTime());
			pst9.setString(43, ib.getOrder_id());

			String paid_amt = "";
			String balance_amt = "";
			paid_amt = ib.getPaid_amt();
			balance_amt = ib.getBalance_amt();

			try {
				x = Integer.valueOf(paid_amt);
			} catch (Exception e) {

				x = 0;
			}
			try {
				Y = Integer.valueOf(balance_amt);
			} catch (Exception e) {

				Y = 0;
			}
			// Integer pp=Integer.parseInt(paid_amt);
			// Integer bb=Integer.parseInt(balance_amt);

			// CASH
			if (ib.getPaymod().equalsIgnoreCase("CASH")) {
				pst9.setString(3, "CASH");

				String paid_amt1 = "";

				paid_amt1 = ib.getNet_amount();

				/*
				 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e) {
				 * 
				 * x=0; }
				 */

				pst9.setString(4, paid_amt1);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setInt(8, 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setNull(6, java.sql.Types.DATE);
				pst9.setString(11, "" + x);
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(18, "0");
				pst9.setString(16, "");

				pst9.setString(17, "");

				k = pst9.executeUpdate();

			}

			// CHEQUE
			else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

				pst9.setString(3, "CHEQUE");
				Integer l = 0;
				String paid_amt2 = "";
				String chek_amt = "";

				paid_amt2 = ib.getCash_amt();

				chek_amt = ib.getCheque_amt();
				Integer c = 0;
				try {
					l = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					l = 0;
				}
				pst9.setString(4, "" + l);
				pst9.setString(5, "" + 0);

				pst9.setString(7, ib.getCheque_no());
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				String dateInString = ib.getCheque_date();
				Date dNo = new Date();
				dNo = ft.parse(dateInString);
				Date dNow = new Date();

				try {
					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				} catch (Exception e) {

					pst9.setString(2, null);
				}

				try {
					pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
				} catch (Exception e) {

					pst9.setString(6, null);
				}

				pst9.setString(11, "" + 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + c);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "" + ib.getBankname());

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, ib.getCardid());
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setInt(11, 0);
				try {
					c = Integer.valueOf(chek_amt);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + a);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, ib.getInsurance());

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + a);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + 0);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");
				String d = null;
				try {
					d = CoreData.getDateFormatAsDb(ib.getDate22());
				} catch (Exception e) {

					d = null;
				}
				pst9.setString(17, d);
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

			else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

				String paymode = "";
				String paid_amt2 = "";
				String balace = "";
				String chek_amt = "";
				String paycash = "";
				String paycheque = "";
				String paycredit = "";
				paid_amt2 = ib.getPaid_amt();

				if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
					paymode = ib.getR1() + "~" + "CASH";
					pst9.setString(11, paid_amt2);
					pst9.setString(12, "0");
					pst9.setString(13, "0");

				} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

					paymode = ib.getR1() + "~" + "CHEQUE";
					pst9.setString(12, paid_amt2);
					pst9.setString(11, "0");
					pst9.setString(13, "0");
				} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
					paymode = ib.getR1() + "~" + "CARD";
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, paid_amt2);

				} else {
					paymode = ib.getPaymod();
					pst9.setString(11, "0");

					pst9.setString(12, "0");
					pst9.setString(13, "0");
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
				pst9.setString(4, "" + a);
				try {
					c = Integer.valueOf(balace);
				} catch (Exception e) {

					c = 0;
				}
				pst9.setString(5, "" + c);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

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

				pst9.setString(4, "" + p);
				/*
				 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; }
				 */
				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
				/*
				 * String dateInString=ib.getCheque_date(); Date dNo = new
				 * Date(); dNo = ft.parse(dateInString);
				 */
				Date dNow = new Date();

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "" + paid_amt2);

				pst9.setString(12, "" + 0);
				pst9.setString(13, "" + credit);
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			} else {

				pst9.setString(3, "");

				pst9.setString(4, "");

				pst9.setString(5, "" + 0);

				pst9.setString(7, "");
				pst9.setString(8, "" + 0);
				pst9.setString(9, "");

				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

				pst9.setNull(6, java.sql.Types.DATE);

				pst9.setString(11, "");

				pst9.setString(12, "");
				pst9.setString(13, "");
				pst9.setString(15, "" + ib.getTamount());
				pst9.setString(16, "");

				pst9.setString(17, "");
				pst9.setString(18, "0");

				k = pst9.executeUpdate();

			}

			// Insert Into Customer Credit Debit Report

			String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

			pst9 = conn.prepareStatement(query11);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(3, ib.getInvoiceno());
			pst9.setString(4, "Invoice");
			pst9.setString(5, "101");
			pst9.setString(6, "Debit");
			pst9.setString(7, ib.getTamount());
			pst9.setString(8, ib.getCustomer_name());

			pst9.setString(9, "");
			pst9.setString(10, bean.getUsername());
			pst9.setString(11, SystemDateTime.CurrentDateTime());

			//System.out.println("SQL:" + pst9);
			k = pst9.executeUpdate();

			

			if (k > 0 && v > 0) {
				response = "success";
			} else {
				response = "fail";

			}

			

			/////////////////////////////////////////////////////////////////////////////////////////////////////////

			// list insert

			int rr = 0;
			String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,perunitqty,year,username,datetime,batch,unit,lr_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
				
				if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

					
					
				
					
						ib.setUnit("");
					
					
					
					pst41.setString(1, ib.getInvoiceno().trim());

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
					pst41.setString(12, "");
					pst41.setString(13, "");
					pst41.setString(14, ib.getMyrate()[j1]);
					pst41.setString(15, ib.getPartno()[j1]);
					pst41.setString(16, ib.getPartdate()[j1]);
					pst41.setString(17, ib.getPartnox()[j1]);
					pst41.setString(18, ib.getDisc()[j1]);
					pst41.setString(19, ib.getDiscamt()[j1]);
					pst41.setString(20, ib.getAmtwithdisc()[j1]);
					pst41.setString(21, ib.getPerunit()[j1]);

					pst41.setString(22, "");
					pst41.setString(23, bean.getUsername());
					pst41.setString(24, SystemDateTime.CurrentDateTime());

					pst41.setString(25, ib.getBatch1()[j1]);
					
					pst41.setString(26, ib.getUnit());
					
					pst41.setString(27, ib.getAa()[j1]);

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

			PreparedStatement preparedStatement112zz = conn.prepareStatement(
					"select sum(igstamount) as cgstamount ,sum(sgstamount) as sgstamount,sum(amtwithdisc) as taxablevalue , sgstrate,igstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"
							+ ib.getInvoiceno() + "'  GROUP BY type_name   ");
			//System.out.println("preparedStatement112" + preparedStatement112zz);
			ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

			while (resultSet12zz.next()) {

				query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,sgstrate,igstamount,sgstamount,rate, taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement pst41x = conn.prepareStatement(query);

				pst41x.setString(1, ib.getInvoiceno());
				pst41x.setString(2, resultSet12zz.getString("type_name"));
				pst41x.setString(3, resultSet12zz.getString("igstrate"));
				pst41x.setString(4, resultSet12zz.getString("sgstrate"));
				pst41x.setString(5, resultSet12zz.getString("cgstamount"));
				pst41x.setString(6, resultSet12zz.getString("sgstamount"));
				pst41x.setString(7, resultSet12zz.getString("vat_percent"));
				pst41x.setString(8, resultSet12zz.getString("taxablevalue"));

				pst41x.setString(9, "");
				pst41x.setString(10, bean.getUsername());
				pst41x.setString(11, SystemDateTime.CurrentDateTime());

				//System.out.println(pst41x);
				pst41x.executeUpdate();
			}

			// insert to tax collection
			q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

			pst41 = conn.prepareStatement(q1);
			for (int j1 = 0; j1 < ib.getT().length; j1++) {

				pst41.setString(1, ib.getInvoiceno());

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

				pst41.setString(6, "");
				pst41.setString(7, bean.getUsername());
				pst41.setString(8, SystemDateTime.CurrentDateTime());

				int js = pst41.executeUpdate();

				if (js > 0) {
					response = "success";
				} else {
					response = "fail";

				}

				// pst41.setString(2,"labour");

			}

			
			
			////////////////Invoice Done Update////////////// 	
			
			try {
	

				for (int l = 0; l < ib.getAa().length; l++) {
		
					String query111="update delivery_done1 set status='1' where LR_no='"+ib.getAa()[l]+"' ";
		
		
					PreparedStatement pst11=conn.prepareStatement(query111);

					System.out.println("SQL"+pst11);
		
					pst11.executeUpdate();
				}
	
			} catch (Exception e) {
	
				System.out.println(e.getMessage());
			}
	
			

		}

			
		
		DBConnection.closeConnection();

		return response;
	}
	
	
	

	public String insertdescinfo(String sparename, String model, String cprice, String comprice, String taxtype,
			String taxper, String remark, String unit, userinfo bean) throws Exception {
		String response = "";

		Connection conn=connection.getConnection();
		PreparedStatement pst41;

		String q1 = "insert into spare_master(spare_name,description,company_price,cust_price,tax_type,tax_percent,remark,spare_id,model,unit,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

		pst41 = conn.prepareStatement(q1);

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

		pst41.setString(11, "");
		pst41.setString(12, bean.getUsername());
		pst41.setString(13, SystemDateTime.CurrentDateTime());

		int HH = pst41.executeUpdate();

		if (HH > 0) {
			response = "success";
		} else {
			response = "fail";

		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {

		}
		
		
		
		DBConnection.closeConnection();
		
		return response;
	}

	public String insertdescinfo1(String service_name, String tax_type, String taxpercent, String amount,
			userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();
		
		PreparedStatement pst41;

		String q1 = "insert into stax_master(service_tax_name,tax_percent,tax_type,amount,year,username,datetime) values(?,?,?,?,?,?,?)";

		pst41 = conn.prepareStatement(q1);

		pst41.setString(1, service_name);
		String tax = taxpercent;
		float ta = 0.0f;
		ta = Float.parseFloat(tax);
		pst41.setFloat(2, ta);
		pst41.setString(3, tax_type);
		pst41.setString(4, amount);

		pst41.setString(5, "");
		pst41.setString(6, bean.getUsername());
		pst41.setString(7, SystemDateTime.CurrentDateTime());

		int HH = pst41.executeUpdate();

		if (HH > 0) {
			response = "success";
		} else {
			response = "fail";

		}
		try {
			if (!conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {

		}
		
		
		
		DBConnection.closeConnection();
		
		return response;

	}

	public invoicebean1 FetchspareGatepassAssemblyform(String autoinvoice, userinfo bean) {

		Connection conn=connection.getConnection();
		
		invoicebean1 ib = new invoicebean1();
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
		List<String> rate2 = new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2 = new ArrayList<String>();
		List<String> myrate = new ArrayList<String>();
		List<String> partno = new ArrayList<String>();
		List<String> partdate = new ArrayList<String>();
		List<String> partnox = new ArrayList<String>();
		List<String> dcno = new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		List<String> batch = new ArrayList<String>();
		try {
			int sno = 1;

			// connnection conn = DaoHelper.getconnnection();

			PreparedStatement pst = conn
					.prepareStatement("select * from invoice_tax_details  where invoice_no='" + autoinvoice + "' ");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String ty = rs.getString("type");

				if (ty.equalsIgnoreCase("parts")) {
					type.add("PARTS");
				}

				if (ty.equalsIgnoreCase("labour")) {
					type.add("LABOUR");
				}

				descrip.add(rs.getString("descrip"));
				batch.add(rs.getString("batch"));
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
				System.out.println(">>>" + rs.getString("amtwithdisc"));

				sparesize++;
			}

			try {
				// DaoHelper.closeconnnection();
			} catch (Exception e) {

			}

		} catch (Exception e) {

		}
		ib.setSparesize(sparesize);
		ib.setType1(type);
		ib.setDescrip1(descrip);

		ib.setBatcht(batch);
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

		
		DBConnection.closeConnection();
		
		return ib;

	}

	public invoicebean1 FetchspareGatepassAssemblyformSales(String autoinvoice, userinfo bean) {

		invoicebean1 ib = new invoicebean1();
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
		List<String> rate2 = new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2 = new ArrayList<String>();
		List<String> myrate = new ArrayList<String>();
		List<String> partno = new ArrayList<String>();
		List<String> partdate = new ArrayList<String>();
		List<String> partnox = new ArrayList<String>();
		List<String> dcno = new ArrayList<String>();
		try {
			int sno = 1;

			Connection conn=connection.getConnection();

			PreparedStatement pst = conn.prepareStatement(
					"select * from invoice_tax_details_sales_return  where invoice_no='" + autoinvoice + "'");

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

			try {
				// DaoHelper.closeconnnection();
			} catch (Exception e) {

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
		
		
		DBConnection.closeConnection();
		return ib;

	}

	// Add purchase order

	public String Add_purchaseorder(invoicebean1 ib, userinfo bean) throws Exception {

		int k = 0;

		Integer x = 0;

		String response = null;
		
		Connection conn=connection.getConnection();
		
		/*
		 * // fiscal year int result = -1; Date date = new Date(); if (date !=
		 * null) { Calendar cal = Calendar.getInstance(); cal.setTime(date);
		 * result = cal.get(Calendar.MONTH) + 1; } int result1 = -1; if (date !=
		 * null) { Calendar cal = Calendar.getInstance(); cal.setTime(date);
		 * result1 = cal.get(Calendar.YEAR); } String year = ""; String yy = "";
		 * String yy1 = ""; yy = "" + result1;
		 * 
		 * yy1 = yy.substring(2, 4);
		 * 
		 * int pp = 0; pp = Integer.parseInt(yy1);
		 * 
		 * if (result <= 3) { year = "" + (result1 - 1); } else {
		 * 
		 * year = "" + result1;
		 * 
		 * }
		 * 
		 * if (result <= 3) { Fyear = (result1 - 1) + "-" + pp; } else {
		 * 
		 * Fyear = result1 + "-" + (pp + 1);
		 * 
		 * }
		 * 
		 * String FMONTH = "" + result;
		 */

		String Fyear = bean.getYearlogin();
		String pref = "PO";

		PreparedStatement pst9 = null;

		// String pref="INV";
		PreparedStatement preparedStatement11 = conn.prepareStatement(
				"select  max(SUBSTRING(invoice_no,-5)) as myval1 from purchase_order  where LENGTH(invoice_no)>5 and year='"
						+ Fyear + "'");

		// preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
			stringValue1 = pref + "/" + Fyear + "/0000" + stringValue1;

		} else {

			if (String.valueOf(myval1).length() == 1) {
				stringValue1 = pref + "/" + Fyear + "/0000" + String.valueOf(myval1);

			} else if (String.valueOf(myval1).length() == 2) {
				stringValue1 = pref + "/" + Fyear + "/000" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 3) {
				stringValue1 = pref + "/" + Fyear + "/00" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 4) {
				stringValue1 = pref + "/" + Fyear + "/0" + String.valueOf(myval1);
			} else {
				stringValue1 = pref + "/" + Fyear + "/" + String.valueOf(myval1);
			}
		}

		ib.setInvoiceno(stringValue1);
		String query = "";
		PreparedStatement preparedStatement = conn
				.prepareStatement("select * from purchase_order where  pono=? and year='" + bean.getYearlogin() + "'");

		preparedStatement.setString(1, ib.getPono());

		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			response = "Already";

		} else {

			String query1 = "INSERT INTO purchase_order(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termconnd,vendor,name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst9 = conn.prepareStatement(query1);
			pst9.setString(1, ib.getCustomer_Id());
			pst9.setString(10, stringValue1);
			pst9.setString(14, ib.getJob_Card_no());
			pst9.setString(19, ib.getPono());
			pst9.setString(20, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(21, ib.getTermcond());
			pst9.setString(22, ib.getVendor());
			pst9.setString(23, ib.getCustomer_name());

			pst9.setString(24, bean.getYearlogin());
			pst9.setString(25, bean.getUsername());
			pst9.setString(26, SystemDateTime.CurrentDateTime());

			// Integer pp=Integer.parseInt(paid_amt);
			// Integer bb=Integer.parseInt(balance_amt);

			// CASH

			pst9.setString(3, "CASH");

			pst9.setString(4, "" + x);
			pst9.setString(5, "" + 0);

			pst9.setString(7, "");
			pst9.setInt(8, 0);
			pst9.setString(9, "");

			pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst9.setString(6, null);
			pst9.setString(11, "");
			pst9.setString(12, "");
			pst9.setString(13, "");
			pst9.setString(15, "" + ib.getTamount());
			pst9.setString(18, "0");
			pst9.setString(16, "");

			pst9.setString(17, "");

			k = pst9.executeUpdate();

			// list insert

			int rr = 0;
			String q1 = "insert into purchase_order_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,disc,discamt,qtyremaining,dcqty,custid,pono,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pst41 = conn.prepareStatement(q1);
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
					pst41.setString(17, "" + Quantity1);
					pst41.setString(18, "" + Quantity1);
					pst41.setString(19, ib.getCustomer_Id());
					pst41.setString(20, ib.getPono());

					pst41.setString(21, bean.getYearlogin());
					pst41.setString(22, bean.getUsername());
					pst41.setString(23, SystemDateTime.CurrentDateTime());

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

			response = "success";
			// pst41.setString(2,"labour");

		}

		// -----

		try {

			// DaoHelper.closeconnnection();

		} catch (Exception e) {

		}
		
		DBConnection.closeConnection();

		return response;

	}

	public String insertCustomerInfoIgst(invoicebean1 ib, userinfo bean) throws Exception {
		// TODO Auto-generated method stub
		String response = "";

		Connection conn=connection.getConnection();
		
		int flag1 = 0;

		/*PreparedStatement preparedStatement112z = conn.prepareStatement("select * from settings ");
		
		ResultSet resultSet12z = preparedStatement112z.executeQuery();

		if (resultSet12z.next()) {

			if (resultSet12z.getString("po").equals("yes")) {

				for (int mx = 0; mx < ib.getDescription1().length; mx++) {
					if (ib.getDescription1()[mx] != "") {

						Double qtyremaining = 0.0;
						PreparedStatement preparedStatementx = conn
								.prepareStatement("select * from purchase_order_details where descrip=? and pono='"
										+ ib.getPono() + "' and year='" + bean.getYearlogin() + "'  ");
						preparedStatementx.setString(1, ib.getDescription1()[mx]);
						System.out.println("SQL:" + preparedStatementx);
						ResultSet resultSetx = preparedStatementx.executeQuery();
						if (resultSetx.next()) {
							Double qtyentered = Double.parseDouble(ib.getQuantity1()[mx]);

							try {
								qtyremaining = Double.parseDouble(resultSetx.getString("qtyremaining"));
							} catch (Exception e) {
								qtyremaining = 0.0;
							}
							System.out.println(qtyremaining + ">>>>" + qtyentered);

							if (qtyremaining < qtyentered) {
								// System.out.println("AAA");
								response = "Notsuffqty";
								// System.out.println("AAA12");
								flag1 = 1;
								// System.out.println("AAA23");
								break;
							}
						} else {
							response = "Notsuffqty";
							flag1 = 1;
						}

					}

				}
				System.out.println("Flag Value:" + flag1);
			}

		}*/

		// Stock Check

		/*PreparedStatement pps = conn.prepareStatement("select * from settings ");
		// System.out.println("preparedStatement112"+preparedStatement112);
		ResultSet rs12 = pps.executeQuery();

		if (rs12.next()) {

			if (rs12.getString("withstock").equals("yes")) {

				for (int mx = 0; mx < ib.getDescription1().length; mx++) {
					if (ib.getDescription1()[mx] != "") {

						Double qtyremaining = 0.0;

						PreparedStatement preparedStatementx = conn
								.prepareStatement("select * from stocktablev where sparecode=?  ");

						preparedStatementx.setString(1, ib.getDescription1()[mx]);

						System.out.println("SQL:" + preparedStatementx);

						ResultSet resultSetx = preparedStatementx.executeQuery();

						if (resultSetx.next()) {

							Double qtyentered = Double.parseDouble(ib.getQuantity1()[mx]);

							try {
								qtyremaining = Double.parseDouble(resultSetx.getString("qty"));
							} catch (Exception e) {
								qtyremaining = 0.0;
							}
							System.out.println(qtyremaining + ">>>>" + qtyentered);

							if (qtyremaining < qtyentered) {

								// System.out.println("AAA");
								response = "NotsuffqtyStock";

								ib.setVvtaxtype(ib.getDescription1()[mx]);

								ib.setQuantity(ib.getQuantity1()[mx]);

								// System.out.println("AAA12");
								flag1 = 1;
								// System.out.println("AAA23");
								break;
							}
						}

						else {
							response = "NotsuffqtyStock";

							ib.setVvtaxtype(ib.getDescription1()[mx]);

							ib.setQuantity(ib.getQuantity1()[mx]);

							// System.out.println("AAA12");
							flag1 = 1;
							// System.out.println("AAA23");
							break;
						}

					}

				}
				System.out.println("Flag Value:" + flag1);
			}

		}*/

		if (flag1 == 0) {
			System.out.println("iinFlag Value:" + flag1);
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
			/*
			 * int result = -1; Date date = new Date(); if (date != null) {
			 * Calendar cal = Calendar.getInstance(); cal.setTime(date); result
			 * = cal.get(Calendar.MONTH) + 1; } int result1 = -1; if (date !=
			 * null) { Calendar cal = Calendar.getInstance(); cal.setTime(date);
			 * result1 = cal.get(Calendar.YEAR); } String year = ""; String yy =
			 * ""; String yy1 = ""; yy = "" + result1;
			 * 
			 * yy1 = yy.substring(2, 4);
			 * 
			 * int pp = 0; pp = Integer.parseInt(yy1);
			 * 
			 * if (result <= 3) { year = "" + (result1 - 1); } else {
			 * 
			 * year = "" + result1;
			 * 
			 * } String Fyear = ""; if (result <= 3) { Fyear = (result1 - 1) +
			 * "-" + pp; } else {
			 * 
			 * Fyear = result1 + "-" + (pp + 1);
			 * 
			 * }
			 * 
			 * String FMONTH = "" + result;
			 */

			String Fyear = bean.getYearlogin();
			String pref = "INV";

			PreparedStatement pst9 = null;
			PreparedStatement pst99 = null;

			// String pref="INV";
			/*PreparedStatement preparedStatement11 = conn.prepareStatement(
					"select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice  where LENGTH(invoice_no)>5 and year='"
							+ bean.getYearlogin() + "'");

			// preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
				stringValue1 = Fyear + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = Fyear + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = Fyear + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = Fyear + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) {
					stringValue1 = Fyear + "/0" + String.valueOf(myval1);
				} else {
					stringValue1 = Fyear + "/" + String.valueOf(myval1);
				}
			}

			ib.setInvoiceno(stringValue1);*/
			
			
			String query = "";
			
			PreparedStatement preparedStatement = conn.prepareStatement(
					"select * from invoice where  invoice_no=? ");
			
			String inv = ib.getInvoiceno();
			
			String inv1 = " " + inv;

			preparedStatement.setString(1, inv1.trim());

			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				response = "Already";
			
				PreparedStatement pst1 = conn
						.prepareStatement("select * from customer_payment_details where invoiceno='" + inv1.trim()
								+ "' ");
				System.out.println("pst........." + pst1);
				
				ResultSet rs1 = pst1.executeQuery();
				
				if (rs1.next()) {

				} else {

					if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

						query = "UPDATE   invoice  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

						inv1 = ib.getInvoiceno();
						ib.setInvoiceno(inv1);
						Date d1 = new Date();
						String da = "" + d1;

						pst9 = conn.prepareStatement(query);
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

						/*try {

							PreparedStatement pps4 = conn.prepareStatement("select * from settings ");
							// System.out.println("preparedStatement112"+preparedStatement112);
							ResultSet rs12s = pps4.executeQuery();

							if (rs12s.next()) {

								if (rs12s.getString("withstock").equals("yes")) {

									String qd = "Select *  from invoice_tax_details where invoice_no=? and year='"
											+ bean.getYearlogin() + "'";

									// System.out.println("1");

									String inv2 = ib.getInvno();
									String inv21 = " " + inv2;

									PreparedStatement pstdel = conn.prepareStatement(qd);
									pstdel.setString(1, inv21.trim());
									// System.out.println("2");

									System.out.println("SQL11:" + pstdel);
									ResultSet rss = pstdel.executeQuery();

									while (rss.next()) {

										// System.out.println(rss.getString("qty"));

										Double qttsparedet = rss.getDouble("qty");

										// System.out.println(">>>>>");

										String a92x = "select qty,sparecode from stocktablev where sparecode='"
												+ rss.getString("descrip") + "' ";

										PreparedStatement pst32x = conn.prepareStatement(a92x);

										System.out.println("SQL12:" + pst32x);

										ResultSet resultSet112x = pst32x.executeQuery(a92x);

										if (resultSet112x.next()) {

											String sparequantity = resultSet112x.getString("qty");

											Double qty = Double.parseDouble(sparequantity);

											Double totalqty = (qty + qttsparedet);
											String a1022x = "update stocktablev set qty=" + totalqty
													+ " where sparecode='" + rss.getString("descrip") + "'  ";

											PreparedStatement pst1422x = conn.prepareStatement(a1022x);

											System.out.println("SQL13:	" + pst1422x);

											int y = pst1422x.executeUpdate();

										}
									}

								} else {

								}

							}
						} catch (Exception e) {

						}*/

					} else {

						query = "UPDATE   invoice  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,contactp=?,contactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=?,igstamount=?,totaltax=?,remaining_amount=? where invoice_no=? ";

						inv1 = ib.getInvoiceno();
						ib.setInvoiceno(inv1);
						Date d1 = new Date();
						String da = "" + d1;

						pst9 = conn.prepareStatement(query);
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

							// paid_amt2 = ib.getCash_amt();

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
							 * String dateInString=ib.getCheque_date(); Date dNo
							 * = new Date(); dNo = ft.parse(dateInString);
							 */
							Date dNow = new Date();

							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
							 * String dateInString=ib.getCheque_date(); Date dNo
							 * = new Date(); dNo = ft.parse(dateInString);
							 */

							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

							pst9.setNull(6, java.sql.Types.DATE);

							pst9.setString(11, paid_amt2);

							pst9.setString(12, "0");
							pst9.setString(13, "0");
							pst9.setString(14, ib.getTamount());
							pst9.setString(15, ib.getJob_Card_no());
							String d = "";
							try {
								d = CoreData.getDateFormatAsDb(ib.getDate22());

							} catch (Exception e) {

							}

							pst9.setString(16, d);

							pst9.setString(17, "");

							k = pst9.executeUpdate();

						}

						else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
							String paymode = "";
							String paid_amt2 = "";
							String balace = "";
							String chek_amt = "";

							paid_amt2 = ib.getPaid_amt();

							if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
								paymode = ib.getR1() + "~" + "CASH";
								pst9.setString(11, paid_amt2);
								pst9.setString(12, "0");
								pst9.setString(13, "0");

							} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

								paymode = ib.getR1() + "~" + "CHEQUE";
								pst9.setString(12, paid_amt2);
								pst9.setString(11, "0");
								pst9.setString(13, "0");
							} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
								paymode = ib.getR1() + "~" + "CARD";
								pst9.setString(11, "0");

								pst9.setString(12, "0");
								pst9.setString(13, paid_amt2);

							} else {
								paymode = ib.getPaymod();
								pst9.setString(11, "0");

								pst9.setString(12, "0");
								pst9.setString(13, "0");
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

							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

							pst9.setNull(6, java.sql.Types.DATE);

							/*
							 * pst9.setString(11, "0");
							 * 
							 * pst9.setString(12, "0"); pst9.setString(13, "0");
							 */
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

							pst9.setString(4, "" + p);
							/*
							 * try{ c = Integer.valueOf(balace); }catch
							 * (Exception e) { // TODO: handle exception c=0; }
							 */
							pst9.setString(5, "" + 0);

							pst9.setString(7, "");
							pst9.setString(8, "" + ib.getTrandi());
							pst9.setString(9, "");

							pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

							pst9.setNull(6, java.sql.Types.DATE);

							pst9.setString(11, "" + a);

							pst9.setString(12, "" + 0);
							pst9.setString(13, "" + c);
							pst9.setString(14, ib.getTamount());
							pst9.setString(15, ib.getJob_Card_no());
							pst9.setString(16, "");

							pst9.setString(17, "");

							k = pst9.executeUpdate();

						} else {

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
					String qd = "delete  from invoice_tax_details where invoice_no=? ";
					String inv2 = ib.getInvoiceno();
					String inv21 = " " + inv2;
					PreparedStatement pstdel = conn.prepareStatement(qd);
					pstdel.setString(1, inv21.trim());

					int n1 = pstdel.executeUpdate();

					int i = 0;
					int l1 = 0;
					String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,year,username,datetime,batch,unit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

					PreparedStatement pst41 = conn.prepareStatement(q1);

					for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {

						if (!ib.getDescription1()[j1].trim().equals("")
								&& !ib.getDescription1()[j1].trim().equals(null)) {

							
							
							
							PreparedStatement preparedStatementx1 = conn
									.prepareStatement("select type from bag_config_master where bag_name='"
											+ ib.getDescription1()[j1] + "'");

							
							//System.out.println("SQL:"+preparedStatementx1);
							
							ResultSet resultSetx1 = preparedStatementx1.executeQuery();
							
							if (resultSetx1.next()) {
								ib.setUnit(resultSetx1.getString("type"));
							} else {
								ib.setUnit("");
							}
							
							
							
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
							pst41.setString(12, "");
							pst41.setString(13, "");
							pst41.setString(14, ib.getMyrate()[j1]);
							pst41.setString(15, ib.getPartno()[j1]);
							pst41.setString(16, ib.getPartdate()[j1]);
							pst41.setString(17, ib.getPartnox()[j1]);
							pst41.setString(18, ib.getDisc()[j1]);
							pst41.setString(19, ib.getDiscamt()[j1]);
							pst41.setString(20, ib.getAmtwithdisc()[j1]);

							pst41.setString(21, "");
							pst41.setString(22, bean.getUsername());
							pst41.setString(23, SystemDateTime.CurrentDateTime());
							pst41.setString(24, ib.getBatch1()[j1]);

							pst41.setString(25, ib.getUnit());
							
							i = i++;
							String sn = "" + i;

							ib.setSn(sn);

							l1 = pst41.executeUpdate();

						}

						String qd1 = "delete  from invoice_hsn_details where invoiceno=? ";
						inv2 = ib.getInvoiceno();
						inv21 = " " + inv2;
						PreparedStatement pstdel1 = conn.prepareStatement(qd1);
						pstdel1.setString(1, inv21.trim());

						int n12 = pstdel1.executeUpdate();

						PreparedStatement preparedStatement112zz = conn.prepareStatement(
								"select sum(igstamount) as igstamount ,sum(amtwithdisc) as taxablevalue  ,igstrate,type_name,invoice_no,vat_percent from invoice_tax_details where invoice_no='"
										+ inv21.trim() + "'  GROUP BY type_name   ");
						System.out.println("preparedStatement112" + preparedStatement112zz);
						ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

						while (resultSet12zz.next()) {

							query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,igstamount,rate ,taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?) ";
							PreparedStatement pst41z = conn.prepareStatement(query);

							pst41z.setString(1, inv21.trim());
							pst41z.setString(2, resultSet12zz.getString("type_name"));
							pst41z.setString(3, resultSet12zz.getString("igstrate"));

							pst41z.setString(4, resultSet12zz.getString("igstamount"));
							pst41z.setString(5, resultSet12zz.getString("vat_percent"));
							pst41z.setString(6, resultSet12zz.getString("taxablevalue"));

							pst41z.setString(7, "");
							pst41z.setString(8, bean.getUsername());
							pst41z.setString(9, SystemDateTime.CurrentDateTime());

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

					String qdtc = "delete  from invoice_tax_collection where invoice_no=? ";
					String inv23 = ib.getInvoiceno();
					String inv231 = " " + inv23;
					PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
					pstdeltc.setString(1, inv231.trim());

					int ntc = pstdeltc.executeUpdate();
					q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

					pst41 = conn.prepareStatement(q1);
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

						pst41.setString(6, "");
						pst41.setString(7, bean.getUsername());
						pst41.setString(8, SystemDateTime.CurrentDateTime());

						int js = pst41.executeUpdate();

						

						if (js > 0 && ntc > 0) {
							response = "success";
						} else {
							response = "fail";

						}

						// pst41.setString(2,"labour");

					}
					
					
					
					try {
						query = "UPDATE   customercreditdebit  set Amount=?,Customercode='" + ib.getCustomer_Id()
							+ "' where Documentsno=? ";

						inv1 = ib.getInvoiceno();
						ib.setInvoiceno(inv1);
						Date d1 = new Date();
						String da = "" + d1;

						pst9 = conn.prepareStatement(query);
						pst9.setString(1, ib.getTamount());
						pst9.setString(2, inv1);

						k = pst9.executeUpdate();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					//////////////////////////////Update In Order Table//////////////////////

					try {

						String q11 = "update order_table set bill_amount='" + ib.getTamount() + "' where order_id='" + ib.getOrder_id() + "' ";

						PreparedStatement ps = conn.prepareStatement(q11);

						System.out.println("Update::" + ps);

						ps.executeUpdate();

					} catch (Exception e)

					{

					}
					

					// Stock Deduction

					/*try {
						// System.out.println(">>>>s");

						PreparedStatement preparedStatement112 = conn.prepareStatement("select * from settings ");
						// System.out.println("preparedStatement112"+preparedStatement112);
						ResultSet resultSet12 = preparedStatement112.executeQuery();
						System.out.println(">>>>s1" + preparedStatement112);

						if (resultSet12.next()) {
							if (resultSet12.getString("withstock").trim().equals("yes")) {
								// System.out.println(">>>>3>>>"+ib.getDescription1().length);

								for (int k2 = 0; k2 < ib.getDescription1().length; k2++) {
									// System.out.println(">>>>4");

									// System.out.println(">>>>s");
									PreparedStatement ppt = conn
											.prepareStatement("select sparecode,qty from stocktablev where  sparecode='"
													+ ib.getDescription1()[k2] + "' ");

									System.out.println("SQL:" + ppt);
									ResultSet rst = ppt.executeQuery();

									while (rst.next()) {

										String desc = ib.getDescription1()[k2];
										String qty = rst.getString("qty");

										// System.out.println("Quantity:"+qty);

										String qty1 = ib.getQuantity1()[k2];

										Double qty2 = Double.parseDouble(qty) - Double.parseDouble(qty1);

										// System.out.println("New
										// QUantity:"+qty2);

										String q11 = "update stocktablev set  qty='" + qty2 + "' where sparecode='"
												+ desc + "' ";
										PreparedStatement ps1 = conn.prepareStatement(q11);

										System.out.println("Sql12::" + ps1);

										ps1.executeUpdate();

									}

								}
							} else {
							}
						}
					} catch (Exception e) {

					}*/

				}

				try {

					// DaoHelper.closeconnnection();

				} catch (Exception e) {
				}

			}

			else {

				String query1 = "INSERT INTO invoice(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termconnd,vendor,dcno,dcdate,transmode,contactp,contactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,igstamount,totaltax,year,username,datetime,order_id)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pst9 = conn.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10, ib.getInvoiceno());
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
				pst9.setString(36, "" + ib.getTamount());
				pst9.setString(37, "" + ib.getA2()[0]);
				pst9.setString(38, "" + ib.getA2()[1]);

				pst9.setString(39, "");
				pst9.setString(40, bean.getUsername());
				pst9.setString(41, SystemDateTime.CurrentDateTime());
				
				pst9.setString(42, ib.getOrder_id());

				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();

				try {
					x = Integer.valueOf(paid_amt);
				} catch (Exception e) {

					x = 0;
				}
				try {
					Y = Integer.valueOf(balance_amt);
				} catch (Exception e) {

					Y = 0;
				}
				// Integer pp=Integer.parseInt(paid_amt);
				// Integer bb=Integer.parseInt(balance_amt);

				// CASH
				if (ib.getPaymod().equalsIgnoreCase("CASH")) {
					pst9.setString(3, "CASH");

					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();

					try {
						x = Integer.valueOf(paid_amt1);
					} catch (Exception e) {

						x = 0;
					}

					pst9.setString(4, "" + x);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setInt(8, 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "" + x);
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(18, "0");
					pst9.setString(16, "");

					pst9.setString(17, "");

					k = pst9.executeUpdate();

				}

				// CHEQUE
				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						l = 0;
					}
					pst9.setString(4, "" + l);
					pst9.setString(5, "" + 0);

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					String dateInString = ib.getCheque_date();
					Date dNo = new Date();
					dNo = ft.parse(dateInString);
					Date dNow = new Date();

					try {
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					} catch (Exception e) {

						pst9.setString(2, null);
					}

					try {
						pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
					} catch (Exception e) {

						pst9.setString(6, null);
					}

					pst9.setString(11, "" + 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + c);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "" + ib.getBankname());

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + a);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + a);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");
					String d = null;
					try {
						d = CoreData.getDateFormatAsDb(ib.getDate22());
					} catch (Exception e) {

						d = null;
					}
					pst9.setString(17, d);
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

					String paymode = "";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
						paymode = ib.getR1() + "~" + "CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");

					} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

						paymode = ib.getR1() + "~" + "CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
						paymode = ib.getR1() + "~" + "CARD";
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);

					} else {
						paymode = ib.getPaymod();
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, "0");
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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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

					pst9.setString(4, "" + p);
					/*
					 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
					 * 
					 * c=0; }
					 */
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + paid_amt2);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + credit);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				} else {

					pst9.setString(3, "");

					pst9.setString(4, "");

					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "");

					pst9.setString(12, "");
					pst9.setString(13, "");
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				// Insert Into Customer Credit Debit Report

				String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				pst9 = conn.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3, ib.getInvoiceno());
				pst9.setString(4, "Invoice Igst");
				pst9.setString(5, "101");
				pst9.setString(6, "Debit");
				pst9.setString(7, ib.getTamount());

				pst9.setString(8, ib.getCustomer_name());

				pst9.setString(9, "");
				pst9.setString(10, bean.getUsername());
				pst9.setString(11, SystemDateTime.CurrentDateTime());

				System.out.println("SQL:" + pst9);
				k = pst9.executeUpdate();

				// --------------------

				/*PreparedStatement preparedStatement1121 = conn
						.prepareStatement("update  job_card set job_card_done_status='" + 1
								+ "' where job_card_no=? and year='" + bean.getYearlogin() + "'");

				preparedStatement1121.setString(1, ib.getJob_Card_no());
				j = preparedStatement1121.executeUpdate();

				if (k > 0 && j > 0 && v > 0) {
					response = "success";
				} else {
					response = "fail";

				}*/

				/*PreparedStatement preparedStatement112z1 = conn.prepareStatement("select * from settings ");
				// System.out.println("preparedStatement112"+preparedStatement112);
				ResultSet resultSet12z1 = preparedStatement112z1.executeQuery();

				if (resultSet12z1.next()) {

					if (resultSet12z1.getString("po").equals("yes")) {

						for (int k2 = 0; k2 < ib.getDescription1().length; k2++) {

							PreparedStatement ppt = conn
									.prepareStatement("select * from purchase_order_details where pono='" + ib.getPono()
											+ "' and descrip='" + ib.getDescription1()[k2] + "' and year='"
											+ bean.getYearlogin() + "' ");

							System.out.println("SQL:" + ppt);
							ResultSet rst = ppt.executeQuery();

							while (rst.next()) {

								String desc = ib.getDescription1()[k2];
								String qty = rst.getString("qtyremaining");

								String qty1 = ib.getQuantity1()[k2];

								Double qty2 = Double.parseDouble(qty) - Double.parseDouble(qty1);

								System.out.println("QUantity:" + qty2);

								String q11 = "update purchase_order_details set  qtyremaining='" + qty2
										+ "' where descrip='" + desc + "' and pono='" + ib.getPono() + "' and year='"
										+ bean.getYearlogin() + "'";
								PreparedStatement ps1 = conn.prepareStatement(q11);

								System.out.println("Sql12::" + ps1);

								ps1.executeUpdate();

							}

						}
					}
				}*/

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// Stock Maintail

				/*try {
					// System.out.println(">>>>s");

					PreparedStatement preparedStatement112 = conn.prepareStatement("select * from settings ");
					// System.out.println("preparedStatement112"+preparedStatement112);
					ResultSet resultSet12 = preparedStatement112.executeQuery();
					System.out.println(">>>>s1" + preparedStatement112);

					if (resultSet12.next()) {

						if (resultSet12.getString("withstock").trim().equals("yes")) {
							// System.out.println(">>>>3>>>"+ib.getDescription1().length);

							for (int k2 = 0; k2 < ib.getDescription1().length; k2++) {
								// System.out.println(">>>>4");

								// System.out.println(">>>>s");
								PreparedStatement ppt = conn
										.prepareStatement("select sparecode,qty from stocktablev where  sparecode='"
												+ ib.getDescription1()[k2] + "' ");

								System.out.println("SQL:" + ppt);
								ResultSet rst = ppt.executeQuery();

								while (rst.next()) {

									String desc = ib.getDescription1()[k2];
									String qty = rst.getString("qty");

									// System.out.println("Quantity:"+qty);

									String qty1 = ib.getQuantity1()[k2];

									Double qty2 = Double.parseDouble(qty) - Double.parseDouble(qty1);

									// System.out.println("New QUantity:"+qty2);

									String q11 = "update stocktablev set  qty='" + qty2 + "' where sparecode='" + desc
											+ "' ";
									PreparedStatement ps1 = conn.prepareStatement(q11);

									System.out.println("Sql12::" + ps1);

									ps1.executeUpdate();

								}

							}
						} else {
						}
					}
				} catch (Exception e) {

				}*/

				/////////////////////////////////////////////////////////////////////////////////////////////////////////

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,disc,discamt,amtwithdisc,year,username,datetime,batch,unit) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {

						
						PreparedStatement preparedStatementx1 = conn
								.prepareStatement("select type from bag_config_master where bag_name='"
										+ ib.getDescription1()[j1] + "'");

						
						//System.out.println("SQL:"+preparedStatementx1);
						
						ResultSet resultSetx1 = preparedStatementx1.executeQuery();
						
						if (resultSetx1.next()) {
							ib.setUnit(resultSetx1.getString("type"));
						} else {
							ib.setUnit("");
						}
						
						
						
						
						pst41.setString(1, ib.getInvoiceno().trim());

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
						pst41.setString(12, "");
						pst41.setString(13, "");
						pst41.setString(14, ib.getMyrate()[j1]);
						pst41.setString(15, ib.getPartno()[j1]);
						pst41.setString(16, ib.getPartdate()[j1]);
						pst41.setString(17, ib.getPartnox()[j1]);
						pst41.setString(18, ib.getDisc()[j1]);
						pst41.setString(19, ib.getDiscamt()[j1]);
						pst41.setString(20, ib.getAmtwithdisc()[j1]);

						pst41.setString(21, "");
						pst41.setString(22, bean.getUsername());
						pst41.setString(23, SystemDateTime.CurrentDateTime());
						pst41.setString(24, ib.getBatch1()[j1]);
						
						pst41.setString(25, ib.getUnit());

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

				PreparedStatement preparedStatement112zz = conn.prepareStatement(
						"select sum(igstamount) as igstamount,sum(amtwithdisc) as taxablevalue , igstrate,cgstrate,type_name,invoice_no,vat_percent,invoice_no from invoice_tax_details where invoice_no='"
								+ ib.getInvoiceno() + "'  GROUP BY type_name   ");

				System.out.println("preparedStatement112" + preparedStatement112zz);
				ResultSet resultSet12zz = preparedStatement112zz.executeQuery();

				while (resultSet12zz.next()) {

					query = "insert into   invoice_hsn_details  (invoiceno,hsncode,igstrate,igstamount,rate ,taxablevalue,year,username,datetime) values (?,?,?,?,?,?,?,?,?) ";
					PreparedStatement pst41x = conn.prepareStatement(query);

					pst41x.setString(1, ib.getInvoiceno());
					pst41x.setString(2, resultSet12zz.getString("type_name"));
					pst41x.setString(3, resultSet12zz.getString("igstrate"));

					pst41x.setString(4, resultSet12zz.getString("igstamount"));
					pst41x.setString(5, resultSet12zz.getString("vat_percent"));
					pst41x.setString(6, resultSet12zz.getString("taxablevalue"));

					pst41x.setString(7, "");
					pst41x.setString(8, bean.getUsername());
					pst41x.setString(9, SystemDateTime.CurrentDateTime());

					System.out.println(pst41x);
					pst41x.executeUpdate();
				}

				// insert to tax collection
				q1 = "insert into invoice_tax_collection(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
				for (int j1 = 0; j1 < ib.getT().length; j1++) {

					pst41.setString(1, ib.getInvoiceno());

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

					pst41.setString(6, "");
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

					if (js > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}
				
				
					//////////////////////////////Update In Order Table//////////////////////

				try {

					String q11 = "update order_table set invoice_no='" + ib.getInvoiceno() + "'," + "bill_time='"
							+ CoreData.getCurrentTime() + "'," + "bill_username='" + bean.getUsername() + "',"
							+ "bill_datetime='" + SystemDateTime.CurrentDateTime() + "'," + "bill_date='"
							+ CoreData.getDateFormatAsDb(ib.getDate()) + "'," + "bill_amount='" + ib.getTamount() + "',"
							+ "status='5' where order_id='" + ib.getOrder_id() + "' ";

					PreparedStatement ps = conn.prepareStatement(q11);

					System.out.println("Update::" + ps);

					ps.executeUpdate();

				} catch (Exception e)

				{

				}
				
				
				
				//////////////////////////////Update In Despatch //////////////////////////////

				try {

					String q11 = "update despatch set status='2',invoice_no='"+ib.getInvoiceno()+"',bill_datetime='"+SystemDateTime.CurrentDateTime()+"' where order_id='" + ib.getOrder_id() + "' and despatch_id='"+ib.getDespatch_id()+"' ";

					PreparedStatement ps = conn.prepareStatement(q11);

					//System.out.println("Update::" + ps);

					ps.executeUpdate();

				} catch (Exception e)

				{

				}
				
				
				
				
				
				////////////////////////////// Status Report Updation //////////////////////////////

				try {

					String q11 = "update order_table_second set status='4' where order_id='" + ib.getOrder_id() + "'  ";

					PreparedStatement ps = conn.prepareStatement(q11);

					//System.out.println("Update::" + ps);

					ps.executeUpdate();

				} catch (Exception e)

				{
					
				}
				
				
				

			}//else close
			
			
			String responsetally="";
			try{
				responsetally=SendToTally(ib);
				System.out.println(">>>"+responsetally);
				if(!responsetally.equals("success")){
					
					
					PreparedStatement preparedStatementz = conn
							.prepareStatement("select * from tally_missing where  Invoiceno=?");
								preparedStatementz.setString(1, ib.getInvoiceno());
					System.out.println(preparedStatementz);
					ResultSet resultSetz = preparedStatementz.executeQuery();
					if (resultSetz.next()) {
						
					
					}else{
					
					String q1xx = "insert into tally_missing(Invoiceno,date,type) values(?,?,?)";

				PreparedStatement	pst41xx= conn.prepareStatement(q1xx);
			pst41xx.setString(1, ib.getInvoiceno());
			pst41xx.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
			pst41xx.setString(3, "Addnew");
			System.out.println(pst41xx);
			int HH = pst41xx.executeUpdate();
					}
					
				} else if(responsetally.equals("success")){
					
					System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					PreparedStatement preparedStatementz = conn
							.prepareStatement("select * from tally_missing where  Invoiceno=?");
								preparedStatementz.setString(1, ib.getInvoiceno());
					System.out.println(preparedStatementz);
					ResultSet resultSetz = preparedStatementz.executeQuery();
					if (resultSetz.next()) {
						
						PreparedStatement preparedStatement144 = conn
								.prepareStatement("delete from tally_missing  where Invoiceno=?");
									
							
						preparedStatement144.setString(1, ib.getInvoiceno());
						
						//System.out.println("receipt");
					int	j9 = preparedStatement144.executeUpdate();
						
						
						
					
					}
				}
				
				
			}catch(Exception e){
				
				System.out.println(e.getMessage());
			}
			

			// -----

			try {

				DBConnection.closeConnection();

			} catch (Exception e) {

			}

		}

		return response;
	}

	public invoicebean1 FetchspareGatepassAssemblyform745(String autoinvoice, userinfo bean) {

		Connection conn=connection.getConnection();
		
		invoicebean1 ib = new invoicebean1();
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
		List<String> rate2 = new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2 = new ArrayList<String>();
		List<String> myrate = new ArrayList<String>();
		List<String> partno = new ArrayList<String>();
		List<String> partdate = new ArrayList<String>();
		List<String> partnox = new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		try {
			int sno = 1;

			// connnection conn = DaoHelper.getconnnection();

			PreparedStatement pst = conn.prepareStatement("select * from invoice_tax_details  where invoice_no='"
					+ autoinvoice + "' and year='" + bean.getYearlogin() + "'");

			System.out.println(pst);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String ty = rs.getString("type");

				if (ty.equalsIgnoreCase("parts")) {
					type.add("PARTS");
				}

				if (ty.equalsIgnoreCase("labour")) {
					type.add("LABOUR");
				}

				// type.add(rs.getString("type"));
				descrip.add(rs.getString("descrip"));
				qty.add(rs.getString("qty"));
				amt.add(rs.getString("amt"));
				vat_percent.add(rs.getString("vat_percent"));
				tax_amt_percent.add(rs.getString("tax_amt_percent"));
				net_amt.add(rs.getString("net_amt"));
				type_name.add(rs.getString("type_name"));
				rate1.add(rs.getString("igstrate"));
				// rate2.add(rs.getString("sgstrate"));
				myrate.add(rs.getString("rate"));
				gstamt1.add(rs.getString("igstamount"));
				/// gstamt2.add(rs.getString("sgstamount"));
				partno.add(rs.getString("partno"));
				partnox.add(rs.getString("partnox"));
				partdate.add(rs.getString("partdate"));
				disc.add(rs.getString("disc"));
				discamt.add(rs.getString("discamt"));
				amtwithdisc.add(rs.getString("amtwithdisc"));
				sparesize++;
			}

			try {
				// DaoHelper.closeconnnection();
			} catch (Exception e) {

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
		// ib.setRate2(rate2);
		ib.setGstamt1(gstamt1);
		// ib.setGstamt2(gstamt2);
		ib.setPartno2(partno);
		ib.setPartno2x(partnox);
		ib.setPartdate2(partdate);
		ib.setDisc2(disc);
		ib.setDiscamt2(discamt);
		ib.setAmtwithdisc2(amtwithdisc);
		
		DBConnection.closeConnection();
		
		return ib;

	}

	public invoicebean1 FetchspareGatepassAssemblyform745Igst(String autoinvoice, userinfo bean) {

		Connection conn=connection.getConnection();
		
		invoicebean1 ib = new invoicebean1();
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
		List<String> rate2 = new ArrayList<String>();
		List<String> gstamt1 = new ArrayList<String>();
		List<String> gstamt2 = new ArrayList<String>();
		List<String> myrate = new ArrayList<String>();
		List<String> partno = new ArrayList<String>();
		List<String> partdate = new ArrayList<String>();
		List<String> partnox = new ArrayList<String>();
		try {
			int sno = 1;

			// connnection conn = DaoHelper.getconnnection();

			PreparedStatement pst = conn.prepareStatement(
					"select * from invoice_tax_details_sales_return  where invoice_no='" + autoinvoice + "'");

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
				// rate2.add(rs.getString("sgstrate"));
				myrate.add(rs.getString("rate"));
				gstamt1.add(rs.getString("igstamount"));
				/// gstamt2.add(rs.getString("sgstamount"));
				partno.add(rs.getString("partno"));
				partnox.add(rs.getString("partnox"));
				partdate.add(rs.getString("partdate"));
				sparesize++;
			}

			try {
				// DaoHelper.closeconnnection();
			} catch (Exception e) {

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
		// ib.setRate2(rate2);
		ib.setGstamt1(gstamt1);
		// ib.setGstamt2(gstamt2);
		ib.setPartno2(partno);
		ib.setPartno2x(partnox);
		ib.setPartdate2(partdate);
		
		
		DBConnection.closeConnection();
		
		return ib;

	}

	public String insertSalesReturn(invoicebean1 ib, userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();
		
		int flag1 = 0;

		/*
		 * PreparedStatement preparedStatement112z = conn.prepareStatement(
		 * "select * from settings ");
		 * //System.out.println("preparedStatement112"+preparedStatement112);
		 * ResultSet resultSet12z = preparedStatement112z.executeQuery();
		 * 
		 * if (resultSet12z.next()) {
		 * 
		 * if(resultSet12z.getString("withstock").equals("yes")){
		 * 
		 * for(int mx=0;mx<ib.getDescription1().length;mx++) {
		 * if(ib.getDescription1()[mx] != "" ){
		 * 
		 * 
		 * PreparedStatement preparedStatementx=conn.prepareStatement(
		 * "select * from purchase_order_details where descrip=? and invoice_no='"
		 * +ib.getPono()+"'   "); preparedStatementx.setString(1,
		 * ib.getDescription1()[mx]);
		 * System.out.println("SQL:"+preparedStatementx); ResultSet
		 * resultSetx=preparedStatementx.executeQuery(); if(resultSetx.next()) {
		 * int qtyentered=Integer.parseInt(ib.getQuantity1()[mx]); int
		 * qtyremaining =Integer.parseInt(resultSetx.getString("qtyremaining"));
		 * if(qtyremaining<qtyentered){ System.out.println("AAA");
		 * response="Notsuffqty"; System.out.println("AAA12"); flag1=1;
		 * System.out.println("AAA23"); //spcode=spcode +"  , "
		 * +amc_Bean.getSpare_code()[mx]; break; } }else{ flag1=1; }
		 * 
		 * 
		 * 
		 * }
		 * 
		 * } System.out.println("Flag Value:"+flag1); }
		 * 
		 * 
		 * }
		 */

		if (flag1 == 0) {
			System.out.println("iinFlag Value:" + flag1);
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
			/*
			 * int result = -1; Date date = new Date(); if (date != null) {
			 * Calendar cal = Calendar.getInstance(); cal.setTime(date); result
			 * = cal.get(Calendar.MONTH) + 1; } int result1 = -1; if (date !=
			 * null) { Calendar cal = Calendar.getInstance(); cal.setTime(date);
			 * result1 = cal.get(Calendar.YEAR); } String year = ""; String yy =
			 * ""; String yy1 = ""; yy = "" + result1;
			 * 
			 * yy1 = yy.substring(2, 4);
			 * 
			 * int pp = 0; pp = Integer.parseInt(yy1);
			 * 
			 * if (result <= 3) { year = "" + (result1 - 1); } else {
			 * 
			 * year = "" + result1;
			 * 
			 * } String Fyear = ""; if (result <= 3) { Fyear = (result1 - 1) +
			 * "-" + pp; } else {
			 * 
			 * Fyear = result1 + "-" + (pp + 1);
			 * 
			 * }
			 * 
			 * String FMONTH = "" + result;
			 */

			String Fyear = bean.getYearlogin();

			String pref = "INV";

			PreparedStatement pst9 = null;
			PreparedStatement pst99 = null;

			// String pref="INV";
			PreparedStatement preparedStatement11 = conn.prepareStatement(
					"select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice_sales_return  where LENGTH(invoice_no)>5 and year='"
							+ Fyear + "'");

			// preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
				stringValue1 = Fyear + "/SR" + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = Fyear + "/SR" + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = Fyear + "/SR" + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = Fyear + "/SR" + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) {
					stringValue1 = Fyear + "/SR" + "/0" + String.valueOf(myval1);
				} else {
					stringValue1 = Fyear + "/SR" + "/" + String.valueOf(myval1);
				}
			}

			ib.setInvoiceno(stringValue1);
			String query = "";
			PreparedStatement preparedStatement = conn.prepareStatement(
					"select * from invoice_sales_return where  invoice_no=? and year='" + bean.getYearlogin() + "'");
			String inv = ib.getInvno();
			String inv1 = " " + inv;

			preparedStatement.setString(1, inv1.trim());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";

				if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

					query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,conntactp=?,conntactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=? and year='"
							+ bean.getYearlogin() + "'";

					inv1 = ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

				} else {

					query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,conntactp=?,conntactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=? and year='"
							+ bean.getYearlogin() + "'";

					inv1 = ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

						// paid_amt2 = ib.getCash_amt();

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */
						Date dNow = new Date();

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, paid_amt2);

						pst9.setString(12, "0");
						pst9.setString(13, "0");
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						String d = "";
						try {
							d = CoreData.getDateFormatAsDb(ib.getDate22());

						} catch (Exception e) {

						}

						pst9.setString(16, d);

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					}

					else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
						String paymode = "";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";

						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
							paymode = ib.getR1() + "~" + "CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");

						} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

							paymode = ib.getR1() + "~" + "CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
							paymode = ib.getR1() + "~" + "CARD";
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);

						} else {
							paymode = ib.getPaymod();
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, "0");
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

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						/*
						 * pst9.setString(11, "0");
						 * 
						 * pst9.setString(12, "0"); pst9.setString(13, "0");
						 */
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

						pst9.setString(4, "" + p);
						/*
						 * try{ c = Integer.valueOf(balace); }catch (Exception
						 * e) { // TODO: handle exception c=0; }
						 */
						pst9.setString(5, "" + 0);

						pst9.setString(7, "");
						pst9.setString(8, "" + ib.getTrandi());
						pst9.setString(9, "");

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, "" + a);

						pst9.setString(12, "" + 0);
						pst9.setString(13, "" + c);
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						pst9.setString(16, "");

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					} else {

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
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no());
				 * 
				 * j = preparedStatement1121.executeUpdate();
				 * 
				 * response = "success";
				 */

				// update tax_datails
				response = "success";
				String qd = "delete  from invoice_tax_details_sales_return where invoice_no=? and year='"
						+ bean.getYearlogin() + "'";
				String inv2 = ib.getInvno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);

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

						pst41.setString(18, bean.getYearlogin());
						pst41.setString(19, bean.getUsername());
						pst41.setString(20, SystemDateTime.CurrentDateTime());

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

				String qdtc = "delete  from invoice_tax_collection_sales_return where invoice_no=? and year='"
						+ bean.getYearlogin() + "'";
				String inv23 = ib.getInvno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, bean.getYearlogin());
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

				try {

					// DaoHelper.closeconnnection();

				} catch (Exception e) {
				}

			}

			else {

				String query1 = "INSERT INTO invoice_sales_return(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termconnd,vendor,dcno,dcdate,transmode,conntactp,conntactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pst9 = conn.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10, stringValue1);
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
				pst9.setString(36, "" + ib.getTamount());

				pst9.setString(37, bean.getYearlogin());
				pst9.setString(38, bean.getUsername());
				pst9.setString(39, SystemDateTime.CurrentDateTime());

				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();

				try {
					x = Integer.valueOf(paid_amt);
				} catch (Exception e) {

					x = 0;
				}
				try {
					Y = Integer.valueOf(balance_amt);
				} catch (Exception e) {

					Y = 0;
				}
				// Integer pp=Integer.parseInt(paid_amt);
				// Integer bb=Integer.parseInt(balance_amt);

				// CASH
				if (ib.getPaymod().equalsIgnoreCase("CASH")) {
					pst9.setString(3, "CASH");

					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();

					/*
					 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e)
					 * {
					 * 
					 * x=0; }
					 */

					pst9.setString(4, paid_amt1);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setInt(8, 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "" + x);
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(18, "0");
					pst9.setString(16, "");

					pst9.setString(17, "");

					k = pst9.executeUpdate();

				}

				// CHEQUE
				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						l = 0;
					}
					pst9.setString(4, "" + l);
					pst9.setString(5, "" + 0);

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					String dateInString = ib.getCheque_date();
					Date dNo = new Date();
					dNo = ft.parse(dateInString);
					Date dNow = new Date();

					try {
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					} catch (Exception e) {

						pst9.setString(2, null);
					}

					try {
						pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
					} catch (Exception e) {

						pst9.setString(6, null);
					}

					pst9.setString(11, "" + 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + c);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "" + ib.getBankname());

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + a);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + a);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");
					String d = null;
					try {
						d = CoreData.getDateFormatAsDb(ib.getDate22());
					} catch (Exception e) {

						d = null;
					}
					pst9.setString(17, d);
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

					String paymode = "";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
						paymode = ib.getR1() + "~" + "CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");

					} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

						paymode = ib.getR1() + "~" + "CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
						paymode = ib.getR1() + "~" + "CARD";
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);

					} else {
						paymode = ib.getPaymod();
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, "0");
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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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

					pst9.setString(4, "" + p);
					/*
					 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
					 * 
					 * c=0; }
					 */
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + paid_amt2);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + credit);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				} else {

					pst9.setString(3, "");

					pst9.setString(4, "");

					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "");

					pst9.setString(12, "");
					pst9.setString(13, "");
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				/// new insertiom

				/*
				 * PreparedStatement pstcx9 = conn.prepareStatement(
				 * "insert into customerpayment(Invoiceno,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,total,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?)"
				 * );
				 * 
				 * pstcx9.setString(1,stringValue1);
				 * 
				 * // CASH if(ib.getPaymod().equalsIgnoreCase("CASH")) {
				 * pstcx9.setString(3, "CASH");
				 * 
				 * String paid_amt1="";
				 * 
				 * paid_amt1=ib.getNet_amount();
				 * 
				 * 
				 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e) {
				 * 
				 * x=0; }
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * pstcx9.setString(2, ""+x);
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,""+x);
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * // CHEQUE else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				 * {
				 * 
				 * 
				 * pstcx9.setString(3, "CHEQUE"); Integer l=0; String
				 * paid_amt2=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getCash_amt();
				 * 
				 * 
				 * chek_amt=ib.getCheque_amt(); Integer c=0; try{ l =
				 * Integer.valueOf(chek_amt); }catch (Exception e) {
				 * 
				 * l=0; } pstcx9.setString(2, ""+l);
				 * 
				 * 
				 * pstcx9.setString(5,ib.getCheque_no());
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""+l); pstcx9.setString(10,"");
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); DateFormat ft = new
				 * SimpleDateFormat("yyyy/MM/dd"); String
				 * dateInString=ib.getCheque_date(); Date dNo = new Date(); dNo
				 * = ft.parse(dateInString); Date dNow = new Date();
				 * 
				 * 
				 * try{
				 * pst9.setString(4,CoreData.getDateFormatAsDb(ib.getDate()));
				 * }catch (Exception e) {
				 * 
				 * pst9.setString(2,null); }
				 * 
				 * 
				 * try{ pstcx9.setString(4,CoreData.getDateFormatAsDb(ib.
				 * getCheque_date())); }catch (Exception e) {
				 * 
				 * pstcx9.setString(4,null); }
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * 
				 * //credit
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("CREDIT")) {
				 * 
				 * 
				 * pstcx9.setString(3, "CARD");
				 * 
				 * String paid_amt2=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getNet_amountcard();
				 * 
				 * 
				 * chek_amt=ib.getNet_amountcard(); Integer c=0; Integer a=0;
				 * try{ a = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a);
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,ib.getCardid()); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,""+a);
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * // Insurance else
				 * if(ib.getPaymod().equalsIgnoreCase("INSURANCE")) {
				 * 
				 * 
				 * pstcx9.setString(3, "INSURANCE");
				 * 
				 * String paid_amt2=""; String balace=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getPaid_amt22();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard();
				 * balace=ib.getBalance_amt22(); Integer c=0; Integer a=0; try{
				 * a = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a); try{ c =
				 * Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; } pstcx9.setNull(4,java.sql.Types.DATE);
				 * pstcx9.setString(5, "");
				 * 
				 * pstcx9.setString(6,"");
				 * pstcx9.setString(7,ib.getInsurance());
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
				 * 
				 * 
				 * //pstcx9.setString(3, "PARTPAYMENT"); String paymode="";
				 * String paid_amt2=""; String balace=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getPaid_amt();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard();
				 * balace=ib.getBalance_amt(); Integer c=0; Integer a=0; try{ a
				 * = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a); try{ c =
				 * Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * String ppmode=""; if
				 * (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
				 * paymode=ib.getR1()+"~"+"CASH"; pstcx9.setString(8, ""+a);
				 * pstcx9.setString(9, "0"); pstcx9.setString(10, "0");
				 * 
				 * } else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
				 * {
				 * 
				 * paymode=ib.getR1()+"~"+"CHEQUE"; pstcx9.setString(9, ""+a);
				 * pstcx9.setString(8, "0"); pstcx9.setString(10, "0"); } else
				 * if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
				 * paymode=ib.getR1()+"~"+"CARD"; pstcx9.setString(8,"0");
				 * 
				 * pstcx9.setString(9, "0"); pstcx9.setString(10, ""+a);
				 * 
				 * } else { paymode=ib.getPaymod(); pstcx9.setString(8,"0");
				 * 
				 * pstcx9.setString(9, "0"); pstcx9.setString(10,"0"); }
				 * 
				 * 
				 * pstcx9.setString(3, paymode);
				 * 
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * // card and cash
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {
				 * 
				 * 
				 * pstcx9.setString(3, "CARDANDCASH");
				 * 
				 * String paid_amt2=""; String balace=""; String credit="";
				 * 
				 * paid_amt2=ib.getCashhh();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard(); credit=ib.getCarddd();
				 * Integer c=0; Integer a=0; Integer p=0; try{ a =
				 * Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; }
				 * 
				 * try{ c = Integer.valueOf(credit); }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * p=(a+c);
				 * 
				 * pstcx9.setString(2, ""+a); try{ c = Integer.valueOf(balace);
				 * }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(7,""); pstcx9.setString(8,paid_amt2);
				 * pstcx9.setString(9,""); pstcx9.setString(10,credit);
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); v=pstcx9.executeUpdate();
				 * 
				 * }else{ pstcx9.setString(2, ""); pstcx9.setString(3, "");
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE);
				 * pstcx9.setString(5,""); pstcx9.setString(6,"");
				 * pstcx9.setString(7,""); pstcx9.setString(8,"");
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * v= pstcx9.executeUpdate();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * }
				 */

				// Insert Into Customer Credit Debit Report

				String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				pst9 = conn.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3, stringValue1);
				pst9.setString(4, "Sales Return");
				pst9.setString(5, "101");
				pst9.setString(6, "Credit");
				pst9.setString(7, ib.getTamount());
				pst9.setString(8, ib.getCustomer_name());

				pst9.setString(9, bean.getYearlogin());
				pst9.setString(10, bean.getUsername());
				pst9.setString(11, SystemDateTime.CurrentDateTime());

				System.out.println("SQL:" + pst9);
				k = pst9.executeUpdate();

				// Bill Number Generation For Customer Credit Debit

				String stringValue = "";
				int len11 = 0;
				PreparedStatement preparedStatement1x = conn.prepareStatement(
						"SELECT * FROM  customercreditdebit where year='" + bean.getYearlogin() + "'");

				ResultSet resultSet1x = preparedStatement1x.executeQuery();
				while (resultSet1x.next()) {
					len11++;
				}

				int size = len11 + 1;
				stringValue = String.valueOf(size);

				String ap = "IP";

				if (stringValue.length() == 1) {
					stringValue = "ICP/" + ap + "/000" + stringValue;
				} else if (stringValue.length() == 2) {
					stringValue = "ICP/" + ap + "/00" + stringValue;
				} else if (stringValue.length() == 3) {
					stringValue = "ICP/" + ap + "/0" + stringValue;
				} else {
					stringValue = "ICP/" + ap + "/" + stringValue;
				}

				ib.setBillno(stringValue);

				

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,cgstrate,cgstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);
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

						pst41.setString(18, bean.getYearlogin());
						pst41.setString(19, bean.getUsername());
						pst41.setString(20, SystemDateTime.CurrentDateTime());

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
				q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, bean.getYearlogin());
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

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

			try {

				DBConnection.closeConnection();

			} catch (Exception e) {

			}

		}

		return response;
	}

	// Method To Insert Sales Return Of Igst

	public String insertSalesReturnIgst(invoicebean1 ib, userinfo bean) throws Exception {

		String response = "";

		Connection conn=connection.getConnection();
		
		int flag1 = 0;

		

		if (flag1 == 0) {
			System.out.println("iinFlag Value:" + flag1);
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

			
			// String FMONTH = "" + result;

			String Fyear = bean.getYearlogin();

			String pref = "INV";

			PreparedStatement pst9 = null;
			PreparedStatement pst99 = null;

			// String pref="INV";
			PreparedStatement preparedStatement11 = conn.prepareStatement(
					"select  max(SUBSTRING(invoice_no,-4)) as myval1 from invoice_sales_return  where LENGTH(invoice_no)>5 and year='"
							+ Fyear + "'");

			// preparedStatement11.setString(1, "" + "%" + Fyear + "%");

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
				stringValue1 = Fyear + "/SR" + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = Fyear + "/SR" + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = Fyear + "/SR" + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = Fyear + "/SR" + "/00" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 4) {
					stringValue1 = Fyear + "/SR" + "/0" + String.valueOf(myval1);
				} else {
					stringValue1 = Fyear + "/SR" + "/" + String.valueOf(myval1);
				}
			}

			ib.setInvoiceno(stringValue1);
			String query = "";
			PreparedStatement preparedStatement = conn.prepareStatement(
					"select * from invoice_sales_return where  invoice_no=? and year='" + bean.getYearlogin() + "'");
			String inv = ib.getInvno();
			String inv1 = " " + inv;

			preparedStatement.setString(1, inv1.trim());

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				response = "Already";

				if (ib.getPaymod() == null || ib.getPaymod().equals("")) {

					query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,job_card_no=? ,invoice_done_status='0',total=?,pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,conntactp=?,conntactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=? and year='"
							+ bean.getYearlogin() + "'";

					inv1 = ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

				} else {

					query = "UPDATE   invoice_sales_return  set vehicle_no=?,date=?,pay_mode=?,paid_amount=?,balance_amount=?,CHECK_date=?,check_no=?,card_trn_id=?,insurance_comp=?,invoice_no=?,paybycash=?,paybycheque=?,paybycredit=?,total=?,job_card_no=?,bankname=?,insurance_date=? ,invoice_done_status='0',pono=?,podate=?,termconnd=?,vendor=?,dcno=?,dcdate=?,transmode=?,conntactp=?,conntactpno=?,shipparty=?,shipadd=?,shipgstn=?,shipstate=?,vehino=?,freight=?,transport=? where invoice_no=? and year='"
							+ bean.getYearlogin() + "'";

					inv1 = ib.getInvno();
					ib.setInvoiceno(inv1);
					Date d1 = new Date();
					String da = "" + d1;

					pst9 = conn.prepareStatement(query);
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

						// paid_amt2 = ib.getCash_amt();

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */
						Date dNow = new Date();

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

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
						 * String dateInString=ib.getCheque_date(); Date dNo =
						 * new Date(); dNo = ft.parse(dateInString);
						 */

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, paid_amt2);

						pst9.setString(12, "0");
						pst9.setString(13, "0");
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						String d = "";
						try {
							d = CoreData.getDateFormatAsDb(ib.getDate22());

						} catch (Exception e) {

						}

						pst9.setString(16, d);

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					}

					else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
						String paymode = "";
						String paid_amt2 = "";
						String balace = "";
						String chek_amt = "";

						paid_amt2 = ib.getPaid_amt();

						if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
							paymode = ib.getR1() + "~" + "CASH";
							pst9.setString(11, paid_amt2);
							pst9.setString(12, "0");
							pst9.setString(13, "0");

						} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

							paymode = ib.getR1() + "~" + "CHEQUE";
							pst9.setString(12, paid_amt2);
							pst9.setString(11, "0");
							pst9.setString(13, "0");
						} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
							paymode = ib.getR1() + "~" + "CARD";
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, paid_amt2);

						} else {
							paymode = ib.getPaymod();
							pst9.setString(11, "0");

							pst9.setString(12, "0");
							pst9.setString(13, "0");
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

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						/*
						 * pst9.setString(11, "0");
						 * 
						 * pst9.setString(12, "0"); pst9.setString(13, "0");
						 */
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

						pst9.setString(4, "" + p);
						/*
						 * try{ c = Integer.valueOf(balace); }catch (Exception
						 * e) { // TODO: handle exception c=0; }
						 */
						pst9.setString(5, "" + 0);

						pst9.setString(7, "");
						pst9.setString(8, "" + ib.getTrandi());
						pst9.setString(9, "");

						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

						pst9.setNull(6, java.sql.Types.DATE);

						pst9.setString(11, "" + a);

						pst9.setString(12, "" + 0);
						pst9.setString(13, "" + c);
						pst9.setString(14, ib.getTamount());
						pst9.setString(15, ib.getJob_Card_no());
						pst9.setString(16, "");

						pst9.setString(17, "");

						k = pst9.executeUpdate();

					} else {

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
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no());
				 * 
				 * j = preparedStatement1121.executeUpdate();
				 * 
				 * response = "success";
				 */

				// update tax_datails
				response = "success";
				String qd = "delete  from invoice_tax_details_sales_return where invoice_no=? and year='"
						+ bean.getYearlogin() + "'";
				String inv2 = ib.getInvno();
				String inv21 = " " + inv2;
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, inv21.trim());

				int n1 = pstdel.executeUpdate();

				int i = 0;
				int l1 = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);

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

						pst41.setString(18, bean.getYearlogin());
						pst41.setString(19, bean.getUsername());
						pst41.setString(20, SystemDateTime.CurrentDateTime());

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

				String qdtc = "delete  from invoice_tax_collection_sales_return where invoice_no=? and year='"
						+ bean.getYearlogin() + "'";
				String inv23 = ib.getInvno();
				String inv231 = " " + inv23;
				PreparedStatement pstdeltc = conn.prepareStatement(qdtc);
				pstdeltc.setString(1, inv231.trim());

				int ntc = pstdeltc.executeUpdate();
				q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, bean.getYearlogin());
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

					int js = pst41.executeUpdate();

					if (js > 0 && ntc > 0) {
						response = "success";
					} else {
						response = "fail";

					}

					// pst41.setString(2,"labour");

				}

				try {

					// DaoHelper.closeconnnection();

				} catch (Exception e) {
				}

			}

			else {

				String query1 = "INSERT INTO invoice_sales_return(vehicle_no,date,pay_mode,paid_amount,balance_amount,CHECK_date,check_no,card_trn_id,insurance_comp,invoice_no,paybycash,paybycheque,paybycredit,job_card_no,total,bankname,insurance_date,invoice_done_status,pono,podate,termconnd,vendor,dcno,dcdate,transmode,conntactp,conntactpno,shipparty,shipadd,shipgstn,shipstate,vehino,freight,transport,invtype,remaining_amount,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				pst9 = conn.prepareStatement(query1);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(10, stringValue1);
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
				pst9.setString(36, "" + ib.getTamount());

				pst9.setString(37, bean.getYearlogin());
				pst9.setString(38, bean.getUsername());
				pst9.setString(39, SystemDateTime.CurrentDateTime());

				String paid_amt = "";
				String balance_amt = "";
				paid_amt = ib.getPaid_amt();
				balance_amt = ib.getBalance_amt();

				try {
					x = Integer.valueOf(paid_amt);
				} catch (Exception e) {

					x = 0;
				}
				try {
					Y = Integer.valueOf(balance_amt);
				} catch (Exception e) {

					Y = 0;
				}
				// Integer pp=Integer.parseInt(paid_amt);
				// Integer bb=Integer.parseInt(balance_amt);

				// CASH
				if (ib.getPaymod().equalsIgnoreCase("CASH")) {
					pst9.setString(3, "CASH");

					String paid_amt1 = "";

					paid_amt1 = ib.getNet_amount();

					try {
						x = Integer.valueOf(paid_amt1);
					} catch (Exception e) {

						x = 0;
					}

					pst9.setString(4, "" + x);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setInt(8, 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					pst9.setNull(6, java.sql.Types.DATE);
					pst9.setString(11, "" + x);
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(18, "0");
					pst9.setString(16, "");

					pst9.setString(17, "");

					k = pst9.executeUpdate();

				}

				// CHEQUE
				else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {

					pst9.setString(3, "CHEQUE");
					Integer l = 0;
					String paid_amt2 = "";
					String chek_amt = "";

					paid_amt2 = ib.getCash_amt();

					chek_amt = ib.getCheque_amt();
					Integer c = 0;
					try {
						l = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						l = 0;
					}
					pst9.setString(4, "" + l);
					pst9.setString(5, "" + 0);

					pst9.setString(7, ib.getCheque_no());
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					String dateInString = ib.getCheque_date();
					Date dNo = new Date();
					dNo = ft.parse(dateInString);
					Date dNow = new Date();

					try {
						pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
					} catch (Exception e) {

						pst9.setString(2, null);
					}

					try {
						pst9.setString(6, CoreData.getDateFormatAsDb(ib.getCheque_date()));
					} catch (Exception e) {

						pst9.setString(6, null);
					}

					pst9.setString(11, "" + 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + c);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "" + ib.getBankname());

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, ib.getCardid());
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setInt(11, 0);
					try {
						c = Integer.valueOf(chek_amt);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + a);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, ib.getInsurance());

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + a);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + 0);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");
					String d = null;
					try {
						d = CoreData.getDateFormatAsDb(ib.getDate22());
					} catch (Exception e) {

						d = null;
					}
					pst9.setString(17, d);
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {

					String paymode = "";
					String paid_amt2 = "";
					String balace = "";
					String chek_amt = "";
					String paycash = "";
					String paycheque = "";
					String paycredit = "";
					paid_amt2 = ib.getPaid_amt();

					if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
						paymode = ib.getR1() + "~" + "CASH";
						pst9.setString(11, paid_amt2);
						pst9.setString(12, "0");
						pst9.setString(13, "0");

					} else if (ib.getR1().equalsIgnoreCase("partpaymentcheque")) {

						paymode = ib.getR1() + "~" + "CHEQUE";
						pst9.setString(12, paid_amt2);
						pst9.setString(11, "0");
						pst9.setString(13, "0");
					} else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
						paymode = ib.getR1() + "~" + "CARD";
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, paid_amt2);

					} else {
						paymode = ib.getPaymod();
						pst9.setString(11, "0");

						pst9.setString(12, "0");
						pst9.setString(13, "0");
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
					pst9.setString(4, "" + a);
					try {
						c = Integer.valueOf(balace);
					} catch (Exception e) {

						c = 0;
					}
					pst9.setString(5, "" + c);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

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

					pst9.setString(4, "" + p);
					/*
					 * try{ c = Integer.valueOf(balace); }catch (Exception e) {
					 * 
					 * c=0; }
					 */
					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					DateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
					/*
					 * String dateInString=ib.getCheque_date(); Date dNo = new
					 * Date(); dNo = ft.parse(dateInString);
					 */
					Date dNow = new Date();

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "" + paid_amt2);

					pst9.setString(12, "" + 0);
					pst9.setString(13, "" + credit);
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				} else {

					pst9.setString(3, "");

					pst9.setString(4, "");

					pst9.setString(5, "" + 0);

					pst9.setString(7, "");
					pst9.setString(8, "" + 0);
					pst9.setString(9, "");

					pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));

					pst9.setNull(6, java.sql.Types.DATE);

					pst9.setString(11, "");

					pst9.setString(12, "");
					pst9.setString(13, "");
					pst9.setString(15, "" + ib.getTamount());
					pst9.setString(16, "");

					pst9.setString(17, "");
					pst9.setString(18, "0");

					k = pst9.executeUpdate();

				}

				/// new insertiom

				/*
				 * PreparedStatement pstcx9 = conn.prepareStatement(
				 * "insert into customerpayment(Invoiceno,paidamount,pay_mode,CHECK_date,check_no,card_trn_id,insurance_comp,paybycash,paybycheque,paybycredit,total,receiptno) values(?,?,?,?,?,?,?,?,?,?,?,?)"
				 * );
				 * 
				 * pstcx9.setString(1,stringValue1);
				 * 
				 * // CASH if(ib.getPaymod().equalsIgnoreCase("CASH")) {
				 * pstcx9.setString(3, "CASH");
				 * 
				 * String paid_amt1="";
				 * 
				 * paid_amt1=ib.getNet_amount();
				 * 
				 * 
				 * try{ x = Integer.valueOf(paid_amt1); }catch (Exception e) {
				 * 
				 * x=0; }
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * pstcx9.setString(2, ""+x);
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,""+x);
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * // CHEQUE else if(ib.getPaymod().equalsIgnoreCase("CHEQUE"))
				 * {
				 * 
				 * 
				 * pstcx9.setString(3, "CHEQUE"); Integer l=0; String
				 * paid_amt2=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getCash_amt();
				 * 
				 * 
				 * chek_amt=ib.getCheque_amt(); Integer c=0; try{ l =
				 * Integer.valueOf(chek_amt); }catch (Exception e) {
				 * 
				 * l=0; } pstcx9.setString(2, ""+l);
				 * 
				 * 
				 * pstcx9.setString(5,ib.getCheque_no());
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""+l); pstcx9.setString(10,"");
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); DateFormat ft = new
				 * SimpleDateFormat("yyyy/MM/dd"); String
				 * dateInString=ib.getCheque_date(); Date dNo = new Date(); dNo
				 * = ft.parse(dateInString); Date dNow = new Date();
				 * 
				 * 
				 * try{
				 * pst9.setString(4,CoreData.getDateFormatAsDb(ib.getDate()));
				 * }catch (Exception e) {
				 * 
				 * pst9.setString(2,null); }
				 * 
				 * 
				 * try{ pstcx9.setString(4,CoreData.getDateFormatAsDb(ib.
				 * getCheque_date())); }catch (Exception e) {
				 * 
				 * pstcx9.setString(4,null); }
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * 
				 * //credit
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("CREDIT")) {
				 * 
				 * 
				 * pstcx9.setString(3, "CARD");
				 * 
				 * String paid_amt2=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getNet_amountcard();
				 * 
				 * 
				 * chek_amt=ib.getNet_amountcard(); Integer c=0; Integer a=0;
				 * try{ a = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a);
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,ib.getCardid()); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,""+a);
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * // Insurance else
				 * if(ib.getPaymod().equalsIgnoreCase("INSURANCE")) {
				 * 
				 * 
				 * pstcx9.setString(3, "INSURANCE");
				 * 
				 * String paid_amt2=""; String balace=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getPaid_amt22();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard();
				 * balace=ib.getBalance_amt22(); Integer c=0; Integer a=0; try{
				 * a = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a); try{ c =
				 * Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; } pstcx9.setNull(4,java.sql.Types.DATE);
				 * pstcx9.setString(5, "");
				 * 
				 * pstcx9.setString(6,"");
				 * pstcx9.setString(7,ib.getInsurance());
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
				 * 
				 * 
				 * //pstcx9.setString(3, "PARTPAYMENT"); String paymode="";
				 * String paid_amt2=""; String balace=""; String chek_amt="";
				 * 
				 * paid_amt2=ib.getPaid_amt();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard();
				 * balace=ib.getBalance_amt(); Integer c=0; Integer a=0; try{ a
				 * = Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; } pstcx9.setString(2, ""+a); try{ c =
				 * Integer.valueOf(balace); }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * String ppmode=""; if
				 * (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
				 * paymode=ib.getR1()+"~"+"CASH"; pstcx9.setString(8, ""+a);
				 * pstcx9.setString(9, "0"); pstcx9.setString(10, "0");
				 * 
				 * } else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
				 * {
				 * 
				 * paymode=ib.getR1()+"~"+"CHEQUE"; pstcx9.setString(9, ""+a);
				 * pstcx9.setString(8, "0"); pstcx9.setString(10, "0"); } else
				 * if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
				 * paymode=ib.getR1()+"~"+"CARD"; pstcx9.setString(8,"0");
				 * 
				 * pstcx9.setString(9, "0"); pstcx9.setString(10, ""+a);
				 * 
				 * } else { paymode=ib.getPaymod(); pstcx9.setString(8,"0");
				 * 
				 * pstcx9.setString(9, "0"); pstcx9.setString(10,"0"); }
				 * 
				 * 
				 * pstcx9.setString(3, paymode);
				 * 
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(6,""); pstcx9.setString(7,"");
				 * pstcx9.setString(8,"");
				 * 
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * 
				 * 
				 * v=pstcx9.executeUpdate();
				 * 
				 * }
				 * 
				 * 
				 * // card and cash
				 * 
				 * else if(ib.getPaymod().equalsIgnoreCase("CARDANDCASH")) {
				 * 
				 * 
				 * pstcx9.setString(3, "CARDANDCASH");
				 * 
				 * String paid_amt2=""; String balace=""; String credit="";
				 * 
				 * paid_amt2=ib.getCashhh();
				 * 
				 * 
				 * //chek_amt=ib.getNet_amountcard(); credit=ib.getCarddd();
				 * Integer c=0; Integer a=0; Integer p=0; try{ a =
				 * Integer.valueOf(paid_amt2); }catch (Exception e) {
				 * 
				 * a=0; }
				 * 
				 * try{ c = Integer.valueOf(credit); }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * p=(a+c);
				 * 
				 * pstcx9.setString(2, ""+a); try{ c = Integer.valueOf(balace);
				 * }catch (Exception e) {
				 * 
				 * c=0; }
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE); pstcx9.setString(5,
				 * "");
				 * 
				 * pstcx9.setString(7,""); pstcx9.setString(8,paid_amt2);
				 * pstcx9.setString(9,""); pstcx9.setString(10,credit);
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1); v=pstcx9.executeUpdate();
				 * 
				 * }else{ pstcx9.setString(2, ""); pstcx9.setString(3, "");
				 * 
				 * pstcx9.setNull(4,java.sql.Types.DATE);
				 * pstcx9.setString(5,""); pstcx9.setString(6,"");
				 * pstcx9.setString(7,""); pstcx9.setString(8,"");
				 * pstcx9.setString(9,""); pstcx9.setString(10,"");
				 * 
				 * pstcx9.setString(11, ""+ib.getTamount());
				 * pstcx9.setString(12,stringValue1);
				 * 
				 * v= pstcx9.executeUpdate();
				 * 
				 * 
				 * 
				 * 
				 * 
				 * }
				 */

				// Insert Into Customer Credit Debit Report

				String query11 = "insert into customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,year,username,datetime)VALUES(?,?,?,?,?,?,?,?,?,?,?)";

				pst9 = conn.prepareStatement(query11);
				pst9.setString(1, ib.getCustomer_Id());
				pst9.setString(2, CoreData.getDateFormatAsDb(ib.getDate()));
				pst9.setString(3, stringValue1);
				pst9.setString(4, "Sales Return");
				pst9.setString(5, "101");
				pst9.setString(6, "Credit");
				pst9.setString(7, ib.getTamount());

				pst9.setString(8, ib.getCustomer_name());

				pst9.setString(9, bean.getYearlogin());
				pst9.setString(10, bean.getUsername());
				pst9.setString(11, SystemDateTime.CurrentDateTime());

				System.out.println("SQL:" + pst9);
				k = pst9.executeUpdate();

				// Bill Number Generation For Customer Credit Debit

				String stringValue = "";
				int len11 = 0;
				PreparedStatement preparedStatement1x = conn
						.prepareStatement("SELECT * FROM  customercreditdebit where year='" + Fyear + "'");

				ResultSet resultSet1x = preparedStatement1x.executeQuery();
				while (resultSet1x.next()) {
					len11++;
				}

				int size = len11 + 1;
				stringValue = String.valueOf(size);

				String ap = "IP";

				if (stringValue.length() == 1) {
					stringValue = "ICP/" + ap + "/000" + stringValue;
				} else if (stringValue.length() == 2) {
					stringValue = "ICP/" + ap + "/00" + stringValue;
				} else if (stringValue.length() == 3) {
					stringValue = "ICP/" + ap + "/0" + stringValue;
				} else {
					stringValue = "ICP/" + ap + "/" + stringValue;
				}

				ib.setBillno(stringValue);

				/*
				 * if(!(ib.getPaymod().equals("0")) &&
				 * !(Double.parseDouble(ib.getNet_amount())<=0))
				 * 
				 * // if(!(Integer.parseInt(ib.getPaymod())==0) &&
				 * !(Double.parseDouble(ib.getNet_amount())<=0))
				 * 
				 * {
				 * 
				 * 
				 * String queryee=
				 * "INSERT INTO customercreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name)VALUES(?,?,?,?,?,?,?,?)"
				 * ;
				 * 
				 * pst99=conn.prepareStatement(queryee); pst99.setString(1,
				 * ib.getCustomer_Id());
				 * pst99.setString(2,CoreData.getDateFormatAsDb(ib.getDate()));
				 * pst99.setString(3,stringValue); pst99.setString(4,
				 * "Invoice Payment"); pst99.setString(5, "201");
				 * pst99.setString(6, "Credit");
				 * 
				 * if (ib.getPaymod().trim().equals("CASH")) {
				 * 
				 * String paybycash=ib.getNet_amount();
				 * 
				 * pst99.setString(7,paybycash );
				 * 
				 * 
				 * 
				 * 
				 * } else if (ib.getPaymod().equalsIgnoreCase("CHEQUE")) {
				 * String paybycash=ib.getCheque_amt();
				 * 
				 * pst99.setString(7,paybycash );
				 * 
				 * 
				 * 
				 * 
				 * }
				 * 
				 * else if (ib.getPaymod().equalsIgnoreCase("CREDIT")) {
				 * 
				 * String paybycash=ib.getNet_amountcard();
				 * 
				 * pst99.setString(7,paybycash );
				 * 
				 * }
				 * 
				 * 
				 * 
				 * else if (ib.getPaymod().equalsIgnoreCase("PARTPAYMENT")) {
				 * 
				 * String paybycash= ib.getPaid_amt();
				 * 
				 * 
				 * if (ib.getR1().equalsIgnoreCase("partpaymentcash")) {
				 * 
				 * pst99.setString(7,paybycash);
				 * 
				 * 
				 * } else if (ib.getR1().equalsIgnoreCase("partpaymentcheque"))
				 * {
				 * 
				 * 
				 * pst99.setString(7,paybycash);
				 * 
				 * } else if (ib.getR1().equalsIgnoreCase("partpaymentcard")) {
				 * 
				 * pst99.setString(7,paybycash);
				 * 
				 * } else {
				 * 
				 * pst99.setString(7,"0"); }
				 * 
				 * 
				 * 
				 * 
				 * }
				 * 
				 * pst99.setString(8,ib.getCustomer_name());
				 * 
				 * System.out.println("SQL:"+pst9); k=pst99.executeUpdate();
				 * 
				 * }
				 * 
				 * //--------------------
				 * 
				 * 
				 * PreparedStatement preparedStatement1121 = conn
				 * .prepareStatement(
				 * "update  job_card set job_card_done_status='" + 1 +
				 * "' where job_card_no=? ");
				 * 
				 * preparedStatement1121.setString(1, ib.getJob_Card_no()); j =
				 * preparedStatement1121.executeUpdate();
				 * 
				 * if (k > 0 && j > 0 && v>0) { response = "success"; } else {
				 * response = "fail";
				 * 
				 * }
				 */

				/*
				 * PreparedStatement preparedStatement112z1 =
				 * conn.prepareStatement("select * from settings ");
				 * //System.out.println("preparedStatement112"+
				 * preparedStatement112); ResultSet resultSet12z1 =
				 * preparedStatement112z1.executeQuery();
				 * 
				 * if (resultSet12z1.next()) {
				 * 
				 * if(resultSet12z1.getString("withstock").equals("yes")){
				 * 
				 * for (int k2=0;k<ib.getDescription1().length;k2++) {
				 * 
				 * 
				 * PreparedStatement ppt = conn .prepareStatement(
				 * "select * from purchase_order_details where invoice_no='"
				 * +ib.getPono()+"' and descrip='"+ib.getDescription1()[k2]+"' "
				 * );
				 * 
				 * System.out.println("SQL:"+pp); ResultSet rst =
				 * ppt.executeQuery();
				 * 
				 * while (rst.next()) {
				 * 
				 * String desc=ib.getDescription1()[k2]; String
				 * qty=rst.getString("qtyremaining");
				 * 
				 * String qty1=ib.getQuantity1()[k2];
				 * 
				 * Double qty2=Double.parseDouble(qty)+Double.parseDouble(qty1);
				 * 
				 * System.out.println("QUantity:"+qty2);
				 * 
				 * String q11 =
				 * "update purchase_order_details set  qtyremaining='"+qty2+
				 * "' where descrip='"+desc+"' and invoice_no='"
				 * +ib.getPono()+"'"; PreparedStatement ps1 =
				 * conn.prepareStatement(q11);
				 * 
				 * 
				 * System.out.println("Sql12::"+ps1);
				 * 
				 * ps1.executeUpdate();
				 * 
				 * }
				 * 
				 * } } }
				 */

				// list insert

				int rr = 0;
				String q1 = "insert into invoice_tax_details_sales_return(invoice_no,type,descrip,qty,amt,vat_percent,tax_amt_percent,net_amt,type_name,igstrate,igstamount,sgstrate,sgstamount,rate,partno,partdate,partnox,year,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement pst41 = conn.prepareStatement(q1);
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

						pst41.setString(18, bean.getYearlogin());
						pst41.setString(19, bean.getUsername());
						pst41.setString(20, SystemDateTime.CurrentDateTime());

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
				q1 = "insert into invoice_tax_collection_sales_return(invoice_no,tax_type,taxable_amt,tax_amt,date,year,username,datetime) values(?,?,?,?,?,?,?,?)";

				pst41 = conn.prepareStatement(q1);
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

					pst41.setString(6, bean.getYearlogin());
					pst41.setString(7, bean.getUsername());
					pst41.setString(8, SystemDateTime.CurrentDateTime());

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

			try {

				DBConnection.closeConnection();

			} catch (Exception e) {

			}

		}

		return response;
	}
	
	
	
	
	
	
	
	
	
	
	
public String SendToTally(invoicebean1 ib) throws Exception {

    	
	Connection conn=connection.getConnection();
	
        String Url = "http://192.168.1.9:9000/"; 
        
        System.out.println("url is"+Url);  


        String SOAPAction = "";

        String Voucher = this.CreateRequest(ib);

        // Create the connection where we're going to send the file.
        URL url = new URL(Url);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;

        ByteArrayInputStream bin = new ByteArrayInputStream(Voucher.getBytes());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        // Copy the SOAP file to the open connection.

        copy1(bin, bout); 

        byte[] b = bout.toByteArray();

        // Set the appropriate HTTP parameters.
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);

        // Everything's set up; send the XML that was read in to b.
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();
   //     System.out.println("hiii");
        // Read the response and write it to standard out.

        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
      // System.out.println("isr"+isr);
        BufferedReader in = new BufferedReader(isr);
       // System.out.println("in"+in);
        String inputLine;
        
        String msg="";
       
	while ((inputLine = in.readLine()) != null) {
           
		System.out.println("777"+inputLine);
          
            if(inputLine.contains("<ERRORS>0</ERRORS>")){
            	msg="success";
            	break;
            }else{
            	msg="fail";
            }
            
            
        }
        
        System.out.println("msg>>>"+msg);
       
        in.close();
		
        return msg;
    
    	
    }
    


public void copy1(InputStream in, OutputStream out)
            throws IOException {

        // do not allow other threads to read from the
        // input or write to the output while copying is
        // taking place

        synchronized (in) {
            synchronized (out) {

                byte[] buffer = new byte[256];
                while (true) {
                    int bytesRead = in.read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }
                    out.write(buffer, 0, bytesRead);
                }
            }
        }
    }
	
	











/*public String CreateRequest(invoicebean1 ib) throws SQLException {
	 

	//System.out.println("hello"); 
   String TXML = null;
   
   
   
   Connection conn=connection.getConnection();

   PreparedStatement preparedStatementx = conn
  			.prepareStatement("select * from destributor_master where destributor_id='"
  					+ ib.getCustomer_Id() + "'");

  			ResultSet resultSetx = preparedStatementx.executeQuery();
  			//System.out.println("ddddd"+preparedStatementx);
  			if (resultSetx.next()) {
  				
  				
  					ib.setCustomer_name1(resultSetx.getString("name"));
  					
  					ib.setAddress1(resultSetx.getString("address"));
  					ib.setVat007(resultSetx.getString("gstn"));
  					ib.setState1(resultSetx.getString("state"));
  					ib.setPincode(resultSetx.getString("pincode"));
  					ib.setEmail(resultSetx.getString("email"));
      
      
  			}
   
   
   
  			String date=CoreData.getDateFormatAsDb(ib.getDate());
  		   	date=date.replaceAll("-", "");
  		       
  		       Double amtwithouttax=0.0;
  		       String stockitem="";
  		       String tax11="";
  		       
  		     String cgstrate="";
  		     String sgstrate="";
  		       
  		       
  		       String inventory="";
  		       Double ocgst=0.0;
  		       Double osgst=0.0;
  		      
  		       for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
  		    	  
  		    	
  		    	  String desc=ib.getDescription1()[j1].replaceAll("&", "&amp;");
  		    	  
  		    	  //String unit=ib.getUnit1()[j1];

  		    		if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
  		    			String ttype="";
  		    			tax11=ib.getVat1()[j1];
  		    			
  		    			cgstrate=ib.getGrate1()[j1];
  		    			sgstrate=ib.getGrate2()[j1];
  		    			
  		    			
  		    			try{
  		    			amtwithouttax=amtwithouttax+Double.parseDouble(ib.getAmount1()[j1]);
  		    			}catch(Exception e){}
  		    			
  		    			try{
  		    				ocgst=ocgst+Double.parseDouble(ib.getGstamount1()[j1]);
  			    			}catch(Exception e){}
  			    			
  		    			
  		    			try{
  		    				osgst=osgst+Double.parseDouble(ib.getGstamount2()[j1]);
  			    			}catch(Exception e){}
  			    			
  		    			
  		    			try {
  							ttype = ib.getTtype()[j1];
  						} catch (Exception e) {
  							// TODO: handle exception
  							ttype = "";
  						}
			

			  System.out.println(">>>>"+desc);
  		    			stockitem+="  <STOCKITEM NAME=\""+desc+"\" RESERVEDNAME=\"\">" + 
  		    					"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		    					"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		    					"      </OLDAUDITENTRYIDS.LIST>" + 
  		    					"      <GUID>dbda3fe1-e516-4616-9b81-939d974dd35b-000089eb</GUID>" + 
  		    					"      <PARENT></PARENT>" + 
  		    					"      <CATEGORY/>" + 
  		    					"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		    					"      <TAXCLASSIFICATIONNAME/>" + 
  		    					"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		    					"      <EXCISEAPPLICABILITY>&#4; Applicable</EXCISEAPPLICABILITY>" + 
  		    					"      <SALESTAXCESSAPPLICABLE/>" + 
  		    					"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		    					"      <COSTINGMETHOD>FIFO</COSTINGMETHOD>" + 
  		    					"      <VALUATIONMETHOD>Avg. Price</VALUATIONMETHOD>" + 
  		    					"      <BASEUNITS></BASEUNITS>" + 
  		    					"      <ADDITIONALUNITS/>" + 
  		    					"      <EXCISEITEMCLASSIFICATION/>" + 
  		    					"      <VATBASEUNIT></VATBASEUNIT>" + 
  		    					"      <GSTREPUOM></GSTREPUOM>" + 
  		    					"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		    					"      <ISBATCHWISEON>Yes</ISBATCHWISEON>" + 
  		    					"      <ISPERISHABLEON>No</ISPERISHABLEON>" + 
  		    					"      <ISENTRYTAXAPPLICABLE>No</ISENTRYTAXAPPLICABLE>" + 
  		    					"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  		    					"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		    					"      <ASORIGINAL>No</ASORIGINAL>" + 
  		    					"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		    					"      <IGNOREPHYSICALDIFFERENCE>No</IGNOREPHYSICALDIFFERENCE>" + 
  		    					"      <IGNORENEGATIVESTOCK>No</IGNORENEGATIVESTOCK>" + 
  		    					"      <TREATSALESASMANUFACTURED>No</TREATSALESASMANUFACTURED>" + 
  		    					"      <TREATPURCHASESASCONSUMED>No</TREATPURCHASESASCONSUMED>" + 
  		    					"      <TREATREJECTSASSCRAP>No</TREATREJECTSASSCRAP>" + 
  		    					"      <HASMFGDATE>No</HASMFGDATE>" + 
  		    					"      <ALLOWUSEOFEXPIREDITEMS>No</ALLOWUSEOFEXPIREDITEMS>" + 
  		    					"      <IGNOREBATCHES>No</IGNOREBATCHES>" + 
  		    					"      <IGNOREGODOWNS>No</IGNOREGODOWNS>" + 
  		    					"      <CALCONMRP>No</CALCONMRP>" + 
  		    					"      <EXCLUDEJRNLFORVALUATION>No</EXCLUDEJRNLFORVALUATION>" + 
  		    					"      <ISMRPINCLOFTAX>No</ISMRPINCLOFTAX>" + 
  		    					"      <ISADDLTAXEXEMPT>No</ISADDLTAXEXEMPT>" + 
  		    					"      <ISSUPPLEMENTRYDUTYON>No</ISSUPPLEMENTRYDUTYON>" + 
  		    					"      <GVATISEXCISEAPPL>No</GVATISEXCISEAPPL>" + 
  		    					"      <REORDERASHIGHER>No</REORDERASHIGHER>" + 
  		    					"      <MINORDERASHIGHER>No</MINORDERASHIGHER>" + 
  		    					"      <ISEXCISECALCULATEONMRP>No</ISEXCISECALCULATEONMRP>" + 
  		    					"      <INCLUSIVETAX>No</INCLUSIVETAX>" + 
  		    					"      <GSTCALCSLABONMRP>No</GSTCALCSLABONMRP>" + 
  		    					"      <MODIFYMRPRATE>No</MODIFYMRPRATE>" + 
  		    					"      <ALTERID> 1244566</ALTERID>" + 
  		    					"      <DENOMINATOR> 1</DENOMINATOR>" + 
  		    					"      <RATEOFVAT>0</RATEOFVAT>" + 
  		    					"      <VATBASENO> 1</VATBASENO>" + 
  		    					"      <VATTRAILNO> 1</VATTRAILNO>" + 
  		    					"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		    					"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		    					"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		    					"      <GSTDETAILS.LIST>" + 
  		    					"       <APPLICABLEFROM>"+date+"</APPLICABLEFROM>" + 
  		    					"       <CALCULATIONTYPE>On Value</CALCULATIONTYPE>" + 
  		    					"       <HSNCODE>"+ttype+"</HSNCODE>" + 
  		    					"       <HSNMASTERNAME/>" + 
  		    					"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		    					"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		    					"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		    					"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		    					"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		    					"       <STATEWISEDETAILS.LIST>" + 
  		    					"        <STATENAME>&#4; Any</STATENAME>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE> "+ib.getGrate1()[j1]+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE>"+ib.getGrate2()[j1]+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE> "+tax11+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		    					"       </STATEWISEDETAILS.LIST>" + 
  		    					"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		    					"      </GSTDETAILS.LIST>" + 
  		    					
  		    					"      <LANGUAGENAME.LIST>" + 
  		    					"       <NAME.LIST TYPE=\"String\">" + 
  		    					"        <NAME>"+desc+"</NAME>" + 
  		    					"       </NAME.LIST>" + 
  		    					"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		    					"      </LANGUAGENAME.LIST>" + 
  		    					"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		    					"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		    					"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		    					"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		    					"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		    					"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		    					"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		    					"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		    					"      <MRPDETAILS.LIST>      </MRPDETAILS.LIST>" + 
  		    					"      <VATCLASSIFICATIONDETAILS.LIST>      </VATCLASSIFICATIONDETAILS.LIST>" + 
  		    					"      <COMPONENTLIST.LIST>      </COMPONENTLIST.LIST>" + 
  		    					"      <ADDITIONALLEDGERS.LIST>      </ADDITIONALLEDGERS.LIST>" + 
  		    					"      <SALESLIST.LIST>      </SALESLIST.LIST>" + 
  		    					"      <PURCHASELIST.LIST>      </PURCHASELIST.LIST>" + 
  		    				
  		    	  				
  		    	  				"      <BATCHALLOCATIONS.LIST>      </BATCHALLOCATIONS.LIST>" + 
  		    	  				"      <TRADEREXCISEDUTIES.LIST>      </TRADEREXCISEDUTIES.LIST>" + 
  		    	  				"      <STANDARDCOSTLIST.LIST>      </STANDARDCOSTLIST.LIST>" + 
  		    	  				"      <STANDARDPRICELIST.LIST>      </STANDARDPRICELIST.LIST>" + 
  		    	  				"      <EXCISEITEMGODOWN.LIST>      </EXCISEITEMGODOWN.LIST>" + 
  		    	  				"      <MULTICOMPONENTLIST.LIST>      </MULTICOMPONENTLIST.LIST>" + 
  		    	  				"      <LBTDETAILS.LIST>      </LBTDETAILS.LIST>" + 
  		    	  				"      <PRICELEVELLIST.LIST>      </PRICELEVELLIST.LIST>" + 
  		    	  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		    	  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		    	  				"      <TEMPGSTITEMSLABRATES.LIST>      </TEMPGSTITEMSLABRATES.LIST>" + 
  		    	  				"     </STOCKITEM>" ;
  		    	  				

	
	 
		}
	 
		}
  
  		       
  		       
  
  		    PreparedStatement preparedStatement112zz = conn.prepareStatement("select * from invoice_hsn_details where invoiceno='"+ib.getInvoiceno()+"'    ");
  			System.out.println("preparedStatement112"+preparedStatement112zz);
  		ResultSet resultSet12zz = preparedStatement112zz.executeQuery();
  		String taxxml="";
  		
  		String abc="";
  		String st="";
  		int hhh=0;
  		Double amtwtax=0.0;
  		while (resultSet12zz.next()) {
  			String tax="";
  			
  			String taxx="";
  			String tax1="";
  			
  			String tax3="";
  			
  			String tax2="";
  			ocgst=0.0;
  			osgst=0.0;
  			amtwithouttax=0.0;
  			try{
  				if(resultSet12zz.getString("rate").endsWith("18")){
  			 tax="18%";
  			 tax1="9%";
  			 taxx="18";
  			 tax2="9";
  			tax3="18";
  				}
  				
  				if(resultSet12zz.getString("rate").endsWith("28")){
  					 tax="28%";
  					 tax1="14%";
  					 taxx="28";
  					tax2="14";
  					tax3="28";
  						}
  				
  				if(resultSet12zz.getString("rate").endsWith("12")){
 					 tax="12%";
 					 tax1="6%";
 					 taxx="12";
 					tax2="6";
 					tax3="12";
 						}
  				
  				 amtwithouttax=Double.parseDouble(resultSet12zz.getString("taxablevalue"));
  				 ocgst=ocgst+Double.parseDouble(resultSet12zz.getString("cgstamount"));
  				 osgst=osgst+Double.parseDouble(resultSet12zz.getString("sgstamount"));
  				 ocgst=Math.round(ocgst * 100.0) / 100.0;
  				 osgst=Math.round(osgst * 100.0) / 100.0;
  				 amtwithouttax=Math.round(amtwithouttax * 100.0) / 100.0;
  				 
  				 amtwtax=amtwtax+(amtwithouttax+ocgst+osgst);
  				 System.out.println(amtwithouttax+"MM>>>>>>"+ocgst+"NN>>>>>>"+osgst);
  			}catch(Exception e){}
  			
  			
  			PreparedStatement preparedStatement112zz1 = conn.prepareStatement("select * from invoice_tax_details where invoice_no='"+ib.getInvoiceno()+"' and vat_percent='"+taxx+"' and type_name='"+resultSet12zz.getString("hsncode")+"'   ");
  			//System.out.println("preparedStatement112"+preparedStatement112zz1);
  		ResultSet resultSet12zz1 = preparedStatement112zz1.executeQuery();
  		
  		while (resultSet12zz1.next()) {
  			String tttt="";
  			String unit="";
  			String disc="";
  			String amt="";
  			String rate="";
  			String batch="";
  			String invoice_no="";
  			
  			String totaltax="";
  			
  			
  			
  			
  			
  			
  			
  			
  			String totaltaxamt="";
  			
  			try{
  				tttt=resultSet12zz1.getString("descrip").replaceAll("&", "&amp;");
  				 
  				//unit=resultSet12zz1.getString("unit");
  				 
  				 disc=resultSet12zz1.getString("disc");
  				 
  				 rate=resultSet12zz1.getString("rate");
  				 
  				 amt=resultSet12zz1.getString("net_amt");
  				 
  				 invoice_no=resultSet12zz1.getString("invoice_no");
  				 
  				totaltax=resultSet12zz1.getString("vat_percent");
  				 
  				 // batch=resultSet12zz1.getString("amt");
  			
  			}catch(Exception e){}
  			System.out.println(">>>>>>>>"+amt);
  			
  			st   +="<ALLINVENTORYENTRIES.LIST>" + 
  					"       <STOCKITEMNAME>"+tttt+"</STOCKITEMNAME>" + 
  					"       <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  					"       <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  					"       <ISAUTONEGATE>No</ISAUTONEGATE>" + 
  					"       <ISCUSTOMSCLEARANCE>No</ISCUSTOMSCLEARANCE>" + 
  					"       <ISTRACKCOMPONENT>No</ISTRACKCOMPONENT>" + 
  					"       <ISTRACKPRODUCTION>No</ISTRACKPRODUCTION>" + 
  					"       <ISPRIMARYITEM>No</ISPRIMARYITEM>" + 
  					"       <ISSCRAP>No</ISSCRAP>" + 
  					"       <RATE>"+rate+"</RATE>" + 
  					"       <DISCOUNT> "+disc+"</DISCOUNT>" + 
  					"       <AMOUNT>"+amt+"</AMOUNT>" + 
  					"       <ACTUALQTY> 30 Pkt. 0 Pch.</ACTUALQTY>" + 
  					"       <BILLEDQTY> 30 Pkt. 0 Pch.</BILLEDQTY>" + 
  					"       <BATCHALLOCATIONS.LIST>" + 
  					"        <GODOWNNAME>Main Location</GODOWNNAME>" + 
  					"        <BATCHNAME>01</BATCHNAME>" + 
  					"        <DESTINATIONGODOWNNAME>Main Location</DESTINATIONGODOWNNAME>" + 
  					"        <INDENTNO/>" + 
  					"        <ORDERNO>"+ib.getOrder_id()+"</ORDERNO>" + 
  					"        <TRACKINGNUMBER>"+ib.getOrder_id()+"</TRACKINGNUMBER>" + 
  					"        <DYNAMICCSTISCLEARED>No</DYNAMICCSTISCLEARED>" + 
  					"        <AMOUNT>"+amt+"</AMOUNT>" + 
  					"        <ACTUALQTY> 30 Pkt. 0 Pch.</ACTUALQTY>" + 
  					"        <BILLEDQTY> 30 Pkt. 0 Pch.</BILLEDQTY>" + 
  					"        <ORDERDUEDATE >"+date+"</ORDERDUEDATE>" + 
  					"        <ADDITIONALDETAILS.LIST>        </ADDITIONALDETAILS.LIST>" + 
  					"        <VOUCHERCOMPONENTLIST.LIST>        </VOUCHERCOMPONENTLIST.LIST>" + 
  					"       </BATCHALLOCATIONS.LIST>" + 
  					"       <ACCOUNTINGALLOCATIONS.LIST>" + 
  					"        <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  					"         <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  					"        </OLDAUDITENTRYIDS.LIST>" + 
  					"        <LEDGERNAME>Sales @ "+totaltax+"% GST</LEDGERNAME>" + 
  					"        <GSTCLASS/>" + 
  					"        <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  					"        <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  					"        <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  					"        <ISPARTYLEDGER>No</ISPARTYLEDGER>" + 
  					"        <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  					"        <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  					"        <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  					"        <AMOUNT>"+amt+"</AMOUNT>" + 
  					"        <SERVICETAXDETAILS.LIST>        </SERVICETAXDETAILS.LIST>" + 
  					"        <BANKALLOCATIONS.LIST>        </BANKALLOCATIONS.LIST>" + 
  					"        <BILLALLOCATIONS.LIST>        </BILLALLOCATIONS.LIST>" + 
  					"        <INTERESTCOLLECTION.LIST>        </INTERESTCOLLECTION.LIST>" + 
  					"        <OLDAUDITENTRIES.LIST>        </OLDAUDITENTRIES.LIST>" + 
  					"        <ACCOUNTAUDITENTRIES.LIST>        </ACCOUNTAUDITENTRIES.LIST>" + 
  					"        <AUDITENTRIES.LIST>        </AUDITENTRIES.LIST>" + 
  					"        <INPUTCRALLOCS.LIST>        </INPUTCRALLOCS.LIST>" + 
  					"        <DUTYHEADDETAILS.LIST>        </DUTYHEADDETAILS.LIST>" + 
  					"        <EXCISEDUTYHEADDETAILS.LIST>        </EXCISEDUTYHEADDETAILS.LIST>" + 
  					"        <RATEDETAILS.LIST>        </RATEDETAILS.LIST>" + 
  					"        <SUMMARYALLOCS.LIST>        </SUMMARYALLOCS.LIST>" + 
  					"        <STPYMTDETAILS.LIST>        </STPYMTDETAILS.LIST>" + 
  					"        <EXCISEPAYMENTALLOCATIONS.LIST>        </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  					"        <TAXBILLALLOCATIONS.LIST>        </TAXBILLALLOCATIONS.LIST>" + 
  					"        <TAXOBJECTALLOCATIONS.LIST>        </TAXOBJECTALLOCATIONS.LIST>" + 
  					"        <TDSEXPENSEALLOCATIONS.LIST>        </TDSEXPENSEALLOCATIONS.LIST>" + 
  					"        <VATSTATUTORYDETAILS.LIST>        </VATSTATUTORYDETAILS.LIST>" + 
  					"        <COSTTRACKALLOCATIONS.LIST>        </COSTTRACKALLOCATIONS.LIST>" + 
  					"        <REFVOUCHERDETAILS.LIST>        </REFVOUCHERDETAILS.LIST>" + 
  					"        <INVOICEWISEDETAILS.LIST>        </INVOICEWISEDETAILS.LIST>" + 
  					"        <VATITCDETAILS.LIST>        </VATITCDETAILS.LIST>" + 
  					"        <ADVANCETAXDETAILS.LIST>        </ADVANCETAXDETAILS.LIST>" + 
  					"       </ACCOUNTINGALLOCATIONS.LIST>" + 
  					"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  					"       <SUPPLEMENTARYDUTYHEADDETAILS.LIST>       </SUPPLEMENTARYDUTYHEADDETAILS.LIST>" + 
  					"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  					"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  					"       <EXCISEALLOCATIONS.LIST>       </EXCISEALLOCATIONS.LIST>" + 
  					"       <EXPENSEALLOCATIONS.LIST>       </EXPENSEALLOCATIONS.LIST>" + 
  					"      </ALLINVENTORYENTRIES.LIST>";
  			
  			


}

  		
  		
  		



  		
  	} 
  		 taxxml+="<LEDGER NAME=\"Sales @ 18% GST\" RESERVEDNAME=\"\">" + 
  		  		"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		  		"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		  		"      </OLDAUDITENTRYIDS.LIST>" + 
  		  		"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  		  		"      <CREATEDDATE>20170708</CREATEDDATE>" + 
  		  		"      <ALTEREDON>20180710</ALTEREDON>" + 
  		  		"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047f3</GUID>" + 
  		  		"      <CURRENCYNAME></CURRENCYNAME>" + 
  		  		"      <PARENT>Sales Accounts</PARENT>" + 
  		  		"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		  		"      <CREATEDBY>manohar</CREATEDBY>" + 
  		  		"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  		  		"      <TAXCLASSIFICATIONNAME/>" + 
  		  		"      <TAXTYPE>Others</TAXTYPE>" + 
  		  		"      <GSTTYPE/>" + 
  		  		"      <APPROPRIATEFOR/>" + 
  		  		"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		  		"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  		  		"      <EXCISELEDGERCLASSIFICATION/>" + 
  		  		"      <EXCISEDUTYTYPE/>" + 
  		  		"      <EXCISENATUREOFPURCHASE/>" + 
  		  		"      <LEDGERFBTCATEGORY/>" + 
  		  		"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		  		"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  		  		"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		  		"      <ISINTERESTON>No</ISINTERESTON>" + 
  		  		"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  		  		"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  		  		"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  		  		"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		  		"      <ASORIGINAL>No</ASORIGINAL>" + 
  		  		"      <ISCONDENSED>No</ISCONDENSED>" + 
  		  		"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  		  		"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		  		"      <FORPAYROLL>No</FORPAYROLL>" + 
  		  		"      <ISABCENABLED>No</ISABCENABLED>" + 
  		  		"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  		  		"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  		  		"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  		  		"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  		  		"      <USEFORVAT>No</USEFORVAT>" + 
  		  		"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  		  		"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  		  		"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  		  		"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  		  		"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  		  		"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  		  		"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  		  		"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  		  		"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  		  		"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  		  		"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  		  		"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  		  		"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  		  		"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  		  		"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  		  		"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  		  		"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  		  		"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  		  		"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  		  		"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  		  		"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  		  		"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  		  		"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  		  		"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  		  		"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  		  		"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  		  		"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  		  		"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  		  		"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  		  		"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  		  		"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  		  		"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  		  		"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  		  		"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  		  		"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  		  		"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  		  		"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  		  		"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  		  		"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  		  		"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  		  		"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  		  		"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  		  		"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  		  		"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  		  		"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  		  		"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  		  		"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  		  		"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  		  		"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  		  		"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  		  		"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  		  		"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  		  		"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  		  		"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  		  		"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  		  		"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  		  		"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  		  		"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  		  		"      <HASEDDCITY>No</HASEDDCITY>" + 
  		  		"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  		  		"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  		  		"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  		  		"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  		  		"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  		  		"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  		  		"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  		  		"      <ISSCBUAE>No</ISSCBUAE>" + 
  		  		"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  		  		"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  		  		"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  		  		"      <AUDITED>No</AUDITED>" + 
  		  		"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  		  		"      <ALTERID> 118554</ALTERID>" + 
  		  		"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		  		"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  		  		"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		  		"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		  		"      <GSTDETAILS.LIST>" + 
  		  		"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  		  		"       <HSNMASTERNAME/>" + 
  		  		"       <HSN>Namkeen</HSN>" + 
  		  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		  		"       <STATEWISEDETAILS.LIST>" + 
  		  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE>9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 18</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		  		"       </STATEWISEDETAILS.LIST>" + 
  		  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		  		"      </GSTDETAILS.LIST>" + 
  		  		"      <GSTDETAILS.LIST>" + 
  		  		"       <APPLICABLEFROM>20180701</APPLICABLEFROM>" + 
  		  		"       <HSNMASTERNAME/>" + 
  		  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		  		"       <STATEWISEDETAILS.LIST>" + 
  		  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 18</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		  		"       </STATEWISEDETAILS.LIST>" + 
  		  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		  		"      </GSTDETAILS.LIST>" + 
  		  		"      <LANGUAGENAME.LIST>" + 
  		  		"       <NAME.LIST TYPE=\"String\">" + 
  		  		"        <NAME>Sales @ 18% GST</NAME>" + 
  		  		"       </NAME.LIST>" + 
  		  		"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		  		"      </LANGUAGENAME.LIST>" + 
  		  		"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  		  		"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  		  		"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		  		"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		  		"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		  		"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		  		"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  		  		"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  		  		"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  		  		"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  		  		"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		  		"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  		  		"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  		  		"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  		  		"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  		  		"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  		  		"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  		  		"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  		  		"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		  		"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  		  		"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  		  		"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  		  		"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  		  		"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  		  		"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  		  		"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  		  		"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  		  		"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		  		"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		  		"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  		  		"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  		  		"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  		  		"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  		  		"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  		  		"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  		  		"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  		  		"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  		  		"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  		  		"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  		  		"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  		  		"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  		  		"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  		  		"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  		  		"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  		  		"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		  		"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		  		"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  		  		"     </LEDGER>";
  
  taxxml+="<LEDGER NAME=\"Sales @ 12% GST\" RESERVEDNAME=\"\">" + 
  		"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		"      </OLDAUDITENTRYIDS.LIST>" + 
  		"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  		"      <CREATEDDATE>20170708</CREATEDDATE>" + 
  		"      <ALTEREDON>20180710</ALTEREDON>" + 
  		"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047f3</GUID>" + 
  		"      <CURRENCYNAME></CURRENCYNAME>" + 
  		"      <PARENT>Sales Accounts</PARENT>" + 
  		"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		"      <CREATEDBY>manohar</CREATEDBY>" + 
  		"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  		"      <TAXCLASSIFICATIONNAME/>" + 
  		"      <TAXTYPE>Others</TAXTYPE>" + 
  		"      <GSTTYPE/>" + 
  		"      <APPROPRIATEFOR/>" + 
  		"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  		"      <EXCISELEDGERCLASSIFICATION/>" + 
  		"      <EXCISEDUTYTYPE/>" + 
  		"      <EXCISENATUREOFPURCHASE/>" + 
  		"      <LEDGERFBTCATEGORY/>" + 
  		"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  		"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		"      <ISINTERESTON>No</ISINTERESTON>" + 
  		"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  		"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  		"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  		"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		"      <ASORIGINAL>No</ASORIGINAL>" + 
  		"      <ISCONDENSED>No</ISCONDENSED>" + 
  		"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  		"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		"      <FORPAYROLL>No</FORPAYROLL>" + 
  		"      <ISABCENABLED>No</ISABCENABLED>" + 
  		"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  		"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  		"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  		"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  		"      <USEFORVAT>No</USEFORVAT>" + 
  		"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  		"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  		"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  		"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  		"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  		"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  		"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  		"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  		"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  		"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  		"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  		"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  		"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  		"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  		"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  		"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  		"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  		"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  		"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  		"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  		"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  		"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  		"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  		"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  		"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  		"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  		"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  		"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  		"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  		"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  		"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  		"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  		"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  		"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  		"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  		"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  		"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  		"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  		"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  		"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  		"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  		"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  		"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  		"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  		"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  		"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  		"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  		"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  		"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  		"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  		"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  		"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  		"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  		"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  		"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  		"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  		"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  		"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  		"      <HASEDDCITY>No</HASEDDCITY>" + 
  		"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  		"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  		"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  		"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  		"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  		"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  		"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  		"      <ISSCBUAE>No</ISSCBUAE>" + 
  		"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  		"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  		"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  		"      <AUDITED>No</AUDITED>" + 
  		"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  		"      <ALTERID> 118554</ALTERID>" + 
  		"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  		"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		"      <GSTDETAILS.LIST>" + 
  		"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  		"       <HSNMASTERNAME/>" + 
  		"       <HSN>Namkeen</HSN>" + 
  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		"       <STATEWISEDETAILS.LIST>" + 
  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 12</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		"       </STATEWISEDETAILS.LIST>" + 
  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		"      </GSTDETAILS.LIST>" + 
  		"      <GSTDETAILS.LIST>" + 
  		"       <APPLICABLEFROM>20180701</APPLICABLEFROM>" + 
  		"       <HSNMASTERNAME/>" + 
  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		"       <STATEWISEDETAILS.LIST>" + 
  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 12</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		"       </STATEWISEDETAILS.LIST>" + 
  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		"      </GSTDETAILS.LIST>" + 
  		"      <LANGUAGENAME.LIST>" + 
  		"       <NAME.LIST TYPE=\"String\">" + 
  		"        <NAME>Sales @ 12% GST</NAME>" + 
  		"       </NAME.LIST>" + 
  		"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		"      </LANGUAGENAME.LIST>" + 
  		"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  		"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  		"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  		"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  		"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  		"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  		"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  		"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  		"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  		"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  		"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  		"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  		"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  		"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  		"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  		"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  		"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  		"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  		"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  		"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  		"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  		"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  		"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  		"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  		"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  		"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  		"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  		"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  		"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  		"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  		"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  		"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  		"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  		"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  		"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  		"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  		"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  		"     </LEDGER>";
  

  		Double realtotal=amtwtax;
  		Double mytotal=Double.parseDouble(ib.getTamount());
  		//System.out.println("???111>>>"+realtotal);
  		//System.out.println("zczcx9>>>>"+mytotal);
  		if(Math.abs(realtotal-mytotal)<=1 && realtotal-mytotal!=0 && realtotal>mytotal){
  			
  			mytotal=mytotal+Math.abs(realtotal-mytotal);
  		}

  		if(Math.abs(realtotal-mytotal)<=1 && realtotal-mytotal!=0 && realtotal<mytotal){
  			
  		mytotal=mytotal-Math.abs(realtotal-mytotal);
  		}

  		//System.out.println("???"+realtotal);
  		//System.out.println("zczcx"+mytotal);
  		realtotal=Math.round(realtotal * 100.0) / 100.0;
  		mytotal=Math.round(mytotal * 100.0) / 100.0;
  		// ib.setTamount(""+realtotal);
  		      
  		System.out.println("Total::"+mytotal);
  

  		TXML = "<ENVELOPE>" + 
  				" <HEADER>" + 
  				"  <TALLYREQUEST>Import Data</TALLYREQUEST>" + 
  				" </HEADER>" + 
  				" <BODY>" + 
  				"  <IMPORTDATA>" + 
  				"   <REQUESTDESC>" + 
  				"    <REPORTNAME>Vouchers</REPORTNAME>" + 
  				"    <STATICVARIABLES>" + 
  				"     <SVCURRENTCOMPANY>Vasaya Foods ERP Demo</SVCURRENTCOMPANY>" + 
  				"    </STATICVARIABLES>" + 
  				"   </REQUESTDESC>" + 
  				"   <REQUESTDATA>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				
  				"     <GROUP NAME=\"Sales Accounts\" RESERVEDNAME=\"Sales Accounts\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000017</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>Yes</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>Yes</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 230</SORTPOSITION>" + 
  				"      <ALTERID> 116344</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales Accounts</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				"     <LEDGER NAME=\"Sales Tax Free - GST\" RESERVEDNAME=\"\">" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  				"      <CREATEDDATE>20170721</CREATEDDATE>" + 
  				"      <ALTEREDON>20181005</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00004816</GUID>" + 
  				"      <CURRENCYNAME>â‚¹</CURRENCYNAME>" + 
  				"      <VATDEALERTYPE>Regular</VATDEALERTYPE>" + 
  				"      <PARENT>Sales Accounts</PARENT>" + 
  				"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  				"      <CREATEDBY>manohar</CREATEDBY>" + 
  				"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> 118585</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>" + 
  				"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  				"       <HSNMASTERNAME/>" + 
  				"       <TAXABILITY>Exempt</TAXABILITY>" + 
  				"       <GSTNATUREOFTRANSACTION>Sales Exempt</GSTNATUREOFTRANSACTION>" + 
  				"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  				"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  				"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  				"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  				"       <STATEWISEDETAILS.LIST>" + 
  				"        <STATENAME>&#4; Any</STATENAME>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  				"       </STATEWISEDETAILS.LIST>" + 
  				"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  				"      </GSTDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>" + 
  				"       <APPLICABLEFROM>20180524</APPLICABLEFROM>" + 
  				"       <HSNCODE>1905</HSNCODE>" + 
  				"       <HSNMASTERNAME/>" + 
  				"       <TAXABILITY>Nil Rated</TAXABILITY>" + 
  				"       <GSTNATUREOFTRANSACTION>Sales Nil Rated</GSTNATUREOFTRANSACTION>" + 
  				"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  				"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  				"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  				"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  				"       <STATEWISEDETAILS.LIST>" + 
  				"        <STATENAME>&#4; Any</STATENAME>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  				"       </STATEWISEDETAILS.LIST>" + 
  				"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  				"      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales Tax Free - GST</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
 				
  				stockitem+
  				
  				
 				
  				
  				
  				
  				
  				"     <GROUP NAME=\"Indirect Expenses\" RESERVEDNAME=\"Indirect Expenses\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000001c</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>Yes</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 280</SORTPOSITION>" + 
  				"      <ALTERID> 116349</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Indirect Expenses</NAME>" + 
  				"        <NAME>Expenses (Indirect)</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"ADMINSITRATIVE EXPENSES\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000aa1</GUID>" + 
  				"      <PARENT>Indirect Expenses</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116375</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>ADMINSITRATIVE EXPENSES</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Misc. Expenses\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000a4b</GUID>" + 
  				"      <PARENT>ADMINSITRATIVE EXPENSES</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116366</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Misc. Expenses</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <LEDGER NAME=\"Amount Rounded Off\" RESERVEDNAME=\"\">" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  				"      <CREATEDDATE>20160410</CREATEDDATE>" + 
  				"      <ALTEREDON>20141202</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000858</GUID>" + 
  				"      <CURRENCYNAME>â‚¹</CURRENCYNAME>" + 
  				"      <PARENT>Misc. Expenses</PARENT>" + 
  				"      <CREATEDBY>Admin</CREATEDBY>" + 
  				"      <ALTEREDBY>Admin</ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>No</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> 116480</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Amount Rounded Off</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
  				
  				
  				"     <GROUP NAME=\"Current Liabilities\" RESERVEDNAME=\"Current Liabilities\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000003</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 30</SORTPOSITION>" + 
  				"      <ALTERID> 116324</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Current Liabilities</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Duties &amp; Taxes\" RESERVEDNAME=\"Duties &amp; Taxes\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000000e</GUID>" + 
  				"      <PARENT>Current Liabilities</PARENT>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 140</SORTPOSITION>" + 
  				"      <ALTERID> 116335</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Duties &amp; Taxes</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"GST\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047db</GUID>" + 
  				"      <PARENT>Duties &amp; Taxes</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116437</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>GST</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				
  				taxxml+
  				
  				
  				
  				"     <GROUP NAME=\"Current Assets\" RESERVEDNAME=\"Current Assets\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000006</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 60</SORTPOSITION>" + 
  				"      <ALTERID> 116327</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Current Assets</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Sundry Debtors\" RESERVEDNAME=\"Sundry Debtors\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000014</GUID>" + 
  				"      <PARENT>Current Assets</PARENT>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>Yes</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 200</SORTPOSITION>" + 
  				"      <ALTERID> 116341</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sundry Debtors</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Amin Charaniya Pcmc Group\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000096c</GUID>" + 
  				"      <PARENT>Sundry Debtors</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116355</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Amin Charaniya Pcmc Group</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				
  				
  				
  				"     <LEDGER NAME=\""+ib.getCustomer_name1()+"\" RESERVEDNAME=\"\">" + 
  				"      <ADDRESS.LIST TYPE=\"String\">" + 
  				"       <ADDRESS>"+ib.getAddress1()+"</ADDRESS>" + 
  				"      </ADDRESS.LIST>" + 
  				"      <MAILINGNAME.LIST TYPE=\"String\">" + 
  				"       <MAILINGNAME>"+ib.getCustomer_name1()+"</MAILINGNAME>" + 
  				"      </MAILINGNAME.LIST>" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>"+date+"</STARTINGFROM>" + 
  				"      <CREATEDDATE>"+date+"</CREATEDDATE>" + 
  				"      <ALTEREDON>"+date+"</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047ac</GUID>" + 
  				"      <CURRENCYNAME>â‚¹</CURRENCYNAME>" + 
  				"      <EMAIL>"+ib.getEmail()+"</EMAIL>" + 
  				"      <PINCODE>"+ib.getPincode()+"</PINCODE>" + 
  				"      <INTERSTATESTNUMBER>"+ib.getInvoiceno()+"</INTERSTATESTNUMBER>" + 
  				"      <VATTINNUMBER>"+ib.getInvoiceno()+"</VATTINNUMBER>" + 
  				"      <COUNTRYNAME>India</COUNTRYNAME>" + 
  				"      <GSTREGISTRATIONTYPE>Regular</GSTREGISTRATIONTYPE>" + 
  				"      <VATDEALERTYPE>Regular</VATDEALERTYPE>" + 
  				"      <PRICELEVEL>"+ib.getCustomer_name1()+"</PRICELEVEL>" + 
  				"      <PARENT>Sundry Debtors</PARENT>" + 
  				"      <CREATEDBY></CREATEDBY>" + 
  				"      <ALTEREDBY></ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <COUNTRYOFRESIDENCE>India</COUNTRYOFRESIDENCE>" + 
  				"      <LEDADDLALLOCTYPE/>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <PARTYGSTIN>"+ib.getVat007()+"</PARTYGSTIN>" + 
  				"      <GSTNATUREOFSUPPLY/>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <LEDSTATENAME>"+ib.getState1()+"</LEDSTATENAME>" + 
  				"      <PARTYBUSINESSSTYLE>"+ib.getCustomer_name1()+"</PARTYBUSINESSSTYLE>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>Yes</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <OPENINGBALANCE>-"+ib.getTamount()+"</OPENINGBALANCE>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>"+ib.getCustomer_name1()+"</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>" + 
  				"       <BILLDATE>"+date+"</BILLDATE>" + 
  				"       <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"       <ISADVANCE>No</ISADVANCE>" + 
  				"       <OPENINGBALANCE>-"+ib.getTamount()+"</OPENINGBALANCE>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
  				
  				
  				
  				
  				"     <VOUCHERTYPE NAME=\"Sales\" RESERVEDNAME=\"Sales\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000026</GUID>" + 
  				"      <PARENT>Sales</PARENT>" + 
  				"      <MAILINGNAME>Sale</MAILINGNAME>" + 
  				"      <TAXUNITNAME>&#4; Primary</TAXUNITNAME>" + 
  				"      <VCHPRINTTITLE>Tax Invoice</VCHPRINTTITLE>" + 
  				"      <VCHPRINTDECL>&quot;I/We hereby certify that my/our registration certificate under the GST Act 2017,is in force on the date on which the sale of the goods specified in this tax invoice is made by me/us and it shall be accounted for in the turnover of sales while filling of return and the due tax ,if any payable on the sale has been paid or shall be paid&quot;. &quot;I/We hereby certify that food/foods mentioned in this invoice is/are warranted to be safe in nature substance &amp; quality.</VCHPRINTDECL>" + 
  				"      <NUMBERINGMETHOD>Automatic</NUMBERINGMETHOD>" + 
  				"      <EXCISEUNITNAME>&#4; Primary</EXCISEUNITNAME>" + 
  				"      <VCHPRINTJURISDICTION>Pune</VCHPRINTJURISDICTION>" + 
  				"      <CONTRACONTRA/>" + 
  				"      <PAYMENTCONTRA/>" + 
  				"      <RECEIPTCONTRA/>" + 
  				"      <JOURNALCONTRA/>" + 
  				"      <CNOTECONTRA/>" + 
  				"      <DNOTECONTRA/>" + 
  				"      <SALESCONTRA/>" + 
  				"      <PURCHASECONTRA/>" + 
  				"      <CREDITCSTCTR/>" + 
  				"      <DEBITCSTCTR/>" + 
  				"      <PREVIOUSPURCHASE/>" + 
  				"      <PREVIOUSSALES/>" + 
  				"      <PREVIOUSGODOWN/>" + 
  				"      <PREVNARRATION>being 18 Bags of CN Rs.2/- Ruturn from Customer on 16/12/2018.</PREVNARRATION>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <PREVENTDUPLICATES>No</PREVENTDUPLICATES>" + 
  				"      <PREFILLZERO>Yes</PREFILLZERO>" + 
  				"      <PRINTAFTERSAVE>Yes</PRINTAFTERSAVE>" + 
  				"      <FORMALRECEIPT>No</FORMALRECEIPT>" + 
  				"      <ISOPTIONAL>Yes</ISOPTIONAL>" + 
  				"      <ASMFGJRNL>No</ASMFGJRNL>" + 
  				"      <EFFECTIVEDATE>No</EFFECTIVEDATE>" + 
  				"      <COMMONNARRATION>Yes</COMMONNARRATION>" + 
  				"      <MULTINARRATION>No</MULTINARRATION>" + 
  				"      <ISTAXINVOICE>Yes</ISTAXINVOICE>" + 
  				"      <USEFORPOSINVOICE>No</USEFORPOSINVOICE>" + 
  				"      <USEFOREXCISETRADERINVOICE>No</USEFOREXCISETRADERINVOICE>" + 
  				"      <USEFOREXCISE>No</USEFOREXCISE>" + 
  				"      <USEFORJOBWORK>No</USEFORJOBWORK>" + 
  				"      <ISFORJOBWORKIN>No</ISFORJOBWORKIN>" + 
  				"      <ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>" + 
  				"      <USEFOREXCISEGOODS>No</USEFOREXCISEGOODS>" + 
  				"      <USEFOREXCISESUPPLEMENTARY>No</USEFOREXCISESUPPLEMENTARY>" + 
  				"      <ISDEFAULTALLOCENABLED>No</ISDEFAULTALLOCENABLED>" + 
  				"      <SORTPOSITION> 70</SORTPOSITION>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <BEGINNINGNUMBER> 1</BEGINNINGNUMBER>" + 
  				"      <WIDTHOFNUMBER> 4</WIDTHOFNUMBER>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <PREFIXLIST.LIST>" + 
  				"       <DATE>"+date+"</DATE>" + 
  				"       <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"      </PREFIXLIST.LIST>" + 
  				"      <RESTARTFROMLIST.LIST>" + 
  				"       <DATE>"+date+"</DATE>" + 
  				"       <RESTARTFROM>Yearly</RESTARTFROM>" + 
  				"       <PERIODBEGINNIGNUM> 1</PERIODBEGINNIGNUM>" + 
  				"       <LASTNUMBERLIST.LIST>       </LASTNUMBERLIST.LIST>" + 
  				"      </RESTARTFROMLIST.LIST>" + 
  				"      <VOUCHERCLASSLIST.LIST>      </VOUCHERCLASSLIST.LIST>" + 
  				"      <PRODUCTCODEDETAILS.LIST>      </PRODUCTCODEDETAILS.LIST>" + 
  				"      <UDF:_UDF_553648231.LIST DESC=\"\" ISLIST=\"YES\" TYPE=\"Logical\" INDEX=\"102\">" + 
  				"       <UDF:_UDF_553648231 DESC=\"\">Yes</UDF:_UDF_553648231>" + 
  				"      </UDF:_UDF_553648231.LIST>" + 
  				"      <UDF:_UDF_553676630.LIST DESC=\"\" ISLIST=\"YES\" TYPE=\"Logical\" INDEX=\"28501\">" + 
  				"       <UDF:_UDF_553676630 DESC=\"\">Yes</UDF:_UDF_553676630>" + 
  				"      </UDF:_UDF_553676630.LIST>" + 
  				"      <UDF:ISUSEFOREXCISE.LIST DESC=\"`IsUseforExcise`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"15124\">" + 
  				"       <UDF:ISUSEFOREXCISE DESC=\"`IsUseforExcise`\">No</UDF:ISUSEFOREXCISE>" + 
  				"      </UDF:ISUSEFOREXCISE.LIST>" + 
  				"     </VOUCHERTYPE>" + 
  				
  				
  				
  				
  				
  				"     <VOUCHER REMOTEID=\"fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00030557-"+ib.getInvoiceno()+"\" VCHKEY=\"fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000a9d6:00000048\" VCHTYPE=\"Sales\" ACTION=\"Create\" OBJVIEW=\"Invoice Voucher View\">" + 
  				"      <ADDRESS.LIST TYPE=\"String\">" + 
  				"       <ADDRESS>"+ib.getAddress1()+"</ADDRESS>" + 
   				"      </ADDRESS.LIST>" + 
  				"      <BASICBUYERADDRESS.LIST TYPE=\"String\">" + 
  				"       <BASICBUYERADDRESS>"+ib.getAddress1()+"</BASICBUYERADDRESS>" + 
  				"      </BASICBUYERADDRESS.LIST>" + 
  				"      <BASICORDERTERMS.LIST TYPE=\"String\">" + 
  				"       <BASICORDERTERMS>FOR</BASICORDERTERMS>" + 
  				"      </BASICORDERTERMS.LIST>" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <DATE>"+date+"</DATE>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00030557</GUID>" + 
  				"      <STATENAME>"+ib.getState1()+"</STATENAME>" + 
  				"      <PRICELEVEL>"+ib.getCustomer_name1()+"</PRICELEVEL>" + 
  				"      <COUNTRYOFRESIDENCE>India</COUNTRYOFRESIDENCE>" + 
  				"      <PARTYGSTIN>"+ib.getVat007()+"</PARTYGSTIN>" + 
  				"      <PARTYNAME>"+ib.getCustomer_name1()+"</PARTYNAME>" + 
  				"      <VOUCHERTYPENAME>Sales</VOUCHERTYPENAME>" + 
  				"      <REFERENCE>"+ib.getInvoiceno()+"</REFERENCE>" + 
  				"      <VOUCHERNUMBER>"+ib.getInvoiceno()+"</VOUCHERNUMBER>" + 
  				"      <PARTYLEDGERNAME>"+ib.getCustomer_name1()+"</PARTYLEDGERNAME>" + 
  				"      <BASICBASEPARTYNAME>"+ib.getCustomer_name1()+"</BASICBASEPARTYNAME>" + 
  				"      <CSTFORMISSUETYPE/>" + 
  				"      <CSTFORMRECVTYPE/>" + 
  				"      <CONSIGNEECSTNUMBER></CONSIGNEECSTNUMBER>" + 
  				"      <BUYERSCSTNUMBER></BUYERSCSTNUMBER>" + 
  				"      <FBTPAYMENTTYPE>Default</FBTPAYMENTTYPE>" + 
  				"      <PERSISTEDVIEW>Invoice Voucher View</PERSISTEDVIEW>" + 
  				"      <PLACEOFSUPPLY>"+ib.getState1()+"</PLACEOFSUPPLY>" + 
  				"      <CONSIGNEEGSTIN>"+ib.getVat007()+"</CONSIGNEEGSTIN>" + 
  				"      <BASICSHIPPEDBY>"+ib.getVehino()+"</BASICSHIPPEDBY>" + 
  				"      <BASICBUYERNAME>"+ib.getCustomer_name1()+"</BASICBUYERNAME>" + 
  				"      <BASICDATETIMEOFINVOICE></BASICDATETIMEOFINVOICE>" + 
  				"      <BASICDATETIMEOFREMOVAL></BASICDATETIMEOFREMOVAL>" + 
  				"      <VCHGSTCLASS/>" + 
  				"      <CONSIGNEESTATENAME>"+ib.getState1()+"</CONSIGNEESTATENAME>" + 
  				"      <ENTEREDBY>kumar</ENTEREDBY>" + 
  				"      <DIFFACTUALQTY>No</DIFFACTUALQTY>" + 
  				"      <ISMSTFROMSYNC>No</ISMSTFROMSYNC>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <FORJOBCOSTING>No</FORJOBCOSTING>" + 
  				"      <ISOPTIONAL>No</ISOPTIONAL>" + 
  				"      <EFFECTIVEDATE>"+date+"</EFFECTIVEDATE>" + 
  				"      <USEFOREXCISE>No</USEFOREXCISE>" + 
  				"      <ISFORJOBWORKIN>No</ISFORJOBWORKIN>" + 
  				"      <ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>" + 
  				"      <USEFORINTEREST>No</USEFORINTEREST>" + 
  				"      <USEFORGAINLOSS>No</USEFORGAINLOSS>" + 
  				"      <USEFORGODOWNTRANSFER>No</USEFORGODOWNTRANSFER>" + 
  				"      <USEFORCOMPOUND>No</USEFORCOMPOUND>" + 
  				"      <USEFORSERVICETAX>No</USEFORSERVICETAX>" + 
  				"      <ISEXCISEVOUCHER>No</ISEXCISEVOUCHER>" + 
  				"      <EXCISETAXOVERRIDE>No</EXCISETAXOVERRIDE>" + 
  				"      <USEFORTAXUNITTRANSFER>No</USEFORTAXUNITTRANSFER>" + 
  				"      <IGNOREPOSVALIDATION>No</IGNOREPOSVALIDATION>" + 
  				"      <EXCISEOPENING>No</EXCISEOPENING>" + 
  				"      <USEFORFINALPRODUCTION>No</USEFORFINALPRODUCTION>" + 
  				"      <ISTDSOVERRIDDEN>No</ISTDSOVERRIDDEN>" + 
  				"      <ISTCSOVERRIDDEN>No</ISTCSOVERRIDDEN>" + 
  				"      <ISTDSTCSCASHVCH>No</ISTDSTCSCASHVCH>" + 
  				"      <INCLUDEADVPYMTVCH>No</INCLUDEADVPYMTVCH>" + 
  				"      <ISSUBWORKSCONTRACT>No</ISSUBWORKSCONTRACT>" + 
  				"      <ISVATOVERRIDDEN>No</ISVATOVERRIDDEN>" + 
  				"      <IGNOREORIGVCHDATE>No</IGNOREORIGVCHDATE>" + 
  				"      <ISVATPAIDATCUSTOMS>No</ISVATPAIDATCUSTOMS>" + 
  				"      <ISDECLAREDTOCUSTOMS>No</ISDECLAREDTOCUSTOMS>" + 
  				"      <ISSERVICETAXOVERRIDDEN>No</ISSERVICETAXOVERRIDDEN>" + 
  				"      <ISISDVOUCHER>No</ISISDVOUCHER>" + 
  				"      <ISEXCISEOVERRIDDEN>No</ISEXCISEOVERRIDDEN>" + 
  				"      <ISEXCISESUPPLYVCH>No</ISEXCISESUPPLYVCH>" + 
  				"      <ISGSTOVERRIDDEN>No</ISGSTOVERRIDDEN>" + 
  				"      <GSTNOTEXPORTED>No</GSTNOTEXPORTED>" + 
  				"      <IGNOREGSTINVALIDATION>No</IGNOREGSTINVALIDATION>" + 
  				"      <ISVATPRINCIPALACCOUNT>No</ISVATPRINCIPALACCOUNT>" + 
  				"      <ISBOENOTAPPLICABLE>No</ISBOENOTAPPLICABLE>" + 
  				"      <ISSHIPPINGWITHINSTATE>No</ISSHIPPINGWITHINSTATE>" + 
  				"      <ISOVERSEASTOURISTTRANS>No</ISOVERSEASTOURISTTRANS>" + 
  				"      <ISDESIGNATEDZONEPARTY>No</ISDESIGNATEDZONEPARTY>" + 
  				"      <ISCANCELLED>No</ISCANCELLED>" + 
  				"      <HASCASHFLOW>No</HASCASHFLOW>" + 
  				"      <ISPOSTDATED>No</ISPOSTDATED>" + 
  				"      <USETRACKINGNUMBER>No</USETRACKINGNUMBER>" + 
  				"      <ISINVOICE>Yes</ISINVOICE>" + 
  				"      <MFGJOURNAL>No</MFGJOURNAL>" + 
  				"      <HASDISCOUNTS>Yes</HASDISCOUNTS>" + 
  				"      <ASPAYSLIP>No</ASPAYSLIP>" + 
  				"      <ISCOSTCENTRE>No</ISCOSTCENTRE>" + 
  				"      <ISSTXNONREALIZEDVCH>No</ISSTXNONREALIZEDVCH>" + 
  				"      <ISEXCISEMANUFACTURERON>No</ISEXCISEMANUFACTURERON>" + 
  				"      <ISBLANKCHEQUE>No</ISBLANKCHEQUE>" + 
  				"      <ISVOID>No</ISVOID>" + 
  				"      <ISONHOLD>No</ISONHOLD>" + 
  				"      <ORDERLINESTATUS>No</ORDERLINESTATUS>" + 
  				"      <VATISAGNSTCANCSALES>No</VATISAGNSTCANCSALES>" + 
  				"      <VATISPURCEXEMPTED>No</VATISPURCEXEMPTED>" + 
  				"      <ISVATRESTAXINVOICE>No</ISVATRESTAXINVOICE>" + 
  				"      <VATISASSESABLECALCVCH>No</VATISASSESABLECALCVCH>" + 
  				"      <ISVATDUTYPAID>Yes</ISVATDUTYPAID>" + 
  				"      <ISDELIVERYSAMEASCONSIGNEE>No</ISDELIVERYSAMEASCONSIGNEE>" + 
  				"      <ISDISPATCHSAMEASCONSIGNOR>No</ISDISPATCHSAMEASCONSIGNOR>" + 
  				"      <ISDELETED>No</ISDELETED>" + 
  				"      <CHANGEVCHMODE>No</CHANGEVCHMODE>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <MASTERID> 197975</MASTERID>" + 
  				"      <VOUCHERKEY>"+ib.getInvoiceno()+"</VOUCHERKEY>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <DUTYHEADDETAILS.LIST>      </DUTYHEADDETAILS.LIST>" + 
  				"      <SUPPLEMENTARYDUTYHEADDETAILS.LIST>      </SUPPLEMENTARYDUTYHEADDETAILS.LIST>" + 
  				"      <EWAYBILLDETAILS.LIST>      </EWAYBILLDETAILS.LIST>" + 
  				"      <INVOICEDELNOTES.LIST>" + 
  				"       <BASICSHIPPINGDATE>"+date+"</BASICSHIPPINGDATE>" + 
  				"       <BASICSHIPDELIVERYNOTE>"+ib.getInvoiceno()+"</BASICSHIPDELIVERYNOTE>" + 
  				"      </INVOICEDELNOTES.LIST>" + 
  				"      <INVOICEORDERLIST.LIST>" + 
  				"       <BASICORDERDATE>"+date+"</BASICORDERDATE>" + 
  				"       <BASICPURCHASEORDERNO>"+ib.getInvoiceno()+"</BASICPURCHASEORDERNO>" + 
  				"      </INVOICEORDERLIST.LIST>" + 
  				"      <INVOICEINDENTLIST.LIST>      </INVOICEINDENTLIST.LIST>" + 
  				"      <ATTENDANCEENTRIES.LIST>      </ATTENDANCEENTRIES.LIST>" + 
  				"      <ORIGINVOICEDETAILS.LIST>      </ORIGINVOICEDETAILS.LIST>" + 
  				"      <INVOICEEXPORTLIST.LIST>      </INVOICEEXPORTLIST.LIST>" + 
  				"      <LEDGERENTRIES.LIST>" + 
  				"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"       </OLDAUDITENTRYIDS.LIST>" + 
  				"       <LEDGERNAME>"+ib.getCustomer_name1()+"</LEDGERNAME>" + 
  				"       <GSTCLASS/>" + 
  				"       <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"       <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  				"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  				"       <ISPARTYLEDGER>Yes</ISPARTYLEDGER>" + 
  				"       <ISLASTDEEMEDPOSITIVE>Yes</ISLASTDEEMEDPOSITIVE>" + 
  				"       <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  				"       <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  				"       <AMOUNT>-"+ib.getTamount()+"</AMOUNT>" + 
  				"       <SERVICETAXDETAILS.LIST>       </SERVICETAXDETAILS.LIST>" + 
  				"       <BANKALLOCATIONS.LIST>       </BANKALLOCATIONS.LIST>" + 
  				"       <BILLALLOCATIONS.LIST>" + 
  				"        <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"        <BILLTYPE>New Ref</BILLTYPE>" + 
  				"        <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"        <AMOUNT>-"+ib.getTamount()+"</AMOUNT>" + 
  				"        <INTERESTCOLLECTION.LIST>        </INTERESTCOLLECTION.LIST>" + 
  				"        <STBILLCATEGORIES.LIST>        </STBILLCATEGORIES.LIST>" + 
  				"       </BILLALLOCATIONS.LIST>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"       <OLDAUDITENTRIES.LIST>       </OLDAUDITENTRIES.LIST>" + 
  				"       <ACCOUNTAUDITENTRIES.LIST>       </ACCOUNTAUDITENTRIES.LIST>" + 
  				"       <AUDITENTRIES.LIST>       </AUDITENTRIES.LIST>" + 
  				"       <INPUTCRALLOCS.LIST>       </INPUTCRALLOCS.LIST>" + 
  				"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  				"       <EXCISEDUTYHEADDETAILS.LIST>       </EXCISEDUTYHEADDETAILS.LIST>" + 
  				"       <RATEDETAILS.LIST>       </RATEDETAILS.LIST>" + 
  				"       <SUMMARYALLOCS.LIST>       </SUMMARYALLOCS.LIST>" + 
  				"       <STPYMTDETAILS.LIST>       </STPYMTDETAILS.LIST>" + 
  				"       <EXCISEPAYMENTALLOCATIONS.LIST>       </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  				"       <TAXBILLALLOCATIONS.LIST>       </TAXBILLALLOCATIONS.LIST>" + 
  				"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  				"       <TDSEXPENSEALLOCATIONS.LIST>       </TDSEXPENSEALLOCATIONS.LIST>" + 
  				"       <VATSTATUTORYDETAILS.LIST>       </VATSTATUTORYDETAILS.LIST>" + 
  				"       <COSTTRACKALLOCATIONS.LIST>       </COSTTRACKALLOCATIONS.LIST>" + 
  				"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  				"       <INVOICEWISEDETAILS.LIST>       </INVOICEWISEDETAILS.LIST>" + 
  				"       <VATITCDETAILS.LIST>       </VATITCDETAILS.LIST>" + 
  				"       <ADVANCETAXDETAILS.LIST>       </ADVANCETAXDETAILS.LIST>" + 
  				"      </LEDGERENTRIES.LIST>" + 
  				
  				
  				
  				
  				abc+
  				
  				
  				"      <LEDGERENTRIES.LIST>" + 
  				"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"       </OLDAUDITENTRYIDS.LIST>" + 
  				"       <LEDGERNAME>Amount Rounded Off</LEDGERNAME>" + 
  				"       <GSTCLASS/>" + 
  				"       <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"       <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  				"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  				"       <ISPARTYLEDGER>No</ISPARTYLEDGER>" + 
  				"       <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  				"       <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  				"       <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  				"       <AMOUNT>0.115</AMOUNT>" + 
  				"       <VATEXPAMOUNT>0.115</VATEXPAMOUNT>" + 
  				"       <SERVICETAXDETAILS.LIST>       </SERVICETAXDETAILS.LIST>" + 
  				"       <BANKALLOCATIONS.LIST>       </BANKALLOCATIONS.LIST>" + 
  				"       <BILLALLOCATIONS.LIST>       </BILLALLOCATIONS.LIST>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"       <OLDAUDITENTRIES.LIST>       </OLDAUDITENTRIES.LIST>" + 
  				"       <ACCOUNTAUDITENTRIES.LIST>       </ACCOUNTAUDITENTRIES.LIST>" + 
  				"       <AUDITENTRIES.LIST>       </AUDITENTRIES.LIST>" + 
  				"       <INPUTCRALLOCS.LIST>       </INPUTCRALLOCS.LIST>" + 
  				"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  				"       <EXCISEDUTYHEADDETAILS.LIST>       </EXCISEDUTYHEADDETAILS.LIST>" + 
  				"       <RATEDETAILS.LIST>       </RATEDETAILS.LIST>" + 
  				"       <SUMMARYALLOCS.LIST>       </SUMMARYALLOCS.LIST>" + 
  				"       <STPYMTDETAILS.LIST>       </STPYMTDETAILS.LIST>" + 
  				"       <EXCISEPAYMENTALLOCATIONS.LIST>       </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  				"       <TAXBILLALLOCATIONS.LIST>       </TAXBILLALLOCATIONS.LIST>" + 
  				"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  				"       <TDSEXPENSEALLOCATIONS.LIST>       </TDSEXPENSEALLOCATIONS.LIST>" + 
  				"       <VATSTATUTORYDETAILS.LIST>       </VATSTATUTORYDETAILS.LIST>" + 
  				"       <COSTTRACKALLOCATIONS.LIST>       </COSTTRACKALLOCATIONS.LIST>" + 
  				"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  				"       <INVOICEWISEDETAILS.LIST>       </INVOICEWISEDETAILS.LIST>" + 
  				"       <VATITCDETAILS.LIST>       </VATITCDETAILS.LIST>" + 
  				"       <ADVANCETAXDETAILS.LIST>       </ADVANCETAXDETAILS.LIST>" + 
  				"      </LEDGERENTRIES.LIST>"+ 
  				
  				
  				st+
  				
  					
  				"      <PAYROLLMODEOFPAYMENT.LIST>      </PAYROLLMODEOFPAYMENT.LIST>" + 
  				"      <ATTDRECORDS.LIST>      </ATTDRECORDS.LIST>" + 
  				"      <GSTEWAYCONSIGNORADDRESS.LIST>      </GSTEWAYCONSIGNORADDRESS.LIST>" + 
  				"      <GSTEWAYCONSIGNEEADDRESS.LIST>      </GSTEWAYCONSIGNEEADDRESS.LIST>" + 
  				"      <TEMPGSTRATEDETAILS.LIST>      </TEMPGSTRATEDETAILS.LIST>" + 
  				"      <UDF:VAAPPROVEDBY.LIST DESC=\"`VAApprovedBy`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"211\">" + 
  				"       <UDF:VAAPPROVEDBY DESC=\"`VAApprovedBy`\">kumar</UDF:VAAPPROVEDBY>" + 
  				"      </UDF:VAAPPROVEDBY.LIST>" + 
  				"      <UDF:VCREMARKS.LIST DESC=\"`VCRemarks`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"215\">" + 
  				"       <UDF:VCREMARKS DESC=\"`VCRemarks`\">Approved</UDF:VCREMARKS>" + 
  				"      </UDF:VCREMARKS.LIST>" + 
  				"     </VOUCHER>" + 
  				"    </TALLYMESSAGE>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				"     <COMPANY>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>fe3dda4e-0caf-40d4-aded-cd9acef4ead5</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods ERP Demo</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>23468eb0-6cc0-4915-8193-fa84b280316c</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>ef15fbb2-364b-49e3-ba21-80170e8028a0</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"     </COMPANY>" + 
  				"    </TALLYMESSAGE>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				"     <COMPANY>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>fe3dda4e-0caf-40d4-aded-cd9acef4ead5</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods ERP Demo</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>23468eb0-6cc0-4915-8193-fa84b280316c</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>ef15fbb2-364b-49e3-ba21-80170e8028a0</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"     </COMPANY>" + 
  				"    </TALLYMESSAGE>" + 
  				"   </REQUESTDATA>" + 
  				"  </IMPORTDATA>" + 
  				" </BODY>" + 
  				"</ENVELOPE>" ; 
                       
   

	System.out.println("XMLM::"+TXML);
	
	
	DBConnection.closeConnection();

    return TXML;
    

}*/

public String CreateRequest(invoicebean1 ib) throws SQLException {
	 

	//System.out.println("hello"); 
   String TXML = null;
   
   
   
   Connection conn=connection.getConnection();

   PreparedStatement preparedStatementx = conn
  			.prepareStatement("select * from destributor_master where destributor_id='"
  					+ ib.getCustomer_Id() + "'");

  			ResultSet resultSetx = preparedStatementx.executeQuery();
  			//System.out.println("ddddd"+preparedStatementx);
  			if (resultSetx.next()) {
  				
  				
  					ib.setCustomer_name1(resultSetx.getString("name"));
  					
  					ib.setAddress1(resultSetx.getString("address"));
  					ib.setVat007(resultSetx.getString("gstn"));
  					ib.setState1(resultSetx.getString("state"));
  					ib.setPincode(resultSetx.getString("pincode"));
  					ib.setEmail(resultSetx.getString("email"));
      
      
  			}
   
   
   
  			String date=CoreData.getDateFormatAsDb(ib.getDate());
  		   	date=date.replaceAll("-", "");
  		       
  		       Double amtwithouttax=0.0;
  		       String stockitem="";
  		       String tax11="";
  		       
  		     String cgstrate="";
  		     String sgstrate="";
  		       
  		       
  		       String inventory="";
  		       Double ocgst=0.0;
  		       Double osgst=0.0;
  		      
  		       for (int j1 = 0; j1 < ib.getAmount1().length; j1++) {
  		    	  
  		    	
  		    	  String desc=ib.getDescription1()[j1].replaceAll("&", "&amp;");
  		    	  
  		    	  //String unit=ib.getUnit1()[j1];

  		    		if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
  		    			String ttype="";
  		    			tax11=ib.getVat1()[j1];
  		    			
  		    			cgstrate=ib.getGrate1()[j1];
  		    			sgstrate=ib.getGrate2()[j1];
  		    			
  		    			
  		    			try{
  		    			amtwithouttax=amtwithouttax+Double.parseDouble(ib.getAmount1()[j1]);
  		    			}catch(Exception e){}
  		    			
  		    			try{
  		    				ocgst=ocgst+Double.parseDouble(ib.getGstamount1()[j1]);
  			    			}catch(Exception e){}
  			    			
  		    			
  		    			try{
  		    				osgst=osgst+Double.parseDouble(ib.getGstamount2()[j1]);
  			    			}catch(Exception e){}
  			    			
  		    			
  		    			try {
  							ttype = ib.getTtype()[j1];
  						} catch (Exception e) {
  							// TODO: handle exception
  							ttype = "";
  						}
			

			  System.out.println(">>>>"+desc);
  		    			stockitem+="  <STOCKITEM NAME=\""+desc+"\" RESERVEDNAME=\"\">" + 
  		    					"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		    					"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		    					"      </OLDAUDITENTRYIDS.LIST>" + 
  		    					"      <GUID>dbda3fe1-e516-4616-9b81-939d974dd35b-000089eb</GUID>" + 
  		    					"      <PARENT></PARENT>" + 
  		    					"      <CATEGORY/>" + 
  		    					"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		    					"      <TAXCLASSIFICATIONNAME/>" + 
  		    					"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		    					"      <EXCISEAPPLICABILITY>&#4; Applicable</EXCISEAPPLICABILITY>" + 
  		    					"      <SALESTAXCESSAPPLICABLE/>" + 
  		    					"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		    					"      <COSTINGMETHOD>FIFO</COSTINGMETHOD>" + 
  		    					"      <VALUATIONMETHOD>Avg. Price</VALUATIONMETHOD>" + 
  		    					"      <BASEUNITS></BASEUNITS>" + 
  		    					"      <ADDITIONALUNITS/>" + 
  		    					"      <EXCISEITEMCLASSIFICATION/>" + 
  		    					"      <VATBASEUNIT></VATBASEUNIT>" + 
  		    					"      <GSTREPUOM></GSTREPUOM>" + 
  		    					"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		    					"      <ISBATCHWISEON>Yes</ISBATCHWISEON>" + 
  		    					"      <ISPERISHABLEON>No</ISPERISHABLEON>" + 
  		    					"      <ISENTRYTAXAPPLICABLE>No</ISENTRYTAXAPPLICABLE>" + 
/*  		    					"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
*/  		    					"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		    					"      <ASORIGINAL>No</ASORIGINAL>" + 
  		    					"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		    					"      <IGNOREPHYSICALDIFFERENCE>No</IGNOREPHYSICALDIFFERENCE>" + 
  		    					"      <IGNORENEGATIVESTOCK>No</IGNORENEGATIVESTOCK>" + 
  		    					"      <TREATSALESASMANUFACTURED>No</TREATSALESASMANUFACTURED>" + 
  		    					"      <TREATPURCHASESASCONSUMED>No</TREATPURCHASESASCONSUMED>" + 
  		    					"      <TREATREJECTSASSCRAP>No</TREATREJECTSASSCRAP>" + 
  		    					"      <HASMFGDATE>No</HASMFGDATE>" + 
  		    					"      <ALLOWUSEOFEXPIREDITEMS>No</ALLOWUSEOFEXPIREDITEMS>" + 
  		    					"      <IGNOREBATCHES>No</IGNOREBATCHES>" + 
  		    					"      <IGNOREGODOWNS>No</IGNOREGODOWNS>" + 
  		    					"      <CALCONMRP>No</CALCONMRP>" + 
  		    					"      <EXCLUDEJRNLFORVALUATION>No</EXCLUDEJRNLFORVALUATION>" + 
  		    					"      <ISMRPINCLOFTAX>No</ISMRPINCLOFTAX>" + 
  		    					"      <ISADDLTAXEXEMPT>No</ISADDLTAXEXEMPT>" + 
  		    					"      <ISSUPPLEMENTRYDUTYON>No</ISSUPPLEMENTRYDUTYON>" + 
  		    					"      <GVATISEXCISEAPPL>No</GVATISEXCISEAPPL>" + 
  		    					"      <REORDERASHIGHER>No</REORDERASHIGHER>" + 
  		    					"      <MINORDERASHIGHER>No</MINORDERASHIGHER>" + 
  		    					"      <ISEXCISECALCULATEONMRP>No</ISEXCISECALCULATEONMRP>" + 
  		    					"      <INCLUSIVETAX>No</INCLUSIVETAX>" + 
  		    					"      <GSTCALCSLABONMRP>No</GSTCALCSLABONMRP>" + 
  		    					"      <MODIFYMRPRATE>No</MODIFYMRPRATE>" + 
  		    					"      <ALTERID> 1244566</ALTERID>" + 
  		    					"      <DENOMINATOR> 1</DENOMINATOR>" + 
  		    					"      <RATEOFVAT>0</RATEOFVAT>" + 
  		    					"      <VATBASENO> 1</VATBASENO>" + 
  		    					"      <VATTRAILNO> 1</VATTRAILNO>" + 
  		    					"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		    					"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		    					"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		    					"      <GSTDETAILS.LIST>" + 
  		    					"       <APPLICABLEFROM>"+date+"</APPLICABLEFROM>" + 
  		    					"       <CALCULATIONTYPE>On Value</CALCULATIONTYPE>" + 
  		    					"       <HSNCODE>"+ttype+"</HSNCODE>" + 
  		    					"       <HSNMASTERNAME/>" + 
  		    					"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		    					"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		    					"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		    					"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		    					"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		    					"       <STATEWISEDETAILS.LIST>" + 
  		    					"        <STATENAME>&#4; Any</STATENAME>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE> "+cgstrate+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE>"+sgstrate+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"         <GSTRATE> "+tax11+"</GSTRATE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <RATEDETAILS.LIST>" + 
  		    					"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		    					"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		    					"        </RATEDETAILS.LIST>" + 
  		    					"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		    					"       </STATEWISEDETAILS.LIST>" + 
  		    					"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		    					"      </GSTDETAILS.LIST>" + 
  		    					
  		    					"      <LANGUAGENAME.LIST>" + 
  		    					"       <NAME.LIST TYPE=\"String\">" + 
  		    					"        <NAME>"+desc+"</NAME>" + 
  		    					"       </NAME.LIST>" + 
  		    					"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		    					"      </LANGUAGENAME.LIST>" + 
  		    					"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		    					"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		    					"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		    					"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		    					"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		    					"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		    					"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		    					"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		    					"      <MRPDETAILS.LIST>      </MRPDETAILS.LIST>" + 
  		    					"      <VATCLASSIFICATIONDETAILS.LIST>      </VATCLASSIFICATIONDETAILS.LIST>" + 
  		    					"      <COMPONENTLIST.LIST>      </COMPONENTLIST.LIST>" + 
  		    					"      <ADDITIONALLEDGERS.LIST>      </ADDITIONALLEDGERS.LIST>" + 
  		    					"      <SALESLIST.LIST>      </SALESLIST.LIST>" + 
  		    					"      <PURCHASELIST.LIST>      </PURCHASELIST.LIST>" + 
  		    				
  		    	  				
  		    	  				"      <BATCHALLOCATIONS.LIST>      </BATCHALLOCATIONS.LIST>" + 
  		    	  				"      <TRADEREXCISEDUTIES.LIST>      </TRADEREXCISEDUTIES.LIST>" + 
  		    	  				"      <STANDARDCOSTLIST.LIST>      </STANDARDCOSTLIST.LIST>" + 
  		    	  				"      <STANDARDPRICELIST.LIST>      </STANDARDPRICELIST.LIST>" + 
  		    	  				"      <EXCISEITEMGODOWN.LIST>      </EXCISEITEMGODOWN.LIST>" + 
  		    	  				"      <MULTICOMPONENTLIST.LIST>      </MULTICOMPONENTLIST.LIST>" + 
  		    	  				"      <LBTDETAILS.LIST>      </LBTDETAILS.LIST>" + 
  		    	  				"      <PRICELEVELLIST.LIST>      </PRICELEVELLIST.LIST>" + 
  		    	  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		    	  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		    	  				"      <TEMPGSTITEMSLABRATES.LIST>      </TEMPGSTITEMSLABRATES.LIST>" + 
  		    	  				"     </STOCKITEM>" ;
  		    	  				

	
	 
		}
	 
		}
  
  		       
  		       
  
  		    PreparedStatement preparedStatement112zz = conn.prepareStatement("select * from invoice_hsn_details where invoiceno='"+ib.getInvoiceno()+"'    ");
  			System.out.println("preparedStatement112"+preparedStatement112zz);
  		ResultSet resultSet12zz = preparedStatement112zz.executeQuery();
  		String taxxml="";
  		
  		String abc="";
  		String st="";
  		int hhh=0;
  		Double amtwtax=0.0;
  		while (resultSet12zz.next()) {
  			String tax="";
  			
  			String taxx="";
  			String tax1="";
  			
  			String tax3="";
  			
  			String tax2="";
  			ocgst=0.0;
  			osgst=0.0;
  			amtwithouttax=0.0;
  			try{
  				if(resultSet12zz.getString("rate").endsWith("18.00")){
  			 tax="18%";
  			 tax1="9%";
  			 taxx="18";
  			 tax2="9";
  			tax3="18";
  				}
  				
  				if(resultSet12zz.getString("rate").endsWith("28.00")){
  					 tax="28%";
  					 tax1="14%";
  					 taxx="28";
  					tax2="14";
  					tax3="28";
  						}
  				
  				if(resultSet12zz.getString("rate").endsWith("12.00")){
 					 tax="12%";
 					 tax1="6%";
 					 taxx="12";
 					tax2="6";
 					tax3="12";
 						}
  				
  				 amtwithouttax=Double.parseDouble(resultSet12zz.getString("taxablevalue"));
  				 ocgst=ocgst+Double.parseDouble(resultSet12zz.getString("cgstamount"));
  				 osgst=osgst+Double.parseDouble(resultSet12zz.getString("sgstamount"));
  				 ocgst=Math.round(ocgst * 100.0) / 100.0;
  				 osgst=Math.round(osgst * 100.0) / 100.0;
  				 amtwithouttax=Math.round(amtwithouttax * 100.0) / 100.0;
  				 
  				 amtwtax=amtwtax+(amtwithouttax+ocgst+osgst);
  				 System.out.println(amtwithouttax+"MM>>>>>>"+ocgst+"NN>>>>>>"+osgst);
  			}catch(Exception e){   System.out.println(e.getMessage());  }
  			
  			
  			PreparedStatement preparedStatement112zz1 = conn.prepareStatement("select * from invoice_tax_details where invoice_no='"+ib.getInvoiceno()+"' and vat_percent='"+taxx+"' and type_name='"+resultSet12zz.getString("hsncode")+"'   ");
  			System.out.println("preparedStatement112"+preparedStatement112zz1);
  		ResultSet resultSet12zz1 = preparedStatement112zz1.executeQuery();
  		
  		while (resultSet12zz1.next()) {
  			String tttt="";
  			String unit="";
  			String disc="";
  			String qty="";
  			String amt="";
  			String rate="";
  			String batch="";
  			String invoice_no="";
  			
  			String totaltax="";
  			
  			
  			
  			
  			
  			
  			
  			
  			String totaltaxamt="";
  			
  			try{
  				tttt=resultSet12zz1.getString("descrip").replaceAll("&", "&amp;");
  				 
  			//	unit=resultSet12zz1.getString("unit");
  				 qty=resultSet12zz1.getString("qty");
  				 disc=resultSet12zz1.getString("disc");
  				 
  				 rate=resultSet12zz1.getString("rate");
  				 
  				 amt=resultSet12zz1.getString("net_amt");
  				 
  				batch=resultSet12zz1.getString("batch");
  				 
  				 invoice_no=resultSet12zz1.getString("invoice_no");
  				 
  				totaltax=resultSet12zz1.getString("vat_percent");
  				 
  				//System.out.println(amtwithouttax+"MM>>>>>>"+totaltax+"NN>>>>>>"+totaltax);
  			
  			}catch(Exception e){}
  			
  			//System.out.println(">>>>>>>>"+amt);
  			
  			System.out.println("Rate::"+rate);
  			System.out.println("Disc::"+disc);
  			System.out.println("Qty::"+qty);
  			
  			st   +="<ALLINVENTORYENTRIES.LIST>" + 
  					"       <STOCKITEMNAME>"+tttt+"</STOCKITEMNAME>" + 
  					"       <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  					"       <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  					"       <ISAUTONEGATE>No</ISAUTONEGATE>" + 
  					"       <ISCUSTOMSCLEARANCE>No</ISCUSTOMSCLEARANCE>" + 
/*  					"       <ISTRACKCOMPONENT>No</ISTRACKCOMPONENT>" + 
*/  					"       <ISTRACKPRODUCTION>No</ISTRACKPRODUCTION>" + 
  					"       <ISPRIMARYITEM>No</ISPRIMARYITEM>" + 
  					"       <ISSCRAP>No</ISSCRAP>" + 
  					"       <RATE>"+rate+"</RATE>" + 
  					"       <DISCOUNT> "+disc+"</DISCOUNT>" + 
  					"       <AMOUNT>"+amt+"</AMOUNT>" + 
  					"       <ACTUALQTY> "+qty+"</ACTUALQTY>" + 
  					"       <BILLEDQTY> "+qty+"</BILLEDQTY>" + 
  					
  						
  					"       <BATCHALLOCATIONS.LIST>" + 
  					"        <GODOWNNAME>Main Location</GODOWNNAME>" + 
  					"        <BATCHNAME>"+batch+"</BATCHNAME>" + 
  					"        <DESTINATIONGODOWNNAME>Main Location</DESTINATIONGODOWNNAME>" + 
  					"        <INDENTNO/>" + 
  					"        <ORDERNO>"+ib.getOrder_id()+"</ORDERNO>" + 
/*  					"        <TRACKINGNUMBER>"+ib.getOrder_id()+"</TRACKINGNUMBER>" + 
*/  					"        <DYNAMICCSTISCLEARED>No</DYNAMICCSTISCLEARED>" + 
  					"        <AMOUNT>"+amt+"</AMOUNT>" + 
  					"        <ACTUALQTY> "+qty+"</ACTUALQTY>" + 
  					"        <BILLEDQTY> "+qty+"</BILLEDQTY>" + 
  					"        <ORDERDUEDATE >"+date+"</ORDERDUEDATE>" + 
  					"        <ADDITIONALDETAILS.LIST>        </ADDITIONALDETAILS.LIST>" + 
  					"        <VOUCHERCOMPONENTLIST.LIST>        </VOUCHERCOMPONENTLIST.LIST>" + 
  					"       </BATCHALLOCATIONS.LIST>" + 
  					
  					"       <ACCOUNTINGALLOCATIONS.LIST>" + 
  					"        <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  					"         <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  					"        </OLDAUDITENTRYIDS.LIST>" + 
  					"        <LEDGERNAME>Sales @ "+totaltax+"% GST</LEDGERNAME>" + 
  					"        <GSTCLASS/>" + 
  					"        <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  					"        <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  					"        <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  					"        <ISPARTYLEDGER>No</ISPARTYLEDGER>" + 
  					"        <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  					"        <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  					"        <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  					"        <AMOUNT>"+amt+"</AMOUNT>" + 
  					"        <SERVICETAXDETAILS.LIST>        </SERVICETAXDETAILS.LIST>" + 
  					"        <BANKALLOCATIONS.LIST>        </BANKALLOCATIONS.LIST>" + 
  					"        <BILLALLOCATIONS.LIST>        </BILLALLOCATIONS.LIST>" + 
  					"        <INTERESTCOLLECTION.LIST>        </INTERESTCOLLECTION.LIST>" + 
  					"        <OLDAUDITENTRIES.LIST>        </OLDAUDITENTRIES.LIST>" + 
  					"        <ACCOUNTAUDITENTRIES.LIST>        </ACCOUNTAUDITENTRIES.LIST>" + 
  					"        <AUDITENTRIES.LIST>        </AUDITENTRIES.LIST>" + 
  					"        <INPUTCRALLOCS.LIST>        </INPUTCRALLOCS.LIST>" + 
  					"        <DUTYHEADDETAILS.LIST>        </DUTYHEADDETAILS.LIST>" + 
  					"        <EXCISEDUTYHEADDETAILS.LIST>        </EXCISEDUTYHEADDETAILS.LIST>" + 
  					"        <RATEDETAILS.LIST>        </RATEDETAILS.LIST>" + 
  					"        <SUMMARYALLOCS.LIST>        </SUMMARYALLOCS.LIST>" + 
  					"        <STPYMTDETAILS.LIST>        </STPYMTDETAILS.LIST>" + 
  					"        <EXCISEPAYMENTALLOCATIONS.LIST>        </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  					"        <TAXBILLALLOCATIONS.LIST>        </TAXBILLALLOCATIONS.LIST>" + 
  					"        <TAXOBJECTALLOCATIONS.LIST>        </TAXOBJECTALLOCATIONS.LIST>" + 
  					"        <TDSEXPENSEALLOCATIONS.LIST>        </TDSEXPENSEALLOCATIONS.LIST>" + 
  					"        <VATSTATUTORYDETAILS.LIST>        </VATSTATUTORYDETAILS.LIST>" + 
  					"        <COSTTRACKALLOCATIONS.LIST>        </COSTTRACKALLOCATIONS.LIST>" + 
  					"        <REFVOUCHERDETAILS.LIST>        </REFVOUCHERDETAILS.LIST>" + 
  					"        <INVOICEWISEDETAILS.LIST>        </INVOICEWISEDETAILS.LIST>" + 
  					"        <VATITCDETAILS.LIST>        </VATITCDETAILS.LIST>" + 
  					"        <ADVANCETAXDETAILS.LIST>        </ADVANCETAXDETAILS.LIST>" + 
  					"       </ACCOUNTINGALLOCATIONS.LIST>" + 
  					"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  					"       <SUPPLEMENTARYDUTYHEADDETAILS.LIST>       </SUPPLEMENTARYDUTYHEADDETAILS.LIST>" + 
  					"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  					"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  					"       <EXCISEALLOCATIONS.LIST>       </EXCISEALLOCATIONS.LIST>" + 
  					"       <EXPENSEALLOCATIONS.LIST>       </EXPENSEALLOCATIONS.LIST>" + 
  					"      </ALLINVENTORYENTRIES.LIST>";
  			
  			


}

  		
  		System.out.println(st);
  		



  		
  	} 
  		 taxxml+="<LEDGER NAME=\"Sales @ 18% GST\" RESERVEDNAME=\"\">" + 
  		  		"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		  		"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		  		"      </OLDAUDITENTRYIDS.LIST>" + 
  		  		"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  		  		"      <CREATEDDATE>20170708</CREATEDDATE>" + 
  		  		"      <ALTEREDON>20180710</ALTEREDON>" + 
  		  		"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047f3</GUID>" + 
  		/*  		"      <CURRENCYNAME></CURRENCYNAME>" + 
  		*/  		"      <PARENT>Sales Accounts</PARENT>" + 
  		  		"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		  		"      <CREATEDBY>manohar</CREATEDBY>" + 
  		  		"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  		  		"      <TAXCLASSIFICATIONNAME/>" + 
  		  		"      <TAXTYPE>Others</TAXTYPE>" + 
  		  		"      <GSTTYPE/>" + 
  		  		"      <APPROPRIATEFOR/>" + 
  		  		"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		  		"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  		  		"      <EXCISELEDGERCLASSIFICATION/>" + 
  		  		"      <EXCISEDUTYTYPE/>" + 
  		  		"      <EXCISENATUREOFPURCHASE/>" + 
  		  		"      <LEDGERFBTCATEGORY/>" + 
  		  		"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		  		"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  		  		"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		  		"      <ISINTERESTON>No</ISINTERESTON>" + 
  		  		"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  		  		"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  		  		"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  		  		"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		  		"      <ASORIGINAL>No</ASORIGINAL>" + 
  		  		"      <ISCONDENSED>No</ISCONDENSED>" + 
  		  		"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  		  		"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		  		"      <FORPAYROLL>No</FORPAYROLL>" + 
  		  		"      <ISABCENABLED>No</ISABCENABLED>" + 
  		  		"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  		  		"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  		  		"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  		  		"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  		  		"      <USEFORVAT>No</USEFORVAT>" + 
  		  		"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  		  		"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  		  		"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  		  		"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  		  		"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  		  		"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  		  		"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  		  		"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  		  		"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  		  		"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  		  		"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  		  		"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  		  		"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  		  		"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  		  		"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  		  		"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  		  		"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  		  		"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  		  		"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  		  		"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  		  		"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  		  		"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  		  		"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  		  		"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  		  		"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  		  		"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  		  		"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  		  		"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  		  		"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  		  		"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  		  		"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  		  		"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  		  		"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  		  		"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  		  		"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  		  		"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  		  		"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  		  		"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  		  		"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  		  		"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  		  		"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  		  		"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  		  		"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  		  		"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  		  		"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  		  		"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  		  		"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  		  		"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  		  		"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  		  		"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  		  		"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  		  		"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  		  		"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  		  		"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  		  		"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  		  		"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  		  		"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  		  		"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  		  		"      <HASEDDCITY>No</HASEDDCITY>" + 
  		  		"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  		  		"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  		  		"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  		  		"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  		  		"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  		  		"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  		  		"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  		  		"      <ISSCBUAE>No</ISSCBUAE>" + 
  		  		"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  		  		"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  		  		"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  		  		"      <AUDITED>No</AUDITED>" + 
  		  		"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  		  		"      <ALTERID> 118554</ALTERID>" + 
  		  		"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		  		"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  		  		"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		  		"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		  		"      <GSTDETAILS.LIST>" + 
  		  		"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  		  		"       <HSNMASTERNAME/>" + 
  		  		"       <HSN>Namkeen</HSN>" + 
  		  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		  		"       <STATEWISEDETAILS.LIST>" + 
  		  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE>9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 18</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		  		"       </STATEWISEDETAILS.LIST>" + 
  		  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		  		"      </GSTDETAILS.LIST>" + 
  		  		"      <GSTDETAILS.LIST>" + 
  		  		"       <APPLICABLEFROM>20180701</APPLICABLEFROM>" + 
  		  		"       <HSNMASTERNAME/>" + 
  		  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		  		"       <STATEWISEDETAILS.LIST>" + 
  		  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 9</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"         <GSTRATE> 18</GSTRATE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <RATEDETAILS.LIST>" + 
  		  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		  		"        </RATEDETAILS.LIST>" + 
  		  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		  		"       </STATEWISEDETAILS.LIST>" + 
  		  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		  		"      </GSTDETAILS.LIST>" + 
  		  		"      <LANGUAGENAME.LIST>" + 
  		  		"       <NAME.LIST TYPE=\"String\">" + 
  		  		"        <NAME>Sales @ 18% GST</NAME>" + 
  		  		"       </NAME.LIST>" + 
  		  		"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		  		"      </LANGUAGENAME.LIST>" + 
  		  		"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  		  		"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  		  		"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		  		"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		  		"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		  		"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		  		"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  		  		"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  		  		"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  		  		"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  		  		"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		  		"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  		  		"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  		  		"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  		  		"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  		  		"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  		  		"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  		  		"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  		  		"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		  		"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  		  		"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  		  		"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  		  		"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  		  		"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  		  		"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  		  		"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  		  		"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  		  		"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		  		"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		  		"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  		  		"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  		  		"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  		  		"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  		  		"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  		  		"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  		  		"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  		  		"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  		  		"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  		  		"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  		  		"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  		  		"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  		  		"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  		  		"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  		  		"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  		  		"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		  		"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		  		"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  		  		"     </LEDGER>";
  
  taxxml+="<LEDGER NAME=\"Sales @ 12.00% GST\" RESERVEDNAME=\"\">" + 
  		"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  		"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  		"      </OLDAUDITENTRYIDS.LIST>" + 
  		"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  		"      <CREATEDDATE>20170708</CREATEDDATE>" + 
  		"      <ALTEREDON>20180710</ALTEREDON>" + 
  		"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047f3</GUID>" + 
/*  		"      <CURRENCYNAME></CURRENCYNAME>" + 
*/  		"      <PARENT>Sales Accounts</PARENT>" + 
  		"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  		"      <CREATEDBY>manohar</CREATEDBY>" + 
  		"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  		"      <TAXCLASSIFICATIONNAME/>" + 
  		"      <TAXTYPE>Others</TAXTYPE>" + 
  		"      <GSTTYPE/>" + 
  		"      <APPROPRIATEFOR/>" + 
  		"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  		"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  		"      <EXCISELEDGERCLASSIFICATION/>" + 
  		"      <EXCISEDUTYTYPE/>" + 
  		"      <EXCISENATUREOFPURCHASE/>" + 
  		"      <LEDGERFBTCATEGORY/>" + 
  		"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  		"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  		"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  		"      <ISINTERESTON>No</ISINTERESTON>" + 
  		"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  		"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  		"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  		"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  		"      <ASORIGINAL>No</ASORIGINAL>" + 
  		"      <ISCONDENSED>No</ISCONDENSED>" + 
  		"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  		"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  		"      <FORPAYROLL>No</FORPAYROLL>" + 
  		"      <ISABCENABLED>No</ISABCENABLED>" + 
  		"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  		"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  		"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  		"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  		"      <USEFORVAT>No</USEFORVAT>" + 
  		"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  		"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  		"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  		"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  		"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  		"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  		"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  		"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  		"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  		"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  		"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  		"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  		"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  		"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  		"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  		"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  		"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  		"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  		"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  		"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  		"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  		"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  		"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  		"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  		"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  		"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  		"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  		"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  		"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  		"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  		"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  		"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  		"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  		"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  		"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  		"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  		"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  		"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  		"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  		"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  		"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  		"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  		"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  		"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  		"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  		"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  		"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  		"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  		"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  		"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  		"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  		"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  		"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  		"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  		"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  		"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  		"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  		"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  		"      <HASEDDCITY>No</HASEDDCITY>" + 
  		"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  		"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  		"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  		"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  		"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  		"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  		"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  		"      <ISSCBUAE>No</ISSCBUAE>" + 
  		"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  		"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  		"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  		"      <AUDITED>No</AUDITED>" + 
  		"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  		"      <ALTERID> 118554</ALTERID>" + 
  		"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  		"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  		"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  		"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  		"      <GSTDETAILS.LIST>" + 
  		"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  		"       <HSNMASTERNAME/>" + 
  		"       <HSN>Namkeen</HSN>" + 
  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		"       <STATEWISEDETAILS.LIST>" + 
  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 12</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		"       </STATEWISEDETAILS.LIST>" + 
  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		"      </GSTDETAILS.LIST>" + 
  		"      <GSTDETAILS.LIST>" + 
  		"       <APPLICABLEFROM>20180701</APPLICABLEFROM>" + 
  		"       <HSNMASTERNAME/>" + 
  		"       <TAXABILITY>Taxable</TAXABILITY>" + 
  		"       <GSTNATUREOFTRANSACTION>Sales Taxable</GSTNATUREOFTRANSACTION>" + 
  		"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  		"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  		"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  		"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  		"       <STATEWISEDETAILS.LIST>" + 
  		"        <STATENAME>&#4; Any</STATENAME>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 6</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"         <GSTRATE> 12</GSTRATE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <RATEDETAILS.LIST>" + 
  		"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  		"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  		"        </RATEDETAILS.LIST>" + 
  		"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  		"       </STATEWISEDETAILS.LIST>" + 
  		"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  		"      </GSTDETAILS.LIST>" + 
  		"      <LANGUAGENAME.LIST>" + 
  		"       <NAME.LIST TYPE=\"String\">" + 
  		"        <NAME>Sales @ 12.00% GST</NAME>" + 
  		"       </NAME.LIST>" + 
  		"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  		"      </LANGUAGENAME.LIST>" + 
  		"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  		"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  		"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  		"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  		"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  		"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  		"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  		"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  		"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  		"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  		"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  		"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  		"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  		"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  		"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  		"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  		"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  		"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  		"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  		"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  		"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  		"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  		"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  		"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  		"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  		"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  		"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  		"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  		"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  		"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  		"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  		"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  		"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  		"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  		"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  		"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  		"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  		"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  		"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  		"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  		"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  		"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  		"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  		"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  		"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  		"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  		"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  		"     </LEDGER>";
  

  		Double realtotal=amtwtax;
  		Double mytotal=Double.parseDouble(ib.getTamount());
  		//System.out.println("???111>>>"+realtotal);
  		//System.out.println("zczcx9>>>>"+mytotal);
  		if(Math.abs(realtotal-mytotal)<=1 && realtotal-mytotal!=0 && realtotal>mytotal){
  			
  			mytotal=mytotal+Math.abs(realtotal-mytotal);
  		}

  		if(Math.abs(realtotal-mytotal)<=1 && realtotal-mytotal!=0 && realtotal<mytotal){
  			
  		mytotal=mytotal-Math.abs(realtotal-mytotal);
  		}

  		//System.out.println("???"+realtotal);
  		//System.out.println("zczcx"+mytotal);
  		realtotal=Math.round(realtotal * 100.0) / 100.0;
  		mytotal=Math.round(mytotal * 100.0) / 100.0;
  		// ib.setTamount(""+realtotal);
  		      
  		System.out.println("Total::"+mytotal);
  

  		TXML = "<ENVELOPE>" + 
  				" <HEADER>" + 
  				"  <TALLYREQUEST>Import Data</TALLYREQUEST>" + 
  				" </HEADER>" + 
  				" <BODY>" + 
  				"  <IMPORTDATA>" + 
  				"   <REQUESTDESC>" + 
  				"    <REPORTNAME>Vouchers</REPORTNAME>" + 
  				"    <STATICVARIABLES>" + 
  				"     <SVCURRENTCOMPANY>Vasaya Foods ERP Demo</SVCURRENTCOMPANY>" + 
  				"    </STATICVARIABLES>" + 
  				"   </REQUESTDESC>" + 
  				"   <REQUESTDATA>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				
  				"     <GROUP NAME=\"Sales Accounts\" RESERVEDNAME=\"Sales Accounts\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000017</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>Yes</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>Yes</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 230</SORTPOSITION>" + 
  				"      <ALTERID> 116344</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales Accounts</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				"     <LEDGER NAME=\"Sales Tax Free - GST\" RESERVEDNAME=\"\">" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  				"      <CREATEDDATE>20170721</CREATEDDATE>" + 
  				"      <ALTEREDON>20181005</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00004816</GUID>" + 
  				/*"      <CURRENCYNAME>Ã¢â€šÂ¹</CURRENCYNAME>" + */
  				"      <VATDEALERTYPE>Regular</VATDEALERTYPE>" + 
  				"      <PARENT>Sales Accounts</PARENT>" + 
  				"      <GSTAPPLICABLE>&#4; Applicable</GSTAPPLICABLE>" + 
  				"      <CREATEDBY>manohar</CREATEDBY>" + 
  				"      <ALTEREDBY>manohar</ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <GSTTYPEOFSUPPLY>Goods</GSTTYPEOFSUPPLY>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <VATAPPLICABLE>&#4; Applicable</VATAPPLICABLE>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>Yes</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> 118585</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>" + 
  				"       <APPLICABLEFROM>20170701</APPLICABLEFROM>" + 
  				"       <HSNMASTERNAME/>" + 
  				"       <TAXABILITY>Exempt</TAXABILITY>" + 
  				"       <GSTNATUREOFTRANSACTION>Sales Exempt</GSTNATUREOFTRANSACTION>" + 
  				"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  				"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  				"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  				"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  				"       <STATEWISEDETAILS.LIST>" + 
  				"        <STATENAME>&#4; Any</STATENAME>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  				"       </STATEWISEDETAILS.LIST>" + 
  				"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  				"      </GSTDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>" + 
  				"       <APPLICABLEFROM>20180524</APPLICABLEFROM>" + 
  				"       <HSNCODE>1905</HSNCODE>" + 
  				"       <HSNMASTERNAME/>" + 
  				"       <TAXABILITY>Nil Rated</TAXABILITY>" + 
  				"       <GSTNATUREOFTRANSACTION>Sales Nil Rated</GSTNATUREOFTRANSACTION>" + 
  				"       <ISREVERSECHARGEAPPLICABLE>No</ISREVERSECHARGEAPPLICABLE>" + 
  				"       <ISNONGSTGOODS>No</ISNONGSTGOODS>" + 
  				"       <GSTINELIGIBLEITC>No</GSTINELIGIBLEITC>" + 
  				"       <INCLUDEEXPFORSLABCALC>No</INCLUDEEXPFORSLABCALC>" + 
  				"       <STATEWISEDETAILS.LIST>" + 
  				"        <STATENAME>&#4; Any</STATENAME>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Central Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>State Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Integrated Tax</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Value</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <RATEDETAILS.LIST>" + 
  				"         <GSTRATEDUTYHEAD>Cess on Qty</GSTRATEDUTYHEAD>" + 
  				"         <GSTRATEVALUATIONTYPE>Based on Quantity</GSTRATEVALUATIONTYPE>" + 
  				"        </RATEDETAILS.LIST>" + 
  				"        <GSTSLABRATES.LIST>        </GSTSLABRATES.LIST>" + 
  				"       </STATEWISEDETAILS.LIST>" + 
  				"       <TEMPGSTDETAILSLABRATES.LIST>       </TEMPGSTDETAILSLABRATES.LIST>" + 
  				"      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales Tax Free - GST</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
 				
  				stockitem+
  				
  				
 				
  				
  				
  				
  				
  				"     <GROUP NAME=\"Indirect Expenses\" RESERVEDNAME=\"Indirect Expenses\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000001c</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>Yes</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 280</SORTPOSITION>" + 
  				"      <ALTERID> 116349</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Indirect Expenses</NAME>" + 
  				"        <NAME>Expenses (Indirect)</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"ADMINSITRATIVE EXPENSES\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000aa1</GUID>" + 
  				"      <PARENT>Indirect Expenses</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116375</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>ADMINSITRATIVE EXPENSES</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Misc. Expenses\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000a4b</GUID>" + 
  				"      <PARENT>ADMINSITRATIVE EXPENSES</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116366</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Misc. Expenses</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <LEDGER NAME=\"Amount Rounded Off\" RESERVEDNAME=\"\">" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>20180401</STARTINGFROM>" + 
  				"      <CREATEDDATE>20160410</CREATEDDATE>" + 
  				"      <ALTEREDON>20141202</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000858</GUID>" + 
  				/*"      <CURRENCYNAME>Ã¢â€šÂ¹</CURRENCYNAME>" + */
  				"      <PARENT>Misc. Expenses</PARENT>" + 
  				"      <CREATEDBY>Admin</CREATEDBY>" + 
  				"      <ALTEREDBY>Admin</ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>No</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>No</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> 116480</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Amount Rounded Off</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
  				
  				
  				"     <GROUP NAME=\"Current Liabilities\" RESERVEDNAME=\"Current Liabilities\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000003</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 30</SORTPOSITION>" + 
  				"      <ALTERID> 116324</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Current Liabilities</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Duties &amp; Taxes\" RESERVEDNAME=\"Duties &amp; Taxes\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000000e</GUID>" + 
  				"      <PARENT>Current Liabilities</PARENT>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 140</SORTPOSITION>" + 
  				"      <ALTERID> 116335</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Duties &amp; Taxes</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"GST\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047db</GUID>" + 
  				"      <PARENT>Duties &amp; Taxes</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116437</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>GST</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				
  				taxxml+
  				
  				
  				
  				"     <GROUP NAME=\"Current Assets\" RESERVEDNAME=\"Current Assets\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000006</GUID>" + 
  				"      <PARENT/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>No</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 60</SORTPOSITION>" + 
  				"      <ALTERID> 116327</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Current Assets</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Sundry Debtors\" RESERVEDNAME=\"Sundry Debtors\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000014</GUID>" + 
  				"      <PARENT>Current Assets</PARENT>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>Yes</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>No</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 200</SORTPOSITION>" + 
  				"      <ALTERID> 116341</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sundry Debtors</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				"     <GROUP NAME=\"Amin Charaniya Pcmc Group\" RESERVEDNAME=\"\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000096c</GUID>" + 
  				"      <PARENT>Sundry Debtors</PARENT>" + 
  				"      <BASICGROUPISCALCULABLE>No</BASICGROUPISCALCULABLE>" + 
  				"      <ADDLALLOCTYPE/>" + 
  				"      <GRPDEBITPARENT/>" + 
  				"      <GRPCREDITPARENT/>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISADDABLE>No</ISADDABLE>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISSUBLEDGER>No</ISSUBLEDGER>" + 
  				"      <ISREVENUE>No</ISREVENUE>" + 
  				"      <AFFECTSGROSSPROFIT>No</AFFECTSGROSSPROFIT>" + 
  				"      <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"      <TRACKNEGATIVEBALANCES>Yes</TRACKNEGATIVEBALANCES>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISGROUPFORLOANRCPT>No</ISGROUPFORLOANRCPT>" + 
  				"      <ISGROUPFORLOANPYMNT>No</ISGROUPFORLOANPYMNT>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <ISINVDETAILSENABLE>No</ISINVDETAILSENABLE>" + 
  				"      <SORTPOSITION> 500</SORTPOSITION>" + 
  				"      <ALTERID> 116355</ALTERID>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Amin Charaniya Pcmc Group</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"     </GROUP>" + 
  				
  				
  				
  				
  				
  				"     <LEDGER NAME=\""+ib.getCustomer_name1()+"\" RESERVEDNAME=\"\">" + 
  				"      <ADDRESS.LIST TYPE=\"String\">" + 
  				"       <ADDRESS>"+ib.getAddress1()+"</ADDRESS>" + 
  				"      </ADDRESS.LIST>" + 
  				"      <MAILINGNAME.LIST TYPE=\"String\">" + 
  				"       <MAILINGNAME>"+ib.getCustomer_name1()+"</MAILINGNAME>" + 
  				"      </MAILINGNAME.LIST>" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <STARTINGFROM>"+date+"</STARTINGFROM>" + 
  				"      <CREATEDDATE>"+date+"</CREATEDDATE>" + 
  				"      <ALTEREDON>"+date+"</ALTEREDON>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-000047ac</GUID>" + 
  				/*"      <CURRENCYNAME>Ã¢â€šÂ¹</CURRENCYNAME>" + */
  				"      <EMAIL>"+ib.getEmail()+"</EMAIL>" + 
  				"      <PINCODE>"+ib.getPincode()+"</PINCODE>" + 
  				"      <INTERSTATESTNUMBER>"+ib.getInvoiceno()+"</INTERSTATESTNUMBER>" + 
  				"      <VATTINNUMBER>"+ib.getInvoiceno()+"</VATTINNUMBER>" + 
  				"      <COUNTRYNAME>India</COUNTRYNAME>" + 
  				"      <GSTREGISTRATIONTYPE>Regular</GSTREGISTRATIONTYPE>" + 
  				"      <VATDEALERTYPE>Regular</VATDEALERTYPE>" + 
  				"      <PRICELEVEL>"+ib.getCustomer_name1()+"</PRICELEVEL>" + 
  				"      <PARENT>Sundry Debtors</PARENT>" + 
  				"      <CREATEDBY></CREATEDBY>" + 
  				"      <ALTEREDBY></ALTEREDBY>" + 
  				"      <TAXCLASSIFICATIONNAME/>" + 
  				"      <TAXTYPE>Others</TAXTYPE>" + 
  				"      <COUNTRYOFRESIDENCE>India</COUNTRYOFRESIDENCE>" + 
  				"      <LEDADDLALLOCTYPE/>" + 
  				"      <GSTTYPE/>" + 
  				"      <APPROPRIATEFOR/>" + 
  				"      <PARTYGSTIN>"+ib.getVat007()+"</PARTYGSTIN>" + 
  				"      <GSTNATUREOFSUPPLY/>" + 
  				"      <SERVICECATEGORY>&#4; Not Applicable</SERVICECATEGORY>" + 
  				"      <EXCISELEDGERCLASSIFICATION/>" + 
  				"      <EXCISEDUTYTYPE/>" + 
  				"      <EXCISENATUREOFPURCHASE/>" + 
  				"      <LEDGERFBTCATEGORY/>" + 
  				"      <LEDSTATENAME>"+ib.getState1()+"</LEDSTATENAME>" + 
  				"      <PARTYBUSINESSSTYLE>"+ib.getCustomer_name1()+"</PARTYBUSINESSSTYLE>" + 
  				"      <ISBILLWISEON>Yes</ISBILLWISEON>" + 
  				"      <ISCOSTCENTRESON>No</ISCOSTCENTRESON>" + 
  				"      <ISINTERESTON>No</ISINTERESTON>" + 
  				"      <ALLOWINMOBILE>No</ALLOWINMOBILE>" + 
  				"      <ISCOSTTRACKINGON>No</ISCOSTTRACKINGON>" + 
  				"      <ISBENEFICIARYCODEON>No</ISBENEFICIARYCODEON>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISCONDENSED>No</ISCONDENSED>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <ISRATEINCLUSIVEVAT>No</ISRATEINCLUSIVEVAT>" + 
  				"      <FORPAYROLL>No</FORPAYROLL>" + 
  				"      <ISABCENABLED>No</ISABCENABLED>" + 
  				"      <ISCREDITDAYSCHKON>No</ISCREDITDAYSCHKON>" + 
  				"      <INTERESTONBILLWISE>No</INTERESTONBILLWISE>" + 
  				"      <OVERRIDEINTEREST>No</OVERRIDEINTEREST>" + 
  				"      <OVERRIDEADVINTEREST>No</OVERRIDEADVINTEREST>" + 
  				"      <USEFORVAT>No</USEFORVAT>" + 
  				"      <IGNORETDSEXEMPT>No</IGNORETDSEXEMPT>" + 
  				"      <ISTCSAPPLICABLE>No</ISTCSAPPLICABLE>" + 
  				"      <ISTDSAPPLICABLE>No</ISTDSAPPLICABLE>" + 
  				"      <ISFBTAPPLICABLE>No</ISFBTAPPLICABLE>" + 
  				"      <ISGSTAPPLICABLE>No</ISGSTAPPLICABLE>" + 
  				"      <ISEXCISEAPPLICABLE>No</ISEXCISEAPPLICABLE>" + 
  				"      <ISTDSEXPENSE>No</ISTDSEXPENSE>" + 
  				"      <ISEDLIAPPLICABLE>No</ISEDLIAPPLICABLE>" + 
  				"      <ISRELATEDPARTY>No</ISRELATEDPARTY>" + 
  				"      <USEFORESIELIGIBILITY>No</USEFORESIELIGIBILITY>" + 
  				"      <ISINTERESTINCLLASTDAY>No</ISINTERESTINCLLASTDAY>" + 
  				"      <APPROPRIATETAXVALUE>No</APPROPRIATETAXVALUE>" + 
  				"      <ISBEHAVEASDUTY>No</ISBEHAVEASDUTY>" + 
  				"      <INTERESTINCLDAYOFADDITION>No</INTERESTINCLDAYOFADDITION>" + 
  				"      <INTERESTINCLDAYOFDEDUCTION>No</INTERESTINCLDAYOFDEDUCTION>" + 
  				"      <ISOTHTERRITORYASSESSEE>No</ISOTHTERRITORYASSESSEE>" + 
  				"      <OVERRIDECREDITLIMIT>No</OVERRIDECREDITLIMIT>" + 
  				"      <ISAGAINSTFORMC>Yes</ISAGAINSTFORMC>" + 
  				"      <ISCHEQUEPRINTINGENABLED>Yes</ISCHEQUEPRINTINGENABLED>" + 
  				"      <ISPAYUPLOAD>No</ISPAYUPLOAD>" + 
  				"      <ISPAYBATCHONLYSAL>No</ISPAYBATCHONLYSAL>" + 
  				"      <ISBNFCODESUPPORTED>No</ISBNFCODESUPPORTED>" + 
  				"      <ALLOWEXPORTWITHERRORS>No</ALLOWEXPORTWITHERRORS>" + 
  				"      <CONSIDERPURCHASEFOREXPORT>No</CONSIDERPURCHASEFOREXPORT>" + 
  				"      <ISTRANSPORTER>No</ISTRANSPORTER>" + 
  				"      <USEFORNOTIONALITC>No</USEFORNOTIONALITC>" + 
  				"      <ISECOMMOPERATOR>No</ISECOMMOPERATOR>" + 
  				"      <SHOWINPAYSLIP>No</SHOWINPAYSLIP>" + 
  				"      <USEFORGRATUITY>No</USEFORGRATUITY>" + 
  				"      <ISTDSPROJECTED>No</ISTDSPROJECTED>" + 
  				"      <FORSERVICETAX>No</FORSERVICETAX>" + 
  				"      <ISINPUTCREDIT>No</ISINPUTCREDIT>" + 
  				"      <ISEXEMPTED>No</ISEXEMPTED>" + 
  				"      <ISABATEMENTAPPLICABLE>No</ISABATEMENTAPPLICABLE>" + 
  				"      <ISSTXPARTY>No</ISSTXPARTY>" + 
  				"      <ISSTXNONREALIZEDTYPE>No</ISSTXNONREALIZEDTYPE>" + 
  				"      <ISUSEDFORCVD>No</ISUSEDFORCVD>" + 
  				"      <LEDBELONGSTONONTAXABLE>No</LEDBELONGSTONONTAXABLE>" + 
  				"      <ISEXCISEMERCHANTEXPORTER>No</ISEXCISEMERCHANTEXPORTER>" + 
  				"      <ISPARTYEXEMPTED>No</ISPARTYEXEMPTED>" + 
  				"      <ISSEZPARTY>No</ISSEZPARTY>" + 
  				"      <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"      <ISECHEQUESUPPORTED>No</ISECHEQUESUPPORTED>" + 
  				"      <ISEDDSUPPORTED>No</ISEDDSUPPORTED>" + 
  				"      <HASECHEQUEDELIVERYMODE>No</HASECHEQUEDELIVERYMODE>" + 
  				"      <HASECHEQUEDELIVERYTO>No</HASECHEQUEDELIVERYTO>" + 
  				"      <HASECHEQUEPRINTLOCATION>No</HASECHEQUEPRINTLOCATION>" + 
  				"      <HASECHEQUEPAYABLELOCATION>No</HASECHEQUEPAYABLELOCATION>" + 
  				"      <HASECHEQUEBANKLOCATION>No</HASECHEQUEBANKLOCATION>" + 
  				"      <HASEDDDELIVERYMODE>No</HASEDDDELIVERYMODE>" + 
  				"      <HASEDDDELIVERYTO>No</HASEDDDELIVERYTO>" + 
  				"      <HASEDDPRINTLOCATION>No</HASEDDPRINTLOCATION>" + 
  				"      <HASEDDPAYABLELOCATION>No</HASEDDPAYABLELOCATION>" + 
  				"      <HASEDDBANKLOCATION>No</HASEDDBANKLOCATION>" + 
  				"      <ISEBANKINGENABLED>No</ISEBANKINGENABLED>" + 
  				"      <ISEXPORTFILEENCRYPTED>No</ISEXPORTFILEENCRYPTED>" + 
  				"      <ISBATCHENABLED>No</ISBATCHENABLED>" + 
  				"      <ISPRODUCTCODEBASED>No</ISPRODUCTCODEBASED>" + 
  				"      <HASEDDCITY>No</HASEDDCITY>" + 
  				"      <HASECHEQUECITY>No</HASECHEQUECITY>" + 
  				"      <ISFILENAMEFORMATSUPPORTED>No</ISFILENAMEFORMATSUPPORTED>" + 
  				"      <HASCLIENTCODE>No</HASCLIENTCODE>" + 
  				"      <PAYINSISBATCHAPPLICABLE>No</PAYINSISBATCHAPPLICABLE>" + 
  				"      <PAYINSISFILENUMAPP>No</PAYINSISFILENUMAPP>" + 
  				"      <ISSALARYTRANSGROUPEDFORBRS>No</ISSALARYTRANSGROUPEDFORBRS>" + 
  				"      <ISEBANKINGSUPPORTED>No</ISEBANKINGSUPPORTED>" + 
  				"      <ISSCBUAE>No</ISSCBUAE>" + 
  				"      <ISBANKSTATUSAPP>No</ISBANKSTATUSAPP>" + 
  				"      <ISSALARYGROUPED>No</ISSALARYGROUPED>" + 
  				"      <USEFORPURCHASETAX>No</USEFORPURCHASETAX>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <SORTPOSITION> 1000</SORTPOSITION>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <OPENINGBALANCE>-"+ib.getTamount()+"</OPENINGBALANCE>" + 
  				"      <SERVICETAXDETAILS.LIST>      </SERVICETAXDETAILS.LIST>" + 
  				"      <LBTREGNDETAILS.LIST>      </LBTREGNDETAILS.LIST>" + 
  				"      <VATDETAILS.LIST>      </VATDETAILS.LIST>" + 
  				"      <SALESTAXCESSDETAILS.LIST>      </SALESTAXCESSDETAILS.LIST>" + 
  				"      <GSTDETAILS.LIST>      </GSTDETAILS.LIST>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>"+ib.getCustomer_name1()+"</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <XBRLDETAIL.LIST>      </XBRLDETAIL.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <SCHVIDETAILS.LIST>      </SCHVIDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <TCSCATEGORYDETAILS.LIST>      </TCSCATEGORYDETAILS.LIST>" + 
  				"      <TDSCATEGORYDETAILS.LIST>      </TDSCATEGORYDETAILS.LIST>" + 
  				"      <SLABPERIOD.LIST>      </SLABPERIOD.LIST>" + 
  				"      <GRATUITYPERIOD.LIST>      </GRATUITYPERIOD.LIST>" + 
  				"      <ADDITIONALCOMPUTATIONS.LIST>      </ADDITIONALCOMPUTATIONS.LIST>" + 
  				"      <EXCISEJURISDICTIONDETAILS.LIST>      </EXCISEJURISDICTIONDETAILS.LIST>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <BANKALLOCATIONS.LIST>      </BANKALLOCATIONS.LIST>" + 
  				"      <PAYMENTDETAILS.LIST>      </PAYMENTDETAILS.LIST>" + 
  				"      <BANKEXPORTFORMATS.LIST>      </BANKEXPORTFORMATS.LIST>" + 
  				"      <BILLALLOCATIONS.LIST>" + 
  				"       <BILLDATE>"+date+"</BILLDATE>" + 
  				"       <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"       <ISADVANCE>No</ISADVANCE>" + 
  				"       <OPENINGBALANCE>-"+ib.getTamount()+"</OPENINGBALANCE>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"      </BILLALLOCATIONS.LIST>" + 
  				"      <INTERESTCOLLECTION.LIST>      </INTERESTCOLLECTION.LIST>" + 
  				"      <LEDGERCLOSINGVALUES.LIST>      </LEDGERCLOSINGVALUES.LIST>" + 
  				"      <LEDGERAUDITCLASS.LIST>      </LEDGERAUDITCLASS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <TDSEXEMPTIONRULES.LIST>      </TDSEXEMPTIONRULES.LIST>" + 
  				"      <DEDUCTINSAMEVCHRULES.LIST>      </DEDUCTINSAMEVCHRULES.LIST>" + 
  				"      <LOWERDEDUCTION.LIST>      </LOWERDEDUCTION.LIST>" + 
  				"      <STXABATEMENTDETAILS.LIST>      </STXABATEMENTDETAILS.LIST>" + 
  				"      <LEDMULTIADDRESSLIST.LIST>      </LEDMULTIADDRESSLIST.LIST>" + 
  				"      <STXTAXDETAILS.LIST>      </STXTAXDETAILS.LIST>" + 
  				"      <CHEQUERANGE.LIST>      </CHEQUERANGE.LIST>" + 
  				"      <DEFAULTVCHCHEQUEDETAILS.LIST>      </DEFAULTVCHCHEQUEDETAILS.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <BRSIMPORTEDINFO.LIST>      </BRSIMPORTEDINFO.LIST>" + 
  				"      <AUTOBRSCONFIGS.LIST>      </AUTOBRSCONFIGS.LIST>" + 
  				"      <BANKURENTRIES.LIST>      </BANKURENTRIES.LIST>" + 
  				"      <DEFAULTCHEQUEDETAILS.LIST>      </DEFAULTCHEQUEDETAILS.LIST>" + 
  				"      <DEFAULTOPENINGCHEQUEDETAILS.LIST>      </DEFAULTOPENINGCHEQUEDETAILS.LIST>" + 
  				"      <CANCELLEDPAYALLOCATIONS.LIST>      </CANCELLEDPAYALLOCATIONS.LIST>" + 
  				"      <ECHEQUEPRINTLOCATION.LIST>      </ECHEQUEPRINTLOCATION.LIST>" + 
  				"      <ECHEQUEPAYABLELOCATION.LIST>      </ECHEQUEPAYABLELOCATION.LIST>" + 
  				"      <EDDPRINTLOCATION.LIST>      </EDDPRINTLOCATION.LIST>" + 
  				"      <EDDPAYABLELOCATION.LIST>      </EDDPAYABLELOCATION.LIST>" + 
  				"      <AVAILABLETRANSACTIONTYPES.LIST>      </AVAILABLETRANSACTIONTYPES.LIST>" + 
  				"      <LEDPAYINSCONFIGS.LIST>      </LEDPAYINSCONFIGS.LIST>" + 
  				"      <TYPECODEDETAILS.LIST>      </TYPECODEDETAILS.LIST>" + 
  				"      <FIELDVALIDATIONDETAILS.LIST>      </FIELDVALIDATIONDETAILS.LIST>" + 
  				"      <INPUTCRALLOCS.LIST>      </INPUTCRALLOCS.LIST>" + 
  				"      <GSTCLASSFNIGSTRATES.LIST>      </GSTCLASSFNIGSTRATES.LIST>" + 
  				"      <EXTARIFFDUTYHEADDETAILS.LIST>      </EXTARIFFDUTYHEADDETAILS.LIST>" + 
  				"      <VOUCHERTYPEPRODUCTCODES.LIST>      </VOUCHERTYPEPRODUCTCODES.LIST>" + 
  				"     </LEDGER>" + 
  				
  				
  				
  				
  				"     <VOUCHERTYPE NAME=\"Sales\" RESERVEDNAME=\"Sales\">" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00000026</GUID>" + 
  				"      <PARENT>Sales</PARENT>" + 
  				"      <MAILINGNAME>Sale</MAILINGNAME>" + 
  				"      <TAXUNITNAME>&#4; Primary</TAXUNITNAME>" + 
  				"      <VCHPRINTTITLE>Tax Invoice</VCHPRINTTITLE>" + 
  				"      <VCHPRINTDECL>&quot;I/We hereby certify that my/our registration certificate under the GST Act 2017,is in force on the date on which the sale of the goods specified in this tax invoice is made by me/us and it shall be accounted for in the turnover of sales while filling of return and the due tax ,if any payable on the sale has been paid or shall be paid&quot;. &quot;I/We hereby certify that food/foods mentioned in this invoice is/are warranted to be safe in nature substance &amp; quality.</VCHPRINTDECL>" + 
  				"      <NUMBERINGMETHOD>Automatic</NUMBERINGMETHOD>" + 
  				"      <EXCISEUNITNAME>&#4; Primary</EXCISEUNITNAME>" + 
  				"      <VCHPRINTJURISDICTION>Pune</VCHPRINTJURISDICTION>" + 
  				"      <CONTRACONTRA/>" + 
  				"      <PAYMENTCONTRA/>" + 
  				"      <RECEIPTCONTRA/>" + 
  				"      <JOURNALCONTRA/>" + 
  				"      <CNOTECONTRA/>" + 
  				"      <DNOTECONTRA/>" + 
  				"      <SALESCONTRA/>" + 
  				"      <PURCHASECONTRA/>" + 
  				"      <CREDITCSTCTR/>" + 
  				"      <DEBITCSTCTR/>" + 
  				"      <PREVIOUSPURCHASE/>" + 
  				"      <PREVIOUSSALES/>" + 
  				"      <PREVIOUSGODOWN/>" + 
  				"      <PREVNARRATION>being 18 Bags of CN Rs.2/- Ruturn from Customer on 16/12/2018.</PREVNARRATION>" + 
  				"      <ISUPDATINGTARGETID>No</ISUPDATINGTARGETID>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"      <AFFECTSSTOCK>No</AFFECTSSTOCK>" + 
  				"      <PREVENTDUPLICATES>No</PREVENTDUPLICATES>" + 
  				"      <PREFILLZERO>Yes</PREFILLZERO>" + 
  				"      <PRINTAFTERSAVE>Yes</PRINTAFTERSAVE>" + 
  				"      <FORMALRECEIPT>No</FORMALRECEIPT>" + 
  				"      <ISOPTIONAL>Yes</ISOPTIONAL>" + 
  				"      <ASMFGJRNL>No</ASMFGJRNL>" + 
  				"      <EFFECTIVEDATE>No</EFFECTIVEDATE>" + 
  				"      <COMMONNARRATION>Yes</COMMONNARRATION>" + 
  				"      <MULTINARRATION>No</MULTINARRATION>" + 
  				"      <ISTAXINVOICE>Yes</ISTAXINVOICE>" + 
  				"      <USEFORPOSINVOICE>No</USEFORPOSINVOICE>" + 
  				"      <USEFOREXCISETRADERINVOICE>No</USEFOREXCISETRADERINVOICE>" + 
  				"      <USEFOREXCISE>No</USEFOREXCISE>" + 
  				"      <USEFORJOBWORK>No</USEFORJOBWORK>" + 
  				"      <ISFORJOBWORKIN>No</ISFORJOBWORKIN>" + 
  				"      <ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>" + 
  				"      <USEFOREXCISEGOODS>No</USEFOREXCISEGOODS>" + 
  				"      <USEFOREXCISESUPPLEMENTARY>No</USEFOREXCISESUPPLEMENTARY>" + 
  				"      <ISDEFAULTALLOCENABLED>No</ISDEFAULTALLOCENABLED>" + 
  				"      <SORTPOSITION> 70</SORTPOSITION>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <BEGINNINGNUMBER> 1</BEGINNINGNUMBER>" + 
  				"      <WIDTHOFNUMBER> 4</WIDTHOFNUMBER>" + 
  				"      <LANGUAGENAME.LIST>" + 
  				"       <NAME.LIST TYPE=\"String\">" + 
  				"        <NAME>Sales</NAME>" + 
  				"       </NAME.LIST>" + 
  				"       <LANGUAGEID> 1033</LANGUAGEID>" + 
  				"      </LANGUAGENAME.LIST>" + 
  				"      <AUDITDETAILS.LIST>      </AUDITDETAILS.LIST>" + 
  				"      <EXCISETARIFFDETAILS.LIST>      </EXCISETARIFFDETAILS.LIST>" + 
  				"      <PREFIXLIST.LIST>" + 
  				"       <DATE>"+date+"</DATE>" + 
  				"       <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"      </PREFIXLIST.LIST>" + 
  				"      <RESTARTFROMLIST.LIST>" + 
  				"       <DATE>"+date+"</DATE>" + 
  				"       <RESTARTFROM>Yearly</RESTARTFROM>" + 
  				"       <PERIODBEGINNIGNUM> 1</PERIODBEGINNIGNUM>" + 
  				"       <LASTNUMBERLIST.LIST>       </LASTNUMBERLIST.LIST>" + 
  				"      </RESTARTFROMLIST.LIST>" + 
  				"      <VOUCHERCLASSLIST.LIST>      </VOUCHERCLASSLIST.LIST>" + 
  				"      <PRODUCTCODEDETAILS.LIST>      </PRODUCTCODEDETAILS.LIST>" + 
  				"      <UDF:_UDF_553648231.LIST DESC=\"\" ISLIST=\"YES\" TYPE=\"Logical\" INDEX=\"102\">" + 
  				"       <UDF:_UDF_553648231 DESC=\"\">Yes</UDF:_UDF_553648231>" + 
  				"      </UDF:_UDF_553648231.LIST>" + 
  				"      <UDF:_UDF_553676630.LIST DESC=\"\" ISLIST=\"YES\" TYPE=\"Logical\" INDEX=\"28501\">" + 
  				"       <UDF:_UDF_553676630 DESC=\"\">Yes</UDF:_UDF_553676630>" + 
  				"      </UDF:_UDF_553676630.LIST>" + 
  				"      <UDF:ISUSEFOREXCISE.LIST DESC=\"`IsUseforExcise`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"15124\">" + 
  				"       <UDF:ISUSEFOREXCISE DESC=\"`IsUseforExcise`\">No</UDF:ISUSEFOREXCISE>" + 
  				"      </UDF:ISUSEFOREXCISE.LIST>" + 
  				"     </VOUCHERTYPE>" + 
  				
  				
  				
  				
  				
  				"     <VOUCHER REMOTEID=\"fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00030557-"+ib.getInvoiceno()+"\" VCHKEY=\"fe3dda4e-0caf-40d4-aded-cd9acef4ead5-0000a9d6:00000048\" VCHTYPE=\"Sales\" ACTION=\"Create\" OBJVIEW=\"Invoice Voucher View\">" + 
  				"      <ADDRESS.LIST TYPE=\"String\">" + 
  				"       <ADDRESS>"+ib.getAddress1()+"</ADDRESS>" + 
   				"      </ADDRESS.LIST>" + 
  				"      <BASICBUYERADDRESS.LIST TYPE=\"String\">" + 
  				"       <BASICBUYERADDRESS>"+ib.getAddress1()+"</BASICBUYERADDRESS>" + 
  				"      </BASICBUYERADDRESS.LIST>" + 
  				"      <BASICORDERTERMS.LIST TYPE=\"String\">" + 
  				"       <BASICORDERTERMS>FOR</BASICORDERTERMS>" + 
  				"      </BASICORDERTERMS.LIST>" + 
  				"      <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"       <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"      </OLDAUDITENTRYIDS.LIST>" + 
  				"      <DATE>"+date+"</DATE>" + 
  				"      <GUID>fe3dda4e-0caf-40d4-aded-cd9acef4ead5-00030557</GUID>" + 
  				"      <STATENAME>"+ib.getState1()+"</STATENAME>" + 
  				"      <PRICELEVEL>"+ib.getCustomer_name1()+"</PRICELEVEL>" + 
  				"      <COUNTRYOFRESIDENCE>India</COUNTRYOFRESIDENCE>" + 
  				"      <PARTYGSTIN>"+ib.getVat007()+"</PARTYGSTIN>" + 
  				"      <PARTYNAME>"+ib.getCustomer_name1()+"</PARTYNAME>" + 
  				"      <VOUCHERTYPENAME>Sales</VOUCHERTYPENAME>" + 
  				"      <REFERENCE>"+ib.getInvoiceno()+"</REFERENCE>" + 
  				"      <VOUCHERNUMBER>"+ib.getInvoiceno()+"</VOUCHERNUMBER>" + 
  				"      <PARTYLEDGERNAME>"+ib.getCustomer_name1()+"</PARTYLEDGERNAME>" + 
  				"      <BASICBASEPARTYNAME>"+ib.getCustomer_name1()+"</BASICBASEPARTYNAME>" + 
  				"      <CSTFORMISSUETYPE/>" + 
  				"      <CSTFORMRECVTYPE/>" + 
  				"      <CONSIGNEECSTNUMBER></CONSIGNEECSTNUMBER>" + 
  				"      <BUYERSCSTNUMBER></BUYERSCSTNUMBER>" + 
  				"      <FBTPAYMENTTYPE>Default</FBTPAYMENTTYPE>" + 
  				"      <PERSISTEDVIEW>Invoice Voucher View</PERSISTEDVIEW>" + 
  				"      <PLACEOFSUPPLY>"+ib.getState1()+"</PLACEOFSUPPLY>" + 
  				"      <CONSIGNEEGSTIN>"+ib.getVat007()+"</CONSIGNEEGSTIN>" + 
  				"      <BASICSHIPPEDBY>"+ib.getVehino()+"</BASICSHIPPEDBY>" + 
  				"      <BASICBUYERNAME>"+ib.getCustomer_name1()+"</BASICBUYERNAME>" + 
  				"      <BASICDATETIMEOFINVOICE></BASICDATETIMEOFINVOICE>" + 
  				"      <BASICDATETIMEOFREMOVAL></BASICDATETIMEOFREMOVAL>" + 
  				"      <VCHGSTCLASS/>" + 
  				"      <CONSIGNEESTATENAME>"+ib.getState1()+"</CONSIGNEESTATENAME>" + 
  				"      <ENTEREDBY>kumar</ENTEREDBY>" + 
  				"      <DIFFACTUALQTY>No</DIFFACTUALQTY>" + 
  				"      <ISMSTFROMSYNC>No</ISMSTFROMSYNC>" + 
  				"      <ASORIGINAL>No</ASORIGINAL>" + 
  				"      <AUDITED>No</AUDITED>" + 
  				"      <FORJOBCOSTING>No</FORJOBCOSTING>" + 
  				"      <ISOPTIONAL>No</ISOPTIONAL>" + 
  				"      <EFFECTIVEDATE>"+date+"</EFFECTIVEDATE>" + 
  				"      <USEFOREXCISE>No</USEFOREXCISE>" + 
  				"      <ISFORJOBWORKIN>No</ISFORJOBWORKIN>" + 
  				"      <ALLOWCONSUMPTION>No</ALLOWCONSUMPTION>" + 
  				"      <USEFORINTEREST>No</USEFORINTEREST>" + 
  				"      <USEFORGAINLOSS>No</USEFORGAINLOSS>" + 
  				"      <USEFORGODOWNTRANSFER>No</USEFORGODOWNTRANSFER>" + 
  				"      <USEFORCOMPOUND>No</USEFORCOMPOUND>" + 
  				"      <USEFORSERVICETAX>No</USEFORSERVICETAX>" + 
  				"      <ISEXCISEVOUCHER>No</ISEXCISEVOUCHER>" + 
  				"      <EXCISETAXOVERRIDE>No</EXCISETAXOVERRIDE>" + 
  				"      <USEFORTAXUNITTRANSFER>No</USEFORTAXUNITTRANSFER>" + 
  				"      <IGNOREPOSVALIDATION>No</IGNOREPOSVALIDATION>" + 
  				"      <EXCISEOPENING>No</EXCISEOPENING>" + 
  				"      <USEFORFINALPRODUCTION>No</USEFORFINALPRODUCTION>" + 
  				"      <ISTDSOVERRIDDEN>No</ISTDSOVERRIDDEN>" + 
  				"      <ISTCSOVERRIDDEN>No</ISTCSOVERRIDDEN>" + 
  				"      <ISTDSTCSCASHVCH>No</ISTDSTCSCASHVCH>" + 
  				"      <INCLUDEADVPYMTVCH>No</INCLUDEADVPYMTVCH>" + 
  				"      <ISSUBWORKSCONTRACT>No</ISSUBWORKSCONTRACT>" + 
  				"      <ISVATOVERRIDDEN>No</ISVATOVERRIDDEN>" + 
  				"      <IGNOREORIGVCHDATE>No</IGNOREORIGVCHDATE>" + 
  				"      <ISVATPAIDATCUSTOMS>No</ISVATPAIDATCUSTOMS>" + 
  				"      <ISDECLAREDTOCUSTOMS>No</ISDECLAREDTOCUSTOMS>" + 
  				"      <ISSERVICETAXOVERRIDDEN>No</ISSERVICETAXOVERRIDDEN>" + 
  				"      <ISISDVOUCHER>No</ISISDVOUCHER>" + 
  				"      <ISEXCISEOVERRIDDEN>No</ISEXCISEOVERRIDDEN>" + 
  				"      <ISEXCISESUPPLYVCH>No</ISEXCISESUPPLYVCH>" + 
  				"      <ISGSTOVERRIDDEN>No</ISGSTOVERRIDDEN>" + 
  				"      <GSTNOTEXPORTED>No</GSTNOTEXPORTED>" + 
  				"      <IGNOREGSTINVALIDATION>No</IGNOREGSTINVALIDATION>" + 
  				"      <ISVATPRINCIPALACCOUNT>No</ISVATPRINCIPALACCOUNT>" + 
  				"      <ISBOENOTAPPLICABLE>No</ISBOENOTAPPLICABLE>" + 
  				"      <ISSHIPPINGWITHINSTATE>No</ISSHIPPINGWITHINSTATE>" + 
  				"      <ISOVERSEASTOURISTTRANS>No</ISOVERSEASTOURISTTRANS>" + 
  				"      <ISDESIGNATEDZONEPARTY>No</ISDESIGNATEDZONEPARTY>" + 
  				"      <ISCANCELLED>No</ISCANCELLED>" + 
  				"      <HASCASHFLOW>No</HASCASHFLOW>" + 
  				"      <ISPOSTDATED>No</ISPOSTDATED>" + 
  				"      <USETRACKINGNUMBER>No</USETRACKINGNUMBER>" + 
  				"      <ISINVOICE>Yes</ISINVOICE>" + 
  				"      <MFGJOURNAL>No</MFGJOURNAL>" + 
  				"      <HASDISCOUNTS>Yes</HASDISCOUNTS>" + 
  				"      <ASPAYSLIP>No</ASPAYSLIP>" + 
  				"      <ISCOSTCENTRE>No</ISCOSTCENTRE>" + 
  				"      <ISSTXNONREALIZEDVCH>No</ISSTXNONREALIZEDVCH>" + 
  				"      <ISEXCISEMANUFACTURERON>No</ISEXCISEMANUFACTURERON>" + 
  				"      <ISBLANKCHEQUE>No</ISBLANKCHEQUE>" + 
  				"      <ISVOID>No</ISVOID>" + 
  				"      <ISONHOLD>No</ISONHOLD>" + 
  				"      <ORDERLINESTATUS>No</ORDERLINESTATUS>" + 
  				"      <VATISAGNSTCANCSALES>No</VATISAGNSTCANCSALES>" + 
  				"      <VATISPURCEXEMPTED>No</VATISPURCEXEMPTED>" + 
  				"      <ISVATRESTAXINVOICE>No</ISVATRESTAXINVOICE>" + 
  				"      <VATISASSESABLECALCVCH>No</VATISASSESABLECALCVCH>" + 
  				"      <ISVATDUTYPAID>Yes</ISVATDUTYPAID>" + 
  				"      <ISDELIVERYSAMEASCONSIGNEE>No</ISDELIVERYSAMEASCONSIGNEE>" + 
  				"      <ISDISPATCHSAMEASCONSIGNOR>No</ISDISPATCHSAMEASCONSIGNOR>" + 
  				"      <ISDELETED>No</ISDELETED>" + 
  				"      <CHANGEVCHMODE>No</CHANGEVCHMODE>" + 
  				"      <ALTERID> "+ib.getInvoiceno()+"</ALTERID>" + 
  				"      <MASTERID> 197975</MASTERID>" + 
  				"      <VOUCHERKEY>"+ib.getInvoiceno()+"</VOUCHERKEY>" + 
  				"      <EXCLUDEDTAXATIONS.LIST>      </EXCLUDEDTAXATIONS.LIST>" + 
  				"      <OLDAUDITENTRIES.LIST>      </OLDAUDITENTRIES.LIST>" + 
  				"      <ACCOUNTAUDITENTRIES.LIST>      </ACCOUNTAUDITENTRIES.LIST>" + 
  				"      <AUDITENTRIES.LIST>      </AUDITENTRIES.LIST>" + 
  				"      <DUTYHEADDETAILS.LIST>      </DUTYHEADDETAILS.LIST>" + 
  				"      <SUPPLEMENTARYDUTYHEADDETAILS.LIST>      </SUPPLEMENTARYDUTYHEADDETAILS.LIST>" + 
  				"      <EWAYBILLDETAILS.LIST>      </EWAYBILLDETAILS.LIST>" + 
  				"      <INVOICEDELNOTES.LIST>" + 
  				"       <BASICSHIPPINGDATE>"+date+"</BASICSHIPPINGDATE>" + 
  				"       <BASICSHIPDELIVERYNOTE>"+ib.getInvoiceno()+"</BASICSHIPDELIVERYNOTE>" + 
  				"      </INVOICEDELNOTES.LIST>" + 
  				"      <INVOICEORDERLIST.LIST>" + 
  				"       <BASICORDERDATE>"+date+"</BASICORDERDATE>" + 
  				"       <BASICPURCHASEORDERNO>"+ib.getInvoiceno()+"</BASICPURCHASEORDERNO>" + 
  				"      </INVOICEORDERLIST.LIST>" + 
  				"      <INVOICEINDENTLIST.LIST>      </INVOICEINDENTLIST.LIST>" + 
  				"      <ATTENDANCEENTRIES.LIST>      </ATTENDANCEENTRIES.LIST>" + 
  				"      <ORIGINVOICEDETAILS.LIST>      </ORIGINVOICEDETAILS.LIST>" + 
  				"      <INVOICEEXPORTLIST.LIST>      </INVOICEEXPORTLIST.LIST>" + 
  				"      <LEDGERENTRIES.LIST>" + 
  				"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"       </OLDAUDITENTRYIDS.LIST>" + 
  				"       <LEDGERNAME>"+ib.getCustomer_name1()+"</LEDGERNAME>" + 
  				"       <GSTCLASS/>" + 
  				"       <ISDEEMEDPOSITIVE>Yes</ISDEEMEDPOSITIVE>" + 
  				"       <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  				"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  				"       <ISPARTYLEDGER>Yes</ISPARTYLEDGER>" + 
  				"       <ISLASTDEEMEDPOSITIVE>Yes</ISLASTDEEMEDPOSITIVE>" + 
  				"       <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  				"       <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  				"       <AMOUNT>-"+ib.getTamount()+"</AMOUNT>" + 
  				"       <SERVICETAXDETAILS.LIST>       </SERVICETAXDETAILS.LIST>" + 
  				"       <BANKALLOCATIONS.LIST>       </BANKALLOCATIONS.LIST>" + 
  				"       <BILLALLOCATIONS.LIST>" + 
  				"        <NAME>"+ib.getInvoiceno()+"</NAME>" + 
  				"        <BILLTYPE>New Ref</BILLTYPE>" + 
  				"        <TDSDEDUCTEEISSPECIALRATE>No</TDSDEDUCTEEISSPECIALRATE>" + 
  				"        <AMOUNT>-"+ib.getTamount()+"</AMOUNT>" + 
  				"        <INTERESTCOLLECTION.LIST>        </INTERESTCOLLECTION.LIST>" + 
  				"        <STBILLCATEGORIES.LIST>        </STBILLCATEGORIES.LIST>" + 
  				"       </BILLALLOCATIONS.LIST>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"       <OLDAUDITENTRIES.LIST>       </OLDAUDITENTRIES.LIST>" + 
  				"       <ACCOUNTAUDITENTRIES.LIST>       </ACCOUNTAUDITENTRIES.LIST>" + 
  				"       <AUDITENTRIES.LIST>       </AUDITENTRIES.LIST>" + 
  				"       <INPUTCRALLOCS.LIST>       </INPUTCRALLOCS.LIST>" + 
  				"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  				"       <EXCISEDUTYHEADDETAILS.LIST>       </EXCISEDUTYHEADDETAILS.LIST>" + 
  				"       <RATEDETAILS.LIST>       </RATEDETAILS.LIST>" + 
  				"       <SUMMARYALLOCS.LIST>       </SUMMARYALLOCS.LIST>" + 
  				"       <STPYMTDETAILS.LIST>       </STPYMTDETAILS.LIST>" + 
  				"       <EXCISEPAYMENTALLOCATIONS.LIST>       </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  				"       <TAXBILLALLOCATIONS.LIST>       </TAXBILLALLOCATIONS.LIST>" + 
  				"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  				"       <TDSEXPENSEALLOCATIONS.LIST>       </TDSEXPENSEALLOCATIONS.LIST>" + 
  				"       <VATSTATUTORYDETAILS.LIST>       </VATSTATUTORYDETAILS.LIST>" + 
  				"       <COSTTRACKALLOCATIONS.LIST>       </COSTTRACKALLOCATIONS.LIST>" + 
  				"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  				"       <INVOICEWISEDETAILS.LIST>       </INVOICEWISEDETAILS.LIST>" + 
  				"       <VATITCDETAILS.LIST>       </VATITCDETAILS.LIST>" + 
  				"       <ADVANCETAXDETAILS.LIST>       </ADVANCETAXDETAILS.LIST>" + 
  				"      </LEDGERENTRIES.LIST>" + 
  				
  				
  				
  			
  			/*	"      <LEDGERENTRIES.LIST>" + 
  				"       <OLDAUDITENTRYIDS.LIST TYPE=\"Number\">" + 
  				"        <OLDAUDITENTRYIDS>-1</OLDAUDITENTRYIDS>" + 
  				"       </OLDAUDITENTRYIDS.LIST>" + 
  				"       <LEDGERNAME>Amount Rounded Off</LEDGERNAME>" + 
  				"       <GSTCLASS/>" + 
  				"       <ISDEEMEDPOSITIVE>No</ISDEEMEDPOSITIVE>" + 
  				"       <LEDGERFROMITEM>No</LEDGERFROMITEM>" + 
  				"       <REMOVEZEROENTRIES>No</REMOVEZEROENTRIES>" + 
  				"       <ISPARTYLEDGER>No</ISPARTYLEDGER>" + 
  				"       <ISLASTDEEMEDPOSITIVE>No</ISLASTDEEMEDPOSITIVE>" + 
  				"       <ISCAPVATTAXALTERED>No</ISCAPVATTAXALTERED>" + 
  				"       <ISCAPVATNOTCLAIMED>No</ISCAPVATNOTCLAIMED>" + 
  				"       <AMOUNT>0.115</AMOUNT>" + 
  				"       <VATEXPAMOUNT>0.115</VATEXPAMOUNT>" + 
  				"       <SERVICETAXDETAILS.LIST>       </SERVICETAXDETAILS.LIST>" + 
  				"       <BANKALLOCATIONS.LIST>       </BANKALLOCATIONS.LIST>" + 
  				"       <BILLALLOCATIONS.LIST>       </BILLALLOCATIONS.LIST>" + 
  				"       <INTERESTCOLLECTION.LIST>       </INTERESTCOLLECTION.LIST>" + 
  				"       <OLDAUDITENTRIES.LIST>       </OLDAUDITENTRIES.LIST>" + 
  				"       <ACCOUNTAUDITENTRIES.LIST>       </ACCOUNTAUDITENTRIES.LIST>" + 
  				"       <AUDITENTRIES.LIST>       </AUDITENTRIES.LIST>" + 
  				"       <INPUTCRALLOCS.LIST>       </INPUTCRALLOCS.LIST>" + 
  				"       <DUTYHEADDETAILS.LIST>       </DUTYHEADDETAILS.LIST>" + 
  				"       <EXCISEDUTYHEADDETAILS.LIST>       </EXCISEDUTYHEADDETAILS.LIST>" + 
  				"       <RATEDETAILS.LIST>       </RATEDETAILS.LIST>" + 
  				"       <SUMMARYALLOCS.LIST>       </SUMMARYALLOCS.LIST>" + 
  				"       <STPYMTDETAILS.LIST>       </STPYMTDETAILS.LIST>" + 
  				"       <EXCISEPAYMENTALLOCATIONS.LIST>       </EXCISEPAYMENTALLOCATIONS.LIST>" + 
  				"       <TAXBILLALLOCATIONS.LIST>       </TAXBILLALLOCATIONS.LIST>" + 
  				"       <TAXOBJECTALLOCATIONS.LIST>       </TAXOBJECTALLOCATIONS.LIST>" + 
  				"       <TDSEXPENSEALLOCATIONS.LIST>       </TDSEXPENSEALLOCATIONS.LIST>" + 
  				"       <VATSTATUTORYDETAILS.LIST>       </VATSTATUTORYDETAILS.LIST>" + 
  				"       <COSTTRACKALLOCATIONS.LIST>       </COSTTRACKALLOCATIONS.LIST>" + 
  				"       <REFVOUCHERDETAILS.LIST>       </REFVOUCHERDETAILS.LIST>" + 
  				"       <INVOICEWISEDETAILS.LIST>       </INVOICEWISEDETAILS.LIST>" + 
  				"       <VATITCDETAILS.LIST>       </VATITCDETAILS.LIST>" + 
  				"       <ADVANCETAXDETAILS.LIST>       </ADVANCETAXDETAILS.LIST>" + 
  				"      </LEDGERENTRIES.LIST>"+*/ 
  				
  				
  				st+
  				
  					
  				"      <PAYROLLMODEOFPAYMENT.LIST>      </PAYROLLMODEOFPAYMENT.LIST>" + 
  				"      <ATTDRECORDS.LIST>      </ATTDRECORDS.LIST>" + 
  				"      <GSTEWAYCONSIGNORADDRESS.LIST>      </GSTEWAYCONSIGNORADDRESS.LIST>" + 
  				"      <GSTEWAYCONSIGNEEADDRESS.LIST>      </GSTEWAYCONSIGNEEADDRESS.LIST>" + 
  				"      <TEMPGSTRATEDETAILS.LIST>      </TEMPGSTRATEDETAILS.LIST>" + 
  				"      <UDF:VAAPPROVEDBY.LIST DESC=\"`VAApprovedBy`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"211\">" + 
  				"       <UDF:VAAPPROVEDBY DESC=\"`VAApprovedBy`\">kumar</UDF:VAAPPROVEDBY>" + 
  				"      </UDF:VAAPPROVEDBY.LIST>" + 
  				"      <UDF:VCREMARKS.LIST DESC=\"`VCRemarks`\" ISLIST=\"YES\" TYPE=\"String\" INDEX=\"215\">" + 
  				"       <UDF:VCREMARKS DESC=\"`VCRemarks`\">Approved</UDF:VCREMARKS>" + 
  				"      </UDF:VCREMARKS.LIST>" + 
  				"     </VOUCHER>" + 
  				"    </TALLYMESSAGE>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				"     <COMPANY>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>fe3dda4e-0caf-40d4-aded-cd9acef4ead5</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods ERP Demo</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>23468eb0-6cc0-4915-8193-fa84b280316c</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>ef15fbb2-364b-49e3-ba21-80170e8028a0</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"     </COMPANY>" + 
  				"    </TALLYMESSAGE>" + 
  				"    <TALLYMESSAGE xmlns:UDF=\"TallyUDF\">" + 
  				"     <COMPANY>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>fe3dda4e-0caf-40d4-aded-cd9acef4ead5</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods ERP Demo</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>23468eb0-6cc0-4915-8193-fa84b280316c</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"      <REMOTECMPINFO.LIST MERGE=\"Yes\">" + 
  				"       <NAME>ef15fbb2-364b-49e3-ba21-80170e8028a0</NAME>" + 
  				"       <REMOTECMPNAME>Vasaya Foods Pvt.Ltd.</REMOTECMPNAME>" + 
  				"       <REMOTECMPSTATE>Maharashtra</REMOTECMPSTATE>" + 
  				"      </REMOTECMPINFO.LIST>" + 
  				"     </COMPANY>" + 
  				"    </TALLYMESSAGE>" + 
  				"   </REQUESTDATA>" + 
  				"  </IMPORTDATA>" + 
  				" </BODY>" + 
  				"</ENVELOPE>" ; 
                       
   

	//System.out.println("XMLM::"+TXML);
	
	
	DBConnection.closeConnection();

    return TXML;
    

}

}
