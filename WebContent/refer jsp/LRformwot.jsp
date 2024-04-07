
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.aqua.dao.DaoHelper,java.sql.* "%>
<%@taglib uri="/struts-tags" prefix="s"%>

<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">


<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
	
<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js"
	type="text/javascript"></script>

 <script src="datevalidation.js" type="text/javascript"></script>

<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>



<link rel="stylesheet" href="configure/css/main2.css">

 
	
	
	<!-- table -->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=latin" rel="stylesheet">

	<link href="configure/css/bootstrap.min.css" rel="stylesheet">

	<link href="configure/css/nifty.min.css" rel="stylesheet">

	<link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">

	<link href="configure/plugins/switchery/switchery.min.css" rel="stylesheet">

	<link href="configure/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">

	<link href="configure/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="configure/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">

	<link href="configure/css/demo/nifty-demo.min.css" rel="stylesheet">

	<link href="configure/plugins/pace/pace.min.css" rel="stylesheet">
	<script src="configure/plugins/pace/pace.min.js"></script>

    
    

<script >
function getrowdetails(v){

	if (window.XMLHttpRequest) {
		var xp1 = new XMLHttpRequest();
	} else {
		var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var $traverse_row = $(v).parents('.item-row');
		
			
			$hoardinglocationxaa = $($traverse_row).find('#model');
			$hoardinglocationxaa2 = $($traverse_row).find('#qty');
		var codetype = $($hoardinglocationxaa).val();

		var codetype=codetype.split("-"); 
		var codetype1=codetype[0];
		$hoardinglocationxaa.val(codetype[0]);
		$hoardinglocationxaa2.val(codetype[1]);
		//alert(codetype[0]);
		
		
}
function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('sympdiv').style = 'display:block';
    }
    else document.getElementById('sympdiv').style= 'display:none';
    document.getElementById("total_amt").value= '';

}
 function splitname(v)
 {
	 var name=document.getElementById("company_name").value;
	 alert(name);
	 if(name.indexOf('-')>-1)
		 {
		 alert("if");
		 var name=document.getElementById("company_name").value;
		 var s=name.split('-');
		 var s1=s[0];
		 alert(s[0]);
		 var s2=s[1];
		 document.getElementById("company_name").value=s[0];
		 document.getElementById("supplier_id").value=s[1];
		 }
 }

</script>
<%-- <section class="content">
<center>

    <br>
    <div class="container-fluid">
        <div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="card">
					<div class="header">
						<h2><strong>Purchase</strong> Form  </h2>
						<!-- <ul class="header-dropdown">
                            <li class="remove">
                                <a role="button" class="boxs-close"><i class="zmdi zmdi-close"></i></a>
                            </li>  
                        </ul> -->  
					</div> 
     --%>
<%
																		



																		String discount="no";
																		
																		
																		%>



<<!-- div class="container-fluid">
        <div class="row clearfix">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="card">
				 
					<div class="body">
					<body > -->

	<input type="hidden" name="spareorlabour" id="spareorlabour" value="">
	<input type="hidden" name="discountval" id="discountval" value="<%=discount%>">
					</head>		
	<!-- <div class="panel panel-widget forms-panel">
						<div class="forms">
							<div class=" form-grids form-grids-right">
								<div class="widget-shadow " data-example-id="basic-forms">  
									<div class="form-title">
										<h4>PURCHASE FORM W/O Tax</h4>
									</div>
									<div class="body">
									
									<form action="insert_LRformwot" id="formID2" name="formID2"
			onsubmit="return validateform();">
 -->
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
					<h1 class="page-header text-overflow">PURCHASE FORM W/O Tax</h1>
				</div>
				<!--End page title-->
				
				

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						
						
						<div class="col-lg-12">
						
							<div class="panel">
							<div class="col-lg-6"></div>
							
								
								<form action="insert_LRformwot" id="frmFileUpload"
								class="form-control" method="post" name="mainForm"
								onsubmit="return validateform();" >
								
			<br>
								With Detail  <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withdetail" id="yesCheck" checked > without detail <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withoutdetail" id="noCheck" ><br>
    
						 		<br><br>
	

				<div class="row ">
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text" class="form-control floating-input" placeholder=" "  name="prb.lrnumber" id="lrnumber"  required>
                                    <span class="highlight"></span>
      								<label>Invoice No</label>
                                </div>
                            </div>
                            
                              <div class="col-sm-6">
                                <div class="form-group floating-label">
                                   <input type="text" class="form-control floating-input" placeholder=" " name="prb.company_name" id="company_name" value="${supplier_name}" onblur="splitname(this);"  required>
                                   <span class="highlight"></span>
      								<label>Supplier Name</label>
                                </div>
                            </div>
                            
                           
                        </div>
									
								
									
									 <div class="row ">
									 
									  <div class="col-sm-6">
                                <div class="form-group floating-label">
                                   <input type="text" class="form-control floating-input" placeholder=" " readonly name="prb.supplier_id" id="supplier_id" value="${supplier_id}"   required>
                                   <span class="highlight"></span>
      								<label>Supplier Id</label>
                                </div>
                            </div>
                            
									
									<div class="col-sm-6">
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.to_date" onblur="FixShortDate(this);return ValidateForm(this);"
										id="to_date" 
												
												 required> <span class="highlight"></span>
											<label>Date</label>
										</div>
									
									</div>
									 <input type="text" class="form-control floating-input" placeholder=" " readonly name="prb.pono" id="pono" value="${pono}" >
									
									</div>

				<div class="tab-content m-t-10" >
             
             <div class="tab-pane table-responsive active" id="sympdiv"  style="display:block"   >
            
              <div class="col-sm-2"></div>
             <div class="col-sm-12"  >
                         <div class="col-sm-12">
                      <div class="form-group"> 
			
				<table id="itemsTable" class="table table-bordered"> 
						
			
			<tbody>
				<tr >
					
						
											<th style="">Del</th>
											<!-- <th id="VLsparename"><label>Material Type</label></th> -->
											<!-- <th id="VLsparename"><label>Sr No</label>
											</th> -->
											<th id="VLsparename" ><label>Description of Goods</label>
											</th>
											<th id="VLsparename" ><label>Rate</label>
											<th id="VLsparename"><label>Quantity</label>
											<th id="VLsparename"><label>Amount</label>
											<% if(discount.equals("yes")) {%>
											<th id="VLsparename"><label>Disc(%)</label></th>
											<th id="VLsparename"><label>Tot Amt</label></th>
																		<%  }%>
											<!-- <th id="VLsparename"><label>HSN</label>
											<th id="VLsparename"><label>Tax Percent</label>
											<th id="VLsparename"><label>cgstrate</label>
											<th id="VLsparename"><label>cgstamount</label>
											<th id="VLsparename"><label>sgstrate</label>
											<th id="VLsparename"><label>sgstamount</label> -->
											
											<th id="VLsparename"><label>Unit</label>
											<!-- <th id="VLsparename"><label>Net Amount</label> -->
											 
											</th>
										</tr>
									</tbody>


									<tbody>
									<s:iterator value="po_details_products1">
										<tr class="item-row">
										<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
											

											<td><input style="width:190px" name="prb.unit_no" class="form-control" value="<s:property value="disc1"/>"  maxlength="20" size="30" id="model" required onblur="getgst();checkstockqty(this);duplicate(this);getrowdetails(this);"></td>
											<td><input style="width:80px"  name="prb.price" class="form-control" value="<s:property value="price1"/>" id="price" onblur="sparenetamt11(this);allnumeric(this);" required maxlength="6"></td>		
											<td><input  style="width:80px"  name="prb.qty"  class="form-control" id="qty"  value="<s:property value="qty2"/>" onblur="sparenetamt11(this);allnumeric(this);" required maxlength="6"></td>
											<td><input  style="width:80px"  name="prb.amount"  class="form-control" value="<s:property value="amount1"/>" onblur="netamt();twodecimal(this);gotoadd()" readonly
												id="amount" required maxlength="6"></td>
												<% if(discount.equals("yes")) {%>
													<td><input type="hidden" name="prb.disc"
																			id="disc" value="" 
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 80px;" />
																		</td>
																		<td><input type="hidden" name="prb.amtwithdisc" readonly
																			id="amtwithdisc" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		</td>
																		<input type="hidden" name="prb.discamt"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		
												
												<%  }else{%>
													<input type="hidden" name="prb.disc"
																			id="disc" value="" 
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 80px;" />
																			<input type="hidden" name="prb.amtwithdisc"
																			id="amtwithdisc" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																	
																		<input type="hidden" name="prb.discamt"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		
												
												<% } %>
											<!-- <td><input style="width:80px"  required name="prb.hsn" maxlength="20" size="30" id="hsn" readonly></td>
											<td><input style="width:60px" required  name="prb.tax_percent" id="tax"  maxlength="6" readonly></td>		
											<td><input  style="width:60px" required name="prb.gstrate1" id="gstrate1" readonly onblur="netamt();"  maxlength="6"></td>	
												
											<td><input  style="width:80px" required name="prb.gstamount1" maxlength="20" readonly size="30" id="gstamount1" ></td>
											<td><input style="width:60px" required  name="prb.gstrate2" id="gstrate2"  readonly maxlength="6"></td>		
											<td><input style="width:80px" required  name="prb.gstamount2" id="gstamount2" readonly maxlength="6"></td>	
												 -->
										<td><Select name="prb.unitno" id="unit_no" >
										<option value="NOS">NOS</option>
										<option value="KG">KG</option>
										<option value="PCS">PCS</option>
										<option value="MTRS">MTRS</option>
										
										
										</Select>
										<input type="hidden" name="prb.currentqty"
												id="currentqty" value="" readonly>
											
										</td>
										
										<!-- <td><input  style="width:80px" required  name="prb.net" id="net" readonly maxlength="6"></td>
											 -->
											
										</tr>
</s:iterator>
									</tbody>
								</table>
								<table style="width: 550px;">

									<tr>
										<td align="left"><a href="#" id="addRow"
											class="button-clean large"><span> <img 
													src="Images_4_design/AddRowDataTable/icon-plus.png"
													alt="Add" title="Add Row" style="margin-left: 0px" /> Add
													Item</span> </a>
										</td>
									</tr>
								</table>

							</div></div>
				
				</div></div></div>
				<br>
				
					

					<div class="row">
											
				
				<div class="col-sm-6">
												
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.total_amt" id="total_amt" required onblur="f22(this);allnumeric(this);twodecimal(this)" 
												
												> <span class="highlight"></span>
											<label>Total</label>
										</div>
									</div>
									
									
									<div class="col-sm-6">
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.labour" id="labour" value="0" onblur="netamt();allnumeric(this);" 
												
												> <span class="highlight"></span>
											<label>Labour</label>
										</div>
									</div>
									<input type="hidden" name="prb.discount" value="0"
											id="discount" onblur="netamt();" maxlength="6" size="30"
											onblur="allnumeric(this);twodecimal(this)" />
									</div>
									
									
									<div class="row">
											
				
									<div class="col-sm-6">
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.transport" id="transport" value="0" onblur="netamt();allnumeric(this);" 
 
												
												> <span class="highlight"></span>
											<label>Transportation</label>
										</div>
									</div>
									
									<div class="col-sm-6">
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.other" id="other" value="0" onblur="netamt();allnumeric(this);" 
												
												> <span class="highlight"></span>
											<label>Other</label>
										</div>
									</div></div> 
									
									<div class="row">
											
				
									<div class="col-sm-6">
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.net_amount" id="net_amount" readonly
 
												
												> <span class="highlight"></span>
											<label>Net Amount</label>
										</div>
									</div></div>
									
									
									
							<%-- 	<tr style="visibility:hidden">
									<td colspan=1 ALIGN="left"><b>PaymentMode :</b>
									</td>
									<td><select name="prb.paymod" id="paymod" 
										onchange="display(this);">
											<option value="">--------SELECT--------</option>
											<option value="1">Cash:</option>

											<option value="3">Cheque:</option>
											<option value="4">Part Payment:</option>

									</select>
									</td>

								</tr> --%>
								<tr>
									<td colspan="4" align="center" >
										<!-- AddRowDataTable -->

										<div style="width: 100%; height: auto; border: 1px;" id="tab">
											<table id="itemsTableSpare" cellpadding="5" style="padding:0" >

												<tbody id="1" style="display: none;">
													


												</tbody>
												<tbody id="8" style="display: none;">
													<tr>
														<td align="left" class="style2">Cash Amount :</td>
														<td align="left" colspan="2"><input type="text"
															name="prb.cash_amt" id="cash_amt" maxlength=8 id="p2"
															size="15"></td>
													</tr>
												</tbody>
												<tbody id="2" style="display: none;">
													<tr>
														<td class="style2" align="left">Bank Name :</td>
														<td align="center" colspan="2"><input type="text"
															name="prb.bankname" id="bankname" maxlength=30 size="15">
														</td>
													</tr>
												</tbody>
												<tbody id="3" style="display: none;">
													<tr>
														<td class="style2" align="left">Cheque No :</td>
														<td class="style2" align="left">Cheque Amount :</td>
														<td class="style2" align="left">Cheque Date :</td>
													</tr>
												</tbody>
												<tbody id="4" style="display: none;">
													<tr>
														<td align="left"><input type="text"
															name="prb.cheque_no" id="p4" maxlength=10 size="10"
															onkeypress="isNumber(event);"
															Class="validate[custom[integer]]">
														</td>
														<td align="left"><input type="text"
															name="prb.cheque_amt" size="10" maxlength=7 id="p5"
															onkeypress="isNumber(event);" onblur="allnumeric(this);">
														</td>
														<td align="left"><input name="prb.cheque_date"
															value="" maxlength="20" id="p6"
															onblur="FixShortDate(this);return ValidateForm(this);"
															size="10">
													</tr>

												</tbody>
												<tbody id="5" style="display: none;">
													<tr>
														<td align="left"><input type="text" name="chkno2"
															id="p7" maxlength=10 size="15"
															onkeypress="isNumber(event);"></td>
														<td align="left"><input type="text" name="amt2"
															size="15" maxlength=8 id="p8"
															onkeypress="isNumber(event);"></td>
														<td align="left"><input name="chkdate2" value=""
															maxlength="20" id="p9" size="10"><a
															href="javascript:void(0)"
															onclick="if(self.gfPop)gfPop.fPopCalendar(document.invoice.chkdate2) return false;"><img
																class="PopcalTrigger" align="middle"
																src="HelloWorld/calbtn.gif" width="34" height="22"
																border="0" alt=""> </a>
													</tr>
												</tbody>
												<tbody id="6" style="display: none;">
													<tr>
														<td align="left"><input type="text" name="chkno3"
															"size="15" onkeypress="isNumber(event);">
														</td>
														<td align="left"><input type="text" name="amt3"
															maxlength=8 size="15" onkeypress="isNumber(event);">
														</td>
														<td align="left"><input name="chkdate3" value=""
															maxlength="20" readonly size="10"><a
															href="javascript:void(0)"
															onclick="if(self.gfPop)gfPop.fPopCalendar(document.invoice.chkdate3) return false;"><img
																class="PopcalTrigger" align="middle"
																src="HelloWorld/calbtn.gif" width="34" height="22"
																border="0" alt=""> </a>
													</tr>
												</tbody>

												<tbody id="7" style="display: none;">
													<tr>
														<td class="style2" align="left">Paid Amount :</td>
														<td align="left" colspan="2"><input type="text"
															name="prb.paid_amt" id="paid_amt" maxlength=7 size="15"
															onblur="netamt();">
														</td>
													</tr>
													<tr>
														<td align="left" class="style2">Balance Amount :</td>
														<td align="left" colspan="2"><input type="text"
															name="prb.balance_amt" id="balance_amt" maxlength=7
															size="15" readonly >
														</td>
													</tr>
												</tbody>



											</table>

										</div></td>
								</tr>
							</table></td>
					</tr>
					</table>

				</fieldset>
				
				<br>

				<div class="row">
											<div class="col-sm-4 ">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
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
					
					<!--End menu-->
				</div>
			</nav>
			<!--END MAIN NAVIGATION-->
		</div>
		<jsp:include page="/PO/poleftsidebar.jsp"></jsp:include>
		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->
	</div>
	<!-- END OF CONTAINER -->
	
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
<!--JAVASCRIPT-->
	<%-- <script src="configure/js/jquery-2.1.1.min.js"></script> --%>
	<script src="configure/js/bootstrap.min.js"></script>
	<script src="configure/plugins/fast-click/fastclick.min.js"></script>
	<script src="configure/js/nifty.min.js"></script>
	<script src="configure/plugins/morris-js/morris.min.js"></script>
	<script src="configure/plugins/morris-js/raphael-js/raphael.min.js"></script>
	<script src="configure/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="configure/plugins/skycons/skycons.min.js"></script>
	<script src="configure/plugins/switchery/switchery.min.js"></script>
	<script src="configure/plugins/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="configure/js/demo/nifty-demo.min.js"></script>
	<script src="configure/js/demo/dashboard.js"></script>


<script type="text/javascript">

$(function() {
	
	$("#company_name").autocomplete("GoogleSearch/company_name_master_auto_search.jsp"); 
	$("#model").autocomplete("GoogleSearch/PO/disc_auto_search.jsp");
	 
	
});

 var k=1;
 $(document).ready(function(){
	// alert(">>>>");

     $("#addRow").bind('click', addRows);
function addRows(e){
	
	
//alert(">>>>");
               try{
               
               	k++;
                         var $itemsTable = $('#itemsTable');  
                         var $row = $($rowTemp);
                         
                         
                         var disc=document.getElementById("discountval").value;
							if(disc=="yes"){
								myflag='<td><input type="text" name="prb.disc"		id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 80px;" />		</td>';
								myflag2='<td><input type="text" name="prb.amtwithdisc"		id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 80px;" />		</td>';
									myflag1='<input type="hidden" name="prb.discamt"	id="discamt" value="" 	 		style="width: 80px;twodecimal(this)" />';
							}else{
								myflag='<input type="hidden" name="prb.disc"		id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 80px;" />		';
								myflag2='<input type="hidden" name="prb.amtwithdisc"		id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 80px;" />		</td>';
								myflag1='<input type="hidden" name="prb.discamt"	id="discamt" value="" 	 		style="width: 80px;twodecimal(this)" />';
							}
                         
                         //alert(k);
                         var $rowTemp = [
                         '<tr class="item-row">',
                         '<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                         /* '<td>'+k+'</td>', */
                      '<td><input  style="width:190px" type="text" class="form-control" name="prb.unit_no"  size="30"  id="model"  maxlegth="251"  Class="validate[required]" onblur="checkstockqty(this);duplicate(this);getrowdetails(this);"/></td>',
                       '<td><input   class="form-control"  style="width:80px" type="text" name="prb.price" id="price"  maxlegth="6" onblur="twodecimal(this);sparenetamt11(this);"  Class="validate[required]" /></td>',
                        '<td><input  class="form-control"  style="width:80px" type="text" name="prb.qty" onblur="sparenetamt11(this);"  onblur="allnumeric(this);" Class="validate[required]" maxlegth="6" id="qty"/></td>',
                        '<td><input class="form-control"  style="width:80px"  type="text" name="prb.amount" Class="validate[required]" id="amount" onblur="netamt();twodecimal(this);gotoadd();" readonly maxlegth="6"/></td>',

                        myflag,
                        myflag2,
                        myflag1,
                        /* '<td><input  style="width:80px"  name="prb.hsn" maxlength="20" size="30" id="hsn" readonly"></td>',
						'<td><input  style="width:60px"  name="prb.tax_percent" id="tax" readonly maxlength="6"></td>',		
						'<td><input   style="width:60px"  name="prb.gstrate1" id="gstrate1"  readonly maxlength="6"></td>'	,
							
						'<td><input   style="width:80px" name="prb.gstamount1" maxlength="20" readonly size="30" id="gstamount1" ></td>',
						'<td><input   style="width:60px" name="prb.gstrate2" id="gstrate2" readonly  maxlength="6"></td>',		
						'<td><input   style="width:80px"  name="prb.gstamount2" id="gstamount2" readonly  maxlength="6"></td>',	
                         */
                        '<td><Select  name="prb.unitno" id="unit_no" ><option value="NOS">NOS</option><option value="KG">KG</option><option value="PCS">PCS</option><option value="MTRS">MTRS</option></Select><input   style="width:80px" type="hidden" name="prb.currentqty" id="currentqty" readonly  maxlegth="6"/></td>',
                        /* '<td><input   style="width:80px" name="prb.net" id="net" maxlength="6" readonly></td>', */
                                               
                                '</tr>'
                         ].join('');
                         var $row = $($rowTemp);
                         $.currentRow = $row;    
                         var $pcode= $row.find('#model');
                         $($pcode).autocomplete("GoogleSearch/PO/disc_auto_search.jsp");
                 		
                         
                         $last = $('#itemsTable').find('tbody tr:last');
                         $.first = $last.find('input:first');
                         if (true ) {                       	                                                   	          
                    	$('.item-row:last', $itemsTable).after($row);                    	                     
                         }// End if last ItemName input is empty
                         else
                  		 {
                  		 $('.item-row:last', $itemsTable).after($row);                  		                    	      
                  		 }
                         $last = $('#itemsTable').find('tbody tr:last');
                         $.first = $last.find('input:first');
                         $($pcode).focus();
               }catch(err){
                         alert(err);
               }
               return false;
     }

}); // End DOM

//Remove row when clicked
$("#deleteRow").live('click',function(){
	
     $(this).parents('.item-row').remove();
     // Hide delete Icon if we only have one row in the list.
     
     k--;
     if ($(".item-row").length < 2) $("#deleteRow").hide();
});


$(document).ready(function(){
    $("#addRowSpare").bind('click', addRows);
function addRows(e){
              try{
              	
                        var $itemsTable = $('#itemsTableSpare');
                        var $rowTemp = [
                        '<tr class="item-row1">',
                      
                        '<td><a id="deleteRow1"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                        
                      
                       
                       '<td><input type="text" name="prb.product_code" id="product_code" /></td>', 
                       
                       '<td><Select name="prb.unitno" id="unit_no" ><option value="NOS">NOS</option><option value="PCS">PCS</option><option value="MTRS">MTRS</option></Select></td>', 
                     
                       '<td><input type="text" name="prb.price2" onblur="allnumeric(this);" onblur="netamt();" id="price2" maxlength="4" /></td>', 

                       
                       
                        '</tr>'
                        ].join('');
                        var $row = $($rowTemp);
                        $.currentRow = $row;
                       
                        var $row = $($rowTemp);
                        $.currentRow = $row;    
                        var $pcode= $row.find('#model');
                        $($pcode).autocomplete("GoogleSearch/model_auto_search_pc.jsp");
                        $last = $('#itemsTable').find('tbody tr:last');
                        $.first = $last.find('input:first');
                        if (true ) {                       	                                                   	          
                   	$('.item-row1:last', $itemsTable).after($row);                    	                     
                        }// End if last ItemName input is empty
                        else
                 		 {
                 		 $('.item-row1:last', $itemsTable).after($row);                  		                    	      
                 		 }
                        $last = $('#itemsTable').find('tbody tr:last');
                        $.first = $last.find('input:first');
                        $($pcode).focus();
              }catch(err){
                        alert(err);
              }
              return false;
    }


//    $('#ItemName').focus(function(){
//              window.onbeforeunload = function(){
//                        return "You haven't saved your data.  Are you sure you want to leave this page without saving first?";
//              };
//    });

}); // End DOM

//Remove row when clicked
$("#deleteRow1").live('click',function(){
    $(this).parents('.item-row1').remove();
    // Hide delete Icon if we only have one row in the list.
    if ($(".item-row1").length < 2) $("#deleteRow1").hide();
});

function getnewsrno1xxx(v) {
	
	var	amt = 0;
	var $traverse_row = $(v).parents('.item-row');
	
	$discrate = $($traverse_row).find('#disc');
	
	if($discrate.val()!="0" && $discrate.val()!=""){
		
		$discamt = $($traverse_row).find('#discamt');
		$amt1 = $($traverse_row).find('#amount');
		$amtwithdisc = $($traverse_row).find('#amtwithdisc');
		
		
		$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
		
		$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
	
	$discamt.val( $discamt1 );
	
	$amtwithdisc.val(   Math.abs($amt1.val())  -$discamt1   );
	
	sparenetamt11(v);
	
	}

	}


 </script>
 
 <script>
 function gotoadd(){
		
		
		$("#addRow").focus();
	
	
	}
 </script>
 
<script type="text/javascript">




function display(obj) {
	//alert("fewfw");
	txt = obj.options[obj.selectedIndex].value;
	$("#1").hide();
	$("#2").hide();
	$("#3").hide();
	$("#4").hide();
	$("#5").hide();
	$("#6").hide();
	$("#7").hide();
	$("#8").hide();
	$("#tab").hide();
	document.getElementById("paid_amt").required = false;
	document.getElementById("p4").required = false;
	document.getElementById("p5").required = false;
	document.getElementById("p6").required = false;
	document.getElementById("bankname").required = false;
	if (txt == 1) {
		/* document.getElementById(1).style.display = 'block'; */
		$("#1").show(1000);
		/* $("#7").show(1000); */
		$("#tab").show(1000);
		;
	}
	if (txt == 2) {
		$("#1").show(1000);
		$("#2").show(1000);
		$("#3").show(1000);
		$("#4").show(1000);
		$("#5").show(1000);
		$("#6").show(1000);
		$("#tab").show(1000);
	}
	if (txt == 3) {
		$("#1").show(1000);
		$("#2").show(1000);
		$("#3").show(1000);
		$("#4").show(1000);
		$("#7").show(1000);
		$("#tab").show(1000);
		document.getElementById("paid_amt").required = true;
		document.getElementById("p4").required = true;
		document.getElementById("p5").required = true;
		document.getElementById("p6").required = true;
		document.getElementById("bankname").required = true;
	}
	if (txt == 4) {
		$("#1").show(1000);
		$("#7").show(1000);	
		$("#tab").show(1000);
		
		document.getElementById("paid_amt").required = true;
		
		
	}
	if (txt == 5) {
		$("#1").show(1000);
		$("#2").show(1000);
		$("#3").show(1000);
		$("#4").show(1000);
		$("#7").show(1000);
		$("#8").show(1000);
		$("#tab").show(1000);
	}
}

function netamt() {
	
	var total=0;
	
	total=Math.abs(document.getElementById("total_amt").value);
	
	if(document.getElementById("discount").value!=""){
		
	total = total  - Math.abs(document.getElementById("discount").value);
	document.getElementById("net_amount").value =total ;
	
	}
		
	if(document.getElementById("labour").value!=""){
		total = total  + Math.abs(document.getElementById("labour").value);
		document.getElementById("net_amount").value =total ;		
		}
	
	if(document.getElementById("transport").value!=""){
		total = total  + Math.abs(document.getElementById("transport").value);
		document.getElementById("net_amount").value =total ;		
		}
	
	if(document.getElementById("other").value!=""){
		total = total  + Math.abs(document.getElementById("other").value);
		document.getElementById("net_amount").value =total ;		
		}
	
	
	
		
	/* if(document.getElementById("discount").value!="" && document.getElementById("labour").value!=""){
		document.getElementById("net_amount").value =  Math.abs(document.getElementById("total_amt").value) - Math.abs(document.getElementById("discount").value) +  Math.abs(document.getElementById("labour").value  );
		
		}
	
	if(document.getElementById("discount").value!="" && document.getElementById("labour").value!="" && document.getElementById("transport").value!=""){
		document.getElementById("net_amount").value =  Math.abs(document.getElementById("total_amt").value) - Math.abs(document.getElementById("discount").value) + ( Math.abs(document.getElementById("labour").value)  +  Math.abs(document.getElementById("transport").value ) );
		
		}
	
	
	if(document.getElementById("discount").value!="" && document.getElementById("labour").value!="" && document.getElementById("transport").value!=""  && document.getElementById("other").value!=""  ){
		document.getElementById("net_amount").value =  Math.abs(document.getElementById("total_amt").value) - Math.abs(document.getElementById("discount").value) + ( Math.abs(document.getElementById("labour").value)  +  Math.abs(document.getElementById("transport").value)  +  Math.abs(document.getElementById("other").value) );
		
		}

	if(document.getElementById("paid_amt").value!="" ){
		document.getElementById("balance_amt").value =  Math.abs(document.getElementById("net_amount").value) - Math.abs(document.getElementById("paid_amt").value)  ;
		
		} */

}


function f9()
{
	alert("f9()");
	 if((document.getElementById("").value).length!=0)
	  {
		         var x= /^[0-9]+$/;
				var y=document.getElementById("qty").value;
				if(!y.match(x))
					{
					document.getElementById("qty").value='';
					alert("Only digit is allowed for qty number")
					document.getElementById("qty").value='';
					document.getElementById("qty").focus();
					 return false;
					} 
			    
	  }
}

function allnumeric(a)  
{   
//alert(">>>>");
	var ths = $(a).val();
	
	 if(ths.length!=0)
	  {
var numbers = /^[+]?([0-9]+(?:[\.][0-9]*)?|\.[0-9]+)$/;
if(ths.match(numbers))  
{  
return true;  
}  
else  
{  
	
alert('Must have numeric characters only');  
$(a).focus(); 
$(a).val('');
return false;  
}  

	  }
}


function chkDigits(obj)
{
	
   if (isNaN(document.getElementById(obj).value)==true)
   {
    alert("Please enter digits");
    document.getElementById(obj).focus();
    document.getElementById(obj).select();
    return false;
  }
}
function check_unit(string)
{
	var status;
	
  // var string=document.getElementById("unit_no").value;
  
		var str = $(string).val(); 
		
	var comp;
	if(window.XMLHttpRequest)
	{
		comp=new XMLHttpRequest(); 
	}
	else
	{
		comp=new ActiveXobject("Microsoft.XMLHTTP");
	}
	document.getElementById("comname").innerHTML="<br><img src='img/loading_bar.gif' height='20' width='25'></br>";
	comp.open("POST","ajax/check_unitno.jsp?unit_no="+str,true);
	comp.send();
	comp.onreadystatechange=function()
	{
	  	if(comp.readyState==4 && comp.status==200)
		{
			var x=comp.responseText;
			
			if(x.trim()!="")
				{
				var $traverse_row1 = $(string).parents('.item-row');
				

				$($traverse_row1).find('#unit_no').val("");
				document.getElementById("comname").innerHTML="Already Exist";
			
					document.getElementById("unit_no").focus();
					
					status=comp.responseText;
					//alert("haa"+status);
					
					return false;
						   
				}else
					{
					document.getElementById("comname").innerHTML="";
					}
		}
	}
   
	return true;
		  
}
function check_spareCode(string)
{
	var status;
	
  // var string=document.getElementById("unit_no").value;
  
		var str = $(string).val(); 
		
      
		  
	var comp;
	if(window.XMLHttpRequest)
	{
		comp=new XMLHttpRequest(); 
	}
	else
	{
		comp=new ActiveXobject("Microsoft.XMLHTTP");
	}
	document.getElementById("comname").innerHTML="<br><img src='img/loading_bar.gif' height='20' width='25'></br>";
	comp.open("POST","ajax/check_unitno.jsp?unit_no="+str,true);
	comp.send();
	comp.onreadystatechange=function()
	{
		if(comp.readyState==4 && comp.status==200)
		{
			var x=comp.responseText;
		
			if(x.trim()!="")
				{
				var $traverse_row1 = $(string).parents('.item-row');
				

				$($traverse_row1).find('#spare_name').val("");
				document.getElementById("comname").innerHTML="Already Exist";
			
					document.getElementById("spare_name").focus();
					
					status=comp.responseText;
					//alert("haa"+status);
					
					return false;
						   
				}else
					{
					document.getElementById("comname").innerHTML="";
					}
		}
	}
   
	return true;
		  
}
			
		function duplicate(a)
    { 
      // alert("<<<<<<<");
			var ths = $(a).val();
			var t = 0;
			 $('.item-row').each(function(i,row){
				 
				 var $vid = $(row).find('#model');
				 
				 if($($vid).val()==ths && ths!="")
		 		{
		 		t=t+1;
		 		}
			 });
			
			 if(t>1){
				 alert("Please don't Repeat unit code");
				 $(a).val('');
					
			 }
    		 
    }
</script>

<script type="text/javascript">
	$(function() {        
		$("#purchase_order").validationEngine();
		$("#to_date" ).datepicker({
			dateFormat: "dd-mm-yy"			
		});
	});

	
</script>


<%-- <script type="text/javascript">
function gettaxpercent(v){
	if (window.XMLHttpRequest) {
		var xp1 = new XMLHttpRequest();
	} else {
		var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var taxtype = $(v).val();
	
		
	xp1.open("POST", "gettaxpercent?taxtype="+taxtype+" ");

	xp1.send();

	xp1.onreadystatechange = function() {

		if (xp1.readyState == 4 && xp1.status == 200) {
			var rep = xp1.responseText;
			
			document.getElementById("tax").value=rep;
		}

	};
	
}	

function gettaxpercent_tax2(v){
	if (window.XMLHttpRequest) {
		var xp1 = new XMLHttpRequest();
	} else {
		var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var taxtype = $(v).val();
	
		
	xp1.open("POST", "gettaxpercent?taxtype="+taxtype+" ");

	xp1.send();

	xp1.onreadystatechange = function() {

		if (xp1.readyState == 4 && xp1.status == 200) {
			var rep = xp1.responseText;
			
			document.getElementById("tax1").value=rep;
		}

	};
	
}	


    function toggle_visibility(spare) {
       var e = document.getElementById(spare);
       if(e.style.display == 'block')
          e.style.display = 'none';
       else
          e.style.display = 'block';
    }
   
</script> --%>
<script type="text/javascript">
function toggle(obj) {

		var el = document.getElementById(obj);
	if ( el.style.display != 'none' ) {

		el.style.display = 'none';

	}

	else {

		el.style.display = '';

	}

}
</script>



<script type="text/javascript">


function func1() {
	var el1 = document.getElementById('spare');
	el1.style.display != 'none'

	}
	
window.onload=func1;

</script>

<script type="text/javascript">
function validateform(){
	/* if(document.getElementById("company_name").value==""){
		
		alert("Please Enter Valid Company name");
		return false;
		
	}else if(document.getElementById("model").value==""  ){
		alert("Please Enter Valid Spare");
		return false;
	}else{
		return true;
	} */
	
	
	
}

function checkstockqty(a){
	
	 if (window.XMLHttpRequest) {
			var xp1=new XMLHttpRequest();
		}
		else {
			var xp1=new ActiveXObject("Microsoft.XMLHTTP");
		}
	 var ths = $(a).val();
	// alert(ths);
	 ths = ths.replace(/\+/g, '%2B');
	 ths = ths.replace(/\&/g, '%26');
	 
	 //alert(ths);
	xp1.open("POST","checkstockqty_LRForm?model="+ths);

	
 xp1.send();


xp1.onreadystatechange=function() {


	if (xp1.readyState==4 && xp1.status==200) {
var rep=xp1.responseText;
//alert(xp1.responseText);
var parts=rep.split("~");

//alert(">>>>");
var $traverse_row = $(a).parents('.item-row');
	var $hoardinglocation= $($traverse_row).find('#price');
	$($hoardinglocation).val(parts[1]);
	var $hoardinglocation1= $($traverse_row).find('#currentqty');
	$($hoardinglocation1).val(parts[0]);
	
		//document.getElementById("price").value=parts[1];
		///document.getElementById("currentqty").value=parts[0];
		
		}


	  }
	
	
}


        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        function IsNumeric(e) {
            var keyCode = e.which ? e.which : e.keyCode
            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            document.getElementById("error").style.display = ret ? "none" : "inline";
            return ret;
        }
        
        function twodecimal(a){
        	
        	 var ths = $(a).val();
        	if(ths!=""){
        	var n = parseFloat(ths).toFixed(2);
        	 $(a).val(n);
        }
        }
        
        
        
    </script>
    
    
    <%--  <script>
function getgst(){
		
	$('.item-row').each(function(i,row)
	{ 
	
	if (window.XMLHttpRequest) {
		var xp1=new XMLHttpRequest();
	}
	else {
		var xp1=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var $s=$(row).find('#model');
	
	var model_code=$($s).val();
	
	
	
	model_code=model_code.replace(/\%/g, "%25") ;
	 model_code = model_code.replace(/\&/g, '%26');
	 model_code = model_code.replace(/\&/g, '%26');
	 
	 model_code=model_code.replace(/\:/g, "%3A") ;
	 
	 model_code = model_code.replace(/\+/g, '%2B');
	 model_code = model_code.replace(/\+/g, '%2B');
	 
	// model_code=model_code.replace(/\%/g, "%25") ;
	 
	 model_code=model_code.replace(/\@/g, "%40") ;
	 model_code=model_code.replace(/["']/g, "") ;
	
	 
	//alert("Model:"+model_code);
	xp1.open("POST","gettaxpercentxxx?model="+model_code);
	
	xp1.send();

	xp1.onreadystatechange=function() {


	if (xp1.readyState==4 && xp1.status==200) {
	var rep=xp1.responseText;
	
	var detail=rep.split("~");

	
	var cc=detail[2];

	var dd=detail[1];
	var ee=detail[0];


	var $s12=$(row).find('#hsn');
	var $s123=$(row).find('#tax');
	var $e123=$(row).find('#price');
	
	$($s12).val(cc);
	$($s123).val(dd);
	//$($e123).val(ee);

	//var s3=$($s12).val();
	
	
	
	}
	}	 }); 
}
	</script>  --%>
    
    <script>
    
    function sparenetamt11(v) {
    	
    	if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		

		amt = 0;grate=0;gstamount=0;net2=0;

		//$('.item-row').each(function(i, row) {
			var row = $(v).parents('.item-row');
			var $traverse_row = $(v).parents('.item-row');
			var $hoardinglocation = $($traverse_row).find('#model');
			var $hoardinglocation1 = $($traverse_row).find('#qty');
			
			if($($hoardinglocation).val()!="" &&  $($hoardinglocation1).val()!="" ){
				
				
				var Spare_name=$($hoardinglocation).val();
				Spare_name=Spare_name.replace(/\%/g, "%25") ;
				 Spare_name = Spare_name.replace(/\&/g, '%26');
				 Spare_name = Spare_name.replace(/\&/g, '%26');
				 
				 Spare_name=Spare_name.replace(/\:/g, "%3A") ;
				 
				 Spare_name = Spare_name.replace(/\+/g, '%2B');
				 Spare_name = Spare_name.replace(/\+/g, '%2B');
				 
				// Spare_name=Spare_name.replace(/\%/g, "%25") ;
				 
				 Spare_name=Spare_name.replace(/\@/g, "%40") ;	
				
			
			xp1.open("POST", "getpmsamount1?description="
					+ Spare_name + "&qty="
					+ $($hoardinglocation1).val() + "&btype=parts");

		
			xp1.send();

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//alert(rep);
					var parts = new Array();
					
					parts = rep.split("^");

					var rate1 = parts[0];
					

					var tax1 = parts[1];
					var ttype = parts[2];
					
					var $qty = $(row).find('#qty');
					var r = $($qty).val();

					var $price = $(row).find('#price');
					var r1 = $($price).val();

					amt1 = Math.abs(r) * Math.abs(r1);

					var $price1 = $(row).find('#amount');
					$($price1).val(amt1);
					
					var st=$($price1).val();
					
					
					
					/* $discrate = $(row).find('#disc');
					
					if($discrate.val()!="0" && $discrate.val()!=""){
						
						$discamt = $($traverse_row).find('#discamt');
						$amt1 = $($traverse_row).find('#amount');
						
						$amtwithdisc = $($traverse_row).find('#amtwithdisc');
						
						$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
						
						$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
					
					$discamt.val( $discamt1 );
					
					$amtwithdisc.val( Math.abs($amt1.val()) -  $discamt1 );
					
					amt = amt + amt1 - $discamt1;
					
					}else{
						
						amt = amt + amt1  ;
					} */
					
					
					
					
					//alert(amt1);
					
					//alert(st);
					
					/* var $hsn = $(row).find('#hsn');
					 $($hsn).val(ttype);
					
					
					var $tax = $(row).find('#tax');
					 $($tax).val(tax1);
					
					
					
					
					 grate=parseFloat(tax1)/2;
					
					 gstamount =(amt * grate)/100 ;
					
						
					var $grate1 = $(row).find('#gstrate1');
					var $grate2 = $(row).find('#gstrate2');
					var $gamt1 = $(row).find('#gstamount1');
					var $gamt2 = $(row).find('#gstamount2');
					
					
					$($grate1).val(grate);
					$($grate2).val(grate);
					
					$($gamt1).val(gstamount);
					$($gamt2).val(gstamount);
					
				
					 var $net1 = $(row).find('#net');
					var net=Math.abs(gstamount)+Math.abs(gstamount)+Math.abs(amt);
					
					//alert("Net:"+net);
					$($net1).val(net); 
					 var $net1 = $(row).find('#net')
					net2=net2+net;
 */
 
 //alert(amt1);
				document.getElementById("total_amt").value =amt1;
				
				
			
				totalnetamt();
				
				}
			}
			
			
			}
			
		
		}
		
		
		function get_val()
		{
			var amt=document.getElementById("amount").value;
			
			alert(amt);
			document.getElementById("total_amt").value =amt;
			
		}
		
		
		 function totalnetamt() {
			
			
			
			amt = 0;
			 //amt1 = 0;
			amt2 = 0;
			amt3 = 0;
			amt15=0;

			$('.item-row').each(function(i, row) {
				
				
				/* var $gstamt1temp = $(row).find('#gstamount1');
				var $gstamt1 = $($gstamt1temp).val();
				
				amt1 = Math.abs(amt1) + Math.abs($gstamt1);
				
				
				var $gstamt1temp = $(row).find('#gstamount2');
				var $gstamt2 = $($gstamt1temp).val();
				
				amt2 = Math.abs(amt2) + Math.abs($gstamt2);
				
				amt3 = amt1 + amt2;
				 */
				
				var $totamttemp = $(row).find('#amount');
				var totamt = $($totamttemp).val();
				amt15=Math.abs(amt15)+ Math.abs(totamt);
				
				
			});
				
				//$traverse_row = $(v).parents('.item-row');
				
	//alert(amt1);
		//	document.getElementById("A1").value = amt.toFixed(2);
			document.getElementById("total_amt").value = Math.round(amt15.toFixed(2));
			document.getElementById("net_amount").value =Math.round(amt15.toFixed(2));
		/* 	
		
			document.getElementById("tamount").value = Math.abs(amt15).toFixed(2);
			document.getElementById("net_amount").value = amt15;
			document.getElementById("net_amountcard").value = amt15;
			document.getElementById("cash_amt").value = amt15;
			document.getElementById("amount22").value = amt15;
			document.getElementById("total_amt22").value = amt15;
			document.getElementById("totalll").value = amt15;
			document.getElementById("cheque_amt").value = amt15; */ 
			
			
			//$("#addRow").focus();
		}
		
		
    
    </script>
    
    
</body>
</html>
