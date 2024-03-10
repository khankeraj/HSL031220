<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link href="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.css" rel="stylesheet">
</head>
<body>
<%
int site_visitor_id=Integer.parseInt(request.getParameter("site_visitor_id"));
String lead_no=request.getParameter("lead_no");

%>
	<div id="container" class="effect mainnav-lg">
		<!--NAVBAR-->
		<jsp:include page="/common/header.jsp"></jsp:include>
		<!--END NAVBAR-->

		<div class="boxed">
			<!--CONTENT CONTAINER-->
			<div id="content-container">
				<!--Page Title-->
				<div id="page-title">
					<h1 class="page-header text-overflow">Token Amount Form</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li class="active">Token Amount Form</li>
				</ol>
				<!--End breadcrumb-->

				<!--Page content-->
				<div id="page-content">
						<div class="row">
						<div class="col-lg-12">
							<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title"></h3>
								</div>
								<form action="InsertTokenAmount" id="submitForm" method="POST" onsubmit="location.href='quot_Index'">
								<div class="panel-body">
								
								<s:iterator value="getFinalizationAmttokenamt">
								      <div class="row">
								      		<div class="col-sm-6">
												<div class="form-group">
												<input type="hidden" name="site_visitor_id" value="<%=site_visitor_id%>">
													<label class="control-label">Finalized Amount :</label>
													<input type="text" class="form-control" placeholder="" value="${finalizaed_amt}" name="finalized_amount"  class="form-control" required>
												</div>
											</div>
								      
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Token Amount :</label>
													<input type="text" class="form-control" placeholder="" value="${token_amt}" name="token_amount" class="form-control" required>
												</div>
											</div>
									  </div>
									  </s:iterator>
									  <div class="row">
											<div class="col-sm-6">
												<div class="form-group">
												   <label class="control-label">Paymode:</label>
												   <select class="selectpicker" data-live-search="true" id="paymode" onchange="getPaymode(this.value);" name="paymode"  data-width="100%">
													<option selected disabled value="select paymode">select paymode</option>
													<option value="Cash">Cash</option>
													<option value="Card">NEFT/Bank Transfer</option>
													<option value="Cheque">Cheque</option>
													<option value="Cash&Card">Cash&Card</option>
												   </select>
												</div>
											</div>
											<div class="col-sm-6" style="display: none;" id="cash">
												<div class="form-group">
													<label class="control-label">Net Amount :</label>
													<input type="text" class="form-control" placeholder="" name="net_amount"  class="form-control" >
												</div>
											</div>
										</div>
										
										
										<div class="row" style="display: none;" id="card">
								           <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Card Net Amount :</label>
													<input type="text" class="form-control" placeholder="" name="netcard_amount"  class="form-control" >
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Card Transaction Id :</label>
													<input type="text" class="form-control" placeholder="" name="card_trans_id"  class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="cheque">
								           <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Bank Name :</label>
													<input type="text" class="form-control" placeholder="" name="bank_name"  class="form-control" >
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Cheque No :</label>
													<input type="text" class="form-control" placeholder="" name="cheque_no"  class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="chequeId">
								           <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Cheque Amount :</label>
													<input type="text" class="form-control" placeholder="" name="cheque_amount"  class="form-control" >
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Cheque Date :</label>
													<input type="text" class="form-control" placeholder="" name="cheque_date"  class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="cash&card">
								           <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Total Amount :</label>
													<input type="text" class="form-control" placeholder="" name="total_amount"  class="form-control" >
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Cash Amount :</label>
													<input type="text" class="form-control" placeholder="" name="cash_amount"  class="form-control" >
												</div>
											</div>
									  </div>
									  
									  <div class="row" style="display: none;" id="cash&cardId">
								           <div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Credit Card Amount :</label>
													<input type="text" class="form-control" placeholder="" name="creditcard_amount"  class="form-control" >
												</div>
											</div>
											<div class="col-sm-6">
												<div class="form-group">
													<label class="control-label">Transaction Id :</label>
													<input type="text" class="form-control" placeholder="" name="transction_id"  class="form-control" >
												</div>
											</div>
									  </div>
									  
									  
										
										<div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
											<input type="text" name="lead_no" value="<%=lead_no%>">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit" >Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="reset"  onclick="history.go(-1)">Back</button>
												<button class="btn btn-primary btn-labeled fa fa-repeat fa-lg" style="margin-left: 10px" type="reset">Reset</button>
											</div>
										</div>
								     </div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!--End page content-->
			</div>
			<!--END CONTENT CONTAINER-->
			
			<!--MAIN NAVIGATION-->
			<nav id="mainnav-container">
				<div id="mainnav">
					<!--Shortcut buttons-->
					<div id="mainnav-shortcut">
						<ul class="list-unstyled">
							<li class="col-xs-4" data-content="Additional Sidebar">
								<a id="demo-toggle-aside" class="shortcut-grid" href="#">
									<i class="fa fa-magic"></i>
								</a>
							</li>
							<li class="col-xs-4" data-content="Notification">
								<a id="demo-alert" class="shortcut-grid" href="#">
									<i class="fa fa-bullhorn"></i>
								</a>
							</li>
							<li class="col-xs-4" data-content="Page Alerts">
								<a id="demo-page-alert" class="shortcut-grid" href="#">
									<i class="fa fa-bell"></i>
								</a>
							</li>
						</ul>
					</div>
					<!--End shortcut buttons-->

					<!--Menu-->
					<jsp:include page="/common/leftsidebar.jsp"></jsp:include>
					<!--End menu-->
				</div>
			</nav>
			<!--END MAIN NAVIGATION-->
		</div>
		
		<!-- FOOTER -->
		<jsp:include page="/common/footer.jsp"></jsp:include>
		<!-- END FOOTER -->
	</div>
	<!-- END OF CONTAINER -->
	
	<!-- SETTINGS - DEMO PURPOSE ONLY -->
	<jsp:include page="/common/settings.jsp"></jsp:include>
	<!-- END SETTINGS -->
	<script src="configure/plugins/bootstrap-datepicker/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
	function getPaymode(id) {
		alert(id);
		if(id=='Cash')
			{
				document.getElementById("cash").style.display="block";
				document.getElementById("card").style.display="none";
				document.getElementById("cheque").style.display="none";
				document.getElementById("chequeId").style.display="none";
				document.getElementById("cash&card").style.display="none";
				document.getElementById("cash&cardId").style.display="none";
			}else if(id=='Card')
				{
					document.getElementById("cash").style.display="none";
					document.getElementById("cheque").style.display="none";
					document.getElementById("chequeId").style.display="none";
					document.getElementById("cash&card").style.display="none";
					document.getElementById("cash&cardId").style.display="none";
					document.getElementById("card").style.display="block";
				}else if(id=='Cheque'){
					document.getElementById("cash").style.display="none";
					document.getElementById("card").style.display="none";
					document.getElementById("cash&card").style.display="none";
					document.getElementById("cash&cardId").style.display="none";
					document.getElementById("cheque").style.display="block";
					document.getElementById("chequeId").style.display="block";
				}else if(id=='Cash&Card'){
					document.getElementById("cash").style.display="none";
					document.getElementById("card").style.display="none";
					document.getElementById("cheque").style.display="none";
					document.getElementById("chequeId").style.display="none";
					document.getElementById("cash&card").style.display="block";
					document.getElementById("cash&cardId").style.display="block";
					
				}
		
	}
	</script>
</body>
</html>

