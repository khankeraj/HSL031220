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
		// $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		  $("#bill_to").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
		 $("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
		 $("#vehicle_type").autocomplete("GoogleSearch/autosearchVehicleType.jsp");
			
		 
		 
		 $("#loadname").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#shipname").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#buyername").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 
		 
			
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
			
		 
		 
		 $('.item-row').each(function(i, row) {
			 
			 if (window.XMLHttpRequest) {
					var xp1 = new XMLHttpRequest();
				} else {
					var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
				}
				
			 var $s=$(row).find('#vehicle_Type');
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
	 
	function getAddress12(v){
		 
		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 var cname = v.value;
		 var tname = document.getElementById('loadname').value;
		 var cust = cname.split("-");
		/*  var trans = tname.split("-"); */
		 
		 xp11.open("POST", "cust_details?customer_code="+ cust[1]);
			
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
				 var tstate = parts[1];
				 var tgstn = parts[2];
				 var tcperson = parts[3];
				 var tcontact = parts[4];
				 //alert('555');
				 document.getElementById('loadname').value = cust[0];
				 document.getElementById('loadadd').value = tadd;
				 document.getElementById('loadstate').value = tstate;
				 document.getElementById('loadgstn').value = tgstn;
				 document.getElementById('load_contact_person').value = tcperson;		
				 document.getElementById('load_contact_no').value = tcontact;
				 
			    }
			  };
				
	 }
	
	
	function getAddress123(v){
		 
		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 var cname = v.value;
		 var tname = document.getElementById('shipname').value;
		 var cust = cname.split("-");
		/*  var trans = tname.split("-"); */
		 
		 xp11.open("POST", "cust_details?customer_code="+ cust[1]);
			
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
				 var tstate = parts[1];
				 var tgstn = parts[2];
				 var tcperson = parts[3];
				 var tcontact = parts[4];
				 //alert('555');
				  document.getElementById('shipname').value = cust[0];
				 document.getElementById('shipadd').value = tadd;
				 document.getElementById('shipstate').value = tstate;
				 document.getElementById('shipgstn').value = tgstn;
				 document.getElementById('dest_contact_person').value = tcperson;		
				 document.getElementById('dest_contact_no').value = tcontact;
				 
			    }
			  };
				
	 }
	
	function getAddress124(v){
		 
		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 var cname = v.value;
		 var tname = document.getElementById('buyername').value;
		 var cust = cname.split("-");
		/*  var trans = tname.split("-"); */
		 
		 xp11.open("POST", "cust_details?customer_code="+ cust[1]);
			
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
				 var tstate = parts[1];
				 var tgstn = parts[2];
				 var tcperson = parts[3];
				 var tcontact = parts[4];
				 //alert('555');
				  document.getElementById('buyername').value = cust[0];
				 document.getElementById('buyeradd').value = tadd;
				 document.getElementById('buyerstatus').value = tstate;
				 document.getElementById('buyergstn').value = tgstn;
				 document.getElementById('buyer_contact_person').value = tcperson;		
				 document.getElementById('buyer_contact_no').value = tcontact;
				 
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
	
	
	
	
	
	
	<script type="text/javascript">
	
	
	
	
	
	
	
	function getAddress(v){
		 
		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 var cname = v.value;
		 var tname = document.getElementById('transporter_name').value;
		 var cust = cname.split("-");
		 var trans = tname.split("-");
		 
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
					<h1 class="page-header text-overflow">LR Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">LR Form</li>
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
								
							<form action="insert_lr_action" method="POST"   onsubmit="myFunction();">
								<div class="panel-body">
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  onblur="FixShortDate(this);return ValidateForm(this);" name="date" id="date1" value="${datee}"  required>
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Lr Number:</label>
													<input type="text" class="form-control" value="${lr_no}"  name="lr_number" id="lr_number" readonly required>
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
													
													<input type="text" class="form-control" value="${source}" style="background-color: #f3eded"  name="source" id="source"   required>
												
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">To:</label>
													<input type="text" class="form-control" value="${destination}" style="background-color: #f3eded"  name="destination" id="destination"   required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
										
											<input type="hidden" class="form-control" value="${transporter_name}-${transport_code}" name="transporter_name" id="transporter_name"   >
												
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" class="form-control" value="${name}" onblur="getAddress(this)" style="background-color: #f3eded"  name="customer_name" id="customer_name"   required>
												</div>
											</div>
									 <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Volume:</label>
													<input type="text" class="form-control"  name="volume" id="volume"  required>
												</div>
											</div>
											</div>
											<div class="row">
									 
									 <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle No:</label>
													<input type="text" class="form-control"  name="vehicle_no" id="vehicle_no" style="background-color: #f3eded"   value="${vehicle_no}"   required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Type</label>
																		
													<input type="text" class="form-control" style="background-color: #f3eded"  value="${vehicle_type}"  name="vehicle_Type" id="vehicle_type"  required>
												</div>
											</div>
											
									 
									  </div>
													
							<input type="hidden" class="form-control"  name="transporter_addr" id="transporter_addr"   >
											
							<input type="hidden" class="form-control"  name="customer_addr" id="customer_addr"   >
												
									  
									  <div class="row">
									  
									  		
									  		
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name:</label>
													<input type="text" class="form-control"  name="driver_name" style="background-color: #f3eded"   id="driver_name" value="${driver_name}"   class="form-control" >
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Contact </label>
													<input type="text" class="form-control" value="${driver_mobile}" style="background-color: #f3eded"  name="driver_mobile" id="driver_mobile"   required>
												</div>
											</div>
											
									  </div>
									  
									  
									  
									  
									  
									  
									  
									  <div class="row">
									  
									  <input type="hidden" class="form-control"  name="commission" id="commission"  class="form-control" >
											
										<input type="hidden" class="form-control" value="${order_id}" name="order_id" id="order_id"  readonly>
															
										<input type="hidden" class="form-control" value="${inquiry_id}" name="inquiry_id" id="inquiry_id"  readonly>
											
											
									  </div>
									  
									  
									  
									  
									  <div class="row">
									  
												
											
									 <!--  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Invoice Value(Rupees):</label>
													<input type="text" class="form-control"  name="val_rupees" id="val_rupees"  required>
												</div>
											</div> -->
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Invoice No</label>
													<input type="text" class="form-control"  name="invoice_No" id="invoice_No"  required>
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">invoice value</label>
													<input type="number" class="form-control"   name="invoice_value" id="invoice_value"  required>
												</div>
											</div>
											
									  </div>
											
										  <div class="row">
									  
												<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mode Of Booking :</label>
													
													<select class="form-control show-tick " name="booking" id="booking" required>
												
																<option value="">...........Select..........</option>
			
																<option value="AIR">Air</option>
																<option value="TRAIN">Train</option>
																<option value="SURFACE">Surface</option>
																
																
													</select>
												</div>
									  </div>
									  
									  
									  
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Insurance Type:</label>
													
													<select class="form-control show-tick " name="insurance" id="insurance" required>
												
																<option value="">...........Select..........</option>
			
																<option value="INSURED">Insured</option>
																<option value="UNINSURED">Uninsured</option>
																
																
													</select>
												</div>
									  </div>
									  </div>
									  
									  <div class="row">
									  
												
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mode Of Freight :</label>
													
													<select class="form-control show-tick " name="freight" id="freight" required>
												
																<option value="">...........Select..........</option>
			
																<option value="TOPAY">To Pay</option>
																<option value="PAID">Paid</option>
																<option value="TBB">Tbb</option>
																
																
													</select>
												</div>
									  </div>
									  
									  
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bill To </label>
													<input type="text" class="form-control"  name="bill_to" id="bill_to"  required>
												</div>
											</div>
											
									  </div>
									   
									  <div class="row">
									  
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Owner Risk </label>
													<input type="text" class="form-control"  name="owner_risk" id="owner_risk"  required>
												</div>
											</div>
											
											
									  </div>
									    <div class="row">
									  
										
									  </div>
									  
									  
									  
									  <div class="row">
                                         <div class="col-md-6">
                                                <div class="form-group">
                                        		 			
                                        		 			
																	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1"  >&nbsp;&nbsp;&nbsp;<b>Consignor</b>
														<!-- <div  id="myd11">
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd3"  id="myd3" onclick="showmyd1(this)" value="myd3"  >&nbsp;&nbsp;&nbsp;<b>Same As Above</b>
                                         				</div> -->
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b style="color: orange;"> Consignee</b>
															
																
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd4"  >&nbsp;&nbsp;&nbsp;<b style="color: blue;">Buyer Other then Consigning</b>
															
															</div>
                                         	</div>
                                         </div>
                                         
                                         
                                         
                                          <div class="row"  id="111">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor Party :</label>
													<input type="text" class="form-control" value="${loadname}"   onblur="getAddress12(this)" name="loadname" id="loadname">
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
                                         
                                         
                                         
                                    <div class="row"  id="444">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee To Party :</label>
													<input type="text" class="form-control" style="border-color: orange;" onblur="getAddress123(this)"  value="${shipname}" name="shipname" id="shipname">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee Address</label>
													<input type="text" class="form-control" value="${shipadd}" style="border-color: orange;" name="shipadd" id="shipadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="555">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee State</label>
													<input type="text" class="form-control" value="${shipstate}" style="border-color: orange;" name="shipstate" id="shipstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee GSTIN NO :</label>
													<input type="text" class="form-control" value="${shipgstn}"  style="border-color: orange;" name="shipgstn" id="shipgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row" id="666">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control" value="${dest_contact_person}" name="dest_contact_person" style="border-color: orange;" id="dest_contact_person">
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${dest_contact_no}"  name="dest_contact_no" id="dest_contact_no"  style="border-color: orange;"  onblur="checkMobileLength2(this);">
												</div>
											</div>
									  </div>
									  
			                               
                                         <div class="row"  id="777">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Party :</label>
													<input type="text" class="form-control" value="${buyername}"  onblur="getAddress124(this)"    style="border-color:blue;" name="buyername" id="buyername">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Address</label>
													<input type="text" class="form-control" value="${buyeradd}" style="border-color:blue;" name="buyeradd" id="buyeradd"  >
												</div>
											</div>
											
									</div>
									  
									   <div class="row"  id="888">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer State</label>
													<input type="text" class="form-control"  value="${buyerstatus}" style="border-color:blue;" name="buyerstatus" id="buyerstatus"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer GSTIN NO :</label>
													<input type="text" class="form-control" value="${buyergstn}" style="border-color:blue;" name="buyergstn" id="buyergstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="999">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control"  value="${buyer_contact_person}" style="border-color:blue;" name="buyer_contact_person" id="buyer_contact_person"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" value="${buyer_contact_no}" style="border-color:blue;" name="buyer_contact_no" id="buyer_contact_no"  >
												</div>
											</div>
									  
									   </div>
                                         
									  
									  <div id="product" style="width:100%">
												
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		
																		<th id="VLsparename"><label>Description</label> </th>
																	
																		<th id="VLsparename"><label>NO Of Packages</label> </th>
																		
																		<th id="VLsparename"><label>Type Of Packing</label> </th>
																		
																			
																		<!-- <th id="VLsparename"><label>Vehicle Type</label> </th>
																		 -->
																		<!-- <th id="VLsparename"><label>From</label> </th>
																		
																		<th id="VLsparename"><label>To</label> </th>
																		 -->
																		<th id="VLsparename"><label>Weight</label> </th>
																		
																		<!-- <th id="VLsparename"><label>Rate</label></th>
									  									 -->
									  									<th id="VLsparename"><label>Amount</label></th>
									  								
									  								</tr>
									  								
									  								
									  								<%-- <s:iterator value="inquiryReport"> --%>
																	
																	<tr class="item-row">
																	
																	<td style="width:1px;"></td>
																	<td><input type="text"  name="cc" class="form-control" style="width: 250px;" id="cc"  required/></td>
																	
																	
																	<td><input type="text" name="aa" class="form-control" style="width: 80px;"  id="aa" required/></td>
																	
																		<td><input type="text"  name="bb" class="form-control" style="width: 80px;"  id="bb" required/></td>
																		
																			
																		<%-- <td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd"  style="width: 80px;" required/> </td>
																		 --%>
																		<%-- <td><input type="text" value="<s:property value="ee1"/>" name="ee" class="form-control" id="ee"   style="width: 100px;"  required/> </td>
																		
																		<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" id="ff"  style="width: 100px;"  required/> </td>
																		 --%>
																		<td><input type="text" value="${resource_from}" name="gg" onblur="getTotal(this);" class="form-control" id="gg"  style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		<%-- <td><input type="text" value="<s:property value="hh1"/>" name="hh" onblur="getAmount(this);getTotal1(this);" class="form-control" id="hh"  style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		 --%>
																		<td><input type="text" value="${rno}" name="ii"  class="form-control" id="ii"  onblur="getTotal1(this);" style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
									  								
									  								</tr>
									  								<%-- </s:iterator> --%>
									  								
									  								
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
									  								
									  								
									  								<table id="TaNAB" class="table table-striped table-bordered" cellspacing="0" width="70%">

																	<tr>
																		<td>Total Amount</td>
																		<td><input type="text" name="total_amount" class="form-control"
																			id="total_amount" value="${rno}"
																			readonly
																			style="width: 120px;" required/></td>
																			
																			<td>Total Weight</td>
																		<td><input type="text" name="advance" class="form-control"
																			id="advance" value="${resource_from}"
																			readonly
																			style="width: 120px;" required/></td>
																			
																			
																		
																		<input type="hidden" name="balance" class="form-control" style="width: 120px;" />
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
																		
																		'<td><input type="text"  name="cc" class="form-control" style="width: 250px;" id="cc"  required/></td>',
																		
																		'<td><input type="text" name="aa" class="form-control" style="width: 80px;"  id="aa" required/></td>',
																		
																		'<td><input type="text"  name="bb" class="form-control" style="width: 80px;"  id="bb" required/></td>',
																		
																		
																		/* '<td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd"  style="width: 80px;" required/> </td>',
																		 */
																		/* '<td><input type="text" value="<s:property value="ee1"/>" name="ee" class="form-control" id="ee"   style="width: 100px;"  required/> </td>',
																		
																		'<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" id="ff"  style="width: 100px;"  required/> </td>',
																		 */
																		'<td><input type="text" value="<s:property value="gg1"/>" name="gg" onblur="getTotal(this);" class="form-control" id="gg"  style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		
																		/* '<td><input type="text" value="<s:property value="hh1"/>" name="hh" onblur="getAmount(this);getTotal1(this);" class="form-control" id="hh"  style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		 */
																		'<td><input type="text" value="<s:property value="ii1"/>" name="ii"  class="form-control" id="ii" onblur="getTotal1(this);"style="width: 80px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		'</tr>' ]
																		.join('');
															
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#ee');
																$($description).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																var $description1 = $row.find('#ff');
																$($description1).autocomplete("GoogleSearch/autosearchCity.jsp");

																
																var $description2 = $row.find('#dd');
																$($description2).autocomplete("GoogleSearch/autosearchVehicleType.jsp");

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
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit"  id="myBtn">Submit</button>
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
