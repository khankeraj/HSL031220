<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<script src="Css/jquery-1.10.2.js"></script>
<script src="Css/jquery-ui.js"></script>
<%String extracolumn="";
String manualauto="";
String partlabour="";
String withstock="";
String col1="";
String col2="";
String col3="";
String discount="";
String perunit="";
 try
{
	 DBConnection conn=new DBConnection();
	Connection connection = conn.getConnection();
	
	PreparedStatement preparedStatement112 = connection
	.prepareStatement("select * from settings ");
	//System.out.println("preparedStatement112"+preparedStatement112);
ResultSet resultSet12 = preparedStatement112.executeQuery();


if (resultSet12.next()) {


	extracolumn = resultSet12.getString("extracolumn") ;
	manualauto = resultSet12.getString("manualauto") ;
	partlabour = resultSet12.getString("partlabour") ;
	withstock = resultSet12.getString("withstock") ;
	 
	col1 = resultSet12.getString("col1") ;
	col2 = resultSet12.getString("col2") ;
	col3 = resultSet12.getString("col3") ;
	discount= resultSet12.getString("discount") ;
	perunit= resultSet12.getString("perunit") ;
}
	
}
catch(Exception e)
{
e.printStackTrace();
}

%>

	<s:push value="ib">
		
<div
																style="width: 1200px; height: auto;  border: 1px solid black;"
																id="main">

<table class="general-table" style="width:">
		
							
								<% int sr_No=1; %>
								<s:iterator value="(sparesize).{# this}" status="stat">
									<tr id="sparesize${top}" class="item-row"  >
									<td style="width:30px;" ><a id="deleteRow"><img style="width:30px;" src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>
									
									
										<% if(partlabour.equals("yes")) {%>
																		<td><select name="ib.btype" id="btype"
																			onblur="gotoparts(v);" onchange="selectchange(this);"
																			align="center" style="width: 70px;" tabindex="8">

																				<option value="parts">PARTS</option>

																				<option value="labour">LABOUR</option>
																		</select></td>
																		<% }else{ %>
																		<input type="hidden" value="parts"  name="ib.btype" id="btype"	/>
																		<%} %>
																		
																		
																		<% if(extracolumn.equals("0")) {%>
																		<input type="hidden" name="ib.partno"
																			style="width: 80px;" id="partno" value="<s:property value="partno2[top]"/>"
																			tabindex="10"  />
																			<input type="hidden" name="ib.partdate"
																			style="width: 80px;" id="partdate" value="<s:property value="partdate2[top]"/>"
																			tabindex="10"  />
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value="<s:property value="partnox2[top]"/>"
																			tabindex="10"  />
																		<%  } %>

																		
																		<% if(extracolumn.equals("1")) {%>
																		<td><input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value="<s:property value="partno2[top]"/>"
																			tabindex="10"  /></td>
																			<input type="hidden" name="ib.partdate"
																			style="width: 80px;" id="partdate" value="<s:property value="partdate2[top]"/>"
																			tabindex="10"  />
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value="<s:property value="partnox2[top]"/>"
																			tabindex="10"  />
																		<%  }%>
																		<% if(extracolumn.equals("2")) {%>
																	<td>	<input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value="<s:property value="partno2[top]"/>"
																			tabindex="10"  /></td>
																	<td>	<input type="text" name="ib.partdate"
																			style="width: 80px;" id="partdate" value="<s:property value="partdate2[top]"/>"
																			tabindex="10"  /></td>
																			<input type="hidden" name="ib.partnox"
																			style="width: 80px;" id="ib.partnox" value="<s:property value="partnox2[top]"/>"
																			tabindex="10"  />
																		</th>
																		<%  }%>
																		<% if(extracolumn.equals("3")) {%>
																		<td><input type="text" name="ib.partno"
																			style="width: 80px;" id="partno" value="<s:property value="partno2[top]"/>"
																			tabindex="10"  /></td>
																		<td><input type="text" name="ib.partdate"
																			style="width: 80px;" id="partdate" value="<s:property value="partdate2[top]"/>"
																			tabindex="10"  /></td>
																		<td><input type="text" name="ib.partnox"
																			style="width: 80px;" id="partnox" value="<s:property value="partnox2[top]"/>"
																			tabindex="10"  /></td>
																		</th>
																		<%  }%>			
								
									<td><input type="text" name="ib.description1" style="width:250px;" readonly
																	value="<s:property value="descrip1[top]"/>" id="description1" /></td>
																	
										<td><input type="text" name="ib.quantity1" style="width:60px;" readonly
																	id="quantity1" value="<s:property value="qty1[top]"/>" 
																	/></td>
																	
																		<% if(perunit.equals("yes")) {%>
																			<td><input type="text" name="ib.perunit"
																			style="width: 60px;" id="perunit" 
																			tabindex="11"   value="<s:property value="peruntqty2[top]"/>"   /></td>
																			<%} else{%>
																			<input type="hidden" name="ib.perunit"
																			style="width: 60px;" id="perunit" value=""
																			tabindex="11"  value=""   />
																			<% } %>
																	
																	
																	
															<td><input type="text" name="ib.myrate" style="width:60px;" readonly
																	id="myrate" value="<s:property value="myrate2[top]"/>" 
																	/></td>		
																	
																	
																	
																	<td><input type="text" name="ib.amount1"
																	id="amount1" value="<s:property value="amt112[top]"/>"
																	  style="width:60px;" readonly/>
																</td>	
																
																<% if(discount.equals("yes")) {%>
													<td><input type="text" name="ib.disc"
																			id="disc"  tabindex="12"
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 60px;"  value="<s:property value="disc2[top]"/>"  />
																		</td>
																		<td><input type="text" name="ib.amtwithdisc" readonly tabindex="12"
																			id="amtwithdisc" onblur="twodecimal(this)"  value="<s:property value="amtwithdisc2[top]"/>"  
																			 
																			style="width: 60px;" />
																		</td>
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)"  value="<s:property value="discamt2[top]"/>" 
																			 
																			style="width: 60px;" />
																		
												
												<%  }else{%>
													<input type="hidden" name="ib.disc"
																			id="disc" value="<s:property value="disc2[top]"/>"   tabindex="12"
																			onblur="getnewsrno1xxx(this);twodecimal(this);gotoadd1();" 
																			style="width: 60px;" />
																			<input type="hidden" name="ib.amtwithdisc" tabindex="12"
																			id="amtwithdisc" onblur="twodecimal(this)" value="<s:property value="amtwithdisc2[top]"/>"  
																			 
																			style="width: 60px;" />
																	
																		<input type="hidden" name="ib.discamt" tabindex="12"
																			id="discamt" onblur="twodecimal(this)" value="<s:property value="discamt2[top]"/>"
																			 
																			style="width: 60px;" />
																		
												
												<% } %>
																<td><input type="text" readonly
																	value="<s:property value="type_name1[top]"/>" name="ib.ttype"
																	id="ttype"  style="width:60px;">
																</td>
																<input type="hidden" name="ib.vat1" id="vat1" readonly value="<s:property value="vat_percent1[top]"/>" style="width:60px;" >
																		<td><input name="ib.grate1" id="grate1" value="<s:property value="rate1[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																		<td><input name="ib.gstamount1" id="gstamount1" value="<s:property value="gstamt1[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																		<td><input name="ib.grate2" id="grate2" value="<s:property value="rate2[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																		<td><input name="ib.gstamount2" id="gstamount2" value="<s:property value="gstamt2[top]"/>"
																			style="width: 60px;" readonly>
																		</td>
																<input type="hidden" name="ib.taxqmount1" id="taxqmount1" readonly
																	value="<s:property value="tax_amt_percent1[top]"/>" style="width:60px;"></td>

																<td><input name="ib.vatamount1" id="vatamount1"
																	value="<s:property value="net_amt1[top]"/>" style="width:60px;" onblur="getnewsrno44(this);">
																	
																					
																	

									

									</tr>


									<%sr_No++; %>
								
								</s:iterator>


			</table>	

</div>

</s:push>

	<script type="text/javascript">
	//Remove row when clicked
	$("#deleteRow").live('click', function() {
		$(this).parents('.item-row').remove();
		// Hide delete Icon if we only have one row in the list.
		if ($(".item-row").length < 2)
			$("#deleteRow").hide();
	});
</script>
