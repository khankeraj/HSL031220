<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

PreparedStatement pst=conn.prepareStatement("SELECT name_of_employee FROM employee_master");
ResultSet rs=pst.executeQuery();
System.out.println("pst:"+pst);
while(rs.next())
{
	out.println(rs.getString(1));
}
%>
