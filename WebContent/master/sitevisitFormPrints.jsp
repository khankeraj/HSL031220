<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
<script type="text/javascript">
	 function printData()
	 {
		
	    var divToPrint=document.getElementById("siteVisit");
	    newWin= window.open("");
	    newWin.document.write(divToPrint.outerHTML);
	    newWin.print();
	    newWin.close();
	 }
	 
	 function goHome(){
		 
		 location.href="siteVisitForm";
	 }
	 
</script>
<style>
.indented {
  padding-left: 50pt;
  padding-right: 50pt;
}
</style>
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
					<h1 class="page-header text-overflow">Site Visit</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Site Visit Form</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
				<div>
					<input type="button" name="Print"
					id="Print" value="Print" class="NFButton" onclick="printData('printsQuotation')">
					<input type="button" name="Home"
					id="Home" value="Home" class="NFButton" onclick="goHome()">
				</div>
					<div id="siteVisit">
						<table style="border: 1px solid black;width:100%;border-collapse:collapse;page-break-inside: auto"">
							<tr>
								<td>
									<table width="50%;">
										<tr>
										<td width="40%;">Client Name:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${client_name}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Client Address:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${client_address}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Customer Email:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${customer_email}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Plot Type:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${plot_type}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Water Source:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${water_source}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Road Connectivity:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${road_connectivity}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Construction Area:</td>
										<s:iterator value="siteVistorPrints"><td width="25%;">${construction_area}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">BIS Circle:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${bis_circle}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Actual Photograph of site :</td>
										<s:iterator value="siteVistorPrints"><td width="10%;"><img height="50px;" src="1SG6fvyBFMKkmZSiBsTpkRA.jpeg"></td></s:iterator>
										</tr>
												
										<tr align="center" style="margin-top: 100px;">
										<td width="50%;">Project Co-Ordinator Signature </td>
										</tr>
									</table>
								</td>
								<td>
								   <table width="50%;">
										<tr>
										<td width="40%;">Date:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${requiredDate}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Customer Mobile No:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${customer_mobile}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Project CO-Ordinator Name:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${project_coordinator}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Plot Area:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${plot_area}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Electricity Source:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${electricity_Source}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Construction Type:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${cosntruction_type}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Reject Water:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${reject_water}</td></s:iterator>
										</tr>
										<tr>
										<td width="40%;">Project CO-Ordinator Remarks:</td>
										<s:iterator value="siteVistorPrints"><td width="10%;">${project_coordinator_remarks}</td></s:iterator>
										</tr>
										
										<tr align="center" style="margin-top: 100px;">
										<td width="50%;">Client Signature </td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
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
	
	<script>
		
		function previewImages() {
		
			  var $preview = $('#actual_phoograph_of_site').empty();
			  
			  if (this.files) $.each(this.files, readAndPreview);
		
			  function readAndPreview(i, file) {
			    
			    if (!/\.(jpe?g|png|gif)$/i.test(file.name)){
			      return alert(file.name +" is not an image");
			    } // else...
			    
			    var reader = new FileReader();
		
			    $(reader).on("load", function() {
			      $preview.append($("<img/>", {src:this.result, height:100,width:100}));
			    });
		
			    reader.readAsDataURL(file);
			    
			  }
		
			}
	
		$('#actual_photo').on("change", previewImages);
	</script>
</body>
</html>

