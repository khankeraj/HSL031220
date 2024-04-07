package com.master.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.master.dao.prn_Dao;
import com.master.model.purchase_bean;
import com.master.util.CoreData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Purchase_action extends ActionSupport implements
ModelDriven<purchase_bean>,SessionAware,
		ServletRequestAware {
private String df="";
private String dt="";
private int i=0;
private int l=0;
private String iccr_no;
private String Customer_Name;
private String Address;
private String Outstanding_Amount;
private String paidamount;
private String mode="";
	public String getIccr_no() {
	return iccr_no;
}

public void setIccr_no(String iccr_no) {
	this.iccr_no = iccr_no;
}

public String getCustomer_Name() {
	return Customer_Name;
}

public void setCustomer_Name(String customer_Name) {
	Customer_Name = customer_Name;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getOutstanding_Amount() {
	return Outstanding_Amount;
}

public void setOutstanding_Amount(String outstanding_Amount) {
	Outstanding_Amount = outstanding_Amount;
}

public String getPaidamount() {
	return paidamount;
}

public void setPaidamount(String paidamount) {
	this.paidamount = paidamount;
}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	public purchase_bean getPsb() {
		return psb;
	}

	public void setPsb(purchase_bean psb) {
		this.psb = psb;
	}

	public List<purchase_bean> getReport() {
		return report;
	}

	public void setReport(List<purchase_bean> report) {
		this.report = report;
	}

	private purchase_bean psb= new purchase_bean();
	private String totalbalance;
	private purchase_bean psb1;
	private purchase_bean psb2;
	private double tot;
	//private double tota;
	private String tota44;
	private String tparts;
	private String  tcgst25;
	private String  tcgst6;
	private String  tcgst9;
	private String  tcgst14;
	
	private String  tsgst25;
	private String  tsgst6;
	private String  tsgst9;
	private String  tsgst14;
	
	
	private String  tigst5;
	private String  tigst12;
	private String  tigst18;
	private String  tigst28;
	public String getTlabourwct() {
		return tlabourwct;
	}

	public List<purchase_bean> getStockreport() {
		return stockreport;
	}

	public void setStockreport(List<purchase_bean> stockreport) {
		this.stockreport = stockreport;
	}

	public void setTlabourwct(String tlabourwct) {
		this.tlabourwct = tlabourwct;
	}

	private String tlabour;
	private String tlabourwct;
	private String tot1;
	
	
	List<purchase_bean> report = new ArrayList<purchase_bean>();
	List<purchase_bean> stockreport = new ArrayList<purchase_bean>();
	List<purchase_bean> report1 = new ArrayList<purchase_bean>();
	public List<purchase_bean> getReport1() {
		return report1;
	}

	public void setReport1(List<purchase_bean> report1) {
		this.report1 = report1;
	}

	public String prod1() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().prodd(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod1 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount = report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("totalamount " + totalamount);

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}
		/*
		 * String totalamount = ""; for (int i = 0; i < report.size(); i++) {
		 * try { totalamount = report.get(i).getTotal_amt(); } catch (Exception
		 * e) { // TODO: handle exception } }
		 */

		// System.out.println(">>"+totalamount);

		/*
		 * try { request.setAttribute("totalamount", totalamount); } catch
		 * (Exception e) { // TODO: handle exception }
		 */
		/*
		 * try { report = new Product_Sale_Dao().fetchunitno1(psb);
		 * System.out.println(report.size()); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		return "success";

	}
	
	
	
	public String displaysalesRegister(){
		
		
		
		return "success";
	}
	
public String enquiryReport(){
	
		return "success";
	}
	
public String LRReport2(){
	
	return "success";
}
	
public String monthlybooking(){
	
	return "success";
}

	public String salereportsubmit() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().salereportsubmit(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tcgst25=""+ Math.round(Double.parseDouble(report.get(i).getTcgst25()));
				tcgst6=""+ Math.round(Double.parseDouble(report.get(i).getTcgst6()));
				tcgst9=""+ Math.round(Double.parseDouble(report.get(i).getTcgst9()));
				tcgst14=""+ Math.round(Double.parseDouble(report.get(i).getTcgst14()));
				
				tsgst25=""+ Math.round(Double.parseDouble(report.get(i).getTsgst25()));
				tsgst6=""+ Math.round(Double.parseDouble(report.get(i).getTsgst6()));
				tsgst9=""+ Math.round(Double.parseDouble(report.get(i).getTsgst9()));
				tsgst14=""+ Math.round(Double.parseDouble(report.get(i).getTsgst14()));
				
				tigst5=""+ Math.round(Double.parseDouble(report.get(i).getTigst5()));
				tigst12=""+ Math.round(Double.parseDouble(report.get(i).getTigst12()));
				tigst18=""+ Math.round(Double.parseDouble(report.get(i).getTigst18()));
				tigst28=""+ Math.round(Double.parseDouble(report.get(i).getTigst28()));
				
				totalbalance=""+ Math.round(Double.parseDouble(report.get(i).getTotalamount1()));

				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		System.out.println(">>>1");
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		request.setAttribute("totalbalance", totalbalance);
		
		}
		catch (Exception e) {
		}
		System.out.println(">>>2");
		
		return "success";

	}
	
	
	
	
	
	public String salereturnreportsubmit() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().salereturnreportsubmit(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tcgst25=""+ Math.round(Double.parseDouble(report.get(i).getTcgst25()));
				tcgst6=""+ Math.round(Double.parseDouble(report.get(i).getTcgst6()));
				tcgst9=""+ Math.round(Double.parseDouble(report.get(i).getTcgst9()));
				tcgst14=""+ Math.round(Double.parseDouble(report.get(i).getTcgst14()));
				
				tsgst25=""+ Math.round(Double.parseDouble(report.get(i).getTsgst25()));
				tsgst6=""+ Math.round(Double.parseDouble(report.get(i).getTsgst6()));
				tsgst9=""+ Math.round(Double.parseDouble(report.get(i).getTsgst9()));
				tsgst14=""+ Math.round(Double.parseDouble(report.get(i).getTsgst14()));
				
				tigst5=""+ Math.round(Double.parseDouble(report.get(i).getTigst5()));
				tigst12=""+ Math.round(Double.parseDouble(report.get(i).getTigst12()));
				tigst18=""+ Math.round(Double.parseDouble(report.get(i).getTigst18()));
				tigst28=""+ Math.round(Double.parseDouble(report.get(i).getTigst28()));
				
				totalbalance=""+ Math.round(Double.parseDouble(report.get(i).getTotalamount1()));

				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		System.out.println(">>>1");
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		request.setAttribute("totalbalance", totalbalance);
		
		}
		catch (Exception e) {
		}
		System.out.println(">>>2");
		
		return "success";

	}
	
	
	
	public String collection_summary_tax() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().collection_summary_tax(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tcgst25=""+ Math.round(Double.parseDouble(report.get(i).getTcgst25()));
				tcgst6=""+ Math.round(Double.parseDouble(report.get(i).getTcgst6()));
				tcgst9=""+ Math.round(Double.parseDouble(report.get(i).getTcgst9()));
				tcgst14=""+ Math.round(Double.parseDouble(report.get(i).getTcgst14()));
				
				tsgst25=""+ Math.round(Double.parseDouble(report.get(i).getTsgst25()));
				tsgst6=""+ Math.round(Double.parseDouble(report.get(i).getTsgst6()));
				tsgst9=""+ Math.round(Double.parseDouble(report.get(i).getTsgst9()));
				tsgst14=""+ Math.round(Double.parseDouble(report.get(i).getTsgst14()));
				
				tigst5=""+ Math.round(Double.parseDouble(report.get(i).getTigst5()));
				tigst12=""+ Math.round(Double.parseDouble(report.get(i).getTigst12()));
				tigst18=""+ Math.round(Double.parseDouble(report.get(i).getTigst18()));
				tigst28=""+ Math.round(Double.parseDouble(report.get(i).getTigst28()));
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		
		
		}
		catch (Exception e) {
		}
		
		
		return "success";

	}
	
	public String enquiryReportDetails() {
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		try {
			report = new prn_Dao().enquiryReportDetails(datefrom, dateto);
			System.out.println("report"+report.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "success";
	}
	
	public String LRReportDetails() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		String customer=psb.getCustomer();
		String transp=psb.getTransporter();
		
		try {
			report = new prn_Dao().LRReportDetails(datefrom, dateto,customer,transp);
			System.out.println("report"+report.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "success";

	}
	
	public String monthlybookingdetails() {
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		try {
			report = new prn_Dao().monthlybookingdetails(datefrom, dateto);
			System.out.println("report"+report.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "success";
	}
	
	public String collection_summary_taxactual() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		setDf(datefrom);
		setDt(dateto);
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().collection_summary_taxactual(datefrom, dateto);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		
		
		}
		catch (Exception e) {
		}
		
		
		return "success";

	}

	
	public String collection_summary_taxip() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().collection_summary_taxip(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tcgst25=""+ Math.round(Double.parseDouble(report.get(i).getTcgst25()));
				tcgst6=""+ Math.round(Double.parseDouble(report.get(i).getTcgst6()));
				tcgst9=""+ Math.round(Double.parseDouble(report.get(i).getTcgst9()));
				tcgst14=""+ Math.round(Double.parseDouble(report.get(i).getTcgst14()));
				
				tsgst25=""+ Math.round(Double.parseDouble(report.get(i).getTsgst25()));
				tsgst6=""+ Math.round(Double.parseDouble(report.get(i).getTsgst6()));
				tsgst9=""+ Math.round(Double.parseDouble(report.get(i).getTsgst9()));
				tsgst14=""+ Math.round(Double.parseDouble(report.get(i).getTsgst14()));
				
				tigst5=""+ Math.round(Double.parseDouble(report.get(i).getTigst5()));
				tigst12=""+ Math.round(Double.parseDouble(report.get(i).getTigst12()));
				tigst18=""+ Math.round(Double.parseDouble(report.get(i).getTigst18()));
				tigst28=""+ Math.round(Double.parseDouble(report.get(i).getTigst28()));
				
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		
		
		}
		catch (Exception e) {
		}
		
		
		return "success";

	}
	
	
	
	public String purchasereturnreport() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().PurchaseReturnReport(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tcgst25=""+ Math.round(Double.parseDouble(report.get(i).getTcgst25()));
				tcgst6=""+ Math.round(Double.parseDouble(report.get(i).getTcgst6()));
				tcgst9=""+ Math.round(Double.parseDouble(report.get(i).getTcgst9()));
				tcgst14=""+ Math.round(Double.parseDouble(report.get(i).getTcgst14()));
				
				tsgst25=""+ Math.round(Double.parseDouble(report.get(i).getTsgst25()));
				tsgst6=""+ Math.round(Double.parseDouble(report.get(i).getTsgst6()));
				tsgst9=""+ Math.round(Double.parseDouble(report.get(i).getTsgst9()));
				tsgst14=""+ Math.round(Double.parseDouble(report.get(i).getTsgst14()));
				
				tigst5=""+ Math.round(Double.parseDouble(report.get(i).getTigst5()));
				tigst12=""+ Math.round(Double.parseDouble(report.get(i).getTigst12()));
				tigst18=""+ Math.round(Double.parseDouble(report.get(i).getTigst18()));
				tigst28=""+ Math.round(Double.parseDouble(report.get(i).getTigst28()));
				
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		try {
		request.setAttribute("tcgst25", tcgst25);
		request.setAttribute("tcgst6", tcgst6);
		request.setAttribute("tcgst9", tcgst9);
		request.setAttribute("tcgst14", tcgst14);
		request.setAttribute("tsgst25", tsgst25);
		request.setAttribute("tsgst6", tsgst6);
		request.setAttribute("tsgst9", tsgst9);
		request.setAttribute("tsgst14", tsgst14);
		
		request.setAttribute("tigst5", tigst5);
		request.setAttribute("tigst12", tigst12);
		request.setAttribute("tigst18", tigst18);
		request.setAttribute("tigst28", tigst28);
		
		
		}
		catch (Exception e) {
		}
		
		
		return "success";

	}
	
	
	
	public String prod2() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		
		double twct=0.0;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		
		try {
			report = new prn_Dao().prodd1(datefrom, dateto);
			
			for(int i=0;i<report.size();i++){
				
				tparts=""+ Math.round(Double.parseDouble(report.get(i).getTparts()));
				
				tlabour=""+Math.round(Double.parseDouble(report.get(i).getTlabour()));
				//request.setAttribute("tlabour", tlabour);
				twct=Double.parseDouble(report.get(i).getTlabourwct());
				
				
		
				tot1=""+Math.round(Double.parseDouble(report.get(i).getTot()));
			}
			tlabourwct=""+Math.round(twct);
			System.out.println("totallabourwct"+tlabourwct);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		try {
		request.setAttribute("tparts", tparts);
		request.setAttribute("tlabour", tlabour);
		request.setAttribute("tlabourwct", tlabourwct);
		request.setAttribute("tot1", tot1);
		}
		catch (Exception e) {
		}
		
		
		return "success";

	}
	
	
	public String prod22() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date22();
		String dateto = psb.getTo_date122();
df=datefrom;
dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		//purchase_bean psb1=new purchase_bean();
		try {
			psb1 = new prn_Dao().prodd122(datefrom, dateto);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		
		
		//System.out.println("sumtot" + psb1.getPaybycashtotal());
		
		return "success";

	}

	
	
	public String inv22() {
			int k=0;
				int j=0;

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String datefrom = psb.getFrom_date22();
		String dateto = psb.getTo_date122();
df=datefrom;
dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);*/
		//report=new purchase_bean();
		//purchase_bean psb1=new purchase_bean();
		String status="";
		String Paid_amt="";
		String date="";
		String vehicleno="";
		String jobcardno="";
		String tot="";
		String invsatus="";
		try {
			report = new prn_Dao().inv22();
			System.out.println("size"+report.size());
			
			//int p=report.size();
		/*	for (int o = 0; o <report.size(); o++)
			{
				status=report.get(o).getInvstatus();*/
				
				/*try
				{
				
				Paid_amt=report.get(o).getPaid_amt();
				}
				catch (Exception e){
					
					Paid_amt="";
					
				}
				
				try
				{
				
					date=report.get(o).getDate();
				}
				catch (Exception e){
					
					date="";
					
				}
				try
				{
				
					vehicleno=report.get(o).getVechicle_no();
				}
				catch (Exception e){
					
					vehicleno="";
					
				}
				
				
				try
				{
				
					jobcardno=report.get(o).getJob_card_no();
				}
				catch (Exception e){
					
					jobcardno="";
					
				}
				
				try
				{
				
					tot=report.get(o).getTot();
				}
				catch (Exception e){
					
					tot="";
					
				}
				
				try
				{
				
					invsatus=report.get(o).getInvstatus();
				}
				catch (Exception e){
					
					invsatus="";
					
				}
				
				*/
				
				
				
				
				
				
				
				
				
				
				/*if(status.equalsIgnoreCase("0"))
				{
					psb1.setPaid_amt(report.get(o).getPaid_amt());
					psb1.setDate(report.get(o).getDate());
					psb1.setVechicle_no(report.get(o).getVechicle_no());
					psb1.setJob_card_no(report.get(o).getJob_card_no());
					psb1.setTot(report.get(o).getTot());
					psb1.setInvstatus(report.get(o).getInvstatus());
					j++;
				}
				else{
					
					psb1.setPaid_amt(report.get(o).getPaid_amt());
					psb1.setDate(report.get(o).getDate());
					psb1.setVechicle_no(report.get(o).getVechicle_no());
					psb1.setJob_card_no(report.get(o).getJob_card_no());
					psb1.setTot(report.get(o).getTot());
					psb1.setInvstatus(report.get(o).getInvstatus());
					j=o;
				}
				i=j;
				report1.add(psb1);*/
				
				//System.out.println("statfinal"+i);
			//}
			
			//System.out.println("statfinal"+i);
			//System.out.println("statfinal"+_i);
			
		}
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		
		
		//System.out.println("sumtot" + psb1.getPaybycashtotal());
		
		return "success";

	}
	
	
	public String purchasereport() {

		
		
		try {
			report = new prn_Dao().purchasereport();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		
		return "success";
	
	
	
	}
	
	
	
	public String ageingreport() {
	
		try {
			report = new prn_Dao().AgeingReport();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
			
		return "success";

	}
	
	
	
	public String out221() {

		
	
		try {
			report = new prn_Dao().out221();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		for(int i=0;i<report.size();i++)
		{
			totalbalance=report.get(i).getBalance_amount();
			
			tot=tot+Double.parseDouble(totalbalance);
			//tota44=String.format("%.4f",tot);
			tota44=""+ Math.round(tot);
			
			//System.out.println("double" +tot);
			
			HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			request.setAttribute("tot", tota44);
		
		}	
		
		
		
		return "success";
	
	
	
	}
	
	
	
	public String Add_invoice445()throws IOException,SQLException
	{
		
	//System.out.println(">>>in action");
//	System.out.println(">>>in action"+amb.getIccr_no());
		
		Map session=ActionContext.getContext().getSession();
		/*LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);*/
		//user =bean.getDealercode();
		purchase_bean bean1=new purchase_bean();
	//psb.setDealer_id(user);
	bean1 = new prn_Dao().insert(psb);
	if (bean1.getResponse().equals("success")) {
		//custcode=bean1.getCust_code();
		return "success";

	}	
	else if (bean1.getResponse().equals("fail")){
		
		return "fail";
	}
		
			return "success";	
		
		
		
	}
	
	
	
	
	
	
	//Method to Insert Customer Payment
	public String addcustpayment()throws IOException,SQLException
	{
		
	Map session=ActionContext.getContext().getSession();
	
		purchase_bean bean1=new purchase_bean();
	
	bean1 = new prn_Dao().insertcustpayment(psb);
	
	if (bean1.getResponse().equals("success")) {
		//custcode=bean1.getCust_code();
		return "success";
	}	
	else if (bean1.getResponse().equals("fail")){
		
		return "fail";
	}
		
			return "success";		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String openbill()
	{
		
		//System.out.println(">>>"+jb.getCustomer_name1());
		

			
			return "success";	
		
		
		
	}
	
	public String openpayform()
	{
		
		//System.out.println(">>>"+jb.getCustomer_name1());
		

			
			return "success";	
		
		
		
	}
	
	
	
	public String Print() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String datefrom = psb.getFrom_date22();
		String dateto = psb.getTo_date122();
df=datefrom;
dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);*/
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
String invoiceno = request1.getParameter("invoice_no");
String jobcardno = request1.getParameter("job_card_no");
		//purchase_bean psb1=new purchase_bean();

System.out.println("invoiceno"+invoiceno);
System.out.println("jobcardno"+jobcardno);
		try {
			psb = new prn_Dao().Print22(invoiceno,jobcardno);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		
		
		//System.out.println("sumtot" + psb1.getPaybycashtotal());
		
		return "success";

	}
	
	
	
	
	
	public String Print444() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String datefrom = psb.getFrom_date22();
		String dateto = psb.getTo_date122();
df=datefrom;
dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);*/
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
String invoiceno = request1.getParameter("invoice_no");
String jobcardno = request1.getParameter("job_card_no");
		//purchase_bean psb1=new purchase_bean();

System.out.println("invoiceno"+invoiceno);
System.out.println("jobcardno"+jobcardno);
		try {
			psb = new prn_Dao().Print44(invoiceno,jobcardno);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		
		
		//System.out.println("sumtot" + psb1.getPaybycashtotal());
		
		return "success";

	}
	
	
	
	
	
	
	
	
	
	
	
	

	public String prod3() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		String mode = psb.getMode();
		System.out.println("datefrom" + datefrom + "dateto" + dateto);
df=datefrom;
dt=dateto;
mode=mode;
		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().prodd2(datefrom, dateto, mode);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in prod3 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount =report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "success";

	}

	public String tax() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().tax(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in tax " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount = report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "success";

	}
	
	
	public String tax22() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();
		df=datefrom;
		dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			psb2 = new prn_Dao().tax22(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in tax " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		/*String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount = report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}*/

		return "success";

	}
	
	public String viewpo() {

		// System.out.println("prod");
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
				String pono = request1.getParameter("pono");
		
		try {
			psb = new prn_Dao().viewpo(pono);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in tax " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		//tot=0.0;
		
		return "success";

	}
	
	public String out22() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);
*/
		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().out22();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in tax " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		//tot=0.0;
		
			for(int i=0;i<report.size();i++)
			{
				totalbalance=report.get(i).getTotalamtlabour();
				tot=Double.parseDouble(totalbalance);
				//System.out.println("double" +tot);
					
			}

		return "success";

	}
	
	
	
	
	//Method For Stock Report
	
	public String Stockreport() throws Exception {


		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		stockreport = new prn_Dao().StockReport();
		
		System.out.println("Size:"+stockreport.size());
		
		return "success";

	}
	
	
	
	
	
	
	
	
	public String alert22() {

		// System.out.println("prod");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
*/
		try {
			report = new prn_Dao().alert22();

		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	System.out.println("Error in tax " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		//tot=0.0;
		
			/*for(int i=0;i<report.size();i++)
			{
				totalbalance=report.get(i).getTotalamtlabour();
				tot=Double.parseDouble(totalbalance);
				//System.out.println("double" +tot);
					
			}*/

		return "success";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String tax_detail_report() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().tax_detail_report(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in tax_detail_report " + datefrom + " "
					+ dateto);
			e.printStackTrace();
		}
		String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount = report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "success";

	}

	public String estimate_search() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().estimate_search(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in tax_detail_report " + datefrom + " "
					+ dateto);
			e.printStackTrace();
		}
		String totalamount = "";
		for (int i = 0; i < report.size(); i++) {
			try {
				totalamount = report.get(i).getTotalamount1();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		try {
			request.setAttribute("totalamount", totalamount);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "success";

	}

	public String invoice_report() {

		// System.out.println("prod");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date();
		String dateto = psb.getTo_date1();

		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);

		try {
			report = new prn_Dao().invoice_report(datefrom, dateto);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in invoice_report " + datefrom + " "
					+ dateto);
			e.printStackTrace();
		}

		return "success";

	}
	
	
	
	
	
	
	
	public String invoicesearch() throws SQLException {

		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String autoinvoice = request.getParameter("autoinvoice");
		
	System.out.println("Product:"+autoinvoice);
		try {
			psb = new prn_Dao().FetchspareMaterial(autoinvoice);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	
	
	public String invoicesearch1() throws SQLException {

		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String autoinvoice = request.getParameter("customer_no");
		
	System.out.println("Product:"+autoinvoice);
		try {
			psb = new prn_Dao().FetchspareMaterial12(autoinvoice);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	
	
/*public String dcreport() {

		
		
		try {
			report = new prn_Dao().dcreport();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
		return "success";
	
	
	
	}*/
	
	
		public String purchaseorderreport() {

		
		
					try {
							report = new prn_Dao().purchaseorderreport();
						}
						
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			
					}
		
	
					return "success";
		
			}
	


		public String DcOsReport() {

			
			
			try {
					report = new prn_Dao().DcOsReport();
				}
				
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}

			return "success";

	}
		
		
		public String DcOwSrcOsReport() {	
			try {
					report = new prn_Dao().DcOwSrcOsReport();
				}
				
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	
			}

			return "success";

	}
		

	public void setPsb1(purchase_bean psb1) {
		this.psb1 = psb1;
	}

	public purchase_bean getPsb1() {
		return psb1;
	}

	public void setPsb2(purchase_bean psb2) {
		this.psb2 = psb2;
	}

	public purchase_bean getPsb2() {
		return psb2;
	}

	public void setTotalbalance(String totalbalance) {
		this.totalbalance = totalbalance;
	}

	public String getTotalbalance() {
		return totalbalance;
	}

	public void setTot(double tot) {
		this.tot = tot;
	}

	public double getTot() {
		return tot;
	}

	public void setTparts(String tparts) {
		this.tparts = tparts;
	}

	public String getTparts() {
		return tparts;
	}

	public String getTigst5() {
		return tigst5;
	}

	public void setTigst5(String tigst5) {
		this.tigst5 = tigst5;
	}

	public String getTigst12() {
		return tigst12;
	}

	public void setTigst12(String tigst12) {
		this.tigst12 = tigst12;
	}

	public String getTigst18() {
		return tigst18;
	}

	public void setTigst18(String tigst18) {
		this.tigst18 = tigst18;
	}

	public String getTigst28() {
		return tigst28;
	}

	public void setTigst28(String tigst28) {
		this.tigst28 = tigst28;
	}

	public void setTlabour(String tlabour) {
		this.tlabour = tlabour;
	}

	public String getTlabour() {
		return tlabour;
	}

	public void setTot1(String tot1) {
		this.tot1 = tot1;
	}

	public String getTot1() {
		return tot1;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public String getDf() {
		return df;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getDt() {
		return dt;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getL() {
		return l;
	}

	@Override
	public purchase_bean getModel() {
		// TODO Auto-generated method stub
		return psb;
	}

	/*public void setTota(double tota) {
		this.tota = tota;
	}

	public double getTota() {
		return tota;
	}*/

	public void setTota44(String tota44) {
		this.tota44 = tota44;
	}

	public String getTcgst25() {
		return tcgst25;
	}

	public void setTcgst25(String tcgst25) {
		this.tcgst25 = tcgst25;
	}

	public String getTcgst6() {
		return tcgst6;
	}

	public void setTcgst6(String tcgst6) {
		this.tcgst6 = tcgst6;
	}

	public String getTcgst9() {
		return tcgst9;
	}

	public void setTcgst9(String tcgst9) {
		this.tcgst9 = tcgst9;
	}

	public String getTcgst14() {
		return tcgst14;
	}

	public void setTcgst14(String tcgst14) {
		this.tcgst14 = tcgst14;
	}

	public String getTsgst25() {
		return tsgst25;
	}

	public void setTsgst25(String tsgst25) {
		this.tsgst25 = tsgst25;
	}

	public String getTsgst6() {
		return tsgst6;
	}

	public void setTsgst6(String tsgst6) {
		this.tsgst6 = tsgst6;
	}

	public String getTsgst9() {
		return tsgst9;
	}

	public void setTsgst9(String tsgst9) {
		this.tsgst9 = tsgst9;
	}

	public String getTsgst14() {
		return tsgst14;
	}

	public void setTsgst14(String tsgst14) {
		this.tsgst14 = tsgst14;
	}

	public String getTota44() {
		return tota44;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

}
