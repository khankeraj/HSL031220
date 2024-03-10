<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");

PreparedStatement pst=conn.prepareStatement("SELECT distinct(customer_name) FROM quotation where customer_name LIKE '%"+query+"%' ");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString("customer_name"));
}

DBConnection.closeConnection();
%>






 