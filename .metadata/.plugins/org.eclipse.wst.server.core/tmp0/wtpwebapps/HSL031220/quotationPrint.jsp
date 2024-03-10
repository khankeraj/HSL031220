<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="java.util.Properties"%>

<script type="text/javascript">
	 function printData()
	 {
		
		document.getElementById("Print").style.visibility="hidden";
		document.getElementById("Home").style.visibility="hidden";
	    window.print();
	    document.getElementById("Print").style.visibility="visible";
	    document.getElementById("Home").style.visibility="visible";
	   
	 }
	 
	 function goHome(){
		 
		 location.href="test.jsp";
	 }
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
html,body,table#pagelayout {
height:98%;
width:99%;

}
</style>
</head>
<body>
<div >
<input type="button" name="Print"
			id="Print" value="Print" class="NFButton" onclick="printData()"><img
			src="img/0.png" class="NFButtonRight">
			<input type="button" name="Home"
			id="Home" value="Home" class="NFButton" onclick="goHome()"><img
			src="img/0.png" class="NFButtonRight">

</div>

<table id="pagelayout" style="border: 1px solid #787f7a;width:100%;border-collapse:collapse;page-break-after: always"">

</table>		
</body>
</html>




