<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
 <!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
</head>
<body>

	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Driver Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Driver Master</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div>
								
							<form action="update_driver_master_details" method="POST" enctype="multipart/form-data">
							
								<div class="panel-body">
								<s:iterator value="fetchDriverDetails">
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="hidden" class="form-control" placeholder="" name="driver_id" value="${driver_id}"  />
													<input type="text" class="form-control" placeholder="" name="driver_name" value="${driver_name}"  class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Address(Permanent) :</label>
													<input type="text" class="form-control" placeholder="" name="addr_permanent" value="${addr_permanent}"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Driver Address(Current) :</label>
												<input type="text" placeholder=""  name="addr_curr" value="${addr_curr}" class="form-control" required>
											</div>
										</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number :</label>
													<input type="text" placeholder=""  name="contact_number" value="${contact_number}" style="line-height: 15px;"  class="form-control" required>
												</div>
											</div>
									  </div>
									
									 <div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Date Of Birth :</label>
												<input type="date" placeholder=""  name="date_of_birth" value="${date_of_birth}" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Age :</label>
												<input type="text" placeholder=""  autocomplete="off" name="age" value="${age}"  class="form-control" required>
										    </div>
										  </div>
									</div>
										
										
									<div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Salary Type :</label>
												<input type="text" placeholder=""  name="salary_type" value="${salary_type}" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Basic Salary :</label>
												<input type="text" placeholder=""  autocomplete="off" name="basic_salary" value="${basic_salary}" class="form-control" required>
										    </div>
										  </div>
									</div>	
										
										
										
										
										<div class="row">
											  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bank Name :</label>
														<input type="text" placeholder="" autocomplete="off" name="bank_name" value="${bank_name}" id="bank_name" class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Account No :</label>
												<input type="text" placeholder=""  autocomplete="off" name="account_no" value="${account_no}"  class="form-control" required>
											</div>
										 </div>
										 </div>
										
									   <div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">IFSC Code :</label>
												<input type="text" placeholder="" name="ifsc_code" value="${ifsc_code}" class="form-control" required>
											</div>
									     </div>
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Remark :</label>
												<input type="text" placeholder="" name="remark" value="${remark}" class="form-control" required>
											</div>
										</div>
										</div>
										
										
										
										<div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Experience :</label>
												<input type="text" placeholder="" name="experience" value="${experience}" class="form-control" required>
											</div>
									     </div>
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Emergency Contact No :</label>
												<input type="text" placeholder="" name="emer_contact" value="${emer_contact}"  class="form-control" required>
											</div>
										</div>
										</div>
										</s:iterator>
										
										
										
										<s:iterator value="fetchDriverDetails">
										<div id="product" style="width:100%">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%" colspan="5">

															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Sr. No.</th>
																		<th id="VLsparename"><label></label>
																		</th>
																		
																		<th id="VLsparename"><label></label>
																		</th>
																		
																		<th id="VLsparename"><label></label></th>
									  
									  								</tr>
									  								
									  								
									  								
									  								
									  								<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	
																	<tr class="item-row">
																	<td style="width:1px;">1</td>
																	<td>Driver Photo</td>
																		<td colspan="2"><input type="file" name="photo"  value="" multiple accept='image/*' class="form-control"  /></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">2</td>
																	<td>Aadhar Card</td>
																		<td><input type="text" name="aadhar_no" value="${aadhar_no}" class="form-control"
																			style="width: 260px;"   
																			tabindex="11" /></td>
																		<td><input type="file" name="photo"  multiple accept='image/*' class="form-control" /></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>Driving License</td>
																		<td><input type="text" name="license_no" value="${license_no}" class="form-control"
																			style="width: 260px;" id="quantity" 
																			tabindex="11" onblur="getnewsrno(this);"  /></td>
																		<td><input type="file" name="photo" multiple accept='image/*'  class="form-control" />
																		</td>
									  								</tr>
									  								
									  								
									  								
									  								
									  								
									  								</table>
									  		
									  						</td>
									  					</tr>
									  				</table>
									  			</div>
										</s:iterator>
										
										
										
										
										
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
									</div>
									
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--End page content-->
			</div>
			<!--END CONTENT CONTAINER-->
			
			<!--MAIN NAVIGATION-->
			<nav id="mainnav-container">
				<div id="mainnav">
					<!--Shortcut buttons-->
					<div id="mainnav-shortcut">
						<ul class="list-unstyled">
							<li class="col-xs-4" data-content="Additional Sidebar">
								<a id="demo-toggle-aside" class="shortcut-grid" href="#">
									<i class="fa fa-magic"></i>
								</a>
							</li>
							<li class="col-xs-4" data-content="Notification">
								<a id="demo-alert" class="shortcut-grid" href="#">
									<i class="fa fa-bullhorn"></i>
								</a>
							</li>
							<li class="col-xs-4" data-content="Page Alerts">
								<a id="demo-page-alert" class="shortcut-grid" href="#">
									<i class="fa fa-bell"></i>
								</a>
							</li>
						</ul>
					</div>
					<!--End shortcut buttons-->

					<!--Menu-->
					<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
					<!--End menu-->
				</div>
			</nav>
			<!--END MAIN NAVIGATION-->
		</div>
		
		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->
	</div>
	<!-- END OF CONTAINER -->
	
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>
