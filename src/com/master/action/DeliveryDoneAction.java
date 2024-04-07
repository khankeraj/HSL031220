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

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
//import com.aqua.dao.Reports_Dao;
/*import com.aqua.dao.Cust_Master_dao;*/
import com.master.dao.DeliveryDoneDao;
import com.master.dao.TripDao;
import com.master.dao.invoice_dao;
import com.master.model.DeliveryModel;
import com.master.model.invoicebean;
import com.master.util.AmtInWord;
import com.master.util.EnglishNumberToWords;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeliveryDoneAction extends ActionSupport implements ServletRequestAware, SessionAware,ModelDriven{

	
	private DeliveryModel deliverymodel = new DeliveryModel();
	
	private String response;
	private String sparesize;
	private String graph;
	private String graph1;
	private String graph2;
	private String graph3;
	
	private String graph4;
	private String graph5;
	private String graph6;
	
private String graph7;
	
	private String graph8;
	private String graph9;
	private String graph10;
	
	private String vname="";
	private String vid="";
	
	
	private String bill_no="";
	private String delivery_done_id="";
	private String transporter_name="";
	private String transporter_code="";
	private String date="";
	private String total_amount="";
	
	
	
	
			
	

	public String getBill_no() {
		return bill_no;
	}



	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}



	public String getDelivery_done_id() {
		return delivery_done_id;
	}



	public void setDelivery_done_id(String delivery_done_id) {
		this.delivery_done_id = delivery_done_id;
	}



	public String getTransporter_name() {
		return transporter_name;
	}



	public void setTransporter_name(String transporter_name) {
		this.transporter_name = transporter_name;
	}



	public String getTransporter_code() {
		return transporter_code;
	}



	public void setTransporter_code(String transporter_code) {
		this.transporter_code = transporter_code;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getTotal_amount() {
		return total_amount;
	}



	public void setTotal_amount(String total_amount) {
		this.total_amount = total_amount;
	}






	public String getVname() {
		return vname;
	}



	public void setVname(String vname) {
		this.vname = vname;
	}



	public String getVid() {
		return vid;
	}



	public void setVid(String vid) {
		this.vid = vid;
	}



	HttpServletRequest request;



	private List<DeliveryModel> deliveryDetails;
	private List<DeliveryModel> deliveryDetails1 = new ArrayList<DeliveryModel>();
	
	







	public String deliveryDoneForm()
	{
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		String trip_id = request.getParameter("trip_id");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String vehicle_no = request.getParameter("vehicle_no");
		String driver_name = request.getParameter("driver_name");
		String updown_id = request.getParameter("updown_id");
		String updown = request.getParameter("updown");
		String customer_name = request.getParameter("customer_name");
		String lr_number  = request.getParameter("lr_number");
		String inquiry_id  = request.getParameter("inquiry_id");
		
		deliveryDetails = new DeliveryDoneDao().fetchDeliveryDoneDetails(trip_id, source, destination, vehicle_no, driver_name, updown_id, updown, customer_name, lr_number,bean,inquiry_id);
		
		System.out.println("Size : "+deliveryDetails.size());
		
		
		if(deliveryDetails.size()>0)
		
			return "success";
		
		else
			
			return "fail";
	}
	
	
	
	public String deliverydoneinsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		boolean sms = false;
		
		String status = new DeliveryDoneDao().insertDeliveryDoneDetails(deliverymodel,bean);
		
		//sms = new DeliveryDoneDao().send_ready_sms(deliverymodel);
		
		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";
			
		}
	}
	
	
	
	
	public String commissioninsert() throws SQLException {
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		String status = new DeliveryDoneDao().insertCommissionDetails(deliverymodel);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";
			
		}
	}
	
	public String commissioninsert1() throws SQLException {
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String transporter_name = request.getParameter("transporter_name");
		
		String status = new DeliveryDoneDao().insertCommissionDetails1(deliverymodel, transporter_name);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";
			
		}
	}
	
	
	public String fetchShortDetails1()
	{
		return "success";
	}
	
	public String fetchShortDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String customer_name = request.getParameter("customer_name");
		String driver_name = request.getParameter("driver_name");
		
		
		System.out.println("from date: "+from_date);
		System.out.println("to date: "+to_date);
		System.out.println("customer_name: "+customer_name);
		System.out.println("driver_name: "+driver_name);
		
		
		deliveryDetails=new DeliveryDoneDao().fetchShortDetails(from_date, to_date, customer_name, driver_name);
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	public String fetchDeliveryDoneDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		deliveryDetails=new DeliveryDoneDao().fetchDeliveryDoneDetails();
		
		System.out.println("Size -- -- - "+deliveryDetails.size());
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	public String fetchPIDoneDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		deliveryDetails=new DeliveryDoneDao().fetchPIDoneDetails();
		
		System.out.println("Size -- -- - "+deliveryDetails.size());
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	


	/*public String fetchMaintenanceDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);
		
		maintenanceDetails=new MaintenanceDao().fetchMaintenanceDetails(vehicle_no);
		System.out.println("Size -- -- - "+maintenanceDetails.size());
		if(maintenanceDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}*/
	
	
	
	
	public String commisionForm()
	{
		return "success";
	}

	
	
	
	public String invoiceForm()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String trip_id = request.getParameter("trip_id");
		String customer_name = request.getParameter("customer_name");
		String transporter_name = request.getParameter("transporter_name");
		String updown_id = request.getParameter("updown_id");
		String lr_number = request.getParameter("lr_number");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String vehicle_no = request.getParameter("vehicle_no");
		String driver_name = request.getParameter("driver_name");
		String total_amount = request.getParameter("total_amount");
		
		System.out.println("Lr number : "+lr_number);
		
		deliveryDetails = new DeliveryDoneDao().fetchForInvoice(lr_number);
		
		
		System.out.println("size : "+deliveryDetails.size());
		
		deliverymodel = new DeliveryDoneDao().fetchCustDetails(lr_number);
		
		
		
		if(deliveryDetails.size()>0)
			return "success";
		else
			return "fail";
	}
	
	
	
	
	
	public String invoiceFormwoTax()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String trip_id = request.getParameter("trip_id");
		String customer_name = request.getParameter("customer_name");
		String transporter_name = request.getParameter("transporter_name");
		String updown_id = request.getParameter("updown_id");
		String lr_number = request.getParameter("lr_number");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String vehicle_no = request.getParameter("vehicle_no");
		String driver_name = request.getParameter("driver_name");
		String total_amount = request.getParameter("total_amount");
		
		//System.out.println("Lr number : "+lr_number);
		
		deliveryDetails = new DeliveryDoneDao().invoiceFormwoTax(lr_number);
		
		//System.out.println("size : "+deliveryDetails.size());
		
		deliverymodel = new DeliveryDoneDao().fetchCustDetails(lr_number);
		
		
		
		if(deliveryDetails.size()>0)
			return "success";
		else
			return "fail";
	}
	
	
	
	public String invoiceFormIgst()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String trip_id = request.getParameter("trip_id");
		String customer_name = request.getParameter("customer_name");
		String transporter_name = request.getParameter("transporter_name");
		String updown_id = request.getParameter("updown_id");
		String lr_number = request.getParameter("lr_number");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String vehicle_no = request.getParameter("vehicle_no");
		String driver_name = request.getParameter("driver_name");
		String total_amount = request.getParameter("total_amount");
		
		System.out.println("Lr number : "+lr_number);
		
		deliveryDetails = new DeliveryDoneDao().fetchForInvoiceIgst(lr_number);
		System.out.println("size : "+deliveryDetails.size());
		
		deliverymodel = new DeliveryDoneDao().fetchCustDetailsIgst(lr_number);
		
		
		
		if(deliveryDetails.size()>0)
			return "success";
		else
			return "fail";
	}
	
	
	public String commisionForm1()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		String str = request.getParameter("str");
		System.out.println("str  :"+str);
		deliveryDetails=new DeliveryDoneDao().fetchForMultiCommision(str);
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return deliverymodel;
	}


	public DeliveryModel getDeliverymodel() {
		return deliverymodel;
	}


	public void setDeliverymodel(DeliveryModel deliverymodel) {
		this.deliverymodel = deliverymodel;
	}


	public List<DeliveryModel> getDeliveryDetails() {
		return deliveryDetails;
	}


	public void setDeliveryDetails(List<DeliveryModel> deliveryDetails) {
		this.deliveryDetails = deliveryDetails;
	}



	public String Add_New_invoice1() throws IOException, SQLException, ParseException {
	
		System.out.println("1");
	int flag = 0;
	HttpServletRequest request=ServletActionContext.getRequest();
	String lr_number=request.getParameter("lr_number");
		String answer  = "";
		response = new DeliveryDoneDao().insertInvoiceInfo(deliverymodel,lr_number);
		sparesize=String.valueOf(deliverymodel.getDescription().length);
		System.out.println("sparesize >>"+sparesize);
		if (response.equals("Notsuffqty")) {

			answer = "Notsuffqty";

			flag = 1;
		} else {
			flag = 0;
		}

		if (flag == 0) {
			int labourc = 0;
			int partsc = 0;
				
			

			try {
				 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
				PreparedStatement preparedStatementx = con
						.prepareStatement("select * from customer_master_details where customer_name='" + deliverymodel.getCustomer_name() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				if (resultSetx.next()) {
					/*ib.setCustomer_name(resultSetx.getString("customer_name"));
					ib.setAddress(resultSetx.getString("customer_address"));
					ib.setVat("");
					ib.setCust_subname("");
					ib.setState("state");*/
					
					deliverymodel.setCustomer_no(resultSetx.getString("customer_no"));
					deliverymodel.setAddress(resultSetx.getString("customer_address"));
					deliverymodel.setState(resultSetx.getString("state"));;
					
					
					
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

					deliverymodel.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}

					int rr = 0;
					int rr1 = 0;
					double cgst = 0.0;
					double sgst = 0.0;
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
						if (!deliverymodel.getDescription()[j1].trim().equals("")
								&& !deliverymodel.getDescription()[j1].trim().equals(null)) {
								
							System.out.println("101");
							
							DeliveryModel deliverymodel22 = new DeliveryModel();
							
							deliverymodel22.setDescription1(deliverymodel.getDescription()[j1]);
							deliverymodel22.setWeight1(deliverymodel.getWeight()[j1]);
							deliverymodel22.setAmount1(deliverymodel.getAmount()[j1]);
							deliverymodel22.setRate1(deliverymodel.getRate()[j1]);
							deliverymodel22.setPenalty_amount(deliverymodel.getPenalty_amt()[j1]);
							deliverymodel22.setHsn1(deliverymodel.getHsn()[j1]);
							deliverymodel22.setGstrate1(deliverymodel.getGst_rate1()[j1]);
							deliverymodel22.setGstrate2(deliverymodel.getGst_rate2()[j1]);
							deliverymodel22.setGstamt1(deliverymodel.getGst_rate1amt()[j1]);
							deliverymodel22.setGstamt2(deliverymodel.getGst_rate2amt()[j1]);
							
							deliverymodel22.setNet_amt1(deliverymodel.getNet_amt()[j1]);
							
							System.out.println("descrip1 : "+deliverymodel22.getDescription1());
							
							deliveryDetails1.add(deliverymodel22);
							
							answer = response;
						}
					}
					
					answer = response;
							/*	try{
								
								
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

							PreparedStatement preparedStatementx1 = con
									.prepareStatement("select unit from  item_master where item_name='"
											+ ib.getDescription1()[j1] + "'");

							ResultSet resultSetx1 = preparedStatementx1.executeQuery();
							if (resultSetx1.next()) {
								ib1.setUnit(resultSetx1.getString("unit"));
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
							try {
								ib1.setAmount(ib.getAmtwithdisc()[j1]);
								Double q1 = Double.parseDouble(ib.getAmtwithdisc()[j1]);

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
					}
					
					
					try {
						
						
						PreparedStatement preparedStatementxh = con
								.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvoiceno() + "'");
						System.out.println(preparedStatementxh);
						ResultSet resultSetxh = preparedStatementxh.executeQuery();
						while (resultSetxh.next()) {
							invoicebean ib2h = new invoicebean();
							
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

						invoicebean ib2 = new invoicebean();

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

				}*/
				answer = response;
			} catch (Exception e) {
				// TODO: handle exception
				answer = "fail";
			}

		}
		try {
			////DaoHelper.closeConnection();
			

		} catch (Exception e) {
			e.printStackTrace();
				
		}

		System.out.println("mb: "+deliverymodel.getMobile());
		
		System.out.println("size : "+deliveryDetails1.size());
		
		return "success";

		
		
		
	}
	
	
	
	
	
	
	public String Add_New_invoice_Igst() throws IOException, SQLException, ParseException {
		
		System.out.println("1");
	
		int flag = 0;
	
	
		HttpServletRequest request=ServletActionContext.getRequest();
	
	
		String lr_number=request.getParameter("lr_number");
		
		String answer  = "";
		
		response = new DeliveryDoneDao().Add_New_invoice_Igst(deliverymodel,lr_number);
		
		sparesize=String.valueOf(deliverymodel.getDescription().length);
		
		System.out.println("sparesize >>"+sparesize);
		
		if (response.equals("Notsuffqty")) {

			answer = "Notsuffqty";

			flag = 1;
		} else {
			flag = 0;
		}

		if (flag == 0) {
			int labourc = 0;
			int partsc = 0;
				
			

			try {
				 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
				PreparedStatement preparedStatementx = con
						.prepareStatement("select * from customer_master_details where customer_name='" + deliverymodel.getCustomer_name() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				if (resultSetx.next()) {
					
					
					deliverymodel.setCustomer_no(resultSetx.getString("customer_no"));
					deliverymodel.setAddress(resultSetx.getString("customer_address"));
					deliverymodel.setState(resultSetx.getString("state"));;
					
					
					
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

					deliverymodel.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}

					int rr = 0;
					int rr1 = 0;
					double cgst = 0.0;
					double sgst = 0.0;
					for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
						if (!deliverymodel.getDescription()[j1].trim().equals("")
								&& !deliverymodel.getDescription()[j1].trim().equals(null)) {
								
							System.out.println("101");
							
							DeliveryModel deliverymodel22 = new DeliveryModel();
							
							deliverymodel22.setDescription1(deliverymodel.getDescription()[j1]);
							deliverymodel22.setWeight1(deliverymodel.getWeight()[j1]);
							deliverymodel22.setAmount1(deliverymodel.getAmount()[j1]);
							deliverymodel22.setRate1(deliverymodel.getRate()[j1]);
							deliverymodel22.setPenalty_amount(deliverymodel.getPenalty_amt()[j1]);
							deliverymodel22.setHsn1(deliverymodel.getHsn()[j1]);
							deliverymodel22.setGstrate1(deliverymodel.getGst_rate1()[j1]);
							deliverymodel22.setGstrate2(deliverymodel.getGst_rate2()[j1]);
							deliverymodel22.setGstamt1(deliverymodel.getGst_rate1amt()[j1]);
							deliverymodel22.setGstamt2(deliverymodel.getGst_rate2amt()[j1]);
							
							deliverymodel22.setNet_amt1(deliverymodel.getNet_amt()[j1]);
							
							System.out.println("descrip1 : "+deliverymodel22.getDescription1());
							
							deliveryDetails1.add(deliverymodel22);
							
							answer = response;
						}
					}
					
				
							
				answer = response;
			} catch (Exception e) {
				// TODO: handle exception
				answer = "fail";
			}

		}
		try {
			////DaoHelper.closeConnection();
			

		} catch (Exception e) {
			e.printStackTrace();
				
		}

		System.out.println("mb: "+deliverymodel.getMobile());
		
		System.out.println("size : "+deliveryDetails1.size());
		
		return "success";

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public String Add_New_invoice2()
	{

		
		System.out.println("1");
		int flag = 0;
		HttpServletRequest request=ServletActionContext.getRequest();
		//String lr_number=request.getParameter("lr_number");
		String answer  = "";
		response = new DeliveryDoneDao().insertInvoiceInfo2(deliverymodel);
		
		System.out.println("response >>"+response);
		if (response.equals("Notsuffqty")) {

			answer = "Notsuffqty";

			flag = 1;
		} else {
			flag = 0;
		}

		if (flag == 0) {
			int labourc = 0;
			int partsc = 0;
			/*tqty=0.0;
			pono = ib.getPono();
			podate = ib.getPodate();
			termcond = ib.getTermcond();
			vendor = ib.getVendor();
			dcnox = ib.getDcnox();
			dcdatex = ib.getDcdatex();

			transmode = ib.getTransmode();
			contactp = ib.getContactp();
			contactpno = ib.getContactpno();
			*/

			/*System.out.println(">>>dcno" + dcnox);*/
			

			
			

			try {
				 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
				PreparedStatement preparedStatementx = con
						.prepareStatement("select * from customer_master_details where customer_name='" + deliverymodel.getCustomer_name() + "'");

				ResultSet resultSetx = preparedStatementx.executeQuery();
				if (resultSetx.next()) {
					/*ib.setCustomer_name(resultSetx.getString("customer_name"));
					ib.setAddress(resultSetx.getString("customer_address"));
					ib.setVat("");
					ib.setCust_subname("");
					ib.setState("state");*/
					
					deliverymodel.setCustomer_no(resultSetx.getString("customer_no"));
					deliverymodel.setAddress(resultSetx.getString("customer_address"));
					deliverymodel.setState(resultSetx.getString("state"));;
					
					
					
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

					deliverymodel.setMobile(resultSetx.getString("mobile_no") + " " + mob);

				}

				/*if (ib.getPrintbutton2().equalsIgnoreCase("printbutton2")) {

					int rr = 0;
					int rr1 = 0;
					double cgst = 0.0;
					double sgst = 0.0;
					for (int j1 = 0; j1 < ib.getDescription1().length; j1++) {
						if (!ib.getDescription1()[j1].trim().equals("")
								&& !ib.getDescription1()[j1].trim().equals(null)) {
							invoicebean ib1 = new invoicebean();

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

							PreparedStatement preparedStatementx1 = con
									.prepareStatement("select unit from  item_master where item_name='"
											+ ib.getDescription1()[j1] + "'");

							ResultSet resultSetx1 = preparedStatementx1.executeQuery();
							if (resultSetx1.next()) {
								ib1.setUnit(resultSetx1.getString("unit"));
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
							try {
								ib1.setAmount(ib.getAmtwithdisc()[j1]);
								Double q1 = Double.parseDouble(ib.getAmtwithdisc()[j1]);

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
					}
					
					
					try {
						
						
						PreparedStatement preparedStatementxh = con
								.prepareStatement("select * from invoice_hsn_details where invoiceno='" + ib.getInvoiceno() + "'");
						System.out.println(preparedStatementxh);
						ResultSet resultSetxh = preparedStatementxh.executeQuery();
						while (resultSetxh.next()) {
							invoicebean ib2h = new invoicebean();
							
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

						invoicebean ib2 = new invoicebean();

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

				}*/
				
				
				
				int rr = 0;
				int rr1 = 0;
				double cgst = 0.0;
				double sgst = 0.0;
				for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
					if (!deliverymodel.getDescription()[j1].trim().equals("")
							&& !deliverymodel.getDescription()[j1].trim().equals(null)) {
							
						System.out.println("101");
						
						DeliveryModel deliverymodel22 = new DeliveryModel();
						
						deliverymodel22.setDescription1(deliverymodel.getDescription()[j1]);
						deliverymodel22.setWeight1(deliverymodel.getWeight()[j1]);
						deliverymodel22.setAmount1(deliverymodel.getAmount()[j1]);
						deliverymodel22.setRate1(deliverymodel.getRate()[j1]);
						deliverymodel22.setPenalty_amount(deliverymodel.getPenalty_amt()[j1]);
						deliverymodel22.setHsn1(deliverymodel.getHsn()[j1]);
						deliverymodel22.setGstrate1(deliverymodel.getGst_rate1()[j1]);
						deliverymodel22.setGstrate2(deliverymodel.getGst_rate2()[j1]);
						deliverymodel22.setGstamt1(deliverymodel.getGst_rate1amt()[j1]);
						deliverymodel22.setGstamt2(deliverymodel.getGst_rate2amt()[j1]);
						
						deliverymodel22.setNet_amt1(deliverymodel.getNet_amt()[j1]);
						
						System.out.println("descrip1 : "+deliverymodel22.getDescription1());
						
						deliveryDetails1.add(deliverymodel22);
						
						answer = response;
					}
				}
				
				answer = response;
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				answer = "success";
			} catch (Exception e) {
				// TODO: handle exception
				answer = "fail";
			}

		}
		try {
			////DaoHelper.closeConnection();
			

		} catch (Exception e) {
			e.printStackTrace();
				
		}

		System.out.println(deliverymodel.getMobile());
		
		return answer;

		
		
		
	
	}
	
	
	public String invForm1()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		String str = request.getParameter("str");
		System.out.println("str  :"+str);
		
		String c_name = request.getParameter("customer_name");
		System.out.println("c_name : "+c_name);
		//System.out.println("lr size : "+deliverymodel.getLr_number1().length);
		deliveryDetails=new DeliveryDoneDao().fetchForMultiInv(str, c_name);
		deliverymodel = new DeliveryDoneDao().fetchCustDetails1(str);
		
		
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	public String invoice_reports()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		deliveryDetails=new DeliveryDoneDao().fetchInvoiveDetails();
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	
	public String fetchForUpdateInvoice()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		String invoiceno = request.getParameter("invoiceno");
		
		String type = request.getParameter("type");
		
		
		if(type.equals("sgst"))
		{
			
			deliveryDetails=new DeliveryDoneDao().fetchForEditInv(invoiceno);
			
			deliverymodel = new DeliveryDoneDao().fetchCustDetails2(invoiceno);
			
			return "success";
		}
		
		else {
		
			
			deliveryDetails=new DeliveryDoneDao().fetchForEditInvIgst(invoiceno);
			
			deliverymodel = new DeliveryDoneDao().fetchCustDetails2Igst(invoiceno);
		
			return "success1";
		}
		
		
		
	}
	
	
	public String edit_invoice()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String invoiceno = request.getParameter("invoiceno");
		
		response = new DeliveryDoneDao().editInvoice(deliverymodel);
		
		try {
			 DBConnection connection=new DBConnection();Connection con = connection.getConnection();
			PreparedStatement preparedStatementx = con
					.prepareStatement("select * from customer_master_details where customer_name='" + deliverymodel.getCustomer_name() + "'");

			ResultSet resultSetx = preparedStatementx.executeQuery();
			if (resultSetx.next()) {
				/*ib.setCustomer_name(resultSetx.getString("customer_name"));
				ib.setAddress(resultSetx.getString("customer_address"));
				ib.setVat("");
				ib.setCust_subname("");
				ib.setState("state");*/
				
				deliverymodel.setCustomer_no(resultSetx.getString("customer_no"));
				deliverymodel.setAddress(resultSetx.getString("customer_address"));
				deliverymodel.setState(resultSetx.getString("state"));;
				
				
				
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

				deliverymodel.setMobile(resultSetx.getString("mobile_no") + " " + mob);

			}

				int rr = 0;
				int rr1 = 0;
				double cgst = 0.0;
				double sgst = 0.0;
				for (int j1 = 0; j1 < deliverymodel.getDescription().length; j1++) {
					if (!deliverymodel.getDescription()[j1].trim().equals("")
							&& !deliverymodel.getDescription()[j1].trim().equals(null)) {
							
						System.out.println("101");
						
						DeliveryModel deliverymodel22 = new DeliveryModel();
						
						deliverymodel22.setDescription1(deliverymodel.getDescription()[j1]);
						deliverymodel22.setWeight1(deliverymodel.getWeight()[j1]);
						deliverymodel22.setAmount1(deliverymodel.getAmount()[j1]);
						deliverymodel22.setRate1(deliverymodel.getRate()[j1]);
						deliverymodel22.setPenalty_amount(deliverymodel.getPenalty_amt()[j1]);
						deliverymodel22.setHsn1(deliverymodel.getHsn()[j1]);
						deliverymodel22.setGstrate1(deliverymodel.getGst_rate1()[j1]);
						deliverymodel22.setGstrate2(deliverymodel.getGst_rate2()[j1]);
						deliverymodel22.setGstamt1(deliverymodel.getGst_rate1amt()[j1]);
						deliverymodel22.setGstamt2(deliverymodel.getGst_rate2amt()[j1]);
						
						deliverymodel22.setNet_amt1(deliverymodel.getNet_amt()[j1]);
						
						System.out.println("descrip1 : "+deliverymodel22.getDescription1());
						
						deliveryDetails1.add(deliverymodel22);
						
						//answer = response;
					}
				}
				
				//answer = response;
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return response;
	}
	
	
	
	public String transporter_comm_reports()
	{
		return "success";
	}
	
	public String profit_Reports()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//String transporter_name = request.getParameter("transporter_name");
		String drv_code = "";
		
		
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String trip_id = request.getParameter("trip_id");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String driver_name = request.getParameter("driver_name");
		
		if(!driver_name.equals(""))
		{
			String drv[] = driver_name.split("-");
			
			drv_code=drv[1];
		}
		/*System.out.println("from_date "+from_date);
		System.out.println("to_date "+to_date);
		System.out.println("trip_id "+trip_id);
		System.out.println("source "+source);
		System.out.println("destination "+destination);*/
		
		deliveryDetails = new DeliveryDoneDao().fetchProfitDetails(from_date, to_date, trip_id, source, destination, drv_code);
		
		
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
	
	}
	
	public String profit_Reports1()
	{
		return "success";
	}
	
	
	public String updown_profit_Reports1()
	{
		return "success";
	}
	
	public String updown_profit_Reports()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//String transporter_name = request.getParameter("transporter_name");
		String drv_code = "";
		
		
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String trip_id = request.getParameter("trip_id");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String driver_name = request.getParameter("driver_name");
		String updown_id = request.getParameter("updown_id");
		
		if(!driver_name.equals(""))
		{
			String drv[] = driver_name.split("-");
			
			drv_code=drv[1];
		}
		/*System.out.println("from_date "+from_date);
		System.out.println("to_date "+to_date);
		System.out.println("trip_id "+trip_id);
		System.out.println("source "+source);
		System.out.println("destination "+destination);*/
		
		deliveryDetails = new DeliveryDoneDao().fetchUpDownProfitDetails(from_date, to_date, trip_id, updown_id, source, destination, drv_code);
		
		
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
	
	}
	
	
	
	
	public String lr_profit_Reports1()
	{
		return "success";
	}
	
	
	public String lr_profit_Reports()
	{

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//String transporter_name = request.getParameter("transporter_name");
		String drv_code = "";
		String cust_code = "";
		
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String trip_id = request.getParameter("trip_id");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		String driver_name = request.getParameter("driver_name");
		String updown_id = request.getParameter("updown_id");
		String lr_number = request.getParameter("lr_number");
		String customer_name = request.getParameter("customer_name");
		
		if(!driver_name.equals(""))
		{
			String drv[] = driver_name.split("-");
			
			drv_code=drv[1];
		}
		
		
		if(!customer_name.equals(""))
		{
			String cust[] = customer_name.split("-");
			
			cust_code=cust[1];
		}
		
		/*System.out.println("from_date "+from_date);
		System.out.println("to_date "+to_date);
		System.out.println("trip_id "+trip_id);
		System.out.println("source "+source);
		System.out.println("destination "+destination);*/
		
		deliveryDetails = new DeliveryDoneDao().fetchLRProfitDetails(from_date, to_date, trip_id, updown_id, source, destination, drv_code, cust_code, lr_number);
		
		
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
	
	
		
	}
	
	
	
	
	
	
	
	
	public String transporter_comm_reports1()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String transporter_name = request.getParameter("transporter_name");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		String trip_id = request.getParameter("trip_id");
		
		deliveryDetails = new DeliveryDoneDao().fetchCommDetails(transporter_name, from_date, to_date, trip_id);
		
		
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
		
		//return "success";
	}


	public String transporterBussReduce() {
		deliveryDetails = new DeliveryDoneDao().getTransportBussReduce();
		
		if(deliveryDetails.size()>0)
		{
			return "success";
		}
		else
		{
			return "fail";
		}
	}
	
	
	public String vehicleProfit()
	{
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		//String transporter_name = request.getParameter("transporter_name");
		String vehicle_no = request.getParameter("vehicle_no");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		//String trip_id = request.getParameter("trip_id");
		
		
		deliveryDetails = new DeliveryDoneDao().fetchVehicleProfitDetails(vehicle_no, from_date, to_date);
		
		
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
	
	}
	
	public String vehicleProfit1()
	{
		return "success";
	}
	
	
	public String saleReport()
	{
		return "success";
	}
	
	
	public String saleReport1()
	{
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");
		deliveryDetails = new DeliveryDoneDao().fetchSaleDetails(from_date, to_date);
		
		
		if(deliveryDetails.size()>0)
		{
			return "success";
		}
		
		else
		{
			return "fail";
		}
	}
	
	public String vehicleCompareGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph=(new DeliveryDoneDao().getvehicleGraph());
			
			//System.out.println("--- "+graph);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return "success";
	}
	
	
	public String monthlyBusinessGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph1=(new DeliveryDoneDao().getBusinessGraph());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	public String resourceEnquiryGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph3=(new DeliveryDoneDao().getResourceEnquiryGraph());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	public String resourceEnquiryGraph1()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph4=(new DeliveryDoneDao().getResourceEnquiryGraph1());
			
			//System.out.println("--- "+graph4);
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	public String businessGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph5=(new DeliveryDoneDao().businessGraph());
			
			//System.out.println("Data:"+graph5);
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	public String eximyGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph6=(new DeliveryDoneDao().eximyGraph());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	
	public String eximyGraph1()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph7=(new DeliveryDoneDao().eximyGraph1());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	public String eximyGraph12()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph7=(new DeliveryDoneDao().eximyGraph12());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	public String eximyGraph123()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph8=(new DeliveryDoneDao().eximyGraph123());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	public String orderlostGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph2=(new DeliveryDoneDao().getOrderLostGraph());
			
			//System.out.println("--- "+graph1);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		return "success";
	}
	
	
	
	
	public String monthlyShortWeightGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph2=(new DeliveryDoneDao().getShortWeightGraph());
			
			//System.out.println("--- "+graph2);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return "success";
	}
	
	public String monthlyTripsGraph()
	{
		Map session = ActionContext.getContext().getSession();
		try {
			
			graph3=(new DeliveryDoneDao().getTripsGraph());
			
			//System.out.println("--- "+graph3);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return "success";
	}
	
	
	
	public String printInvoice()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		String invoice_no = request.getParameter("invoiceno");
		
		String type = request.getParameter("type");
		
		
		
		if(type.equals("sgst"))
		
		{	
		
			deliveryDetails1 = new DeliveryDoneDao().getInvoiceDetails(invoice_no);
		
			deliverymodel = new DeliveryDoneDao().getInvoiceDetails1(invoice_no);
		
		
			return "success";
		
		}
		
		else {
			
			
			deliveryDetails1 = new DeliveryDoneDao().getInvoiceDetailsIgst(invoice_no);
			
			deliverymodel = new DeliveryDoneDao().getInvoiceDetails1Igst(invoice_no);
			
			
				return "success1";
			
		}
		
	
	}
	
	
	
	
	
	public String fetchTransporterlrDoneDetails()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		
		String vnamea=request.getParameter("transporter_name");
			
		try {
		String ssklp[]=vnamea.split("-");
		
		vname=ssklp[0];
		vid=ssklp[1];
		
		System.out.println("dfgdfgdfggggggg----------"+vnamea);
		request.setAttribute("vname", vname);
		request.setAttribute("vid", vid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		deliveryDetails=new DeliveryDoneDao().fetchTransporterDoneDetails(vnamea);
		
		System.out.println("Size -- -- - "+deliveryDetails.size());
		
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	

	public String submitvendormbill()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		String responce=new DeliveryDoneDao().insertvendorBill(deliverymodel,bean);
		
		
		if(responce.equals("success"))
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	public String vendor_bill_reports()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		deliveryDetails=new DeliveryDoneDao().vendorbillreport();
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	
	public String vendor_bill_form()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String vehicle_no = request.getParameter("vehicle_no");
		System.out.println("Vehicle no :"+vehicle_no);*/
		
		
		String sskl=request.getParameter("delivery_done_id");
		
		
		deliveryDetails=new DeliveryDoneDao().vendorbilldetails(sskl);
		System.out.println("Size -- -- - "+deliveryDetails.size());
		if(deliveryDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	public String submitvendormpayment()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		String responce=new DeliveryDoneDao().insertvendorpayment(deliverymodel,bean);
		
		
		if(responce.equals("success"))
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	

	public String getSparesize() {
		return sparesize;
	}



	public void setSparesize(String sparesize) {
		this.sparesize = sparesize;
	}



	public String getGraph4() {
		return graph4;
	}



	public void setGraph4(String graph4) {
		this.graph4 = graph4;
	}



	public String getGraph5() {
		return graph5;
	}



	public void setGraph5(String graph5) {
		this.graph5 = graph5;
	}



	public String getGraph6() {
		return graph6;
	}



	public void setGraph6(String graph6) {
		this.graph6 = graph6;
	}
	
	public String getGraph1() {
		return graph1;
	}



	public void setGraph1(String graph1) {
		this.graph1 = graph1;
	}



	public String getGraph2() {
		return graph2;
	}



	public void setGraph2(String graph2) {
		this.graph2 = graph2;
	}



	public String getGraph3() {
		return graph3;
	}



	public void setGraph3(String graph3) {
		this.graph3 = graph3;
	}



	public String getGraph() {
		return graph;
	}



	public void setGraph(String graph) {
		this.graph = graph;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}
	

	public List<DeliveryModel> getDeliveryDetails1() {
		return deliveryDetails1;
	}



	public void setDeliveryDetails1(List<DeliveryModel> deliveryDetails1) {
		this.deliveryDetails1 = deliveryDetails1;
	}



	public HttpServletRequest getRequest() {
		return request;
	}



	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}



	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}



	public String getGraph7() {
		return graph7;
	}



	public void setGraph7(String graph7) {
		this.graph7 = graph7;
	}



	public String getGraph8() {
		return graph8;
	}



	public void setGraph8(String graph8) {
		this.graph8 = graph8;
	}



	public String getGraph9() {
		return graph9;
	}



	public void setGraph9(String graph9) {
		this.graph9 = graph9;
	}



	public String getGraph10() {
		return graph10;
	}



	public void setGraph10(String graph10) {
		this.graph10 = graph10;
	}
	
}
