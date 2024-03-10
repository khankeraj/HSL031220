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
	
	
	
	<style>
body {
  margin: 0 auto;
  max-width: 100%;
  padding: 0 20px;
}

.container {
  border: 2px solid #dedede;
  background-color: #f1f1f1;
  border-radius: 5px;
  padding: 10px;
  margin: 10px 0;
}

.darker {
  border-color: #ccc;
  background-color: #ddd;
}

.container::after {
  content: "";
  clear: both;
  display: table;
}

.container img {
  float: left;
  max-width: 100%;
  width: 50%;
  margin-right: 20px;
  border-radius: 20%;
}

.container img.right {
  float: right;
  margin-left: 20px;
  margin-right:0;
}

.time-right {
  float: right;
  color: #aaa;
}

.time-left {
  float: left;
  color: #999;
}
</style>

	
	
	
	</head>
<body>
	
	
	<s:push value="im">
		
		<%-- <div id="product" class="tab-pane table-responsive active">
												
															
					<table id="itemsTable" class="table table-striped table-bordered" cellspacing="0" width="100%">
																	
						<tr>
									
										<th id="VLsparename">Lr Number</th>
										<th id="VLsparename">Date</th>
										<th id="VLsparename">Status</th>
										
										
									</tr>
									
								<tbody>
								
								<s:iterator value="(sparesize).{# this}" status="stat">
									
									<tr id="sparesize${top}" class="item-row11"  >
								
									
										<td><input type="text"  style="width:80px;"  value="<s:property value="schemeid1[top]"/>"  /></td>
										<td><input type="text"  style="width:80px;" id="scname" name="scname" value="<s:property value="schemename1[top]"/>"  /></td>
										<td><input type="text"  style="width:250px;" value="<s:property value="city1[top]"/>"  /></td>
																							
																	

									</tr>


									
								</s:iterator>


			</table>	
</div>
 --%>
 
 
 
 <h2>Chat Messages</h2>
 <s:iterator value="(sparesize).{# this}" status="stat">
									
								

<%-- <div class="container">
  <img src="/w3images/bandmember.jpg" alt="Avatar" style="width:20%;">
  <p><s:property value="city1[top]"/></p>
  <span class="time-right"><s:property value="schemename1[top]"/></span>
</div> --%>

<div class="container " style="width: 100% ; <s:property value="schemeid1[top]"/>">

<!--   <img src="/w3images/avatar_g2.jpg" alt="Avatar" class="right" style="width:300px;"> -->
  <p  style="width:500px;" ><h3><s:property value="city1[top]"/></h3><br>
  <h4><s:property value="schemename1[top]"/></h4>  </p>
</div>


</s:iterator>

<%-- <div class="container">
  <img src="/w3images/bandmember.jpg" alt="Avatar" style="width:100%;">
  <p>Sweet! So, what do you wanna do today?</p>
  <span class="time-right">11:02</span>
</div>

<div class="container darker">
  <img src="/w3images/avatar_g2.jpg" alt="Avatar" style="width:100%;">
  <p>Nah, I dunno. Play soccer.. or learn more coding perhaps?</p>
  <span class="time-left">11:05</span>
</div> --%>
 
 
 
 
 

</s:push>

</head></html>
	