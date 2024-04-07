
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
	<script>
	function phoneNumberCheck(v)
	{
	        
	        if( v.value == "" ||
	        		isNaN( v.value) ||
	        		v.value.length != 10 )
	        		{
	        		alert( "Please provide a valid Mobile No" );
	        		/* v.focus() ; */

	        		
	        		}
	        
	  
	}
	
	function getAge(v){
		
		/* alert(v.value); */
		var dob = v.value;
		var year = Number(dob.substr(0, 4));
		var month = Number(dob.substr(5, 2)) - 1;
		var day = Number(dob.substr(8, 2));
		
		var today = new Date();
		var age = today.getFullYear() - year;
		if (today.getMonth() < month || (today.getMonth() == month && today.getDate() < day)) {
		  age--;
		}
		
		/* alert("year - "+year+" month - "+month+" day - "+day+" today - "+today);
		alert(age); */
		document.getElementById("age").value = age;
	}
	
	
	
	</script>
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
								
							<form action="Add_New_Driver" method="POST" enctype="multipart/form-data">
								<div class="panel-body">
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="text" class="form-control" placeholder="" name="driver_name"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Address(Permanent) :</label>
													<input type="text" class="form-control" placeholder="" name="addr_permanent"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Driver Address(Current) :</label>
												<input type="text" placeholder=""  name="addr_curr" class="form-control" required>
											</div>
										</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number :</label>
													<input type="text" placeholder=""  name="contact_number" style="line-height: 15px;" pattern="[0-9]*" maxlength="10" class="form-control" onblur="phoneNumberCheck(this);" required>
												</div>
											</div>
									  </div>
									
									 <div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Date Of Birth :</label>
												<input type="date" placeholder="" style="line-height: 15px;"  name="date_of_birth" onblur="getAge(this);" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Age :</label>
												<input type="text" placeholder=""  autocomplete="off" name="age" id="age" class="form-control" required>
										    </div>
										  </div>
									</div>
										
										
									<div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Salary Type :</label>
												<input type="text" placeholder=""  name="salary_type" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Basic Salary :</label>
												<input type="text" placeholder=""  autocomplete="off" name="basic_salary"  class="form-control" required>
										    </div>
										  </div>
									</div>	
										
										
										
										
										<div class="row">
											  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bank Name :</label>
														<input type="text" placeholder="" autocomplete="off" name="bank_name" id="bank_name" class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Account No :</label>
												<input type="text" placeholder=""  autocomplete="off" name="account_no"  class="form-control" required>
											</div>
										 </div>
										 </div>
										
									   <div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">IFSC Code :</label>
												<input type="text" placeholder="" name="ifsc_code"  class="form-control" required>
											</div>
									     </div>
									     
										
										
										<div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Experience :</label>
												<input type="text" placeholder="" name="experience"  class="form-control" required>
											</div>
									     </div>
										</div>
										
										
										
										<div class="row">
										 
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Emergency Contact No :</label>
												<input type="text" placeholder="" name="emer_contact"  class="form-control" pattern="[0-9]*" maxlength="10" onblur="phoneNumberCheck(this);"required>
											</div>
										</div>
										
										
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Remark :</label>
												<input type="text" placeholder="" name="remark"  class="form-control" required>
											</div>
										</div>
										
										
										</div>
										
										
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
																		<td colspan="2"><input type="file" name="photo" multiple accept='image/*' class="form-control" required /></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">2</td>
																	<td>Aadhar Card</td>
																		<td><input type="text" name="aadhar_no" class="form-control"
																			style="width: 260px;"  value=""  placeholder="Aadhar card number"
																			tabindex="11" required/></td>
																		<td><input type="file" name="photo" multiple accept='image/*' class="form-control" required/></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>Driving License</td>
																		<td><input type="text" name="license_no" class="form-control" placeholder="Driving license number"
																			style="width: 260px;" id="quantity" value="" 
																			tabindex="11" required /></td>
																		<td><input type="file" name="photo" multiple accept='image/*' class="form-control" required/>
																		</td>
									  								</tr>
									  								
									  								
									  								
									  								
									  								
									  								</table>
									  		
									  						</td>
									  					</tr>
									  				</table>
									  			</div>
										
										
										
										
										
										
										
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
