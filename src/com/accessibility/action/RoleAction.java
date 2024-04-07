package com.accessibility.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.Factory.ServiceFactory;
import com.Service.RoleService;
import com.ValuesToBean.RoleActionToRoleBean;
import com.master.Constants.Constants;
import com.login.loginModel.userinfo;

import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725869288211208449L;

	private Map session;
	
	private String zones;
	private String offices;
	private String departments;
	private String users;
	private String city_name;
	private String role_name;

	
	 private boolean new_role_action;
	 private boolean role;
	 private boolean Newuser;
	 private boolean ChangePass;
	 
	 
	 private boolean Role_Action;
	 private boolean dashboard;
	 private boolean CreateRole;
	 
	
	
	private boolean report1;
	

	private boolean report2;
	private boolean report3;
	
	private boolean report4;
	private boolean report5;
	
	private boolean report6;
	private boolean report7;
	private boolean report8;
	
	private boolean report9;
	private boolean report10;
	
	
	
	private boolean graph_report1;
	private boolean graph_report2;
	private boolean graph_report3;
	
	private boolean graph_report4;
	private boolean graph_report5;
	
	private boolean graph_report6;
	private boolean graph_report7;
	private boolean graph_report8;
	
	private boolean graph_report9;
	
	private boolean graph_report10;
	
	
	
	
	
	
	
	private boolean ProductMasterReport;
	private boolean PacketConfigMasterReport;
	private boolean BagConfigMasterReport;
	
	private boolean SchemeMasterReport;
	private boolean CityMasterReport;
	private boolean RouteMasterReport;
	
	private boolean VehicleTypeMasterReport;
	private boolean TransportMasterReport;
	private boolean  VehicleMasterReport;
	
	private boolean DriverMasterReport;
	private boolean DestributorMasterReport;
	private boolean EmployeeMasterReport;
	
	private boolean TaxMasterReport;
	private boolean HsnMasterReport;
	private boolean Inward;
	private boolean Warehouse_Ledger;
	
	private boolean Despatch_Ledger;
	
	public boolean isWarehouse_Ledger() {
		return Warehouse_Ledger;
	}



	public boolean isDespatch_Ledger() {
		return Despatch_Ledger;
	}



	public void setDespatch_Ledger(boolean despatch_Ledger) {
		Despatch_Ledger = despatch_Ledger;
	}



	public void setWarehouse_Ledger(boolean warehouse_Ledger) {
		Warehouse_Ledger = warehouse_Ledger;
	}



	private boolean RequisitionReport;
	private boolean PktToBag;
	private boolean BagToParcel;
	
	private boolean StockTransferReport;
	private boolean Scrap;
	private boolean ScrapReport;
	
	private boolean ClosingForm;
	private boolean StockReport;
	private boolean Order;
	
	private boolean OrderReport;
	private boolean OrderApproveReport;
	private boolean OrderLoadDoneReport;
	
	
	private boolean DeliveryReport;
	private boolean PaymentDoneReport;
	private boolean OrderDespatchReport;
	
	private boolean Requisition;
	private boolean RequisitionReceiveReport;
	private boolean DespatchClosingForm;
	
	private boolean MaterialReturn;
	private boolean PriceLevel;
	private boolean PriceLevelReport;
	
	private boolean RateHistoryReport;
	private boolean OrderReportAccount;
	private boolean BillReport;
	
	private boolean BillApproveReport;
	private boolean DeliveryDoneReport;
	private boolean cup;
	
	private boolean Customer_Os;
	private boolean CpReport;
	private boolean custcreditnote;
	
	private boolean custcdreport;
	private boolean Customer_Credit_Advance_Reportv;
	private boolean Transport_Credit_Advance_Reportv;
	
	private boolean ExpiryReport;
	private boolean RequisitionCancelReport;
	private boolean OrderCancelReport;
	
	private boolean ClosingAnalysis;
	private boolean ClosingReport;
	private boolean ClosingRequestReport;
	private boolean ClosingDifferenceReport;
	
	private boolean DistrictMasterReport;
	private boolean TahsilMasterReport;
	
	private boolean SpecialOrderReport;
	private boolean OrderSpecialHistory;
	private boolean RequisitionHistory;
	
	
	
	
	
	
	
	
	
	
	private boolean Stocktronfreport;
	private boolean whstocktransfor;
	
	private boolean orderplanningform;
	private boolean productionplanningreport;
	private boolean orderplanningreport;
	
	
	private boolean dispatchstocktransferform;
	private boolean requisitionreport;
	
	private boolean dcReport;
	
	private boolean RoleMasterReport;
	private boolean RoleReport;
	private boolean adduserProductMasterReport;
	
	private boolean Enquiry;
	private boolean EnquiryReport;
	private boolean PricingReport;
	private boolean QuotationReport;
	private boolean ReviseQuotationReport;
	private boolean PricingReport1;
	
	private boolean lr_Reports;
	private boolean delivery_done_Reports1;
	private boolean InvoiceReport;
	private boolean PI_done_Reports1;
	private boolean pi_InvoiceReport;
	private boolean newlr_Reports;
	private boolean customer_master_Reports;
	private boolean city_master_Reports;
	private boolean route_master_Reports;
	private boolean product_master_Reports;
	private boolean driver_master_Reports;
	private boolean vehicle_master_Reports;
	private boolean transport_master_Reports;
	private boolean expense_master_Reports;
	private boolean EmployeeReports;
	private boolean designation_master_Reports;
	
	private boolean ResourceTypeMasterReport;
	private boolean ReasonTypeMasterReport;
	private boolean expense_form;
	private boolean Amount_issue;
	private boolean Amount_issue_Reports;
	private boolean expense_Reports1;
	private boolean Transporter_Credit_Advance_Reportv;
	
	private boolean Supervisor_Credit_Advance_Reportv;
	private boolean Daily_Cash_Advance_Reportv;
	private boolean Escalation_Advance_Reportv;
	private boolean Customer_Credit_Advance_Reportv123;
	private boolean creditdebitnote_Credit_Advance_Reportv;
	
	private boolean supcdreport;
	private boolean transporter_payment;
	private boolean customer_payment;
	private boolean transporter_payment_report;
	private boolean customer_payment_report;
	private boolean transporter_outstanding_report;
	private boolean customer_outstanding_report;
	private boolean resource_enquiry_graph;
	private boolean resource_enquiry_graph1;
	private boolean order_lost_graph;
	private boolean monthly_business_graph;
	private boolean business_graph;
	private boolean exim_graph;
	private boolean exim_graph1;
	private boolean exim_graph123;
	private boolean AlertForm;
	private boolean AlertReport;
	private boolean AlertDoneReport;
	private boolean AlertExpectedReport;
	private boolean PriceCheckForm123;
	private boolean PriceCheckReport123;
	
	private boolean VendorBillReport;
	private boolean DeliveryAlertReport;
	private boolean PriceCheckForm;
	private boolean PriceCheckReport;
	private boolean CompanyContactReport;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isRoleMasterReport() {
		return RoleMasterReport;
	}



	public void setRoleMasterReport(boolean roleMasterReport) {
		RoleMasterReport = roleMasterReport;
	}



	public boolean isRoleReport() {
		return RoleReport;
	}



	public void setRoleReport(boolean roleReport) {
		RoleReport = roleReport;
	}



	public boolean isAdduserProductMasterReport() {
		return adduserProductMasterReport;
	}



	public void setAdduserProductMasterReport(boolean adduserProductMasterReport) {
		this.adduserProductMasterReport = adduserProductMasterReport;
	}



	public boolean isEnquiry() {
		return Enquiry;
	}



	public void setEnquiry(boolean enquiry) {
		Enquiry = enquiry;
	}



	public boolean isEnquiryReport() {
		return EnquiryReport;
	}



	public void setEnquiryReport(boolean enquiryReport) {
		EnquiryReport = enquiryReport;
	}



	public boolean isPricingReport() {
		return PricingReport;
	}



	public void setPricingReport(boolean pricingReport) {
		PricingReport = pricingReport;
	}



	public boolean isQuotationReport() {
		return QuotationReport;
	}



	public void setQuotationReport(boolean quotationReport) {
		QuotationReport = quotationReport;
	}



	public boolean isReviseQuotationReport() {
		return ReviseQuotationReport;
	}



	public void setReviseQuotationReport(boolean reviseQuotationReport) {
		ReviseQuotationReport = reviseQuotationReport;
	}



	public boolean isPricingReport1() {
		return PricingReport1;
	}



	public void setPricingReport1(boolean pricingReport1) {
		PricingReport1 = pricingReport1;
	}



	public boolean isLr_Reports() {
		return lr_Reports;
	}



	public void setLr_Reports(boolean lr_Reports) {
		this.lr_Reports = lr_Reports;
	}



	public boolean isDelivery_done_Reports1() {
		return delivery_done_Reports1;
	}



	public void setDelivery_done_Reports1(boolean delivery_done_Reports1) {
		this.delivery_done_Reports1 = delivery_done_Reports1;
	}



	public boolean isInvoiceReport() {
		return InvoiceReport;
	}



	public void setInvoiceReport(boolean invoiceReport) {
		InvoiceReport = invoiceReport;
	}



	public boolean isPI_done_Reports1() {
		return PI_done_Reports1;
	}



	public void setPI_done_Reports1(boolean pI_done_Reports1) {
		PI_done_Reports1 = pI_done_Reports1;
	}



	public boolean isPi_InvoiceReport() {
		return pi_InvoiceReport;
	}



	public void setPi_InvoiceReport(boolean pi_InvoiceReport) {
		this.pi_InvoiceReport = pi_InvoiceReport;
	}



	public boolean isNewlr_Reports() {
		return newlr_Reports;
	}



	public void setNewlr_Reports(boolean newlr_Reports) {
		this.newlr_Reports = newlr_Reports;
	}



	public boolean isCustomer_master_Reports() {
		return customer_master_Reports;
	}



	public void setCustomer_master_Reports(boolean customer_master_Reports) {
		this.customer_master_Reports = customer_master_Reports;
	}



	public boolean isCity_master_Reports() {
		return city_master_Reports;
	}



	public void setCity_master_Reports(boolean city_master_Reports) {
		this.city_master_Reports = city_master_Reports;
	}



	public boolean isRoute_master_Reports() {
		return route_master_Reports;
	}



	public void setRoute_master_Reports(boolean route_master_Reports) {
		this.route_master_Reports = route_master_Reports;
	}



	public boolean isProduct_master_Reports() {
		return product_master_Reports;
	}



	public void setProduct_master_Reports(boolean product_master_Reports) {
		this.product_master_Reports = product_master_Reports;
	}



	public boolean isDriver_master_Reports() {
		return driver_master_Reports;
	}



	public void setDriver_master_Reports(boolean driver_master_Reports) {
		this.driver_master_Reports = driver_master_Reports;
	}



	public boolean isVehicle_master_Reports() {
		return vehicle_master_Reports;
	}



	public void setVehicle_master_Reports(boolean vehicle_master_Reports) {
		this.vehicle_master_Reports = vehicle_master_Reports;
	}



	public boolean isTransport_master_Reports() {
		return transport_master_Reports;
	}



	public void setTransport_master_Reports(boolean transport_master_Reports) {
		this.transport_master_Reports = transport_master_Reports;
	}



	public boolean isExpense_master_Reports() {
		return expense_master_Reports;
	}



	public void setExpense_master_Reports(boolean expense_master_Reports) {
		this.expense_master_Reports = expense_master_Reports;
	}



	public boolean isEmployeeReports() {
		return EmployeeReports;
	}



	public void setEmployeeReports(boolean employeeReports) {
		EmployeeReports = employeeReports;
	}



	public boolean isDesignation_master_Reports() {
		return designation_master_Reports;
	}



	public void setDesignation_master_Reports(boolean designation_master_Reports) {
		this.designation_master_Reports = designation_master_Reports;
	}



	public boolean isResourceTypeMasterReport() {
		return ResourceTypeMasterReport;
	}



	public void setResourceTypeMasterReport(boolean resourceTypeMasterReport) {
		ResourceTypeMasterReport = resourceTypeMasterReport;
	}



	public boolean isReasonTypeMasterReport() {
		return ReasonTypeMasterReport;
	}



	public void setReasonTypeMasterReport(boolean reasonTypeMasterReport) {
		ReasonTypeMasterReport = reasonTypeMasterReport;
	}



	public boolean isExpense_form() {
		return expense_form;
	}



	public void setExpense_form(boolean expense_form) {
		this.expense_form = expense_form;
	}



	public boolean isAmount_issue() {
		return Amount_issue;
	}



	public void setAmount_issue(boolean amount_issue) {
		Amount_issue = amount_issue;
	}



	public boolean isAmount_issue_Reports() {
		return Amount_issue_Reports;
	}



	public void setAmount_issue_Reports(boolean amount_issue_Reports) {
		Amount_issue_Reports = amount_issue_Reports;
	}



	public boolean isExpense_Reports1() {
		return expense_Reports1;
	}



	public void setExpense_Reports1(boolean expense_Reports1) {
		this.expense_Reports1 = expense_Reports1;
	}



	public boolean isTransporter_Credit_Advance_Reportv() {
		return Transporter_Credit_Advance_Reportv;
	}



	public void setTransporter_Credit_Advance_Reportv(boolean transporter_Credit_Advance_Reportv) {
		Transporter_Credit_Advance_Reportv = transporter_Credit_Advance_Reportv;
	}



	public boolean isSupervisor_Credit_Advance_Reportv() {
		return Supervisor_Credit_Advance_Reportv;
	}



	public void setSupervisor_Credit_Advance_Reportv(boolean supervisor_Credit_Advance_Reportv) {
		Supervisor_Credit_Advance_Reportv = supervisor_Credit_Advance_Reportv;
	}



	public boolean isDaily_Cash_Advance_Reportv() {
		return Daily_Cash_Advance_Reportv;
	}



	public void setDaily_Cash_Advance_Reportv(boolean daily_Cash_Advance_Reportv) {
		Daily_Cash_Advance_Reportv = daily_Cash_Advance_Reportv;
	}



	public boolean isEscalation_Advance_Reportv() {
		return Escalation_Advance_Reportv;
	}



	public void setEscalation_Advance_Reportv(boolean escalation_Advance_Reportv) {
		Escalation_Advance_Reportv = escalation_Advance_Reportv;
	}



	public boolean isCustomer_Credit_Advance_Reportv123() {
		return Customer_Credit_Advance_Reportv123;
	}



	public void setCustomer_Credit_Advance_Reportv123(boolean customer_Credit_Advance_Reportv123) {
		Customer_Credit_Advance_Reportv123 = customer_Credit_Advance_Reportv123;
	}



	public boolean isCreditdebitnote_Credit_Advance_Reportv() {
		return creditdebitnote_Credit_Advance_Reportv;
	}



	public void setCreditdebitnote_Credit_Advance_Reportv(boolean creditdebitnote_Credit_Advance_Reportv) {
		this.creditdebitnote_Credit_Advance_Reportv = creditdebitnote_Credit_Advance_Reportv;
	}



	public boolean isSupcdreport() {
		return supcdreport;
	}



	public void setSupcdreport(boolean supcdreport) {
		this.supcdreport = supcdreport;
	}



	public boolean isTransporter_payment() {
		return transporter_payment;
	}



	public void setTransporter_payment(boolean transporter_payment) {
		this.transporter_payment = transporter_payment;
	}



	public boolean isCustomer_payment() {
		return customer_payment;
	}



	public void setCustomer_payment(boolean customer_payment) {
		this.customer_payment = customer_payment;
	}



	public boolean isTransporter_payment_report() {
		return transporter_payment_report;
	}



	public void setTransporter_payment_report(boolean transporter_payment_report) {
		this.transporter_payment_report = transporter_payment_report;
	}



	public boolean isCustomer_payment_report() {
		return customer_payment_report;
	}



	public void setCustomer_payment_report(boolean customer_payment_report) {
		this.customer_payment_report = customer_payment_report;
	}



	public boolean isTransporter_outstanding_report() {
		return transporter_outstanding_report;
	}



	public void setTransporter_outstanding_report(boolean transporter_outstanding_report) {
		this.transporter_outstanding_report = transporter_outstanding_report;
	}



	public boolean isCustomer_outstanding_report() {
		return customer_outstanding_report;
	}



	public void setCustomer_outstanding_report(boolean customer_outstanding_report) {
		this.customer_outstanding_report = customer_outstanding_report;
	}



	public boolean isResource_enquiry_graph() {
		return resource_enquiry_graph;
	}



	public void setResource_enquiry_graph(boolean resource_enquiry_graph) {
		this.resource_enquiry_graph = resource_enquiry_graph;
	}



	public boolean isResource_enquiry_graph1() {
		return resource_enquiry_graph1;
	}



	public void setResource_enquiry_graph1(boolean resource_enquiry_graph1) {
		this.resource_enquiry_graph1 = resource_enquiry_graph1;
	}



	public boolean isOrder_lost_graph() {
		return order_lost_graph;
	}



	public void setOrder_lost_graph(boolean order_lost_graph) {
		this.order_lost_graph = order_lost_graph;
	}



	public boolean isMonthly_business_graph() {
		return monthly_business_graph;
	}



	public void setMonthly_business_graph(boolean monthly_business_graph) {
		this.monthly_business_graph = monthly_business_graph;
	}



	public boolean isBusiness_graph() {
		return business_graph;
	}



	public void setBusiness_graph(boolean business_graph) {
		this.business_graph = business_graph;
	}



	public boolean isExim_graph() {
		return exim_graph;
	}



	public void setExim_graph(boolean exim_graph) {
		this.exim_graph = exim_graph;
	}



	public boolean isExim_graph1() {
		return exim_graph1;
	}



	public void setExim_graph1(boolean exim_graph1) {
		this.exim_graph1 = exim_graph1;
	}



	public boolean isExim_graph123() {
		return exim_graph123;
	}



	public void setExim_graph123(boolean exim_graph123) {
		this.exim_graph123 = exim_graph123;
	}



	public boolean isAlertForm() {
		return AlertForm;
	}



	public void setAlertForm(boolean alertForm) {
		AlertForm = alertForm;
	}



	public boolean isAlertReport() {
		return AlertReport;
	}



	public void setAlertReport(boolean alertReport) {
		AlertReport = alertReport;
	}



	public boolean isAlertDoneReport() {
		return AlertDoneReport;
	}



	public void setAlertDoneReport(boolean alertDoneReport) {
		AlertDoneReport = alertDoneReport;
	}



	public boolean isAlertExpectedReport() {
		return AlertExpectedReport;
	}



	public void setAlertExpectedReport(boolean alertExpectedReport) {
		AlertExpectedReport = alertExpectedReport;
	}



	public boolean isPriceCheckForm123() {
		return PriceCheckForm123;
	}



	public void setPriceCheckForm123(boolean priceCheckForm123) {
		PriceCheckForm123 = priceCheckForm123;
	}



	public boolean isPriceCheckReport123() {
		return PriceCheckReport123;
	}



	public void setPriceCheckReport123(boolean priceCheckReport123) {
		PriceCheckReport123 = priceCheckReport123;
	}



	public boolean isVendorBillReport() {
		return VendorBillReport;
	}



	public void setVendorBillReport(boolean vendorBillReport) {
		VendorBillReport = vendorBillReport;
	}



	public boolean isDeliveryAlertReport() {
		return DeliveryAlertReport;
	}



	public void setDeliveryAlertReport(boolean deliveryAlertReport) {
		DeliveryAlertReport = deliveryAlertReport;
	}



	public boolean isPriceCheckForm() {
		return PriceCheckForm;
	}



	public void setPriceCheckForm(boolean priceCheckForm) {
		PriceCheckForm = priceCheckForm;
	}



	public boolean isPriceCheckReport() {
		return PriceCheckReport;
	}



	public void setPriceCheckReport(boolean priceCheckReport) {
		PriceCheckReport = priceCheckReport;
	}



	public boolean isCompanyContactReport() {
		return CompanyContactReport;
	}



	public void setCompanyContactReport(boolean companyContactReport) {
		CompanyContactReport = companyContactReport;
	}



	public boolean isDcReport() {
		return dcReport;
	}



	public void setDcReport(boolean dcReport) {
		this.dcReport = dcReport;
	}



	public boolean isStocktronfreport() {
		return Stocktronfreport;
	}



	public void setStocktronfreport(boolean stocktronfreport) {
		Stocktronfreport = stocktronfreport;
	}



	public boolean isWhstocktransfor() {
		return whstocktransfor;
	}



	public void setWhstocktransfor(boolean whstocktransfor) {
		this.whstocktransfor = whstocktransfor;
	}



	public boolean isOrderplanningform() {
		return orderplanningform;
	}



	public void setOrderplanningform(boolean orderplanningform) {
		this.orderplanningform = orderplanningform;
	}



	public boolean isProductionplanningreport() {
		return productionplanningreport;
	}



	public void setProductionplanningreport(boolean productionplanningreport) {
		this.productionplanningreport = productionplanningreport;
	}



	public boolean isOrderplanningreport() {
		return orderplanningreport;
	}



	public void setOrderplanningreport(boolean orderplanningreport) {
		this.orderplanningreport = orderplanningreport;
	}



	public boolean isDispatchstocktransferform() {
		return dispatchstocktransferform;
	}



	public void setDispatchstocktransferform(boolean dispatchstocktransferform) {
		this.dispatchstocktransferform = dispatchstocktransferform;
	}



	public boolean isRequisitionreport() {
		return requisitionreport;
	}



	public void setRequisitionreport(boolean requisitionreport) {
		this.requisitionreport = requisitionreport;
	}



	private boolean Production;
	private boolean ProductionReport;
	private boolean VehicleAssignReport;
 
	
	private boolean RequisitionHistoryDespatch;
	private boolean DestributorBillWiseOs;
	private boolean DestributorSalesItemWise;
	
	
	
	
	private boolean AllorderReport;
	private boolean OrderAlertReport;
	private boolean OrderStatusReport;
	
	private boolean OrderCountReport;
	private boolean DistributorHistory;
	private boolean OrderProductReport;
	
	
	
	private boolean SalesRegister;
	private boolean DayReport;
	private boolean EscalationReport;
	
	private boolean ReqHistory;
	
	private boolean Graph1;
	private boolean Graph2;
	
	private boolean Graph3;
	private boolean Graph4;
	
	private boolean Graph5;
	private boolean Graph6;
	
	private boolean Graph7;
	private boolean Graph8;
	
	private boolean Graph9;
	private boolean Graph10;
	
	private boolean Graph11;
	private boolean Graph12;
	
	
	public Map getSession() {
		return session;
	}

	
	
	public void setSession(Map session) {
		this.session = session;
	}


	
	
	public String execute() throws SQLException {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		
		RoleService roleservice = factory.getRoleService();
			
		new RoleActionToRoleBean().setvalues(this);

		userinfo lb = (userinfo) session.get(Constants.USER_PROFILE);
		
		int status = roleservice.roleService(this, lb);
		
		if (status == 1) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	
	
	
	/*public String execute1() throws SQLException {
		
		ServiceFactory factory = ServiceFactory.getInstance();
		
		RoleService roleservice = factory.getRoleService();
		
		
		new RoleActionToRoleBean().setvalues1(this);
		
		LoginBean lb = (LoginBean) session.get(Constants.USER_PROFILE);
		
		int status = roleservice.roleService1(this, lb);
		
		if (status == 1) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	*/
	
	
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public String getZones() {
		return zones;
	}

	public void setZones(String zones) {
		this.zones = zones;
	}

	public String getOffices() {
		return offices;
	}

	public void setOffices(String offices) {
		this.offices = offices;
	}

	public String getDepartments() {
		return departments;
	}

	public void setDepartments(String departments) {
		this.departments = departments;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public boolean isNew_role_action() {
		return new_role_action;
	}

	public void setNew_role_action(boolean new_role_action) {
		this.new_role_action = new_role_action;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public boolean isNewuser() {
		return Newuser;
	}

	public void setNewuser(boolean newuser) {
		Newuser = newuser;
	}

	public boolean isChangePass() {
		return ChangePass;
	}

	public void setChangePass(boolean changePass) {
		ChangePass = changePass;
	}



	


	public boolean isReport1() {
		return report1;
	}



	public void setReport1(boolean report1) {
		this.report1 = report1;
	}



	public boolean isReport2() {
		return report2;
	}



	public void setReport2(boolean report2) {
		this.report2 = report2;
	}



	public boolean isReport3() {
		return report3;
	}



	public void setReport3(boolean report3) {
		this.report3 = report3;
	}



	public boolean isReport4() {
		return report4;
	}



	public void setReport4(boolean report4) {
		this.report4 = report4;
	}



	public boolean isReport5() {
		return report5;
	}



	public void setReport5(boolean report5) {
		this.report5 = report5;
	}



	public boolean isReport6() {
		return report6;
	}



	public void setReport6(boolean report6) {
		this.report6 = report6;
	}



	public boolean isReport7() {
		return report7;
	}



	public void setReport7(boolean report7) {
		this.report7 = report7;
	}



	public boolean isReport8() {
		return report8;
	}



	public void setReport8(boolean report8) {
		this.report8 = report8;
	}



	public boolean isReport9() {
		return report9;
	}



	public void setReport9(boolean report9) {
		this.report9 = report9;
	}



	public boolean isReport10() {
		return report10;
	}



	public void setReport10(boolean report10) {
		this.report10 = report10;
	}



	



	public boolean isGraph_report1() {
		return graph_report1;
	}



	public void setGraph_report1(boolean graph_report1) {
		this.graph_report1 = graph_report1;
	}



	public boolean isGraph_report2() {
		return graph_report2;
	}



	public void setGraph_report2(boolean graph_report2) {
		this.graph_report2 = graph_report2;
	}



	public boolean isGraph_report3() {
		return graph_report3;
	}



	public void setGraph_report3(boolean graph_report3) {
		this.graph_report3 = graph_report3;
	}



	public boolean isGraph_report4() {
		return graph_report4;
	}



	public void setGraph_report4(boolean graph_report4) {
		this.graph_report4 = graph_report4;
	}



	public boolean isGraph_report5() {
		return graph_report5;
	}



	public void setGraph_report5(boolean graph_report5) {
		this.graph_report5 = graph_report5;
	}



	public boolean isGraph_report6() {
		return graph_report6;
	}



	public void setGraph_report6(boolean graph_report6) {
		this.graph_report6 = graph_report6;
	}



	public boolean isGraph_report7() {
		return graph_report7;
	}



	public void setGraph_report7(boolean graph_report7) {
		this.graph_report7 = graph_report7;
	}



	public boolean isGraph_report8() {
		return graph_report8;
	}



	public void setGraph_report8(boolean graph_report8) {
		this.graph_report8 = graph_report8;
	}



	public boolean isGraph_report9() {
		return graph_report9;
	}



	public void setGraph_report9(boolean graph_report9) {
		this.graph_report9 = graph_report9;
	}



	public boolean isGraph_report10() {
		return graph_report10;
	}



	public void setGraph_report10(boolean graph_report10) {
		this.graph_report10 = graph_report10;
	}



	


	public boolean isRole_Action() {
		return Role_Action;
	}



	public void setRole_Action(boolean role_Action) {
		Role_Action = role_Action;
	}



	public boolean isDashboard() {
		return dashboard;
	}



	public void setDashboard(boolean dashboard) {
		this.dashboard = dashboard;
	}



	public boolean isCreateRole() {
		return CreateRole;
	}



	public void setCreateRole(boolean createRole) {
		CreateRole = createRole;
	}



	public boolean isProductMasterReport() {
		return ProductMasterReport;
	}



	public void setProductMasterReport(boolean productMasterReport) {
		ProductMasterReport = productMasterReport;
	}



	public boolean isPacketConfigMasterReport() {
		return PacketConfigMasterReport;
	}



	public void setPacketConfigMasterReport(boolean packetConfigMasterReport) {
		PacketConfigMasterReport = packetConfigMasterReport;
	}



	public boolean isBagConfigMasterReport() {
		return BagConfigMasterReport;
	}



	public void setBagConfigMasterReport(boolean bagConfigMasterReport) {
		BagConfigMasterReport = bagConfigMasterReport;
	}



	public boolean isSchemeMasterReport() {
		return SchemeMasterReport;
	}



	public void setSchemeMasterReport(boolean schemeMasterReport) {
		SchemeMasterReport = schemeMasterReport;
	}



	public boolean isCityMasterReport() {
		return CityMasterReport;
	}



	public void setCityMasterReport(boolean cityMasterReport) {
		CityMasterReport = cityMasterReport;
	}



	public boolean isRouteMasterReport() {
		return RouteMasterReport;
	}



	public void setRouteMasterReport(boolean routeMasterReport) {
		RouteMasterReport = routeMasterReport;
	}



	public boolean isVehicleTypeMasterReport() {
		return VehicleTypeMasterReport;
	}



	public void setVehicleTypeMasterReport(boolean vehicleTypeMasterReport) {
		VehicleTypeMasterReport = vehicleTypeMasterReport;
	}



	public boolean isTransportMasterReport() {
		return TransportMasterReport;
	}



	public void setTransportMasterReport(boolean transportMasterReport) {
		TransportMasterReport = transportMasterReport;
	}



	public boolean isVehicleMasterReport() {
		return VehicleMasterReport;
	}



	public void setVehicleMasterReport(boolean vehicleMasterReport) {
		VehicleMasterReport = vehicleMasterReport;
	}



	public boolean isDriverMasterReport() {
		return DriverMasterReport;
	}



	public void setDriverMasterReport(boolean driverMasterReport) {
		DriverMasterReport = driverMasterReport;
	}



	public boolean isDestributorMasterReport() {
		return DestributorMasterReport;
	}



	public void setDestributorMasterReport(boolean destributorMasterReport) {
		DestributorMasterReport = destributorMasterReport;
	}



	public boolean isEmployeeMasterReport() {
		return EmployeeMasterReport;
	}



	public void setEmployeeMasterReport(boolean employeeMasterReport) {
		EmployeeMasterReport = employeeMasterReport;
	}



	public boolean isTaxMasterReport() {
		return TaxMasterReport;
	}



	public void setTaxMasterReport(boolean taxMasterReport) {
		TaxMasterReport = taxMasterReport;
	}



	public boolean isHsnMasterReport() {
		return HsnMasterReport;
	}



	public void setHsnMasterReport(boolean hsnMasterReport) {
		HsnMasterReport = hsnMasterReport;
	}



	public boolean isInward() {
		return Inward;
	}



	public void setInward(boolean inward) {
		Inward = inward;
	}



	public boolean isRequisitionReport() {
		return RequisitionReport;
	}



	public void setRequisitionReport(boolean requisitionReport) {
		RequisitionReport = requisitionReport;
	}



	public boolean isPktToBag() {
		return PktToBag;
	}



	public void setPktToBag(boolean pktToBag) {
		PktToBag = pktToBag;
	}



	public boolean isBagToParcel() {
		return BagToParcel;
	}



	public void setBagToParcel(boolean bagToParcel) {
		BagToParcel = bagToParcel;
	}



	public boolean isStockTransferReport() {
		return StockTransferReport;
	}



	public void setStockTransferReport(boolean stockTransferReport) {
		StockTransferReport = stockTransferReport;
	}



	public boolean isScrap() {
		return Scrap;
	}



	public void setScrap(boolean scrap) {
		Scrap = scrap;
	}



	public boolean isScrapReport() {
		return ScrapReport;
	}



	public void setScrapReport(boolean scrapReport) {
		ScrapReport = scrapReport;
	}



	public boolean isClosingForm() {
		return ClosingForm;
	}



	public void setClosingForm(boolean closingForm) {
		ClosingForm = closingForm;
	}



	public boolean isStockReport() {
		return StockReport;
	}



	public void setStockReport(boolean stockReport) {
		StockReport = stockReport;
	}



	public boolean isOrder() {
		return Order;
	}



	public void setOrder(boolean order) {
		Order = order;
	}



	public boolean isOrderReport() {
		return OrderReport;
	}



	public void setOrderReport(boolean orderReport) {
		OrderReport = orderReport;
	}



	public boolean isOrderApproveReport() {
		return OrderApproveReport;
	}



	public void setOrderApproveReport(boolean orderApproveReport) {
		OrderApproveReport = orderApproveReport;
	}



	public boolean isOrderLoadDoneReport() {
		return OrderLoadDoneReport;
	}



	public void setOrderLoadDoneReport(boolean orderLoadDoneReport) {
		OrderLoadDoneReport = orderLoadDoneReport;
	}



	public boolean isDeliveryReport() {
		return DeliveryReport;
	}



	public void setDeliveryReport(boolean deliveryReport) {
		DeliveryReport = deliveryReport;
	}



	public boolean isPaymentDoneReport() {
		return PaymentDoneReport;
	}



	public void setPaymentDoneReport(boolean paymentDoneReport) {
		PaymentDoneReport = paymentDoneReport;
	}



	public boolean isOrderDespatchReport() {
		return OrderDespatchReport;
	}



	public void setOrderDespatchReport(boolean orderDespatchReport) {
		OrderDespatchReport = orderDespatchReport;
	}



	public boolean isRequisition() {
		return Requisition;
	}



	public void setRequisition(boolean requisition) {
		Requisition = requisition;
	}



	public boolean isRequisitionReceiveReport() {
		return RequisitionReceiveReport;
	}



	public void setRequisitionReceiveReport(boolean requisitionReceiveReport) {
		RequisitionReceiveReport = requisitionReceiveReport;
	}



	public boolean isDespatchClosingForm() {
		return DespatchClosingForm;
	}



	public void setDespatchClosingForm(boolean despatchClosingForm) {
		DespatchClosingForm = despatchClosingForm;
	}



	public boolean isMaterialReturn() {
		return MaterialReturn;
	}



	public void setMaterialReturn(boolean materialReturn) {
		MaterialReturn = materialReturn;
	}



	public boolean isPriceLevel() {
		return PriceLevel;
	}



	public void setPriceLevel(boolean priceLevel) {
		PriceLevel = priceLevel;
	}



	public boolean isPriceLevelReport() {
		return PriceLevelReport;
	}



	public void setPriceLevelReport(boolean priceLevelReport) {
		PriceLevelReport = priceLevelReport;
	}



	public boolean isRateHistoryReport() {
		return RateHistoryReport;
	}



	public void setRateHistoryReport(boolean rateHistoryReport) {
		RateHistoryReport = rateHistoryReport;
	}



	public boolean isOrderReportAccount() {
		return OrderReportAccount;
	}



	public void setOrderReportAccount(boolean orderReportAccount) {
		OrderReportAccount = orderReportAccount;
	}



	public boolean isBillReport() {
		return BillReport;
	}



	public void setBillReport(boolean billReport) {
		BillReport = billReport;
	}



	public boolean isBillApproveReport() {
		return BillApproveReport;
	}



	public void setBillApproveReport(boolean billApproveReport) {
		BillApproveReport = billApproveReport;
	}



	public boolean isDeliveryDoneReport() {
		return DeliveryDoneReport;
	}



	public void setDeliveryDoneReport(boolean deliveryDoneReport) {
		DeliveryDoneReport = deliveryDoneReport;
	}



	public boolean isCup() {
		return cup;
	}



	public void setCup(boolean cup) {
		this.cup = cup;
	}



	public boolean isCustomer_Os() {
		return Customer_Os;
	}



	public void setCustomer_Os(boolean customer_Os) {
		Customer_Os = customer_Os;
	}



	public boolean isCpReport() {
		return CpReport;
	}



	public void setCpReport(boolean cpReport) {
		CpReport = cpReport;
	}



	public boolean isCustcreditnote() {
		return custcreditnote;
	}



	public void setCustcreditnote(boolean custcreditnote) {
		this.custcreditnote = custcreditnote;
	}



	public boolean isCustcdreport() {
		return custcdreport;
	}



	public void setCustcdreport(boolean custcdreport) {
		this.custcdreport = custcdreport;
	}



	public boolean isCustomer_Credit_Advance_Reportv() {
		return Customer_Credit_Advance_Reportv;
	}



	public void setCustomer_Credit_Advance_Reportv(boolean customer_Credit_Advance_Reportv) {
		Customer_Credit_Advance_Reportv = customer_Credit_Advance_Reportv;
	}



	public boolean isTransport_Credit_Advance_Reportv() {
		return Transport_Credit_Advance_Reportv;
	}



	public void setTransport_Credit_Advance_Reportv(boolean transport_Credit_Advance_Reportv) {
		Transport_Credit_Advance_Reportv = transport_Credit_Advance_Reportv;
	}



	public boolean isExpiryReport() {
		return ExpiryReport;
	}



	public void setExpiryReport(boolean expiryReport) {
		ExpiryReport = expiryReport;
	}



	public boolean isRequisitionCancelReport() {
		return RequisitionCancelReport;
	}



	public void setRequisitionCancelReport(boolean requisitionCancelReport) {
		RequisitionCancelReport = requisitionCancelReport;
	}



	public boolean isOrderCancelReport() {
		return OrderCancelReport;
	}



	public void setOrderCancelReport(boolean orderCancelReport) {
		OrderCancelReport = orderCancelReport;
	}



	public boolean isClosingAnalysis() {
		return ClosingAnalysis;
	}



	public void setClosingAnalysis(boolean closingAnalysis) {
		ClosingAnalysis = closingAnalysis;
	}



	public boolean isClosingReport() {
		return ClosingReport;
	}



	public void setClosingReport(boolean closingReport) {
		ClosingReport = closingReport;
	}



	public boolean isClosingRequestReport() {
		return ClosingRequestReport;
	}



	public void setClosingRequestReport(boolean closingRequestReport) {
		ClosingRequestReport = closingRequestReport;
	}



	public boolean isClosingDifferenceReport() {
		return ClosingDifferenceReport;
	}



	public void setClosingDifferenceReport(boolean closingDifferenceReport) {
		ClosingDifferenceReport = closingDifferenceReport;
	}



	public boolean isDistrictMasterReport() {
		return DistrictMasterReport;
	}



	public void setDistrictMasterReport(boolean districtMasterReport) {
		DistrictMasterReport = districtMasterReport;
	}



	public boolean isTahsilMasterReport() {
		return TahsilMasterReport;
	}



	public void setTahsilMasterReport(boolean tahsilMasterReport) {
		TahsilMasterReport = tahsilMasterReport;
	}



	public boolean isSpecialOrderReport() {
		return SpecialOrderReport;
	}



	public void setSpecialOrderReport(boolean specialOrderReport) {
		SpecialOrderReport = specialOrderReport;
	}



	public boolean isOrderSpecialHistory() {
		return OrderSpecialHistory;
	}



	public void setOrderSpecialHistory(boolean orderSpecialHistory) {
		OrderSpecialHistory = orderSpecialHistory;
	}



	public boolean isRequisitionHistory() {
		return RequisitionHistory;
	}



	public void setRequisitionHistory(boolean requisitionHistory) {
		RequisitionHistory = requisitionHistory;
	}



	public boolean isProduction() {
		return Production;
	}



	public void setProduction(boolean production) {
		Production = production;
	}



	public boolean isProductionReport() {
		return ProductionReport;
	}



	public void setProductionReport(boolean productionReport) {
		ProductionReport = productionReport;
	}



	public boolean isVehicleAssignReport() {
		return VehicleAssignReport;
	}



	public void setVehicleAssignReport(boolean vehicleAssignReport) {
		VehicleAssignReport = vehicleAssignReport;
	}



	public boolean isRequisitionHistoryDespatch() {
		return RequisitionHistoryDespatch;
	}



	public void setRequisitionHistoryDespatch(boolean requisitionHistoryDespatch) {
		RequisitionHistoryDespatch = requisitionHistoryDespatch;
	}



	public boolean isDestributorBillWiseOs() {
		return DestributorBillWiseOs;
	}



	public void setDestributorBillWiseOs(boolean destributorBillWiseOs) {
		DestributorBillWiseOs = destributorBillWiseOs;
	}



	public boolean isDestributorSalesItemWise() {
		return DestributorSalesItemWise;
	}



	public void setDestributorSalesItemWise(boolean destributorSalesItemWise) {
		DestributorSalesItemWise = destributorSalesItemWise;
	}



	public boolean isAllorderReport() {
		return AllorderReport;
	}



	public void setAllorderReport(boolean allorderReport) {
		AllorderReport = allorderReport;
	}



	public boolean isOrderAlertReport() {
		return OrderAlertReport;
	}



	public void setOrderAlertReport(boolean orderAlertReport) {
		OrderAlertReport = orderAlertReport;
	}



	public boolean isOrderStatusReport() {
		return OrderStatusReport;
	}



	public void setOrderStatusReport(boolean orderStatusReport) {
		OrderStatusReport = orderStatusReport;
	}



	public boolean isOrderCountReport() {
		return OrderCountReport;
	}



	public void setOrderCountReport(boolean orderCountReport) {
		OrderCountReport = orderCountReport;
	}



	public boolean isDistributorHistory() {
		return DistributorHistory;
	}



	public void setDistributorHistory(boolean distributorHistory) {
		DistributorHistory = distributorHistory;
	}



	public boolean isOrderProductReport() {
		return OrderProductReport;
	}



	public void setOrderProductReport(boolean orderProductReport) {
		OrderProductReport = orderProductReport;
	}



	public boolean isSalesRegister() {
		return SalesRegister;
	}



	public void setSalesRegister(boolean salesRegister) {
		SalesRegister = salesRegister;
	}



	public boolean isDayReport() {
		return DayReport;
	}



	public void setDayReport(boolean dayReport) {
		DayReport = dayReport;
	}



	public boolean isEscalationReport() {
		return EscalationReport;
	}



	public void setEscalationReport(boolean escalationReport) {
		EscalationReport = escalationReport;
	}



	public boolean isReqHistory() {
		return ReqHistory;
	}



	public void setReqHistory(boolean reqHistory) {
		ReqHistory = reqHistory;
	}



	public boolean isGraph1() {
		return Graph1;
	}



	public void setGraph1(boolean graph1) {
		Graph1 = graph1;
	}



	public boolean isGraph2() {
		return Graph2;
	}



	public void setGraph2(boolean graph2) {
		Graph2 = graph2;
	}



	public boolean isGraph3() {
		return Graph3;
	}



	public void setGraph3(boolean graph3) {
		Graph3 = graph3;
	}



	public boolean isGraph4() {
		return Graph4;
	}



	public void setGraph4(boolean graph4) {
		Graph4 = graph4;
	}



	public boolean isGraph5() {
		return Graph5;
	}



	public void setGraph5(boolean graph5) {
		Graph5 = graph5;
	}



	public boolean isGraph6() {
		return Graph6;
	}



	public void setGraph6(boolean graph6) {
		Graph6 = graph6;
	}



	public boolean isGraph7() {
		return Graph7;
	}



	public void setGraph7(boolean graph7) {
		Graph7 = graph7;
	}



	public boolean isGraph8() {
		return Graph8;
	}



	public void setGraph8(boolean graph8) {
		Graph8 = graph8;
	}



	public boolean isGraph9() {
		return Graph9;
	}



	public void setGraph9(boolean graph9) {
		Graph9 = graph9;
	}



	public boolean isGraph10() {
		return Graph10;
	}



	public void setGraph10(boolean graph10) {
		Graph10 = graph10;
	}



	public boolean isGraph11() {
		return Graph11;
	}



	public void setGraph11(boolean graph11) {
		Graph11 = graph11;
	}



	public boolean isGraph12() {
		return Graph12;
	}



	public void setGraph12(boolean graph12) {
		Graph12 = graph12;
	}

	
	
	

		


}
