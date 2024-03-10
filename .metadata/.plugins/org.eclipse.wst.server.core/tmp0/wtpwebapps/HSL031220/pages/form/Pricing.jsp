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
	<script src="js/rangopopup.js" type="text/javascript"></script>
	
	 <script>
	  $(function() {
		// $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		$("#dd").autocomplete("GoogleSearch/autosearchVehicleType.jsp");
		$("#aa").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#bb").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#transname").autocomplete("GoogleSearch/transporterautosearch.jsp");
		 $("#popupContactcustomer").hide();
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
	</script>
			
			
	<script>
	 
	 function getTotal(v)
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
			document.getElementById("total").value=amount;
		
	 }
	 
	 function openPopupcust() {
			
			loadPopupcust();


		}

		function disablePopup_cust() {
		//disables popup only if it is enabled
		if (popupStatus_cust == 1) {
		$("#backgroundPopup").fadeOut("slow");
		$("#popupContactcustomer").fadeOut("slow");
		popupStatus_cust = 0;
		}
		}


		function Addinfocust(v) {
			//alert("144444");

			if (window.XMLHttpRequest) {
				var xp11 = new XMLHttpRequest();
			} else {
				var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
			}
				
			var temp=0;
			
				//alert("1");

			var tab1 = document.getElementById('loc').value;
			var tab2 = document.getElementById('mobile').value;

			//	alert("2" + tab1);
			
			if(tab1=="")
			{
				 temp=false;
				 alert("Please Fill Name ");
				 document.getElementById('loc').focus();
				
			}
			else if(tab2=="")
			{
				 temp=false;
				 alert("Please Fill Contact Number ");
				 document.getElementById('mobile').focus();
				
			}
			
			else{
				
				 temp=true;
				
			}
				
				
			
				if(temp== true)
					{
						
			
			xp11.open("POST", "Add_New_Transporter?name="+tab1+"&mobile="
					+ tab2 );
			
			xp11.send();
			//alert("343");
			xp11.onreadystatechange = function() {
			//	alert(xp11.readyState);
				if (xp11.readyState == 4 && xp11.status == 200) {
					///$("#popupContact").hide();
					//popupStatus = 0;
					//alert("rep"+xp11.responseText);
					if(xp11.responseText.trim()=="already"){
						alert("This Transporter already exists");
					}
				}
			};

			document.getElementById('loc').value = tab1;


			disablePopup_cust();
			
			
			}
				

				
			return temp;
			
		}
		 
	 </script>
	 
	<style>
#popupContactcustomer {
  position: fixed;
    top: 50%;
    left: 60%;
  transform: translate(-50%, -50%);
}
</style> 
	 
	 
	 
	 
	 
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
					<h1 class="page-header text-overflow">Pricing</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Pricing</a></li>
					<li class="active">Pricing Form</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								<!-- <div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div> -->
								
							<form action="InsertPricing" method="POST" onsubmit="myFunction();" >
								
								<div class="panel-body">
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  style="line-height: 15px;" name="date" id="date1"  value="${datee}"  class="form-control" required>
												</div>
											</div>
											
											 <div class="col-sm-5" style="display: none;">
												<div class="form-group">
													<label class="control-label">Transporter Name:</label>
													<input type="text" class="form-control"  name="name" id="name"   class="form-control" >
												
												</div>
											</div>
											<div class="col-sm-1" style="display: none;">
												<div class="form-group">
												<label class="control-label"></label><br>
												<br>
													<input type="Button" class=" btn btn-primary" value="New" onclick="openPopupcust();" />
												
												</div>
											</div> 
									  
									  </div>
								
									  
									  <div class="row">
											
											
											
													<input type="hidden" class="form-control" value="${inquiry_id}" name="inquiry_id" id="inquiry_id"  class="form-control" readonly>
												
											
											
											 <div class="col-sm-6" style="display: none;">
												<div class="form-group">
													<label class="control-label">Type:</label>
													<input type="text" class="form-control" value="${type}" name="type" id="type"  class="form-control" readonly>
												</div>
											</div> 
									  </div>
									  
									  
									  
									  
									  
									  
									  	<div id="product" style="width:100%">
												
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		
																		<th id="VLsparename"><label>Transporter name</label>
																		
																	
													<input type="Button" class=" btn btn-primary" value="New" onclick="openPopupcust();" />
												
												
											</div> 
																		</th>
																		
																		<th id="VLsparename"><label>Type</label></th>
																		
																		<th id="VLsparename"><label>Vehicle Type</label></th>
																		
																		<th id="VLsparename"><label>From</label> </th>
																		
																		<th id="VLsparename"><label>To</label> </th>
																		
																		<th id="VLsparename"><label>Price</label></th>
									  									
									  									
									  								
									  								</tr>
									  								
									  								
									  													
																	<tr class="item-row">
																	
																		<td style="width:1px;"></td>
																		
																		<td><input type="text" name="transname" class="form-control" id="transname"   style="width: 120px;"  required/> </td>
																		
																		<td><input type="text" name="transtype" class="form-control" id="transtype"   style="width: 120px;"  required value="${type}"/> </td>
																		
																		<td><input type="text" name="dd" class="form-control" id="dd"   style="width: 120px;"  required/> </td>
																	
																		<td><input type="text" name="aa" class="form-control" style="width: 120px;"  id="aa" value="${source12}" required/></td>
																		
																		<td><input type="text" name="bb" class="form-control" style="width: 120px;" id="bb"  value="${dest12}"  required/></td>
																		
																		<td><input type="text" name="cc" class="form-control" id="cc" onblur="getTotal(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>
																		
																		
									  								
									  								
									  								</tr>
									  								
									  								
									  								
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
													<input type="text" class="form-control"  name="total" id="total"  class="form-control" readonly required>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark</label>
													<input type="text" class="form-control"  name="remark" id="remark"  class="form-control" >
												</div>
											</div>
											
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
																		
																		'<td><input type="text" name="transname" class="form-control" id="transname"   style="width: 120px;"  required/> </td>',
																		
																		'<td><input type="text" name="transtype" class="form-control" id="transtype"   style="width: 120px;"  required value="${type}"/> </td>',

																		'<td><input type="text" name="dd" class="form-control" id="dd"   style="width: 120px;"  required/> </td>',
																		
																		'<td><input type="text" name="aa" class="form-control" style="width: 120px;"  id="aa" required/></td>',
																		
																		'<td><input type="text" name="bb" class="form-control" style="width: 120px;" id="bb"  required/></td>',
																		
																		'<td><input type="text" name="cc" class="form-control" id="cc" onblur="getTotal(this);" style="width: 120px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/> </td>',
																		
																					
																		'</tr>' ]
																		.join('');
																var $row = $($rowTemp);
																$.currentRow = $row;

																var $description = $row.find('#aa');
																$($description).autocomplete("GoogleSearch/autosearchCity.jsp");

																var $description1 = $row.find('#bb');
																$($description1).autocomplete("GoogleSearch/autosearchCity.jsp");
																
																var $description2 = $row.find('#dd');
																$($description2).autocomplete("GoogleSearch/autosearchVehicleType.jsp");
																
																var $description3 = $row.find('#transname');
																$($description3).autocomplete("GoogleSearch/transporterautosearch.jsp");
																
																
																
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
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" id="myBtn">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
									</div>
								</form>
								
								
								
			<form action="#" id="popupContactcustomer" style="overflow:auto;background-color:#bdd7f9;width:600px;"  method="POST" style="">


				<center><h2>Add New Transporter</h2></center><br>
				
				
					<div id="page-content" style=";">
					<div class="">
						
						<div class="">
							
							<div class="row">
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Transporter Name :
                                                    </label>
                                                    <input type="text" class="form-control"  id="loc"   name="loc"  required> 
                                                </div>
                                       		 </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="row">
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Contact No :
                                                    </label>
                                                    <input type="text" class="form-control"  id="mobile"   name="mobile"  required> 
                                                </div>
                                       		 </div>
                                       		 
                                         		</div>
                                         		
                                         		
                                         		<div class="col-md-6">
                                            	<div class="form-group">
						
					&nbsp;&nbsp; &nbsp;<button type="button" onclick=" return Addinfocust(this);" class="btn btn-default w3ls-button">Submit</button>   
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button"  onclick="disablePopup_cust();" class="btn btn-default w3ls-button">Back</button> 
					</div></div>
						</div>
					</div>
				</div>
				
	
			
			
					

			</form>
										
					<div id="backgroundPopup"></div></div>
								
								
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
