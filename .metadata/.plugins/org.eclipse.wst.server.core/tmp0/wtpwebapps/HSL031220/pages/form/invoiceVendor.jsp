 <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
	
	<script src="js/datevalidation.js"></script>

<script type="text/javascript">

$(function() {        
	$("#formID2").validationEngine();
	$("#popupContactcustomer").validationEngine();
	//$("#Vehicle_no").focus();
	

});

	$(function() {
		 var today = new Date(); 
		var dd = today.getDate(); 
		var mm = today.getMonth()+1;//January is 0! 
		var yyyy = today.getFullYear(); 
		if(dd<10){dd='0'+dd} 
		if(mm<10){mm='0'+mm} 
		$("#to_date").val(dd+'/'+mm+'/'+yyyy); 
		
		$("#111").hide();
		$("#222").hide();
		$("#333").hide();
		$("#444").hide();
		$("#555").hide();
		
		//$("#Vehicle_no").focus();
		$("#popupContact").hide();
		$("#popupContact1").hide();
		$("#popupContact_jobcard").hide();
		$("#popupContactcustomer").hide();
		
		
		 $("#description1").autocomplete("GoogleSearch/spareautosearch.jsp");
		 
		 
		 
		//$("#Job_Card_no").autocomplete("GoogleSearch/jobcardsearch.jsp");
		
		//$("#brand").autocomplete("GoogleSearch/brandsearcj.jsp");
		// $("#model").autocomplete("GoogleSearch/modelmaster.jsp");
		//$("#Model_jobcard").autocomplete("GoogleSearch/modelmaster.jsp");
		
		//$("#Vehicle_no").autocomplete("GoogleSearch/model_auto_search1.jsp");
		//$("#Vehicle_no1").autocomplete("GoogleSearch/model_auto_search.jsp");
		//$("#modelno").autocomplete("GoogleSearch/modelmaster.jsp");
		//$("#modelno1").autocomplete("GoogleSearch/modelmaster.jsp"); 
		//$("#taxtype").autocomplete("GoogleSearch/gsttaxtypeautosearch.jsp"); 
		//$("#tax_type").autocomplete("GoogleSearch/gsttaxtypeautosearch.jsp"); 
		//$("#ttype").autocomplete("GoogleSearch/gsttaxtypeautosearch1.jsp"); 
		//$("#Supervisor").autocomplete("GoogleSearch/EMPLOYEE1search.jsp");
		//$("#Mechanic").autocomplete("GoogleSearch/EMPLOYEE1search.jsp");
		
		$("#autoinvoice").autocomplete("GoogleSearch/invoicenoautosearch.jsp");
		
		$("#Customer_Id").autocomplete("GoogleSearch/Customer_name.jsp");
		$("#pono").autocomplete("GoogleSearch/pono.jsp");
		//$("#description1").autocomplete("GoogleSearch/spareautosearch.jsp");
		$("#shipstate").autocomplete("GoogleSearch/state_auto_search.jsp");

	});
	
	function selectchange(v)
	{
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#description1');
		$($hoardinglocation).focus();
		document.getElementById("spareorlabour").value= $(v).val();
		}
	
	
	 function validatenum(){
		  
			var x=  document.getElementById('paid_amt').value;
			var q=  document.getElementById('amount22').value;
			
			var a= parseInt(x);
			var b= parseInt(q);

			
			if(a>b)
				{
				
				alert("paid amount cannot be more then net amount");
				 document.getElementById('paid_amt').value="";
				 document.getElementById('balance_amt').value="";
				}
			
		  }
	
	
	
	

	
	
	
	function unselect(){
		
		if(document.getElementById('r1').checked )
			{
			
			document.getElementById('r2').checked = false;
			document.getElementById('r3').checked = false;
			
			
			}
		
		if(document.getElementById('r2').checked )
		{
		
		document.getElementById('r1').checked = false;
		document.getElementById('r3').checked = false;
		
		
		}
		
		if(document.getElementById('r3').checked )
		{
		
		document.getElementById('r1').checked = false;
		document.getElementById('r2').checked = false;
		
		
		}
		
		
		
		
	}
	
	
	
	
	function ValidatePhNo() {
        var phoneNo = document.getElementById('Phone').value;
        
        
        var phoneno = /^\+?([0-9]{2})\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})$/;  
        if	(phoneNo.match(phoneno) || phoneNo=="")  
              {  
           		 return true;  
              }  
            else  
              {  
              		alert("phone No. is not valid, Please Enter valid phone No"); 
              		document.getElementById('Phone').value="";
              		 document.getElementById('Phone').focus();
              		return false;  
              }  
        /* if (isNaN(phoneNo)) // this is the code I need to change
	    {
	        alert("Must input numbers");
	        document.getElementById('Phone').value="";
	        return false;
	    }*/
        if (phoneNo.length < 10 || phoneNo.length > 10) 
        {
            alert("phone No. is not valid, Please Enter valid phone No.");
            document.getElementById('Phone').value="";
            document.getElementById('Phone').focus();
            return false;
        } 

    //    alert("Success ");
        //return true;
     }
	
	
	function validatecust() {
	    var x = document.getElementById('vehicleno1').value;
	    if (x == null || x == "") {
	        alert("vehicleno must be filled out");
	        document.getElementById('vehicleno1').focus();
	        return false;
	    }
	    
	}
	
	
	
	function getCustinfo(str) {

		var tb1 = document.getElementById('Customer_name1').value;
		//alert(tb1);
		document.getElementById('Customer_name').value = tb1;

		//document.getElementById('Customer_name').value=document.getElementById('Customer_name1').value;
		//document.getElementById('modelno').value=document.getElementById('modelno1').value;

	}
</script>

<script type="text/javascript">
	function display(obj) {
		//alert("fewfw");
		txt = obj.options[obj.selectedIndex].value;
		/* document.getElementById(1).style.display = 'none';
		document.getElementById(2).style.display = 'none';
		document.getElementById(3).style.display = 'none';
		document.getElementById(4).style.display = 'none';
		//document.getElementById(5).style.display = 'none';
		//document.getElementById(6).style.display = 'none';
		document.getElementById(7).style.display = 'none';
		document.getElementById(8).style.display = 'none';
		document.getElementById(12).style.display = 'none';
		document.getElementById(13).style.display = 'none';
		document.getElementById(17).style.display = 'none'; */
		$("#1").hide();
		$("#2").hide();
		$("#3").hide();
		$("#4").hide();
		$("#5").hide();
		$("#6").hide();
		$("#7").hide();
		$("#8").hide();
		$("#12").hide();
		$("#13").hide();
		$("#17").hide();
		
		if (txt == "CASH") {
			$("#1").show(1000);
		}
		if (txt == "CREDIT") {
			$("#12").show(1000);
			/* document.getElementById(2).style.display = 'block';
			document.getElementById(3).style.display = 'block';
			document.getElementById(4).style.display = 'block';
			document.getElementById(5).style.display = 'block';
			document.getElementById(6).style.display = 'block' */;

		}
		if (txt == "CHEQUE") {
			/* document.getElementById(1).style.display = 'block';*/
			/* document.getElementById(2).style.display = 'block';
			document.getElementById(3).style.display = 'block';
			document.getElementById(4).style.display = 'block';
			document.getElementById(8).style.display = 'block'; */
			$("#2").show(1000);
			$("#3").show(1000);
			$("#4").show(1000);
			$("#5").show(1000);
		}
		if (txt == "PARTPAYMENT") {
			/* document.getElementById(1).style.display = 'block'; */
			$("#7").show(1000);
		}
		if (txt == "INSURANCE") {
			$("#13").show(1000);
			/* document.getElementById(8).style.display = 'block';
			document.getElementById(2).style.display = 'block';
			document.getElementById(3).style.display = 'block';
			document.getElementById(4).style.display = 'block'; */

		}

		if (txt == "CARDANDCASH") {
			$("#17").show(1000);
			/* document.getElementById(8).style.display = 'block';
			document.getElementById(2).style.display = 'block';
			document.getElementById(3).style.display = 'block';
			document.getElementById(4).style.display = 'block'; */

		}

	}

	function getvehicleno(v) {

		// alert(">>>");
		var $traverse_row = $(v).parents('.item-row');
		$hoardinglocationx = $($traverse_row).find('#btype');
		var tb1 = $($hoardinglocationx).val();
		//alert(tb1);
		document.getElementById('hh2').value = tb1;

		if (tb1 == "parts") {
			// alert("...1");
			openPopup1();

		} else {
			// alert("...2");
			openPopup2();

		}

		/* document.getElementById('hh').value= document.getElementById('Vehicle_no').value;
		document.getElementById('hh3').value=document.getElementById('Job_Card_no').value; 
		document.getElementById('hh4').value=document.getElementById('to_date').value; 	 
		document.getElementById('hh5').value=document.getElementById('Customer_name').value;  */

		/* document.getElementById('hh3').value=document.getElementById('Job_Card_no').value;  */
	}

	function balance() {
		//	alert(tb1);
		var tb1 = document.getElementById('amount22').value;
		var tb2 = document.getElementById('paid_amt').value;
		var tb3 = tb1 - tb2;
		document.getElementById('balance_amt').value = tb3;

		/* document.getElementById('hh3').value=document.getElementById('Job_Card_no').value;  */
	}

	function balance1() {
		//alert(tb1);
		var tb1 = document.getElementById('total_amt22').value;
		var tb2 = document.getElementById('paid_amt22').value;
		var tb3 = tb1 - tb2;
		document.getElementById('balance_amt22').value = tb3;

		/* document.getElementById('hh3').value=document.getElementById('Job_Card_no').value;  */
	}
</script>




<script>
function checkspecial() {
	
	
    var username = document.getElementById("shipgstn").value;
   
    var pattern = new RegExp(/[@~`!#$%\^*+=\-\[\]\\';,/{}|\\":<>\?]/); //unacceptable chars
    if (pattern.test(username)) {
        alert("Please only use standard alphanumerics");
        
        document.getElementById("shipgstn").value='';
        return false;
    }
    return true; //good user input
}

function CheckGstnSize() {
    var phoneNo = document.getElementById('shipgstn').value;
   
    if (phoneNo.length < 15 || phoneNo.length > 15) 
    {
        alert("GSTN is not valid, Please Enter 15 Digit GSTN No.");
        
        document.getElementById('shipgstn').value="";
        return false;
        
    }

   // alert("Success ");
  
    return true;
 }	
 
 
function duplicate(a)
{ 

		var ths = $(a).val();
		var t = 0;
		 $('.item-row').each(function(i,row){
			 
			 var $vid = $(row).find('#description1');
			 
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


<script>
	
	function getAmount(v)
	 {
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#quantity1');
				
			var tax1=$($hoardinglocation1).val();
			
			
			var $hoardinglocation2 = $($traverse_row).find('#myrate');
			
			var tax2=$($hoardinglocation2).val();
			
			$hoardinglocation5 = $($traverse_row).find('#amount1');
			
			$('.item-row').each(function(i, row) {
				
				
				amount = tax1 * tax2;
				
				//$hoardinglocation5 = $($traverse_row).find('#ee');
				$($hoardinglocation5).val(amount.toFixed(2));
				
			});
			
		
	 }
	
	
	
	function calculategst(v){
		
		
		
		//alert("1");
		
		var $traverse_row = $(v).parents('.item-row');
		
		
		$hoardinglocationgratq = $($traverse_row).find('#grate2');
		
		$hoardinglocationgratqq = $($traverse_row).find('#grate1');
		
		var $hoardinglocation = $($traverse_row).find('#vat1');
		
		var tax2=$($hoardinglocation).val();
		
		//$($hoardinglocation).val(rep);
		
		
		
		
		$('.item-row').each(function(i, row) {
			
			var grate=parseFloat(tax2)/2;
			
			//alert("Grate:"+grate);
		
		//$hoardinglocationgrate = $($traverse_row).find('#grate1');
		$($hoardinglocationgratq).val(grate);
		
		//$hoardinglocationgrate = $($traverse_row).find('#grate2');
		$($hoardinglocationgratqq).val(grate);
		
		
		var $traverse_row = $(v).parents('.item-row');
		
		//	alert(">>>");
			$hoardinglocationx1 = $($traverse_row).find('#myrate');
			//alert(">>>");
			$hoardinglocationx = $($traverse_row).find('#quantity1');
		//	alert(">>>");
			$hoardinglocation3 = $($traverse_row).find('#vat1');
			
			
			var qty = $($hoardinglocationx).val();
		
			var rate1 = $($hoardinglocationx1).val();
			
			var tax1 = $($hoardinglocation3).val();
			//alert(">>>");
			//alert(rate1);
			//alert(qty);
			
			ttamt= rate1 * qty;
			//alert(ttamt);
			$hoardinglocation = $($traverse_row).find('#amount1');
			$($hoardinglocation).val(ttamt);
			
			
			
			//alert(ttamt);
			netamount1=(ttamt*tax1)/ 100;
			
			var netamount= netamount1+ttamt;
			
			
			
			
			
			
			$hoardinglocation5x = $($traverse_row).find('#vatamount1');
			$($hoardinglocation5x).val(netamount.toFixed(2));
			
			 grate=parseFloat(tax1)/2;
			 
			 
			 var gstamount =(ttamt * grate)/100 ;
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
		
				
			 
			
			totalnetamt();
			
			
		});
			
			}
function totalnetamt() {
		
		
		
		amt = 0;
		 amt1 = 0;
		amt2 = 0;
		amt3 = 0;
		amt15=0;

		$('.item-row').each(function(i, row) {
			
			
			var $gstamt1temp = $(row).find('#gstamount1');
			var $gstamt1 = $($gstamt1temp).val();
			
			amt1 = Math.abs(amt1) + Math.abs($gstamt1);
			
			
			var $gstamt1temp = $(row).find('#gstamount2');
			var $gstamt2 = $($gstamt1temp).val();
			
			amt2 = Math.abs(amt2) + Math.abs($gstamt2);
			
			amt3 = amt1 + amt2;
			
			
			var $totamttemp = $(row).find('#vatamount1');
			var totamt = $($totamttemp).val();
			amt15=Math.abs(amt15)+ Math.abs(totamt);
			
			
		});
			
		document.getElementById("stot").value = Math.abs(amt15).toFixed(2);
		
		if(document.getElementById("transcharge").value!=""){
			transcharge=document.getElementById("transcharge").value;
			amt15=Math.abs(transcharge) + Math.abs(amt15);
			
		}
		
		if(document.getElementById("freight").value!=""){
			freight=document.getElementById("freight").value;
			amt15=Math.abs(freight) + Math.abs(amt15);
			
		}
		
		document.getElementById("A2").value = amt1.toFixed(2);
		document.getElementById("A4").value = amt2.toFixed(2);
		document.getElementById("A17").value = amt3.toFixed(2);
		
		document.getElementById("tamount").value = Math.abs(amt15).toFixed(2);
		document.getElementById("net_amount").value = Math.abs(amt15).toFixed(2);
		document.getElementById("net_amountcard").value = Math.abs(amt15).toFixed(2);
		document.getElementById("cash_amt").value = Math.abs(amt15).toFixed(2);
		document.getElementById("amount22").value =  Math.abs(amt15).toFixed(2);
		document.getElementById("total_amt22").value =  Math.abs(amt15).toFixed(2);
		document.getElementById("totalll").value = Math.abs(amt15).toFixed(2);
		document.getElementById("cheque_amt").value = Math.abs(amt15).toFixed(2);
		
		
		//$("#addRow").focus();
	}
	
	
function showmyd1(v){
	 var isChecked = $(v).attr('checked');
	 var myv=$(v).val();
	
		if(myv=="myd1"){
		if(isChecked=="checked"){
		
			
			$("#111").show(1000);
			$("#222").show(1000);
			$("#333").show(1000);
		}else{
			$("#111").hide();
			$("#222").hide();
			$("#333").hide();
			
		}
		
		}
		
		if(myv=="myd2"){
		if(isChecked=="checked"){
			
				
				$("#444").show(1000);
				$("#555").show(1000);
				
			}else{
				$("#444").hide();
				$("#555").hide();
				
				
			}
			
			}
	
}

	
	
	</script>

</head>
<body>

	<%
		String extracolumn = "";
		String manualauto = "";
		String partlabour = "";
		String withstock = "";
		String col1 = "";
		String col2 = "";
		String col3 = "";
		String discount = "";
		String perunit = "";
		try {
			DBConnection connection = new DBConnection();
			Connection conn = connection.getConnection();

			PreparedStatement preparedStatement112 = conn.prepareStatement("select * from settings ");
			//System.out.println("preparedStatement112"+preparedStatement112);
			ResultSet resultSet12 = preparedStatement112.executeQuery();

			if (resultSet12.next()) {

				extracolumn = resultSet12.getString("extracolumn");
				manualauto = resultSet12.getString("manualauto");
				partlabour = resultSet12.getString("partlabour");
				withstock = resultSet12.getString("withstock");

				col1 = resultSet12.getString("col1");
				col2 = resultSet12.getString("col2");
				col3 = resultSet12.getString("col3");
				discount = resultSet12.getString("discount");
				perunit = resultSet12.getString("perunit");
				//out.println(extracolumn);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

<input type="hidden" name="spareorlabour" id="spareorlabour" value="">
	
	<input type="hidden" name="partlbr" id="partlbr" value="<%=partlabour%>">
	<input type="hidden" name="extracolumn" id="extracolumn" value="<%=extracolumn%>">
	<input type="hidden" name="discountval" id="discountval" value="<%=discount%>">
	<input type="hidden" name="perunitcolumn" id="perunitcolumn" value="<%=perunit%>">
	<input type="hidden" name="manualauto" id="manualauto" value="<%=manualauto%>">

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
					<li><a href="#">Invoice</a></li>
					<li class="active">Invoice Form</li>
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
								
								<form action="Add_invoice_vendor" class="form-control" method="POST">
									
									<s:push value="eb">
									<div class="panel-body">
									
									
									<div class="row">
                                               
                                               <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Invoice No:</b>
                                                    </label>
                                                    <input type="text" size="30"  value="${response}" class="form-control"  name="invoiceno" required/> 
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>LR No</b>
                                                    </label>
                                                    <input type="text" class="form-control"  value="${invoice}"  name="order_id" id="order_id" readonly/> 
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       		 
                                                    <input type="hidden" class="form-control"  value="${despatch_id}"  name="despatch_id" id="despatch_id" readonly/> 
                                                
                                       		 
                                      		 
                                       		</div>
                                       		
                                       		
                                       		
                                   <div class="row">
                                               
                                               <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Customer Code</b>
                                                    </label>
                                                    <input type="text" onblur="getjobno1(this);" name="Customer_Id" id="Customer_Id" 
													 value="<s:property value="custid"/>" required readonly class="form-control"/>
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Customer Name</b>
                                                    </label>
                                                   <input type="text" name="Customer_name" id="Customer_name" 
													  value="<s:property value="cust_name"/>"  class="form-control" readonly required/>
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Gstn No</b>
                                                    </label>
                                                    <input name="Job_Card_no" id="Job_Card_no" value="<s:property value="gstn_no"/>" 
												         class="form-control" readonly required />
                                                </div>
                                       		 </div>
                                       		 
                                      		 
                                       		</div>  
                                       		
                                       		
                                       		
                                      <div class="row">
                                               
                                               <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Pan No</b>
                                                    </label>
                                                    <input name="Vehicle_no" class="form-control" value="<s:property value="pancard_no"/>" readonly	id="Vehicle_no"	 >
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>State</b>
                                                    </label>
                                                  <input type="text" name="Model" id="Model"  value="<s:property value="state"/>" class="form-control" readonly />
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>City</b>
                                                    </label>
                                                    <input type="text" name="KM" id="KM" value="<s:property value="city"/>" class="form-control" readonly/>
                                                </div>
                                       		 </div>
                                       		 
                                      		 
                                       		</div>
                                       		
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Mobile</b>
                                                    </label>
                                                    <input type="text" class="form-control" name="mobile" readonly id="mobile" value="<s:property value="mob_no"/>"  />
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Pending Amount</b>
                                                    </label>
                                                  <input type="text" class="form-control" name="Pendingamt" id="Pendingamt" readonly value="<s:property value="vendor"/>" />
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Date</b>
                                                    </label>
                                                <input type="text" name="Date" class="form-control" id="to_date"  onblur="FixShortDate(this);return ValidateForm(this);" required/>
                                                </div>
                                       		 </div>
                                       		 
                                      		 
                                       		</div>  		  		
									
									
									
									
									
									<div class="row">
                                               
                                               <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Address</b>
                                                    </label>
                                                    <textarea name="address" class="form-control" id="address"   rows="2" cols="23"  />${address}</textarea>
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Po NO</b>
                                                    </label>
                                                  <input type="text" class="form-control" name="pono" id="pono"   />
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-4">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Po Date</b>
                                                    </label>
                                               <input type="text" class="form-control" name="podate" id="podate"  onblur="FixShortDate(this);return ValidateForm(this);"  />
                                                </div>
                                       		 </div>
                                       		 
                                      		 
                                       		</div> 
									
									
									
									
									
									
									
									<table id="textfocus" width="900px;" cellspacing="1" cellpadding="1">
															
															<%-- <tr>
																
															<td align="left"><b>Invoice No:</b><br><input type="text" 
																	size="30" readonly
																	 value="${response}" 
																	class="validate[required]"  name="invoiceno"/> </td>
																
																
																<td align="left"><b>Order ID</b><br><input type="text" 
																	size="30" readonly value="${invoice}"  name="order_id"/></td>

																<td align="left"><b></b><br></td>
																</tr>	 --%>
															
															
															
															<%-- <tr>
																
															<td align="left"><b>Customer Code:</b><br><input type="text" onblur="getjobno1(this);"
																	name="Customer_Id" id="Customer_Id" size="30"
																	onchange="checkvalue();" value="<s:property value="custid"/>" tabindex="4"
																	class="validate[required]"  /> </td>
																
																<td align="left"><b>Customer Name:</b><br><input type="text" 
																	name="Customer_name" id="Customer_name" size="30"
																	onchange="checkvalue();" value="<s:property value="cust_name"/>"  tabindex="5"
																	class="validate[required] backcolor"  /></td>

																<td align="left"><b>GSTIN No:</b><br><input name="Job_Card_no"
																	size="30" id="Job_Card_no" value="<s:property value="gstn_no"/>" tabindex="6"
																	class="validate[required] backcolor" readonly="readonly" /></td>
																</tr> --%>		
																
																
																<%-- <tr>
																
																
																
																<td align="left"><b> Pan&nbsp;&nbsp;No:</b><br>
																<input name="Vehicle_no" class="form-control" value="<s:property value="pancard_no"/>" readonly	id="Vehicle_no"	 >
																</td>
															
																<td align="left"><b> State:</b><br>
																<input type="text" name="Model" id="Model"  value="<s:property value="state"/>" class="form-control" readonly />
																	
																</td>
																
																
																<td align="left"><b>City:</b><br>
																<input type="text" name="KM" id="KM" value="<s:property value="city"/>" class="form-control" readonly/>
																	</td>
															


															</tr> --%>
															
															
															
															<%-- <tr>

																<td align="left"><b>Mobile:</b><br>
																<input type="text" name="mobile" class="backcolor"
																	readonly id="mobile" size="30" onchange="checkvalue();"
																	value="<s:property value="mob_no"/>" tabindex="6" />
																</td>
																

																<td align="left"><b>Pending Amt:</b><br>
																<input type="text" name="Pendingamt"
																	id="Pendingamt" readonly size="30" 
																	value="<s:property value="vendor"/>" tabindex="6"
																	maxlength="6" /></td>
																
																<td align="left"><b>Date: </b><br>
																<input type="text" name="Date"
																	id="to_date" size="30" onblur="FixShortDate(this);return ValidateForm(this);"
																	value="" tabindex="6"  
																	class="validate[required]" readonly/>
																</td>
															</tr> --%>

														<%-- <tr>
															<td align="left"><b>Address:</b><br>
																	<textarea name="address" class="backcolor"
																	id="address"  size="30" rows="2" cols="23"
																	value="" tabindex="6" 
																	maxlength="916" />${address}</textarea>
																	</td>
																	
														<td align="left"><b>Po No:</b><br><input type="text" name="pono"
																	id="pono"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" />
																	</td>
																
																<td align="left"><b>PO Date:</b><br><input type="text" name="podate"
																	id="podate" size="30"  value=""  onblur="FixShortDate(this);return ValidateForm(this);" 
																	tabindex="6" 
																 /></td>
															
															</tr> --%>
															
															<tr>
															<td align="left">
															<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1" >&nbsp;&nbsp;&nbsp;<b>Details</b>
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b>Shipment Details</b>
															</td>
															</tr>
															
															<tr id="111">
															<td align="left"><b>Pay Term:</b><br><input type="text" name="termcond"
																	id="termcond"  size="30" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"
																	value="" tabindex="6" 
																	maxlength="96" />
																	</td>
															
																
																<td align="left"><b>Vendor:</b><br><input type="text" name="vendor"
																	id="vendor"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
															<td align="left">	<b>Vehicle No:</b><br>
															<input type="text" name="vehino"
																	id="vehino"  size="30" value="${vehicleno}"
																	value="" tabindex="6" 
																	maxlength="10" /></td>
																
															</tr>
															
															<tr  id="222"><td align="left"><b>E way Bill No</b><br><input type="text" name="dcnox"
																	id="dcnox"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>E way Bill Date:</b><br>
																<input type="text" name="dcdatex"
																	id="dcdatex"  size="30" 
																	value="" tabindex="6" onblur="FixShortDate(this);return ValidateForm(this);"
																	maxlength="96" /></td>
																
																
																<td align="left"><b>Transport Mode:</b><br><input type="text" name="transmode"
																	id="transmode"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
															</tr>
															
															<tr  id="333"><td align="left"><b>Contact Person:</b><br><input type="text" name="contactp"
																	id="contactp"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>Contact No:</b><br><input type="text" name="contactpno"
																	id="contactpno"  size="30" onblur="ValidateMoNo();"
																	value="" tabindex="6" 
																	maxlength="10" /></td>
																	
																
																
															</tr>
																
																	
															<tr  id="444">
															
															<td align="left"><b>Ship To party:</b><br><input type="text" name="shipparty"
																	id="shipparty"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
															
															
															
															<td align="left"><b>Shipping Address:</b><br><input type="text" name="shipadd"
																	id="shipadd"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>Ship GSTN No:</b><br><input type="text" name="shipgstn"
																	id="shipgstn"  size="30" onblur="checkspecial();CheckGstnSize();"
																	value="" tabindex="6" 
																	maxlength="15" /></td>
																	
																	
																
															</tr>
															
															<tr  id="555">
																	
																	<td align="left"><b>Ship State:</b><br><input type="text" name="shipstate"
																	id="shipstate"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
															</tr>
															<tr>

																
																
															</tr>
														</table>
														
														
														
														
                                       		
                                       		<br><br>
                                       		
                                       		
                                       	
                                       	
                                       	
                       <div id="product" class="tab-pane table-responsive active">
												
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%" colspan="5">
															<!-- AddRowDataTable -->
															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	
																	<tr>
																	
																	<th style="">Delete</th>
																	<th id="VLsparename"><label>Description</label></th>
																	<!-- <th id="VLsparename"><label>Batch</label></th> -->
																	
																	<th id="VLsparename"><label>Weight</label></th>
																	<th id="VLsparename"><label>Rate</label></th>
																	
																	<th id="VLsparename"><label>Amount</label></th> 
																	<% if(discount.equals("yes")) {%> 
																		 
																	<th id="VLsparename"><label>Disc(%)</label></th>
																	<th id="VLsparename"><label>Tot Amt</label></th> 
																	 <%  }%>
																	
																	
																	<th id="VLsparename"><label>HSN Code</label></th>
																	<th id="VLsparename"><label>Tax %</label></th>
																	<th id="VLsparename"><label>Cgst Rate</label></th>
																	<th id="VLsparename"><label>Cgst Amount</label></th>
																	<th id="VLsparename"><label>Sgst Rate</label></th>
																	<th id="VLsparename"><label>Sgst Amount</label></th> 
																	<th id="VLsparename"><label>Net Amount</label></th>
																		
																	
                                        
                                        
                                        							</tr>
																	
																	<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	
																		
																	<%-- <s:iterator value="(gridsize).{# this}" status="stat"> --%>
																
																
																<tr class="item-row">
																	
																	<td style="width:1px;"><a id="deleteRow"><img style="width:15px;" src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																	
																	<% if(partlabour.equals("yes")) {%>
																		<td><select name="ib.btype" id="btype"
																			onblur="gotoparts(v);" onchange="selectchange(this);"
																			align="center" style="width: 70px;" tabindex="8">

																				<option value="parts">PARTS</option>

																				<option value="labour">LABOUR</option>
																		</select></td>
																		<% }else{ %>
																		<input type="hidden" value="parts"  name="ib.btype" id="btype"	/>
																		<%} %>
																		
																	<% if(extracolumn.equals("0")) {%>
																		<input type="hidden" name="ib.partno"
																			style="width: 80px;" id="partno" value=""
																			tabindex="10"  />
																			<input type="hidden" name="ib.partdate"
																			style="width: 80px;" id="partdate" value=""
																			tabindex="10"  />
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value=""
																			tabindex="10"  />
																		<%  } %>

																		
																		<% if(extracolumn.equals("1")) {%>
																		<td><input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value=""
																			tabindex="10"  /></td>
																			<input type="hidden" name="ib.partdate"
																			style="width: 80px;" id="partdate" value=""
																			tabindex="10"  />
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value=""
																			tabindex="10"  />
																		<%  }%>
																		<% if(extracolumn.equals("2")) {%>
																	<td>	<input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value=""
																			tabindex="10"  /></td>
																	<td>	<input type="text" name="ib.partdate"
																			style="width: 80px;" id="partdate" value=""
																			tabindex="10"  /></td>
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value=""
																			tabindex="10"  />
																		</th>
																		<%  }%>
																		<% if(extracolumn.equals("3")) {%>
																		<td><input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value=""
																			tabindex="10"  /></td>
																		<td><input type="text" name="ib.partdate"
																			style="width: 80px;" id="partdate" value=""
																			tabindex="10"  /></td>
																		<td><input type="text" name="ib.partnox"
																			style="width: 80px;" id="partnox" value=""
																			tabindex="10"  /></td>
																		</th>
																		<%  }%>
																		


																		<td><input type="text" name="ib.description1"
																			style="width: 250px;" value="<s:property value="descriptiont[top]"/>" id="description1"
																			tabindex="10" required/></td>
																			
																			
																			
																		<input type="hidden" name="ib.batch1" style="width: 80px;" value="<s:property value="batcht[top]"/>" id="batch1" readonly />
																		
																		<td><input type="text" name="ib.quantity1"
																			style="width: 60px;" id="quantity1" required
																			tabindex="11"  onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"/></td>
																		
																			<% if(perunit.equals("yes")) {%>
																		
																			<td><input type="text" name="ib.perunit"
																			style="width: 60px;" id="perunit" value=""
																			tabindex="11"  onblur="calculategst(this);"  /></td>
																			<%} else{%>
																			<input type="hidden" name="ib.perunit"
																			style="width: 60px;" id="perunit" value=""
																			tabindex="11"  onblur="calculategst(this);"  />
																			<% } %>
																			
																			<td><input type="text" name="ib.myrate" 
																			style="width: 60px;" id="myrate"  onblur="getAmount(this);" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"
																			tabindex="11"   required/></td>
																		
																		<td><input type="text" name="ib.amount1" required readonly
																			id="amount1"  " onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"
																			style="width: 60px;" />
																		</td>
																		
																		<% if(discount.equals("yes")) {%>
																		
																		<td><input type="text" name="ib.disc" 
																			id="disc"  onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"
																			onblur="getnewsrno1xxx(this);gotoadd1();twodecimal(this);" 
																			style="width: 60px;" />
																		</td>
																		
																		<td><input type="text" name="ib.amtwithdisc" readonly tabindex="12"
																			id="amtwithdisc" onblur="twodecimal(this)" value="<s:property value="myamt[top]"/>" 
																			 
																			style="width: 60px;" />
																		</td>
																		
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																		
												
												<%  				}else{%>
													
																		<input type="hidden" name="ib.disc"
																			id="disc" value=""  tabindex="12"
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 60px;" />
																			
																			
																			<input type="hidden" name="ib.amtwithdisc" tabindex="12"
																			id="amtwithdisc" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																	
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																		
												
												<% } %>

																		<td><input type="text" value="<s:property value="hsncode[top]"/>" name="ib.ttype"   tabindex="12"
																			style="width: 60px;" id="ttype" required >
																		</td>
																		
																		<td><input type="text" name="ib.vat1" id="vat1" tabindex="13"
																			style="width: 60px;" onblur="calculategst(this);"></td>

																		
																		
																		<td><input name="ib.grate1" id="grate1" value="<s:property value="rate[top]"/>"
																			style="width: 60px;" reodonly>
																		</td>
																		
																		<td><input name="ib.gstamount1" id="gstamount1" value="<s:property value="netamt[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																		
																		<td><input name="ib.grate2" id="grate2" value="<s:property value="rate[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																		
																		<td><input name="ib.gstamount2" id="gstamount2" value="<s:property value="netamt[top]"/>"
																			style="width: 60px;" readonly>
																		</td>


																		<input type="hidden" name="ib.taxqmount1" id="taxqmount1"
																			value="" style="width: 60px;" readonly>

																		<td><input name="ib.vatamount1" id="vatamount1" onblur="getnewsrno44(this);" value="<s:property value="gstamt1[top]"/>" style="width: 60px;" >
																			
																	</tr>
																
																
																<%-- </s:iterator> --%>
																	
                                        </table></td></tr></table>
                                        
                                        
                                        
                                        <table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">

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
                                       		
                                       		
                                       		
                                       		
                                       
                                       <br><br>
                                       
                                       <div class="row">
                                               
                                               <div class="col-md-3">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Total</b>
                                                    </label>
                                                    <input name="ib.stot" class="form-control" id="stot"  value="<s:property value="totamt"/>" >
                                               
                                              
                                                </div>
                                       		 </div>
                                        		 
                                       		 <div class="col-md-3">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Freight</b>
                                                    </label>
                                                <input name="ib.freight" class="form-control" id="freight"   onblur="totalnetamt();" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;">
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-3">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Transport</b>
                                                    </label>
                                               <input name="ib.transport" id="transcharge" class="form-control" onblur="totalnetamt();" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;">
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 <div class="col-md-3">
                                            	<div class="form-group">
                                                    <label for="wlastName2"><b>Total Amt</b>
                                                    </label>
                                                <input name="ib.tamount" class="form-control" id="tamount"  value="<s:property value="totamt"/>">
                                                </div>
                                       		 </div>
                                       		 
                                      		 
                                       		</div> 
                                       
                                       
                                       
                                       
                                       
										
										<br>
										<table id="itemsTable$"  class="general-table$">
													
													<tr>
														<td  align="center"  colspan="5"> 
										

													<tr>
														<td><table>
																<tr>
																	<td class="style2" align="center">Tax</td>
																	
																	<td class="style2" colspan="2" align="center">Tax
																		amount</td>
																</tr>
																<tr>
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t1" maxlength="8"
																		size="37" value="CGST:" readonly="readonly">
																	</td>
																	<input type="hidden"
																		name="ib.A" id="A1" maxlength="8" size="15"
																		readonly="readonly">
																	
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A2" value="<s:property value="cgstamt"/>" maxlength="8" size="15"
																		">
																	</td>

																</tr>



																<tr>
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t2" maxlength="8"
																		size="37" value="SGST:" readonly="readonly">
																	</td>
																	<input type="hidden"
																		name="ib.A" id="A3" maxlength="8" size="15"
																		readonly="readonly">
																	

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A4" value="<s:property value="cgstamt"/>" maxlength="8" size="15"
																		>
																	</td>

																</tr>
																<!-- <tr>
											<td class="style2" align="center"><input type="text"
												name="ib.t" id="t3" maxlength="8" size="37"
												value="WCT12.5%:"></td>
											<td colspan="2" align="center"><input type="text"
												name="ib.A" id="A5" maxlength="8" size="15">
											</td>

											<td colspan="2" align="center"><input type="text"
												name="ib.A2" id="A6" maxlength="8" size="15">
											</td>

										</tr> -->
																<tr >
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t4" maxlength="8"
																		size="37" value="TOTAL TAX AMOUNT:" readonly="readonly">
																	</td>
																	<input type="hidden"
																		name="ib.A" id="A16" maxlength="8" size="15"
																		readonly="readonly">
																	

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A17" value="<s:property value="sgstamt"/>"  maxlength="8" size="15"
																		>
																	</td>

																</tr>
																<!-- <tr style="visibility:hidden">
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t8" maxlength="18"
																		size="37" value="SERVICE TAX 14% on 75% of D/P:"
																		readonly="readonly">
																	</td>
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A" id="A14" maxlength="18" size="15"
																		readonly="readonly">
																	</td>

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A15" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>
																<tr style="visibility:hidden">
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t9" maxlength="18"
																		size="37" value="SERVICE TAX 14%:"
																		readonly="readonly"></td>
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A" id="A7" maxlength="18" size="15"
																		readonly="readonly">
																	</td>

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A8" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>
																<tr style="visibility:hidden">
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t5" maxlength="8"
																		size="37" value="SWATCH BHARAT CESS 0.5%:"
																		readonly="readonly"></td>
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A" id="A9" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A10" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr>
																
																<tr style="visibility:hidden">
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t5" maxlength="8"
																		size="37" value="KRISHI KALYAN CESS 0.5%:"
																		readonly="readonly"></td>
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A" id="A100" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A101" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr> -->
																
																
																
																
																
																
																
																
																<!-- <tr>
										<td colspan="5">
										&nbsp;
										</td>
										
										</tr>
 -->


															</table>
														</td>

														<td><table align="left" id="textfocus">
																<tr>

																	<!-- <td colspan="1" ALIGN="LEFT"><b>Search :</b></td>
																	<td align="left" colspan="2"><input type="text"
																		name="autoinvoice" id="autoinvoice" maxlength="7"
																		size="30">
																	</td>
																	<td align="left" colspan="2"><input type="button"
																		name="Search" value="Search" class="btn btn-primary"
																		onclick="showspares();" /></td> -->
																</tr>
																<tr>
																	<!-- <td colspan="1" ALIGN="LEFT"><b>Invoice No:</b></td>
																	<td align="left" colspan="2"><input type="text"
																		name="invno" id="invno" maxlength="7" size="12">
																	</td>
																	<td colspan="1" ALIGN="LEFT"><b>&nbsp;</b></td> -->

																</tr>
																<tr>
																	<td colspan="4">&nbsp;</td>
																</tr>


																<tr>
																	<td colspan="4">

																		<table align="left" id="textfocus">
												 					 	<tr>

																				<td colspan="1" ALIGN="LEFT"><b></b></td>
																				<td><input type="hidden" name="paymod" id="paymod"
																					tabindex="21" onchange="display(this);"
																					align="center" value="" >
																						<%-- <option value="0">--------SELECT--------</option>
																						<option value="CASH">Cash :</option>
																						<option value="CREDIT">Card :</option>


																						<option value="CHEQUE">Cheque :</option>
																						<option value="PARTPAYMENT">Part Payment
																							:</option>
																						<!-- <option value="INSURANCE">Insurance:</option> -->
																						<!-- <option value="CARDANDCASH">Card & cash:</option> -->

																				</select> --%>
																				</td>

																			</tr>   
																			<td colspan="3">

																				<table border="1" id="tab">



																					<tbody id="1" style="display: none;">
																						<tr>
																							<td class="style2" align="center">Net Amount
																								:</td>
																							<td colspan="2" align="center"><input 
																								type="text" name="net_amount" id="net_amount"
																								maxlength="8" size="15">
																							</td>

																						</tr>
																					</tbody>

																					<tbody id="12" style="display: none;">
																						<tr>
																							<td class="style2" align="center">Net Amount
																								:</td>
																							<td colspan="2" align="center"><input
																								type="text" name="net_amountcard" readonly
																								id="net_amountcard" maxlength="8" size="15">
																							</td>
																							<td class="style2" align="center">Card
																								Transaction id :</td>
																							<td colspan="2" align="center"><input
																								type="text" name="cardid" id="cardid"
																								maxlength="8" size="15">
																							</td>

																						</tr>
																					</tbody>

																					<tbody id="13" style="display: none;">

																						<tr>
																							<td align="center" class="style2">Total
																								Amount :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="total_amt22" id="total_amt22"
																								maxlength="7" size="15">
																							</td>


																						</tr>

																						<tr>
																							<td class="style2" align="center">Paid
																								Amount :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="paid_amt22" id="paid_amt22"
																								onkeypress="isNumber(event);"
																								onblur="balance1();" maxlength="7" size="15">
																							</td>
																						</tr>
																						<tr>
																							<td align="center" class="style2">Balance
																								Amount :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="balance_amt22"
																								id="balance_amt22" maxlength="7" size="15"
																								readonly>
																							</td>


																						</tr>

																						<tr>
																							<td align="center" class="style2">Insurance
																								company :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="insurance" id="insurance"
																								maxlength="100" size="15">
																							</td>


																						</tr>

																						<tr>
																							<td align="center" class="style2">ID :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="id" id="id" maxlength="7"
																								size="15">
																							</td>


																						</tr>
																						<tr>
																							<td align="center" class="style2">Expected
																								date :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="date22" id="date22"
																								maxlength="10" size="15" onblur="FixShortDate(this);return ValidateForm(this);">
																							</td>


																						</tr>




																					</tbody>





																					<tbody id="8" style="display: none;">
																						<tr>
																							<td align="left" class="style2">Cash Amount
																								:</td>
																							<td align="left" colspan="2"><input
																								type="text" name="cash_amt" id="cash_amt"
																								maxlength="8" size="15">
																							</td>
																						</tr>
																					</tbody>
																					<tbody id="2" style="display: none;">
																						<tr>
																							<td class="style2" align="center">Bank Name
																								:</td>
																							<td align="center" colspan="2"><input
																								type="text" name="bankname" id="bankname"
																								maxlength="30" size="15">
																							</td>
																						</tr>
																					</tbody>
																					<tbody id="3" style="display: none;">
																						<tr>
																							<td class="style2" align="left">Cheque No :</td>
																							<td class="style2" align="left">Cheque
																								Amount :</td>
																							<td class="style2" align="left">Cheque Date
																								:</td>
																						</tr>
																					</tbody>
																					<tbody id="4" style="display: none;">
																						<tr>
																							<td align="left"><input type="text"
																								name="cheque_no" id="p4" maxlength="10"
																								size="15" onkeypress="isNumber(event);">
																							</td>
																							<td align="left"><input type="text" id="cheque_amt"
																								name="cheque_amt" size="15" maxlength="6" 
																								 onkeypress="isNumber(event);">
																							</td>
																							<td align="left"><input name="cheque_date" id="cheque_date"
																								value="" maxlength="20" 
																								onblur="FixShortDate(this);return ValidateForm(this);"
																								size="10"></td>
																						</tr>
																					</tbody>

																					<tbody id="7" style="display: none;">
																						<tr>
																							<td class="style2" align="center">Net Amount
																								:</td>
																							<td colspan="2" align="center"><input
																								type="text" name="amount22" id="amount22"
																								maxlength="8" size="15">
																							</td>

																						</tr>

																						<tr>
																							<td class="style2" align="center">Paid
																								Amount :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="paid_amt" id="paid_amt"
																								onkeypress="isNumber(event);"
																								onblur="balance();validatenum();" maxlength="7" size="15"
																								onchange='balance();'>
																							</td>
																						</tr>
																						<tr>
																							<td align="center" class="style2">Balance
																								Amount :</td>
																							<td align="left" colspan="2"><input name="balance_amt" id="balance_amt"
																								maxlength="7" size="15" readonly>
																							</td>
																						</tr>
																						<tr>
																						 <td align="center" ><table><tr><td><input type="radio" name="r1"  value="partpaymentcash"  > Cash</td>
 																							 <td><input type="radio" name="r1" value="partpaymentcheque"   > Cheque</td>
  																							<td><input type="radio" name="r1" value="partpaymentcard"  > Card</td></tr></table>
																						</td>
																						
																						</tr>
																						
																					</tbody>


																					<tbody id="17" style="display: none;">

																						<tr>
																							<td class="style2" align="center">Total
																								Amount :</td>
																							<td colspan="2" align="center"><input
																								type="text" name="totalll" id="totalll"
																								maxlength="8" size="15">
																							</td>

																						</tr>




																						<tr>
																							<td class="style2" align="center">Cash
																								Amount :</td>
																							<td colspan="2" align="center"><input
																								type="text" name="cashhh" id="cashhh"
																								maxlength="8" size="15">
																							</td>

																						</tr>

																						<tr>
																							<td class="style2" align="center">Credit
																								Card Amount :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="carddd" id="carddd"
																								onkeypress="isNumber(event);"
																								onblur="partpayment();" maxlength="7" size="15"
																								onchange='balance();'>
																							</td>
																						</tr>
																						<tr>
																							<td align="center" class="style2">Transaction
																								id :</td>
																							<td align="left" colspan="2"><input
																								type="text" name="trandi" id="trandi"
																								maxlength="7" size="15">
																							</td>
																						</tr>
																					</tbody>







																					<s:hidden name="payment_status_type"
																						id="payment_status_type" value="AMC"></s:hidden>


																				</table>
																			</td>







																		</table>
																	</td>


																</tr>
																<tr>
																	<td colspan="4">
																		<div id="printthis">

																			<input type="hidden" id="printbutton2"
																				name="printbutton2"> <input type="hidden"
																				id="submit2" name="submit2">
																				
																				
																		</div>
																	</td>

																</tr>

															</table></td>


													</tr>
													<tr><td>&nbsp;</td></tr>
											
										<!-- <tr>

											<td colspan="2" align="center">
												<input type="button"
												class="btn btn-primary" value="Submit" name="submit1" onclick="submitInvoice('submit');">
												
												<input type="button" name="Print" value="Submit"
												id="submitme" class="btn btn-primary"
												onclick="submitInvoice('Print');" />
												<input type="button" name="ReadySMS" value="Ready SMS"
												id="ReadySMS" class="btn btn-primary" onclick="sendsms(Customer_name.value,Vehicle_no.value,tamount.value,mobile.value,invno.value);"
												 />
												</td>
										</tr> -->
									</table>	
                                       		
                                       		
                                             
                                        <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" onclick="submitInvoice('Print');">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
									</div>
									
									</s:push>
						
									
									
									
								</form>
								
								
								
							</div>
						</div>
					</div>
				</div>
				
				
				<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRow").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
											var selected1="";
											var selected2="";
						
											if(document.getElementById("spareorlabour").value=="parts"){
												selected1="selected";
											}
											if(document.getElementById("spareorlabour").value=="labour"){
												selected2="selected";
											}			
											var myflag="";
												var partlbr=document.getElementById("partlbr").value;
												if(partlbr=="yes"){
													myflag='<td><select name="ib.btype" id="btype" onchange="selectchange(this);" align="cente<option value="" >--------SELECT--------</option><option value="parts" '+selected1+' >PARTS</option><option value="labour" '+selected2+' >LABOUR</option> </td>';
												}else{
													myflag='<input type="hidden" value="parts"  name="ib.btype" id="btype"		>';
													
												}
												var col1="";
												var col2="";
												var col3="";
												var extracolumn=document.getElementById("extracolumn").value;
											if(extracolumn=="0"){
													
													col1='<input style="width:80px;" type="hidden" name="ib.partno"  id="partno"  value=""   />';
													col2='<input style="width:80px;" type="hidden" name="ib.partdate"  id="partdate"  value=""   />';
													col3='<input style="width:80px;" type="hidden" name="ib.partnox"  id="partnox"  value=""   />';
												}
												if(extracolumn=="1"){
													
													col1='<td><input style="width:80px;" type="text" name="ib.partno"  id="partno"  value=""   /></td>';
													col2='<input style="width:80px;" type="hidden" name="ib.partdate"  id="partdate"  value=""   />';
													col3='<input style="width:80px;" type="hidden" name="ib.partnox"  id="partnox"  value=""   />';
												}
												if(extracolumn=="2"){
													
													col1='<td><input style="width:80px;" type="text" name="ib.partno"  id="partno"  value=""   /></td>';
													col2='<td><input style="width:80px;" type="text" name="ib.partdate"  id="partdate"  value=""   /></td>';
													col3='<input style="width:80px;" type="hidden" name="ib.partnox"  id="partnox"  value=""   />';
												}
												if(extracolumn=="3"){
													
													col1='<td><input style="width:80px;" type="text" name="ib.partno"  id="partno"  value=""   /></td>';
													col2='<td><input style="width:80px;" type="text" name="ib.partdate"  id="partdate"  value=""   /></td>';
													col3='<td><input style="width:80px;" type="text" name="ib.partnox"  id="partnox"  value=""   />';
												}
												
												
												
												   var disc=document.getElementById("discountval").value;
													if(disc=="yes"){
														myflag11='<td><input type="text" name="ib.disc"	  	id="disc" value="" 		onblur="getnewsrno1xxx(this);gotoadd1();twodecimal(this);" 	style="width: 60px;" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"/>		</td>';
														myflag22='<td><input type="text" name="ib.amtwithdisc" 		id="amtwithdisc" value="" 					readonly			style="width: 60px;" />		</td>';
															myflag33='<input type="hidden" name="ib.discamt"	 id="discamt" value="" 	 		style="width: 60px;twodecimal(this)" />';
													}else{
														myflag11='<input type="hidden" name="ib.disc"		id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 60px;" />		';
														myflag22='<input type="hidden" name="ib.amtwithdisc"		id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 60px;" />		</td>';
														myflag33='<input type="hidden" name="ib.discamt" 	id="discamt" value="" 	 		style="width: 60px;twodecimal(this)" />';
													}
												//alert(myflag);
													var puc="";
													var punit=document.getElementById("perunitcolumn").value;
													if(punit=="yes"){
														puc='<td><input style="width:60px;" type="text" name="ib.perunit"  id="perunit"  value="" onblur="calculategst(this);"  /></td>';
														
													}else{
														puc='<input style="width:60px;" type="hidden" name="ib.perunit"  id="perunit"  value="" onblur="calculategst(this);"  />';
														
													}
												
													var $itemsTable = $('#itemsTable');
													var $rowTemp = [
															'<tr class="item-row">',
															
															'<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															myflag,
															col1,
															col2,
															col3,
															/* '<td></select>	<input type="Button"class="btn btn-primary" value="New" onclick="getvehicleno(this);"></td>', */
															'<td><input style="width:250px;" type="text" name="ib.description1"  id="description1"  required/></td>',
															'<input type="hidden" name="ib.batch1" style="width: 80px;"  id="batch1"  />',
															'<td><input style="width:60px;" type="text"  name="ib.quantity1"  id="quantity1"   onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/></td>',
															puc,
															'<td><input style="width:60px;" type="text"  name="ib.myrate"  id="myrate" onblur="getAmount(this);"  required onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"/></td>',
															'<td><input style="width:60px;" type="text" name="ib.amount1"   id="amount1" readonly   onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;"/></td>',
															  myflag11,
										                        myflag22,
										                        myflag33,
															'<td><input type="text"  style="width:60px;" value="" name="ib.ttype"   required id="ttype" ></td>',
															'<td><input style="width:60px;" type="text" name="ib.vat1"    id="vat1" onblur="calculategst(this);" required/></td>',
															'<td><input type="text"  style="width:60px;"  name="ib.grate1" id="grate1" readonly required></td>',
															'<td><input type="text"  style="width:60px;"  name="ib.gstamount1" id="gstamount1" readonly required></td>',
															'<td><input type="text"  style="width:60px;"  name="ib.grate2" id="grate2" readonly required></td>',
															'<td><input type="text"  style="width:60px;"  name="ib.gstamount2" id="gstamount2" readonly required></td>',
															
															'<td><input style="width:60px;" type="text" name="ib.vatamount1"   id="vatamount1" value=""  onblur="getnewsrno44(this);" onkeypress="if ( isNaN(this.value + String.fromCharCode(event.keyCode) )) return false;" required/></td>',
															'<input type="hidden" name="ib.taxqmount1" id="taxqmount1"	value="" style="width: 60px;" readonly>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

													var $description1 = $row
															.find('#description1');
													$($description1)
															.autocomplete(
																	"GoogleSearch/spareautosearch.jsp");
													
													var $aa = $row
													.find('#ttype');
											$($aa)
													.autocomplete(
															"GoogleSearch/gsttaxtypeautosearch1.jsp");

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

