<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection(); 
/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */

PreparedStatement pt= conn.prepareStatement("select  distinct vehicle_no,cust_name,model from customer_master where vehicle_no LIKE '%"+query+"%' ");

ResultSet rs =pt.executeQuery();

while(rs.next())
{
	
	out.println(" <tr> <td width='200px'> "+rs.getString("vehicle_no").toUpperCase()+"  ~ </td>   <td width='100px'>    "+rs.getString("cust_name")+" ~ </td>   <td width='100px'>  "+rs.getString("model") +" </td> </tr>");

}
conn.close();
%>


