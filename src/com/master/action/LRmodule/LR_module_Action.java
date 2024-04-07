package com.master.action.LRmodule;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.master.dao.LRmodule.LRform_Dao;
import com.master.model.estimate_bean;
import com.master.model.LoginBean;
import com.master.Constants.Constants;
import com.master.model.estimate_bean;
import org.apache.struts2.interceptor.SessionAware;

public class LR_module_Action extends ActionSupport implements
		ModelDriven<estimate_bean>, ServletRequestAware, Serializable,
		SessionAware {
	private static final long serialVersionUID = 1L;
	private Map session;
	private estimate_bean prb;
	private estimate_bean purchase_Order_bean;
	private List<estimate_bean> po_details_products = new ArrayList<estimate_bean>();
	private String price;
	private String company_name;
	private String to_date;
	private String lrno;
	private String lrnumber;
	private String lastmonthjccount;
	private String currentmonthjccount;
	private String lastmonthxcoolection;
	private String currmoncoll;
	private String hsn;
	
	private String lastmonthlvt;
	private String currmonthlvt;
	private String currmonthlvt1;
	private String lastmonthstax;
	private String lastmonthstax1;
	private String cust_name;
	
	public String getLastmonthstax1() {
		return lastmonthstax1;
	}

	public void setLastmonthstax1(String lastmonthstax1) {
		this.lastmonthstax1 = lastmonthstax1;
	}

	private String currmonthstax;
	private String currmonosbill;
	private String lastpendingjc;
	private String currpendingjc;
	private String alertt;
	public Map getSession() {
		return session;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;

	}

	/*
	 * public void setSession(Map session) { this.session = session; }
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getpmsamount() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		price = new LRform_Dao().getpmsamount(description, qty, bean);

		System.out.println("price in action"+price);
		return "success";

	}
	
	

	
	public String Fetchlasmothjobcardcount() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
		setLastmonthjccount(new LRform_Dao().getlastmonthjccount(bean));
		
		//System.out.println("lastmonthjccount"+lastmonthjccount);
		return "success";

	}
	
	
	public String Fetchcurrmothjobcardcount() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setCurrentmonthjccount(new LRform_Dao().getcurrentmonthjccount(bean));
		//System.out.println("currentmonthjccount"+currentmonthjccount);
		return "success";

	}
	
	public String Fetlatsmothcollection() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setLastmonthxcoolection(new LRform_Dao().getlastmonthjcoll(bean));
		//System.out.println("currentmonthjccount"+currentmonthjccount);
		return "success";

	}
	
	
	
	public String Fetcurrmothcollection() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setCurrmoncoll(new LRform_Dao().getcurrmonthjcoll(bean));
		//System.out.println("currmoncoll"+currmoncoll);
		return "success";

	}
	
	
	
	
	public String Fetlasrmothvat() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setLastmonthlvt(new LRform_Dao().getlastmonthlvtl(bean));
		//System.out.println("lastmonthlvt"+lastmonthlvt);
		return "success";

	}
	
	public String Fetcurrmothvat() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		currmonthlvt1=new LRform_Dao().getcurrmonthlvtl(bean);
		System.out.println("currmonthlvt1>>>"+currmonthlvt1);
		return "success";

	}
	
	
	public String Fetlastrmothstax() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		//setLastmonthstax(new LRform_Dao().getlastmonthstax(bean));
		lastmonthstax1=new LRform_Dao().getlastmonthstax(bean);
		System.out.println("currmonthlvt11>"+lastmonthstax1);
		return "success";

	}
	
	
	public String Fetcurrrmothstax() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setCurrmonthstax(new LRform_Dao().getcurrmonthstax(bean));
		//System.out.println("currmonthlvt"+currmonthlvt);
		return "success";

	}
	
	
	
	public String Fetcurrrmothosbills() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setCurrmonosbill(new LRform_Dao().getcurrmonthosbill(bean));
		//System.out.println("currmonthlvt"+currmonthlvt);
		return "success";

	}
	
	public String Fetpendingjbc() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		setLastpendingjc(new LRform_Dao().getlastpendingjc(bean));
		//System.out.println("currmonthlvt"+currmonthlvt);
		return "success";

	}
	
	
	
	
	public String Fetcurrpendingjbc() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/
	
		currpendingjc=new LRform_Dao().getcurrpendingjc(bean);
	System.out.println("currpendingjc"+currpendingjc);
		return "success";

	}
	
	
	public String Fetcalert() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		/*HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");*/

				alertt=new LRform_Dao().getalertt(bean);
	System.out.println("alert"+alertt);
		return "success";

	}
	
	
	
	
	public String Get_datails() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String vehicle_no = request.getParameter("vehicle_no");
		//String qty = request.getParameter("qty");
		price = new LRform_Dao().getvehicle(vehicle_no, bean);

		System.out.println("price in action"+price);
		return "success";

	}
	
	public String getpmsamount1purchase() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");
		String model = request.getParameter("model");
		price = new LRform_Dao().getpmsamount1purchase(description, qty,btype, bean,model);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	public String getpmsamount1() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");
		price = new LRform_Dao().getpmsamount1(description, qty,btype, bean);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	public String getRemainingAmount() {

		/*Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
*/
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");*/
		String emp_name = request.getParameter("emp_name");
		String exp_amount = request.getParameter("exp_amount");
		System.out.println("emp_name: "+emp_name);
		System.out.println("exp_amount: "+exp_amount);
		price = new LRform_Dao().getRemainingAmount(emp_name, exp_amount);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	
	
	
	public String getAddress1() {

		/*Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
*/
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		/*String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");*/
		/*price = new LRform_Dao().getpmsamount1(description, qty,btype, bean);*/
		
		String transporter_code = request.getParameter("transporter_code");
		String customer_code = request.getParameter("customer_code");
		price = new LRform_Dao().getAddress(transporter_code, customer_code);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	
	public String gettaxnhsn() {

		/*Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");*/

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		/*String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");*/
		price = new LRform_Dao().gettaxnhsn(description);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	
	
	
	
	
	
	
	
	
	
	// new addition
	
	public String getjobamount1() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String Vehicle_no = request.getParameter("Vehicle_no");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price = new LRform_Dao().getjobamount1(Vehicle_no,bean);

		return "success";

	}
	
	public String getjobamountagain() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String invno = request.getParameter("Vehicle_no");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		System.out.println("<<<"+invno);
		price = new LRform_Dao().getjobamountagain(invno,bean);

		return "success";

	}
	
	
	
	
	public String getjobamountagainsales() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String invno = request.getParameter("Vehicle_no");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		System.out.println("<<<"+invno);
		price = new LRform_Dao().getjobamountagainsales(invno,bean);

		return "success";

	}
	
	public String getjobamountagain1() {
		System.out.println("<<<,,,,,,,,,,,,,,,,");
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String estno = request.getParameter("Vehicle_no");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		System.out.println("<<<"+estno);
		price = new LRform_Dao().getjobamountagain1(estno,bean);

		return "success";

	}
	
	
	
	
	public String gettaxpercent() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String model = request.getParameter("taxtype");
	
	//	hsn=new LR_Dao().gettaxpercent(model);

		System.out.println("HSN:"+hsn);
		return "success";

	}
	
	
	public String gettaxpercentxxx() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String model = request.getParameter("model");
	
		//hsn=new LR_Dao().gettaxpercentxxx(model);

		System.out.println("HSN:"+hsn);
		return "success";

	}
	
	
	
	//-------
	
	public String getpmsvalue1() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String vehicleno1 = request.getParameter("vehicleno1");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price = new LRform_Dao().getpmsvalue1(vehicleno1,  bean);

		System.out.println("price in action"+price);
		return "success";

	}

	public String getpmsvalue1112() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String vehicleno1 = request.getParameter("vehicleno1");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price = new LRform_Dao().getpmsvalue1112(vehicleno1,  bean);

		System.out.println("price in action"+price);
		return "success";

	}

	
	
	
	public String getcustdetails() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String cust_id = request.getParameter("cust_id");
	
		cust_name=new LRform_Dao().getcustname(cust_id);

		return "success";

	}
	
	
	
	public String getbillamount() {

	/*	Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	*/
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		String billbo = request.getParameter("billbo");
	
		System.out.println("kkkkkkkkkkkkkkkk------"+billbo);
		price=new LRform_Dao().getbillamount(billbo);

		return "success";

	}
	
	
	
	
	/*public String getcustdetailsgstnew() throws Exception {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa111");
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
	
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2222");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		String cust_id = request.getParameter("customercode");
		System.out.println("aaaaaaaassssssssss---");
		System.out.println("aaaaaaaa---"+cust_id);
		price=new LRform_Dao().getcustnamegst(cust_id);

		return "success";

	}*/
	
	
	
	
	public String getcustdetailsnew()throws Exception  {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa0000");
		/*Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);*/
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa111");
		
		String cust_id = request.getParameter("name");
	
		
		price=new LRform_Dao().getcustnamegst(cust_id);
		//cust_name=new LRform_Dao().getcustname(cust_id);

		return "success";

	}
	
	
	

	public estimate_bean getPrb() {
		return prb;
	}

	public void setPrb(estimate_bean prb) {
		this.prb = prb;
	}

	public estimate_bean getPurchase_Order_bean() {
		return purchase_Order_bean;
	}

	public void setPurchase_Order_bean(estimate_bean purchase_Order_bean) {
		this.purchase_Order_bean = purchase_Order_bean;
	}

	public List<estimate_bean> getPo_details_products() {
		return po_details_products;
	}

	public void setPo_details_products(List<estimate_bean> po_details_products) {
		this.po_details_products = po_details_products;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setLrno(String lrno) {
		this.lrno = lrno;
	}

	public String getLrno() {
		return lrno;
	}

	public void setLrnumber(String lrnumber) {
		this.lrnumber = lrnumber;
	}

	public String getLrnumber() {
		return lrnumber;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public estimate_bean getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLastmonthjccount() {
		return lastmonthjccount;
	}

	public void setLastmonthjccount(String lastmonthjccount) {
		this.lastmonthjccount = lastmonthjccount;
	}

	public String getCurrentmonthjccount() {
		return currentmonthjccount;
	}

	public void setCurrentmonthjccount(String currentmonthjccount) {
		this.currentmonthjccount = currentmonthjccount;
	}

	public String getLastmonthxcoolection() {
		return lastmonthxcoolection;
	}

	public void setLastmonthxcoolection(String lastmonthxcoolection) {
		this.lastmonthxcoolection = lastmonthxcoolection;
	}

	public String getLastmonthstax() {
		return lastmonthstax;
	}

	public void setLastmonthstax(String lastmonthstax) {
		this.lastmonthstax = lastmonthstax;
	}

	public String getLastpendingjc() {
		return lastpendingjc;
	}

	public void setLastpendingjc(String lastpendingjc) {
		this.lastpendingjc = lastpendingjc;
	}

	public String getCurrmonthstax() {
		return currmonthstax;
	}

	public void setCurrmonthstax(String currmonthstax) {
		this.currmonthstax = currmonthstax;
	}

	public String getCurrmonosbill() {
		return currmonosbill;
	}

	public void setCurrmonosbill(String currmonosbill) {
		this.currmonosbill = currmonosbill;
	}

	public String getLastmonthlvt() {
		return lastmonthlvt;
	}

	public void setLastmonthlvt(String lastmonthlvt) {
		this.lastmonthlvt = lastmonthlvt;
	}

	public String getCurrmoncoll() {
		return currmoncoll;
	}

	public void setCurrmoncoll(String currmoncoll) {
		this.currmoncoll = currmoncoll;
	}

	public String getCurrmonthlvt1() {
		return currmonthlvt1;
	}

	public void setCurrmonthlvt1(String currmonthlvt1) {
		this.currmonthlvt1 = currmonthlvt1;
	}

	
	public String getpmsamount1x() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		String qty = request.getParameter("qty");
		String btype = request.getParameter("btype");
		price = new LRform_Dao().getpmsamount1x(description, qty,btype, bean);

		System.out.println("price in action"+price);
		return "success";

	}

	
	
	
	//akshu
	public String getpmsamount11x() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String description = request.getParameter("description");
		
		price = new LRform_Dao().getpmsamount11x(description, bean);

		System.out.println("price in action"+price);
		return "success";

	}
	
	
	
	public String custdetails() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
			
		/*String transporter_code = request.getParameter("transporter_code");*/
		String customer_code = request.getParameter("customer_code");
	/*	price = new LRform_Dao().getAddress(transporter_code, customer_code);*/
		price = new LRform_Dao().getcustditeals(customer_code);
		System.out.println("price in action"+price);
		return "success";

	}
	
	
	
	
	public String getHsn() {
		return hsn;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	
	
}
