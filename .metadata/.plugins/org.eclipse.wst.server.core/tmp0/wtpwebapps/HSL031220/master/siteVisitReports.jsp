<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
 	<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&amp;subset=latin" rel="stylesheet">
	<link href="configure/css/bootstrap.min.css" rel="stylesheet">
	<link href="configure/css/nifty.min.css" rel="stylesheet">
	<link href="configure/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="configure/plugins/switchery/switchery.min.css" rel="stylesheet">
	<link href="configure/plugins/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">
	<link href="configure/plugins/datatables/media/css/dataTables.bootstrap.css" rel="stylesheet">
	<link href="configure/plugins/datatables/extensions/Responsive/css/dataTables.responsive.css" rel="stylesheet">
	<link href="configure/css/demo/nifty-demo.min.css" rel="stylesheet">
	<link href="configure/plugins/pace/pace.min.css" rel="stylesheet">
	<script src="configure/plugins/pace/pace.min.js"></script>
</head>
<body>
<%
String finalization_id=request.getParameter("finalization_id");
String finalized_amt=request.getParameter("finalized_amt");
String token_amt=request.getParameter("token_amt");

System.out.println("finalized amount:"+finalized_amt+"token amount:"+token_amt);
%>
	<div id="container" class="effect mainnav-lg">
		<jsp:include page="/common/data-tableheader.jsp"></jsp:include>
		<div class="boxed">
			<div id="content-container">
				
				<div id="page-content">
					<div class="panel">
						<div class="panel-heading">
							<h3 class="panel-title">Site Visit Reports</h3>
						</div>
						<div class="panel-body">
							<table id="demo-dt-basic" class="table table-striped table-bordered" cellspacing="0" width="100%">
								<thead>
									<tr>
										<th align="center">Sr.No</th>
										<th align="center">Client Name</th>
										<th align="center">Date</th>
										<th align="center">Client Address</th>
										<th align="center">Customer Mobile</th>
										<th align="center">Customer Email</th>
										<th align="center">Token</th>
										<th align="center">Action</th>
										<th align="center">Action</th>
									</tr>
								</thead>
								
								<tbody>
								 <%int i=1; %>
								 
								 <c:forEach items="${visitorList}" var="visitorList">
									<tr>
										<td align="center"><%=i++ %></td>
										<td align="center"><c:out value="${visitorList.client_name}"/></td>
										<td align="center"><c:out value="${visitorList.requiredDate}"/></td>
										<td align="center"><c:out value="${visitorList.client_address}"/></td>
										<td align="center"><c:out value="${visitorList.customer_mobile}"/></td>
										<td align="center"><c:out value="${visitorList.customer_email}"/></td>
										<td align="center"><a title="Token Form" href="TokenForm?site_visitor_id=<c:out value="${visitorList.finalization_id}"/>&lead_no=<c:out value="${visitorList.lead_no}"/>&finalized_amount="+finalized_amt+"&token_amount="+token_amount"><img alt="Token" height="25px;" src="configure/img/money-bag.svg"></a></td>
										<td align="center"><a title="Edit" href="updateSiteVisite?site_visit_id=${visitorList.visitor_id}"><img alt="Update" height="25px;" src="configure/img/editmeeting.svg"></a></td>
										<td align="center"><a  title="Delete" href="deleteSiteVisit?siteVisit_id=${visitorList.visitor_id}"><img alt=""  height="25px;"   src="configure/img/delete.svg"></a></td>
									</tr>
								 </c:forEach>
								 
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
		
		</div>

		

		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->

	</div>
	<script src="configure/js/jquery-2.1.1.min.js"></script>
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

