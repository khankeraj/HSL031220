
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="com.aqua.dao.DaoHelper,java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>VEERAT ENTERPRISES</title>
<%-- 
 	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=latin" rel="stylesheet">

	<link href="configure/css/bootstrap.min.css" rel="stylesheet">

	<link href="configure/css/nifty.min.css" rel="stylesheet">

	<link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">

	<link href="configure/plugins/switchery/switchery.min.css" rel="stylesheet">

	<link href="configure/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">

	<!-- <link href="configure/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet"> -->
	<link href="configure/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">

	<link href="configure/css/demo/nifty-demo.min.css" rel="stylesheet">

	<link href="configure/plugins/pace/pace.min.css" rel="stylesheet">
	<script src="configure/plugins/pace/pace.min.js"></script>
	<style>
.button {
    background-color: #83f796; /* Green */
    
}

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #efa177;} /* Orange */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */
</style>    --%>


	<script type="text/javascript">
function Cancellead(id,qtno,mid){
		
		 var okdelete=confirm("Are You Sure Want to Cancel?");
		  if(okdelete)
		 	 {
			  
			  location.href = "Cancel_lead22?id="+id+"&qtno="+qtno+"&mid="+mid+"";
		 	 }
		
		
	}
function Cancellead1(id,qtno){
	
	 var okdelete=confirm("Are You Sure Want to View?");
	  if(okdelete)
	 	 {
		  
		  location.href = "Quotation_View_Print?id="+id+"&qtno="+qtno+"";
	 	 }
	
	
}
	
	
function Cancellead12(id,qtno){
	
	 var okdelete=confirm("Are You Sure Want to View?");
	  if(okdelete)
	 	 {
		  
		  location.href = "Quotation_View_Print2?id="+id+"&qtno="+qtno+"";
	 	 }
	
	
}
	</script> 
	
	<script type="text/javascript">
			function Closelead(id,qtno,amount,mid) {
				//alert(id);
				//alert(divinid);
				//var currentURL = "closeleaddeal.php?";
				//var currentURL = "closelead_form.php?";
				//var currentURL = "closeleaddeal.php?";
				
				var okdelete = confirm("Are You Sure Want to Close Lead!");
				if (okdelete) {
					
					/* location.href = currentURL + "recno=" + id +"&product="+product+"&name="+name; */
					location.href = "close_lead?id="+id+"&qtno="+qtno+"&amount="+amount+"&mid="+mid+"";
				}
			}
			
			
			
			
			
</script>

</script>
	
	 <script type="text/javascript" language="javascript" src="cssc/jquery-1.12.3.min.js"></script>
	    <script type="text/javascript" language="javascript" src="cssc/jquery.dataTables.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/dataTables.buttons.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/buttons.flash.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/jszip.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/pdfmake.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/vfs_fonts.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/buttons.html5.min.js"></script>
	   <script type="text/javascript" language="javascript" src="cssc/buttons.print.min.js"></script>
	   
		   
	
<!--autosearch  -->
<script src="js/jquery-migrate-1.2.1.js"></script>
<script src="Grid/AutoSearch/stAutoSearchJquery.js"></script>
<script src="js/rangopopup.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" media="all" href="Grid/AutoSearch/styleAS.css" />
<!--autosearch  -->
	
	
	<script>
$(function() {
		
				
				
	
	$("#particular").autocomplete("GoogleSearch/expenseAutoSearch.jsp");  
	
	$("#name").autocomplete("GoogleSearch/Purchase/emp_nameauto.jsp");
	
	
	}); 
	</script>
	
<script type="text/javascript" language="javascript" class="init">

$(document).ready(function() {
    $('#example').DataTable( {
        dom: 'Bfrtip',
        "pageLength": 20,
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]   

			
    } );
} );
</script>
<style>
button.dt-button, div.dt-button, a.dt-button {
    position: relative;
    display: inline-block;
    box-sizing: border-box;
    margin-right: 0.333em;
    padding: 0.5em 1em;
    border: 1px solid #999;
    border-radius: 2px;
    cursor: pointer;
    font-size: 0.88em;
    color: black;
    white-space: nowrap;
    overflow: hidden;
    background-color: #e9e9e9;
    background-image: -webkit-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -moz-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -ms-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: -o-linear-gradient(top, #fff 0%, #e9e9e9 100%);
    background-image: linear-gradient(to bottom, #fff 0%, #00cfd1  100%) !important;
    filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,StartColorStr='white', EndColorStr='#e9e9e9');
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    text-decoration: none;
    outline: none;
}
</style>

	

<%-- <script>
	$(function() {
		
		$("#cust_name").autocomplete("GoogleSearch/Customer_name2.jsp");

	});
	</script>
	 --%>
	
</head>
<body>
	<div id="container" class="effect mainnav-lg">
		
		<jsp:include page="/common/header.jsp"></jsp:include>
		
		

		<div class="boxed">
		
			<div id="content-container">
				
				<div id="page-title">
					<h1 class="page-header text-overflow"> Daily Cash Report</h1>
				</div>
				
				
			

				<!--Page content-->
				<div id="page-content">
						

						<div class="panel">
						<div>
                            <a class="btn btn-primary btn-round" href="cash_recivedasdas">Add New</a>
                            
                       <div>
						<div class="panel-heading">
							<h3 class="panel-title">Daily Cash Report</h3>
						</div>
						
				<form name="DailyCash_Report_Submit" action="DailyCash_Report_Submit" id="frmFileUpload" class=" " method="post" > 
                    
                        <div class="row clearfix">
                            <div class="col-sm-3">
                                <div class="form-group floating-label">
                                    <input type="text"  name="from_date" id="from_date" class="form-control floating-input"   placeholder=" "   required>
                                    
                                    <label>From Date </label>
                                    
                                </div> 
                            </div>
                            
                           
                            <div class="col-sm-3">
                                <div class="form-group floating-label">
                                    <input type="text"  name="to_date1" id="to_date" class="form-control floating-input"   placeholder=" "   required>
                                    
                                    <label>To Date </label>
                                    
                                </div> 
                            </div>
                            
                            
                            
                            <!-- 
                            <div class="col-sm-3">
                                <div class="form-group floating-label">
                                    <input type="text"  name="particular" id="particular" class="form-control floating-input"   placeholder=" "   required>
                                    
                                    <label>Expense Particular </label>
                                    
                                </div> 
                            </div>
                           
                            <div class="col-sm-3">
                                <div class="form-group floating-label">
                                    <input type="text"  name="name" id="name" class="form-control floating-input"   placeholder=" "   >
                                    
                                    <label>Employee name </label>
                                    
                                </div> 
                            </div>
                             -->
                            <div class="col-sm-3">
                            <div class="form-group ">
                              <button type="submit" class="btn btn-primary btn-round">Search</button>
                            </div>
                            </div>
                            </div>
                         		</form>   
				
					
						
							 <div class="panel-body">
							<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
								<thead>
								
								
									<tr>
									<!-- <th>Sr.</th> -->
									<th>Date</th>
									<th>Particular</th>
								<!-- 	<th>Dealer Code</th>
									<th>Emp Code</th>
									<th>From</th>
									<th>To</th>
									<th>GPno/Invoiceno</th> -->
									<th>Receipt/Voucher No</th>
									<th>Remark</th>
									<th>Cheque No</th>
									<th>Cheque Credit</th>

									<th>Cheque Debit</th>

									<th>Cash Credit</th>
									<th>Cash Debit</th>
									<th>Transaction ID</th>
									<th>Balance</th>

								</tr>
                                    </thead>
                                    <tbody> 
                                    <% int sr_No1=1; %>
                                    
                                <s:iterator value="report">
									<tr class="alt">
										<td><s:property value="to_date1" />
										</td>
										<td><s:property value="amtpert" />
										</td>
									<%-- 	<td><s:property value="delader" />(<s:property value="Dealer_id" />)
										</td>
										<td><s:property value="emp_code" />
										</td>
										<td><s:property value="fromcounter" />
										</td>
										<td><s:property value="tocounter" />
										</td>
										<td><s:property value="gatepassno" /> <s:property value="icr_no" />
										</td> --%>
										<td><s:property value="voucher_no" />
										</td>
										<td style="width: 100px;"><s:property value="remark" />
										</td>
										<td><s:property value="cheque_no" />
										</td>

										<td><s:property value="chequecredit" />
										</td>
										<td><s:property value="chequedebit" />
										</td>

										<td><s:property value="cashcredit" />
										</td>
										<td><s:property value="cashdebit" />
										</td>
										<td><s:property value="transcation_id" />
										</td>
										<td><s:property value="balance_amt" />
										</td>
									</tr>

								</s:iterator>
                                    </tbody>
                                    
                                    <tr>
				<td>
				<table>
				
								<tr><td> Opening Balance:</td><td>${initialbalstore}</td><td>&nbsp;</td><td>Closing Balance:</td><td>${finalbalance}</td></tr>
				
				
				<tr>
			
				
			
				
				</tr>
				</table>
				
				</td>
				
				
				</tr>
                                </table>
                                
						</div>
					</div></div>

			

					
				</div>
			
				<jsp:include page="/officemg/leftsidebar.jsp"></jsp:include>
		<jsp:include page="/common/footer.jsp"></jsp:include>
		</div>
		
		
		
	
	
		
		
	

<!--JAVASCRIPT-->
	<!--=================================================-->

	
	<script src="configure/js/bootstrap.min.js"></script>

 <script src="configure/plugins/fast-click/fastclick.min.js"></script>
 
	<script src="configure/js/nifty.min.js"></script>

	<script src="configure/plugins/switchery/switchery.min.js"></script>

	<script src="configure/plugins/bootstrap-select/bootstrap-select.min.js"></script>

	<script src="configure/plugins/datatables/media/js/jquery.dataTables.js"></script>
	 <script src="configure/plugins/datatables/media/js/dataTables.bootstrap.js"></script>
	 <script src="configure/plugins/datatables/extensions/Responsive/js/dataTables.responsive.min.js"></script>

	<script src="configure/js/demo/nifty-demo.min.js"></script>

	<script src="configure/js/demo/tables-datatables.js"></script> 
	
	</body>
</html>
