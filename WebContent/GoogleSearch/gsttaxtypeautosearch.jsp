<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 

System.out.println(">>>ppppppppp");
String query = request.getParameter("q");

DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();

System.out.println(">>>ppppppppp"+query);
PreparedStatement pt= conn.prepareStatement("select  distinct hsncode from  gst_tax_master where hsncode LIKE '"+query+"%'   ");
System.out.println(">>>"+pt); 
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	out.println(rs.getString("hsncode"));
}
conn.close();
%>


