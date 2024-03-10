<%@page import="java.sql.SQLException"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{  
	Connection con=null;
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ultracare","root","");  
	 PreparedStatement pst=con.prepareStatement("select select_image from ro_master");
	 ResultSet rs1=pst.executeQuery(); 
	 String imgLen="";
	 
        if (rs1.next()) {
            byte[] imgData = rs1.getBytes("select_image");//Here....... r1.getBytes() extract byte data from resultSet 
            System.out.println("image:"+imgData);
            response.setHeader("expires", "0");
            response.setContentType("image/jpg");

            OutputStream os = response.getOutputStream(); // output with the help of outputStream 
            os.write(imgData);
            response.getOutputStream().flush();
            response.getOutputStream().close();

        }
    } catch (SQLException ex) {
        // String message = "ERROR: " + ex.getMessage();
        ex.printStackTrace();
        
    }

    
%>
</body>
</html>