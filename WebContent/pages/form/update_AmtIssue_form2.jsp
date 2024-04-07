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
  <!-- AutoSearch -->
	<script>
	$(function() {
		// $("#given_by").autocomplete("GoogleSearch/employee.jsp");
		 $("#given_to").autocomplete("GoogleSearch/employee.jsp");
		 //$("#emp_name").autocomplete("GoogleSearch/employee.jsp");
		 $("#exp_parti").autocomplete("GoogleSearch/autosearchExp.jsp");

		 $("#given_by").autocomplete("GoogleSearch/EMPLOYEE1name_idsearch2.jsp");
		 $("#emp_name").autocomplete("GoogleSearch/EMPLOYEE1name_idsearch2.jsp");

	});
	</script>
	
	
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
	
	 <%-- <script>
	 $(function() {
		 $("#driver_name").autocomplete("GoogleSearch/autosearchDriver.jsp");
		 $("#vehicle_no").autocomplete("GoogleSearch/autosearchVehicle.jsp");
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#next_destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#customer_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
		 $("#description").autocomplete("GoogleSearch/spareautosearch.jsp");
	});
	 
	 
	 function getRNA(v)
	 {
		 var $traverse_row = $(v).parents('.item-row');
			
			//	alert(">>>");
				$hoardinglocationx1 = $($traverse_row).find('#rate');
				//alert(">>>");
				$hoardinglocationx = $($traverse_row).find('#weight');
			//	alert(">>>");
				/* $hoardinglocation3 = $($traverse_row).find('#amount'); */
				$('.item-row').each(function(i,row){
				var weight = $($hoardinglocationx).val();
				
				var rate = $($hoardinglocationx1).val();
				
				/* var amount = $($hoardinglocation3).val();  */
				
				
				if(weight!="" && rate!="" ){
					amt= rate * weight;
					$hoardinglocation = $($traverse_row).find('#amount');
					//alert(amt);
					$($hoardinglocation).val(amt);
					
				}
		 
				});	
    		 //alert("1234567");
    		 /* var $vid = $(row).find('#weight');
    		 var $vid1 = $(row).find('#rate');
    		
    		 var $vid2 = $vid * $vid1;
    		 
    		 alert($vid2);
    		 
    		 $(row).find('#amount').value = $vid2; */
    		 
    	 
    	 
		 
		 /* var amount = weight * rate;
		 alert("amount : "+amount);
		 document.getElementById("amount").value = amount; */
	 }
	 
	 function getTotal(v)
	 {
		// alert('getTotal()');
		 /* var $traverse_row = $(v).parents('.item-row');
		 var tot_amt = 0; */
		/*  $hoardinglocationx = $($traverse_row).find('#amount'); */
		 /* $hoardinglocationx = $($traverse_row).find('#amount');
		 
		 $('.item-row').each(function(i,row){
			 
			 var amount = $($hoardinglocationx).val();
			 
			 tot_amt = Math.abs(tot_amt) + Math.abs(amount);
			  */
			 /* $hoardinglocation = $($traverse_row).find('#total_amount'); */
			 
		 /* });	
		//alert(tot_amt);
		document.getElementById("total_amount").value = tot_amt; */
		
		
		
		var amount=0;
		
		 var $traverse_row = $(v).parents('.item-row');
				
			var $hoardinglocation1 = $($traverse_row).find('#amount');
				
			var tax2=$($hoardinglocation1).val();
			
			
			$('.item-row').each(function(i, row) {
				
				
				var $totamttemp = $(row).find('#amount');
				var totamt = $($totamttemp).val();
				amount=Math.abs(amount)+ Math.abs(totamt);
				
				
			});
			//alert("Total:"+amount);
			alert(amount);
			document.getElementById("total_amount").value=amount;
		
	 }
	 
	 function getBalance(v)
	 {
		 var advance = v.value;
		 var total = document.getElementById('total_amount').value;
		 var balance = Math.abs(total) - Math.abs(advance);
		 
		 alert(balance);
		 document.getElementById("balance").value = balance;
	 }
	 
	  /* function skipqty(v){

			
			
			
			var $traverse_row = $(v).parents('.item-row');
			var $hoardinglocation = $($traverse_row).find('#weight');
			var $hoardinglocationa = $($traverse_row).find('#rate');
			var $hoardinglocationx = $($traverse_row).find('#description');
			var $hoardinglocationb = $($traverse_row).find('#amount');
			
			var desc=$(v).val();
			desc = desc.trim();
			$(v).val(desc);
			
			
			var ths = $(v).val();
	    	var t = 0;
	    	 $('.item-row').each(function(i,row){
	    		 //alert("1234567");
	    		 var $vid = $(row).find('#description');
	    		 
	    		 
	    		 if($($vid).val()==ths)
	     		{
	     		t=t+1;
	     		}
	    	 });
	    	 
	 } */
	 
	 
	 
	 /* function getnewsrno(v){
			calculategst(v);
			
		}
	 
	 function calculategst(v){
			
			//alert(">>>");
			var $traverse_row = $(v).parents('.item-row');
			
		//	alert(">>>");
			$hoardinglocationx1 = $($traverse_row).find('#rate');
			//alert(">>>");
			$hoardinglocationx = $($traverse_row).find('#weight');
		//	alert(">>>");
			/* $hoardinglocation3 = $($traverse_row).find('#amount'); 
			
			var weight = $($hoardinglocationx).val();
			
			var rate = $($hoardinglocationx1).val();
			
			var amount = $($hoardinglocation3).val(); 
			
			
			if(weight!="" && rate!="" ){
				amt= rate * weight;
				$hoardinglocation = $($traverse_row).find('#amount');
				$($hoardinglocation).val(amt);
				
			}
	 } */ 
	 
	 </script>
 --%>
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
					<h1 class="page-header text-overflow">Amount Issue Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Transport</a></li>
					<li class="active">Amount Issue Form</li>
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
								
							<form action="update_amount_issue_details" id="frmFileUpload" class="form-control " method="post" enctype="multipart/form-data">
					    <br>
					    <s:iterator value="tripDetails">
					<div class="body">
                        <div class="row clearfix">
                        
                        
                        
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="date1y" id="date1y" value="${date1y}" class="form-control floating-input" onblur="FixShortDate(this);return ValidateForm(this);"   placeholder=" "  required>
                                    
                                    <label>Date</label>
                                    
                                    
                                </div> 
                            </div>
                           </div>
                           <div class="row clearfix">
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="given_by" id="given_by"  value="${given_by}" class="form-control floating-input"   placeholder=" " onblur="getname();"  required>
                                    
                                    <label>Given By</label>
                               
                                </div> 
                            </div>
                           </div>
                           <div class="row clearfix">
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="name" id="emp_name"  value="${emp_name}"  class="form-control floating-input"   placeholder=" " onblur="getdetails(this);"  required>
                                    
                                    <label>Employee Name</label>
                                    
                                    
                                </div> 
                            </div>
                           </div>
                          <div class="row clearfix">
                            
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="particular"   value="${dest_contact_person}" id="exp_parti" class="form-control floating-input"   placeholder=" "   required>
                                    
                                    <label>Expense Particular</label>
                                    
                                    
                                </div> 
                          </div>
                          </div>
                           
                           <div class="row clearfix">
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="amount1" id="amount1"   value="${amount1}" class="form-control floating-input"   placeholder=" "  required>
                                    
                                    <label>Amount</label>
                                    
                                    
                                </div> 
                            </div>
                           </div>
                           
                            <div class="row clearfix">
                            <div class="col-sm-6">
                                <div class="form-group floating-label">
                                    <input type="text"  name="remark" id="remark"  value="${remark}" class="form-control floating-input"   placeholder=" "  required>
                                    <input type="hidden"  name="emp_id" id="emp_id" class="form-control floating-input"  placeholder=" "   required>
                                    <label>Remark</label>
                                                                       
                                </div> 
                            </div>
                           </div>
                             <input type="hidden"  name="documentsno" id="documentsno"  value="${documentsno}" class="form-control floating-input"   placeholder=" " >
                           
                                 <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
                            </div>
                            </s:iterator>
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
