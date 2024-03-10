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

<%-- <style type="text/css" title="currentStyle">
@import "Css/rptsTable/demo_page.css";

@import "Css/rptsTable/demo_table.css";

.backcolor{ 
background-color:#D6CECE;


}

#backgroundPopup {
	display: none;
	position: fixed;
	_position: absolute; /* hack for internet explorer 6*/
	height: 100%;
	width: 100%;
	top: 0;
	left: 0;
	background: #000000;
	border: 1px solid #cecece;
	z-index: 1;
}

*:focus {
	outline: 5px !important;
	border: 1px solid;
	border-color: #0b0595;
	box-shadow: 0 0 10px #0b0595;
}
</style>
 --%>
<script type="text/javascript" src="jQuery_4_design/AddRowDataTable/purchase_spare.js"></script>
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script >


$(function() {
	
	
	$("#supplier").autocomplete("GoogleSearch/Supplier_name.jsp");
 
	

}); 
	 
	</script>

</head>
<body>



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
					<h1 class="page-header text-overflow">Material Received Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Material Received</a></li>
					<li class="active">Material Received</li>
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
								<form action="insert_material_action" method="POST">
									<div class="panel-body">
									
									  <div class="row">
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">PO NO :</label>
													<input type="text" class="form-control" placeholder=" " name="mrm.pono" class="form-control" value="<%=request.getParameter("purchase_po_no")%>" readonly required>
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
													<label class="control-label">Date :</label>
													<input type="date" class="form-control" placeholder=" " id="date" name="mrm.date"  class="form-control" style="line-height: 15px;" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Supplier :</label>
													<input type="text" class="form-control" placeholder=" " name="mrm.supplier" id="supplier" onkeyup="this.value=this.value.toUpperCase()" class="form-control">
												</div>
											</div>
									  </div>
									  
									  <div id="product" style="width:49%">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%" colspan="5">

															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Delete</th>
																		<th id="VLsparename"><label>Description</label>
																		</th>
																		
																		<th id="VLsparename"><label>Quantity</label>
																		</th>
																		
																		<th id="VLsparename"><label>Received Quantity</label></th>
									  
									  								</tr>
									  								
									  								
									  								
									  								
									  								<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	<c:forEach items="${material_Received_model123}" var="purchase_Order_bean123">
																	<tr class="item-row">
																	<td style="width:1px;"></td>
																	<td><input type="text" name="mrm.description" class="form-control"
																			style="width: 100%;" value="${purchase_Order_bean123.material_code1}" id="description"
																			tabindex="10" onblur="skipqty(this);"
																			onkeypress="NewSpareServiceOpen(event,this)" /></td>
																		<td><input type="text" name="mrm.quantity" class="form-control"
																			style="width: 60px;" id="quantity" value="${purchase_Order_bean123.remain}" 
																			tabindex="11" onblur="getnewsrno(this);" readonly /></td>
																		<td><input type="text" name="mrm.receivedquantity" class="form-control"
																			id="receivedquantity" value=""
																			tabindex="12"
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
																		'<td><input style="width:250px;" type="text" class="form-control" name="mrm.description"  id="description" /></td>',
																		'<td><input style="width:60px;" type="text" class="form-control" name="mrm.quantity"  id="quantity" readonly value="0"/></td>',
																		//puc,
																		'<td><input style="width:60px;" type="text" class="form-control" name="mrm.receivedquantity"   id="receivedquantity" value="" /></td>',
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
    <%-- <jsp:include page="/common/settings.jsp"></jsp:include> --%>
    <jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
<%-- 	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
 --%></body>
</html>

