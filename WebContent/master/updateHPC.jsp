<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRow").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
													var $itemsTable = $('#itemsTable');
													var $rowTemp = [
															'<tr class="item-row">',

															'<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input  type="text" class="form-control" name="specifications"/></td>',
															'<td><input  type="text" class="form-control" name="quantity"/></td>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

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
					
					<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRow1").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
													var $itemsTable = $('#itemsTable1');
													var $rowTemp = [
															'<tr class="item-row">',

															'<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input  type="text" class="form-control" name="headingsOfspecifications"/></td>',
															'<td><input  type="text" class="form-control" name="specifications1"/></td>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

													$last = $('#itemsTable1')
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
													$last = $('#itemsTable1')
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
					
					<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRowps").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
													var $itemsTable = $('#itemsTableps');
													var $rowTemp = [
															'<tr class="item-row">',

															'<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input  type="text" class="form-control" name="specifications3"/></td>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

													$last = $('#itemsTableps')
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
													$last = $('#itemsTableps')
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
					
					<script type="text/javascript">
						$(document)
								.ready(
										function() {
											$("#addRowps1").bind('click', addRows);
											var index = 13;
											function addRows(e) {
												try {
													var $itemsTable = $('#itemsTableps1');
													var $rowTemp = [
															'<tr class="item-row">',

															'<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
															'<td><input  type="text" class="form-control" name="specifications4"/></td>',
															'<td><input  type="text" class="form-control" name="quantity4"/></td>',
															'</tr>' ].join('');
													var $row = $($rowTemp);
													$.currentRow = $row;

													$last = $('#itemsTableps1')
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
													$last = $('#itemsTableps1')
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
					<h1 class="page-header text-overflow">High Pressure Compressor For PET Blowing</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">HPC For PET Blowing</li>
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
								<form action="updateHighPressureCompMaster" method="POST">
									<div class="panel-body">
									<div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
	                                                <div id="highpressCompress">
	                                             	  <img alt="roWater" src="configure/img/hpc.png"  height="200px;" width="1000px;"> 
													</div>
	                                            </div>
                                            </div>
                                     </div>
                                     
                                    	 <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Name Of Quotation :
                                                    </label>
                                                    <input type="text" name="quotation_name" value="${quotation_name}" onkeyup="this.value=this.value.toUpperCase()" class="form-control"> </div>
                                            </div>
                                         </div>
                                     
                                  <s:iterator value="hpc4">
									<div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Name Of Index :
                                                    </label>
                                                    <input type="text" name="update_id" value="${highPressureComp_id}">
                                                    <input type="text" value="${name_of_index}" name="name_of_index" onkeyup="this.value=this.value.toUpperCase()" class="form-control"> </div>
                                            </div>
                                         
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2">Select Image :
                                                    </label>
                                                    <input type="hidden" name="image" value="${image}"> 
                                                    <input type="file" class="form-control"  id="sethighpreComp"  class="form-control"> </div>
                                            </div>
                                     </div>
                                      </s:iterator>
                                     
                                     <div class="row">
                                   		<div class="col-md-6">
                                              <div class="form-group">
												<label for="wfirstName2">machine Details :</label>
												<input type="text" class="form-control"  onkeyup="this.value=this.value.toUpperCase()" name="machine_details" value="${machine}">
											 </div>
                                        </div>
                                        
                                        <div class="col-md-6">
                                              <div class="form-group">
												<label for="wfirstName2">Sub Name 1 :</label>
												<input type="text" class="form-control"  onkeyup="this.value=this.value.toUpperCase()" name="subname1" value="${name1}" >
											 </div>
                                        </div>
                                        
                                     </div>
                                    
                                    <div class="row">
                                     <div class="col-md-6">
                                              <div class="form-group">
                                                  <label for="wfirstName2">Sub Name 2:
                                                  </label>
                                                  <input type="text" name="subname2" value="${name2}" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> 
                                             </div>
                                        </div>
                                        <s:iterator value="hpc4">
                                   		<div class="col-md-6">
                                              <div class="form-group">
                                                  <label for="wfirstName2">Technical Name :
                                                  </label>
                                                  <input type="text" class="form-control" name="techname" value="${techname}" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> 
                                             </div>
                                        </div>
                                        </s:iterator>
                                     </div>
                                        
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
													<tr>
														<td colspan="5">
														
																<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																		<th><i class="fa fa-remove" title="Remove Item"></i></th>
																		<th id="VLsparename"><label>Specification </label></th>
																		<th id="VLsparename"><label>Quantity </label></th>
																	</tr>
																	
																	<s:iterator value="hpc5">
																	<tr class="item-row">
																		<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																		<td><input type="text" name="specifications" value="${specifi}" class="form-control">
																		</td>
																		<td><input type="text" name="quantity" value="${qty}" class="form-control">
																		</td>	
																	</tr>
																	</s:iterator>
																	
																</table>
																
																	<table id="demo-dt-addrow" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																			<td align="left"><a	href="#" id="addRow" class="button-clean large">
																			<span><img id="" tabindex="13" src="configure/img/icon-plus.png" alt="Add" title="Add Row" style="margin-left: 0px" />
																			Add Item</span> </a></td>
																	</tr>
																</table>
															</td>
														</tr>
												</table>
											</div>
                                          </div>
                                        </div>
                                        
                                      <s:iterator value="hpc4">
                                       <div class="row">
	                                   		<div class="col-md-6">
	                                              <div class="form-group">
	                                                  <label for="wfirstName2">Technical Details :
	                                                  </label>
	                                             <input type="text" class="form-control" name="techDetails" value="${techDetails}" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
	                                        </div>
                                    	 </div>
                                      </s:iterator>
                                        
                                         <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
													<tr>
														<td colspan="5">
																<table id="itemsTable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																		<th><i class="fa fa-remove" title="Remove Item"></i></th>
																		<th id="VLsparename"><label>Specification </label></th>
																		<th id="VLsparename"><label>Quantity</label></th>
																	</tr>
																	
																	<s:iterator value="hpc6">
																	<tr class="item-row">
																		<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																		<td><input type="text" name="headingsOfspecifications" value="${specifi2}" class="form-control">
																		</td>
																		<td><input type="text" name="specifications1" value="${qty2}" class="form-control">
																		</td>	
																	</tr>
																	</s:iterator>
																	
																</table>
																	<table id="demo-dt-addrow" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																			<td align="left"><a	href="#" id="addRow1" class="button-clean large">
																			<span><img id="" tabindex="13" src="configure/img/icon-plus.png" alt="Add" title="Add Row" style="margin-left: 0px" />
																			Add Item</span> </a></td>
																	</tr>
																</table>
															</td>
														</tr>
												</table>
											</div>
                                          </div>
                                        </div>
                                        
                                       
                                        <div class="row">
	                                   		<div class="col-md-6">
	                                              <div class="form-group">
	                                                  <label for="wfirstName2">Heading :
	                                                  </label>
	                                             <input type="text" class="form-control"  name="heading1" value="${head}" onkeyup="this.value=this.value.toUpperCase()" class="form-control" required> </div>
	                                        </div>
                                    	 </div>
                                        
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="form-group">
												<table id="itemsTable$" class="table table-striped table-bordered" cellspacing="0" width="100%">
													<tr>
														<td colspan="5">
																<table id="itemsTableps1" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																		<th><i class="fa fa-remove" title="Remove Item"></i></th>
																		<th id="VLsparename"><label>Specification </label></th>
																		<th id="VLsparename"><label>Quantity </label></th>
																	</tr>
																	
																	<s:iterator value="hpc7">
																	<tr class="item-row">
																		<td><a id="deleteRow"><img src="configure/img/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
																		<td><input type="text" name="specifications4" value="${specifi3}" class="form-control">
																		</td>
																		<td><input type="text" name="quantity4" value="${qty3}" class="form-control">
																		</td>
																	</tr>
																	</s:iterator>
																	
																</table>
																	<table id="demo-dt-addrow" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	<tr>
																			<td align="left"><a	href="#" id="addRowps1" class="button-clean large">
																			<span><img id="" tabindex="13" src="configure/img/icon-plus.png" alt="Add" title="Add Row" style="margin-left: 0px" />
																			Add Item</span> </a></td>
																	</tr>
																</table>
															</td>
														</tr>
												</table>
											</div>
                                          </div>
                                        </div>
                                        
                                        <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="button"  onclick="history.go(-1)">Back</button>
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
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
	
	<script>
	function previewImages() {
	
		  var $preview = $('#highpressCompress').empty();
		  
		  if (this.files) $.each(this.files, readAndPreview);
	
		  function readAndPreview(i, file) {
		    
		    if (!/\.(jpe?g|png|gif)$/i.test(file.name)){
		      return alert(file.name +" is not an image");
		    } // else...
		    
		    var reader = new FileReader();
	
		    $(reader).on("load", function() {
		      $preview.append($("<img/>", {src:this.result, height:200,width:1000}));
		    });
	
		    reader.readAsDataURL(file);
		    
		  }
	
		}

	$('#sethighpreComp').on("change", previewImages);
</script>
</body>
</html>

