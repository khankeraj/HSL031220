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



 <script type="text/javascript">
	
	$(function() {
		
		$("#role_name").autocomplete("GoogleSearch/assigned_role.jsp");
		
		
		
	});
</script>  

<script>
		$(function () {
			$('#supported').text('Supported/allowed: ' + !!screenfull.enabled);

			if (!screenfull.enabled) {
				return false;
			}
			$('#toggle').click(function () {
				screenfull.toggle($('#container')[0]);
			});	
		});
		</script>


<script type="text/javascript">


jQuery(document).ready(function(){
	// binds form submission and fields to the validation engine
	//jQuery("#formID").validationEngine();
});

function checkHELLO(field, rules, i, options){
	if (field.val() != "HELLO") {
		// this allows to use i18 for the error msgs
		return options.allrules.validate2fields.alertText;
	}
}




	function selectvalue(a) {

		if (a == "All-Zones") {
			$("#city_name").val('Own-City'); 
			 $("#offices").val('Own-Office'); 
			$("#departments").val('Own-Deparment');
			$("#userdata").val('Own-User');
		 $("#cityssrow").hide("fast"); 
			$("#officesrow").hide("fast");
			$("#departmentsrow").hide("fast");
			$("#userdatarow").hide("fast");
		} else if (a == "Own-Zone") {
		 $("#cityssrow").show("fast"); 
			$("#officesrow").show("fast");
			$("#departmentsrow").show("fast");
			$("#userdatarow").show("fast");
		} 
	 else if (a == "All-Citys") {
			$("#offices").val('Own-Office');
			$("#departments").val('Own-Deparment');
			$("#userdata").val('Own-User');
			$("#officesrow").hide("fast");
			$("#departmentsrow").hide("fast");
			$("#userdatarow").hide("fast"); 
		 } else if (a == "Own-City") {
			$("#officesrow").show("fast");
			$("#departmentsrow").show("fast");
			$("#userdatarow").show("fast");} 
	
		else if (a == "All-Offices") {
			$("#departments").val('Own-Deparment');
			$("#userdata").val('Own-User');
			$("#departmentsrow").hide("fast");
			$("#userdatarow").hide("fast");
		} else if (a == "Own-Office") {
			$("#departmentsrow").show("fast");
			$("#userdatarow").show("fast");
		} else if (a == "All-Departments") {
			$("#userdata").val('Own-User');
			$("#userdatarow").hide("fast");
		} else if (a == "Own-Deparment") {
			$("#userdatarow").show("fast");
		}

	}
	
	
	function savevalue()
	{
		  /* var role_name = $("#role_name").val();
		  alert(role_name);
		var new_role=  $("#username").val();
		
		 new_role=role_name; */
		 var travel = document.getElementById("role_name").value;
		    var days;
		    var result = "";
		    

		   
		    
		        document.getElementById("username").value =travel;
		    
		
	}
	function checkAll(input) {
		try {
			if ($(input).attr("name") == "usersAll")
				$('.user_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "assembly")
				$('.assembly_info input:checkbox').each(function(i, checkbox) {
					if ($(input).attr("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});

			if ($(input).attr("name") == "masters")
				$('.master_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "sales")
				$('.sale_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "purchases")
				$('.purchase_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "services")
				$('.service_info  input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "hrs")
				$('.HR_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			
			if ($(input).attr("name") == "Complain")
				$('.Complain_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "status")
				$('.status_info input:checkbox').each(function(i, checkbox) {
					if ($(input).attr("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "deal")
				$('.deal_info input:checkbox').each(function(i, checkbox) {
					if ($(input).attr("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});

			if ($(input).attr("name") == "admins")
				$('.admin_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			
			
			if ($(input).attr("name") == "admins1")
				$('.admin_info1 input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			
			
			if ($(input).attr("name") == "rpts")
				$('.stat_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			
			if ($(input).attr("name") == "acc")
				$('.acc_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "rt")
				$('.rt_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			if ($(input).attr("name") == "dt")
				$('.dt_info input:checkbox').each(function(i, checkbox) {
					if ($(input).prop("checked"))
						$(checkbox).prop("checked", true);
					else
						$(checkbox).prop("checked", false);
				});
			
			
		} catch (er) {
			alert(er);
		}

	}
	function expandAll(input) {
		try {
			//alert($(input).attr("name"));
			if ($(input).attr("name") == "userimg")

				$('.user_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#userimgdown").show("fast");
						$("#userimgright").hide("fast");
					} else {

						$(tr).hide();

						$("#userimgdown").hide("fast");
						$("#userimgright").show("fast");
					}
				}

				);

			else {

				if ($(input).attr("name") == "masters")

					$('.master_info').each(function(i, tr)

					{

						if ($(tr).is(':hidden')) {

							$(tr).show();

							$("#mastersdown").show("fast");
							$("#mastersright").hide("fast");
						} else {

							$(tr).hide();

							$("#mastersdown").hide("fast");
							$("#mastersright").show("fast");
						}

					});
			}
			if ($(input).attr("name") == "statusimg")

				$('.status_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#statusimgdown").show("fast");
						$("#statusimgright").hide("fast");
					} else {

						$(tr).hide();

						$("#statusimgdown").hide("fast");
						$("#statusimgright").show("fast");
					}
				}

				);
			if ($(input).attr("name") == "dealimg")

				$('.deal_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#dealimgdown").show("fast");
						$("#dealimgright").hide("fast");
					} else {

						$(tr).hide();

						$("#dealimgdown").hide("fast");
						$("#dealimgright").show("fast");
					}
				}

				);
			if ($(input).attr("name") == "assemblyimg")

				$('.assembly_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#assemblyimgdown").show("fast");
						$("#assemblyimgright").hide("fast");
					} else {

						$(tr).hide();

						$("#assemblyimgdown").hide("fast");
						$("#assemblyimgright").show("fast");
					}
				}

				);
			if ($(input).attr("name") == "sales")

				$('.sale_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#salesdown").show("fast");
						$("#salesright").hide("fast");
					} else {

						$(tr).hide();

						$("#salesdown").hide("fast");
						$("#salesright").show("fast");
					}

				});
			if ($(input).attr("name") == "acc")

				$('.acc_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#accdown").show("fast");
						$("#accright").hide("fast");
					} else {

						$(tr).hide();

						$("#accdown").hide("fast");
						$("#accright").show("fast");
					}

				});
			if ($(input).attr("name") == "purchases")

				$('.purchase_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#purchasesdown").show("fast");
						$("#purchasesright").hide("fast");
					} else {

						$(tr).hide();

						$("#purchasesdown").hide("fast");
						$("#purchasesright").show("fast");
					}

				});
			
			
			if ($(input).attr("name") == "rpts")

				$('.stat_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#rptsdown").show("fast");
						$("#rptsright").hide("fast");
					} else {

						$(tr).hide();

						$("#rptsdown").hide("fast");
						$("#rptsright").show("fast");
					}

				});
			
			
			if ($(input).attr("name") == "services")

				$('.service_info').each(function(i, tr)

				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#servicesdown").show("fast");
						$("#servicesright").hide("fast");
					} else {

						$(tr).hide();

						$("#servicesdown").hide("fast");
						$("#servicesright").show("fast");
					}

				});
			if ($(input).attr("name") == "hrs")

				$('.HR_info').each(function(i, tr)

				{
					

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#hrsdown").show("fast");
						$("#hrsright").hide("fast");
					} else {

						$(tr).hide();

						$("#hrsdown").hide("fast");
						$("#hrsright").show("fast");
					}

				});
			if ($(input).attr("name") == "Complain")

				$('.Complain_info').each(function(i, tr)

				{
					

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#Complaindown").show("fast");
						$("#Complainright").hide("fast");
					} else {

						$(tr).hide();

						$("#Complaindown").hide("fast");
						$("#Complainright").show("fast");
					}

				});

			if ($(input).attr("name") == "admins")
				$('.admin_info').each(function(i, tr)
				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#adminsdown").show("fast");
						$("#adminsright").hide("fast");
					} else {

						$(tr).hide();

						$("#adminsdown").hide("fast");
						$("#adminsright").show("fast");
					}

				});
			
			
			if ($(input).attr("name") == "admins1")
				$('.admin_info1').each(function(i, tr)
				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#adminsdown1").show("fast");
						$("#adminsright1").hide("fast");
					} else {

						$(tr).hide();

						$("#adminsdown1").hide("fast");
						$("#adminsright1").show("fast");
					}

				});
			
			if ($(input).attr("name") == "rt")
				$('.rt_info').each(function(i, tr)
				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#rtdown").show("fast");
						$("#rtright").hide("fast");
					} else {

						$(tr).hide();

						$("#rtdown").hide("fast");
						$("#rtright").show("fast");
					}

				});
			
			
			if ($(input).attr("name") == "dt")
				$('.dt_info').each(function(i, tr)
				{

					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#dtdown").show("fast");
						$("#dtright").hide("fast");
					} else {

						$(tr).hide();

						$("#dtdown").hide("fast");
						$("#dtright").show("fast");
					}

				});
			
			
			
			
			
			
			
			
			
			
			
			/* if ($(input).attr("name") == "rpts")

				$('.rpt_info').each(function(i, tr)

				{
					
					if ($(tr).is(':hidden')) {

						$(tr).show();

						$("#rptsdown").show("fast");
						$("#rptsright").hide("fast");
					} else {

						$(tr).hide();

						$("#rptsdown").hide("fast");
						$("#rptsright").show("fast");
					}

				});
		 */
	<%--if ($(input).attr("name") == "assembly")

			$('.assembly_info').each(function(i, tr)

			{

				if ($(tr).is(':hidden')) {

					$(tr).show();

					$("#assemblysdown").show("fast");
					$("#assemblyright").hide("fast");
				} else {

					$(tr).hide();

					$("#assemblysdown").hide("fast");
					$("#assemblyright").show("fast");
				}

			});--%>
	       
	}
		catch (er) {
			alert(er);

		}
	}
	
	
	function checkvalue()
	{
		//alert("sssss");
	    var role_name = $("#role_name").val();
	  	//alert(role_name);
		var params ={ role_name:  role_name};
		//alert("---------"+product_name);
		$.ajax({ url: "fetch/Check_Create_Role.jsp",
			data: params,
			success: function showAlert(data){
				try{
				var rows = data.split("\n");
				var ii =0;
		         for (var i=0; i < rows.length; i++) {
		        	 var row = $.trim(rows[i]);
		        	 if(row)
						{
		        		 if(ii==0)
		        			 alert("Please Don't Repeat Role Name");
		        		 $('#role_name').val('');
						
		        	 ii++;
		        		 }
		         }			
                 
				}catch(er){alert(er);}
			},
			cache: false });
		
	 	}
</script>
<script type="text/javascript">
	function aa() {
		
		
		
		$("#userimgdown").hide("fast");
		$("#mastersdown").hide("fast");
		$("#hrsdown").hide("fast");
		$("#adminsdown").hide("fast");
		$("#adminsdown1").hide("fast");
		$("#servicesdown").hide("fast");
		$("#rptsdown").hide("fast");
		$("#salesdown").hide("fast");
		$("#purchasesdown").hide("fast");
		$("#assemblyimgdown").hide("fast");
		
		$("#Complaindown").hide("fast");
		$("#rptsdown").hide("fast");
		$("#accdown").hide("fast");
		$("#statusimgdown").hide("fast");
		$("#rtdown").hide("fast");
		$("#dtdown").hide("fast");
		$("#dealimgdown").hide("fast");
		
		
		$('.user_info').each(function(i, tr)

		{
			$(tr).hide();
		});
		$('.assembly_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.status_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		
		$('.master_info').each(function(i, tr)

		{
			$(tr).hide();
		});
		$('.HR_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.admin_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.deal_info').each(function(i, tr)

				{
					$(tr).hide();
				});

		$('.service_info').each(function(i, tr)

		{
			$(tr).hide();
		});
		$('.stat_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.sale_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.purchase_info').each(function(i, tr)

				{
					$(tr).hide();
				});
		$('.Complain_info').each(function(i, tr)

				{
					$(tr).hide();
				});

		$('.acc_info').each(function(i, tr)

				{
					$(tr).hide();
				});

		$('.rt_info').each(function(i, tr)

				{
					$(tr).hide();
				});

		$('.dt_info').each(function(i, tr)

				{
					$(tr).hide();
				});


	}
</script>	

</head>



<body onload="aa();">
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Role</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Role</a></li>
					<li class="active">Create Role</li>
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
                        
                     <form action="RoleAction" method="post" id="formID" class="form-control">
                        
                        <div class="panel-body">
                            
                          <table>
						
                            
                          <tr>
                          
                          
                          <div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Role Name :
                                                    </label>
                                                    <input type="text" class="form-control" placeholder="Enter Role" name="role_name" id="role_name" onblur="checkvalue();"  required >
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       	    
                                       		 
                                       		</div>
                          
                        
                          
                          
                          </tr>  
                            
                          
                           
                          <tr>
						<td>Menu Details
						 <br><br>
							
							<div class="tab-pane table-responsive active" id="sympdiv" >
             
            						
							
							<table align="left" id="textfocus"
								style="border: 1px solid black;" width="500px;">
								
								
                           
   
								 <tr>

									<td align="left"><b><img name="assemblyimg"
											id="assemblyimgdown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="assemblyimg"
											id="assemblyimgright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="assembly"
												id="assembly" onchange="checkAll(this);" />
											&nbsp;&nbsp;User</b>
									</td>
							
								</tr>
								<tbody class="assembly_info">
								
									
								<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											name="RoleMasterReport" id="assemblyform" value="true"/>
										Create Role </td>
								</tr>
								
								<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											name="RoleReport" id="assemblyform" value="true"/>
										 Role</td>
								</tr>
								
								<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											name="adduserProductMasterReport" id="assemblyform" value="true"/>
									 User Report</td>
								</tr>
								
								<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											name="ChangePass" id="assemblyform" value="true"/>
										Change Password</td>
								</tr>
								
								</tbody>
						
								<tr>
								
								<td align="left"><b><img name="dealimg"
											id="dealimgdown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="dealimg"
											id="dealimgright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="deal"
												id="deal" onchange="checkAll(this);"/>
											&nbsp;&nbsp; Inquiry</b>
									</td>

								</tr>

								<tbody class="deal_info">
				          
				          							
							
									<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Enquiry" value="true" id="brand"/>
									Inquiry Form</td></tr>
									
									<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="EnquiryReport" value="true" id="brand"/>
									Inquiry Report</td></tr>
									
									
									<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="PricingReport" value="true" id="brand"/>
									Quotation</td></tr>
									
							
									<tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="QuotationReport" value="true" id="brand"/>
									Quotation Report</td></tr>
							
								   <tr><td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="ReviseQuotationReport" value="true" id="brand"/>
									Revised Quotation Report</td></tr>
									
									
									
									 
									
								</tbody>
								
								
								
								
								
								
								
                          
                          

								<tr>

									<td align="left"><b><img name="masters"
											id="mastersdown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="masters"
											id="mastersright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="masters"
												id="masters" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Order</b>
									</td>


								</tr>
								<tbody class="master_info">
								
											
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PricingReport1" value="true" id="brand"/>
											Vehicle Confirmation</td>
									</tr>
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="OrderReport" value="true" id="brand"/>
											Create LR</td>
									</tr>
								
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="lr_Reports" value="true" id="brand"/>
												Delivery Done</td>

									</tr>
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="delivery_done_Reports1" value="true" id="brand"/>
												
										Invoice</td>

									</tr>
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="InvoiceReport" value="true" id="brand"/>
											Invoice Report</td>
									</tr>
								
								
								<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PI_done_Reports1" value="true" id="brand"/>
											PI Invoice</td>
									</tr>
								
								
								<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="pi_InvoiceReport" value="true" id="brand"/>
											PI Report</td>
									</tr>
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="newlr_Reports" value="true" id="brand"/>
											LR Report</td>
									</tr>
									
									
									
									
									</tbody>
								
								<tr>

									<td align="left"><b><img name="services"
											id="servicesdown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="services"
											id="servicesright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="services"
												id="services" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Masters</b>
									</td>

								</tr>
                          
                          	<tbody class="service_info">
                          	
                          	
                            
				          			
				          			<tr>
									
									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="customer_master_Reports" value="true" id="brand"/>
											Customer Master
											
										</td>
										
									</tr>
									
									
									<tr>
									
									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="city_master_Reports" value="true" id="brand"/>
											City Master
											
										</td>
										
									</tr>
				          			
				          			
									
									<tr>
									
									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="route_master_Reports" value="true" id="brand"/>
											Route Master
											
										</td>
										
									</tr>
                          
             						<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="product_master_Reports" value="true" id="brand"/>
											Product Master
									</td>

									</tr>
                          			
                          			
                          			
									<!-- <tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="OrderLoadDoneReport" value="true" id="brand"/>
											Loading Done Report
								
									</td>

									</tr> -->
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="driver_master_Reports" value="true" id="brand"/>
											Driver Master
								
									</td>

									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="vehicle_master_Reports" value="true" id="brand"/>
											Vehicle Master
								
									</td>

									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="transport_master_Reports" value="true" id="brand"/>
											Transporter Master
								
									</td>

									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="expense_master_Reports" value="true" id="brand"/>
											Expense Particular Master
								
									</td>

									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="EmployeeReports" value="true" id="brand"/>
											Employee Master
								
									</td>

									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="designation_master_Reports" value="true" id="brand"/>
										Designation Master
								
									</td>

									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="VehicleTypeMasterReport" value="true" id="brand"/>
											Vehicle Type Master
								
									</td>

									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="ResourceTypeMasterReport" value="true" id="brand"/>
											Resource Master
								
									</td>

									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
											 name="Reason Master" value="true" id="brand"/>
											ReasonTypeMasterReport
								
									</td>

									</tr>
									
									
										
									
								</tbody>
								
								
								
								<tr>

									<td align="left"><b><img name="sales" id="salesdown"
											src="img/icon-down.png" onclick="expandAll(this);"> <img
											name="sales" id="salesright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="sales"
												id="sales" onchange="checkAll(this);">
											&nbsp;&nbsp;Accounts</b>
									</td>


								</tr>
								
								<tbody class="sale_info">
								
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="expense_form" value="true" id="brand"/>
											Expense Form</td>
									</tr>
									
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Amount_issue" value="true" id="brand"/>
									Amount issue Form</td>
									
									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Amount_issue_Reports" value="true" id="brand"/>
									Amount issue Report</td>
									
									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="expense_Reports1" value="true" id="brand"/>
									Expense Report</td>
									
									</tr>
									
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Transporter_Credit_Advance_Reportv" value="true" id="brand"/>
									Transporter Ledger</td>
									
									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Customer_Credit_Advance_Reportv" value="true" id="brand"/>
									Customer Ledger</td>
									
									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Supervisor_Credit_Advance_Reportv" value="true" id="brand"/>
									Supervisor  Ledger</td>
									
									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Daily_Cash_Advance_Reportv" value="true" id="brand"/>
									Daily Cash Report</td>
									
									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Escalation_Advance_Reportv" value="true" id="brand"/>
									Escalation Report</td>
									
									</tr>
								
								<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="Customer_Credit_Advance_Reportv123" value="true" id="brand"/>
									LR Profitability Report</td>
									
									</tr>
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="creditdebitnote_Credit_Advance_Reportv" value="true" id="brand"/>
									Credit/Debit Note</td>
									
									</tr>
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="custcdreport" value="true" id="brand"/>
									Customer CR/DR Note Report</td>
									
									</tr>
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
										name="supcdreport" value="true" id="brand"/>
									Supplier CR/DR Note Report</td>
									
									</tr>
								
									
								</tbody>
								
								
								
								
								<tr>

									<td align="left"><b><img name="hrs" id="hrsdown"
											src="img/icon-down.png" onclick="expandAll(this);"> <img
											name="hrs" id="hrsright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="hrs"
												id="hrs" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Payments</b>
									</td>


								</tr>

								<tbody class="HR_info">

									
									
									
									
									
									
									
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="transporter_payment" value="true" id="brand"/>
										Transporter Payment</td>
									</tr> 
									
									
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="customer_payment" value="true" id="brand"/>
											Customer Receipt</td>
									</tr> 
									
										
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="transporter_payment_report" value="true" id="brand"/>
											Transporter Payment Report</td>
									</tr> 
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="customer_payment_report" value="true" id="brand"/>
											Customer Payment Report</td>
									</tr> 
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="transporter_outstanding_report" value="true" id="brand"/>
											Transporter Outstanding Report</td>
									</tr> 
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="customer_outstanding_report" value="true" id="brand"/>
											Customer Outstanding Report</td>
									</tr> 
									
									
									
								
								
								</tbody>
								
                          		
                          		
                          		<tr>

									<td align="left"><b><img name="Complain"
											id="Complaindown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="Complain"
											id="Complainright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="Complain"
												id="Complain" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Graphs</b>
									</td>


								</tr>
								<tbody class="Complain_info">
								
								
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="resource_enquiry_graph" value="true" id="brand"/>
											Resource Enquiry Graph</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="resource_enquiry_graph1" value="true" id="brand"/>
											Resource Enquiry Graph1</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="order_lost_graph" value="true" id="brand"/>
											Order Lost Graph</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="monthly_business_graph" value="true" id="brand"/>
											Monthly Business Graph</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="business_graph" value="true" id="brand"/>
											Resource Enquiry Business Graph</td>
									</tr>
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="exim_graph" value="true" id="brand"/>
											EXIM Graph</td>
									</tr>
									
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="exim_graph1" value="true" id="brand"/>
											Shipment Type Graph</td>
									</tr>
									
									
									<tr>

									<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="exim_graph123" value="true" id="brand"/>
											Root Graph</td>
									</tr>
									
									
									
								
								
												
								
								</tbody>
                          		
                          		
                          		
                          		
                          		<tr>

									<td align="left"><b><img name="rt" id="rtdown"
											src="img/icon-down.png" onclick="expandAll(this);"> <img
											name="rt" id="rtright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="rt"
												id="rt" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Alert</b>
									</td>


								</tr>

								<tbody class="rt_info">
								
									

									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="AlertForm" value="true" id="brand"/>
											Alert Form</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="AlertReport" value="true" id="brand"/>
											Alert Report </td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="AlertDoneReport" value="true" id="brand"/>
											Alert Done Report</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="AlertExpectedReport" value="true" id="brand"/>
											Expected Alert Report</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PriceCheckForm123" value="true" id="brand"/>
											Pricing Form</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PriceCheckReport123" value="true" id="brand"/>
											Pricing Report</td>
									</tr>
				                 		
									
				                 		
									
				                 		
			                 		
								</tbody> 
                          		
                          		
                          		

								<tr>
								
							
								

						<td align="left"><b><img name="statusimg"
											id="statusimgdown" src="img/icon-down.png"
											onclick="expandAll(this);"> <img name="statusimg"
											id="statusimgright" src="img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox" name="status"
												id="status" onchange="checkAll(this);"/>
											&nbsp;&nbsp;Reports</b>
									</td>
                                     
					</tr>

					<tbody class="status_info">
						
						
						
						
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="SalesRegister" value="true" id="brand"/>
											Sales Report</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="VendorBillReport" value="true" id="brand"/>
											Vendor Bill Report</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="DeliveryAlertReport" value="true" id="brand"/>
											Delivery Alert Report</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PriceCheckForm" value="true" id="brand"/>
											Pricing Check Form</td>
									</tr>
									
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="PriceCheckReport" value="true" id="brand"/>
											Pricing Check Report</td>
									</tr>
									
									<tr>

										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												name="CompanyContactReport" value="true" id="brand"/>
											Company Contacts</td>
									</tr>
									
		
						
						</tbody>


								

								
								

								

								
						<!-- <tr>

									<td align="left"><b><img name="userimg"
											id="userimgdown" src="assets/img/icon-down.png"
											onclick="expandAll(this);"> <img name="userimg"
											id="userimgright" src="assets/img/icon-right.png"
											onclick="expandAll(this);"> <input type="checkbox"  name="usersAll"
												id="usersAll" onchange="checkAll(this);" />&nbsp;&nbsp;Accessibility
											</b>
									</td>

								</tr>
								
								
							 	<tbody class="user_info">
							 	
							 	
							 		<tr>
										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												 name="Role_Action" id="brand" value="true"/>
											Add Role</td>
									</tr>
									
									
									<tr>
										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												 name="CreateRole" id="brand" value="true"/>
											Role</td>
									</tr>
									
										
									<tr>
										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												 name="ChangePass" id="brand" value="true"/>
											ChangePassword</td>
									</tr>
									
									
									<tr>
										<td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"
												 name="user_report" id="brand" value="true"/>
											User Report</td>
									</tr>
									
									
								</tbody>	 -->	
								
							
									
                          	 	
                          
                          
                           </table>
                           
                           
                          
                             			
							
									
								     
                           </div>
                           
                           
                           </td></tr></table>
                           
                           <br>
                           <div class="col-sm-4 ">
												
								<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												
								<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												
							</div>
                           
                           </div>
                           
                           
                           
                           </form></div></div></div>
                        
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>

 <script type="text/javascript">

aa();
</script> 

</body>
</html>

