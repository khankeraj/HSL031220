<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection(); 
PreparedStatement pt= conn.prepareStatement("select  distinct emp_code from emp_master where emp_code LIKE '"+query+"%' ");
ResultSet rs =pt.executeQuery();
System.out.println("pt"+pt);
while(rs.next())
{
	out.println(rs.getString("emp_code"));
}
conn.close();
%>


