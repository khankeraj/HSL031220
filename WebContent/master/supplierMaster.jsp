<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
					<h1 class="page-header text-overflow">Supplier Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Supplier Master</li>
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
								
								<form action="Suppiler_Company_Master_Action" theme="simple" id="FormID" method="POST">
								   <div class="panel-body">
								   	 <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Supplier Name :</label>
													<input type="text" placeholder="" name="company_name"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Address :</label>
													<input type="text"  placeholder="" name="address"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mobile Number :</label>
													<input type="text" placeholder="" name="company_contact"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">State :</label>
													<input type="text"  placeholder="" name="state"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">GSTN NO :</label>
													<input type="text" placeholder="" name="city"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Email :</label>
													<input type="text"  placeholder="" name="email_id"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">city :</label>
													<input type="text" placeholder="" name="vatno"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PAN NO :</label>
													<input type="text"  placeholder="" name="cstno"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									   <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bank&nbsp;Name :</label>
													<input type="text" placeholder="" name="bank_name"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Account&nbsp;No :</label>
													<input type="text"  placeholder="" name="account_no"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">IFSC&nbsp;Code :</label>
													<input type="text" placeholder="" name="ifsc_code"   class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark :</label>
													<input type="text"  placeholder="" name="remark"  class="form-control" required>
												</div>
											</div>
									  </div>
									
								 		<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<input type="hidden" value="<%=quotation_id%>" name="quotation_id">
												<input type="hidden" name="customer_name" value="<%=customer_name%>">
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

