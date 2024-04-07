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
		 $("#vehicle_type").autocomplete("GoogleSearch/autosearchVehicleType.jsp");
		 $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
		
		/*  $('.item-row').each(function(i, row) {
				 
				 if (window.XMLHttpRequest) {
						var xp1 = new XMLHttpRequest();
					} else {
						var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
					}
					
				 var $s=$(row).find('#ff');
				 var $s1=$(row).find('#aa');
				 var $s2=$(row).find('#bb');	
					
				 
				 $($s).autocomplete("GoogleSearch/autosearchVehicleType.jsp");
				 $($s1).autocomplete("GoogleSearch/autosearchCity.jsp");
				 $($s2).autocomplete("GoogleSearch/autosearchCity.jsp");
			 }); */
		 
		 

			 	$("#111").hide();
				$("#222").hide();
				$("#333").hide();
				$("#444").hide();
				$("#555").hide();
				$("#666").hide();
				$("#777").hide();
				$("#888").hide();
				$("#999").hide();
				$("#myd11").hide();
	});
	 
	
	 
	 function getTotal(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#ee');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#ee');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("total").value=amount;
		
	 }
	 
	 
	 
	 function getTotal1(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#cc');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#cc');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			//alert(amount);
			document.getElementById("total1").value=amount;
		
	 }
	 
	 function showmyd1(v){
		 var isChecked = $(v).attr('checked');
		 var myv=$(v).val();
		
			if(myv=="myd1"){
			if(isChecked=="checked"){
			
				
				$("#111").show(1000);
				$("#222").show(1000);
				$("#333").show(1000);
				$("#myd11").show(1000);
			}else{
				$("#111").hide();
				$("#222").hide();
				$("#333").hide();
				$("#myd11").hide();
				
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
			
			if(myv=="myd4"){
				if(isChecked=="checked"){
					
						
						$("#777").show(1000);
						$("#888").show(1000);
						$("#999").show(1000);
						
					}else{
						$("#777").hide();
						$("#888").hide();
						$("#999").hide(1000);
						
					}
					
					}
				
			
			
			if(myv=="myd3"){
				
				if(isChecked=="checked"){
						
					var aa=document.getElementById("name").value;
					var bb=document.getElementById("address").value;
					var cc=document.getElementById("src_contact_person").value;
					var dd=document.getElementById("src_contact_no").value;
					var ee=document.getElementById("state").value;
					var ff=document.getElementById("gstn").value;
					
					
					$("#loadname").val(aa);
					$("#loadadd").val(bb);
					$("#load_contact_person").val(cc);
					$("#load_contact_no").val(dd);
					$("#loadstate").val(ee);
					$("#loadgstn").val(ff);
			
						
					}else{
					
						$("#loadname").val('');
						$("#loadadd").val('');
						$("#load_contact_person").val('');
						$("#load_contact_no").val('');
						$("#loadstate").val('');
						$("#loadgstn").val('');
					
					
					}
					
					}
			
			
		
	}
		 
	 </script>
	 
	<script>
	
	function getAmount(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#cc');
				
			var tax1=$($hoardinglocation1).val();
			
			
			var $hoardinglocation2 = $($traverse_row).find('#dd');
			
			var tax2=$($hoardinglocation2).val();
			
			$hoardinglocation5 = $($traverse_row).find('#ee');
			
			$('.item-row').each(function(i, row) {
				
				
				amount = tax1 * tax2;
				
				//$hoardinglocation5 = $($traverse_row).find('#ee');
				$($hoardinglocation5).val(amount.toFixed(2));
				
			});
			
		
	 }
	</script>
	 <script>
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


function checkMobileLength1()
{   
		var x=/[a-zA-Z]/g;
			
		var dealer_contact=document.getElementById("src_contact_no").value;
			
	 if(dealer_contact.length!=0)
		{
			if(dealer_contact.match(x))
			{
			alert("Only digit is allowed for mobile number")
			document.getElementById("src_contact_no").value='';
			document.getElementById("src_contact_no").focus();
			return false;
			}
			else if(dealer_contact.length<10||dealer_contact.length>10)
			{
			alert("Enter only 10 digits for mobile number");
			document.getElementById("src_contact_no").value='';
			document.getElementById("src_contact_no").focus();
			
			return false;
			}
		}
		
	
}


function checkMobileLength2()
{   
		var x=/[a-zA-Z]/g;
			
		var dealer_contact=document.getElementById("dest_contact_no").value;
			
	 if(dealer_contact.length!=0)
		{
			if(dealer_contact.match(x))
			{
			alert("Only digit is allowed for mobile number")
			document.getElementById("dest_contact_no").value='';
			document.getElementById("dest_contact_no").focus();
			return false;
			}
			else if(dealer_contact.length<10||dealer_contact.length>10)
			{
			alert("Enter only 10 digits for mobile number");
			document.getElementById("dest_contact_no").value='';
			document.getElementById("dest_contact_no").focus();
			
			return false;
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
					<h1 class="page-header text-overflow">Vehicle Confirmation Edit</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Vehicle</a></li>
					<li class="active">Vehicle Confirmation Edit</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							
							
							<div class="panel">
								
							<s:push value="im">	
								
							<form action="UpdateOrder" method="POST">
								
								<div class="panel-body">
								
								
								<div class="row">
								
								
								<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Order Id:</label>
													<input type="text" class="form-control" value="${order_id}"  name="order_id" id="order_id" readonly   required>
												</div>
											</div>
											
											
											
								<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Lr Number:</label>
													<input type="text" class="form-control" value="${lr_no}"  name="lr_no" id="lr_no" readonly   required>
												</div>
											</div>			
											
											
								<input type="hidden" class="form-control" value="${pricing_id}"  name="pricing_id" id="pricing_id" readonly   >
												
								<input type="hidden" class="form-control" value="${inquiry_id}"  name="inquiry_id" id="inquiry_id" readonly   >
												
									  
									  </div>
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  onblur="FixShortDate(this);return ValidateForm(this);" value="${date}" name="date" id="date"    required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" class="form-control"  name="name" id="name" value="${name}"  required>
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
													<input type="text" class="form-control" value="${contact_no}" name="contact_no" id="contact_no" onblur="checkMobileLength(this);"  required>
												</div>
											</div>
									  </div>
									  
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control" value="${src_contact_person}" name="src_contact_person" id="src_contact_person"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${src_contact_no}" name="src_contact_no" id="src_contact_no"  onblur="checkMobileLength1(this);" required>
												</div>
											</div>
									  </div>
									  
									  
									  
									<input type="hidden" class="form-control" value="${ebillno}" name="ebillno" id="ebillno"   >
												
									<input type="hidden" class="form-control" value="${invoiceno}" name="invoiceno" id="invoiceno"   >
												
									  
									  
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Route</label>
													<input type="text" class="form-control" value="${route}" name="route" id="route"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Delivery Date</label>
													<input type="text" class="form-control" value="${delevery_date}" name="delevery_date" id="delevery_date" onblur="FixShortDate(this);return ValidateForm(this);"  required>
												</div>
											</div>
									  </div>
									  
									  
									  
									  <div class="row">
											
											
												
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Delivery Time</label>
													<input type="time" class="form-control" value="${delivery_time}" name="delivery_time" id="delivery_time" value="00:00"  required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Type</label>
													<input type="text" class="form-control" value="${vehicle_type}" name="vehicle_type" id="vehicle_type"   required>
												</div>
											</div>
									  </div>
									  
									  
									  
									  <div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name</label>
													<input type="text" class="form-control" value="${transporter_name}-${transport_code}" name="transporter_name" id="transporter_name"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Number</label>
													<input type="text" class="form-control" value="${vehicle_no}" name="vehicle_no" id="vehicle_no"   required>
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  
									  
									  <div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name</label>
													<input type="text" class="form-control" value="${driver_name}" name="driver_name" id="driver_name"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Contact </label>
													<input type="text" class="form-control" value="${driver_mobile}" name="driver_mobile" id="driver_mobile"   required>
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  
									  
									  
									  
									  
									  <div class="row">
                                         <div class="col-md-6">
                                                <div class="form-group">
                                        		 			
                                        		 			
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1"  >&nbsp;&nbsp;&nbsp;<b>Consignor</b>
														<!-- <div  id="myd11">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd3"  id="myd3" onclick="showmyd1(this)" value="myd3"  >&nbsp;&nbsp;&nbsp;<b>Same As Above</b>
                                         				</div> -->
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b> Consigning</b>
															
																
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd4"  >&nbsp;&nbsp;&nbsp;<b>Buyer Other then Consigning</b>
															
															</div>
                                         	</div>
                                         </div>
                                         
                                         
                                  	  
									  
									  
									    <div class="row"  id="444">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consigning To Party :</label>
													<input type="text" class="form-control"  value="${shipname}" name="shipname" id="shipname">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consigning Address</label>
													<input type="text" class="form-control" value="${shipadd}" name="shipadd" id="shipadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="555">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consigning State</label>
													<input type="text" class="form-control" value="${shipstate}"  name="shipstate" id="shipstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consigning GSTIN NO :</label>
													<input type="text" class="form-control" value="${shipgstn}" name="shipgstn" id="shipgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row" id="666">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control" value="${dest_contact_person}" name="dest_contact_person" id="dest_contact_person"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${dest_contact_no}"  name="dest_contact_no" id="dest_contact_no"   onblur="checkMobileLength2(this);" required>
												</div>
											</div>
									  </div>
									  
									  
									  
									  
									  
									  
									  <div class="row"  id="111">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor Party :</label>
													<input type="text" class="form-control" value="${loadname}"  name="loadname" id="loadname">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor Address</label>
													<input type="text" class="form-control" value="${loadadd}"  name="loadadd" id="loadadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="222">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor State</label>
													<input type="text" class="form-control"  value="${loadstate}"  name="loadstate" id="loadstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor GSTIN NO :</label>
													<input type="text" class="form-control" value="${loadgstn}"  name="loadgstn" id="loadgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="333">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control" value="${load_contact_person}"   name="load_contact_person" id="load_contact_person"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${load_contact_no}"  name="load_contact_no" id="load_contact_no"  >
												</div>
											</div>
									  
									   </div>
                                         
                                         
                                         
                                         <div class="row"  id="777">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Party :</label>
													<input type="text" class="form-control" value="${buyername}"  name="buyername" id="loadname">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Address</label>
													<input type="text" class="form-control" value="${buyeradd}"  name="buyeradd" id="loadadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="888">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer State</label>
													<input type="text" class="form-control"  value="${buyerstatus}"  name="buyerstatus" id="loadstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer GSTIN NO :</label>
													<input type="text" class="form-control" value="${buyergstn}"  name="buyergstn" id="loadgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="999">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control"  value="${buyer_contact_person}"  name="buyer_contact_person" id="load_contact_person"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${buyer_contact_no}"  name="buyer_contact_no" id="load_contact_no"  >
												</div>
											</div>
									  
									   </div>
                                      
									  
									  	<%-- <div id="product" style="width:100%">
												
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		
																		<th id="VLsparename"><label>Vehicle Type</label> </th>
																		
																		<th id="VLsparename"><label>Source</label> </th>
																		
																		<th id="VLsparename"><label>Destination</label> </th>
																		
																		<th id="VLsparename"><label>Weight</label></th>
									  									
									  									<th id="VLsparename"><label>Rate</label></th>
									  									
									  									<th id="VLsparename"><label>Amount</label></th>
									  									
									  									
									  								
									  								</tr>
									  								
									  								<s:iterator value="inquiryReport">
									  													
																	<tr class="item-row">
																	
																		<td style="width:1px;"></td>
																	
																		<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" style="width: 120px;"  id="ff" required/></td>
																		
																		<td><input type="text" value="<s:property value="aa1"/>" name="aa" class="form-control" style="width: 120px;"  id="aa" required/></td>
																		
																		<td><input type="text" value="<s:property value="bb1"/>" name="bb" class="form-control" style="width: 120px;" id="bb"  required/></td>
																		
																		<td><input type="text" value="<s:property value="cc1"/>" name="cc" class="form-control" id="cc" onblur="getTotal1(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		<td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd" onblur="getAmount(this);"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		<td><input type="text" value="<s:property value="ee1"/>" name="ee" class="form-control" id="ee" onblur="getTotal(this);"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																	
									  								
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
									  								
									  								
									  								
									  								</div> --%>
									  
									
									<input type="hidden" class="form-control" value="${total_weight}" name="total1" id="total1"   readonly >
												
											
									<input type="hidden" class="form-control" value="${total}" name="total" id="total"   readonly >
											
											
											
										<div class="row">	
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark</label>
													<input type="text" class="form-control" value="${remark}" name="remark" id="remark"    required>
												</div>
											</div>
											
									  </div>
										
										
										<%-- <script type="text/javascript">
								
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
																		
																		'<td><input type="text" name="ff" class="form-control" style="width: 120px;"  id="ff" required/></td>',
																		
																		'<td><input type="text" name="aa" class="form-control" style="width: 120px;"  id="aa" required/></td>',
																		
																		'<td><input type="text" name="bb" class="form-control" style="width: 120px;" id="bb"  required/></td>',
																		
																		'<td><input type="text" name="cc" class="form-control" id="cc" onblur="getTotal1(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		
																		'<td><input type="text" name="dd" class="form-control" id="dd"  onblur="getAmount(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		'<td><input type="text" name="ee" class="form-control" id="ee" onblur="getTotal(this);"   style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		
																		'</tr>' ]
																		.join('');
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#aa');
																$($description).autocomplete("GoogleSearch/autosearchCity.jsp");

																var $description1 = $row.find('#bb');
																$($description1).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																
																var $description1 = $row.find('#ff');
																$($description1).autocomplete("GoogleSearch/autosearchVehicleType.jsp");

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
													
								</script>	 --%>						 
										
										
										
										
										
										
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
