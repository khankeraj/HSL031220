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
								<form action="update_student_master_details" id="submitForm" method="POST" onsubmit="location.href='quot_Index'">
									<div class="panel-body">
									<s:iterator value="fetchStudentDetails">
									<div class="row">
     						            <div class="col-md-6">
							              <div class="form-group">
							                <label>Name </label>
							                <input type="text" class="form-control" value="${name}" name="name"  placeholder="Name" required/>
							              </div>
							            </div>
							           
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label> Address </label>
							                <input type="text" class="form-control" value="${address}" name="address" placeholder=" Address" required>
							              </div>
							            </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>City</label>
							                <input type="text" class="form-control" name="city" value="${city}" placeholder="" required>
							              </div>
							            </div>
							          </div>
							          
							    
							       
							             <div class="col-md-6">
							              <div class="form-group">
							                <label>Mobile</label>
							                <input type="text" class="form-control" name="mobile" value="${mobile}"   placeholder="Mobile" required>
							              </div>
							            </div>
							          </div>
							          
						           <div class="col-sm-6">
									    <div class="form-group">
									        <label class="control-label">Gender</label>
									        
									        <div class="radio">
									            <label>
									                <input type="radio" name="gender" value="male"> Male
									            </label>
									        </div>
									
									        <div class="radio">
									            <label>
									                <input type="radio" name="gender" value="Female"> Female
									            </label>
									        </div>
									    </div>
									</div>
							            
			
			
									<div class="col-sm-6">
									    <div class="form-group">
									        <label class="control-label">Language</label>
									        
									        <div class="checkbox">
									            <label>
									                <input type="checkbox" name="language" value="Java"> Java
									            </label>
									        </div>
									
									        <div class="checkbox">
									            <label>
									                <input type="checkbox" name="language" value="c++"> c++
									            </label>
									        </div>
									
									        <div class="checkbox">
									            <label>
									                <input type="checkbox" name="language" value="Php"> PHP
									            </label>
									        </div>
									    </div>
									</div>
							          
							          
							          <div class="row">
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Email</label>
							                <input type="text" class="form-control" name="email" value="${email}" placeholder="Email" required>
							              </div>
							            </div>
							               </div>
							            
							            <div class="col-md-6">
							              <div class="form-group">
							                <label>Department</label>
							                <input type="text" class="form-control" name="department" value="${department}" placeholder="Department" required>
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

