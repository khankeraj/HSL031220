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
					<h1 class="page-header text-overflow">Transporter Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Transporter Master</li>
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
								<form action="update_transporter_master_details" id="submitForm" method="POST">
									<div class="panel-body">
									<s:iterator value="fetchTransporterDetails">
									<div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Transporter Name </label>
							                 <input type="hidden" class="form-control"  name="transporter_id" value="${transporter_id}"  placeholder="Transporter ID" required/>
							                <input type="text" class="form-control"  name="transporter_name" value="${transporter_name}"  placeholder="Transporter Name" required/>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Company Name </label>
							                <input type="text" class="form-control" name="company_name" value="${company_name}" id="transporter_subname"  placeholder="Company Name" required>
							                <input type="hidden" name="Cust_id" class="form-control" maxlength="100"/></td>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Transporter Address </label>
							                <input type="text" class="form-control" name="transporter_address" value="${transporter_address}" placeholder="Transporter Address" required>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Mobile No</label>
							                <input type="text" class="form-control" name="transporter_mobile" value="${transporter_mobile}"  id="Mob_no" pattern="[0-9]*" maxlength="10" onblur="phoneNumberCheck(this);" placeholder="Transporter No" required>
							              </div>
							            </div>
							          </div>
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Phone No </label>
							                <input type="text" class="form-control" name="phone_no" value="${phone_no}" id="Ph_no"  onblur="ValidateMoNo()" placeholder="Phone No" required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Transporter Email  </label>
							                <input type="email" class="form-control"  name="email" value="${email}" id="email" onblur="checkEmail(this)" placeholder="Transporter Email" required>
							              </div>
							            </div>
							          </div>
							           <div class="row">
							           <div class="col-md-6">
							              <div class="form-group">
							                <label>State </label>
							                <input type="text" class="form-control" name="state"  value="${state}" id="brand" onblur="checkInp1()" placeholder="State" required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>City </label>
							                <input type="text" class="form-control" name="city" value="${city}" id="city" placeholder="City" required>
							              </div>
							            </div>
							          </div>
							          
							          
		          
							          <div class="row">
							          <div class="col-md-6">
							              <div class="form-group">
							                <label>Pincode No </label>
							                <input type="text" class="form-control" name="pincode_no" value="${pincode_no}"  id="pincode" onblur="checkInp1()" placeholder="Pincode No" required>
							              </div>
							            </div>
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Pan No </label>
							                <input type="text" class="form-control" name="pan_no" value="${pan_no}" id="panno" onblur="checkInp1()" placeholder="Pan No" required>
							              </div>
							            </div>
							          </div>
							          
							          
							          
							          
							          
							          
							          
							          <div class="row">
											  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bank Name </label>
														<input type="text" placeholder="Bank Name" autocomplete="off" name="bank_name"  value="${bank_name}" id="bank_name" class="form-control" required>
												</div>
											</div>
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Account No </label>
												<input type="text" placeholder="Account No"  autocomplete="off" name="account_no" value="${account_no}"   class="form-control" required>
											</div>
										 </div>
										 </div>
										
									   <div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">IFSC Code </label>
												<input type="text" placeholder="IFSC Code" name="ifsc_code"  value="${ifsc_code}" class="form-control" required>
											</div>
									     </div>
									     
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Branch </label>
												<input type="text" placeholder="branch" name="branch" value="${branch}"  class="form-control" required>
											</div>
										</div>
										</div>
										
							          <div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">Location</label>
												<input type="text"  name="loc"  id="loc" value="${loc}" class="form-control" required>
											</div>
									     </div>
									     
									     <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Remark </label>
												<input type="text"  name="remark" value="${remark}" class="form-control" required>
											</div>
										</div>
									     
										</div>
										
										
										<div class="row">
										 <div class="col-sm-6">	 
											<div class="form-group">
												<label class="control-label">GSTN</label>
												<input type="text"  name="gstn"  id="gstn" value="${gstn}" class="form-control" required>
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

