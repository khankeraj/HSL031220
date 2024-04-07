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
	
	<%-- <script>
	$(function() {
		 $("#bank_name").autocomplete("GoogleSearch/bankName.jsp");
	});
	</script> --%>
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
					<h1 class="page-header text-overflow">Vehicle Master</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Vehicle Master</li>
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
								
							<form action="update_vehicle_master_details" method="POST" enctype="multipart/form-data">
							<s:iterator value="fetchVehicleDetails">
								<div class="panel-body">
								      <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle No:</label>
													<input type="hidden" name="vehicle_id" value="${v_id}">
													<input type="text" class="form-control" placeholder="" name="vehicle_no" value="${vehicle_no}"  class="form-control" required>
												</div>
											</div>
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Vehicle Type :</label>
													<input type="text" class="form-control" placeholder="" name="vehicle_type"  value="${vehicle_type}"   class="form-control" required>
												</div>
											</div>
									  </div>
									  
									  <div class="row">
									  <div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Model :</label>
												<input type="text" placeholder=""  name="model" value="${model}" class="form-control" required>
											</div>
										</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Size :</label>
													<input type="text" placeholder=""  name="size" value="${size}" style="line-height: 15px;"  class="form-control" required>
												</div>
											</div>
									  </div>
									
									 <div class="row">
											<div class="col-sm-6">
											<div class="form-group">
												<label class="control-label">Capacity :</label>
												<input type="text" placeholder=""  name="capacity"  value="${capacity}" class="form-control" required>
											</div>
										  </div>
										   <div class="col-sm-6">
										    <div class="form-group">
												<label class="control-label">Driver :</label>
												<input type="text" placeholder=""  autocomplete="off" name="driver" value="${driver}" class="form-control" required>
										    </div>
										  </div>
									</div>
										
										
									
										
										
										<div id="product" style="width:100%">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%">
													
													<tr>
														<td  id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="70%" colspan="5">

															
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="70%">
																	
																	<tr>
																		<th style="">Sr. No.</th>
																		<th id="VLsparename"><label>Title</label>
																		</th>
																		
																		<th id="VLsparename"><label>Date</label>
																		</th>
																		
																		
																		<th id="VLsparename"><label>Photo</label>
																		</th>
																		
																		
									  
									  								</tr>
									  								
									  								
									  								
									  								
									  								<tr id= "editdiv" ><td colspan="13"  style="height:1px">
																	<div id="documentNoSpan"></div>
																	</td></tr>
																	
																	<tr class="item-row">
																	<td style="width:1px;">1</td>
																	<td>Road Tax</td>
																		<td><input type="date" name="road_tax_date" value="${road_tax_date}" id="road_tax_date"/></td>
																		<%-- <td><input type="file" name="road_tax_photo" value="${road_tax_photo}" multiple accept='image/*' class="form-control" required /></td> --%>
																		<td><input type="file" name="photo" multiple accept='image/*' class="form-control"  /></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">2</td>
																	<td>Fitness Tax</td>
																		<td><input type="date" name="fitness_tax_date" value="${fitness_tax_date}" id="fitness_tax_date"/></td>
																		<%-- <td><input type="file" name="fitness_tax_photo" value="${fitness_tax_photo}" multiple accept='image/*' class="form-control" required/></td> --%>
																		<td><input type="file" name="photo" multiple accept='image/*' class="form-control" /></td>
									  								</tr>
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>Permit tax</td>
																		<td><input type="date" name="permit_tax_date" value="${permit_tax_date}" id="permit_tax_date"/></td>
																		<%-- <td><input type="file" name="permit_tax_photo" value="${permit_tax_photo}" multiple accept='image/*' class="form-control" required/> --%>
																		<td><input type="file" name="photo"  multiple accept='image/*' class="form-control" />
																		</td>
									  								</tr>
									  								
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>PUC</td>
																		<td><input type="date" name="puc_date" value="${puc_date}" id="puc_date"/></td>
																		<%-- <td><input type="file" name="puc_photo" value="${puc_photo}" multiple accept='image/*' class="form-control" required/> --%>
																		<td><input type="file" name="photo"  multiple accept='image/*' class="form-control" />
																		</td>
									  								</tr>
									  								
									  								
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>Servicing</td>
																		<td><input type="date" name="servicing_date" value="${servicing_date}" id="servicing_date"/></td>
																		<%-- <td><input type="file" name="servicing_photo" value="${servicing_photo}" multiple accept='image/*' class="form-control" required/> --%>
																		<td><input type="file" name="photo"  multiple accept='image/*' class="form-control" />
																		</td>
									  								</tr>
									  								
									  								
									  								<tr class="item-row">
																	<td style="width:1px;">3</td>
																	<td>Insurance</td>
																		<td><input type="date" name="insurance_date" value="${insurance_date}" id="insurance_date"/></td>
																		<%-- <td><input type="file" name="insurance_photo" value="${insurance_photo}" multiple accept='image/*' class="form-control" required/> --%>
																		<td><input type="file" name="photo"  multiple accept='image/*' class="form-control" />
																		</td>
									  								</tr>
									  								
									  								
									  								
									  								
									  								
									  								</table>
									  		
									  						</td>
									  					</tr>
									  				</table>
									  			</div>
										
										
										
										
										
										
										
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
