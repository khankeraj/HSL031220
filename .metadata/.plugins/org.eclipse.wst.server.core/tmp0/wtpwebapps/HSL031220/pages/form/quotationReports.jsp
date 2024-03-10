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
		
	var res = id.split("/");
	var id1=res[0];
	var quotation_name=res[1];
	
	var lead_no=document.getElementById("lead_no").value;
	var customer_name=document.getElementById("customer_name").value;
	
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (xhttp.readyState == 4 && xhttp.status == 200) {
	      var ref_no =xhttp.responseText;
	      if(id1==1){
				location.href="contractForm?lead_no="+lead_no+"&customer_name="+customer_name+"&ref_no="+ref_no;
	    	  //location.href="contractForm?lead_no="+lead_no+"&customer_name="+customer_name;
			}
	    }
	  };
	  xhttp.open("POST", "fetchRefrenceNO?quotation_name="+quotation_name, true);
	  xhttp.send();
	  
}

</script>
</head>
<body>
<%
String lead_no=request.getParameter("lead_no");

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
												  
												  
												   <!--  <input type="hidden" id="lead_no" value="<%=lead_no%>">-->
												   <input type="hidden" id="lead_no" name="lead_no" value="<%=lead_no%>">
												  <!--  <input type="hidden" id="customer_name" value="<%=customer_name%>">-->
												   <input type="hidden" id="customer_name" name="customer_name" value="<%=customer_name%>">
												
												  <select class="selectpicker" data-live-search="true" name="quotation_name" onchange="getQuotationName(this.value)" data-width="100%">
													<option selected disabled>Select Reports</option>	
													<option value="1/PDWP">Project Reports-PDWP</option>
													<option value="2/ROPlant">RO Plant</option>
													<option value="3/WaterATM">Water ATM</option>
													<option value="4/DomesticRO">Domestic RO</option>
													<option value="5/AMC">AMC</option>
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

