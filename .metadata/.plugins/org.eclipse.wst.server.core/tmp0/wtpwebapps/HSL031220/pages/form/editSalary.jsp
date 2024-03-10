
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
	
	
	
	</script> --%>
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
	
	<script>
	$(function() {
		 $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
	});
	</script>
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
					<h1 class="page-header text-overflow">Driver Salary</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Driver Salary</a></li>
					<li class="active">Salary Form</li>
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
								
							<form action="update_salary_details" method="POST">
							<s:iterator value="drivermodeldetails">
								<div class="panel-body">
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="hidden" class="form-control" placeholder="" name="sal_id" id="sal_id" value="${sal_id}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
													<input type="text" class="form-control" placeholder="" name="driver_name" id="driver_name" value="${driver_name}-${driver_id}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date :</label>
													<input type="date" class="form-control" placeholder="" style="line-height: 15px;" name="date" value="${date}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  <div class="col-sm-6">
											<div class="form-group">
												<p class="text-thin mar-btm">Month :</p>
												
													<select  style="width:100%;height:30px;" name="month">
																<option value="">Select</option>
													 			<option value="January">January</option>

																<option value="February">February</option>

																<option value="March">March</option>
																<option value="April">April</option>
																<option value="May">May</option>
																<option value="June">June</option>
																<option value="July">July</option>
																<option value="August">August</option>
																<option value="September">September</option>
																<option value="October">October</option>
																<option value="November">November</option>
																<option value="December">December</option>
													</select>
											</div>
										</div>
											<div class="col-sm-6">
												<div class="form-group">
												    <p class="text-thin mar-btm">Year :</p>
													
													<select style="width:100%; height:30px;" name="year" >
													  <option value="">Select</option>
													  <option value="2019">2019</option>
													  <option value="2020">2020</option>
													  <option value="2021">2021</option>
													  <option value="2022">2022</option>
													  
												   </select>
												</div>
											</div>
									  </div>
									
									 
										
										
										
										
										<div class="row">
											  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total Days Present :</label>
														<input type="text" placeholder="" autocomplete="off" name="days_present" value="${days_present}"  id="bank_name" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Tax :</label>
												<input type="text" placeholder=""  autocomplete="off" name="tax" value="${tax}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
											</div>
										 </div>
										 </div>
										
									   <div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Bonus :</label>
												<input type="text" placeholder="" name="bonus" value="${bonus}"  class="form-control" required>
											</div>
									     </div>
									     
										
										
										<div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Other :</label>
												<input type="text" placeholder="" name="other" value="${other}"  class="form-control" required>
											</div>
									     </div>
										</div>
										
										
										
										<div class="row">
										 
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Fine :</label>
												<input type="text" placeholder="" name="fine"  value="${fine}" class="form-control" pattern="[0-9]*" maxlength="10" onblur="phoneNumberCheck(this);"required>
											</div>
										</div>
										
										
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Overtime :</label>
												<input type="text" placeholder="" name="overtime" value="${overtime}"  class="form-control" required>
											</div>
										</div>
										
										
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
									</s:iterator>
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
