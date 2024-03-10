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
	
	
	<script src="js/datevalidation.js" type="text/javascript"></script>
	
	<script>
	 $(function() {
		 //$("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#resource_from").autocomplete("GoogleSearch/autosearchResource.jsp");
		 //$("#exim").autocomplete("GoogleSearch/autosearchResource2.jsp");
		 
		 ///$("#name").autocomplete("GoogleSearch/autosearchName.jsp");
		 
	});
	
	
	</script>
	<script>
function checkMobileLength()
{   
		var x=/[a-zA-Z]/g;
			
		var dealer_contact=document.getElementById("contact_no").value;
			
	 if(dealer_contact.length!=0)
		{
			if(dealer_contact.match(x))
			{
			alert("Only digit is allowed for mobile number")
			document.getElementById("contact_no").value='';
			document.getElementById("contact_no").focus();
			return false;
			}
			else if(dealer_contact.length<10||dealer_contact.length>10)
			{
			alert("Enter only 10 digits for mobile number");
			document.getElementById("contact_no").value='';
			document.getElementById("contact_no").focus();
			
			return false;
			}
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
					<h1 class="page-header text-overflow">Company Contact Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Company</a></li>
					<li class="active">Company Contact Form</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								<!-- <div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div> -->
								
								<form action="CompanyContactInsert" method="POST" class="form-group">
									
									
								<div class="panel-body">
									
									 <div class="row">
								
									
									<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Company Name :</label>
													<input type="text" class="form-control"  id="name" name="name"   required>
												</div>
									  </div>
									
									
									</div>
									
									
									 
									  <div class="row">
									  
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person :</label>
													<input type="text" class="form-control"  id="contactp" name="contactp"   required>
												</div>
									  </div>
									  
									  </div>
									  
									   <div class="row">
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact No :</label>
													<input type="text" class="form-control"  id="contact_no" name="contact_no"   maxlength="10" onblur="checkMobileLength();" required>
												</div>
									  </div>
									  </div>
									  
									  
									  
									  
										
										
									<div class="row">
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Department:</label>
													<input type="text" class="form-control"  name="remark" id="remark"  required>
												</div>
											</div>
											
										</div>	
										
										
											
									  								
									  								
									  <div class="row">
									  <div class="col-sm-6">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
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
    <%-- <jsp:include page="/common/settings.jsp"></jsp:include> --%>
    <jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
<%-- 	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
 --%></body>
</html>

							
