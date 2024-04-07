<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		 $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
	});
	 
	 
	 function getRNA(v)
	 {
		 var $traverse_row = $(v).parents('.item-row');
			
			//	alert(">>>");
				$hoardinglocationx1 = $($traverse_row).find('#rate');
				//alert(">>>");
				$hoardinglocationx = $($traverse_row).find('#weight');
			//	alert(">>>");
				/* $hoardinglocation3 = $($traverse_row).find('#amount'); */
				$('.item-row').each(function(i,row){
				var weight = $($hoardinglocationx).val();
				
				var rate = $($hoardinglocationx1).val();
				
				/* var amount = $($hoardinglocation3).val();  */
				
				
				if(weight!="" && rate!="" ){
					amt= rate * weight;
					$hoardinglocation = $($traverse_row).find('#amount');
					//alert(amt);
					$($hoardinglocation).val(amt);
					
				}
		 
				});	
    		 //alert("1234567");
    		 /* var $vid = $(row).find('#weight');
    		 var $vid1 = $(row).find('#rate');
    		
    		 var $vid2 = $vid * $vid1;
    		 
    		 alert($vid2);
    		 
    		 $(row).find('#amount').value = $vid2; */
    		 
    	 
    	 
		 
		 /* var amount = weight * rate;
		 alert("amount : "+amount);
		 document.getElementById("amount").value = amount; */
	 }
	 
	 function getTotal(v)
	 {
		// alert('getTotal()');
		 /* var $traverse_row = $(v).parents('.item-row');
		 var tot_amt = 0; */
		/*  $hoardinglocationx = $($traverse_row).find('#amount'); */
		 /* $hoardinglocationx = $($traverse_row).find('#amount');
		 
		 $('.item-row').each(function(i,row){
			 
			 var amount = $($hoardinglocationx).val();
			 
			 tot_amt = Math.abs(tot_amt) + Math.abs(amount);
			  */
			 /* $hoardinglocation = $($traverse_row).find('#total_amount'); */
			 
		 /* });	
		//alert(tot_amt);
		document.getElementById("total_amount").value = tot_amt; */
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#amount');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#amount');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("total_amount").value=amount;
		
	 }
	 
	 function getBalance(v)
	 {
		 var advance = v.value;
		 var total = document.getElementById('total_amount').value;
		 var balance = Math.abs(total) - Math.abs(advance);
		 
		 //alert(balance);
		 document.getElementById("balance").value = balance;
	 }
	 
	  /* function skipqty(v){

			
			
			
			var $traverse_row = $(v).parents('.item-row');
			var $hoardinglocation = $($traverse_row).find('#weight');
			var $hoardinglocationa = $($traverse_row).find('#rate');
			var $hoardinglocationx = $($traverse_row).find('#description');
			var $hoardinglocationb = $($traverse_row).find('#amount');
			
			var desc=$(v).val();
			desc = desc.trim();
			$(v).val(desc);
			
			
			var ths = $(v).val();
	    	var t = 0;
	    	 $('.item-row').each(function(i,row){
	    		 //alert("1234567");
	    		 var $vid = $(row).find('#description');
	    		 
	    		 
	    		 if($($vid).val()==ths)
	     		{
	     		t=t+1;
	     		}
	    	 });
	    	 
	 } */
	 
	 
	 
	 /* function getnewsrno(v){
			calculategst(v);
			
		}
	 
	 function calculategst(v){
			
			//alert(">>>");
			var $traverse_row = $(v).parents('.item-row');
			
		//	alert(">>>");
			$hoardinglocationx1 = $($traverse_row).find('#rate');
			//alert(">>>");
			$hoardinglocationx = $($traverse_row).find('#weight');
		//	alert(">>>");
			/* $hoardinglocation3 = $($traverse_row).find('#amount'); 
			
			var weight = $($hoardinglocationx).val();
			
			var rate = $($hoardinglocationx1).val();
			
			var amount = $($hoardinglocation3).val(); 
			
			
			if(weight!="" && rate!="" ){
				amt= rate * weight;
				$hoardinglocation = $($traverse_row).find('#amount');
				$($hoardinglocation).val(amt);
				
			}
	 } */ 
	 
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
					<h1 class="page-header text-overflow">Commission Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Transport</a></li>
					<li class="active">Commission Form</li>
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
								
							<form action="insert_commission1_action" method="POST">
								<div class="panel-body">
								
								<div class="row">
											
											<!-- <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="date" class="form-control" placeholder="" style="line-height: 15px;" name="date" id="date"   class="form-control" required>
												</div>
											</div> -->
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name:</label>
													<input type="text" class="form-control" placeholder="" value="${transporter_name}" style="line-height: 15px;" name="transporter_name" id="transporter_name"   class="form-control" required readonly>
												</div>
											</div>
									  </div>
								
								
								
								      
									  
									  <div id="product" style="width:100%">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%" colspan="5">

															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		<th id="VLsparename"><label>Trip Id</label>
																		</th>
																		
																		<th id="VLsparename"><label>Up/down Id</label>
																		</th>
																		
																		<th id="VLsparename"><label>LR No</label></th>
									  									
									  									<th id="VLsparename"><label>Source</label></th>
									  									
									  									<th id="VLsparename"><label>Destination</label></th>
									  									
									  									<th id="VLsparename"><label>Vehicle No.</label></th>
									  									
									  									<th id="VLsparename"><label>Driver Name</label></th>
									  									
									  									<th id="VLsparename"><label>Commission Amount</label></th>
									  								</tr>
									  								
									  								
									  								
									  								
									  								<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																<c:forEach items="${deliveryDetails}" var="deliveryDetails">
																	<tr class="item-row">
																	<td style="width:1px;"></td>
																	<td><input type="text" name="trip_id1" class="form-control"
																			style="width: 110px;" value="${deliveryDetails.trip_id}" id="trip_id"
																			 /></td>
																		 
																		<td><input type="text" name="updown_id1" class="form-control"
																			style="width: 125px;" id="updown_id" value="${deliveryDetails.updown_id}" 
																			 /></td>
																		<td><input type="text" name="lr_number1" class="form-control"
																			id="lr_number" value="${deliveryDetails.lr_number}" readonly
																			
																			style="width: 140px;" />
																		</td>
																		
																		<td><input type="text" name="source1" class="form-control"
																			id="source" value="${deliveryDetails.source}" 
																	
																			style="width: 80px;"  />
																		</td>
																		
																		
																		<td><input type="text" name="destination1" class="form-control"
																			id="destination" value="${deliveryDetails.destination}" 
																	
																			style="width: 80px;"  />
																		</td>
																		
																		<td><input type="text" name="vehicle_no1" class="form-control"
																			id="vehicle_no" value="${deliveryDetails.vehicle_no}" 
																	
																			style="width: 100px;"  />
																		</td>
																		
																		<td><input type="text" name="driver_name1" class="form-control"
																			id="driver_name" value="${deliveryDetails.driver_name}" 
																	
																			style="width: 100px;"  />
																		</td>
																		
																		<td><input type="text" name="commision1" class="form-control"
																			id="commision" value="" 
																	
																			style="width: 100px;"  />
																		</td>
																		
									  								</tr>
									  							</c:forEach>
									  								
									  								
									  								</table>
									  								<%-- <table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">

																	<tr>
																		<td align="left"
																			style="padding-left: 14px; padding-top: 14px;"><a
																			href="#" id="addRow" class="button-clean large"><span>
																					<img id="" tabindex="13"
																					src="Images_4_design/AddRowDataTable/icon-plus.png"
																					alt="Add" title="Add Row" style="margin-left: 0px" />
																					Add Item</span> </a></td>
																	</tr>
																	
																
																	</table> --%>
									  								
									  								
									  																
									  								</td>
									  								</tr>
									  								</table>
									  								</div>
									  
										<script type="text/javascript">
								
									$(document)
											.ready(
													function() {
														//alert('Inside fun()');
														
														$("#addRow").bind('click',addRows);
														var index = 13;
														function addRows(e) {
															try {
																var $itemsTable = $('#itemsTable');
																var $rowTemp = [
																		'<tr class="item-row">',

																		'<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
																		//myflag,
																		//col1,
																		//col2,
																		//col3,
																		/* '<td></select>	<input type="Button"class="btn btn-primary" value="New" onclick="getvehicleno(this);"></td>', */
																		'<td><input style="" type="text" class="form-control" name="description"  id="description" /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="weight"  id="weight" /></td>',
																		//puc,
																		'<td><input style="width:100px;" type="text" class="form-control" name="rate"   id="rate" value="" onblur="getRNA(this);" /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="amount"   id="amount" value="" onblur="getTotal(this);" /></td>',
																		//myflag11,
																		//myflag22,
																		//myflag33,
																		'</tr>' ]
																		.join('');
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#description');
																$($description).autocomplete("GoogleSearch/spareautosearch.jsp");

																

																$last = $(
																		'#itemsTable')
																		.find(
																				'tbody tr:last');
																$.first = $last
																		.find('input:first');
																//var $btype = $row
																	//	.find('#btype');
																var $description = $row
																		.find('#description');
																if (true) {
																	$('.item-row:last',
																			$itemsTable)
																			.after($row);
																}// End if last ItemName input is empty
																else {
																	$('.item-row:last',
																			$itemsTable)
																			.after($row);
																}
																$last = $('#itemsTable')
																		.find(
																				'tbody tr:last');
																$.first = $last
																		.find('input:first');
																$($description)
																		.focus();

															} catch (err) {
																alert(err);
															}
															return false;
														}

													}); // End DOM
													
													
													//Remove row when clicked
													$("#deleteRow").live('click', function() {
														//alert(">>>");
													
														$(this).parents('.item-row').remove();
														// Hide delete Icon if we only have one row in the list.
														if ($(".item-row").length < 2)
															$("#deleteRow").hide();
														
														//totalnetamt();
													});
													
								</script>							 
										
										
										
										
										
										
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
