<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection con=new DBConnection();
Connection connection = con.getConnection();


PreparedStatement pt= connection.prepareStatement("select  * from company_master where (company_name LIKE '"+query+"%' ) ");
System.out.println(">>>QUERY"+pt);
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("company_name"));
}
%>


