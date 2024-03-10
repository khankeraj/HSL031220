<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();
PreparedStatement pst=conn.prepareStatement("SELECT `trip_id` FROM `trip` ");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString(1));
}
%>






 