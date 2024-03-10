<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
</head>
<body>
<%
String quotation_edit_id=request.getParameter("quotation_edit_id");
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
					<h1 class="page-header text-overflow">Edit Contractor Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Edit Contractor Master</li>
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
								<form action="EditQuotation" method="POST">
									<div class="panel-body">
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ref.No :</label>
													<input type="text" class="form-control" placeholder="Ref. No" name="ref_no" value="${ref_no}" class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date :</label>
													<input type="date" placeholder=""  name="requiredDate" value="${requiredDate}"  class="form-control" required>
												</div>
											</div>
									  </div>
									
									 <div class="row">
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">TO :</label>
												<input type="text" placeholder="TO" value="${to}"  name="to" class="form-control" required>
											</div>
										</div>
										
											<div class="col-sm-6">
												<div class="form-group">
												    <label class="control-label">Name 1 :</label>
													<input type="text" placeholder="Name 1" value="${name1}" pattern="[a-z A-Z]*" name="name1" class="form-control" required>
												</div>
											</div>
										</div>
										
										<div class="row">
										  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Name 2 :</label>
												<input type="text" placeholder="Name 2" value="${name2}" pattern="[a-z A-Z]*" name="name2" class="form-control" required>
											</div>
										  </div>
										  
										  <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Address :</label>
												<input type="text" placeholder="Address"  autocomplete="off" name="address" value="${address}" class="form-control" required>
										    </div>
										  </div>
										 </div>
										
									   <div class="row">
									    <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">State :</label>
													<input type="text" placeholder="State" autocomplete="off" name="state" value="${state}" pattern="[a-z A-Z]*" class="form-control" required>
											</div>
										</div>
										
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">City :</label>
												<input type="text" placeholder="City" autocomplete="off" name="city" value="${city}" pattern="[a-z A-Z]*" class="form-control" required>
											</div>
										 </div>
										</div>
										 
									<div class="row">
									    <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Contact No :</label>
												<input type="text" placeholder="Contact No" name="contact" value="${contact}" pattern="[0-9]{10}*" class="form-control" required>
											</div>
									     </div>
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Email :</label>
												<input type="text" placeholder="Email" name="email" value="${email}" class="form-control" required>
											</div>
										</div>
									</div>
										
									<div class="row">
									    <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Subject :</label>
												<input type="text" placeholder="Subject" name="subject" value="${subject}" pattern="[a-z A-Z]*" class="form-control" required>
											</div>
										</div>
									   <div class="col-sm-6">
										<div class="form-group">
											<label class="control-label">Pin Code :</label>
											<input type="text" placeholder="Pin Code" name="pincode" value="${pincode}" pattern="[0-9]*" class="form-control">
										</div>
										</div>
									</div>
										
									<div class="row">
									    <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Project CO-Ordinator Name :</label>
												<input type="text" placeholder="Project CO-Ordinator Name" value="${proCoOrdiName}" name="proCoOrdiName" pattern="[a-z A-Z]*" class="form-control">
											</div>
										</div>
									  <div class="col-sm-6">
										<div class="form-group">
											<label class="control-label">Project CO-Ordinator Contact :</label>
											<input type="hidden" name="update_id" value="${lead_no}"/>
											<input type="hidden" name="quotation_edit_id" value="<%=quotation_edit_id%>"/>
											<input type="text" placeholder="Project CO-Ordinator Contact" value="${proCoOrdiContactNo}" name="proCoOrdiContactNo" pattern="[0-9]*" class="form-control">
										</div>
									  </div>
									 </div>
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
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

