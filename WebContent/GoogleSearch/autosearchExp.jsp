<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();
PreparedStatement pst=conn.prepareStatement("SELECT `name` FROM `exp_part_master` ");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString(1));
}
%>






 