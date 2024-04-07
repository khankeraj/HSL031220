<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
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
					<h1 class="page-header text-overflow">Meeting Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Meeting</a></li>
					<li class="active">Meeting Form</li>
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
								<form action="Meeting_From_Update" method="POST">
									<div class="panel-body">
									<s:iterator value="leadForm2">
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name :</label>
													<input type="hidden" value="${cust_id}">
													<input type="text" class="form-control" placeholder="" value="${customer_name}" name="customer_name" class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact No :</label>
													<input type="text" placeholder=""  name="contact_no"  value="${contact_no}" class="form-control" required>
												</div>
											</div>
									  </div>
									  </s:iterator>
									
									 <div class="row">
									 <s:iterator value="leadForm2">
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Date :</label>
												<input type="date" placeholder=""  name="requiredDate"  style="line-height: 15px;" value="${requiredDate}" class="form-control" required>
											</div>
										</div>
										</s:iterator>
											<div class="col-sm-6">
												<div class="form-group">
												<label class="control-label">Select Status :</label>
												   <select class="selectpicker" data-live-search="true" style="margin-top: -9px;" name="meeting_status" data-width="100%">
													<option value="HOT">HOT</option>
													<option value="UCOLD">COLD</option>
													<option value="WARM">WARM</option>
												   </select>
												</div>
											</div>
										</div>
										
										<div class="row">
										  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Next Meeting Date:</label>
												<input type="date" placeholder="" name="next_meeting_date" style="line-height: 15px;" class="form-control" required>
											</div>
										  </div>
										  
										  <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Description :</label>
												<input type="text" placeholder=""  autocomplete="off" name="description" class="form-control" required>
										    </div>
										  </div>
										 </div>
										
									<s:iterator value="leadForm2">	
									   <div class="row">
									    <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Remark :</label>
													<input type="text" placeholder="" autocomplete="off" value="${remark}" name="remark" pattern="[a-z A-Z]*" class="form-control" required>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Amount :</label>
												<input type="text" placeholder="" autocomplete="off" value="${amount}" name="amount" pattern="[0-9]*" class="form-control" required>
											</div>
										 </div>
										</div>
										</s:iterator>
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<%String lead_no=request.getParameter("lead_no");%>
												<input type="text" name="lead_serial_no" value="<%=lead_no%>">
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

