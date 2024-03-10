<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.SimpleDateFormat "%>
<%@page import="java.util.Date "%>
<%@page import="com.DB.DBConnection,java.sql.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
 <!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <link href="configure/css/gcss.css" rel="stylesheet">
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
	<script type="text/javascript" src="js/loader.js"></script>
	<script type="text/javascript" src="configure/css/loader.js"></script>
	<script type="text/javascript" src="configure/css/jsapi.js"></script>
		
  
  
  
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->
	
	<script>
		
	/* google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart05);
	
	function drawChart05() {

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
		var q1 = 0;
		var q2 = 0;
		var q3 = 0;
		var q4 = 0;
		var q5 = 0;
		var q6 = 0;
		var q7 = 0;
		var q8 = 0;
		var q9 = 0;
		var q10 = 0;
		var q11 = 0;
		var q12 = 0;
		
		var myArray = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
		var myArray1 = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];
		var myArray2 = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]; 
		
		/* var myArray = [];
		var myArray1 = [];
		var myArray2 = []; */
		
		
		
		/* var p = [];
		var q = [];
		var r = [];
		var main1 = [];
		var qqq1 = [ 'Vehicle No', 'Amount' ];
		var tot_a = "";
		var tot_b = "";
		var tot_c = "";
		main1.push(qqq1);
		
		
		var a = document.getElementById("graph05").value;

		var parts = a.split("#");

		j = 1;

		for (i = 0; i < parts.length; i++) {

			try {
				/* var temp = parts[j - 1].split("~"); */
				/* var temp = parts[i].split("~");
				myArray[i] = temp[0];
				myArray1[i] = temp[1];
				myArray2[i] = temp[2];
			} catch (e) { */
				// TODO: handle exception

			/*}
			
			alert(temp[0]+" t0");
			alert(temp[1]+" t1");
			alert(temp[2]+" t2"); */
			
			/* try {
				var tempx = temp[1].split("-");
				

			} catch (e) {
				// TODO: handle exception
				tempx[0] = 0;
				tempx[1] = 0;
				//myArray1[i] = parseInt(tempx[0]);
				//myArray2[i] = parseInt(tempx[1]);
			}
			
			myArray1[i] = parseInt(tempx[0]);
			myArray2[i] = parseInt(tempx[1]); */
			
			//	alert(temp[0]+">>>"+i);
			/* if (temp[0] == i) {
				myArray1[i] = parseInt(tempx[0]);
				myArray2[i] = parseInt(tempx[1]);
				/* myArray1[i]=tempx[0];	
				myArray2[i]=tempx[1];	
				j++;
				 */

			/* } else {

				myArray1[i] = 0;
				myArray2[i] = 0;
			}  

			//		alert(myArray[i]+">>>"+myArray1[i]+">>>>"+myArray2[i]);
			//j++;
		}*/

		/* p1 = parseInt(myArray1[1]);
		p2 = parseInt(myArray1[2]);
		p3 = parseInt(myArray1[3]);
		p4 = parseInt(myArray1[4]);
		p5 = parseInt(myArray1[5]);
		p6 = parseInt(myArray1[6]);
		p7 = parseInt(myArray1[7]);
		p8 = parseInt(myArray1[8]);
		p9 = parseInt(myArray1[9]);
		p10 = parseInt(myArray1[10]);
		p11 = parseInt(myArray1[11]);
		p12 = parseInt(myArray1[12]);

		q1 = parseInt(myArray2[1]);
		q2 = parseInt(myArray2[2]);
		q3 = parseInt(myArray2[3]);
		q4 = parseInt(myArray2[4]);
		q5 = parseInt(myArray2[5]);
		q6 = parseInt(myArray2[6]);
		q7 = parseInt(myArray2[7]);
		q8 = parseInt(myArray2[8]);
		q9 = parseInt(myArray2[9]);
		q10 = parseInt(myArray2[10]);
		q11 = parseInt(myArray2[11]);
		q12 = parseInt(myArray2[12]);

		var data = google.visualization.arrayToDataTable([
				[ 'Month', 'Total Lead', 'Closed Lead' ],
				[ "JAN", p1, q1 ], [ "FEB", p2, q2 ],
				[ "MAR", p3, q3 ], [ 'APR', p4, q4 ],
				[ 'MAY', p5, q5 ], [ 'JUN', p6, q6 ],
				[ 'JUL', p7, q7 ], [ 'AUG', p8, q8 ],
				[ 'SEP', p9, q9 ], [ 'OCT', p10, q10 ],
				[ 'NOV', p11, q11 ], [ 'DEC', p12, q12 ]

		]);

		var options = {
			title : 'Count Of Lead And Closed Lead',
			hAxis : {
				title : 'Leads',
				titleTextStyle : {
					color : '#333'
				}
			},
			vAxis : {
				minValue : 0
			}
		};

		var chart = new google.visualization.ColumnChart(
				document.getElementById('chart_div05'));
		chart.draw(data, options); */
		
		/* for (i = 0; i < parts.length; i++) {

			p[i] = myArray[i];

			q[i] = parseInt(myArray1[i]);
			
			r[i] = parseInt(myArray2[i]);
			//alert("p"+i+":"+p[i]);
			//alert("q"+i+":"+q[i]);

			ucdt = [ p[i], q[i], r[i]];
	
			alert(ucdt);

			main1.push(ucdt);

			tot_a += p[i];
			tot_b += q[i];
			tot_c += r[i];
			
		}
		
		var tot = tot_a;

		var tot1 = tot_b;
		
		var tot2 = tot_c;

		document.getElementById("u_c_dX").value = main1;
		alert(main1+" mm");

		document.getElementById("u_c_d1X").value = main1;
		alert('here1');
		var ucd2 = [ qqq1 ];
		alert('here2');
		var data = google.visualization.arrayToDataTable(main1);
		alert('here3');
		var options = {
			title : 'Vehicle Comparison Graph',
			hAxis : {
				title : 'Vehicle',
				titleTextStyle : {
					color : '#333'
				}
			},
			vAxis : {
				minValue : 0
			}
		};
		alert('here4');
		var chart = new google.visualization.ColumnChart(
				document.getElementById('chart_div02'));
		alert('here5');
		chart.draw(data, options);
		alert('here6'); 

	} */

	
	
	
	</script> 
	
	
	
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
					<h1 class="page-header text-overflow">Resource Enquiry Graph </h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<!-- <ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Transport</a></li>
					<li class="active">Expense Form</li>
				</ol> -->
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
				
				
				<input type="hidden" value="${graph3}" id="graph3"> 
						
					
					
					<script src="js/loader.js" type="text/javascript"></script> 
  					
  					
										
										<input type="hidden" id="u_c_d3" style="width:700px;">
									
									<input type="hidden" id="u_c_d13" style="width:700px;">
										
												
										 <div id="top_x_div13" style="width: 900px; height: 350px;"></div>
					
										
					
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
