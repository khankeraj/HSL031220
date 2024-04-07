<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">

<script>
function getQuotationName(id)
{
	alert(id);
	/* 	
	var res = id.split("/");
	var id1=res[0];
	var quotation_name=res[1];
	
	var lead_no=document.getElementById("lead_no").value;
	var customer_name=document.getElementById("customer_name").value;
	
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	      var ref_no =xhttp.responseText;
	      
	    }
	  };
	  xhttp.open("POST", "fetchRefrenceNO?quotation_name="+quotation_name, true);
	  xhttp.send(); */
	  var lead_no=document.getElementById("lead_no").value;
	  var quotation_edit_id=document.getElementById("quotation_edit_id").value;
	if(id==1){
		location.href="contract_edit_Master?lead_no="+lead_no+"&quotation_edit_id="+quotation_edit_id;
	}
	  
}

</script>
</head>
<body>
<%
String lead_no=request.getParameter("lead_no");
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
					<h1 class="page-header text-overflow">Submit Quotation Name</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Meeting</a></li>
					<li class="active">Submit Quotation Name</li>
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
								
									<div class="panel-body">
									
									 <div class="row">
									 <!-- <input type="text" name="setreportsvalue" id="setreportsvalue"> -->
											<div class="col-sm-6">
												<div class="form-group">
												   <p class="text-thin mar-btm">Select Quotation Reports :</p>
												  
												   <input type="text" id="lead_no" value="<%=lead_no%>">
												   <input type="text" id="quotation_edit_id" value="<%=quotation_edit_id%>">
												  <select class="selectpicker" data-live-search="true" name="quotation_name" onchange="getQuotationName(this.value)" data-width="100%">
													<option selected disabled>Select Reports</option>	
													<option value="1">Project Reports-PDWP</option>
													<option value="2">RO Plant</option>
													<option value="3">Water ATM</option>
													<option value="4">Domestic RO</option>
													<option value="5">AMC</option>
												  </select>
												  
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

