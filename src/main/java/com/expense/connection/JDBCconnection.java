package com.expense.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnection {
	
	private String Dburl = "jdbc:mysql://localhost:3306/expense_app";
	private String DbUser = "root";
	private String DbPass = "root";
	private String DbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver()
	{
		try {
			Class.forName(DbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(Dburl, DbUser, DbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;		
	}

}
