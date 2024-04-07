package com.master.action;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
//import com.aqua.dao.installation_claim_report_dao;
import com.master.dao.CityMasterDao;
import com.master.dao.MAterialReceivedDAO;
import com.master.dao.RouteMasterDao;
import com.master.dao.TripDao;
import com.master.dao.Inquiry.InquiryDao;
import com.master.model.CityModel;
import com.master.model.TripModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ParseException;

public class TripAction extends ActionSupport implements ServletRequestAware, SessionAware,ModelDriven<TripModel> {

	private TripModel tripModel = new TripModel();
	private List<TripModel> tripDetails;

	private TripModel tripModel1 = new TripModel();

	private String from_date;
	private String to_date;

	private String finalbalancecredit;
	private String finalbalancedebit;

	private String initialbalstore;
	private String initialbalaccounts;

	private String finalbalanccecredit;
	private String finalbalanccedebit;

	private String initialbalance;
	private String finalbalance;
	private String readyos;
	private String taxos;
	
	private String update_product;
	
	public String getUpdate_product() {
		return update_product;
	}

	public void setUpdate_product(String update_product) {
		this.update_product = update_product;
	}



	private File[] photo;
	
	 private String[] photoFileName;
	 private String[] photoContentType;
	 private String imageFileName;
	 private File image;
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}



	public File getImage() {
		return image;
	}



	public void setImage(File image) {
		this.image = image;
	}



	public String[] getPhotoFileName() {
		return photoFileName;
	}



	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}



	public String[] getPhotoContentType() {
		return photoContentType;
	}



	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}



	public File[] getPhoto() {
		return photo;
	}



	public void setPhoto(File[] photo) {
		this.photo = photo;
	}



	private String totaldebit;
	private String totalcredit;

	private String dealer_id;
	private String dealerid1;
	private String dealerid2;
	private String fromdate;
	private String todate;
	private String companyname;
	private String storecredit;
	private String storedebit;
	private String accountscredit;
	private String accountsdebit;
	private String accountsbalance;
	private String storebalance;
	private String storetransfer;
	private String accountstransfer;
	private String cashgiventosir;
	private String cashgiventosir2;
	
	private String path1;
	
	
	public String getPath1() {
		return path1;
	}

	public void setPath1(String path1) {
		this.path1 = path1;
	}



	HttpServletRequest request = ServletActionContext.getRequest();
	
	HttpServletRequest request2;
	
	public HttpServletRequest getRequest2() {
		return request2;
	}

	public void setRequest2(HttpServletRequest request2) {
		this.request2 = request2;
	}

	public String execute() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	
	}

	public String add_emp()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		System.out.println("11hiiii....");
		return "success";
		
	}
	
	public String insert_trip_details() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();

		String response;
		int i = 0;
		try {
			i = new TripDao().insert_trip_Details(tripModel,bean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :" + i);

		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}

	
	

public String deleteissueamount()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String delete_product_id=request.getParameter("product_id");
		
		int i=new TripDao().deleteissueamount(tripModel,delete_product_id);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}


	
	
	
	public String update_amount_issue_details()
	{
		String response;
				HttpServletRequest request=ServletActionContext.getRequest();
		
		/*request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		  ServletContext context = ServletActionContext.getServletContext();
	*/
		
		/*String update_product=request.getParameter("product_id");
		*/
		/*System.out.println("update:"+update_product);
		*/
	//	System.out.println("product model name : "+tripModel.getProduct_name());
		int i=new TripDao().update_amount_issue_details(tripModel);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	
	
	
	public String fetchTripDetails() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		
		tripDetails = new TripDao().fetchTripDetails(tripModel,bean);
		
		//System.out.println("Size -- -- - " + tripDetails.size());
		
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	
	
	
	
	
	public String amount_issueProductMasterDetails()
	{
		String response;
		tripDetails=new TripDao().amountDetails();
		if(tripDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	public String updateamountissue()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		String product_id=request.getParameter("product_id");
		System.out.println("update--------"+product_id);
		
		tripDetails=new TripDao().updateamountissue(tripModel,product_id);
		
		System.out.println(tripDetails.size());
		
		if(tripDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	
	
	
	
	public String fetchAmountIssueDetails() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;

		
		tripDetails = new TripDao().fetchAmountIssueDetails(tripModel, from_date, to_date,bean);
		
		
		//System.out.println("Size -- -- - " + tripDetails.size());
		
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	
	
	
	public String fetchAmountIssueDetails1() {
	
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return "success";
	
	}

	public String fetchExpenseDetails1() {
	
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return "success";
	
	}

	
	
	
	public String fetchExpenseDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String from_date=request.getParameter("from_date");
		String to_date=request.getParameter("to_date");
		
		tripDetails = new TripDao().fetchExpenseDetails(from_date, to_date, tripModel,bean);
		
		//System.out.println("Size -- -- - " + tripDetails.size());
		
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	
	public String lrForm() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		return "success";
	
	}

	
	public String lrForm1() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		return "success";
	
	}

	
	public String amtIssueForm() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		return "success";
	}

	
	public String tripIssueForm() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
	
		return "success";
	
	}

	
	public String tripIssueForm1() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	
	}

public String tripIssueForm11() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String inv=request.getParameter("inv");
		
		request.setAttribute("inv", inv);
		
		return "success";
	
	}
	
	public String tripIssueForm2() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	
	}

	
	
	public String expenseForm() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		/* String response = ""; */
		tripModel = new TripDao().getVoucherNo();
		System.out.println(tripModel.getVoucher_no());
		if (tripModel.getVoucher_no() != null)
			return "success";
		else
			return "fail";
	}

	
	
	public String updowninsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertUpdownDetails(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	
	
	
	public String fetchUpDownDetails() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		tripDetails = new TripDao().fetchUpDownDetails(tripModel,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	



	public String lrinsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		//System.out.println("000000000000----------"+bean.getUsername());

		String rep = new TripDao().insertLRDetails(tripModel,bean);
		// request.setAttribute("tripModel", tripModel);
		// TripModel tripModel1 = new TripDao().getLRPrintDetails();

		//System.out.println("commission: " + tripModel.getCommission());

		if (rep.equals("success")) {
			return "success";
		} else {
			return "error";
		}

		
	}
	
public String getno() {
		
		
		int size=3;
	    StringBuilder generatedToken = new StringBuilder();
	   
	    try {
	        SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
	      
	        // Generate 20 integers 0..20
	        for (int i = 0; i < size; i++) {
	            generatedToken.append(number.nextInt(9));
	            
	        }
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    String s1=generatedToken.toString();

	  
		return s1;
	}
	
	
public String deliveryinsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
			try {
			request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
				  ServletContext context = ServletActionContext.getServletContext();
			  
			 System.out.println("11123");   
				 
				String d = context.getRealPath("/").concat("PathologyReport");
			  
			  
				
				System.out.println("11134>:"+d);   
				
			
				
				/*for(int i=0;i<images.length;i++)
				{
				*/
					System.out.println("111355>:");
				System.out.println("1113477:"+imageFileName);
				String ss=getno().concat(imageFileName);
				File dfile = new File(d,ss);	
				System.out.println("111366:"+ss);
				try {
					FileUtils.copyFile(image,dfile); 
					
					System.out.println("111388:");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("error:");
					e.printStackTrace();
				}
				
				path1="PathologyReport" +  "\\"+ss ; 
				
				System.out.println("Action Path 1:"+path1);


				tripModel.setPath2(path1);  
				System.out.println("Action Path 222:"+path1 );
				
				//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			/*int ImgLen=0;
try{
		
		 ImgLen=image.length;
		
}
catch (Exception e) {
	// TODO Auto-generated catch block
 ImgLen=0;
	e.printStackTrace();
} */
	

		String rep = new TripDao().deliveryinsert(tripModel,bean);
		
		
		// request.setAttribute("tripModel", tripModel);
		// TripModel tripModel1 = new TripDao().getLRPrintDetails();

		//System.out.println("commission: " + tripModel.getCommission());

		if (rep.equals("success")) {
			return "success";
		} else {
			return "error";
		}

		
	}
	
	



public String piinsert() throws SQLException {
	
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
		try {
		request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
			  ServletContext context = ServletActionContext.getServletContext();
		  
		 System.out.println("11123");   
			 
			String d = context.getRealPath("/").concat("PathologyReport");
			System.out.println("11134>:"+d);   
				System.out.println("111355>:");
			System.out.println("1113477:"+imageFileName);
			String ss=getno().concat(imageFileName);
			File dfile = new File(d,ss);	
			System.out.println("111366:"+ss);
			try {
				FileUtils.copyFile(image,dfile); 
				
				System.out.println("111388:");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("error:");
				e.printStackTrace();
			}
			
			path1="PathologyReport" +  "\\"+ss ; 
			
			System.out.println("Action Path 1:"+path1);


			tripModel.setPath2(path1);  
			System.out.println("Action Path 222:"+path1 );
			
			//}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

	String rep = new TripDao().pininsert(tripModel,bean);
	

	if (rep.equals("success")) {
		return "success";
	} else {
		return "error";
	}

	
}

















	public String amtissueinsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertAmtIssueDetails(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	public String tripissueinsert() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertTripIssueDetails(tripModel,bean);

		System.out.println("status: " + status);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("insufficient")) {
			return "insufficient";
		}

		else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	public String tripissueinsert1() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertTripIssueDetails1(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("insufficient")) {
			return "insufficient";
		}

		else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}
	
	
public String tripissueinsert11() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertTripIssueDetails11(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("insufficient")) {
			return "insufficient";
		}

		else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	public String tripissueinsert2() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertTripIssueDetails2(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("insufficient")) {
			return "insufficient";
		}

		else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	public String expenseinsert() throws SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();
		String status = new TripDao().insertExpenseDetails(tripModel,bean);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";

		}
	}

	public String fetchLRDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		tripDetails = new TripDao().fetchLRDetails(tripModel,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
public String newfetchLRDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		tripDetails = new TripDao().newfetchLRDetails(tripModel,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	

	public String fetchTripExpensesDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		System.out.println("from date ---  " + from_date);
		tripDetails = new TripDao().fetchTripExpensesDetails(tripModel, from_date, to_date,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchTripIssueDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		
		tripDetails = new TripDao().fetchTripIssueDetails(tripModel, from_date, to_date,bean);
	
		
		if (tripDetails.size() > 0) {
			
			response = "success";
		
		} else {
			
			response = "fail";
		
		}

		return response;
	}

	
	
	public String fetchUpdownIssueDetails() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		System.out.println("from date ---  " + from_date);
		tripDetails = new TripDao().fetchUpdownIssueDetails(tripModel, from_date, to_date,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	
	
	
	public String printLR() {
		
			Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lr = request.getParameter("lr_number");

		
		tripModel1 = new TripDao().fetchorderLrView(tripModel1,bean,lr);
		
		tripDetails = new TripDao().fetchorderLrView1(tripModel, lr,bean);
		
		
		System.out.println("Count:"+tripModel1.getSn());

		return "success";
		
	}
	
	
	
	public String printInvoice() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return "success";
	}

	
	
	public String printID() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request = ServletActionContext.getRequest();

		return "success";
	}

	
	
	public String fetchTripExpensesDetails1() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	}

	public String fetchTripIssueDetails1() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	}

	
	public String fetchUpdownIssueDetails1() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	}

	
	
	public String managerLedgerReport() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response;
		// System.out.println("from date --- "+from_date);
		HttpServletRequest request = ServletActionContext.getRequest();
		String emp_name = request.getParameter("emp_name");
		String from_date = request.getParameter("from_date");
		String to_date = request.getParameter("to_date");

		tripDetails = new TripDao().fetchManagerLedger(emp_name, from_date, to_date,bean);
		System.out.println("Size -- -- - " + tripDetails.size());
		if (tripDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	

	public String managerLedgerReport1() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	}

	
	
	public String Transporter_Credit_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	

	public String supervisor_Credit_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
	
	
	public String daily_Cash_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
	
public String escalation_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
	

	public String Transporter_Credit_Advance_Report_Submitv() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		tripDetails = new TripDao().Transporter_Credit_Advance_Report_submitv(tripModel,bean);

		System.out.println("ddddd------"+tripDetails.size());
		for (int i = 0; i <tripDetails.size(); i++) {
			
			finalbalancedebit=tripDetails.get(i).getFinalbalancedebit();
			finalbalancecredit=tripDetails.get(i).getFinalbalancecredit();
			initialbalance=tripDetails.get(i).getInitialbalance();
			finalbalance=tripDetails.get(i).getFinalbalance();
			//dealerid2=report.get(i).getDealer_id();
			String s="";
			try{
				 s=tripModel.getDealer_id();
			//s = s.substring(s.indexOf("(") + 1);
			//s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			//dealerid1=tripDetails.get(i).getDelader();
			
			// fromdate=tripDetails.get(i).getFrom_date();
			//todate=tripDetails.get(i).getTo_date();
			
			}
		
			System.out.println("aaaaaa----"+finalbalancedebit);
			System.out.println("bbbbbb----"+finalbalancecredit);
			request2.setAttribute("finalbalancedebit",finalbalancedebit);
			request2.setAttribute("finalbalancecredit",finalbalancecredit);
			
			request2.setAttribute("initialbalance",initialbalance);  
			request2.setAttribute("finalbalance",finalbalance);
			request2.setAttribute("dealerid1",dealerid1);
			
			/*request.setAttribute("fromdate",fromdate);
			request.setAttribute("todate",todate);
*/
		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}

	
	
	
public String supervisor_Credit_Advance_Report_Submitv() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		tripDetails = new TripDao().supervisor_Credit_Advance_Report_submitv(tripModel,bean);

		for (int i = 0; i < tripDetails.size(); i++) {

			finalbalancedebit = tripDetails.get(i).getFinalbalancedebit();
			finalbalancecredit = tripDetails.get(i).getFinalbalancecredit();
			initialbalance = tripDetails.get(i).getInitialbalance();
			finalbalance = tripDetails.get(i).getFinalbalance();
			// System.out.println("finalbalancedebit: "+finalbalancedebit);
			// System.out.println("finalbalance: "+finalbalance);
			// System.out.println("initialbalance: "+initialbalance);
			/*
			 * readyos=tripDetails.get(i).getReadyos(); taxos=tripDetails.get(i).getTaxos();
			 * 
			 * totaldebit=tripDetails.get(i).getAccountsdebit();
			 * totalcredit=tripDetails.get(i).getAccountscredit();
			 */

			// dealerid2=report.get(i).getDealer_id();
			String s = "";
			try {
				s = tripModel.getDealer_id();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
			} catch (Exception e) {
				// TODO: handle exception
				s = "";
			}

			// dealerid1=report.get(i).getDelader()+"("+s+")~"+s;

			dealerid1 = tripDetails.get(i).getDelader();

			fromdate = tripDetails.get(i).getFrom_date();
			todate = tripDetails.get(i).getTo_date();
			// System.out.println(">>>>yes"+report.get(i).getDealer_id());
		}
		if (finalbalancecredit != null)
			request.setAttribute("finalbalancecredit", finalbalancecredit);
		if (finalbalancedebit != null)
			request.setAttribute("finalbalancedebit", finalbalancedebit);

		try {
			if (initialbalance != null)
				request.setAttribute("initialbalance", initialbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if (finalbalance != null)
				request.setAttribute("finalbalance", finalbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (readyos != null)
			request.setAttribute("readyos", readyos);
		if (taxos != null)
			request.setAttribute("taxos", taxos);
		if (totaldebit != null)
			request.setAttribute("totaldebit", totaldebit);
		if (totalcredit != null)
			request.setAttribute("totalcredit", totalcredit);
		if (dealerid1 != null)
			request.setAttribute("dealerid1", dealerid1);
		if (from_date != null)
			request.setAttribute("fromdate", from_date);
		if (to_date != null)
			request.setAttribute("todate", to_date);

		// name=dpb.getDelader();

		// System.out.println("Name:"+dealerid1);

		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}
	







public String daily_Cash_Credit_Advance_Report_Submitv() throws Exception {
	
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
	tripDetails = new TripDao().daily_Cash_Credit_Advance_Report_submitv(tripModel,bean);

		if (tripDetails != null) {
		return "success";
	} else {
		return ERROR;
	}

}


public String escalation_Report_Submitv() throws Exception {
	
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	
	tripDetails = new TripDao().escalation_Report_Submitv(tripModel,bean);

		if (tripDetails != null) {
		return "success";
	} else {
		return ERROR;
	}

}




	
	public String Driver_Credit_Advance_Reportv() throws IOException, SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
	
	

	public String Driver_Credit_Advance_Report_Submitv() throws Exception {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		
		tripDetails = new TripDao().Driver_Credit_Advance_Report_submitv(tripModel,bean);

		for (int i = 0; i < tripDetails.size(); i++) {

			finalbalancedebit = tripDetails.get(i).getFinalbalancedebit();
			finalbalancecredit = tripDetails.get(i).getFinalbalancecredit();
			initialbalance = tripDetails.get(i).getInitialbalance();
			finalbalance = tripDetails.get(i).getFinalbalance();
			System.out.println("finalbalancedebit: " + finalbalancedebit);
			System.out.println("finalbalance: " + finalbalance);
			System.out.println("initialbalance: " + initialbalance);
			/*
			 * readyos=tripDetails.get(i).getReadyos(); taxos=tripDetails.get(i).getTaxos();
			 * 
			 * totaldebit=tripDetails.get(i).getAccountsdebit();
			 * totalcredit=tripDetails.get(i).getAccountscredit();
			 */

			// dealerid2=report.get(i).getDealer_id();
			String s = "";
			try {
				s = tripModel.getDealer_id();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
			} catch (Exception e) {
				// TODO: handle exception
				s = "";
			}

			// dealerid1=report.get(i).getDelader()+"("+s+")~"+s;

			dealerid1 = tripDetails.get(i).getDelader();

			fromdate = tripDetails.get(i).getFrom_date();
			todate = tripDetails.get(i).getTo_date();
			// System.out.println(">>>>yes"+report.get(i).getDealer_id());
		}
		if (finalbalancecredit != null)
			request.setAttribute("finalbalancecredit", finalbalancecredit);
		if (finalbalancedebit != null)
			request.setAttribute("finalbalancedebit", finalbalancedebit);

		try {
			if (initialbalance != null)
				request.setAttribute("initialbalance", initialbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if (finalbalance != null)
				request.setAttribute("finalbalance", finalbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (readyos != null)
			request.setAttribute("readyos", readyos);
		if (taxos != null)
			request.setAttribute("taxos", taxos);
		if (totaldebit != null)
			request.setAttribute("totaldebit", totaldebit);
		if (totalcredit != null)
			request.setAttribute("totalcredit", totalcredit);
		if (dealerid1 != null)
			request.setAttribute("dealerid1", dealerid1);
		if (from_date != null)
			request.setAttribute("fromdate", from_date);
		if (to_date != null)
			request.setAttribute("todate", to_date);

		// name=dpb.getDelader();

		// System.out.println("Name:"+dealerid1);

		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}
	
	

	public String Customer_Credit_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
public String Customer_Credit_Advance_Reportv123() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}
	
	

	public String Customer_Credit_Advance_Report_Submitv() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		tripDetails = new TripDao().Customer_Credit_Advance_Report_submitv(tripModel,bean);

for (int i = 0; i <tripDetails.size(); i++) {
			
			finalbalancedebit=tripDetails.get(i).getFinalbalancedebit();
			finalbalancecredit=tripDetails.get(i).getFinalbalancecredit();
			initialbalance=tripDetails.get(i).getInitialbalance();
			finalbalance=tripDetails.get(i).getFinalbalance();
			//dealerid2=report.get(i).getDealer_id();
			String s="";
			try{
				 s=tripModel.getDealer_id();
			//s = s.substring(s.indexOf("(") + 1);
			//s = s.substring(0, s.indexOf(")"));
			}catch (Exception e) {
				// TODO: handle exception
				s="";
			}
			//dealerid1=tripDetails.get(i).getDelader();
			
			// fromdate=tripDetails.get(i).getFrom_date();
			//todate=tripDetails.get(i).getTo_date();
			
			}
		
			System.out.println("aaaaaa----"+finalbalancedebit);
			System.out.println("bbbbbb----"+finalbalancecredit);
			request2.setAttribute("finalbalancedebit",finalbalancedebit);
			request2.setAttribute("finalbalancecredit",finalbalancecredit);
			
			request2.setAttribute("initialbalance",initialbalance);  
			request2.setAttribute("finalbalance",finalbalance);
			request2.setAttribute("dealerid1",dealerid1);
	
		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}

	
	
	
public String Customer_Credit_Advance_Report_Submitv123() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		System.out.println("aaaaaaaaaaaaaaaa");
		tripDetails = new TripDao().Customer_Credit_Advance_Report_submitv123(tripModel,bean);

		System.out.println("sssssssssssssss---"+tripDetails.size());
		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}

	
	
	public String Manager_Credit_Advance_Reportv() throws IOException, SQLException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		return "success";

	}

	
	
	public String Manager_Credit_Advance_Report_Submitv() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		tripDetails = new TripDao().Manager_Credit_Advance_Report_submitv(tripModel,bean);

		for (int i = 0; i < tripDetails.size(); i++) {

			finalbalancedebit = tripDetails.get(i).getFinalbalancedebit();
			finalbalancecredit = tripDetails.get(i).getFinalbalancecredit();
			initialbalance = tripDetails.get(i).getInitialbalance();
			finalbalance = tripDetails.get(i).getFinalbalance();
			System.out.println("finalbalancedebit: " + finalbalancedebit);
			System.out.println("finalbalance: " + finalbalance);
			System.out.println("initialbalance: " + initialbalance);
			/*
			 * readyos=tripDetails.get(i).getReadyos(); taxos=tripDetails.get(i).getTaxos();
			 * 
			 * totaldebit=tripDetails.get(i).getAccountsdebit();
			 * totalcredit=tripDetails.get(i).getAccountscredit();
			 */

			// dealerid2=report.get(i).getDealer_id();
			String s = "";
			try {
				s = tripModel.getDealer_id();
				s = s.substring(s.indexOf("(") + 1);
				s = s.substring(0, s.indexOf(")"));
			} catch (Exception e) {
				// TODO: handle exception
				s = "";
			}

			// dealerid1=report.get(i).getDelader()+"("+s+")~"+s;

			dealerid1 = tripDetails.get(i).getDelader();

			fromdate = tripDetails.get(i).getFrom_date();
			todate = tripDetails.get(i).getTo_date();
			// System.out.println(">>>>yes"+report.get(i).getDealer_id());
		}
		if (finalbalancecredit != null)
			request.setAttribute("finalbalancecredit", finalbalancecredit);
		if (finalbalancedebit != null)
			request.setAttribute("finalbalancedebit", finalbalancedebit);

		try {
			if (initialbalance != null)
				request.setAttribute("initialbalance", initialbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if (finalbalance != null)
				request.setAttribute("finalbalance", finalbalance);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (readyos != null)
			request.setAttribute("readyos", readyos);
		if (taxos != null)
			request.setAttribute("taxos", taxos);
		if (totaldebit != null)
			request.setAttribute("totaldebit", totaldebit);
		if (totalcredit != null)
			request.setAttribute("totalcredit", totalcredit);
		if (dealerid1 != null)
			request.setAttribute("dealerid1", dealerid1);
		if (from_date != null)
			request.setAttribute("fromdate", from_date);
		if (to_date != null)
			request.setAttribute("todate", to_date);

		// name=dpb.getDelader();

		// System.out.println("Name:"+dealerid1);

		if (tripDetails != null) {
			return "success";
		} else {
			return ERROR;
		}

	}

	
	
	public String aa()

	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		return "success";
	}

	
	
	public String orderLrView()

	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lr = request.getParameter("lr_number");

		
		tripModel1 = new TripDao().fetchorderLrView(tripModel1,bean,lr);
		
		tripDetails = new TripDao().fetchorderLrView1(tripModel, lr,bean);
		
		
		System.out.println("Count:"+tripModel1.getSn());

		return "success";
	}
	
	
	
	public String orderLrViewaabb()

	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lr = request.getParameter("lr_number");

		
		tripDetails = new TripDao().fetchorderLrView1ccdd(tripModel1,lr,bean);
			
		//System.out.println("Count:"+tripModel1.getSn());

		return "success";
	}
	
	
	
	
	
	public String delivery_done()

	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String lr = request.getParameter("lr_number");

		
		tripModel1 = new TripDao().delivery_done(tripModel1,bean,lr);
		
		tripDetails = new TripDao().delivery_done1(tripModel, lr,bean);
		
	
		return "success";
	}
	
	

	public String lrupdate() throws SQLException {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		

		String rep = new TripDao().updateLRDetails(tripModel,bean);

		if (rep.equals("success")) {
			return "success";
		} else {
			return "error";
		}

	}

	
	public String lrCancel() {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		HttpServletRequest request = ServletActionContext.getRequest();

		String lr_number = request.getParameter("lr_number");

		String ss = new TripDao().lrCancel(tripModel, lr_number,bean);

		if (ss.equals("success"))

		{
			return "success";

		}

		else {

			return "fail";
		}
	}

	
	
	
	public String insert_status() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		

		String ss = new TripDao().insert_status(tripModel,bean);

		tripDetails = new TripDao().fetchLRDetails(tripModel,bean);

		if (ss.equals("success"))

		{
			return "success";

		}

		else {

			return "fail";
		}

	}

	
	public String insert_chitchat() throws Exception {
		
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		

		String ss = new TripDao().insert_chitchat(tripModel,bean);

		tripDetails = new TripDao().fetchLRDetails(tripModel,bean);

		if (ss.equals("success"))

		{
			return "success";

		}

		else {

			return "fail";
		}

	}
	
	
	
	
	
	public String insert_amt() throws SQLException, ParseException {
  		// TODO Auto-generated method stub
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
	
  		 String response = new TripDao().insert_amt(tripModel,bean);
  		 
  		 
  		 System.out.println("response"+response);
  		if(response.equals("Already")) 
  		 {
  		 	response="Already";
  		 }  
  		  else
  		
  		 if(response.equals("success"))
  		  {
  		 	 response="success"; 
  		  } 
  		  else
  		  {
  		 	 response="fail";
  		  }
  		 	
  		 	
  		 	return response;

  		 }
	
	
	
	public String InsertCustCreditDebit()
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		String recpco;
		
		String status=new TripDao().insertcustcreditdebitnote(tripModel,bean);		
		recpco=tripModel.getVoucher_no();
		System.out.println(recpco);
		if(status.equals("success"))
		{
			return "success";
		}
		else
		{
			return "fail";
		}

}
	
public String CustCreditNoteReport() throws Exception{
		
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);

	
	tripDetails = new TripDao().fetchCreditDebitNoteCust(tripModel);
		
		/*bankledger = TripDao.fetchCreditDebitNoteCust(dpb);
		
		System.out.println("Size:"+bankledger.size());
	*/	
		return "success";
		
	}



public String SupCreditNoteReport() throws Exception{
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);

	
	tripDetails = new TripDao().fetchCreditDebitNoteSup(tripModel);
	
	return "success";
	
}
	










public String insertlradvanceform() throws SQLException {
	
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);

	HttpServletRequest request = ServletActionContext.getRequest();
	String status = new TripDao().insertLrAdvanceform(tripModel,bean);

	System.out.println("status: " + status);

	if (status.equals("success")) {
		return "success";
	} else if (status.equals("insufficient")) {
		return "insufficient";
	}

	else if (status.equals("Already")) {
		return "Already";
	} else {
		return "error";

	}
}


public String vendor_Credit_Advance_Reportv() throws IOException, SQLException {
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);

	return "success";

}







public String vendor_Credit_Advance_Report_Submitv() throws Exception {
	
	
	Map session = ActionContext.getContext().getSession();
	userinfo bean = new userinfo();
	bean = (userinfo) session.get(Constants.USER_PROFILE);
	
	tripDetails = new TripDao().vendor_Credit_Advance_Report_submitv(tripModel,bean);

for (int i = 0; i <tripDetails.size(); i++) {
		
		finalbalancedebit=tripDetails.get(i).getFinalbalancedebit();
		finalbalancecredit=tripDetails.get(i).getFinalbalancecredit();
		initialbalance=tripDetails.get(i).getInitialbalance();
		finalbalance=tripDetails.get(i).getFinalbalance();
		//dealerid2=report.get(i).getDealer_id();
		String s="";
		try{
			 s=tripModel.getDealer_id();
		//s = s.substring(s.indexOf("(") + 1);
		//s = s.substring(0, s.indexOf(")"));
		}catch (Exception e) {
			// TODO: handle exception
			s="";
		}
		//dealerid1=tripDetails.get(i).getDelader();
		
		// fromdate=tripDetails.get(i).getFrom_date();
		//todate=tripDetails.get(i).getTo_date();
		
		}
	
		System.out.println("aaaaaa----"+finalbalancedebit);
		System.out.println("bbbbbb----"+finalbalancecredit);
		request2.setAttribute("finalbalancedebit",finalbalancedebit);
		request2.setAttribute("finalbalancecredit",finalbalancecredit);
		
		request2.setAttribute("initialbalance",initialbalance);  
		request2.setAttribute("finalbalance",finalbalance);
		request2.setAttribute("dealerid1",dealerid1);

	if (tripDetails != null) {
		return "success";
	} else {
		return ERROR;
	}

}








	

	@Override
	public TripModel getModel() {
		// TODO Auto-generated method stub
		return tripModel;
	}

	public String getFinalbalancecredit() {
		return finalbalancecredit;
	}

	public void setFinalbalancecredit(String finalbalancecredit) {
		this.finalbalancecredit = finalbalancecredit;
	}

	public String getFinalbalancedebit() {
		return finalbalancedebit;
	}

	public void setFinalbalancedebit(String finalbalancedebit) {
		this.finalbalancedebit = finalbalancedebit;
	}

	public String getInitialbalstore() {
		return initialbalstore;
	}

	public void setInitialbalstore(String initialbalstore) {
		this.initialbalstore = initialbalstore;
	}

	public String getInitialbalaccounts() {
		return initialbalaccounts;
	}

	public void setInitialbalaccounts(String initialbalaccounts) {
		this.initialbalaccounts = initialbalaccounts;
	}

	public String getFinalbalanccecredit() {
		return finalbalanccecredit;
	}

	public void setFinalbalanccecredit(String finalbalanccecredit) {
		this.finalbalanccecredit = finalbalanccecredit;
	}

	public String getFinalbalanccedebit() {
		return finalbalanccedebit;
	}

	public void setFinalbalanccedebit(String finalbalanccedebit) {
		this.finalbalanccedebit = finalbalanccedebit;
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

	public String getReadyos() {
		return readyos;
	}

	public void setReadyos(String readyos) {
		this.readyos = readyos;
	}

	public String getTaxos() {
		return taxos;
	}

	public void setTaxos(String taxos) {
		this.taxos = taxos;
	}

	public String getTotaldebit() {
		return totaldebit;
	}

	public void setTotaldebit(String totaldebit) {
		this.totaldebit = totaldebit;
	}

	public String getTotalcredit() {
		return totalcredit;
	}

	public void setTotalcredit(String totalcredit) {
		this.totalcredit = totalcredit;
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

	public String getStorecredit() {
		return storecredit;
	}

	public void setStorecredit(String storecredit) {
		this.storecredit = storecredit;
	}

	public String getStoredebit() {
		return storedebit;
	}

	public void setStoredebit(String storedebit) {
		this.storedebit = storedebit;
	}

	public String getAccountscredit() {
		return accountscredit;
	}

	public void setAccountscredit(String accountscredit) {
		this.accountscredit = accountscredit;
	}

	public String getAccountsdebit() {
		return accountsdebit;
	}

	public void setAccountsdebit(String accountsdebit) {
		this.accountsdebit = accountsdebit;
	}

	public String getAccountsbalance() {
		return accountsbalance;
	}

	public void setAccountsbalance(String accountsbalance) {
		this.accountsbalance = accountsbalance;
	}

	public String getStorebalance() {
		return storebalance;
	}

	public void setStorebalance(String storebalance) {
		this.storebalance = storebalance;
	}

	public String getStoretransfer() {
		return storetransfer;
	}

	public void setStoretransfer(String storetransfer) {
		this.storetransfer = storetransfer;
	}

	public String getAccountstransfer() {
		return accountstransfer;
	}

	public void setAccountstransfer(String accountstransfer) {
		this.accountstransfer = accountstransfer;
	}

	public String getCashgiventosir() {
		return cashgiventosir;
	}

	public void setCashgiventosir(String cashgiventosir) {
		this.cashgiventosir = cashgiventosir;
	}

	public String getCashgiventosir2() {
		return cashgiventosir2;
	}

	public void setCashgiventosir2(String cashgiventosir2) {
		this.cashgiventosir2 = cashgiventosir2;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String from_date) {
		this.from_date = from_date;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public TripModel getTripModel() {
		return tripModel;
	}

	public void setTripModel(TripModel tripModel) {
		this.tripModel = tripModel;
	}

	public TripModel getTripModel1() {
		return tripModel1;
	}

	public void setTripModel1(TripModel tripModel1) {
		this.tripModel1 = tripModel1;
	}

	public List<TripModel> getTripDetails() {
		return tripDetails;
	}

	public void setTripDetails(List<TripModel> tripDetails) {
		this.tripDetails = tripDetails;
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
	public void setServletRequest(HttpServletRequest request2) {
		this.request2 = request2;
		
	}
	
	
	

	
	
	

}