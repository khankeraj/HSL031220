<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();

/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */

PreparedStatement pt= conn.prepareStatement("select  distinct name_of_employee,employee_id from employee_master where name_of_employee LIKE '"+query+"%'   ");

ResultSet rs =pt.executeQuery();

System.out.println("ddddddddddddddd---------"+pt);
while(rs.next())
{
	out.println(rs.getString("name_of_employee")+"-"+rs.getString("employee_id"));
}
conn.close();
%>


