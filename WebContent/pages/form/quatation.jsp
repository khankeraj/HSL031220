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
function myFunction() {
    var checkBox = document.getElementById("myCheck");
    var text = document.getElementById("text");
    if (checkBox.checked == true){
        text.style.display = "block";
    } else {
       text.style.display = "none";
    }
}
</script>

<script>
$(document).ready(function() {
    $("#chkdwn2").click(function() {
       if ($(this).is(":checked")) { 
          $("#dropdown").prop("disabled", true);
       } else {
          $("#dropdown").prop("disabled", false);  
       }
    });
});
</script>

<script>
function getQuotationName(quotation_name){
	alert(quotation_name);
	document.getElementById("myCheckBox").checked=true;
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
					<h1 class="page-header text-overflow">Quotation Prints</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Quotation Prints</li>
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
								<form action="contractMaster" method="POST">
									<div class="panel-body">
									
									 <%--  <div class="row" align="left">
											<div class="col-sm-12">
											 <div class="form-group">
												<table>
													<tr>
														<td>
															 <%
															 	DBConnection connection=new DBConnection();
															 	Connection conn=connection.getConnection();
															 	try{
															 	PreparedStatement pst=conn.prepareStatement("SELECT `quotation_id`, `quotation_name` FROM `quotation_name_master`");
															 	ResultSet rs=pst.executeQuery();
															 %>
															 <select class="selectpicker" data-live-search="true" name="meeting_status" onchange="getQuotationName(this.value)" data-width="100%">
																<option selected disabled>Select Quotation</option>	
																<%
																while(rs.next()){
																int customer_id=rs.getInt(1);
																String quotation_name=rs.getString(2);
																
																%>
																	<option value="<%=quotation_name%>"><%=quotation_name%></option>
																<%} %>
															   </select>
															   <%}catch(Exception e){e.printStackTrace();} %>
														</td>
													</tr>
												 </table>
											</div>
									  </div>
									</div> --%>
									
									<s:iterator value="quotation">
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<i class="fa fa-right"></i>&nbsp;&nbsp;<input type="checkbox" id="myCheckBox" value="" onclick="myFunction()">&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="name_of_index"/>
												</div>
											</div>
									  </div>
									</s:iterator>
									
										<!-- <table align="center" style="display: none;">
											<tr>
												<td>
													<p><h1><b>Project Includes<br></b></h1></p>
													<p>01.Understanding market and client requirements</p>
													<p>02.Manufacture machineries as per requirements</p>
													<p>03.Consultancy to build factory as per BIS standards</p>
													<p>04.Machineries erection & setup</p>
													<p>05.BIS consultancy</p>
													<p>06.Preparation of BIS inspection and execution as per BIS guideline</p>
													<p>07.Technical recruitment and training</p>
													<p>08.Product design</p>
													<p>09.Marketing strategy and planning</p>
													<p>10.Service & support</p>
													<p>11. Initial co-ordination with all genuine raw material suppliers to
													procure right raw material.</p>
													<p>12. And of course healthy business relationship.</p>
												</td>
											</tr>
										</table>
									
										<table style="display: none;"><tr><td>
											<p>
											<h4 align="center"><b>OUR CLIENTS<BR></b></h4>
											</p>
											<table>
												<tr align="center">
												<td><img alt="" src="configure/img/volk.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/bajaj.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/bharat.png" height="70%" width="70%"></td>
												</tr>
												
												<tr align="center">
												<td><img alt="" src="configure/img/axis.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/symbiosis.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/infosys.png" height="70%" width="70%"></td>
												</tr>
												
												<tr align="center">
												<td><img alt="" src="configure/img/international.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/trp.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/university.png" height="70%" width="70%"></td>
												</tr>
												</table>
												<p><h4 align="center"><b>ClientelePackaged Drinking water Projects</b></h4></p>
												<table>
												<tr align="center">
												<td><img alt="" src="configure/img/spenca.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/swizzale.png" height="70%" width="70%"></td>
												<td><img alt="" src="configure/img/raghav.png" height="70%" width="70%"></td>
												</tr>
											</table>
											</td></tr>
										</table>
									
										<table style="display: none;"><tr><td>
												<p>
												<h1>OUR PRODUCTS<br></h1>
												Turnkey Packaged<br>
												Drinking Water Project<br>
												<hr width="70%" align="left"><br>
												Water Treatment<br>
												Equipments<br>
												<hr width="70%" align="left"><br>
												Water ATM<br>
												<hr width="70%" align="left"><br>
												Domestic Products<br>
												<hr width="70%" align="left"><br>
												Consumable<br>
												<hr width="70%" align="left"><br>
												Medical RO<br>
												<hr width="70%" align="left"><br>
												Water Softners<br>
												<p align="right">
												<img alt="logo" src="configure/img/logo.png">
												</p>
												</p>
												</td></tr>
										</table>
									
										<table style="display: none;"><tr><td>
											<p><br><br><br><br><br>
											<h1 align="center"><b>WHO WE ARE ?<br></b></h1>
											</p>
											<center>
											<p style="width: 50%" class="indented">
												Ultracare Group is a leading turnkey solution provider of Packaged Drinking Water and water treatment equipment all over the India. With its full commitment, high quality and customer first business principles, Ultracare Group has set up strict quality controls in the manufacturing and offer complete after-sale services with well-groomed service team.In the field of Packaged Drinking Water project and water Treatment equipment industry, keeping alive our motto to aim higher, we made our team well groomed. Ultracare is the only Turnkey solution provider for packaged Drinking Water Projects in India. Adding more allied services like, Market research, Marketing strategy and planning, product design, and resource of expert plant operating team to smooth function of Production line. We strictly deal with genuine and reputed vendor to ensure quality supply of raw material at any time.While catering our clients, we believe in Understanding requirement, well planning, execution, delivery and best response for after sales service…
											</p>
											</center>
											</td></tr>
										</table>
									
										<table style="url('configure/img/backgroundImage.png');display: none;" >
											<tr>
												<td>
												<img alt="logo" src="configure/img/logo.png" align="right">
													<img alt="Cover Page" src="configure/img/headingPageImage.png" width="100%">
												<h2>We are here to serve you<br><h2>
												  <h1>ABOVE & BEYOND</h1>
												</td>
											</tr>
										</table> -->
										
										<%-- <table>
											<tr>
												<td>
												<img alt="Cover Page" src="configure/img/coverPage.jpg" width="100%">
													<p><h1>
														<b>PROJECT<br>PROPOSAL<br>
															</b></h1></p>
																<P><H5>Packaged Drink Water Plant</H5></P>
														<hr><br>
													  <p>
															<h4>
																Prepared For<br>
															<br>
															<s:iterator value="coverDetails">
																${to}<br>
																${address}<br>
																${city}<br>
																${state}.<br>
																</s:iterator>
															</h4>
													   </p>
															<P align="right">
																<img alt="logo" src="configure/img/logo.png"><br>
														Towards Healthier Life<hr style="width: 100%" align="center">
													</P>
												<img alt="Cover Page" src="configure/img/coverPage2.png" width="100%">
												</td>
												</tr>
										</table> --%>
										
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

