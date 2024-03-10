<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

DBConnection connection=new DBConnection();
Connection conn=connection.getConnection();

String query = request.getParameter("q");
String query1 = request.getParameter("inv");

PreparedStatement pst=conn.prepareStatement("SELECT `lr_no` FROM `invoice_tax_details` where lr_no like '%"+query+"%' and  invoice_no='"+query1+"' ");
System.out.println("pst:"+pst);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
	out.println(rs.getString(1));
}
%>






 