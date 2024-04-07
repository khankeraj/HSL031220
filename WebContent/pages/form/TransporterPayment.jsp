<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
  <script src="js/datevalidation.js" type="text/javascript"></script>
	
	
  <!-- AutoSearch -->
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
	
	 <script>
	 
	   $(document).ready(function(){
		    $('input[type="radio"]').click(function(){
		    	var demovalue = $(this).val();
		    	//alert("demovalue : "+demovalue);
		    	if(demovalue=="normal")
		    	{
		    		$("#go").hide();
		    		 $("#documentNoSpan").hide();
		    	}
		    	
		    	if(demovalue=="against_trip")
		    	{
		    		$("#go").show();
		    		$("#documentNoSpan").show();
		    	}
		        /* $("#documentNoSpan").hide();
		        $("#documentNoSpan").show(); */
		    });
		})  
	 
	 
	 $(function() {
		 $("#transporter_name").autocomplete("GoogleSearch/transporterautosearch.jsp");
		 /* $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp"); */
	});
	 
	 
	 function showGrid()
	 {
		 t_name = document.getElementById("transporter_name").value;
		  
		 if(t_name=="" || t_name==null)
		 {
				alert('Please select Transporter name!');	 
		 }
		 
		 
		 else
		 {
			 var parts = t_name.split("-");
			 var t_code = parts[1];
			 
			 if (window.XMLHttpRequest) {
					var xp1=new XMLHttpRequest();
				}
			 
			else{
					var xp1=new ActiveXObject("Microsoft.XMLHTTP");
				}
			 
			 xp1.open("POST","CommissionSearch1?transporter_code="+t_code);
			 xp1.send();
			 
			 
			 xp1.onreadystatechange=function() {


				if (xp1.readyState==4 && xp1.status==200) {

				//alert(xp1.responseText);
				
					

					document.getElementById("documentNoSpan").innerHTML=xp1.responseText;
						
						

				}
					
			};
					
			 
			 
			 
		 }
	 }
	 
	 
	 
	 
	 
	 
	 function display(obj) {
			
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
			
	    var x=document.getElementById("total_amount").value;
	          document.getElementById("net_amount").value=x;
	          document.getElementById("p5").value=x;
	          
		}
	 
	 
		function CalculateTotal12(v)
		{
			 var total12 = 0;	
			 try {
				 var $traverse_row = $(v).parents('.item-row');
					$i = $($traverse_row).find('#commcheck');
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
			
			
			 document.getElementById("total_amount").value=amt15;
			 document.getElementById("net_amount").value=amt15;
			 
			 
			 }catch (e) {
				 	
				 }
				 }
	 
	 
	 
	 function getNetAmt(v)
	 {
		 var total = v.value;
		 document.getElementById("net_amount").value = total;
	 }
	 
	 
	 
	 function checkTotals()
	 {
		 var tot1 = document.getElementById("total_amount").value;
		 var t_name = document.getElementById("transporter_name").value;
		// var tot2 = document.getElementById("total_amount").value;
		// alert('tot1: '+tot1);
		
		if(t_name=="" || t_name==null)
		{
			alert('Please select transporter name!');
			return false;
			//history.go(-1)
			//window.location.reload();
		}
		
		
		if(tot1==0 || tot1=="" || tot1==null)
		{
			alert('Please select atleast one checkbox!');
			return false;
			//history.go(-1)
			//window.location.reload();
		}
		
		else
		{
			document.getElementById("form1").action = "inserttransporterpaymentv";
		}
	 }  
	 
	 
	 
	 </script>
</head>
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
					<h1 class="page-header text-overflow">Transporter Payment Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Payments</a></li>
					<li class="active">Transporter Payment Form</li>
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
								
							<form id="form1" method="POST">
								<div class="panel-body">
								
									<!-- <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													
													<input type="radio" name="dpb.paytype" value="against_trip" checked> Against Trip
													<input type="radio" name="dpb.paytype" value="normal"> Normal
													
												</div>
											</div>
											
											
									  </div> -->
								
									<div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  name="dpb.payment_date" id="payment_date" style="line-height:15px;"  onblur="FixShortDate(this);return ValidateForm(this);"  class="form-control" required>
													
												</div>
											</div>
											
											
									  </div>
									
									
								
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transporter Name:</label>
													<input type="text" class="form-control" placeholder="Transporter Name" name="dpb.transporter_name" id="transporter_name"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" required>
													<br><button id="go" onclick="showGrid();">Go</button>
												</div>
											</div>
											
											
									  </div>
									  
									  
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<div id="documentNoSpan"></div>
												</div>
											</div>
											
											
									  </div>
									  
									  
									  
									  
									  
									  
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total Amount:</label>
													<input type="text" class="form-control" placeholder="Total Amount" name="dpb.total_amount" id="total_amount"  onkeyup="this.value=this.value.toUpperCase()" class="form-control" onblur="getNetAmt(this)" required>
												</div>
											</div>
											
											
									  </div>
									  
									  
									  <%-- <div class="row">
			  
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Paymode:</label>
					   <select  tabindex="8" style="width:100%;"
							onchange="display(this);" name="dpb.paymod" id="paymod" class="validate[required]"   >										>
								<option value="">-------------------SELECT-----------------</option>
								<option value="1">Cash :</option>

								<option value="3">Cheque :</option>
								<option value="4">NEFT :</option>
				
					</select>
					</div>							
			 </div>
			 
			 	
			  </div> --%>
			  
			 						 <div class="row">
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Paymode:</label>
													
													<select  onchange="display(this);" name="dpb.paymod" id="paymod" class="form-control show-tick "   >	
												
																<option value="">SELECT</option>
																<option value="1">Cash :</option>

																<option value="3">Cheque :</option>
																<option value="4">NEFT :</option>
																
																
													</select>
												</div>
									  </div></div>
			  
			  
			  
			  
					<div class="row">
					<div class="col-sm-6">
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
			   </div>
			   			
			   			<div class="row">
					   	<div class="col-sm-6">
								<div class="form-group">
									<label class="control-label">Verified By :</label>
									<input type="text" name="dpb.verifyby" class="form-control"
													id="verifyby">
													
								</div>
						</div>
			   	
			   	
			   	</div>
			 
				<div class="row">
						<div class="col-sm-6">
								<div class="form-group">
									<label class="control-label">Remark :</label>
									<input type="text" name="dpb.remark" class="form-control"
													id="remark">
													
								</div>
						</div>
											
											
				</div>					
										
										
										
										
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" onclick="checkTotals()">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>
