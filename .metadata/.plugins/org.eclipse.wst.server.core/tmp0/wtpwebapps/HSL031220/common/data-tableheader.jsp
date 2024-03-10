<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat "%>
<%@page import="java.util.Date "%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.sql.*"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>High Seas Logistics Pvt. Ltd.</title>
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
   
    var date=new Date();  
    var day=date.getDate();  
    var month=date.getMonth()+1;  
    var year=date.getFullYear(); 
    document.getElementById("date").innerHTML=Date is: day+"/"+month+"/"+year;
   
 </script> 
    
    
  <script>
 
 function TodaysVaccinations() {
 	
     <%
     
     String response1="0";
   
     int days=0;
     
     int count=0;
    
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select *  from alert_table WHERE   status='0' ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			
			Date datee = new Date();
					
			String dateBeforeString = df.format(datee);
			String dateAfterString = resultSet12.getString("exp_date");
				
			//Parsing the date
			LocalDate dateBefore = LocalDate.parse(dateBeforeString);
			LocalDate dateAfter = LocalDate.parse(dateAfterString);
				
			//calculating number of days in between
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
				
			//displaying the number of days
			System.out.println(noOfDaysBetween);
 			
			
			PreparedStatement pst1 = conn.prepareStatement("select no_of_days from no_of_days ");
			ResultSet rs1 = pst1.executeQuery();
		
			if(rs1.next())
			{
					days=rs1.getInt("no_of_days");
			}
			
			
			if(noOfDaysBetween <=days)
			{
				count++;
			}
			
 					
 		
 			}
 		
 		
 		response1 = String.valueOf(count) ;
 		
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
 
 
 
 	
 function TodaysVaccinations2() {
	 	
     <%
     
     String response2="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count2  from inquiry WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response2 = resultSet12.getString("count2") ;
 		
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
 
 
 
 function TodaysVaccinations3() {
	 	
     <%
     
     String response3="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count3  from pricing WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response3 = resultSet12.getString("count3") ;
 		
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
 
 
 
 
 
 function TodaysVaccinations4() {
	 	
     <%
     
     String response4="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count4  from quotation WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response4 = resultSet12.getString("count4") ;
 		
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
 
 
 
 function TodaysVaccinations5() {
	 	
     <%
     
     String response5="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count5  from pricing WHERE  status='2'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response5 = resultSet12.getString("count5") ;
 		
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
 
 
 
 function TodaysVaccinations6() {
	 	
     <%
     
     String response6="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count6  from order_table WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response6 = resultSet12.getString("count6") ;
 		
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
 
 
 
 
 
 function TodaysVaccinations7() {
	 	
     <%
     
     String response7="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count7  from lr WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response7 = resultSet12.getString("count7") ;
 		
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
 
 
 
 
 
 function TodaysVaccinations8() {
	 	
     <%
     
     String response8="0";
   
      
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count8  from delivery_done1 WHERE  status='0'  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		while (resultSet12.next()) {
 	
 	
 			response8 = resultSet12.getString("count8") ;
 		
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
	function logout() {

	var currentURL = "Logout";
	
		var okdelete = confirm("Are You Sure Want to Logout!");

		if (okdelete)

		{

			location.href = currentURL;

		}
		

	}
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
<body>

		<header id="navbar">
			
			<div id="navbar-container" class="boxed">

			
			<div class="navbar-header">
					<a href="dashboard" class="navbar-brand">
						<div class="brand-title">
							<span class="brand-text"><img style="margin-left: -10px;    width: 117px;    height: 46px;" alt="" src="configure/img/logo.png"></span>
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
						
						
					<!-- <ul class="nav navbar-top-links pull-right">
      
     			 		<li><a  class="btn btn-primary"> </a></li>
    			
    				</ul> -->
    				
    				
    				
    				<ul class="nav navbar-top-links pull-right">
      
     			 		<li><a onclick="logout();" class="btn btn-primary"> Logout</a></li>
    			
    				</ul>
					
					
					<%-- <ul class="nav navbar-top-links pull-right">
      
     					 <li><input type="hidden" value='<s:property value="#session.USER_PROFILE.username"/>' id="mys" /></li>
    			
    				</ul> --%>
    				
    				
    				<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Pricing Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-money" style="color:#229954    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response2 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Quotation Pending">
    					
    					<li>
    						<a href="#" class="notification">	
 							 
 							 	<i class="fa fa-pencil-square-o" style="color:#ff3300    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response3 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Quotation Finalize Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-quote-left" style="color:#ccff66    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response4 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Vehicle Assign Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-truck" style="color:#660066    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response5 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="LR Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-bell" style="color:#990099    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response6 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Delivery Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-hdd-o" style="color:#660066    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response7 %></span>
				
							</a>
						</li>
					
					</ul>
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Invoice Pending">
    					
    					<li>
    						<a href="#" class="notification">
 							 
 							 	<i class="fa fa-inr" style="color:#00cc00    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response8 %></span>
				
							</a>
						</li>
					
					</ul>
					
					
					<ul class="nav navbar-top-links pull-right" data-toggle="tooltip" data-placement="top" title="Expected Alert">
    					
    					<li>
    						<a href="AlertExpectedReport" class="notification">
 							 
 							 	<i class="fa fa-exclamation-triangle" style="color:#3333ff    ;font-size:25px" ></i>
  								
  								<span class="badge"><%=response1 %></span>
				
							</a>
						</li>
					
					</ul>
    			<ul class="nav navbar-top-links pull-right">
      
     			 		<li><input type="hidden" value='<s:property value="#session.USER_PROFILE.username"/>' id="mys" /></li>
    			
    				</ul>
    				
				</div>
			</div>
		</header>
	
		
</body>
</html>