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
 
  <%-- <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
   --%>
   <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale2noreq.js" type="text/javascript"></script>
  
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->
	
	<script src="js/datevalidation.js" type="text/javascript"></script>
	
	
	 <script>
	 $(function() {
		 $("#vehicle_type").autocomplete("GoogleSearch/autosearchVehicleType.jsp");
		 //$("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
		 
		 $("#route").autocomplete("GoogleSearch/autosearchRoute.jsp");
		// $("#aa").autocomplete("GoogleSearch/autosearchCity.jsp");
		// $("#bb").autocomplete("GoogleSearch/autosearchCity.jsp");
		
		 
		 $("#loadname").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#shipname").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#buyername").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		
		 

		
		
		
		
		
		
		
		 /* $('.item-row').each(function(i, row) {
				 
				 if (window.XMLHttpRequest) {
						var xp1 = new XMLHttpRequest();
					} else {
						var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
					}
					
				 var $s=$(row).find('#ff');
				 var $s1=$(row).find('#aa');
				 var $s2=$(row).find('#bb');	
					
				 `
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
					<h1 class="page-header text-overflow">Vehicle Confirmation </h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Vehicle</a></li>
					<li class="active">Vehicle Confirmation</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								
								
							<form action="InsertOrder" method="POST"  onsubmit="myFunction();">
								
								<div class="panel-body">
								
								
								
							<input type="hidden" class="form-control" value="${pricing_id}"  name="pricing_id" id="pricing_id" readonly   >
												
							<input type="hidden" class="form-control" value="${inquiry_id}"  name="inquiry_id" id="inquiry_id" readonly   >
											
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  onblur="FixShortDate(this);return ValidateForm(this);" name="date" id="date1"  value="${datee}"  required>
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
													<input type="text" class="form-control" value="${contact_no}" name="contact_no" id="contact_no"  onblur="checkMobileLength(this);" required>
												</div>
											</div>
									  </div>
									  
									  
									
													
													
								<input type="hidden" class="form-control" value="${state}" name="state" id="state"   >
												
								<input type="hidden" class="form-control" value="${gstn}" name="gstn" id="gstn"   >
												
									  
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control"  value="${contact_person}" name="src_contact_person" id="src_contact_person"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control"   value="${contact_no}"name="src_contact_no" id="src_contact_no"  onblur="checkMobileLength1(this);"  required>
												</div>
											</div>
									  </div>
									  
									  
									
									<input type="hidden" class="form-control"  name="ebillno" id="ebillno"  >
												
									<input type="hidden" class="form-control"  name="invoiceno" id="invoiceno"  >
												
									  
									  
									  
									  <div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name</label>
													<input type="text" class="form-control" value="${transporter_name}"  name="transporter_name" id="transporter_name"   required>
												</div>
												
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Route</label>
													<input type="text" class="form-control"  name="route" id="route"   required>
												</div>
											</div>
											
											 </div>
											 
											  <div class="row">
											 
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Delivery Date</label>
													<input type="text" class="form-control"  name="delevery_date" id="delevery_date" onblur="FixShortDate(this);return ValidateForm(this);"  required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Delivery Time</label>
													<input type="time" class="form-control"  name="delivery_time" id="delivery_time" value="00:00" style=" height: 30px;"  required>
												</div>
											</div>
									
									 	 </div>
									  
									  
									  <div class="row">
											
											
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Type</label>
													<input type="text" class="form-control"  name="vehicle_type" value="${vehicle_type}"  id="vehicle_type"   required>
												</div>
											</div>
											
											
												
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Number</label>
													<input type="text" class="form-control"  name="vehicle_no" id="vehicle_no11" required >
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  
									  
									  <div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Name</label>
													<input type="text" class="form-control"  name="driver_name" id="driver_name"   required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Driver Contact </label>
													<input type="text" class="form-control"  name="driver_mobile" id="driver_mobile"   required>
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  
									  <div class="row">
                                         <div class="col-md-6">
                                                <div class="form-group">
                                        		 			
                                        		 			<table>
                                        		 			<tr>
																
																<td>	
															<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1">&nbsp;&nbsp;&nbsp;<b>Consignor</b>
														
														<br>
														<div  id="myd11">
															<!-- <input type="checkbox" name="myd3"  id="myd3" onclick="showmyd1(this)" value="myd3"> &nbsp;&nbsp;&nbsp;<b>same as above</b>
                                         				 --></div>
                                         				</td>
                                         				<td valign="top">
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b style="color: orange">Consignee </b><br>
															
															</td>
															<td valign="top">
															
																
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="myd4"  id="myd4" onclick="showmyd1(this)" value="myd4"  >&nbsp;&nbsp;&nbsp;<b style="color: blue;">Buyer Other then Consigning</b>
														</td>
														</tr>
														</table>
															</div>
                                         	</div>
                                         </div>
     									  
									  
									  
									  
									  
									  <div class="row"  id="111">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor Party :</label>
													<input type="text" class="form-control"  onblur="getAddress12(this)" name="loadname" id="loadname">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor Address</label>
													<input type="text" class="form-control"  name="loadadd" id="loadadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="222">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor State</label>
													<input type="text" class="form-control"   name="loadstate" id="loadstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignor GSTIN NO :</label>
													<input type="text" class="form-control"  name="loadgstn" id="loadgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="333">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control"   name="load_contact_person" id="load_contact_person"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control"  name="load_contact_no" id="load_contact_no"  >
												</div>
											</div>
									  
									   </div>				
									   
									   
                                         
                                         <div class="row"  id="444">
                                         
									  		<div class="col-sm-6">
									  		<input type="checkbox" name="type"  id="type"  value="yes"  >&nbsp;&nbsp;&nbsp;<b style="color: orange">Add To Master </b>
											<br>
												<div class="form-group">
													<label class="control-label">Consignee To Party :</label>
													<input type="text" class="form-control" style="border-color: orange" onblur="getAddress123(this)"  name="shipname" id="shipname">
												</div>
											</div>
											
											<div class="col-sm-6">
											<br>
										
												<div class="form-group">
													<label class="control-label">Consignee Address</label>
													<input type="text" class="form-control" style="border-color: orange" name="shipadd" id="shipadd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="555">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee State</label>
													<input type="text" class="form-control"  style="border-color: orange" name="shipstate" id="shipstate"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Consignee GSTIN NO :</label>
													<input type="text" class="form-control" style="border-color: orange" name="shipgstn" id="shipgstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row" id="666">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person:</label>
													<input type="text" class="form-control"  style="border-color: orange"name="dest_contact_person" id="dest_contact_person"   >
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control"  style="border-color: orange"name="dest_contact_no" id="dest_contact_no"   onblur="checkMobileLength2(this);" >
												</div>
											</div>
									  </div>
									  
									  
                                         
                                         <div class="row"  id="777">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Party :</label>
													<input type="text" class="form-control" style="border-color: blue;" name="buyername" onblur="getAddress124(this)" id="buyername">
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer Address</label>
													<input type="text" class="form-control" style="border-color: blue;" name="buyeradd" id="buyeradd"  >
												</div>
											</div>
											
											
									  
									  
									  
									  </div>
									  
									   <div class="row"  id="888">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer State</label>
													<input type="text" class="form-control"  style="border-color: blue;" name="buyerstatus" id="buyerstatus"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Buyer GSTIN NO :</label>
													<input type="text" class="form-control"  style="border-color: blue;" name="buyergstn" id="buyergstn"  >
												</div>
											</div>
									  
									   </div>
									   
									   
									   <div class="row"  id="999">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person</label>
													<input type="text" class="form-control"  style="border-color: blue;" name="buyer_contact_person" id="buyer_contact_person"  >
												</div>
											</div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Number:</label>
													<input type="text" class="form-control" style="border-color: blue;" name="buyer_contact_no" id="buyer_contact_no"  >
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
																		
																		<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" style="width: 120px;"  id="ff" /></td>
																	
																		<td><input type="text" value="<s:property value="aa1"/>" name="aa" class="form-control" style="width: 120px;"  id="aa" /></td>
																		
																		<td><input type="text" value="<s:property value="bb1"/>" name="bb" class="form-control" style="width: 120px;" id="bb"  /></td>
																		
																		<td><input type="text" name="cc" class="form-control" id="cc" onblur="getTotal1(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" /> </td>
																		
																		<td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd" onblur="getAmount(this);"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" /> </td>
																		
																		<td><input type="text" name="ee" class="form-control" id="ee" onblur="getTotal(this);"  style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" /> </td>
																		
																	
									  								
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
									  
										
										
										<div class="row">
											
										
											<input type="hidden" class="form-control"  name="total1" id="total1"   readonly >
												
											<input type="hidden" class="form-control"  name="total" id="total"   readonly >
															
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark</label>
													<input type="text" class="form-control"  name="remark" id="remark"    required>
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
																		'<td><input type="text" name="ee" class="form-control" id="ee" onblur="getTotal(this);"   style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"  required/> </td>',
																		
																		'</tr>' ]
																		.join('');
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#aa');
																$($description).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																var $description1 = $row.find('#bb');
																$($description1).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																
																var $description2 = $row.find('#ff');
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
													
								</script>	 --%>						 
										
										
										
										
										
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit"  d="myBtn" >Submit</button>
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
