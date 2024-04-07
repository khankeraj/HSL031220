package com.login.loginAction;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.Factory.ServiceFactory;
import com.Service.LoginService;
import com.dao.Impl.Authorization;
import com.login.loginDao.LoginDAO;
import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.DeliveryDoneDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven,SessionAware{
	
	private userinfo userinfo=new userinfo();

	private String total_outstanding = "";
	
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
	
	

	public String getTotal_outstanding() {
		return total_outstanding;
	}

	public void setTotal_outstanding(String total_outstanding) {
		this.total_outstanding = total_outstanding;
	}

	public userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
	Map session;
	
	
	public String getAccess() throws Exception
	{
		
		
		System.out.println("check=" +userinfo.getUsername());
		ServiceFactory factory = ServiceFactory.getInstance();
		LoginService loginservice = factory.getLoginService();
		userinfo loginbean = loginservice.loginService(userinfo.getUsername(), userinfo.getPassword());
		
		
		System.out.println("ok3"+loginbean.getInvaliduser());
		if (loginbean.getInvaliduser() == "0" || loginbean.getInvaliduser() == "1") {
			
			userinfo lb = loginbean;//new LoginBean();
			
			lb.setUsername(loginbean.getUsername());
			
			
			Authorization a = new Authorization();
			System.out.println("qqqqqqqqqqqqqqq==="+loginbean.getType());
			session=ActionContext.getContext().getSession();
			
			session.put(Constants.USER_PROFILE, loginbean);
			session.put("username",loginbean.getUsername());
			
			session.put("type",loginbean.getType());
			
			System.out.println("test check");
			Map menus = a.menu(lb);
			
			System.out.println("test check1");
			if (menus != null) {
				
					session.put("menus", menus);
				
			}
			total_outstanding = new LoginDAO().getTotalOutstanding();
			
			//System.out.println("Menu:"+menus);
			try {
				
				graph1=new DeliveryDoneDao().getBusinessGraph();
				
				graph2=new DeliveryDoneDao().getOrderLostGraph();
				
				graph3=new DeliveryDoneDao().getResourceEnquiryGraph();
				
				graph4=new DeliveryDoneDao().getResourceEnquiryGraph1();
				
				graph5=new DeliveryDoneDao().businessGraph();
				
				graph6=new DeliveryDoneDao().eximyGraph();
				
				graph7=new DeliveryDoneDao().eximyGraph1();
				graph8=new DeliveryDoneDao().eximyGraph123();
				
				//System.out.println("--- "+graph3);
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			if (loginbean.getInvaliduser() == "1" ) {
				//System.out.println("connected...20");
			
			return SUCCESS;
			
			}else{
			
				//System.out.println("connected...21");
				return "SUCCESSV";
				
			}

			
			
		}else if (loginbean.getInvaliduser().equals("invalidusername")) { 
			//System.out.println("connected...22");
			return "ERRORUSERNAME";
		}else {
			
			//System.out.println("connected...23");
			return ERROR;
		}
	
		
		
		/*String response="";
		
		userinfo user=new userinfo();
		
		//System.out.println("login action");
		
		String status=new LoginDAO().getLoginAccess(user);
		
		session=ActionContext.getContext().getSession();
		
		session.put(Constants.USER_PROFILE, userinfo);
		
		session.put("username",userinfo.getUsername());
		
		//System.out.println("status:"+status);
		
		//total_outstanding = new LoginDAO().getTotalOutstanding();
		
		
		try {
			
			graph1=new DeliveryDoneDao().getBusinessGraph();
			
			graph2=new DeliveryDoneDao().getOrderLostGraph();
			
			graph3=new DeliveryDoneDao().getResourceEnquiryGraph();
			
			graph4=new DeliveryDoneDao().getResourceEnquiryGraph1();
			
			graph5=new DeliveryDoneDao().businessGraph();
			
			graph6=new DeliveryDoneDao().eximyGraph();
			
			graph7=new DeliveryDoneDao().eximyGraph1();
			graph8=new DeliveryDoneDao().eximyGraph123();
			
			//System.out.println("--- "+graph3);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		if(status.equals("success"))
		
		{
			response="success";
		
		}
		
		else {
		
			HttpServletRequest request = ServletActionContext.getRequest();
		
			request.setAttribute("fail", "Please Check Username OR Password...Correctly!!!");
		
			response="fail";
		}
		
		return response;*/
		
	}
	
	
	public String getdashboard()
	{
		
		
		/*total_outstanding = "2000";*/
		
		try {
			
			graph1=new DeliveryDoneDao().getBusinessGraph();
			
			graph2=new DeliveryDoneDao().getOrderLostGraph();
			
			graph3=new DeliveryDoneDao().getResourceEnquiryGraph();
			
			graph4=new DeliveryDoneDao().getResourceEnquiryGraph1();
			
			total_outstanding = new LoginDAO().getTotalOutstanding();
			
			//System.out.println("--- "+graph3);
		
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		
		return "success";
	}
	
	
	
	public String getLogout()
	{
		
		
		return "success";
	}
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return userinfo;
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

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	

}
