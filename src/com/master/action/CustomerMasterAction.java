package com.master.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.login.loginModel.userinfo;
import com.master.Constants.Constants;
import com.master.dao.CityMasterDao;
import com.master.dao.CustomerMasterDAO;
import com.master.dao.DesignationMasterDao;
import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.ProductMasterDao;
import com.master.dao.RentalMasterDao;
import com.master.dao.TransporterMasterDao;
import com.master.dao.VehicleMasterDao;
import com.master.model.CityModel;
import com.master.model.CustomerMasterModel;
import com.master.model.DesignationModel;
import com.master.model.DriverModel;
import com.master.model.EmployeeMasterModel;
import com.master.model.ProductModel;
import com.master.model.RentalModel;
import com.master.model.TransporterModel;
import com.master.model.VehicleModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerMasterAction extends ActionSupport implements ModelDriven {

	private CustomerMasterModel customer_modal = new CustomerMasterModel();

	private CityModel city_modal = new CityModel();
	private DriverModel driver_model = new DriverModel();
	private VehicleModel vehicle_model = new VehicleModel();
	private RentalModel rental_model = new RentalModel();
	private String price;

	public VehicleModel getVehicle_model() {
		return vehicle_model;
	}

	public void setVehicle_model(VehicleModel vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	public DriverModel getDriver_model() {
		return driver_model;
	}

	public void setDriver_model(DriverModel driver_model) {
		this.driver_model = driver_model;
	}

	private ProductModel product_model = new ProductModel();

	public ProductModel getProduct_model() {
		return product_model;
	}

	public void setProduct_model(ProductModel product_model) {
		this.product_model = product_model;
	}

	public List<CityModel> getFetchCityDetails() {
		return fetchCityDetails;
	}

	public void setFetchCityDetails(List<CityModel> fetchCityDetails) {
		this.fetchCityDetails = fetchCityDetails;
	}

	public List<ProductModel> getProductMasterDetails() {
		return productMasterDetails;
	}

	public void setProductMasterDetails(List<ProductModel> productMasterDetails) {
		this.productMasterDetails = productMasterDetails;
	}

	private List<CustomerMasterModel> customerMasterDetails;

	private List<ProductModel> productMasterDetails;

	private List<ProductModel> expenseMasterDetails;

	private List<DesignationModel> designationMasterDetails;

	private List<TransporterModel> transporterMasterDetails;

	public List<TransporterModel> getTransporterMasterDetails() {
		return transporterMasterDetails;
	}

	public void setTransporterMasterDetails(List<TransporterModel> transporterMasterDetails) {
		this.transporterMasterDetails = transporterMasterDetails;
	}

	public List<DesignationModel> getDesignationMasterDetails() {
		return designationMasterDetails;
	}

	public void setDesignationMasterDetails(List<DesignationModel> designationMasterDetails) {
		this.designationMasterDetails = designationMasterDetails;
	}

	public List<ProductModel> getExpenseMasterDetails() {
		return expenseMasterDetails;
	}

	public void setExpenseMasterDetails(List<ProductModel> expenseMasterDetails) {
		this.expenseMasterDetails = expenseMasterDetails;
	}

	private List<CustomerMasterModel> fetchCustomerDetails;

	private List<CityModel> fetchCityDetails;
	
	private List <RentalModel> fetchRetalDetails;

	private List<DriverModel> fetchDriverDetails;

	private List<VehicleModel> fetchVehicleDetails;
	
	
	

	public RentalModel getRental_model() {
		return rental_model;
	}

	public void setRental_model(RentalModel rental_model) {
		this.rental_model = rental_model;
	}

	public List<RentalModel> getFetchRetalDetails() {
		return fetchRetalDetails;
	}

	public void setFetchRetalDetails(List<RentalModel> fetchRetalDetails) {
		this.fetchRetalDetails = fetchRetalDetails;
	}

	public List<RentalModel> getRentalMasterDetails() {
		return rentalMasterDetails;
	}

	public void setRentalMasterDetails(List<RentalModel> rentalMasterDetails) {
		this.rentalMasterDetails = rentalMasterDetails;
	}

	public List<VehicleModel> getFetchVehicleDetails() {
		return fetchVehicleDetails;
	}

	public void setFetchVehicleDetails(List<VehicleModel> fetchVehicleDetails) {
		this.fetchVehicleDetails = fetchVehicleDetails;
	}

	public List<DriverModel> getFetchDriverDetails() {
		return fetchDriverDetails;
	}

	public void setFetchDriverDetails(List<DriverModel> fetchDriverDetails) {
		this.fetchDriverDetails = fetchDriverDetails;
	}

	private List<ProductModel> fetchProductDetails;

	private List<DesignationModel> fetchDesignationDetails;

	private List<EmployeeMasterModel> fetchEmployeeDetails;

	private List<TransporterModel> fetchTransporterDetails;

	public List<TransporterModel> getFetchTransporterDetails() {
		return fetchTransporterDetails;
	}

	public void setFetchTransporterDetails(List<TransporterModel> fetchTransporterDetails) {
		this.fetchTransporterDetails = fetchTransporterDetails;
	}

	public List<EmployeeMasterModel> getFetchEmployeeDetails() {
		return fetchEmployeeDetails;
	}

	public void setFetchEmployeeDetails(List<EmployeeMasterModel> fetchEmployeeDetails) {
		this.fetchEmployeeDetails = fetchEmployeeDetails;
	}

	private List<ProductModel> fetchExpenseDetails;

	public List<ProductModel> getFetchExpenseDetails() {
		return fetchExpenseDetails;
	}

	public void setFetchExpenseDetails(List<ProductModel> fetchExpenseDetails) {
		this.fetchExpenseDetails = fetchExpenseDetails;
	}

	public List<DesignationModel> getFetchDesignationDetails() {
		return fetchDesignationDetails;
	}

	public void setFetchDesignationDetails(List<DesignationModel> fetchDesignationDetails) {
		this.fetchDesignationDetails = fetchDesignationDetails;
	}

	public List<ProductModel> getFetchProductDetails() {
		return fetchProductDetails;
	}

	public void setFetchProductDetails(List<ProductModel> fetchProductDetails) {
		this.fetchProductDetails = fetchProductDetails;
	}

	private List<RentalModel> rentalMasterDetails;

	private List<CityModel> cityMasterDetails;

	private List<CityModel> routeMasterDetails;

	private List<DriverModel> driverMasterDetails;

	private List<VehicleModel> vehicleMasterDetails;

	public List<DriverModel> getDriverMasterDetails() {
		return driverMasterDetails;
	}

	public void setDriverMasterDetails(List<DriverModel> driverMasterDetails) {
		this.driverMasterDetails = driverMasterDetails;
	}

	public List<VehicleModel> getVehicleMasterDetails() {
		return vehicleMasterDetails;
	}

	public void setVehicleMasterDetails(List<VehicleModel> vehicleMasterDetails) {
		this.vehicleMasterDetails = vehicleMasterDetails;
	}

	public CityModel getCity_modal() {
		return city_modal;
	}

	public void setCity_modal(CityModel city_modal) {
		this.city_modal = city_modal;
	}

	public List<CityModel> getRouteMasterDetails() {
		return routeMasterDetails;
	}

	public void setRouteMasterDetails(List<CityModel> routeMasterDetails) {
		this.routeMasterDetails = routeMasterDetails;
	}

	public List<CityModel> getCityMasterDetails() {
		return cityMasterDetails;
	}

	public void setCityMasterDetails(List<CityModel> cityMasterDetails) {
		this.cityMasterDetails = cityMasterDetails;
	}

	private String customer;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public List<CustomerMasterModel> getFetchCustomerDetails() {
		return fetchCustomerDetails;
	}

	public void setFetchCustomerDetails(List<CustomerMasterModel> fetchCustomerDetails) {
		this.fetchCustomerDetails = fetchCustomerDetails;
	}

	public CustomerMasterModel getCustomer_modal() {
		return customer_modal;
	}

	public void setCustomer_modal(CustomerMasterModel customer_modal) {
		this.customer_modal = customer_modal;
	}

	public String execute() {
		return "success";
	}

	public String fetchCustomerforautofilled() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String customer_no = request.getParameter("customer_no");

		customer = new CustomerMasterDAO().fetchCustomerforautofilled(customer_modal, customer_no);
		System.out.println("customer:" + customer);
		return "success";
	}

	public String insert_customer_master_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		int i = new CustomerMasterDAO().insert_customer_master_details(customer_modal);
		if (i > 0) {
			response = "success";
		} else if (i == -1) {
			response = "already";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchCustomerMasterDetails() {
		String response;
		customerMasterDetails = new CustomerMasterDAO().fetchCustomerMasterDetails(customer_modal);
		if (customerMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchCustDetails() {
		Map session = ActionContext.getContext().getSession();
		userinfo bean = new userinfo();
		bean = (userinfo) session.get(Constants.USER_PROFILE);

		HttpServletRequest request = ServletActionContext.getRequest();

		String name = request.getParameter("name");

		price = new CustomerMasterDAO().fetchCustDetails(name);

		// System.out.println("Value="+price);

		return "success";
	}

	public String fetchRentalMasterDetails() {
		String response;
		rentalMasterDetails = new RentalMasterDao().fetchRentalMasterDetails(rental_model);
		if (rentalMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchCityMasterDetails() {
		String response;
		cityMasterDetails = new CityMasterDao().fetchCityMasterDetails(city_modal);
		if (cityMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchRouteMasterDetails() {
		String response;
		routeMasterDetails = new CityMasterDao().fetchRouteMasterDetails(city_modal);
		System.out.println("Size -- -- - " + routeMasterDetails.size());
		if (routeMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchResourceMasterDetails() {
		String response;

		routeMasterDetails = new CityMasterDao().fetchResourceMasterDetails(city_modal);

		System.out.println("Size -- -- - " + routeMasterDetails.size());

		if (routeMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchDriverMasterDetails() {
		String response;
		driverMasterDetails = new DriverMasterDao().fetchDriverMasterDetails();
		System.out.println("Size -- -- - " + driverMasterDetails.size());
		if (driverMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchVehicleMasterDetails() {
		String response;
		vehicleMasterDetails = new VehicleMasterDao().fetchVehicleMasterDetails();
		System.out.println("Size -- -- - " + vehicleMasterDetails.size());
		if (vehicleMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchProductMasterDetails() {
		String response;
		productMasterDetails = new ProductMasterDao().fetchProductMasterDetails();
		if (productMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchExpenseMasterDetails() {
		String response;
		expenseMasterDetails = new ProductMasterDao().fetchExpenseMasterDetails();
		if (expenseMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchDesignationMasterDetails() {
		String response;
		designationMasterDetails = new DesignationMasterDao().fetchDesigantionMasterDetails();
		if (designationMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchTransporterMasterDetails() {
		String response;
		transporterMasterDetails = new TransporterMasterDao().fetchTransporterMasterDetails();
		if (transporterMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateCustomerDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String customer_id = request.getParameter("customer_id");

		fetchCustomerDetails = new CustomerMasterDAO().fetchForUpdateCustomerDetailss(customer_modal, customer_id);

		if (fetchCustomerDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateDriverDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String driver_id = request.getParameter("driver_id");

		fetchDriverDetails = new DriverMasterDao().fetchForUpdateDriverDetailss(driver_model, driver_id);

		for (DriverModel d : fetchDriverDetails) {
			System.out.println("Driver Name ---" + d.getDriver_name());
			System.out.println("Aadhar photo ---" + d.getAadhar_photo());
			System.out.println("Aadhar No  ---" + d.getAadhar_no());
			System.out.println("License No  ---" + d.getLicense_no());
		}

		System.out.println(fetchDriverDetails.size());

		if (fetchDriverDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateVehicleDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String vehicle_id = request.getParameter("vehicle_id");

		fetchVehicleDetails = new VehicleMasterDao().fetchForUpdateVehicleDetailss(vehicle_model, vehicle_id);

		System.out.println(fetchVehicleDetails.size());

		if (fetchVehicleDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateCityDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String city_id = request.getParameter("city_id");

		fetchCityDetails = new CityMasterDao().fetchForUpdateCityDetailss(city_modal, city_id);

		System.out.println(fetchCityDetails.size());

		if (fetchCityDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	
	public String fetchForUpdateRentalDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String rental_id = request.getParameter("rental_id");

		fetchRetalDetails = new RentalMasterDao().fetchForUpdateRentalDetailss(rental_model, rental_id);

		System.out.println(fetchRetalDetails.size());

		if (fetchCityDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateRouteDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String route_id = request.getParameter("route_id");

		fetchCityDetails = new CityMasterDao().fetchForUpdateRouteDetailss(city_modal, route_id);

		System.out.println(fetchCityDetails.size());

		if (fetchCityDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateProductDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String product_id = request.getParameter("product_id");

		fetchProductDetails = new ProductMasterDao().fetchForUpdateProductDetailss(product_model, product_id);

		System.out.println(fetchProductDetails.size());

		if (fetchProductDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateDesignationDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String designation_id = request.getParameter("designation_id");

		fetchDesignationDetails = new DesignationMasterDao().fetchForUpdateDesignationDetailss(designation_id);

		System.out.println(fetchDesignationDetails.size());

		if (fetchDesignationDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateExpenseDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String expense_id = request.getParameter("expense_id");

		fetchExpenseDetails = new ProductMasterDao().fetchForUpdateExpenseDetailss(expense_id);

		System.out.println(fetchExpenseDetails.size());

		if (fetchExpenseDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateEmployeeDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String employee_id = request.getParameter("employee_id");

		fetchEmployeeDetails = new EmployeeMasterDAO().fetchForUpdateEmployeeDetailss(employee_id);

		System.out.println(fetchEmployeeDetails.size());

		if (fetchEmployeeDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String fetchForUpdateTransporterDetailss() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String transporter_id = request.getParameter("transporter_id");

		fetchTransporterDetails = new TransporterMasterDao().fetchForUpdateTransporterDetailss(transporter_id);

		System.out.println(fetchTransporterDetails.size());

		if (fetchTransporterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String update_customer_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String update_customer = request.getParameter("update_customer_id");
		System.out.println("update:" + update_customer);
		int i = new CustomerMasterDAO().update_customer_details(customer_modal, update_customer);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}

	public String update_route_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String update_customer = request.getParameter("update_customer_id");
		System.out.println("update:" + update_customer);
		int i = new CustomerMasterDAO().update_customer_details(customer_modal, update_customer);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}

	public String update_product_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String update_customer = request.getParameter("update_customer_id");
		System.out.println("update:" + update_customer);
		int i = new CustomerMasterDAO().update_customer_details(customer_modal, update_customer);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}

	public String deleteCustomerMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_customer_id = request.getParameter("customer_id");

		int i = new CustomerMasterDAO().deleteCustomer_master(customer_modal, delete_customer_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteDriverMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_driver_id = request.getParameter("driver_id");
		System.out.println("Driver id : " + delete_driver_id);
		int i = new DriverMasterDao().deleteDriver_master(delete_driver_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteVehicleMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_vehicle_id = request.getParameter("vehicle_id");

		int i = new VehicleMasterDao().deleteVehicle_master(delete_vehicle_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteCityMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_city_id = request.getParameter("city_id");

		int i = new CityMasterDao().deleteCity_master(city_modal, delete_city_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	
	public String deleteRentalMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_rental_id = request.getParameter("rental_id");

		int i = new RentalMasterDao().delete_rental_master(rental_model, delete_rental_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	

	public String deleteRouteMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_route_id = request.getParameter("route_id");

		int i = new CityMasterDao().deleteRoute_master(city_modal, delete_route_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteProductMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_product_id = request.getParameter("product_id");

		int i = new ProductMasterDao().deleteProduct_master(product_model, delete_product_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteDesignationMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_designation_id = request.getParameter("designation_id");

		int i = new DesignationMasterDao().deleteDesignation_master(delete_designation_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteExpenseMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_expense_id = request.getParameter("expense_id");

		int i = new ProductMasterDao().deleteExpense_master(product_model, delete_expense_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteEmployeeMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_employee_id = request.getParameter("employee_id");

		int i = new EmployeeMasterDAO().deleteEmployee_master(delete_employee_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	public String deleteTransporterMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_transporter_id = request.getParameter("transporter_id");

		int i = new TransporterMasterDao().deleteTransporter_master(delete_transporter_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return customer_modal;
	}

	public List<CustomerMasterModel> getCustomerMasterDetails() {
		return customerMasterDetails;
	}

	public void setCustomerMasterDetails(List<CustomerMasterModel> customerMasterDetails) {
		this.customerMasterDetails = customerMasterDetails;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
