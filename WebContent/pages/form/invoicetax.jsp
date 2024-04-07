<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.DB.DBConnection,java.sql.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Ultracare Group</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
 <script src="Css/jquery-ui.js" type="text/javascript"></script>
<script src="Css/jquery-ui.css" type="text/javascript"></script>

<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
<script src="datevalidation.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="js/rptsTable/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
<script type="text/javascript" src="jQuery_4_design/AddRowDataTable/purchase_spare.js"></script>
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>


<script>
function getTamtNTtxamt(){
	alert('Inside getTamtNTtxamt()');
	var net_amt = document.getElementById('net_amount').value;
	alert(net_amt);
	
	
}
</script>



</head>
<body onload="getTamtNTtxamt();">

<div id="container" class="effect mainnav-lg">




	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
								<div id="content-container">
									<!--Page Title-->
									<div id="page-title">
										<h1 class="page-header text-overflow">Invoice Tax Form</h1>
									</div>
									<!--End page title-->
									
									<!--Breadcrumb-->
									<ol class="breadcrumb">
										<li><a href="#">Home</a></li>
										<li><a href="#">Invoice Tax</a></li>
										<li class="active">Invoice Tax</li>
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
													<form action="insert_invoice-tax_action" method="POST">
														<div class="panel-body">
														With Detail  <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withdetail" id="yesCheck" checked > without detail <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withoutdetail" id="noCheck" ><br>
    
						 								<br><br>
														
														  <div class="row">
														  
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Invoice NO :</label>
																		<input type="text" class="form-control" placeholder=" " name="invm.ino" class="form-control" value="<%=request.getParameter("purchase_po_no")%>" readonly required>
																	</div>
														  </div>
														  
														  
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Customer Code :</label>
																		<input type="text" class="form-control" placeholder=" " name="mrm.customer_code" onkeyup="this.value=this.value.toUpperCase()" class="form-control" value="<%=request.getParameter("customer_no")%>" readonly required>
																	</div>
														  </div>
														  
														  
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Customer Name :</label>
																		<input type="text" class="form-control" placeholder=" " name="mrm.customer_name" onkeyup="this.value=this.value.toUpperCase()" class="form-control" value="<%=request.getParameter("customer_name")%>" readonly required>
																	</div>
														  </div>
														
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Supplier Id :</label>
																		<input type="text" class="form-control" placeholder=" " value="<%=request.getParameter("supplier_id")%>" name="mrm.supplier" id="supplier" onkeyup="this.value=this.value.toUpperCase()" class="form-control">
																	</div>
														  </div>	
														  
														  
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Supplier Name :</label>
																		<input type="text" class="form-control" placeholder=" " name="mrm.customer_name" onkeyup="this.value=this.value.toUpperCase()" class="form-control" value="<%=request.getParameter("supplier")%>" readonly required>
																	</div>
														  </div>
														  
														  
														  
														  
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">PO NO :</label>
																		<input type="text" class="form-control" placeholder=" " name="invm.ino" class="form-control" value="<%=request.getParameter("pono")%>" readonly required>
																	</div>
														  </div>
														 
														 
														  <div class="col-sm-6">
																	<div class="form-group">
																		<label class="control-label">Date :</label>
																		<input type="date" class="form-control" placeholder=" " id="date" name="mrm.date"  class="form-control" style="line-height: 15px;" required>
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
																					
																					<th id="VLsparename"><label>Description</label></th>
																					
																					<th id="VLsparename"><label>Quantity</label></th>
																					
																					<th id="VLsparename"><label>Rate</label></th>
																					
																					<th id="VLsparename"><label>Amount</label></th>
																					
																					<th id="VLsparename"><label>HSN Code</label></th>
																					
																					<th id="VLsparename"><label>CGST Rate</label></th>
																					
																					<th id="VLsparename"><label>CGST Amount</label></th>
																					
																					<th id="VLsparename"><label>SGST Rate</label></th>
																					
																					<th id="VLsparename"><label>SGST Amount</label></th>
																					
																					<th id="VLsparename"><label>Net Amount</label></th>
												  
												  								</tr>
																				
																				<tr id= "editdiv" >
																					<td colspan="13"  style="height:1px">
																						<div id="documentNoSpan"></div>
																					</td>
																				</tr>
																				
																				<!-- <tr class="item-row">
																					
																					<td style="width:1px;"></td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="description" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="" class="form-control"
																						id="" value=""
																						style="width: 60px;" />
																					</td>
																					
												  								 </tr> -->
																
																
																	<c:forEach items="${invoicebean123}" var="invoicebean123">
																	<tr class="item-row">
																				<td style="width:1px;"></td>
																				<td><input type="text" name="ib.description" class="form-control"
																						style="width: 100%;" value="${invoicebean123.description}" id="description" readonly/></td>
																					<td><input type="text" name="ib.quantity" class="form-control"
																						style="width: 60px;" id="quantity" value="${invoicebean123.quantity}" 
																						readonly />
																					</td>
																					<td><input type="text" name="ib.myrate" id="myrate" class="form-control"
																						 value="${invoicebean123.rate}"
																						style="width: 60px;" onblur="calculategst(this);gotoadd();"/>
																					</td>
																					
																					<td><input type="text" name="ib.amount" class="form-control"
																						id="amount" value="${invoicebean123.amount}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.hsn" class="form-control"
																						id="hsn" value="${invoicebean123.hsn}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.crate" class="form-control"
																						id="crate" value="${invoicebean123.crate}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.cgstamt" class="form-control"
																						id="cgstamt" value="${invoicebean123.cgstamt}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.srate" class="form-control"
																						id="srate" value="${invoicebean123.srate}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.sgstamt" class="form-control"
																						id="sgstamt" value="${invoicebean123.sgstamt}"
																						style="width: 60px;" />
																					</td>
																					
																					<td><input type="text" name="ib.net_amount" class="form-control"
																						id="net_amount" value="${invoicebean123.net_amount}"
																						style="width: 60px;" />
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
																	
																	<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<s:push value="invoicebean123"> 
																	<tr>
																	
																		
																		<td align="left" style="padding-left:5px;"><b>Total:</b><input name="ib.stot" class="form-control"
																			id="stot"  value="<s:property value="total"/>" readonly
																			></td>
																	
																		<td align="left" style="padding-left:5px;"><b>Freight:</b><input name="ib.freight" class="form-control"
																			id="freight"  value="" onblur="totalnetamt();"
																			></td>
																			<td align="left" style="padding-left:5px;"><b>Transport:</b><input name="ib.transport" class="form-control"
																			id="transcharge"  value=""  onblur="totalnetamt();"
																			></td>
																		<td align="left" style="padding-left:5px;"><b>Total&nbsp;Amt:</b><input name="ib.tamount" class="form-control"
																			id="tamount" readonly value=""
																			></td>
																			
																	</tr>
																	</s:push>
																	</table>
														
																</td>
															</tr>
															<tr><td>&nbsp;</td></tr>

													<tr>
														<td><table>
																<tr>
																	<td class="style2" align="center">Tax</td>
																	
																	<td class="style2" colspan="2" align="center">Tax
																		amount</td>
																</tr>
																<tr>
																	<td class="style2" align="center"><input class="form-control"
																		type="text" name="ib.t" id="t1" maxlength="8"
																		size="37" value="CGST:" readonly="readonly">
																		<input type="hidden"
																		name="ib.A" id="A1" maxlength="8" size="15"
																		readonly="readonly">
																	</td>
																	
																	
																	<td colspan="2" align="center"><input type="text" class="form-control"
																		name="ib.A2" id="A2" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>



																<tr>
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t2" maxlength="8" class="form-control"
																		size="37" value="SGST:" readonly="readonly">
																		<input type="hidden"
																		name="ib.A" id="A3" maxlength="8" size="15"
																		readonly="readonly">
																	</td>
																	
																	

																	<td colspan="2" align="center"><input type="text" class="form-control"
																		name="ib.A2" id="A4" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>
																
																<tr >
																	<td class="style2" align="center"><input 
																		type="text" name="ib.t" id="t4" maxlength="8" class="form-control"
																		size="37" value="TOTAL TAX AMOUNT:" readonly="readonly">
																		<input type="hidden"
																		name="ib.A" id="A16" maxlength="8" size="15"
																		readonly="readonly">
																	</td>
																	
																	

																	<td colspan="2" align="center"><input type="text" class="form-control"
																		name="ib.A2" id="A17" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>
																</table></td></tr>
															
															
															
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
												
												
												
												<script type="text/javascript">
								
														$(document)
																.ready(
																		function() {
												
																						$("#addRow").bind('click',addRows);
																						function addRows(e) {
																							try {
																								var $itemsTable = $('#itemsTable');
																								var $rowTemp = [
																									'<tr class="item-row">',

																									'<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
																									'<td><input type="text" name="" class="form-control" id="description" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																									'<td><input type="text" name="" class="form-control" id="" value="" style="width: 60px;" /> </td>',
																						
																						
																									
																									
																									
																									'</tr>' ]
																									.join('');
																									
																									var $row = $($rowTemp);
																									$.currentRow = $row;
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

												
											</form>
										</div>
									</div>
								</div>
							</div>
					  </div>	  
									  
									  	
											
											
											
											
											
											
											
											
											
											
					<!--Menu-->
					<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
					<!--End menu-->
				</div>
			
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
	
	<script>
	getTamtNTtxamt();
	</script>															
																
</body>
</html>	