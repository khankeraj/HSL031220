<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>

<%@ page import="java.util.Properties" %>
<%@ page import="com.aqua.dao.Spare_master_dao" %>
<html lang="en">

<head>

<meta charset="utf-8">

<title>Service Station Software</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<!--   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    Ionicons
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="dist/css/animsition.min.css">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- animsition.js -->
<script src="dist/js/animsition.min.js"></script>
   <script type="text/javascript">
   $(document).ready(function() {
	  /*  $(".animsition").animsition({
	     inClass: 'fade-in-right',
	     outClass: 'fade-out-right',
	     inDuration: 1500,
	     outDuration: 800,
	     linkElement: '.animsition-link',
	     // e.g. linkElement: 'a:not([target="_blank"]):not([href^="#"])'
	     loading: false,
	     loadingParentElement: 'body', //animsition wrapper element
	     loadingClass: 'animsition-loading',
	     loadingInner: '', // e.g '<img src="loading.svg" />'
	     timeout: false,
	     timeoutCountdown: 5000,
	     onLoadEvent: true,
	     browser: [ 'animation-duration', '-webkit-animation-duration'],
	     // "browser" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
	     // The default setting is to disable the "animsition" in a browser that does not support "animation-duration".
	     overlay : false,
	     overlayClass : 'animsition-overlay-slide',
	     overlayParentElement : 'body',
	    // transition: function(url){ window.location.href = url; }
	   }); */
	 });
   
   
  function submitthis(){
	  // alert(">>>");
	  /* $(".animsition").animsition({
		     inClass: 'fade-in-left',
		     outClass: 'fade-out-left',
		     inDuration: 1500,
		     outDuration: 800,
		     linkElement: '.animsition-link',
		     // e.g. linkElement: 'a:not([target="_blank"]):not([href^="#"])'
		     loading: false,
		     loadingParentElement: 'body', //animsition wrapper element
		     loadingClass: 'animsition-loading',
		     loadingInner: '', // e.g '<img src="loading.svg" />'
		     timeout: false,
		     timeoutCountdown: 5000,
		     onLoadEvent: true,
		     browser: [ 'animation-duration', '-webkit-animation-duration'],
		     // "browser" option allows you to disable the "animsition" in case the css property in the array is not supported by your browser.
		     // The default setting is to disable the "animsition" in a browser that does not support "animation-duration".
		     overlay : false,
		     overlayClass : 'animsition-overlay-slide',
		     overlayParentElement : 'body',
		    // transition: function(url){ window.location.href = url; }
		   }); */
	  document.getElementById("sss").submit();
	   
   }
</script>
</head>

<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
    
    function clearvalue() {
	location.href="index.jsp";
	}  
    
    
</SCRIPT>

<script type="text/javascript">
  function valid()
  {
  
   if(document.getElementById("username").value=="")
    {
    alert("plases enter username");
    document.getElementById("username").focus();
    return false;
    }
    if(document.getElementById("password").value=="")
    {
    alert("plases enter password");
    document.getElementById("password").focus();
    return false;
    }
    return true;
    }
    


</script>
<%
Properties systemPropery = null;
systemPropery = new Properties();

	//System.out.println(">>>>");
systemPropery.load(new Spare_master_dao().getClass()
		.getResourceAsStream(
				"/com/aqua/dao/UserProfile.properties"));

String name = systemPropery.getProperty("NAME");


%>
<BODY style="" onload="noBack();" >
	<center>
  <div> <!-- class="animsition wrapper" -->
            <div class="container">
                <div class="row">
		<div class="header">

			<div class="logo">

				<img src="images/4Tbky78Tg.jpg" />
<div style="font-size:50px;font-color:blue"><%=name %></div>
			</div>
		</div>
		<div class="col-md-4">&nbsp;</div>

		<div class="col-md-4">
			
			<div class="box box-primary">
				

				<h1 align="center">Login Form</h1>

				<s:form id="sss" action="LoginAction" theme="simple"
					onsubmit="return valid();">

					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Username</label> <input
								type="text" class="form-control" name="username" id="username"
								value="" placeholder="Enter Username">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" name="password"
								id="password" value="" placeholder="Password">
						</div>


					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<button type="button" class="btn btn-primary" onclick="submitthis();" >Submit</button>
					</div>
					</s:form>
			</div>

</div>

<div class="col-md-4">&nbsp;</div>
			

</div></div></div>		

	</center>
  <div class="footer">
            <div class="container">
                <b class="copyright">&copy; 2017 Service Station Software </b>All rights reserved.
            </div>
        </div>



	<a href="http://www.htmldrive.net/"
		title="HTML DRIVE - Free DHMTL Scripts,Jquery plugins,Javascript,CSS,CSS3,Html5 Library">
	</a>
</body>

</html>