<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection con=new DBConnection();
Connection connection = con.getConnection();


PreparedStatement pt= connection.prepareStatement("select  * from customer_master_details where (customer_name LIKE '"+query+"%' or customer_no LIKE '"+query+"%' ) ");
System.out.println(">>>QUERY"+pt);
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("customer_no")+"~"+rs.getString("customer_name")+"");
}
%>


