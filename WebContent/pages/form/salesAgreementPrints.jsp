<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UltraCare Group</title>
<script type="text/javascript">
	 function printData()
	 {
		
	    var divToPrint=document.getElementById("printsSalesAgreement");
	    newWin= window.open("");
	    newWin.document.write(divToPrint.outerHTML);
	    newWin.print();
	    newWin.close();
	 }
	 
	 function goHome(){
		 location.href="Agreementt_reports";
	 }
	 
</script>
<style>
#id {
    border-collapse: collapse;
}

#id {
    border: 1px solid black;
}
</style>
</head>
<body>
<div>
<input type="button" name="Print"
id="Print" value="Print" class="NFButton" onclick="printData('printsQuotation')">
<input type="button" name="Home"
id="Home" value="Home" class="NFButton" onclick="goHome()">
</div>
<div id="printsSalesAgreement">
<table style="width:100%;border-collapse:collapse;page-break-inside: auto;page-break-after: always;"">
	<tr>
		<td>
			<table>
				<tr align="center"><td><s:iterator value="agreement_report"><b>AGREEMENT FOR ${agreement_subject}</b></s:iterator></td></tr>
				<tr align="center"><td>This agreement made on 7th day of April month of year 2018</td></tr>
			
				<tr align="center"><td>BETWEEN</td></tr>
			
				<tr><td><p><s:iterator value="agreement_report"><b>${name}</b> having firm <b>${fim_name}</b> registration no.<b>${reg_no}</b> and having its corporate office at <b>${office_address}</</b>,<b>${city}</b>-<b>${pincode}</b>  being represented by its authorized signatory,<b>${authorized_signatory}</b></s:iterator> (hereinafter called “the firm”, which expression shall, unless excluded by or repugnant to the context or meaning thereof, include its successors-in-title and permitted assigns) of the First Part;</p></td></tr>
 			</table>
 		</td>
 	</tr>
<tr>
<td><p>1. &nbsp;M/s. ULTRACARE SERVICES a company within the meaning of the Companies Act, 1956/ Companies Act, 2013 with corporate identity number U41000PN2014PTC152164 and having its registered office at B-219&220, B WINGS, JAI GANESH VISION AKURDI PUNE Pune MH 411035 (hereinafter called “the firm”, which expression shall, unless excluded by or repugnant to the context or meaning thereof, include its successors-in-title and permitted assigns) of the Second Part;</p></td>
</tr>

<tr><td><p>Whereas the party of First Part has decided to establish packaged drinking water plant at location Bhamboli and has approached to party of Second Part to provide with the offer for the supply and installation of entire packaged drinking water project machinery.</p></td></tr>
<tr><td><p></p>Whereas the party of Second Part possess expertise in the business of supply and installation of package drinking water machinery and is into the said business since 2006 has given quotation for completion of required project to the party at First Part vide quotation no. <s:iterator value="agreement_report"><b>${quotation_no}</b> dated <b>${order_no}</b></s:iterator>. The full description of said quotation is annexed to this agreement as ‘Annexure I’.</td></tr>
<tr><td><p>Whereas the party at First Part in pursuance of quotation placed by party at Second part as mentioned above has agreed to the terms of said quotation and placed an order for the purchase and installation of said package drinking water project vide quotation no. <s:iterator value="agreement_report"><b>${quotation_no}</b> dated <b>${date_of_quotation}</b> and Purchase Order no.<b>${order_no}</b></s:iterator> and party at Second Part has agreed to supply machinery and execute the installation as per said quotation at the above address of party at First Part.</p></td></tr>
<tr><td><p><u><b>NOW THEREFORE IT IS AGREED TO BETWEEN THE PARTIES AS FOLLOWS:</b></u></p></td></tr>

<tr><td><p><u><b style="margin-left: 30px;">1.&nbsp;Purpose of Agreement: </b></u></p></td></tr>

<tr><td>The purpose of agreement is that on requirement of Party of First part for procurement and installation of packaged drinking water project, the party at second part will supply and install the same at the place of part at first part at  Gat No. 51, At Post – Bhamboli,Tal : Khed, Dist : Pune, 412105.</td></tr>

<tr><td><p><u><b style="margin-left: 30px;">2.&nbsp;Project Cost:</b></u> </p></td></tr>
<tr><td><p style="margin-left: 70px;">1.Both the parties have mutually agreed that the consideration cost to be paid by party at first part to party at second part will be Rs.<s:iterator value="agreement_report"><b>${second_part_payment}</b></s:iterator>/- which will include the price of designing, engineering, supply and installation of package drinking water project machinery including consumables at the place of party at first part. Taxes & Transportation excluded from the cost.</p></td></tr>

<tr><td><p style="margin-left: 70px;">2.In consideration of fixed price Party No. 1 given advance payment of Rs.       - (          ) received through Cheque on             (“                 ”) &              remaining 50% of Project cost will be paid within 15 days other payment will be done time to time as demand from party no.2. </p></td></tr>
<tr><td><p style="margin-left: 70px;">3.The schedule of payment shall be as such decided by both the parties mutually.</p></td></tr>
<tr><td><p style="margin-left: 70px;">4.In case of the delay in payment by the Party at First Part as per payment schedule mutually decided, the Party at Second Part shall have all the rights to levy the interest, at the rate as may be charged at that particular time by the banks on lending, on the amount due by the Party at First Part or to charge such amount of penalty as may be deemed appropriate or to suspend the execution of order placed by the Party at First part till the dues are settled by the Party at First part.</p></td></tr>
<tr><td><p><u><b style="margin-left: 30px;">3.&nbsp;Scope of both the parties: </b></u></p></td></tr>
<tr><td><p style="margin-left: 70px;">1.The Party at First part can prescribe technical specifications, if any, required by it in the procurement and installation of plant & machinery with respect to the packaged drinking water project.</p></td></tr>
<tr><td><p style="margin-left: 70px;">2.The Party at First Part can take trial of plant & machinery required to be installed at its place, at the factory of Party at Second Part</p></td></tr>

<tr><td><p><u><b style="margin-left: 30px;">4.&nbsp;Project Implementation Schedule & responsibilities of parties: </</b></</u></p></td></tr>
<tr><td><p style="margin-left: 70px;">a.The Break-up of the project completion activities and relative time and party’s responsibility for each of them is shown below:</p></td></tr>

<tr>
<td>
<table border="1 px solid black" style="width:100%; page-break-inside: auto;">
	<tr>
		<th align="left"><b>Nature of Activity</b></th>
		<th align="center"><b>Partys responsibility</b></th>
	</tr>
	
	<tr>
	<td>1.Preparation of Project</td>
	<td>Party at Second Part</td>
	</tr>
	
	<tr>
	<td>2.SSI Registration</td>
	<td>Party at First Part</td>
	</tr>
	
	<tr>
	<td>3.BIS Registration:
	<tr><td>a.Submission of required documents required for BIS registration and arrangement<br> for inspection visit of BIS authority</td><td>Party at Second Part</td></tr>
	<tr><td>b.Approaching BIS department and submission of additional documents & information<br> as may be required for registration </td><td>Party at First Part</td></tr>
	</td>
	</tr>
	
	<tr>
	<td>4.	Sanction of Bank Loan</td>
	<td>Party at First Part</td>
	</tr>
	
	<tr>
	<td>5.	Clearance from Pollution Control Board and taking permission from Municipal Health Authorities/ BIS etc.</td>
	<td>Party at First Part</td>
	</tr>
	
	<tr>
	<td>6.	Supply and Installation of plant & machinery and appointment of its technical staff</td>
	<td>Party at Second Part</td>
	</tr>
	
	<tr>
	<td>7.	Power connection arrangement from Electricity Board</td>
	<td>Party at First Part</td>
	</tr>
	
	<tr>
	<td>8.	Appointment of operating Staff etc.</td>
	<td>Party at First Part</td>
	</tr>
	
	<tr>
	<td>9.	Training the staff of Party at First Part regarding operations of plant and machinery, delivering the manual and other guidance literature; trial run/ demonstration</td>
	<td>Party at Second part</td>
	</tr>
	
	<tr>
	<td>10.	Commencement of Production and operation of plant; marketing of its product and registration of trademark</td>
	<td>Party of First part</td>
	</tr>
	
	<tr>
	<td>11.	Warranty of: 
	<tr><td>a.	Entire plant & machinery post installation includes 2 free service<br> visits for one year.</td><td>Party at Second Part</td></tr>
	<tr><td>b.	Consumables servicing on repair or replacement basis shall be chargeable<br> on post installation </td></tr>
	</td>
	</tr>
	
	<tr>
	<td>12.	Quality Control & Standard of product as per BIS specifications</td>
	<td>Party at First Part</td>
	</tr>
</table>
</td>
</tr>

<tr><td><u><b style="margin-left: 30px;">b.&nbsp;Other responsibilities of party at first & second part:</b></u></td></tr>
<tr><td><p style="margin-left: 70px;">1.Party at First Part will complete construction as BIS Standard before erection of machinery</p></td></tr>
<tr><td><p style="margin-left: 70px;">2.Party at First Part will make arrangement of raw water connection, electrical connection, manpower, loading and unloading of materials to and from its installation location and boarding, to & fro transportation of technical staff of Part at Second Part required for installation of plant & machinery and erection of project.</p></td></tr>
<tr><td><p style="margin-left: 70px;">3.All kinds of freight, transportation, insurance charges and government taxes shall be borne by the party at first part. The Party at First part shall be responsible for any kind of damages or loss to plant & machinery during the transit process.</p></td></tr>
<tr><td><p style="margin-left: 70px;">4.Party at Second Part shall not be responsible for delay caused in the competition of project due to failure in fulfilling of commitment or providing of services in due time by local agencies and contractors like civil contractors, Electricity Board, Government Authorities granting required approvals, Plumbing Contractor etc</p></td></tr>
<tr><td><p style="margin-left: 70px;">5.The party at Second Part shall be not responsible for objection raised, if any, by BIS authority on the operation and/or product of the project, post registration, due to wrong practice followed by the party at First Part.   Part at First Part shall be responsible for any objections raised by the BIS authority on the packaged water bottle design or its label design and will be required to provide all required documents, information and explanations as may be demanded by the BIS department or its authority and to ensure compliance of all its norms post registration of the project.</p></td></tr>
<tr><td><p style="margin-left: 70px;">6.The layouts, designs, drawings & engineering of the said project shall stand property of Party at First Part on completion of project from the Party at Second Part subject to all dues relating to said project are paid as per payment schedule by Party at First Party to Party at Second Part.</p></td></tr>
<tr><td><p style="margin-left: 70px;">7.All commercial terms and conditions of quotation dated <b>${date_of_quotation}</b> no. <b>${quotation_no}</b>and this agreement shall stand binding on both the parties with effect from the date of execution of this agreement.</p></td></tr>

<tr><td><u><b style="margin-left: 30px;">5.&nbsp;Force Majeure:</b></u><br><p style="margin-left: 50px;">Without prejudice and without antecedent liability, neither party shall be responsible for non-performance or non-fulfillment of any nor all their obligations under this agreement of such non-performance or non-fulfillment are due to ‘Force Majeure’.</p></td></tr>
<tr><td><u><b style="margin-left: 30px;">6.&nbsp;Performance Guarantee: </b></u><p style="margin-left: 50px;">The failure of any party to enforce at any time any of the provisions of this agreement shall in no way be construed to be a waiver of such provision, nor in any way to affect the validity of this agreement or any part thereof. Should elements of this agreement be discovered to be ineffective, or contain omissions all remaining clauses of the agreement shall continue to be effective. With regard to the ineffective or missing elements, the PARTIES shall agree upon a correction to these elements which corresponds to the spirit of this agreement as well as its economic purpose and sense, which in any case the PARTIES would have agreed upon, if the ineffective or missing elements would have been discovered before the signature of this agreement.</p></td></tr>


<tr><td><p style="margin-left: 50px;">No PARTY shall assign or in any way transfer its rights or obligations arising out of the present MOU without obtaining the prior written consent of the other PARTY hereto. 
All notices to be given under this MOU shall be in writing and shall be deemed to have been properly given upon dispatch by registered  or certified mail or telefax to the PARTY’s address as set forth below or to such other address as the PARTY may  subsequently designate; <br>
<br>
ULTRACARE SERVICES,<br>
REGISTERED OFFICE ADDRESS: B-219&220, B WINGS, JAI GANESH VISION<br> AKURDI PUNE Pune MH 411035
TELEPHONE: 02046748997 TELEFAX</p>
</td></tr>

<tr>
<td><u><b style="margin-left: 30px;">6.ARBITRATION:</b></u><br><p style="margin-left: 50px;">Any dispute or question that may arise between the parties as to the meaning and or interpretation of any matter pertaining to or arising out of this agreement shall be settled according to Indian Arbitration and Conciliation Act 1996.</p></td>
</tr>

<tr><td><p style="margin-left: 10px;">The following Annexes form integral parts of this agreement:</p></td></tr>
<tr><td><p style="margin-left: 50px;">1.&nbsp;Quotation dated <b>${date_of_quotation}</b> no <b>${quotation_no}</b>BIS registration documents checklist</p></td></tr>
<tr><td><p style="margin-left: 50px;">2.&nbsp;Terms and conditions of Warranty offered</p></td></tr>

<tr><td><p style="margin-left: 10px;">IN WITNESS WHEREOF the parties have put their respective hands the day and year first<br></b> hereinabove written</p></td></tr>
<tr><td><p style="margin-left: 10px;">Sign and delivered by</p></td></tr>
<tr><td><p style="margin-left: 10px;">Gorakh Kature</p></td></tr>
<tr><td><p style="margin-left: 10px;">Director (Din: 06686087)</p></td></tr>
<br>
<tr><td><p style="margin-left: 10px;">For and behalf of </p></td></tr>
<tr><td><p style="margin-left: 10px;">M/s. <s:iterator value="agreement_report">${firm_name}</s:iterator></p></td></tr>

<tr><td><p style="margin-left: 10px;"><s:iterator value="agreement_report">${authorized_signatory}</s:iterator></p></td></tr>

<tr><td><p style="margin-left: 10px;">(Party of First Part)</p></td></tr>

</br></br>
<tr><td><p style="margin-left: 10px;">________________</p></td></tr>
<tr><td><p style="margin-left: 10px;">(Partner/ Director/ Authorized Representative)</p></td></tr>

<tr><td><p style="margin-left: 10px;">Witness:</p></td></tr>
<tr><td><table>
<tr><td><p>1.</p></td></tr>
<tr><td>MR. VIJAY GUND</td></tr>
<tr><td>For and on behalf of </td><tr>
<tr><td><b>ULTRACARE SERVICES</</b></u></td></tr>
<tr><td>(Ultracare Group of Companies)</td></tr>
<tr><td>(Party at Second Part)</td></tr>
</table>
</td>
<td>
</td>
</tr>
</table>

</div>
</body>
</html>