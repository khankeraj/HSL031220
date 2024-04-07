package com.master.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.master.Constants.Constants;
import com.master.dao.Dc_Dao;
import com.master.dao.dealer_payment_dao;
import com.master.model.Dealer_Payment_Bean;
import com.master.model.LoginBean;
import com.master.model.expenses_Bean;
import com.master.util.AmtInWord;
import com.master.util.EnglishNumberToWords;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class dealer_payment_action extends ActionSupport  implements SessionAware
{
private static final long serialVersionUID = 1L;
	private Map session;
	private Dealer_Payment_Bean dpb;
	private expenses_Bean bean1;
	
	private String voucher_no;
	private String recpco="";
	private String paymode="";
	private String bankname="";
	private String chequeno="";
	private String checkdate="";
	private String amount="";
	private String user;
	private String date;
	private String recno;
	private String name;
	
	List<Dealer_Payment_Bean> bankledger=new ArrayList<Dealer_Payment_Bean>();
	List<expenses_Bean> expprint=new ArrayList<expenses_Bean>();
	
	public Map getSession() {
		return session;
	}

	public List<Dealer_Payment_Bean> getBankledger() {
		return bankledger;
	}

	public void setBankledger(List<Dealer_Payment_Bean> bankledger) {
		this.bankledger = bankledger;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	
	

	public List<expenses_Bean> getExpprint() {
		return expprint;
	}

	public void setExpprint(List<expenses_Bean> expprint) {
		this.expprint = expprint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String insertexpenses()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String status=new dealer_payment_dao().insertexpenses(dpb,bean);		
		recpco=dpb.getVoucher_no();
		paymode=dpb.getPaymod();
	
		
		bankname=dpb.getBankname();
		chequeno=dpb.getCheque_no();
		amount=dpb.getCheque_amt();
		date=dpb.getCheque_date();
		name=dpb.getEmp_name();
		recno=dpb.getRecno();
		
		
		System.out.println(recpco);
		System.out.println("Paymode:"+paymode);
		System.out.println("Bank:"+bankname);
		System.out.println("Cheque No:"+chequeno);
		System.out.println("Amount:"+amount);
		System.out.println("Date:"+date);
		System.out.println("Name:"+name);
		System.out.println("Rec No:"+recno);
		
		
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}
	
	
	// Method to Insert Deposit,Withdraw and Bank Transfer
	
	public String insertdepwitbank()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String status=new dealer_payment_dao().InsertDepositWithraw(dpb,bean);		
		/*recpco=dpb.getVoucher_no();
		paymode=dpb.getPaymod();
	
		
		bankname=dpb.getBankname();
		chequeno=dpb.getCheque_no();
		amount=dpb.getCheque_amt();
		date=dpb.getCheque_date();
		name=dpb.getEmp_name();
		recno=dpb.getRecno();
		
		
		System.out.println(recpco);
		System.out.println("Paymode:"+paymode);
		System.out.println("Bank:"+bankname);
		System.out.println("Cheque No:"+chequeno);
		System.out.println("Amount:"+amount);
		System.out.println("Date:"+date);
		System.out.println("Name:"+name);
		System.out.println("Rec No:"+recno);
		*/
		
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}
	
	
	
	public String InsertCustCreditDebit()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			
		String status=new dealer_payment_dao().insertcustcreditdebitnote(dpb,bean);		
		recpco=dpb.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}
	
	
	
	public String InsertSupplierCreditDebit()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			
		String status=new dealer_payment_dao().insertsupcreditdebitnote(dpb,bean);		
		recpco=dpb.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}
	
	
	/*	public String insertexpensesv()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			
		String status=new dealer_payment_dao().insertexpensesv(dpb,bean);		
		recpco=dpb.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}
	
	public String execute()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			
		String status=new dealer_payment_dao().insertdealerpayment(dpb,bean);		
		recpco=dpb.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

}*/
	
	public String insertdealerpaymentv()
	{
		
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			
		String status=new dealer_payment_dao().insertdealerpaymentv(dpb,bean);		
		recpco=dpb.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}

		
}
	
	
	public String insertsupplierpaymentv()
	{
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
			
		String status=new dealer_payment_dao().insertsupplierpaymentv(dpb,bean);		
		
		recpco=dpb.getVoucher_no();
		paymode=dpb.getPaymod();
	
		
		bankname=dpb.getBankname();
		chequeno=dpb.getCheque_no();
		amount=dpb.getCheque_amt();
		date=dpb.getCheque_date();
		name=dpb.getEmp_name();
		recno=dpb.getRecno();
		
		
		System.out.println(recpco);
		System.out.println("Paymode:"+paymode);
		System.out.println("Bank:"+bankname);
		System.out.println("Cheque No:"+chequeno);
		System.out.println("Amount:"+amount);
		System.out.println("Date:"+date);
		System.out.println("Name:"+name);
		System.out.println("Rec No:"+recno);
		
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else if(status.equals("AlreadyCheque"))
		{
			return "AlreadyCheque";
		}
		else
		{
			return "fail";
		}
}
	public String insertcustomerpaymentv()
	{
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String customer_name=request.getParameter("customer_name");
		
		String WithGrid=request.getParameter("WithGrid");
		String WithoutGrid=request.getParameter("WithoutGrid");
		
		String status="";
		String lead_no=request.getParameter("lead_no");
		String invoice_no=request.getParameter("invoice_no");
		System.out.println("invoice_no:"+invoice_no);
		if(WithGrid.equals("1"))
		{
			System.out.println("withgrid:"+WithGrid);
			status=new dealer_payment_dao().insertcustomerpaymentv(dpb,bean,customer_name,WithGrid,lead_no,invoice_no);	
			System.out.println("status1:"+status);
		}else if(WithoutGrid.equals("2"))
		{
			System.out.println("withoutgrid:"+WithoutGrid);
			
			status=new dealer_payment_dao().insertcustomerpaymentv(dpb,bean,customer_name,WithoutGrid,lead_no,invoice_no);
			System.out.println("status2:"+status);
		}
		
		recpco=dpb.getVoucher_no();
		
		System.out.println(recpco);
		
		if(status.equals("success"))
		{
			return "success";
		}
		else if(status.equals("Already"))
		{
			return "already";
		}
		else
		{
			return "fail";
		}
	}
	
	public String openform(){
		try{
			LoginBean bean = new LoginBean();
			bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
			user=String.valueOf(bean.getUid());
			}catch (Exception e) {
				// TODO: handle exception
			}
		return "success";
		
	}
	
	private String initialbalance;
	private String finalbalance;
	private String dealer_id;
	private String dealerid1;
	
	private String dealerid2;
	private String fromdate;
	private String todate;
	private String companyname;
	HttpServletRequest request;
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletRequest(HttpServletRequest request)
	{
		this.request=request;
		
	}
	
	public String bankledger() throws Exception{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchBankLedger(dpb);
		for(int i=0; i<bankledger.size();i++){
			
			initialbalance=bankledger.get(i).getInitialbalance();
			finalbalance=bankledger.get(i).getFinalbalance();
			//dealerid2=report.get(i).getDealer_id();
			String s="";
			try{
				 s=dpb.getDealer_id();
			s = s.substring(s.indexOf("(") + 1);
			s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			bankname=bankledger.get(i).getBankname();
			
			System.out.println("Bank Name:"+bankname);
			
			 fromdate=bankledger.get(i).getFrom_date();
			todate=bankledger.get(i).getTo_date();
			//System.out.println(">>>>yes"+report.get(i).getDealer_id());
			}
		try{
			request.setAttribute("initialbalance",initialbalance);  
			request.setAttribute("finalbalance",finalbalance);
			request.setAttribute("bankname",bankname);
			
			request.setAttribute("fromdate",fromdate);
			request.setAttribute("todate",todate);
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		System.out.println("Size:"+bankledger.size());
		return "success";
		
	}
	
	
	
	public String cashledger() throws Exception{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchCashLedger(dpb);
		for(int i=0; i<bankledger.size();i++){
			
			initialbalance=bankledger.get(i).getInitialbalance();
			finalbalance=bankledger.get(i).getFinalbalance();
			//dealerid2=report.get(i).getDealer_id();
			String s="";
			try{
				 s=dpb.getDealer_id();
			s = s.substring(s.indexOf("(") + 1);
			s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			dealerid1=bankledger.get(i).getDelader()+"("+s+")~"+s;
			
			 fromdate=bankledger.get(i).getFrom_date();
			todate=bankledger.get(i).getTo_date();
			//System.out.println(">>>>yes"+report.get(i).getDealer_id());
			}
		try{
			request.setAttribute("initialbalance",initialbalance);  
			request.setAttribute("finalbalance",finalbalance);
			request.setAttribute("dealerid1",dealerid1);
			
			request.setAttribute("fromdate",fromdate);
			request.setAttribute("todate",todate);
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		System.out.println("Size:"+bankledger.size());
		return "success";
		
	}
	
	
	
	public String CustCreditNoteReport() throws Exception{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchCreditDebitNoteCust(dpb);
		
		System.out.println("Size:"+bankledger.size());
		
		return "success";
		
	}
	
	
	public String SupCreditNoteReport() throws Exception{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchCreditDebitNoteSup(dpb);
		
		System.out.println("Size:"+bankledger.size());
		
		return "success";
		
	}
	
	
	
	
	
	public String chequelinksupplier() throws IOException, SQLException{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchChequeLinkSup(dpb);
			
		System.out.println("Size:"+bankledger.size());
		return "success";
		
	}
	
public String ChequeLinkCust() throws IOException, SQLException{
		
		new dealer_payment_dao();
		bankledger = dealer_payment_dao.fetchChequeLinkCust(dpb);
			
//		System.out.println("Size:"+bankledger.size());
		return "success";
		
	}
	
	
	/*public String recordlist(){
		
String status=new dealer_payment_dao().insertdealerpayment(dpb,bean);		
		
		
		return "recordlist";
		
		
		
		
	}*/


	public String ExpensePrint444() {

	
	HttpServletRequest request1 = (HttpServletRequest) ActionContext
	.getContext().get(ServletActionContext.HTTP_REQUEST);
	String voucher_no = request1.getParameter("voucher_no");
	
	//purchase_bean psb1=new purchase_bean();

	System.out.println("Voucher...id.."+voucher_no);

	try {
		expprint= new dealer_payment_dao().Print44(voucher_no);
	//System.out.println("description.."+eb.getNn().size());
	
	
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	return "success";

}
	
	
	
	
	/*public String ChequePrint444() {

		
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
		.getContext().get(ServletActionContext.HTTP_REQUEST);
		String voucher_no = request1.getParameter("voucher_no");
		
		//purchase_bean psb1=new purchase_bean();

		System.out.println("Voucher...id.."+voucher_no);

		try {
			List<expenses_Bean> ss= new dealer_payment_dao().ChequePrint(voucher_no);
		//System.out.println("description.."+eb.getNn().size());
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		try {
			String WholeNumber = "", Decimal = "";
			String StringOfOne = bean1.getAmount();
			
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
				WholeNumber = bean1.getAmount();
			}
			

			if (isDecimal) {
				String temp = " "
					+ AmtInWord.getAmtInWord(Integer
							.parseInt(WholeNumber));
				bean1.setAmountinnumber(temp.toUpperCase());

			} else {
				String temp = " "
					+ EnglishNumberToWords.convert(Integer
							.parseInt(bean1.getAmount())) + "  only";
				bean1.setAmountinnumber(temp.toUpperCase());

			}

			
			// ifc_P_PedidosBean.setAmountinwords(EnglishNumberToWords.convert(Long.parseLong(ifc_P_PedidosBean.getTotal())));

			// System.out.println("Amount in Words : "+obj.convertToWords(Integer.parseInt(ifc_P_PedidosBean.getTotal())));
		} catch (Exception e) {
			System.out
			.println("Error: IFC_P_Pedidos_Action  in Print3:"
					+ e.getMessage());
		}
		
		
		
		return "success";

	}*/


	public void setDpb(Dealer_Payment_Bean dpb) {
		this.dpb = dpb;
	}

	public String getInitialbalance() {
		return initialbalance;
	}

	public void setInitialbalance(String initialbalance) {
		this.initialbalance = initialbalance;
	}

	public String getFinalbalance() {
		return finalbalance;
	}

	public void setFinalbalance(String finalbalance) {
		this.finalbalance = finalbalance;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getDealerid1() {
		return dealerid1;
	}

	public void setDealerid1(String dealerid1) {
		this.dealerid1 = dealerid1;
	}

	public String getDealerid2() {
		return dealerid2;
	}

	public void setDealerid2(String dealerid2) {
		this.dealerid2 = dealerid2;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public Dealer_Payment_Bean getDpb() {
		return dpb;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setRecpco(String recpco) {
		this.recpco = recpco;
	}

	public String getRecpco() {
		return recpco;
	}

	public void setVoucher_no(String voucher_no) {
		this.voucher_no = voucher_no;
	}

	public String getVoucher_no() {
		return voucher_no;
	}

	public String getPaymode() {
		return paymode;
	}

	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}

	public expenses_Bean getBean1() {
		return bean1;
	}

	public void setBean1(expenses_Bean bean1) {
		this.bean1 = bean1;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getChequeno() {
		return chequeno;
	}

	public void setChequeno(String chequeno) {
		this.chequeno = chequeno;
	}

	public String getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(String checkdate) {
		this.checkdate = checkdate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRecno() {
		return recno;
	}

	public void setRecno(String recno) {
		this.recno = recno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

