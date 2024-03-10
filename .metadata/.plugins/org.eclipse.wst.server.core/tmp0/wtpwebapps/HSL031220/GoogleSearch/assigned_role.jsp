<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");

    
    PreparedStatement pt = conn.prepareStatement("select distinct role_name from role_master where role_name LIKE '"+query+"%' ");
    ResultSet rs = pt.executeQuery();
    while (rs.next()) {
       
   
        	out.println(rs.getString("role_name"));
    
    }



 DBConnection.closeConnection();
%>

