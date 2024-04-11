package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3307/";
	String dbName = "hsl";
	String userName = "root";
	String password = "root";
	static Connection con;
	int rowsInserted=0;
	ResultSet rs;

	public Connection getConnection()
	{
		try
		{
			Class.forName(driverName);
			con = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("connected...");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return con;
	}	

	
	
	public static void closeConnection() {
		if (con != null)
			try {
				con.close();
			} catch (SQLException ex) {
			}

	}
	
	
	
	
	
}
