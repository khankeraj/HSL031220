<%@page import="java.sql.ResultSet"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>
<%@page import="java.util.Calendar "%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String extracolumn="";
String manualauto="";
String partlabour="";
String withstock="";
String col1="";
String col2="";
String col3="";
String perunit="";

%>

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
		 
		 location.href="test.jsp";
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
		    	DBConnection conn=new DBConnection();
		    	Connection connection = conn.getConnection();
				
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
	
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<%
int mycolspan=11;

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

<tr><td align="left" colspan="<%=mycolspan %>" style="border-right:1px solid #000000;height: 10%;" ><table width="100%"><tr><td><img src="images/GST SOFTWARE-Logo(1).png" width="150px" ></td><td align="center">

	<font size="5px;">	
<b><%=name %></b></font>
<br>
<font size="3px;">			
<b><%=address %></b>
</font>
<br>
<%
if(!address2.trim().equals("")) { 
	%>

<font size="2px;">			
<%=address2 %>
</font>
<br>
<%}
%>
<font size="2px;">	
<%=email %></font>
<br>
<font size="2px;">			
<%=contact %>
</font>

</td></tr></table>



</td>
</tr>

<tr><td align="center" colspan="<%=mycolspan %>" style="border-top: 1px solid #000000;border-right:1px solid #000000">
<font size="4px;"> <b>TAX INVOICE</b></font>
</td></tr>

<s:if test="shipparty==''">
<tr>
<td colspan="<%=mycolspan %>">


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="2px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${invoice_no}</b></s:iterator></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">GSTN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${gstin_no}</b></s:iterator> <%-- <s:property value="KM" /> --%></font>
</td>
</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px">INVOICE DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${requiredDate}</b></s:iterator></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">PAN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${pan_no}</b></s:iterator></font>
</td>
</tr>



<tr>
<td width="20%">
<font face="caibri" size="2px">REVERSE CHARGE:</font>
</td>
<td width="30%">
<font face="caibri" size="2px">&nbsp;</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">CATEGORY:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><font face="caibri" size="2px">INDUSTRIAL CONSUMER <%-- <s:property value="Model" /> --%></font>
</td>
</tr>


<tr>
<td width="20%">
<font face="caibri" size="2px">STATE:</font>
</td>
<td width="30%">
<font face="caibri" size="2px">27&nbsp;&nbsp;&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">PAY TERM:</font>
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
<font face="caibri" size="2px">BILL TO PARTY</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font face="caibri" size="2px">&nbsp;</font>
</td>
</tr>

</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="2px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><b><s:iterator value="fetchPrintsinvoice"><b>${customer_name}</b></s:iterator></b></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">VENDOR:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${address}</b></s:iterator></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">MOBILE NO:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${mobile_no}</b></s:iterator></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${gstin_no}</b></s:iterator></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">PO NO & PO DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${po_no}</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${po_date }</s:iterator></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="2px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:iterator value="fetchPrintsinvoice"><b>${state}</b></s:iterator></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="2px">DC NO & DC DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </font>
</td>
</tr>


<tr>
<td width="20%">
<font size="2px"><font face="caibri" size="2px">KIND ATTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px"><font face="caibri" size="2px">CONTACT:</font>
</td>
<td width="30%">
<font size="2px"></font>
</td>
</tr>



</table>
</td>
</tr>

</s:if>



		<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>SR</font></th>
						
						<% if(extracolumn.equals("1")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;width:20%;" ><font face="caibri" size="2px"><b><%=col1 %></font></th>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;width:5%" ><font face="caibri" size="2px"><b><%=col1 %></font></th>
							<td align="center" valign="middle" style="border:1px solid #787f7a;width:5%" ><font face="caibri" size="2px"><b><%=col2 %></font></th>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;width:5%" ><font face="caibri" size="2px"><b><%=col1 %></font></th>
							<td align="center" valign="middle" style="border:1px solid #787f7a;width:5%" ><font face="caibri" size="2px"><b><%=col2 %></font></th>
							<td align="center" valign="middle" style="border:1px solid #787f7a;width:5%" ><font face="caibri" size="2px"><b><%=col3 %></font></th>
						<%} %>
					<td align="center" valign="middle" style="border:1px solid #787f7a;width:35%;" ><font face="caibri" size="2px"><b>Description</font></th>
<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>HSN Code/<br>SAC Code</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Qty</font></th>

<% if(perunit.equals("yes")) {%>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Sq ft</font></th>
					<% } %>




					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Rate</font></th>
					<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Disc(%)</font></th>
					<% } %>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Taxable Value</font></th>

					<td align="center" colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>CGST</font></th>
				
					<td align="center"  colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>SGST</font></th>
				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Total</font></th>
				</tr>
					
				<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					
						<% if(extracolumn.equals("1")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<% } %>
					<% if(perunit.equals("yes")) {%>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<% } %>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">Amount</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">Amount</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="2px">&nbsp;</font></th>
				</tr>
					
			

<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'parts'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
								
						<% if(extracolumn.equals("1")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partdatee" /></font></td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partdatee" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoox" /></font></td>
						<%} %>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="description" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="tax_type" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="quantity" />&nbsp;&nbsp;<s:property value="unit" /></font></td>
							<% if(perunit.equals("yes")) {%>
					<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property value="punt" /></font></td>
					<% } %>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="myrate1" /></font></td>
							<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
					<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="disc1" /></font></td>
					<% } %>
					
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gr1" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gsa1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gr2" /></font></td>

								<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gsa2" /></font></td>

							
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property
									value="vatamount" /></font></td>

						</tr>


				
</s:if>

				
				</s:iterator>

<tr>
							<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<% if(extracolumn.equals("1")) {%>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						<%} %>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
					<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
					<% } %>
					<% if(perunit.equals("yes")) {%>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
					<% } %>
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

				
				<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'labour'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
								
						<% if(extracolumn.equals("1")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partdatee" /></font></td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoo" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partdatee" /></font></td>
						<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="partnoox" /></font></td>
						<%} %>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="description" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="2px"><s:property value="tax_type" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="quantity" />&nbsp;&nbsp;<s:property value="unit" /></font></td>
							<% if(perunit.equals("yes")) {%>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="punt" /></font></td>
					<% } %>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="myrate1" /></font></td>
							<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property value="disc1" /></font></td>
					<% } %>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gr1" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gsa1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gr2" /></font></td>

								<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="gsa2" /></font></td>

							
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="2px"><s:property
									value="vatamount" /></font></td>

						</tr>


				
</s:if>

				
				</s:iterator>


		
					<tr style="height:100%;">
						<th align="center" valign="middle"		style="border-left: 1px solid grey;border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
							<% if(extracolumn.equals("1")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
											<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
					<% } %>
											<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
					
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
					</tr>

						<tr style="height:100%;">
						<th align="center" valign="middle"		style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
							<% if(extracolumn.equals("1")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></th>
						<%} %>
						
						<td align="left" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">VEHICLE NO:${vehino }</font></td>
						
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
												<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
																	<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></td>
					<% } %>
					
																	<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></td>
					
											<td align="right" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="hh1" /></font></td>
											<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><b>TOTAL</font></td>
					
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="netamt" /></font></th>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;;"><font face="caibri" size="2px">&nbsp;</font></td>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="cgst" /></font></font></td>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;</font></td>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="sgst" /></font></font></td>
						<td align="right" valign="middle"  style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><s:property value="grossamt" /></font></font></td>
					</tr>
					<tr>
              		<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						
							<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
												<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					<% } %>
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><b>Total Amount Before Tax</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="netamt" /></font></td>

								</tr>
								<tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;</td>
										<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
											<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
					<% } %>
									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>CGST</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="cgst" /></font></td>

								</tr>
								
					<tr>
									<td align="left" colspan="3"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px">Bank Name: <%=bank %></font></td>
									<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
											<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
					<% } %>

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>SGST</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="sgst" /></font></td>

								</tr>
				
				<tr>
									<td align="left" colspan="3"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px">AC/ No: <%=acno %></font></td>
									<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
											<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:150px;">&nbsp;</td>
					<% } %>

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>Total Tax Amount</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="tax" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="3"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px">IFSC Code: <%=ifsc %></font></td>
									
										<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								
<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
											<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:150px;">&nbsp;</td>
					<% } %>
									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>Total Amount after Tax</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><b><s:property value="grossamt" /></b></font></td>

								</tr>
								
							<s:if test="freight!='0.00'">	
								<tr>
									<td align="left" colspan="3"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px"></font></td>
									
										<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
											<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
						
							
					<% } %>
					<% if(perunit.equals("yes")) {%>
							<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
					<% } %>

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>Freight</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="freight" /></font></td>

								</tr>
								</s:if>
								<s:if test="transport!='0.00'">
								<tr>
									<td align="left" colspan="3"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px"></font></td>
									
										<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
						<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
							<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>Transport</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="transport" /></font></td>

								</tr>
								</s:if>
								<s:if test="transport!='0.00' or freight!='0.00'  ">
								<tr>
									<td align="left" colspan="3"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font face="caibri" size="2px"></font></td>
									
										<% if(extracolumn.equals("1")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("2")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(extracolumn.equals("3")) {%>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
						<%} %>
						<% if(discount.equals("yes") && !discount.equals("") && !discount.equals("0")) {%>
						<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
							<%} %>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b>Grand Total</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><b><s:property value="ggtotal" /></b></font></td>

								</tr>
								</s:if>
								<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font face="caibri" size="2px"><b>IN WORDS:<s:property
																			value="amountinwords" />&nbsp; ONLY</b></font>
																
</td>
								</tr>
							
								
									<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font face="caibri" size="2px">DECLARATION:</font><br>
										<font face="caibri" size="2px">We declare that this invoice shows the actual price of the goods described and that all particulars are true and correct.
										</font>
									
</td></tr>

<tr>


<td align="left" colspan="<%=mycolspan/2-2 %>" style="padding-left:5px;"
										>
									<font face="caibri" size="2px">Customer's Signature</font>
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




