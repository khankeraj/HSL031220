<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=latin" rel="stylesheet">
	<link href="configure/css/bootstrap.min.css" rel="stylesheet">
	<link href="configure/css/nifty.min.css" rel="stylesheet">
	<link href="configure/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="configure/plugins/switchery/switchery.min.css" rel="stylesheet">
	<link href="configure/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
	<link href="configure/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="configure/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">
	<link href="configure/css/demo/nifty-demo.min.css" rel="stylesheet">
	<link href="configure/plugins/pace/pace.min.css" rel="stylesheet">
	<script src="configure/plugins/pace/pace.min.js"></script>



<script>
	function edit(order_id) {

	var currentURL = "OrderEdit?order_id="+order_id+"";
	
		
			location.href = currentURL;

	}
</script>

<script>
	function cancel(order_id) {

	var currentURL = "OrderCancel?order_id="+order_id+"";
	
		

			location.href = currentURL;

		

	}
</script>

<%-- <script>
	function orderLr(order_id,inquiry_id,source,destination,name,vendor,address,total1,total) {

	var currentURL = "OrderLRForm?order_id="+order_id+"&inquiry_id="+inquiry_id+"&source="+source+"&destination="+destination+"&name="+name+"&vendor="+vendor+"&address="+address+"&total1="+total1+"&total="+total+"";
	
		var okdelete = confirm("Are You Sure Want to LR!");

		if (okdelete)

		{

			location.href = currentURL;

		}
		

	}
</script> --%>


<script>
	function orderLr(order_id,lr_no,date) {

	var currentURL = "OrderLRForm?order_id="+order_id+"&lr_no="+lr_no+"&datee="+date+"";
	
		

			location.href = currentURL;


	}
</script>


<script>
	function vehicleChange(order_id,lr_no) {

	var currentURL = "VehicleChange?order_id="+order_id+"&lr_no="+lr_no+"";
	
		

			location.href = currentURL;

		

	}
</script>


<script>
function evalGroup()
{
	//alert("1");
	
var group = document.formid.dcno;
for (var i=0; i<group.length; i++) {
if (group[i].checked)
break;
}
if (i==group.length){
 alert("Please Check The Check Box..");
return false;
}
}
</script>

<script>
function getRNA(v)
{
	
	var myArray = [];
	var id = "";
	var oTable = $("#demo-dt-basic").dataTable();
	$(".class1:checked", oTable.fnGetNodes()).each(function() {
	    if (id != "") {
	        id = id + "~" + $(this).val();
	    } else {
	        id = $(this).val();
	    }
	});
	
	document.getElementById("vt1").value = id;
	 
	
		
}
</script>

<script>
function openPopupcust() {
	
	loadPopupcust();


}

</script>

<script>
	function CommonLr() {
		
		
		var aa=document.getElementById("vt1").value;
		
		//alert("AA:"+aa);
		

	var currentURL = "OrderCommonLr?order_id="+aa+"";
	
		
			location.href = currentURL;

	}
	
	
	function checkMobileLength1()
	{   
			var x=/[a-zA-Z]/g;
				
			var dealer_contact=document.getElementById("src_contact_no").value;
				
		 if(dealer_contact.length!=0)
			{
				if(dealer_contact.match(x))
				{
				alert("Only digit is allowed for mobile number")
				document.getElementById("src_contact_no").value='';
				document.getElementById("src_contact_no").focus();
				return false;
				}
				else if(dealer_contact.length<10||dealer_contact.length>10)
				{
				alert("Enter only 10 digits for mobile number");
				document.getElementById("src_contact_no").value='';
				document.getElementById("src_contact_no").focus();
				
				return false;
				}
			}
			
		
	}
	
</script>

</head>
<body>
	<div id="container" class="effect mainnav-lg">
		<jsp:include page="/common/data-tableheader.jsp"></jsp:include>
		<div class="boxed">
			<div id="content-container">
				<div id="page-title">
					
				</div>
				<div id="page-content">
					<div class="panel">
						
						
						<input type="hidden" name="vt1" id="vt1" >
						
						<div class="panel-heading">
							<h3 class="panel-title">Order Report</h3>
						</div>
						<div class="panel-body">
							<table id="demo-dt-basic" class="table table-striped table-bordered" cellspacing="0" width="100%">
								<thead>
									<tr>
										<!-- <th>select</th> -->
										<th>Sr No</th>
										<th>Order NO</th>
										<th>Customer Name</th>
										<th>Contact Person</th>
										<th>Contact Number</th>
										<th>Route</th>
										<th>Vehicle Type</th>
										
										<th>From</th>
										<th>To</th>
										<!-- <th>Total Weight</th>
										<th>Total Amount</th>  -->
										<th>Vehicle Change</th> 
										<th>LR</th> 
										<!-- <th>Distribute</th>  -->
										<th>Edit</th> 
										<th>Cancel</th>
										<th>SEND SMS</th> 
									</tr>
								</thead>
								
								<tbody>
								 <%int i=1; %>
								 <s:iterator value="inquiryReport">
									<tr class="item-row">
										<td><%=i++ %></td>
										<%-- <td><input  type="checkbox" class="class1" onclick="getRNA(this)" value="<s:property value="order_id"/>" name="dcno" id="dcno" /></td> --%>
										
										<td><s:property value="order_id"/></td>
										<td><s:property value="name"/></td>
										<td><s:property value="src_contact_person"/></td>
										
										<td><s:property value="src_contact_no"/></td>
										<td><s:property value="route"/></td>
										<td><s:property value="vehicle_type"/></td>
										<td><s:property value="source"/></td>
										<td><s:property value="destination"/></td>
										<%-- <td><s:property value="total1"/></td>
										<td><s:property value="total"/></td> --%>
											
										<td  align="center"><a style="text-decoration: none;color: green;" title="Vehicle" onclick="vehicleChange('<s:property value="order_id"/>','<s:property value="lr_no"/>')" >
											<img alt="Vehicle" height="35px;" src="configure/img/vehicles.png"></a>
									   </td>
											
										<td  align="center"><a style="text-decoration: none;color: green;" title="LR" onclick="orderLr('<s:property value="order_id"/>','<s:property value="lr_no"/>','<s:property value="date"/>')" >
											<img alt="LR" height="35px;" src="configure/img/order.png"></a>
									   </td>
									
										<%-- <td  align="center"><a style="text-decoration: none;color: green;" title="Distribute" onclick="quotation('<s:property value="order_id"/>','<s:property value="name"/>')" >
											<img alt="Distribute" height="35px;" src="configure/img/quot.png"></a>
									   </td> --%>
									
									
										<td  align="center"><a style="text-decoration: none;color: green;" title="Edit" onclick="edit('<s:property value="order_id"/>')" >
											<img alt="Edit" height="35px;" src="configure/img/editmeeting.svg"></a>
									   </td>
									
										<td  align="center"><a style="text-decoration: none;color: green;" title="Cancel" onclick="cancel('<s:property value="order_id"/>')" >
											<img alt="Cancel" height="35px;" src="configure/img/cancel.svg"></a>
									   </td>
									   
									   <td>	
									   
									   	<form action="manualsmssend" method="POST">
									   <input type="text" class="form-control" placeholder="Mobile No." id="src_contact_no" name="contact_no"   maxlength="10" onblur="checkMobileLength1(this);" required>
									   <input type="hidden" class="form-control"   id="order_id" name="order_id"   maxlength="10" value="<s:property value="order_id"/>" required>
									   <input type="submit" class="btn btn-primary" value="SEND" />		
									   	 
									   	 </form>
									   	      </td>
									
									
									</tr>
								 </s:iterator>
								
								</tbody>
								<!-- <tr>
								<td align="left"><input class="btn btn-primary" type="submit" onclick="CommonLr();" value="LR"></td>
								</tr> -->
								
							</table>
						</div>
						
					</div>
				</div>
			</div>
			
			<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
		
		</div>

		

		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->

	</div>
	<div id="demo-set" class="demo-set">
		<div class="demo-set-body bg-dark">
			<div id="demo-set-alert"></div>
			<div class="demo-set-content clearfix">
				<div class="col-xs-6 col-md-4">
					<h4 class="text-lg mar-btm">Animations</h4>
					<div id="demo-anim" class="mar-btm">
						<label class="form-checkbox form-icon active">
							<input type="checkbox" checked=""> Enable Animations
						</label>
					</div>
					<p>Transition effects</p>
					<select id="demo-ease">
						<option value="effect" selected>ease (Default)</option>
						<option value="easeInQuart">easeInQuart</option>
						<option value="easeOutQuart">easeOutQuart</option>
						<option value="easeInBack">easeInBack</option>
						<option value="easeOutBack">easeOutBack</option>
						<option value="easeInOutBack">easeInOutBack</option>
						<option value="steps">Steps</option>
						<option value="jumping">Jumping</option>
						<option value="rubber">Rubber</option>
					</select>
					<hr class="bord-no">
					<br>
					<h4 class="text-lg mar-btm">Navigation</h4>
					<div class="mar-btm">
						<label id="demo-nav-fixed" class="form-checkbox form-icon">
							<input type="checkbox"> Fixed
						</label>
					</div>
					<label id="demo-nav-coll" class="form-checkbox form-icon">
						<input type="checkbox"> Collapsed
					</label>
					<hr class="bord-no">
					<br>
					<h4 class="text-lg mar-btm">Off Canvas Navigation</h4>
					<select id="demo-nav-offcanvas">
						<option value="none" selected disabled="disabled">-- Select Mode --</option>
						<option value="push">Push</option>
						<option value="slide">Slide in on top</option>
						<option value="reveal">Reveal</option>
					</select>
				</div>
				<div class="col-xs-6 col-md-3">
					<h4 class="text-lg mar-btm">Aside</h4>
					<div class="form-block">
						<label id="demo-asd-vis" class="form-checkbox form-icon">
							<input type="checkbox"> Visible
						</label>
						<label id="demo-asd-fixed" class="form-checkbox form-icon">
							<input type="checkbox"> Fixed
						</label>
						<label id="demo-asd-align" class="form-checkbox form-icon">
							<input type="checkbox"> Aside on the left side
						</label>
						<label id="demo-asd-themes" class="form-checkbox form-icon">
							<input type="checkbox"> Bright Theme
						</label>
					</div>
					<hr class="bord-no">
					<br>
					<h4 class="text-lg mar-btm">Header / Navbar</h4>
					<label id="demo-navbar-fixed" class="form-checkbox form-icon">
						<input type="checkbox"> Fixed
					</label>
					<hr class="bord-no">
					<br>
					<h4 class="text-lg mar-btm">Footer</h4>
					<label id="demo-footer-fixed" class="form-checkbox form-icon">
						<input type="checkbox"> Fixed
					</label>
				</div>
				<div class="col-xs-12 col-md-5">
					<div id="demo-theme">
						<h4 class="text-lg mar-btm">Color Themes</h4>
						<div class="demo-theme-btn">
							<a href="#" class="demo-theme demo-a-light add-tooltip" data-theme="theme-light" data-type="a" data-title="(A). Light">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-navy add-tooltip" data-theme="theme-navy" data-type="a" data-title="(A). Navy Blue">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-ocean add-tooltip" data-theme="theme-ocean" data-type="a" data-title="(A). Ocean">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-lime add-tooltip" data-theme="theme-lime" data-type="a" data-title="(A). Lime">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-purple add-tooltip" data-theme="theme-purple" data-type="a" data-title="(A). Purple">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-dust add-tooltip" data-theme="theme-dust" data-type="a" data-title="(A). Dust">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-mint add-tooltip" data-theme="theme-mint" data-type="a" data-title="(A). Mint">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-yellow add-tooltip" data-theme="theme-yellow" data-type="a" data-title="(A). Yellow">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-well-red add-tooltip" data-theme="theme-well-red" data-type="a" data-title="(A). Well Red">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-coffee add-tooltip" data-theme="theme-coffee" data-type="a" data-title="(A). Coffee">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-prickly-pear add-tooltip" data-theme="theme-prickly-pear" data-type="a" data-title="(A). Prickly pear">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-a-dark add-tooltip" data-theme="theme-dark" data-type="a" data-title="(A). Dark">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
						</div>
						<div class="demo-theme-btn">
							<a href="#" class="demo-theme demo-b-light add-tooltip" data-theme="theme-light" data-type="b" data-title="(B). Light">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-navy add-tooltip" data-theme="theme-navy" data-type="b" data-title="(B). Navy Blue">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-ocean add-tooltip" data-theme="theme-ocean" data-type="b" data-title="(B). Ocean">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-lime add-tooltip" data-theme="theme-lime" data-type="b" data-title="(B). Lime">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-purple add-tooltip" data-theme="theme-purple" data-type="b" data-title="(B). Purple">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-dust add-tooltip" data-theme="theme-dust" data-type="b" data-title="(B). Dust">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-mint add-tooltip" data-theme="theme-mint" data-type="b" data-title="(B). Mint">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-yellow add-tooltip" data-theme="theme-yellow" data-type="b" data-title="(B). Yellow">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-well-red add-tooltip" data-theme="theme-well-red" data-type="b" data-title="(B). Well red">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-coffee add-tooltip" data-theme="theme-coffee" data-type="b" data-title="(B). Coofee">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-prickly-pear add-tooltip" data-theme="theme-prickly-pear" data-type="b" data-title="(B). Prickly pear">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-b-dark add-tooltip" data-theme="theme-dark" data-type="b" data-title="(B). Dark">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
						</div>
						<div class="demo-theme-btn">
							<a href="#" class="demo-theme demo-c-light add-tooltip" data-theme="theme-light" data-type="c" data-title="(C). Light">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-navy add-tooltip" data-theme="theme-navy" data-type="c" data-title="(C). Navy Blue">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-ocean add-tooltip" data-theme="theme-ocean" data-type="c" data-title="(C). Ocean">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-lime add-tooltip" data-theme="theme-lime" data-type="c" data-title="(C). Lime">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-purple add-tooltip" data-theme="theme-purple" data-type="c" data-title="(C). Purple">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-dust add-tooltip" data-theme="theme-dust" data-type="c" data-title="(C). Dust">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-mint add-tooltip" data-theme="theme-mint" data-type="c" data-title="(C). Mint">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-yellow add-tooltip" data-theme="theme-yellow" data-type="c" data-title="(C). Yellow">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-well-red add-tooltip" data-theme="theme-well-red" data-type="c" data-title="(C). Well Red">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-coffee add-tooltip" data-theme="theme-coffee" data-type="c" data-title="(C). Coffee">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-prickly-pear add-tooltip" data-theme="theme-prickly-pear" data-type="c" data-title="(C). Prickly pear">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
							<a href="#" class="demo-theme demo-c-dark add-tooltip" data-theme="theme-dark" data-type="c" data-title="(C). Dark">
								<div class="demo-theme-brand"></div>
								<div class="demo-theme-head"></div>
								<div class="demo-theme-nav"></div>
							</a>
						</div>
					</div>
				</div>
			</div>
			<div class="pad-all text-left">
				<hr class="hr-sm">
				<p class="demo-set-save-text">* All settings will be saved automatically.</p>
				<button id="demo-reset-settings" class="btn btn-primary btn-labeled fa fa-refresh mar-btm">Restore Default Settings</button>
			</div>
		</div>
		<button id="demo-set-btn" class="btn btn-sm"><i class="fa fa-cog fa-2x"></i></button>
	</div>

	<script src="configure/js/jquery-2.1.1.min.js"></script>
	<script src="configure/js/bootstrap.min.js"></script>
	<script src="configure/plugins/fast-click/fastclick.min.js"></script>
	<script src="configure/js/nifty.min.js"></script>
	<script src="configure/plugins/switchery/switchery.min.js"></script>
	<script src="configure/plugins/bootstrap-select/bootstrap-select.min.js"></script>
	<script src="configure/plugins/datatables/media/js/jquery.dataTables.js"></script>
	<script src="configure/plugins/datatables/media/js/dataTables.bootstrap.js"></script>
	<script src="configure/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>
	<script src="configure/js/demo/nifty-demo.min.js"></script>
	<script src="configure/js/demo/tables-datatables.js"></script>
</body>
</html>

