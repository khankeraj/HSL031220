<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="Css/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" href="Css/validationEngine/validationEngine.jquery.css" type="text/css" />
<script src="js/languages/jquery.validationEngine-en.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="Css/validationEngine.jquery.css" type="text/css" />

<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
<script src="datevalidation.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="js/rptsTable/jquery.dataTables.js"></script>
<link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />

<%-- <style type="text/css" title="currentStyle">
@import "Css/rptsTable/demo_page.css";

@import "Css/rptsTable/demo_table.css";

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
</style> --%>

<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>

<script>
function showWithGrid() {
	
	var withgrid=document.getElementById("withgrid").value;
	
	alert(withgrid);
	
	document.getElementById("WithGrid").value=withgrid;
	
	if(document.getElementById("withgrid").checked==true){
		document.getElementById("withoutgrid").checked=false;
		document.getElementById("customer_name_id").style.display="block";
		document.getElementById("customer_grid_id").style.display="block";
		document.getElementById("direct_customer_name").style.display="none";
		document.getElementById("dealer_payment_amt").readOnly = true;
		document.getElementById("dealer_code").focus();
		document.getElementById("dealer_payment_amt").value="";
	}else
		{
		document.getElementById("customer_name_id").style.display="none";
		document.getElementById("customer_grid_id").style.display="none";
		}
	
}

function showwithoutGrid() {
	
	var withoutgrid=document.getElementById("withoutgrid").value;
	
	alert(withoutgrid);
	
	document.getElementById("WithoutGrid").value=withoutgrid;
	
	if(document.getElementById("withoutgrid").checked==true)
	{
		document.getElementById("withgrid").checked=false;
		
		document.getElementById("customer_name_id").style.display="none";
		document.getElementById("direct_customer_name").style.display="block";
		document.getElementById("customer_grid_id").style.display="none";
		document.getElementById("dealer_payment_amt").readOnly = false;
		
		var total_amount=document.getElementById("total_amount").value;
		
		document.getElementById("dealer_payment_amt").value=total_amount;
		document.getElementById("dealer_payment_amt").focus();
		
	}else
		{
			document.getElementById("customer_name_id").style.display="none";
		}
}
</script>
<script type="text/javascript">

	

	function display(obj) {
		alert(obj);
		txt = obj.options[obj.selectedIndex].value;
		$("#1").hide();
		$("#2").hide();
		$("#3").hide();
		$("#4").hide();
		$("#5").hide();
		$("#6").hide();
		$("#7").hide();
		$("#7x").hide();
		$("#8").hide();
		$("#tab").hide();
		$("#22").hide();
		
		document.getElementById("p4").required = false;
		document.getElementById("p5").required = false;
		document.getElementById("p6").required = false;
		document.getElementById("bankname").required = false;
		document.getElementById("transcation_id").required = false;
		
		if (txt == 1) {
			$("#1").show(1000);
			$("#tab").show(1000);
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
			$("#22").show(1000);
			$("#tab").show(1000);
			document.getElementById("p4").required = true;
			document.getElementById("p5").required = true;
			document.getElementById("p6").required = true;
			document.getElementById("bankname").required = true;
			document.getElementById("bankname22").required = true;
		}
		if (txt == 4) {
			$("#2").show(1000);
			$("#1").show(1000);
			$("#7").show(1000);
			$("#tab").show(1000);
			$("#22").show(1000);
			document.getElementById("bankname").required = true;
			document.getElementById("transcation_id").required = true;
			document.getElementById("bankname22").required = true;
		}
		if (txt == 5) {
			$("#1").show(1000);
			$("#7").show(1000);
			$("#7x").show(1000);
			$("#tab").show(1000);

		}
		if (txt == 6) {
			$("#1").show(1000);
			$("#7").show(1000);
			$("#tab").show(1000);

		}
	}

	
	function f1()
	{
		
    var x=document.getElementById("dealer_payment_amt").value;
          document.getElementById("net_amount").value=x;
          document.getElementById("p5").value=x;
          
	}
	
</script>



<script type="text/javascript">


$(function() {
	
	$("#dealer_code").autocomplete("GoogleSearch/cust_auto_search.jsp");
	$("#empcode").autocomplete("GoogleSearch/emp_code_auto_search.jsp");	
	$("#icr_no").autocomplete("GoogleSearch/payment_Invoice_no_auto_search.jsp");
	$("#bankname").autocomplete("GoogleSearch/bankmaster_auto_search.jsp");
	$("#bankname22").autocomplete("GoogleSearch/bankmaster_auto_search.jsp");
	/* $("#product_code").autocomplete("GoogleSearch/amc_productcode_auto_search.jsp");
	$("#unit_no").autocomplete("GoogleSearch/amc_unitno_auto_search.jsp");
	$("#dealer_name").autocomplete("GoogleSearch/dealer_name_search.jsp"); */
	
	
	});

$(function() {
	var today = new Date(); 
	var dd = today.getDate(); 
	var mm = today.getMonth()+1;//January is 0! 
	var yyyy = today.getFullYear(); 
	if(dd<10){dd='0'+dd} 
	if(mm<10){mm='0'+mm} 
	$("#payment_date").val(dd+'-'+mm+'-'+yyyy);
	//$("#payment_date").focus();
		$("#dealerpayment").validationEngine();
		$("#s1").hide();
		$("#s2").hide();
		$("#s3").hide();
		$("#s4").hide();
		/* $("#payment_date" ).datepicker();
			dateFormat: "dd-mm-yy"	; */
	});
	
	
	
	
/* end */

</script>

<script type="text/javascript">
function showconfig(){
	
		//alert(">>>>>1");
		var aa=document.getElementById("dealer_code").value;
		alert(aa);
		var parts=aa.split("-");
		var autoinvoice = parts[1];
		alert(autoinvoice);
		//var autoinvoice1 = document.getElementById("qtyy").value;
		if(aa!=""){
		 if (window.XMLHttpRequest) {
				var xp1=new XMLHttpRequest();
			}
			else {
				var xp1=new ActiveXObject("Microsoft.XMLHTTP");
			}

	
		xp1.open("POST","InvoiceSearch1?autoinvoice="+autoinvoice);
	//alert("FetchspareGatepassAssemblyform?autoinvoice="+inv);

	    xp1.send();

	   
	   xp1.onreadystatechange=function() {


		if (xp1.readyState==4 && xp1.status==200) {

	//alert(xp1.responseText);
	
		

			document.getElementById("documentNoSpan").innerHTML=xp1.responseText;
			
			

			}
		
	 	  };
		
	 	 
	 	 document.getElementById("editdiv").style.height="auto";
	 	   	  
		}else{
			
			alert("Please select Customer Name");
			
		}
		
		
	}    
	    
    
  </script>  
<script type="text/javascript">
 var k=1;
 $(document).ready(function(){
		
     $("#addRow").bind('click', addRows);
function addRows(e){
               try{
               
               	k++;
                         var $itemsTable = $('#itemsTable');  
                         var $row = $($rowTemp);
                         //alert(k);
                         var $rowTemp = [
                         '<tr class="item-row">',
                         '<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                         /* '<td>'+k+'</td>', */
                       '<td><input  style="width:190px" type="text" name="material"  size="30"  id="material"  maxlegth="400"  Class="validate[required]" /></td>',
                       '<td><input  style="width:80px" type="text" name="materialqty" id="materialqty"  maxlegth="20"   Class="validate[required]" /></td>',
                       '<td><input  style="width:80px" type="text" name="qty123" id="qty123"  maxlegth="20"   Class="validate[required]" /></td>',
                       '<td><input  style="width:80px" type="text" name="qty123" id="qty123"  maxlegth="20"   Class="validate[required]" /></td>',                          
                                '</tr>'
                         ].join('');
                         var $row = $($rowTemp);
                         $.currentRow = $row;    
                         var $pcode= $row.find('#material');
                         $($pcode).autocomplete("GoogleSearch/spare_name_master_auto_search.jsp");
                         
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
                     
                       '<td><input type="text" name="prb.price2" onblur="allnumeric(this);" onchange="netamt();" id="price2" maxlength="4" /></td>', 

                       
                       
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



 </script>

<Script type="text/javascript">
function CalculateTotal12(v)
{
	 var total12 = 0;	
	 try {
		 var $traverse_row = $(v).parents('.item-row');
			$i = $($traverse_row).find('#invcheck');
			var isChecked = $(v).attr('checked');
			if (isChecked == 'checked'){
			
			 $($i).val($(v).val());
			 }else{
		    
			 $($i).val('');
			 }
	
	
	var amt15=0;
	$('.item-row').each(function(i, row) {
		
		var $gstamt1temp = $(row).find('#reamt');
		var $gstamt1 = $($gstamt1temp).val();
		
		
		$mycec= $(row).find('#mycec');
	 	 var isChecked = $($mycec).attr('checked');
	 	 
	 
	 	 
		 if (isChecked == 'checked'){
			 amt15=Math.abs(amt15)+ Math.abs($gstamt1);
			
	 	 }
		
	});
	
	
	 document.getElementById("dealer_payment_amt").value=amt15;
	 document.getElementById("net_amount").value=amt15;
	 
	 
	 }catch (e) {
		 	
		 }
		 }
	 
function qqq(s){
	 
	 if (document.getElementById("dealer_payment_amt").value=="0") {
		 alert("Please chec checbox");
	 		      return false;
	      
	    } else {
	      return true;
	    }

}

</script>

</head>

<body id="background">
<%
String lead_no=request.getParameter("lead_no");
String customer_name=request.getParameter("customer_name");
System.out.println("drevt_customer_name:"+customer_name);
String total=request.getParameter("total");
System.out.println("total:"+total);
String invoice_no=request.getParameter("invoice_no");

%>
<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Customer Payment</h1>
				</div>
				<!--End page title-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div>
		<s:form action="insertcustomerpaymentv" onsubmit="return qqq(this);" theme="simple" id="dealerpayment" class="formular">
			<div class="panel-body">
			<div class="row" align="right">
					<div class="col-sm-12">
						<div class="form-group">
							<label class="control-label"><input type="checkbox" class="form-control" name="withgrid" value="1" onclick="showWithGrid()" name="withgrid" id="withgrid"/>&nbsp; With Grid</label>
							<label class="control-label"><input type="checkbox" class="form-control" name="withoutgrid" value="2"  onclick="showwithoutGrid()" name="withoutgrid" id="withoutgrid"/>&nbsp; Direct</label>
						</div>
						
					</div>
			  </div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label">Date :</label>
							<input type="hidden"
										name="dpb.voucher_no" id="voucher_no" size="30"
										readonly="true" tabindex="1">
							<input type="hidden" name="WithoutGrid" id="WithoutGrid">
							<input type="hidden" name="WithGrid" id="WithGrid">
							<input type="hidden" name="total_amount" id="total_amount" value="<%=total%>">
							<input type="text" name="dpb.payment_date" class="form-control"
											id="payment_date" size="30" onblur="FixShortDate(this);"
											class="validate[required]"  cssClass="validate[required]"
											tabindex="2">
						</div>
					</div>
					
					<div class="col-sm-5" style="display: none;" id="customer_name_id">
						<div class="form-group">
							<label class="control-label">Customer&nbsp;Name :</label>
							<input type="text"  name="dpb.dealer_code" class="form-control"
											id="dealer_code" onblur="FixShortDate(this);"
											class="validate[required]"  cssClass="validate[required]"
											tabindex="2">
								<input type="button" style="margin-left: 428px; margin-top: -32px;" name="Search" value="GO" class="btn btn-primary" onclick="showconfig();" />
						</div>
						
					</div>
					
					<div class="col-sm-6" style="display: none;" id="direct_customer_name">
						<div class="form-group">
							<label class="control-label">Customer&nbsp;Name :</label>
							<input type="text"  name="customer_name" class="form-control" 
											id="customer_name" value="<%=customer_name%>">
						</div>
						
					</div>
			  </div>
			  
			  <div class="row" style="display:none;" id="customer_grid_id">
			  <table>
			  	<tr>
						<td colspan="9">
								<table id="itemsTable" class="general-table">

									<tbody>
									</tbody>


									<tbody>
									<tr id= "editdiv" ><td colspan="12"  style="height:1px" >
																	<div id="documentNoSpan"></div>
																	</td></tr>

									</tbody>
								</table>

							 <!-- AddRowDataTable --></td>
						
					</tr>
			  </table>
			  </div>
			  
			  <div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label">Paid&nbsp;Amt :</label>
							<input type="hidden"
										name="dpb.voucher_no" id="voucher_no" size="30" 
										readonly="true" tabindex="1">
							<input type="text" readonly class="form-control"
											name="dpb.dealer_payment_amt" id="dealer_payment_amt" 
											size="30" maxlength="7" onblur="f1();" 
											class="validate[required]" tabindex="5">
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label">Remark :</label>
							<input type="text"   name="dpb.remark" class="form-control"
											id="remark">
											
						</div>
						
					</div>
			  </div>
			  
			  <div class="row">
			  
			  <div class="col-sm-6">
					<div class="form-group">
					   <p class="text-thin mar-btm">Payment Mode :</p>
					   <select  tabindex="8" style="width:100%;"
							onchange="display(this);" name="dpb.paymod" id="paymod" class="validate[required]"  class="selectpicker" data-live-search="true">										>
								<option value="">-------------------SELECT-----------------</option>
								<option value="1">Cash :</option>

								<option value="3">Cheque :</option>
								<option value="4">NEFT :</option>
				
					</select>
					</div>							
			 </div>
			 
			 	<div class="col-sm-6">
						<div class="form-group">
							<label class="control-label">Verified By :</label>
							<input type="text" name="dpb.verifyby" class="form-control"
											id="verifyby">
											
						</div>
				</div>
			  </div>
			  
					<div class="row">
			   			<table >
								<tr>
									<td>&nbsp;</td>
									<td>
										<div id="tab">
											<table id="itemsTableSpare"  class="table table-striped table-bordered" cellspacing="0" width="100%">


												<tbody id="1" style="display: none;">
													<tr>
														<td  align="center">Net Amount :</td>
														<td colspan="2" align="center"><input type="text" class="form-control"
															name="dpb.net_amount" id="net_amount" maxlength=8
															size="15" readonly="readonly"></td>

													</tr>
												</tbody>
												<tbody id="8" style="display: none;">
													<tr>
														<td align="left" class="style2">Cash Amount :</td>
														<td align="left" colspan="2"><input type="text" class="form-control"
															name="dpb.cash_amt" id="cash_amt" maxlength=8 id="p2"
															size="15" cssClass="validate[required]">
														</td>
													</tr>
												</tbody>
												<tbody id="2" style="display: none;">
													<tr>
														<td class="style2" align="center">Bank Name :</td>
														<td align="center" colspan="2"><input type="text" class="form-control"
															name="dpb.bankname" id="bankname" tabindex="15"
															maxlength=30 size="15" class="validate[required]"
															>
														</td>
													</tr>
												</tbody>
												<tbody id="22" style="display: none;">
													<tr>
														<td class="style2" align="center">Our Bank Name :</td>
														<td align="center" colspan="2"><input type="text" class="form-control"
															name="dpb.bankname22" id="bankname22" tabindex="15"
															maxlength=30 size="15" class="validate[required]"
															>
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
														<td align="left"><input type="text" class="validate[required]" class="form-control"
															name="dpb.cheque_no" id="p4" maxlength=10 tabindex="16"
															size="15" onkeypress="isNumber(event);"></td>
														<td align="left"><input type="text" class="form-control"
															name="dpb.cheque_amt" size="15" maxlength=10
															tabindex="17" id="p5" onkeypress="isNumber(event);"
															class="validate[required]"
															maxlength="7"></td>
														<td align="left"><input name="dpb.cheque_date" class="form-control"
															value="" maxlength="20" id="p6" tabindex="18" class="validate[required]"
															onblur="FixShortDate(this);return ValidateForm(this);"
															size="10">
													</tr>
												</tbody>
												<tbody id="5" style="display: none;">
													<tr>
														<td align="left"><input type="text" name="dpb.chkno2" class="form-control"
															id="p7" maxlength=10 size="15"
															onkeypress="isNumber(event);"></td>
														<td align="left"><input type="text" name="dpb.amt2" class="form-control"
															size="15" maxlength=8 id="p8"
															onkeypress="isNumber(event);"
															cssClass="validate[required]"></td>
														<td align="left"><input name="dpb.chkdate2" value="" class="form-control"
															maxlength="20" id="p9" size="10"><a
															href="javascript:void(0)"> </a>
													</tr>
												</tbody>
												<tbody id="6" style="display: none;">
													<tr>
														<td align="left"><input type="text" name="dpb.chkno3" class="form-control"
															"size="15" onkeypress="isNumber(event);"></td>
														<td align="left"><input type="text" name="dpb.amt3" class="form-control"
															maxlength=8 size="15" onkeypress="isNumber(event);">
														</td>
														<td align="left"><input name="dpb.chkdate3" value="" class="form-control"
															maxlength="20" readonly size="10"><a
															href="javascript:void(0)"><img
																class="PopcalTrigger" align="middle"
																src="HelloWorld/calbtn.gif" width="34" height="22"
																border="0" alt=""> </a>
													</tr>
												</tbody>
												<tbody id="7" style="display: none;">
													<tr>
														<td class="style2" align="center">Transcation&nbsp;Id</td>
														<td align="left" colspan="2"><input type="text" class="form-control"
															name="dpb.transcation_id" id="transcation_id"
															tabindex="19" onkeypress="isNumber(event);" maxlength=7
															size="15" onblur="balanceamt();"></td>
													</tr>

												</tbody>

												<tbody id="7x" style="display: none;">
													<tr>
														<td class="style2" align="center">Supplier Name</td>
														<td align="left" colspan="2"><input type="text" class="form-control"
															name="dpb.suppliername" id="suppliername"
															tabindex="20" 
															size="15" ></td>
													</tr>
													<tr>
														<td class="style2" align="center">Bank Name</td>
														<td align="left" colspan="2"><input type="text" class="form-control"
															name="dpb.supplierbankname" id="supplierbankname"
															tabindex="20" 
															size="15" ></td>
													</tr>
													<tr>
														<td class="style2" align="center">Supplier City</td>
														<td align="left" colspan="2"><input type="text" class="form-control"
															name="dpb.suppliercity" id="suppliercity"
															tabindex="20" 
															size="15" ></td>
													</tr>
												</tbody>

											</table>
											</div>
									</td>
								</tr>
			   	</table>
			   </div>
			  <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<input type="hidden"  name="lead_no" value="<%=lead_no%>">
												<input type="hidden"  name="invoice_no" value="<%=invoice_no%>">
												
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
			</div>
		</s:form></div></div></div>
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
	</div>
	</div>
	
</body>
</html>
