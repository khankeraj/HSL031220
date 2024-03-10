<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
	 function printData()
	 {
		
	    var divToPrint=document.getElementById("quotation");
	    newWin= window.open("");
	    newWin.document.write(divToPrint.outerHTML);
	    newWin.print();
	    newWin.close();
	 }
</script>
<style>

.img1 { 
   border:1px solid #ffff;
}




.ourProduct{
background: url('ourproduct.gif') !important;
background-size: 100% 950px;
}


@media print {
* {
    -webkit-print-color-adjust: exact !important; /*Chrome, Safari */

  }
  
}

#pagelayout{
page-break-after: always;
}

#xyz{

  background: url("configure/img/u.png");
  background-repeat: no-repeat;
  background-size: 100% 100%;
  position: fixed; top: 0; left: 0;height:100%;
  width:100% 

} 

.background2 {

background: url('backgroundimage1.png') !important;
color: white !important;
background-size: 100% 100%;
}


.ourCLient{
color:#000000;
}

.striped_tab tr:nth-child(odd){
 background-color: #f2f2f2;
}



.container {
  position: relative;
  /* font-family: Arial; */
}

.text-block {
  position: absolute;
 /*  bottom: 20px;
  right: 20px; */
  /* background-color: black; */
  color: white;
  padding-left: 20px;
  padding-right: 20px;
  padding-top: 80px;
}



</style>
</head>


<body>
<div style="position: fixed; top: 20%; left: 20%;opacity:0.4;z-index:1; "><img src="configure/img/99.png" width="100%" height="100%"/></div>


<div id="pagelayout" style="height:100%">
<img alt="" src="configure/img/cover1.png" width="100%" height="40%">
<div style="height: 300px; width:100%;background-color: #27aae1" >
<div style="width:30%; float:right;padding-top: 50px;"><img alt="" src="configure/img/2.png" height="200px" width="220px" style="margin-left:-50px;" class="img1" ></div>
	<div style="width:70%;">
		<font color="#ffffff" face="calibri" size="20em" style="margin-left: 25px">PROJECT</font><br>
		<font color="#ffffff" face="calibri" size="20em" style="margin-left: 25px"><b>PROPOSAL</b></font><br>
		<font color="#ffffff" face="calibri" size="3px;" style="margin-left: 25px">Packaged Drinking Water Plant</font>
		<hr width="95%"  style="border-width: 1px; align:left; padding-left:0px; margin-left:0px;">
		<font color="#ffffff"><font color="#ffffff" face="calibri" style="margin-left: 25px">Prepared For<br>
					<s:iterator value="coverDetails">
						<font color="#ffffff" face="calibri" style="margin-left: 25px">${to}<br>
						<font color="#ffffff" face="calibri" style="margin-left: 25px">${address}<br>
						<font color="#ffffff" face="calibri" style="margin-left: 25px">${city},${state}<br>
					</s:iterator>
	</div>
	
	
		
</div>
	<div>
			<img style="margin-left: 45%; margin-top:10%; height:100px; width:400px;" alt="logo" src="configure/img/logo.png">
	</div>
	
</div>

<div>
</div>


<div id="pagelayout" style="height:100%;width:100%" >

	<img alt="heading page" src="configure/img/blackbg.jpg" width="100%" height="100%">
</div>

<div id="pagelayout" style="height:100%;width:100%">
		<img alt="logo" src="configure/img/logo.png"  style="margin-left: 25%; margin-top:5%; height:100px; width:300px">
		<img alt="heading page" style="width:90%;height:600px; padding-left:20px;padding-right:20px;margin-top:10%" src="configure/img/secongbg.png"   >
		<hr style="color:#787F7A;">
		<%-- <span style="z-index:999">	<font color="#000000" face="calibri"><center>WE ARE TO SERVE YOU</center></font><br>
		<font color="#0d96ec" face="calibri" size="70px;"><center>ABOVE & BEYOND</center></font></span>  --%>
		<font style="text-align: center; color:#000000; font-size: 25px;font-family: Trajan;"><center>WE ARE TO SERVE YOU</center></font><br>
		<font style="text-align: center; color:#0099ff; font-size: 50px;font-family: Trajan;"><center>ABOVE & BEYOND</center></font>
</div>


<%-- <div id="pagelayout" style="height:100%;width:100%" class="background2">

<table align="center" style="width:100%; height:100%;">
<tr>
	<td>
	    <center>
		<h1 align="left" style="margin-top:20%;margin-left:17%" ><b>WHO WE ARE ?<br></b></h1>
			<p class="whoweare" style="width: 65%; color: white; font-size: 20px;" class="indented" align="left">
				Ultracare Group is a leading turnkey solution provider of Packaged Drinking Water and water treatment equipment all over the India. With its full commitment, high quality and customer first business principles, Ultracare Group has set up strict quality controls in the manufacturing and offer complete after-sale services with well-groomed service team.In the field of Packaged Drinking Water project and water Treatment equipment industry, keeping alive our motto to aim higher, we made our team well groomed. Ultracare is the only Turnkey solution provider for packaged Drinking Water Projects in India. Adding more allied services like, Market research, Marketing strategy and planning, product design, and resource of expert plant operating team to smooth function of Production line. We strictly deal with genuine and reputed vendor to ensure quality supply of raw material at any time.While catering our clients, we believe in Understanding requirement, well planning, execution, delivery and best response for after sales services.
			</p>
		</center>
	</td>
</tr>
</table>

</div> --%>


<div id="pagelayout" style="height:100%;width:100%" class="container">
	<div class="text-block">
			<center>
		<h1 align="left" style="margin-top:20%;margin-left:17%; font-family: Trajan;" ><b>WHO WE ARE ?<br></b></h1>
			<p class="whoweare" style="width: 65%; color: white; font-size: 20px;" class="indented" align="left">
				Ultracare Group is a leading turnkey solution provider of Packaged Drinking Water and water treatment equipment all over the India. With its full commitment, high quality and customer first business principles, Ultracare Group has set up strict quality controls in the manufacturing and offer complete after-sale services with well-groomed service team.In the field of Packaged Drinking Water project and water Treatment equipment industry, keeping alive our motto to aim higher, we made our team well groomed. Ultracare is the only Turnkey solution provider for packaged Drinking Water Projects in India. Adding more allied services like, Market research, Marketing strategy and planning, product design, and resource of expert plant operating team to smooth function of Production line. We strictly deal with genuine and reputed vendor to ensure quality supply of raw material at any time.While catering our clients, we believe in Understanding requirement, well planning, execution, delivery and best response for after sales services.
			</p>
		</center>
	</div>
	<img alt="heading page" src="backgroundimage1.png" width="100%" height="950px">
	
</div>

<div id="pagelayout" style="height:100%;width:100%" class="container">
	<div class="text-block" style="margin-top:120px;margin-left:50px;">
			<h1><font color="#ffffff" face="calibri" style="font-family: Trajan;">OUR PRODUCTS<br></h1>
			<font color="#ffffff" face="calibri">Turnkey Packaged<br>
			<font color="#ffffff" face="calibri">Drinking Water Project<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Water Treatment<br>
			<font color="#ffffff" face="calibri">Equipments<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Water ATM<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Domestic Products<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Consumable<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Medical RO<br>
			<hr width="250%" align="left"><br>
			
			<font color="#ffffff" face="calibri">Water Softeners<br>
			
			<img alt="logo" src="logoultra.png" style="margin-left:200%;margin-top:40%;">
	</div>
	<img alt="heading page" src="ourproduct.png" width="100%" height="950px">
	
</div>




<!-- <div id="pagelayout" class="ourProduct" style="height:100%;width:100%">
<table style="width:80%"><tr>
<td >
<p>
<h1 style="margin-top:20%;margin-left:10%;"><font color="#ffffff" face="calibri">OUR PRODUCTS<br></h1>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Turnkey Packaged<br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Drinking Water Project<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Water Treatment<br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Equipments<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Water ATM<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Domestic Products<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Consumable<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Medical RO<br>
<hr width="100%" align="left" style="margin-left:10%;"><br>
<font color="#ffffff" face="calibri" style="margin-left:10%;">Water Softners<br>

<p align="right" >
<img alt="logo" src="logoultra.png">
</p>
</p>
</td></tr>
</table>
</div>
 -->
<div id="pagelayout" style="height:100%;width:100%; page-break-before:always;" class="ourCLient">

<table>
 	<tr><td colspan="3"><h1><font color="#0d96ec" style="margin-left:50px; font-family: Trajan;color:#005c99;">OUR CLIENTS</font></h1></td></tr>
 	
 	<tr align="center">
	<td><img alt="" src="configure/img/volk.png" style="width: 120px;padding-left: 50px; height: 120px"></td>
	<td><img alt="" src="configure/img/bajaj.png" style="width: 100px;padding-left: 100px; height: 120px"></td>
	<td><img alt="" src="configure/img/bharat.png" style="width: 100px;padding-left: 100px; height: 120px"></td>
	</tr>
 	
 	<tr align="center">
 		
 		<td><img alt="" src="configure/img/axis.png" style="width: 130px;padding-left: 50px; height: 80px; padding-top: 50px"></td>
 		<td><img alt="" src="configure/img/symbiosis.png" style="width: 130px;padding-left: 100px; height: 80px; padding-top: 50px"></td>
 		<td><img alt="" src="configure/img/infosys.png" style="width: 80px;padding-left: 100px; height: 120px; padding-top: 50px"></td>
 	
 	</tr>
 	
 	<tr align="center">
	<td><img alt="" src="configure/img/international.png" style="width: 100px;padding-left: 50px; height: 80px; padding-top: 50px"></td>
	<td><img alt="" src="configure/img/trp.png" style="width: 130px;padding-left: 100px; height: 80px; padding-top: 50px"></td>
	<td><img alt="" src="configure/img/university.png"  style="width: 100px;padding-left: 100px; height: 80px; padding-top: 50px"></td>
	</tr>
 	
 	<tr><td colspan="3" style="font-color:#0d96ec;"><h3><font color="#0d96ec" style="margin-left:50px; font-family: Trajan;color:#005c99;">PACKAGED DRINKING WATER PROJECTS</font></h3></td></tr>
 
 	<tr align="center">
	<td><img alt="" src="configure/img/spenca.png" style="width: 130px;padding-left: 50px; height: 80px"></td>
	<td><img alt="" src="configure/img/swizzale.png" style="width: 130px;padding-left: 100px; height: 80px"></td>
	<td><img alt="" src="configure/img/raghav.png" style="width: 130px;padding-left: 100px; height: 80px"></td>
	</tr>
 
 </table>
	 <img alt="water" src="bottom.png" width="100%"/>

</div>


<div id="pagelayout" style="height:100%;width:100%">
<p><h1><b style="margin-left: 50px;font-color:#0d96ec;"><font color="#0d96ec" style="font-family: Trajan;color:#005c99;">PROJECT INCLUDES</font><br></b></h1></p>
			<p style="margin-left: 50px; color:black;">01.Understanding market and client requirements</p>
			<p style="margin-left: 50px; color:black;">02.Manufacture machineries as per requirements</p>
			<p style="margin-left: 50px; color:black;">03.Consultancy to build factory as per BIS standards</p>
			<p style="margin-left: 50px; color:black;">04.Machineries erection & setup</p>
			<p style="margin-left: 50px; color:black;">05.BIS consultancy</p>
			<p style="margin-left: 50px; color:black;">06.Preparation of BIS inspection and execution as per BIS guideline</p>
			<p style="margin-left: 50px; color:black;">07.Technical recruitment and training</p>
			<p style="margin-left: 50px; color:black;">08.Product design</p>
			<p style="margin-left: 50px; color:black;">09.Marketing strategy and planning</p>
			<p style="margin-left: 50px; color:black;">10.Service & support</p>
			<p style="margin-left: 50px; color:black;">11. Initial co-ordination with all genuine raw material suppliers to
											procure right raw material.</p>
			<p style="margin-left: 50px; color:black;">12. And of course healthy business relationship.</p>
			
			<img alt="water" src="bottom.png" width="100%" style="margin-top:167px;"/>
</div>


<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />
		<s:iterator value="contractDetails">
		<p align="left" style="color: black;">Reference: ${ref_no} <font style="margin-left: 70%; color: black;">Date: ${requiredDate}</font><br></p>
		<p align="left" style="margin-top: 0px; color: black;">
		
		</p>

		<%-- <font style="color: black;">${name1},</font><br>
		<font style="color: black;">${name2},</font><br>
		<font style="color: black;">${address},</font><br> --%>
		<font style="color: black;">To,<br>
		<font style="color: black; font-weight: bold;">${to},</font><br>
		<font style="color: black; font-weight: bold;">${city},</font>
		<font style="color: black; font-weight: bold;">${state} - ${pincode},</font><br>
		<font style="color: black; font-weight: bold;">${contact}</font><br>
		<font style="color: black; font-weight: bold;">${email}</font><br>
		<p style="color: black; margin-left:30%;">Subject: ${subject}</</p><br>
		<p align="left" style="margin-top: 0px; color: balck; color: black;">Dear Sir / Madam,</p>
		<p align="left" style="margin-top: 0px; color: balck; color: black;">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;We <b>ULTRACARE GROUP</b> are engaged to serve water treatment and management solutions. We are proud to acclaim
		for fulfilling customers water treatment requirement as per their requirement. Ultracare has deep experience of water treatment
		and management since 2006. Since last one decade we have setup Fifty plus Packaged Drinking Water Project and more than
		thousand RO water treatment plant in India. We are serving water solutions product to various industries like, food Processing,
		Poultry farm, Sugar factories, Pharmaceuticals, Corporate establishments, business collages, Housing complexes, Army base
		camp and construction sites. Some of these regulated industries require stringent testing and validation procedure in order to
		gain approvals. Our products comply with current good manufacturing practice and requirement of Indian, British and United
		State Pharmacopoeia.
		We have well groomed technical team to implement Turn-key basis project and to serve industries best response. We wish to
		remember our self in customers mind for efficient work.
		We assure that we will provide you best project solution as per your requirement and expect to remember our self before
		finalization of your valued project.
		</p>
		<P align="right"></P>
		<%-- <p align="right" style="color: black;">Thanking You,</p>
		<p align="right" style="color: black;"><span>${proCoOrdiName}</span></p>
		<p align="right" style="color: black;">Project CO-Ordinator</p>
		<p align="right" style="color: black;"><span>${proCoOrdiContactNo}</span></p>
		<p align="right" style="color: black;">For Aquaberry Ro System Private Ltd</p>
		<p align="right" style="color: black;">(ULTRACARE GROUP OF COMPANIES)</p> --%>
		<div align="right">
		<font style="color: black;">Thanking You,</font><br>
		<font style="color: black; font-weight: bold;">${proCoOrdiName}</font><br>
		<font style="color: black; ">Project CO-Ordinator</font><br>
		<font style="color: black; ">${proCoOrdiContactNo}</font><br><br>
		<font style="color: black; ">For Aquaberry Ro System Private Ltd</font><br>
		<font style="color: black; ">(ULTRACARE GROUP OF COMPANIES)</font><br>
		</div>
</s:iterator>
<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 30%;"/>
</div>
</div>

<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />
	<h3 style="color:black;">Our best techno-commercial offer is constructed as follow:-</h3>
	
	<ul style="margin-left:-15px; color:black;">
				<li style="font-size:19px; font-weight:normal;">Process of the system and design</li>
				<li style="font-size:19px; font-weight:normal; padding-top:10px;">Scope of supply with technical specifications and scope of exclusion</li>
				<li style="font-size:19px; font-weight:normal; padding-top:10px;">Price with commercial terms and conditions</li>
				<li style="font-size:19px; font-weight:normal; padding-top:10px;">Document list (if any)</li>
	</ul>
	
	<table>
			<s:iterator value="quotationIndexList" var="quotationIndexList">
			<s:if test="%{#quotationIndexList.name_of_index != null && #quotationIndexList.name_of_index != ''}">
			<tr><td><b><font style="color:black;">${name_of_index}</font></b></td></tr>
			</s:if>
			</s:iterator>
			
			
			<% int count=1; %>
			<s:iterator value="quotationIndexList" var="quotationIndexList">
			<s:if test="%{#quotationIndexList.subindex != null && #quotationIndexList.subindex != ''}">
			
			<tr><td><font style="color:black;"><%=count++%>) ${subindex}</font></td></tr>
			</s:if>
			</s:iterator>
	</table>
	
<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 40%;"/>
</div>	
</div>

<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px"/>

	<s:iterator value="romaster" var="romaster">
				<s:if test="%{#romaster.name_of_index != null && #romaster.name_of_index != ''}">
	<font style="color:#0080ff; font-size: 25px;"><u>${name_of_index}</u></font>
	</s:if>
	</s:iterator>
	
	<img alt="roWater" src="configure/img/roWater.png" style="width:100%; height:250px; border:1px solid black;margin-top:5px;padding-right:5px;">
	
<table style="vertical-align: top;">
<tr>
	<td width="50%" style="vertical-align: top;">
		<table width="100%;" class="striped_tab" style="vertical-align: top;" >
		<s:iterator value="romaster" var="romaster">
			<s:if test="%{#romaster.specifi != null && #romaster.specifi != ''}">
				<tr>
					<td style="color:black;">${specifi}</td>
					<td width="20%;" style="color:black;">${qty}</td>
				</tr>
			</s:if>
		</s:iterator>
		</table>
	</td>
	
	<td><div class="vl" style="border-left: 2px solid #0d96ec; height: 500px;"></div></td>
	
	<td width="50%" style="padding-left:5px;padding-top:0px;vertical-align: top;">
			<table style="border-collapse: collapse;vertical-align:top;">
			<tr><td colspan="2"><font style="color:black; font-size: 13px;">The following are technical specification for equipments supply for drinking water project.</font></td></tr>
			<tr style="padding-bottom:0px;margin-bottom:0px;"><td colspan="2" style="padding-bottom:0px;margin-bottom:0px;"><font style="color:#0d96ec;"><u>Design Basis</u></font></td></tr>
				<s:iterator value="romaster">
					<s:if test='specifi1!=""'>
							<tr style="color: black; font-size: 13px;">
								<td>${specifi1}</td>
								<td width="50%;">${qty1}</td>
							</tr>
						</s:if>	
				</s:iterator>
				
				<s:iterator value="romaster">
				<s:if test='specifi2!=""'>
					<tr style="color: black; padding-top:0; font-size: 13px;">
						<td style="font-weight: bold;padding-top:0;">${specifi2}</td>
						<td width="50%" style="padding-top:0;">${qty2}</td>
					</tr>
					</s:if>
				</s:iterator>
				
				<s:iterator value="romaster">
				<s:if test='subHeading1!=""'>
					<tr style="color: black; font-size: 13px;">
						<td colspan="2"><b>${subHeading1}</b>
						</td>
					</tr>
				</s:if>
				</s:iterator>
				
				<%-- <s:iterator value="romaster" var="romaster">
				<s:if test="%{#romaster.subHeading2 != null && #romaster.subHeading2 != ''}">
					<tr style="color: black">
						<td colspan="2">${subHeading2}</td>
					</tr>
				</s:if>
			    </s:iterator> --%>
			    
			    <tr style="color: black; font-size: 13px;"><td colspan="2">The approximate treated water quality is as follows however it depends on raw water quality consider for design of system.</td></tr>
			    
			    <s:iterator value="romaster">
				<s:if test='specifi3!=""'>
					<tr style="color: black; font-size: 13px;">
						<td><b>${specifi3}</b></td>
						<td>${qty3}</td>
					</tr>
				</s:if>
				</s:iterator>
				
				<%-- <s:iterator value="romaster">
				<s:if test='summary!=""'>
						<tr style="color: black">
							<td colspan="2" width="100%">${summary}</td>
						</tr>
				</s:if>
				</s:iterator> --%>
				
				<tr style="color: black; font-size: 13px;"><td colspan="2">The above treated water quality is approximate assumption, we can change the property of minerals/ions 
				in Treated water by reducing and editing the mixing water quality in R.O. treated water.</td></tr>
				
			
		</table>
	</td>
</tr>	
</table>
<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:2%;"/>
</div>

</div>


<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px"/>


<table>

		<tbody>
	<tr>
		<td colspan="2">
			<table style="margin-top: 0px;">
					<s:iterator value="romaster" var="romaster">
					<s:if test="%{#romaster.name_of_index1!=null && #romaster.name_of_index1!=''}">
						<tr>
							<td style="color: #0d96ec"><u><b>${name_of_index1}</b></u></td>
						</tr>
					</s:if>
					</s:iterator>
			</table>
		
		
		</td>
	</tr>

				
		   		<% int cnt=0; int flag=1; %>
		   		
			   		<s:iterator value="rotechspecifications">
			   		<% if(cnt==2){ %>
		   			<tr>
		   			<% cnt = 0;
		   			
		   			%>
		   			<%} %>
		   			<% cnt++; %>
			   		<td valign="top">
							   		<table width=100% <%if(cnt==1){ %>style="border-right: 2px solid #0d96ec;" <%} %> >
							   			<tr>
							   				   			
							   			<th colspan="2" align="left"><u><b><%=flag%>. ${ro_heading}</b></u></th>
							   			</tr><%flag++; %>
									 	<s:iterator value="(size).{# this}" status="stat">
							   			<tr>
						   				<td width="50%" style="font-size: 13px;"><s:property value="rosp[top]"/></td>
						   				<td width="50%" style="font-size: 13px;"><s:property value="roqty[top]"/></td>
						   				
						   			</tr>
						   			</s:iterator>
						   		
						   			</table>
		   			</td>
		   			
		   		<% if(cnt==2){ %>
		   			</tr>
		   			<%} %>
		   			
		  </s:iterator>
			   		
		   	
</tbody>




</table>






<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:40%;"/>
</div>

</div>



<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px"/>

<table>
		
	
	   <tr>
		   <td colspan="2">
		   		<table>
		   		<s:iterator value="fabrfclist" var="fabrfclist">
		   		<s:if test="%{#fabrfclist.fab_rfc_name != null && #fabrfclist.fab_rfc_name != ''}">
		   			<tr><td style="color:#0080ff; font-size: 25px;"><u><b>${fab_rfc_name}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  <tr>
		   <td colspan="2">
		   		<table>
		   			<tr>
			   			<td>
			   			<img align="middle" alt="" src="configure/img/fabRFCappingmachine.png" style="border: 1px solid black; padding: 2px 2px; width:100%; height:250px;">
			   			</td>
		   			</tr>
		   		</table>
		   	</td>
	  </tr>
	</table>
	
	
	<table>
	<tr><td width="50%">
	<table>  
	
	  <tr><td colspan="2"><s:iterator value="fabrfclist" var="fabrfclist">
	  				<s:if test="%{#fabrfclist.fab_rfc_subname != null && #fabrfclist.fab_rfc_subname != ''}">
		   				<tr align="left"><td style="color: #0d96ec; font-size:15px;" colspan="2"><u><b>${fab_rfc_subname}</b></u></td></tr>
		   			</s:if>
		   		</s:iterator></td>
     </tr>
	  
	  <tr>
		   <td>
		   		<table>
			   		<s:iterator value="fabrfclist" var="fabrfclist">
			   			<s:if test="%{#fabrfclist.fab_rfc_sp1 != null && #fabrfclist.fab_rfc_sp1 != ''}">
				   			<tr>
					   			<td align="left" style="font-size: 13px;">${fab_rfc_sp1}</td>
					   			<td  align="left" style="font-size: 13px;">:${qty1}</td>
				   			</tr>
			   			</s:if>
			   		</s:iterator>
		   		</table>
		   	</td>
		   	<td></td>
	  </tr>
	  
	  <tr>
	  	<td colspan="2">
	  		<table>
	  			<s:iterator value="fabrfclist" var="fabrfclist">
	  			<s:if test="%{#fabrfclist.heading1 != null && #fabrfclist.heading1 != ''}">
	  				<tr><td><u><b>${heading1}</b></u></td></tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="fabrfclist" var="fabrfclist">
			   		<s:if test="%{#fabrfclist.fab_rfc_sp2 != null && #fabrfclist.fab_rfc_sp2 != ''}">
			   			<tr style="font-size: 13px;">
				   			<td  align="left" style="font-size: 13px;">${fab_rfc_sp2}</td>
				   			<td align="left" style="font-size: 13px;">:${qty2}</td>
			   			</tr>
			   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
		   	<td></td>
	  </tr>
	  
	  <tr>
	  	<td colspan="2">
	  		<table>
	  			<s:iterator value="fabrfclist" var="fabrfclist">
	  			<s:if test="%{#fabrfclist.heading2 != null && #fabrfclist.heading2 != ''}">
	  				<tr><td><u><b>${heading2}</b></u></td></tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="fabrfclist" var="fabrfclist">
		   		<s:if test="%{#fabrfclist.fab_rfc_sp3 != null && #fabrfclist.fab_rfc_sp3 != ''}">
		   			<tr>
			   			<td  align="left" style="font-size: 13px;">${fab_rfc_sp3}</td>
			   			<td  align="left" style="font-size: 13px;">:${qty3}</td>
		   			</tr>
		   			</s:if>
		   			</s:iterator>
		   		</table>
		   	</td>
		   	<td></td>
	  </tr>
	  </table>
	  </td>
	  <td width="50%" style="vertical-align: top;">
	  <table style="vertical-align: top;">
	  <tr>
	  	<td colspan="2">
	  		<table>
	  			<s:iterator value="fabrfclist" var="fabrfclist">
	  			<s:if test="%{#fabrfclist.heading3 != null && #fabrfclist.heading3 != ''}">
	  				<tr><td><u><b>${heading3}</b></u></td></tr>
	  				</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
			   		<s:iterator value="fabrfclist" var="fabrfclist">
			   		<s:if test="%{#fabrfclist.fab_rfc_sp4 != null && #fabrfclist.fab_rfc_sp4 != ''}">
			   			<tr>
				   			<td align="left" style="font-size: 13px;">${fab_rfc_sp4}</td>
				   			<td  align="left" style="font-size: 13px;">:${qty4}</td>
			   			</tr>
			   		</s:if>
			   		</s:iterator>
		   		</table>
		   	</td>
		   	<td ></td>
	  </tr>
	 </table>
	 </td>
	 </tr>
	 
</table>



<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:3%;"/>
</div>

</div>



<div id="pagelayout" style="height:100%;width:100%">
<img src="configure/img/7.png" width="100%" height="100px"/>

<table>

			<tbody>

	   <tr>
		   <td>
		   		<table style="margin-top:0px;">
		   		<s:iterator value="fablabelinglist" var="fablabelinglist">
			   			<s:if test="%{#fablabelinglist.fab_labeling_name != null && #fablabelinglist.fab_labeling_name != ''}">
			   				<tr><td style="color:#0080ff; font-size: 25px;"><u><b>${fab_labeling_name}</b></u></td></tr>
			   			</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table align="center">
		   			<tr>
			   			<td>
			   				<img align="middle" alt="" src="configure/img/labelingmc.png"  style="border : 1px solid black; padding :2px 2px;margin-top:0px; width:100%; height:250px;">
			   			</td>
		   			</tr>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<table style="margin-top:0px;">
	  			<s:iterator value="fablabelinglist" var="fablabelinglist">
	  				<s:if test="%{#fablabelinglist.fab_labeling_subname != null && #fablabelinglist.fab_labeling_subname != ''}">
	  				<tr><td><u><b>${fab_labeling_subname}</b></u></td></tr>
	  				</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="fablabelinglist" var="fablabelinglist">
			   				<s:if test="%{#fablabelinglist.specifi != null && #fablabelinglist.specifi != ''}">
					   			<tr>
						   			<td width=50% style="font-size: 13px;">${specifi}</td>
						   			<td width=50% style="font-size: 13px;">${qty}</td>
					   			</tr>
				   			</s:if>
		   		</s:iterator>
		   			
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<table style="margin-top: 0px;">
	  			<s:iterator value="fablabelinglist" var="fablabelinglist">
		  			<s:if test="%{#fablabelinglist.heading != null && #fablabelinglist.heading != ''}">
		  				<tr><td><u><b>${heading}</b></u></td></tr>
		  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
			   		<s:iterator value="fablabelinglist" var="fablabelinglist">
			   			<s:if test="%{#fablabelinglist.feature != null && #fablabelinglist.feature != ''}">
				   			<tr>
					   			<td width=18% style="font-size: 13px;">${feature}</td>
				   			</tr>
				   		</s:if>	
			   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr style="height:100%">
	  <td></td>
	  </tr>
	  
	  </tbody>

</table>




<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:20%;"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />

		<table>	
		<tbody>
	   <tr style="width:100%;">
		   <td>
		   		<table>
		   		<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
		   		<s:if test="%{#hotfabmoldingmc.name != null && #hotfabmoldingmc.name != ''}">
		   			<tr><td><u><b><font color="#0d96ec" style="color:#0080ff; font-size: 25px;">${name}</font></b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr align="center">
		   <td colspan="2">
		   		<table>
		   			<tr>
			   			<td>
			   				<img align="middle" alt="" src="configure/img/moldingmachine.png"  style="padding : 2px 2px; border: 1px solid black; width:100%; height:250px;">
			   			</td>
		   			</tr>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td style="border-right:1px solid black; width:50%; vertical-align: top;">
	  		<table style="vertical-align: top;">
	  			<tr>
	  				<td style="vertical-align: top;">
	  					<table style="vertical-align: top;">
	  			
	  						<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
	  							<s:if test="%{#hotfabmoldingmc.machine_details != null && #hotfabmoldingmc.machine_details != ''}">
	  								<tr style="font-size: 13px;"><td>${machine_details}</td></tr>
	  							</s:if>
	  						</s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  			
	  			<tr>
	  				<td>
	  					<table  style="margin-top: 0px;">
	  						<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
	  							<s:if test="%{#hotfabmoldingmc.subname != null && #hotfabmoldingmc.subname != ''}">
			  						<tr style="font-size: 13px;"><td>${subname}</td></tr>
			  						<tr style="font-size: 13px;"><td>${subheading1}</td></tr>
		  						</s:if>
	  						</s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  			
	  			<tr>
	  				<td>
	  					<table style="margin-top: 0px;">
	  						<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
	  						<s:if test="%{#hotfabmoldingmc.subname1 != null && #hotfabmoldingmc.subname1 != ''}">
	  						<tr><td><u><b>${subname1}</b></u></td></tr>
	  						</s:if>
	  						</s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  			<tr>
	  				<td>
	  					<table style="margin-top: 0px;">
	  						<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
	  						<s:if test="%{#hotfabmoldingmc.specification != null && #hotfabmoldingmc.specification != ''}">
	  						<tr style="font-size: 13px;">
	  						<td>${specification}</td>
	  						</tr>
	  						</s:if>
	  						</s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  		</table>
	  	</td>
	  	
	  	<td>
	  		<table>
	  		
			  		<tr>
					<td>
						<table>
							<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
							<s:if test="%{#hotfabmoldingmc.specificationsDetails !=null && #hotfabmoldingmc.specificationsDetails !=''}">
								<tr style="font-size: 15px;"><td>${specificationsDetails}</td></tr>
							</s:if>
						   </s:iterator>
						</table>
					</td>
			   </tr>
			   
			   <tr>
					<td>
						<table style="margin-top: 0px;">
							<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
							<s:if test="%{#hotfabmoldingmc.specification2 !=null && #hotfabmoldingmc.specification2 !=''}">
								<tr style="font-size: 15px;"><td>${specification2}</td>
								<td>${quantity21}</td></tr>
							</s:if>
						   </s:iterator>
						</table>
					</td>
				</tr>
	  		
	  		
	  			<tr>
	  				<td>
	  					<table style="margin-top:0px;">
	  						<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
	  						<s:if test="%{#hotfabmoldingmc.subheading2 != null && #hotfabmoldingmc.subheading2 != ''}">
	  							<tr style="font-size: 15px;"><td>${subheading2}</td></tr>
	  						</s:if>
	  						</s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  			
	  			<tr>
	  				<td>
	  					<table style="margin-top: 0px;">
		  					<s:iterator value="hotfabmoldingmc" var="hotfabmoldingmc">
			  					<s:if test="%{#hotfabmoldingmc.srno1 != null && #hotfabmoldingmc.srno1 !=''}">
			  						<tr style="font-size: 15px;">
			  						    <td>${srno1}</td>
			  							<td>${specification1}</td>
			  						</tr>
			  					</s:if>
		  				   </s:iterator>
	  					</table>
	  				</td>
	  			</tr>
	  		</table>
	  	</td>
	  </tr>
	 </tbody>
	</table>	
			
			

<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:110%"/>
</div>
</div>

<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />

		<table>	
					<tbody>
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.name_of_index !=null && #hpc.name_of_index !=''}">
		   			<tr><td><u><b><font color="#0d96ec" style="color:#0080ff; font-size: 25px;">${name_of_index}</font></b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  <tr align="center">
		   <td>
		   		<table>
		   			<tr>
			   			<td>
			   				<img align="middle" alt="" src="configure/img/hpc.png" width="100%" height="250px" style="border: 1px solid black; padding: 2px 2px;">
			   			</td>
		   			</tr>
		   		</table>
		   	</td>
	  </tr>
  
    <tr>
 	<td>
 	<table>
	   <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.machine_details !=null && #hpc.machine_details !=''}">
		   			<tr><td style="font-size: 13px;">${machine_details}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.subname1 !=null && #hpc.subname1 !=''}">
		   			<tr><td><u><b>${subname1}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.subname2 !=null && #hpc.subname2 !=''}">
		   			<tr style="font-size: 13px;"><td>${subname2}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.techname !=null && #hpc.techname !=''}">
		   			<tr style="font-size: 13px;"><td>${techname}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.specifi !=null && #hpc.specifi !=''}">
		   			<tr style="font-size: 13px;">
		   			<td>${specifi}</td>
		   			<td>${qty}</td>
		   			</tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.techDetails !=null && #hpc.techDetails !=''}">
		   			<tr style="font-size: 13px;">
		   			<td><b>${techDetails}</b></td>
		   			</tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	   <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.specifi2 !=null && #hpc.specifi2 !=''}">
		   			<tr style="font-size: 13px;"><td><b>${specifi2}</b></td></tr>
		   			<tr style="font-size: 13px;"><td>${qty2}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top: 0px;">
		   		<s:iterator value="hpc" var="hpc">
		   		<s:if test="%{#hpc.specifi3 !=null && #hpc.specifi3 !=''}">
		   			<tr style="font-size: 13px;"><td><b>${specifi3}</b></td></tr>
		   			<tr style="font-size: 13px;"><td>${qty3}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	</table>
	</td>
	</tr>
	</tbody>
					
		</table>

<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 80%;"/>
</div>
</div>

<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />

		<table >	
	   <tbody>
	   <tr>
		   <td style="padding-bottom: 0em;">
		   		<table>
		   		<s:iterator value="lpc">
		   			<tr><td style="padding-bottom: 0em;"><u><b><font color="#0d96ec" style="color:#0080ff; font-size: 20px;">${name_of_index}</font></b></u></td></tr>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table>
		   			<tr>
			   			<td>
			   				<img align="left" alt="" src="configure/img/lowPressureCompressure.png" width="100%" height="250px" style="border: 1px solid black;padding-right:5px;padding-top: 5px;padding-bottom: 5px;">
			   			</td>
		   			</tr>
		   		</table>
		   </td>
	  </tr>
	  
	  <tr>
	  <td>
	  <table>
	  
		  <tr>
			   <td>
			   		<table>
			   		<s:iterator value="lpc" var="lpc">
			   		<s:if test="%{#lpc.machine_details1 !=null && #lpc.machine_details1 !=''}">
			   			<tr style="font-size: 12px;"><td>${machine_details1}</td></tr>
			   		</s:if>
			   		</s:iterator>
			   		</table>
			   	</td>
		  </tr>
	  
	  <tr>
		   <td>
		   		<table >
		   		<s:iterator value="lpc" var="lpc">
		   		<s:if test="%{#lpc.machine_details2 !=null && #lpc.machine_details2 !=''}">
		   			<tr style="font-size: 12px;"><td><u><b>${machine_details2}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table>
		   		<s:iterator value="lpc" var="lpc">
		   		<s:if test="%{#lpc.tech_specifications !=null && #lpc.tech_specifications !=''}">
		   			<tr style="font-size: 12px;"><td><u><b>${tech_specifications}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  <tr>
		   <td>
		   		<table>
		   		<s:iterator value="lpc" var="lpc">
		   		<s:if test="%{#lpc.specifi !=null && #lpc.specifi !=''}">
		   			<tr style="font-size: 12px;"><td>${specifi}</td>
		   			<td>${qty}</td>
		   			</tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
			   <td>
			   		<table>
			   			<s:iterator value="lpcList" var="lpcList">
				   			<s:if test="%{#lpcList.scope_of_supply !=null && #lpcList.scope_of_supply !=''}">
					   			<tr style="font-size: 12px;"><td>${scope_of_supply}</td>
					   			</tr>
				   			</s:if>
			   			</s:iterator>
			   		</table>
			   	</td>
		  </tr>
	  
			  <tr>
			  	<td>
			  		<s:iterator value="lpcList" var="lpcList">
			  			<s:if test="%{#lpcList.specifi2 !=null && #lpcList.specifi2 !=''}">
				   			<tr style="font-size: 12px;">
				   			<td><b>${specifi2}</b></td>
				   			</tr>
				   			<tr style="font-size: 12px;"><td>${specifi3}</td>
				   			</tr>
				   		</s:if>
				   	</s:iterator>
			  	</td>
			  </tr>
	  
	  
	  
	  </table>
	  </td>
	  </tr>
	  <tr>
	  	<td>
	  		<table>
		  	
	  		</table>
	  	</td>
	  </tr>
	  </tbody>
				
		
		</table>

<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />

	<table>
			<tbody>
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="shrinkmodel" var="shrinkmodel">
		   		<s:if test="%{#shrinkmodel.shrink !=null && #shrinkmodel.shrink !=''}">
		   			<tr><td><u><b><font color="#0d96ec" style="color:#0080ff; font-size: 25px;">${shrink}</font></b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table>
		   			<tr>
			   			<td>
			   				<img align="left" alt="" src="configure/img/shrinkmachine.png" width="100%" height="250px" style="border:1px solid black; padding: 2px 2px;margin-top:0px;">
			   			</td>
		   			</tr>
		   		</table>
		   </td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top:0px;">
		   		<s:iterator value="shrinkmodel" var="shrinkmodel">
		   		<s:if test="%{#shrinkmodel.name !=null && #shrinkmodel.name !=''}">
		   			<tr><td><u><b>${name}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top:0px;">
		   		<s:iterator value="shrinkmodel" var="shrinkmodel">
		   		<s:if test="%{#shrinkmodel.parameterValue !=null && #shrinkmodel.parameterValue !=''}">
		   			<tr><td><u><b>${parameterValue}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<table style="margin-top:0px;">
	  			<s:iterator value="shrinkmodel" var="shrinkmodel">
	  			<s:if test="%{#shrinkmodel.specifi1 !=null && #shrinkmodel.specifi1 !=''}">
	  				<tr style="font-size: 13px;"><td>${specifi1}</td></tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <tr>
		   <td>
		   		<table style="margin-top:0px;">
		   		<s:iterator value="shrinkmodel" var="shrinkmodel">
		   		<s:if test="%{#shrinkmodel.specifi !=null && #shrinkmodel.specifi !=''}">
		   		<tr><td><u><b>${specifi}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<table style="margin-top:0px;">
	  			<s:iterator value="shrinkmodel" var="shrinkmodel">
	  			<s:if test="%{#shrinkmodel.features !=null && #shrinkmodel.features !=''}">
	  				<tr style="font-size: 13px;"><td>${features}</td></tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  </tbody>
	
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top:30%;"/>
</div>
</div>

<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />

<table>
		<tbody>
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="autocasepacker" var="autocasepacker">
		   		<s:if test="%{#autocasepacker.name_of_index !=null && #autocasepacker.name_of_index !=''}">
		   			<tr><td><u><b><font color="#0d96ec" style="color:#0080ff; font-size: 25px;">${name_of_index}</font></b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="autocasepacker" var="autocasepacker">
		   		<s:if test="%{#autocasepacker.subanme !=null && #autocasepacker.subanme !=''}">
		   			<tr><td><u><b>${subanme}</b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  <td>
	  <table style="margin-top:0px;">
	  <tr>
		   <td>
		   		<table>
		   		<s:iterator value="autocasepacker" var="autocasepacker">
				   		<s:if test="%{#autocasepacker.specifi !=null && #autocasepacker.specifi !=''}">
				   			<tr style="font-size: 13px;"><td><u><b>${specifi}</b></u></td>
				   			</tr>
				   			<tr style="font-size: 13px;"><td><td>${qty}</td></tr>
				   		</s:if>
		   			</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  </table>
	  </td>
	  </tr>
	  
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="autocasepacker" var="autocasepacker">
		   		<s:if test="%{#autocasepacker.note !=null && #autocasepacker.note !=''}">
		   			<tr style="font-size: 13px;"><td>${note}</td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  </tbody>
		
</table>
<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 70%;"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
	<tbody>
   	<tr>
	   	<td>
	   		<table>
	   		<s:iterator value="labchembio" var="labchembio">
	   		<s:if test="%{#labchembio.name_of_index !=null && #labchembio.name_of_index !=''}">
	   			<tr><td><u><b><font color="#0d96ec">${name_of_index}</font></b></u></td></tr>
	   			<tr><td><u><b><font color="#0d96ec">${subname1}</font></b></u></td></tr>
	   		</s:if>
	   		</s:iterator>
	   		</table>
	   	</td>
   	</tr>
   	
	  <tr>
	  <td>
		<table style="margin-top: 0px;" width="100%;" class="striped_tab">
			<tr>
				<th align="left">Sr. No.</th><%int ctn=1; %>
				<th align="left">Particulars</th>
				<th align="center">Qty</th>
			</tr>
			<s:iterator value="labchembio" var="labchembio">
			<s:if test="%{#labchembio.parti !=null && #labchembio.parti !=''}">
			<tr>
				<td><%=ctn++ %></td>
				<td>${parti}</td>
				<td align="center" width="10%">${quantity}</td>
			</tr>
			</s:if>
			</s:iterator>
			<%ctn=1; %>
		</table>
		</td>
	  </tr>
	  </tbody>
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 10%;"/>
</div>
</div>




<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
			<tbody>
	  <tr><td>
	      <table><s:iterator value="labchembio" var="labchembio">
	      			<s:if test="%{#labchembio.subname2 !=null && #labchembio.subname2 !=''}">
		   				<tr><td><u><b><font color="#0d96ec">${subname2}</font></b></u></td></tr>
		   			</s:if>
		   		</s:iterator></table>
	  </td></tr>
	 
	  <tr>
	  <td width="100%">
		<table  width="100%;" cellspacing="0" class="striped_tab">
			<tr>
				<th align="left">Sr. No.</th>
				<th align="left">Particulars</th>
				<th align="center">Qty</th>
			</tr>
			<s:iterator value="labchemglass" var="labchemglass">
			<s:if test="%{#labchemglass.parti1 !=null && #labchemglass.parti1 !=''}">
			<tr>
				<td><%=ctn++ %></td>
				<td>${parti1}</td>
				<td align="center" width="10%">${quantity1}</td>
			</tr>
			</s:if>
			</s:iterator>
			<%ctn=1; %>
		</table>
		</td>
	  </tr>
	  </tbody>
	
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 70%;"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
	
	<tbody>
	 <tr>
		   <td>
		   		<table>
		   		<s:iterator value="labchembio" var="labchembio">
			   		<s:if test="%{#labchembio.subname3 !=null && #labchembio.subname3 !=''}">
			   			<tr><td><u><b><font color="#0d96ec">${subname3}</font></b></u></td></tr>
			   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	 
	  <tr>
	  	<td>
	  		<table width="100%;" class="striped_tab">
	  			<tr>
	  				<th align="left">Sr. No.</th>
	  				<th align="left">Particulars</th>
	  				<th align="center">Qty</th>
	  			</tr>
	  			<s:iterator value="labchemchem" var="labchemchem">
	  			<s:if test="%{#labchemchem.parti2 !=null && #labchemchem.parti2 !=''}">
	  			<tr>
	  				<td><%=ctn++ %></td>
	  				<td>${parti2}</td>
	  				<td width="10%" align="center">${quantity2}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  			<%ctn=1; %>
	  		</table>
	  	</td>
	  </tr>
	  </tbody>
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 50%;"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
	
			<tbody>
	 
	 <tr>
		   <td>
		   		<table>
		   		<s:iterator value="labchembio" var="labchembio">
		   		<s:if test="%{#labchembio.subname4 !=null && #labchembio.subname4 !=''}">
		   			<tr><td><u><b><font color="#0d96ec">${subname4}</font></b></u></td></tr>
		   			</s:if>
		   			</s:iterator>
		   		</table>
		   	</td>
	  </tr>
	  
	  <tr>
	  	<td>
	  		<table width="100%;" class="striped_tab">
	  			<tr>
	  				<th align="left">Sr. No.</th>
	  				<th align="left">Particulars</th>
	  				<th align="center">Qty</th>
	  			</tr>
	  			<s:iterator value="labchemchem3" var="labchemchem3">
	  			<s:if test="%{#labchemchem3.parti3 !=null && #labchemchem3.parti3 !=''}">
	  			<tr>
	  				<td><%=ctn++ %></td>
	  				<td>${parti3}</td>
	  				<td width="10%" align="center">${quantity3}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  			<%ctn=1; %>
	  		</table>
	  	</td>
	  </tr>
	  
	  </tbody> 
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 42%;"/>
</div>
</div>




<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
			<tbody>
	   <tr>
		   <td>
		   		<table>
		   		<s:iterator value="labchembio" var="labchembio">
		   		<s:if test="%{#labchembio.subname5 !=null && #labchembio.subname5 !=''}">
		   			<tr><td><u><b><font color="#0d96ec">${subname5}</font></b></u></td></tr>
		   		</s:if>
		   		</s:iterator>
		   		</table>
		   	</td>
	  </tr>
  <tr>
	  	<td>
	  		<table width="100%;" class="striped_tab">
	  			<tr>
	  				<th align="left">Sr. No.</th>
	  				<th align="left">Particulars</th>
	  				<th align="center">Qty</th>
	  			</tr>
	  			<s:iterator value="labchemchem4" var="labchemchem4">
	  			<s:if test="%{#labchemchem4.parti4 !=null && #labchemchem4.parti4 !=''}">
	  			<tr>
	  				<td><%=ctn++ %></td>
	  				<td>${parti4}</td>
	  				<td width="10%" align="center">${quantity4}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  			<%ctn=1; %>
	  		</table>
	  	</td>
	  </tr>
	  </tbody>
			
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 1%;"/>
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
			<tbody>
<tr>
   <td>
   		<table>
   		<s:iterator value="investmentAndExp" var="investmentAndExp">
   		<s:if test="%{#investmentAndExp.name != null && #investmentAndExp.name != ''}">
   			<tr><td><u><b><font color="#0d96ec">${name}</font></b></u></td></tr>
   			<tr><td><u><b><font color="#0d96ec">${subname}</font></b></u></td></tr>
   		</s:if>
   			</s:iterator>
   		</table>
   	</td>
</tr>
<tr>
	  	<td>
	  		<table width="100%;" class="striped_tab" style="margin-top: 0px;">
	  			<tr>
	  				<th>SrNo</th>
	  				<th>Particulars</th>
	  				<th>Expenses</th>
	  				<th>GST Percentage</th>
	  				<th>GST Amount</th>
	  				<th>Total</th>
	  			</tr>
	  			<s:iterator value="investmentAndExp">
	  			<tr>
	  				<%-- <td>${invest_exp_id}</td> --%>
	  				<td><%=ctn++ %></td>
	  				<td>${parti}</td>
	  				<td>${exp}</td>
	  				<td>${gstP}</td>
	  				<td>${gstAmt}</td>
	  				<td>${tot}</td>
	  			</tr>
	  			</s:iterator>
	  		</table>
	  	</td>
 </tr>
 
 <tr>
 <td>
 <table><b>Total</b>
	 <s:iterator value="investmentAndExp" var="investmentAndExp">
	 		<s:if test="%{#investmentAndExp.tot1 != null && #investmentAndExp.tot1 != ''}">
 			<tr>
 					<td width="90%;"></td>	
	  				<td  align="left">${tot1}</td>
	  				<td></td>
	  				<td width="50%;" align="center">${tot2}</td>
	  				<td align="right">${tot3}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  			</table>
	  			</td>
	  			</tr>
<tr>
<td>
 <table style="margin-top: 0px;">
	 <s:iterator value="investmentAndExp" var="investmentAndExp">
	 <s:if test="%{#investmentAndExp.heading3 != null && #investmentAndExp.heading3 != ''}">
 			<tr>
 					<td width="50%;"></td>	
	  				<td  align="center">${heading3}</td>
	  				<td></td>
	  				<td align="right">${heading4}</td>
	  				<td></td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  			</table>
	  			</td>
	  			</tr>
	  			</tbody>
			
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 110%;"/>
</div>
</div>





<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table width="100%">
			<tbody>
<tr>
   <td>
   		<table>
   		<s:iterator value="termsConditions11" var="termsConditions11">
   		<s:if test="%{#termsConditions11.name_of_index != null && #termsConditions11.name_of_index != ''}">
   			<tr><td><u><b><font color="#0d96ec">${name_of_index}</font></b></u></td></tr>
   			</s:if>
   			</s:iterator>
   		</table>
   	</td>
</tr>

<tr>
	  	<td>
	  		<table width="100%;">
	  			<s:iterator value="termsConditions11" var="termsConditions11">
	  			<s:if test="%{#termsConditions11.specifi != null && #termsConditions11.specifi != ''}">
	  			<tr><td><u><b>${specifi}</b></u></td></tr>
	  			<tr style="font-size: 13px;"><td>${qty}</td></tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  
	  <s:iterator value="termsConditions11" var="termsConditions11">
	  	 <s:if test="%{#termsConditions11.sub_name_of_index != null && #termsConditions11.sub_name_of_index != ''}">
	 	 <tr><td><u><b>${sub_name_of_index}</b></u></td></tr>
	 	 </s:if>
	  </s:iterator>
	  
	  <tr>
	  	<td>
	  		<table width="100%;">
	  			<s:iterator value="termsConditions11" var="termsConditions11">
	  			<s:if test="%{#termsConditions11.specifi1 != null && #termsConditions11.specifi1 != ''}">
	  			<tr style="font-size: 13px;">
	  				<td>${specifi1}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
</tbody>
			
			
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 10%;"/>
</div>
</div>




<%-- <div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table>
	
			<tbody>
<tr>
   <td>
   		<table style="margin-top: 0px;">
   		<s:iterator value="pwpc" var="pwpc">
   		<s:if test="%{#pwpc.name_of_index != null && #pwpc.name_of_index != ''}">
   			<tr><td><u><b>${name_of_index}</b></u></td></tr><br>
   			<tr><td><u><b>${heading1}</b></u></td></tr>
   		</s:if>
   		</s:iterator>
   		</table>
   	</td>
</tr>

	  <tr>
	  	<td>
	  		<table width="100%;" style="margin-top: 0px;" class="striped_tab">
	  			<tr>
	  				<th align="left">Particulars</th>
	  				<th align="left">Qty</th>
	  			</tr>
	  			<s:iterator value="pwpc" var="pwpc">
	  			<s:if test="%{#pwpc.parti != null && #pwpc.parti != ''}">
	  			<tr>
	  				<td>${parti}</td>
	  				<td>${ltr}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  <tr>
   <td>
   		<table style="margin-top: 0px;">
   		<s:iterator value="pwpc" var="pwpc">
   		<s:if test="%{#pwpc.heading2 != null && #pwpc.heading2 != ''}">
   			<tr><td><u><b>${heading2}</b></u></td></tr><br>
   		</s:if>
   			</s:iterator>
   		</table>
   	</td>
</tr>
	  <tr>
	  	<td>
	  		<table width="100%;" class="striped_tab">
	  			<tr>
	  				<th align="left">Particulars</th>
	  				<th align="left">Qty</th>
	  			</tr>
	  			<s:iterator value="pwpc" var="pwpc">
	  			<s:if test="%{#pwpc.req != null && #pwpc.req != ''}">
	  			<tr>
	  				<td>${req}</td>
	  				<td>${qty}</td>
	  			</tr>
	  			</s:if>
	  			</s:iterator>
	  		</table>
	  	</td>
	  </tr>
	  </tbody>
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 10%;"/>
	
</div>
</div>


<div id="pagelayout" style="height:100%; width:100%">
<img src="configure/img/7.png" width="100%" height="100px" />


	<table>
	
			<tbody>
<tr>
   <td>
   		<table>
   		<s:iterator value="flowcharts" var="flowcharts">
	   		<s:if test="%{#flowcharts.name_of_index != null && #flowcharts.name_of_index != ''}">
	   			<tr><td><u><b>${name_of_index}</b></u></td></tr>
	   		</s:if>
   		</s:iterator>
   		</table>
   	</td>
</tr>

<tr>
   <td>
   		<table>
   		
   			<tr><s:iterator value="flowcharts" var="flowcharts">
   			<s:if test="%{#flowcharts.image != null && #flowcharts.image != ''}">
   			<td>
   			<img alt="" src="configure/img/${image}">
   			</td>
   			</s:if>
   			</s:iterator>
   			</tr>
   			
   		</table>
   	</td>
</tr>
</tbody>
	</table>


<div id="footer" style="border-bottom:1px solid black;">
	<img src="configure/img/footer.png" width="100%" height="50px" style="margin-top: 10%;"/>
</div>
</div>
 --%>


</body>
</html>