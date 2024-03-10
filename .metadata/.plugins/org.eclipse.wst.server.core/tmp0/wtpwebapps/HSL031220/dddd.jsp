<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="panel-group driving-license-settings" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading">
             <h4 class="panel-title">
                                      <div class="checkbox">
                <label data-toggle="collapse" data-target="#collapseOne">
                    <input type="checkbox"/> I have Driver License	
                </label>
            </div>
								  </h4>

        </div>
        <div id="collapseOne" class="panel-collapse collapse in">
            <div class="panel-body">
                <div class="driving-license-kind">
                    <div class="checkbox">
                        <input type="checkbox" value="">A</div>
                    <div class="checkbox">
                        <input type="checkbox" value="">B</div>
                    <div class="checkbox">
                        <input type="checkbox" value="">C</div>
                    <div class="checkbox">
                        <input type="checkbox" value="">D</div>
                    <div class="checkbox">
                        <input type="checkbox" value="">E</div>
                </div>
            </div>
        </div>
    </div>
</div>

<Script>$('.collapse').collapse()</Script>
</body>
</html>