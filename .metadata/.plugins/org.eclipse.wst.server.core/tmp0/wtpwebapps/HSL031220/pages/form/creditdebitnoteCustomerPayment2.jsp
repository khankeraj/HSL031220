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
	 $("#customer_code").autocomplete("GoogleSearch/transporterautosearch.jsp");
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

function display12(obj) {
	
	txt = obj.options[obj.selectedIndex].value;
	
	
	//alert("Value:"+txt);
	
	if (txt == "Customer") {
		
	//alert("AA");
		$("#dealer_code").show(100);
		$("#customer_code").hide(100);
		
	}
	  else if(txt == "Supplier"){
		$("#dealer_code").hide(100);
		$("#customer_code").show(100);
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
					<h1 class="page-header text-overflow">Credit/Debit Notes</h1>
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
		<form action="InsertCustCreditDebit" id="frmFileUpload"
								class="form-control" method="post" name="mainForm"
								onsubmit="return qqq(this);" enctype="multipart/form-data">
								
								
								<br><br>

				 
					<div class="body">
                        <div class="row ">
                        
                        
                        
									<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Type:</label>
													
													<select class="form-control show-tick " onchange="display12(this);" name="usertype" id="type"  required>
												
																<option value="">Select</option>
			
																<option value="Customer">Customer</option>
																<option value="Supplier">Supplier</option>
																
																
													</select>
												</div>
									  </div>
							
									
                        </div>
                        
                         <div class="row ">
                            
                           <div class="col-sm-6">
                            
                            <div class="form-group floating-label">
											<input type="text" class="form-control floating-input" 
												 name="dealer_code" id="dealer_code" placeholder="Customer Name" > 
												
												
												 
												 
												 <input type="text" class="form-control floating-input" style="display: none"
												 name="transport_code" id="customer_code" placeholder="Supplier Name" >
												
												
												 
												 
												 
												  <span class="highlight"></span>
											<label> Name</label>
											
											
										</div></div>
										
										
										
										<div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="payment_date" id="payment_date" onblur="FixShortDate(this);return ValidateForm(this);checkDate();" 
												
												 required> <span class="highlight"></span>
											<label>Date</label>
										</div>
                            </div>
                           
                           </div>
                          <div class="row ">
                            <div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dealer_payment_amt" id="dealer_payment_amt"
											size="30" maxlength="7"  required> 
												
												 <span class="highlight"></span>
											<label>Amount</label>
										</div>
                            </div>
                            
                            <%--  <div class="col-sm-6">
                               <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="dpb.remark" id="city" value="${city1}"
												
												 > <span class="highlight"></span>
											<label>Type</label>
										</div>
                            </div> --%>
                           
                            <div class="col-sm-6">
                             <div class="form-group floating-label">
									<select class="selectpicker form-control floating-input" name="type" id="type" >
													<option value="0">----Select----</option>
													<option value="Credit">Credit</option>
										<option value="Debit">Debit</option>
										
										</Select></div>
                            </div>
                           
                           
                          
                           </div>
                           
                           <div class="row ">
                            <div class="col-sm-6">
                                
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="remark" id="remark" 
												
												 > <span class="highlight"></span>
											<label>Nariation</label>
										</div>
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="refno" id="refno" 
												
												 > <span class="highlight"></span>
											<label>REF NO</label>
										</div>
                            </div>
                           
                           </div>
                           
                           
                             
                            
                                <div class="row">
											<div class="col-sm-4 ">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div> 
							</form>
										</div></div></div>
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
