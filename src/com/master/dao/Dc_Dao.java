package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.login.loginModel.userinfo;
import com.master.model.Dc_bean;
import com.master.model.LoginBean;
import com.master.util.CoreData;
import com.master.util.SystemDateTime;

public class Dc_Dao {
	
	
	static DBConnection connection=new DBConnection();
	//static Connection conn=connection.getConnection();

	public static String insert(Dc_bean eb, userinfo bean) {
		
		
		String response = "";
		
		Connection conn=connection.getConnection();
		
		try {
		
		String Scode = "";
		String Scode1="";
		//Connection conn=DaoHelper.getConnection();
	
		try {
			
			PreparedStatement preparedStatementx = conn.prepareStatement("select  max(SUBSTRING(Dc_id,3,5)) from dc where LENGTH(Dc_id)=5  and status='0' ");
			System.out.println("SQL............"+preparedStatementx);
			ResultSet resultSetx = preparedStatementx.executeQuery();
			if (resultSetx.next()) {
				
				Scode = String.valueOf(Integer.parseInt(resultSetx
						.getString(1)) + 1);
				if (String.valueOf(Scode).length() == 1) {
					Scode = "DC00" + Scode;
				} else if (String.valueOf(Scode).length() == 2) {
					Scode = "DC0" + Scode;
				} else if (String.valueOf(Scode).length() == 3) {
					Scode = "DC" + Scode;
				}
			} else {
				Scode = "DC001";
			}
		} catch (Exception e) {
			Scode = "DC001";
		} 
		
		eb.setDc_id(Scode);
		
		
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("insert into dc(Dc_id,cust_name,mob_no,cust_address,pancard_no,email,gstn_no,custid,date,cno,cdate,pono,username,datetime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
				
				pst.setString(1, eb.getDc_id());
				pst.setString(2, eb.getCust_name());
				pst.setString(3, eb.getMob_no());
				pst.setString(4, eb.getCust_address());
				pst.setString(5, eb.getPancard_no());
				pst.setString(6, eb.getEmail());
				pst.setString(7, eb.getGstn_no());
				pst.setString(8, eb.getCustid());
				
				
				pst.setString(9, eb.getDate());
				pst.setString(10, eb.getCno());
				pst.setString(11, eb.getCdate());
				pst.setString(12, eb.getPono());
				
				pst.setString(13, bean.getUsername());
				pst.setString(14, SystemDateTime.CurrentDateTime());
				
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
					
					PreparedStatement pst2 = conn
							.prepareStatement("insert into dc_details(Dc_id,description,qty,price,pono,username,datetime) values(?,?,?,?,?,?,?) ");
					
					pst2.setString(1, eb.getDc_id());	
					pst2.setString(2, eb.getDescription()[k]);
					pst2.setString(3, eb.getQty()[k]);
					pst2.setString(4, eb.getPrice()[k]);
					pst2.setString(5, eb.getPono());
					
					pst2.setString(6, bean.getUsername());
					pst2.setString(7, SystemDateTime.CurrentDateTime());
					
					System.out.println("Sql2:..........."+pst2);
					pst2.executeUpdate();
					
				}
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
				
				PreparedStatement pp = conn
						.prepareStatement("select qty,descrip from purchase_order_details where invoice_no='"+eb.getPono()+"' and descrip='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp);
				ResultSet rst = pp.executeQuery();
			
				while (rst.next()) {
					
				String desc=eb.getDescription()[k];
				String qty=rst.getString("qty");
				
				String qty1=eb.getQty()[k];
					
				Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);
				
				System.out.println("QUantity:"+qty2);
				
				String q11 = "update purchase_order_details set  remainingqty='"+qty2+"',username=?,datetime=? where descrip='"+eb.getDescription()[k]+"' and invoice_no='"+eb.getPono()+"'";
		       	PreparedStatement ps1 = conn.prepareStatement(q11);	
		    	ps1.setString(1, bean.getUsername());
				ps1.setString(2, SystemDateTime.CurrentDateTime());
		       	
		     System.out.println("Sql12::"+ps1);
		    	
		       	ps1.executeUpdate();
				
				}
				
				}
					/*try {
						
						
						
						PreparedStatement ppp = conn.prepareStatement("select  max(SUBSTRING(client_id,5,7)) from customer_master where LENGTH(client_id)=7");
						System.out.println("SQL"+ppp);
						ResultSet rs = ppp.executeQuery();
						if (rs.next()) {
							System.out.println("11");
							Scode1 = String.valueOf(Integer.parseInt(rs
									.getString(1)) + 1);
							if (String.valueOf(Scode1).length() == 1) {
								Scode1 = "CUST00" + Scode1;
							} else if (String.valueOf(Scode1).length() == 2) {
								Scode1 = "CUST0" + Scode1;
							} else if (String.valueOf(Scode1).length() == 3) {
								Scode1 = "CUST" + Scode1;
							}
						} else {
							Scode1 = "CUST001";
						}
					} catch (Exception e) {
						Scode1 = "CUST001";
					} 
					
					pb.setClient_id(Scode1);*/
					
					
				/*	try {
					
					
					PreparedStatement preparedStatement = connection
							.prepareStatement("select * from customer_master where client_name=? and email=?");
			
					preparedStatement.setString(1, pb.getClient_name());
					preparedStatement.setString(2, pb.getEmail());
					
					
					ResultSet resultSet = preparedStatement.executeQuery();
				
					if (resultSet.next()) {
						response = "success";
					}

					else {
						
						
				PreparedStatement pst1 = connection
						.prepareStatement("insert into customer_master(client_id,client_name,mobile_no,email,address) values(?,?,?,?,?) ");
				
				pst1.setString(1, pb.getClient_id());
				pst1.setString(2, pb.getClient_name());
				pst1.setString(3, pb.getMobile_no());
				pst1.setString(4, pb.getEmail());
				pst1.setString(5, pb.getAddress());
				
				pst1.executeUpdate();
				
				
				
					}
					response= "success";

		} catch (Exception e) {

			response = "";
		}*/
				response="success";
	}catch (Exception e) {

		response = "";
	}
		}catch (Exception e) {

		response = "";
	}
		
		
		DBConnection.closeConnection();
		return response;
	}

	public String getcust(String cust_name, userinfo bean) throws SQLException {
		
		String response = "";
		String response1 = "";
		
		
		Connection conn=connection.getConnection();
		
		//System.out.println("customer_name"+cust_name);
/*try{*/
			//Connection connection = DaoHelper.getConnection();
			
			PreparedStatement preparedStatement112 = conn
			.prepareStatement("select * from customer_master where cust_id=?");
	preparedStatement112.setString(1, cust_name);
	System.out.println("customer info ..."+preparedStatement112);
	ResultSet resultSet12 = preparedStatement112.executeQuery();
	
	if (resultSet12.next()) {
		
		
			response = resultSet12.getString("cust_address") + "~"+ resultSet12.getString("mobile_no")+ "~"+ resultSet12.getString("chasis_no")+ "~"+ resultSet12.getString("company_vat")+ "~"+ resultSet12.getString("vehicle_no")+ "~"+ resultSet12.getString("cust_name");
			
					System.out.println("response is"+response);
		
	}
	DBConnection.closeConnection();
		return response;

	}


	
	public static Dc_bean makedcinvoice(Dc_bean eb) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
	
		Connection conn=connection.getConnection();
		//Connection connection = DaoHelper.getConnection();
		
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> email=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		
		String job="";
		String dd="";
	//	List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
		for(int i=0;i<eb.getDcno().length;i++){
			
			
			job += eb.getDcno()[i]+"~";
		   // job +="~";
				
			
			System.out.println("Job::"+job);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from billing where job_card_id=?");
			
			preparedStatement112xx.setString(1, eb.getDcno()[i]);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				bean1.setCust_name(resultSet12xx.getString("client_name"));
				//bean1.setMob_no(resultSet12xx.getString("mob_no"));
				//bean1.setGstn_no(resultSet12xx.getString("gstn_no"));
				//bean1.setPancard_no(resultSet12xx.getString("pancard_no"));
				bean1.setCustid(resultSet12xx.getString("client_id"));
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master where client_id=?");
				preparedStatement112xx1.setString(1, resultSet12xx.getString("client_id"));
				
				System.out.println("SQL1:"+preparedStatement112xx1);
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("area"));
					bean1.setAddress(resultSet12xx1.getString("address"));
					
					
					
					
				}
				
			
				
			}
			
			
			try {
				PreparedStatement preparedStatement1 = conn
						.prepareStatement("SELECT (SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00)) ) -( SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00))) AS amt FROM customercreditdebit where Customercode='"+resultSet12xx.getString("client_id")+"' ");	

				System.out.println("SQL:"+preparedStatement1);

				ResultSet rs112 = preparedStatement1.executeQuery();
				
				String pendingamt = "";Double totos=0.0;
				
				if (rs112.next()) {
					pendingamt=rs112.getString("amt");
				}
				
				

				bean1.setCno(pendingamt);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from billing where job_card_id=?");
			preparedStatement112.setString(1, eb.getDcno()[i]);
			
			
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				
				 
				
				dcno.add(eb.getDcno()[i]);
				
				description1.add(resultSet12.getString("job_name"));
				
				quantity.add(resultSet12.getString("quantity"));
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from job_name_master where material=?");
				preparedStatement112x.setString(1, resultSet12.getString("job_name"));
				System.out.println(preparedStatement112x);
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				if (resultSet12x.next()) {
					
					
				hsncode.add(resultSet12x.getString("hsn"));
				
				Double tax = resultSet12x.getDouble("tax");
				
				Double taxr=tax/2;
				
				
				
				rate.add(String.valueOf(taxr));
				
				
				myrate.add(resultSet12x.getString("price"));
				
				//System.out.println("<<<<"+resultSet12.getString("price"));
				
				Double myrate1=resultSet12x.getDouble("price");
				Double amt=0.0;
				try{
				 amt = resultSet12.getDouble("uv") * resultSet12x.getDouble("price");
				}catch(Exception e){
					amt=0.0;
				}
				
				myamt.add(String.valueOf(amt));
				
				Double gstamt=0.0;
				
				gstamt = amt * taxr /100;
				
				gstamt1.add(String.valueOf(gstamt));
				
				Double netamt1=amt+gstamt+gstamt;
				
				netamt.add(String.valueOf(netamt1));
				vat.add(resultSet12x.getString("tax"));
				
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamt;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamt+gstamt;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				bean1.setTotamt(""+totamt);
				
				}
				
				
				try {
					PreparedStatement pst = conn
							.prepareStatement("select * from  jobcard where job_card_id=?");
					
					pst.setString(1, eb.getDcno()[i]);
					
					System.out.println("SQL1:"+pst);
					
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()) {
						
						email.add(rs.getString("remaining_amount"));
						
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				
				
				
				gridsize++;
			}
			
			
			
			
		}
		
		System.out.println("JOBS:"+job);
		
		
		bean1.setJobs(job);
		bean1.setDcnot(dcno);
		bean1.setDescriptiont(description1);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(netamt);
		bean1.setVat(vat);
		bean1.setEmail22(email);
		
		DBConnection.closeConnection();
		return bean1;
	}

	
	
	public static Dc_bean makeReadyInvoice(Dc_bean eb,String job_card_id,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		//Connection connection = DaoHelper.getConnection();
		Connection conn=connection.getConnection();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
	//	List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from billing where job_card_id=?");
			
			preparedStatement112xx.setString(1, job_card_id);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				bean1.setCust_name(resultSet12xx.getString("client_name"));
				bean1.setCustid(resultSet12xx.getString("client_id"));
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master where client_id=?");
				preparedStatement112xx1.setString(1, resultSet12xx.getString("client_id"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("area"));
					bean1.setAddress(resultSet12xx1.getString("address"));
					
					bean1.setVendor(remain);
					
					bean1.setJob_card_id(job_card_id);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from billing where job_card_id=?");
			preparedStatement112.setString(1, job_card_id);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("job_name"));
				
				quantity.add(resultSet12.getString("quantity"));
				
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from material_master where material=?");
				preparedStatement112x.setString(1, resultSet12.getString("job_name"));
				System.out.println(preparedStatement112x);
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				if (resultSet12x.next()) {
				
					hsncode.add(resultSet12x.getString("hsn"));
				
				Double tax = resultSet12x.getDouble("tax");
				
				Double taxr=tax/2;
				
				
				
				rate.add(String.valueOf(taxr));
				
				
				myrate.add(resultSet12x.getString("price"));
				
				//System.out.println("<<<<"+resultSet12.getString("price"));
				
				Double myrate1=resultSet12x.getDouble("price");
				Double amt=0.0;
				try{
				 amt = resultSet12.getDouble("uv") * resultSet12x.getDouble("price");
				}catch(Exception e){
					amt=0.0;
				}
				
				myamt.add(String.valueOf(amt));
				
				Double gstamt=0.0;
				
				gstamt = amt * taxr /100;
				
				gstamt1.add(String.valueOf(gstamt));
				
				Double netamt1=amt+gstamt+gstamt;
				
				netamt.add(String.valueOf(netamt1));
				vat.add(resultSet12x.getString("tax"));
				
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamt;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamt+gstamt;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				bean1.setTotamt(""+totamt);
				
				}
				
				gridsize++;
			}
			
	
		bean1.setDcnot(dcno);
		bean1.setDescriptiont(description1);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(netamt);
		bean1.setVat(vat);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	public static Dc_bean makeInvoiceFromReady(Dc_bean eb,String lr,userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> batch=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
		String level="";
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from lr where LR_no=?");
			
			preparedStatement112xx.setString(1, lr);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(lr);
				
				
				
				bean1.setCustid(resultSet12xx.getString("transporter_code"));
				
						
				bean1.setVehicleno(resultSet12xx.getString("vehicle_no"));
				
				
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  transporter_master where transporter_no=?");
				
				preparedStatement112xx1.setString(1, resultSet12xx.getString("transporter_code"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("transporter_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan_no"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("transporter_address"));
					
					
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
				
			/*PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from despatch_details where order_id=? and despatch_id=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			preparedStatement112.setString(2, des);
			
			//System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				
				String ss=resultSet12.getString("scheme");
				
				String type=resultSet12.getString("unit");
				
				String product_name=resultSet12.getString("product_name");
				
				
				
				
				
				
				description1.add(resultSet12.getString("product_name"));
				
				batch.add(resultSet12.getString("batch"));
				
				
				double qty12=Double.parseDouble(resultSet12.getString("quantity"));
				
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				quantity.add(df.format(qty12));
				
					
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from price_level_details where product_name=? and name='"+level+"'");
				
				preparedStatement112x.setString(1, resultSet12.getString("product_name"));
				
				//System.out.println(preparedStatement112x);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				while (resultSet12x.next()) {
				
					hsncode.add(resultSet12x.getString("hsn"));
				
				
					
				if(ss.equals("no"))	
					
				{	
				
					double tax = resultSet12x.getDouble("tax");
				
				myrate.add(resultSet12x.getString("price"));
				
				
				double taxr = 0;
				
				try {
					taxr = tax/2;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate.add(String.valueOf(taxr));
				
				
				double k=100;
				
				double j= tax;
				
				double qty= Double.parseDouble(resultSet12.getString("quantity"));
				
				double x= k+j;
				
				double netamount = 0;
				try {
					netamount = Double.parseDouble(resultSet12x.getString("price"));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				double amount = 0;
				
				
				try {
					amount = (qty * netamount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				amount = Math.round(amount*100)/100.0d;
				
				myamt.add(String.valueOf(amount));
				
				
				
				
				
				try {
					double netamount1=(amount*tax)/ 100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				double gstamount = 0;
				try {
					gstamount = (amount * taxr)/100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gstamount = Math.round(gstamount*100)/100.0d;
				
				double rate12 = 0;
				try {
					rate12 = (amount / qty);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate12 = Math.round(rate12*100)/100.0d;
				
				
				
				gstamt2.add(String.valueOf(gstamount));
				
				vat.add(String.valueOf(tax));
				
				Double netamt1=amount+gstamount+gstamount;
				
				gstamt1.add(String.valueOf(netamt1));
				
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamount;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamount+gstamount;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				bean1.setTotamt(String.valueOf(totamt));
				
				}
				
				
				else{
					
					myrate.add("0");
					myamt.add("0");
					gstamt1.add("0");
					gstamt2.add("0");
					vat.add("0");
					
					rate.add("0");
					
				}
				
				
				}	
				gridsize++;
			
			
				
			
			}*/
			
			
			
	
		
		/*bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(gstamt2);
		bean1.setVat(vat);*/
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	
	public static Dc_bean CommonInvoiceCgst(Dc_bean eb,String lr,userinfo bean,String invoice) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> batch=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
		String level="";
		
		
		
		String order=lr;
		
		String detail[]=order.split("~");
				
	
		
		for(int i=0;i<detail.length;i++){
			
			dcno.add(detail[i]);
			
			gridsize++;
		
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from delivery_done1 where LR_no=?");
			
			preparedStatement112xx.setString(1, detail[i]);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			while (resultSet12xx.next()) {
				
				
				
				PreparedStatement ps = conn
						.prepareStatement("select * from customer_master_details where customer_name='"+resultSet12xx.getString("Customer_name")+"'");
				
				
				System.out.println("SQL:"+ps);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
				
				
					bean1.setAddress(rs.getString("customer_address"));
					bean1.setMob_no(rs.getString("mobile_no"));
					bean1.setGstn_no(rs.getString("customer_gst_no"));
					
					bean1.setCustid(rs.getString("customer_no"));
					
					bean1.setPancard_no(rs.getString("pan_no"));
					
					bean1.setState(rs.getString("state"));
					
					bean1.setCity(rs.getString("city"));
					
					
				}
				
				
				
				bean1.setName(resultSet12xx.getString("Customer_name"));
				bean1.setInquiry_id(resultSet12xx.getString("inquiry_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(resultSet12xx.getString("date")));
				
				
				
				bean1.setInvoiceno(invoice);
				
				
				
				
				
				
			}
			
			
			
			
				
			
			
			
			
		}
		bean1.setDcnot(dcno);
		bean1.setGridsize(gridsize);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	
	public static Dc_bean CommonInvoiceIgst(Dc_bean eb,String lr,userinfo bean,String invoice) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> batch=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
		String level="";
		
		
		
		String order=lr;
		
		String detail[]=order.split("~");
				
	
		
		for(int i=0;i<detail.length;i++){
			
			dcno.add(detail[i]);
			
			gridsize++;
		
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from delivery_done1 where LR_no=?");
			
			preparedStatement112xx.setString(1, detail[i]);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			while (resultSet12xx.next()) {
				
				
				
				PreparedStatement ps = conn
						.prepareStatement("select * from customer_master_details where customer_name='"+resultSet12xx.getString("Customer_name")+"'");
				
				
				System.out.println("SQL:"+ps);
				
				ResultSet rs = ps.executeQuery();
				
				if (rs.next()) {
				
				
					bean1.setAddress(rs.getString("customer_address"));
					bean1.setMob_no(rs.getString("mobile_no"));
					bean1.setGstn_no(rs.getString("customer_gst_no"));
					
					bean1.setCustid(rs.getString("customer_no"));
					
					bean1.setPancard_no(rs.getString("pan_no"));
					
					bean1.setState(rs.getString("state"));
					
					bean1.setCity(rs.getString("city"));
				}
					bean1.setName(resultSet12xx.getString("Customer_name"));
				bean1.setInquiry_id(resultSet12xx.getString("inquiry_id"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(resultSet12xx.getString("date")));
				
				bean1.setInvoiceno(invoice);
				
			}
			
		}
		bean1.setDcnot(dcno);
		bean1.setGridsize(gridsize);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	public static Dc_bean makeInvoiceFromReadyIgst(Dc_bean eb,String invoiceno,String remain, userinfo bean,String des) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> batch=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
		String level="";
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from order_table where order_id=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				bean1.setDespatch_id(des);
				
				bean1.setCustid(resultSet12xx.getString("dest_id"));
				
				
				String vv=resultSet12xx.getString("vehicle_assign_code");
				
				
				PreparedStatement pp = conn
						.prepareStatement("select * from  vehicle_assign_details where vs_id='"+vv+"'");
				
					
				ResultSet rr = pp.executeQuery();
				
				if (rr.next()) {
					
					
					bean1.setVehicleno(rr.getString("vehicle_no"));
				}
				
				
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  destributor_master where destributor_id=?");
				
				preparedStatement112xx1.setString(1, resultSet12xx.getString("dest_id"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("address"));
					
					bean1.setVendor(resultSet12xx1.getString("credit_amount"));
					
					level=resultSet12xx1.getString("price_level");
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from despatch_details where order_id=? and despatch_id=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			preparedStatement112.setString(2, des);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				
				String ss=resultSet12.getString("scheme");
				
				
				String type=resultSet12.getString("unit");
				
				String product_name=resultSet12.getString("product_name");
				
				
				
				description1.add(resultSet12.getString("product_name"));
				
				batch.add(resultSet12.getString("batch"));
				
				double qty12=Double.parseDouble(resultSet12.getString("quantity"));
				
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				quantity.add(df.format(qty12));
				
				//double amt12=Double.parseDouble(resultSet12.getString("amount"));
				
				
				//gstamt1.add(df.format(amt12));
				
				
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from price_level_details where product_name=? and name='"+level+"'");
				
				preparedStatement112x.setString(1, resultSet12.getString("product_name"));
				
				System.out.println(preparedStatement112x);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				if (resultSet12x.next()) {
				
					hsncode.add(resultSet12x.getString("hsn"));
				
				
					if(ss.equals("no"))
						
					{		
					
					double tax = resultSet12x.getDouble("tax");
				
				myrate.add(resultSet12x.getString("price"));
				
				
				double taxr = 0;
				try {
					taxr = tax;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate.add(String.valueOf(taxr));
				
				
				double k=100;
				
				double j= tax;
				
				double qty= Double.parseDouble(resultSet12.getString("quantity"));
				
				double x= k+j;
				
				double netamount = Double.parseDouble(resultSet12x.getString("price"));
				
				double amount = 0;
				
				
				try {
					amount = (qty * netamount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				amount = Math.round(amount*100)/100.0d;
				
				myamt.add(String.valueOf(amount));
				
				
				
				
				try {
					double netamount1=(amount*tax)/ 100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				double gstamount = 0;
				try {
					gstamount = (amount * taxr)/100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gstamount = Math.round(gstamount*100)/100.0d;
				
				double rate12 = 0;
				try {
					rate12 = (amount / qty);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate12 = Math.round(rate12*100)/100.0d;
				
				
				 
				//myrate.add(String.valueOf(rate12));
				
				//myamt.add(String.valueOf(amount));
				
				gstamt2.add(String.valueOf(gstamount));
				
				vat.add(String.valueOf(tax));
				
				Double netamt1=amount+gstamount;
				
				gstamt1.add(String.valueOf(netamt1));
				
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamount;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamount;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				bean1.setTotamt(String.valueOf(totamt));
				
				}
				
			
				
				else{
					
					myrate.add("0");
					myamt.add("0");
					gstamt1.add("0");
					//gstamt2.add("0");
					vat.add("0");
					
					rate.add("0");
					
				}

			}
				
				gridsize++;
			}
			
	
		
		bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(gstamt2);
		bean1.setVat(vat);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	public static Dc_bean BillView(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		List<String> batch=new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from invoice where invoice_no=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				//bean1.setOrder_id(resultSet12xx.getString("order_id"));
				
				bean1.setCustid(resultSet12xx.getString("vehicle_no"));
				
				bean1.setVehicleno(resultSet12xx.getString("vehino"));
				
				
				bean1.setSgstamt(resultSet12xx.getString("sgstamount"));
				bean1.setCgstamt(resultSet12xx.getString("cgstamount"));
				
				bean1.setTotamt(resultSet12xx.getString("total"));
				
				bean1.setFreight(resultSet12xx.getString("freight"));
				bean1.setTransport(resultSet12xx.getString("transport"));
				
				
				
				bean1.setTotal_amt(resultSet12xx.getString("totaltax"));
				
				
				
				
				//Double netamt1=amount+gstamount+gstamount;
				
				

				double ff=0;
				double tt=0;
				double tot=0;
				try {
					
					try {
						ff = Double.parseDouble(resultSet12xx.getString("freight"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tt = Double.parseDouble(resultSet12xx.getString("transport"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tot = Double.parseDouble(resultSet12xx.getString("total"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try{
					tot=tot-ff-tt;
				}catch(Exception e){
					
				}
				
				
				
				bean1.setTps(String.valueOf(tot));
				
				System.out.println("Tot::"+tot);
				
				bean1.setPono(resultSet12xx.getString("pono"));
				bean1.setPodate(resultSet12xx.getString("podate"));
				
				bean1.setDcnox(resultSet12xx.getString("dcno"));
				bean1.setDcdatex(resultSet12xx.getString("dcdate"));
				
				bean1.setTermcond(resultSet12xx.getString("termcond"));
				
				bean1.setTransport1(resultSet12xx.getString("transmode"));
				
				bean1.setContactp(resultSet12xx.getString("contactp"));
				bean1.setContactno(resultSet12xx.getString("contactpno"));
				
				bean1.setShipp(resultSet12xx.getString("shipparty"));
				bean1.setShipstate(resultSet12xx.getString("shipstate"));
				bean1.setShipadd(resultSet12xx.getString("shipadd"));
				bean1.setShipgstn(resultSet12xx.getString("shipgstn"));
				
				
				
				String vv=resultSet12xx.getString("vehicle_no");
				
					
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master_details where customer_no='"+vv+"'");
				
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("customer_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("customer_gst_no"));
					bean1.setPancard_no(resultSet12xx1.getString("pan_no"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("customer_address"));
					
					
					
					
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			int gridsize1=0;
			
			List<String> lrno=new ArrayList<String>();
			List<String> drivername=new ArrayList<String>();
			List<String> expdate=new ArrayList<String>();
			List<String> exppart=new ArrayList<String>();
			List<String> expamt=new ArrayList<String>();
			List<String> vehicleno=new ArrayList<String>();
			List<String> remark=new ArrayList<String>();

			List<String> givenby=new ArrayList<String>();
			List<String> sno=new ArrayList<String>();
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from invoice_tax_details where invoice_no=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("descrip"));
				
				batch.add(resultSet12.getString("lr_no"));
				
				vat.add(resultSet12.getString("vat_percent"));
				
				double qty12=Double.parseDouble(resultSet12.getString("qty"));
				
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				quantity.add(df.format(qty12));
				
				
				hsncode.add(resultSet12.getString("type_name"));
					
				myrate.add(resultSet12.getString("rate"));
				
				myamt.add(resultSet12.getString("amt"));
				
				rate.add(resultSet12.getString("cgstrate"));
				
				gstamt1.add(resultSet12.getString("net_amt"));
				
				gstamt2.add(resultSet12.getString("cgstamount"));
				
				disc.add(resultSet12.getString("disc"));
				discamt.add(resultSet12.getString("discamt"));
				amtwithdisc.add(resultSet12.getString("amtwithdisc"));
				
				
					
						
				gridsize++;
				
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from issue_expenses where LR_no=?");
				
				preparedStatement112x.setString(1, resultSet12.getString("lr_no"));
				
				//System.out.println("SQL:"+preparedStatement112);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				while (resultSet12x.next()) {
					
				
						lrno.add(resultSet12.getString("lr_no"));

					expdate.add(CoreData.getDateFormatAsUser(resultSet12x.getString("date")));
					
					drivername.add(resultSet12x.getString("driver_name"));
					
					exppart.add(resultSet12x.getString("exp_parti"));
					
					expamt.add(resultSet12x.getString("exp_amount"));
					
					vehicleno.add(resultSet12x.getString("vehicle_no"));
					
					givenby.add(resultSet12x.getString("given_by"));
					
					remark.add(resultSet12x.getString("remark"));
					gridsize1++;
				
				
			}
				
				
				
			}
			
			bean1.setLrno(lrno);
			bean1.setDrivername(drivername);
			bean1.setExpdate(expdate);
			bean1.setExppart1(exppart);

			bean1.setExpamt(expamt);
			bean1.setVehiclenoz(vehicleno);
			bean1.setRemark1(remark);
			bean1.setSparesize(gridsize1);


			bean1.setGivenby(givenby);
	
	
		
		bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(gstamt2);
		bean1.setVat(vat);
		bean1.setDisc2(disc);
		bean1.setDiscamt2(discamt);
		bean1.setAmtwithdisc2(amtwithdisc);
		
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	public static Dc_bean BillViewIgst(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		//Connection connection = DaoHelper.getConnection();
		
		Connection conn=connection.getConnection();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		List<String> batch=new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from invoice where invoice_no=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				//bean1.setOrder_id(resultSet12xx.getString("order_id"));
				
				bean1.setCustid(resultSet12xx.getString("vehicle_no"));
				
				bean1.setVehicleno(resultSet12xx.getString("vehino"));
				
				
				//ean1.setSgstamt(resultSet12xx.getString("sgstamount"));
				bean1.setCgstamt(resultSet12xx.getString("igstamount"));
				
				bean1.setTotamt(resultSet12xx.getString("total"));
				
				bean1.setFreight(resultSet12xx.getString("freight"));
				bean1.setTransport(resultSet12xx.getString("transport"));
				
				
				
				bean1.setTotal_amt(resultSet12xx.getString("totaltax"));
				
				
				
				
				//Double netamt1=amount+gstamount+gstamount;
				
				

				double ff=0;
				double tt=0;
				double tot=0;
				try {
					
					try {
						ff = Double.parseDouble(resultSet12xx.getString("freight"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tt = Double.parseDouble(resultSet12xx.getString("transport"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					try {
						tot = Double.parseDouble(resultSet12xx.getString("total"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try{
					tot=tot-ff-tt;
				}catch(Exception e){
					
				}
				
				
				
				bean1.setTps(String.valueOf(tot));
				
				//System.out.println("Tot::"+tot);
				
				bean1.setPono(resultSet12xx.getString("pono"));
				bean1.setPodate(resultSet12xx.getString("podate"));
				
				bean1.setDcnox(resultSet12xx.getString("dcno"));
				bean1.setDcdatex(resultSet12xx.getString("dcdate"));
				
				bean1.setTermcond(resultSet12xx.getString("termcond"));
				
				bean1.setTransport1(resultSet12xx.getString("transmode"));
				
				bean1.setContactp(resultSet12xx.getString("contactp"));
				bean1.setContactno(resultSet12xx.getString("contactpno"));
				
				bean1.setShipp(resultSet12xx.getString("shipparty"));
				bean1.setShipstate(resultSet12xx.getString("shipstate"));
				bean1.setShipadd(resultSet12xx.getString("shipadd"));
				bean1.setShipgstn(resultSet12xx.getString("shipgstn"));
				
				
				
				String vv=resultSet12xx.getString("vehicle_no");
				
					
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master_details where customer_no='"+vv+"'");
				
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("customer_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("customer_gst_no"));
					bean1.setPancard_no(resultSet12xx1.getString("pan_no"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("customer_address"));
					
					
					
					
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from invoice_tax_details where invoice_no=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("descrip"));
				
				batch.add(resultSet12.getString("lr_no"));
				
				vat.add(resultSet12.getString("vat_percent"));
				
				
				double qty12=Double.parseDouble(resultSet12.getString("qty"));
				
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				quantity.add(df.format(qty12));
				
				
				hsncode.add(resultSet12.getString("type_name"));
					
				myrate.add(resultSet12.getString("rate"));
				
				myamt.add(resultSet12.getString("amt"));
				
				rate.add(resultSet12.getString("igstrate"));
				
				gstamt1.add(resultSet12.getString("net_amt"));
				
				gstamt2.add(resultSet12.getString("igstamount"));
				
				disc.add(resultSet12.getString("disc"));
				discamt.add(resultSet12.getString("discamt"));
				amtwithdisc.add(resultSet12.getString("amtwithdisc"));
				
				
					
						
				gridsize++;
			}
			
	
		
		bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(gstamt2);
		bean1.setVat(vat);
		bean1.setDisc2(disc);
		bean1.setDiscamt2(discamt);
		bean1.setAmtwithdisc2(amtwithdisc);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	
	public static Dc_bean BillViewWithoutTax(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		List<String> batch=new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		int gridsize1=0;
		
		List<String> lrno=new ArrayList<String>();
		List<String> drivername=new ArrayList<String>();
		List<String> expdate=new ArrayList<String>();
		List<String> exppart=new ArrayList<String>();
		List<String> expamt=new ArrayList<String>();
		List<String> vehicleno=new ArrayList<String>();
		List<String> remark=new ArrayList<String>();

		List<String> givenby=new ArrayList<String>();
		List<String> sno=new ArrayList<String>();
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from invoice where invoice_no=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				//bean1.setOrder_id(resultSet12xx.getString("order_id"));
				
				bean1.setCustid(resultSet12xx.getString("vehicle_no"));
				
					
				
				bean1.setTotal(resultSet12xx.getString("total"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(resultSet12xx.getString("date")));
					
				
				bean1.setPono(resultSet12xx.getString("pono"));
				bean1.setPodate(resultSet12xx.getString("podate"));
				
				bean1.setDcnox(resultSet12xx.getString("dcno"));
				
				bean1.setLr_amt(resultSet12xx.getString("lr_amount"));
				bean1.setDcdatex(resultSet12xx.getString("dcdate"));
				
				bean1.setTermcond(resultSet12xx.getString("termconnd"));
				
				bean1.setTransport1(resultSet12xx.getString("transmode"));
				
				bean1.setContactp(resultSet12xx.getString("contactp"));
				bean1.setContactno(resultSet12xx.getString("contactpno"));
				
				bean1.setShipp(resultSet12xx.getString("shipparty"));
				bean1.setShipstate(resultSet12xx.getString("shipstate"));
				bean1.setShipadd(resultSet12xx.getString("shipadd"));
				bean1.setShipgstn(resultSet12xx.getString("shipgstn"));
				
				bean1.setDest(resultSet12xx.getString("to_add"));
				
				String vv=resultSet12xx.getString("vehicle_no");
				
					
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master_details where customer_no='"+vv+"'");
				
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("customer_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("customer_gst_no"));
					bean1.setPancard_no(resultSet12xx1.getString("pan_no"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("customer_address"));
					
					
					
					
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from invoice_tax_details where invoice_no=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("lr_no"));
				
				batch.add(resultSet12.getString("lr_date"));
				
				vat.add(resultSet12.getString("consignor"));
				
				
				quantity.add(resultSet12.getString("consignee"));
				
				
				hsncode.add(resultSet12.getString("source"));
					
				myrate.add(resultSet12.getString("manual_lr"));
				
				myamt.add(resultSet12.getString("destination"));
				
				rate.add(resultSet12.getString("weight"));
				
				gstamt1.add(resultSet12.getString("amount"));
				
				
				
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from issue_expenses where LR_no=?");
				
				preparedStatement112x.setString(1, resultSet12.getString("lr_no"));
				
				//System.out.println("SQL:"+preparedStatement112);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				while (resultSet12x.next()) {
					
				
						lrno.add(resultSet12.getString("lr_no"));

					expdate.add(CoreData.getDateFormatAsUser(resultSet12x.getString("date")));
					
					drivername.add(resultSet12x.getString("driver_name"));
					
					exppart.add(resultSet12x.getString("exp_parti"));
					
					expamt.add(resultSet12x.getString("exp_amount"));
					
					vehicleno.add(resultSet12x.getString("vehicle_no"));
					
					givenby.add(resultSet12x.getString("given_by"));
					
					remark.add(resultSet12x.getString("remark"));
					gridsize1++;
				
				
			}
				
						
						
				gridsize++;
			}
			
			
			bean1.setLrno(lrno);
			bean1.setDrivername(drivername);
			bean1.setExpdate(expdate);
			bean1.setExppart1(exppart);

			bean1.setExpamt(expamt);
			bean1.setVehiclenoz(vehicleno);
			bean1.setRemark1(remark);
			bean1.setSparesize(gridsize1);


			bean1.setGivenby(givenby);
	
		
		bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setVat(vat);
			
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	public static Dc_bean pi_BillViewWithoutTax(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		//Connection con = DaoHelper.getConnection1();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		List<String> batch=new ArrayList<String>();
		List<String> disc = new ArrayList<String>();
		List<String> discamt = new ArrayList<String>();
		List<String> amtwithdisc = new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from pi_invoice where invoice_no=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			System.out.println("SQL:"+preparedStatement112xx);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				//bean1.setOrder_id(resultSet12xx.getString("order_id"));
				
				bean1.setCustid(resultSet12xx.getString("vehicle_no"));
				
					
				
				bean1.setTotal(resultSet12xx.getString("total"));
				
				bean1.setDate(CoreData.getDateFormatAsUser(resultSet12xx.getString("date")));
					
				
				bean1.setPono(resultSet12xx.getString("pono"));
				bean1.setPodate(resultSet12xx.getString("podate"));
				
				bean1.setDcnox(resultSet12xx.getString("dcno"));
				
				bean1.setLr_amt(resultSet12xx.getString("lr_amount"));
				bean1.setDcdatex(resultSet12xx.getString("dcdate"));
				
				bean1.setTermcond(resultSet12xx.getString("termcond"));
				
				bean1.setTransport1(resultSet12xx.getString("transmode"));
				
				bean1.setContactp(resultSet12xx.getString("contactp"));
				bean1.setContactno(resultSet12xx.getString("contactpno"));
				
				bean1.setShipp(resultSet12xx.getString("shipparty"));
				bean1.setShipstate(resultSet12xx.getString("shipstate"));
				bean1.setShipadd(resultSet12xx.getString("shipadd"));
				bean1.setShipgstn(resultSet12xx.getString("shipgstn"));
				
				bean1.setDest(resultSet12xx.getString("to_add"));
				
				String vv=resultSet12xx.getString("vehicle_no");
				
					
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master_details where customer_no='"+vv+"'");
				
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("customer_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("customer_gst_no"));
					bean1.setPancard_no(resultSet12xx1.getString("pan_no"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("customer_address"));
					
					
					
					
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from PI_invoice_tax_details where invoice_no=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("lr_no"));
				
				batch.add(resultSet12.getString("lr_date"));
				
				vat.add(resultSet12.getString("consignor"));
				
				
				quantity.add(resultSet12.getString("consignee"));
				
				
				hsncode.add(resultSet12.getString("source"));
					
				myrate.add(resultSet12.getString("manual_lr"));
				
				myamt.add(resultSet12.getString("destination"));
				
				rate.add(resultSet12.getString("weight"));
				
				gstamt1.add(resultSet12.getString("amount"));
				
						
						
				gridsize++;
			}
			
	
		
		bean1.setDescriptiont(description1);
		bean1.setBatcht(batch);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setVat(vat);
			
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	
	
	public static Dc_bean makeInvoiceFromReady1(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		//Connection connection = DaoHelper.getConnection();
		
		Connection conn=connection.getConnection();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		List<String> hsncode=new ArrayList<String>();
		List<String> rate=new ArrayList<String>();
		List<String> myrate=new ArrayList<String>();
		List<String> gstamt1=new ArrayList<String>();
		List<String> gstamt2=new ArrayList<String>();
		List<String> netamt=new ArrayList<String>();
		List<String> myamt=new ArrayList<String>();
		
		List<String> vat=new ArrayList<String>();
		
		List<String> taxqamount=new ArrayList<String>();
		double totamt=0.0;
		double cgstamt=0.0;
		double sgstamt=0.0;
		double tottax=0.0;
		List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from order_table where order_id=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
				
				bean1.setInvoice(invoiceno);
				
				bean1.setCustid(resultSet12xx.getString("dest_id"));
				
				
				String vv=resultSet12xx.getString("vehicle_assign_code");
				
				
				PreparedStatement pp = conn
						.prepareStatement("select * from  vehicle_assign_details where vs_id='"+vv+"'");
				
					
				ResultSet rr = pp.executeQuery();
				
				if (rr.next()) {
					
					
					bean1.setVehicleno(rr.getString("vehicle_no"));
				}
				
				
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  destributor_master where destributor_id=?");
				
				preparedStatement112xx1.setString(1, resultSet12xx.getString("dest_id"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setCust_name(resultSet12xx1.getString("name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("city"));
					bean1.setAddress(resultSet12xx1.getString("address"));
					
					bean1.setVendor(resultSet12xx1.getString("credit_amount"));
					
					//bean1.setJob_card_id(invoiceno);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from order_details where order_id=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			System.out.println("SQL::"+preparedStatement112);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				//dcno.add(job_card_id);
				
				description1.add(resultSet12.getString("product_name"));
				
				
				double qty12=Double.parseDouble(resultSet12.getString("quantity"));
				
				
				DecimalFormat df = new DecimalFormat("###.#");
				
				quantity.add(df.format(qty12));
				
				//double amt12=Double.parseDouble(resultSet12.getString("amount"));
				
				
				//gstamt1.add(df.format(amt12));
				
				
				PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from bag_config_master where bag_name=?");
				
				preparedStatement112x.setString(1, resultSet12.getString("product_name"));
				
				System.out.println(preparedStatement112x);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				if (resultSet12x.next()) {
				
					hsncode.add(resultSet12x.getString("hsn"));
				
				double tax = resultSet12x.getDouble("tax");
				
				myrate.add(resultSet12x.getString("price"));
				
				
				double taxr = 0;
				try {
					taxr = tax;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate.add(String.valueOf(taxr));
				
				
				double k=100;
				
				double j= tax;
				
				double qty= Double.parseDouble(resultSet12.getString("quantity"));
				
				double x= k+j;
				
				double netamount = Double.parseDouble(resultSet12x.getString("price"));
				
				double amount = 0;
				
				
				try {
					amount = (qty * netamount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				amount = Math.round(amount*100)/100.0d;
				
				myamt.add(String.valueOf(amount));
				
				
				/*try {
					netamount = Double.parseDouble(remain);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				
				/*try {
					amount = (netamount / x)*100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				 
				
				
				
				//System.out.println("Amount::"+amount);
				
				
				try {
					double netamount1=(amount*tax)/ 100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				double gstamount = 0;
				try {
					gstamount = (amount * taxr)/100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gstamount = Math.round(gstamount*100)/100.0d;
				
				double rate12 = 0;
				try {
					rate12 = (amount / qty);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate12 = Math.round(rate12*100)/100.0d;
				
				
				 
				//myrate.add(String.valueOf(rate12));
				
				//myamt.add(String.valueOf(amount));
				
				gstamt2.add(String.valueOf(gstamount));
				
				vat.add(String.valueOf(tax));
				
				Double netamt1=amount+gstamount+gstamount;
				
				gstamt1.add(String.valueOf(netamt1));
				
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamount;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamount+gstamount;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				bean1.setTotamt(String.valueOf(totamt));
				
				}
				
				
				/*PreparedStatement preparedStatement112x = conn
						.prepareStatement("select * from bag_config_master where bag_name=?");
				
				preparedStatement112x.setString(1, resultSet12.getString("product_name"));
				
				System.out.println(preparedStatement112x);
				
				ResultSet resultSet12x = preparedStatement112x.executeQuery();
				
				if (resultSet12x.next()) {
				
					hsncode.add(resultSet12x.getString("hsn"));
				
				double tax = resultSet12x.getDouble("tax");
				
			
				double taxr = 0;
				try {
					taxr = tax/2;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				
				
				rate.add(String.valueOf(taxr));
				
				
				double k=100;
				
				double j= tax;
				
				double qty= Double.parseDouble(resultSet12.getString("quantity")) ;;
				
				double x= k+j;
				
				double netamount = 0;
				try {
					netamount = Double.parseDouble(remain);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				double amount = 0;
				try {
					amount = (netamount / x)*100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				amount = Math.round(amount*100)/100.0d;
				
				//System.out.println("Amount::"+amount);
				
				
				try {
					double netamount1=(amount*tax)/ 100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				double gstamount = 0;
				try {
					gstamount = (amount * taxr)/100;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				gstamount = Math.round(gstamount*100)/100.0d;
				
				double rate12 = 0;
				try {
					rate12 = (amount / qty);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				rate12 = Math.round(rate12*100)/100.0d;
				
				
				 
				myrate.add(String.valueOf(rate12));
				
				myamt.add(String.valueOf(amount));
				
				gstamt2.add(String.valueOf(gstamount));
				
				vat.add(String.valueOf(tax));
				
				Double netamt1=amount+gstamount+gstamount;
				
				try{
					totamt=totamt+netamt1;
				}catch(Exception e){
					
				}
				
				try{
					cgstamt=cgstamt+gstamount;
				}catch(Exception e){
					
				}
				
				
				try{
					tottax=tottax+gstamount+gstamount;
				}catch(Exception e){
					
				}
				bean1.setSgstamt(""+tottax);
				bean1.setCgstamt(""+cgstamt);
				
				
				
				
				}*/
				
					
				
				gridsize++;
			}
			
	
		
		bean1.setDescriptiont(description1);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setRate(rate);
		bean1.setHsncode(hsncode);
		bean1.setMyrate(myrate);
		bean1.setMyamt(myamt);
		bean1.setGstamt1(gstamt1);
		bean1.setNetamt(gstamt2);
		bean1.setVat(vat);
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	public static Dc_bean makeReadyInvoiceView(Dc_bean eb,String invoiceno,String remain, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		Dc_bean  bean1 = new Dc_bean();
		
		Connection conn=connection.getConnection();
		
		List<String> description1=new ArrayList<String>();
		List<String> dcno=new ArrayList<String>();
		List<String> quantity=new ArrayList<String>();
		
		List<String> gstamt1=new ArrayList<String>();
		
	//	List<String> unit=new ArrayList<String>();
		int gridsize=0;
		
				
			//System.out.println(eb.getDcno()[i]);
		
			PreparedStatement preparedStatement112xx = conn
					.prepareStatement("select * from ready_invoice where invoice_no=?");
			
			preparedStatement112xx.setString(1, invoiceno);
			
			ResultSet resultSet12xx = preparedStatement112xx.executeQuery();
			
			if (resultSet12xx.next()) {
				
		
				bean1.setCustid(resultSet12xx.getString("vehicle_no"));
				
				bean1.setPo(resultSet12xx.getString("pono"));
				
				bean1.setPodate(CoreData.getDateFormatAsUser(resultSet12xx.getString("podate")));
				
				bean1.setInvoice(invoiceno);
				
				bean1.setDc(resultSet12xx.getString("dcno"));
				
				bean1.setDcdate(CoreData.getDateFormatAsUser(resultSet12xx.getString("dcdate")));
				
				bean1.setTps(resultSet12xx.getString("transmode"));
				
				bean1.setContactp(resultSet12xx.getString("contactp"));
				
				bean1.setContactno(resultSet12xx.getString("contactpno"));
				
				bean1.setVehicleno(resultSet12xx.getString("vehino"));
				
				
				bean1.setShipp(resultSet12xx.getString("shipparty"));
				
				bean1.setShipadd(resultSet12xx.getString("shipadd"));
				
				bean1.setShipgstn(resultSet12xx.getString("shipgstn"));
				
				bean1.setShipstate(resultSet12xx.getString("shipstate"));
				
				bean1.setFreight(resultSet12xx.getString("freight"));
				
				bean1.setTransport(resultSet12xx.getString("transport"));
				
				bean1.setTotal_amt(resultSet12xx.getString("total"));
				
				bean1.setJob_card_id(resultSet12xx.getString("job_card_id"));
				
				
				
				double tot = 0;
				
				try {
					tot = Double.parseDouble(resultSet12xx.getString("total"));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				double fre = 0;
				try {
					fre = Double.parseDouble(resultSet12xx.getString("freight"));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				double trans = 0;
				try {
					trans = Double.parseDouble(resultSet12xx.getString("transport"));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				double other = 0;
				try {
					other = fre+trans;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				try {
					tot = tot-other;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				bean1.setTotal(String.valueOf(tot));
				
				
			
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master where client_id=?");
				
				preparedStatement112xx1.setString(1, resultSet12xx.getString("vehicle_no"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					bean1.setCust_name(resultSet12xx1.getString("client_name"));
					bean1.setMob_no(resultSet12xx1.getString("mobile_no"));
					bean1.setGstn_no(resultSet12xx1.getString("gstn"));
					bean1.setPancard_no(resultSet12xx1.getString("pan"));
					
					
					bean1.setState(resultSet12xx1.getString("state"));
					bean1.setCity(resultSet12xx1.getString("area"));
					bean1.setAddress(resultSet12xx1.getString("address"));
					
					bean1.setVendor(remain);
					
				}
				
				
				
			}
			
			
			PreparedStatement preparedStatement112 = conn
					.prepareStatement("select * from ready_invoice_tax_details where invoice_no=?");
			
			preparedStatement112.setString(1, invoiceno);
			
			ResultSet resultSet12 = preparedStatement112.executeQuery();
			
			while (resultSet12.next()) {
				
				dcno.add(invoiceno);
				
				description1.add(resultSet12.getString("descrip"));
				
				quantity.add(resultSet12.getString("qty"));
				
				gstamt1.add(resultSet12.getString("amt"));
				
				
				

				gridsize++;
			}
			
	
		bean1.setDcnot(dcno);
		bean1.setDescriptiont(description1);
		bean1.setGridsize(gridsize);
		bean1.setQuantity(quantity);
		bean1.setGstamt1(gstamt1);
		
		
		DBConnection.closeConnection();
		return bean1;
	}
	
	
	
	
	
	
	
	
	
	public Dc_bean Print44(String dc_id, userinfo bean2) throws SQLException {
		//Connection con = DaoHelper.getConnection();
		
		Connection conn=connection.getConnection();
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		Dc_bean bean = new Dc_bean();
		List<String> description122 = new ArrayList<String>();
		
		List<String> qty122 = new ArrayList<String>();
		
		List<String> price = new ArrayList<String>();
	
		
						
					PreparedStatement pst1 = conn
					.prepareStatement("select  * from dc  where Dc_id=?"); 
					pst1.setString(1,dc_id);
					System.out.println("pst8888....."+pst1);

					ResultSet rs11 = pst1.executeQuery();
					while (rs11.next()) {
						//	bean = new Area_Master_Bean();
						bean.setCust_name(rs11.getString("cust_name"));
						bean.setCust_address(rs11.getString("cust_address"));
						bean.setDate(rs11.getString("date"));
						bean.setCustid(rs11.getString("custid"));
						bean.setGstn_no(rs11.getString("gstn_no"));
						bean.setPancard_no(rs11.getString("pancard_no"));
						bean.setEmail(rs11.getString("email"));
						bean.setMob_no(rs11.getString("mob_no"));
						bean.setDc_id(rs11.getString("Dc_id"));
						bean.setCno(rs11.getString("cno"));
						bean.setCdate(rs11.getString("cdate"));
						
						PreparedStatement pst122 = conn
						.prepareStatement("select description,qty,price from dc_details  where Dc_id=?");
						
						pst122.setString(1,dc_id);
						
				System.out.println("pst122......." + pst122);
				String btype = "";
				
				ResultSet rs122 = pst122.executeQuery();
				int k=0;
				int mysize=0;
				while (rs122.next()) {
				
					
					description122.add(rs122.getString("description"));
					qty122.add(rs122.getString("qty"));
					price.add(rs122.getString("price"));
					/*for (int i = 0; i < description122.size(); i++) {
					*/	
				
						bean.setDescription122(description122);
						
						bean.setQty122(qty122);	
					
						
						bean.setNn(price);
					//}
					mysize++;
				k++;

						
						
				}
				bean.setMysize(mysize);	
							
				bean.setDc_id(dc_id);		
					bean.setGridsize(k);	
						
						
						
						}

		
					DBConnection.closeConnection();
					return bean;
					
					
	}

	
	
	
	public Dc_bean DcReceiveEdit(String dc_id, userinfo bean2) throws SQLException {
		
		
		Connection conn=connection.getConnection();
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		Dc_bean bean = new Dc_bean();
		List<String> description122 = new ArrayList<String>();
		
		List<String> qty122 = new ArrayList<String>();
		
		List<String> price = new ArrayList<String>();
	
		
						
					PreparedStatement pst1 = conn
					.prepareStatement("select  * from receivedc  where Dc_id=?"); 
					pst1.setString(1,dc_id);
					System.out.println("pst8888....."+pst1);

					ResultSet rs11 = pst1.executeQuery();
					while (rs11.next()) {
						//	bean = new Area_Master_Bean();
						bean.setCust_name(rs11.getString("cust_name"));
						bean.setCust_address(rs11.getString("cust_address"));
						bean.setDate(rs11.getString("date"));
						bean.setCustid(rs11.getString("custid"));
						bean.setGstn_no(rs11.getString("gstn_no"));
						bean.setPancard_no(rs11.getString("pancard_no"));
						bean.setEmail(rs11.getString("email"));
						bean.setMob_no(rs11.getString("mob_no"));
						bean.setDc_id(rs11.getString("Dc_id"));
						bean.setCno(rs11.getString("cno"));
						bean.setCdate(rs11.getString("cdate"));
						bean.setPono(rs11.getString("pono"));
						
						
						PreparedStatement pst122 = conn
						.prepareStatement("select description,qty,price from receive_dc_details  where Dc_id=?");
						
						pst122.setString(1,dc_id);
						
				System.out.println("pst122......." + pst122);
				String btype = "";
				
				ResultSet rs122 = pst122.executeQuery();
				int k=0;
				int mysize=0;
				while (rs122.next()) {
				
					
					description122.add(rs122.getString("description"));
					qty122.add(rs122.getString("qty"));
					price.add(rs122.getString("price"));
					/*for (int i = 0; i < description122.size(); i++) {
					*/	
				
						bean.setDescription122(description122);
						
						bean.setQty122(qty122);	
					
						
						bean.setNn(price);
					//}
					mysize++;
				k++;

						
						
				}
				bean.setMysize(mysize);	
							
				bean.setDc_id(dc_id);		
					bean.setGridsize(k);	
						
						
						
						}

		
					DBConnection.closeConnection();
					return bean;
					
					
	}
	
	
	
	
	
	
	
	public Dc_bean DCOwSrcEdit(String dc_id, userinfo bean2) throws SQLException {
		
		
		Connection conn=connection.getConnection();
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		Dc_bean bean = new Dc_bean();
		List<String> description122 = new ArrayList<String>();
		
		List<String> qty122 = new ArrayList<String>();
		
		List<String> price = new ArrayList<String>();
		List<String> rqty = new ArrayList<String>();
		
						
					PreparedStatement pst1 = conn
					.prepareStatement("select  * from outsrcdc  where Dc_id=?"); 
					pst1.setString(1,dc_id);
					System.out.println("pst8888....."+pst1);

					ResultSet rs11 = pst1.executeQuery();
					while (rs11.next()) {
						//	bean = new Area_Master_Bean();
						bean.setCust_name(rs11.getString("cust_name"));
						bean.setCust_address(rs11.getString("cust_address"));
						bean.setDate(rs11.getString("date"));
						bean.setCustid(rs11.getString("custid"));
						bean.setGstn_no(rs11.getString("gstn_no"));
						bean.setPancard_no(rs11.getString("pancard_no"));
						bean.setEmail(rs11.getString("email"));
						bean.setMob_no(rs11.getString("mob_no"));
						bean.setDc_id(rs11.getString("Dc_id"));
						bean.setCno(rs11.getString("cno"));
						bean.setCdate(rs11.getString("cdate"));
						bean.setPono(rs11.getString("pono"));
						
						
						PreparedStatement pst122 = conn
						.prepareStatement("select description,qty,price,remainingqty from outsrc_dc_details  where Dc_id=?");
						
						pst122.setString(1,dc_id);
						
				System.out.println("pst122......." + pst122);
				String btype = "";
				
				ResultSet rs122 = pst122.executeQuery();
				int k=0;
				int mysize=0;
				while (rs122.next()) {
				
					
					description122.add(rs122.getString("description"));
					qty122.add(rs122.getString("qty"));
					price.add(rs122.getString("price"));
					rqty.add(rs122.getString("remainingqty"));
					
						bean.setDescription122(description122);
						
						bean.setQty122(qty122);	
						bean.setQtyremain(rqty);
						
						bean.setNn(price);
					//}
					mysize++;
				k++;

						
						
				}
				bean.setMysize(mysize);	
							
				bean.setDc_id(dc_id);		
					bean.setGridsize(k);	
						
						
						
						}

					DBConnection.closeConnection();
			
					return bean;
					
					
	}
	
	
	
	public static String update(Dc_bean eb, userinfo bean) {
		// TODO Auto-generated method stub
		String response = "";
		
		Connection conn=connection.getConnection();
		
		try {
		
		String Scode = "";
		String Scode1="";
			
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("Update dc set cust_name=?, mob_no=?, cust_address=?,pancard_no=?,email=?,gstn_no=?,custid=?,date=?,cno=?,cdate=?,username='"+bean.getUsername()+"',datetime='"+SystemDateTime.CurrentDateTime()+"' where Dc_id=? ");
				
				
				pst.setString(1, eb.getCust_name());
				pst.setString(2, eb.getMob_no());
				pst.setString(3, eb.getCust_address());
				pst.setString(4, eb.getPancard_no());
				pst.setString(5, eb.getEmail());
				pst.setString(6, eb.getGstn_no());
				pst.setString(7, eb.getCustid());
				
				pst.setString(8, eb.getDate());
			
				pst.setString(9, eb.getCno());
				pst.setString(10, eb.getCdate());
				pst.setString(11, eb.getDc_id());
				
				
				
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
				String qd = "delete  from dc_details where Dc_id=?";
				
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, eb.getDc_id());

				int n1 = pstdel.executeUpdate();

				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
					
					PreparedStatement pst2 = conn
							.prepareStatement("insert into dc_details(Dc_id,description,qty,price,username,datetime) values(?,?,?,?,?,?) ");
					
					pst2.setString(1, eb.getDc_id());	
					pst2.setString(2, eb.getDescription()[k]);
					pst2.setString(3, eb.getQty()[k]);
					pst2.setString(4, eb.getPrice()[k]);
					pst2.setString(5, bean.getUsername());
					pst2.setString(6, SystemDateTime.CurrentDateTime());
					
					System.out.println("Sql2:..........."+pst2);
					pst2.executeUpdate();
					
				}
				response="success";
	}catch (Exception e) {

		response = "";
	}
		}catch (Exception e) {

		response = "";
	}
		
		DBConnection.closeConnection();
		return response;
	}

	
	
	
	
	
	
	public static String Dc_submitupdate_Receive(Dc_bean eb, userinfo bean) {
		// TODO Auto-generated method stub
		String response = "";
		
		Connection conn=connection.getConnection();
		
		try {
		
		String Scode = "";
		String Scode1="";
			
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("Update receivedc set cust_name=?, mob_no=?, cust_address=?,pancard_no=?,email=?,gstn_no=?,custid=?,date=?,cno=?,cdate=? where Dc_id=? ");
				
				
				pst.setString(1, eb.getCust_name());
				pst.setString(2, eb.getMob_no());
				pst.setString(3, eb.getCust_address());
				pst.setString(4, eb.getPancard_no());
				pst.setString(5, eb.getEmail());
				pst.setString(6, eb.getGstn_no());
				pst.setString(7, eb.getCustid());
				
				pst.setString(8, eb.getDate());
			
				pst.setString(9, eb.getCno());
				pst.setString(10, eb.getCdate());
				pst.setString(11, eb.getDc_id());
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
			
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
				
				PreparedStatement pp = conn
						.prepareStatement("select dcqty,descrip from purchase_order_details where invoice_no='"+eb.getPono()+"' and descrip='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp);
				ResultSet rst = pp.executeQuery();
			
				while (rst.next()) {
					
				String desc=eb.getDescription()[k];
				String qty=rst.getString("dcqty");
				
				
				
				PreparedStatement pp1 = conn
						.prepareStatement("select description,qty from receive_dc_details where Dc_id='"+eb.getDc_id()+"' and description='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp);
				ResultSet rst1 = pp1.executeQuery();
			
				while (rst1.next()) {
					
				String desc1=eb.getDescription()[k];
				String qty11=rst1.getString("qty");
				
						
				Double qty2=Double.parseDouble(qty)+Double.parseDouble(qty11);
				
				
				
				
			
			
				System.out.println("QUantity:"+qty2);
				
				String q11 = "update purchase_order_details set  dcqty='"+qty2+"' where descrip='"+eb.getDescription()[k]+"' and invoice_no='"+eb.getPono()+"'";
		       	PreparedStatement ps1 = conn.prepareStatement(q11);	
		       	
		       	
		     System.out.println("Sql12::"+ps1);
		    	
		       	ps1.executeUpdate();
				
				}
				
				}}
				
				
				
				
				
				
				String qd = "delete  from receive_dc_details where Dc_id=?";
				
				PreparedStatement pstdel = conn.prepareStatement(qd);
				pstdel.setString(1, eb.getDc_id());

				int n1 = pstdel.executeUpdate();

				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
					
					PreparedStatement pst2 = conn
							.prepareStatement("insert into receive_dc_details(Dc_id,description,qty,price,pono,cno) values(?,?,?,?,?,?) ");
					
					pst2.setString(1, eb.getDc_id());	
					pst2.setString(2, eb.getDescription()[k]);
					pst2.setString(3, eb.getQty()[k]);
					pst2.setString(4, eb.getPrice()[k]);
					pst2.setString(5, eb.getPono());
					pst2.setString(6, eb.getCno());
					System.out.println("Sql2:..........."+pst2);
					pst2.executeUpdate();
					
				}
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
				
				PreparedStatement pp = conn
						.prepareStatement("select dcqty,descrip from purchase_order_details where invoice_no='"+eb.getPono()+"' and descrip='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp);
				ResultSet rst = pp.executeQuery();
			
				while (rst.next()) {
					
				String desc=eb.getDescription()[k];
				String qty=rst.getString("dcqty");
				
				String qty1=eb.getQty()[k];
					
				Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);
				
				System.out.println("QUantity:"+qty2);
				
				String q11 = "update purchase_order_details set   dcqty='"+qty2+"' where descrip='"+eb.getDescription()[k]+"' and invoice_no='"+eb.getPono()+"'";
		       	PreparedStatement ps1 = conn.prepareStatement(q11);	
		       	
		       	
		     System.out.println("Sql12::"+ps1);
		    	
		       	ps1.executeUpdate();
				
				}
				
				}
				
				
				
				response="success";
	}catch (Exception e) {

		response = "";
	}
		}catch (Exception e) {

		response = "";
	}
		
		DBConnection.closeConnection();
		return response;
	}

	
	
	
	
	
	
	public static String Dc_submitupdate_OutSrc(Dc_bean eb, userinfo bean) {
		// TODO Auto-generated method stub
		String response = "";
		
		Connection conn=connection.getConnection();
			
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("Update outsrcdc set cust_name=?, mob_no=?, cust_address=?,pancard_no=?,email=?,gstn_no=?,custid=?,date=?,cno=?,cdate=? where Dc_id=? ");
				
				
				pst.setString(1, eb.getCust_name());
				pst.setString(2, eb.getMob_no());
				pst.setString(3, eb.getCust_address());
				pst.setString(4, eb.getPancard_no());
				pst.setString(5, eb.getEmail());
				pst.setString(6, eb.getGstn_no());
				pst.setString(7, eb.getCustid());
				
				pst.setString(8, eb.getDate());
			
				pst.setString(9, eb.getCno());
				pst.setString(10, eb.getCdate());
				pst.setString(11, eb.getDc_id());
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
			
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
						
				
				PreparedStatement pp1 = conn
						.prepareStatement("select description,remainingqty from outsrc_dc_details where Dc_id='"+eb.getDc_id()+"' and description='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp1);
				ResultSet rst1 = pp1.executeQuery();
			
				while (rst1.next()) {
					
				String desc1=eb.getDescription()[k];
				String qty11=rst1.getString("remainingqty");
				
				String qty=eb.getReqty()[k];
				
						
				Double qty2=Double.parseDouble(qty11)-Double.parseDouble(qty);
				
			
				System.out.println("QUantity:"+qty2);
				
				String q11 = "update outsrc_dc_details set  remainingqty='"+qty2+"' where description='"+eb.getDescription()[k]+"' and Dc_id='"+eb.getDc_id()+"'";
		       	PreparedStatement ps1 = conn.prepareStatement(q11);	
		       	
		       	
		     System.out.println("Sql12::"+ps1);
		    	
		       	ps1.executeUpdate();
				
				}}
				
			
				
				
				response="success";
	
		}catch (Exception e) {

		response = "";
	}
		
		DBConnection.closeConnection();
		return response;
	}

	

	public static String cancel(String dc_id, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		String response = "";

		Connection conn=connection.getConnection();
		
		String qd = "update   dc set status='1' where Dc_id=?";
		
		PreparedStatement pstdel = conn.prepareStatement(qd);
		pstdel.setString(1, dc_id);
		System.out.println(pstdel);
		int n1 = pstdel.executeUpdate();
		response = "success";
		
		DBConnection.closeConnection();
		return response;
		
	}
	
	
	
	public static String DCReceivecancel(String dc_id, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		String response = "";

		Connection conn=connection.getConnection();
		
		String qd = "update   receivedc set status='1' where Dc_id=?";
		
		PreparedStatement pstdel = conn.prepareStatement(qd);
		pstdel.setString(1, dc_id);
		System.out.println(pstdel);
		int n1 = pstdel.executeUpdate();
		response = "success";
		
		DBConnection.closeConnection();
		return response;
		
	}
	
	
	public static String DCOwSrccancel(String dc_id, userinfo bean) throws SQLException {
		// TODO Auto-generated method stub
		String response = "";

		Connection conn=connection.getConnection();
		
		String qd = "update  outsrcdc set status='1' where Dc_id=?";
		
		PreparedStatement pstdel = conn.prepareStatement(qd);
		pstdel.setString(1, dc_id);
		System.out.println(pstdel);
		int n1 = pstdel.executeUpdate();
		response = "success";
		
		DBConnection.closeConnection();
		return response;
		
	}
	
	public List<Dc_bean> dcreport(userinfo bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=connection.getConnection();
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		PreparedStatement preparedStatement1 = conn
		.prepareStatement("select * from dc where status='0' ");
// purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement1 " + preparedStatement1);

// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs112 = preparedStatement1.executeQuery();

			while (rs112.next()) {
	
	
				Dc_bean  bean;
		
		
			bean = new Dc_bean();
			
			bean.setCustid(rs112.getString("custid"));
			
			bean.setDc_id(rs112.getString("Dc_id"));
			bean.setCust_name(rs112.getString("cust_name"));
			bean.setMob_no(rs112.getString("mob_no"));
			bean.setCust_address(rs112.getString("cust_address"));
			bean.setPancard_no(rs112.getString("pancard_no"));
			bean.setEmail(rs112.getString("email"));
			bean.setGstn_no(rs112.getString("gstn_no"));
					
			report.add(bean);
			} 
			

			DBConnection.closeConnection();
		
		return report;
		
	}
	
	
	
	public List<Dc_bean> DcReveiveReoprt(userinfo bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=connection.getConnection();
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		PreparedStatement preparedStatement1 = conn
		.prepareStatement("select * from receivedc where status='0' ");
// purchase_bean bean = new purchase_bean();
		System.out.println("preparedStatement1 " + preparedStatement1);

// System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs112 = preparedStatement1.executeQuery();

			while (rs112.next()) {
	
	
				Dc_bean  bean;
		
		
			bean = new Dc_bean();
			
			bean.setCustid(rs112.getString("custid"));
			
			bean.setDc_id(rs112.getString("Dc_id"));
			bean.setCust_name(rs112.getString("cust_name"));
			bean.setMob_no(rs112.getString("mob_no"));
			bean.setCust_address(rs112.getString("cust_address"));
			bean.setPancard_no(rs112.getString("pancard_no"));
			bean.setEmail(rs112.getString("email"));
			bean.setGstn_no(rs112.getString("gstn_no"));
			bean.setPono(rs112.getString("pono"));
					
			report.add(bean);
			} 
			

			DBConnection.closeConnection();
		
		return report;
		
	}
	
	
	
	
	public List<Dc_bean> DcOutSrcReoprt(userinfo bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		
		Connection conn=connection.getConnection();
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		PreparedStatement preparedStatement1 = conn
		.prepareStatement("select * from outsrcdc where status='0' ");
		
		System.out.println("preparedStatement1 " + preparedStatement1);

		ResultSet rs112 = preparedStatement1.executeQuery();

			while (rs112.next()) {

				Dc_bean  bean;
			
			bean = new Dc_bean();
			
			bean.setCustid(rs112.getString("custid"));
			
			bean.setDc_id(rs112.getString("Dc_id"));
			bean.setCust_name(rs112.getString("cust_name"));
			bean.setMob_no(rs112.getString("mob_no"));
			bean.setCust_address(rs112.getString("cust_address"));
			bean.setPancard_no(rs112.getString("pancard_no"));
			bean.setEmail(rs112.getString("email"));
			bean.setGstn_no(rs112.getString("gstn_no"));
			bean.setPono(rs112.getString("pono"));
					
			report.add(bean);
			} 
			

			DBConnection.closeConnection();
		
		return report;
		
	}
	
	
	
	public List<Dc_bean> poreport(userinfo bean2) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=connection.getConnection();
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		PreparedStatement preparedStatement1 = conn
		.prepareStatement("select * from purchase_order  ");
		ResultSet rs112 = preparedStatement1.executeQuery();

			while (rs112.next()) {
	
	
				Dc_bean  bean;
		
		
			bean = new Dc_bean();
			
			bean.setCustid(rs112.getString("vehicle_no"));
			
			bean.setDc_id(rs112.getString("invoice_no"));
			
			PreparedStatement preparedStatement1x = conn
					.prepareStatement("select * from customer_master where cust_id='"+rs112.getString("vehicle_no")+"'  ");
					ResultSet rs112x = preparedStatement1x.executeQuery();
						if (rs112x.next()) {
							bean.setCust_name(rs112x.getString("cust_name"));
						}
			
			
		
					
			report.add(bean);
			} 
			

			DBConnection.closeConnection();
		
		return report;
		
	}
	
	
	public Dc_bean MakeDc(String dc_id, userinfo bean2) throws SQLException {
		
		Connection conn=connection.getConnection();
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		int j1=0;
		int j9=0;
		
		String	stringValue1="";
		Dc_bean bean = new Dc_bean();
		List<String> description122 = new ArrayList<String>();
		
		List<String> qty122 = new ArrayList<String>();
		List<String> remainqty = new ArrayList<String>();
		List<String> dcqty = new ArrayList<String>();
		
		
						
					PreparedStatement pst1 = conn
					.prepareStatement("select * from purchase_order  where invoice_no=?"); 
					pst1.setString(1,dc_id);
					System.out.println("pst8888....."+pst1);

					ResultSet rs11 = pst1.executeQuery();
					while (rs11.next()) {
						//	bean = new Area_Master_Bean();
						bean.setCustid(rs11.getString("vehicle_no"));
						
						bean.setDc_id(rs11.getString("invoice_no"));
					//	bean.setCust_name(rs11.getString("name"));
						
						
						PreparedStatement preparedStatement1x = conn
								.prepareStatement("select * from customer_master where cust_id='"+rs11.getString("vehicle_no")+"'  ");
								ResultSet rs112x = preparedStatement1x.executeQuery();
									if (rs112x.next()) {
										bean.setCust_name(rs112x.getString("cust_name"));
										bean.setCust_address(rs112x.getString("cust_address"));
										bean.setMob_no(rs112x.getString("mobile_no"));
										bean.setGstn_no(rs112x.getString("company_vat"));
										bean.setPancard_no(rs112x.getString("vehicle_no"));
										bean.setEmail(rs112x.getString("chasis_no"));
									}
						
						
						PreparedStatement pst122 = conn
						.prepareStatement("select * from purchase_order_details  where invoice_no=?");
						
						pst122.setString(1,dc_id);
						
				System.out.println("pst122......." + pst122);
				String btype = "";
				
				ResultSet rs122 = pst122.executeQuery();
				int k=0;
				int mysize=0;
				while (rs122.next()) {
				
					
					description122.add(rs122.getString("descrip"));
					qty122.add(rs122.getString("qty"));
					
					remainqty.add(rs122.getString("qtyremaining"));
					dcqty.add(rs122.getString("dcqty"));
					
					/*for (int i = 0; i < description122.size(); i++) {
					*/	
				
						bean.setDescription122(description122);
						
						bean.setQty122(qty122);	
						bean.setQtyremain(remainqty);	
						bean.setDcqty(dcqty);	
					
						
						
					//}
					mysize++;
				k++;

						
						
				}
				bean.setMysize(mysize);	
							
				bean.setDc_id(dc_id);		
					bean.setGridsize(k);	
						
						
						
						}

		
					DBConnection.closeConnection();
					return bean;
					
					
	}
	
	
	
	
	public static String insertreceive(Dc_bean eb, userinfo bean) {
		
		
		String response = "";
		
		Connection conn=connection.getConnection();
		
		try {
		
		String Scode = "";
		String Scode1="";
		//Connection conn=DaoHelper.getConnection();
	
		try {
			
			PreparedStatement preparedStatementx = conn.prepareStatement("select  max(SUBSTRING(Dc_id,4,6)) from receivedc where LENGTH(Dc_id)=6  and status='0' ");
			System.out.println("SQL............"+preparedStatementx);
			ResultSet resultSetx = preparedStatementx.executeQuery();
			if (resultSetx.next()) {
				
				Scode = String.valueOf(Integer.parseInt(resultSetx
						.getString(1)) + 1);
				if (String.valueOf(Scode).length() == 1) {
					Scode = "DCR00" + Scode;
				} else if (String.valueOf(Scode).length() == 2) {
					Scode = "DCR0" + Scode;
				} else if (String.valueOf(Scode).length() == 3) {
					Scode = "DCR" + Scode;
				}
			} else {
				Scode = "DCR001";
			}
		} catch (Exception e) {
			Scode = "DCR001";
		} 
		
		eb.setDc_id(Scode);
		
		
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("insert into receivedc(Dc_id,cust_name,mob_no,cust_address,pancard_no,email,gstn_no,custid,date,cno,cdate,pono) values(?,?,?,?,?,?,?,?,?,?,?,?) ");
				
				pst.setString(1, eb.getDc_id());
				pst.setString(2, eb.getCust_name());
				pst.setString(3, eb.getMob_no());
				pst.setString(4, eb.getCust_address());
				pst.setString(5, eb.getPancard_no());
				pst.setString(6, eb.getEmail());
				pst.setString(7, eb.getGstn_no());
				pst.setString(8, eb.getCustid());
				
				
				pst.setString(9, eb.getDate());
				pst.setString(10, eb.getCno());
				pst.setString(11, eb.getCdate());
				pst.setString(12, eb.getPono());
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
					
					PreparedStatement pst2 = conn
							.prepareStatement("insert into receive_dc_details(Dc_id,description,qty,price,pono,cno) values(?,?,?,?,?,?) ");
					
					pst2.setString(1, eb.getDc_id());	
					pst2.setString(2, eb.getDescription()[k]);
					pst2.setString(3, eb.getDqty()[k]);
					pst2.setString(4, eb.getPrice()[k]);
					pst2.setString(5, eb.getPono());
					pst2.setString(6, eb.getCno());
					System.out.println("Sql2:..........."+pst2);
					pst2.executeUpdate();
					
				}
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
				
				PreparedStatement pp = conn
						.prepareStatement("select * from purchase_order_details where invoice_no='"+eb.getPono()+"' and descrip='"+eb.getDescription()[k]+"' ");
		
				System.out.println("SQL:"+pp);
				ResultSet rst = pp.executeQuery();
			
				while (rst.next()) {
					
				String desc=eb.getDescription()[k];
				String qty=rst.getString("dcqty");
				
				String qty1=eb.getDqty()[k];
					
				Double qty2=Double.parseDouble(qty)-Double.parseDouble(qty1);
				
				System.out.println("QUantity:"+qty2);
				
				String q11 = "update purchase_order_details set   dcqty='"+qty2+"' where descrip='"+eb.getDescription()[k]+"' and invoice_no='"+eb.getPono()+"'";
		       	PreparedStatement ps1 = conn.prepareStatement(q11);	
		       	
		       	
		     System.out.println("Sql12::"+ps1);
		    	
		       	ps1.executeUpdate();
				
				}
				
				}
	
				response="success";
	}catch (Exception e) {

		response = "";
	}
		}catch (Exception e) {

		response = "";
	}
		
		DBConnection.closeConnection();
		return response;
	}
	
	
	
	
	
	public static String insertoutsrc(Dc_bean eb, userinfo bean) {
		
		
		String response = "";
		
		Connection conn=connection.getConnection();
		
		try {
		
		String Scode = "";
		String Scode1="";
		//Connection conn=DaoHelper.getConnection();
	
		try {
			
			PreparedStatement preparedStatementx = conn.prepareStatement("select  max(SUBSTRING(Dc_id,11,13)) from outsrcdc where LENGTH(Dc_id)=13 and status='0' ");
			System.out.println("SQL............"+preparedStatementx);
			ResultSet resultSetx = preparedStatementx.executeQuery();
			if (resultSetx.next()) {
				
				Scode = String.valueOf(Integer.parseInt(resultSetx
						.getString(1)) + 1);
				if (String.valueOf(Scode).length() == 1) {
					Scode = "DC/OW/SRC/00" + Scode;
				} else if (String.valueOf(Scode).length() == 2) {
					Scode = "DC/OW/SRC/0" + Scode;
				} else if (String.valueOf(Scode).length() == 3) {
					Scode = "DC/OW/SRC/" + Scode;
				}
			} else {
				Scode = "DC/OW/SRC/001";
			}
		} catch (Exception e) {
			Scode = "DC/OW/SRC/001";
		} 
		
		eb.setDc_id(Scode);
		
		
		try {
		
			//Connection connection = DaoHelper.getConnection();
			
			
				PreparedStatement pst = conn
						.prepareStatement("insert into outsrcdc(Dc_id,cust_name,mob_no,cust_address,pancard_no,email,gstn_no,custid,date,cno,cdate,pono) values(?,?,?,?,?,?,?,?,?,?,?,?) ");
				
				pst.setString(1, eb.getDc_id());
				pst.setString(2, eb.getCust_name());
				pst.setString(3, eb.getMob_no());
				pst.setString(4, eb.getCust_address());
				pst.setString(5, eb.getPancard_no());
				pst.setString(6, eb.getEmail());
				pst.setString(7, eb.getGstn_no());
				pst.setString(8, eb.getCustid());
				
				
				pst.setString(9, eb.getDate());
				pst.setString(10, eb.getCno());
				pst.setString(11, eb.getCdate());
				pst.setString(12, eb.getPono());
				System.out.println("Sql1:..........."+pst);
				int i = pst.executeUpdate();
				
				
				
				for (int k=0;k<eb.getDescription().length;k++)
				{
					
					
					PreparedStatement pst2 = conn
							.prepareStatement("insert into outsrc_dc_details(Dc_id,description,qty,price,pono,cno) values(?,?,?,?,?,?) ");
					
					pst2.setString(1, eb.getDc_id());	
					pst2.setString(2, eb.getDescription()[k]);
					pst2.setString(3, eb.getQty()[k]);
					pst2.setString(4, eb.getPrice()[k]);
					pst2.setString(5, eb.getPono());
					pst2.setString(6, eb.getCno());
					System.out.println("Sql2:..........."+pst2);
					pst2.executeUpdate();
					
				}
				
				
				
				
				
	
				response="success";
	}catch (Exception e) {

		response = "";
	}
		}catch (Exception e) {

		response = "";
	}
		
		DBConnection.closeConnection();
		return response;
	}

	
	
	
	
	
	public List<Dc_bean> displayBillReport(userinfo bean, Dc_bean eb) {
		
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pp = conn.prepareStatement("select *  from invoice_vendor");
			
			
			ResultSet rp=pp.executeQuery();
		
			
			while(rp.next())
				
			{
				
			
				Dc_bean bean1 = new Dc_bean();
				
							
				bean1.setInvoiceno(rp.getString("invoice_no"));
				bean1.setDate(rp.getString("date"));
				
				bean1.setTotal(rp.getString("total"));
			
				bean1.setType(rp.getString("invtype"));
				
				
				
				
				
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  transporter_master where transporter_no=?");
				
				preparedStatement112xx1.setString(1, rp.getString("vehicle_no"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setName(resultSet12xx1.getString("transporter_name"));
					
					
				}
				
				
				report.add(bean1);

				
			
		
			
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		
		DBConnection.closeConnection();
		
		return report;
	}
	
	
	
	
	
	
public List<Dc_bean> displayInvoiceReport(userinfo bean, Dc_bean eb) {
		
		
		
		List<Dc_bean> report = new ArrayList<Dc_bean>();
		
		Connection conn=connection.getConnection();
		
		try {
		
		
			
			PreparedStatement pp = conn.prepareStatement("select *  from invoice");
			
			
			ResultSet rp=pp.executeQuery();
		
			
			while(rp.next())
				
			{
				
			
				Dc_bean bean1 = new Dc_bean();
				
							
				bean1.setInvoiceno(rp.getString("invoice_no"));
				bean1.setDate(rp.getString("date"));
				
				bean1.setTotal(rp.getString("total"));
			
				bean1.setType(rp.getString("invtype"));
				
				
				
				
				
				PreparedStatement preparedStatement112xx1 = conn
						.prepareStatement("select * from  customer_master_details where customer_no=?");
				
				preparedStatement112xx1.setString(1, rp.getString("vehicle_no"));
				
				ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
				
				if (resultSet12xx1.next()) {
					
					
					bean1.setName(resultSet12xx1.getString("customer_name"));
					
					
				}
				
				
				report.add(bean1);

				
			
		
			
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		
		DBConnection.closeConnection();
		
		return report;
	}
	









public List<Dc_bean> pi_displayInvoiceReport(userinfo bean, Dc_bean eb) {
	
	
	
	List<Dc_bean> report = new ArrayList<Dc_bean>();
	
	Connection conn=connection.getConnection();
	
	try {
	
	
		
		PreparedStatement pp = conn.prepareStatement("select *  from pi_invoice");
		
		
		ResultSet rp=pp.executeQuery();
	
		
		while(rp.next())
			
		{
			
		
			Dc_bean bean1 = new Dc_bean();
			
						
			bean1.setInvoiceno(rp.getString("invoice_no"));
			bean1.setDate(rp.getString("date"));
			
			bean1.setTotal(rp.getString("total"));
		
			bean1.setType(rp.getString("invtype"));
			
			
			
			
			
			PreparedStatement preparedStatement112xx1 = conn
					.prepareStatement("select * from  customer_master_details where customer_no=?");
			
			preparedStatement112xx1.setString(1, rp.getString("vehicle_no"));
			
			ResultSet resultSet12xx1 = preparedStatement112xx1.executeQuery();
			
			if (resultSet12xx1.next()) {
				
				
				bean1.setName(resultSet12xx1.getString("customer_name"));
				
				
			}
			
			
			report.add(bean1);

			
		
	
		
		}
	
	} catch (Exception e) {
		// TODO: handle exception
	}		
	
	
	DBConnection.closeConnection();
	
	return report;
}


		
	}

