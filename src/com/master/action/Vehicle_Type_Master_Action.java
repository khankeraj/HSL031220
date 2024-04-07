package com.master.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.Vehicle_Type_Master_Dao;
import com.master.model.LoginBean;
import com.master.model.TransportBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Vehicle_Type_Master_Action extends ActionSupport implements ModelDriven<TransportBean>, ServletRequestAware {

	/**
	 * 
	 */
	@Override

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	private static final long serialVersionUID = 1L;

	HttpServletRequest request;

	private TransportBean bin = new TransportBean();

	private List<TransportBean> ProductReport = new ArrayList<TransportBean>();

	private Map session;
	
	private String price1;
	
	
	
	

	public String insertVehicleTypeMaster() throws SQLException, ParseException {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		String response = new Vehicle_Type_Master_Dao().insertVehicleTypeMaster(bin,bean);
		
		if (response.equals("Already")) {
			response = "already";
		
		} else if (response.equals("success")) {
			response = "success";
		
		} else {
			response = "fail";
		}
		
		return response;

	}

	
	public String execute()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		return "success";
		
	}
	
	

	
	
	public String displayVehicleTypeMaster() throws SQLException, ParseException {

		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		ProductReport = new Vehicle_Type_Master_Dao().displayVehicleTypeMaster(bean);
		
		
		  return "display";

	}
	
	
	
	public String editVehicleTypeMaster()
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		ProductReport = new Vehicle_Type_Master_Dao().displayVehicleTypeMasterEdit(bean,id);
		
		if(ProductReport.size()>0)
		{
			response="editVehicleTypeMaster";
		}
		else
		{
			response="fail";
		}
		
		return response;
		
		//return "editProductMaster";
	}
	
	
	
	
	
	
	public String updateVehicleTypeMaster() throws Exception
	{
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		List<TransportBean> ss = Vehicle_Type_Master_Dao.updateVehicleTypeMaster(bin,bean);
		
		
		ProductReport = new Vehicle_Type_Master_Dao().displayVehicleTypeMaster(bean);
		
		return "updateVehicleTypeMaster";
	}
	
	
	
	public String deleteVehicleTypeMaster() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		
		String delete=Vehicle_Type_Master_Dao.deleteVehicleTypeMaster(bin,bean,id);
		
		ProductReport = new Vehicle_Type_Master_Dao().displayVehicleTypeMaster(bean);
		
		return "deleteVehicleTypeMaster";
		
	}
	
	
	
	/*public String Add_New_Medicine()throws IOException,SQLException
	{
		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String medicine = request.getParameter("medicine");
		
		String hsn = request.getParameter("hsn");
		
		String tax = request.getParameter("tax");
		
		String price = request.getParameter("price");
	
		String qty1 = request.getParameter("qty1");
		
		String bprice = request.getParameter("bprice");
		
		String dprice = request.getParameter("dprice");
		
		String molecule = request.getParameter("molecule");
		
		//String clinic_type = request.getParameter("clinic_type");
	
		
		
		
		String response = new Vehicle_Type_Master_Dao().insertmedicineInfo( medicine,hsn,tax,price,qty1,bin,bean,bprice,dprice,molecule);
		if(response.equalsIgnoreCase("already"))
		{
			//request.setAttribute("role_bean",Job_card_bean);
			return "already";
		}
		else 	if(response.equalsIgnoreCase("success"))
		
		{
			return "success";	
		}else{
			return "fail";	
		}
		
		
	}
	public String getpmsvalue12() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String medicine = request.getParameter("medicine");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price1 = new Vehicle_Type_Master_Dao().getpmsvalue12(medicine,  bean);

		return "success";

	}
	
	
	public String ValidEmailCheck() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String email = request.getParameter("email");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price1 = new Vehicle_Type_Master_Dao().ValidEmailCheck(email,  bean);

		return "success";

	}
	
	public String getpmsvalue123() {

		Map session = ActionContext.getContext().getSession();
		LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String particular_name = request.getParameter("particular_name");
		//String qty = request.getParameter("qty");
		//String btype = request.getParameter("btype");
		price1 = new Vehicle_Type_Master_Dao().getpmsvalue123(particular_name,  bean);

		return "success";

	}*/

	

	public String getPrice1() {
		return price1;
	}


	public void setPrice1(String price1) {
		this.price1 = price1;
	}


	


	public Map getSession() {
		return session;
	}


	public void setSession(Map session) {
		this.session = session;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


	public TransportBean getBin() {
		return bin;
	}


	public void setBin(TransportBean bin) {
		this.bin = bin;
	}


	public List<TransportBean> getProductReport() {
		return ProductReport;
	}


	public void setProductReport(List<TransportBean> productReport) {
		ProductReport = productReport;
	}


	@Override
	public TransportBean getModel() {
		// TODO Auto-generated method stub
		return bin;
	}


	


	

	
}
