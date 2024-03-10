<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
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

															'<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input  type="text" class="form-control" name="particulars"/></td>',
															'<td><input  type="text" class="form-control" name="expences" id="getExpenses" onblur="getnewsrno(this);ExpencesAmount()" /></td>',
															'<td><input  type="text" class="form-control" name="gstPer" id="gstPer" onblur="getnewsrno(this)" /></td>',
															'<td><input  type="text" class="form-control" name="gstAmount" id="setAmount" onblur="getGstAmount()"/></td>',
															'<td><input  type="text" class="form-control" name="total" id="total" onblur="getTotalAmount()" /></td>',
															
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
													.find('#description1');
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
					</script>
</head>
<script type="text/javascript">

function getnewsrno(v) {
	//alert("1" + v);


	var $traverse_row = $(v).parents('.item-row');//get row 
	
	var $hoardinglocation = $($traverse_row).find('#getExpenses');//get textbox 
	var $hoardinglocation2 = $($traverse_row).find('#gstPer');//get textbox 
	var $hoardinglocation3 = $($traverse_row).find('#setAmount');//get textbox which value is setted for this.
	
	var exp=$($hoardinglocation).val();//get value from textbox
	
	var gstper=$($hoardinglocation2).val();//get value from textbox

	var gstAmount=(exp*gstper)/100;
	
	$($hoardinglocation3).val(gstAmount);//for setting value to textbox
	
	
}
</script>

<script>
function ExpencesAmount() {
	var amt1 = 0;

$('.item-row').each(function(i, row) {
	var $exp = $(row).find('#getExpenses');
	
	var $exp1 = $($exp).val();
	amt1 = Math.abs(amt1) + Math.abs($exp1);
	
});
document.getElementById("totalAmountOfExp").value = Math.abs(amt1).toFixed(2);
}
</script>

<script>
function getGstAmount() {
	var amt1 = 0;

	$('.item-row').each(function(i, row) {
		var $exp = $(row).find('#setAmount');
		
		var $exp1 = $($exp).val();
		amt1 = Math.abs(amt1) + Math.abs($exp1);
		
	});
	if(amt1=='NaN')
		{
		document.getElementById("totalAmt").value ="";
		}else
			{
			document.getElementById("totalAmt").value = Math.abs(amt1).toFixed(2);
			}
	
}
</script>

<script>
function getTotalAmount() {
	var amt1 = 0;

	$('.item-row').each(function(i, row) {
		var $exp = $(row).find('#total');
		
		var $exp1 = $($exp).val();
		amt1 = Math.abs(amt1) + Math.abs($exp1);
		
	});
	document.getElementById("FinalTotal").value = Math.abs(amt1).toFixed(2);
	
}
</script>

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
					<h1 class="page-header text-overflow">Investment & Expenses As Per Bis</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Investment & Expenses As Per Bis</li>
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
								<form action="UpdateInvestmentAndExpensesMaster" method="POST">
									<div class="panel-body">
									
									 <s:iterator value="investmentExp2">
										<div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2">Name Of Quotation  :
                                                    </label>
                                                    <input type="text" class="form-control" value="${quotation_name}" name="quotation_name" onkeyup="this.value=this.value.toUpperCase()" required> </div>
                                            </div>
										</div>
										</s:iterator>
										
										<s:iterator value="investmentExp2">
										<div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Name  :
                                                    </label>
                                                    <input type="text" name="invest_exp_id" value="${invest_exp_id}">
                                                    <input type="text" class="form-control" value="${name}" name="name" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Sub Name :
                                                    </label>
                                                    <input type="text" class="form-control" value="${subname}" name="subname" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
                                            </div>
                                  		  </div>
                                  		  
                                  		  <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Heading 1  :
                                                    </label>
                                                    <input type="text" class="form-control" value="${heading1}" name="heading1" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Heading 2 :
                                                    </label>
                                                    <input type="text" class="form-control" value="${heading2}" name="heading2" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
                                            </div>
                                  		  </div>
                                  		  
                                  		  </s:iterator>
                                        
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
                                                <div class="tab-content m-t-10">
												<table id="itemsTable$" class="table table-striped table-bordered table-responsive" cellspacing="0" width="100%">
													<tr>
														<td colspan="5">
														
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																		<th><i class="fa fa-remove" title="Remove Item"></i></th>
																		<th id="VLsparename"><label>Particulars </label></th>
																		<th id="VLsparename"><label>Expenses</label></th>
																		<th id="VLsparename"><label>GST(%) </label></th>
																		<th id="VLsparename"><label>GST Amount </label></th>
																		<th id="VLsparename"><label>Total</label></th>
																	</tr>
																	
																	<s:iterator value="investmentExp3">
																		<tr class="item-row">
																			<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																			<td><input type="text" name="particulars" value="${parti}" class="form-control"></td>	
																			<td><input type="text" name="expences"  value="${exp}" class="form-control" id="getExpenses" onblur="getnewsrno(this);ExpencesAmount()"></td>
																			<td><input type="text" name="gstPer"  value="${gstP}" class="form-control" id="gstPer" onblur="getnewsrno(this)"></td>
																			<td><input type="text" name="gstAmount" value="${gstAmt}" class="form-control" id="setAmount" onblur="getGstAmount()" ></td>
																			<td><input type="text" name="total" id="total" value="${tot}" class="form-control" onblur="getTotalAmount()"></td>
																		</tr>
																	</s:iterator>
																	
																</table>
																
																<table id="demo-dt-addrow" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																			<td align="left"><a	href="#" id="addRow" class="button-clean large">
																			<span><img id="" tabindex="13" src="configure/img/icon-plus.png" alt="Add" title="Add Row" style="margin-left: 0px" />
																			Add Item</span> </a></td>
																	</tr>
																</table>
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	
																	<tr>
																		<th id="VLsparename"><label></label></th>
																		<th id="VLsparename"><label> </label></th>
																		<th id="VLsparename"><label></label></th>
																		<th id="VLsparename"><label> </label></th>
																		<th id="VLsparename"><label> </label></th>
																		<th id="VLsparename"><label></label></th>
																	</tr>
																	
																	<s:iterator value="investmentExp2">
																	<tr>
																		<td></td>
																		<td><input type="text" name="particulars1" class="form-control" value="TOTAL" readonly></td>	
																		<td><input type="text" name="tot1" class="form-control" value="${tot1}" id="totalAmountOfExp"></td>
																		<td><input type="text" name="gstPer1" class="form-control" id="totalGstAmount" readonly></td>
																		<td><input type="text" name="tot2" class="form-control" value="${tot2}" id="totalAmt"></td>
																		<td><input type="text" name="tot3" class="form-control" value="${tot3}" id="FinalTotal"></td>
																	</tr>
																	</s:iterator>
																	
																</table>
															</td>
														</tr>
												</table>
												</div>
											</div>
                                          </div>
                                        </div>
                                        
                                        <s:iterator value="investmentExp2">
	                                        <div class="row">
	                                            <div class="col-md-6">
	                                                <div class="form-group">
	                                                    <input type="text" class="form-control" value="${heading3}" name="heading3" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
	                                            </div>
	                                            
	                                            <div class="col-md-6">
	                                                <div class="form-group">
	                                                    <input type="text" class="form-control" value="${heading4}" name="heading4" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
	                                            </div>
	                                  	     </div>
                                  	   </s:iterator>
                                        
                                        <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="button"  onclick="history.go(-1)">Back</button>
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
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
	
</body>
</html>

