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
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
	
	 <script>
	 $(function() {
		 
		 $("#111").hide();
		 $("#reason").autocomplete("GoogleSearch/autosearchReason.jsp");
		 //$("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		// $("#ee").autocomplete("GoogleSearch/autosearchCity.jsp");
		// $("#ff").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 //$("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
		 //$("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
	});
	 
	 $(function() {
			var today = new Date(); 
			var dd = today.getDate(); 
			var mm = today.getMonth()+1;//January is 0! 
			var yyyy = today.getFullYear(); 
			if(dd<10){dd='0'+dd} 
			if(mm<10){mm='0'+mm} 
			$("#date").val(dd+'/'+mm+'/'+yyyy);
			
			
		});
	 
	 function display(obj) {
			
			txt = obj.options[obj.selectedIndex].value;
			
			
			//alert("Value:"+txt);
			
			if (txt == "OrderLost") {
				
			//alert("AA");
				$("#111").show(1000);
				
			}
			else{
				$("#111").hide();
			}
			
	 }
	 
		 
	 </script>
	 
	 
	 
	 
<script>
function myFunction() {
  document.getElementById("myBtn").disabled = true;
 /*  alert("Hiiiii"); */
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
					<h1 class="page-header text-overflow">Quotation Final</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Quotation</a></li>
					<li class="active">Quotation Final</li>
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
								
							<form action="QuotationFinalSuccess" method="POST"  onsubmit="myFunction();">
								
								<div class="panel-body">
								
								
								<div class="row">	
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Quotation No</label>
													<input type="text" class="form-control"  name="quotation_no" id="quotation_no" value="${quotation_no}"  readonly required>
												</div>
											</div>
											</div>
								
								
								
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  style="line-height: 15px;" name="date" id="date1"  value="${datee}"   required>
												</div>
											</div>
											</div>
											
											
											
									  
									  		<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Amount:</label>
													<input type="text" class="form-control" value="${total}" name="total" id="total"   required>
												</div>
											</div>
											</div>
											
											
											<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark:</label>
													<input type="text" class="form-control"  name="remark" id="remark"   >
												</div>
											</div>
									   	</div>
									  	
										
											
										
													<input type="hidden" class="form-control"  name="pricing_id" id="pricing_id" value="${pricing_id}"  readonly >
												
													<input type="hidden" class="form-control"  name="inquiry_id" id="inquiry_id" value="${inquiry_id}"  readonly >
												
											
											<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Process:</label>
													
													<select class="form-control show-tick " onchange="display(this);" name="type" id="type"  required>
												
																<option value="">Select</option>
			
																<option value="OrderLost">Order Lost</option>
																<option value="OrderReceive">Order Receive</option>
																
																
													</select>
												</div>
									  </div>
											</div>
											
											
											<div class="row">
											<div class="col-sm-6" id="111">
												<div class="form-group">
													<label class="control-label">Reason:</label>
													<input type="text" class="form-control"  name="reason" id="reason"   >
												</div>
											</div>
											
											
																
										</div>
										
										
										<div class="row">
											<div class="col-sm-6">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit"  id="myBtn" >Submit</button>
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
