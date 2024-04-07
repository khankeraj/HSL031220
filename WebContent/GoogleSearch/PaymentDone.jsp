<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

PreparedStatement pst=conn.prepareStatement("SELECT pymentdone FROM PaymentDone_Master");
ResultSet rs=pst.executeQuery();

while(rs.next())
{
	out.println(rs.getString(1));
}
%>
