<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Service Station Software</title>
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!--   <link rel="stylesheet" href="configure/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <link rel="stylesheet" href="configure/bower_components/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="configure/bower_components/Ionicons/css/ionicons.min.css">
  <link rel="stylesheet" href="configure/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="configure/dist/css/skins/_all-skins.min.css">
  <link rel="stylesheet" href="configure/dist/css/css.css"> -->
  <%-- <!-- ********************************Responsive Data Table************************** -->
	<link rel="stylesheet" type="text/css" href="responsiveDatatable/jquery.dataTables.min.css">
	<link rel="stylesheet" type="text/css" href="responsiveDatatable/responsive.dataTables.min.css">
	
	<script type="text/javascript" charset="utf8" src="responsiveDatatable/jquery.dataTables.min.js"></script>
	<script type="text/javascript" charset="utf8" src="responsiveDatatable/dataTables.responsive.min.js"></script>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script> --%>
<!--********************************************************************************-->
 <!-- AutoSearch -->
 <script type="text/javascript" charset="utf8" src="responsiveDatatable/jquery-1.12.4.js"></script>
  <link rel="stylesheet" type="text/css" href="Css/styleAS.css" />
  <script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
  <link rel="stylesheet" type="text/css" media="all" href="Css/AutoSearch/styleAS.css" />
  <script src="jQuery_4_design/AutoSearch/AutoSearchJquerySale.js" type="text/javascript"></script>
  <!-- AutoSearch -->
<script src="js/jquery-migrate-1.2.1.js" type="text/javascript"></script>
	<script>
	$(function() {
		 $("#item_name").autocomplete("GoogleSearch/autosearchCustomer.jsp");
	});
	</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <jsp:include page="/common/header.jsp"></jsp:include>
  <!-- Left side column. contains the logo and sidebar -->
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
  
    <section class="content-header">
     <input type="Button" class="btn btn-primary" value="Add New" onClick="location.href='cust_master'"/>
      <input type="Button" class="btn btn-warning" value="All Customer"  style="margin-left: 10px" onClick="location.href='cust_master_report'"/>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Master</a></li>
        <li class="active">Customer Master Report </li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
		<div class="row">
        <div class="col-xs-12">
          <div class="box">
          
            <div class="box-header">
              <h3 class="box-title">Customer Master Report </h3>
            </div>
            <!-- /.box-header -->
       <s:form action="customerHistorySearchSubmit" id="customerMaster" class="formular" onsubmit="return validateme(this);">
        <div class="box-body">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Vehicle No </label>
                <input type="text" class="form-control" name="vehicle_no" onblur="getVehicleNo()" id="item_name" pattern="[a-z A-Z 0-9-]*" placeholder="Vehicle No" required>
             </div>
            </div>
            
            <div class="col-md-6">
              <div class="form-group">
                <label>Customer Name </label>
                 <input type="text" class="form-control" name="cust_name" pattern="[a-z A-Z.()]]*" id="cust_name" placeholder="Customer Name" onchange="checkvalue();" required>
             </div>
            </div>
          </div>
          
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label>Contact No </label>
                <input type="text" class="form-control"  name="mob_no" pattern="[0-9]*" maxlength="10"
							id="mob_no"  placeholder="Contact No" required>
              </div>
            </div>
            
            <div class="col-md-6">
              <div class="form-group">
                <label>Address</label>
                <input type="text" class="form-control" name="cust_address"
							id="cust_address" pattern="[a-z A-Z 0-9]*" maxlength="20"   placeholder="Address" required>
              </div>
            </div>
          </div>
          
        </div>
          <div class="box-footer">
                <button type="submit" class="btn btn-success" name="Submit" id="Submit" value="Submit">Submit</button>&nbsp;
          </div>
        </s:form>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      </div>

      
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
    </div>
    <strong>Copyright &copy; 2018-2019 <a href="https://www.sindans.com">Sindans Software Solutions</a>.</strong> All rights
    reserved.
  </footer>
  <div class="control-sidebar-bg"></div>
</div>


</html>