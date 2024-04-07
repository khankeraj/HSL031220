package com.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.accessibility.action.RoleAction;
import com.dao.RoleDao;
import com.login.loginModel.userinfo;


public class RoleDaoImpl implements RoleDao {

	
	DBConnection conn=new DBConnection();
	//Connection con=conn.getConnection();
	
	public int roleDao(RoleAction rb, userinfo lb) throws SQLException {
		
		Connection con=conn.getConnection();
		
		int Max_role_id = 0;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		pst = con
				.prepareStatement("select MAX(access_id) as max from accessibility ");
		
		rs = pst.executeQuery();
	
		int access_id = 0;
		if (rs.next()) {
			access_id = rs.getInt(1);
		}
		access_id++;
	
		rs.close();
		// pst.close();

		List<String> sub_menu_list = new ArrayList<String>();
		
		
		
		
		if (rb.isNew_role_action())sub_menu_list.add("Role_Action");
		
		if (rb.isRole())sub_menu_list.add("role");
		
		if (rb.isNewuser())sub_menu_list.add("Newuser");
		
		
	
		
		
		
		
		
		//if (rb.isRole_Action())sub_menu_list.add("Role_Action");
		if (rb.isCreateRole())sub_menu_list.add("CreateRole");
		
		if (rb.isDashboard())sub_menu_list.add("dashboard");
		
		if(rb.isRoleMasterReport())sub_menu_list.add("RoleMasterReport");
		if(rb.isRoleReport())sub_menu_list.add("RoleReport");	
		
		if(rb.isAdduserProductMasterReport())sub_menu_list.add("adduserProductMasterReport");
		if(rb.isChangePass())sub_menu_list.add("ChangePass");
		if(rb.isEnquiry())sub_menu_list.add("Enquiry");
		if(rb.isEnquiryReport())sub_menu_list.add("EnquiryReport");
		if(rb.isPricingReport())sub_menu_list.add("PricingReport");
		if(rb.isQuotationReport())sub_menu_list.add("QuotationReport");
		if(rb.isReviseQuotationReport())sub_menu_list.add("ReviseQuotationReport");
		if(rb.isPricingReport1())sub_menu_list.add("PricingReport1");
		if(rb.isOrderReport())sub_menu_list.add("OrderReport");
		if(rb.isLr_Reports())sub_menu_list.add("lr_Reports");
		if(rb.isDelivery_done_Reports1())sub_menu_list.add("delivery_done_Reports1");
		if(rb.isInvoiceReport())sub_menu_list.add("InvoiceReport");
		if(rb.isPI_done_Reports1())sub_menu_list.add("PI_done_Reports1");
		if(rb.isPi_InvoiceReport())sub_menu_list.add("pi_InvoiceReport");
		if(rb.isNewlr_Reports())sub_menu_list.add("newlr_Reports");
		if(rb.isCustomer_master_Reports())sub_menu_list.add("customer_master_Reports");
		if(rb.isCity_master_Reports())sub_menu_list.add("city_master_Reports");
		if(rb.isRoute_master_Reports())sub_menu_list.add("route_master_Reports");
		if(rb.isProduct_master_Reports())sub_menu_list.add("product_master_Reports");
		if(rb.isDriver_master_Reports())sub_menu_list.add("driver_master_Reports");
		if(rb.isVehicle_master_Reports())sub_menu_list.add("vehicle_master_Reports");
		if(rb.isTransport_master_Reports())sub_menu_list.add("transport_master_Reports");
		if(rb.isExpense_master_Reports())sub_menu_list.add("expense_master_Reports");
		if(rb.isEmployeeReports())sub_menu_list.add("EmployeeReports");
		if(rb.isDesignation_master_Reports())sub_menu_list.add("designation_master_Reports");
		if(rb.isVehicleTypeMasterReport())sub_menu_list.add("VehicleTypeMasterReport");
		if(rb.isResourceTypeMasterReport())sub_menu_list.add("ResourceTypeMasterReport");
		if(rb.isReasonTypeMasterReport())sub_menu_list.add("ReasonTypeMasterReport");
		if(rb.isExpense_form())sub_menu_list.add("expense_form");
		if(rb.isAmount_issue())sub_menu_list.add("Amount_issue");
		if(rb.isAmount_issue_Reports())sub_menu_list.add("Amount_issue_Reports");
		if(rb.isExpense_Reports1())sub_menu_list.add("expense_Reports1");
		if(rb.isTransporter_Credit_Advance_Reportv())sub_menu_list.add("Transporter_Credit_Advance_Reportv");
		if(rb.isCustomer_Credit_Advance_Reportv())sub_menu_list.add("Customer_Credit_Advance_Reportv");
		if(rb.isSupervisor_Credit_Advance_Reportv())sub_menu_list.add("Supervisor_Credit_Advance_Reportv");
		if(rb.isDaily_Cash_Advance_Reportv())sub_menu_list.add("Daily_Cash_Advance_Reportv");
		if(rb.isEscalation_Advance_Reportv())sub_menu_list.add("Escalation_Advance_Reportv");
		if(rb.isCustomer_Credit_Advance_Reportv123())sub_menu_list.add("Customer_Credit_Advance_Reportv123");
		if(rb.isCreditdebitnote_Credit_Advance_Reportv())sub_menu_list.add("creditdebitnote_Credit_Advance_Reportv");
		if(rb.isCustcdreport())sub_menu_list.add("custcdreport");
		if(rb.isSupcdreport())sub_menu_list.add("supcdreport");
		if(rb.isTransporter_payment())sub_menu_list.add("transporter_payment");
		if(rb.isCustomer_payment())sub_menu_list.add("customer_payment");
		if(rb.isTransporter_payment_report())sub_menu_list.add("transporter_payment_report");
		if(rb.isCustomer_payment_report())sub_menu_list.add("customer_payment_report");
		if(rb.isTransporter_outstanding_report())sub_menu_list.add("transporter_outstanding_report");
		if(rb.isCustomer_outstanding_report())sub_menu_list.add("customer_outstanding_report");
		if(rb.isResource_enquiry_graph())sub_menu_list.add("resource_enquiry_graph");
		if(rb.isResource_enquiry_graph1())sub_menu_list.add("resource_enquiry_graph1");
		if(rb.isOrder_lost_graph())sub_menu_list.add("order_lost_graph");
		if(rb.isMonthly_business_graph())sub_menu_list.add("monthly_business_graph");
		if(rb.isBusiness_graph())sub_menu_list.add("business_graph");
		if(rb.isExim_graph())sub_menu_list.add("exim_graph");
		if(rb.isExim_graph1())sub_menu_list.add("exim_graph1");
		if(rb.isExim_graph123())sub_menu_list.add("exim_graph123");
		if(rb.isAlertForm())sub_menu_list.add("AlertForm");
		if(rb.isAlertReport())sub_menu_list.add("AlertReport");
		if(rb.isAlertDoneReport())sub_menu_list.add("AlertDoneReport");
		if(rb.isAlertExpectedReport())sub_menu_list.add("AlertExpectedReport");
		if(rb.isPriceCheckForm123())sub_menu_list.add("PriceCheckForm123");
		if(rb.isPriceCheckReport123())sub_menu_list.add("PriceCheckReport123");
		if(rb.isSalesRegister())sub_menu_list.add("SalesRegister");
		if(rb.isVendorBillReport())sub_menu_list.add("VendorBillReport");
		if(rb.isDeliveryAlertReport())sub_menu_list.add("DeliveryAlertReport");
		if(rb.isPriceCheckForm())sub_menu_list.add("PriceCheckForm");
		if(rb.isPriceCheckReport())sub_menu_list.add("PriceCheckReport");
		if(rb.isCompanyContactReport())sub_menu_list.add("CompanyContactReport");
		
		
		
		
		
		
		
		
		List<String> sub_menu_id_list = new ArrayList<String>();
		
	
		for (String menu : sub_menu_list) {

			pst = con
					.prepareStatement("select sub_menu_id from submenu where sub_menu_name = '"
							+ menu + "'");
			rs = pst.executeQuery();
			
			
			if (rs.next()) {

				sub_menu_id_list.add(rs.getString(1));
			}
		}
		
		
		int sub_id_location = 0;
		
		for (String menu : sub_menu_id_list) {
			pst = con
					.prepareStatement("insert into accessibility(access_id, sub_menu_id) values("+ access_id+ ","+sub_menu_id_list.get(sub_id_location)+")");
		
			
			pst.executeUpdate();
			
			sub_id_location++;
		}

		// ALERT ACCESS
	
		// ROLE TABLE

		pst = con
				.prepareStatement("select max(r.role_id) as maxroleid from role r  ");
		
	
		rs = pst.executeQuery();
	
		
		Max_role_id=0;
		if (rs.next()) {
			Max_role_id = rs.getInt(1);
		}
		Max_role_id++;
		pst = con
		.prepareStatement("insert into role(role_id, role_name, zones, offices,city_name, departments, users, access_id, alert_access_id, rpt_access_id, uid) values("
				+ Max_role_id
				+ ",'"
				+ rb.getRole_name()
				+ "','"
				 + rb.getZones()
				+ "','"
				+rb.getCity_name()
				+ "','"
				+ rb.getOffices()
				+ "','"
				+ rb.getDepartments()
				+ "','"
				+ rb.getUsers()
				+ "',"
				+ access_id
				+ ","
				+ 5
				+ ","
				+ 6 + ",5)");

		pst.executeUpdate();
		
		
		
		DBConnection.closeConnection();
		
		return 1;

	}
	
	
	
	
public int roleDao1(RoleAction rb, userinfo lb) throws SQLException {
		
	Connection con=conn.getConnection();
		
	int Max_role_id = 0;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		pst = con
				.prepareStatement("select MAX(access_id) as max from accessibility_admin ");
		rs = pst.executeQuery();
		int access_id = 0;
		if (rs.next()) {
			access_id = rs.getInt(1);
		}
		access_id++;
		rs.close();
		// pst.close();

		List<String> sub_menu_list = new ArrayList<String>();
		
		
		
		
		if (rb.isNew_role_action())sub_menu_list.add("Role_Action");
		
		if (rb.isRole())sub_menu_list.add("role");
		
		if (rb.isNewuser())sub_menu_list.add("Newuser");
		
			
		
		if (rb.isReport1())sub_menu_list.add("report1");
		if (rb.isReport2())sub_menu_list.add("report2");
		if (rb.isReport3())sub_menu_list.add("report3");
		if (rb.isReport4())sub_menu_list.add("report4");
		if (rb.isReport5())sub_menu_list.add("report5");
		if (rb.isReport6())sub_menu_list.add("report6");
		if (rb.isReport7())sub_menu_list.add("report7");
		if (rb.isReport8())sub_menu_list.add("report8");
		if (rb.isReport9())sub_menu_list.add("report9");
		if (rb.isReport10())sub_menu_list.add("report10");
		
		
		if (rb.isGraph_report1())sub_menu_list.add("graph_report1");
		if (rb.isGraph_report2())sub_menu_list.add("graph_report2");
		if (rb.isGraph_report3())sub_menu_list.add("graph_report3");
		if (rb.isGraph_report4())sub_menu_list.add("graph_report4");
		if (rb.isGraph_report5())sub_menu_list.add("graph_report5");
		if (rb.isGraph_report6())sub_menu_list.add("graph_report6");
		if (rb.isGraph_report7())sub_menu_list.add("graph_report7");
		if (rb.isGraph_report8())sub_menu_list.add("graph_report8");
		if (rb.isGraph_report9())sub_menu_list.add("graph_report9");
		if (rb.isGraph_report10())sub_menu_list.add("graph_report10");
		
		
		List<String> sub_menu_id_list = new ArrayList<String>();
		
	
		for (String menu : sub_menu_list) {

			pst = con
					.prepareStatement("select sub_menu_id from submenu_admin where sub_menu_name = '"
							+ menu + "'");
			rs = pst.executeQuery();
			
			
			if (rs.next()) {

				sub_menu_id_list.add(rs.getString(1));
			}
		}
		
		
		int sub_id_location = 0;
		
		for (String menu : sub_menu_id_list) {
			pst = con
					.prepareStatement("insert into accessibility_admin(access_id, sub_menu_id) values("+ access_id+ ","+sub_menu_id_list.get(sub_id_location)+")");
		
			
			pst.executeUpdate();
			
			sub_id_location++;
		}

		// ALERT ACCESS
	
		// ROLE TABLE

		pst = con
				.prepareStatement("select max(r.role_id) as maxroleid from role_admin r ");
		
	
		rs = pst.executeQuery();
	
		
		Max_role_id=0;
		if (rs.next()) {
			Max_role_id = rs.getInt(1);
		}
		Max_role_id++;
		pst = con
		.prepareStatement("insert into role_admin(role_id, role_name, zones, offices,city_name, departments, users, access_id, alert_access_id, rpt_access_id, uid) values("
				+ Max_role_id
				+ ",'"
				+ rb.getRole_name()
				+ "','"
				 + rb.getZones()
				+ "','"
				+rb.getCity_name()
				+ "','"
				+ rb.getOffices()
				+ "','"
				+ rb.getDepartments()
				+ "','"
				+ rb.getUsers()
				+ "',"
				+ access_id
				+ ","
				+ 5
				+ ","
				+ 6 + ",5)");

		pst.executeUpdate();
		
		
		
		DBConnection.closeConnection();
		
		return 1;

	}
















	
	
	
	
	
}
