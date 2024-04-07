<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.aqua.dao.DaoHelper,java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Customer Credit Debit Note</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
Ionicons
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
<!-- Theme style -->

<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="Css/jquery-ui.css">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="Css/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="Css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="niceform-Product-Master.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="masterstyle.css" />
<link rel="stylesheet" type="text/css" href="Css/layout-styles.css" />
<link rel="stylesheet"
	href="Css/validationEngine/validationEngine.jquery.css" type="text/css" />
<link rel="stylesheet" href="Css/template.css" type="text/css" />
<script src="js/languages/jquery.validationEngine-en.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/datevalidation.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" href="Css/validationEngine.jquery.css"
	type="text/css" />
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js"
	type="text/javascript"></script>
<script type="text/javascript" src="js/validation.js"></script>
<script src="datevalidation.js" type="text/javascript"></script>

<link rel="stylesheet" href="Css/demos.css">
<script type="text/javascript" language="javascript"
	src="js/rptsTable/jquery.dataTables.js"></script>
<style type="text/css" title="currentStyle">
@import "Css/rptsTable/demo_page.css";

@import "Css/rptsTable/demo_table.css";

#backgroundPopup {
	display: none;
	position: fixed;
	_position: absolute; /* hack for internet explorer 6*/
	height: 100%;
	width: 100%;
	top: 0;
	left: 0;
	background: #000000;
	border: 1px solid #cecece;
	z-index: 1;
}

*:focus {
	outline: 5px !important;
	border: 1px solid;
	border-color: #0b0595;
	box-shadow: 0 0 10px #0b0595;
}
</style>
<script type="text/javascript"
	src="jQuery_4_design/AddRowDataTable/purchase_spare.js"></script>
<link rel="stylesheet" type="text/css"
	href="Css/AddRowDataTable/layout-styles.css" />
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="datevalidation.js" type="text/javascript"></script>
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script src="js/rangopopup.js" type="text/javascript"></script>
<script type="text/javascript">
	function displaytheautosearch(obj1) {
		//txt = obj1.options[obj1.selectedIndex].value;
		txt = document.getElementById("exppart").value;
		if (txt == "Bank Deposit") {
			$("#s1").show(1000);

		} else {

			$("#s1").hide();
		}

	}
	function display(obj) {

		txt = obj.options[obj.selectedIndex].value;
		$("#1").hide();
		$("#2").hide();
		$("#3").hide();
		$("#4").hide();
		$("#5").hide();
		$("#6").hide();
		$("#7").hide();
		$("#8").hide();
		$("#tab").hide();
		if (txt == 1) {
			$("#1").show(1000);
			$("#tab").show(1000);
		}
		if (txt == 2) {
			$("#1").show(1000);
			$("#2").show(1000);
			$("#3").show(1000);
			$("#4").show(1000);
			$("#5").show(1000);
			$("#6").show(1000);
			$("#tab").show(1000);

		}
		if (txt == 3) {
			$("#1").show(1000);
			$("#2").show(1000);
			$("#3").show(1000);
			$("#4").show(1000);

			$("#tab").show(1000);
		}
		if (txt == 4) {
			$("#1").show(1000);
			$("#2").show(1000);
			$("#7").show(1000);
			$("#tab").show(1000);
		}
		if (txt == 5) {
			$("#1").show(1000);
			$("#2").show(1000);
			$("#3").show(1000);
			$("#4").show(1000);
			$("#8").show(1000);
			$("#tab").show(1000);

		}
	}

	function f1() {

		var x = document.getElementById("dealer_payment_amt").value;
		document.getElementById("net_amount").value = x;
	}
</script>




<script type="text/javascript">
	$(function() {
	
		$("#dealer_code").autocomplete("GoogleSearch/Customer_name1.jsp");
		

	});

	/* all field velidation arvind */

	$(function() {
		$("#dealerpayment").validationEngine();
		/* $("#payment_date" ).datepicker();
			dateFormat: "dd-mm-yy"	; */
	});

	/* end */
</script>


</head>

<body id="background">

<center>


		<!-- Content Wrapper. Contains page content -->
	
				<div class="row">
					<!-- left column -->
					<div class="col-md-3">
					</div>
					
					<div class="col-md-6">
						<!-- general form elements -->
						<div class="box box-primary">
							
							<!-- /.box-header -->
							<!-- form start -->
							<center><H2>Customer Credit Debit Notes</H2></center>
							<br>

	

		<s:form action="InsertCustCreditDebit" theme="simple" id="dealerpayment"
			class="formular">

			
				<!-- <input type="text" name="user" id="user" value="${user}"> -->
				<table>
					<tr>
						<td>
							<table align="left" id="textfocus"
								style="border: 1px solid black;" width="500px;" height="200px;">
								
								<tr>

									<td align="left"><b>Date </b>
									</td>
									<td align="left"><input type="text"
										name="dpb.payment_date" id="payment_date" size="30"
										onblur="FixShortDate(this);" class="validate[required]"
										 cssClass="validate[required]" ></td>

								</tr>
								
								
								<tr>
									<td align="left"><b>Customer&nbsp;Name</b>
									</td>
									<td align="left"><s:textfield name="dpb.dealer_code"
											id="dealer_code" size="30" class="validate[required]"
											></s:textfield></td>


								</tr>
								
								
						
					
								<tr>
									<td align="left"><b>Amount</b>
									</td>
									<td align="left"><s:textfield
											name="dpb.dealer_payment_amt" id="dealer_payment_amt"
											size="30" maxlength="7" onblur="f1();"
											cssClass="validate[required,custom[integer]]"></s:textfield>
									</td>


								</tr>


								<tr>
								<td align="left"><b>Type</b>
									</td>
								<td align="left">
								 <select class="form-control" id="type" name="dpb.type" required="" >
									<option value="0">--------------Select----------------</option>
									<option  value="Credit">Credit</option>
									<option  value="Debit">Debit</option>
						
								</select> 
								</td>
							</tr>
							<tr>
									<td align="left"><b>Nariation</b>
									</td>
									<td align="left"><s:textfield name="dpb.remark"
											id="remark" size="30" class="validate[required]"
											maxlength="330"
											cssClass="validate[required]"
											></s:textfield></td>


								</tr>


								<tr>
									<td align="left"><b>Ref NO</b>
									</td>
									<td align="left"><s:textfield name="dpb.refno"
											id="refno" size="30" class="validate[required]"
											maxlength="330"
											cssClass="validate[required]"
											></s:textfield></td>


								</tr>

								





							</table></td>
					</tr>
				</table>
				<table align="center">
					<tr>
						<td><img class="NFButtonLeft" src="img/0.png" alt=""><input
							type="submit" name="Submit" id="Submit" value="Submit"
							class="NFButton"><img src="img/0.png"
							class="NFButtonRight" alt=""></td>
						
					</tr>
				</table>

			</fieldset>
		</s:form>
	</center>

</body>
</html>
 --%>
 
 
 
 
 
 
 
 
 
 
<!DOCTYPE html>
<html lang="en">
<head>
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
	

	<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js"
	type="text/javascript"></script>
	

 <script src="datevalidation.js" type="text/javascript"></script>

<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>



<link rel="stylesheet" href="configure/css/main2.css">
 
<head>

<script>  
    
    $(function() {
		
    	$("#dealer_code").autocomplete("GoogleSearch/Customer_name1.jsp");

		

	});
    function f1() {

		var x = document.getElementById("dealer_payment_amt").value;
		document.getElementById("net_amount").value = x;
	}
</script> 
<script type="text/javascript">



	$(function() {
		
		/*  $("#type").autocomplete("GoogleSearch/typemaster1.jsp"); */

		

	});</script>
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
					<h1 class="page-header text-overflow">Credit/Debit Notes</h1>
				</div>
				<!--End page title-->
				
				

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						
						
						<div class="col-lg-12">
						
							<div class="panel">
							<div class="col-lg-6"></div>
							
								
								<form action="InsertCustCreditDebit" id="frmFileUpload"
								class="form-control" method="post" name="mainForm"
								onsubmit="return qqq(this);" enctype="multipart/form-data">
								
								
								<br><br>

				 
					<div class="body">
                        <div class="row ">
                            <div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.payment_date" id="payment_date" onblur="FixShortDate(this);return ValidateForm(this);checkDate();" 
												
												 required> <span class="highlight"></span>
											<label>Date</label>
										</div>
                            </div>
                           <div class="col-sm-6">
                            
                            <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.dealer_code" id="dealer_code" 
												
												 required> <span class="highlight"></span>
											<label>Customer Name</label>
										</div></div>
                           
                           </div>
                          <div class="row ">
                            <div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.dealer_payment_amt" id="dealer_payment_amt"
											size="30" maxlength="7"  required> 
												
												 <span class="highlight"></span>
											<label>Amount</label>
										</div>
                            </div>
                            
                            <%--  <div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.remark" id="city" value="${city1}"
												
												 > <span class="highlight"></span>
											<label>Type</label>
										</div>
                            </div> --%>
                           
                            <div class="col-sm-6">
                             <div class="form-group floating-label">
									<select class="selectpicker form-control floating-input" name="dpb.type" id="type" >
													<option value="0">----Select----</option>
													<option value="Credit">Credit</option>
										<option value="Debit">Debit</option>
										
										</Select></div>
                            </div>
                           
                           
                          
                           </div>
                           
                           <div class="row ">
                            <div class="col-sm-6">
                                
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.remark" id="remark" 
												
												 > <span class="highlight"></span>
											<label>Nariation</label>
										</div>
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.refno" id="refno" 
												
												 > <span class="highlight"></span>
											<label>REF NO</label>
										</div>
                            </div>
                           
                           </div>
                           
                           
                             
                            
                                <div class="row">
											<div class="col-sm-4 ">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
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
					
					<!--End menu-->
				</div>
			</nav>
			<!--END MAIN NAVIGATION-->
		</div>
				<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->
	</div>
	<!-- END OF CONTAINER -->
	
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	
	<!-- END SETTINGS -->
<!--JAVASCRIPT-->
	<script src="configure/js/bootstrap.min.js"></script>
	<script src="configure/plugins/fast-click/fastclick.min.js"></script>
	<script src="configure/js/nifty.min.js"></script>
	<script src="configure/plugins/morris-js/morris.min.js"></script>
	<script src="configure/plugins/morris-js/raphael-js/raphael.min.js"></script>
	<script src="configure/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="configure/plugins/skycons/skycons.min.js"></script>
	<script src="configure/plugins/switchery/switchery.min.js"></script>
	<script src="configure/plugins/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="configure/js/demo/nifty-demo.min.js"></script>
	<script src="configure/js/demo/dashboard.js"></script>
</body>
</html>