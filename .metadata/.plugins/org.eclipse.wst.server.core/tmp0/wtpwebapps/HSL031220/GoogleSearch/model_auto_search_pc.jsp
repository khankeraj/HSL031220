<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection con=new DBConnection();
Connection connection = con.getConnection();
 PreparedStatement pt= connection.prepareStatement("select  distinct model from model_masterv where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); 

ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("model"));
}
connection.close();
%>


