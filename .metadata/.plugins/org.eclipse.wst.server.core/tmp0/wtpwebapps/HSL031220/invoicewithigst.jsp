<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@page import="com.aqua.dao.DaoHelper,java.sql.* "%>
<html>
<head>
<sx:head />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Invoice</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
Ionicons
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
<!-- Theme style -->

<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="Css/jquery-ui.css">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="Css/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="Css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="niceform-Product-Master.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="masterstyle.css" />
<link rel="stylesheet" type="text/css" href="Css/layout-styles.css" />
<link rel="stylesheet"
	href="Css/validationEngine/validationEngine.jquery.css" type="text/css" />
<link rel="stylesheet" href="Css/template.css" type="text/css" />
<script src="js/languages/jquery.validationEngine-en.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script>

<link rel="stylesheet" href="Css/validationEngine.jquery.css"
	type="text/css" />
<%-- <script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script> --%>
<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js"
	type="text/javascript"></script>
<%-- <script type="text/javascript" src="js/validation.js"></script> --%>
<script src="datevalidation.js" type="text/javascript"></script>

<link rel="stylesheet" href="Css/demos.css">
<script type="text/javascript" language="javascript"
	src="js/rptsTable/jquery.dataTables.js"></script>
<style type="text/css" title="currentStyle">
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
<script type="text/javascript"
	src="jQuery_4_design/AddRowDataTable/purchase_spare.js"></script>
<link rel="stylesheet" type="text/css"
	href="Css/AddRowDataTable/layout-styles.css" />
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />

<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script src="js/rangopopup.js" type="text/javascript"></script>
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
		
		$("#brand").autocomplete("GoogleSearch/brandsearcj.jsp");
		 $("#model").autocomplete("GoogleSearch/modelmaster.jsp");
		$("#Model_jobcard").autocomplete("GoogleSearch/modelmaster.jsp");
		
		$("#Vehicle_no").autocomplete("GoogleSearch/model_auto_search1.jsp");
		$("#Vehicle_no1").autocomplete("GoogleSearch/model_auto_search.jsp");
		$("#modelno").autocomplete("GoogleSearch/modelmaster.jsp");
		$("#modelno1").autocomplete("GoogleSearch/modelmaster.jsp"); 
		$("#taxtype").autocomplete("GoogleSearch/gsttaxtypeautosearch.jsp"); 
		$("#tax_type").autocomplete("GoogleSearch/gsttaxtypeautosearch.jsp"); 
		$("#ttype").autocomplete("GoogleSearch/gsttaxtypeautosearch1.jsp"); 
		$("#Supervisor").autocomplete("GoogleSearch/EMPLOYEE1search.jsp");
		$("#Mechanic").autocomplete("GoogleSearch/EMPLOYEE1search.jsp");
		$("#autoinvoice").autocomplete("GoogleSearch/invoicenoautosearchigst.jsp");
		
		$("#Customer_Id").autocomplete("GoogleSearch/Customer_name.jsp");
		$("#pono").autocomplete("GoogleSearch/pono.jsp");
		//$("#description1").autocomplete("GoogleSearch/spareautosearch.jsp");
		//$("#model").autocomplete("GoogleSearch/modelmaster.jsp");

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
	
	
	
	function openPopup1() {

		loadPopup();
		$("#sparename").focus();
		//centerPopup();
	  document.getElementById('sparename').value="";
	
		 document.getElementById('model').value="";
		 document.getElementById('cprice').value="";
	 document.getElementById('comprice').value="";
	 document.getElementById('taxtype').value="";
		//alert("1"+hoardinglocation6);
	document.getElementById('taxper').value="";
		document.getElementById('remark').value=""; 
		
		
		$("#sparename").focus();
	}

	function openPopup2() {

		loadPopup1();
		$("#service_name").focus();

		//centerPopup1();
		document.getElementById('service_name').value="";
		document.getElementById('tax_type').value="";
		//alert("5" + hoardinglocation77);
		document.getElementById('taxpercent').value="";
		
		$("#service_name").focus();

	}

	function openPopupcust() {
		
		
		loadPopupcust();
		//$("#").validationEngine();
		//$("#Batteryno").show("fast");
		//$("#formID2").hide("slow");
		
		document.getElementById('vehicleno1').value="";
		document.getElementById('chasisno').value="";
		document.getElementById('modelno1').value="";
		document.getElementById('engineno').value="";
		document.getElementById('Customer_namecust').value="";
		document.getElementById('custmastermobile').value="";
		document.getElementById('address').value="";
		document.getElementById('Phone').value="";
		document.getElementById('vatno').value="";
		/* document.getElementById('address').value="";
		document.getElementById('address').value="";
		document.getElementById('address').value=""; */
		
		$("#vehicleno1").focus();
		//centerPopupcust();
		//$("#vehicleno1").focus();

	}
	
	

	function openPopupcust() {
		
		
		loadPopupcust();
		
		document.getElementById('vehicleno1').value="";
		document.getElementById('chasisno').value="";
		document.getElementById('modelno1').value="";
		document.getElementById('engineno').value="";
		document.getElementById('Customer_namecust').value="";
		document.getElementById('custmastermobile').value="";
		document.getElementById('address').value="";
		document.getElementById('Phone').value="";
		document.getElementById('vatno').value="";
		/* document.getElementById('address').value="";
		document.getElementById('address').value="";
		document.getElementById('address').value=""; */
		
		$("#vehicleno1").focus();
		//centerPopupcust();
		$("#vehicleno1").focus();

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
	
	
	
	
	
function updatevehicle() {
		 var autoinvoice= document.getElementById('autoinvoice').value;
		// alert("autoinvoice"+autoinvoice);
		if(autoinvoice!=""){
		 var parts = autoinvoice.split("^");

			var inv = parts[0];
			//alert("inv" + inv);

			var vehicle = parts[1];
			//alert("vehicle" + vehicle);
			var cust = parts[2];
			//alert("cust" + cust);
				if (vehicle != "" && vehicle != "undefined") {
					document.getElementById('Vehicle_no').value = vehicle;
					
				
				}
				if (cust != "" && cust != "undefined") {
					document.getElementById('Customer_name').value = cust;
				
				}
				if (inv != "" && inv != "undefined") {
					document.getElementById('invno').value = inv;
					
				
				}
			//	getjobnoagain();
			
			//document.getElementById('Model_jobcard').value = model;
		

		
		}

	}
	
function showspares(){
	
	//alert(">>>>>1");
		var autoinvoice = document.getElementById("autoinvoice").value;
		if(autoinvoice!=""){
		 if (window.XMLHttpRequest) {
				var xp1=new XMLHttpRequest();
			}
			else {
				var xp1=new ActiveXObject("Microsoft.XMLHTTP");
			}

			
		 
		 
		 
	 var parts = autoinvoice.split("^");

				var inv = parts[0];
				//alert("inv" + inv);

				var vehicle = parts[1];
				//alert("vehicle" + vehicle);
				var cust = parts[2];
				//alert("111111" + vehicle);
				getjobnoagain(inv);
				//alert("111111" + vehicle);
		xp1.open("POST","FetchspareGatepassAssemblyform745?autoinvoice="+inv);
	//alert("FetchspareGatepassAssemblyform?autoinvoice="+inv);

	    xp1.send();


	   xp1.onreadystatechange=function() {


		if (xp1.readyState==4 && xp1.status==200) {

	//alert(xp1.responseText);

			document.getElementById("documentNoSpan").innerHTML=xp1.responseText;
			
			 totalnetamt();

			}


	 	  };
		
	 	
	 	 document.getElementById("editdiv").style.height="auto";
	 	  
	 	  
	 	  
	 	  
	 	  
	 	  
		}else{
			
			alert("Please select autoinvoice ");
			
		}
		
		
	}    
	    
	
	
	
	








function vissiblebatteryno() {
	
	
	$("#Batteryno").show("fast");
	
	// document.getElementById('').value;
	// alert("autoinvoice"+autoinvoice);
	 
	var remember1 = document.getElementById('Battery');

		if (remember1.checked) {

			$("#Batteryno").show("fast");

			$("#Batteryno").focus();

		}
		else{
			
			$("#Batteryno").hide("fast");
		}
	

}
	
	
	
	
	
	/* function centerPopup_jobcard(){
		//request data for centering
		//alert(">>>221");
	//	var windowWidth = document.documentElement.clientWidth;
//	var windowHeight = document.documentElement.clientHeight;
		//var popupHeight = $("#popupContact_jobcard").height();
		//var popupWidth = $("#popupContact_jobcard").width();
		//centering
		var windowHeight="900px";
		$("#popupContact_jobcard").css({
			"position": "absolute"
		//	"width":windowWidth
			//"top": windowHeight-popupHeight/2,
			//"left": windowWidth/2-popupWidth/2
		});
		//only need force for IE6
		
		$("#backgroundPopup").css({
			"height": windowHeight
		});
		
	} */
	/* function centerPopupcust(){
	
		//request data for centering
		//var windowWidth = document.documentElement.clientWidth;
		//var windowHeight = document.documentElement.clientHeight;
		//var popupHeight = $("#popupContactcustomer").height();
		//var popupWidth = $("#popupContactcustomer").width();
		//centering
		$("#popupContactcustomer").css({
			"position": "absolute"
		//	"width":windowWidth
			//"top": windowHeight-popupHeight/2,
			//"left": windowWidth/2-popupWidth/2
		});
		//only need force for IE6
		
		$("#backgroundPopup").css({
			//"height": windowHeight
		});
		
	} */
	function openPopup_jobcard() {
		
		loadPopup_jobcard();
		//centerPopup_jobcard();
		$("#Batteryno").hide("fast");
				$("#Vehicle_no1").focus();
		
		var today = new Date(); 
		var dd = today.getDate(); 
		var mm = today.getMonth()+1;//January is 0! 
		var yyyy = today.getFullYear(); 
		if(dd<10){dd='0'+dd} 
		if(mm<10){mm='0'+mm} 
		$("#Date1").val(dd+'-'+mm+'-'+yyyy);
		
		
//alert(">>>>");
		//$("#Vehicle_no1").focus();

	}
	function disablePopup_job() {
		//disables popup only if it is enabled
		//alert(">>>"+popupStatus_jobcard);
		if (popupStatus_jobcard == 1) {
			$("#backgroundPopup").fadeOut("slow");
			$("#popupContact_jobcard").fadeOut("slow");
			popupStatus_jobcard = 0;
		}
	}

	//disabling popup with jQuery magic!
	function disablePopup() {
		//disables popup only if it is enabled
		if (popupStatus == 1) {
			$("#backgroundPopup").fadeOut("slow");
			$("#popupContact").fadeOut("slow");
			popupStatus = 0;
		}
	}
	function disablePopup1() {
		//disables popup only if it is enabled
		if (popupStatus1 == 1) {
			$("#backgroundPopup").fadeOut("slow");
			$("#popupContact1").fadeOut("slow");
			popupStatus1 = 0;
		}
	}

	function disablePopup_cust() {
		//disables popup only if it is enabled
		if (popupStatus_cust == 1) {
			$("#backgroundPopup").fadeOut("slow");
			$("#popupContactcustomer").fadeOut("slow");
			popupStatus_cust = 0;
		}
	}

	function focusOnMyInputBox() {
		document.getElementById("Customer_Id").focus();
		$("#Customer_Id").focus();
	}
	
	function gotoparts(v) {
		
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#description1');
		$($hoardinglocation).focus();
	//	document.getElementById("description1").focus();
		
		
	}
	
	
		
		


	// document.getElementById('Customer_name').value=document.getElementById('Customer_name1').value;
	//document.getElementById('modelno').value=document.getElementById('modelno1').value;

	function getmodelInfo(str) {

		var tb1 = document.getElementById('modelno1').value;
		//alert(tb1);
		document.getElementById('modelno').value = tb1;

		//document.getElementById('Customer_name').value=document.getElementById('Customer_name1').value;
		//document.getElementById('modelno').value=document.getElementById('modelno1').value;

	}

	function ValidateMoNo() {
        var phoneNo = document.getElementById('custmastermobile').value;
        if (isNaN(phoneNo)) // this is the code I need to change
	    {
	        alert("Must input numbers");
	        document.getElementById('custmastermobile').value="";
	        document.getElementById('custmastermobile').focus();
	        return false;
	        
	    }
        if (phoneNo=="") 
        {
            alert("Mobile No. is not valid, Please Enter 10 Digit Mobile No.");
            document.getElementById('custmastermobile').value="";
            document.getElementById('custmastermobile').focus();
            return false;
            
        }
        if ( phoneNo.length > 10 || phoneNo.length < 10 ) 
        {
            alert("mobile no  should be 10 digit");
            document.getElementById('custmastermobile').value="";
            document.getElementById('custmastermobile').focus();
            return false;
        }
        
        
        

        //alert("Success ");
        return true;
     }
	
	
	
	function Validatecomprice() {
        var comprice = document.getElementById('comprice').value;
        if (isNaN(comprice)) // this is the code I need to change
	    {
	        alert("Must input numbers");
	        document.getElementById('comprice').value="";
	        document.getElementById('comprice').focus();
	        return false;
	    }
        
        else{
        return true;
        }
     }
	
	
	function Validatekm() {
        var KM1 = document.getElementById('KM1').value;
        if (isNaN(KM1)) // this is the code I need to change
	    {
	        alert("Must input numbers");
	        document.getElementById('KM1').value="";
	        document.getElementById('KM1').focus();
	        return false;
	    }
        if ( KM1.length > 6  ) 
        {
            alert("kilometer should be 6 digit");
            document.getElementById('KM1').value="";
            document.getElementById('KM1').focus();
            return false;
        }

        //alert("Success ");
         $("#Battery").focus();
        return true;
     }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	function Validatecostprice() {
        var cprice = document.getElementById('cprice').value;
        if (isNaN(cprice)) // this is the code I need to change
	    {
	        alert("Must input numbers");
	        document.getElementById('cprice').value="";
	        document.getElementById('cprice').focus();
	        return false;
	    }	
       /*  if ( cprice.length > 5 || cprice.length < 5 ) 
        {
            alert("price should be 5 digit");
            document.getElementById('cprice').value="";
            $("#cprice").focus();
            return false;
        }
        */

        //alert("Success ");
        return true;
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


<script type="text/javascript">
	function getnewsrno_jobcard() {
		//	alert("hie");

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var tab1 = document.getElementById('Vehicle_no1').value;
		if (tab1 != "") {
			xp1.open("POST", "getpmsvalue1?vehicleno1=" + tab1);
			//alert("hie2222");
			//	alert("1");
			xp1.send();
			//alert("2");
			//alert("hie3333");
			xp1.onreadystatechange = function() {
				// alert(xp1.readyState );
				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//alert("rep"+rep);
					
					if(rep.trim()==""){

					//	openPopupcust();
						
					}
					else if(rep.trim()=="Vehicle no ALready exist"){
						
						alert("vehicle no already exist");
						document.getElementById('Vehicle_no1').value = "";
						 $("#Vehicle_no1").focus();
						
					}
					
					
					else{
				
				
					var parts = rep.split("^");

					var model = parts[0];
					//alert("model" + model);

					var vehicle = parts[1];
					//alert("vehicle" + vehicle);
					var cust = parts[2];
					//alert("cust" + cust);
					var pamt = parts[3];



if( pamt > 0) {
							document.getElementById('pamt').value = pamt;
						}else{
document.getElementById('pamt').value = "0";

}


					document.getElementById('Customer_name1').value = cust;
					document.getElementById('Model_jobcard').value = model;
					document.getElementById('Vehicle_no1').value = vehicle;
					
					document.getElementById('KM1').focus();
					}
					
					
					
					

				}

			};
		}
	}
	
	
	function getnewsrno_jobcard1() {
		//	alert("hie");

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var tab1 = document.getElementById('vehicleno1').value;
		if (tab1 != "") {
			xp1.open("POST", "getpmsvalue1112?vehicleno1=" + tab1);
			//alert("hie2222");
			//	alert("1");
			xp1.send();
			//alert("2");
			//alert("hie3333");
			xp1.onreadystatechange = function() {
				// alert(xp1.readyState );
				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//alert("rep"+rep);
					
					if(rep.trim()==""){

					//	openPopupcust();
						
					}
					else if(rep.trim()=="vehicle_no already exist"){
						
						alert("vehicle no already exist");
						document.getElementById('vehicleno1').value = "";
						 $("#vehicleno1").focus();
						
					}
					
					
					else{
				
				
					
					}
					
					
					
					

				}

			};
		}
	}
	
	
	
	
	
	
	
	
	
	

	function Addinfocust(v) {
		//alert("144444");

		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
			var temp=0;
		//alert("1");

		var tab1 = document.getElementById('vehicleno1').value;
	//	alert("2" + tab1);
		if(tab1=="")
		{
			 temp=false;
			 alert("Please Fill Vehicle No");
			 document.getElementById('vehicleno1').focus();
			
		}
		else if(document.getElementById('modelno1').value==""){
			
			 temp=false;
			 alert("Please Fill Model Name");
			 document.getElementById('modelno1').focus();
			
		}else if(document.getElementById('Customer_namecust').value==""){
			
			 temp=false;
			 alert("Please Fill Customer Name");
			 document.getElementById('Customer_namecust').focus();
			
		}else if(document.getElementById('custmastermobile').value==""){
			
			 temp=false;
			 alert("Please Fill Customer Mobile");
			 document.getElementById('custmastermobile').focus();
			
		}
		
		else{
			
			 temp=true;
			
		}
			
			
		var tab2 = document.getElementById('modelno1').value;
		//alert("3" + tab2);

		var tab3 = document.getElementById('Customer_namecust').value;
		//alert("4");

		var tab4 = document.getElementById('chasisno').value;
		//alert("5");

		var tab5 = document.getElementById('engineno').value;
		//alert("6");

		var tab6 = document.getElementById('custmastermobile').value;
		//alert("7");

		var tab7 = document.getElementById('address').value;
		//alert("8");

		var tab8 = document.getElementById('Phone').value;
		//alert("9");

		var tab9 = document.getElementById('vatno').value;
		//alert("10");
        var cust_subname = document.getElementById('cust_subname').value;
		//var tab10=document.getElementById('Phone').value;
	//alert(">>>>"+"Add_New_Customer?vehicleno1=" + tab1 + "&modelno1="
	//	+ tab2 + "&Customer_name1=" + tab3 + "&chasisno=" + tab4
	//	+ "&engineno=" + tab5 + "&mobile=" + tab6 + "&address=" + tab7
	//	+ "&Phone=" + tab8 + "&vatno=" + tab9);
			if(temp== true)
				{
					
		
		xp11.open("POST", "Add_New_Customer?vehicleno1=" + tab1 + "&modelno1="
				+ tab2 + "&Customer_name1=" + tab3 + "&chasisno=" + tab4
				+ "&engineno=" + tab5 + "&mobile=" + tab6 + "&address=" + tab7
				+ "&Phone=" + tab8 + "&vatno=" + tab9 + "&cust_subname="+cust_subname);
		//alert("12");

		//alert("Add_New_Customer?vehicleno1=" + tab1 + "&modelno1=" + tab2
		//		+ "&Customer_name1=" + tab3 + "&chasisno=" + tab4
		//		+ "&engineno=" + tab5 + "&mobile=" + tab6 + "&address=" + tab7
		//		+ "&Phone=" + tab8 + "&vatno=" + tab9);
		//alert("13");
		//alert("1");
		xp11.send();
		//alert("343");
		xp11.onreadystatechange = function() {
		//	alert(xp11.readyState);
			if (xp11.readyState == 4 && xp11.status == 200) {
				///$("#popupContact").hide();
				//popupStatus = 0;
			//	alert("rep"+xp11.responseText);
				if(xp11.responseText.trim()=="Already"){
					alert("This vehicle number already exists");
				}
			}
		};

		document.getElementById('Vehicle_no1').value = tab1;

		document.getElementById('Customer_name1').value = tab3;
		document.getElementById('Model_jobcard').value = tab2;
		
	
		disablePopup_cust();
		$("#KM1").focus();
		
		
				}
			

		//var $traverse_row = $(v).parents('.item-row');
		//var $hoardinglocation = $($traverse_row).find('#description1');

		//$("#popupContact").hide();
		//$("#vehicleno1").focus();
		
		return temp;
		
	}
	
	



			
			
function sendsms(custname,vehicleno,amount,mobile,invoice){
	alert(custname+">>>>"+vehicleno+">>>>"+amount+">>>"+mobile);
	  var okdelete=confirm("Are You Sure Want to Send sms ?");
	  if(okdelete)
	 	 {
	    
	   
    	
    	
    	 if (window.XMLHttpRequest) {
				var xp1=new XMLHttpRequest();
			}
			else {
				var xp1=new ActiveXObject("Microsoft.XMLHTTP");
			}


		xp1.open("POST","send_ready_sms?custname="+custname+"&vehicleno="+vehicleno+"&amount="+amount+"&mobile="+mobile+"&invoice="+invoice);


	    xp1.send();


	   xp1.onreadystatechange=function() {


		if (xp1.readyState==4 && xp1.status==200) {

alert("Sms sent successfully");
	


			


	 	  }
    	
    	}
    	
    	 
	 	 }
	
}



	function submitInvoice(str)
	{
	
		if(str=="Print"){
			document.getElementById("printbutton2").value="printbutton2";
			//document.getElementById("printbutton2").style.display="block";
		}else{
			document.getElementById("submit2").value="submit2";
			//document.getElementById("submit2").style.display="block";
			
		}
	
	 	var act="Add_invoice_Igst";
	
		$("#formID2").attr('action', act);
		$("#formID2").submit();
	
	//document.formID1.submit();
	

	}
	

	
	
	/* function submitInvoice()
	{
	
		 

	}
	 */
	
	function NewCustomerOpen(e){
        if(e.keyCode === 13){
        	openPopupcust();
        	
        }

        return false;
    }
	function NewJobCardOpen1(e){
        if(e.keyCode === 13){
        	openPopup_jobcard();
        	
        }

        return false;
    }
	
	function NewJobCardOpen(e){
		try{
        if(e.keyCode === 13){
        	openPopup_jobcard();
        
        	
        }	
		}catch (e) {
			// TODO: handle exception
		}

        return false;
    }
	
	function NewSpareServiceOpen(e,v){
        if(e.keyCode === 13){
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
        
        	
        }	

        return false;
    }
	
	
	function getjobno2(v) {

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var jc = document.getElementById('Vehicle_no').value;
		if (jc != "") {
			xp1.open("POST", "getjobamount1?Vehicle_no=" + jc);

			xp1.send();

			//alert("POST", "getjobamount1?Job_Card_no=" + jc);

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
				//alert("rep" + rep);
					if (rep.trim() != "") {
						var parts = new Array();
					//	alert("2");
						parts = rep.split("^");

						var model = parts[0];
						//alert("model" + model);

						var vehicleno = parts[1];
						//alert("vehicleno" + vehicleno);

						var cust_name = parts[2];
						var km = parts[3];
						var jobcardno = parts[4];
						var mobileno = parts[6];
						var date = parts[5];
					//	alert(mobileno);
						//document.getElementById('Job_Card_no').value;
						$("#btype").focus();
						if (jobcardno != "" && jobcardno != "undefined") {
							document.getElementById('Job_Card_no').value = jobcardno;
						}
						if (model != "" && model != "undefined") {
						document.getElementById('Model').value = model;
						}
						if (cust_name != "" && cust_name != "undefined") {
						document.getElementById('Customer_name').value = cust_name;
						}
						
						if (km != "" && km != "undefined") {
						document.getElementById('KM').value = km;
						}
						if (mobileno != "" && mobileno != "undefined") {
						document.getElementById('mobile').value = mobileno;
						}
						if (vehicleno != "" && vehicleno != "undefined") {
							document.getElementById('Vehicle_no').value = vehicleno;
							}
							
						
						
						
						/* 
						if (date != "" && date != "undefined") {
							//document.getElementById('to_date').value = date;
							}
 */
						
					} /* else {

						openPopup_jobcard();

					} */

				} 

			};
		}
	}
	
	
	function getjobno1(v) {

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		//alert($(v).val());
		var desc=$(v).val();
		
		
		//parts=desc.split("~");
		
		
		//$(v).val(parts[0]);
		
		//alert($(v).val());
		//var jc = document.getElementById('Vehicle_no').value;
		if (desc != "") {
			xp1.open("POST", "getjobamount1?Vehicle_no=" + $(v).val());

			xp1.send();

			//alert("POST", "getjobamount1?Job_Card_no=" + jc);

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
				//alert("rep" + rep);
					if (rep.trim() != "" && rep.trim() != "0") {
						var parts = new Array();
					//	alert("2");
						parts = rep.split("^");

						var model = parts[0];
						//alert("model" + model);

						var vehicleno = parts[1];
						//alert("vehicleno" + vehicleno);

						var cust_name = parts[2];
						var km = parts[3];
						var jobcardno = parts[4];
						var mobileno = parts[6];
						var date = parts[5];
						var pamt = parts[7];
						var vendor = parts[8];
						var address = parts[9];
						//alert(address);
						//document.getElementById('Job_Card_no').value;
						$("#btype").focus();
						if (jobcardno != "" && jobcardno != "undefined") {
							document.getElementById('Job_Card_no').value = jobcardno;
						}
						if (model != "" && model != "undefined") {
						document.getElementById('Model').value = model;
						}
						 if (cust_name != "" && cust_name != "undefined") {
						document.getElementById('Customer_name').value = cust_name;
						} 
						
						if (km != "" && km != "undefined") {
						document.getElementById('KM').value = km;
						}
						if (mobileno != "" && mobileno != "undefined") {
						document.getElementById('mobile').value = mobileno;
						}
						if (vehicleno != "" && vehicleno != "undefined") {
							document.getElementById('Vehicle_no').value = vehicleno;
							}
						
						if (vendor != "" && vendor != "undefined") {
							document.getElementById('vendor').value = vendor;
							}
							
						if (pamt != "" && pamt != "undefined" && pamt >0 ) {
							document.getElementById('Pendingamt').value = pamt;
							}else{
						document.getElementById('Pendingamt').value = "0";

						}
						
						if (address != "" && address != "undefined"  ) {
							document.getElementById('address').value = address;
							}else{
						document.getElementById('address').value = "";

						}
						
						

						document.getElementById('pono').value = "";
						document.getElementById('podate').value = "";
						document.getElementById('termcond').value = "";
						
					}  else {
						document.getElementById('Job_Card_no').value="";
						document.getElementById('Model').value ="";
						document.getElementById('Customer_name').value="";
						document.getElementById('KM').value = "";
						document.getElementById('mobile').value = "";
						document.getElementById('Vehicle_no').value = "";
						document.getElementById('Pendingamt').value = "0";
					} 

				} 

			};
		}
	}
	
		
	
	function getnewsrno1(v) {
		//alert("1" + v);

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}

		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#description1');

		var $hoardinglocation1 = $($traverse_row).find('#quantity1');
		var $hoardinglocation2 = $($traverse_row).find('#amount1');
		var $hoardinglocation3 = $($traverse_row).find('#vat1');
		var $hoardinglocation4 = $($traverse_row).find('#taxqmount1');
		var $hoardinglocation5 = $($traverse_row).find('#vatamount1');
		var $hoardinglocation6 = $($traverse_row).find('#btype');
		var $hoardinglocation7 = $($traverse_row).find('#ttype');
			//$($hoardinglocation7).val(ttype);
		//	alert($hoardinglocation6.val());
		//	if($hoardinglocation6.val()=="labour"){
			var string =$($hoardinglocation).val();
			string=string.replace(/&/, "%26") ;
			string=string.replace(/&/, "%26") ;
			string=string.replace(/&/, "%26") ;
			  string=string.replace(/\"/g, "%22") ;
			  string=string.replace(/\#/g, "%23") ;
			  string=string.replace(/\#/g, "%23") ;
				 string=string.replace(/\+/g, "%2B") ;
				 string=string.replace(/\+/g, "%2B") ;
		xp1.open("POST", "getpmsamount1?description="
				+ string + "&qty="
				+ $($hoardinglocation1).val() + "&btype="
				+ $($hoardinglocation6).val());

		//	alert("1");
		xp1.send();
		//alert("2");
		xp1.onreadystatechange = function() {

			if (xp1.readyState == 4 && xp1.status == 200) {
				var rep = xp1.responseText;
				//	alert("rep"+rep);
				var parts = new Array();
				//alert("2");
				parts = rep.split("^");

				var rate1 = parts[0];
				//alert("rate1" + rate1);

				var tax1 = parts[1];
				//var tax1 = parts[1];
				//alert("tax1" + tax1)1
				
				$traverse_row = $(v).parents('.item-row');
				$hoardinglocationxs = $($traverse_row).find('#btype');
				$hoardinglocationx = $($traverse_row).find('#amount1');
				$hoardinglocationxwww = $($traverse_row).find('#vatamount1');
				
				if ($($hoardinglocationxs).val() == "parts") {

					var qty = $($hoardinglocation1).val();
					var partsamount = $($hoardinglocationx).val();
					 
					netamount = rate1 * qty;
					
					amount = (tax1 * netamount) / 100;
					var amount1 = (tax1 * netamount) / 100;
					//alert(netamount+">>>>"+amount1);
					var total1 =(netamount-amount1);

					total1=netamount;
					
				//	$($hoardinglocation1).val(qty.toFixed(2));
					$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(total1.toFixed(2));
					
				} else {
					var myamt = parts[2];
					$($hoardinglocationx).val(Math.abs(myamt).toFixed(2));
					$($hoardinglocationxwww).val(Math.abs(myamt).toFixed(2));
					var amount = $($hoardinglocationx).val();
					var amount1 = (tax1 * amount) / 100;
					var netamt = amount * 1;
					
					var grate=parseFloat(tax1)/2;
					var total1 = (netamt + amount1);
					$hoardinglocationgrate = $($traverse_row).find('#grate1');
					$($hoardinglocationgrate).val(grate);
					
					$hoardinglocationgrate = $($traverse_row).find('#grate2');
					$($hoardinglocationgrate).val(grate);
					
					var gstamount =(amount * grate)/100 ;
					
					$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
					
					$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
					
					$hoardinglocationgrate = $($traverse_row).find('#myrate');
					$($hoardinglocationgrate).val( Math.abs(myamt).toFixed(2));
					

				}

				$hoardinglocation = $($traverse_row).find('#vat1');
				$($hoardinglocation3).val(tax1);
			/* 	$hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(amount1); */
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				//$($hoardinglocation5).val(total1);
				$hoardinglocationl = $($traverse_row).find('#vatamount1');
				
				$($hoardinglocationl).focus();
				$($hoardinglocationl).select();

				
				 $hoardinglocation = $($traverse_row).find('#ttype');
				 if ($($hoardinglocationxs).val() == "labour") {

			$($hoardinglocation7).val(rate1);
				 }
					totalnetamt();

				
			}

		};
			//}
		
		
		
		$hoardinglocationl = $($traverse_row).find('#vatamount1');
		
		$($hoardinglocationl).focus();
		$($hoardinglocationl).select();

	}
	
	
	function getjobnoagain(vz) {

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
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
		
		

document.getElementById('invno').value = vz;
		var jc = document.getElementById('Vehicle_no').value;
		if (vz != "") {
			xp1.open("POST", "getjobamountagain?Vehicle_no=" + vz);

			xp1.send();

			//alert("POST", "getjobamount1?Job_Card_no=" + jc);

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//alert("rep" + rep);
					if (rep.trim() != "0" && rep.trim() != "") {
						var parts = new Array();
					//	alert("2");
						parts = rep.split("^");

						var model = parts[0];
						//alert("model" + model);

						var vehicleno = parts[1];
						//alert("vehicleno" + vehicleno);

						var cust_name = parts[2];
						var km = parts[3];
						var jobcardno = parts[4];
						var mobileno = parts[6];
						var date = parts[5];
						var paymode = parts[7];
						var paidmat = parts[8];
						var balanceamt = parts[9];
						var chek_date = parts[10];
						var cekno = parts[11];
						var cardid = parts[12];
						var insurancecomp = parts[13];
						var bankname = parts[14];
						var insurancedate = parts[15];
						var paybycredit=parts[17];
						var paybycash=	parts[16];
						var cid=	parts[18];
						
						var pono=	parts[19];
						var podate=	parts[20];
						var termcond=	parts[21];
						//alert(pono);
							var address=	parts[23];
						var vendor=parts[22];
						
						var dcno=	parts[24];
						var dcdate=	parts[25];
						
						 transmode=parts[26];
						  contactp=parts[27];
						  contactpno=parts[28];
						  shipparty=parts[29];
						  shipadd=parts[30];
						  	shipgstn=parts[31];
						  	shipstate=parts[32];
						  vehino=parts[33];
						  freight=parts[34];
						  transport=parts[35];
						  var st=parts[36];
							
						  if (st.trim()=="1") {


							  $('input[type="text"]').prop("readonly", true);
							  $('#autoinvoice').prop("readonly", false);
							  $('#address').prop("readonly", true);
								
								}else{
									 $('input[type="text"]').prop("readonly", false);
									 $('#invno').prop("readonly", true);
									 $('#A2').prop("readonly", true);
									 $('#A4').prop("readonly", true);
									 $('#A17').prop("readonly", true);
									 $('#address').prop("readonly", true);
									 $('#stot').prop("readonly", true);
									 $('#tamount').prop("readonly", true);
								} 
						  
						  if (freight != "" && freight != "undefined") {
								document.getElementById('freight').value = freight;
								}
						  
						  if (transport != "" && transport != "undefined") {
								document.getElementById('transcharge').value = transport;
								}
						  
						  if (transmode != "" && transmode != "undefined") {
								document.getElementById('transmode').value = transmode;
								}
						  if (contactp != "" && contactp != "undefined") {
								document.getElementById('contactp').value = contactp;
								}
						  if (contactpno != "" && contactpno != "undefined") {
								document.getElementById('contactpno').value = contactpno;
								}
						  if (shipparty != "" && shipparty != "undefined") {
								document.getElementById('shipparty').value = shipparty;
								}
						  if (shipadd != "" && shipadd != "undefined") {
								document.getElementById('shipadd').value = shipadd;
								}
						  if (shipgstn != "" && shipgstn != "undefined") {
								document.getElementById('shipgstn').value = shipgstn;
								}
						  if (shipstate != "" && shipstate != "undefined") {
								document.getElementById('shipstate').value = shipstate;
								}
						  if (vehino != "" && vehino != "undefined") {
								document.getElementById('vehino').value = vehino;
								}
						//alert(dcno);
						//document.getElementById('Job_Card_no').value;
						$("#btype").focus();
						if (jobcardno != "" && jobcardno != "undefined") {
							document.getElementById('Job_Card_no').value = jobcardno;
						}
						if (model != "" && model != "undefined") {
						document.getElementById('Model').value = model;
						}
						if (cust_name != "" && cust_name != "undefined") {
						document.getElementById('Customer_name').value = cust_name;
						}
						
						if (km != "" && km != "undefined") {
						document.getElementById('KM').value = km;
						}
						if (mobileno != "" && mobileno != "undefined") {
						document.getElementById('mobile').value = mobileno;
						}
						if (vehicleno != "" && vehicleno != "undefined") {
							document.getElementById('Customer_Id').value = vehicleno;
							}
						if (vehicleno != "" && vehicleno != "undefined") {
							document.getElementById('Vehicle_no').value = cid;
							}
						if (date != "" && date != "undefined") {
							document.getElementById('to_date').value = date;
							}
						if (paymode != "" && paymode != "undefined") {
							document.getElementById('paymod').value = paymode;
							document.getElementById('paymod').disabled = true ;
							
							}
						 else {

								document.getElementById('paymod').disabled = false ;

							}
						
						if (podate != "" && podate != "undefined") {
							document.getElementById('podate').value = podate;
							}
						
						
						if (pono != "" && pono != "undefined") {
							document.getElementById('pono').value = pono;
							}
						
						
						if (termcond != "" && termcond != "undefined") {
							document.getElementById('termcond').value = termcond;
							}
						
						if (address != "" && address != "undefined") {
							document.getElementById('address').value = address;
							}
						
						if (vendor != "" && vendor != "undefined") {
							document.getElementById('vendor').value = vendor;
							}
						
						if (dcno != "" && dcno != "undefined") {
							document.getElementById('dcnox').value = dcno;
							}
						
						if (dcdate != "" && dcdate != "undefined") {
							document.getElementById('dcdatex').value = dcdate;
							}
						
						/* 
						 if (paymode == "CASH") {
							$("#1").show(1000);
						}
						
						if (paymode == "CASH" ){
							if (paidmat != "" && paidmat != "undefined") {
								document.getElementById('net_amount').value = paidmat;
								}
							}
						
						if (paymode == "CHEQUE") {
							$("#2").show(1000);
							$("#3").show(1000);
							$("#4").show(1000);
							$("#5").show(1000);
						}
						if (paymode == "CHEQUE" ){
							if (paidmat != "" && paidmat != "undefined"  && paidmat != "null") {
								document.getElementById('cheque_amt').value = paidmat;
								}
							if (chek_date != "" && chek_date != "undefined" && chek_date != "null") {
								document.getElementById('cheque_date').value = chek_date;
								}
							if (bankname != "" && bankname != "undefined" && bankname != "null") {
								document.getElementById('bankname').value = bankname;
								}
							if (cekno != "" && cekno != "undefined" && cekno != "null") {
								document.getElementById('p4').value = cekno;
								}
							
							
							}
						if (paymode == "CREDIT") {
							$("#12").show(1000);
							

						}
					
						
						if (paymode == "CREDIT" ){
							if (paidmat != "" && paidmat != "undefined" && paidmat != "null") {
								document.getElementById('net_amountcard').value = paidmat;
								}
							
							if (cardid != "" && cardid != "undefined"  && cardid != "null") {
								document.getElementById('cardid').value = cardid;
								}
							
						}
						if (paymode == "INSURANCE") {
							$("#13").show(1000);
							
						}

						if (paymode == "INSURANCE" ){
							/* if (paidmat != "" && paidmat != "undefined"  && paidmat != "null") {
								document.getElementById('total_amt22').value = paidmat;
								} */
							/* 	if (paidmat != "" && paidmat != "undefined" && paidmat != "null" ) {
									document.getElementById('paid_amt22').value = paidmat;
								}
							if (insurancecomp != "" && insurancecomp != "undefined"  && insurancecomp != "null") {
								document.getElementById('insurance').value = insurancecomp;
								}
							if (insurancedate != "" && insurancedate != "undefined" && insurancedate != "null") {
								document.getElementById('date22').value = insurancedate;
								}
							
							if (balanceamt != "" && balanceamt != "undefined"  && balanceamt != "null") {
								document.getElementById('balance_amt22').value = balanceamt;
								}
							
						}
						
						
						if (paymode == "PARTPAYMENT") {
							
							$("#7").show(1000);
						}
						
							if (paymode == "PARTPAYMENT") {
							
								if (paidmat != "" && paidmat != "undefined"  && paidmat != "null") {
									document.getElementById('paid_amt').value = paidmat;
									}
								
								if (balanceamt != "" && balanceamt != "undefined"  && balanceamt != "null") {
									document.getElementById('balance_amt').value = balanceamt;
									}
								
						}
						
							
							if (paymode == "CARDANDCASH") {
								
								$("#17").show(1000);
							}
							
								if (paymode == "CARDANDCASH") {
								
									if (paybycash != "" && paybycash != "undefined"  && paybycash != "null") {
										document.getElementById('cashhh').value = paybycash;
										}
									
									if (paybycredit != "" && paybycredit != "undefined"  && paybycredit != "null") {
										document.getElementById('carddd').value = paybycredit;
										}
									
							}
							
 */					
						
						
						
						
						/* if (txt == "CREDIT") {
							$("#12").show(1000);
							

						}
					
						if (txt == "PARTPAYMENT") {
							
							$("#7").show(1000);
						}
						if (txt == "INSURANCE") {
							$("#13").show(1000);
							
						}

						if (txt == "CARDANDCASH") {
							$("#17").show(1000);
							
						} */

						
						/* 
						if (date != "" && date != "undefined") {
							//document.getElementById('to_date').value = date;
							}
 */
					/*  if (paymode == "" && paymode == "null") {
						 document.getElementById('paymod').disabled=true;
		
							}
 
								//
						
					 else {

						document.getElementById('paymod').disabled = false ;

					} */
					}

				} 

			};
		}
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// AJAX
	
	function Addinfo(v) {
		//alert("1" + v);

		if (window.XMLHttpRequest) {
			var xp11 = new XMLHttpRequest();
		} else {
			var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
		}
			var temp=0;
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation9 = $($traverse_row).find('#btype');
	////var $hoardinglocation14 = $($traverse_row).find('#ttype');

		var hoardinglocation1 = document.getElementById('sparename').value;
		if(hoardinglocation1=="")
			{
			
			var temp=false;
			alert("please fill spare name");
			
			}
		
		else{
			
			var temp=true;
			
		}
		
		//var hoardinglocation2 = document.getElementById('brand').value;
		var hoardinglocation3 = document.getElementById('model').value;
		var hoardinglocation4 = document.getElementById('cprice').value;
		var hoardinglocation5 = document.getElementById('comprice').value;
		var hoardinglocation6 = document.getElementById('taxtype').value;
		//alert("1"+hoardinglocation6);
		var hoardinglocation7 = document.getElementById('taxper').value;
		var hoardinglocation8 = document.getElementById('remark').value;
		var hoardinglocationunit = document.getElementById('unit').value;
		if(temp==true){

		xp11.open("POST", "Add_New_spare?sparename=" + hoardinglocation1
				 + "&model=" + hoardinglocation3
				+ "&cprice=" + hoardinglocation4 + "&comprice="
				+ hoardinglocation5 + "&taxtype=" + hoardinglocation6
				+ "&taxper=" + hoardinglocation7 + "&remark="
				+ hoardinglocation8 +"&unit="+hoardinglocationunit);
	/*  alert("Add_New_spare?sparename=" + hoardinglocation1
				 + "&model=" + hoardinglocation3
				+ "&cprice=" + hoardinglocation4 + "&comprice="
				+ hoardinglocation5 + "&taxtype=" + hoardinglocation6
				+ "&taxper=" + hoardinglocation7 + "&remark="
				+ hoardinglocation8);  */
		//alert("1");
		xp11.send();
	//alert("343");
		xp11.onreadystatechange = function() {
		
			if (xp11.readyState == 4 && xp11.status == 200) {
				///$("#popupContact").hide();
				//popupStatus = 0;
		//alert("rep" + xp11.responseText);
			}
			
		};
		
		
		disablePopup();
		
		}
	

		var $hoardinglocationqqqq = $($traverse_row).find('#description1');
		$($hoardinglocationqqqq).focus();
		
		return temp;

	}

	function Addinfo1(v) {
	//	alert("1" + v);

		if (window.XMLHttpRequest) {
			var xp112 = new XMLHttpRequest();
		} else {
			var xp112 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		var temp=0;
	//	alert("2" + v);
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation99 = $($traverse_row).find('#btype');
		
		
		
		
		
		//alert("3" + v);
		var hoardinglocation66 = document.getElementById('service_name').value;
		
		if(hoardinglocation66==""){
			var temp=false;
			alert("please fill service name");
				
				
				
			}
		
		else{
			
			var temp=true;
			
			
		}
		//alert("4" + hoardinglocation66);
		var hoardinglocation77 = document.getElementById('tax_type').value;
		//alert("5" + hoardinglocation77);
		var hoardinglocation88 = document.getElementById('taxpercent').value;
		var hoardinglocation881 = document.getElementById('amountsp').value;
		//alert("6" + hoardinglocation881);
		//alert("4" + v);
		if (temp== true){

		xp112.open("POST", "Add_New_spare1?service_name=" + hoardinglocation66
				+ "&tax_type=" + hoardinglocation77 + "&taxpercent="
				+ hoardinglocation88 +"&amount="+hoardinglocation881);
		//alert("5" + v);
		//alert("Add_New_spare1?service_name=" + hoardinglocation66
		//		+ "&tax_type=" + hoardinglocation77 + "&taxpercent="
		//		+ hoardinglocation88);
		//alert("1");
		xp112.send();
		//alert("343");
		xp112.onreadystatechange = function() {
			//alert(xp112.readyState);
			if (xp112.readyState == 4 && xp112.status == 200) {
				///$("#popupContact").hide();
				//popupStatus = 0;
				//alert("rep" + xp112.responseText);
			}
		};
		disablePopup1();
		
		
		}
		
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocationse = $($traverse_row).find('#description1');
		
		$($hoardinglocationse).focus();
		
		//$("#popupContact").hide();
		
		return temp;
	}

	function AddJobCard(v) {
		

		if (window.XMLHttpRequest) {
			var xp112 = new XMLHttpRequest();
		} else {
			var xp112 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		 var temp = 0;
		  

		var Vehicle_no1 = document.getElementById('Vehicle_no1').value;
		 //alert("Vehicle_no1"+Vehicle_no1);
		 
		 if(Vehicle_no1=="")
			 {
			 //alert("temp iff");
			 
			 var temp = false;
			 alert("please fill vehicle no");
			 
			 }
		 else{
			 
			 var temp = true; 
			 
		 }
	
		var modelnonn = document.getElementById('Model_jobcard').value;
	
		var Customer_name1 = document.getElementById('Customer_name1').value;
		
		var KM1 = document.getElementById('KM1').value;
		 if(KM1=="")
		 {
		 //alert("temp iff");
		 
		 var temp = false;
		 alert("please fill kilometer");
		 
		 }
	 else{
		 
		 var temp = true; 
		 
	 }
		var Fuel = document.getElementById('Fuel').value;
		var Date1 = document.getElementById('Date1').value;
		var Body_damg = document.getElementById('Body_damg').value;
		var Supervisor = document.getElementById('Supervisor').value;
		var Mechanic = document.getElementById('Mechanic').value;
		var drunning = document.getElementById('drunning').value;
	
		var Batteryno  = 	document.getElementById('Batteryno').value;
		if (Batteryno != "" && Batteryno != "undefined") {
			
			Batteryno = document.getElementById('Batteryno').value;
			
		}
		else
			{
			
			Batteryno = "";
			
			}
		var multipleValues = null;

	
		var remember = document.getElementById('Service_Book');

		if (remember.checked) {

		
			multipleValues = document.getElementById('Service_Book').value;
		

		}

		var remember1 = document.getElementById('Spare_wheel');

		if (remember1.checked) {

		

			multipleValues = multipleValues + ","
					+ document.getElementById('Spare_wheel').value;
		

		}

		var remember2 = document.getElementById('Jackie_handle');

		if (remember2.checked) {

		

			multipleValues = multipleValues + ","
					+ document.getElementById('Jackie_handle').value;
		

		}
		var remember3 = document.getElementById('carder');

		if (remember3.checked) {

	
			multipleValues = multipleValues + ","
					+ document.getElementById('carder').value;
		

		}

		var remember4 = document.getElementById('stereo');

		if (remember4.checked) {

		
			multipleValues = multipleValues + ","
					+ document.getElementById('stereo').value;
			

		}

		var remember5 = document.getElementById('clock');

		if (remember5.checked) {

	

			multipleValues = multipleValues + ","
					+ document.getElementById('clock').value;
	

		}

		var remember6 = document.getElementById('Tool_Kit');

		if (remember6.checked) {

		

			multipleValues = multipleValues + ","
					+ document.getElementById('Tool_Kit').value;
		

		}

		var remember7 = document.getElementById('Mats_Carpet');

		if (remember7.checked) {

		

			multipleValues = multipleValues + ","
					+ document.getElementById('Mats_Carpet').value;
			//alert("7" + multipleValues);

		}

		var remember8 = document.getElementById('mud_flaps');

		if (remember8.checked) {

			//alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('mud_flaps').value;
			//alert("7" + multipleValues);

		}
		var remember9 = document.getElementById('mud_flaps');

		if (remember9.checked) {

			///alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('mud_flaps').value;
			//alert("7" + multipleValues);

		}

		var remember10 = document.getElementById('Frohner');

		if (remember10.checked) {

			//alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('Frohner').value;
			//alert("7" + multipleValues);

		}

		var remember11 = document.getElementById('Wheel_cap');

		if (remember11.checked) {

			//alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('Wheel_cap').value;
			//alert("7" + multipleValues);

		}

		var remember12 = document.getElementById('speaker');

		if (remember12.checked) {

			//alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('speaker').value;
			//alert("7" + multipleValues);

		}

		var remember13 = document.getElementById('Battery');

		if (remember13.checked) {

			//alert("lllll");

			multipleValues = multipleValues + ","
					+ document.getElementById('Battery').value;
			//alert("7" + multipleValues);

		}
		//alert("<<<<"+temp);
	if(temp==true)
		{

		xp112.open("POST", "Add_jobcard?Vehicle_no1=" + Vehicle_no1
				+ "&Customer_name1=" + Customer_name1 + "&modelnonn=" + modelnonn + "&KM1=" + KM1
				+ "&Fuel=" + Fuel + "&drunning=" + drunning + "&Date1=" + Date1 + "&Body_damg="
				+ Body_damg + "&Supervisor=" + Supervisor + "&Mechanic="
				+ Mechanic + "&multipleValues=" + multipleValues + "&Batteryno=" + Batteryno);

	

	
		xp112.send();
	
		xp112.onreadystatechange = function() {
			//alert(xp112.readyState);
			if (xp112.readyState == 4 && xp112.status == 200) {
				///$("#popupContact").hide();
				//popupStatus = 0;
					//alert(xp112.responseText);
					 var parts = xp112.responseText.split("~");

					 document.getElementById('Job_Card_no').value= parts[0];
					 document.getElementById('mobile').value= parts[1];
				
					
				
				
			}
		};
		//alert(">>>1");
		
		
	 document.getElementById('Vehicle_no').value = document.getElementById('Vehicle_no1').value;
						document.getElementById('Model').value = document.getElementById('Model_jobcard').value;
						document.getElementById('Customer_name').value = document.getElementById('Customer_name1').value;
						
						document.getElementById('KM').value = document.getElementById('KM1').value; 
						//alert(">>>2");
						document.getElementById('Pendingamt').value = document.getElementById('pamt').value; 
							
							//getjobno1(document.getElementById('Vehicle_no1'));
							getjobno2();
							//alert(">>>3");
							var okdelete = confirm("Do you want to add new Job Card ?");
							if (okdelete) {

								$("#Vehicle_no1").focus();
							} else  {

								disablePopup_job();
								
								$("#btype").focus();

							}
							
	
	
		
	 //alert("Job Card Added Successfully");
		 document.getElementById('Vehicle_no1').value="";
			document.getElementById('Model_jobcard').value="";
			document.getElementById('Customer_name1').value="";
			document.getElementById('KM1').value="";
			document.getElementById('Body_damg').value="";
			document.getElementById('Supervisor').value="";
			document.getElementById('Mechanic').value="";
			document.getElementById('Batteryno').value="";
			$("#Batteryno").hide("fast");
			var remember = document.getElementById('Service_Book');

			if (remember.checked) {

				remember.checked = false;
					

			}

			var remember1 = document.getElementById('Spare_wheel');

			if (remember1.checked) {

				remember1.checked = false;

				

			}

			var remember2 = document.getElementById('Jackie_handle');

			if (remember2.checked) {

				remember2.checked = false;
		
				

			}
			var remember3 = document.getElementById('carder');

			if (remember3.checked) {

		
				remember3.checked = false;
			

			}

			var remember4 = document.getElementById('stereo');

			if (remember4.checked) {

				remember4.checked = false;
			

			}

			var remember5 = document.getElementById('clock');

			if (remember5.checked) {

		
				remember5.checked = false;
				

			}

			var remember6 = document.getElementById('Tool_Kit');

			if (remember6.checked) {

			
				remember6.checked = false;

				

			}

			var remember7 = document.getElementById('Mats_Carpet');

			if (remember7.checked) {

			

				remember7.checked = false;
				//alert("7" + multipleValues);

			}

			var remember8 = document.getElementById('mud_flaps');

			if (remember8.checked) {

				//alert("lllll");

				remember8.checked = false;

			}
			var remember9 = document.getElementById('mud_flaps');

			if (remember9.checked) {

				///alert("lllll");

				remember9.checked = false;
				//alert("7" + multipleValues);

			}

			var remember10 = document.getElementById('Frohner');

			if (remember10.checked) {

				//alert("lllll");

				remember10.checked = false;
				//alert("7" + multipleValues);

			}

			var remember11 = document.getElementById('Wheel_cap');

			if (remember11.checked) {

				//alert("lllll");

				remember11.checked= false;

			}

			var remember12 = document.getElementById('speaker');

			if (remember12.checked) {

				//alert("lllll");

				remember12.checked = false;

			}

			var remember13 = document.getElementById('Battery');

			if (remember13.checked) {

				//alert("lllll");

				remember13.checked = false;

			}
			
		
			
		}
		//----------
	
		//var $traverse_row = $(v).parents('.item-row');
		//var $hoardinglocation = $($traverse_row).find('#description1');

		//$("#popupContact").hide();
		return temp;
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
			
			
			
			
			amt3 =  amt1;
			
			
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
	
		
		//alert(amt2);
		document.getElementById("tamount").value = Math.abs(amt15).toFixed(2);
		document.getElementById("net_amount").value = amt15;
		document.getElementById("net_amountcard").value = amt15;
		document.getElementById("cash_amt").value = amt15;
		document.getElementById("amount22").value = amt15;
		document.getElementById("total_amt22").value = amt15;
		document.getElementById("totalll").value = amt15;
		document.getElementById("cheque_amt").value = amt15;
		
		
		//document.getElementById("A2").value = amt1.toFixed(2);
		document.getElementById("A4").value = amt1.toFixed(2);
		document.getElementById("A17").value = amt3.toFixed(2);
		//$("#addRow").focus();
	}

	function fnPrint(invoicedivd) {

		var okprint = confirm("Are You Sure Want to Print!");
		/* var orderno=document.getElementById("orderno").value;
		 var documentno=document.getElementById("documentno").value; */
		if (okprint) {
			/* documentno=documentno.replace(/&/, "%26") ;
			
			documentno=documentno.replace(/#/, "%23") ; */

			window.open('PrintPage3_Printout?vehicleno=' + invoicedivd, '',
					'width=600,height=600');

		}
	}
	
	function movetosubmit(){
	
		document.getElementById("submitme").focus();
	
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


<body  onload="focusOnMyInputBox();">
<%
																		



																		String extracolumn="";
																		String manualauto="";
																		String partlabour="";
																		String withstock="";
																		String col1="";
																		String col2="";
																		String col3="";
																		String discount="";
																		 try
																	    {
																	    	Connection connection = DaoHelper.getConnection();
																			
																			PreparedStatement preparedStatement112 = connection
																			.prepareStatement("select * from settings ");
																			//System.out.println("preparedStatement112"+preparedStatement112);
																		ResultSet resultSet12 = preparedStatement112.executeQuery();
													
														
																		if (resultSet12.next()) {
																		
																		
																			extracolumn = resultSet12.getString("extracolumn") ;
																			manualauto = resultSet12.getString("manualauto") ;
																			partlabour = resultSet12.getString("partlabour") ;
																			withstock = resultSet12.getString("withstock") ;
																			 
																			col1 = resultSet12.getString("col1") ;
																			col2 = resultSet12.getString("col2") ;
																			col3 = resultSet12.getString("col3") ;
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
	
	<input type="hidden" name="partlbr" id="partlbr" value="<%=partlabour%>">
	<input type="hidden" name="extracolumn" id="extracolumn" value="<%=extracolumn%>">
		<input type="hidden" name="discountval" id="discountval" value="<%=discount%>">
	
	<div class="wrapper">




		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper1">
			<!-- Content Header (Page header) -->
			<div class="row">
				<!-- left column -->
				<div class="col-md-12">
					<!-- general form elements -->
					<div class="box box-primary">
					
									<form action="Add_invoice_Igst" id="formID2" name="formID2"
										method="POST">


										<center>

											<h2>TAX INVOICE IGST</h2>

										

														<table id="textfocus" width="900px;" cellspacing="1" cellpadding="1">
															<tr>
																
															<td align="left"><b>Invoice No:</b><br><input type="text" 
																	size="30" readonly
																	 value="${response}" 
																	class="validate[required]"  /> </td>
																<td align="left"><b></b><br></td>

																<td align="left"><b></b><br></td>
																</tr>	
															<tr>
																
															<td align="left"><b>Customer Code:</b><br><input type="text" onblur="getjobno1(this);"
																	name="Customer_Id" id="Customer_Id" size="30"
																	onchange="checkvalue();" value="" tabindex="4"
																	class="validate[required]"  /> </td>
																<td align="left"><b>Customer Name:</b><br><input type="text" 
																	name="Customer_name" id="Customer_name" size="30"
																	onchange="checkvalue();" value="" tabindex="5"
																	class="validate[required] backcolor"  /></td>

																<td align="left"><b>GSTIN No:</b><br><input name="Job_Card_no"
																	size="30" id="Job_Card_no" value="" tabindex="6"
																	class="validate[required] backcolor" readonly="readonly" /></td>
																</tr>		
																<tr>
																<td align="left"><b> Pan&nbsp;&nbsp;No:</b><br>
																<input name="Vehicle_no" class="backcolor" tabindex="6" readonly	id="Vehicle_no"		size="30" value="" >
																</td>
															
																<td align="left"><b> State:</b><br>
																<input type="text" name="Model"
																	id="Model" size="30"  value=""
																	tabindex="6" class="validate[required] backcolor"
																	readonly="readonly" />
																	
																</td>
																
																
																<td align="left"><b>City:</b><br>
																<input type="text" name="KM"
																	id="KM" readonly size="30" 
																	value="" tabindex="6" class="validate[required] backcolor"
																	maxlength="6" />
																	</td>
															


															</tr>
															<tr>

																<td align="left"><b>Mobile:</b><br>
																<input type="text" name="mobile" class="backcolor"
																	readonly id="mobile" size="30" onchange="checkvalue();"
																	value="" tabindex="6" />
																</td>
																

																<td align="left"><b>Pending Amt:</b><br>
																<input type="text" name="Pendingamt" class="backcolor"
																	id="Pendingamt" readonly size="30" 
																	value="" tabindex="6"
																	maxlength="6" /></td>
																<td align="left"><b>Date: </b><br>
																<input type="text" name="Date"
																	id="to_date" size="30" onblur="FixShortDate(this);return ValidateForm(this);"
																	value="" tabindex="6"  
																	class="validate[required]" />
																</td>
															</tr>

														<tr>
															<td align="left"><b>Address:</b><br>
																	<textarea name="address" class="backcolor"
																	id="address"  size="30" rows="2" cols="23"
																	value="" tabindex="6" 
																	maxlength="916" /></textarea>
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
															
															</tr>
															
															
																<tr>
															<td align="left">
															<input type="checkbox" name="myd1"  id="myd1" onclick="showmyd1(this)" value="myd1" >&nbsp;&nbsp;&nbsp;<b>Details</b>
															&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="checkbox" name="myd2"  id="myd2" onclick="showmyd1(this)" value="myd2"  >&nbsp;&nbsp;&nbsp;<b>Shipment Details</b>
															</td>
															</tr>
															
															<tr id="111"><td align="left"><b>Pay Term:</b><br><input type="text" name="termcond"
																	id="termcond"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" />
																	</td>
															
																
																<td align="left"><b>Vendor:</b><br><input type="text" name="vendor"
																	id="vendor"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
															<td align="left">	<b>Vehicle No:</b><br>
															<input type="text" name="vehino"
																	id="vehino"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
															</tr>
															
															<tr id="222"><td align="left"><b>Dc No</b><br><input type="text" name="dcnox"
																	id="dcnox"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>DC Date:</b><br>
																<input type="text" name="dcdatex"
																	id="dcdatex"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																<td align="left"><b>Transport Mode:</b><br><input type="text" name="transmode"
																	id="transmode"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
															</tr>
															
															<tr id="333"><td align="left"><b>Contact Person:</b><br><input type="text" name="contactp"
																	id="contactp"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>Contact No:</b><br><input type="text" name="contactpno"
																	id="contactpno"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																	
																	
																
															</tr>
															
															<tr id="444">
															
															<td align="left"><b>Ship To party:</b><br><input type="text" name="shipparty"
																	id="shipparty"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
															
															<td align="left"><b>Shipping Address:</b><br><input type="text" name="shipadd"
																	id="shipadd"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
																<td align="left"><b>Ship GSTN No:</b><br><input type="text" name="shipgstn"
																	id="shipgstn"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																	
																	
																
															</tr>
															<tr id="555">

																<td align="left"><b>Ship State:</b><br><input type="text" name="shipstate"
																	id="shipstate"  size="30" 
																	value="" tabindex="6" 
																	maxlength="96" /></td>
																
															</tr>
														</table>
													</td>
												</tr>
											</table>

											<fieldset>
												<label align="left" onclick="toggle('product');"><font
													size="4"> </font> </label>
											</fieldset>
											<fieldset id="product">


												<table id="itemsTable$"  class="general-table$"  >
													<!--  id="itemsTable" class="general-table" -->

													<!--  222222222222222222222222222222222222222222222 -->

													<tr>
														<td align="center">
															<!-- AddRowDataTable -->
															
																<table id="itemsTable"  class="general-table">
																	<tr>

																		<th style="">Delete</th>

																		
																		
																		
																		<% if(partlabour.equals("yes")) {%>
																		<th id="VLsparename"><label>Type</label>
																		</th>
																		<%  }%>
																		
																		<% if(extracolumn.equals("1")) {%>
																		<th id="VLsparename"><label><%=col1 %></label>
																		</th>
																		<%  }%>
																		<% if(extracolumn.equals("2")) {%>
																		<th id="VLsparename"><label><%=col1 %></label>
																		<th id="VLsparename"><label><%=col2 %></label>
																		</th>
																		<%  }%>
																		<% if(extracolumn.equals("3")) {%>
																		<th id="VLsparename"><label><%=col1 %></label>
																		<th id="VLsparename"><label><%=col2 %></label>
																		<th id="VLsparename"><label><%=col3 %></label>
																		</th>
																		<%  }%>
																		
																		<th id="VLsparename"><label>Description</label>
																		</th>
																		
																		<th id="VLsparename"><label>Quantity</label>
																		</th>
																			<th id="VLsparename"><label>Rate</label></th>
																		<th id="VLsparename"><label>Amount</label></th>
																			<% if(discount.equals("yes")) {%>
											<th id="VLsparename"><label>Disc(%)</label></th>
											<th id="VLsparename"><label>Tot Amt</label></th>
																		<%  }%>
																		<th id="VLsparename"><label>HSN Code</label></th>
																		<!-- <th id="VLsparename"><label>GST&nbsp;%&nbsp;</label>
																		</th> -->
																		<!-- <th id="VLsparename"><label>Tax Amount</label></th> -->
																		<th id="VLsparename"><label>Rate</label></th>
																		<th id="VLsparename"><label>Amount</label></th>
																		
																		<th id="VLsparename"><label>Net Amount</label></th>

																	</tr>
																	
																	<tr id= "editdiv" ><td colspan="12"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	
																	
																	<tr class="item-row" >
																	<td style="width:1px;"></td>
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
																			style="width: 60px;" id="partdate" value=""
																			tabindex="10"  /></td>
																		<td><input type="text" name="ib.partnox"
																			style="width: 60px;" id="partnox" value=""
																			tabindex="10"  /></td>
																		</th>
																		<%  }%>
																		


																		<td><input type="text" name="ib.description1"
																			style="width: 250px;" value="" id="description1"
																			tabindex="10" onblur="skipqty(this);"
																			onkeypress="NewSpareServiceOpen(event,this)"  /></td>
																		<td><input type="text" name="ib.quantity1" 
																			style="width: 60px;" id="quantity1" value=""
																			tabindex="11" onblur="getnewsrno(this);" /></td>
																			
																			<td><input type="text" name="ib.myrate"  
																			style="width: 60px;" id="myrate" value=""
																			tabindex="11"  onblur="calculategst(this);gotoadd()"  /></td>
																		<td><input type="text" name="ib.amount1" 
																			id="amount1" value="" readonly
																			tabindex="12"
																			style="width: 60px;" />
																		</td>
																		
																			<% if(discount.equals("yes")) {%>
													<td><input type="text" name="ib.disc"
																			id="disc" value="" tabindex="12"  
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 60px;" />
																		</td>
																		<td><input type="text" name="ib.amtwithdisc" readonly tabindex="12"
																			id="amtwithdisc" onblur="gotoadd1();twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																		</td>
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																		
												
												<%  }else{%>
													<input type="hidden" name="ib.disc"
																			id="disc" value=""  tabindex="12"
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 60px;" />
																			<input type="hidden" name="ib.amtwithdisc" tabindex="12"
																			id="amtwithdisc" onblur="gotoadd1();twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																	
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)" value="" 
																			 
																			style="width: 60px;" />
																		
												
												<% } %>

																		<td><input type="text" value="" name="ib.ttype"   tabindex="12"
																			style="width: 60px;" id="ttype"  onblur="gettaxpercent(this);gotoadd1();" >
																		</td>

																		<input type="hidden" name="ib.vat1" id="vat1" value=""
																			style="width: 60px;" readonly>
																		
																			<td><input name="ib.grate1" id="grate1" value="" 
																			style="width: 60px;" readonly>
																		</td>
																		<td><input name="ib.gstamount1" id="gstamount1" value="" 
																			style="width: 60px;" readonly>
																		</td>
																		<input type="hidden" name="ib.grate2" id="grate2" value="" 
																			style="width: 60px;" readonly>
																		
																		<input type="hidden" name="ib.gstamount2" id="gstamount2" value="" 
																			style="width: 60px;" readonly>


																		<input type="hidden" name="ib.taxqmount1" id="taxqmount1"
																			value="" style="width: 60px;" readonly>

																		<td><input name="ib.vatamount1" id="vatamount1"
																			value=""  onblur="getnewsrno44(this);"
																			style="width: 60px;"></td>

																	</tr>



																	<tbody></tbody>
																</table>
																<table style="width: 550px;">

																	<tr>
																		<td align="left"
																			style="padding-left: 14px; padding-top: 14px;"><a
																			href="#" id="addRow" class="button-clean large"><span>
																					<img id="" tabindex="13"
																					src="Images_4_design/AddRowDataTable/icon-plus.png"
																					alt="Add" title="Add Row" style="margin-left: 0px" />
																					Add Item</span> </a></td>
																	</tr>

																	<tr>
																	
																	
																		<td align="left" style="padding-left:5px;"><b>Total:</b><input name="ib.stot"
																			id="stot"  value="" readonly
																			></td>
																	
																		<td align="left" style="padding-left:5px;"><b>Freight:</b><input name="ib.freight"
																			id="freight"  value="" onblur="totalnetamt();"
																			></td>
																			<td align="left" style="padding-left:5px;"><b>Transport:</b><input name="ib.transport"
																			id="transcharge"  value=""  onblur="totalnetamt();"
																			></td>
																		<td align="left" style="padding-left:5px;"><b>Total&nbsp;Amt:</b><input name="ib.tamount"
																			id="tamount" readonly value=""
																			></td>
																			
																	</tr>
																	
																</table>

															</div> <!-- AddRowDataTable --></td>
														<td></td>
													</tr>


													<tr>
														<td><table>
																<tr>
																	<td class="style2" align="center">Tax</td>
																	
																	<td class="style2" colspan="2" align="center">Tax
																		amount</td>
																</tr>
																<!-- <tr>
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t1" maxlength="8"
																		size="37" value="CGST:" readonly="readonly">
																	</td>
																	<input type="hidden"
																		name="ib.A" id="A1" maxlength="8" size="15"
																		readonly="readonly">
																	
																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A2" maxlength="8" size="15"
																		readonly="readonly">
																	</td>

																</tr> -->



																<tr>
																	<td class="style2" align="center"><input
																		type="text" name="ib.t" id="t2" maxlength="8"
																		size="37" value="IGST:" readonly="readonly">
																	</td>
																	<input type="hidden"
																		name="ib.A" id="A3" maxlength="8" size="15"
																		readonly="readonly">
																	

																	<td colspan="2" align="center"><input type="text"
																		name="ib.A2" id="A4" maxlength="8" size="15"
																		readonly="readonly">
																	</td>
																	
																	<td colspan="2" ALIGN="right"><b>Search :</b></td>
																	<td align="center" colspan="2"><input type="text"
																		name="autoinvoice" id="autoinvoice" maxlength="7"
																		size="30">
																	</td>
																	<td align="left" colspan="2"><input type="button"
																		name="Search" value="Search" class="btn btn-primary"
																		onclick="showspares();" /></td>

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
																		name="ib.A2" id="A17" maxlength="8" size="15"
																		readonly="readonly">
																	</td>
																	
																	<td colspan="2" ALIGN="rght"><b>Invoice No:</b></td>
																	<td align="center" colspan="2"><input type="text"
																		name="invno" id="invno" maxlength="7" size="12">
																	</td>
																	<td colspan="1" ALIGN="LEFT"><b>&nbsp;</b></td>

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


															
																


																<tr>
																	<td colspan="4">

																		<table align="left" id="textfocus">
												 					 	<tr>

																				<td colspan="1" ALIGN="LEFT"><b></b></td>
																				<td><input type="hidden" name="paymod" id="paymod"
																					tabindex="21" onchange="display(this);"
																					align="center" >
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
													
											
										<tr>

											<td colspan="2" align="center">
												<!-- <input type="button"
												class="btn btn-primary" value="Submit" name="submit1" onclick="submitInvoice('submit');"> -->
												
												<input type="button" name="Print" value="Submit"
												id="submitme" class="btn btn-primary"
												onclick="submitInvoice('Print');" />
												<input type="button" name="ReadySMS" value="Ready SMS"
												id="ReadySMS" class="btn btn-primary" onclick="sendsms(Customer_name.value,Vehicle_no.value,tamount.value,mobile.value,invno.value);"
												 />
												</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>


			
																		
																		
																		
																		

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
														myflag11='<td><input type="text" name="ib.disc"	  	id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 60px;" />		</td>';
														myflag22='<td><input type="text" name="ib.amtwithdisc" 		id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 60px;" />		</td>';
															myflag33='<input type="hidden" name="ib.discamt"	 id="discamt" value="" 	 		style="width: 60px;twodecimal(this)" />';
													}else{
														myflag11='<input type="hidden" name="ib.disc"		id="disc" value="" 				onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 				style="width: 60px;" />		';
														myflag22='<input type="hidden" name="ib.amtwithdisc"		id="amtwithdisc" value="" 				onblur="gotoadd1();" 	readonly			style="width: 60px;" />		</td>';
														myflag33='<input type="hidden" name="ib.discamt" 	id="discamt" value="" 	 		style="width: 60px;twodecimal(this)" />';
													}
												
												//alert(myflag);
												
													var $itemsTable = $('#itemsTable');
													var $rowTemp = [
															'<tr class="item-row">',
															
															'<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															myflag,
															col1,
															col2,
															col3,
															/* '<td></select>	<input type="Button"class="btn btn-primary" value="New" onclick="getvehicleno(this);"></td>', */
															'<td><input style="width:250px;" type="text" name="ib.description1"  id="description1"  onblur="skipqty(this);" onkeypress="NewSpareServiceOpen(event,this)"  /></td>',
															'<td><input style="width:60px;" type="text" name="ib.quantity1"  id="quantity1"  value=""  onblur="getnewsrno(this);"  /></td>',
															'<td><input style="width:60px;" type="text" name="ib.myrate"   id="myrate" onblur="calculategst(this);gotoadd()"  value=""  /></td>',
															'<td><input style="width:60px;" type="text" name="ib.amount1"   id="amount1" readonly  value=""  /></td>',
															 myflag11,
										                        myflag22,
										                        myflag33,
															'<td><input type="text"  style="width:60px;" value="" name="ib.ttype"   onblur="gettaxpercent(this);gotoadd1();"  id="ttype" ></td>',
															'<input style="width:60px;" type="hidden" name="ib.vat1"    id="vat1" value="" readonly/>',
															'<td><input type="text"  style="width:60px;" value="" name="ib.grate1" id="grate1"  readonly></td>',
															'<td><input type="text"  style="width:60px;" value="" name="ib.gstamount1" id="gstamount1"  readonly></td>',
															'<input type="hidden"  style="width:60px;" value="" name="ib.grate2" id="grate2"  readonly>',
															'<input type="hidden"  style="width:60px;" value="" name="ib.gstamount2" id="gstamount2"  readonly>',
															'<td><input style="width:60px;" type="text" name="ib.vatamount1"   id="vatamount1" value=""  onblur="getnewsrno44(this);" /></td>',
															'<input type="hidden" name="ib.taxqmount1" id="taxqmount1"				value="" style="width: 60px;" readonly>',
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

																		
																		


								<!----- Submit and Reset ------------------------------------------------->
								
							</table>
						</form>

						<div>






							<!----- Job Card No ---------------------------------------------------------->


						</div>





					</div>

				</div>
			</div>


			

		</div>

<form action="" theme="simple" id="popupContact" method="POST"
							style="width: 700px; position: absolute; border: 1px solid black; z-index: 99; top: 50px; left: 250px; display: block; background-color: #8ebbe1;">


							<table align="center">

								<tr>


									<td colspan="2" align="right"><a id="popupContactClose">x</a>
									</td>


								</tr>

								<!----- Job Card No ---------------------------------------------------------->
								<tr>
									<th><h2>Spare Master</h2></th>
								</tr>

								<tr>
									<td align="left">Spare Name:<input type="text"
										class="form-control" name="sparename" id="sparename"
										maxlength="100" onblur="getsparename(this);" /></td>

									<td align="left">Unit <Select name="unit" id="unit"
										class="form-control">
											<option value="Nag">Nag</option>
											<option value="Litre">Litre</option>
											<option value="Kg">Kg</option>
											<option value="Gm">Gm</option>
											<option value="Ml">Ml</option>
									</Select>
									</td>

									<input type="hidden" class="form-control" name="model"
										id="model" maxlength="20" />



								</tr>

								<!----- Vehicle NO ---------------------------------------------------------->
								<tr>

									<td align="left">Buy price:<input type="text"
										class="form-control" name="comprice" id="comprice"
										onblur="Validatecomprice();" maxlength="5" /></td>
									<td align="left">Sale price:<input type="text"
										class="form-control" name="cprice" id="cprice"
										onblur="Validatecostprice();" maxlength="5" /></td>
								</tr>
								<tr>

									<td align="left">HSN Code:<input type="text"
										class="form-control" name="taxtype" id="taxtype"
										maxlength="20" onblur="gettaxpercent(this,'parts');" /></td>
									<td align="left">Tax%:<input type="text"
										class="form-control" name="taxper" id="taxper" maxlength="20"
										readonly /></td>
								</tr>
								<tr>

									<td align="left">Remark:<input type="text"
										class="form-control" name="remark" id="remark" maxlength="20" />
									</td>
								</tr>


								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh1" id="hh1" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="hh2" id="hh2" maxlength="20" /></td>
								</tr>
								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh3" id="hh3" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="hh4" id="hh4" maxlength="20" /></td>
								</tr>
								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh5" id="hh5" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="" id="" maxlength="20" /></td>
								</tr>
								<!-----  ---------------------------------------------------------->


								<!----- Submit and Reset ------------------------------------------------->
								<tr>
									<td colspan="2" align="center"><input type="button"
										class="btn btn-primary" value="Submit"
										onclick=" return Addinfo(this);"> <input type="reset"
										class="btn btn-primary" value="Reset"><input
										type="button" class="btn btn-primary" value="Cancel"
										onclick="disablePopup();"></td>
								</tr>
							</table>
						</form>



						<form action="" theme="simple" id="popupContact1" method="POST"
							style="width: 700px; position: absolute; border: 1px solid black; z-index: 99; top: 50px; left: 250px; display: block; background-color: #8ebbe1;">


							<table align="center">

								<tr>


									<td colspan="2" align="right"><a id="popupContactClose">x</a>
									</td>


								</tr>

								<!----- Job Card No ---------------------------------------------------------->
								<tr>
									<th><h2>Service Master</h2></th>
								</tr>
								<tr>
									<td align="left">Service Name</td>
									<td><input type="text" name="service_name"
										id="service_name" maxlength="100" required /></td>
								</tr>
								<tr>
									<td align="left">Amount</td>
									<td><input type="text" name="amountsp" id="amountsp"
										maxlength="5" required /></td>
								</tr>

								<tr>
									<td align="left">HSN Code</td>
									<td><input type="text" name="tax_type" id="tax_type"
										maxlength="20" required onblur="gettaxpercent(this,'labour');" />
									</td>
								</tr>

								<tr>
									<td align="left">Tax%:</td>
									<td><input type="text" name="taxpercent" id="taxpercent"
										maxlength="20" required readonly /></td>
								</tr>


								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh8" id="hh8" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="hh2" id="hh2" maxlength="20" /></td>
								</tr>
								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh10" id="hh10" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="hh11" id="hh11" maxlength="20" /></td>
								</tr>
								<tr>
									<td align="left"><input type="hidden" class="form-control"
										name="hh12" id="hh12" maxlength="20" /></td>
									<td align="left"><input type="hidden" class="form-control"
										name="" id="" maxlength="20" /></td>
								</tr>
								<!-----  ---

									
									
									
									<!-----  ---------------------------------------------------------->


								<!----- Submit and Reset ------------------------------------------------->
								<tr>
									<td colspan="2" align="center"><input type="button"
										class="btn btn-primary" value="Submit"
										onclick=" return Addinfo1(this);"> <input type="reset"
										class="btn btn-primary" value="Reset"><input
										type="button" class="btn btn-primary" value="Cancel"
										onclick="disablePopup1();"></td>
								</tr>
							</table>
						</form>


		<div id="backgroundPopup"></div>

	</div>

	<% 
	
	if(manualauto.equals("manual")){
	// manual entry   
	%>
	<script>
	
	
	function getnewsrno(v){
		calculategst(v);
		
	}
	
		function calculategst(v){
			
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
					if(qty!="" && rate1!="" ){
				ttamt= rate1 * qty;
				
				$hoardinglocation = $($traverse_row).find('#amount1');
				$($hoardinglocation).val(ttamt);
				//alert(ttamt);
				
				
				$discrate = $($traverse_row).find('#disc');
				
				if($discrate.val()!="0" && $discrate.val()!=""){
					
					$discamt = $($traverse_row).find('#discamt');
					$amt1 = $($traverse_row).find('#amount1');
					
					$amtwithdisc = $($traverse_row).find('#amtwithdisc');
					
					$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
					
					$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
				
				$discamt.val( $discamt1 );
				
				$amtwithdisc.val( Math.abs($amt1.val()) -  $discamt1 );
				
				ttamt = ttamt - $discamt1;
				
				}else{
				$amtwithdisc = $($traverse_row).find('#amtwithdisc');
				$amt1 = $($traverse_row).find('#amount1');
				$amtwithdisc.val( Math.abs($amt1.val()));
			}
				
				
				
				netamount1=(ttamt*tax1)/ 100;
				
				
				var netamount= netamount1+ttamt;
				
				
				$hoardinglocation5x = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5x).val(netamount.toFixed(2));
				
				 grate=parseFloat(tax1);
				 
				 
				 var gstamount =(ttamt * grate)/100 ;
				 if(!isNaN(grate) &&   grate!=""){
					// alert(grate);
					$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
					//alert(">>>>3");
				/* 	$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2)); */
					}
					
				 
				
				totalnetamt();
				gettaxpercent(v);
				//alert(netamount1);
				//$("#addRow").focus();
					
					
					}
			
		} 

		
		function gettaxpercent(v){
			if (window.XMLHttpRequest) {
				var xp1 = new XMLHttpRequest();
			} else {
				var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
			}
			var $traverse_row = $(v).parents('.item-row');
			$hoardinglocationx1zz = $($traverse_row).find('#ttype');
			var taxtype = $($hoardinglocationx1zz).val();
			
				//alert(taxtype);
				if(taxtype!=""){
			
				//alert(taxtype);
			xp1.open("POST", "gettaxpercent?taxtype="+taxtype+" ");

			
			xp1.send();

			xp1.onreadystatechange = function() {

				if (xp1.readyState == 4 && xp1.status == 200) {
					var rep = xp1.responseText;
					//alert(rep);
					if(rep.trim()!="0" && rep.trim()!="" ){
						
						var $traverse_row = $(v).parents('.item-row');
					var $hoardinglocation = $($traverse_row).find('#vat1');
					$($hoardinglocation).val(rep);
					
					var grate=parseFloat(rep);
					
					$hoardinglocationgrate = $($traverse_row).find('#grate1');
					$($hoardinglocationgrate).val(grate);
					
					/* $hoardinglocationgrate = $($traverse_row).find('#grate2');
					$($hoardinglocationgrate).val(grate); */
					
					
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

						$discrate = $($traverse_row).find('#disc');
						
						if($discrate.val()!="0" && $discrate.val()!=""){
							
							$discamt = $($traverse_row).find('#discamt');
							$amt1 = $($traverse_row).find('#amount1');
							
							$amtwithdisc = $($traverse_row).find('#amtwithdisc');
							
							$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
							
							$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
						
						$discamt.val( $discamt1 );
						
						$amtwithdisc.val( Math.abs($amt1.val()) -  $discamt1 );
						
						ttamt = ttamt - $discamt1;
						
						}else{
							$amtwithdisc = $($traverse_row).find('#amtwithdisc');
							$amt1 = $($traverse_row).find('#amount1');
							$amtwithdisc.val( Math.abs($amt1.val()));
						}
						
						
						
						
						
						netamount1=(ttamt*tax1)/ 100;
						
						
						var netamount= netamount1+ttamt;
						
						
						$hoardinglocation5x = $($traverse_row).find('#vatamount1');
						$($hoardinglocation5x).val(netamount.toFixed(2));
						
						 grate=parseFloat(tax1);
						 
						 
						 var gstamount =(ttamt * grate)/100 ;
							
							$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
							$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
							
							/* $hoardinglocationgrate = $($traverse_row).find('#gstamount2');
							$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2)); */
					
							
						 
						
						totalnetamt();
						//alert(netamount1);
						$("#addRow").focus();
					
					
					
					
					}
				}
		

			};
			
			
				}
			
			
		}	
	
	
	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<%
	
	}else{
		
	
	if(partlabour.equals("yes")){ %>
	<script>
	
	


	function gettaxpercent(v,type){
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
				if(type=='parts'){
				document.getElementById("taxper").value=rep;
				}else{
					
					document.getElementById("taxpercent").value=rep;	
				}
			}

		};
		
	}	
	
	 function calculategst(v){
		
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
					if(qty!="" && rate1!="" ){
				ttamt= rate1 * qty;
				//alert(ttamt);
					$hoardinglocation = $($traverse_row).find('#amount1');
			$($hoardinglocation).val(ttamt);
			
				netamount1=(ttamt*tax1)/ 100;
				
				$hoardinglocation = $($traverse_row).find('#amount1');
				$($hoardinglocation).val(ttamt);
				var netamount= netamount1+ttamt;
				
				
				$hoardinglocation5x = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5x).val(netamount.toFixed(2));
				
				 grate=parseFloat(tax1);
				 
				
				 var gstamount =(ttamt * grate)/100 ;
				 if(!isNaN(grate) &&   grate!=""){
					$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
					//alert(">>>>1");
					/* $hoardinglocationgrate = $($traverse_row).find('#gstamount2');
					$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2)); */
			
				 }
				 
				
				totalnetamt();
				//alert(netamount1);
				$("#addRow").focus();
					}
					
				
	}  

	function getnewsrno(v) {
		//alert("1" + v);

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		

		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#description1');

		var $hoardinglocation1 = $($traverse_row).find('#quantity1');
		var $hoardinglocation2 = $($traverse_row).find('#amount1');
		var $hoardinglocation3 = $($traverse_row).find('#vat1');
		var $hoardinglocation4 = $($traverse_row).find('#taxqmount1');
		var $hoardinglocation5 = $($traverse_row).find('#vatamount1');
		var $hoardinglocation6 = $($traverse_row).find('#btype');
		var $hoardinglocation7 = $($traverse_row).find('#ttype');
		
		
		var Spare_name=$($hoardinglocation).val();
		Spare_name=Spare_name.replace(/\%/g, "%25") ;
		 Spare_name = Spare_name.replace(/\&/g, '%26');
		 Spare_name = Spare_name.replace(/\&/g, '%26');
		 
		 Spare_name=Spare_name.replace(/\:/g, "%3A") ;
		 
		 Spare_name=Spare_name.replace(/\"/g, "%22") ;
		 
		// Spare_name=Spare_name.replace(/\%/g, "%25") ;
		 
		 Spare_name=Spare_name.replace(/\@/g, "%40") ;
		
		 Spare_name=Spare_name.replace(/\#/g, "%23") ;
		 Spare_name=Spare_name.replace(/\#/g, "%23") ;
		 
		 Spare_name=Spare_name.replace(/\+/g, "%2B") ;
		 
		 Spare_name=Spare_name.replace(/\+/g, "%2B") ;
		 
		xp1.open("POST", "getpmsamount1?description="
				+ Spare_name + "&qty="
				+ $($hoardinglocation1).val() + "&btype="
				+ $($hoardinglocation6).val());

	/*  alert("getpmsamount1?description="
			+ $($hoardinglocation).val() + "&qty="
			+ $($hoardinglocation1).val() + "&btype="
			+ $($hoardinglocation6).val());  */
		xp1.send();

		xp1.onreadystatechange = function() {

			if (xp1.readyState == 4 && xp1.status == 200) {
				var rep = xp1.responseText;
				//	alert("rep"+rep);
				var parts = new Array();
				//alert("2");
				parts = rep.split("^");

				var rate1 = parts[0];
				//alert("rate1" + rate1);

				var tax1 = parts[1];
				var ttype = parts[2];
				 var partno =parts[3];
				//alert("tax1" + tax1);
				var netamount = 0;
				var netamount1 = 0;
				var netamount2 = 0;
				var netamount3 = 0;
				var amount=0;
				var grate=0;
				var amount1=0;
				var  ttamt=0;
				$traverse_row = $(v).parents('.item-row');
				$hoardinglocationxs = $($traverse_row).find('#btype');
				$hoardinglocationx1 = $($traverse_row).find('#vatamount1');
				$hoardinglocationx = $($traverse_row).find('#quantity1');
				
				 $hoardinglocationxp = $($traverse_row).find('#partnox');
					$($hoardinglocationxp).val(partno); 
					
				//alert($($hoardinglocationxs).val());
				if ($($hoardinglocationxs).val() == "parts") {
					//alert(">>>>>"+$($hoardinglocationxs).val());

				

					var qty = $($hoardinglocationx).val();
					var partsamount = $($hoardinglocationx1).val();
					//if (partsamount == "") {
					netamount = rate1 * qty;
					ttamt= rate1 * qty;
					var y="100";
					var k=parseFloat(y);
					//alert(">>>>>"+k);
					var j= parseFloat(tax1);
					
					 grate=parseFloat(tax1);
					//alert(">>>"+j);
					var x= k+j;
					amount =(ttamt / x)*100 ;
				
					//alert(">>>>>"+amount);
					
					netamount1=(ttamt*tax1)/ 100;
					//alert(">>>>>"+netamount1);
					amount1=  Math.abs(amount).toFixed(2);
					netamount3= Math.abs(netamount1).toFixed(2);
					 
					$hoardinglocationgrate = $($traverse_row).find('#grate1');
					$($hoardinglocationgrate).val(grate);
					
					$hoardinglocationgrate = $($traverse_row).find('#grate2');
					$($hoardinglocationgrate).val(grate);
					
					
					
					
					
					$hoardinglocationlx = $($traverse_row).find('#myrate');
					
					$($hoardinglocationlx).focus();
					

				} else {
					/* var rep = xp1.responseText;
					//	alert("rep"+rep);
					var parts = new Array();
					//alert("2");
					parts = rep.split("^");

					var amount = parts[2];
					//alert("rate1" + rate1);

					var tax1 = parts[1];
					var ttype = parts[0]; */
					 
					 
					 
					 
				}
				 $hoardinglocation = $($traverse_row).find('#ttype');
					$($hoardinglocation7).val(ttype);
					
				$hoardinglocation = $($traverse_row).find('#amount1');
				$($hoardinglocation2).val(ttamt);
				
				
				var gstamount =(amount1 * grate)/100 ;
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				var qty = $($hoardinglocationx).val();
				var myrate =(amount1 / qty)
				
				$hoardinglocationgrate = $($traverse_row).find('#myrate');
				$($hoardinglocationgrate).val( Math.abs(rate1).toFixed(2));

				$hoardinglocation = $($traverse_row).find('#vat1');
				$($hoardinglocation3).val(tax1);
				
				
				netamount= gstamount+ttamt;
				
				
				/* $hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(netamount3.toFixed(2)); */
				
				
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount.toFixed(2));
				
				
				
				totalnetamt();
				
			/* 	$hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(amount);
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount); */
				//alert(">>>>1");totalnetamt
					
				
				
			 $hoardinglocationq = $($traverse_row).find('#myrate');
			// alert(">>>>"+$($hoardinglocationq).val());
				//if ($($hoardinglocationq).val() == "" || $($hoardinglocationq).val() == "0.0" || $($hoardinglocationq).val() == "0.00") {
					//$($hoardinglocationq).val("0");
					$($hoardinglocationq).focus();
					$($hoardinglocationq).select();
					
				//} else {
					//alert(">>>>");
				
					//$("#addRow").focus();
				//} 
				 
				

			
				//alert(">>>>2");

				//alert("4");
				/* var parts=rep.split("~");

				 //alert(">>>>");
				 var $traverse_row = $(a).parents('.item-row');
				 var $hoardinglocation= $($traverse_row).find('#price');
				 $($hoardinglocation).val(parts[1]);
				 var $hoardinglocation1= $($traverse_row).find('#currentqty');
				 $($hoardinglocation1).val(parts[0]); */

				//document.getElementById("price").value=parts[1];
				///document.getElementById("currentqty").value=parts[0];
			}
			
			

		};
	}
				
function skipqty(v){

		
	
		
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#btype');
		var $hoardinglocationa = $($traverse_row).find('#vatamount1');
		var $hoardinglocationx = $($traverse_row).find('#description1');
		if($($hoardinglocation).val()=="labour" && $($hoardinglocationx).val()!=""){
			//-------------------------------------------------------------------------
			
			//getnewsrno1(v);
			
			
			
			
			//-----------------------------------------------------------------------------
		//	$($hoardinglocationa).focus();
		}else{
			var desc=$(v).val();
			
			
			parts=desc.split("~");
			
			desc = parts[0].trim();
			desc = desc.replace("<td width='200px'>", "");
			desc = desc.replace("<tr>", "");
			desc = desc.trim();
			$(v).val(desc);
		}
		
		
		var ths = $(v).val();
    	var t = 0;
    	 $('.item-row').each(function(i,row){
    		 //alert("1234567");
    		 var $vid = $(row).find('#description1');
    		 
    		 
    		 if($($vid).val()==ths)
     		{
     		t=t+1;
     		}
    	 });
    	
    	/*  if(t>1){
    		alert("Please don't Repeat Description");
    		 $(v).val('');
    		 $(v).focus();
    	 } */
		
		
		
		
    	 }
    	 
    	 
    	 
function getnewsrno44(v) {
	//alert("1" + v);

	
	

	var $traverse_row = $(v).parents('.item-row');
	var $hoardinglocation = $($traverse_row).find('#description1');

	var $hoardinglocation1 = $($traverse_row).find('#quantity1');
	var $hoardinglocation2 = $($traverse_row).find('#amount1');
	var $hoardinglocation3 = $($traverse_row).find('#vat1');
	var $hoardinglocation4 = $($traverse_row).find('#taxqmount1');
	var $hoardinglocation5 = $($traverse_row).find('#vatamount1');
	var $hoardinglocation6 = $($traverse_row).find('#btype');
	var $hoardinglocation7 = $($traverse_row).find('#ttype');
	
			//alert("tax1" + tax1);
			var netamount = 0;
			var amount=0;
			var grate=0;
			var tax1=$($hoardinglocation3).val();
			var  ttype=$($hoardinglocation7).val();
			$traverse_row = $(v).parents('.item-row');
			$hoardinglocationxs = $($traverse_row).find('#btype');
			$hoardinglocationx1 = $($traverse_row).find('#vatamount1');
			$hoardinglocationx = $($traverse_row).find('#quantity1');
			var qty = $($hoardinglocationx).val();
			//alert($($hoardinglocationxs).val());
			if ($($hoardinglocationxs).val() == "parts") {
				//alert(">>>>>"+$($hoardinglocationxs).val());

			

				
				var partsamount = $($hoardinglocationx1).val();
				if (partsamount == "") {
								netamount =  Math.abs(rate1).toFixed(2);  
								//alert("amount"+amount);
								// var total1 = (tax1) * amount; 
								var y="100";
								var k=parseFloat(y);
								//alert(">>>>>"+k);
								var j= parseFloat(tax1);
								//alert(">>>"+j);
								var x= k+j;
								amount =(netamount / x)*100;
								amount1=  Math.abs(amount).toFixed(2);
								
								netamount1=(amount*tax1)/ 100;
								netamount3= Math.abs(netamount1).toFixed(2);
								
								
								 grate=parseFloat(tax1)/2;
								
				
				
				
				
				}else{
					
					netamount = Math.abs(partsamount).toFixed(2); 
					//alert("amount"+amount);
					// var total1 = (tax1) * amount; 
					// var total1 = (tax1) * amount; 
					var y="100";
				var k=parseFloat(y);
				//alert(">>>>>"+k);
				var j= parseFloat(tax1);
				//alert(">>>"+j);
				var x= k+j;
					amount =(netamount / x)*100;
					 grate=parseFloat(tax1)/2;
					
					amount1=  Math.abs(amount).toFixed(2);
					
					netamount1=(amount*tax1)/ 100;
					netamount3= Math.abs(netamount1).toFixed(2);
					
					
				}
				
				$hoardinglocationgrate = $($traverse_row).find('#grate1');
				$($hoardinglocationgrate).val(grate);
				
				$hoardinglocationgrate = $($traverse_row).find('#grate2');
				$($hoardinglocationgrate).val(grate);
				
				var gstamount =(amount1 * grate)/100 ;
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocation = $($traverse_row).find('#amount1');
				$($hoardinglocation2).val(amount1);
				
				 qty = $($hoardinglocationx).val();
				var myrate =(amount1 / qty)
				
				
				//$hoardinglocationgrate = $($traverse_row).find('#myrate');
				//$($hoardinglocationgrate).val( Math.abs(myrate).toFixed(2));

			  $hoardinglocation = $($traverse_row).find('#vat1');
				$($hoardinglocation3).val(tax1); 
				$hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(netamount3);
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount);
				
				
			 $hoardinglocation = $($traverse_row).find('#ttype');
				$($hoardinglocation7).val(ttype);
				
				totalnetamt();
				
			/* 	$hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(amount);
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount); */
				//alert(">>>>1");totalnetamt
					
				
				
			$hoardinglocationq = $($traverse_row).find('#amount1');
				
				
				if ($($hoardinglocationq).val() == "") {
					$($hoardinglocationq).val("0");
				} else {
					$("#addRow").focus();
				}
				 
				
			
				
				

			} else {
			 	
			 	$hoardinglocationq = $($traverse_row).find('#vatamount1');
				var amount = $($hoardinglocationq).val();
				
				$taxxx = $($traverse_row).find('#vat1');
				var tax1 = $($taxxx).val();
				
				
				var amount1 = (tax1 * amount) / 100;
				var netamt = amount * 1;
				//var netamount = rate1 * qty;
				
				// var total1 = (tax1) * amount; 
				 grate=parseFloat(tax1)/2;
				var gstamount =(amount * grate)/100 ;
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				

				$hoardinglocationq1 = $($traverse_row).find('#taxqmount1');
				$($hoardinglocationq1).val(amount1.toFixed(2));
				
				var total1 = (netamt + amount1);
				
				$hoardinglocationq11 = $($traverse_row).find('#vatamount1');
				$($hoardinglocationq11).val(total1.toFixed(2));
				
				//alert(amount);
				
				$hoardinglocationq121 = $($traverse_row).find('#amount1');
				//alert(">>>1");
				$($hoardinglocationq121).val(amount);
				
				
				
				
				//$hoardinglocationgrate = $($traverse_row).find('#myrate');
				//$($hoardinglocationgrate).val( Math.abs(amount).toFixed(2));
				
				
				
				
				//alert(">>>");
				totalnetamt();
				//$("#addRow").focus();
				 
			}

			
			//alert(">>>>2");

			//alert("4");
			/* var parts=rep.split("~");

			 //alert(">>>>");
			 var $traverse_row = $(a).parents('.item-row');
			 var $hoardinglocation= $($traverse_row).find('#price');
			 $($hoardinglocation).val(parts[1]);
			 var $hoardinglocation1= $($traverse_row).find('#currentqty');
			 $($hoardinglocation1).val(parts[0]); */

			//document.getElementById("price").value=parts[1];
			///document.getElementById("currentqty").value=parts[0];
		//	$("#addRow").focus();
		}
	
	</script>
	
	<%}else{ %>
	
	
	
	
	
	
	<script>



	function gettaxpercent(v,type){
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
				if(type=='parts'){
				document.getElementById("taxper").value=rep;
				}else{
					
					document.getElementById("taxpercent").value=rep;	
				}
			}

		};
		
	}	
	function calculategst(v){
		
		var $traverse_row = $(v).parents('.item-row');
		
			//alert(">>>");
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
				if(qty!="" && rate1!="" ){
			ttamt= rate1 * qty;
			
			$hoardinglocation = $($traverse_row).find('#amount1');
			$($hoardinglocation).val(ttamt);
			
			
			$discrate = $($traverse_row).find('#disc');
			
			if($discrate.val()!="0" && $discrate.val()!=""){
				
				$discamt = $($traverse_row).find('#discamt');
				$amt1 = $($traverse_row).find('#amount1');
				
				$amtwithdisc = $($traverse_row).find('#amtwithdisc');
				
				$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
				
				$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
			
			$discamt.val( $discamt1 );
			
			$amtwithdisc.val( Math.abs($amt1.val()) -  $discamt1 );
			
			ttamt = ttamt - $discamt1;
			
			}else{
				$amtwithdisc = $($traverse_row).find('#amtwithdisc');
				$amt1 = $($traverse_row).find('#amount1');
				$amtwithdisc.val( Math.abs($amt1.val()));
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			//alert(ttamt);
			netamount1=(ttamt*tax1)/ 100;
			
			
			var netamount= netamount1+ttamt;
			
			
			$hoardinglocation5x = $($traverse_row).find('#vatamount1');
			$($hoardinglocation5x).val(netamount.toFixed(2));
			
			 grate=parseFloat(tax1);
			 
			
			 var gstamount =(ttamt * grate)/100 ;
				
			 
			 if(!isNaN(grate) &&   grate!=""){
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				//alert(">>>>2");
				/* $hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2)); */
			 }
				
			 
			
			totalnetamt();
			//alert(netamount1);
			//$("#addRow").focus();
				}
	} 
	
	
	
	
	

	function getnewsrno(v) {
		//alert("1" + v);

		//alert("1" + v);

		if (window.XMLHttpRequest) {
			var xp1 = new XMLHttpRequest();
		} else {
			var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		
		

		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#description1');

		var $hoardinglocation1 = $($traverse_row).find('#quantity1');
		var $hoardinglocation2 = $($traverse_row).find('#amount1');
		var $hoardinglocation3 = $($traverse_row).find('#vat1');
		var $hoardinglocation4 = $($traverse_row).find('#taxqmount1');
		var $hoardinglocation5 = $($traverse_row).find('#vatamount1');
		var $hoardinglocation6 = $($traverse_row).find('#btype');
		var $hoardinglocation7 = $($traverse_row).find('#ttype');
		
		var Spare_name=$($hoardinglocation).val();
		Spare_name=Spare_name.replace(/\%/g, "%25") ;
		 Spare_name = Spare_name.replace(/\&/g, '%26');
		 Spare_name = Spare_name.replace(/\&/g, '%26');
		 
		 Spare_name=Spare_name.replace(/\:/g, "%3A") ;
		 
		 Spare_name=Spare_name.replace(/\"/g, "%22") ;
		 
		// Spare_name=Spare_name.replace(/\%/g, "%25") ;
		 
		 Spare_name=Spare_name.replace(/\@/g, "%40") ;
		
		 Spare_name=Spare_name.replace(/\#/g, "%23") ;
		 Spare_name=Spare_name.replace(/\#/g, "%23") ;
		 Spare_name=Spare_name.replace(/\+/g, "%2B") ;
		 
		 Spare_name=Spare_name.replace(/\+/g, "%2B") ;
		 
		xp1.open("POST", "getpmsamount1?description="
				+ Spare_name + "&qty="
				+ $($hoardinglocation1).val() + "&btype="
				+ $($hoardinglocation6).val());

	/*  alert("getpmsamount1?description="
			+ $($hoardinglocation).val() + "&qty="
			+ $($hoardinglocation1).val() + "&btype="
			+ $($hoardinglocation6).val());  */
		xp1.send();

		xp1.onreadystatechange = function() {

			if (xp1.readyState == 4 && xp1.status == 200) {
				var rep = xp1.responseText;
				//	alert("rep"+rep);
				var parts = new Array();
				//alert("2");
				parts = rep.split("^");

				var rate1 = parts[0];
				//alert("rate1" + rate1);

				var tax1 = parts[1];
				var ttype = parts[2];
				 var partno =parts[3];
				//alert("tax1" + tax1);
				var netamount = 0;
				var netamount1 = 0;
				var netamount2 = 0;
				var netamount3 = 0;
				var amount=0;
				var grate=0;
				var amount1=0;
				var  ttamt=0;
				$traverse_row = $(v).parents('.item-row');
				$hoardinglocationxs = $($traverse_row).find('#btype');
				$hoardinglocationx1 = $($traverse_row).find('#vatamount1');
				$hoardinglocationx = $($traverse_row).find('#quantity1');
				
				 $hoardinglocationxp = $($traverse_row).find('#partnox');
					$($hoardinglocationxp).val(partno); 
					
				//alert($($hoardinglocationxs).val());
				if ($($hoardinglocationxs).val() == "parts") {
					//alert(">>>>>"+$($hoardinglocationxs).val());

				

					var qty = $($hoardinglocationx).val();
					var partsamount = $($hoardinglocationx1).val();
					//if (partsamount == "") {
					netamount = rate1 * qty;
					ttamt= rate1 * qty;
					var y="100";
					var k=parseFloat(y);
					//alert(">>>>>"+k);
					var j= parseFloat(tax1);
					
					 grate=parseFloat(tax1);
					//alert(">>>"+j);
					var x= k+j;
					
					$hoardinglocation = $($traverse_row).find('#amount1');
					$($hoardinglocation2).val(ttamt);
					
					$discrate = $($traverse_row).find('#disc');
					
					if($discrate.val()!="0" && $discrate.val()!=""){
						
						$discamt = $($traverse_row).find('#discamt');
						$amt1 = $($traverse_row).find('#amount1');
						
						$amtwithdisc = $($traverse_row).find('#amtwithdisc');
						
						$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
						
						$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
					
					$discamt.val( $discamt1 );
					
					$amtwithdisc.val( Math.abs($amt1.val()) -  $discamt1 );
					
					ttamt = ttamt - $discamt1;
					
					}else{
						$amtwithdisc = $($traverse_row).find('#amtwithdisc');
						$amt1 = $($traverse_row).find('#amount1');
						$amtwithdisc.val( Math.abs($amt1.val()));
					}
					
					
					
					
					
					
					
					
					
					
					
					amount =(ttamt / x)*100 ;
				
					//alert(">>>>>"+amount);
					
					netamount1=(ttamt*tax1)/ 100;
					//alert(">>>>>"+netamount1);
					amount1=  Math.abs(amount).toFixed(2);
					netamount3= Math.abs(netamount1).toFixed(2);
					 
					$hoardinglocationgrate = $($traverse_row).find('#grate1');
					$($hoardinglocationgrate).val(grate);
					
					$hoardinglocationgrate = $($traverse_row).find('#grate2');
					$($hoardinglocationgrate).val(grate);
					
					
					
					
					
					$hoardinglocationlx = $($traverse_row).find('#myrate');
					
					$($hoardinglocationlx).focus();
					

				} else {
					/* var rep = xp1.responseText;
					//	alert("rep"+rep);
					var parts = new Array();
					//alert("2");
					parts = rep.split("^");

					var amount = parts[2];
					//alert("rate1" + rate1);

					var tax1 = parts[1];
					var ttype = parts[0]; */
					 
					 
					 
					 
				}
				 $hoardinglocation = $($traverse_row).find('#ttype');
					$($hoardinglocation7).val(ttype);
					
			
				
				
				
				
				
				var gstamount =(amount1 * grate)/100 ;
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount1');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				$hoardinglocationgrate = $($traverse_row).find('#gstamount2');
				$($hoardinglocationgrate).val( Math.abs(gstamount).toFixed(2));
				
				var qty = $($hoardinglocationx).val();
				var myrate =(amount1 / qty)
				
				$hoardinglocationgrate = $($traverse_row).find('#myrate');
				$($hoardinglocationgrate).val( Math.abs(rate1).toFixed(2));

				$hoardinglocation = $($traverse_row).find('#vat1');
				$($hoardinglocation3).val(tax1);
				
				
				netamount= gstamount+ttamt;
				
				
				/* $hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(netamount3.toFixed(2)); */
				
				
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount.toFixed(2));
				
				calculategst(v);
				
				totalnetamt();
				
			/* 	$hoardinglocation = $($traverse_row).find('#taxqmount1');
				$($hoardinglocation4).val(amount);
				$hoardinglocation = $($traverse_row).find('#vatamount1');
				$($hoardinglocation5).val(netamount); */
				//alert(">>>>1");totalnetamt
					
				
				
			 $hoardinglocationq = $($traverse_row).find('#myrate');
			// alert(">>>>"+$($hoardinglocationq).val());
				//if ($($hoardinglocationq).val() == "" || $($hoardinglocationq).val() == "0.0" || $($hoardinglocationq).val() == "0.00") {
					//$($hoardinglocationq).val("0");
					//$($hoardinglocationq).focus();
					//$($hoardinglocationq).select();
					
				//} else {
					//alert(">>>>");
				
					//$("#addRow").focus();
				//} 
				 
				

			
				//alert(">>>>2");

				//alert("4");
				/* var parts=rep.split("~");

				 //alert(">>>>");
				 var $traverse_row = $(a).parents('.item-row');
				 var $hoardinglocation= $($traverse_row).find('#price');
				 $($hoardinglocation).val(parts[1]);
				 var $hoardinglocation1= $($traverse_row).find('#currentqty');
				 $($hoardinglocation1).val(parts[0]); */

				//document.getElementById("price").value=parts[1];
				///document.getElementById("currentqty").value=parts[0];
			}
			
			

		};
		
	}
		
		
function skipqty(v){

		
		
		
		var $traverse_row = $(v).parents('.item-row');
		var $hoardinglocation = $($traverse_row).find('#btype');
		var $hoardinglocationa = $($traverse_row).find('#vatamount1');
		var $hoardinglocationx = $($traverse_row).find('#description1');
		if($($hoardinglocation).val()=="labour" && $($hoardinglocationx).val()!=""){
			//-------------------------------------------------------------------------
			
			getnewsrno1(v);
			
			
			
			
			//-----------------------------------------------------------------------------
			$($hoardinglocationa).focus();
		}else{
			var desc=$(v).val();
			
			
			parts=desc.split("~");
			
			desc = parts[0].trim();
			desc = desc.replace("<td width='200px'>", "");
			desc = desc.replace("<tr>", "");
			desc = desc.trim();
			$(v).val(desc);
		}
		
		
		var ths = $(v).val();
    	var t = 0;
    	 $('.item-row').each(function(i,row){
    		 //alert("1234567");
    		 var $vid = $(row).find('#description1');
    		 
    		 
    		 if($($vid).val()==ths)
     		{
     		t=t+1;
     		}
    	 });
    	
    	 if(t>1){
    		alert("Please don't Repeat Description");
    		 $(v).val('');
    		 $(v).focus();
    	 }
		
		
		
		
    	 }
	
	</script>
	
	<%} %>
	
	
	
	<%} %>
	
	
	<script>
	
	function getnewsrno1xxx(v) {
		
		var	amt = 0;
		var $traverse_row = $(v).parents('.item-row');
		
		$discrate = $($traverse_row).find('#disc');
		
		if($discrate.val()!="0" && $discrate.val()!=""){
			
			$discamt = $($traverse_row).find('#discamt');
			$amt1 = $($traverse_row).find('#amount1');
			$amtwithdisc = $($traverse_row).find('#amtwithdisc');
			
			
			$discamt.val(  (  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100  );
			
			$discamt1=(  Math.abs($discrate.val())  *  Math.abs($amt1.val())  )/100;
		
		$discamt.val( $discamt1 );
		
		$amtwithdisc.val(   Math.abs($amt1.val())  -$discamt1   );
		
		
		}else{
			$amtwithdisc = $($traverse_row).find('#amtwithdisc');
			$amt1 = $($traverse_row).find('#amount1');
			$amtwithdisc.val( Math.abs($amt1.val()));
		}
		calculategst(v);
		
		}

	
	</script>
	
	<% if (discount.equals("no") ){ %>
 <script>
 function gotoadd(){
		
	if( document.getElementById("manualauto").value=="manual"){
		
		
	}else{
		
		$("#addRow").focus();
	}
	
	}
 </script>
 <%} else {%>
  <script>
 function gotoadd1(){
		
	
	 if( document.getElementById("manualauto").value=="manual"){
			
			
		}else{
			
			$("#addRow").focus();
		}
	
	
	}
 </script>
 
 <% } %>
	
</body>
</html>

