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
												
												$(function() {
													
													 $("#city").autocomplete("GoogleSearch/autosearchCity.jsp");
												});
										
												
												
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
					<h1 class="page-header text-overflow">Customer Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Customer Master</li>
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
								<form action="customer_master_insert" id="submitForm" method="POST">
									<div class="panel-body">
									<div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer Name </label>
							                <input type="text" class="form-control"   name="customer_name"   required/>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Contact Person </label>
							                <input type="text" class="form-control" name="company_name" id="cust_subname"   required>
							                <input type="hidden" name="Cust_id" class="form-control" maxlength="100"/></td>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer Address </label>
							                <input type="text" class="form-control"  name="customer_address"  required>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Contact Number</label>
							                <input type="text" class="form-control" name="customer_mobile" id="Mob_no" pattern="[0-9]*" maxlength="10" onblur="phoneNumberCheck(this);"  required>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Phone No </label>
							                <input type="text" class="form-control" name="phone_no"  id="Ph_no"  onblur="ValidateMoNo()"  required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer Email  </label>
							                <input type="email" class="form-control"  name="email"  id="email" onblur="checkEmail(this)"  required>
							              </div>
							            </div>
							          </div>
							           <div class="row">
							           <div class="col-md-6">
							              <div class="form-group">
							                <label>State </label>
							                <input type="text" class="form-control"  name="state"  id="brand" onblur="checkInp1()"  required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>City </label>
							                <input type="text" class="form-control" name="city" id="city"  required>
							              </div>
							            </div>
							          </div>
								          <div class="row">
							          <div class="col-md-6">
							              <div class="form-group">
							                <label>Pincode No </label>
							                <input type="text" class="form-control" name="pincode_no"  id="pincode" onblur="checkInp1()"  required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Pan No </label>
							                <input type="text" class="form-control" name="pan_no"  id="panno" onblur="checkInp1()"  required>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							          <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer GST NO </label>
							                <input type="text" class="form-control"   name="customer_gst_no" id="Cust_vat_tin" onblur="checkInp3()"  required>
							              </div>
							            </div>
							         
							         <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Type:</label>
													
													<select class="form-control show-tick " name="type" id="type" >
												
																<option value=" ">.............Select.............</option>
			
																<option value="Contracted">Contracted</option>
																<option value="Existing">Existing</option>
																<option value="Non Existing">Non Existing</option>
																
																
													</select>
												</div>
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

