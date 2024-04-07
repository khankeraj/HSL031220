package com.master.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.CityModel;
import com.master.model.DriverModel;
import com.master.model.EmployeeMasterModel;
import com.master.model.ProductModel;
import com.master.util.SystemDateTime;
//import com.relience.dao.dao_helper.DaoHelper;
/*import com.relience.dao.dao_helper.DaoHelper;
import com.relience.util.CoreData;*/





public class DriverMasterDao {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
public int insert_driver_Details(DriverModel drivermodel, File[] photo) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from driver_master where driver_name = '"+drivermodel.getDriver_name()+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return -1;
			}
			
			
			String customer_final_id="DRV/0001";
			
			String pref="DRV";
			
			PreparedStatement preparedStatement11 = conn
					.prepareStatement("select  max(SUBSTRING(driver_id,-5)) as myval1 from driver_master  where LENGTH(driver_id)>5 and driver_id like '%"
							+ pref + "%' ");
			String mystr1 = "";
			int myval1 = 0;
			String stringValue1 = "1";
			ResultSet resultSet11 = preparedStatement11.executeQuery();
			if (resultSet11.next()) {
				try {
					mystr1 = resultSet11.getString("myval1");
					myval1 = Integer.parseInt(mystr1);
					myval1 = myval1 + 1;
				} catch (Exception e) {
					// TODO: handle exception
					myval1 = 1;
					mystr1 = "";
				}
			}
	

			if (mystr1.equals("")) {
				stringValue1 = pref + "/0000" + stringValue1;

			} else {

				if (String.valueOf(myval1).length() == 1) {
					stringValue1 = pref + "/0000" + String.valueOf(myval1);

				} else if (String.valueOf(myval1).length() == 2) {
					stringValue1 = pref + "/000" + String.valueOf(myval1);
				} else if (String.valueOf(myval1).length() == 3) {
					stringValue1 = pref + "/00" + String.valueOf(myval1);
				} else  if (String.valueOf(myval1).length() == 4) {
					stringValue1 = pref + "/0" + String.valueOf(myval1);
				} else {
					stringValue1 = pref + "/" + String.valueOf(myval1);
				}
			}
			
			drivermodel.setDriver_id(stringValue1);
			
			
			
			
			
			PreparedStatement pst = conn.prepareStatement("insert into `driver_master` (`driver_name`,  `driver_address_p`, `driver_address_c`, `contact_number`, `dob`, `age`, `salary_type`, `basic_salary`, `bank_name`, `account_no`, `ifsc_code`, `remark`, `experience`, `emergency_contact`, `driver_photo`, `aadhar_no`, `license_no`, `aadhar_photo`, `license_photo`, `driver_id`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, drivermodel.getDriver_name());
			pst.setString(2, drivermodel.getAddr_permanent());
			pst.setString(3, drivermodel.getAddr_curr());
			pst.setString(4, drivermodel.getContact_number());
			pst.setString(5, drivermodel.getDate_of_birth());
			pst.setString(6, drivermodel.getAge());
			pst.setString(7, drivermodel.getSalary_type());
			pst.setString(8, drivermodel.getBasic_salary());
			pst.setString(9, drivermodel.getBank_name());
			pst.setString(10, drivermodel.getAccount_no());
			pst.setString(11, drivermodel.getIfsc_code());
			pst.setString(12, drivermodel.getRemark());
			pst.setString(13, drivermodel.getExperience());
			pst.setString(14, drivermodel.getEmer_contact());
			/*pst.setString(15, drivermodel.getDriver_photo());*/
			pst.setString(15, String.valueOf(photo[0]));
			pst.setString(16, drivermodel.getAadhar_no());
			pst.setString(17, drivermodel.getLicense_no());
			/*pst.setString(18, drivermodel.getAadhar_photo());*/
			pst.setString(18, String.valueOf(photo[1]));
			/*pst.setString(19, drivermodel.getLicense_photo());*/
			pst.setString(19, String.valueOf(photo[2]));
			pst.setString(20, stringValue1);
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
public List<DriverModel> fetchDriverMasterDetails() {
	// TODO Auto-generated method stub
List<DriverModel> list=new ArrayList<DriverModel>();
	
	try {
			PreparedStatement pst=conn.prepareStatement("SELECT `id`, `driver_id`, `driver_name`, `driver_address_p`, `driver_address_c`, `contact_number`, `dob`, `age`, `salary_type`, `basic_salary`, `bank_name`, `account_no`, `ifsc_code`, `remark`, `experience`, `emergency_contact`, `driver_photo`, `aadhar_no`, `license_no`, `aadhar_photo`, `license_photo` FROM `driver_master`");
			ResultSet rs=pst.executeQuery();
			System.out.println("1...."+pst);
			while(rs.next())
			{
				DriverModel driverModel=new DriverModel();
				driverModel.setD_id(String.valueOf(rs.getInt(1)));
				driverModel.setDriver_id(rs.getString(2));
				driverModel.setDriver_name(rs.getString(3));
				driverModel.setAddr_permanent(rs.getString(4));
				driverModel.setAddr_curr(rs.getString(5));
				driverModel.setContact_number(rs.getString(6));
				driverModel.setDate_of_birth(rs.getString(7));
				driverModel.setAge(rs.getString(8));
				driverModel.setSalary_type(rs.getString(9));
				driverModel.setBasic_salary(rs.getString(10));
				driverModel.setBank_name(rs.getString(11));
				driverModel.setAccount_no(rs.getString(12));
				driverModel.setIfsc_code(rs.getString(13));
				driverModel.setRemark(rs.getString(14));
				driverModel.setExperience(rs.getString(15));
				driverModel.setEmer_contact(rs.getString(16));
				driverModel.setDriver_photo(rs.getString(17));
				driverModel.setAadhar_no(rs.getString(18));
				driverModel.setLicense_no(rs.getString(19));
				driverModel.setAadhar_photo(rs.getString(20));
				driverModel.setLicense_photo(rs.getString("license_photo"));
				
				list.add(driverModel);
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
public List<DriverModel> fetchForUpdateDriverDetailss(DriverModel driver_model, String driver_id) {
	// TODO Auto-generated method stub
List<DriverModel> list=new ArrayList<DriverModel>();
	
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT `id`, `driver_id`, `driver_name`, `driver_address_p`, `driver_address_c`, `contact_number`, `dob`, `age`, `salary_type`, `basic_salary`, `bank_name`, `account_no`, `ifsc_code`, `remark`, `experience`, `emergency_contact`, `driver_photo`, `aadhar_no`, `license_no`, `aadhar_photo`, `license_photo` FROM `driver_master` WHERE driver_id='"+driver_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			DriverModel driverModel=new DriverModel();
			driverModel.setD_id(String.valueOf(rs.getInt(1)));
			driverModel.setDriver_id(rs.getString(2));
			driverModel.setDriver_name(rs.getString(3));
			driverModel.setAddr_permanent(rs.getString("driver_address_p"));
			driverModel.setAddr_curr(rs.getString("driver_address_c"));
			driverModel.setContact_number(rs.getString("contact_number"));
			driverModel.setDate_of_birth(rs.getString("dob"));
			driverModel.setAge(rs.getString("age"));
			driverModel.setSalary_type(rs.getString("salary_type"));
			driverModel.setBasic_salary(rs.getString("basic_salary"));
			driverModel.setBank_name(rs.getString("bank_name"));
			driverModel.setAccount_no(rs.getString("account_no"));
			driverModel.setIfsc_code(rs.getString("ifsc_code"));
			driverModel.setRemark(rs.getString("remark"));
			driverModel.setExperience(rs.getString("experience"));
			driverModel.setEmer_contact(rs.getString("emergency_contact"));
			driverModel.setDriver_photo(rs.getString("driver_photo"));;
			driverModel.setAadhar_no(rs.getString("aadhar_no"));
			driverModel.setLicense_no(rs.getString("license_no"));
			driverModel.setAadhar_photo(rs.getString("aadhar_photo"));
			driverModel.setLicense_photo(rs.getString("license_photo"));
			
			list.add(driverModel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

}
public int deleteDriver_master(String delete_driver_id) {
	// TODO Auto-generated method stub
	int i=0;
	try {
		PreparedStatement pst=conn.prepareStatement("DELETE FROM `driver_master` WHERE driver_id='"+delete_driver_id+"'");
		i=pst.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public int update_driver_details(DriverModel drivermodel, String update_driver) {
	// TODO Auto-generated method stub
	int i=0;
	/*int driver_id=Integer.parseInt(update_driver);*/
	
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `driver_master` SET `driver_name`=?, `driver_address_p`=?, `driver_address_c`=?, `contact_number`=?, `dob`=?, `age`=?, `salary_type`=?, `basic_salary`=?, `bank_name`=?, `account_no`=?, `ifsc_code`=?, `remark`=?, `experience`=?, `emergency_contact`=?, `driver_photo`=?, `aadhar_no`=?, `license_no`=?, `aadhar_photo`=?, `license_photo`=? WHERE `driver_id`=?");
		
		pst.setString(1, drivermodel.getDriver_name());
		pst.setString(2, drivermodel.getAddr_permanent());
		pst.setString(3, drivermodel.getAddr_curr());
		pst.setString(4, drivermodel.getContact_number());
		pst.setString(5, drivermodel.getDate_of_birth());
		pst.setString(6, drivermodel.getAge());
		pst.setString(7, drivermodel.getSalary_type());
		pst.setString(8, drivermodel.getBasic_salary());
		pst.setString(9, drivermodel.getBank_name());
		pst.setString(10, drivermodel.getAccount_no());
		pst.setString(11, drivermodel.getIfsc_code());
		pst.setString(12, drivermodel.getRemark());
		pst.setString(13, drivermodel.getExperience());
		pst.setString(14, drivermodel.getEmer_contact());
		pst.setString(15, drivermodel.getDriver_photo());
		pst.setString(16, drivermodel.getAadhar_no());
		pst.setString(17, drivermodel.getLicense_no());
		pst.setString(18, drivermodel.getAadhar_photo());
		pst.setString(19, drivermodel.getLicense_photo());
		
		
		
		pst.setString(20, update_driver);
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public int insert_salary_Details(DriverModel drivermodel) {
	// TODO Auto-generated method stub
	String[] drv  = drivermodel.getDriver_name().split("-");
	int c = 0;
	try {
		
		
		String customer_final_id="SAL/0001";
		
		String pref="SAL";
		
		PreparedStatement preparedStatement11 = conn
				.prepareStatement("select  max(SUBSTRING(sal_id,-5)) as myval1 from driver_salary  where LENGTH(sal_id)>5 and sal_id like '%"
						+ pref + "%' ");
		String mystr1 = "";
		int myval1 = 0;
		String stringValue1 = "1";
		ResultSet resultSet11 = preparedStatement11.executeQuery();
		if (resultSet11.next()) {
			try {
				mystr1 = resultSet11.getString("myval1");
				myval1 = Integer.parseInt(mystr1);
				myval1 = myval1 + 1;
			} catch (Exception e) {
				// TODO: handle exception
				myval1 = 1;
				mystr1 = "";
			}
		}


		if (mystr1.equals("")) {
			stringValue1 = pref + "/0000" + stringValue1;

		} else {

			if (String.valueOf(myval1).length() == 1) {
				stringValue1 = pref + "/0000" + String.valueOf(myval1);

			} else if (String.valueOf(myval1).length() == 2) {
				stringValue1 = pref + "/000" + String.valueOf(myval1);
			} else if (String.valueOf(myval1).length() == 3) {
				stringValue1 = pref + "/00" + String.valueOf(myval1);
			} else  if (String.valueOf(myval1).length() == 4) {
				stringValue1 = pref + "/0" + String.valueOf(myval1);
			} else {
				stringValue1 = pref + "/" + String.valueOf(myval1);
			}
		}
		
		drivermodel.setSal_id(stringValue1);
		
		
		
		
		
		
		
		
		
		
		
		PreparedStatement pst = conn.prepareStatement("insert into driver_salary(driver_id, driver_name, date, month, year, days_present, tax, bonus, other, fine, overtime, sal_id, status) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1, drv[1]);
		pst.setString(2, drv[0]);
		pst.setString(3, drivermodel.getDate());
		pst.setString(4, drivermodel.getMonth());
		pst.setString(5, drivermodel.getYear());
		pst.setString(6, drivermodel.getDays_present());
		pst.setString(7, drivermodel.getTax());
		pst.setString(8, drivermodel.getBonus());
		pst.setString(9, drivermodel.getOther());
		pst.setString(10, drivermodel.getFine());
		pst.setString(11, drivermodel.getOvertime());
		pst.setString(12, drivermodel.getSal_id());
		pst.setString(13, "0");
		
		c = pst.executeUpdate();
		System.out.println("pst: "+pst);
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return c;
}
public List<DriverModel> getSalaryDetails(String month, String year) {
	// TODO Auto-generated method stub
	List<DriverModel> list  = new ArrayList<>();
	
	try {
		
		String mnum = "";
		if(month.equals("January"))
			mnum = "1";
		if(month.equals("February"))
			mnum = "2";
		if(month.equals("March"))
			mnum = "3";
		if(month.equals("April"))
			mnum = "4";
		if(month.equals("May"))
			mnum = "5";
		if(month.equals("June"))
			mnum = "6";
		if(month.equals("July"))
			mnum = "7";
		if(month.equals("August"))
			mnum = "8";
		if(month.equals("September"))
			mnum = "9";
		if(month.equals("Ocotber"))
			mnum = "10";
		if(month.equals("November"))
			mnum = "11";
		if(month.equals("December"))
			mnum = "12";
						
		
		double days = 0;
		double basic = 0;
		double per_day = 0;
		double new_basic = 0;
				
		double tax = 0;
		double bonus = 0;
		double other = 0; 
		double fine = 0;
		double overtime = 0;
		double advance = 0;
		
		
		PreparedStatement pst = conn.prepareStatement("select * from driver_salary where month = '"+month+"' and year='"+year+"'");
		ResultSet rs = pst.executeQuery();
		System.out.println("pst: "+pst);
		while(rs.next())
		{
			DriverModel model = new DriverModel();
			model.setDriver_id(rs.getString("driver_id"));
			model.setDriver_name(rs.getString("driver_name"));
			model.setDays_present(rs.getString("days_present"));
			model.setTax(rs.getString("tax"));
			model.setBonus(rs.getString("bonus"));
			model.setOther(rs.getString("other"));
			model.setFine(rs.getString("fine"));
			model.setOvertime(rs.getString("overtime"));
			model.setSal_id(rs.getString("sal_id"));
			model.setStatus(rs.getString("status"));
			
			PreparedStatement pst1 = conn.prepareStatement("select basic_salary from driver_master where driver_id = '"+model.getDriver_id()+"'");
			ResultSet rs1 = pst1.executeQuery();
			
			if(rs1.next())
			{
				model.setBasic_salary(rs1.getString(1));
			}
			
			try {
			 days = Double.parseDouble(model.getDays_present());
			 basic = Double.parseDouble(model.getBasic_salary());
			 per_day = basic/31;
			 new_basic = per_day * days;
					
			 tax = Double.parseDouble(model.getTax());
			 bonus = Double.parseDouble(model.getBonus());
			 other = Double.parseDouble(model.getOther()); 
			 fine = Double.parseDouble(model.getFine());
			 overtime = Double.parseDouble(model.getOvertime());
			 
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			PreparedStatement psta = conn.prepareStatement("select sum(exp_amount) from expense where exp_parti='SALARY ADVANCE' and drv_code = '"+model.getDriver_id()+"' and MONTH(date)='"+mnum+"' and YEAR(date)='"+year+"'");
			ResultSet rsa = psta.executeQuery();
			System.out.println("psta: "+psta);
			
			
			if(rsa.next())
			{
				model.setAdvance(rsa.getString(1));
				try {
				advance = Double.parseDouble(model.getAdvance());
				}catch (Exception e) {
					// TODO: handle exception
					advance = 0;
				}
			}
			
			
			
			double tot_ded = tax + other + fine;
			double gross = new_basic + bonus;
			double tot_net = gross - tot_ded + overtime;
			
			model.setTot_ded(String.format("%.2f", tot_ded));
			model.setGross(String.format("%.2f", gross));
			model.setTot_net(String.format("%.2f", tot_net));
			
			
			list.add(model);
			
		}
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return list;
}
public String submit_salary_Details(DriverModel drivermodel) {
	// TODO Auto-generated method stub

	String response = "";

	try {
		//System.out.println("Attendance Submit Dao.......");

		//Connection connection = DaoHelper.getConnection1();

		/*PreparedStatement pst = connection.prepareStatement(
				"delete from salarygenerate where   month='" + bin.getMnth() + "' and year='" + bin.getYr() + "' ");

		int i = pst.executeUpdate();*/

		int length = drivermodel.getDriver_name1().length;

		//System.out.println("length" + bin.getEmp_name1().length);
		// //System.out.println("555555");
	
		
		
		

		for (int k = 0; k < drivermodel.getDriver_name1().length; k++) {
			//System.out.println("kkk" + bin.getEmp_name1()[k]);
			if (drivermodel.getDriver_name1()[k] != "") {

				String salary_code="";
				try {

					
					PreparedStatement psx = conn.prepareStatement("select  max(SUBSTRING(salary_code,-4)) as salary_code from salarygenerate where month='"+drivermodel.getMonth()+"' and year='"+drivermodel.getYear()+"'  ");
					//System.out.println(psx);
					ResultSet rsx = psx.executeQuery();
					if (rsx.next())
					{
						salary_code = String.valueOf(Integer.parseInt(rsx.getString(1)) + 1);
						if (String.valueOf(salary_code).length() == 1) 
							salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/000" + salary_code ;
						else if (String.valueOf(salary_code).length() == 2)
							salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/00" + salary_code ;
						else if (String.valueOf(salary_code).length() == 3) 
							salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/0" + salary_code ;
						else if (String.valueOf(salary_code).length() == 4) 
							salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/" + salary_code ;
					} 
					else 
						salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/0001";
					
			}	catch (Exception e) {
					// TODO: handle exception
					salary_code = "Sal/"+drivermodel.getMonth()+drivermodel.getYear()+"/0001";
					e.printStackTrace();
				}
				
				PreparedStatement pst1 = conn.prepareStatement(
						"insert into salarygenerate(date,year,month,driver_id,driver_name,basic,bonus,gross,ptax,overtime,adv,room,pf,other,eSI,tDed,net,days,fine,supervisor,cardno,salary_code) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

				//System.out.println(">>>>>>1");
				pst1.setString(1, SystemDateTime.CurrentDateTime());
				//System.out.println(">>>>>>2");
				pst1.setString(2, drivermodel.getYear());
				//System.out.println(">>>>>>3");
				pst1.setString(3, drivermodel.getMonth());
				pst1.setString(4, drivermodel.getDriver_id1()[k]);
				pst1.setString(5, drivermodel.getDriver_name1()[k]);
				//System.out.println(">>>>>>4");
				pst1.setString(6, drivermodel.getBasic_salary1()[k]);
				pst1.setString(7, drivermodel.getBonus1()[k]);
				pst1.setString(8, drivermodel.getGross1()[k]);
				pst1.setString(9, drivermodel.getTax1()[k]);
				pst1.setString(10, drivermodel.getOvertime1()[k]);
				pst1.setString(11, drivermodel.getAdvance1()[k]);
				//System.out.println(">>>>>>5");
				pst1.setString(12, "");
				//System.out.println(">>>>>>51");
				pst1.setString(13, "");
				//System.out.println(">>>>>>52");
				pst1.setString(14, drivermodel.getOther1()[k]);
				//System.out.println(">>>>>>53");
				pst1.setString(15, "");
				//System.out.println(">>>>>>6");
				pst1.setString(16, drivermodel.getTot_ded1()[k]);
				pst1.setString(17, drivermodel.getTot_net1()[k]);
				pst1.setString(18, drivermodel.getDays_present1()[k]);
				pst1.setString(19, drivermodel.getFine1()[k]);
				pst1.setString(20, "");
				pst1.setString(21, "");
				pst1.setString(22, salary_code);
				//System.out.println(pst1);
				//pst1.setString(23, salary_code);
				pst1.executeUpdate();
				
				try {
					
					
					PreparedStatement psts = conn.prepareStatement("update driver_salary set status='1' where sal_id = '"+drivermodel.getSal_id1()[k]+"'");
					int sc = psts.executeUpdate();
					System.out.println("psts: "+psts);
					
					
					System.out.println("1");
					
					if(!drivermodel.getBasic_salary1()[k].trim().equals("0.00")) {
						
						String stringValue6 = "";
						int len4 = 0;
						PreparedStatement preparedStatement5 = conn
								.prepareStatement("select  max(SUBSTRING(billno,-4)) as myval1 from drivercreditdebit");
						
						
						String mystr4 = "";
						int myval4 = 0;
						ResultSet resultSet4 = preparedStatement5.executeQuery();
						
						if (resultSet4.next()) {
							try {
								mystr4 = resultSet4.getString("myval1");
								myval4 = Integer.parseInt(mystr4);
								myval4 = myval4 + 1;
							} catch (Exception e) {
								// TODO: handle exception
								myval4 = 1;
								mystr4 = "";
								e.printStackTrace();
							}
						}
						
						
						
						
						int size4 = len4 + 1;
						stringValue6 = String.valueOf(myval4);
						
							if (stringValue6.length() == 1) {
								stringValue6 = "BILL/" + "000" + stringValue6;
							} else if (stringValue6.length() == 2) {
								stringValue6 = "BILL/" + "00" + stringValue6;
							} else if (stringValue6.length() == 3) {
								stringValue6 = "BILL/" + "0" + stringValue6;
							} else {
								stringValue6 = "BILL/" + stringValue6;
							}
	
						
						
						
						System.out.println("2");
					PreparedStatement pst9 = conn.prepareStatement("insert into drivercreditdebit(driver_id,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, drivermodel.getDriver_id1()[k]);
					pst9.setString(2, SystemDateTime.CurrentDateTime());
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, ""+drivermodel.getTot_net1()[k]);
					pst9.setString(8, drivermodel.getDriver_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,stringValue6);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}
					System.out.println("3");
					int k1 = pst9.executeUpdate();
					System.out.println("4");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				/*
				try {
					if(!bin.getFine1()[k].trim().equals("0.00")) {
					PreparedStatement pst9 = connection.prepareStatement("insert into employeecreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, bin.getEmp_code()[k]);
					pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate Fine");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, bin.getFine1()[k]);
					pst9.setString(8, bin.getEmp_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,bin.getCard_no1()[k]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}

					//System.out.println("SQL:" + pst9);
					int k1 = pst9.executeUpdate();
					}
				} catch (Exception e) {
				}
				try {
					if(!bin.getAdv()[k].trim().equals("0.00")) {
					PreparedStatement pst9 = connection.prepareStatement("insert into employeecreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, bin.getEmp_code()[k]);
					pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate Advance");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, bin.getAdv()[k]);
					pst9.setString(8, bin.getEmp_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,bin.getCard_no1()[k]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}

					//System.out.println("SQL:" + pst9);
					int k1 = pst9.executeUpdate();
					}
				} catch (Exception e) {
				}
				try {
					if(!bin.getUnif()[k].trim().equals("0.00")) {
					PreparedStatement pst9 = connection.prepareStatement("insert into employeecreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, bin.getEmp_code()[k]);
					pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate Uniform");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, bin.getUnif()[k]);
					pst9.setString(8, bin.getEmp_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,bin.getCard_no1()[k]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}

					int k1 = pst9.executeUpdate();
					}
				} catch (Exception e) {
				}

				
				
				try {
					if(!bin.getRoom1()[k].trim().equals("0.00")) {
					PreparedStatement pst9 = connection.prepareStatement("insert into employeecreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, bin.getEmp_code()[k]);
					pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate Room Rent");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, bin.getRoom1()[k]);
					pst9.setString(8, bin.getEmp_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,bin.getCard_no1()[k]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}
					
					int k1 = pst9.executeUpdate();
					}
				} catch (Exception e) {
				}
				try {
					if(!bin.getOther()[k].trim().equals("0.00")) {
					PreparedStatement pst9 = connection.prepareStatement("insert into employeecreditdebit(Customercode,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
					pst9.setString(1, bin.getEmp_code()[k]);
					pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));
					pst9.setString(3, salary_code);
					pst9.setString(4, "Salary Generate Other");
					pst9.setString(5, "101");
					pst9.setString(6, "Debit");
					pst9.setString(7, bin.getOther()[k]);
					pst9.setString(8, bin.getEmp_name1()[k]);
					
					pst9.setString(9, "");
					pst9.setString(10, SystemDateTime.CurrentDateTime());
					
					try {
						pst9.setString(11,bin.getCard_no1()[k]);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						pst9.setString(11,"");
						e1.printStackTrace();
					}

					int k1 = pst9.executeUpdate();
					}
				} catch (Exception e) {
				}*/
				/*try {
					PreparedStatement pst31 = connection
							.prepareStatement("update emp_master set salary_adv=salary_adv-" + bin.getAdv()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst31);
					int iz1 = pst31.executeUpdate();
				} catch (Exception e) {
				}
				try {
					PreparedStatement pst32 = connection
							.prepareStatement("update emp_master set uniform_os=uniform_os-" + bin.getUnif()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst32);
					int iz2 = pst32.executeUpdate();
				} catch (Exception e) {
				}*/

				//System.out.println(pst1);

				// //System.out.println("hsn name is......."+bin.getCity());
				response = "success";
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}

	//DaoHelper.closeConnection();
	return response;

}
public List<DriverModel> getSalaryReport() {
	// TODO Auto-generated method stub
	List<DriverModel> list = new ArrayList<>();
	try {
	PreparedStatement pst = conn.prepareStatement("select * from driver_salary where status='0' ");
	ResultSet rs = pst.executeQuery();
	
	while(rs.next())
	{
		DriverModel model = new DriverModel();
		model.setD_id(rs.getString("id"));
		model.setDriver_id(rs.getString("driver_id"));
		model.setDriver_name(rs.getString("driver_name"));
		model.setDate(rs.getString("date"));
		model.setMonth(rs.getString("month"));
		model.setYear(rs.getString("year"));
		model.setDays_present(rs.getString("days_present"));
		model.setTax(rs.getString("tax"));
		model.setBonus(rs.getString("bonus"));
		model.setOther(rs.getString("other"));
		model.setFine(rs.getString("fine"));
		model.setOvertime(rs.getString("overtime"));
		model.setSal_id(rs.getString("sal_id"));
		list.add(model);
	}
	
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return list;
}
public List<DriverModel> fetchForUpdateSalary(String sal_id) {
	// TODO Auto-generated method stub
	List<DriverModel> list=new ArrayList<DriverModel>();
	//int emp_id = Integer.parseInt(employee_id);
	try {
		PreparedStatement pst=conn.prepareStatement("SELECT * from driver_salary WHERE sal_id='"+sal_id+"'");
		ResultSet rs=pst.executeQuery();
		System.out.println("pst ---- "+pst);
		while(rs.next())
		{
			DriverModel model = new DriverModel();
			model.setDriver_id(rs.getString("driver_id"));
			model.setDriver_name(rs.getString("driver_name"));
			model.setDate(rs.getString("date"));
			model.setMonth(rs.getString("month"));
			model.setYear(rs.getString("year"));
			model.setDays_present(rs.getString("days_present"));
			model.setTax(rs.getString("tax"));
			model.setBonus(rs.getString("bonus"));
			model.setOther(rs.getString("other"));
			model.setFine(rs.getString("fine"));
			model.setOvertime(rs.getString("overtime"));
			model.setSal_id(rs.getString("sal_id"));
			
			list.add(model);
			System.out.println("here");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;

}
public int update_salary_details(DriverModel drivermodel) {
	// TODO Auto-generated method stub
	int i=0;
	//int vehicle_id=Integer.parseInt(update_vehicle);
	String[] drv = drivermodel.getDriver_name().split("-");
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `driver_salary` SET `driver_id`=?, `driver_name`=?, `date`=?, `month`=?, `year`=?, `days_present`=?, `tax`=?, `bonus`=?, `other`=?, `fine`=?, `overtime`=? WHERE `sal_id`=?");
		
		pst.setString(1, drv[1]);
		pst.setString(2, drv[0]);
		pst.setString(3, drivermodel.getDate());
		pst.setString(4, drivermodel.getMonth());
		pst.setString(5, drivermodel.getYear());
		pst.setString(6, drivermodel.getDays_present());
		pst.setString(7, drivermodel.getTax());
		pst.setString(8, drivermodel.getBonus());
		pst.setString(9, drivermodel.getOther());
		pst.setString(10, drivermodel.getFine());
		pst.setString(11, drivermodel.getOvertime());
		pst.setString(12, drivermodel.getSal_id());
		
		
		
		i=pst.executeUpdate();
		System.out.println(pst);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
public int delete_salary_details(String sal_id) {
	// TODO Auto-generated method stub
	int c = 0;
	try {
		PreparedStatement pst = conn.prepareStatement("delete from driver_salary where sal_id='"+sal_id+"'");
		c = pst.executeUpdate();
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	return c;
}
public List<DriverModel> fetchSalaryGenerationEditDetails() {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	List<DriverModel> report = new ArrayList<DriverModel>();

	try {

		//System.out.println("model_bean");
		int sno = 1;
		//Connection connection = DaoHelper.getConnection1();
		
		
		PreparedStatement pst = conn
				.prepareStatement("select DISTINCT year,month  from salarygenerate  ");
		ResultSet resultSet1 = pst.executeQuery();

		//System.out.println("area........" + pst);

		while (resultSet1.next()) {
			DriverModel bean1 = new DriverModel();


			bean1.setMonth(resultSet1.getString("month"));
			

			// bean1.setScty_id(resultSet1.getString("societyname"));

			bean1.setYear(resultSet1.getString("year"));

			

			report.add(bean1);

			sno++;
			//System.out.println("area........" + sno);

		}

	} catch (Exception e) {
		// TODO: handle exception
	}

	//DaoHelper.closeConnection();

	return report;


}
public List<DriverModel> EditSalaryGenerate(DriverModel drivermodel) {
	// TODO Auto-generated method stub
	List<DriverModel> report = new ArrayList<DriverModel>();

	try {

		int mnth = 0;
		int mnth1 = 0;
		if (drivermodel.getMonth().equals("January")) {
			mnth = 0;
		}
		if (drivermodel.getMonth().equals("February")) {
			mnth = 1;
		}
		if (drivermodel.getMonth().equals("March")) {
			mnth = 2;
		}
		if (drivermodel.getMonth().equals("April")) {
			mnth = 3;
		}
		if (drivermodel.getMonth().equals("May")) {
			mnth = 4;
		}
		if (drivermodel.getMonth().equals("June")) {
			mnth = 5;
		}
		if (drivermodel.getMonth().equals("July")) {
			mnth = 6;
		}
		if (drivermodel.getMonth().equals("August")) {
			mnth = 7;
		}
		if (drivermodel.getMonth().equals("September")) {
			mnth = 8;
		}
		if (drivermodel.getMonth().equals("Ocotber")) {
			mnth = 9;
		}
		if (drivermodel.getMonth().equals("November")) {
			mnth = 10;
		}
		if (drivermodel.getMonth().equals("December")) {
			mnth = 11;
		}
		mnth1 = mnth + 1;
	int sno = 1;

	int gtotaldays = 0;
	Double tnet = 0.0;
	Double gtded = 0.0;
	Double gtgross = 0.0;
	Double gtbonus = 0.0;
	Double gtbbasic = 0.0;
	Double gtptax = 0.0;
	Double gtuniform = 0.0;
	Double gtroom = 0.0;
	Double gtadv = 0.0;
	Double gfine = 0.0;
	Double gother = 0.0;
	//Connection connection = DaoHelper.getConnection1();
	PreparedStatement pst1x11 = conn.prepareStatement("select *  from salarygenerate where year=? and month=?  ");
	pst1x11.setString(2, drivermodel.getMonth());

	pst1x11.setString(1, drivermodel.getYear());
	//System.out.println(pst1x11);
	ResultSet resultSet2x11 = pst1x11.executeQuery();

	if (resultSet2x11.next()) {
	int totaldays = 0;
	Double gross = 0.0;
	Double unf = 0.0;
	Double rm = 0.0;
	Double sadv = 0.0;
	Double net = 0.0;
	Double tded = 0.0;
	Double ptax = 0.0;
	Double fine = 0.0;
	Double other = 0.0;
	PreparedStatement pst1x11x = conn.prepareStatement("select *  from salarygenerate where year=? and month=?  ");
	pst1x11x.setString(2, drivermodel.getMonth());

	pst1x11x.setString(1, drivermodel.getYear());
	//System.out.println(pst1x11x);
	ResultSet resultSet2x11x = pst1x11x.executeQuery();

	while (resultSet2x11x.next()) {
		DriverModel bean1 = new DriverModel();
		bean1.setDriver_name(resultSet2x11x.getString("driver_name"));
		bean1.setDriver_id(resultSet2x11x.getString("driver_id"));
		//bean1.setEsign(resultSet2x11x.getString("empid"));
		bean1.setDays_present(resultSet2x11x.getString("days"));
		bean1.setBasic_salary(resultSet2x11x.getString("basic"));
		bean1.setSal_code(resultSet2x11x.getString("salary_code"));
		try {
			gtbbasic = gtbbasic + Double.parseDouble(resultSet2x11x.getString("basic"));
		} catch (Exception e) {
		}
		try {
			gtotaldays = gtotaldays + Integer.parseInt(resultSet2x11x.getString("days"));
		} catch (Exception e) {
		}
		bean1.setDate14x("" + String.format("%.2f", gtbbasic));
		bean1.setDate11x("" + gtotaldays);
	
		bean1.setBonus(resultSet2x11x.getString("bonus"));
	
	
	try {
		gross = (Double.parseDouble(resultSet2x11x.getString("gross")));
		
		gtgross = gtgross + Math.round(gross);
		gtbonus = gtbonus + Double.parseDouble(bean1.getBonus());
	} catch (Exception e) {

	}
	bean1.setDate12x("" + String.format("%.2f", gtgross));
	bean1.setGross("" + String.format("%.2f", gross));
	bean1.setDate13x("" + String.format("%.2f", gtbonus));
	
	
	bean1.setOvertime(resultSet2x11x.getString("overtime"));
	unf = resultSet2x11x.getDouble("overtime");
	gtuniform = gtuniform + unf;
	bean1.setDate16x("" + gtuniform);
	//bean1.setSupervisor(resultSet2x11x.getString("supervisor"));
	//bean1.setCard_no(resultSet2x11x.getString("cardno"));

	bean1.setFine(resultSet2x11x.getString("fine"));
						fine = resultSet2x11x.getDouble("fine");
						gfine = gfine + fine;
						bean1.setDate19x("" + gfine);
						
						
						bean1.setOther(resultSet2x11x.getString("other"));
						other = resultSet2x11x.getDouble("other");
						gother = gother + other;
						bean1.setDate20x("" + gother);


						//bean1.setRoom(resultSet2x11x.getString("room"));
						//rm = resultSet2x11x.getDouble("room");
						//gtroom = gtroom + rm;
						//bean1.setDate17x("" + gtroom);

						bean1.setAdvance(resultSet2x11x.getString("adv"));
						sadv = resultSet2x11x.getDouble("adv");
						gtadv = gtadv + sadv;
						bean1.setDate18x("" + gtadv);
						
						ptax=resultSet2x11x.getDouble("ptax");

						gtptax = gtptax + resultSet2x11x.getDouble("ptax");

				bean1.setDate15x("" + gtptax);
				bean1.setTax("" + ptax);
				
				
				try {
					if (gross > 0) {
						
						tded = resultSet2x11x.getDouble("tDed");
						net = resultSet2x11x.getDouble("net");
						tnet = tnet +  Math.round( net);
						gtded = gtded + (tded);
					}
				} catch (Exception e) {
				}
				bean1.setAge("" + String.format("%.2f", gtded));
				bean1.setArea("" + Math.round(tnet));
				bean1.setTot_net("" + Math.round(net));
				bean1.setTot_ded("" + String.format("%.2f", tded));
		
		
		bean1.setSr_no(sno);

		report.add(bean1);

		sno++;
	}
	
	}

	
	
} catch (Exception e) {
	// TODO: handle exception
}

//DaoHelper.closeConnection();

return report;
}
public String Salary_submit1(DriverModel drivermodel) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	String response = "";

	try {
		//System.out.println("Attendance Submit Dao.......");

		//Connection connection = DaoHelper.getConnection1();
/*
		PreparedStatement pst = connection.prepareStatement(
				"delete from salarygenerate where   month='" + bin.getMnth() + "' and year='" + bin.getYr() + "' ");

		int i = pst.executeUpdate();*/

		int length = drivermodel.getDriver_id1().length;

		//System.out.println("length" + bin.getEmp_name1().length);
		// //System.out.println("555555");

		for (int k = 0; k < drivermodel.getDriver_id1().length; k++) {
			//System.out.println("kkk" + bin.getEmp_name1()[k]);
			if (drivermodel.getDriver_name1()[k] != "") {

				//System.out.println("length" + bin.getEmp_name1().length);

				PreparedStatement pst1 = conn.prepareStatement(
"Update  salarygenerate set "
+ "date='"+SystemDateTime.CurrentDateTime()+"',year='"+drivermodel.getYear()+"',month='"+drivermodel.getMonth()+"'"
+ ",driver_id='"+drivermodel.getDriver_id1()[k]+"',driver_name='"+drivermodel.getDriver_name1()[k]+"',basic='"+drivermodel.getBasic_salary1()[k]+"'"
+ ",bonus='"+drivermodel.getBonus1()[k]+"',gross='"+drivermodel.getGross1()[k]+"',ptax='"+drivermodel.getTax1()[k]+"',overtime='"+drivermodel.getOvertime1()[k]+"'"
+ ",adv='"+drivermodel.getAdvance1()[k]+"',room='',pf='', other='"+drivermodel.getOther1()[k]+"'"
+ ",eSI='',tDed='"+drivermodel.getTot_ded1()[k]+"',net='"+drivermodel.getTot_net1()[k]+"',days='"+drivermodel.getDays_present1()[k]+"'"
+ ",fine='"+drivermodel.getFine1()[k]+"',supervisor='',cardno='' where salary_code='"+drivermodel.getSalary_code1()[k]+"' ");
				System.out.println("length" + pst1);
				

				pst1.executeUpdate();

				/*try {
					PreparedStatement pst3 = connection.prepareStatement("update emp_master set room_os=room_os-"
							+ bin.getRoom1()[k] + " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst3);
					int iz = pst3.executeUpdate();
				} catch (Exception e) {
				}
				try {
					PreparedStatement pst31 = connection
							.prepareStatement("update emp_master set salary_adv=salary_adv-" + bin.getAdv()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst31);
					int iz1 = pst31.executeUpdate();
				} catch (Exception e) {
				}
				try {
					PreparedStatement pst32 = connection
							.prepareStatement("update emp_master set uniform_os=uniform_os-" + bin.getUnif()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst32);
					int iz2 = pst32.executeUpdate();
				} catch (Exception e) {
				}*/

				//System.out.println(pst1);

				// //System.out.println("hsn name is......."+bin.getCity());
				response = "success";
			}
		}

	} catch (Exception e) {
		// TODO: handle exception
	}

	//DaoHelper.closeConnection();
	return response;


}
public List<DriverModel> salary_payment_search(DriverModel drivermodel) {
	// TODO Auto-generated method stub
	List<DriverModel> report = new ArrayList<DriverModel>();

	try {

		int mnth = 0;
		int mnth1 = 0;
		/*if (drivermodel.getMonth().equals("January")) {
			mnth = 0;
		}
		if (drivermodel.getMonth().equals("February")) {
			mnth = 1;
		}
		if (drivermodel.getMonth().equals("March")) {
			mnth = 2;
		}
		if (drivermodel.getMonth().equals("April")) {
			mnth = 3;
		}
		if (drivermodel.getMonth().equals("May")) {
			mnth = 4;
		}
		if (drivermodel.getMonth().equals("June")) {
			mnth = 5;
		}
		if (drivermodel.getMonth().equals("July")) {
			mnth = 6;
		}
		if (drivermodel.getMonth().equals("August")) {
			mnth = 7;
		}
		if (drivermodel.getMonth().equals("September")) {
			mnth = 8;
		}
		if (drivermodel.getMonth().equals("Ocotber")) {
			mnth = 9;
		}
		if (drivermodel.getMonth().equals("November")) {
			mnth = 10;
		}
		if (drivermodel.getMonth().equals("December")) {
			mnth = 11;
		}
		mnth1 = mnth + 1;*/
	int sno = 1;

	int gtotaldays = 0;
	Double tnet = 0.0;
	Double gtded = 0.0;
	Double gtgross = 0.0;
	Double gtbonus = 0.0;
	Double gtbbasic = 0.0;
	Double gtptax = 0.0;
	Double gtuniform = 0.0;
	Double gtroom = 0.0;
	Double gtadv = 0.0;
	Double gfine = 0.0;
	Double gother = 0.0;
	//Connection connection = DaoHelper.getConnection1();
	PreparedStatement pst1x11 = conn.prepareStatement("select *  from salarygenerate where year=? and month=?  ");
	pst1x11.setString(2, drivermodel.getMonth());

	pst1x11.setString(1, drivermodel.getYear());
	//System.out.println(pst1x11);
	ResultSet resultSet2x11 = pst1x11.executeQuery();

	if (resultSet2x11.next()) {
	int totaldays = 0;
	Double gross = 0.0;
	Double unf = 0.0;
	Double rm = 0.0;
	Double sadv = 0.0;
	Double net = 0.0;
	Double tded = 0.0;
	Double ptax = 0.0;
	Double fine = 0.0;
	Double other = 0.0;
	PreparedStatement pst1x11x = conn.prepareStatement("select *  from salarygenerate where year=? and month=?  ");
	pst1x11x.setString(2, drivermodel.getMonth());

	pst1x11x.setString(1, drivermodel.getYear());
	//System.out.println(pst1x11x);
	ResultSet resultSet2x11x = pst1x11x.executeQuery();
	
	System.out.println("pst1x11x: "+pst1x11x);

	while (resultSet2x11x.next()) {
		DriverModel bean1 = new DriverModel();
		bean1.setDriver_name(resultSet2x11x.getString("driver_name"));
		bean1.setDriver_id(resultSet2x11x.getString("driver_id"));
		//bean1.setEsign(resultSet2x11x.getString("empid"));
		bean1.setDays_present(resultSet2x11x.getString("days"));
		bean1.setBasic_salary(resultSet2x11x.getString("basic"));
		bean1.setSal_code(resultSet2x11x.getString("salary_code"));
		try {
			gtbbasic = gtbbasic + Double.parseDouble(resultSet2x11x.getString("basic"));
		} catch (Exception e) {
		}
		try {
			gtotaldays = gtotaldays + Integer.parseInt(resultSet2x11x.getString("days"));
		} catch (Exception e) {
		}
		bean1.setDate14x("" + String.format("%.2f", gtbbasic));
		bean1.setDate11x("" + gtotaldays);
	
		bean1.setBonus(resultSet2x11x.getString("bonus"));
	
	
	try {
		gross = (Double.parseDouble(resultSet2x11x.getString("gross")));
		
		gtgross = gtgross + Math.round(gross);
		gtbonus = gtbonus + Double.parseDouble(bean1.getBonus());
	} catch (Exception e) {

	}
	bean1.setDate12x("" + String.format("%.2f", gtgross));
	bean1.setGross("" + String.format("%.2f", gross));
	bean1.setDate13x("" + String.format("%.2f", gtbonus));
	
	
	bean1.setOvertime(resultSet2x11x.getString("overtime"));
	unf = resultSet2x11x.getDouble("overtime");
	gtuniform = gtuniform + unf;
	bean1.setDate16x("" + gtuniform);
	//bean1.setSupervisor(resultSet2x11x.getString("supervisor"));
	//bean1.setCard_no(resultSet2x11x.getString("cardno"));

	bean1.setFine(resultSet2x11x.getString("fine"));
						fine = resultSet2x11x.getDouble("fine");
						gfine = gfine + fine;
						bean1.setDate19x("" + gfine);
						
						
						bean1.setOther(resultSet2x11x.getString("other"));
						other = resultSet2x11x.getDouble("other");
						gother = gother + other;
						bean1.setDate20x("" + gother);


						//bean1.setRoom(resultSet2x11x.getString("room"));
						//rm = resultSet2x11x.getDouble("room");
						//gtroom = gtroom + rm;
						//bean1.setDate17x("" + gtroom);

						bean1.setAdvance(resultSet2x11x.getString("adv"));
						sadv = resultSet2x11x.getDouble("adv");
						gtadv = gtadv + sadv;
						bean1.setDate18x("" + gtadv);
						
						ptax=resultSet2x11x.getDouble("ptax");

						gtptax = gtptax + resultSet2x11x.getDouble("ptax");

				bean1.setDate15x("" + gtptax);
				bean1.setTax("" + ptax);
				
				
				try {
					if (gross > 0) {
						
						tded = resultSet2x11x.getDouble("tDed");
						net = resultSet2x11x.getDouble("net");
						tnet = tnet +  Math.round( net);
						gtded = gtded + (tded);
					}
				} catch (Exception e) {
				}
				bean1.setAge("" + String.format("%.2f", gtded));
				bean1.setArea("" + Math.round(tnet));
				bean1.setTot_net("" + Math.round(net));
				bean1.setTot_ded("" + String.format("%.2f", tded));
				bean1.setPaid_amt(resultSet2x11x.getString("paid_amt"));
		
		
		bean1.setSr_no(sno);

		report.add(bean1);

		sno++;
	}
	
	}

	
	
} catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}

//DaoHelper.closeConnection();

return report;

}
public String payment_submit(DriverModel drivermodel) {
	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	// TODO Auto-generated method stub

	String response = "";

	try {
		//System.out.println("Attendance Submit Dao.......");

		//Connection connection = DaoHelper.getConnection1();
/*
		PreparedStatement pst = connection.prepareStatement(
				"delete from salarygenerate where   month='" + bin.getMnth() + "' and year='" + bin.getYr() + "' ");

		int i = pst.executeUpdate();*/

		int length = drivermodel.getDriver_name1().length;

		//System.out.println("length" + bin.getEmp_name1().length);
		// //System.out.println("555555");

		for (int k = 0; k < drivermodel.getDriver_name1().length; k++) {
			//System.out.println("kkk" + bin.getEmp_name1()[k]);
			if (!drivermodel.getDriver_name1()[k].equals("") && !drivermodel.getDriver_name1()[k].equals("")) {

				//System.out.println("length" + bin.getEmp_name1().length);

				PreparedStatement pst1 = conn.prepareStatement(
						"Update  salarygenerate set paid_amt='"+drivermodel.getPaid_amt1()[k]+"' where salary_code='"+drivermodel.getSalary_code1()[k]+"' ");
				System.out.println("length" + pst1);
				

				pst1.executeUpdate();
				
				
				
				PreparedStatement pst1x11 = conn.prepareStatement("select *  from drivercreditdebit where Documentsno=? and type=?  ");
				pst1x11.setString(2, "Credit");

				pst1x11.setString(1, drivermodel.getSalary_code1()[k]);
				System.out.println(pst1x11);
				ResultSet resultSet2x11 = pst1x11.executeQuery();

				if (resultSet2x11.next()) {

					try {
						PreparedStatement pst9 = conn.prepareStatement("update drivercreditdebit set driver_id=?,Date=?,Remark=?,Typecode=?,Amount=?,Name=?,username=?,datetime=?,billno=?  where Documentsno=? and type=? ");
						pst9.setString(1, drivermodel.getDriver_id1()[k]);
						/*pst9.setString(2, CoreData.getDateFormatAsDb(SystemDateTime.CurrentDate()));*/
						pst9.setString(2, SystemDateTime.CurrentDateTime());
						
						pst9.setString(3, "Salary Payment");
						pst9.setString(4, "201");
						
						pst9.setString(5, drivermodel.getPaid_amt1()[k]);
						pst9.setString(6, drivermodel.getDriver_name1()[k]);
						
						pst9.setString(7, "");
						pst9.setString(8, SystemDateTime.CurrentDateTime());
						
						try {
							pst9.setString(9,"");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							pst9.setString(9,"");
							e1.printStackTrace();
						}
						pst9.setString(10, drivermodel.getSalary_code1()[k]);
						pst9.setString(11, "Credit");
						System.out.println(pst9);
						int k1 = pst9.executeUpdate();
					} catch (Exception e) {
					}
				
				}else {
					
					try {
						PreparedStatement pst9 = conn.prepareStatement("insert into drivercreditdebit(driver_id,Date,Documentsno,Remark,Typecode,type,Amount,Name,username,datetime,billno)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
						pst9.setString(1, drivermodel.getDriver_id1()[k]);
						pst9.setString(2, SystemDateTime.CurrentDateTime());
						pst9.setString(3, drivermodel.getSalary_code1()[k]);
						pst9.setString(4, "Salary Payment");
						pst9.setString(5, "201");
						pst9.setString(6, "Credit");
						pst9.setString(7, drivermodel.getPaid_amt1()[k]);
						pst9.setString(8, drivermodel.getDriver_name1()[k]);
						
						pst9.setString(9, "");
						pst9.setString(10, SystemDateTime.CurrentDateTime());
						
						try {
							pst9.setString(11,"");
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							pst9.setString(11,"");
							e1.printStackTrace();
						}
						System.out.println(pst9);
						int k1 = pst9.executeUpdate();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					
				}

				/*try {
					PreparedStatement pst3 = connection.prepareStatement("update emp_master set room_os=room_os-"
							+ bin.getRoom1()[k] + " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst3);
					int iz = pst3.executeUpdate();
				} catch (Exception e) {
				}
				try {
					PreparedStatement pst31 = connection
							.prepareStatement("update emp_master set salary_adv=salary_adv-" + bin.getAdv()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst31);
					int iz1 = pst31.executeUpdate();
				} catch (Exception e) {
				}
				try {
					PreparedStatement pst32 = connection
							.prepareStatement("update emp_master set uniform_os=uniform_os-" + bin.getUnif()[k]
									+ " where emp_id='" + bin.getEmp_id() + "'   ");
					//System.out.println(pst32);
					int iz2 = pst32.executeUpdate();
				} catch (Exception e) {
				}*/

				//System.out.println(pst1);

				// //System.out.println("hsn name is......."+bin.getCity());
				response = "success";
			}
		}

	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}

	//DaoHelper.closeConnection();
	return response;



}
}
