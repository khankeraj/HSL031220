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
		 //$("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 //$("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#ee").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#ff").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#aa").autocomplete("GoogleSearch/autosearchVehicleType.jsp");
		 $("#bb").autocomplete("GoogleSearch/autosearchVehicleSize.jsp");
		 $("#payterm").autocomplete("GoogleSearch/PaymentDone.jsp");
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
	 
	 function getTotal(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#dd');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#dd');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("total").value=amount;
		
	 }
	 
	 function checkMobileLength()
	 {   
	 		var x=/[a-zA-Z]/g;
	 			
	 		var dealer_contact=document.getElementById("contact_no").value;
	 			
	 	 if(dealer_contact.length!=0)
	 		{
	 			if(dealer_contact.match(x))
	 			{
	 			alert("Only digit is allowed for mobile number")
	 			document.getElementById("contact_no").value='';
	 			document.getElementById("contact_no").focus();
	 			return false;
	 			}
	 			else if(dealer_contact.length<10||dealer_contact.length>10)
	 			{
	 			alert("Enter only 10 digits for mobile number");
	 			document.getElementById("contact_no").value='';
	 			document.getElementById("contact_no").focus();
	 			
	 			return false;
	 			}
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
					<h1 class="page-header text-overflow">Quotation Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Quotation</a></li>
					<li class="active">Quotation Form</li>
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
								
							<form action="InsertQuotation" method="POST"   onsubmit="myFunction();">
								
								<div class="panel-body">
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  onblur="FixShortDate(this);return ValidateForm(this);"  value="${datee}" name="date" id="date1"    required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" class="form-control"  name="name" id="name" value="${name}"   required>
												</div>
											</div>
									  
									  </div>
								
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Address:</label>
													<input type="text" class="form-control" value="${address}" name="address" id="address"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mobile:</label>
													<input type="text" class="form-control" value="${contact_no}" name="contact_no" id="contact_no"  onblur="checkMobileLength(this);" required>
												</div>
											</div>
									  </div>
									  
									   
									  <div class="row">
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Reference Type:</label>
													
													<select class="form-control show-tick " name="reference" id="reference" >
												
																<option value="${resource}">${resource}</option>
																<option value="By Email">By Email</option>
																<option value="By Phone">By Phone</option>
													</select>
												</div>
									  </div>
								
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Kind Attn:</label>
													<input type="text" class="form-control"  name="kind_attn" id="kind_attn">
												</div>
											</div>
									  </div>
									  
									  
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Payment terms:</label>
													<input type="text" class="form-control"  name="payterm" id="payterm" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"  required>
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  	<div id="product" style="width:100%">
												
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		<th id="VLsparename"><label>Type Of Vehicle</label> </th>
																		
																		<!-- <th id="VLsparename"><label>Size Of Vehicle</label> </th> -->
																		
																		<th id="VLsparename"><label>From</label></th>
									  									
									  									<th id="VLsparename"><label>To</label></th>
																		
																		<th id="VLsparename"><label>Weight</label></th>
									  									
									  									<th id="VLsparename"><label>Rate</label></th>
									  									
									  									
									  								
									  								</tr>
									  								
									  								
									  										<s:iterator value="Report">			
																	<tr class="item-row">
																	
																		<td style="width:1px;"></td>
																	
																		<td><input type="text" name="aa" value="<s:property value="aa1"/>" class="form-control" style="width: 120px;"  id="aa" required/></td>
																		
																		<input type="hidden" name="bb" class="form-control" style="width: 120px;" id="bb"  />
																		
																		<td><input type="text" name="ee"  value="<s:property value="ee1"/>" class="form-control" id="ee"   style="width: 120px;"  required/> </td>
																		
																		<td><input type="text" name="ff"  value="<s:property value="ff1"/>" name="ff" class="form-control" id="ff"   style="width: 120px;"  required/> </td>
									  								
																		
																		
																		<td><input type="text" name="cc" class="form-control" id="cc"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		<td><input type="text" name="dd" class="form-control" id="dd"  onblur="getTotal(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		
									  								
									  								</tr>
									  								
									  								</s:iterator>
									  								
									  								</table>
									  								
									  								<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">

																	<tr>
																		<td align="left"
																			style="padding-left: 14px; padding-top: 14px;"><a
																			href="#" id="addRow" class="button-clean large"><span>
																					<img id="" tabindex="13"
																					src="Images_4_design/AddRowDataTable/icon-plus.png"
																					alt="Add" title="Add Row" style="margin-left: 0px" />
																					Add Item</span> </a></td>
																	</tr>
																	
																
																	</table>
									  								
									  								
									  								
									  								</div>
									  
										<div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total</label>
													<input type="text" class="form-control"  name="total" id="total"   readonly required>
												</div>
											</div>
											
											
											
													<input type="hidden" class="form-control"  name="pricing_id" id="pricing_id" value="${pricing_id}"  readonly >
												
											</div>
											
											
											
										<input type="hidden" class="form-control"  name="inquiry_id" id="inquiry_id" value="${inquiry_id}"  readonly >
												
											
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
																		'<td><input type="text" name="aa" class="form-control" style="width: 120px;"  id="aa" required/></td>',
																		
																		'<input type="hidden" name="bb" class="form-control" style="width: 120px;" id="bb"  />',
																		
																		'<td><input type="text" name="ee" class="form-control" id="ee"   style="width: 120px;"  required/> </td>',
																		'<td><input type="text" name="ff" class="form-control" id="ff"   style="width: 120px;"  required/> </td>',	
																		
																		'<td><input type="text" name="cc" class="form-control" id="cc"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		
																		'<td><input type="text" name="dd" class="form-control" id="dd" onblur="getTotal(this);" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" style="width: 120px;"  required/> </td>',
																			
																		
																		'</tr>' ]
																		.join('');
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#ee');
																$($description).autocomplete("GoogleSearch/autosearchCity.jsp");

																var $description1 = $row.find('#ff');
																$($description1).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																var $description2 = $row.find('#aa');
																$($description2).autocomplete("GoogleSearch/autosearchVehicleType.jsp");

																var $description3 = $row.find('#bb');
																$($description3).autocomplete("GoogleSearch/autosearchVehicleSize.jsp");

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
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit"  id="myBtn" >Submit</button>
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
