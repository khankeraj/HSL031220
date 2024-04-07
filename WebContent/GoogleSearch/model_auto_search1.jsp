<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();
/* PreparedStatement pt= connection.prepareStatement("select  distinct model from model_master where model LIKE '%"+query+"%'");
System.out.println(">>>"+pt); */
System.out.println(">>>"+query);
PreparedStatement pt= conn.prepareStatement("select  distinct vehicle_no from job_card where vehicle_no LIKE '%"+query+"%' and job_card_done_status=0  ");
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	//out.println((rs.getString("vehicle_no")).toUpperCase());
	
	PreparedStatement pt1= conn.prepareStatement("select  model,cust_name from customer_master where vehicle_no = '"+rs.getString("vehicle_no")+"'  ");
ResultSet rs1 =pt1.executeQuery();

if(rs1.next())
{
	
	out.println(" <tr> <td width='200px'> "+(rs.getString("vehicle_no")).toUpperCase()+"  ~ </td>   <td width='100px'>    "+rs1.getString("cust_name")+" ~ </td>   <td width='100px'>  "+rs1.getString("model") +" </td> </tr>");
}
}
conn.close();
%>


