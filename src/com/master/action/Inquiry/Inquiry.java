package com.master.action.Inquiry;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Destination;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;
import javax.print.event.PrintJobListener;
import javax.servlet.http.HttpServletRequest;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.job_card_dao;
import com.master.dao.Inquiry.InquiryDao;
import com.master.model.InquiryBean;
import com.master.model.TripModel;
import com.master.model.expenses_Bean;
import com.master.model.invoicebean;
import com.master.util.AmtInWord;
import com.master.util.CoreData;
import com.master.util.EnglishNumberToWords;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Inquiry extends ActionSupport implements ServletRequestAware, SessionAware, ModelDriven<InquiryBean>{

	
	private List<InquiryBean> inquiryReport= new ArrayList<InquiryBean>();
	
	private List<InquiryBean> Report= new ArrayList<InquiryBean>();
	private List<InquiryBean> Report1= new ArrayList<InquiryBean>();	
	private expenses_Bean expenses=new expenses_Bean();

	
	

	public expenses_Bean getExpenses() {
		return expenses;
	}


	public void setExpenses(expenses_Bean expenses) {
		this.expenses = expenses;
	}


	private List<TripModel> Report2= new ArrayList<TripModel>();
	private List<TripModel> Report3= new ArrayList<TripModel>();
	
	public List<TripModel> getReport3() {
		return Report3;
	}


	public void setReport3(List<TripModel> report3) {
		Report3 = report3;
	}


	public List<TripModel> getReport2() {
		return Report2;
	}


	public void setReport2(List<TripModel> report2) {
		Report2 = report2;
	}


	private List<InquiryBean> invoicebean_1 = new ArrayList<InquiryBean>();
		
	private InquiryBean im=new InquiryBean();
	
	HttpServletRequest request;
	
	private String name;
	private String vendor;
	private String price_id;
	private String inq_id;
	private String total;
	private String remark;
	private String datee;
	
	private String lr_no;
	
	private String issueamount;
	
	private String expenceseamount;
	
	
	
	
	
	public String getExpenceseamount() {
		return expenceseamount;
	}


	public void setExpenceseamount(String expenceseamount) {
		this.expenceseamount = expenceseamount;
	}


	public String getIssueamount() {
		return issueamount;
	}


	public void setIssueamount(String issueamount) {
		this.issueamount = issueamount;
	}


	public String getLr_no() {
		return lr_no;
	}


	public void setLr_no(String lr_no) {
		this.lr_no = lr_no;
	}

	private String total12;

	public String getTotal12() {
		return total12;
	}


	public void setTotal12(String total12) {
		this.total12 = total12;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	String amt="";
	
	
	
	private String pricing_id;
	private String date;
	private String src_contact_person;
	private String src_contact_no;
	private String customer_name;
	private String address;
	private String mobile_no;
	private String dest_contact_person;
	private String dest_contact_no;
	private String shipstate;
	private String shipgstn;
	private String shipadd;
	private String shipname;
	private String ebillno;
	private String invoiceno;
	private String route;
	private String delevery_date;
	private String delivery_time;
	private String vehicle_type;
	private String total_weight;
	private String inquiry_id;
	
	private String payterm;
	
	private String ref;
	
	private String kind;
	
	
	
	private String contact_person;
	private String contact_no;
	
	private String resource;
	
	
	
	
	public String getResource() {
		return resource;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}


	public String getContact_person() {
		return contact_person;
	}


	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}


	public String getContact_no() {
		return contact_no;
	}


	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}


	public String getTransporter_name() {
		return transporter_name;
	}


	public void setTransporter_name(String transporter_name) {
		this.transporter_name = transporter_name;
	}


	private String transporter_name;
	
	
	private String response1="";
	
	
	
	public String logout()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
		
	}
	
	
	public String execute()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	public String price_check()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	public String priceForm()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	
	public String alert()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	
	public String SessionOut()
	{
		
		
		
		return "success";
		
	}
	
	public String company()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	public String insert_inquiry()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_inquiry(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}

	
	
	public String insert_alert()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_alert(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	public String insert_company()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_company(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	public String alertEdit()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		inquiryReport = new InquiryDao().alertEdit(im,bean,id);
		
		
		
		return "success";
	}
	
	
	
	public String companyEdit()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		inquiryReport = new InquiryDao().companyEdit(im,bean,id);
		
		
		
		return "success";
	}
	
	
	
	
	public String alertUpdate() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().alertUpdate(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().alertReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	public String companyUpdate() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().companyUpdate(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().companyReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	
	public String alertDone()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().alertDone(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().alertReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	
	public String companyDelete()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().companyDelete(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().companyReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	public String alertReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().alertReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String companyReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().companyReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String alertDoneReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().alertDoneReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String alertExpectedReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().alertExpectedReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String alertEdit1()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		inquiryReport = new InquiryDao().alertEdit(im,bean,id);
		
		
		
		return "success";
	}
	
	
	
	
	public String alertUpdate1() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().alertUpdate(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().alertExpectedReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	
	public String alertDone1()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String id=request.getParameter("id");
		
		String ss = new InquiryDao().alertDone(im,bean,id);
		
		if(ss.equals("success"))
		
		{
		
			inquiryReport = new InquiryDao().alertExpectedReport(im,bean);
		
			return "success";
		}
		
		else {
			
			return "success";
		}
		
	}
	
	
	
	public String fetchInquiryReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().fetchInquiryReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String fetchPriceCheckReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String source=request.getParameter("source");
		
		String dest=request.getParameter("dest");
		
		inquiryReport = new InquiryDao().fetchPriceCheckReport(im,bean,source,dest);
		
		
		
		return "success";
	}
	
	
	public String fetchPriceCheckReport1()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String source=request.getParameter("source");
		
		String dest=request.getParameter("dest");
		
		inquiryReport = new InquiryDao().fetchPriceCheckReport(im,bean,source,dest);
		
		
		
		return "success";
	}
	
	public String fetchPriceCheckReport123()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String source=request.getParameter("source");
		
		String dest=request.getParameter("dest");
		
		inquiryReport = new InquiryDao().fetchPriceCheckReport123(im,bean,source,dest);
		
		
		
		return "success";
	}
	
	
	
	
	
	public String enquiryCancel()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String inquiry_id=request.getParameter("inquiry_id");
		
		String status = new InquiryDao().enquiryCancel(im,bean,inquiry_id);
		
		
		
		return "success";
		
		//return "editProductMaster";
	}
	
	
	private String source12;
	
	private String print_file;
	
	

	public static boolean isJobRunning() {
		return jobRunning;
	}


	public static void setJobRunning(boolean jobRunning) {
		Inquiry.jobRunning = jobRunning;
	}


	private String dest12;
	
	public String getSource12() {
		return source12;
	}


	public void setSource12(String source12) {
		this.source12 = source12;
	}


	public String getDest12() {
		return dest12;
	}


	public void setDest12(String dest12) {
		this.dest12 = dest12;
	}


	
	public String enquiryDone()
	
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		source12=request.getParameter("source");
		
		dest12=request.getParameter("dest");
	
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	
	
	public String insert_pricing() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_pricing(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	
	public String insert_pricing_check() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_pricing_check(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
public String insert_pricing_check123() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_pricing_check123(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	
	public String fetchPricingReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().fetchPricingReport(im,bean);
		
		
		
		return "success";
	}
	
	
	public String fetchPricingReport1()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().fetchPricingReport1(im,bean);
		
		
		
		return "success";
	}
	
	
	public String pricingCancel()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String pricing_id=request.getParameter("pricing_id");
		
		String status = new InquiryDao().pricingCancel(im,bean,pricing_id);
		
		
		
		return "success";
		
		
	}
	
	
	
	public String editPricing()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String pricing_id=request.getParameter("pricing_id");
		
		inquiryReport = new InquiryDao().editPricing(im,bean,pricing_id);
		
		
		
		
		
		for(int i=0;i<inquiryReport.size();i++){
			
			
			vendor=inquiryReport.get(i).getVendor();
			price_id=inquiryReport.get(i).getPricing_id();
			inq_id=inquiryReport.get(i).getInquiry_id();
			total=inquiryReport.get(i).getTotal();
			remark=inquiryReport.get(i).getRemark();
			datee=inquiryReport.get(i).getDate();
		
		}
		request.setAttribute("vendor",vendor);
		request.setAttribute("price_id",price_id);
		request.setAttribute("inq_id",inq_id);
		request.setAttribute("total",total);
		request.setAttribute("remark",remark);
		request.setAttribute("datee",datee);
		
		
		return "success";
	}
	
	
	
	
	public String update_pricing()
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = null;
		try {
			
			status = new InquiryDao().update_pricing(im,bean);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	
	public String quotation()
	
	{
		
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		source12=request.getParameter("pricing_id");
		
		//dest12=request.getParameter("desti");
	
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		Report = new InquiryDao().Quotation_View_Print_griddeta(im,bean,source12);
		
		
		
		return  "success";
		
	}
	
	
	
	
	  private static boolean jobRunning = true;
	  
	  
	  
	  
	  
	  
	  private static class JobCompleteMonitor extends PrintJobAdapter {
		    @Override
		    public void printJobCompleted(PrintJobEvent jobEvent) {
		        System.out.println("Job completed");
		        jobRunning = false;
		    }
		}

public String quotation123() throws PrintException, InterruptedException, URISyntaxException, IOException
	
	{
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
		
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		print_file=request.getParameter("print_file");
		
		
		
		
		String skk=print_file.replace('', '/');
		
		 skk=print_file.replace('?', '/');
		 
		System.out.println("lllllllllllllllllllllll----------"+skk);
		
		System.out.println("ooooooooooooo----------   "+print_file);
		
		System.out.println("yyyyyyyyyyyyyyyyyyy--------"+im.getPrint_file12());
		
		 InputStream is = new BufferedInputStream(new FileInputStream("D:/Naval/sample.pdf"));
		 
		
		DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
		 
		  // Locate the default print service for this environment.
		 
		  PrintService service = PrintServiceLookup.lookupDefaultPrintService();
		 
		
		  // any of the supported document flavors.
		 
		  DocPrintJob printJob = service.createPrintJob();
		 
		  // register a listener to get notified when the job is complete
		 
		  
		  printJob.addPrintJobListener(new JobCompleteMonitor());
		 
		  // Construct a SimpleDoc with the specified 
		 
		  // print data, doc flavor and doc attribute set.
		 
		  Doc doc = new SimpleDoc(is, flavor, null);
		 
		  // set up the attributes
		 
		  PrintRequestAttributeSet attributes = new HashPrintRequestAttributeSet();
		 
		  attributes.add(new Destination(new java.net.URI("file:C:/aa/myfile.ps")));
		 
		  // Print a document with the specified job attributes.
		 
		  printJob.print(doc, attributes);
		 
		  while (jobRunning) {
		 
		    Thread.sleep(1000);
		 
		  }
		 is.close();
	return  "success";
		
	}




	
	
	
	
	public String insert_quotation() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_quotation(im,bean);
		
		String qtno=im.getQuotation_no();
		
		System.out.println("Qu::"+qtno);
		
		Report = new InquiryDao().Quotation_View_Print(im,bean,qtno);
		
		Report1 = new InquiryDao().Quotation_View_Print1(im,bean,qtno);
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	public String fetchQuotationReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().fetchQuotationReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String quotation_view()
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String quotation_no=request.getParameter("quotation_no");
		
		inquiryReport = new InquiryDao().viewQuotation(im,bean,quotation_no);
		
		
			
			
		
		for(int i=0;i<inquiryReport.size();i++){
			
			
			vendor=inquiryReport.get(i).getName();
			price_id=inquiryReport.get(i).getAddress();
			inq_id=inquiryReport.get(i).getQuotation_no();
			total=inquiryReport.get(i).getTotal();
			remark=inquiryReport.get(i).getContact_no();
			datee=inquiryReport.get(i).getDate();
			
			payterm=inquiryReport.get(i).getPayterm();
			
			ref=inquiryReport.get(i).getReference();
			kind=inquiryReport.get(i).getKind_attn();
			
		
		}
		request.setAttribute("vendor",vendor);
		request.setAttribute("price_id",price_id);
		request.setAttribute("inq_id",inq_id);
		request.setAttribute("total",total);
		request.setAttribute("remark",remark);
		request.setAttribute("datee",datee);
		
		request.setAttribute("payterm",payterm);
		
		request.setAttribute("reference",ref);
		request.setAttribute("kind_attn",kind);
		
		
		return  "success";
		
	}



	public String update_quotation()
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = null;
		try {
			
			status = new InquiryDao().update_quotation(im,bean);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	public String quotation_print() throws SQLException{

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String qtno=request.getParameter("quotation_no");
		
		Report = new InquiryDao().Quotation_View_Print(im,bean,qtno);
		Report1 = new InquiryDao().Quotation_View_Print1(im,bean,qtno);
		
			
		  return "success";

	}
	
	
	
	public String quotationCancel()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String quotation_no=request.getParameter("quotation_no");
		
		String status = new InquiryDao().quotationCancel(im,bean,quotation_no);
		
		
		
		return "success";
		
		
	}
	
	
	
	
	public String revise_Quotation()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	
	public String revise_Quotation1()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().revise_Quotation1(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String quotation_print1() throws SQLException{

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String qtno=request.getParameter("quotation_no");
		
		String rno=request.getParameter("rno");
		
		Report = new InquiryDao().Re_Quotation_View_Print(im,bean,qtno,rno);
		Report1 = new InquiryDao().Re_Quotation_View_Print1(im,bean,qtno,rno);
		
			
		  return "success";

	}
	
	
	

	public String quotationFinal()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		
		
		return "success";
	}
	
	
	
	public String quotationFinal1() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		//String response;
		//HttpServletRequest request=ServletActionContext.getRequest();
		
		//String quotation_no=request.getParameter("quotation_no");
		
		String status = new InquiryDao().quotationFinal(im,bean);
		
		
		
		//inquiryReport = new InquiryDao().fetchQuotationReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	public String order()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String p_id=request.getParameter("pricing_id");
		
		inquiryReport = new InquiryDao().fetchPricingDetails(im,bean,p_id);
		
		return  "success";
		
	}
	
	
public String Add_New_Rate() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().Add_New_Rate(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}else if(status.equals("already"))
			
		{
			
			return "already";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	public String insert_order() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().insert_order(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	
	public String fetchOrderReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().fetchOrderReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	
	public String orderCancel()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String order_id=request.getParameter("order_id");
		
		String status = new InquiryDao().orderCancel(im,bean,order_id);
		
		//inquiryReport = new InquiryDao().fetchOrderReport(im,bean);
		
		return "success";
		
		
	}
	
public String EditRateMaster()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String rateid=request.getParameter("rateid");
		
		im = new InquiryDao().EditRateMaster(im,bean,rateid);
		
		System.out.println("LR:"+im.getId());
		
		
			
		
		return  "success";
		
	}
	
	
	public String orderEdit()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String order_id=request.getParameter("order_id");
		
		im = new InquiryDao().orderEdit(im,bean,order_id);
		
		System.out.println("LR:"+im.getLr_no());
		
		/*for(int i=0;i<inquiryReport.size();i++){
			
			
			pricing_id=inquiryReport.get(i).getPricing_id();
			date=inquiryReport.get(i).getDate();
			src_contact_person=inquiryReport.get(i).getSrc_contact_person();
			src_contact_no=inquiryReport.get(i).getSrc_contact_no();
			customer_name=inquiryReport.get(i).getName();
			address=inquiryReport.get(i).getAddress();
			mobile_no=inquiryReport.get(i).getContact_no();
			dest_contact_person=inquiryReport.get(i).getDest_contact_person();
			dest_contact_no=inquiryReport.get(i).getDest_contact_no();
			shipstate=inquiryReport.get(i).getShipstate();
			shipgstn=inquiryReport.get(i).getShipgstn();
			shipadd=inquiryReport.get(i).getShipadd();
			shipname=inquiryReport.get(i).getShipname();
			ebillno=inquiryReport.get(i).getEbillno();
			invoiceno=inquiryReport.get(i).getInvoiceno();
			route=inquiryReport.get(i).getRoute();
			delevery_date=inquiryReport.get(i).getDelevery_date();
			delivery_time=inquiryReport.get(i).getDelivery_time();
			vehicle_type=inquiryReport.get(i).getVehicle_type();
			total_weight=inquiryReport.get(i).getTotal1();
			inquiry_id=inquiryReport.get(i).getInquiry_id();
			total=inquiryReport.get(i).getTotal();
			remark=inquiryReport.get(i).getRemark();
			
		
		
		}
		
		request.setAttribute("total",total);
		request.setAttribute("remark",remark);
		
		
		request.setAttribute("pricing_id",pricing_id);
		request.setAttribute("date",date);
		request.setAttribute("src_contact_person",src_contact_person);
		request.setAttribute("src_contact_no",src_contact_no);
		request.setAttribute("customer_name",customer_name);
		
		request.setAttribute("address",address);
		request.setAttribute("mobile_no",mobile_no);
		request.setAttribute("dest_contact_person",dest_contact_person);
		request.setAttribute("dest_contact_no",dest_contact_no);
		request.setAttribute("shipstate",shipstate);
		
		request.setAttribute("shipgstn",shipgstn);
		request.setAttribute("shipadd",shipadd);
		request.setAttribute("shipname",shipname);
		request.setAttribute("ebillno",ebillno);
		request.setAttribute("invoiceno",invoiceno);
		
		request.setAttribute("route",route);
		request.setAttribute("delevery_date",delevery_date);
		request.setAttribute("delivery_time",delivery_time);
		request.setAttribute("vehicle_type",vehicle_type);
		request.setAttribute("total_weight",total_weight);
		
		request.setAttribute("inquiry_id",inquiry_id);*/
		
			
		
		return  "success";
		
	}
	
	
	
	public String orderUpdate()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
	
		
		String status = new InquiryDao().orderUpdate(im,bean);
		
		
		
		return  "success";
		
	}
	
	
	
	public String vehicleChange()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String order_id=request.getParameter("order_id");
		
		im = new InquiryDao().vehicleChange(im,bean,order_id);
		
			
		return  "success";
		
	}
	
	
	public String vehicleChangeSuccess()
	
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
	
		
		String status = new InquiryDao().vehicleChangeSuccess(im,bean);
		
		
		
		return  "success";
		
	}
	
	
	
	public String orderLr()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String order_id=request.getParameter("order_id");
		
		String lr_no=request.getParameter("lr_no");
		
		
		im = new InquiryDao().orderLr(im,bean,order_id,lr_no);
		//inquiryReport = new InquiryDao().orderLr(im,bean,order_id,lr_no);
		
		//inquiryReport = new InquiryDao().orderLr(im,bean,order_id,lr_no);
		
		
		//inquiryReport = new InquiryDao().orderLR(im,bean,order_id);
		
		
		return  "success";
		
	}
	
	
	public String orderLrCommon()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return  "success";
		
	}
	
	
	
	public String deliveryAlertReport()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		inquiryReport = new InquiryDao().deliveryAlertReport(im,bean);
		
		
		
		return "success";
	}
	
	
	
	
	public String Add_New_Location()throws IOException,SQLException
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
			
		String loc = request.getParameter("name");
			
		response1 = new InquiryDao().insertLocationInfo(loc);
		
		
		System.out.println("<<<<"+response1);
		
		if(response1.equalsIgnoreCase("already"))
		{
			//request.setAttribute("role_bean",Job_card_bean);
			return "already";
		}
		
		else if(response1.equalsIgnoreCase("success"))
		
		{
			return "success";	
		
		}else{
			
			return "fail";	
		}
		
		
	}
	
	
	
	
	public String Add_New_Transporter()throws IOException,SQLException
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
			
		String name = request.getParameter("name");
		
		String mobile = request.getParameter("mobile");
			
		response1 = new InquiryDao().Add_New_Transporter(name,mobile);
		
		
		System.out.println("<<<<"+response1);
		
		if(response1.equalsIgnoreCase("already"))
		{
			//request.setAttribute("role_bean",Job_card_bean);
			return "already";
		}
		
		else if(response1.equalsIgnoreCase("success"))
		
		{
			return "success";	
		
		}else{
			
			return "fail";	
		}
		
		
	}
	
	
	
	
	public String fetchSchemeDetails() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();

		String autoinvoice = request.getParameter("lr");
		
		String msg="";

		try {
			
			im = new InquiryDao().FetchSchemeDetails(autoinvoice);
			
			System.out.println("Size:"+im.getSchemeid1().size());
			
			if(im.getSchemeid1().size()>0){
				
				msg= "success";
			}else{
				
				msg= "nodata";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;

	}
	
	public String assignCommonInvoice() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String lr = request.getParameter("lr_no");
		
		
		System.out.println("LR:"+lr);
		
		
		
		response1 = new job_card_dao().getnvnumber(bean);
		
		
		im  = new InquiryDao().assignCommonInvoice(im,lr,response1,bean);
		
		
		
			return "success";
		
	}
	
	
	
	
	
	
	
	
	
public String assignPIInvoice() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String lr = request.getParameter("lr_no");
		
		
		System.out.println("LR:"+lr);
		
		
		
		response1 = new job_card_dao().getPInvnumber(bean);
		
		
		im  = new InquiryDao().assignPIInvoice(im,lr,response1,bean);
		
		//System.out.println(">>>>>>>zzz"+bin.getGridsize());
			return "success";
		
	}
	
	
	public String commonInvoiceSubmit() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		double total=0.0;
		total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
		
		
		String status = new InquiryDao().commonInvoiceSubmit(im,bean,total);
		
		double ssk=Double.parseDouble(request.getParameter("total12"));
		
		
		Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
		
		Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
		//total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
		
		expenceseamount=String.valueOf(total);
		issueamount=String.valueOf(total+ssk);
		
		
		
		if(status.equals("success"))
			
		{
			
			
					for (int j1 = 0; j1 < im.getAa().length; j1++) {
						
						InquiryBean ib1 = new InquiryBean();

						
						if(im.getHh()[j1].equals(im.getAa()[j1]))
						{
							ib1.setAa1(im.getHh()[j1]);
						}
						else
						{
							//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
							ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
						}
						
							
							
							ib1.setBb1(im.getBb()[j1]);
							
							ib1.setCc1(im.getCc()[j1]);
							
							ib1.setDd1(im.getDd()[j1]);
							
							ib1.setEe1(im.getEe()[j1]);
							
							ib1.setFf1(im.getFf()[j1]);
							
							ib1.setGg1(im.getGg()[j1]);
							
							/*ib1.setHh1(im.getHh()[j1]);
							*/
							ib1.setIi1(im.getIi()[j1]);
						
							
							
							invoicebean_1.add(ib1);
							
						}
					try {
						String WholeNumber = "", Decimal = "";
						String StringOfOne = issueamount;

						boolean isDecimal = false;

						int decimalIndex = StringOfOne.lastIndexOf(".");

						if (decimalIndex >= 0) {
							WholeNumber = StringOfOne.substring(0, decimalIndex);
							Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
									+ StringOfOne.substring(StringOfOne.length());

							// now you have the WholeNumber split up.
							isDecimal = true;
						} else {
							WholeNumber = issueamount;
						}

						if (isDecimal) {
							String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
							im.setAmountinwords(captializeAllFirstLetter(temp));

						} else {
							String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
									+ "  Only";
							
							/* String kkpl="";
							String sskp[]=temp.split(" ");
							
							for(int i=0;i<sskp.length;i++)
							{
								String kkk="";
								kkk=sskp[i].charAt(0);
							}
							*/
							String kkk= captializeAllFirstLetter(temp);
							
							System.out.println("jjjjjjj------"+kkk);
							
							im.setAmountinwords(kkk);

						}

						 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

						 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
					} catch (Exception e) {
						System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
					}
			
			
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	String captializeAllFirstLetter(String name) 
    {
        char[] array = name.toCharArray();
        array[0] = Character.toUpperCase(array[0]);

        for (int i = 1; i < array.length; i++) {
            if (Character.isWhitespace(array[i - 1])) {
                array[i] = Character.toUpperCase(array[i]);
            }
        }

        return new String(array);
    }
	
	public String commonInvoiceUpdate() throws Exception
	
		{
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			double total=0.0;
			total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
			String status = new InquiryDao().commonInvoiceUpdate(im,bean,total);
			
			
			//double ssk=Double.parseDouble(request.getParameter("total12"));
			
			
			Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
			
			Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
			total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
			
			
			total=Math.round(total*100.00)/100.00;
			
			String ssk = new InquiryDao().commonInvoicelrno(im,bean);
			
			String kkk[]=ssk.split("~");
			double aa=Double.parseDouble(kkk[0]);
			double bb=Double.parseDouble(kkk[1]);
			
			im.setLr_amount(String.valueOf(aa));
			
			
			expenceseamount=String.valueOf(total);
			
			
			
			issueamount=String.valueOf(bb);
		
			
		
		
			if(status.equals("success"))
			
			{
			
				 
				
					for (int j1 = 0; j1 < im.getAa().length; j1++) {
						
						InquiryBean ib1 = new InquiryBean();

						
						if(im.getHh()[j1].equals(im.getAa()[j1]))
						{
							ib1.setAa1(im.getHh()[j1]);
						}
						else
						{
							//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
							ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
						}
						
							//ib1.setAa1(im.getHh()[j1]);
							
							ib1.setBb1(im.getBb()[j1]);
							
							ib1.setCc1(im.getCc()[j1]);
							
							ib1.setDd1(im.getDd()[j1]);
							
							ib1.setEe1(im.getEe()[j1]);
							
							ib1.setFf1(im.getFf()[j1]);
							
							ib1.setGg1(im.getGg()[j1]);
							
							/*ib1.setHh1(im.getHh()[j1]);*/
							
							ib1.setIi1(im.getIi()[j1]);
						
							
							
							invoicebean_1.add(ib1);
							
						}
					try {
						String WholeNumber = "", Decimal = "";
						String StringOfOne = issueamount;

						boolean isDecimal = false;

						int decimalIndex = StringOfOne.lastIndexOf(".");

						if (decimalIndex >= 0) {
							WholeNumber = StringOfOne.substring(0, decimalIndex);
							Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
									+ StringOfOne.substring(StringOfOne.length());

							// now you have the WholeNumber split up.
							isDecimal = true;
						} else {
							WholeNumber = issueamount;
						}

						if (isDecimal) {
							String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
							im.setAmountinwords(temp.toUpperCase());

						} else {
							String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
									+ "  only";
							
							String kkkk= captializeAllFirstLetter(temp);
							
							System.out.println("jjjjjjj------"+kkkk);
							
							im.setAmountinwords(kkkk);
						}

						 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

						 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
					} catch (Exception e) {
						System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
					}
			
			
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
	public String pi_commonInvoiceUpdate() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		String status = new InquiryDao().pi_commonInvoiceUpdate(im,bean);
		
		
		//double ssk=Double.parseDouble(request.getParameter("total12"));
		
		
		Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
		double total=0.0;
		Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
		total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
		
		
		total=Math.round(total*100.00)/100.00;
		
		String ssk = new InquiryDao().pi_commonInvoicelrno(im,bean);
		
		String kkk[]=ssk.split("~");
		double aa=Double.parseDouble(kkk[0]);
		double bb=Double.parseDouble(kkk[1]);
		
		im.setLr_amount(String.valueOf(aa));
		
		
		expenceseamount=String.valueOf(total);
		
		
		
		issueamount=String.valueOf(bb);
	
		
	
	
		if(status.equals("success"))
		
		{
		
			 
			
				for (int j1 = 0; j1 < im.getAa().length; j1++) {
					
					InquiryBean ib1 = new InquiryBean();

					
					if(im.getHh()[j1].equals(im.getAa()[j1]))
					{
						ib1.setAa1(im.getHh()[j1]);
					}
					else
					{
						//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
						ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
					}
					
						//ib1.setAa1(im.getHh()[j1]);
						
						ib1.setBb1(im.getBb()[j1]);
						
						ib1.setCc1(im.getCc()[j1]);
						
						ib1.setDd1(im.getDd()[j1]);
						
						ib1.setEe1(im.getEe()[j1]);
						
						ib1.setFf1(im.getFf()[j1]);
						
						ib1.setGg1(im.getGg()[j1]);
						
						/*ib1.setHh1(im.getHh()[j1]);*/
						
						ib1.setIi1(im.getIi()[j1]);
					
						
						
						invoicebean_1.add(ib1);
						
					}
				try {
					String WholeNumber = "", Decimal = "";
					String StringOfOne = issueamount;

					boolean isDecimal = false;

					int decimalIndex = StringOfOne.lastIndexOf(".");

					if (decimalIndex >= 0) {
						WholeNumber = StringOfOne.substring(0, decimalIndex);
						Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
								+ StringOfOne.substring(StringOfOne.length());

						// now you have the WholeNumber split up.
						isDecimal = true;
					} else {
						WholeNumber = issueamount;
					}

					if (isDecimal) {
						String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
						im.setAmountinwords(temp.toUpperCase());

					} else {
						String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
								+ "  only";
						
						String kkkk= captializeAllFirstLetter(temp);
						
						System.out.println("jjjjjjj------"+kkkk);
						
						im.setAmountinwords(kkkk);
					}

					 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

					 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
				} catch (Exception e) {
					System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
				}
		
		
		
		return "success";
	}
	
	else {
	
		return "fail";
	}
	
}

	
	
	
	public String commonInvoiceUpdate12() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		//String status = new InquiryDao().commonInvoiceUpdate(im,bean);
		
		String status="success";
		//double ssk=Double.parseDouble(request.getParameter("total12"));
		
		
		Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
		double total=0.0;
		Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
		total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
		
		
		total=Math.round(total*100.00)/100.00;
		
		String ssk = new InquiryDao().commonInvoicelrno(im,bean);
		
		String kkk[]=ssk.split("~");
		double aa=Double.parseDouble(kkk[0]);
		double bb=Double.parseDouble(kkk[1]);
		
		im.setLr_amount(String.valueOf(aa));
		
		
		expenceseamount=String.valueOf(total);
		
		issueamount=String.valueOf(bb);
	
		if(status.equals("success"))
		
		{
				for (int j1 = 0; j1 < im.getAa().length; j1++) {
					
					InquiryBean ib1 = new InquiryBean();

						
					
					if(im.getHh()[j1].equals(im.getAa()[j1]))
					{
						ib1.setAa1(im.getHh()[j1]);
					}
					else
					{
						//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
						ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
					}
					
					//ib1.setAa1(im.getHh()[j1]);3
						
						ib1.setBb1(im.getBb()[j1]);
						
						ib1.setCc1(im.getCc()[j1]);
						
						ib1.setDd1(im.getDd()[j1]);
						
						ib1.setEe1(im.getEe()[j1]);
						
						ib1.setFf1(im.getFf()[j1]);
						
						ib1.setGg1(im.getGg()[j1]);
						
						/*ib1.setHh1(im.getHh()[j1]);*/
						
						ib1.setIi1(im.getIi()[j1]);
					
						
						
						invoicebean_1.add(ib1);
						
					}
				try {
					String WholeNumber = "", Decimal = "";
					String StringOfOne = issueamount;

					boolean isDecimal = false;

					int decimalIndex = StringOfOne.lastIndexOf(".");

					if (decimalIndex >= 0) {
						WholeNumber = StringOfOne.substring(0, decimalIndex);
						Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
								+ StringOfOne.substring(StringOfOne.length());

						// now you have the WholeNumber split up.
						isDecimal = true;
					} else {
						WholeNumber = issueamount;
					}

					if (isDecimal) {
						String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
						im.setAmountinwords(temp.toUpperCase());

					} else {
						String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
								+ "  only";
						
						String kkkk= captializeAllFirstLetter(temp);
						
						System.out.println("jjjjjjj------"+kkkk);
						
						im.setAmountinwords(kkkk);
					}

					 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

					 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
				} catch (Exception e) {
					System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
				}
		
		
		
		return "success";
	}
	
	else {
	
		return "fail";
	}
	
}


	
	
	
public String pi_commonInvoiceUpdate12() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		//String status = new InquiryDao().commonInvoiceUpdate(im,bean);
		
		String status="success";
		//double ssk=Double.parseDouble(request.getParameter("total12"));
		
		
		Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
		double total=0.0;
		Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
		total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
		
		
		total=Math.round(total*100.00)/100.00;
		
		String ssk = new InquiryDao().pi_commonInvoicelrno(im,bean);
		
		String kkk[]=ssk.split("~");
		double aa=Double.parseDouble(kkk[0]);
		double bb=Double.parseDouble(kkk[1]);
		
		im.setLr_amount(String.valueOf(aa));
		
		
		expenceseamount=String.valueOf(total);
		
		issueamount=String.valueOf(bb);
	
		if(status.equals("success"))
		
		{
				for (int j1 = 0; j1 < im.getAa().length; j1++) {
					
					InquiryBean ib1 = new InquiryBean();

						
					
					if(im.getHh()[j1].equals(im.getAa()[j1]))
					{
						ib1.setAa1(im.getHh()[j1]);
					}
					else
					{
						//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
						ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
					}
					
					//ib1.setAa1(im.getHh()[j1]);3
						
						ib1.setBb1(im.getBb()[j1]);
						
						ib1.setCc1(im.getCc()[j1]);
						
						ib1.setDd1(im.getDd()[j1]);
						
						ib1.setEe1(im.getEe()[j1]);
						
						ib1.setFf1(im.getFf()[j1]);
						
						ib1.setGg1(im.getGg()[j1]);
						
						/*ib1.setHh1(im.getHh()[j1]);*/
						
						ib1.setIi1(im.getIi()[j1]);
					
						
						
						invoicebean_1.add(ib1);
						
					}
				try {
					String WholeNumber = "", Decimal = "";
					String StringOfOne = issueamount;

					boolean isDecimal = false;

					int decimalIndex = StringOfOne.lastIndexOf(".");

					if (decimalIndex >= 0) {
						WholeNumber = StringOfOne.substring(0, decimalIndex);
						Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
								+ StringOfOne.substring(StringOfOne.length());

						// now you have the WholeNumber split up.
						isDecimal = true;
					} else {
						WholeNumber = issueamount;
					}

					if (isDecimal) {
						String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
						im.setAmountinwords(temp.toUpperCase());

					} else {
						String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
								+ "  only";
						
						String kkkk= captializeAllFirstLetter(temp);
						
						System.out.println("jjjjjjj------"+kkkk);
						
						im.setAmountinwords(kkkk);
					}

					 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

					 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
				} catch (Exception e) {
					System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
				}
		
		
		
		return "success";
	}
	
	else {
	
		return "fail";
	}
	
}

	
	
	
public String manualsmssend() throws Exception
	
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String status = new InquiryDao().manualsmssend_order(im,bean);
		
		
		if(status.equals("success"))
			
		{
			
			return "success";
		}
		
		else {
		
			return "fail";
		}
		
	}
	
	
	
public String commonInvoicePISubmit() throws Exception

{
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);

	String status = new InquiryDao().commonInvoicePISubmit(im,bean);
	
	double ssk=Double.parseDouble(request.getParameter("total12"));
	
	
	Report2 = new InquiryDao().commonInvoiceSubmit123(im,bean);
	double total=0.0;
	Report3 = new InquiryDao().commonInvoiceSubmit123123(im,bean);
	total = new InquiryDao().commonInvoiceSubmit12312322(im,bean);
	
	expenceseamount=String.valueOf(total);
	issueamount=String.valueOf(total+ssk);
	
	if(status.equals("success"))
		
	{
		
		
				for (int j1 = 0; j1 < im.getAa().length; j1++) {
					
					InquiryBean ib1 = new InquiryBean();

					
					if(im.getHh()[j1].equals(im.getAa()[j1]))
					{
						ib1.setAa1(im.getHh()[j1]);
					}
					else
					{
						//ib1.setAa1(im.getHh()[j1]+" ("+im.getAa()[j1]+")");
						ib1.setAa1(im.getAa()[j1]+" ("+im.getHh()[j1]+")");
					}
					
						
						
						ib1.setBb1(im.getBb()[j1]);
						
						ib1.setCc1(im.getCc()[j1]);
						
						ib1.setDd1(im.getDd()[j1]);
						
						ib1.setEe1(im.getEe()[j1]);
						
						ib1.setFf1(im.getFf()[j1]);
						
						ib1.setGg1(im.getGg()[j1]);
						
						/*ib1.setHh1(im.getHh()[j1]);
						*/
						ib1.setIi1(im.getIi()[j1]);
					
						
						
						invoicebean_1.add(ib1);
						
					}
				try {
					String WholeNumber = "", Decimal = "";
					String StringOfOne = issueamount;

					boolean isDecimal = false;

					int decimalIndex = StringOfOne.lastIndexOf(".");

					if (decimalIndex >= 0) {
						WholeNumber = StringOfOne.substring(0, decimalIndex);
						Decimal = StringOfOne.substring(decimalIndex + 1, StringOfOne.length())
								+ StringOfOne.substring(StringOfOne.length());

						// now you have the WholeNumber split up.
						isDecimal = true;
					} else {
						WholeNumber = issueamount;
					}

					if (isDecimal) {
						String temp = " " + AmtInWord.getAmtInWord(Integer.parseInt(WholeNumber));
						im.setAmountinwords(captializeAllFirstLetter(temp));

					} else {
						String temp = " " + EnglishNumberToWords.convert(Integer.parseInt(issueamount))
								+ "  Only";
						
						/* String kkpl="";
						String sskp[]=temp.split(" ");
						
						for(int i=0;i<sskp.length;i++)
						{
							String kkk="";
							kkk=sskp[i].charAt(0);
						}
						*/
						String kkk= captializeAllFirstLetter(temp);
						
						System.out.println("jjjjjjj------"+kkk);
						
						im.setAmountinwords(kkk);

					}

					 //ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

					 //System.out.println("Amount in Words :"+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
				} catch (Exception e) {
					System.out.println("Error: IFC_P_Pedidos_Action  in Print3:" + e.getMessage());
				}
		
		
		
		return "success";
	}
	
	else {
	
		return "fail";
	}
	
}

	
	

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}


	public List<InquiryBean> getInquiryReport() {
		return inquiryReport;
	}



	public void setInquiryReport(List<InquiryBean> inquiryReport) {
		this.inquiryReport = inquiryReport;
	}



	public InquiryBean getIm() {
		return im;
	}



	public void setIm(InquiryBean im) {
		this.im = im;
	}



	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public String getPrice_id() {
		return price_id;
	}


	public void setPrice_id(String price_id) {
		this.price_id = price_id;
	}


	public String getInq_id() {
		return inq_id;
	}


	public void setInq_id(String inq_id) {
		this.inq_id = inq_id;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getDatee() {
		return datee;
	}


	public void setDatee(String datee) {
		this.datee = datee;
	}


	@Override
	public InquiryBean getModel() {
		// TODO Auto-generated method stub
		return im;
	}


	public List<InquiryBean> getReport() {
		return Report;
	}


	public void setReport(List<InquiryBean> report) {
		Report = report;
	}


	public List<InquiryBean> getReport1() {
		return Report1;
	}


	public void setReport1(List<InquiryBean> report1) {
		Report1 = report1;
	}


	public String getAmt() {
		return amt;
	}


	public void setAmt(String amt) {
		this.amt = amt;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public String getPricing_id() {
		return pricing_id;
	}


	public void setPricing_id(String pricing_id) {
		this.pricing_id = pricing_id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getSrc_contact_person() {
		return src_contact_person;
	}


	public void setSrc_contact_person(String src_contact_person) {
		this.src_contact_person = src_contact_person;
	}


	public String getSrc_contact_no() {
		return src_contact_no;
	}


	public void setSrc_contact_no(String src_contact_no) {
		this.src_contact_no = src_contact_no;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getMobile_no() {
		return mobile_no;
	}


	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}


	public String getDest_contact_person() {
		return dest_contact_person;
	}


	public void setDest_contact_person(String dest_contact_person) {
		this.dest_contact_person = dest_contact_person;
	}


	public String getDest_contact_no() {
		return dest_contact_no;
	}


	public void setDest_contact_no(String dest_contact_no) {
		this.dest_contact_no = dest_contact_no;
	}


	public String getShipstate() {
		return shipstate;
	}


	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}


	public String getShipgstn() {
		return shipgstn;
	}


	public void setShipgstn(String shipgstn) {
		this.shipgstn = shipgstn;
	}


	public String getShipadd() {
		return shipadd;
	}


	public void setShipadd(String shipadd) {
		this.shipadd = shipadd;
	}


	public String getShipname() {
		return shipname;
	}


	public void setShipname(String shipname) {
		this.shipname = shipname;
	}


	public String getEbillno() {
		return ebillno;
	}


	public void setEbillno(String ebillno) {
		this.ebillno = ebillno;
	}


	public String getInvoiceno() {
		return invoiceno;
	}


	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}


	public String getRoute() {
		return route;
	}


	public void setRoute(String route) {
		this.route = route;
	}


	public String getDelevery_date() {
		return delevery_date;
	}


	public void setDelevery_date(String delevery_date) {
		this.delevery_date = delevery_date;
	}


	public String getDelivery_time() {
		return delivery_time;
	}


	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}


	public String getVehicle_type() {
		return vehicle_type;
	}


	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}


	public String getTotal_weight() {
		return total_weight;
	}


	public void setTotal_weight(String total_weight) {
		this.total_weight = total_weight;
	}


	public String getInquiry_id() {
		return inquiry_id;
	}


	public void setInquiry_id(String inquiry_id) {
		this.inquiry_id = inquiry_id;
	}


	public String getResponse1() {
		return response1;
	}


	public void setResponse1(String response1) {
		this.response1 = response1;
	}


	public List<InquiryBean> getInvoicebean_1() {
		return invoicebean_1;
	}


	public void setInvoicebean_1(List<InquiryBean> invoicebean_1) {
		this.invoicebean_1 = invoicebean_1;
	}


	public String getPayterm() {
		return payterm;
	}


	public void setPayterm(String payterm) {
		this.payterm = payterm;
	}
	
	
	
	
}