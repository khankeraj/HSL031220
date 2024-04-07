<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="utility.SysDate"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
 <!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <!-- AutoSearch -->
	<script>
	$(function() {
		 $("#description").autocomplete("GoogleSearch/autosearchCustomer.jsp");
	});
	</script>
<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRow").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
													var $itemsTable = $('#itemsTable');
													var $rowTemp = [
															'<tr class="item-row">',
															'<td><a id="deleteRow1"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input type="text" class="form-control" name="description" id="description" onblur="skipqty(this)"></td>',
															'<td><input  type="text" class="form-control" id="quantity" onblur="fetchItemDetails(this)" name="quantity" /></td>',
															'<td><input  type="text" class="form-control" id="rate" name="rate"/></td>',
															'<td><input  type="text" class="form-control" id="amount" name="amount"/></td>',
															'<td><input  type="text" class="form-control" id="hsn_code" name="hsn_code"/></td>',
															'<td><input  type="text" class="form-control" id="rate1" name="rate1" /></td>',
															'<td><input  type="text" class="form-control" id="amount1" name="amount1"/></td>',
															'<td><input  type="text" class="form-control" id="rate2" name="rate2" /></td>',
															'<td><input  type="text" class="form-control" id="amount2" name="amount2"/></td>',
															'<td><input  type="text" class="form-control" id="net_amount" name="net_amount" /></td>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

													$last = $('#itemsTable')
															.find(
																	'tbody tr:last');
													$.first = $last
															.find('input:first');
													var $btype = $row
															.find('#btype');
													
												var $description1 = $row
													.find('#description');
											$($description1)
													.autocomplete(
															"GoogleSearch/autosearchCustomer.jsp"); 
													
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
													$($description1).focus();

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
							
							totalnetamt();
						});
						$("#deleteRow1").live('click', function() {
							//alert(">>>");
						
							$(this).parents('.item-row').remove();
							// Hide delete Icon if we only have one row in the list.
							if ($(".item-row").length < 2)
								$("#deleteRow1").hide();
							
							totalnetamt();
						});
						
						
						function fetchItemDetails(v)
						{
							
							var $traverse_row = $(v).parents('.item-row');
							var $hoardinglocationx = $($traverse_row).find('#description');
							var descript=$($hoardinglocationx).val();
							
							var $qty = $($traverse_row).find('#quantity');
							
							if (window.XMLHttpRequest) {
								var xp1 = new XMLHttpRequest();
							} else {
								var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
							}

							var tab1 = descript;
							if (tab1 != "") {
								xp1.open("POST", "fetchItemDetails?item_name=" + tab1);
								//alert("hie2222");
								xp1.send();
								//alert("hie3333");
								xp1.onreadystatechange = function() {
									// alert(xp1.readyState );
									if (xp1.readyState == 4 && xp1.status == 200) {
										var rep = xp1.responseText;
										//alert("rep"+rep);
									
										var parts = rep.split(",");
										
										var rate = parts[0];
										var hsn_code = parts[1];
										var tax = parts[2]/2;
										
										var $rate = $($traverse_row).find('#rate');
										$($rate).val(rate);
										
										var qty=$($qty).val();
										
										var  amount=(rate)*(qty);
										
										var $amount = $($traverse_row).find('#amount');
										$($amount).val(amount);
										
										
										var $hsn_code = $($traverse_row).find('#hsn_code');
										$($hsn_code).val(hsn_code);
										
										var taxamount=(amount*tax)/100;
										
										var $tax = $($traverse_row).find('#rate1');
										$($tax).val(tax);
										
										var $taxamount = $($traverse_row).find('#amount1');
										$($taxamount).val(taxamount);
										
										var taxamount1=(amount*9)/100;
										
										var $tax = $($traverse_row).find('#rate2');
										$($tax).val(tax);
										
										var $taxamount1 = $($traverse_row).find('#amount2');
										$($taxamount1).val(taxamount);
										
										var $amount = $($traverse_row).find('#net_amount');
										$($amount).val(amount);
										
										
										getamount1();//fetch cgst details;
										getamount2();//fetch sgst details;
										netAmount();//fetch total_amount;
										fetchtaxDetails();//fetch total tax amount;
										getFeightValue();//
										getTransportValue()//
										
										}
									}
							}
						}
					</script>
					
					<script>
						function getamount1() {
							var amt1 = 0;
						
						$('.item-row').each(function(i, row) {
							var $exp = $(row).find('#amount1');
							
							var $exp1 = $($exp).val();
							amt1 = Math.abs(amt1) + Math.abs($exp1);
						});
						document.getElementById("cgst").value = Math.abs(amt1).toFixed(2);
						}
			</script>
			
				<script>
						function getamount2() {
							var amt1 = 0;
						
						$('.item-row').each(function(i, row) {
							var $exp = $(row).find('#amount2');
							
							var $exp1 = $($exp).val();
							amt1 = Math.abs(amt1) + Math.abs($exp1);
						});
						document.getElementById("sgst").value = Math.abs(amt1).toFixed(2);
						}
			</script>
			<script>
						function netAmount() {
							var amt1 = 0;
						
						$('.item-row').each(function(i, row) {
							var $exp = $(row).find('#net_amount');
							
							var $exp1 = $($exp).val();
							amt1 = Math.abs(amt1) + Math.abs($exp1);
						});
						document.getElementById("total").value = Math.abs(amt1).toFixed(2);
						}
			</script>
			<script>
			function fetchtaxDetails()
			{
				alert("hii");
				 var cgst=document.getElementById("cgst").value;
				 var sgst=document.getElementById("sgst").value;
				var totaltaxamt=Math.abs(cgst) + Math.abs(sgst);
				document.getElementById("total_amount").value=Math.abs(totaltaxamt).toFixed(2);
			}
			</script>
			
			<script>
				function getFeightValue() {
					 var feight=document.getElementById("feight").value;
					 //alert(feight);
					 var total=document.getElementById("total").value;
					 var totalamount=Math.abs(total) + Math.abs(feight);
					 document.getElementById("totalamt").value=Math.abs(totalamount).toFixed(2);
				}
			</script>
			
			<script>
				function getTransportValue() {
					var transport=document.getElementById("transport").value;
					//alert(transport);
					 var total=document.getElementById("totalamt").value;
					 var totalamount=Math.abs(total) + Math.abs(transport);
					 document.getElementById("totalamt").value=Math.abs(totalamount).toFixed(2);
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
					<h1 class="page-header text-overflow">Customer PO</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">PO</a></li>
					<li class="active">Customer PO</li>
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
								<form action="CustomerProformaInvoice" method="POST">
									<div class="panel-body">
									  
									  <div class="row">
									 	  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Invoice NO :</label>
													<input type="text" class="form-control" placeholder=" " name="invoice_no"  class="form-control" required>
												</div>
											</div>
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Code :</label>
													<%
													DBConnection connection=new DBConnection();
													Connection conn=connection.getConnection();
													PreparedStatement pst=conn.prepareStatement("SELECT `customer_no`, `customer_name` FROM `customer_master_details`");
													ResultSet rs=pst.executeQuery();
													%>
													<!-- <input type="text" class="form-control" placeholder=" " name="customer_code"  class="form-control" required> -->
													<input list="customer_nm" name="customer_code" onblur="getCustomerDetails()" id="customer_code" class="form-control" >
													  <datalist id="customer_nm">
														<%
														while(rs.next()){
															String cust_code=rs.getString(1);
															String cust_name=rs.getString(2);
														%>   
													    <option value="<%=cust_code%>"><%=cust_name%></option>
													<%} 
													conn.close();
													%>
													  </datalist>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  	<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name</label>
													<input type="text" class="form-control" placeholder="" style="margin-top: 18px;" id="customer_name" name="customer_name"  class="form-control" required>
												</div>
											</div>
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">GSTIN NO :</label>
													<input type="text" class="form-control" placeholder=" " id="gstin_no" name="gstin_no"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									 	 <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PAN NO</label>
													<input type="text" class="form-control" placeholder="" id="pan_no"  name="pan_no"  class="form-control" required>
												</div>
											</div>
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">State :</label>
													<input type="text" class="form-control" placeholder=" " id="state" name="state"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
										  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">City</label>
													<input type="text" class="form-control" placeholder="" id="city"  name="city" class="form-control" required>
												</div>
											</div>
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Mobile NO :</label>
													<input type="text" class="form-control" placeholder=" " id="mobile_no" name="mobile_no" class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
										  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Pending Amount</label>
													<input type="text" class="form-control" placeholder="" id="pending_amt"  name="pending_amt" class="form-control" required>
												</div>
											</div>
											<%
											SysDate sd=new SysDate();
											String reqDate[]=sd.todayDate().split("-");
											String reqDate1=reqDate[2]+"-"+reqDate[1]+"-"+reqDate[0];
										
											%>
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control" placeholder=" " value="<%=reqDate1%>"  name="requiredDate"  class="form-control" required>
												</div>
											</div>
									  </div>
									  
									   <div class="row">
									  	    <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Address</label>
													<input type="text" class="form-control" placeholder="" id="address"  name="address" class="form-control" required>
												</div>
											</div>
											
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PO NO</label>
													<input type="text" class="form-control" placeholder=""  name="po_no" class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PO Date :</label>
													<input type="date" class="form-control" placeholder=" "  style="line-height:15px;"  name="po_date" class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  		<div class="col-sm-6">
												<div class="form-group">
													<div class="pad-ver">
														<!--Checkboxes labeled-->
														<label class="form-checkbox form-normal form-primary active"><input type="checkbox" id="myCheck" onclick=" myFunction()"> Details</label>
														<label class="form-checkbox form-normal form-primary"><input type="checkbox" id="myCheck1" onclick="myFunction1()">Shipment Details</label>
													</div>
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="first">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Pay Term :</label>
													<input type="text" class="form-control" placeholder=" " name="payterm" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vendor</label>
													<input type="text" class="form-control" placeholder=""  name="vendor" class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="first1">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle NO :</label>
													<input type="text" class="form-control" placeholder=" " name="vehicle_no" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">DC NO :</label>
													<input type="text" class="form-control" placeholder=""  name="dc_no" class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="first2">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">DC Date :</label>
													<input type="date" class="form-control" placeholder=" " style="line-height:15px;" name="dc_date" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">TransPort Mode :</label>
													<input type="text" class="form-control" placeholder=""  name="transPort_mode" class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="first3">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">GRN NO :</label>
													<input type="text" class="form-control" placeholder=" " name="grn_no" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact NO :</label>
													<input type="text" class="form-control" placeholder=""  name="contact_no" class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="second1">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship To Party :</label>
													<input type="text" class="form-control" placeholder=" " name="shipTOParty" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Shipping Address</label>
													<input type="text" class="form-control" placeholder=""  name="shippingAddress" class="form-control" >
												</div>
											</div>
									  </div>
									  
									   <div class="row" style="display: none;" id="second2">
									  		<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship GSTIN NO :</label>
													<input type="text" class="form-control" placeholder=" " name="shipgstinno" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Ship State</label>
													<input type="text" class="form-control" placeholder=""  name="shipstate" class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
													<tr>
														<td colspan="5">
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																		<th><i class="fa fa-remove" title="Remove Item"></i></th>
																		<th id="VLsparename"><label>Description </label></th>
																		<th id="VLsparename"><label>Quantity</label></th>
																		<th id="VLsparename"><label>Rate</label></th>
																		<th id="VLsparename"><label>Amount</label></th>
																		<th id="VLsparename"><label>HSN Code</label></th>
																		<th id="VLsparename"><label>Rate</label></th>
																		<th id="VLsparename"><label>Amount</label></th>
																		<th id="VLsparename"><label>Rate</label></th>
																		<th id="VLsparename"><label>Amount</label></th>
																		<th id="VLsparename"><label> Net Amount</label></th>
																	</tr>
																	
																	<tr class="item-row">
																		<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																		<td><input type="text" class="form-control" name="description" id="description" onblur="skipqty(this)"></td>	
																		<td><input type="text" name="quantity" id="quantity" onblur="fetchItemDetails(this)" class="form-control"></td>
																		<td><input type="text" name="rate" id="rate" class="form-control"></td>
																		<td><input type="text" name="amount" id="amount" class="form-control"></td>
																		<td><input type="text" name="hsn_code" id="hsn_code" class="form-control"></td>
																		<td><input type="text" name="rate1" id="rate1" class="form-control"></td>
																		<td><input type="text" name="amount1" id="amount1" class="form-control"></td>
																		<td><input type="text" name="rate2"  id="rate2" class="form-control"></td>
																		<td><input type="text" name="amount2"  id="amount2" class="form-control"></td>
																		<td><input type="text" name="net_amount" id="net_amount" class="form-control"></td>
																	</tr>
																	
																</table>
																	<table id="demo-dt-addrow" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																			<td align="left"><a	href="#" id="addRow" class="button-clean large">
																			<span><img id="" tabindex="13" src="configure/img/icon-plus.png" alt="Add" title="Add Row" style="margin-left: 0px" />
																			Add Item</span> </a></td>
																	</tr>
																</table>
															</td>
														</tr>
												</table>
											</div>
                                          </div>
                                        </div>
                                        
                                        
                                         <div class="row">
									  		<div class="col-sm-3">
												<div class="form-group">
													<label class="control-label">Total :</label>
													<input type="text" class="form-control" placeholder=" " id="total" name="total" class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-3">
												<div class="form-group">
													<label class="control-label">Feight :</label>
													<input type="text" class="form-control" placeholder=""  id="feight"  name="feight" onblur="getFeightValue()" class="form-control" >
												</div>
											</div>
											<div class="col-sm-3">
												<div class="form-group">
													<label class="control-label">TransPort :</label>
													<input type="text" class="form-control" placeholder=" " id="transport" name="transport" onblur="getTransportValue()" class="form-control" >
												</div>
											</div>
											
											<div class="col-sm-3">
												<div class="form-group">
													<label class="control-label">Total Amount :</label>
													<input type="text" class="form-control" placeholder="" id="totalamt" name="totalamt" class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="margin-left: 4px;">
									  		<table width="30%">
									  			<tr>
									  				<td width="15%">TAX</td>
									  				<td width="15%">TAX Amount</td>
									  			</tr>
									  			
									  			<tr>
									  			<td>
									  			<input type="text" value="CGST:" class="form-control">
									  			<input type="text" value="SGST:" class="form-control">
									  			<input type="text" value="Total Amount:" class="form-control">
									  			</td>
									  			<td>
									  			<input type="text" id="cgst" name="cgst" class="form-control">
									  			<input type="text" id="sgst" name="sgst" class="form-control">
									  			<input type="text"id="total_amount" name="total_tax_amt" class="form-control">
									  			</td>
									  			</tr>
									  		</table>
									  </div>
                                        
                                        
									<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
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
	<!--JAVASCRIPT-->
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<!-- END SETTINGS -->
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<!-- END SETTINGS -->
	<script type="text/javascript">
	function myFunction() {
		  // Get the checkbox
		  var checkBox = document.getElementById("myCheck");
		  // Get the output text
		  var text = document.getElementById("first");
		  var text1 = document.getElementById("first1");
		  var text2 = document.getElementById("first2");
		  var text3 = document.getElementById("first3");

		  // If the checkbox is checked, display the output text
		  if (checkBox.checked == true){
		    text.style.display = "block";
		    text1.style.display = "block";
		    text2.style.display = "block";
		    text3.style.display = "block";
		  } else {
		    text.style.display = "none";
		    text1.style.display = "none";
		    text2.style.display = "none";
		    text3.style.display = "none";
		  }
		}
	
	function myFunction1() {
		  // Get the checkbox
		  var checkBox = document.getElementById("myCheck1");
		  // Get the output text
		  var text1 = document.getElementById("second1");
		  var text2 = document.getElementById("second2");

		  // If the checkbox is checked, display the output text
		  if (checkBox.checked == true){
		    text1.style.display = "block";
		    text2.style.display = "block";
		    
		  } else {
		    text1.style.display = "none";
		    text2.style.display = "none";
		  }
		}
	
	function getCustomerDetails() {
		
		var id=document.getElementById("customer_code").value;
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (xhttp.readyState == 4 && xhttp.status == 200) {
		      var demo= (xhttp.responseText).split(",");
		      document.getElementById("customer_name").value=demo[0];
		      document.getElementById("gstin_no").value=demo[1];
		      document.getElementById("pan_no").value=demo[2];
		      document.getElementById("state").value=demo[3];
		      document.getElementById("city").value=demo[4];
		      document.getElementById("mobile_no").value=demo[5];
		      document.getElementById("pending_amt").value=demo[6];
		      document.getElementById("address").value=demo[7];
		    }
		  };
		  xhttp.open("POST", "fetchCust?customer_code="+id, true);
		  xhttp.send();
	}
</script>
</body>
</html>

