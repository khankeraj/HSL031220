<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script>
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
								<form action="update_customer_master_details" id="submitForm" method="POST" onsubmit="location.href='quot_Index'">
									<div class="panel-body">
									<s:iterator value="fetchCustomerDetails">
									<div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer Name </label>
							                <input type="hidden" name="update_customer_id" value="${customer_id}"> 
							                <input type="text" class="form-control" value="${customer_name}" name="customer_name"  placeholder="Customer Name" required/>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Contact Person</label>
							                <input type="text" class="form-control" name="company_name" value="${company_name}"  id="cust_subname"  placeholder="Company Name" required>
							                <input type="hidden" name="Cust_id" class="form-control" maxlength="100"/></td>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer Address </label>
							                <input type="text" class="form-control" value="${customer_address}" name="customer_address" placeholder="Customer Address" required>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Contact Number</label>
							                <input type="text" class="form-control" name="customer_mobile" value="${customer_mobile}" id="Mob_no" pattern="[0-9]*" maxlength="10" onblur="ValidateMoNo();" placeholder="Mobile No" required>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Phone No </label>
							                <input type="text" class="form-control" name="phone_no" value="${phone_no}"  id="Ph_no"  onblur="ValidateMoNo()" placeholder="Phone No" required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>State </label>
							                <input type="text" class="form-control"  value="${state}" name="state"  id="brand" onblur="checkInp1()" placeholder="State" required>
							              </div>
							            </div>
							          </div>
							           <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>City </label>
							                <input type="text" class="form-control"  value="${city}" name="city" id="city" onblur="checkInp2()" placeholder="City" required>
							              </div>
							            </div>
							             <div class="col-md-6">
							              <div class="form-group">
							                <label>Pincode No </label>
							                <input type="text" class="form-control" name="pincode_no" value="${pincode_no}"  id="pincode" onblur="checkInp1()" placeholder="Pincode No" required>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Pan No </label>
							                <input type="text" class="form-control" name="pan_no" value="${pan_no}" id="panno" onblur="checkInp1()" placeholder="Pan No" required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Customer GST NO </label>
							                <input type="text" class="form-control" name="customer_gst_no" value="${customer_gst_no}" id="Cust_vat_tin" onblur="checkInp3()" placeholder="Customer GST NO" required>
							              </div>
							            </div>
							          </div>
							          
							          
							          
							          <div class="row">
							          <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Type:</label>
													
													<select class="form-control show-tick " name="type" id="type" >
																<option value="${type}">${type}</option>
															
																<option value="Contracted">Contracted</option>
																<option value="Existing">Existing</option>
																<option value="Non Existing">Non Existing</option>
																
																
													</select>
												</div>
							          </div>
							          </div>
							          
							          </s:iterator>
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
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

