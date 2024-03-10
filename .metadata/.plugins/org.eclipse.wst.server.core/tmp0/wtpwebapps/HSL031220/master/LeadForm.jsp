<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		 $("#resource").autocomplete("GoogleSearch/resource.jsp");
	});
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
					<h1 class="page-header text-overflow">Lead Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Lead</a></li>
					<li class="active">Lead Form</li>
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
								<form action="LeadForm" method="POST">
									<div class="panel-body">
									<div class="row">
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Customer Name :
                                                    </label>
                                                    <input type="text" class="form-control"  id="customer_name" pattern="[A-Z a-z]*" onblur="checkInp1()" autocomplete="off"   name="customer_name" required> 
                                                </div>
                                       		 </div>
                                       		 
                                       		 <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wlastName2"> Contact No :
                                                    </label>
                                                    <input type="text" class="form-control"  id="contactno"  autocomplete="off" pattern="[0-9]*" maxlength="10" name="contact_no" required> 
                                                </div>
                                            </div>
                                       		 
                                       		</div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wemailAddress2"> Product :
                                                    </label>
                                                    <input type="text" class="form-control" pattern="[A-Z a-z]*" id="product" autocomplete="off" name="product" required> 
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wphoneNumber2">Amount :</label>
                                                    <input type="text" class="form-control " id="amount" pattern="[0-9]*" autocomplete="off" pattern="[0-9]*" name="amount" required> </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wphoneNumber2">City :</label>
                                                    <input type="text" class="form-control" autocomplete="off" pattern="[A-Z a-z]*" id="city" pattern="[a-z A-Z]*" name="city" required> </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wdate2">Zone :</label>
                                                    <input type="text" class="form-control" autocomplete="off" id="zone" pattern="[A-Z a-z]*" pattern="[a-z A-Z]*" name="zone" required> </div>
                                            </div>
                                        </div>
                                        
                                         <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wphoneNumber2">Area :</label>
                                                    <input type="text" class="form-control" autocomplete="off"  pattern="[A-Z a-z]*" id="area" pattern="[a-z A-Z]*" name="area" required> </div>
                                            </div>
                                             <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wdate2">Date :</label>
                                                    <input type="date" class="form-control"   id="date" style="line-height: 15px;"  name="requiredDate" required> 
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wphoneNumber2">Remark :</label>
                                                    <input type="text" class="form-control" autocomplete="off" pattern="[A-Z a-z]*" id="remark" pattern="[a-z A-Z]*" name="remark" required> </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wdate2">Contact Person :</label>
                                                    <input type="text" class="form-control" autocomplete="off" pattern="[A-Z a-z]*" pattern="[a-z A-Z]*" id="contact_person" name="contact_person" required> </div>
                                            </div>
                                        </div>
                                        
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wphoneNumber2">Image :</label>
                                                    <input type="file" class="form-control" id="image" name="image"> </div>
                                            </div>
                                             <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wdate2">Resource :</label>
                                                    <input type="text" class="form-control" autocomplete="off" pattern="[A-Z a-z]*" id="resource" pattern="[a-z A-Z]*" id="resource" name="resource" required> </div>
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

