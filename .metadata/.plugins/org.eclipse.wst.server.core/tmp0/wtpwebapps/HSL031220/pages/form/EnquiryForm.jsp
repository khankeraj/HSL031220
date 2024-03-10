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
	
	
	<script src="js/datevalidation.js" type="text/javascript"></script>
	
	<script src="js/rangopopup.js" type="text/javascript"></script>
	
	<script>
	 $(function() {
		 $("#source").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#destination").autocomplete("GoogleSearch/autosearchCity.jsp");
		 $("#resource_from").autocomplete("GoogleSearch/autosearchResource.jsp");
		 $("#exim").autocomplete("GoogleSearch/autosearchResource2.jsp");
		 
		 $("#name").autocomplete("GoogleSearch/autosearchName.jsp");
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
			$("#date").focus();
			
			
		});
	
	</script>
	<script>
function checkMobileLength()
{   
		var x=/[a-zA-Z]/g;
			
		var dealer_contact=document.getElementById("contact_no").value;
			
	 if(dealer_contact.length!=0)
		{
			if(dealer_contact.match(x))
			{
			alert("Only digit is allowed for mobile number")
			document.getElementById("contact_no").value='';
			document.getElementById("contact_no").focus();
			return false;
			}
			else if(dealer_contact.length<10||dealer_contact.length>10)
			{
			alert("Enter only 10 digits for mobile number");
			document.getElementById("contact_no").value='';
			document.getElementById("contact_no").focus();
			
			return false;
			}
		}
		
	
}
</script>

<script>

$(document).ready(function() {
    $('form:first *:input[type!=hidden]:first').focus();
});
</script>



<script>
function getDetails(v){
	
	if (window.XMLHttpRequest) {
		var xp1=new XMLHttpRequest();
	}
	else {
		var xp1=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var name = $(v).val();
	
	
	
	//var s=document.getElementById("model").value;
	//alert("1::"+v);
	
	 xp1.open("POST","getCustomerDetails?name="+name);

	// alert("2");
	 
	xp1.send();
	
	//alert("3:");

	xp1.onreadystatechange=function() {

		//alert("4");
	if (xp1.readyState==4 && xp1.status==200) {
	
		var rep=xp1.responseText;
		
		//alert("Details:"+rep);
		
		var detail=rep.split("~");
		
		var name=detail[0];
		var contact=detail[1];
		
		
			
	document.getElementById("contact_person").value=name;
	document.getElementById("contact_no").value=contact;
	
	
	
}
	
};
	
}	


function openPopupcust() {
	
	loadPopupcust();


}

function disablePopup_cust() {
//disables popup only if it is enabled
if (popupStatus_cust == 1) {
$("#backgroundPopup").fadeOut("slow");
$("#popupContactcustomer").fadeOut("slow");
popupStatus_cust = 0;
}
}


function Addinfocust(v) {
	//alert("144444");

	if (window.XMLHttpRequest) {
		var xp11 = new XMLHttpRequest();
	} else {
		var xp11 = new ActiveXObject("Microsoft.XMLHTTP");
	}
		
	var temp=0;
	
		//alert("1");

	var tab1 = document.getElementById('loc').value;

	//	alert("2" + tab1);
	
	if(tab1=="")
	{
		 temp=false;
		 alert("Please Fill Location ");
		 document.getElementById('loc').focus();
		
	}
	
	else{
		
		 temp=true;
		
	}
		
		
	
		if(temp== true)
			{
				
	
	xp11.open("POST", "Add_New_Location?name=" + tab1 );
	
	xp11.send();
	//alert("343");
	xp11.onreadystatechange = function() {
	//	alert(xp11.readyState);
		if (xp11.readyState == 4 && xp11.status == 200) {
			///$("#popupContact").hide();
			//popupStatus = 0;
			//alert("rep"+xp11.responseText);
			if(xp11.responseText.trim()=="already"){
				alert("This Location already exists");
			}
		}
	};

	document.getElementById('loc').value = tab1;


	disablePopup_cust();
	
	
	}
		

		
	return temp;
	
}

</script>
<style>
#popupContactcustomer {
  position: fixed;
    top: 50%;
    left: 40%;
  transform: translate(-50%, -50%);
}
</style>



<%-- <script type="text/javascript">
function getfocus() {
	
	document.getElementById("date").focus();
	
}

</script> --%>




<script>
function myFunction() {
  document.getElementById("myBtn").disabled = true;
 /*  alert("Hiiiii"); */
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
					<h1 class="page-header text-overflow">Enquiry Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Enquiry</a></li>
					<li class="active">Enquiry Form</li>
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
								
								<form action="InquiryInsert" method="POST"  onsubmit="myFunction();">
									
									
									<div class="panel-body">
									
									  <div class="row">
									  
							
							 
									<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Date:</label> 
									
								<input type="text" class="form-control"  id="date" name="date" onblur="FixShortDate(this);return ValidateForm(this);" required>
												
									
									</div></div>
									
									
									
									<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Type:</label>
													
													<select class="form-control show-tick " name="type" id="type" required >
												
																<option value="">Select</option>
			
																<option value="Contracted">Contracted</option>
																<option value="Existing">Existing</option>
																<option value="Non Existing">Non Existing</option>
																
																
													</select>
												</div>
									  </div>
									
									</div>
									
									
									 
									  <div class="row">
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Customer Name :</label>
													<input type="text" class="form-control"  id="name" name="name" onblur="getDetails(this);"  required>
												</div>
									  </div>
									  
									  
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact Person :</label>
													<input type="text" class="form-control"  id="contact_person" name="contact_person"    required>
												</div>
									  </div>
									  
									 
									  </div>
									  
									  
									  <div class="row">
									 
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Contact No :</label>
													<input type="text" class="form-control"  id="contact_no" name="contact_no"   maxlength="10" onblur="checkMobileLength();" required>
											</div>
									  </div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Shipment Type :</label>
													<input type="text" class="form-control"  name="exim"  id="exim"  required>
												</div>
											</div>
									  
									  
									  </div>
									  
									  
									  
									  <div class="row">
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">From :</label>
													<input type="text" class="form-control"  name="source" id="source"    required>
												
												<input type="Button" class="btn btn-primary" value="Location" onclick="openPopupcust();" />
												</div>
									  </div>
									  
									  <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">To :</label>
													<input type="text" class="form-control"  name="destination"   id="destination" required>
												</div>
											</div>
											
										</div>	
										
										<div class="row">
											
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Resource:</label>
													
													<select class="form-control show-tick " name="resource" id="resource" >
												
																<option value=" ">Select</option>
			
																<option value="Email">Email</option>
																<option value="WhatsApp">WhatsApp</option>
																<option value="Phone">Phone</option>
																
																
													</select>
												</div>
									  </div>	
											
											
											
										<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Resource From :</label>
													<input type="text" class="form-control"  name="resource_from"  id="resource_from"  required>
												</div>
											</div>	
											
											</div>
											
											
										<div class="row">
											
											
											
											
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Remark :</label>
													<input type="text" class="form-control"  name="remark"  >
												</div>
											</div>
									  </div>
									
									
									
									
													
									  								
									  
									  <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit"   id="myBtn">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
									</div>
									  								
																	
									
								</form>
								
								
			<form action="#" id="popupContactcustomer" style="overflow:auto;background-color:#bdd7f9;width:600px;"  method="POST" style="">


				<center><h2>Location</h2></center>
				
				
					<div id="page-content" style=";">
					<div class="">
						
						<div class="">
							
							<div class="row">
							<div class="col-md-3">
                                            </div>	
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                  <center>  <label for="wlastName2">Location :
                                                    </label></center>
                                                    <input type="text" class="form-control"  id="loc"   name="loc"  required> 
                                                </div>
                                                <div class="form-group">
						
					&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick=" return Addinfocust(this);" class="btn btn-default w3ls-button">Submit</button>   
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button"  onclick="disablePopup_cust();" class="btn btn-default w3ls-button">&nbsp;&nbsp;&nbsp;Back&nbsp;&nbsp;&nbsp;</button> 
					</div>
                                       		 </div>
                                       		 
                                         		</div>
                                         		
                                         		
                                         		<div class="col-md-6">
                                            	</div>
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
    <%-- <jsp:include page="/common/settings.jsp"></jsp:include> --%>
    <jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<%-- <script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
 --%>

</body>
</html>

							
