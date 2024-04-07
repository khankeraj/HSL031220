<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();Connection conn=connection.getConnection();



PreparedStatement pt= conn.prepareStatement("select  distinct voucher_no,exp_amount  from lr_advance WHERE voucher_no LIKE '%"+query+"%'");
System.out.println(">>>>customer"+pt);
ResultSet rs =pt.executeQuery();
while(rs.next())
{
	out.println(rs.getString("voucher_no")+"~"+rs.getString("exp_amount"));
}

conn.close();
%>


