<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.util.Calendar "%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>

<%String extracolumn="";
String manualauto="";
String partlabour="";
String withstock="";
String col1="";
String col2="";
String col3="";
String perunit="";

%>

<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/jquery-migrate-1.2.1.js"
	type="text/javascript"></script>
	 
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
		    	 DBConnection connection=new DBConnection();
		    	 Connection conn=connection.getConnection();
				
				PreparedStatement preparedStatement112 = conn
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
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"><!--

html,body,table#pagelayout {
height:98%;
width:99%;

}

@media print {
   .topcolor { background-color: #B2BABB !important; -webkit-print-color-adjust: exact;}
    
}

</style>



 <style>
.topcolor {background-color: #B2BABB;}

</style> 
</head>



<%--  <script type="text/javascript">
function totalnetamt2() {
	
	
	alert("111");
		var amt15=0;
		 amt1 = 0;

		alert("111");
		
	$('.item-row1').each(function(i, row) {
		
		alert("111222");
		
		var $gstamt1temp = $(row).find('#quantity1');
		var $gstamt1 = $($gstamt1temp).val();
		
		amt1 = Math.abs(amt1) + Math.abs($gstamt1);
		
		 alert("dd");
		 alert(amt1);
		
		});
	
	alert("111222333");
	 var ssno=document.getElementById("total12").value;
	 alert(ssno);
		alert("111222333444");
	document.getElementById("stot").value = Math.abs(amt15+ssno).toFixed(2);
}
</script>
  --%>


<body  >
<%
int mycolspan=10;

if(extracolumn.equals("0")) { 
	
}
if(extracolumn.equals("1")) { 
	mycolspan++;
}
if(extracolumn.equals("2")) { 
	mycolspan++;mycolspan++;
}
if(extracolumn.equals("3")) { 
	mycolspan++;mycolspan++;mycolspan++;
}
if(discount.equals("yes")) {
	mycolspan++;
 }
if(perunit.equals("yes")) {
	mycolspan++;
 }
%>

<div >Original
<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">

</div>

<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always"" >

<tr><td align="left" colspan="<%=mycolspan %>" style="border-right:1px solid #000000" >

<table width="100%"><tr><td><img src="configure/img/logo.png" width="150px" ></td><td align="center">

<font  face="caibri" size="5px;">	
<b><%=name %></b></font>
<br>
<font  face="caibri" size="2px;">			
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

<tr><td align="center" colspan="<%=mycolspan%>" style="border-top: 1px solid #000000;border-right:1px solid #000000">
<font size="4px;"> <b> PROFORMA  INVOICE</b></font>
</td></tr>



<tr>
<td colspan="<%=mycolspan %>">

	
<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">PI NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><b><s:property value="invoiceno" /></b></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">GSTN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><%=gstn%> <%-- <s:property value="KM" /> --%></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="1px">PI DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="date" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">PAN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><%=pan %></font>
</td>
</tr>



<%-- <tr>
<td width="20%">
<font face="caibri" size="1px">REVERSE CHARGE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">&nbsp;</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">CATEGORY:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><font face="caibri" size="1px">INDUSTRIAL CONSUMER <s:property value="Model" /></font>
</td>
</tr>
 --%>

<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">27&nbsp;&nbsp;&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">PAYMENT TERMS:</font>
</td>
<td width="30%">
${termcond }
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


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="50%" align="center" >
<font face="caibri" size="1px">BILL TO PARTY</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font face="caibri" size="1px">&nbsp;</font>
</td>
</tr>

</table>

<s:iterator value="Report2">
<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><b><s:property value="customer_name" /></b></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">MOBILE NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="mobile" /></font>
</td>
</tr>


					

<tr>
<td width="20%">
<font face="caibri" size="1px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="customer_addr" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">CONTACT PERSON</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="load_contact_person" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="gstin1" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">CONTACT NO</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="load_contact_no" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">PAN NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="path2" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">GST-</font>
</td>
<td width="30%">
<font face="caibri" size="1px">Transaction Covered Under Reverse Charges</font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="state1" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px"><!-- E way Bill NO <br> E way Bill DATE: --></font>
</td>
<td width="30%">
<font face="caibri" size="1px"></font>
</td>
</tr>


<%-- <tr>
<td width="20%">
<font size="2px"><font face="caibri" size="1px">KIND ATTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="contactp" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px"><font face="caibri" size="1px">CONTACT:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="contactpno" /></font>
</td>
</tr>
 --%>


</table>

</s:iterator>


<%-- <table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="invoiceno" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">GSTN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="gstn" /></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="1px">INVOICE DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="date" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">JOb No:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="job_no" /></font>
</td>
</tr>



<tr>
<td width="20%">
<font face="caibri" size="1px">Bill To:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="destination" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">Service Code:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="source" /></font></td>
</tr>

</table>






<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="100%" align="center" >
&nbsp;
</td>
</tr>

</table> --%>




</td>
</tr>

<tr class ="topcolor">
				<td align="center" valign="middle" style="border:1px solid #787f7a;width:10%;" ><font face="caibri" size="1px"><b>SR</font></td>
						
						
						
				<td align="center" valign="middle" style="border:1px solid #787f7a;width:10%;" ><font face="caibri" size="1px"><b>LR NO</font></td>
				<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="1px"><b>DATE</font></td>
				<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;width:20%;" ><font face="caibri" size="1px"><b>CONSIGNOR</font></td>
				
				<td align="center" valign="middle" style="border:1px solid #787f7a;width:20%;" ><font face="caibri" size="1px"><b>CONSIGNEE</font></td>


					<td align="center" valign="middle" style="border:1px solid #787f7a;width:15%;" ><font face="caibri" size="1px"><b>FROM</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;width:15%;" ><font face="caibri" size="1px"><b>TO</font></td>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;width:15%;" ><font face="caibri" size="1px"><b>WEIGHT</font></td>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">RATE</font></td>

					 -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;width:10%;" ><font face="caibri" size="1px"><b>AMOUNT</font></td>
				</tr>
					
				
			<!-- 	<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					
						
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
				</tr> -->
					
			
 <%int i=1; %>
	<s:iterator value="invoicebean_1" var="myobj">
				
						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><%=i++ %>&nbsp;&nbsp;</font></td>
								
						
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="aa1" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="bb1" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="cc1" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="dd1" /></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="1px"><s:property value="ee1" /></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="ff1" /></font></td>

							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="gg1" /></font></td>
							<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="hh1" /></font></td>
 --%>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="ii1" /></font></td>

							
						
						</tr>


				
			
				
		</s:iterator>
				
				
				
				
				
			
				
				

		<!-- <tr>
							<td align="center" style="border-right: 1px solid #787f7a; padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>

<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
					</tr>
 -->
				
				


		
					<tr style="height:100px;">
						<th align="center" valign="middle"style="border-left: 1px solid grey;border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
							
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
					
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<!-- <th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						 --><th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
				
						</tr>
						
						
						<tr  class ="topcolor">
				<td align="center" valign="middle" style="border:1px solid #787f7a;width:10%;" ><font face="caibri" size="1px"><b>SR</font></td>
						
						
						
					<td align="center" colspan="" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="1px"><b>VCH NO</font></td>
					<td align="center" colspan="" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="1px"><b>DATE</font></td>
				
				<td align="center" colspan="2" valign="middle" style="border:1px solid #787f7a;width:20%;" ><font face="caibri" size="1px"><b> EXPENSES </font></td>


					<td align="center" colspan="3" valign="middle" style="border:1px solid #787f7a;width:15%;" ><font face="caibri" size="1px"><b>REMARK</font></td>
				
					
					<td align="center" colspan="1" valign="middle" style="border:1px solid #787f7a;width:10%;" ><font face="caibri" size="1px"><b>AMOUNT</font></td>		
				</tr>
						
						
						
						<%int j=1; %>
	<s:iterator value="Report3">
				
						
						<tr class="item-row">
							<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><%=i++ %>&nbsp;&nbsp;</font></td>
								
						
							<td align="center" colspan="1"	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="voucher_no" /></font></td>
							
							<td align="center" colspan="1"	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="date" /></font></td>
							
							<td align="center" colspan="2"	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="exp_parti" /></font></td>
							
							
							<td align="center" colspan="3"	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="1px"><s:property value="remark1" /></font></td>

							

							<td align="center" colspan="1" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="exp_amount" /></font>
							<%-- <input style="width:60px;" type="text"  class="form-control" name="pb.quantitys"  id="quantity1"  value=" <s:property value="exp_amount" />" />
							 --%>
							</td>

							
						</tr>
						

			
		</s:iterator>
				
						
						
					<tr style="height:100%;">
						<th align="center"  valign="middle"style="border-left: 1px solid grey;border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
							
						<th align="center" colspan="1" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
					
						<th align="center" colspan="1" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
					
						<th align="center" colspan="2" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" colspan="3" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center"  colspan="1" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
								
						</tr>
						
				
					<tr>
              		<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;"></td>
              		<td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;"></td>
					<td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									

									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">Total Expense</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="expenceseamount"/></font></td>

								</tr>
								
					
					<tr>
              		<!-- <td align="center" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;"></td>
              		 --><td align="left" colspan="4" style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 0px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp; Bank Name  &nbsp; : <%=bank %></font></td>
							
										<!-- <td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							 -->		<td align="center"
										style="border-top: 1px solid grey;border-right: 0px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									




								<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"> LR Charges</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="lr_amount" /></font></td>
								
									
								</tr>
								
								
								
								<tr>
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">PAN NO:</td>
									 -->	
									<td align="left" colspan="4" style="border-top: 0px solid grey;border-right: 0px solid grey; padding-left: 5px;width:550px;"><font face="caibri" size="2px">Account No  &nbsp;  : <%=acno %></font></td>
									<!-- <td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
									 --><!-- <td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
								 -->	<td align="center"
										style="border-top: 0px solid grey;border-right: 0px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 0px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									


									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">Total Freight</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="total" />.0</font></td>
									
									
									

								</tr>
								
								
								
								
								<tr>
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">PAN NO:</td>
									 -->	
									<td align="left" colspan="4" style="border-top: 0px solid grey;border-right: 0px solid grey; padding-left: 5px;width:550px;"><font face="caibri" size="2px">IFSC Code &nbsp; &nbsp; :  <%=ifsc %><br>Branch   &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;    :&nbsp;Khadki Pune</font></td>
									<!-- <td align="left" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
									 --><!-- <td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
								 -->	<td align="center"
										style="border-top: 0px solid grey;border-right: 0px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 0px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									

									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="1px"> Grand Total </font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"> <s:property value="issueamount" /></font>
									<%--  <input style="width:60px;" type="text"  class="form-control" name="pb.quantitys"  id="total12"  value=" <s:property value="total12" />"       />
					 --%>		</td>
									<%-- <input style="width:60px;" type="text"  class="form-control" name="pb.quantitys"  id="total12"  value=" <s:property value="issueamount" />"   />
	  --%>
									</td>

								</tr>
								
								
								
								<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font face="caibri" size="2px"><b>Rupees: <s:property
																			value="amountinwords" />&nbsp; only.</b></font>
																
</td>
								</tr>
							
								
									<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font face="caibri" size="2px">DECLARATION:</font><br>
										<font face="caibri" size="2px">#The Above Rates are Subject to any change in particulars of shipment,any fines and penalties during the transit<br>
															# We reserve the right to charge interest @ 24% if the bill is not paid in 15 days/committed time.<br>
															# DD/Cheque should be made in favor of HIGH SEAS LOGISTICS PVT LTD.<br>
															# Disputes relation to this bill must be submitted in writing within 7 days from receipt of same after which no changes will be entertained.<br>
															# Supplementry bill will follow for any charges left out or incurred subsequently.<br>
															#Subject to Pune Jurisdiction.
															
										</font>
									
</td></tr>

<tr>


<td align="left" colspan="<%=mycolspan/2-2 %>" style="padding-left:5px;">
<br><br>
									<font face="caibri" size="1px"><b>Customer's Signature</b></font>
</td>
<td align="right" colspan="<%=mycolspan/2+2+1 %>" style="padding-right:5px;"
										>
									<font face="caibri" size="2px">For <%=name %></b></font>
									<br><br>
									Authorized Signatory
</td>
								</tr>
								
								
					</tbody>
			</table>		




</body>
</html>




