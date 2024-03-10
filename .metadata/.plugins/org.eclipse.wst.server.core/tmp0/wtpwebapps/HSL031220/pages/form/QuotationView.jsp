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
		 //$("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 //$("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 //$("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 //$("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 //$("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
		 //$("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
	});
	 
	 /* $(function() {
			var today = new Date(); 
			var dd = today.getDate(); 
			var mm = today.getMonth()+1;//January is 0! 
			var yyyy = today.getFullYear(); 
			if(dd<10){dd='0'+dd} 
			if(mm<10){mm='0'+mm} 
			$("#date").val(dd+'/'+mm+'/'+yyyy);
			
			
		}); */
	 
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
					<h1 class="page-header text-overflow">Quotation View</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Quotation</a></li>
					<li class="active">Quotation View</li>
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
								
							<!-- <form action="InsertQuotation" method="POST"> -->
								
								<div class="panel-body">
								
								<div class="row">
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control" value="${datee}"  name="date" id="date" readonly   required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name:</label>
													<input type="text" class="form-control"  name="name" id="name" value="${vendor}"   readonly>
												</div>
											</div>
									  
									  </div>
								
									  
									  <div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Address:</label>
													<input type="text" class="form-control" value="${price_id}" name="address" id="address"  readonly>
												</div>
											</div>
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mobile:</label>
													<input type="text" class="form-control" value="${remark}" name="contact_no" id="contact_no"   readonly>
												</div>
											</div>
									  </div>
									  
									   <div class="row">
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Reference Type:</label>
													
													<select class="form-control show-tick " name="reference" id="reference" readonly>
												
																<option value=" ">${reference}</option>
																<option value="By Email">By Email</option>
																<option value="By Phone">By Phone</option>
													</select>
												</div>
									  </div>
								
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Kind Attn:</label>
													<input type="text" class="form-control" value="${kind_attn}" name="kind_attn" id="kind_attn" readonly>
												</div>
											</div>
									  </div>
									  
									  
									  
									  
									  	<div id="product" style="width:100%">
												
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		<th id="VLsparename"><label>Type Of Vehicle</label> </th>
																		
																		<!-- <th id="VLsparename"><label>Size Of Vehicle</label> </th> -->
																		
																		<th id="VLsparename"><label>Weight</label></th>
									  									
									  									<th id="VLsparename"><label>Rate</label></th>
									  									
									  									<th id="VLsparename"><label>Source</label></th>
									  									
									  									<th id="VLsparename"><label>Destination</label></th>
									  								
									  								</tr>
									  								
									  								<s:iterator value="inquiryReport">
									  													
																	<tr class="item-row">
																	
																		<td style="width:1px;"></td>
																	
																		<td><input type="text" value="<s:property value="aa1"/>" name="aa" class="form-control" style="width: 120px;"  id="aa" readonly/></td>
																		
																		<%-- <td><input type="text" value="<s:property value="bb1"/>" name="bb" class="form-control" style="width: 120px;" id="bb"  readonly/></td> --%>
																		
																		<td><input type="text" value="<s:property value="cc1"/>" name="cc" class="form-control" id="cc"  style="width: 120px;" readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="dd1"/>" name="dd" class="form-control" id="dd"   style="width: 120px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="ee1"/>" name="ee" class="form-control" id="ee"   style="width: 120px;"  readonly/> </td>
																		
																		<td><input type="text" value="<s:property value="ff1"/>" name="ff" class="form-control" id="ff"   style="width: 120px;"  readonly/> </td>
									  								
									  								
									  								</tr>
									  								
									  								</s:iterator>
									  								
									  								</table>
									  								
									  								
									  								
									  								
									  								
									  								</div>
									  
										<div class="row">
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total</label>
													<input type="text" class="form-control" value="${total}" name="total" id="total" readonly >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Quotation No</label>
													<input type="text" class="form-control" value="${inq_id}" name="quotation_no" id="quotation_no"  readonly >
												</div>
											</div>
											
											
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
