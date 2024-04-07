<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>
<%@page import="com.DB.DBConnection,java.sql.* "%>


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
		// document.getElementsByClassName('sss').style.visibility='hidden';
		//alert("11");
		document.getElementById("Print").style.visibility="hidden";
		document.getElementById("Home").style.visibility="hidden";
		//document.getElementById("11").style.visibility="hidden";
		 
		
	    window.print();
	    document.getElementById("Print").style.visibility="visible";
	    document.getElementById("Home").style.visibility="visible";
	   // document.getElementsByClassName('sss').style.visibility='visible';
	    //document.getElementById("11").style.visibility="visible";
	   
	 }
	 
	 function goHome(){
		 
		 location.href="dashboard";
	 }
	 
	 
	 
	 </script>

<%
		
		
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
int mycolspan=6;

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

<div >
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

<tr><td align="center" colspan="<%=mycolspan %>" style="border-top: 1px solid #787f7a;border-right:1px solid #787f7a">
<font face="caibri" size="4px;"> <b>QUOTATION</b></font>
</td></tr>


<tr>
<td colspan="<%=mycolspan %>">


<table width="100%" style="border-top: 1px solid #787f7a;border-bottom: 1px solid #787f7a;border-collapse:collapse;" width="100%">
<s:iterator value="Report1" > 
<tr>
<td width="20%">
<b><font face="caibri" size="2px">Customer Name:</font></b>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><s:property value="name" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<b><font face="caibri" size="2px">Quotation No:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px">  <s:property value="quotation_no" /></font>
</td>
</tr>

<tr>
<td width="20%">
<b><font face="caibri" size="2px">Address:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="address" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<b><font face="caibri" size="2px">Date:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px"> <s:property value="date" /></font>
</td>
</tr>





<tr>
<td width="20%">
<b><font face="caibri" size="2px">Mobile No:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="contact_no" /></font>
</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<b><font face="caibri" size="2px">Reference:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="reference" /></font>

</td>
</tr>
<tr>
<td width="20%">
<!-- <font face="caibri" size="2px"><b>Email:</b></font> -->
</td>
<td width="30%">

</td>
<td width="20%" style="border-left:1px solid #787f7a;">
<b><font face="caibri" size="2px">Kind Attn:</font></b>
</td>
<td width="30%">
<font face="caibri" size="2px"><s:property value="kind_attn" /></font>
</td>
</tr>

</s:iterator>

</table>




</td>
</tr>



<%-- <tr><td align="left" colspan="<%=mycolspan %>" style="border-bottom: 1px solid #787f7a;border-right:1px solid #787f7a">
<font face="caibri" size="2px"><b>SUBJECT:</b>&nbsp;</font>
</td></tr> --%>


<tr >
<td align="center" valign="middle" style="border-bottom:1px solid #787f7a;width:1%" ><font face="caibri" size="2px"><b>SR</font></th>
						
						
	<td align="center" valign="middle" style="border-bottom:1px solid #787f7a;border-left:1px solid #787f7a;width:35%" ><font face="caibri" size="2px"><b>Type Of Vehicle &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>

<!-- <td align="center" valign="middle" style="border-bottom:1px solid #787f7a;border-left:1px solid #787f7a;" ><font face="caibri" size="2px"><b>Size Of Vehicle</font></th> -->
<td align="center" valign="middle" style="border-bottom:1px solid #787f7a;border-left:1px solid #787f7a;width:18%" ><font face="caibri" size="2px"><b>From</font></td>
<td style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center;width:18%"><font face="caibri" size="2px"><b>To</b></td>


<td align="center" valign="middle" style="border-bottom:1px solid #787f7a;border-left:1px solid #787f7a;width:10%" ><font face="caibri" size="2px"><b>&nbsp;Weight&nbsp;</font></td>
<td align="center" valign="middle" style="border-bottom:1px solid #787f7a;border-left:1px solid #787f7a;width:15%" ><font face="caibri" size="2px"><b>Rate</font></td>




					
				</tr>
					
				
					
			
			 <s:iterator value="Report" var="myobj">
                                       
											 <tr>
										<td  style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px">&nbsp;<s:property value="sn" /></td>
										<td valign="top" colspan="" style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font face="caibri" size="2px"><b><s:property value="aa1" /></b></td>
										
										
										<%-- <td  align="right"  style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center"><font face="caibri" size="2px"><s:property value="bb1" /> </td> --%>
										
										<td  align="right"  colspan="" style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center"><font face="caibri" size="2px"><s:property value="ee1" /> </td>
										<td  align="right"  style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center"><font face="caibri" size="2px"><s:property value="ff1" /> </td> 
										<td  align="right"  style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center;"><font face="caibri" size="2px"><s:property value="qty1" /> <s:property value="cc1" /> </td>
										<td  align="right" style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;text-align:center"><font face="caibri" size="2px"><s:property value="dd1" /> </td>
										
										
																
											 </tr>
												

									
                                        </s:iterator>
                                



			



								 <tr style="height:100%;">
						<th align="center" valign="middle"
							style="border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<!-- <th colspan="" align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th> -->
						<th colspan="" align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
							<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th colspan="" align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						<th align="center" valign="middle"
							style="border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;"><font size="2px">&nbsp;</font></th>
						

</tr>

<s:iterator value="Report1">
<tr>
									<td align="left" colspan="4"
										style="border-top: 1px solid grey;border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;<font face="caibri" size="2px"><b>Bank Name &nbsp;:&nbsp;<%=bank %></td>
									
									<!-- <td align="right" colspan=""
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font size="2px" ><font face="caibri" size="2px">&nbsp;</font></td> -->
								
									<td align="right"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font
									face="caibri" size="2px"><b>Total Rate</b></font></td>
									
									 <td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;"><font
									size="2px"><b><s:property value="total" /></b></font></td>
											
									

								</tr>
								
								
								<tr>
							
										<td align="left" colspan="4"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;<font face="caibri" size="2px"><b>Account No &nbsp;:&nbsp;<%=acno %></td>
									
									
									
										<!-- <td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td> -->
									
								<td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;">&nbsp;</td>
								
									<td align="right" colspan=""
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:100px;"><font face="caibri" size="2px"><b></font></td>
									


									
								</tr>
								
								
								
								
								<tr>
										<td align="left" colspan="4"
										style="border-left: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:50px;">&nbsp;<font face="caibri" size="2px"><b>IFSC Code &nbsp;&nbsp;:&nbsp;<%=ifsc %><br>&nbsp;<font face="caibri" size="2px"><b>Branch&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :&nbsp;Khadki Pune</td>
									
										<!-- <td align="left"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-left: 5px;width:550px;border-bottom: 1px solid grey;">&nbsp;</td> -->
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-bottom: 1px solid grey;"><font
									size="2px">&nbsp;</font></td>
									<td align="center"
										style="border-top: 1px solid grey;border-right: 1px solid grey; padding-right: 5px;width:150px;border-bottom: 1px solid grey;"><font
									size="2px">&nbsp;</font></td>
								
								
								

								</tr>
								 

						
			
		<tr>



<td colspan="<%=mycolspan %>" style="border-top: 1px solid grey;" >
<table style="width:100%">


<tr>

<b><u>&nbsp;TERMS AND CONDITIONS.</u></b>
<font face="caibri" size="1px">
<br>
<b>&nbsp;1. Statistical Charges:</b> Rs 100/-per consignment note.
<br>
<b>	&nbsp;2. Halting Charges:</b> Rs <s:property value="halt_charge" />/-per day / <s:property value="vehicle_type" /> .
<br>
<b>&nbsp;3. Loading / Unloading:</b> On A/c of the supplier and Consignee.
<br>
<b>&nbsp;4. Over Dimension:</b> The penalties would be as per receipts / mutual agreements.

<br>
<b>&nbsp;5. Transit Insurance:</b> Should be arranged by the Supplier. In case of any damage / shortage  caused due to force majure/accident/gods act client has to take it up with &nbsp;&nbsp;respective insurance company. We Shall issue damage certificate after receiving insurance survey report from the client.

<br>
<b>&nbsp;6. Document related to dispatch</b> should purely be on consignor's responsibility.

<br>
<b>&nbsp;7. Refusal of material or Change of delivery address:</b> In case of return transport it would be considered as a fresh consignment and the freight has to be discussed case to &nbsp;&nbsp;case. If the cargo is offloaded at any other location,we shall charge additional amount agreed mutually.

<br>
<b>&nbsp;8. GST :</b> As Applicable under RCM
<br>
<b>&nbsp;9. Rates Validity:</b> Immediate for 7 days only

<br>

<b>&nbsp;10. Payment terms :</b> <s:property value="payterm" /> days from our invoice.
</font>

</tr>
</s:iterator>

<tr>
<td align="left"  style="padding-left:5px;width:50%" >
									<font face="caibri" size="2px">Customer's Signature</font>
</td>
<td align="right" style="padding-right:5px;width:50%"
										>
									<font face="caibri" size="1px"> For <b><%=name %></b></font>
									<br><br>
									<font face="caibri" size="2px">Authorized Signatory<br>
</td>
</tr>


								



</table>
	</td>							</tr>
	
	
								
								
					</tbody>
			</table >	
			
			
			
		

 
 