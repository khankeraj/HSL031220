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
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
		 $("#designation").autocomplete("GoogleSearch/autosearchDesignation.jsp");
	});
	
	
	function phoneNumberCheck(v)
	{
		/* alert('here');
	  var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	  if((v.value.match(phoneno))
	        {
	      return true;
	        }
	      else
	        {
	        alert("message");
	        return false;
	        } */
	        /* alert('Hi '+v.value); */
	        
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
					<h1 class="page-header text-overflow">Employee Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Employee Master</li>
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
								
							<form action="Add_New_Employee" method="POST">
								<div class="panel-body">
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Employee Name:</label>
													<input type="text" class="form-control" placeholder="" name="employee_name"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Address :</label>
													<input type="text" class="form-control" placeholder="" name="address"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Mobile No :</label>
												<input type="text" placeholder=""  name="mobile_no" class="form-control" pattern="[0-9]*" maxlength="10" onblur="phoneNumberCheck(this);"  required>
											</div>
										</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date Of Joining :</label>
													<input type="date" placeholder=""  name="date_of_joining" style="line-height: 15px;"  class="form-control" required>
												</div>
											</div>
									  </div>
									
									 <div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Date Of Birth :</label>
												<input type="date" placeholder=""  style="line-height: 15px;"  name="date_of_birth" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Designation :</label>
												<input type="text" placeholder=""  autocomplete="off" name="designation" id="designation"  class="form-control" required>
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
												<label class="control-label">Remark :</label>
												<input type="text" placeholder="" name="remark"  class="form-control" required>
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
