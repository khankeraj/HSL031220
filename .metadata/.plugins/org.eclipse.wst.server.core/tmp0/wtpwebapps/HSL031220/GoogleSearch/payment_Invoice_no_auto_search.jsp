<%@page import="com.DB.DBConnection"%>
<%@page import="java.sql.*"%>
<% 
String query = request.getParameter("q");
String q1=  request.getParameter("emp_code");
 String amtpert=  request.getParameter("amtpert");
 /*
String s = q1;

s = s.substring(s.indexOf("(") + 1);
s = s.substring(0, s.indexOf(")"));
//System.out.println(q1+">>>>"+q2);
if(q2.equals("ayu")){
	q2="ay";
} */
String invtype="";
System.out.println(">>>>"+amtpert);

if(amtpert.equals("ProductSale")){
	
	invtype= " and ( type='ay' or type='ma')  ";	
	
}
if(amtpert.equals("Feedback")){
	
	invtype= " and type='sp'  ";
	
}

if(amtpert.equals("Amc")){
	
	
	invtype= " and type='ag'  ";
}

DBConnection connection=new  DBConnection();
Connection conn=connection.getConnection();


	
	


PreparedStatement pt= conn.prepareStatement("select  distinct invoice_no from invoice_issue where invoice_no LIKE '"+query+"%' and emp_code='"+q1+"' and invoice_status='1' "+invtype+" " );
//System.out.println(">>>>"+pt);
ResultSet rs =pt.executeQuery();

while(rs.next())
{
	PreparedStatement pt1= conn.prepareStatement("select  icr_no  from amountreceived where icr_no = '"+rs.getString("invoice_no")+"'  " );
	//System.out.println(">>>>"+pt1);
	ResultSet rs1 =pt1.executeQuery();

	if(rs1.next()){
	}else{
	out.println(rs.getString("invoice_no"));
	
	}
}


conn.close();
%>


