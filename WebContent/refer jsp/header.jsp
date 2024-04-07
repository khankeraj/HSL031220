<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat "%>
<%@page import="java.util.Date "%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>VASAYA FOODS PVT. LTD.</title>
 	<link href="configure/css/online.css" rel="stylesheet">
	<link href="configure/css/bootstrap.min.css" rel="stylesheet">
	<link href="configure/css/nifty.min.css" rel="stylesheet">
	<link href="configure/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="configure/plugins/animate-css/animate.min.css" rel="stylesheet">
	<link href="configure/plugins/morris-js/morris.min.css" rel="stylesheet">
	<link href="configure/plugins/switchery/switchery.min.css" rel="stylesheet">
	<link href="configure/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
	<link href="configure/css/demo/nifty-demo.min.css" rel="stylesheet">
	<link href="configure/plugins/pace/pace.min.css" rel="stylesheet">
	<script src="configure/plugins/pace/pace.min.js"></script>
	
	
	<%-- <script src="Css/jquery-1.10.2.js" type="text/javascript"></script> --%>
 	 
  

	<script>  
	window.onload=function(){getTime();}  
	function getTime(){  
	var today=new Date();  
	var h=today.getHours();  
	var m=today.getMinutes();  
	var s=today.getSeconds();  
	// add a zero in front of numbers<10  
	m=checkTime(m);  
	s=checkTime(s);  
	document.getElementById('txt').innerHTML=h+":"+m+":"+s;  
	setTimeout(function(){getTime()},1000);  
	}  
	//setInterval("getTime()",1000);//another way  
	function checkTime(i){  
	if (i<10){  
	  i="0" + i;  
	 }  
	return i;  
	}  
</script> 

<script>
	function logout() {

	var currentURL = "Logout";
	
		var okdelete = confirm("Are You Sure Want to Logout!");

		if (okdelete)

		{

			location.href = currentURL;

		}
		

	}
</script>
<%-- <style>

.container1 {
    position: absolute;
    top: 50%;
    left: 50%;
    margin-right: -50%;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    text-align: center;
}

button {
    display: block;
    padding: 1em 2em;
    outline: none;
    font-weight: 600;
    border: none;
    color: #fff;
    background-color: #3498db;
    border: 1px solid #1f74ac;
    border-radius: 0.3em;
    margin-top: 4em;
    cursor: pointer;
}

button:hover {
    background-color: #2487c9;
}

/* Notifications */

.notificationx {
    display: inline-block;
    position: relative;
   /*  padding: 0.9em; */
    background: #3498db;
    border-radius: 0.2em;
    font-size: 1.7em;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.notificationx::before, 
.notificationx::after {
    color: #fff;
    text-shadow: 0 1px 3px rgba(0, 0, 0, 0.3);
}

.notificationx::before {
    display: block;
    content: "\f0f3";
    font-family: "FontAwesome";
    transform-origin: top center;
}

.notificationx::after {
    font-family: Arial;
    font-size: 0.7em;
    font-weight: 700;
    position: absolute;
    top: -15px;
    right: -15px;
    padding: 5px 8px;
    line-height: 100%;
    border: 2px #fff solid;
    border-radius: 60px;
    background: #3498db;
    opacity: 0;
    content: attr(data-count);
    opacity: 0;
    -webkit-transform: scale(0.5);
    transform: scale(0.5);
    transition: transform, opacity;
    transition-duration: 0.3s;
    transition-timing-function: ease-out;
}

.notificationx.notifyx::before {
    -webkit-animation: ring 1.5s ease;
    animation: ring 1.5s ease;
}

.notificationx.show-countx::after {
    -webkit-transform: scale(1);
    transform: scale(1);
    opacity: 1;
}

@-webkit-keyframes ring {
    0% {
        -webkit-transform: rotate(35deg);
    }
    12.5% {
        -webkit-transform: rotate(-30deg);
    }
    25% {
        -webkit-transform: rotate(25deg);
    }
    37.5% {
        -webkit-transform: rotate(-20deg);
    }
    50% {
        -webkit-transform: rotate(15deg);
    }
    62.5% {
        -webkit-transform: rotate(-10deg);
    }
    75% {
        -webkit-transform: rotate(5deg);
    }
    100% {
        -webkit-transform: rotate(0deg);
    }
}

@keyframes ring {
    0% {
        -webkit-transform: rotate(35deg);
        transform: rotate(35deg);
    }
    12.5% {
        -webkit-transform: rotate(-30deg);
        transform: rotate(-30deg);
    }
    25% {
        -webkit-transform: rotate(25deg);
        transform: rotate(25deg);
    }
    37.5% {
        -webkit-transform: rotate(-20deg);
        transform: rotate(-20deg);
    }
    50% {
        -webkit-transform: rotate(15deg);
        transform: rotate(15deg);
    }
    62.5% {
        -webkit-transform: rotate(-10deg);
        transform: rotate(-10deg);
    }
    75% {
        -webkit-transform: rotate(5deg);
        transform: rotate(5deg);
    }
    100% {
        -webkit-transform: rotate(0deg);
        transform: rotate(0deg);
    }
}
</style> 
<script>
var el = document.getElementById('n1');
//alert(">>>>1");
function myfun(){
var cnt=4;
/* $( "#notification1" ).click(function() { */


document.getElementById('n1').className = "notificationx show-countx";
  document.getElementById('n1').className = "notificationx notifyx show-countx";
document.getElementById("n1").setAttribute("data-count", cnt);
    if (count === 0) {
    	document.getElementById('n1').className = "notificationx notifyx show-countx";
    }


/* }); */
}   
</script> --%>


<script>
	
$(function() {
	
	
	if(document.getElementById("mys").value == "")
		{
		
		
		
		location.href="SessionOut";
		
		}


});
		
		
	
	</script>	

 <script>
 
 function TodaysVaccinations() {
 	
     <%
     
     String response1="0";
   
     
    
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	Date date = new Date();
     	
     	SimpleDateFormat sdfCreationDestination = new SimpleDateFormat("yyyy-MM-dd");
     	
      	
     	String dd=sdfCreationDestination.format(date);
     	
 		
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count1  from order_table WHERE  date='"+dd+"' and status='0' ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		if (resultSet12.next()) {
 	
 	
 		 response1 = resultSet12.getString("count1") ;
 				
 		
 			}
 		
     }
     catch(Exception e)
     {
     e.printStackTrace();
     }
     
     finally{
    	 
    	 
    	 DBConnection.closeConnection();
     }
     
      
     %>
     } 
 
 
 
 </script>  
 
 <script>
 $(function () {
	  $('[data-toggle="tooltip"]').tooltip()
	})
 </script>
 
  <style>


.badge {
  position: absolute;
  top: -1px;
  right: -4px;
  padding: 3px 7px;
  border-radius: 50%;
  background-color: #fc466d;
  color: white;
}
</style> 
 
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="asd();">


<!--NAVBAR-->
		<!--===================================================-->
		<header id="navbar">
			
			<div id="navbar-container" class="boxed">

				
				 <div class="navbar-header">
					<a href="#" class="navbar-brand">
						<div class="brand-title">
							<span class="brand-text"><img alt="" src="configure/img/logo-1.png"></span>
						</div>
					</a>
				</div> 
				
				
				<div class="navbar-content clearfix">
					
					
					<ul class="nav navbar-top-links pull-left">

						<!--Navigation toogle button-->
						<li class="tgl-menu-btn">
							<a class="mainnav-toggle" href="#">
							<i class="fa fa-navicon fa-lg"></i>
							</a>
						</li>
						
					</ul>
					
					
					
				 
    			
    			
    			<ul class="nav navbar-top-links pull-right">
      
     			 <li><a  class="btn btn-primary"> </a></li>
    			
    			</ul>
    			
    			
    			<ul class="nav navbar-top-links pull-right">
      
     			 <li><a onclick="logout();" class="btn btn-primary"> Logout</a></li>
    			
    			</ul>
					
					
				<ul class="nav navbar-top-links pull-right">
      
     			 <li><input type="hidden" value='<s:property value="#session.USER_PROFILE.username"/>' id="mys" /></li>
    			
    			</ul>
    			
    			
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Approval">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-external-link" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response1 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Vehicle Assign">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-truck" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response2 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Loading">
    			<li><a href="#" class="notification">
 					<i class="fa fa-drivers-license" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response3 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Bill">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-inr" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response4 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Bill Approve">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-money" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response5 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Delivery">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-hdd-o" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response6 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			
    			<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pending Transport Payment">
    			<li><a href="#" >
 					 <i class="fa fa-credit-card" style="color:white;font-size:25px" ></i>
  						<span class="badge"><%=response7 %></span>
				
					</a></li>
					
				</ul>
    			
    			
    			<%-- <ul class="nav navbar-top-links pull-right">
    			<li><a href="#" class="notification">
 					 <i class="fa fa-bell" style="font-size:36px"></i>
  						<span class="badge">3</span>
				
					</a></li>
					
				</ul>	 --%>
    			
				
				</div>
				
				
				
				
			</div>
		</header>
	
		
</body>
</html>