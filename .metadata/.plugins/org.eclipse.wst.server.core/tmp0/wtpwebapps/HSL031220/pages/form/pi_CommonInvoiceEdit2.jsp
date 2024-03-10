<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
  
  <script src="js/datevalidation.js"></script>
  
	<script>
	$(function() {
		var today = new Date(); 
		var dd = today.getDate(); 
		var mm = today.getMonth()+1;//January is 0! 
		var yyyy = today.getFullYear(); 
		if(dd<10){dd='0'+dd} 
		if(mm<10){mm='0'+mm} 
		$("#date").val(dd+'/'+mm+'/'+yyyy);
		
		totalQty(v);
		});
	</script>

	
	 <script>
	
	 function totalQty(v) {
			

			var amount=0;

				$('.item-row').each(function(i, row) {
		
					var $price = $(row).find('#ii');
					
					var r1 = $($price).val();
					
					
					
					amount=Math.abs(amount)+ Math.abs(r1);
					
					


				});
				
				var s=Number(document.getElementById("lr_amount").value);
				
				
				document.getElementById("total").value=amount;
				document.getElementById("total12").value=amount+s;
				
	 } 
 function getAmount(v)
 {
	
	
	
	var amount=0;
	
	 var $traverse_row = $(v).parents('.item-row');
			
		var $hoardinglocation1 = $($traverse_row).find('#gg');
			
		var tax1=$($hoardinglocation1).val();
		
		
		var $hoardinglocation2 = $($traverse_row).find('#hh');
		
		var tax2=$($hoardinglocation2).val();
		
		$hoardinglocation5 = $($traverse_row).find('#ii');
		
		$('.item-row').each(function(i, row) {
			
			
			amount = tax1 * tax2;
			
			//$hoardinglocation5 = $($traverse_row).find('#ee');
			$($hoardinglocation5).val(amount.toFixed(2));
			
		});
		
	
 }
 
		
</script>  


</head>
<body >
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">PI Invoice </h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Invoice</a></li>
					<li class="active">PI Invoice</li>
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
								
								
								<s:push value="eb">
								
								<form action="pi_InvoiceUpdateCommon" class="form-control" name="formid" id="formid" method="POST" ">
								
								
									<div class="panel-body">
									
									
									
									<div class="row">
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Customer Name</label>
							                <input type="text" class="form-control" value="<s:property value="cust_name"/>" id="name" name="name" required >
							              </div>
							            
							          </div>
							          
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Invoice No </label>
							                <input type="text" class="form-control" value="<s:property value="invoice"/>" name="invoiceno" id="invoiceno"  readonly  required>
							              </div>
							            
							          </div>
							          
							              
							          </div>
							          
							          
							          
							          <div class="row">
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Address</label>
							                <input type="text" class="form-control" value="<s:property value="address"/>" id="address" name="address" required >
							              </div>
							            
							          </div>
							          
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Date</label>
							                <input type="text" class="form-control"  name="date" id="date1"  value="<s:property value="date"/>" required>
							              </div>
							            
							          </div>
							          
							              
							          </div>
							          
							          
							          
							          <div class="row">
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Mobile No</label>
							                <input type="text" class="form-control" value="<s:property value="mob_no"/>" id="mobile" name="mobile" required >
							              </div>
							            
							          </div>
							          
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>GSTN No</label>
							                <input type="text" class="form-control" value="<s:property value="gstn_no"/>" name="gstn" id="gstn"   required>
							              </div>
							            
							          </div>
							          
							              
							          </div>
							          
							          
							          
							          <div class="row">
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>To</label>
							                <input type="text" class="form-control" value="<s:property value="dest"/>" id="destination" name="destination" required >
							              </div>
							            
							          </div>
							          
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Service Code</label>
							                <input type="text" class="form-control" value="<s:property value="dcnox"/>" name="source" id="source"   required>
							              </div>
							            
							          </div>
							          
							              
							          </div>
							          
							          
							          
							          <div class="row">
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Job No</label>
							                <input type="text" class="form-control" id="job_no" value="<s:property value="pono"/>" name="job_no" required >
							              </div>
							            
							          </div>
							           
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>LR Amount</label>
							                <input type="text" class="form-control" id="lr_amount" name="lr_amount"  value="<s:property value="lr_amt"/>" onblur="totalQty(this)" required  >
							              </div>
							            
							          </div>
							          
							          
							          
							              
							          </div>
									
									
									<br><br>
									<div class="row">
									
									
									<div id="product" class="tab-pane table-responsive active">

								<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">

									<tbody>
										<tr>
										<th id="VLsparename" ><label>LR NO</label></th>
										<th id="VLsparename" ><label>Manual LR NO</label></th>
										<th id="VLsparename" ><label>DATE</label></th>
										
										<th id="VLsparename" ><label>CONSIGNER</label></th>
										<th id="VLsparename" ><label>CONSIGNEE</label></th>
										<th id="VLsparename" ><label>FROM</label></th>
										<th id="VLsparename" ><label>DESTINATION</label></th>
										<th id="VLsparename" ><label>CH WEIGHT</label></th>
										<!-- <th id="VLsparename" ><label>RATE</label></th> -->
										<th id="VLsparename" ><label>AMOUNT</label></th>
																					
										</tr>
									</tbody>

								
								<s:iterator value="(gridsize).{# this}" status="stat">
									<tr class="item-row">
											
									<td><input class="form-control" style="width:80px;"  type="text" name="aa"  
									id="aa" value="<s:property value="descriptiont[top]"/>" readonly/></td>
									
									
										
									 <td><input class="form-control" style="width:80px;" value="<s:property value="myrate[top]"/>"  type="text" name="hh"  
									id="hh"  required/></td>
									
									
									<td><input class="form-control" style="width:120px;"  type="text" name="bb"  
									id="bb" value="<s:property value="batcht[top]"/>" readonly/></td>
									
									<td><input class="form-control" style="width:120px;"  type="text" name="cc"  
									id="cc" value="<s:property value="vat[top]"/>" readonly/></td>
									
									<td><input class="form-control" style="width:120px;"  type="text" name="dd"  
									id="dd" value="<s:property value="quantity[top]"/>" readonly/></td>
									
									<td><input class="form-control" style="width:120px;"  type="text" name="ee"  
									id="ee" value="<s:property value="hsncode[top]"/>" readonly/></td>
									
									<td><input class="form-control" style="width:120px;"  type="text" name="ff"  
									id="ff" value="<s:property value="myamt[top]"/>" readonly/></td>									
									
									
									<td><input class="form-control" style="width:80px;"  type="text" name="gg"  
									id="gg" value="<s:property value="rate[top]"/>" required/></td>
									
									<%-- <td><input class="form-control" style="width:80px;" value="<s:property value="myrate[top]"/>"  type="text" name="hh"  
									id="hh" onblur="getAmount(this);totalQty(this);" required/></td>
									 --%>
									<td><input class="form-control" style="width:80px;" value="<s:property value="gstamt1[top]"/>" type="text" name="ii"  
									id="ii" required readonly/></td>
									
									</tr>


									
								
								</s:iterator>


								</table>	
			
								</div>
									
				 				</div>
									
									
									
									
								<br><br>
									
							          
							          <div class="row">
							          
							          
							          <div class="col-md-6">
							          <div class="form-group">
							                <label>Total </label>
							                <input type="hidden" class="form-control"   name="total" id="total"  readonly >
							           
							             <input type="text" class="form-control"   name="total12" id="total12" readonly >
							           
							              </div>
							            
							          </div>
							          
							              
							          </div>
							          
							          
								          </div>
							          <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" id="formSave" type="submit"  >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
								</form></s:push></div>
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

<script>
totalQty();
</script>
</body>
</html>


