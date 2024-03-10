<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection(); 

PreparedStatement pt= conn.prepareStatement("select  invoice_no ,vehicle_no,job_card_no from invoice   where  (invoice_no LIKE '%"+query+"%' or  vehicle_no LIKE '"+query+"%') and length(invoice_no)>3 and  invtype='sgst' and wotax='no'  order by invoice_no desc");

ResultSet rs =pt.executeQuery();
/* PreparedStatement pt2 = connection.prepareStatement("select customer_name from job_card  where   job_card_no = ? ");
 */String custname="";
while(rs.next())
{
	
	/* pt2.setString(1, rs.getString("job_card_no"));
	
    	 ResultSet rs2 = pt2.executeQuery();
    	 if(rs2.next())
    	 {
    		 custname=rs2.getString("customer_name");
    	 } */
    	 
	out.println(rs.getString("invoice_no")+'^'+rs.getString("vehicle_no")+'^'+custname) ;
}
conn.close();
%>


