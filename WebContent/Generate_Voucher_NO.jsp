<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script language="javascript">
function gohome()
 {
   location.href ="pages/form/homePage.jsp"
 }
function goback()
{
  location.href ="dealerpaymentreport_actionv"
}

 function Print(recno,date,name,amount,chequeno,bankname)
{
	alert(">>>");

		var okdelete = confirm("Are You Sure Want to Print!");

		if (okdelete)

		{

			location.href="chequeprint?recno="+recno+"&date="+date+"&amount="+amount+"&chequeno="+chequeno+"&bankname="+bankname+"&name="+name;

		}
	} 


</script>
</head>
<body bgcolor="#EBEBEB"">
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Generated Voucher Code </h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Generated Voucher Code </li>
				</ol>
				<!--End breadcrumb-->
						<div style="margin: 200px;">
							<center>
								<font color="#497F0F"><h2>Data Inserted Successfully.</h2>
								</font>
							</center>
							<br>
							<center>
								<font color="#497F0F"><h2>
										Generated&nbsp;&nbsp;No&nbsp;is&nbsp;&nbsp;&nbsp;&nbsp;
										<c:out value="${dpb.voucher_no}" />
									</h2>
								</font>
							</center>
							<br>
							<table align="center">
								<tr>
									<td>
									
									<!-- <input type="button" class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" name="home" id="home" value="Back"
										onclick="gohome();"
										style="width: 100px; height: 30px; border-radius: 5px;"> --></td>
									
									
									
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="paymode" id="paymode" value="${paymode}" /> </td>
					
													</tr>
													
													
													
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="recno" id="recno" value="${recno}" /> </td>
					
													</tr>
													
													
													
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="date" id="date" value="${date}" /> </td>
					
													</tr>
													
													
													
													
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="bankname" id="bankname" value="${bankname}" /> </td>
					
													</tr>
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="amount" id="amount" value="${amount}" /> </td>
					
													</tr>
													
													
													<tr>
					
														<td align="left"><b></b>
														</td>
														<td align="left"><input type="hidden"
															 name="chequeno" id="chequeno" value="${chequeno}" /> </td>
					
													</tr>
													
													<tr>
					
														<td align="left"><b> </b>
														</td>
														<td align="left"><input type="hidden"
															 name="name" id="name" value="${name}" /> </td>
					
													</tr>
									
									
									<s:set var="myNum" value="paymode" />
									
									
						
									
									<%-- <tr>
					
														<td align="left"><b>MyNum</b>
														</td>
														<td align="left"><input type="text"
															 name="abc" id="abc" value="${myNum}" /> </td>
					
													</tr>
									 --%>
									
								<%-- <c:out value="${myNum}" /> --%>
									
					
					
					<c:if test="${ myNum== '3' }">
									 
									 <td><%-- <a 
										 href="ChequePrint444?voucher_no=<c:out value="${dpb.voucher_no}" />"><input
									type="button" style="width: 100px; height: 30px; border-radius: 5px;" value="Print Cheque" onclick="" /></a>&nbsp;</td>
					 --%>
					 <input type="button" id="print" name="print"  class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" value="Cheque Print" onclick="Print('<s:property value="recno"/>','<s:property value="date"/>','<s:property value="name"/>','<s:property value="amount"/>','<s:property value="chequeno"/>','<s:property value="bankname"/>'); "   >
																			
									</td>
					 
									 </c:if>
									
									
									<%-- <td><input type="button" id="print" name="print" value="Print" onclick="Print('<s:property value="recno"/>','<s:property value="date"/>','<s:property value="name"/>','<s:property value="amount"/>','<s:property value="chequeno"/>','<s:property value="bankname"/>'); "   >
																			
									</td>
								 --%>
					
							</table>
						</div>
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