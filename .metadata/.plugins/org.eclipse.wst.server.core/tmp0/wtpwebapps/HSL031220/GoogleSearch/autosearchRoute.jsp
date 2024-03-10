<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");

PreparedStatement pst=conn.prepareStatement("SELECT route FROM route_master where route LIKE '%"+query+"%' ");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString(1));
}

DBConnection.closeConnection();

%>






 