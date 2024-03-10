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
	

 
	<script>
	$(function() {

		 $("#vendor").autocomplete("GoogleSearch/transporterautosearch.jsp");
	
		 
	});
	</script>
	

	


<script>
function getRNA(v)
{
	
	var myArray = [];
	var id = "";
	var names = 0;
	var temp="";
	var oTable = $("#demo-dt-basic").dataTable();
	$(".class1:checked", oTable.fnGetNodes()).each(function() {
	  
		temp= $(this).val();
		 var models=temp.split("@");
		 var ids=models[0];
		var name=Number(models[1]);
		 
		
		if (id != "") {
	        id = id + "~" + ids;
	        names = names + name;
	        
	    } else {
	        id =ids ;
	        names =name;
	    }
	});
	
	document.getElementById("vt1").value = id;
	document.getElementById("other").value = id;
	
	document.getElementById("vt").value = names;
	document.getElementById("total_amount").value = names;
	
}
</script> 



<script>
	function billsubmit() {
		

		//totalQty();

		
		var aa=document.getElementById("vt1").value;
		var bb=document.getElementById("billno").value;
		
		
	if (aa != "") {
	
		//var currentURL = "CommonInvoice?lr_no="+aa+"";
		
			if ( bb != "") {

				 $("#myformsub").submit();
					
							
			}
			else{
				alert("Please Enter Bill No.");
				return false;
						
				}
		

		}
	
	else{
		
		alert("Please Check the Checkbox.");
		return false;
	}
	
		}
</script>





<script>
	
 function totalQty() {

		alert("dsfgdfgdg");

		var amount=0;
		var names = 0;
		var newlr=document.getElementById("vt1").value;

		 var models=newlr.split("~");

		 for(i=0; i<models.length; i++)
			{
			 alert("dsfgdfgdg----"+models[i]);
			}
		
		
			$('.item-row').each(function(i, row) {
	
				var $prices = $(row).find('#amount1');
				var $lrno = $(row).find('#lr_number1');
				
				var r11 = $($prices).val();
				var lrnum = $($lrno).val();


					
				alert("dsfgdfgdg----0000- price-----------"+r11);
				alert("dsfgdfgdg----0000 lr number------------"+lrnum+" -----and model is-----"+models);
				for(i=0; i<models.length; i++)
				{
						if(models[i]==lrnum)
						{

							 names = names + Number(r11);
						}
					
				}


			});

			alert("total amount----"+names)
			document.getElementById("vt").value = names;
			document.getElementById("total_amount").value = names;

			
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
					
					
					<input type="text" name="vt1" id="vt1" >
					
					<input type="text" name="vt" id="vt" >
					
					
					
						
					
							</div>
							
							<form action="Transporter_done_Reports1"  id="frmFileUpload">
					 <div class="row clearfix">
					 
                            <div class="col-sm-3">
                               Vendor Name:-
                                  <input type="text"  name="transporter_name" id="vendor"   required>
                                      
                            
                            </div>
                            <div class="col-sm-3">
                            <button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
														
							</div>
								
								</div>		
                           </form>
                           
                           
                           
							<br>
							<br>
							
							
							<form action="venderbillSubmit" class="form-control " id="myformsub" method="post">
							
							
							<div class="col-sm-3">
                               Bill No:-
                                  <input type="text"  name="bill_no" id="billno"   required>
                                      
                            
                            </div>
                            <div class="col-sm-4">
                               Vendor Name:-
                                  <input type="text"  name="transporter_name" id="transport_name" value="${vname}" required>
                                      
                            		 <input type="text"  name="transporter_code" id="transporter_code" value="${vid}" required>
                                 
                                 	 <input type="text"  name="other" id="other" value="${vid}" required>
                                 
                                 
                            </div>
							
							<br>
							<br>
							
							
						<div class="panel-body">
							<table id="demo-dt-basic" class="table table-striped table-bordered" cellspacing="0" width="100%">
								<thead>
									<tr>
										<!-- <th>Select</th> -->
										
										<th>Sr No</th>
										
											
										<th>LR No</th>
									
										<th>Customer Name</th>
									
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
										
										
										
										<td><input  type="checkbox" class="class1" onclick="getRNA(this);" value="<c:out value="${deliveryDetails.lr_number}" />@<c:out value="${deliveryDetails.total_amount}" />"  name="dcno" id="dcno" /></td>
										
										<td>
										 <input type="text" style="background-color: #f1dfdf;"  name="lr_number1" id="lr_number1" value="<c:out value="${deliveryDetails.lr_number}" />"   required readonly="readonly"></td>
										
                                  
										<td>
										 <input type="text" style="background-color: #f1dfdf;" name="customet_name" id="customet_name" value="<c:out value="${deliveryDetails.customer_name}" />"   required readonly="readonly"></td>
										
										<td>
										<input type="text" style="background-color: #f1dfdf;" name="from" id="from" value="<c:out value="${deliveryDetails.source}" />"   required readonly="readonly"></td>
										 
										<td>
										<input type="text" style="background-color: #f1dfdf;" name="description" id="description" value="<c:out value="${deliveryDetails.destination}" />"   required readonly="readonly"></td>
									
										
										<td>
										<input type="text" style="background-color: #f1dfdf;" name="vehicelno" id="vehicelno" value="<c:out value="${deliveryDetails.vehicle_no}" />"   required readonly="readonly"></td>
									
										<td>	
										<input type="text" style="background-color: #f1dfdf;" name="driver_name1" id="driver_name1" value="<c:out value="${deliveryDetails.driver_name}" />"   required readonly="readonly"></td>
									
										
										<td>
										<input type="text"  name="amount" id="amount1"  value="<c:out value="${deliveryDetails.total_amount}" />"   required></td>
									
										</tr>
								 </c:forEach>
								</tbody>
								</table>
							
							  <div class="col-sm-12">
                           
                                  <input type="hidden"  name="total_amount" id="total_amount"   required>
                                      
                            
                            </div>
							 <div class="col-sm-12">
								 <input class="btn btn-primary" type="submit" onclick="billsubmit();"  value="Submit">
								</div>
								
						</div>
						</form>
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
	
	
	<!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->
</body>
</html>

