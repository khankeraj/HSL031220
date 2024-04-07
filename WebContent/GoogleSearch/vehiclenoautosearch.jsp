<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection conn=new DBConnection();
Connection connection=conn.getConnection();
/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */

PreparedStatement pt= connection.prepareStatement("select  distinct vehicle_no from customer_master where vehicle_no LIKE '"+query+"%' ");
System.out.println(pt);
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("vehicle_no"));
}
connection.close();
%>
