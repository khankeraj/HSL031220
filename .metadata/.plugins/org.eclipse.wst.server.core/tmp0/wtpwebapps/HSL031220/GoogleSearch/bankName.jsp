<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

PreparedStatement pst=conn.prepareStatement("SELECT `bank_name` FROM `bank_master` WHERE 1");
ResultSet rs=pst.executeQuery();

while(rs.next())
{
	out.println(rs.getString(1));
}
%>
