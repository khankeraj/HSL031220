<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script src="Css/jquery-1.10.2.js"></script>
<script src="Css/jquery-ui.js"></script>

<%-- <meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>GST SOFTWARE Service Center</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->

<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

<link rel="stylesheet" type="text/css" media="all"
	href="niceform-Product-Master.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="masterstyle.css" />
<link rel="stylesheet" type="text/css" href="Css/layout-styles.css" />
<link rel="stylesheet" href="Css/validationEngine.jquery.css"
	type="text/css" />
<link rel="stylesheet" href="Css/template.css" type="text/css" />
<script src="js/languages/jquery.validationEngine-en.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"
	charset="utf-8"></script>
<link rel="stylesheet" type="text/css" media="all"
	href="Css/AutoSearch/styleAS.css" />
<script src="jQuery_4_design/AutoSearch/AutoSearchJquery.js"></script>
<script type="text/javascript" src="js/validation.js"></script>

<script src="datevalidation.js"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').dataTable();		   
	});
</script>
<link rel="stylesheet" href="Css/demos.css">
<script type="text/javascript" language="javascript"
	src="js/rptsTable/jquery.dataTables.js"></script>
<style type="text/css" title="currentStyle">
@import "Css/rptsTable/demo_page.css";

@import "Css/rptsTable/demo_table.css";
</style>
<script type="text/javascript"
	src="jQuery_4_design/AddRowDataTable/purchase_spare.js"></script>
<link rel="stylesheet" type="text/css"
	href="Css/AddRowDataTable/layout-styles.css" />
<link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
<script src="datevalidation.js"></script>
<script src="js/jquery-migrate-1.2.1.js"></script>
 --%>



	<s:push value="pay1model">
		<div style="width:  1050px; id="main">
	<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">

									<tbody>
										<tr>
											<th style="">Select</th>
									
											<th id="VLsparename" ><label>Date</label></th>
											
											<!-- <th id="VLsparename" ><label>Trip Id</label></th>
											<th id="VLsparename" ><label>Up/Down Id</label></th> -->
											<th id="VLsparename" ><label>LR No</label></th>
											<th id="VLsparename" ><label>Total Amount</label></th>
											<th id="VLsparename" ><label>Remaining Amount</label></th>
										</tr>
									</tbody>

	<tr class="item-row">
		
							
								
								<s:iterator value="(spare_size).{# this}" status="stat">
									<tr id="spare_size${top}" class="item-row"  >
											
									
									
								
								<td><input  type="checkbox" value="<s:property value="lr_number2[top]"/>" name="<s:property value="lr_number2[top]"/>" id="mycec" onclick="CalculateTotal12(this);"/></td>
												
							
									
									
									
									<td><input style="width:150px;"  type="text" name="dpb.date2"   class="form-control"
									id="dd" value="<s:property value="date2[top]"/>" readonly required/></td>
									
									<input style="width:150px;"  type="hidden" name="dpb.trip_id2"   class="form-control"
									value="<s:property value="trip_id2[top]"/>" id="material" /></td>
																	
									
																	
									<input style="width:150px;"  type="hidden" name="dpb.updown_id2"   class="form-control"
									 value="<s:property value="updown_id2[top]"/>" />
																	
									
									
									
									 <td><input style="width:150px;"  type="text" name="dpb.lr_number2"  class="form-control"
									 value="<s:property value="lr_number2[top]"/>" readonly required/></td>													
									
									<td><input style="width:150px;"  type="text" name="dpb.commision2"  class="form-control"
									id="commamt" value="<s:property value="commision2[top]"/>"  readonly required/></td>
									
									<td><input style="width:150px;"  type="text" name="dpb.remaining_amount2"  class="form-control"
									id="reamt" value="<s:property value="remaining_amount2[top]"/>"  onblur="CalculateTotal12();" /></td>
									
								
									
									
									
									<%-- <td><input style="width:150px;"  type="text" name="dpb.commision2"  class="form-control"
									id="commamt" value="<s:property value="remaining_amount2[top]"/>"  readonly required/></td>
									
									<td><input style="width:150px;"  type="text" name="dpb.remaining_amount2"  class="form-control"
									id="reamt" value="<s:property value="commision2[top]"/>"   onblur="CalculateTotal12();" /></td>
									 --%>
									
									<td hidden><input style="width:150px;"  type="hidden" name="dpb.commcheck"  
									id="commcheck" value="" /></td>
	
									</tr>


									
								
								</s:iterator>


			</table>	
			
			</div>

</s:push>

	<script type="text/javascript">
	//Remove row when clicked
	$("#deleteRow").live('click', function() {
		$(this).parents('.item-row').remove();
		// Hide delete Icon if we only have one row in the list.
		if ($(".item-row").length < 2)
			$("#deleteRow").hide();
	});
</script>
