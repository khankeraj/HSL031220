<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();



PreparedStatement pt= conn.prepareStatement("select  distinct customer_name,customer_no  from customer_master_details WHERE customer_name LIKE '%"+query+"%'");
System.out.println(">>>>customer"+pt);
ResultSet rs =pt.executeQuery();
while(rs.next())
{
	out.println(rs.getString("customer_name")+"-"+rs.getString("customer_no"));
}

conn.close();
%>


