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
		 
		 location.href="dashboard";
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

<%
String drv_id = request.getParameter("driver_id");
String drv1 = drv_id.substring(4);
//String path =  getServletContext().getRealPath("/").concat("images\\DRV\\"+drv1+"Driver-Photo(1).png");
String path1 = "images/DRV/"+drv1+"Driver-Photo(1).png";
%>

<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">


<table style="border: 1px solid #787f7a;width:40%;border-collapse:collapse;">
<tr><td style="padding-left: 0px;padding-top: 10px;"><img src="configure/img/logo.png" width="50px" ></td><td style="font-weight: bold;"><font size="3px;">&nbsp;&nbsp;&nbsp;AMBIKA TRANSPORT</font>
<br>
<%-- <font size="3px;" style="margin-right: 100px;">			
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fleet Owners, Transport Contractor And Commission Agent
	</font>
	<br>
	<font size="2px;" style="margin-right: 150px;">			
	<%=address2 %>
	&nbsp;&nbsp;Daily Service - Aurangabad, Jalna, Latur, Kolhapur, Nashik and whole Maharashtra
	</font>
	
	<br>
	<font size="2px;" style="margin-right: 100px;">			
	<%=contact %>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7385414141/9823547386
	</font>
	<br> --%>

<td align="left"><div id="qrcode"></div></td>
<td></tr>
</table>



<table style="border: 1px solid #787f7a;width:40%;border-collapse:collapse;">


<tr><td style="padding-left: 30px;padding-top: 10px;">

Driver Name:&nbsp;&nbsp;&nbsp;<font face="caibri" size="2px"><%=request.getParameter("driver_name") %></font><br><br>
Contact Number:&nbsp;&nbsp;&nbsp;<font face="caibri" size="2px"><%=request.getParameter("contact_number") %></font><br><br>
<img src="<%=path1%>" width="150px" style="margin-left: 30px;"><br><br>
Emergency Contact No:&nbsp;&nbsp;&nbsp;<font face="caibri" size="2px"><%=request.getParameter("emergency_contact_number") %></font><br><br>

</td>

<%-- <td align="right"><img src="<%=path1%>" width="150px" ></td> --%>
<td></tr>
</table>



<%-- <tr>
<td width="20%">
<font face="caibri" size="2px">Driver Name:</font>
</td>
<td width="30%" style="border-right:1px solid #787f7a;">
<font face="caibri" size="2px"><%=request.getParameter("driver_name") %></font>
</td>

</tr>

<tr>
<td width="20%">
<font face="caibri" size="2px">Contact No:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><%=request.getParameter("contact_number") %></font>
</td>

</tr>



<tr>
<td width="20%">
<font face="caibri" size="2px">Emergency Contact No:</font>
</td>
<td width="30%">
<font face="caibri" size="2px"><%=request.getParameter("emergency_contact_number") %></font>
</td>

</tr> --%>





<script>
   // new QRCode(document.getElementById('qrcode'), 'LRNo: <s:property value="lr_number" />, Customer: <s:property value="customer_name" />, Date: <s:property value="date" />, Mobile: <s:property value="mobile" />');
  // var tot = document.getElementById('tot_amt').value;
   var qrcode = new QRCode(document.getElementById('qrcode'), {
   text: 'Driver Id: <%=request.getParameter("driver_id")%>, Driver name: <%=request.getParameter("driver_name")%>, Contact Number: <%=request.getParameter("contact_number")%>', 
   width: 60,
   height: 60,
   colorDark : 'black',
   colorLight : 'white',
   correctLevel : QRCode.CorrectLevel.H
});
   
   
</script>



</body>
</html>




