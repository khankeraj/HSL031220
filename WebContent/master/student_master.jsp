<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link
	href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css"
	rel="stylesheet">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<!-- AutoSearch -->
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js"
	type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script>
<!-- AutoSearch -->


<script>
	$(function() {
		$("#city").autocomplete("GoogleSearch/autosearchCity.jsp");
	})



												function checkEmail(v){
													
													var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
													
													if(v.value.match(mailformat))
													{
													
														return true;
													}
													else{
														alert("You have entered an invalid email address!");
														return false;
													}
												}

	
	function mobileCheck(v)
	{
	        if( v.value == "" ||
	        		isNaN( v.value) ||
	        		v.value.length != 10 )
	        		{
	        		alert( "Please provide a valid Mobile No" );
	        		/* v.focus() ; */
}
	        
	  
	}
	

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
					<h1 class="page-header text-overflow">Student Master</h1>
				</div>
				<!--End page title-->

				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Student Master</li>
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
								<form action="student_master_insert" id="submitForm"
									method="POST">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label> Name </label> <input type="text"
														class="form-control" name="name" required />
												</div>
											</div>


											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label> Address </label> <input type="text"
															class="form-control" name="address" required>
													</div>
												</div>


												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label> City </label> <input type="text"
																class="form-control" name="city" required>
														</div>
													</div>


													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label">Gender</label>

															<div class="radio">
																<label> <input type="radio" name="gender"
																	value="male"> Male
																</label>
															</div>

															<div class="radio">
																<label> <input type="radio" name="gender"
																	value="Female"> Female
																</label>
															</div>
														</div>
													</div>


													<div class="col-sm-6">
														<div class="form-group">
															<label class="control-label">Language</label>

															<div class="checkbox">
																<label> <input type="checkbox" name="language"
																	value="Java"> Java
																</label>
															</div>

															<div class="checkbox">
																<label> <input type="checkbox" name="language"
																	value="c++"> c++
																</label>
															</div>

															<div class="checkbox">
																<label> <input type="checkbox" name="language"
																	value="Php"> PHP
																</label>
															</div>
														</div>
													</div>



													<div class="col-md-6">
														<div class="form-group">
															<label>Mobile</label> <input type="text"
																class="form-control" name="mobile" id="mobile" required>
														</div>
													</div>
												</div>




												<div class="col-md-6">
													<div class="form-group">
														<label> Email </label> <input type="email"
															class="form-control" name="email" id="email" required>
													</div>
												</div>
											</div>



											<div class="col-md-6">
												<div class="form-group">
													<label>Department </label> <input type="department"
														class="form-control" name="department" required>
												</div>
											</div>
										</div>


										<div class="panel-footer">
											<div class="row">
												<div class="col-sm-9 col-sm-offset-3">
													<button
														class="btn btn-success btn-labeled fa fa-check fa-lg"
														style="margin-left: 10px" type="submit">Submit</button>

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
						<li class="col-xs-4" data-content="Additional Sidebar"><a
							id="demo-toggle-aside" class="shortcut-grid" href="#"> <i
								class="fa fa-magic"></i>
						</a></li>
						<li class="col-xs-4" data-content="Notification"><a
							id="demo-alert" class="shortcut-grid" href="#"> <i
								class="fa fa-bullhorn"></i>
						</a></li>
						<li class="col-xs-4" data-content="Page Alerts"><a
							id="demo-page-alert" class="shortcut-grid" href="#"> <i
								class="fa fa-bell"></i>
						</a></li>
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
	<script
		src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

