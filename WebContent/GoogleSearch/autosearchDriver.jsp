<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");

PreparedStatement pst=conn.prepareStatement("SELECT driver_name, driver_id FROM driver_master where driver_name LIKE '%"+query+"%'");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString(1)+"-"+rs.getString(2));
}

DBConnection.closeConnection();

%>






 