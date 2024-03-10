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

// -->
</style>
</head>
<body>
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


<tr><td align="center" colspan="<%=mycolspan %>" style="border-top: 1px solid #000000;border-right:1px solid #000000">
<font size="4px;"> <b>TAX INVOICE</b></font>
</td></tr>

<s:if test="shipparty==''">
<tr>
<td colspan="<%=mycolspan %>"style="border-right: 1px solid #787f7a;" >


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><b><s:property value="invoiceno" /></b></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">GSTN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><%=gstn %> <%-- <s:property value="KM" /> --%></font>
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
<font face="caibri" size="1px">PAN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><%=pan %></font>
</td>
</tr>



<tr>
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
<font face="caibri" size="1px"><font face="caibri" size="1px">INDUSTRIAL CONSUMER <%-- <s:property value="Model" /> --%></font>
</td>
</tr>


<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">27&nbsp;&nbsp;&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">PAY TERM:</font>
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


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><b><s:property value="customer_name" /></b></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
 <font face="caibri" size="1px">Consignor:</font> 
</td>

<td width="30%"  style="border-right:1px solid #787f7a;">
 <font face="caibri" size="1px">${consigner}</font>
 </td> 
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">From:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${from}</font>
</td> 
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="vat" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">Consignee:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${consignee}</font>
</td> 
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="state" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">To:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${to}</font>
</td>
</tr>


<tr>
<td width="20%">
<font size="2px"><font face="caibri" size="1px">KIND ATTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="contactp" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<!-- <font size="2px"><font face="caibri" size="1px">CONTACT:</font>
 --></td>
<td width="30%">
<%-- <font size="2px"><s:property value="contactpno" /></font>
 --%></td>
</tr>
<tr>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">MOBILE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="mobile" /></font>
</td>

</tr>



</table>
</td>
</tr>

</s:if>


<s:else>

<tr>
<td colspan="<%=mycolspan %>">


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
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
<font face="caibri" size="1px"><%=gstn %> <%-- <s:property value="KM" /> --%></font>
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
<font face="caibri" size="1px">PAN NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><%=pan %></font>
</td>
</tr>



<tr>
<td width="20%">
<font face="caibri" size="1px">VENDOR:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${vendor }</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">PO NO & PO DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${pono }  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${podate }</font></td>
</tr>


<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">27&nbsp;&nbsp;&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">E way Bill NO & E way Bill DATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${dcnox }  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ${dcdatex }</font>
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
<font face="caibri" size="1px">SHIP TO PARTY</font>
</td>
</tr>

</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font face="caibri" size="1px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="customer_name" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">SHIPPING PARTY:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${shipparty }</font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">SHIPPING ADDRESS :</font>
</td>
<td width="30%">
<font face="caibri" size="1px"><s:property value="shipadd" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="vat" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">GSTN:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${shipgstn }</font>
</td>
</tr>
<tr>
<td width="20%">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="state" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">STATE:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${shipstate }</font>
</td>
</tr>

<%-- <tr>
<td width="20%">
<font face="caibri" size="1px">TRANSPORT MODE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="1px"><s:property value="transmode" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font face="caibri" size="1px">VEHICLE NO:</font>
</td>
<td width="30%">
<font face="caibri" size="1px">${vehino }</font>
</td>
</tr> --%>


</table>
</td>
</tr>












</s:else>





	<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">SR</font></td>
						
						
					<td align="center" valign="middle" style="border:1px solid #787f7a;width:35%;" ><font face="caibri" size="1px">Description of Goods</font></td>
					<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="1px">LR NO</font></td>
					<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font face="caibri" size="1px">HSN/SAC </font></td>
				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Qty</font></td>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Rate</font></td>
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Taxable Value</font></td>

					<td align="center" colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">IGST</font></td>
				
					<!-- <td align="center"  colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">SGST</font></td> -->
				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Total</font></td>
				</tr>
					
				
				
				<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					
						
					
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Rate</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Amount</font></td>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Rate</font></td>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">Amount</font></td> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font face="caibri" size="1px">&nbsp;</font></td>
				</tr>
					
			
<%int i=1; %>
	<s:iterator value="invoicebean_1" var="myobj">
				
						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><%=i++ %>&nbsp;&nbsp;</font></td>
								
						
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="description" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="batch22" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font face="caibri" size="1px"><s:property value="tax_type" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="quantity" />&nbsp;&nbsp;<s:property value="unit" /></font></td>
							
							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="myrate1" /></font></td>
							
					
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="1px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="gr1" /></font></td>

							<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="gsa1" /></font></td>
							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="gr2" /></font></td>

								<td align="right" 	style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="gsa2" /></font></td> --%>

							
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font face="caibri" size="1px"><s:property
									value="vatamount" /></font></td>

						</tr>


		
				
		</s:iterator>
				
				
				
				
				
			
				
				

			<tr>
				
				<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
						
				<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>

			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<!-- <td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
			<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td> -->
		<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>							

						</tr>

				
				


		
					<tr style="height:100%;">
						
						<th align="center" valign="middle"		style="border-left: 1px solid grey;border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
							
						
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
					
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<!-- <th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th> -->
						<th align="center" valign="middle" style="border-right: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
					</tr>

						
						
						
						<tr style="height:100%;">
						
						<th align="center" valign="middle"		style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></th>
							
						
						
						
						<td align="left" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><%-- <font face="caibri" size="1px">VEHICLE NO:${vehino }</font> --%></td>
						
						
					
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></td>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="hh1" /></font></td>
					
						<td align="right" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></td>
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">TOTAL</font></td>
					
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="netamt" /></font></th>
						<!-- <td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;;"><font face="caibri" size="1px">&nbsp;</font></td> -->
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"></font></font></td>
						<!-- <td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">&nbsp;</font></td> -->
						<td align="center" valign="middle"	style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="sgst" /></font></font></td>
						<td align="right" valign="middle"  style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="1px"><s:property value="grossamt" /></font></font></td>
					
					
					</tr>
					
					
				<tr>
              		
              		
              		<td align="center" style="border-top: 1px solid grey;">&nbsp;</td>
              		
              		<td align="center" style="border-top: 1px solid grey;" >&nbsp;</td>
					
					<td align="left" style="border-top: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
							
						
					<td align="left" style="border-top: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
					
					<td align="center" style="border-top: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
					
					<!-- <td align="center" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
					
					<td align="center" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td> -->
								

					<td align="left" colspan="4" style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey;padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font face="caibri" size="1px">Total Amount Before Tax</font></td>


					<td align="right" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="netamt" /></font></td>

				</tr>
								
								
								
								
								
					<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px">Bank Name: <%=bank %></font></td>
									
									<td align="center"><font
									size="2px">&nbsp;</font></td>
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									
									
							
							<!-- <td align="center" style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="1px">IGST</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="sgst" /></font></td>

								</tr>
				
				
				
				
				<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px">AC/ No: <%=acno %></font></td>
									
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									
									
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey;padding-right: 5px;width:100px;"><font face="caibri" size="1px">Total Tax Amount</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="tax" /></font></td>

								</tr>
								
								
								
								
								<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px">IFSC Code: <%=ifsc %></font></td>
									
										
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey; padding-left: 5px;width:100px;"><font face="caibri" size="1px">Total Amount after Tax</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><b><s:property value="grossamt" /></b></font></td>

								</tr>
								
							<s:if test="freight!='0.00'">	
								<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px"></font></td>
										
										
									
										
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="1px">Freight</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="freight" /></font></td>

								</tr>
								</s:if>
								
								
								
								
								<s:if test="transport!='0.00'">
								<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px"></font></td>
									
										
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="1px">Transport</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="transport" /></font></td>

								</tr>
								</s:if>
								
								
								<s:if test="transport!='0.00' or freight!='0.00'  ">
								<tr>
									<td align="left" colspan="3"
										><font face="caibri" size="1px"></font></td>
									
										
									<!-- <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td> -->
									
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										><font
									size="2px">&nbsp;</font></td>
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; border-left: 1px solid grey;  padding-right: 5px;width:100px;"><font face="caibri" size="1px">Grand Total</font></td>


									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><b><s:property value="ggtotal" /></b></font></td>

								</tr>
								</s:if>
								<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font face="caibri" size="1px"><b>Tax Amount(in words):<s:property
																			value="amountinwords" />&nbsp; ONLY</b></font>
																
</td>
								</tr>
							<%-- 	<tr>
								<td colspan="<%=mycolspan %>" style="padding-left: 5px;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;">
								
								<table width="100%" border="1" style="width:100%;border-collapse:collapse;">
													<tr>
													<td align="center"><font face="caibri" size="1px">HSN/SAC</font> </td>
													<td align="center"><font face="caibri" size="1px">Taxable Value </font></td>
													<td align="center" colspan="2"><font face="caibri" size="1px">Central Tax</font> </td>
													<td align="center" colspan="2"><font face="caibri" size="1px">State Tax </font></td>
													
													</tr>
													<tr>
													<td>&nbsp; </td>
													<td>&nbsp; </td>
													<td align="center"><font face="caibri" size="1px">Rate</font></td>
													<td align="center"><font face="caibri" size="1px">Amount </font></td>
													<td align="center"><font face="caibri" size="1px">Rate</font></td>
													<td align="center"><font face="caibri" size="1px">Amount</font> </td>
													</tr>
													<s:iterator value="invoicebean" var="myobj">
													<tr>
													
													<td align="left"><font face="caibri" size="1px"><s:property	value="hsn" /></font> </td>
													<td align="right"><font face="caibri" size="1px"><s:property	value="taxablevalue" /> </font></td>
													<td align="right"><font face="caibri" size="1px"><s:property	value="crate" />%</font></td>
													<td align="right"><font face="caibri" size="1px"><s:property	value="camount" /> </font></td>
													<td align="right"><font face="caibri" size="1px"><s:property	value="srate" />%</font></td>
													<td align="right"><font face="caibri" size="1px"><s:property	value="samount" /> </font></td>
													
													</tr>
													
													</s:iterator>
													<tr>
													<td align="right"><font face="caibri" size="1px"> Total</font></td>
													<td align="right"><font face="caibri" size="1px"> <s:property value="netamt" /></font></td>
													<td align="right" ><font face="caibri" size="1px"> </font></td>
													<td align="right" ><font face="caibri" size="1px"><s:property value="cgst" /></font></td>
													<td align="right" ><font face="caibri" size="1px"></font></td>
													<td align="right" ><font face="caibri" size="1px"><s:property value="sgst" /></font></td>
													
													
													</tr>
													</table>
								
								
								
								</td>
								</tr> --%>
								
									<tr>
									<td align="left" colspan="<%=mycolspan %>"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font face="caibri" size="1px">DECLARATION:</font><br>
										<font face="caibri" size="1px">"I/We hereby certify that my/our registration certificate under the GST Act 2017,is in force on the date on which the sale of goods specified in this tax invoice is made by me/us and it shall be accounted for in the turnover of sales while filling of return and the due tax ,if any payable on the sale has been paid or shall be paid"."I/We hereby certify that food/foods mentioned in this invoice is/are warranted to be safe in nature substance & quality."
										</font>
									
</td></tr>

<tr>


<td align="left" colspan="<%=mycolspan/2-2 %>" style="padding-left:5px;">
<br><br>
									<font face="caibri" size="2px"><b>Customer's Signature</b></font>
</td>
<td align="right" colspan="<%=mycolspan/2+2+1 %>" style="padding-right:5px;"
										>
									<font face="caibri" size="1px">For <%=name %></b></font>
									<br><br>
									Authorized Signatory
</td>
								</tr>
								
								
					</tbody>
			</table>		




</body>
</html>




