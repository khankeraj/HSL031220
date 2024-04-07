<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery.qrcode.min.js"></script>
<script type="text/javascript" src="js/qrcode.min.js"></script>
<script type="text/javascript" src="js/qrcode.js"></script>
 <!-- AutoSearch -->
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <script src="js/jquery.validationEngine.js" type="text/javascript" charset="utf-8"></script>
  <!-- AutoSearch -->




<script type="text/javascript">

	
	 
	 function printData()
	 {
		  var printButton = document.getElementById("Print");
	        //Set the print button visibility to 'hidden' 
	        printButton.style.visibility = 'hidden';
	        var printButton1 = document.getElementById("Home");
	        //Set the print button visibility to 'hidden' 
	        printButton1.style.visibility = 'hidden';
		
	    window.print();
	    
	    printButton1.style.visibility = 'visible';
	    
	    printButton.style.visibility = 'visible';
	   
	 }
	 
	 function goHome(){
		 
		 location.href="lr_Reports";
	 }
	 
	 
	 
	 </script>

<%-- <%
		Properties systemPropery = null;
		systemPropery = new Properties();

		//System.out.println(">>>>");
		systemPropery
				.load(new Spare_master_dao().getClass()
						.getResourceAsStream(
								"/com/aqua/dao/UserProfile.properties"));

		String name = systemPropery.getProperty("NAME");
		String address = systemPropery.getProperty("ADDRESS");
		String bankname = systemPropery.getProperty("BANKNAME");
		String acno = systemPropery.getProperty("ACNO");
		String ifsc = systemPropery.getProperty("IFSCCODE");
		String gstn = systemPropery.getProperty("GSTN");
	%> --%>

<style type="text/css"><!--

html,body,table#pagelayout {
height:98%;
width:99%;
font-family: calibri;
font-size: 1em;;
}


/* #qrcode {
  width:10px;
  height:10px;
  margin-top:0px;
}
 */
// -->
</style>
</head>
<s:bean name="com.master.model.TripModel" var="casestage" />
<body style="font-family: calibri;font-size: 1em;">





 <s:push value="tripModel"> 


<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">



<table id="pagelayout"   style="border: 1px solid #787f7a;width:99%;border-collapse:collapse;page-break-after: always; vertical-align: top;" >

<tr><td align="left" colspan="10"><table width="100%"><tr><td><img src="configure/img/logo.jpg" width="100px" style="margin-top: -40px;"></td>

<td align="center">

	<label style="margin-right:80px;margin-top: 0px;"><font size="5px;">Ambika Transport</label>
	<br>
	<font size="3px;" style="margin-right: 100px;">			
	Fleet Owners, Transport Contractor And Commission Agent
	</font>
	<br>
	<font size="2px;" style="margin-right: 150px;">			
	<%-- <%=address2 %> --%>
	Daily Service - Aurangabad, Jalna, Latur, Kolhapur, Nashik and whole Maharashtra
	</font>
	
	<br>
	<font size="2px;" style="margin-right: 100px;">			
	<%-- <%=contact %> --%>
	7385414141/9823547386
	</font>
	
<%-- <%=name %></font> --%>

<br>
<font size="3px;">			
<%-- <%=address %>&nbsp;&nbsop;&nbsp;GSTIN NO<%=gstn %> --%>

</font><br>
<%-- <font size="3px;">			
GSTIN NO<%=gstn %>
</font> --%>
</td>
<td><div id="qrcode"></div></td>

</tr>

<tr><td>GSTIN No : 27AQOPM7373CIZ1</td>
	
	<td colspan="2" align="right">Pan No : AQOPM 7373C</td>
</tr>

<tr><td align="center" colspan="11" style="border-top: 1px solid #000000;">
<font size="4px;">LR</font>
</td></tr>



</table>



</td>
</tr>




<tr>

<td colspan="5" align="left" valign="top"
							style="width:50%;border-left: 1px solid grey;border-right: 1px solid #787f7a;border-top: 1px solid #787f7a;border-bottom: 1px solid #787f7a;">


<table width="100%" style="border-collapse:collapse;" width="100%">

<tr>
<td valign="top" width="15%">
<font size="1em"><center>LR NO:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="lr_number" /></font>
</td>

<td valign="top" width="15%">
<font size="1em"><center>Date:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="date" /></font>
</td>


</tr>

<tr>
<td valign="top" width="15%">
<font size="1em"><center>TRANSPORTER:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="transporter_name" /></font>
</td>

<td valign="top" width="15%">
<font size="1em"><center>CUSTOMER:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="customer_name" /></font>
</td>


</tr>
<tr>

<td valign="top" width="15%">
<font size="1em"><center>Mobile No:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="mobile" /></font>
</td>
<td valign="top" width="15%">
<font size="1em"><center>SOURCE:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="source" /></font>
</td>


</tr>


<tr>

<td valign="top" width="15%">
<font size="1em"><center>DESTINATION:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="destination" /></font>
</td>

<td width="20%" style="">
<font size="1em"><center>ADDRESS:</center></font>
</td>
<td width="30%">
<font size="1em"><s:property value="customer_addr" /></font>
</td>

</tr>



<tr>
<td valign="top" width="15%">
<font size="1em"><center>VEHICLE NO:</center></font>
</td>
<td width="35%" style="">
<font size="1em"><s:property value="vehicle_no" /></font>
</td>

<td width="20%" style="">
<font size="1em"><center>DRIVER NAME:</center></font>
</td>
<td width="30%" style="">
<font size="1em"><s:property value="driver_name" />
</td>


</tr>



</table>
</td></tr>

			<!-- <tr><td> -->		
					<tr>
						<td style="font-size: 12px; font-weight: bold;">Description</td>
						<td style="font-size: 12px; font-weight: bold;">Weight</td>
						<td style="font-size: 12px; font-weight: bold;">Rate</td>
						<td style="font-size: 12px; font-weight: bold;">Amount</td>
					</tr>
					
					<c:forEach items="${tripModel.description}" varStatus="loop">
						<tr style="font-size: 12px; border: 1px solid black;">
						
					    <td><c:out value="${tripModel.description[loop.index]}"/></td>
					    <td><c:out value="${tripModel.weight[loop.index]}"/></td>
					    <td><c:out value="${tripModel.rate[loop.index]}"/></td>
					    <td><c:out value="${tripModel.amount[loop.index]}"/></td>
					   </tr>
					</c:forEach>
					
					
					
					<tr style="font-size: 12px;">
						<td>Total Amount : <s:property value="total_amount" /> <input type="hidden" id="tot_amt" value="<s:property value="total_amount" />"/>
						
							<br>Advance &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <s:property value="advance" />
							<br>Balance  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <s:property value="balance" />
							<br>
							<br>
							
						</td>
						<td></td>
						<td align="right"><label  style="font-size: 12px;">For Ambika Transport,</label>
						
						<br><br>Signature:
						</td>
						
					</tr>
					
					<!-- <tr style="font-size: 12px;">
						
						<td></td>
						
					</tr>
					
					<tr style="font-size: 12px;">
						
						
						<td></td>
					</tr> -->
					
					
					<%-- <c:forEach items="${tripModel.getDescription()}" var="current">
					
					            <tr>
					                <td><c:out value="${current}"/></td>
					                <td><c:out value="${current.weight}"/></td>
									<td><c:out value="${current.rate}"/></td>
									<td><c:out value="${current.amount}"/></td>
					            </tr>
					</c:forEach> --%>
					
					
<!-- <tr>
<td align="left" colspan="11" valign="top"
										style="padding-right: 5px;">
		<font size="1em"><p style="border: thin;">Terms & Conditions: <br>
			1. customer vehicles are received & store at customer's risk ,and the garage accepts no responsibility for loss and damage arising due to fire,theft and accedent orotherwise.<br>
			2. The Vehicles are tested on street highway at customer risk.<br>
			3. I here by authorize you to carry the above mentioned work on my vehicleas per your scheduled rates leaving margin and agree to pay all charges.<br>
			4. I understand that the estimate is provisional and any additional work must be authorized my self prior to commencement.</p> 
								</font></td>
										
									

</tr>
<tr> -->





								
									
								<tr>
								<td colspan="11" style="border-right:1px solid #000000">
								<!-- <input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight"> -->
								
								</td>
								</tr>
					</tbody>
					
			</table>
			
			
		</s:push>	


<script>
   // new QRCode(document.getElementById('qrcode'), 'LRNo: <s:property value="lr_number" />, Customer: <s:property value="customer_name" />, Date: <s:property value="date" />, Mobile: <s:property value="mobile" />');
   var tot = document.getElementById('tot_amt').value;
   var qrcode = new QRCode(document.getElementById('qrcode'), {
   text: 'LRNo: <s:property value="lr_number" />,  Date: <s:property value="date" /> ,Total Amount:'+tot, 
   width: 100,
   height: 100,
   colorDark : 'black',
   colorLight : 'white',
   correctLevel : QRCode.CorrectLevel.H
});
   
   
</script>



</body>
</html>




