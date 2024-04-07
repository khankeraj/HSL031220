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
<html lang="en">
<head>
	
	<meta charset="utf-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<%-- <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script> --%>
	
	 <script src="js/loader.js" type="text/javascript"></script> 
	
	
	<script>
 
 function TodaysVaccinations() {
 	
     <%
     
     String response1="0";
     String response11="0";
     
     
    
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	/* Date date = new Date();
     	
     	SimpleDateFormat sdfCreationDestination = new SimpleDateFormat("yyyy-MM-dd");
     	 */
      	
     	/* String dd=sdfCreationDestination.format(date);
     	
 		 */
     	
     	 PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select count(*) as count1  from inquiry");
 		 

			ResultSet resultSet12 = preparedStatement112.executeQuery();

		if (resultSet12.next()) {
	
	
		 response1 = resultSet12.getString("count1") ;
				
		
			}
 		 

 		 PreparedStatement preparedStatement1123 = conn
 		.prepareStatement("select count(*) as count2  from inquiry WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')  ");
 		  		
 		ResultSet resultSet1123 = preparedStatement1123.executeQuery();

		if (resultSet1123.next()) {
	
	
		 response11 = resultSet1123.getString("count2") ;
				
		
			}
     	
     	//System.out.print("SQL:"+preparedStatement112);
 		
 		
 		
 		
 		
 		
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
 
 
 	
 function TodaysVaccinations1() {
	 	
     <%
     
     String response2="0";
     String response22="0";
     String saleresponse="0";
     String salemonthresponse="0";
     String purchaseresponse="0";
     String purchasemonthresponse="0";
     
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
     	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("select sum(total_amount) as count2  from lr  ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		if (resultSet12.next()) {
 	
 	
 		 response2 = resultSet12.getString("count2") ;
 				
 		
 			}
 		 
 		PreparedStatement preparedStatement1123 = conn
 		 		.prepareStatement("select sum(total_amount) as count3  from lr WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')");
 		 		  		
 		 		ResultSet resultSet1123 = preparedStatement1123.executeQuery();

 				if (resultSet1123.next()) {
 			
 			
 				 response22 = resultSet1123.getString("count3") ;
 						
 				
 					}
 		 
 		
 				PreparedStatement ps2 = conn
 				 		.prepareStatement("select sum(total) as tot  from invoice  ");
 				ResultSet rs2 = ps2.executeQuery();

 				if (rs2.next()) {
 			
 			
 					saleresponse = rs2.getString("tot") ;
 						
 				
 					}
 		
 				
 				PreparedStatement ps3 = conn
 		 		 		.prepareStatement("select sum(total) as mtot  from invoice WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')");
 		 		 		  		
 		 		 		ResultSet rs3 = ps3.executeQuery();

 		 				if (rs3.next()) {
 		 			
 		 				salemonthresponse = rs3.getString("mtot") ;
 		 						
 		 				
 		 					}
 		 				
 		 				
 		 				PreparedStatement ps4 = conn
 		 				 		.prepareStatement("select (SUM(IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00)) ) -( SUM(IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00))) as tot2  from vendor_creditdebit");
 		 				ResultSet rs4 = ps4.executeQuery();

 		 				if (rs4.next()) {
 		 			
 		 					purchaseresponse = rs4.getString("tot2");
 		 						
 		 				
 		 					}
 		 				
 		 				PreparedStatement ps5 = conn
 		 		 		 		.prepareStatement("select (SUM(IF(vendor_creditdebit.type='Credit',vendor_creditdebit.totalamount,0.00)) ) -( SUM(IF(vendor_creditdebit.type='Debit',vendor_creditdebit.totalamount,0.00))) as mtot2  from vendor_creditdebit WHERE date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d')");
 		 		 		 		  		
 		 		 		 		ResultSet rs5 = ps5.executeQuery();

 		 		 				if (rs5.next()) {
 		 		 			
 		 		 					purchasemonthresponse = rs5.getString("mtot2") ;
 		 		 						
 		 		 				
 		 		 					}
 		 		 				
 		 		 				if(purchasemonthresponse==null){
 		 		 					purchasemonthresponse="0";
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
 
 
 
 
 function TodaysVaccinations2() {
	 	
     <%
     
     String transpoter1="0";
     String transpoter12="0";
     
     
    
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
    	/*  PreparedStatement pst11=conn.prepareStatement("SELECT (SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00)) ) -( SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00))) AS total FROM customercreditdebit    ");
		 */	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("SELECT (SUM(IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00)) ) -( SUM(IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00))) AS total FROM transportercreditdebit ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		if (resultSet12.next()) {
 	
 	
 			transpoter1 = resultSet12.getString("total") ;
 				
 		
 			}
 		 
 		PreparedStatement preparedStatement1123 = conn
 		 		.prepareStatement("SELECT(SUM(IF(transportercreditdebit.type='Debit',transportercreditdebit.Amount,0.00)) ) -( SUM(IF(transportercreditdebit.type='Credit',transportercreditdebit.Amount,0.00))) AS total12 FROM transportercreditdebit WHERE Date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')");
 		 		  		
 		 		ResultSet resultSet1123 = preparedStatement1123.executeQuery();

 				if (resultSet1123.next()) {
 			
 			
 					transpoter12 = resultSet1123.getString("total12") ;
 						
 				
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
 
 
 
 
 
 
 
 function TodaysVaccinations23() {
	 	
     <%
     
     String cust1="0";
     String cust12="0";
     
     
    
     try
     {
    	 
    	 DBConnection connection=new DBConnection();
    	 Connection conn=connection.getConnection();
     	
     	
    	/*  PreparedStatement pst11=conn.prepareStatement("SELECT (SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00)) ) -( SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00))) AS total FROM customercreditdebit    ");
		 */	
     	PreparedStatement preparedStatement112 = conn
 		.prepareStatement("SELECT (SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00)) ) -( SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00))) AS total FROM customercreditdebit ");
 		
     	//System.out.print("SQL:"+preparedStatement112);
 		
 			ResultSet resultSet12 = preparedStatement112.executeQuery();

 		if (resultSet12.next()) {
 	
 	
 			cust1 = resultSet12.getString("total") ;
 				
 		
 			}
 		 
 		PreparedStatement preparedStatement1123 = conn
 		 		.prepareStatement("SELECT(SUM(IF(customercreditdebit.type='Debit',customercreditdebit.Amount,0.00)) ) -( SUM(IF(customercreditdebit.type='Credit',customercreditdebit.Amount,0.00))) AS total12 FROM customercreditdebit WHERE Date BETWEEN DATE_FORMAT(NOW() - INTERVAL 1 MONTH, '%Y-%m-01 00:00:00') AND DATE_FORMAT(LAST_DAY(NOW() - INTERVAL 1 MONTH), '%Y-%m-%d 23:59:59')");
 		 		  		
 		 		ResultSet resultSet1123 = preparedStatement1123.executeQuery();

 				if (resultSet1123.next()) {
 			
 			
 					cust12 = resultSet1123.getString("total12") ;
 						
 				
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
	
</head>
<body>
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->
		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<!--===================================================-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Dashboard</h1>
					<!-- <div class="searchbox">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search..">
							<span class="input-group-btn">
								<button class="text-muted" type="button"><i class="fa fa-search"></i></button>
							</span>
						</div>
					</div> -->
				</div>
				<!--End page title-->

				<!--Page content-->
				<div id="page-content">
					
					<div class="row">
						<div class="col-lg-12"><br>
					
					
					<div class="row">
						
						<div class="col-md-6 col-lg-3">
							<div class="panel panel-success panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-users fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=response11 %></p>
										<small class="text-uppercase">Current Month  Enquiries</small>
										<br><br>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="10" role="progressbar"></div>
								</div>
								
								<div class="pad-all media">
								<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-users fa-2x"></i>
										</span>
									</div>
								<div class="media-body">
										<p class="h3 text-thin media-heading"><%=response1 %></p>
										<small class="text-uppercase">Total Enquiries</small>
									</div>
									</div>
									
								
							</div>
						</div>
						<!--===================================================-->
						<!--End Tile with progress bar - (Visit Today)-->
					
					
						<!--Tile with progress bar - (Comments)-->
						<!--===================================================-->
						<div class="col-md-6 col-lg-3">
							<div class="panel panel-mint panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-comment fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=response22 %></p>
										<small class="text-uppercase">Current Month  Lr</small>
										<br><br>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="45.9" role="progressbar"></div>
								</div>
								
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-comment fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=response2 %></p>
										<small class="text-uppercase">Total Lr</small>
									</div>
								</div>
							
								
								<%-- <div class="pad-all text-right">
									<small><span class="text-semibold"><i class="fa fa-unlock-alt fa-fw"></i> </span> </small>
								</div> --%>
							</div>
						</div>
						
						<div class="col-md-6 col-lg-3">
							<div class="panel panel-purple panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=transpoter12 %></p>
										<small class="text-uppercase">Current Month Transporter Total Outstanding</small>
									</div>
									
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75" role="progressbar"></div>
								</div>
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=transpoter1 %></p>
										<small class="text-uppercase">Transporter Total Outstanding</small>
									</div>
								</div>
								
							</div>
						</div>
						
										
						<div class="col-md-6 col-lg-3" >
							<div class="panel panel-danger panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=cust1 %></p>
										<small class="text-uppercase">Current Month Customer Total Outstanding</small>
									</div>
								</div>
								<br>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75" role="progressbar"></div>
								</div>
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=cust12 %></p>
										<small class="text-uppercase">Customer Total Outstanding</small>
									</div>
								</div>
								
								
							</div>
						</div>
						
						
						
						<%-- <div class="col-md-6 col-lg-3">
							<div class="panel panel-purple panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading">5,345</p>
										<small class="text-uppercase">New Order</small>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 75%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75" role="progressbar"></div>
								</div>
								<div class="pad-all text-right">
									<small><span class="text-semibold"><i class="fa fa-shopping-cart fa-fw"></i> 954</span> Sales in this month</small>
								</div>
							</div>
						</div> --%>
						
						
						
						
						<%-- <div class="col-md-6 col-lg-3">
							<div class="panel panel-pink panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-dollar fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading">7,428</p>
										<small class="text-uppercase">Earning</small>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 37.4%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="37.4" role="progressbar"></div>
								</div>
								<div class="pad-all text-right">
									<small><span class="text-semibold"><i class="fa fa-dollar fa-fw"></i> 22,675</span> Total Earning</small>
								</div>
							</div>
						</div> --%>
						
						
						
						
						
						
						<%-- <div class="col-md-6 col-lg-3">
							<div class="panel panel-purple panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-shopping-cart fa-fw fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading">${total_outstanding }</p>
										<small class="text-uppercase">Transporter Total Outstanding</small>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 75%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="75" role="progressbar"></div>
								</div>
								<div class="pad-all text-right">
									<!-- <small><span class="text-semibold"><i class="fa fa-shopping-cart fa-fw"></i> 954</span> Sales in this month</small> -->
								</div>
							</div>
						</div> --%>
						
						
							</div>
						<div class="row">
						<div class="col-md-6 col-lg-3">
							<div class="panel panel-success panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-users fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=salemonthresponse %></p>
										<small class="text-uppercase">Current Month Sales</small>
										<br><br>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="10" role="progressbar"></div>
								</div>
								
								<div class="pad-all media">
								<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-users fa-2x"></i>
										</span>
									</div>
								<div class="media-body">
										<p class="h3 text-thin media-heading"><%=saleresponse %></p>
										<small class="text-uppercase">Total Sales</small>
									</div>
									</div>
									
								
							</div>
						</div>
						
						<div class="col-md-6 col-lg-3">
							<div class="panel panel-mint panel-colorful">
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-comment fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=purchasemonthresponse %></p>
										<small class="text-uppercase">Current Month  Purchase</small>
										<br><br>
									</div>
								</div>
								<div class="progress progress-xs progress-dark-base mar-no">
									<div style="width: 100%" class="progress-bar progress-bar-light" aria-valuemax="100" aria-valuemin="0" aria-valuenow="45.9" role="progressbar"></div>
								</div>
								
								<div class="pad-all media">
									<div class="media-left">
										<span class="icon-wrap icon-wrap-xs">
											<i class="fa fa-comment fa-2x"></i>
										</span>
									</div>
									<div class="media-body">
										<p class="h3 text-thin media-heading"><%=purchaseresponse %></p>
										<small class="text-uppercase">Total Purchase</small>
									</div>
								</div>
							
								
								<%-- <div class="pad-all text-right">
									<small><span class="text-semibold"><i class="fa fa-unlock-alt fa-fw"></i> </span> </small>
								</div> --%>
							</div>
						</div>
						
						</div>
						
						
						
<div class="row">


<div class="col-lg-6">
	<script type="text/javascript">
      
	google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	  //alert('11');
    	  	var p1 = 0;
			var p2 = 0;
			var p3 = 0;
			var p4 = 0;
			var p5 = 0;
			var p6 = 0;
			var p7 = 0;
			var p8 = 0;
			var p9 = 0;
			var p10 = 0;
			var p11 = 0;
			var p12 = 0;
			var myArray = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
    	  
  		
		var a = document.getElementById("graph1").value;
		
		var parts = a.split("-");
		
		
		j = 1;
		for (i = 1; i <= 12; i++) {
			
			try {
			
					var temp = parts[j - 1].split("~");
					
			    }catch (e) {
					// TODO: handle exception
					temp[0] = 0;
					temp[1] = i;
					
				}
			if (temp[1] == i) {
				myArray[i] = temp[0];
				j++;
			}
			else {

				myArray[i] = 0;

			}
			
			
		
	}
		
		
		p1 = parseInt(myArray[1]);
		p2 = parseInt(myArray[2]);
		p3 = parseInt(myArray[3]);
		p4 = parseInt(myArray[4]);
		p5 = parseInt(myArray[5]);
		p6 = parseInt(myArray[6]);
		p7 = parseInt(myArray[7]);
		p8 = parseInt(myArray[8]);
		p9 = parseInt(myArray[9]);
		p10 = parseInt(myArray[10]);
		p11 = parseInt(myArray[11]);
		p12 = parseInt(myArray[12]);
		
		
		var data = google.visualization.arrayToDataTable([
			[ 'Month', 'Amount' ], [ "JAN", p1 ],
			[ "FEB", p2 ], [ "MAR", p3 ], [ 'APR', p4 ],
			[ 'MAY', p5 ], [ 'JUN', p6 ], [ 'JUL', p7 ],
			[ 'AUG', p8 ], [ 'SEP', p9 ], [ 'OCT', p10 ],
			[ 'NOV', p11 ], [ 'DEC', p12 ]

		]);
		
		
		
        var options = {
                chart: {
                  title: 'Monthly Business',
               
                },
                bars: 'vertical' // Required for Material Bar Charts.
              };

        /* var options = {
                width: 600,
                height: 400,
                legend: { position: 'top', maxLines: 3 },
                bar: { groupWidth: '75%' },
                isStacked: true
              }; */
       
        var chart = new google.charts.Bar(document.getElementById('barchart_material'));

        chart.draw(data, google.charts.Bar.convertOptions(options));
      
      }
    </script>
						
	<input type="hidden" value="${graph1}" id="graph1">
						
						
 <div id="barchart_material" style="width: 100%; height: 400px;"></div>
						
						
	</div>
	
	
	
	<div class="col-lg-6">
							
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main=[];
	var qqq=['Order Lost Reasons','Count'];
	var tot_a="";
	var tot_b="";
	 
	main.push(qqq);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph2").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main.push(ucdt);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d").value = main;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd1= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d1").value = main;
		
 		var ucd2= [ qqq ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main);
		
		var options = {title: 'Order Lost Reasons Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div1'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options));
	};
      
    </script> 
						
						
						<input type="hidden" value="${graph2}" id="graph2"> 
										
										<input type="hidden" id="u_c_d" style="width: 100%; height: 400px;">
									
									<input type="hidden" id="u_c_d1" style="width: 100%; height: 400px;">
										
												
										 <div id="top_x_div1" style="width: 100%; height: 400px;"></div>	
						
						
						
						</div>
	
	
	
		</div>
						
						
						
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////////////// -->					
						
						
						
						
						<%-- <br><br>
						
						<div class="row">
						<div class="col-lg-6">
							
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main=[];
	var qqq=['Order Lost Reasons','Count'];
	var tot_a="";
	var tot_b="";
	 
	main.push(qqq);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph2").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main.push(ucdt);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d").value = main;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd1= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d1").value = main;
		
 		var ucd2= [ qqq ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main);
		
		var options = {title: 'Order Lost Reasons Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div1'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options));
	};
      
    </script> 
						
						
						<input type="hidden" value="${graph2}" id="graph2"> 
										
										<input type="hidden" id="u_c_d" style="width:700px;">
									
									<input type="hidden" id="u_c_d1" style="width:700px;">
										
												
										 <div id="top_x_div1" style="width: 900px; height: 350px;"></div>	
						
						
						
						</div>
						
						</div> --%>
						
						
						
	<!--/////////////////////////////////////////////////////////////////////////////////////////////////////////  -->					
						
						
						
		<br><br>
						
						<div class="row">
						<div class="col-lg-6">
							
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main1=[];
	var qqq1=['Resource Enquiry Graph','Count'];
	var tot_a="";
	var tot_b="";
	 
	main1.push(qqq1);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph3").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt1 =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main1.push(ucdt1);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d3").value = main1;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd13= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d13").value = main1;
		
 		var ucd23= [ qqq1 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main1);
		
		var options1 = {title: 'Resource Enquiry Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div13'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options1));
	};
      
    </script> 
						
						
						<input type="hidden" value="${graph3}" id="graph3"> 
										
										<input type="hidden" id="u_c_d3" style="width:400px;">
									
									<input type="hidden" id="u_c_d13" style="width:400px;">
										
												
										 <div id="top_x_div13" style="width: 100%; height: 400px;"></div>	
						
						
						
						</div>
						
						
						
	<!-- ////////////////////////////////////////////////////////////////////////////////////////////	 -->				
						
						
						<div class="col-lg-6">
							
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main4=[];
	var qqq4=['Resource Enquiry Graph','Amount'];
	var tot_a="";
	var tot_b="";
	 
	main4.push(qqq4);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph4").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt4 =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main4.push(ucdt4);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d4").value = main4;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd14= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d14").value = main4;
		
 		var ucd24= [ qqq4 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main4);
		
		var options4 = {title: 'Resource Enquiry Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div14'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options4));
	};
      
    </script> 
						
						
						<input type="hidden" value="${graph4}" id="graph4"> 
										
										<input type="hidden" id="u_c_d4" style="width:400px;">
									
									<input type="hidden" id="u_c_d14" style="width:400px;">
										
												
										 <div id="top_x_div14" style="width: 100%; height: 400px;"></div>	
						
						
						
						</div>
						
						
						
						
						</div>				
						
						
						<br><br>
						
						
						
						
						
						
						
						
						
						
											
						
						
						
				<div class="row">
						
												<div class="col-lg-6">	
					
					<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main7=[];
	var qqq7=['Shipment Type Graph','Amount'];
	var tot_a="";
	var tot_b="";
	 
	main7.push(qqq7);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph7").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt7 =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main7.push(ucdt7);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d7").value = main7;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd17= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d17").value = main7;
		
 		var ucd27= [ qqq7 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main7);
		
		var options7 = {title: 'Shipment Type Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div17'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options7));
	};
      
    </script><input type="hidden" value="${graph7}" id="graph7"> 
						
					
					
					<script src="js/loader.js" type="text/javascript"></script> 
  					
  					
										
										<input type="hidden" id="u_c_d7" style="width:400px;">
									
									<input type="hidden" id="u_c_d17" style="width:400px;">
										
												
										 <div id="top_x_div17" style="width: 100%; height: 400px;"></div>
					
					</div>
					
					
						
						<div class="col-lg-6">
						
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main6=[];
	var qqq6=['EXIM Resource Graph','Count'];
	var tot_a="";
	var tot_b="";
	 
	main6.push(qqq6);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph6").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt6 =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main6.push(ucdt6);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d6").value = main6;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd16= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d16").value = main6;
		
 		var ucd26= [ qqq6 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main6);
		
		var options6 = {title: 'EXIM Resource Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div16'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options6));
	};
      
    </script> 
						<input type="hidden" value="${graph6}" id="graph6"> 
						
					
					
										
										<input type="hidden" id="u_c_d6" style="width:400px;">
									
									<input type="hidden" id="u_c_d16" style="width:400px;">
										
												
										 <div id="top_x_div16" style="width: 100%; height: 400px;"></div>
						</div>
						
						
						
						
						
					
					
					
					
					<br><br>
					
					
						
						

						<br><br>	
					
					
					</div>
					
					<div class="row">
					<br><br>	
					
					<div class="col-lg-4">
						
						<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	var myArray2 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
	var r=[];
		
	var main5=[];
	var qqq5=['Resource Enquiry Business Graph','Amount','Amount'];
	var tot_a="";
	var tot_b="";
	var tot_c="";
	 
	main5.push(qqq5);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph5").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=0;
				    temp[2]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				myArray2[i]=temp[2];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				
				q[i]=parseInt(myArray1[i]);	
				
				//alert("p"+i+":"+p[i]);
				
				
				r[i]=myArray2[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt5 =[r[i],p[i],q[i]];
				
				//alert("UCDT::"+ucdt);
				
				main5.push(ucdt5);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d5").value = main5;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd15= [ ['Year', 'Total','Total'], ["abc", 1000,1000], ["b", 1000,1000],['c', 1170,1000],['d', 660,1000],['e', 1030,1000],['f', 1030,1000],['g', 1030,1000] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d15").value = main5;
		
 		var ucd25= [ qqq5 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main5);
		
		var options5 = {title: 'Resource Enquiry Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div15'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options5));
	};
      
    </script>
						
						<input type="hidden" value="${graph5}" id="graph5"> 
						
					
					
					
										
										<input type="hidden" id="u_c_d5" style="width:400px;">
									
									<input type="hidden" id="u_c_d15" style="width:400px;">
										
												
										 <div id="top_x_div15" style="width: 100%; height: 400px;"></div>
										 
										 
										 
						</div>
						
						
						
						
						
						
						
						
						<div class="col-lg-8">	
					
					<script type="text/javascript">
    
    
        google.charts.load('current', {'packages':['bar']});
		google.charts.setOnLoadCallback(drawStuff);
      
      
  	var myArray = [0, 0, 0,0,0,0,0,0,0,0];

	/*var q1=0;var q2=0;var q3=0;var q4=0;var q5=0;var q6=0;*/
	var myArray1 = [0, 0, 0,0,0,0,0,0,0,0];
	
	
	var p=[];
	var q=[];
		
	var main8=[];
	var qqq8=['Root Graph','Amount'];
	var tot_a="";
	var tot_b="";
	 
	main8.push(qqq8);
	
	

      function drawStuff() {
    	  
    	  
    	  var a = document.getElementById("graph8").value;
			
    	  
    	  //alert("A:"+a);
			
    	  var parts=a.split("-");
			
    		  
    	  j=1;	
    	  
    	  //alert("Length:"+parts.length);
    	  
    	  for(i=0;i<parts.length;i++){
  			
				try{
				
					var temp=parts[j-1].split("~");
				
				//alert("TEMP:"+temp);
				}catch (e) {
					// TODO: handle exception
					 temp[0]=0;
				    temp[1]=i;
				    
				    
				}
				
					
				
					
					
				myArray[i]=temp[0];		
				myArray1[i]=temp[1];
				
				j++;
				
				} 
			
    	  for(i=0;i<parts.length;i++)
			{
				p[i]=parseInt(myArray[i]);	
				//alert("p"+i+":"+p[i]);
				q[i]=myArray1[i];						

				
				//alert("Q"+i+":"+q[i]);
				
				ucdt8 =[q[i],p[i]];
				
				//alert("UCDT::"+ucdt);
				
				main8.push(ucdt8);
				
				
			}	
    	    
	    
			/* var tot=tot_a;
			
			var tot1=tot_b; */
  			
		document.getElementById("u_c_d8").value = main8;
 		
		//alert(main);    	 		 	 	
 		
 		var ucd17= [ ['Year', 'Total'], ["abc", 1000], ["b", 1000],['c', 1170],['d', 660],['e', 1030],['f', 1030],['g', 1030] ] ;
 		
 		//alert(ucd1);
 		
 		document.getElementById("u_c_d18").value = main8;
		
 		var ucd27= [ qqq8 ];
 	
 		
 		var data= google.visualization.arrayToDataTable(main8);
		
		var options8 = {title: 'Root Graph',};
		
	
		var chart = new google.charts.Bar(document.getElementById('top_x_div18'));
// Convert the Classic options to Material options.
			chart.draw(data,google.charts.Bar.convertOptions(options8));
	};
      
    </script><input type="hidden" value="${graph8}" id="graph8"> 
						
					
					
					<script src="js/loader.js" type="text/javascript"></script> 
  					
  					
										
										<input type="hidden" id="u_c_d8" style="width:400px;">
									
									<input type="hidden" id="u_c_d18" style="width:400px;">
										
												
										 <div id="top_x_div18" style="width: 100%; height: 400px;"></div>
					
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
			
			<!--ASIDE-->
			<aside id="aside-container">
				<div id="aside">
					<div class="nano">
						<div class="nano-content">
							
							<!--Nav tabs-->
							<ul class="nav nav-tabs nav-justified">
								<li class="active">
									<a href="#demo-asd-tab-1" data-toggle="tab">
										<i class="fa fa-comments"></i>
										<span class="badge badge-purple">7</span>
									</a>
								</li>
								<li>
									<a href="#demo-asd-tab-2" data-toggle="tab">
										<i class="fa fa-info-circle"></i>
									</a>
								</li>
								<li>
									<a href="#demo-asd-tab-3" data-toggle="tab">
										<i class="fa fa-wrench"></i>
									</a>
								</li>
							</ul>
							<!--End nav tabs-->



							<!-- Tabs Content -->
							<div class="tab-content">

								<!--First tab (Contact list)-->
								<div class="tab-pane fade in active" id="demo-asd-tab-1">
									<h4 class="pad-hor text-thin">
										<span class="pull-right badge badge-warning">3</span> Family
									</h4>

									<!--Family-->
									<div class="list-group bg-trans">
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av2.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Stephen Tran</div>
												<span class="text-muted">Availabe</span>
											</div>
										</a>
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av4.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Brittany Meyer</div>
												<span class="text-muted">I think so</span>
											</div>
										</a>
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av3.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Donald Brown</div>
												<span class="text-muted">Lorem ipsum dolor sit amet.</span>
											</div>
										</a>
									</div>


									<hr>
									<h4 class="pad-hor text-thin">
										<span class="pull-right badge badge-info">4</span> Friends
									</h4>

									<!--Friends-->
									<div class="list-group bg-trans">
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av5.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Betty Murphy</div>
												<span class="text-muted">Bye</span>
											</div>
										</a>
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av6.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Olivia Spencer</div>
												<span class="text-muted">Thank you!</span>
											</div>
										</a>
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av4.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Sarah Ruiz</div>
												<span class="text-muted">2 hours ago</span>
											</div>
										</a>
										<a href="#" class="list-group-item">
											<div class="media-left">
												<img class="img-circle img-xs" src="configure/img/av3.png" alt="Profile Picture">
											</div>
											<div class="media-body">
												<div class="text-lg">Paul Aguilar</div>
												<span class="text-muted">2 hours ago</span>
											</div>
										</a>
									</div>


									<hr>
									<h4 class="pad-hor text-thin">
										<span class="pull-right badge badge-success">Offline</span> Works
									</h4>

									<!--Works-->
									<div class="list-group bg-trans">
										<a href="#" class="list-group-item">
											<span class="badge badge-purple badge-icon badge-fw pull-left"></span> Joey K. Greyson
										</a>
										<a href="#" class="list-group-item">
											<span class="badge badge-info badge-icon badge-fw pull-left"></span> Andrea Branden
										</a>
										<a href="#" class="list-group-item">
											<span class="badge badge-pink badge-icon badge-fw pull-left"></span> Lucy Moon
										</a>
										<a href="#" class="list-group-item">
											<span class="badge badge-success badge-icon badge-fw pull-left"></span> Johny Juan
										</a>
										<a href="#" class="list-group-item">
											<span class="badge badge-danger badge-icon badge-fw pull-left"></span> Susan Sun
										</a>
									</div>

								</div>
								<!--End first tab (Contact list)-->


								<!--Second tab (Custom layout)-->
								<div class="tab-pane fade" id="demo-asd-tab-2">

									<!--Monthly billing-->
									<div class="pad-all">
										<h4 class="text-lg mar-no">Monthly Billing</h4>
										<p class="text-sm">January 2015</p>
										<button class="btn btn-block btn-success mar-top">Pay Now</button>
									</div>


									<hr>

									<!--Information-->
									<div class="text-center clearfix pad-top">
										<div class="col-xs-6">
											<span class="h4">4,327</span>
											<p class="text-muted text-uppercase"><small>Sales</small></p>
										</div>
										<div class="col-xs-6">
											<span class="h4">$ 1,252</span>
											<p class="text-muted text-uppercase"><small>Earning</small></p>
										</div>
									</div>


									<hr>

									<!--Simple Menu-->
									<div class="list-group bg-trans">
										<a href="#" class="list-group-item"><span class="label label-danger pull-right">Featured</span>Edit Password</a>
										<a href="#" class="list-group-item">Email</a>
										<a href="#" class="list-group-item"><span class="label label-success pull-right">New</span>Chat</a>
										<a href="#" class="list-group-item">Reports</a>
										<a href="#" class="list-group-item">Transfer Funds</a>
									</div>


									<hr>

									<div class="text-center">Questions?
										<p class="text-lg text-semibold"> (415) 234-53454 </p>
										<small><em>We are here 24/7</em></small>
									</div>
								</div>
								<!--End second tab (Custom layout)-->
							
								<!--Third tab (Settings)-->
								<div class="tab-pane fade" id="demo-asd-tab-3">
									<ul class="list-group bg-trans">
										<li class="list-header">
											<h4 class="text-thin">Account Settings</h4>
										</li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox" checked>
											</div>
											<p>Show my personal status</p>
											<small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small>
										</li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox" checked>
											</div>
											<p>Show offline contact</p>
											<small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small>
										</li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox">
											</div>
											<p>Invisible mode </p>
											<small class="text-muted">Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</small>
										</li>
									</ul>


									<hr>

									<ul class="list-group bg-trans">
										<li class="list-header"><h4 class="text-thin">Public Settings</h4></li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox" checked>
											</div>
											Online status
										</li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox" checked>
											</div>
											Show offline contact
										</li>
										<li class="list-group-item">
											<div class="pull-right">
												<input class="demo-switch" type="checkbox">
											</div>
											Show my device icon
										</li>
									</ul>



									<hr>

									<h4 class="pad-hor text-thin">Task Progress</h4>
									<div class="pad-all">
										<p>Upgrade Progress</p>
										<div class="progress progress-sm">
											<div class="progress-bar progress-bar-success" style="width: 15%;"><span class="sr-only">15%</span></div>
										</div>
										<small class="text-muted">15% Completed</small>
									</div>
									<div class="pad-hor">
										<p>Database</p>
										<div class="progress progress-sm">
											<div class="progress-bar progress-bar-danger" style="width: 75%;"><span class="sr-only">75%</span></div>
										</div>
										<small class="text-muted">17/23 Database</small>
									</div>

								</div>
								<!--Third tab (Settings)-->

							</div>
						</div>
					</div>
				</div>
			</aside>
		</div>
		
	<!-- FOOTER START HERE -->
	<jsp:include page="/common/footer.jsp"></jsp:include>
	<!-- FOOTER START HERE -->
	
	</div>
	<!-- END OF CONTAINER -->
	
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
</body>
</html>
