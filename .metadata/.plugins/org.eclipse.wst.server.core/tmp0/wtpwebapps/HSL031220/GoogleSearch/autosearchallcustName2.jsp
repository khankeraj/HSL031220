<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");
String query1 = request.getParameter("cust_type");

System.out.println("Type:"+query1);

PreparedStatement pst=conn.prepareStatement("SELECT customer_name FROM customer_master_details where customer_name LIKE '%"+query+"%' ");

System.out.println("pst:"+pst);

ResultSet rs=pst.executeQuery();

while(rs.next())
{
	
	
	
	out.println(rs.getString("customer_name"));

	
}


%>






 