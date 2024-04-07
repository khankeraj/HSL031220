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
	
	<script src="js/datevalidation.js" type="text/javascript"></script>
	
	 <script>
	 $(function() {
		 $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
		 $("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
		 
		 $("#111").hide();
			$("#222").hide();
			$("#333").hide();
			$("#444").hide();
			$("#555").hide();
			$("#666").hide();
		 
		 
		 $('.item-row').each(function(i, row) {
			 
			 if (window.XMLHttpRequest) {
					var xp1 = new XMLHttpRequest();
				} else {
					var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
			 var $s=$(row).find('#dd');
			 var $s1=$(row).find('#ee');
			 var $s2=$(row).find('#ff');	
				
			 
			 $($s).autocomplete("GoogleSearch/autosearchVehicleType.jsp");
			 $($s1).autocomplete("GoogleSearch/autosearchCity.jsp");
			 $($s2).autocomplete("GoogleSearch/autosearchCity.jsp");
		 });
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
	 
	function getAddress(v){
		 
		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 //alert('Inside');
		 
		 
		 var cname = v.value;
		 var tname = document.getElementById('transporter_name').value;
		 //alert('cust nm'+cname);
		 //alert('trans nm'+tname);
		 
		 
		 var cust = cname.split("-");
		 var trans = tname.split("-");
		 
		 //alert("cust code: "+cust[1]);
		 //alert("trans code: "+trans[1]);
		 
		 
		 
		 
		 
		 xp11.open("POST", "Get_Address?transporter_code="
					+ trans[1] + "&customer_code="
					+ cust[1]);
			
			xp11.send();
			//alert("343");
			
			//alert("343");
			 xp11.onreadystatechange = function() {
			 if (xp11.readyState == 4 && xp11.status == 200) {
				 //alert('333');
				 var rep = xp11.responseText;
				 parts = rep.split("^");
				 //alert('444');
				 var tadd = parts[0];
				 var cadd = parts[1];
				 //alert('555');
				 document.getElementById('transporter_addr').value = tadd;
				 document.getElementById('customer_addr').value = cadd;
				 
			    }
			  };
			
				
			
	 }
	 
	 
	 
	
	
	 
	 </script>
	 <script>
	 
	 function getTotal(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#gg');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#gg');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("advance").value=amount;
		
	 }
	 
	 
	 
	 function getTotal1(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#ii');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#ii');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("total_amount").value=amount;
		
	 }
	
	function getAmount(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#gg');
				
			var tax1=$($hoardinglocation1).val();
			
			
			var $hoardinglocation2 = $($traverse_row).find('#hh');
			
			var tax2=$($hoardinglocation2).val();
			
			$hoardinglocation5 = $($traverse_row).find('#ii');
			
			$('.item-row').each(function(i, row) {
				
				
				amount = tax1 * tax2;
				
				//$hoardinglocation5 = $($traverse_row).find('#ee');
				$($hoardinglocation5).val(amount.toFixed(2));
				
			});
			
		
	 }
	
	
	function showmyd1(v){
		 var isChecked = $(v).attr('checked');
		 var myv=$(v).val();
		
			if(myv=="myd1"){
			if(isChecked=="checked"){
			
				
				$("#111").show(1000);
				$("#222").show(1000);
				$("#333").show(1000);
			}else{
				$("#111").hide();
				$("#222").hide();
				$("#333").hide();
				
			}
			
			}
			
			if(myv=="myd2"){
			if(isChecked=="checked"){
				
					
					$("#444").show(1000);
					$("#555").show(1000);
					$("#666").show(1000);
					
				}else{
					$("#444").hide();
					$("#555").hide();
					$("#666").hide(1000);
					
				}
				
				}
		
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
					<h1 class="page-header text-overflow">Vehicle Change</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Vehicle</a></li>
					<li class="active">Vehicle Change</li>
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
								
								<s:push value="im">
								
							<form action="VehicleChangeSuccess" method="POST" class="form-control">
								
								<div class="panel-body">
								
								<div class="row">
								
								
								<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Order Id:</label>
													<input type="text" class="form-control" value="${order_id}" name="order_id" id="order_id"  readonly>
												</div>
											</div>
											
											
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Lr Number:</label>
													<input type="text" class="form-control" value="${lr_no}"  name="lr_no" id="lr_no" readonly required>
												</div>
											</div>
									  
									  
									  </div>
								
								
								
								      
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name:</label>
													<input type="text" class="form-control" value="${transporter_name}-${transport_code}" name="transporter_name" id="transporter_name"   required>
												</div>
											</div>
										
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle No:</label>
													<input type="text" class="form-control"  name="vehicle_no" id="vehicle_no" value="${vehicle_no}"   required>
												</div>
											</div>	
											
									  </div>
									  
									  
													
													
									  
									  <div class="row">
									  
									  		
									  		
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="text" class="form-control"  name="driver_name"  id="driver_name" value="${driver_name}-${driver_code}"   class="form-control" >
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Contact </label>
													<input type="text" class="form-control" value="${driver_mobile}" name="driver_mobile" id="driver_mobile"   required>
												</div>
											</div>
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
