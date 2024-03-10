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


<script>

function PwdCheck()
{
	
	var aa=document.getElementById("password").value;
	
	var bb=document.getElementById("Confirm_New_Password").value;
	
		
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

<script>
function getDetails(){
	
	if (window.XMLHttpRequest) {
		var xp1=new XMLHttpRequest();
	}
	else {
		var xp1=new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	//var taxtype = $(v).val();
	
	
	 flag=1;
	
	var uname=document.getElementById("username").value;
	var pws=document.getElementById("current_password").value;
	
	//var s=document.getElementById("model").value;
	//alert("1::"+v);
	
	 xp1.open("POST","getUnamePwd?username="+uname+"&username="+pws);

	// alert("2");
	 
	xp1.send();
	
	//alert("3:");

	xp1.onreadystatechange=function() {

		//alert("4");
	if (xp1.readyState==4 && xp1.status==200) {
	
		var rep=xp1.responseText;
		
		
		var detail=rep.split("~");
		
		var name=detail[0];
		var city=detail[1];
		
		
			
		if(name==uname)
			
		{
			
		}
		
		else{
			
				
			flag=0;
		}
		
	
	if(city==pws)
			
		{
			
		}
		
		else{
			
				flag=0;
		
		}
	
}
	
	if(flag==0)
		
	{
		
		alert("Username and Password Do not Match..");
		
		document.getElementById("username").value='';
		document.getElementById("current_password").value='';
		
		return false;
	}
	
	else{
		
		return true;
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
					<h1 class="page-header text-overflow">Password Change</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">User</a></li>
					<li class="active">Password Changer</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								

								
						<form action="ChangePassAction" class="form-control" name="AmcModule" id="formID" >
 						
									
									<div class="panel-body">
									
									<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">UserName :
                                                    </label>
                                                    <input type="text" class="form-control"  id="username"   name="username" onchange="checkvalue();" required> 
                                                </div>
                                       		 </div>
                                       		 
                                       		 </div>
                                       		
                                       		
                                       		<div class="row"> 
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Current Password :
                                                    </label>
                                                    <input type="text" class="form-control"  id="current_password"   name="current_password" onblur="getDetails();" required> 
                                                </div>
                                       		 </div>
                                       	    
                                       		 
                                       		</div>
                                       		
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">New Password :
                                                    </label>
                                                    <input type="text" class="form-control"  id="password"  name="password"  required> 
                                                </div>
                                       		 </div>
                                       		 </div>
                                       		 
                                       		 <div class="row">
                                       		 <div class="col-md-6">
                                            	<div class="form-group">
                                                    <label for="wlastName2">Confirm New Password :
                                                    </label>
                                                    <input type="text" class="form-control"  id="Confirm_New_Password"   name="Confirm_New_Password" onblur="PwdCheck();" required> 
                                                </div>
                                       		 </div>
                                       	    
                                       		 
                                       		</div>
                                       		
                                       		
                                       		
                                       		<div class="row">
                                               
                                               <div class="col-md-6">
                                            	<div class="form-group">
                                                    <button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												
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
	<jsp:include page="/common/settingsForGrid.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
</body>
</html>

			
			
