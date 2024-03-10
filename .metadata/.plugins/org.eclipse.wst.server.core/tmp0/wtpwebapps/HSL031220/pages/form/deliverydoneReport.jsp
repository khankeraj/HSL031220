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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>

	<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.min.js" type="text/javascript"></script>
	
	

	


<!-- <script>
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
</script>  -->	


<script>
function getRNA(v)
{
	
	var myArray = [];
	var id = "";
	var names = "";
	var temp="";
	var oTable = $("#demo-dt-basic").dataTable();
	$(".class1:checked", oTable.fnGetNodes()).each(function() {
	  
		temp= $(this).val();
		 var models=temp.split("@");
		 var ids=models[0];
		 var name=models[1];
		 
		
		if (id != "") {
	        id = id + "~" + ids;
	        names = names + "~" + name;
	        
	    } else {
	        id =ids ;
	        names =name;
	    }
	});
	
	document.getElementById("vt1").value = id;
	document.getElementById("vt").value = names;
	
}
</script> 



<script>
	function CommonInvoice() {
		
		
		var aa=document.getElementById("vt1").value;
		var kk=document.getElementById("vt").value;
		
		//alert("AA:"+aa);
		
	if (aa != "") {
	
		var currentURL = "CommonInvoice?lr_no="+aa+"";
	
			

		
		 aa = aa.substring(0, aa.length);
		 //alert("s1 : "+s1); 
		 
		 var temp = kk.split("~");
		 
		for(i=0; i<temp.length; i++)
		{
			if(i<=temp.length-2)
			{
				if(temp[i]!=temp[i+1])
				{
					alert('Please select same Customer!');	
					return false;
				}
			}
		}
				location.href = currentURL;

		

		}
	
	else{
		
		alert("Please Check the Checkbox.");
		return false;
	}
	
		}
</script>






<script>

function CommonInvoice1() {
		
		
	var aa=document.getElementById("vt1").value;
	var kk=document.getElementById("vt").value;


	
	
		if (aa != "") {
	
			var currentURL = "CommonInvoiceCgst?lr_no="+aa+"";
	
			aa = aa.substring(0, aa.length);
			 //alert("s1 : "+s1); 
			 
			 var temp = kk.split("~");

			 var xx=0;
			for(i=0; i<temp.length; i++)
			{
				if(i<=temp.length-2)
				{
					if(temp[i]!=temp[i+1])
					{
						alert('Please select same Customer!');	
						return false;
					}
				}
				xx++;
			}
			if(xx===1)
					{
			
				location.href = currentURL;

					}
			else{
				alert("Please Check the Single Checkbox.");
				}
		}
		
		else{
			
			alert("Please Check the Checkbox.");
			return false;
		}

	}
</script>
 <script>
	function CommonInvoice2() {
		
		
		var aa=document.getElementById("vt1").value;
		var kk=document.getElementById("vt").value;
		
		if (aa != "") {
		
	
			var currentURL = "CommonInvoiceIgst?lr_no="+aa+"";
		
			aa = aa.substring(0, aa.length);
			 //alert("s1 : "+s1); 
			 
			 var temp = kk.split("~");
			 var xx=0;
			for(i=0; i<temp.length; i++)
			{
				if(i<=temp.length-2)
				{
					if(temp[i]!=temp[i+1])
					{
						alert('Please select same Customer!');	
						return false;
					}
				}
				xx++;
			}
			if(xx===1)
			{
	
						location.href = currentURL;

			}
				else{
					alert("Please Check the Single Checkbox.");
					}
	}
	else{
			
			alert("Please Check the Checkbox.");
			return false;
		}
		
	}
</script> 







<script>
	function quotation123(print_file) {

	var currentURL = "PricingQuotation123?print_file="+print_file+"";
	
		
			location.href = currentURL;


	}
</script>

<script>


function commForm()
{
	 
	 var s1 = document.getElementById("vt1").value;
	 //alert("s1 : "+s1);
	 
	
	 
	/*  var str = document.getElementById("t1").value;
	 
	 
	 var link = "commForm?str="+str+"&transporter_name="+temp[0];
		
		deleteOk = confirm('Are you sure you want to go to commision form?');
		
		if(deleteOk)
			{
				location.href = link;
			} */
		
	 
	 
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
					
					<input type="hidden" name="vt" id="vt" >
					
						<div class="panel-heading">
							<h3 class="panel-title">Delivery Done Report</h3>
						</div>
						<div class="panel-body">
							<table id="demo-dt-basic" class="table table-striped table-bordered" cellspacing="0" width="100%">
								<thead>
									<tr>
										<!-- <th>Select</th> -->
										
										<th>Sr No</th>
										
										<th>Customer Name</th>
										<th>Transporter Name</th>
										
										<th>LR No</th>
										<th>From</th>
										<th>To</th>
										<th>Vehicle No</th>
										<th>Driver Name</th>
										<th>Total Amount</th>
										<!-- <th>Print Document</th>
										 --><!-- <th>Invoice</th> -->
										<!-- <th>Invoice(IGST)</th> -->
										<!-- <th>Partial Invoice</th> -->
										
									</tr>
								</thead>
								
								<tbody>
								 <%int i=1; %>
								 <c:forEach items="${deliveryDetails}" var="deliveryDetails">
									<tr class="item-row">
										
										<%-- <td><input type="checkbox" name="${deliveryDetails.total_amount}" id="dcno" value="${deliveryDetails.total_amount}" onclick="getRNA(this);getRNA1(this);"> </td> --%>
										
										<%-- <td><input type="text" name="customer_name" id="customer_name" readonly value="<c:out value="${deliveryDetails.customer_name}" />"></td>
										<td><input type="text" name="transporter_name" id="transporter_name" readonly value="<c:out value="${deliveryDetails.transporter_name}" />"></td>
											
										<td><input type="text" value="<c:out value="${deliveryDetails.lr_number}" />" name="lr_number" id="lr_number" readonly></td>
										
										<td><input type="text" name="source" id="source" readonly value="<c:out value="${deliveryDetails.source}" />"></td>
										<td><input type="text" name="destination" id="destination" readonly value="<c:out value="${deliveryDetails.destination}" />"></td>
										
										<td><input type="text" name="vehicle_no" id="vehicle_no" readonly value="<c:out value="${deliveryDetails.vehicle_no}" />"></td>
										<td><input type="text" name="driver_name" id="driver_name" readonly value="<c:out value="${deliveryDetails.driver_name}" />"></td>
										<td><input type="text" name="total_amount" id="total_amount" readonly value="<c:out value="${deliveryDetails.total_amount}" />"></td> --%>
										
										
										<%-- <td><%=i++ %></td> --%>
										
										
										<td><input  type="checkbox" class="class1" onclick="getRNA(this);" value="<c:out value="${deliveryDetails.lr_number}" />@<c:out value="${deliveryDetails.customer_name}" />" name="dcno" id="dcno" /></td>
										
										<td><c:out value="${deliveryDetails.customer_name}" /></td>
										<td><c:out value="${deliveryDetails.transporter_name}" /></td>
											
										<td><c:out value="${deliveryDetails.lr_number}" /></td>
										
										<td><c:out value="${deliveryDetails.source}" /></td>
										<td><c:out value="${deliveryDetails.destination}" /></td>
										
										<td><c:out value="${deliveryDetails.vehicle_no}" /></td>
										<td><c:out value="${deliveryDetails.driver_name}" /></td>
										<td><c:out value="${deliveryDetails.total_amount}" /></td>
										<%-- <td><c:out value="${deliveryDetails.print_file}" /></td>
										 --%>
										<%-- <td  align="center"><a style="text-decoration: none;color: green;" title="Quotation" onclick="quotation123('<c:out value="${deliveryDetails.print_file}" />')" >
											<img alt="Quotation" height="35px;" src="configure/img/quot.png">
											<input type="text"value="<c:out value="${deliveryDetails.print_file}" />"  name="print_file12" id="print_file12" />
											</a>
											
									   </td>
 --%>										
										</tr>
								 </c:forEach>
								</tbody>
								</table>
							
								<input class="btn btn-primary" type="submit" onclick="CommonInvoice();" value="Invoice">
								
								<input class="btn btn-primary" type="submit" onclick="CommonInvoice1();" value="Invoice(CGST)">
								
								 <input class="btn btn-primary" type="submit" onclick="CommonInvoice2();" value="Invoice(IGST)"> 
								
								
							
							
							
									
							
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

