<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
//String query1 = request.getParameter("dealerid");
DBConnection connection=new  DBConnection();
			Connection conn=connection.getConnection(); 


PreparedStatement pt= conn.prepareStatement("select  distinct bankname from bankmaster where bankname LIKE '"+query+"%'");
ResultSet rs =pt.executeQuery();
while(rs.next())
{
	out.println(rs.getString("bankname"));
}

conn.close();
%>


