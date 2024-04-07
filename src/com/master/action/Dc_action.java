package com.master.action;

import java.sql.SQLException;
import java.util.ArrayList
;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.Dc_Dao;
import com.master.dao.job_card_dao;
import com.master.dao.Inquiry.InquiryDao;
import com.master.model.Dc_bean;
import com.master.model.LoginBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Dc_action extends ActionSupport implements
		ModelDriven<Dc_bean>, SessionAware {
	private int total_amount = 0;
	private double total_amount1 = 0.0;
	private int partscount;
	private int labourcount;
	private int repaircount;
	private int paintingcount;
	private int refittingcount;
	private String estimateno;
	private String checkme1;
	private String checkme2;
	private String cust_info;
	private String Dc_id;
	
	List<Dc_bean> report12 = new ArrayList<Dc_bean>();
	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	private static final long serialVersionUID = 1L;
	private Dc_bean eb = new Dc_bean();
	private Dc_bean eb1 = new Dc_bean();
	private int length = 0;
	
	HttpServletRequest request;
	
	private String response;
	
	private Map session;
	
	private List<Dc_bean> rpt = new ArrayList<Dc_bean>();

	public String execute() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String v = request.getParameter("cust_name");
		System.out.println("cust_name" + v);

		return "success";
	}

	public String Opennew(){
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		return "SUCCESS";
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

		
	
	
	/*public String insert() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String str = Dc_Dao.insert(eb,bean);
		setDc_id(eb.getDc_id());
		if (str.equals("success"))

		{
			return "success";
		} else {
			return "fail";
		}
	}
		
		
		
		public String insertreceive() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			String str = Dc_Dao.insertreceive(eb,bean);
			setDc_id(eb.getDc_id());
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
		
		
		
		public String insertoutsrc() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			String str = Dc_Dao.insertoutsrc(eb,bean);
			setDc_id(eb.getDc_id());
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
		
		
		public String Dc_submitupdate() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			String str = Dc_Dao.update(eb,bean);
			setDc_id(eb.getDc_id());
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
		
		
		
		public String Dc_submitupdate_Receive() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			String str = Dc_Dao.Dc_submitupdate_Receive(eb,bean);
			setDc_id(eb.getDc_id());
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
		
		public String Dc_submitupdate_OutSrc() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			String str = Dc_Dao.Dc_submitupdate_OutSrc(eb,bean);
			setDc_id(eb.getDc_id());
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
		
		List<purchase_bean> report = new ArrayList<purchase_bean>();
public List<purchase_bean> getReport() {
			return report;
		}

		public void setReport(List<purchase_bean> report) {
			this.report = report;
		}

		
		
		
	public String DCPrint444cancel() throws Exception {
	
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
		String Dc_id = request.getParameter("Dc_id");
			String str = Dc_Dao.cancel(Dc_id,bean);
			
			try {
				report12 = new Dc_Dao().dcreport(bean);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
			
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
	
	
	
	
	
	public String DCReceivecancel() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
		String Dc_id = request.getParameter("Dc_id");
			String str = Dc_Dao.DCReceivecancel(Dc_id,bean);
			
			try {
				report12 = new Dc_Dao().DcReveiveReoprt(bean);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
					
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
	
	
	
	public String DCOwSrccancel() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
		String Dc_id = request.getParameter("Dc_id");
			String str = Dc_Dao.DCOwSrccancel(Dc_id,bean);
			
			try {
				report12 = new Dc_Dao().DcOutSrcReoprt(bean);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
					
			if (str.equals("success"))

			{
				return "success";
			} else {
				return "fail";
			}
		}
	
	
		
		public String Get_datails() throws SQLException {

			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			

			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			String cust_name = request.getParameter("cust_name");
		
			cust_info = new Dc_Dao().getcust(cust_name, bean);

			
			return "success";

		}
		
		
		public String makedcinvoice() throws Exception {
			
			
			eb  = Dc_Dao.makedcinvoice(eb);
			
			//System.out.println(">>>>>>>zzz"+eb.getGridsize());
				return "success";
			
		}
		
		
		public String MakeReadyInvoice() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
					
			String job_card_id = request1.getParameter("job_card_id");
			
			String remain = request1.getParameter("ready");
					
					//purchase_bean psb1=new purchase_bean();

		//System.out.println("JOb.id.."+job_card_id+"~~~~"+remain);
			
			
			eb  = Dc_Dao.makeReadyInvoice(eb,job_card_id,remain,bean);
			
			//System.out.println(">>>>>>>zzz"+eb.getGridsize());
				return "success";
			
		}*/
	
	
	
	public String displayBillReport() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		report12 = new Dc_Dao().displayBillReport(bean, eb);
		
		
		  return "display";

	}
	
	
	public String displayInvoiceReport() throws SQLException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		report12 = new Dc_Dao().displayInvoiceReport(bean, eb);
		
		
		  return "display";

	}
		
		
	public String invoice() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
			return "success";
		
	}
		
		
		public String MakeInvoice() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			//response = new job_card_dao().getnvnumber(bean);
			
					
			String lr = request1.getParameter("lr_number");
			
			
			eb  = Dc_Dao.makeInvoiceFromReady(eb,lr,bean);
			
				
			return "success";
			
		}
		
		
		
		
		
		public String CommonInvoiceCgst() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			response = new job_card_dao().getnvnumber(bean);
			
					
			String lr = request1.getParameter("lr_no");
			
			
			eb  = Dc_Dao.CommonInvoiceCgst(eb,lr,bean,response);
			
			System.out.println("Size:"+eb.getGridsize());
			
			System.out.println("AA:"+eb.getDcnot().size());
			
				
			return "success";
			
		}
		
		
		
		
		public String CommonInvoiceIgst() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			response = new job_card_dao().getnvnumber(bean);
			
					
			String lr = request1.getParameter("lr_no");
			
			
			eb  = Dc_Dao.CommonInvoiceIgst(eb,lr,bean,response);
			
					
			return "success";
			
		}
		
		
		
		public String MakeInvoiceIgst() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			response = new job_card_dao().getnvnumber(bean);
			
			
					
			String invoiceno = request1.getParameter("order_id");
			
			String des = request1.getParameter("despatch_id");
			
			String remain ="";
					
					//purchase_bean psb1=new purchase_bean();

		//System.out.println("JOb.id.."+invoiceno+"~~~~"+remain);
			
			
			eb  = Dc_Dao.makeInvoiceFromReadyIgst(eb,invoiceno,remain,bean,des);
			
			//System.out.println(">>>>>>>zzz"+eb.getGridsize());
				
			return "success";
			
		}
		
		
		
		public String billView() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			//response = new job_card_dao().getnvnumber(bean);
			
					
			String invoiceno = request1.getParameter("invoice");
			
			String type = request1.getParameter("type");
			
			String remain ="";
			
					
			System.out.println("aaaaa------"+type);
			
			if(type.equals("sgst"))
			{
				
				eb  = Dc_Dao.BillView(eb,invoiceno,remain,bean);
				
				return "success";
			}
			else if(type.equals("igst"))
					
			{
				
				eb  = Dc_Dao.BillViewIgst(eb,invoiceno,remain,bean);
				
				return "success1";
					
			}
			
			else if(type.equals("WithoutTax"))
			{
				eb  = Dc_Dao.BillViewWithoutTax(eb,invoiceno,remain,bean);
				
				return "success2";
				
			}
			
			else {
				
				return "fail";
			}
		
			
		}
		
		
		
public String pi_billView() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			//response = new job_card_dao().getnvnumber(bean);
			
					
			String invoiceno = request1.getParameter("invoice");
			
			String type = request1.getParameter("type");
			
			String remain ="";
			
					
			/*System.out.println("aaaaa------"+type);
			
			if(type.equals("sgst"))
			{
				
				eb  = Dc_Dao.BillView(eb,invoiceno,remain,bean);
				
				return "success";
			}
			else if(type.equals("igst"))
					
			{
				
				eb  = Dc_Dao.BillViewIgst(eb,invoiceno,remain,bean);
				
				return "success1";
					
			}*/
			
			 if(type.equals("WithoutTax"))
			{
				eb  = Dc_Dao.pi_BillViewWithoutTax(eb,invoiceno,remain,bean);
				
				return "success2";
				
			}
			
			else {
				
				return "fail";
			}
		
			
		}
		
		
		public String MakeInvoice1() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			
			response = new job_card_dao().getnvnumber(bean);
			
			//request.setAttribute("response", response);
			
					
			String invoiceno = request1.getParameter("order_id");
			
			String remain ="";
					
					//purchase_bean psb1=new purchase_bean();

		//System.out.println("JOb.id.."+invoiceno+"~~~~"+remain);
			
			
			eb  = Dc_Dao.makeInvoiceFromReady1(eb,invoiceno,remain,bean);
			
			//System.out.println(">>>>>>>zzz"+eb.getGridsize());
				
			return "success";
			
		}
		
		
		public String pi_displayInvoiceReport() throws SQLException {

			Map session = ActionContext.getContext().getSession();
			userinfo bean = new userinfo();
			bean = (userinfo) session.get(Constants.USER_PROFILE);
			
			
			report12 = new Dc_Dao().pi_displayInvoiceReport(bean, eb);
			
			
			  return "display";

		}
			
		
		
		
		// Method To Ready Invoice View
		
		/*public String ReadyInvoiceView() throws Exception {
			
			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
					
			String invoiceno = request1.getParameter("invoiceno");
			
			String remain = request1.getParameter("amount");
					
			
			System.out.println("JOb.id.."+invoiceno+"~~~~"+remain);
			
			
			eb  = Dc_Dao.makeReadyInvoiceView(eb,invoiceno,remain,bean);
			
			System.out.println(">>>>>>>zzz"+eb.getGridsize());
				return "success";
			
		}
		
		
		
		
		public String DCPrint444edit() {

			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			String Dc_id = request1.getParameter("Dc_id");
			
			//purchase_bean psb1=new purchase_bean();

			System.out.println("Dc...id.."+Dc_id);

			try {
				eb = new Dc_Dao().Print44(Dc_id,bean);
			//System.out.println("description.."+eb.getNn().size());
			int rr=0;
			rr = rr + 1;
			;
			String sn = "" + rr;

			eb.setSn(sn);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "success";

		}
		
		
		
		public String DCReceiveEdit() {

			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			String Dc_id = request1.getParameter("Dc_id");
			
			//purchase_bean psb1=new purchase_bean();

			System.out.println("Dc...id.."+Dc_id);

			try {
				eb = new Dc_Dao().DcReceiveEdit(Dc_id,bean);
			//System.out.println("description.."+eb.getNn().size());
			int rr=0;
			rr = rr + 1;
			
			String sn = "" + rr;

			eb.setSn(sn);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "success";

		}
		
		
		
		public String DCOwSrcEdit() {

			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			String Dc_id = request1.getParameter("Dc_id");
			
			//purchase_bean psb1=new purchase_bean();

			System.out.println("Dc...id.."+Dc_id);

			try {
				eb = new Dc_Dao().DCOwSrcEdit(Dc_id,bean);
			//System.out.println("description.."+eb.getNn().size());
			int rr=0;
			rr = rr + 1;
			
			String sn = "" + rr;

			eb.setSn(sn);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "success";

		}
		
		
		public String makedc() {

			Map session = ActionContext.getContext().getSession();
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			String Dc_id = request1.getParameter("Dc_id");
			
			//purchase_bean psb1=new purchase_bean();

			System.out.println("Dc...id.."+Dc_id);

			try {
				eb = new Dc_Dao().MakeDc(Dc_id,bean);
			
			int rr=0;
			rr = rr + 1;
			String sn = "" + rr;

			eb.setSn(sn);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "success";

		}
		
		
		
		
		
			public String DcPrint444() {

				Map session = ActionContext.getContext().getSession();
				LoginBean bean = new LoginBean();
				bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
			HttpServletRequest request1 = (HttpServletRequest) ActionContext
			.getContext().get(ServletActionContext.HTTP_REQUEST);
			String Dc_id = request1.getParameter("Dc_id");
			
			//purchase_bean psb1=new purchase_bean();

			System.out.println("Dc...id.."+Dc_id);

			try {
				eb = new Dc_Dao().Print44(Dc_id,bean);
			//System.out.println("description.."+eb.getNn().size());
			int rr=0;
			rr = rr + 1;
			
			String sn = "" + rr;

			eb.setSn(sn);
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return "success";

		}
			
			
			
			
			
			
			public String dcreport() {

				Map session = ActionContext.getContext().getSession();
				LoginBean bean = new LoginBean();
				bean = (LoginBean) session.get(Constants.USER_PROFILE);
				
				try {
					report12 = new Dc_Dao().dcreport(bean);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
						
				return "success";
			
			
			
			}	
			
			
			public String DcReveiveReoprt() {
			
				Map session = ActionContext.getContext().getSession();
				LoginBean bean = new LoginBean();
				bean = (LoginBean) session.get(Constants.USER_PROFILE);
				
				try {
					report12 = new Dc_Dao().DcReveiveReoprt(bean);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
						
				return "success";
				
			
			}	
			
			
			
			public String DcOutSrcReoprt() {
				
				Map session = ActionContext.getContext().getSession();
				LoginBean bean = new LoginBean();
				bean = (LoginBean) session.get(Constants.USER_PROFILE);
				
				try {
					report12 = new Dc_Dao().DcOutSrcReoprt(bean);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
						
				return "success";	
			}	
			
			
			
			public String poreport() {
		
				Map session = ActionContext.getContext().getSession();
				LoginBean bean = new LoginBean();
				bean = (LoginBean) session.get(Constants.USER_PROFILE);
				
				try {
					report12 = new Dc_Dao().poreport(bean);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
						
				return "success";
				
			
			}*/	

	/*public String estimaterpt() throws SQLException {
		
		
		
		
		
		rpt = new Estimate_Dao().estimate22();
		System.out.println("size"+rpt.size());
		
		
		if(rpt.size()>0){
			

			return "success";
			
		}
		else
	
	
		{
			return "fail";
		}
	
	
		
	}*/
	
	
	
	
	

	/*public String EstmPrint444() {

		// System.out.println("prod");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String datefrom = psb.getFrom_date22();
		String dateto = psb.getTo_date122();
df=datefrom;
dt=dateto;
		System.out.println("datefrom" + datefrom + "dateto" + dateto);

		// psb.setTo_date1(to_date1);
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
		String estimateno = request1.getParameter("estimateno");

		//purchase_bean psb1=new purchase_bean();

		System.out.println("estimateno"+estimateno);

		try {
			eb = new Estimate_Dao().Print44(estimateno);
		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//System.out.println("Error in prod2 " + datefrom + " " + dateto);
			e.printStackTrace();
		}
		
		System.out.println("tamount" + eb.getTamount967());
		int p = 1;
		int p1 = 1;
		int p2 = 1;
		int p3 = 1;
		int p4 = 1;
		int partsc=0;
		int labourc=0;
		int repairc=0;
		int paintc=0;
		int refitc=0;
		
		int length1 = eb.getDescription122().size();
		for (int i = 0; i < length1; i++) {
			estimate_bean b1 = new estimate_bean();
			b1.setBtype1(eb.getBtype122().get(i));
			if (b1.getBtype1().equalsIgnoreCase("parts")) {
			b1.setDescription1(eb.getDescription122().get(i));
			b1.setQty1(eb.getQty122().get(i));
			//b1.setAmt1(eb.getAmt122().get(i));
			//b1.setTotal1(eb.getTax122().get(i));
			
			b1.setTotal1(eb.getTax122().get(i));
			//total_amount1 = total_amount1 + (Double.parseDouble(eb.getTax122().get(i)));
			total_amount1 = total_amount1 + (Double.parseDouble(eb.getAmt122().get(i)));
			b1.setSr_no("" + p);
			p++;
			partsc++;
			//System.out.println("b1.getDescription1()" + b1.getDescription1());
			}
			else if(b1.getBtype1().equalsIgnoreCase("labour")) {
				b1.setDescription1(eb.getDescription122().get(i));
				b1.setQty1(eb.getQty122().get(i));
				//b1.setAmt1(eb.getAmt122().get(i));
				//b1.setTotal1(eb.getTax122().get(i));
				b1.setTotal1(eb.getAmt122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getAmt122().get(i)));
				//total_amount1 = total_amount1 + (Double.parseDouble(eb.getTax122().get(i)));
				//total_amount = total_amount + (Integer.parseInt(eb.getTotal()[i]));
				b1.setSr_no("" + p1);
				p1++;
				labourc++;
				System.out.println("b1.getDescription1()" + b1.getDescription1());
				}
			
			else if(b1.getBtype1().equalsIgnoreCase("repair")) {
				b1.setDescription1(eb.getDescription122().get(i));
				b1.setQty1(eb.getQty122().get(i));
				//b1.setAmt1(eb.getAmt122().get(i));
				//b1.setTotal1(eb.getTax122().get(i));
				//total_amount1 = total_amount1 + (Double.parseDouble(eb.getTax122().get(i)));
				//total_amount = total_amount + (Integer.parseInt(eb.getTotal()[i]));
				b1.setTotal1(eb.getAmt122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getAmt122().get(i)));
				b1.setSr_no("" + p2);
				p2++;
				repairc++;
				System.out.println("b1.getDescription1()" + b1.getDescription1());
				}
			else if(b1.getBtype1().equalsIgnoreCase("painting")) {
				b1.setDescription1(eb.getDescription122().get(i));
				b1.setQty1(eb.getQty122().get(i));
				
				b1.setTotal1(eb.getAmt122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getAmt122().get(i)));
				b1.setAmt1(eb.getAmt122().get(i));
				b1.setTotal1(eb.getTax122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getTax122().get(i)));
				//total_amount = total_amount + (Integer.parseInt(eb.getTotal()[i]));
				b1.setSr_no("" + p3);
				p3++;
				paintc++;
				System.out.println("b1.getDescription1()" + b1.getDescription1());
				}
			else if(b1.getBtype1().equalsIgnoreCase("repairandrefitting")) {
				b1.setDescription1(eb.getDescription122().get(i));
				b1.setQty1(eb.getQty122().get(i));
				b1.setAmt1(eb.getAmt122().get(i));
				b1.setTotal1(eb.getTax122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getTax122().get(i)));
				//total_amount = total_amount + (Integer.parseInt(eb.getTotal()[i]));
				b1.setTotal1(eb.getAmt122().get(i));
				total_amount1 = total_amount1 + (Double.parseDouble(eb.getAmt122().get(i)));
				b1.setSr_no("" + p4);
				p4++;
				refitc++;
				System.out.println("b1.getDescription1()" + b1.getDescription1());
				}
			
			
			
			
			 labourcount= labourc;
			 partscount=partsc;
			 repaircount=repairc;
			 paintingcount=paintc;
			 refittingcount=refitc;
			rpt.add(b1);

		
		
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//System.out.println("sumtot" + psb1.getPaybycashtotal());
		
		return "success";

	}*/
	/*public String FetchspareGatepassAssemblyform1() throws SQLException {
		HttpServletRequest request = (HttpServletRequest) ActionContext
        .getContext().get(ServletActionContext.HTTP_REQUEST);
		String autoinvoice = request.getParameter("autoinvoice");
		System.out.println(">>>>>>>zzz" + autoinvoice);
		try {
			eb = new Estimate_Dao().FetchspareGatepassAssemblyform(autoinvoice);
			// /System.out.println(">>>>>>>zzz"+purchase_order_bean.getSparesize());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";

	}
	
	*/
	
	
	

	@Override
	public Dc_bean getModel() {
		// TODO Auto-generated method stub
		return eb;
	}

	public Dc_bean getEb() {
		return eb;
	}

	public void setEb(Dc_bean eb) {
		this.eb = eb;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<Dc_bean> getRpt() {
		return rpt;
	}

	public void setRpt(List<Dc_bean> rpt) {
		this.rpt = rpt;
	}

	public void setLabourcount(int labourcount) {
		this.labourcount = labourcount;
	}

	public int getLabourcount() {
		return labourcount;
	}

	public void setPartscount(int partscount) {
		this.partscount = partscount;
	}

	public int getPartscount() {
		return partscount;
	}

	public void setTotal_amount1(double total_amount1) {
		this.total_amount1 = total_amount1;
	}

	public double getTotal_amount1() {
		return total_amount1;
	}

	public void setRepaircount(int repaircount) {
		this.repaircount = repaircount;
	}

	public int getRepaircount() {
		return repaircount;
	}

	public void setPaintingcount(int paintingcount) {
		this.paintingcount = paintingcount;
	}

	public int getPaintingcount() {
		return paintingcount;
	}

	public void setRefittingcount(int refittingcount) {
		this.refittingcount = refittingcount;
	}

	public int getRefittingcount() {
		return refittingcount;
	}

	public void setEstimateno(String estimateno) {
		this.estimateno = estimateno;
	}

	public String getEstimateno() {
		return estimateno;
	}

	public void setCheckme1(String checkme1) {
		this.checkme1 = checkme1;
	}

	public String getCheckme1() {
		return checkme1;
	}

	public void setCheckme2(String checkme2) {
		this.checkme2 = checkme2;
	}

	public String getCheckme2() {
		return checkme2;
	}

	public String getCust_info() {
		return cust_info;
	}

	public void setCust_info(String cust_info) {
		this.cust_info = cust_info;
	}

	public String getDc_id() {
		return Dc_id;
	}

	public void setDc_id(String dc_id) {
		Dc_id = dc_id;
	}

	public List<Dc_bean> getReport12() {
		return report12;
	}

	public void setReport12(List<Dc_bean> report12) {
		this.report12 = report12;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	
	
}
