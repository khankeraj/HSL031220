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
	
	<script>
	$(function() {
		 $("#exp_parti").autocomplete("GoogleSearch/autosearchExp.jsp");
		 $("#given_by").autocomplete("GoogleSearch/employee.jsp");
	});
	
	
	function getRNA()
	 {
		 
		 
		//alert("1");
		 
		 //alert("VA::"+v.value);
		 
		 var $traverse_row = $().parents('.item-row');
		 
			 
				/* $i = $($traverse_row).find('#invcheck');;
				
				var isChecked=$(v).attr('checked');
				
				if(isChecked == 'checked'){
					
					//alert("2");
					
					$($i).val($(v).val());
					
					
				}
				
				else{
					
					$($i).val('');
				} */
					 
				
					var amt15=parseFloat("0"); 
				
					var amt16=parseFloat("0"); 
					
					var amt17=parseFloat("0");
					
					var amt18=parseFloat("0");
					
				    var t_name="";
					 
				$('.item-row').each(function(i, row) {
					
					$hoardinglocationx1 = $(row).find('#net_amt');
					$hoardinglocationx2 = $(row).find('#gst_rate1amt');
					//$hoardinglocationx3 = $(row).find('#gst_rate2amt');
					
					$hoardinglocationx4 = $(row).find('#amount');
					
					
					
					
					
					var check = $($hoardinglocationx1).val(); 
					//alert("check : "+check);
					
					var check2 = $($hoardinglocationx2).val();
					//var check3 = $($hoardinglocationx3).val();
					
					var check4 = $($hoardinglocationx4).val();
					
					//alert("22");
					
					//$mycec=$(row).find('#dcno');
					//alert("dcno - -- "+$mycec.val());
					
					//var isChecked=$($mycec).prop("checked");
					//alert("ischecked: "+isChecked);
					
					//var count = 0;
					//var tr1 = "";
					//if(isChecked == true){
						
						//alert("33");
					
						//count++;
						
						
					
						amt15=amt15 + parseFloat(check);
						amt16=amt16 + parseFloat(check2);
						//amt17=amt17 + parseFloat(check3);
						amt18=amt18 + parseFloat(check4);
						
						//alert("amt15 : "+amt15);
						//alert("amt16 : "+amt16);
						//alert("amt17 : "+amt17);
						//t_name=t_name.concat(check2+"~");
					//}
					
					
					
				});
				
									
				//alert("t_name : "+t_name);
				//alert("amt-="+amt15);
				document.getElementById("total_amount1").value = amt15;
				document.getElementById("cgst").value = amt16;
				//document.getElementById("sgst").value = amt17;
				
				var total_tax = amt16 ;
				document.getElementById("total_tax_amount").value = total_tax;
				
				
				document.getElementById("total_amt").value = amt18;
				
	 			//alert(amt15);
	 }
	
	
	function getValues(v)
	 {
		 var $traverse_row = $(v).parents('.item-row');
			
			//	alert(">>>");
				$hoardinglocationx1 = $($traverse_row).find('#rate');
				//alert(">>>");
				$hoardinglocationx = $($traverse_row).find('#weight');
				
				$hoardinglocationx2 = $($traverse_row).find('#gst_rate1');
				
				$hoardinglocationx3 = $($traverse_row).find('#gst_rate2');
			//	alert(">>>");
				/* $hoardinglocation3 = $($traverse_row).find('#amount'); */
				$('.item-row').each(function(i,row){
				var weight = $($hoardinglocationx).val();
				
				var rate = $($hoardinglocationx1).val();
				
				var rate1 = $($hoardinglocationx2).val();
				
				var rate2 = $($hoardinglocationx3).val();
				/* var amount = $($hoardinglocation3).val();  */
				
				
				if(weight!="" && rate!="" ){
					amt= rate * weight;
					
					gamt1 = (amt * rate1)/100;
					gamt2 = (amt * rate2)/100;
					net_am = amt + gamt1 + gamt2; 
					
					$hoardinglocation = $($traverse_row).find('#amount');
					$hoardinglocation1 = $($traverse_row).find('#gst_rate1amt');
					$hoardinglocation2 = $($traverse_row).find('#gst_rate2amt');
					$hoardinglocation3 = $($traverse_row).find('#net_amt');
					//alert(amt);
					
					$($hoardinglocation).val(amt);
					$($hoardinglocation1).val(gamt1);
					$($hoardinglocation2).val(gamt2);
					$($hoardinglocation3).val(net_am);
					
					
					
					
					
					
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
		 
		 getTotal();
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
			document.getElementById("total_amt").value=amount;
		
	 }
	
	
	 
	 
	 function getnewsrno(v) {
			//alert("1" + v);

			if (window.XMLHttpRequest) {
				var xp1 = new XMLHttpRequest();
			} else {
				var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
			}

			var $traverse_row = $(v).parents('.item-row');
			var $hoardinglocation = $($traverse_row).find('#description');
			
			var $hoardinglocation1 = $($traverse_row).find('#weight');
			var $hoardinglocation2 = $($traverse_row).find('#rate');
			var $hoardinglocation3 = $($traverse_row).find('#amount');
			var $hoardinglocation4 = $($traverse_row).find('#hsn');
			var $hoardinglocation5 = $($traverse_row).find('#gst_rate1');
			var $hoardinglocation6 = $($traverse_row).find('#gst_rate1amt');
			var $hoardinglocation7 = $($traverse_row).find('#gst_rate2');
			var $hoardinglocation8 = $($traverse_row).find('#gst_rate2amt');
			
			var $hoardinglocation9 = $($traverse_row).find('#net_amt');
			xp1.open("POST", "gettaxnhsn?description="+ $($hoardinglocation).val());
					

			//alert("1");
			xp1.send();

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//	alert("rep"+rep);
					var parts = new Array();
					//alert("2");
					parts = rep.split("^");

					var hsn = parts[0];
					//alert("rate1" + rate1);
					
					
					var tax1 = parts[1];
					//alert("tax1" + tax1);
					
					var tax_rate = parseFloat(tax1)/2;
					
					$traverse_row = $(v).parents('.item-row');
					
					$($hoardinglocation4).val(hsn);
					$($hoardinglocation5).val(tax_rate);
					$($hoardinglocation7).val(tax_rate);
					
					
					
					/* $hoardinglocationx = $($traverse_row).find('#quantity1');
					
					var qty=$($hoardinglocationx).val();
					var amount = (tax1 * qty)/100;
					var netamount = rate1 * qty;
					//alert("amount"+amount);
					// var total1 = (tax1) * amount; 
					 
					 var total1 = (amount + netamount); */
					//alert("tax"+tax);
					//alert("3");
					//alert(xp1.responseText);
					
					/* $hoardinglocation = $($traverse_row).find('#amount1');
					$($hoardinglocation2).val(netamount);
					$hoardinglocation = $($traverse_row).find('#vat1');
						$($hoardinglocation3).val(tax1); 
						$hoardinglocation = $($traverse_row).find('#taxqmount1');
						$($hoardinglocation4).val(amount); 
						$hoardinglocation = $($traverse_row).find('#vatamount1');
						$($hoardinglocation5).val(total1);  */
						
						//alert(">>>>1");
						
						  $("#addRow").focus();
						  //alert(">>>>2");
					
					
					
					
					//alert("4");
					/* var parts=rep.split("~");

					 //alert(">>>>");
					 var $traverse_row = $(a).parents('.item-row');
					 var $hoardinglocation= $($traverse_row).find('#price');
					 $($hoardinglocation).val(parts[1]);
					 var $hoardinglocation1= $($traverse_row).find('#currentqty');
					 $($hoardinglocation1).val(parts[0]); */

					//document.getElementById("price").value=parts[1];
					///document.getElementById("currentqty").value=parts[0];
				}

			}

		}
	 
	 
	 
	 
	 
	  function checkTotals()
	 {
		 /* var tot1 = document.getElementById("total_amt").value;
		 var tot2 = document.getElementById("total_amount").value;
		 
		if(tot1!=tot2)
		{
			alert('Both the Total amounts should be equal!');
			return false;
			//history.go(-1)
			//window.location.reload();
		}
		 */
		/* else
		{ */
			document.getElementById("form1").action = "Edit_Invoice";
		/* } */
	 } 
	 
	 
	 
	 
	 
	 
	
	
	
	</script> 
	
	
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
	
	 <%-- <script>
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
			alert(amount);
			document.getElementById("total_amount").value=amount;
		
	 }
	 
	 function getBalance(v)
	 {
		 var advance = v.value;
		 var total = document.getElementById('total_amount').value;
		 var balance = Math.abs(total) - Math.abs(advance);
		 
		 alert(balance);
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
 --%>
</head>
<body onload="getRNA();">

	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Invoice Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Transport</a></li>
					<li class="active">Invoice Form</li>
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
								
							<form id="form1"  method="POST" action="#">
								<div class="panel-body">
								
								<s:push value="deliverymodel" >
								
								<div class="row">
										<div class="col-sm-6">
													<div class="form-group">
														<label class="control-label">Invoice No:</label>
														<input type="text" class="form-control" placeholder="" name="invoiceno" id="invoiceno" value="${invoiceno}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													</div>
										</div>
								</div>
											
								<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Customer Code:</label>
													
														<input type="text" class="form-control" placeholder="" name="customer_no" id="customer_no" value="<s:property value = "customer_no" />"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Customer Name:</label>
													
														<input type="text" class="form-control" placeholder="" name="customer_name" id="customer_name" value="${customer_name}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
								
								
								
								</div>
								
								
								
								<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">GSTIN No:</label>
													
														<input type="text" class="form-control" placeholder="" name="gstin_no" id="gstin_no" value="<s:property value = "gstin_no" />"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Pan No:</label>
													
														<input type="text" class="form-control" placeholder="" name="pan_no" id="pan_no" value="${pan_no}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
								
								
								
								</div>
								
								
								<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">State:</label>
													
														<input type="text" class="form-control" placeholder="" name="state" id="state" value="${state}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">City:</label>
													
														<input type="text" class="form-control" placeholder="" name="city" id="city" value="<s:property value = "city" />"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
								
								
								
								</div>
								
								
								<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Mobile:</label>
													
														<input type="text" class="form-control" placeholder="" name="mobile" id="mobile" value="${mobile}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Pending Amount:</label>
													
														<input type="text" class="form-control" placeholder="" name="pending_amount" id="pending_amount" value="${pending_amount}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
								
								
								
								</div>
								
								<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Address:</label>
													
														<input type="text" class="form-control" placeholder="" name="address" id="address" value="${address}"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required readonly>
													
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
											
												
													<label class="control-label">Date:</label>
													
														<input type="date" class="form-control" placeholder="" name="date" id="date" style="line-height:15px;"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required >
													
												</div>
											 </div>
								
								
								</div>
								
								
								
								
								      
									  
									  
									  
									  
									  
									  
									  
									  
									  
									  
									  
									  
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total Amount:</label>
													<input type="text" class="form-control" placeholder="" name="total_amount" id="total_amount" value="${total_amount}"  class="form-control" required readonly>
												</div>
											</div>
											
									  </div>
									  </s:push>
										
										<div id="product" style="width:100%;overflow-x:auto;" >
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%" colspan="5">

															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%" >
																	
																	<tr>
																		
																		<th style="">Delete</th>
																		
																		
																		<th id="VLsparename"><label>LR No.</label>
																		</th>
																		
																		<th id="VLsparename"><label>Description</label>
																		</th>
																		
																		<th id="VLsparename"><label>Weight</label>
																		</th>
																		
																		<th id="VLsparename"><label>Rate</label></th>
									  									
									  									<th id="VLsparename"><label>Amount</label></th>
									  									
									  									<th id="VLsparename"><label>Penalty Amount</label></th>
									  									
									  									<th id="VLsparename"><label>HSN</label></th>
									  									
									  									<th id="VLsparename"><label>Igst Rate</label></th>
									  									
									  									<th id="VLsparename"><label>Igst Amount</label></th>
									  									
									  									<!-- <th id="VLsparename"><label>Rate2</label></th>
									  									
									  									<th id="VLsparename"><label>Amount2</label></th> -->
									  									
									  									<th id="VLsparename"><label>Net Amount</label></th>
									  								</tr>
									  								
									  								
									  								
									  								
									  								<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	
																<c:forEach items="${deliveryDetails}" var="deliveryDetails">
																	<tr class="item-row">
																	<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																	
																	<td hidden><input type="text" name="trip_id1" class="form-control"
																			style="width: 150px;" id="trip_id1" value="${deliveryDetails.trip_id}" 
																			tabindex="11"   /></td>	
																			
																	<td hidden><input type="text" name="updown_id1" class="form-control"
																			style="width: 150px;" id="updown_id1" value="${deliveryDetails.updown_id}" 
																			tabindex="11"   /></td>	
																			
																	<td hidden><input type="text" name="source1" class="form-control"
																			style="width: 150px;" id="source1" value="${deliveryDetails.source}" 
																			tabindex="11"   /></td>	
																			
																	<td hidden><input type="text" name="destination1" class="form-control"
																			style="width: 150px;" id="destination1" value="${deliveryDetails.destination}" 
																			tabindex="11"   /></td>	
																	
																	
																	<td><input type="text" name="lr_number1" class="form-control"
																			style="width: 150px;" id="lr_number1" value="${deliveryDetails.lr_number}" 
																			tabindex="11"   /></td>	
																	
																	
																	<td><input type="text" name="description" class="form-control"
																			style="width: 100%;" value="${deliveryDetails.description1}" id="description"
																			tabindex="10"  /></td>
																		<td><input type="text" name="weight" class="form-control"
																			style="width: 100px;" id="weight" value="${deliveryDetails.weight1}" 
																			tabindex="11"  onblur="getnewsrno(this)" /></td>
																			
																		<td><input type="text" name="rate" class="form-control"
																			style="width: 100px;" id="rate" value="${deliveryDetails.rate1}" 
																			tabindex="11"  onblur="getValues(this)" /></td>	
																			
																		
																		<td><input type="text" name="amount" class="form-control"
																			style="width: 100px;" id="amount" value="${deliveryDetails.amount1}" 
																			tabindex="11"   /></td>	
																		
																		
																		<td><input type="text" name="penalty_amt" class="form-control"
																			id="penalty_amt" value="${deliveryDetails.penalty_amount}"
																			tabindex="12"
																			style="width: 100px;" />
																		</td>
																		
																		<td><input type="text" name="hsn" class="form-control"
																			id="hsn" value="${deliveryDetails.hsn1}"
																			tabindex="12"
																			style="width: 100px;" />
																		</td>
																		
																		<td><input type="text" name="gst_rate1" class="form-control"
																			id="gst_rate1" value="${deliveryDetails.gstrate1}"
																			tabindex="12"
																			style="width: 100px;" />
																		</td>
																		
																		<td><input type="text" name="gst_rate1amt" class="form-control"
																			id="gst_rate1amt" value="${deliveryDetails.gstamt1}"
																			tabindex="12"
																			style="width: 100px;" />
																		</td>
																		
																		<input type="hidden" name="gst_rate2" class="form-control"
																			id="gst_rate2" value="${deliveryDetails.gstrate2}"
																			tabindex="12"
																			style="width: 100px;" />
																		
																		
																		<input type="hidden" name="gst_rate2amt" class="form-control"
																			id="gst_rate2amt" value="${deliveryDetails.gstamt2}"
																			tabindex="12"
																			style="width: 100px;" />
																		
																		
																		<td><input type="text" name="net_amt" class="form-control"
																			id="net_amt" value="${deliveryDetails.net_amt1}"
																			tabindex="12"
																			style="width: 100px;" />
																		</td>
																		
																		
									  								</tr>
									  								
									  								
									  								</c:forEach>
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
													
													
													
													
													</td>
													</tr>
													
													<!-- <tr><td>Total Amount  : <input type="text" name="total_amt" id="total_amt" /></td></tr>
													
													<tr><td>Total Amount (With Tax ) : <input type="text" name="total_amount1" id="total_amount1" /></td></tr>
													
													<tr>
														<td>
																<table>
																	<tr><td>CGST:</td><td><input type="text" name="cgst" id="cgst"></td></tr>
																	<tr><td>SGST:</td><td><input type="text" name="sgst" id="sgst"></td></tr>
																	<tr><td>Total Tax Amount:</td><td><input type="text" name="total_tax_amount" id="total_tax_amount"></td></tr>
																</table>
														</td>
													</tr>
													 -->
													 
													 <tr>
														<td>
																<table>
																	<tr><td>Total Amount: </td><td> <input type="text"  class="form-control" name="total_amt" id="total_amt" /></td></tr>
													
																	<tr><td>Total Amount (With Tax ): </td><td><input class="form-control"  type="text" name="total_amount1" id="total_amount1" /></td></tr>
																	<tr><td>IGST: </td><td><input class="form-control"  type="text" name="cgst" id="cgst"></td></tr>
																	<!-- <tr><td>SGST: </td><td><input class="form-control"  type="text" name="sgst" id="sgst"></td></tr> -->
																	<tr><td>Total Tax Amount: </td><td><input type="text"  class="form-control" name="total_tax_amount" id="total_tax_amount"></td></tr>
																</table>
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
																		
																		'<td><input type="text" name="lr_number1" class="form-control" style="width: 150px;" id="lr_number1"  tabindex="11"   /></td>',
																		'<td><input type="text" name="description" class="form-control" style="width: 100%;" value="" id="description"/></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="weight"  id="weight" onblur="getnewsrno(this)" /></td>',
																		//puc,
																		'<td><input style="width:100px;" type="text" class="form-control" name="rate"   id="rate" value="" onblur="getValues(this)" /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="amount"   id="amount" value=""  /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="penalty_amt"   id="penalty_amt" value=""  /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="hsn"   id="hsn" value=""  /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="gst_rate1"   id="gst_rate1" value=""  /></td>',
																		'<td><input style="width:100px;" type="text" class="form-control" name="gst_rate1amt"   id="gst_rate1amt" value=""  /></td>',
																		'<input style="width:100px;" type="hidden" class="form-control" name="gst_rate2"   id="gst_rate2" value=""  />',
																		'<input style="width:100px;" type="hidden" class="form-control" name="gst_rate2amt"   id="gst_rate2amt" value=""  />',
																		'<td><input style="width:100px;" type="text" class="form-control" name="net_amt"   id="net_amt" value=""  /></td>',
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
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" onclick="checkTotals()">Submit</button>
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
	<script>getRNA();</script>
</body>
</html>
