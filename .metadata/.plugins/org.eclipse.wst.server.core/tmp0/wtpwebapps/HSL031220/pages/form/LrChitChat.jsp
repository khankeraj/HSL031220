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
  
  <script src="js/rangopopup.js" type="text/javascript"></script>
	
		
	 <script>
	 $(function() {
		  
		 $("#popupContactcustomer").hide();
		 
		 
		 
		});
	
	 $(function() {
			var today = new Date(); 
			var dd = today.getDate(); 
			var mm = today.getMonth()+1;//January is 0! 
			var yyyy = today.getFullYear(); 
			if(dd<10){dd='0'+dd} 
			if(mm<10){mm='0'+mm} 
			$("#date").val(dd+'/'+mm+'/'+yyyy);
			
			
		});
	 function disablePopup_cust() {
			//disables popup only if it is enabled
			if (popupStatus_cust == 1) {
				$("#backgroundPopup").fadeOut("slow");
				$("#popupContactcustomer").fadeOut("slow");
				popupStatus_cust = 0;
			}
		}
	
	</script>
	
<script>


function openPopupcust(){
		
	if (window.XMLHttpRequest) {
		var xp1 = new XMLHttpRequest();
	} else {
		var xp1 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//alert("1");
	
	var taxtype = document.getElementById('lr_number').value;
	
	//alert("Value:"+taxtype);
		
	
		xp1.open("POST","FetchLrChitChat?lr="+taxtype);
	
		//alert("2");
		
	    xp1.send();
	   // alert("3");

	   xp1.onreadystatechange=function() {

		   //alert("4");
		if (xp1.readyState==4 && xp1.status==200) {

			if(xp1.responseText!="nodata"){
				
				//alert("5");
				document.getElementById("documentNoSpan12").innerHTML=xp1.responseText;
			 	
				loadPopupcust();
				
	
			
     }
			else{
				
				
				alert("History Not Found...");
				return false;
			}
			
			}


	 	  };
	 	 	
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
					<h1 class="page-header text-overflow">LR Chit Chat Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">LR</a></li>
					<li class="active">LR Chit Chat Form</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								
								
							<form action="InsertLrChitChat" method="POST">
								
								<div class="panel-body">
								
								
								
								
								<div class="row">
											
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">Date:</label>
													<input type="text" class="form-control"  style="line-height: 15px;" name="date" id="date" readonly   required>
												</div>
											</div>
										</div>
										
										
										<div class="row">	
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">LR Number:</label>
													<input type="text" class="form-control"  name="lr_number" id="lr_number" value="${lr_number}"  readonly>
												</div>
											</div>
											
											
											<div class="col-md-3">
                                            	<div class="form-group">
                                                   
                                       		 
                                       		 <input type="Button" class="btn btn-primary" value="History" onclick="openPopupcust();">
                                       		 
                                       		 
                                       		 </div>
                                       	    
                                       		 </div>
									  
									 </div>
									 
									 
									 <div class="row">		
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark:</label>
													<input type="text" class="form-control"  name="remark" id="remark"   required>
												</div>
											</div>
											
											
											
									  </div>
									  
									  
									  
                      					
										
										
										<div class="row">		
											<div class="col-sm-6">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     
									</div>
								</form>
								
								
								<form action="#" id="popupContactcustomer" style="overflow:auto;background-color:#bdd7f9;width:600px;"  method="POST" style="">


				<center><h2>Chit Chat History</h2></center><br>
				
				
					<div id="page-content" style=";">
					<div class="">
						
						<div class="">
							
							<table align="center">
								
							<tr id= "editdiv12" >
				
							<td colspan="4"  style="height:1px">
				
								<div id="documentNoSpan12"></div>
							</td>
							</tr>
							
							
							
								
							</table>
							
							<table align="center">
							<tr>
							<td>
							<button  type="button"  onclick="disablePopup_cust();" class="btn btn-default w3ls-button">Back</button>
							</td>
							</tr>
							</table>
							
						</div>
                                         		
                                         		
                                         		
						</div>
					</div>
				
	
			
			
					

			</form>
										
					<div id="backgroundPopup"></div></div>
								
								
								
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
