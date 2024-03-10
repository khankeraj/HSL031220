<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>
<%@page import="com.DB.DBConnection,java.sql.* "%>
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

 <%
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
		     
		
		
		
		
	%> 
	

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
<% int mycolspan=5; %>

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

<table width="100%"><tr><td><img src="configure/img/logo.png" width="150px" ></td><td align="center">

<font  face="caibri" size="5px;">	
<b><%=name %></b></font>
<br>
<font  face="caibri" size="3px;">			
Office Address :<%=address %>
</font>
<br>
<%
if(!address2.trim().equals("")) { 
	%>

<font  face="caibri" size="2px;">			
<%=address2 %><%=contact %>
</font>
<br>
<%}
%>
<font face="caibri" size="2px;">	
<%=email %></font>
<br>
<%-- <font size="3px;">			
<%=contact %>
</font> --%>

</td></tr>

</table>



</td>
</tr>

<tr><td align="center" colspan="<%=mycolspan %>" style="border-top: 1px solid #000000;border-right:1px solid #000000">
<font size="4px;" face="caibri"> <b>CONSIGNMENT NOTE</b></font>
</td></tr>





<tr>
<td colspan="<%=mycolspan%>" style="border-right:1px solid #000000">


<table width="100%" style="border: 1px solid #787f7a; border-right:1px solid #000000 border-collapse:collapse;" width="100%">

<tr>



<td width="60%" valign="top">
<table width="100%" style="border-right:1px solid #787f7a; borde:0px; border-collapse:collapse;" width="100%">
	
	<tr>
<td width="20%" colspan="4">
<font face="caibri" size="2px"><b>Consignor:</b></font>
</td>

<!-- <td width="20%">
<font face="caibri" size="2px"></font>
</td>
<td width="20%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"></font>
</td> -->
</tr>



<tr>
<!-- <td width="20%" colspan="2">
<font face="caibri" size="2px"> Party :</font>
</td> -->



</tr>

<tr>
<!-- <td width="20%">
<font face="caibri" size="2px"> Address:</font>
</td> -->
<td width="30%"  colspan="4" style="border-right:1px solid #787f7a; ">
<font face="caibri" size="2px"><s:property value="loadname" /></font>
</td>
</tr>
<tr>
<!-- <td width="20%">
<font face="caibri" size="2px"> Address:</font>
</td> -->
<td width="30%"  colspan="4" style="border-right:1px solid #787f7a; ">
<font face="caibri" size="2px"><s:property value="loadadd" /></font>
</td>
</tr>

<tr>
<td width="15%">
<font face="caibri" size="2px"> <b>State: </b></font>
</td>
<td width="30%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="loadstate" /></font>
</td>



<td width="15%">
<font face="caibri" size="2px"><b> GSTIN NO : </b></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="loadgstn" /></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Con Person: </b></font>
</td>
<td width="20%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="load_contact_person" /></font>
</td>


<td width="20%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"> <b>Con No: </b></font>
</td>
<td width="20%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="load_contact_no" /></font>
</td>
</tr>

<tr>
<td width="20%" colspan="4" style="border-top: 1px solid black;">
<font face="caibri" size="2px"><b> Consignee:</b></font>
</td>

<!-- <td width="20%" style="border-top: 1px solid black; ">
<font face="caibri" size="2px"></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a; border-top: 1px solid black;">
<font face="caibri" size="2px"></font>
</td> -->

</tr>

<tr>
<td width="30%" colspan="4" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="shipname" /></font>
</td>
</tr>
<tr>
<!-- <td width="21%">
<font face="caibri" size="2px"> Party :</font>
</td> -->


<!-- <td width="20%">
<font face="caibri" size="2px"> Address:</font>
</td> -->
<td width="30%" colspan="4" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="shipadd" /></font>
</td>

</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px"> <b>State: </b></font>
</td>
<td width="30%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="shipstate" /></font>
</td>
<td width="20%">
<font face="caibri" size="2px"> <b>GSTIN NO : </b></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="shipgstn" /></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px"> <b>Con Person: </b></font>
</td>
<td width="30%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="dest_contact_person" /></font>
</td>
<td width="20%">
<font face="caibri" size="2px"><b> Con No:</b></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="dest_contact_no" /></font>
</td>
</tr>
<tr>
<td width="100%" colspan="4" style="border-top: 1px solid black; border-right: 1px solid black;">
<font face="caibri" size="2px"><b>Buyer Other then Consignee: </b></font>
</td>
<!-- <td width="0%" style="border-right:0px solid #787f7a; border-top: 1px solid black;">
<font face="caibri" size="2px"></font>
</td>
<td width="0%" style="border-top: 1px solid black;">
<font face="caibri" size="2px"></font>
</td>
<td width="0%" style="border-right:1px solid #787f7a; border-top: 1px solid black;">
<font face="caibri" size="2px"></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px">  Party :</font>
</td> -->
<!-- <td width="50%" colspan="3" style="border-right:1px solid #787f7a; border-top:1px solid black;">
<font face="caibri" size="2px"></font>
</td> -->
</tr>
<tr>
<td width="30%"  colspan="4" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyername" /></font>
</td>
</tr>
<tr>
<!-- <td width="20%">
<font face="caibri" size="2px">  Address:</font>
</td> -->
<td width="30%" colspan="4" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyeradd" /></font>
</td>
</tr>

<tr>
<td width="20%" >
<font face="caibri" size="2px"> <b>State: </b></font>
</td>
<td width="30%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyerstatus" /></font>
</td>

<td width="20%">
<font face="caibri" size="2px"><b>GSTIN NO : </b></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyergstn" /></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px"> <b>Con Person:</b></font>
</td>
<td width="30%" style="border-right:0px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyer_contact_person" /></font>
</td>

<td width="20%">
<font face="caibri" size="2px"> <b>Con No: </b></font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="buyer_contact_no" /></font>
</td>
</tr>

<tr>
<td width="30%"  colspan="4" he style="border-right:1px solid #787f7a;">
<font face="caibri"  size="2px"> <br><br></font>
</td>
</tr>

</table>
</td>





<td width="40%" valign="top" >
<table width="100%"  height="100%"style="border: 0px solid #787f7a; border-bottom:0px;border-collapse:collapse;" width="100%" height="100%">
	
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Lr No</b></font>
</td>
<td width="30%" >
<font face="caibri" size="2px"><s:property value="lr_number" /></font>
</td>
</tr>
<tr>
<td width="20%" >
<font face="caibri" size="2px"><b>Date:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"> <s:property value="date" /> </font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>From:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="source" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>To:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="destination" /></font>

</td>

</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Booking Office:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px">8805854900</font>
</td>
</tr>

<tr>
<td width="20%"style="border-top: 1px solid #787f7a;">

<font face="caibri" size="2px"><b>Vehicle No:</b></font>
</td>
<td width="30%" style="border-top: 1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="vehicle_no" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Vehicle Type:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="vehicle_Type" /></font>
</td>

</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Mode of Booking:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="booking" /></font>
</td>

</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Mode Of Freight:</b></font>
</td>
<td width="30%" >
<font face="caibri" size="2px"><s:property value="freight" /></font>
</td>

</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Insurance:</b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="insurance" /></font>
</td>
</tr>
<tr>
<td width="20%" style="border-top:1px solid #787f7a;">
<font face="caibri" size="2px"><b> Invoice No : </b></font>
</td>
<td width="30%" style="border-top:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="invoice_No" /></font>
</td>
</tr>


<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Volume: </b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="volume" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px"><b>Invoice Value: </b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="invoice_value" /></font>
</td>
</tr>
<tr>
<td width="20%" style="border-left:0px solid #787f7a;">
<font face="caibri" size="2px"><b>Destination No: </b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="load_contact_no" /></font>
</td>
</tr>

<tr>
<td width="20%" style="border-left:0px solid #787f7a;">
<font face="caibri" size="2px"><b>Owners Risk: </b></font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="owner_risk" /></font>
</td>
</tr>


</table>
</table>











</td>
</tr>













			<tr>
					<td align="center" valign="middle" style="border:1px solid #787f7a;"  ><font face="caibri" size="2px"><b>SR</font></th>
						
					<td align="center" valign="middle" style="border:1px solid #787f7a;"width="15%" ><font face="caibri" size="2px"><b>No Of Packages</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" width="15%"><font face="caibri" size="2px"><b>Type Of Packing</font></th>	
		
					<td align="center" valign="middle" style="border:1px solid #787f7a;"width="50%" ><font face="caibri" size="2px"><b>Description(Content as Declared by Consignor)</font></th>
					
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Vehicle Type</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Source</font></th>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Destination</font></th>
					 -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;"width="20%" ><font face="caibri" size="2px"><b>Weight</font></th>

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
						
							<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.dd[loop.index]}"/></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.ee[loop.index]}"/></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><c:out value="${tripModel.ff[loop.index]}"/></font></td>
							 --%>
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
								
								
								<!-- 
								<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
								<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
								<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
								 -->
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
						
						
						<!-- 
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
							
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						 -->
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
					
						
					<!-- <td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">Total Weight</td>
					
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>

 -->
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

<td colspan="<%=mycolspan -0%>" valign="top">
<table style="border-collapse:collapse;width:100%">


<%-- <tr>


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




</tr> --%>


<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;">
<font face="caibri" size="2px">&nbsp;&nbsp;GST No :&nbsp;&nbsp;27AACCH9813K1Z9</font>
</td>
	
 

<td width="20%" align="center" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px"></font>
</td>

<td width="30%" align="center" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px"><b>For High Seas Logistics Pvt. Ltd,</b></font>
</td>




</tr>

<tr>
<td width="30%" style="border-bottom:1px solid #787f7a;">
<font face="caibri" size="2px">&nbsp;&nbsp;GST Transactions Covered Under Reverse Charge<br>&nbsp;&nbsp;SAC - 996791<br>&nbsp;&nbsp;Subject to Pune Jurisdiction only.<br>&nbsp;&nbsp;Goods booked & carried subject to conditions overleaf.</font>
</td>
	


<td width="20%" align="center"  rowspan="" style="border-left:1px solid #787f7a;  vertical-align: bottom;  border-bottom:1px solid #787f7a; border-right:1px solid #787f7a;">
<font face="caibri"  size="2px">Consignor Sign.</font>
</td>




</tr>

<tr>
<td width="50%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px">Regd. Office : Flat no. 601, Block 4c, Kalpataru Estate-!!,Jawalkarnagar, Pimple-Gurav, Pune-411061.</font>
</td>
	
<td width="20%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"></font>
</td>

</tr>
<tr>
<td width="50%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px">&nbsp;</font>
</td>
	

<td width="20%" align="center" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;border-right:1px solid #787f7a;" >
<font face="caibri" size="2px">Consignee Sign.</font>
</td>

<td width="30%" align="center" style="border-left:1px solid #787f7a;border-bottom:1px solid #787f7a;" >
<font face="caibri" size="2px">Booking Executive</font>
</td>

</tr>


 


</table>
</td>
<!-- 
<td colspan="6" align="center" style="width:40%;border-right: 1px solid #787f7a;border-left: 1px solid #787f7a;">



<font face="caibri" size="2px"><b>For High Seas Logistics Pvt. Ltd,</b></font>
									<br><br><br><br>
									Booking Executive
</td> -->







</tr>
								
								
							
								
								
								
								
					</tbody>
			</table>		



<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;page-break-after: always"" >

<tr><td align="left"  style="border-right:1px solid #000000" valign="top" >

<table width="100%" style="border: 1px solid #787f7a;"  ><tr><td><img src="configure/img/logo.png" width="150px" ></td><td align="center">

<font  face="caibri" size="5px;">	
<b><%=name %></b></font>
<br>
<font  face="caibri" size="3px;">			
Office Address :<%=address %>
</font>
<br>
<%
if(!address2.trim().equals("")) { 
	%>

<font  face="caibri" size="2px;">			
<%=address2 %><%=contact %>
</font>
<br>
<%}
%>
<font face="caibri" size="2px;">	
<%=email %></font>
<br>
<%-- <font size="3px;">			
<%=contact %>
</font> --%>

</td></tr>

</table>
</td>
</tr>


<tr>
<td align="left"  style="border-right:1px solid #000000" valign="top" >
<table width="100%" style="r">


<tr style=" margin: 0" > 
<td valign="top" style=" margin: 0" >
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">1</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px;">

 It shall be the absolute responsibility of consignor to insure the
 goods meant for transportation Otherwise carrier would not be liable for any loss/damage.

  </p></font>
</td>

</tr>



<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">2</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
 Carrier shall not be responsible in case of any damage/loss occurring due to fire strike,
 lost accident earthquake, flood or any other act of god. However carrier shall be discharged 
 in case of accident if presented proper fir, other document are shown.
  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">3</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
That the consignor/consignee would have to get the survey of goods/consignments if they are 
damaged during transit by general insurance and the survey must be done within a week of accident/ delivery.
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">4</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px;">
 The consignor has to necessarily indicate number of articles quality of articles,
 weather is the goods are fragile, highly inflammable perishable etc, otherwise The 
 carrier would not be liable for damage, loss, leakage or shortage.
  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">5</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The carrier can transship the goods from any vehicle to another, if three are chances of damage. 
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">6</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The consignor would have to inform in writing in advance, if the goods are not to be sent with the 
goods of other parties or goods  other quality otherwise transporter would not be liable and carrier
can send the goods as per its discretion.
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">7</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The consignor would have to inform in writing about the required vehicle for transportation.
Whether trucks or trailers depending upon the size of goods consignment,
risk of good products of dangerous nature, chemical products etc. 
otherwise the carrier would not be liable and the carrier would send the goods in ordinary manner and in ordinary vehicle.  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">8</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The carrier holds rights to exercise a line over the goods bailed and can with hold the goods if full charges are not paid.
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">9</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
Carrier is not liable for the deterioration of good resulting from natural causes like affect of temperature,
 weather conditions etc.
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">10</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The carrier shall have the right to dispose of the good after giving 15 days notice to the
consignee fails to receive the goods at the destination.  
  </p></font>
</td>

</tr>


<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">11</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
Interest  @ 24 % P.A  would be charged if the bill is not paid within contracting/agreed terms.

  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">12</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The carrier shall not be liable if the gods are not delivered within scheduled time due to any unavoidable circumstances.
  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">13</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
The carrier would not be liable for any shortage in delivery of goods unless if notified and statement
is made to that effect by the consignee on the copy of consignment note and destination copy of driver. 
The consignee should also take signature/thumb impression of the driver.
  </p></font>
</td>

</tr>

<tr>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">14</p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
	Any dispute would be reached subject to carriers act & under pune jurisdiction.       
  </p></font>
</td>

</tr>


<tr height="120px">
<td valign="top" height="120px">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; "></p></font>
</td>
<td valign="top">
<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; ">
	   
  </p></font>
</td>

</tr>

<!-- <td>




<font face="caibri" size="2px"><p style="line-height:1.1; word-spacing: 10px; margin: 4px; margin: 0;">
1.IT SHALL BE THE ABSOLUTE RESPONSIBILLITY OF CONSIGNOR TO INSURE THE<br>
 &nbsp; GOODS MEANT FOR TRANSPORTAIONS OTHERWISE CARRIER WOULD NOT BE<br>
 &nbsp; LIABLE FOR ANY LOSS/DAMAGE.
  <br>
2 CARRIER SHALL NOT BE RESPONSIBLE IN CASE OF ANY DAMAGE/LOSS OCCURING <br> DUE TO FIRE STRIKE,
  LOST ACCIDENT EARTHQUAKE,FLOOD OR ANY OTHRE ACT<br> OF GOD. HOWEVER CARRIER SHALL BE DISCHARGED 
  IN CASE OF ACCIDENT<br> IF PRESENTED PROPER FIR,OTHER DOCUMENT ARE SHOWN.
  <br>
3 THAT THE CONSIONGNOR /CONSIGNEE WOULD HAVE TO GET THE SURVEY OF GOODS/CONSIGNMENTS IF THEY 
  ARE DAMAGED DURING TRANSIT BY GENERAL INSURANCE AND THE SURVEY MUST BE DONE WITHIN A WEEK OF 
  ACCIDENT/DELIVERY.
4 THE CONSIGNOR HAS TO  NECESSARILY INDICATE NUMBER OF ARTICLES QUQLITY OF ARTICLES, WEATHER IS
  THE GOODS ARE FRAGILE,HIGHLY INFLAMMABLE PERISHABLE ETC.OTHERWISE THE CARRIERS
  WOULD NOT BE LIABLE FOR DAMAGE , LOSS , LEAKAGE OR SHORTAGE.
5 THE  CARRIER CAN TRANSHIP THE GOODS FROM ANY VEHICLE TO ANOTHER , IF THERE ARE CHANCES OF DAMAGE.
6 THE CONSIGNOR WOULD HAVE TO INFORM IN WRITING IN ADVANCE,IF THE GOODS ARE NOT TO BE SENT WITH 
  THE GOODS OFOTHER PARTIES OR GOODS OTHER QUQLITY OTHERWISE TRANSPPRTER
  WOULD NOT BE LIABLE AND CARRIER CAN SEND THE GOODS AS PER ITS DISCRETION.
7 THE CONSIGNOR WOULD HAVE TO INFORM IN WRITING ABOUT THE REQUIRED VEHICLE FOR TRANSPORTAION.
  WHETHER TRUCKS OR TRAILORS DEPENDING UPON THE SIZE OF GOODS CONSIGNMENT, RISK OF GOODS PRODUCTS OF 
  OF DANGEROUS NATURE, CHEMICAL PRODUCTS ETC. OTHERWISE THE CARRIER WOULD NOT BE LIABLE AND THE CARRIER
  WOULD SEND THE GOODS IN ORDINARY MANNER AND IN ORDINARY VEHICLE.
8 THE CARRIER HOLDS RIGHTS TO EXERCISE A LINE OVER THE GOODS BAILED AND CAN WITHHOLD THE GOODS IF
  FULL CHARGES ARE NOT PAID. 
9 CARRIER IS NOT LIABLE FOR THE DETERIORATION OF GOODS RESULTING FROM NETURAL CAUSES LIKE
  AFFECT OF TEMPERATURE, WEATHER CONDITIONS ETC.
10 THE CARRIER SHALL HAVE THE RIGHT TO DISPOSE OF THE GOODS AFTER GIVING 15 DAYS NOTICS TO
   THE CONSIGNEE FAILS TO RECEIVE THE GOODS AT THE DESTINATION.
11 INTEREST @24% P. A. WOULD BE CHARGED IF THE BILL IS NOT PAID WITHIN CONTRACTING TERMS.
12 THE CARRIER SHALL NOT BE LIABLE IF THE GOODS ARE NOT DELIVERED OF GOODS UNLESS IF NOTIFIED AND STATEMENT 
   IS MADE TO THAT EFFECT BY THE CONSIGNEE ON THE COPY OF CONSIGNMENT NOTE AND DESTINATION COPY OF DRIVER.
   THE CONSIGNEE SHOULD ALSO TAKE SIGNTURE//THUMB IMPRESSION OF THE DRIVER. 
13 THE CARRIER WOULD NOT BE LIABLE FOR ANY SHORTAGE IN DELIVERY OF DELIVERY OF GOODS UNLESS 
   IF NOTIFIED AND STATEMENT IS MADE TO THAT EFFECT BY THE CONSIGNEE ON THE COPY OF CONSIGMENT
   NOTE AND DESTINATION COPY OF DRIVER.
   THE CONSIGNEE SHOULD ALSO TAKE SIGNTURE/THUMB IMPRESSION OF THE DRIVER.
14 ANY DISPUTE WOULD BE REACHED SUBJECT TO CARRIER'S ACT AND UNDER PUNE JURISDICTION.
</p></font>
</td>
 -->

</table>
</td>
</tr>

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




