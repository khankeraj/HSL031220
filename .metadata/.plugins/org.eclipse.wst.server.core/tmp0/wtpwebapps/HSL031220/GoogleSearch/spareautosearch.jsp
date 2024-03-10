<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection con=new DBConnection();
Connection connection = con.getConnection();

	PreparedStatement ptz= connection.prepareStatement("select product_name from product_master where product_name like '%"+query+"%' ");

	ResultSet rsz =ptz.executeQuery();
	System.out.println("preparedStatement112"+ptz);
	while(rsz.next())
	{
		out.println(rsz.getString(1));
	}	
	connection.close();
%>


