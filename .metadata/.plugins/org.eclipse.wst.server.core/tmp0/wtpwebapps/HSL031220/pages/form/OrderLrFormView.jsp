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
		 
		// alert(balance);
		 document.getElementById("balance").value = balance;
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
					<h1 class="page-header text-overflow">LR Form View</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">LR</a></li>
					<li class="active">LR Form View</li>
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
								
							<!-- <form action="insert_lr_action" method="POST"> -->
								
								
								<div class="panel-body">
								
								
								<s:push value="tripModel1">
								
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  style="line-height: 15px;" value="${date}" name="date" id="date" class="form-control" readonly>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">LR Number:</label>
													<input type="text" class="form-control"   value="${lr_number}" name="lr_number" id="lr_number" class="form-control" readonly>
												</div>
											</div>
											
									  </div>
								
								
								
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">From:</label>
													<input type="hidden" name="trip_id" value="${trip_id}">
													<input type="hidden" name="updown_id" value="${updown_id}">
													<input type="hidden" name="updown" value="${updown}">
													<input type="text" class="form-control" value="${source}" name="source" id="source"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Destination:</label>
													<input type="text" class="form-control" value="${destination}" name="destination" id="destination"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name:</label>
													<input type="text" class="form-control" value="${transporter_name}-${transporter_code}" name="transporter_name" id="transporter_name"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" class="form-control" value="${customer_name}-${customer_code}"  name="customer_name" id="customer_name"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
									  </div>
									  
									
													
													
													
									<input type="hidden" class="form-control" value="${transporter_addr}" name="transporter_addr" id="transporter_addr"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												
								<input type="hidden" class="form-control" value="${customer_addr}" name="customer_addr" id="customer_addr"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												
									  
									  <div class="row">
									  
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle No:</label>
													<input type="text" class="form-control"  name="vehicle_no" id="vehicle_no" value="${vehicle_no}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
									  		
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="text" class="form-control"  name="driver_name"  id="driver_name" value="${driver_name}-${driver_code}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" readonly>
												</div>
											</div>
									  </div>
									  
									  
									  <div class="row">
									  
									  		
													<input type="hidden" class="form-control" value="${commission}" name="commission" id="commission"  class="form-control" readonly>
												
										
													<input type="hidden" class="form-control" value="${order_id}" name="order_id" id="order_id"  readonly>
												
											 <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Contact </label>
													<input type="text" class="form-control" value="${driver_mobile}" name="driver_mobile" id="driver_mobile"   readonly>
												</div>
											</div>
											
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Volume:</label>
													<input type="text" class="form-control" value="${volume}" name="volume" id="volume"  readonly>
												</div>
											</div>
											
									  </div>
									  
									  
									  
									  <div class="row">
									  
									  			
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Insurance Type:</label>
													
													<select class="form-control show-tick " name="insurance" id="insurance" readonly>
												
																<option value="${insurance} ">${insurance}</option>
			
																	
																
													</select>
												</div>
									  </div>
											
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mode Of Booking :</label>
													
													<select class="form-control show-tick " name="booking" id="booking" readonly>
												
																<option value="${booking}">${booking}</option>
			
															
																
																
													</select>
												</div>
									  </div>
											
									  </div>
									  
									  
									  
									  <div class="row">
									  
									  			
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Value Rupees:</label>
													<input type="text" class="form-control" value="${val_rupees}"  name="val_rupees" id="val_rupees"  readonly>
												</div>
											</div>
											
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mode Of Freight :</label>
													
													<select class="form-control show-tick " name="freight" id="freight" readonly>
												
																<option value="${freight}">${freight}</option>
			
																
													</select>
												</div>
									  </div>
											
									  </div>
									  
									  
									  <div class="row">
                                         <div class="col-md-6">
                                                <div class="form-group">
                                        		 			
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b>Shipment Details</b>
															
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1"  >&nbsp;&nbsp;&nbsp;<b>Loading Details</b>
                                         		</div>
                                         	</div>
                                         </div>
                                         
                                         
                                  	  
									  
									  
									  <div class="row"  id="444">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship To Party :</label>
													<input type="text" class="form-control" value="${shipname}" name="shipname" name="shipname" readonly>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Shipping Address</label>
													<input type="text" class="form-control" value="${shipadd}" name="shipadd" id="shipadd"  readonly>
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="555">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship State</label>
													<input type="text" class="form-control" value="${shipstate}"  name="shipstate" id="shipstate"  readonly>
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship GSTIN NO :</label>
													<input type="text" class="form-control" value="${shipgstn}"  name="shipgstn" id="shipgstn" readonly >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row" id="666">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control" value="${dest_contact_person}" name="dest_contact_person" id="dest_contact_person"   readonly>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${dest_contact_no}" name="dest_contact_no" id="dest_contact_no" onblur="checkMobileLength2(this);"  readonly>
												</div>
											</div>
									  </div>
                                         
									  <div class="row"  id="111">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Load Party :</label>
													<input type="text" class="form-control" value="${loadname}" name="loadname" name="loadname" readonly>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Loading Address</label>
													<input type="text" class="form-control" value="${loadadd}" name="loadadd" id="loadadd" readonly >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="222">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Loading State</label>
													<input type="text" class="form-control" value="${loadstate}"  name="loadstate" id="loadstate"  readonly>
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Loading GSTIN NO :</label>
													<input type="text" class="form-control" value="${loadgstn}" name="loadgstn" id="loadgstn"  readonly>
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="333">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control" value="${load_contact_person}"  name="load_contact_person" id="load_contact_person"  readonly>
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${load_contact_no}" name="load_contact_no" id="load_contact_no" readonly >
												</div>
											</div>
									  
									   </div>
									  
									  
									  <div id="product" style="width:100%">
														
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		
																		<th id="VLsparename"><label>NO Of Packages</label> </th>
																		
																		<th id="VLsparename"><label>Type Of Packing</label> </th>
																		
																		<th id="VLsparename"><label>Description</label> </th>
																		
																		<th id="VLsparename"><label>Vehicle Type</label> </th>
																		
																		<th id="VLsparename"><label>Source</label> </th>
																		
																		<th id="VLsparename"><label>Destination</label> </th>
																		
																		<th id="VLsparename"><label>Weight</label> </th>
																		
																		<th id="VLsparename"><label>Rate</label></th>
									  									
									  									<th id="VLsparename"><label>Amount</label></th>
									  								
									  								</tr>
									  								
									  								
									  								 <s:iterator value="tripDetails"> 
																	
																	<tr class="item-row">
																	<td style="width:1px;"></td>
																	
																	
																	<td><input type="text" value="<s:property value="aa1"/>" name="aa" class="form-control" style="width: 80px;"  id="aa" readonly/></td>
																	
																		<td><input type="text"  value="<s:property value="bb1"/>" name="bb" class="form-control" style="width: 80px;"  id="bb" readonly/></td>
																		
																		<td><input type="text"  value="<s:property value="cc1"/>" name="cc" class="form-control" style="width: 250px;" id="cc"  readonly/></td>
																		
																		<td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd"  style="width: 80px;" readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="ee1"/>" name="ee" class="form-control" id="ee"   style="width: 100px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" id="ff"  style="width: 100px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="gg1"/>" name="gg" onblur="getTotal(this);" class="form-control" id="gg"  style="width: 80px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="hh1"/>" name="hh" onblur="getAmount(this);" class="form-control" id="hh"  style="width: 80px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="ii1"/>" name="ii" onblur="getTotal1(this);" class="form-control" id="ii"  style="width: 80px;"  readonly/> </td>
									  								
									  								</tr>
									  								
									  								</s:iterator> 
									  								
									  								</table>
									  								
									  								
									  								
									  								<table id="TaNAB" class="table table-striped table-bordered" cellspacing="0" width="70%">

																	<tr>
																		<td>Total Amount</td>
																		<td><input type="text" name="total_amount" class="form-control"
																			id="total_amount" value="${total_amount}"
																			tabindex="12"
																			style="width: 120px;" readonly/></td>
																			
																			<td>Total Weight</td>
																		<td><input type="text" name="advance" class="form-control"
																			id="advance" value="${advance}"
																			tabindex="12" 
																			style="width: 120px;" readonly/></td>
																			
																		
																	</tr>
																	
																
																	</table>
									  								
									  								
									  								</div>
									  
																 
										
										
										
										
										
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<!-- <button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button> -->
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<!-- <button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button> -->
											</div>
										</div>
								     </div>
									</div>
									
									</s:push>
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
