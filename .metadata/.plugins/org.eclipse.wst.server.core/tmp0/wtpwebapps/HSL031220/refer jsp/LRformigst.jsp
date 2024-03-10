
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
		
		/* $("#model").autocomplete(
		"GoogleSearch/model_auto_search.jsp"); */
		$("#company_name").autocomplete(
		"GoogleSearch/PO/company_name_master_auto_search.jsp"); 
		
		
		
		$("#model").autocomplete(
		"GoogleSearch/PO/disc_auto_search.jsp");
		
		$("#product_code").autocomplete(
		"GoogleSearch/model_auto_search_pc.jsp");
		
		$("#product_code").autocomplete(
		"GoogleSearch/model_auto_search_pc.jsp");
		
		$("#tax_type").autocomplete("GoogleSearch/taxtypeautosearch.jsp"); 
		
		$("#tax_type1").autocomplete("GoogleSearch/taxtypeautosearch.jsp"); 
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
        	
        	var n = parseFloat(ths).toFixed(2);
        	 $(a).val(n);
        }
        
        
        
    </script>
    
    
     <script>
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
	</script> 
    
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
					
					$discrate = $(row).find('#disc');
					
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
					}
					
					
					
					var $hsn = $(row).find('#hsn');
					 $($hsn).val(ttype);
					
					
					var $tax = $(row).find('#tax');
					 $($tax).val(tax1);
					
					
					
					
					 grate=parseFloat(tax1);
					
					 gstamount =(amt * grate)/100 ;
					
						
					var $grate1 = $(row).find('#gstrate1');
					//var $grate2 = $(row).find('#gstrate2');
					var $gamt1 = $(row).find('#gstamount1');
					//var $gamt2 = $(row).find('#gstamount2');
					
					
					$($grate1).val(grate);
					//$($grate2).val(grate);
					
					$($gamt1).val(gstamount);
					//$($gamt2).val(gstamount);
					
				
					 var $net1 = $(row).find('#net');
					var net=Math.abs(gstamount)+Math.abs(amt);
					
					//alert("Net:"+net);
					$($net1).val(net); 
					 var $net1 = $(row).find('#net')
					net2=net2+net;

				document.getElementById("total_amt").value = net2;
				
				totalnetamt();
				
				}
			}
			
			
			}
			
		
		}
		 function splitname(v)
		 {
			 var name=document.getElementById("company_name").value;
			// alert(name);
			 if(name.indexOf('-')>-1)
				 {
				// alert("if");
				 var name=document.getElementById("company_name").value;
				 var s=name.split('-');
				 var s1=s[0];
				// alert(s[0]);
				 var s2=s[1];
				 document.getElementById("company_name").value=s[0];
				 document.getElementById("supplier_id").value=s[1];
				 }
		 }
 
		
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
		
		function totalnetamt() {
			
			
			
			amt = 0;
			 amt1 = 0;
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
				
				var $totamttemp = $(row).find('#net');
				var totamt = $($totamttemp).val();
				amt15=Math.abs(amt15)+ Math.abs(totamt);
				
				
			});
				
				//$traverse_row = $(v).parents('.item-row');
				
	//alert(amt1);
		//	document.getElementById("A1").value = amt.toFixed(2);
			document.getElementById("total_amt").value = amt15.toFixed(2);
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
    
    
    
    
</head>


<body >

<%
																		



																		String discount="";
																		
																		 try
																	    {
																	    	Connection connection = DaoHelper.getConnection();
																			
																			PreparedStatement preparedStatement112 = connection
																			.prepareStatement("select * from settings ");
																			//System.out.println("preparedStatement112"+preparedStatement112);
																		ResultSet resultSet12 = preparedStatement112.executeQuery();
													
														
																		if (resultSet12.next()) {
																		
																		
																			discount = resultSet12.getString("discount") ;
																		
																			
																		//out.println(extracolumn);
																		}
																			
																	    }
																	    catch(Exception e)
																	    {
																	    e.printStackTrace();
																	    }
																		
																		%>
																		
																		
	<input type="hidden" name="spareorlabour" id="spareorlabour" value="">
	<input type="hidden" name="discountval" id="discountval" value="<%=discount%>">
	
 
<%--  <body>
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Purchase IGST Form </h1>
				</div>
				<!--End page title-->
				
				

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						
						
						<div class="col-lg-12">
						
							<div class="panel">
							<div class="col-lg-6"></div>
							
								<div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div>
			
								<form class="form-horizontal" action="insert_LRformigst" Method="post" onsubmit="return validateform();">
									<div class="panel-body">
									<div class="col-lg-4"></div> --%>
									
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
					<h1 class="page-header text-overflow">Purchase IGST Form</h1>
				</div>
				<!--End page title-->
				
				

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						
						
						<div class="col-lg-12">
						
							<div class="panel">
							<div class="col-lg-6"></div>
							
								
								<form action="insert_LRformigst" id="frmFileUpload"
								class="form-control" method="post" name="mainForm"
								onsubmit="return validateform();" >
								<br>
								With Detail  <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withdetail" id="yesCheck" checked > without detail <input type="radio" onclick="javascript:yesnoCheck();" name="prb.yesno" value="withoutdetail" id="noCheck" ><br><br>
								<div class="row">
									<div class="col-sm-6">
												
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.lrnumber" id="lrnumber"  
												
												 required> <span class="highlight"></span>
											<label>Invoice No</label>
										</div>
									</div>
																		<div class="col-sm-6">
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.company_name" id="company_name"  value="${supplier_name }" onblur="splitname(this);"
												
												 required> <span class="highlight"></span>
											<label>Supplier Name</label>
										</div>
									</div></div>
									
									<div class="row">
									<div class="col-sm-6">
										<div class="form-group floating-label">
											<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.supplier_id" id="supplier_id" value="${supplier_id }"'readonly
												
												 required> <span class="highlight"></span>
											<label>Supplier ID</label>
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
									<input type="text" class="form-control floating-input"
												placeholder=" " name="prb.pono" id="pono" value="${pono }"'readonly
												
												 > 
									</div>
									
									<div class="tab-content m-t-10">
             
             <div class="tab-pane table-responsive active" id="sympdiv"  style="display:block">
             
             <div class="col-sm-12">
                         
                     <!--  <div class="form-group"> 
			
				<table id="itemsTable" class="table table-bordered">  -->
				<div class="form-group">
										<table id="itemsTable" class="table  table-bordered" cellspacing="0" width="100%">
												
						
			
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
											<th id="VLsparename"><label>HSN</label>
											<th id="VLsparename"><label>Tax Percent</label>
											<th id="VLsparename"><label>Igst Rate</label>
											<th id="VLsparename"><label>Igst Amount</label>
											<!-- <th id="VLsparename"><label>sgstrate</label>
											<th id="VLsparename"><label>sgstamount</label> -->
											
											<th id="VLsparename"><label>Unit</label>
											<th id="VLsparename"><label>Net Amount</label>
											 
											</th>
											 
											
										</tr>
					
								
				
										
			</tbody>
					
			<tbody>
			<s:iterator value="po_details_products1">
			
										<tr class="item-row">
											<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
										<!-- 	<td>1</td> -->

											<td><input style="width:190px" class="form-control"  name="prb.unit_no" required maxlength="20" size="30" id="model" value="<s:property value="disc1"/>" onblur="checkstockqty(this);duplicate(this);getrowdetails(this);"></td>
											<td><input style="width:80px"  class="form-control" name="prb.price" required id="price"  onblur="sparenetamt11(this);" value="<s:property value="price1"/>"  maxlength="6"></td>		
											<td><input  style="width:80px" class="form-control"  name="prb.qty" required id="qty" onblur="sparenetamt11(this);" value="<s:property value="qty2"/>" maxlength="6"></td>
											<td><input  style="width:80px" class="form-control"  name="prb.amount" required onblur="netamt();twodecimal(this);gotoadd()" value="<s:property value="amount1"/>" readonly
												id="amount" maxlength="6"></td>
												<% if(discount.equals("yes")) {%>
													<td><input type="text" class="form-control"  name="prb.disc"
																			id="disc" value="" 
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 80px;" />
																		</td>
																		<td><input type="hidden" class="form-control"  name="prb.amtwithdisc" readonly
																			id="amtwithdisc" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		</td>
																		<input type="hidden" class="form-control"  name="prb.discamt"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		
												
												<%  }else{%>
													<input type="hidden" name="prb.disc"
																			id="disc" class="form-control"  value="" 
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 80px;" />
																			<input type="hidden" class="form-control"  name="prb.amtwithdisc"
																			id="amtwithdisc" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																	
																		<input type="hidden" name="prb.discamt"
																			id="discamt" class="form-control"  onblur="twodecimal(this)" value="" 
																			 
																			style="width: 80px;" />
																		
												
												<% } %>
											<td><input style="width:80px" class="form-control"  value="<s:property value="tax"/>" name="prb.hsn" required maxlength="20" size="30" id="hsn" readonly></td>
											<td><input style="width:60px" class="form-control"  value="<s:property value="tax_percent1"/>" name="prb.tax_percent" required id="tax"  maxlength="6" readonly></td>		
											<td><input  style="width:60px" class="form-control"   name="prb.gstrate1" value="<s:property value="gstrate11"/>" required id="gstrate1" readonly onblur="netamt();"  maxlength="6"></td>	
												
											<td><input type="text"  class="form-control"  style="width:80px" required name="prb.gstamount1" value="<s:property value="gstamount11"/>" readonly maxlength="20" size="30" id="gstamount1" ></td>	
											<input  type="hidden" class="form-control"  style="width:60px"   name="prb.gstrate2" id="gstrate2" readonly maxlength="6">	
											<input type="hidden"  class="form-control" style="width:80px"   name="prb.gstamount2" id="gstamount2"  readonly maxlength="6"></td>	
												
										<td><Select name="prb.unitno"   id="unit_no" >
										<option value="NOS">NOS</option>
										<option value="KG">KG</option>
										<option value="PCS">PCS</option>
										<option value="MTRS">MTRS</option>
										
										
										</Select></td>
										
										<td><input  style="width:80px"  class="form-control" value="<s:property value="net1"/>"  name="prb.net" id="net" maxlength="6">
											<input type="hidden" name="prb.currentqty"
												id="currentqty" value="" readonly></td>
											
											
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
				
				</div></div>
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
 var k=1;
 $(document).ready(function(){
		
     $("#addRow").bind('click', addRows);
function addRows(e){
               try{
               
               	k++;
                         var $itemsTable = $('#itemsTable');  
                         var $row = $($rowTemp);
                         
                         var disc=document.getElementById("discountval").value;
							if(disc=="yes"){
								myflag='<td><input type="text" name="prb.disc"	class="form-control" 	id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 80px;" />		</td>';
								myflag2='<td><input type="text" name="prb.amtwithdisc"	class="form-control" 	id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 80px;" />		</td>';
									myflag1='<input type="hidden" name="prb.discamt" class="form-control" 	id="discamt" value="" 	 		style="width: 80px;twodecimal(this)" />';
							}else{
								myflag='<input type="hidden" name="prb.disc"	class="form-control" 	id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 80px;" />		';
								myflag2='<input type="hidden" name="prb.amtwithdisc"	class="form-control" 	id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 80px;" />		</td>';
								myflag1='<input type="hidden" name="prb.discamt" class="form-control" 	id="discamt" value="" 	 		style="width: 80px;twodecimal(this)" />';
							}
							
                         //alert(k);
                         var $rowTemp = [
                         '<tr class="item-row">',
                         '<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                         /* '<td>'+k+'</td>', */
                       '<td><input  style="width:190px" type="text" class="form-control" name="prb.unit_no"  size="30"  id="model"  maxlegth="251"  Class="validate[required]" onblur="checkstockqty(this);duplicate(this);getrowdetails(this);"/></td>',
                       '<td><input  style="width:80px" type="text" class="form-control" name="prb.price" id="price"  maxlegth="6" onblur="twodecimal(this);sparenetamt11(this);"   Class="validate[required]" /></td>',
                        '<td><input   style="width:80px" type="text" class="form-control"  name="prb.qty" onblur="sparenetamt11(this);"  onblur="allnumeric(this);" Class="validate[required]" maxlegth="6" id="qty"/></td>',
                        '<td><input  style="width:80px"  type="text" class="form-control" name="prb.amount" Class="validate[required]" readonly id="amount" onblur="netamt();twodecimal(this);gotoadd()" maxlegth="6"/></td>',
                        myflag,
                        myflag2,
                        myflag1,
                        '<td><input  style="width:80px" class="form-control"   name="prb.hsn" maxlength="20" size="30" id="hsn" readonly></td>',
						'<td><input  style="width:60px" class="form-control"   name="prb.tax_percent" id="tax" readonly maxlength="6"></td>',		
						'<td><input   style="width:60px" class="form-control"   name="prb.gstrate1" id="gstrate1" readonly  maxlength="6"></td>'	,
							
						'<td><input   style="width:80px" class="form-control"  name="prb.gstamount1" readonly maxlength="20" size="30" id="gstamount1" ></td>',
						'<input  type="hidden" class="form-control" style="width:60px" name="prb.gstrate2" id="gstrate2"  maxlength="6">',		
						'<input   type="hidden" class="form-control"   style="width:80px"  name="prb.gstamount2" id="gstamount2"  maxlength="6">',	
                        
                        '<td><Select  name="prb.unitno"   id="unit_no" ><option value="NOS">NOS</option><option value="KG">KG</option><option value="PCS">PCS</option><option value="MTRS">MTRS</option></Select></td>',
                        '<td><input   style="width:80px"  class="form-control" name="prb.net" id="net" maxlength="6" readonly></td>',
                        '<td><input   style="width:80px" class="form-control"  type="hidden" name="prb.currentqty" id="currentqty" readonly  maxlegth="6"/></td>',                           
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
                        /*  $($pcode).focus(); */
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


/* $(document).ready(function(){
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
 */
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
 <% if (discount.equals("no")){ %>
 <script>
 function gotoadd(){
		
		
		$("#addRow").focus();
	
	
	}
 </script>
 <%} else {%>
  <script>
 function gotoadd1(){
		
		
		$("#addRow").focus();
	
	
	}
 </script>
 
 <% } %>
 
</body>
</html>