<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script src="Css/jquery-1.10.2.js" type="text/javascript"></script>
<script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
</head>
<body>
<%
String finalization_id=request.getParameter("finalization_id");
String finalized_amt=request.getParameter("finalized_amt");
String token_amt=request.getParameter("token_amt");
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
					<h1 class="page-header text-overflow">Site Visit</h1>
				</div>
				<!--End page title-->
				
				<!--Breadcrumb-->
				<ol class="breadcrumb">
					<li><a href="#">Home</a></li>
					<li><a href="#">Master</a></li>
					<li class="active">Site Visit Form</li>
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
								<form action="InsertSiteVisitForm" method="POST">
									<div class="panel-body">
										<div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Client Name :
                                                    </label>
                                                    <%
                                                    DBConnection connection=new DBConnection();
                                                    Connection conn=connection.getConnection();
                                                    PreparedStatement pst=conn.prepareStatement("SELECT customer_master_details.customer_name FROM customer_master_details");
                                                    ResultSet rs=pst.executeQuery();
                                                    %>
                                                     <input list="client_name" name="client_name" value="${customer_name}" autoComplete="off" class="form-control">
													  <%-- <datalist id="client_name">
													    <% while(rs.next()){%>
														<option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
													   <%} %>
													  </datalist> --%>
                                            </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2">Date :
                                                    </label>
                                                    <input type="date" class="form-control" style="line-height: 15px;" name="requiredDate"  required> </div>
                                            </div>
                                  		 </div>
                                      
                                        <div class="row">
										    <div class="col-md-6">
												<div class="form-group">
												<label for="wfirstName2">Client Address :
                                                    </label>
													<textarea id="demo-textarea-input" style="line-height: 9px;" class="form-control" name="client_address" placeholder=""></textarea>
												</div>
											</div>
											
											<%
											 DBConnection connection1=new DBConnection();
                                            Connection conn1=connection1.getConnection();
                                            PreparedStatement pst1=conn.prepareStatement("SELECT customer_master_details.mobile_no FROM customer_master_details");
                                            ResultSet rs1=pst1.executeQuery();
											%>
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Customer Mobile No:
                                                    </label>
                                                  <input list="customer_mobile" name="customer_mobile" autoComplete="off" class="form-control">
													  <datalist id="customer_mobile">
													    <% while(rs1.next()){%>
														<option value="<%=rs1.getString(1)%>"><%=rs1.getString(1)%></option>
													   <%} %>
													  </datalist>
  											 </div>
                                  		  </div>
                                  		  </div>
                                  		 <%
											 DBConnection connection2=new DBConnection();
                                            Connection conn2=connection2.getConnection();
                                            PreparedStatement pst2=conn.prepareStatement("SELECT customer_master_details.customer_email FROM customer_master_details");
                                            ResultSet rs2=pst2.executeQuery();
											%>
                                  		 <div class="row">
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Customer Email:
                                                    </label>
                                                  <input list="customer_email" name="customer_email" autoComplete="off" class="form-control">
													  <datalist id="customer_email">
													    <% while(rs2.next()){%>
														<option value="<%=rs2.getString(1)%>"><%=rs2.getString(1)%></option>
													   <%} %>
													  </datalist>
                                            </div>
                                             </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Project CO-Ordinator Name:
                                                    </label>
                                                    <input type="text"  name="project_coordinator" class="form-control" required> </div>
                                            </div>
                                  		 </div>
                                  		 	<%
											 DBConnection connection3=new DBConnection();
                                            Connection conn3=connection3.getConnection();
                                            PreparedStatement pst3=conn.prepareStatement("SELECT `plot_type` FROM `plot_type_master`");
                                            ResultSet rs3=pst3.executeQuery();
											%>
                                  		 <div class="row">
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Plot Type:
                                                    </label>
                                                    <input list="plotType" name="plot_type" autoComplete="off" class="form-control">
													  <datalist id="plotType">
													    <% while(rs3.next()){%>
														<option value="<%=rs3.getString(1)%>"><%=rs3.getString(1)%></option>
													   <%} %>
													  </datalist>
                                            	</div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Plot Area:
                                                    </label>
                                                    <input type="text"  name="plot_area" class="form-control" required> </div>
                                            </div>
                                  		 </div>
                                  		 	<%
											 DBConnection connection4=new DBConnection();
                                            Connection conn4=connection4.getConnection();
                                            PreparedStatement pst4=conn.prepareStatement("SELECT `water_source` FROM `water_source_master`");
                                            ResultSet rs4=pst4.executeQuery();
											%>
                                  		 <div class="row">
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Water Source:
                                                    </label>
                                                    <input list="waterSource" name="water_source" autoComplete="off" class="form-control">
													  <datalist id="waterSource">
													    <% while(rs4.next()){%>
														<option value="<%=rs4.getString(1)%>"><%=rs4.getString(1)%></option>
													   <%} %>
													  </datalist>
                                            </div>
                                            </div>
                                            <%
											 DBConnection connection5=new DBConnection();
                                            Connection conn5=connection5.getConnection();
                                            PreparedStatement pst5=conn.prepareStatement("SELECT `electricity_source` FROM `electricity_source_master`");
                                            ResultSet rs5=pst5.executeQuery();
											%>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Electricity Source:
                                                    </label>
                                                   <input list="electricity_source" name="electricity_Source" autoComplete="off" class="form-control">
													  <datalist id="electricity_source">
													    <% while(rs5.next()){%>
														<option value="<%=rs5.getString(1)%>"><%=rs5.getString(1)%></option>
													   <%} %>
													  </datalist>
                                            </div>
                                  		 </div>
                                  		 <%
											 DBConnection connection6=new DBConnection();
                                            Connection conn6=connection6.getConnection();
                                            PreparedStatement pst6=conn.prepareStatement("SELECT `road_connectivity` FROM `road_connectivity`");
                                            ResultSet rs6=pst6.executeQuery();
											%>
                                  		 <div class="row">
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Road Connectivity:
                                                    </label>
                                                   <input list="road_connectivity" name="road_connectivity" autoComplete="off" class="form-control">
													  <datalist id="road_connectivity">
													    <% while(rs6.next()){%>
														<option value="<%=rs6.getString(1)%>"><%=rs6.getString(1)%></option>
													   <%} %>
													  </datalist>
                                            </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Construction Type:
                                                    </label>
                                                    <input type="text"  name="cosntruction_type" class="form-control" required> </div>
                                            </div>
                                  		 </div>
                                  		 
                                  		 <div class="row">
											<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Construction area :
                                                    </label>
                                                    <input type="text"  name="construction_area" class="form-control" required> </div>
                                            </div>
                                            
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> Reject Water:
                                                    </label>
                                                    <input type="text"  name="reject_water" class="form-control" required> </div>
                                            </div>
                                  		 </div>
                                  		 
                                  		 <div class="row">
                                  		 	<div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2"> BIS Circle :
                                                    </label>
                                                    <input type="text"  name="bis_circle" class="form-control" required> </div>
                                            </div>
											 
											<div class="col-md-6">
												<div class="form-group">
												 <label for="wfirstName2"> Project COOrdinator Remarks :
                                                    </label>
													<textarea id="demo-textarea-input" style="line-height: 9px;" class="form-control" name="project_coordinator_remarks" placeholder=""></textarea>
												</div>
											</div>
											
                                  		 </div>
                                  		 
                                  		 <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label for="wfirstName2">Actual Photograph of site :
                                                    </label>
                                                    <input type="file" id="actual_photo" name="actual_phoograph_of_site" class="form-control" required> </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                            		<div id="actual_phoograph_of_site"></div>
                                           		 </div>
                                            </div>
                                  		 </div>
                                      
                                        <div class="panel-footer" >
										<div class="row">
											<div class="col-sm-9 col-sm-offset-3">
											<input type="hidden" value="<%=finalization_id%>" name="finalization_id">
											<input type="hidden" value="<%=finalized_amt%>" name="finalized_amt">
											<input type="hidden" value="<%=token_amt%>" name="token_amt">
											<input type="hidden" value="<%=lead_no%>" name="lead_no">
												<button class="btn btn-success btn-labeled fa fa-check fa-lg" style="margin-left: 10px" type="submit">Submit</button>
												<button class="btn btn-danger btn-labeled fa fa-mail-reply fa-lg" style="margin-left: 10px" type="button"  onclick="history.go(-1)">Back</button>
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


	<script>
		
		function previewImages() {
		
			  var $preview = $('#actual_phoograph_of_site').empty();
			  
			  if (this.files) $.each(this.files, readAndPreview);
		
			  function readAndPreview(i, file) {
			    
			    if (!/\.(jpe?g|png|gif)$/i.test(file.name)){
			      return alert(file.name +" is not an image");
			    } // else...
			    
			    var reader = new FileReader();
		
			    $(reader).on("load", function() {
			      $preview.append($("<img/>", {src:this.result, height:100,width:100}));
			    });
		
			    reader.readAsDataURL(file);
			    
			  }
		
			}
	
		$('#actual_photo').on("change", previewImages);
	</script>
</body>
</html>

