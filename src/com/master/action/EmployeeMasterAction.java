package com.master.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.DesignationMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.model.DriverModel;
import com.master.model.EmployeeMasterModel;
import com.master.model.VehicleModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeMasterAction extends ActionSupport implements ModelDriven{

	private EmployeeMasterModel employeeModel=new EmployeeMasterModel();
	
	
	
	private DriverModel drivermodel = new DriverModel();
	private VehicleModel vehiclemodel = new VehicleModel();
	
	

	
	public VehicleModel getVehiclemodel() {
		return vehiclemodel;
	}

	public void setVehiclemodel(VehicleModel vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}

	public DriverModel getDrivermodel() {
		return drivermodel;
	}

	public void setDrivermodel(DriverModel drivermodel) {
		this.drivermodel = drivermodel;
	}





	private List<EmployeeMasterModel> fetchEmployeeDetails;
	
	
	public EmployeeMasterModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeMasterModel employeeModel) {
		this.employeeModel = employeeModel;
	}

	public List<EmployeeMasterModel> getFetchEmployeeDetails() {
		return fetchEmployeeDetails;
	}

	public void setFetchEmployeeDetails(List<EmployeeMasterModel> fetchEmployeeDetails) {
		this.fetchEmployeeDetails = fetchEmployeeDetails;
	}

	public String insert_employee_details()
	{
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_employee_Details(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
		if(i==-1)
		{
			return "already";
		}
		
		
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
	
	
	
	
	public String insert_driver_details()
	{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		System.out.println(drivermodel.getDriver_name());
		
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_driver_Details(drivermodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
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
	
	
	
	
	
	
	
	public String insert_vehicle_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_vehicle_Details(vehiclemodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
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
	
	
	
	
	
	
	
	
	/*public String insert_city_details()
	{
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_city_Details(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}*/
	
	
	
	
	
	
	
	
	public String insert_route_details()
	{
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_employee_Details(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
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
	
	
	
	public String insert_product_details()
	{
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_employee_Details(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
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
	
	
	public String insert_transport_details()
	{
		String response;
		int i = 0;
		try {
			i=new EmployeeMasterDAO().insert_employee_Details(employeeModel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String fetchEmployeeDetails()
	{
		String response;
		fetchEmployeeDetails=new EmployeeMasterDAO().fetchEmployeeDetails(employeeModel);
		System.out.println("fetchEmployeeDetails:"+fetchEmployeeDetails.size());
		if(fetchEmployeeDetails!=null)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String execute()
	{
		return "success";
	}
	
	
	public String driverMaster() {
		
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);
		
		
		System.out.println("Username::"+bean.getUsername());
		
		
		return "success";
	}
	
	public String vehicleMaster() {
		return "success";
	}
	public String cityMaster() {
		return "success";
	}
	
	public String routeMaster() {
		return "success";
	}
	public String productMaster() {
		return "success";
	}
	public String transportMaster() {
		return "success";
	}
	
	public String expenseMaster() {
		return "success";
	}
	
	public String update_employee_details()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_employee=request.getParameter("employee_id");
		System.out.println("update:"+update_employee);
		
		System.out.println("employee name : "+employeeModel.getEmployee_name());
		int i=new EmployeeMasterDAO().update_employee_details(employeeModel,update_employee);
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
	
	
	
	
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return employeeModel;
	}

	
}
