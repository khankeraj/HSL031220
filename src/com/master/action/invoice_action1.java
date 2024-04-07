package com.master.action;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.invoice_dao1;
import com.master.dao.job_card_dao;
import com.master.model.LoginBean;
import com.master.model.TripModel;
import com.master.model.invoicebean;
import com.master.model.invoicebean1;
import com.master.util.AmtInWord;
import com.master.util.EnglishNumberToWords;
import com.opensymphony.xwork2.ActionContext;

//import antlr.collections.List;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class invoice_action1 extends ActionSupport
		implements ServletRequestAware, SessionAware, ModelDriven<invoicebean1> {

	/**
	 * 
	 */
			
			static DBConnection connection=new DBConnection();
			//static Connection conn=connection.getConnection();		
			
	private static final long serialVersionUID = 2725869288211208449L;
	private List<invoicebean1> invoicebean_1 = new ArrayList<invoicebean1>();
	private List<invoicebean1> invoicebean_5 = new ArrayList<invoicebean1>();
	private List<invoicebean1> invoicebean_2 = new ArrayList<invoicebean1>();
	private List<invoicebean1> invoicebean = new ArrayList<invoicebean1>();
	
	private List<TripModel> consigndetails = new ArrayList<TripModel>();
	
	
	
	
	HttpServletRequest request;
	private int partscount;
	private int labourcount;
	
	private Map session;
	private invoicebean1 ib = new invoicebean1();
	private LoginBean bean = new LoginBean();

	private String response = "";
	private boolean submit;
	private boolean printbutton2;

	private String answer = "";
	private String nparts = "";
	private String tparts = "";
	private String nntparts = "";
	private String LABAMT = "";
	private String LABTAX = "";
	private String netamt = "";
	private String naettax = "";
	private String gross = "";
	private String LABNET = "";
	double nettparts = 0.0;
	double ttttparts = 0.0;
	double tnttparts = 0.0;
	double labour1 = 0.0;
	double labour2 = 0.0;
	double total1 = 0.0;
	double total2 = 0.0;
	double labour3 = 0.0;
	double total3 = 0.0;
	double sum = 0.0;
	double sum1 = 0.0;
	double sum2 = 0.0;
	double sum3 = 0.0;
	double sum4 = 0.0;
	double sum5 = 0.0;
	double sumt1 = 0.0;
	double sumt2 = 0.0;
	double sumt3 = 0.0;
	double transport = 0.0;
	double freight = 0.0;
	double gtot = 0.0;
	

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	
	
	
	public String FetchspareGatepassAssemblyform745() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String autoinvoice = request.getParameter("autoinvoice");

		try {
			ib = new invoice_dao1().FetchspareGatepassAssemblyform745(autoinvoice,bean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	
	public String FetchspareGatepassAssemblyform745Igst() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String autoinvoice = request.getParameter("autoinvoice");

		try {
			ib = new invoice_dao1().FetchspareGatepassAssemblyform745Igst(autoinvoice,bean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	

	public String openbill745() throws IOException, SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		response = new job_card_dao().getnvnumber(bean);
		request.setAttribute("response", response);
		System.out.println(">>>"+response);
		
		
		return "success";

	}

	

	public String Add_New_spare() throws Exception {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String sparename = request.getParameter("sparename");
		// String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String cprice = request.getParameter("cprice");
		String comprice = request.getParameter("comprice");
		String taxtype = request.getParameter("taxtype");
		String taxper = request.getParameter("taxper");
		String remark = request.getParameter("remark");
		String unit = request.getParameter("unit");

		/*
		 * String btype=request.getParameter("btype"); String
		 * service_name=request.getParameter("service_name"); String
		 * tax_type=request.getParameter("tax_type"); String
		 * taxpercent=request.getParameter("taxpercent");
		 */

		// ib.setVehicle_no(request.getParameter("vehicleno"));
		response = new invoice_dao1().insertdescinfo(sparename, model, cprice, comprice, taxtype, taxper, remark, unit,bean);

		System.out.println("answer" + response);

		//System.out.println(">>>>>>");
		return "success11";

	}

	public String Add_New_spare1() throws Exception {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		// String btype=request.getParameter("btype");
		String service_name = request.getParameter("service_name");
		String tax_type = request.getParameter("tax_type");
		String taxpercent = request.getParameter("taxpercent");
		String amount = request.getParameter("amount");
		// ib.setVehicle_no(request.getParameter("vehicleno"));
		response = new invoice_dao1().insertdescinfo1(service_name, tax_type, taxpercent, amount,bean);

		return "success11";

	}

	public String FetchspareGatepassAssemblyform() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String autoinvoice = request.getParameter("autoinvoice");

		try {
			ib = new invoice_dao1().FetchspareGatepassAssemblyform(autoinvoice,bean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	
	public String FetchspareGatepassAssemblyformSales() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String autoinvoice = request.getParameter("autoinvoice");

		try {
			ib = new invoice_dao1().FetchspareGatepassAssemblyformSales(autoinvoice,bean);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}

	private String pono;
	private String podate;
	private String termcond;
	private String vendor;

	private String dcnox;
	private String dcdatex;

	private String transmode;
	private String contactp;
	private String contactpno;
	private String shipparty;
	private String shipadd;
	private String shipgstn;
	private String shipstate;
	private String vehino;
	private Double tqty;
	private String t11qty;
	
	private String consigner;
	private String from;
	private String consignee;
	private String to;
	
	
	
	
	
	
	public String getConsigner() {
		return consigner;
	}




	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}




	public String getFrom() {
		return from;
	}




	public void setFrom(String from) {
		this.from = from;
	}




	public String getConsignee() {
		return consignee;
	}




	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	



	public String getTo() {
		return to;
	}




	public void setTo(String to) {
		this.to = to;
	}




	public String Add_New_invoice() throws Exception {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;
		
		
		
		response = new invoice_dao1().insertCustomerInfo(ib,bean);
		
	
		/*if (response.equals("success")) {

			
			flag = 0;
		}
		
		else {
			flag = 1;
		}
		
		//System.out.println("Flag::"+flag);
		

		if (flag == 0) {
			
			
			Connection conn=connection.getConnection();
			
			int labourc = 0;
			int partsc = 0;
			tqty=0.0;
			pono = ib.getPono();
			podate = ib.getPodate();
			termcond = ib.getTermcond();
			vendor = ib.getVendor();
			dcnox = ib.getDcnox();
			dcdatex = ib.getDcdatex();

			transmode = ib.getTransmode();
			contactp = ib.getContactp();
			contactpno = ib.getContactpno();
			try {
				shipparty = ib.getShipparty().trim();
			} catch (Exception e) {
			}

			try {
				shipadd = ib.getShipadd().trim();
			} catch (Exception e) {
			}
			try {
				shipgstn = ib.getShipgstn().trim();
			} catch (Exception e) {
			}
			try {
				shipstate = ib.getShipstate().trim();
			} catch (Exception e) {
			}
			vehino = ib.getVehino();

			//System.out.println(">>>dcno" + dcnox);
			for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
				if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
					if (ib.getBtype()[j1].equals("parts")) {
						partsc++;
					}

					if (ib.getBtype()[j1].equals("labour")) {
						labourc++;
					}

				}
			}

			labourcount = labourc;
			partscount = partsc;
			
			

			try {
				//Connection con = DaoHelper.getConnection();
				
				PreparedStatement preparedStatementx = conn
						.prepareStatement("select * from destributor_master where destributor_id='" + ib.getCustomer_Id() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				if (resultSetx.next()) {
					ib.setCustomer_name(resultSetx.getString("name"));
					ib.setAddress(resultSetx.getString("address"));
					ib.setVat(resultSetx.getString("gstn"));
					//ib.setCust_subname(resultSetx.getString("cust_subname"));
					ib.setState(resultSetx.getString("state"));
					String mob = "";

					

					ib.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}
				
				
				//System.out.println("PRINT::"+ib.getPrintbutton2());

				if (ib.getPrintbutton2().equalsIgnoreCase("printbutton2")) {

					System.out.println("If Part:");
					
					int rr = 0;
					int rr1 = 0;
					double cgst = 0.0;
					double sgst = 0.0;
					for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
						
						if (!ib.getDescription1()[j1].trim().equals("")
								&& !ib.getDescription1()[j1].trim().equals(null)) {
							
							invoicebean1 ib1 = new invoicebean1();

							ib1.setType_1(ib.getBtype()[j1]);

							ib1.setDescription(ib.getDescription1()[j1]);
							ib1.setTax_type(ib.getTtype()[j1]);
							ib1.setGr1(ib.getGrate1()[j1]);
							ib1.setGr2(ib.getGrate2()[j1]);
							ib1.setGsa1(ib.getGstamount1()[j1]);
							ib1.setPartnoo(ib.getPartno()[j1]);
							ib1.setPartdatee(ib.getPartdate()[j1]);
							ib1.setPartnoox(ib.getPartnox()[j1]);
							ib1.setGsa2(ib.getGstamount2()[j1]);
							ib1.setDisc1(ib.getDisc()[j1]);
							
							
							ib1.setBatch22(ib.getBatch1()[j1]);
							
							//System.out.println("If Part111:");
							
							try{
								
								
							}catch(Exception e){
								
								
								
							}
							
							
							try {
								cgst = cgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {

							}
							try {
								sgst = sgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {
							}

							ib1.setMyrate1(ib.getMyrate()[j1]);

							
							PreparedStatement preparedStatementx1 = conn
									.prepareStatement("select type from bag_config_master where bag_name='"
											+ ib.getDescription1()[j1] + "'");

							
							//System.out.println("SQL:"+preparedStatementx1);
							
							ResultSet resultSetx1 = preparedStatementx1.executeQuery();
							
							if (resultSetx1.next()) {
								ib1.setUnit(resultSetx1.getString("type"));
							} else {
								ib1.setUnit("");
							}
							
							try {
								if (!ib1.getUnit().equals("") && !ib1.getUnit().equals(null)) {

								} else {
									ib1.setUnit("");
								}
							} catch (Exception e) {
								ib1.setUnit("");
								// TODO: handle exception
							}

							// ib1.setUnit1(unit);
							ib1.setTaxqmount(ib.getGstamount1()[j1]);
							
							
							
							/// If Discount available///
							try {
								ib1.setAmount(ib.getAmtwithdisc()[j1]);
								Double q1 = Double.parseDouble(ib.getAmtwithdisc()[j1]);

								ib1.setAmount("" + String.format("%.2f", q1));
							} catch (Exception e) {
								// TODO: handle exception
							}

							
							
								
							
							
							try {
								Double q = Double.parseDouble(ib.getQuantity1()[j1]);
								//System.out.println(">>>" + q);
								tqty=tqty+q;
								ib1.setQuantity(String.format("%.2f", q));

							} catch (Exception e) {
								// TODO: handle exception
								ib1.setQuantity("0.00");
							}

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getAmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum = tot1 + sum;
							}
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);

							}

							ib1.setVat(ib.getVat1()[j1]);

							ib1.setTaxqmount(ib.getTaxqmount1()[j1]);

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum1 = tot1 + sum1;

							}

							ib1.setVatamount(ib.getVatamount1()[j1]);
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum2 = tot1 + sum2;

							}
							// LABOURR.....

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getAmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum3 = tot1 + sum3;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum4 = tot1 + sum4;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum5 = tot1 + sum5;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);
								//System.out.println("srno" + ib1.getSn());

							}

							// TOTAL

							String tot = ib1.getAmount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sumt1 = tot1 + sumt1;
							ib1.setTaxqmount(ib.getGstamount1()[j1]);
							String tot3 = ib1.getTaxqmount();
							double tot8 = 0.00;

							try {
								tot8 = Double.parseDouble(tot3);
							} catch (Exception e) {
								// TODO: handle exception
								tot8 = 0.00;
							}

							sumt2 = tot8 + sumt2;

							String tot99 = ib1.getVatamount();
							double tot88 = 0.00;

							try {
								tot88 = Double.parseDouble(tot99);
							} catch (Exception e) {
								// TODO: handle exception
								tot88 = 0.00;
							}

							sumt3 = tot88 + sumt3;

							invoicebean_1.add(ib1);

						}
					}
					
					
					
					
					
					
					try {
						
						
						PreparedStatement preparedStatementxh = conn
								.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvno() + "'");
						
						//System.out.println("SQL>>"+preparedStatementxh);
						
						ResultSet resultSetxh = preparedStatementxh.executeQuery();
						
						while (resultSetxh.next()) {
							invoicebean1 ib2h = new invoicebean1();
							
							ib2h.setHsn(resultSetxh.getString("hsncode"));
							ib2h.setTaxablevalue(resultSetxh.getString("taxablevalue"));
							
							ib2h.setSrate(resultSetxh.getString("sgstrate"));
							ib2h.setCrate(resultSetxh.getString("cgstrate"));
							ib2h.setSamount(resultSetxh.getString("sgstamount"));
							
							ib2h.setCamount(resultSetxh.getString("cgstamount"));
							
							
							invoicebean.add(ib2h);
							
						}
						
					} catch (Exception e) {
						
						// TODO: handle exception
					}
					
					
					// nettparts=;
					nettparts = Math.round(sum * 100) / 100.00;
					nparts = "" + String.format("%.2f", nettparts);

					ttttparts = Math.round(sum1 * 100) / 100.00;

					tparts = "" + String.format("%.2f", ttttparts);
					// tnttparts=;
					tnttparts = Math.round(sum2 * 100) / 100.00;
					// DecimalFormat df= new DecimalFormat("#.##");
					// df.format(tnttparts);
					nntparts = "" + String.format("%.2f", tnttparts);

					// LABOURRR

					// labour1=sum3;
					labour1 = Math.round(sum3 * 100) / 100.00;
					LABAMT = "" + String.format("%.2f", labour1);

					// labour2=;
					labour2 = Math.round(sum4 * 100) / 100.00;
					LABTAX = "" + String.format("%.2f", labour2);
					// =sum5;
					labour3 = Math.round(sum5 * 100) / 100.00;
					LABNET = "" + String.format("%.2f", labour3);
					// TOTALLL

					// =sumt1;
					total1 = Math.round(sumt1 * 100) / 100.00;
					netamt = "" + String.format("%.2f", total1);

					// =sumt2;
					total2 = Math.round(sumt2 * 100) / 100.00;
					naettax = "" + String.format("%.2f", total2 + total2);
					// =sumt3;
					total3 = Math.round(sumt3);
					// Math.round(total3);
					gross = "" + String.format("%.2f", total3);
					BigDecimal tabono = BigDecimal.ZERO;
					ib.setHh1( String.format("%.2f", tqty));
					ib.setTparts(tparts);
					ib.setNtparts(nparts);
					ib.setLAB2(LABTAX);
					ib.setLAB1(LABAMT);
					ib.setLAB3(LABNET);
					ib.setNntparts(nntparts);
					ib.setNetamt(netamt);
					ib.setTax(naettax);
					ib.setCgst("" + String.format("%.2f", cgst));
					ib.setSgst("" + String.format("%.2f", sgst));
					ib.setGrossamt(gross);

					double gtotal = 0.00;
					double freight = 0.00;
					double transport = 0.00;

					try {
						freight = Double.parseDouble(ib.getFreight());
					} catch (Exception e) {
						// TODO: handle exception
						freight = 0.00;
					}

					try {
						transport = Double.parseDouble(ib.getTransport());
					} catch (Exception e) {
						// transport: handle exception
						transport = 0.00;
					}

					ib.setFreight("" + String.format("%.2f", freight));
					ib.setTransport("" + String.format("%.2f", transport));

					gtotal = total3 + freight + transport;

					ib.setGgtotal("" + String.format("%.2f", gtotal));

					// collectiontable
					for (int j1 = 0; j1 < ib.getT().length; j1++) {

						invoicebean1 ib2 = new invoicebean1();

						ib2.setVvtaxtype(ib.getT()[j1]);

						ib2.setVvtaxableamt(ib.getA()[j1]);

						ib2.setVvtax(ib.getA2()[j1]);

						invoicebean_5.add(ib2);

					}

					try {
						String WholeNumber = "", Decimal = "";
						String StringOfOne = ib.getGgtotal();

						boolean isDecimal = false;

						int decimalIndex = StringOfOne.lastIndexOf(".");

						if (decimalIndex >= 0) {
							WholeNumber = StringOfOne.substring(0, decimalIndex);
							Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
									+ StringOfOne.substring(StringOfOne.length());

							// now you have the WholeNumber split up.
							isDecimal = true;
						} else {
							WholeNumber = ib.getGrossamt();
						}

						if (isDecimal) {
							String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
							ib.setAmountinwords(temp.toUpperCase());

						} else {
							String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(ib.getGrossamt()))
									+ "  only";
							ib.setAmountinwords(temp.toUpperCase());

						}

						 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

						 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
					} catch (Exception e) {
						System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
					}

					

				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		
		if (response.equals("success")) {
			// request.setAttribute("role_bean",Job_card_bean);
			//System.out.println("11");
			
			answer = "print3";
			
			//System.out.println("22");
			
		} else {
			answer = "fail";
		}*/
		
		
		DBConnection.closeConnection();
		
		return "success";

	}

	
	
	
	
	public String Add_invoice_Customer() throws Exception {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;
		
		
		
		response = new invoice_dao1().Add_invoice_Customer(ib,bean);
		
	
		if (response.equals("success")) {

			
			flag = 0;
		}
		
		else {
			flag = 1;
		}
		
		//System.out.println("Flag::"+flag);
		

		if (flag == 0) {
			
			
			 DBConnection connection=new DBConnection();
			 
			 Connection con = connection.getConnection();
			
			
			int labourc = 0;
			int partsc = 0;
			tqty=0.0;
			pono = ib.getPono();
			podate = ib.getPodate();
			termcond = ib.getTermcond();
			vendor = ib.getVendor();
			dcnox = ib.getDcnox();
			dcdatex = ib.getDcdatex();

			transmode = ib.getTransmode();
			contactp = ib.getContactp();
			contactpno = ib.getContactpno();
			try {
				shipparty = ib.getShipparty().trim();
			} catch (Exception e) {
			}

			try {
				shipadd = ib.getShipadd().trim();
			} catch (Exception e) {
			}
			try {
				shipgstn = ib.getShipgstn().trim();
			} catch (Exception e) {
			}
			try {
				shipstate = ib.getShipstate().trim();
			} catch (Exception e) {
			}
			vehino = ib.getVehino();

			System.out.println(">>>dcno" + dcnox);
			
			
	
			

			try {
				
				
				 PreparedStatement preparedStatementx = con
						.prepareStatement("select * from customer_master_details where customer_no='" + ib.getCustomer_Id() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				
				if (resultSetx.next()) {
					ib.setCustomer_name(resultSetx.getString("customer_name"));
					ib.setAddress(resultSetx.getString("customer_address"));
					ib.setVat("customer_gst_no");
					ib.setCust_subname("");
					ib.setState("state");
					String mob = "mobile_no";

					try {
						if (!resultSetx.getString("mobile_no").equals("")
								&& !resultSetx.getString("mobile_no").equals(null)) {
							mob = resultSetx.getString("mobile_no");
						}
					} catch (Exception e) {
						// TODO: handle exception
						mob = "";
					}

					ib.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}
				
				
			}catch(Exception e){}

			double cgst = 0.0;
			double sgst = 0.0;
			int rr = 0;
			int rr1 = 0;
					
			try {
			
					for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
						
						
							invoicebean1 ib1 = new invoicebean1();

							ib1.setType_1(ib.getBtype()[j1]);

							ib1.setDescription(ib.getDescription1()[j1]);
							ib1.setTax_type(ib.getTtype()[j1]);
							ib1.setGr1(ib.getGrate1()[j1]);
							ib1.setGr2(ib.getGrate2()[j1]);
							ib1.setGsa1(ib.getGstamount1()[j1]);
							ib1.setPartnoo(ib.getPartno()[j1]);
							ib1.setPartdatee(ib.getPartdate()[j1]);
							ib1.setPartnoox(ib.getPartnox()[j1]);
							ib1.setGsa2(ib.getGstamount2()[j1]);
							ib1.setDisc1(ib.getDisc()[j1]);
							
							ib1.setBatch22(ib.getA2()[j1]);
							
							//ib1.setQuantity(ib.getQuantity1()[j1]);
							
							ib1.setVatamount(ib.getVatamount1()[j1]);
							
							ib1.setMyrate1(ib.getMyrate()[j1]);

						
								ib1.setUnit("");
							
							

							// ib1.setUnit1(unit);
							//ib1.setTaxqmount(ib.getGstamount1()[j1]);
							
							
							
						
							
							//ib1.setAmount(ib.getAmount1()[j1]);
							
							
							
							try {
								cgst = cgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {

							}
							try {
								sgst = sgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {
							}

							//ib1.setMyrate1(ib.getMyrate()[j1]);

							
							//ib1.setTaxqmount(ib.getGstamount1()[j1]);
							
							try {
								ib1.setAmount(ib.getAmount1()[j1]);
								Double q1 = Double.parseDouble(ib.getAmount1()[j1]);

								ib1.setAmount("" + String.format("%.2f", q1));
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {
								Double q = Double.parseDouble(ib.getQuantity1()[j1]);
								System.out.println(">>>" + q);
								tqty=tqty+q;
								ib1.setQuantity(String.format("%.2f", q));

							} catch (Exception e) {
								// TODO: handle exception
								ib1.setQuantity("0.00");
							}

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getAmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum = tot1 + sum;
							}
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);

							}

							ib1.setVat(ib.getVat1()[j1]);

							ib1.setTaxqmount(ib.getTaxqmount1()[j1]);

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum1 = tot1 + sum1;

							}

							ib1.setVatamount(ib.getVatamount1()[j1]);
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum2 = tot1 + sum2;

							}
							// LABOURR.....

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getAmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum3 = tot1 + sum3;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum4 = tot1 + sum4;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum5 = tot1 + sum5;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);
								System.out.println("srno" + ib1.getSn());

							}

							// TOTAL

							String tot = ib1.getAmount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sumt1 = tot1 + sumt1;
							ib1.setTaxqmount(ib.getGstamount1()[j1]);
							String tot3 = ib1.getTaxqmount();
							double tot8 = 0.00;

							try {
								tot8 = Double.parseDouble(tot3);
							} catch (Exception e) {
								// TODO: handle exception
								tot8 = 0.00;
							}

							sumt2 = tot8 + sumt2;

							String tot99 = ib1.getVatamount();
							double tot88 = 0.00;

							try {
								tot88 = Double.parseDouble(tot99);
							} catch (Exception e) {
								// TODO: handle exception
								tot88 = 0.00;
							}

							sumt3 = tot88 + sumt3;
							
							invoicebean_1.add(ib1);

							

						
					}
					
			}catch(Exception e)
			{}
					
					
					try {
						
						
						PreparedStatement preparedStatementxh = con
								.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvoiceno() + "'");
						System.out.println(preparedStatementxh);
						ResultSet resultSetxh = preparedStatementxh.executeQuery();
						while (resultSetxh.next()) {
							invoicebean1 ib2h = new invoicebean1();
							
							ib2h.setHsn(resultSetxh.getString("hsncode"));
							ib2h.setTaxablevalue(resultSetxh.getString("taxablevalue"));
							
							ib2h.setSrate(resultSetxh.getString("sgstrate"));
							ib2h.setCrate(resultSetxh.getString("cgstrate"));
							ib2h.setSamount(resultSetxh.getString("sgstamount"));
							
							ib2h.setCamount(resultSetxh.getString("cgstamount"));
							
							
							invoicebean.add(ib2h);
							
						}
						
					} catch (Exception e) {
						
						// TODO: handle exception
					}
					
					
					
					
					
					
					
					
					
					
try {
			
						PreparedStatement pst=con.prepareStatement("SELECT * FROM lr where LR_no='"+ib.getAa()[0]+"'");
						
						ResultSet rs=pst.executeQuery();
						
						
						System.out.println("1...."+pst);
						
						
						
						while(rs.next())
						{	
							
							
							
							from=rs.getString("source");
							to=rs.getString("destination");
							
							consigner=rs.getString("loadname");
							
							consignee=rs.getString("shipname");
							
							
							
						}
						
					} catch (Exception e) {
						
						// TODO: handle exception
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					

					double gtotal = 0.00;
					double freight = 0.00;
					double transport = 0.00;
					
					
					nettparts = Math.round(sum * 100) / 100.00;
					nparts = "" + String.format("%.2f", nettparts);

					ttttparts = Math.round(sum1 * 100) / 100.00;

					tparts = "" + String.format("%.2f", ttttparts);
					// tnttparts=;
					tnttparts = Math.round(sum2 * 100) / 100.00;
					// DecimalFormat df= new DecimalFormat("#.##");
					// df.format(tnttparts);
					nntparts = "" + String.format("%.2f", tnttparts);

					// LABOURRR

					// labour1=sum3;
					labour1 = Math.round(sum3 * 100) / 100.00;
					LABAMT = "" + String.format("%.2f", labour1);

					// labour2=;
					labour2 = Math.round(sum4 * 100) / 100.00;
					LABTAX = "" + String.format("%.2f", labour2);
					// =sum5;
					labour3 = Math.round(sum5 * 100) / 100.00;
					LABNET = "" + String.format("%.2f", labour3);
					// TOTALLL

					// =sumt1;
					total1 = Math.round(sumt1 * 100) / 100.00;
					netamt = "" + String.format("%.2f", total1);

					// =sumt2;
					total2 = Math.round(sumt2 * 100) / 100.00;
					naettax = "" + String.format("%.2f", total2 + total2);
					// =sumt3;
					total3 = Math.round(sumt3);
					// Math.round(total3);
					gross = "" + String.format("%.2f", total3);
					BigDecimal tabono = BigDecimal.ZERO;
					ib.setHh1( String.format("%.2f", tqty));
					ib.setTparts(tparts);
					ib.setNtparts(nparts);
					ib.setLAB2(LABTAX);
					ib.setLAB1(LABAMT);
					ib.setLAB3(LABNET);
					ib.setNntparts(nntparts);
					ib.setNetamt(netamt);
					ib.setTax(naettax);
					ib.setCgst("" + String.format("%.2f", cgst));
					ib.setSgst("" + String.format("%.2f", sgst));
					ib.setGrossamt(gross);
					
					
					
					

					try {
						freight = Double.parseDouble(ib.getFreight());
					} catch (Exception e) {
						// TODO: handle exception
						freight = 0.00;
					}

					try {
						transport = Double.parseDouble(ib.getTransport());
					} catch (Exception e) {
						// transport: handle exception
						transport = 0.00;
					}

					ib.setFreight("" + String.format("%.2f", freight));
					ib.setTransport("" + String.format("%.2f", transport));

					gtotal = total3 + freight + transport;

					ib.setGgtotal("" + String.format("%.2f", gtotal));

					// collectiontable
					for (int j1 = 0; j1 < ib.getT().length; j1++) {

						invoicebean1 ib2 = new invoicebean1();

						ib2.setVvtaxtype(ib.getT()[j1]);

						ib2.setVvtaxableamt(ib.getA()[j1]);

						ib2.setVvtax(ib.getA2()[j1]);

						invoicebean_5.add(ib2);

					}

					try {
						String WholeNumber = "", Decimal = "";
						String StringOfOne = ib.getGgtotal();

						boolean isDecimal = false;

						int decimalIndex = StringOfOne.lastIndexOf(".");

						if (decimalIndex >= 0) {
							WholeNumber = StringOfOne.substring(0, decimalIndex);
							Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
									+ StringOfOne.substring(StringOfOne.length());

							// now you have the WholeNumber split up.
							isDecimal = true;
						} else {
							WholeNumber = ib.getGrossamt();
						}

						if (isDecimal) {
							String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
							ib.setAmountinwords(temp.toUpperCase());

						} else {
							String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(ib.getGrossamt()))
									+ "  only";
							ib.setAmountinwords(temp.toUpperCase());

						}

						// ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

						// System.out.println("Amount in Words :
						// "+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
					} catch (Exception e) {
						System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
					}

					if (response.equalsIgnoreCase("")) {
						// request.setAttribute("role_bean",Job_card_bean);
						answer = "fail";
					} else {
						answer = "print3";
					}

				

			} 

		
		
		if (response.equals("success")) {
			// request.setAttribute("role_bean",Job_card_bean);
			//System.out.println("11");
			
			answer = "print3";
			
			//System.out.println("22");
			
		} else {
			answer = "fail";
		}
		
		
		DBConnection.closeConnection();
		
		
		
		System.out.println("Length:"+invoicebean_1.size());
		
		return "success";

	}
	
	
	
	
	
	
	
	
	public String Add_invoice_Customer_Igst() throws Exception {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;
		
		
		
		response = new invoice_dao1().Add_invoice_Customer_Igst(ib,bean);
		
	
		if (response.equals("success")) {

			
			flag = 0;
		}
		
		else {
			flag = 1;
		}
		
		//System.out.println("Flag::"+flag);
		

		if (flag == 0) {
			
			
			 DBConnection connection=new DBConnection();
			 
			 Connection con = connection.getConnection();
			
			
			int labourc = 0;
			int partsc = 0;
			tqty=0.0;
			pono = ib.getPono();
			podate = ib.getPodate();
			termcond = ib.getTermcond();
			vendor = ib.getVendor();
			dcnox = ib.getDcnox();
			dcdatex = ib.getDcdatex();

			transmode = ib.getTransmode();
			contactp = ib.getContactp();
			contactpno = ib.getContactpno();
			try {
				shipparty = ib.getShipparty().trim();
			} catch (Exception e) {
			}

			try {
				shipadd = ib.getShipadd().trim();
			} catch (Exception e) {
			}
			try {
				shipgstn = ib.getShipgstn().trim();
			} catch (Exception e) {
			}
			try {
				shipstate = ib.getShipstate().trim();
			} catch (Exception e) {
			}
			vehino = ib.getVehino();

			System.out.println(">>>dcno" + dcnox);
			
			
	
			

			try {
				
				
				 PreparedStatement preparedStatementx = con
						.prepareStatement("select * from customer_master_details where customer_no='" + ib.getCustomer_Id() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				
				if (resultSetx.next()) {
					ib.setCustomer_name(resultSetx.getString("customer_name"));
					ib.setAddress(resultSetx.getString("customer_address"));
					ib.setVat("customer_gst_no");
					ib.setCust_subname("");
					ib.setState("state");
					String mob = "mobile_no";

					try {
						if (!resultSetx.getString("mobile_no").equals("")
								&& !resultSetx.getString("mobile_no").equals(null)) {
							mob = resultSetx.getString("mobile_no");
						}
					} catch (Exception e) {
						// TODO: handle exception
						mob = "";
					}

					ib.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}
				
				
			}catch(Exception e){}

			double cgst = 0.0;
			double sgst = 0.0;
			int rr = 0;
			int rr1 = 0;
					
			try {
			
					for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
						
						
							invoicebean1 ib1 = new invoicebean1();

							ib1.setType_1(ib.getBtype()[j1]);

							ib1.setDescription(ib.getDescription1()[j1]);
							ib1.setTax_type(ib.getTtype()[j1]);
							ib1.setGr1(ib.getGrate1()[j1]);
							//ib1.setGr2(ib.getGrate2()[j1]);
							ib1.setGsa1(ib.getGstamount1()[j1]);
							ib1.setPartnoo(ib.getPartno()[j1]);
							ib1.setPartdatee(ib.getPartdate()[j1]);
							ib1.setPartnoox(ib.getPartnox()[j1]);
							//ib1.setGsa2(ib.getGstamount2()[j1]);
							ib1.setDisc1(ib.getDisc()[j1]);
							
							ib1.setBatch22(ib.getAa()[j1]);
							
							//ib1.setQuantity(ib.getQuantity1()[j1]);
							
							ib1.setVatamount(ib.getVatamount1()[j1]);
							
							ib1.setMyrate1(ib.getMyrate()[j1]);

						
								ib1.setUnit("");
							
							

							// ib1.setUnit1(unit);
							//ib1.setTaxqmount(ib.getGstamount1()[j1]);
							
							
							
						
							
							//ib1.setAmount(ib.getAmount1()[j1]);
							
							
							
							try {
								cgst = cgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {

							}
							try {
								sgst = sgst + Double.parseDouble(ib.getGstamount1()[j1]);
							} catch (Exception e) {
							}

							//ib1.setMyrate1(ib.getMyrate()[j1]);

							
							//ib1.setTaxqmount(ib.getGstamount1()[j1]);
							
							try {
								ib1.setAmount(ib.getAmount1()[j1]);
								Double q1 = Double.parseDouble(ib.getAmount1()[j1]);

								ib1.setAmount("" + String.format("%.2f", q1));
							} catch (Exception e) {
								// TODO: handle exception
							}

							try {
								Double q = Double.parseDouble(ib.getQuantity1()[j1]);
								System.out.println(">>>" + q);
								tqty=tqty+q;
								ib1.setQuantity(String.format("%.2f", q));

							} catch (Exception e) {
								// TODO: handle exception
								ib1.setQuantity("0.00");
							}

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getAmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum = tot1 + sum;
							}
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);

							}

							ib1.setVat(ib.getVat1()[j1]);

							ib1.setTaxqmount(ib.getTaxqmount1()[j1]);

							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.0;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.0;
								}

								sum1 = tot1 + sum1;

							}

							ib1.setVatamount(ib.getVatamount1()[j1]);
							if (ib1.getType_1().equalsIgnoreCase("parts")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum2 = tot1 + sum2;

							}
							// LABOURR.....

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getAmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum3 = tot1 + sum3;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getTaxqmount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum4 = tot1 + sum4;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								String tot = ib1.getVatamount();
								double tot1 = 0.00;

								try {
									tot1 = Double.parseDouble(tot);
								} catch (Exception e) {
									// TODO: handle exception
									tot1 = 0.00;
								}

								sum5 = tot1 + sum5;

							}

							if (ib1.getType_1().equalsIgnoreCase("labour")) {

								rr = rr + 1;
								;
								String sn = "" + rr;

								ib1.setSn(sn);
								System.out.println("srno" + ib1.getSn());

							}

							// TOTAL

							String tot = ib1.getAmount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sumt1 = tot1 + sumt1;
							ib1.setTaxqmount(ib.getGstamount1()[j1]);
							String tot3 = ib1.getTaxqmount();
							double tot8 = 0.00;

							try {
								tot8 = Double.parseDouble(tot3);
							} catch (Exception e) {
								// TODO: handle exception
								tot8 = 0.00;
							}

							sumt2 = tot8 + sumt2;

							String tot99 = ib1.getVatamount();
							double tot88 = 0.00;

							try {
								tot88 = Double.parseDouble(tot99);
							} catch (Exception e) {
								// TODO: handle exception
								tot88 = 0.00;
							}

							sumt3 = tot88 + sumt3;
							
							invoicebean_1.add(ib1);

							

						
					}
					
			}catch(Exception e)
			{}
					
					
					try {
						
						
						PreparedStatement preparedStatementxh = con
								.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvoiceno() + "'");
						System.out.println(preparedStatementxh);
						ResultSet resultSetxh = preparedStatementxh.executeQuery();
						while (resultSetxh.next()) {
							invoicebean1 ib2h = new invoicebean1();
							
							ib2h.setHsn(resultSetxh.getString("hsncode"));
							ib2h.setTaxablevalue(resultSetxh.getString("taxablevalue"));
							
							ib2h.setSrate(resultSetxh.getString("sgstrate"));
							ib2h.setCrate(resultSetxh.getString("cgstrate"));
							ib2h.setSamount(resultSetxh.getString("sgstamount"));
							
							ib2h.setCamount(resultSetxh.getString("cgstamount"));
							
							
							invoicebean.add(ib2h);
							
						}
						
					} catch (Exception e) {
						
						// TODO: handle exception
					}
					
					
					try {
						
						PreparedStatement pst=con.prepareStatement("SELECT * FROM lr where LR_no='"+ib.getAa()[0]+"'");
						
						ResultSet rs=pst.executeQuery();
						
						
						System.out.println("1...."+pst);
						
						
						
						while(rs.next())
						{	
							
							
							
							from=rs.getString("source");
							to=rs.getString("destination");
							
							consigner=rs.getString("loadname");
							
							consignee=rs.getString("shipname");
							
							
							
						}
						
					} catch (Exception e) {
						
						// TODO: handle exception
					}
					
		
					double gtotal = 0.00;
					double freight = 0.00;
					double transport = 0.00;
					
					
					nettparts = Math.round(sum * 100) / 100.00;
					nparts = "" + String.format("%.2f", nettparts);

					ttttparts = Math.round(sum1 * 100) / 100.00;

					tparts = "" + String.format("%.2f", ttttparts);
					// tnttparts=;
					tnttparts = Math.round(sum2 * 100) / 100.00;
					// DecimalFormat df= new DecimalFormat("#.##");
					// df.format(tnttparts);
					nntparts = "" + String.format("%.2f", tnttparts);

					// LABOURRR

					// labour1=sum3;
					labour1 = Math.round(sum3 * 100) / 100.00;
					LABAMT = "" + String.format("%.2f", labour1);

					// labour2=;
					labour2 = Math.round(sum4 * 100) / 100.00;
					LABTAX = "" + String.format("%.2f", labour2);
					// =sum5;
					labour3 = Math.round(sum5 * 100) / 100.00;
					LABNET = "" + String.format("%.2f", labour3);
					// TOTALLL

					// =sumt1;
					total1 = Math.round(sumt1 * 100) / 100.00;
					netamt = "" + String.format("%.2f", total1);

					// =sumt2;
					total2 = Math.round(sumt2 * 100) / 100.00;
					naettax = "" + String.format("%.2f", total2 );
					// =sumt3;
					total3 = Math.round(sumt3);
					// Math.round(total3);
					gross = "" + String.format("%.2f", total3);
					BigDecimal tabono = BigDecimal.ZERO;
					ib.setHh1( String.format("%.2f", tqty));
					ib.setTparts(tparts);
					ib.setNtparts(nparts);
					ib.setLAB2(LABTAX);
					ib.setLAB1(LABAMT);
					ib.setLAB3(LABNET);
					ib.setNntparts(nntparts);
					ib.setNetamt(netamt);
					ib.setTax(naettax);
					ib.setCgst("" + String.format("%.2f", cgst));
					ib.setSgst("" + String.format("%.2f", sgst));
					ib.setGrossamt(gross);
					
					
					
					

					try {
						freight = Double.parseDouble(ib.getFreight());
					} catch (Exception e) {
						// TODO: handle exception
						freight = 0.00;
					}

					try {
						transport = Double.parseDouble(ib.getTransport());
					} catch (Exception e) {
						// transport: handle exception
						transport = 0.00;
					}

					ib.setFreight("" + String.format("%.2f", freight));
					ib.setTransport("" + String.format("%.2f", transport));

					gtotal = total3 + freight + transport;

					ib.setGgtotal("" + String.format("%.2f", gtotal));

					// collectiontable
					for (int j1 = 0; j1 < ib.getT().length; j1++) {

						invoicebean1 ib2 = new invoicebean1();

						ib2.setVvtaxtype(ib.getT()[j1]);

						ib2.setVvtaxableamt(ib.getA()[j1]);

						ib2.setVvtax(ib.getA2()[j1]);

						invoicebean_5.add(ib2);

					}

					try {
						String WholeNumber = "", Decimal = "";
						String StringOfOne = ib.getGgtotal();

						boolean isDecimal = false;

						int decimalIndex = StringOfOne.lastIndexOf(".");

						if (decimalIndex >= 0) {
							WholeNumber = StringOfOne.substring(0, decimalIndex);
							Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
									+ StringOfOne.substring(StringOfOne.length());

							// now you have the WholeNumber split up.
							isDecimal = true;
						} else {
							WholeNumber = ib.getGrossamt();
						}

						if (isDecimal) {
							String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
							ib.setAmountinwords(temp.toUpperCase());

						} else {
							String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(ib.getGrossamt()))
									+ "  only";
							ib.setAmountinwords(temp.toUpperCase());

						}

						// ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

						// System.out.println("Amount in Words :
						// "+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
					} catch (Exception e) {
						System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
					}

					if (response.equalsIgnoreCase("")) {
						// request.setAttribute("role_bean",Job_card_bean);
						answer = "fail";
					} else {
						answer = "print3";
					}

				

			} 

		
		
		if (response.equals("success")) {
			// request.setAttribute("role_bean",Job_card_bean);
			//System.out.println("11");
			
			answer = "print3";
			
			//System.out.println("22");
			
		} else {
			answer = "fail";
		}
		
		
		DBConnection.closeConnection();
		
		
		
		System.out.println("Length:"+invoicebean_1.size());
		
		return "success";

	}
	
	public String Add_New_invoice_igst() throws IOException, SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;
		
		
	
	
		
		try {
			response = new invoice_dao1().insertCustomerInfoIgst(ib,bean);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Response:"+response);

		if (response.equals("success")) {

			
			flag = 0;
		}
		
		else {
			flag = 1;
		}
		
		System.out.println("Flag::"+flag);
		
		

		if (flag == 0) {
			
			Connection conn=connection.getConnection();
		
		int labourc = 0;
		int partsc = 0;
		pono = ib.getPono();
		podate = ib.getPodate();
		termcond = ib.getTermcond();
		vendor = ib.getVendor();

		for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
			if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
				if (ib.getBtype()[j1].equals("parts")) {
					partsc++;
				}

				if (ib.getBtype()[j1].equals("labour")) {
					labourc++;
				}

			}
		}

		labourcount = labourc;
		partscount = partsc;

		try {
			
			PreparedStatement preparedStatementx = conn
					.prepareStatement("select * from destributor_master where destributor_id='" + ib.getCustomer_Id() + "'");

			ResultSet resultSetx = preparedStatementx.executeQuery();
			if (resultSetx.next()) {
				ib.setCustomer_name(resultSetx.getString("name"));
				ib.setAddress(resultSetx.getString("address"));
				ib.setVat(resultSetx.getString("gstn"));
				//ib.setCust_subname(resultSetx.getString("cust_subname"));
				ib.setState(resultSetx.getString("state"));
				String mob = "";

				/*try {
					if (!resultSetx.getString("phone_no").equals("")
							&& !resultSetx.getString("phone_no").equals(null)) {
						mob = resultSetx.getString("phone_no");
					}
				} catch (Exception e) {
					// TODO: handle exception
					mob = "";
				}*/

				ib.setMobile(resultSetx.getString("mobile_no") + " " + mob);

			
			}

			if (ib.getPrintbutton2().equalsIgnoreCase("printbutton2")) {

				int rr = 0;
				int rr1 = 0;
				double cgst = 0.0;
				double sgst = 0.0;
				for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
					if (!ib.getDescription1()[j1].trim().equals("") && !ib.getDescription1()[j1].trim().equals(null)) {
						invoicebean1 ib1 = new invoicebean1();

						ib1.setType_1(ib.getBtype()[j1]);

						ib1.setDescription(ib.getDescription1()[j1]);
						ib1.setTax_type(ib.getTtype()[j1]);
						ib1.setGr1(ib.getGrate1()[j1]);
						ib1.setGr2(ib.getGrate2()[j1]);
						ib1.setGsa1(ib.getGstamount1()[j1]);
						ib1.setPartnoo(ib.getPartno()[j1]);
						ib1.setPartdatee(ib.getPartdate()[j1]);
						ib1.setPartnoox(ib.getPartnox()[j1]);
						ib1.setDisc1(ib.getDisc()[j1]);
						ib1.setGsa2(ib.getGstamount2()[j1]);
						
						ib1.setBatch22(ib.getBatch1()[j1]);
						
						try {
							cgst = cgst + Double.parseDouble(ib.getGstamount1()[j1]);
						} catch (Exception e) {

						}
						try {
							sgst = sgst + Double.parseDouble(ib.getGstamount1()[j1]);
						} catch (Exception e) {
						}

						ib1.setMyrate1(ib.getMyrate()[j1]);

						
						
						PreparedStatement preparedStatementx1 = conn
								.prepareStatement("select type from bag_config_master where bag_name='"
										+ ib.getDescription1()[j1] + "'");

						ResultSet resultSetx1 = preparedStatementx1.executeQuery();
						if (resultSetx1.next()) {
							ib1.setUnit(resultSetx1.getString("type"));
						} else {
							ib1.setUnit("");
						}
						try {
							if (!ib1.getUnit().equals("") && !ib1.getUnit().equals(null)) {

							} else {
								ib1.setUnit("");
							}
						} catch (Exception e) {
							ib1.setUnit("");
							// TODO: handle exception
						}

						// ib1.setUnit1(unit);
						
						
						/// If Discount available///
						try {
							ib1.setAmount(ib.getAmtwithdisc()[j1]);
							Double q1 = Double.parseDouble(ib.getAmtwithdisc()[j1]);

							ib1.setAmount("" + String.format("%.2f", q1));
						} catch (Exception e) {
							// TODO: handle exception
						}
						

						/*try {
							ib1.setAmount(ib.getAmount1()[j1]);
							Double q1 = Double.parseDouble(ib.getAmount1()[j1]);

							ib1.setAmount("" + String.format("%.2f", q1));
						} catch (Exception e) {
							// TODO: handle exception
						}*/
						
						
						

						try {
							Double q = Double.parseDouble(ib.getQuantity1()[j1]);
							System.out.println(">>>" + q);
							ib1.setQuantity(String.format("%.2f", q));

						} catch (Exception e) {
							// TODO: handle exception
							ib1.setQuantity("0.00");
						}

						if (ib1.getType_1().equalsIgnoreCase("parts")) {

							String tot = ib1.getAmount();
							double tot1 = 0.0;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.0;
							}

							sum = tot1 + sum;
						}
						if (ib1.getType_1().equalsIgnoreCase("parts")) {

							rr = rr + 1;
							;
							String sn = "" + rr;

							ib1.setSn(sn);

						}

						ib1.setVat(ib.getVat1()[j1]);

						ib1.setTaxqmount(ib.getTaxqmount1()[j1]);

						if (ib1.getType_1().equalsIgnoreCase("parts")) {

							String tot = ib1.getTaxqmount();
							double tot1 = 0.0;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.0;
							}

							sum1 = tot1 + sum1;

						}

						ib1.setVatamount(ib.getVatamount1()[j1]);
						if (ib1.getType_1().equalsIgnoreCase("parts")) {

							String tot = ib1.getVatamount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sum2 = tot1 + sum2;

						}
						// LABOURR.....

						if (ib1.getType_1().equalsIgnoreCase("labour")) {

							String tot = ib1.getAmount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sum3 = tot1 + sum3;

						}

						if (ib1.getType_1().equalsIgnoreCase("labour")) {

							String tot = ib1.getTaxqmount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sum4 = tot1 + sum4;

						}

						if (ib1.getType_1().equalsIgnoreCase("labour")) {

							String tot = ib1.getVatamount();
							double tot1 = 0.00;

							try {
								tot1 = Double.parseDouble(tot);
							} catch (Exception e) {
								// TODO: handle exception
								tot1 = 0.00;
							}

							sum5 = tot1 + sum5;

						}

						if (ib1.getType_1().equalsIgnoreCase("labour")) {

							rr = rr + 1;
							;
							String sn = "" + rr;

							ib1.setSn(sn);
							System.out.println("srno" + ib1.getSn());

						}

						// TOTAL

						String tot = ib1.getAmount();
						double tot1 = 0.00;

						try {
							tot1 = Double.parseDouble(tot);
						} catch (Exception e) {
							// TODO: handle exception
							tot1 = 0.00;
						}

						sumt1 = tot1 + sumt1;

						String tot3 = ib1.getTaxqmount();
						double tot8 = 0.00;

						try {
							tot8 = Double.parseDouble(tot3);
						} catch (Exception e) {
							// TODO: handle exception
							tot8 = 0.00;
						}

						sumt2 = tot8 + sumt2;

						String tot99 = ib1.getVatamount();
						double tot88 = 0.00;

						try {
							tot88 = Double.parseDouble(tot99);
						} catch (Exception e) {
							// TODO: handle exception
							tot88 = 0.00;
						}

						sumt3 = tot88 + sumt3;

						invoicebean_1.add(ib1);

					}
				}
				
				/*try
				{
					
					PreparedStatement pp = conn
							.prepareStatement("select * from scheme_details where order_id='"
									+ ib.getOrder_id() + "'");

					System.out.println("SQL:"+pp);
					
					ResultSet rss = pp.executeQuery();
					while (rss.next()) {
						
						invoicebean ib4 = new invoicebean();
						
						
						ib4.setSchemep(rss.getString("product_name"));
						ib4.setSchemeq(rss.getString("quantity"));
						ib4.setSchemeu(rss.getString("unit"));
						ib4.setSchemeb(rss.getString("batch"));
						
						
						PreparedStatement pp1 = conn
								.prepareStatement("select * from scheme_master where scheme_name='"
										+rss.getString("scheme_name")+ "'");

						System.out.println("SQL:"+pp1);
						
						ResultSet rss1 = pp1.executeQuery();
						if (rss1.next()) {
						
							ib4.setSchemeh(rss1.getString("hsn"));
							
						}
						
						
						invoicebean_2.add(ib4);
						
					} 
				}
				catch(Exception e)
				{
					
				}*/
				
				
				try {
					
					
					PreparedStatement preparedStatementxh = conn
							.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvoiceno() + "'");
System.out.println(preparedStatementxh);
					ResultSet resultSetxh = preparedStatementxh.executeQuery();
					while (resultSetxh.next()) {
						invoicebean1 ib2h = new invoicebean1();
						
						ib2h.setHsn(resultSetxh.getString("hsncode"));
						ib2h.setTaxablevalue(resultSetxh.getString("taxablevalue"));
						
						ib2h.setSrate(resultSetxh.getString("sgstrate"));
						ib2h.setCrate(resultSetxh.getString("cgstrate"));
						ib2h.setSamount(resultSetxh.getString("sgstamount"));
						
						ib2h.setCamount(resultSetxh.getString("cgstamount"));
						
						
						invoicebean.add(ib2h);
						
					}
					
				} catch (Exception e) {
					
					// TODO: handle exception
				}
				
				// nettparts=;
				nettparts = Math.round(sum * 100) / 100.00;
				nparts = "" + String.format("%.2f", nettparts);

				ttttparts = Math.round(sum1 * 100) / 100.00;

				tparts = "" + String.format("%.2f", ttttparts);
				// tnttparts=;
				tnttparts = Math.round(sum2 * 100) / 100.00;
				// DecimalFormat df= new DecimalFormat("#.##");
				// df.format(tnttparts);
				nntparts = "" + String.format("%.2f", tnttparts);

				// LABOURRR

				// labour1=sum3;
				labour1 = Math.round(sum3 * 100) / 100.00;
				LABAMT = "" + String.format("%.2f", labour1);

				// labour2=;
				labour2 = Math.round(sum4 * 100) / 100.00;
				LABTAX = "" + String.format("%.2f", labour2);
				// =sum5;
				labour3 = Math.round(sum5 * 100) / 100.00;
				LABNET = "" + String.format("%.2f", labour3);
				// TOTALLL

				// =sumt1;
				total1 = Math.round(sumt1 * 100) / 100.00;
				netamt = "" + String.format("%.2f", total1);

				// =sumt2;
				total2 = Math.round(sumt2 * 100) / 100.00;
				naettax = "" + String.format("%.2f", total2);
				// =sumt3;
				total3 = Math.round(sumt3);
				// Math.round(total3);
				gross = "" + String.format("%.2f", total3);
				BigDecimal tabono = BigDecimal.ZERO;

				ib.setTparts(tparts);
				ib.setNtparts(nparts);
				ib.setLAB2(LABTAX);
				ib.setLAB1(LABAMT);
				ib.setLAB3(LABNET);
				ib.setNntparts(nntparts);
				ib.setNetamt(netamt);
				ib.setTax(String.valueOf(cgst));
				ib.setCgst("" + String.format("%.2f", cgst));
				ib.setSgst("" + String.format("%.2f", sgst));
				ib.setGrossamt(gross);
				double gtotal = 0.00;
				double freight = 0.00;
				double transport = 0.00;
			

				try {
					freight = Double.parseDouble(ib.getFreight());
				} catch (Exception e) {
					// TODO: handle exception
					freight = 0.00;
				}

				try {
					transport = Double.parseDouble(ib.getTransport());
				} catch (Exception e) {
					// transport: handle exception
					transport = 0.00;
				}

				ib.setFreight("" + String.format("%.2f", freight));
				ib.setTransport("" + String.format("%.2f", transport));

				gtotal = total3 + freight + transport;

				ib.setGgtotal("" + String.format("%.2f", gtotal));

				// collectiontable
				for (int j1 = 0; j1 < ib.getT().length; j1++) {

					invoicebean1 ib2 = new invoicebean1();

					ib2.setVvtaxtype(ib.getT()[j1]);

					ib2.setVvtaxableamt(ib.getA()[j1]);

					ib2.setVvtax(ib.getA2()[j1]);

					invoicebean_5.add(ib2);

				}

				try {
					String WholeNumber = "", Decimal = "";
					String StringOfOne = ib.getGgtotal();

					boolean isDecimal = false;

					int decimalIndex = StringOfOne.lastIndexOf(".");

					if (decimalIndex >= 0) {
						WholeNumber = StringOfOne.substring(0, decimalIndex);
						Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
								+ StringOfOne.substring(StringOfOne.length());

						// now you have the WholeNumber split up.
						isDecimal = true;
					} else {
						WholeNumber = ib.getGgtotal();
					}

					if (isDecimal) {
						//String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
						//ib.setAmountinwords(temp.toUpperCase());

					} else {
						String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(ib.getGrossamt())) + "  only";
						ib.setAmountinwords(temp.toUpperCase());

					}

					// ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

					// System.out.println("Amount in Words :
					// "+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
				} catch (Exception e) {
					System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
				}

				if (response.equals("success")) {
					// request.setAttribute("role_bean",Job_card_bean);
					System.out.println("11");
					
					answer = "print3";
					
					System.out.println("22");
					
				} else {
					answer = "fail";
				}
				System.out.println("Answer:"+answer);
				
				System.out.println("Size :"+invoicebean_1.size());
				
				
				return answer;


			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		}
		try {
			DBConnection.closeConnection();

		} catch (Exception e) {

		}

		return answer;

	}

	
	
	
	// Method To Add Sales Retun
	
	public String Add_Sales_Return() throws IOException, SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;

		try {
			response = new invoice_dao1().insertSalesReturn(ib,bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (response.equals("Notsuffqty")) {

			answer = "Notsuffqty";

			
		} 
		if (response.equals("success")) {

			answer = "success";

			
		}
		else {
			answer = "fail";
		}
		
		return answer;

	

	}
	
	
	
	// Method to Add Sales Return Of Igst
	public String Add_Sales_Return_Igst() throws IOException, SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		int flag = 0;

		try {
			response = new invoice_dao1().insertSalesReturnIgst(ib,bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (response.equals("Notsuffqty")) {

			answer = "Notsuffqty";

			
		} 
		if (response.equals("success")) {

			answer = "success";

			
		}
		else {
			answer = "fail";
		}

		return answer;

	}
	
	public String Add_purchaseorder() throws SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		try {
			response = new invoice_dao1().Add_purchaseorder(ib,bean);
		
			if (response.equals("Already")) {

				return  "already";

				
			}
			else{
				
				return "success";
			}
			
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;

	}

	public Map getSession() {
		return session;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;

	}

	public LoginBean getBean() {
		return bean;
	}

	public void setBean(LoginBean bean) {
		this.bean = bean;
	}

	public invoicebean1 getIb() {
		return ib;
	}

	public void setIb(invoicebean1 ib) {
		this.ib = ib;
	}

	@Override
	public invoicebean1 getModel() {
		// TODO Auto-generated method stub
		return ib;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setInvoicebean_1(List<invoicebean1> invoicebean1_1) {
		this.invoicebean_1 = invoicebean_1;
	}

	public List<invoicebean1> getInvoicebean_1() {
		return invoicebean_1;
	}

	public void setInvoicebean_2(List<invoicebean1> invoicebean_2) {
		this.invoicebean_2 = invoicebean_2;
	}

	public List<invoicebean1> getInvoicebean_2() {
		return invoicebean_2;
	}

	public void setNparts(String nparts) {
		this.nparts = nparts;
	}

	public String getNparts() {
		return nparts;
	}

	public void setTparts(String tparts) {
		this.tparts = tparts;
	}

	public String getTparts() {
		return tparts;
	}

	public void setNntparts(String nntparts) {
		this.nntparts = nntparts;
	}

	public String getNntparts() {
		return nntparts;
	}

	public void setLABAMT(String lABAMT) {
		LABAMT = lABAMT;
	}

	public String getLABAMT() {
		return LABAMT;
	}

	public void setLABTAX(String lABTAX) {
		LABTAX = lABTAX;
	}

	public String getLABTAX() {
		return LABTAX;
	}

	public void setLABNET(String lABNET) {
		LABNET = lABNET;
	}

	public String getLABNET() {
		return LABNET;
	}

	public void setNetamt(String netamt) {
		this.netamt = netamt;
	}

	public String getNetamt() {
		return netamt;
	}

	public void setNaettax(String naettax) {
		this.naettax = naettax;
	}

	public String getNaettax() {
		return naettax;
	}

	public void setGross(String gross) {
		this.gross = gross;
	}

	public String getGross() {
		return gross;
	}

	public void setInvoicebean_5(List<invoicebean1> invoicebean_5) {
		this.invoicebean_5 = invoicebean_5;
	}

	public List<invoicebean1> getInvoicebean_5() {
		return invoicebean_5;
	}

	public void setPartscount(int partscount) {
		this.partscount = partscount;
	}

	public int getPartscount() {
		return partscount;
	}

	public void setLabourcount(int labourcount) {
		this.labourcount = labourcount;
	}

	public int getLabourcount() {
		return labourcount;
	}

	public String getPono() {
		return pono;
	}

	public void setPono(String pono) {
		this.pono = pono;
	}

	public String getPodate() {
		return podate;
	}

	public void setPodate(String podate) {
		this.podate = podate;
	}

	public String getTermcond() {
		return termcond;
	}

	public void setTermcond(String termcond) {
		this.termcond = termcond;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDcnox() {
		return dcnox;
	}

	public void setDcnox(String dcnox) {
		this.dcnox = dcnox;
	}

	public String getDcdatex() {
		return dcdatex;
	}

	public void setDcdatex(String dcdatex) {
		this.dcdatex = dcdatex;
	}

	public String getTransmode() {
		return transmode;
	}

	public void setTransmode(String transmode) {
		this.transmode = transmode;
	}

	public String getContactp() {
		return contactp;
	}

	public void setContactp(String contactp) {
		this.contactp = contactp;
	}

	public String getContactpno() {
		return contactpno;
	}

	public void setContactpno(String contactpno) {
		this.contactpno = contactpno;
	}

	public String getShipparty() {
		return shipparty;
	}

	public void setShipparty(String shipparty) {
		this.shipparty = shipparty;
	}

	public String getShipadd() {
		return shipadd;
	}

	public void setShipadd(String shipadd) {
		this.shipadd = shipadd;
	}

	public String getShipgstn() {
		return shipgstn;
	}

	public void setShipgstn(String shipgstn) {
		this.shipgstn = shipgstn;
	}

	public String getShipstate() {
		return shipstate;
	}

	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}

	public String getVehino() {
		return vehino;
	}

	public void setVehino(String vehino) {
		this.vehino = vehino;
	}

	public double getTransport() {
		return transport;
	}

	public void setTransport(double transport) {
		this.transport = transport;
	}

	public double getFreight() {
		return freight;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public double getGtot() {
		return gtot;
	}

	public void setGtot(double gtot) {
		this.gtot = gtot;
	}

	public List<invoicebean1> getInvoicebean() {
		return invoicebean;
	}

	public void setInvoicebean(List<invoicebean1> invoicebean) {
		this.invoicebean = invoicebean;
	}

	public Double getTqty() {
		return tqty;
	}

	public void setTqty(Double tqty) {
		this.tqty = tqty;
	}

	public String getT11qty() {
		return t11qty;
	}

	public void setT11qty(String t11qty) {
		this.t11qty = t11qty;
	}

}