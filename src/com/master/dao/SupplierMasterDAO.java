package com.master.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;


public class SupplierMasterDAO {

	
	public String insertCompanyMaster(Company_Master_Bean bmb)
	{
		String response="";
		try
		{
	
			 	DBConnection connection=new DBConnection();Connection conn=connection.getConnection();
			 	
			 	PreparedStatement preparedStatement=conn.prepareStatement("select * from company_master where company_name=?");	
				preparedStatement.setString(1, bmb.getCompany_name());
				ResultSet resultSet=preparedStatement.executeQuery();
				if(resultSet.next())
				{
					response="Already";
					
				}
				
				
				
				else {
					String dcode = "";
					try {
						PreparedStatement preparedStatementx = conn
								.prepareStatement("select  max(SUBSTRING(company_id,4,6)) from company_master where LENGTH(company_id)>4 ");
						System.out.println(preparedStatementx);
						ResultSet resultSetx = preparedStatementx.executeQuery();
						if (resultSetx.next()) {

							dcode = String.valueOf(Integer.parseInt(resultSetx
									.getString(1)) + 1);

							if (String.valueOf(dcode).length() == 1) {
								dcode = "SUP000" + dcode;

							} else if (String.valueOf(dcode).length() == 2) {
								dcode = "SUP00" + dcode;

							} else if (String.valueOf(dcode).length() == 3) {
								dcode = "SUP0" + dcode;

							}else if (String.valueOf(dcode).length() == 4) {
								dcode = "SUP" + dcode;

							}

						} else {
							dcode = "SUP0001";
						}

					} catch (Exception e) {
						// TODO: handle exception
						dcode = "SUP0001";
					}
					try {
						if (!dcode.equals(null) && !dcode.equals("")) {

						} else {
							dcode = "SUP0001";
						}
					} catch (Exception e) {
						// TODO: handle exception
						dcode = "SUP0001";
					}
					// dmb.setDealer_code("D"+dcode);
					System.out.println(">>>>>" + dcode);
					PreparedStatement pst=conn.prepareStatement("insert into company_master(company_name,address,company_contact,city,email_id,company_id,cstno,vatno,bank_name,account_no,ifsc_code,remark,state) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");	
					
					pst.setString(1,bmb.getCompany_name());
					
					pst.setString(2,bmb.getAddress());
					
					pst.setString(3,bmb.getCompany_contact() );
					
					pst.setString(4,bmb.getCity());
					pst.setString(5,bmb.getEmail_id());
					pst.setString(6,dcode);
					pst.setString(7,bmb.getCstno());
					pst.setString(8,bmb.getVatno());
					pst.setString(9,bmb.getBank_name());
					pst.setString(10,bmb.getAccount_no());
					pst.setString(11,bmb.getIfsc_code());
					pst.setString(12,bmb.getRemark());
					pst.setString(13,bmb.getState());
					int i=pst.executeUpdate();
					
					if(i>0)
						response="success";
					else
						response="fail";
				}
			  
		}
		catch(Exception e)
		{
			
			response="fail";
		}
		return response;
	}
	
	public static List<Company_Master_Bean> fetchCompanyReport()throws IOException,SQLException
	{
		
		 List<Company_Master_Bean> list2=new ArrayList<Company_Master_Bean>();
		try{
			DBConnection connection=new DBConnection();Connection conn=connection.getConnection();
			
			 PreparedStatement pst2=conn.prepareStatement("select  * from company_master");
			 
			 ResultSet rs=pst2.executeQuery();
			 while(rs.next())
				{
				
				 Company_Master_Bean bmb=new Company_Master_Bean();
				 
				 bmb.setCompany_name(rs.getString("company_name"));
				 bmb.setAddress(rs.getString("address"));
				 bmb.setCompany_contact(rs.getString("company_contact"));
				 bmb.setCity(rs.getString("city"));
				 bmb.setEmail_id(rs.getString("email_id"));
				 bmb.setCompany_id(rs.getString("company_id"));
				 bmb.setCstno(rs.getString("cstno"));
				 bmb.setVatno(rs.getString("vatno"));
				 bmb.setBank_name(rs.getString("bank_name"));
				 bmb.setAccount_no(rs.getString("account_no"));
				 bmb.setIfsc_code(rs.getString("ifsc_code"));
				 bmb.setRemark(rs.getString("remark"));
				 bmb.setCompany_id(rs.getString("company_id"));
				 bmb.setState(rs.getString("state"));
				 list2.add(bmb);  
				}
		}catch(Exception ex){System.out.println("error"+ex.getMessage());}
		
		
		return list2;
		
	}
	public static List <Company_Master_Bean> fetchCompanyReportSearch(String company_name)throws IOException,SQLException
	{
	
		List<Company_Master_Bean> list1=new ArrayList<Company_Master_Bean>();
		try{
			DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
		
		 PreparedStatement pst2=connection.prepareStatement("select * from company_master where company_name='"+company_name+"' ");
		 
		 ResultSet rs=pst2.executeQuery();
		 while(rs.next())
		   {
			 Company_Master_Bean bmb2=new Company_Master_Bean();
			 
			 bmb2.setCompany_name(rs.getString("company_name"));
			 bmb2.setAddress(rs.getString("address"));
			 bmb2.setCompany_contact(rs.getString("company_contact"));
			 bmb2.setCity(rs.getString("city"));
			 bmb2.setCompany_id(rs.getString("company_id"));
			 bmb2.setCstno(rs.getString("cstno"));
			 bmb2.setVatno(rs.getString("vatno"));
			 bmb2.setBank_name(rs.getString("bank_name"));
			 bmb2.setAccount_no(rs.getString("account_no"));
			 bmb2.setIfsc_code(rs.getString("ifsc_code"));
			 bmb2.setRemark(rs.getString("remark"));
			 bmb2.setState(rs.getString("state"));
			 bmb2.setCompany_id(rs.getString("company_id"));
			 list1.add(bmb2);
			 
		   }
		}catch(Exception ex){
			System.out.println("error"+ex.getMessage());
		}
		return list1;
	}
	
	public static 	Boolean editCompanyMaster(String company_name,String address,String company_contact,String city,String email_id, String cstno, String vatno, String bank_name, String account_no, String ifsc_code, String remark, String company_id )
	{
		Boolean response=false;
		try {
			
			DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
			
			 PreparedStatement pst3=connection.prepareStatement("update  company_master set company_name='"+company_name+"',address='"+address+"',company_contact='"+company_contact+"',bank_name='"+bank_name+"',account_no='"+account_no+"',ifsc_code='"+ifsc_code+"',remark='"+remark+"',city='"+city+"',email_id='"+email_id+"',cstno='"+cstno+"',vatno='"+vatno+"' where company_id='"+company_id+"'");
		System.out.println(pst3);
			  int i=pst3.executeUpdate();
			  
			  if(i>0)
				  response=true;
			  else
				  response=false;
			   
			   
			
		}
		catch (Exception e) {
			  response=false;
		}
		
		
	
		return response;
	}
	
	public static List<Company_Master_Bean> fetchCompanyReport1()throws IOException,SQLException
	{
		
		 List<Company_Master_Bean> list2=new ArrayList<Company_Master_Bean>();
		try{
			DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
			 PreparedStatement pst2=connection.prepareStatement("select * from company_master");
			 
			 ResultSet rs=pst2.executeQuery();
			
			 while(rs.next())
				{
				 Company_Master_Bean bmb=new Company_Master_Bean();
				 
				 bmb.setCompany_name(rs.getString("company_name"));
				 bmb.setAddress(rs.getString("address"));
				 bmb.setCompany_contact(rs.getString("company_contact"));
				 bmb.setCity(rs.getString("city"));
				 bmb.setEmail_id(rs.getString("email_id"));
				 bmb.setCompany_id(rs.getString("company_id"));
				 bmb.setCstno(rs.getString("cstno"));
				 bmb.setVatno(rs.getString("vatno"));
				 bmb.setBank_name(rs.getString("bank_name"));
				 bmb.setAccount_no(rs.getString("account_no"));
				 bmb.setIfsc_code(rs.getString("ifsc_code"));
				 bmb.setRemark(rs.getString("remark"));
				 bmb.setCompany_id(rs.getString("company_id"));
				 bmb.setState(rs.getString("state"));
				 list2.add(bmb);  
				}
		}catch(Exception ex){System.out.println("error"+ex.getMessage());}
		
		
		return list2;
		
	}
	
	public static 	Boolean deleteCompanyMaster(String company_name)
	{
		Boolean response=false;
		
		try {
			
			DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
			
			 PreparedStatement pst4=connection.prepareStatement("delete from  company_master where company_name='"+company_name+"' ");
			
			 int i=pst4.executeUpdate();
			 
			  if(i>0)
				  response=true;
			  else
				  response=false;
		} catch (Exception e) {
			// TODO: handle exception
		}
	
			return response;
	}

	public boolean editCompanyMaster(Company_Master_Bean bmb) {
		// TODO Auto-generated method stub
		Boolean response=false;
		try {
			
			DBConnection conn=new DBConnection();Connection connection=conn.getConnection();
			
			 PreparedStatement pst3=connection.prepareStatement("update  company_master set company_name='"+bmb.getCompany_name()+"',address='"+bmb.getAddress()+"',company_contact='"+bmb.getCompany_contact()+"',bank_name='"+bmb.getBank_name()+"',account_no='"+bmb.getAccount_no()+"',ifsc_code='"+bmb.getIfsc_code()+"',remark='"+bmb.getRemark()+"',city='"+bmb.getCity()+"',email_id='"+bmb.getEmail_id()+"',cstno='"+bmb.getCstno()+"',vatno='"+bmb.getVatno()+"' ,state='"+bmb.getState()+"' where company_id='"+bmb.getCompany_id()+"'");
			 System.out.println(pst3);
			  int i=pst3.executeUpdate();
			  
			  if(i>0)
				  response=true;
			  else
				  response=false;
			   
			   
			
		}
		catch (Exception e) {
			  response=false;
		}
		
		
	
		return response;
	}
	
	
}

