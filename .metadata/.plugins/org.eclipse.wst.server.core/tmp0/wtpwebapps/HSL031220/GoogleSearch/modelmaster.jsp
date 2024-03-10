<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();
/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */
System.out.println(">>>"+query);
PreparedStatement pt= conn.prepareStatement("select  distinct model_name from model_master where model_name LIKE '"+query+"%'  ");
System.out.println(">>>QUERY"+pt);
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("model_name"));
}
conn.close();
%>


