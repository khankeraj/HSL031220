<!DOCTYPE html>
 <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat "%>
<%@page import="java.util.Date "%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.*"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>HSL</title>
</head>
	<body>
			<!--MAIN NAVIGATION-->
			<nav id="mainnav-container">
				<div id="mainnav" style="background-color: #d4dee9">
					<!--Menu-->
					<div id="mainnav-menu-wrap">
						<div class="nano">
							
					<s:if test="#session.USER_PROFILE.type=='Admin'"> 
							<div class="nano-content">
								<ul id="mainnav-menu" class="list-group">
						
									<!--Menu list item-->
									
								<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/settings.svg">
											<span class="menu-title">
												<span class="menu-title">User</span>
												<span class="label label-primary pull-right">4</span>
											</span>
										</a>
										
										<ul class="collapse">
											
											
											
                          				<li><a href="RoleMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Create Role</a></li>
                            
                           					
											<li><a href="RoleReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp; Role</a></li>
											
											<!--  <li><a href="NewUser"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Add User</a></li>
											 -->
											<li><a href="adduserProductMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;User Report</a></li>
											
	
											<li><a href="ChangePass"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Change Password</a></li>
											
										</ul>
									</li>
									<li class="list-divider"></li>
									
										
									<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/2551b1199e.svg">
											<span class="menu-title">
												<span class="menu-title"><b>Inquiry</b></span>
												<span class="label label-primary pull-right">5</span>
											</span>
										</a>
										
										<ul class="collapse">
											
											<li><a href="Enquiry"><img alt="" height="15px;" src="configure/img/editmeeting.svg">&nbsp;<font style="font-weight: 600;">Inquiry Form</font></a></li>
											
											<li><a href="EnquiryReport"><img alt="" height="15px;" src="configure/img/clipboard.svg">&nbsp;<font style="font-weight: 600;">Inquiry Report</font></a></li>
											
											<li><a href="PricingReport"><img alt="" height="15px;" src="configure/img/quot12.png">&nbsp;<font style="font-weight: 600;">Quotation</font></a></li>
											<li><a href="QuotationReport"><img alt="" height="15px;" src="configure/img/online-shop.svg">&nbsp;<font style="font-weight: 600;">Quotation Report</font></a></li>
											
											<li><a href="ReviseQuotationReport"><img alt="" height="15px;" src="configure/img/price-tag.svg">&nbsp;<font style="font-weight: 600;">Revised Quotation Report</font></a></li>
											
											
										
										</ul>
									</li>
									
									<li class="list-divider"></li>
									
									
									
									<li>
										<a href="#">
											 <img alt="" height="30px;"width="30px;" src="configure/img/lorry.png">
												
											<span class="menu-title">
												<span class="menu-title"><b>Order</b></span>
												<span class="label label-primary pull-right">5</span>
											</span>
										</a>
										
										<ul class="collapse">
										
										<li><a href="PricingReport1"><img alt=""  height="15px;" src="configure/img/icon-car.png">&nbsp;<font style="font-weight: 600;">Vehicle Confirmation</font></a></li>
											
											<li><a href="OrderReport"><img alt="" height="15px;" src="configure/img/human-resources.svg">&nbsp;<font style="font-weight: 600;">Create LR</font></a></li>
																	
											<li><a href="lr_Reports"><img alt="" height="15px;" src="configure/img/icons8-report-card-50.png">&nbsp;<font style="font-weight: 600;"> Delivery Done</font></a></li>
										
										<li><a href="delivery_done_Reports1"><img alt="" height="15px;" src="configure/img/house-visiting.svg">&nbsp;<font style="font-weight: 600;">Invoice</font></a></li>
										
										<li><a href="InvoiceReport"><img alt="" height="15px;" src="configure/img/icons8-report-card-50.png">&nbsp;<font style="font-weight: 600;">Invoice Report</font></a></li>
											
											<li><a href="PI_done_Reports1"><img alt="" height="15px;" src="configure/img/house-visiting.svg">&nbsp;<font style="font-weight: 600;"> PI Invoice</font></a></li>
										
											<li><a href="pi_InvoiceReport"><img alt="" height="15px;" src="configure/img/icons8-report-card-50.png">&nbsp;<font style="font-weight: 600;">PI Report</font></a></li>
										
												<li><a href="newlr_Reports"><img alt="" height="15px;" src="configure/img/icons8-report-card-50.png">&nbsp;<font style="font-weight: 600;"> LR Report</font></a></li>
										
											
												<li><a href="lr_advanceform"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Vendor Advance Form</font></a></li>
											
											
											
												<li><a href="Transporter_done_Reports1"><img alt="" height="15px;" src="configure/img/house-visiting.svg">&nbsp;<font style="font-weight: 600;">Transporter Invoice</font></a></li>
										
											<li><a href="Vendor_Bill_Report"><img alt="" height="15px;" src="configure/img/house-visiting.svg">&nbsp;<font style="font-weight: 600;">Vendor Bill Report</font></a></li>
										
										
											<li><a href="vendor_Credit_Advance_Reportv"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Vendor Ledger</font></a></li>
											
											
											
											
										</ul>
									</li>
									
									<li class="list-divider"></li>
									
									<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/settings.svg">
											<span class="menu-title">
												<span class="menu-title"><b>Masters</b></span>
												<span class="label label-primary pull-right">13</span>
											</span>
										</a>
										
										<ul class="collapse">
											<!-- <li><a href="contractReport"><img alt="" height="15px;" src="configure/img/contract (1).svg">&nbsp;Contract Reports</a></li> -->
											<li><a href="customer_master_Reports"><img alt="" height="15px;" src="configure/img/specialist-user.svg">&nbsp;<font style="font-weight: 600;">Customer Master</font></a></li>
											<li><a href="city_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-building-50.png">&nbsp;<font style="font-weight: 600;">City Master</a></li>
											<li><a href="rental_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-box-50.png">&nbsp;<font style="font-weight: 600;">Rental Master</a></li>
											
											<li><a href="student_master_Reports"><img alt="" height="15px;" src="configure/img/specialist-user.svg">&nbsp;<font style="font-weight: 600;">Student Master</font></a></li>
											<li><a href="route_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-route-50.png">&nbsp;<font style="font-weight: 600;">Route Master</a></li>
											<li><a href="product_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-box-50.png">&nbsp;<font style="font-weight: 600;">Product Master</a></li>
											<li><a href="driver_master_Reports"><img alt="" height="15px;" src="configure/img/driver1.png">&nbsp;<font style="font-weight: 600;">Driver Master</a></li>
											<li><a href="vehicle_master_Reports"><img alt="" height="20px;" src="configure/img/icons8-truck-50.png">&nbsp;<font style="font-weight: 600;">Vehicle Master</a></li>
											<li><a href="transport_master_Reports"><img alt="" height="15px;" src="configure/img/specialist-user.svg">&nbsp;<font style="font-weight: 600;">Transporter Master</a></li>
											<li><a href="expense_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-rupee-50.png">&nbsp;<font style="font-weight: 600;">Expense Particular Master</a></li>
											<li><a href="EmployeeReports"><img alt="" height="15px;" src="configure/img/specialist-user.svg">&nbsp;<font style="font-weight: 600;">Employee Master</a></li> 
											<li><a href="designation_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Designation Master</a></li>
											
											<li><a href="VehicleTypeMasterReport"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Vehicle Type Master</a></li>
											
											<li><a href="ResourceTypeMasterReport"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Resource Master</a></li>
											
											<li><a href="ReasonTypeMasterReport"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Reason Master</a></li>
											<li><a href="rate_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Rate Master</a></li>
											
											
										</ul>
									</li>
									
									
									<li class="list-divider"></li>
									
									 
									
									
									
									 <li>
										<a href="#">
											<img alt="" height="30px;" src="configure/img/accounts.png">
											<span class="menu-title">
												<span class="menu-title"><b>Accounts</b></span>
												<span class="label label-primary pull-right">4</span>
											</span>
										</a>
												
										<ul class="collapse">
											
											<li><a href="expense_form"><img alt="" height="22px" src="configure/img/cost-8.png">&nbsp;<font style="font-weight: 600;">Expense Form</a></li>
											
											
											<li><a href="Amount_issue"><img alt="" height="22px" src="configure/img/enquiry-icon-png-11.png">&nbsp;<font style="font-weight: 600;">Amount issue Form</a></li>
											
											<li><a href="Amount_issue_Reports"><img alt="" height="22px" src="configure/img/purchase.svg">&nbsp;<font style="font-weight: 600;">Amount issue Report</a></li>
											
											<li><a href="expense_Reports1"><img alt="" height="22px" src="configure/img/tax.svg">&nbsp;<font style="font-weight: 600;">Expense Report</a></li>
										
											<li><a href="Transporter_Credit_Advance_Reportv"><img alt="" height="22px" src="configure/img/payment-method.svg">&nbsp;<font style="font-weight: 600;">Transporter Ledger</a></li>
										
											<li><a href="Customer_Credit_Advance_Reportv"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Customer Ledger</a></li>
											
											
											
											<li><a href="Supervisor_Credit_Advance_Reportv"><img alt="" height="22px" src="configure/img/Worker_hat_workers_hard_construction_building.png">&nbsp;<font style="font-weight: 600;">Supervisor  Ledger</a></li>
										
											<li><a href="Daily_Cash_Advance_Reportv"><img alt="" height="22px" src="configure/img/tax-icon-19.png">&nbsp;<font style="font-weight: 600;">Daily Cash Report</font></a></li>
										
											<li><a href="Escalation_Advance_Reportv"><img alt="" height="22px" src="configure/img/208-2088206_report-icon-project-report.png">&nbsp;<font style="font-weight: 600;">Escalation Report</font></a></li>
										
											<li><a href="Customer_Credit_Advance_Reportv123"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">LR Profitability Report</a></li>
									
										
												<li><a href="creditdebitnote_Credit_Advance_Reportv"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Credit/Debit Note</a></li>
									
									
													<li><a href="custcdreport"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Customer CR/DR Note Report</a></li>
													<li><a href="supcdreport"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Supplier CR/DR Note Report</a></li>
													
										
										</ul>
										
										
										
														
										
									</li> 
									
									
								
									
									
									
									<li class="list-divider"></li>
									
									
									
									<li>
										<a href="#">
											<img alt="" height="30px;" src="configure/img/money-exchange.svg">
											<span class="menu-title">
												<span class="menu-title"><b>Payments</b></span>
												<span class="label label-primary pull-right">6</span>
											</span>
										</a>
										
										<ul class="collapse">
											<li><a href="transporter_payment"><img alt=""  height="22px" src="configure/img/payment-method1.svg">&nbsp;<font style="font-weight: 600;">Transporter Payment</font></a></li>
											<li><a href="customer_payment"><img alt=""  height="22px" src="configure/img/payment-method1.svg">&nbsp;<font style="font-weight: 600;">Customer Receipt</font></a></li>
										
											<li><a href="transporter_payment_report"><img alt=""  height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Transporter Payment Report</font></a></li>
											<li><a href="customer_payment_report"><img alt=""  height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Customer Payment Report</font></a></li>
											<li><a href="transporter_outstanding_report"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Transporter Outstanding Report</font></a></li>
											<li><a href="customer_outstanding_report"><img alt="" height="22px" src="configure/img/receipt.svg">&nbsp;<font style="font-weight: 600;">Customer Outstanding Report</font></a></li>
										</ul>
										
									</li>
									
									
									
									
									
									 <li class="list-divider"></li>
									
									
									
									<li>
										<a href="#">
											<img alt="" height="30px; " src="configure/img/chart.png">
											<span class="menu-title">
												<span class="menu-title"><b>Graphs</b></span>
												<span class="label label-primary pull-right">3</span>
											</span>
										</a>
										
										<ul class="collapse">
												
										
											
											<!-- <li><a href="vehicle_alert_report"><img alt="" height="20px;" src="configure/img/icons8-business-report-64 (1).png">&nbsp;<font style="font-weight: 600;">Vehicle Alert Report</font></a></li> -->
											
											<!-- <li><a href="transporter_business_alert_report"><img alt="" height="20px;" src="configure/img/icons8-business-report-64 (1).png">&nbsp;<font style="font-weight: 600;">Transporter Business Reduce Alert Report</font></a></li>
											
											<li><a href="vehicle_profitability_report1"><img alt="" height="20px;" src="configure/img/icons8-business-report-64 (1).png">&nbsp;<font style="font-weight: 600;">Vehicle Profitability Report</font></a></li>
											
											<li><a href="sale_report"><img alt="" height="20px;" src="configure/img/icons8-business-report-64 (1).png">&nbsp;<font style="font-weight: 600;">Sales Report</font></a></li>
											
											<li><a href="vehicle_comparison_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Vehicle Comparison Graph</font></a></li> -->
											
											<li><a href="resource_enquiry_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Resource Enquiry Graph</font></a></li>
											
											<li><a href="resource_enquiry_graph1"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Resource Enquiry Graph1</font></a></li>
											
											<li><a href="order_lost_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Order Lost Graph</font></a></li>
											
											<li><a href="monthly_business_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Monthly Business Graph</font></a></li>
											
											<li><a href="business_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Resource Enquiry Business Graph</font></a></li>
											
											<li><a href="exim_graph"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">EXIM Graph</font></a></li>
											
											<li><a href="exim_graph1"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Shipment Type Graph</font></a></li>
											
												
											<!-- <li><a href="exim_graph12"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Shipment Type Graph</font></a></li>
		 -->									
											<li><a href="exim_graph123"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Root Graph</font></a></li>
											
										
										</ul>
									</li> 
									
									
									<li class="list-divider"></li>
									
									
									
									<li>
										<a href="#">
											<img alt="" height="30px; " src="configure/img/chart.png">
											<span class="menu-title">
												<span class="menu-title"><b>Alert</b></span>
												<span class="label label-primary pull-right">3</span>
											</span>
										</a>
										
										<ul class="collapse">
												
										
											
											
											<li><a href="AlertForm"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Alert Form</font></a></li>
											
											<li><a href="AlertReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Alert Report</font></a></li>
											
											<li><a href="AlertDoneReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Alert Done Report</font></a></li>
											
											<li><a href="AlertExpectedReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Expected Alert Report</font></a></li>
											<li><a href="PriceCheckForm123"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Pricing Form</font></a></li>
											
											<li><a href="PriceCheckReport123"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Pricing Report</font></a></li>
											
											
										</ul>
									</li> 
									
									<li class="list-divider"></li>
									
									
									
									<li>
										<a href="#">
											<img alt="" height="30px; " src="configure/img/chart.png">
											<span class="menu-title">
												<span class="menu-title"><b>Reports</b></span>
												<span class="label label-primary pull-right">3</span>
											</span>
										</a>
										
										<ul class="collapse">
												
										
											<li><a href="SalesRegister"><img alt="" height="20px;" src="configure/img/icons8-business-report-64 (1).png">&nbsp;<font style="font-weight: 600;">Sales Report</font></a></li>
													
											<li><a href="VendorBillReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Vendor Bill Report</font></a></li>
											
											<li><a href="DeliveryAlertReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Delivery Alert Report</font></a></li>
											
											<li><a href="PriceCheckForm"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Pricing Check Form</font></a></li>
											
											<li><a href="PriceCheckReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Pricing Check Report</font></a></li>
											
											<li><a href="CompanyContactReport"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Company Contacts</font></a></li>
											
											<li><a href="EnquiryReport2"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Enquiry Report</font></a></li>
											
											<li><a href="LRReport2"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">LR Report</font></a></li>
																				
											<li><a href="monthlybooking"><img alt="" height="20px;" src="configure/img/chart_bar.png">&nbsp;<font style="font-weight: 600;">Monthly Booking</font></a></li>
													
											
										</ul>
									</li> 
									
									<li class="list-divider"></li>
									
									
								</ul>
								
								<%-- <li><input type="text" value='<s:property value="#session.USER_PROFILE.type"/>' id="mys" /></li> --%>
								
							</div>
							
							</s:if>
							
							<s:else>
							
								
							 <div class="nano-content">
								<ul id="mainnav-menu" class="list-group">
						
									<!--Menu list item-->
									
									
									
										<%
												Map m = (Map) session.getAttribute("menus");
										
                  		 						if (m.containsKey("user")) {
											
                  		 						List s = (List) m.get("user");
							
										 %>
									
									
									
									
									
									<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/settings.svg">
											<span class="menu-title">
												<span class="menu-title">User</span>
												<span class="label label-primary pull-right">1</span>
											</span>
										</a>
										
										<ul class="collapse">
											
											
											 <% if (s.contains("RoleMasterReport")) { %>
                          
                          							 <li><a href="RoleMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Create Role</a></li>
                            
                           					 <% } %>
											
											<% if (s.contains("RoleReport")) { %>
											
											<li><a href="RoleReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp; Role</a></li>
											
											<% } %>
											
											
											
											<% if (s.contains("adduserProductMasterReport")) { %>
										
											<li><a href="adduserProductMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;User Report</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("ChangePass")) { %>
											
											
											<li><a href="ChangePass"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Change Password</a></li>
											
											<% } %>		
											
										</ul>
									</li>
									
									 <% } %>
									
									
									
									
									
										<%
												
                  		 						if (m.containsKey("Inquiry")) {
											
                  		 						List s = (List) m.get("Inquiry");
							
										 %>
									
									
									<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/settings.svg">
											<span class="menu-title">
												<span class="menu-title">Inquiry</span>
												<span class="label label-primary pull-right">16</span>
											</span>
										</a>
										
										<ul class="collapse">
											
											 <% if (s.contains("Enquiry")) { %>
											
												<li><a href="Enquiry"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Inquiry Form</a></li>
											
											<% } %>	
											
											 <% if (s.contains("EnquiryReport")) { %>
											
												<li><a href="EnquiryReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Inquiry Report</a></li>
											
											<% } %>	
											
											
											 <% if (s.contains("PricingReport")) { %>
											
												<li><a href="PricingReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Quotation</a></li>
											
											<% } %>	
											
											
											 <% if (s.contains("QuotationReport")) { %>
											
												<li><a href="QuotationReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Quotation Report</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("ReviseQuotationReport")) { %>
											
												<li><a href="ReviseQuotationReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Revised Quotation Report</a></li>
											
											<% } %>	
											
											
											
											
											
										</ul>
									</li>
									
									<% } %>	
									
									
									
									
									
										<%
												
                  		 						if (m.containsKey("Order")) {
											
                  		 						List s = (List) m.get("Order");
							
										 %>
									
									
									<li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/warehouse.svg">
											<span class="menu-title">
												<span class="menu-title">Order</span>
												<span class="label label-primary pull-right">9</span>
											</span>
										</a>
										<ul class="collapse">
											
											<% if (s.contains("PricingReport1")) { %>
											
												<li><a href="PricingReport1"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Vehicle Confirmation</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("OrderReport")) { %>
											
												<li><a href="OrderReport"><img alt="" height="15px;" src="configure/img/lead.svg">Create LR</a></li>
											
											
											<% } %>	
											
											
											
											<% if (s.contains("lr_Reports")) { %>
											
												<li><a href="lr_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Delivery Done</a></li>
											
											<% } %>	
											
											<% if (s.contains("delivery_done_Reports1")) { %>
											
												<li><a href="delivery_done_Reports1"><img alt="" height="15px;" src="configure/img/lead.svg">Invoice</a></li>
											
											<% } %>	
											
											<% if (s.contains("InvoiceReport")) { %>
											
												<li><a href="InvoiceReport"><img alt="" height="15px;" src="configure/img/lead.svg">Invoice Report</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("PI_done_Reports1")) { %>
												<li><a href="PI_done_Reports1"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp; PI Invoice</a></li>
											
											<% } %>	
											
											<% if (s.contains("pi_InvoiceReport")) { %>
												
												
												<li><a href="pi_InvoiceReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;PI Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("newlr_Reports")) { %>
												
												<li><a href="newlr_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;LR Report</a></li>
											
											<% } %>	
											
											
											
										</ul>
									</li>
									
									
									<% } %>	
									
									
									
										<%
												
                  		 						if (m.containsKey("Masters")) {
											
                  		 						List s = (List) m.get("Masters");
							
										 %>
									
									
									 <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/logistic.svg">
											<span class="menu-title">
												<span class="menu-title">Masters</span>
												<span class="label label-primary pull-right">6</span>
											</span>
										</a>
										<ul class="collapse">
											
											
											<% if (s.contains("customer_master_Reports")) { %>
												
												<li><a href="customer_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer Master</a></li>
											
											<% } %>	
											
											<% if (s.contains("city_master_Reports")) { %>
											
												<li><a href="city_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;City Master</a></li>
											
											<% } %>	
											
											<% if (s.contains("route_master_Reports")) { %>
												
												<li><a href="route_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Route Master</a></li>
											
											<% } %>	
											
											<% if (s.contains("OrderLoadDoneReport")) { %>
												
												<li><a href="OrderLoadDoneReport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Loading Done Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("product_master_Reports")) { %>
											
												<li><a href="product_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Product Master</a></li>
											
											<% } %>	
											
											<% if (s.contains("driver_master_Reports")) { %>
											
											<li><a href="driver_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Driver Master</a></li>
										
											<% } %>	
											
											
											<% if (s.contains("vehicle_master_Reports")) { %>
											
											<li><a href="vehicle_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Vehicle Master</a></li>
										
											<% } %>	
											
											
											<% if (s.contains("transport_master_Reports")) { %>
											
											<li><a href="transport_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Transporter Master</a></li>
										
											<% } %>	
											
											
											<% if (s.contains("expense_master_Reports")) { %>
											
											<li><a href="expense_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Expense Particular Master</a></li>
										
											<% } %>	
											
											
											<% if (s.contains("EmployeeReports")) { %>
											
											<li><a href="EmployeeReports"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Employee Master</a></li>
		
											<% } %>	
											
											<% if (s.contains("designation_master_Reports")) { %>
											
											<li><a href="designation_master_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">Designation Master</a>
											
											<% } %>	
											
											<% if (s.contains("VehicleTypeMasterReport")) { %>
											
											<li><a href="VehicleTypeMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">Vehicle Type Master</a>
											
											<% } %>	
										
										<% if (s.contains("ResourceTypeMasterReport")) { %>
											
											<li><a href="ResourceTypeMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">Resource Master</a>
											
											<% } %>
											<% if (s.contains("ReasonTypeMasterReport")) { %>
											
											<li><a href="ReasonTypeMasterReport"><img alt="" height="15px;" src="configure/img/lead.svg">Reason Master</a>
																																	<li><a href="rate_master_Reports"><img alt="" height="15px;" src="configure/img/icons8-user-location-50.png">&nbsp;<font style="font-weight: 600;">Rate Master</a></li>
											
											<% } %>
										
										
										
										
											
										</ul>
									</li> 
									
									<% } %>	
									
									
									
									
										<%
												
                  		 						if (m.containsKey("Accounts")) {
											
                  		 						List s = (List) m.get("Accounts");
							
										 %>
									
									
									 <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/despatch.svg">
											<span class="menu-title">
												<span class="menu-title">Accounts</span>
												<span class="label label-primary pull-right">5</span>
											</span>
										</a>
										<ul class="collapse">
										
										
										<% if (s.contains("expense_form")) { %>
											
											<li><a href="expense_form"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Expense Form</a></li>
										
										<% } %>	
										
										<% if (s.contains("Amount_issue")) { %>
										
											<li><a href="Amount_issue"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Amount issue Form</a></li>
										
										<% } %>	
										
										<% if (s.contains("Amount_issue_Reports")) { %>
											
											<li><a href="Amount_issue_Reports"><img alt="" height="15px;" src="configure/img/lead.svg">Amount issue Report</a></li>
											
										<% } %>	
										
										
										
										<% if (s.contains("expense_Reports1")) { %>
											
											<li><a href="expense_Reports1"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Expense Report</a></li>
										
										<% } %>	
										
										
										<% if (s.contains("Transporter_Credit_Advance_Reportv")) { %>
											
											<li><a href="Transporter_Credit_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">Transporter Ledger</a></li>
											
										<% } %>	
										
										
										
										<% if (s.contains("Customer_Credit_Advance_Reportv")) { %>
											
											<li><a href="Customer_Credit_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer Ledger</a></li>
											
										<% } %>	
										
										
										
										<% if (s.contains("Supervisor_Credit_Advance_Reportv")) { %>
											
											<li><a href="Supervisor_Credit_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Supervisor  Ledger</a></li>
											
										<% } %>
										
										<% if (s.contains("Daily_Cash_Advance_Reportv")) { %>
											
											<li><a href="Daily_Cash_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Daily Cash Report </a></li>
											
										<% } %>	
										
										<% if (s.contains("Escalation_Advance_Reportv")) { %>
											
											<li><a href="Escalation_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Escalation Report</a></li>
											
										<% } %>	
										
											
										<% if (s.contains("Customer_Credit_Advance_Reportv123")) { %>
											
											<li><a href="Customer_Credit_Advance_Reportv123"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;LR Profitability Report</a></li>
											
										<% } %>	
											
										<% if (s.contains("creditdebitnote_Credit_Advance_Reportv")) { %>
											
											<li><a href="creditdebitnote_Credit_Advance_Reportv"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Credit/Debit Note</a></li>
											
										<% } %>	
										
										
										<% if (s.contains("custcdreport")) { %>
											
											<li><a href="custcdreport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer CR/DR Note Report</a></li>
											
										<% } %>	
										
										<% if (s.contains("supcdreport")) { %>
											
											<li><a href="supcdreport"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Supplier CR/DR Note Report</a></li>
											
										<% } %>	
										
										</ul>
									</li> 
									
									
									<% } %>	
									
									
									
									
										<%
												
                  		 						if (m.containsKey("Payments")) {
											
                  		 						List s = (List) m.get("Payments");
							
										 %>
									
									
									 <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/bank-building.svg">
											<span class="menu-title">
												<span class="menu-title">Payments</span>
												<span class="label label-primary pull-right">12</span>
											</span>
										</a>
										<ul class="collapse">
											
											
											<% if (s.contains("customer_payment")) { %>
												
												<li><a href="customer_payment"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer Receipt</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("transporter_payment_report")) { %>
												
												<li><a href="transporter_payment_report"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Transporter Payment Report</a></li>
											
											<% } %>	
											
											
											
											<% if (s.contains("customer_payment_report")) { %>
												
													<li><a href="customer_payment_report"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer Payment Report</a></li>
				
											<% } %>	
											
											
											
											<% if (s.contains("transporter_outstanding_report")) { %>
											
												<li><a href="transporter_outstanding_report"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Transporter Outstanding Report</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("customer_outstanding_report")) { %>
												
												<li><a href="customer_outstanding_report"><img alt="" height="15px;" src="configure/img/lead.svg">&nbsp;Customer Outstanding Report</a></li>
											
											<% } %>	
											
											
											
											</ul>
									</li> 
									
									
								<% } %>	
									
									
									
									
										<%
												
                  		 						if (m.containsKey("Graphs")) {
											
                  		 						List s = (List) m.get("Graphs");
							
										 %>
									
									 <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/report.svg">
											<span class="menu-title">
												<span class="menu-title">Graphs</span>
												<span class="label label-primary pull-right">5</span>
											</span>
										</a>
										<ul class="collapse">
											
											<% if (s.contains("resource_enquiry_graph")) { %>
												<li><a href="resource_enquiry_graph"><img alt="" height="15px;" src="configure/img/lead.svg">Resource Enquiry Graph</a></li>
											
											<% } %>	
											
											<% if (s.contains("resource_enquiry_graph1")) { %>
											
												<li><a href="resource_enquiry_graph1"><img alt="" height="15px;" src="configure/img/lead.svg">Resource Enquiry Graph1</a></li>
											
											<% } %>	
											
											<% if (s.contains("order_lost_graph")) { %>
												
												<li><a href="order_lost_graph"><img alt="" height="15px;" src="configure/img/lead.svg">Order Lost Graph</a></li>
											
											<% } %>	
											
											<% if (s.contains("monthly_business_graph")) { %>
												
												<li><a href="monthly_business_graph"><img alt="" height="15px;" src="configure/img/lead.svg">Monthly Business Graph</a></li>
											
											<% } %>	
											
											<% if (s.contains("business_graph")) { %>
											
												<li><a href="business_graph"><img alt="" height="15px;" src="configure/img/lead.svg">Resource Enquiry Business Graph</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("exim_graph")) { %>
											
												<li><a href="exim_graph"><img alt="" height="15px;" src="configure/img/lead.svg">EXIM Graph</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("exim_graph1")) { %>
											
												<li><a href="exim_graph1"><img alt="" height="15px;" src="configure/img/lead.svg">Shipment Type Graph</a></li>
											
											<% } %>	
											
											
											<% if (s.contains("exim_graph123")) { %>
											
												<li><a href="exim_graph123"><img alt="" height="15px;" src="configure/img/lead.svg">Root Graph</a></li>
											
											<% } %>	
											
											
											
											
											
											
											
										</ul>
									</li> 
									
									
									
									<% } %>	
									
									
									
										<%
												
                  		 						if (m.containsKey("Alert")) {
											
                  		 						List s = (List) m.get("Alert");
							
										 %>
									
									  <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/online-shop.svg">
											<span class="menu-title">
												<span class="menu-title">Alert</span>
												<span class="label label-primary pull-right">4</span>
											</span>
										</a>
										<ul class="collapse">
											
											<% if (s.contains("AlertForm")) { %>
												
												<li><a href="AlertForm"><img alt="" height="15px;" src="configure/img/lead.svg">Alert Form</a></li>
											
											<% } %>	
											
											<% if (s.contains("AlertReport")) { %>
												
												<li><a href="AlertReport"><img alt="" height="15px;" src="configure/img/lead.svg">Alert Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("AlertDoneReport")) { %>
												
												<li><a href="AlertDoneReport"><img alt="" height="15px;" src="configure/img/lead.svg">Alert Done Report</a></li>
											
											
											<% } %>	
											
											
											<% if (s.contains("AlertExpectedReport")) { %>
												
												<li><a href="AlertExpectedReport"><img alt="" height="15px;" src="configure/img/lead.svg">Expected Alert Report</a></li>
											
											<% } %>	
											
											
											
											<% if (s.contains("PriceCheckForm123")) { %>
												
												<li><a href="PriceCheckForm123"><img alt="" height="15px;" src="configure/img/lead.svg">Pricing Form</a></li>
											
											<% } %>	
											<% if (s.contains("PriceCheckReport123")) { %>
												
												<li><a href="PriceCheckReport123"><img alt="" height="15px;" src="configure/img/lead.svg">Pricing Report</a></li>
											
											<% } %>	
										</ul>
									</li>  
									
									
									<% } %>	
									
									
									
										<%
												
                  		 						if (m.containsKey("Reports")) {
											
                  		 						List s = (List) m.get("Reports");
							
										 %>
										 
										 
										 
										  <li>
										<a href="#">
											<img alt="" height="20px;" src="configure/img/online-shop.svg">
											<span class="menu-title">
												<span class="menu-title">Reports</span>
												<span class="label label-primary pull-right">12</span>
											</span>
										</a>
										<ul class="collapse">
											
											<% if (s.contains("SalesRegister")) { %>
												
												<li><a href="SalesRegister"><img alt="" height="15px;" src="configure/img/lead.svg">Sales Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("VendorBillReport")) { %>
												
												<li><a href="VendorBillReport"><img alt="" height="15px;" src="configure/img/lead.svg">Vendor Bill Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("DeliveryAlertReport")) { %>
												
												<li><a href="DeliveryAlertReport"><img alt="" height="15px;" src="configure/img/lead.svg">Delivery Alert Report</a></li>
											
											
											<% } %>	
											
											
											<% if (s.contains("PriceCheckForm")) { %>
												
												<li><a href="PriceCheckForm"><img alt="" height="15px;" src="configure/img/lead.svg">Pricing Check Form</a></li>
											
											<% } %>	
											
											
											
											<% if (s.contains("PriceCheckReport")) { %>
												
												<li><a href="PriceCheckReport"><img alt="" height="15px;" src="configure/img/lead.svg">Pricing Check Report</a></li>
											
											<% } %>	
											
											<% if (s.contains("CompanyContactReport")) { %>
												
												<li><a href="CompanyContactReport"><img alt="" height="15px;" src="configure/img/lead.svg">Company Contacts</a></li>
											
											<% } %>	
											
											
											
											
											
											
											<% } %>	
										</ul>
									</li>
									
									 
									
								</ul>
								
							</div> 
							
							</s:else>
							
						</div>
					</div>

				</div>
			</nav>
	
</body>
</html>
