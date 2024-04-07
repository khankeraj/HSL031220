<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script>
</script>
</head>
<body>
<%
String quotation_id=request.getParameter("quotation_id");
String customer_name=request.getParameter("customer_name");
String lead_no=request.getParameter("lead_no");

%>
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Sales Agreement Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Sales Agreement Master</li>
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
								<form action="InsertSalesAgreement" method="POST">
								<div class="panel-body">
								
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Agreement Subject :</label>
													<input type="text" class="form-control" placeholder="" name="agreement_subject"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Name :</label>
													<input type="text" class="form-control" placeholder="" name="name"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Firm Name :</label>
													<input type="text" class="form-control" placeholder="" name="firm_name"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Registration NO :</label>
													<input type="text" class="form-control" placeholder="" name="reg_no"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									   <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Office Address :</label>
													<input type="text" class="form-control" placeholder="" name="office_address"   class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">City :</label>
													<input type="text" class="form-control" placeholder="" name="city"   class="form-control" required>
												</div>
											</div>
									    </div>
									    
									    <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PinCode :</label>
													<input type="text" class="form-control" placeholder="" name="pincode"   class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Authorized Signatoy :</label>
													<input type="text" class="form-control" placeholder="" name="authorized_signatory"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									   <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Quotation No :</label>
													<input type="text" class="form-control" placeholder="" name="quotation_no"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date Of Quotation:</label>
													<input type="date" class="form-control" style="line-height: 15px;" placeholder="" name="date_of_quotation"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Order No :</label>
													<input type="text" class="form-control" placeholder="" name="order_no"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Second Part Payment:</label>
													<input type="text" class="form-control" placeholder="" name="second_part_payment"   class="form-control" required>
												</div>
											</div>
									  </div>
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<%-- <input type="hidden" value="<%=quotation_id%>" name="quotation_id"> --%>
												
												<input type="text" name="lead_no" value="<%=lead_no%>">
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
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

