<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();

/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */

PreparedStatement pt= conn.prepareStatement("select  distinct emp_name from emp_master where emp_name LIKE '"+query+"%'   ");

ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("emp_name"));
}
conn.close();
%>


