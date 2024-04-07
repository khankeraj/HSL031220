<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>
<%-- <%@ page import="com.aqua.dao.Spare_master_dao"%>
<%@page import="com.aqua.dao.DaoHelper,java.sql.* "%> --%>
<%@page import="java.util.Calendar "%>



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
		 
		 location.href="assignBill745";
	 }
	 
	 
	 
	 </script>


	
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

<%@page import="java.util.Calendar "%>
<%@page import="java.util.GregorianCalendar "%>
<%

String Company="";
String address1="";
String address="";
String address2="";
String contact="";
String email="";
String gstn="";
String pan="";
String bakname="";
String accountno="";
String ifsccode="";

%>
<%


try
{
	Connection connection = DaoHelper.getConnection();
	
	PreparedStatement preparedStatementxc = connection
			.prepareStatement("select * from settings ");

			ResultSet resultSetxc = preparedStatementxc.executeQuery();
			if (resultSetxc.next()) {
			
				 Company=resultSetxc.getString("companyname");
				 address1=resultSetxc.getString("address1");
				 address=resultSetxc.getString("address");
				 address2=resultSetxc.getString("address2");
				 contact=resultSetxc.getString("contact");
				 email=resultSetxc.getString("email");
				 gstn=resultSetxc.getString("gstnno");
				 pan=resultSetxc.getString("panno");
				 bakname=resultSetxc.getString("bankname");
				 accountno=resultSetxc.getString("accountno");
				 ifsccode=resultSetxc.getString("ifsccode");
			}
			
}catch(Exception e){}

	%>

<div align="right" >Original</div>
<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always"" >
<tr><td align="center" colspan="12"><table width="100%"><tr><td align="center"><img src="images/Sindans-Logo(1).png" width="250px" ></td><td align="right">

<font  size="3px;">			
All Types of Computer And Printing Job Work
</font>
<br>
<font  size="2px;">
Dhanlaxmi Hsg. Soc., 94/4, M. Phulenagar, Chinchwad Pune -19
</font>
<br>
<font size="3px;">	
<%=email %></font>
<br>
<font size="3px;">			
<%=contact %>
</font>

</td></tr></table>



</td>
</tr>
<tr><td align="center" colspan="11" style="border-top: 1px solid #000000;">
<font size="4px;"> TAX INVOICE</font>
</td></tr>

<tr>
<td colspan="11">



<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="invoiceno" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">GSTN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=gstn %> <%-- <s:property value="KM" /> --%></font>
</td>
</tr>

<tr>
<td width="20%">
<font size="2px">INVOICE DATE:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="date" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=pan %></font>
</td>
</tr>



<tr>
<td width="20%">
<font size="2px">REVERSE CHARGE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">CATEGORY:</font>
</td>
<td width="30%">
<font size="2px"><font size="2px">INDUSTRIAL CONSUMER <%-- <s:property value="Model" /> --%></font>
</td>
</tr>


<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">&nbsp;</font>
</td>
<td width="30%">
<font size="2px"></font>
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
<font size="2px">BILL TO PARTY</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font size="2px">&nbsp;</font>
</td>
</tr>

</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="customer_name" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">VENDOR:</font>
</td>
<td width="30%">
<font size="2px">${vendor }</font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">MOBILE NO:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="mobile" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="vat" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PO NO & DATE:</font>
</td>
<td width="30%">
${pono }&nbsp;&nbsp;&nbsp;&nbsp;${podate }
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="state" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAYMENT TERMS:</font>
</td>
<td width="30%">
<font size="2px">${termcond }</font>
</td>
</tr>
</table>

</td>
</tr>
<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SR</font></th>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch No</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch Date</font></th> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Description</font></th>
<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font size="2px" >HSN Code/<br>SAC Code</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Qty</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Taxable Value</font></th>

					<td align="center" colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >IGST</font></th>
				
<!-- 					<td align="center"  colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SGST</font></th>
 -->				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Total</font></th>
				</tr>
					
				<tr >
				
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
				</tr>
					
			<!-- 	<tr>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;"><font size="2px">Parts</font></td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
				<td style="border:1px solid #787f7a;">&nbsp;</td>
				</tr> -->

<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'parts'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
								<%-- <td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partnoo" />&nbsp;&nbsp;</font></td>
									<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partdate" />&nbsp;&nbsp;</font></td> --%>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;width:45%"><font size="2px" ><s:property value="description" />&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="partnoox" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="2px" ><s:property value="tax_type" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property
									value="vatamount" /></font></td>

						</tr>


				
</s:if>

				
				</s:iterator>

<tr>
							<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>

<!-- <td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td> -->
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<!-- <td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td> -->
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>							

						</tr>

				
				<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'labour'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
						
							<%-- <td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td> --%>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="description" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property
									value="vatamount" /></font></td>

						</tr>

				
</s:if>

				
				</s:iterator>




				
				
				
				
					
					
					
			<!-- <tr class="greadheading" style="border:1px solid #787f7a;">
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="left" valign="middle" style="border:1px solid #787f7a;" ><font size="2px">Labour</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="1">Service Tax</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
				</tr> -->
				
			
				<!-- <tr >
					<td></td>
					<td><font size="2px">Labour</font></td>
				</tr > -->
				<%-- <s:iterator value="invoicebean_1" var="myobj">
					<s:if test="#myobj.type_1  ==  'labour'">

						<tr   >
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="sn" /></font></td>
							<td align="left" 	style="border-right: 1px solid grey;padding-left:5px;"><font size="1px"><s:property value="description" /></font></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="taxqmount" /></font></td>
							<td align="right" style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property
									value="vatamount" /></font></td>

						</tr>

					</s:if>



				</s:iterator> --%>
				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				





				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				



			
		
					<tr style="height:100%;">
						
						<th align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
						<!-- <th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>

<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th> -->
						
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<!-- <th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th> -->
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>



						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
					</tr>

<tr style="height:100%;">
						<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
							<!-- <td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							
							<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
 -->
					<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">TOTAL</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
						<!-- <td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td> -->
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><s:property value="netamt" /></font></th>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="cgst" /></font></font></td>
						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="sgst" /></font></font></td>



						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="grossamt" /></font></font></td>
					</tr>
					<tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										
										<!-- <td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										
										 -->
										
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
								
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font size="2px" >Total Amount Before Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="netamt" /></font></td>

								</tr>
								<%-- <tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;</td>
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
								

									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >CGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="cgst" /></font></td>

								</tr> --%>
								
					<tr>
									<td align="left" colspan="5"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >Bank Name: <%=bakname %></font></td>
								
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>

								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >IGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="sgst" /></font></td>

								</tr>
				
				<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >AC/ No: <%=accountno %></font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Tax Amount</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="tax" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >IFSC Code: <%=ifsccode %></font></td>
									
										
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Amount after Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="grossamt" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="12"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font size="2px"><b>IN WORDS:<s:property
																			value="amountinwords" />&nbsp; ONLY</b></font>
																
</td>
								</tr>
								
									<tr>
									<td align="left" colspan="12"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font size="2px"><b>DECLARATION:</b></font><br>
										<font size="2px">1. We declare that this invoice shows the actual price of the goods described and that all particulars are true and correct.<br>
										2. Goods once sold will not be taken back.<br>
										3. Subject to Pune Jurisdiction
										</font>
									<br><br>
									
</td></tr>

<tr>


<td align="left" colspan="12" style="padding-left:5px;"
										><br>
									<br><br>
									<font size="2px">Customer's Signature</font>
</td>
</tr>

<tr>
<td align="right" colspan="12" style="padding-right:5px;width:900px;"
										>
									<font size="2px"> For<b><%=Company %></b></font><br>
									<br><br>
									Authorized Signatory
</td>
								</tr>
								
					</tbody>
			</table>
<!--Duplicate -->
<div align="right" >Duplicate</div>
<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always"" >
<tr><td align="center" colspan="12"><table width="100%"><tr><td align="center"><img src="images/Sindans-Logo(1).png" width="250px" ></td><td align="right">

<font  size="3px;">			
All Types of Computer And Printing Job Work
</font>
<br>
<font  size="2px;">
Dhanlaxmi Hsg. Soc., 94/4, M. Phulenagar, Chinchwad Pune -19
</font>
<br>
<font size="3px;">	
<%=email %></font>
<br>
<font size="3px;">			
<%=contact %>
</font>

</td></tr></table>



</td>
</tr>
<tr><td align="center" colspan="11" style="border-top: 1px solid #000000;">
<font size="4px;"> TAX INVOICE</font>
</td></tr>

<tr>
<td colspan="11">



<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="invoiceno" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">GSTN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=gstn %> <%-- <s:property value="KM" /> --%></font>
</td>
</tr>

<tr>
<td width="20%">
<font size="2px">INVOICE DATE:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="date" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=pan %></font>
</td>
</tr>



<tr>
<td width="20%">
<font size="2px">REVERSE CHARGE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">CATEGORY:</font>
</td>
<td width="30%">
<font size="2px"><font size="2px">INDUSTRIAL CONSUMER <%-- <s:property value="Model" /> --%></font>
</td>
</tr>


<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">&nbsp;</font>
</td>
<td width="30%">
<font size="2px"></font>
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
<font size="2px">BILL TO PARTY</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font size="2px">&nbsp;</font>
</td>
</tr>

</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="customer_name" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">VENDOR:</font>
</td>
<td width="30%">
<font size="2px">${vendor }</font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">MOBILE NO:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="mobile" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="vat" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PO NO & DATE:</font>
</td>
<td width="30%">
${pono }&nbsp;&nbsp;&nbsp;&nbsp;${podate }
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="state" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAYMENT TERMS:</font>
</td>
<td width="30%">
<font size="2px">${termcond }</font>
</td>
</tr>
</table>
<%-- 
<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="50%" align="left" >
<font size="2px">PONO: ${pono} &nbsp;&nbsp;&nbsp;PO DATE: ${podate } &nbsp;&nbsp;&nbsp;TERM:${termcond }</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font size="2px">&nbsp;</font>
</td>
</tr>

</table> --%>


<%-- 
<table width="100%" style="border: 1px solid #787f7a;" width="100%">

				<tr>

					<td align="left" style="padding: 1px;" width="35%"><font
							size="2px">CUSTOMER NAME:</font><s:property
							value="customer_name" /></td>

					<td align="right" valign="top" style="padding: 1px;" width="15%"><font
							size="2px">BILL NO:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="20%"><div
							class="due">
							<font size="2px"><s:property value="invoiceno" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%" valign="top"><font
							size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DATE:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%">
						<font size="2px"><s:property value="date" /></font>
					</td>
				</tr>


				<tr>


					<td align="left" style="padding: 1px;" width="35%"><font
							size="2px">ADDRESS:</font><font size="2px"><s:property
								value="address" /></font></td>
					<td align="right" style="padding: 1px;" width="15%"><font
							size="2px">VEHICLE NO:</font></td>
					<td align="left" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2"><s:property value="Vehicle_no" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%"><font
							size="2px">KMS:</font></td>
					<td align="left" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2px"> <s:property value="KM" /></font>
						</div></td>
				</tr>

				<tr>


					<td align="left" style="padding: 1px;" width="35%">&nbsp;</td>

					<td align="right" valign="top" style="padding: 1px;" width="15%"><font
							size="2px">MOBILE NO:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2px"><s:property value="mobile" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%" valign="top"><font
							size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MODEL:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%">
						<font size="2px"><s:property value="Model" /></font>
					</td>
				</tr>


			</table>
 --%>
</td>
</tr>
<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SR</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch No</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch Date</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Description</font></th>
<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font size="2px" >HSN Code/<br>SAC Code</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Qty</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Taxable Value</font></th>

					<td align="center" colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >IGST</font></th>
				
<!-- 					<td align="center"  colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SGST</font></th>
 -->				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Total</font></th>
				</tr>
					
				<tr >
				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
				</tr>
					
			<!-- 	<tr>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;"><font size="2px">Parts</font></td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
				<td style="border:1px solid #787f7a;">&nbsp;</td>
				</tr> -->

<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'parts'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
								<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partnoo" />&nbsp;&nbsp;</font></td>
									<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partdate" />&nbsp;&nbsp;</font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;width:45%"><font size="2px" ><s:property value="description" />&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="partnoox" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="2px" ><s:property value="tax_type" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property
									value="vatamount" /></font></td>

						</tr>


				
</s:if>

				
				</s:iterator>

<tr>
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
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>							

						</tr>

				
				<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'labour'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
						
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property
									value="vatamount" /></font></td>

						</tr>

				
</s:if>

				
				</s:iterator>




				
				
				
				
					
					
					
			<!-- <tr class="greadheading" style="border:1px solid #787f7a;">
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="left" valign="middle" style="border:1px solid #787f7a;" ><font size="2px">Labour</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="1">Service Tax</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
				</tr> -->
				
			
				<!-- <tr >
					<td></td>
					<td><font size="2px">Labour</font></td>
				</tr > -->
				<%-- <s:iterator value="invoicebean_1" var="myobj">
					<s:if test="#myobj.type_1  ==  'labour'">

						<tr   >
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="sn" /></font></td>
							<td align="left" 	style="border-right: 1px solid grey;padding-left:5px;"><font size="1px"><s:property value="description" /></font></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="taxqmount" /></font></td>
							<td align="right" style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property
									value="vatamount" /></font></td>

						</tr>

					</s:if>



				</s:iterator> --%>
				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				





				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				



			
		
					<tr style="height:100%;">
						<th align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<!-- <th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th> -->
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>



						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
					</tr>

<tr style="height:100%;">
						<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
							<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">TOTAL</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
						<!-- <td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td> -->
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><s:property value="netamt" /></font></th>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="cgst" /></font></font></td>
						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="sgst" /></font></font></td>



						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="grossamt" /></font></font></td>
					</tr>
					<tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
								
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font size="2px" >Total Amount Before Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="netamt" /></font></td>

								</tr>
								<%-- <tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;</td>
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
								

									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >CGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="cgst" /></font></td>

								</tr> --%>
								
					<tr>
									<td align="left" colspan="5"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >Bank Name: <%=bakname %></font></td>
								
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>

								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >IGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="sgst" /></font></td>

								</tr>
				
				<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >AC/ No: <%=accountno %></font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Tax Amount</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="tax" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >IFSC Code: <%=ifsccode %></font></td>
									
										
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Amount after Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="grossamt" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="12"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font size="2px"><b>IN WORDS:<s:property
																			value="amountinwords" />&nbsp; ONLY</b></font>
																
</td>
								</tr>
								
									<tr>
									<td align="left" colspan="12"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font size="2px"><b>DECLARATION:</b></font><br>
										<font size="2px">1. We declare that this invoice shows the actual price of the goods described and that all particulars are true and correct.<br>
										2. Goods once sold will not be taken back.<br>
										3. Subject to Pune Jurisdiction
										</font>
									<br><br>
									
</td></tr>

<tr>


<td align="left" colspan="12" style="padding-left:5px;"
										><br>
									<br><br>
									<font size="2px">Customer's Signature</font>
</td>
</tr>

<tr>
<td align="right" colspan="12" style="padding-right:5px;width:900px;"
										>
									<font size="2px"> For<b><%=Company %></b></font><br>
									<br><br>
									Authorized Signatory
</td>
								</tr>
								
					</tbody>
			</table>
<!-- Triplicate -->			
	
<div align="right" >Triplicate</div>
<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always"" >
<tr><td align="center" colspan="12"><table width="100%"><tr><td align="center"><img src="images/Sindans-Logo(1).png" width="250px" ></td><td align="right">

<font  size="3px;">			
All Types of Computer And Printing Job Work
</font>
<br>
<font  size="2px;">
Dhanlaxmi Hsg. Soc., 94/4, M. Phulenagar, Chinchwad Pune -19
</font>
<br>
<font size="3px;">	
<%=email %></font>
<br>
<font size="3px;">			
<%=contact %>
</font>

</td></tr></table>



</td>
</tr>
<tr><td align="center" colspan="11" style="border-top: 1px solid #000000;">
<font size="4px;"> TAX INVOICE</font>
</td></tr>

<tr>
<td colspan="11">



<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">INVOICE NO:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="invoiceno" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">GSTN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=gstn %> <%-- <s:property value="KM" /> --%></font>
</td>
</tr>

<tr>
<td width="20%">
<font size="2px">INVOICE DATE:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="date" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAN NO:</font>
</td>
<td width="30%">
<font size="2px"><%=pan %></font>
</td>
</tr>



<tr>
<td width="20%">
<font size="2px">REVERSE CHARGE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">CATEGORY:</font>
</td>
<td width="30%">
<font size="2px"><font size="2px">INDUSTRIAL CONSUMER <%-- <s:property value="Model" /> --%></font>
</td>
</tr>


<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%">
<font size="2px">&nbsp;MAHARASHTRA</font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">&nbsp;</font>
</td>
<td width="30%">
<font size="2px"></font>
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
<font size="2px">BILL TO PARTY</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font size="2px">&nbsp;</font>
</td>
</tr>

</table>


<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="20%">
<font size="2px">CUSTOMER NAME:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="customer_name" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">VENDOR:</font>
</td>
<td width="30%">
<font size="2px">${vendor }</font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">ADDRESS:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">MOBILE NO:</font>
</td>
<td width="30%">
<font size="2px"><s:property value="mobile" /></font>
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">GSTN:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="vat" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PO NO & DATE:</font>
</td>
<td width="30%">
${pono }&nbsp;&nbsp;&nbsp;&nbsp;${podate }
</td>
</tr>
<tr>
<td width="20%">
<font size="2px">STATE:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font size="2px"><s:property value="state" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<font size="2px">PAYMENT TERMS:</font>
</td>
<td width="30%">
<font size="2px">${termcond }</font>
</td>
</tr>
</table>
<%-- 
<table width="100%" style="border: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<tr>
<td width="50%" align="left" >
<font size="2px">PONO: ${pono} &nbsp;&nbsp;&nbsp;PO DATE: ${podate } &nbsp;&nbsp;&nbsp;TERM:${termcond }</font>
</td>
<td width="50%" align="center" style="border-left:1px solid #787f7a;" 	>
<font size="2px">&nbsp;</font>
</td>
</tr>

</table> --%>


<%-- 
<table width="100%" style="border: 1px solid #787f7a;" width="100%">

				<tr>

					<td align="left" style="padding: 1px;" width="35%"><font
							size="2px">CUSTOMER NAME:</font><s:property
							value="customer_name" /></td>

					<td align="right" valign="top" style="padding: 1px;" width="15%"><font
							size="2px">BILL NO:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="20%"><div
							class="due">
							<font size="2px"><s:property value="invoiceno" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%" valign="top"><font
							size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DATE:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%">
						<font size="2px"><s:property value="date" /></font>
					</td>
				</tr>


				<tr>


					<td align="left" style="padding: 1px;" width="35%"><font
							size="2px">ADDRESS:</font><font size="2px"><s:property
								value="address" /></font></td>
					<td align="right" style="padding: 1px;" width="15%"><font
							size="2px">VEHICLE NO:</font></td>
					<td align="left" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2"><s:property value="Vehicle_no" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%"><font
							size="2px">KMS:</font></td>
					<td align="left" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2px"> <s:property value="KM" /></font>
						</div></td>
				</tr>

				<tr>


					<td align="left" style="padding: 1px;" width="35%">&nbsp;</td>

					<td align="right" valign="top" style="padding: 1px;" width="15%"><font
							size="2px">MOBILE NO:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%"><div
							class="due">
							<font size="2px"><s:property value="mobile" /></font>
						</div></td>
					<td align="right" style="padding: 1px;" width="15%" valign="top"><font
							size="2px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MODEL:</font></td>
					<td align="left" valign="top" style="padding: 1px;" width="15%">
						<font size="2px"><s:property value="Model" /></font>
					</td>
				</tr>


			</table>
 --%>
</td>
</tr>
<tr >
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SR</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch No</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Ch Date</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Description</font></th>
<td align="center" valign="middle" style="width:10%;border:1px solid #787f7a;" ><font size="2px" >HSN Code/<br>SAC Code</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Qty</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Taxable Value</font></th>

					<td align="center" colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >IGST</font></th>
				
<!-- 					<td align="center"  colspan ="2" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >SGST</font></th>
 -->				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Total</font></th>
				</tr>
					
				<tr >
				
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th>
					<!-- <td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Rate</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >Amount</font></th> -->
					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="2px" >&nbsp;</font></th>
				</tr>
					
			<!-- 	<tr>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;"><font size="2px">Parts</font></td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
					<td style="border:1px solid #787f7a;">&nbsp;</td>
				<td style="border:1px solid #787f7a;">&nbsp;</td>
				</tr> -->

<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'parts'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
								<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partnoo" />&nbsp;&nbsp;</font></td>
									<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2" ><s:property value="partdate" />&nbsp;&nbsp;</font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;width:45%"><font size="2px" ><s:property value="description" />&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="partnoox" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="2px" ><s:property value="tax_type" /></font></td>
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="2px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="2px" ><s:property
									value="vatamount" /></font></td>

						</tr>


				
</s:if>

				
				</s:iterator>

<tr>
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
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>
<td align="center" style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" >&nbsp;&nbsp;</font></td>							

						</tr>

				
				<s:iterator value="invoicebean_1" var="myobj">
				<s:if test="#myobj.type_1  ==  'labour'">

						<tr>
							<td align="center" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1" ><s:property value="sn" />&nbsp;&nbsp;</font></td>
						
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							<td align="left" 	style="border-right: 1px solid #787f7a;padding-left:5px;"><font size="1px" ><s:property value="tax_type" /></font></td>
							
							<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="quantity" /></font></td>
<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="myrate1" /></font></td>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="amount" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr1" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa1" /></font></td>
<%-- <td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gr2" /></font></td>

<td align="center" 	style="border-right: 1px solid #787f7a;"><font size="1px" ><s:property value="gsa2" /></font></td> --%>

							<%-- <td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property value="taxqmount" /></font></td> --%>
							<td align="right" 	style="border-right: 1px solid #787f7a;padding-right:5px;"><font size="1px" ><s:property
									value="vatamount" /></font></td>

						</tr>

				
</s:if>

				
				</s:iterator>




				
				
				
				
					
					
					
			<!-- <tr class="greadheading" style="border:1px solid #787f7a;">
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="left" valign="middle" style="border:1px solid #787f7a;" ><font size="2px">Labour</font></th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>

					<td align="center" valign="middle" style="border:1px solid #787f7a;" ><font size="1">Service Tax</font></th>
					<td align="center" valign="middle" style="border:1px solid #787f7a;" >&nbsp;</th>
				</tr> -->
				
			
				<!-- <tr >
					<td></td>
					<td><font size="2px">Labour</font></td>
				</tr > -->
				<%-- <s:iterator value="invoicebean_1" var="myobj">
					<s:if test="#myobj.type_1  ==  'labour'">

						<tr   >
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="sn" /></font></td>
							<td align="left" 	style="border-right: 1px solid grey;padding-left:5px;"><font size="1px"><s:property value="description" /></font></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>
							<td align="center" 	style="border-right: 1px solid grey;padding-right:5px;"></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="amount" /></font></td>

							<td align="right" 	style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property value="taxqmount" /></font></td>
							<td align="right" style="border-right: 1px solid grey;padding-right:5px;"><font size="1px"><s:property
									value="vatamount" /></font></td>

						</tr>

					</s:if>



				</s:iterator> --%>
				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				





				<!--tr  style="border:1px solid #787f7a;" >
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td align="right">&nbsp;</td>

					<td align="right"><font size="2px">&nbsp;</font></td>

					<td align="right"><font size="2px">&nbsp;</font></td>
					<td align="right"><font size="2px">&nbsp;</font></td>
				</tr-->
				



			
		
					<tr style="height:100%;">
						<th align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<!-- <th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th> -->
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>



						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
					</tr>

<tr style="height:100%;">
						<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						
							<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<td align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">TOTAL</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
						<!-- <td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td> -->
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><s:property value="netamt" /></font></th>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;;"><font size="2px">&nbsp;</font></td>
							<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="cgst" /></font></font></td>
						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></td>
<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="sgst" /></font></font></td>



						<td align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px"><font
									size="2px"><s:property value="grossamt" /></font></font></td>
					</tr>
					<tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;border-top: 1px solid #787f7a;">&nbsp;</td>
									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
										<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-top: 1px solid #787f7a;">&nbsp;</td>
								
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font size="2px" >Total Amount Before Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;border-top: 1px solid #787f7a;"><font
									size="2px"><s:property value="netamt" /></font></td>

								</tr>
								<%-- <tr>
									<td align="center"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;</td>
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
								

									<td align="left" colspan="2"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >CGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="cgst" /></font></td>

								</tr> --%>
								
					<tr>
									<td align="left" colspan="5"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >Bank Name: <%=bakname %></font></td>
								
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>

								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >IGST</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="sgst" /></font></td>

								</tr>
				
				<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >AC/ No: <%=accountno %></font></td>
									
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
									
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Tax Amount</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="tax" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="5"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;"><font size="2px" >IFSC Code: <%=ifsccode %></font></td>
									
										
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px">&nbsp;</font></td>
									
								
								

									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" >Total Amount after Tax</font></td>


									<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									size="2px"><s:property value="grossamt" /></font></td>

								</tr>
								
								<tr>
									<td align="left" colspan="12"
										style="padding-left: 5px;border-top: 1px solid black;border-left: 1px solid black;border-right: 1px solid black; padding-right: 5px;width:50px;">
									<font size="2px"><b>IN WORDS:<s:property
																			value="amountinwords" />&nbsp; ONLY</b></font>
																
</td>
								</tr>
								
									<tr>
									<td align="left" colspan="12"
										style=" padding-left: 5px;width:50px;border-right: 1px solid black;">
										<br>
										<font size="2px"><b>DECLARATION:</b></font><br>
										<font size="2px">1. We declare that this invoice shows the actual price of the goods described and that all particulars are true and correct.<br>
										2. Goods once sold will not be taken back.<br>
										3. Subject to Pune Jurisdiction
										</font>
									<br><br>
									
</td></tr>

<tr>


<td align="left" colspan="12" style="padding-left:5px;"
										><br>
									<br><br>
									<font size="2px">Customer's Signature</font>
</td>
</tr>

<tr>
<td align="right" colspan="12" style="padding-right:5px;width:900px;"
										>
									<font size="2px"> For<b><%=Company %></b></font><br>
									<br><br>
									Authorized Signatory
</td>
								</tr>
								<tr>
								<td colspan="12" style="border-right:1px solid #000000">
								<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">
								</td>
								</tr>
					</tbody>
			</table>		
</body>
</html>




