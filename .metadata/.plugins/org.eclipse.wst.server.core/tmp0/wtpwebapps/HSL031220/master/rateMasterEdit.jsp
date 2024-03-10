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
 
  <%-- <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
   --%>
   <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale2noreq.js" type="text/javascript"></script>
  
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->
	
	<script src="js/datevalidation.js" type="text/javascript"></script>
	
	
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script>
	$(function() {
		
		
		$("#name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		
		
		var today = new Date(); 
		var dd = today.getDate(); 
		var mm = today.getMonth()+1;//January is 0! 
		var yyyy = today.getFullYear(); 
		if(dd<10){dd='0'+dd} 
		if(mm<10){mm='0'+mm} 
		$("#date").val(dd+'/'+mm+'/'+yyyy);
		
		
		
		
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
					<h1 class="page-header text-overflow">Rate Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Rate Master</li>
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
								<s:push value="im">	
								<form action="Add_New_Rate" id="submitForm" method="POST" >
									
									
									<div class="panel-body">
									
									
									
									<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" value="${customer_name }" class="form-control" placeholder="" name="customer_name"  id="name"   class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" value="${date }"  class="form-control" placeholder="" name="date"  onblur="FixShortDate(this);return ValidateForm(this);"  class="form-control" >
												</div>
											</div>
											
										
									  </div>
									  
							          
							          <div class="row">
									   <div id="product" class="tab-pane table-responsive active">

								<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">

									<tbody>
										<tr>
										<th id="VLsparename" ><label>Type</label></th>
										<th id="VLsparename" ><label>Purchase Rate</label></th>
										<th id="VLsparename" ><label>Sale Rate</label></th>
										
									
																					
										</tr>
										<s:iterator value="(gridsize).{# this}" status="stat">
									<tr class="item-row">
											
									<td><input class="form-control" style="width:220px;"  type="text" name="typerate"  
									id="type" value="<s:property value="typerate[top]" />" readonly/></td>
									   
									   <td><input class="form-control" style="width:120px;"  type="text" name="purchaserate"  
									id="purchaserate" value="<s:property value="purchaserate[top]" />" /></td>
									
									<td><input class="form-control" style="width:120px;"  type="text" name="salerate"  
									id="salerate" value="<s:property value="salerate[top]" />" /></td>
									   </tr>
									   
									   </s:iterator>
									</tbody>
									
									</table>
									
									
									</div>
							          
							               </div>  
							                <input type="hidden" class="form-control"  name="no_of_box"  placeholder="No Of Box" />
							           
							               
							                <input type="hidden" class="form-control"  name="no_of_bag"  placeholder="No Of Bag" />
							             
							         
							         
							         
							         <div class="panel-footer">

										
											<div class="col-md-6">
												
												<button class="btn btn-success btn-labeled fa fa-check fa-lg"
													style="margin-left: 10px" type="submit">Submit</button>
												
												<button
													class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg"
													style="margin-left: 10px" type="reset"
													onclick="history.go(-1)">Back</button>
												
												<button
													class="btn btn-primary btn-labeled fa fa-repeat fa-lg"
													style="margin-left: 10px" type="reset">Reset</button>
											
											</div>
										</div>
							         
							         
							         
							         
							            
							          
							        </div>
							          
								</form>
								</s:push>
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


<%-- <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
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
					<h1 class="page-header text-overflow">City Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">City Master</li>
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
       
       
       
       <s:form action="Add_CityMaster" method="post" id="customerMaster" class="formular" onsubmit="return validateme(this);">
       
        <div class="panel-body">
         
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>City Name </label>
                <input type="text" class="form-control" name="name"  id="name"  placeholder="City Name" required>
             </div>
            </div>
            
          
            
            
            
          </div>
          
       
        </div>
         <!--  <div class="box-footer">
                <button type="submit" class="btn btn-success" name="Submit" id="Submit" value="Submit">Submit</button>&nbsp;
          </div>
          --> 
          
          <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" name="Submit" id="Submit" type="Submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
          
        </s:form>
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
</html> --%>



