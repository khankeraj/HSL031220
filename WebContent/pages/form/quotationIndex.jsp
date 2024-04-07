<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ultracare Group</title>
</head>
<body>
<%int i=1; %>
<s:iterator>
<div><p></p></div>
<%=i++ %> ) <s:property value="sub_name_of_index"/>
</s:iterator>
</body>
</html>