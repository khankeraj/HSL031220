<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>

<%-- <script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="js/qrcode.min.js"></script>
<script type="text/javascript" src="js/qrcode.js"></script>
 --%>
<!--QR CODE  -->
<script type="text/javascript" src="js/JSS/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/JSS/kendo.all.min.js"></script>
<script type="text/javascript" src="js/JSS/kendo.common.min.css"></script>
<script type="text/javascript" src="js/JSS/kendo.mobile.all.min.css"></script>
<script type="text/javascript" src="js/JSS/kendo.rtl.min.css"></script>
<script type="text/javascript" src="js/JSS/kendo.silver.min.css"></script>


<!--END QR CODE  -->

 <!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->

<%String extracolumn="";
String manualauto="";
String partlabour="";
String withstock="";
String col1="";
String col2="";
String col3="";
String perunit="";

%>



<%-- <script type="text/javascript">
var qrcode = new QRCode(document.getElementById("qrcode"), {
	width : 50,
	height : 50
});

function makeCode () {		
	var elText = document.getElementById("text");
	
	if (!elText.value) {
		alert("Input a text");
		elText.focus();
		return;
	}
	
	qrcode.makeCode(elText.value);
}

makeCode();

$("#text").
	on("blur", function () {
		makeCode();
	}).
	on("keydown", function (e) {
		if (e.keyCode == 13) {
			makeCode();
		}
	});
</script>
 --%>



<script type="text/javascript">

	
	 
	 function printData()
	 {
		
		document.getElementById("Print").style.visibility="hidden";
		document.getElementById("Home").style.visibility="hidden";
	    window.print();
	    document.getElementById("Print").style.visibility="visible";
	    document.getElementById("Home").style.visibility="visible";
	   
	 }
	 
	 function goHome(){
		 
		 location.href="dashboard";
	 }
	 
	 
	 
	 </script>

<%-- <%
		/* Properties systemPropery = null;
		systemPropery = new Properties();

		//System.out.println(">>>>");
		systemPropery
				.load(new Spare_master_dao().getClass()
						.getResourceAsStream(
								"/com/aqua/dao/UserProfile.properties"));

		String name = systemPropery.getProperty("NAME");
		String address = systemPropery.getProperty("ADDRESS"); */
		
		
		String name="";
		String address="";
		String email="";
		String contact=""; 
		String bank="";
		String acno="";
		String ifsc="";
		String gstn="";
		String pan="";
		String discount="";
		String address2="";
		    try
		    {
		   	 DBConnection con=new DBConnection();
		    	Connection connection = con.getConnection();
								
				PreparedStatement preparedStatement112 = connection
				.prepareStatement("select * from settings ");
				//System.out.println("preparedStatement112"+preparedStatement112);
			ResultSet resultSet12 = preparedStatement112.executeQuery();

			if (resultSet12.next()) {
			
			
				 name = resultSet12.getString("companyname") ;
				 address = resultSet12.getString("address1") ;
				 address2 = resultSet12.getString("address2") ;
				 email = resultSet12.getString("email") ;
				 contact = resultSet12.getString("contact") ;
				 
				 bank = resultSet12.getString("bankname") ;
				 acno = resultSet12.getString("accountno") ;
				 ifsc = resultSet12.getString("ifsccode") ;
				 gstn = resultSet12.getString("gstnno") ;
				 pan = resultSet12.getString("panno") ;
				 
				 extracolumn = resultSet12.getString("extracolumn") ;
					manualauto = resultSet12.getString("manualauto") ;
					partlabour = resultSet12.getString("partlabour") ;
					withstock = resultSet12.getString("withstock") ;
					 
					col1 = resultSet12.getString("col1") ;
					col2 = resultSet12.getString("col2") ;
					col3 = resultSet12.getString("col3") ;
					discount = resultSet12.getString("discount") ;
			
					perunit= resultSet12.getString("perunit") ;
			}
				
		    }
		    catch(Exception e)
		    {
		    e.printStackTrace();
		    }
		     
		
		
		
		
	%> --%>
	

<head>
<style type="text/css"><!--

html,body,table#pagelayout {
height:98%;
width:99%;

}

// -->
</style>
</head>
<body>
<% int mycolspan=10; %>

<div >Original
<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">

</div>



 <s:push value="tripModel">

<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always"" >

<tr><td align="left" colspan="<%=mycolspan %>" style="border-right:1px solid #000000" >

<table width="100%"><tr><td><img src="configure/img/logo.png" width="150px" ></td>

<td align="center">

	<label style="margin-right:80px;margin-top: 0px;"><font size="5px;">High Seas Logistics Pvt. Ltd.</label>
	<br>
	<font size="3px;" style="margin-right: 100px;">			
	Corp. Office : Shop no. 10. Excel Enclave S. No.87/2,Main Road,
	</font>
	<br>
	<font size="2px;" style="margin-right: 150px;">			
	Kashid Park, Pimple-Gurav, Pune 411 061.Mob 8805854900 / 9372888900
	</font>
	
	<br>
	<font size="2px;" style="margin-right: 100px;">			
		www.highseaslogistics.com E-mail :morya@highseaslogistics.com
	</font>

<br>
<font size="3px;">			

</font><br>
</td>

<td><div id="qrcode"></div></td>

</tr></table>



</td>
</tr>

<tr><td align="center" colspan="<%=mycolspan %>" style="border-top: 1px solid #000000;border-right:1px solid #000000">
<font size="4px;"> <b>LR</b></font>
</td></tr>





<tr>
<td colspan="<%=mycolspan %>">


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">


<tr>
<td width="20%">
<font face="caibri" size="2px">LR NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="lr_number" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Date:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"> <s:property value="date" /> </font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px">Customer:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="customer_name" /></font>

</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Mobile No:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="mobile" /></font>
</td>
</tr>



<%-- <tr>
<td width="20%">
<font face="caibri" size="2px">Source:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="source" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Destination:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="destination" /></font></td>
</tr>
 --%>

<%-- <tr>
<td width="20%">
<font face="caibri" size="2px">Destination:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="destination" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Address:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="customer_addr" /></font>
</td>
</tr> --%>



<tr>
<td width="20%">
<font face="caibri" size="2px">Vehicle No:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="vehicle_no" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Driver Name:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="driver_name" /></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px">Volume:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="volume" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Insurance:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="insurance" /></font>
</td>
</tr>


<%-- <tr>
<td width="20%">
<font face="caibri" size="2px">Booking:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="booking" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Value Rs.:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="val_rupees" /></font>
</td>
</tr> --%>

<tr>
<td width="20%">
<font face="caibri" size="2px">Mode Of Freight:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="freight" /></font>
</td>

</tr>

</table>



<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">


<tr>
<td width="20%">
<font face="caibri" size="2px">Consignor Name:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="shipname" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Consignee Name:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"> <s:property value="loadname" /> </font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px">Address:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="shipadd" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Address:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="loadadd" /></font>
</td>
</tr>



<tr>
<td width="20%">
<font face="caibri" size="2px">State:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="shipstate" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">State:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="loadstate" /></font></td>
</tr>


<tr>
<td width="20%">
<font face="caibri" size="2px">Gstn:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="shipgstn" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">Gstn:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="loadgstn" /></font>
</td>
</tr>



</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="100%" align="center" >
&nbsp;
</td>
</tr>

</table>





</td>
</tr>













<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>SR</font></th>
						
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>No Of Packages</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Type Of Packing</font></th>	
		
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Description</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Vehicle Type</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Source</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Destination</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Weight</font></th>

					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Rate</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Amount</font></th>
			 -->					
					
				</tr>
					
				
					
			 <%int i=1; %>

	<c:forEach items="${tripModel.aa}" varStatus="loop">
				
						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;width:5%;"><font size="2" ><%=i++ %>&nbsp;&nbsp;</font></td>
								
						
					
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;width:5%;"><font face="caibri" size="2px"><c:out value="${tripModel.aa[loop.index]}"/></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.bb[loop.index]}"/></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.cc[loop.index]}"/></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.dd[loop.index]}"/></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.ee[loop.index]}"/></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.ff[loop.index]}"/></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.gg[loop.index]}"/></font></td>
							
							<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.hh[loop.index]}"/></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.ii[loop.index]}"/></font></td>
		 --%>
							
						</tr>



				
				</c:forEach>

<tr>
							
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<!-- <td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
 -->
						</tr>

				
				


		
					<tr style="height:100%;">
						
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
							
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<!-- <th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						 --><!-- <th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						 -->	
							</tr>

						
								
					<tr>
              		<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
						
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">Total Weight</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>

					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;"><s:property value="advance" /></td>
					
					<!-- <td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					 --></tr>
					
					
					
					<%-- <tr>
              		<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
						
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">Total Amount</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>

					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;"><s:property value="total_amount" /></td>
					</tr> --%>
					
								
							
								
								
								<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font face="caibri" size="2px"><b><%-- IN WORDS:<s:property
																			value="amountinwords" />&nbsp; ONLY</b> --%></font>
																
						</td>
								</tr>
							
								
									<%-- <tr>
									<td align="left" colspan="<%=mycolspan %>" style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										
										Total Amount : <s:property value="total_amount" /><input type="hidden" id="tot_amt" value="<s:property value="total_amount" />"/>
										<br>Total Weight &nbsp;&nbsp: <s:property value="advance" />
										
											</font>
									
</td></tr> --%>

<%-- <tr>


<td align="left" colspan="<%=mycolspan/2-2 %>" style="padding-left:5px;"
										>
									<font face="caibri" size="2px">Customer's Signature</font>
</td>
<td align="right" colspan="<%=mycolspan/2+2+1 %>" style="padding-right:5px;"
										>
									<font face="caibri" size="2px">For High Seas Logistics Pvt. Ltd,</b></font>
									<br><br>
									Booking Executive
</td>
								</tr> --%>







<tr>

<td colspan="<%=mycolspan -4%>" valign="top">
<table style="border-collapse:collapse;width:100%">


<tr>


<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;Booking Office No :</font>
</td>



<td width="30%" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;Destination Ph :</font>
</td>




<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;INVOICE NO :</font>
</td>
	
 

<td width="30%" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;VALUE Rs :</font>
</td>




</tr>



<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;MODE OF BOOKING :&nbsp;&nbsp;<s:property value="booking" /> </font>
</td>
	


<td width="30%" align="center" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;DELIVERY STATUS<br>DOOR/OUR OFFICE</font>
</td>




</tr>


<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;GST No :&nbsp;&nbsp;27AACCH9813K1Z9</font>
</td>
	
 

<td width="30%" align="center" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;PAN NO :&nbsp;&nbsp;AACCH9813K</font>
</td>




</tr>

<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;GST Transactions Covered Under Reverse Charge<br>&nbsp;&nbsp;SAC - 996791<br>&nbsp;&nbsp;Subject to Pune Jurisdiction only.<br>&nbsp;&nbsp;Goods booked & carried subject to conditions overleaf.</font>
</td>
	


<td width="30%" align="center" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="verdana" size="2px">&nbsp;&nbsp;OWNERS RISK</font>
</td>




</tr>

<tr>
<td width="50%" >
<font face="verdana" size="2px">Regd. Office : Flat no. 601, Block 4c, Kalpataru Estate-!!,Jawalkarnagar, Pimple-Gurav, Pune-411061.</font>
</td>
	
<td width="10%" style="border-right:1px solid #787f7a;">
<font face="verdana" size="2px"></font>
</td>

</tr>


 


</table>
</td>

<td colspan="4" align="center" style="width:20%;border-right: 1px solid #787f7a;">



<font face="caibri" size="2px"><b>For High Seas Logistics Pvt. Ltd,</b></font>
									<br><br><br><br>
									Booking Executive
</td>







</tr>
								
								
							
								
								
								
								
					</tbody>
			</table>		


</s:push>
	 <script>
    new QRCode(document.getElementById('qrcode'), 'LRNo: <s:property value="lr_number" />, Customer: <s:property value="customer_name" />, Date: <s:property value="date" />, Mobile: <s:property value="mobile" />');
 /*   var tot = document.getElementById('tot_amt').value;
    
   var qrcode = new QRCode(document.getElementById('qrcode'),
		   {
    text: 'LRNo: <s:property value="lr_number" />,  Date: <s:property value="date" /> ,Total Amount:'+tot, 
   width: 100,
   height: 100,
   colorDark : 'black',
   colorLight : 'white',
   correctLevel : QRCode.CorrectLevel.H
}); 
   /* 
   $("#qrcode").kendoQRCode({
	    value: ,
	    size: 300
	});
    */
   
</script>		

<script>
$("#qrcode").kendoQRCode({
  value: 'LRNo: <s:property value="lr_number" />, Customer: <s:property value="customer_name" />, Date: <s:property value="date" />, Mobile: <s:property value="mobile" />',
  size: 100
});
</script>

</body>
</html>




