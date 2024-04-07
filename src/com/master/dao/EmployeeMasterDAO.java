package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.DesignationModel;
import com.master.model.DriverModel;
import com.master.model.EmployeeMasterModel;
import com.master.model.VehicleModel;

public class EmployeeMasterDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
	
	
	
	public int insert_employee_Details(EmployeeMasterModel employeeModel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			
			
			
			String stringValue6 = "";
			int len4 = 0;
			PreparedStatement preparedStatement5 = conn
					.prepareStatement("select  max(SUBSTRING(employee_id,-4)) as myval1 from employee_master");
			
			
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
				}
			}
			
			
			
			
			int size4 = len4 + 1;
			stringValue6 = String.valueOf(myval4);
			
				if (stringValue6.length() == 1) {
					stringValue6 = "HSL/EMP/" + "000" + stringValue6;
				} else if (stringValue6.length() == 2) {
					stringValue6 = "HSL/EMP/" + "00" + stringValue6;
				} else if (stringValue6.length() == 3) {
					stringValue6 = "HSL/EMP/" + "0" + stringValue6;
				} else {
					stringValue6 = "HSL/EMP/" + stringValue6;
				}
					
			
			
			
			
			
			PreparedStatement ps = conn.prepareStatement("select * from employee_master where name_of_employee = '"+employeeModel.getEmployee_name()+"'");
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				return -1;
			}
			
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `employee_master`(`name_of_employee`, `address`, `mobile_no`, `date_of_joining`, `date_of_birth`, `designation`, `bank_name`, `account_no`, `ifsc_code`, `remark`,`employee_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, employeeModel.getEmployee_name());
			pst.setString(2, employeeModel.getAddress());
			pst.setString(3, employeeModel.getMobile_no());
			pst.setString(4, employeeModel.getDate_of_joining());
			pst.setString(5, employeeModel.getDate_of_birth());
			pst.setString(6, employeeModel.getDesignation());
			pst.setString(7, employeeModel.getBank_name());
			pst.setString(8, employeeModel.getAccount_no());
			pst.setString(9, employeeModel.getIfsc_code());
			pst.setString(10,employeeModel.getRemark());
			pst.setString(11, stringValue6);
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	
	
	
	
	public List<EmployeeMasterModel> fetchEmployeeDetails(EmployeeMasterModel employeeModel) {
		// TODO Auto-generated method stub
		List<EmployeeMasterModel> list=new ArrayList<>();
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("SELECT `employee_id`, `name_of_employee`, `address`, `mobile_no`, `date_of_joining`, `date_of_birth`, `designation`, `bank_name`, `account_no`, `ifsc_code`, `remark` FROM `employee_master` WHERE 1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				EmployeeMasterModel empModel=new EmployeeMasterModel();
				empModel.setEmployee_id(rs.getInt(1));
				empModel.setEmployee_name(rs.getString(2));
				empModel.setAddress(rs.getString(3));
				empModel.setMobile_no(rs.getString(4));
				empModel.setDate_of_joining(rs.getString(5));
				empModel.setDate_of_birth(rs.getString(6));
				empModel.setDesignation(rs.getString(7));
				empModel.setBank_name(rs.getString(8));
				empModel.setAccount_no(rs.getString(9));
				empModel.setIfsc_code(rs.getString(10));
				empModel.setRemark(rs.getString(11));
				list.add(empModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int insert_driver_Details(DriverModel drivermodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			PreparedStatement pst = conn.prepareStatement("insert into `driver_master` (`driver_name`,  `driver_address_p`, `driver_address_c`, `contact_number`, `dob`, `age`, `salary_type`, `basic_salary`, `bank_name`, `account_no`, `ifsc_code`, `remark`, `experience`, `emergency_contact`, `driver_photo`, `aadhar_no`, `license_no`, `aadhar_photo`, `license_photo`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int insert_vehicle_Details(VehicleModel vehiclemodel) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			
			PreparedStatement pst = conn.prepareStatement("insert into `vehicle_master` (`vehicle_no`,  `vehicle_type`, `model`, `size`, `capacity`, `driver`, `road_tax_photo`, `fitness_tax_photo`, `permit_tax_photo`, `puc_photo`, `servicing_photo`, `insurance_photo`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1,  vehiclemodel.getVehicle_no());
			pst.setString(2,  vehiclemodel.getVehicle_type());
			pst.setString(3,  vehiclemodel.getModel());
			pst.setString(4,  vehiclemodel.getSize());
			pst.setString(5,  vehiclemodel.getCapacity());
			pst.setString(6,  vehiclemodel.getDriver());
			pst.setString(7,  vehiclemodel.getRoad_tax_photo());
			pst.setString(8,  vehiclemodel.getFitness_tax_photo());
			pst.setString(9,  vehiclemodel.getPermit_tax_photo());
			pst.setString(10,  vehiclemodel.getPuc_photo());
			pst.setString(11,  vehiclemodel.getServicing_photo());
			pst.setString(12,  vehiclemodel.getInsurance_photo());
			
			i=pst.executeUpdate();
			
			System.out.println("i:"+i+"pst:"+pst);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<EmployeeMasterModel> fetchForUpdateEmployeeDetailss(String employee_id) {
		// TODO Auto-generated method stub
		List<EmployeeMasterModel> list=new ArrayList<EmployeeMasterModel>();
		int emp_id = Integer.parseInt(employee_id);
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `employee_id`, `name_of_employee`, `address`, `mobile_no`, `date_of_joining`, `date_of_birth`, `designation`, `bank_name`, `account_no`, `ifsc_code`, `remark` from employee_master WHERE employee_id="+emp_id+"");
			ResultSet rs=pst.executeQuery();
			System.out.println("pst ---- "+pst);
			while(rs.next())
			{
				EmployeeMasterModel employeeModel=new EmployeeMasterModel();
				employeeModel.setEmployee_id(rs.getInt(1));
				employeeModel.setEmployee_name(rs.getString(2));
				employeeModel.setAddress(rs.getString(3));
				employeeModel.setMobile_no(rs.getString(4));
				employeeModel.setDate_of_joining(rs.getString(5));
				employeeModel.setDate_of_birth(rs.getString(6));
				employeeModel.setDesignation(rs.getString(7));
				employeeModel.setBank_name(rs.getString(8));
				employeeModel.setAccount_no(rs.getString(9));
				employeeModel.setIfsc_code(rs.getString(10));
				employeeModel.setRemark(rs.getString(11));
				
				list.add(employeeModel);
				System.out.println("here");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public int update_employee_details(EmployeeMasterModel employeeModel, String update_employee) {
		// TODO Auto-generated method stub
		int i=0;
		int employee_id=Integer.parseInt(update_employee);
		
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `employee_master` SET `name_of_employee`=?, `address`=?, `mobile_no`=?, `date_of_joining`=?, `date_of_birth`=?, `designation`=?, `bank_name`=?, `account_no`=?, `ifsc_code`=?, `remark`=?  WHERE `employee_id`=? ");
			
			pst.setString(1, employeeModel.getEmployee_name());
			pst.setString(2, employeeModel.getAddress());
			pst.setString(3, employeeModel.getMobile_no());
			pst.setString(4, employeeModel.getDate_of_joining());
			pst.setString(5, employeeModel.getDate_of_birth());
			pst.setString(6, employeeModel.getDesignation());
			pst.setString(7, employeeModel.getBank_name());
			pst.setString(8, employeeModel.getAccount_no());
			pst.setString(9, employeeModel.getIfsc_code());
			pst.setString(10, employeeModel.getRemark());
			pst.setInt(11, employee_id);
			
			
			
			
			i=pst.executeUpdate();
			System.out.println(pst);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public int deleteEmployee_master(String delete_employee_id) {
		
		int emp_id = Integer.parseInt(delete_employee_id);
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `employee_master` WHERE employee_id="+emp_id+"");
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


}
