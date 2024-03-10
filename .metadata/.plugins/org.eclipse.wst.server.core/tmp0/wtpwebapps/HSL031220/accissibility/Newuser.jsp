 <%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

</head>
<script>
	$(function() {
		 $("#role_name").autocomplete("GoogleSearch/assigned_role.jsp");
		
	});
	</script>
<script type="text/javascript">
		
	function checkvalue()
	{
		//alert("sssss");
	    var username = $("#username").val();
	  
		var params ={ username:  username};
		//alert("---------"+product_name);
		$.ajax({ url: "ajax/Check_New_User.jsp",
			data: params,
			success: function showAlert(data){
				try{
				var rows = data.split("\n");
				var ii =0;
		         for (var i=0; i < rows.length; i++) {
		        	 var row = $.trim(rows[i]);
		        	 if(row)
						{
		        		 if(ii==0)
		        			 alert("Please Don't Repeat Username");
		        		 $('#username').val('');
						
		        	 ii++;
		        		 }
		         }			
                 
				}catch(er){alert(er);}
			},
			cache: false });
		
	 	}
	
	
	
	
	

</script>

<script>

function PwdCheck()
{
	
	var aa=document.getElementById("password").value;
	
	var bb=document.getElementById("rpassword").value;
	
		
	if(aa==bb)
		{
		
		alert("Password Match..");
		return true;
		
		}
	else
	
	{
		
		alert("Password Not Match..");
		return false;
		
		//document.getElementById("rpassword").value='';
		
		
		
	}

}


</script>

<%-- <script type="text/javascript">
  function valid()
  {
  if(isvalid())
	 
  {
     	
	  if(document.getElementById("username").value=="")
   		 
	  {
    	 alert("plases enter username");
   		 document.getElementById("username").focus();
   		 return false;
    	
	  }
    	
     	 if(document.getElementById("password").value=="")
   		 {
    	
    		alert("plases enter password");
    		
    		document.getElementById("password").focus();
    		
    		return false;
    		
   		 }
    		
    	if(document.getElementById("rpassword").value=="")
    		
    	{
    		alert("plases enter Re Type password");
    		document.getElementById("rpassword").focus();
    		return false;
    	
    	}
   
   	    if(document.getElementById("rpassword").document.getElementById("password"))
	  // if(Confirm_New_Password.match(password))
    		 {
    		alert("Confirm password is not match ");
    		document.getElementById("rpassword").focus();
    		return false;
              }
   	       return true;
            }
  else
	  {
	  alert("username and  password is not match ");
		//document.getElementById("Confirm_New_Password").focus();
		
	  return false;
	  }
    }
    


</script> --%>

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
					<h1 class="page-header text-overflow">New User</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">User</a></li>
					<li class="active">New User</li>
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

							<form action="NewUserAction"  name="f1" id="formID" method="post" >

			
										<div class="panel-body">
			
			
			
										<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">UserName :
                                                    </label>
                                                    <input type="text" class="form-control"  id="username" onchange="checkvalue();"  name="username"  required> 
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Role Name :
                                                    </label>
                                                    <input type="text" class="form-control"  id="role_name"   name="role_name"  required> 
                                                </div>
                                       		 </div>
                                       	    
                                       		 
                                       		</div>
                                       		
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Password :
                                                    </label>
                                                    <input type="password" class="form-control"  id="password"   name="password"  required> 
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Re Type Password :
                                                    </label>
                                                    <input type="password" class="form-control"  id="rpassword"   name="rpassword" onblur="PwdCheck();"  required> 
                                                </div>
                                       		 </div>
                                       	    
                                       		 
                                       		</div>
                                       		
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Address :
                                                    </label>
                                                    <input type="text" class="form-control"  id="address"   name="address"  > 
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Contact No :
                                                    </label>
                                                    <input type="text" class="form-control"  id="contact_no"   name="contact_no"  > 
                                                </div>
                                       		 </div>
                                       	    
                                       		 
                                       		</div>
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Email :
                                                    </label>
                                                    <input type="text" class="form-control"  id="email"   name="email"  > 
                                                </div>
                                       		 </div>
                                       		 
                                       		 
                                       		 
                                       		 
                                       		 
                                       		</div>
                                       		
                                       		
                                       		<div class="panel-footer" >
										
											<div class="col-sm-9 col-sm-offset-3">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

			
			
